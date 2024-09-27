package com.lms.api.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.QuestionDto;
import com.lms.api.model.Answer;
import com.lms.api.model.Forum;
import com.lms.api.model.Question;
import com.lms.api.repository.AnswerRepository;
import com.lms.api.repository.ForumRepository;
import com.lms.api.repository.QuestionRepository;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private ForumRepository forumRepository;
	/*
	 * post Api for question
	 */
	
	@PostMapping("/question")
	public Question postQuestion(@RequestBody Question question,
								Principal principal ) {
		question.setUsername(principal.getName());
		question.setDateOfPost(LocalDate.of(2022, 03, 10));
		return questionRepository.save(question);
		
	}
	
	/*
	 * adding answer to question
	 */
	@PostMapping("/question/answer/{qid}/{aid}")
	public Question AddQuestionToForum(@PathVariable("qid") Long qid,@PathVariable("aid") Long aid) {
		Question question = questionRepository.getById(qid);
		Answer answer = answerRepository.getById(aid);
		List<Answer> list = question.getAnswer();
		list.add(answer);
		question.setAnswer(list);
		return questionRepository.save(question);
	}
	
	/*
	 * get all Questions based on the forumID and number of answers for that question
	 */
	
	@GetMapping("/question/{fid}")
	public QuestionDto getQuestionByForumId(@PathVariable("fid") Long fid) {
		/*
		 * get all questions based on forum id
		 */
		List<Question> listOfQuestion = questionRepository.findByForumId(fid);
		/*
		 * get forum by forum id
		 */
		Forum forum = forumRepository.getById(fid);
		/*
		 * creating dto for forum
		 */
		QuestionDto dto = new QuestionDto();
		/*
		 * creating dto for question
		 */
		List<QuestionDto.modelDto> list = new ArrayList<>();
		dto.setForumID(forum.getId());
		dto.setTopic(forum.getTopic());
		listOfQuestion.stream().forEach(q->{
			QuestionDto.modelDto modelDto = new QuestionDto.modelDto();
			modelDto.setQuestionID(q.getId());
			modelDto.setQuestionText(q.getQuestionText());
			modelDto.setLikes(q.getLikes());
			modelDto.setUsername(q.getUsername());
			modelDto.setDateOfPost(q.getDateOfPost());
			modelDto.setNumberofAnswers(q.getAnswer().size());
			list.add(modelDto);
		});
		/*
		 * sorting list by date of post
		 */
		List<QuestionDto.modelDto> listSorted =  list.stream().sorted(Comparator.comparing(QuestionDto.modelDto :: getDateOfPost))
					.collect(Collectors.toList());
		dto.setQuestions(listSorted);
		return dto;
		
	}
	
	/*
	 * get all answers as per question id
	 */
	@GetMapping("/answer/question/{qid}")
	public Question getAllAnswersByQuestionId(@PathVariable("qid") Long qid) {
		Question question = questionRepository.getById(qid);
		List<Answer> list = question.getAnswer()
				.stream().sorted(Comparator.comparing(Answer :: getDateOfPost).reversed())
				.collect(Collectors.toList());
		question.setAnswer(list);
		return question;
	}
	
	@PutMapping("/question/add-like/{qid}")
	public Question putALike(@PathVariable("qid") Long qid) {
		Question question = questionRepository.getById(qid);
		question.setLikes(question.getLikes() + 1);
		return questionRepository.save(question);
	}
	
	@PutMapping("/question/update/{qid}")
	public Question updateQuestion(@RequestBody Question question, 
							@PathVariable("qid") Long qid, Principal principal) {
		String user = principal.getName();
		Question questionDB = questionRepository.getById(qid);
		if(! user.equalsIgnoreCase(questionDB.getUsername()))
			throw new RuntimeException("User not allowed to update the answer");
		if(question.getQuestionText() != null) {
			questionDB.setQuestionText(question.getQuestionText());
			questionDB.setDateOfPost(LocalDate.now());
		}
		return questionRepository.save(questionDB);
	}
	
	
}

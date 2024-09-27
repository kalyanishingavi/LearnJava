package com.lms.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.ForumDto;
import com.lms.api.dto.ForumDto.forumStatsdto;
import com.lms.api.model.Answer;
import com.lms.api.model.Forum;
import com.lms.api.model.Question;
import com.lms.api.repository.ForumRepository;
import com.lms.api.repository.QuestionRepository;

@RestController
public class ForumController {
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	/*
	 * fetch question text based on forum id
	 */
	
	@GetMapping("/question/based-on-forum/{fid}")
	public List<String> getQuestionText(@PathVariable("fid") Long fid) {
		List<String> list = forumRepository.getQuestionText(fid);
	//	List<String> list1 = list.stream().map(q->q.getQuestionText()).collect(Collectors.toList());
		return list;
		
	}

	/*
	 * post method for forum
	 */
	
	@PostMapping("/forum")
	public Forum postForum(@RequestBody Forum forum) {
		return forumRepository.save(forum); 
	}
	
	/*
	 * add question to forum
	 */
	@PostMapping("/forum/question/{fid}/{qid}")
	public Forum AddQuestionToForum(@PathVariable("fid") Long fid,@PathVariable("qid") Long qid) {
		/*
		 * get forum by forum id
		 */
		Forum forum = forumRepository.getById(fid);
		/*
		 * get question by question id
		 */
		Question question = questionRepository.getById(qid);
		/*
		 * get list of question by forum and add question in it and save to db
		 */
		List<Question> list = forum.getQuestion();
		list.add(question);
		forum.setQuestion(list);
		return forumRepository.save(forum);
	}
	
	/*
	 * get all forums and number of questions in it as per page
	 */
	@GetMapping("/forum/all")
	public List<ForumDto> displayAllForums(
					@RequestParam(name="page",required = false,defaultValue = "0") Integer page,
					@RequestParam(name ="size",required = false,defaultValue = "2")Integer size){
		
		/*
		 * creating pagable interface for viewing forums as per page
		 */
		
		Pageable pageable = PageRequest.of(page, size);
		
		/*
		 * get all forums form the db as per pageable interface
		 */
		List<Forum> forum = forumRepository.findAll(pageable).getContent();
		/*
		 * dto to show output as per requirement
		 */
		List<ForumDto> listDto = new ArrayList<>();
		/*
		 * looping through forum and add the elements to the forumDto
		 */
		forum.stream().forEach(f->{
			ForumDto dto = new ForumDto();
			dto.setId(f.getId());
			dto.setTopic(f.getTopic());
			dto.setNoOfQuestions(f.getQuestion().size());
			listDto.add(dto);
		});
		return listDto;
	}
	
	/*
	 * stats api for forum
	 */
	@GetMapping("/forum/stats")
	public forumStatsdto forumStats() {
		/*
		 * get all forums by findall method
		 */
		List<Forum> list = forumRepository.findAll();
		/*
		 * creating dto for stats
		 */
		forumStatsdto dto = new forumStatsdto();
		/*
		 * get list of list<Question> by forum list
		 */
		List<List<Question>> list2 = list.stream().map(f->f.getQuestion()).collect(Collectors.toList());
	
		List<Question> QuestionList = new ArrayList<>();
		List<Answer> AnswerList = new ArrayList<>();
		/*
		 * Treeset for the users to not get repeated values
		 */
		Set<String> users = new TreeSet<>();
		/*
		 * itreating through list of list of Question 
		 */
		for(List<Question> l: list2) {
			/*
			 * iterate through list of question
			 */
			for(Question q : l) {
				QuestionList.add(q);	// add question to list
				users.add(q.getUsername()); // add user to set
				/*
				 * iterating through list of answers of each question
				 */
				for(Answer al : q.getAnswer()) {
					AnswerList.add(al);		// add answer to list
					users.add(al.getUsername()); // add user to set
				}
			}
		}
		
		/*
		 * add the list sizes directly to dto
		 */
		dto.setTotalNumberOfTopics(list.size());
		dto.setTotalNumberOfQuestions(QuestionList.size());
		dto.setTotalNumberOfAnswers(AnswerList.size());
		dto.setTotalNumberOfUsers(users.size());
		return dto;
		
	}
	
}


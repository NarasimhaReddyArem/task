package com.task.musicalpillow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.musicalpillow.data.MusicalPillowDetails;
import com.task.musicalpillow.data.Winner;
import com.task.musicalpillow.impl.MusicalPillowImpl;

@RestController
public class MusicalPillowController {

	
	@PutMapping("/task/winner") 
	public ResponseEntity<Object> getWinner(@RequestBody MusicalPillowDetails details) {
			
			int winningPosition = MusicalPillowImpl.gameWinner(details);
			Winner winner = new Winner();
			winner.setWinner(winningPosition);
			return new ResponseEntity<>(winner,HttpStatus.OK);
		}
		
	}
	


package com.task.musicalpillow.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.task.musicalpillow.data.MusicalPillowDetails;

public class MusicalPillowImpl {

	int count;
	int songDuration;

	int startingPosition;
	List<Integer> list = new ArrayList();

	// Finding which person is out of the game
	int startgame(int pos) {
		int in = pos;
		for (int i = 0; i < songDuration - 1; i++) {
			if (in == list.size() - 1)
				in = 0;
			else
				in++;
		}
		return in;

	}

	int deleteItem(int pos) {

		int k = startgame(pos);
		Integer str;

		if (k == list.size() - 1) { // if game playing 2 persons (if list having 2 elements means) means this
									// condition will excuete
			str = list.get(0);
		} else { // if game playing more than 2 persons (if list having more than 2 elements
					// means) means this condition will excuete

			str = list.get(k + 1);
		}

		// remove loosed person from the game (remove the integer from list)
		list.remove(k);

		// update the starting position
		startingPosition = list.indexOf(str);

		return list.size();

	}

	public int gameWinner(MusicalPillowDetails details) {

		count = details.getCount();
		songDuration = details.getSongDuration();
		startingPosition = 0;

		// Adding the 1,2,3 ...up to count to list using for loop
		for (int i = 1; i <= count; i++) {
			list.add(i);
		}

		// Each and every iteration one person out of the game
		while (count > 1) {

			count = deleteItem(startingPosition);

		}

		return list.get(0);

	}

}

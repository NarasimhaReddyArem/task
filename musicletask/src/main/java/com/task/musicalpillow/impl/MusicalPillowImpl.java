package com.task.musicalpillow.impl;

import java.util.ArrayList;
import java.util.List;



import com.task.musicalpillow.data.MusicalPillowDetails;

public class MusicalPillowImpl {

	static int count;
	static int songDuration;

	static int startingPosition = 0;
	static List<Integer> list = new ArrayList();

	static int increment(int pos) {
		int in = pos;
		for (int i = 0; i < songDuration - 1; i++) {
			if (in == list.size() - 1)
				in = 0;
			else
				in++;
		}
		return in;

	}

	static int deleteItem(int pos) {

		int k = increment(pos);
		Integer str;

		if (k == list.size() - 1) {
			str = (Integer) list.get(0);
		} else {
			str = (Integer) list.get(k + 1);
		}

		list.remove(k);
		startingPosition = list.indexOf(str);

		return list.size() - 1;

	}

	

	public static int gameWinner(MusicalPillowDetails details) {

		count = details.getCount();
		songDuration = details.getSongDuration();

		for (int i = 1; i <= count; i++) {
			list.add(i);
		}

		count = deleteItem(startingPosition);
		while (count > 0) {

			count = deleteItem(startingPosition);

		}

		int k;
		k = (Integer) list.get(count);

		return k;

	}

}

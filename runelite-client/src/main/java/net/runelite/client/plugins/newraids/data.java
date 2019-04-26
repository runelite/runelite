package net.runelite.client.plugins.newraids;

import java.util.Date;

public class data
{
	int total;
	int personal;
	int hr;
	int timeTaken;
	int kc;
	boolean cm;
	String raid;
	Date start;
	Date finish;

	void add(int total, int personal, int hr, int timeTaken, int kc, boolean cm, String raid, Date start, Date finish)
	{
		this.total = total;
		this.personal = personal;
		this.hr = hr;
		this.kc = kc;
		this.cm = cm;
		this.timeTaken = timeTaken;
		this.raid = raid;
		this.start = start;
		this.finish = finish;
	}
}

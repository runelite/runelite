package net.runelite.http.api.hiscore;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Datapoint
{
	private TimePeriod time;
	private Map<HiscoreSkill, Progression> xp = new HashMap<>();

	public enum TimePeriod
	{
		DAY, WEEK, MONTH
	}

	protected Datapoint(TimePeriod time)
	{
		this.time = time;
	}

	static class Builder
	{
		private TimePeriod timePeriod;
		private Map<HiscoreSkill, Progression> xp = new HashMap<>();

		Builder(TimePeriod timePeriod)
		{
			this.timePeriod = timePeriod;
		}

		void addProgression(HiscoreSkill skill, Progression amount)
		{
			xp.put(skill, amount);
		}

		public Datapoint build()
		{
			Datapoint instance = new Datapoint(timePeriod);
			instance.xp = xp;
			return instance;
		}
	}
}

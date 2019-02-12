package net.runelite.client.events;

import lombok.Value;

@Value
public class SlayerTaskChanged
{
	private final String oldTask, newTask;
}

package net.runelite.client.plugins.autoaccount;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Singleton
@Slf4j
public class AutoAccountConfig
{

	@Setter
	private String username;

	@Setter
	private String password;

	@Setter
	private int world;



}

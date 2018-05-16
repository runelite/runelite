/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.http.service.xp;

import java.io.IOException;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.hiscore.HiscoreEndpoint;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.xp.XpData;
import net.runelite.http.service.hiscore.HiscoreResultBuilder;
import net.runelite.http.service.hiscore.HiscoreService;
import net.runelite.http.service.xp.beans.PlayerEntity;
import net.runelite.http.service.xp.beans.XpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Service
@Slf4j
public class XpTrackerService
{
	private static final String CREATE_PLAYER_SQL = "CREATE TABLE IF NOT EXISTS `player` (\n" +
		"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
		"  `name` varchar(32) NOT NULL,\n" +
		"  `tracked_since` timestamp NOT NULL DEFAULT current_timestamp(),\n" +
		"  PRIMARY KEY (`id`),\n" +
		"  UNIQUE KEY `name` (`name`)\n" +
		") ENGINE=InnoDB\n";

	private static final String CREATE_XP_SQL = "CREATE TABLE IF NOT EXISTS `xp` (\n" +
		"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
		"  `time` timestamp NOT NULL DEFAULT current_timestamp(),\n" +
		"  `player` int(11) NOT NULL,\n" +
		"  `attack_xp` int(11) NOT NULL,\n" +
		"  `defence_xp` int(11) NOT NULL,\n" +
		"  `strength_xp` int(11) NOT NULL,\n" +
		"  `hitpoints_xp` int(11) NOT NULL,\n" +
		"  `ranged_xp` int(11) NOT NULL,\n" +
		"  `prayer_xp` int(11) NOT NULL,\n" +
		"  `magic_xp` int(11) NOT NULL,\n" +
		"  `cooking_xp` int(11) NOT NULL,\n" +
		"  `woodcutting_xp` int(11) NOT NULL,\n" +
		"  `fletching_xp` int(11) NOT NULL,\n" +
		"  `fishing_xp` int(11) NOT NULL,\n" +
		"  `firemaking_xp` int(11) NOT NULL,\n" +
		"  `crafting_xp` int(11) NOT NULL,\n" +
		"  `smithing_xp` int(11) NOT NULL,\n" +
		"  `mining_xp` int(11) NOT NULL,\n" +
		"  `herblore_xp` int(11) NOT NULL,\n" +
		"  `agility_xp` int(11) NOT NULL,\n" +
		"  `thieving_xp` int(11) NOT NULL,\n" +
		"  `slayer_xp` int(11) NOT NULL,\n" +
		"  `farming_xp` int(11) NOT NULL,\n" +
		"  `runecraft_xp` int(11) NOT NULL,\n" +
		"  `hunter_xp` int(11) NOT NULL,\n" +
		"  `construction_xp` int(11) NOT NULL,\n" +
		"  `overall_xp` int(11) NOT NULL,\n" +
		"  `attack_level` int(11) NOT NULL ,\n" +
		"  `defence_level` int(11) NOT NULL ,\n" +
		"  `strength_level` int(11) NOT NULL ,\n" +
		"  `hitpoints_level` int(11) NOT NULL ,\n" +
		"  `ranged_level` int(11) NOT NULL ,\n" +
		"  `prayer_level` int(11) NOT NULL ,\n" +
		"  `magic_level` int(11) NOT NULL ,\n" +
		"  `cooking_level` int(11) NOT NULL ,\n" +
		"  `woodcutting_level` int(11) NOT NULL ,\n" +
		"  `fletching_level` int(11) NOT NULL ,\n" +
		"  `fishing_level` int(11) NOT NULL ,\n" +
		"  `firemaking_level` int(11) NOT NULL ,\n" +
		"  `crafting_level` int(11) NOT NULL ,\n" +
		"  `smithing_level` int(11) NOT NULL ,\n" +
		"  `mining_level` int(11) NOT NULL ,\n" +
		"  `herblore_level` int(11) NOT NULL ,\n" +
		"  `agility_level` int(11) NOT NULL ,\n" +
		"  `thieving_level` int(11) NOT NULL ,\n" +
		"  `slayer_level` int(11) NOT NULL ,\n" +
		"  `farming_level` int(11) NOT NULL ,\n" +
		"  `runecraft_level` int(11) NOT NULL ,\n" +
		"  `hunter_level` int(11) NOT NULL ,\n" +
		"  `construction_level` int(11) NOT NULL ,\n" +
		"  `overall_level` int(11) NOT NULL ,\n" +
		"  `attack_rank` int(11) NOT NULL,\n" +
		"  `defence_rank` int(11) NOT NULL,\n" +
		"  `strength_rank` int(11) NOT NULL,\n" +
		"  `hitpoints_rank` int(11) NOT NULL,\n" +
		"  `ranged_rank` int(11) NOT NULL,\n" +
		"  `prayer_rank` int(11) NOT NULL,\n" +
		"  `magic_rank` int(11) NOT NULL,\n" +
		"  `cooking_rank` int(11) NOT NULL,\n" +
		"  `woodcutting_rank` int(11) NOT NULL,\n" +
		"  `fletching_rank` int(11) NOT NULL,\n" +
		"  `fishing_rank` int(11) NOT NULL,\n" +
		"  `firemaking_rank` int(11) NOT NULL,\n" +
		"  `crafting_rank` int(11) NOT NULL,\n" +
		"  `smithing_rank` int(11) NOT NULL,\n" +
		"  `mining_rank` int(11) NOT NULL,\n" +
		"  `herblore_rank` int(11) NOT NULL,\n" +
		"  `agility_rank` int(11) NOT NULL,\n" +
		"  `thieving_rank` int(11) NOT NULL,\n" +
		"  `slayer_rank` int(11) NOT NULL,\n" +
		"  `farming_rank` int(11) NOT NULL,\n" +
		"  `runecraft_rank` int(11) NOT NULL,\n" +
		"  `hunter_rank` int(11) NOT NULL,\n" +
		"  `construction_rank` int(11) NOT NULL,\n" +
		"  `overall_rank` int(11) NOT NULL,\n" +
		"  PRIMARY KEY (`id`),\n" +
		"  UNIQUE KEY `player_time` (`player`,`time`),\n" +
		"  CONSTRAINT `fk_player` FOREIGN KEY (`player`) REFERENCES `player` (`id`)\n" +
		") ENGINE=InnoDB\n";

	private final Sql2o sql2o;
	private final HiscoreService hiscoreService;

	@Autowired
	public XpTrackerService(@Qualifier("Runelite XP Tracker SQL2O") Sql2o sql2o, HiscoreService hiscoreService)
	{
		this.sql2o = sql2o;
		this.hiscoreService = hiscoreService;

		try (Connection con = sql2o.beginTransaction())
		{
			con.createQuery(CREATE_PLAYER_SQL).executeUpdate();
			con.createQuery(CREATE_XP_SQL).executeUpdate();
		}
	}

	public void update(String username) throws IOException
	{
		HiscoreResultBuilder hiscoreResultBuilder = hiscoreService.lookupUsername(username, HiscoreEndpoint.NORMAL);
		HiscoreResult hiscoreResult = hiscoreResultBuilder.build();
		update(username, hiscoreResult);
	}

	public void update(String username, HiscoreResult hiscoreResult)
	{
		try (Connection con = sql2o.open())
		{
			PlayerEntity playerEntity = findOrCreatePlayer(con, username);

			XpEntity currentXp = findXpAtTime(con, username, Instant.now());
			if (currentXp != null)
			{
				XpData hiscoreData = XpMapper.INSTANCE.hiscoreResultToXpData(hiscoreResult);
				XpData existingData = XpMapper.INSTANCE.xpEntityToXpData(currentXp);

				if (hiscoreData.equals(existingData))
				{
					log.debug("Hiscore for {} already up to date", username);
					return;
				}
			}

			con.createQuery("insert into xp (player,attack_xp,defence_xp,strength_xp,hitpoints_xp,ranged_xp,prayer_xp,magic_xp,cooking_xp,woodcutting_xp,"
				+ "fletching_xp,fishing_xp,firemaking_xp,crafting_xp,smithing_xp,mining_xp,herblore_xp,agility_xp,thieving_xp,slayer_xp,farming_xp,"
				+ "runecraft_xp,hunter_xp,construction_xp,overall_xp,attack_level,defence_level,strength_level,hitpoints_level,ranged_level,prayer_level,magic_level,cooking_level,woodcutting_level,"
				+ "fletching_level,fishing_level,firemaking_level,crafting_level,smithing_level,mining_level,herblore_level,agility_level,thieving_level,slayer_level,farming_level,"
				+ "runecraft_level,hunter_level,construction_level,overall_level,attack_rank,defence_rank,strength_rank,hitpoints_rank,ranged_rank,prayer_rank,magic_rank,"
				+ "cooking_rank,woodcutting_rank,fletching_rank,fishing_rank,firemaking_rank,crafting_rank,smithing_rank,mining_rank,herblore_rank,"
				+ "agility_rank,thieving_rank,slayer_rank,farming_rank,runecraft_rank,hunter_rank,construction_rank,overall_rank) values (:player,:attack_xp,:defence_xp,"
				+ ":strength_xp,:hitpoints_xp,:ranged_xp,:prayer_xp,:magic_xp,:cooking_xp,:woodcutting_xp,:fletching_xp,:fishing_xp,:firemaking_xp,"
				+ ":crafting_xp,:smithing_xp,:mining_xp,:herblore_xp,:agility_xp,:thieving_xp,:slayer_xp,:farming_xp,:runecraft_xp,:hunter_xp,"
				+ ":construction_xp,:overall_xp,:attack_level,:defence_level,:strength_level,:hitpoints_level,:ranged_level,:prayer_level,:magic_level,:cooking_level,:woodcutting_level,"
				+ ":fletching_level,:fishing_level,:firemaking_level,:crafting_level,:smithing_level,:mining_level,:herblore_level,:agility_level,:thieving_level,:slayer_level,:farming_level,"
				+ ":runecraft_level,:hunter_level,:construction_level,:overall_level,:attack_rank,:defence_rank,:strength_rank,:hitpoints_rank,:ranged_rank,:prayer_rank,:magic_rank,:cooking_rank,"
				+ ":woodcutting_rank,:fletching_rank,:fishing_rank,:firemaking_rank,:crafting_rank,:smithing_rank,:mining_rank,:herblore_rank,"
				+ ":agility_rank,:thieving_rank,:slayer_rank,:farming_rank,:runecraft_rank,:hunter_rank,:construction_rank,:overall_rank)")
				.addParameter("player", playerEntity.getId())
				.addParameter("attack_xp", hiscoreResult.getAttack().getExperience())
				.addParameter("defence_xp", hiscoreResult.getDefence().getExperience())
				.addParameter("strength_xp", hiscoreResult.getStrength().getExperience())
				.addParameter("hitpoints_xp", hiscoreResult.getHitpoints().getExperience())
				.addParameter("ranged_xp", hiscoreResult.getRanged().getExperience())
				.addParameter("prayer_xp", hiscoreResult.getPrayer().getExperience())
				.addParameter("magic_xp", hiscoreResult.getMagic().getExperience())
				.addParameter("cooking_xp", hiscoreResult.getCooking().getExperience())
				.addParameter("woodcutting_xp", hiscoreResult.getWoodcutting().getExperience())
				.addParameter("fletching_xp", hiscoreResult.getFletching().getExperience())
				.addParameter("fishing_xp", hiscoreResult.getFishing().getExperience())
				.addParameter("firemaking_xp", hiscoreResult.getFiremaking().getExperience())
				.addParameter("crafting_xp", hiscoreResult.getCrafting().getExperience())
				.addParameter("smithing_xp", hiscoreResult.getSmithing().getExperience())
				.addParameter("mining_xp", hiscoreResult.getMining().getExperience())
				.addParameter("herblore_xp", hiscoreResult.getHerblore().getExperience())
				.addParameter("agility_xp", hiscoreResult.getAgility().getExperience())
				.addParameter("thieving_xp", hiscoreResult.getThieving().getExperience())
				.addParameter("slayer_xp", hiscoreResult.getSlayer().getExperience())
				.addParameter("farming_xp", hiscoreResult.getFarming().getExperience())
				.addParameter("runecraft_xp", hiscoreResult.getRunecraft().getExperience())
				.addParameter("hunter_xp", hiscoreResult.getHunter().getExperience())
				.addParameter("construction_xp", hiscoreResult.getConstruction().getExperience())
				.addParameter("overall_xp", hiscoreResult.getOverall().getExperience())
				.addParameter("attack_level", hiscoreResult.getAttack().getLevel())
				.addParameter("defence_level", hiscoreResult.getDefence().getLevel())
				.addParameter("strength_level", hiscoreResult.getStrength().getLevel())
				.addParameter("hitpoints_level", hiscoreResult.getHitpoints().getLevel())
				.addParameter("ranged_level", hiscoreResult.getRanged().getLevel())
				.addParameter("prayer_level", hiscoreResult.getPrayer().getLevel())
				.addParameter("magic_level", hiscoreResult.getMagic().getLevel())
				.addParameter("cooking_level", hiscoreResult.getCooking().getLevel())
				.addParameter("woodcutting_level", hiscoreResult.getWoodcutting().getLevel())
				.addParameter("fletching_level", hiscoreResult.getFletching().getLevel())
				.addParameter("fishing_level", hiscoreResult.getFishing().getLevel())
				.addParameter("firemaking_level", hiscoreResult.getFiremaking().getLevel())
				.addParameter("crafting_level", hiscoreResult.getCrafting().getLevel())
				.addParameter("smithing_level", hiscoreResult.getSmithing().getLevel())
				.addParameter("mining_level", hiscoreResult.getMining().getLevel())
				.addParameter("herblore_level", hiscoreResult.getHerblore().getLevel())
				.addParameter("agility_level", hiscoreResult.getAgility().getLevel())
				.addParameter("thieving_level", hiscoreResult.getThieving().getLevel())
				.addParameter("slayer_level", hiscoreResult.getSlayer().getLevel())
				.addParameter("farming_level", hiscoreResult.getFarming().getLevel())
				.addParameter("runecraft_level", hiscoreResult.getRunecraft().getLevel())
				.addParameter("hunter_level", hiscoreResult.getHunter().getLevel())
				.addParameter("construction_level", hiscoreResult.getConstruction().getLevel())
				.addParameter("overall_level", hiscoreResult.getOverall().getLevel())
				.addParameter("attack_rank", hiscoreResult.getAttack().getRank())
				.addParameter("defence_rank", hiscoreResult.getDefence().getRank())
				.addParameter("strength_rank", hiscoreResult.getStrength().getRank())
				.addParameter("hitpoints_rank", hiscoreResult.getHitpoints().getRank())
				.addParameter("ranged_rank", hiscoreResult.getRanged().getRank())
				.addParameter("prayer_rank", hiscoreResult.getPrayer().getRank())
				.addParameter("magic_rank", hiscoreResult.getMagic().getRank())
				.addParameter("cooking_rank", hiscoreResult.getCooking().getRank())
				.addParameter("woodcutting_rank", hiscoreResult.getWoodcutting().getRank())
				.addParameter("fletching_rank", hiscoreResult.getFletching().getRank())
				.addParameter("fishing_rank", hiscoreResult.getFishing().getRank())
				.addParameter("firemaking_rank", hiscoreResult.getFiremaking().getRank())
				.addParameter("crafting_rank", hiscoreResult.getCrafting().getRank())
				.addParameter("smithing_rank", hiscoreResult.getSmithing().getRank())
				.addParameter("mining_rank", hiscoreResult.getMining().getRank())
				.addParameter("herblore_rank", hiscoreResult.getHerblore().getRank())
				.addParameter("agility_rank", hiscoreResult.getAgility().getRank())
				.addParameter("thieving_rank", hiscoreResult.getThieving().getRank())
				.addParameter("slayer_rank", hiscoreResult.getSlayer().getRank())
				.addParameter("farming_rank", hiscoreResult.getFarming().getRank())
				.addParameter("runecraft_rank", hiscoreResult.getRunecraft().getRank())
				.addParameter("hunter_rank", hiscoreResult.getHunter().getRank())
				.addParameter("construction_rank", hiscoreResult.getConstruction().getRank())
				.addParameter("overall_rank", hiscoreResult.getOverall().getRank())
				.executeUpdate();
		}
	}

	private synchronized PlayerEntity findOrCreatePlayer(Connection con, String username)
	{
		PlayerEntity playerEntity = con.createQuery("select * from player where name = :name")
			.addParameter("name", username)
			.executeAndFetchFirst(PlayerEntity.class);
		if (playerEntity != null)
		{
			return playerEntity;
		}

		Instant now = Instant.now();

		int id = con.createQuery("insert into player (name, tracked_since) values (:name, :tracked_since)")
			.addParameter("name", username)
			.addParameter("tracked_since", now)
			.executeUpdate()
			.getKey(int.class);

		playerEntity = new PlayerEntity();
		playerEntity.setId(id);
		playerEntity.setName(username);
		playerEntity.setTracked_since(now);
		return playerEntity;
	}

	private XpEntity findXpAtTime(Connection con, String username, Instant time)
	{
		return con.createQuery("select * from xp join player on player.id=xp.player where player.name = :username and time <= :time order by time desc limit 1")
			.throwOnMappingFailure(false)
			.addParameter("username", username)
			.addParameter("time", time)
			.executeAndFetchFirst(XpEntity.class);
	}

	public XpEntity findXpAtTime(String username, Instant time)
	{
		try (Connection con = sql2o.open())
		{
			return findXpAtTime(con, username, time);
		}
	}
}

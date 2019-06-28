/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.service.animation;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.List;
import net.runelite.http.api.animation.AnimationKey;
import net.runelite.http.api.animation.AnimationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Service
public class AnimationEndpoint
{
	private static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS `animation` (\n"
		+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
		+ "  `npcid` int(11) NOT NULL,\n"
		+ "  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n"
		+ "  `rev` int(11) NOT NULL,\n"
		+ "  `anim1` int(11) NOT NULL,\n"
		+ "  `anim2` int(11),\n"
		+ "  `anim3` int(11),\n"
		+ "  `anim4` int(11),\n"
		+ "  `anim5` int(11),\n"
		+ "  `anim6` int(11),\n"
		+ "  `anim7` int(11),\n"
		+ "  `anim8` int(11),\n"
		+ "  `anim9` int(11),\n"
		+ "  `anim10` int(11),\n"
		+ "  PRIMARY KEY (`id`),\n"
		+ "  KEY `npcid` (`npcid`,`time`)\n"
		+ ") ENGINE=InnoDB";

	private final Sql2o sql2o;

	private final Cache<Integer, AnimationCache> keyCache = CacheBuilder.newBuilder()
		.maximumSize(1024)
		.build();

	@Autowired
	public AnimationEndpoint(
		@Qualifier("Runelite SQL2O") Sql2o sql2o
	)
	{
		this.sql2o = sql2o;

		try (Connection con = sql2o.beginTransaction())
		{
			con.createQuery(CREATE_SQL)
				.executeUpdate();
		}
	}

	private AnimationEntry findLatestAnimations(Connection con, int npcid)
	{
		return con.createQuery("select npcid, time, anim1, anim2, anim3, anim4, anim5, anim6, anim7, anim8, anim9, anim10 from animation "
			+ "where npcid = :npcid "
			+ "order by time desc "
			+ "limit 1")
			.addParameter("npcid", npcid)
			.executeAndFetchFirst(AnimationEntry.class);
	}

	public void submit(AnimationRequest animationRequest)
	{
		boolean cached = true;
		for (AnimationKey key : animationRequest.getKeys())
		{
			int npcid = key.getNPCId();
			int[] animations = key.getAnimations();

			AnimationCache animationCache = keyCache.getIfPresent(npcid);
			if (animationCache == null
				|| animationCache.getAnim1() != animations[0]
				|| animationCache.getAnim2() != animations[1]
				|| animationCache.getAnim3() != animations[2]
				|| animationCache.getAnim4() != animations[3]
				|| animationCache.getAnim5() != animations[4]
				|| animationCache.getAnim6() != animations[5]
				|| animationCache.getAnim7() != animations[6]
				|| animationCache.getAnim8() != animations[7]
				|| animationCache.getAnim9() != animations[8]
				|| animationCache.getAnim10() != animations[9])
			{
				cached = false;
				keyCache.put(npcid, new AnimationCache(npcid, animations[0], animations[1], animations[2], animations[3], animations[4], animations[5], animations[6], animations[7], animations[8], animations[9]));
			}
		}

		if (cached)
		{
			return;
		}

		try (Connection con = sql2o.beginTransaction())
		{
			Query query = null;

			for (AnimationKey key : animationRequest.getKeys())
			{
				int npcid = key.getNPCId();
				int[] animations = key.getAnimations();

				AnimationEntry animationEntry = findLatestAnimations(con, npcid);

				if (animations.length != 10)
				{
					throw new IllegalArgumentException("Key length must be 10");
				}

				// already have these?
				if (animationEntry != null
					&& animationEntry.getAnimations()[0] == animations[0]
					&& animationEntry.getAnimations()[1] == animations[1]
					&& animationEntry.getAnimations()[2] == animations[2]
					&& animationEntry.getAnimations()[3] == animations[3]
					&& animationEntry.getAnimations()[4] == animations[4]
					&& animationEntry.getAnimations()[5] == animations[5]
					&& animationEntry.getAnimations()[6] == animations[6]
					&& animationEntry.getAnimations()[7] == animations[7]
					&& animationEntry.getAnimations()[8] == animations[8]
					&& animationEntry.getAnimations()[9] == animations[9])
				{
					continue;
				}


				if (query == null)
				{
					query = con.createQuery("insert into animation (npcid, rev, anim1, anim2, anim3, anim4, anim5, anim6, anim7, anim8, anim9, anim10) "
						+ "values (:npcid, :rev, :anim1, :anim2, :anim3, :anim4, anim5, anim6, anim7, anim8, anim9, anim10)");
				}

				query.addParameter("npcid", npcid)
					.addParameter("rev", animationRequest.getRevision())
					.addParameter("anim1", animations[0])
					.addParameter("anim2", animations[1])
					.addParameter("anim3", animations[2])
					.addParameter("anim4", animations[3])
					.addParameter("anim5", animations[4])
					.addParameter("anim6", animations[5])
					.addParameter("anim7", animations[6])
					.addParameter("anim8", animations[7])
					.addParameter("anim9", animations[8])
					.addParameter("anim10", animations[9])
					.addToBatch();
			}

			if (query != null)
			{
				query.executeBatch();
				con.commit(false);
			}
		}
	}

	public List<AnimationEntry> get()
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery(
				"select t1.npcid, t2.time, t2.rev, t2.anim1, t2.anim2, t2.anim3, t2.anim4, t2.anim5, t2.anim6, t2.anim7, t2.anim8, t2.anim9, t2.anim10 from " +
					"(select npcid,max(id) as id from animation group by npcid) t1 " +
					"join animation t2 on t1.id = t2.id")
				.executeAndFetch(AnimationEntry.class);
		}
	}

	public AnimationEntry getNPC(int npcid)
	{
		try (Connection con = sql2o.open())
		{
			return con.createQuery("select npcid, time, rev, anim1, anim2, anim3, anim4, anim5, anim6, anim7, anim8, anim9, anim10 from animation "
				+ "where npcid = :npcid order by time desc limit 1")
				.addParameter("npcid", npcid)
				.executeAndFetchFirst(AnimationEntry.class);
		}
	}
}

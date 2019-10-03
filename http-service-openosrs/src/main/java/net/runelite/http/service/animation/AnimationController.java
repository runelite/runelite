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
package net.runelite.http.service.animation;

import java.util.List;
import java.util.stream.Collectors;
import net.runelite.http.api.animation.AnimationKey;
import net.runelite.http.api.animation.AnimationRequest;
import net.runelite.http.service.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animation")
public class AnimationController
{
	@Autowired
	private AnimationEndpoint animationService;

	@RequestMapping(method = POST)
	public void submit(@RequestBody AnimationRequest animationRequest)
	{
		animationService.submit(animationRequest);
	}

	@GetMapping
	public List<AnimationKey> get()
	{
		return animationService.get().stream()
			.map(AnimationController::entryToKey)
			.collect(Collectors.toList());
	}

	@GetMapping("/{npcid}")
	public AnimationKey getRegion(@PathVariable int npcid)
	{
		AnimationEntry animationEntry = animationService.getNPC(npcid);
		if (animationEntry == null)
		{
			throw new NotFoundException();
		}

		return entryToKey(animationEntry);
	}

	private static AnimationKey entryToKey(AnimationEntry xe)
	{
		AnimationKey animationKey = new AnimationKey();
		animationKey.setNPCId(xe.getNPCId());
		animationKey.setAnimations(new int[]
		{
			xe.getAnimations()[0],
			xe.getAnimations()[1],
			xe.getAnimations()[2],
			xe.getAnimations()[3],
			xe.getAnimations()[4],
			xe.getAnimations()[5],
			xe.getAnimations()[6],
			xe.getAnimations()[7],
			xe.getAnimations()[8],
			xe.getAnimations()[9],
		});
		return animationKey;
	}
}

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
package net.runelite.http.service.xtea;

import java.util.List;
import java.util.stream.Collectors;
import net.runelite.http.api.xtea.XteaKey;
import net.runelite.http.api.xtea.XteaRequest;
import net.runelite.http.service.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xtea")
public class XteaController
{
	@Autowired
	private XteaEndpoint xteaService;

	@RequestMapping(method = POST)
	public void submit(@RequestBody XteaRequest xteaRequest)
	{
		xteaService.submit(xteaRequest);
	}

	@GetMapping
	public List<XteaKey> get()
	{
		return xteaService.get().stream()
			.map(XteaController::entryToKey)
			.collect(Collectors.toList());
	}

	@GetMapping("/{region}")
	public XteaKey getRegion(@PathVariable int region)
	{
		XteaEntry xteaRegion = xteaService.getRegion(region);
		if (xteaRegion == null)
		{
			throw new NotFoundException();
		}

		return entryToKey(xteaRegion);
	}

	private static XteaKey entryToKey(XteaEntry xe)
	{
		XteaKey xteaKey = new XteaKey();
		xteaKey.setRegion(xe.getRegion());
		xteaKey.setKeys(new int[]
		{
			xe.getKey1(),
			xe.getKey2(),
			xe.getKey3(),
			xe.getKey4()
		});
		return xteaKey;
	}
}

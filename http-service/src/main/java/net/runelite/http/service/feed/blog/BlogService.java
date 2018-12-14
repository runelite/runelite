/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
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
package net.runelite.http.service.feed.blog;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.runelite.http.api.RuneLiteAPI;
import net.runelite.http.api.feed.FeedItem;
import net.runelite.http.api.feed.FeedItemType;
import net.runelite.http.service.util.exception.InternalServerErrorException;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class BlogService
{
	private static final HttpUrl RSS_URL = HttpUrl.parse("https://runelite.net/atom.xml");
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

	public List<FeedItem> getBlogPosts() throws IOException
	{
		Request request = new Request.Builder()
			.url(RSS_URL)
			.build();

		try (Response response = RuneLiteAPI.CLIENT.newCall(request).execute())
		{
			if (!response.isSuccessful())
			{
				throw new IOException("Error getting blog posts: " + response.message());
			}

			try
			{
				InputStream in = response.body().byteStream();
				Document document = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder()
						.parse(in);

				Element documentElement = document.getDocumentElement();
				NodeList documentItems = documentElement.getElementsByTagName("entry");

				List<FeedItem> items = new ArrayList<>();

				for (int i = 0; i < Math.min(documentItems.getLength(), 3); i++)
				{
					Node item = documentItems.item(i);
					NodeList children = item.getChildNodes();

					String title = null;
					String summary = null;
					String link = null;
					long timestamp = -1;

					for (int j = 0; j < children.getLength(); j++)
					{
						Node childItem = children.item(j);
						String nodeName = childItem.getNodeName();

						switch (nodeName)
						{
							case "title":
								title = childItem.getTextContent();
								break;
							case "summary":
								summary = childItem.getTextContent().replace("\n", "").trim();
								break;
							case "link":
								link = childItem.getAttributes().getNamedItem("href").getTextContent();
								break;
							case "updated":
								timestamp = DATE_FORMAT.parse(childItem.getTextContent()).getTime();
								break;
						}
					}

					if (title == null || summary == null || link == null || timestamp == -1)
					{
						throw new InternalServerErrorException("Failed to find title, summary, link and/or timestamp in the blog post feed");
					}

					items.add(new FeedItem(FeedItemType.BLOG_POST, title, summary, link, timestamp));
				}

				return items;
			}
			catch (ParserConfigurationException | SAXException | ParseException e)
			{
				throw new InternalServerErrorException("Failed to parse blog posts: " + e.getMessage());
			}
		}
	}
}

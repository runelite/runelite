/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.info;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLEditorKit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class JRichTextPane extends JEditorPane
{
	private HyperlinkListener linkHandler;

	public JRichTextPane()
	{
		super();
		setHighlighter(null);
		setEditable(false);
		setOpaque(false);
		enableAutoLinkHandler(true);
		setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		HTMLEditorKit ek = (HTMLEditorKit) getEditorKitForContentType("text/html");
		ek.getStyleSheet().addRule("a {color: #DDDDDD }");
	}

	public JRichTextPane(String type, String text)
	{
		this();
		setContentType(type);
		setText(text);
	}

	void enableAutoLinkHandler(boolean enable)
	{
		if (enable == (linkHandler == null))
		{
			if (enable)
			{
				linkHandler = e ->
				{
					if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType()) && e.getURL() != null && Desktop.isDesktopSupported())
					{
						try
						{
							Desktop.getDesktop().browse(e.getURL().toURI());
						}
						catch (URISyntaxException | IOException ex)
						{
							log.warn("Error opening link", ex);
						}
					}
				};
				addHyperlinkListener(linkHandler);
			}
			else
			{
				removeHyperlinkListener(linkHandler);
				linkHandler = null;
			}
		}
	}

	public boolean getAutoLinkHandlerEnabled()
	{
		return linkHandler != null;
	}
}

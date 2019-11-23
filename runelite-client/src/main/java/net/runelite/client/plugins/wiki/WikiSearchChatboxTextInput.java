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
package net.runelite.client.plugins.wiki;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.api.widgets.WidgetSizeMode;
import net.runelite.api.widgets.WidgetTextAlignment;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.util.LinkBrowser;
import net.runelite.http.api.RuneLiteAPI;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class WikiSearchChatboxTextInput extends ChatboxTextInput
{
	private static final int LINE_HEIGHT = 20;
	private static final int CHATBOX_HEIGHT = 120;
	private static final int MAX_NUM_PREDICTIONS = (CHATBOX_HEIGHT / LINE_HEIGHT) - 2; // 1 title, 1 edit

	private static final int PREDICTION_DEBOUNCE_DELAY_MS = 200;

	private final ChatboxPanelManager chatboxPanelManager;
	private final Gson gson = new Gson();

	private Future<?> runningRequest = null;
	private List<String> predictions = ImmutableList.of();

	private int selectedPrediction = -1;
	private String offPrediction = null;

	@Inject
	public WikiSearchChatboxTextInput(final ChatboxPanelManager chatboxPanelManager, final ClientThread clientThread, final ScheduledExecutorService scheduledExecutorService, @Named("developerMode") final boolean developerMode)
	{
		super(chatboxPanelManager, clientThread);
		this.chatboxPanelManager = chatboxPanelManager;

		lines(1);
		prompt("OSRS Wiki Search");
		onDone(string ->
		{
			if (string != null && string.length() > 0)
			{
				search(string);
			}
		});
		onChanged(searchString ->
		{
			selectedPrediction = -1;
			Future<?> rr = runningRequest;
			if (rr != null)
			{
				rr.cancel(false);
			}
			if (searchString.length() <= 1)
			{
				runningRequest = null;
				clientThread.invokeLater(() ->
				{
					predictions = ImmutableList.of();
					update();
				});
				return;
			}
			runningRequest = scheduledExecutorService.schedule(() ->
			{
				HttpUrl url = WikiPlugin.WIKI_API.newBuilder()
					.addQueryParameter("action", "opensearch")
					.addQueryParameter("search", searchString)
					.addQueryParameter("redirects", "resolve")
					.addQueryParameter("format", "json")
					.addQueryParameter("warningsaserror", Boolean.toString(developerMode))
					.build();

				Request req = new Request.Builder()
					.url(url)
					.build();

				RuneLiteAPI.CLIENT.newCall(req).enqueue(new Callback()
				{
					@Override
					public void onFailure(@NotNull Call call, @NotNull IOException e)
					{
						log.warn("error searching wiki", e);
					}

					@Override
					public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException
					{
						String body = response.body().string();
						try
						{
							JsonArray jar = new JsonParser().parse(body).getAsJsonArray();
							List<String> apredictions = gson.fromJson(jar.get(1), new TypeToken<List<String>>() {}.getType());

							if (apredictions.size() > MAX_NUM_PREDICTIONS)
							{
								apredictions = apredictions.subList(0, MAX_NUM_PREDICTIONS);
							}

							final List<String> bpredictions = apredictions;

							clientThread.invokeLater(() ->
							{
								predictions = bpredictions;
								update();
							});
						}
						catch (JsonParseException | IllegalStateException | IndexOutOfBoundsException e)
						{
							log.warn("error parsing wiki response {}", body, e);
						}
						finally
						{
							response.close();
						}
					}
				});

				runningRequest = null;
			}, PREDICTION_DEBOUNCE_DELAY_MS, TimeUnit.MILLISECONDS);
		});
	}

	@Override
	protected void update()
	{
		Widget container = chatboxPanelManager.getContainerWidget();
		container.deleteAllChildren();

		Widget promptWidget = container.createChild(-1, WidgetType.TEXT);
		promptWidget.setText(getPrompt());
		promptWidget.setTextColor(0x800000);
		promptWidget.setFontId(getFontID());
		promptWidget.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
		promptWidget.setOriginalX(0);
		promptWidget.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		promptWidget.setOriginalY(5);
		promptWidget.setOriginalHeight(LINE_HEIGHT);
		promptWidget.setXTextAlignment(WidgetTextAlignment.CENTER);
		promptWidget.setYTextAlignment(WidgetTextAlignment.CENTER);
		promptWidget.setWidthMode(WidgetSizeMode.MINUS);
		promptWidget.revalidate();

		buildEdit(0, 5 + LINE_HEIGHT, container.getWidth(), LINE_HEIGHT);

		Widget separator = container.createChild(-1, WidgetType.LINE);
		separator.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
		separator.setOriginalX(0);
		separator.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
		separator.setOriginalY(4 + (LINE_HEIGHT * 2));
		separator.setOriginalHeight(0);
		separator.setOriginalWidth(16);
		separator.setWidthMode(WidgetSizeMode.MINUS);
		separator.revalidate();

		for (int i = 0; i < predictions.size(); i++)
		{
			String pred = predictions.get(i);
			int y = 6 + (LINE_HEIGHT * (2 + i));

			Widget bg = container.createChild(-1, WidgetType.RECTANGLE);
			bg.setTextColor(0x4444DD);
			bg.setFilled(true);
			bg.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
			bg.setOriginalX(1);
			bg.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
			bg.setOriginalY(y);
			bg.setOriginalHeight(LINE_HEIGHT);
			bg.setOriginalWidth(16);
			bg.setWidthMode(WidgetSizeMode.MINUS);
			bg.revalidate();
			bg.setName("<col=ff9040>" + pred);
			bg.setAction(0, "Open");
			bg.setHasListener(true);
			bg.setOnOpListener((JavaScriptCallback) ev -> search(pred));

			Widget text = container.createChild(-1, WidgetType.TEXT);
			text.setText(pred);
			text.setFontId(getFontID());
			text.setXPositionMode(WidgetPositionMode.ABSOLUTE_CENTER);
			text.setOriginalX(0);
			text.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
			text.setOriginalY(y);
			text.setOriginalHeight(LINE_HEIGHT);
			text.setXTextAlignment(WidgetTextAlignment.CENTER);
			text.setYTextAlignment(WidgetTextAlignment.CENTER);
			text.setWidthMode(WidgetSizeMode.MINUS);
			text.revalidate();

			if (i == selectedPrediction)
			{
				text.setTextColor(0xFFFFFF);
			}
			else
			{
				bg.setOpacity(255);
				text.setTextColor(0x000000);
				bg.setOnMouseRepeatListener((JavaScriptCallback) ev -> text.setTextColor(0xFFFFFF));
				bg.setOnMouseLeaveListener((JavaScriptCallback) ev -> text.setTextColor(0x000000));
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent ev)
	{
		switch (ev.getKeyCode())
		{
			case KeyEvent.VK_UP:
				ev.consume();
				if (selectedPrediction > -1)
				{
					selectedPrediction--;
					if (selectedPrediction == -1)
					{
						value(offPrediction);
					}
					else
					{
						value(predictions.get(selectedPrediction));
					}
				}
				break;
			case KeyEvent.VK_DOWN:
				ev.consume();

				if (selectedPrediction == -1)
				{
					offPrediction = getValue();
				}

				selectedPrediction++;
				if (selectedPrediction >= predictions.size())
				{
					selectedPrediction = predictions.size() - 1;
				}

				if (selectedPrediction != -1)
				{
					value(predictions.get(selectedPrediction));
				}
				break;
			default:
				super.keyPressed(ev);
		}
	}

	private void search(String search)
	{
		LinkBrowser.browse(WikiPlugin.WIKI_BASE.newBuilder()
			.addQueryParameter("search", search)
			.addQueryParameter(WikiPlugin.UTM_SOURCE_KEY, WikiPlugin.UTM_SOURCE_VALUE)
			.build()
			.toString());
		chatboxPanelManager.close();
	}
}

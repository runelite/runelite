/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.lfghelper;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.PluginPanel;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class lfghelperpanel extends PluginPanel
{
	private final lfghelperconfig config;

	// Define input fields for the form
	private JTextField bossField;
	private JTextField clanchatField;
	private JTextField teamSizeField;
	private JTextField splitsOrFFAField;
	private JTextField worldField;

	@Inject
	private Client client; // Injected client to get player name

	// Track the last submit time for rate limiting
	private long lastSubmitTime = 0;
	private static final long RATE_LIMIT_TIME = 5 * 60 * 1000; // 5 minutes in milliseconds

	public lfghelperpanel(lfghelperconfig config, Client client)
	{
		this.config = config;
		this.client = client;

		// Set layout and size
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300, 400)); // Optional, to set panel size

		// Font setup
		Font labelFont = new Font("Arial", Font.PLAIN, 14); // Larger font for labels
		Font textFieldFont = new Font("Arial", Font.PLAIN, 16); // Larger font for text fields

		// Boss Input Field
		add(new JLabel("What boss is being killed?"));
		bossField = new JTextField(10);
		bossField.setFont(textFieldFont);
		add(bossField);
		add(Box.createVerticalStrut(10)); // Padding between sections

		// Clanchat Input Field
		add(new JLabel("What clanchat is to be used?"));
		clanchatField = new JTextField(10);
		clanchatField.setFont(textFieldFont);
		add(clanchatField);
		add(Box.createVerticalStrut(10)); // Padding between sections

		// Team Size Input Field
		add(new JLabel("<html>What is the team size?<br>Enter 99 if unlimited</html>"));
		teamSizeField = new JTextField(5);
		teamSizeField.setFont(textFieldFont);
		add(teamSizeField);
		add(Box.createVerticalStrut(10)); // Padding

		// Splits or Free for All Input Field
		add(new JLabel("Splits or free for all?"));
		splitsOrFFAField = new JTextField(10);
		splitsOrFFAField.setFont(textFieldFont);
		add(splitsOrFFAField);
		add(Box.createVerticalStrut(10)); // Padding between sections

		// World Input Field
		add(new JLabel("What world?"));
		worldField = new JTextField(5);
		worldField.setFont(textFieldFont);
		add(worldField);
		add(Box.createVerticalStrut(10)); // Padding between sections

		// Submit Button
		JButton submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.BOLD, 16)); // Larger font for button
		add(submitButton);

		submitButton.addActionListener(e -> handleSubmit());

		// Initially disable the submit button (until fields are filled)
		submitButton.setEnabled(false);

		// Add listeners to enable/disable submit button based on field input
		addDocumentListenerToField(bossField, submitButton);
		addDocumentListenerToField(clanchatField, submitButton);
		addDocumentListenerToField(teamSizeField, submitButton);
		addDocumentListenerToField(splitsOrFFAField, submitButton);
		addDocumentListenerToField(worldField, submitButton);
	}

	private void addDocumentListenerToField(JTextField field, JButton submitButton)
	{
		field.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
			public void insertUpdate(DocumentEvent e)
			{
				toggleSubmitButton(submitButton);
			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{
				toggleSubmitButton(submitButton);
			}

			@Override
			public void changedUpdate(DocumentEvent e)
			{
				toggleSubmitButton(submitButton);
			}
		});
	}

	private void toggleSubmitButton(JButton submitButton)
	{
		// Check if any field is empty and disable submit button
		boolean isAnyFieldEmpty = bossField.getText().isEmpty() || clanchatField.getText().isEmpty() ||
			teamSizeField.getText().isEmpty() || splitsOrFFAField.getText().isEmpty() ||
			worldField.getText().isEmpty();

		submitButton.setEnabled(!isAnyFieldEmpty);
	}

	private void handleSubmit()
	{
		// Ensure client is available and player is logged in
		if (client == null || client.getLocalPlayer() == null)
		{
			JOptionPane.showMessageDialog(this, "You need to be logged in to submit.");
			return;
		}

		long currentTime = System.currentTimeMillis();

		// Check if the user is within the rate limit
		if (currentTime - lastSubmitTime < RATE_LIMIT_TIME)
		{
			// If the user has submitted within the last 5 minutes, block the submission
			JOptionPane.showMessageDialog(this, "You can submit again after 5 minutes.");
			return; // Don't process the form
		}

		// Update the last submit time after passing the rate limit check
		lastSubmitTime = currentTime;

		String characterName = client.getLocalPlayer().getName();
		if (characterName == null || characterName.isEmpty())
		{
			log.error("Failed to retrieve player name.");
			return;
		}

		// Collect form input data
		String boss = bossField.getText();
		String clanchat = clanchatField.getText();
		String teamSize = teamSizeField.getText();
		String splitsOrFFA = splitsOrFFAField.getText();
		String world = worldField.getText();

		// Handle special case for team size (99 -> "unlimited")
		if ("99".equals(teamSize))
		{
			teamSize = "unlimited";
		}

		// Retrieve the role ID from config
		String roleId = config.roleId();

		// Create the JSON payload with the character name
		String jsonPayload = String.format(
			"{"
				+ "  \"content\": \"<@&%s>, %s is starting a group for %s!\","
				+ "  \"embeds\": [{"
				+ "    \"title\": \"LFG Request\","
				+ "    \"color\": 16776960,"
				+ "    \"fields\": ["
				+ "      {\"name\": \"Boss\", \"value\": \"%s\", \"inline\": false},"
				+ "      {\"name\": \"Clanchat\", \"value\": \"%s\", \"inline\": false},"
				+ "      {\"name\": \"Team Size\", \"value\": \"%s\", \"inline\": false},"
				+ "      {\"name\": \"Splits or Free for All\", \"value\": \"%s\", \"inline\": false},"
				+ "      {\"name\": \"World\", \"value\": \"%s\", \"inline\": false}"
				+ "    ]"
				+ "  }]"
				+ "}", roleId, characterName, boss, boss, clanchat, teamSize, splitsOrFFA, world
		);

		sendToDiscord(jsonPayload);
	}

	private void sendToDiscord(String jsonPayload)
	{
		String webhookUrl = config.webhookUrl();

		if (webhookUrl.isEmpty())
		{
			log.error("Webhook URL is not set.");
			return;
		}

		// Send the JSON payload to Discord via the existing sendWebhookRequest method
		sendWebhookRequest(webhookUrl, jsonPayload);
	}

	private void sendWebhookRequest(String webhookUrl, String payload)
	{
		try
		{
			// Create the URL and open a connection
			URL url = new URL(webhookUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set the request method to POST
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");

			// Send the JSON payload
			try (OutputStream os = connection.getOutputStream())
			{
				byte[] input = payload.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			// Get the response code (optional, but useful for debugging)
			int responseCode = connection.getResponseCode();
			log.info("POST request sent, response code: " + responseCode);

			// Close the connection
			connection.disconnect();
		}
		catch (IOException e)
		{
			log.error("Failed to send webhook request", e);
		}
	}
}

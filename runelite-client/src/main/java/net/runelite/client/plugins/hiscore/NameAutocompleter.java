/*
 * Copyright (c) 2018, John Pettenger
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
package net.runelite.client.plugins.hiscore;

import com.google.inject.Inject;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.Friend;
import net.runelite.api.Player;

@Slf4j
class NameAutocompleter implements KeyListener
{
	/**
	 * Non-breaking space character.
	 */
	private static final String NBSP = Character.toString((char)160);

	/**
	 * Character class for characters that cannot be in an RSN.
	 */
	private static final Pattern INVALID_CHARS = Pattern.compile("[^a-zA-Z0-9_ -]");

	private final Client client;

	/**
	 * The name currently being autocompleted.
	 */
	private String autocompleteName;

	/**
	 * Pattern for the name currently being autocompleted.
	 */
	private Pattern autocompleteNamePattern;

	@Inject
	private NameAutocompleter(@Nullable Client client)
	{
		this.client = client;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{

	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		final JTextComponent input = (JTextComponent)e.getSource();
		final String inputText = input.getText();

		// Only autocomplete if the selection end is at the end of the text.
		if (input.getSelectionEnd() != inputText.length())
		{
			return;
		}

		// Character to be inserted at the selection start.
		final String charToInsert = Character.toString(e.getKeyChar());

		// Don't attempt to autocomplete if the name is invalid.
		// This condition is also true when the user presses a key like backspace.
		if (INVALID_CHARS.matcher(charToInsert).find()
			|| INVALID_CHARS.matcher(inputText).find())
		{
			return;
		}

		// Check if we are already autocompleting.
		if (autocompleteName != null && autocompleteNamePattern.matcher(inputText).matches())
		{
			if (isExpectedNext(input, charToInsert))
			{
				try
				{
					// Insert the character and move the selection.
					final int insertIndex = input.getSelectionStart();
					Document doc = input.getDocument();
					doc.remove(insertIndex, 1);
					doc.insertString(insertIndex, charToInsert, null);
					input.select(insertIndex + 1, input.getSelectionEnd());
				}
				catch (BadLocationException ex)
				{
					log.warn("Could not insert character.", ex);
				}

				// Prevent default behavior.
				e.consume();
			}
			else // Character to insert does not match current autocompletion. Look for another name.
			{
				newAutocomplete(e);
			}
		}
		else // Search for a name to autocomplete
		{
			newAutocomplete(e);
		}
	}

	private void newAutocomplete(KeyEvent e)
	{
		final JTextComponent input = (JTextComponent)e.getSource();
		final String inputText = input.getText();
		final String nameStart = inputText.substring(0, input.getSelectionStart()) + e.getKeyChar();

		if (findAutocompleteName(nameStart))
		{
			// Assert this.autocompleteName != null
			final String name = this.autocompleteName;
			SwingUtilities.invokeLater(() ->
			{
				try
				{
					input.getDocument().insertString(
						nameStart.length(),
						name.substring(nameStart.length()),
						null);
					input.select(nameStart.length(), name.length());
				}
				catch (BadLocationException ex)
				{
					log.warn("Could not autocomplete name.", ex);
				}
			});
		}
	}

	private boolean findAutocompleteName(String nameStart)
	{
		final Pattern pattern;
		Optional<String> autocompleteName;

		// Pattern to match names that start with nameStart.
		// Allows spaces to be represented as common whitespaces, underscores,
		// hyphens, or non-breaking spaces.
		// Matching non-breaking spaces is necessary because the API
		// returns non-breaking spaces when a name has whitespace.
		pattern = Pattern.compile(
			"(?i)^" + nameStart.replaceAll("[ _-]", "[ _" + NBSP + "-]") + ".+?");

		if (client == null)
		{
			return false;
		}

		autocompleteName = Optional.empty();

		// TODO: Search lookup history

		Friend[] friends = client.getFriends();
		if (friends != null)
		{
			autocompleteName = Arrays.stream(friends)
				.filter(Objects::nonNull)
				.map(Friend::getName)
				.filter(n -> pattern.matcher(n).matches())
				.findFirst();
		}

		// Search clan if a friend wasn't found
		if (!autocompleteName.isPresent())
		{
			final ClanMember[] clannies = client.getClanMembers();
			if (clannies != null)
			{
				autocompleteName = Arrays.stream(clannies)
					.filter(Objects::nonNull)
					.map(ClanMember::getUsername)
					.filter(n -> pattern.matcher(n).matches())
					.findFirst();
			}
		}

		// Search cached players if a clannie wasn't found.
		if (!autocompleteName.isPresent())
		{
			final Player[] cachedPlayers = client.getCachedPlayers();
			autocompleteName = Arrays.stream(cachedPlayers)
				.filter(Objects::nonNull)
				.map(Player::getName)
				.filter(n -> pattern.matcher(n).matches())
				.findFirst();
		}

		if (autocompleteName.isPresent())
		{
			this.autocompleteName = autocompleteName.get().replace(NBSP, " ");
			this.autocompleteNamePattern = Pattern.compile(
				"(?i)^" + this.autocompleteName.replaceAll("[ _-]", "[ _-]") + "$");
		}
		else
		{
			this.autocompleteName = null;
			this.autocompleteNamePattern = null;
		}

		return autocompleteName.isPresent();
	}

	private boolean isExpectedNext(JTextComponent input, String nextChar)
	{
		String expected;
		if (input.getSelectionStart() < input.getSelectionEnd())
		{
			try
			{
				expected = input.getText(input.getSelectionStart(), 1);
			}
			catch (BadLocationException ex)
			{
				log.warn("Could not get first character from input selection.", ex);
				return false;
			}
		}
		else
		{
			expected = "";
		}
		return nextChar.equalsIgnoreCase(expected);
	}
}
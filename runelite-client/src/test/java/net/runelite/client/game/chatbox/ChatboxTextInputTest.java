/*
 * Copyright (c) 2025, Sam (sjstorment123@gmail.com)
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

package net.runelite.client.game.chatbox;

import com.google.inject.Guice;
import com.google.inject.testing.fieldbinder.Bind;
import com.google.inject.testing.fieldbinder.BoundFieldModule;
import java.awt.event.KeyEvent;
import java.util.stream.IntStream;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChatboxTextInputTest
{
	private static final char[] SPECIAL_CHARS =
	{
		'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '=',
		'{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', ',', '>', '.', '?', '/'
	};

	@Inject
	private ChatboxTextInput chatboxTextInput;

	@Mock
	@Bind
	private ChatboxPanelManager chatboxPanelManager;

	@Mock
	@Bind
	private Client client;

	@Mock
	@Bind
	private ClientThread clientThread;

	@Before
	public void before()
	{
		Guice.createInjector(BoundFieldModule.of(this)).injectMembers(this);
		when(chatboxPanelManager.shouldTakeInput()).thenReturn(true);
	}

	private KeyEvent mockKeyPressed(int keyCode, boolean ctrl, boolean shift)
	{
		KeyEvent e = mock(KeyEvent.class);
		when(e.getKeyCode()).thenReturn(keyCode);
		when(e.isControlDown()).thenReturn(ctrl);
		when(e.isShiftDown()).thenReturn(shift);
		return e;
	}

	private void type(String text)
	{
		for (char c : text.toCharArray())
		{
			KeyEvent e = mock(KeyEvent.class);
			when(e.getKeyChar()).thenReturn(c);
			chatboxTextInput.keyTyped(e);
		}
	}

	private void right(boolean ctrl, boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_RIGHT, ctrl, shift));
	}

	private void left(boolean ctrl, boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_LEFT, ctrl, shift));
	}

	private void up(boolean ctrl, boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_UP, ctrl, shift));
	}

	private void down(boolean ctrl, boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_DOWN, ctrl, shift));
	}

	private void backspace(boolean ctrl, boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_BACK_SPACE, ctrl, shift));
	}

	private void delete(boolean ctrl, boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_DELETE, ctrl, shift));
	}

	private void ctrlZ()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_Z, true, false));
	}

	private void ctrlY()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_Y, true, false));
	}

	private void ctrlA()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_A, true, false));
	}

	private void ctrlC()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_C, true, false));
	}

	private void ctrlV()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_V, true, false));
	}

	private void home(boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_HOME, false, shift));
	}

	private void end(boolean shift)
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_END, false, shift));
	}

	private void ctrlBackspace()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_BACK_SPACE, true, false));
	}

	private void ctrlDelete()
	{
		chatboxTextInput.keyPressed(mockKeyPressed(KeyEvent.VK_DELETE, true, false));
	}

	@Test
	public void testCtrlASelectsAllText()
	{
		var message = "B0aty 73 Whale";
		type(message);
		ctrlA();
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(message.length(), chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testBackSpace()
	{
		var message = "Hey there Delilah";
		type(message);

		// delete 1
		backspace(false, false);
		assertEquals("Hey there Delila", chatboxTextInput.getValue());

		// delete 1
		backspace(false, false);
		assertEquals("Hey there Delil", chatboxTextInput.getValue());

		// delete 5
		IntStream.range(0, 5).forEach(i -> backspace(false, false));
		assertEquals("Hey there ", chatboxTextInput.getValue());
	}

	@Test public void testCopyAndPaste()
	{
		var message = "B0aty 73 Whale";
		type(message);
		ctrlA();
		ctrlC();
		chatboxTextInput.cursorAt(message.length());
		ctrlV();
		assertEquals(message + message, chatboxTextInput.getValue());
	}

	@Test public void testCursorMovement()
	{
		var message = "Let's all go to the lobby";
		type(message);

		// cursor is at end after typing
		assertEquals(chatboxTextInput.getCursorStart(), chatboxTextInput.getCursorEnd());
		assertEquals(chatboxTextInput.getCursorStart(), message.length());

		// moving left into the value works
		IntStream.range(0, 5).forEach(i -> left(false, false));
		assertEquals(chatboxTextInput.getCursorStart(), chatboxTextInput.getCursorEnd());
		assertEquals(chatboxTextInput.getCursorStart(), message.length() - 5);

		// overshooting start stops at 0
		IntStream.range(0, message.length()).forEach(i -> left(false, false));
		assertEquals(chatboxTextInput.getCursorStart(), chatboxTextInput.getCursorEnd());
		assertEquals(chatboxTextInput.getCursorStart(), 0);

		// moving right into the value works
		IntStream.range(0, 5).forEach(i -> right(false, false));
		assertEquals(chatboxTextInput.getCursorStart(), chatboxTextInput.getCursorEnd());
		assertEquals(chatboxTextInput.getCursorStart(), 5);

		// overshooting end stops at value.length
		IntStream.range(0, message.length()).forEach(i -> right(false, false));
		assertEquals(chatboxTextInput.getCursorStart(), chatboxTextInput.getCursorEnd());
		assertEquals(chatboxTextInput.getCursorStart(), message.length());
	}

	@Test
	public void testDeleteForward()
	{
		var message = "Hey there Delilah";
		type(message);
		chatboxTextInput.cursorAt(0);

		delete(false, false);
		assertEquals("ey there Delilah", chatboxTextInput.getValue());

		delete(false, false);
		assertEquals("y there Delilah", chatboxTextInput.getValue());

		// delete at end does nothing
		chatboxTextInput.cursorAt(chatboxTextInput.getValue().length());
		delete(false, false);
		assertEquals("y there Delilah", chatboxTextInput.getValue());
	}

	@Test
	public void testFixTypo()
	{
		// Type a word with a missing letter, navigate back and insert it
		type("helo world");
		IntStream.range(0, 7).forEach(i -> left(false, false));
		// cursor is now between 'l' and 'o' in "helo"
		type("l");
		assertEquals("hello world", chatboxTextInput.getValue());
	}

	@Test
	public void testSelectAndReplace()
	{
		type("hello world");
		// shift+left 5 times selects "world"
		IntStream.range(0, 5).forEach(i -> left(false, true));
		assertEquals(6, chatboxTextInput.getCursorStart());
		assertEquals(11, chatboxTextInput.getCursorEnd());
		type("there");
		assertEquals("hello there", chatboxTextInput.getValue());
	}

	@Test
	public void testSelectAllAndRetype()
	{
		type("old message");
		ctrlA();
		type("new message");
		assertEquals("new message", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlBackspaceFixLastWord()
	{
		type("meet me at the liberry");
		ctrlBackspace();
		type("library");
		assertEquals("meet me at the library", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlDeleteClearsWordByWord()
	{
		type("one two three");
		chatboxTextInput.cursorAt(0);
		ctrlDelete();
		assertEquals("two three", chatboxTextInput.getValue());
		ctrlDelete();
		assertEquals("three", chatboxTextInput.getValue());
		ctrlDelete();
		assertEquals("", chatboxTextInput.getValue());
	}

	// --- Undo/Redo ---

	@Test
	public void testUndoTyping()
	{
		type("hello");
		ctrlZ();
		assertEquals("", chatboxTextInput.getValue());
	}

	@Test
	public void testRedoAfterUndo()
	{
		type("hello");
		ctrlZ();
		ctrlY();
		assertEquals("hello", chatboxTextInput.getValue());
	}

	@Test
	public void testConsecutiveTypingIsOneSingleUndoStep()
	{
		type("hello world what a lovely day");
		ctrlZ();
		assertEquals("", chatboxTextInput.getValue());
	}

	@Test
	public void testTypingAfterDeleteCreatesNewUndoGroup()
	{
		type("hello");
		backspace(false, false);
		type(" world");
		// "hell world"
		ctrlZ();
		assertEquals("hell", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("hello", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("", chatboxTextInput.getValue());
	}

	@Test
	public void testRedoIsInvalidatedByTyping()
	{
		type("hello");
		ctrlZ();
		type("world");
		ctrlY();
		// Redo should be gone after typing
		assertEquals("world", chatboxTextInput.getValue());
	}

	@Test
	public void testUndoRestoresCursorPosition()
	{
		type("hello");
		ctrlZ();
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(0, chatboxTextInput.getCursorEnd());
	}

	// --- Backspace/Delete batching ---

	@Test
	public void testConsecutiveBackspacesBatchedIntoOneUndoStep()
	{
		type("hello world");
		backspace(false, false);
		backspace(false, false);
		backspace(false, false);
		assertEquals("hello wo", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("hello world", chatboxTextInput.getValue());
	}

	@Test
	public void testConsecutiveDeletesBatchedIntoOneUndoStep()
	{
		type("hello world");
		chatboxTextInput.cursorAt(0);
		delete(false, false);
		delete(false, false);
		delete(false, false);
		assertEquals("lo world", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("hello world", chatboxTextInput.getValue());
	}

	@Test
	public void testMixedBackspaceAndDeleteBatchedTogether()
	{
		type("hello world");
		chatboxTextInput.cursorAt(6);
		backspace(false, false);
		delete(false, false);
		backspace(false, false);
		assertEquals("hellorld", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("hello world", chatboxTextInput.getValue());
	}

	@Test
	public void testSelectionDeleteBatchedWithSubsequentSingleCharDelete()
	{
		type("hello world");
		chatboxTextInput.cursorAt(6, 11);
		backspace(false, false);
		// "hello "
		backspace(false, false);
		// "hello"
		assertEquals("hello", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("hello world", chatboxTextInput.getValue());
	}

	// --- Ctrl+Backspace word deletion ---

	@Test
	public void testCtrlBackspaceDeletesWord()
	{
		type("hey how are you");
		ctrlBackspace();
		assertEquals("hey how are ", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlBackspaceWithLeadingSpacesBeforeWord()
	{
		type("hey how are   you");
		ctrlBackspace();
		assertEquals("hey how are   ", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlBackspaceUnderscoreIsWordChar()
	{
		type("hey how are_you");
		ctrlBackspace();
		assertEquals("hey how ", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlBackspaceStopsAtSpecialChar()
	{
		for (char special : SPECIAL_CHARS)
		{
			chatboxTextInput.value("hey how are" + special + "you");
			ctrlBackspace();
			assertEquals("special=" + special, "hey how are" + special, chatboxTextInput.getValue());
		}
	}

	@Test
	public void testCtrlBackspaceFromTrailingSpaceConsumesSpaceThenWord()
	{
		type("hey how are ");
		ctrlBackspace();
		assertEquals("hey how ", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlBackspaceFromTrailingSpecialCharConsumesItThenWord()
	{
		for (char special : SPECIAL_CHARS)
		{
			chatboxTextInput.value("hey how are" + special);
			ctrlBackspace();
			assertEquals("special=" + special, "hey how ", chatboxTextInput.getValue());
		}
	}

	@Test
	public void testConsecutiveCtrlBackspacesBatchedIntoOneUndoStep()
	{
		type("hey how are you");
		ctrlBackspace();
		ctrlBackspace();
		assertEquals("hey how ", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("hey how are you", chatboxTextInput.getValue());
	}

	// --- Ctrl+Delete word deletion ---

	@Test
	public void testCtrlDeleteFromStartOfWord()
	{
		type("how are you");
		chatboxTextInput.cursorAt(0);
		ctrlDelete();
		assertEquals("are you", chatboxTextInput.getValue());
	}

	@Test
	public void testCtrlDeleteConsumesTrailingBoundaryChar()
	{
		for (char special : SPECIAL_CHARS)
		{
			chatboxTextInput.value("how" + special + "are" + special + "you");
			chatboxTextInput.cursorAt(0);
			ctrlDelete();
			assertEquals("special=" + special, "are" + special + "you", chatboxTextInput.getValue());
		}
	}

	@Test
	public void testCtrlDeleteFromLeadingSpacesConsumesOnlySpaces()
	{
		type("   how-are-you");
		chatboxTextInput.cursorAt(0);
		ctrlDelete();
		assertEquals("how-are-you", chatboxTextInput.getValue());
	}

	@Test
	public void testConsecutiveCtrlDeletesBatchedIntoOneUndoStep()
	{
		type("how are you");
		chatboxTextInput.cursorAt(0);
		ctrlDelete();
		ctrlDelete();
		assertEquals("you", chatboxTextInput.getValue());
		ctrlZ();
		assertEquals("how are you", chatboxTextInput.getValue());
	}

	// --- Ctrl+Left/Right word navigation ---

	@Test
	public void testCtrlRightMovesToEndOfWordIncludingTrailingBoundary()
	{
		type("hello world");
		chatboxTextInput.cursorAt(0);
		right(true, false);
		assertEquals(6, chatboxTextInput.getCursorStart());
	}

	@Test
	public void testCtrlRightFromNonWordCharSkipsToStartOfNextWord()
	{
		type("hello world");
		chatboxTextInput.cursorAt(5);
		right(true, false);
		assertEquals(6, chatboxTextInput.getCursorStart());
	}

	@Test
	public void testCtrlLeftMovesToStartOfWord()
	{
		type("hello world");
		// cursor starts at end (11)
		left(true, false);
		assertEquals(6, chatboxTextInput.getCursorStart());
	}

	@Test
	public void testCtrlLeftFromSpaceSkipsSpaceThenWord()
	{
		type("hello world");
		chatboxTextInput.cursorAt(6);
		left(true, false);
		assertEquals(0, chatboxTextInput.getCursorStart());
	}

	@Test
	public void testCtrlShiftRightExtendsSelection()
	{
		type("hello world");
		chatboxTextInput.cursorAt(0);
		right(true, true);
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(6, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testCtrlShiftLeftExtendsSelection()
	{
		type("hello world");
		// cursor at end (11)
		left(true, true);
		assertEquals(6, chatboxTextInput.getCursorStart());
		assertEquals(11, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testHomeMovesToStart()
	{
		// cursor somewhere in the middle, Home snaps to position 0
		type("What a day to be alive");
		chatboxTextInput.cursorAt(10);
		home(false);
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(0, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testEndMovesToEnd()
	{
		// cursor at the start, End snaps to the last character
		var message = "What a day to be alive";
		type(message);
		chatboxTextInput.cursorAt(0);
		end(false);
		assertEquals(message.length(), chatboxTextInput.getCursorStart());
		assertEquals(message.length(), chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testUpMovesToStart()
	{
		// no multi-line widget in tests, so Up behaves like Home
		type("What a day to be alive");
		chatboxTextInput.cursorAt(10);
		up(false, false);
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(0, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testDownMovesToEnd()
	{
		// no multi-line widget in tests, so Down behaves like End
		var message = "What a day to be alive";
		type(message);
		chatboxTextInput.cursorAt(0);
		down(false, false);
		assertEquals(message.length(), chatboxTextInput.getCursorStart());
		assertEquals(message.length(), chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testShiftHomeSelectsToStart()
	{
		// cursor mid-word, Shift+Home selects everything to the left
		type("Zezima was here");
		chatboxTextInput.cursorAt(6);
		home(true);
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(6, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testShiftEndSelectsToEnd()
	{
		// cursor mid-sentence, Shift+End selects everything to the right
		var message = "Zezima was here";
		type(message);
		chatboxTextInput.cursorAt(7);
		end(true);
		assertEquals(7, chatboxTextInput.getCursorStart());
		assertEquals(message.length(), chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testShiftUpSelectsToStart()
	{
		// Shift+Up with no multi-line widget selects from cursor to position 0
		type("Zezima was here");
		chatboxTextInput.cursorAt(6);
		up(false, true);
		assertEquals(0, chatboxTextInput.getCursorStart());
		assertEquals(6, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testShiftDownSelectsToEnd()
	{
		// Shift+Down with no multi-line widget selects from cursor to the end
		var message = "Zezima was here";
		type(message);
		chatboxTextInput.cursorAt(7);
		down(false, true);
		assertEquals(7, chatboxTextInput.getCursorStart());
		assertEquals(message.length(), chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testShiftRightExtendsSelectionCharByChar()
	{
		// holding Shift while pressing Right selects one character at a time
		type("GE bank");
		chatboxTextInput.cursorAt(3);
		right(false, true);
		assertEquals(3, chatboxTextInput.getCursorStart());
		assertEquals(4, chatboxTextInput.getCursorEnd());
		right(false, true);
		assertEquals(3, chatboxTextInput.getCursorStart());
		assertEquals(5, chatboxTextInput.getCursorEnd());
	}

	@Test
	public void testShiftLeftExtendsSelectionCharByChar()
	{
		// holding Shift while pressing Left selects one character at a time going backward
		type("GE bank");
		chatboxTextInput.cursorAt(5);
		left(false, true);
		assertEquals(4, chatboxTextInput.getCursorStart());
		assertEquals(5, chatboxTextInput.getCursorEnd());
		left(false, true);
		assertEquals(3, chatboxTextInput.getCursorStart());
		assertEquals(5, chatboxTextInput.getCursorEnd());
	}
}

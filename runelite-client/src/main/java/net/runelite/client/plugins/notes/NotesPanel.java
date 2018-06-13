/*
 * Copyright (c) 2018 Charlie Waters
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.plugins.notes;

import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

@Slf4j
public class NotesPanel extends PluginPanel
{
	private static final String UNDO = "Undo";
	private static final String REDO = "Redo";
	private static final int MODIFIER_KEY = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

	private final JTextArea notesEditor = new JTextArea();
	private final UndoManager undoManager = new UndoManager();

	void init(NotesConfig config)
	{
		// This may or may not qualify as a hack
		// but this lets the editor pane expand to fill the whole parent panel
		getParent().setLayout(new BorderLayout());
		getParent().add(this, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		final JLabel notesHeader = new JLabel("Notes");
		notesHeader.setForeground(Color.WHITE);
		notesHeader.setBorder(new EmptyBorder(1, 0, 10, 0));

		add(notesHeader, BorderLayout.NORTH);

		notesEditor.setLineWrap(true);
		notesEditor.setWrapStyleWord(true);

		final JPanel notesContainer = new JPanel();
		notesContainer.setLayout(new BorderLayout());
		notesContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		notesEditor.setOpaque(false);

		// Load note text
		final String data = config.notesData();
		notesEditor.setText(data);

		// Enable undo listener
		undoManager.setLimit(300); // Triple the default history limit
		notesEditor.getDocument().addUndoableEditListener(undoManager);

		// Set hotkeys to respond to
		final InputMap inputs = notesEditor.getInputMap();
		inputs.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, MODIFIER_KEY), UNDO); // Ctrl+Z (or Cmd+Z)
		inputs.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, MODIFIER_KEY), REDO); // Ctrl+Y (or Cmd+Y)

		// Set hotkey actions
		final ActionMap actions = notesEditor.getActionMap();
		actions.put(UNDO, new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (undoManager.canUndo())
				{
					undoManager.undo();
				}
			}
		});
		actions.put(REDO, new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (undoManager.canRedo())
				{
					undoManager.redo();
				}
			}
		});

		// Save notes whenever they lose keyboard focus
		notesEditor.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				notesChanged(notesEditor.getDocument());
			}

			private void notesChanged(Document doc)
			{
				try
				{
					// Get document text and save to config whenever editor is changed
					final String data = doc.getText(0, doc.getLength());
					config.notesData(data);
				}
				catch (BadLocationException ex)
				{
					log.warn("Notes Document Bad Location: " + ex);
				}
			}
		});
		notesContainer.add(notesEditor, BorderLayout.CENTER);
		notesContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

		add(notesContainer, BorderLayout.CENTER);
	}

	void setNotes(String data)
	{
		notesEditor.setText(data);
	}
}

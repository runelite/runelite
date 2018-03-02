/*
 * Copyright (c) 2018 Charlie Waters
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

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.PluginPanel;

import java.awt.BorderLayout;

@Slf4j
public class NotesPanel extends PluginPanel
{
	private final JEditorPane notesEditor = new JEditorPane();

	void init(NotesConfig config)
	{
		// this may or may not qualify as a hack
		// but this lets the editor pane expand to fill the whole parent panel
		getParent().setLayout(new BorderLayout());
		getParent().add(this, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(2, 6, 6, 6));

		final JLabel notesHeader = new JLabel("Notes");
		add(notesHeader, BorderLayout.NORTH);

		notesEditor.setContentType("text/plain");

		if (config.persistNotes())
		{
			// load note text
			String data = unEscapeNote(config.notesData());
			notesEditor.setText(data);

			notesEditor.getDocument().addDocumentListener(new DocumentListener()
			{
				@Override
				public void insertUpdate(DocumentEvent e)
				{
					notesChanged(e.getDocument());
				}

				@Override
				public void removeUpdate(DocumentEvent e)
				{
					notesChanged(e.getDocument());
				}

				@Override
				public void changedUpdate(DocumentEvent e)
				{
					notesChanged(e.getDocument());
				}

				private void notesChanged(Document doc)
				{
					try
					{
						// get document text and save to config whenever editor is changed
						String data = escapeNote(doc.getText(0, doc.getLength()));
						log.debug("Save Notes: " + data.length());
						config.notesData(data);
					}
					catch (BadLocationException ex)
					{
						log.warn("Notes Document Bad Location: " + ex);
					}
				}
			});
		}
		add(notesEditor, BorderLayout.CENTER);
	}

	private String escapeNote(String s)
	{
		return s.replaceAll("\n", "\\\n");
	}

	private String unEscapeNote(String s)
	{
		return s.replaceAll("\\\n", "\n");
	}
}

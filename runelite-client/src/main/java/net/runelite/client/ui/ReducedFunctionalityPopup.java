/*
 * Copyright (c) 2018, Sam "Berry" Beresford <seb1g13@soton.ac.uk>
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
package net.runelite.client.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ReducedFunctionalityPopup
{
	private JDialog dialog;

	public void init() throws Exception
	{

		SwingUtilities.invokeAndWait(() ->
			{
				dialog = new JDialog();
				dialog.setTitle("Reduced Functionality Mode");
				dialog.setModal(true);
				dialog.setAlwaysOnTop(true);
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

				dialog.setLayout(new BorderLayout());
				dialog.getContentPane().setBackground(Color.GRAY);
		});
	}

	public void show() throws Exception
	{
		SwingUtilities.invokeAndWait(() ->
			{
				JTextArea text = new JTextArea("RuneLite has not yet been updated for use with the \n" +
								"latest OSRS update.\n" +
								"As a result RuneLite is running in reduced functionality mode.\n" +
								"A new version of RuneLite for use with the new game update \n" +
								"should be available shortly.\n" +
								"\nThank you for your patience."
				);
				text.setBorder(BorderFactory.createCompoundBorder(
						new LineBorder(Color.DARK_GRAY, 1, true),
						new EmptyBorder(15, 15, 15, 15)
				));
				text.setEditable(false);


				JPanel textPanel = new JPanel();
				textPanel.setBorder(new EmptyBorder(15, 15, 0, 15));
				textPanel.add(text);



		JLabel icon = new JLabel(javax.swing.UIManager.getIcon("OptionPane.errorIcon"));


			JPanel iconPanel = new JPanel();
			iconPanel.setBorder(new EmptyBorder(30, 25, 0, 0));
			iconPanel.add(icon);

				JButton okButton = new JButton("Ok");
				okButton.setFont(FontManager.getRunescapeBoldFont());
				okButton.addActionListener(e -> dialog.setVisible(false));
				okButton.setBorder(new EmptyBorder(8, 35, 8, 35));

				JPanel buttonPanel = new JPanel();
				buttonPanel.setBorder(new EmptyBorder(0, 0, 15, 0));
				buttonPanel.add(okButton);

				dialog.getRootPane().setDefaultButton(okButton);

				dialog.add(iconPanel, BorderLayout.WEST);
				dialog.add(textPanel, BorderLayout.CENTER);
				dialog.add(buttonPanel, BorderLayout.SOUTH);

				dialog.pack();
				dialog.setLocationRelativeTo(null);
				dialog.setResizable(false);
				dialog.setVisible(true);
				dialog.requestFocus();
			});
	}
}

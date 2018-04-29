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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReducedFunctionalityPopup extends JDialog
{
	public ReducedFunctionalityPopup()
	{
		this.setTitle("Reduced Functionality Mode");
		this.setModal(true);
		this.setAlwaysOnTop(true);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.DARK_GRAY);

		JLabel text = new JLabel("<html><p color='white'>" +
			"RuneLite has not yet been updated for use with the <br>" +
			"latest OSRS update.<br>" +
			"As a result RuneLite is running in reduced functionality mode.<br>" +
			"A new version of RuneLite for use with the new game update <br>" +
			"should be available shortly.<br>" +
			"<br>Thank you for your patience." +
			"</p></html>");
		text.setBorder(new EmptyBorder(15, 15, 0, 15));

		JLabel icon = new JLabel(javax.swing.UIManager.getIcon("OptionPane.informationIcon"));
		icon.setBorder(new EmptyBorder(10, 25, 50, 25));

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(e -> this.setVisible(false));
		okButton.setBorder(new EmptyBorder(8, 35, 8, 35));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.setBorder(new EmptyBorder(15, 0, 15, 0));
		buttonPanel.add(okButton);

		this.getRootPane().setDefaultButton(okButton);

		this.add(icon, BorderLayout.WEST);
		this.add(text, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setVisible(true);
	}
}

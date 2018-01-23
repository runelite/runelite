/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.Widget;

@Slf4j
public class WidgetEditPanel extends JPanel
{
	private Widget widget;

	private JLabel nameLbl = new JLabel();
	private JLabel textLbl = new JLabel();
	private JLabel typeLbl = new JLabel();
	private JLabel contentTypeLbl = new JLabel();
	private JLabel textColorLbl = new JLabel();
	private JLabel hiddenLbl = new JLabel();
	private JLabel spriteLbl = new JLabel();
	private JLabel relativeXLbl = new JLabel();
	private JLabel relativeYLbl = new JLabel();
	private JLabel widthLbl = new JLabel();
	private JLabel heightLbl = new JLabel();

	private JTextField nameTF = new JTextField();
	private JTextField textTF = new JTextField();
	private NumberField typeTF = new NumberField();
	private NumberField contentTypeTF = new NumberField();
	private NumberField textColorTF = new NumberField();
	private JCheckBox hiddenCB = new JCheckBox();
	private NumberField spriteTF = new NumberField();
	private NumberField relativeXTF = new NumberField();
	private NumberField relativeYTF = new NumberField();
	private NumberField widthTF = new NumberField();
	private NumberField heightTF = new NumberField();

	private JButton cancelBtn = new JButton();
	private JButton applyBtn = new JButton();

	private final DevToolsPanel owner;

	public WidgetEditPanel(DevToolsPanel panel, Widget w)
	{
		this.owner = panel;
		this.widget = w;

		init();
	}

	private void init()
	{
		createInputElements();

		this.setLayout(new GridBagLayout());

		errorCheck();
		createInterfaceElements();
		setupInterface();
	}

	private void errorCheck()
	{
		if (widget == null)
		{
			JLabel errorLabel = new JLabel("Widget could not be loaded!");
			errorLabel.setForeground(Color.RED);
			this.add(errorLabel);
		}
	}

	public void setWidget(Widget w)
	{
		this.removeAll();
		this.widget = w;
		init();

	}

	private void createInputElements()
	{
		if (widget == null)
			return;

		nameTF = new JTextField(widget.getName());
		textTF = new JTextField(widget.getText());
		typeTF = new NumberField(widget.getType());
		contentTypeTF = new NumberField(widget.getContentType());
		textColorTF = new NumberField(widget.getTextColor());
		hiddenCB = new JCheckBox();
		spriteTF = new NumberField(widget.getSpriteId());
		relativeXTF = new NumberField(widget.getRelativeX());
		relativeYTF = new NumberField(widget.getRelativeY());
		widthTF = new NumberField(widget.getWidth());
		heightTF = new NumberField(widget.getHeight());

		hiddenCB.setSelected(widget.isHidden());
	}

	private void createInterfaceElements()
	{
		nameLbl = new JLabel("Name");
		textLbl = new JLabel("Text");
		typeLbl = new JLabel("Type");
		contentTypeLbl = new JLabel("Content type");
		textColorLbl = new JLabel(String.valueOf("Text color"));
		hiddenLbl = new JLabel("Hidden");
		spriteLbl = new JLabel("Sprite");
		relativeXLbl = new JLabel("Relative X");
		relativeYLbl = new JLabel("Relative Y");
		widthLbl = new JLabel("Width");
		heightLbl = new JLabel("Height");

		cancelBtn = new JButton("Cancel");
		applyBtn = new JButton("Apply");

		this.cancelBtn.addActionListener(e ->
		{
			owner.cancelEdit();
		});

		this.applyBtn.addActionListener(e ->
		{
			applyChanges();
		});
	}

	/**
	 * only change when actual change happened to prevent sending too many change events
	 */
	private void applyChanges()
	{
		boolean hidden = hiddenCB.isSelected();
		String name = nameTF.getText();
		String text = textTF.getText();
		int type = typeTF.getNumber();
		int contentType = contentTypeTF.getNumber();
		int textColor = textColorTF.getNumber();
		int sprite = spriteTF.getNumber();
		int relativeX = relativeXTF.getNumber();
		int relativeY = relativeYTF.getNumber();
		int width = widthTF.getNumber();
		int height = heightTF.getNumber();

		if (hidden != widget.isHidden())
			widget.setHidden(hidden);

		if (!name.equals(widget.getName()))
			widget.setName(name);

		if (!text.equals(widget.getText()))
			widget.setText(text);

		if (type != widget.getType())
			widget.setType(type);

		if (contentType != widget.getContentType())
			widget.setContentType(contentType);

		if (textColor != widget.getTextColor())
			widget.setTextColor(textColor);

		if (sprite != widget.getSpriteId())
			widget.setSpriteId(sprite);

		if (relativeX != widget.getRelativeX())
			widget.setRelativeX(relativeX);

		if (relativeY != widget.getRelativeY())
			widget.setRelativeY(relativeY);

		if (width != widget.getWidth())
			widget.setWidth(width);

		if (height != widget.getHeight())
			widget.setHeight(height);
	}

	private void setupInterface()
	{
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0.5;

		constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.add(nameLbl, constraints);

		constraints.gridx = 1;
		this.add(nameTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		this.add(textLbl, constraints);
		constraints.gridx = 1;
		this.add(textTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		this.add(typeLbl, constraints);
		constraints.gridx = 1;
		this.add(typeTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		this.add(contentTypeLbl, constraints);
		constraints.gridx = 1;
		this.add(contentTypeTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		this.add(textColorLbl, constraints);
		constraints.gridx = 1;
		this.add(textColorTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 7;
		this.add(hiddenLbl, constraints);
		constraints.gridx = 1;
		this.add(hiddenCB, constraints);

		constraints.gridx = 0;
		constraints.gridy = 8;
		this.add(spriteLbl, constraints);
		constraints.gridx = 1;
		this.add(spriteTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 9;
		this.add(relativeXLbl, constraints);
		constraints.gridx = 1;
		this.add(relativeXTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 10;
		this.add(relativeYLbl, constraints);
		constraints.gridx = 1;
		this.add(relativeYTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 11;
		this.add(widthLbl, constraints);
		constraints.gridx = 1;
		this.add(widthTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 12;
		this.add(heightLbl, constraints);
		constraints.gridx = 1;
		this.add(heightTF, constraints);

		constraints.gridx = 0;
		constraints.gridy = 13;
		this.add(cancelBtn, constraints);

		constraints.gridx = 1;
		this.add(applyBtn, constraints);
	}
}

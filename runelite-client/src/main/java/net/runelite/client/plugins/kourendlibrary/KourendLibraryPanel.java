/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018 Psikoi
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
package net.runelite.client.plugins.kourendlibrary;

import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.SwingUtil;

@Singleton
public class KourendLibraryPanel extends PluginPanel
{
	private static final ImageIcon RESET_ICON;
	private static final ImageIcon RESET_CLICK_ICON;

	@Inject
	private Library library;

	private final HashMap<Book, BookPanel> bookPanels = new HashMap<>();

	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				BufferedImage resetIcon = ImageIO.read(KourendLibraryPanel.class.getResourceAsStream("reset.png"));
				RESET_ICON = new ImageIcon(resetIcon);
				RESET_CLICK_ICON = new ImageIcon(SwingUtil.grayscaleOffset(resetIcon, -100));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	void init()
	{
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		JPanel books = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		Stream.of(Book.values())
			.filter(b -> !b.isDarkManuscript())
			.sorted(Comparator.comparing(Book::getShortName))
			.forEach(b ->
			{
				BookPanel p = new BookPanel(b);
				bookPanels.put(b, p);
				books.add(p, c);
				c.gridy++;
			});

		JLabel reset = new JLabel(RESET_ICON);
		reset.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				reset.setIcon(RESET_CLICK_ICON);
				library.reset();
				update();
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent)
			{
				reset.setIcon(RESET_ICON);
			}
		});

		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());
		header.setBorder(new CompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(58, 58, 58)),
			BorderFactory.createEmptyBorder(0, 0, 10, 0)));

		JLabel pluginName = new JLabel("Kourend Library Plugin");
		pluginName.setForeground(Color.WHITE);

		header.add(reset, BorderLayout.EAST);
		header.add(pluginName, BorderLayout.CENTER);

		layout.setHorizontalGroup(layout.createParallelGroup()
			.addComponent(books)
			.addComponent(header)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(header)
			.addGap(10)
			.addComponent(books)
		);

		update();
	}

	void update()
	{
		SwingUtilities.invokeLater(() ->
		{
			Book customerBook = library.getCustomerBook();
			for (Map.Entry<Book, BookPanel> b : bookPanels.entrySet())
			{
				b.getValue().setIsTarget(customerBook == b.getKey());
			}

			HashMap<Book, HashSet<String>> bookLocations = new HashMap<>();

			for (Bookcase bookcase : library.getBookcases())
			{
				if (bookcase.getBook() != null)
				{
					bookLocations.computeIfAbsent(bookcase.getBook(), a -> new HashSet<>()).add(bookcase.getLocationString());
				}
				else
				{
					for (Book book : bookcase.getPossibleBooks())
					{
						if (book != null)
						{
							bookLocations.computeIfAbsent(book, a -> new HashSet<>()).add(bookcase.getLocationString());
						}
					}
				}
			}

			for (Map.Entry<Book, BookPanel> e : bookPanels.entrySet())
			{
				HashSet<String> locs = bookLocations.get(e.getKey());
				if (locs == null || locs.size() > 3)
				{
					e.getValue().setLocation("Unknown");
				}
				else
				{
					e.getValue().setLocation("<html>" + locs.stream().collect(Collectors.joining("<br>")) + "</html>");
				}
			}
		});
	}
}
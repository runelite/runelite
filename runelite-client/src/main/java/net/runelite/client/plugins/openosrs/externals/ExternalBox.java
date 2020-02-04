package net.runelite.client.plugins.openosrs.externals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import org.pf4j.update.PluginInfo;

public class ExternalBox extends JPanel
{
	private static final Font normalFont = FontManager.getRunescapeFont();
	private static final Font smallFont = FontManager.getRunescapeSmallFont();

	PluginInfo pluginInfo;
	JLabel install = new JLabel();
	JMultilineLabel description = new JMultilineLabel();

	ExternalBox(String name, URL url)
	{
		this(name, url.toString().replace("https://raw.githubusercontent.com/", "").replace("/master/", ""));
	}

	ExternalBox(PluginInfo pluginInfo)
	{
		this(pluginInfo.name, pluginInfo.description);
	}

	ExternalBox(String name, String desc)
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARKER_GRAY_COLOR);

		JPanel titleWrapper = new JPanel(new BorderLayout());
		titleWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		titleWrapper.setBorder(new CompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARK_GRAY_COLOR),
			BorderFactory.createLineBorder(ColorScheme.DARKER_GRAY_COLOR)
		));

		JLabel title = new JLabel();
		title.setText(name);
		title.setFont(normalFont);
		title.setBorder(null);
		title.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		title.setPreferredSize(new Dimension(0, 24));
		title.setForeground(Color.WHITE);
		title.setBorder(new EmptyBorder(0, 8, 0, 0));

		JPanel titleActions = new JPanel(new BorderLayout(3, 0));
		titleActions.setBorder(new EmptyBorder(0, 0, 0, 8));
		titleActions.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		titleActions.add(install, BorderLayout.EAST);

		titleWrapper.add(title, BorderLayout.CENTER);
		titleWrapper.add(titleActions, BorderLayout.EAST);

		description.setText(desc);
		description.setFont(smallFont);
		description.setDisabledTextColor(Color.WHITE);
		description.setBackground(ColorScheme.DARKER_GRAY_COLOR);

		add(titleWrapper, BorderLayout.NORTH);
		add(description, BorderLayout.CENTER);
	}

	public static class JMultilineLabel extends JTextArea
	{
		private static final long serialVersionUID = 1L;

		public JMultilineLabel()
		{
			super();
			setEditable(false);
			setCursor(null);
			setOpaque(false);
			setFocusable(false);
			setWrapStyleWord(true);
			setLineWrap(true);
			setBorder(new EmptyBorder(0, 8, 0, 8));
			setAlignmentY(JLabel.CENTER_ALIGNMENT);

			DefaultCaret caret = (DefaultCaret) getCaret();
			caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		}
	}
}

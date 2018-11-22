package net.runelite.client.plugins.bosslog;

import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bosslog.enums.Tab;
import net.runelite.client.plugins.config.ConfigPanel;
import net.runelite.client.plugins.timetracking.TimeTrackingPlugin;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.util.Locale;

public class BossLogDropPanel extends BossLogPanelView
{
	private JPanel uniqueContainer = new JPanel();
	private JPanel logContainer = new JPanel();
	private JPanel navbar = new JPanel();

	private JLabel logLabelGP;
	private JLabel logLabelKC;

	private final BufferedImage backIcon = ImageUtil.getResourceStreamFromClass(ConfigPanel.class, "config_back_icon.png");
	private final BufferedImage resetIcon = ImageUtil.getResourceStreamFromClass(TimeTrackingPlugin.class, "reset_icon.png");

	final Boss panelBoss;
	private final BossLogPanel bossLogPanel;

	private ItemManager itemManager;

	private final Client client;

	BossLogDropPanel(final ItemManager itemManager, Boss boss, final Client client, BossLogPanel bossLogPanel)
	{
		this.client = client;
		panelBoss = boss;
		this.itemManager = itemManager;
		this.bossLogPanel = bossLogPanel;

		setLayout(new DynamicGridLayout(0, 1, 0, 5));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(5, 0, 5, 6));

		//back button
		navbar.setLayout(new DynamicGridLayout(1, 3, 0 , 0));
		navbar.setBorder(new EmptyBorder(0, 5, 5, 0));
		add(navbar);
		addBack();

		//uniques
		JPanel uniqueMainContainer = new JPanel();
		uniqueMainContainer.setLayout(new BorderLayout(0, 2));
		add(uniqueMainContainer);

		JPanel uniqueTextContainer = new JPanel();
		uniqueTextContainer.setBorder(new EmptyBorder(4, 4, 4, 4));
		uniqueTextContainer.setBackground(new Color(24, 24, 24));
		uniqueTextContainer.setLayout(new BorderLayout());

		JLabel uniqueLabel = new JLabel();
		uniqueLabel.setForeground(Color.WHITE);
		uniqueLabel.setFont(FontManager.getRunescapeFont());
		uniqueLabel.setText("Uniques");
		uniqueTextContainer.add(uniqueLabel, BorderLayout.WEST);
		uniqueMainContainer.add(uniqueTextContainer, BorderLayout.NORTH);

		uniqueContainer.setLayout(new GridLayout(0, 5, 1, 1));

		uniqueMainContainer.add(uniqueContainer, BorderLayout.CENTER);

		//regular drops
		JPanel logMainContainer = new JPanel();
		logMainContainer.setLayout(new BorderLayout(0, 2));
		add(logMainContainer);

		JPanel logTextContainer = new JPanel();
		logTextContainer.setLayout(new BorderLayout());
		logTextContainer.setBorder(new EmptyBorder(4, 4, 4, 4));
		logTextContainer.setBackground(new Color(24, 24, 24));
		logMainContainer.add(logTextContainer, BorderLayout.NORTH);

		JLabel logLabel = new JLabel();
		logLabel.setForeground(Color.WHITE);
		logLabel.setFont(FontManager.getRunescapeFont());
		logLabel.setText("Drop Log");
		logTextContainer.add(logLabel, BorderLayout.WEST);

		logLabelKC = new JLabel();
		logLabelKC.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logLabelKC.setFont(FontManager.getRunescapeSmallFont());
		logLabelKC.setText("  (" + boss.getKC() + " KC)");
		logTextContainer.add(logLabelKC, BorderLayout.CENTER);

		logLabelGP = new JLabel();
		logLabelGP.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		logLabelGP.setFont(FontManager.getRunescapeSmallFont());
		logLabelGP.setText("0 gp");
		logTextContainer.add(logLabelGP, BorderLayout.EAST);

		logContainer.setLayout(new GridLayout(0, 5, 1, 1));
		logContainer.setBorder(new EmptyBorder(0, 0, 0, 0));
		logMainContainer.add(logContainer, BorderLayout.CENTER);
	}

	@Override
	public void update()
	{
		logLabelGP.setText(NumberFormat.getNumberInstance(Locale.US).format(panelBoss.getProfit()) + " gp");
		logLabelKC.setText("  (" + panelBoss.getKC() + " KC)");
		drawSlots();
	}

	void drawSlots()
	{
		//draw unique drops
		uniqueContainer.removeAll();
		for (int id : panelBoss.getBoss().getUniques())
		{
			boolean added = false;
			for (BossLogItem i : panelBoss.getDrops())
			{
				if (id == i.getId())
				{
					uniqueContainer.add(new BossLogDropBox(itemManager, i, false));
					added = true;
					break;
				}
			}
			if (!added)
			{
				ItemComposition ic = itemManager.getItemComposition(id);
				uniqueContainer.add(new BossLogDropBox(itemManager, new BossLogItem(id, 0, ic.getName(), 0), true));
			}
		}

		//draw regular drops
		logContainer.removeAll();
		int rows = ( client.getCanvasHeight() - 208) / 42; //trim top, calculate rows (will truncate = good)
		int cr = 0;
		for (BossLogItem i : panelBoss.getDrops())
		{
			if (cr / 5 == rows) break;
			BossLogDropBox slot = new BossLogDropBox(itemManager, i, false);
			logContainer.add(slot);
			cr++;
		}
	}

	private void addBack()
	{
		ImageIcon BACK_ICON = new ImageIcon(backIcon);
		ImageIcon BACK_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(backIcon, -100));

		JPanel contBB = new JPanel();
		contBB.setLayout(new BorderLayout());
		navbar.add(contBB, BorderLayout.WEST);

		JLabel back_button = new JLabel(BACK_ICON);
		contBB.add(back_button, BorderLayout.WEST);

		back_button.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				back_button.setIcon(BACK_ICON);
				bossLogPanel.switchTab(Tab.OVERVIEW);
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				back_button.setIcon(BACK_ICON_HOVER);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				back_button.setIcon(BACK_ICON);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		JPanel contBL = new JPanel();
		contBL.setLayout(new BorderLayout());
		contBL.setBorder(new EmptyBorder(4, 0, 0, 0));
		navbar.add(contBL, BorderLayout.CENTER);

		JLabel bossLabel = new JLabel(panelBoss.getBoss().getName());
		bossLabel.setHorizontalAlignment(JLabel.CENTER);
		bossLabel.setVerticalAlignment(JLabel.CENTER);
		bossLabel.setForeground(Color.WHITE);
		bossLabel.setFont(FontManager.getRunescapeBoldFont());
		contBL.add(bossLabel, BorderLayout.CENTER);

		JPanel resetContainer = new JPanel();
		resetContainer.setLayout(new BorderLayout());
		navbar.add(resetContainer);

		ImageIcon RESET_ICON = new ImageIcon(resetIcon);
		ImageIcon RESET_ICON_HOVER = new ImageIcon(ImageUtil.alphaOffset(resetIcon, -100));
		JLabel reset_button = new JLabel(RESET_ICON);
		reset_button.setToolTipText("Reset Log");
		resetContainer.add(reset_button, BorderLayout.EAST);

		reset_button.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				reset_button.setIcon(RESET_ICON);
				panelBoss.clear();
				bossLogPanel.plugin.save(panelBoss.getBoss());
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				reset_button.setIcon(RESET_ICON_HOVER);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				reset_button.setIcon(RESET_ICON);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
}

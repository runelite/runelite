package net.runelite.client.plugins.remotebankcontents;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

public class RemoteBankContentsPanel extends PluginPanel
{

	private static final int ITEMS_PER_ROW = 5;
	final JPanel bankItemPanel = new JPanel();
	private final JLabel overallIcon = new JLabel();    // Details and navigation

	@Inject
	private final ItemManager itemManager;
	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;
	private LinkedHashSet<BankItem> items; //Goes through all tabs numerically and then does the first main tab.
	private LinkedHashSet<BankItem> tempItems;
	private JTextField searchBar = new JTextField();
	private JPanel searchPanel = new JPanel();
	private LinkedHashMap<Integer, Integer> itemsAndQuantities;

	RemoteBankContentsPanel(Client client, ItemManager itemManager)
	{
		this.client = client;
		this.itemManager = itemManager;
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BoxLayout(this, 1));


		add(searchBar);

		searchBar.getDocument().addDocumentListener(new DocumentListener()
		{
			public void insertUpdate(DocumentEvent e)
			{
				filter(searchBar.getText());
			}

			public void removeUpdate(DocumentEvent e)
			{
				filter(searchBar.getText());
			}

			public void changedUpdate(DocumentEvent e)

			{

			}
		});


		bankItemPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		bankItemPanel.setBorder(new EmptyBorder(5, 5, 5, 10));

		add(bankItemPanel);


	}


	//AsyncBufferedImage itemImage = itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1);
	//private final ItemManager itemManager;
	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	void setItems(LinkedHashSet<BankItem> items)
	{

		this.items = items.stream().filter(i -> !i.isTemplate()).filter(i -> i.getQuantity() > 0).filter(i -> i.getName().length() > 0).collect(Collectors.toCollection(LinkedHashSet::new));

		populatePanel();
	}


	public void populatePanel()
	{

		if (items != null)
		{
			int itemsPerRow = ITEMS_PER_ROW;
			final int numberOfRows = ((items.size() % itemsPerRow == 0) ? items.size() / itemsPerRow : items.size() / itemsPerRow + 1);

			bankItemPanel.removeAll();
			bankItemPanel.setLayout(new GridLayout(numberOfRows, ITEMS_PER_ROW, 1, 1));
			bankItemPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

			items.forEach(bankItem -> {

					if (!bankItem.isTemplate() && bankItem.getQuantity() > 0 && !bankItem.getName().equals(""))
					{

						JPanel slotContainer = new JPanel();
						slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

						JLabel imageLabel = new JLabel();
						imageLabel.setVerticalAlignment(SwingConstants.CENTER);
						imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
						bankItem.getImage().addTo(imageLabel);
						imageLabel.setToolTipText(bankItem.getName());

						slotContainer.add(imageLabel);
						bankItemPanel.add(slotContainer);
					}
				}
			);

			rebuild();
		}

	}

	public void rebuild()
	{

		repaint();
		revalidate();
	}


	//remember on logout everything resets
	public void filter(String name)
	{
		if (items != null)
		{
			tempItems = items;

			CharSequence chars = name.toLowerCase();

			System.out.println(chars.length());
			if (chars.length() > 0)
			{

				items = items.stream().filter(i -> i.getName().toLowerCase().contains(chars)).collect(Collectors.toCollection(LinkedHashSet::new));
				populatePanel();
				items = tempItems;
			}
			else
			{
				items = tempItems;
				populatePanel();
			}


		}
	}
}
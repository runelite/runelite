package net.runelite.client.plugins.remotebankcontents;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
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
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

public class RemoteBankContentsPanel extends PluginPanel
{

	private static final int ITEMS_PER_ROW = 5;
	final JPanel innerPanel = new JPanel();
	private final JLabel overallIcon = new JLabel();    // Details and navigation
	private final JPanel itemContainer = new JPanel();

	@Inject
	private final ItemManager itemManager;
	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;
	private Set<BankItem> items; //Goes through all tabs numerically and then does the first main tab.
	private Set<BankItem> tempItems;
	private JTextField searchBar = new JTextField();
	private JPanel searchPanel = new JPanel();
	private LinkedHashMap<Integer, Integer> itemsAndQuantities;

	RemoteBankContentsPanel(Client client, ItemManager itemManager)
	{
		this.client = client;
		this.itemManager = itemManager;
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BoxLayout(this, 1));

		add(searchPanel);
		searchPanel.setLayout(new GridLayout(1, 2));

		searchPanel.add(searchBar);
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


		add(innerPanel);
		innerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		innerPanel.setBorder(new EmptyBorder(5, 5, 5, 10));


	}


	//AsyncBufferedImage itemImage = itemManager.getImage(item.getId(), item.getQuantity(), item.getQuantity() > 1);
	//private final ItemManager itemManager;
	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}

	void setItems(LinkedHashSet<BankItem> items)
	{

		this.items = items;

		populatePanel();
	}


	public void populatePanel()
	{

		if (items != null)
		{
			final int rowSize = ((items.size() % ITEMS_PER_ROW == 0) ? 0 : 1) + items.size() / ITEMS_PER_ROW;
			innerPanel.setLayout(new GridLayout(rowSize, ITEMS_PER_ROW, 1, 1));
			innerPanel.removeAll();
			items.forEach(bankItem -> {


				if (client.getItemDefinition(bankItem.getId()).getPlaceholderTemplateId() == -1)
				{


					int quantity = 0;


					quantity = bankItem.getQuantity();


					if (quantity > 0)
					{

						final JPanel slotContainer = new JPanel();
						slotContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

						AsyncBufferedImage itemImage = bankItem.getImage();

						JLabel imageLabel = new JLabel();
						imageLabel.setVerticalAlignment(SwingConstants.CENTER);
						imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
						itemImage.addTo(imageLabel);
						imageLabel.setToolTipText(bankItem.getName());
						slotContainer.add(imageLabel);
						innerPanel.add(slotContainer);
					}
				}
			});

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
				items = items.stream().filter(i -> i.getName().toLowerCase().contains(chars)).collect(Collectors.toSet());
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
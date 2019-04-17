package net.runelite.client.plugins.remotebankcontents;

import java.awt.GridLayout;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;

public class RemoteBankContentsPanel extends PluginPanel
{

	/*
		Constants
	 */

	//May make this changeable in settings in the future.
	private static final int ITEMS_PER_ROW = 5;


	private final ItemManager itemManager;

	/*
		Swing Stuff
	 */
	private final JPanel bankItemPanel = new JPanel();
	/*  The error panel, this displays an error message */
	PluginErrorPanel initialPanel = new PluginErrorPanel();
	private Client client;
	private LinkedHashSet<BankItem> items; //Goes through all tabs numerically and then does the first main tab.
	private boolean initialised = false;
	private JTextField searchBar = new JTextField();

	RemoteBankContentsPanel(Client client, ItemManager itemManager)
	{

		/*
			Pass client and item manager from main class.
		 */
		this.client = client;
		this.itemManager = itemManager;


		initialPanel.setBorder(new EmptyBorder(50, 20, 20, 20));
		initialPanel.setContent("Plugin not initialised.", "Please open the bank to initialise");

		add(initialPanel);
	}

	public void setInitialPanel(){
		initialPanel.setBorder(new EmptyBorder(50, 20, 20, 20));
		initialPanel.setContent("Plugin not initialised.", "Please open the bank to initialise");

		add(initialPanel);
	}

	public void reset()
	{
		removeAll();
		setInitialPanel();
		rebuild();
	}



	private void initialiseMainPanel()
	{


		removeAll();

		setBorder(new EmptyBorder(8, 8, 8, 8));
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
		initialised = true;

	}

/*
	void loadHeaderIcon(BufferedImage img)
	{
		overallIcon.setIcon(new ImageIcon(img));
	}
*/

	void setItems(LinkedHashSet<BankItem> items)
	{

		this.items = items.stream().filter(i -> !i.isTemplate()).filter(i -> i.getQuantity() > 0).filter(i -> i.getName().length() > 0).collect(Collectors.toCollection(LinkedHashSet::new));

		populatePanel();
	}


	public void populatePanel()
	{

		Instant start = Instant.now();



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
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		client.getLogger().debug("Populate panel took: " + timeElapsed + "ms");
	}

	public void rebuild()
	{

		if (!initialised)
		{
			initialiseMainPanel();
		}

		repaint();
		revalidate();

	}


	//remember on logout everything resets
	public void filter(String name)
	{
		if (items != null)
		{
			LinkedHashSet<BankItem> tempItems = items;

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

	public LinkedHashSet<BankItem> getItems() {


		return items;
}

}

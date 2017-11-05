package net.runelite.client.plugins.grandexchange;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.client.RuneLite;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;
import org.apache.commons.lang3.tuple.MutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class GrandExchangePanel extends PluginPanel
{
	private static final Logger logger = LoggerFactory.getLogger(GrandExchangePanel.class);

	private final Client client = RuneLite.getClient();

	private JComponent component;

	private ArrayList<MutablePair<GrandExchangeOffer, GrandExchangeOfferSlot>> grandExchangeOffers;

	GrandExchangePanel()
	{
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		setVisible(true);

		populate();
		component = buildPanel();
		add(component);
	}

	private void populate()
	{
		this.grandExchangeOffers = new ArrayList<>(8);
		IntStream.range(0, 8)
			.forEach(i -> grandExchangeOffers.add(i, new MutablePair<GrandExchangeOffer, GrandExchangeOfferSlot>(new GrandExchangeOfferImpl()
		{
		}, new GrandExchangeOfferSlot())));
	}

	//Scheduled @ (1 sec)
	void updateOffers()
	{
		if (client == null || client.getGameState() != GameState.LOGGED_IN)
		{
			//TODO: only repaint/update if offer changed.
			return;
		}

		updateConsumer.accept(getGrandExchangeOffers.get());

		grandExchangeOffers.forEach(pair ->
		{
			GrandExchangeOffer offer = pair.getLeft();
			GrandExchangeOfferSlot slot = pair.getRight();

			int itemId = offer.getItemId();
			int price = offer.getPrice();
			int sold = offer.getQuantitySold();
			int total = offer.getTotalQuantity();

			final String itemName = client.getItemDefinition(itemId).getName();
			final Image itemImage = ItemManager.getImage(itemId);

			EventQueue.invokeLater(() ->
			{
				try
				{
					slot.setItemNameLabel(itemId == 0 ? "Empty" : itemName);
					slot.setOfferImage(new ImageIcon(itemImage));
					slot.setOfferPriceLabel(ItemManager.quantityToStackSize(price).endsWith("M")
						|| ItemManager.quantityToStackSize(price).endsWith("K")
						? ItemManager.quantityToStackSize(price)
						: ItemManager.quantityToStackSize(price) + " gp");
					slot.getProgressBar().setString(sold + " / " + total);
					slot.setProgressBar(total == 0 ? 0 : (sold / total) * 100);
					slot.setStatusIndicator(OfferState.codeToInstance(offer.getProgress()));
				}
				catch (Exception ex)
				{
					logger.warn("error updating slot", ex);
				}
			});

		});

	}

	private JComponent buildPanel()
	{
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 225, 555);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JPanel[] panelSlots = new JPanel[8];
		for (int i = 0; i < 8; i++)
		{
			panelSlots[i] = buildSlot(i);
		}
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelSlots[0], GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
						.addComponent(panelSlots[1], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSlots[2], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSlots[3], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSlots[4], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSlots[5], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSlots[6], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSlots[7], GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelSlots[0], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[1], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[2], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[3], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[4], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[5], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[6], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSlots[7], GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		return panel;
	}

	private JPanel buildSlot(int slotNumber)
	{
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(90, 82, 69));

		GrandExchangeOfferSlot offerSlot = getSlot(slotNumber);

		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 187, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(offerSlot.getImageLabel())
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(offerSlot.getItemNameLabel(), GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(58))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(offerSlot.getOfferPriceLabel())
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addComponent(offerSlot.getStatusIndicatorLabel()))
						.addComponent(offerSlot.getProgressBar(), GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 54, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(offerSlot.getItemNameLabel(), GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(offerSlot.getOfferPriceLabel())
						.addComponent(offerSlot.getStatusIndicatorLabel()))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(offerSlot.getProgressBar(), GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addComponent(offerSlot.getImageLabel())
					.addContainerGap())
		);
		panel.setLayout(groupLayout);

		return panel;
	}

	private Supplier<GrandExchangeOffer[]> getGrandExchangeOffers = () -> client.getGrandExchangeOffers();

	private Consumer<GrandExchangeOffer[]> updateConsumer = (newOffers) ->
	{
		if (newOffers == null)
		{
			return;
		}
		IntStream.range(0, newOffers.length).forEach(i -> grandExchangeOffers.get(i).setLeft(newOffers[i]));
	};

	private GrandExchangeOfferSlot getSlot(int slotNumber)
	{
		return grandExchangeOffers.stream()
			.filter(pair -> this.grandExchangeOffers.get(slotNumber).equals(pair))
			.findFirst()
			.get()
			.getRight();
	}

}

package net.runelite.client.plugins.grandexchange;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import net.runelite.api.Client;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.client.RuneLite;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.PluginPanel;

/**
 * @author Robbie, created on 29/10/2017 09:58 AM
 */
public class GrandExchangePanel extends PluginPanel
{

  private Client client;

  private JComponent component;
  private static GrandExchangePanel instance;


  private JLabel[] imageLabels;
  private ImageIcon[] offerImages;
  private JLabel[] itemNameLabels;
  private JLabel[] offerPriceLabels;
  private JLabel[] statusIndicators;
  private JProgressBar[] progressBars;

  private GrandExchangePanel()
  {
    setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    setSize(PANEL_WIDTH, PANEL_HEIGHT);
    setVisible(true);
  }

  public static GrandExchangePanel getInstance()
  {
    return instance == null
        ? instance = new GrandExchangePanel()
        : instance;
  }

  public void init()
  {
    if (component == null) {
      client = RuneLite.getClient();
      populate();
      component = buildPanel();
      add(component);
      handleLogic();
    }
  }

  private void populate()
  {
    this.offerImages = new ImageIcon[8];
    this.imageLabels = new JLabel[8];
    this.itemNameLabels = new JLabel[8];
    this.offerPriceLabels = new JLabel[8];
    this.statusIndicators = new JLabel[8];
    this.progressBars = new JProgressBar[8];

    //TODO: via java 8 stream?
    for (int i = 0; i < offerImages.length; i++) {
      offerImages[i] = new ImageIcon(ItemManager.getImage(0)); //the icon (dwarf remains)
      imageLabels[i] = new JLabel(); //holds icon
      itemNameLabels[i] = new JLabel(); //holds item name
      offerPriceLabels[i] = new JLabel(); //holds offer price
      statusIndicators[i] = new JLabel(); //holds quantity bought/sold
      progressBars[i] = new JProgressBar();
    }

  }

  private void handleLogic()
  {
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
    ses.scheduleWithFixedDelay(() -> updateUI.accept(client.getGrandExchangeOffers()), 0, 1000, TimeUnit.MILLISECONDS);
  }

  private Consumer<GrandExchangeOffer[]> updateUI = (offers) ->
      Arrays.stream(offers)
          .filter(Objects::nonNull)
          .forEach(offer -> {

            int idx = Arrays.asList(offers).indexOf(offer);

            offerImages[idx] = new ImageIcon(
                client.getGrandExchangeOffers() == null || client.getGrandExchangeOffers()[idx] == null
                    ? ItemManager.getImage(0)
                    : ItemManager.getImage(client.getGrandExchangeOffers()[idx].getItemId())
            );

            //TODO: "empty slot" image [instead of dwarf remains image]?
            imageLabels[idx].setIcon(offer.getItemId() == 0 ? new ImageIcon(ItemManager.getImage(0)) : offerImages[idx]);

            itemNameLabels[idx].setText(offer.getItemId() == 0 ? "Empty" : offer.getTotalQuantity() + "x " + client.getItemDefinition(offer.getItemId()).getName());

            offerPriceLabels[idx].setText(ItemManager.quantityToStackSize(offer.getPrice()).endsWith("M")
                || ItemManager.quantityToStackSize(offer.getPrice()).endsWith("K")
                ? ItemManager.quantityToStackSize(offer.getPrice())
                : ItemManager.quantityToStackSize(offer.getPrice()) + " gp");

            statusIndicators[idx].setText(getIsBuySell(offer));

            EventQueue.invokeLater(() -> progressBars[idx].setValue(offer.getTotalQuantity() == 0 ? 0 : (offer.getQuantitySold() / offer.getTotalQuantity()) * 100));

            progressBars[idx].setStringPainted(true);
            progressBars[idx].setBackground(decodeColour(progressBars[idx]));
            progressBars[idx].setForeground(Color.white);
            progressBars[idx].setString(offer.getQuantitySold() + " / " + offer.getTotalQuantity());

          });

  private String getIsBuySell(GrandExchangeOffer offer)
  {
    switch (offer.getProgress()) {
      case 2:
        return "Buy";

      case 5:
        return "Bought";

      case 10:
        return "Sell";

      case 13:
        return "Sold";

      case 0:
      default:
        return "";
    }
  }

  private Color decodeColour(JProgressBar offerBar)
  {
    switch ((int) offerBar.getPercentComplete() * 100) {
      case 0:
        return Color.GRAY;

      case 100:
        return Color.GREEN;

      default:
        return Color.ORANGE;
    }
  }

  private Function<GrandExchangeOffer[], String> getOfferStrings = (offers) ->
  {
    for (GrandExchangeOffer offer : offers) {
      if (offer != null) {
        return "GrandExchangeOffer{" +
            "id=" + offer.getItemId() + ", " +
            "price=" + offer.getPrice() + ", " +
            "quantitySold=" + offer.getQuantitySold() + ", " +
            "totalQuantity=" + offer.getTotalQuantity() +
            "}";
      }
    }
    return null;
  };

  private JComponent buildPanel()
  {

    JFrame frame = new JFrame();
    frame.setBounds(100, 100, 225, 555);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.CENTER);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(90, 82, 69));
    panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

    JPanel panel_2 = new JPanel();
    panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_2.setBackground(new Color(90, 82, 69));

    imageLabels[1] = new JLabel("");
    imageLabels[1].setIcon(offerImages[1]);

    itemNameLabels[1] = new JLabel("Empty");

    progressBars[1] = new JProgressBar();

    offerPriceLabels[1] = new JLabel("");

    statusIndicators[1] = new JLabel("");
    GroupLayout gl_panel_2 = new GroupLayout(panel_2);
    gl_panel_2.setHorizontalGroup(
        gl_panel_2.createParallelGroup(Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
            .addGroup(gl_panel_2.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[1])
                .addGap(10)
                .addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
                    .addGroup(gl_panel_2.createSequentialGroup()
                        .addComponent(itemNameLabels[1], GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addGap(58))
                    .addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
                        .addComponent(offerPriceLabels[1])
                        .addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(statusIndicators[1]))
                    .addComponent(progressBars[1], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_2.setVerticalGroup(
        gl_panel_2.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 54, Short.MAX_VALUE)
            .addGroup(gl_panel_2.createSequentialGroup()
                .addComponent(itemNameLabels[1], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
                    .addComponent(offerPriceLabels[1])
                    .addComponent(statusIndicators[1]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[1], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_2.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(imageLabels[1])
                .addContainerGap())
    );
    panel_2.setLayout(gl_panel_2);

    JPanel panel_3 = new JPanel();
    panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_3.setBackground(new Color(90, 82, 69));

    imageLabels[2] = new JLabel("");
    imageLabels[2].setIcon(offerImages[2]);

    itemNameLabels[2] = new JLabel("Empty");

    progressBars[2] = new JProgressBar();

    offerPriceLabels[2] = new JLabel("");

    statusIndicators[2] = new JLabel("");
    GroupLayout gl_panel_3 = new GroupLayout(panel_3);
    gl_panel_3.setHorizontalGroup(
        gl_panel_3.createParallelGroup(Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
            .addGroup(gl_panel_3.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[2])
                .addGap(10)
                .addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
                    .addGroup(gl_panel_3.createSequentialGroup()
                        .addComponent(itemNameLabels[2], GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addGap(58))
                    .addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
                        .addComponent(offerPriceLabels[2])
                        .addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(statusIndicators[2]))
                    .addComponent(progressBars[2], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_3.setVerticalGroup(
        gl_panel_3.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 54, Short.MAX_VALUE)
            .addGroup(gl_panel_3.createSequentialGroup()
                .addComponent(itemNameLabels[2], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
                    .addComponent(offerPriceLabels[2])
                    .addComponent(statusIndicators[2]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[2], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_3.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(imageLabels[2])
                .addContainerGap())
    );
    panel_3.setLayout(gl_panel_3);

    JPanel panel_4 = new JPanel();
    panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_4.setBackground(new Color(90, 82, 69));

    imageLabels[3] = new JLabel("");
    imageLabels[3].setIcon(offerImages[3]);

    itemNameLabels[3] = new JLabel("Empty");

    progressBars[3] = new JProgressBar();

    offerPriceLabels[3] = new JLabel("");

    statusIndicators[3] = new JLabel("");
    GroupLayout gl_panel_4 = new GroupLayout(panel_4);
    gl_panel_4.setHorizontalGroup(
        gl_panel_4.createParallelGroup(Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(gl_panel_4.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[3])
                .addGap(10)
                .addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
                    .addComponent(itemNameLabels[3], GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addGroup(gl_panel_4.createSequentialGroup()
                        .addComponent(offerPriceLabels[3])
                        .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(statusIndicators[3]))
                    .addComponent(progressBars[3], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_4.setVerticalGroup(
        gl_panel_4.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_4.createSequentialGroup()
                .addComponent(itemNameLabels[3], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                    .addComponent(statusIndicators[3])
                    .addComponent(offerPriceLabels[3]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[3], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_4.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabels[3])
                .addContainerGap())
    );
    panel_4.setLayout(gl_panel_4);

    JPanel panel_5 = new JPanel();
    panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_5.setBackground(new Color(90, 82, 69));

    imageLabels[4] = new JLabel("");
    imageLabels[4].setIcon(offerImages[4]);

    itemNameLabels[4] = new JLabel("Empty");

    progressBars[4] = new JProgressBar();

    offerPriceLabels[4] = new JLabel("");

    statusIndicators[4] = new JLabel("");
    GroupLayout gl_panel_5 = new GroupLayout(panel_5);
    gl_panel_5.setHorizontalGroup(
        gl_panel_5.createParallelGroup(Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(gl_panel_5.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[4])
                .addGap(10)
                .addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
                    .addComponent(itemNameLabels[4], GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addGroup(gl_panel_5.createSequentialGroup()
                        .addComponent(offerPriceLabels[4])
                        .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(statusIndicators[4]))
                    .addComponent(progressBars[4], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_5.setVerticalGroup(
        gl_panel_5.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_5.createSequentialGroup()
                .addComponent(itemNameLabels[4], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
                    .addComponent(statusIndicators[4])
                    .addComponent(offerPriceLabels[4]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[4], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_5.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabels[4])
                .addContainerGap())
    );
    panel_5.setLayout(gl_panel_5);

    JPanel panel_6 = new JPanel();
    panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_6.setBackground(new Color(90, 82, 69));

    imageLabels[5] = new JLabel("");
    imageLabels[5].setIcon(offerImages[5]);

    itemNameLabels[5] = new JLabel("Empty");

    progressBars[5] = new JProgressBar();

    offerPriceLabels[5] = new JLabel("");

    statusIndicators[5] = new JLabel("");
    GroupLayout gl_panel_6 = new GroupLayout(panel_6);
    gl_panel_6.setHorizontalGroup(
        gl_panel_6.createParallelGroup(Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(gl_panel_6.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[5])
                .addGap(10)
                .addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
                    .addComponent(itemNameLabels[5], GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addGroup(gl_panel_6.createSequentialGroup()
                        .addComponent(offerPriceLabels[5])
                        .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(statusIndicators[5]))
                    .addComponent(progressBars[5], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_6.setVerticalGroup(
        gl_panel_6.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_6.createSequentialGroup()
                .addComponent(itemNameLabels[5], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
                    .addComponent(statusIndicators[5])
                    .addComponent(offerPriceLabels[5]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[5], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_6.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabels[5])
                .addContainerGap())
    );
    panel_6.setLayout(gl_panel_6);

    JPanel panel_7 = new JPanel();
    panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_7.setBackground(new Color(90, 82, 69));

    imageLabels[6] = new JLabel("");
    imageLabels[6].setIcon(offerImages[6]);

    itemNameLabels[6] = new JLabel("Empty");

    progressBars[6] = new JProgressBar();

    offerPriceLabels[6] = new JLabel("");

    statusIndicators[6] = new JLabel("");
    GroupLayout gl_panel_7 = new GroupLayout(panel_7);
    gl_panel_7.setHorizontalGroup(
        gl_panel_7.createParallelGroup(Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(gl_panel_7.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[6])
                .addGap(10)
                .addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
                    .addComponent(itemNameLabels[6], GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addGroup(gl_panel_7.createSequentialGroup()
                        .addComponent(offerPriceLabels[6])
                        .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(statusIndicators[6]))
                    .addComponent(progressBars[6], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_7.setVerticalGroup(
        gl_panel_7.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_7.createSequentialGroup()
                .addComponent(itemNameLabels[6], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
                    .addComponent(statusIndicators[6])
                    .addComponent(offerPriceLabels[6]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[6], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_7.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabels[6])
                .addContainerGap())
    );
    panel_7.setLayout(gl_panel_7);

    JPanel panel_8 = new JPanel();
    panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
    panel_8.setBackground(new Color(90, 82, 69));

    imageLabels[7] = new JLabel("");
    imageLabels[7].setIcon(offerImages[7]);

    itemNameLabels[7] = new JLabel("Empty");

    progressBars[7] = new JProgressBar();

    offerPriceLabels[7] = new JLabel("");

    statusIndicators[7] = new JLabel("");
    GroupLayout gl_panel_8 = new GroupLayout(panel_8);
    gl_panel_8.setHorizontalGroup(
        gl_panel_8.createParallelGroup(Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(gl_panel_8.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[7])
                .addGap(10)
                .addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
                    .addComponent(itemNameLabels[7], GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addGroup(gl_panel_8.createSequentialGroup()
                        .addComponent(offerPriceLabels[7])
                        .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(statusIndicators[7]))
                    .addComponent(progressBars[7], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_8.setVerticalGroup(
        gl_panel_8.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_8.createSequentialGroup()
                .addComponent(itemNameLabels[7], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
                    .addComponent(statusIndicators[7])
                    .addComponent(offerPriceLabels[7]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBars[7], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
            .addGroup(gl_panel_8.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageLabels[7])
                .addContainerGap())
    );
    panel_8.setLayout(gl_panel_8);
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
        gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
                .addContainerGap()
                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                    .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel.setVerticalGroup(
        gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
    );

    imageLabels[0] = new JLabel("");
    imageLabels[0].setIcon(offerImages[0]);

    itemNameLabels[0] = new JLabel("Empty");

    progressBars[0] = new JProgressBar();

    statusIndicators[0] = new JLabel("");

    offerPriceLabels[0] = new JLabel("");
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(
        gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabels[0])
                .addGap(10)
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_panel_1.createSequentialGroup()
                        .addComponent(offerPriceLabels[0])
                        .addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(statusIndicators[0]))
                    .addComponent(progressBars[0], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemNameLabels[0], GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
    );
    gl_panel_1.setVerticalGroup(
        gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel_1.createSequentialGroup()
                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_panel_1.createSequentialGroup()
                        .addGap(5)
                        .addComponent(itemNameLabels[0])
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                            .addComponent(offerPriceLabels[0])
                            .addComponent(statusIndicators[0]))
                        .addGap(2)
                        .addComponent(progressBars[0], GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
                    .addGroup(gl_panel_1.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageLabels[0])))
                .addContainerGap())
    );
    panel_1.setLayout(gl_panel_1);
    panel.setLayout(gl_panel);

    return panel;
  }

}

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
public class GrandExchangePanel extends PluginPanel {

  private Client client;

  private JComponent component;
  private static GrandExchangePanel instance;


  private JLabel[] imageLabels;
  private ImageIcon[] offerImages;
  private JLabel[] itemNameLabels;
  private JLabel[] offerPriceLabels;

  private GrandExchangePanel() {
    setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    setSize(PANEL_WIDTH, PANEL_HEIGHT);
    setVisible(true);
  }

  public static GrandExchangePanel getInstance() {
    return instance == null
        ? instance = new GrandExchangePanel()
        : instance;
  }

  public void init() {
    if (component == null) {
      client = RuneLite.getClient();
      populate();
      component = buildPanel();
      add(component);
      handleLogic();
    }
  }

  private void populate() {
    this.offerImages = new ImageIcon[8];
    this.imageLabels = new JLabel[8];
    this.itemNameLabels = new JLabel[8];
    this.offerPriceLabels = new JLabel[8];

    //TODO: via java 8 stream?
    for (int i = 0; i < offerImages.length; i++) {
      offerImages[i] = new ImageIcon(ItemManager.getImage(0)); //the icon (dwarf remains)
      imageLabels[i] = new JLabel(); //holds icon
      itemNameLabels[i] = new JLabel(); //holds item name
      offerPriceLabels[i] = new JLabel(); //holds offer price
    }

  }

  private void handleLogic() {
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
    ses.scheduleWithFixedDelay(() -> updateUI.accept(client.getGrandExchangeOffers()), 0, 1000, TimeUnit.MILLISECONDS);
  }

  private Consumer<GrandExchangeOffer[]> updateUI = (offers) -> {
    System.out.println("Started call to updateUI consumer");
    Arrays.stream(offers)
        .filter(Objects::nonNull)
        .forEach(offer -> {

              int idx = Arrays.asList(offers).indexOf(offer);

              //TODO: add Selling/Buying indicator? Sell/Buy Flag is decoded as below...
//              switch (offer.getProgress()) {
//                case 2:
//                  System.out.println("BUY OFFER @ "+client.getItemDefinition(offer.getItemId()).getName());
//                  break;
//
//                case 10:
//                  System.out.println("SELL OFFER @ "+client.getItemDefinition(offer.getItemId()).getName());
//                  break;
//
//                case 0:
//                  System.out.println("< Empty slot >");
//                  break;
//              }

              System.out.println(offer.getQuantitySold()+", "+offer.getTotalQuantity());


              offerImages[idx] = new ImageIcon(
                  client.getGrandExchangeOffers() == null || client.getGrandExchangeOffers()[idx] == null
                      ? ItemManager.getImage(0)
                      : ItemManager.getImage(client.getGrandExchangeOffers()[idx].getItemId())
              );

              //TODO: "empty slot" image [instead of dwarf remains image]?
              imageLabels[idx].setIcon(offer.getItemId() == 0 ? new ImageIcon(ItemManager.getImage(0)) : offerImages[idx]);

              itemNameLabels[idx].setText(offer.getItemId() == 0 ? "Empty" : client.getItemDefinition(offer.getItemId()).getName());

              offerPriceLabels[idx].setText(ItemManager.quantityToStackSize(offer.getPrice())+" gp");

            }
        ); //update our map
    System.out.println("Finished call to updateUI consumer");
  };

  private Function<GrandExchangeOffer[], String> getOfferStrings = (offers) -> {
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

  private JComponent buildPanel() {

    JFrame frame = new JFrame();
    frame.setBounds(100, 100, 225, 555);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    JProgressBar progressBar_1 = new JProgressBar();

    offerPriceLabels[1] = new JLabel("");

    JLabel label_4 = new JLabel("258 / 3849");
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
                        .addComponent(label_4))
                    .addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(label_4))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar_2 = new JProgressBar();

    offerPriceLabels[2] = new JLabel("");

    JLabel label_8 = new JLabel("258 / 3849");
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
                        .addComponent(label_8))
                    .addComponent(progressBar_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(label_8))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_2, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar_3 = new JProgressBar();

    offerPriceLabels[3] = new JLabel("");

    JLabel label_12 = new JLabel("258 / 3849");
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
                        .addComponent(label_12))
                    .addComponent(progressBar_3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_4.setVerticalGroup(
        gl_panel_4.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_4.createSequentialGroup()
                .addComponent(itemNameLabels[3], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                    .addComponent(label_12)
                    .addComponent(offerPriceLabels[3]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_3, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar_4 = new JProgressBar();

    offerPriceLabels[4] = new JLabel("");

    JLabel label_17 = new JLabel("258 / 3849");
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
                        .addComponent(label_17))
                    .addComponent(progressBar_4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_5.setVerticalGroup(
        gl_panel_5.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_5.createSequentialGroup()
                .addComponent(itemNameLabels[4], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
                    .addComponent(label_17)
                    .addComponent(offerPriceLabels[4]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_4, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar_5 = new JProgressBar();

    offerPriceLabels[5] = new JLabel("");

    JLabel label_21 = new JLabel("258 / 3849");
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
                        .addComponent(label_21))
                    .addComponent(progressBar_5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_6.setVerticalGroup(
        gl_panel_6.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_6.createSequentialGroup()
                .addComponent(itemNameLabels[5], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
                    .addComponent(label_21)
                    .addComponent(offerPriceLabels[5]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_5, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar_6 = new JProgressBar();

    offerPriceLabels[6] = new JLabel("");

    JLabel label_25 = new JLabel("258 / 3849");
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
                        .addComponent(label_25))
                    .addComponent(progressBar_6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_7.setVerticalGroup(
        gl_panel_7.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_7.createSequentialGroup()
                .addComponent(itemNameLabels[6], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
                    .addComponent(label_25)
                    .addComponent(offerPriceLabels[6]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_6, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar_7 = new JProgressBar();

    offerPriceLabels[7] = new JLabel("");

    JLabel label_29 = new JLabel("258 / 3849");
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
                        .addComponent(label_29))
                    .addComponent(progressBar_7, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    gl_panel_8.setVerticalGroup(
        gl_panel_8.createParallelGroup(Alignment.TRAILING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(gl_panel_8.createSequentialGroup()
                .addComponent(itemNameLabels[7], GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
                    .addComponent(label_29)
                    .addComponent(offerPriceLabels[7]))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(progressBar_7, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

    JProgressBar progressBar = new JProgressBar();

    JLabel label_15 = new JLabel("258 / 3849");

    offerPriceLabels[0] = new JLabel("3539 gp");
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
                        .addComponent(label_15))
                    .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(label_15))
                        .addGap(2)
                        .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 10, Short.MAX_VALUE))
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

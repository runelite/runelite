package net.runelite.client.plugins.flipping;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.grandexchange.GrandExchangePlugin;
import net.runelite.client.plugins.hiscore.IconTextField;
import net.runelite.client.ui.PluginPanel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
public class FlippingPanel extends PluginPanel
{

    private final ScheduledExecutorService executor;

    private IconTextField searchBox = new IconTextField();
    private Icon search;

    private JScrollPane scrollPane = new JScrollPane();
    private JPanel container = new JPanel();
    private JPanel searchItemsPanel = new JPanel();
    private JLabel searchingLabel = new JLabel();

    @Inject
    FlippingPanel(ScheduledExecutorService executor)
    {
        this.executor = executor;

        setLayout(new BorderLayout());
        container.setLayout(new BorderLayout());

        try
        {
            BufferedImage icon;
            synchronized (ImageIO.class)
            {
                icon = ImageIO.read(GrandExchangePlugin.class.getResourceAsStream("search.png"));
            }
            search = new ImageIcon(icon);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        searchBox.setIcon(search);
        searchBox.addActionListener(e -> executor.execute(() -> searchForFlipPrices()));

        container.add(searchBox, BorderLayout.NORTH);

        searchingLabel.setHorizontalAlignment(JLabel.CENTER);
        searchingLabel.setForeground(Color.YELLOW);

        searchItemsPanel.setLayout(new GridLayout(0, 1, 0, 3));
        searchItemsPanel.setBorder(new EmptyBorder(3, 0, 0, 0));

        container.add(searchItemsPanel, BorderLayout.SOUTH);

        scrollPane = new JScrollPane(container);

        add(scrollPane, BorderLayout.NORTH);
    }

    private void searchForFlipPrices()
    {
        String itemName = searchBox.getText();

        searchItemsPanel.removeAll();

        if (itemName == null || itemName.isEmpty())
        {
            return;
        }

        showSearchString("Searching...");

        List<FlippingItem> flippingItems = searchFlippingItem(itemName);
        SwingUtilities.invokeLater(() ->
        {
            if (flippingItems != null)
            {
                if (!flippingItems.isEmpty())
                {
                    for (FlippingItem flippingItem : flippingItems)
                    {
                        FlippingItemPanel panel = new FlippingItemPanel(flippingItem.getItemName(), flippingItem.getIcon(),
                                flippingItem.getBuyPrice(), flippingItem.getSellPrice());

                        searchItemsPanel.add(panel);
                    }

                    showSearchString(null);
                    flippingItems.clear();
                }
                else
                {
                    showSearchString("No results found.");
                }
            }
            else
            {
                showSearchString("Something went wrong...");
            }
        });
    }

    private void showSearchString(String str)
    {
        if (str != null)
        {
            remove(searchingLabel);
            searchingLabel.setText(str);
            add(searchingLabel, BorderLayout.CENTER);
        }
        else
        {
            remove(searchingLabel);
        }

        revalidate();
        repaint();
    }

    private List<FlippingItem> searchFlippingItem(String itemName)
    {
        try
        {
            List<FlippingItem> flippingItems = new ArrayList<>();

            Document document = Jsoup.connect(String.format("https://www.ge-tracker.com/names/%s", itemName)).timeout(6000).get();
            Elements elements = document.getElementsByClass("item-row");
            for(Element element : elements)
            {
                String fullItemName = element.getElementsByTag("img").attr("alt");

                URL imageURL = new URL(element.getElementsByTag("img").attr("src"));
                ImageIcon rawIcon = new ImageIcon(imageURL);
                Icon icon = resizeImageIcon(rawIcon);

                Long buyPrice = Long.parseLong(element.getElementsByTag("td").get(3).text().replace(",", ""));
                Long sellPrice = Long.parseLong(element.getElementsByTag("td").get(4).text().replace(",", ""));

                flippingItems.add(new FlippingItem(fullItemName, icon, buyPrice, sellPrice));

                if(flippingItems.size() == 10)
                {
                    break;
                }
            }

            return flippingItems;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private Icon resizeImageIcon(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);

        return icon;
    }
}

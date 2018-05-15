package net.runelite.client.plugins.flipping;

import com.google.common.eventbus.Subscribe;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.events.SetMessage;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginToolbar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.io.IOException;

@PluginDescriptor(
        name = "Flipping",
        loadWhenOutdated = true
)

@Slf4j
public class Flipping extends Plugin {

    @Inject
    private Client client;

    @Inject
    private ChatMessageManager chatMessageManager;

    @Inject
    private PluginToolbar pluginToolbar;

    @Getter(AccessLevel.PACKAGE)
    private NavigationButton button;

    @Getter(AccessLevel.PACKAGE)
    private FlippingPanel panel;

    @Override
    protected void startUp() throws IOException {
        panel = injector.getInstance(FlippingPanel.class);

        BufferedImage icon;
        synchronized (ImageIO.class)
        {
            icon = ImageIO.read(getClass().getResourceAsStream("flipping_icon.png"));
        }

        button = NavigationButton.builder()
                .name("Flipping")
                .icon(icon)
                .panel(panel)
                .build();

        pluginToolbar.addNavigation(button);
    }

    @Override
    protected void shutDown() {
        pluginToolbar.removeNavigation(button);
    }

    @Subscribe
    public void onSetMessage(SetMessage setMessage)
    {
        if(setMessage.getType() == ChatMessageType.PUBLIC) {
            String message = setMessage.getValue();
            MessageNode messageNode = setMessage.getMessageNode();

            if(message.toLowerCase().startsWith("!flipping") || message.toLowerCase().startsWith("!flip")) {
                String response;
                if(message.toLowerCase().contains(" ")) {
                    String[] messageSplit = message.split(" ");
                    if (messageSplit.length >= 2) {
                        String itemName = null;
                        for(int i = 1; i < messageSplit.length; i++) {
                            if(itemName == null) {
                                itemName = messageSplit[i];
                            } else {
                                itemName += " " + messageSplit[i];
                            }
                        }

                        Long[] prices = getPricesOfItem(itemName);
                        if(prices != null) {
                            response = new ChatMessageBuilder()
                                    .append(ChatColorType.NORMAL)
                                    .append("Item: ")
                                    .append(ChatColorType.HIGHLIGHT)
                                    .append(itemName.toUpperCase())
                                    .append(ChatColorType.NORMAL)
                                    .append(" Buy: ")
                                    .append(ChatColorType.HIGHLIGHT)
                                    .append(String.format("%,d", prices[0]))
                                    .append(ChatColorType.NORMAL)
                                    .append(" Sell: ")
                                    .append(ChatColorType.HIGHLIGHT)
                                    .append(String.format("%,d", prices[1]))
                                    .build();
                        } else {
                            response = getNoPricesErrorResponseMessage();
                        }
                    } else {
                        response = getErrorResponseMessage();
                    }
                } else {
                    response = getErrorResponseMessage();
                }

                messageNode.setRuneLiteFormatMessage(response);
                chatMessageManager.update(messageNode);
                client.refreshChat();
            }
        }
    }

    private String getErrorResponseMessage() {
        return new ChatMessageBuilder()
                .append(ChatColorType.NORMAL)
                .append("INVALID SYNTAX!")
                .build();
    }

    private String getNoPricesErrorResponseMessage() {
        return new ChatMessageBuilder()
                .append(ChatColorType.NORMAL)
                .append("NO PRICES FOUND!")
                .build();
    }

    private Long[] getPricesOfItem(String itemName) {
        try {
            if(itemName.contains(" ")) {
                itemName = itemName.replace(" ", "-");
            }

            Document document = Jsoup.connect(String.format("https://www.ge-tracker.com/item/%s", itemName)).timeout(6000).get();
            String buyPrice = document.getElementById("item_stat_offer_price").text();
            String sellPrice = document.getElementById("item_stat_sell_price").text();

            if(buyPrice != null && sellPrice != null) {
                buyPrice = buyPrice.replace(",", "");
                sellPrice = sellPrice.replace(",", "");

                System.out.print(buyPrice);
                Long[] prices = {Long.parseLong(buyPrice), Long.parseLong(sellPrice)};

                return prices;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

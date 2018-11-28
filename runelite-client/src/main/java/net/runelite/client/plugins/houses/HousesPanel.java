
package net.runelite.client.plugins.houses;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.SessionClose;
import net.runelite.api.events.SessionOpen;
import net.runelite.client.RuneLiteProperties;
import net.runelite.client.account.SessionManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import javax.inject.Singleton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ScheduledExecutorService;

@Singleton
public class HousesPanel extends PluginPanel {

	@Inject
	private static Client client;

	@Inject
	private RuneLiteProperties runeLiteProperties;

	@Inject
	private EventBus eventBus;

	@Inject
	private SessionManager sessionManager;

	@Inject
	private ScheduledExecutorService executor;

	static public DefaultListModel RimmListModel = new DefaultListModel();
	static public DefaultListModel YanListModel = new DefaultListModel();
	static JList<String> RimmList = new JList<String>(RimmListModel);
	static JList<String> YanList = new JList<>(YanListModel);
	void init()
	{
		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		JPanel Rows = new JPanel();
		Rows.setLayout(new GridLayout(2,1,0,10));
		JPanel RimmRow = new JPanel();
		RimmRow.setLayout(new BorderLayout());
		JPanel RimmPanel = new JPanel();
		RimmPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		RimmPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		RimmPanel.setLayout(new GridLayout(1, 1));
		RimmList.addFocusListener(new Actions());
		RimmList.addKeyListener(new Actions());
		final Font boldFont = FontManager.getRunescapeBoldFont();
		final Font Font = FontManager.getRunescapeFont();
		RimmList.setFont(Font);
		JPanel YanRow = new JPanel();
		YanRow.setLayout(new BorderLayout());
		JPanel YanPanel = new JPanel();
		YanPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		YanPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		YanPanel.setLayout(new GridLayout(1, 1));

		YanList.setFont(Font);
		YanList.addFocusListener(new Actions());
		YanList.addKeyListener(new Actions());

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2,0,10));
		buttons.setBorder(new EmptyBorder(10, 0, 0, 0));
		for (int i = 0; i < 2; i++){
			JButton button = new JButton((i==0? "Clear":"Refresh"));
			button.setActionCommand((i==0? "Clear":"Refresh"));
			button.addActionListener(new Actions());
			buttons.add(button);
		}
		RimmPanel.add(RimmList,BorderLayout.NORTH);
		YanPanel.add(YanList);
		JLabel label = new JLabel("Rimmington Hosts:");
		label.setFont(boldFont);
		RimmRow.add(label,BorderLayout.NORTH);
		RimmRow.add(RimmPanel,BorderLayout.CENTER);
		Rows.add(RimmRow);
		label = new JLabel("Yanille Hosts:");
		label.setFont(boldFont);
		YanRow.add(label,BorderLayout.NORTH);
		YanRow.add(YanPanel,BorderLayout.CENTER);
		Rows.add(YanRow);
		add(Rows, BorderLayout.NORTH);
		add(buttons,BorderLayout.CENTER);

		eventBus.register(this);

	}
	public final static String Yan = "Yanille Hosts: ";
	public final static String Rimm = "Rimmington Hosts: ";
	public static String YanHosts = Yan;
	public static String RimmHosts = Rimm;
	public static void getHostsFromAPI() {
		try {
			YanHosts = Yan;
			RimmHosts = Rimm;
			URL url = new URL("http://altar.rs/altartracker.txt");
			URLConnection request;
			request = url.openConnection();
			request.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			request.connect();
			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); //from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
			JsonObject json = root.getAsJsonObject(); //May be an array, may be an object.
			JsonArray JsonHosts = json.get("OSRS Hosts").getAsJsonArray(); //just grab the zipcode
			for (JsonElement Jsonhost : JsonHosts) {
				if (Jsonhost.getAsJsonObject().get("loc").toString().equalsIgnoreCase("\"rimmington\"")) {
					RimmHosts += (RimmHosts.equals(Rimm) ? "" : ", ") + Jsonhost.getAsJsonObject().get("Username").toString();
				} else if (Jsonhost.getAsJsonObject().get("loc").toString().equalsIgnoreCase("\"yanille\"")) {
					YanHosts += (YanHosts.equals(Yan) ? "" : ", ") + Jsonhost.getAsJsonObject().get("Username").toString();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//updateHosts();
	}
	public void updateHosts() {
        getHostsFromAPI();
        updateRimm(true);
        updateYan(true);
        isInClan();
    }
	private static void updateRimm() {
		updateRimm(false);
	}
	private void isInClan() {
        if (client == null)
        {
            System.out.println("null client");
            return;
        }
        if (client.getGameState() != GameState.LOGGED_IN)
        {
            System.out.println("!= logged in");
            return;
        }
        for (int i = 0; i < RimmListModel.getSize(); i++) {
            if (client.getClanMembers().toString().toLowerCase().contains(RimmListModel.get(i).toString())) {
                RimmListModel.set(i, RimmListModel.get(i).toString() + " [07 Altar]");
            }
        }
        for (int i = 0; i < YanListModel.getSize(); i++) {
            if (client.getClanMembers().toString().toLowerCase().contains(YanListModel.get(i).toString())) {
                YanListModel.set(i, YanListModel.get(i).toString() + " [07 Altar]");
            }

        }
    }

	private static void updateRimm(boolean gottenHosts) {
		if (!gottenHosts)
			getHostsFromAPI();
		String[] tempRimmHosts = (RimmHosts.substring(Rimm.length()+1, RimmHosts.length()-1)).split("\", \"");
		RimmListModel.clear();
		for (String host: tempRimmHosts) {
			RimmListModel.addElement(host);
		}
		//controller.rimmList.setItems(data);
		//controller.rimmList.setItems(FXCollections.observableArrayList(tempRimmHosts2));
	}
	private static void updateYan() {
		updateYan(false);
	}
	private static void updateYan(boolean gottenHosts) {
		if (!gottenHosts)
			getHostsFromAPI();
		YanListModel.clear();
		for (String host: (YanHosts.substring(Yan.length()+1, YanHosts.length()-1)).split("\", \"")) {
			YanListModel.addElement(host);
		}
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen)
	{
		//updateLoggedIn();
	}

	@Subscribe
	public void onSessionClose(SessionClose e)
	{
		//updateLoggedIn();
	}
}

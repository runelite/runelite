/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.profiles;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.ConfigChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
   
    name="Account Switcher",
    description="Allow for a allows you to easily switch between multiple OSRS Accounts", 
    tags={"profile", "account", "login", "log in"},
    type = PluginType.UTILITY
)

public class ProfilesPlugin
extends Plugin {
    @Inject
    private ClientToolbar clientToolbar;
    @Inject
    private Client client;
    @Inject
    private ProfilesConfig config;
    private ProfilesPanel panel;
    private NavigationButton navButton;
    String text = "Hello World";
    private static String key = "Bar12345Bar12345";
    private static Key aesKey = new SecretKeySpec(key.getBytes(), "AES");

    @Provides
    ProfilesConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(ProfilesConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        this.panel = this.injector.getInstance(ProfilesPanel.class);
        BufferedImage icon = ImageUtil.getResourceStreamFromClass(this.getClass(), "/net/runelite/client/plugins/profiles/profiles_icon.png");
        this.navButton = NavigationButton.builder().tooltip("Profiles").icon(icon).priority(8).panel(this.panel).build();
        this.clientToolbar.addNavigation(this.navButton);
    }

    @Override
    protected void shutDown() {
        this.clientToolbar.removeNavigation(this.navButton);
    }
    
    @Subscribe
    private void onConfigChanged(ConfigChanged event) throws Exception {
        if (event.getGroup().equals("profiles") && event.getKey().equals("rememberPassword")) {
            this.panel = this.injector.getInstance(ProfilesPanel.class);
            this.shutDown();
            this.startUp();
        }
    }

    public static String decryptText(String text) {
        byte[] bb = new byte[text.length()];
        for (int i = 0; i < text.length(); ++i) {
            bb[i] = (byte)text.charAt(i);
        }
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        try {
            cipher.init(2, aesKey);
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            Logger.getLogger("EncryptionLogger").info("Decrypted " + text + " to " + new String(cipher.doFinal(bb)));
            return new String(cipher.doFinal(bb));
        }
        catch (BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encryptText(String text) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : encrypted) {
                sb.append((char)b);
            }
            Logger.getLogger("EncryptionLogger").info("Encrypted " + text + " to " + sb.toString());
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        catch (BadPaddingException e) {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }
}


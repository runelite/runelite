/*
 * Decompiled with CFR 0.139.
 */
package net.runelite.client.plugins.profiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.client.plugins.profiles.ProfilePanel;
import net.runelite.client.plugins.profiles.ProfilesConfig;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ProfilesPanel
extends PluginPanel {
    private static final Logger log = LoggerFactory.getLogger(ProfilesPanel.class);
    private static final String ACCOUNT_USERNAME = "Account Username";
    private static final String ACCOUNT_LABEL = "Account Label";
    private static final String PASSWORD_LABEL = "Account Password";
    private static final Dimension PREFERRED_SIZE = new Dimension(205, 30);
    private static final Dimension MINIMUM_SIZE = new Dimension(0, 30);
    private final Client client;
    private static ProfilesConfig profilesConfig;
    private final JTextField txtAccountLabel = new JTextField("Account Label");
    private final JPasswordField txtAccountLogin = new JPasswordField("Account Username");
    private final JPasswordField txtPasswordLogin = new JPasswordField("Account Password");
    private final JPanel profilesPanel = new JPanel();
    private GridBagConstraints c;

    @Inject
    public ProfilesPanel(Client client, final ProfilesConfig config) {
        this.client = client;
        profilesConfig = config;
        this.setBorder(new EmptyBorder(18, 10, 0, 10));
        this.setBackground(ColorScheme.DARK_GRAY_COLOR);
        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();
        this.c.fill = 2;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.weightx = 1.0;
        this.c.weighty = 0.0;
        this.c.insets = new Insets(0, 0, 4, 0);
        this.txtAccountLabel.setPreferredSize(PREFERRED_SIZE);
        this.txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
        this.txtAccountLabel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        this.txtAccountLabel.setMinimumSize(MINIMUM_SIZE);
        this.txtAccountLabel.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if (ProfilesPanel.this.txtAccountLabel.getText().equals(ProfilesPanel.ACCOUNT_LABEL)) {
                    ProfilesPanel.this.txtAccountLabel.setText("");
                    ProfilesPanel.this.txtAccountLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ProfilesPanel.this.txtAccountLabel.getText().isEmpty()) {
                    ProfilesPanel.this.txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
                    ProfilesPanel.this.txtAccountLabel.setText(ProfilesPanel.ACCOUNT_LABEL);
                }
            }
        });
        this.add((Component)this.txtAccountLabel, this.c);
        ++this.c.gridy;
        this.txtAccountLogin.setEchoChar('\u0000');
        this.txtAccountLogin.setPreferredSize(PREFERRED_SIZE);
        this.txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
        this.txtAccountLogin.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        this.txtAccountLogin.setMinimumSize(MINIMUM_SIZE);
        this.txtAccountLogin.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if (ProfilesPanel.ACCOUNT_USERNAME.equals(String.valueOf(ProfilesPanel.this.txtAccountLogin.getPassword()))) {
                    ProfilesPanel.this.txtAccountLogin.setText("");
                    if (config.isStreamerMode()) {
                        ProfilesPanel.this.txtAccountLogin.setEchoChar('*');
                    }
                    ProfilesPanel.this.txtAccountLogin.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ProfilesPanel.this.txtAccountLogin.getPassword().length == 0) {
                    ProfilesPanel.this.txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
                    ProfilesPanel.this.txtAccountLogin.setText(ProfilesPanel.ACCOUNT_USERNAME);
                    ProfilesPanel.this.txtAccountLogin.setEchoChar('\u0000');
                }
            }
        });
        this.add((Component)this.txtAccountLogin, this.c);
        ++this.c.gridy;
        this.txtPasswordLogin.setEchoChar('\u0000');
        this.txtPasswordLogin.setPreferredSize(PREFERRED_SIZE);
        this.txtPasswordLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
        this.txtPasswordLogin.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        this.txtPasswordLogin.setToolTipText("Account password");
        this.txtPasswordLogin.setMinimumSize(MINIMUM_SIZE);
        this.txtPasswordLogin.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if (ProfilesPanel.PASSWORD_LABEL.equals(String.valueOf(ProfilesPanel.this.txtPasswordLogin.getPassword()))) {
                    ProfilesPanel.this.txtPasswordLogin.setText("");
                    ProfilesPanel.this.txtPasswordLogin.setEchoChar('*');
                    ProfilesPanel.this.txtPasswordLogin.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ProfilesPanel.this.txtPasswordLogin.getPassword().length == 0) {
                    ProfilesPanel.this.txtPasswordLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
                    ProfilesPanel.this.txtPasswordLogin.setText(ProfilesPanel.PASSWORD_LABEL);
                    ProfilesPanel.this.txtPasswordLogin.setEchoChar('\u0000');
                }
            }
        });
        if (config.rememberPassword()) {
            this.add((Component)this.txtPasswordLogin, this.c);
            ++this.c.gridy;
        }
        this.c.insets = new Insets(0, 0, 15, 0);
        final JButton btnAddAccount = new JButton("Add Account");
        btnAddAccount.setPreferredSize(PREFERRED_SIZE);
        btnAddAccount.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        btnAddAccount.setMinimumSize(MINIMUM_SIZE);
        btnAddAccount.addActionListener(e -> {
            String labelText = String.valueOf(this.txtAccountLabel.getText());
            String loginText = String.valueOf(this.txtAccountLogin.getPassword());
            String passwordText = String.valueOf(this.txtPasswordLogin.getPassword());
            if (labelText.equals(ACCOUNT_LABEL) || loginText.equals(ACCOUNT_USERNAME)) {
                return;
            }
            String data = config.rememberPassword() && this.txtPasswordLogin.getPassword() != null ? labelText + ":" + loginText + ":" + passwordText : labelText + ":" + loginText;
            log.info(data);
            this.addAccount(data);
            ProfilesPanel.addProfile(data);
            this.txtAccountLabel.setText(ACCOUNT_LABEL);
            this.txtAccountLabel.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
            this.txtAccountLogin.setText(ACCOUNT_USERNAME);
            this.txtAccountLogin.setEchoChar('\u0000');
            this.txtAccountLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
            this.txtPasswordLogin.setText(PASSWORD_LABEL);
            this.txtPasswordLogin.setEchoChar('\u0000');
            this.txtPasswordLogin.setForeground(ColorScheme.MEDIUM_GRAY_COLOR);
        });
        this.txtAccountLogin.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    btnAddAccount.doClick();
                    btnAddAccount.requestFocus();
                }
            }
        });
        this.txtAccountLogin.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.add((Component)btnAddAccount, this.c);
        ++this.c.gridy;
        this.profilesPanel.setLayout(new GridBagLayout());
        this.add((Component)this.profilesPanel, this.c);
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 0, 5, 0);
        this.addAccounts(config.profilesData());
    }

    void redrawProfiles() {
        this.profilesPanel.removeAll();
        this.c.gridy = 0;
        this.addAccounts(profilesConfig.profilesData());
    }

    private void addAccount(String data) {
        ProfilePanel profile = new ProfilePanel(this.client, data, profilesConfig);
        ++this.c.gridy;
        this.profilesPanel.add((Component)profile, this.c);
        this.revalidate();
        this.repaint();
    }

    void addAccounts(String data) {
        if (!(data = data.trim()).contains(":")) {
            return;
        }
        Arrays.stream(data.split("\\n")).forEach(this::addAccount);
    }

    static void addProfile(String data) {
        profilesConfig.profilesData(profilesConfig.profilesData() + data + "\n");
    }

    static void removeProfile(String data) {
        profilesConfig.profilesData(profilesConfig.profilesData().replaceAll(data + "\\n", ""));
    }

}


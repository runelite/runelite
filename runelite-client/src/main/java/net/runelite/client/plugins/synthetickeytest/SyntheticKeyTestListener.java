package net.runelite.client.plugins.synthetickeytest;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.input.MouseAdapter;

class SyntheticKeyTestListener extends MouseAdapter {
    @Inject
    private SyntheticKeyTestPlugin plugin;

    @Inject
    private SyntheticKeyTestConfig config;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;


    @Override
    public MouseEvent mousePressed(MouseEvent me) {
        int mappedKeyCode = KeyEvent.VK_UNDEFINED;

        if (me.getButton() > 3)
        {
            me.consume();
        }

        if (config.f1().matches(me)) {
            mappedKeyCode = KeyEvent.VK_F1;
        }

        if (mappedKeyCode != KeyEvent.VK_UNDEFINED) {
            int modifiers = me.getModifiersEx();
            long now = System.currentTimeMillis();

            KeyEvent syntheticKeyPress = new KeyEvent(
                    me.getComponent(),
                    KeyEvent.KEY_PRESSED,
                    now,
                    modifiers,
                    mappedKeyCode,
                    KeyEvent.CHAR_UNDEFINED
            );


            clientThread.invokeLater(() ->
            {
                client.getCanvas().dispatchEvent(syntheticKeyPress);
            });
        }

        return me;
    }

    @Override
    public MouseEvent mouseReleased(MouseEvent me) {
        int mappedKeyCode = KeyEvent.VK_UNDEFINED;

        if (config.f1().matches(me)) {
            mappedKeyCode = KeyEvent.VK_F1;
        }

        if (mappedKeyCode != KeyEvent.VK_UNDEFINED) {
            int modifiers = me.getModifiersEx();

            KeyEvent syntheticKeyRelease = new KeyEvent(
                    me.getComponent(),
                    KeyEvent.KEY_RELEASED,
                    System.currentTimeMillis(),
                    modifiers,
                    mappedKeyCode,
                    KeyEvent.CHAR_UNDEFINED
            );

            clientThread.invokeLater(() -> client.getCanvas().dispatchEvent(syntheticKeyRelease));
        }

        return me;
    }
}
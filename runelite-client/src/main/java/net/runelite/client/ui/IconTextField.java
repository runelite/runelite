package net.runelite.client.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class IconTextField extends JTextField
{
    private Border border;
    private Icon icon;

    @Override
    public void setBorder(Border border)
    {
        this.border = border;

        if (icon == null)
        {
            super.setBorder(border);
        }
        else
        {
            Border margin = BorderFactory.createEmptyBorder(0, icon.getIconWidth() + 4, 0, 0);
            Border compound = BorderFactory.createCompoundBorder(border, margin);
            super.setBorder(compound);
        }
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Insets iconInsets = border.getBorderInsets(this);
        icon.paintIcon(this, graphics, iconInsets.left, iconInsets.top);
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        resetBorder();
    }

    private void resetBorder() {
        setBorder(border);
    }
}

package net.runelite.client.ui.overlay.examinebox;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;


@Data
public class ExamineBox
{
    private String text;
    private LayoutableRenderableEntity component;

    @Getter
    @Setter
    private int x;
    private int y;

    public ExamineBox(final String text, final int x, final int y)
    {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public ExamineBox(final LayoutableRenderableEntity component)
    {
        this.component = component;
    }
}

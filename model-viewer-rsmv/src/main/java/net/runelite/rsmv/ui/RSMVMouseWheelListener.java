package net.runelite.rsmv.ui;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import net.runelite.rsmv.Main;

public final class RSMVMouseWheelListener implements MouseWheelListener {
   // $FF: synthetic field
   private Main field30;

   public RSMVMouseWheelListener(Main var1) {
      this.field30 = var1;
   }

   public final void mouseWheelMoved(MouseWheelEvent var1) {
      Main.mouseWheelMoved(this.field30, var1);
   }
}

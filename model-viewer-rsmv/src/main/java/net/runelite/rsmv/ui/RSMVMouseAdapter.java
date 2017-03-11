package net.runelite.rsmv.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.runelite.rsmv.Main;

public final class RSMVMouseAdapter extends MouseAdapter {
   // $FF: synthetic field
   private Main field6;

   public RSMVMouseAdapter(Main var1) {
      this.field6 = var1;
   }

   public final void mousePressed(MouseEvent var1) {
   }

   public final void mouseReleased(MouseEvent var1) {
      Main.mouseReleasedCallback(this.field6, var1);
   }
}

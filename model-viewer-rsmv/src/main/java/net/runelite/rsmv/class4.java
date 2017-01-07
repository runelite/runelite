package net.runelite.rsmv;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final class class4 extends MouseAdapter {
   // $FF: synthetic field
   private Main field6;

   class4(Main var1) {
      this.field6 = var1;
   }

   public final void mousePressed(MouseEvent var1) {
   }

   public final void mouseReleased(MouseEvent var1) {
      Main.method15(this.field6, var1);
   }
}

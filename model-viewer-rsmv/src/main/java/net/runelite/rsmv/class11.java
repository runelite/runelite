package net.runelite.rsmv;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

final class class11 implements MouseWheelListener {
   // $FF: synthetic field
   private Main field30;

   class11(Main var1) {
      this.field30 = var1;
   }

   public final void mouseWheelMoved(MouseWheelEvent var1) {
      Main.method14(this.field30, var1);
   }
}

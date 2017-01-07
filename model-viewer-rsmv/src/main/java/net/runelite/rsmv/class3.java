package net.runelite.rsmv;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

final class class3 extends ComponentAdapter {
   // $FF: synthetic field
   private Main field5;

   class3(Main var1) {
      this.field5 = var1;
   }

   public final void componentResized(ComponentEvent var1) {
      Main.method16(this.field5, var1);
   }
}

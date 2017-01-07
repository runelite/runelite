package net.runelite.rsmv;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class class12 extends WindowAdapter {
   // $FF: synthetic field
   private Main field31;

   class12(Main var1) {
      this.field31 = var1;
   }

   public final void windowClosing(WindowEvent var1) {
      Main.method13(this.field31, var1);
   }
}

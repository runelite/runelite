package net.runelite.rsmv;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

final class class1 extends MouseMotionAdapter {
   // $FF: synthetic field
   private Main field1;

   class1(Main var1) {
      this.field1 = var1;
   }

   public final void mouseDragged(MouseEvent var1) {
      Main.method17(this.field1, var1);
   }
}

package net.runelite.rsmv;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

final class class0 implements ListSelectionListener {
   // $FF: synthetic field
   private Main field0;

   class0(Main var1) {
      this.field0 = var1;
   }

   public final void valueChanged(ListSelectionEvent var1) {
      Main.method18(this.field0, var1);
   }
}

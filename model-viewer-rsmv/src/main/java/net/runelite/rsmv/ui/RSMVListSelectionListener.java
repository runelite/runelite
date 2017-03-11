package net.runelite.rsmv.ui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.runelite.rsmv.Main;

public final class RSMVListSelectionListener implements ListSelectionListener {
   // $FF: synthetic field
   private Main field0;

   public RSMVListSelectionListener(Main var1) {
      this.field0 = var1;
   }

   public final void valueChanged(ListSelectionEvent var1) {
      Main.listSelectionValueChanged(this.field0, var1);
   }
}

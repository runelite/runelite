package net.runelite.rsmv.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.runelite.rsmv.Main;

public final class RSMVWindowAdapter extends WindowAdapter {
   // $FF: synthetic field
   private Main field31;

   public RSMVWindowAdapter(Main var1) {
      this.field31 = var1;
   }

   public final void windowClosing(WindowEvent var1) {
      Main.windowClosingCallback(this.field31, var1);
   }
}

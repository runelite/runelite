package net.runelite.rsmv.ui;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import net.runelite.rsmv.Main;

public final class RSMVComponentAdapter extends ComponentAdapter {
   // $FF: synthetic field
   private Main field5;

   public RSMVComponentAdapter(Main var1) {
      this.field5 = var1;
   }

   public final void componentResized(ComponentEvent var1) {
      Main.componentResizedCallback(this.field5, var1);
   }
}

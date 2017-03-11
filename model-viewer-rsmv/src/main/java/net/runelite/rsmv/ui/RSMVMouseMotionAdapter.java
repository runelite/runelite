package net.runelite.rsmv.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import net.runelite.rsmv.Main;

public final class RSMVMouseMotionAdapter extends MouseMotionAdapter {
   // $FF: synthetic field
   private Main field1;

   public RSMVMouseMotionAdapter(Main var1) {
      this.field1 = var1;
   }

   public final void mouseDragged(MouseEvent var1) {
      Main.mouseDragged(this.field1, var1);
   }
}

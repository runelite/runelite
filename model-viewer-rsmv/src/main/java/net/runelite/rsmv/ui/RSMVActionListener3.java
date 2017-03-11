package net.runelite.rsmv.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.runelite.rsmv.Main;

public final class RSMVActionListener3 implements ActionListener {
   // $FF: synthetic field
   private Main field29;

   public RSMVActionListener3(Main var1) {
      this.field29 = var1;
   }

   public final void actionPerformed(ActionEvent var1) {
      Main.actionListenerCallback3(this.field29, var1);
   }
}

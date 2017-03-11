package net.runelite.rsmv.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.runelite.rsmv.Main;

public final class RSMVActionListener2 implements ActionListener {
   // $FF: synthetic field
   private Main field27;

   public RSMVActionListener2(Main var1) {
      this.field27 = var1;
   }

   public final void actionPerformed(ActionEvent var1) {
      Main.actionListenerCallback2(this.field27, var1);
   }
}

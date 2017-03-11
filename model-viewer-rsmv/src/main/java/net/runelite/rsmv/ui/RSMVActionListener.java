package net.runelite.rsmv.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.runelite.rsmv.Main;

public final class RSMVActionListener implements ActionListener {
   // $FF: synthetic field
   private Main field28;

   public RSMVActionListener(Main var1) {
      this.field28 = var1;
   }

   public final void actionPerformed(ActionEvent var1) {
      Main.actionListenerCallback(this.field28, var1);
   }
}

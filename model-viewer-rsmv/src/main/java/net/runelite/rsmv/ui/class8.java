package net.runelite.rsmv.ui;

import net.runelite.rsmv.Main;
import net.runelite.rsmv.Model;

public final class class8 implements Runnable {
   public final void run() {
      Main var1;
      (var1 = new Main()).setTitle("Runescape Model Viewer v0.3");
      var1.method10();
      var1.setVisible(true);
      var1.method9();
      (new Thread(var1)).start();
      Model.method33(1);
   }
}

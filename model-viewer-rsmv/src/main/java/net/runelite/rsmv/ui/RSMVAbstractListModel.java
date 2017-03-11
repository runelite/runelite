package net.runelite.rsmv.ui;

import javax.swing.AbstractListModel;
import net.runelite.rsmv.Main;

public final class RSMVAbstractListModel extends AbstractListModel {
   private String[] field24;
   // $FF: synthetic field
   private int field25;
   // $FF: synthetic field
   private String[] field26;

   public RSMVAbstractListModel(Main var1, int var2, String[] var3) {
      this.field25 = var2;
      this.field26 = var3;
      this.field24 = this.field26;
   }

   public final int getSize() {
      return this.field24.length;
   }

   public final Object getElementAt(int var1) {
      return this.field24[var1];
   }
}

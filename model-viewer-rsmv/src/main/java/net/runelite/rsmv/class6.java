package net.runelite.rsmv;

import javax.swing.AbstractListModel;

final class class6 extends AbstractListModel {
   private String[] field24;
   // $FF: synthetic field
   private int field25;
   // $FF: synthetic field
   private String[] field26;

   class6(Main var1, int var2, String[] var3) {
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

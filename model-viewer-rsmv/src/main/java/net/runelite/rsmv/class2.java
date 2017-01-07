package net.runelite.rsmv;

import javax.swing.AbstractListModel;

final class class2 extends AbstractListModel {
   private String[] field2;
   // $FF: synthetic field
   private int field3;
   // $FF: synthetic field
   private String[] field4;

   class2(Main var1, int var2, String[] var3) {
      this.field3 = var2;
      this.field4 = var3;
      this.field2 = this.field4;
   }

   public final int getSize() {
      return this.field2.length;
   }

   public final Object getElementAt(int var1) {
      return this.field2[var1];
   }
}

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class0 implements Comparator {
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 1752216023
   )
   public static int field1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1406785875
   )
   public static int field2;
   @ObfuscatedName("bm")
   static class184 field4;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2066724465"
   )
   static void method1(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2340(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-578642638"
   )
   int method5(class2 var1, class2 var2) {
      return var1.field22 < var2.field22?-1:(var2.field22 == var1.field22?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5((class2)var1, (class2)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "1159254659"
   )
   static void method8(class18 var0) {
      class49.method871(var0, 200000);
   }
}

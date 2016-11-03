import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
final class class219 implements Comparator {
   @ObfuscatedName("n")
   static String field3210;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "4"
   )
   int method3987(class217 var1, class217 var2) {
      return var1.field3198.totalQuantity < var2.field3198.totalQuantity?-1:(var2.field3198.totalQuantity == var1.field3198.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3987((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-339374236"
   )
   public static int method3992(int var0) {
      class50 var1 = ClassInfo.method3965(var0);
      int var2 = var1.field1103;
      int var3 = var1.field1101;
      int var4 = var1.field1105;
      int var5 = class179.field2953[var4 - var3];
      return class179.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-563684897"
   )
   static void method3994(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field645[var5]) {
            var2[var4] = World.field645[var5];
            var3[var4] = World.field644[var5];
            ++var4;
         }
      }

      World.field645 = var2;
      World.field644 = var3;
      class165.method3231(ItemComposition.worldList, 0, ItemComposition.worldList.length - 1, World.field645, World.field644);
   }
}

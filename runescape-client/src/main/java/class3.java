import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class3 implements Comparator {
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = 1919813983
   )
   static int field29;
   @ObfuscatedName("v")
   static int[] field31;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -424683121
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("ef")
   static ModIcon[] field37;
   @ObfuscatedName("p")
   public static class182 field38;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-323449322"
   )
   int method33(class2 var1, class2 var2) {
      return var1.field18.totalQuantity < var2.field18.totalQuantity?-1:(var2.field18.totalQuantity == var1.field18.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method33((class2)var1, (class2)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1542500520"
   )
   public static final void method36(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class57.field1047 = var0;
         class57.field1042 = var1;
         class211.field3122 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1390608060"
   )
   static final boolean method42(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field331 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field550.method3121(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field550.method3122(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field550.method3123(false);
         }

         if(var1 == 325) {
            Client.field550.method3123(true);
         }

         if(var1 == 326) {
            Client.field394.method3037(32);
            Client.field550.method3124(Client.field394);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2128459924"
   )
   public static int method43(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}

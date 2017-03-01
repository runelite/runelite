import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class6 implements Comparator {
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -94590391
   )
   static int field41;
   @ObfuscatedName("j")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 2061412465
   )
   static int field43;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -25160799
   )
   static int field44;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1399717497
   )
   static int field54;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "286028365"
   )
   int method82(class2 var1, class2 var2) {
      return var1.method30().compareTo(var2.method30());
   }

   public int compare(Object var1, Object var2) {
      return this.method82((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1922256343"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class188.method3520(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "50"
   )
   static final int method86(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)V",
      garbageValue = "-48"
   )
   public static void method90(class182 var0, class182 var1) {
      KitDefinition.field2829 = var0;
      KitDefinition.field2822 = var1;
      KitDefinition.field2831 = KitDefinition.field2829.method3352(3);
   }
}

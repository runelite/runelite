import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class37 {
   @ObfuscatedName("ag")
   static class184 field780;
   @ObfuscatedName("n")
   static int[] field784;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "579508153"
   )
   public static SpritePixels method717(class182 var0, int var1, int var2) {
      return !method718(var0, var1, var2)?null:FloorUnderlayDefinition.method3373();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-1316607095"
   )
   static boolean method718(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class9.method98(var3);
         return true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "2101281591"
   )
   static final int method719(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1453[var2 * 1024 / var3] >> 1;
      return (var1 * var4 >> 16) + (var0 * (65536 - var4) >> 16);
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class161 {
   @ObfuscatedName("eh")
   static SpritePixels[] field2129;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2103530990"
   )
   static void method3070(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field674[var5]) {
            var2[var4] = World.field674[var5];
            var3[var4] = World.field676[var5];
            ++var4;
         }
      }

      World.field674 = var2;
      World.field676 = var3;
      VertexNormal.method1597(World.worldList, 0, World.worldList.length - 1, World.field674, World.field676);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;B)I",
      garbageValue = "0"
   )
   public static int method3071(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method3072() {
      if(class97.loadWorlds()) {
         class41.worldSelectShown = true;
      }

   }
}

import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class148 extends RuntimeException {
   @ObfuscatedName("h")
   public static String field2201;
   @ObfuscatedName("j")
   static Applet field2202;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -1111382365
   )
   static int field2203;
   @ObfuscatedName("z")
   String field2204;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 69257817
   )
   static int field2205;
   @ObfuscatedName("x")
   Throwable field2206;

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1139321852"
   )
   static final int method3106(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field84[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class5.field91[var5][var3][var4] * (128 - var6) + var6 * class5.field91[var5][var3 + 1][var4] >> 7;
         int var9 = var6 * class5.field91[var5][1 + var3][var4 + 1] + (128 - var6) * class5.field91[var5][var3][1 + var4] >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}

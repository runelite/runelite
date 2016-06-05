import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class14 {
   @ObfuscatedName("f")
   static int[] field209;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -143661267
   )
   int field210 = -1;
   @ObfuscatedName("g")
   int[] field211;
   @ObfuscatedName("h")
   String[] field212;
   @ObfuscatedName("s")
   static int[] field213;
   @ObfuscatedName("eu")
   static class78[] field214;
   @ObfuscatedName("t")
   class22 field215;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2075941836"
   )
   public static String method145(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "-2015643155"
   )
   static boolean method146(class173 var0) {
      if(client.field452) {
         if(class138.method2906(var0) != 0) {
            return false;
         }

         if(var0.field2778 == 0) {
            return false;
         }
      }

      return var0.field2875;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-116785458"
   )
   static final int method147(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field83[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class5.field100[var5][var3][var4] + var6 * class5.field100[var5][var3 + 1][var4] >> 7;
         int var9 = class5.field100[var5][1 + var3][1 + var4] * var6 + (128 - var6) * class5.field100[var5][var3][1 + var4] >> 7;
         return var7 * var9 + (128 - var7) * var8 >> 7;
      } else {
         return 0;
      }
   }
}

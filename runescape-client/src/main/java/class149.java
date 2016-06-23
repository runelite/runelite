import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class149 {
   @ObfuscatedName("o")
   public static class228 field2232 = null;
   @ObfuscatedName("k")
   public static class228 field2237 = null;
   @ObfuscatedName("e")
   public static String[] field2238;
   @ObfuscatedName("c")
   public static String field2239;
   @ObfuscatedName("r")
   public static class228 field2241 = null;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1326930315
   )
   static int field2242;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   static final void method3162() {
      for(class16 var0 = (class16)client.field421.method3852(); null != var0; var0 = (class16)client.field421.method3857()) {
         if(var0.field239 == -1) {
            var0.field232 = 0;
            class23.method626(var0);
         } else {
            var0.method3946();
         }
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIII)V",
      garbageValue = "1637463352"
   )
   static final void method3163(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field537) {
         client.field372 = 32;
      } else {
         client.field372 = 0;
      }

      client.field537 = false;
      int var7;
      if(class140.field2144 == 1 || !class148.field2224 && class140.field2144 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2776 -= 4;
            class39.method818(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.field2776 += 4;
            class39.method818(var0);
         } else if(var5 >= var1 - client.field372 && var5 < var1 + 16 + client.field372 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2776 = var8 * (var4 - var3) / var9;
            class39.method818(var0);
            client.field537 = true;
         }
      }

      if(client.field485 != 0) {
         var7 = var0.field2769;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.field2776 += client.field485 * 45;
            class39.method818(var0);
         }
      }

   }
}

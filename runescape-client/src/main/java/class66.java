import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class66 {
   @ObfuscatedName("ms")
   @ObfuscatedSignature(
      signature = "[Lin;"
   )
   static Widget[] field785;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "9"
   )
   static String method1132(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class317.field3926[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class317.field3926[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class317.field3926[(var6 & 15) << 2 | var7 >>> 6]).append(class317.field3926[var7 & 63]);
            } else {
               var3.append(class317.field3926[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class317.field3926[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}

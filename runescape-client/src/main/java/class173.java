import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class173 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1550636618"
   )
   public static String method3149(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class206.field3093[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class206.field3093[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class206.field3093[(var6 & 15) << 2 | var7 >>> 6]).append(class206.field3093[var7 & 63]);
            } else {
               var3.append(class206.field3093[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class206.field3093[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}

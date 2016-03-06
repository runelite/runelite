package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ab")
public class class26 {
   @ObfuscatedName("ps")
   public static class135 field648;
   @ObfuscatedName("t")
   static String field663;

   @ObfuscatedName("j")
   public static class43 method635(int var0) {
      class43 var1 = (class43)class43.field1008.method3711((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class43.field1016.method3214(13, var0);
         var1 = new class43();
         var1.field1022 = var0;
         if(null != var2) {
            var1.method904(new class118(var2));
         }

         class43.field1008.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   public static String method636(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class160.field2650[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class160.field2650[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class160.field2650[(var6 & 15) << 2 | var7 >>> 6]).append(class160.field2650[var7 & 63]);
            } else {
               var3.append(class160.field2650[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class160.field2650[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}

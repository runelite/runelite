import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class1 {
   @ObfuscatedName("m")
   static class154 field21;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "656053538"
   )
   static final int method9(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = (789221 + var2 * var2 * 15731) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "64"
   )
   static final void method13(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class41.field985[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class5.field94[0][var5][var4] = class5.field94[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class5.field94[0][var5][var4] = class5.field94[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field94[0][var5][var4] = class5.field94[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class5.field94[0][var5][var4] = class5.field94[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1215156148"
   )
   public static String method14(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class138.method3044(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && 63 != var5 && 33 != var5) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}

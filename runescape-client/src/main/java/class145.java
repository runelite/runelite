import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class145 {
   @ObfuscatedName("d")
   public static class170 field2245;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "92"
   )
   static long method3016(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(1 + var5 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-123"
   )
   public static int method3020(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
public class class187 {
   @ObfuscatedName("gf")
   public static final int[] field3029 = new int[]{0, 0, 0, 0, -2, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, -2, 0, 2, 6, 0, 0, 0, 1, 2, 7, 0, -2, 0, -2, 0, 12, 0, 0, 28, 6, 0, 0, -2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 2, 2, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 6, 0, 15, 0, 0, 0, 5, 0, 0, 0, 8, 0, 0, 0, 14, 0, 10, 8, 6, 0, -2, 0, 0, 4, 4, 0, -2, 2, 1, -1, 0, 0, 0, 0, 0, 4, -2, -2, 0, 0, 0, 0, 0, 0, 0, 6, 0, 6, 0, -1, -2, 0, 0, 2, 0, -2, 0, 0, 0, -2, 6, 0, 6, 0, 2, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 20, 0, 0, -2, 0, 0, 2, 0, 0, 0, 5, -2, -2, 0, 0, 5, 0, -2, 1, 0, 0, 0, 0, 0, 0, -2, 2, 0, 0, 0, -1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 0, 0, 6, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 8, 0, 7, 0, 0, 6, -2, 0, 6, 0, 0, 0, 0, 4};

   @ObfuscatedName("a")
   public static boolean method3783(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label90: {
            char var7 = var0.charAt(var6);
            if(0 == var6) {
               if(45 == var7) {
                  var2 = true;
                  break label90;
               }

               if(43 == var7) {
                  break label90;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var8 / 10 != var4) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }
}

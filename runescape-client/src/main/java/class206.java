import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class206 {
   @ObfuscatedName("p")
   static char[] field3080 = new char[64];
   @ObfuscatedName("x")
   static int[] field3081;
   @ObfuscatedName("g")
   static char[] field3084;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-20"
   )
   static int method3819(CharSequence var0, int var1, boolean var2) {
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

            int var9 = var1 * var5 + var10;
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

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3080[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3080[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3080[var0] = (char)(48 + var0 - 52);
      }

      field3080[62] = 43;
      field3080[63] = 47;
      field3084 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3084[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3084[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3084[var0] = (char)(48 + var0 - 52);
      }

      field3084[62] = 42;
      field3084[63] = 45;
      field3081 = new int[128];

      for(var0 = 0; var0 < field3081.length; ++var0) {
         field3081[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3081[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3081[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3081[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3081;
      field3081[43] = 62;
      var2[42] = 62;
      int[] var1 = field3081;
      field3081[47] = 63;
      var1[45] = 63;
   }

   class206() throws Throwable {
      throw new Error();
   }
}

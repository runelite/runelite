import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public class class269 {
   @ObfuscatedName("t")
   static SpritePixels field3672;
   @ObfuscatedName("h")
   static char[] field3673;
   @ObfuscatedName("u")
   static int[] field3674;
   @ObfuscatedName("l")
   public static IndexDataBase field3677;
   @ObfuscatedName("i")
   public static char[] field3679;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "2132531969"
   )
   public static boolean method4931(CharSequence var0) {
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

         label94: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label94;
               }

               if(var7 == 43) {
                  break label94;
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

            int var8 = var9 + var4 * 10;
            if(var4 != var8 / 10) {
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

   static {
      field3679 = new char[64];

      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3679[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3679[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3679[var0] = (char)(var0 + 48 - 52);
      }

      field3679[62] = 43;
      field3679[63] = 47;
      field3673 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3673[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3673[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3673[var0] = (char)(var0 + 48 - 52);
      }

      field3673[62] = 42;
      field3673[63] = 45;
      field3674 = new int[128];

      for(var0 = 0; var0 < field3674.length; ++var0) {
         field3674[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3674[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3674[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3674[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3674;
      field3674[43] = 62;
      var2[42] = 62;
      int[] var1 = field3674;
      field3674[47] = 63;
      var1[45] = 63;
   }
}

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class12 implements Comparator {
   @ObfuscatedName("at")
   static class231 field275;
   @ObfuscatedName("kp")
   static Widget field280;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "7"
   )
   public static int method63(CharSequence var0, int var1, boolean var2) {
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

            int var9 = var10 + var1 * var5;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1446700114"
   )
   int method64(class14 var1, class14 var2) {
      return var1.field297 < var2.field297?-1:(var1.field297 == var2.field297?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-435327105"
   )
   static int method70(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   public int compare(Object var1, Object var2) {
      return this.method64((class14)var1, (class14)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)LFont;",
      garbageValue = "249954231"
   )
   public static Font method74(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class286.field3793, class286.field3794, class286.field3791, class149.field2211, class116.field1686, class286.field3797);
         class286.field3793 = null;
         class286.field3794 = null;
         class286.field3791 = null;
         class149.field2211 = null;
         class116.field1686 = null;
         class286.field3797 = null;
         return var1;
      }
   }
}

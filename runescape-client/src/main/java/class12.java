import java.util.Comparator;

import net.runelite.mapping.Export;
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
   @Export("parseInt")
   public static int parseInt(CharSequence characters, int radix, boolean var2) {
      if(radix >= 2 && radix <= 36) {
         boolean negative = false;
         boolean var4 = false;
         int var5 = 0;
         int length = characters.length();

         for(int index = 0; index < length; ++index) {
            char character = characters.charAt(index);
            if(index == 0) {
               if(character == 45) {
                  negative = true;
                  continue;
               }

               if(character == 43) {
                  continue;
               }
            }

            int var9;
            if(character >= 48 && character <= 57) {
               var9 = character - 48;
            } else if(character >= 65 && character <= 90) {
               var9 = character - 55;
            } else {
               if(character < 97 || character > 122) {
                  throw new NumberFormatException();
               }

               var9 = character - 87;
            }

            if(var9 >= radix) {
               throw new NumberFormatException();
            }

            if(negative) {
               var9 = -var9;
            }

            int var10 = var9 + radix * var5;
            if(var5 != var10 / radix) {
               throw new NumberFormatException();
            }

            var5 = var10;
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
         class286.field3797 = (byte[][])null;
         return var1;
      }
   }
}

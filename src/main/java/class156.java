import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class156 {
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 39048027
   )
   @Export("cameraZ")
   static int field2333;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "3"
   )
   public static void method3193(class119 var0, int var1) {
      if(class149.field2252 != null) {
         try {
            class149.field2252.method4169(0L);
            class149.field2252.method4157(var0.field2012, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1"
   )
   static int method3194(CharSequence var0, int var1) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var2 = false;
         boolean var3 = false;
         int var4 = 0;
         int var5 = var0.length();

         for(int var6 = 0; var6 < var5; ++var6) {
            char var7 = var0.charAt(var6);
            if(0 == var6) {
               if(var7 == 45) {
                  var2 = true;
                  continue;
               }

               if(var7 == 43) {
                  continue;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  throw new NumberFormatException();
               }

               var9 = var7 - 87;
            }

            if(var9 >= var1) {
               throw new NumberFormatException();
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var1 * var4;
            if(var4 != var8 / var1) {
               throw new NumberFormatException();
            }

            var4 = var8;
            var3 = true;
         }

         if(!var3) {
            throw new NumberFormatException();
         } else {
            return var4;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}

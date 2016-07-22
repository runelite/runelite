import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class20 extends class211 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1956243447
   )
   int field556;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2067262135
   )
   int field557;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1791631573
   )
   int field558;
   @ObfuscatedName("bc")
   static class171 field559;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -1325590561
   )
   static int field560;
   @ObfuscatedName("mi")
   static class81 field561;
   @ObfuscatedName("jx")
   static class176[] field563;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1459955613
   )
   int field565;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1555561183"
   )
   void method552(int var1, int var2, int var3, int var4) {
      this.field565 = var1;
      this.field557 = var2;
      this.field556 = var3;
      this.field558 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-726898599"
   )
   static final void method553() {
      if(class158.field2354 != null) {
         class158.field2354.method1250();
      }

      if(class36.field799 != null) {
         class36.field799.method1250();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1905544019"
   )
   public static void method555() {
      class44.field1024.method3814();
      class44.field1012.method3814();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1810253627"
   )
   static void method556() {
      if(class33.field756) {
         class33.field745 = null;
         class33.field731 = null;
         class75.field1421 = null;
         class189.field3054 = null;
         class141.field2199 = null;
         class30.field698 = null;
         class29.field684 = null;
         class33.field732 = null;
         class30.field696 = null;
         class98.field1699 = null;
         class147.field2271 = null;
         class90.field1610 = null;
         class4.field69 = null;
         class26.field639 = null;
         class33.field755 = null;
         class33.field736 = null;
         class98.field1694 = null;
         class132.field2104 = null;
         class33.field739 = null;
         class96.field1672 = null;
         class47.field1064 = null;
         class33.field740 = null;
         class186.field3004 = 1;
         class128.field2089 = null;
         class105.field1834 = -1;
         class186.field3009 = -1;
         class40.field903 = 0;
         class133.field2111 = false;
         class186.field3010 = 2;
         class13.method156(true);
         class33.field756 = false;
      }
   }

   class20(int var1, int var2, int var3, int var4) {
      this.field565 = var1;
      this.field557 = var2;
      this.field556 = var3;
      this.field558 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-15001186"
   )
   public static boolean method557(CharSequence var0, int var1, boolean var2) {
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
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}

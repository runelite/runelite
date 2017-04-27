import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class161 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2060134351
   )
   int field2105;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 641594427
   )
   int field2106;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -671160473
   )
   int field2107;
   @ObfuscatedName("q")
   class158 field2108;
   @ObfuscatedName("c")
   class163 field2109;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1454777195
   )
   int field2110;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -514706485
   )
   int field2111;
   @ObfuscatedName("a")
   class66 field2112;
   @ObfuscatedName("n")
   class55 field2113;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1588719735
   )
   int field2114;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1009465141
   )
   int field2115;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1394582053
   )
   int field2116;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1447932675
   )
   int field2117;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1642721727
   )
   int field2118;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1288656177
   )
   int field2119;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -420020309
   )
   int field2120;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1074578001
   )
   int field2121;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -162520437
   )
   int field2122;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -713038823
   )
   int field2123;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -506764681
   )
   int field2124;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1143966913
   )
   int field2125;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "923803967"
   )
   public static boolean method3023(CharSequence var0) {
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

         label93: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label93;
               }

               if(var7 == 43) {
                  break label93;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-785899601"
   )
   void method3024() {
      this.field2109 = null;
      this.field2113 = null;
      this.field2108 = null;
      this.field2112 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "-1863269509"
   )
   public static Varbit method3027(int var0) {
      Varbit var1 = (Varbit)Varbit.field2867.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.field2866.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method3581(new Buffer(var2));
         }

         Varbit.field2867.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "-121"
   )
   static void method3028(Widget var0, int var1, int var2) {
      if(var0.field2212 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2212 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2212 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2212 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2212 == 4) {
         var0.relativeX = (var1 * var0.originalX >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2206 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2206 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2206 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2206 == 3) {
         var0.relativeY = var0.originalY * var2 >> 14;
      } else if(var0.field2206 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var0.originalY * var2 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field455 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}

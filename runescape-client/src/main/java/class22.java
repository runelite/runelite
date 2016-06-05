import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class22 extends class204 {
   @ObfuscatedName("i")
   int[] field580;
   @ObfuscatedName("h")
   String[] field582;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 75831633
   )
   int field583;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -605268731
   )
   int field584;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1390883187
   )
   int field585;
   @ObfuscatedName("g")
   int[] field586;
   @ObfuscatedName("dd")
   static byte[][] field587;
   @ObfuscatedName("k")
   public static class59 field590;
   @ObfuscatedName("t")
   static class193 field593 = new class193(128);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1111523689
   )
   int field594;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "580630189"
   )
   static final int method561(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var0 / 4 << 10) + (var1 / 32 << 7) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIII)V",
      garbageValue = "541664555"
   )
   static final void method562(class173 var0, int var1, int var2, int var3) {
      class135.method2845();
      class175 var4 = var0.method3375(false);
      if(null != var4) {
         class79.method1753(var1, var2, var4.field2918 + var1, var2 + var4.field2917);
         if(client.field549 != 2 && client.field549 != 5) {
            int var5 = client.field302 + client.field355 & 2047;
            int var6 = 48 + class152.field2301.field809 / 32;
            int var7 = 464 - class152.field2301.field804 / 32;
            class101.field1767.method1736(var1, var2, var4.field2918, var4.field2917, var6, var7, var5, 256 + client.field357, var4.field2920, var4.field2922);

            int var8;
            int var9;
            int var17;
            for(var8 = 0; var8 < client.field310; ++var8) {
               var9 = 4 * client.field411[var8] + 2 - class152.field2301.field809 / 32;
               var17 = 2 + client.field492[var8] * 4 - class152.field2301.field804 / 32;
               class6.method79(var1, var2, var9, var17, client.field464[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  class199 var10 = client.field415[class32.field754][var8][var9];
                  if(null != var10) {
                     var11 = 2 + var8 * 4 - class152.field2301.field809 / 32;
                     var12 = var9 * 4 + 2 - class152.field2301.field804 / 32;
                     class6.method79(var1, var2, var11, var12, class108.field1908[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field293; ++var8) {
               class34 var18 = client.field320[client.field322[var8]];
               if(var18 != null && var18.vmethod735()) {
                  class39 var20 = var18.field772;
                  if(null != var20 && null != var20.field907) {
                     var20 = var20.method752();
                  }

                  if(null != var20 && var20.field883 && var20.field910) {
                     var11 = var18.field809 / 32 - class152.field2301.field809 / 32;
                     var12 = var18.field804 / 32 - class152.field2301.field804 / 32;
                     class6.method79(var1, var2, var11, var12, class108.field1908[1], var4);
                  }
               }
            }

            var8 = class32.field741;
            int[] var24 = class32.field742;

            for(var17 = 0; var17 < var8; ++var17) {
               class2 var19 = client.field405[var24[var17]];
               if(var19 != null && var19.vmethod735() && !var19.field56 && var19 != class152.field2301) {
                  var12 = var19.field809 / 32 - class152.field2301.field809 / 32;
                  int var13 = var19.field804 / 32 - class152.field2301.field804 / 32;
                  boolean var14 = false;
                  if(class47.method962(var19.field39, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class19.field274; ++var16) {
                     if(var19.field39.equals(class19.field278[var16].field622)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var23 = false;
                  if(class152.field2301.field55 != 0 && var19.field55 != 0 && class152.field2301.field55 == var19.field55) {
                     var23 = true;
                  }

                  if(var14) {
                     class6.method79(var1, var2, var12, var13, class108.field1908[3], var4);
                  } else if(var23) {
                     class6.method79(var1, var2, var12, var13, class108.field1908[4], var4);
                  } else if(var15) {
                     class6.method79(var1, var2, var12, var13, class108.field1908[5], var4);
                  } else {
                     class6.method79(var1, var2, var12, var13, class108.field1908[2], var4);
                  }
               }
            }

            if(client.field301 != 0 && client.field332 % 20 < 10) {
               if(client.field301 == 1 && client.field406 >= 0 && client.field406 < client.field320.length) {
                  class34 var21 = client.field320[client.field406];
                  if(null != var21) {
                     var11 = var21.field809 / 32 - class152.field2301.field809 / 32;
                     var12 = var21.field804 / 32 - class152.field2301.field804 / 32;
                     class74.method1563(var1, var2, var11, var12, class48.field1094[1], var4);
                  }
               }

               if(client.field301 == 2) {
                  var17 = client.field304 * 4 - class89.field1565 * 4 + 2 - class152.field2301.field809 / 32;
                  var11 = 2 + (client.field305 * 4 - client.field358 * 4) - class152.field2301.field804 / 32;
                  class74.method1563(var1, var2, var17, var11, class48.field1094[1], var4);
               }

               if(client.field301 == 10 && client.field506 >= 0 && client.field506 < client.field405.length) {
                  class2 var22 = client.field405[client.field506];
                  if(var22 != null) {
                     var11 = var22.field809 / 32 - class152.field2301.field809 / 32;
                     var12 = var22.field804 / 32 - class152.field2301.field804 / 32;
                     class74.method1563(var1, var2, var11, var12, class48.field1094[1], var4);
                  }
               }
            }

            if(client.field545 != 0) {
               var17 = client.field545 * 4 + 2 - class152.field2301.field809 / 32;
               var11 = client.field517 * 4 + 2 - class152.field2301.field804 / 32;
               class6.method79(var1, var2, var17, var11, class48.field1094[0], var4);
            }

            if(!class152.field2301.field56) {
               class79.method1785(var1 + var4.field2918 / 2 - 1, var4.field2917 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            class79.method1752(var1, var2, 0, var4.field2920, var4.field2922);
         }

         client.field488[var3] = true;
      }
   }
}

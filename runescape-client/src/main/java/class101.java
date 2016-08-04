import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("GameObject")
public final class class101 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 635841177
   )
   @Export("x")
   int field1730;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -679546869
   )
   @Export("y")
   int field1731;
   @ObfuscatedName("h")
   @Export("renderable")
   public class88 field1732;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -89704105
   )
   @Export("orientation")
   int field1733;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2124637843
   )
   @Export("hash")
   public int field1734 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -794664543
   )
   @Export("flags")
   int field1735 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -482191997
   )
   @Export("offsetX")
   int field1736;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1830302523
   )
   @Export("offsetY")
   int field1737;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 544477081
   )
   int field1738;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1227518657
   )
   int field1739;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 46906273
   )
   @Export("height")
   int field1740;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -733748801
   )
   @Export("relativeY")
   int field1741;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1528506441
   )
   @Export("relativeX")
   int field1742;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 95261857
   )
   @Export("plane")
   int field1744;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -1664151529
   )
   static int field1745;
   @ObfuscatedName("v")
   public static String field1746;
   @ObfuscatedName("dz")
   @Export("xteaKeys")
   static int[][] field1747;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIZI)V",
      garbageValue = "1683296091"
   )
   static void method2286(class176 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2822;
      int var5 = var0.field2823;
      if(var0.field2806 == 0) {
         var0.field2822 = var0.field2818;
      } else if(var0.field2806 == 1) {
         var0.field2822 = var1 - var0.field2818;
      } else if(var0.field2806 == 2) {
         var0.field2822 = var0.field2818 * var1 >> 14;
      }

      if(var0.field2815 == 0) {
         var0.field2823 = var0.field2819;
      } else if(var0.field2815 == 1) {
         var0.field2823 = var2 - var0.field2819;
      } else if(var0.field2815 == 2) {
         var0.field2823 = var2 * var0.field2819 >> 14;
      }

      if(var0.field2806 == 4) {
         var0.field2822 = var0.field2922 * var0.field2823 / var0.field2917;
      }

      if(var0.field2815 == 4) {
         var0.field2823 = var0.field2917 * var0.field2822 / var0.field2922;
      }

      if(client.field471 && var0.field2910 == 0) {
         if(var0.field2823 < 5 && var0.field2822 < 5) {
            var0.field2823 = 5;
            var0.field2822 = 5;
         } else {
            if(var0.field2823 <= 0) {
               var0.field2823 = 5;
            }

            if(var0.field2822 <= 0) {
               var0.field2822 = 5;
            }
         }
      }

      if(var0.field2811 == 1337) {
         client.field465 = var0;
      }

      if(var3 && null != var0.field2916 && (var0.field2822 != var4 || var5 != var0.field2823)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field8 = var0.field2916;
         client.field353.method3963(var6);
      }

   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Lclass176;",
      garbageValue = "39270046"
   )
   static class176 method2287(class176 var0) {
      class176 var1 = class44.method935(var0);
      if(var1 == null) {
         var1 = var0.field2882;
      }

      return var1;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIIB)V",
      garbageValue = "4"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method2288(class2 var0, int var1, int var2, int var3) {
      if(class3.field65 != var0) {
         if(client.field368 < 400) {
            String var4;
            if(var0.field54 == 0) {
               var4 = var0.field50[0] + var0.field58 + var0.field50[1] + class136.method3003(var0.field37, class3.field65.field37) + " " + " (" + "level-" + var0.field37 + ")" + var0.field50[2];
            } else {
               var4 = var0.field50[0] + var0.field58 + var0.field50[1] + " " + " (" + "skill-" + var0.field54 + ")" + var0.field50[2];
            }

            int var5;
            if(client.field439 == 1) {
               class107.method2394("Use", client.field447 + " " + "->" + " " + class16.method205(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field448) {
               if((class27.field675 & 8) == 8) {
                  class107.method2394(client.field306, client.field452 + " " + "->" + " " + class16.method205(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != client.field422[var5]) {
                     short var6 = 0;
                     if(client.field422[var5].equalsIgnoreCase("Attack")) {
                        if(class21.field589 == client.field292) {
                           continue;
                        }

                        if(client.field292 == class21.field587 || client.field292 == class21.field590 && var0.field37 > class3.field65.field37) {
                           var6 = 2000;
                        }

                        if(class3.field65.field44 != 0 && var0.field44 != 0) {
                           if(var0.field44 == class3.field65.field44) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(client.field423[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = client.field421[var5] + var6;
                     class107.method2394(client.field422[var5], class16.method205(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field368; ++var5) {
               if(client.field438[var5] == 23) {
                  client.field510[var5] = class16.method205(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("WidgetNode")
public class class3 extends class211 {
   @ObfuscatedName("c")
   boolean field58 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1008593041
   )
   int field59;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 721201609
   )
   @Export("id")
   int field60;
   @ObfuscatedName("i")
   static class83 field61;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "42"
   )
   static void method36() {
      client var0 = client.field289;
      synchronized(client.field289) {
         Container var1 = client.field289.method3122();
         if(var1 != null) {
            class116.field2025 = Math.max(var1.getSize().width, class114.field2019);
            class16.field246 = Math.max(var1.getSize().height, class47.field1076);
            if(class105.field1845 == var1) {
               Insets var2 = class105.field1845.getInsets();
               class116.field2025 -= var2.left + var2.right;
               class16.field246 -= var2.top + var2.bottom;
            }

            if(class116.field2025 <= 0) {
               class116.field2025 = 1;
            }

            if(class16.field246 <= 0) {
               class16.field246 = 1;
            }

            if(class14.method155() == 1) {
               class142.field2191 = client.field510;
               class132.field2109 = client.field497;
            } else {
               class142.field2191 = Math.min(class116.field2025, 7680);
               class132.field2109 = Math.min(class16.field246, 2160);
            }

            class147.field2249 = (class116.field2025 - class142.field2191) / 2;
            class147.field2250 = 0;
            class158.field2346.setSize(class142.field2191, class132.field2109);
            int var3 = class142.field2191;
            int var4 = class132.field2109;
            Canvas var5 = class158.field2346;

            Object var11;
            try {
               class84 var6 = new class84();
               var6.vmethod1966(var3, var4, var5);
               var11 = var6;
            } catch (Throwable var9) {
               class78 var7 = new class78();
               var7.vmethod1966(var3, var4, var5);
               var11 = var7;
            }

            class44.field1039 = (class80)var11;
            if(class105.field1845 == var1) {
               Insets var12 = class105.field1845.getInsets();
               class158.field2346.setLocation(class147.field2249 + var12.left, var12.top + class147.field2250);
            } else {
               class158.field2346.setLocation(class147.field2249, class147.field2250);
            }

            class10.method116();
            if(client.field454 != -1) {
               class118.method2544(client.field454, class142.field2191, class132.field2109, true);
            }

            class101.method2285();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-93920962"
   )
   static void method37(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class175 var4 = (class175)class174.field2772.method3864(var2);
      if(var4 != null) {
         class174.field2764.method3973(var4);
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1849032847"
   )
   @Export("groundItemSpawned")
   static final void method38(int var0, int var1) {
      class202 var2 = client.field426[class50.field1119][var0][var1];
      if(var2 == null) {
         class79.field1453.method2099(class50.field1119, var0, var1);
      } else {
         long var3 = -99999999L;
         class30 var5 = null;

         class30 var6;
         for(var6 = (class30)var2.method3899(); null != var6; var6 = (class30)var2.method3918()) {
            class55 var7 = class9.method108(var6.field717);
            long var8 = (long)var7.field1197;
            if(var7.field1194 == 1) {
               var8 *= (long)(1 + var6.field715);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class79.field1453.method2099(class50.field1119, var0, var1);
         } else {
            var2.method3896(var5);
            class30 var11 = null;
            class30 var10 = null;

            for(var6 = (class30)var2.method3899(); var6 != null; var6 = (class30)var2.method3918()) {
               if(var6.field717 != var5.field717) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.field717 != var11.field717 && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class79.field1453.method2016(class50.field1119, var0, var1, class105.method2370(128 * var0 + 64, 128 * var1 + 64, class50.field1119), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "396859666"
   )
   static final void method39() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var29;
      if(client.field549 == 236) {
         var0 = client.field338.method2610();
         var1 = class169.field2706 + (var0 >> 4 & 7);
         var2 = class186.field3002 + (var0 & 7);
         var3 = client.field338.method2612();
         var4 = client.field338.method2610();
         var5 = var4 >> 4 & 15;
         var6 = var4 & 7;
         var7 = client.field338.method2610();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var29 = var5 + 1;
            if(class118.field2035.field885[0] >= var1 - var29 && class118.field2035.field885[0] <= var1 + var29 && class118.field2035.field906[0] >= var2 - var29 && class118.field2035.field906[0] <= var29 + var2 && client.field536 != 0 && var6 > 0 && client.field535 < 50) {
               client.field370[client.field535] = var3;
               client.field539[client.field535] = var6;
               client.field449[client.field535] = var7;
               client.field494[client.field535] = null;
               client.field291[client.field535] = var5 + (var2 << 8) + (var1 << 16);
               ++client.field535;
            }
         }
      }

      if(client.field549 == 248) {
         var0 = client.field338.method2610();
         var1 = class169.field2706 + (var0 >> 4 & 7);
         var2 = (var0 & 7) + class186.field3002;
         var3 = client.field338.method2612();
         var4 = client.field338.method2612();
         var5 = client.field338.method2612();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class202 var41 = client.field426[class50.field1119][var1][var2];
            if(null != var41) {
               for(class30 var31 = (class30)var41.method3899(); null != var31; var31 = (class30)var41.method3918()) {
                  if(var31.field717 == (var3 & 32767) && var31.field715 == var4) {
                     var31.field715 = var5;
                     break;
                  }
               }

               method38(var1, var2);
            }
         }

      } else {
         int var9;
         int var10;
         int var12;
         if(client.field549 == 148) {
            byte var35 = client.field338.method2641();
            var1 = client.field338.method2645();
            var2 = client.field338.method2789();
            var3 = (var2 >> 4 & 7) + class169.field2706;
            var4 = class186.field3002 + (var2 & 7);
            var5 = client.field338.method2612();
            byte var36 = client.field338.method2641();
            var7 = client.field338.method2610();
            var29 = var7 >> 2;
            var9 = var7 & 3;
            var10 = client.field461[var29];
            byte var11 = client.field338.method2707();
            var12 = client.field338.method2645();
            int var13 = client.field338.method2645();
            byte var14 = client.field338.method2641();
            class2 var15;
            if(client.field417 == var12) {
               var15 = class118.field2035;
            } else {
               var15 = client.field467[var12];
            }

            if(var15 != null) {
               class42 var16 = class146.method3102(var1);
               int var17;
               int var18;
               if(var9 != 1 && var9 != 3) {
                  var17 = var16.field959;
                  var18 = var16.field1000;
               } else {
                  var17 = var16.field1000;
                  var18 = var16.field959;
               }

               int var19 = var3 + (var17 >> 1);
               int var20 = (var17 + 1 >> 1) + var3;
               int var21 = (var18 >> 1) + var4;
               int var22 = (var18 + 1 >> 1) + var4;
               int[][] var23 = class5.field78[class50.field1119];
               int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
               int var25 = (var3 << 7) + (var17 << 6);
               int var26 = (var18 << 6) + (var4 << 7);
               class108 var27 = var16.method844(var29, var9, var23, var25, var24, var26);
               if(null != var27) {
                  class141.method3039(class50.field1119, var3, var4, var10, -1, 0, 0, 1 + var5, var13 + 1);
                  var15.field38 = client.field567 + var5;
                  var15.field30 = client.field567 + var13;
                  var15.field41 = var27;
                  var15.field40 = 128 * var3 + 64 * var17;
                  var15.field42 = var4 * 128 + var18 * 64;
                  var15.field43 = var24;
                  byte var28;
                  if(var35 > var14) {
                     var28 = var35;
                     var35 = var14;
                     var14 = var28;
                  }

                  if(var36 > var11) {
                     var28 = var36;
                     var36 = var11;
                     var11 = var28;
                  }

                  var15.field34 = var3 + var35;
                  var15.field46 = var3 + var14;
                  var15.field45 = var36 + var4;
                  var15.field29 = var11 + var4;
               }
            }
         }

         if(client.field549 == 47) {
            var0 = client.field338.method2610();
            var1 = (var0 >> 4 & 7) + class169.field2706;
            var2 = (var0 & 7) + class186.field3002;
            var3 = client.field338.method2612();
            var4 = client.field338.method2610();
            var5 = client.field338.method2612();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var1 = var1 * 128 + 64;
               var2 = var2 * 128 + 64;
               class31 var30 = new class31(var3, class50.field1119, var1, var2, class105.method2370(var1, var2, class50.field1119) - var4, var5, client.field567);
               client.field429.method3895(var30);
            }

         } else if(client.field549 == 253) {
            var0 = client.field338.method2610();
            var1 = (var0 >> 4 & 7) + class169.field2706;
            var2 = class186.field3002 + (var0 & 7);
            var3 = var1 + client.field338.method2611();
            var4 = var2 + client.field338.method2611();
            var5 = client.field338.method2613();
            var6 = client.field338.method2612();
            var7 = client.field338.method2610() * 4;
            var29 = client.field338.method2610() * 4;
            var9 = client.field338.method2612();
            var10 = client.field338.method2612();
            int var40 = client.field338.method2610();
            var12 = client.field338.method2610();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
               var1 = var1 * 128 + 64;
               var2 = 64 + 128 * var2;
               var3 = 64 + 128 * var3;
               var4 = 64 + var4 * 128;
               class6 var34 = new class6(var6, class50.field1119, var1, var2, class105.method2370(var1, var2, class50.field1119) - var7, var9 + client.field567, client.field567 + var10, var40, var12, var5, var29);
               var34.method79(var3, var4, class105.method2370(var3, var4, class50.field1119) - var29, var9 + client.field567);
               client.field428.method3895(var34);
            }

         } else if(client.field549 == 139) {
            var0 = client.field338.method2645();
            var1 = client.field338.method2789();
            var2 = var1 >> 2;
            var3 = var1 & 3;
            var4 = client.field461[var2];
            var5 = client.field338.method2633();
            var6 = class169.field2706 + (var5 >> 4 & 7);
            var7 = (var5 & 7) + class186.field3002;
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               class141.method3039(class50.field1119, var6, var7, var4, var0, var2, var3, 0, -1);
            }

         } else if(client.field549 == 93) {
            var0 = client.field338.method2633();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = client.field461[var1];
            var4 = client.field338.method2662();
            var5 = (var4 >> 4 & 7) + class169.field2706;
            var6 = class186.field3002 + (var4 & 7);
            var7 = client.field338.method2646();
            if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
               if(var3 == 0) {
                  class90 var8 = class79.field1453.method2031(class50.field1119, var5, var6);
                  if(null != var8) {
                     var9 = var8.field1601 >> 14 & 32767;
                     if(var1 == 2) {
                        var8.field1597 = new class12(var9, 2, 4 + var2, class50.field1119, var5, var6, var7, false, var8.field1597);
                        var8.field1599 = new class12(var9, 2, 1 + var2 & 3, class50.field1119, var5, var6, var7, false, var8.field1599);
                     } else {
                        var8.field1597 = new class12(var9, var1, var2, class50.field1119, var5, var6, var7, false, var8.field1597);
                     }
                  }
               }

               if(var3 == 1) {
                  class97 var37 = class79.field1453.method2161(class50.field1119, var5, var6);
                  if(var37 != null) {
                     var9 = var37.field1679 >> 14 & 32767;
                     if(var1 != 4 && var1 != 5) {
                        if(var1 == 6) {
                           var37.field1677 = new class12(var9, 4, 4 + var2, class50.field1119, var5, var6, var7, false, var37.field1677);
                        } else if(var1 == 7) {
                           var37.field1677 = new class12(var9, 4, (2 + var2 & 3) + 4, class50.field1119, var5, var6, var7, false, var37.field1677);
                        } else if(var1 == 8) {
                           var37.field1677 = new class12(var9, 4, 4 + var2, class50.field1119, var5, var6, var7, false, var37.field1677);
                           var37.field1683 = new class12(var9, 4, (2 + var2 & 3) + 4, class50.field1119, var5, var6, var7, false, var37.field1683);
                        }
                     } else {
                        var37.field1677 = new class12(var9, 4, var2, class50.field1119, var5, var6, var7, false, var37.field1677);
                     }
                  }
               }

               if(var3 == 2) {
                  class101 var38 = class79.field1453.method2033(class50.field1119, var5, var6);
                  if(var1 == 11) {
                     var1 = 10;
                  }

                  if(var38 != null) {
                     var38.field1730 = new class12(var38.field1741 >> 14 & 32767, var1, var2, class50.field1119, var5, var6, var7, false, var38.field1730);
                  }
               }

               if(var3 == 3) {
                  class96 var39 = class79.field1453.method2084(class50.field1119, var5, var6);
                  if(null != var39) {
                     var39.field1660 = new class12(var39.field1661 >> 14 & 32767, 22, var2, class50.field1119, var5, var6, var7, false, var39.field1660);
                  }
               }
            }

         } else {
            class30 var33;
            if(client.field549 != 84) {
               if(client.field549 == 143) {
                  var0 = client.field338.method2662();
                  var1 = (var0 >> 4 & 7) + class169.field2706;
                  var2 = (var0 & 7) + class186.field3002;
                  var3 = client.field338.method2633();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = client.field461[var4];
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     class141.method3039(class50.field1119, var1, var2, var6, -1, var4, var5, 0, -1);
                  }

               } else if(client.field549 == 49) {
                  var0 = client.field338.method2646();
                  var1 = client.field338.method2645();
                  var2 = client.field338.method2610();
                  var3 = (var2 >> 4 & 7) + class169.field2706;
                  var4 = (var2 & 7) + class186.field3002;
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     var33 = new class30();
                     var33.field717 = var1;
                     var33.field715 = var0;
                     if(null == client.field426[class50.field1119][var3][var4]) {
                        client.field426[class50.field1119][var3][var4] = new class202();
                     }

                     client.field426[class50.field1119][var3][var4].method3895(var33);
                     method38(var3, var4);
                  }

               }
            } else {
               var0 = client.field338.method2612();
               var1 = client.field338.method2789();
               var2 = (var1 >> 4 & 7) + class169.field2706;
               var3 = (var1 & 7) + class186.field3002;
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  class202 var32 = client.field426[class50.field1119][var2][var3];
                  if(null != var32) {
                     for(var33 = (class30)var32.method3899(); var33 != null; var33 = (class30)var32.method3918()) {
                        if(var33.field717 == (var0 & 32767)) {
                           var33.method4000();
                           break;
                        }
                     }

                     if(var32.method3899() == null) {
                        client.field426[class50.field1119][var2][var3] = null;
                     }

                     method38(var2, var3);
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-23151"
   )
   public static void method40() {
      while(true) {
         class202 var1 = class173.field2750;
         class172 var0;
         synchronized(class173.field2750) {
            var0 = (class172)class173.field2751.method3897();
         }

         if(var0 == null) {
            return;
         }

         var0.field2740.method3430(var0.field2742, (int)var0.field3161, var0.field2747, false);
      }
   }
}

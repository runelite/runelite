import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class33 {
   @ObfuscatedName("az")
   @Export("worldSelectShown")
   static boolean field728;
   @ObfuscatedName("aq")
   @Export("loginMessage1")
   static String field729;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1763432079
   )
   static int field730 = 0;
   @ObfuscatedName("o")
   static class83 field731;
   @ObfuscatedName("k")
   static class83 field732;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -95131927
   )
   @Export("loginWindowX")
   static int field733;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -236018653
   )
   static int field734;
   @ObfuscatedName("ay")
   static String field735;
   @ObfuscatedName("c")
   static int[] field736;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1703814599
   )
   static int field737;
   @ObfuscatedName("af")
   @Export("loginMessage2")
   static String field738;
   @ObfuscatedName("a")
   static int[] field739;
   @ObfuscatedName("an")
   static int[] field740;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1837514317
   )
   static int field741;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1699990887
   )
   static int field742;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 601814909
   )
   static int field744;
   @ObfuscatedName("e")
   static class83 field745;
   @ObfuscatedName("ax")
   static String field746;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -953096867
   )
   static int field747;
   @ObfuscatedName("av")
   static String field748;
   @ObfuscatedName("ac")
   static boolean field749;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1279775471
   )
   static int field750;
   @ObfuscatedName("at")
   @Export("loginMessage3")
   static String field751;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 468166731
   )
   static int field752;
   @ObfuscatedName("ah")
   static class162 field753;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -335519999
   )
   @Export("loginIndex2")
   static int field754;
   @ObfuscatedName("t")
   static int[] field755;
   @ObfuscatedName("m")
   static boolean field756;
   @ObfuscatedName("i")
   static int[] field757;
   @ObfuscatedName("aw")
   @Export("username")
   static String field758;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1792942605
   )
   @Export("loginIndex")
   static int field759;
   @ObfuscatedName("as")
   @Export("authCode")
   static String field760;
   @ObfuscatedName("p")
   static int[][][] field762;
   @ObfuscatedName("kq")
   @Export("chatMessages")
   static class19 field764;

   static {
      field733 = 202 + field730;
      field757 = new int[256];
      field737 = 0;
      field752 = 0;
      field741 = 0;
      field742 = 0;
      field750 = 0;
      field744 = 0;
      field747 = 10;
      field746 = "";
      field759 = 0;
      field748 = "";
      field729 = "";
      field738 = "";
      field751 = "";
      field758 = "";
      field735 = "";
      field753 = class162.field2658;
      field749 = true;
      field754 = 0;
      field728 = false;
      field734 = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "-722446859"
   )
   static class23 method705(int var0) {
      class23 var1 = (class23)class23.field599.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class182.field2967.method3304(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class23();
            class122 var3 = new class122(var2);
            var3.field2045 = var3.field2047.length - 12;
            int var4 = var3.method2577();
            var1.field596 = var3.method2706();
            var1.field595 = var3.method2706();
            var1.field597 = var3.method2706();
            var1.field590 = var3.method2706();
            var3.field2045 = 0;
            var3.method2627();
            var1.field591 = new int[var4];
            var1.field592 = new int[var4];
            var1.field593 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field2045 < var3.field2047.length - 12; var1.field591[var5++] = var6) {
               var6 = var3.method2706();
               if(var6 == 3) {
                  var1.field593[var5] = var3.method2580();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field592[var5] = var3.method2577();
               } else {
                  var1.field592[var5] = var3.method2556();
               }
            }

            class23.field599.method3823(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1550478680"
   )
   static final void method706(int var0, int var1, int var2, int var3) {
      ++client.field377;
      class42.method881(class35.field793);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field344 >= 0) {
         var5 = class34.field777;
         int[] var6 = class34.field780;

         for(var7 = 0; var7 < var5; ++var7) {
            if(client.field344 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class42.method881(class35.field789);
      }

      class119.method2516(true);
      class42.method881(var4?class35.field792:class35.field791);
      class119.method2516(false);
      class138.method2932();

      for(class31 var28 = (class31)client.field406.method3882(); var28 != null; var28 = (class31)client.field406.method3891()) {
         if(class51.field1119 == var28.field712 && !var28.field715) {
            if(client.field282 >= var28.field707) {
               var28.method667(client.field329);
               if(var28.field715) {
                  var28.method3990();
               } else {
                  class5.field91.method2010(var28.field712, var28.field708, var28.field710, var28.field711, 60, var28, 0, -1, false);
               }
            }
         } else {
            var28.method3990();
         }
      }

      class43.method905(var0, var1, var2, var3, true);
      var0 = client.field514;
      var1 = client.field316;
      var2 = client.field534;
      var3 = client.field364;
      class82.method1875(var0, var1, var0 + var2, var3 + var1);
      class94.method2166();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      int var18;
      int var29;
      if(!client.field518) {
         var5 = client.field356;
         if(client.field365 / 256 > var5) {
            var5 = client.field365 / 256;
         }

         if(client.field519[4] && client.field491[4] + 128 > var5) {
            var5 = 128 + client.field491[4];
         }

         var29 = client.field357 + client.field339 & 2047;
         var7 = class85.field1505;
         var8 = class15.method163(class114.field2010.field864, class114.field2010.field831, class51.field1119) - client.field437;
         var9 = class166.field2710;
         var10 = 600 + var5 * 3;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var29 & 2047;
         var13 = 0;
         int var14 = 0;
         var15 = var10;
         int var17;
         if(var11 != 0) {
            var16 = class94.field1660[var11];
            var17 = class94.field1661[var11];
            var18 = var17 * var14 - var16 * var10 >> 16;
            var15 = var14 * var16 + var10 * var17 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class94.field1660[var12];
            var17 = class94.field1661[var12];
            var18 = var17 * var13 + var15 * var16 >> 16;
            var15 = var17 * var15 - var16 * var13 >> 16;
            var13 = var18;
         }

         class9.field144 = var7 - var13;
         class24.field622 = var8 - var14;
         class59.field1256 = var9 - var15;
         class31.field717 = var5;
         class10.field155 = var29;
      }

      if(!client.field518) {
         var5 = class16.method183();
      } else {
         var5 = class79.method1748();
      }

      var29 = class9.field144;
      var7 = class24.field622;
      var8 = class59.field1256;
      var9 = class31.field717;
      var10 = class10.field155;

      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field519[var11]) {
            var12 = (int)(Math.random() * (double)(client.field520[var11] * 2 + 1) - (double)client.field520[var11] + Math.sin((double)client.field522[var11] / 100.0D * (double)client.field523[var11]) * (double)client.field491[var11]);
            if(var11 == 0) {
               class9.field144 += var12;
            }

            if(var11 == 1) {
               class24.field622 += var12;
            }

            if(var11 == 2) {
               class59.field1256 += var12;
            }

            if(var11 == 3) {
               class10.field155 = class10.field155 + var12 & 2047;
            }

            if(var11 == 4) {
               class31.field717 += var12;
               if(class31.field717 < 128) {
                  class31.field717 = 128;
               }

               if(class31.field717 > 383) {
                  class31.field717 = 383;
               }
            }
         }
      }

      var11 = class143.field2213;
      var12 = class143.field2214;
      if(class143.field2224 != 0) {
         var11 = class143.field2220;
         var12 = class143.field2222;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         class108.field1863 = true;
         class108.field1919 = 0;
         class108.field1917 = var11 - var0;
         class108.field1918 = var12 - var1;
      } else {
         class108.field1863 = false;
         class108.field1919 = 0;
      }

      class20.method553();
      class82.method1880(var0, var1, var2, var3, 0);
      class20.method553();
      var13 = class94.field1646;
      class94.field1646 = client.field536;
      class5.field91.method2036(class9.field144, class24.field622, class59.field1256, class31.field717, class10.field155, var5);
      class94.field1646 = var13;
      class20.method553();
      class5.field91.method2013();
      client.field366 = 0;
      boolean var33 = false;
      var15 = -1;
      var16 = class34.field777;
      int[] var31 = class34.field780;

      for(var18 = 0; var18 < client.field394 + var16; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = client.field393[var31[var18]];
            if(client.field344 == var31[var18]) {
               var33 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = client.field308[client.field310[var18 - var16]];
         }

         class111.method2481((class39)var19, var18, var0, var1, var2, var3);
      }

      if(var33) {
         class111.method2481(client.field393[client.field344], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < client.field366; ++var18) {
         int var32 = client.field343[var18];
         int var20 = client.field279[var18];
         int var21 = client.field512[var18];
         int var22 = client.field370[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var30 = 0; var30 < var18; ++var30) {
               if(2 + var20 > client.field279[var30] - client.field370[var30] && var20 - var22 < 2 + client.field279[var30] && var32 - var21 < client.field512[var30] + client.field343[var30] && var32 + var21 > client.field343[var30] - client.field512[var30] && client.field279[var30] - client.field370[var30] < var20) {
                  var20 = client.field279[var30] - client.field370[var30];
                  var23 = true;
               }
            }
         }

         client.field378 = client.field343[var18];
         client.field397 = client.field279[var18] = var20;
         String var24 = client.field375[var18];
         if(client.field429 == 0) {
            int var25 = 16776960;
            if(client.field372[var18] < 6) {
               var25 = client.field487[client.field372[var18]];
            }

            if(client.field372[var18] == 6) {
               var25 = client.field377 % 20 < 10?16711680:16776960;
            }

            if(client.field372[var18] == 7) {
               var25 = client.field377 % 20 < 10?255:'\uffff';
            }

            if(client.field372[var18] == 8) {
               var25 = client.field377 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(client.field372[var18] == 9) {
               var26 = 150 - client.field374[var18];
               if(var26 < 50) {
                  var25 = 16711680 + var26 * 1280;
               } else if(var26 < 100) {
                  var25 = 16776960 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 5 * (var26 - 100) + '\uff00';
               }
            }

            if(client.field372[var18] == 10) {
               var26 = 150 - client.field374[var18];
               if(var26 < 50) {
                  var25 = 16711680 + 5 * var26;
               } else if(var26 < 100) {
                  var25 = 16711935 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 327680 + 255 - 5 * (var26 - 100);
               }
            }

            if(client.field372[var18] == 11) {
               var26 = 150 - client.field374[var18];
               if(var26 < 50) {
                  var25 = 16777215 - 327685 * var26;
               } else if(var26 < 100) {
                  var25 = (var26 - 50) * 327685 + '\uff00';
               } else if(var26 < 150) {
                  var25 = 16777215 - 327680 * (var26 - 100);
               }
            }

            if(client.field373[var18] == 0) {
               class1.field25.method4116(var24, var0 + client.field378, client.field397 + var1, var25, 0);
            }

            if(client.field373[var18] == 1) {
               class1.field25.method4103(var24, client.field378 + var0, var1 + client.field397, var25, 0, client.field377);
            }

            if(client.field373[var18] == 2) {
               class1.field25.method4104(var24, var0 + client.field378, client.field397 + var1, var25, 0, client.field377);
            }

            if(client.field373[var18] == 3) {
               class1.field25.method4174(var24, var0 + client.field378, var1 + client.field397, var25, 0, client.field377, 150 - client.field374[var18]);
            }

            if(client.field373[var18] == 4) {
               var26 = (150 - client.field374[var18]) * (class1.field25.method4094(var24) + 100) / 150;
               class82.method1876(var0 + client.field378 - 50, var1, client.field378 + var0 + 50, var1 + var3);
               class1.field25.method4099(var24, client.field378 + var0 + 50 - var26, client.field397 + var1, var25, 0);
               class82.method1875(var0, var1, var2 + var0, var1 + var3);
            }

            if(client.field373[var18] == 5) {
               var26 = 150 - client.field374[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               class82.method1876(var0, var1 + client.field397 - class1.field25.field3237 - 1, var0 + var2, 5 + var1 + client.field397);
               class1.field25.method4116(var24, var0 + client.field378, var27 + client.field397 + var1, var25, 0);
               class82.method1875(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class1.field25.method4116(var24, client.field378 + var0, var1 + client.field397, 16776960, 0);
         }
      }

      if(client.field418 == 2) {
         class41.method820(client.field296 + (client.field293 - class39.field838 << 7), client.field297 + (client.field309 - class13.field184 << 7), client.field295 * 2);
         if(client.field378 > -1 && client.field282 % 20 < 10) {
            class54.field1165[0].method1800(client.field378 + var0 - 12, var1 + client.field397 - 28);
         }
      }

      ((class98)class94.field1657).method2257(client.field329);
      class101.method2280(var0, var1, var2, var3);
      class9.field144 = var29;
      class24.field622 = var7;
      class59.field1256 = var8;
      class31.field717 = var9;
      class10.field155 = var10;
      if(client.field281) {
         byte var34 = 0;
         var15 = var34 + class174.field2763 + class174.field2765;
         if(var15 == 0) {
            client.field281 = false;
         }
      }

      if(client.field281) {
         class82.method1880(var0, var1, var2, var3, 0);
         class15.method175("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Z",
      garbageValue = "-2009054109"
   )
   static boolean method708(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3304(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class45.method958(var3);
         return true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "220573228"
   )
   public static void method709(class170 var0) {
      class52.field1149 = var0;
   }
}

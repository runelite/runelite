import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class47 extends class204 {
   @ObfuscatedName("x")
   public static class193 field1079 = new class193(64);
   @ObfuscatedName("l")
   static class18 field1080;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2046459815
   )
   public int field1081;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 716456881
   )
   public int field1082;
   @ObfuscatedName("w")
   public static class167 field1083;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -88319519
   )
   static int field1084;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -743378879
   )
   public int field1085;
   @ObfuscatedName("bb")
   static class168 field1086;

   @ObfuscatedName("w")
   public void method1011(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method1012(var1, var2);
      }
   }

   @ObfuscatedName("x")
   void method1012(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1085 = var1.method2508();
         this.field1081 = var1.method2506();
         this.field1082 = var1.method2506();
      }

   }

   @ObfuscatedName("n")
   static final void method1015() {
      if(class82.field1437 != client.field523) {
         client.field523 = class82.field1437;
         class21.method588(class82.field1437);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1733059387"
   )
   static final void method1020(int var0, int var1, int var2, int var3) {
      ++client.field329;
      class17.method185(class33.field774);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field424 >= 0) {
         var5 = class32.field751;
         int[] var6 = class32.field757;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == client.field424) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class17.method185(class33.field767);
      }

      class50.method1056(true);
      class17.method185(var4?class33.field769:class33.field768);
      class50.method1056(false);
      class5.method91();
      class46.method1010();
      class39.method814(var0, var1, var2, var3, true);
      var0 = client.field428;
      var1 = client.field557;
      var2 = client.field306;
      var3 = client.field559;
      class79.method1773(var0, var1, var2 + var0, var1 + var3);
      class91.method2082();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var18;
      int var28;
      if(!client.field542) {
         var5 = client.field378;
         if(client.field387 / 256 > var5) {
            var5 = client.field387 / 256;
         }

         if(client.field568[4] && 128 + client.field545[4] > var5) {
            var5 = 128 + client.field545[4];
         }

         var28 = client.field362 + client.field388 & 2047;
         var7 = class90.field1567;
         var8 = class43.method938(class167.field2692.field849, class167.field2692.field819, class82.field1437) - client.field384;
         var9 = class96.field1643;
         var10 = 600 + var5 * 3;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var28 & 2047;
         var13 = 0;
         var14 = 0;
         var15 = var10;
         int var17;
         if(0 != var11) {
            var16 = class91.field1573[var11];
            var17 = class91.field1595[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var10 * var17 + var14 * var16 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class91.field1573[var12];
            var17 = class91.field1595[var12];
            var18 = var16 * var15 + var17 * var13 >> 16;
            var15 = var15 * var17 - var16 * var13 >> 16;
            var13 = var18;
         }

         class148.field2249 = var7 - var13;
         class156.field2333 = var8 - var14;
         class173.field2868 = var9 - var15;
         class29.field698 = var5;
         class16.field237 = var28;
      }

      if(!client.field542) {
         if(class41.field989.field164) {
            var28 = class82.field1437;
         } else {
            label601: {
               var7 = 3;
               if(class29.field698 < 310) {
                  var8 = class148.field2249 >> 7;
                  var9 = class173.field2868 >> 7;
                  var10 = class167.field2692.field849 >> 7;
                  var11 = class167.field2692.field819 >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var28 = class82.field1437;
                     break label601;
                  }

                  if(0 != (class5.field109[class82.field1437][var8][var9] & 4)) {
                     var7 = class82.field1437;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = 65536 * var13 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if(0 != (class5.field109[class82.field1437][var8][var9] & 4)) {
                           var7 = class82.field1437;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if(0 != (class5.field109[class82.field1437][var8][var9] & 4)) {
                              var7 = class82.field1437;
                           }
                        }
                     }
                  } else {
                     var14 = 65536 * var12 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class5.field109[class82.field1437][var8][var9] & 4) != 0) {
                           var7 = class82.field1437;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class5.field109[class82.field1437][var8][var9] & 4) != 0) {
                              var7 = class82.field1437;
                           }
                        }
                     }
                  }
               }

               if(class167.field2692.field849 >= 0 && class167.field2692.field819 >= 0 && class167.field2692.field849 < 13312 && class167.field2692.field819 < 13312) {
                  if(0 != (class5.field109[class82.field1437][class167.field2692.field849 >> 7][class167.field2692.field819 >> 7] & 4)) {
                     var7 = class82.field1437;
                  }

                  var28 = var7;
               } else {
                  var28 = class82.field1437;
               }
            }
         }

         var5 = var28;
      } else {
         if(class41.field989.field164) {
            var28 = class82.field1437;
         } else {
            var7 = class43.method938(class148.field2249, class173.field2868, class82.field1437);
            if(var7 - class156.field2333 < 800 && (class5.field109[class82.field1437][class148.field2249 >> 7][class173.field2868 >> 7] & 4) != 0) {
               var28 = class82.field1437;
            } else {
               var28 = 3;
            }
         }

         var5 = var28;
      }

      var28 = class148.field2249;
      var7 = class156.field2333;
      var8 = class173.field2868;
      var9 = class29.field698;
      var10 = class16.field237;

      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field568[var11]) {
            var12 = (int)(Math.random() * (double)(1 + client.field479[var11] * 2) - (double)client.field479[var11] + Math.sin((double)client.field349[var11] * ((double)client.field546[var11] / 100.0D)) * (double)client.field545[var11]);
            if(var11 == 0) {
               class148.field2249 += var12;
            }

            if(1 == var11) {
               class156.field2333 += var12;
            }

            if(var11 == 2) {
               class173.field2868 += var12;
            }

            if(var11 == 3) {
               class16.field237 = class16.field237 + var12 & 2047;
            }

            if(4 == var11) {
               class29.field698 += var12;
               if(class29.field698 < 128) {
                  class29.field698 = 128;
               }

               if(class29.field698 > 383) {
                  class29.field698 = 383;
               }
            }
         }
      }

      var11 = class140.field2168;
      var12 = class140.field2182;
      if(0 != class140.field2177) {
         var11 = class140.field2176;
         var12 = class140.field2167;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var3 + var1) {
         class105.field1864 = true;
         class105.field1852 = 0;
         class105.field1865 = var11 - var0;
         class105.field1866 = var12 - var1;
      } else {
         class105.field1864 = false;
         class105.field1852 = 0;
      }

      class59.method1272();
      class79.method1800(var0, var1, var2, var3, 0);
      class59.method1272();
      var13 = class91.field1580;
      class91.field1580 = client.field560;
      class3.field75.method1946(class148.field2249, class156.field2333, class173.field2868, class29.field698, class16.field237, var5);
      class91.field1580 = var13;
      class59.method1272();
      class3.field75.method1922();
      client.field340 = 0;
      boolean var29 = false;
      var15 = -1;
      var16 = class32.field751;
      int[] var30 = class32.field757;

      for(var18 = 0; var18 < client.field332 + var16; ++var18) {
         Object var19;
         if(var18 < var16) {
            var19 = client.field415[var30[var18]];
            if(var30[var18] == client.field424) {
               var29 = true;
               var15 = var18;
               continue;
            }
         } else {
            var19 = client.field331[client.field333[var18 - var16]];
         }

         class106.method2379((class37)var19, var18, var0, var1);
      }

      if(var29) {
         class106.method2379(client.field415[client.field424], var15, var0, var1);
      }

      for(var18 = 0; var18 < client.field340; ++var18) {
         int var32 = client.field471[var18];
         int var20 = client.field391[var18];
         int var21 = client.field393[var18];
         int var22 = client.field392[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var24 = 0; var24 < var18; ++var24) {
               if(2 + var20 > client.field391[var24] - client.field392[var24] && var20 - var22 < 2 + client.field391[var24] && var32 - var21 < client.field471[var24] + client.field393[var24] && var21 + var32 > client.field471[var24] - client.field393[var24] && client.field391[var24] - client.field392[var24] < var20) {
                  var20 = client.field391[var24] - client.field392[var24];
                  var23 = true;
               }
            }
         }

         client.field400 = client.field471[var18];
         client.field401 = client.field391[var18] = var20;
         String var33 = client.field397[var18];
         if(client.field456 == 0) {
            int var25 = 16776960;
            if(client.field376[var18] < 6) {
               var25 = client.field511[client.field376[var18]];
            }

            if(client.field376[var18] == 6) {
               var25 = client.field329 % 20 < 10?16711680:16776960;
            }

            if(client.field376[var18] == 7) {
               var25 = client.field329 % 20 < 10?255:'\uffff';
            }

            if(client.field376[var18] == 8) {
               var25 = client.field329 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(client.field376[var18] == 9) {
               var26 = 150 - client.field531[var18];
               if(var26 < 50) {
                  var25 = var26 * 1280 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = (var26 - 100) * 5 + '\uff00';
               }
            }

            if(client.field376[var18] == 10) {
               var26 = 150 - client.field531[var18];
               if(var26 < 50) {
                  var25 = 5 * var26 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16711935 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = 327680 * (var26 - 100) + 255 - (var26 - 100) * 5;
               }
            }

            if(client.field376[var18] == 11) {
               var26 = 150 - client.field531[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = '\uff00' + 327685 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 16777215 - 327680 * (var26 - 100);
               }
            }

            if(client.field567[var18] == 0) {
               class89.field1561.method4039(var33, client.field400 + var0, var1 + client.field401, var25, 0);
            }

            if(1 == client.field567[var18]) {
               class89.field1561.method4041(var33, var0 + client.field400, client.field401 + var1, var25, 0, client.field329);
            }

            if(client.field567[var18] == 2) {
               class89.field1561.method4042(var33, client.field400 + var0, client.field401 + var1, var25, 0, client.field329);
            }

            if(3 == client.field567[var18]) {
               class89.field1561.method4040(var33, client.field400 + var0, var1 + client.field401, var25, 0, client.field329, 150 - client.field531[var18]);
            }

            if(client.field567[var18] == 4) {
               var26 = (150 - client.field531[var18]) * (class89.field1561.method4032(var33) + 100) / 150;
               class79.method1831(var0 + client.field400 - 50, var1, 50 + client.field400 + var0, var3 + var1);
               class89.field1561.method4037(var33, var0 + client.field400 + 50 - var26, client.field401 + var1, var25, 0);
               class79.method1773(var0, var1, var0 + var2, var1 + var3);
            }

            if(5 == client.field567[var18]) {
               var26 = 150 - client.field531[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               class79.method1831(var0, client.field401 + var1 - class89.field1561.field3194 - 1, var2 + var0, var1 + client.field401 + 5);
               class89.field1561.method4039(var33, client.field400 + var0, var1 + client.field401 + var27, var25, 0);
               class79.method1773(var0, var1, var2 + var0, var3 + var1);
            }
         } else {
            class89.field1561.method4039(var33, client.field400 + var0, var1 + client.field401, 16776960, 0);
         }
      }

      class10.method123(var0, var1);
      ((class95)class91.field1591).method2167(client.field370);
      class190.method3762();
      class148.field2249 = var28;
      class156.field2333 = var7;
      class173.field2868 = var8;
      class29.field698 = var9;
      class16.field237 = var10;
      if(client.field295) {
         byte var31 = 0;
         var15 = var31 + class171.field2739 + class171.field2737;
         if(var15 == 0) {
            client.field295 = false;
         }
      }

      if(client.field295) {
         class79.method1800(var0, var1, var2, var3, 0);
         class19.method228("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "854717733"
   )
   static void method1021(int var0) {
      if(-1 != var0) {
         if(class39.method817(var0)) {
            class173[] var1 = class173.field2830[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(var3.field2853 != null) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field7 = var3.field2853;
                  class13.method161(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("ca")
   static final String method1022(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class72.method1574('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class72.method1574(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class72.method1574(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("t")
   static String method1025(class119 var0, int var1) {
      try {
         int var2 = var0.method2571();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.field2011 += class222.field3185.method2442(var0.field2012, var0.field2011, var3, 0, var2);
         String var4 = class38.method783(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }
}

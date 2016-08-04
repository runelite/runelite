import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public final class class31 extends class88 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1642663941
   )
   int field717;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1097381691
   )
   int field718;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1420373313
   )
   int field719;
   @ObfuscatedName("k")
   class44 field720;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -273150785
   )
   int field722;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -106791693
   )
   int field723 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -740086667
   )
   int field724 = 0;
   @ObfuscatedName("b")
   boolean field725 = false;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 1049453813
   )
   static int field726;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -575734155
   )
   int field727;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -434310693
   )
   int field728;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "415989965"
   )
   final void method688(int var1) {
      if(!this.field725) {
         this.field724 += var1;

         while(this.field724 > this.field720.field1018[this.field723]) {
            this.field724 -= this.field720.field1018[this.field723];
            ++this.field723;
            if(this.field723 >= this.field720.field1030.length) {
               this.field725 = true;
               break;
            }
         }

      }
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field722 = var1;
      this.field718 = var2;
      this.field719 = var3;
      this.field727 = var4;
      this.field728 = var5;
      this.field717 = var6 + var7;
      int var8 = class110.method2488(this.field722).field1042;
      if(var8 != -1) {
         this.field725 = false;
         this.field720 = class22.method585(var8);
      } else {
         this.field725 = true;
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lclass176;II)I",
      garbageValue = "-2073716925"
   )
   static final int method689(class176 var0, int var1) {
      if(null != var0.field2919 && var1 < var0.field2919.length) {
         try {
            int[] var2 = var0.field2919[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field430[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field431[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field432[var2[var4++]];
               }

               int var9;
               class176 var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class134.method2983(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class1.method14(var11).field1199 || client.field520)) {
                     for(var12 = 0; var12 < var10.field2905.length; ++var12) {
                        if(var10.field2905[var12] == var11 + 1) {
                           var7 += var10.field2926[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.field2958[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2358[client.field431[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.field2958[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class3.field65.field37;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2354[var9]) {
                        var7 += client.field431[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class134.method2983(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class1.method14(var11).field1199 || client.field520)) {
                     for(var12 = 0; var12 < var10.field2905.length; ++var12) {
                        if(var10.field2905[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field458;
               }

               if(var6 == 12) {
                  var7 = client.field545;
               }

               if(var6 == 13) {
                  var9 = class179.field2958[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class54.method1164(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = class0.field11 + (class3.field65.field875 >> 7);
               }

               if(var6 == 19) {
                  var7 = (class3.field65.field832 >> 7) + class21.field592;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "144576772"
   )
   static final void method693() {
      class48.field1078.method3910();
      class163.method3330();
      class51.method1116();
      class42.field947.method3910();
      class42.field948.method3910();
      class42.field963.method3910();
      class42.field975.method3910();
      class159.method3311();
      class55.field1186.method3910();
      class55.field1222.method3910();
      class55.field1177.method3910();
      class17.method209();
      class45.field1035.method3910();
      class45.field1036.method3910();
      class142.method3087();
      class6.method92();
      class109.method2484();
      class26.method630();
      class54.method1169();
      class176.field2801.method3910();
      class176.field2802.method3910();
      class176.field2803.method3910();
      class176.field2861.method3910();
      ((class98)class94.field1658).method2263();
      class23.field611.method3910();
      class16.field240.method3408();
      class56.field1236.method3408();
      class164.field2699.method3408();
      class119.field2039.method3408();
      class80.field1476.method3408();
      class188.field3051.method3408();
      class7.field137.method3408();
      client.field451.method3408();
      class42.field964.method3408();
      class25.field644.method3408();
      class0.field12.method3408();
      class20.field581.method3408();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1963586129"
   )
   static final void method694() {
      int var0;
      if(client.field495 != -1) {
         var0 = client.field495;
         if(class14.method179(var0)) {
            class147.method3250(class176.field2836[var0], -1);
         }
      }

      for(var0 = 0; var0 < client.field496; ++var0) {
         if(client.field498[var0]) {
            client.field499[var0] = true;
         }

         client.field500[var0] = client.field498[var0];
         client.field498[var0] = false;
      }

      client.field497 = client.field305;
      client.field442 = -1;
      client.field443 = -1;
      class132.field2104 = null;
      if(client.field495 != -1) {
         client.field496 = 0;
         class111.method2500(client.field495, 0, 0, class189.field3056, class39.field892, 0, 0, -1);
      }

      class82.method1880();
      if(!client.field434) {
         if(client.field442 != -1) {
            var0 = client.field442;
            int var1 = client.field443;
            if(client.field368 >= 2 || client.field439 != 0 || client.field448) {
               String var2;
               if(client.field439 == 1 && client.field368 < 2) {
                  var2 = "Use" + " " + client.field447 + " " + "->";
               } else if(client.field448 && client.field368 < 2) {
                  var2 = client.field306 + " " + client.field452 + " " + "->";
               } else {
                  var2 = class104.method2382(client.field368 - 1);
               }

               if(client.field368 > 2) {
                  var2 = var2 + class16.method205(16777215) + " " + '/' + " " + (client.field368 - 2) + " more options";
               }

               class59.field1268.method4178(var2, var0 + 4, 15 + var1, 16777215, 0, client.field305 / 1000);
            }
         }
      } else {
         class133.method2976();
      }

      if(client.field357 == 3) {
         for(var0 = 0; var0 < client.field496; ++var0) {
            if(client.field500[var0]) {
               class82.method1894(client.field501[var0], client.field502[var0], client.field503[var0], client.field504[var0], 16711935, 128);
            } else if(client.field499[var0]) {
               class82.method1894(client.field501[var0], client.field502[var0], client.field503[var0], client.field504[var0], 16711680, 128);
            }
         }
      }

      class116.method2552(class99.field1701, class3.field65.field875, class3.field65.field832, client.field370);
      client.field370 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "503322838"
   )
   protected final class108 vmethod1990() {
      class45 var1 = class110.method2488(this.field722);
      class108 var2;
      if(!this.field725) {
         var2 = var1.method952(this.field723);
      } else {
         var2 = var1.method952(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1093702810"
   )
   static void method696(int var0) {
      if(var0 == -1 && !client.field533) {
         class49.method1056();
      } else if(var0 != -1 && client.field457 != var0 && client.field294 != 0 && !client.field533) {
         class167.method3374(2, class188.field3051, var0, 0, client.field294, false);
      }

      client.field457 = var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "91"
   )
   static int method697(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3936((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.field221.length?var2.field221[var1]:-1);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-353993035"
   )
   static final void method698(int var0, int var1, int var2, int var3) {
      client.field389 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field783;
      int[] var7 = class34.field784;

      int var8;
      for(var8 = 0; var8 < var6 + client.field486; ++var8) {
         Object var19;
         if(var8 < var6) {
            var19 = client.field302[var7[var8]];
            if(client.field425 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var19 = client.field332[client.field334[var8 - var6]];
         }

         class157.method3310((class39)var19, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class157.method3310(client.field302[client.field425], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field389; ++var8) {
         int var9 = client.field380[var8];
         int var10 = client.field330[var8];
         int var11 = client.field394[var8];
         int var12 = client.field505[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > client.field330[var14] - client.field505[var14] && var10 - var12 < client.field330[var14] + 2 && var9 - var11 < client.field380[var14] + client.field394[var14] && var11 + var9 > client.field380[var14] - client.field394[var14] && client.field330[var14] - client.field505[var14] < var10) {
                  var10 = client.field330[var14] - client.field505[var14];
                  var13 = true;
               }
            }
         }

         client.field401 = client.field380[var8];
         client.field402 = client.field330[var8] = var10;
         String var18 = client.field398[var8];
         if(client.field455 == 0) {
            int var15 = 16776960;
            if(client.field395[var8] < 6) {
               var15 = client.field424[client.field395[var8]];
            }

            if(client.field395[var8] == 6) {
               var15 = client.field400 % 20 < 10?16711680:16776960;
            }

            if(client.field395[var8] == 7) {
               var15 = client.field400 % 20 < 10?255:'\uffff';
            }

            if(client.field395[var8] == 8) {
               var15 = client.field400 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field395[var8] == 9) {
               var16 = 150 - client.field516[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = '\uff00' + 5 * (var16 - 100);
               }
            }

            if(client.field395[var8] == 10) {
               var16 = 150 - client.field516[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 5 * var16;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - 5 * (var16 - 100);
               }
            }

            if(client.field395[var8] == 11) {
               var16 = 150 - client.field516[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = '\uff00' + 327685 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(client.field396[var8] == 0) {
               class59.field1268.method4173(var18, var0 + client.field401, var1 + client.field402, var15, 0);
            }

            if(client.field396[var8] == 1) {
               class59.field1268.method4190(var18, var0 + client.field401, var1 + client.field402, var15, 0, client.field400);
            }

            if(client.field396[var8] == 2) {
               class59.field1268.method4176(var18, var0 + client.field401, var1 + client.field402, var15, 0, client.field400);
            }

            if(client.field396[var8] == 3) {
               class59.field1268.method4200(var18, client.field401 + var0, var1 + client.field402, var15, 0, client.field400, 150 - client.field516[var8]);
            }

            if(client.field396[var8] == 4) {
               var16 = (150 - client.field516[var8]) * (class59.field1268.method4165(var18) + 100) / 150;
               class82.method1941(client.field401 + var0 - 50, var1, client.field401 + var0 + 50, var1 + var3);
               class59.field1268.method4170(var18, 50 + var0 + client.field401 - var16, client.field402 + var1, var15, 0);
               class82.method1908(var0, var1, var2 + var0, var1 + var3);
            }

            if(client.field396[var8] == 5) {
               var16 = 150 - client.field516[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1941(var0, var1 + client.field402 - class59.field1268.field3235 - 1, var2 + var0, 5 + client.field402 + var1);
               class59.field1268.method4173(var18, var0 + client.field401, client.field402 + var1 + var17, var15, 0);
               class82.method1908(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class59.field1268.method4173(var18, var0 + client.field401, var1 + client.field402, 16776960, 0);
         }
      }

   }
}

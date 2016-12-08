import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class20 implements Runnable {
   @ObfuscatedName("lg")
   static class216 field222;
   @ObfuscatedName("m")
   Object field223 = new Object();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -221210237
   )
   int field224 = 0;
   @ObfuscatedName("g")
   int[] field225 = new int[500];
   @ObfuscatedName("o")
   boolean field226 = true;
   @ObfuscatedName("h")
   int[] field227 = new int[500];

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1666483285"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class8.method91();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field514 = 0;
            Client.field322 = 0;
            Client.field323 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class13.field143) {
            class13.field143.method2027();
            class13.field143 = null;
         }

         if(Client.gameState == 25) {
            Client.field346 = 0;
            Client.field516 = 0;
            Client.field343 = 1;
            Client.field344 = 0;
            Client.field345 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class26.method569(class36.canvas, class25.field587, class206.field3086, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class26.method569(class36.canvas, class25.field587, class206.field3086, false, 4);
            } else {
               class99.method1899();
            }
         } else {
            class26.method569(class36.canvas, class25.field587, class206.field3086, true, 0);
         }

         Client.gameState = var0;
      }
   }

   public void run() {
      for(; this.field226; XClanMember.method237(50L)) {
         Object var1 = this.field223;
         synchronized(this.field223) {
            if(this.field224 < 500) {
               this.field225[this.field224] = class115.field1814;
               this.field227[this.field224] = class115.field1821;
               ++this.field224;
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1963737387"
   )
   public static void method193(int var0) {
      if(class138.field1929 != 0) {
         class138.field1932 = var0;
      } else {
         class138.field1926.method2447(var0);
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1080180517"
   )
   static final void method194(int var0) {
      if(class2.method25(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2329 = 0;
               var3.field2226 = 0;
            }
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;B)V",
      garbageValue = "81"
   )
   static final void method195(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class143.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.field2905;
         var11 = var9.field2938;
      } else {
         var10 = var9.field2938;
         var11 = var9.field2905;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (1 + var11 >> 1);
      } else {
         var14 = var3;
         var15 = 1 + var3;
      }

      int[][] var16 = class10.tileHeights[var1];
      int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = 1073741824 + (var4 << 14) + var2 + (var3 << 7);
      if(var9.field2909 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field2930 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.field2906 == -1 && var9.impostorIds == null) {
            var22 = var9.method3526(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 22, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.field2907 == 1) {
            var8.method2203(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field2906 == -1 && null == var9.impostorIds) {
               var22 = var9.method3526(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, var6, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
            }

            var7.method1807(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.field2907 != 0) {
               var8.method2198(var2, var3, var10, var11, var9.field2918);
            }

         } else if(var6 == 0) {
            if(var9.field2906 == -1 && null == var9.impostorIds) {
               var22 = var9.method3526(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 0, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
            }

            var7.method1820(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field92[var5], 0, var20, var21);
            if(var9.field2907 != 0) {
               var8.method2200(var2, var3, var6, var5, var9.field2918);
            }

         } else if(var6 == 1) {
            if(var9.field2906 == -1 && null == var9.impostorIds) {
               var22 = var9.method3526(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 1, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
            }

            var7.method1820(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field87[var5], 0, var20, var21);
            if(var9.field2907 != 0) {
               var8.method2200(var2, var3, var6, var5, var9.field2918);
            }

         } else {
            Object var24;
            int var28;
            if(var6 == 2) {
               var28 = var5 + 1 & 3;
               Object var27;
               if(var9.field2906 == -1 && null == var9.impostorIds) {
                  var27 = var9.method3526(2, 4 + var5, var16, var18, var17, var19);
                  var24 = var9.method3526(2, var28, var16, var18, var17, var19);
               } else {
                  var27 = new class49(var4, 2, 4 + var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
                  var24 = new class49(var4, 2, var28, var1, var2, var3, var9.field2906, true, (Renderable)null);
               }

               var7.method1820(var0, var2, var3, var17, (Renderable)var27, (Renderable)var24, class10.field92[var5], class10.field92[var28], var20, var21);
               if(var9.field2907 != 0) {
                  var8.method2200(var2, var3, var6, var5, var9.field2918);
               }

            } else if(var6 == 3) {
               if(var9.field2906 == -1 && null == var9.impostorIds) {
                  var22 = var9.method3526(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 3, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
               }

               var7.method1820(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field87[var5], 0, var20, var21);
               if(var9.field2907 != 0) {
                  var8.method2200(var2, var3, var6, var5, var9.field2918);
               }

            } else if(var6 == 9) {
               if(var9.field2906 == -1 && null == var9.impostorIds) {
                  var22 = var9.method3526(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, var6, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
               }

               var7.method1807(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.field2907 != 0) {
                  var8.method2198(var2, var3, var10, var11, var9.field2918);
               }

            } else if(var6 == 4) {
               if(var9.field2906 == -1 && var9.impostorIds == null) {
                  var22 = var9.method3526(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 4, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
               }

               var7.method1675(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field92[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var28 = 16;
                  var23 = var7.method1823(var0, var2, var3);
                  if(var23 != 0) {
                     var28 = class143.getObjectDefinition(var23 >> 14 & 32767).field2914;
                  }

                  if(var9.field2906 == -1 && var9.impostorIds == null) {
                     var24 = var9.method3526(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
                  }

                  var7.method1675(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class10.field92[var5], 0, class10.field89[var5] * var28, var28 * class10.field95[var5], var20, var21);
               } else if(var6 == 6) {
                  var28 = 8;
                  var23 = var7.method1823(var0, var2, var3);
                  if(var23 != 0) {
                     var28 = class143.getObjectDefinition(var23 >> 14 & 32767).field2914 / 2;
                  }

                  if(var9.field2906 == -1 && var9.impostorIds == null) {
                     var24 = var9.method3526(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, 4 + var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
                  }

                  var7.method1675(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var28 * class10.field100[var5], class10.field97[var5] * var28, var20, var21);
               } else if(var6 == 7) {
                  var23 = 2 + var5 & 3;
                  if(var9.field2906 == -1 && null == var9.impostorIds) {
                     var22 = var9.method3526(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var22 = new class49(var4, 4, var23 + 4, var1, var2, var3, var9.field2906, true, (Renderable)null);
                  }

                  var7.method1675(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var28 = 8;
                  var23 = var7.method1823(var0, var2, var3);
                  if(var23 != 0) {
                     var28 = class143.getObjectDefinition(var23 >> 14 & 32767).field2914 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.field2906 == -1 && var9.impostorIds == null) {
                     var24 = var9.method3526(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method3526(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, 4 + var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
                     var25 = new class49(var4, 4, var26 + 4, var1, var2, var3, var9.field2906, true, (Renderable)null);
                  }

                  var7.method1675(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var28 * class10.field100[var5], var28 * class10.field97[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.field2906 == -1 && null == var9.impostorIds) {
            var22 = var9.method3526(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 10, var5, var1, var2, var3, var9.field2906, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method1807(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field2907 != 0) {
            var8.method2198(var2, var3, var10, var11, var9.field2918);
         }

      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "603856973"
   )
   static void method196(int var0, String var1) {
      int var2 = class45.field900;
      int[] var3 = class45.field902;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(null != var6 && var6 != class5.localPlayer && null != var6.name && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field330.method2967(150);
               Client.field330.method2913(0);
               Client.field330.method2922(var3[var5]);
            } else if(var0 == 4) {
               Client.field330.method2967(201);
               Client.field330.method2815(0);
               Client.field330.method2922(var3[var5]);
            } else if(var0 == 6) {
               Client.field330.method2967(24);
               Client.field330.method2760(var3[var5]);
               Client.field330.method2824(0);
            } else if(var0 == 7) {
               Client.field330.method2967(111);
               Client.field330.method2922(var3[var5]);
               Client.field330.method2752(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class16.method183(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LModIcon;",
      garbageValue = "-1553760306"
   )
   static ModIcon method197(class182 var0, int var1, int var2) {
      if(!Friend.method170(var0, var1, var2)) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class204.field3077;
         var4.originalHeight = class225.field3216;
         var4.offsetX = class211.field3125[0];
         var4.offsetY = class225.field3217[0];
         var4.originalWidth = FaceNormal.field1557[0];
         var4.height = FileOnDisk.field1199[0];
         var4.palette = class225.field3215;
         var4.pixels = XGrandExchangeOffer.field36[0];
         class176.method3182();
         return var4;
      }
   }
}

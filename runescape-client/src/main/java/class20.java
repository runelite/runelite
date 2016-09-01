import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class20 extends Node {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1354587081
   )
   int field565;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = 1433868953
   )
   static int field566;
   @ObfuscatedName("b")
   public static int[] field567;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -221248943
   )
   int field568;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2101673799
   )
   int field570;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 803310711
   )
   static int field571;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -819304339
   )
   int field573;

   class20(int var1, int var2, int var3, int var4) {
      this.field573 = var1;
      this.field570 = var2;
      this.field565 = var3;
      this.field568 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1611694603"
   )
   void method542(int var1, int var2, int var3, int var4) {
      this.field573 = var1;
      this.field570 = var2;
      this.field565 = var3;
      this.field568 = var4;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "3726"
   )
   static final void method543(boolean var0) {
      Client.field524 = 0;
      Client.field321 = 0;
      Client.field446.method2824();
      int var1 = Client.field446.method2827(8);
      int var2;
      if(var1 < Client.field319) {
         for(var2 = var1; var2 < Client.field319; ++var2) {
            Client.field380[++Client.field524 - 1] = Client.field320[var2];
         }
      }

      if(var1 > Client.field319) {
         throw new RuntimeException("");
      } else {
         Client.field319 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         for(var2 = 0; var2 < var1; ++var2) {
            int var13 = Client.field320[var2];
            NPC var4 = Client.cachedNPCs[var13];
            var5 = Client.field446.method2827(1);
            if(var5 == 0) {
               Client.field320[++Client.field319 - 1] = var13;
               var4.field859 = Client.gameCycle;
            } else {
               var6 = Client.field446.method2827(2);
               if(var6 == 0) {
                  Client.field320[++Client.field319 - 1] = var13;
                  var4.field859 = Client.gameCycle;
                  Client.field466[++Client.field321 - 1] = var13;
               } else if(var6 == 1) {
                  Client.field320[++Client.field319 - 1] = var13;
                  var4.field859 = Client.gameCycle;
                  var7 = Client.field446.method2827(3);
                  var4.method716(var7, (byte)1);
                  var8 = Client.field446.method2827(1);
                  if(var8 == 1) {
                     Client.field466[++Client.field321 - 1] = var13;
                  }
               } else if(var6 == 2) {
                  Client.field320[++Client.field319 - 1] = var13;
                  var4.field859 = Client.gameCycle;
                  var7 = Client.field446.method2827(3);
                  var4.method716(var7, (byte)2);
                  var8 = Client.field446.method2827(3);
                  var4.method716(var8, (byte)2);
                  var9 = Client.field446.method2827(1);
                  if(var9 == 1) {
                     Client.field466[++Client.field321 - 1] = var13;
                  }
               } else if(var6 == 3) {
                  Client.field380[++Client.field524 - 1] = var13;
               }
            }
         }

         NPC var3;
         int var14;
         while(Client.field446.method2823(Client.field326) >= 27) {
            var1 = Client.field446.method2827(15);
            if(var1 == 32767) {
               break;
            }

            boolean var15 = false;
            if(Client.cachedNPCs[var1] == null) {
               Client.cachedNPCs[var1] = new NPC();
               var15 = true;
            }

            var3 = Client.cachedNPCs[var1];
            Client.field320[++Client.field319 - 1] = var1;
            var3.field859 = Client.gameCycle;
            var14 = Client.field446.method2827(1);
            var5 = Client.field381[Client.field446.method2827(3)];
            if(var15) {
               var3.angle = var5 * -2044990375;
               var3.field835 = var5;
            }

            if(var0) {
               var6 = Client.field446.method2827(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = Client.field446.method2827(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            if(var0) {
               var7 = Client.field446.method2827(8);
               if(var7 > 127) {
                  var7 -= 256;
               }
            } else {
               var7 = Client.field446.method2827(5);
               if(var7 > 15) {
                  var7 -= 32;
               }
            }

            var8 = Client.field446.method2827(1);
            if(var8 == 1) {
               Client.field466[++Client.field321 - 1] = var1;
            }

            var3.composition = GroundObject.getNpcDefinition(Client.field446.method2827(14));
            var3.field821 = var3.composition.field902;
            var3.field870 = var3.composition.field913;
            if(var3.field870 == 0) {
               var3.angle = 0;
            }

            var3.field825 = var3.composition.field896;
            var3.field826 = var3.composition.field909;
            var3.field827 = var3.composition.field898;
            var3.field869 = var3.composition.field916;
            var3.idlePoseAnimation = var3.composition.field893;
            var3.field839 = var3.composition.field907;
            var3.field852 = var3.composition.field919;
            var3.method729(class48.localPlayer.pathX[0] + var6, class48.localPlayer.pathY[0] + var7, var14 == 1);
         }

         Client.field446.method2822();

         for(var1 = 0; var1 < Client.field321; ++var1) {
            var2 = Client.field466[var1];
            var3 = Client.cachedNPCs[var2];
            var14 = Client.field446.method2556();
            if((var14 & 16) != 0) {
               var5 = Client.field446.method2593();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = Client.field446.method2583();
               if(var5 == var3.animation && var5 != -1) {
                  var7 = class113.getAnimation(var5).replyMode;
                  if(var7 == 1) {
                     var3.actionFrame = 0;
                     var3.field842 = 0;
                     var3.actionAnimationDisable = var6;
                     var3.field853 = 0;
                  }

                  if(var7 == 2) {
                     var3.field853 = 0;
                  }
               } else if(var5 == -1 || var3.animation == -1 || class113.getAnimation(var5).field1004 >= class113.getAnimation(var3.animation).field1004) {
                  var3.animation = var5;
                  var3.actionFrame = 0;
                  var3.field842 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field853 = 0;
                  var3.field822 = var3.field871;
               }
            }

            if((var14 & 64) != 0) {
               var5 = Client.field446.method2592();
               var6 = Client.field446.method2593();
               var7 = var3.x - (var5 - class28.baseX - class28.baseX) * 64;
               var8 = var3.y - (var6 - class159.baseY - class159.baseY) * 64;
               if(var7 != 0 || var8 != 0) {
                  var3.field845 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if((var14 & 2) != 0) {
               var3.overhead = Client.field446.method2774();
               var3.field838 = 100;
            }

            if((var14 & 4) != 0) {
               var3.composition = GroundObject.getNpcDefinition(Client.field446.method2591());
               var3.field821 = var3.composition.field902;
               var3.field870 = var3.composition.field913;
               var3.field825 = var3.composition.field896;
               var3.field826 = var3.composition.field909;
               var3.field827 = var3.composition.field898;
               var3.field869 = var3.composition.field916;
               var3.idlePoseAnimation = var3.composition.field893;
               var3.field839 = var3.composition.field907;
               var3.field852 = var3.composition.field919;
            }

            if((var14 & 32) != 0) {
               var3.interacting = Client.field446.method2592();
               if(var3.interacting == '\uffff') {
                  var3.interacting = -1;
               }
            }

            if((var14 & 8) != 0) {
               var3.graphic = Client.field446.method2593();
               var5 = Client.field446.method2561();
               var3.field858 = var5 >> 16;
               var3.field857 = (var5 & '\uffff') + Client.gameCycle;
               var3.field855 = 0;
               var3.field856 = 0;
               if(var3.field857 > Client.gameCycle) {
                  var3.field855 = -1;
               }

               if(var3.graphic == '\uffff') {
                  var3.graphic = -1;
               }
            }

            if((var14 & 1) != 0) {
               var5 = Client.field446.method2556();
               int var10;
               int var11;
               if(var5 > 0) {
                  for(var6 = 0; var6 < var5; ++var6) {
                     var8 = -1;
                     var9 = -1;
                     var10 = -1;
                     var7 = Client.field446.method2569();
                     if(var7 == 32767) {
                        var7 = Client.field446.method2569();
                        var9 = Client.field446.method2569();
                        var8 = Client.field446.method2569();
                        var10 = Client.field446.method2569();
                     } else if(var7 != 32766) {
                        var9 = Client.field446.method2569();
                     } else {
                        var7 = -1;
                     }

                     var11 = Client.field446.method2569();
                     var3.method751(var7, var9, var8, var10, Client.gameCycle, var11);
                  }
               }

               var6 = Client.field446.method2583();
               if(var6 > 0) {
                  for(var7 = 0; var7 < var6; ++var7) {
                     var8 = Client.field446.method2569();
                     var9 = Client.field446.method2569();
                     if(var9 != 32767) {
                        var10 = Client.field446.method2569();
                        var11 = Client.field446.method2752();
                        int var12 = var9 > 0?Client.field446.method2556():var11;
                        var3.method752(var8, Client.gameCycle, var9, var10, var11, var12);
                     } else {
                        var3.method753(var8);
                     }
                  }
               }
            }
         }

         for(var1 = 0; var1 < Client.field524; ++var1) {
            var2 = Client.field380[var1];
            if(Client.gameCycle != Client.cachedNPCs[var2].field859) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field326 != Client.field446.offset) {
            throw new RuntimeException(Client.field446.offset + "," + Client.field326);
         } else {
            for(var1 = 0; var1 < Client.field319; ++var1) {
               if(Client.cachedNPCs[Client.field320[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field319);
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-649018639"
   )
   static void method546(String var0, String var1, String var2) {
      class33.loginMessage1 = var0;
      class33.loginMessage2 = var1;
      class33.loginMessage3 = var2;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1771153870"
   )
   static final void method547(int var0, int var1, int var2, int var3) {
      Client.field375 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field760;
      int[] var7 = class34.field755;

      int var8;
      for(var8 = 0; var8 < Client.field319 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field411 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field320[var8 - var6]];
         }

         class151.method3180((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class151.method3180(Client.cachedPlayers[Client.field411], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field375; ++var8) {
         int var19 = Client.field475[var8];
         int var10 = Client.field378[var8];
         int var11 = Client.field356[var8];
         int var12 = Client.field379[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var18 = 0; var18 < var8; ++var18) {
               if(var10 + 2 > Client.field378[var18] - Client.field379[var18] && var10 - var12 < Client.field378[var18] + 2 && var19 - var11 < Client.field356[var18] + Client.field475[var18] && var19 + var11 > Client.field475[var18] - Client.field356[var18] && Client.field378[var18] - Client.field379[var18] < var10) {
                  var10 = Client.field378[var18] - Client.field379[var18];
                  var13 = true;
               }
            }
         }

         Client.field387 = Client.field475[var8];
         Client.field388 = Client.field378[var8] = var10;
         String var14 = Client.field384[var8];
         if(Client.field441 == 0) {
            int var15 = 16776960;
            if(Client.field559[var8] < 6) {
               var15 = Client.field554[Client.field559[var8]];
            }

            if(Client.field559[var8] == 6) {
               var15 = Client.field386 % 20 < 10?16711680:16776960;
            }

            if(Client.field559[var8] == 7) {
               var15 = Client.field386 % 20 < 10?255:'\uffff';
            }

            if(Client.field559[var8] == 8) {
               var15 = Client.field386 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field559[var8] == 9) {
               var16 = 150 - Client.field383[var8];
               if(var16 < 50) {
                  var15 = 1280 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(Client.field559[var8] == 10) {
               var16 = 150 - Client.field383[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = 255 + 327680 * (var16 - 100) - 5 * (var16 - 100);
               }
            }

            if(Client.field559[var8] == 11) {
               var16 = 150 - Client.field383[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field382[var8] == 0) {
               VertexNormal.field1680.method4046(var14, Client.field387 + var0, Client.field388 + var1, var15, 0);
            }

            if(Client.field382[var8] == 1) {
               VertexNormal.field1680.method4048(var14, Client.field387 + var0, var1 + Client.field388, var15, 0, Client.field386);
            }

            if(Client.field382[var8] == 2) {
               VertexNormal.field1680.method4049(var14, var0 + Client.field387, var1 + Client.field388, var15, 0, Client.field386);
            }

            if(Client.field382[var8] == 3) {
               VertexNormal.field1680.method4050(var14, var0 + Client.field387, Client.field388 + var1, var15, 0, Client.field386, 150 - Client.field383[var8]);
            }

            if(Client.field382[var8] == 4) {
               var16 = (150 - Client.field383[var8]) * (VertexNormal.field1680.method4099(var14) + 100) / 150;
               class82.method1826(var0 + Client.field387 - 50, var1, Client.field387 + var0 + 50, var1 + var3);
               VertexNormal.field1680.method4079(var14, 50 + var0 + Client.field387 - var16, Client.field388 + var1, var15, 0);
               class82.method1825(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field382[var8] == 5) {
               var16 = 150 - Client.field383[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1826(var0, Client.field388 + var1 - VertexNormal.field1680.field3240 - 1, var0 + var2, Client.field388 + var1 + 5);
               VertexNormal.field1680.method4046(var14, var0 + Client.field387, var17 + var1 + Client.field388, var15, 0);
               class82.method1825(var0, var1, var2 + var0, var3 + var1);
            }
         } else {
            VertexNormal.field1680.method4046(var14, var0 + Client.field387, Client.field388 + var1, 16776960, 0);
         }
      }

   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public final class class31 extends Renderable {
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
   Sequence field720;
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
         this.field720 = class22.getAnimation(var8);
      } else {
         this.field725 = true;
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "-2073716925"
   )
   static final int method689(Widget var0, int var1) {
      if(null != var0.dynamicValues && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
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
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class134.method2983(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class1.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2358[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = WidgetNode.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2354[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class134.method2983(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class1.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class179.widgetSettings[var2[var4++]];
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
                  var7 = class0.baseX + (WidgetNode.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = (WidgetNode.localPlayer.y >> 7) + class21.baseY;
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
      class48.field1078.reset();
      class163.method3330();
      class51.method1116();
      ObjectComposition.field947.reset();
      ObjectComposition.field948.reset();
      ObjectComposition.field963.reset();
      ObjectComposition.field975.reset();
      class159.method3311();
      ItemComposition.field1186.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Friend.method209();
      class45.field1035.reset();
      class45.field1036.reset();
      RSCanvas.method3087();
      Projectile.method92();
      class109.method2484();
      class26.method630();
      class54.method1169();
      Widget.field2801.reset();
      Widget.field2802.reset();
      Widget.field2803.reset();
      Widget.field2861.reset();
      ((TextureProvider)class94.field1658).method2263();
      class23.field611.reset();
      class16.field240.method3408();
      class56.field1236.method3408();
      class164.field2699.method3408();
      class119.field2039.method3408();
      BufferProvider.field1476.method3408();
      class188.field3051.method3408();
      Ignore.field137.method3408();
      Client.field451.method3408();
      ObjectComposition.field964.method3408();
      XClanMember.field644.method3408();
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
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(class14.method179(var0)) {
            GameEngine.method3250(Widget.widgets[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.field496; ++var0) {
         if(Client.field498[var0]) {
            Client.field499[var0] = true;
         }

         Client.field500[var0] = Client.field498[var0];
         Client.field498[var0] = false;
      }

      Client.field497 = Client.gameCycle;
      Client.field442 = -1;
      Client.field443 = -1;
      class132.field2104 = null;
      if(Client.widgetRoot != -1) {
         Client.field496 = 0;
         CollisionData.method2500(Client.widgetRoot, 0, 0, class189.field3056, Actor.field892, 0, 0, -1);
      }

      class82.method1880();
      if(!Client.isMenuOpen) {
         if(Client.field442 != -1) {
            var0 = Client.field442;
            int var1 = Client.field443;
            if(Client.menuOptionCount >= 2 || Client.field439 != 0 || Client.field448) {
               String var2;
               if(Client.field439 == 1 && Client.menuOptionCount < 2) {
                  var2 = "Use " + Client.field447 + " " + "->";
               } else if(Client.field448 && Client.menuOptionCount < 2) {
                  var2 = Client.field306 + " " + Client.field452 + " " + "->";
               } else {
                  var2 = Tile.method2382(Client.menuOptionCount - 1);
               }

               if(Client.menuOptionCount > 2) {
                  var2 = var2 + class16.method205(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
               }

               class59.field1268.method4178(var2, var0 + 4, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
            }
         }
      } else {
         class133.method2976();
      }

      if(Client.field357 == 3) {
         for(var0 = 0; var0 < Client.field496; ++var0) {
            if(Client.field500[var0]) {
               class82.method1894(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field499[var0]) {
               class82.method1894(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      class116.method2552(VertexNormal.plane, WidgetNode.localPlayer.x, WidgetNode.localPlayer.y, Client.field370);
      Client.field370 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "503322838"
   )
   protected final Model getModel() {
      class45 var1 = class110.method2488(this.field722);
      Model var2;
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
      if(var0 == -1 && !Client.field533) {
         class49.method1056();
      } else if(var0 != -1 && Client.field457 != var0 && Client.field294 != 0 && !Client.field533) {
         class167.method3374(2, class188.field3051, var0, 0, Client.field294, false);
      }

      Client.field457 = var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "91"
   )
   static int method697(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3936((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-353993035"
   )
   static final void method698(int var0, int var1, int var2, int var3) {
      Client.field389 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field783;
      int[] var7 = class34.field784;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field486; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field425 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field334[var8 - var6]];
         }

         class157.method3310((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class157.method3310(Client.cachedPlayers[Client.field425], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field389; ++var8) {
         int var18 = Client.field380[var8];
         int var10 = Client.field330[var8];
         int var11 = Client.field394[var8];
         int var12 = Client.field505[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field330[var14] - Client.field505[var14] && var10 - var12 < Client.field330[var14] + 2 && var18 - var11 < Client.field380[var14] + Client.field394[var14] && var11 + var18 > Client.field380[var14] - Client.field394[var14] && Client.field330[var14] - Client.field505[var14] < var10) {
                  var10 = Client.field330[var14] - Client.field505[var14];
                  var13 = true;
               }
            }
         }

         Client.field401 = Client.field380[var8];
         Client.field402 = Client.field330[var8] = var10;
         String var19 = Client.field398[var8];
         if(Client.field455 == 0) {
            int var15 = 16776960;
            if(Client.field395[var8] < 6) {
               var15 = Client.field424[Client.field395[var8]];
            }

            if(Client.field395[var8] == 6) {
               var15 = Client.field400 % 20 < 10?16711680:16776960;
            }

            if(Client.field395[var8] == 7) {
               var15 = Client.field400 % 20 < 10?255:'\uffff';
            }

            if(Client.field395[var8] == 8) {
               var15 = Client.field400 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field395[var8] == 9) {
               var16 = 150 - Client.field516[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = '\uff00' + 5 * (var16 - 100);
               }
            }

            if(Client.field395[var8] == 10) {
               var16 = 150 - Client.field516[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 5 * var16;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - 5 * (var16 - 100);
               }
            }

            if(Client.field395[var8] == 11) {
               var16 = 150 - Client.field516[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = '\uff00' + 327685 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(Client.field396[var8] == 0) {
               class59.field1268.method4173(var19, var0 + Client.field401, var1 + Client.field402, var15, 0);
            }

            if(Client.field396[var8] == 1) {
               class59.field1268.method4190(var19, var0 + Client.field401, var1 + Client.field402, var15, 0, Client.field400);
            }

            if(Client.field396[var8] == 2) {
               class59.field1268.method4176(var19, var0 + Client.field401, var1 + Client.field402, var15, 0, Client.field400);
            }

            if(Client.field396[var8] == 3) {
               class59.field1268.method4200(var19, Client.field401 + var0, var1 + Client.field402, var15, 0, Client.field400, 150 - Client.field516[var8]);
            }

            if(Client.field396[var8] == 4) {
               var16 = (150 - Client.field516[var8]) * (class59.field1268.method4165(var19) + 100) / 150;
               class82.method1941(Client.field401 + var0 - 50, var1, Client.field401 + var0 + 50, var1 + var3);
               class59.field1268.method4170(var19, 50 + var0 + Client.field401 - var16, Client.field402 + var1, var15, 0);
               class82.method1908(var0, var1, var2 + var0, var1 + var3);
            }

            if(Client.field396[var8] == 5) {
               var16 = 150 - Client.field516[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1941(var0, var1 + Client.field402 - class59.field1268.field3235 - 1, var2 + var0, 5 + Client.field402 + var1);
               class59.field1268.method4173(var19, var0 + Client.field401, Client.field402 + var1 + var17, var15, 0);
               class82.method1908(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class59.field1268.method4173(var19, var0 + Client.field401, var1 + Client.field402, 16776960, 0);
         }
      }

   }
}

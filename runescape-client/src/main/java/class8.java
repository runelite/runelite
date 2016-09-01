import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class8 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -934832203
   )
   int field133 = 1;
   @ObfuscatedName("es")
   static SpritePixels[] field135;
   @ObfuscatedName("z")
   boolean field136;
   @ObfuscatedName("b")
   LinkedHashMap field137 = new LinkedHashMap();
   @ObfuscatedName("kf")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("ei")
   static SpritePixels[] field140;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 724386371
   )
   static int field141;
   @ObfuscatedName("lb")
   static class133 field142;
   @ObfuscatedName("eg")
   static SpritePixels field143;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 438014479
   )
   static int field144 = 4;
   @ObfuscatedName("j")
   boolean field145;

   class8(Buffer var1) {
      if(var1 != null && null != var1.payload) {
         int var2 = var1.method2556();
         if(var2 >= 0 && var2 <= field144) {
            if(var1.method2556() == 1) {
               this.field145 = true;
            }

            if(var2 > 1) {
               this.field136 = var1.method2556() == 1;
            }

            if(var2 > 3) {
               this.field133 = var1.method2556();
            }

            if(var2 > 2) {
               int var3 = var1.method2556();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2561();
                  int var6 = var1.method2561();
                  this.field137.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method118(true);
         }
      } else {
         this.method118(true);
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "757142112"
   )
   static final int method112(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
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
                  var10 = World.method628(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!MessageNode.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class179.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class158.field2351[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class179.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class48.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class158.field2352[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = World.method628(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!MessageNode.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(1 + var11 == var10.itemIds[var12]) {
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
                  var7 = Sequence.method901(var9);
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
                  var7 = (class48.localPlayer.x >> 7) + class28.baseX;
               }

               if(var6 == 19) {
                  var7 = (class48.localPlayer.y >> 7) + class159.baseY;
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   static final void method113() {
      int var0;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(class175.method3419(var0)) {
            class85.method1924(Widget.widgets[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.field547; ++var0) {
         if(Client.field484[var0]) {
            Client.field485[var0] = true;
         }

         Client.field486[var0] = Client.field484[var0];
         Client.field484[var0] = false;
      }

      Client.field483 = Client.gameCycle;
      Client.field428 = -1;
      Client.field510 = -1;
      class14.field208 = null;
      if(Client.widgetRoot != -1) {
         Client.field547 = 0;
         class18.method194(Client.widgetRoot, 0, 0, FaceNormal.field1499, class212.field3175, 0, 0, -1);
      }

      class82.method1824();
      int var1;
      if(!Client.isMenuOpen) {
         if(Client.field428 != -1) {
            var0 = Client.field428;
            var1 = Client.field510;
            if(Client.menuOptionCount >= 2 || Client.field432 != 0 || Client.field404) {
               String var2;
               if(Client.field432 == 1 && Client.menuOptionCount < 2) {
                  var2 = "Use" + " " + Client.field433 + " " + "->";
               } else if(Client.field404 && Client.menuOptionCount < 2) {
                  var2 = Client.field437 + " " + Client.field438 + " " + "->";
               } else {
                  int var4 = Client.menuOptionCount - 1;
                  String var3;
                  if(Client.menuTargets[var4].length() > 0) {
                     var3 = Client.menuOptions[var4] + " " + Client.menuTargets[var4];
                  } else {
                     var3 = Client.menuOptions[var4];
                  }

                  var2 = var3;
               }

               if(Client.menuOptionCount > 2) {
                  var2 = var2 + class154.method3185(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
               }

               VertexNormal.field1680.method4051(var2, var0 + 4, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
            }
         }
      } else {
         class13.method155();
      }

      if(Client.field491 == 3) {
         for(var0 = 0; var0 < Client.field547; ++var0) {
            if(Client.field486[var0]) {
               class82.method1856(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field485[var0]) {
               class82.method1856(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = FrameMap.plane;
      var1 = class48.localPlayer.x;
      int var13 = class48.localPlayer.y;
      int var14 = Client.field329;

      for(class24 var11 = (class24)class24.field604.method3850(); null != var11; var11 = (class24)class24.field604.method3852()) {
         if(var11.field611 != -1 || null != var11.field619) {
            int var5 = 0;
            if(var1 > var11.field606) {
               var5 += var1 - var11.field606;
            } else if(var1 < var11.field614) {
               var5 += var11.field614 - var1;
            }

            if(var13 > var11.field607) {
               var5 += var13 - var11.field607;
            } else if(var13 < var11.field605) {
               var5 += var11.field605 - var13;
            }

            if(var5 - 64 <= var11.field608 && Client.field520 != 0 && var0 == var11.field602) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var11.field608 - var5) * Client.field520 / var11.field608;
               Object var10000;
               if(null == var11.field610) {
                  if(var11.field611 >= 0) {
                     var10000 = null;
                     class61 var12 = class61.method1294(class51.field1111, var11.field611, 0);
                     if(var12 != null) {
                        class65 var8 = var12.method1293().method1322(class143.field2215);
                        class67 var9 = class67.method1342(var8, 100, var6);
                        var9.method1345(-1);
                        class14.field205.method1179(var9);
                        var11.field610 = var9;
                     }
                  }
               } else {
                  var11.field610.method1346(var6);
               }

               if(var11.field615 == null) {
                  if(var11.field619 != null && (var11.field613 -= var14) <= 0) {
                     int var7 = (int)(Math.random() * (double)var11.field619.length);
                     var10000 = null;
                     class61 var15 = class61.method1294(class51.field1111, var11.field619[var7], 0);
                     if(var15 != null) {
                        class65 var16 = var15.method1293().method1322(class143.field2215);
                        class67 var10 = class67.method1342(var16, 100, var6);
                        var10.method1345(0);
                        class14.field205.method1179(var10);
                        var11.field615 = var10;
                        var11.field613 = var11.field603 + (int)(Math.random() * (double)(var11.field612 - var11.field603));
                     }
                  }
               } else {
                  var11.field615.method1346(var6);
                  if(!var11.field615.linked()) {
                     var11.field615 = null;
                  }
               }
            } else {
               if(null != var11.field610) {
                  class14.field205.method1180(var11.field610);
                  var11.field610 = null;
               }

               if(var11.field615 != null) {
                  class14.field205.method1180(var11.field615);
                  var11.field615 = null;
               }
            }
         }
      }

      Client.field329 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "-1333344082"
   )
   Buffer method114() {
      Buffer var1 = new Buffer(100);
      var1.method2715(field144);
      var1.method2715(this.field145?1:0);
      var1.method2715(this.field136?1:0);
      var1.method2715(this.field133);
      var1.method2715(this.field137.size());
      Iterator var2 = this.field137.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2544(((Integer)var3.getKey()).intValue());
         var1.method2544(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1490847323"
   )
   void method118(boolean var1) {
   }

   class8() {
      this.method118(true);
   }
}

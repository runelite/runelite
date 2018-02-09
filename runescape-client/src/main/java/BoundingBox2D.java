import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("k")
   static int[] field229;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -488513313
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 822571245
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1084556877
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 812500605
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1217968107
   )
   @Export("color")
   final int color;

   BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1287124829"
   )
   final void draw() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1304948061"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = TextureProvider.font_p12full.method5447(var0, 250);
      int var6 = TextureProvider.font_p12full.method5370(var0, 250) * 13;
      Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      TextureProvider.font_p12full.method5376(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class188.method3796(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         class22.rasterProvider.drawFull(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.widgetCount; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field906[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "322844635"
   )
   static final void method38(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1075 - Client.field1082) * var5 / 100 + Client.field1082;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field982) {
         var15 = Client.field982;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field938) {
            var6 = Client.field938;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1081) {
         var15 = Client.field1081;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1078) {
            var6 = Client.field1078;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field962 - Client.field1076) * var5 / 100 + Client.field1076;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method3041(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Ljv;IIII)V",
      garbageValue = "675147756"
   )
   static final void method37(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3660) {
               if(!var0.field3638 || Client.field992 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + Tile.method2711(var0.combatLevel, GroundObject.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3638 && Client.field1013) {
                     NPCComposition.addMenuEntry("Examine", class70.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     NPCComposition.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class70.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((Occluder.field2038 & 2) == 2) {
                        NPCComposition.addMenuEntry(Client.field854, Client.field995 + " " + "->" + " " + class70.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3638 && Client.field1013?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.numberMenuOptions) {
                        var6 = class84.prependIndices(var6);
                     }

                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              NPCComposition.addMenuEntry(var6[var7], class70.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(AttackOption.AttackOption_hidden != Client.npcAttackOption) {
                                 if(Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > GroundObject.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 NPCComposition.addMenuEntry(var6[var7], class70.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3638 || !Client.field1013) {
                        NPCComposition.addMenuEntry("Examine", class70.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}

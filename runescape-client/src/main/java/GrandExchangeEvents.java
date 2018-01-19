import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("v")
   public static Comparator field264;
   @ObfuscatedName("y")
   public static Comparator field265;
   @ObfuscatedName("r")
   public static Comparator field266;
   @ObfuscatedName("h")
   public static Comparator field267;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static SpritePixels field269;
   @ObfuscatedName("eb")
   @ObfuscatedGetter(
      intValue = -2035131079
   )
   static int field263;
   @ObfuscatedName("n")
   @Export("events")
   public final List events;

   static {
      field264 = new class19();
      new WorldComparator();
      field265 = new UnitPriceComparator();
      field266 = new class18();
      field267 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgv;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "65"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public static boolean method75() {
      ClassInfo var0 = (ClassInfo)class293.classInfos.last();
      return var0 != null;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1468917877"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = CombatInfo1.font_p12full.method5003(var0, 250);
      int var6 = CombatInfo1.font_p12full.method5038(var0, 250) * 13;
      Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      CombatInfo1.font_p12full.method4954(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class23.method167(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2);
      if(var1) {
         class35.rasterProvider.drawFull(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.widgetCount; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field1061[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(Lbm;IIIIII)V",
      garbageValue = "-1101776319"
   )
   @Export("draw2DExtras")
   static final void draw2DExtras(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.hasConfig()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class94.playerIndexesCount;
         int[] var7 = class94.playerIndices;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.isEmpty()) {
            BoundingBox3D.characterToScreen(var0, var0.field1199 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.last(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var10 = var9.method1697(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1698()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4587();
                  SpritePixels var13 = var11.method4586();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3466 * 2 < var13.width) {
                        var15 = var11.field3466;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.cycle;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.int2 > var18) {
                     var20 = var11.field3461 == 0?0:var11.field3461 * (var18 / var11.field3461);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.int2 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field3462 + var10.int2 - var18;
                     if(var11.field3460 >= 0) {
                        var16 = (var20 << 8) / (var11.field3462 - var11.field3460);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenX - (var14 >> 1);
                  var21 = var3 + Client.screenY - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var88 == var14) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.drawAtOpacity(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var88 + var20, var21 + var22);
                        var13.drawAtOpacity(var20, var21, var16);
                     } else {
                        var12.drawAt(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var88 + var20, var21 + var22);
                        var13.drawAt(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenX > -1) {
                        Rasterizer2D.Rasterizer2D_fillRectangle(var20, var21, var88, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var88 + var20, var21, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.hidden) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               BoundingBox3D.characterToScreen(var0, var0.field1199 + 15);
               if(Client.screenX > -1) {
                  if(var85.skullIcon != -1) {
                     class44.headIconsPk[var85.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class18.headIconsPrayer[var85.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               BoundingBox3D.characterToScreen(var0, var0.field1199 + 15);
               if(Client.screenX > -1) {
                  GameEngine.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3661 >= 0 && var86.field3661 < class18.headIconsPrayer.length) {
               BoundingBox3D.characterToScreen(var0, var0.field1199 + 15);
               if(Client.screenX > -1) {
                  class18.headIconsPrayer[var86.field3661].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var74] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               BoundingBox3D.characterToScreen(var0, var0.field1199 + 15);
               if(Client.screenX > -1) {
                  GameEngine.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.publicChatMode == 4 || !var0.field1195 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && class91.isFriended(((Player)var0).name, false))))) {
            BoundingBox3D.characterToScreen(var0, var0.field1199);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.maxOverheadTexts) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = class36.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = class36.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field1114[Client.overheadTextCount] = var0.field1166;
               Client.field955[Client.overheadTextCount] = var0.field1167;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1182[var75];
            class265 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = PacketNode.method3257(var0.field1182[var75]);
               var78 = var87.field3503;
               if(var87 != null && var87.field3507 != null) {
                  var87 = var87.method4682();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1183[var75];
            class265 var79 = null;
            if(var14 >= 0) {
               var79 = PacketNode.method3257(var14);
               if(var79 != null && var79.field3507 != null) {
                  var79 = var79.method4682();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  BoundingBox3D.characterToScreen(var0, var0.field1199 / 2);
                  if(Client.screenX > -1) {
                     if(var75 == 1) {
                        Client.screenY -= 20;
                     }

                     if(var75 == 2) {
                        Client.screenX -= 15;
                        Client.screenY -= 10;
                     }

                     if(var75 == 3) {
                        Client.screenX += 15;
                        Client.screenY -= 10;
                     }

                     SpritePixels var80 = null;
                     SpritePixels var81 = null;
                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var80 = var87.method4677();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4678();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4700();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4680();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4677();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4678();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4700();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4680();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4699();
                     if(var84 == null) {
                        var84 = FileRequest.fontPlain11;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4699();
                        if(var43 == null) {
                           var43 = FileRequest.fontPlain11;
                        }
                     } else {
                        var43 = FileRequest.fontPlain11;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4676(var0.hitsplatTypes[var75]);
                     int var89 = var84.getTextWidth(var44);
                     if(var79 != null) {
                        var45 = var79.method4676(var0.field1192[var75]);
                        var47 = var43.getTextWidth(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var82 == null && var83 == null) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var79 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var79 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.hitsplatCycles[var75] - Client.gameCycle;
                     int var62 = var87.field3511 - var61 * var87.field3511 / var87.field3503;
                     int var63 = var61 * var87.field3499 / var87.field3503 + -var87.field3499;
                     int var64 = var62 + (var2 + Client.screenX - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.screenY - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + var87.field3516 + 15;
                     int var69 = var68 - var84.minSpacing;
                     int var70 = var68 + var84.maxSpacing;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var79 != null) {
                        var71 = var65 + var79.field3516 + 15;
                        var72 = var71 - var43.minSpacing;
                        var73 = var71 + var43.maxSpacing;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3513 >= 0) {
                        var72 = (var61 << 8) / (var87.field3503 - var87.field3513);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.drawAtOpacity(var51 + var64 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.drawAtOpacity(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAtOpacity(var22 * var73 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAtOpacity(var55 + var64 - var28, var65, var72);
                        }

                        var84.method5009(var44, var64 + var54, var68, var87.field3509, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAtOpacity(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.drawAtOpacity(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAtOpacity(var73 * var34 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var59 + var64 - var40, var65, var72);
                           }

                           var43.method5009(var45, var60 + var64, var71, var79.field3509, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.drawAt(var51 + var64 - var25, var65);
                        }

                        if(var82 != null) {
                           var82.drawAt(var52 + var64 - var27, var65);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAt(var73 * var22 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAt(var55 + var64 - var28, var65);
                        }

                        var84.method4950(var44, var64 + var54, var68, var87.field3509 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAt(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.drawAt(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAt(var34 * var73 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAt(var64 + var59 - var40, var65);
                           }

                           var43.method4950(var45, var60 + var64, var71, var79.field3509 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}

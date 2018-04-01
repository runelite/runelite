import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("World")
public class World {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1622430193
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 719315955
   )
   static int field1223;
   @ObfuscatedName("p")
   static int[] field1224;
   @ObfuscatedName("w")
   static int[] field1220;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1630125505
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1287107705
   )
   @Export("id")
   int id;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -417413109
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2064917163
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("f")
   @Export("address")
   String address;
   @ObfuscatedName("l")
   @Export("activity")
   String activity;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 452975209
   )
   @Export("location")
   int location;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1968641635
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1223 = 0;
      field1224 = new int[]{1, 1, 1, 1};
      field1220 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "867548888"
   )
   boolean method1614() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "100"
   )
   boolean method1609() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2141269269"
   )
   boolean method1610() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "102"
   )
   boolean method1624() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1734975376"
   )
   boolean method1612() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1286673565"
   )
   boolean method1613() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgf;I)I",
      garbageValue = "-1804871393"
   )
   static int method1642(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1056576629"
   )
   static final void method1643() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            WorldMapType1.method300(var2, var2.composition.field3702);
         }
      }

   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lbg;IIIIIB)V",
      garbageValue = "80"
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

         int var75 = class93.playerIndexesCount;
         int[] var7 = class93.playerIndices;
         byte var8 = 0;
         Player var10;
         if(var1 < var75 && var0.field1154 == Client.gameCycle) {
            var10 = (Player)var0;
            boolean var9;
            if(Client.playerNameMask == 0) {
               var9 = false;
            } else if(var10 != WorldComparator.localPlayer) {
               boolean var77 = (Client.playerNameMask & 4) != 0;
               boolean var78 = var77;
               boolean var13;
               if(!var77) {
                  var13 = (Client.playerNameMask & 1) != 0;
                  var78 = var13 && var10.isFriend();
               }

               var13 = var78;
               if(!var78) {
                  boolean var79 = (Client.playerNameMask & 2) != 0;
                  var13 = var79 && var10.isClanMember();
               }

               var9 = var13;
            } else {
               var9 = class237.method4379();
            }

            if(var9) {
               Player var11 = (Player)var0;
               if(var1 < var75) {
                  AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight + 15);
                  FontTypeFace var12 = (FontTypeFace)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var92 = 9;
                  var12.drawTextCentered(var11.name.getName(), var2 + Client.screenX, var3 + Client.screenY - var92, 16777215, 0);
                  var8 = 18;
               }
            }
         }

         int var87 = -2;
         int var15;
         int var22;
         int var23;
         if(!var0.combatInfoList.isEmpty()) {
            AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight + 15);

            for(CombatInfoListHolder var88 = (CombatInfoListHolder)var0.combatInfoList.last(); var88 != null; var88 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var89 = var88.method1811(Client.gameCycle);
               if(var89 == null) {
                  if(var88.method1810()) {
                     var88.unlink();
                  }
               } else {
                  CombatInfo2 var91 = var88.combatInfo2;
                  SpritePixels var76 = var91.method4873();
                  SpritePixels var14 = var91.method4860();
                  int var16 = 0;
                  if(var76 != null && var14 != null) {
                     if(var91.field3528 * 2 < var14.width) {
                        var16 = var91.field3528;
                     }

                     var15 = var14.width - var16 * 2;
                  } else {
                     var15 = var91.healthScale;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.gameCycle - var89.cycle;
                  int var20 = var15 * var89.health / var91.healthScale;
                  int var21;
                  int var93;
                  if(var89.int2 > var19) {
                     var21 = var91.field3517 == 0?0:var91.field3517 * (var19 / var91.field3517);
                     var22 = var15 * var89.healthRatio / var91.healthScale;
                     var93 = var21 * (var20 - var22) / var89.int2 + var22;
                  } else {
                     var93 = var20;
                     var21 = var91.field3524 + var89.int2 - var19;
                     if(var91.field3522 >= 0) {
                        var17 = (var21 << 8) / (var91.field3524 - var91.field3522);
                     }
                  }

                  if(var89.health > 0 && var93 < 1) {
                     var93 = 1;
                  }

                  if(var76 != null && var14 != null) {
                     if(var93 == var15) {
                        var93 += var16 * 2;
                     } else {
                        var93 += var16;
                     }

                     var21 = var76.height;
                     var87 += var21;
                     var22 = var2 + Client.screenX - (var15 >> 1);
                     var23 = var3 + Client.screenY - var87;
                     var22 -= var16;
                     if(var17 >= 0 && var17 < 255) {
                        var76.drawAtOpacity(var22, var23, var17);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var93, var23 + var21);
                        var14.drawAtOpacity(var22, var23, var17);
                     } else {
                        var76.drawAt(var22, var23);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var93, var21 + var23);
                        var14.drawAt(var22, var23);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var87 += 2;
                  } else {
                     var87 += 5;
                     if(Client.screenX > -1) {
                        var21 = var2 + Client.screenX - (var15 >> 1);
                        var22 = var3 + Client.screenY - var87;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var93, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var93, var22, var15 - var93, 5, 16711680);
                     }

                     var87 += 2;
                  }
               }
            }
         }

         if(var87 == -2) {
            var87 += 7;
         }

         var87 += var8;
         if(var1 < var75) {
            var10 = (Player)var0;
            if(var10.hidden) {
               return;
            }

            if(var10.skullIcon != -1 || var10.overheadIcon != -1) {
               AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  if(var10.skullIcon != -1) {
                     var87 += 25;
                     class20.headIconsPk[var10.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                  }

                  if(var10.overheadIcon != -1) {
                     var87 += 25;
                     class86.headIconsPrayer[var10.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  var87 += class47.headIconsHint[1].height;
                  class47.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
               }
            }
         } else {
            NPCComposition var90 = ((NPC)var0).composition;
            if(var90.configs != null) {
               var90 = var90.transform();
            }

            if(var90.field3724 >= 0 && var90.field3724 < class86.headIconsPrayer.length) {
               AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  class86.headIconsPrayer[var90.field3724].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  class47.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.field1179 && (Client.publicChatMode == 4 || !var0.field1167 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.field962) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = class228.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = class228.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field1073[Client.overheadTextCount] = var0.field1207;
               Client.field984[Client.overheadTextCount] = var0.field1168;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var80 = 0; var80 < 4; ++var80) {
            int var96 = var0.hitsplatCycles[var80];
            int var97 = var0.field1170[var80];
            class281 var95 = null;
            int var98 = 0;
            if(var97 >= 0) {
               if(var96 <= Client.gameCycle) {
                  continue;
               }

               var95 = BoundingBox2D.method49(var0.field1170[var80]);
               var98 = var95.field3572;
               if(var95 != null && var95.field3569 != null) {
                  var95 = var95.method4993();
                  if(var95 == null) {
                     var0.hitsplatCycles[var80] = -1;
                     continue;
                  }
               }
            } else if(var96 < 0) {
               continue;
            }

            var15 = var0.field1150[var80];
            class281 var81 = null;
            if(var15 >= 0) {
               var81 = BoundingBox2D.method49(var15);
               if(var81 != null && var81.field3569 != null) {
                  var81 = var81.method4993();
               }
            }

            if(var96 - var98 <= Client.gameCycle) {
               if(var95 == null) {
                  var0.hitsplatCycles[var80] = -1;
               } else {
                  AbstractSoundSystem.characterToScreen(var0, var0.logicalHeight / 2);
                  if(Client.screenX > -1) {
                     if(var80 == 1) {
                        Client.screenY -= 20;
                     }

                     if(var80 == 2) {
                        Client.screenX -= 15;
                        Client.screenY -= 10;
                     }

                     if(var80 == 3) {
                        Client.screenX += 15;
                        Client.screenY -= 10;
                     }

                     SpritePixels var82 = null;
                     SpritePixels var83 = null;
                     SpritePixels var84 = null;
                     SpritePixels var85 = null;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     SpritePixels var33 = null;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     var82 = var95.method4988();
                     int var43;
                     if(var82 != null) {
                        var22 = var82.width;
                        var43 = var82.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var82.offsetX;
                     }

                     var83 = var95.method4983();
                     if(var83 != null) {
                        var23 = var83.width;
                        var43 = var83.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var83.offsetX;
                     }

                     var84 = var95.method4968();
                     if(var84 != null) {
                        var24 = var84.width;
                        var43 = var84.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var84.offsetX;
                     }

                     var85 = var95.method4969();
                     if(var85 != null) {
                        var25 = var85.width;
                        var43 = var85.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var85.offsetX;
                     }

                     if(var81 != null) {
                        var30 = var81.method4988();
                        if(var30 != null) {
                           var34 = var30.width;
                           var43 = var30.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var81.method4983();
                        if(var31 != null) {
                           var35 = var31.width;
                           var43 = var31.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var81.method4968();
                        if(var32 != null) {
                           var36 = var32.width;
                           var43 = var32.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.offsetX;
                        }

                        var33 = var81.method4969();
                        if(var33 != null) {
                           var37 = var33.width;
                           var43 = var33.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.offsetX;
                        }
                     }

                     Font var86 = var95.method4984();
                     if(var86 == null) {
                        var86 = class2.fontPlain11;
                     }

                     Font var44;
                     if(var81 != null) {
                        var44 = var81.method4984();
                        if(var44 == null) {
                           var44 = class2.fontPlain11;
                        }
                     } else {
                        var44 = class2.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var95.method4965(var0.hitsplatTypes[var80]);
                     int var94 = var86.getTextWidth(var45);
                     if(var81 != null) {
                        var46 = var81.method4965(var0.field1174[var80]);
                        var48 = var44.getTextWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var23 > 0) {
                        if(var84 == null && var85 == null) {
                           var49 = 1;
                        } else {
                           var49 = var94 / var23 + 1;
                        }
                     }

                     if(var81 != null && var35 > 0) {
                        if(var32 == null && var33 == null) {
                           var50 = 1;
                        } else {
                           var50 = var48 / var35 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var24 > 0) {
                        var51 += var24;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var23 > 0) {
                        var56 = var49 * var23;
                        var51 += var56;
                        var55 += (var56 - var94) / 2;
                     } else {
                        var51 += var94;
                     }

                     var56 = var51;
                     if(var25 > 0) {
                        var51 += var25;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(var81 != null) {
                        var51 += 2;
                        var57 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var36 > 0) {
                           var51 += var36;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var35 > 0) {
                           var62 = var35 * var50;
                           var51 += var62;
                           var61 += (var62 - var48) / 2;
                        } else {
                           var51 += var48;
                        }

                        var60 = var51;
                        if(var37 > 0) {
                           var51 += var37;
                        }
                     }

                     var62 = var0.hitsplatCycles[var80] - Client.gameCycle;
                     int var63 = var95.field3577 - var62 * var95.field3577 / var95.field3572;
                     int var64 = var62 * var95.field3578 / var95.field3572 + -var95.field3578;
                     int var65 = var63 + (var2 + Client.screenX - (var51 >> 1));
                     int var66 = var3 + Client.screenY - 12 + var64;
                     int var67 = var66;
                     int var68 = var42 + var66;
                     int var69 = var66 + var95.field3582 + 15;
                     int var70 = var69 - var86.minSpacing;
                     int var71 = var69 + var86.maxSpacing;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(var81 != null) {
                        var72 = var66 + var81.field3582 + 15;
                        var73 = var72 - var44.minSpacing;
                        var74 = var72 + var44.maxSpacing;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var95.field3579 >= 0) {
                        var73 = (var62 << 8) / (var95.field3572 - var95.field3579);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var82 != null) {
                           var82.drawAtOpacity(var52 + var65 - var26, var66, var73);
                        }

                        if(var84 != null) {
                           var84.drawAtOpacity(var65 + var53 - var28, var66, var73);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAtOpacity(var23 * var74 + (var54 + var65 - var27), var66, var73);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAtOpacity(var65 + var56 - var29, var66, var73);
                        }

                        var86.method5586(var45, var65 + var55, var69, var95.field3571, 0, var73);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAtOpacity(var65 + var57 - var38, var66, var73);
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var65 + var58 - var40, var66, var73);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAtOpacity(var35 * var74 + (var65 + var59 - var39), var66, var73);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAtOpacity(var60 + var65 - var41, var66, var73);
                           }

                           var44.method5586(var46, var61 + var65, var72, var81.field3571, 0, var73);
                        }
                     } else {
                        if(var82 != null) {
                           var82.drawAt(var65 + var52 - var26, var66);
                        }

                        if(var84 != null) {
                           var84.drawAt(var53 + var65 - var28, var66);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAt(var74 * var23 + (var65 + var54 - var27), var66);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAt(var56 + var65 - var29, var66);
                        }

                        var86.method5521(var45, var55 + var65, var69, var95.field3571 | -16777216, 0);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAt(var65 + var57 - var38, var66);
                           }

                           if(var32 != null) {
                              var32.drawAt(var58 + var65 - var40, var66);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAt(var35 * var74 + (var59 + var65 - var39), var66);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAt(var65 + var60 - var41, var66);
                           }

                           var44.method5521(var46, var61 + var65, var72, var81.field3571 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}

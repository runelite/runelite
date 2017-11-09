import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class11 {
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -571366267
   )
   static int field265;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "La;"
   )
   public static final class11 field263;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "La;"
   )
   public static final class11 field261;
   @ObfuscatedName("b")
   public static short[] field266;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 1290179937
   )
   static int field267;

   static {
      field263 = new class11();
      field261 = new class11();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lfg;",
      garbageValue = "21"
   )
   public static PacketNode method60() {
      return PacketNode.field2422 == 0?new PacketNode():PacketNode.field2425[--PacketNode.field2422];
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(Lbf;IIIIIB)V",
      garbageValue = "66"
   )
   static final void method61(Actor var0, int var1, int var2, int var3, int var4, int var5) {
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
         if(!var0.combatInfoList.method3744()) {
            WorldMapData.characterToScreen(var0, var0.field1161 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3741(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3743()) {
               CombatInfo1 var10 = var9.method1757(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1758()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4584();
                  SpritePixels var13 = var11.method4574();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3430 * 2 < var13.width) {
                        var15 = var11.field3430;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var10.field1205;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var88;
                  if(var10.field1206 > var18) {
                     var20 = var11.field3427 == 0?0:var11.field3427 * (var18 / var11.field3427);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.field1206 + var21;
                  } else {
                     var88 = var19;
                     var20 = var10.field1206 + var11.field3426 - var18;
                     if(var11.field3415 >= 0) {
                        var16 = (var20 << 8) / (var11.field3426 - var11.field3415);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenY - (var14 >> 1);
                  var21 = var3 + Client.screenX - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var14 == var88) {
                        var88 += var15 * 2;
                     } else {
                        var88 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5325(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var20 + var88, var22 + var21);
                        var13.method5325(var20, var21, var16);
                     } else {
                        var12.drawAt(var20, var21);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var88 + var20, var21 + var22);
                        var13.drawAt(var20, var21);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var8 += 2;
                  } else {
                     if(Client.screenY > -1) {
                        Rasterizer2D.method5151(var20, var21, var88, 5, 65280);
                        Rasterizer2D.method5151(var88 + var20, var21, var14 - var88, 5, 16711680);
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
               WorldMapData.characterToScreen(var0, var0.field1161 + 15);
               if(Client.screenY > -1) {
                  if(var85.skullIcon != -1) {
                     CacheFile.headIconsPk[var85.skullIcon].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class72.headIconsPrayer[var85.overheadIcon].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               WorldMapData.characterToScreen(var0, var0.field1161 + 15);
               if(Client.screenY > -1) {
                  class229.headIconsHint[1].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3631 >= 0 && var86.field3631 < class72.headIconsPrayer.length) {
               WorldMapData.characterToScreen(var0, var0.field1161 + 15);
               if(Client.screenY > -1) {
                  class72.headIconsPrayer[var86.field3631].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var74] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               WorldMapData.characterToScreen(var0, var0.field1161 + 15);
               if(Client.screenY > -1) {
                  class229.headIconsHint[0].drawAt(var2 + Client.screenY - 12, var3 + Client.screenX - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field1057 == 4 || !var0.field1147 && (Client.field1057 == 0 || Client.field1057 == 3 || Client.field1057 == 1 && Client.isFriended(((Player)var0).name, false))))) {
            WorldMapData.characterToScreen(var0, var0.field1161);
            if(Client.screenY > -1 && Client.field942 < Client.field943) {
               Client.field947[Client.field942] = class20.field320.method4926(var0.overhead) / 2;
               Client.field944[Client.field942] = class20.field320.verticalSpace;
               Client.field1130[Client.field942] = Client.screenY;
               Client.field945[Client.field942] = Client.screenX;
               Client.field948[Client.field942] = var0.field1160;
               Client.field1099[Client.field942] = var0.field1188;
               Client.field1065[Client.field942] = var0.field1148;
               Client.field951[Client.field942] = var0.overhead;
               ++Client.field942;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1169[var75];
            class261 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = class10.method55(var0.field1169[var75]);
               var78 = var87.field3472;
               if(var87 != null && var87.field3483 != null) {
                  var87 = var87.method4656();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1166[var75];
            class261 var79 = null;
            if(var14 >= 0) {
               var79 = class10.method55(var14);
               if(var79 != null && var79.field3483 != null) {
                  var79 = var79.method4656();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  WorldMapData.characterToScreen(var0, var0.field1161 / 2);
                  if(Client.screenY > -1) {
                     if(var75 == 1) {
                        Client.screenX -= 20;
                     }

                     if(var75 == 2) {
                        Client.screenY -= 15;
                        Client.screenX -= 10;
                     }

                     if(var75 == 3) {
                        Client.screenY += 15;
                        Client.screenX -= 10;
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
                     var80 = var87.method4658();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4659();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4690();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4661();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4658();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4659();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4690();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4661();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4662();
                     if(var84 == null) {
                        var84 = class47.field580;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4662();
                        if(var43 == null) {
                           var43 = class47.field580;
                        }
                     } else {
                        var43 = class47.field580;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4684(var0.hitsplatTypes[var75]);
                     int var89 = var84.method4926(var44);
                     if(var79 != null) {
                        var45 = var79.method4684(var0.field1167[var75]);
                        var47 = var43.method4926(var45);
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
                     int var62 = var87.field3477 - var61 * var87.field3477 / var87.field3472;
                     int var63 = var61 * var87.field3478 / var87.field3472 + -var87.field3478;
                     int var64 = var62 + (var2 + Client.screenY - (var50 >> 1));
                     int var65 = var3 + Client.screenX - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + var87.field3470 + 15;
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
                        var71 = var65 + var79.field3470 + 15;
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
                     if(var87.field3464 >= 0) {
                        var72 = (var61 << 8) / (var87.field3472 - var87.field3464);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.method5325(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.method5325(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method5325(var22 * var73 + (var53 + var64 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.method5325(var55 + var64 - var28, var65, var72);
                        }

                        var84.method4932(var44, var54 + var64, var68, var87.field3471, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.method5325(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5325(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5325(var34 * var73 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5325(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4932(var45, var64 + var60, var71, var79.field3471, 0, var72);
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
                              var81.drawAt(var73 * var22 + (var64 + var53 - var26), var65);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAt(var64 + var55 - var28, var65);
                        }

                        var84.method4931(var44, var54 + var64, var68, var87.field3471 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAt(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.drawAt(var57 + var64 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAt(var34 * var73 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAt(var64 + var59 - var40, var65);
                           }

                           var43.method4931(var45, var64 + var60, var71, var79.field3471 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(Lhk;IIIB)V",
      garbageValue = "13"
   )
   static final void method62(Widget var0, int var1, int var2, int var3) {
      class90.method1801();
      class217 var4 = var0.method4183(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2683 + var1, var2 + var4.field2680);
         if(Client.field1085 != 2 && Client.field1085 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = class48.localPlayer.x / 32 + 48;
            int var7 = 464 - class48.localPlayer.y / 32;
            class39.field507.method5289(var1, var2, var4.field2683, var4.field2680, var6, var7, var5, 256, var4.field2681, var4.field2682);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1079; ++var8) {
               var9 = Client.field1120[var8] * 4 + 2 - class48.localPlayer.x / 32;
               var10 = Client.field969[var8] * 4 + 2 - class48.localPlayer.y / 32;
               class56.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[Ignore.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - class48.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class48.localPlayer.y / 32;
                     class56.drawDot(var1, var2, var11, var12, class8.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.hasConfig()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.transform();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3614) {
                     var11 = var18.x / 32 - class48.localPlayer.x / 32;
                     var12 = var18.y / 32 - class48.localPlayer.y / 32;
                     class56.drawDot(var1, var2, var11, var12, class8.mapDots[1], var4);
                  }
               }
            }

            var8 = class94.playerIndexesCount;
            int[] var22 = class94.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != class48.localPlayer) {
                  var12 = var19.x / 32 - class48.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class48.localPlayer.y / 32;
                  boolean var14 = false;
                  if(Client.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < Client.clanChatCount; ++var16) {
                     if(var19.name.equals(DynamicObject.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class48.localPlayer.team != 0 && var19.team != 0 && var19.team == class48.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class56.drawDot(var1, var2, var12, var13, class8.mapDots[3], var4);
                  } else if(var20) {
                     class56.drawDot(var1, var2, var12, var13, class8.mapDots[4], var4);
                  } else if(var15) {
                     class56.drawDot(var1, var2, var12, var13, class8.mapDots[5], var4);
                  } else {
                     class56.drawDot(var1, var2, var12, var13, class8.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class48.localPlayer.x / 32;
                     var12 = var23.y / 32 - class48.localPlayer.y / 32;
                     Script.method1928(var1, var2, var11, var12, Ignore.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - ItemLayer.baseX * 4 + 2 - class48.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - ItemLayer.baseY * 4 + 2 - class48.localPlayer.y / 32;
                  Script.method1928(var1, var2, var10, var11, Ignore.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class48.localPlayer.x / 32;
                     var12 = var24.y / 32 - class48.localPlayer.y / 32;
                     Script.method1928(var1, var2, var11, var12, Ignore.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - class48.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class48.localPlayer.y / 32;
               class56.drawDot(var1, var2, var10, var11, Ignore.mapMarkers[0], var4);
            }

            if(!class48.localPlayer.hidden) {
               Rasterizer2D.method5151(var4.field2683 / 2 + var1 - 1, var4.field2680 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5165(var1, var2, 0, var4.field2681, var4.field2682);
         }

         Client.field1056[var3] = true;
      }
   }
}

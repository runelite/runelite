import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("DState")
public final class DState {
   @ObfuscatedName("o")
   final int field2564;
   @ObfuscatedName("k")
   final int field2544;
   @ObfuscatedName("t")
   final int field2549;
   @ObfuscatedName("d")
   final int field2538;
   @ObfuscatedName("h")
   final int field2539;
   @ObfuscatedName("m")
   final int field2540;
   @ObfuscatedName("z")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1095530927
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1902463339
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("x")
   @Export("out")
   byte[] out;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1891387609
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -625190015
   )
   int field2553;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -845180563
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("n")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1990083591
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -667715381
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1329067841
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -191985273
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 667614551
   )
   int field2541;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1930044721
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1560434239
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("g")
   int[] field2550;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 7622675
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("p")
   int[] field2558;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -679251425
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("ab")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ap")
   boolean[] field2561;
   @ObfuscatedName("ag")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("at")
   byte[] field2563;
   @ObfuscatedName("ac")
   int[] field2562;
   @ObfuscatedName("al")
   byte[] field2565;
   @ObfuscatedName("ah")
   byte[] field2566;
   @ObfuscatedName("af")
   byte[][] field2543;
   @ObfuscatedName("aq")
   int[][] field2568;
   @ObfuscatedName("ai")
   int[][] field2569;
   @ObfuscatedName("az")
   int[][] field2552;
   @ObfuscatedName("aa")
   int[] field2571;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 122707805
   )
   int field2572;

   DState() {
      this.field2564 = 4096;
      this.field2544 = 16;
      this.field2549 = 258;
      this.field2538 = 6;
      this.field2539 = 50;
      this.field2540 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2550 = new int[256];
      this.field2558 = new int[257];
      this.inUse = new boolean[256];
      this.field2561 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2563 = new byte[4096];
      this.field2562 = new int[16];
      this.field2565 = new byte[18002];
      this.field2566 = new byte[18002];
      this.field2543 = new byte[6][258];
      this.field2568 = new int[6][258];
      this.field2569 = new int[6][258];
      this.field2552 = new int[6][258];
      this.field2571 = new int[6];
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(Lba;IIIIII)V",
      garbageValue = "1946728442"
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
         if(var1 < var75 && var0.field1161 == Client.gameCycle) {
            var10 = (Player)var0;
            boolean var9;
            if(Client.playerNameMask == 0) {
               var9 = false;
            } else if(var10 == SoundTaskDataProvider.localPlayer) {
               var9 = class36.method540();
            } else {
               var9 = WidgetNode.method1134() || ISAACCipher.method3821() && var10.isFriend() || World.method1722() && var10.isClanMember();
            }

            if(var9) {
               Player var11 = (Player)var0;
               if(var1 < var75) {
                  WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
                  FontTypeFace var12 = (FontTypeFace)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var13 = 9;
                  var12.drawTextCentered(var11.name.getName(), var2 + Client.screenX, var3 + Client.screenY - var13, 16777215, 0);
                  var8 = 18;
               }
            }
         }

         int var87 = -2;
         int var15;
         int var22;
         int var23;
         if(!var0.combatInfoList.isEmpty()) {
            WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);

            for(CombatInfoListHolder var88 = (CombatInfoListHolder)var0.combatInfoList.last(); var88 != null; var88 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var89 = var88.method1860(Client.gameCycle);
               if(var89 == null) {
                  if(var88.method1858()) {
                     var88.unlink();
                  }
               } else {
                  CombatInfo2 var91 = var88.combatInfo2;
                  SpritePixels var76 = var91.method4863();
                  SpritePixels var14 = var91.method4862();
                  int var16 = 0;
                  if(var76 != null && var14 != null) {
                     if(var91.field3525 * 2 < var14.width) {
                        var16 = var91.field3525;
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
                  int var92;
                  if(var89.int2 > var19) {
                     var21 = var91.field3530 == 0?0:var91.field3530 * (var19 / var91.field3530);
                     var22 = var15 * var89.healthRatio / var91.healthScale;
                     var92 = var21 * (var20 - var22) / var89.int2 + var22;
                  } else {
                     var92 = var20;
                     var21 = var91.field3522 + var89.int2 - var19;
                     if(var91.field3523 >= 0) {
                        var17 = (var21 << 8) / (var91.field3522 - var91.field3523);
                     }
                  }

                  if(var89.health > 0 && var92 < 1) {
                     var92 = 1;
                  }

                  if(var76 != null && var14 != null) {
                     if(var92 == var15) {
                        var92 += var16 * 2;
                     } else {
                        var92 += var16;
                     }

                     var21 = var76.height;
                     var87 += var21;
                     var22 = var2 + Client.screenX - (var15 >> 1);
                     var23 = var3 + Client.screenY - var87;
                     var22 -= var16;
                     if(var17 >= 0 && var17 < 255) {
                        var76.drawAtOpacity(var22, var23, var17);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var92, var21 + var23);
                        var14.drawAtOpacity(var22, var23, var17);
                     } else {
                        var76.drawAt(var22, var23);
                        Rasterizer2D.setInnerDrawRegion(var22, var23, var22 + var92, var21 + var23);
                        var14.drawAt(var22, var23);
                     }

                     Rasterizer2D.setDrawRegion(var2, var3, var2 + var4, var3 + var5);
                     var87 += 2;
                  } else {
                     var87 += 5;
                     if(Client.screenX > -1) {
                        var21 = var2 + Client.screenX - (var15 >> 1);
                        var22 = var3 + Client.screenY - var87;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var92, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var92 + var21, var22, var15 - var92, 5, 16711680);
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
               WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  if(var10.skullIcon != -1) {
                     var87 += 25;
                     GameEngine.headIconsPk[var10.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                  }

                  if(var10.overheadIcon != -1) {
                     var87 += 25;
                     Fonts.headIconsPrayer[var10.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  var87 += BoundingBox3DDrawMode.headIconsHint[1].height;
                  BoundingBox3DDrawMode.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var87);
               }
            }
         } else {
            NPCComposition var90 = ((NPC)var0).composition;
            if(var90.configs != null) {
               var90 = var90.transform();
            }

            if(var90.headIcon >= 0 && var90.headIcon < Fonts.headIconsPrayer.length) {
               WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  Fonts.headIconsPrayer[var90.headIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               WorldMapDecoration.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  BoundingBox3DDrawMode.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var75 || !var0.field1157 && (Client.publicChatMode == 4 || !var0.field1168 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            WorldMapDecoration.characterToScreen(var0, var0.logicalHeight);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.field944) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = MessageNode.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = MessageNode.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field962[Client.overheadTextCount] = var0.field1174;
               Client.field963[Client.overheadTextCount] = var0.field1175;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var77 = 0; var77 < 4; ++var77) {
            int var78 = var0.hitsplatCycles[var77];
            int var79 = var0.field1180[var77];
            class281 var94 = null;
            int var80 = 0;
            if(var79 >= 0) {
               if(var78 <= Client.gameCycle) {
                  continue;
               }

               var94 = Huffman.method3457(var0.field1180[var77]);
               var80 = var94.field3575;
               if(var94 != null && var94.field3586 != null) {
                  var94 = var94.method4962();
                  if(var94 == null) {
                     var0.hitsplatCycles[var77] = -1;
                     continue;
                  }
               }
            } else if(var78 < 0) {
               continue;
            }

            var15 = var0.field1183[var77];
            class281 var81 = null;
            if(var15 >= 0) {
               var81 = Huffman.method3457(var15);
               if(var81 != null && var81.field3586 != null) {
                  var81 = var81.method4962();
               }
            }

            if(var78 - var80 <= Client.gameCycle) {
               if(var94 == null) {
                  var0.hitsplatCycles[var77] = -1;
               } else {
                  WorldMapDecoration.characterToScreen(var0, var0.logicalHeight / 2);
                  if(Client.screenX > -1) {
                     if(var77 == 1) {
                        Client.screenY -= 20;
                     }

                     if(var77 == 2) {
                        Client.screenX -= 15;
                        Client.screenY -= 10;
                     }

                     if(var77 == 3) {
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
                     var82 = var94.method4968();
                     int var43;
                     if(var82 != null) {
                        var22 = var82.width;
                        var43 = var82.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var82.offsetX;
                     }

                     var83 = var94.method4991();
                     if(var83 != null) {
                        var23 = var83.width;
                        var43 = var83.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var83.offsetX;
                     }

                     var84 = var94.method4966();
                     if(var84 != null) {
                        var24 = var84.width;
                        var43 = var84.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var84.offsetX;
                     }

                     var85 = var94.method4981();
                     if(var85 != null) {
                        var25 = var85.width;
                        var43 = var85.height;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var85.offsetX;
                     }

                     if(var81 != null) {
                        var30 = var81.method4968();
                        if(var30 != null) {
                           var34 = var30.width;
                           var43 = var30.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var81.method4991();
                        if(var31 != null) {
                           var35 = var31.width;
                           var43 = var31.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var81.method4966();
                        if(var32 != null) {
                           var36 = var32.width;
                           var43 = var32.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.offsetX;
                        }

                        var33 = var81.method4981();
                        if(var33 != null) {
                           var37 = var33.width;
                           var43 = var33.height;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.offsetX;
                        }
                     }

                     Font var86 = var94.method4970();
                     if(var86 == null) {
                        var86 = class55.fontPlain11;
                     }

                     Font var44;
                     if(var81 != null) {
                        var44 = var81.method4970();
                        if(var44 == null) {
                           var44 = class55.fontPlain11;
                        }
                     } else {
                        var44 = class55.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var94.method4963(var0.hitsplatTypes[var77]);
                     int var93 = var86.getTextWidth(var45);
                     if(var81 != null) {
                        var46 = var81.method4963(var0.field1181[var77]);
                        var48 = var44.getTextWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var23 > 0) {
                        if(var84 == null && var85 == null) {
                           var49 = 1;
                        } else {
                           var49 = var93 / var23 + 1;
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
                        var55 += (var56 - var93) / 2;
                     } else {
                        var51 += var93;
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

                     var62 = var0.hitsplatCycles[var77] - Client.gameCycle;
                     int var63 = var94.field3571 - var62 * var94.field3571 / var94.field3575;
                     int var64 = var62 * var94.field3581 / var94.field3575 + -var94.field3581;
                     int var65 = var63 + (var2 + Client.screenX - (var51 >> 1));
                     int var66 = var3 + Client.screenY - 12 + var64;
                     int var67 = var66;
                     int var68 = var42 + var66;
                     int var69 = var66 + var94.field3584 + 15;
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
                        var72 = var66 + var81.field3584 + 15;
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
                     if(var94.field3582 >= 0) {
                        var73 = (var62 << 8) / (var94.field3575 - var94.field3582);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var82 != null) {
                           var82.drawAtOpacity(var65 + var52 - var26, var66, var73);
                        }

                        if(var84 != null) {
                           var84.drawAtOpacity(var53 + var65 - var28, var66, var73);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAtOpacity(var23 * var74 + (var54 + var65 - var27), var66, var73);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAtOpacity(var56 + var65 - var29, var66, var73);
                        }

                        var86.method5511(var45, var55 + var65, var69, var94.field3574, 0, var73);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAtOpacity(var65 + var57 - var38, var66, var73);
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var58 + var65 - var40, var66, var73);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAtOpacity(var35 * var74 + (var65 + var59 - var39), var66, var73);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAtOpacity(var60 + var65 - var41, var66, var73);
                           }

                           var44.method5511(var46, var61 + var65, var72, var81.field3574, 0, var73);
                        }
                     } else {
                        if(var82 != null) {
                           var82.drawAt(var52 + var65 - var26, var66);
                        }

                        if(var84 != null) {
                           var84.drawAt(var65 + var53 - var28, var66);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAt(var23 * var74 + (var54 + var65 - var27), var66);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAt(var65 + var56 - var29, var66);
                        }

                        var86.method5510(var45, var55 + var65, var69, var94.field3574 | -16777216, 0);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAt(var57 + var65 - var38, var66);
                           }

                           if(var32 != null) {
                              var32.drawAt(var58 + var65 - var40, var66);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAt(var35 * var74 + (var65 + var59 - var39), var66);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAt(var60 + var65 - var41, var66);
                           }

                           var44.method5510(var46, var61 + var65, var72, var81.field3574 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}

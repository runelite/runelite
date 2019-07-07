import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class39 extends class21 {
   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("mapDotSprites")
   static Sprite[] mapDotSprites;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -521428531
   )
   int field318;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 686082379
   )
   int field319;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1610203543
   )
   int field321;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2053974369
   )
   int field323;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "101973298"
   )
   void method714(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != class31.field254.field255) {
         throw new IllegalStateException("");
      } else {
         super.field148 = var1.readUnsignedByte();
         super.field156 = var1.readUnsignedByte();
         super.field149 = var1.readUnsignedShort();
         super.field146 = var1.readUnsignedShort();
         this.field318 = var1.readUnsignedByte();
         this.field319 = var1.readUnsignedByte();
         super.field159 = var1.readUnsignedShort();
         super.field147 = var1.readUnsignedShort();
         this.field321 = var1.readUnsignedByte();
         this.field323 = var1.readUnsignedByte();
         super.field150 = var1.method51();
         super.field152 = var1.method51();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1937224298"
   )
   void vmethod715(Buffer var1) {
      super.field156 = Math.min(super.field156, 4);
      super.field151 = new short[1][64][64];
      super.field145 = new short[super.field156][64][64];
      super.field154 = new byte[super.field156][64][64];
      super.field155 = new byte[super.field156][64][64];
      super.field144 = new WorldMapDecoration[super.field156][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class30.field247.field248) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         int var5 = var1.readUnsignedByte();
         int var6 = var1.readUnsignedByte();
         if (var3 == super.field159 && var4 == super.field147 && var5 == this.field321 && var6 == this.field323) {
            for (int var7 = 0; var7 < 8; ++var7) {
               for (int var8 = 0; var8 < 8; ++var8) {
                  this.method259(var7 + this.field321 * 8, var8 + this.field323 * 8, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2074777367"
   )
   int method717() {
      return this.field318;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-914799830"
   )
   int method718() {
      return this.field319;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "20"
   )
   int method719() {
      return this.field321;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "793815646"
   )
   int method720() {
      return this.field323;
   }

   public int hashCode() {
      return super.field159 | super.field147 << 8 | this.field321 << 16 | this.field323 << 24;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof class39)) {
         return false;
      } else {
         class39 var2 = (class39)var1;
         return var2.field159 == super.field159 && var2.field147 == super.field147 ? this.field321 == var2.field321 && var2.field323 == this.field323 : false;
      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Lbz;IIIIIB)V",
      garbageValue = "-1"
   )
   @Export("drawActor2d")
   static final void drawActor2d(Actor actor, int var1, int var2, int var3, int var4, int var5) {
      if (actor != null && actor.isVisible()) {
         if (actor instanceof NPC) {
            NPCDefinition var6 = ((NPC)actor).definition;
            if (var6.transforms != null) {
               var6 = var6.transform();
            }

            if (var6 == null) {
               return;
            }
         }

         int var77 = Players.Players_count;
         int[] var7 = Players.Players_indices;
         byte var8 = 0;
         Player var9;
         if (var1 < var77 && actor.playerCycle == Client.cycle) {
            var9 = (Player)actor;
            boolean var10;
            if (Client.field210 == 0) {
               var10 = false;
            } else if (var9 != Canvas.localPlayer) {
               boolean var11 = (Client.field210 & 4) != 0;
               boolean var12 = var11;
               boolean var13;
               if (!var11) {
                  var13 = (Client.field210 & 1) != 0;
                  var12 = var13 && var9.isFriend();
               }

               var13 = var12;
               if (!var12) {
                  boolean var14 = (Client.field210 & 2) != 0;
                  var13 = var14 && var9.isClanMember();
               }

               var10 = var13;
            } else {
               var10 = class14.method169();
            }

            if (var10) {
               Player var79 = (Player)actor;
               if (var1 < var77) {
                  DevicePcmPlayerProvider.method840(actor, actor.defaultHeight + 15);
                  AbstractFont var81 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var83 = 9;
                  var81.drawCentered(var79.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var83, 16777215, 0);
                  var8 = 18;
               }
            }
         }

         int var78 = -2;
         int var15;
         int var80;
         int var82;
         int var84;
         int var85;
         if (!actor.healthBars.isEmpty()) {
            DevicePcmPlayerProvider.method840(actor, actor.defaultHeight + 15);

            for (HealthBar var16 = (HealthBar)actor.healthBars.last(); var16 != null; var16 = (HealthBar)actor.healthBars.previous()) {
               HealthBarUpdate var17 = var16.get(Client.cycle);
               if (var17 == null) {
                  if (var16.isEmpty()) {
                     var16.remove();
                  }
               } else {
                  HealthBarDefinition var18 = var16.definition;
                  Sprite var19 = var18.getSprite2();
                  Sprite var20 = var18.getSprite1();
                  int var21 = 0;
                  if (var19 != null && var20 != null) {
                     if (var18.widthPadding * 2 < var20.subWidth) {
                        var21 = var18.widthPadding;
                     }

                     var85 = var20.subWidth - var21 * 2;
                  } else {
                     var85 = var18.width;
                  }

                  int var22 = 255;
                  boolean var23 = true;
                  int var24 = Client.cycle - var17.cycle;
                  int var25 = var85 * var17.health2 / var18.width;
                  if (var17.cycleOffset > var24) {
                     var80 = var18.int4 == 0 ? 0 : var18.int4 * (var24 / var18.int4);
                     var84 = var85 * var17.health / var18.width;
                     var82 = var80 * (var25 - var84) / var17.cycleOffset + var84;
                  } else {
                     var82 = var25;
                     var80 = var17.cycleOffset + var18.int5 - var24;
                     if (var18.int3 >= 0) {
                        var22 = (var80 << 8) / (var18.int5 - var18.int3);
                     }
                  }

                  if (var17.health2 > 0 && var82 < 1) {
                     var82 = 1;
                  }

                  if (var19 != null && var20 != null) {
                     if (var85 == var82) {
                        var82 += var21 * 2;
                     } else {
                        var82 += var21;
                     }

                     var80 = var19.subHeight;
                     var78 += var80;
                     var84 = var2 + Client.viewportTempX - (var85 >> 1);
                     var15 = var3 + Client.viewportTempY - var78;
                     var84 -= var21;
                     if (var22 >= 0 && var22 < 255) {
                        var19.method310(var84, var15, var22);
                        Rasterizer2D.Rasterizer2D_expandClip(var84, var15, var84 + var82, var15 + var80);
                        var20.method310(var84, var15, var22);
                     } else {
                        var19.drawAt2(var84, var15);
                        Rasterizer2D.Rasterizer2D_expandClip(var84, var15, var82 + var84, var80 + var15);
                        var20.drawAt2(var84, var15);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var78 += 2;
                  } else {
                     var78 += 5;
                     if (Client.viewportTempX > -1) {
                        var80 = var2 + Client.viewportTempX - (var85 >> 1);
                        var84 = var3 + Client.viewportTempY - var78;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var80, var84, var82, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var80 + var82, var84, var85 - var82, 5, 16711680);
                     }

                     var78 += 2;
                  }
               }
            }
         }

         if (var78 == -2) {
            var78 += 7;
         }

         var78 += var8;
         if (var1 < var77) {
            var9 = (Player)actor;
            if (var9.isHidden) {
               return;
            }

            if (var9.headIconPk != -1 || var9.headIconPrayer != -1) {
               DevicePcmPlayerProvider.method840(actor, actor.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  if (var9.headIconPk != -1) {
                     var78 += 25;
                     class15.headIconPkSprites[var9.headIconPk].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var78);
                  }

                  if (var9.headIconPrayer != -1) {
                     var78 += 25;
                     ClientPreferences.headIconPrayerSprites[var9.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var78);
                  }
               }
            }

            if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               DevicePcmPlayerProvider.method840(actor, actor.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  var78 += Player.headIconHintSprites[1].subHeight;
                  Player.headIconHintSprites[1].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var78);
               }
            }
         } else {
            NPCDefinition var86 = ((NPC)actor).definition;
            if (var86.transforms != null) {
               var86 = var86.transform();
            }

            if (var86.headIconPrayer >= 0 && var86.headIconPrayer < ClientPreferences.headIconPrayerSprites.length) {
               DevicePcmPlayerProvider.method840(actor, actor.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  ClientPreferences.headIconPrayerSprites[var86.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
               }
            }

            if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var77] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               DevicePcmPlayerProvider.method840(actor, actor.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  Player.headIconHintSprites[0].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         if (actor.overheadText != null && (var1 >= var77 || !actor.field11 && (Client.publicChatMode == 4 || !actor.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)actor).isFriend())))) {
            DevicePcmPlayerProvider.method840(actor, actor.defaultHeight);
            if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
               Client.overheadTextXOffsets[Client.overheadTextCount] = class2.fontBold12.stringWidth(actor.overheadText) / 2;
               Client.overheadTextAscents[Client.overheadTextCount] = class2.fontBold12.ascent;
               Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
               Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
               Client.overheadTextColors[Client.overheadTextCount] = actor.overheadTextColor;
               Client.overheadTextEffects[Client.overheadTextCount] = actor.overheadTextEffect;
               Client.overheadTextCyclesRemaining[Client.overheadTextCount] = actor.overheadTextCyclesRemaining;
               Client.overheadText[Client.overheadTextCount] = actor.overheadText;
               ++Client.overheadTextCount;
            }
         }

         for (int var88 = 0; var88 < 4; ++var88) {
            int var87 = actor.hitSplatCycles[var88];
            int var89 = actor.hitSplatTypes[var88];
            HitSplatDefinition var90 = null;
            int var91 = 0;
            if (var89 >= 0) {
               if (var87 <= Client.cycle) {
                  continue;
               }

               var90 = LoginScreenAnimation.getHitSplatDefinition(actor.hitSplatTypes[var88]);
               var91 = var90.field387;
               if (var90 != null && var90.transforms != null) {
                  var90 = var90.transform();
                  if (var90 == null) {
                     actor.hitSplatCycles[var88] = -1;
                     continue;
                  }
               }
            } else if (var87 < 0) {
               continue;
            }

            var85 = actor.hitSplatTypes2[var88];
            HitSplatDefinition var92 = null;
            if (var85 >= 0) {
               var92 = LoginScreenAnimation.getHitSplatDefinition(var85);
               if (var92 != null && var92.transforms != null) {
                  var92 = var92.transform();
               }
            }

            if (var87 - var91 <= Client.cycle) {
               if (var90 == null) {
                  actor.hitSplatCycles[var88] = -1;
               } else {
                  DevicePcmPlayerProvider.method840(actor, actor.defaultHeight / 2);
                  if (Client.viewportTempX > -1) {
                     if (var88 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if (var88 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if (var88 == 3) {
                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     Sprite var93 = null;
                     Sprite var94 = null;
                     Sprite var95 = null;
                     Sprite var96 = null;
                     var84 = 0;
                     var15 = 0;
                     var80 = 0;
                     var82 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     Sprite var30 = null;
                     Sprite var31 = null;
                     Sprite var32 = null;
                     Sprite var33 = null;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     var93 = var90.method123();
                     int var43;
                     if (var93 != null) {
                        var84 = var93.subWidth;
                        var43 = var93.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var93.yOffset;
                     }

                     var94 = var90.method124();
                     if (var94 != null) {
                        var15 = var94.subWidth;
                        var43 = var94.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var94.yOffset;
                     }

                     var95 = var90.method125();
                     if (var95 != null) {
                        var80 = var95.subWidth;
                        var43 = var95.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var95.yOffset;
                     }

                     var96 = var90.method126();
                     if (var96 != null) {
                        var82 = var96.subWidth;
                        var43 = var96.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var96.yOffset;
                     }

                     if (var92 != null) {
                        var30 = var92.method123();
                        if (var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.yOffset;
                        }

                        var31 = var92.method124();
                        if (var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.yOffset;
                        }

                        var32 = var92.method125();
                        if (var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.yOffset;
                        }

                        var33 = var92.method126();
                        if (var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.yOffset;
                        }
                     }

                     Font var44 = var90.getFont();
                     if (var44 == null) {
                        var44 = ScriptEvent.fontPlain11;
                     }

                     Font var45;
                     if (var92 != null) {
                        var45 = var92.getFont();
                        if (var45 == null) {
                           var45 = ScriptEvent.fontPlain11;
                        }
                     } else {
                        var45 = ScriptEvent.fontPlain11;
                     }

                     String var46 = null;
                     String var47 = null;
                     boolean var48 = false;
                     int var49 = 0;
                     var46 = var90.getString(actor.hitSplatValues[var88]);
                     int var50 = var44.stringWidth(var46);
                     if (var92 != null) {
                        var47 = var92.getString(actor.hitSplatValues2[var88]);
                        var49 = var45.stringWidth(var47);
                     }

                     int var51 = 0;
                     int var52 = 0;
                     if (var15 > 0) {
                        if (var95 == null && var96 == null) {
                           var51 = 1;
                        } else {
                           var51 = var50 / var15 + 1;
                        }
                     }

                     if (var92 != null && var35 > 0) {
                        if (var32 == null && var33 == null) {
                           var52 = 1;
                        } else {
                           var52 = var49 / var35 + 1;
                        }
                     }

                     int var53 = 0;
                     int var54 = var53;
                     if (var84 > 0) {
                        var53 += var84;
                     }

                     var53 += 2;
                     int var55 = var53;
                     if (var80 > 0) {
                        var53 += var80;
                     }

                     int var56 = var53;
                     int var57 = var53;
                     int var58;
                     if (var15 > 0) {
                        var58 = var15 * var51;
                        var53 += var58;
                        var57 += (var58 - var50) / 2;
                     } else {
                        var53 += var50;
                     }

                     var58 = var53;
                     if (var82 > 0) {
                        var53 += var82;
                     }

                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62 = 0;
                     int var63 = 0;
                     int var64;
                     if (var92 != null) {
                        var53 += 2;
                        var59 = var53;
                        if (var34 > 0) {
                           var53 += var34;
                        }

                        var53 += 2;
                        var60 = var53;
                        if (var36 > 0) {
                           var53 += var36;
                        }

                        var61 = var53;
                        var63 = var53;
                        if (var35 > 0) {
                           var64 = var35 * var52;
                           var53 += var64;
                           var63 += (var64 - var49) / 2;
                        } else {
                           var53 += var49;
                        }

                        var62 = var53;
                        if (var37 > 0) {
                           var53 += var37;
                        }
                     }

                     var64 = actor.hitSplatCycles[var88] - Client.cycle;
                     int var65 = var90.field392 - var64 * var90.field392 / var90.field387;
                     int var66 = var64 * var90.field393 / var90.field387 + -var90.field393;
                     int var67 = var65 + (var2 + Client.viewportTempX - (var53 >> 1));
                     int var68 = var66 + (var3 + Client.viewportTempY - 12);
                     int var69 = var68;
                     int var70 = var42 + var68;
                     int var71 = var68 + var90.field397 + 15;
                     int var72 = var71 - var44.maxAscent;
                     int var73 = var71 + var44.maxDescent;
                     if (var72 < var68) {
                        var69 = var72;
                     }

                     if (var73 > var70) {
                        var70 = var73;
                     }

                     int var74 = 0;
                     int var75;
                     int var76;
                     if (var92 != null) {
                        var74 = var68 + var92.field397 + 15;
                        var75 = var74 - var45.maxAscent;
                        var76 = var74 + var45.maxDescent;
                        if (var75 < var69) {
                        }

                        if (var76 > var70) {
                        }
                     }

                     var75 = 255;
                     if (var90.field394 >= 0) {
                        var75 = (var64 << 8) / (var90.field387 - var90.field394);
                     }

                     if (var75 >= 0 && var75 < 255) {
                        if (var93 != null) {
                           var93.method310(var54 + var67 - var26, var68, var75);
                        }

                        if (var95 != null) {
                           var95.method310(var67 + var55 - var28, var68, var75);
                        }

                        if (var94 != null) {
                           for (var76 = 0; var76 < var51; ++var76) {
                              var94.method310(var15 * var76 + (var67 + var56 - var27), var68, var75);
                           }
                        }

                        if (var96 != null) {
                           var96.method310(var58 + var67 - var29, var68, var75);
                        }

                        var44.drawAlpha(var46, var57 + var67, var71, var90.field386, 0, var75);
                        if (var92 != null) {
                           if (var30 != null) {
                              var30.method310(var67 + var59 - var38, var68, var75);
                           }

                           if (var32 != null) {
                              var32.method310(var67 + var60 - var40, var68, var75);
                           }

                           if (var31 != null) {
                              for (var76 = 0; var76 < var52; ++var76) {
                                 var31.method310(var76 * var35 + (var61 + var67 - var39), var68, var75);
                              }
                           }

                           if (var33 != null) {
                              var33.method310(var62 + var67 - var41, var68, var75);
                           }

                           var45.drawAlpha(var47, var63 + var67, var74, var92.field386, 0, var75);
                        }
                     } else {
                        if (var93 != null) {
                           var93.drawAt2(var54 + var67 - var26, var68);
                        }

                        if (var95 != null) {
                           var95.drawAt2(var67 + var55 - var28, var68);
                        }

                        if (var94 != null) {
                           for (var76 = 0; var76 < var51; ++var76) {
                              var94.drawAt2(var15 * var76 + (var56 + var67 - var27), var68);
                           }
                        }

                        if (var96 != null) {
                           var96.drawAt2(var58 + var67 - var29, var68);
                        }

                        var44.draw(var46, var57 + var67, var71, var90.field386 | -16777216, 0);
                        if (var92 != null) {
                           if (var30 != null) {
                              var30.drawAt2(var67 + var59 - var38, var68);
                           }

                           if (var32 != null) {
                              var32.drawAt2(var60 + var67 - var40, var68);
                           }

                           if (var31 != null) {
                              for (var76 = 0; var76 < var52; ++var76) {
                                 var31.drawAt2(var76 * var35 + (var67 + var61 - var39), var68);
                              }
                           }

                           if (var33 != null) {
                              var33.drawAt2(var62 + var67 - var41, var68);
                           }

                           var45.draw(var47, var63 + var67, var74, var92.field386 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "3"
   )
   @Export("drawMenuActionTextAt")
   static final void drawMenuActionTextAt(int var0, int var1) {
      if ((Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) && Client.showMouseOverText) {
         int var2 = Client.menuOptionsCount - 1;
         String var3;
         if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
            var3 = "Use " + Client.selectedItemName + " ->";
         } else if (Client.isSpellSelected && Client.menuOptionsCount < 2) {
            var3 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " ->";
         } else {
            String var4;
            if (var2 < 0) {
               var4 = "";
            } else if (Client.menuTargetNames[var2].length() > 0) {
               var4 = Client.menuActions[var2] + " " + Client.menuTargetNames[var2];
            } else {
               var4 = Client.menuActions[var2];
            }

            var3 = var4;
         }

         if (Client.menuOptionsCount > 2) {
            var3 = var3 + BufferedFile.colorStartTag(16777215) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
         }

         class2.fontBold12.drawRandomAlphaAndSpacing(var3, var0 + 4, var1 + 15, 16777215, 0, Client.cycle / 1000);
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([Lho;Lho;ZI)V",
      garbageValue = "1840850218"
   )
   @Export("revalidateWidgetScroll")
   static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
      int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
      WorldMapRegion.notRevalidateWidgetScroll(var0, var1.id, var3, var4, var2);
      if (var1.children != null) {
         WorldMapRegion.notRevalidateWidgetScroll(var1.children, var1.id, var3, var4, var2);
      }

      InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
      if (var5 != null) {
         int var6 = var5.group;
         if (GroundItemPile.loadInterface(var6)) {
            WorldMapRegion.notRevalidateWidgetScroll(Widget.interfaceComponents[var6], -1, var3, var4, var2);
         }
      }

      if (var1.contentType == 1337) {
      }

   }
}

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
      if(var2 != class31.field254.field255) {
         throw new IllegalStateException("");
      } else {
         super.field148 = var1.readUnsignedByte();
         super.field156 = var1.readUnsignedByte();
         super.field149 = var1.__ag_302();
         super.field146 = var1.__ag_302();
         this.field318 = var1.readUnsignedByte();
         this.field319 = var1.readUnsignedByte();
         super.field159 = var1.__ag_302();
         super.field147 = var1.__ag_302();
         this.field321 = var1.readUnsignedByte();
         this.field323 = var1.readUnsignedByte();
         super.field150 = var1.__ap_310();
         super.field152 = var1.__ap_310();
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
      super.field144 = new class25[super.field156][64][64][];
      int var2 = var1.readUnsignedByte();
      if(var2 != class30.field247.field248) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         int var5 = var1.readUnsignedByte();
         int var6 = var1.readUnsignedByte();
         if(var3 == super.field159 && var4 == super.field147 && var5 == this.field321 && var6 == this.field323) {
            for(int var7 = 0; var7 < 8; ++var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
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
      if(!(var1 instanceof class39)) {
         return false;
      } else {
         class39 var2 = (class39)var1;
         return var2.field159 == super.field159 && var2.field147 == super.field147?this.field321 == var2.field321 && var2.field323 == this.field323:false;
      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Lbz;IIIIIB)V",
      garbageValue = "-1"
   )
   @Export("drawActor2d")
   static final void drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.isVisible()) {
         if(var0 instanceof NPC) {
            NPCDefinition var6 = ((NPC)var0).definition;
            if(var6.transforms != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var77 = Players.Players_count;
         int[] var7 = Players.Players_indices;
         byte var8 = 0;
         Player var9;
         if(var1 < var77 && var0.playerCycle == Client.cycle) {
            var9 = (Player)var0;
            boolean var10;
            if(Client.__client_ke == 0) {
               var10 = false;
            } else if(var9 != Canvas.localPlayer) {
               boolean var11 = (Client.__client_ke & 4) != 0;
               boolean var12 = var11;
               boolean var13;
               if(!var11) {
                  var13 = (Client.__client_ke & 1) != 0;
                  var12 = var13 && var9.isFriend();
               }

               var13 = var12;
               if(!var12) {
                  boolean var14 = (Client.__client_ke & 2) != 0;
                  var13 = var14 && var9.isClanMember();
               }

               var10 = var13;
            } else {
               var10 = class14.method169();
            }

            if(var10) {
               Player var79 = (Player)var0;
               if(var1 < var77) {
                  DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
                  AbstractFont var81 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var84 = 9;
                  var81.drawCentered(var79.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var84, 16777215, 0);
                  var8 = 18;
               }
            }
         }

         int var78 = -2;
         int var24;
         int var25;
         int var80;
         int var82;
         int var85;
         if(!var0.healthBars.isEmpty()) {
            DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);

            for(HealthBar var83 = (HealthBar)var0.healthBars.last(); var83 != null; var83 = (HealthBar)var0.healthBars.previous()) {
               HealthBarUpdate var15 = var83.get(Client.cycle);
               if(var15 == null) {
                  if(var83.isEmpty()) {
                     var83.remove();
                  }
               } else {
                  HealthBarDefinition var16 = var83.definition;
                  Sprite var17 = var16.getSprite2();
                  Sprite var18 = var16.getSprite1();
                  int var19 = 0;
                  if(var17 != null && var18 != null) {
                     if(var16.widthPadding * 2 < var18.subWidth) {
                        var19 = var16.widthPadding;
                     }

                     var80 = var18.subWidth - var19 * 2;
                  } else {
                     var80 = var16.width;
                  }

                  int var20 = 255;
                  boolean var21 = true;
                  int var22 = Client.cycle - var15.cycle;
                  int var23 = var80 * var15.health2 / var16.width;
                  if(var15.cycleOffset > var22) {
                     var24 = var16.int4 == 0?0:var16.int4 * (var22 / var16.int4);
                     var82 = var80 * var15.health / var16.width;
                     var25 = var24 * (var23 - var82) / var15.cycleOffset + var82;
                  } else {
                     var25 = var23;
                     var24 = var15.cycleOffset + var16.int5 - var22;
                     if(var16.int3 >= 0) {
                        var20 = (var24 << 8) / (var16.int5 - var16.int3);
                     }
                  }

                  if(var15.health2 > 0 && var25 < 1) {
                     var25 = 1;
                  }

                  if(var17 != null && var18 != null) {
                     if(var80 == var25) {
                        var25 += var19 * 2;
                     } else {
                        var25 += var19;
                     }

                     var24 = var17.subHeight;
                     var78 += var24;
                     var82 = var2 + Client.viewportTempX - (var80 >> 1);
                     var85 = var3 + Client.viewportTempY - var78;
                     var82 -= var19;
                     if(var20 >= 0 && var20 < 255) {
                        var17.__h_508(var82, var85, var20);
                        Rasterizer2D.Rasterizer2D_expandClip(var82, var85, var82 + var25, var85 + var24);
                        var18.__h_508(var82, var85, var20);
                     } else {
                        var17.drawAt2(var82, var85);
                        Rasterizer2D.Rasterizer2D_expandClip(var82, var85, var25 + var82, var24 + var85);
                        var18.drawAt2(var82, var85);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var78 += 2;
                  } else {
                     var78 += 5;
                     if(Client.viewportTempX > -1) {
                        var24 = var2 + Client.viewportTempX - (var80 >> 1);
                        var82 = var3 + Client.viewportTempY - var78;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var24, var82, var25, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var24 + var25, var82, var80 - var25, 5, 16711680);
                     }

                     var78 += 2;
                  }
               }
            }
         }

         if(var78 == -2) {
            var78 += 7;
         }

         var78 += var8;
         if(var1 < var77) {
            var9 = (Player)var0;
            if(var9.isHidden) {
               return;
            }

            if(var9.headIconPk != -1 || var9.headIconPrayer != -1) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  if(var9.headIconPk != -1) {
                     var78 += 25;
                     class15.headIconPkSprites[var9.headIconPk].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var78);
                  }

                  if(var9.headIconPrayer != -1) {
                     var78 += 25;
                     ClientPreferences.headIconPrayerSprites[var9.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var78);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  var78 += Player.headIconHintSprites[1].subHeight;
                  Player.headIconHintSprites[1].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var78);
               }
            }
         } else {
            NPCDefinition var86 = ((NPC)var0).definition;
            if(var86.transforms != null) {
               var86 = var86.transform();
            }

            if(var86.headIconPrayer >= 0 && var86.headIconPrayer < ClientPreferences.headIconPrayerSprites.length) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  ClientPreferences.headIconPrayerSprites[var86.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
               }
            }

            if(Client.hintArrowType == 1 && Client.npcIndices[var1 - var77] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  Player.headIconHintSprites[0].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         if(var0.overheadText != null && (var1 >= var77 || !var0.__az && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            DevicePcmPlayerProvider.method840(var0, var0.defaultHeight);
            if(Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
               Client.overheadTextXOffsets[Client.overheadTextCount] = class2.fontBold12.stringWidth(var0.overheadText) / 2;
               Client.overheadTextAscents[Client.overheadTextCount] = class2.fontBold12.ascent;
               Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
               Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY;
               Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
               Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
               Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadText[Client.overheadTextCount] = var0.overheadText;
               ++Client.overheadTextCount;
            }
         }

         for(int var88 = 0; var88 < 4; ++var88) {
            int var87 = var0.hitSplatCycles[var88];
            int var89 = var0.hitSplatTypes[var88];
            HitSplatDefinition var90 = null;
            int var91 = 0;
            if(var89 >= 0) {
               if(var87 <= Client.cycle) {
                  continue;
               }

               var90 = class72.getHitSplatDefinition(var0.hitSplatTypes[var88]);
               var91 = var90.__i;
               if(var90 != null && var90.transforms != null) {
                  var90 = var90.transform();
                  if(var90 == null) {
                     var0.hitSplatCycles[var88] = -1;
                     continue;
                  }
               }
            } else if(var87 < 0) {
               continue;
            }

            var80 = var0.hitSplatTypes2[var88];
            HitSplatDefinition var92 = null;
            if(var80 >= 0) {
               var92 = class72.getHitSplatDefinition(var80);
               if(var92 != null && var92.transforms != null) {
                  var92 = var92.transform();
               }
            }

            if(var87 - var91 <= Client.cycle) {
               if(var90 == null) {
                  var0.hitSplatCycles[var88] = -1;
               } else {
                  DevicePcmPlayerProvider.method840(var0, var0.defaultHeight / 2);
                  if(Client.viewportTempX > -1) {
                     if(var88 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if(var88 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if(var88 == 3) {
                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     Sprite var93 = null;
                     Sprite var94 = null;
                     Sprite var95 = null;
                     Sprite var96 = null;
                     var82 = 0;
                     var85 = 0;
                     var24 = 0;
                     var25 = 0;
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
                     var93 = var90.__g_417();
                     int var43;
                     if(var93 != null) {
                        var82 = var93.subWidth;
                        var43 = var93.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var93.yOffset;
                     }

                     var94 = var90.__l_418();
                     if(var94 != null) {
                        var85 = var94.subWidth;
                        var43 = var94.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var94.yOffset;
                     }

                     var95 = var90.__e_419();
                     if(var95 != null) {
                        var24 = var95.subWidth;
                        var43 = var95.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var95.yOffset;
                     }

                     var96 = var90.__x_420();
                     if(var96 != null) {
                        var25 = var96.subWidth;
                        var43 = var96.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var96.yOffset;
                     }

                     if(var92 != null) {
                        var30 = var92.__g_417();
                        if(var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.yOffset;
                        }

                        var31 = var92.__l_418();
                        if(var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.yOffset;
                        }

                        var32 = var92.__e_419();
                        if(var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.yOffset;
                        }

                        var33 = var92.__x_420();
                        if(var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.yOffset;
                        }
                     }

                     Font var44 = var90.getFont();
                     if(var44 == null) {
                        var44 = ScriptEvent.fontPlain11;
                     }

                     Font var45;
                     if(var92 != null) {
                        var45 = var92.getFont();
                        if(var45 == null) {
                           var45 = ScriptEvent.fontPlain11;
                        }
                     } else {
                        var45 = ScriptEvent.fontPlain11;
                     }

                     String var46 = null;
                     String var47 = null;
                     boolean var48 = false;
                     int var49 = 0;
                     var46 = var90.getString(var0.hitSplatValues[var88]);
                     int var50 = var44.stringWidth(var46);
                     if(var92 != null) {
                        var47 = var92.getString(var0.hitSplatValues2[var88]);
                        var49 = var45.stringWidth(var47);
                     }

                     int var51 = 0;
                     int var52 = 0;
                     if(var85 > 0) {
                        if(var95 == null && var96 == null) {
                           var51 = 1;
                        } else {
                           var51 = var50 / var85 + 1;
                        }
                     }

                     if(var92 != null && var35 > 0) {
                        if(var32 == null && var33 == null) {
                           var52 = 1;
                        } else {
                           var52 = var49 / var35 + 1;
                        }
                     }

                     int var53 = 0;
                     int var54 = var53;
                     if(var82 > 0) {
                        var53 += var82;
                     }

                     var53 += 2;
                     int var55 = var53;
                     if(var24 > 0) {
                        var53 += var24;
                     }

                     int var56 = var53;
                     int var57 = var53;
                     int var58;
                     if(var85 > 0) {
                        var58 = var85 * var51;
                        var53 += var58;
                        var57 += (var58 - var50) / 2;
                     } else {
                        var53 += var50;
                     }

                     var58 = var53;
                     if(var25 > 0) {
                        var53 += var25;
                     }

                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62 = 0;
                     int var63 = 0;
                     int var64;
                     if(var92 != null) {
                        var53 += 2;
                        var59 = var53;
                        if(var34 > 0) {
                           var53 += var34;
                        }

                        var53 += 2;
                        var60 = var53;
                        if(var36 > 0) {
                           var53 += var36;
                        }

                        var61 = var53;
                        var63 = var53;
                        if(var35 > 0) {
                           var64 = var35 * var52;
                           var53 += var64;
                           var63 += (var64 - var49) / 2;
                        } else {
                           var53 += var49;
                        }

                        var62 = var53;
                        if(var37 > 0) {
                           var53 += var37;
                        }
                     }

                     var64 = var0.hitSplatCycles[var88] - Client.cycle;
                     int var65 = var90.__t - var64 * var90.__t / var90.__i;
                     int var66 = var64 * var90.__y / var90.__i + -var90.__y;
                     int var67 = var65 + (var2 + Client.viewportTempX - (var53 >> 1));
                     int var68 = var66 + (var3 + Client.viewportTempY - 12);
                     int var69 = var68;
                     int var70 = var42 + var68;
                     int var71 = var68 + var90.__r + 15;
                     int var72 = var71 - var44.maxAscent;
                     int var73 = var71 + var44.maxDescent;
                     if(var72 < var68) {
                        var69 = var72;
                     }

                     if(var73 > var70) {
                        var70 = var73;
                     }

                     int var74 = 0;
                     int var75;
                     int var76;
                     if(var92 != null) {
                        var74 = var68 + var92.__r + 15;
                        var75 = var74 - var45.maxAscent;
                        var76 = var74 + var45.maxDescent;
                        if(var75 < var69) {
                           ;
                        }

                        if(var76 > var70) {
                           ;
                        }
                     }

                     var75 = 255;
                     if(var90.__h >= 0) {
                        var75 = (var64 << 8) / (var90.__i - var90.__h);
                     }

                     if(var75 >= 0 && var75 < 255) {
                        if(var93 != null) {
                           var93.__h_508(var54 + var67 - var26, var68, var75);
                        }

                        if(var95 != null) {
                           var95.__h_508(var67 + var55 - var28, var68, var75);
                        }

                        if(var94 != null) {
                           for(var76 = 0; var76 < var51; ++var76) {
                              var94.__h_508(var85 * var76 + (var67 + var56 - var27), var68, var75);
                           }
                        }

                        if(var96 != null) {
                           var96.__h_508(var58 + var67 - var29, var68, var75);
                        }

                        var44.drawAlpha(var46, var57 + var67, var71, var90.surfaceOffsetY, 0, var75);
                        if(var92 != null) {
                           if(var30 != null) {
                              var30.__h_508(var67 + var59 - var38, var68, var75);
                           }

                           if(var32 != null) {
                              var32.__h_508(var67 + var60 - var40, var68, var75);
                           }

                           if(var31 != null) {
                              for(var76 = 0; var76 < var52; ++var76) {
                                 var31.__h_508(var76 * var35 + (var61 + var67 - var39), var68, var75);
                              }
                           }

                           if(var33 != null) {
                              var33.__h_508(var62 + var67 - var41, var68, var75);
                           }

                           var45.drawAlpha(var47, var63 + var67, var74, var92.surfaceOffsetY, 0, var75);
                        }
                     } else {
                        if(var93 != null) {
                           var93.drawAt2(var54 + var67 - var26, var68);
                        }

                        if(var95 != null) {
                           var95.drawAt2(var67 + var55 - var28, var68);
                        }

                        if(var94 != null) {
                           for(var76 = 0; var76 < var51; ++var76) {
                              var94.drawAt2(var85 * var76 + (var56 + var67 - var27), var68);
                           }
                        }

                        if(var96 != null) {
                           var96.drawAt2(var58 + var67 - var29, var68);
                        }

                        var44.draw(var46, var57 + var67, var71, var90.surfaceOffsetY | -16777216, 0);
                        if(var92 != null) {
                           if(var30 != null) {
                              var30.drawAt2(var67 + var59 - var38, var68);
                           }

                           if(var32 != null) {
                              var32.drawAt2(var60 + var67 - var40, var68);
                           }

                           if(var31 != null) {
                              for(var76 = 0; var76 < var52; ++var76) {
                                 var31.drawAt2(var76 * var35 + (var67 + var61 - var39), var68);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAt2(var62 + var67 - var41, var68);
                           }

                           var45.draw(var47, var63 + var67, var74, var92.surfaceOffsetY | -16777216, 0);
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
      if((Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) && Client.showMouseOverText) {
         int var2 = Client.menuOptionsCount - 1;
         String var3;
         if(Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
            var3 = "Use " + Client.selectedItemName + " ->";
         } else if(Client.isSpellSelected && Client.menuOptionsCount < 2) {
            var3 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " ->";
         } else {
            String var4;
            if(var2 < 0) {
               var4 = "";
            } else if(Client.menuTargetNames[var2].length() > 0) {
               var4 = Client.menuActions[var2] + " " + Client.menuTargetNames[var2];
            } else {
               var4 = Client.menuActions[var2];
            }

            var3 = var4;
         }

         if(Client.menuOptionsCount > 2) {
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
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      WorldMapRegion.notRevalidateWidgetScroll(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         WorldMapRegion.notRevalidateWidgetScroll(var1.children, var1.id, var3, var4, var2);
      }

      WidgetGroupParent var5 = (WidgetGroupParent)Client.widgetGroupParents.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.group;
         if(GroundItemPile.loadWidgetGroup(var6)) {
            WorldMapRegion.notRevalidateWidgetScroll(Widget.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}

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
         if(var0 instanceof Npc) {
            NpcDefinition var6 = ((Npc)var0).definition;
            if(var6.transforms != null) {
               var6 = var6.transform();
            }

            if(var6 == null) {
               return;
            }
         }

         int var75 = Players.Players_count;
         int[] var7 = Players.Players_indices;
         byte var8 = 0;
         Player var10;
         if(var1 < var75 && var0.playerCycle == Client.cycle) {
            var10 = (Player)var0;
            boolean var9;
            if(Client.__client_ke == 0) {
               var9 = false;
            } else if(var10 != Canvas.localPlayer) {
               boolean var77 = (Client.__client_ke & 4) != 0;
               boolean var78 = var77;
               boolean var13;
               if(!var77) {
                  var13 = (Client.__client_ke & 1) != 0;
                  var78 = var13 && var10.isFriend();
               }

               var13 = var78;
               if(!var78) {
                  boolean var79 = (Client.__client_ke & 2) != 0;
                  var13 = var79 && var10.isClanMember();
               }

               var9 = var13;
            } else {
               var9 = class14.method169();
            }

            if(var9) {
               Player var11 = (Player)var0;
               if(var1 < var75) {
                  DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
                  AbstractFont var12 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var92 = 9;
                  var12.drawCentered(var11.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var92, 16777215, 0);
                  var8 = 18;
               }
            }
         }

         int var87 = -2;
         int var15;
         int var22;
         int var23;
         if(!var0.healthBars.isEmpty()) {
            DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);

            for(HealthBar var88 = (HealthBar)var0.healthBars.last(); var88 != null; var88 = (HealthBar)var0.healthBars.previous()) {
               HealthBarUpdate var89 = var88.get(Client.cycle);
               if(var89 == null) {
                  if(var88.isEmpty()) {
                     var88.remove();
                  }
               } else {
                  HealthBarDefinition var91 = var88.definition;
                  Sprite var76 = var91.getSprite2();
                  Sprite var14 = var91.getSprite1();
                  int var16 = 0;
                  if(var76 != null && var14 != null) {
                     if(var91.widthPadding * 2 < var14.subWidth) {
                        var16 = var91.widthPadding;
                     }

                     var15 = var14.subWidth - var16 * 2;
                  } else {
                     var15 = var91.width;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.cycle - var89.cycle;
                  int var20 = var15 * var89.health2 / var91.width;
                  int var21;
                  int var93;
                  if(var89.cycleOffset > var19) {
                     var21 = var91.int4 == 0?0:var91.int4 * (var19 / var91.int4);
                     var22 = var15 * var89.health / var91.width;
                     var93 = var21 * (var20 - var22) / var89.cycleOffset + var22;
                  } else {
                     var93 = var20;
                     var21 = var89.cycleOffset + var91.int5 - var19;
                     if(var91.int3 >= 0) {
                        var17 = (var21 << 8) / (var91.int5 - var91.int3);
                     }
                  }

                  if(var89.health2 > 0 && var93 < 1) {
                     var93 = 1;
                  }

                  if(var76 != null && var14 != null) {
                     if(var15 == var93) {
                        var93 += var16 * 2;
                     } else {
                        var93 += var16;
                     }

                     var21 = var76.subHeight;
                     var87 += var21;
                     var22 = var2 + Client.viewportTempX - (var15 >> 1);
                     var23 = var3 + Client.viewportTempY - var87;
                     var22 -= var16;
                     if(var17 >= 0 && var17 < 255) {
                        var76.__h_508(var22, var23, var17);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var93, var23 + var21);
                        var14.__h_508(var22, var23, var17);
                     } else {
                        var76.drawAt2(var22, var23);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var93 + var22, var21 + var23);
                        var14.drawAt2(var22, var23);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var87 += 2;
                  } else {
                     var87 += 5;
                     if(Client.viewportTempX > -1) {
                        var21 = var2 + Client.viewportTempX - (var15 >> 1);
                        var22 = var3 + Client.viewportTempY - var87;
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
            if(var10.isHidden) {
               return;
            }

            if(var10.headIconPk != -1 || var10.headIconPrayer != -1) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  if(var10.headIconPk != -1) {
                     var87 += 25;
                     class15.headIconPkSprites[var10.headIconPk].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
                  }

                  if(var10.headIconPrayer != -1) {
                     var87 += 25;
                     ClientPreferences.headIconPrayerSprites[var10.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  var87 += Player.headIconHintSprites[1].subHeight;
                  Player.headIconHintSprites[1].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var87);
               }
            }
         } else {
            NpcDefinition var90 = ((Npc)var0).definition;
            if(var90.transforms != null) {
               var90 = var90.transform();
            }

            if(var90.headIconPrayer >= 0 && var90.headIconPrayer < ClientPreferences.headIconPrayerSprites.length) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  ClientPreferences.headIconPrayerSprites[var90.headIconPrayer].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 30);
               }
            }

            if(Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               DevicePcmPlayerProvider.method840(var0, var0.defaultHeight + 15);
               if(Client.viewportTempX > -1) {
                  Player.headIconHintSprites[0].drawAt2(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         if(var0.overheadText != null && (var1 >= var75 || !var0.__az && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
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

         for(int var80 = 0; var80 < 4; ++var80) {
            int var96 = var0.hitSplatCycles[var80];
            int var97 = var0.hitSplatTypes[var80];
            HitSplatDefinition var95 = null;
            int var98 = 0;
            if(var97 >= 0) {
               if(var96 <= Client.cycle) {
                  continue;
               }

               var95 = class72.getHitSplatDefinition(var0.hitSplatTypes[var80]);
               var98 = var95.__i;
               if(var95 != null && var95.transforms != null) {
                  var95 = var95.transform();
                  if(var95 == null) {
                     var0.hitSplatCycles[var80] = -1;
                     continue;
                  }
               }
            } else if(var96 < 0) {
               continue;
            }

            var15 = var0.hitSplatTypes2[var80];
            HitSplatDefinition var81 = null;
            if(var15 >= 0) {
               var81 = class72.getHitSplatDefinition(var15);
               if(var81 != null && var81.transforms != null) {
                  var81 = var81.transform();
               }
            }

            if(var96 - var98 <= Client.cycle) {
               if(var95 == null) {
                  var0.hitSplatCycles[var80] = -1;
               } else {
                  DevicePcmPlayerProvider.method840(var0, var0.defaultHeight / 2);
                  if(Client.viewportTempX > -1) {
                     if(var80 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if(var80 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if(var80 == 3) {
                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     Sprite var82 = null;
                     Sprite var83 = null;
                     Sprite var84 = null;
                     Sprite var85 = null;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
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
                     var82 = var95.__g_417();
                     int var43;
                     if(var82 != null) {
                        var22 = var82.subWidth;
                        var43 = var82.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var82.yOffset;
                     }

                     var83 = var95.__l_418();
                     if(var83 != null) {
                        var23 = var83.subWidth;
                        var43 = var83.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var83.yOffset;
                     }

                     var84 = var95.__e_419();
                     if(var84 != null) {
                        var24 = var84.subWidth;
                        var43 = var84.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var84.yOffset;
                     }

                     var85 = var95.__x_420();
                     if(var85 != null) {
                        var25 = var85.subWidth;
                        var43 = var85.subHeight;
                        if(var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var85.yOffset;
                     }

                     if(var81 != null) {
                        var30 = var81.__g_417();
                        if(var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.yOffset;
                        }

                        var31 = var81.__l_418();
                        if(var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.yOffset;
                        }

                        var32 = var81.__e_419();
                        if(var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.yOffset;
                        }

                        var33 = var81.__x_420();
                        if(var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if(var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.yOffset;
                        }
                     }

                     Font var86 = var95.getFont();
                     if(var86 == null) {
                        var86 = ScriptEvent.fontPlain11;
                     }

                     Font var44;
                     if(var81 != null) {
                        var44 = var81.getFont();
                        if(var44 == null) {
                           var44 = ScriptEvent.fontPlain11;
                        }
                     } else {
                        var44 = ScriptEvent.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var95.getString(var0.hitSplatValues[var80]);
                     int var94 = var86.stringWidth(var45);
                     if(var81 != null) {
                        var46 = var81.getString(var0.hitSplatValues2[var80]);
                        var48 = var44.stringWidth(var46);
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
                        var56 = var23 * var49;
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

                     var62 = var0.hitSplatCycles[var80] - Client.cycle;
                     int var63 = var95.__t - var62 * var95.__t / var95.__i;
                     int var64 = var62 * var95.__y / var95.__i + -var95.__y;
                     int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
                     int var66 = var64 + (var3 + Client.viewportTempY - 12);
                     int var67 = var66;
                     int var68 = var42 + var66;
                     int var69 = var66 + var95.__r + 15;
                     int var70 = var69 - var86.maxAscent;
                     int var71 = var69 + var86.maxDescent;
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
                        var72 = var66 + var81.__r + 15;
                        var73 = var72 - var44.maxAscent;
                        var74 = var72 + var44.maxDescent;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var95.__h >= 0) {
                        var73 = (var62 << 8) / (var95.__i - var95.__h);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var82 != null) {
                           var82.__h_508(var52 + var65 - var26, var66, var73);
                        }

                        if(var84 != null) {
                           var84.__h_508(var65 + var53 - var28, var66, var73);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.__h_508(var23 * var74 + (var65 + var54 - var27), var66, var73);
                           }
                        }

                        if(var85 != null) {
                           var85.__h_508(var56 + var65 - var29, var66, var73);
                        }

                        var86.drawAlpha(var45, var55 + var65, var69, var95.__n, 0, var73);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.__h_508(var65 + var57 - var38, var66, var73);
                           }

                           if(var32 != null) {
                              var32.__h_508(var65 + var58 - var40, var66, var73);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.__h_508(var74 * var35 + (var59 + var65 - var39), var66, var73);
                              }
                           }

                           if(var33 != null) {
                              var33.__h_508(var60 + var65 - var41, var66, var73);
                           }

                           var44.drawAlpha(var46, var61 + var65, var72, var81.__n, 0, var73);
                        }
                     } else {
                        if(var82 != null) {
                           var82.drawAt2(var52 + var65 - var26, var66);
                        }

                        if(var84 != null) {
                           var84.drawAt2(var65 + var53 - var28, var66);
                        }

                        if(var83 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var83.drawAt2(var23 * var74 + (var54 + var65 - var27), var66);
                           }
                        }

                        if(var85 != null) {
                           var85.drawAt2(var56 + var65 - var29, var66);
                        }

                        var86.draw(var45, var55 + var65, var69, var95.__n | -16777216, 0);
                        if(var81 != null) {
                           if(var30 != null) {
                              var30.drawAt2(var65 + var57 - var38, var66);
                           }

                           if(var32 != null) {
                              var32.drawAt2(var58 + var65 - var40, var66);
                           }

                           if(var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawAt2(var74 * var35 + (var65 + var59 - var39), var66);
                              }
                           }

                           if(var33 != null) {
                              var33.drawAt2(var60 + var65 - var41, var66);
                           }

                           var44.draw(var46, var61 + var65, var72, var81.__n | -16777216, 0);
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
      if(Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) {
         if(Client.showMouseOverText) {
            int var2 = Client.menuOptionsCount - 1;
            String var4;
            if(Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
               var4 = "Use" + " " + Client.selectedItemName + " " + "->";
            } else if(Client.isSpellSelected && Client.menuOptionsCount < 2) {
               var4 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " " + "->";
            } else {
               String var5;
               if(var2 < 0) {
                  var5 = "";
               } else if(Client.menuTargetNames[var2].length() > 0) {
                  var5 = Client.menuActions[var2] + " " + Client.menuTargetNames[var2];
               } else {
                  var5 = Client.menuActions[var2];
               }

               var4 = var5;
            }

            if(Client.menuOptionsCount > 2) {
               var4 = var4 + BufferedFile.colorStartTag(0xffffff) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
            }

            class2.fontBold12.drawRandomAlphaAndSpacing(var4, var0 + 4, var1 + 15, 0xffffff, 0, Client.cycle / 1000);
         }
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

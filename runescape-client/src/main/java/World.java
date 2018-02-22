import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("World")
public class World {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lbs;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1379698839
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2101294155
   )
   static int field1167;
   @ObfuscatedName("y")
   static int[] field1168;
   @ObfuscatedName("g")
   static int[] field1166;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2054770689
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1335858747
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1304532959
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("v")
   @Export("address")
   String address;
   @ObfuscatedName("s")
   @Export("activity")
   String activity;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1287809811
   )
   @Export("location")
   int location;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -927919443
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1167 = 0;
      field1168 = new int[]{1, 1, 1, 1};
      field1166 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-13492"
   )
   boolean method1643() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "56"
   )
   boolean method1675() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2024842254"
   )
   boolean method1645() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1916637115"
   )
   boolean method1663() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "22"
   )
   boolean method1654() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-100"
   )
   boolean method1664() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-412394831"
   )
   public static void method1680(String[] var0, short[] var1) {
      class20.method166(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1286406689"
   )
   static final void method1682(String var0) {
      StringBuilder var10000 = (new StringBuilder()).append(var0);
      Object var10001 = null;
      String var1 = var10000.append(" is already on your friend list").toString();
      class149.sendGameMessage(30, "", var1);
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(I)Lll;",
      garbageValue = "89800568"
   )
   static RenderOverview method1681() {
      return BoundingBox3D.renderOverview;
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lim;IIB)V",
      garbageValue = "-38"
   )
   static final void method1678(Widget var0, int var1, int var2) {
      if(Client.field834 == 0 || Client.field834 == 3) {
         if(MouseInput.mouseLastButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class230 var3 = var0.method4429(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4362(var4, var5)) {
               var4 -= var3.field2732 / 2;
               var5 -= var3.field2730 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var8 * var4 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + OwnWorldComparator.localPlayer.x >> 7;
               int var12 = OwnWorldComparator.localPlayer.y - var10 >> 7;
               PacketNode var13 = class61.method1076(ClientPacket.field2427, Client.field863.field1434);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.writeIntLE16(var11 + ScriptState.baseX);
               var13.packetBuffer.putShortLE(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.writeIntLE16(var12 + WorldMapType1.baseY);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(OwnWorldComparator.localPlayer.x);
               var13.packetBuffer.putShort(OwnWorldComparator.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field863.method2039(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(Lbq;IIIIII)V",
      garbageValue = "-259680310"
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

         int var74 = class92.playerIndexesCount;
         int[] var7 = class92.playerIndices;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.isEmpty()) {
            WorldMapType2.characterToScreen(var0, var0.logicalHeight + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.last(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.previous()) {
               CombatInfo1 var10 = var9.method1823(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1826()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4842();
                  SpritePixels var13 = var11.method4841();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3464 * 2 < var13.width) {
                        var15 = var11.field3464;
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
                     var20 = var11.field3463 == 0?0:var11.field3463 * (var18 / var11.field3463);
                     var21 = var14 * var10.healthRatio / var11.healthScale;
                     var88 = var20 * (var19 - var21) / var10.int2 + var21;
                  } else {
                     var88 = var19;
                     var20 = var11.field3460 + var10.int2 - var18;
                     if(var11.field3462 >= 0) {
                        var16 = (var20 << 8) / (var11.field3460 - var11.field3462);
                     }
                  }

                  if(var10.health > 0 && var88 < 1) {
                     var88 = 1;
                  }

                  var20 = var2 + Client.screenX - (var14 >> 1);
                  var21 = var3 + Client.screenY - var8;
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
                        var12.drawAtOpacity(var20, var21, var16);
                        Rasterizer2D.setInnerDrawRegion(var20, var21, var88 + var20, var22 + var21);
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
                        Rasterizer2D.Rasterizer2D_fillRectangle(var20 + var88, var21, var14 - var88, 5, 16711680);
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
               WorldMapType2.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  if(var85.skullIcon != -1) {
                     WidgetNode.headIconsPk[var85.skullIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class162.headIconsPrayer[var85.overheadIcon].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.hintArrowTargetType == 10 && var7[var1] == Client.hintArrowPlayerTargetIdx) {
               WorldMapType2.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  FaceNormal.headIconsHint[1].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.transform();
            }

            if(var86.field3635 >= 0 && var86.field3635 < class162.headIconsPrayer.length) {
               WorldMapType2.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  class162.headIconsPrayer[var86.field3635].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 30);
               }
            }

            if(Client.hintArrowTargetType == 1 && Client.npcIndices[var1 - var74] == Client.hintArrowNpcTargetIdx && Client.gameCycle % 20 < 10) {
               WorldMapType2.characterToScreen(var0, var0.logicalHeight + 15);
               if(Client.screenX > -1) {
                  FaceNormal.headIconsHint[0].drawAt(var2 + Client.screenX - 12, var3 + Client.screenY - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.publicChatMode == 4 || !var0.field1103 && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            WorldMapType2.characterToScreen(var0, var0.logicalHeight);
            if(Client.screenX > -1 && Client.overheadTextCount < Client.maxOverheadTexts) {
               Client.overheadTextsOffsetX[Client.overheadTextCount] = class153.fontBold12.getTextWidth(var0.overhead) / 2;
               Client.overheadTextsOffsetY[Client.overheadTextCount] = class153.fontBold12.verticalSpace;
               Client.overheadTextsX[Client.overheadTextCount] = Client.screenX;
               Client.overheadTextsY[Client.overheadTextCount] = Client.screenY;
               Client.field901[Client.overheadTextCount] = var0.field1111;
               Client.field902[Client.overheadTextCount] = var0.field1112;
               Client.overheadTextsCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadTexts[Client.overheadTextCount] = var0.overhead;
               ++Client.overheadTextCount;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var76 = var0.hitsplatCycles[var75];
            int var77 = var0.field1114[var75];
            class274 var87 = null;
            int var78 = 0;
            if(var77 >= 0) {
               if(var76 <= Client.gameCycle) {
                  continue;
               }

               var87 = NPC.method1847(var0.field1114[var75]);
               var78 = var87.field3516;
               if(var87 != null && var87.field3514 != null) {
                  var87 = var87.method4919();
                  if(var87 == null) {
                     var0.hitsplatCycles[var75] = -1;
                     continue;
                  }
               }
            } else if(var76 < 0) {
               continue;
            }

            var14 = var0.field1117[var75];
            class274 var79 = null;
            if(var14 >= 0) {
               var79 = NPC.method1847(var14);
               if(var79 != null && var79.field3514 != null) {
                  var79 = var79.method4919();
               }
            }

            if(var76 - var78 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.hitsplatCycles[var75] = -1;
               } else {
                  WorldMapType2.characterToScreen(var0, var0.logicalHeight / 2);
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
                     var80 = var87.method4921();
                     int var42;
                     if(var80 != null) {
                        var21 = var80.width;
                        var42 = var80.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var80.offsetX;
                     }

                     var81 = var87.method4938();
                     if(var81 != null) {
                        var22 = var81.width;
                        var42 = var81.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.offsetX;
                     }

                     var82 = var87.method4923();
                     if(var82 != null) {
                        var23 = var82.width;
                        var42 = var82.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var82.offsetX;
                     }

                     var83 = var87.method4937();
                     if(var83 != null) {
                        var24 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var83.offsetX;
                     }

                     if(var79 != null) {
                        var29 = var79.method4921();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var79.method4938();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var79.method4923();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var79.method4937();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4925();
                     if(var84 == null) {
                        var84 = class259.fontPlain11;
                     }

                     Font var43;
                     if(var79 != null) {
                        var43 = var79.method4925();
                        if(var43 == null) {
                           var43 = class259.fontPlain11;
                        }
                     } else {
                        var43 = class259.fontPlain11;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4920(var0.hitsplatTypes[var75]);
                     int var89 = var84.getTextWidth(var44);
                     if(var79 != null) {
                        var45 = var79.method4920(var0.field1118[var75]);
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
                        var55 = var22 * var48;
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
                           var61 = var34 * var49;
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
                     int var62 = var87.field3509 - var61 * var87.field3509 / var87.field3516;
                     int var63 = var61 * var87.field3496 / var87.field3516 + -var87.field3496;
                     int var64 = var62 + (var2 + Client.screenX - (var50 >> 1));
                     int var65 = var63 + (var3 + Client.screenY - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + var87.field3503 + 15;
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
                        var71 = var65 + var79.field3503 + 15;
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
                     if(var87.field3510 >= 0) {
                        var72 = (var61 << 8) / (var87.field3516 - var87.field3510);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var80 != null) {
                           var80.drawAtOpacity(var64 + var51 - var25, var65, var72);
                        }

                        if(var82 != null) {
                           var82.drawAtOpacity(var64 + var52 - var27, var65, var72);
                        }

                        if(var81 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.drawAtOpacity(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var83 != null) {
                           var83.drawAtOpacity(var55 + var64 - var28, var65, var72);
                        }

                        var84.method5452(var44, var54 + var64, var68, var87.field3502, 0, var72);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAtOpacity(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.drawAtOpacity(var64 + var57 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAtOpacity(var34 * var73 + (var64 + var58 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAtOpacity(var64 + var59 - var40, var65, var72);
                           }

                           var43.method5452(var45, var64 + var60, var71, var79.field3502, 0, var72);
                        }
                     } else {
                        if(var80 != null) {
                           var80.drawAt(var64 + var51 - var25, var65);
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

                        var84.method5451(var44, var54 + var64, var68, var87.field3502 | -16777216, 0);
                        if(var79 != null) {
                           if(var29 != null) {
                              var29.drawAt(var64 + var56 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.drawAt(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.drawAt(var73 * var34 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.drawAt(var64 + var59 - var40, var65);
                           }

                           var43.method5451(var45, var64 + var60, var71, var79.field3502 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}

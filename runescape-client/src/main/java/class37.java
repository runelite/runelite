import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class37 {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = -1859169745
   )
   static int field485;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   static final class37 field481;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   static final class37 field482;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -991014029
   )
   final int field483;

   static {
      field481 = new class37(0);
      field482 = new class37(1);
   }

   class37(int var1) {
      this.field483 = var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "310441734"
   )
   static int method521(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class237.plane;
         int var13 = (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX;
         int var5 = (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY;
         class150.method3134().method6021(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var15;
         if(var0 == 6601) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            String var20 = "";
            var15 = class150.method3134().getWorldMapDataByFileId(var3);
            if(var15 != null) {
               var20 = var15.getName();
            }

            class81.scriptStringStack[++World.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            class150.method3134().method6026(var3);
            return 1;
         } else if(var0 == 6603) {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6036();
            return 1;
         } else if(var0 == 6604) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            class150.method3134().method6133(var3);
            return 1;
         } else if(var0 == 6605) {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6038()?1:0;
            return 1;
         } else {
            Coordinates var19;
            if(var0 == 6606) {
               var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
               class150.method3134().method6097(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6607) {
               var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
               class150.method3134().method6143(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6608) {
               var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
               class150.method3134().method6042(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6609) {
               var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
               class150.method3134().method6196(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6610) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6181();
               class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6081();
               return 1;
            } else {
               WorldMapData var17;
               if(var0 == 6611) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var17 = class150.method3134().getWorldMapDataByFileId(var3);
                  if(var17 == null) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.method357().bitpack();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var17 = class150.method3134().getWorldMapDataByFileId(var3);
                  if(var17 == null) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = (var17.method319() - var17.getMinX() + 1) * 64;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = (var17.method313() - var17.getMinY() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var17 = class150.method3134().getWorldMapDataByFileId(var3);
                  if(var17 == null) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  } else {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.getMinX() * 64;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.getMinY() * 64;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.method319() * 64 + 64 - 1;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.method313() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var17 = class150.method3134().getWorldMapDataByFileId(var3);
                  if(var17 == null) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.method352();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var19 = class150.method3134().method6053();
                  if(var19 == null) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var19.worldX;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = var19.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6131();
                  return 1;
               } else if(var0 == 6617) {
                  var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
                  var17 = class150.method3134().method6024();
                  if(var17 == null) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var18 = var17.method309(var19.plane, var19.worldX, var19.worldY);
                     if(var18 == null) {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                     } else {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = var18[0];
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = var18[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var11;
                  if(var0 == 6618) {
                     var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
                     var17 = class150.method3134().method6024();
                     if(var17 == null) {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var11 = var17.method354(var19.worldX, var19.worldY);
                        if(var11 == null) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var11.bitpack();
                        }

                        return 1;
                     }
                  } else {
                     int var6;
                     int var7;
                     int var8;
                     Coordinates var9;
                     Coordinates var16;
                     if(var0 == 6619) {
                        SceneTilePaint.intStackSize -= 2;
                        var3 = class81.intStack[SceneTilePaint.intStackSize];
                        var16 = new Coordinates(class81.intStack[SceneTilePaint.intStackSize + 1]);
                        var15 = class150.method3134().getWorldMapDataByFileId(var3);
                        var6 = WorldComparator.localPlayer.field842;
                        var7 = (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX;
                        var8 = (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        class150.method3134().method6202(var15, var9, var16, false);
                        return 1;
                     } else if(var0 == 6620) {
                        SceneTilePaint.intStackSize -= 2;
                        var3 = class81.intStack[SceneTilePaint.intStackSize];
                        var16 = new Coordinates(class81.intStack[SceneTilePaint.intStackSize + 1]);
                        var15 = class150.method3134().getWorldMapDataByFileId(var3);
                        var6 = WorldComparator.localPlayer.field842;
                        var7 = (WorldComparator.localPlayer.x >> 7) + PacketNode.baseX;
                        var8 = (WorldComparator.localPlayer.y >> 7) + BaseVarType.baseY;
                        var9 = new Coordinates(var6, var7, var8);
                        class150.method3134().method6202(var15, var9, var16, true);
                        return 1;
                     } else if(var0 == 6621) {
                        SceneTilePaint.intStackSize -= 2;
                        var3 = class81.intStack[SceneTilePaint.intStackSize];
                        var16 = new Coordinates(class81.intStack[SceneTilePaint.intStackSize + 1]);
                        var15 = class150.method3134().getWorldMapDataByFileId(var3);
                        if(var15 == null) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var15.containsCoord(var16.plane, var16.worldX, var16.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6173();
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6084();
                        return 1;
                     } else if(var0 == 6623) {
                        var19 = new Coordinates(class81.intStack[--SceneTilePaint.intStackSize]);
                        var17 = class150.method3134().getWorldMapDataContainingCoord(var19.plane, var19.worldX, var19.worldY);
                        if(var17 == null) {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                        } else {
                           class81.intStack[++SceneTilePaint.intStackSize - 1] = var17.getFileId();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class150.method3134().method6030(class81.intStack[--SceneTilePaint.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        class150.method3134().method6050();
                        return 1;
                     } else if(var0 == 6626) {
                        class150.method3134().method6051(class81.intStack[--SceneTilePaint.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        class150.method3134().method6052();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           class150.method3134().method6066(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class81.intStack[--SceneTilePaint.intStackSize];
                           class150.method3134().method6054(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class81.intStack[--SceneTilePaint.intStackSize];
                           class150.method3134().method6075(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           class150.method3134().method6056();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                           class150.method3134().method6057(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              SceneTilePaint.intStackSize -= 2;
                              var3 = class81.intStack[SceneTilePaint.intStackSize];
                              var4 = class81.intStack[SceneTilePaint.intStackSize + 1] == 1;
                              class150.method3134().method6058(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              SceneTilePaint.intStackSize -= 2;
                              var3 = class81.intStack[SceneTilePaint.intStackSize];
                              var4 = class81.intStack[SceneTilePaint.intStackSize + 1] == 1;
                              class150.method3134().method6059(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6060()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6061(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class81.intStack[--SceneTilePaint.intStackSize];
                              class81.intStack[++SceneTilePaint.intStackSize - 1] = class150.method3134().method6062(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              SceneTilePaint.intStackSize -= 2;
                              var3 = class81.intStack[SceneTilePaint.intStackSize];
                              var16 = new Coordinates(class81.intStack[SceneTilePaint.intStackSize + 1]);
                              var11 = class150.method3134().method6065(var3, var16);
                              if(var11 == null) {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                              } else {
                                 class81.intStack[++SceneTilePaint.intStackSize - 1] = var11.bitpack();
                              }

                              return 1;
                           } else {
                              MapIcon var12;
                              if(var0 == 6639) {
                                 var12 = class150.method3134().method6080();
                                 if(var12 == null) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var12.areaId;
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var12.field512.bitpack();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var12 = class150.method3134().method6068();
                                 if(var12 == null) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                 } else {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var12.areaId;
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var12.field512.bitpack();
                                 }

                                 return 1;
                              } else {
                                 Area var10;
                                 if(var0 == 6693) {
                                    var3 = class81.intStack[--SceneTilePaint.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    if(var10.name == null) {
                                       class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                                    } else {
                                       class81.scriptStringStack[++World.scriptStringStackSize - 1] = var10.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class81.intStack[--SceneTilePaint.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = var10.field3449;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class81.intStack[--SceneTilePaint.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    if(var10 == null) {
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = var10.field3463;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class81.intStack[--SceneTilePaint.intStackSize];
                                    var10 = Area.mapAreaType[var3];
                                    if(var10 == null) {
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                                    } else {
                                       class81.intStack[++SceneTilePaint.intStackSize - 1] = var10.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = class36.scriptMapIconReference.areaId;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = class36.scriptMapIconReference.field576.bitpack();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class81.intStack[++SceneTilePaint.intStackSize - 1] = class36.scriptMapIconReference.field574.bitpack();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Lbx;ZB)V",
      garbageValue = "93"
   )
   static void method523(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field843 << 14;
         var0.isLowDetail = false;
         if((Client.lowMemory && class93.playerIndexesCount > 50 || class93.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.isLowDetail = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.animationCycleStart && Client.gameCycle < var0.animationCycleEnd) {
               var0.isLowDetail = false;
               var0.field828 = class5.getTileHeight(var0.x, var0.y, class237.plane);
               var0.field1154 = Client.gameCycle;
               class308.region.method2888(class237.plane, var0.x, var0.y, var0.field828, 60, var0, var0.angle, var2, var0.field835, var0.field826, var0.field848, var0.field838);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field952[var3][var4] == Client.field953) {
                     return;
                  }

                  Client.field952[var3][var4] = Client.field953;
               }

               var0.field828 = class5.getTileHeight(var0.x, var0.y, class237.plane);
               var0.field1154 = Client.gameCycle;
               class308.region.method3006(class237.plane, var0.x, var0.y, var0.field828, 60, var0, var0.angle, var2, var0.field1181);
            }
         }
      }

   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1514463203"
   )
   static final void method524(int var0, int var1, int var2, int var3) {
      if(Client.field937) {
         if(Client.cursorState == 1) {
            WorldComparator.crossSprites[Client.field958 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
         }

         if(Client.cursorState == 2) {
            WorldComparator.crossSprites[Client.field958 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
         }
      }

      class55.method827();
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lbx;IIIB)V",
      garbageValue = "-57"
   )
   static final void method522(Player var0, int var1, int var2, int var3) {
      if(WorldComparator.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = WorldComparator.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class173.getColTags(16711680);
               } else if(var9 < -6) {
                  var6 = class173.getColTags(16723968);
               } else if(var9 < -3) {
                  var6 = class173.getColTags(16740352);
               } else if(var9 < 0) {
                  var6 = class173.getColTags(16756736);
               } else if(var9 > 9) {
                  var6 = class173.getColTags(65280);
               } else if(var9 > 6) {
                  var6 = class173.getColTags(4259584);
               } else if(var9 > 3) {
                  var6 = class173.getColTags(8453888);
               } else if(var9 > 0) {
                  var6 = class173.getColTags(12648192);
               } else {
                  var6 = class173.getColTags(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var10;
            if(Client.itemSelectionState == 1) {
               RunException.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class173.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class241.field2799 & 8) == 8) {
                  RunException.addMenuEntry(Client.field956, Client.field1015 + " " + "->" + " " + class173.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(Client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(Client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(AttackOption.AttackOption_hidden == Client.playerAttackOption) {
                           continue;
                        }

                        if(AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > WorldComparator.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(WorldComparator.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == WorldComparator.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.playerMenuTypes[var10] + var11;
                     RunException.addMenuEntry(Client.playerOptions[var10], class173.getColTags(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class173.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}

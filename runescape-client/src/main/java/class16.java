import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class16 {
   @ObfuscatedName("ol")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lbp;"
   )
   static class72 field85;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache10")
   static IndexCache indexCache10;
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("mapMarkerSprites")
   static Sprite[] mapMarkerSprites;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1434501763"
   )
   public static int method190(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "1394688825"
   )
   static int method188(int var0, Script var1, boolean var2) {
      Widget var3 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      if(var0 == 1800) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class211.method4107(class1.getWidgetClickMask(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(Lgf;I)V",
      garbageValue = "1917804788"
   )
   static final void method189(class190 var0) {
      PacketBuffer var1 = Client.packetWriter.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      byte var10;
      int var11;
      if(class190.field2342 == var0) {
         byte var12 = var1.__bk_320();
         var2 = var1.__bm_326();
         byte var13 = var1.__bk_320();
         var3 = var1.__bu_325();
         var4 = var1.__ag_302();
         var5 = var1.__bb_317();
         var6 = var5 >> 2;
         var7 = var5 & 3;
         var8 = Client.__client_gd[var6];
         byte var14 = var1.__bn_319();
         var9 = var1.__by_324();
         var10 = var1.__bk_320();
         var11 = var1.readUnsignedByteNegate();
         int var15 = (var11 >> 4 & 7) + WorldMapSection3.__p_go;
         int var16 = (var11 & 7) + Canvas.__ao_gk;
         Player var17;
         if(var9 == Client.localPlayerIndex) {
            var17 = Canvas.localPlayer;
         } else {
            var17 = Client.players[var9];
         }

         if(var17 != null) {
            ObjectDefinition var18 = class50.getObjectDefinition(var3);
            int var19;
            int var20;
            if(var7 != 1 && var7 != 3) {
               var19 = var18.sizeX;
               var20 = var18.sizeY;
            } else {
               var19 = var18.sizeY;
               var20 = var18.sizeX;
            }

            int var21 = var15 + (var19 >> 1);
            int var22 = var15 + (var19 + 1 >> 1);
            int var23 = var16 + (var20 >> 1);
            int var24 = var16 + (var20 + 1 >> 1);
            int[][] var25 = Tiles.Tiles_heights[SoundSystem.plane];
            int var26 = var25[var22][var23] + var25[var21][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
            int var27 = (var15 << 7) + (var19 << 6);
            int var28 = (var16 << 7) + (var20 << 6);
            Model var29 = var18.getModel(var6, var7, var25, var27, var26, var28);
            if(var29 != null) {
               class258.method4898(SoundSystem.plane, var15, var16, var8, -1, 0, 0, var4 + 1, var2 + 1);
               var17.animationCycleStart = var4 + Client.cycle;
               var17.animationCycleEnd = var2 + Client.cycle;
               var17.model0 = var29;
               var17.__k = var15 * 128 + var19 * 64;
               var17.__i = var16 * 128 + var20 * 64;
               var17.tileHeight2 = var26;
               byte var30;
               if(var12 > var10) {
                  var30 = var12;
                  var12 = var10;
                  var10 = var30;
               }

               if(var14 > var13) {
                  var30 = var14;
                  var14 = var13;
                  var13 = var30;
               }

               var17.__z = var15 + var12;
               var17.__s = var10 + var15;
               var17.__j = var14 + var16;
               var17.__t = var13 + var16;
            }
         }
      }

      int var31;
      int var32;
      if(class190.field2349 == var0) {
         var31 = var1.__bb_317();
         var2 = (var31 >> 4 & 7) + WorldMapSection3.__p_go;
         var32 = (var31 & 7) + Canvas.__ao_gk;
         var3 = var1.__bq_318();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.__client_gd[var4];
         var7 = var1.__bu_325();
         if(var2 >= 0 && var32 >= 0 && var2 < 104 && var32 < 104) {
            class258.method4898(SoundSystem.plane, var2, var32, var6, var7, var4, var5, 0, -1);
         }
      } else {
         if(class190.field2345 == var0) {
            var31 = var1.readUnsignedByte();
            var2 = (var31 >> 4 & 7) + WorldMapSection3.__p_go;
            var32 = (var31 & 7) + Canvas.__ao_gk;
            var3 = var1.__bq_318();
            var4 = var1.__bb_317();
            var5 = var4 >> 4 & 15;
            var6 = var4 & 7;
            var7 = var1.__bm_326();
            if(var2 >= 0 && var32 >= 0 && var2 < 104 && var32 < 104) {
               var8 = var5 + 1;
               if(Canvas.localPlayer.pathX[0] >= var2 - var8 && Canvas.localPlayer.pathX[0] <= var8 + var2 && Canvas.localPlayer.pathY[0] >= var32 - var8 && Canvas.localPlayer.pathY[0] <= var8 + var32 && Client.__client_qc != 0 && var6 > 0 && Client.soundEffectCount < 50) {
                  Client.soundEffectIds[Client.soundEffectCount] = var7;
                  Client.unknownSoundValues1[Client.soundEffectCount] = var6;
                  Client.queuedSoundEffectDelays[Client.soundEffectCount] = var3;
                  Client.soundEffects[Client.soundEffectCount] = null;
                  Client.soundLocations[Client.soundEffectCount] = var5 + (var32 << 8) + (var2 << 16);
                  ++Client.soundEffectCount;
               }
            }
         }

         if(class190.field2341 == var0) {
            var31 = var1.__ag_302();
            var2 = var1.__bb_317();
            var32 = var1.__bu_325();
            var3 = var1.readUnsignedByte();
            var4 = (var3 >> 4 & 7) + WorldMapSection3.__p_go;
            var5 = (var3 & 7) + Canvas.__ao_gk;
            if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               var4 = var4 * 128 + 64;
               var5 = var5 * 128 + 64;
               GraphicsObject var33 = new GraphicsObject(var31, SoundSystem.plane, var4, var5, class32.getTileHeight(var4, var5, SoundSystem.plane) - var2, var32, Client.cycle);
               Client.graphicsObjects.addFirst(var33);
            }
         } else {
            int var35;
            if(class190.field2344 == var0) {
               var31 = var1.__bq_318();
               var2 = var31 >> 2;
               var32 = var31 & 3;
               var3 = Client.__client_gd[var2];
               var4 = var1.readUnsignedByteNegate();
               var5 = (var4 >> 4 & 7) + WorldMapSection3.__p_go;
               var6 = (var4 & 7) + Canvas.__ao_gk;
               var7 = var1.__ag_302();
               if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
                  if(var3 == 0) {
                     BoundaryObject var34 = class65.scene.getBoundaryObject(SoundSystem.plane, var5, var6);
                     if(var34 != null) {
                        var35 = HitSplatDefinition.method4972(var34.tag);
                        if(var2 == 2) {
                           var34.entity1 = new DynamicObject(var35, 2, var32 + 4, SoundSystem.plane, var5, var6, var7, false, var34.entity1);
                           var34.entity2 = new DynamicObject(var35, 2, var32 + 1 & 3, SoundSystem.plane, var5, var6, var7, false, var34.entity2);
                        } else {
                           var34.entity1 = new DynamicObject(var35, var2, var32, SoundSystem.plane, var5, var6, var7, false, var34.entity1);
                        }
                     }
                  }

                  if(var3 == 1) {
                     WallDecoration var36 = class65.scene.getWallDecoration(SoundSystem.plane, var5, var6);
                     if(var36 != null) {
                        var35 = HitSplatDefinition.method4972(var36.tag);
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var36.entity1 = new DynamicObject(var35, 4, var32 + 4, SoundSystem.plane, var5, var6, var7, false, var36.entity1);
                           } else if(var2 == 7) {
                              var36.entity1 = new DynamicObject(var35, 4, (var32 + 2 & 3) + 4, SoundSystem.plane, var5, var6, var7, false, var36.entity1);
                           } else if(var2 == 8) {
                              var36.entity1 = new DynamicObject(var35, 4, var32 + 4, SoundSystem.plane, var5, var6, var7, false, var36.entity1);
                              var36.entity2 = new DynamicObject(var35, 4, (var32 + 2 & 3) + 4, SoundSystem.plane, var5, var6, var7, false, var36.entity2);
                           }
                        } else {
                           var36.entity1 = new DynamicObject(var35, 4, var32, SoundSystem.plane, var5, var6, var7, false, var36.entity1);
                        }
                     }
                  }

                  if(var3 == 2) {
                     GameObject var37 = class65.scene.__aj_243(SoundSystem.plane, var5, var6);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(var37 != null) {
                        var37.entity = new DynamicObject(HitSplatDefinition.method4972(var37.tag), var2, var32, SoundSystem.plane, var5, var6, var7, false, var37.entity);
                     }
                  }

                  if(var3 == 3) {
                     FloorDecoration var39 = class65.scene.getFloorDecoration(SoundSystem.plane, var5, var6);
                     if(var39 != null) {
                        var39.entity = new DynamicObject(HitSplatDefinition.method4972(var39.tag), 22, var32, SoundSystem.plane, var5, var6, var7, false, var39.entity);
                     }
                  }
               }
            } else {
               NodeDeque var38;
               GroundItem var41;
               if(class190.field2347 == var0) {
                  var31 = var1.__bb_317();
                  var2 = (var31 >> 4 & 7) + WorldMapSection3.__p_go;
                  var32 = (var31 & 7) + Canvas.__ao_gk;
                  var3 = var1.__bm_326();
                  if(var2 >= 0 && var32 >= 0 && var2 < 104 && var32 < 104) {
                     var38 = Client.groundItems[SoundSystem.plane][var2][var32];
                     if(var38 != null) {
                        for(var41 = (GroundItem)var38.last(); var41 != null; var41 = (GroundItem)var38.previous()) {
                           if((var3 & 32767) == var41.id) {
                              var41.remove();
                              break;
                           }
                        }

                        if(var38.last() == null) {
                           Client.groundItems[SoundSystem.plane][var2][var32] = null;
                        }

                        TilePaint.method3061(var2, var32);
                     }
                  }
               } else if(class190.field2350 == var0) {
                  var31 = var1.__bq_318();
                  var2 = var31 >> 2;
                  var32 = var31 & 3;
                  var3 = Client.__client_gd[var2];
                  var4 = var1.__bq_318();
                  var5 = (var4 >> 4 & 7) + WorldMapSection3.__p_go;
                  var6 = (var4 & 7) + Canvas.__ao_gk;
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     class258.method4898(SoundSystem.plane, var5, var6, var3, -1, var2, var32, 0, -1);
                  }
               } else if(class190.field2352 == var0) {
                  var31 = var1.__bq_318() * 4;
                  var2 = var1.__ag_302();
                  var32 = var1.__bu_325();
                  var3 = var1.__bq_318() * 4;
                  var4 = var1.__bl_327();
                  var5 = var1.readUnsignedByte();
                  var6 = var1.__bq_318();
                  var7 = var1.__by_324();
                  var8 = var1.__bb_317();
                  var35 = (var8 >> 4 & 7) + WorldMapSection3.__p_go;
                  var9 = (var8 & 7) + Canvas.__ao_gk;
                  var10 = var1.__bn_319();
                  byte var40 = var1.__bk_320();
                  var11 = var40 + var35;
                  int var42 = var10 + var9;
                  if(var35 >= 0 && var9 >= 0 && var35 < 104 && var9 < 104 && var11 >= 0 && var42 >= 0 && var11 < 104 && var42 < 104 && var32 != 65535) {
                     var35 = var35 * 128 + 64;
                     var9 = var9 * 128 + 64;
                     var11 = var11 * 128 + 64;
                     var42 = var42 * 128 + 64;
                     Projectile var43 = new Projectile(var32, SoundSystem.plane, var35, var9, class32.getTileHeight(var35, var9, SoundSystem.plane) - var3, var7 + Client.cycle, var2 + Client.cycle, var5, var6, var4, var31);
                     var43.setDestination(var11, var42, class32.getTileHeight(var11, var42, SoundSystem.plane) - var31, var7 + Client.cycle);
                     Client.projectiles.addFirst(var43);
                  }
               } else if(class190.field2346 != var0) {
                  if(class190.field2343 == var0) {
                     var31 = var1.__bu_325();
                     var2 = var1.__bm_326();
                     var32 = var1.__bb_317();
                     var3 = (var32 >> 4 & 7) + WorldMapSection3.__p_go;
                     var4 = (var32 & 7) + Canvas.__ao_gk;
                     if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                        var41 = new GroundItem();
                        var41.id = var2;
                        var41.quantity = var31;
                        if(Client.groundItems[SoundSystem.plane][var3][var4] == null) {
                           Client.groundItems[SoundSystem.plane][var3][var4] = new NodeDeque();
                        }

                        Client.groundItems[SoundSystem.plane][var3][var4].addFirst(var41);
                        TilePaint.method3061(var3, var4);
                     }
                  }
               } else {
                  var31 = var1.__by_324();
                  var2 = var1.__bm_326();
                  var32 = var1.__by_324();
                  var3 = var1.__bb_317();
                  var4 = (var3 >> 4 & 7) + WorldMapSection3.__p_go;
                  var5 = (var3 & 7) + Canvas.__ao_gk;
                  if(var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                     var38 = Client.groundItems[SoundSystem.plane][var4][var5];
                     if(var38 != null) {
                        for(GroundItem var44 = (GroundItem)var38.last(); var44 != null; var44 = (GroundItem)var38.previous()) {
                           if((var31 & 32767) == var44.id && var32 == var44.quantity) {
                              var44.quantity = var2;
                              break;
                           }
                        }

                        TilePaint.method3061(var4, var5);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "0"
   )
   @Export("insertMenuItem")
   static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen && Client.menuOptionsCount < 500) {
         Client.menuActions[Client.menuOptionsCount] = var0;
         Client.menuTargetNames[Client.menuOptionsCount] = var1;
         Client.menuOpcodes[Client.menuOptionsCount] = var2;
         Client.menuArguments0[Client.menuOptionsCount] = var3;
         Client.menuArguments1[Client.menuOptionsCount] = var4;
         Client.menuArguments2[Client.menuOptionsCount] = var5;
         Client.menuShiftClick[Client.menuOptionsCount] = var6;
         ++Client.menuOptionsCount;
      }

   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lho;II)I",
      garbageValue = "931169314"
   )
   static final int method187(Widget var0, int var1) {
      if(var0.cs1Instructions != null && var1 < var0.cs1Instructions.length) {
         try {
            int[] var2 = var0.cs1Instructions[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.currentLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.levels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.experience[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = Huffman.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Skills.getItemDefinition(var11).isMembersOnly || Client.isMembersWorld)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = Varps.Varps_main[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = Skills.Skills_experienceTable[Client.levels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = Varps.Varps_main[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = Canvas.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(Skills.Skills_enabled[var9]) {
                        var7 += Client.levels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = Huffman.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!Skills.getItemDefinition(var11).isMembersOnly || Client.isMembersWorld)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.runEnergy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = Varps.Varps_main[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = WorldMapSection2.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (Canvas.localPlayer.x >> 7) + class50.baseX;
               }

               if(var6 == 19) {
                  var7 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}

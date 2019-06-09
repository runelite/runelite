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
      int var3;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var12;
      byte var13;
      int var14;
      if(class190.field2342 == var0) {
         byte var2 = var1.__bk_320();
         var3 = var1.__bm_326();
         byte var4 = var1.__bk_320();
         var5 = var1.__bu_325();
         var6 = var1.__ag_302();
         var7 = var1.__bb_317();
         var8 = var7 >> 2;
         var9 = var7 & 3;
         var10 = Client.__client_gd[var8];
         byte var11 = var1.__bn_319();
         var12 = var1.__by_324();
         var13 = var1.__bk_320();
         var14 = var1.readUnsignedByteNegate();
         int var15 = (var14 >> 4 & 7) + WorldMapSection3.__p_go;
         int var16 = (var14 & 7) + Canvas.__ao_gk;
         Player var17;
         if(var12 == Client.localPlayerIndex) {
            var17 = Canvas.localPlayer;
         } else {
            var17 = Client.players[var12];
         }

         if(var17 != null) {
            ObjectDefinition var18 = class50.getObjectDefinition(var5);
            int var19;
            int var20;
            if(var9 != 1 && var9 != 3) {
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
            Model var29 = var18.getModel(var8, var9, var25, var27, var26, var28);
            if(var29 != null) {
               class258.method4898(SoundSystem.plane, var15, var16, var10, -1, 0, 0, var6 + 1, var3 + 1);
               var17.animationCycleStart = var6 + Client.cycle;
               var17.animationCycleEnd = var3 + Client.cycle;
               var17.model0 = var29;
               var17.__k = var15 * 128 + var19 * 64;
               var17.__i = var16 * 128 + var20 * 64;
               var17.tileHeight2 = var26;
               byte var30;
               if(var2 > var13) {
                  var30 = var2;
                  var2 = var13;
                  var13 = var30;
               }

               if(var11 > var4) {
                  var30 = var11;
                  var11 = var4;
                  var4 = var30;
               }

               var17.__z = var15 + var2;
               var17.__s = var13 + var15;
               var17.__j = var11 + var16;
               var17.__t = var4 + var16;
            }
         }
      }

      int var37;
      int var38;
      if(class190.field2349 == var0) {
         var37 = var1.__bb_317();
         var3 = (var37 >> 4 & 7) + WorldMapSection3.__p_go;
         var38 = (var37 & 7) + Canvas.__ao_gk;
         var5 = var1.__bq_318();
         var6 = var5 >> 2;
         var7 = var5 & 3;
         var8 = Client.__client_gd[var6];
         var9 = var1.__bu_325();
         if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
            class258.method4898(SoundSystem.plane, var3, var38, var8, var9, var6, var7, 0, -1);
         }

      } else {
         if(class190.field2345 == var0) {
            var37 = var1.readUnsignedByte();
            var3 = (var37 >> 4 & 7) + WorldMapSection3.__p_go;
            var38 = (var37 & 7) + Canvas.__ao_gk;
            var5 = var1.__bq_318();
            var6 = var1.__bb_317();
            var7 = var6 >> 4 & 15;
            var8 = var6 & 7;
            var9 = var1.__bm_326();
            if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
               var10 = var7 + 1;
               if(Canvas.localPlayer.pathX[0] >= var3 - var10 && Canvas.localPlayer.pathX[0] <= var10 + var3 && Canvas.localPlayer.pathY[0] >= var38 - var10 && Canvas.localPlayer.pathY[0] <= var10 + var38 && Client.__client_qc != 0 && var8 > 0 && Client.soundEffectCount < 50) {
                  Client.soundEffectIds[Client.soundEffectCount] = var9;
                  Client.unknownSoundValues1[Client.soundEffectCount] = var8;
                  Client.queuedSoundEffectDelays[Client.soundEffectCount] = var5;
                  Client.soundEffects[Client.soundEffectCount] = null;
                  Client.soundLocations[Client.soundEffectCount] = var7 + (var38 << 8) + (var3 << 16);
                  ++Client.soundEffectCount;
               }
            }
         }

         if(class190.field2341 == var0) {
            var37 = var1.__ag_302();
            var3 = var1.__bb_317();
            var38 = var1.__bu_325();
            var5 = var1.readUnsignedByte();
            var6 = (var5 >> 4 & 7) + WorldMapSection3.__p_go;
            var7 = (var5 & 7) + Canvas.__ao_gk;
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               var6 = var6 * 128 + 64;
               var7 = var7 * 128 + 64;
               GraphicsObject var42 = new GraphicsObject(var37, SoundSystem.plane, var6, var7, class32.getTileHeight(var6, var7, SoundSystem.plane) - var3, var38, Client.cycle);
               Client.graphicsObjects.addFirst(var42);
            }

         } else {
            int var39;
            if(class190.field2344 == var0) {
               var37 = var1.__bq_318();
               var3 = var37 >> 2;
               var38 = var37 & 3;
               var5 = Client.__client_gd[var3];
               var6 = var1.readUnsignedByteNegate();
               var7 = (var6 >> 4 & 7) + WorldMapSection3.__p_go;
               var8 = (var6 & 7) + Canvas.__ao_gk;
               var9 = var1.__ag_302();
               if(var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
                  if(var5 == 0) {
                     BoundaryObject var32 = class65.scene.getBoundaryObject(SoundSystem.plane, var7, var8);
                     if(var32 != null) {
                        var39 = HitSplatDefinition.method4972(var32.tag);
                        if(var3 == 2) {
                           var32.entity1 = new DynamicObject(var39, 2, var38 + 4, SoundSystem.plane, var7, var8, var9, false, var32.entity1);
                           var32.entity2 = new DynamicObject(var39, 2, var38 + 1 & 3, SoundSystem.plane, var7, var8, var9, false, var32.entity2);
                        } else {
                           var32.entity1 = new DynamicObject(var39, var3, var38, SoundSystem.plane, var7, var8, var9, false, var32.entity1);
                        }
                     }
                  }

                  if(var5 == 1) {
                     WallDecoration var43 = class65.scene.getWallDecoration(SoundSystem.plane, var7, var8);
                     if(var43 != null) {
                        var39 = HitSplatDefinition.method4972(var43.tag);
                        if(var3 != 4 && var3 != 5) {
                           if(var3 == 6) {
                              var43.entity1 = new DynamicObject(var39, 4, var38 + 4, SoundSystem.plane, var7, var8, var9, false, var43.entity1);
                           } else if(var3 == 7) {
                              var43.entity1 = new DynamicObject(var39, 4, (var38 + 2 & 3) + 4, SoundSystem.plane, var7, var8, var9, false, var43.entity1);
                           } else if(var3 == 8) {
                              var43.entity1 = new DynamicObject(var39, 4, var38 + 4, SoundSystem.plane, var7, var8, var9, false, var43.entity1);
                              var43.entity2 = new DynamicObject(var39, 4, (var38 + 2 & 3) + 4, SoundSystem.plane, var7, var8, var9, false, var43.entity2);
                           }
                        } else {
                           var43.entity1 = new DynamicObject(var39, 4, var38, SoundSystem.plane, var7, var8, var9, false, var43.entity1);
                        }
                     }
                  }

                  if(var5 == 2) {
                     GameObject var44 = class65.scene.__aj_243(SoundSystem.plane, var7, var8);
                     if(var3 == 11) {
                        var3 = 10;
                     }

                     if(var44 != null) {
                        var44.entity = new DynamicObject(HitSplatDefinition.method4972(var44.tag), var3, var38, SoundSystem.plane, var7, var8, var9, false, var44.entity);
                     }
                  }

                  if(var5 == 3) {
                     FloorDecoration var45 = class65.scene.getFloorDecoration(SoundSystem.plane, var7, var8);
                     if(var45 != null) {
                        var45.entity = new DynamicObject(HitSplatDefinition.method4972(var45.tag), 22, var38, SoundSystem.plane, var7, var8, var9, false, var45.entity);
                     }
                  }
               }

            } else {
               GroundItem var34;
               if(class190.field2347 == var0) {
                  var37 = var1.__bb_317();
                  var3 = (var37 >> 4 & 7) + WorldMapSection3.__p_go;
                  var38 = (var37 & 7) + Canvas.__ao_gk;
                  var5 = var1.__bm_326();
                  if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
                     NodeDeque var33 = Client.groundItems[SoundSystem.plane][var3][var38];
                     if(var33 != null) {
                        for(var34 = (GroundItem)var33.last(); var34 != null; var34 = (GroundItem)var33.previous()) {
                           if((var5 & 32767) == var34.id) {
                              var34.remove();
                              break;
                           }
                        }

                        if(var33.last() == null) {
                           Client.groundItems[SoundSystem.plane][var3][var38] = null;
                        }

                        TilePaint.method3061(var3, var38);
                     }
                  }

               } else if(class190.field2350 == var0) {
                  var37 = var1.__bq_318();
                  var3 = var37 >> 2;
                  var38 = var37 & 3;
                  var5 = Client.__client_gd[var3];
                  var6 = var1.__bq_318();
                  var7 = (var6 >> 4 & 7) + WorldMapSection3.__p_go;
                  var8 = (var6 & 7) + Canvas.__ao_gk;
                  if(var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
                     class258.method4898(SoundSystem.plane, var7, var8, var5, -1, var3, var38, 0, -1);
                  }

               } else if(class190.field2352 == var0) {
                  var37 = var1.__bq_318() * 4;
                  var3 = var1.__ag_302();
                  var38 = var1.__bu_325();
                  var5 = var1.__bq_318() * 4;
                  var6 = var1.__bl_327();
                  var7 = var1.readUnsignedByte();
                  var8 = var1.__bq_318();
                  var9 = var1.__by_324();
                  var10 = var1.__bb_317();
                  var39 = (var10 >> 4 & 7) + WorldMapSection3.__p_go;
                  var12 = (var10 & 7) + Canvas.__ao_gk;
                  var13 = var1.__bn_319();
                  byte var40 = var1.__bk_320();
                  var14 = var40 + var39;
                  int var41 = var13 + var12;
                  if(var39 >= 0 && var12 >= 0 && var39 < 104 && var12 < 104 && var14 >= 0 && var41 >= 0 && var14 < 104 && var41 < 104 && var38 != 65535) {
                     var39 = var39 * 128 + 64;
                     var12 = var12 * 128 + 64;
                     var14 = var14 * 128 + 64;
                     var41 = var41 * 128 + 64;
                     Projectile var35 = new Projectile(var38, SoundSystem.plane, var39, var12, class32.getTileHeight(var39, var12, SoundSystem.plane) - var5, var9 + Client.cycle, var3 + Client.cycle, var7, var8, var6, var37);
                     var35.setDestination(var14, var41, class32.getTileHeight(var14, var41, SoundSystem.plane) - var37, var9 + Client.cycle);
                     Client.projectiles.addFirst(var35);
                  }

               } else if(class190.field2346 != var0) {
                  if(class190.field2343 == var0) {
                     var37 = var1.__bu_325();
                     var3 = var1.__bm_326();
                     var38 = var1.__bb_317();
                     var5 = (var38 >> 4 & 7) + WorldMapSection3.__p_go;
                     var6 = (var38 & 7) + Canvas.__ao_gk;
                     if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                        var34 = new GroundItem();
                        var34.id = var3;
                        var34.quantity = var37;
                        if(Client.groundItems[SoundSystem.plane][var5][var6] == null) {
                           Client.groundItems[SoundSystem.plane][var5][var6] = new NodeDeque();
                        }

                        Client.groundItems[SoundSystem.plane][var5][var6].addFirst(var34);
                        TilePaint.method3061(var5, var6);
                     }

                  }
               } else {
                  var37 = var1.__by_324();
                  var3 = var1.__bm_326();
                  var38 = var1.__by_324();
                  var5 = var1.__bb_317();
                  var6 = (var5 >> 4 & 7) + WorldMapSection3.__p_go;
                  var7 = (var5 & 7) + Canvas.__ao_gk;
                  if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                     NodeDeque var31 = Client.groundItems[SoundSystem.plane][var6][var7];
                     if(var31 != null) {
                        for(GroundItem var36 = (GroundItem)var31.last(); var36 != null; var36 = (GroundItem)var31.previous()) {
                           if((var37 & 32767) == var36.id && var38 == var36.quantity) {
                              var36.quantity = var3;
                              break;
                           }
                        }

                        TilePaint.method3061(var6, var7);
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
      if(!Client.isMenuOpen) {
         if(Client.menuOptionsCount < 500) {
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

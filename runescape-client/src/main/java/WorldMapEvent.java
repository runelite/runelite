import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapEvent")
public class WorldMapEvent {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("__ap_w")
   static IndexedSprite[] __ap_w;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 264384233
   )
   @Export("mapElement")
   public int mapElement;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("coord1")
   public TileLocation coord1;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("coord2")
   public TileLocation coord2;

   @ObfuscatedSignature(
      signature = "(ILhu;Lhu;)V"
   )
   public WorldMapEvent(int var1, TileLocation var2, TileLocation var3) {
      this.mapElement = var1;
      this.coord1 = var2;
      this.coord2 = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-782761258"
   )
   public static int method780(int var0) {
      return UnitPriceComparator.method134(ViewportMouse.ViewportMouse_entityTags[var0]);
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "2"
   )
   static final void method781(int var0, int var1, int var2, int var3) {
      if(Client.isItemSelected == 0 && !Client.isSpellSelected) {
         Tiles.method1106("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      long var4 = -1L;
      long var6 = -1L;
      int var8 = 0;

      while(true) {
         int var9 = ViewportMouse.ViewportMouse_entityCount;
         if(var8 >= var9) {
            if(-1L != var4) {
               var8 = UnitPriceComparator.method134(var4);
               int var29 = (int)(var4 >>> 7 & 127L);
               Player var11 = Client.players[Client.combatTargetPlayerIndex];
               TotalQuantityComparator.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var29);
            }

            return;
         }

         long var10 = ViewportMouse.ViewportMouse_entityTags[var8];
         if(var6 != var10) {
            label276: {
               var6 = var10;
               int var12 = method780(var8);
               long var13 = ViewportMouse.ViewportMouse_entityTags[var8];
               int var15 = (int)(var13 >>> 7 & 127L);
               var15 = var15;
               int var16 = GrandExchangeEvent.method80(var8);
               int var17 = ClientPreferences.method1808(var8);
               if(var16 == 2 && class65.scene.getObjectFlags(SoundSystem.plane, var12, var15, var10) >= 0) {
                  ObjectDefinition var18 = class50.getObjectDefinition(var17);
                  if(var18.transforms != null) {
                     var18 = var18.transform();
                  }

                  if(var18 == null) {
                     break label276;
                  }

                  if(Client.isItemSelected == 1) {
                     Tiles.method1106("Use", Client.selectedItemName + " -> " + BufferedFile.colorStartTag(65535) + var18.name, 1, var17, var12, var15);
                  } else if(Client.isSpellSelected) {
                     if((FloorDecoration.selectedSpellFlags & 4) == 4) {
                        Tiles.method1106(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + BufferedFile.colorStartTag(65535) + var18.name, 2, var17, var12, var15);
                     }
                  } else {
                     String[] var19 = var18.actions;
                     if(var19 != null) {
                        for(int var20 = 4; var20 >= 0; --var20) {
                           if(var19[var20] != null) {
                              short var21 = 0;
                              if(var20 == 0) {
                                 var21 = 3;
                              }

                              if(var20 == 1) {
                                 var21 = 4;
                              }

                              if(var20 == 2) {
                                 var21 = 5;
                              }

                              if(var20 == 3) {
                                 var21 = 6;
                              }

                              if(var20 == 4) {
                                 var21 = 1001;
                              }

                              Tiles.method1106(var19[var20], BufferedFile.colorStartTag(65535) + var18.name, var21, var17, var12, var15);
                           }
                        }
                     }

                     Tiles.method1106("Examine", BufferedFile.colorStartTag(65535) + var18.name, 1002, var18.id, var12, var15);
                  }
               }

               int var22;
               int var30;
               NPC var31;
               Player var32;
               int[] var34;
               if(var16 == 1) {
                  NPC var23 = Client.npcs[var17];
                  if(var23 == null) {
                     break label276;
                  }

                  if(var23.definition.size == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                     for(var30 = 0; var30 < Client.npcCount; ++var30) {
                        var31 = Client.npcs[Client.npcIndices[var30]];
                        if(var31 != null && var23 != var31 && var31.definition.size == 1 && var31.x == var23.x && var31.y == var23.y) {
                           Tile.addNpcToMenu(var31.definition, Client.npcIndices[var30], var12, var15);
                        }
                     }

                     var30 = Players.Players_count;
                     var34 = Players.Players_indices;

                     for(var22 = 0; var22 < var30; ++var22) {
                        var32 = Client.players[var34[var22]];
                        if(var32 != null && var32.x == var23.x && var32.y == var23.y) {
                           TotalQuantityComparator.addPlayerToMenu(var32, var34[var22], var12, var15);
                        }
                     }
                  }

                  Tile.addNpcToMenu(var23.definition, var17, var12, var15);
               }

               if(var16 == 0) {
                  Player var33 = Client.players[var17];
                  if(var33 == null) {
                     break label276;
                  }

                  if((var33.x & 127) == 64 && (var33.y & 127) == 64) {
                     for(var30 = 0; var30 < Client.npcCount; ++var30) {
                        var31 = Client.npcs[Client.npcIndices[var30]];
                        if(var31 != null && var31.definition.size == 1 && var33.x == var31.x && var33.y == var31.y) {
                           Tile.addNpcToMenu(var31.definition, Client.npcIndices[var30], var12, var15);
                        }
                     }

                     var30 = Players.Players_count;
                     var34 = Players.Players_indices;

                     for(var22 = 0; var22 < var30; ++var22) {
                        var32 = Client.players[var34[var22]];
                        if(var32 != null && var32 != var33 && var32.x == var33.x && var32.y == var33.y) {
                           TotalQuantityComparator.addPlayerToMenu(var32, var34[var22], var12, var15);
                        }
                     }
                  }

                  if(var17 != Client.combatTargetPlayerIndex) {
                     TotalQuantityComparator.addPlayerToMenu(var33, var17, var12, var15);
                  } else {
                     var4 = var10;
                  }
               }

               if(var16 == 3) {
                  NodeDeque var35 = Client.groundItems[SoundSystem.plane][var12][var15];
                  if(var35 != null) {
                     for(GroundItem var24 = (GroundItem)var35.first(); var24 != null; var24 = (GroundItem)var35.next()) {
                        ItemDefinition var25 = Skills.getItemDefinition(var24.id);
                        if(Client.isItemSelected == 1) {
                           Tiles.method1106("Use", Client.selectedItemName + " -> " + BufferedFile.colorStartTag(16748608) + var25.name, 16, var24.id, var12, var15);
                        } else if(Client.isSpellSelected) {
                           if((FloorDecoration.selectedSpellFlags & 1) == 1) {
                              Tiles.method1106(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + BufferedFile.colorStartTag(16748608) + var25.name, 17, var24.id, var12, var15);
                           }
                        } else {
                           String[] var26 = var25.groundActions;

                           for(int var27 = 4; var27 >= 0; --var27) {
                              if(var26 != null && var26[var27] != null) {
                                 byte var28 = 0;
                                 if(var27 == 0) {
                                    var28 = 18;
                                 }

                                 if(var27 == 1) {
                                    var28 = 19;
                                 }

                                 if(var27 == 2) {
                                    var28 = 20;
                                 }

                                 if(var27 == 3) {
                                    var28 = 21;
                                 }

                                 if(var27 == 4) {
                                    var28 = 22;
                                 }

                                 Tiles.method1106(var26[var27], BufferedFile.colorStartTag(16748608) + var25.name, var28, var24.id, var12, var15);
                              } else if(var27 == 2) {
                                 Tiles.method1106("Take", BufferedFile.colorStartTag(16748608) + var25.name, 20, var24.id, var12, var15);
                              }
                           }

                           Tiles.method1106("Examine", BufferedFile.colorStartTag(16748608) + var25.name, 1004, var24.id, var12, var15);
                        }
                     }
                  }
               }
            }
         }

         ++var8;
      }
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "43"
   )
   static boolean method779() {
      return Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
   }
}

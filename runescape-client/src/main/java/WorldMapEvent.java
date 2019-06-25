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
         int var10 = ViewportMouse.ViewportMouse_entityCount;
         if(var8 >= var10) {
            if(-1L != var4) {
               var8 = UnitPriceComparator.method134(var4);
               int var9 = (int)(var4 >>> 7 & 127L);
               Player var11 = Client.players[Client.combatTargetPlayerIndex];
               TotalQuantityComparator.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var9);
            }

            return;
         }

         long var26 = ViewportMouse.ViewportMouse_entityTags[var8];
         if(var6 != var26) {
            label338: {
               var6 = var26;
               int var15 = method780(var8);
               long var18 = ViewportMouse.ViewportMouse_entityTags[var8];
               int var17 = (int)(var18 >>> 7 & 127L);
               var17 = var17;
               int var28 = GrandExchangeEvent.method80(var8);
               int var19 = ClientPreferences.method1808(var8);
               if(var28 == 2 && class65.scene.getObjectFlags(SoundSystem.plane, var15, var17, var26) >= 0) {
                  ObjectDefinition var20 = class50.getObjectDefinition(var19);
                  if(var20.transforms != null) {
                     var20 = var20.transform();
                  }

                  if(var20 == null) {
                     break label338;
                  }

                  if(Client.isItemSelected == 1) {
                     Tiles.method1106("Use", Client.selectedItemName + " " + "->" + " " + BufferedFile.colorStartTag(65535) + var20.name, 1, var19, var15, var17);
                  } else if(Client.isSpellSelected) {
                     if((FloorDecoration.selectedSpellFlags & 4) == 4) {
                        Tiles.method1106(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + BufferedFile.colorStartTag(65535) + var20.name, 2, var19, var15, var17);
                     }
                  } else {
                     String[] var29 = var20.actions;
                     if(var29 != null) {
                        for(int var30 = 4; var30 >= 0; --var30) {
                           if(var29[var30] != null) {
                              short var23 = 0;
                              if(var30 == 0) {
                                 var23 = 3;
                              }

                              if(var30 == 1) {
                                 var23 = 4;
                              }

                              if(var30 == 2) {
                                 var23 = 5;
                              }

                              if(var30 == 3) {
                                 var23 = 6;
                              }

                              if(var30 == 4) {
                                 var23 = 1001;
                              }

                              Tiles.method1106(var29[var30], BufferedFile.colorStartTag(65535) + var20.name, var23, var19, var15, var17);
                           }
                        }
                     }

                     Tiles.method1106("Examine", BufferedFile.colorStartTag(65535) + var20.name, 1002, var20.id, var15, var17);
                  }
               }

               int var21;
               Npc var22;
               Player var24;
               int[] var36;
               int var38;
               if(var28 == 1) {
                  Npc var33 = Client.npcs[var19];
                  if(var33 == null) {
                     break label338;
                  }

                  if(var33.definition.size == 1 && (var33.x & 127) == 64 && (var33.y & 127) == 64) {
                     for(var21 = 0; var21 < Client.npcCount; ++var21) {
                        var22 = Client.npcs[Client.npcIndices[var21]];
                        if(var22 != null && var33 != var22 && var22.definition.size == 1 && var22.x == var33.x && var22.y == var33.y) {
                           Tile.addNpcToMenu(var22.definition, Client.npcIndices[var21], var15, var17);
                        }
                     }

                     var21 = Players.Players_count;
                     var36 = Players.Players_indices;

                     for(var38 = 0; var38 < var21; ++var38) {
                        var24 = Client.players[var36[var38]];
                        if(var24 != null && var24.x == var33.x && var24.y == var33.y) {
                           TotalQuantityComparator.addPlayerToMenu(var24, var36[var38], var15, var17);
                        }
                     }
                  }

                  Tile.addNpcToMenu(var33.definition, var19, var15, var17);
               }

               if(var28 == 0) {
                  Player var34 = Client.players[var19];
                  if(var34 == null) {
                     break label338;
                  }

                  if((var34.x & 127) == 64 && (var34.y & 127) == 64) {
                     for(var21 = 0; var21 < Client.npcCount; ++var21) {
                        var22 = Client.npcs[Client.npcIndices[var21]];
                        if(var22 != null && var22.definition.size == 1 && var34.x == var22.x && var34.y == var22.y) {
                           Tile.addNpcToMenu(var22.definition, Client.npcIndices[var21], var15, var17);
                        }
                     }

                     var21 = Players.Players_count;
                     var36 = Players.Players_indices;

                     for(var38 = 0; var38 < var21; ++var38) {
                        var24 = Client.players[var36[var38]];
                        if(var24 != null && var24 != var34 && var24.x == var34.x && var24.y == var34.y) {
                           TotalQuantityComparator.addPlayerToMenu(var24, var36[var38], var15, var17);
                        }
                     }
                  }

                  if(var19 != Client.combatTargetPlayerIndex) {
                     TotalQuantityComparator.addPlayerToMenu(var34, var19, var15, var17);
                  } else {
                     var4 = var26;
                  }
               }

               if(var28 == 3) {
                  NodeDeque var35 = Client.groundItems[SoundSystem.plane][var15][var17];
                  if(var35 != null) {
                     for(GroundItem var39 = (GroundItem)var35.first(); var39 != null; var39 = (GroundItem)var35.next()) {
                        ItemDefinition var37 = Skills.getItemDefinition(var39.id);
                        if(Client.isItemSelected == 1) {
                           Tiles.method1106("Use", Client.selectedItemName + " " + "->" + " " + BufferedFile.colorStartTag(16748608) + var37.name, 16, var39.id, var15, var17);
                        } else if(Client.isSpellSelected) {
                           if((FloorDecoration.selectedSpellFlags & 1) == 1) {
                              Tiles.method1106(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + BufferedFile.colorStartTag(16748608) + var37.name, 17, var39.id, var15, var17);
                           }
                        } else {
                           String[] var31 = var37.groundActions;

                           for(int var32 = 4; var32 >= 0; --var32) {
                              if(var31 != null && var31[var32] != null) {
                                 byte var25 = 0;
                                 if(var32 == 0) {
                                    var25 = 18;
                                 }

                                 if(var32 == 1) {
                                    var25 = 19;
                                 }

                                 if(var32 == 2) {
                                    var25 = 20;
                                 }

                                 if(var32 == 3) {
                                    var25 = 21;
                                 }

                                 if(var32 == 4) {
                                    var25 = 22;
                                 }

                                 Tiles.method1106(var31[var32], BufferedFile.colorStartTag(16748608) + var37.name, var25, var39.id, var15, var17);
                              } else if(var32 == 2) {
                                 Tiles.method1106("Take", BufferedFile.colorStartTag(16748608) + var37.name, 20, var39.id, var15, var17);
                              }
                           }

                           Tiles.method1106("Examine", BufferedFile.colorStartTag(16748608) + var37.name, 1004, var39.id, var15, var17);
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

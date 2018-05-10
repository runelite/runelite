import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("f")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1213546159
   )
   public final int field3149;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.field3149 = var2;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1240991873"
   )
   static final void method4608(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field796[var4] = true;
         }
      }

   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1551283972"
   )
   static final void method4609(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         VertexNormal.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      long var4 = -1L;
      long var6 = -1L;
      int var8 = 0;

      while(true) {
         int var10 = class120.Viewport_entityCountAtMouse;
         if(var8 >= var10) {
            if(-1L != var4) {
               var8 = (int)(var4 >>> 0 & 127L);
               var10 = UnitPriceComparator.method59(var4);
               Player var11 = Client.cachedPlayers[Client.field719];
               Varcs.method1942(var11, Client.field719, var8, var10);
            }

            return;
         }

         long var25 = CacheFile.method2522(var8);
         if(var6 != var25) {
            label331: {
               var6 = var25;
               long var15 = class120.field1688[var8];
               int var14 = (int)(var15 >>> 0 & 127L);
               var14 = var14;
               int var27 = class177.method3533(var8);
               int var16 = class59.method1122(var8);
               int var17 = class8.method93(class120.field1688[var8]);
               int var18 = var17;
               if(var16 == 2 && ScriptEvent.region.method2931(class192.plane, var14, var27, var25) >= 0) {
                  ObjectComposition var19 = SoundTaskDataProvider.getObjectDefinition(var17);
                  if(var19.impostorIds != null) {
                     var19 = var19.getImpostor();
                  }

                  if(var19 == null) {
                     break label331;
                  }

                  if(Client.itemSelectionState == 1) {
                     VertexNormal.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class50.getColTags(65535) + var19.name, 1, var17, var14, var27);
                  } else if(Client.spellSelected) {
                     if((class45.field373 & 4) == 4) {
                        VertexNormal.addMenuEntry(Client.field750, Client.field751 + " " + "->" + " " + class50.getColTags(65535) + var19.name, 2, var17, var14, var27);
                     }
                  } else {
                     String[] var28 = var19.actions;
                     if(var28 != null) {
                        for(int var31 = 4; var31 >= 0; --var31) {
                           if(var28[var31] != null) {
                              short var22 = 0;
                              if(var31 == 0) {
                                 var22 = 3;
                              }

                              if(var31 == 1) {
                                 var22 = 4;
                              }

                              if(var31 == 2) {
                                 var22 = 5;
                              }

                              if(var31 == 3) {
                                 var22 = 6;
                              }

                              if(var31 == 4) {
                                 var22 = 1001;
                              }

                              VertexNormal.addMenuEntry(var28[var31], class50.getColTags(65535) + var19.name, var22, var18, var14, var27);
                           }
                        }
                     }

                     VertexNormal.addMenuEntry("Examine", class50.getColTags(65535) + var19.name, 1002, var19.id, var14, var27);
                  }
               }

               int var20;
               NPC var21;
               Player var23;
               int[] var35;
               int var37;
               if(var16 == 1) {
                  NPC var32 = Client.cachedNPCs[var18];
                  if(var32 == null) {
                     break label331;
                  }

                  if(var32.composition.size == 1 && (var32.x & 127) == 64 && (var32.y & 127) == 64) {
                     for(var20 = 0; var20 < Client.npcIndexesCount; ++var20) {
                        var21 = Client.cachedNPCs[Client.npcIndices[var20]];
                        if(var21 != null && var21 != var32 && var21.composition.size == 1 && var21.x == var32.x && var21.y == var32.y) {
                           class184.method3829(var21.composition, Client.npcIndices[var20], var14, var27);
                        }
                     }

                     var20 = class81.playerIndexesCount;
                     var35 = class81.playerIndices;

                     for(var37 = 0; var37 < var20; ++var37) {
                        var23 = Client.cachedPlayers[var35[var37]];
                        if(var23 != null && var23.x == var32.x && var32.y == var23.y) {
                           Varcs.method1942(var23, var35[var37], var14, var27);
                        }
                     }
                  }

                  class184.method3829(var32.composition, var18, var14, var27);
               }

               if(var16 == 0) {
                  Player var33 = Client.cachedPlayers[var18];
                  if(var33 == null) {
                     break label331;
                  }

                  if((var33.x & 127) == 64 && (var33.y & 127) == 64) {
                     for(var20 = 0; var20 < Client.npcIndexesCount; ++var20) {
                        var21 = Client.cachedNPCs[Client.npcIndices[var20]];
                        if(var21 != null && var21.composition.size == 1 && var21.x == var33.x && var21.y == var33.y) {
                           class184.method3829(var21.composition, Client.npcIndices[var20], var14, var27);
                        }
                     }

                     var20 = class81.playerIndexesCount;
                     var35 = class81.playerIndices;

                     for(var37 = 0; var37 < var20; ++var37) {
                        var23 = Client.cachedPlayers[var35[var37]];
                        if(var23 != null && var23 != var33 && var23.x == var33.x && var23.y == var33.y) {
                           Varcs.method1942(var23, var35[var37], var14, var27);
                        }
                     }
                  }

                  if(var18 != Client.field719) {
                     Varcs.method1942(var33, var18, var14, var27);
                  } else {
                     var4 = var25;
                  }
               }

               if(var16 == 3) {
                  Deque var34 = Client.groundItemDeque[class192.plane][var14][var27];
                  if(var34 != null) {
                     for(Item var38 = (Item)var34.getTail(); var38 != null; var38 = (Item)var34.getPrevious()) {
                        ItemComposition var36 = class120.getItemDefinition(var38.id);
                        if(Client.itemSelectionState == 1) {
                           VertexNormal.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class50.getColTags(16748608) + var36.name, 16, var38.id, var14, var27);
                        } else if(Client.spellSelected) {
                           if((class45.field373 & 1) == 1) {
                              VertexNormal.addMenuEntry(Client.field750, Client.field751 + " " + "->" + " " + class50.getColTags(16748608) + var36.name, 17, var38.id, var14, var27);
                           }
                        } else {
                           String[] var29 = var36.groundActions;

                           for(int var30 = 4; var30 >= 0; --var30) {
                              if(var29 != null && var29[var30] != null) {
                                 byte var24 = 0;
                                 if(var30 == 0) {
                                    var24 = 18;
                                 }

                                 if(var30 == 1) {
                                    var24 = 19;
                                 }

                                 if(var30 == 2) {
                                    var24 = 20;
                                 }

                                 if(var30 == 3) {
                                    var24 = 21;
                                 }

                                 if(var30 == 4) {
                                    var24 = 22;
                                 }

                                 VertexNormal.addMenuEntry(var29[var30], class50.getColTags(16748608) + var36.name, var24, var38.id, var14, var27);
                              } else if(var30 == 2) {
                                 VertexNormal.addMenuEntry("Take", class50.getColTags(16748608) + var36.name, 20, var38.id, var14, var27);
                              }
                           }

                           VertexNormal.addMenuEntry("Examine", class50.getColTags(16748608) + var36.name, 1004, var38.id, var14, var27);
                        }
                     }
                  }
               }
            }
         }

         ++var8;
      }
   }
}

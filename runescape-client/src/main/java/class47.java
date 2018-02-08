import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class47 {
   @ObfuscatedName("fn")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2099216865
   )
   public int field572;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   public Coordinates field575;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   public Coordinates field574;

   @ObfuscatedSignature(
      signature = "(ILhv;Lhv;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field572 = var1;
      this.field575 = var2;
      this.field574 = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "9468"
   )
   public static void method678() {
      if(MouseInput.mouse != null) {
         MouseInput var0 = MouseInput.mouse;
         synchronized(MouseInput.mouse) {
            MouseInput.mouse = null;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "-18273"
   )
   static void method679(String var0, String var1, String var2) {
      class89.loginMessage1 = var0;
      class89.loginMessage2 = var1;
      class89.loginMessage3 = var2;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2117590978"
   )
   static void method676() {
      if(class175.renderOverview != null) {
         class175.renderOverview.method5817(class60.plane, (GroundObject.localPlayer.x >> 7) + ClanMemberManager.baseX, (GroundObject.localPlayer.y >> 7) + WorldMapData.baseY, false);
         class175.renderOverview.method5833();
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1079643050"
   )
   static final void method677(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         NPCComposition.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class131.Viewport_entityCountAtMouse; ++var6) {
         var7 = class131.Viewport_entityIdsAtMouse[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && TotalQuantityComparator.region.getObjectFlags(class60.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class219.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  NPCComposition.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class70.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((Occluder.field2038 & 4) == 4) {
                     NPCComposition.addMenuEntry(Client.field854, Client.field995 + " " + "->" + " " + class70.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(Client.numberMenuOptions) {
                     var19 = class84.prependIndices(var19);
                  }

                  if(var19 != null) {
                     for(int var20 = 4; var20 >= 0; --var20) {
                        if(var19[var20] != null) {
                           short var15 = 0;
                           if(var20 == 0) {
                              var15 = 3;
                           }

                           if(var20 == 1) {
                              var15 = 4;
                           }

                           if(var20 == 2) {
                              var15 = 5;
                           }

                           if(var20 == 3) {
                              var15 = 6;
                           }

                           if(var20 == 4) {
                              var15 = 1001;
                           }

                           NPCComposition.addMenuEntry(var19[var20], class70.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  NPCComposition.addMenuEntry("Examine", class70.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            int var13;
            NPC var14;
            Player var16;
            int[] var26;
            int var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3633 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var23 != var14 && var14.composition.field3633 == 1 && var23.x == var14.x && var23.y == var14.y) {
                        BoundingBox2D.method37(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class92.playerIndexesCount;
                  var26 = class92.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        class92.method1968(var16, var26[var28], var8, var9);
                     }
                  }
               }

               BoundingBox2D.method37(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3633 == 1 && var24.x == var14.x && var14.y == var24.y) {
                        BoundingBox2D.method37(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class92.playerIndexesCount;
                  var26 = class92.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var24.y == var16.y) {
                        class92.method1968(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field953) {
                  class92.method1968(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class60.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = ItemContainer.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        NPCComposition.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class70.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((Occluder.field2038 & 1) == 1) {
                           NPCComposition.addMenuEntry(Client.field854, Client.field995 + " " + "->" + " " + class70.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;
                        if(Client.numberMenuOptions) {
                           var21 = class84.prependIndices(var21);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              NPCComposition.addMenuEntry(var21[var22], class70.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              NPCComposition.addMenuEntry("Take", class70.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        NPCComposition.addMenuEntry("Examine", class70.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field953];
         class92.method1968(var18, Client.field953, var6, var7);
      }

   }
}

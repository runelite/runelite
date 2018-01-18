import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class40 {
   @ObfuscatedName("na")
   static byte field526;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field522;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field518;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field519;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field521;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   public static final class40 field520;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 806140889
   )
   static int field523;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   static class159 field525;
   @ObfuscatedName("d")
   public final String field517;

   static {
      field522 = new class40("details");
      field518 = new class40("compositemap");
      field519 = new class40("compositetexture");
      field521 = new class40("area");
      field520 = new class40("labels");
   }

   class40(String var1) {
      this.field517 = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "-64"
   )
   public static void method537(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field647.startsWith("win") && !var3) {
            UnitPriceComparator.method115(var0, 0, "openjs");
            return;
         }

         if(class56.field647.startsWith("mac")) {
            UnitPriceComparator.method115(var0, 1, var2);
            return;
         }

         UnitPriceComparator.method115(var0, 2, "openjs");
      } else {
         UnitPriceComparator.method115(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1463023859"
   )
   static final void method540(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class7.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class45.region.method2762(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class45.region.method2773(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class45.region.method2774(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class45.region.method2775(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class45.region.getObjectFlags(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class45.region.removeBoundaryObject(var0, var2, var3);
               var12 = NPC.getObjectDefinition(var13);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               class45.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               class45.region.method2765(var0, var2, var3);
               var12 = NPC.getObjectDefinition(var13);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               class45.region.removeFloorDecoration(var0, var2, var3);
               var12 = NPC.getObjectDefinition(var13);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3226(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            DecorativeObject.method2961(var0, var11, var2, var3, var4, var5, var6, class45.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-310927030"
   )
   static final void method539(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         DecorativeObject.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class133.Viewport_entityCountAtMouse; ++var6) {
         var7 = class133.Viewport_entityIdsAtMouse[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class45.region.getObjectFlags(class7.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = NPC.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  DecorativeObject.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class54.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((MouseRecorder.field817 & 4) == 4) {
                     DecorativeObject.addMenuEntry(Client.field1013, Client.field1014 + " " + "->" + " " + class54.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(Client.numberMenuOptions) {
                     var19 = class37.prependIndices(var19);
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

                           DecorativeObject.addMenuEntry(var19[var20], class54.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  DecorativeObject.addMenuEntry("Examine", class54.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
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

               if(var23.composition.field3667 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var23 != var14 && var14.composition.field3667 == 1 && var14.x == var23.x && var23.y == var14.y) {
                        DynamicObject.method1884(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class94.playerIndexesCount;
                  var26 = class94.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        WorldMapData.method339(var16, var26[var28], var8, var9);
                     }
                  }
               }

               DynamicObject.method1884(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3667 == 1 && var14.x == var24.x && var24.y == var14.y) {
                        DynamicObject.method1884(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class94.playerIndexesCount;
                  var26 = class94.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var24 != var16 && var16.x == var24.x && var16.y == var24.y) {
                        WorldMapData.method339(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field974) {
                  WorldMapData.method339(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class7.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = class115.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        DecorativeObject.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class54.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((MouseRecorder.field817 & 1) == 1) {
                           DecorativeObject.addMenuEntry(Client.field1013, Client.field1014 + " " + "->" + " " + class54.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;
                        if(Client.numberMenuOptions) {
                           var21 = class37.prependIndices(var21);
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

                              DecorativeObject.addMenuEntry(var21[var22], class54.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              DecorativeObject.addMenuEntry("Take", class54.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        DecorativeObject.addMenuEntry("Examine", class54.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field974];
         WorldMapData.method339(var18, Client.field974, var6, var7);
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "2032276312"
   )
   static final void method538(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(FontName.loadWidget(var0)) {
         FontName.field3710 = null;
         class11.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(FontName.field3710 != null) {
            class11.gameDraw(FontName.field3710, -1412584499, var1, var2, var3, var4, class60.field719, Client.field1134, var7);
            FontName.field3710 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1041[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1041[var8] = true;
            }
         }

      }
   }
}

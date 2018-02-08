import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements TaskDataProvider {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ldf;",
      garbageValue = "956750753"
   )
   public AbstractSoundSystem taskData() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;B)V",
      garbageValue = "-29"
   )
   public static void method739(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      NPCComposition.NpcDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-92"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class161.listFetcher == null) {
            class161.listFetcher = NPC.urlRequester.request(new URL(Client.field846));
         } else if(class161.listFetcher.isDone()) {
            byte[] var0 = class161.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            class31.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = class31.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            class175.method3419(class31.worldList, 0, class31.worldList.length - 1, World.field1187, World.field1186);
            class161.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class161.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "765274851"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      CombatInfoListHolder.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-1960592883"
   )
   static String method734(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1521502409"
   )
   static final void method738(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var9 * var11 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var12 * var8 + var11 * var10 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      class89.cameraX = var0 - var8;
      class216.cameraZ = var1 - var9;
      class3.cameraY = var2 - var10;
      ScriptEvent.cameraPitch = var3;
      class80.cameraYaw = var4;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lhs;III)V",
      garbageValue = "-697745914"
   )
   static final void method743(Widget var0, int var1, int var2) {
      if(var0.field2860 == 1) {
         NPCComposition.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2860 == 2 && !Client.spellSelected) {
         var3 = class28.method240(var0);
         if(var3 != null) {
            NPCComposition.addMenuEntry(var3, class70.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2860 == 3) {
         NPCComposition.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2860 == 4) {
         NPCComposition.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2860 == 5) {
         NPCComposition.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2860 == 6 && Client.field885 == null) {
         NPCComposition.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var5;
      int var15;
      if(var0.type == 2) {
         var15 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var4;
               if(var15 < 20) {
                  var6 += var0.xSprites[var15];
                  var7 += var0.field2823[var15];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field896 = var15;
                  class45.field562 = var0;
                  if(var0.itemIds[var15] > 0) {
                     ItemComposition var8 = ItemContainer.getItemDefinition(var0.itemIds[var15] - 1);
                     if(Client.itemSelectionState == 1 && class54.method752(WorldComparator.getWidgetConfig(var0))) {
                        if(var0.id != class274.field3702 || var15 != class18.selectedItemIndex) {
                           NPCComposition.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class70.getColTags(16748608) + var8.name, 31, var8.id, var15, var0.id);
                        }
                     } else if(Client.spellSelected && class54.method752(WorldComparator.getWidgetConfig(var0))) {
                        if((Occluder.field2038 & 16) == 16) {
                           NPCComposition.addMenuEntry(Client.field854, Client.field995 + " " + "->" + " " + class70.getColTags(16748608) + var8.name, 32, var8.id, var15, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        if(Client.numberMenuOptions) {
                           var9 = class84.prependIndices(var9);
                        }

                        int var10 = -1;
                        if(Client.field972 && KeyFocusListener.keyPressed[81]) {
                           var10 = var8.method4981();
                        }

                        if(class54.method752(WorldComparator.getWidgetConfig(var0))) {
                           for(int var11 = 4; var11 >= 3; --var11) {
                              if(var10 != var11) {
                                 CollisionData.method3357(var0, var8, var15, var11, false);
                              }
                           }
                        }

                        int var12 = WorldComparator.getWidgetConfig(var0);
                        boolean var19 = (var12 >> 31 & 1) != 0;
                        if(var19) {
                           NPCComposition.addMenuEntry("Use", class70.getColTags(16748608) + var8.name, 38, var8.id, var15, var0.id);
                        }

                        Object var10000 = null;
                        int var13;
                        if(class54.method752(WorldComparator.getWidgetConfig(var0))) {
                           for(var13 = 2; var13 >= 0; --var13) {
                              if(var10 != var13) {
                                 CollisionData.method3357(var0, var8, var15, var13, false);
                              }
                           }

                           if(var10 >= 0) {
                              CollisionData.method3357(var0, var8, var15, var10, true);
                           }
                        }

                        var9 = var0.configActions;
                        if(Client.numberMenuOptions) {
                           var9 = class84.prependIndices(var9);
                        }

                        if(var9 != null) {
                           for(var13 = 4; var13 >= 0; --var13) {
                              if(var9[var13] != null) {
                                 byte var14 = 0;
                                 if(var13 == 0) {
                                    var14 = 39;
                                 }

                                 if(var13 == 1) {
                                    var14 = 40;
                                 }

                                 if(var13 == 2) {
                                    var14 = 41;
                                 }

                                 if(var13 == 3) {
                                    var14 = 42;
                                 }

                                 if(var13 == 4) {
                                    var14 = 43;
                                 }

                                 NPCComposition.addMenuEntry(var9[var13], class70.getColTags(16748608) + var8.name, var14, var8.id, var15, var0.id);
                              }
                           }
                        }

                        NPCComposition.addMenuEntry("Examine", class70.getColTags(16748608) + var8.name, 1005, var8.id, var15, var0.id);
                     }
                  }
               }

               ++var15;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(KeyFocusListener.method733(WorldComparator.getWidgetConfig(var0)) && (Occluder.field2038 & 32) == 32) {
               NPCComposition.addMenuEntry(Client.field854, Client.field995 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var15 = 9; var15 >= 5; --var15) {
               String var16 = class29.method243(var0, var15);
               if(var16 != null) {
                  NPCComposition.addMenuEntry(var16, var0.name, 1007, var15 + 1, var0.index, var0.id);
               }
            }

            var3 = class28.method240(var0);
            if(var3 != null) {
               NPCComposition.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var17 = class29.method243(var0, var4);
               if(var17 != null) {
                  NPCComposition.addMenuEntry(var17, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            var5 = WorldComparator.getWidgetConfig(var0);
            boolean var18 = (var5 & 1) != 0;
            if(var18) {
               NPCComposition.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}

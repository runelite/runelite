import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class44 extends WorldMapData {
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "Lbl;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("s")
   HashSet field541;
   @ObfuscatedName("n")
   HashSet field542;
   @ObfuscatedName("y")
   List field544;

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Lgh;Lgh;Lgh;IZB)V",
      garbageValue = "11"
   )
   void method618(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field541 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method161(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field541.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field542 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method630(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field542.add(var9);
      }

      this.method619(var2, var5);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lgh;ZI)V",
      garbageValue = "-2144667660"
   )
   void method619(Buffer var1, boolean var2) {
      this.field544 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3372();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field544.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "2"
   )
   static long method620() {
      try {
         URL var0 = new URL(class22.method167("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1721765707"
   )
   static void method627() {
      if(MouseRecorder.loadWorlds()) {
         class91.worldSelectShown = true;
      }

   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "34"
   )
   static final void method625(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class39.method546(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1117 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2042097043"
   )
   static final void method626(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class37.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
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
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class48.region.getObjectFlags(BoundingBox2D.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = CacheFile.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class37.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + Buffer.getColTags(65535) + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class86.field1278 & 4) == 4) {
                     class37.addMenuEntry(Client.field986, Client.field910 + " " + "->" + " " + Buffer.getColTags(65535) + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var19 = var12.actions;
                  if(Client.numberMenuOptions) {
                     var19 = GameEngine.prependIndices(var19);
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

                           class37.addMenuEntry(var19[var20], Buffer.getColTags(65535) + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class37.addMenuEntry("Examine", Buffer.getColTags(65535) + var12.name, 1002, var12.id << 14, var8, var9);
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

               if(var23.composition.field3620 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14 != var23 && var14.composition.field3620 == 1 && var14.x == var23.x && var14.y == var23.y) {
                        class232.method4202(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class94.playerIndexesCount;
                  var26 = class94.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        class234.drawRightClickMenuOptions(var16, var26[var28], var8, var9);
                     }
                  }
               }

               class232.method4202(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.npcIndexesCount; ++var13) {
                     var14 = Client.cachedNPCs[Client.npcIndices[var13]];
                     if(var14 != null && var14.composition.field3620 == 1 && var24.x == var14.x && var24.y == var14.y) {
                        class232.method4202(var14.composition, Client.npcIndices[var13], var8, var9);
                     }
                  }

                  var13 = class94.playerIndexesCount;
                  var26 = class94.playerIndices;

                  for(var28 = 0; var28 < var13; ++var28) {
                     var16 = Client.cachedPlayers[var26[var28]];
                     if(var16 != null && var16 != var24 && var16.x == var24.x && var24.y == var16.y) {
                        class234.drawRightClickMenuOptions(var16, var26[var28], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field957) {
                  class234.drawRightClickMenuOptions(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[BoundingBox2D.plane][var8][var9];
               if(var25 != null) {
                  for(Item var29 = (Item)var25.getTail(); var29 != null; var29 = (Item)var25.getPrevious()) {
                     ItemComposition var27 = KitDefinition.getItemDefinition(var29.id);
                     if(Client.itemSelectionState == 1) {
                        class37.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + Buffer.getColTags(16748608) + var27.name, 16, var29.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class86.field1278 & 1) == 1) {
                           class37.addMenuEntry(Client.field986, Client.field910 + " " + "->" + " " + Buffer.getColTags(16748608) + var27.name, 17, var29.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var27.groundActions;
                        if(Client.numberMenuOptions) {
                           var21 = GameEngine.prependIndices(var21);
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

                              class37.addMenuEntry(var21[var22], Buffer.getColTags(16748608) + var27.name, var17, var29.id, var8, var9);
                           } else if(var22 == 2) {
                              class37.addMenuEntry("Take", Buffer.getColTags(16748608) + var27.name, 20, var29.id, var8, var9);
                           }
                        }

                        class37.addMenuEntry("Examine", Buffer.getColTags(16748608) + var27.name, 1004, var29.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field957];
         class234.drawRightClickMenuOptions(var18, Client.field957, var6, var7);
      }

   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "885493032"
   )
   static void method628(int var0, int var1) {
      class3.method6(PendingSpawn.topContextMenuRow, var0, var1);
      PendingSpawn.topContextMenuRow = null;
   }
}

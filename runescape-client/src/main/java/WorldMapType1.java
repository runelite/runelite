import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      intValue = 34100395
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1804854277
   )
   static int field443;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -307226473
   )
   int field437;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1820268281
   )
   int field434;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2130760737
   )
   int field435;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 614527595
   )
   int field439;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 811764253
   )
   int field436;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1604034503
   )
   int field438;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -338263797
   )
   int field433;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2036547967
   )
   int field442;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1189345241
   )
   int field440;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 773722837
   )
   int field441;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "-33"
   )
   public void vmethod716(WorldMapData var1) {
      if(var1.field459 > this.field433) {
         var1.field459 = this.field433;
      }

      if(var1.field460 < this.field440) {
         var1.field460 = this.field440;
      }

      if(var1.field453 > this.field442) {
         var1.field453 = this.field442;
      }

      if(var1.field462 < this.field441) {
         var1.field462 = this.field441;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1122721489"
   )
   public boolean vmethod712(int var1, int var2, int var3) {
      return var1 >= this.field437 && var1 < this.field434 + this.field437?var2 >> 6 >= this.field435 && var2 >> 6 <= this.field436 && var3 >> 6 >= this.field439 && var3 >> 6 <= this.field438:false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-78"
   )
   public boolean vmethod715(int var1, int var2) {
      return var1 >> 6 >= this.field433 && var1 >> 6 <= this.field440 && var2 >> 6 >= this.field442 && var2 >> 6 <= this.field441;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "606812260"
   )
   public int[] vmethod714(int var1, int var2, int var3) {
      if(!this.vmethod712(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field433 * 64 - this.field435 * 64 + var2, var3 + (this.field442 * 64 - this.field439 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lic;",
      garbageValue = "-1902472796"
   )
   public Coordinates vmethod717(int var1, int var2) {
      if(!this.vmethod715(var1, var2)) {
         return null;
      } else {
         int var3 = this.field435 * 64 - this.field433 * 64 + var1;
         int var4 = this.field439 * 64 - this.field442 * 64 + var2;
         return new Coordinates(this.field437, var3, var4);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "241325114"
   )
   public void vmethod718(Buffer var1) {
      this.field437 = var1.readUnsignedByte();
      this.field434 = var1.readUnsignedByte();
      this.field435 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.field438 = var1.readUnsignedShort();
      this.field433 = var1.readUnsignedShort();
      this.field442 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.field441 = var1.readUnsignedShort();
      this.method261();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1744457886"
   )
   void method261() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljava/lang/String;Ljava/lang/String;I)[Lly;",
      garbageValue = "-1938447654"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!AbstractByteBuffer.method3843(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Area.method4898();
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "730621442"
   )
   static int method282(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class81.intStack[++class81.intStackSize - 1] = GrandExchangeEvents.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = class18.method132();
            if(var3 != null) {
               class81.intStack[++class81.intStackSize - 1] = var3.id;
               class81.intStack[++class81.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class81.intStackSize - 1] = var3.location;
               class81.intStack[++class81.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class81.intStackSize - 1] = -1;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = ServerPacket.method3479();
            if(var3 != null) {
               class81.intStack[++class81.intStackSize - 1] = var3.id;
               class81.intStack[++class81.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++class81.intStackSize - 1] = var3.location;
               class81.intStack[++class81.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++class81.intStackSize - 1] = -1;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.intStack[++class81.intStackSize - 1] = 0;
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class81.intStack[--class81.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class81.intStack[++class81.intStackSize - 1] = var4.id;
                  class81.intStack[++class81.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class81.intStackSize - 1] = var4.location;
                  class81.intStack[++class81.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class81.intStackSize -= 4;
               var7 = class81.intStack[class81.intStackSize];
               boolean var10 = class81.intStack[class81.intStackSize + 1] == 1;
               var5 = class81.intStack[class81.intStackSize + 2];
               boolean var6 = class81.intStack[class81.intStackSize + 3] == 1;
               class90.method1940(var7, var10, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field937 = class81.intStack[--class81.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class278 var9;
                  if(var0 == 6513) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = Timer.method3375(var8);
                     if(var9.method5043()) {
                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = class255.getNpcDefinition(var7).method5234(var8, var9.field3543);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = class255.getNpcDefinition(var7).method5233(var8, var9.field3542);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = Timer.method3375(var8);
                     if(var9.method5043()) {
                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = class169.getObjectDefinition(var7).method5121(var8, var9.field3543);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = class169.getObjectDefinition(var7).method5120(var8, var9.field3542);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = Timer.method3375(var8);
                     if(var9.method5043()) {
                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = class251.getItemDefinition(var7).method5171(var8, var9.field3543);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = class251.getItemDefinition(var7).method5210(var8, var9.field3542);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class81.intStackSize -= 2;
                     var7 = class81.intStack[class81.intStackSize];
                     var8 = class81.intStack[class81.intStackSize + 1];
                     var9 = Timer.method3375(var8);
                     if(var9.method5043()) {
                        class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = class170.method3339(var7).method5050(var8, var9.field3543);
                     } else {
                        class81.intStack[++class81.intStackSize - 1] = class170.method3339(var7).method5055(var8, var9.field3542);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class81.intStack[++class81.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class81.intStack[--class81.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = World.worldList[var7];
                  class81.intStack[++class81.intStackSize - 1] = var4.id;
                  class81.intStack[++class81.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++class81.intStackSize - 1] = var4.location;
                  class81.intStack[++class81.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "-66"
   )
   static final void method280(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class62.field751 || class1.field9 != var1) {
         class62.field751 = var0;
         class1.field9 = var1;
         Enum.setGameState(25);
         SoundTaskDataProvider.method783("Loading - please wait.", true);
         int var3 = baseX;
         int var4 = Enum.baseY;
         baseX = (var0 - 6) * 8;
         Enum.baseY = (var1 - 6) * 8;
         int var5 = baseX - var3;
         int var6 = Enum.baseY - var4;
         var3 = baseX;
         var4 = Enum.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.queuedSoundEffectCount = 0;
         Client.field1092 = false;
         Resampler.cameraX -= var5 << 7;
         class31.cameraY -= var6 << 7;
         field443 -= var5 << 7;
         class171.field2218 -= var6 << 7;
         Client.field1073 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1481244014"
   )
   static void method264(int var0) {
      UrlRequester.topContextMenuRow = new ContextMenuRow();
      UrlRequester.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      UrlRequester.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      UrlRequester.topContextMenuRow.type = Client.menuTypes[var0];
      UrlRequester.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      UrlRequester.topContextMenuRow.option = Client.menuOptions[var0];
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "750423031"
   )
   static void method283(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3643; ++var4) {
         ItemComposition var5 = class251.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               AttackOption.field1333 = -1;
               class45.field578 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class45.field578 = var2;
      BaseVarType.field28 = 0;
      AttackOption.field1333 = var3;
      String[] var8 = new String[AttackOption.field1333];

      for(int var9 = 0; var9 < AttackOption.field1333; ++var9) {
         var8[var9] = class251.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = class45.field578;
      GameCanvas.method798(var8, var10, 0, var8.length - 1);
   }
}

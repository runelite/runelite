import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   static SpritePixels[] field1854;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1342595845
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1065573783
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 944584781
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1485454357
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -279196355
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1994975015"
   )
   static boolean method2540(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1375116879"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   static void method2538() {
      Object var0 = class236.field3231;
      synchronized(class236.field3231) {
         if(class236.field3228 == 0) {
            class223.field2835 = new Thread(new class236());
            class223.field2835.setDaemon(true);
            class223.field2835.start();
            class223.field2835.setPriority(5);
         }

         class236.field3228 = 600;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-936460157"
   )
   static int method2541(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class251.field3392:class164.field2314;
      if(var0 == 1500) {
         class81.intStack[++class278.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class81.intStack[++class278.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class81.intStack[++class278.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class81.intStack[++class278.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class81.intStack[++class278.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class81.intStack[++class278.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "2072436404"
   )
   static final void method2539(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class51.field678 || class94.field1500 != var1) {
         class51.field678 = var0;
         class94.field1500 = var1;
         class72.setGameState(25);
         class24.drawStatusBox("Loading - please wait.", true);
         int var3 = class22.baseX;
         int var4 = class273.baseY;
         class22.baseX = (var0 - 6) * 8;
         class273.baseY = (var1 - 6) * 8;
         int var5 = class22.baseX - var3;
         int var6 = class273.baseY - var4;
         var3 = class22.baseX;
         var4 = class273.baseY;

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
         for(int var13 = var20; var18 != var13; var13 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var14 + var6;

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

         Client.field1154 = 0;
         Client.field1160 = false;
         Client.field1116 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}

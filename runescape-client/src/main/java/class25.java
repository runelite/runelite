import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class25 {
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   @Export("rssocket")
   static class169 rssocket;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -646327649
   )
   int field373;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   Coordinates field371;

   @ObfuscatedSignature(
      signature = "(ILio;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field373 = var1;
      this.field371 = var2;
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lji;",
      garbageValue = "704829096"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class167.dat2File != null) {
         var4 = new IndexFile(var0, class167.dat2File, class7.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, ScriptEvent.indexStore255, var0, var1, var2, var3);
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "85"
   )
   static final void method191() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(Client.field926 == 0) {
         var0 = class265.localPlayer.x;
         var1 = class265.localPlayer.y;
         if(Size.field367 - var0 < -500 || Size.field367 - var0 > 500 || class236.field2783 - var1 < -500 || class236.field2783 - var1 > 500) {
            Size.field367 = var0;
            class236.field2783 = var1;
         }

         if(var0 != Size.field367) {
            Size.field367 += (var0 - Size.field367) / 16;
         }

         if(var1 != class236.field2783) {
            class236.field2783 += (var1 - class236.field2783) / 16;
         }

         var2 = Size.field367 >> 7;
         var3 = class236.field2783 >> 7;
         var4 = GrandExchangeEvent.getTileHeight(Size.field367, class236.field2783, ScriptVarType.plane);
         var5 = 0;
         int var6;
         if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = ScriptVarType.plane;
                  if(var8 < 3 && (class62.tileSettings[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - class62.tileHeights[var8][var6][var7];
                  if(var9 > var5) {
                     var5 = var9;
                  }
               }
            }
         }

         var6 = var5 * 192;
         if(var6 > 98048) {
            var6 = 98048;
         }

         if(var6 < 32768) {
            var6 = 32768;
         }

         if(var6 > Client.field937) {
            Client.field937 += (var6 - Client.field937) / 24;
         } else if(var6 < Client.field937) {
            Client.field937 += (var6 - Client.field937) / 80;
         }

         AttackOption.field1333 = GrandExchangeEvent.getTileHeight(class265.localPlayer.x, class265.localPlayer.y, ScriptVarType.plane) - Client.field927;
      } else if(Client.field926 == 1) {
         if(Client.field934 && class265.localPlayer != null) {
            var0 = class265.localPlayer.pathX[0];
            var1 = class265.localPlayer.pathY[0];
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               Size.field367 = class265.localPlayer.x;
               var2 = GrandExchangeEvent.getTileHeight(class265.localPlayer.x, class265.localPlayer.y, ScriptVarType.plane) - Client.field927;
               if(var2 < AttackOption.field1333) {
                  AttackOption.field1333 = var2;
               }

               class236.field2783 = class265.localPlayer.y;
               Client.field934 = false;
            }
         }

         short var10 = -1;
         if(KeyFocusListener.keyPressed[33]) {
            var10 = 0;
         } else if(KeyFocusListener.keyPressed[49]) {
            var10 = 1024;
         }

         if(KeyFocusListener.keyPressed[48]) {
            if(var10 == 0) {
               var10 = 1792;
            } else if(var10 == 1024) {
               var10 = 1280;
            } else {
               var10 = 1536;
            }
         } else if(KeyFocusListener.keyPressed[50]) {
            if(var10 == 0) {
               var10 = 256;
            } else if(var10 == 1024) {
               var10 = 768;
            } else {
               var10 = 512;
            }
         }

         byte var11 = 0;
         if(KeyFocusListener.keyPressed[35]) {
            var11 = -1;
         } else if(KeyFocusListener.keyPressed[51]) {
            var11 = 1;
         }

         var2 = 0;
         if(var10 >= 0 || var11 != 0) {
            var2 = KeyFocusListener.keyPressed[81]?Client.field858:Client.field931;
            var2 *= 16;
            Client.field929 = var10;
            Client.field930 = var11;
         }

         if(Client.field965 < var2) {
            Client.field965 += var2 / 8;
            if(Client.field965 > var2) {
               Client.field965 = var2;
            }
         } else if(Client.field965 > var2) {
            Client.field965 = Client.field965 * 9 / 10;
         }

         if(Client.field965 > 0) {
            var3 = Client.field965 / 16;
            if(Client.field929 >= 0) {
               var0 = Client.field929 - class33.cameraYaw & 2047;
               var4 = Graphics3D.SINE[var0];
               var5 = Graphics3D.COSINE[var0];
               Size.field367 += var4 * var3 / 65536;
               class236.field2783 += var5 * var3 / 65536;
            }

            if(Client.field930 != 0) {
               AttackOption.field1333 += var3 * Client.field930;
               if(AttackOption.field1333 > 0) {
                  AttackOption.field1333 = 0;
               }
            }
         } else {
            Client.field929 = -1;
            Client.field930 = -1;
         }

         if(KeyFocusListener.keyPressed[13]) {
            WorldComparator.method72();
         }
      }

      if(MouseInput.mouseCurrentButton == 4 && Occluder.middleMouseMovesCamera) {
         var0 = MouseInput.mouseLastY - Client.field925;
         Client.field923 = var0 * 2;
         Client.field925 = var0 != -1 && var0 != 1?(MouseInput.mouseLastY + Client.field925) / 2:MouseInput.mouseLastY;
         var1 = Client.field924 - MouseInput.mouseLastX;
         Client.field922 = var1 * 2;
         Client.field924 = var1 != -1 && var1 != 1?(Client.field924 + MouseInput.mouseLastX) / 2:MouseInput.mouseLastX;
      } else {
         if(KeyFocusListener.keyPressed[96]) {
            Client.field922 += (-24 - Client.field922) / 2;
         } else if(KeyFocusListener.keyPressed[97]) {
            Client.field922 += (24 - Client.field922) / 2;
         } else {
            Client.field922 /= 2;
         }

         if(KeyFocusListener.keyPressed[98]) {
            Client.field923 += (12 - Client.field923) / 2;
         } else if(KeyFocusListener.keyPressed[99]) {
            Client.field923 += (-12 - Client.field923) / 2;
         } else {
            Client.field923 /= 2;
         }

         Client.field925 = MouseInput.mouseLastY;
         Client.field924 = MouseInput.mouseLastX;
      }

      Client.mapAngle = Client.field922 / 2 + Client.mapAngle & 2047;
      Client.cameraPitchTarget += Client.field923 / 2;
      if(Client.cameraPitchTarget < 128) {
         Client.cameraPitchTarget = 128;
      }

      if(Client.cameraPitchTarget > 383) {
         Client.cameraPitchTarget = 383;
      }

   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-700397504"
   )
   static final void method189() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == ScriptVarType.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, GrandExchangeEvent.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class265.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, GrandExchangeEvent.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field913);
               GameSocket.region.method2958(ScriptVarType.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(IIII)Lbt;",
      garbageValue = "1536383497"
   )
   static final WidgetNode method192(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      WorldMapType1.method274(var1);
      Widget var4 = UnitPriceComparator.getWidget(var0);
      TotalQuantityComparator.method100(var4);
      if(Client.field1017 != null) {
         TotalQuantityComparator.method100(Client.field1017);
         Client.field1017 = null;
      }

      class264.method4807();
      class33.method372(GZipDecompressor.widgets[var0 >> 16], var4, false);
      class95.runWidgetOnLoadListener(var1);
      if(Client.widgetRoot != -1) {
         GraphicsObject.method1920(Client.widgetRoot, 1);
      }

      return var3;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public enum class246 implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3328(2, 0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3326(0, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3329(1, 2);

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1619546375
   )
   public final int field3327;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 727192549
   )
   final int field3325;

   class246(int var3, int var4) {
      this.field3327 = var3;
      this.field3325 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field3325;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-709683858"
   )
   static final void method4249(int var0, int var1, int var2, int var3) {
      ++Client.field951;
      if(class275.localPlayer.x >> 7 == Client.destinationX && class275.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      Varcs.method1805();
      if(Client.field1070 >= 0 && Client.cachedPlayers[Client.field1070] != null) {
         class34.method458(Client.cachedPlayers[Client.field1070], false);
      }

      Player.method1091(true);
      int var4 = class94.playerIndexesCount;
      int[] var5 = class94.playerIndices;

      int var6;
      for(var6 = 0; var6 < var4; ++var6) {
         if(var5[var6] != Client.field1070 && var5[var6] != Client.localInteractingIndex) {
            class34.method458(Client.cachedPlayers[var5[var6]], true);
         }
      }

      Player.method1091(false);

      for(Projectile var27 = (Projectile)Client.projectiles.getFront(); var27 != null; var27 = (Projectile)Client.projectiles.getNext()) {
         if(var27.floor == class28.plane && Client.gameCycle <= var27.cycle) {
            if(Client.gameCycle >= var27.startTime) {
               if(var27.interacting > 0) {
                  NPC var31 = Client.cachedNPCs[var27.interacting - 1];
                  if(var31 != null && var31.x >= 0 && var31.x < 13312 && var31.y >= 0 && var31.y < 13312) {
                     var27.method1747(var31.x, var31.y, class18.getTileHeight(var31.x, var31.y, var27.floor) - var27.endHeight, Client.gameCycle);
                  }
               }

               if(var27.interacting < 0) {
                  var6 = -var27.interacting - 1;
                  Player var32;
                  if(var6 == Client.localInteractingIndex) {
                     var32 = class275.localPlayer;
                  } else {
                     var32 = Client.cachedPlayers[var6];
                  }

                  if(var32 != null && var32.x >= 0 && var32.x < 13312 && var32.y >= 0 && var32.y < 13312) {
                     var27.method1747(var32.x, var32.y, class18.getTileHeight(var32.x, var32.y, var27.floor) - var27.endHeight, Client.gameCycle);
                  }
               }

               var27.method1739(Client.field922);
               Client.region.method2699(class28.plane, (int)var27.x, (int)var27.velocityZ, (int)var27.z, 60, var27, var27.rotationX, -1, false);
            }
         } else {
            var27.unlink();
         }
      }

      for(GraphicsObject var35 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var35 != null; var35 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var35.level == class28.plane && !var35.finished) {
            if(Client.gameCycle >= var35.startCycle) {
               var35.method1635(Client.field922);
               if(var35.finished) {
                  var35.unlink();
               } else {
                  Client.region.method2699(var35.level, var35.x, var35.y, var35.height, 60, var35, 0, -1, false);
               }
            }
         } else {
            var35.unlink();
         }
      }

      FileOnDisk.method2387(var0, var1, var2, var3, true);
      var0 = Client.field1099;
      var1 = Client.field1109;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2601();
      int var28;
      if(!Client.field1094) {
         var4 = Client.field930;
         if(Client.field1055 / 256 > var4) {
            var4 = Client.field1055 / 256;
         }

         if(Client.field1095[4] && Client.field1074[4] + 128 > var4) {
            var4 = Client.field1074[4] + 128;
         }

         var28 = Client.mapAngle & 2047;
         GrandExchangeOffer.method112(WorldMapType3.field360, class18.getTileHeight(class275.localPlayer.x, class275.localPlayer.y, class28.plane) - Client.field902, class74.field846, var4, var28, var4 * 3 + 600);
      }

      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var14;
      if(!Client.field1094) {
         if(class70.preferences.hideRoofs) {
            var28 = class28.plane;
         } else {
            label610: {
               var6 = 3;
               if(class45.cameraPitch < 310) {
                  var7 = class45.cameraX >> 7;
                  var8 = Client.cameraY >> 7;
                  var9 = class275.localPlayer.x >> 7;
                  var10 = class275.localPlayer.y >> 7;
                  if(var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
                     var28 = class28.plane;
                     break label610;
                  }

                  if((class61.tileSettings[class28.plane][var7][var8] & 4) != 0) {
                     var6 = class28.plane;
                  }

                  if(var9 > var7) {
                     var11 = var9 - var7;
                  } else {
                     var11 = var7 - var9;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  int var13;
                  if(var11 > var12) {
                     var13 = var12 * 65536 / var11;
                     var14 = 32768;

                     while(var7 != var9) {
                        if(var7 < var9) {
                           ++var7;
                        } else if(var7 > var9) {
                           --var7;
                        }

                        if((class61.tileSettings[class28.plane][var7][var8] & 4) != 0) {
                           var6 = class28.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[class28.plane][var7][var8] & 4) != 0) {
                              var6 = class28.plane;
                           }
                        }
                     }
                  } else {
                     var13 = var11 * 65536 / var12;
                     var14 = 32768;

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class61.tileSettings[class28.plane][var7][var8] & 4) != 0) {
                           var6 = class28.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var7 < var9) {
                              ++var7;
                           } else if(var7 > var9) {
                              --var7;
                           }

                           if((class61.tileSettings[class28.plane][var7][var8] & 4) != 0) {
                              var6 = class28.plane;
                           }
                        }
                     }
                  }
               }

               if(class275.localPlayer.x >= 0 && class275.localPlayer.y >= 0 && class275.localPlayer.x < 13312 && class275.localPlayer.y < 13312) {
                  if((class61.tileSettings[class28.plane][class275.localPlayer.x >> 7][class275.localPlayer.y >> 7] & 4) != 0) {
                     var6 = class28.plane;
                  }

                  var28 = var6;
               } else {
                  var28 = class28.plane;
               }
            }
         }

         var4 = var28;
      } else {
         var4 = Player.method1079();
      }

      var28 = class45.cameraX;
      var6 = class279.cameraZ;
      var7 = Client.cameraY;
      var8 = class45.cameraPitch;
      var9 = class230.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field1095[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field868[var10] * 2 + 1) - (double)Client.field868[var10] + Math.sin((double)Client.field1098[var10] / 100.0D * (double)Client.field990[var10]) * (double)Client.field1074[var10]);
            if(var10 == 0) {
               class45.cameraX += var11;
            }

            if(var10 == 1) {
               class279.cameraZ += var11;
            }

            if(var10 == 2) {
               Client.cameraY += var11;
            }

            if(var10 == 3) {
               class230.cameraYaw = var11 + class230.cameraYaw & 2047;
            }

            if(var10 == 4) {
               class45.cameraPitch += var11;
               if(class45.cameraPitch < 128) {
                  class45.cameraPitch = 128;
               }

               if(class45.cameraPitch > 383) {
                  class45.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseInput.field681;
      var11 = MouseInput.field676;
      if(MouseInput.field687 != 0) {
         var10 = MouseInput.field674;
         var11 = MouseInput.field688;
      }

      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         Script.method1825(var10 - var0, var11 - var1);
      } else {
         class133.field1903 = false;
         class133.field1907 = 0;
      }

      class90.method1683();
      Rasterizer2D.method4981(var0, var1, var2, var3, 0);
      class90.method1683();
      var12 = Graphics3D.field1926;
      Graphics3D.field1926 = Client.scale;
      Client.region.draw(class45.cameraX, class279.cameraZ, Client.cameraY, class45.cameraPitch, class230.cameraYaw, var4);
      class24.method175();
      Graphics3D.field1926 = var12;
      class90.method1683();
      Client.region.clearEntities();
      Client.field940 = 0;
      boolean var33 = false;
      var14 = -1;
      int var15 = class94.playerIndexesCount;
      int[] var16 = class94.playerIndices;

      int var17;
      for(var17 = 0; var17 < var15 + Client.npcIndexesCount; ++var17) {
         Object var18;
         if(var17 < var15) {
            var18 = Client.cachedPlayers[var16[var17]];
            if(var16[var17] == Client.field1070) {
               var33 = true;
               var14 = var17;
               continue;
            }
         } else {
            var18 = Client.cachedNPCs[Client.npcIndices[var17 - var15]];
         }

         class171.method3123((Actor)var18, var17, var0, var1, var2, var3);
      }

      if(var33) {
         class171.method3123(Client.cachedPlayers[Client.field1070], var14, var0, var1, var2, var3);
      }

      for(var17 = 0; var17 < Client.field940; ++var17) {
         int var29 = Client.field942[var17];
         int var19 = Client.field1120[var17];
         int var20 = Client.field904[var17];
         int var21 = Client.field944[var17];
         boolean var22 = true;

         while(var22) {
            var22 = false;

            for(int var23 = 0; var23 < var17; ++var23) {
               if(var19 + 2 > Client.field1120[var23] - Client.field944[var23] && var19 - var21 < Client.field1120[var23] + 2 && var29 - var20 < Client.field904[var23] + Client.field942[var23] && var29 + var20 > Client.field942[var23] - Client.field904[var23] && Client.field1120[var23] - Client.field944[var23] < var19) {
                  var19 = Client.field1120[var23] - Client.field944[var23];
                  var22 = true;
               }
            }
         }

         Client.screenY = Client.field942[var17];
         Client.screenX = Client.field1120[var17] = var19;
         String var30 = Client.field949[var17];
         if(Client.field1009 == 0) {
            int var24 = 16776960;
            if(Client.field900[var17] < 6) {
               var24 = Client.field1062[Client.field900[var17]];
            }

            if(Client.field900[var17] == 6) {
               var24 = Client.field951 % 20 < 10?16711680:16776960;
            }

            if(Client.field900[var17] == 7) {
               var24 = Client.field951 % 20 < 10?255:'\uffff';
            }

            if(Client.field900[var17] == 8) {
               var24 = Client.field951 % 20 < 10?'뀀':8454016;
            }

            int var25;
            if(Client.field900[var17] == 9) {
               var25 = 150 - Client.field931[var17];
               if(var25 < 50) {
                  var24 = var25 * 1280 + 16711680;
               } else if(var25 < 100) {
                  var24 = 16776960 - (var25 - 50) * 327680;
               } else if(var25 < 150) {
                  var24 = (var25 - 100) * 5 + 65280;
               }
            }

            if(Client.field900[var17] == 10) {
               var25 = 150 - Client.field931[var17];
               if(var25 < 50) {
                  var24 = var25 * 5 + 16711680;
               } else if(var25 < 100) {
                  var24 = 16711935 - (var25 - 50) * 327680;
               } else if(var25 < 150) {
                  var24 = (var25 - 100) * 327680 + 255 - (var25 - 100) * 5;
               }
            }

            if(Client.field900[var17] == 11) {
               var25 = 150 - Client.field931[var17];
               if(var25 < 50) {
                  var24 = 16777215 - var25 * 327685;
               } else if(var25 < 100) {
                  var24 = (var25 - 50) * 327685 + 65280;
               } else if(var25 < 150) {
                  var24 = 16777215 - (var25 - 100) * 327680;
               }
            }

            if(Client.field947[var17] == 0) {
               Client.field909.method4773(var30, var0 + Client.screenY, Client.screenX + var1, var24, 0);
            }

            if(Client.field947[var17] == 1) {
               Client.field909.method4775(var30, var0 + Client.screenY, Client.screenX + var1, var24, 0, Client.field951);
            }

            if(Client.field947[var17] == 2) {
               Client.field909.method4776(var30, var0 + Client.screenY, Client.screenX + var1, var24, 0, Client.field951);
            }

            if(Client.field947[var17] == 3) {
               Client.field909.method4777(var30, var0 + Client.screenY, Client.screenX + var1, var24, 0, Client.field951, 150 - Client.field931[var17]);
            }

            if(Client.field947[var17] == 4) {
               var25 = (150 - Client.field931[var17]) * (Client.field909.method4790(var30) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               Client.field909.method4770(var30, var0 + Client.screenY + 50 - var25, Client.screenX + var1, var24, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field947[var17] == 5) {
               var25 = 150 - Client.field931[var17];
               int var26 = 0;
               if(var25 < 25) {
                  var26 = var25 - 25;
               } else if(var25 > 125) {
                  var26 = var25 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - Client.field909.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               Client.field909.method4773(var30, var0 + Client.screenY, var26 + Client.screenX + var1, var24, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            Client.field909.method4773(var30, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
         }
      }

      PacketNode.method3098(var0, var1);
      ((TextureProvider)Graphics3D.textureLoader).method2394(Client.field922);
      WorldMapType2.method508(var0, var1, var2, var3);
      class45.cameraX = var28;
      class279.cameraZ = var6;
      Client.cameraY = var7;
      class45.cameraPitch = var8;
      class230.cameraYaw = var9;
      if(Client.field1005) {
         byte var34 = 0;
         var14 = var34 + class245.field3308 + class245.field3310;
         if(var14 == 0) {
            Client.field1005 = false;
         }
      }

      if(Client.field1005) {
         Rasterizer2D.method4981(var0, var1, var2, var3, 0);
         IndexFile.drawStatusBox("Loading - please wait.", false);
      }

   }
}

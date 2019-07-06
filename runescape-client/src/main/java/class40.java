import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class40 {
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache7")
   static IndexCache indexCache7;
   @ObfuscatedName("gs")
   @Export("regionLandArchives")
   static byte[][] regionLandArchives;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1443846573
   )
   int field326;
   @ObfuscatedName("f")
   byte[][][] field329;

   class40(int var1) {
      this.field326 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "125"
   )
   void method743(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (var7 != 0 && this.field326 != 0 && this.field329 != null) {
         var8 = this.method744(var8, var7);
         var7 = this.method774(var7);
         Rasterizer2D.raster2d7(var1, var2, var5, var6, var3, var4, this.field329[var7 - 1][var8], this.field326);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-203451964"
   )
   int method744(int var1, int var2) {
      if (var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if (var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if (var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-63"
   )
   int method774(int var1) {
      return var1 != 9 && var1 != 10 ? (var1 == 11 ? 8 : var1) : 1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1551779144"
   )
   void method763() {
      if (this.field329 == null) {
         this.field329 = new byte[8][4][];
         this.method745();
         this.method748();
         this.method751();
         this.method750();
         this.method762();
         this.method752();
         this.method753();
         this.method754();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "196149319"
   )
   void method745() {
      byte[] var1 = new byte[this.field326 * this.field326];
      int var2 = 0;

      int var3;
      int var4;
      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1590087827"
   )
   void method748() {
      byte[] var1 = new byte[this.field326 * this.field326];
      int var2 = 0;

      int var3;
      int var4;
      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[1][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var2 >= 0 && var2 < var1.length) {
               if (var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field329[1][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[1][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[1][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "530017326"
   )
   void method751() {
      byte[] var1 = new byte[this.field326 * this.field326];
      int var2 = 0;

      int var3;
      int var4;
      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][3] = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   void method750() {
      byte[] var1 = new byte[this.field326 * this.field326];
      int var2 = 0;

      int var3;
      int var4;
      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-545325116"
   )
   void method762() {
      byte[] var1 = new byte[this.field326 * this.field326];
      int var2 = 0;

      int var3;
      int var4;
      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = this.field326 - 1; var3 >= 0; --var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = 0; var4 < this.field326; ++var4) {
            if (var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for (var3 = 0; var3 < this.field326; ++var3) {
         for (var4 = this.field326 - 1; var4 >= 0; --var4) {
            if (var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][3] = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2005544109"
   )
   void method752() {
      byte[] var1 = new byte[this.field326 * this.field326];
      boolean var2 = false;
      var1 = new byte[this.field326 * this.field326];
      int var3 = 0;

      int var4;
      int var5;
      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var5 <= this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[5][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var4 <= this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[5][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var5 >= this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[5][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var4 >= this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[5][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   void method753() {
      byte[] var1 = new byte[this.field326 * this.field326];
      boolean var2 = false;
      var1 = new byte[this.field326 * this.field326];
      int var3 = 0;

      int var4;
      int var5;
      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var5 <= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[6][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = this.field326 - 1; var4 >= 0; --var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var5 <= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[6][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = this.field326 - 1; var4 >= 0; --var4) {
         for (var5 = this.field326 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[6][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = this.field326 - 1; var5 >= 0; --var5) {
            if (var5 <= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[6][3] = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2013517896"
   )
   void method754() {
      byte[] var1 = new byte[this.field326 * this.field326];
      boolean var2 = false;
      var1 = new byte[this.field326 * this.field326];
      int var3 = 0;

      int var4;
      int var5;
      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var5 >= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[7][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = this.field326 - 1; var4 >= 0; --var4) {
         for (var5 = 0; var5 < this.field326; ++var5) {
            if (var5 >= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[7][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = this.field326 - 1; var4 >= 0; --var4) {
         for (var5 = this.field326 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[7][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var3 = 0;

      for (var4 = 0; var4 < this.field326; ++var4) {
         for (var5 = this.field326 - 1; var5 >= 0; --var5) {
            if (var5 >= var4 - this.field326 / 2) {
               var1[var3] = -1;
            }

            ++var3;
         }
      }

      this.field329[7][3] = var1;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1557475479"
   )
   @Export("drawEntities")
   static final void drawEntities(int var0, int var1, int var2, int var3) {
      ++Client.viewportDrawCount;
      class229.method4514();
      WorldMapDecoration.addLocalPlayerToScene();
      TriBool.addTargetPlayerToScene();
      BufferedSource.method3423(true);
      int var4 = Players.Players_count;
      int[] var5 = Players.Players_indices;

      int var6;
      for (var6 = 0; var6 < var4; ++var6) {
         if (var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
            WorldMapCacheName.addPlayerToScene(Client.players[var5[var6]], true);
         }
      }

      BufferedSource.method3423(false);

      for (Projectile var7 = (Projectile)Client.projectiles.last(); var7 != null; var7 = (Projectile)Client.projectiles.previous()) {
         if (var7.plane == SoundSystem.plane && Client.cycle <= var7.cycleEnd) {
            if (Client.cycle >= var7.cycleStart) {
               if (var7.targetIndex > 0) {
                  NPC var8 = Client.npcs[var7.targetIndex - 1];
                  if (var8 != null && var8.x >= 0 && var8.x < 13312 && var8.y >= 0 && var8.y < 13312) {
                     var7.setDestination(var8.x, var8.y, class32.getTileHeight(var8.x, var8.y, var7.plane) - var7.endHeight, Client.cycle);
                  }
               }

               if (var7.targetIndex < 0) {
                  var6 = -var7.targetIndex - 1;
                  Player var23;
                  if (var6 == Client.localPlayerIndex) {
                     var23 = Canvas.localPlayer;
                  } else {
                     var23 = Client.players[var6];
                  }

                  if (var23 != null && var23.x >= 0 && var23.x < 13312 && var23.y >= 0 && var23.y < 13312) {
                     var7.setDestination(var23.x, var23.y, class32.getTileHeight(var23.x, var23.y, var7.plane) - var7.endHeight, Client.cycle);
                  }
               }

               var7.advance(Client.field183);
               class65.scene.method285(SoundSystem.plane, (int)var7.x, (int)var7.y, (int)var7.z, 60, var7, var7.yaw, -1L, false);
            }
         } else {
            var7.remove();
         }
      }

      for (GraphicsObject var21 = (GraphicsObject)Client.graphicsObjects.last(); var21 != null; var21 = (GraphicsObject)Client.graphicsObjects.previous()) {
         if (var21.plane == SoundSystem.plane && !var21.isFinished) {
            if (Client.cycle >= var21.cycleStart) {
               var21.advance(Client.field183);
               if (var21.isFinished) {
                  var21.remove();
               } else {
                  class65.scene.method285(var21.plane, var21.x, var21.y, var21.height, 60, var21, 0, -1L, false);
               }
            }
         } else {
            var21.remove();
         }
      }

      FontName.setViewportShape(var0, var1, var2, var3, true);
      var0 = Client.viewportOffsetX;
      var1 = Client.viewportOffsetY;
      var2 = Client.viewportWidth;
      var3 = Client.viewportHeight;
      Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
      Rasterizer3D.Rasterizer3D_method1();
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var22;
      int var24;
      if (!Client.isCameraLocked) {
         var4 = Client.cameraPitchTarget;
         if (Client.field202 / 256 > var4) {
            var4 = Client.field202 / 256;
         }

         if (Client.field139[4] && Client.field142[4] + 128 > var4) {
            var4 = Client.field142[4] + 128;
         }

         var15 = Client.minimapOrientation & 2047;
         var6 = MouseHandler.oculusOrbFocalPointX;
         var22 = MouseRecorder.field566;
         var24 = ScriptEvent.oculusOrbFocalPointY;
         var9 = var4 * 3 + 600;
         var10 = ScriptEvent.method1176(var9, var3);
         var11 = 2048 - var4 & 2047;
         var12 = 2048 - var15 & 2047;
         var13 = 0;
         var14 = 0;
         int var16 = var10;
         int var17;
         int var18;
         int var19;
         if (var11 != 0) {
            var17 = Rasterizer3D.Rasterizer3D_sine[var11];
            var18 = Rasterizer3D.Rasterizer3D_cosine[var11];
            var19 = var14 * var18 - var17 * var10 >> 16;
            var16 = var18 * var10 + var17 * var14 >> 16;
            var14 = var19;
         }

         if (var12 != 0) {
            var17 = Rasterizer3D.Rasterizer3D_sine[var12];
            var18 = Rasterizer3D.Rasterizer3D_cosine[var12];
            var19 = var16 * var17 + var18 * var13 >> 16;
            var16 = var16 * var18 - var17 * var13 >> 16;
            var13 = var19;
         }

         WorldMapSection1.cameraX = var6 - var13;
         GrandExchangeEvents.cameraY = var22 - var14;
         class11.cameraZ = var24 - var16;
         WorldMapIcon1.cameraPitch = var4;
         MusicPatchNode.cameraYaw = var15;
         if (Client.oculusOrbState == 1 && Client.rights >= 2 && Client.cycle % 50 == 0 && (MouseHandler.oculusOrbFocalPointX >> 7 != Canvas.localPlayer.x >> 7 || ScriptEvent.oculusOrbFocalPointY >> 7 != Canvas.localPlayer.y >> 7)) {
            var17 = Canvas.localPlayer.plane;
            var18 = (MouseHandler.oculusOrbFocalPointX >> 7) + class50.baseX;
            var19 = (ScriptEvent.oculusOrbFocalPointY >> 7) + GraphicsObject.baseY;
            PacketBufferNode var20 = Interpreter.method1915(ClientPacket.field283, Client.packetWriter.isaacCipher);
            var20.packetBuffer.writeIntME(Client.field198);
            var20.packetBuffer.writeShortLE(var19);
            var20.packetBuffer.method56(var17);
            var20.packetBuffer.writeShort(var18);
            Client.packetWriter.method241(var20);
         }
      }

      if (!Client.isCameraLocked) {
         var4 = UnitPriceComparator.method131();
      } else {
         var4 = Login.method2061();
      }

      var15 = WorldMapSection1.cameraX;
      var6 = GrandExchangeEvents.cameraY;
      var22 = class11.cameraZ;
      var24 = WorldMapIcon1.cameraPitch;
      var9 = MusicPatchNode.cameraYaw;

      for (var10 = 0; var10 < 5; ++var10) {
         if (Client.field139[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field141[var10] * 2 + 1) - (double)Client.field141[var10] + Math.sin((double)Client.field144[var10] * ((double)Client.field143[var10] / 100.0D)) * (double)Client.field142[var10]);
            if (var10 == 0) {
               WorldMapSection1.cameraX += var11;
            }

            if (var10 == 1) {
               GrandExchangeEvents.cameraY += var11;
            }

            if (var10 == 2) {
               class11.cameraZ += var11;
            }

            if (var10 == 3) {
               MusicPatchNode.cameraYaw = var11 + MusicPatchNode.cameraYaw & 2047;
            }

            if (var10 == 4) {
               WorldMapIcon1.cameraPitch += var11;
               if (WorldMapIcon1.cameraPitch < 128) {
                  WorldMapIcon1.cameraPitch = 128;
               }

               if (WorldMapIcon1.cameraPitch > 383) {
                  WorldMapIcon1.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseHandler.MouseHandler_x;
      var11 = MouseHandler.MouseHandler_y;
      if (MouseHandler.MouseHandler_lastButton != 0) {
         var10 = MouseHandler.MouseHandler_lastPressedX;
         var11 = MouseHandler.MouseHandler_lastPressedY;
      }

      if (var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         var12 = var10 - var0;
         var13 = var11 - var1;
         ViewportMouse.ViewportMouse_x = var12;
         ViewportMouse.ViewportMouse_y = var13;
         ViewportMouse.ViewportMouse_isInViewport = true;
         ViewportMouse.ViewportMouse_entityCount = 0;
         ViewportMouse.ViewportMouse_false0 = false;
      } else {
         ViewportMouse.ViewportMouse_isInViewport = false;
         ViewportMouse.ViewportMouse_entityCount = 0;
      }

      class13.playPcmPlayers();
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
      class13.playPcmPlayers();
      var12 = Rasterizer3D.Rasterizer3D_zoom;
      Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
      class65.scene.draw(WorldMapSection1.cameraX, GrandExchangeEvents.cameraY, class11.cameraZ, WorldMapIcon1.cameraPitch, MusicPatchNode.cameraYaw, var4);
      Rasterizer3D.Rasterizer3D_zoom = var12;
      class13.playPcmPlayers();
      class65.scene.clearTempGameObjects();
      UrlRequester.method3258(var0, var1, var2, var3);
      UnitPriceComparator.method136(var0, var1);
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field183);
      Client.field208 = 0;
      var13 = (Canvas.localPlayer.x >> 7) + class50.baseX;
      var14 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
      if (var13 >= 3053 && var13 <= 3156 && var14 >= 3056 && var14 <= 3136) {
         Client.field208 = 1;
      }

      if (var13 >= 3072 && var13 <= 3118 && var14 >= 9492 && var14 <= 9535) {
         Client.field208 = 1;
      }

      if (Client.field208 == 1 && var13 >= 3139 && var13 <= 3199 && var14 >= 3008 && var14 <= 3062) {
         Client.field208 = 0;
      }

      WorldMapSection1.cameraX = var15;
      GrandExchangeEvents.cameraY = var6;
      class11.cameraZ = var22;
      WorldMapIcon1.cameraPitch = var24;
      MusicPatchNode.cameraYaw = var9;
      if (Client.isLoading) {
         byte var25 = 0;
         var14 = var25 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
         if (var14 == 0) {
            Client.isLoading = false;
         }
      }

      if (Client.isLoading) {
         Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
         PendingSpawn.drawLoadingMessage("Loading - please wait.", false);
      }

   }
}

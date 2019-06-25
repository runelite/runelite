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
      if(var7 != 0 && this.field326 != 0 && this.field329 != null) {
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
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
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
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1551779144"
   )
   void method763() {
      if(this.field329 == null) {
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
      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[0][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3) {
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
      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[1][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
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

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[1][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
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
      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[2][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
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
      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[3][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
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
      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field329[4][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var2 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
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
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[5][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var3 <= this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[5][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[5][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var3 >= this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
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
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[6][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 <= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[6][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[6][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
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
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[7][0] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field326; ++var4) {
            if(var4 >= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[7][1] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = this.field326 - 1; var3 >= 0; --var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field329[7][2] = var1;
      var1 = new byte[this.field326 * this.field326];
      var5 = 0;

      for(var3 = 0; var3 < this.field326; ++var3) {
         for(var4 = this.field326 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field326 / 2) {
               var1[var5] = -1;
            }

            ++var5;
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
      class25.method349();
      TriBool.method5560();
      BufferedSource.method3423(true);
      int var4 = Players.Players_count;
      int[] var5 = Players.Players_indices;

      int var6;
      for(var6 = 0; var6 < var4; ++var6) {
         if(var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
            WorldMapCacheName.addPlayerToScene(Client.players[var5[var6]], true);
         }
      }

      BufferedSource.method3423(false);

      for(Projectile var20 = (Projectile)Client.projectiles.last(); var20 != null; var20 = (Projectile)Client.projectiles.previous()) {
         if(var20.plane == SoundSystem.plane && Client.cycle <= var20.cycleEnd) {
            if(Client.cycle >= var20.cycleStart) {
               if(var20.targetIndex > 0) {
                  Npc var22 = Client.npcs[var20.targetIndex - 1];
                  if(var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
                     var20.setDestination(var22.x, var22.y, class32.getTileHeight(var22.x, var22.y, var20.plane) - var20.endHeight, Client.cycle);
                  }
               }

               if(var20.targetIndex < 0) {
                  var6 = -var20.targetIndex - 1;
                  Player var23;
                  if(var6 == Client.localPlayerIndex) {
                     var23 = Canvas.localPlayer;
                  } else {
                     var23 = Client.players[var6];
                  }

                  if(var23 != null && var23.x >= 0 && var23.x < 13312 && var23.y >= 0 && var23.y < 13312) {
                     var20.setDestination(var23.x, var23.y, class32.getTileHeight(var23.x, var23.y, var20.plane) - var20.endHeight, Client.cycle);
                  }
               }

               var20.advance(Client.__client_gy);
               class65.scene.__a_239(SoundSystem.plane, (int)var20.x, (int)var20.y, (int)var20.z, 60, var20, var20.yaw, -1L, false);
            }
         } else {
            var20.remove();
         }
      }

      for(GraphicsObject var25 = (GraphicsObject)Client.graphicsObjects.last(); var25 != null; var25 = (GraphicsObject)Client.graphicsObjects.previous()) {
         if(var25.plane == SoundSystem.plane && !var25.isFinished) {
            if(Client.cycle >= var25.cycleStart) {
               var25.advance(Client.__client_gy);
               if(var25.isFinished) {
                  var25.remove();
               } else {
                  class65.scene.__a_239(var25.plane, var25.x, var25.y, var25.height, 60, var25, 0, -1L, false);
               }
            }
         } else {
            var25.remove();
         }
      }

      FontName.setViewportShape(var0, var1, var2, var3, true);
      var0 = Client.viewportOffsetX;
      var1 = Client.viewportOffsetY;
      var2 = Client.viewportWidth;
      var3 = Client.viewportHeight;
      Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
      Rasterizer3D.Rasterizer3D_method1();
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var21;
      if(!Client.isCameraLocked) {
         var4 = Client.cameraPitchTarget;
         if(Client.__client_ik / 256 > var4) {
            var4 = Client.__client_ik / 256;
         }

         if(Client.__client_rh[4] && Client.__client_rl[4] + 128 > var4) {
            var4 = Client.__client_rl[4] + 128;
         }

         var21 = Client.minimapOrientation & 2047;
         var6 = MouseHandler.oculusOrbFocalPointX;
         var7 = MouseRecorder.__bu_hy;
         var8 = ScriptEvent.oculusOrbFocalPointY;
         var9 = var4 * 3 + 600;
         var10 = ScriptEvent.method1176(var9, var3);
         var11 = 2048 - var4 & 2047;
         var12 = 2048 - var21 & 2047;
         var13 = 0;
         var14 = 0;
         int var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = Rasterizer3D.Rasterizer3D_sine[var11];
            var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var17 * var10 + var16 * var14 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = Rasterizer3D.Rasterizer3D_sine[var12];
            var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
            var18 = var15 * var16 + var17 * var13 >> 16;
            var15 = var15 * var17 - var16 * var13 >> 16;
            var13 = var18;
         }

         WorldMapSection1.cameraX = var6 - var13;
         GrandExchangeEvents.cameraY = var7 - var14;
         class11.cameraZ = var8 - var15;
         WorldMapIcon1.cameraPitch = var4;
         MusicPatchNode.cameraYaw = var21;
         if(Client.oculusOrbState == 1 && Client.rights >= 2 && Client.cycle % 50 == 0 && (MouseHandler.oculusOrbFocalPointX >> 7 != Canvas.localPlayer.x >> 7 || ScriptEvent.oculusOrbFocalPointY >> 7 != Canvas.localPlayer.y >> 7)) {
            var16 = Canvas.localPlayer.plane;
            var17 = (MouseHandler.oculusOrbFocalPointX >> 7) + class50.baseX;
            var18 = (ScriptEvent.oculusOrbFocalPointY >> 7) + GraphicsObject.baseY;
            PacketBufferNode var19 = Interpreter.method1915(ClientPacket.__gs_bx, Client.packetWriter.isaacCipher);
            var19.packetBuffer.writeIntME(Client.__client_il);
            var19.packetBuffer.writeShortLE(var18);
            var19.packetBuffer.__ai_315(var16);
            var19.packetBuffer.writeShort(var17);
            Client.packetWriter.__q_167(var19);
         }
      }

      if(!Client.isCameraLocked) {
         var4 = UnitPriceComparator.method131();
      } else {
         var4 = Login.method2061();
      }

      var21 = WorldMapSection1.cameraX;
      var6 = GrandExchangeEvents.cameraY;
      var7 = class11.cameraZ;
      var8 = WorldMapIcon1.cameraPitch;
      var9 = MusicPatchNode.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.__client_rh[var10]) {
            var11 = (int)(Math.random() * (double)(Client.__client_rd[var10] * 2 + 1) - (double)Client.__client_rd[var10] + Math.sin((double)Client.__client_rk[var10] * ((double)Client.__client_rj[var10] / 100.0D)) * (double)Client.__client_rl[var10]);
            if(var10 == 0) {
               WorldMapSection1.cameraX += var11;
            }

            if(var10 == 1) {
               GrandExchangeEvents.cameraY += var11;
            }

            if(var10 == 2) {
               class11.cameraZ += var11;
            }

            if(var10 == 3) {
               MusicPatchNode.cameraYaw = var11 + MusicPatchNode.cameraYaw & 2047;
            }

            if(var10 == 4) {
               WorldMapIcon1.cameraPitch += var11;
               if(WorldMapIcon1.cameraPitch < 128) {
                  WorldMapIcon1.cameraPitch = 128;
               }

               if(WorldMapIcon1.cameraPitch > 383) {
                  WorldMapIcon1.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseHandler.MouseHandler_x;
      var11 = MouseHandler.MouseHandler_y;
      if(MouseHandler.MouseHandler_lastButton != 0) {
         var10 = MouseHandler.MouseHandler_lastPressedX;
         var11 = MouseHandler.MouseHandler_lastPressedY;
      }

      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
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
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.__client_gy);
      Client.__client_jc = 0;
      var13 = (Canvas.localPlayer.x >> 7) + class50.baseX;
      var14 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
      if(var13 >= 3053 && var13 <= 3156 && var14 >= 3056 && var14 <= 3136) {
         Client.__client_jc = 1;
      }

      if(var13 >= 3072 && var13 <= 3118 && var14 >= 9492 && var14 <= 9535) {
         Client.__client_jc = 1;
      }

      if(Client.__client_jc == 1 && var13 >= 3139 && var13 <= 3199 && var14 >= 3008 && var14 <= 3062) {
         Client.__client_jc = 0;
      }

      WorldMapSection1.cameraX = var21;
      GrandExchangeEvents.cameraY = var6;
      class11.cameraZ = var7;
      WorldMapIcon1.cameraPitch = var8;
      MusicPatchNode.cameraYaw = var9;
      if(Client.isLoading) {
         byte var24 = 0;
         var14 = var24 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
         if(var14 == 0) {
            Client.isLoading = false;
         }
      }

      if(Client.isLoading) {
         Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
         class68.drawLoadingMessage("Loading - please wait.", false);
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3390;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3383;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1871593107
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -687633361
   )
   int field3382;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -409672179
   )
   public int field3386;
   @ObfuscatedName("l")
   short[] field3379;
   @ObfuscatedName("b")
   short[] field3385;
   @ObfuscatedName("n")
   short[] field3380;
   @ObfuscatedName("c")
   short[] field3387;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 207659473
   )
   int field3388;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 949373077
   )
   int field3389;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1219360481
   )
   int field3381;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1793764679
   )
   int field3391;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -464288853
   )
   int field3392;

   static {
      spotanims = new NodeCache(64);
      field3383 = new NodeCache(30);
   }

   Spotanim() {
      this.field3386 = -1;
      this.field3388 = 128;
      this.field3389 = 128;
      this.field3381 = 0;
      this.field3391 = 0;
      this.field3392 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "65536"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4519(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "1801726183"
   )
   void method4519(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3382 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3386 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3388 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3389 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3381 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3391 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3392 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3379 = new short[var3];
            this.field3385 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3379[var4] = (short)var1.readUnsignedShort();
               this.field3385[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3380 = new short[var3];
            this.field3387 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3380[var4] = (short)var1.readUnsignedShort();
               this.field3387[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Len;",
      garbageValue = "1023010549"
   )
   public final Model method4520(int var1) {
      Model var2 = (Model)field3383.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2533(field3390, this.field3382, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3379 != null) {
            for(var4 = 0; var4 < this.field3379.length; ++var4) {
               var3.recolor(this.field3379[var4], this.field3385[var4]);
            }
         }

         if(this.field3380 != null) {
            for(var4 = 0; var4 < this.field3380.length; ++var4) {
               var3.method2536(this.field3380[var4], this.field3387[var4]);
            }
         }

         var2 = var3.light(this.field3391 + 64, this.field3392 + 850, -30, -50, -30);
         field3383.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3386 != -1 && var1 != -1) {
         var5 = ItemLayer.getAnimation(this.field3386).method4879(var2, var1);
      } else {
         var5 = var2.method2613(true);
      }

      if(this.field3388 != 128 || this.field3389 != 128) {
         var5.method2628(this.field3388, this.field3389, this.field3388);
      }

      if(this.field3381 != 0) {
         if(this.field3381 == 90) {
            var5.method2677();
         }

         if(this.field3381 == 180) {
            var5.method2677();
            var5.method2677();
         }

         if(this.field3381 == 270) {
            var5.method2677();
            var5.method2677();
            var5.method2677();
         }
      }

      return var5;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-87"
   )
   static final void method4527(int var0, int var1, int var2, int var3) {
      ++Client.field953;
      if(class48.localPlayer.x >> 7 == Client.destinationX && class48.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      class171.method3210(class48.localPlayer, false);
      if(Client.field978 >= 0 && Client.cachedPlayers[Client.field978] != null) {
         class171.method3210(Client.cachedPlayers[Client.field978], false);
      }

      class44.method685(true);
      WorldMapType3.method220();
      class44.method685(false);
      CombatInfoListHolder.method1760();
      MouseInput.method1067();
      class175.method3246(var0, var1, var2, var3, true);
      var0 = Client.field1111;
      var1 = Client.field1109;
      var2 = Client.viewportHeight;
      var3 = Client.viewportWidth;
      Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
      Graphics3D.method2707();
      int var4;
      int var5;
      if(!Client.field1097) {
         var4 = Client.field932;
         if(Client.field1102 / 256 > var4) {
            var4 = Client.field1102 / 256;
         }

         if(Client.field1098[4] && Client.field1071[4] + 128 > var4) {
            var4 = Client.field1071[4] + 128;
         }

         var5 = Client.mapAngle & 2047;
         class14.method94(WorldMapType3.field375, class70.getTileHeight(class48.localPlayer.x, class48.localPlayer.y, Ignore.plane) - Client.field950, class34.field465, var4, var5, var4 * 3 + 600);
      }

      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      if(!Client.field1097) {
         if(Buffer.preferences.hideRoofs) {
            var5 = Ignore.plane;
         } else {
            label498: {
               var6 = 3;
               if(class28.cameraPitch < 310) {
                  var7 = class29.cameraX >> 7;
                  var8 = Player.cameraY >> 7;
                  var9 = class48.localPlayer.x >> 7;
                  var10 = class48.localPlayer.y >> 7;
                  if(var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
                     var5 = Ignore.plane;
                     break label498;
                  }

                  if((class61.tileSettings[Ignore.plane][var7][var8] & 4) != 0) {
                     var6 = Ignore.plane;
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

                  if(var11 > var12) {
                     var13 = var12 * 65536 / var11;
                     var14 = 32768;

                     while(var9 != var7) {
                        if(var7 < var9) {
                           ++var7;
                        } else if(var7 > var9) {
                           --var7;
                        }

                        if((class61.tileSettings[Ignore.plane][var7][var8] & 4) != 0) {
                           var6 = Ignore.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class61.tileSettings[Ignore.plane][var7][var8] & 4) != 0) {
                              var6 = Ignore.plane;
                           }
                        }
                     }
                  } else {
                     var13 = var11 * 65536 / var12;
                     var14 = 32768;

                     while(var10 != var8) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class61.tileSettings[Ignore.plane][var7][var8] & 4) != 0) {
                           var6 = Ignore.plane;
                        }

                        var14 += var13;
                        if(var14 >= 65536) {
                           var14 -= 65536;
                           if(var7 < var9) {
                              ++var7;
                           } else if(var7 > var9) {
                              --var7;
                           }

                           if((class61.tileSettings[Ignore.plane][var7][var8] & 4) != 0) {
                              var6 = Ignore.plane;
                           }
                        }
                     }
                  }
               }

               if(class48.localPlayer.x >= 0 && class48.localPlayer.y >= 0 && class48.localPlayer.x < 13312 && class48.localPlayer.y < 13312) {
                  if((class61.tileSettings[Ignore.plane][class48.localPlayer.x >> 7][class48.localPlayer.y >> 7] & 4) != 0) {
                     var6 = Ignore.plane;
                  }

                  var5 = var6;
               } else {
                  var5 = Ignore.plane;
               }
            }
         }

         var4 = var5;
      } else {
         var4 = FileRequest.method4275();
      }

      var5 = class29.cameraX;
      var6 = class70.cameraZ;
      var7 = Player.cameraY;
      var8 = class28.cameraPitch;
      var9 = class228.cameraYaw;

      for(var10 = 0; var10 < 5; ++var10) {
         if(Client.field1098[var10]) {
            var11 = (int)(Math.random() * (double)(Client.field949[var10] * 2 + 1) - (double)Client.field949[var10] + Math.sin((double)Client.field1101[var10] / 100.0D * (double)Client.field946[var10]) * (double)Client.field1071[var10]);
            if(var10 == 0) {
               class29.cameraX += var11;
            }

            if(var10 == 1) {
               class70.cameraZ += var11;
            }

            if(var10 == 2) {
               Player.cameraY += var11;
            }

            if(var10 == 3) {
               class228.cameraYaw = var11 + class228.cameraYaw & 2047;
            }

            if(var10 == 4) {
               class28.cameraPitch += var11;
               if(class28.cameraPitch < 128) {
                  class28.cameraPitch = 128;
               }

               if(class28.cameraPitch > 383) {
                  class28.cameraPitch = 383;
               }
            }
         }
      }

      var10 = MouseInput.field704;
      var11 = MouseInput.field708;
      if(MouseInput.field713 != 0) {
         var10 = MouseInput.field714;
         var11 = MouseInput.field715;
      }

      if(var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
         var12 = var10 - var0;
         var13 = var11 - var1;
         class133.field1914 = var12;
         class133.field1912 = var13;
         class133.field1917 = true;
         class133.field1921 = 0;
         class133.field1915 = false;
      } else {
         class171.method3203();
      }

      class90.method1801();
      Rasterizer2D.method5151(var0, var1, var2, var3, 0);
      class90.method1801();
      var12 = Graphics3D.field1940;
      Graphics3D.field1940 = Client.scale;
      class56.region.draw(class29.cameraX, class70.cameraZ, Player.cameraY, class28.cameraPitch, class228.cameraYaw, var4);
      class15.method110();
      Graphics3D.field1940 = var12;
      class90.method1801();
      class56.region.clearEntities();
      Client.field942 = 0;
      boolean var29 = false;
      var14 = -1;
      int var15 = class94.playerIndexesCount;
      int[] var16 = class94.playerIndices;

      int var17;
      for(var17 = 0; var17 < var15 + Client.npcIndexesCount; ++var17) {
         Object var18;
         if(var17 < var15) {
            var18 = Client.cachedPlayers[var16[var17]];
            if(var16[var17] == Client.field978) {
               var29 = true;
               var14 = var17;
               continue;
            }
         } else {
            var18 = Client.cachedNPCs[Client.npcIndices[var17 - var15]];
         }

         class11.method61((Actor)var18, var17, var0, var1, var2, var3);
      }

      if(var29) {
         class11.method61(Client.cachedPlayers[Client.field978], var14, var0, var1, var2, var3);
      }

      for(var17 = 0; var17 < Client.field942; ++var17) {
         int var27 = Client.field1130[var17];
         int var19 = Client.field945[var17];
         int var20 = Client.field947[var17];
         int var21 = Client.field944[var17];
         boolean var22 = true;

         while(var22) {
            var22 = false;

            for(int var23 = 0; var23 < var17; ++var23) {
               if(var19 + 2 > Client.field945[var23] - Client.field944[var23] && var19 - var21 < Client.field945[var23] + 2 && var27 - var20 < Client.field947[var23] + Client.field1130[var23] && var20 + var27 > Client.field1130[var23] - Client.field947[var23] && Client.field945[var23] - Client.field944[var23] < var19) {
                  var19 = Client.field945[var23] - Client.field944[var23];
                  var22 = true;
               }
            }
         }

         Client.screenY = Client.field1130[var17];
         Client.screenX = Client.field945[var17] = var19;
         String var28 = Client.field951[var17];
         if(Client.field1011 == 0) {
            int var24 = 16776960;
            if(Client.field948[var17] < 6) {
               var24 = Client.field1038[Client.field948[var17]];
            }

            if(Client.field948[var17] == 6) {
               var24 = Client.field953 % 20 < 10?16711680:16776960;
            }

            if(Client.field948[var17] == 7) {
               var24 = Client.field953 % 20 < 10?255:'\uffff';
            }

            if(Client.field948[var17] == 8) {
               var24 = Client.field953 % 20 < 10?'뀀':8454016;
            }

            int var25;
            if(Client.field948[var17] == 9) {
               var25 = 150 - Client.field1065[var17];
               if(var25 < 50) {
                  var24 = var25 * 1280 + 16711680;
               } else if(var25 < 100) {
                  var24 = 16776960 - (var25 - 50) * 327680;
               } else if(var25 < 150) {
                  var24 = (var25 - 100) * 5 + 65280;
               }
            }

            if(Client.field948[var17] == 10) {
               var25 = 150 - Client.field1065[var17];
               if(var25 < 50) {
                  var24 = var25 * 5 + 16711680;
               } else if(var25 < 100) {
                  var24 = 16711935 - (var25 - 50) * 327680;
               } else if(var25 < 150) {
                  var24 = (var25 - 100) * 327680 + 255 - (var25 - 100) * 5;
               }
            }

            if(Client.field948[var17] == 11) {
               var25 = 150 - Client.field1065[var17];
               if(var25 < 50) {
                  var24 = 16777215 - var25 * 327685;
               } else if(var25 < 100) {
                  var24 = (var25 - 50) * 327685 + 65280;
               } else if(var25 < 150) {
                  var24 = 16777215 - (var25 - 100) * 327680;
               }
            }

            if(Client.field1099[var17] == 0) {
               class20.field320.method4934(var28, var0 + Client.screenY, Client.screenX + var1, var24, 0);
            }

            if(Client.field1099[var17] == 1) {
               class20.field320.method4936(var28, var0 + Client.screenY, Client.screenX + var1, var24, 0, Client.field953);
            }

            if(Client.field1099[var17] == 2) {
               class20.field320.method4937(var28, var0 + Client.screenY, Client.screenX + var1, var24, 0, Client.field953);
            }

            if(Client.field1099[var17] == 3) {
               class20.field320.method4923(var28, var0 + Client.screenY, Client.screenX + var1, var24, 0, Client.field953, 150 - Client.field1065[var17]);
            }

            if(Client.field1099[var17] == 4) {
               var25 = (150 - Client.field1065[var17]) * (class20.field320.method4926(var28) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenY - 50, var1, var0 + Client.screenY + 50, var3 + var1);
               class20.field320.method4931(var28, var0 + Client.screenY + 50 - var25, Client.screenX + var1, var24, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field1099[var17] == 5) {
               var25 = 150 - Client.field1065[var17];
               int var26 = 0;
               if(var25 < 25) {
                  var26 = var25 - 25;
               } else if(var25 > 125) {
                  var26 = var25 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenX + var1 - class20.field320.verticalSpace - 1, var0 + var2, Client.screenX + var1 + 5);
               class20.field320.method4934(var28, var0 + Client.screenY, var26 + Client.screenX + var1, var24, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class20.field320.method4934(var28, var0 + Client.screenY, Client.screenX + var1, 16776960, 0);
         }
      }

      if(Client.hintArrowTargetType == 2) {
         class3.method6((Client.hintArrowX - ItemLayer.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - ItemLayer.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class229.headIconsHint[0].drawAt(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }
      }

      ((TextureProvider)Graphics3D.textureLoader).method2501(Client.field925);
      if(Client.cursorState == 1) {
         CombatInfoListHolder.field1287[Client.field937 / 100].drawAt(Client.field956 - 8, Client.field957 - 8);
      }

      if(Client.cursorState == 2) {
         CombatInfoListHolder.field1287[Client.field937 / 100 + 4].drawAt(Client.field956 - 8, Client.field957 - 8);
      }

      WorldMapData.method330();
      class29.cameraX = var5;
      class70.cameraZ = var6;
      Player.cameraY = var7;
      class28.cameraPitch = var8;
      class228.cameraYaw = var9;
      if(Client.field877 && class239.method4274(true, false) == 0) {
         Client.field877 = false;
      }

      if(Client.field877) {
         Rasterizer2D.method5151(var0, var1, var2, var3, 0);
         class66.drawStatusBox("Loading - please wait.", false);
      }

   }
}

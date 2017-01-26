import java.awt.Component;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("bb")
   static class184 field1189;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 5287257490423751219L
   )
   @Export("position")
   long position;
   @ObfuscatedName("e")
   static int[] field1191;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 1794825227997244551L
   )
   @Export("length")
   long length;
   @ObfuscatedName("p")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1312355429"
   )
   public final void method1402(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1873456927"
   )
   public final void method1403() throws IOException {
      if(null != this.file) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("p")
   final void method1404(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "6"
   )
   public final int method1405(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method1403();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass178;",
      garbageValue = "-1917846652"
   )
   public static class178[] method1406() {
      return new class178[]{class178.field2672, class178.field2673, class178.field2679, class178.field2676};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1249322080"
   )
   static boolean method1407(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "161176968"
   )
   public final long method1418() throws IOException {
      return this.file.length();
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;B)Z",
      garbageValue = "104"
   )
   public static final boolean method1425(int var0, int var1, int var2, class119 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class118.field1847[var7][var8] = 99;
      class118.field1848[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class118.field1849[var11] = var0;
      int var20 = var11 + 1;
      class118.field1850[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label349:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label326:
                     do {
                        if(var20 == var12) {
                           class149.field2039 = var5;
                           class20.field208 = var6;
                           return false;
                        }

                        var5 = class118.field1849[var12];
                        var6 = class118.field1850[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2300(var2, var5, var6, var4)) {
                           class149.field2039 = var5;
                           class20.field208 = var6;
                           return true;
                        }

                        var16 = 1 + class118.field1848[var18][var19];
                        if(var18 > 0 && class118.field1847[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1849[var20] = var5 - 1;
                                 class118.field1850[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1847[var18 - 1][var19] = 2;
                                 class118.field1848[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class118.field1847[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var2 + var14][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1849[var20] = var5 + 1;
                                 class118.field1850[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1847[var18 + 1][var19] = 8;
                                 class118.field1848[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class118.field1847[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var2 + var14 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1849[var20] = var5;
                                 class118.field1850[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1847[var18][var19 - 1] = 1;
                                 class118.field1848[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class118.field1847[var18][1 + var19] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1849[var20] = var5;
                                 class118.field1850[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1847[var18][var19 + 1] = 4;
                                 class118.field1848[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class118.field1847[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class118.field1849[var20] = var5 - 1;
                                 class118.field1850[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1847[var18 - 1][var19 - 1] = 3;
                                 class118.field1848[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class118.field1847[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class118.field1849[var20] = 1 + var5;
                                 class118.field1850[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1847[var18 + 1][var19 - 1] = 9;
                                 class118.field1848[1 + var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 - 1 + var17] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class118.field1847[var18 - 1][1 + var19] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var14 - 1 + var17][var2 + var15] & 19137016) != 0) {
                                 continue label326;
                              }
                           }

                           class118.field1849[var20] = var5 - 1;
                           class118.field1850[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class118.field1847[var18 - 1][var19 + 1] = 6;
                           class118.field1848[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class118.field1847[var18 + 1][1 + var19] != 0);
            } while((var13[var2 + var14][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label349;
               }
            }

            class118.field1849[var20] = 1 + var5;
            class118.field1850[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class118.field1847[var18 + 1][1 + var19] = 12;
            class118.field1848[var18 + 1][1 + var19] = var16;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "59"
   )
   static final void method1426(int var0, int var1, int var2, int var3) {
      ++Client.field524;
      CombatInfo2.method3526(class15.field153);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field336 >= 0) {
         var5 = class45.field898;
         int[] var6 = class45.field895;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field336 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         CombatInfo2.method3526(class15.field157);
      }

      class5.method80(true);
      CombatInfo2.method3526(var4?class15.field156:class15.field155);
      class5.method80(false);
      class172.method3240();
      class25.method573();
      class37.method735(var0, var1, var2, var3, true);
      var0 = Client.field539;
      var1 = Client.field540;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method4008(var0, var1, var2 + var0, var3 + var1);
      class84.method1678();
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      int var18;
      int var28;
      if(!Client.field525) {
         var5 = Client.field383;
         if(Client.field519 / 256 > var5) {
            var5 = Client.field519 / 256;
         }

         if(Client.field443[4] && 128 + Client.field528[4] > var5) {
            var5 = Client.field528[4] + 128;
         }

         var28 = Client.mapAngle + Client.field346 & 2047;
         var7 = class44.field891;
         var8 = class65.method1153(class16.localPlayer.x, class16.localPlayer.y, WallObject.plane) - Client.field298;
         var9 = class13.field122;
         var10 = var5 * 3 + 600;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var28 & 2047;
         var13 = 0;
         int var14 = 0;
         var15 = var10;
         int var17;
         if(var11 != 0) {
            var16 = class84.field1438[var11];
            var17 = class84.field1452[var11];
            var18 = var14 * var17 - var16 * var10 >> 16;
            var15 = var10 * var17 + var14 * var16 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class84.field1438[var12];
            var17 = class84.field1452[var12];
            var18 = var17 * var13 + var16 * var15 >> 16;
            var15 = var17 * var15 - var13 * var16 >> 16;
            var13 = var18;
         }

         GameEngine.cameraX = var7 - var13;
         class40.cameraZ = var8 - var14;
         class149.cameraY = var9 - var15;
         class13.cameraPitch = var5;
         World.cameraYaw = var28;
      }

      if(!Client.field525) {
         var5 = class230.method4276();
      } else {
         var5 = class22.method215();
      }

      var28 = GameEngine.cameraX;
      var7 = class40.cameraZ;
      var8 = class149.cameraY;
      var9 = class13.cameraPitch;
      var10 = World.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field443[var11]) {
            var12 = (int)(Math.random() * (double)(1 + 2 * Client.field527[var11]) - (double)Client.field527[var11] + Math.sin((double)Client.field530[var11] * ((double)Client.field529[var11] / 100.0D)) * (double)Client.field528[var11]);
            if(var11 == 0) {
               GameEngine.cameraX += var12;
            }

            if(var11 == 1) {
               class40.cameraZ += var12;
            }

            if(var11 == 2) {
               class149.cameraY += var12;
            }

            if(var11 == 3) {
               World.cameraYaw = World.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class13.cameraPitch += var12;
               if(class13.cameraPitch < 128) {
                  class13.cameraPitch = 128;
               }

               if(class13.cameraPitch > 383) {
                  class13.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1805;
      var12 = class115.field1814;
      if(class115.field1813 != 0) {
         var11 = class115.field1811;
         var12 = class115.field1812;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1409 = true;
         Model.field1412 = 0;
         Model.field1410 = var11 - var0;
         Model.field1363 = var12 - var1;
      } else {
         Model.field1409 = false;
         Model.field1412 = 0;
      }

      class85.method1692();
      Rasterizer2D.method4020(var0, var1, var2, var3, 0);
      class85.method1692();
      var13 = class84.field1437;
      class84.field1437 = Client.scale;
      Renderable.region.method1791(GameEngine.cameraX, class40.cameraZ, class149.cameraY, class13.cameraPitch, World.cameraYaw, var5);
      class84.field1437 = var13;
      class85.method1692();
      Renderable.region.method1879();
      Client.field372 = 0;
      boolean var32 = false;
      var15 = -1;
      var16 = class45.field898;
      int[] var31 = class45.field895;

      for(var18 = 0; var18 < Client.field316 + var16; ++var18) {
         Object var29;
         if(var18 < var16) {
            var29 = Client.cachedPlayers[var31[var18]];
            if(var31[var18] == Client.field336) {
               var32 = true;
               var15 = var18;
               continue;
            }
         } else {
            var29 = Client.cachedNPCs[Client.field419[var18 - var16]];
         }

         class0.method14((Actor)var29, var18, var0, var1, var2, var3);
      }

      if(var32) {
         class0.method14(Client.cachedPlayers[Client.field336], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field372; ++var18) {
         int var19 = Client.field491[var18];
         int var20 = Client.field401[var18];
         int var21 = Client.field377[var18];
         int var22 = Client.field376[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var24 = 0; var24 < var18; ++var24) {
               if(var20 + 2 > Client.field401[var24] - Client.field376[var24] && var20 - var22 < 2 + Client.field401[var24] && var19 - var21 < Client.field377[var24] + Client.field491[var24] && var19 + var21 > Client.field491[var24] - Client.field377[var24] && Client.field401[var24] - Client.field376[var24] < var20) {
                  var20 = Client.field401[var24] - Client.field376[var24];
                  var23 = true;
               }
            }
         }

         Client.field398 = Client.field491[var18];
         Client.field317 = Client.field401[var18] = var20;
         String var30 = Client.field381[var18];
         if(Client.field413 == 0) {
            int var25 = 16776960;
            if(Client.field278[var18] < 6) {
               var25 = Client.field494[Client.field278[var18]];
            }

            if(Client.field278[var18] == 6) {
               var25 = Client.field524 % 20 < 10?16711680:16776960;
            }

            if(Client.field278[var18] == 7) {
               var25 = Client.field524 % 20 < 10?255:'\uffff';
            }

            if(Client.field278[var18] == 8) {
               var25 = Client.field524 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field278[var18] == 9) {
               var26 = 150 - Client.field380[var18];
               if(var26 < 50) {
                  var25 = var26 * 1280 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = '\uff00' + (var26 - 100) * 5;
               }
            }

            if(Client.field278[var18] == 10) {
               var26 = 150 - Client.field380[var18];
               if(var26 < 50) {
                  var25 = 16711680 + var26 * 5;
               } else if(var26 < 100) {
                  var25 = 16711935 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 255 + 327680 * (var26 - 100) - (var26 - 100) * 5;
               }
            }

            if(Client.field278[var18] == 11) {
               var26 = 150 - Client.field380[var18];
               if(var26 < 50) {
                  var25 = 16777215 - 327685 * var26;
               } else if(var26 < 100) {
                  var25 = 327685 * (var26 - 50) + '\uff00';
               } else if(var26 < 150) {
                  var25 = 16777215 - 327680 * (var26 - 100);
               }
            }

            if(Client.field379[var18] == 0) {
               Tile.field1346.method3910(var30, Client.field398 + var0, var1 + Client.field317, var25, 0);
            }

            if(Client.field379[var18] == 1) {
               Tile.field1346.method3879(var30, var0 + Client.field398, var1 + Client.field317, var25, 0, Client.field524);
            }

            if(Client.field379[var18] == 2) {
               Tile.field1346.method3880(var30, Client.field398 + var0, Client.field317 + var1, var25, 0, Client.field524);
            }

            if(Client.field379[var18] == 3) {
               Tile.field1346.method3881(var30, Client.field398 + var0, Client.field317 + var1, var25, 0, Client.field524, 150 - Client.field380[var18]);
            }

            if(Client.field379[var18] == 4) {
               var26 = (150 - Client.field380[var18]) * (Tile.field1346.method3870(var30) + 100) / 150;
               Rasterizer2D.method3986(Client.field398 + var0 - 50, var1, 50 + var0 + Client.field398, var1 + var3);
               Tile.field1346.method3875(var30, 50 + Client.field398 + var0 - var26, Client.field317 + var1, var25, 0);
               Rasterizer2D.method4008(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field379[var18] == 5) {
               var26 = 150 - Client.field380[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               Rasterizer2D.method3986(var0, Client.field317 + var1 - Tile.field1346.field3100 - 1, var2 + var0, 5 + Client.field317 + var1);
               Tile.field1346.method3910(var30, var0 + Client.field398, var27 + Client.field317 + var1, var25, 0);
               Rasterizer2D.method4008(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            Tile.field1346.method3910(var30, Client.field398 + var0, var1 + Client.field317, 16776960, 0);
         }
      }

      if(Client.field407 == 2) {
         class162.method3081((Client.field439 - Projectile.baseX << 7) + Client.field356, (Client.field549 - class3.baseY << 7) + Client.field296, Client.field301 * 2);
         if(Client.field398 > -1 && Client.gameCycle % 20 < 10) {
            World.field678[0].method4144(var0 + Client.field398 - 12, var1 + Client.field317 - 28);
         }
      }

      ((TextureProvider)class84.field1448).method1437(Client.field354);
      if(Client.field371 == 1) {
         Player.field253[Client.field388 / 100].method4144(Client.field420 - 8, Client.field464 - 8);
      }

      if(Client.field371 == 2) {
         Player.field253[Client.field388 / 100 + 4].method4144(Client.field420 - 8, Client.field464 - 8);
      }

      class6.method91();
      GameEngine.cameraX = var28;
      class40.cameraZ = var7;
      class149.cameraY = var8;
      class13.cameraPitch = var9;
      World.cameraYaw = var10;
      if(Client.field385 && class85.method1691(true, false) == 0) {
         Client.field385 = false;
      }

      if(Client.field385) {
         Rasterizer2D.method4020(var0, var1, var2, var3, 0);
         Tile.method1549("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1449271316"
   )
   public static void method1428(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-4"
   )
   public static final boolean method1429(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}

import java.awt.Canvas;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class32 {
   @ObfuscatedName("i")
   static Calendar field711 = Calendar.getInstance();
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -667207015
   )
   static int field712 = 0;
   @ObfuscatedName("r")
   static String[] field713;
   @ObfuscatedName("o")
   static int[] field714;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -641523113
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("q")
   static int[] field716 = new int[1000];
   @ObfuscatedName("d")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("c")
   static class10[] field719 = new class10[50];
   @ObfuscatedName("j")
   static int[][] field720 = new int[5][5000];
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 152809229
   )
   static int field721;
   @ObfuscatedName("v")
   static final String[] field722 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1518969149
   )
   static int field723 = 0;
   @ObfuscatedName("qm")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("g")
   static Widget field731;
   @ObfuscatedName("w")
   static int[] field734 = new int[5];

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-101020646"
   )
   public static void method709(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   class32() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-24"
   )
   public static int method713(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   static final void method715(int var0, int var1, int var2, int var3) {
      ++Client.field451;
      class114.method2193(class15.field166);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field407 >= 0) {
         var5 = class45.field901;
         int[] var16 = class45.field902;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field407 == var16[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class114.method2193(class15.field163);
      }

      class153.method2862(true);
      class114.method2193(var4?class15.field164:class15.field161);
      class153.method2862(false);
      class0.method12();
      XGrandExchangeOffer.method48();
      class206.method3825(var0, var1, var2, var3, true);
      var0 = Client.field280;
      var1 = Client.field541;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method3973(var0, var1, var2 + var0, var3 + var1);
      class84.method1642();
      int var6;
      if(!Client.field526) {
         var5 = Client.field361;
         if(Client.field370 / 256 > var5) {
            var5 = Client.field370 / 256;
         }

         if(Client.field527[4] && Client.field529[4] + 128 > var5) {
            var5 = Client.field529[4] + 128;
         }

         var6 = Client.field346 + Client.mapAngle & 2047;
         ObjectComposition.method3609(class49.field952, Renderable.method1883(VertexNormal.localPlayer.x, VertexNormal.localPlayer.y, class48.plane) - Client.field367, class65.field1111, var5, var6, var5 * 3 + 600);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      if(!Client.field526) {
         if(class85.field1456.field685) {
            var6 = class48.plane;
         } else {
            label370: {
               var7 = 3;
               if(FloorUnderlayDefinition.cameraPitch < 310) {
                  var8 = class202.cameraX >> 7;
                  var9 = class16.cameraY >> 7;
                  var10 = VertexNormal.localPlayer.x >> 7;
                  var11 = VertexNormal.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var6 = class48.plane;
                     break label370;
                  }

                  if((class11.tileSettings[class48.plane][var8][var9] & 4) != 0) {
                     var7 = class48.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  int var14;
                  if(var12 > var13) {
                     var14 = 65536 * var13 / var12;
                     var15 = '耀';

                     while(var10 != var8) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class11.tileSettings[class48.plane][var8][var9] & 4) != 0) {
                           var7 = class48.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class11.tileSettings[class48.plane][var8][var9] & 4) != 0) {
                              var7 = class48.plane;
                           }
                        }
                     }
                  } else {
                     var14 = 65536 * var12 / var13;
                     var15 = '耀';

                     while(var11 != var9) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class11.tileSettings[class48.plane][var8][var9] & 4) != 0) {
                           var7 = class48.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class11.tileSettings[class48.plane][var8][var9] & 4) != 0) {
                              var7 = class48.plane;
                           }
                        }
                     }
                  }
               }

               if(VertexNormal.localPlayer.x >= 0 && VertexNormal.localPlayer.y >= 0 && VertexNormal.localPlayer.x < 13312 && VertexNormal.localPlayer.y < 13312) {
                  if((class11.tileSettings[class48.plane][VertexNormal.localPlayer.x >> 7][VertexNormal.localPlayer.y >> 7] & 4) != 0) {
                     var7 = class48.plane;
                  }

                  var6 = var7;
               } else {
                  var6 = class48.plane;
               }
            }
         }

         var5 = var6;
      } else {
         if(class85.field1456.field685) {
            var6 = class48.plane;
         } else {
            var7 = Renderable.method1883(class202.cameraX, class16.cameraY, class48.plane);
            if(var7 - cameraZ < 800 && (class11.tileSettings[class48.plane][class202.cameraX >> 7][class16.cameraY >> 7] & 4) != 0) {
               var6 = class48.plane;
            } else {
               var6 = 3;
            }
         }

         var5 = var6;
      }

      var6 = class202.cameraX;
      var7 = cameraZ;
      var8 = class16.cameraY;
      var9 = FloorUnderlayDefinition.cameraPitch;
      var10 = class3.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field527[var11]) {
            var12 = (int)(Math.random() * (double)(2 * Client.field528[var11] + 1) - (double)Client.field528[var11] + Math.sin((double)Client.field531[var11] * ((double)Client.field387[var11] / 100.0D)) * (double)Client.field529[var11]);
            if(var11 == 0) {
               class202.cameraX += var12;
            }

            if(var11 == 1) {
               cameraZ += var12;
            }

            if(var11 == 2) {
               class16.cameraY += var12;
            }

            if(var11 == 3) {
               class3.cameraYaw = class3.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               FloorUnderlayDefinition.cameraPitch += var12;
               if(FloorUnderlayDefinition.cameraPitch < 128) {
                  FloorUnderlayDefinition.cameraPitch = 128;
               }

               if(FloorUnderlayDefinition.cameraPitch > 383) {
                  FloorUnderlayDefinition.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1799;
      var12 = class115.field1794;
      if(class115.field1804 != 0) {
         var11 = class115.field1800;
         var12 = class115.field1807;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         Model.field1407 = true;
         Model.field1399 = 0;
         Model.field1355 = var11 - var0;
         Model.field1409 = var12 - var1;
      } else {
         Model.field1407 = false;
         Model.field1399 = 0;
      }

      class3.method33();
      Rasterizer2D.method4004(var0, var1, var2, var3, 0);
      class3.method33();
      var13 = class84.field1437;
      class84.field1437 = Client.scale;
      class65.region.method1748(class202.cameraX, cameraZ, class16.cameraY, FloorUnderlayDefinition.cameraPitch, class3.cameraYaw, var5);
      class84.field1437 = var13;
      class3.method33();
      class65.region.method1770();
      class104.method1983(var0, var1, var2, var3);
      class41.method777(var0, var1);
      ((TextureProvider)class84.field1448).method1446(Client.field354);
      if(Client.field520 == 1) {
         class33.field742[Client.field464 / 100].method4121(Client.field385 - 8, Client.field386 - 8);
      }

      if(Client.field520 == 2) {
         class33.field742[Client.field464 / 100 + 4].method4121(Client.field385 - 8, Client.field386 - 8);
      }

      class60.method1159();
      class202.cameraX = var6;
      cameraZ = var7;
      class16.cameraY = var8;
      FloorUnderlayDefinition.cameraPitch = var9;
      class3.cameraYaw = var10;
      if(Client.field287) {
         byte var17 = 0;
         var15 = var17 + class185.field2734 + class185.field2732;
         if(var15 == 0) {
            Client.field287 = false;
         }
      }

      if(Client.field287) {
         Rasterizer2D.method4004(var0, var1, var2, var3, 0);
         class101.method1940("Loading - please wait.", false);
      }

   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class124 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 179203593
   )
   static int field2039 = 0;
   @ObfuscatedName("y")
   static byte[][] field2040 = new byte[1000][];
   @ObfuscatedName("p")
   static byte[][] field2041 = new byte[250][];
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -13535465
   )
   static int field2042;
   @ObfuscatedName("bp")
   static class171 field2043;
   @ObfuscatedName("r")
   static ModIcon field2045;
   @ObfuscatedName("g")
   static byte[][] field2046 = new byte[50][];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1350236005
   )
   static int field2049 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 887645163
   )
   static int field2050 = 0;
   @ObfuscatedName("u")
   static int[] field2052;

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "56"
   )
   static final void method2739(int var0, int var1, int var2, int var3) {
      ++Client.field374;
      Player.method10(class35.field759);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field399 >= 0) {
         var5 = class34.field743;
         int[] var6 = class34.field739;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field399 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         Player.method10(class35.field756);
      }

      Ignore.method104(true);
      Player.method10(var4?class35.field760:class35.field757);
      Ignore.method104(false);
      class146.method3001();

      for(class31 var16 = (class31)Client.field403.method3808(); null != var16; var16 = (class31)Client.field403.method3810()) {
         if(class59.plane == var16.field679 && !var16.field681) {
            if(Client.gameCycle >= var16.field683) {
               var16.method677(Client.field297);
               if(var16.field681) {
                  var16.unlink();
               } else {
                  class114.region.method1926(var16.field679, var16.field680, var16.field677, var16.field682, 60, var16, 0, -1, false);
               }
            }
         } else {
            var16.unlink();
         }
      }

      class75.method1585(var0, var1, var2, var3, true);
      var0 = Client.field530;
      var1 = Client.field531;
      var2 = Client.camera2;
      var3 = Client.camera3;
      class82.method1795(var0, var1, var0 + var2, var1 + var3);
      class94.method2081();
      int var17;
      if(!Client.field516) {
         var5 = Client.field353;
         if(Client.field490 / 256 > var5) {
            var5 = Client.field490 / 256;
         }

         if(Client.field517[4] && 128 + Client.field519[4] > var5) {
            var5 = Client.field519[4] + 128;
         }

         var17 = Client.field337 + Client.mapAngle & 2047;
         Client.method423(XClanMember.field614, class79.method1656(TextureProvider.localPlayer.x, TextureProvider.localPlayer.y, class59.plane) - Client.field359, class116.field1996, var5, var17, 600 + 3 * var5);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      if(!Client.field516) {
         if(Sequence.field984.field123) {
            var17 = class59.plane;
         } else {
            label457: {
               var7 = 3;
               if(class125.cameraPitch < 310) {
                  var8 = class13.cameraX >> 7;
                  var9 = class154.cameraY >> 7;
                  var10 = TextureProvider.localPlayer.x >> 7;
                  var11 = TextureProvider.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var17 = class59.plane;
                     break label457;
                  }

                  if((class5.tileSettings[class59.plane][var8][var9] & 4) != 0) {
                     var7 = class59.plane;
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

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var8 != var10) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class5.tileSettings[class59.plane][var8][var9] & 4) != 0) {
                           var7 = class59.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class5.tileSettings[class59.plane][var8][var9] & 4) != 0) {
                              var7 = class59.plane;
                           }
                        }
                     }
                  } else {
                     var14 = var12 * 65536 / var13;
                     var15 = '耀';

                     while(var11 != var9) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class5.tileSettings[class59.plane][var8][var9] & 4) != 0) {
                           var7 = class59.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class5.tileSettings[class59.plane][var8][var9] & 4) != 0) {
                              var7 = class59.plane;
                           }
                        }
                     }
                  }
               }

               if(TextureProvider.localPlayer.x >= 0 && TextureProvider.localPlayer.y >= 0 && TextureProvider.localPlayer.x < 13312 && TextureProvider.localPlayer.y < 13312) {
                  if((class5.tileSettings[class59.plane][TextureProvider.localPlayer.x >> 7][TextureProvider.localPlayer.y >> 7] & 4) != 0) {
                     var7 = class59.plane;
                  }

                  var17 = var7;
               } else {
                  var17 = class59.plane;
               }
            }
         }

         var5 = var17;
      } else {
         if(Sequence.field984.field123) {
            var17 = class59.plane;
         } else {
            var7 = class79.method1656(class13.cameraX, class154.cameraY, class59.plane);
            if(var7 - Ignore.cameraZ < 800 && (class5.tileSettings[class59.plane][class13.cameraX >> 7][class154.cameraY >> 7] & 4) != 0) {
               var17 = class59.plane;
            } else {
               var17 = 3;
            }
         }

         var5 = var17;
      }

      var17 = class13.cameraX;
      var7 = Ignore.cameraZ;
      var8 = class154.cameraY;
      var9 = class125.cameraPitch;
      var10 = class166.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field517[var11]) {
            var12 = (int)(Math.random() * (double)(2 * Client.field526[var11] + 1) - (double)Client.field526[var11] + Math.sin((double)Client.field355[var11] / 100.0D * (double)Client.field521[var11]) * (double)Client.field519[var11]);
            if(var11 == 0) {
               class13.cameraX += var12;
            }

            if(var11 == 1) {
               Ignore.cameraZ += var12;
            }

            if(var11 == 2) {
               class154.cameraY += var12;
            }

            if(var11 == 3) {
               class166.cameraYaw = class166.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class125.cameraPitch += var12;
               if(class125.cameraPitch < 128) {
                  class125.cameraPitch = 128;
               }

               if(class125.cameraPitch > 383) {
                  class125.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class143.field2192;
      var12 = class143.field2189;
      if(class143.field2198 != 0) {
         var11 = class143.field2188;
         var12 = class143.field2196;
      }

      if(var11 >= var0 && var11 < var2 + var0 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1893 = true;
         Model.field1896 = 0;
         Model.field1894 = var11 - var0;
         Model.field1880 = var12 - var1;
      } else {
         Model.field1893 = false;
         Model.field1896 = 0;
      }

      class12.method162();
      class82.method1801(var0, var1, var2, var3, 0);
      class12.method162();
      var13 = class94.field1608;
      class94.field1608 = Client.scale;
      class114.region.method1953(class13.cameraX, Ignore.cameraZ, class154.cameraY, class125.cameraPitch, class166.cameraYaw, var5);
      class94.field1608 = var13;
      class12.method162();
      class114.region.method1929();
      class14.method170(var0, var1, var2, var3);
      if(Client.field310 == 2) {
         class158.method3156((Client.field287 - class23.baseX << 7) + Client.field286, Client.field350 + (Client.field433 - class8.baseY << 7), Client.field550 * 2);
         if(Client.field375 > -1 && Client.gameCycle % 20 < 10) {
            ChatMessages.field260[0].method1712(Client.field375 + var0 - 12, Client.field376 + var1 - 28);
         }
      }

      ((TextureProvider)class94.field1625).method2155(Client.field297);
      if(Client.field468 == 1) {
         NPCComposition.field907[Client.field539 / 100].method1712(Client.field454 - 8, Client.field378 - 8);
      }

      if(Client.field468 == 2) {
         NPCComposition.field907[4 + Client.field539 / 100].method1712(Client.field454 - 8, Client.field378 - 8);
      }

      Client.field426 = 0;
      var14 = (TextureProvider.localPlayer.x >> 7) + class23.baseX;
      var15 = class8.baseY + (TextureProvider.localPlayer.y >> 7);
      if(var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
         Client.field426 = 1;
      }

      if(var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
         Client.field426 = 1;
      }

      if(Client.field426 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
         Client.field426 = 0;
      }

      class13.cameraX = var17;
      Ignore.cameraZ = var7;
      class154.cameraY = var8;
      class125.cameraPitch = var9;
      class166.cameraYaw = var10;
      if(Client.field275) {
         byte var18 = 0;
         var15 = var18 + class174.field2768 + class174.field2766;
         if(var15 == 0) {
            Client.field275 = false;
         }
      }

      if(Client.field275) {
         class82.method1801(var0, var1, var2, var3, 0);
         class22.method555("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1459596207"
   )
   static synchronized byte[] method2740(int var0) {
      byte[] var1;
      if(var0 == 100 && field2049 > 0) {
         var1 = field2040[--field2049];
         field2040[field2049] = null;
         return var1;
      } else if(var0 == 5000 && field2050 > 0) {
         var1 = field2041[--field2050];
         field2041[field2050] = null;
         return var1;
      } else if(var0 == 30000 && field2039 > 0) {
         var1 = field2046[--field2039];
         field2046[field2039] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-4939"
   )
   public static void method2741() {
      try {
         class152.field2279.method4141();

         for(int var0 = 0; var0 < class152.field2277; ++var0) {
            class152.field2271[var0].method4141();
         }

         class152.field2278.method4141();
         class152.field2276.method4141();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lclass136;",
      garbageValue = "-2109725379"
   )
   static class136 method2743() {
      try {
         return new class150();
      } catch (Throwable var1) {
         return new class144();
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "391813177"
   )
   static final void method2745(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field298; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field379[var4] = true;
         }
      }

   }
}

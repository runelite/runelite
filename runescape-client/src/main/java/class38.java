import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("aa")
public class class38 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 756725805
   )
   int field795;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1972621711
   )
   int field797;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -838241645
   )
   int field798;
   @ObfuscatedName("g")
   String field799;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 510692611
   )
   int field800;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   static void method704() {
      int var0 = ItemLayer.field1223;
      int var1 = class112.field1755;
      if(class118.field1849 < var0) {
         var0 = class118.field1849;
      }

      if(class104.field1679 < var1) {
         var1 = class104.field1679;
      }

      if(null != class149.field2044) {
         try {
            Client var2 = Client.field282;
            Object[] var3 = new Object[]{Integer.valueOf(XGrandExchangeOffer.method57())};
            JSObject.getWindow(var2).call("resize", var3);
         } catch (Throwable var4) {
            ;
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-232120891"
   )
   static final void method705() {
      if(class171.plane != Client.field515) {
         Client.field515 = class171.plane;
         int var0 = class171.plane;
         int[] var1 = class159.field2131.image;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = 24628 + (103 - var3) * 2048;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
                  Client.region.method1725(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class10.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  Client.region.method1725(var1, var4, 512, 1 + var0, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         class159.field2131.method4039();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
                  class5.method68(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  class5.method68(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field516 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = Client.region.method1720(class171.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = ItemLayer.getObjectDefinition(var7).field2921;
                  if(var8 >= 0) {
                     int var9 = var5;
                     int var10 = var6;
                     if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                        int[][] var13 = Client.collisionMaps[class171.plane].flags;

                        for(int var14 = 0; var14 < 10; ++var14) {
                           int var15 = (int)(Math.random() * 4.0D);
                           if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                              --var9;
                           }

                           if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[var9 + 1][var10] & 19136896) == 0) {
                              ++var9;
                           }

                           if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                              --var10;
                           }

                           if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][var10 + 1] & 19136800) == 0) {
                              ++var10;
                           }
                        }
                     }

                     Client.field519[Client.field516] = class44.field898[var8];
                     Client.field357[Client.field516] = var9;
                     Client.field510[Client.field516] = var10;
                     ++Client.field516;
                  }
               }
            }
         }

         ChatMessages.bufferProvider.method3954();
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   static final int method706() {
      if(class149.field2044.field689) {
         return class171.plane;
      } else {
         int var0 = 3;
         if(Buffer.cameraPitch < 310) {
            int var1 = WidgetNode.cameraX >> 7;
            int var2 = class2.cameraY >> 7;
            int var3 = class39.localPlayer.x >> 7;
            int var4 = class39.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class171.plane;
            }

            if((class10.tileSettings[class171.plane][var1][var2] & 4) != 0) {
               var0 = class171.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class10.tileSettings[class171.plane][var1][var2] & 4) != 0) {
                     var0 = class171.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class10.tileSettings[class171.plane][var1][var2] & 4) != 0) {
                        var0 = class171.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class10.tileSettings[class171.plane][var1][var2] & 4) != 0) {
                     var0 = class171.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class10.tileSettings[class171.plane][var1][var2] & 4) != 0) {
                        var0 = class171.plane;
                     }
                  }
               }
            }
         }

         if(class39.localPlayer.x >= 0 && class39.localPlayer.y >= 0 && class39.localPlayer.x < 13312 && class39.localPlayer.y < 13312) {
            if((class10.tileSettings[class171.plane][class39.localPlayer.x >> 7][class39.localPlayer.y >> 7] & 4) != 0) {
               var0 = class171.plane;
            }

            return var0;
         } else {
            return class171.plane;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "1835089180"
   )
   static class184 method707(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1673) {
         var4 = new class116(var0, class104.field1673, class9.field84[var0], 1000000);
      }

      return new class184(var4, class140.field1958, var0, var1, var2, var3);
   }
}

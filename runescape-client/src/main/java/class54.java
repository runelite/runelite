import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class54 extends CacheableNode {
   @ObfuscatedName("q")
   static NodeCache field1162 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1525869387
   )
   public int field1163 = 0;
   @ObfuscatedName("k")
   public static class170 field1165;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1480183104"
   )
   void method1101(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1163 = var1.method2691();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "11373"
   )
   void method1102(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1101(var1, var2);
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1762779798"
   )
   static final void method1105(int var0) {
      int[] var1 = DecorativeObject.field1677.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + 2048 * (103 - var3);

         for(var5 = 1; var5 < 103; ++var5) {
            if((class5.tileSettings[var0][var5][var3] & 24) == 0) {
               Frames.region.method1994(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class5.tileSettings[1 + var0][var5][var3] & 8) != 0) {
               Frames.region.method1994(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      DecorativeObject.field1677.method1739();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class5.tileSettings[var0][var6][var5] & 24) == 0) {
               class92.method2154(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class5.tileSettings[1 + var0][var6][var5] & 8) != 0) {
               class92.method2154(1 + var0, var6, var5, var3, var4);
            }
         }
      }

      Client.field510 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = Frames.region.method2102(class145.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = Projectile.getObjectDefinition(var7).field963;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class145.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < var5 + 3 && (var13[var9 + 1][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field513[Client.field510] = MessageNode.field804[var8];
                  Client.field511[Client.field510] = var9;
                  Client.field368[Client.field510] = var10;
                  ++Client.field510;
               }
            }
         }
      }

      Sequence.bufferProvider.method1720();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-43"
   )
   static void method1108(int var0, int var1, int var2) {
      if(Client.field520 != 0 && var1 != 0 && Client.field522 < 50) {
         Client.field523[Client.field522] = var0;
         Client.field524[Client.field522] = var1;
         Client.field327[Client.field522] = var2;
         Client.field527[Client.field522] = null;
         Client.field392[Client.field522] = 0;
         ++Client.field522;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1664989867"
   )
   static final void method1110(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field851 == 0) {
         var0.field883 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var10 = NPC.getAnimation(var0.animation);
            if(var0.field863 > 0 && var10.precedenceAnimating == 0) {
               ++var0.field883;
               return;
            }

            if(var0.field863 <= 0 && var10.field1018 == 0) {
               ++var0.field883;
               return;
            }
         }

         int var1 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field841 * 64 + 128 * var0.pathX[var0.field851 - 1];
         int var4 = var0.field841 * 64 + 128 * var0.pathY[var0.field851 - 1];
         if(var1 < var3) {
            if(var2 < var4) {
               var0.field876 = 1280;
            } else if(var2 > var4) {
               var0.field876 = 1792;
            } else {
               var0.field876 = 1536;
            }
         } else if(var1 > var3) {
            if(var2 < var4) {
               var0.field876 = 768;
            } else if(var2 > var4) {
               var0.field876 = 256;
            } else {
               var0.field876 = 512;
            }
         } else if(var2 < var4) {
            var0.field876 = 1024;
         } else if(var2 > var4) {
            var0.field876 = 0;
         }

         byte var5 = var0.field882[var0.field851 - 1];
         if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field876 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field834;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field833;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field836;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field835;
            }

            if(var7 == -1) {
               var7 = var0.field833;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field876 != var0.angle && var0.interacting == -1 && var0.field878 != 0) {
                  var8 = 2;
               }

               if(var0.field851 > 2) {
                  var8 = 6;
               }

               if(var0.field851 > 3) {
                  var8 = 8;
               }

               if(var0.field883 > 0 && var0.field851 > 1) {
                  var8 = 8;
                  --var0.field883;
               }
            } else {
               if(var0.field851 > 1) {
                  var8 = 6;
               }

               if(var0.field851 > 2) {
                  var8 = 8;
               }

               if(var0.field883 > 0 && var0.field851 > 1) {
                  var8 = 8;
                  --var0.field883;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field833 && var0.field872 != -1) {
               var0.poseAnimation = var0.field872;
            }

            if(var3 != var1 || var4 != var2) {
               if(var1 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var1 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var0.y == var4) {
               --var0.field851;
               if(var0.field863 > 0) {
                  --var0.field863;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field851;
            if(var0.field863 > 0) {
               --var0.field863;
            }

         }
      }
   }
}

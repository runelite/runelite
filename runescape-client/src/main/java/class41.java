import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class41 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 102261417
   )
   static int field806;
   @ObfuscatedName("i")
   static ModIcon field807;
   @ObfuscatedName("a")
   static ModIcon field808;
   @ObfuscatedName("c")
   static SpritePixels field809;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1835346097
   )
   static int field810;
   @ObfuscatedName("z")
   static ModIcon field811;
   @ObfuscatedName("aw")
   @Export("username")
   static String username;
   @ObfuscatedName("ag")
   static int[] field813;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1434620871
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("k")
   static int[] field815;
   @ObfuscatedName("y")
   static int[] field816;
   @ObfuscatedName("h")
   static int[] field817;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 373489827
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1113751733
   )
   static int field821;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1083808957
   )
   static int field822;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1684994967
   )
   static int field823;
   @ObfuscatedName("ae")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1515066351
   )
   static int field825;
   @ObfuscatedName("ai")
   static String field826;
   @ObfuscatedName("az")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("av")
   static String field828;
   @ObfuscatedName("at")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ad")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ak")
   static String field833;
   @ObfuscatedName("aq")
   static class97 field834;
   @ObfuscatedName("ay")
   static boolean field835;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1330405171
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("d")
   static SpritePixels field840;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 488981849
   )
   static int field841;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2061079945
   )
   static int field843;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1968836549
   )
   static int field846 = 0;

   static {
      loginWindowX = field846 + 202;
      field815 = new int[256];
      field806 = 0;
      field810 = 0;
      field821 = 0;
      field822 = 0;
      field823 = 0;
      field843 = 0;
      field825 = 10;
      field826 = "";
      loginIndex = 0;
      field828 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field833 = "";
      field834 = class97.field1620;
      field835 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field841 = -1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "33"
   )
   static void method770(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1671, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2760(3);
         var3.method2760(null != var1?1:0);
         var3.method2798(var0.getPath());
         if(var1 != null) {
            var3.method2798("");
         }

         var2.method1375(var3.payload, 0, var3.offset);
         var2.method1365();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[IB)I",
      garbageValue = "-73"
   )
   public static int method771(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1834[var8][var9] = 0;
            class118.field1826[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var28 = class109.method2011(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var28 = class139.method2603(var0, var1, var3, var4);
      } else {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1834[var12][var13] = 99;
         class118.field1826[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class118.field1828[var16] = var0;
         var33 = var16 + 1;
         class118.field1829[var16] = var1;
         int[][] var18 = var4.flags;

         boolean var29;
         label525:
         while(true) {
            label523:
            while(true) {
               do {
                  do {
                     do {
                        label500:
                        do {
                           if(var33 == var17) {
                              class146.field2005 = var10;
                              class118.field1827 = var11;
                              var29 = false;
                              break label525;
                           }

                           var10 = class118.field1828[var17];
                           var11 = class118.field1829[var17];
                           var17 = 1 + var17 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod2276(var2, var10, var11, var4)) {
                              class146.field2005 = var10;
                              class118.field1827 = var11;
                              var29 = true;
                              break label525;
                           }

                           var21 = class118.field1826[var30][var31] + 1;
                           if(var30 > 0 && class118.field1834[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1828[var33] = var10 - 1;
                                    class118.field1829[var33] = var11;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1834[var30 - 1][var31] = 2;
                                    class118.field1826[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class118.field1834[1 + var30][var31] == 0 && (var18[var2 + var19][var20] & 19136899) == 0 && (var18[var2 + var19][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1828[var33] = var10 + 1;
                                    class118.field1829[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1834[1 + var30][var31] = 8;
                                    class118.field1826[1 + var30][var31] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class118.field1834[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var2 + var19 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1828[var33] = var10;
                                    class118.field1829[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1834[var30][var31 - 1] = 1;
                                    class118.field1826[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class118.field1834[var30][1 + var31] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var19 + var2 - 1][var2 + var20] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1828[var33] = var10;
                                    class118.field1829[var33] = 1 + var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1834[var30][var31 + 1] = 4;
                                    class118.field1826[var30][1 + var31] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 + var2] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class118.field1834[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1828[var33] = var10 - 1;
                                    class118.field1829[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1834[var30 - 1][var31 - 1] = 3;
                                    class118.field1826[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class118.field1834[1 + var30][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1828[var33] = var10 + 1;
                                    class118.field1829[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1834[1 + var30][var31 - 1] = 9;
                                    class118.field1826[1 + var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var22 + (var20 - 1)] & 19136995) != 0 || (var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class118.field1834[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var19 - 1 + var22][var2 + var20] & 19137016) != 0) {
                                    continue label500;
                                 }
                              }

                              class118.field1828[var33] = var10 - 1;
                              class118.field1829[var33] = 1 + var11;
                              var33 = var33 + 1 & 4095;
                              class118.field1834[var30 - 1][var31 + 1] = 6;
                              class118.field1826[var30 - 1][1 + var31] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class118.field1834[1 + var30][1 + var31] != 0);
               } while((var18[var2 + var19][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var20 + var2] & 19137016) != 0 || (var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                     continue label523;
                  }
               }

               class118.field1828[var33] = 1 + var10;
               class118.field1829[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1834[var30 + 1][var31 + 1] = 12;
               class118.field1826[1 + var30][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class146.field2005;
      var30 = class118.field1827;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1838;
         var17 = var3.field1840;
         int var27 = var3.field1841;
         var19 = var3.field1837;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1826[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var31 || var26 == var31 && class118.field1826[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1826[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var1 == var30) {
         return 0;
      } else {
         var13 = 0;
         class118.field1828[var13] = var11;
         var31 = var13 + 1;
         class118.field1829[var13] = var30;

         for(var14 = var15 = class118.field1834[var11 - var9][var30 - var10]; var11 != var0 || var30 != var1; var14 = class118.field1834[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class118.field1828[var31] = var11;
               class118.field1829[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class118.field1828[var31];
            var7[var33++] = class118.field1829[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)LSpritePixels;",
      garbageValue = "107"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class88.getItemDefinition(var0);
      if(var1 > 1 && var9.field2971 != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field2972[var11] && var9.field2972[var11] != 0) {
               var10 = var9.field2971[var11];
            }
         }

         if(var10 != -1) {
            var9 = class88.getItemDefinition(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if(null == var20) {
         return null;
      } else {
         SpritePixels var19 = null;
         if(var9.field2974 != -1) {
            var19 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var19 == null) {
               return null;
            }
         } else if(var9.field2983 != -1) {
            var19 = createSprite(var9.field2941, var1, var2, var3, 0, false);
            if(var19 == null) {
               return null;
            }
         } else if(var9.field2942 != -1) {
            var19 = createSprite(var9.field2984, var1, 0, 0, 0, false);
            if(null == var19) {
               return null;
            }
         }

         int[] var12 = class219.graphicsPixels;
         int var13 = class219.graphicsPixelsWidth;
         int var14 = class219.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class219.method3967(var15);
         var8 = new SpritePixels(36, 32);
         class219.setRasterBuffer(var8.image, 36, 32);
         class219.method4007();
         class84.method1614();
         class84.method1604(16, 16);
         class84.rasterGouraudLowRes = false;
         if(var9.field2942 != -1) {
            var19.method4122(0, 0);
         }

         int var16 = var9.field2948;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class84.field1438[var9.field2949] >> 16;
         int var18 = class84.field1428[var9.field2949] * var16 >> 16;
         var20.method1532();
         var20.method1531(0, var9.field2937, var9.field2951, var9.field2949, var9.field2952, var9.field2953 + var17 + var20.modelHeight / 2, var18 + var9.field2953);
         if(var9.field2983 != -1) {
            var19.method4122(0, 0);
         }

         if(var2 >= 1) {
            var8.method4155(1);
         }

         if(var2 >= 2) {
            var8.method4155(16777215);
         }

         if(var3 != 0) {
            var8.method4141(var3);
         }

         class219.setRasterBuffer(var8.image, 36, 32);
         if(var9.field2974 != -1) {
            var19.method4122(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class206.field3075.method3867(class174.method3239(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class219.setRasterBuffer(var12, var13, var14);
         class219.method3968(var15);
         class84.method1614();
         class84.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "156265229"
   )
   static final void method773(Actor var0) {
      if(var0.field616 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.field650 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field613) {
               var0.interacting = -1;
               var0.field613 = false;
            }
         }

         if(var0.field627 != -1 && (var0.field653 == 0 || var0.field657 > 0)) {
            var0.field650 = var0.field627;
            var0.field627 = -1;
         }

         int var5 = var0.field650 - var0.angle & 2047;
         if(var5 == 0 && var0.field613) {
            var0.interacting = -1;
            var0.field613 = false;
         }

         if(var5 != 0) {
            ++var0.field624;
            boolean var6;
            if(var5 > 1024) {
               var0.angle -= var0.field616;
               var6 = true;
               if(var5 < var0.field616 || var5 > 2048 - var0.field616) {
                  var0.angle = var0.field650;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field624 > 25 || var6)) {
                  if(var0.field605 != -1) {
                     var0.poseAnimation = var0.field605;
                  } else {
                     var0.poseAnimation = var0.field607;
                  }
               }
            } else {
               var0.angle += var0.field616;
               var6 = true;
               if(var5 < var0.field616 || var5 > 2048 - var0.field616) {
                  var0.angle = var0.field650;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field624 > 25 || var6)) {
                  if(var0.field626 != -1) {
                     var0.poseAnimation = var0.field626;
                  } else {
                     var0.poseAnimation = var0.field607;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field624 = 0;
         }

      }
   }
}

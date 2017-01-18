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
      int var8;
      int var9;
      for(var9 = 0; var9 < 128; ++var9) {
         for(var8 = 0; var8 < 128; ++var8) {
            class118.field1834[var9][var8] = 0;
            class118.field1826[var9][var8] = 99999999;
         }
      }

      int var10;
      byte var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      boolean var19;
      int var20;
      int var21;
      int var22;
      byte var23;
      if(var2 == 1) {
         var19 = class109.method2011(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var19 = class139.method2603(var0, var1, var3, var4);
      } else {
         var9 = var0;
         var10 = var1;
         var23 = 64;
         var11 = 64;
         var12 = var0 - var23;
         var13 = var1 - var11;
         class118.field1834[var23][var11] = 99;
         class118.field1826[var23][var11] = 0;
         byte var24 = 0;
         var14 = 0;
         class118.field1828[var24] = var0;
         var22 = var24 + 1;
         class118.field1829[var24] = var1;
         int[][] var25 = var4.flags;

         boolean var26;
         label328: {
            label327:
            while(var22 != var14) {
               var9 = class118.field1828[var14];
               var10 = class118.field1829[var14];
               var14 = 1 + var14 & 4095;
               var20 = var9 - var12;
               var21 = var10 - var13;
               var15 = var9 - var4.x;
               var16 = var10 - var4.y;
               if(var3.vmethod2276(var2, var9, var10, var4)) {
                  class146.field2005 = var9;
                  class118.field1827 = var10;
                  var26 = true;
                  break label328;
               }

               var17 = class118.field1826[var20][var21] + 1;
               if(var20 > 0 && class118.field1834[var20 - 1][var21] == 0 && (var25[var15 - 1][var16] & 19136782) == 0 && (var25[var15 - 1][var2 + var16 - 1] & 19136824) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2 - 1) {
                        class118.field1828[var22] = var9 - 1;
                        class118.field1829[var22] = var10;
                        var22 = 1 + var22 & 4095;
                        class118.field1834[var20 - 1][var21] = 2;
                        class118.field1826[var20 - 1][var21] = var17;
                        break;
                     }

                     if((var25[var15 - 1][var18 + var16] & 19136830) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var20 < 128 - var2 && class118.field1834[1 + var20][var21] == 0 && (var25[var2 + var15][var16] & 19136899) == 0 && (var25[var2 + var15][var16 + var2 - 1] & 19136992) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2 - 1) {
                        class118.field1828[var22] = var9 + 1;
                        class118.field1829[var22] = var10;
                        var22 = var22 + 1 & 4095;
                        class118.field1834[1 + var20][var21] = 8;
                        class118.field1826[1 + var20][var21] = var17;
                        break;
                     }

                     if((var25[var2 + var15][var16 + var18] & 19136995) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var21 > 0 && class118.field1834[var20][var21 - 1] == 0 && (var25[var15][var16 - 1] & 19136782) == 0 && (var25[var2 + var15 - 1][var16 - 1] & 19136899) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2 - 1) {
                        class118.field1828[var22] = var9;
                        class118.field1829[var22] = var10 - 1;
                        var22 = var22 + 1 & 4095;
                        class118.field1834[var20][var21 - 1] = 1;
                        class118.field1826[var20][var21 - 1] = var17;
                        break;
                     }

                     if((var25[var15 + var18][var16 - 1] & 19136911) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var21 < 128 - var2 && class118.field1834[var20][1 + var21] == 0 && (var25[var15][var16 + var2] & 19136824) == 0 && (var25[var15 + var2 - 1][var2 + var16] & 19136992) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2 - 1) {
                        class118.field1828[var22] = var9;
                        class118.field1829[var22] = 1 + var10;
                        var22 = var22 + 1 & 4095;
                        class118.field1834[var20][var21 + 1] = 4;
                        class118.field1826[var20][1 + var21] = var17;
                        break;
                     }

                     if((var25[var18 + var15][var16 + var2] & 19137016) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var20 > 0 && var21 > 0 && class118.field1834[var20 - 1][var21 - 1] == 0 && (var25[var15 - 1][var16 - 1] & 19136782) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2) {
                        class118.field1828[var22] = var9 - 1;
                        class118.field1829[var22] = var10 - 1;
                        var22 = 1 + var22 & 4095;
                        class118.field1834[var20 - 1][var21 - 1] = 3;
                        class118.field1826[var20 - 1][var21 - 1] = var17;
                        break;
                     }

                     if((var25[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var25[var15 - 1 + var18][var16 - 1] & 19136911) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var20 < 128 - var2 && var21 > 0 && class118.field1834[1 + var20][var21 - 1] == 0 && (var25[var15 + var2][var16 - 1] & 19136899) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2) {
                        class118.field1828[var22] = var9 + 1;
                        class118.field1829[var22] = var10 - 1;
                        var22 = 1 + var22 & 4095;
                        class118.field1834[1 + var20][var21 - 1] = 9;
                        class118.field1826[1 + var20][var21 - 1] = var17;
                        break;
                     }

                     if((var25[var2 + var15][var18 + (var16 - 1)] & 19136995) != 0 || (var25[var18 + var15][var16 - 1] & 19136911) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var20 > 0 && var21 < 128 - var2 && class118.field1834[var20 - 1][var21 + 1] == 0 && (var25[var15 - 1][var2 + var16] & 19136824) == 0) {
                  var18 = 1;

                  while(true) {
                     if(var18 >= var2) {
                        class118.field1828[var22] = var9 - 1;
                        class118.field1829[var22] = 1 + var10;
                        var22 = var22 + 1 & 4095;
                        class118.field1834[var20 - 1][var21 + 1] = 6;
                        class118.field1826[var20 - 1][1 + var21] = var17;
                        break;
                     }

                     if((var25[var15 - 1][var16 + var18] & 19136830) != 0 || (var25[var15 - 1 + var18][var2 + var16] & 19137016) != 0) {
                        break;
                     }

                     ++var18;
                  }
               }

               if(var20 < 128 - var2 && var21 < 128 - var2 && class118.field1834[1 + var20][1 + var21] == 0 && (var25[var2 + var15][var16 + var2] & 19136992) == 0) {
                  for(var18 = 1; var18 < var2; ++var18) {
                     if((var25[var15 + var18][var16 + var2] & 19137016) != 0 || (var25[var2 + var15][var16 + var18] & 19136995) != 0) {
                        continue label327;
                     }
                  }

                  class118.field1828[var22] = 1 + var9;
                  class118.field1829[var22] = var10 + 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1834[var20 + 1][var21 + 1] = 12;
                  class118.field1826[1 + var20][var21 + 1] = var17;
               }
            }

            class146.field2005 = var9;
            class118.field1827 = var10;
            var26 = false;
         }

         var19 = var26;
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class146.field2005;
      var20 = class118.field1827;
      if(!var19) {
         var21 = Integer.MAX_VALUE;
         var12 = Integer.MAX_VALUE;
         var23 = 10;
         var22 = var3.field1838;
         var14 = var3.field1840;
         int var29 = var3.field1841;
         var15 = var3.field1837;

         for(var16 = var22 - var23; var16 <= var22 + var23; ++var16) {
            for(var17 = var14 - var23; var17 <= var23 + var14; ++var17) {
               var18 = var16 - var8;
               int var30 = var17 - var9;
               if(var18 >= 0 && var30 >= 0 && var18 < 128 && var30 < 128 && class118.field1826[var18][var30] < 100) {
                  int var31 = 0;
                  if(var16 < var22) {
                     var31 = var22 - var16;
                  } else if(var16 > var22 + var29 - 1) {
                     var31 = var16 - (var29 + var22 - 1);
                  }

                  int var27 = 0;
                  if(var17 < var14) {
                     var27 = var14 - var17;
                  } else if(var17 > var14 + var15 - 1) {
                     var27 = var17 - (var14 + var15 - 1);
                  }

                  int var28 = var31 * var31 + var27 * var27;
                  if(var28 < var21 || var28 == var21 && class118.field1826[var18][var30] < var12) {
                     var21 = var28;
                     var12 = class118.field1826[var18][var30];
                     var10 = var16;
                     var20 = var17;
                  }
               }
            }
         }

         if(var21 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var10 && var1 == var20) {
         return 0;
      } else {
         var11 = 0;
         class118.field1828[var11] = var10;
         var21 = var11 + 1;
         class118.field1829[var11] = var20;

         for(var12 = var13 = class118.field1834[var10 - var8][var20 - var9]; var10 != var0 || var20 != var1; var12 = class118.field1834[var10 - var8][var20 - var9]) {
            if(var12 != var13) {
               var13 = var12;
               class118.field1828[var21] = var10;
               class118.field1829[var21++] = var20;
            }

            if((var12 & 2) != 0) {
               ++var10;
            } else if((var12 & 8) != 0) {
               --var10;
            }

            if((var12 & 1) != 0) {
               ++var20;
            } else if((var12 & 4) != 0) {
               --var20;
            }
         }

         var22 = 0;

         while(var21-- > 0) {
            var6[var22] = class118.field1828[var21];
            var7[var22++] = class118.field1829[var21];
            if(var22 >= var6.length) {
               break;
            }
         }

         return var22;
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
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class88.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(null == var19) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field2983 != -1) {
            var20 = createSprite(var9.field2941, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field2942 != -1) {
            var20 = createSprite(var9.field2984, var1, 0, 0, 0, false);
            if(null == var20) {
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
            var20.method4122(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class84.field1438[var9.xan2d] >> 16;
         int var18 = class84.field1428[var9.xan2d] * var16 >> 16;
         var19.method1532();
         var19.method1531(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var9.offsetY2d + var17 + var19.modelHeight / 2, var18 + var9.offsetY2d);
         if(var9.field2983 != -1) {
            var20.method4122(0, 0);
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
         if(var9.notedTemplate != -1) {
            var20.method4122(0, 0);
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

         int var4 = var0.field650 - var0.angle & 2047;
         if(var4 == 0 && var0.field613) {
            var0.interacting = -1;
            var0.field613 = false;
         }

         if(var4 != 0) {
            ++var0.field624;
            boolean var5;
            if(var4 > 1024) {
               var0.angle -= var0.field616;
               var5 = true;
               if(var4 < var0.field616 || var4 > 2048 - var0.field616) {
                  var0.angle = var0.field650;
                  var5 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field624 > 25 || var5)) {
                  if(var0.field605 != -1) {
                     var0.poseAnimation = var0.field605;
                  } else {
                     var0.poseAnimation = var0.field607;
                  }
               }
            } else {
               var0.angle += var0.field616;
               var5 = true;
               if(var4 < var0.field616 || var4 > 2048 - var0.field616) {
                  var0.angle = var0.field650;
                  var5 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field624 > 25 || var5)) {
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
}

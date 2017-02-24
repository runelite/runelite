import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public final class class10 {
   @ObfuscatedName("j")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -247953357
   )
   static int field95 = 99;
   @ObfuscatedName("p")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("l")
   static final int[] field97 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("s")
   static int[] field98;
   @ObfuscatedName("i")
   static int[][] field99;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1462354743
   )
   static int field100 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("bp")
   static ModIcon[] field101;
   @ObfuscatedName("b")
   static int[] field102;
   @ObfuscatedName("y")
   static final int[] field103 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("w")
   static final int[] field104 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("a")
   static final int[] field105 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("k")
   static final int[] field106 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("r")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("x")
   static final int[] field108 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1112256003
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("d")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("bw")
   static class184 field111;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1696394995
   )
   static int field112 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("q")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("c")
   static byte[][][] field118;

   class10() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;S)V",
      garbageValue = "-6092"
   )
   static final void method114(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field308 || (tileSettings[0][var1][var2] & 2) != 0 || (tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < field95) {
            field95 = var0;
         }

         ObjectComposition var8 = class187.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var2 << 7) + var1 + (var3 << 14);
         if(var8.field2912 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field2932 == 1) {
            var20 += 256;
         }

         if(var8.method3626()) {
            class18.method200(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field308 || var8.field2912 != 0 || var8.field2943 == 1 || var8.field2940) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method3648(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2943 == 1 && var7 != null) {
                  var7.method2310(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3648(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1757(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class49.field984[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2943 != 0 && var7 != null) {
                     var7.method2331(var1, var2, var9, var10, var8.field2911);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3648(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1890(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, field103[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2939) {
                        field118[var0][var1][var2] = 50;
                        field118[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field2892) {
                        class49.field984[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2939) {
                        field118[var0][var1][var2 + 1] = 50;
                        field118[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field2892) {
                        class49.field984[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2939) {
                        field118[var0][1 + var1][var2] = 50;
                        field118[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field2892) {
                        class49.field984[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2939) {
                        field118[var0][var1][var2] = 50;
                        field118[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2892) {
                        class49.field984[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2943 != 0 && var7 != null) {
                     var7.method2307(var1, var2, var5, var4, var8.field2911);
                  }

                  if(var8.field2917 != 16) {
                     var6.method1763(var0, var1, var2, var8.field2917);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3648(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1890(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, field104[var4], 0, var19, var20);
                  if(var8.field2939) {
                     if(var4 == 0) {
                        field118[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        field118[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        field118[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        field118[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2943 != 0 && null != var7) {
                     var7.method2307(var1, var2, var5, var4, var8.field2911);
                  }

               } else {
                  Object var26;
                  int var27;
                  if(var5 == 2) {
                     var27 = 1 + var4 & 3;
                     Object var28;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var28 = var8.method3648(2, var4 + 4, var15, var17, var16, var18);
                        var26 = var8.method3648(2, var27, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var26 = new class49(var3, 2, var27, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1890(var0, var1, var2, var16, (Renderable)var28, (Renderable)var26, field103[var4], field103[var27], var19, var20);
                     if(var8.field2892) {
                        if(var4 == 0) {
                           class49.field984[var0][var1][var2] |= 585;
                           class49.field984[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class49.field984[var0][var1][1 + var2] |= 1170;
                           class49.field984[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class49.field984[var0][1 + var1][var2] |= 585;
                           class49.field984[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class49.field984[var0][var1][var2] |= 1170;
                           class49.field984[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2943 != 0 && var7 != null) {
                        var7.method2307(var1, var2, var5, var4, var8.field2911);
                     }

                     if(var8.field2917 != 16) {
                        var6.method1763(var0, var1, var2, var8.field2917);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3648(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1890(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, field104[var4], 0, var19, var20);
                     if(var8.field2939) {
                        if(var4 == 0) {
                           field118[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           field118[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           field118[var0][1 + var1][var2] = 50;
                        } else if(var4 == 3) {
                           field118[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2943 != 0 && var7 != null) {
                        var7.method2307(var1, var2, var5, var4, var8.field2911);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3648(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1757(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2943 != 0 && null != var7) {
                        var7.method2331(var1, var2, var9, var10, var8.field2911);
                     }

                     if(var8.field2917 != 16) {
                        var6.method1763(var0, var1, var2, var8.field2917);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3648(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1756(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, field103[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var27 = 16;
                     var22 = var6.method1773(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class187.getObjectDefinition(var22 >> 14 & 32767).field2917;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var26 = var8.method3648(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1756(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, field103[var4], 0, var27 * field105[var4], field106[var4] * var27, var19, var20);
                  } else if(var5 == 6) {
                     var27 = 8;
                     var22 = var6.method1773(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class187.getObjectDefinition(var22 >> 14 & 32767).field2917 / 2;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var26 = var8.method3648(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1756(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, 256, var4, field97[var4] * var27, var27 * field108[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3648(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, 4 + var22, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1756(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var27 = 8;
                     var22 = var6.method1773(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class187.getObjectDefinition(var22 >> 14 & 32767).field2917 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var26 = var8.method3648(4, 4 + var4, var15, var17, var16, var18);
                        var29 = var8.method3648(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1756(var0, var1, var2, var16, (Renderable)var26, (Renderable)var29, 256, var4, field97[var4] * var27, var27 * field108[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var21 = var8.method3648(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method1757(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2939) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1619() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > field118[var0][var1 + var23][var24 + var2]) {
                           field118[var0][var1 + var23][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2943 != 0 && null != var7) {
                  var7.method2331(var1, var2, var9, var10, var8.field2911);
               }

            }
         }
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1723602905"
   )
   static final void method134(int var0) {
      if(class30.method696(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2327 = 0;
               var3.field2328 = 0;
            }
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "9251"
   )
   static final int method136() {
      if(class184.field2735.field714) {
         return WallObject.plane;
      } else {
         int var0 = 3;
         if(Actor.cameraPitch < 310) {
            int var1 = VertexNormal.cameraX >> 7;
            int var2 = class37.cameraY >> 7;
            int var3 = class36.localPlayer.x >> 7;
            int var4 = class36.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return WallObject.plane;
            }

            if((tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
               var0 = WallObject.plane;
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
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                     var0 = WallObject.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                        var0 = WallObject.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                     var0 = WallObject.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((tileSettings[WallObject.plane][var1][var2] & 4) != 0) {
                        var0 = WallObject.plane;
                     }
                  }
               }
            }
         }

         if(class36.localPlayer.x >= 0 && class36.localPlayer.y >= 0 && class36.localPlayer.x < 13312 && class36.localPlayer.y < 13312) {
            if((tileSettings[WallObject.plane][class36.localPlayer.x >> 7][class36.localPlayer.y >> 7] & 4) != 0) {
               var0 = WallObject.plane;
            }

            return var0;
         } else {
            return WallObject.plane;
         }
      }
   }
}

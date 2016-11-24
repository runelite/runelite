import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public abstract class class163 {
   @ObfuscatedName("ga")
   static Widget field2313;
   @ObfuscatedName("d")
   static boolean field2314 = false;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1659875851"
   )
   static final void method3198(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field288 || (class11.tileSettings[0][var1][var2] & 2) != 0 || (class11.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class11.field102) {
            class11.field102 = var0;
         }

         ObjectComposition var8 = class15.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field2903;
            var10 = var8.field2907;
         } else {
            var9 = var8.field2907;
            var10 = var8.field2903;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class11.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field2910 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2931 == 1) {
            var20 += 256;
         }

         if(var8.method3660()) {
            class15.method193(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field288 || var8.field2910 != 0 || var8.field2908 == 1 || var8.field2929) {
               if(var8.field2914 == -1 && var8.impostorIds == null) {
                  var21 = var8.method3655(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2908 == 1 && var7 != null) {
                  var7.method2306(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field2914 == -1 && null == var8.impostorIds) {
                     var21 = var8.method3655(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                  }

                  var6.method1750(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class187.field2778[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2908 != 0 && var7 != null) {
                     var7.method2333(var1, var2, var9, var10, var8.field2909);
                  }

               } else if(var5 == 0) {
                  if(var8.field2914 == -1 && null == var8.impostorIds) {
                     var21 = var8.method3655(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                  }

                  var6.method1748(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class11.field108[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2891) {
                        class5.field51[var0][var1][var2] = 50;
                        class5.field51[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field2913) {
                        class187.field2778[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2891) {
                        class5.field51[var0][var1][1 + var2] = 50;
                        class5.field51[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field2913) {
                        class187.field2778[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2891) {
                        class5.field51[var0][var1 + 1][var2] = 50;
                        class5.field51[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field2913) {
                        class187.field2778[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2891) {
                        class5.field51[var0][var1][var2] = 50;
                        class5.field51[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field2913) {
                        class187.field2778[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2908 != 0 && null != var7) {
                     var7.method2326(var1, var2, var5, var4, var8.field2909);
                  }

                  if(var8.field2915 != 16) {
                     var6.method1839(var0, var1, var2, var8.field2915);
                  }

               } else if(var5 == 1) {
                  if(var8.field2914 == -1 && var8.impostorIds == null) {
                     var21 = var8.method3655(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                  }

                  var6.method1748(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class11.field109[var4], 0, var19, var20);
                  if(var8.field2891) {
                     if(var4 == 0) {
                        class5.field51[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class5.field51[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class5.field51[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field51[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2908 != 0 && null != var7) {
                     var7.method2326(var1, var2, var5, var4, var8.field2909);
                  }

               } else {
                  int var27;
                  Object var28;
                  if(var5 == 2) {
                     var27 = var4 + 1 & 3;
                     Object var29;
                     if(var8.field2914 == -1 && null == var8.impostorIds) {
                        var29 = var8.method3655(2, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.method3655(2, var27, var15, var17, var16, var18);
                     } else {
                        var29 = new class49(var3, 2, 4 + var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                        var28 = new class49(var3, 2, var27, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1748(var0, var1, var2, var16, (Renderable)var29, (Renderable)var28, class11.field108[var4], class11.field108[var27], var19, var20);
                     if(var8.field2913) {
                        if(var4 == 0) {
                           class187.field2778[var0][var1][var2] |= 585;
                           class187.field2778[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class187.field2778[var0][var1][1 + var2] |= 1170;
                           class187.field2778[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class187.field2778[var0][1 + var1][var2] |= 585;
                           class187.field2778[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class187.field2778[var0][var1][var2] |= 1170;
                           class187.field2778[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2908 != 0 && null != var7) {
                        var7.method2326(var1, var2, var5, var4, var8.field2909);
                     }

                     if(var8.field2915 != 16) {
                        var6.method1839(var0, var1, var2, var8.field2915);
                     }

                  } else if(var5 == 3) {
                     if(var8.field2914 == -1 && var8.impostorIds == null) {
                        var21 = var8.method3655(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1748(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class11.field109[var4], 0, var19, var20);
                     if(var8.field2891) {
                        if(var4 == 0) {
                           class5.field51[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class5.field51[var0][var1 + 1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class5.field51[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class5.field51[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2908 != 0 && var7 != null) {
                        var7.method2326(var1, var2, var5, var4, var8.field2909);
                     }

                  } else if(var5 == 9) {
                     if(var8.field2914 == -1 && null == var8.impostorIds) {
                        var21 = var8.method3655(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1750(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2908 != 0 && null != var7) {
                        var7.method2333(var1, var2, var9, var10, var8.field2909);
                     }

                     if(var8.field2915 != 16) {
                        var6.method1839(var0, var1, var2, var8.field2915);
                     }

                  } else if(var5 == 4) {
                     if(var8.field2914 == -1 && var8.impostorIds == null) {
                        var21 = var8.method3655(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1749(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class11.field108[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var27 = 16;
                     var22 = var6.method1766(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class15.getObjectDefinition(var22 >> 14 & 32767).field2915;
                     }

                     if(var8.field2914 == -1 && null == var8.impostorIds) {
                        var28 = var8.method3655(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 4, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1749(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class11.field108[var4], 0, class11.field117[var4] * var27, var27 * class11.field116[var4], var19, var20);
                  } else if(var5 == 6) {
                     var27 = 8;
                     var22 = var6.method1766(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class15.getObjectDefinition(var22 >> 14 & 32767).field2915 / 2;
                     }

                     if(var8.field2914 == -1 && null == var8.impostorIds) {
                        var28 = var8.method3655(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1749(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var27 * class11.field112[var4], class11.field113[var4] * var27, var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.field2914 == -1 && null == var8.impostorIds) {
                        var21 = var8.method3655(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var22 + 4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1749(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var27 = 8;
                     var22 = var6.method1766(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class15.getObjectDefinition(var22 >> 14 & 32767).field2915 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var24;
                     if(var8.field2914 == -1 && null == var8.impostorIds) {
                        var28 = var8.method3655(4, var4 + 4, var15, var17, var16, var18);
                        var24 = var8.method3655(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.field2914, true, (Renderable)null);
                        var24 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.field2914, true, (Renderable)null);
                     }

                     var6.method1749(var0, var1, var2, var16, (Renderable)var28, (Renderable)var24, 256, var4, var27 * class11.field112[var4], class11.field113[var4] * var27, var19, var20);
                  }
               }
            } else {
               if(var8.field2914 == -1 && null == var8.impostorIds) {
                  var21 = var8.method3655(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.field2914, true, (Renderable)null);
               }

               if(var21 != null && var6.method1750(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2891) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1609() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var26 = 0; var26 <= var10; ++var26) {
                        if(var22 > class5.field51[var0][var1 + var23][var26 + var2]) {
                           class5.field51[var0][var23 + var1][var2 + var26] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2908 != 0 && null != var7) {
                  var7.method2333(var1, var2, var9, var10, var8.field2909);
               }

            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1727335232"
   )
   abstract void vmethod3199(byte[] var1);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-213456903"
   )
   abstract byte[] vmethod3210();
}

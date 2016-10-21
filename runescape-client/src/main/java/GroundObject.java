import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1235486511
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -670983781
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 405133515
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -183495639
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -738628633
   )
   int field1652;
   @ObfuscatedName("t")
   @Export("renderable")
   public Renderable renderable;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "1"
   )
   public static void method2200(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2200(var0, var1, var2, var5 - 1);
         method2200(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "65"
   )
   static final void method2201(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field286 && XItemContainer.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class9.region.method2044(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class9.region.method1991(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class9.region.method2123(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class9.region.method2026(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class9.region.method1994(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class9.region.method1981(var0, var2, var3);
               var12 = class8.getObjectDefinition(var34);
               if(var12.field938 != 0) {
                  Client.collisionMaps[var0].method2417(var2, var3, var35, var36, var12.field967);
               }
            }

            if(var1 == 1) {
               class9.region.method2113(var0, var2, var3);
            }

            if(var1 == 2) {
               class9.region.method1983(var0, var2, var3);
               var12 = class8.getObjectDefinition(var34);
               if(var12.field936 + var2 > 103 || var12.field936 + var3 > 103 || var12.field937 + var2 > 103 || var12.field937 + var3 > 103) {
                  return;
               }

               if(var12.field938 != 0) {
                  Client.collisionMaps[var0].method2410(var2, var3, var12.field936, var12.field937, var36, var12.field967);
               }
            }

            if(var1 == 3) {
               class9.region.method1984(var0, var2, var3);
               var12 = class8.getObjectDefinition(var34);
               if(var12.field938 == 1) {
                  Client.collisionMaps[var0].method2420(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class9.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class8.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field936;
               var16 = var14.field937;
            } else {
               var15 = var14.field937;
               var16 = var14.field936;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = (1 + var15 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class5.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var18][var19] + var21[var17][var19] + var21[var17][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = 1073741824 + var2 + (var3 << 7) + (var4 << 14);
            if(var14.field958 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field961 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field944 == -1 && null == var14.impostorIds) {
                  var27 = var14.method828(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field938 == 1) {
                  var13.method2425(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field944 == -1 && var14.impostorIds == null) {
                     var27 = var14.method828(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                  }

                  var37.method2046(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field938 != 0) {
                     var13.method2413(var2, var3, var15, var16, var14.field967);
                  }
               } else if(var6 == 0) {
                  if(var14.field944 == -1 && null == var14.impostorIds) {
                     var27 = var14.method828(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                  }

                  var37.method1972(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field86[var5], 0, var25, var26);
                  if(var14.field938 != 0) {
                     var13.method2412(var2, var3, var6, var5, var14.field967);
                  }
               } else if(var6 == 1) {
                  if(var14.field944 == -1 && null == var14.impostorIds) {
                     var27 = var14.method828(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                  }

                  var37.method1972(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field87[var5], 0, var25, var26);
                  if(var14.field938 != 0) {
                     var13.method2412(var2, var3, var6, var5, var14.field967);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = 1 + var5 & 3;
                     Object var33;
                     if(var14.field944 == -1 && var14.impostorIds == null) {
                        var33 = var14.method828(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method828(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, 4 + var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                        var29 = new class12(var4, 2, var32, var11, var2, var3, var14.field944, true, (Renderable)null);
                     }

                     var37.method1972(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class5.field86[var5], class5.field86[var32], var25, var26);
                     if(var14.field938 != 0) {
                        var13.method2412(var2, var3, var6, var5, var14.field967);
                     }
                  } else if(var6 == 3) {
                     if(var14.field944 == -1 && null == var14.impostorIds) {
                        var27 = var14.method828(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                     }

                     var37.method1972(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field87[var5], 0, var25, var26);
                     if(var14.field938 != 0) {
                        var13.method2412(var2, var3, var6, var5, var14.field967);
                     }
                  } else if(var6 == 9) {
                     if(var14.field944 == -1 && null == var14.impostorIds) {
                        var27 = var14.method828(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                     }

                     var37.method2046(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field938 != 0) {
                        var13.method2413(var2, var3, var15, var16, var14.field967);
                     }
                  } else if(var6 == 4) {
                     if(var14.field944 == -1 && var14.impostorIds == null) {
                        var27 = var14.method828(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                     }

                     var37.method2021(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field86[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method2044(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class8.getObjectDefinition(var28 >> 14 & 32767).field945;
                        }

                        if(var14.field944 == -1 && var14.impostorIds == null) {
                           var29 = var14.method828(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                        }

                        var37.method2021(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class5.field86[var5], 0, var32 * class5.field85[var5], var32 * class5.field89[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method2044(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class8.getObjectDefinition(var28 >> 14 & 32767).field945 / 2;
                        }

                        if(var14.field944 == -1 && var14.impostorIds == null) {
                           var29 = var14.method828(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field944, true, (Renderable)null);
                        }

                        var37.method2021(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class5.field98[var5], var32 * class5.field91[var5], var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field944 == -1 && var14.impostorIds == null) {
                           var27 = var14.method828(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var28 + 4, var11, var2, var3, var14.field944, true, (Renderable)null);
                        }

                        var37.method2021(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method2044(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class8.getObjectDefinition(var28 >> 14 & 32767).field945 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field944 == -1 && var14.impostorIds == null) {
                           var29 = var14.method828(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method828(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field944, true, (Renderable)null);
                           var30 = new class12(var4, 4, 4 + var31, var11, var2, var3, var14.field944, true, (Renderable)null);
                        }

                        var37.method2021(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class5.field98[var5] * var32, class5.field91[var5] * var32, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field944 == -1 && var14.impostorIds == null) {
                  var27 = var14.method828(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field944, true, (Renderable)null);
               }

               if(null != var27) {
                  var37.method2046(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field938 != 0) {
                  var13.method2413(var2, var3, var15, var16, var14.field967);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-628360653"
   )
   public static int method2202(CharSequence var0, int var1) {
      return class93.method2129(var0, var1, true);
   }
}

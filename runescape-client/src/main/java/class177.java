import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class177 {
   @ObfuscatedName("g")
   public static final short[][] field2942 = new short[][]{{(short)6798, (short)107, (short)10283, (short)16, (short)4797, (short)7744, (short)5799, (short)4634, (short)-31839, (short)22433, (short)2983, (short)-11343, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)8741, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)25239, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)25238, (short)8742, (short)12, (short)-1506, (short)-22374, (short)7735, (short)8404, (short)1701, (short)-27106, (short)24094, (short)10153, (short)-8915, (short)4783, (short)1341, (short)16578, (short)-30533, (short)8, (short)5281, (short)10438, (short)3650, (short)-27322, (short)-21845, (short)200, (short)571, (short)908, (short)21830, (short)28946, (short)-15701, (short)-14010}, {(short)4626, (short)11146, (short)6439, (short)12, (short)4758, (short)10270}, {(short)4550, (short)4537, (short)5681, (short)5673, (short)5790, (short)6806, (short)8076, (short)4574, (short)17050, (short)0, (short)127}};
   @ObfuscatedName("l")
   public static final short[] field2943 = new short[]{(short)6798, (short)8741, (short)25238, (short)4626, (short)4550};
   @ObfuscatedName("r")
   public static final short[] field2944 = new short[]{(short)-10304, (short)9104, (short)-1, (short)-1, (short)-1};
   @ObfuscatedName("e")
   public static final short[][] field2945 = new short[][]{{(short)6554, (short)115, (short)10304, (short)28, (short)5702, (short)7756, (short)5681, (short)4510, (short)-31835, (short)22437, (short)2859, (short)-11339, (short)16, (short)5157, (short)10446, (short)3658, (short)-27314, (short)-21965, (short)472, (short)580, (short)784, (short)21966, (short)28950, (short)-15697, (short)-14002}, {(short)9104, (short)10275, (short)7595, (short)3610, (short)7975, (short)8526, (short)918, (short)-26734, (short)24466, (short)10145, (short)-6882, (short)5027, (short)1457, (short)16565, (short)-30545, (short)25486, (short)24, (short)5392, (short)10429, (short)3673, (short)-27335, (short)-21957, (short)192, (short)687, (short)412, (short)21821, (short)28835, (short)-15460, (short)-14019}, new short[0], new short[0], new short[0]};

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-977422388"
   )
   static final void method3597(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field301 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field81) {
            class5.field81 = var0;
         }

         ObjectComposition var8 = class160.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field960;
            var10 = var8.field970;
         } else {
            var9 = var8.field970;
            var10 = var8.field960;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field944 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field985 == 1) {
            var20 += 256;
         }

         if(var8.method860()) {
            class110.method2492(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field301 || var8.field944 != 0 || var8.field998 == 1 || var8.field983) {
               if(var8.field968 == -1 && var8.impostorIds == null) {
                  var21 = var8.method851(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field998 == 1 && null != var7) {
                  var7.method2513(var1, var2);
               }
            }
         } else {
            int var22;
            int var23;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field968 == -1 && null == var8.impostorIds) {
                     var21 = var8.method851(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                  }

                  var6.method2002(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     VertexNormal.field1704[var0][var1][var2] |= 2340;
                  }

                  if(var8.field998 != 0 && null != var7) {
                     var7.method2506(var1, var2, var9, var10, var8.field961);
                  }
               } else if(var5 == 0) {
                  if(var8.field968 == -1 && null == var8.impostorIds) {
                     var21 = var8.method851(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                  }

                  var6.method2000(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field90[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field976) {
                        class232.field3275[var0][var1][var2] = 50;
                        class232.field3275[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field953) {
                        VertexNormal.field1704[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field976) {
                        class232.field3275[var0][var1][var2 + 1] = 50;
                        class232.field3275[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field953) {
                        VertexNormal.field1704[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field976) {
                        class232.field3275[var0][1 + var1][var2] = 50;
                        class232.field3275[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field953) {
                        VertexNormal.field1704[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field976) {
                        class232.field3275[var0][var1][var2] = 50;
                        class232.field3275[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field953) {
                        VertexNormal.field1704[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field998 != 0 && null != var7) {
                     var7.method2517(var1, var2, var5, var4, var8.field961);
                  }

                  if(var8.field969 != 16) {
                     var6.method2127(var0, var1, var2, var8.field969);
                  }
               } else if(var5 == 1) {
                  if(var8.field968 == -1 && null == var8.impostorIds) {
                     var21 = var8.method851(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                  }

                  var6.method2000(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field91[var4], 0, var19, var20);
                  if(var8.field976) {
                     if(var4 == 0) {
                        class232.field3275[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class232.field3275[var0][1 + var1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class232.field3275[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class232.field3275[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field998 != 0 && var7 != null) {
                     var7.method2517(var1, var2, var5, var4, var8.field961);
                  }
               } else {
                  Object var27;
                  if(var5 == 2) {
                     var23 = var4 + 1 & 3;
                     Object var25;
                     if(var8.field968 == -1 && null == var8.impostorIds) {
                        var25 = var8.method851(2, var4 + 4, var15, var17, var16, var18);
                        var27 = var8.method851(2, var23, var15, var17, var16, var18);
                     } else {
                        var25 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                        var27 = new class12(var3, 2, var23, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2000(var0, var1, var2, var16, (Renderable)var25, (Renderable)var27, class5.field90[var4], class5.field90[var23], var19, var20);
                     if(var8.field953) {
                        if(var4 == 0) {
                           VertexNormal.field1704[var0][var1][var2] |= 585;
                           VertexNormal.field1704[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           VertexNormal.field1704[var0][var1][1 + var2] |= 1170;
                           VertexNormal.field1704[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           VertexNormal.field1704[var0][1 + var1][var2] |= 585;
                           VertexNormal.field1704[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           VertexNormal.field1704[var0][var1][var2] |= 1170;
                           VertexNormal.field1704[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field998 != 0 && var7 != null) {
                        var7.method2517(var1, var2, var5, var4, var8.field961);
                     }

                     if(var8.field969 != 16) {
                        var6.method2127(var0, var1, var2, var8.field969);
                     }
                  } else if(var5 == 3) {
                     if(var8.field968 == -1 && null == var8.impostorIds) {
                        var21 = var8.method851(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2000(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field91[var4], 0, var19, var20);
                     if(var8.field976) {
                        if(var4 == 0) {
                           class232.field3275[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class232.field3275[var0][var1 + 1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class232.field3275[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class232.field3275[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field998 != 0 && null != var7) {
                        var7.method2517(var1, var2, var5, var4, var8.field961);
                     }
                  } else if(var5 == 9) {
                     if(var8.field968 == -1 && var8.impostorIds == null) {
                        var21 = var8.method851(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2002(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field998 != 0 && var7 != null) {
                        var7.method2506(var1, var2, var9, var10, var8.field961);
                     }

                     if(var8.field969 != 16) {
                        var6.method2127(var0, var1, var2, var8.field969);
                     }
                  } else if(var5 == 4) {
                     if(var8.field968 == -1 && null == var8.impostorIds) {
                        var21 = var8.method851(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2001(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field90[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var23 = 16;
                     var22 = var6.method1998(var0, var1, var2);
                     if(var22 != 0) {
                        var23 = class160.getObjectDefinition(var22 >> 14 & 32767).field969;
                     }

                     if(var8.field968 == -1 && null == var8.impostorIds) {
                        var27 = var8.method851(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2001(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class5.field90[var4], 0, class5.field92[var4] * var23, class5.field98[var4] * var23, var19, var20);
                  } else if(var5 == 6) {
                     var23 = 8;
                     var22 = var6.method1998(var0, var1, var2);
                     if(var22 != 0) {
                        var23 = class160.getObjectDefinition(var22 >> 14 & 32767).field969 / 2;
                     }

                     if(var8.field968 == -1 && var8.impostorIds == null) {
                        var27 = var8.method851(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2001(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var4, var23 * class5.field94[var4], var23 * class5.field93[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field968 == -1 && null == var8.impostorIds) {
                        var21 = var8.method851(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2001(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var23 = 8;
                     var22 = var6.method1998(var0, var1, var2);
                     if(var22 != 0) {
                        var23 = class160.getObjectDefinition(var22 >> 14 & 32767).field969 / 2;
                     }

                     int var28 = 2 + var4 & 3;
                     Object var26;
                     if(var8.field968 == -1 && null == var8.impostorIds) {
                        var27 = var8.method851(4, 4 + var4, var15, var17, var16, var18);
                        var26 = var8.method851(4, 4 + var28, var15, var17, var16, var18);
                     } else {
                        var27 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field968, true, (Renderable)null);
                        var26 = new class12(var3, 4, 4 + var28, var0, var1, var2, var8.field968, true, (Renderable)null);
                     }

                     var6.method2001(var0, var1, var2, var16, (Renderable)var27, (Renderable)var26, 256, var4, class5.field94[var4] * var23, class5.field93[var4] * var23, var19, var20);
                  }
               }
            } else {
               if(var8.field968 == -1 && null == var8.impostorIds) {
                  var21 = var8.method851(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field968, true, (Renderable)null);
               }

               if(var21 != null && var6.method2002(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field976) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2458() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class232.field3275[var0][var1 + var23][var2 + var24]) {
                           class232.field3275[var0][var23 + var1][var2 + var24] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field998 != 0 && null != var7) {
                  var7.method2506(var1, var2, var9, var10, var8.field961);
               }
            }
         }
      }

   }
}

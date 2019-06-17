import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class227 {
   @ObfuscatedName("e")
   @Export("__hj_e")
   public static short[] __hj_e;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIILem;Lfy;B)V",
      garbageValue = "120"
   )
   static final void method4446(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
      if(!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
         if(var0 < Tiles.Tiles_minPlane) {
            Tiles.Tiles_minPlane = var0;
         }

         ObjectDefinition var8 = class50.getObjectDefinition(var3);
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
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = Tiles.Tiles_heights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         long var19 = FontName.method5637(var1, var2, 2, var8.int1 == 0, var3);
         int var21 = var5 + (var4 << 6);
         if(var8.int3 == 1) {
            var21 += 256;
         }

         int var22;
         int var23;
         if(var8.__t_424()) {
            ObjectSound var24 = new ObjectSound();
            var24.__f = var0;
            var24.__q = var1 * 128;
            var24.__w = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var24.__o = (var22 + var1) * 128;
            var24.__u = (var23 + var2) * 128;
            var24.soundEffectId = var8.ambientSoundId;
            var24.__g = var8.int4 * 128;
            var24.__x = var8.int5;
            var24.__d = var8.int6;
            var24.soundEffectIds = var8.__ax;
            if(var8.transforms != null) {
               var24.obj = var8;
               var24.set();
            }

            ObjectSound.objectSounds.addFirst(var24);
            if(var24.soundEffectIds != null) {
               var24.surfaceOffsetY = var24.__x + (int)(Math.random() * (double)(var24.__d - var24.__x));
            }
         }

         Object var31;
         if(var5 == 22) {
            if(!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
               if(var8.animationId == -1 && var8.transforms == null) {
                  var31 = var8.__l_423(22, var4, var15, var17, var16, var18);
               } else {
                  var31 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
               }

               var6.newFloorDecoration(var0, var1, var2, var16, (Entity)var31, var19, var21);
               if(var8.interactType == 1 && var7 != null) {
                  var7.__o_286(var1, var2);
               }
            }
         } else {
            int var25;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var31 = var8.__l_423(var5, var4, var15, var17, var16, var18);
                  } else {
                     var31 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.__d_238(var0, var1, var2, var16, 1, 1, (Entity)var31, 0, var19, var21);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     Tiles.__bq_a[var0][var1][var2] |= 2340;
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.__q_284(var1, var2, var9, var10, var8.boolean1);
                  }
               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var31 = var8.__l_423(0, var4, var15, var17, var16, var18);
                  } else {
                     var31 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var31, (Entity)null, Tiles.__bq_t[var4], 0, var19, var21);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        Tiles.__bq_l[var0][var1][var2] = 50;
                        Tiles.__bq_l[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        Tiles.__bq_a[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        Tiles.__bq_l[var0][var1][var2 + 1] = 50;
                        Tiles.__bq_l[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        Tiles.__bq_a[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        Tiles.__bq_l[var0][var1 + 1][var2] = 50;
                        Tiles.__bq_l[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        Tiles.__bq_a[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        Tiles.__bq_l[var0][var1][var2] = 50;
                        Tiles.__bq_l[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        Tiles.__bq_a[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.__f_283(var1, var2, var5, var4, var8.boolean1);
                  }

                  if(var8.int2 != 16) {
                     var6.__y_241(var0, var1, var2, var8.int2);
                  }
               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var31 = var8.__l_423(1, var4, var15, var17, var16, var18);
                  } else {
                     var31 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var31, (Entity)null, Tiles.__bq_y[var4], 0, var19, var21);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        Tiles.__bq_l[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        Tiles.__bq_l[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        Tiles.__bq_l[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        Tiles.__bq_l[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.__f_283(var1, var2, var5, var4, var8.boolean1);
                  }
               } else if(var5 == 2) {
                  var25 = var4 + 1 & 3;
                  Object var26;
                  Object var27;
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var26 = var8.__l_423(2, var4 + 4, var15, var17, var16, var18);
                     var27 = var8.__l_423(2, var25, var15, var17, var16, var18);
                  } else {
                     var26 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
                     var27 = new DynamicObject(var3, 2, var25, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var26, (Entity)var27, Tiles.__bq_t[var4], Tiles.__bq_t[var25], var19, var21);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        Tiles.__bq_a[var0][var1][var2] |= 585;
                        Tiles.__bq_a[var0][var1][1 + var2] |= 1170;
                     } else if(var4 == 1) {
                        Tiles.__bq_a[var0][var1][1 + var2] |= 1170;
                        Tiles.__bq_a[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        Tiles.__bq_a[var0][var1 + 1][var2] |= 585;
                        Tiles.__bq_a[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        Tiles.__bq_a[var0][var1][var2] |= 1170;
                        Tiles.__bq_a[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.__f_283(var1, var2, var5, var4, var8.boolean1);
                  }

                  if(var8.int2 != 16) {
                     var6.__y_241(var0, var1, var2, var8.int2);
                  }
               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var31 = var8.__l_423(3, var4, var15, var17, var16, var18);
                  } else {
                     var31 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var31, (Entity)null, Tiles.__bq_y[var4], 0, var19, var21);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        Tiles.__bq_l[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        Tiles.__bq_l[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        Tiles.__bq_l[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        Tiles.__bq_l[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.__f_283(var1, var2, var5, var4, var8.boolean1);
                  }
               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var31 = var8.__l_423(var5, var4, var15, var17, var16, var18);
                  } else {
                     var31 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.__d_238(var0, var1, var2, var16, 1, 1, (Entity)var31, 0, var19, var21);
                  if(var8.interactType != 0 && var7 != null) {
                     var7.__q_284(var1, var2, var9, var10, var8.boolean1);
                  }

                  if(var8.int2 != 16) {
                     var6.__y_241(var0, var1, var2, var8.int2);
                  }
               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.transforms == null) {
                     var31 = var8.__l_423(4, var4, var15, var17, var16, var18);
                  } else {
                     var31 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                  }

                  var6.newWallDecoration(var0, var1, var2, var16, (Entity)var31, (Entity)null, Tiles.__bq_t[var4], 0, 0, 0, var19, var21);
               } else {
                  Object var28;
                  long var32;
                  if(var5 == 5) {
                     var25 = 16;
                     var32 = var6.__ar_244(var0, var1, var2);
                     if(var32 != 0L) {
                        var25 = class50.getObjectDefinition(HitSplatDefinition.method4972(var32)).int2;
                     }

                     if(var8.animationId == -1 && var8.transforms == null) {
                        var28 = var8.__l_423(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Entity)var28, (Entity)null, Tiles.__bq_t[var4], 0, var25 * Tiles.__bq_h[var4], var25 * Tiles.__bq_b[var4], var19, var21);
                  } else if(var5 == 6) {
                     var25 = 8;
                     var32 = var6.__ar_244(var0, var1, var2);
                     if(var32 != 0L) {
                        var25 = class50.getObjectDefinition(HitSplatDefinition.method4972(var32)).int2 / 2;
                     }

                     if(var8.animationId == -1 && var8.transforms == null) {
                        var28 = var8.__l_423(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Entity)var28, (Entity)null, 256, var4, var25 * Tiles.__bq_c[var4], var25 * Tiles.__bq_r[var4], var19, var21);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.transforms == null) {
                        var31 = var8.__l_423(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var31 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Entity)var31, (Entity)null, 256, var22, 0, 0, var19, var21);
                  } else if(var5 == 8) {
                     var25 = 8;
                     var32 = var6.__ar_244(var0, var1, var2);
                     if(var32 != 0L) {
                        var25 = class50.getObjectDefinition(HitSplatDefinition.method4972(var32)).int2 / 2;
                     }

                     int var29 = var4 + 2 & 3;
                     Object var30;
                     if(var8.animationId == -1 && var8.transforms == null) {
                        var28 = var8.__l_423(4, var4 + 4, var15, var17, var16, var18);
                        var30 = var8.__l_423(4, var29 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
                        var30 = new DynamicObject(var3, 4, var29 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Entity)var28, (Entity)var30, 256, var4, var25 * Tiles.__bq_c[var4], var25 * Tiles.__bq_r[var4], var19, var21);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.transforms == null) {
                  var31 = var8.__l_423(10, var4, var15, var17, var16, var18);
               } else {
                  var31 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
               }

               if(var31 != null && var6.__d_238(var0, var1, var2, var16, var9, var10, (Entity)var31, var5 == 11?256:0, var19, var21) && var8.clipped) {
                  var22 = 15;
                  if(var31 instanceof Model) {
                     var22 = ((Model)var31).__l_233() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(var23 = 0; var23 <= var9; ++var23) {
                     for(var25 = 0; var25 <= var10; ++var25) {
                        if(var22 > Tiles.__bq_l[var0][var23 + var1][var25 + var2]) {
                           Tiles.__bq_l[var0][var23 + var1][var25 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.__q_284(var1, var2, var9, var10, var8.boolean1);
               }
            }
         }
      }

   }
}

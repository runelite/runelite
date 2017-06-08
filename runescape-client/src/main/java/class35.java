import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class35 {
   @ObfuscatedName("b")
   static String[] field499;
   @ObfuscatedName("p")
   static final class35 field500;
   @ObfuscatedName("n")
   static final class35 field504;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1569918211
   )
   final int field505;

   static {
      field504 = new class35(0);
      field500 = new class35(1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class35(int var1) {
      this.field505 = var1;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "762130657"
   )
   static final void method492(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field918 && class92.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class61.region.method2701(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class61.region.method2702(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class61.region.method2703(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class61.region.method2704(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class61.region.method2770(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class61.region.method2832(var0, var2, var3);
               var12 = class61.getObjectDefinition(var34);
               if(var12.field3459 != 0) {
                  Client.collisionMaps[var0].method3022(var2, var3, var35, var36, var12.field3460);
               }
            }

            if(var1 == 1) {
               class61.region.method2693(var0, var2, var3);
            }

            if(var1 == 2) {
               class61.region.method2772(var0, var2, var3);
               var12 = class61.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var12.sizeX + var3 > 103 || var2 + var12.sizeY > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field3459 != 0) {
                  Client.collisionMaps[var0].method3015(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field3460);
               }
            }

            if(var1 == 3) {
               class61.region.method2840(var0, var2, var3);
               var12 = class61.getObjectDefinition(var34);
               if(var12.field3459 == 1) {
                  Client.collisionMaps[var0].method3025(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class61.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class61.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (var15 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var17][var19] + var21[var18][var19] + var21[var17][var20] + var21[var18][var20] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.field3464 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field3482 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4560(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class100(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field3459 == 1) {
                  var13.method3037(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4560(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class100(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2685(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field3459 != 0) {
                     var13.method3018(var2, var3, var15, var16, var14.field3460);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4560(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class100(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2683(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field744[var5], 0, var25, var26);
                  if(var14.field3459 != 0) {
                     var13.method3020(var2, var3, var6, var5, var14.field3460);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4560(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class100(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2683(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field745[var5], 0, var25, var26);
                  if(var14.field3459 != 0) {
                     var13.method3020(var2, var3, var6, var5, var14.field3460);
                  }
               } else {
                  Object var29;
                  int var33;
                  if(var6 == 2) {
                     var33 = var5 + 1 & 3;
                     Object var32;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method4560(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4560(2, var33, var21, var23, var22, var24);
                     } else {
                        var32 = new class100(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class100(var4, 2, var33, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2683(var0, var2, var3, var22, (Renderable)var32, (Renderable)var29, class61.field744[var5], class61.field744[var33], var25, var26);
                     if(var14.field3459 != 0) {
                        var13.method3020(var2, var3, var6, var5, var14.field3460);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4560(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class100(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2683(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field745[var5], 0, var25, var26);
                     if(var14.field3459 != 0) {
                        var13.method3020(var2, var3, var6, var5, var14.field3460);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4560(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class100(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2685(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field3459 != 0) {
                        var13.method3018(var2, var3, var15, var16, var14.field3460);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4560(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class100(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2684(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field744[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var33 = 16;
                        var28 = var37.method2701(var0, var2, var3);
                        if(var28 != 0) {
                           var33 = class61.getObjectDefinition(var28 >> 14 & 32767).field3466;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4560(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class100(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2684(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field744[var5], 0, class61.field746[var5] * var33, var33 * class61.field752[var5], var25, var26);
                     } else if(var6 == 6) {
                        var33 = 8;
                        var28 = var37.method2701(var0, var2, var3);
                        if(var28 != 0) {
                           var33 = class61.getObjectDefinition(var28 >> 14 & 32767).field3466 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4560(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class100(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2684(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, class61.field738[var5] * var33, class61.field749[var5] * var33, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4560(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class100(var4, 4, var28 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2684(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var33 = 8;
                        var28 = var37.method2701(var0, var2, var3);
                        if(var28 != 0) {
                           var33 = class61.getObjectDefinition(var28 >> 14 & 32767).field3466 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4560(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4560(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class100(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class100(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2684(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var33 * class61.field738[var5], var33 * class61.field749[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4560(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class100(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2685(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field3459 != 0) {
                  var13.method3018(var2, var3, var15, var16, var14.field3460);
               }
            }
         }
      }

   }
}

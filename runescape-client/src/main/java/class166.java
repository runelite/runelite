import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class166 extends CacheableNode {
   @ObfuscatedName("n")
   public final int[] field2164;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 29490981
   )
   public final int field2165;
   @ObfuscatedName("q")
   public final int[] field2166;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1645405243
   )
   public final int field2167;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "-29"
   )
   static final void method3132(class68 var0) {
      var0.field1125 = false;
      if(var0.field1122 != null) {
         var0.field1122.field1156 = 0;
      }

      for(class68 var1 = var0.vmethod3102(); var1 != null; var1 = var0.vmethod3091()) {
         method3132(var1);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1158062598"
   )
   public boolean method3133(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2166.length) {
         int var3 = this.field2166[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2164[var2]) {
            return true;
         }
      }

      return false;
   }

   class166(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2167 = var1;
      this.field2165 = var2;
      this.field2164 = var3;
      this.field2166 = var4;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1412669661"
   )
   static final void method3137(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field285 && Client.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class172.region.method1747(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class172.region.method1805(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class172.region.method1818(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class172.region.method1750(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class172.region.method1751(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class172.region.method1738(var0, var2, var3);
               var12 = class26.getObjectDefinition(var34);
               if(var12.field2936 != 0) {
                  Client.collisionMaps[var0].method2263(var2, var3, var35, var36, var12.field2942);
               }
            }

            if(var1 == 1) {
               class172.region.method1720(var0, var2, var3);
            }

            if(var1 == 2) {
               class172.region.method1740(var0, var2, var3);
               var12 = class26.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var3 + var12.sizeX > 103 || var12.sizeY + var2 > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field2936 != 0) {
                  Client.collisionMaps[var0].method2262(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field2942);
               }
            }

            if(var1 == 3) {
               class172.region.method1741(var0, var2, var3);
               var12 = class26.getObjectDefinition(var34);
               if(var12.field2936 == 1) {
                  Client.collisionMaps[var0].method2258(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class172.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class26.getObjectDefinition(var4);
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
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = (var15 + 1 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class10.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var17][var19] + var21[var18][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(var14.field2943 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field2964 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method3685(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field2936 == 1) {
                  var13.method2253(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method3685(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1746(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field2936 != 0) {
                     var13.method2252(var2, var3, var15, var16, var14.field2942);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method3685(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1729(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class10.field99[var5], 0, var25, var26);
                  if(var14.field2936 != 0) {
                     var13.method2254(var2, var3, var6, var5, var14.field2942);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method3685(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class49(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1729(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class10.field101[var5], 0, var25, var26);
                  if(var14.field2936 != 0) {
                     var13.method2254(var2, var3, var6, var5, var14.field2942);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var33;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var33 = var14.method3685(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method3685(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class49(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1729(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class10.field99[var5], class10.field99[var32], var25, var26);
                     if(var14.field2936 != 0) {
                        var13.method2254(var2, var3, var6, var5, var14.field2942);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method3685(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1729(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class10.field101[var5], 0, var25, var26);
                     if(var14.field2936 != 0) {
                        var13.method2254(var2, var3, var6, var5, var14.field2942);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method3685(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1746(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field2936 != 0) {
                        var13.method2252(var2, var3, var15, var16, var14.field2942);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method3685(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1730(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class10.field99[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method1747(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class26.getObjectDefinition(var28 >> 14 & 32767).field2951;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3685(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1730(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class10.field99[var5], 0, var32 * class10.field100[var5], var32 * class10.field107[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method1747(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class26.getObjectDefinition(var28 >> 14 & 32767).field2951 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3685(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1730(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class10.field110[var5], var32 * class10.field103[var5], var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method3685(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class49(var4, 4, var28 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1730(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method1747(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class26.getObjectDefinition(var28 >> 14 & 32767).field2951 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3685(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method3685(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class49(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1730(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class10.field110[var5], class10.field103[var5] * var32, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method3685(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class49(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method1746(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2936 != 0) {
                  var13.method2252(var2, var3, var15, var16, var14.field2942);
               }
            }
         }
      }

   }
}

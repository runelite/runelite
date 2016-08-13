import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class20 extends Node {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1309296437
   )
   int field577;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -198715103
   )
   int field578;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -554880233
   )
   int field579;
   @ObfuscatedName("by")
   static class171 field581;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2103373921
   )
   int field583;
   @ObfuscatedName("bf")
   static FontMetrics field584;
   @ObfuscatedName("nm")
   static class58 field585;

   class20(int var1, int var2, int var3, int var4) {
      this.field583 = var1;
      this.field578 = var2;
      this.field579 = var3;
      this.field577 = var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "6"
   )
   static void method568(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class22.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field848 = 0;
            var0.actionAnimationDisable = var2;
            var0.field867 = 0;
         }

         if(var3 == 2) {
            var0.field867 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class22.getAnimation(var1).field1023 >= class22.getAnimation(var0.animation).field1023) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field848 = 0;
         var0.actionAnimationDisable = var2;
         var0.field867 = 0;
         var0.field839 = var0.field849;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;B)V",
      garbageValue = "-76"
   )
   public static void method570(class170 var0, class170 var1) {
      class49.field1106 = var0;
      class49.field1101 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-850471339"
   )
   void method571(int var1, int var2, int var3, int var4) {
      this.field583 = var1;
      this.field578 = var2;
      this.field579 = var3;
      this.field577 = var4;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "611743624"
   )
   static final void method572(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field301 && var0 != VertexNormal.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class136.region.method1998(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class136.region.method2018(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class136.region.method2019(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class136.region.method2014(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class136.region.method2081(var0, var2, var3, var7);
            int var12 = var7 >> 14 & 32767;
            int var13 = var11 & 31;
            int var14 = var11 >> 6 & 3;
            ObjectComposition var15;
            if(var1 == 0) {
               class136.region.method2008(var0, var2, var3);
               var15 = class160.getObjectDefinition(var12);
               if(var15.field998 != 0) {
                  Client.collisionMaps[var0].method2495(var2, var3, var13, var14, var15.field961);
               }
            }

            if(var1 == 1) {
               class136.region.method2009(var0, var2, var3);
            }

            if(var1 == 2) {
               class136.region.method2010(var0, var2, var3);
               var15 = class160.getObjectDefinition(var12);
               if(var2 + var15.field960 > 103 || var15.field960 + var3 > 103 || var15.field970 + var2 > 103 || var3 + var15.field970 > 103) {
                  return;
               }

               if(var15.field998 != 0) {
                  Client.collisionMaps[var0].method2501(var2, var3, var15.field960, var15.field970, var14, var15.field961);
               }
            }

            if(var1 == 3) {
               class136.region.method2100(var0, var2, var3);
               var15 = class160.getObjectDefinition(var12);
               if(var15.field998 == 1) {
                  Client.collisionMaps[var0].method2503(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var33 = class136.region;
            CollisionData var34 = Client.collisionMaps[var0];
            ObjectComposition var35 = class160.getObjectDefinition(var4);
            int var16;
            int var36;
            if(var5 != 1 && var5 != 3) {
               var36 = var35.field960;
               var16 = var35.field970;
            } else {
               var36 = var35.field970;
               var16 = var35.field960;
            }

            int var17;
            int var18;
            if(var36 + var2 <= 104) {
               var17 = (var36 >> 1) + var2;
               var18 = var2 + (1 + var36 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (1 + var16 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class5.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var17][var19] + var21[var18][var19] >> 2;
            int var23 = (var2 << 7) + (var36 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = 1073741824 + var2 + (var3 << 7) + (var4 << 14);
            if(var35.field944 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var35.field985 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var35.field968 == -1 && null == var35.impostorIds) {
                  var27 = var35.method852(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
               }

               var33.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var35.field998 == 1) {
                  var34.method2513(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var35.field968 == -1 && null == var35.impostorIds) {
                     var27 = var35.method852(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                  }

                  var33.method2002(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var35.field998 != 0) {
                     var34.method2506(var2, var3, var36, var16, var35.field961);
                  }
               } else if(var6 == 0) {
                  if(var35.field968 == -1 && null == var35.impostorIds) {
                     var27 = var35.method852(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                  }

                  var33.method2000(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field90[var5], 0, var25, var26);
                  if(var35.field998 != 0) {
                     var34.method2517(var2, var3, var6, var5, var35.field961);
                  }
               } else if(var6 == 1) {
                  if(var35.field968 == -1 && var35.impostorIds == null) {
                     var27 = var35.method852(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                  }

                  var33.method2000(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field91[var5], 0, var25, var26);
                  if(var35.field998 != 0) {
                     var34.method2517(var2, var3, var6, var5, var35.field961);
                  }
               } else {
                  int var28;
                  Object var29;
                  if(var6 == 2) {
                     var28 = var5 + 1 & 3;
                     Object var30;
                     if(var35.field968 == -1 && null == var35.impostorIds) {
                        var30 = var35.method852(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var35.method852(2, var28, var21, var23, var22, var24);
                     } else {
                        var30 = new class12(var4, 2, var5 + 4, var11, var2, var3, var35.field968, true, (Renderable)null);
                        var29 = new class12(var4, 2, var28, var11, var2, var3, var35.field968, true, (Renderable)null);
                     }

                     var33.method2000(var0, var2, var3, var22, (Renderable)var30, (Renderable)var29, class5.field90[var5], class5.field90[var28], var25, var26);
                     if(var35.field998 != 0) {
                        var34.method2517(var2, var3, var6, var5, var35.field961);
                     }
                  } else if(var6 == 3) {
                     if(var35.field968 == -1 && var35.impostorIds == null) {
                        var27 = var35.method852(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                     }

                     var33.method2000(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field91[var5], 0, var25, var26);
                     if(var35.field998 != 0) {
                        var34.method2517(var2, var3, var6, var5, var35.field961);
                     }
                  } else if(var6 == 9) {
                     if(var35.field968 == -1 && null == var35.impostorIds) {
                        var27 = var35.method852(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                     }

                     var33.method2002(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var35.field998 != 0) {
                        var34.method2506(var2, var3, var36, var16, var35.field961);
                     }
                  } else if(var6 == 4) {
                     if(var35.field968 == -1 && var35.impostorIds == null) {
                        var27 = var35.method852(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                     }

                     var33.method2001(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class5.field90[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var37;
                     if(var6 == 5) {
                        var28 = 16;
                        var37 = var33.method1998(var0, var2, var3);
                        if(var37 != 0) {
                           var28 = class160.getObjectDefinition(var37 >> 14 & 32767).field969;
                        }

                        if(var35.field968 == -1 && null == var35.impostorIds) {
                           var29 = var35.method852(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                        }

                        var33.method2001(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class5.field90[var5], 0, var28 * class5.field92[var5], var28 * class5.field98[var5], var25, var26);
                     } else if(var6 == 6) {
                        var28 = 8;
                        var37 = var33.method1998(var0, var2, var3);
                        if(var37 != 0) {
                           var28 = class160.getObjectDefinition(var37 >> 14 & 32767).field969 / 2;
                        }

                        if(var35.field968 == -1 && null == var35.impostorIds) {
                           var29 = var35.method852(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var35.field968, true, (Renderable)null);
                        }

                        var33.method2001(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var28 * class5.field94[var5], class5.field93[var5] * var28, var25, var26);
                     } else if(var6 == 7) {
                        var37 = 2 + var5 & 3;
                        if(var35.field968 == -1 && null == var35.impostorIds) {
                           var27 = var35.method852(4, var37 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, 4 + var37, var11, var2, var3, var35.field968, true, (Renderable)null);
                        }

                        var33.method2001(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var37, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var28 = 8;
                        var37 = var33.method1998(var0, var2, var3);
                        if(var37 != 0) {
                           var28 = class160.getObjectDefinition(var37 >> 14 & 32767).field969 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var32;
                        if(var35.field968 == -1 && var35.impostorIds == null) {
                           var29 = var35.method852(4, var5 + 4, var21, var23, var22, var24);
                           var32 = var35.method852(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var35.field968, true, (Renderable)null);
                           var32 = new class12(var4, 4, 4 + var31, var11, var2, var3, var35.field968, true, (Renderable)null);
                        }

                        var33.method2001(var0, var2, var3, var22, (Renderable)var29, (Renderable)var32, 256, var5, var28 * class5.field94[var5], class5.field93[var5] * var28, var25, var26);
                     }
                  }
               }
            } else {
               if(var35.field968 == -1 && var35.impostorIds == null) {
                  var27 = var35.method852(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var35.field968, true, (Renderable)null);
               }

               if(var27 != null) {
                  var33.method2002(var0, var2, var3, var22, var36, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var35.field998 != 0) {
                  var34.method2506(var2, var3, var36, var16, var35.field961);
               }
            }
         }
      }

   }
}

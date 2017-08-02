import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public final class class29 {
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = -1027690585
   )
   static int field410;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   final class41 this$0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 649367967
   )
   int field408;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2130335777
   )
   int field407;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 76749019
   )
   int field406;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1649780359
   )
   int field409;

   @ObfuscatedSignature(
      signature = "(Lae;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "651969233"
   )
   static final int method243() {
      return class134.field1953;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Lho;IIIB)V",
      garbageValue = "-109"
   )
   static final void method242(Widget var0, int var1, int var2, int var3) {
      class210 var4 = var0.method3920(false);
      if(var4 != null) {
         if(Client.field1138 < 3) {
            Player.compass.method5022(var1, var2, var4.field2569, var4.field2566, 25, 25, Client.mapAngle, 256, var4.field2568, var4.field2567);
         } else {
            Rasterizer2D.method4843(var1, var2, 0, var4.field2568, var4.field2567);
         }

      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "24"
   )
   static final void method240(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class10.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class19.region.method2760(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class19.region.method2616(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class19.region.method2645(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class19.region.method2646(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class19.region.method2715(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class19.region.method2634(var0, var2, var3);
               var12 = class169.getObjectDefinition(var34);
               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var35, var36, var12.field3439);
               }
            }

            if(var1 == 1) {
               class19.region.method2635(var0, var2, var3);
            }

            if(var1 == 2) {
               class19.region.method2636(var0, var2, var3);
               var12 = class169.getObjectDefinition(var34);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.interactType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field3439);
               }
            }

            if(var1 == 3) {
               class19.region.method2652(var0, var2, var3);
               var12 = class169.getObjectDefinition(var34);
               if(var12.interactType == 1) {
                  Client.collisionMaps[var0].unblock(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class19.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class169.getObjectDefinition(var4);
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
               var17 = var2 + (var15 >> 1);
               var18 = var2 + (var15 + 1 >> 1);
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

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
            if(var14.field3429 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field3431 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4404(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.interactType == 1) {
                  var13.block(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4404(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2627(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addObject(var2, var3, var15, var16, var14.field3439);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4404(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field763[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addWall(var2, var3, var6, var5, var14.field3439);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4404(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field757[var5], 0, var25, var26);
                  if(var14.interactType != 0) {
                     var13.addWall(var2, var3, var6, var5, var14.field3439);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method4404(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4404(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class61.field763[var5], class61.field763[var32], var25, var26);
                     if(var14.interactType != 0) {
                        var13.addWall(var2, var3, var6, var5, var14.field3439);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4404(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundary(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field757[var5], 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addWall(var2, var3, var6, var5, var14.field3439);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4404(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2627(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.interactType != 0) {
                        var13.addObject(var2, var3, var15, var16, var14.field3439);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4404(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field763[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2760(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class169.getObjectDefinition(var33 >> 14 & 32767).field3447;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4404(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field763[var5], 0, var32 * class61.field758[var5], var32 * class61.field759[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2760(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class169.getObjectDefinition(var33 >> 14 & 32767).field3447 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4404(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class61.field760[var5], var32 * class61.field761[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4404(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2760(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class169.getObjectDefinition(var33 >> 14 & 32767).field3447 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4404(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4404(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.addBoundaryDecoration(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, var32 * class61.field760[var5], var32 * class61.field761[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4404(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2627(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.interactType != 0) {
                  var13.addObject(var2, var3, var15, var16, var14.field3439);
               }
            }
         }
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "31"
   )
   static final void method241(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class9.loadWidget(var0)) {
         class2.method7(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}

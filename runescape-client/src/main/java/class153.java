import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class153 extends RuntimeException {
   @ObfuscatedName("m")
   public static Applet field2133;
   @ObfuscatedName("p")
   public static String field2136;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -526410271
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("j")
   String field2134;
   @ObfuscatedName("v")
   Throwable field2137;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lia;",
      garbageValue = "1486123415"
   )
   public static InvType method3052(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3340.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIILec;Lfa;I)V",
      garbageValue = "-1467080400"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field725) {
            class61.field725 = var0;
         }

         ObjectComposition var8 = class24.getObjectDefinition(var3);
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

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3506 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3527 == 1) {
            var20 += 256;
         }

         if(var8.method4706()) {
            class259.method4645(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3506 != 0 || var8.interactType == 1 || var8.field3525) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.interactType == 1 && var7 != null) {
                  var7.block(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2791(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     ItemLayer.field1710[var0][var1][var2] |= 2340;
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3505);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field723[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class61.field738[var0][var1][var2] = 50;
                        class61.field738[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        ItemLayer.field1710[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class61.field738[var0][var1][var2 + 1] = 50;
                        class61.field738[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        ItemLayer.field1710[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class61.field738[var0][var1 + 1][var2] = 50;
                        class61.field738[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        ItemLayer.field1710[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class61.field738[var0][var1][var2] = 50;
                        class61.field738[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        ItemLayer.field1710[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3505);
                  }

                  if(var8.field3491 != 16) {
                     var6.method2863(var0, var1, var2, var8.field3491);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field732[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class61.field738[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class61.field738[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class61.field738[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class61.field738[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3505);
                  }

               } else {
                  int var26;
                  Object var28;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.getModel(2, var26, var15, var17, var16, var18);
                     } else {
                        var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field723[var4], class61.field723[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           ItemLayer.field1710[var0][var1][var2] |= 585;
                           ItemLayer.field1710[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           ItemLayer.field1710[var0][var1][1 + var2] |= 1170;
                           ItemLayer.field1710[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           ItemLayer.field1710[var0][var1 + 1][var2] |= 585;
                           ItemLayer.field1710[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           ItemLayer.field1710[var0][var1][var2] |= 1170;
                           ItemLayer.field1710[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3505);
                     }

                     if(var8.field3491 != 16) {
                        var6.method2863(var0, var1, var2, var8.field3491);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field732[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class61.field738[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class61.field738[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class61.field738[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class61.field738[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3505);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2791(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.interactType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.field3505);
                     }

                     if(var8.field3491 != 16) {
                        var6.method2863(var0, var1, var2, var8.field3491);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field723[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method2814(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class24.getObjectDefinition(var22 >> 14 & 32767).field3491;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field723[var4], 0, var26 * class61.field733[var4], var26 * class61.field734[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method2814(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class24.getObjectDefinition(var22 >> 14 & 32767).field3491 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field724[var4], var26 * class61.field736[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.method2814(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class24.getObjectDefinition(var22 >> 14 & 32767).field3491 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field724[var4], var26 * class61.field736[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2791(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2683() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class61.field738[var0][var23 + var1][var24 + var2]) {
                           class61.field738[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3505);
               }

            }
         }
      }
   }
}

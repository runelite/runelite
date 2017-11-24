import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class66 extends class203 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -305693375
   )
   int field788;
   @ObfuscatedName("x")
   String field785;
   @ObfuscatedName("k")
   short field786;

   class66(String var1, int var2) {
      this.field788 = (int)(ServerPacket.currentTimeMs() / 1000L);
      this.field785 = var1;
      this.field786 = (short)var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1407615488"
   )
   static void method1113() {
      for(class81 var0 = (class81)class81.field1248.getFront(); var0 != null; var0 = (class81)class81.field1248.getNext()) {
         if(var0.field1253 != null) {
            class70.field821.method1954(var0.field1253);
            var0.field1253 = null;
         }

         if(var0.field1250 != null) {
            class70.field821.method1954(var0.field1250);
            var0.field1250 = null;
         }
      }

      class81.field1248.clear();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIILed;Lfb;I)V",
      garbageValue = "1982861274"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field735) {
            class61.field735 = var0;
         }

         ObjectComposition var8 = class3.getObjectDefinition(var3);
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
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3518 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3539 == 1) {
            var20 += 256;
         }

         if(var8.method4691()) {
            World.method1615(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3518 != 0 || var8.interactType == 1 || var8.field3530) {
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

                  var6.method2807(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class10.field242[var0][var1][var2] |= 2340;
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3517);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field733[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        ScriptState.field745[var0][var1][var2] = 50;
                        ScriptState.field745[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class10.field242[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        ScriptState.field745[var0][var1][var2 + 1] = 50;
                        ScriptState.field745[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class10.field242[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        ScriptState.field745[var0][var1 + 1][var2] = 50;
                        ScriptState.field745[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class10.field242[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        ScriptState.field745[var0][var1][var2] = 50;
                        ScriptState.field745[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        class10.field242[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3517);
                  }

                  if(var8.field3516 != 16) {
                     var6.method2880(var0, var1, var2, var8.field3516);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field729[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        ScriptState.field745[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        ScriptState.field745[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        ScriptState.field745[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        ScriptState.field745[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3517);
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

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field733[var4], class61.field733[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           class10.field242[var0][var1][var2] |= 585;
                           class10.field242[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class10.field242[var0][var1][var2 + 1] |= 1170;
                           class10.field242[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class10.field242[var0][var1 + 1][var2] |= 585;
                           class10.field242[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class10.field242[var0][var1][var2] |= 1170;
                           class10.field242[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3517);
                     }

                     if(var8.field3516 != 16) {
                        var6.method2880(var0, var1, var2, var8.field3516);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field729[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           ScriptState.field745[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           ScriptState.field745[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           ScriptState.field745[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           ScriptState.field745[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3517);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2807(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.interactType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.field3517);
                     }

                     if(var8.field3516 != 16) {
                        var6.method2880(var0, var1, var2, var8.field3516);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field733[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method2823(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class3.getObjectDefinition(var22 >> 14 & 32767).field3516;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field733[var4], 0, var26 * class61.field730[var4], var26 * class61.field731[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method2823(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class3.getObjectDefinition(var22 >> 14 & 32767).field3516 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field723[var4], var26 * class61.field721[var4], var19, var20);
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
                     var22 = var6.method2823(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class3.getObjectDefinition(var22 >> 14 & 32767).field3516 / 2;
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

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field723[var4], var26 * class61.field721[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2807(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2686() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > ScriptState.field745[var0][var23 + var1][var24 + var2]) {
                           ScriptState.field745[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3517);
               }

            }
         }
      }
   }
}

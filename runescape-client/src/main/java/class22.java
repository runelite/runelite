import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class22 extends class28 {
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -428306949
   )
   static int field322;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;Lgj;I)V",
      garbageValue = "-635773537"
   )
   void method172(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field466.field467) {
         throw new IllegalStateException("");
      } else {
         super.field379 = var2.readUnsignedByte();
         super.field381 = var2.readUnsignedByte();
         super.field384 = var2.readUnsignedShort();
         super.field376 = var2.readUnsignedShort();
         super.field377 = var2.readUnsignedShort();
         super.field378 = var2.readUnsignedShort();
         super.field381 = Math.min(super.field381, 4);
         super.field380 = new short[1][64][64];
         super.field382 = new short[super.field381][64][64];
         super.field386 = new byte[super.field381][64][64];
         super.field383 = new byte[super.field381][64][64];
         super.field385 = new class31[super.field381][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field460.field462) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field377 && var5 == super.field378) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method250(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field377 == super.field377 && super.field378 == var2.field378;
      }
   }

   public int hashCode() {
      return super.field377 | super.field378 << 8;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIILee;Lfg;B)V",
      garbageValue = "0"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field686) {
            class61.field686 = var0;
         }

         ObjectComposition var8 = TextureProvider.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.width;
            var10 = var8.length;
         } else {
            var9 = var8.length;
            var10 = var8.width;
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
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.int1 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.supportItems == 1) {
            var20 += 256;
         }

         if(var8.method4817()) {
            WorldComparator.method83(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.clipType == 1 || var8.obstructsGround) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.clipType == 1 && var7 != null) {
                  var7.method3260(var1, var2);
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

                  var6.method2823(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class61.field690[var0][var1][var2] |= 2340;
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field698[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class29.field392[var0][var1][var2] = 50;
                        class29.field392[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field690[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class29.field392[var0][var1][var2 + 1] = 50;
                        class29.field392[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field690[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class29.field392[var0][var1 + 1][var2] = 50;
                        class29.field392[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field690[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class29.field392[var0][var1][var2] = 50;
                        class29.field392[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field690[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3270(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2930(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field697[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class29.field392[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class29.field392[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class29.field392[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class29.field392[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3270(var1, var2, var5, var4, var8.blocksProjectile);
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

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field698[var4], class61.field698[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           class61.field690[var0][var1][var2] |= 585;
                           class61.field690[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class61.field690[var0][var1][var2 + 1] |= 1170;
                           class61.field690[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class61.field690[var0][var1 + 1][var2] |= 585;
                           class61.field690[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class61.field690[var0][var1][var2] |= 1170;
                           class61.field690[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.method3270(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method2930(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field697[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class29.field392[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class29.field392[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class29.field392[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class29.field392[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.clipType != 0 && var7 != null) {
                        var7.method3270(var1, var2, var5, var4, var8.blocksProjectile);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2823(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.clipType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                     }

                     if(var8.decorDisplacement != 16) {
                        var6.method2930(var0, var1, var2, var8.decorDisplacement);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field698[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method2895(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = TextureProvider.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field698[var4], 0, var26 * class61.field694[var4], var26 * class61.field695[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method2895(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = TextureProvider.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field696[var4], var26 * class61.field692[var4], var19, var20);
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
                     var22 = var6.method2895(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = TextureProvider.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
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

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field696[var4], var26 * class61.field692[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2823(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2662() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class29.field392[var0][var23 + var1][var24 + var2]) {
                           class29.field392[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
               }

            }
         }
      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("oi")
   static boolean field726;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1978930655
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("i")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("a")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "66"
   )
   static char method1125(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "124683281"
   )
   public static void method1124() {
      class229.field2673.method4172();
      class229.field2674 = 1;
      class229.field2672 = null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIILew;Lfa;B)V",
      garbageValue = "-10"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class62.tileSettings[0][var1][var2] & 2) != 0 || (class62.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class62.field705) {
            class62.field705 = var0;
         }

         ObjectComposition var8 = Spotanim.getObjectDefinition(var3);
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

         int[][] var15 = class62.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
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

         int var22;
         int var23;
         if(var8.method5008()) {
            class80 var21 = new class80();
            var21.field1237 = var0;
            var21.field1243 = var1 * 128;
            var21.field1239 = var2 * 128;
            var22 = var8.width;
            var23 = var8.length;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.length;
               var23 = var8.width;
            }

            var21.field1249 = (var22 + var1) * 128;
            var21.field1245 = (var23 + var2) * 128;
            var21.field1241 = var8.ambientSoundId;
            var21.field1242 = var8.int4 * 128;
            var21.field1246 = var8.int5;
            var21.field1247 = var8.int6;
            var21.field1236 = var8.field3642;
            if(var8.impostorIds != null) {
               var21.field1250 = var8;
               var21.method1794();
            }

            class80.field1240.addFront(var21);
            if(var21.field1236 != null) {
               var21.field1248 = var21.field1246 + (int)(Math.random() * (double)(var21.field1247 - var21.field1246));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.clipType == 1 || var8.obstructsGround) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.clipType == 1 && var7 != null) {
                  var7.method3388(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2876(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class62.field709[var0][var1][var2] |= 2340;
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field713[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class62.field704[var0][var1][var2] = 50;
                     class62.field704[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class62.field709[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class62.field704[var0][var1][var2 + 1] = 50;
                     class62.field704[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class62.field709[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class62.field704[var0][var1 + 1][var2] = 50;
                     class62.field704[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class62.field709[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class62.field704[var0][var1][var2] = 50;
                     class62.field704[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class62.field709[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3416(var1, var2, var5, var4, var8.blocksProjectile);
               }

               if(var8.decorDisplacement != 16) {
                  var6.method2939(var0, var1, var2, var8.decorDisplacement);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field715[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class62.field704[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class62.field704[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class62.field704[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class62.field704[var0][var1][var2] = 50;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3416(var1, var2, var5, var4, var8.blocksProjectile);
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

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class62.field713[var4], class62.field713[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class62.field709[var0][var1][var2] |= 585;
                        class62.field709[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class62.field709[var0][var1][var2 + 1] |= 1170;
                        class62.field709[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class62.field709[var0][var1 + 1][var2] |= 585;
                        class62.field709[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class62.field709[var0][var1][var2] |= 1170;
                        class62.field709[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3416(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2939(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field715[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class62.field704[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class62.field704[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class62.field704[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class62.field704[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3416(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2876(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2939(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field713[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2987(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Spotanim.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class62.field713[var4], 0, var26 * class62.field722[var4], var26 * class62.field716[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2987(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Spotanim.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class62.field717[var4], var26 * class62.field718[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method2987(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Spotanim.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
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

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class62.field717[var4], var26 * class62.field718[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2876(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2692() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class62.field704[var0][var23 + var1][var24 + var2]) {
                        class62.field704[var0][var23 + var1][var24 + var2] = (byte)var22;
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

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1478048754"
   )
   static final void method1126() {
      int[] var0 = class93.playerIndices;

      int var1;
      for(var1 = 0; var1 < class93.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if(var2.overheadTextCyclesRemaining == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if(var3.overheadTextCyclesRemaining == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}

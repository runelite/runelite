import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 33007959
   )
   public static int field810;
   @ObfuscatedName("n")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-1168388311"
   )
   public static int method1115(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class249.NetCache_pendingPriorityResponsesCount + class249.NetCache_pendingPriorityWritesCount;
      return var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIILeh;Lfi;I)V",
      garbageValue = "-616963298"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field729) {
            class61.field729 = var0;
         }

         ObjectComposition var8 = NPC.getObjectDefinition(var3);
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
         if(var8.method4742()) {
            class81 var21 = new class81();
            var21.field1242 = var0;
            var21.field1252 = var1 * 128;
            var21.field1243 = var2 * 128;
            var22 = var8.width;
            var23 = var8.length;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.length;
               var23 = var8.width;
            }

            var21.field1241 = (var22 + var1) * 128;
            var21.field1246 = (var23 + var2) * 128;
            var21.field1248 = var8.ambientSoundId;
            var21.field1244 = var8.int4 * 128;
            var21.field1254 = var8.int5;
            var21.field1251 = var8.int6;
            var21.field1245 = var8.field3569;
            if(var8.impostorIds != null) {
               var21.field1255 = var8;
               var21.method1641();
            }

            class81.field1247.addFront(var21);
            if(var21.field1245 != null) {
               var21.field1253 = var21.field1254 + (int)(Math.random() * (double)(var21.field1251 - var21.field1254));
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
                  var7.method3199(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2756(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class161.field2183[var0][var1][var2] |= 2340;
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

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field727[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class115.field1595[var0][var1][var2] = 50;
                     class115.field1595[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class161.field2183[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class115.field1595[var0][var1][var2 + 1] = 50;
                     class115.field1595[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class161.field2183[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class115.field1595[var0][var1 + 1][var2] = 50;
                     class115.field1595[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class161.field2183[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class115.field1595[var0][var1][var2] = 50;
                     class115.field1595[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class161.field2183[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3206(var1, var2, var5, var4, var8.blocksProjectile);
               }

               if(var8.decorDisplacement != 16) {
                  var6.method2801(var0, var1, var2, var8.decorDisplacement);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field735[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class115.field1595[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class115.field1595[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class115.field1595[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class115.field1595[var0][var1][var2] = 50;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3206(var1, var2, var5, var4, var8.blocksProjectile);
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

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field727[var4], class61.field727[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class161.field2183[var0][var1][var2] |= 585;
                        class161.field2183[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class161.field2183[var0][var1][var2 + 1] |= 1170;
                        class161.field2183[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class161.field2183[var0][var1 + 1][var2] |= 585;
                        class161.field2183[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class161.field2183[var0][var1][var2] |= 1170;
                        class161.field2183[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3206(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2801(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field735[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class115.field1595[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class115.field1595[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class115.field1595[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class115.field1595[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3206(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2756(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2801(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field727[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2762(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = NPC.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field727[var4], 0, var26 * class61.field736[var4], var26 * class61.field737[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2762(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = NPC.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field744[var4], var26 * class61.field739[var4], var19, var20);
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
                  var22 = var6.method2762(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = NPC.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
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

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field744[var4], var26 * class61.field739[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2756(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2580() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class115.field1595[var0][var23 + var1][var24 + var2]) {
                        class115.field1595[var0][var23 + var1][var24 + var2] = (byte)var22;
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

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-1"
   )
   static final void method1114(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class45.region.method2762(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class45.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class234.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = NPC.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class21.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.originalWidth) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5253(var15 + var1 * 4 + 48, (104 - var2 - var13.length) * 4 + var16 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class45.region.method2774(var0, var1, var2);
      if(var5 != 0) {
         var6 = class45.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = NPC.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class21.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.originalWidth) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5253(var1 * 4 + var12 + 48, (104 - var2 - var23.length) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class234.minimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class45.region.method2775(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = NPC.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class21.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.originalWidth) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5253(var9 + var1 * 4 + 48, (104 - var2 - var19.length) * 4 + var21 + 48);
            }
         }
      }

   }
}

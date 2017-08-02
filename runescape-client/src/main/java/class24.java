import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class24 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public static final class24 field351;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public static final class24 field342;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   public static final class24 field343;
   @ObfuscatedName("lr")
   @ObfuscatedSignature(
      signature = "[Lho;"
   )
   static Widget[] field346;
   @ObfuscatedName("ap")
   static int[] field348;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1344092945
   )
   final int field347;
   @ObfuscatedName("u")
   final String field344;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 204471349
   )
   final int field349;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1995522171
   )
   final int field345;

   static {
      field351 = new class24("SMALL", 2, 0, 4);
      field342 = new class24("MEDIUM", 0, 1, 2);
      field343 = new class24("LARGE", 1, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field344 = var1;
      this.field349 = var2;
      this.field345 = var3;
      this.field347 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "-1942015343"
   )
   boolean method172(float var1) {
      return var1 >= (float)this.field347;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)[Lb;",
      garbageValue = "58"
   )
   static class24[] method171() {
      return new class24[]{field351, field342, field343};
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(Lbc;I)V",
      garbageValue = "1591281209"
   )
   static final void method170(class66 var0) {
      if(class226.localPlayer.x >> 7 == Client.destinationX && class226.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class96.field1469;
      int[] var2 = class96.field1470;
      int var3 = var1;
      if(class66.field810 == var0 || class66.field808 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field810 == var0) {
            var5 = class226.localPlayer;
            var6 = class226.localPlayer.field901 << 14;
         } else if(class66.field808 == var0) {
            var5 = Client.cachedPlayers[Client.field1033];
            var6 = Client.field1033 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field809 == var0 && var2[var4] == Client.field1033) {
               continue;
            }
         }

         if(var5 != null && var5.hasConfig() && !var5.hidden) {
            var5.field897 = false;
            if((Client.lowMemory && var1 > 50 || var1 > 200) && class66.field810 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field897 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field904 && Client.gameCycle < var5.field875) {
                  var5.field897 = false;
                  var5.field882 = class23.getTileHeight(var5.x, var5.y, class10.plane);
                  class19.region.method2629(class10.plane, var5.x, var5.y, var5.field882, 60, var5, var5.angle, var6, var5.field889, var5.field890, var5.field891, var5.field892);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1007[var7][var8] == Client.field1021) {
                        continue;
                     }

                     Client.field1007[var7][var8] = Client.field1021;
                  }

                  var5.field882 = class23.getTileHeight(var5.x, var5.y, class10.plane);
                  class19.region.method2671(class10.plane, var5.x, var5.y, var5.field882, 60, var5, var5.angle, var6, var5.field1233);
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIILej;Lfu;B)V",
      garbageValue = "81"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field754) {
            class61.field754 = var0;
         }

         ObjectComposition var8 = class169.getObjectDefinition(var3);
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
            var11 = var1 + (var9 >> 1);
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var11][var13] + var15[var12][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.field3429 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3431 == 1) {
            var20 += 256;
         }

         if(var8.method4410()) {
            class31.method270(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.field3429 != 0 || var8.interactType == 1 || var8.field3448) {
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

                  var6.method2627(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class61.field755[var0][var1][var2] |= 2340;
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.field3439);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field763[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.clipped) {
                        class134.field1949[var0][var1][var2] = 50;
                        class134.field1949[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field755[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.clipped) {
                        class134.field1949[var0][var1][var2 + 1] = 50;
                        class134.field1949[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field755[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.clipped) {
                        class134.field1949[var0][var1 + 1][var2] = 50;
                        class134.field1949[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field755[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.clipped) {
                        class134.field1949[var0][var1][var2] = 50;
                        class134.field1949[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.modelClipped) {
                        class61.field755[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3439);
                  }

                  if(var8.field3447 != 16) {
                     var6.method2650(var0, var1, var2, var8.field3447);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.getModel(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field757[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class134.field1949[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class134.field1949[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class134.field1949[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class134.field1949[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.interactType != 0 && var7 != null) {
                     var7.addWall(var1, var2, var5, var4, var8.field3439);
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

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field763[var4], class61.field763[var26], var19, var20);
                     if(var8.modelClipped) {
                        if(var4 == 0) {
                           class61.field755[var0][var1][var2] |= 585;
                           class61.field755[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class61.field755[var0][var1][var2 + 1] |= 1170;
                           class61.field755[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class61.field755[var0][var1 + 1][var2] |= 585;
                           class61.field755[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class61.field755[var0][var1][var2] |= 1170;
                           class61.field755[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3439);
                     }

                     if(var8.field3447 != 16) {
                        var6.method2650(var0, var1, var2, var8.field3447);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundary(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field757[var4], 0, var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class134.field1949[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class134.field1949[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class134.field1949[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class134.field1949[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.interactType != 0 && var7 != null) {
                        var7.addWall(var1, var2, var5, var4, var8.field3439);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2627(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.interactType != 0 && var7 != null) {
                        var7.addObject(var1, var2, var9, var10, var8.field3439);
                     }

                     if(var8.field3447 != 16) {
                        var6.method2650(var0, var1, var2, var8.field3447);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field763[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method2760(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class169.getObjectDefinition(var22 >> 14 & 32767).field3447;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field763[var4], 0, var26 * class61.field758[var4], var26 * class61.field759[var4], var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method2760(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class169.getObjectDefinition(var22 >> 14 & 32767).field3447 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field760[var4], var26 * class61.field761[var4], var19, var20);
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
                     var22 = var6.method2760(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class169.getObjectDefinition(var22 >> 14 & 32767).field3447 / 2;
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

                     var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field760[var4], var26 * class61.field761[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.getModel(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2627(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.clipped) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2470() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class134.field1949[var0][var23 + var1][var24 + var2]) {
                           class134.field1949[var0][var23 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.interactType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.field3439);
               }

            }
         }
      }
   }
}

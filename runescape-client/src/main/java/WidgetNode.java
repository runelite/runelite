import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 823988497
   )
   int field53;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1155465443
   )
   @Export("id")
   int id;
   @ObfuscatedName("pf")
   static class224 field55;
   @ObfuscatedName("j")
   boolean field57 = false;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;B)V",
      garbageValue = "4"
   )
   static final void method43(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class1.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.field938;
         var11 = var9.field939;
      } else {
         var10 = var9.field939;
         var11 = var9.field938;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = (var11 >> 1) + var3;
         var15 = var3 + (1 + var11 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class5.tileHeights[var1];
      int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = 1073741824 + (var3 << 7) + var2 + (var4 << 14);
      if(var9.field966 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field963 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.field946 == -1 && null == var9.impostorIds) {
            var22 = var9.method812(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 22, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.field940 == 1) {
            var8.method2446(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.field946 == -1 && null == var9.impostorIds) {
               var22 = var9.method812(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
            }

            var7.method1958(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.field940 != 0) {
               var8.method2444(var2, var3, var10, var11, var9.field973);
            }

         } else if(var6 == 0) {
            if(var9.field946 == -1 && null == var9.impostorIds) {
               var22 = var9.method812(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 0, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
            }

            var7.method2010(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class5.field82[var5], 0, var20, var21);
            if(var9.field940 != 0) {
               var8.method2443(var2, var3, var6, var5, var9.field973);
            }

         } else if(var6 == 1) {
            if(var9.field946 == -1 && var9.impostorIds == null) {
               var22 = var9.method812(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class12(var4, 1, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
            }

            var7.method2010(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class5.field83[var5], 0, var20, var21);
            if(var9.field940 != 0) {
               var8.method2443(var2, var3, var6, var5, var9.field973);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var28;
               if(var9.field946 == -1 && var9.impostorIds == null) {
                  var28 = var9.method812(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method812(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class12(var4, 2, var5 + 4, var1, var2, var3, var9.field946, true, (Renderable)null);
                  var24 = new class12(var4, 2, var27, var1, var2, var3, var9.field946, true, (Renderable)null);
               }

               var7.method2010(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, class5.field82[var5], class5.field82[var27], var20, var21);
               if(var9.field940 != 0) {
                  var8.method2443(var2, var3, var6, var5, var9.field973);
               }

            } else if(var6 == 3) {
               if(var9.field946 == -1 && null == var9.impostorIds) {
                  var22 = var9.method812(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 3, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
               }

               var7.method2010(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class5.field83[var5], 0, var20, var21);
               if(var9.field940 != 0) {
                  var8.method2443(var2, var3, var6, var5, var9.field973);
               }

            } else if(var6 == 9) {
               if(var9.field946 == -1 && var9.impostorIds == null) {
                  var22 = var9.method812(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, var6, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
               }

               var7.method1958(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.field940 != 0) {
                  var8.method2444(var2, var3, var10, var11, var9.field973);
               }

            } else if(var6 == 4) {
               if(var9.field946 == -1 && var9.impostorIds == null) {
                  var22 = var9.method812(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class12(var4, 4, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
               }

               var7.method1957(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class5.field82[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method1974(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class1.getObjectDefinition(var23 >> 14 & 32767).field976;
                  }

                  if(var9.field946 == -1 && var9.impostorIds == null) {
                     var24 = var9.method812(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
                  }

                  var7.method1957(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class5.field82[var5], 0, var27 * class5.field84[var5], class5.field77[var5] * var27, var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method1974(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class1.getObjectDefinition(var23 >> 14 & 32767).field976 / 2;
                  }

                  if(var9.field946 == -1 && null == var9.impostorIds) {
                     var24 = var9.method812(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field946, true, (Renderable)null);
                  }

                  var7.method1957(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class5.field90[var5], class5.field87[var5] * var27, var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.field946 == -1 && null == var9.impostorIds) {
                     var22 = var9.method812(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var22 = new class12(var4, 4, var23 + 4, var1, var2, var3, var9.field946, true, (Renderable)null);
                  }

                  var7.method1957(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method1974(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class1.getObjectDefinition(var23 >> 14 & 32767).field976 / 2;
                  }

                  int var26 = 2 + var5 & 3;
                  Object var25;
                  if(var9.field946 == -1 && null == var9.impostorIds) {
                     var24 = var9.method812(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method812(4, 4 + var26, var16, var18, var17, var19);
                  } else {
                     var24 = new class12(var4, 4, 4 + var5, var1, var2, var3, var9.field946, true, (Renderable)null);
                     var25 = new class12(var4, 4, var26 + 4, var1, var2, var3, var9.field946, true, (Renderable)null);
                  }

                  var7.method1957(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class5.field90[var5], class5.field87[var5] * var27, var20, var21);
               }
            }
         }
      } else {
         if(var9.field946 == -1 && null == var9.impostorIds) {
            var22 = var9.method812(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class12(var4, 10, var5, var1, var2, var3, var9.field946, true, (Renderable)null);
         }

         if(null != var22) {
            var7.method1958(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field940 != 0) {
            var8.method2444(var2, var3, var10, var11, var9.field973);
         }

      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-841408832"
   )
   static final void method44(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Projectile.region.method1974(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = Projectile.region.method1978(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class143.field2205.image;
         var11 = 24624 + 4 * var1 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class1.getObjectDefinition(var12);
         if(var13.field952 != -1) {
            ModIcon var14 = ChatLineBuffer.field689[var13.field952];
            if(null != var14) {
               int var15 = (var13.field938 * 4 - var14.originalWidth) / 2;
               int var16 = (var13.field939 * 4 - var14.height) / 2;
               var14.method1896(48 + var1 * 4 + var15, var16 + 48 + 4 * (104 - var2 - var13.field939));
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }
         }
      }

      var5 = Projectile.region.method2014(var0, var1, var2);
      if(var5 != 0) {
         var6 = Projectile.region.method1978(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class1.getObjectDefinition(var9);
         int var21;
         if(var23.field952 != -1) {
            ModIcon var22 = ChatLineBuffer.field689[var23.field952];
            if(var22 != null) {
               var12 = (var23.field938 * 4 - var22.originalWidth) / 2;
               var21 = (var23.field939 * 4 - var22.height) / 2;
               var22.method1896(4 * var1 + 48 + var12, var21 + 48 + 4 * (104 - var2 - var23.field939));
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = class143.field2205.image;
            var21 = 24624 + var1 * 4 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var17[var21] = var11;
               var17[1 + var21 + 512] = var11;
               var17[2 + 1024 + var21] = var11;
               var17[var21 + 1536 + 3] = var11;
            } else {
               var17[var21 + 1536] = var11;
               var17[1024 + var21 + 1] = var11;
               var17[2 + 512 + var21] = var11;
               var17[var21 + 3] = var11;
            }
         }
      }

      var5 = Projectile.region.method2111(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class1.getObjectDefinition(var6);
         if(var20.field952 != -1) {
            ModIcon var18 = ChatLineBuffer.field689[var20.field952];
            if(var18 != null) {
               var9 = (var20.field938 * 4 - var18.originalWidth) / 2;
               int var19 = (var20.field939 * 4 - var18.height) / 2;
               var18.method1896(48 + 4 * var1 + var9, var19 + (104 - var2 - var20.field939) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "4"
   )
   static void method45(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3830((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}

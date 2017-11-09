import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
public class class296 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static IndexedSprite field3859;
   @ObfuscatedName("x")
   String field3856;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   IndexDataBase field3860;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -484701545
   )
   int field3861;
   @ObfuscatedName("b")
   boolean field3863;

   @ObfuscatedSignature(
      signature = "(Lik;)V"
   )
   class296(IndexDataBase var1) {
      this.field3861 = 0;
      this.field3863 = false;
      this.field3860 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1222229434"
   )
   void method5398(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.field3856) {
            this.field3856 = var1;
            this.field3861 = 0;
            this.field3863 = false;
            this.method5409();
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2027061186"
   )
   int method5409() {
      if(this.field3861 < 25) {
         if(!this.field3860.method4295(class40.field510.field512, this.field3856)) {
            return this.field3861;
         }

         this.field3861 = 25;
      }

      if(this.field3861 == 25) {
         if(!this.field3860.method4295(this.field3856, class40.field515.field512)) {
            return 25 + this.field3860.method4323(this.field3856) * 25 / 100;
         }

         this.field3861 = 50;
      }

      if(this.field3861 == 50) {
         if(this.field3860.method4297(class40.field509.field512, this.field3856) && !this.field3860.method4295(class40.field509.field512, this.field3856)) {
            return 50;
         }

         this.field3861 = 75;
      }

      if(this.field3861 == 75) {
         if(!this.field3860.method4295(this.field3856, class40.field513.field512)) {
            return 75;
         }

         this.field3861 = 100;
         this.field3863 = true;
      }

      return this.field3861;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "882468521"
   )
   boolean method5400() {
      return this.field3863;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1904863486"
   )
   int method5399() {
      return this.field3861;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIILec;Lfa;S)V",
      garbageValue = "4549"
   )
   static final void method5402(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class24.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.sizeX;
         var11 = var9.sizeY;
      } else {
         var10 = var9.sizeY;
         var11 = var9.sizeX;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class61.tileHeights[var1];
      int var17 = var16[var13][var14] + var16[var12][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field3506 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field3527 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4700(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.interactType == 1) {
            var8.block(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4700(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2791(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addObject(var2, var3, var10, var11, var9.field3505);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4700(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field723[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3505);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4700(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field732[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3505);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var23;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var23 = var9.method4700(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4700(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var23, (Renderable)var24, class61.field723[var5], class61.field723[var27], var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3505);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4700(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field732[var5], 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3505);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4700(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2791(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addObject(var2, var3, var10, var11, var9.field3505);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4700(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field723[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = var7.method2814(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class24.getObjectDefinition(var28 >> 14 & 32767).field3491;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4700(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class61.field723[var5], 0, var27 * class61.field733[var5], var27 * class61.field734[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = var7.method2814(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class24.getObjectDefinition(var28 >> 14 & 32767).field3491 / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4700(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class61.field724[var5], var27 * class61.field736[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4700(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = var7.method2814(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class24.getObjectDefinition(var28 >> 14 & 32767).field3491 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4700(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4700(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class61.field724[var5], var27 * class61.field736[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4700(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2791(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.interactType != 0) {
            var8.addObject(var2, var3, var10, var11, var9.field3505);
         }

      }
   }
}

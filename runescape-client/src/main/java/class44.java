import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class44 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -985107897
   )
   int field563;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1816465807
   )
   int field567;
   @ObfuscatedName("t")
   int[][] field564;
   @ObfuscatedName("d")
   int[][] field562;
   @ObfuscatedName("h")
   int[][] field566;
   @ObfuscatedName("m")
   int[][] field565;

   class44(int var1, int var2) {
      this.field563 = var1;
      this.field567 = var2;
      this.field564 = new int[var1][var2];
      this.field562 = new int[var1][var2];
      this.field566 = new int[var1][var2];
      this.field565 = new int[var1][var2];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILje;B)V",
      garbageValue = "41"
   )
   void method656(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field563 && var2 - var3 <= this.field567) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field563, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field567, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field564[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field562[var9][var10] += var4.saturation;
                     this.field566[var9][var10] += var4.lightness;
                     ++this.field565[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1453740112"
   )
   int method655(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field563 && var2 < this.field567) {
         if(this.field566[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field564[var1][var2] / this.field565[var1][var2];
            int var4 = this.field562[var1][var2] / this.field565[var1][var2];
            int var5 = this.field566[var1][var2] / this.field565[var1][var2];
            return class27.method248((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lin;",
      garbageValue = "-1766786559"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(MouseRecorder.widgets[var1] == null || MouseRecorder.widgets[var1][var2] == null) {
         boolean var3 = class189.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return MouseRecorder.widgets[var1][var2];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lfn;"
   )
   public static RunException method664(Throwable var0, String var1) {
      RunException var2;
      if(var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.field2197 = var2.field2197 + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIILel;Lfb;I)V",
      garbageValue = "796936137"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class62.tileSettings[0][var1][var2] & 2) != 0 || (class62.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class62.field747) {
            class62.field747 = var0;
         }

         ObjectComposition var8 = GameCanvas.getObjectDefinition(var3);
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
         int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
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
         if(var8.method5005()) {
            class80 var21 = new class80();
            var21.field1259 = var0;
            var21.field1265 = var1 * 128;
            var21.field1261 = var2 * 128;
            var22 = var8.width;
            var23 = var8.length;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.length;
               var23 = var8.width;
            }

            var21.field1269 = (var22 + var1) * 128;
            var21.field1262 = (var23 + var2) * 128;
            var21.field1264 = var8.ambientSoundId;
            var21.field1273 = var8.int4 * 128;
            var21.field1267 = var8.int5;
            var21.field1268 = var8.int6;
            var21.field1274 = var8.field3614;
            if(var8.impostorIds != null) {
               var21.field1272 = var8;
               var21.method1794();
            }

            class80.field1263.addFront(var21);
            if(var21.field1274 != null) {
               var21.field1270 = var21.field1267 + (int)(Math.random() * (double)(var21.field1268 - var21.field1267));
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
                  var7.method3385(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2862(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  GZipDecompressor.field2520[var0][var1][var2] |= 2340;
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

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field749[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class297.field3831[var0][var1][var2] = 50;
                     class297.field3831[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     GZipDecompressor.field2520[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class297.field3831[var0][var1][var2 + 1] = 50;
                     class297.field3831[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     GZipDecompressor.field2520[var0][var1][1 + var2] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class297.field3831[var0][var1 + 1][var2] = 50;
                     class297.field3831[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     GZipDecompressor.field2520[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class297.field3831[var0][var1][var2] = 50;
                     class297.field3831[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     GZipDecompressor.field2520[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3391(var1, var2, var5, var4, var8.blocksProjectile);
               }

               if(var8.decorDisplacement != 16) {
                  var6.method2868(var0, var1, var2, var8.decorDisplacement);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field746[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class297.field3831[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class297.field3831[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class297.field3831[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class297.field3831[var0][var1][var2] = 50;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3391(var1, var2, var5, var4, var8.blocksProjectile);
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

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class62.field749[var4], class62.field749[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        GZipDecompressor.field2520[var0][var1][var2] |= 585;
                        GZipDecompressor.field2520[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        GZipDecompressor.field2520[var0][var1][1 + var2] |= 1170;
                        GZipDecompressor.field2520[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        GZipDecompressor.field2520[var0][var1 + 1][var2] |= 585;
                        GZipDecompressor.field2520[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        GZipDecompressor.field2520[var0][var1][var2] |= 1170;
                        GZipDecompressor.field2520[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3391(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2868(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field746[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class297.field3831[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class297.field3831[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class297.field3831[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class297.field3831[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3391(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2862(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2868(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field749[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.getWallObjectHash(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = GameCanvas.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class62.field749[var4], 0, var26 * class62.field738[var4], var26 * class62.field740[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.getWallObjectHash(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = GameCanvas.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class62.field752[var4], var26 * class62.field750[var4], var19, var20);
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
                  var22 = var6.getWallObjectHash(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = GameCanvas.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
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

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class62.field752[var4], var26 * class62.field750[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2862(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2693() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class297.field3831[var0][var23 + var1][var24 + var2]) {
                        class297.field3831[var0][var23 + var1][var24 + var2] = (byte)var22;
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lll;I)V",
      garbageValue = "-643534752"
   )
   static final void method663(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < MouseRecorder.field819.length; ++var2) {
         MouseRecorder.field819[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         MouseRecorder.field819[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               GrandExchangeEvents.field287[var5] = (MouseRecorder.field819[var5 - 128] + MouseRecorder.field819[var5 + 1] + MouseRecorder.field819[var5 + 128] + MouseRecorder.field819[var5 - 1]) / 4;
            }
         }

         int[] var8 = MouseRecorder.field819;
         MouseRecorder.field819 = GrandExchangeEvents.field287;
         GrandExchangeEvents.field287 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.width; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  MouseRecorder.field819[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1859889380"
   )
   static final void method666(int var0, int var1, int var2, boolean var3) {
      if(class189.loadWidget(var0)) {
         KeyFocusListener.method787(MouseRecorder.widgets[var0], -1, var1, var2, var3);
      }
   }
}

import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class19 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "575329386"
   )
   int method156(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field269 < var2.field269?-1:(var2.field269 == var1.field269?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method156((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   public static final void method152(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1120028771"
   )
   static boolean method147(String var0, int var1) {
      return KitDefinition.method4832(var0, var1, "openjs");
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lie;III)Llm;",
      garbageValue = "-464699858"
   )
   public static SpritePixels method165(IndexDataBase var0, int var1, int var2) {
      return !class258.method4705(var0, var1, var2)?null:GroundObject.method2684();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIILev;Lfq;I)V",
      garbageValue = "1607623442"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field686) {
            class61.field686 = var0;
         }

         ObjectComposition var8 = Preferences.getObjectDefinition(var3);
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
         if(var8.method4964()) {
            class79 var21 = new class79();
            var21.field1205 = var0;
            var21.field1202 = var1 * 128;
            var21.field1203 = var2 * 128;
            var22 = var8.width;
            var23 = var8.length;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.length;
               var23 = var8.width;
            }

            var21.field1204 = (var22 + var1) * 128;
            var21.field1208 = (var23 + var2) * 128;
            var21.field1207 = var8.ambientSoundId;
            var21.field1206 = var8.int4 * 128;
            var21.field1209 = var8.int5;
            var21.field1212 = var8.int6;
            var21.field1211 = var8.field3565;
            if(var8.impostorIds != null) {
               var21.field1214 = var8;
               var21.method1750();
            }

            class79.field1210.addFront(var21);
            if(var21.field1211 != null) {
               var21.field1216 = var21.field1209 + (int)(Math.random() * (double)(var21.field1212 - var21.field1209));
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
                  var7.method3409(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2893(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class56.field619[var0][var1][var2] |= 2340;
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

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field690[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class188.field2488[var0][var1][var2] = 50;
                     class188.field2488[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class56.field619[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class188.field2488[var0][var1][var2 + 1] = 50;
                     class188.field2488[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class56.field619[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class188.field2488[var0][var1 + 1][var2] = 50;
                     class188.field2488[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class56.field619[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class188.field2488[var0][var1][var2] = 50;
                     class188.field2488[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class56.field619[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3382(var1, var2, var5, var4, var8.blocksProjectile);
               }

               if(var8.decorDisplacement != 16) {
                  var6.method2899(var0, var1, var2, var8.decorDisplacement);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field691[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class188.field2488[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class188.field2488[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class188.field2488[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class188.field2488[var0][var1][var2] = 50;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3382(var1, var2, var5, var4, var8.blocksProjectile);
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

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field690[var4], class61.field690[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class56.field619[var0][var1][var2] |= 585;
                        class56.field619[var0][var1][1 + var2] |= 1170;
                     } else if(var4 == 1) {
                        class56.field619[var0][var1][1 + var2] |= 1170;
                        class56.field619[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class56.field619[var0][var1 + 1][var2] |= 585;
                        class56.field619[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class56.field619[var0][var1][var2] |= 1170;
                        class56.field619[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3382(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2899(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field691[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class188.field2488[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class188.field2488[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class188.field2488[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class188.field2488[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3382(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2893(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2899(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field690[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2941(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Preferences.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field690[var4], 0, var26 * class61.field694[var4], var26 * class61.field693[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2941(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Preferences.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field689[var4], var26 * class61.field695[var4], var19, var20);
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
                  var22 = var6.method2941(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = Preferences.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
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

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field689[var4], var26 * class61.field695[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2893(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2709() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class188.field2488[var0][var23 + var1][var24 + var2]) {
                        class188.field2488[var0][var23 + var1][var24 + var2] = (byte)var22;
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
      signature = "(III)I",
      garbageValue = "1894340861"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1461403442"
   )
   static final void method161(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field947 - Client.field1055) * var5 / 100 + Client.field1055;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1061) {
         var15 = Client.field1061;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1060) {
            var6 = Client.field1060;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1062) {
         var15 = Client.field1062;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1059) {
            var6 = Client.field1059;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1058 - Client.field899) * var5 / 100 + Client.field899;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(IIIILlm;Lhq;B)V",
      garbageValue = "17"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class230 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2732 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class37.mapedge.method5822(var15 + (var0 + var5.field2732 / 2 - var17 / 2), var5.field2730 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class21.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}

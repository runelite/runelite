import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class17 implements Comparator {
   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "Lce;"
   )
   static class90 field318;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lr;Lr;B)I",
      garbageValue = "26"
   )
   int method119(class14 var1, class14 var2) {
      return var1.field291.price < var2.field291.price?-1:(var2.field291.price == var1.field291.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method119((class14)var1, (class14)var2);
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lhi;III)V",
      garbageValue = "1901433372"
   )
   static void method131(Widget var0, int var1, int var2) {
      if(var0.field2654 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2654 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2654 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2654 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2654 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2734 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2734 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2734 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2734 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2734 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1096 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(III)Lfe;",
      garbageValue = "1895401284"
   )
   static class164 method128(int var0, int var1) {
      Client.field1201.field2318 = var0;
      Client.field1201.field2315 = var1;
      Client.field1201.field2314 = 1;
      Client.field1201.field2317 = 1;
      return Client.field1201;
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Lbl;ZB)V",
      garbageValue = "14"
   )
   static final void method127(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && BaseVarType.validInterfaces[var2]) {
         SoundTask.widgetIndex.method4126(var2);
         if(class176.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < class176.widgets[var2].length; ++var5) {
               if(class176.widgets[var2][var5] != null) {
                  if(class176.widgets[var2][var5].type != 2) {
                     class176.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class176.widgets[var2] = null;
            }

            BaseVarType.validInterfaces[var2] = false;
         }
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3558(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3559()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var7 = class84.method1670(var3);
      if(var7 != null) {
         class90.method1723(var7);
      }

      class74.method1183();
      if(Client.widgetRoot != -1) {
         Friend.method1140(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIILez;Lfc;B)V",
      garbageValue = "4"
   )
   static final void method132(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class37.getObjectDefinition(var4);
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
      int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field3445 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field3466 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4560(22, var5, var16, var18, var17, var19);
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
               var22 = var9.method4560(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2712(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addObject(var2, var3, var10, var11, var9.field3444);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4560(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field767[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3444);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4560(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field770[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3444);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var23;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var23 = var9.method4560(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4560(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var23, (Renderable)var24, class61.field767[var5], class61.field767[var27], var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3444);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4560(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field770[var5], 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3444);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4560(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2712(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addObject(var2, var3, var10, var11, var9.field3444);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4560(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field767[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = var7.method2728(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class37.getObjectDefinition(var28 >> 14 & 32767).field3450;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4560(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class61.field767[var5], 0, var27 * class61.field769[var5], var27 * class61.field772[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = var7.method2728(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class37.getObjectDefinition(var28 >> 14 & 32767).field3450 / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4560(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class61.field771[var5], var27 * class61.field781[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4560(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = var7.method2728(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = class37.getObjectDefinition(var28 >> 14 & 32767).field3450 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4560(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4560(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class61.field771[var5], var27 * class61.field781[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4560(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2712(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.interactType != 0) {
            var8.addObject(var2, var3, var10, var11, var9.field3444);
         }

      }
   }
}

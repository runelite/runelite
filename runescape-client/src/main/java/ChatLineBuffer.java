import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("e")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1620614587
   )
   @Export("length")
   int length;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "37"
   )
   MessageNode method868(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2388();
         var5.method199(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-1313704601"
   )
   MessageNode method869(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1387803557"
   )
   static void method871(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2312(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1125788005"
   )
   int method877() {
      return this.length;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "303378837"
   )
   static final void method880(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field289 && class171.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Client.region.method1717(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Client.region.method1718(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Client.region.method1719(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Client.region.method1720(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Client.region.method1721(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Client.region.method1708(var0, var2, var3);
               var12 = ItemLayer.getObjectDefinition(var34);
               if(var12.field2909 != 0) {
                  Client.collisionMaps[var0].method2216(var2, var3, var35, var36, var12.field2910);
               }
            }

            if(var1 == 1) {
               Client.region.method1774(var0, var2, var3);
            }

            if(var1 == 2) {
               Client.region.method1715(var0, var2, var3);
               var12 = ItemLayer.getObjectDefinition(var34);
               if(var2 + var12.field2907 > 103 || var12.field2907 + var3 > 103 || var2 + var12.field2908 > 103 || var3 + var12.field2908 > 103) {
                  return;
               }

               if(var12.field2909 != 0) {
                  Client.collisionMaps[var0].method2220(var2, var3, var12.field2907, var12.field2908, var36, var12.field2910);
               }
            }

            if(var1 == 3) {
               Client.region.method1841(var0, var2, var3);
               var12 = ItemLayer.getObjectDefinition(var34);
               if(var12.field2909 == 1) {
                  Client.collisionMaps[var0].method2219(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = Client.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = ItemLayer.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field2907;
               var16 = var14.field2908;
            } else {
               var15 = var14.field2908;
               var16 = var14.field2907;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = 1 + var2;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = (var16 + 1 >> 1) + var3;
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class10.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var2 << 7) + (var15 << 6);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var14.field2911 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field2932 == 1) {
               var26 += 256;
            }

            Object var32;
            if(var6 == 22) {
               if(var14.field2913 == -1 && var14.impostorIds == null) {
                  var32 = var14.method3574(22, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 22, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var32, var25, var26);
               if(var14.field2909 == 1) {
                  var13.method2218(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field2913 == -1 && var14.impostorIds == null) {
                     var32 = var14.method3574(var6, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, var6, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                  }

                  var37.method1701(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                  if(var14.field2909 != 0) {
                     var13.method2212(var2, var3, var15, var16, var14.field2910);
                  }
               } else if(var6 == 0) {
                  if(var14.field2913 == -1 && var14.impostorIds == null) {
                     var32 = var14.method3574(0, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 0, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                  }

                  var37.method1741(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field90[var5], 0, var25, var26);
                  if(var14.field2909 != 0) {
                     var13.method2211(var2, var3, var6, var5, var14.field2910);
                  }
               } else if(var6 == 1) {
                  if(var14.field2913 == -1 && var14.impostorIds == null) {
                     var32 = var14.method3574(1, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 1, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                  }

                  var37.method1741(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field95[var5], 0, var25, var26);
                  if(var14.field2909 != 0) {
                     var13.method2211(var2, var3, var6, var5, var14.field2910);
                  }
               } else {
                  int var27;
                  Object var29;
                  if(var6 == 2) {
                     var27 = 1 + var5 & 3;
                     Object var33;
                     if(var14.field2913 == -1 && var14.impostorIds == null) {
                        var33 = var14.method3574(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method3574(2, var27, var21, var23, var22, var24);
                     } else {
                        var33 = new class49(var4, 2, 4 + var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                        var29 = new class49(var4, 2, var27, var11, var2, var3, var14.field2913, true, (Renderable)null);
                     }

                     var37.method1741(var0, var2, var3, var22, (Renderable)var33, (Renderable)var29, class10.field90[var5], class10.field90[var27], var25, var26);
                     if(var14.field2909 != 0) {
                        var13.method2211(var2, var3, var6, var5, var14.field2910);
                     }
                  } else if(var6 == 3) {
                     if(var14.field2913 == -1 && var14.impostorIds == null) {
                        var32 = var14.method3574(3, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 3, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                     }

                     var37.method1741(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field95[var5], 0, var25, var26);
                     if(var14.field2909 != 0) {
                        var13.method2211(var2, var3, var6, var5, var14.field2910);
                     }
                  } else if(var6 == 9) {
                     if(var14.field2913 == -1 && null == var14.impostorIds) {
                        var32 = var14.method3574(var6, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, var6, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                     }

                     var37.method1701(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                     if(var14.field2909 != 0) {
                        var13.method2212(var2, var3, var15, var16, var14.field2910);
                     }
                  } else if(var6 == 4) {
                     if(var14.field2913 == -1 && var14.impostorIds == null) {
                        var32 = var14.method3574(4, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 4, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                     }

                     var37.method1700(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field90[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var27 = 16;
                        var28 = var37.method1717(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = ItemLayer.getObjectDefinition(var28 >> 14 & 32767).field2892;
                        }

                        if(var14.field2913 == -1 && null == var14.impostorIds) {
                           var29 = var14.method3574(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
                        }

                        var37.method1700(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class10.field90[var5], 0, var27 * class10.field96[var5], class10.field94[var5] * var27, var25, var26);
                     } else if(var6 == 6) {
                        var27 = 8;
                        var28 = var37.method1717(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = ItemLayer.getObjectDefinition(var28 >> 14 & 32767).field2892 / 2;
                        }

                        if(var14.field2913 == -1 && var14.impostorIds == null) {
                           var29 = var14.method3574(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.field2913, true, (Renderable)null);
                        }

                        var37.method1700(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, class10.field98[var5] * var27, class10.field89[var5] * var27, var25, var26);
                     } else if(var6 == 7) {
                        var28 = 2 + var5 & 3;
                        if(var14.field2913 == -1 && var14.impostorIds == null) {
                           var32 = var14.method3574(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var32 = new class49(var4, 4, 4 + var28, var11, var2, var3, var14.field2913, true, (Renderable)null);
                        }

                        var37.method1700(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var27 = 8;
                        var28 = var37.method1717(var0, var2, var3);
                        if(var28 != 0) {
                           var27 = ItemLayer.getObjectDefinition(var28 >> 14 & 32767).field2892 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.field2913 == -1 && null == var14.impostorIds) {
                           var29 = var14.method3574(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method3574(4, 4 + var31, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.field2913, true, (Renderable)null);
                           var30 = new class49(var4, 4, var31 + 4, var11, var2, var3, var14.field2913, true, (Renderable)null);
                        }

                        var37.method1700(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class10.field98[var5] * var27, class10.field89[var5] * var27, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field2913 == -1 && null == var14.impostorIds) {
                  var32 = var14.method3574(10, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 10, var5, var11, var2, var3, var14.field2913, true, (Renderable)null);
               }

               if(null != var32) {
                  var37.method1701(var0, var2, var3, var22, var15, var16, (Renderable)var32, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2909 != 0) {
                  var13.method2212(var2, var3, var15, var16, var14.field2910);
               }
            }
         }
      }

   }
}

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("a")
final class class6 implements Comparator {
   @ObfuscatedName("aa")
   static class102 field60;
   @ObfuscatedName("v")
   @Export("worldServersDownload")
   static class26 worldServersDownload;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1213064006"
   )
   static final void method72(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field289 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field102) {
            class10.field102 = var0;
         }

         ObjectComposition var8 = ItemLayer.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field2907;
            var10 = var8.field2908;
         } else {
            var9 = var8.field2908;
            var10 = var8.field2907;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var11][var13] + var15[var12][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = (var2 << 7) + var1 + (var3 << 14) + 1073741824;
         if(var8.field2911 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2932 == 1) {
            var20 += 256;
         }

         if(var8.method3558()) {
            class146.method2697(var0, var1, var2, var8, var4);
         }

         Object var27;
         if(var5 == 22) {
            if(!Client.field289 || var8.field2911 != 0 || var8.field2909 == 1 || var8.field2930) {
               if(var8.field2913 == -1 && null == var8.impostorIds) {
                  var27 = var8.method3544(22, var4, var15, var17, var16, var18);
               } else {
                  var27 = new class49(var3, 22, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var27, var19, var20);
               if(var8.field2909 == 1 && var7 != null) {
                  var7.method2218(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field2913 == -1 && var8.impostorIds == null) {
                     var27 = var8.method3544(var5, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, var5, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                  }

                  var6.method1701(var0, var1, var2, var16, 1, 1, (Renderable)var27, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class10.field97[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2909 != 0 && null != var7) {
                     var7.method2212(var1, var2, var9, var10, var8.field2910);
                  }

               } else if(var5 == 0) {
                  if(var8.field2913 == -1 && null == var8.impostorIds) {
                     var27 = var8.method3544(0, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 0, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                  }

                  var6.method1741(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field90[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2915) {
                        class10.field92[var0][var1][var2] = 50;
                        class10.field92[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field2914) {
                        class10.field97[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2915) {
                        class10.field92[var0][var1][var2 + 1] = 50;
                        class10.field92[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field2914) {
                        class10.field97[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2915) {
                        class10.field92[var0][1 + var1][var2] = 50;
                        class10.field92[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field2914) {
                        class10.field97[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2915) {
                        class10.field92[var0][var1][var2] = 50;
                        class10.field92[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2914) {
                        class10.field97[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2909 != 0 && null != var7) {
                     var7.method2211(var1, var2, var5, var4, var8.field2910);
                  }

                  if(var8.field2892 != 16) {
                     var6.method1813(var0, var1, var2, var8.field2892);
                  }

               } else if(var5 == 1) {
                  if(var8.field2913 == -1 && var8.impostorIds == null) {
                     var27 = var8.method3544(1, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 1, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                  }

                  var6.method1741(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field95[var4], 0, var19, var20);
                  if(var8.field2915) {
                     if(var4 == 0) {
                        class10.field92[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class10.field92[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class10.field92[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class10.field92[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2909 != 0 && var7 != null) {
                     var7.method2211(var1, var2, var5, var4, var8.field2910);
                  }

               } else {
                  int var21;
                  Object var26;
                  if(var5 == 2) {
                     var21 = 1 + var4 & 3;
                     Object var29;
                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var29 = var8.method3544(2, 4 + var4, var15, var17, var16, var18);
                        var26 = var8.method3544(2, var21, var15, var17, var16, var18);
                     } else {
                        var29 = new class49(var3, 2, 4 + var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                        var26 = new class49(var3, 2, var21, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1741(var0, var1, var2, var16, (Renderable)var29, (Renderable)var26, class10.field90[var4], class10.field90[var21], var19, var20);
                     if(var8.field2914) {
                        if(var4 == 0) {
                           class10.field97[var0][var1][var2] |= 585;
                           class10.field97[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class10.field97[var0][var1][1 + var2] |= 1170;
                           class10.field97[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class10.field97[var0][var1 + 1][var2] |= 585;
                           class10.field97[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class10.field97[var0][var1][var2] |= 1170;
                           class10.field97[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2909 != 0 && var7 != null) {
                        var7.method2211(var1, var2, var5, var4, var8.field2910);
                     }

                     if(var8.field2892 != 16) {
                        var6.method1813(var0, var1, var2, var8.field2892);
                     }

                  } else if(var5 == 3) {
                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var27 = var8.method3544(3, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 3, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1741(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field95[var4], 0, var19, var20);
                     if(var8.field2915) {
                        if(var4 == 0) {
                           class10.field92[var0][var1][1 + var2] = 50;
                        } else if(var4 == 1) {
                           class10.field92[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class10.field92[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class10.field92[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2909 != 0 && var7 != null) {
                        var7.method2211(var1, var2, var5, var4, var8.field2910);
                     }

                  } else if(var5 == 9) {
                     if(var8.field2913 == -1 && null == var8.impostorIds) {
                        var27 = var8.method3544(var5, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, var5, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1701(var0, var1, var2, var16, 1, 1, (Renderable)var27, 0, var19, var20);
                     if(var8.field2909 != 0 && var7 != null) {
                        var7.method2212(var1, var2, var9, var10, var8.field2910);
                     }

                     if(var8.field2892 != 16) {
                        var6.method1813(var0, var1, var2, var8.field2892);
                     }

                  } else if(var5 == 4) {
                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var27 = var8.method3544(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1700(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field90[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var21 = 16;
                     var22 = var6.method1717(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = ItemLayer.getObjectDefinition(var22 >> 14 & 32767).field2892;
                     }

                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var26 = var8.method3544(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 4, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1700(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class10.field90[var4], 0, var21 * class10.field96[var4], class10.field94[var4] * var21, var19, var20);
                  } else if(var5 == 6) {
                     var21 = 8;
                     var22 = var6.method1717(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = ItemLayer.getObjectDefinition(var22 >> 14 & 32767).field2892 / 2;
                     }

                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var26 = var8.method3544(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1700(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, 256, var4, var21 * class10.field98[var4], class10.field89[var4] * var21, var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var27 = var8.method3544(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, 4 + var22, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1700(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var21 = 8;
                     var22 = var6.method1717(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = ItemLayer.getObjectDefinition(var22 >> 14 & 32767).field2892 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var24;
                     if(var8.field2913 == -1 && var8.impostorIds == null) {
                        var26 = var8.method3544(4, var4 + 4, var15, var17, var16, var18);
                        var24 = var8.method3544(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
                        var24 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.field2913, true, (Renderable)null);
                     }

                     var6.method1700(var0, var1, var2, var16, (Renderable)var26, (Renderable)var24, 256, var4, var21 * class10.field98[var4], var21 * class10.field89[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field2913 == -1 && null == var8.impostorIds) {
                  var27 = var8.method3544(10, var4, var15, var17, var16, var18);
               } else {
                  var27 = new class49(var3, 10, var4, var0, var1, var2, var8.field2913, true, (Renderable)null);
               }

               if(null != var27 && var6.method1701(var0, var1, var2, var16, var9, var10, (Renderable)var27, var5 == 11?256:0, var19, var20) && var8.field2915) {
                  var22 = 15;
                  if(var27 instanceof Model) {
                     var22 = ((Model)var27).method1580() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var28 = 0; var28 <= var10; ++var28) {
                        if(var22 > class10.field92[var0][var1 + var23][var2 + var28]) {
                           class10.field92[var0][var23 + var1][var2 + var28] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2909 != 0 && var7 != null) {
                  var7.method2212(var1, var2, var9, var10, var8.field2910);
               }

            }
         }
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "66"
   )
   int method78(class2 var1, class2 var2) {
      return var1.method24().compareTo(var2.method24());
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "49"
   )
   static final void method80(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class10.tileHeights[var0][var1 + var3][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1][var3 + var2] = class10.tileHeights[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var3 + var1][var2] = class10.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class10.tileHeights[var0][var1 - 1][var2] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class10.tileHeights[var0][var1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class10.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-16"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class171.plane][var0][var1];
      if(var2 == null) {
         Client.region.method1712(class171.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2359(); null != var6; var6 = (Item)var2.method2361()) {
            ItemComposition var7 = class7.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(1 + var6.quantity);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            Client.region.method1712(class171.plane, var0, var1);
         } else {
            var2.method2355(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2359(); null != var6; var6 = (Item)var2.method2361()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            Client.region.method1711(class171.plane, var0, var1, class85.method1686(128 * var0 + 64, var1 * 128 + 64, class171.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "95"
   )
   static final void method82() {
      try {
         if(Client.field316 == 0) {
            if(class156.field2118 != null) {
               class156.field2118.method2035();
               class156.field2118 = null;
            }

            class118.field1844 = null;
            Client.field411 = false;
            Client.field317 = 0;
            Client.field316 = 1;
         }

         if(Client.field316 == 1) {
            if(class118.field1844 == null) {
               class118.field1844 = class41.field855.method1931(class5.host, class167.field2189);
            }

            if(class118.field1844.field1650 == 2) {
               throw new IOException();
            }

            if(class118.field1844.field1650 == 1) {
               class156.field2118 = new class110((Socket)class118.field1844.field1652, class41.field855);
               class118.field1844 = null;
               Client.field316 = 2;
            }
         }

         if(Client.field316 == 2) {
            Client.field294.offset = 0;
            Client.field294.method2932(14);
            class156.field2118.method2032(Client.field294.payload, 0, 1);
            Client.field544.offset = 0;
            Client.field316 = 3;
         }

         int var0;
         if(Client.field316 == 3) {
            if(null != Client.field568) {
               Client.field568.method1017();
            }

            if(class104.field1680 != null) {
               class104.field1680.method1017();
            }

            var0 = class156.field2118.method2030();
            if(null != Client.field568) {
               Client.field568.method1017();
            }

            if(class104.field1680 != null) {
               class104.field1680.method1017();
            }

            if(var0 != 0) {
               class115.method2181(var0);
               return;
            }

            Client.field544.offset = 0;
            Client.field316 = 5;
         }

         int var1;
         int var2;
         if(Client.field316 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field294.offset = 0;
            Client.field294.method2932(1);
            Client.field294.method2932(class41.field851.vmethod3974());
            Client.field294.method2748(var5[0]);
            Client.field294.method2748(var5[1]);
            Client.field294.method2748(var5[2]);
            Client.field294.method2748(var5[3]);
            switch(class41.field851.field1621) {
            case 0:
               Client.field294.offset += 8;
               break;
            case 1:
            case 2:
               Client.field294.method2747(class200.field3048);
               Client.field294.offset += 5;
               break;
            case 3:
               Client.field294.method2748(((Integer)class149.field2044.field687.get(Integer.valueOf(RSCanvas.method2052(class41.username)))).intValue());
               Client.field294.offset += 4;
            }

            Client.field294.method2757(class41.field850);
            Client.field294.method2780(class39.field807, class39.field812);
            Client.field362.offset = 0;
            if(Client.gameState == 40) {
               Client.field362.method2932(18);
            } else {
               Client.field362.method2932(16);
            }

            Client.field362.method2746(0);
            var1 = Client.field362.offset;
            Client.field362.method2748(129);
            Client.field362.method2753(Client.field294.payload, 0, Client.field294.offset);
            var2 = Client.field362.offset;
            Client.field362.method2757(class41.username);
            Client.field362.method2932((Client.isResized?1:0) << 1 | (Client.field289?1:0));
            Client.field362.method2746(ItemLayer.field1223);
            Client.field362.method2746(class112.field1755);
            class3.method33(Client.field362);
            Client.field362.method2757(CombatInfoListHolder.field756);
            Client.field362.method2748(class167.field2188);
            Buffer var3 = new Buffer(class180.field2695.method4161());
            class180.field2695.method4166(var3);
            Client.field362.method2753(var3.payload, 0, var3.payload.length);
            Client.field362.method2932(class18.field185);
            Client.field362.method2748(class137.field1897.field2719);
            Client.field362.method2748(class44.field900.field2719);
            Client.field362.method2748(Friend.field152.field2719);
            Client.field362.method2748(class47.field947.field2719);
            Client.field362.method2748(VertexNormal.field1425.field2719);
            Client.field362.method2748(Friend.field150.field2719);
            Client.field362.method2748(class204.field3079.field2719);
            Client.field362.method2748(class140.field1974.field2719);
            Client.field362.method2748(Client.field314.field2719);
            Client.field362.method2748(MessageNode.field220.field2719);
            Client.field362.method2748(CollisionData.field1838.field2719);
            Client.field362.method2748(class105.field1706.field2719);
            Client.field362.method2748(class65.field1111.field2719);
            Client.field362.method2748(CollisionData.field1837.field2719);
            Client.field362.method2748(class180.field2696.field2719);
            Client.field362.method2748(class0.field7.field2719);
            Client.field362.method2899(var5, var2, Client.field362.offset);
            Client.field362.method2755(Client.field362.offset - var1);
            class156.field2118.method2032(Client.field362.payload, 0, Client.field362.offset);
            Client.field294.method2979(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field544.method2979(var5);
            Client.field316 = 6;
         }

         if(Client.field316 == 6 && class156.field2118.method2028() > 0) {
            var0 = class156.field2118.method2030();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field316 = 7;
            } else if(var0 == 2) {
               Client.field316 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field485 = -1;
               Client.field316 = 13;
            } else if(var0 == 23 && Client.field318 < 1) {
               ++Client.field318;
               Client.field316 = 0;
            } else {
               if(var0 != 29) {
                  class115.method2181(var0);
                  return;
               }

               Client.field316 = 11;
            }
         }

         if(Client.field316 == 7 && class156.field2118.method2028() > 0) {
            Client.field386 = (class156.field2118.method2030() + 3) * 60;
            Client.field316 = 8;
         }

         if(Client.field316 == 8) {
            Client.field317 = 0;
            class22.method204("You have only just left another world.", "Your profile will be transferred in:", Client.field386 / 60 + " seconds.");
            if(--Client.field386 <= 0) {
               Client.field316 = 0;
            }

         } else {
            if(Client.field316 == 9 && class156.field2118.method2028() >= 13) {
               boolean var10 = class156.field2118.method2030() == 1;
               class156.field2118.method2031(Client.field544.payload, 0, 4);
               Client.field544.offset = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = Client.field544.method2975() << 24;
                  var1 |= Client.field544.method2975() << 16;
                  var1 |= Client.field544.method2975() << 8;
                  var1 |= Client.field544.method2975();
                  var2 = RSCanvas.method2052(class41.username);
                  if(class149.field2044.field687.size() >= 10 && !class149.field2044.field687.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = class149.field2044.field687.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  class149.field2044.field687.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class41.method759();
               }

               Client.field358 = class156.field2118.method2030();
               Client.field455 = class156.field2118.method2030() == 1;
               Client.localInteractingIndex = class156.field2118.method2030();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += class156.field2118.method2030();
               Client.field410 = class156.field2118.method2030();
               class156.field2118.method2031(Client.field544.payload, 0, 1);
               Client.field544.offset = 0;
               Client.packetOpcode = Client.field544.method2975();
               class156.field2118.method2031(Client.field544.payload, 0, 2);
               Client.field544.offset = 0;
               Client.field485 = Client.field544.readUnsignedShort();

               try {
                  Client var6 = Client.field282;
                  JSObject.getWindow(var6).call("zap", (Object[])null);
               } catch (Throwable var8) {
                  ;
               }

               Client.field316 = 10;
            }

            if(Client.field316 == 10) {
               if(class156.field2118.method2028() >= Client.field485) {
                  Client.field544.offset = 0;
                  class156.field2118.method2031(Client.field544.payload, 0, Client.field485);
                  GroundObject.method1527();
                  Client.method439(Client.field544);
                  MessageNode.field227 = -1;
                  CollisionData.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field316 == 11 && class156.field2118.method2028() >= 2) {
                  Client.field544.offset = 0;
                  class156.field2118.method2031(Client.field544.payload, 0, 2);
                  Client.field544.offset = 0;
                  Client.field320 = Client.field544.readUnsignedShort();
                  Client.field316 = 12;
               }

               if(Client.field316 == 12 && class156.field2118.method2028() >= Client.field320) {
                  Client.field544.offset = 0;
                  class156.field2118.method2031(Client.field544.payload, 0, Client.field320);
                  Client.field544.offset = 0;
                  String var13 = Client.field544.method2767();
                  String var7 = Client.field544.method2767();
                  String var14 = Client.field544.method2767();
                  class22.method204(var13, var7, var14);
                  XGrandExchangeOffer.setGameState(10);
               }

               if(Client.field316 == 13) {
                  if(Client.field485 == -1) {
                     if(class156.field2118.method2028() < 2) {
                        return;
                     }

                     class156.field2118.method2031(Client.field544.payload, 0, 2);
                     Client.field544.offset = 0;
                     Client.field485 = Client.field544.readUnsignedShort();
                  }

                  if(class156.field2118.method2028() >= Client.field485) {
                     class156.field2118.method2031(Client.field544.payload, 0, Client.field485);
                     Client.field544.offset = 0;
                     var0 = Client.field485;
                     class18.method186();
                     Client.method439(Client.field544);
                     if(Client.field544.offset != var0) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field317;
                  if(Client.field317 > 2000) {
                     if(Client.field318 < 1) {
                        if(class167.field2189 == class9.field87) {
                           class167.field2189 = class7.field66;
                        } else {
                           class167.field2189 = class9.field87;
                        }

                        ++Client.field318;
                        Client.field316 = 0;
                     } else {
                        class115.method2181(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field318 < 1) {
            if(class167.field2189 == class9.field87) {
               class167.field2189 = class7.field66;
            } else {
               class167.field2189 = class9.field87;
            }

            ++Client.field318;
            Client.field316 = 0;
         } else {
            class115.method2181(-2);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "484188084"
   )
   static void method83(class18 var0, int var1) {
      Object[] var2 = var0.field188;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = class157.method2971(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field950;
         int[] var9 = var4.field948;
         byte var10 = -1;
         class32.field722 = 0;

         int var13;
         try {
            class168.field2193 = new int[var4.field952];
            int var11 = 0;
            class32.field724 = new String[var4.field955];
            int var12 = 0;

            int var14;
            String var33;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field192;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field189;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field187 != null?var0.field187.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field198;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field187?var0.field187.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field196?var0.field196.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field196?var0.field196.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field190;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field193;
                  }

                  class168.field2193[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var33 = (String)var2[var13];
                  if(var33.equals("event_opbase")) {
                     var33 = var0.field194;
                  }

                  class32.field724[var12++] = var33;
               }
            }

            var13 = 0;
            class32.field728 = var0.field195;

            label3877:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var47 = var8[var7];
               int var10001;
               String var17;
               int var18;
               int var34;
               int var38;
               int var39;
               int[] var50;
               int var57;
               String var61;
               String var76;
               int var87;
               byte var112;
               if(var47 < 100) {
                  if(var47 == 0) {
                     class32.field720[var5++] = var9[var7];
                     continue;
                  }

                  if(var47 == 1) {
                     var14 = var9[var7];
                     class32.field720[var5++] = class165.widgetSettings[var14];
                     continue;
                  }

                  if(var47 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class165.widgetSettings[var14] = class32.field720[var5];
                     class47.method835(var14);
                     continue;
                  }

                  if(var47 == 3) {
                     class32.chatboxSegments[var6++] = var4.field951[var7];
                     continue;
                  }

                  if(var47 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var47 == 7) {
                     var5 -= 2;
                     if(class32.field720[var5 + 1] != class32.field720[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 8) {
                     var5 -= 2;
                     if(class32.field720[1 + var5] == class32.field720[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 9) {
                     var5 -= 2;
                     if(class32.field720[var5] < class32.field720[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 10) {
                     var5 -= 2;
                     if(class32.field720[var5] > class32.field720[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 21) {
                     if(class32.field722 == 0) {
                        return;
                     }

                     class11 var85 = class32.field732[--class32.field722];
                     var4 = var85.field118;
                     var8 = var4.field950;
                     var9 = var4.field948;
                     var7 = var85.field115;
                     class168.field2193 = var85.field111;
                     class32.field724 = var85.field112;
                     continue;
                  }

                  if(var47 == 25) {
                     var14 = var9[var7];
                     class32.field720[var5++] = class97.method1898(var14);
                     continue;
                  }

                  if(var47 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class31.method638(var14, class32.field720[var5]);
                     continue;
                  }

                  if(var47 == 31) {
                     var5 -= 2;
                     if(class32.field720[var5] <= class32.field720[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 32) {
                     var5 -= 2;
                     if(class32.field720[var5] >= class32.field720[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var47 == 33) {
                     class32.field720[var5++] = class168.field2193[var9[var7]];
                     continue;
                  }

                  if(var47 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class168.field2193[var10001] = class32.field720[var5];
                     continue;
                  }

                  if(var47 == 35) {
                     class32.chatboxSegments[var6++] = class32.field724[var9[var7]];
                     continue;
                  }

                  if(var47 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class32.field724[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var47 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var82 = class32.chatboxSegments;
                     if(var14 == 0) {
                        var76 = "";
                     } else if(var14 == 1) {
                        var17 = var82[var6];
                        if(null == var17) {
                           var76 = "null";
                        } else {
                           var76 = var17.toString();
                        }
                     } else {
                        var34 = var6 + var14;
                        var18 = 0;

                        for(var57 = var6; var57 < var34; ++var57) {
                           var61 = var82[var57];
                           if(null == var61) {
                              var18 += 4;
                           } else {
                              var18 += var61.length();
                           }
                        }

                        StringBuilder var108 = new StringBuilder(var18);

                        for(var87 = var6; var87 < var34; ++var87) {
                           String var62 = var82[var87];
                           if(var62 == null) {
                              var108.append("null");
                           } else {
                              var108.append(var62);
                           }
                        }

                        var76 = var108.toString();
                     }

                     class32.chatboxSegments[var6++] = var76;
                     continue;
                  }

                  if(var47 == 38) {
                     --var5;
                     continue;
                  }

                  if(var47 == 39) {
                     --var6;
                     continue;
                  }

                  if(var47 == 40) {
                     var14 = var9[var7];
                     class48 var119 = class157.method2971(var14);
                     var50 = new int[var119.field952];
                     String[] var69 = new String[var119.field955];

                     for(var18 = 0; var18 < var119.field954; ++var18) {
                        var50[var18] = class32.field720[var5 - var119.field954 + var18];
                     }

                     for(var18 = 0; var18 < var119.field949; ++var18) {
                        var69[var18] = class32.chatboxSegments[var18 + (var6 - var119.field949)];
                     }

                     var5 -= var119.field954;
                     var6 -= var119.field949;
                     class11 var114 = new class11();
                     var114.field118 = var4;
                     var114.field115 = var7;
                     var114.field111 = class168.field2193;
                     var114.field112 = class32.field724;
                     class32.field732[++class32.field722 - 1] = var114;
                     var4 = var119;
                     var8 = var119.field950;
                     var9 = var119.field948;
                     var7 = -1;
                     class168.field2193 = var50;
                     class32.field724 = var69;
                     continue;
                  }

                  if(var47 == 42) {
                     class32.field720[var5++] = Ignore.chatMessages.method805(var9[var7]);
                     continue;
                  }

                  if(var47 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     Ignore.chatMessages.method811(var10001, class32.field720[var5]);
                     continue;
                  }

                  if(var47 == 44) {
                     var14 = var9[var7] >> 16;
                     var38 = var9[var7] & '\uffff';
                     --var5;
                     var39 = class32.field720[var5];
                     if(var39 >= 0 && var39 <= 5000) {
                        class32.field727[var14] = var39;
                        var112 = -1;
                        if(var38 == 105) {
                           var112 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var39) {
                              continue label3877;
                           }

                           class32.field719[var14][var18] = var112;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var47 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var38 = class32.field720[var5];
                     if(var38 >= 0 && var38 < class32.field727[var14]) {
                        class32.field720[var5++] = class32.field719[var14][var38];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var47 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var38 = class32.field720[var5];
                     if(var38 >= 0 && var38 < class32.field727[var14]) {
                        class32.field719[var14][var38] = class32.field720[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var47 == 47) {
                     var33 = Ignore.chatMessages.method806(var9[var7]);
                     if(var33 == null) {
                        var33 = "null";
                     }

                     class32.chatboxSegments[var6++] = var33;
                     continue;
                  }

                  if(var47 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     Ignore.chatMessages.method832(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var58;
               if(var9[var7] == 1) {
                  var58 = true;
               } else {
                  var58 = false;
               }

               Widget var15;
               Widget var51;
               boolean var54;
               Widget var74;
               Widget var90;
               boolean var110;
               if(var47 < 1000) {
                  if(var47 == 100) {
                     var5 -= 3;
                     var38 = class32.field720[var5];
                     var39 = class32.field720[var5 + 1];
                     var34 = class32.field720[2 + var5];
                     if(var39 == 0) {
                        throw new RuntimeException();
                     }

                     var90 = class191.method3433(var38);
                     if(var90.children == null) {
                        var90.children = new Widget[var34 + 1];
                     }

                     if(var90.children.length <= var34) {
                        Widget[] var103 = new Widget[1 + var34];

                        for(var87 = 0; var87 < var90.children.length; ++var87) {
                           var103[var87] = var90.children[var87];
                        }

                        var90.children = var103;
                     }

                     if(var34 > 0 && var90.children[var34 - 1] == null) {
                        throw new RuntimeException("" + (var34 - 1));
                     }

                     Widget var104 = new Widget();
                     var104.type = var39;
                     var10001 = var90.id;
                     var104.id = var90.id * -267565191;
                     var104.parentId = var10001;
                     var104.index = var34;
                     var104.field2198 = true;
                     var90.children[var34] = var104;
                     if(var58) {
                        class88.field1538 = var104;
                     } else {
                        class32.field718 = var104;
                     }

                     class94.method1890(var90);
                     continue;
                  }

                  if(var47 == 101) {
                     var15 = var58?class88.field1538:class32.field718;
                     var74 = class191.method3433(var15.id);
                     var74.children[var15.index] = null;
                     class94.method1890(var74);
                     continue;
                  }

                  if(var47 == 102) {
                     --var5;
                     var15 = class191.method3433(class32.field720[var5]);
                     var15.children = null;
                     class94.method1890(var15);
                     continue;
                  }

                  if(var47 == 200) {
                     var5 -= 2;
                     var38 = class32.field720[var5];
                     var39 = class32.field720[1 + var5];
                     var51 = class26.method561(var38, var39);
                     if(null != var51 && var39 != -1) {
                        class32.field720[var5++] = 1;
                        if(var58) {
                           class88.field1538 = var51;
                        } else {
                           class32.field718 = var51;
                        }
                        continue;
                     }

                     class32.field720[var5++] = 0;
                     continue;
                  }

                  if(var47 == 201) {
                     --var5;
                     var15 = class191.method3433(class32.field720[var5]);
                     if(var15 != null) {
                        class32.field720[var5++] = 1;
                        if(var58) {
                           class88.field1538 = var15;
                        } else {
                           class32.field718 = var15;
                        }
                     } else {
                        class32.field720[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var106;
                  if(var47 >= 1000 && var47 < 1100 || var47 >= 2000 && var47 < 2100) {
                     var38 = -1;
                     if(var47 >= 2000) {
                        var47 -= 1000;
                        --var5;
                        var38 = class32.field720[var5];
                        var74 = class191.method3433(var38);
                     } else {
                        var74 = var58?class88.field1538:class32.field718;
                     }

                     if(var47 == 1000) {
                        var5 -= 4;
                        var74.field2288 = class32.field720[var5];
                        var74.field2218 = class32.field720[1 + var5];
                        var74.field2213 = class32.field720[2 + var5];
                        var74.field2214 = class32.field720[var5 + 3];
                        class94.method1890(var74);
                        FrameMap.method1687(var74);
                        if(var38 != -1 && var74.type == 0) {
                           class2.method18(Widget.widgets[var38 >> 16], var74, false);
                        }
                        continue;
                     }

                     if(var47 == 1001) {
                        var5 -= 4;
                        var74.field2219 = class32.field720[var5];
                        var74.field2220 = class32.field720[var5 + 1];
                        var74.field2215 = class32.field720[var5 + 2];
                        var74.field2264 = class32.field720[3 + var5];
                        class94.method1890(var74);
                        FrameMap.method1687(var74);
                        if(var38 != -1 && var74.type == 0) {
                           class2.method18(Widget.widgets[var38 >> 16], var74, false);
                        }
                        continue;
                     }

                     if(var47 == 1003) {
                        --var5;
                        var106 = class32.field720[var5] == 1;
                        if(var74.isHidden != var106) {
                           var74.isHidden = var106;
                           class94.method1890(var74);
                        }
                        continue;
                     }

                     if(var47 == 1005) {
                        --var5;
                        var74.field2341 = class32.field720[var5] == 1;
                        continue;
                     }

                     if(var47 == 1006) {
                        --var5;
                        var74.field2342 = class32.field720[var5] == 1;
                        continue;
                     }
                  } else if((var47 < 1100 || var47 >= 1200) && (var47 < 2100 || var47 >= 2200)) {
                     if((var47 < 1200 || var47 >= 1300) && (var47 < 2200 || var47 >= 2300)) {
                        if(var47 >= 1300 && var47 < 1400 || var47 >= 2300 && var47 < 2400) {
                           if(var47 >= 2000) {
                              var47 -= 1000;
                              --var5;
                              var15 = class191.method3433(class32.field720[var5]);
                           } else {
                              var15 = var58?class88.field1538:class32.field718;
                           }

                           if(var47 == 1300) {
                              --var5;
                              var39 = class32.field720[var5] - 1;
                              if(var39 >= 0 && var39 <= 9) {
                                 --var6;
                                 var15.method3102(var39, class32.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var47 == 1301) {
                              var5 -= 2;
                              var39 = class32.field720[var5];
                              var34 = class32.field720[1 + var5];
                              var15.parent = class26.method561(var39, var34);
                              continue;
                           }

                           if(var47 == 1302) {
                              --var5;
                              var15.field2286 = class32.field720[var5] == 1;
                              continue;
                           }

                           if(var47 == 1303) {
                              --var5;
                              var15.field2306 = class32.field720[var5];
                              continue;
                           }

                           if(var47 == 1304) {
                              --var5;
                              var15.field2285 = class32.field720[var5];
                              continue;
                           }

                           if(var47 == 1305) {
                              --var6;
                              var15.name = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var47 == 1306) {
                              --var6;
                              var15.field2287 = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var47 == 1307) {
                              var15.actions = null;
                              continue;
                           }
                        } else {
                           String var49;
                           int[] var53;
                           if(var47 >= 1400 && var47 < 1500 || var47 >= 2400 && var47 < 2500) {
                              if(var47 >= 2000) {
                                 var47 -= 1000;
                                 --var5;
                                 var15 = class191.method3433(class32.field720[var5]);
                              } else {
                                 var15 = var58?class88.field1538:class32.field718;
                              }

                              --var6;
                              var49 = class32.chatboxSegments[var6];
                              var53 = null;
                              if(var49.length() > 0 && var49.charAt(var49.length() - 1) == 89) {
                                 --var5;
                                 var18 = class32.field720[var5];
                                 if(var18 > 0) {
                                    for(var53 = new int[var18]; var18-- > 0; var53[var18] = class32.field720[var5]) {
                                       --var5;
                                    }
                                 }

                                 var49 = var49.substring(0, var49.length() - 1);
                              }

                              Object[] var107 = new Object[var49.length() + 1];

                              for(var57 = var107.length - 1; var57 >= 1; --var57) {
                                 if(var49.charAt(var57 - 1) == 115) {
                                    --var6;
                                    var107[var57] = class32.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var107[var57] = new Integer(class32.field720[var5]);
                                 }
                              }

                              --var5;
                              var57 = class32.field720[var5];
                              if(var57 != -1) {
                                 var107[0] = new Integer(var57);
                              } else {
                                 var107 = null;
                              }

                              if(var47 == 1400) {
                                 var15.field2290 = var107;
                              }

                              if(var47 == 1401) {
                                 var15.field2227 = var107;
                              }

                              if(var47 == 1402) {
                                 var15.field2207 = var107;
                              }

                              if(var47 == 1403) {
                                 var15.field2294 = var107;
                              }

                              if(var47 == 1404) {
                                 var15.field2295 = var107;
                              }

                              if(var47 == 1405) {
                                 var15.field2318 = var107;
                              }

                              if(var47 == 1406) {
                                 var15.field2296 = var107;
                              }

                              if(var47 == 1407) {
                                 var15.field2301 = var107;
                                 var15.field2302 = var53;
                              }

                              if(var47 == 1408) {
                                 var15.field2307 = var107;
                              }

                              if(var47 == 1409) {
                                 var15.field2308 = var107;
                              }

                              if(var47 == 1410) {
                                 var15.field2298 = var107;
                              }

                              if(var47 == 1411) {
                                 var15.field2291 = var107;
                              }

                              if(var47 == 1412) {
                                 var15.field2259 = var107;
                              }

                              if(var47 == 1414) {
                                 var15.field2303 = var107;
                                 var15.field2304 = var53;
                              }

                              if(var47 == 1415) {
                                 var15.field2216 = var107;
                                 var15.field2241 = var53;
                              }

                              if(var47 == 1416) {
                                 var15.field2334 = var107;
                              }

                              if(var47 == 1417) {
                                 var15.field2309 = var107;
                              }

                              if(var47 == 1418) {
                                 var15.field2310 = var107;
                              }

                              if(var47 == 1419) {
                                 var15.field2311 = var107;
                              }

                              if(var47 == 1420) {
                                 var15.field2238 = var107;
                              }

                              if(var47 == 1421) {
                                 var15.field2313 = var107;
                              }

                              if(var47 == 1422) {
                                 var15.field2337 = var107;
                              }

                              if(var47 == 1423) {
                                 var15.field2315 = var107;
                              }

                              if(var47 == 1424) {
                                 var15.field2316 = var107;
                              }

                              if(var47 == 1425) {
                                 var15.field2268 = var107;
                              }

                              if(var47 == 1426) {
                                 var15.field2319 = var107;
                              }

                              if(var47 == 1427) {
                                 var15.field2317 = var107;
                              }

                              var15.field2280 = true;
                              continue;
                           }

                           if(var47 < 1600) {
                              var15 = var58?class88.field1538:class32.field718;
                              if(var47 == 1500) {
                                 class32.field720[var5++] = var15.relativeX;
                                 continue;
                              }

                              if(var47 == 1501) {
                                 class32.field720[var5++] = var15.relativeY;
                                 continue;
                              }

                              if(var47 == 1502) {
                                 class32.field720[var5++] = var15.width;
                                 continue;
                              }

                              if(var47 == 1503) {
                                 class32.field720[var5++] = var15.height;
                                 continue;
                              }

                              if(var47 == 1504) {
                                 class32.field720[var5++] = var15.isHidden?1:0;
                                 continue;
                              }

                              if(var47 == 1505) {
                                 class32.field720[var5++] = var15.parentId;
                                 continue;
                              }
                           } else if(var47 < 1700) {
                              var15 = var58?class88.field1538:class32.field718;
                              if(var47 == 1600) {
                                 class32.field720[var5++] = var15.scrollX;
                                 continue;
                              }

                              if(var47 == 1601) {
                                 class32.field720[var5++] = var15.scrollY;
                                 continue;
                              }

                              if(var47 == 1602) {
                                 class32.chatboxSegments[var6++] = var15.text;
                                 continue;
                              }

                              if(var47 == 1603) {
                                 class32.field720[var5++] = var15.scrollWidth;
                                 continue;
                              }

                              if(var47 == 1604) {
                                 class32.field720[var5++] = var15.scrollHeight;
                                 continue;
                              }

                              if(var47 == 1605) {
                                 class32.field720[var5++] = var15.field2262;
                                 continue;
                              }

                              if(var47 == 1606) {
                                 class32.field720[var5++] = var15.rotationX;
                                 continue;
                              }

                              if(var47 == 1607) {
                                 class32.field720[var5++] = var15.rotationY;
                                 continue;
                              }

                              if(var47 == 1608) {
                                 class32.field720[var5++] = var15.rotationZ;
                                 continue;
                              }

                              if(var47 == 1609) {
                                 class32.field720[var5++] = var15.opacity;
                                 continue;
                              }

                              if(var47 == 1610) {
                                 class32.field720[var5++] = var15.field2270;
                                 continue;
                              }

                              if(var47 == 1611) {
                                 class32.field720[var5++] = var15.textColor;
                                 continue;
                              }

                              if(var47 == 1612) {
                                 class32.field720[var5++] = var15.field2234;
                                 continue;
                              }

                              if(var47 == 1613) {
                                 class32.field720[var5++] = var15.field2204.vmethod3974();
                                 continue;
                              }
                           } else if(var47 < 1800) {
                              var15 = var58?class88.field1538:class32.field718;
                              if(var47 == 1700) {
                                 class32.field720[var5++] = var15.item;
                                 continue;
                              }

                              if(var47 == 1701) {
                                 if(var15.item != -1) {
                                    class32.field720[var5++] = var15.stackSize;
                                 } else {
                                    class32.field720[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var47 == 1702) {
                                 class32.field720[var5++] = var15.index;
                                 continue;
                              }
                           } else if(var47 < 1900) {
                              var15 = var58?class88.field1538:class32.field718;
                              if(var47 == 1800) {
                                 class32.field720[var5++] = RSCanvas.method2049(class143.method2647(var15));
                                 continue;
                              }

                              if(var47 == 1801) {
                                 --var5;
                                 var39 = class32.field720[var5];
                                 --var39;
                                 if(var15.actions != null && var39 < var15.actions.length && null != var15.actions[var39]) {
                                    class32.chatboxSegments[var6++] = var15.actions[var39];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var47 == 1802) {
                                 if(var15.name == null) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var15.name;
                                 }
                                 continue;
                              }
                           } else if((var47 < 1900 || var47 >= 2000) && (var47 < 2900 || var47 >= 3000)) {
                              if(var47 < 2600) {
                                 --var5;
                                 var15 = class191.method3433(class32.field720[var5]);
                                 if(var47 == 2500) {
                                    class32.field720[var5++] = var15.relativeX;
                                    continue;
                                 }

                                 if(var47 == 2501) {
                                    class32.field720[var5++] = var15.relativeY;
                                    continue;
                                 }

                                 if(var47 == 2502) {
                                    class32.field720[var5++] = var15.width;
                                    continue;
                                 }

                                 if(var47 == 2503) {
                                    class32.field720[var5++] = var15.height;
                                    continue;
                                 }

                                 if(var47 == 2504) {
                                    class32.field720[var5++] = var15.isHidden?1:0;
                                    continue;
                                 }

                                 if(var47 == 2505) {
                                    class32.field720[var5++] = var15.parentId;
                                    continue;
                                 }
                              } else if(var47 < 2700) {
                                 --var5;
                                 var15 = class191.method3433(class32.field720[var5]);
                                 if(var47 == 2600) {
                                    class32.field720[var5++] = var15.scrollX;
                                    continue;
                                 }

                                 if(var47 == 2601) {
                                    class32.field720[var5++] = var15.scrollY;
                                    continue;
                                 }

                                 if(var47 == 2602) {
                                    class32.chatboxSegments[var6++] = var15.text;
                                    continue;
                                 }

                                 if(var47 == 2603) {
                                    class32.field720[var5++] = var15.scrollWidth;
                                    continue;
                                 }

                                 if(var47 == 2604) {
                                    class32.field720[var5++] = var15.scrollHeight;
                                    continue;
                                 }

                                 if(var47 == 2605) {
                                    class32.field720[var5++] = var15.field2262;
                                    continue;
                                 }

                                 if(var47 == 2606) {
                                    class32.field720[var5++] = var15.rotationX;
                                    continue;
                                 }

                                 if(var47 == 2607) {
                                    class32.field720[var5++] = var15.rotationY;
                                    continue;
                                 }

                                 if(var47 == 2608) {
                                    class32.field720[var5++] = var15.rotationZ;
                                    continue;
                                 }

                                 if(var47 == 2609) {
                                    class32.field720[var5++] = var15.opacity;
                                    continue;
                                 }

                                 if(var47 == 2610) {
                                    class32.field720[var5++] = var15.field2270;
                                    continue;
                                 }

                                 if(var47 == 2611) {
                                    class32.field720[var5++] = var15.textColor;
                                    continue;
                                 }

                                 if(var47 == 2612) {
                                    class32.field720[var5++] = var15.field2234;
                                    continue;
                                 }

                                 if(var47 == 2613) {
                                    class32.field720[var5++] = var15.field2204.vmethod3974();
                                    continue;
                                 }
                              } else if(var47 < 2800) {
                                 if(var47 == 2700) {
                                    --var5;
                                    var15 = class191.method3433(class32.field720[var5]);
                                    class32.field720[var5++] = var15.item;
                                    continue;
                                 }

                                 if(var47 == 2701) {
                                    --var5;
                                    var15 = class191.method3433(class32.field720[var5]);
                                    if(var15.item != -1) {
                                       class32.field720[var5++] = var15.stackSize;
                                    } else {
                                       class32.field720[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var47 == 2702) {
                                    --var5;
                                    var38 = class32.field720[var5];
                                    WidgetNode var48 = (WidgetNode)Client.componentTable.method2311((long)var38);
                                    if(null != var48) {
                                       class32.field720[var5++] = 1;
                                    } else {
                                       class32.field720[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var47 == 2706) {
                                    class32.field720[var5++] = Client.widgetRoot;
                                    continue;
                                 }
                              } else if(var47 < 2900) {
                                 --var5;
                                 var15 = class191.method3433(class32.field720[var5]);
                                 if(var47 == 2800) {
                                    class32.field720[var5++] = RSCanvas.method2049(class143.method2647(var15));
                                    continue;
                                 }

                                 if(var47 == 2801) {
                                    --var5;
                                    var39 = class32.field720[var5];
                                    --var39;
                                    if(null != var15.actions && var39 < var15.actions.length && null != var15.actions[var39]) {
                                       class32.chatboxSegments[var6++] = var15.actions[var39];
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var47 == 2802) {
                                    if(null == var15.name) {
                                       class32.chatboxSegments[var6++] = "";
                                    } else {
                                       class32.chatboxSegments[var6++] = var15.name;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 int var23;
                                 int var25;
                                 int var40;
                                 int var70;
                                 if(var47 < 3200) {
                                    if(var47 == 3100) {
                                       --var6;
                                       var76 = class32.chatboxSegments[var6];
                                       ObjectComposition.method3581(0, "", var76);
                                       continue;
                                    }

                                    if(var47 == 3101) {
                                       var5 -= 2;
                                       XGrandExchangeOffer.method38(class39.localPlayer, class32.field720[var5], class32.field720[1 + var5]);
                                       continue;
                                    }

                                    if(var47 == 3103) {
                                       CombatInfoListHolder.method674();
                                       continue;
                                    }

                                    if(var47 == 3104) {
                                       --var6;
                                       var76 = class32.chatboxSegments[var6];
                                       var39 = 0;
                                       boolean var19 = false;
                                       boolean var36 = false;
                                       var40 = 0;
                                       var22 = var76.length();
                                       var23 = 0;

                                       while(true) {
                                          if(var23 >= var22) {
                                             var54 = var36;
                                             break;
                                          }

                                          label4187: {
                                             char var24 = var76.charAt(var23);
                                             if(var23 == 0) {
                                                if(var24 == 45) {
                                                   var19 = true;
                                                   break label4187;
                                                }

                                                if(var24 == 43) {
                                                   break label4187;
                                                }
                                             }

                                             if(var24 >= 48 && var24 <= 57) {
                                                var70 = var24 - 48;
                                             } else if(var24 >= 65 && var24 <= 90) {
                                                var70 = var24 - 55;
                                             } else {
                                                if(var24 < 97 || var24 > 122) {
                                                   var54 = false;
                                                   break;
                                                }

                                                var70 = var24 - 87;
                                             }

                                             if(var70 >= 10) {
                                                var54 = false;
                                                break;
                                             }

                                             if(var19) {
                                                var70 = -var70;
                                             }

                                             var25 = var70 + 10 * var40;
                                             if(var40 != var25 / 10) {
                                                var54 = false;
                                                break;
                                             }

                                             var40 = var25;
                                             var36 = true;
                                          }

                                          ++var23;
                                       }

                                       if(var54) {
                                          var39 = class177.method3191(var76);
                                       }

                                       Client.field294.method2976(54);
                                       Client.field294.method2748(var39);
                                       continue;
                                    }

                                    if(var47 == 3105) {
                                       --var6;
                                       var76 = class32.chatboxSegments[var6];
                                       Client.field294.method2976(100);
                                       Client.field294.method2932(var76.length() + 1);
                                       Client.field294.method2757(var76);
                                       continue;
                                    }

                                    if(var47 == 3106) {
                                       --var6;
                                       var76 = class32.chatboxSegments[var6];
                                       Client.field294.method2976(145);
                                       Client.field294.method2932(var76.length() + 1);
                                       Client.field294.method2757(var76);
                                       continue;
                                    }

                                    if(var47 == 3107) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       --var6;
                                       var49 = class32.chatboxSegments[var6];
                                       Ignore.method189(var38, var49);
                                       continue;
                                    }

                                    if(var47 == 3108) {
                                       var5 -= 3;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[1 + var5];
                                       var34 = class32.field720[2 + var5];
                                       var90 = class191.method3433(var34);
                                       DecorativeObject.method1894(var90, var38, var39);
                                       continue;
                                    }

                                    if(var47 == 3109) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[1 + var5];
                                       var51 = var58?class88.field1538:class32.field718;
                                       DecorativeObject.method1894(var51, var38, var39);
                                       continue;
                                    }

                                    if(var47 == 3110) {
                                       --var5;
                                       class103.field1662 = class32.field720[var5] == 1;
                                       continue;
                                    }

                                    if(var47 == 3111) {
                                       class32.field720[var5++] = class149.field2044.field689?1:0;
                                       continue;
                                    }

                                    if(var47 == 3112) {
                                       --var5;
                                       class149.field2044.field689 = class32.field720[var5] == 1;
                                       class41.method759();
                                       continue;
                                    }

                                    if(var47 == 3113) {
                                       --var6;
                                       var76 = class32.chatboxSegments[var6];
                                       --var5;
                                       var110 = class32.field720[var5] == 1;
                                       if(!var110) {
                                          GroundObject.method1528(var76, 3);
                                          continue;
                                       }

                                       if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                          try {
                                             Desktop.getDesktop().browse(new URI(var76));
                                             continue;
                                          } catch (Exception var45) {
                                             ;
                                          }
                                       }

                                       if(class114.field1784.startsWith("win")) {
                                          GroundObject.method1528(var76, 0);
                                       } else if(class114.field1784.startsWith("mac")) {
                                          NPC.method689(var76, 1, "openjs");
                                       } else {
                                          GroundObject.method1528(var76, 2);
                                       }
                                       continue;
                                    }

                                    if(var47 == 3115) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       Client.field294.method2976(233);
                                       Client.field294.method2746(var38);
                                       continue;
                                    }

                                    if(var47 == 3116) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       var6 -= 2;
                                       var49 = class32.chatboxSegments[var6];
                                       var17 = class32.chatboxSegments[1 + var6];
                                       if(var49.length() <= 500 && var17.length() <= 500) {
                                          Client.field294.method2976(189);
                                          Client.field294.method2746(1 + class57.method1067(var49) + class57.method1067(var17));
                                          Client.field294.method2757(var49);
                                          Client.field294.method2785(var38);
                                          Client.field294.method2757(var17);
                                       }
                                       continue;
                                    }
                                 } else if(var47 < 3300) {
                                    if(var47 == 3200) {
                                       var5 -= 3;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[1 + var5];
                                       var34 = class32.field720[2 + var5];
                                       if(Client.field482 != 0 && var39 != 0 && Client.field528 < 50) {
                                          Client.field529[Client.field528] = var38;
                                          Client.field409[Client.field528] = var39;
                                          Client.field439[Client.field528] = var34;
                                          Client.field533[Client.field528] = null;
                                          Client.field483[Client.field528] = 0;
                                          ++Client.field528;
                                       }
                                       continue;
                                    }

                                    if(var47 == 3201) {
                                       --var5;
                                       class168.method3100(class32.field720[var5]);
                                       continue;
                                    }

                                    if(var47 == 3202) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5];
                                       int var10000 = class32.field720[var5 + 1];
                                       if(Client.field373 != 0 && var38 != -1) {
                                          class116.method2199(class105.field1706, var38, 0, Client.field373, false);
                                          Client.field525 = true;
                                       }
                                       continue;
                                    }
                                 } else if(var47 < 3400) {
                                    if(var47 == 3300) {
                                       class32.field720[var5++] = Client.gameCycle;
                                       continue;
                                    }

                                    if(var47 == 3301) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[var5 + 1];
                                       class32.field720[var5++] = class33.method664(var38, var39);
                                       continue;
                                    }

                                    if(var47 == 3302) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[var5 + 1];
                                       class32.field720[var5++] = class94.method1889(var38, var39);
                                       continue;
                                    }

                                    XItemContainer var20;
                                    if(var47 == 3303) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[1 + var5];
                                       var53 = class32.field720;
                                       var18 = var5++;
                                       var20 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var38);
                                       if(var20 == null) {
                                          var57 = 0;
                                       } else if(var39 == -1) {
                                          var57 = 0;
                                       } else {
                                          var40 = 0;

                                          for(var22 = 0; var22 < var20.stackSizes.length; ++var22) {
                                             if(var39 == var20.itemIds[var22]) {
                                                var40 += var20.stackSizes[var22];
                                             }
                                          }

                                          var57 = var40;
                                       }

                                       var53[var18] = var57;
                                       continue;
                                    }

                                    if(var47 == 3304) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       var50 = class32.field720;
                                       var34 = var5++;
                                       class186 var35 = (class186)class186.field2771.get((long)var38);
                                       class186 var92;
                                       if(var35 != null) {
                                          var92 = var35;
                                       } else {
                                          byte[] var59 = class186.field2774.method3211(5, var38);
                                          var35 = new class186();
                                          if(var59 != null) {
                                             var35.method3363(new Buffer(var59));
                                          }

                                          class186.field2771.put(var35, (long)var38);
                                          var92 = var35;
                                       }

                                       var50[var34] = var92.field2773;
                                       continue;
                                    }

                                    if(var47 == 3305) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       class32.field720[var5++] = Client.boostedSkillLevels[var38];
                                       continue;
                                    }

                                    if(var47 == 3306) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       class32.field720[var5++] = Client.realSkillLevels[var38];
                                       continue;
                                    }

                                    if(var47 == 3307) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       class32.field720[var5++] = Client.skillExperiences[var38];
                                       continue;
                                    }

                                    if(var47 == 3308) {
                                       var38 = class171.plane;
                                       var39 = class15.baseX + (class39.localPlayer.x >> 7);
                                       var34 = class20.baseY + (class39.localPlayer.y >> 7);
                                       class32.field720[var5++] = (var39 << 14) + (var38 << 28) + var34;
                                       continue;
                                    }

                                    if(var47 == 3309) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       class32.field720[var5++] = var38 >> 14 & 16383;
                                       continue;
                                    }

                                    if(var47 == 3310) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       class32.field720[var5++] = var38 >> 28;
                                       continue;
                                    }

                                    if(var47 == 3311) {
                                       --var5;
                                       var38 = class32.field720[var5];
                                       class32.field720[var5++] = var38 & 16383;
                                       continue;
                                    }

                                    if(var47 == 3312) {
                                       class32.field720[var5++] = Client.isMembers?1:0;
                                       continue;
                                    }

                                    if(var47 == 3313) {
                                       var5 -= 2;
                                       var38 = '耀' + class32.field720[var5];
                                       var39 = class32.field720[var5 + 1];
                                       class32.field720[var5++] = class33.method664(var38, var39);
                                       continue;
                                    }

                                    if(var47 == 3314) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5] + '耀';
                                       var39 = class32.field720[var5 + 1];
                                       class32.field720[var5++] = class94.method1889(var38, var39);
                                       continue;
                                    }

                                    if(var47 == 3315) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5] + '耀';
                                       var39 = class32.field720[var5 + 1];
                                       var53 = class32.field720;
                                       var18 = var5++;
                                       var20 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var38);
                                       if(var20 == null) {
                                          var57 = 0;
                                       } else if(var39 == -1) {
                                          var57 = 0;
                                       } else {
                                          var40 = 0;

                                          for(var22 = 0; var22 < var20.stackSizes.length; ++var22) {
                                             if(var39 == var20.itemIds[var22]) {
                                                var40 += var20.stackSizes[var22];
                                             }
                                          }

                                          var57 = var40;
                                       }

                                       var53[var18] = var57;
                                       continue;
                                    }

                                    if(var47 == 3316) {
                                       if(Client.field358 >= 2) {
                                          class32.field720[var5++] = Client.field358;
                                       } else {
                                          class32.field720[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var47 == 3317) {
                                       class32.field720[var5++] = Client.field300;
                                       continue;
                                    }

                                    if(var47 == 3318) {
                                       class32.field720[var5++] = Client.world;
                                       continue;
                                    }

                                    if(var47 == 3321) {
                                       class32.field720[var5++] = Client.energy;
                                       continue;
                                    }

                                    if(var47 == 3322) {
                                       class32.field720[var5++] = Client.weight;
                                       continue;
                                    }

                                    if(var47 == 3323) {
                                       if(Client.field455) {
                                          class32.field720[var5++] = 1;
                                       } else {
                                          class32.field720[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var47 == 3324) {
                                       class32.field720[var5++] = Client.flags;
                                       continue;
                                    }
                                 } else if(var47 < 3500) {
                                    if(var47 == 3400) {
                                       var5 -= 2;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[var5 + 1];
                                       class195 var55 = class183.method3314(var38);
                                       if(var55.field2862 != 115) {
                                          ;
                                       }

                                       for(var18 = 0; var18 < var55.field2859; ++var18) {
                                          if(var39 == var55.field2860[var18]) {
                                             class32.chatboxSegments[var6++] = var55.field2858[var18];
                                             var55 = null;
                                             break;
                                          }
                                       }

                                       if(var55 != null) {
                                          class32.chatboxSegments[var6++] = var55.field2857;
                                       }
                                       continue;
                                    }

                                    if(var47 == 3408) {
                                       var5 -= 4;
                                       var38 = class32.field720[var5];
                                       var39 = class32.field720[var5 + 1];
                                       var34 = class32.field720[var5 + 2];
                                       var18 = class32.field720[var5 + 3];
                                       class195 var86 = class183.method3314(var34);
                                       if(var86.field2853 == var38 && var39 == var86.field2862) {
                                          for(var87 = 0; var87 < var86.field2859; ++var87) {
                                             if(var86.field2860[var87] == var18) {
                                                if(var39 == 115) {
                                                   class32.chatboxSegments[var6++] = var86.field2858[var87];
                                                } else {
                                                   class32.field720[var5++] = var86.field2855[var87];
                                                }

                                                var86 = null;
                                                break;
                                             }
                                          }

                                          if(var86 != null) {
                                             if(var39 == 115) {
                                                class32.chatboxSegments[var6++] = var86.field2857;
                                             } else {
                                                class32.field720[var5++] = var86.field2863;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var39 == 115) {
                                          class32.chatboxSegments[var6++] = "null";
                                       } else {
                                          class32.field720[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    String var88;
                                    if(var47 < 3700) {
                                       if(var47 == 3600) {
                                          if(Client.field554 == 0) {
                                             class32.field720[var5++] = -2;
                                          } else if(Client.field554 == 1) {
                                             class32.field720[var5++] = -1;
                                          } else {
                                             class32.field720[var5++] = Client.friendCount;
                                          }
                                          continue;
                                       }

                                       if(var47 == 3601) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(Client.field554 == 2 && var38 < Client.friendCount) {
                                             class32.chatboxSegments[var6++] = Client.friends[var38].name;
                                             class32.chatboxSegments[var6++] = Client.friends[var38].previousName;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var47 == 3602) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(Client.field554 == 2 && var38 < Client.friendCount) {
                                             class32.field720[var5++] = Client.friends[var38].world;
                                             continue;
                                          }

                                          class32.field720[var5++] = 0;
                                          continue;
                                       }

                                       if(var47 == 3603) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(Client.field554 == 2 && var38 < Client.friendCount) {
                                             class32.field720[var5++] = Client.friends[var38].rank;
                                             continue;
                                          }

                                          class32.field720[var5++] = 0;
                                          continue;
                                       }

                                       if(var47 == 3604) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          --var5;
                                          var39 = class32.field720[var5];
                                          Client.field294.method2976(137);
                                          Client.field294.method2932(class57.method1067(var76) + 1);
                                          Client.field294.method2757(var76);
                                          Client.field294.method2784(var39);
                                          continue;
                                       }

                                       if(var47 == 3605) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          class10.method134(var76);
                                          continue;
                                       }

                                       if(var47 == 3606) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          class112.method2068(var76);
                                          continue;
                                       }

                                       Ignore var96;
                                       if(var47 == 3607) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          if(null == var76) {
                                             continue;
                                          }

                                          if((Client.ignoreCount < 100 || Client.field410 == 1) && Client.ignoreCount < 400) {
                                             var49 = class118.method2244(var76, class108.field1724);
                                             if(null == var49) {
                                                continue;
                                             }

                                             for(var34 = 0; var34 < Client.ignoreCount; ++var34) {
                                                var96 = Client.ignores[var34];
                                                var88 = class118.method2244(var96.name, class108.field1724);
                                                if(null != var88 && var88.equals(var49)) {
                                                   ObjectComposition.method3581(31, "", var76 + " is already on your ignore list");
                                                   continue label3877;
                                                }

                                                if(null != var96.previousName) {
                                                   var61 = class118.method2244(var96.previousName, class108.field1724);
                                                   if(var61 != null && var61.equals(var49)) {
                                                      ObjectComposition.method3581(31, "", var76 + " is already on your ignore list");
                                                      continue label3877;
                                                   }
                                                }
                                             }

                                             for(var34 = 0; var34 < Client.friendCount; ++var34) {
                                                Friend var99 = Client.friends[var34];
                                                var88 = class118.method2244(var99.name, class108.field1724);
                                                if(var88 != null && var88.equals(var49)) {
                                                   ObjectComposition.method3581(31, "", "Please remove " + var76 + " from your friend list first");
                                                   continue label3877;
                                                }

                                                if(null != var99.previousName) {
                                                   var61 = class118.method2244(var99.previousName, class108.field1724);
                                                   if(var61 != null && var61.equals(var49)) {
                                                      ObjectComposition.method3581(31, "", "Please remove " + var76 + " from your friend list first");
                                                      continue label3877;
                                                   }
                                                }
                                             }

                                             if(class118.method2244(class39.localPlayer.name, class108.field1724).equals(var49)) {
                                                ObjectComposition.method3581(31, "", "You can\'t add yourself to your own ignore list");
                                             } else {
                                                Client.field294.method2976(251);
                                                Client.field294.method2932(class57.method1067(var76));
                                                Client.field294.method2757(var76);
                                             }
                                             continue;
                                          }

                                          ObjectComposition.method3581(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var47 == 3608) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          if(null == var76) {
                                             continue;
                                          }

                                          var49 = class118.method2244(var76, class108.field1724);
                                          if(null == var49) {
                                             continue;
                                          }

                                          var34 = 0;

                                          while(true) {
                                             if(var34 >= Client.ignoreCount) {
                                                continue label3877;
                                             }

                                             var96 = Client.ignores[var34];
                                             var88 = var96.name;
                                             var61 = class118.method2244(var88, class108.field1724);
                                             boolean var111;
                                             if(null != var76 && var88 != null) {
                                                if(!var76.startsWith("#") && !var88.startsWith("#")) {
                                                   var111 = var49.equals(var61);
                                                } else {
                                                   var111 = var76.equals(var88);
                                                }
                                             } else {
                                                var111 = false;
                                             }

                                             if(var111) {
                                                --Client.ignoreCount;

                                                for(var22 = var34; var22 < Client.ignoreCount; ++var22) {
                                                   Client.ignores[var22] = Client.ignores[1 + var22];
                                                }

                                                Client.field479 = Client.field471;
                                                Client.field294.method2976(205);
                                                Client.field294.method2932(class57.method1067(var76));
                                                Client.field294.method2757(var76);
                                                continue label3877;
                                             }

                                             ++var34;
                                          }
                                       }

                                       if(var47 == 3609) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          class177[] var52 = class16.method181();

                                          for(var34 = 0; var34 < var52.length; ++var34) {
                                             class177 var95 = var52[var34];
                                             if(var95.field2659 != -1 && var76.startsWith(XGrandExchangeOffer.method56(var95.field2659))) {
                                                var76 = var76.substring(6 + Integer.toString(var95.field2659).length());
                                                break;
                                             }
                                          }

                                          class32.field720[var5++] = class119.method2252(var76, false)?1:0;
                                          continue;
                                       }

                                       if(var47 == 3611) {
                                          if(null != Client.field513) {
                                             class32.chatboxSegments[var6++] = NPCComposition.method3660(Client.field513);
                                          } else {
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var47 == 3612) {
                                          if(Client.field513 != null) {
                                             class32.field720[var5++] = class13.field136;
                                          } else {
                                             class32.field720[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var47 == 3613) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(Client.field513 != null && var38 < class13.field136) {
                                             class32.chatboxSegments[var6++] = class8.clanMembers[var38].username;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var47 == 3614) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(null != Client.field513 && var38 < class13.field136) {
                                             class32.field720[var5++] = class8.clanMembers[var38].world;
                                             continue;
                                          }

                                          class32.field720[var5++] = 0;
                                          continue;
                                       }

                                       if(var47 == 3615) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(null != Client.field513 && var38 < class13.field136) {
                                             class32.field720[var5++] = class8.clanMembers[var38].rank;
                                             continue;
                                          }

                                          class32.field720[var5++] = 0;
                                          continue;
                                       }

                                       if(var47 == 3616) {
                                          class32.field720[var5++] = World.field683;
                                          continue;
                                       }

                                       if(var47 == 3617) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          if(class8.clanMembers != null) {
                                             Client.field294.method2976(120);
                                             Client.field294.method2932(class57.method1067(var76));
                                             Client.field294.method2757(var76);
                                          }
                                          continue;
                                       }

                                       if(var47 == 3618) {
                                          class32.field720[var5++] = class20.field218;
                                          continue;
                                       }

                                       if(var47 == 3619) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          if(!var76.equals("")) {
                                             Client.field294.method2976(204);
                                             Client.field294.method2932(class57.method1067(var76));
                                             Client.field294.method2757(var76);
                                          }
                                          continue;
                                       }

                                       if(var47 == 3620) {
                                          Client.field294.method2976(204);
                                          Client.field294.method2932(0);
                                          continue;
                                       }

                                       if(var47 == 3621) {
                                          if(Client.field554 == 0) {
                                             class32.field720[var5++] = -1;
                                          } else {
                                             class32.field720[var5++] = Client.ignoreCount;
                                          }
                                          continue;
                                       }

                                       if(var47 == 3622) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(Client.field554 != 0 && var38 < Client.ignoreCount) {
                                             class32.chatboxSegments[var6++] = Client.ignores[var38].name;
                                             class32.chatboxSegments[var6++] = Client.ignores[var38].previousName;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var47 == 3623) {
                                          --var6;
                                          var76 = class32.chatboxSegments[var6];
                                          var17 = "<img=0>";
                                          if(var76.startsWith(var17) || var76.startsWith(XGrandExchangeOffer.method56(1))) {
                                             var76 = var76.substring(7);
                                          }

                                          class32.field720[var5++] = class189.method3399(var76)?1:0;
                                          continue;
                                       }

                                       if(var47 == 3624) {
                                          --var5;
                                          var38 = class32.field720[var5];
                                          if(null != class8.clanMembers && var38 < class13.field136 && class8.clanMembers[var38].username.equalsIgnoreCase(class39.localPlayer.name)) {
                                             class32.field720[var5++] = 1;
                                             continue;
                                          }

                                          class32.field720[var5++] = 0;
                                          continue;
                                       }

                                       if(var47 == 3625) {
                                          if(Client.clanChatOwner != null) {
                                             class32.chatboxSegments[var6++] = NPCComposition.method3660(Client.clanChatOwner);
                                          } else {
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }
                                    } else {
                                       long var98;
                                       if(var47 < 4000) {
                                          if(var47 == 3903) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = Client.grandExchangeOffers[var38].method41();
                                             continue;
                                          }

                                          if(var47 == 3904) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = Client.grandExchangeOffers[var38].itemId;
                                             continue;
                                          }

                                          if(var47 == 3905) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = Client.grandExchangeOffers[var38].price;
                                             continue;
                                          }

                                          if(var47 == 3906) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = Client.grandExchangeOffers[var38].totalQuantity;
                                             continue;
                                          }

                                          if(var47 == 3907) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = Client.grandExchangeOffers[var38].quantitySold;
                                             continue;
                                          }

                                          if(var47 == 3908) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = Client.grandExchangeOffers[var38].spent;
                                             continue;
                                          }

                                          if(var47 == 3910) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var39 = Client.grandExchangeOffers[var38].method40();
                                             class32.field720[var5++] = var39 == 0?1:0;
                                             continue;
                                          }

                                          if(var47 == 3911) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var39 = Client.grandExchangeOffers[var38].method40();
                                             class32.field720[var5++] = var39 == 2?1:0;
                                             continue;
                                          }

                                          if(var47 == 3912) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var39 = Client.grandExchangeOffers[var38].method40();
                                             class32.field720[var5++] = var39 == 5?1:0;
                                             continue;
                                          }

                                          if(var47 == 3913) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var39 = Client.grandExchangeOffers[var38].method40();
                                             class32.field720[var5++] = var39 == 1?1:0;
                                             continue;
                                          }

                                          boolean var113;
                                          if(var47 == 3914) {
                                             --var5;
                                             var113 = class32.field720[var5] == 1;
                                             if(CombatInfoListHolder.field749 != null) {
                                                CombatInfoListHolder.field749.method15(class1.field12, var113);
                                             }
                                             continue;
                                          }

                                          if(var47 == 3915) {
                                             --var5;
                                             var113 = class32.field720[var5] == 1;
                                             if(null != CombatInfoListHolder.field749) {
                                                CombatInfoListHolder.field749.method15(class1.field11, var113);
                                             }
                                             continue;
                                          }

                                          if(var47 == 3916) {
                                             var5 -= 2;
                                             var113 = class32.field720[var5] == 1;
                                             var110 = class32.field720[1 + var5] == 1;
                                             if(CombatInfoListHolder.field749 != null) {
                                                CombatInfoListHolder.field749.method15(new class44(var110), var113);
                                             }
                                             continue;
                                          }

                                          if(var47 == 3917) {
                                             --var5;
                                             var113 = class32.field720[var5] == 1;
                                             if(CombatInfoListHolder.field749 != null) {
                                                CombatInfoListHolder.field749.method15(class1.field10, var113);
                                             }
                                             continue;
                                          }

                                          if(var47 == 3918) {
                                             --var5;
                                             var113 = class32.field720[var5] == 1;
                                             if(CombatInfoListHolder.field749 != null) {
                                                CombatInfoListHolder.field749.method15(class1.field13, var113);
                                             }
                                             continue;
                                          }

                                          if(var47 == 3919) {
                                             class32.field720[var5++] = CombatInfoListHolder.field749 == null?0:CombatInfoListHolder.field749.field14.size();
                                             continue;
                                          }

                                          class2 var56;
                                          if(var47 == 3920) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             class32.field720[var5++] = var56.field23;
                                             continue;
                                          }

                                          if(var47 == 3921) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             class32.chatboxSegments[var6++] = var56.method24();
                                             continue;
                                          }

                                          if(var47 == 3922) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             class32.chatboxSegments[var6++] = var56.method19();
                                             continue;
                                          }

                                          if(var47 == 3923) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             var98 = class72.method1385() - Sequence.field3061 - var56.field26;
                                             var57 = (int)(var98 / 3600000L);
                                             var87 = (int)((var98 - (long)(var57 * 3600000)) / 60000L);
                                             var40 = (int)((var98 - (long)(var57 * 3600000) - (long)('\uea60' * var87)) / 1000L);
                                             String var41 = var57 + ":" + var87 / 10 + var87 % 10 + ":" + var40 / 10 + var40 % 10;
                                             class32.chatboxSegments[var6++] = var41;
                                             continue;
                                          }

                                          if(var47 == 3924) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             class32.field720[var5++] = var56.field24.totalQuantity;
                                             continue;
                                          }

                                          if(var47 == 3925) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             class32.field720[var5++] = var56.field24.price;
                                             continue;
                                          }

                                          if(var47 == 3926) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var56 = (class2)CombatInfoListHolder.field749.field14.get(var38);
                                             class32.field720[var5++] = var56.field24.itemId;
                                             continue;
                                          }
                                       } else if(var47 < 4100) {
                                          if(var47 == 4000) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var39 + var38;
                                             continue;
                                          }

                                          if(var47 == 4001) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var38 - var39;
                                             continue;
                                          }

                                          if(var47 == 4002) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             class32.field720[var5++] = var38 * var39;
                                             continue;
                                          }

                                          if(var47 == 4003) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var38 / var39;
                                             continue;
                                          }

                                          if(var47 == 4004) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = (int)(Math.random() * (double)var38);
                                             continue;
                                          }

                                          if(var47 == 4005) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = (int)(Math.random() * (double)(var38 + 1));
                                             continue;
                                          }

                                          if(var47 == 4006) {
                                             var5 -= 5;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             var34 = class32.field720[2 + var5];
                                             var18 = class32.field720[var5 + 3];
                                             var57 = class32.field720[4 + var5];
                                             class32.field720[var5++] = (var57 - var34) * (var39 - var38) / (var18 - var34) + var38;
                                             continue;
                                          }

                                          if(var47 == 4007) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var38 + var38 * var39 / 100;
                                             continue;
                                          }

                                          if(var47 == 4008) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var38 | 1 << var39;
                                             continue;
                                          }

                                          if(var47 == 4009) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             class32.field720[var5++] = var38 & -1 - (1 << var39);
                                             continue;
                                          }

                                          if(var47 == 4010) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             class32.field720[var5++] = (var38 & 1 << var39) != 0?1:0;
                                             continue;
                                          }

                                          if(var47 == 4011) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var38 % var39;
                                             continue;
                                          }

                                          if(var47 == 4012) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             if(var38 == 0) {
                                                class32.field720[var5++] = 0;
                                             } else {
                                                class32.field720[var5++] = (int)Math.pow((double)var38, (double)var39);
                                             }
                                             continue;
                                          }

                                          if(var47 == 4013) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             if(var38 == 0) {
                                                class32.field720[var5++] = 0;
                                             } else if(var39 == 0) {
                                                class32.field720[var5++] = Integer.MAX_VALUE;
                                             } else {
                                                class32.field720[var5++] = (int)Math.pow((double)var38, 1.0D / (double)var39);
                                             }
                                             continue;
                                          }

                                          if(var47 == 4014) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             class32.field720[var5++] = var38 & var39;
                                             continue;
                                          }

                                          if(var47 == 4015) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             class32.field720[var5++] = var38 | var39;
                                             continue;
                                          }

                                          if(var47 == 4018) {
                                             var5 -= 3;
                                             long var117 = (long)class32.field720[var5];
                                             var98 = (long)class32.field720[1 + var5];
                                             long var66 = (long)class32.field720[2 + var5];
                                             class32.field720[var5++] = (int)(var117 * var66 / var98);
                                             continue;
                                          }
                                       } else if(var47 < 4200) {
                                          if(var47 == 4100) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             --var5;
                                             var39 = class32.field720[var5];
                                             class32.chatboxSegments[var6++] = var76 + var39;
                                             continue;
                                          }

                                          if(var47 == 4101) {
                                             var6 -= 2;
                                             var76 = class32.chatboxSegments[var6];
                                             var49 = class32.chatboxSegments[var6 + 1];
                                             class32.chatboxSegments[var6++] = var76 + var49;
                                             continue;
                                          }

                                          if(var47 == 4102) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             --var5;
                                             var39 = class32.field720[var5];
                                             class32.chatboxSegments[var6++] = var76 + class155.method2947(var39, true);
                                             continue;
                                          }

                                          if(var47 == 4103) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = var76.toLowerCase();
                                             continue;
                                          }

                                          if(var47 == 4104) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             long var116 = ((long)var38 + 11745L) * 86400000L;
                                             class32.field725.setTime(new Date(var116));
                                             var18 = class32.field725.get(5);
                                             var57 = class32.field725.get(2);
                                             var87 = class32.field725.get(1);
                                             class32.chatboxSegments[var6++] = var18 + "-" + class32.field726[var57] + "-" + var87;
                                             continue;
                                          }

                                          if(var47 == 4105) {
                                             var6 -= 2;
                                             var76 = class32.chatboxSegments[var6];
                                             var49 = class32.chatboxSegments[var6 + 1];
                                             if(null != class39.localPlayer.composition && class39.localPlayer.composition.isFemale) {
                                                class32.chatboxSegments[var6++] = var49;
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = var76;
                                             continue;
                                          }

                                          if(var47 == 4106) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.chatboxSegments[var6++] = Integer.toString(var38);
                                             continue;
                                          }

                                          if(var47 == 4107) {
                                             var6 -= 2;
                                             int[] var93 = class32.field720;
                                             var39 = var5++;
                                             var88 = class32.chatboxSegments[var6];
                                             var61 = class32.chatboxSegments[1 + var6];
                                             var40 = Client.field290;
                                             var22 = var88.length();
                                             var23 = var61.length();
                                             var70 = 0;
                                             var25 = 0;
                                             byte var26 = 0;
                                             byte var27 = 0;

                                             label3613:
                                             while(true) {
                                                if(var70 - var26 >= var22 && var25 - var27 >= var23) {
                                                   int var78 = Math.min(var22, var23);

                                                   int var80;
                                                   char var84;
                                                   for(var80 = 0; var80 < var78; ++var80) {
                                                      char var81 = var88.charAt(var80);
                                                      var84 = var61.charAt(var80);
                                                      if(var81 != var84 && Character.toUpperCase(var81) != Character.toUpperCase(var84)) {
                                                         var81 = Character.toLowerCase(var81);
                                                         var84 = Character.toLowerCase(var84);
                                                         if(var84 != var81) {
                                                            var18 = class200.method3676(var81, var40) - class200.method3676(var84, var40);
                                                            break label3613;
                                                         }
                                                      }
                                                   }

                                                   var80 = var22 - var23;
                                                   if(var80 != 0) {
                                                      var18 = var80;
                                                   } else {
                                                      for(int var83 = 0; var83 < var78; ++var83) {
                                                         var84 = var88.charAt(var83);
                                                         char var32 = var61.charAt(var83);
                                                         if(var84 != var32) {
                                                            var18 = class200.method3676(var84, var40) - class200.method3676(var32, var40);
                                                            break label3613;
                                                         }
                                                      }

                                                      var18 = 0;
                                                   }
                                                   break;
                                                }

                                                if(var70 - var26 >= var22) {
                                                   var18 = -1;
                                                   break;
                                                }

                                                if(var25 - var27 >= var23) {
                                                   var18 = 1;
                                                   break;
                                                }

                                                char var28;
                                                if(var26 != 0) {
                                                   var28 = (char)var26;
                                                   boolean var73 = false;
                                                } else {
                                                   var28 = var88.charAt(var70++);
                                                }

                                                char var29;
                                                if(var27 != 0) {
                                                   var29 = (char)var27;
                                                   boolean var75 = false;
                                                } else {
                                                   var29 = var61.charAt(var25++);
                                                }

                                                byte var30;
                                                if(var28 == 198) {
                                                   var30 = 69;
                                                } else if(var28 == 230) {
                                                   var30 = 101;
                                                } else if(var28 == 223) {
                                                   var30 = 115;
                                                } else if(var28 == 338) {
                                                   var30 = 69;
                                                } else if(var28 == 339) {
                                                   var30 = 101;
                                                } else {
                                                   var30 = 0;
                                                }

                                                var26 = var30;
                                                byte var31;
                                                if(var29 == 198) {
                                                   var31 = 69;
                                                } else if(var29 == 230) {
                                                   var31 = 101;
                                                } else if(var29 == 223) {
                                                   var31 = 115;
                                                } else if(var29 == 338) {
                                                   var31 = 69;
                                                } else if(var29 == 339) {
                                                   var31 = 101;
                                                } else {
                                                   var31 = 0;
                                                }

                                                var27 = var31;
                                                var28 = CombatInfo1.method589(var28, var40);
                                                var29 = CombatInfo1.method589(var29, var40);
                                                if(var29 != var28 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                                   var28 = Character.toLowerCase(var28);
                                                   var29 = Character.toLowerCase(var29);
                                                   if(var28 != var29) {
                                                      var18 = class200.method3676(var28, var40) - class200.method3676(var29, var40);
                                                      break;
                                                   }
                                                }
                                             }

                                             if(var18 > 0) {
                                                var112 = 1;
                                             } else if(var18 < 0) {
                                                var112 = -1;
                                             } else {
                                                var112 = 0;
                                             }

                                             var93[var39] = var112;
                                             continue;
                                          }

                                          class208 var91;
                                          byte[] var102;
                                          if(var47 == 4108) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var39 = class32.field720[var5];
                                             var34 = class32.field720[1 + var5];
                                             var102 = CollisionData.field1837.method3211(var34, 0);
                                             var91 = new class208(var102);
                                             class32.field720[var5++] = var91.method3797(var76, var39);
                                             continue;
                                          }

                                          if(var47 == 4109) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var39 = class32.field720[var5];
                                             var34 = class32.field720[var5 + 1];
                                             var102 = CollisionData.field1837.method3211(var34, 0);
                                             var91 = new class208(var102);
                                             class32.field720[var5++] = var91.method3799(var76, var39);
                                             continue;
                                          }

                                          if(var47 == 4110) {
                                             var6 -= 2;
                                             var76 = class32.chatboxSegments[var6];
                                             var49 = class32.chatboxSegments[1 + var6];
                                             --var5;
                                             if(class32.field720[var5] == 1) {
                                                class32.chatboxSegments[var6++] = var76;
                                             } else {
                                                class32.chatboxSegments[var6++] = var49;
                                             }
                                             continue;
                                          }

                                          if(var47 == 4111) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = class209.method3778(var76);
                                             continue;
                                          }

                                          if(var47 == 4112) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             --var5;
                                             var39 = class32.field720[var5];
                                             class32.chatboxSegments[var6++] = var76 + (char)var39;
                                             continue;
                                          }

                                          char var67;
                                          if(var47 == 4113) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var50 = class32.field720;
                                             var34 = var5++;
                                             var67 = (char)var38;
                                             if(var67 >= 32 && var67 <= 126) {
                                                var54 = true;
                                             } else if(var67 >= 160 && var67 <= 255) {
                                                var54 = true;
                                             } else if(var67 != 8364 && var67 != 338 && var67 != 8212 && var67 != 339 && var67 != 376) {
                                                var54 = false;
                                             } else {
                                                var54 = true;
                                             }

                                             var50[var34] = var54?1:0;
                                             continue;
                                          }

                                          if(var47 == 4114) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var50 = class32.field720;
                                             var34 = var5++;
                                             var67 = (char)var38;
                                             var54 = var67 >= 48 && var67 <= 57 || var67 >= 65 && var67 <= 90 || var67 >= 97 && var67 <= 122;
                                             var50[var34] = var54?1:0;
                                             continue;
                                          }

                                          if(var47 == 4115) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = class138.method2457((char)var38)?1:0;
                                             continue;
                                          }

                                          if(var47 == 4116) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var50 = class32.field720;
                                             var34 = var5++;
                                             var67 = (char)var38;
                                             var54 = var67 >= 48 && var67 <= 57;
                                             var50[var34] = var54?1:0;
                                             continue;
                                          }

                                          if(var47 == 4117) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             if(null != var76) {
                                                class32.field720[var5++] = var76.length();
                                             } else {
                                                class32.field720[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var47 == 4118) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var39 = class32.field720[var5];
                                             var34 = class32.field720[var5 + 1];
                                             class32.chatboxSegments[var6++] = var76.substring(var39, var34);
                                             continue;
                                          }

                                          if(var47 == 4119) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             StringBuilder var63 = new StringBuilder(var76.length());
                                             var106 = false;

                                             for(var18 = 0; var18 < var76.length(); ++var18) {
                                                var67 = var76.charAt(var18);
                                                if(var67 == 60) {
                                                   var106 = true;
                                                } else if(var67 == 62) {
                                                   var106 = false;
                                                } else if(!var106) {
                                                   var63.append(var67);
                                                }
                                             }

                                             class32.chatboxSegments[var6++] = var63.toString();
                                             continue;
                                          }

                                          if(var47 == 4120) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             --var5;
                                             var39 = class32.field720[var5];
                                             class32.field720[var5++] = var76.indexOf(var39);
                                             continue;
                                          }

                                          if(var47 == 4121) {
                                             var6 -= 2;
                                             var76 = class32.chatboxSegments[var6];
                                             var49 = class32.chatboxSegments[1 + var6];
                                             --var5;
                                             var34 = class32.field720[var5];
                                             class32.field720[var5++] = var76.indexOf(var49, var34);
                                             continue;
                                          }
                                       } else if(var47 < 4300) {
                                          if(var47 == 4200) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.chatboxSegments[var6++] = class7.getItemDefinition(var38).name;
                                             continue;
                                          }

                                          ItemComposition var60;
                                          if(var47 == 4201) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             var60 = class7.getItemDefinition(var38);
                                             if(var39 >= 1 && var39 <= 5 && var60.groundActions[var39 - 1] != null) {
                                                class32.chatboxSegments[var6++] = var60.groundActions[var39 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var47 == 4202) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             var60 = class7.getItemDefinition(var38);
                                             if(var39 >= 1 && var39 <= 5 && null != var60.inventoryActions[var39 - 1]) {
                                                class32.chatboxSegments[var6++] = var60.inventoryActions[var39 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var47 == 4203) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = class7.getItemDefinition(var38).price;
                                             continue;
                                          }

                                          if(var47 == 4204) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = class7.getItemDefinition(var38).isStackable == 1?1:0;
                                             continue;
                                          }

                                          ItemComposition var68;
                                          if(var47 == 4205) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var68 = class7.getItemDefinition(var38);
                                             if(var68.field2985 == -1 && var68.note >= 0) {
                                                class32.field720[var5++] = var68.note;
                                                continue;
                                             }

                                             class32.field720[var5++] = var38;
                                             continue;
                                          }

                                          if(var47 == 4206) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var68 = class7.getItemDefinition(var38);
                                             if(var68.field2985 >= 0 && var68.note >= 0) {
                                                class32.field720[var5++] = var68.note;
                                                continue;
                                             }

                                             class32.field720[var5++] = var38;
                                             continue;
                                          }

                                          if(var47 == 4207) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = class7.getItemDefinition(var38).isMembers?1:0;
                                             continue;
                                          }

                                          if(var47 == 4208) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var68 = class7.getItemDefinition(var38);
                                             if(var68.field2996 == -1 && var68.field2995 >= 0) {
                                                class32.field720[var5++] = var68.field2995;
                                                continue;
                                             }

                                             class32.field720[var5++] = var38;
                                             continue;
                                          }

                                          if(var47 == 4209) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var68 = class7.getItemDefinition(var38);
                                             if(var68.field2996 >= 0 && var68.field2995 >= 0) {
                                                class32.field720[var5++] = var68.field2995;
                                                continue;
                                             }

                                             class32.field720[var5++] = var38;
                                             continue;
                                          }

                                          if(var47 == 4210) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             --var5;
                                             var39 = class32.field720[var5];
                                             var54 = var39 == 1;
                                             var17 = var76.toLowerCase();
                                             short[] var94 = new short[16];
                                             var87 = 0;
                                             var40 = 0;

                                             while(true) {
                                                if(var40 >= ItemComposition.field2948) {
                                                   class94.field1567 = var94;
                                                   WallObject.field1548 = 0;
                                                   class31.field698 = var87;
                                                   String[] var21 = new String[class31.field698];

                                                   for(var22 = 0; var22 < class31.field698; ++var22) {
                                                      var21[var22] = class7.getItemDefinition(var94[var22]).name;
                                                   }

                                                   class41.method743(var21, class94.field1567);
                                                   break;
                                                }

                                                ItemComposition var109 = class7.getItemDefinition(var40);
                                                if((!var54 || var109.field2992) && var109.field2985 == -1 && var109.name.toLowerCase().indexOf(var17) != -1) {
                                                   if(var87 >= 250) {
                                                      class31.field698 = -1;
                                                      class94.field1567 = null;
                                                      break;
                                                   }

                                                   if(var87 >= var94.length) {
                                                      short[] var42 = new short[var94.length * 2];

                                                      for(var70 = 0; var70 < var87; ++var70) {
                                                         var42[var70] = var94[var70];
                                                      }

                                                      var94 = var42;
                                                   }

                                                   var94[var87++] = (short)var40;
                                                }

                                                ++var40;
                                             }

                                             class32.field720[var5++] = class31.field698;
                                             continue;
                                          }

                                          if(var47 == 4211) {
                                             if(class94.field1567 != null && WallObject.field1548 < class31.field698) {
                                                class32.field720[var5++] = class94.field1567[++WallObject.field1548 - 1] & '\uffff';
                                                continue;
                                             }

                                             class32.field720[var5++] = -1;
                                             continue;
                                          }

                                          if(var47 == 4212) {
                                             WallObject.field1548 = 0;
                                             continue;
                                          }
                                       } else if(var47 < 5100) {
                                          if(var47 == 5000) {
                                             class32.field720[var5++] = Client.field504;
                                             continue;
                                          }

                                          if(var47 == 5001) {
                                             var5 -= 3;
                                             Client.field504 = class32.field720[var5];
                                             var39 = class32.field720[1 + var5];
                                             class216[] var65 = class39.method711();
                                             var18 = 0;

                                             class216 var115;
                                             while(true) {
                                                if(var18 >= var65.length) {
                                                   var115 = null;
                                                   break;
                                                }

                                                class216 var101 = var65[var18];
                                                if(var101.field3166 == var39) {
                                                   var115 = var101;
                                                   break;
                                                }

                                                ++var18;
                                             }

                                             Item.field889 = var115;
                                             if(null == Item.field889) {
                                                Item.field889 = class216.field3163;
                                             }

                                             Client.field505 = class32.field720[2 + var5];
                                             Client.field294.method2976(150);
                                             Client.field294.method2932(Client.field504);
                                             Client.field294.method2932(Item.field889.field3166);
                                             Client.field294.method2932(Client.field505);
                                             continue;
                                          }

                                          if(var47 == 5002) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var39 = class32.field720[var5];
                                             var34 = class32.field720[1 + var5];
                                             Client.field294.method2976(21);
                                             Client.field294.method2932(class57.method1067(var76) + 2);
                                             Client.field294.method2757(var76);
                                             Client.field294.method2932(var39 - 1);
                                             Client.field294.method2932(var34);
                                             continue;
                                          }

                                          if(var47 == 5003) {
                                             var5 -= 2;
                                             var38 = class32.field720[var5];
                                             var39 = class32.field720[var5 + 1];
                                             ChatLineBuffer var105 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var38));
                                             MessageNode var64 = var105.method869(var39);
                                             if(null != var64) {
                                                class32.field720[var5++] = var64.id;
                                                class32.field720[var5++] = var64.tick;
                                                class32.chatboxSegments[var6++] = null != var64.name?var64.name:"";
                                                class32.chatboxSegments[var6++] = var64.sender != null?var64.sender:"";
                                                class32.chatboxSegments[var6++] = null != var64.value?var64.value:"";
                                             } else {
                                                class32.field720[var5++] = -1;
                                                class32.field720[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var47 == 5004) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             MessageNode var72 = (MessageNode)class47.field944.method2284((long)var38);
                                             if(null != var72) {
                                                class32.field720[var5++] = var72.type;
                                                class32.field720[var5++] = var72.tick;
                                                class32.chatboxSegments[var6++] = null != var72.name?var72.name:"";
                                                class32.chatboxSegments[var6++] = var72.sender != null?var72.sender:"";
                                                class32.chatboxSegments[var6++] = null != var72.value?var72.value:"";
                                             } else {
                                                class32.field720[var5++] = -1;
                                                class32.field720[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var47 == 5005) {
                                             if(null == Item.field889) {
                                                class32.field720[var5++] = -1;
                                             } else {
                                                class32.field720[var5++] = Item.field889.field3166;
                                             }
                                             continue;
                                          }

                                          if(var47 == 5008) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             --var5;
                                             var39 = class32.field720[var5];
                                             var17 = var76.toLowerCase();
                                             byte var79 = 0;
                                             if(var17.startsWith("yellow:")) {
                                                var79 = 0;
                                                var76 = var76.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var79 = 1;
                                                var76 = var76.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var79 = 2;
                                                var76 = var76.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var79 = 3;
                                                var76 = var76.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var79 = 4;
                                                var76 = var76.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var79 = 5;
                                                var76 = var76.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var79 = 6;
                                                var76 = var76.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var79 = 7;
                                                var76 = var76.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var79 = 8;
                                                var76 = var76.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var79 = 9;
                                                var76 = var76.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var79 = 10;
                                                var76 = var76.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var79 = 11;
                                                var76 = var76.substring("glow3:".length());
                                             } else if(Client.field290 != 0) {
                                                if(var17.startsWith("yellow:")) {
                                                   var79 = 0;
                                                   var76 = var76.substring("yellow:".length());
                                                } else if(var17.startsWith("red:")) {
                                                   var79 = 1;
                                                   var76 = var76.substring("red:".length());
                                                } else if(var17.startsWith("green:")) {
                                                   var79 = 2;
                                                   var76 = var76.substring("green:".length());
                                                } else if(var17.startsWith("cyan:")) {
                                                   var79 = 3;
                                                   var76 = var76.substring("cyan:".length());
                                                } else if(var17.startsWith("purple:")) {
                                                   var79 = 4;
                                                   var76 = var76.substring("purple:".length());
                                                } else if(var17.startsWith("white:")) {
                                                   var79 = 5;
                                                   var76 = var76.substring("white:".length());
                                                } else if(var17.startsWith("flash1:")) {
                                                   var79 = 6;
                                                   var76 = var76.substring("flash1:".length());
                                                } else if(var17.startsWith("flash2:")) {
                                                   var79 = 7;
                                                   var76 = var76.substring("flash2:".length());
                                                } else if(var17.startsWith("flash3:")) {
                                                   var79 = 8;
                                                   var76 = var76.substring("flash3:".length());
                                                } else if(var17.startsWith("glow1:")) {
                                                   var79 = 9;
                                                   var76 = var76.substring("glow1:".length());
                                                } else if(var17.startsWith("glow2:")) {
                                                   var79 = 10;
                                                   var76 = var76.substring("glow2:".length());
                                                } else if(var17.startsWith("glow3:")) {
                                                   var79 = 11;
                                                   var76 = var76.substring("glow3:".length());
                                                }
                                             }

                                             var17 = var76.toLowerCase();
                                             byte var71 = 0;
                                             if(var17.startsWith("wave:")) {
                                                var71 = 1;
                                                var76 = var76.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var71 = 2;
                                                var76 = var76.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var71 = 3;
                                                var76 = var76.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var71 = 4;
                                                var76 = var76.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var71 = 5;
                                                var76 = var76.substring("slide:".length());
                                             } else if(Client.field290 != 0) {
                                                if(var17.startsWith("wave:")) {
                                                   var71 = 1;
                                                   var76 = var76.substring("wave:".length());
                                                } else if(var17.startsWith("wave2:")) {
                                                   var71 = 2;
                                                   var76 = var76.substring("wave2:".length());
                                                } else if(var17.startsWith("shake:")) {
                                                   var71 = 3;
                                                   var76 = var76.substring("shake:".length());
                                                } else if(var17.startsWith("scroll:")) {
                                                   var71 = 4;
                                                   var76 = var76.substring("scroll:".length());
                                                } else if(var17.startsWith("slide:")) {
                                                   var71 = 5;
                                                   var76 = var76.substring("slide:".length());
                                                }
                                             }

                                             Client.field294.method2976(110);
                                             Client.field294.method2932(0);
                                             var87 = Client.field294.offset;
                                             Client.field294.method2932(var39);
                                             Client.field294.method2932(var79);
                                             Client.field294.method2932(var71);
                                             class179.method3206(Client.field294, var76);
                                             Client.field294.method2756(Client.field294.offset - var87);
                                             continue;
                                          }

                                          if(var47 == 5009) {
                                             var6 -= 2;
                                             var76 = class32.chatboxSegments[var6];
                                             var49 = class32.chatboxSegments[1 + var6];
                                             Client.field294.method2976(142);
                                             Client.field294.method2746(0);
                                             var34 = Client.field294.offset;
                                             Client.field294.method2757(var76);
                                             class179.method3206(Client.field294, var49);
                                             Client.field294.method2755(Client.field294.offset - var34);
                                             continue;
                                          }

                                          if(var47 == 5015) {
                                             if(null != class39.localPlayer && class39.localPlayer.name != null) {
                                                var76 = class39.localPlayer.name;
                                             } else {
                                                var76 = "";
                                             }

                                             class32.chatboxSegments[var6++] = var76;
                                             continue;
                                          }

                                          if(var47 == 5016) {
                                             class32.field720[var5++] = Client.field505;
                                             continue;
                                          }

                                          if(var47 == 5017) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var50 = class32.field720;
                                             var34 = var5++;
                                             ChatLineBuffer var100 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var38));
                                             if(var100 == null) {
                                                var18 = 0;
                                             } else {
                                                var18 = var100.method877();
                                             }

                                             var50[var34] = var18;
                                             continue;
                                          }

                                          if(var47 == 5018) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             var50 = class32.field720;
                                             var34 = var5++;
                                             MessageNode var97 = (MessageNode)class47.field944.method2284((long)var38);
                                             if(var97 == null) {
                                                var18 = -1;
                                             } else if(var97.previous == class47.field940.field1896) {
                                                var18 = -1;
                                             } else {
                                                var18 = ((MessageNode)var97.previous).id;
                                             }

                                             var50[var34] = var18;
                                             continue;
                                          }

                                          if(var47 == 5019) {
                                             --var5;
                                             var38 = class32.field720[var5];
                                             class32.field720[var5++] = class173.method3182(var38);
                                             continue;
                                          }

                                          if(var47 == 5020) {
                                             --var6;
                                             var76 = class32.chatboxSegments[var6];
                                             if(var76.equalsIgnoreCase("toggleroof")) {
                                                class149.field2044.field689 = !class149.field2044.field689;
                                                class41.method759();
                                                if(class149.field2044.field689) {
                                                   ObjectComposition.method3581(99, "", "Roofs are now all hidden");
                                                } else {
                                                   ObjectComposition.method3581(99, "", "Roofs will only be removed selectively");
                                                }
                                             }

                                             if(var76.equalsIgnoreCase("displayfps")) {
                                                Client.field469 = !Client.field469;
                                             }

                                             if(Client.field358 >= 2) {
                                                if(var76.equalsIgnoreCase("fpson")) {
                                                   Client.field469 = true;
                                                }

                                                if(var76.equalsIgnoreCase("fpsoff")) {
                                                   Client.field469 = false;
                                                }

                                                if(var76.equalsIgnoreCase("gc")) {
                                                   System.gc();
                                                }

                                                if(var76.equalsIgnoreCase("clientdrop")) {
                                                   class177.method3192();
                                                }

                                                if(var76.equalsIgnoreCase("errortest") && Client.field287 == 2) {
                                                   throw new RuntimeException();
                                                }
                                             }

                                             Client.field294.method2976(26);
                                             Client.field294.method2932(var76.length() + 1);
                                             Client.field294.method2757(var76);
                                             continue;
                                          }

                                          if(var47 == 5021) {
                                             --var6;
                                             Client.field532 = class32.chatboxSegments[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var47 == 5022) {
                                             class32.chatboxSegments[var6++] = Client.field532;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var47 >= 2000) {
                                 var47 -= 1000;
                                 --var5;
                                 var15 = class191.method3433(class32.field720[var5]);
                              } else {
                                 var15 = var58?class88.field1538:class32.field718;
                              }

                              if(var47 == 1927) {
                                 if(class32.field728 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var15.field2317) {
                                    return;
                                 }

                                 class18 var16 = new class18();
                                 var16.field187 = var15;
                                 var16.field188 = var15.field2317;
                                 var16.field195 = class32.field728 + 1;
                                 Client.field475.method2376(var0);
                                 continue;
                              }
                           }
                        }
                     } else {
                        if(var47 >= 2000) {
                           var47 -= 1000;
                           --var5;
                           var15 = class191.method3433(class32.field720[var5]);
                        } else {
                           var15 = var58?class88.field1538:class32.field718;
                        }

                        class94.method1890(var15);
                        if(var47 == 1200 || var47 == 1205 || var47 == 1212) {
                           var5 -= 2;
                           var39 = class32.field720[var5];
                           var34 = class32.field720[1 + var5];
                           var15.item = var39;
                           var15.stackSize = var34;
                           ItemComposition var89 = class7.getItemDefinition(var39);
                           var15.rotationX = var89.field2960;
                           var15.rotationZ = var89.field2953;
                           var15.rotationY = var89.field2962;
                           var15.field2283 = var89.field2977;
                           var15.field2258 = var89.field2964;
                           var15.field2262 = var89.field2959;
                           if(var47 == 1205) {
                              var15.field2266 = 0;
                           } else if(var47 == 1212 | var89.isStackable == 1) {
                              var15.field2266 = 1;
                           } else {
                              var15.field2266 = 2;
                           }

                           if(var15.field2292 > 0) {
                              var15.field2262 = var15.field2262 * 32 / var15.field2292;
                           } else if(var15.field2219 > 0) {
                              var15.field2262 = var15.field2262 * 32 / var15.field2219;
                           }
                           continue;
                        }

                        if(var47 == 1201) {
                           var15.modelType = 2;
                           --var5;
                           var15.modelId = class32.field720[var5];
                           continue;
                        }

                        if(var47 == 1202) {
                           var15.modelType = 3;
                           var15.modelId = class39.localPlayer.composition.method3087();
                           continue;
                        }
                     }
                  } else {
                     var39 = -1;
                     if(var47 >= 2000) {
                        var47 -= 1000;
                        --var5;
                        var39 = class32.field720[var5];
                        var15 = class191.method3433(var39);
                     } else {
                        var15 = var58?class88.field1538:class32.field718;
                     }

                     if(var47 == 1100) {
                        var5 -= 2;
                        var15.scrollX = class32.field720[var5];
                        if(var15.scrollX > var15.scrollWidth - var15.width) {
                           var15.scrollX = var15.scrollWidth - var15.width;
                        }

                        if(var15.scrollX < 0) {
                           var15.scrollX = 0;
                        }

                        var15.scrollY = class32.field720[1 + var5];
                        if(var15.scrollY > var15.scrollHeight - var15.height) {
                           var15.scrollY = var15.scrollHeight - var15.height;
                        }

                        if(var15.scrollY < 0) {
                           var15.scrollY = 0;
                        }

                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1101) {
                        --var5;
                        var15.textColor = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1102) {
                        --var5;
                        var15.field2237 = class32.field720[var5] == 1;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1103) {
                        --var5;
                        var15.opacity = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1104) {
                        --var5;
                        var15.field2239 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1105) {
                        --var5;
                        var15.textureId = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1106) {
                        --var5;
                        var15.field2245 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1107) {
                        --var5;
                        var15.field2246 = class32.field720[var5] == 1;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1108) {
                        var15.modelType = 1;
                        --var5;
                        var15.modelId = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1109) {
                        var5 -= 6;
                        var15.field2283 = class32.field720[var5];
                        var15.field2258 = class32.field720[1 + var5];
                        var15.rotationX = class32.field720[var5 + 2];
                        var15.rotationZ = class32.field720[3 + var5];
                        var15.rotationY = class32.field720[var5 + 4];
                        var15.field2262 = class32.field720[var5 + 5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1110) {
                        --var5;
                        var34 = class32.field720[var5];
                        if(var15.field2255 != var34) {
                           var15.field2255 = var34;
                           var15.field2330 = 0;
                           var15.field2251 = 0;
                           class94.method1890(var15);
                        }
                        continue;
                     }

                     if(var47 == 1111) {
                        --var5;
                        var15.field2265 = class32.field720[var5] == 1;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1112) {
                        --var6;
                        var17 = class32.chatboxSegments[var6];
                        if(!var17.equals(var15.text)) {
                           var15.text = var17;
                           class94.method1890(var15);
                        }
                        continue;
                     }

                     if(var47 == 1113) {
                        --var5;
                        var15.field2217 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1114) {
                        var5 -= 3;
                        var15.field2271 = class32.field720[var5];
                        var15.field2202 = class32.field720[var5 + 1];
                        var15.field2276 = class32.field720[var5 + 2];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1115) {
                        --var5;
                        var15.field2273 = class32.field720[var5] == 1;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1116) {
                        --var5;
                        var15.borderThickness = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1117) {
                        --var5;
                        var15.sprite2 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1118) {
                        --var5;
                        var15.flippedVertically = class32.field720[var5] == 1;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1119) {
                        --var5;
                        var15.flippedHorizontally = class32.field720[var5] == 1;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1120) {
                        var5 -= 2;
                        var15.scrollWidth = class32.field720[var5];
                        var15.scrollHeight = class32.field720[1 + var5];
                        class94.method1890(var15);
                        if(var39 != -1 && var15.type == 0) {
                           class2.method18(Widget.widgets[var39 >> 16], var15, false);
                        }
                        continue;
                     }

                     if(var47 == 1121) {
                        var34 = var15.id;
                        var18 = var15.index;
                        Client.field294.method2976(52);
                        Client.field294.method2748(var34);
                        Client.field294.method2763(var18);
                        Client.field450 = var15;
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1122) {
                        --var5;
                        var15.field2331 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1123) {
                        --var5;
                        var15.field2234 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1124) {
                        --var5;
                        var15.field2270 = class32.field720[var5];
                        class94.method1890(var15);
                        continue;
                     }

                     if(var47 == 1125) {
                        --var5;
                        var34 = class32.field720[var5];
                        class221 var37 = (class221)XItemContainer.method161(class63.method1139(), var34);
                        if(null != var37) {
                           var15.field2204 = var37;
                           class94.method1890(var15);
                        }
                        continue;
                     }
                  }
               }

               if(var47 < 5400) {
                  if(var47 == 5306) {
                     class32.field720[var5++] = XGrandExchangeOffer.method57();
                     continue;
                  }

                  if(var47 == 5307) {
                     --var5;
                     var38 = class32.field720[var5];
                     if(var38 == 1 || var38 == 2) {
                        Friend.method166(var38);
                     }
                     continue;
                  }

                  if(var47 == 5308) {
                     class32.field720[var5++] = class149.field2044.field691;
                     continue;
                  }

                  if(var47 == 5309) {
                     --var5;
                     var38 = class32.field720[var5];
                     if(var38 == 1 || var38 == 2) {
                        class149.field2044.field691 = var38;
                        class41.method759();
                     }
                     continue;
                  }
               }

               if(var47 < 5600) {
                  if(var47 == 5504) {
                     var5 -= 2;
                     var38 = class32.field720[var5];
                     var39 = class32.field720[1 + var5];
                     if(!Client.field534) {
                        Client.field371 = var38;
                        Client.mapAngle = var39;
                     }
                     continue;
                  }

                  if(var47 == 5505) {
                     class32.field720[var5++] = Client.field371;
                     continue;
                  }

                  if(var47 == 5506) {
                     class32.field720[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var47 == 5530) {
                     --var5;
                     var38 = class32.field720[var5];
                     if(var38 < 0) {
                        var38 = 0;
                     }

                     Client.field377 = var38;
                     continue;
                  }

                  if(var47 == 5531) {
                     class32.field720[var5++] = Client.field377;
                     continue;
                  }
               }

               if(var47 < 5700 && var47 == 5630) {
                  Client.field453 = 250;
               } else {
                  if(var47 < 6300) {
                     if(var47 == 6200) {
                        var5 -= 2;
                        Client.field540 = (short)class32.field720[var5];
                        if(Client.field540 <= 0) {
                           Client.field540 = 256;
                        }

                        Client.field541 = (short)class32.field720[1 + var5];
                        if(Client.field541 <= 0) {
                           Client.field541 = 205;
                        }
                        continue;
                     }

                     if(var47 == 6201) {
                        var5 -= 2;
                        Client.field382 = (short)class32.field720[var5];
                        if(Client.field382 <= 0) {
                           Client.field382 = 256;
                        }

                        Client.field543 = (short)class32.field720[1 + var5];
                        if(Client.field543 <= 0) {
                           Client.field543 = 320;
                        }
                        continue;
                     }

                     if(var47 == 6202) {
                        var5 -= 4;
                        Client.field392 = (short)class32.field720[var5];
                        if(Client.field392 <= 0) {
                           Client.field392 = 1;
                        }

                        Client.field545 = (short)class32.field720[1 + var5];
                        if(Client.field545 <= 0) {
                           Client.field545 = 32767;
                        } else if(Client.field545 < Client.field392) {
                           Client.field545 = Client.field392;
                        }

                        Client.field546 = (short)class32.field720[2 + var5];
                        if(Client.field546 <= 0) {
                           Client.field546 = 1;
                        }

                        Client.field547 = (short)class32.field720[var5 + 3];
                        if(Client.field547 <= 0) {
                           Client.field547 = 32767;
                        } else if(Client.field547 < Client.field546) {
                           Client.field547 = Client.field546;
                        }
                        continue;
                     }

                     if(var47 == 6203) {
                        if(null != Client.field421) {
                           class39.method709(0, 0, Client.field421.width, Client.field421.height, false);
                           class32.field720[var5++] = Client.camera2;
                           class32.field720[var5++] = Client.camera3;
                        } else {
                           class32.field720[var5++] = -1;
                           class32.field720[var5++] = -1;
                        }
                        continue;
                     }

                     if(var47 == 6204) {
                        class32.field720[var5++] = Client.field382;
                        class32.field720[var5++] = Client.field543;
                        continue;
                     }

                     if(var47 == 6205) {
                        class32.field720[var5++] = Client.field540;
                        class32.field720[var5++] = Client.field541;
                        continue;
                     }
                  }

                  if(var47 < 6600) {
                     if(var47 == 6500) {
                        class32.field720[var5++] = TextureProvider.loadWorlds()?1:0;
                        continue;
                     }

                     World var77;
                     if(var47 == 6501) {
                        World.field673 = 0;
                        if(World.field673 < World.field672) {
                           var77 = class107.worldList[++World.field673 - 1];
                        } else {
                           var77 = null;
                        }

                        if(var77 != null) {
                           class32.field720[var5++] = var77.id;
                           class32.field720[var5++] = var77.mask;
                           class32.chatboxSegments[var6++] = var77.activity;
                           class32.field720[var5++] = var77.location;
                           class32.field720[var5++] = var77.playerCount;
                           class32.chatboxSegments[var6++] = var77.address;
                        } else {
                           class32.field720[var5++] = -1;
                           class32.field720[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field720[var5++] = 0;
                           class32.field720[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var47 == 6502) {
                        World var118;
                        if(World.field673 < World.field672) {
                           var118 = class107.worldList[++World.field673 - 1];
                        } else {
                           var118 = null;
                        }

                        if(var118 != null) {
                           class32.field720[var5++] = var118.id;
                           class32.field720[var5++] = var118.mask;
                           class32.chatboxSegments[var6++] = var118.activity;
                           class32.field720[var5++] = var118.location;
                           class32.field720[var5++] = var118.playerCount;
                           class32.chatboxSegments[var6++] = var118.address;
                        } else {
                           class32.field720[var5++] = -1;
                           class32.field720[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field720[var5++] = 0;
                           class32.field720[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var47 == 6506) {
                        --var5;
                        var38 = class32.field720[var5];
                        var77 = null;

                        for(var34 = 0; var34 < World.field672; ++var34) {
                           if(class107.worldList[var34].id == var38) {
                              var77 = class107.worldList[var34];
                              break;
                           }
                        }

                        if(null != var77) {
                           class32.field720[var5++] = var77.id;
                           class32.field720[var5++] = var77.mask;
                           class32.chatboxSegments[var6++] = var77.activity;
                           class32.field720[var5++] = var77.location;
                           class32.field720[var5++] = var77.playerCount;
                           class32.chatboxSegments[var6++] = var77.address;
                        } else {
                           class32.field720[var5++] = -1;
                           class32.field720[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field720[var5++] = 0;
                           class32.field720[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var47 == 6507) {
                        var5 -= 4;
                        var38 = class32.field720[var5];
                        var110 = class32.field720[var5 + 1] == 1;
                        var34 = class32.field720[2 + var5];
                        var54 = class32.field720[3 + var5] == 1;
                        GameEngine.method2157(var38, var110, var34, var54);
                        continue;
                     }

                     if(var47 == 6511) {
                        --var5;
                        var38 = class32.field720[var5];
                        if(var38 >= 0 && var38 < World.field672) {
                           var77 = class107.worldList[var38];
                           class32.field720[var5++] = var77.id;
                           class32.field720[var5++] = var77.mask;
                           class32.chatboxSegments[var6++] = var77.activity;
                           class32.field720[var5++] = var77.location;
                           class32.field720[var5++] = var77.playerCount;
                           class32.chatboxSegments[var6++] = var77.address;
                           continue;
                        }

                        class32.field720[var5++] = -1;
                        class32.field720[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field720[var5++] = 0;
                        class32.field720[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var46) {
            StringBuilder var44 = new StringBuilder(30);
            var44.append("").append(var4.hash).append(" ");

            for(var13 = class32.field722 - 1; var13 >= 0; --var13) {
               var44.append("").append(class32.field732[var13].field118.hash).append(" ");
            }

            var44.append("").append(var10);
            FaceNormal.method1864(var44.toString(), var46);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-714909241"
   )
   public static void method84(Component var0) {
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1703 = -1;
   }

   public int compare(Object var1, Object var2) {
      return this.method78((class2)var1, (class2)var2);
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method85(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field287 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field287 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field287 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field287 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field287 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != CombatInfoListHolder.field756) {
         var3 = "/p=" + CombatInfoListHolder.field756;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field290 + "/a=" + class167.field2188 + var3 + "/";
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "-1073375479"
   )
   static final void method86(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(null != var9 && (!var9.field2198 || var9.type == 0 || var9.field2280 || class143.method2647(var9) != 0 || var9 == Client.field460 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.field2198 || !class221.method3975(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.width;
               var19 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field511 == var9) {
               Client.field467 = true;
               Client.field468 = var10;
               Client.field325 = var11;
            }

            if(!var9.field2198 || var12 < var14 && var13 < var15) {
               var16 = class115.field1794;
               var17 = class115.field1797;
               if(class115.field1802 != 0) {
                  var16 = class115.field1803;
                  var17 = class115.field1804;
               }

               int var21;
               int var22;
               int var23;
               int var25;
               int var36;
               int var43;
               if(var9.contentType == 1337) {
                  if(!Client.field292 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     if(Client.field526 == 0 && !Client.field523) {
                        class184.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var18 = -1;
                     var19 = -1;

                     for(var43 = 0; var43 < Model.field1395; ++var43) {
                        var21 = Model.field1414[var43];
                        var22 = var21 & 127;
                        var23 = var21 >> 7 & 127;
                        var36 = var21 >> 29 & 3;
                        var25 = var21 >> 14 & 32767;
                        if(var21 != var19) {
                           var19 = var21;
                           if(var36 == 2 && Client.region.method1721(class171.plane, var22, var23, var21) >= 0) {
                              ObjectComposition var26 = ItemLayer.getObjectDefinition(var25);
                              if(null != var26.impostorIds) {
                                 var26 = var26.getImpostor();
                              }

                              if(var26 == null) {
                                 continue;
                              }

                              if(Client.field526 == 1) {
                                 class184.addMenuEntry("Use", Client.field375 + " " + "->" + " " + class155.method2949('\uffff') + var26.name, 1, var21, var22, var23);
                              } else if(Client.field523) {
                                 if((class187.field2780 & 4) == 4) {
                                    class184.addMenuEntry(Client.field444, Client.field327 + " " + "->" + " " + class155.method2949('\uffff') + var26.name, 2, var21, var22, var23);
                                 }
                              } else {
                                 String[] var27 = var26.actions;
                                 if(Client.field570) {
                                    var27 = class139.method2591(var27);
                                 }

                                 if(null != var27) {
                                    for(int var28 = 4; var28 >= 0; --var28) {
                                       if(null != var27[var28]) {
                                          short var29 = 0;
                                          if(var28 == 0) {
                                             var29 = 3;
                                          }

                                          if(var28 == 1) {
                                             var29 = 4;
                                          }

                                          if(var28 == 2) {
                                             var29 = 5;
                                          }

                                          if(var28 == 3) {
                                             var29 = 6;
                                          }

                                          if(var28 == 4) {
                                             var29 = 1001;
                                          }

                                          class184.addMenuEntry(var27[var28], class155.method2949('\uffff') + var26.name, var29, var21, var22, var23);
                                       }
                                    }
                                 }

                                 class184.addMenuEntry("Examine", class155.method2949('\uffff') + var26.name, 1002, var26.field2923 << 14, var22, var23);
                              }
                           }

                           Player var30;
                           NPC var33;
                           int var34;
                           int var48;
                           int[] var49;
                           if(var36 == 1) {
                              NPC var44 = Client.cachedNPCs[var25];
                              if(null == var44) {
                                 continue;
                              }

                              if(var44.composition.field3012 == 1 && (var44.x & 127) == 64 && (var44.y & 127) == 64) {
                                 for(var34 = 0; var34 < Client.field322; ++var34) {
                                    var33 = Client.cachedNPCs[Client.field323[var34]];
                                    if(null != var33 && var44 != var33 && var33.composition.field3012 == 1 && var44.x == var33.x && var44.y == var33.y) {
                                       Widget.method3153(var33.composition, Client.field323[var34], var22, var23);
                                    }
                                 }

                                 var34 = class45.field908;
                                 var49 = class45.field903;

                                 for(var48 = 0; var48 < var34; ++var48) {
                                    var30 = Client.cachedPlayers[var49[var48]];
                                    if(null != var30 && var30.x == var44.x && var44.y == var30.y) {
                                       class63.method1138(var30, var49[var48], var22, var23);
                                    }
                                 }
                              }

                              Widget.method3153(var44.composition, var25, var22, var23);
                           }

                           if(var36 == 0) {
                              Player var45 = Client.cachedPlayers[var25];
                              if(null == var45) {
                                 continue;
                              }

                              if((var45.x & 127) == 64 && (var45.y & 127) == 64) {
                                 for(var34 = 0; var34 < Client.field322; ++var34) {
                                    var33 = Client.cachedNPCs[Client.field323[var34]];
                                    if(var33 != null && var33.composition.field3012 == 1 && var45.x == var33.x && var45.y == var33.y) {
                                       Widget.method3153(var33.composition, Client.field323[var34], var22, var23);
                                    }
                                 }

                                 var34 = class45.field908;
                                 var49 = class45.field903;

                                 for(var48 = 0; var48 < var34; ++var48) {
                                    var30 = Client.cachedPlayers[var49[var48]];
                                    if(var30 != null && var30 != var45 && var45.x == var30.x && var45.y == var30.y) {
                                       class63.method1138(var30, var49[var48], var22, var23);
                                    }
                                 }
                              }

                              if(Client.field418 != var25) {
                                 class63.method1138(var45, var25, var22, var23);
                              } else {
                                 var18 = var21;
                              }
                           }

                           if(var36 == 3) {
                              Deque var46 = Client.groundItemDeque[class171.plane][var22][var23];
                              if(var46 != null) {
                                 for(Item var47 = (Item)var46.method2360(); var47 != null; var47 = (Item)var46.method2362()) {
                                    ItemComposition var50 = class7.getItemDefinition(var47.id);
                                    if(Client.field526 == 1) {
                                       class184.addMenuEntry("Use", Client.field375 + " " + "->" + " " + class155.method2949(16748608) + var50.name, 16, var47.id, var22, var23);
                                    } else if(Client.field523) {
                                       if((class187.field2780 & 1) == 1) {
                                          class184.addMenuEntry(Client.field444, Client.field327 + " " + "->" + " " + class155.method2949(16748608) + var50.name, 17, var47.id, var22, var23);
                                       }
                                    } else {
                                       String[] var38 = var50.groundActions;
                                       if(Client.field570) {
                                          var38 = class139.method2591(var38);
                                       }

                                       for(int var39 = 4; var39 >= 0; --var39) {
                                          if(var38 != null && var38[var39] != null) {
                                             byte var31 = 0;
                                             if(var39 == 0) {
                                                var31 = 18;
                                             }

                                             if(var39 == 1) {
                                                var31 = 19;
                                             }

                                             if(var39 == 2) {
                                                var31 = 20;
                                             }

                                             if(var39 == 3) {
                                                var31 = 21;
                                             }

                                             if(var39 == 4) {
                                                var31 = 22;
                                             }

                                             class184.addMenuEntry(var38[var39], class155.method2949(16748608) + var50.name, var31, var47.id, var22, var23);
                                          } else if(var39 == 2) {
                                             class184.addMenuEntry("Take", class155.method2949(16748608) + var50.name, 20, var47.id, var22, var23);
                                          }
                                       }

                                       class184.addMenuEntry("Examine", class155.method2949(16748608) + var50.name, 1004, var47.id, var22, var23);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var18 != -1) {
                        var43 = var18 & 127;
                        var21 = var18 >> 7 & 127;
                        Player var52 = Client.cachedPlayers[Client.field418];
                        class63.method1138(var52, Client.field418, var43, var21);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  Item.method779(var9, var10, var11);
               } else {
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class60.method1121(var9, var16 - var10, var17 - var11);
                  }

                  if(var9.type == 0) {
                     if(!var9.field2198 && class221.method3975(var9) && var9 != FaceNormal.field1558) {
                        continue;
                     }

                     method86(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method86(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var35 = (WidgetNode)Client.componentTable.method2311((long)var9.id);
                     if(null != var35) {
                        if(var35.field180 == 0 && class115.field1794 >= var12 && class115.field1797 >= var13 && class115.field1794 < var14 && class115.field1797 < var15 && !Client.isMenuOpen && !Client.field456) {
                           for(class18 var40 = (class18)Client.field475.method2359(); var40 != null; var40 = (class18)Client.field475.method2361()) {
                              if(var40.field191) {
                                 var40.unlink();
                                 var40.field187.field2300 = false;
                              }
                           }

                           if(class72.field1191 == 0) {
                              Client.field511 = null;
                              Client.field460 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var35.id;
                        if(class212.method3870(var19)) {
                           method86(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.field2198) {
                     class18 var51;
                     if(!var9.field2341) {
                        if(var9.field2342 && class115.field1794 >= var12 && class115.field1797 >= var13 && class115.field1794 < var14 && class115.field1797 < var15) {
                           for(var51 = (class18)Client.field475.method2359(); null != var51; var51 = (class18)Client.field475.method2361()) {
                              if(var51.field191 && var51.field188 == var51.field187.field2309) {
                                 var51.unlink();
                              }
                           }
                        }
                     } else if(class115.field1794 >= var12 && class115.field1797 >= var13 && class115.field1794 < var14 && class115.field1797 < var15) {
                        for(var51 = (class18)Client.field475.method2359(); null != var51; var51 = (class18)Client.field475.method2361()) {
                           if(var51.field191) {
                              var51.unlink();
                              var51.field187.field2300 = false;
                           }
                        }

                        if(class72.field1191 == 0) {
                           Client.field511 = null;
                           Client.field460 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var41;
                     if(class115.field1794 >= var12 && class115.field1797 >= var13 && class115.field1794 < var14 && class115.field1797 < var15) {
                        var41 = true;
                     } else {
                        var41 = false;
                     }

                     boolean var42 = false;
                     if((class115.field1795 == 1 || !class103.field1662 && class115.field1795 == 4) && var41) {
                        var42 = true;
                     }

                     boolean var20 = false;
                     if((class115.field1802 == 1 || !class103.field1662 && class115.field1802 == 4) && class115.field1803 >= var12 && class115.field1804 >= var13 && class115.field1803 < var14 && class115.field1804 < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        DecorativeObject.method1894(var9, class115.field1803 - var10, class115.field1804 - var11);
                     }

                     if(Client.field511 != null && var9 != Client.field511 && var41 && class156.method2956(class143.method2647(var9))) {
                        Client.field463 = var9;
                     }

                     if(var9 == Client.field460) {
                        Client.field464 = true;
                        Client.field494 = var10;
                        Client.field329 = var11;
                     }

                     if(var9.field2280) {
                        class18 var32;
                        if(var41 && Client.field394 != 0 && null != var9.field2309) {
                           var32 = new class18();
                           var32.field191 = true;
                           var32.field187 = var9;
                           var32.field189 = Client.field394;
                           var32.field188 = var9.field2309;
                           Client.field475.method2376(var32);
                        }

                        if(Client.field511 != null || null != WallObject.field1550 || Client.isMenuOpen) {
                           var20 = false;
                           var42 = false;
                           var41 = false;
                        }

                        if(!var9.field2327 && var20) {
                           var9.field2327 = true;
                           if(var9.field2290 != null) {
                              var32 = new class18();
                              var32.field191 = true;
                              var32.field187 = var9;
                              var32.field192 = class115.field1803 - var10;
                              var32.field189 = class115.field1804 - var11;
                              var32.field188 = var9.field2290;
                              Client.field475.method2376(var32);
                           }
                        }

                        if(var9.field2327 && var42 && null != var9.field2291) {
                           var32 = new class18();
                           var32.field191 = true;
                           var32.field187 = var9;
                           var32.field192 = class115.field1794 - var10;
                           var32.field189 = class115.field1797 - var11;
                           var32.field188 = var9.field2291;
                           Client.field475.method2376(var32);
                        }

                        if(var9.field2327 && !var42) {
                           var9.field2327 = false;
                           if(null != var9.field2207) {
                              var32 = new class18();
                              var32.field191 = true;
                              var32.field187 = var9;
                              var32.field192 = class115.field1794 - var10;
                              var32.field189 = class115.field1797 - var11;
                              var32.field188 = var9.field2207;
                              Client.field552.method2376(var32);
                           }
                        }

                        if(var42 && null != var9.field2227) {
                           var32 = new class18();
                           var32.field191 = true;
                           var32.field187 = var9;
                           var32.field192 = class115.field1794 - var10;
                           var32.field189 = class115.field1797 - var11;
                           var32.field188 = var9.field2227;
                           Client.field475.method2376(var32);
                        }

                        if(!var9.field2300 && var41) {
                           var9.field2300 = true;
                           if(var9.field2294 != null) {
                              var32 = new class18();
                              var32.field191 = true;
                              var32.field187 = var9;
                              var32.field192 = class115.field1794 - var10;
                              var32.field189 = class115.field1797 - var11;
                              var32.field188 = var9.field2294;
                              Client.field475.method2376(var32);
                           }
                        }

                        if(var9.field2300 && var41 && null != var9.field2259) {
                           var32 = new class18();
                           var32.field191 = true;
                           var32.field187 = var9;
                           var32.field192 = class115.field1794 - var10;
                           var32.field189 = class115.field1797 - var11;
                           var32.field188 = var9.field2259;
                           Client.field475.method2376(var32);
                        }

                        if(var9.field2300 && !var41) {
                           var9.field2300 = false;
                           if(null != var9.field2295) {
                              var32 = new class18();
                              var32.field191 = true;
                              var32.field187 = var9;
                              var32.field192 = class115.field1794 - var10;
                              var32.field189 = class115.field1797 - var11;
                              var32.field188 = var9.field2295;
                              Client.field552.method2376(var32);
                           }
                        }

                        if(null != var9.field2307) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2307;
                           Client.field486.method2376(var32);
                        }

                        class18 var24;
                        if(null != var9.field2301 && Client.field432 > var9.field2336) {
                           if(var9.field2302 != null && Client.field432 - var9.field2336 <= 32) {
                              label1197:
                              for(var21 = var9.field2336; var21 < Client.field432; ++var21) {
                                 var22 = Client.field472[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2302.length; ++var23) {
                                    if(var22 == var9.field2302[var23]) {
                                       var24 = new class18();
                                       var24.field187 = var9;
                                       var24.field188 = var9.field2301;
                                       Client.field475.method2376(var24);
                                       break label1197;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class18();
                              var32.field187 = var9;
                              var32.field188 = var9.field2301;
                              Client.field475.method2376(var32);
                           }

                           var9.field2336 = Client.field432;
                        }

                        if(var9.field2303 != null && Client.field365 > var9.field2299) {
                           if(var9.field2304 != null && Client.field365 - var9.field2299 <= 32) {
                              label1173:
                              for(var21 = var9.field2299; var21 < Client.field365; ++var21) {
                                 var22 = Client.field474[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2304.length; ++var23) {
                                    if(var9.field2304[var23] == var22) {
                                       var24 = new class18();
                                       var24.field187 = var9;
                                       var24.field188 = var9.field2303;
                                       Client.field475.method2376(var24);
                                       break label1173;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class18();
                              var32.field187 = var9;
                              var32.field188 = var9.field2303;
                              Client.field475.method2376(var32);
                           }

                           var9.field2299 = Client.field365;
                        }

                        if(var9.field2216 != null && Client.field379 > var9.field2338) {
                           if(var9.field2241 != null && Client.field379 - var9.field2338 <= 32) {
                              label1149:
                              for(var21 = var9.field2338; var21 < Client.field379; ++var21) {
                                 var22 = Client.field285[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2241.length; ++var23) {
                                    if(var9.field2241[var23] == var22) {
                                       var24 = new class18();
                                       var24.field187 = var9;
                                       var24.field188 = var9.field2216;
                                       Client.field475.method2376(var24);
                                       break label1149;
                                    }
                                 }
                              }
                           } else {
                              var32 = new class18();
                              var32.field187 = var9;
                              var32.field188 = var9.field2216;
                              Client.field475.method2376(var32);
                           }

                           var9.field2338 = Client.field379;
                        }

                        if(Client.field361 > var9.field2335 && var9.field2310 != null) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2310;
                           Client.field475.method2376(var32);
                        }

                        if(Client.field479 > var9.field2335 && null != var9.field2238) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2238;
                           Client.field475.method2376(var32);
                        }

                        if(Client.field480 > var9.field2335 && var9.field2313 != null) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2313;
                           Client.field475.method2376(var32);
                        }

                        if(Client.field481 > var9.field2335 && var9.field2268 != null) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2268;
                           Client.field475.method2376(var32);
                        }

                        if(Client.field446 > var9.field2335 && null != var9.field2319) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2319;
                           Client.field475.method2376(var32);
                        }

                        if(Client.field476 > var9.field2335 && var9.field2337 != null) {
                           var32 = new class18();
                           var32.field187 = var9;
                           var32.field188 = var9.field2337;
                           Client.field475.method2376(var32);
                        }

                        var9.field2335 = Client.field471;
                        if(var9.field2311 != null) {
                           for(var21 = 0; var21 < Client.field509; ++var21) {
                              class18 var37 = new class18();
                              var37.field187 = var9;
                              var37.field190 = Client.field431[var21];
                              var37.field193 = Client.field458[var21];
                              var37.field188 = var9.field2311;
                              Client.field475.method2376(var37);
                           }
                        }
                     }
                  }

                  if(!var9.field2198 && null == Client.field511 && WallObject.field1550 == null && !Client.isMenuOpen) {
                     if((var9.field2323 >= 0 || var9.field2235 != 0) && class115.field1794 >= var12 && class115.field1797 >= var13 && class115.field1794 < var14 && class115.field1797 < var15) {
                        if(var9.field2323 >= 0) {
                           FaceNormal.field1558 = var0[var9.field2323];
                        } else {
                           FaceNormal.field1558 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1794 >= var12 && class115.field1797 >= var13 && class115.field1794 < var14 && class115.field1797 < var15) {
                        class10.field105 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var18 = var10 + var9.width;
                        var19 = var9.height;
                        var43 = var9.scrollHeight;
                        var21 = class115.field1794;
                        var22 = class115.field1797;
                        if(Client.field369) {
                           Client.field473 = 32;
                        } else {
                           Client.field473 = 0;
                        }

                        Client.field369 = false;
                        if(class115.field1795 == 1 || !class103.field1662 && class115.field1795 == 4) {
                           if(var21 >= var18 && var21 < var18 + 16 && var22 >= var11 && var22 < var11 + 16) {
                              var9.scrollY -= 4;
                              class94.method1890(var9);
                           } else if(var21 >= var18 && var21 < var18 + 16 && var22 >= var11 + var19 - 16 && var22 < var19 + var11) {
                              var9.scrollY += 4;
                              class94.method1890(var9);
                           } else if(var21 >= var18 - Client.field473 && var21 < 16 + var18 + Client.field473 && var22 >= var11 + 16 && var22 < var11 + var19 - 16) {
                              var23 = (var19 - 32) * var19 / var43;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              var36 = var22 - var11 - 16 - var23 / 2;
                              var25 = var19 - 32 - var23;
                              var9.scrollY = var36 * (var43 - var19) / var25;
                              class94.method1890(var9);
                              Client.field369 = true;
                           }
                        }

                        if(Client.field394 != 0) {
                           var23 = var9.width;
                           if(var21 >= var18 - var23 && var22 >= var11 && var21 < 16 + var18 && var22 <= var19 + var11) {
                              var9.scrollY += Client.field394 * 45;
                              class94.method1890(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}

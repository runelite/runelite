import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class105 implements KeyListener, FocusListener {
   @ObfuscatedName("p")
   @Export("keyboard")
   public static class105 keyboard = new class105();
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 1570667431
   )
   static int field1701 = 0;
   @ObfuscatedName("cv")
   static char[] field1706 = new char[128];
   @ObfuscatedName("cd")
   public static boolean[] field1708 = new boolean[112];
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 569359441
   )
   static int field1710 = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 944588015
   )
   public static int field1711 = 0;
   @ObfuscatedName("cx")
   public static int[] field1712 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cj")
   static int[] field1713 = new int[128];
   @ObfuscatedName("ce")
   public static int[] field1714 = new int[128];
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -463563371
   )
   public static int field1715 = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 529999543
   )
   static int field1717 = 0;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 860773805
   )
   static int field1718 = 0;
   @ObfuscatedName("ch")
   static int[] field1719 = new int[128];
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 2010850187
   )
   @Export("keyboardIdleTicks")
   static volatile int keyboardIdleTicks = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 108410411
   )
   public static int field1721;

   public final void keyTyped(KeyEvent var1) {
      if(null != keyboard) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class140.method2636(var2)) {
            int var3 = field1717 + 1 & 127;
            if(var3 != field1701) {
               field1713[field1717] = -1;
               field1706[field1717] = var2;
               field1717 = var3;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1712.length) {
            var2 = field1712[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field1711 >= 0 && var2 >= 0) {
            field1719[field1711] = ~var2;
            field1711 = 1 + field1711 & 127;
            if(field1711 == field1710) {
               field1711 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1073423493"
   )
   public static Widget method1992(int var0, int var1) {
      Widget var2 = class37.method736(var0);
      return var1 == -1?var2:(null != var2 && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lclass109;",
      garbageValue = "46"
   )
   static class109 method2002() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != keyboard) {
         keyboardIdleTicks = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field1712.length) {
            var2 = field1712[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field1711 >= 0 && var2 >= 0) {
            field1719[field1711] = var2;
            field1711 = 1 + field1711 & 127;
            if(field1711 == field1710) {
               field1711 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field1717 + 1 & 127;
            if(var3 != field1701) {
               field1713[field1717] = var2;
               field1706[field1717] = 0;
               field1717 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1438468817"
   )
   static final void method2014(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field283 && var0 != WallObject.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Renderable.region.method1778(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Renderable.region.method1726(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Renderable.region.method1727(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Renderable.region.method1741(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Renderable.region.method1729(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Renderable.region.method1716(var0, var2, var3);
               var12 = class217.getObjectDefinition(var34);
               if(var12.field2906 != 0) {
                  Client.collisionMaps[var0].method2259(var2, var3, var35, var36, var12.field2934);
               }
            }

            if(var1 == 1) {
               Renderable.region.method1717(var0, var2, var3);
            }

            if(var1 == 2) {
               Renderable.region.method1830(var0, var2, var3);
               var12 = class217.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var12.sizeX + var3 > 103 || var12.sizeY + var2 > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.field2906 != 0) {
                  Client.collisionMaps[var0].method2267(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field2934);
               }
            }

            if(var1 == 3) {
               Renderable.region.method1719(var0, var2, var3);
               var12 = class217.getObjectDefinition(var34);
               if(var12.field2906 == 1) {
                  Client.collisionMaps[var0].method2269(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = Renderable.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class217.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = var2 + (var15 >> 1);
               var18 = (var15 + 1 >> 1) + var2;
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (1 + var16 >> 1);
            } else {
               var19 = var3;
               var20 = 1 + var3;
            }

            int[][] var21 = class10.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var19] + var21[var18][var19] + var21[var17][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = (var4 << 14) + var2 + (var3 << 7) + 1073741824;
            if(var14.field2908 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = var6 + (var5 << 6);
            if(var14.field2929 == 1) {
               var26 += 256;
            }

            Object var32;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var32 = var14.method3608(22, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var32, var25, var26);
               if(var14.field2906 == 1) {
                  var13.method2257(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3608(var6, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1709(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                  if(var14.field2906 != 0) {
                     var13.method2255(var2, var3, var15, var16, var14.field2934);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3608(0, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1867(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field91[var5], 0, var25, var26);
                  if(var14.field2906 != 0) {
                     var13.method2254(var2, var3, var6, var5, var14.field2934);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && null == var14.impostorIds) {
                     var32 = var14.method3608(1, var5, var21, var23, var22, var24);
                  } else {
                     var32 = new class49(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method1867(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field92[var5], 0, var25, var26);
                  if(var14.field2906 != 0) {
                     var13.method2254(var2, var3, var6, var5, var14.field2934);
                  }
               } else {
                  int var27;
                  Object var29;
                  if(var6 == 2) {
                     var27 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method3608(2, 4 + var5, var21, var23, var22, var24);
                        var29 = var14.method3608(2, var27, var21, var23, var22, var24);
                     } else {
                        var28 = new class49(var4, 2, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class49(var4, 2, var27, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1867(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class10.field91[var5], class10.field91[var27], var25, var26);
                     if(var14.field2906 != 0) {
                        var13.method2254(var2, var3, var6, var5, var14.field2934);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method3608(3, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1867(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field92[var5], 0, var25, var26);
                     if(var14.field2906 != 0) {
                        var13.method2254(var2, var3, var6, var5, var14.field2934);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method3608(var6, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1709(var0, var2, var3, var22, 1, 1, (Renderable)var32, 0, var25, var26);
                     if(var14.field2906 != 0) {
                        var13.method2255(var2, var3, var15, var16, var14.field2934);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var32 = var14.method3608(4, var5, var21, var23, var22, var24);
                     } else {
                        var32 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method1757(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, class10.field91[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var27 = 16;
                        var33 = var37.method1778(var0, var2, var3);
                        if(var33 != 0) {
                           var27 = class217.getObjectDefinition(var33 >> 14 & 32767).field2935;
                        }

                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3608(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1757(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class10.field91[var5], 0, var27 * class10.field95[var5], var27 * class10.field94[var5], var25, var26);
                     } else if(var6 == 6) {
                        var27 = 8;
                        var33 = var37.method1778(var0, var2, var3);
                        if(var33 != 0) {
                           var27 = class217.getObjectDefinition(var33 >> 14 & 32767).field2935 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method3608(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1757(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var27 * class10.field85[var5], class10.field96[var5] * var27, var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var32 = var14.method3608(4, 4 + var33, var21, var23, var22, var24);
                        } else {
                           var32 = new class49(var4, 4, 4 + var33, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1757(var0, var2, var3, var22, (Renderable)var32, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var27 = 8;
                        var33 = var37.method1778(var0, var2, var3);
                        if(var33 != 0) {
                           var27 = class217.getObjectDefinition(var33 >> 14 & 32767).field2935 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.animationId == -1 && null == var14.impostorIds) {
                           var29 = var14.method3608(4, 4 + var5, var21, var23, var22, var24);
                           var30 = var14.method3608(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class49(var4, 4, 4 + var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class49(var4, 4, 4 + var31, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method1757(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class10.field85[var5] * var27, class10.field96[var5] * var27, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && null == var14.impostorIds) {
                  var32 = var14.method3608(10, var5, var21, var23, var22, var24);
               } else {
                  var32 = new class49(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var32 != null) {
                  var37.method1709(var0, var2, var3, var22, var15, var16, (Renderable)var32, var6 == 11?256:0, var25, var26);
               }

               if(var14.field2906 != 0) {
                  var13.method2255(var2, var3, var15, var16, var14.field2934);
               }
            }
         }
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field1711 = -1;
      }

   }
}

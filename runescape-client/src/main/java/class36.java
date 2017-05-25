import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class36 {
   @ObfuscatedName("i")
   static final class36 field497;
   @ObfuscatedName("h")
   static final class36 field498;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -601728627
   )
   final int field499;
   @ObfuscatedName("q")
   public static class204 field501;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 1332885709
   )
   static int field502;

   static {
      field497 = new class36(0);
      field498 = new class36(1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class36(int var1) {
      this.field499 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LModel;IIII)Z",
      garbageValue = "-1880564379"
   )
   static final boolean method496(Model var0, int var1, int var2, int var3) {
      boolean var4 = class134.field1980;
      if(!var4) {
         return false;
      } else {
         int var5;
         int var6;
         int var7;
         int var8;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         if(!class134.field1984) {
            var5 = Region.field2063;
            var6 = Region.field2064;
            var7 = Region.field2065;
            var8 = Region.field2085;
            byte var9 = 50;
            short var10 = 3500;
            var11 = var9 * (class134.field1979 - class136.field2007) / class136.field1998;
            var12 = var9 * (class134.field1988 - class136.field2008) / class136.field1998;
            var13 = (class134.field1979 - class136.field2007) * var10 / class136.field1998;
            int var14 = var10 * (class134.field1988 - class136.field2008) / class136.field1998;
            int var15 = class136.method2667(var12, var9, var6, var5);
            var16 = class136.method2644(var12, var9, var6, var5);
            var12 = var15;
            var15 = class136.method2667(var14, var10, var6, var5);
            var17 = class136.method2644(var14, var10, var6, var5);
            var14 = var15;
            var15 = class136.method2642(var11, var16, var8, var7);
            var16 = class136.method2643(var11, var16, var8, var7);
            var11 = var15;
            var15 = class136.method2642(var13, var17, var8, var7);
            var17 = class136.method2643(var13, var17, var8, var7);
            class134.field1982 = (var11 + var15) / 2;
            class134.field1983 = (var12 + var14) / 2;
            class14.field291 = (var17 + var16) / 2;
            class23.field352 = (var15 - var11) / 2;
            class134.field1981 = (var14 - var12) / 2;
            class3.field17 = (var17 - var16) / 2;
            class33.field470 = Math.abs(class23.field352);
            class134.field1985 = Math.abs(class134.field1981);
            class31.field446 = Math.abs(class3.field17);
         }

         var5 = var0.field1919 + var1;
         var6 = var0.field1941 + var2;
         var7 = var3 + var0.field1942;
         var8 = var0.field1963;
         var16 = var0.field1956;
         var17 = var0.field1945;
         var11 = class134.field1982 - var5;
         var12 = class134.field1983 - var6;
         var13 = class14.field291 - var7;
         return Math.abs(var11) > class33.field470 + var8?false:(Math.abs(var12) > class134.field1985 + var16?false:(Math.abs(var13) > var17 + class31.field446?false:(Math.abs(var13 * class134.field1981 - class3.field17 * var12) > var17 * class134.field1985 + var16 * class31.field446?false:(Math.abs(var11 * class3.field17 - class23.field352 * var13) > var17 * class33.field470 + var8 * class31.field446?false:Math.abs(class23.field352 * var12 - var11 * class134.field1981) <= var8 * class134.field1985 + var16 * class33.field470))));
      }
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "-1473048526"
   )
   static void method497(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2713 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2713 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2713 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.field2654 == 0) {
         var0.height = var0.field2638;
      } else if(var0.field2654 == 1) {
         var0.height = var2 - var0.field2638;
      } else if(var0.field2654 == 2) {
         var0.height = var0.field2638 * var2 >> 14;
      }

      if(var0.field2713 == 4) {
         var0.width = var0.height * var0.field2659 / var0.field2757;
      }

      if(var0.field2654 == 4) {
         var0.height = var0.field2757 * var0.width / var0.field2659;
      }

      if(Client.field1060 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field903 = var0;
      }

      if(var3 && var0.field2751 != null && (var0.width != var4 || var0.height != var5)) {
         class69 var6 = new class69();
         var6.field816 = var0;
         var6.field826 = var0.field2751;
         Client.field1089.method3655(var6);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "987985243"
   )
   static int method498(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class83.field1311:Buffer.field2384;
      if(var0 == 1600) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class83.intStack[++class83.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2696;
         return 1;
      } else if(var0 == 1606) {
         class83.intStack[++class83.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class83.intStack[++class83.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class83.intStack[++class83.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class83.intStack[++class83.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2734;
         return 1;
      } else if(var0 == 1611) {
         class83.intStack[++class83.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2668;
         return 1;
      } else if(var0 == 1613) {
         class83.intStack[++class83.intStackSize - 1] = var3.field2672.vmethod5090();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   static void method499() {
      try {
         File var0 = new File(class60.field735, "random.dat");
         int var2;
         if(var0.exists()) {
            class155.field2221 = new class123(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label39:
            for(int var1 = 0; var1 < class155.field2227.length; ++var1) {
               for(var2 = 0; var2 < class60.field736.length; ++var2) {
                  File var3 = new File(class60.field736[var2] + class155.field2227[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class155.field2221 = new class123(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label39;
                  }
               }
            }
         }

         if(class155.field2221 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class155.field2221 = new class123(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;B)V",
      garbageValue = "108"
   )
   static final void method500(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field895 || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field752) {
            class61.field752 = var0;
         }

         ObjectComposition var8 = class43.getObjectDefinition(var3);
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
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = (var2 << 7) + var1 + (var3 << 14) + 1073741824;
         if(var8.field3456 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field3443 == 1) {
            var20 += 256;
         }

         if(var8.method4623()) {
            class170.method3170(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field895 || var8.field3456 != 0 || var8.field3446 == 1 || var8.field3461) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method4603(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class100(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field3446 == 1 && var7 != null) {
                  var7.method3072(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method4603(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class100(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2787(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class61.field754[var0][var1][var2] |= 2340;
                  }

                  if(var8.field3446 != 0 && var7 != null) {
                     var7.method3074(var1, var2, var9, var10, var8.field3447);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method4603(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class100(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2717(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field755[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field3460) {
                        class18.field315[var0][var1][var2] = 50;
                        class18.field315[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field3451) {
                        class61.field754[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field3460) {
                        class18.field315[var0][var1][var2 + 1] = 50;
                        class18.field315[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field3451) {
                        class61.field754[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field3460) {
                        class18.field315[var0][var1 + 1][var2] = 50;
                        class18.field315[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field3451) {
                        class61.field754[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field3460) {
                        class18.field315[var0][var1][var2] = 50;
                        class18.field315[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field3451) {
                        class61.field754[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field3446 != 0 && var7 != null) {
                     var7.method3100(var1, var2, var5, var4, var8.field3447);
                  }

                  if(var8.field3453 != 16) {
                     var6.method2723(var0, var1, var2, var8.field3453);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method4603(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class100(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2717(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field750[var4], 0, var19, var20);
                  if(var8.field3460) {
                     if(var4 == 0) {
                        class18.field315[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class18.field315[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class18.field315[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class18.field315[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field3446 != 0 && var7 != null) {
                     var7.method3100(var1, var2, var5, var4, var8.field3447);
                  }

               } else {
                  Object var23;
                  int var28;
                  if(var5 == 2) {
                     var28 = var4 + 1 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.method4603(2, var4 + 4, var15, var17, var16, var18);
                        var23 = var8.method4603(2, var28, var15, var17, var16, var18);
                     } else {
                        var27 = new class100(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var23 = new class100(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2717(var0, var1, var2, var16, (Renderable)var27, (Renderable)var23, class61.field755[var4], class61.field755[var28], var19, var20);
                     if(var8.field3451) {
                        if(var4 == 0) {
                           class61.field754[var0][var1][var2] |= 585;
                           class61.field754[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class61.field754[var0][var1][var2 + 1] |= 1170;
                           class61.field754[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class61.field754[var0][var1 + 1][var2] |= 585;
                           class61.field754[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class61.field754[var0][var1][var2] |= 1170;
                           class61.field754[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field3446 != 0 && var7 != null) {
                        var7.method3100(var1, var2, var5, var4, var8.field3447);
                     }

                     if(var8.field3453 != 16) {
                        var6.method2723(var0, var1, var2, var8.field3453);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4603(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class100(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2717(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field750[var4], 0, var19, var20);
                     if(var8.field3460) {
                        if(var4 == 0) {
                           class18.field315[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class18.field315[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class18.field315[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class18.field315[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field3446 != 0 && var7 != null) {
                        var7.method3100(var1, var2, var5, var4, var8.field3447);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4603(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class100(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2787(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field3446 != 0 && var7 != null) {
                        var7.method3074(var1, var2, var9, var10, var8.field3447);
                     }

                     if(var8.field3453 != 16) {
                        var6.method2723(var0, var1, var2, var8.field3453);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4603(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class100(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2777(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field755[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var28 = 16;
                     var22 = var6.method2733(var0, var1, var2);
                     if(var22 != 0) {
                        var28 = class43.getObjectDefinition(var22 >> 14 & 32767).field3453;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method4603(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class100(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2777(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class61.field755[var4], 0, class61.field751[var4] * var28, class61.field757[var4] * var28, var19, var20);
                  } else if(var5 == 6) {
                     var28 = 8;
                     var22 = var6.method2733(var0, var1, var2);
                     if(var22 != 0) {
                        var28 = class43.getObjectDefinition(var22 >> 14 & 32767).field3453 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method4603(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class100(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2777(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, class61.field753[var4] * var28, var28 * class61.field742[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4603(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class100(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2777(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var28 = 8;
                     var22 = var6.method2733(var0, var1, var2);
                     if(var22 != 0) {
                        var28 = class43.getObjectDefinition(var22 >> 14 & 32767).field3453 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method4603(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method4603(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class100(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new class100(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2777(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, class61.field753[var4] * var28, class61.field742[var4] * var28, var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method4603(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class100(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2787(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field3460) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2541() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var26 = 0; var26 <= var9; ++var26) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class18.field315[var0][var26 + var1][var2 + var24]) {
                           class18.field315[var0][var26 + var1][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field3446 != 0 && var7 != null) {
                  var7.method3074(var1, var2, var9, var10, var8.field3447);
               }

            }
         }
      }
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "755082607"
   )
   static final void method501() {
      int var0 = class90.field1399 * 128 + 64;
      int var1 = class73.field852 * 128 + 64;
      int var2 = Ignore.method1119(var0, var1, Sequence.plane) - Item.field1477;
      if(class12.cameraX < var0) {
         class12.cameraX += class41.field547 + class27.field391 * (var0 - class12.cameraX) / 1000;
         if(class12.cameraX > var0) {
            class12.cameraX = var0;
         }
      }

      if(class12.cameraX > var0) {
         class12.cameraX -= class27.field391 * (class12.cameraX - var0) / 1000 + class41.field547;
         if(class12.cameraX < var0) {
            class12.cameraX = var0;
         }
      }

      if(class40.cameraZ < var2) {
         class40.cameraZ += class27.field391 * (var2 - class40.cameraZ) / 1000 + class41.field547;
         if(class40.cameraZ > var2) {
            class40.cameraZ = var2;
         }
      }

      if(class40.cameraZ > var2) {
         class40.cameraZ -= class27.field391 * (class40.cameraZ - var2) / 1000 + class41.field547;
         if(class40.cameraZ < var2) {
            class40.cameraZ = var2;
         }
      }

      if(class12.cameraY < var1) {
         class12.cameraY += (var1 - class12.cameraY) * class27.field391 / 1000 + class41.field547;
         if(class12.cameraY > var1) {
            class12.cameraY = var1;
         }
      }

      if(class12.cameraY > var1) {
         class12.cameraY -= (class12.cameraY - var1) * class27.field391 / 1000 + class41.field547;
         if(class12.cameraY < var1) {
            class12.cameraY = var1;
         }
      }

      var0 = class15.field296 * 128 + 64;
      var1 = class172.field2353 * 128 + 64;
      var2 = Ignore.method1119(var0, var1, Sequence.plane) - class257.field3542;
      int var3 = var0 - class12.cameraX;
      int var4 = var2 - class40.cameraZ;
      int var5 = var1 - class12.cameraY;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(field502 < var7) {
         field502 += ChatMessages.field1500 * (var7 - field502) / 1000 + class164.field2292;
         if(field502 > var7) {
            field502 = var7;
         }
      }

      if(field502 > var7) {
         field502 -= class164.field2292 + ChatMessages.field1500 * (field502 - var7) / 1000;
         if(field502 < var7) {
            field502 = var7;
         }
      }

      int var9 = var8 - class244.field3307;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class244.field3307 += class164.field2292 + var9 * ChatMessages.field1500 / 1000;
         class244.field3307 &= 2047;
      }

      if(var9 < 0) {
         class244.field3307 -= class164.field2292 + ChatMessages.field1500 * -var9 / 1000;
         class244.field3307 &= 2047;
      }

      int var10 = var8 - class244.field3307;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class244.field3307 = var8;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-569254879"
   )
   public static final void method502() {
      class134.field1980 = false;
      class134.field1986 = 0;
   }
}

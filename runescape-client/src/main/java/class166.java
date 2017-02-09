import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public final class class166 extends Buffer {
   @ObfuscatedName("mj")
   static byte field2291;
   @ObfuscatedName("n")
   class167 field2292;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1140458993
   )
   int field2293;
   @ObfuscatedName("c")
   static final int[] field2295 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("bb")
   static class184 field2297;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1167490769"
   )
   static final void method3171(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class39.field798[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class11.tileHeights[0][var5][var4] = class11.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;B)V",
      garbageValue = "120"
   )
   static final void method3172(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field278 || (class11.tileSettings[0][var1][var2] & 2) != 0 || (class11.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class11.field115) {
            class11.field115 = var0;
         }

         ObjectComposition var8 = class156.getObjectDefinition(var3);
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
            var11 = (var9 >> 1) + var1;
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class11.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var2 << 7) + var1 + (var3 << 14);
         if(var8.field2910 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2914 == 1) {
            var20 += 256;
         }

         int var22;
         int var27;
         if(var8.method3608()) {
            class31 var26 = new class31();
            var26.field703 = var0;
            var26.field699 = var1 * 128;
            var26.field692 = var2 * 128;
            var22 = var8.sizeX;
            var27 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var27 = var8.sizeX;
            }

            var26.field696 = (var1 + var22) * 128;
            var26.field704 = (var27 + var2) * 128;
            var26.field694 = var8.ambientSoundId;
            var26.field698 = var8.field2919 * 128;
            var26.field701 = var8.field2874;
            var26.field702 = var8.field2921;
            var26.field695 = var8.field2922;
            if(null != var8.impostorIds) {
               var26.field706 = var8;
               var26.method699();
            }

            class31.field693.method2380(var26);
            if(null != var26.field695) {
               var26.field697 = var26.field701 + (int)(Math.random() * (double)(var26.field702 - var26.field701));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field278 || var8.field2910 != 0 || var8.field2901 == 1 || var8.field2912) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var30 = var8.method3603(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field2901 == 1 && var7 != null) {
                  var7.method2270(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var30 = var8.method3603(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1756(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class7.field55[var0][var1][var2] |= 2340;
               }

               if(var8.field2901 != 0 && var7 != null) {
                  var7.method2239(var1, var2, var9, var10, var8.field2876);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3603(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1715(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class11.field107[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field2905) {
                     class39.field798[var0][var1][var2] = 50;
                     class39.field798[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.field2896) {
                     class7.field55[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field2905) {
                     class39.field798[var0][var1][1 + var2] = 50;
                     class39.field798[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field2896) {
                     class7.field55[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field2905) {
                     class39.field798[var0][var1 + 1][var2] = 50;
                     class39.field798[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.field2896) {
                     class7.field55[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field2905) {
                     class39.field798[var0][var1][var2] = 50;
                     class39.field798[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.field2896) {
                     class7.field55[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field2901 != 0 && var7 != null) {
                  var7.method2245(var1, var2, var5, var4, var8.field2876);
               }

               if(var8.field2898 != 16) {
                  var6.method1755(var0, var1, var2, var8.field2898);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method3603(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method1715(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class11.field116[var4], 0, var19, var20);
               if(var8.field2905) {
                  if(var4 == 0) {
                     class39.field798[var0][var1][1 + var2] = 50;
                  } else if(var4 == 1) {
                     class39.field798[var0][1 + var1][1 + var2] = 50;
                  } else if(var4 == 2) {
                     class39.field798[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class39.field798[var0][var1][var2] = 50;
                  }
               }

               if(var8.field2901 != 0 && null != var7) {
                  var7.method2245(var1, var2, var5, var4, var8.field2876);
               }

            } else {
               int var21;
               Object var23;
               if(var5 == 2) {
                  var21 = var4 + 1 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var29 = var8.method3603(2, var4 + 4, var15, var17, var16, var18);
                     var23 = var8.method3603(2, var21, var15, var17, var16, var18);
                  } else {
                     var29 = new class49(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var23 = new class49(var3, 2, var21, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1715(var0, var1, var2, var16, (Renderable)var29, (Renderable)var23, class11.field107[var4], class11.field107[var21], var19, var20);
                  if(var8.field2896) {
                     if(var4 == 0) {
                        class7.field55[var0][var1][var2] |= 585;
                        class7.field55[var0][var1][1 + var2] |= 1170;
                     } else if(var4 == 1) {
                        class7.field55[var0][var1][1 + var2] |= 1170;
                        class7.field55[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class7.field55[var0][var1 + 1][var2] |= 585;
                        class7.field55[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class7.field55[var0][var1][var2] |= 1170;
                        class7.field55[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field2901 != 0 && null != var7) {
                     var7.method2245(var1, var2, var5, var4, var8.field2876);
                  }

                  if(var8.field2898 != 16) {
                     var6.method1755(var0, var1, var2, var8.field2898);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3603(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1715(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class11.field116[var4], 0, var19, var20);
                  if(var8.field2905) {
                     if(var4 == 0) {
                        class39.field798[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class39.field798[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class39.field798[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class39.field798[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2901 != 0 && null != var7) {
                     var7.method2245(var1, var2, var5, var4, var8.field2876);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3603(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1756(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field2901 != 0 && null != var7) {
                     var7.method2239(var1, var2, var9, var10, var8.field2876);
                  }

                  if(var8.field2898 != 16) {
                     var6.method1755(var0, var1, var2, var8.field2898);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method3603(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1716(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class11.field107[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var21 = 16;
                  var22 = var6.method1733(var0, var1, var2);
                  if(var22 != 0) {
                     var21 = class156.getObjectDefinition(var22 >> 14 & 32767).field2898;
                  }

                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var23 = var8.method3603(4, var4, var15, var17, var16, var18);
                  } else {
                     var23 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1716(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class11.field107[var4], 0, class11.field103[var4] * var21, var21 * class11.field104[var4], var19, var20);
               } else if(var5 == 6) {
                  var21 = 8;
                  var22 = var6.method1733(var0, var1, var2);
                  if(var22 != 0) {
                     var21 = class156.getObjectDefinition(var22 >> 14 & 32767).field2898 / 2;
                  }

                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var23 = var8.method3603(4, 4 + var4, var15, var17, var16, var18);
                  } else {
                     var23 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1716(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var21 * class11.field105[var4], class11.field98[var4] * var21, var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var30 = var8.method3603(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new class49(var3, 4, 4 + var22, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1716(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var21 = 8;
                  var22 = var6.method1733(var0, var1, var2);
                  if(var22 != 0) {
                     var21 = class156.getObjectDefinition(var22 >> 14 & 32767).field2898 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var24;
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var23 = var8.method3603(4, 4 + var4, var15, var17, var16, var18);
                     var24 = var8.method3603(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var23 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var24 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1716(var0, var1, var2, var16, (Renderable)var23, (Renderable)var24, 256, var4, class11.field105[var4] * var21, class11.field98[var4] * var21, var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.method3603(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(null != var30 && var6.method1756(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field2905) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method1570() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var27 = 0; var27 <= var9; ++var27) {
                  for(int var28 = 0; var28 <= var10; ++var28) {
                     if(var22 > class39.field798[var0][var27 + var1][var28 + var2]) {
                        class39.field798[var0][var27 + var1][var2 + var28] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field2901 != 0 && null != var7) {
               var7.method2239(var1, var2, var9, var10, var8.field2876);
            }

         }
      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1616835830"
   )
   public void method3174(int[] var1) {
      this.field2292 = new class167(var1);
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-388116426"
   )
   public void method3175() {
      this.field2293 = super.offset * 8;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1608475918"
   )
   public int method3176(int var1) {
      int var2 = this.field2293 >> 3;
      int var3 = 8 - (this.field2293 & 7);
      int var4 = 0;

      for(this.field2293 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2295[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2295[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2295[var1];
      }

      return var4;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method3177() {
      super.offset = (7 + this.field2293) / 8;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "210638898"
   )
   public int method3178(int var1) {
      return 8 * var1 - this.field2293;
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "-497920413"
   )
   static final void method3183(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field359) {
         Client.field314 = 32;
      } else {
         Client.field314 = 0;
      }

      Client.field359 = false;
      int var7;
      if(class115.field1805 == 1 || !class115.field1809 && class115.field1805 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            class2.method28(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class2.method28(var0);
         } else if(var5 >= var1 - Client.field314 && var5 < 16 + var1 + Client.field314 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class2.method28(var0);
            Client.field359 = true;
         }
      }

      if(Client.field475 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var3 + var2) {
            var0.scrollY += Client.field475 * 45;
            class2.method28(var0);
         }
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1832733221"
   )
   public int method3190() {
      return super.payload[++super.offset - 1] - this.field2292.method3204() & 255;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "985759169"
   )
   public void method3195(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2292.method3204());
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "65535"
   )
   static final void method3199(Actor var0) {
      int var1 = var0.field636 - Client.gameCycle;
      int var2 = var0.field597 * 64 + var0.field632 * 128;
      int var3 = var0.field597 * 64 + var0.field634 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field638 = 0;
      var0.field641 = var0.field616;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class166(int var1) {
      super(var1);
   }
}

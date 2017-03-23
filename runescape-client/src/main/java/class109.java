import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public abstract class class109 {
   @ObfuscatedName("n")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("l")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "299182090"
   )
   abstract void vmethod2090();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1101349845"
   )
   abstract int vmethod2091(int var1, int var2);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Lclass187;",
      garbageValue = "1"
   )
   public static class187 method2096(int var0) {
      class187 var1 = (class187)class187.field2793.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class187.field2788.getConfigData(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3492(new Buffer(var2));
         }

         class187.field2793.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[II)I",
      garbageValue = "-61347940"
   )
   public static int method2098(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1865[var8][var9] = 0;
            class118.field1870[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var28 = class25.method559(var0, var1, var3, var4);
      } else {
         byte var12;
         byte var16;
         int[][] var18;
         boolean var29;
         if(var2 == 2) {
            var10 = var0;
            var11 = var1;
            var12 = 64;
            var13 = 64;
            var14 = var0 - var12;
            var15 = var1 - var13;
            class118.field1865[var12][var13] = 99;
            class118.field1870[var12][var13] = 0;
            var16 = 0;
            var17 = 0;
            class118.field1869[var16] = var0;
            var33 = var16 + 1;
            class118.field1867[var16] = var1;
            var18 = var4.flags;

            while(true) {
               if(var33 == var17) {
                  class118.field1866 = var10;
                  class118.field1863 = var11;
                  var29 = false;
                  break;
               }

               var10 = class118.field1869[var17];
               var11 = class118.field1867[var17];
               var17 = 1 + var17 & 4095;
               var30 = var10 - var14;
               var31 = var11 - var15;
               var19 = var10 - var4.x;
               var20 = var11 - var4.y;
               if(var3.vmethod2355(2, var10, var11, var4)) {
                  class118.field1866 = var10;
                  class118.field1863 = var11;
                  var29 = true;
                  break;
               }

               var21 = class118.field1870[var30][var31] + 1;
               if(var30 > 0 && class118.field1865[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
                  class118.field1869[var33] = var10 - 1;
                  class118.field1867[var33] = var11;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[var30 - 1][var31] = 2;
                  class118.field1870[var30 - 1][var31] = var21;
               }

               if(var30 < 126 && class118.field1865[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
                  class118.field1869[var33] = var10 + 1;
                  class118.field1867[var33] = var11;
                  var33 = var33 + 1 & 4095;
                  class118.field1865[var30 + 1][var31] = 8;
                  class118.field1870[1 + var30][var31] = var21;
               }

               if(var31 > 0 && class118.field1865[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
                  class118.field1869[var33] = var10;
                  class118.field1867[var33] = var11 - 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[var30][var31 - 1] = 1;
                  class118.field1870[var30][var31 - 1] = var21;
               }

               if(var31 < 126 && class118.field1865[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
                  class118.field1869[var33] = var10;
                  class118.field1867[var33] = var11 + 1;
                  var33 = var33 + 1 & 4095;
                  class118.field1865[var30][var31 + 1] = 4;
                  class118.field1870[var30][var31 + 1] = var21;
               }

               if(var30 > 0 && var31 > 0 && class118.field1865[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
                  class118.field1869[var33] = var10 - 1;
                  class118.field1867[var33] = var11 - 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[var30 - 1][var31 - 1] = 3;
                  class118.field1870[var30 - 1][var31 - 1] = var21;
               }

               if(var30 < 126 && var31 > 0 && class118.field1865[1 + var30][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136911) == 0 && (var18[2 + var19][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
                  class118.field1869[var33] = var10 + 1;
                  class118.field1867[var33] = var11 - 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[1 + var30][var31 - 1] = 9;
                  class118.field1870[1 + var30][var31 - 1] = var21;
               }

               if(var30 > 0 && var31 < 126 && class118.field1865[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136830) == 0 && (var18[var19 - 1][2 + var20] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
                  class118.field1869[var33] = var10 - 1;
                  class118.field1867[var33] = 1 + var11;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[var30 - 1][1 + var31] = 6;
                  class118.field1870[var30 - 1][1 + var31] = var21;
               }

               if(var30 < 126 && var31 < 126 && class118.field1865[1 + var30][var31 + 1] == 0 && (var18[var19 + 1][var20 + 2] & 19137016) == 0 && (var18[var19 + 2][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
                  class118.field1869[var33] = var10 + 1;
                  class118.field1867[var33] = 1 + var11;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[var30 + 1][1 + var31] = 12;
                  class118.field1870[1 + var30][var31 + 1] = var21;
               }
            }

            var28 = var29;
         } else {
            var10 = var0;
            var11 = var1;
            var12 = 64;
            var13 = 64;
            var14 = var0 - var12;
            var15 = var1 - var13;
            class118.field1865[var12][var13] = 99;
            class118.field1870[var12][var13] = 0;
            var16 = 0;
            var17 = 0;
            class118.field1869[var16] = var0;
            var33 = var16 + 1;
            class118.field1867[var16] = var1;
            var18 = var4.flags;

            label723:
            while(true) {
               label721:
               while(true) {
                  do {
                     do {
                        do {
                           label698:
                           do {
                              if(var17 == var33) {
                                 class118.field1866 = var10;
                                 class118.field1863 = var11;
                                 var29 = false;
                                 break label723;
                              }

                              var10 = class118.field1869[var17];
                              var11 = class118.field1867[var17];
                              var17 = var17 + 1 & 4095;
                              var30 = var10 - var14;
                              var31 = var11 - var15;
                              var19 = var10 - var4.x;
                              var20 = var11 - var4.y;
                              if(var3.vmethod2355(var2, var10, var11, var4)) {
                                 class118.field1866 = var10;
                                 class118.field1863 = var11;
                                 var29 = true;
                                 break label723;
                              }

                              var21 = 1 + class118.field1870[var30][var31];
                              if(var30 > 0 && class118.field1865[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1869[var33] = var10 - 1;
                                       class118.field1867[var33] = var11;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1865[var30 - 1][var31] = 2;
                                       class118.field1870[var30 - 1][var31] = var21;
                                       break;
                                    }

                                    if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 < 128 - var2 && class118.field1865[1 + var30][var31] == 0 && (var18[var2 + var19][var20] & 19136899) == 0 && (var18[var19 + var2][var2 + var20 - 1] & 19136992) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1869[var33] = var10 + 1;
                                       class118.field1867[var33] = var11;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1865[var30 + 1][var31] = 8;
                                       class118.field1870[1 + var30][var31] = var21;
                                       break;
                                    }

                                    if((var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var31 > 0 && class118.field1865[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1869[var33] = var10;
                                       class118.field1867[var33] = var11 - 1;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1865[var30][var31 - 1] = 1;
                                       class118.field1870[var30][var31 - 1] = var21;
                                       break;
                                    }

                                    if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var31 < 128 - var2 && class118.field1865[var30][1 + var31] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var19 + var2 - 1][var20 + var2] & 19136992) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2 - 1) {
                                       class118.field1869[var33] = var10;
                                       class118.field1867[var33] = var11 + 1;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1865[var30][var31 + 1] = 4;
                                       class118.field1870[var30][1 + var31] = var21;
                                       break;
                                    }

                                    if((var18[var22 + var19][var2 + var20] & 19137016) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 > 0 && var31 > 0 && class118.field1865[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2) {
                                       class118.field1869[var33] = var10 - 1;
                                       class118.field1867[var33] = var11 - 1;
                                       var33 = var33 + 1 & 4095;
                                       class118.field1865[var30 - 1][var31 - 1] = 3;
                                       class118.field1870[var30 - 1][var31 - 1] = var21;
                                       break;
                                    }

                                    if((var18[var19 - 1][var20 - 1 + var22] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 < 128 - var2 && var31 > 0 && class118.field1865[var30 + 1][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                                 var22 = 1;

                                 while(true) {
                                    if(var22 >= var2) {
                                       class118.field1869[var33] = var10 + 1;
                                       class118.field1867[var33] = var11 - 1;
                                       var33 = 1 + var33 & 4095;
                                       class118.field1865[var30 + 1][var31 - 1] = 9;
                                       class118.field1870[1 + var30][var31 - 1] = var21;
                                       break;
                                    }

                                    if((var18[var19 + var2][var20 - 1 + var22] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var22;
                                 }
                              }

                              if(var30 > 0 && var31 < 128 - var2 && class118.field1865[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                                 for(var22 = 1; var22 < var2; ++var22) {
                                    if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var19 - 1 + var22][var2 + var20] & 19137016) != 0) {
                                       continue label698;
                                    }
                                 }

                                 class118.field1869[var33] = var10 - 1;
                                 class118.field1867[var33] = 1 + var11;
                                 var33 = var33 + 1 & 4095;
                                 class118.field1865[var30 - 1][1 + var31] = 6;
                                 class118.field1870[var30 - 1][1 + var31] = var21;
                              }
                           } while(var30 >= 128 - var2);
                        } while(var31 >= 128 - var2);
                     } while(class118.field1865[1 + var30][1 + var31] != 0);
                  } while((var18[var19 + var2][var20 + var2] & 19136992) != 0);

                  for(var22 = 1; var22 < var2; ++var22) {
                     if((var18[var22 + var19][var20 + var2] & 19137016) != 0 || (var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                        continue label721;
                     }
                  }

                  class118.field1869[var33] = var10 + 1;
                  class118.field1867[var33] = var11 + 1;
                  var33 = 1 + var33 & 4095;
                  class118.field1865[var30 + 1][1 + var31] = 12;
                  class118.field1870[1 + var30][1 + var31] = var21;
               }
            }

            var28 = var29;
         }
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class118.field1866;
      var30 = class118.field1863;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1874;
         var17 = var3.field1882;
         int var27 = var3.field1876;
         var19 = var3.field1875;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1870[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var31 || var31 == var26 && class118.field1870[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1870[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var11 == var0 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class118.field1869[var13] = var11;
         var31 = var13 + 1;
         class118.field1867[var13] = var30;

         for(var14 = var15 = class118.field1865[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class118.field1865[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class118.field1869[var31] = var11;
               class118.field1867[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class118.field1869[var31];
            var7[var33++] = class118.field1867[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }
}

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
      int var8;
      int var9;
      for(var9 = 0; var9 < 128; ++var9) {
         for(var8 = 0; var8 < 128; ++var8) {
            class118.field1865[var9][var8] = 0;
            class118.field1870[var9][var8] = 99999999;
         }
      }

      int var10;
      byte var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      boolean var19;
      int var20;
      int var21;
      int var22;
      byte var23;
      if(var2 == 1) {
         var19 = class25.method559(var0, var1, var3, var4);
      } else {
         byte var24;
         int[][] var25;
         boolean var26;
         if(var2 == 2) {
            var9 = var0;
            var10 = var1;
            var23 = 64;
            var11 = 64;
            var12 = var0 - var23;
            var13 = var1 - var11;
            class118.field1865[var23][var11] = 99;
            class118.field1870[var23][var11] = 0;
            var24 = 0;
            var14 = 0;
            class118.field1869[var24] = var0;
            var22 = var24 + 1;
            class118.field1867[var24] = var1;
            var25 = var4.flags;

            while(true) {
               if(var22 == var14) {
                  class118.field1866 = var9;
                  class118.field1863 = var10;
                  var26 = false;
                  break;
               }

               var9 = class118.field1869[var14];
               var10 = class118.field1867[var14];
               var14 = var14 + 1 & 4095;
               var20 = var9 - var12;
               var21 = var10 - var13;
               var15 = var9 - var4.x;
               var16 = var10 - var4.y;
               if(var3.vmethod2355(2, var9, var10, var4)) {
                  class118.field1866 = var9;
                  class118.field1863 = var10;
                  var26 = true;
                  break;
               }

               var17 = class118.field1870[var20][var21] + 1;
               if(var20 > 0 && class118.field1865[var20 - 1][var21] == 0 && (var25[var15 - 1][var16] & 19136782) == 0 && (var25[var15 - 1][var16 + 1] & 19136824) == 0) {
                  class118.field1869[var22] = var9 - 1;
                  class118.field1867[var22] = var10;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 - 1][var21] = 2;
                  class118.field1870[var20 - 1][var21] = var17;
               }

               if(var20 < 126 && class118.field1865[var20 + 1][var21] == 0 && (var25[var15 + 2][var16] & 19136899) == 0 && (var25[var15 + 2][var16 + 1] & 19136992) == 0) {
                  class118.field1869[var22] = var9 + 1;
                  class118.field1867[var22] = var10;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 + 1][var21] = 8;
                  class118.field1870[var20 + 1][var21] = var17;
               }

               if(var21 > 0 && class118.field1865[var20][var21 - 1] == 0 && (var25[var15][var16 - 1] & 19136782) == 0 && (var25[var15 + 1][var16 - 1] & 19136899) == 0) {
                  class118.field1869[var22] = var9;
                  class118.field1867[var22] = var10 - 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20][var21 - 1] = 1;
                  class118.field1870[var20][var21 - 1] = var17;
               }

               if(var21 < 126 && class118.field1865[var20][var21 + 1] == 0 && (var25[var15][var16 + 2] & 19136824) == 0 && (var25[var15 + 1][var16 + 2] & 19136992) == 0) {
                  class118.field1869[var22] = var9;
                  class118.field1867[var22] = var10 + 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20][var21 + 1] = 4;
                  class118.field1870[var20][var21 + 1] = var17;
               }

               if(var20 > 0 && var21 > 0 && class118.field1865[var20 - 1][var21 - 1] == 0 && (var25[var15 - 1][var16] & 19136830) == 0 && (var25[var15 - 1][var16 - 1] & 19136782) == 0 && (var25[var15][var16 - 1] & 19136911) == 0) {
                  class118.field1869[var22] = var9 - 1;
                  class118.field1867[var22] = var10 - 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 - 1][var21 - 1] = 3;
                  class118.field1870[var20 - 1][var21 - 1] = var17;
               }

               if(var20 < 126 && var21 > 0 && class118.field1865[var20 + 1][var21 - 1] == 0 && (var25[var15 + 1][var16 - 1] & 19136911) == 0 && (var25[var15 + 2][var16 - 1] & 19136899) == 0 && (var25[var15 + 2][var16] & 19136995) == 0) {
                  class118.field1869[var22] = var9 + 1;
                  class118.field1867[var22] = var10 - 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 + 1][var21 - 1] = 9;
                  class118.field1870[var20 + 1][var21 - 1] = var17;
               }

               if(var20 > 0 && var21 < 126 && class118.field1865[var20 - 1][var21 + 1] == 0 && (var25[var15 - 1][var16 + 1] & 19136830) == 0 && (var25[var15 - 1][var16 + 2] & 19136824) == 0 && (var25[var15][var16 + 2] & 19137016) == 0) {
                  class118.field1869[var22] = var9 - 1;
                  class118.field1867[var22] = var10 + 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 - 1][var21 + 1] = 6;
                  class118.field1870[var20 - 1][var21 + 1] = var17;
               }

               if(var20 < 126 && var21 < 126 && class118.field1865[var20 + 1][var21 + 1] == 0 && (var25[var15 + 1][var16 + 2] & 19137016) == 0 && (var25[var15 + 2][var16 + 2] & 19136992) == 0 && (var25[var15 + 2][var16 + 1] & 19136995) == 0) {
                  class118.field1869[var22] = var9 + 1;
                  class118.field1867[var22] = var10 + 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 + 1][var21 + 1] = 12;
                  class118.field1870[var20 + 1][var21 + 1] = var17;
               }
            }

            var19 = var26;
         } else {
            var9 = var0;
            var10 = var1;
            var23 = 64;
            var11 = 64;
            var12 = var0 - var23;
            var13 = var1 - var11;
            class118.field1865[var23][var11] = 99;
            class118.field1870[var23][var11] = 0;
            var24 = 0;
            var14 = 0;
            class118.field1869[var24] = var0;
            var22 = var24 + 1;
            class118.field1867[var24] = var1;
            var25 = var4.flags;

            label465:
            while(true) {
               label463:
               while(true) {
                  do {
                     do {
                        do {
                           label440:
                           do {
                              if(var14 == var22) {
                                 class118.field1866 = var9;
                                 class118.field1863 = var10;
                                 var26 = false;
                                 break label465;
                              }

                              var9 = class118.field1869[var14];
                              var10 = class118.field1867[var14];
                              var14 = var14 + 1 & 4095;
                              var20 = var9 - var12;
                              var21 = var10 - var13;
                              var15 = var9 - var4.x;
                              var16 = var10 - var4.y;
                              if(var3.vmethod2355(var2, var9, var10, var4)) {
                                 class118.field1866 = var9;
                                 class118.field1863 = var10;
                                 var26 = true;
                                 break label465;
                              }

                              var17 = class118.field1870[var20][var21] + 1;
                              if(var20 > 0 && class118.field1865[var20 - 1][var21] == 0 && (var25[var15 - 1][var16] & 19136782) == 0 && (var25[var15 - 1][var2 + var16 - 1] & 19136824) == 0) {
                                 var18 = 1;

                                 while(true) {
                                    if(var18 >= var2 - 1) {
                                       class118.field1869[var22] = var9 - 1;
                                       class118.field1867[var22] = var10;
                                       var22 = var22 + 1 & 4095;
                                       class118.field1865[var20 - 1][var21] = 2;
                                       class118.field1870[var20 - 1][var21] = var17;
                                       break;
                                    }

                                    if((var25[var15 - 1][var16 + var18] & 19136830) != 0) {
                                       break;
                                    }

                                    ++var18;
                                 }
                              }

                              if(var20 < 128 - var2 && class118.field1865[var20 + 1][var21] == 0 && (var25[var2 + var15][var16] & 19136899) == 0 && (var25[var15 + var2][var2 + var16 - 1] & 19136992) == 0) {
                                 var18 = 1;

                                 while(true) {
                                    if(var18 >= var2 - 1) {
                                       class118.field1869[var22] = var9 + 1;
                                       class118.field1867[var22] = var10;
                                       var22 = var22 + 1 & 4095;
                                       class118.field1865[var20 + 1][var21] = 8;
                                       class118.field1870[var20 + 1][var21] = var17;
                                       break;
                                    }

                                    if((var25[var2 + var15][var18 + var16] & 19136995) != 0) {
                                       break;
                                    }

                                    ++var18;
                                 }
                              }

                              if(var21 > 0 && class118.field1865[var20][var21 - 1] == 0 && (var25[var15][var16 - 1] & 19136782) == 0 && (var25[var15 + var2 - 1][var16 - 1] & 19136899) == 0) {
                                 var18 = 1;

                                 while(true) {
                                    if(var18 >= var2 - 1) {
                                       class118.field1869[var22] = var9;
                                       class118.field1867[var22] = var10 - 1;
                                       var22 = var22 + 1 & 4095;
                                       class118.field1865[var20][var21 - 1] = 1;
                                       class118.field1870[var20][var21 - 1] = var17;
                                       break;
                                    }

                                    if((var25[var18 + var15][var16 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var18;
                                 }
                              }

                              if(var21 < 128 - var2 && class118.field1865[var20][var21 + 1] == 0 && (var25[var15][var16 + var2] & 19136824) == 0 && (var25[var15 + var2 - 1][var16 + var2] & 19136992) == 0) {
                                 var18 = 1;

                                 while(true) {
                                    if(var18 >= var2 - 1) {
                                       class118.field1869[var22] = var9;
                                       class118.field1867[var22] = var10 + 1;
                                       var22 = var22 + 1 & 4095;
                                       class118.field1865[var20][var21 + 1] = 4;
                                       class118.field1870[var20][var21 + 1] = var17;
                                       break;
                                    }

                                    if((var25[var18 + var15][var2 + var16] & 19137016) != 0) {
                                       break;
                                    }

                                    ++var18;
                                 }
                              }

                              if(var20 > 0 && var21 > 0 && class118.field1865[var20 - 1][var21 - 1] == 0 && (var25[var15 - 1][var16 - 1] & 19136782) == 0) {
                                 var18 = 1;

                                 while(true) {
                                    if(var18 >= var2) {
                                       class118.field1869[var22] = var9 - 1;
                                       class118.field1867[var22] = var10 - 1;
                                       var22 = var22 + 1 & 4095;
                                       class118.field1865[var20 - 1][var21 - 1] = 3;
                                       class118.field1870[var20 - 1][var21 - 1] = var17;
                                       break;
                                    }

                                    if((var25[var15 - 1][var16 - 1 + var18] & 19136830) != 0 || (var25[var15 - 1 + var18][var16 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var18;
                                 }
                              }

                              if(var20 < 128 - var2 && var21 > 0 && class118.field1865[var20 + 1][var21 - 1] == 0 && (var25[var15 + var2][var16 - 1] & 19136899) == 0) {
                                 var18 = 1;

                                 while(true) {
                                    if(var18 >= var2) {
                                       class118.field1869[var22] = var9 + 1;
                                       class118.field1867[var22] = var10 - 1;
                                       var22 = var22 + 1 & 4095;
                                       class118.field1865[var20 + 1][var21 - 1] = 9;
                                       class118.field1870[var20 + 1][var21 - 1] = var17;
                                       break;
                                    }

                                    if((var25[var15 + var2][var16 - 1 + var18] & 19136995) != 0 || (var25[var15 + var18][var16 - 1] & 19136911) != 0) {
                                       break;
                                    }

                                    ++var18;
                                 }
                              }

                              if(var20 > 0 && var21 < 128 - var2 && class118.field1865[var20 - 1][var21 + 1] == 0 && (var25[var15 - 1][var2 + var16] & 19136824) == 0) {
                                 for(var18 = 1; var18 < var2; ++var18) {
                                    if((var25[var15 - 1][var18 + var16] & 19136830) != 0 || (var25[var15 - 1 + var18][var2 + var16] & 19137016) != 0) {
                                       continue label440;
                                    }
                                 }

                                 class118.field1869[var22] = var9 - 1;
                                 class118.field1867[var22] = var10 + 1;
                                 var22 = var22 + 1 & 4095;
                                 class118.field1865[var20 - 1][var21 + 1] = 6;
                                 class118.field1870[var20 - 1][var21 + 1] = var17;
                              }
                           } while(var20 >= 128 - var2);
                        } while(var21 >= 128 - var2);
                     } while(class118.field1865[var20 + 1][var21 + 1] != 0);
                  } while((var25[var15 + var2][var16 + var2] & 19136992) != 0);

                  for(var18 = 1; var18 < var2; ++var18) {
                     if((var25[var18 + var15][var16 + var2] & 19137016) != 0 || (var25[var2 + var15][var18 + var16] & 19136995) != 0) {
                        continue label463;
                     }
                  }

                  class118.field1869[var22] = var9 + 1;
                  class118.field1867[var22] = var10 + 1;
                  var22 = var22 + 1 & 4095;
                  class118.field1865[var20 + 1][var21 + 1] = 12;
                  class118.field1870[var20 + 1][var21 + 1] = var17;
               }
            }

            var19 = var26;
         }
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class118.field1866;
      var20 = class118.field1863;
      if(!var19) {
         var21 = Integer.MAX_VALUE;
         var12 = Integer.MAX_VALUE;
         var23 = 10;
         var22 = var3.field1874;
         var14 = var3.field1882;
         int var29 = var3.field1876;
         var15 = var3.field1875;

         for(var16 = var22 - var23; var16 <= var22 + var23; ++var16) {
            for(var17 = var14 - var23; var17 <= var23 + var14; ++var17) {
               var18 = var16 - var8;
               int var30 = var17 - var9;
               if(var18 >= 0 && var30 >= 0 && var18 < 128 && var30 < 128 && class118.field1870[var18][var30] < 100) {
                  int var31 = 0;
                  if(var16 < var22) {
                     var31 = var22 - var16;
                  } else if(var16 > var22 + var29 - 1) {
                     var31 = var16 - (var22 + var29 - 1);
                  }

                  int var27 = 0;
                  if(var17 < var14) {
                     var27 = var14 - var17;
                  } else if(var17 > var15 + var14 - 1) {
                     var27 = var17 - (var15 + var14 - 1);
                  }

                  int var28 = var31 * var31 + var27 * var27;
                  if(var28 < var21 || var21 == var28 && class118.field1870[var18][var30] < var12) {
                     var21 = var28;
                     var12 = class118.field1870[var18][var30];
                     var10 = var16;
                     var20 = var17;
                  }
               }
            }
         }

         if(var21 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var10 == var0 && var20 == var1) {
         return 0;
      } else {
         var11 = 0;
         class118.field1869[var11] = var10;
         var21 = var11 + 1;
         class118.field1867[var11] = var20;

         for(var12 = var13 = class118.field1865[var10 - var8][var20 - var9]; var0 != var10 || var20 != var1; var12 = class118.field1865[var10 - var8][var20 - var9]) {
            if(var13 != var12) {
               var13 = var12;
               class118.field1869[var21] = var10;
               class118.field1867[var21++] = var20;
            }

            if((var12 & 2) != 0) {
               ++var10;
            } else if((var12 & 8) != 0) {
               --var10;
            }

            if((var12 & 1) != 0) {
               ++var20;
            } else if((var12 & 4) != 0) {
               --var20;
            }
         }

         var22 = 0;

         while(var21-- > 0) {
            var6[var22] = class118.field1869[var21];
            var7[var22++] = class118.field1867[var21];
            if(var22 >= var6.length) {
               break;
            }
         }

         return var22;
      }
   }
}

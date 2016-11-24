import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class194 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -643141399
   )
   public int field2848;
   @ObfuscatedName("d")
   static NodeCache field2849 = new NodeCache(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1056428101
   )
   public int field2850;
   @ObfuscatedName("n")
   static class182 field2851;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1743261779
   )
   public int field2852;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "8347894"
   )
   void method3589(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.method3590(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1470946782"
   )
   void method3590(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2850 = var1.method3097();
         this.field2848 = var1.method3033();
         this.field2852 = var1.method3033();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[II)I",
      garbageValue = "-2147483648"
   )
   public static int method3591(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1839[var8][var9] = 0;
            class118.field1842[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1839[var12][var13] = 99;
         class118.field1842[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1840[var16] = var0;
         var33 = var16 + 1;
         class118.field1843[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class112.field1767 = var10;
               class118.field1837 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1840[var17];
            var11 = class118.field1843[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2346(1, var10, var11, var4)) {
               class112.field1767 = var10;
               class118.field1837 = var11;
               var29 = true;
               break;
            }

            var21 = class118.field1842[var30][var31] + 1;
            if(var30 > 0 && class118.field1839[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class118.field1840[var33] = var10 - 1;
               class118.field1843[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30 - 1][var31] = 2;
               class118.field1842[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class118.field1839[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class118.field1840[var33] = var10 + 1;
               class118.field1843[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30 + 1][var31] = 8;
               class118.field1842[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class118.field1839[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1840[var33] = var10;
               class118.field1843[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30][var31 - 1] = 1;
               class118.field1842[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class118.field1839[var30][1 + var31] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1840[var33] = var10;
               class118.field1843[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30][1 + var31] = 4;
               class118.field1842[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1839[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1840[var33] = var10 - 1;
               class118.field1843[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30 - 1][var31 - 1] = 3;
               class118.field1842[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class118.field1839[1 + var30][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1840[var33] = var10 + 1;
               class118.field1843[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[1 + var30][var31 - 1] = 9;
               class118.field1842[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class118.field1839[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class118.field1840[var33] = var10 - 1;
               class118.field1843[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30 - 1][var31 + 1] = 6;
               class118.field1842[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class118.field1839[var30 + 1][var31 + 1] == 0 && (var18[1 + var19][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class118.field1840[var33] = 1 + var10;
               class118.field1843[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1839[1 + var30][var31 + 1] = 12;
               class118.field1842[var30 + 1][1 + var31] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1839[var12][var13] = 99;
         class118.field1842[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1840[var16] = var0;
         var33 = var16 + 1;
         class118.field1843[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class112.field1767 = var10;
               class118.field1837 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1840[var17];
            var11 = class118.field1843[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2346(2, var10, var11, var4)) {
               class112.field1767 = var10;
               class118.field1837 = var11;
               var29 = true;
               break;
            }

            var21 = class118.field1842[var30][var31] + 1;
            if(var30 > 0 && class118.field1839[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class118.field1840[var33] = var10 - 1;
               class118.field1843[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30 - 1][var31] = 2;
               class118.field1842[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class118.field1839[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[2 + var19][1 + var20] & 19136992) == 0) {
               class118.field1840[var33] = var10 + 1;
               class118.field1843[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30 + 1][var31] = 8;
               class118.field1842[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class118.field1839[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class118.field1840[var33] = var10;
               class118.field1843[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30][var31 - 1] = 1;
               class118.field1842[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class118.field1839[var30][1 + var31] == 0 && (var18[var19][2 + var20] & 19136824) == 0 && (var18[1 + var19][2 + var20] & 19136992) == 0) {
               class118.field1840[var33] = var10;
               class118.field1843[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30][var31 + 1] = 4;
               class118.field1842[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1839[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class118.field1840[var33] = var10 - 1;
               class118.field1843[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30 - 1][var31 - 1] = 3;
               class118.field1842[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class118.field1839[1 + var30][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
               class118.field1840[var33] = var10 + 1;
               class118.field1843[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30 + 1][var31 - 1] = 9;
               class118.field1842[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class118.field1839[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class118.field1840[var33] = var10 - 1;
               class118.field1843[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[var30 - 1][1 + var31] = 6;
               class118.field1842[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 126 && var31 < 126 && class118.field1839[1 + var30][1 + var31] == 0 && (var18[1 + var19][var20 + 2] & 19137016) == 0 && (var18[2 + var19][var20 + 2] & 19136992) == 0 && (var18[2 + var19][var20 + 1] & 19136995) == 0) {
               class118.field1840[var33] = 1 + var10;
               class118.field1843[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1839[1 + var30][var31 + 1] = 12;
               class118.field1842[1 + var30][var31 + 1] = var21;
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
         class118.field1839[var12][var13] = 99;
         class118.field1842[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1840[var16] = var0;
         var33 = var16 + 1;
         class118.field1843[var16] = var1;
         var18 = var4.flags;

         label884:
         while(true) {
            label882:
            while(true) {
               do {
                  do {
                     do {
                        label859:
                        do {
                           if(var17 == var33) {
                              class112.field1767 = var10;
                              class118.field1837 = var11;
                              var29 = false;
                              break label884;
                           }

                           var10 = class118.field1840[var17];
                           var11 = class118.field1843[var17];
                           var17 = 1 + var17 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod2346(var2, var10, var11, var4)) {
                              class112.field1767 = var10;
                              class118.field1837 = var11;
                              var29 = true;
                              break label884;
                           }

                           var21 = 1 + class118.field1842[var30][var31];
                           if(var30 > 0 && class118.field1839[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1840[var33] = var10 - 1;
                                    class118.field1843[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1839[var30 - 1][var31] = 2;
                                    class118.field1842[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class118.field1839[1 + var30][var31] == 0 && (var18[var2 + var19][var20] & 19136899) == 0 && (var18[var19 + var2][var2 + var20 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1840[var33] = var10 + 1;
                                    class118.field1843[var33] = var11;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1839[var30 + 1][var31] = 8;
                                    class118.field1842[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class118.field1839[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1840[var33] = var10;
                                    class118.field1843[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1839[var30][var31 - 1] = 1;
                                    class118.field1842[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class118.field1839[var30][var31 + 1] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var19 + var2 - 1][var2 + var20] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1840[var33] = var10;
                                    class118.field1843[var33] = 1 + var11;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1839[var30][var31 + 1] = 4;
                                    class118.field1842[var30][1 + var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var2 + var20] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class118.field1839[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1840[var33] = var10 - 1;
                                    class118.field1843[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1839[var30 - 1][var31 - 1] = 3;
                                    class118.field1842[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 - 1 + var22] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class118.field1839[var30 + 1][var31 - 1] == 0 && (var18[var2 + var19][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1840[var33] = 1 + var10;
                                    class118.field1843[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1839[1 + var30][var31 - 1] = 9;
                                    class118.field1842[1 + var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 - 1 + var22] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class118.field1839[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label859;
                                 }
                              }

                              class118.field1840[var33] = var10 - 1;
                              class118.field1843[var33] = var11 + 1;
                              var33 = 1 + var33 & 4095;
                              class118.field1839[var30 - 1][1 + var31] = 6;
                              class118.field1842[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class118.field1839[1 + var30][var31 + 1] != 0);
               } while((var18[var19 + var2][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var20 + var2] & 19137016) != 0 || (var18[var2 + var19][var22 + var20] & 19136995) != 0) {
                     continue label882;
                  }
               }

               class118.field1840[var33] = 1 + var10;
               class118.field1843[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1839[var30 + 1][1 + var31] = 12;
               class118.field1842[var30 + 1][1 + var31] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class112.field1767;
      var30 = class118.field1837;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1856;
         var17 = var3.field1849;
         int var27 = var3.field1851;
         var19 = var3.field1850;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1842[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class118.field1842[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1842[var22][var23];
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

      if(var0 == var11 && var1 == var30) {
         return 0;
      } else {
         var13 = 0;
         class118.field1840[var13] = var11;
         var31 = var13 + 1;
         class118.field1843[var13] = var30;

         for(var14 = var15 = class118.field1839[var11 - var9][var30 - var10]; var0 != var11 || var1 != var30; var14 = class118.field1839[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class118.field1840[var31] = var11;
               class118.field1843[var31++] = var30;
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
            var6[var33] = class118.field1840[var31];
            var7[var33++] = class118.field1843[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "162308422"
   )
   static final void method3601(int var0, int var1) {
      if(var0 != class40.field807 || FrameMap.field1464 != var1) {
         class40.field807 = var0;
         FrameMap.field1464 = var1;
         class186.setGameState(25);
         World.method669("Loading - please wait.", true);
         int var2 = class16.baseX;
         int var3 = Client.baseY;
         class16.baseX = (var0 - 6) * 8;
         Client.baseY = (var1 - 6) * 8;
         int var4 = class16.baseX - var2;
         int var5 = Client.baseY - var3;
         var2 = class16.baseX;
         var3 = Client.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var17 = Client.cachedNPCs[var6];
            if(var17 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var17.pathX[var8] -= var4;
                  var17.pathY[var8] -= var5;
               }

               var17.x -= 128 * var4;
               var17.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var21 = Client.cachedPlayers[var6];
            if(var21 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var21.pathX[var8] -= var4;
                  var21.pathY[var8] -= var5;
               }

               var21.x -= 128 * var4;
               var21.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var7 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var19 = 103;
            var7 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var18 = var19; var7 != var18; var18 += var20) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var18;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var18][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var18][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field419.method2466(); var12 != null; var12 = (class25)Client.field419.method2461()) {
            var12.field578 -= var4;
            var12.field574 -= var5;
            if(var12.field578 < 0 || var12.field574 < 0 || var12.field578 >= 104 || var12.field574 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field527 = 0;
         Client.field533 = false;
         Client.field514 = -1;
         Client.field421.method2453();
         Client.projectiles.method2453();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2302();
         }

      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;
   @ObfuscatedName("ad")
   protected static String field254;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -985483317
   )
   static int field253;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILfh;Lfq;Z[I[IB)I",
      garbageValue = "33"
   )
   public static int method51(int var0, int var1, int var2, class177 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class176.field2241[var8][var9] = 0;
            class176.field2246[var8][var9] = 99999999;
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
         class176.field2241[var12][var13] = 99;
         class176.field2246[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class176.field2244[var16] = var0;
         var33 = var16 + 1;
         class176.field2245[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class151.field2085 = var10;
               class176.field2243 = var11;
               var29 = false;
               break;
            }

            var10 = class176.field2244[var17];
            var11 = class176.field2245[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3428(1, var10, var11, var4)) {
               class151.field2085 = var10;
               class176.field2243 = var11;
               var29 = true;
               break;
            }

            var21 = class176.field2246[var30][var31] + 1;
            if(var30 > 0 && class176.field2241[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class176.field2244[var33] = var10 - 1;
               class176.field2245[var33] = var11;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 - 1][var31] = 2;
               class176.field2246[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class176.field2241[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31] = 8;
               class176.field2246[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class176.field2241[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class176.field2244[var33] = var10;
               class176.field2245[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30][var31 - 1] = 1;
               class176.field2246[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class176.field2241[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class176.field2244[var33] = var10;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30][var31 + 1] = 4;
               class176.field2246[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class176.field2241[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class176.field2244[var33] = var10 - 1;
               class176.field2245[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 - 1][var31 - 1] = 3;
               class176.field2246[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class176.field2241[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31 - 1] = 9;
               class176.field2246[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class176.field2241[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class176.field2244[var33] = var10 - 1;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 - 1][var31 + 1] = 6;
               class176.field2246[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class176.field2241[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31 + 1] = 12;
               class176.field2246[var30 + 1][var31 + 1] = var21;
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
         class176.field2241[var12][var13] = 99;
         class176.field2246[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class176.field2244[var16] = var0;
         var33 = var16 + 1;
         class176.field2245[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class151.field2085 = var10;
               class176.field2243 = var11;
               var29 = false;
               break;
            }

            var10 = class176.field2244[var17];
            var11 = class176.field2245[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3428(2, var10, var11, var4)) {
               class151.field2085 = var10;
               class176.field2243 = var11;
               var29 = true;
               break;
            }

            var21 = class176.field2246[var30][var31] + 1;
            if(var30 > 0 && class176.field2241[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0) {
               class176.field2244[var33] = var10 - 1;
               class176.field2245[var33] = var11;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 - 1][var31] = 2;
               class176.field2246[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class176.field2241[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31] = 8;
               class176.field2246[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class176.field2241[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class176.field2244[var33] = var10;
               class176.field2245[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30][var31 - 1] = 1;
               class176.field2246[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class176.field2241[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
               class176.field2244[var33] = var10;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30][var31 + 1] = 4;
               class176.field2246[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class176.field2241[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class176.field2244[var33] = var10 - 1;
               class176.field2245[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 - 1][var31 - 1] = 3;
               class176.field2246[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class176.field2241[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[var19 + 2][var20] & 19136995) == 0) {
               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31 - 1] = 9;
               class176.field2246[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class176.field2241[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class176.field2244[var33] = var10 - 1;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 - 1][var31 + 1] = 6;
               class176.field2246[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class176.field2241[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 2] & 19137016) == 0 && (var18[var19 + 2][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31 + 1] = 12;
               class176.field2246[var30 + 1][var31 + 1] = var21;
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
         class176.field2241[var12][var13] = 99;
         class176.field2246[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class176.field2244[var16] = var0;
         var33 = var16 + 1;
         class176.field2245[var16] = var1;
         var18 = var4.flags;

         label850:
         while(true) {
            label848:
            while(true) {
               do {
                  do {
                     do {
                        label825:
                        do {
                           if(var17 == var33) {
                              class151.field2085 = var10;
                              class176.field2243 = var11;
                              var29 = false;
                              break label850;
                           }

                           var10 = class176.field2244[var17];
                           var11 = class176.field2245[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod3428(var2, var10, var11, var4)) {
                              class151.field2085 = var10;
                              class176.field2243 = var11;
                              var29 = true;
                              break label850;
                           }

                           var21 = class176.field2246[var30][var31] + 1;
                           if(var30 > 0 && class176.field2241[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class176.field2244[var33] = var10 - 1;
                                    class176.field2245[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class176.field2241[var30 - 1][var31] = 2;
                                    class176.field2246[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class176.field2241[var30 + 1][var31] == 0 && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class176.field2244[var33] = var10 + 1;
                                    class176.field2245[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class176.field2241[var30 + 1][var31] = 8;
                                    class176.field2246[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class176.field2241[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class176.field2244[var33] = var10;
                                    class176.field2245[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class176.field2241[var30][var31 - 1] = 1;
                                    class176.field2246[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class176.field2241[var30][var31 + 1] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var19 + var2 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class176.field2244[var33] = var10;
                                    class176.field2245[var33] = var11 + 1;
                                    var33 = var33 + 1 & 4095;
                                    class176.field2241[var30][var31 + 1] = 4;
                                    class176.field2246[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var20 + var2] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class176.field2241[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class176.field2244[var33] = var10 - 1;
                                    class176.field2245[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class176.field2241[var30 - 1][var31 - 1] = 3;
                                    class176.field2246[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class176.field2241[var30 + 1][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class176.field2244[var33] = var10 + 1;
                                    class176.field2245[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class176.field2241[var30 + 1][var31 - 1] = 9;
                                    class176.field2246[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var22 + (var20 - 1)] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class176.field2241[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label825;
                                 }
                              }

                              class176.field2244[var33] = var10 - 1;
                              class176.field2245[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class176.field2241[var30 - 1][var31 + 1] = 6;
                              class176.field2246[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class176.field2241[var30 + 1][var31 + 1] != 0);
               } while((var18[var19 + var2][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var20 + var2] & 19137016) != 0 || (var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                     continue label848;
                  }
               }

               class176.field2244[var33] = var10 + 1;
               class176.field2245[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class176.field2241[var30 + 1][var31 + 1] = 12;
               class176.field2246[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class151.field2085;
      var30 = class176.field2243;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2250;
         var17 = var3.field2249;
         int var27 = var3.field2252;
         var19 = var3.field2248;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class176.field2246[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class176.field2246[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class176.field2246[var22][var23];
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

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class176.field2244[var13] = var11;
         var31 = var13 + 1;
         class176.field2245[var13] = var30;

         for(var14 = var15 = class176.field2241[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class176.field2241[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class176.field2244[var31] = var11;
               class176.field2245[var31++] = var30;
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
            var6[var33] = class176.field2244[var31];
            var7[var33++] = class176.field2245[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-174907867"
   )
   public static char method50(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "60"
   )
   static int method54(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([Lbs;II[I[II)V",
      garbageValue = "-65007264"
   )
   static void method52(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1643()?1:0;
                     var12 = var8.method1643()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1643()?1:0;
                     var12 = var8.method1643()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method52(var0, var1, var6, var3, var4);
         method52(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "181443640"
   )
   static int method53(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class80.intStackSize -= 3;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         int var5 = class80.intStack[class80.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = NetWriter.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class223.field2643 = var12;
               } else {
                  class80.field1228 = var12;
               }

               ScriptEvent.method1132(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class223.field2643:class80.field1228;
            Widget var10 = NetWriter.getWidget(var9.id);
            var10.children[var9.index] = null;
            ScriptEvent.method1132(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
            var9.children = null;
            ScriptEvent.method1132(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
               if(var9 != null) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
                  if(var2) {
                     class223.field2643 = var9;
                  } else {
                     class80.field1228 = var9;
                  }
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            Widget var11 = class201.getWidgetChild(var3, var4);
            if(var11 != null && var4 != -1) {
               class80.intStack[++class80.intStackSize - 1] = 1;
               if(var2) {
                  class223.field2643 = var11;
               } else {
                  class80.field1228 = var11;
               }
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}

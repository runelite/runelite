import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class107 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 775729575
   )
   public static int field1728;
   @ObfuscatedName("c")
   static File field1729;
   @ObfuscatedName("f")
   static Hashtable field1730 = new Hashtable(16);
   @ObfuscatedName("s")
   static boolean field1731 = false;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -960558949
   )
   static int field1734;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[II)I",
      garbageValue = "-161274847"
   )
   public static int method1981(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1844[var8][var9] = 0;
            class118.field1846[var8][var9] = 99999999;
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
         class118.field1844[var12][var13] = 99;
         class118.field1846[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1849[var16] = var0;
         var33 = var16 + 1;
         class118.field1850[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class118.field1845 = var10;
               class118.field1847 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1849[var17];
            var11 = class118.field1850[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2219(1, var10, var11, var4)) {
               class118.field1845 = var10;
               class118.field1847 = var11;
               var29 = true;
               break;
            }

            var21 = class118.field1846[var30][var31] + 1;
            if(var30 > 0 && class118.field1844[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class118.field1849[var33] = var10 - 1;
               class118.field1850[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1844[var30 - 1][var31] = 2;
               class118.field1846[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class118.field1844[var30 + 1][var31] == 0 && (var18[1 + var19][var20] & 19136896) == 0) {
               class118.field1849[var33] = 1 + var10;
               class118.field1850[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30 + 1][var31] = 8;
               class118.field1846[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class118.field1844[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1849[var33] = var10;
               class118.field1850[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30][var31 - 1] = 1;
               class118.field1846[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class118.field1844[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1849[var33] = var10;
               class118.field1850[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30][1 + var31] = 4;
               class118.field1846[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1844[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1849[var33] = var10 - 1;
               class118.field1850[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1844[var30 - 1][var31 - 1] = 3;
               class118.field1846[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class118.field1844[var30 + 1][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1849[var33] = var10 + 1;
               class118.field1850[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1844[1 + var30][var31 - 1] = 9;
               class118.field1846[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class118.field1844[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1849[var33] = var10 - 1;
               class118.field1850[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30 - 1][1 + var31] = 6;
               class118.field1846[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class118.field1844[1 + var30][1 + var31] == 0 && (var18[var19 + 1][1 + var20] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class118.field1849[var33] = 1 + var10;
               class118.field1850[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1844[1 + var30][1 + var31] = 12;
               class118.field1846[1 + var30][var31 + 1] = var21;
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
         class118.field1844[var12][var13] = 99;
         class118.field1846[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1849[var16] = var0;
         var33 = var16 + 1;
         class118.field1850[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class118.field1845 = var10;
               class118.field1847 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1849[var17];
            var11 = class118.field1850[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2219(2, var10, var11, var4)) {
               class118.field1845 = var10;
               class118.field1847 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class118.field1846[var30][var31];
            if(var30 > 0 && class118.field1844[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class118.field1849[var33] = var10 - 1;
               class118.field1850[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30 - 1][var31] = 2;
               class118.field1846[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class118.field1844[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class118.field1849[var33] = 1 + var10;
               class118.field1850[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1844[1 + var30][var31] = 8;
               class118.field1846[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class118.field1844[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0) {
               class118.field1849[var33] = var10;
               class118.field1850[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30][var31 - 1] = 1;
               class118.field1846[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class118.field1844[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][2 + var20] & 19136992) == 0) {
               class118.field1849[var33] = var10;
               class118.field1850[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1844[var30][var31 + 1] = 4;
               class118.field1846[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1844[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class118.field1849[var33] = var10 - 1;
               class118.field1850[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1844[var30 - 1][var31 - 1] = 3;
               class118.field1846[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class118.field1844[var30 + 1][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136911) == 0 && (var18[2 + var19][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
               class118.field1849[var33] = 1 + var10;
               class118.field1850[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1844[1 + var30][var31 - 1] = 9;
               class118.field1846[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class118.field1844[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class118.field1849[var33] = var10 - 1;
               class118.field1850[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1844[var30 - 1][var31 + 1] = 6;
               class118.field1846[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 126 && var31 < 126 && class118.field1844[var30 + 1][var31 + 1] == 0 && (var18[1 + var19][2 + var20] & 19137016) == 0 && (var18[2 + var19][var20 + 2] & 19136992) == 0 && (var18[2 + var19][1 + var20] & 19136995) == 0) {
               class118.field1849[var33] = 1 + var10;
               class118.field1850[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1844[1 + var30][1 + var31] = 12;
               class118.field1846[1 + var30][var31 + 1] = var21;
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
         class118.field1844[var12][var13] = 99;
         class118.field1846[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1849[var16] = var0;
         var33 = var16 + 1;
         class118.field1850[var16] = var1;
         var18 = var4.flags;

         label902:
         while(true) {
            label900:
            while(true) {
               do {
                  do {
                     do {
                        label877:
                        do {
                           if(var17 == var33) {
                              class118.field1845 = var10;
                              class118.field1847 = var11;
                              var29 = false;
                              break label902;
                           }

                           var10 = class118.field1849[var17];
                           var11 = class118.field1850[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod2219(var2, var10, var11, var4)) {
                              class118.field1845 = var10;
                              class118.field1847 = var11;
                              var29 = true;
                              break label902;
                           }

                           var21 = class118.field1846[var30][var31] + 1;
                           if(var30 > 0 && class118.field1844[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1849[var33] = var10 - 1;
                                    class118.field1850[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1844[var30 - 1][var31] = 2;
                                    class118.field1846[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class118.field1844[var30 + 1][var31] == 0 && (var18[var2 + var19][var20] & 19136899) == 0 && (var18[var2 + var19][var2 + var20 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1849[var33] = 1 + var10;
                                    class118.field1850[var33] = var11;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1844[var30 + 1][var31] = 8;
                                    class118.field1846[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class118.field1844[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1849[var33] = var10;
                                    class118.field1850[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1844[var30][var31 - 1] = 1;
                                    class118.field1846[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class118.field1844[var30][var31 + 1] == 0 && (var18[var19][var2 + var20] & 19136824) == 0 && (var18[var2 + var19 - 1][var2 + var20] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1849[var33] = var10;
                                    class118.field1850[var33] = var11 + 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1844[var30][1 + var31] = 4;
                                    class118.field1846[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var2 + var20] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class118.field1844[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1849[var33] = var10 - 1;
                                    class118.field1850[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1844[var30 - 1][var31 - 1] = 3;
                                    class118.field1846[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class118.field1844[var30 + 1][var31 - 1] == 0 && (var18[var2 + var19][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1849[var33] = var10 + 1;
                                    class118.field1850[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1844[var30 + 1][var31 - 1] = 9;
                                    class118.field1846[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 - 1 + var22] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class118.field1844[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 + var2] & 19137016) != 0) {
                                    continue label877;
                                 }
                              }

                              class118.field1849[var33] = var10 - 1;
                              class118.field1850[var33] = var11 + 1;
                              var33 = 1 + var33 & 4095;
                              class118.field1844[var30 - 1][var31 + 1] = 6;
                              class118.field1846[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class118.field1844[var30 + 1][1 + var31] != 0);
               } while((var18[var2 + var19][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var22 + var19][var2 + var20] & 19137016) != 0 || (var18[var19 + var2][var22 + var20] & 19136995) != 0) {
                     continue label900;
                  }
               }

               class118.field1849[var33] = 1 + var10;
               class118.field1850[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1844[1 + var30][1 + var31] = 12;
               class118.field1846[1 + var30][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class118.field1845;
      var30 = class118.field1847;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1862;
         var17 = var3.field1864;
         int var27 = var3.field1857;
         var19 = var3.field1860;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1846[var22][var23] < 100) {
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
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var31 || var31 == var26 && class118.field1846[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1846[var22][var23];
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
         class118.field1849[var13] = var11;
         var31 = var13 + 1;
         class118.field1850[var13] = var30;

         for(var14 = var15 = class118.field1844[var11 - var9][var30 - var10]; var11 != var0 || var1 != var30; var14 = class118.field1844[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class118.field1849[var31] = var11;
               class118.field1850[var31++] = var30;
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
            var6[var33] = class118.field1849[var31];
            var7[var33++] = class118.field1850[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "385362330"
   )
   static final void method1985(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method1985(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2274((long)var3.id);
               if(null != var4) {
                  class9.method95(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && var3.field2316 != null) {
               var5 = new class18();
               var5.field204 = var3;
               var5.field205 = var3.field2316;
               CombatInfo1.method594(var5);
            }

            if(var1 == 1 && null != var3.field2317) {
               if(var3.index >= 0) {
                  Widget var6 = class108.method1988(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field204 = var3;
               var5.field205 = var3.field2317;
               CombatInfo1.method594(var5);
            }
         }
      }

   }
}

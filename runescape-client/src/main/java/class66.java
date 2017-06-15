import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class66 {
   @ObfuscatedName("t")
   static final class66 field798;
   @ObfuscatedName("cu")
   static IndexData field799;
   @ObfuscatedName("e")
   static final class66 field800;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1829203397
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("p")
   static final class66 field802;
   @ObfuscatedName("me")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("m")
   static final class66 field804;

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-481593356"
   )
   static void method1024() {
      Client.secretPacketBuffer1.putOpcode(144);
      Client.secretPacketBuffer1.putByte(class241.method4167());
      Client.secretPacketBuffer1.putShort(class10.canvasWidth);
      Client.secretPacketBuffer1.putShort(class1.canvasHeight);
   }

   static {
      field802 = new class66();
      field804 = new class66();
      field800 = new class66();
      field798 = new class66();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;Z[I[II)I",
      garbageValue = "1595736843"
   )
   public static int method1025(int var0, int var1, int var2, class163 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class162.field2314[var8][var9] = 0;
            class162.field2311[var8][var9] = 99999999;
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
         class162.field2314[var12][var13] = 99;
         class162.field2311[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2315[var16] = var0;
         var33 = var16 + 1;
         class162.field2316[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class164.field2331 = var10;
               class162.field2310 = var11;
               var29 = false;
               break;
            }

            var10 = class162.field2315[var17];
            var11 = class162.field2316[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2950(1, var10, var11, var4)) {
               class164.field2331 = var10;
               class162.field2310 = var11;
               var29 = true;
               break;
            }

            var21 = class162.field2311[var30][var31] + 1;
            if(var30 > 0 && class162.field2314[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class162.field2315[var33] = var10 - 1;
               class162.field2316[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 - 1][var31] = 2;
               class162.field2311[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class162.field2314[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class162.field2315[var33] = var10 + 1;
               class162.field2316[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 + 1][var31] = 8;
               class162.field2311[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class162.field2314[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2315[var33] = var10;
               class162.field2316[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30][var31 - 1] = 1;
               class162.field2311[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class162.field2314[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2315[var33] = var10;
               class162.field2316[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30][var31 + 1] = 4;
               class162.field2311[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class162.field2314[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2315[var33] = var10 - 1;
               class162.field2316[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 - 1][var31 - 1] = 3;
               class162.field2311[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class162.field2314[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2315[var33] = var10 + 1;
               class162.field2316[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 + 1][var31 - 1] = 9;
               class162.field2311[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class162.field2314[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2315[var33] = var10 - 1;
               class162.field2316[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 - 1][var31 + 1] = 6;
               class162.field2311[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class162.field2314[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2315[var33] = var10 + 1;
               class162.field2316[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 + 1][var31 + 1] = 12;
               class162.field2311[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = class1.method1(var0, var1, var3, var4);
      } else {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class162.field2314[var12][var13] = 99;
         class162.field2311[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2315[var16] = var0;
         var33 = var16 + 1;
         class162.field2316[var16] = var1;
         var18 = var4.flags;

         label642:
         while(true) {
            label640:
            while(true) {
               do {
                  do {
                     do {
                        label617:
                        do {
                           if(var33 == var17) {
                              class164.field2331 = var10;
                              class162.field2310 = var11;
                              var29 = false;
                              break label642;
                           }

                           var10 = class162.field2315[var17];
                           var11 = class162.field2316[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod2950(var2, var10, var11, var4)) {
                              class164.field2331 = var10;
                              class162.field2310 = var11;
                              var29 = true;
                              break label642;
                           }

                           var21 = class162.field2311[var30][var31] + 1;
                           if(var30 > 0 && class162.field2314[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2315[var33] = var10 - 1;
                                    class162.field2316[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2314[var30 - 1][var31] = 2;
                                    class162.field2311[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class162.field2314[var30 + 1][var31] == 0 && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2315[var33] = var10 + 1;
                                    class162.field2316[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2314[var30 + 1][var31] = 8;
                                    class162.field2311[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class162.field2314[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2315[var33] = var10;
                                    class162.field2316[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2314[var30][var31 - 1] = 1;
                                    class162.field2311[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class162.field2314[var30][var31 + 1] == 0 && (var18[var19][var2 + var20] & 19136824) == 0 && (var18[var2 + var19 - 1][var2 + var20] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class162.field2315[var33] = var10;
                                    class162.field2316[var33] = var11 + 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2314[var30][var31 + 1] = 4;
                                    class162.field2311[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var22][var2 + var20] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class162.field2314[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class162.field2315[var33] = var10 - 1;
                                    class162.field2316[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2314[var30 - 1][var31 - 1] = 3;
                                    class162.field2311[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class162.field2314[var30 + 1][var31 - 1] == 0 && (var18[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class162.field2315[var33] = var10 + 1;
                                    class162.field2316[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class162.field2314[var30 + 1][var31 - 1] = 9;
                                    class162.field2311[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var22 + (var20 - 1)] & 19136995) != 0 || (var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class162.field2314[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var19 - 1 + var22][var20 + var2] & 19137016) != 0) {
                                    continue label617;
                                 }
                              }

                              class162.field2315[var33] = var10 - 1;
                              class162.field2316[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class162.field2314[var30 - 1][var31 + 1] = 6;
                              class162.field2311[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class162.field2314[var30 + 1][var31 + 1] != 0);
               } while((var18[var19 + var2][var2 + var20] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var2 + var20] & 19137016) != 0 || (var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                     continue label640;
                  }
               }

               class162.field2315[var33] = var10 + 1;
               class162.field2316[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2314[var30 + 1][var31 + 1] = 12;
               class162.field2311[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class164.field2331;
      var30 = class162.field2310;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2320;
         var17 = var3.field2322;
         int var27 = var3.field2321;
         var19 = var3.field2323;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class162.field2311[var22][var23] < 100) {
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
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class162.field2311[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class162.field2311[var22][var23];
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

      if(var11 == var0 && var1 == var30) {
         return 0;
      } else {
         var13 = 0;
         class162.field2315[var13] = var11;
         var31 = var13 + 1;
         class162.field2316[var13] = var30;

         for(var14 = var15 = class162.field2314[var11 - var9][var30 - var10]; var11 != var0 || var1 != var30; var14 = class162.field2314[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class162.field2315[var31] = var11;
               class162.field2316[var31++] = var30;
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
            var6[var33] = class162.field2315[var31];
            var7[var33++] = class162.field2316[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1045441971"
   )
   static void method1026() {
      for(class82 var0 = (class82)class82.field1314.method3487(); var0 != null; var0 = (class82)class82.field1314.method3512()) {
         if(var0.field1313 != null) {
            WorldMapType1.field442.method1780(var0.field1313);
            var0.field1313 = null;
         }

         if(var0.field1318 != null) {
            WorldMapType1.field442.method1780(var0.field1318);
            var0.field1318 = null;
         }
      }

      class82.field1314.method3481();
   }
}

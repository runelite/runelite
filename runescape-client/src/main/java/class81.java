import java.util.LinkedHashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public final class class81 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   static Deque field1334;
   @ObfuscatedName("ax")
   static int[] field1341;
   @ObfuscatedName("x")
   static int[] field1340;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 24775669
   )
   int field1332;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   ObjectComposition field1339;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1952494165
   )
   int field1331;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1108568017
   )
   int field1342;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1458095
   )
   int field1330;
   @ObfuscatedName("t")
   int[] field1336;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class116 field1327;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1675337055
   )
   int field1335;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1334038403
   )
   int field1337;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 940658339
   )
   int field1333;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 670565641
   )
   int field1328;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1972278425
   )
   int field1326;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class116 field1338;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1816148679
   )
   int field1325;

   static {
      field1334 = new Deque();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1765185797"
   )
   void method1609() {
      int var1 = this.field1332;
      ObjectComposition var2 = this.field1339.getImpostor();
      if(var2 != null) {
         this.field1332 = var2.ambientSoundId;
         this.field1331 = var2.field3479 * 128;
         this.field1342 = var2.field3480;
         this.field1330 = var2.field3461;
         this.field1336 = var2.field3482;
      } else {
         this.field1332 = -1;
         this.field1331 = 0;
         this.field1342 = 0;
         this.field1330 = 0;
         this.field1336 = null;
      }

      if(var1 != this.field1332 && this.field1327 != null) {
         class33.field479.method1880(this.field1327);
         this.field1327 = null;
      }

   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-49"
   )
   static final void method1615(boolean var0) {
      if(var0) {
         Client.field1135 = class91.field1447?class150.field2213:class150.field2207;
      } else {
         LinkedHashMap var1 = Buffer.preferences.preferences;
         String var3 = class91.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field1135 = var1.containsKey(Integer.valueOf(var5))?class150.field2210:class150.field2206;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILfk;Lfh;Z[I[II)I",
      garbageValue = "1287569473"
   )
   public static int method1611(int var0, int var1, int var2, class164 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class163.field2307[var8][var9] = 0;
            class163.field2310[var8][var9] = 99999999;
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
         var28 = class47.method742(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var28 = class20.method177(var0, var1, var3, var4);
      } else {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class163.field2307[var12][var13] = 99;
         class163.field2310[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class163.field2306[var16] = var0;
         var33 = var16 + 1;
         class163.field2312[var16] = var1;
         int[][] var27 = var4.flags;

         boolean var29;
         label465:
         while(true) {
            label463:
            while(true) {
               do {
                  do {
                     do {
                        label440:
                        do {
                           if(var17 == var33) {
                              class89.field1418 = var10;
                              class51.field671 = var11;
                              var29 = false;
                              break label465;
                           }

                           var10 = class163.field2306[var17];
                           var11 = class163.field2312[var17];
                           var17 = var17 + 1 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod3145(var2, var10, var11, var4)) {
                              class89.field1418 = var10;
                              class51.field671 = var11;
                              var29 = true;
                              break label465;
                           }

                           var21 = class163.field2310[var30][var31] + 1;
                           if(var30 > 0 && class163.field2307[var30 - 1][var31] == 0 && (var27[var19 - 1][var20] & 19136782) == 0 && (var27[var19 - 1][var20 + var2 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2306[var33] = var10 - 1;
                                    class163.field2312[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2307[var30 - 1][var31] = 2;
                                    class163.field2310[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if(0 != (var27[var19 - 1][var22 + var20] & 19136830)) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class163.field2307[var30 + 1][var31] == 0 && (var27[var19 + var2][var20] & 19136899) == 0 && (var27[var19 + var2][var20 + var2 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2306[var33] = var10 + 1;
                                    class163.field2312[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2307[var30 + 1][var31] = 8;
                                    class163.field2310[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var27[var19 + var2][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class163.field2307[var30][var31 - 1] == 0 && (var27[var19][var20 - 1] & 19136782) == 0 && (var27[var19 + var2 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2306[var33] = var10;
                                    class163.field2312[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2307[var30][var31 - 1] = 1;
                                    class163.field2310[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if(0 != (var27[var19 + var22][var20 - 1] & 19136911)) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class163.field2307[var30][var31 + 1] == 0 && (var27[var19][var20 + var2] & 19136824) == 0 && (var27[var19 + var2 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class163.field2306[var33] = var10;
                                    class163.field2312[var33] = var11 + 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2307[var30][var31 + 1] = 4;
                                    class163.field2310[var30][var31 + 1] = var21;
                                    break;
                                 }

                                 if((var27[var19 + var22][var20 + var2] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class163.field2307[var30 - 1][var31 - 1] == 0 && (var27[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class163.field2306[var33] = var10 - 1;
                                    class163.field2312[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2307[var30 - 1][var31 - 1] = 3;
                                    class163.field2310[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var27[var19 - 1][var22 + (var20 - 1)] & 19136830) != 0 || (var27[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && 0 == class163.field2307[var30 + 1][var31 - 1] && (var27[var19 + var2][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class163.field2306[var33] = var10 + 1;
                                    class163.field2312[var33] = var11 - 1;
                                    var33 = var33 + 1 & 4095;
                                    class163.field2307[var30 + 1][var31 - 1] = 9;
                                    class163.field2310[var30 + 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var27[var19 + var2][var22 + (var20 - 1)] & 19136995) != 0 || 0 != (var27[var22 + var19][var20 - 1] & 19136911)) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class163.field2307[var30 - 1][var31 + 1] == 0 && (var27[var19 - 1][var20 + var2] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var27[var19 - 1][var20 + var22] & 19136830) != 0 || (var27[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label440;
                                 }
                              }

                              class163.field2306[var33] = var10 - 1;
                              class163.field2312[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class163.field2307[var30 - 1][var31 + 1] = 6;
                              class163.field2310[var30 - 1][var31 + 1] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class163.field2307[var30 + 1][var31 + 1] != 0);
               } while((var27[var19 + var2][var20 + var2] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if(0 != (var27[var19 + var22][var20 + var2] & 19137016) || (var27[var19 + var2][var20 + var22] & 19136995) != 0) {
                     continue label463;
                  }
               }

               class163.field2306[var33] = var10 + 1;
               class163.field2312[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class163.field2307[var30 + 1][var31 + 1] = 12;
               class163.field2310[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class89.field1418;
      var30 = class51.field671;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2314;
         var17 = var3.field2315;
         int var18 = var3.field2316;
         var19 = var3.field2317;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class163.field2310[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var18 + var33 - 1) {
                     var24 = var20 - (var33 + var18 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class163.field2310[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class163.field2310[var22][var23];
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
         class163.field2306[var13] = var11;
         var31 = var13 + 1;
         class163.field2312[var13] = var30;

         for(var14 = var15 = class163.field2307[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class163.field2307[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class163.field2306[var31] = var11;
               class163.field2312[var31++] = var30;
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
            var6[var33] = class163.field2306[var31];
            var7[var33++] = class163.field2312[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }
}

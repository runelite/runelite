package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ed")
public class class152 {
   @ObfuscatedName("f")
   static final class152 field2261 = new class152("RC", 1);
   @ObfuscatedName("m")
   static final class152 field2262 = new class152("BUILDLIVE", 3);
   @ObfuscatedName("u")
   public final String field2263;
   @ObfuscatedName("j")
   static final class152 field2264 = new class152("LIVE", 0);
   @ObfuscatedName("l")
   static final class152 field2265 = new class152("WIP", 2);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1859880991
   )
   public final int field2266;
   @ObfuscatedName("bu")
   static class167 field2268;

   class152(String var1, int var2) {
      this.field2263 = var1;
      this.field2266 = var2;
   }

   @ObfuscatedName("w")
   static boolean method3190(class166 var0, int var1) {
      byte[] var2 = var0.method3338(var1);
      if(null == var2) {
         return false;
      } else {
         class94.method2205(var2);
         return true;
      }
   }

   @ObfuscatedName("i")
   static final void method3192(byte[] var0, int var1, int var2, class85 var3, class107[] var4) {
      class118 var5 = new class118(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2548();
         if(0 == var7) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2548();
            if(0 == var9) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2536();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class5.field86[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               class107 var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class14.method193(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("m")
   public static int method3193(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("be")
   static final void method3194(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field809[0];
      int var5 = var0.field816[0];
      int var6 = var0.method15();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method15();
            client.field553.field1860 = var1;
            client.field553.field1858 = var2;
            client.field553.field1859 = 1;
            client.field553.field1865 = 1;
            class10 var9 = client.field553;
            class10 var10 = var9;
            class107 var11 = client.field335[var0.field56];
            int[] var12 = client.field430;
            int[] var13 = client.field555;

            int var14;
            int var15;
            for(var14 = 0; var14 < 128; ++var14) {
               for(var15 = 0; var15 < 128; ++var15) {
                  class105.field1842[var14][var15] = 0;
                  class105.field1843[var14][var15] = 99999999;
               }
            }

            int var16;
            int var17;
            byte var19;
            int var20;
            int var21;
            int var23;
            int var25;
            int var26;
            int var27;
            int var28;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var33 = class20.method595(var4, var5, var9, var11);
            } else if(2 == var8) {
               var33 = class77.method1712(var4, var5, var9, var11);
            } else {
               var16 = var4;
               var17 = var5;
               byte var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class105.field1842[var18][var19] = 99;
               class105.field1843[var18][var19] = 0;
               byte var22 = 0;
               var23 = 0;
               class105.field1845[var22] = var4;
               var38 = var22 + 1;
               class105.field1848[var22] = var5;
               int[][] var24 = var11.field1879;

               boolean var34;
               label578:
               while(true) {
                  label576:
                  while(true) {
                     do {
                        do {
                           do {
                              label553:
                              do {
                                 if(var23 == var38) {
                                    class105.field1844 = var16;
                                    class105.field1851 = var17;
                                    var34 = false;
                                    break label578;
                                 }

                                 var16 = class105.field1845[var23];
                                 var17 = class105.field1848[var23];
                                 var23 = 1 + var23 & 4095;
                                 var35 = var16 - var20;
                                 var36 = var17 - var21;
                                 var25 = var16 - var11.field1881;
                                 var26 = var17 - var11.field1883;
                                 if(var10.vmethod2416(var16, var17)) {
                                    class105.field1844 = var16;
                                    class105.field1851 = var17;
                                    var34 = true;
                                    break label578;
                                 }

                                 var27 = class105.field1843[var35][var36] + 1;
                                 if(var35 > 0 && class105.field1842[var35 - 1][var36] == 0 && 0 == (var24[var25 - 1][var26] & 19136782) && (var24[var25 - 1][var26 + var8 - 1] & 19136824) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class105.field1845[var38] = var16 - 1;
                                          class105.field1848[var38] = var17;
                                          var38 = 1 + var38 & 4095;
                                          class105.field1842[var35 - 1][var36] = 2;
                                          class105.field1843[var35 - 1][var36] = var27;
                                          break;
                                       }

                                       if((var24[var25 - 1][var26 + var28] & 19136830) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var35 < 128 - var8 && class105.field1842[var35 + 1][var36] == 0 && (var24[var25 + var8][var26] & 19136899) == 0 && 0 == (var24[var25 + var8][var8 + var26 - 1] & 19136992)) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class105.field1845[var38] = var16 + 1;
                                          class105.field1848[var38] = var17;
                                          var38 = 1 + var38 & 4095;
                                          class105.field1842[1 + var35][var36] = 8;
                                          class105.field1843[var35 + 1][var36] = var27;
                                          break;
                                       }

                                       if(0 != (var24[var25 + var8][var28 + var26] & 19136995)) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 > 0 && 0 == class105.field1842[var35][var36 - 1] && 0 == (var24[var25][var26 - 1] & 19136782) && (var24[var8 + var25 - 1][var26 - 1] & 19136899) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class105.field1845[var38] = var16;
                                          class105.field1848[var38] = var17 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class105.field1842[var35][var36 - 1] = 1;
                                          class105.field1843[var35][var36 - 1] = var27;
                                          break;
                                       }

                                       if((var24[var28 + var25][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var36 < 128 - var8 && 0 == class105.field1842[var35][1 + var36] && (var24[var25][var26 + var8] & 19136824) == 0 && 0 == (var24[var25 + var8 - 1][var8 + var26] & 19136992)) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8 - 1) {
                                          class105.field1845[var38] = var16;
                                          class105.field1848[var38] = 1 + var17;
                                          var38 = var38 + 1 & 4095;
                                          class105.field1842[var35][1 + var36] = 4;
                                          class105.field1843[var35][var36 + 1] = var27;
                                          break;
                                       }

                                       if((var24[var28 + var25][var8 + var26] & 19137016) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var35 > 0 && var36 > 0 && class105.field1842[var35 - 1][var36 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8) {
                                          class105.field1845[var38] = var16 - 1;
                                          class105.field1848[var38] = var17 - 1;
                                          var38 = 1 + var38 & 4095;
                                          class105.field1842[var35 - 1][var36 - 1] = 3;
                                          class105.field1843[var35 - 1][var36 - 1] = var27;
                                          break;
                                       }

                                       if(0 != (var24[var25 - 1][var28 + (var26 - 1)] & 19136830) || (var24[var28 + (var25 - 1)][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var35 < 128 - var8 && var36 > 0 && class105.field1842[1 + var35][var36 - 1] == 0 && (var24[var8 + var25][var26 - 1] & 19136899) == 0) {
                                    var28 = 1;

                                    while(true) {
                                       if(var28 >= var8) {
                                          class105.field1845[var38] = 1 + var16;
                                          class105.field1848[var38] = var17 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class105.field1842[var35 + 1][var36 - 1] = 9;
                                          class105.field1843[var35 + 1][var36 - 1] = var27;
                                          break;
                                       }

                                       if(0 != (var24[var25 + var8][var28 + (var26 - 1)] & 19136995) || (var24[var25 + var28][var26 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var28;
                                    }
                                 }

                                 if(var35 > 0 && var36 < 128 - var8 && 0 == class105.field1842[var35 - 1][1 + var36] && (var24[var25 - 1][var8 + var26] & 19136824) == 0) {
                                    for(var28 = 1; var28 < var8; ++var28) {
                                       if((var24[var25 - 1][var26 + var28] & 19136830) != 0 || 0 != (var24[var28 + (var25 - 1)][var26 + var8] & 19137016)) {
                                          continue label553;
                                       }
                                    }

                                    class105.field1845[var38] = var16 - 1;
                                    class105.field1848[var38] = 1 + var17;
                                    var38 = 1 + var38 & 4095;
                                    class105.field1842[var35 - 1][var36 + 1] = 6;
                                    class105.field1843[var35 - 1][var36 + 1] = var27;
                                 }
                              } while(var35 >= 128 - var8);
                           } while(var36 >= 128 - var8);
                        } while(0 != class105.field1842[1 + var35][1 + var36]);
                     } while((var24[var25 + var8][var8 + var26] & 19136992) != 0);

                     for(var28 = 1; var28 < var8; ++var28) {
                        if((var24[var25 + var28][var8 + var26] & 19137016) != 0 || 0 != (var24[var8 + var25][var28 + var26] & 19136995)) {
                           continue label576;
                        }
                     }

                     class105.field1845[var38] = 1 + var16;
                     class105.field1848[var38] = var17 + 1;
                     var38 = 1 + var38 & 4095;
                     class105.field1842[1 + var35][1 + var36] = 12;
                     class105.field1843[1 + var35][1 + var36] = var27;
                  }
               }

               var33 = var34;
            }

            int var7;
            label624: {
               var15 = var4 - 64;
               var16 = var5 - 64;
               var17 = class105.field1844;
               var35 = class105.field1851;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var20 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var10.field1860;
                  var23 = var10.field1858;
                  int var39 = var10.field1859;
                  var25 = var10.field1865;

                  for(var26 = var38 - var37; var26 <= var37 + var38; ++var26) {
                     for(var27 = var23 - var37; var27 <= var23 + var37; ++var27) {
                        var28 = var26 - var15;
                        int var29 = var27 - var16;
                        if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class105.field1843[var28][var29] < 100) {
                           int var30 = 0;
                           if(var26 < var38) {
                              var30 = var38 - var26;
                           } else if(var26 > var38 + var39 - 1) {
                              var30 = var26 - (var39 + var38 - 1);
                           }

                           int var31 = 0;
                           if(var27 < var23) {
                              var31 = var23 - var27;
                           } else if(var27 > var23 + var25 - 1) {
                              var31 = var27 - (var25 + var23 - 1);
                           }

                           int var32 = var31 * var31 + var30 * var30;
                           if(var32 < var36 || var36 == var32 && class105.field1843[var28][var29] < var20) {
                              var36 = var32;
                              var20 = class105.field1843[var28][var29];
                              var17 = var26;
                              var35 = var27;
                           }
                        }
                     }
                  }

                  if(Integer.MAX_VALUE == var36) {
                     var7 = -1;
                     break label624;
                  }
               }

               if(var17 == var4 && var35 == var5) {
                  var7 = 0;
               } else {
                  var19 = 0;
                  class105.field1845[var19] = var17;
                  var36 = var19 + 1;
                  class105.field1848[var19] = var35;

                  for(var20 = var21 = class105.field1842[var17 - var15][var35 - var16]; var4 != var17 || var35 != var5; var20 = class105.field1842[var17 - var15][var35 - var16]) {
                     if(var20 != var21) {
                        var21 = var20;
                        class105.field1845[var36] = var17;
                        class105.field1848[var36++] = var35;
                     }

                     if((var20 & 2) != 0) {
                        ++var17;
                     } else if((var20 & 8) != 0) {
                        --var17;
                     }

                     if((var20 & 1) != 0) {
                        ++var35;
                     } else if((var20 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var12[var38] = class105.field1845[var36];
                     var13[var38++] = class105.field1848[var36];
                     if(var38 >= var12.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var14 = var7;
            if(var7 >= 1) {
               for(var15 = 0; var15 < var14 - 1; ++var15) {
                  var0.method18(client.field430[var15], client.field555[var15], var3);
               }

            }
         }
      }
   }
}

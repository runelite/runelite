package net.runelite.rs.client;

import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ex")
public abstract class class132 {
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 2135240255
   )
   static int field2053;

   @ObfuscatedName("j")
   public abstract void vmethod3155();

   @ObfuscatedName("m")
   abstract int vmethod3158(int var1, int var2);

   @ObfuscatedName("y")
   static final int method2889(int var0, int var1, int var2) {
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

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("an")
   static final void method2891() {
      class23.method624(false);
      client.field330 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class76.field1377.length; ++var1) {
         if(-1 != class46.field1044[var1] && class76.field1377[var1] == null) {
            class76.field1377[var1] = class12.field185.method3352(class46.field1044[var1], 0);
            if(null == class76.field1377[var1]) {
               var0 = false;
               ++client.field330;
            }
         }

         if(-1 != class92.field1575[var1] && null == class19.field270[var1]) {
            class19.field270[var1] = class12.field185.method3337(class92.field1575[var1], 0, class13.field197[var1]);
            if(null == class19.field270[var1]) {
               var0 = false;
               ++client.field330;
            }
         }
      }

      if(!var0) {
         client.field485 = 1;
      } else {
         client.field332 = 0;
         var0 = true;

         int var3;
         int var4;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         for(var1 = 0; var1 < class76.field1377.length; ++var1) {
            byte[] var2 = class19.field270[var1];
            if(var2 != null) {
               var3 = 64 * (class47.field1051[var1] >> 8) - class47.field1053;
               var4 = 64 * (class47.field1051[var1] & 255) - class161.field2629;
               if(client.field336) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               class118 var8 = new class118(var2);
               var9 = -1;

               label630:
               while(true) {
                  var10 = var8.method2548();
                  if(0 == var10) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.method2548();
                        if(var13 == 0) {
                           continue label630;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.method2536() >> 2;
                        int var17 = var15 + var3;
                        int var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           class40 var19 = class33.method755(var9);
                           if(22 != var16 || !client.field527 || 0 != var19.field937 || var19.field921 == 1 || var19.field905) {
                              if(!var19.method844()) {
                                 ++client.field332;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.method2548();
                     if(var13 == 0) {
                        break;
                     }

                     var8.method2536();
                  }
               }
            }
         }

         if(!var0) {
            client.field485 = 2;
         } else {
            if(client.field485 != 0) {
               class40.method880("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class130.method2869();
            class173.method3505();
            class130.method2869();
            class24.field610.method2072();
            class130.method2869();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               client.field335[var1].method2441();
            }

            int var42;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var42 = 0; var42 < 104; ++var42) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class5.field86[var1][var42][var3] = 0;
                  }
               }
            }

            class130.method2869();
            class92.method2179();
            var1 = class76.field1377.length;
            class174.method3508();
            class23.method624(true);
            int var44;
            if(!client.field336) {
               byte[] var5;
               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = 64 * (class47.field1051[var42] >> 8) - class47.field1053;
                  var4 = 64 * (class47.field1051[var42] & 255) - class161.field2629;
                  var5 = class76.field1377[var42];
                  if(var5 != null) {
                     class130.method2869();
                     class8.method141(var5, var3, var4, class135.field2084 * 8 - 48, class52.field1147 * 8 - 48, client.field335);
                  }
               }

               for(var42 = 0; var42 < var1; ++var42) {
                  var3 = (class47.field1051[var42] >> 8) * 64 - class47.field1053;
                  var4 = 64 * (class47.field1051[var42] & 255) - class161.field2629;
                  var5 = class76.field1377[var42];
                  if(null == var5 && class52.field1147 < 800) {
                     class130.method2869();
                     class1.method12(var3, var4, 64, 64);
                  }
               }

               class23.method624(true);

               for(var42 = 0; var42 < var1; ++var42) {
                  byte[] var43 = class19.field270[var42];
                  if(var43 != null) {
                     var4 = 64 * (class47.field1051[var42] >> 8) - class47.field1053;
                     var44 = (class47.field1051[var42] & 255) * 64 - class161.field2629;
                     class130.method2869();
                     class152.method3192(var43, var4, var44, class24.field610, client.field335);
                  }
               }
            }

            int var6;
            int var46;
            int var48;
            if(client.field336) {
               for(var42 = 0; var42 < 4; ++var42) {
                  class130.method2869();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var45 = false;
                        var6 = client.field337[var42][var3][var4];
                        if(-1 != var6) {
                           var46 = var6 >> 24 & 3;
                           var48 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(int var49 = 0; var49 < class47.field1051.length; ++var49) {
                              if(var11 == class47.field1051[var49] && class76.field1377[var49] != null) {
                                 class19.method243(class76.field1377[var49], var42, var3 * 8, 8 * var4, var46, (var9 & 7) * 8, 8 * (var10 & 7), var48, client.field335);
                                 var45 = true;
                                 break;
                              }
                           }
                        }

                        if(!var45) {
                           class15.method195(var42, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var42 = 0; var42 < 13; ++var42) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = client.field337[0][var42][var3];
                     if(var4 == -1) {
                        class1.method12(var42 * 8, 8 * var3, 8, 8);
                     }
                  }
               }

               class23.method624(true);

               for(var42 = 0; var42 < 4; ++var42) {
                  class130.method2869();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label505:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var44 = client.field337[var42][var3][var4];
                        if(-1 != var44) {
                           var6 = var44 >> 24 & 3;
                           var46 = var44 >> 1 & 3;
                           var48 = var44 >> 14 & 1023;
                           var9 = var44 >> 3 & 2047;
                           var10 = (var48 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class47.field1051.length; ++var11) {
                              if(class47.field1051[var11] == var10 && null != class19.field270[var11]) {
                                 byte[] var50 = class19.field270[var11];
                                 var13 = 8 * var3;
                                 var14 = 8 * var4;
                                 var15 = 8 * (var48 & 7);
                                 var16 = 8 * (var9 & 7);
                                 class85 var51 = class24.field610;
                                 class107[] var52 = client.field335;
                                 class118 var53 = new class118(var50);
                                 int var20 = -1;

                                 while(true) {
                                    int var21 = var53.method2548();
                                    if(var21 == 0) {
                                       continue label505;
                                    }

                                    var20 += var21;
                                    int var22 = 0;

                                    while(true) {
                                       int var23 = var53.method2548();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       int var24 = var22 & 63;
                                       int var25 = var22 >> 6 & 63;
                                       int var26 = var22 >> 12;
                                       int var27 = var53.method2536();
                                       int var28 = var27 >> 2;
                                       int var29 = var27 & 3;
                                       if(var26 == var6 && var25 >= var15 && var25 < 8 + var15 && var24 >= var16 && var24 < 8 + var16) {
                                          class40 var30 = class33.method755(var20);
                                          int var33 = var25 & 7;
                                          int var34 = var24 & 7;
                                          int var36 = var30.field919;
                                          int var37 = var30.field920;
                                          int var38;
                                          if((var29 & 1) == 1) {
                                             var38 = var36;
                                             var36 = var37;
                                             var37 = var38;
                                          }

                                          int var35 = var46 & 3;
                                          int var32;
                                          if(0 == var35) {
                                             var32 = var33;
                                          } else if(var35 == 1) {
                                             var32 = var34;
                                          } else if(2 == var35) {
                                             var32 = 7 - var33 - (var36 - 1);
                                          } else {
                                             var32 = 7 - var34 - (var37 - 1);
                                          }

                                          var38 = var32 + var13;
                                          int var39 = var14 + class115.method2475(var25 & 7, var24 & 7, var46, var30.field919, var30.field920, var29);
                                          if(var38 > 0 && var39 > 0 && var38 < 103 && var39 < 103) {
                                             int var40 = var42;
                                             if((class5.field86[1][var38][var39] & 2) == 2) {
                                                var40 = var42 - 1;
                                             }

                                             class107 var41 = null;
                                             if(var40 >= 0) {
                                                var41 = var52[var40];
                                             }

                                             class14.method193(var42, var38, var39, var20, var46 + var29 & 3, var28, var51, var41);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class23.method624(true);
            class173.method3505();
            class130.method2869();
            class41.method904(class24.field610, client.field335);
            class23.method624(true);
            var42 = class5.field74;
            if(var42 > class8.field134) {
               var42 = class8.field134;
            }

            if(var42 < class8.field134 - 1) {
               var42 = class8.field134 - 1;
            }

            if(client.field527) {
               class24.field610.method1978(class5.field74);
            } else {
               class24.field610.method1978(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class172.method3482(var3, var4);
               }
            }

            class130.method2869();

            for(class16 var47 = (class16)client.field408.method3871(); var47 != null; var47 = (class16)client.field408.method3873()) {
               if(var47.field233 == -1) {
                  var47.field222 = 0;
                  class21.method612(var47);
               } else {
                  var47.method3965();
               }
            }

            class40.field907.method3806();
            if(null != class39.field902) {
               client.field318.method2785(210);
               client.field318.method2524(1057001181);
            }

            if(!client.field336) {
               var3 = (class135.field2084 - 6) / 8;
               var4 = (6 + class135.field2084) / 8;
               var44 = (class52.field1147 - 6) / 8;
               var6 = (6 + class52.field1147) / 8;

               for(var46 = var3 - 1; var46 <= 1 + var4; ++var46) {
                  for(var48 = var44 - 1; var48 <= var6 + 1; ++var48) {
                     if(var46 < var3 || var46 > var4 || var48 < var44 || var48 > var6) {
                        class12.field185.method3394("m" + var46 + "_" + var48);
                        class12.field185.method3394("l" + var46 + "_" + var48);
                     }
                  }
               }
            }

            class31.method714(30);
            class130.method2869();
            class112.method2463();
            client.field318.method2785(213);
            class45.field1026.vmethod3155();

            for(var3 = 0; var3 < 32; ++var3) {
               class143.field2182[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               class143.field2183[var3] = 0L;
            }

            class102.field1751 = 0;
         }
      }
   }

   @ObfuscatedName("m")
   public static void method2893(boolean var0) {
      if(null != class170.field2715) {
         try {
            class118 var1 = new class118(4);
            var1.method2521(var0?2:3);
            var1.method2523(0);
            class170.field2715.method3042(var1.field1980, 0, 4);
         } catch (IOException var4) {
            try {
               class170.field2715.method3022();
            } catch (Exception var3) {
               ;
            }

            ++class170.field2704;
            class170.field2715 = null;
         }

      }
   }

   @ObfuscatedName("f")
   public static int method2894() {
      return ++class139.field2129 - 1;
   }

   @ObfuscatedName("aj")
   static final void method2895(int var0, int var1) {
      if(var0 != class135.field2084 || var1 != class52.field1147) {
         class135.field2084 = var0;
         class52.field1147 = var1;
         class31.method714(25);
         class40.method880("Loading - please wait.", true);
         int var2 = class47.field1053;
         int var3 = class161.field2629;
         class47.field1053 = (var0 - 6) * 8;
         class161.field2629 = (var1 - 6) * 8;
         int var4 = class47.field1053 - var2;
         int var5 = class161.field2629 - var3;
         var2 = class47.field1053;
         var3 = class161.field2629;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field313[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field809[var8] -= var4;
                  var7.field816[var8] -= var5;
               }

               var7.field846 -= var4 * 128;
               var7.field834 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field397[var6];
            if(var18 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field809[var8] -= var4;
                  var18.field816[var8] -= var5;
               }

               var18.field846 -= var4 * 128;
               var18.field834 -= 128 * var5;
            }
         }

         byte var17 = 0;
         byte var19 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var17 = 103;
            var19 = -1;
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
         for(int var12 = var17; var19 != var12; var12 += var20) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field407[var16][var12][var13] = client.field407[var16][var14][var15];
                  } else {
                     client.field407[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field408.method3871(); var21 != null; var21 = (class16)client.field408.method3873()) {
            var21.field224 -= var4;
            var21.field225 -= var5;
            if(var21.field224 < 0 || var21.field225 < 0 || var21.field224 >= 104 || var21.field225 >= 104) {
               var21.method3965();
            }
         }

         if(0 != client.field537) {
            client.field537 -= var4;
            client.field294 -= var5;
         }

         client.field516 = 0;
         client.field334 = false;
         client.field503 = 1;
         client.field491.method3865();
         client.field409.method3865();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field335[var13].method2441();
         }

      }
   }

   @ObfuscatedName("ci")
   static final void method2896(int var0) {
      class56.method1261();
      class134.method2910();
      class52 var2 = (class52)class52.field1144.method3808((long)var0);
      class52 var1;
      if(null != var2) {
         var1 = var2;
      } else {
         byte[] var3 = class52.field1149.method3352(16, var0);
         var2 = new class52();
         if(var3 != null) {
            var2.method1117(new class118(var3));
         }

         class52.field1144.method3805(var2, (long)var0);
         var1 = var2;
      }

      int var5 = var1.field1145;
      if(0 != var5) {
         int var6 = class175.field2884[var0];
         if(var5 == 1) {
            if(var6 == 1) {
               class90.method2150(0.9D);
               ((class94)class90.field1569).method2185(0.9D);
            }

            if(2 == var6) {
               class90.method2150(0.8D);
               ((class94)class90.field1569).method2185(0.8D);
            }

            if(3 == var6) {
               class90.method2150(0.7D);
               ((class94)class90.field1569).method2185(0.7D);
            }

            if(var6 == 4) {
               class90.method2150(0.6D);
               ((class94)class90.field1569).method2185(0.6D);
            }

            class51.field1095.method3806();
         }

         if(3 == var5) {
            short var4 = 0;
            if(0 == var6) {
               var4 = 255;
            }

            if(1 == var6) {
               var4 = 192;
            }

            if(var6 == 2) {
               var4 = 128;
            }

            if(3 == var6) {
               var4 = 64;
            }

            if(var6 == 4) {
               var4 = 0;
            }

            if(client.field543 != var4) {
               if(0 == client.field543 && client.field512 != -1) {
                  class41.method903(class142.field2165, client.field512, 0, var4, false);
                  client.field513 = false;
               } else if(var4 == 0) {
                  class182.field2943.method3658();
                  class182.field2940 = 1;
                  class188.field3038 = null;
                  client.field513 = false;
               } else if(0 != class182.field2940) {
                  class182.field2942 = var4;
               } else {
                  class182.field2943.method3652(var4);
               }

               client.field543 = var4;
            }
         }

         if(4 == var5) {
            if(var6 == 0) {
               client.field514 = 127;
            }

            if(var6 == 1) {
               client.field514 = 96;
            }

            if(var6 == 2) {
               client.field514 = 64;
            }

            if(3 == var6) {
               client.field514 = 32;
            }

            if(var6 == 4) {
               client.field514 = 0;
            }
         }

         if(var5 == 5) {
            client.field414 = var6;
         }

         if(6 == var5) {
            client.field436 = var6;
         }

         if(9 == var5) {
            client.field293 = var6;
         }

         if(10 == var5) {
            if(0 == var6) {
               client.field515 = 127;
            }

            if(var6 == 1) {
               client.field515 = 96;
            }

            if(var6 == 2) {
               client.field515 = 64;
            }

            if(3 == var6) {
               client.field515 = 32;
            }

            if(4 == var6) {
               client.field515 = 0;
            }
         }

         if(17 == var5) {
            client.field463 = var6 & '\uffff';
         }

         if(var5 == 18) {
            client.field276 = (class20)class23.method634(class102.method2313(), var6);
            if(null == client.field276) {
               client.field276 = class20.field559;
            }
         }

         if(var5 == 19) {
            if(-1 == var6) {
               client.field406 = -1;
            } else {
               client.field406 = var6 & 2047;
            }
         }

         if(22 == var5) {
            client.field303 = (class20)class23.method634(class102.method2313(), var6);
            if(client.field303 == null) {
               client.field303 = class20.field559;
            }
         }

      }
   }
}

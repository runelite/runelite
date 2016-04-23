import java.awt.Frame;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class4 {
   @ObfuscatedName("h")
   static final BigInteger field72 = new BigInteger("97137feb4b19498bc7238b66e88992b7a98c4571edce07512bd7cf5cd39d01d7636eed4813c83dc20f16a1f9b897b4459a68c53f301d1a454d2b011c041d8c55342cdb09b831646f9c38a1cd0041f0bcc131a49e743f1be63c0ea9f1d82df3cd589161069d39f05ca6ca641187d9fa4ad68d098bed83213ae03e479fd0098649", 16);
   @ObfuscatedName("l")
   static int[] field73;
   @ObfuscatedName("py")
   static class8 field75;
   @ObfuscatedName("ar")
   static class146 field77;
   @ObfuscatedName("j")
   static final BigInteger field80 = new BigInteger("10001", 16);
   @ObfuscatedName("qz")
   protected static Frame field82;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2129713781"
   )
   static final void method34(int var0, int var1) {
      if(var0 != class156.field2294 || var1 != class168.field2692) {
         class156.field2294 = var0;
         class168.field2692 = var1;
         class13.method162(25);
         class171.method3355("Loading - please wait.", true);
         int var2 = class187.field3014;
         int var3 = class0.field12;
         class187.field3014 = (var0 - 6) * 8;
         class0.field12 = (var1 - 6) * 8;
         int var4 = class187.field3014 - var2;
         int var5 = class0.field12 - var3;
         var2 = class187.field3014;
         var3 = class0.field12;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field517[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field848[var8] -= var4;
                  var7.field822[var8] -= var5;
               }

               var7.field816 -= 128 * var4;
               var7.field840 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field396[var6];
            if(null != var18) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field848[var8] -= var4;
                  var18.field822[var8] -= var5;
               }

               var18.field816 -= 128 * var4;
               var18.field840 -= var5 * 128;
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
         for(int var12 = var17; var12 != var19; var12 += var20) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field364[var16][var12][var13] = client.field364[var16][var14][var15];
                  } else {
                     client.field364[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field407.method3784(); var21 != null; var21 = (class16)client.field407.method3777()) {
            var21.field224 -= var4;
            var21.field225 -= var5;
            if(var21.field224 < 0 || var21.field225 < 0 || var21.field224 >= 104 || var21.field225 >= 104) {
               var21.method3883();
            }
         }

         if(client.field507 != 0) {
            client.field507 -= var4;
            client.field508 -= var5;
         }

         client.field515 = 0;
         client.field499 = false;
         client.field355 = -1;
         client.field454.method3789();
         client.field408.method3789();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field482[var13].method2378();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILclass86;[Lclass108;I)V",
      garbageValue = "-31621208"
   )
   static final void method35(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class86 var8, class108[] var9) {
      class119 var10 = new class119(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2512();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2512();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2500();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               class40 var21 = class85.method1903(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.field920;
               int var28 = var21.field921;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var2 + var23;
               int var30 = var3 + class0.method3(var16 & 7, var15 & 7, var7, var21.field920, var21.field921, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class5.field84[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  class108 var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class144.method3076(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass168;",
      garbageValue = "0"
   )
   static class168 method36(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(null != class149.field2217) {
         var4 = new class134(var0, class149.field2217, class15.field221[var0], 1000000);
      }

      return new class168(var4, class151.field2243, var0, var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-110211928"
   )
   static void method37(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field1971 = var0.length - 2;
      class76.field1368 = var1.method2502();
      class76.field1366 = new int[class76.field1368];
      class76.field1367 = new int[class76.field1368];
      class52.field1145 = new int[class76.field1368];
      class76.field1371 = new int[class76.field1368];
      client.field557 = new byte[class76.field1368][];
      var1.field1971 = var0.length - 7 - class76.field1368 * 8;
      class76.field1364 = var1.method2502();
      class129.field2027 = var1.method2502();
      int var2 = (var1.method2500() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1368; ++var3) {
         class76.field1366[var3] = var1.method2502();
      }

      for(var3 = 0; var3 < class76.field1368; ++var3) {
         class76.field1367[var3] = var1.method2502();
      }

      for(var3 = 0; var3 < class76.field1368; ++var3) {
         class52.field1145[var3] = var1.method2502();
      }

      for(var3 = 0; var3 < class76.field1368; ++var3) {
         class76.field1371[var3] = var1.method2502();
      }

      var1.field1971 = var0.length - 7 - class76.field1368 * 8 - (var2 - 1) * 3;
      class227.field3220 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class227.field3220[var3] = var1.method2662();
         if(class227.field3220[var3] == 0) {
            class227.field3220[var3] = 1;
         }
      }

      var1.field1971 = 0;

      for(var3 = 0; var3 < class76.field1368; ++var3) {
         int var4 = class52.field1145[var3];
         int var5 = class76.field1371[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         client.field557[var3] = var7;
         int var8 = var1.method2500();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2670();
            }
         } else if(1 == var8) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.method2670();
               }
            }
         }
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-342574202"
   )
   static final void method38(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(null != var3) {
            if(0 == var3.field2820) {
               if(null != var3.field2868) {
                  method38(var3.field2868, var1);
               }

               class3 var4 = (class3)client.field434.method3742((long)var3.field2774);
               if(var4 != null) {
                  int var5 = var4.field65;
                  if(class107.method2374(var5)) {
                     method38(class173.field2735[var5], var1);
                  }
               }
            }

            class0 var6;
            if(0 == var1 && var3.field2824 != null) {
               var6 = new class0();
               var6.field18 = var3;
               var6.field16 = var3.field2824;
               class37.method749(var6);
            }

            if(1 == var1 && null != var3.field2852) {
               if(var3.field2798 >= 0) {
                  class173 var7 = class141.method2959(var3.field2774);
                  if(var7 == null || null == var7.field2868 || var3.field2798 >= var7.field2868.length || var7.field2868[var3.field2798] != var3) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field18 = var3;
               var6.field16 = var3.field2852;
               class37.method749(var6);
            }
         }
      }

   }
}

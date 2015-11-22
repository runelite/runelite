package net.runelite.rs.client;

import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("u")
public class class4 {
   @ObfuscatedName("j")
   static final BigInteger field67 = new BigInteger("10001", 16);
   @ObfuscatedName("al")
   static class145 field68;
   @ObfuscatedName("m")
   static final BigInteger field69 = new BigInteger("932788aa285b155ea366463bf082f0d55b5002b0ddc7605e4174902bb3f2871e172989cc50f148bfd843ad75ea7ce2517cde36090d5ba67b46289550424d0521d2cf02e7a3fb0218eadb1ac71511a9f2143784a2a90a12d0d0c33af0fb4631c449dda926600360fdae90dc103b879d61f50848fa249534a61c0bd32b08a7b7a1", 16);
   @ObfuscatedName("ba")
   static class167 field70;

   @ObfuscatedName("bn")
   static final void method47() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var9;
      if(client.field446 == 73) {
         var0 = client.field320.method2572();
         var1 = client.field320.method2536();
         var2 = class123.field2019 + (var1 >> 4 & 7);
         var3 = class13.field198 + (var1 & 7);
         var4 = client.field320.method2563();
         var5 = var4 >> 2;
         var6 = var4 & 3;
         var7 = client.field338[var5];
         if(var2 >= 0 && var3 >= 0 && var2 < 103 && var3 < 103) {
            if(0 == var7) {
               class86 var36 = class24.field610.method1954(class8.field134, var2, var3);
               if(null != var36) {
                  var9 = var36.field1513 >> 14 & 32767;
                  if(var5 == 2) {
                     var36.field1511 = new class12(var9, 2, var6 + 4, class8.field134, var2, var3, var0, false, var36.field1511);
                     var36.field1505 = new class12(var9, 2, 1 + var6 & 3, class8.field134, var2, var3, var0, false, var36.field1505);
                  } else {
                     var36.field1511 = new class12(var9, var5, var6, class8.field134, var2, var3, var0, false, var36.field1511);
                  }
               }
            }

            if(var7 == 1) {
               class93 var37 = class24.field610.method1955(class8.field134, var2, var3);
               if(null != var37) {
                  var9 = var37.field1595 >> 14 & 32767;
                  if(4 != var5 && 5 != var5) {
                     if(var5 == 6) {
                        var37.field1593 = new class12(var9, 4, 4 + var6, class8.field134, var2, var3, var0, false, var37.field1593);
                     } else if(7 == var5) {
                        var37.field1593 = new class12(var9, 4, (2 + var6 & 3) + 4, class8.field134, var2, var3, var0, false, var37.field1593);
                     } else if(var5 == 8) {
                        var37.field1593 = new class12(var9, 4, 4 + var6, class8.field134, var2, var3, var0, false, var37.field1593);
                        var37.field1586 = new class12(var9, 4, 4 + (2 + var6 & 3), class8.field134, var2, var3, var0, false, var37.field1586);
                     }
                  } else {
                     var37.field1593 = new class12(var9, 4, var6, class8.field134, var2, var3, var0, false, var37.field1593);
                  }
               }
            }

            if(2 == var7) {
               class97 var38 = class24.field610.method1956(class8.field134, var2, var3);
               if(11 == var5) {
                  var5 = 10;
               }

               if(null != var38) {
                  var38.field1644 = new class12(var38.field1653 >> 14 & 32767, var5, var6, class8.field134, var2, var3, var0, false, var38.field1644);
               }
            }

            if(var7 == 3) {
               class92 var39 = class24.field610.method2043(class8.field134, var2, var3);
               if(null != var39) {
                  var39.field1577 = new class12(var39.field1574 >> 14 & 32767, 22, var6, class8.field134, var2, var3, var0, false, var39.field1577);
               }
            }
         }

      } else {
         int var8;
         int var10;
         int var11;
         int var12;
         if(213 == client.field446) {
            var0 = client.field320.method2536();
            var1 = class123.field2019 + (var0 >> 4 & 7);
            var2 = class13.field198 + (var0 & 7);
            var3 = var1 + client.field320.method2537();
            var4 = var2 + client.field320.method2537();
            var5 = client.field320.method2539();
            var6 = client.field320.method2538();
            var7 = client.field320.method2536() * 4;
            var8 = client.field320.method2536() * 4;
            var9 = client.field320.method2538();
            var10 = client.field320.method2538();
            var11 = client.field320.method2536();
            var12 = client.field320.method2536();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
               var1 = 64 + var1 * 128;
               var2 = 64 + 128 * var2;
               var3 = 64 + 128 * var3;
               var4 = 128 * var4 + 64;
               class6 var40 = new class6(var6, class8.field134, var1, var2, class34.method774(var1, var2, class8.field134) - var7, client.field286 + var9, var10 + client.field286, var11, var12, var5, var8);
               var40.method116(var3, var4, class34.method774(var3, var4, class8.field134) - var8, var9 + client.field286);
               client.field409.method3868(var40);
            }

         } else if(62 == client.field446) {
            var0 = client.field320.method2563();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = client.field338[var1];
            var4 = client.field320.method2571();
            var5 = client.field320.method2561();
            var6 = (var5 >> 4 & 7) + class123.field2019;
            var7 = class13.field198 + (var5 & 7);
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               class83.method1919(class8.field134, var6, var7, var3, var4, var1, var2, 0, -1);
            }

         } else {
            if(210 == client.field446) {
               var0 = client.field320.method2536();
               var1 = (var0 >> 4 & 7) + class123.field2019;
               var2 = (var0 & 7) + class13.field198;
               var3 = client.field320.method2538();
               var4 = client.field320.method2536();
               var5 = var4 >> 4 & 15;
               var6 = var4 & 7;
               var7 = client.field320.method2536();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var8 = 1 + var5;
                  if(class0.field12.field809[0] >= var1 - var8 && class0.field12.field809[0] <= var8 + var1 && class0.field12.field816[0] >= var2 - var8 && class0.field12.field816[0] <= var2 + var8 && 0 != client.field515 && var6 > 0 && client.field516 < 50) {
                     client.field462[client.field516] = var3;
                     client.field518[client.field516] = var6;
                     client.field519[client.field516] = var7;
                     client.field521[client.field516] = null;
                     client.field467[client.field516] = (var1 << 16) + (var2 << 8) + var5;
                     ++client.field516;
                  }
               }
            }

            class28 var31;
            if(238 == client.field446) {
               var0 = client.field320.method2538();
               var1 = client.field320.method2563();
               var2 = (var1 >> 4 & 7) + class123.field2019;
               var3 = (var1 & 7) + class13.field198;
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  class198 var30 = client.field407[class8.field134][var2][var3];
                  if(null != var30) {
                     for(var31 = (class28)var30.method3871(); null != var31; var31 = (class28)var30.method3873()) {
                        if(var31.field660 == (var0 & 32767)) {
                           var31.method3965();
                           break;
                        }
                     }

                     if(var30.method3871() == null) {
                        client.field407[class8.field134][var2][var3] = null;
                     }

                     class172.method3482(var2, var3);
                  }
               }

            } else if(client.field446 == 143) {
               var0 = client.field320.method2536();
               var1 = class123.field2019 + (var0 >> 4 & 7);
               var2 = class13.field198 + (var0 & 7);
               var3 = client.field320.method2538();
               var4 = client.field320.method2538();
               var5 = client.field320.method2538();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class198 var33 = client.field407[class8.field134][var1][var2];
                  if(var33 != null) {
                     for(class28 var35 = (class28)var33.method3871(); null != var35; var35 = (class28)var33.method3873()) {
                        if((var3 & 32767) == var35.field660 && var35.field658 == var4) {
                           var35.field658 = var5;
                           break;
                        }
                     }

                     class172.method3482(var1, var2);
                  }
               }

            } else if(client.field446 == 116) {
               var0 = client.field320.method2570();
               var1 = client.field320.method2559();
               var2 = class123.field2019 + (var1 >> 4 & 7);
               var3 = class13.field198 + (var1 & 7);
               var4 = client.field320.method2570();
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  var31 = new class28();
                  var31.field660 = var4;
                  var31.field658 = var0;
                  if(null == client.field407[class8.field134][var2][var3]) {
                     client.field407[class8.field134][var2][var3] = new class198();
                  }

                  client.field407[class8.field134][var2][var3].method3868(var31);
                  class172.method3482(var2, var3);
               }

            } else {
               if(client.field446 == 34) {
                  var0 = client.field320.method2538();
                  var1 = client.field320.method2559();
                  var2 = (var1 >> 4 & 7) + class123.field2019;
                  var3 = (var1 & 7) + class13.field198;
                  var4 = client.field320.method2572();
                  byte var29 = client.field320.method2564();
                  var6 = client.field320.method2571();
                  byte var34 = client.field320.method2737();
                  var8 = client.field320.method2571();
                  var9 = client.field320.method2563();
                  var10 = var9 >> 2;
                  var11 = var9 & 3;
                  var12 = client.field338[var10];
                  byte var13 = client.field320.method2737();
                  byte var14 = client.field320.method2566();
                  class2 var15;
                  if(var0 == client.field523) {
                     var15 = class0.field12;
                  } else {
                     var15 = client.field397[var0];
                  }

                  if(null != var15) {
                     class40 var16 = class33.method755(var6);
                     int var17;
                     int var18;
                     if(1 != var11 && var11 != 3) {
                        var17 = var16.field919;
                        var18 = var16.field920;
                     } else {
                        var17 = var16.field920;
                        var18 = var16.field919;
                     }

                     int var19 = var2 + (var17 >> 1);
                     int var20 = (1 + var17 >> 1) + var2;
                     int var21 = (var18 >> 1) + var3;
                     int var22 = (1 + var18 >> 1) + var3;
                     int[][] var23 = class5.field79[class8.field134];
                     int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
                     int var25 = (var17 << 6) + (var2 << 7);
                     int var26 = (var18 << 6) + (var3 << 7);
                     class104 var27 = var16.method851(var10, var11, var23, var25, var24, var26);
                     if(null != var27) {
                        class83.method1919(class8.field134, var2, var3, var12, -1, 0, 0, var8 + 1, var4 + 1);
                        var15.field39 = client.field286 + var8;
                        var15.field40 = client.field286 + var4;
                        var15.field44 = var27;
                        var15.field41 = 64 * var17 + 128 * var2;
                        var15.field43 = 64 * var18 + 128 * var3;
                        var15.field42 = var24;
                        byte var28;
                        if(var13 > var29) {
                           var28 = var13;
                           var13 = var29;
                           var29 = var28;
                        }

                        if(var34 > var14) {
                           var28 = var34;
                           var34 = var14;
                           var14 = var28;
                        }

                        var15.field45 = var2 + var13;
                        var15.field47 = var2 + var29;
                        var15.field52 = var34 + var3;
                        var15.field48 = var14 + var3;
                     }
                  }
               }

               if(236 == client.field446) {
                  var0 = client.field320.method2536();
                  var1 = class123.field2019 + (var0 >> 4 & 7);
                  var2 = class13.field198 + (var0 & 7);
                  var3 = client.field320.method2538();
                  var4 = client.field320.method2536();
                  var5 = client.field320.method2538();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     class29 var32 = new class29(var3, class8.field134, var1, var2, class34.method774(var1, var2, class8.field134) - var4, var5, client.field286);
                     client.field491.method3868(var32);
                  }

               } else if(client.field446 == 226) {
                  var0 = client.field320.method2563();
                  var1 = class123.field2019 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class13.field198;
                  var3 = client.field320.method2536();
                  var4 = var3 >> 2;
                  var5 = var3 & 3;
                  var6 = client.field338[var4];
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     class83.method1919(class8.field134, var1, var2, var6, -1, var4, var5, 0, -1);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   static void method48(int var0, int var1, int var2, class40 var3, int var4) {
      class23 var5 = new class23();
      var5.field588 = var0;
      var5.field589 = var1 * 128;
      var5.field592 = var2 * 128;
      int var6 = var3.field919;
      int var7 = var3.field920;
      if(1 == var4 || var4 == 3) {
         var6 = var3.field920;
         var7 = var3.field919;
      }

      var5.field591 = (var1 + var6) * 128;
      var5.field603 = (var2 + var7) * 128;
      var5.field594 = var3.field906;
      var5.field596 = var3.field949 * 128;
      var5.field598 = var3.field950;
      var5.field597 = var3.field951;
      var5.field587 = var3.field955;
      if(var3.field945 != null) {
         var5.field593 = var3;
         var5.method620();
      }

      class23.field590.method3868(var5);
      if(null != var5.field587) {
         var5.field599 = var5.field598 + (int)(Math.random() * (double)(var5.field597 - var5.field598));
      }

   }
}

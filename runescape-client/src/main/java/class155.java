import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class155 {
   @ObfuscatedName("i")
   public static final boolean[] field2323 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("g")
   public static int[] field2324 = new int[99];

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "369697870"
   )
   public static int method3131(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class119.field1999[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = 1 + var1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2324[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "16776960"
   )
   static String method3132(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method3133() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var5;
      int var6;
      int var7;
      int var10;
      int var11;
      int var12;
      int var31;
      int var32;
      int var40;
      if(client.field329 == 79) {
         var0 = client.field327.method2494();
         var1 = class38.field872 + (var0 >> 4 & 7);
         var2 = (var0 & 7) + class143.field2222;
         var3 = var1 + client.field327.method2469();
         var31 = var2 + client.field327.method2469();
         var5 = client.field327.method2638();
         var6 = client.field327.method2470();
         var7 = client.field327.method2494() * 4;
         var32 = client.field327.method2494() * 4;
         var40 = client.field327.method2470();
         var10 = client.field327.method2470();
         var11 = client.field327.method2494();
         var12 = client.field327.method2494();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var31 >= 0 && var3 < 104 && var31 < 104 && var6 != '\uffff') {
            var1 = var1 * 128 + 64;
            var2 = 64 + var2 * 128;
            var3 = 128 * var3 + 64;
            var31 = 128 * var31 + 64;
            class6 var13 = new class6(var6, class32.field754, var1, var2, class14.method147(var1, var2, class32.field754) - var7, var40 + client.field332, var10 + client.field332, var11, var12, var5, var32);
            var13.method69(var3, var31, class14.method147(var3, var31, class32.field754) - var32, client.field332 + var40);
            client.field417.method3771(var13);
         }

      } else {
         class28 var33;
         if(client.field329 == 44) {
            var0 = client.field327.method2494();
            var1 = (var0 >> 4 & 7) + class38.field872;
            var2 = (var0 & 7) + class143.field2222;
            var3 = client.field327.method2646();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class199 var4 = client.field415[class32.field754][var1][var2];
               if(var4 != null) {
                  for(var33 = (class28)var4.method3797(); null != var33; var33 = (class28)var4.method3779()) {
                     if((var3 & 32767) == var33.field677) {
                        var33.method3870();
                        break;
                     }
                  }

                  if(var4.method3797() == null) {
                     client.field415[class32.field754][var1][var2] = null;
                  }

                  class3.method35(var1, var2);
               }
            }

         } else {
            if(client.field329 == 203) {
               var0 = client.field327.method2494();
               var1 = class38.field872 + (var0 >> 4 & 7);
               var2 = class143.field2222 + (var0 & 7);
               var3 = client.field327.method2470();
               var31 = client.field327.method2494();
               var5 = var31 >> 4 & 15;
               var6 = var31 & 7;
               var7 = client.field327.method2494();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var32 = var5 + 1;
                  if(class152.field2301.field847[0] >= var1 - var32 && class152.field2301.field847[0] <= var32 + var1 && class152.field2301.field839[0] >= var2 - var32 && class152.field2301.field839[0] <= var2 + var32 && client.field374 != 0 && var6 > 0 && client.field524 < 50) {
                     client.field525[client.field524] = var3;
                     client.field319[client.field524] = var6;
                     client.field527[client.field524] = var7;
                     client.field529[client.field524] = null;
                     client.field532[client.field524] = var5 + (var1 << 16) + (var2 << 8);
                     ++client.field524;
                  }
               }
            }

            if(client.field329 == 100) {
               var0 = client.field327.method2494();
               var1 = (var0 >> 4 & 7) + class38.field872;
               var2 = (var0 & 7) + class143.field2222;
               var3 = client.field327.method2545();
               var31 = client.field327.method2470();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var33 = new class28();
                  var33.field677 = var31;
                  var33.field671 = var3;
                  if(client.field415[class32.field754][var1][var2] == null) {
                     client.field415[class32.field754][var1][var2] = new class199();
                  }

                  client.field415[class32.field754][var1][var2].method3771(var33);
                  class3.method35(var1, var2);
               }

            } else if(client.field329 == 0) {
               var0 = client.field327.method2495();
               var1 = class38.field872 + (var0 >> 4 & 7);
               var2 = class143.field2222 + (var0 & 7);
               var3 = client.field327.method2494();
               var31 = var3 >> 2;
               var5 = var3 & 3;
               var6 = client.field347[var31];
               var7 = client.field327.method2545();
               if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                  if(var6 == 0) {
                     class87 var8 = class214.field3161.method1892(class32.field754, var1, var2);
                     if(var8 != null) {
                        var40 = var8.field1543 >> 14 & 32767;
                        if(var31 == 2) {
                           var8.field1535 = new class12(var40, 2, 4 + var5, class32.field754, var1, var2, var7, false, var8.field1535);
                           var8.field1538 = new class12(var40, 2, var5 + 1 & 3, class32.field754, var1, var2, var7, false, var8.field1538);
                        } else {
                           var8.field1535 = new class12(var40, var31, var5, class32.field754, var1, var2, var7, false, var8.field1535);
                        }
                     }
                  }

                  if(var6 == 1) {
                     class94 var37 = class214.field3161.method1893(class32.field754, var1, var2);
                     if(var37 != null) {
                        var40 = var37.field1619 >> 14 & 32767;
                        if(var31 != 4 && var31 != 5) {
                           if(var31 == 6) {
                              var37.field1620 = new class12(var40, 4, var5 + 4, class32.field754, var1, var2, var7, false, var37.field1620);
                           } else if(var31 == 7) {
                              var37.field1620 = new class12(var40, 4, (var5 + 2 & 3) + 4, class32.field754, var1, var2, var7, false, var37.field1620);
                           } else if(var31 == 8) {
                              var37.field1620 = new class12(var40, 4, var5 + 4, class32.field754, var1, var2, var7, false, var37.field1620);
                              var37.field1616 = new class12(var40, 4, 4 + (2 + var5 & 3), class32.field754, var1, var2, var7, false, var37.field1616);
                           }
                        } else {
                           var37.field1620 = new class12(var40, 4, var5, class32.field754, var1, var2, var7, false, var37.field1620);
                        }
                     }
                  }

                  if(var6 == 2) {
                     class98 var38 = class214.field3161.method1894(class32.field754, var1, var2);
                     if(var31 == 11) {
                        var31 = 10;
                     }

                     if(var38 != null) {
                        var38.field1685 = new class12(var38.field1678 >> 14 & 32767, var31, var5, class32.field754, var1, var2, var7, false, var38.field1685);
                     }
                  }

                  if(var6 == 3) {
                     class93 var39 = class214.field3161.method1895(class32.field754, var1, var2);
                     if(null != var39) {
                        var39.field1607 = new class12(var39.field1608 >> 14 & 32767, 22, var5, class32.field754, var1, var2, var7, false, var39.field1607);
                     }
                  }
               }

            } else if(client.field329 == 171) {
               var0 = client.field327.method2494();
               var1 = (var0 >> 4 & 7) + class38.field872;
               var2 = (var0 & 7) + class143.field2222;
               var3 = client.field327.method2470();
               var31 = client.field327.method2470();
               var5 = client.field327.method2470();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class199 var41 = client.field415[class32.field754][var1][var2];
                  if(var41 != null) {
                     for(class28 var30 = (class28)var41.method3797(); var30 != null; var30 = (class28)var41.method3779()) {
                        if(var30.field677 == (var3 & 32767) && var31 == var30.field671) {
                           var30.field671 = var5;
                           break;
                        }
                     }

                     class3.method35(var1, var2);
                  }
               }

            } else if(client.field329 == 38) {
               var0 = client.field327.method2494();
               var1 = (var0 >> 4 & 7) + class38.field872;
               var2 = class143.field2222 + (var0 & 7);
               var3 = client.field327.method2623();
               var31 = var3 >> 2;
               var5 = var3 & 3;
               var6 = client.field347[var31];
               var7 = client.field327.method2470();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class32.method700(class32.field754, var1, var2, var6, var7, var31, var5, 0, -1);
               }

            } else {
               if(client.field329 == 208) {
                  byte var35 = client.field327.method2469();
                  var1 = client.field327.method2646();
                  var2 = client.field327.method2470();
                  byte var36 = client.field327.method2659();
                  var31 = client.field327.method2494();
                  var5 = var31 >> 2;
                  var6 = var31 & 3;
                  var7 = client.field347[var5];
                  var32 = client.field327.method2646();
                  byte var9 = client.field327.method2601();
                  var10 = client.field327.method2613();
                  var11 = class38.field872 + (var10 >> 4 & 7);
                  var12 = class143.field2222 + (var10 & 7);
                  byte var34 = client.field327.method2469();
                  int var14 = client.field327.method2646();
                  class2 var15;
                  if(client.field460 == var14) {
                     var15 = class152.field2301;
                  } else {
                     var15 = client.field405[var14];
                  }

                  if(null != var15) {
                     class40 var16 = class49.method980(var1);
                     int var17;
                     int var18;
                     if(var6 != 1 && var6 != 3) {
                        var17 = var16.field954;
                        var18 = var16.field923;
                     } else {
                        var17 = var16.field923;
                        var18 = var16.field954;
                     }

                     int var19 = var11 + (var17 >> 1);
                     int var20 = (1 + var17 >> 1) + var11;
                     int var21 = (var18 >> 1) + var12;
                     int var22 = var12 + (1 + var18 >> 1);
                     int[][] var23 = class5.field100[class32.field754];
                     int var24 = var23[var20][var22] + var23[var19][var21] + var23[var20][var21] + var23[var19][var22] >> 2;
                     int var25 = (var11 << 7) + (var17 << 6);
                     int var26 = (var18 << 6) + (var12 << 7);
                     class105 var27 = var16.method795(var5, var6, var23, var25, var24, var26);
                     if(null != var27) {
                        class32.method700(class32.field754, var11, var12, var7, -1, 0, 0, var2 + 1, 1 + var32);
                        var15.field53 = var2 + client.field332;
                        var15.field45 = var32 + client.field332;
                        var15.field35 = var27;
                        var15.field46 = 128 * var11 + var17 * 64;
                        var15.field52 = var12 * 128 + var18 * 64;
                        var15.field47 = var24;
                        byte var28;
                        if(var35 > var36) {
                           var28 = var35;
                           var35 = var36;
                           var36 = var28;
                        }

                        if(var34 > var9) {
                           var28 = var34;
                           var34 = var9;
                           var9 = var28;
                        }

                        var15.field60 = var11 + var35;
                        var15.field36 = var11 + var36;
                        var15.field49 = var34 + var12;
                        var15.field50 = var12 + var9;
                     }
                  }
               }

               if(client.field329 == 58) {
                  var0 = client.field327.method2494();
                  var1 = (var0 >> 4 & 7) + class38.field872;
                  var2 = (var0 & 7) + class143.field2222;
                  var3 = client.field327.method2470();
                  var31 = client.field327.method2494();
                  var5 = client.field327.method2470();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = 64 + 128 * var1;
                     var2 = var2 * 128 + 64;
                     class29 var29 = new class29(var3, class32.field754, var1, var2, class14.method147(var1, var2, class32.field754) - var31, var5, client.field332);
                     client.field446.method3771(var29);
                  }

               } else if(client.field329 == 251) {
                  var0 = client.field327.method2494();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = client.field347[var1];
                  var31 = client.field327.method2613();
                  var5 = (var31 >> 4 & 7) + class38.field872;
                  var6 = class143.field2222 + (var31 & 7);
                  if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     class32.method700(class32.field754, var5, var6, var3, -1, var1, var2, 0, -1);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "0"
   )
   static final void method3134(String var0, boolean var1) {
      if(null != var0) {
         if((client.field553 < 100 || client.field451 == 1) && client.field553 < 400) {
            String var2 = class36.method723(var0, class96.field1641);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field553; ++var3) {
                  class7 var4 = client.field400[var3];
                  var5 = class36.method723(var4.field135, class96.field1641);
                  if(var5 != null && var5.equals(var2)) {
                     class33.method702(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.field134) {
                     var6 = class36.method723(var4.field134, class96.field1641);
                     if(var6 != null && var6.equals(var2)) {
                        class33.method702(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field418; ++var3) {
                  class17 var7 = client.field551[var3];
                  var5 = class36.method723(var7.field239, class96.field1641);
                  if(var5 != null && var5.equals(var2)) {
                     class33.method702(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var7.field238) {
                     var6 = class36.method723(var7.field238, class96.field1641);
                     if(null != var6 && var6.equals(var2)) {
                        class33.method702(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class36.method723(class152.field2301.field39, class96.field1641).equals(var2)) {
                  class33.method702(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field325.method2733(188);
                  client.field325.method2453(class102.method2237(var0));
                  client.field325.method2586(var0);
               }
            }
         } else {
            class33.method702(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "0"
   )
   public static byte[] method3135(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2753();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)I",
      garbageValue = "1488116566"
   )
   static int method3136(class122 var0) {
      int var1 = var0.method2713(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2713(5);
      } else if(var1 == 2) {
         var2 = var0.method2713(8);
      } else {
         var2 = var0.method2713(11);
      }

      return var2;
   }
}

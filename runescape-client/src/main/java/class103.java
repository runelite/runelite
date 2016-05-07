import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class103 extends class204 {
   @ObfuscatedName("s")
   class88[] field1778;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1924597173
   )
   static int field1779;
   @ObfuscatedName("j")
   public static class167 field1782;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIILclass86;[Lclass108;B)V",
      garbageValue = "53"
   )
   static final void method2271(byte[] var0, int var1, int var2, class86 var3, class108[] var4) {
      class119 var5 = new class119(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2505();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2505();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2492();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var1 + var11;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if(2 == (class5.field90[1][var16][var17] & 2)) {
                  var18 = var12 - 1;
               }

               class108 var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class161.method3164(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZ)V",
      garbageValue = "0"
   )
   public class103(class167 var1, class167 var2, int var3, boolean var4) {
      class199 var5 = new class199();
      int var6 = var1.method3249(var3);
      this.field1778 = new class88[var6];
      int[] var7 = var1.method3281(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method3239(var3, var7[var8]);
         class102 var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(class102 var12 = (class102)var5.method3812(); var12 != null; var12 = (class102)var5.method3817()) {
            if(var11 == var12.field1770) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method3283(var11, 0);
            var10 = new class102(var11, var13);
            var5.method3807(var10);
         }

         this.field1778[var7[var8]] = new class88(var9, var10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
      garbageValue = "0"
   )
   public static void method2275(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class138.field2147.startsWith("win")) {
            class21.method566(var0, 0, "openjs");
            return;
         }

         if(class138.field2147.startsWith("mac")) {
            class21.method566(var0, 1, var2);
            return;
         }

         class21.method566(var0, 2, "openjs");
      } else {
         class21.method566(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1440243828"
   )
   static final void method2276() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var6;
      int var29;
      int var30;
      if(18 == client.field326) {
         var0 = client.field324.method2520();
         var1 = var0 >> 2;
         var2 = var0 & 3;
         var3 = client.field343[var1];
         var29 = client.field324.method2492();
         var30 = (var29 >> 4 & 7) + class134.field2089;
         var6 = (var29 & 7) + class45.field1046;
         if(var30 >= 0 && var6 >= 0 && var30 < 104 && var6 < 104) {
            class130.method2818(class21.field581, var30, var6, var3, -1, var1, var2, 0, -1);
         }

      } else {
         class28 var32;
         if(97 == client.field326) {
            var0 = client.field324.method2526();
            var1 = client.field324.method2613();
            var2 = (var1 >> 4 & 7) + class134.field2089;
            var3 = (var1 & 7) + class45.field1046;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               class199 var33 = client.field345[class21.field581][var2][var3];
               if(var33 != null) {
                  for(var32 = (class28)var33.method3812(); null != var32; var32 = (class28)var33.method3817()) {
                     if((var0 & 32767) == var32.field686) {
                        var32.method3898();
                        break;
                     }
                  }

                  if(var33.method3812() == null) {
                     client.field345[class21.field581][var2][var3] = null;
                  }

                  class12.method161(var2, var3);
               }
            }

         } else {
            int var7;
            int var9;
            if(78 == client.field326) {
               var0 = client.field324.method2613();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field343[var1];
               var29 = client.field324.method2533();
               var30 = client.field324.method2492();
               var6 = (var30 >> 4 & 7) + class134.field2089;
               var7 = (var30 & 7) + class45.field1046;
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(0 == var3) {
                     class87 var36 = client.field339.method1980(class21.field581, var6, var7);
                     if(var36 != null) {
                        var9 = var36.field1535 >> 14 & 32767;
                        if(var1 == 2) {
                           var36.field1542 = new class12(var9, 2, 4 + var2, class21.field581, var6, var7, var29, false, var36.field1542);
                           var36.field1543 = new class12(var9, 2, var2 + 1 & 3, class21.field581, var6, var7, var29, false, var36.field1543);
                        } else {
                           var36.field1542 = new class12(var9, var1, var2, class21.field581, var6, var7, var29, false, var36.field1542);
                        }
                     }
                  }

                  if(var3 == 1) {
                     class94 var37 = client.field339.method1918(class21.field581, var6, var7);
                     if(var37 != null) {
                        var9 = var37.field1619 >> 14 & 32767;
                        if(var1 != 4 && 5 != var1) {
                           if(var1 == 6) {
                              var37.field1617 = new class12(var9, 4, var2 + 4, class21.field581, var6, var7, var29, false, var37.field1617);
                           } else if(var1 == 7) {
                              var37.field1617 = new class12(var9, 4, 4 + (var2 + 2 & 3), class21.field581, var6, var7, var29, false, var37.field1617);
                           } else if(var1 == 8) {
                              var37.field1617 = new class12(var9, 4, 4 + var2, class21.field581, var6, var7, var29, false, var37.field1617);
                              var37.field1622 = new class12(var9, 4, 4 + (2 + var2 & 3), class21.field581, var6, var7, var29, false, var37.field1622);
                           }
                        } else {
                           var37.field1617 = new class12(var9, 4, var2, class21.field581, var6, var7, var29, false, var37.field1617);
                        }
                     }
                  }

                  if(var3 == 2) {
                     class98 var38 = client.field339.method1919(class21.field581, var6, var7);
                     if(11 == var1) {
                        var1 = 10;
                     }

                     if(var38 != null) {
                        var38.field1672 = new class12(var38.field1668 >> 14 & 32767, var1, var2, class21.field581, var6, var7, var29, false, var38.field1672);
                     }
                  }

                  if(var3 == 3) {
                     class93 var39 = client.field339.method1902(class21.field581, var6, var7);
                     if(var39 != null) {
                        var39.field1601 = new class12(var39.field1602 >> 14 & 32767, 22, var2, class21.field581, var6, var7, var29, false, var39.field1601);
                     }
                  }
               }

            } else {
               int var8;
               int var10;
               if(83 == client.field326) {
                  var0 = client.field324.method2527();
                  var1 = client.field324.method2518();
                  var2 = class134.field2089 + (var1 >> 4 & 7);
                  var3 = class45.field1046 + (var1 & 7);
                  byte var4 = client.field324.method2521();
                  byte var5 = client.field324.method2522();
                  var6 = client.field324.method2613();
                  var7 = var6 >> 2;
                  var8 = var6 & 3;
                  var9 = client.field343[var7];
                  var10 = client.field324.method2526();
                  byte var11 = client.field324.method2522();
                  byte var12 = client.field324.method2684();
                  int var13 = client.field324.method2584();
                  int var14 = client.field324.method2527();
                  class2 var15;
                  if(var10 == client.field291) {
                     var15 = class106.field1881;
                  } else {
                     var15 = client.field491[var10];
                  }

                  if(null != var15) {
                     class40 var16 = class9.method120(var14);
                     int var17;
                     int var18;
                     if(1 != var8 && 3 != var8) {
                        var17 = var16.field939;
                        var18 = var16.field966;
                     } else {
                        var17 = var16.field966;
                        var18 = var16.field939;
                     }

                     int var19 = var2 + (var17 >> 1);
                     int var20 = var2 + (var17 + 1 >> 1);
                     int var21 = var3 + (var18 >> 1);
                     int var22 = (1 + var18 >> 1) + var3;
                     int[][] var23 = class5.field93[class21.field581];
                     int var24 = var23[var19][var22] + var23[var19][var21] + var23[var20][var21] + var23[var20][var22] >> 2;
                     int var25 = (var17 << 6) + (var2 << 7);
                     int var26 = (var3 << 7) + (var18 << 6);
                     class105 var27 = var16.method780(var7, var8, var23, var25, var24, var26);
                     if(null != var27) {
                        class130.method2818(class21.field581, var2, var3, var9, -1, 0, 0, 1 + var0, 1 + var13);
                        var15.field51 = client.field335 + var0;
                        var15.field56 = var13 + client.field335;
                        var15.field54 = var27;
                        var15.field44 = var17 * 64 + 128 * var2;
                        var15.field46 = 64 * var18 + 128 * var3;
                        var15.field45 = var24;
                        byte var28;
                        if(var11 > var4) {
                           var28 = var11;
                           var11 = var4;
                           var4 = var28;
                        }

                        if(var12 > var5) {
                           var28 = var12;
                           var12 = var5;
                           var5 = var28;
                        }

                        var15.field48 = var2 + var11;
                        var15.field47 = var4 + var2;
                        var15.field38 = var12 + var3;
                        var15.field33 = var3 + var5;
                     }
                  }
               }

               if(client.field326 == 239) {
                  var0 = client.field324.method2492();
                  var1 = (var0 >> 4 & 7) + class134.field2089;
                  var2 = (var0 & 7) + class45.field1046;
                  var3 = client.field324.method2584();
                  var29 = client.field324.method2492();
                  var30 = client.field324.method2584();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = 128 * var2 + 64;
                     class29 var34 = new class29(var3, class21.field581, var1, var2, class107.method2369(var1, var2, class21.field581) - var29, var30, client.field335);
                     client.field413.method3807(var34);
                  }

               } else if(client.field326 == 199) {
                  var0 = client.field324.method2518();
                  var1 = class134.field2089 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class45.field1046;
                  var3 = client.field324.method2584();
                  var29 = client.field324.method2533();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var32 = new class28();
                     var32.field686 = var3;
                     var32.field680 = var29;
                     if(client.field345[class21.field581][var1][var2] == null) {
                        client.field345[class21.field581][var1][var2] = new class199();
                     }

                     client.field345[class21.field581][var1][var2].method3807(var32);
                     class12.method161(var1, var2);
                  }

               } else if(client.field326 == 140) {
                  var0 = client.field324.method2492();
                  var1 = (var0 >> 4 & 7) + class134.field2089;
                  var2 = (var0 & 7) + class45.field1046;
                  var3 = var1 + client.field324.method2493();
                  var29 = var2 + client.field324.method2493();
                  var30 = client.field324.method2495();
                  var6 = client.field324.method2584();
                  var7 = client.field324.method2492() * 4;
                  var8 = client.field324.method2492() * 4;
                  var9 = client.field324.method2584();
                  var10 = client.field324.method2584();
                  int var40 = client.field324.method2492();
                  int var41 = client.field324.method2492();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var29 >= 0 && var3 < 104 && var29 < 104 && var6 != '\uffff') {
                     var1 = 128 * var1 + 64;
                     var2 = 64 + 128 * var2;
                     var3 = 128 * var3 + 64;
                     var29 = var29 * 128 + 64;
                     class6 var42 = new class6(var6, class21.field581, var1, var2, class107.method2369(var1, var2, class21.field581) - var7, var9 + client.field335, var10 + client.field335, var40, var41, var30, var8);
                     var42.method91(var3, var29, class107.method2369(var3, var29, class21.field581) - var8, client.field335 + var9);
                     client.field414.method3807(var42);
                  }

               } else if(49 == client.field326) {
                  var0 = client.field324.method2520();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = client.field343[var1];
                  var29 = client.field324.method2527();
                  var30 = client.field324.method2492();
                  var6 = class134.field2089 + (var30 >> 4 & 7);
                  var7 = (var30 & 7) + class45.field1046;
                  if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                     class130.method2818(class21.field581, var6, var7, var3, var29, var1, var2, 0, -1);
                  }

               } else {
                  if(client.field326 == 223) {
                     var0 = client.field324.method2492();
                     var1 = class134.field2089 + (var0 >> 4 & 7);
                     var2 = class45.field1046 + (var0 & 7);
                     var3 = client.field324.method2584();
                     var29 = client.field324.method2492();
                     var30 = var29 >> 4 & 15;
                     var6 = var29 & 7;
                     var7 = client.field324.method2492();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var8 = 1 + var30;
                        if(class106.field1881.field866[0] >= var1 - var8 && class106.field1881.field866[0] <= var1 + var8 && class106.field1881.field863[0] >= var2 - var8 && class106.field1881.field863[0] <= var8 + var2 && client.field520 != 0 && var6 > 0 && client.field521 < 50) {
                           client.field537[client.field521] = var3;
                           client.field523[client.field521] = var6;
                           client.field524[client.field521] = var7;
                           client.field526[client.field521] = null;
                           client.field407[client.field521] = var30 + (var2 << 8) + (var1 << 16);
                           ++client.field521;
                        }
                     }
                  }

                  if(client.field326 == 54) {
                     var0 = client.field324.method2492();
                     var1 = (var0 >> 4 & 7) + class134.field2089;
                     var2 = (var0 & 7) + class45.field1046;
                     var3 = client.field324.method2584();
                     var29 = client.field324.method2584();
                     var30 = client.field324.method2584();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        class199 var31 = client.field345[class21.field581][var1][var2];
                        if(null != var31) {
                           for(class28 var35 = (class28)var31.method3812(); var35 != null; var35 = (class28)var31.method3817()) {
                              if((var3 & 32767) == var35.field686 && var29 == var35.field680) {
                                 var35.field680 = var30;
                                 break;
                              }
                           }

                           class12.method161(var1, var2);
                        }
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-866569000"
   )
   public static void method2277() {
      try {
         if(class183.field2973 == 1) {
            int var0 = class183.field2972.method3579();
            if(var0 > 0 && class183.field2972.method3585()) {
               var0 -= class183.field2976;
               if(var0 < 0) {
                  var0 = 0;
               }

               class183.field2972.method3578(var0);
               return;
            }

            class183.field2972.method3584();
            class183.field2972.method3690();
            if(null != class183.field2974) {
               class183.field2973 = 2;
            } else {
               class183.field2973 = 0;
            }

            class9.field162 = null;
            class183.field2975 = null;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2972.method3584();
         class183.field2973 = 0;
         class9.field162 = null;
         class183.field2975 = null;
         class183.field2974 = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean method2278(int var1) {
      return this.field1778[var1].field1554;
   }
}

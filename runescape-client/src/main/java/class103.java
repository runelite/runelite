import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Frames")
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
      int var4;
      int var5;
      int var6;
      if(18 == client.field326) {
         var0 = client.field324.method2520();
         var1 = var0 >> 2;
         var2 = var0 & 3;
         var3 = client.field343[var1];
         var5 = client.field324.method2492();
         var6 = (var5 >> 4 & 7) + class134.field2089;
         var4 = (var5 & 7) + class45.field1046;
         if(var6 >= 0 && var4 >= 0 && var6 < 104 && var4 < 104) {
            class130.method2818(class21.field581, var6, var4, var3, -1, var1, var2, 0, -1);
         }
      } else {
         class28 var7;
         if(97 == client.field326) {
            var0 = client.field324.method2526();
            var1 = client.field324.method2613();
            var2 = (var1 >> 4 & 7) + class134.field2089;
            var3 = (var1 & 7) + class45.field1046;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               class199 var8 = client.field345[class21.field581][var2][var3];
               if(var8 != null) {
                  for(var7 = (class28)var8.method3812(); null != var7; var7 = (class28)var8.method3817()) {
                     if((var0 & 32767) == var7.field686) {
                        var7.method3898();
                        break;
                     }
                  }

                  if(var8.method3812() == null) {
                     client.field345[class21.field581][var2][var3] = null;
                  }

                  class12.method161(var2, var3);
               }
            }
         } else {
            int var9;
            int var32;
            if(78 == client.field326) {
               var0 = client.field324.method2613();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field343[var1];
               var5 = client.field324.method2533();
               var6 = client.field324.method2492();
               var4 = (var6 >> 4 & 7) + class134.field2089;
               var32 = (var6 & 7) + class45.field1046;
               if(var4 >= 0 && var32 >= 0 && var4 < 103 && var32 < 103) {
                  if(0 == var3) {
                     class87 var10 = client.field339.method1980(class21.field581, var4, var32);
                     if(var10 != null) {
                        var9 = var10.field1535 >> 14 & 32767;
                        if(var1 == 2) {
                           var10.field1542 = new class12(var9, 2, 4 + var2, class21.field581, var4, var32, var5, false, var10.field1542);
                           var10.field1543 = new class12(var9, 2, var2 + 1 & 3, class21.field581, var4, var32, var5, false, var10.field1543);
                        } else {
                           var10.field1542 = new class12(var9, var1, var2, class21.field581, var4, var32, var5, false, var10.field1542);
                        }
                     }
                  }

                  if(var3 == 1) {
                     class94 var33 = client.field339.method1918(class21.field581, var4, var32);
                     if(var33 != null) {
                        var9 = var33.field1619 >> 14 & 32767;
                        if(var1 != 4 && 5 != var1) {
                           if(var1 == 6) {
                              var33.field1617 = new class12(var9, 4, var2 + 4, class21.field581, var4, var32, var5, false, var33.field1617);
                           } else if(var1 == 7) {
                              var33.field1617 = new class12(var9, 4, 4 + (var2 + 2 & 3), class21.field581, var4, var32, var5, false, var33.field1617);
                           } else if(var1 == 8) {
                              var33.field1617 = new class12(var9, 4, 4 + var2, class21.field581, var4, var32, var5, false, var33.field1617);
                              var33.field1622 = new class12(var9, 4, 4 + (2 + var2 & 3), class21.field581, var4, var32, var5, false, var33.field1622);
                           }
                        } else {
                           var33.field1617 = new class12(var9, 4, var2, class21.field581, var4, var32, var5, false, var33.field1617);
                        }
                     }
                  }

                  if(var3 == 2) {
                     class98 var34 = client.field339.method1919(class21.field581, var4, var32);
                     if(11 == var1) {
                        var1 = 10;
                     }

                     if(var34 != null) {
                        var34.field1672 = new class12(var34.field1668 >> 14 & 32767, var1, var2, class21.field581, var4, var32, var5, false, var34.field1672);
                     }
                  }

                  if(var3 == 3) {
                     class93 var35 = client.field339.method1902(class21.field581, var4, var32);
                     if(var35 != null) {
                        var35.field1601 = new class12(var35.field1602 >> 14 & 32767, 22, var2, class21.field581, var4, var32, var5, false, var35.field1601);
                     }
                  }
               }
            } else {
               int var11;
               int var36;
               if(83 == client.field326) {
                  var0 = client.field324.method2527();
                  var1 = client.field324.method2518();
                  var2 = class134.field2089 + (var1 >> 4 & 7);
                  var3 = class45.field1046 + (var1 & 7);
                  byte var12 = client.field324.method2521();
                  byte var13 = client.field324.method2522();
                  var4 = client.field324.method2613();
                  var32 = var4 >> 2;
                  var36 = var4 & 3;
                  var9 = client.field343[var32];
                  var11 = client.field324.method2526();
                  byte var14 = client.field324.method2522();
                  byte var15 = client.field324.method2684();
                  int var16 = client.field324.method2584();
                  int var17 = client.field324.method2527();
                  class2 var18;
                  if(var11 == client.field291) {
                     var18 = class106.field1881;
                  } else {
                     var18 = client.field491[var11];
                  }

                  if(null != var18) {
                     class40 var19 = class9.method120(var17);
                     int var20;
                     int var21;
                     if(1 != var36 && 3 != var36) {
                        var20 = var19.field939;
                        var21 = var19.field966;
                     } else {
                        var20 = var19.field966;
                        var21 = var19.field939;
                     }

                     int var22 = var2 + (var20 >> 1);
                     int var23 = var2 + (var20 + 1 >> 1);
                     int var24 = var3 + (var21 >> 1);
                     int var25 = (1 + var21 >> 1) + var3;
                     int[][] var26 = class5.field93[class21.field581];
                     int var27 = var26[var22][var25] + var26[var22][var24] + var26[var23][var24] + var26[var23][var25] >> 2;
                     int var28 = (var20 << 6) + (var2 << 7);
                     int var29 = (var3 << 7) + (var21 << 6);
                     class105 var30 = var19.method780(var32, var36, var26, var28, var27, var29);
                     if(null != var30) {
                        class130.method2818(class21.field581, var2, var3, var9, -1, 0, 0, 1 + var0, 1 + var16);
                        var18.field51 = client.field335 + var0;
                        var18.field56 = var16 + client.field335;
                        var18.field54 = var30;
                        var18.field44 = var20 * 64 + 128 * var2;
                        var18.field46 = 64 * var21 + 128 * var3;
                        var18.field45 = var27;
                        byte var31;
                        if(var14 > var12) {
                           var31 = var14;
                           var14 = var12;
                           var12 = var31;
                        }

                        if(var15 > var13) {
                           var31 = var15;
                           var15 = var13;
                           var13 = var31;
                        }

                        var18.field48 = var2 + var14;
                        var18.field47 = var12 + var2;
                        var18.field38 = var15 + var3;
                        var18.field33 = var3 + var13;
                     }
                  }
               }

               if(client.field326 == 239) {
                  var0 = client.field324.method2492();
                  var1 = (var0 >> 4 & 7) + class134.field2089;
                  var2 = (var0 & 7) + class45.field1046;
                  var3 = client.field324.method2584();
                  var5 = client.field324.method2492();
                  var6 = client.field324.method2584();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = 128 * var2 + 64;
                     class29 var37 = new class29(var3, class21.field581, var1, var2, class107.method2369(var1, var2, class21.field581) - var5, var6, client.field335);
                     client.field413.method3807(var37);
                  }
               } else if(client.field326 == 199) {
                  var0 = client.field324.method2518();
                  var1 = class134.field2089 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class45.field1046;
                  var3 = client.field324.method2584();
                  var5 = client.field324.method2533();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var7 = new class28();
                     var7.field686 = var3;
                     var7.field680 = var5;
                     if(client.field345[class21.field581][var1][var2] == null) {
                        client.field345[class21.field581][var1][var2] = new class199();
                     }

                     client.field345[class21.field581][var1][var2].method3807(var7);
                     class12.method161(var1, var2);
                  }
               } else if(client.field326 == 140) {
                  var0 = client.field324.method2492();
                  var1 = (var0 >> 4 & 7) + class134.field2089;
                  var2 = (var0 & 7) + class45.field1046;
                  var3 = var1 + client.field324.method2493();
                  var5 = var2 + client.field324.method2493();
                  var6 = client.field324.method2495();
                  var4 = client.field324.method2584();
                  var32 = client.field324.method2492() * 4;
                  var36 = client.field324.method2492() * 4;
                  var9 = client.field324.method2584();
                  var11 = client.field324.method2584();
                  int var38 = client.field324.method2492();
                  int var40 = client.field324.method2492();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var5 >= 0 && var3 < 104 && var5 < 104 && var4 != '\uffff') {
                     var1 = 128 * var1 + 64;
                     var2 = 64 + 128 * var2;
                     var3 = 128 * var3 + 64;
                     var5 = var5 * 128 + 64;
                     class6 var42 = new class6(var4, class21.field581, var1, var2, class107.method2369(var1, var2, class21.field581) - var32, var9 + client.field335, var11 + client.field335, var38, var40, var6, var36);
                     var42.method91(var3, var5, class107.method2369(var3, var5, class21.field581) - var36, client.field335 + var9);
                     client.field414.method3807(var42);
                  }
               } else if(49 == client.field326) {
                  var0 = client.field324.method2520();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = client.field343[var1];
                  var5 = client.field324.method2527();
                  var6 = client.field324.method2492();
                  var4 = class134.field2089 + (var6 >> 4 & 7);
                  var32 = (var6 & 7) + class45.field1046;
                  if(var4 >= 0 && var32 >= 0 && var4 < 104 && var32 < 104) {
                     class130.method2818(class21.field581, var4, var32, var3, var5, var1, var2, 0, -1);
                  }
               } else {
                  if(client.field326 == 223) {
                     var0 = client.field324.method2492();
                     var1 = class134.field2089 + (var0 >> 4 & 7);
                     var2 = class45.field1046 + (var0 & 7);
                     var3 = client.field324.method2584();
                     var5 = client.field324.method2492();
                     var6 = var5 >> 4 & 15;
                     var4 = var5 & 7;
                     var32 = client.field324.method2492();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var36 = 1 + var6;
                        if(class106.field1881.field866[0] >= var1 - var36 && class106.field1881.field866[0] <= var1 + var36 && class106.field1881.field863[0] >= var2 - var36 && class106.field1881.field863[0] <= var36 + var2 && client.field520 != 0 && var4 > 0 && client.field521 < 50) {
                           client.field537[client.field521] = var3;
                           client.field523[client.field521] = var4;
                           client.field524[client.field521] = var32;
                           client.field526[client.field521] = null;
                           client.field407[client.field521] = var6 + (var2 << 8) + (var1 << 16);
                           ++client.field521;
                        }
                     }
                  }

                  if(client.field326 == 54) {
                     var0 = client.field324.method2492();
                     var1 = (var0 >> 4 & 7) + class134.field2089;
                     var2 = (var0 & 7) + class45.field1046;
                     var3 = client.field324.method2584();
                     var5 = client.field324.method2584();
                     var6 = client.field324.method2584();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        class199 var39 = client.field345[class21.field581][var1][var2];
                        if(null != var39) {
                           for(class28 var41 = (class28)var39.method3812(); var41 != null; var41 = (class28)var39.method3817()) {
                              if((var3 & 32767) == var41.field686 && var5 == var41.field680) {
                                 var41.field680 = var6;
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

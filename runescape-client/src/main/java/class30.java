import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class30 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1377205605
   )
   int field684;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -26446229
   )
   int field686;
   @ObfuscatedName("x")
   String field687;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1036390149
   )
   int field689;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -251563919
   )
   int field691;
   @ObfuscatedName("g")
   public static String field693;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = -2860802612614860861L
   )
   static long field694;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "2103644125"
   )
   static char method658(char var0) {
      return (char)(198 == var0?'E':(var0 == 230?'e':(223 == var0?'s':(338 == var0?'E':(339 == var0?'e':'\u0000')))));
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "336200276"
   )
   static boolean method659(class173 var0) {
      if(client.field443) {
         if(class144.method3075(var0) != 0) {
            return false;
         }

         if(0 == var0.field2820) {
            return false;
         }
      }

      return var0.field2759;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-994587156"
   )
   public static void method660() {
      try {
         File var0 = new File(class89.field1529, "random.dat");
         int var2;
         if(var0.exists()) {
            class149.field2215 = new class228(new class227(var0, "rw", 25L), 24, 0);
         } else {
            label39:
            for(int var1 = 0; var1 < class124.field2007.length; ++var1) {
               for(var2 = 0; var2 < class19.field268.length; ++var2) {
                  File var3 = new File(class19.field268[var2] + class124.field2007[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class149.field2215 = new class228(new class227(var3, "rw", 25L), 24, 0);
                     break label39;
                  }
               }
            }
         }

         if(null == class149.field2215) {
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var2 = var5.read();
            var5.seek(0L);
            var5.write(var2);
            var5.seek(0L);
            var5.close();
            class149.field2215 = new class228(new class227(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
         ;
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-735439247"
   )
   static final void method661() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(212 == client.field322) {
         var0 = client.field320.method2500();
         var1 = (var0 >> 4 & 7) + class1.field30;
         var2 = (var0 & 7) + class152.field2247;
         var3 = client.field320.method2536();
         var4 = client.field320.method2500();
         var5 = var4 >> 2;
         var6 = var4 & 3;
         var7 = client.field414[var5];
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class19.method242(class28.field655, var1, var2, var7, var3, var5, var6, 0, -1);
         }

      } else if(client.field322 == 169) {
         var0 = client.field320.method2500();
         var1 = (var0 >> 4 & 7) + class1.field30;
         var2 = (var0 & 7) + class152.field2247;
         var3 = client.field320.method2502();
         var4 = client.field320.method2500();
         var5 = client.field320.method2502();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var1 = 128 * var1 + 64;
            var2 = var2 * 128 + 64;
            class29 var37 = new class29(var3, class28.field655, var1, var2, class148.method3106(var1, var2, class28.field655) - var4, var5, client.field285);
            client.field454.method3779(var37);
         }

      } else if(client.field322 == 174) {
         var0 = client.field320.method2526();
         var1 = (var0 >> 4 & 7) + class1.field30;
         var2 = class152.field2247 + (var0 & 7);
         var3 = client.field320.method2526();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = client.field414[var4];
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            class19.method242(class28.field655, var1, var2, var6, -1, var4, var5, 0, -1);
         }

      } else {
         int var8;
         if(138 == client.field322) {
            var0 = client.field320.method2500();
            var1 = class1.field30 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class152.field2247;
            var3 = client.field320.method2502();
            var4 = client.field320.method2500();
            var5 = var4 >> 4 & 15;
            var6 = var4 & 7;
            var7 = client.field320.method2500();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var8 = 1 + var5;
               if(class47.field1053.field848[0] >= var1 - var8 && class47.field1053.field848[0] <= var8 + var1 && class47.field1053.field822[0] >= var2 - var8 && class47.field1053.field822[0] <= var2 + var8 && 0 != client.field514 && var6 > 0 && client.field515 < 50) {
                  client.field439[client.field515] = var3;
                  client.field460[client.field515] = var6;
                  client.field518[client.field515] = var7;
                  client.field543[client.field515] = null;
                  client.field519[client.field515] = (var1 << 16) + (var2 << 8) + var5;
                  ++client.field515;
               }
            }
         }

         int var9;
         int var10;
         int var11;
         int var12;
         if(client.field322 == 56) {
            var0 = client.field320.method2500();
            var1 = (var0 >> 4 & 7) + class1.field30;
            var2 = class152.field2247 + (var0 & 7);
            var3 = var1 + client.field320.method2670();
            var4 = var2 + client.field320.method2670();
            var5 = client.field320.method2501();
            var6 = client.field320.method2502();
            var7 = client.field320.method2500() * 4;
            var8 = client.field320.method2500() * 4;
            var9 = client.field320.method2502();
            var10 = client.field320.method2502();
            var11 = client.field320.method2500();
            var12 = client.field320.method2500();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
               var1 = 64 + var1 * 128;
               var2 = 64 + 128 * var2;
               var3 = var3 * 128 + 64;
               var4 = 64 + var4 * 128;
               class6 var42 = new class6(var6, class28.field655, var1, var2, class148.method3106(var1, var2, class28.field655) - var7, var9 + client.field285, var10 + client.field285, var11, var12, var5, var8);
               var42.method89(var3, var4, class148.method3106(var3, var4, class28.field655) - var8, client.field285 + var9);
               client.field408.method3779(var42);
            }

         } else if(client.field322 == 206) {
            var0 = client.field320.method2500();
            var1 = class1.field30 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class152.field2247;
            var3 = client.field320.method2502();
            var4 = client.field320.method2502();
            var5 = client.field320.method2502();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class199 var34 = client.field364[class28.field655][var1][var2];
               if(var34 != null) {
                  for(class28 var35 = (class28)var34.method3784(); null != var35; var35 = (class28)var34.method3777()) {
                     if((var3 & 32767) == var35.field662 && var4 == var35.field658) {
                        var35.field658 = var5;
                        break;
                     }
                  }

                  class11.method156(var1, var2);
               }
            }

         } else {
            class28 var33;
            if(client.field322 == 32) {
               var0 = client.field320.method2526();
               var1 = class1.field30 + (var0 >> 4 & 7);
               var2 = (var0 & 7) + class152.field2247;
               var3 = client.field320.method2536();
               var4 = client.field320.method2502();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var33 = new class28();
                  var33.field662 = var3;
                  var33.field658 = var4;
                  if(client.field364[class28.field655][var1][var2] == null) {
                     client.field364[class28.field655][var1][var2] = new class199();
                  }

                  client.field364[class28.field655][var1][var2].method3779(var33);
                  class11.method156(var1, var2);
               }

            } else if(165 == client.field322) {
               var0 = client.field320.method2536();
               var1 = client.field320.method2500();
               var2 = (var1 >> 4 & 7) + class1.field30;
               var3 = class152.field2247 + (var1 & 7);
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  class199 var31 = client.field364[class28.field655][var2][var3];
                  if(var31 != null) {
                     for(var33 = (class28)var31.method3784(); var33 != null; var33 = (class28)var31.method3777()) {
                        if((var0 & 32767) == var33.field662) {
                           var33.method3883();
                           break;
                        }
                     }

                     if(var31.method3784() == null) {
                        client.field364[class28.field655][var2][var3] = null;
                     }

                     class11.method156(var2, var3);
                  }
               }

            } else if(client.field322 == 105) {
               var0 = client.field320.method2527();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field414[var1];
               var4 = client.field320.method2502();
               var5 = client.field320.method2663();
               var6 = (var5 >> 4 & 7) + class1.field30;
               var7 = class152.field2247 + (var5 & 7);
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(var3 == 0) {
                     class87 var38 = class35.field771.method2024(class28.field655, var6, var7);
                     if(var38 != null) {
                        var9 = var38.field1510 >> 14 & 32767;
                        if(var1 == 2) {
                           var38.field1511 = new class12(var9, 2, 4 + var2, class28.field655, var6, var7, var4, false, var38.field1511);
                           var38.field1512 = new class12(var9, 2, 1 + var2 & 3, class28.field655, var6, var7, var4, false, var38.field1512);
                        } else {
                           var38.field1511 = new class12(var9, var1, var2, class28.field655, var6, var7, var4, false, var38.field1511);
                        }
                     }
                  }

                  if(1 == var3) {
                     class94 var39 = class35.field771.method1928(class28.field655, var6, var7);
                     if(var39 != null) {
                        var9 = var39.field1595 >> 14 & 32767;
                        if(var1 != 4 && 5 != var1) {
                           if(6 == var1) {
                              var39.field1593 = new class12(var9, 4, 4 + var2, class28.field655, var6, var7, var4, false, var39.field1593);
                           } else if(7 == var1) {
                              var39.field1593 = new class12(var9, 4, (2 + var2 & 3) + 4, class28.field655, var6, var7, var4, false, var39.field1593);
                           } else if(var1 == 8) {
                              var39.field1593 = new class12(var9, 4, 4 + var2, class28.field655, var6, var7, var4, false, var39.field1593);
                              var39.field1594 = new class12(var9, 4, (2 + var2 & 3) + 4, class28.field655, var6, var7, var4, false, var39.field1594);
                           }
                        } else {
                           var39.field1593 = new class12(var9, 4, var2, class28.field655, var6, var7, var4, false, var39.field1593);
                        }
                     }
                  }

                  if(2 == var3) {
                     class98 var40 = class35.field771.method1929(class28.field655, var6, var7);
                     if(var1 == 11) {
                        var1 = 10;
                     }

                     if(var40 != null) {
                        var40.field1640 = new class12(var40.field1648 >> 14 & 32767, var1, var2, class28.field655, var6, var7, var4, false, var40.field1640);
                     }
                  }

                  if(3 == var3) {
                     class93 var41 = class35.field771.method1930(class28.field655, var6, var7);
                     if(var41 != null) {
                        var41.field1576 = new class12(var41.field1577 >> 14 & 32767, 22, var2, class28.field655, var6, var7, var4, false, var41.field1576);
                     }
                  }
               }

            } else {
               if(client.field322 == 109) {
                  var0 = client.field320.method2536();
                  var1 = client.field320.method2527();
                  var2 = class1.field30 + (var1 >> 4 & 7);
                  var3 = class152.field2247 + (var1 & 7);
                  byte var29 = client.field320.method2521();
                  byte var30 = client.field320.method2529();
                  byte var32 = client.field320.method2528();
                  var7 = client.field320.method2536();
                  byte var36 = client.field320.method2670();
                  var9 = client.field320.method2535();
                  var10 = client.field320.method2527();
                  var11 = var10 >> 2;
                  var12 = var10 & 3;
                  int var13 = client.field414[var11];
                  int var14 = client.field320.method2502();
                  class2 var15;
                  if(var0 == client.field397) {
                     var15 = class47.field1053;
                  } else {
                     var15 = client.field396[var0];
                  }

                  if(null != var15) {
                     class40 var16 = class85.method1903(var9);
                     int var17;
                     int var18;
                     if(var12 != 1 && var12 != 3) {
                        var17 = var16.field920;
                        var18 = var16.field921;
                     } else {
                        var17 = var16.field921;
                        var18 = var16.field920;
                     }

                     int var19 = (var17 >> 1) + var2;
                     int var20 = var2 + (1 + var17 >> 1);
                     int var21 = var3 + (var18 >> 1);
                     int var22 = (var18 + 1 >> 1) + var3;
                     int[][] var23 = class5.field91[class28.field655];
                     int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
                     int var25 = (var2 << 7) + (var17 << 6);
                     int var26 = (var3 << 7) + (var18 << 6);
                     class105 var27 = var16.method801(var11, var12, var23, var25, var24, var26);
                     if(null != var27) {
                        class19.method242(class28.field655, var2, var3, var13, -1, 0, 0, 1 + var14, 1 + var7);
                        var15.field44 = var14 + client.field285;
                        var15.field45 = var7 + client.field285;
                        var15.field49 = var27;
                        var15.field46 = 64 * var17 + var2 * 128;
                        var15.field48 = 128 * var3 + var18 * 64;
                        var15.field54 = var24;
                        byte var28;
                        if(var29 > var32) {
                           var28 = var29;
                           var29 = var32;
                           var32 = var28;
                        }

                        if(var30 > var36) {
                           var28 = var30;
                           var30 = var36;
                           var36 = var28;
                        }

                        var15.field50 = var29 + var2;
                        var15.field38 = var2 + var32;
                        var15.field47 = var3 + var30;
                        var15.field53 = var36 + var3;
                     }
                  }
               }

            }
         }
      }
   }
}

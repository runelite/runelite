import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class94 implements class91 {
   @ObfuscatedName("ao")
   static boolean field1617;
   @ObfuscatedName("l")
   class198 field1618 = new class198();
   @ObfuscatedName("f")
   double field1621 = 1.0D;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1750421259
   )
   int field1622 = 0;
   @ObfuscatedName("o")
   class166 field1623;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1182484715
   )
   int field1624;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1979256633
   )
   int field1625 = 128;
   @ObfuscatedName("dp")
   static int[] field1626;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 325669497
   )
   static int field1627;
   @ObfuscatedName("j")
   class82[] field1628;

   @ObfuscatedName("u")
   public void method2141(double var1) {
      this.field1621 = var1;
      this.method2146();
   }

   @ObfuscatedName("j")
   public int[] vmethod2142(int var1) {
      class82 var2 = this.field1628[var1];
      if(null != var2) {
         if(null != var2.field1442) {
            this.field1618.method3769(var2);
            var2.field1450 = true;
            return var2.field1442;
         }

         boolean var3 = var2.method1858(this.field1621, this.field1625, this.field1623);
         if(var3) {
            if(0 == this.field1622) {
               class82 var4 = (class82)this.field1618.method3795();
               var4.method1852();
            } else {
               --this.field1622;
            }

            this.field1618.method3769(var2);
            var2.field1450 = true;
            return var2.field1442;
         }
      }

      return null;
   }

   @ObfuscatedName("i")
   public boolean vmethod2143() {
      return 64 == this.field1625;
   }

   @ObfuscatedName("y")
   public void method2144(int var1) {
      for(int var2 = 0; var2 < this.field1628.length; ++var2) {
         class82 var3 = this.field1628[var2];
         if(var3 != null && var3.field1451 != 0 && var3.field1450) {
            var3.method1853(var1);
            var3.field1450 = false;
         }
      }

   }

   @ObfuscatedName("g")
   public void method2146() {
      for(int var1 = 0; var1 < this.field1628.length; ++var1) {
         if(this.field1628[var1] != null) {
            this.field1628[var1].method1852();
         }
      }

      this.field1618 = new class198();
      this.field1622 = this.field1624;
   }

   public class94(class166 var1, class166 var2, int var3, double var4, int var6) {
      this.field1623 = var2;
      this.field1624 = var3;
      this.field1622 = this.field1624;
      this.field1621 = var4;
      this.field1625 = var6;
      int[] var7 = var1.method3223(0);
      int var8 = var7.length;
      this.field1628 = new class82[var1.method3224(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class118 var10 = new class118(var1.method3214(0, var7[var9]));
         this.field1628[var7[var9]] = new class82(var10);
      }

   }

   @ObfuscatedName("l")
   public int vmethod2157(int var1) {
      return this.field1628[var1] != null?this.field1628[var1].field1445:0;
   }

   @ObfuscatedName("a")
   public boolean vmethod2160(int var1) {
      return this.field1628[var1].field1443;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "255"
   )
   static final void method2162() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(81 == client.field333) {
         var0 = client.field293.method2453();
         var1 = (var0 >> 4 & 7) + class13.field199;
         var2 = (var0 & 7) + class32.field761;
         var3 = client.field293.method2455();
         var4 = client.field293.method2453();
         var5 = var4 >> 4 & 15;
         var6 = var4 & 7;
         var7 = client.field293.method2453();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            var8 = 1 + var5;
            if(class148.field2249.field864[0] >= var1 - var8 && class148.field2249.field864[0] <= var8 + var1 && class148.field2249.field817[0] >= var2 - var8 && class148.field2249.field817[0] <= var8 + var2 && 0 != client.field502 && var6 > 0 && client.field530 < 50) {
               client.field531[client.field530] = var3;
               client.field532[client.field530] = var6;
               client.field443[client.field530] = var7;
               client.field401[client.field530] = null;
               client.field534[client.field530] = var5 + (var2 << 8) + (var1 << 16);
               ++client.field530;
            }
         }
      }

      int var9;
      if(client.field333 == 1) {
         var0 = client.field293.method2481();
         var1 = (var0 >> 4 & 7) + class13.field199;
         var2 = (var0 & 7) + class32.field761;
         var3 = client.field293.method2571();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = client.field349[var4];
         var7 = client.field293.method2489();
         if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
            if(var6 == 0) {
               class86 var36 = class107.field1906.method1897(class75.field1386, var1, var2);
               if(var36 != null) {
                  var9 = var36.field1532 >> 14 & 32767;
                  if(2 == var4) {
                     var36.field1530 = new class12(var9, 2, var5 + 4, class75.field1386, var1, var2, var7, false, var36.field1530);
                     var36.field1531 = new class12(var9, 2, var5 + 1 & 3, class75.field1386, var1, var2, var7, false, var36.field1531);
                  } else {
                     var36.field1530 = new class12(var9, var4, var5, class75.field1386, var1, var2, var7, false, var36.field1530);
                  }
               }
            }

            if(1 == var6) {
               class93 var38 = class107.field1906.method2044(class75.field1386, var1, var2);
               if(var38 != null) {
                  var9 = var38.field1613 >> 14 & 32767;
                  if(4 != var4 && var4 != 5) {
                     if(var4 == 6) {
                        var38.field1604 = new class12(var9, 4, var5 + 4, class75.field1386, var1, var2, var7, false, var38.field1604);
                     } else if(7 == var4) {
                        var38.field1604 = new class12(var9, 4, (2 + var5 & 3) + 4, class75.field1386, var1, var2, var7, false, var38.field1604);
                     } else if(var4 == 8) {
                        var38.field1604 = new class12(var9, 4, 4 + var5, class75.field1386, var1, var2, var7, false, var38.field1604);
                        var38.field1612 = new class12(var9, 4, 4 + (2 + var5 & 3), class75.field1386, var1, var2, var7, false, var38.field1612);
                     }
                  } else {
                     var38.field1604 = new class12(var9, 4, var5, class75.field1386, var1, var2, var7, false, var38.field1604);
                  }
               }
            }

            if(var6 == 2) {
               class97 var39 = class107.field1906.method1899(class75.field1386, var1, var2);
               if(11 == var4) {
                  var4 = 10;
               }

               if(var39 != null) {
                  var39.field1670 = new class12(var39.field1677 >> 14 & 32767, var4, var5, class75.field1386, var1, var2, var7, false, var39.field1670);
               }
            }

            if(3 == var6) {
               class92 var40 = class107.field1906.method1900(class75.field1386, var1, var2);
               if(null != var40) {
                  var40.field1599 = new class12(var40.field1596 >> 14 & 32767, 22, var5, class75.field1386, var1, var2, var7, false, var40.field1599);
               }
            }
         }

      } else {
         class28 var31;
         if(139 == client.field333) {
            var0 = client.field293.method2455();
            var1 = client.field293.method2487();
            var2 = client.field293.method2486();
            var3 = class13.field199 + (var2 >> 4 & 7);
            var4 = class32.field761 + (var2 & 7);
            if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               var31 = new class28();
               var31.field677 = var0;
               var31.field672 = var1;
               if(client.field420[class75.field1386][var3][var4] == null) {
                  client.field420[class75.field1386][var3][var4] = new class198();
               }

               client.field420[class75.field1386][var3][var4].method3768(var31);
               class107.method2366(var3, var4);
            }

         } else if(30 == client.field333) {
            var0 = client.field293.method2453();
            var1 = class13.field199 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class32.field761;
            var3 = client.field293.method2455();
            var4 = client.field293.method2453();
            var5 = client.field293.method2455();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var1 = 128 * var1 + 64;
               var2 = 64 + var2 * 128;
               class29 var35 = new class29(var3, class75.field1386, var1, var2, class105.method2335(var1, var2, class75.field1386) - var4, var5, client.field394);
               client.field423.method3768(var35);
            }

         } else if(client.field333 == 141) {
            var0 = client.field293.method2453();
            var1 = (var0 >> 4 & 7) + class13.field199;
            var2 = class32.field761 + (var0 & 7);
            var3 = client.field293.method2455();
            var4 = client.field293.method2455();
            var5 = client.field293.method2455();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class198 var34 = client.field420[class75.field1386][var1][var2];
               if(null != var34) {
                  for(class28 var37 = (class28)var34.method3773(); var37 != null; var37 = (class28)var34.method3772()) {
                     if(var37.field677 == (var3 & 32767) && var37.field672 == var4) {
                        var37.field672 = var5;
                        break;
                     }
                  }

                  class107.method2366(var1, var2);
               }
            }

         } else if(44 == client.field333) {
            var0 = client.field293.method2486();
            var1 = (var0 >> 4 & 7) + class13.field199;
            var2 = (var0 & 7) + class32.field761;
            var3 = client.field293.method2481();
            var4 = var3 >> 2;
            var5 = var3 & 3;
            var6 = client.field349[var4];
            var7 = client.field293.method2489();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class120.method2681(class75.field1386, var1, var2, var6, var7, var4, var5, 0, -1);
            }

         } else if(66 == client.field333) {
            var0 = client.field293.method2453();
            var1 = class13.field199 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class32.field761;
            var3 = client.field293.method2487();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class198 var30 = client.field420[class75.field1386][var1][var2];
               if(null != var30) {
                  for(var31 = (class28)var30.method3773(); var31 != null; var31 = (class28)var30.method3772()) {
                     if(var31.field677 == (var3 & 32767)) {
                        var31.method3853();
                        break;
                     }
                  }

                  if(var30.method3773() == null) {
                     client.field420[class75.field1386][var1][var2] = null;
                  }

                  class107.method2366(var1, var2);
               }
            }

         } else if(client.field333 == 60) {
            var0 = client.field293.method2571();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = client.field349[var1];
            var4 = client.field293.method2571();
            var5 = class13.field199 + (var4 >> 4 & 7);
            var6 = class32.field761 + (var4 & 7);
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               class120.method2681(class75.field1386, var5, var6, var3, -1, var1, var2, 0, -1);
            }

         } else {
            int var11;
            int var12;
            if(client.field333 == 210) {
               var0 = client.field293.method2571();
               var1 = var0 >> 2;
               var2 = var0 & 3;
               var3 = client.field349[var1];
               byte var29 = client.field293.method2576();
               var5 = client.field293.method2489();
               byte var32 = client.field293.method2454();
               byte var33 = client.field293.method2482();
               var8 = client.field293.method2489();
               var9 = client.field293.method2455();
               byte var10 = client.field293.method2454();
               var11 = client.field293.method2487();
               var12 = client.field293.method2571();
               int var13 = class13.field199 + (var12 >> 4 & 7);
               int var14 = (var12 & 7) + class32.field761;
               class2 var15;
               if(var5 == client.field477) {
                  var15 = class148.field2249;
               } else {
                  var15 = client.field410[var5];
               }

               if(var15 != null) {
                  class40 var16 = class48.method996(var11);
                  int var17;
                  int var18;
                  if(var2 != 1 && var2 != 3) {
                     var17 = var16.field932;
                     var18 = var16.field933;
                  } else {
                     var17 = var16.field933;
                     var18 = var16.field932;
                  }

                  int var19 = var13 + (var17 >> 1);
                  int var20 = var13 + (1 + var17 >> 1);
                  int var21 = (var18 >> 1) + var14;
                  int var22 = var14 + (1 + var18 >> 1);
                  int[][] var23 = class5.field93[class75.field1386];
                  int var24 = var23[var19][var22] + var23[var20][var21] + var23[var19][var21] + var23[var20][var22] >> 2;
                  int var25 = (var13 << 7) + (var17 << 6);
                  int var26 = (var18 << 6) + (var14 << 7);
                  class104 var27 = var16.method805(var1, var2, var23, var25, var24, var26);
                  if(null != var27) {
                     class120.method2681(class75.field1386, var13, var14, var3, -1, 0, 0, 1 + var8, var9 + 1);
                     var15.field43 = var8 + client.field394;
                     var15.field52 = var9 + client.field394;
                     var15.field47 = var27;
                     var15.field44 = 128 * var13 + 64 * var17;
                     var15.field46 = var18 * 64 + var14 * 128;
                     var15.field45 = var24;
                     byte var28;
                     if(var32 > var10) {
                        var28 = var32;
                        var32 = var10;
                        var10 = var28;
                     }

                     if(var33 > var29) {
                        var28 = var33;
                        var33 = var29;
                        var29 = var28;
                     }

                     var15.field59 = var32 + var13;
                     var15.field50 = var13 + var10;
                     var15.field33 = var14 + var33;
                     var15.field51 = var14 + var29;
                  }
               }
            }

            if(216 == client.field333) {
               var0 = client.field293.method2453();
               var1 = class13.field199 + (var0 >> 4 & 7);
               var2 = class32.field761 + (var0 & 7);
               var3 = var1 + client.field293.method2454();
               var4 = var2 + client.field293.method2454();
               var5 = client.field293.method2558();
               var6 = client.field293.method2455();
               var7 = client.field293.method2453() * 4;
               var8 = client.field293.method2453() * 4;
               var9 = client.field293.method2455();
               int var41 = client.field293.method2455();
               var11 = client.field293.method2453();
               var12 = client.field293.method2453();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && '\uffff' != var6) {
                  var1 = 128 * var1 + 64;
                  var2 = 128 * var2 + 64;
                  var3 = 64 + 128 * var3;
                  var4 = var4 * 128 + 64;
                  class6 var42 = new class6(var6, class75.field1386, var1, var2, class105.method2335(var1, var2, class75.field1386) - var7, var9 + client.field394, client.field394 + var41, var11, var12, var5, var8);
                  var42.method85(var3, var4, class105.method2335(var3, var4, class75.field1386) - var8, client.field394 + var9);
                  client.field422.method3768(var42);
               }

            }
         }
      }
   }
}

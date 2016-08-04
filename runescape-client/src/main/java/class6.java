import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("Projectile")
public final class class6 extends class88 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1584884575
   )
   @Export("startTime")
   int field100;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -708966709
   )
   @Export("floor")
   int field101;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -798056087
   )
   @Export("id")
   int field102;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -623429827
   )
   @Export("z1")
   int field104;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 100148603
   )
   int field105;
   @ObfuscatedName("f")
   @Export("scalar")
   double field106;
   @ObfuscatedName("q")
   @Export("isMoving")
   boolean field107 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 790652441
   )
   int field108;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1211544365
   )
   @Export("interacting")
   int field110;
   @ObfuscatedName("t")
   @Export("animationSequence")
   class44 field111;
   @ObfuscatedName("p")
   @Export("x")
   double field112;
   @ObfuscatedName("w")
   @Export("velocityZ")
   double field113;
   @ObfuscatedName("o")
   @Export("z")
   double field114;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -101337393
   )
   int field115 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 215685155
   )
   @Export("x1")
   int field116;
   @ObfuscatedName("z")
   @Export("velocityY")
   double field117;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -283062119
   )
   @Export("y1")
   int field118;
   @ObfuscatedName("v")
   @Export("az")
   double field119;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1786955333
   )
   int field120;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1772374343
   )
   int field121;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1717330259
   )
   @Export("start")
   int field122;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -647281841
   )
   int field123 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1205955213
   )
   int field124;
   @ObfuscatedName("d")
   double field126;
   @ObfuscatedName("nf")
   static class59 field127;
   @ObfuscatedName("i")
   @Export("velocityX")
   double field129;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-73"
   )
   public static void method92() {
      class56.field1231.method3910();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "503322838"
   )
   protected final class108 vmethod1990() {
      class45 var1 = class110.method2488(this.field102);
      class108 var2 = var1.method952(this.field123);
      if(null == var2) {
         return null;
      } else {
         var2.method2411(this.field121);
         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1003132103"
   )
   final void method94(int var1) {
      this.field107 = true;
      this.field112 += (double)var1 * this.field126;
      this.field113 += (double)var1 * this.field106;
      this.field114 += this.field129 * (double)var1 + (double)var1 * (double)var1 * this.field119 * 0.5D;
      this.field129 += this.field119 * (double)var1;
      this.field120 = (int)(Math.atan2(this.field126, this.field106) * 325.949D) + 1024 & 2047;
      this.field121 = (int)(Math.atan2(this.field129, this.field117) * 325.949D) & 2047;
      if(this.field111 != null) {
         this.field115 += var1;

         while(true) {
            do {
               do {
                  if(this.field115 <= this.field111.field1018[this.field123]) {
                     return;
                  }

                  this.field115 -= this.field111.field1018[this.field123];
                  ++this.field123;
               } while(this.field123 < this.field111.field1030.length);

               this.field123 -= this.field111.field1020;
            } while(this.field123 >= 0 && this.field123 < this.field111.field1030.length);

            this.field123 = 0;
         }
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field102 = var1;
      this.field101 = var2;
      this.field116 = var3;
      this.field118 = var4;
      this.field104 = var5;
      this.field100 = var6;
      this.field124 = var7;
      this.field108 = var8;
      this.field122 = var9;
      this.field110 = var10;
      this.field105 = var11;
      this.field107 = false;
      int var12 = class110.method2488(this.field102).field1042;
      if(var12 != -1) {
         this.field111 = class22.method585(var12);
      } else {
         this.field111 = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-64"
   )
   static void method97() {
      class34.field783 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class34.field791[var0] = null;
         class34.field781[var0] = 1;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "101"
   )
   final void method98(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field107) {
         var5 = (double)(var1 - this.field116);
         double var7 = (double)(var2 - this.field118);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field112 = var5 * (double)this.field122 / var9 + (double)this.field116;
         this.field113 = (double)this.field118 + (double)this.field122 * var7 / var9;
         this.field114 = (double)this.field104;
      }

      var5 = (double)(this.field124 + 1 - var4);
      this.field126 = ((double)var1 - this.field112) / var5;
      this.field106 = ((double)var2 - this.field113) / var5;
      this.field117 = Math.sqrt(this.field126 * this.field126 + this.field106 * this.field106);
      if(!this.field107) {
         this.field129 = -this.field117 * Math.tan(0.02454369D * (double)this.field108);
      }

      this.field119 = 2.0D * ((double)var3 - this.field114 - var5 * this.field129) / (var5 * var5);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   static void method103() {
      client.field337.method2903(43);
      client.field337.method2783(class53.method1139());
      client.field337.method2619(class189.field3056);
      client.field337.method2619(class39.field892);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2071693757"
   )
   static final void method104() {
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var35;
      int var36;
      if(client.field341 == 19) {
         var35 = client.field339.method2617();
         var36 = var35 >> 2;
         var2 = var35 & 3;
         var3 = client.field532[var36];
         var4 = client.field339.method2837();
         var5 = class4.field72 + (var4 >> 4 & 7);
         var6 = class46.field1064 + (var4 & 7);
         var7 = client.field339.method2749();
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            class1.method13(class99.field1701, var5, var6, var3, var7, var36, var2, 0, -1);
         }

      } else if(client.field341 == 205) {
         var35 = client.field339.method2633();
         var36 = (var35 >> 4 & 7) + class4.field72;
         var2 = class46.field1064 + (var35 & 7);
         var3 = client.field339.method2635();
         var4 = client.field339.method2633();
         var5 = client.field339.method2635();
         if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
            var36 = 128 * var36 + 64;
            var2 = 64 + 128 * var2;
            class31 var41 = new class31(var3, class99.field1701, var36, var2, class127.method2936(var36, var2, class99.field1701) - var4, var5, client.field305);
            client.field429.method3963(var41);
         }

      } else if(client.field341 == 33) {
         var35 = client.field339.method2662();
         var36 = (var35 >> 4 & 7) + class4.field72;
         var2 = class46.field1064 + (var35 & 7);
         var3 = client.field339.method2617();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = client.field532[var4];
         if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
            class1.method13(class99.field1701, var36, var2, var6, -1, var4, var5, 0, -1);
         }

      } else {
         int var9;
         int var11;
         int var12;
         int var30;
         if(client.field341 == 38) {
            byte var0 = client.field339.method2634();
            byte var1 = client.field339.method2659();
            var2 = client.field339.method2635();
            var3 = client.field339.method2803();
            var4 = client.field339.method2803();
            var5 = client.field339.method2749();
            var6 = client.field339.method2837();
            var7 = var6 >> 2;
            var30 = var6 & 3;
            var9 = client.field532[var7];
            byte var10 = client.field339.method2664();
            var11 = client.field339.method2837();
            var12 = (var11 >> 4 & 7) + class4.field72;
            int var31 = (var11 & 7) + class46.field1064;
            byte var14 = client.field339.method2632();
            class2 var15;
            if(var5 == client.field417) {
               var15 = class3.field65;
            } else {
               var15 = client.field302[var5];
            }

            if(null != var15) {
               class42 var16 = class160.method3312(var2);
               int var17;
               int var18;
               if(var30 != 1 && var30 != 3) {
                  var17 = var16.field960;
                  var18 = var16.field970;
               } else {
                  var17 = var16.field970;
                  var18 = var16.field960;
               }

               int var19 = (var17 >> 1) + var12;
               int var20 = var12 + (1 + var17 >> 1);
               int var21 = var31 + (var18 >> 1);
               int var22 = var31 + (1 + var18 >> 1);
               int[][] var23 = class5.field85[class99.field1701];
               int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
               int var25 = (var12 << 7) + (var17 << 6);
               int var26 = (var18 << 6) + (var31 << 7);
               class108 var27 = var16.method852(var7, var30, var23, var25, var24, var26);
               if(var27 != null) {
                  class1.method13(class99.field1701, var12, var31, var9, -1, 0, 0, var3 + 1, var4 + 1);
                  var15.field43 = var3 + client.field305;
                  var15.field40 = client.field305 + var4;
                  var15.field36 = var27;
                  var15.field41 = 128 * var12 + 64 * var17;
                  var15.field32 = 64 * var18 + var31 * 128;
                  var15.field42 = var24;
                  byte var28;
                  if(var10 > var1) {
                     var28 = var10;
                     var10 = var1;
                     var1 = var28;
                  }

                  if(var0 > var14) {
                     var28 = var0;
                     var0 = var14;
                     var14 = var28;
                  }

                  var15.field55 = var12 + var10;
                  var15.field47 = var1 + var12;
                  var15.field46 = var0 + var31;
                  var15.field48 = var31 + var14;
               }
            }
         }

         if(client.field341 == 199) {
            var35 = client.field339.method2633();
            var36 = class4.field72 + (var35 >> 4 & 7);
            var2 = class46.field1064 + (var35 & 7);
            var3 = var36 + client.field339.method2634();
            var4 = var2 + client.field339.method2634();
            var5 = client.field339.method2636();
            var6 = client.field339.method2635();
            var7 = client.field339.method2633() * 4;
            var30 = client.field339.method2633() * 4;
            var9 = client.field339.method2635();
            int var40 = client.field339.method2635();
            var11 = client.field339.method2633();
            var12 = client.field339.method2633();
            if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
               var36 = 64 + var36 * 128;
               var2 = 64 + 128 * var2;
               var3 = var3 * 128 + 64;
               var4 = var4 * 128 + 64;
               class6 var13 = new class6(var6, class99.field1701, var36, var2, class127.method2936(var36, var2, class99.field1701) - var7, var9 + client.field305, var40 + client.field305, var11, var12, var5, var30);
               var13.method98(var3, var4, class127.method2936(var3, var4, class99.field1701) - var30, var9 + client.field305);
               client.field428.method3963(var13);
            }

         } else if(client.field341 == 15) {
            var35 = client.field339.method2633();
            var36 = (var35 >> 4 & 7) + class4.field72;
            var2 = (var35 & 7) + class46.field1064;
            var3 = client.field339.method2635();
            var4 = client.field339.method2635();
            var5 = client.field339.method2635();
            if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
               class202 var34 = client.field426[class99.field1701][var36][var2];
               if(null != var34) {
                  for(class30 var29 = (class30)var34.method3980(); var29 != null; var29 = (class30)var34.method3970()) {
                     if((var3 & 32767) == var29.field714 && var4 == var29.field709) {
                        var29.field709 = var5;
                        break;
                     }
                  }

                  class144.method3120(var36, var2);
               }
            }

         } else {
            class30 var32;
            if(client.field341 == 152) {
               var35 = client.field339.method2635();
               var36 = client.field339.method2633();
               var2 = (var36 >> 4 & 7) + class4.field72;
               var3 = (var36 & 7) + class46.field1064;
               var4 = client.field339.method2635();
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  var32 = new class30();
                  var32.field714 = var4;
                  var32.field709 = var35;
                  if(null == client.field426[class99.field1701][var2][var3]) {
                     client.field426[class99.field1701][var2][var3] = new class202();
                  }

                  client.field426[class99.field1701][var2][var3].method3963(var32);
                  class144.method3120(var2, var3);
               }

            } else if(client.field341 == 249) {
               var35 = client.field339.method2617();
               var36 = (var35 >> 4 & 7) + class4.field72;
               var2 = (var35 & 7) + class46.field1064;
               var3 = client.field339.method2803();
               if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
                  class202 var33 = client.field426[class99.field1701][var36][var2];
                  if(var33 != null) {
                     for(var32 = (class30)var33.method3980(); var32 != null; var32 = (class30)var33.method3970()) {
                        if((var3 & 32767) == var32.field714) {
                           var32.method4067();
                           break;
                        }
                     }

                     if(var33.method3980() == null) {
                        client.field426[class99.field1701][var36][var2] = null;
                     }

                     class144.method3120(var36, var2);
                  }
               }

            } else if(client.field341 != 24) {
               if(client.field341 == 105) {
                  var35 = client.field339.method2633();
                  var36 = class4.field72 + (var35 >> 4 & 7);
                  var2 = class46.field1064 + (var35 & 7);
                  var3 = client.field339.method2635();
                  var4 = client.field339.method2633();
                  var5 = var4 >> 4 & 15;
                  var6 = var4 & 7;
                  var7 = client.field339.method2633();
                  if(var36 >= 0 && var2 >= 0 && var36 < 104 && var2 < 104) {
                     var30 = 1 + var5;
                     if(class3.field65.field886[0] >= var36 - var30 && class3.field65.field886[0] <= var36 + var30 && class3.field65.field887[0] >= var2 - var30 && class3.field65.field887[0] <= var2 + var30 && client.field535 != 0 && var6 > 0 && client.field536 < 50) {
                        client.field319[client.field536] = var3;
                        client.field538[client.field536] = var6;
                        client.field539[client.field536] = var7;
                        client.field541[client.field536] = null;
                        client.field528[client.field536] = var5 + (var2 << 8) + (var36 << 16);
                        ++client.field536;
                     }
                  }
               }

            } else {
               var35 = client.field339.method2837();
               var36 = class4.field72 + (var35 >> 4 & 7);
               var2 = class46.field1064 + (var35 & 7);
               var3 = client.field339.method2837();
               var4 = var3 >> 2;
               var5 = var3 & 3;
               var6 = client.field532[var4];
               var7 = client.field339.method2803();
               if(var36 >= 0 && var2 >= 0 && var36 < 103 && var2 < 103) {
                  if(var6 == 0) {
                     class90 var8 = class136.field2126.method2155(class99.field1701, var36, var2);
                     if(null != var8) {
                        var9 = var8.field1612 >> 14 & 32767;
                        if(var4 == 2) {
                           var8.field1614 = new class12(var9, 2, 4 + var5, class99.field1701, var36, var2, var7, false, var8.field1614);
                           var8.field1609 = new class12(var9, 2, 1 + var5 & 3, class99.field1701, var36, var2, var7, false, var8.field1609);
                        } else {
                           var8.field1614 = new class12(var9, var4, var5, class99.field1701, var36, var2, var7, false, var8.field1614);
                        }
                     }
                  }

                  if(var6 == 1) {
                     class97 var37 = class136.field2126.method2051(class99.field1701, var36, var2);
                     if(var37 != null) {
                        var9 = var37.field1683 >> 14 & 32767;
                        if(var4 != 4 && var4 != 5) {
                           if(var4 == 6) {
                              var37.field1681 = new class12(var9, 4, 4 + var5, class99.field1701, var36, var2, var7, false, var37.field1681);
                           } else if(var4 == 7) {
                              var37.field1681 = new class12(var9, 4, (var5 + 2 & 3) + 4, class99.field1701, var36, var2, var7, false, var37.field1681);
                           } else if(var4 == 8) {
                              var37.field1681 = new class12(var9, 4, 4 + var5, class99.field1701, var36, var2, var7, false, var37.field1681);
                              var37.field1676 = new class12(var9, 4, (var5 + 2 & 3) + 4, class99.field1701, var36, var2, var7, false, var37.field1676);
                           }
                        } else {
                           var37.field1681 = new class12(var9, 4, var5, class99.field1701, var36, var2, var7, false, var37.field1681);
                        }
                     }
                  }

                  if(var6 == 2) {
                     class101 var38 = class136.field2126.method2015(class99.field1701, var36, var2);
                     if(var4 == 11) {
                        var4 = 10;
                     }

                     if(var38 != null) {
                        var38.field1732 = new class12(var38.field1734 >> 14 & 32767, var4, var5, class99.field1701, var36, var2, var7, false, var38.field1732);
                     }
                  }

                  if(var6 == 3) {
                     class96 var39 = class136.field2126.method2016(class99.field1701, var36, var2);
                     if(var39 != null) {
                        var39.field1666 = new class12(var39.field1667 >> 14 & 32767, 22, var5, class99.field1701, var36, var2, var7, false, var39.field1666);
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1384917157"
   )
   @Export("addChatMessage")
   static void method105(int var0, String var1, String var2, String var3) {
      class29 var4 = (class29)class11.field182.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class29();
         class11.field182.put(Integer.valueOf(var0), var4);
      }

      class37 var5 = var4.method674(var0, var1, var2, var3);
      class11.field174.method3948(var5, (long)var5.field808);
      class11.field173.method4001(var5);
      client.field485 = client.field478;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "556666121"
   )
   public static void method106() {
      class55.field1177.method3910();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "124"
   )
   static char method108(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "236674057"
   )
   static void method109(int var0, int var1, int var2, int var3) {
      class176 var4 = class151.method3265(var0, var1);
      if(var4 != null && var4.field2898 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field8 = var4.field2898;
         class16.method203(var5);
      }

      client.field459 = var3;
      client.field448 = true;
      class13.field209 = var0;
      client.field449 = var1;
      class27.field675 = var2;
      class79.method1777(var4);
   }
}

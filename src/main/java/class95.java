import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class95 implements class92 {
   @ObfuscatedName("m")
   class167 field1623;
   @ObfuscatedName("x")
   class199 field1624 = new class199();
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 315830455
   )
   int field1625;
   @ObfuscatedName("e")
   double field1626 = 1.0D;
   @ObfuscatedName("bo")
   static class80 field1627;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1548042073
   )
   int field1628 = 128;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -162899907
   )
   int field1629 = 0;
   @ObfuscatedName("j")
   static int[] field1635;
   @ObfuscatedName("w")
   class83[] field1636;
   @ObfuscatedName("q")
   static int[] field1637;

   @ObfuscatedName("t")
   public boolean vmethod2161(int var1) {
      return this.field1636[var1].field1447;
   }

   @ObfuscatedName("x")
   public int vmethod2162(int var1) {
      return null != this.field1636[var1]?this.field1636[var1].field1446:0;
   }

   @ObfuscatedName("p")
   public boolean vmethod2165() {
      return 64 == this.field1628;
   }

   @ObfuscatedName("q")
   public void method2166() {
      for(int var1 = 0; var1 < this.field1636.length; ++var1) {
         if(this.field1636[var1] != null) {
            this.field1636[var1].method1889();
         }
      }

      this.field1624 = new class199();
      this.field1629 = this.field1625;
   }

   @ObfuscatedName("a")
   public void method2167(int var1) {
      for(int var2 = 0; var2 < this.field1636.length; ++var2) {
         class83 var3 = this.field1636[var2];
         if(null != var3 && var3.field1451 != 0 && var3.field1444) {
            var3.method1894(var1);
            var3.field1444 = false;
         }
      }

   }

   @ObfuscatedName("j")
   public void method2174(double var1) {
      this.field1626 = var1;
      this.method2166();
   }

   @ObfuscatedName("w")
   public int[] vmethod2175(int var1) {
      class83 var2 = this.field1636[var1];
      if(var2 != null) {
         if(null != var2.field1453) {
            this.field1624.method3835(var2);
            var2.field1444 = true;
            return var2.field1453;
         }

         boolean var3 = var2.method1887(this.field1626, this.field1628, this.field1623);
         if(var3) {
            if(this.field1629 == 0) {
               class83 var4 = (class83)this.field1624.method3839();
               var4.method1889();
            } else {
               --this.field1629;
            }

            this.field1624.method3835(var2);
            var2.field1444 = true;
            return var2.field1453;
         }
      }

      return null;
   }

   @ObfuscatedName("w")
   public static void method2183(class167 var0, class167 var1, class167 var2) {
      class42.field1007 = var0;
      class42.field992 = var1;
      class125.field2048 = var2;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1500198801"
   )
   static final void method2184(int var0) {
      class168.method3372();

      for(class23 var1 = (class23)class23.field618.method3836(); var1 != null; var1 = (class23)class23.field618.method3841()) {
         if(null != var1.field626) {
            var1.method601();
         }
      }

      int var4 = class56.method1237(var0).field1171;
      if(var4 != 0) {
         int var2 = class176.field2916[var0];
         if(1 == var4) {
            if(1 == var2) {
               class91.method2087(0.9D);
               ((class95)class91.field1591).method2174(0.9D);
            }

            if(var2 == 2) {
               class91.method2087(0.8D);
               ((class95)class91.field1591).method2174(0.8D);
            }

            if(3 == var2) {
               class91.method2087(0.7D);
               ((class95)class91.field1591).method2174(0.7D);
            }

            if(var2 == 4) {
               class91.method2087(0.6D);
               ((class95)class91.field1591).method2174(0.6D);
            }

            class51.field1119.method3776();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(1 == var2) {
               var3 = 192;
            }

            if(2 == var2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(4 == var2) {
               var3 = 0;
            }

            if(var3 != client.field369) {
               if(client.field369 == 0 && -1 != client.field532) {
                  class39.method819(class19.field289, client.field532, 0, var3, false);
                  client.field496 = false;
               } else if(var3 == 0) {
                  class183.field2967.method3652();
                  class183.field2968 = 1;
                  class151.field2279 = null;
                  client.field496 = false;
               } else {
                  class181.method3552(var3);
               }

               client.field369 = var3;
            }
         }

         if(4 == var4) {
            if(0 == var2) {
               client.field534 = 127;
            }

            if(1 == var2) {
               client.field534 = 96;
            }

            if(var2 == 2) {
               client.field534 = 64;
            }

            if(var2 == 3) {
               client.field534 = 32;
            }

            if(4 == var2) {
               client.field534 = 0;
            }
         }

         if(5 == var4) {
            client.field432 = var2;
         }

         if(6 == var4) {
            client.field456 = var2;
         }

         if(9 == var4) {
            client.field544 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               client.field535 = 127;
            }

            if(var2 == 1) {
               client.field535 = 96;
            }

            if(2 == var2) {
               client.field535 = 64;
            }

            if(var2 == 3) {
               client.field535 = 32;
            }

            if(var2 == 4) {
               client.field535 = 0;
            }
         }

         if(17 == var4) {
            client.field462 = var2 & '\uffff';
         }

         class20[] var5;
         if(var4 == 18) {
            var5 = new class20[]{class20.field580, class20.field578, class20.field586, class20.field579};
            client.field321 = (class20)class23.method606(var5, var2);
            if(null == client.field321) {
               client.field321 = class20.field578;
            }
         }

         if(19 == var4) {
            if(-1 == var2) {
               client.field424 = -1;
            } else {
               client.field424 = var2 & 2047;
            }
         }

         if(22 == var4) {
            var5 = new class20[]{class20.field580, class20.field578, class20.field586, class20.field579};
            client.field322 = (class20)class23.method606(var5, var2);
            if(null == client.field322) {
               client.field322 = class20.field578;
            }
         }

      }
   }

   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1623 = var2;
      this.field1625 = var3;
      this.field1629 = this.field1625;
      this.field1626 = var4;
      this.field1628 = var6;
      int[] var7 = var1.method3332(0);
      int var8 = var7.length;
      this.field1636 = new class83[var1.method3330(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3335(0, var7[var9]));
         this.field1636[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass86;[Lclass108;I)V",
      garbageValue = "-1813544893"
   )
   static final void method2185(class86 var0, class108[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.field109[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if(2 == (class5.field109[1][var3][var4] & 2)) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2395(var3, var4);
                  }
               }
            }
         }
      }

      class5.field106 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field106 < -8) {
         class5.field106 = -8;
      }

      if(class5.field106 > 8) {
         class5.field106 = 8;
      }

      class5.field107 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field107 < -16) {
         class5.field107 = -16;
      }

      if(class5.field107 > 16) {
         class5.field107 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var44 = class129.field2062[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field96[var2][1 + var12][var11] - class5.field96[var2][var12 - 1][var11];
               var14 = class5.field96[var2][var12][var11 + 1] - class5.field96[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (var18 * -50 + var17 * -10 + -50 * var16) / var10;
               var20 = (var44[var12][var11] >> 1) + (var44[var12][1 + var11] >> 3) + (var44[var12 + 1][var11] >> 3) + (var44[var12 - 1][var11] >> 2) + (var44[var12][var11 - 1] >> 2);
               class5.field97[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field94[var11] = 0;
            class161.field2667[var11] = 0;
            class134.field2090[var11] = 0;
            field1635[var11] = 0;
            field1637[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class34.field782[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     class41 var45 = class36.method764(var14 - 1);
                     class5.field94[var12] += var45.field983;
                     class161.field2667[var12] += var45.field984;
                     class134.field2090[var12] += var45.field985;
                     field1635[var12] += var45.field986;
                     ++field1637[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class34.field782[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     class41 var46 = class36.method764(var15 - 1);
                     class5.field94[var12] -= var46.field983;
                     class161.field2667[var12] -= var46.field984;
                     class134.field2090[var12] -= var46.field985;
                     field1635[var12] -= var46.field986;
                     --field1637[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class5.field94[var18];
                     var13 += class161.field2667[var18];
                     var14 += class134.field2090[var18];
                     var15 += field1635[var18];
                     var16 += field1637[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class5.field94[var19];
                     var13 -= class161.field2667[var19];
                     var14 -= class134.field2090[var19];
                     var15 -= field1635[var19];
                     var16 -= field1637[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field413 || (class5.field109[0][var11][var17] & 2) != 0 || (class5.field109[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field108) {
                        class5.field108 = var2;
                     }

                     var20 = class34.field782[var2][var11][var17] & 255;
                     int var21 = class5.field93[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field96[var2][var11][var17];
                        int var23 = class5.field96[var2][var11 + 1][var17];
                        int var24 = class5.field96[var2][var11 + 1][var17 + 1];
                        int var25 = class5.field96[var2][var11][var17 + 1];
                        int var26 = class5.field97[var11][var17];
                        int var27 = class5.field97[var11 + 1][var17];
                        int var28 = class5.field97[var11 + 1][var17 + 1];
                        int var29 = class5.field97[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        int var34;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           var34 = var14 / var16;
                           var30 = class24.method607(var32, var33, var34);
                           var32 = class5.field106 + var32 & 255;
                           var34 += class5.field107;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class24.method607(var32, var33, var34);
                        }

                        class46 var35;
                        if(var2 > 0) {
                           boolean var48 = true;
                           if(0 == var20 && 0 != class137.field2147[var2][var11][var17]) {
                              var48 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (class46)class46.field1060.method3771((long)var34);
                              class46 var49;
                              if(var35 != null) {
                                 var49 = var35;
                              } else {
                                 byte[] var36 = class46.field1061.method3335(4, var34);
                                 var35 = new class46();
                                 if(var36 != null) {
                                    var35.method995(new class119(var36));
                                 }

                                 var35.method1001();
                                 class46.field1060.method3773(var35, (long)var34);
                                 var49 = var35;
                              }

                              if(!var49.field1067) {
                                 var48 = false;
                              }
                           }

                           if(var48 && var23 == var22 && var22 == var24 && var22 == var25) {
                              class3.field72[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class91.field1590[class44.method978(var31, 96)];
                        }

                        if(0 == var21) {
                           var0.method1942(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class44.method978(var30, var26), class44.method978(var30, var27), class44.method978(var30, var28), class44.method978(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class137.field2147[var2][var11][var17];
                           byte var50 = class114.field1985[var2][var11][var17];
                           int var51 = var21 - 1;
                           class46 var37 = (class46)class46.field1060.method3771((long)var51);
                           if(var37 != null) {
                              var35 = var37;
                           } else {
                              byte[] var38 = class46.field1061.method3335(4, var51);
                              var37 = new class46();
                              if(var38 != null) {
                                 var37.method995(new class119(var38));
                              }

                              var37.method1001();
                              class46.field1060.method3773(var37, (long)var51);
                              var35 = var37;
                           }

                           int var52 = var35.field1062;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var52 >= 0) {
                              var40 = class91.field1591.vmethod2162(var52);
                              var39 = -1;
                           } else if(16711935 == var35.field1075) {
                              var39 = -2;
                              var52 = -1;
                              var40 = -2;
                           } else {
                              var39 = class24.method607(var35.field1066, var35.field1072, var35.field1077);
                              var41 = class5.field106 + var35.field1066 & 255;
                              var42 = var35.field1077 + class5.field107;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class24.method607(var41, var35.field1072, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class91.field1590[class31.method706(var40, 96)];
                           }

                           if(var35.field1064 != -1) {
                              var42 = class5.field106 + var35.field1068 & 255;
                              int var43 = var35.field1070 + class5.field107;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class24.method607(var42, var35.field1069, var43);
                              var41 = class91.field1590[class31.method706(var40, 96)];
                           }

                           var0.method1942(var2, var11, var17, var33, var50, var52, var22, var23, var24, var25, class44.method978(var30, var26), class44.method978(var30, var27), class44.method978(var30, var28), class44.method978(var30, var29), class31.method706(var39, var26), class31.method706(var39, var27), class31.method706(var39, var28), class31.method706(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method1912(var2, var12, var11, class4.method49(var2, var12, var11));
            }
         }

         class34.field782[var2] = (byte[][])null;
         class5.field93[var2] = (byte[][])null;
         class137.field2147[var2] = (byte[][])null;
         class114.field1985[var2] = (byte[][])null;
         class129.field2062[var2] = (byte[][])null;
      }

      var0.method1939(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if(2 == (class5.field109[1][var2][var3] & 2)) {
               var0.method1910(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var47;
                  if((class3.field72[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class3.field72[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class3.field72[var6][var8][var10 + 1] & var2)) {
                        ++var10;
                     }

                     label541:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class3.field72[var11 - 1][var8][var13] & var2) == 0) {
                              break label541;
                           }
                        }

                        --var11;
                     }

                     label530:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class3.field72[1 + var12][var8][var13] & var2)) {
                              break label530;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var47 = 240;
                        var15 = class5.field96[var12][var8][var9] - var47;
                        var16 = class5.field96[var11][var8][var9];
                        class86.method1911(var5, 1, 128 * var8, 128 * var8, 128 * var9, 128 + var10 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class3.field72[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if(0 != (class3.field72[var6][var8][var7] & var3)) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class3.field72[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class3.field72[var6][var10 + 1][var7] & var3)) {
                        ++var10;
                     }

                     label594:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class3.field72[var11 - 1][var13][var7] & var3) == 0) {
                              break label594;
                           }
                        }

                        --var11;
                     }

                     label583:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class3.field72[1 + var12][var13][var7] & var3) == 0) {
                              break label583;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var47 = 240;
                        var15 = class5.field96[var12][var9][var7] - var47;
                        var16 = class5.field96[var11][var9][var7];
                        class86.method1911(var5, 2, 128 * var9, 128 + var10 * 128, var7 * 128, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class3.field72[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class3.field72[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && 0 != (class3.field72[var6][var8][var11 - 1] & var4); --var11) {
                        ;
                     }

                     while(var12 < 104 && 0 != (class3.field72[var6][var8][1 + var12] & var4)) {
                        ++var12;
                     }

                     label647:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class3.field72[var6][var9 - 1][var13] & var4)) {
                              break label647;
                           }
                        }

                        --var9;
                     }

                     label636:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class3.field72[var6][1 + var10][var13] & var4)) {
                              break label636;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class5.field96[var6][var9][var11];
                        class86.method1911(var5, 4, var9 * 128, var10 * 128 + 128, 128 * var11, 128 * var12 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class3.field72[var6][var14][var15] &= ~var4;
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

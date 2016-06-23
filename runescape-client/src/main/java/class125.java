import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public abstract class class125 {
   @ObfuscatedName("u")
   static boolean field2043 = false;
   @ObfuscatedName("h")
   public static String[] field2044;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 7016921330126553433L
   )
   public static long field2046;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "101"
   )
   abstract void vmethod2816(byte[] var1);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "541753250"
   )
   abstract byte[] vmethod2817();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass86;[Lclass108;I)V",
      garbageValue = "987641062"
   )
   static final void method2829(class86 var0, class108[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.field82[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.field82[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2437(var3, var4);
                  }
               }
            }
         }
      }

      class5.field96 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field96 < -8) {
         class5.field96 = -8;
      }

      if(class5.field96 > 8) {
         class5.field96 = 8;
      }

      class5.field98 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field98 < -16) {
         class5.field98 = -16;
      }

      if(class5.field98 > 16) {
         class5.field98 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      int var45;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var44 = class216.field3159[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var45 = class5.field99[var2][var12 + 1][var11] - class5.field99[var2][var12 - 1][var11];
               var14 = class5.field99[var2][var12][var11 + 1] - class5.field99[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var45 * var45));
               var16 = (var45 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (-50 * var16 + -10 * var17 + var18 * -50) / var10 + 96;
               var20 = (var44[var12][1 + var11] >> 3) + (var44[var12][var11 - 1] >> 2) + (var44[1 + var12][var11] >> 3) + (var44[var12 - 1][var11] >> 2) + (var44[var12][var11] >> 1);
               class8.field147[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field103[var11] = 0;
            class5.field87[var11] = 0;
            class5.field85[var11] = 0;
            class5.field90[var11] = 0;
            class38.field887[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var45 = 5 + var11;
               if(var45 >= 0 && var45 < 104) {
                  var14 = class5.field84[var2][var45][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class41 var49 = (class41)class41.field987.method3797((long)var16);
                     class41 var50;
                     if(var49 != null) {
                        var50 = var49;
                     } else {
                        byte[] var47 = class41.field993.method3286(1, var16);
                        var49 = new class41();
                        if(var47 != null) {
                           var49.method879(new class119(var47), var16);
                        }

                        var49.method878();
                        class41.field987.method3788(var49, (long)var16);
                        var50 = var49;
                     }

                     class5.field103[var12] += var50.field989;
                     class5.field87[var12] += var50.field991;
                     class5.field85[var12] += var50.field994;
                     class5.field90[var12] += var50.field992;
                     ++class38.field887[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field84[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class41 var57 = (class41)class41.field987.method3797((long)var17);
                     class41 var48;
                     if(null != var57) {
                        var48 = var57;
                     } else {
                        byte[] var51 = class41.field993.method3286(1, var17);
                        var57 = new class41();
                        if(null != var51) {
                           var57.method879(new class119(var51), var17);
                        }

                        var57.method878();
                        class41.field987.method3788(var57, (long)var17);
                        var48 = var57;
                     }

                     class5.field103[var12] -= var48.field989;
                     class5.field87[var12] -= var48.field991;
                     class5.field85[var12] -= var48.field994;
                     class5.field90[var12] -= var48.field992;
                     --class38.field887[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var45 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class5.field103[var18];
                     var45 += class5.field87[var18];
                     var14 += class5.field85[var18];
                     var15 += class5.field90[var18];
                     var16 += class38.field887[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class5.field103[var19];
                     var45 -= class5.field87[var19];
                     var14 -= class5.field85[var19];
                     var15 -= class5.field90[var19];
                     var16 -= class38.field887[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field296 || (class5.field82[0][var11][var17] & 2) != 0 || (class5.field82[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field83) {
                        class5.field83 = var2;
                     }

                     var20 = class5.field84[var2][var11][var17] & 255;
                     int var21 = class222.field3180[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field99[var2][var11][var17];
                        int var23 = class5.field99[var2][1 + var11][var17];
                        int var24 = class5.field99[var2][1 + var11][1 + var17];
                        int var25 = class5.field99[var2][var11][1 + var17];
                        int var26 = class8.field147[var11][var17];
                        int var27 = class8.field147[var11 + 1][var17];
                        int var28 = class8.field147[1 + var11][var17 + 1];
                        int var29 = class8.field147[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var34;
                        int var52;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var52 = var45 / var16;
                           var34 = var14 / var16;
                           var30 = class150.method3168(var32, var52, var34);
                           var32 = var32 + class5.field96 & 255;
                           var34 += class5.field98;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class150.method3168(var32, var52, var34);
                        }

                        class46 var35;
                        if(var2 > 0) {
                           boolean var55 = true;
                           if(var20 == 0 && class5.field81[var2][var11][var17] != 0) {
                              var55 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (class46)class46.field1060.method3797((long)var34);
                              class46 var33;
                              if(var35 != null) {
                                 var33 = var35;
                              } else {
                                 byte[] var53 = class46.field1071.method3286(4, var34);
                                 var35 = new class46();
                                 if(var53 != null) {
                                    var35.method1004(new class119(var53), var34);
                                 }

                                 var35.method1013();
                                 class46.field1060.method3788(var35, (long)var34);
                                 var33 = var35;
                              }

                              if(!var33.field1064) {
                                 var55 = false;
                              }
                           }

                           if(var55 && var22 == var23 && var24 == var22 && var22 == var25) {
                              class19.field286[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class91.field1593[class56.method1266(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1980(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class56.method1266(var30, var26), class56.method1266(var30, var27), class56.method1266(var30, var28), class56.method1266(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var52 = 1 + class5.field81[var2][var11][var17];
                           byte var56 = class5.field86[var2][var11][var17];
                           int var36 = var21 - 1;
                           class46 var37 = (class46)class46.field1060.method3797((long)var36);
                           if(var37 != null) {
                              var35 = var37;
                           } else {
                              byte[] var38 = class46.field1071.method3286(4, var36);
                              var37 = new class46();
                              if(null != var38) {
                                 var37.method1004(new class119(var38), var36);
                              }

                              var37.method1013();
                              class46.field1060.method3788(var37, (long)var36);
                              var35 = var37;
                           }

                           int var46 = var35.field1062;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var46 >= 0) {
                              var40 = class91.field1594.vmethod2232(var46);
                              var39 = -1;
                           } else if(var35.field1059 == 16711935) {
                              var39 = -2;
                              var46 = -1;
                              var40 = -2;
                           } else {
                              var39 = class150.method3168(var35.field1065, var35.field1066, var35.field1067);
                              var41 = var35.field1065 + class5.field96 & 255;
                              var42 = var35.field1067 + class5.field98;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class150.method3168(var41, var35.field1066, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class91.field1593[class75.method1699(var40, 96)];
                           }

                           if(var35.field1073 != -1) {
                              var42 = var35.field1068 + class5.field96 & 255;
                              int var43 = var35.field1070 + class5.field98;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class150.method3168(var42, var35.field1061, var43);
                              var41 = class91.field1593[class75.method1699(var40, 96)];
                           }

                           var0.method1980(var2, var11, var17, var52, var56, var46, var22, var23, var24, var25, class56.method1266(var30, var26), class56.method1266(var30, var27), class56.method1266(var30, var28), class56.method1266(var30, var29), class75.method1699(var39, var26), class75.method1699(var39, var27), class75.method1699(var39, var28), class75.method1699(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class5.field82[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class5.field82[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method2049(var2, var12, var11, var17);
            }
         }

         class5.field84[var2] = (byte[][])null;
         class222.field3180[var2] = (byte[][])null;
         class5.field81[var2] = (byte[][])null;
         class5.field86[var2] = (byte[][])null;
         class216.field3159[var2] = (byte[][])null;
      }

      var0.method2006(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field82[1][var2][var3] & 2) == 2) {
               var0.method1977(var2, var3);
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
                  short var54;
                  if((class19.field286[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class19.field286[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class19.field286[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label583:
                     while(var11 > 0) {
                        for(var45 = var9; var45 <= var10; ++var45) {
                           if((class19.field286[var11 - 1][var8][var45] & var2) == 0) {
                              break label583;
                           }
                        }

                        --var11;
                     }

                     label572:
                     while(var12 < var5) {
                        for(var45 = var9; var45 <= var10; ++var45) {
                           if((class19.field286[1 + var12][var8][var45] & var2) == 0) {
                              break label572;
                           }
                        }

                        ++var12;
                     }

                     var45 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var45 >= 8) {
                        var54 = 240;
                        var15 = class5.field99[var12][var8][var9] - var54;
                        var16 = class5.field99[var11][var8][var9];
                        class86.method2100(var5, 1, var8 * 128, 128 * var8, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class19.field286[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class19.field286[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class19.field286[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class19.field286[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label636:
                     while(var11 > 0) {
                        for(var45 = var9; var45 <= var10; ++var45) {
                           if((class19.field286[var11 - 1][var45][var7] & var3) == 0) {
                              break label636;
                           }
                        }

                        --var11;
                     }

                     label625:
                     while(var12 < var5) {
                        for(var45 = var9; var45 <= var10; ++var45) {
                           if((class19.field286[1 + var12][var45][var7] & var3) == 0) {
                              break label625;
                           }
                        }

                        ++var12;
                     }

                     var45 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var45 >= 8) {
                        var54 = 240;
                        var15 = class5.field99[var12][var9][var7] - var54;
                        var16 = class5.field99[var11][var9][var7];
                        class86.method2100(var5, 2, 128 * var9, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class19.field286[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class19.field286[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class19.field286[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class19.field286[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label689:
                     while(var9 > 0) {
                        for(var45 = var11; var45 <= var12; ++var45) {
                           if((class19.field286[var6][var9 - 1][var45] & var4) == 0) {
                              break label689;
                           }
                        }

                        --var9;
                     }

                     label678:
                     while(var10 < 104) {
                        for(var45 = var11; var45 <= var12; ++var45) {
                           if((class19.field286[var6][1 + var10][var45] & var4) == 0) {
                              break label678;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var10 - var9)) * (1 + (var12 - var11)) >= 4) {
                        var45 = class5.field99[var6][var9][var11];
                        class86.method2100(var5, 4, var9 * 128, 128 + var10 * 128, var11 * 128, 128 * var12 + 128, var45, var45);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class19.field286[var6][var14][var15] &= ~var4;
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

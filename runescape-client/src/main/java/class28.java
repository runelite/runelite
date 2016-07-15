import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class28 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -437837563
   )
   public static int field695;
   @ObfuscatedName("j")
   static String field702;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass89;[Lclass111;I)V",
      garbageValue = "-188060378"
   )
   static final void method645(class89 var0, class111[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.field89[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.field89[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2488(var3, var4);
                  }
               }
            }
         }
      }

      class5.field93 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field93 < -8) {
         class5.field93 = -8;
      }

      if(class5.field93 > 8) {
         class5.field93 = 8;
      }

      class5.field94 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field94 < -16) {
         class5.field94 = -16;
      }

      if(class5.field94 > 16) {
         class5.field94 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var14;
      int var16;
      int var17;
      int var18;
      int var43;
      int var44;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class5.field83[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var43 = class5.field78[var2][1 + var12][var11] - class5.field78[var2][var12 - 1][var11];
               var14 = class5.field78[var2][var12][1 + var11] - class5.field78[var2][var12][var11 - 1];
               var44 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var43 * var43));
               var16 = (var43 << 8) / var44;
               var17 = 65536 / var44;
               var18 = (var14 << 8) / var44;
               var19 = (-50 * var18 + -10 * var17 + var16 * -50) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][var11 - 1] >> 2) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][1 + var11] >> 3);
               class1.field25[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field84[var11] = 0;
            class5.field85[var11] = 0;
            class8.field155[var11] = 0;
            class225.field3228[var11] = 0;
            class32.field752[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var43 = 5 + var11;
               if(var43 >= 0 && var43 < 104) {
                  var14 = class5.field80[var2][var43][var12] & 255;
                  if(var14 > 0) {
                     class43 var15 = class25.method583(var14 - 1);
                     class5.field84[var12] += var15.field1011;
                     class5.field85[var12] += var15.field1015;
                     class8.field155[var12] += var15.field1013;
                     class225.field3228[var12] += var15.field1014;
                     ++class32.field752[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var44 = class5.field80[var2][var14][var12] & 255;
                  if(var44 > 0) {
                     class43 var45 = class25.method583(var44 - 1);
                     class5.field84[var12] -= var45.field1011;
                     class5.field85[var12] -= var45.field1015;
                     class8.field155[var12] -= var45.field1013;
                     class225.field3228[var12] -= var45.field1014;
                     --class32.field752[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var43 = 0;
               var14 = 0;
               var44 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = 5 + var17;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class5.field84[var18];
                     var43 += class5.field85[var18];
                     var14 += class8.field155[var18];
                     var44 += class225.field3228[var18];
                     var16 += class32.field752[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class5.field84[var19];
                     var43 -= class5.field85[var19];
                     var14 -= class8.field155[var19];
                     var44 -= class225.field3228[var19];
                     var16 -= class32.field752[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field298 || (class5.field89[0][var11][var17] & 2) != 0 || (class5.field89[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field79) {
                        class5.field79 = var2;
                     }

                     var20 = class5.field80[var2][var11][var17] & 255;
                     int var21 = class5.field91[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field78[var2][var11][var17];
                        int var23 = class5.field78[var2][1 + var11][var17];
                        int var24 = class5.field78[var2][1 + var11][var17 + 1];
                        int var25 = class5.field78[var2][var11][var17 + 1];
                        int var26 = class1.field25[var11][var17];
                        int var27 = class1.field25[1 + var11][var17];
                        int var28 = class1.field25[var11 + 1][var17 + 1];
                        int var29 = class1.field25[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var44;
                           var33 = var43 / var16;
                           int var34 = var14 / var16;
                           var30 = class37.method771(var32, var33, var34);
                           var32 = class5.field93 + var32 & 255;
                           var34 += class5.field94;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class37.method771(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class219.field3204[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class5.method75(var21 - 1).field1081) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var24 == var22 && var25 == var22) {
                              class133.field2117[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class94.field1651[class9.method109(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2014(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class9.method109(var30, var26), class9.method109(var30, var27), class9.method109(var30, var28), class9.method109(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class219.field3204[var2][var11][var17] + 1;
                           byte var48 = class5.field81[var2][var11][var17];
                           class48 var35 = class5.method75(var21 - 1);
                           int var36 = var35.field1080;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class94.field1646.vmethod2271(var36);
                              var37 = -1;
                           } else if(var35.field1082 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class37.method771(var35.field1092, var35.field1086, var35.field1087);
                              var39 = class5.field93 + var35.field1092 & 255;
                              var40 = var35.field1087 + class5.field94;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class37.method771(var39, var35.field1086, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class94.field1651[class19.method210(var38, 96)];
                           }

                           if(var35.field1084 != -1) {
                              var40 = class5.field93 + var35.field1088 & 255;
                              int var41 = var35.field1090 + class5.field94;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class37.method771(var40, var35.field1089, var41);
                              var39 = class94.field1651[class19.method210(var38, 96)];
                           }

                           var0.method2014(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class9.method109(var30, var26), class9.method109(var30, var27), class9.method109(var30, var28), class9.method109(var30, var29), class19.method210(var37, var26), class19.method210(var37, var27), class19.method210(var37, var28), class19.method210(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class5.field89[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class5.field89[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method2080(var2, var12, var11, var17);
            }
         }

         class5.field80[var2] = null;
         class5.field91[var2] = null;
         class219.field3204[var2] = null;
         class5.field81[var2] = null;
         class5.field83[var2] = null;
      }

      var0.method2040(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.field89[1][var2][var3] & 2) == 2) {
               var0.method2061(var2, var3);
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
                  short var46;
                  if((class133.field2117[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class133.field2117[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class133.field2117[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label525:
                     while(var11 > 0) {
                        for(var43 = var9; var43 <= var10; ++var43) {
                           if((class133.field2117[var11 - 1][var8][var43] & var2) == 0) {
                              break label525;
                           }
                        }

                        --var11;
                     }

                     label514:
                     while(var12 < var5) {
                        for(var43 = var9; var43 <= var10; ++var43) {
                           if((class133.field2117[var12 + 1][var8][var43] & var2) == 0) {
                              break label514;
                           }
                        }

                        ++var12;
                     }

                     var43 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var43 >= 8) {
                        var46 = 240;
                        var44 = class5.field78[var12][var8][var9] - var46;
                        var16 = class5.field78[var11][var8][var9];
                        class89.method2012(var5, 1, var8 * 128, 128 * var8, 128 * var9, var10 * 128 + 128, var44, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class133.field2117[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class133.field2117[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class133.field2117[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class133.field2117[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label578:
                     while(var11 > 0) {
                        for(var43 = var9; var43 <= var10; ++var43) {
                           if((class133.field2117[var11 - 1][var43][var7] & var3) == 0) {
                              break label578;
                           }
                        }

                        --var11;
                     }

                     label567:
                     while(var12 < var5) {
                        for(var43 = var9; var43 <= var10; ++var43) {
                           if((class133.field2117[1 + var12][var43][var7] & var3) == 0) {
                              break label567;
                           }
                        }

                        ++var12;
                     }

                     var43 = (1 + (var10 - var9)) * (var12 + 1 - var11);
                     if(var43 >= 8) {
                        var46 = 240;
                        var44 = class5.field78[var12][var9][var7] - var46;
                        var16 = class5.field78[var11][var9][var7];
                        class89.method2012(var5, 2, var9 * 128, 128 * var10 + 128, 128 * var7, var7 * 128, var44, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class133.field2117[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class133.field2117[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class133.field2117[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class133.field2117[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label631:
                     while(var9 > 0) {
                        for(var43 = var11; var43 <= var12; ++var43) {
                           if((class133.field2117[var6][var9 - 1][var43] & var4) == 0) {
                              break label631;
                           }
                        }

                        --var9;
                     }

                     label620:
                     while(var10 < 104) {
                        for(var43 = var11; var43 <= var12; ++var43) {
                           if((class133.field2117[var6][var10 + 1][var43] & var4) == 0) {
                              break label620;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var43 = class5.field78[var6][var9][var11];
                        class89.method2012(var5, 4, 128 * var9, 128 + 128 * var10, var11 * 128, 128 + var12 * 128, var43, var43);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var44 = var11; var44 <= var12; ++var44) {
                              class133.field2117[var6][var14][var44] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Z",
      garbageValue = "1988485340"
   )
   static final boolean method646(class176 var0) {
      if(var0.field2907 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2907.length; ++var1) {
            int var2 = class62.method1364(var0, var1);
            int var3 = var0.field2908[var1];
            if(var0.field2907[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2907[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2907[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "([Lclass176;II)V",
      garbageValue = "560465748"
   )
   static final void method647(class176[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class176 var3 = var0[var2];
         if(var3 != null) {
            if(var3.field2796 == 0) {
               if(null != var3.field2827) {
                  method647(var3.field2827, var1);
               }

               class3 var4 = (class3)client.field455.method3864((long)var3.field2794);
               if(null != var4) {
                  class29.method659(var4.field60, var1);
               }
            }

            class0 var5;
            if(var1 == 0 && var3.field2901 != null) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field4 = var3.field2901;
               class143.method3071(var5);
            }

            if(var1 == 1 && var3.field2861 != null) {
               if(var3.field2795 >= 0) {
                  class176 var6 = class19.method212(var3.field2794);
                  if(var6 == null || null == var6.field2827 || var3.field2795 >= var6.field2827.length || var3 != var6.field2827[var3.field2795]) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field4 = var3.field2861;
               class143.method3071(var5);
            }
         }
      }

   }
}

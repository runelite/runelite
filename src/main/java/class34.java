import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("a")
   @Export("composition")
   class39 field784;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 81502797
   )
   static int field785;
   @ObfuscatedName("j")
   static int[] field786;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected final class105 vmethod1999() {
      if(this.field784 == null) {
         return null;
      } else {
         class42 var1 = -1 != super.field848 && 0 == super.field851?class96.method2279(super.field848):null;
         class42 var2 = super.field845 == -1 || super.field822 == super.field845 && null != var1?null:class96.method2279(super.field845);
         class105 var3 = this.field784.method860(var1, super.field849, var2, super.field846);
         if(var3 == null) {
            return null;
         } else {
            var3.method2418();
            super.field867 = var3.field1465;
            if(super.field865 != -1 && super.field854 != -1) {
               class105 var4 = class25.method693(super.field865).method994(super.field854);
               if(var4 != null) {
                  var4.method2402(0, -super.field857, 0);
                  class105[] var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(1 == this.field784.field887) {
               var3.field1819 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1"
   )
   final void method802(int var1, byte var2) {
      int var3 = super.field871[0];
      int var4 = super.field835[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(2 == var1) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(4 == var1) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(7 == var1) {
         ++var3;
         --var4;
      }

      if(super.field848 != -1 && class96.method2279(super.field848).field1004 == 1) {
         super.field848 = -1;
      }

      if(super.field821 < 9) {
         ++super.field821;
      }

      for(int var5 = super.field821; var5 > 0; --var5) {
         super.field871[var5] = super.field871[var5 - 1];
         super.field835[var5] = super.field835[var5 - 1];
         super.field826[var5] = super.field826[var5 - 1];
      }

      super.field871[0] = var3;
      super.field835[0] = var4;
      super.field826[0] = var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   static void method804() {
      client.field338.method2873(74);
      client.field338.method2603(class24.method674());
      client.field338.method2599(class37.field876);
      client.field338.method2599(class98.field1671);
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)Ljava/lang/String;",
      garbageValue = "2136761447"
   )
   static String method805(class173 var0, int var1) {
      int var3 = class31.method776(var0);
      boolean var2 = (var3 >> 1 + var1 & 1) != 0;
      return !var2 && var0.field2806 == null?null:(null != var0.field2832 && var0.field2832.length > var1 && null != var0.field2832[var1] && var0.field2832[var1].trim().length() != 0?var0.field2832[var1]:null);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "0"
   )
   final void method808(int var1, int var2, boolean var3) {
      if(super.field848 != -1 && class96.method2279(super.field848).field1004 == 1) {
         super.field848 = -1;
      }

      int var4 = var1 - super.field871[0];
      int var5 = var2 - super.field835[0];
      if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
         if(super.field821 < 9) {
            ++super.field821;
         }

         for(int var6 = super.field821; var6 > 0; --var6) {
            super.field871[var6] = super.field871[var6 - 1];
            super.field835[var6] = super.field835[var6 - 1];
            super.field826[var6] = super.field826[var6 - 1];
         }

         super.field871[0] = var1;
         super.field835[0] = var2;
         super.field826[0] = 1;
      } else {
         super.field821 = 0;
         super.field875 = 0;
         super.field874 = 0;
         super.field871[0] = var1;
         super.field835[0] = var2;
         super.field844 = 128 * super.field871[0] + super.field841 * 64;
         super.field819 = super.field841 * 64 + 128 * super.field835[0];
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1478814369"
   )
   final boolean vmethod836() {
      return this.field784 != null;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "556920554"
   )
   static final int method816(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && 2 == (class5.field82[1][var3][var4] & 2)) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class5.field94[var5][var3][var4] + var6 * class5.field94[var5][var3 + 1][var4] >> 7;
         int var9 = var6 * class5.field94[var5][var3 + 1][var4 + 1] + class5.field94[var5][var3][1 + var4] * (128 - var6) >> 7;
         return (128 - var7) * var8 + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[II)V",
      garbageValue = "-1517253"
   )
   static void method817(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var2 + var1) / 2;
         class25 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(2 == var3[var10]) {
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field648;
                     var12 = var8.field648;
                     if(var11 == -1 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method679()?1:0;
                     var12 = var8.method679()?1:0;
                  } else {
                     var11 = var0[var6].field646;
                     var12 = var8.field646;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                  } else if(1 == var3[var10]) {
                     var11 = var0[var5].field648;
                     var12 = var8.field648;
                     if(-1 == var11 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method679()?1:0;
                     var12 = var8.method679()?1:0;
                  } else {
                     var11 = var0[var5].field646;
                     var12 = var8.field646;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method817(var0, var1, var6, var3, var4);
         method817(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-298963164"
   )
   static boolean method818(int var0) {
      return 57 == var0 || var0 == 58 || var0 == 1007 || 25 == var0 || 30 == var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass86;[Lclass108;I)V",
      garbageValue = "-1112375534"
   )
   static final void method819(class86 var0, class108[] var1) {
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
                     var1[var5].method2496(var3, var4);
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

      class5.field102 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field102 < -16) {
         class5.field102 = -16;
      }

      if(class5.field102 > 16) {
         class5.field102 = 16;
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
         byte[][] var44 = class41.field985[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.field94[var2][var12 + 1][var11] - class5.field94[var2][var12 - 1][var11];
               var14 = class5.field94[var2][var12][var11 + 1] - class5.field94[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (-50 * var16 + -10 * var17 + var18 * -50) / var10;
               var20 = (var44[var12][var11] >> 1) + (var44[1 + var12][var11] >> 3) + (var44[var12 - 1][var11] >> 2) + (var44[var12][var11 - 1] >> 2) + (var44[var12][var11 + 1] >> 3);
               class209.field3126[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field86[var11] = 0;
            class134.field2077[var11] = 0;
            class142.field2170[var11] = 0;
            class5.field95[var11] = 0;
            class125.field2035[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class45.field1053[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class41 var48 = (class41)class41.field978.method3840((long)var16);
                     class41 var45;
                     if(null != var48) {
                        var45 = var48;
                     } else {
                        byte[] var49 = class163.field2639.method3403(1, var16);
                        var48 = new class41();
                        if(null != var49) {
                           var48.method937(new class119(var49), var16);
                        }

                        var48.method936();
                        class41.field978.method3842(var48, (long)var16);
                        var45 = var48;
                     }

                     class5.field86[var12] += var45.field981;
                     class134.field2077[var12] += var45.field980;
                     class142.field2170[var12] += var45.field983;
                     class5.field95[var12] += var45.field982;
                     ++class125.field2035[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class45.field1053[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class41 var50 = (class41)class41.field978.method3840((long)var17);
                     class41 var46;
                     if(var50 != null) {
                        var46 = var50;
                     } else {
                        byte[] var51 = class163.field2639.method3403(1, var17);
                        var50 = new class41();
                        if(null != var51) {
                           var50.method937(new class119(var51), var17);
                        }

                        var50.method936();
                        class41.field978.method3842(var50, (long)var17);
                        var46 = var50;
                     }

                     class5.field86[var12] -= var46.field981;
                     class134.field2077[var12] -= var46.field980;
                     class142.field2170[var12] -= var46.field983;
                     class5.field95[var12] -= var46.field982;
                     --class125.field2035[var12];
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
                  var18 = 5 + var17;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class5.field86[var18];
                     var13 += class134.field2077[var18];
                     var14 += class142.field2170[var18];
                     var15 += class5.field95[var18];
                     var16 += class125.field2035[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class5.field86[var19];
                     var13 -= class134.field2077[var19];
                     var14 -= class142.field2170[var19];
                     var15 -= class5.field95[var19];
                     var16 -= class125.field2035[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!client.field302 || (class5.field82[0][var11][var17] & 2) != 0 || (class5.field82[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field87) {
                        class5.field87 = var2;
                     }

                     var20 = class45.field1053[var2][var11][var17] & 255;
                     int var21 = class5.field84[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.field94[var2][var11][var17];
                        int var23 = class5.field94[var2][var11 + 1][var17];
                        int var24 = class5.field94[var2][1 + var11][1 + var17];
                        int var25 = class5.field94[var2][var11][1 + var17];
                        int var26 = class209.field3126[var11][var17];
                        int var27 = class209.field3126[1 + var11][var17];
                        int var28 = class209.field3126[var11 + 1][1 + var17];
                        int var29 = class209.field3126[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        int var34;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           var34 = var14 / var16;
                           var30 = class17.method217(var32, var33, var34);
                           var32 = var32 + class5.field96 & 255;
                           var34 += class5.field102;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class17.method217(var32, var33, var34);
                        }

                        class46 var35;
                        if(var2 > 0) {
                           boolean var52 = true;
                           if(var20 == 0 && 0 != class5.field85[var2][var11][var17]) {
                              var52 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (class46)class46.field1065.method3840((long)var34);
                              class46 var53;
                              if(null != var35) {
                                 var53 = var35;
                              } else {
                                 byte[] var36 = class166.field2658.method3403(4, var34);
                                 var35 = new class46();
                                 if(var36 != null) {
                                    var35.method1064(new class119(var36), var34);
                                 }

                                 var35.method1053();
                                 class46.field1065.method3842(var35, (long)var34);
                                 var53 = var35;
                              }

                              if(!var53.field1058) {
                                 var52 = false;
                              }
                           }

                           if(var52 && var22 == var23 && var22 == var24 && var22 == var25) {
                              class4.field77[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class91.field1589[class6.method132(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2130(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class6.method132(var30, var26), class6.method132(var30, var27), class6.method132(var30, var28), class6.method132(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class5.field85[var2][var11][var17];
                           byte var54 = class84.field1463[var2][var11][var17];
                           int var55 = var21 - 1;
                           class46 var37 = (class46)class46.field1065.method3840((long)var55);
                           if(null != var37) {
                              var35 = var37;
                           } else {
                              byte[] var38 = class166.field2658.method3403(4, var55);
                              var37 = new class46();
                              if(var38 != null) {
                                 var37.method1064(new class119(var38), var55);
                              }

                              var37.method1053();
                              class46.field1065.method3842(var37, (long)var55);
                              var35 = var37;
                           }

                           int var56 = var35.field1060;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var56 >= 0) {
                              var40 = class91.field1575.vmethod2257(var56);
                              var39 = -1;
                           } else if(var35.field1059 == 16711935) {
                              var39 = -2;
                              var56 = -1;
                              var40 = -2;
                           } else {
                              var39 = class17.method217(var35.field1063, var35.field1068, var35.field1061);
                              var41 = class5.field96 + var35.field1063 & 255;
                              var42 = class5.field102 + var35.field1061;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class17.method217(var41, var35.field1068, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class91.field1589[class20.method638(var40, 96)];
                           }

                           if(var35.field1062 != -1) {
                              var42 = class5.field96 + var35.field1071 & 255;
                              int var43 = var35.field1064 + class5.field102;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class17.method217(var42, var35.field1067, var43);
                              var41 = class91.field1589[class20.method638(var40, 96)];
                           }

                           var0.method2130(var2, var11, var17, var33, var54, var56, var22, var23, var24, var25, class6.method132(var30, var26), class6.method132(var30, var27), class6.method132(var30, var28), class6.method132(var30, var29), class20.method638(var39, var26), class20.method638(var39, var27), class20.method638(var39, var28), class20.method638(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2105(var2, var12, var11, class51.method1179(var2, var12, var11));
            }
         }

         class45.field1053[var2] = (byte[][])null;
         class5.field84[var2] = (byte[][])null;
         class5.field85[var2] = (byte[][])null;
         class84.field1463[var2] = (byte[][])null;
         class41.field985[var2] = (byte[][])null;
      }

      var0.method2039(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if(2 == (class5.field82[1][var2][var3] & 2)) {
               var0.method2010(var2, var3);
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
                  if(0 != (class4.field77[var6][var8][var7] & var2)) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && 0 != (class4.field77[var6][var8][var9 - 1] & var2); --var9) {
                        ;
                     }

                     while(var10 < 104 && (class4.field77[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label567:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class4.field77[var11 - 1][var8][var13] & var2) == 0) {
                              break label567;
                           }
                        }

                        --var11;
                     }

                     label556:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class4.field77[1 + var12][var8][var13] & var2)) {
                              break label556;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var47 = 240;
                        var15 = class5.field94[var12][var8][var9] - var47;
                        var16 = class5.field94[var11][var8][var9];
                        class86.method2057(var5, 1, var8 * 128, var8 * 128, var9 * 128, 128 + var10 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class4.field77[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class4.field77[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && 0 != (class4.field77[var6][var9 - 1][var7] & var3); --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class4.field77[var6][1 + var10][var7] & var3)) {
                        ++var10;
                     }

                     label620:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class4.field77[var11 - 1][var13][var7] & var3) == 0) {
                              break label620;
                           }
                        }

                        --var11;
                     }

                     label609:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class4.field77[var12 + 1][var13][var7] & var3) == 0) {
                              break label609;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var47 = 240;
                        var15 = class5.field94[var12][var9][var7] - var47;
                        var16 = class5.field94[var11][var9][var7];
                        class86.method2057(var5, 2, var9 * 128, 128 * var10 + 128, var7 * 128, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class4.field77[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class4.field77[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class4.field77[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class4.field77[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label673:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class4.field77[var6][var9 - 1][var13] & var4)) {
                              break label673;
                           }
                        }

                        --var9;
                     }

                     label662:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class4.field77[var6][1 + var10][var13] & var4) == 0) {
                              break label662;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (var10 - var9 + 1) >= 4) {
                        var13 = class5.field94[var6][var9][var11];
                        class86.method2057(var5, 4, var9 * 128, 128 * var10 + 128, var11 * 128, 128 + 128 * var12, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class4.field77[var6][var14][var15] &= ~var4;
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

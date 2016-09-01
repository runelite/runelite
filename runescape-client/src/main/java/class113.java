import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public final class class113 {
   @ObfuscatedName("ax")
   byte[] field1971 = new byte[18002];
   @ObfuscatedName("r")
   final int field1972 = 16;
   @ObfuscatedName("j")
   final int field1973 = 258;
   @ObfuscatedName("z")
   final int field1974 = 6;
   @ObfuscatedName("ao")
   int[][] field1975 = new int[6][258];
   @ObfuscatedName("b")
   final int field1976 = 18002;
   @ObfuscatedName("l")
   byte[] field1977;
   @ObfuscatedName("x")
   final int field1978 = 4096;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -103576789
   )
   int field1979;
   @ObfuscatedName("ap")
   byte[][] field1980 = new byte[6][258];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1085891799
   )
   int field1981 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -559316293
   )
   int field1982;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -120445445
   )
   int field1983;
   @ObfuscatedName("ah")
   boolean[] field1984 = new boolean[256];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1635718463
   )
   int field1985;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1427103203
   )
   int field1986;
   @ObfuscatedName("pz")
   static GarbageCollectorMXBean field1987;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1275945037
   )
   int field1988 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1690694359
   )
   int field1989;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1881241343
   )
   int field1990;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 854387805
   )
   int field1991;
   @ObfuscatedName("n")
   int[] field1992 = new int[256];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -875742479
   )
   int field1993;
   @ObfuscatedName("k")
   int[] field1994 = new int[257];
   @ObfuscatedName("ab")
   int[] field1995 = new int[6];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 311592297
   )
   int field1996;
   @ObfuscatedName("an")
   boolean[] field1997 = new boolean[16];
   @ObfuscatedName("ag")
   byte[] field1998 = new byte[256];
   @ObfuscatedName("as")
   byte[] field1999 = new byte[4096];
   @ObfuscatedName("aq")
   int[] field2000 = new int[16];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -936310109
   )
   int field2001;
   @ObfuscatedName("az")
   byte[] field2002 = new byte[18002];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -120723641
   )
   int field2003;
   @ObfuscatedName("i")
   final int field2004 = 50;
   @ObfuscatedName("af")
   int[][] field2005 = new int[6][258];
   @ObfuscatedName("au")
   int[][] field2006 = new int[6][258];
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1347907887
   )
   int field2007;
   @ObfuscatedName("f")
   byte[] field2008;
   @ObfuscatedName("cx")
   public static char field2009;
   @ObfuscatedName("t")
   byte field2010;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "-1369279206"
   )
   static final void method2480(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2441(var3, var4);
                  }
               }
            }
         }
      }

      class5.field88 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field88 < -8) {
         class5.field88 = -8;
      }

      if(class5.field88 > 8) {
         class5.field88 = 8;
      }

      class5.field89 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field89 < -16) {
         class5.field89 = -16;
      }

      if(class5.field89 > 16) {
         class5.field89 = 16;
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
         byte[][] var42 = class132.field2104[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.tileHeights[var2][1 + var12][var11] - class5.tileHeights[var2][var12 - 1][var11];
               var14 = class5.tileHeights[var2][var12][1 + var11] - class5.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (-10 * var17 + var16 * -50 + var18 * -50) / var10;
               var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11] >> 1);
               class5.field74[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class18.field257[var11] = 0;
            class5.field78[var11] = 0;
            class5.field79[var11] = 0;
            class172.field2766[var11] = 0;
            class12.field184[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field85[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class43 var43 = (class43)class43.field978.get((long)var16);
                     class43 var45;
                     if(null != var43) {
                        var45 = var43;
                     } else {
                        byte[] var44 = class43.field982.method3290(1, var16);
                        var43 = new class43();
                        if(null != var44) {
                           var43.method850(new Buffer(var44), var16);
                        }

                        var43.method843();
                        class43.field978.put(var43, (long)var16);
                        var45 = var43;
                     }

                     class18.field257[var12] += var45.field980;
                     class5.field78[var12] += var45.field981;
                     class5.field79[var12] += var45.field989;
                     class172.field2766[var12] += var45.field983;
                     ++class12.field184[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field85[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     class43 var46 = class77.method1635(var15 - 1);
                     class18.field257[var12] -= var46.field980;
                     class5.field78[var12] -= var46.field981;
                     class5.field79[var12] -= var46.field989;
                     class172.field2766[var12] -= var46.field983;
                     --class12.field184[var12];
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
                     var12 += class18.field257[var18];
                     var13 += class5.field78[var18];
                     var14 += class5.field79[var18];
                     var15 += class172.field2766[var18];
                     var16 += class12.field184[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class18.field257[var19];
                     var13 -= class5.field78[var19];
                     var14 -= class5.field79[var19];
                     var15 -= class172.field2766[var19];
                     var16 -= class12.field184[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field314 || (class5.tileSettings[0][var11][var17] & 2) != 0 || (class5.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field73) {
                        class5.field73 = var2;
                     }

                     var20 = class5.field85[var2][var11][var17] & 255;
                     int var21 = class109.field1921[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.tileHeights[var2][var11][var17];
                        int var23 = class5.tileHeights[var2][1 + var11][var17];
                        int var24 = class5.tileHeights[var2][1 + var11][var17 + 1];
                        int var25 = class5.tileHeights[var2][var11][var17 + 1];
                        int var26 = class5.field74[var11][var17];
                        int var27 = class5.field74[var11 + 1][var17];
                        int var28 = class5.field74[1 + var11][1 + var17];
                        int var29 = class5.field74[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = Widget.method3469(var32, var33, var34);
                           var32 = var32 + class5.field88 & 255;
                           var34 += class5.field89;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = Widget.method3469(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var49 = true;
                           if(var20 == 0 && class5.field75[var2][var11][var17] != 0) {
                              var49 = false;
                           }

                           if(var21 > 0 && !Player.method41(var21 - 1).field1064) {
                              var49 = false;
                           }

                           if(var49 && var22 == var23 && var24 == var22 && var25 == var22) {
                              class220.field3214[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class94.colorPalette[KitDefinition.method949(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1953(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, KitDefinition.method949(var30, var26), KitDefinition.method949(var30, var27), KitDefinition.method949(var30, var28), KitDefinition.method949(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class5.field75[var2][var11][var17] + 1;
                           byte var50 = class5.field76[var2][var11][var17];
                           class48 var35 = Player.method41(var21 - 1);
                           int var36 = var35.field1055;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class94.field1636.vmethod2226(var36);
                              var37 = -1;
                           } else if(var35.field1054 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = Widget.method3469(var35.field1058, var35.field1065, var35.field1068);
                              var39 = class5.field88 + var35.field1058 & 255;
                              var40 = class5.field89 + var35.field1068;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = Widget.method3469(var39, var35.field1065, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class94.colorPalette[class174.method3418(var38, 96)];
                           }

                           if(var35.field1057 != -1) {
                              var40 = var35.field1061 + class5.field88 & 255;
                              int var41 = class5.field89 + var35.field1063;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = Widget.method3469(var40, var35.field1062, var41);
                              var39 = class94.colorPalette[class174.method3418(var38, 96)];
                           }

                           var0.method1953(var2, var11, var17, var33, var50, var36, var22, var23, var24, var25, KitDefinition.method949(var30, var26), KitDefinition.method949(var30, var27), KitDefinition.method949(var30, var28), KitDefinition.method949(var30, var29), class174.method3418(var37, var26), class174.method3418(var37, var27), class174.method3418(var37, var28), class174.method3418(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class5.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class5.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method1987(var2, var12, var11, var17);
            }
         }

         class5.field85[var2] = null;
         class109.field1921[var2] = null;
         class5.field75[var2] = null;
         class5.field76[var2] = null;
         class132.field2104[var2] = null;
      }

      var0.method1979(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1950(var2, var3);
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
                  short var48;
                  if((class220.field3214[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class220.field3214[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class220.field3214[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label535:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class220.field3214[var11 - 1][var8][var13] & var2) == 0) {
                              break label535;
                           }
                        }

                        --var11;
                     }

                     label524:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class220.field3214[var12 + 1][var8][var13] & var2) == 0) {
                              break label524;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var48 = 240;
                        var15 = class5.tileHeights[var12][var8][var9] - var48;
                        var16 = class5.tileHeights[var11][var8][var9];
                        Region.method2098(var5, 1, 128 * var8, 128 * var8, 128 * var9, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class220.field3214[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class220.field3214[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class220.field3214[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class220.field3214[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label588:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class220.field3214[var11 - 1][var13][var7] & var3) == 0) {
                              break label588;
                           }
                        }

                        --var11;
                     }

                     label577:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class220.field3214[1 + var12][var13][var7] & var3) == 0) {
                              break label577;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var48 = 240;
                        var15 = class5.tileHeights[var12][var9][var7] - var48;
                        var16 = class5.tileHeights[var11][var9][var7];
                        Region.method2098(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class220.field3214[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class220.field3214[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class220.field3214[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class220.field3214[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label641:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class220.field3214[var6][var9 - 1][var13] & var4) == 0) {
                              break label641;
                           }
                        }

                        --var9;
                     }

                     label630:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class220.field3214[var6][var10 + 1][var13] & var4) == 0) {
                              break label630;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class5.tileHeights[var6][var9][var11];
                        Region.method2098(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class220.field3214[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LSequence;",
      garbageValue = "0"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field1010.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class181.field2967.method3290(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method861(new Buffer(var2));
         }

         var1.method863();
         Sequence.field1010.put(var1, (long)var0);
         return var1;
      }
   }
}

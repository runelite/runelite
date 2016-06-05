import java.awt.Graphics;
import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class30 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 721145903
   )
   int field695;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1022782999
   )
   int field696;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2123741815
   )
   int field697;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 346522009
   )
   int field698;
   @ObfuscatedName("t")
   String field699;
   @ObfuscatedName("e")
   static int[] field700;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;I)V",
      garbageValue = "1687264322"
   )
   static void method650(class224 var0, class224 var1) {
      if(null == class167.field2717) {
         class167.field2717 = class49.method973(class13.field203, "sl_back", "");
      }

      if(null == class110.field1956) {
         class110.field1956 = class214.method3893(class13.field203, "sl_flags", "");
      }

      if(class12.field186 == null) {
         class12.field186 = class214.method3893(class13.field203, "sl_arrows", "");
      }

      if(null == class44.field1039) {
         class44.field1039 = class214.method3893(class13.field203, "sl_stars", "");
      }

      class79.method1785(class31.field703, 23, 765, 480, 0);
      class79.method1764(class31.field703, 0, 125, 23, 12425273, 9135624);
      class79.method1764(class31.field703 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method3970("Select a world", class31.field703 + 62, 15, 0, -1);
      if(class44.field1039 != null) {
         class44.field1039[1].method1822(140 + class31.field703, 1);
         var1.method3968("Members only world", 152 + class31.field703, 10, 16777215, -1);
         class44.field1039[0].method1822(140 + class31.field703, 12);
         var1.method3968("Free world", class31.field703 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class12.field186) {
         int var2 = class31.field703 + 280;
         if(class25.field643[0] == 0 && class25.field635[0] == 0) {
            class12.field186[2].method1822(var2, 4);
         } else {
            class12.field186[0].method1822(var2, 4);
         }

         if(class25.field643[0] == 0 && class25.field635[0] == 1) {
            class12.field186[3].method1822(15 + var2, 4);
         } else {
            class12.field186[1].method1822(15 + var2, 4);
         }

         var0.method3968("World", 32 + var2, 17, 16777215, -1);
         int var3 = class31.field703 + 390;
         if(class25.field643[0] == 1 && class25.field635[0] == 0) {
            class12.field186[2].method1822(var3, 4);
         } else {
            class12.field186[0].method1822(var3, 4);
         }

         if(class25.field643[0] == 1 && class25.field635[0] == 1) {
            class12.field186[3].method1822(var3 + 15, 4);
         } else {
            class12.field186[1].method1822(var3 + 15, 4);
         }

         var0.method3968("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class31.field703;
         if(class25.field643[0] == 2 && class25.field635[0] == 0) {
            class12.field186[2].method1822(var4, 4);
         } else {
            class12.field186[0].method1822(var4, 4);
         }

         if(class25.field643[0] == 2 && class25.field635[0] == 1) {
            class12.field186[3].method1822(var4 + 15, 4);
         } else {
            class12.field186[1].method1822(var4 + 15, 4);
         }

         var0.method3968("Location", 32 + var4, 17, 16777215, -1);
         var5 = class31.field703 + 610;
         if(class25.field643[0] == 3 && class25.field635[0] == 0) {
            class12.field186[2].method1822(var5, 4);
         } else {
            class12.field186[0].method1822(var5, 4);
         }

         if(class25.field643[0] == 3 && class25.field635[0] == 1) {
            class12.field186[3].method1822(var5 + 15, 4);
         } else {
            class12.field186[1].method1822(var5 + 15, 4);
         }

         var0.method3968("Type", var5 + 32, 17, 16777215, -1);
      }

      class79.method1785(708 + class31.field703, 4, 50, 16, 0);
      var1.method3970("Cancel", class31.field703 + 708 + 25, 16, 16777215, -1);
      class31.field730 = -1;
      if(null != class167.field2717) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= class25.field629) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class25.field629) {
               --var5;
            }

            if((var5 - 1) * var4 >= class25.field629) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var23 * var4) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var24 - (var5 - 1) * var7) / 2;
         int var10 = 23 + var9;
         int var11 = class31.field703 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field629; ++var14) {
            class25 var15 = class25.field636[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field639);
            if(var15.field639 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field639 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method601()) {
               if(var15.method579()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method583()) {
               var19 = 16711680;
               if(var15.method579()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method581()) {
               if(var15.method579()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method579()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class140.field2192 >= var11 && class140.field2189 >= var10 && class140.field2192 < var23 + var11 && class140.field2189 < var24 + var10 && var16) {
               class31.field730 = var14;
               class167.field2717[var18].method1679(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class167.field2717[var18].method1727(var11, var10);
            }

            if(class110.field1956 != null) {
               class110.field1956[(var15.method579()?8:0) + var15.field642].method1822(var11 + 29, var10);
            }

            var0.method3970(Integer.toString(var15.field637 == 374?666:var15.field637), 15 + var11, 5 + var10 + var24 / 2, var19, -1);
            var1.method3970(var17, var11 + 60, var24 / 2 + var10 + 5, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3963(class25.field636[class31.field730].field633) + 6;
            int var20 = 8 + var1.field3193;
            class79.method1785(class140.field2192 - var14 / 2, 5 + 20 + class140.field2189, var14, var20, 16777120);
            class79.method1772(class140.field2192 - var14 / 2, class140.field2189 + 20 + 5, var14, var20, 0);
            var1.method3970(class25.field636[class31.field730].field633, class140.field2192, 4 + var1.field3193 + class140.field2189 + 20 + 5, 0, -1);
         }
      }

      try {
         Graphics var21 = class59.field1221.getGraphics();
         class96.field1646.vmethod1829(var21, 0, 0);
      } catch (Exception var22) {
         class59.field1221.repaint();
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Lclass112;II)Lclass112;",
      garbageValue = "1342018568"
   )
   public static class112 method651(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3145()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-735409988"
   )
   static final void method652(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field287 && var0 != class32.field754) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class214.field3161.method1990(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class214.field3161.method1897(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class214.field3161.method1914(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class214.field3161.method1899(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class214.field3161.method1994(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               class214.field3161.method1887(var0, var2, var3);
               var12 = class49.method980(var34);
               if(var12.field931 != 0) {
                  client.field344[var0].method2358(var2, var3, var35, var36, var12.field937);
               }
            }

            if(var1 == 1) {
               class214.field3161.method1926(var0, var2, var3);
            }

            if(var1 == 2) {
               class214.field3161.method1889(var0, var2, var3);
               var12 = class49.method980(var34);
               if(var2 + var12.field954 > 103 || var12.field954 + var3 > 103 || var12.field923 + var2 > 103 || var3 + var12.field923 > 103) {
                  return;
               }

               if(var12.field931 != 0) {
                  client.field344[var0].method2374(var2, var3, var12.field954, var12.field923, var36, var12.field937);
               }
            }

            if(var1 == 3) {
               class214.field3161.method2014(var0, var2, var3);
               var12 = class49.method980(var34);
               if(var12.field931 == 1) {
                  client.field344[var0].method2361(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.field83[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class86 var37 = class214.field3161;
            class108 var13 = client.field344[var0];
            class40 var14 = class49.method980(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.field954;
               var16 = var14.field923;
            } else {
               var15 = var14.field923;
               var16 = var14.field954;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (1 + var15 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = var3 + (var16 >> 1);
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class5.field100[var11];
            int var22 = var21[var17][var19] + var21[var18][var19] + var21[var17][var20] + var21[var18][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var3 << 7) + (var16 << 6);
            int var25 = 1073741824 + (var4 << 14) + (var3 << 7) + var2;
            if(var14.field924 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field944 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.field927 == -1 && var14.field955 == null) {
                  var27 = var14.method795(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 22, var5, var11, var2, var3, var14.field927, true, (class85)null);
               }

               var37.method1896(var0, var2, var3, var22, (class85)var27, var25, var26);
               if(var14.field931 == 1) {
                  var13.method2356(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.field927 == -1 && var14.field955 == null) {
                     var27 = var14.method795(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field927, true, (class85)null);
                  }

                  var37.method1880(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                  if(var14.field931 != 0) {
                     var13.method2363(var2, var3, var15, var16, var14.field937);
                  }
               } else if(var6 == 0) {
                  if(var14.field927 == -1 && var14.field955 == null) {
                     var27 = var14.method795(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 0, var5, var11, var2, var3, var14.field927, true, (class85)null);
                  }

                  var37.method2038(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field90[var5], 0, var25, var26);
                  if(var14.field931 != 0) {
                     var13.method2359(var2, var3, var6, var5, var14.field937);
                  }
               } else if(var6 == 1) {
                  if(var14.field927 == -1 && null == var14.field955) {
                     var27 = var14.method795(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class12(var4, 1, var5, var11, var2, var3, var14.field927, true, (class85)null);
                  }

                  var37.method2038(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field91[var5], 0, var25, var26);
                  if(var14.field931 != 0) {
                     var13.method2359(var2, var3, var6, var5, var14.field937);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = 1 + var5 & 3;
                     Object var33;
                     if(var14.field927 == -1 && null == var14.field955) {
                        var33 = var14.method795(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method795(2, var32, var21, var23, var22, var24);
                     } else {
                        var33 = new class12(var4, 2, 4 + var5, var11, var2, var3, var14.field927, true, (class85)null);
                        var29 = new class12(var4, 2, var32, var11, var2, var3, var14.field927, true, (class85)null);
                     }

                     var37.method2038(var0, var2, var3, var22, (class85)var33, (class85)var29, class5.field90[var5], class5.field90[var32], var25, var26);
                     if(var14.field931 != 0) {
                        var13.method2359(var2, var3, var6, var5, var14.field937);
                     }
                  } else if(var6 == 3) {
                     if(var14.field927 == -1 && var14.field955 == null) {
                        var27 = var14.method795(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 3, var5, var11, var2, var3, var14.field927, true, (class85)null);
                     }

                     var37.method2038(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field91[var5], 0, var25, var26);
                     if(var14.field931 != 0) {
                        var13.method2359(var2, var3, var6, var5, var14.field937);
                     }
                  } else if(var6 == 9) {
                     if(var14.field927 == -1 && var14.field955 == null) {
                        var27 = var14.method795(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, var6, var5, var11, var2, var3, var14.field927, true, (class85)null);
                     }

                     var37.method1880(var0, var2, var3, var22, 1, 1, (class85)var27, 0, var25, var26);
                     if(var14.field931 != 0) {
                        var13.method2363(var2, var3, var15, var16, var14.field937);
                     }
                  } else if(var6 == 4) {
                     if(var14.field927 == -1 && var14.field955 == null) {
                        var27 = var14.method795(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class12(var4, 4, var5, var11, var2, var3, var14.field927, true, (class85)null);
                     }

                     var37.method2022(var0, var2, var3, var22, (class85)var27, (class85)null, class5.field90[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var28;
                     if(var6 == 5) {
                        var32 = 16;
                        var28 = var37.method1990(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class49.method980(var28 >> 14 & 32767).field938;
                        }

                        if(var14.field927 == -1 && var14.field955 == null) {
                           var29 = var14.method795(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5, var11, var2, var3, var14.field927, true, (class85)null);
                        }

                        var37.method2022(var0, var2, var3, var22, (class85)var29, (class85)null, class5.field90[var5], 0, class5.field85[var5] * var32, class5.field93[var5] * var32, var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var28 = var37.method1990(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class49.method980(var28 >> 14 & 32767).field938 / 2;
                        }

                        if(var14.field927 == -1 && null == var14.field955) {
                           var29 = var14.method795(4, 4 + var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, var5 + 4, var11, var2, var3, var14.field927, true, (class85)null);
                        }

                        var37.method2022(var0, var2, var3, var22, (class85)var29, (class85)null, 256, var5, class5.field82[var5] * var32, class5.field95[var5] * var32, var25, var26);
                     } else if(var6 == 7) {
                        var28 = var5 + 2 & 3;
                        if(var14.field927 == -1 && var14.field955 == null) {
                           var27 = var14.method795(4, var28 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class12(var4, 4, var28 + 4, var11, var2, var3, var14.field927, true, (class85)null);
                        }

                        var37.method2022(var0, var2, var3, var22, (class85)var27, (class85)null, 256, var28, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var28 = var37.method1990(var0, var2, var3);
                        if(var28 != 0) {
                           var32 = class49.method980(var28 >> 14 & 32767).field938 / 2;
                        }

                        int var31 = 2 + var5 & 3;
                        Object var30;
                        if(var14.field927 == -1 && null == var14.field955) {
                           var29 = var14.method795(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method795(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class12(var4, 4, 4 + var5, var11, var2, var3, var14.field927, true, (class85)null);
                           var30 = new class12(var4, 4, var31 + 4, var11, var2, var3, var14.field927, true, (class85)null);
                        }

                        var37.method2022(var0, var2, var3, var22, (class85)var29, (class85)var30, 256, var5, var32 * class5.field82[var5], class5.field95[var5] * var32, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.field927 == -1 && var14.field955 == null) {
                  var27 = var14.method795(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class12(var4, 10, var5, var11, var2, var3, var14.field927, true, (class85)null);
               }

               if(var27 != null) {
                  var37.method1880(var0, var2, var3, var22, var15, var16, (class85)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field931 != 0) {
                  var13.method2363(var2, var3, var15, var16, var14.field937);
               }
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "205070172"
   )
   static final int method653() {
      if(class116.field1988.field138) {
         return class32.field754;
      } else {
         int var0 = 3;
         if(class138.field2164 < 310) {
            int var1 = class9.field155 >> 7;
            int var2 = class4.field81 >> 7;
            int var3 = class152.field2301.field809 >> 7;
            int var4 = class152.field2301.field804 >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class32.field754;
            }

            if((class5.field83[class32.field754][var1][var2] & 4) != 0) {
               var0 = class32.field754;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = 65536 * var6 / var5;
               var8 = '耀';

               while(var3 != var1) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.field83[class32.field754][var1][var2] & 4) != 0) {
                     var0 = class32.field754;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.field83[class32.field754][var1][var2] & 4) != 0) {
                        var0 = class32.field754;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class5.field83[class32.field754][var1][var2] & 4) != 0) {
                     var0 = class32.field754;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.field83[class32.field754][var1][var2] & 4) != 0) {
                        var0 = class32.field754;
                     }
                  }
               }
            }
         }

         if(class152.field2301.field809 >= 0 && class152.field2301.field804 >= 0 && class152.field2301.field809 < 13312 && class152.field2301.field804 < 13312) {
            if((class5.field83[class32.field754][class152.field2301.field809 >> 7][class152.field2301.field804 >> 7] & 4) != 0) {
               var0 = class32.field754;
            }

            return var0;
         } else {
            return class32.field754;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1611781199"
   )
   public static void method654(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            var2 = class56.method1187(var1);
         }

         if(null != var0) {
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class148.field2257) {
            return;
         }

         URL var3 = new URL(class148.field2257.getCodeBase(), "clienterror.ws?c=" + class163.field2680 + "&u=" + class139.field2169 + "&v1=" + class136.field2114 + "&v2=" + class136.field2124 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   static final void method655(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field536 + (client.field419 - client.field536) * var5 / 100;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < client.field526) {
         var15 = client.field526;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 > client.field541) {
            var6 = client.field541;
            var8 = 512 * var6 * var3 / (334 * var15);
            var9 = (var2 - var8) / 2;
            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > client.field543) {
         var15 = client.field543;
         var6 = var2 * var15 * 334 / (512 * var3);
         if(var6 < client.field540) {
            var6 = client.field540;
            var8 = var2 * var15 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = (client.field518 - client.field538) * var5 / 100 + client.field538;
      client.field548 = var3 * var6 * var8 / 85504 << 1;
      if(client.field414 != var2 || var3 != client.field547) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 32 * var10 + 128;
            int var12 = 600 + 3 * var11;
            int var13 = class91.field1602[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         class86.method1905(var14, 500, 800, var2, var3);
      }

      client.field544 = var0;
      client.field489 = var1;
      client.field414 = var2;
      client.field547 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1845544659"
   )
   public static int method656(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}

import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public final class class104 {
   @ObfuscatedName("dc")
   static int[][] field1786;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 410703093
   )
   int field1787;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 260227291
   )
   int field1788;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 698065621
   )
   int field1789;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -952703531
   )
   int field1790;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2064954135
   )
   int field1792;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1464697365
   )
   int field1793;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1477277413
   )
   int field1794;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1818816991
   )
   int field1795;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1961488603
   )
   int field1796;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1582841353
   )
   int field1797;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -656883075
   )
   int field1798;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1610303413
   )
   int field1800;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1054261839
   )
   int field1801;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 363347993
   )
   int field1802;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -756970653
   )
   int field1803;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1305531603
   )
   int field1804;
   @ObfuscatedName("al")
   static class146 field1805;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1169295405
   )
   int field1806;
   @ObfuscatedName("cj")
   static class224 field1807;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1471922435
   )
   int field1808;

   @ObfuscatedName("w")
   public static final void method2291(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class56.method1238(var0 - 1L);
            class56.method1238(1L);
         } else {
            class56.method1238(var0);
         }

      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIBI)V",
      garbageValue = "54740063"
   )
   static final void method2292(class2 var0, int var1, int var2, byte var3) {
      int var4 = var0.field872[0];
      int var5 = var0.field873[0];
      int var6 = var0.method15();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method15();
            class107 var9 = class124.method2792(var1, var2);
            class108 var10 = client.field372[var0.field62];
            int[] var11 = client.field574;
            int[] var12 = client.field575;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class106.field1877[var13][var14] = 0;
                  class106.field1878[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            boolean var32;
            int var34;
            int var35;
            int var37;
            if(1 == var8) {
               var32 = class106.method2378(var4, var5, var9, var10);
            } else if(2 == var8) {
               var15 = var4;
               var16 = var5;
               byte var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class106.field1877[var17][var18] = 99;
               class106.field1878[var17][var18] = 0;
               byte var21 = 0;
               var22 = 0;
               class106.field1881[var21] = var4;
               var37 = var21 + 1;
               class106.field1879[var21] = var5;
               int[][] var23 = var10.field1894;

               boolean var33;
               while(true) {
                  if(var22 == var37) {
                     class106.field1876 = var15;
                     class131.field2071 = var16;
                     var33 = false;
                     break;
                  }

                  var15 = class106.field1881[var22];
                  var16 = class106.field1879[var22];
                  var22 = var22 + 1 & 4095;
                  var34 = var15 - var19;
                  var35 = var16 - var20;
                  var24 = var15 - var10.field1902;
                  var25 = var16 - var10.field1903;
                  if(var9.vmethod2389(var15, var16)) {
                     class106.field1876 = var15;
                     class131.field2071 = var16;
                     var33 = true;
                     break;
                  }

                  var26 = 1 + class106.field1878[var34][var35];
                  if(var34 > 0 && 0 == class106.field1877[var34 - 1][var35] && 0 == (var23[var24 - 1][var25] & 19136782) && 0 == (var23[var24 - 1][1 + var25] & 19136824)) {
                     class106.field1881[var37] = var15 - 1;
                     class106.field1879[var37] = var16;
                     var37 = var37 + 1 & 4095;
                     class106.field1877[var34 - 1][var35] = 2;
                     class106.field1878[var34 - 1][var35] = var26;
                  }

                  if(var34 < 126 && 0 == class106.field1877[var34 + 1][var35] && (var23[var24 + 2][var25] & 19136899) == 0 && 0 == (var23[var24 + 2][var25 + 1] & 19136992)) {
                     class106.field1881[var37] = 1 + var15;
                     class106.field1879[var37] = var16;
                     var37 = 1 + var37 & 4095;
                     class106.field1877[var34 + 1][var35] = 8;
                     class106.field1878[var34 + 1][var35] = var26;
                  }

                  if(var35 > 0 && class106.field1877[var34][var35 - 1] == 0 && 0 == (var23[var24][var25 - 1] & 19136782) && (var23[1 + var24][var25 - 1] & 19136899) == 0) {
                     class106.field1881[var37] = var15;
                     class106.field1879[var37] = var16 - 1;
                     var37 = 1 + var37 & 4095;
                     class106.field1877[var34][var35 - 1] = 1;
                     class106.field1878[var34][var35 - 1] = var26;
                  }

                  if(var35 < 126 && 0 == class106.field1877[var34][var35 + 1] && 0 == (var23[var24][2 + var25] & 19136824) && (var23[var24 + 1][2 + var25] & 19136992) == 0) {
                     class106.field1881[var37] = var15;
                     class106.field1879[var37] = var16 + 1;
                     var37 = 1 + var37 & 4095;
                     class106.field1877[var34][1 + var35] = 4;
                     class106.field1878[var34][1 + var35] = var26;
                  }

                  if(var34 > 0 && var35 > 0 && 0 == class106.field1877[var34 - 1][var35 - 1] && 0 == (var23[var24 - 1][var25] & 19136830) && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24][var25 - 1] & 19136911) == 0) {
                     class106.field1881[var37] = var15 - 1;
                     class106.field1879[var37] = var16 - 1;
                     var37 = var37 + 1 & 4095;
                     class106.field1877[var34 - 1][var35 - 1] = 3;
                     class106.field1878[var34 - 1][var35 - 1] = var26;
                  }

                  if(var34 < 126 && var35 > 0 && class106.field1877[var34 + 1][var35 - 1] == 0 && 0 == (var23[1 + var24][var25 - 1] & 19136911) && 0 == (var23[var24 + 2][var25 - 1] & 19136899) && 0 == (var23[var24 + 2][var25] & 19136995)) {
                     class106.field1881[var37] = var15 + 1;
                     class106.field1879[var37] = var16 - 1;
                     var37 = 1 + var37 & 4095;
                     class106.field1877[1 + var34][var35 - 1] = 9;
                     class106.field1878[var34 + 1][var35 - 1] = var26;
                  }

                  if(var34 > 0 && var35 < 126 && 0 == class106.field1877[var34 - 1][1 + var35] && 0 == (var23[var24 - 1][1 + var25] & 19136830) && (var23[var24 - 1][2 + var25] & 19136824) == 0 && (var23[var24][var25 + 2] & 19137016) == 0) {
                     class106.field1881[var37] = var15 - 1;
                     class106.field1879[var37] = 1 + var16;
                     var37 = var37 + 1 & 4095;
                     class106.field1877[var34 - 1][var35 + 1] = 6;
                     class106.field1878[var34 - 1][var35 + 1] = var26;
                  }

                  if(var34 < 126 && var35 < 126 && class106.field1877[var34 + 1][1 + var35] == 0 && (var23[1 + var24][var25 + 2] & 19137016) == 0 && (var23[2 + var24][2 + var25] & 19136992) == 0 && 0 == (var23[2 + var24][1 + var25] & 19136995)) {
                     class106.field1881[var37] = var15 + 1;
                     class106.field1879[var37] = 1 + var16;
                     var37 = 1 + var37 & 4095;
                     class106.field1877[var34 + 1][var35 + 1] = 12;
                     class106.field1878[var34 + 1][var35 + 1] = var26;
                  }
               }

               var32 = var33;
            } else {
               var32 = class150.method3170(var4, var5, var8, var9, var10);
            }

            int var7;
            label461: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class106.field1876;
               var34 = class131.field2071;
               if(!var32) {
                  var35 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var36 = 10;
                  var37 = var9.field1892;
                  var22 = var9.field1887;
                  int var38 = var9.field1888;
                  var24 = var9.field1889;

                  for(var25 = var37 - var36; var25 <= var37 + var36; ++var25) {
                     for(var26 = var22 - var36; var26 <= var36 + var22; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class106.field1878[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var37) {
                              var29 = var37 - var25;
                           } else if(var25 > var37 + var38 - 1) {
                              var29 = var25 - (var38 + var37 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var22 + var24 - 1) {
                              var30 = var26 - (var24 + var22 - 1);
                           }

                           int var31 = var29 * var29 + var30 * var30;
                           if(var31 < var35 || var31 == var35 && class106.field1878[var27][var28] < var19) {
                              var35 = var31;
                              var19 = class106.field1878[var27][var28];
                              var16 = var25;
                              var34 = var26;
                           }
                        }
                     }
                  }

                  if(Integer.MAX_VALUE == var35) {
                     var7 = -1;
                     break label461;
                  }
               }

               if(var4 == var16 && var5 == var34) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class106.field1881[var18] = var16;
                  var35 = var18 + 1;
                  class106.field1879[var18] = var34;

                  for(var19 = var20 = class106.field1877[var16 - var14][var34 - var15]; var16 != var4 || var5 != var34; var19 = class106.field1877[var16 - var14][var34 - var15]) {
                     if(var19 != var20) {
                        var20 = var19;
                        class106.field1881[var35] = var16;
                        class106.field1879[var35++] = var34;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var34;
                     } else if((var19 & 4) != 0) {
                        --var34;
                     }
                  }

                  var37 = 0;

                  while(var35-- > 0) {
                     var11[var37] = class106.field1881[var35];
                     var12[var37++] = class106.field1879[var35];
                     if(var37 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var37;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method18(client.field574[var14], client.field575[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("t")
   static void method2293(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field188.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class27();
         class11.field188.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method647(var0, var1, var2, var3);
      class11.field186.method3822(var5, (long)var5.field794);
      class11.field185.method3870(var5);
      client.field457 = client.field491;
   }

   @ObfuscatedName("v")
   public static boolean method2294(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("t")
   public static class227 method2295(String var0, String var1, boolean var2) {
      File var3 = new File(class149.field2255, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(33 == class149.field2262) {
         var4 = "_rc";
      } else if(class149.field2262 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class48.field1098, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("w")
   public static String method2296(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class162.field2670[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("dx")
   static void method2297(int var0) {
      for(class201 var1 = (class201)client.field501.method3805(); null != var1; var1 = (class201)client.field501.method3809()) {
         if((long)var0 == (var1.field3123 >> 48 & 65535L)) {
            var1.method3935();
         }
      }

   }
}

import java.awt.Graphics;
import java.util.Date;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class171 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1768881967
   )
   public static int field2709 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1081911851
   )
   public static int field2710 = 0;
   @ObfuscatedName("p")
   public static class119 field2711 = new class119(8);
   @ObfuscatedName("e")
   public static class196 field2712 = new class196(32);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1069770225
   )
   public static int field2713 = 0;
   @ObfuscatedName("n")
   public static class196 field2715 = new class196(4096);
   @ObfuscatedName("c")
   public static class203 field2716 = new class203();
   @ObfuscatedName("u")
   public static class196 field2717 = new class196(4096);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -179289251
   )
   public static int field2718 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -365067975
   )
   public static int field2719 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -426005679
   )
   public static int field2720 = 0;
   @ObfuscatedName("y")
   public static CRC32 field2721 = new CRC32();
   @ObfuscatedName("g")
   public static class168[] field2722 = new class168[256];
   @ObfuscatedName("s")
   public static byte field2723 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -715977875
   )
   public static int field2724 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 783569313
   )
   public static int field2725 = 0;
   @ObfuscatedName("km")
   static class131 field2726;
   @ObfuscatedName("z")
   public static class196 field2728 = new class196(4096);

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1"
   )
   static final void method3355(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = class37.field797.method4004(var0, 250);
      int var6 = class37.field797.method4040(var0, 250) * 13;
      class79.method1783(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 0);
      class79.method1801(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class37.field797.method4008(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class43.method889(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);

      try {
         Graphics var7 = class3.field66.getGraphics();
         class75.field1363.vmethod1873(var7, 0, 0);
      } catch (Exception var8) {
         class3.field66.repaint();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "200000"
   )
   static void method3356(class0 var0, int var1) {
      Object[] var2 = var0.field16;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class49.method1008(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field576;
         int[] var9 = var4.field571;
         byte var10 = -1;
         class36.field786 = 0;

         int var13;
         try {
            class36.field791 = new int[var4.field578];
            int var11 = 0;
            class36.field777 = new String[var4.field575];
            int var25 = 0;

            int var14;
            String var36;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(-2147483647 == var14) {
                     var14 = var0.field3;
                  }

                  if(-2147483646 == var14) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field18 != null?var0.field18.field2774:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field5;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field18?var0.field18.field2798:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field6?var0.field6.field2774:-1;
                  }

                  if(-2147483641 == var14) {
                     var14 = var0.field6 != null?var0.field6.field2798:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field8;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field0;
                  }

                  class36.field791[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var36 = (String)var2[var13];
                  if(var36.equals("event_opbase")) {
                     var36 = var0.field10;
                  }

                  class36.field777[var25++] = var36;
               }
            }

            var13 = 0;
            class36.field787 = var0.field7;

            label3744:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var24 = var8[var7];
               int var15;
               int var29;
               int var37;
               int[] var60;
               byte var71;
               String[] var73;
               String var75;
               if(var24 < 100) {
                  if(0 == var24) {
                     class36.field780[var5++] = var9[var7];
                     continue;
                  }

                  if(1 == var24) {
                     var14 = var9[var7];
                     class36.field780[var5++] = class176.field2900[var14];
                     continue;
                  }

                  if(var24 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2900[var14] = class36.field780[var5];
                     class48.method989(var14);
                     continue;
                  }

                  if(var24 == 3) {
                     class36.field781[var6++] = var4.field574[var7];
                     continue;
                  }

                  if(6 == var24) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(7 == var24) {
                     var5 -= 2;
                     if(class36.field780[var5] != class36.field780[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var24) {
                     var5 -= 2;
                     if(class36.field780[1 + var5] == class36.field780[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var24 == 9) {
                     var5 -= 2;
                     if(class36.field780[var5] < class36.field780[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(10 == var24) {
                     var5 -= 2;
                     if(class36.field780[var5] > class36.field780[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var24 == 21) {
                     if(class36.field786 == 0) {
                        return;
                     }

                     class14 var67 = class36.field783[--class36.field786];
                     var4 = var67.field205;
                     var8 = var4.field576;
                     var9 = var4.field571;
                     var7 = var67.field198;
                     class36.field791 = var67.field199;
                     class36.field777 = var67.field200;
                     continue;
                  }

                  if(25 == var24) {
                     var14 = var9[var7];
                     class36.field780[var5++] = class59.method1263(var14);
                     continue;
                  }

                  if(var24 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class18.method197(var14, class36.field780[var5]);
                     continue;
                  }

                  if(31 == var24) {
                     var5 -= 2;
                     if(class36.field780[var5] <= class36.field780[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var24 == 32) {
                     var5 -= 2;
                     if(class36.field780[var5] >= class36.field780[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var24 == 33) {
                     class36.field780[var5++] = class36.field791[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var24 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field791[var10001] = class36.field780[var5];
                     continue;
                  }

                  if(35 == var24) {
                     class36.field781[var6++] = class36.field777[var9[var7]];
                     continue;
                  }

                  if(36 == var24) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field777[var10001] = class36.field781[var6];
                     continue;
                  }

                  if(var24 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var75 = class142.method2962(class36.field781, var6, var14);
                     class36.field781[var6++] = var75;
                     continue;
                  }

                  if(var24 == 38) {
                     --var5;
                     continue;
                  }

                  if(39 == var24) {
                     --var6;
                     continue;
                  }

                  if(40 == var24) {
                     var14 = var9[var7];
                     class22 var97 = class49.method1008(var14);
                     var60 = new int[var97.field578];
                     var73 = new String[var97.field575];

                     for(var37 = 0; var37 < var97.field577; ++var37) {
                        var60[var37] = class36.field780[var5 - var97.field577 + var37];
                     }

                     for(var37 = 0; var37 < var97.field581; ++var37) {
                        var73[var37] = class36.field781[var6 - var97.field581 + var37];
                     }

                     var5 -= var97.field577;
                     var6 -= var97.field581;
                     class14 var92 = new class14();
                     var92.field205 = var4;
                     var92.field198 = var7;
                     var92.field199 = class36.field791;
                     var92.field200 = class36.field777;
                     class36.field783[++class36.field786 - 1] = var92;
                     var4 = var97;
                     var8 = var97.field576;
                     var9 = var97.field571;
                     var7 = -1;
                     class36.field791 = var60;
                     class36.field777 = var73;
                     continue;
                  }

                  if(42 == var24) {
                     class36.field780[var5++] = class27.field651.method203(var9[var7]);
                     continue;
                  }

                  if(var24 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class27.field651.method202(var10001, class36.field780[var5]);
                     continue;
                  }

                  if(var24 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var29 = class36.field780[var5];
                     if(var29 >= 0 && var29 <= 5000) {
                        class36.field784[var14] = var29;
                        var71 = -1;
                        if(var15 == 105) {
                           var71 = 0;
                        }

                        var37 = 0;

                        while(true) {
                           if(var37 >= var29) {
                              continue label3744;
                           }

                           class36.field779[var14][var37] = var71;
                           ++var37;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(45 == var24) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 >= 0 && var15 < class36.field784[var14]) {
                        class36.field780[var5++] = class36.field779[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var24) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class36.field780[var5];
                     if(var15 >= 0 && var15 < class36.field784[var14]) {
                        class36.field779[var14][var15] = class36.field780[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var24 == 47) {
                     var36 = class27.field651.method217(var9[var7]);
                     if(null == var36) {
                        var36 = "null";
                     }

                     class36.field781[var6++] = var36;
                     continue;
                  }

                  if(var24 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class27.field651.method204(var10001, class36.field781[var6]);
                     continue;
                  }
               }

               boolean var44;
               if(1 == var9[var7]) {
                  var44 = true;
               } else {
                  var44 = false;
               }

               class173 var16;
               int var20;
               class173 var26;
               int var27;
               class173 var31;
               class173 var35;
               boolean var51;
               boolean var59;
               int[] var94;
               if(var24 < 1000) {
                  if(var24 == 100) {
                     var5 -= 3;
                     var15 = class36.field780[var5];
                     var29 = class36.field780[1 + var5];
                     var27 = class36.field780[var5 + 2];
                     if(var29 == 0) {
                        throw new RuntimeException();
                     }

                     var31 = class141.method2959(var15);
                     if(null == var31.field2868) {
                        var31.field2868 = new class173[var27 + 1];
                     }

                     if(var31.field2868.length <= var27) {
                        class173[] var78 = new class173[var27 + 1];

                        for(var20 = 0; var20 < var31.field2868.length; ++var20) {
                           var78[var20] = var31.field2868[var20];
                        }

                        var31.field2868 = var78;
                     }

                     if(var27 > 0 && null == var31.field2868[var27 - 1]) {
                        throw new RuntimeException("" + (var27 - 1));
                     }

                     class173 var79 = new class173();
                     var79.field2820 = var29;
                     var79.field2763 = var79.field2774 = var31.field2774;
                     var79.field2798 = var27;
                     var79.field2768 = true;
                     var31.field2868[var27] = var79;
                     if(var44) {
                        class142.field2155 = var79;
                     } else {
                        class36.field775 = var79;
                     }

                     class2.method28(var31);
                     continue;
                  }

                  if(101 == var24) {
                     var26 = var44?class142.field2155:class36.field775;
                     var16 = class141.method2959(var26.field2774);
                     var16.field2868[var26.field2798] = null;
                     class2.method28(var16);
                     continue;
                  }

                  if(var24 == 102) {
                     --var5;
                     var26 = class141.method2959(class36.field780[var5]);
                     var26.field2868 = null;
                     class2.method28(var26);
                     continue;
                  }

                  if(200 == var24) {
                     var5 -= 2;
                     var15 = class36.field780[var5];
                     var29 = class36.field780[1 + var5];
                     var35 = class46.method972(var15, var29);
                     if(null != var35 && var29 != -1) {
                        class36.field780[var5++] = 1;
                        if(var44) {
                           class142.field2155 = var35;
                        } else {
                           class36.field775 = var35;
                        }
                        continue;
                     }

                     class36.field780[var5++] = 0;
                     continue;
                  }

                  if(var24 == 201) {
                     --var5;
                     var26 = class141.method2959(class36.field780[var5]);
                     if(null != var26) {
                        class36.field780[var5++] = 1;
                        if(var44) {
                           class142.field2155 = var26;
                        } else {
                           class36.field775 = var26;
                        }
                     } else {
                        class36.field780[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var24 < 1000 || var24 >= 1100) && (var24 < 2000 || var24 >= 2100)) {
                     String var28;
                     if((var24 < 1100 || var24 >= 1200) && (var24 < 2100 || var24 >= 2200)) {
                        if((var24 < 1200 || var24 >= 1300) && (var24 < 2200 || var24 >= 2300)) {
                           if((var24 < 1300 || var24 >= 1400) && (var24 < 2300 || var24 >= 2400)) {
                              String var49;
                              int var50;
                              if(var24 >= 1400 && var24 < 1500 || var24 >= 2400 && var24 < 2500) {
                                 if(var24 >= 2000) {
                                    var24 -= 1000;
                                    --var5;
                                    var26 = class141.method2959(class36.field780[var5]);
                                 } else {
                                    var26 = var44?class142.field2155:class36.field775;
                                 }

                                 --var6;
                                 var49 = class36.field781[var6];
                                 int[] var81 = null;
                                 if(var49.length() > 0 && var49.charAt(var49.length() - 1) == 89) {
                                    --var5;
                                    var37 = class36.field780[var5];
                                    if(var37 > 0) {
                                       for(var81 = new int[var37]; var37-- > 0; var81[var37] = class36.field780[var5]) {
                                          --var5;
                                       }
                                    }

                                    var49 = var49.substring(0, var49.length() - 1);
                                 }

                                 Object[] var83 = new Object[var49.length() + 1];

                                 for(var50 = var83.length - 1; var50 >= 1; --var50) {
                                    if(var49.charAt(var50 - 1) == 115) {
                                       --var6;
                                       var83[var50] = class36.field781[var6];
                                    } else {
                                       --var5;
                                       var83[var50] = new Integer(class36.field780[var5]);
                                    }
                                 }

                                 --var5;
                                 var50 = class36.field780[var5];
                                 if(var50 != -1) {
                                    var83[0] = new Integer(var50);
                                 } else {
                                    var83 = null;
                                 }

                                 if(var24 == 1400) {
                                    var26.field2826 = var83;
                                 }

                                 if(1401 == var24) {
                                    var26.field2829 = var83;
                                 }

                                 if(1402 == var24) {
                                    var26.field2828 = var83;
                                 }

                                 if(1403 == var24) {
                                    var26.field2842 = var83;
                                 }

                                 if(var24 == 1404) {
                                    var26.field2851 = var83;
                                 }

                                 if(var24 == 1405) {
                                    var26.field2804 = var83;
                                 }

                                 if(1406 == var24) {
                                    var26.field2836 = var83;
                                 }

                                 if(var24 == 1407) {
                                    var26.field2800 = var83;
                                    var26.field2838 = var81;
                                 }

                                 if(var24 == 1408) {
                                    var26.field2843 = var83;
                                 }

                                 if(1409 == var24) {
                                    var26.field2844 = var83;
                                 }

                                 if(1410 == var24) {
                                    var26.field2834 = var83;
                                 }

                                 if(1411 == var24) {
                                    var26.field2827 = var83;
                                 }

                                 if(var24 == 1412) {
                                    var26.field2794 = var83;
                                 }

                                 if(var24 == 1414) {
                                    var26.field2769 = var83;
                                    var26.field2878 = var81;
                                 }

                                 if(1415 == var24) {
                                    var26.field2841 = var83;
                                    var26.field2764 = var81;
                                 }

                                 if(1416 == var24) {
                                    var26.field2865 = var83;
                                 }

                                 if(var24 == 1417) {
                                    var26.field2845 = var83;
                                 }

                                 if(1418 == var24) {
                                    var26.field2744 = var83;
                                 }

                                 if(1419 == var24) {
                                    var26.field2785 = var83;
                                 }

                                 if(var24 == 1420) {
                                    var26.field2855 = var83;
                                 }

                                 if(var24 == 1421) {
                                    var26.field2835 = var83;
                                 }

                                 if(1422 == var24) {
                                    var26.field2850 = var83;
                                 }

                                 if(var24 == 1423) {
                                    var26.field2824 = var83;
                                 }

                                 if(1424 == var24) {
                                    var26.field2852 = var83;
                                 }

                                 if(1425 == var24) {
                                    var26.field2854 = var83;
                                 }

                                 if(var24 == 1426) {
                                    var26.field2830 = var83;
                                 }

                                 if(1427 == var24) {
                                    var26.field2858 = var83;
                                 }

                                 var26.field2809 = true;
                                 continue;
                              }

                              if(var24 < 1600) {
                                 var26 = var44?class142.field2155:class36.field775;
                                 if(var24 == 1500) {
                                    class36.field780[var5++] = var26.field2796;
                                    continue;
                                 }

                                 if(var24 == 1501) {
                                    class36.field780[var5++] = var26.field2758;
                                    continue;
                                 }

                                 if(var24 == 1502) {
                                    class36.field780[var5++] = var26.field2840;
                                    continue;
                                 }

                                 if(1503 == var24) {
                                    class36.field780[var5++] = var26.field2746;
                                    continue;
                                 }

                                 if(1504 == var24) {
                                    class36.field780[var5++] = var26.field2759?1:0;
                                    continue;
                                 }

                                 if(1505 == var24) {
                                    class36.field780[var5++] = var26.field2763;
                                    continue;
                                 }
                              } else if(var24 < 1700) {
                                 var26 = var44?class142.field2155:class36.field775;
                                 if(var24 == 1600) {
                                    class36.field780[var5++] = var26.field2765;
                                    continue;
                                 }

                                 if(1601 == var24) {
                                    class36.field780[var5++] = var26.field2766;
                                    continue;
                                 }

                                 if(1602 == var24) {
                                    class36.field781[var6++] = var26.field2875;
                                    continue;
                                 }

                                 if(1603 == var24) {
                                    class36.field780[var5++] = var26.field2837;
                                    continue;
                                 }

                                 if(1604 == var24) {
                                    class36.field780[var5++] = var26.field2784;
                                    continue;
                                 }

                                 if(1605 == var24) {
                                    class36.field780[var5++] = var26.field2743;
                                    continue;
                                 }

                                 if(1606 == var24) {
                                    class36.field780[var5++] = var26.field2795;
                                    continue;
                                 }

                                 if(1607 == var24) {
                                    class36.field780[var5++] = var26.field2797;
                                    continue;
                                 }

                                 if(1608 == var24) {
                                    class36.field780[var5++] = var26.field2832;
                                    continue;
                                 }

                                 if(var24 == 1609) {
                                    class36.field780[var5++] = var26.field2775;
                                    continue;
                                 }

                                 if(var24 == 1610) {
                                    class36.field780[var5++] = var26.field2847;
                                    continue;
                                 }

                                 if(var24 == 1611) {
                                    class36.field780[var5++] = var26.field2790;
                                    continue;
                                 }

                                 if(var24 == 1612) {
                                    class36.field780[var5++] = var26.field2770;
                                    continue;
                                 }

                                 if(1613 == var24) {
                                    class36.field780[var5++] = var26.field2788.vmethod3136();
                                    continue;
                                 }
                              } else if(var24 < 1800) {
                                 var26 = var44?class142.field2155:class36.field775;
                                 if(var24 == 1700) {
                                    class36.field780[var5++] = var26.field2773;
                                    continue;
                                 }

                                 if(1701 == var24) {
                                    if(-1 != var26.field2773) {
                                       class36.field780[var5++] = var26.field2738;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var24 == 1702) {
                                    class36.field780[var5++] = var26.field2798;
                                    continue;
                                 }
                              } else if(var24 < 1900) {
                                 var26 = var44?class142.field2155:class36.field775;
                                 if(1800 == var24) {
                                    class36.field780[var5++] = class159.method3139(class144.method3075(var26));
                                    continue;
                                 }

                                 if(1801 == var24) {
                                    --var5;
                                    var29 = class36.field780[var5];
                                    --var29;
                                    if(null != var26.field2818 && var29 < var26.field2818.length && null != var26.field2818[var29]) {
                                       class36.field781[var6++] = var26.field2818[var29];
                                       continue;
                                    }

                                    class36.field781[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 1802) {
                                    if(var26.field2817 == null) {
                                       class36.field781[var6++] = "";
                                    } else {
                                       class36.field781[var6++] = var26.field2817;
                                    }
                                    continue;
                                 }
                              } else if(var24 >= 1900 && var24 < 2000 || var24 >= 2900 && var24 < 3000) {
                                 if(var24 >= 2000) {
                                    var24 -= 1000;
                                    --var5;
                                    var26 = class141.method2959(class36.field780[var5]);
                                 } else {
                                    var26 = var44?class142.field2155:class36.field775;
                                 }

                                 if(var24 == 1927) {
                                    if(class36.field787 >= 10) {
                                       throw new RuntimeException();
                                    }

                                    if(null == var26.field2858) {
                                       return;
                                    }

                                    class0 var88 = new class0();
                                    var88.field18 = var26;
                                    var88.field16 = var26.field2858;
                                    var88.field7 = class36.field787 + 1;
                                    client.field472.method3779(var0);
                                    continue;
                                 }
                              } else if(var24 < 2600) {
                                 --var5;
                                 var26 = class141.method2959(class36.field780[var5]);
                                 if(2500 == var24) {
                                    class36.field780[var5++] = var26.field2796;
                                    continue;
                                 }

                                 if(var24 == 2501) {
                                    class36.field780[var5++] = var26.field2758;
                                    continue;
                                 }

                                 if(2502 == var24) {
                                    class36.field780[var5++] = var26.field2840;
                                    continue;
                                 }

                                 if(2503 == var24) {
                                    class36.field780[var5++] = var26.field2746;
                                    continue;
                                 }

                                 if(2504 == var24) {
                                    class36.field780[var5++] = var26.field2759?1:0;
                                    continue;
                                 }

                                 if(2505 == var24) {
                                    class36.field780[var5++] = var26.field2763;
                                    continue;
                                 }
                              } else if(var24 < 2700) {
                                 --var5;
                                 var26 = class141.method2959(class36.field780[var5]);
                                 if(2600 == var24) {
                                    class36.field780[var5++] = var26.field2765;
                                    continue;
                                 }

                                 if(2601 == var24) {
                                    class36.field780[var5++] = var26.field2766;
                                    continue;
                                 }

                                 if(2602 == var24) {
                                    class36.field781[var6++] = var26.field2875;
                                    continue;
                                 }

                                 if(2603 == var24) {
                                    class36.field780[var5++] = var26.field2837;
                                    continue;
                                 }

                                 if(2604 == var24) {
                                    class36.field780[var5++] = var26.field2784;
                                    continue;
                                 }

                                 if(var24 == 2605) {
                                    class36.field780[var5++] = var26.field2743;
                                    continue;
                                 }

                                 if(var24 == 2606) {
                                    class36.field780[var5++] = var26.field2795;
                                    continue;
                                 }

                                 if(var24 == 2607) {
                                    class36.field780[var5++] = var26.field2797;
                                    continue;
                                 }

                                 if(var24 == 2608) {
                                    class36.field780[var5++] = var26.field2832;
                                    continue;
                                 }

                                 if(2609 == var24) {
                                    class36.field780[var5++] = var26.field2775;
                                    continue;
                                 }

                                 if(var24 == 2610) {
                                    class36.field780[var5++] = var26.field2847;
                                    continue;
                                 }

                                 if(2611 == var24) {
                                    class36.field780[var5++] = var26.field2790;
                                    continue;
                                 }

                                 if(var24 == 2612) {
                                    class36.field780[var5++] = var26.field2770;
                                    continue;
                                 }

                                 if(var24 == 2613) {
                                    class36.field780[var5++] = var26.field2788.vmethod3136();
                                    continue;
                                 }
                              } else if(var24 < 2800) {
                                 if(var24 == 2700) {
                                    --var5;
                                    var26 = class141.method2959(class36.field780[var5]);
                                    class36.field780[var5++] = var26.field2773;
                                    continue;
                                 }

                                 if(var24 == 2701) {
                                    --var5;
                                    var26 = class141.method2959(class36.field780[var5]);
                                    if(var26.field2773 != -1) {
                                       class36.field780[var5++] = var26.field2738;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(2702 == var24) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class3 var41 = (class3)client.field434.method3742((long)var15);
                                    if(null != var41) {
                                       class36.field780[var5++] = 1;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var24 == 2706) {
                                    class36.field780[var5++] = client.field433;
                                    continue;
                                 }
                              } else if(var24 < 2900) {
                                 --var5;
                                 var26 = class141.method2959(class36.field780[var5]);
                                 if(var24 == 2800) {
                                    class36.field780[var5++] = class159.method3139(class144.method3075(var26));
                                    continue;
                                 }

                                 if(var24 == 2801) {
                                    --var5;
                                    var29 = class36.field780[var5];
                                    --var29;
                                    if(var26.field2818 != null && var29 < var26.field2818.length && null != var26.field2818[var29]) {
                                       class36.field781[var6++] = var26.field2818[var29];
                                       continue;
                                    }

                                    class36.field781[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 2802) {
                                    if(var26.field2817 == null) {
                                       class36.field781[var6++] = "";
                                    } else {
                                       class36.field781[var6++] = var26.field2817;
                                    }
                                    continue;
                                 }
                              } else if(var24 < 3200) {
                                 if(3100 == var24) {
                                    --var6;
                                    var75 = class36.field781[var6];
                                    class8.method109(0, "", var75);
                                    continue;
                                 }

                                 if(var24 == 3101) {
                                    var5 -= 2;
                                    class3.method30(class47.field1053, class36.field780[var5], class36.field780[var5 + 1]);
                                    continue;
                                 }

                                 if(var24 == 3103) {
                                    class136.method2873();
                                    continue;
                                 }

                                 if(var24 == 3104) {
                                    --var6;
                                    var75 = class36.field781[var6];
                                    var29 = 0;
                                    if(class82.method1878(var75)) {
                                       var29 = class93.method2161(var75);
                                    }

                                    client.field318.method2735(35);
                                    client.field318.method2488(var29);
                                    continue;
                                 }

                                 if(var24 == 3105) {
                                    --var6;
                                    var75 = class36.field781[var6];
                                    client.field318.method2735(128);
                                    client.field318.method2503(var75.length() + 1);
                                    client.field318.method2491(var75);
                                    continue;
                                 }

                                 if(var24 == 3106) {
                                    --var6;
                                    var75 = class36.field781[var6];
                                    client.field318.method2735(214);
                                    client.field318.method2503(var75.length() + 1);
                                    client.field318.method2491(var75);
                                    continue;
                                 }

                                 if(var24 == 3107) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    --var6;
                                    var49 = class36.field781[var6];
                                    var27 = class32.field737;
                                    int[] var32 = class32.field738;
                                    boolean var33 = false;

                                    for(var20 = 0; var20 < var27; ++var20) {
                                       class2 var21 = client.field396[var32[var20]];
                                       if(null != var21 && class47.field1053 != var21 && null != var21.field58 && var21.field58.equalsIgnoreCase(var49)) {
                                          if(var15 == 1) {
                                             client.field318.method2735(202);
                                             client.field318.method2642(var32[var20]);
                                             client.field318.method2601(0);
                                          } else if(var15 == 4) {
                                             client.field318.method2735(80);
                                             client.field318.method2486(var32[var20]);
                                             client.field318.method2597(0);
                                          } else if(6 == var15) {
                                             client.field318.method2735(19);
                                             client.field318.method2533(var32[var20]);
                                             client.field318.method2523(0);
                                          } else if(7 == var15) {
                                             client.field318.method2735(3);
                                             client.field318.method2601(0);
                                             client.field318.method2486(var32[var20]);
                                          }

                                          var33 = true;
                                          break;
                                       }
                                    }

                                    if(!var33) {
                                       class8.method109(4, "", "Unable to find " + var49);
                                    }
                                    continue;
                                 }

                                 if(var24 == 3108) {
                                    var5 -= 3;
                                    var15 = class36.field780[var5];
                                    var29 = class36.field780[var5 + 1];
                                    var27 = class36.field780[var5 + 2];
                                    var31 = class141.method2959(var27);
                                    class119.method2701(var31, var15, var29);
                                    continue;
                                 }

                                 if(var24 == 3109) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    var29 = class36.field780[var5 + 1];
                                    var35 = var44?class142.field2155:class36.field775;
                                    class119.method2701(var35, var15, var29);
                                    continue;
                                 }

                                 if(var24 == 3110) {
                                    --var5;
                                    class139.field2116 = class36.field780[var5] == 1;
                                    continue;
                                 }

                                 if(var24 == 3111) {
                                    class36.field780[var5++] = class4.field75.field145?1:0;
                                    continue;
                                 }

                                 if(3112 == var24) {
                                    --var5;
                                    class4.field75.field145 = class36.field780[var5] == 1;
                                    class45.method946();
                                    continue;
                                 }

                                 if(var24 == 3113) {
                                    --var6;
                                    var75 = class36.field781[var6];
                                    --var5;
                                    var51 = class36.field780[var5] == 1;
                                    class46.method970(var75, var51, false);
                                    continue;
                                 }

                                 if(3115 == var24) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    client.field318.method2735(228);
                                    client.field318.method2486(var15);
                                    continue;
                                 }

                                 if(3116 == var24) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    var6 -= 2;
                                    var49 = class36.field781[var6];
                                    var28 = class36.field781[1 + var6];
                                    if(var49.length() <= 500 && var28.length() <= 500) {
                                       client.field318.method2735(231);
                                       client.field318.method2486(1 + class116.method2447(var49) + class116.method2447(var28));
                                       client.field318.method2491(var28);
                                       client.field318.method2597(var15);
                                       client.field318.method2491(var49);
                                    }
                                    continue;
                                 }
                              } else if(var24 < 3300) {
                                 if(3200 == var24) {
                                    var5 -= 3;
                                    var15 = class36.field780[var5];
                                    var29 = class36.field780[1 + var5];
                                    var27 = class36.field780[var5 + 2];
                                    if(0 != client.field513 && var29 != 0 && client.field515 < 50) {
                                       client.field439[client.field515] = var15;
                                       client.field460[client.field515] = var29;
                                       client.field518[client.field515] = var27;
                                       client.field543[client.field515] = null;
                                       client.field519[client.field515] = 0;
                                       ++client.field515;
                                    }
                                    continue;
                                 }

                                 if(var24 == 3201) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    if(var15 == -1 && !client.field512) {
                                       class168.method3332();
                                    } else if(-1 != var15 && client.field532 != var15 && client.field409 != 0 && !client.field512) {
                                       class168 var58 = class135.field2069;
                                       var27 = client.field409;
                                       class183.field2959 = 1;
                                       class76.field1370 = var58;
                                       class183.field2960 = var15;
                                       class183.field2961 = 0;
                                       class183.field2957 = var27;
                                       class183.field2964 = false;
                                       class183.field2963 = 2;
                                    }

                                    client.field532 = var15;
                                    continue;
                                 }

                                 if(3202 == var24) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    int var10000 = class36.field780[var5 + 1];
                                    if(0 != client.field409 && var15 != -1) {
                                       class126.method2783(class136.field2080, var15, 0, client.field409, false);
                                       client.field512 = true;
                                    }
                                    continue;
                                 }
                              } else if(var24 < 3400) {
                                 if(3300 == var24) {
                                    class36.field780[var5++] = client.field285;
                                    continue;
                                 }

                                 if(var24 == 3301) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    var29 = class36.field780[1 + var5];
                                    class36.field780[var5++] = class31.method689(var15, var29);
                                    continue;
                                 }

                                 if(3302 == var24) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    var29 = class36.field780[1 + var5];
                                    class36.field780[var5++] = class104.method2283(var15, var29);
                                    continue;
                                 }

                                 if(var24 == 3303) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5];
                                    var29 = class36.field780[1 + var5];
                                    class36.field780[var5++] = class17.method190(var15, var29);
                                    continue;
                                 }

                                 if(var24 == 3304) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    var60 = class36.field780;
                                    var27 = var5++;
                                    class50 var38 = (class50)class50.field1077.method3704((long)var15);
                                    class50 var34;
                                    if(null != var38) {
                                       var34 = var38;
                                    } else {
                                       byte[] var40 = class50.field1082.method3217(5, var15);
                                       var38 = new class50();
                                       if(var40 != null) {
                                          var38.method1016(new class119(var40));
                                       }

                                       class50.field1077.method3706(var38, (long)var15);
                                       var34 = var38;
                                    }

                                    var60[var27] = var34.field1079;
                                    continue;
                                 }

                                 if(3305 == var24) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class36.field780[var5++] = client.field419[var15];
                                    continue;
                                 }

                                 if(var24 == 3306) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class36.field780[var5++] = client.field411[var15];
                                    continue;
                                 }

                                 if(3307 == var24) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class36.field780[var5++] = client.field412[var15];
                                    continue;
                                 }

                                 if(var24 == 3308) {
                                    var15 = class28.field655;
                                    var29 = (class47.field1053.field816 >> 7) + class187.field3014;
                                    var27 = class0.field12 + (class47.field1053.field840 >> 7);
                                    class36.field780[var5++] = var27 + (var29 << 14) + (var15 << 28);
                                    continue;
                                 }

                                 if(var24 == 3309) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class36.field780[var5++] = var15 >> 14 & 16383;
                                    continue;
                                 }

                                 if(3310 == var24) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class36.field780[var5++] = var15 >> 28;
                                    continue;
                                 }

                                 if(var24 == 3311) {
                                    --var5;
                                    var15 = class36.field780[var5];
                                    class36.field780[var5++] = var15 & 16383;
                                    continue;
                                 }

                                 if(var24 == 3312) {
                                    class36.field780[var5++] = client.field279?1:0;
                                    continue;
                                 }

                                 if(3313 == var24) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5] + '耀';
                                    var29 = class36.field780[var5 + 1];
                                    class36.field780[var5++] = class31.method689(var15, var29);
                                    continue;
                                 }

                                 if(3314 == var24) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5] + '耀';
                                    var29 = class36.field780[1 + var5];
                                    class36.field780[var5++] = class104.method2283(var15, var29);
                                    continue;
                                 }

                                 if(var24 == 3315) {
                                    var5 -= 2;
                                    var15 = class36.field780[var5] + '耀';
                                    var29 = class36.field780[var5 + 1];
                                    class36.field780[var5++] = class17.method190(var15, var29);
                                    continue;
                                 }

                                 if(3316 == var24) {
                                    if(client.field440 >= 2) {
                                       class36.field780[var5++] = client.field440;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var24 == 3317) {
                                    class36.field780[var5++] = client.field404;
                                    continue;
                                 }

                                 if(3318 == var24) {
                                    class36.field780[var5++] = client.field274;
                                    continue;
                                 }

                                 if(3321 == var24) {
                                    class36.field780[var5++] = client.field438;
                                    continue;
                                 }

                                 if(var24 == 3322) {
                                    class36.field780[var5++] = client.field413;
                                    continue;
                                 }

                                 if(var24 == 3323) {
                                    if(client.field376) {
                                       class36.field780[var5++] = 1;
                                    } else {
                                       class36.field780[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var24 == 3324) {
                                    class36.field780[var5++] = client.field492;
                                    continue;
                                 }
                              } else {
                                 int var46;
                                 if(var24 < 3500) {
                                    if(3400 == var24) {
                                       var5 -= 2;
                                       var15 = class36.field780[var5];
                                       var29 = class36.field780[var5 + 1];
                                       class48 var39 = (class48)class48.field1062.method3704((long)var15);
                                       class48 var48;
                                       if(null != var39) {
                                          var48 = var39;
                                       } else {
                                          byte[] var47 = class48.field1067.method3217(8, var15);
                                          var39 = new class48();
                                          if(null != var47) {
                                             var39.method984(new class119(var47));
                                          }

                                          class48.field1062.method3706(var39, (long)var15);
                                          var48 = var39;
                                       }

                                       var39 = var48;
                                       if(var48.field1060 != 115) {
                                          ;
                                       }

                                       for(var50 = 0; var50 < var39.field1063; ++var50) {
                                          if(var39.field1058[var50] == var29) {
                                             class36.field781[var6++] = var39.field1066[var50];
                                             var39 = null;
                                             break;
                                          }
                                       }

                                       if(var39 != null) {
                                          class36.field781[var6++] = var39.field1064;
                                       }
                                       continue;
                                    }

                                    if(3408 == var24) {
                                       var5 -= 4;
                                       var15 = class36.field780[var5];
                                       var29 = class36.field780[1 + var5];
                                       var27 = class36.field780[2 + var5];
                                       var37 = class36.field780[var5 + 3];
                                       class48 var42 = (class48)class48.field1062.method3704((long)var27);
                                       class48 var43;
                                       if(null != var42) {
                                          var43 = var42;
                                       } else {
                                          byte[] var45 = class48.field1067.method3217(8, var27);
                                          var42 = new class48();
                                          if(null != var45) {
                                             var42.method984(new class119(var45));
                                          }

                                          class48.field1062.method3706(var42, (long)var27);
                                          var43 = var42;
                                       }

                                       var42 = var43;
                                       if(var15 == var43.field1059 && var43.field1060 == var29) {
                                          for(var46 = 0; var46 < var42.field1063; ++var46) {
                                             if(var37 == var42.field1058[var46]) {
                                                if(var29 == 115) {
                                                   class36.field781[var6++] = var42.field1066[var46];
                                                } else {
                                                   class36.field780[var5++] = var42.field1065[var46];
                                                }

                                                var42 = null;
                                                break;
                                             }
                                          }

                                          if(var42 != null) {
                                             if(var29 == 115) {
                                                class36.field781[var6++] = var42.field1064;
                                             } else {
                                                class36.field780[var5++] = var42.field1057;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var29 == 115) {
                                          class36.field781[var6++] = "null";
                                       } else {
                                          class36.field780[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    String var53;
                                    if(var24 < 3700) {
                                       if(var24 == 3600) {
                                          if(client.field271 == 0) {
                                             class36.field780[var5++] = -2;
                                          } else if(1 == client.field271) {
                                             class36.field780[var5++] = -1;
                                          } else {
                                             class36.field780[var5++] = client.field348;
                                          }
                                          continue;
                                       }

                                       if(var24 == 3601) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(2 == client.field271 && var15 < client.field348) {
                                             class36.field781[var6++] = client.field428[var15].field239;
                                             class36.field781[var6++] = client.field428[var15].field238;
                                             continue;
                                          }

                                          class36.field781[var6++] = "";
                                          class36.field781[var6++] = "";
                                          continue;
                                       }

                                       if(var24 == 3602) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field271 == 2 && var15 < client.field348) {
                                             class36.field780[var5++] = client.field428[var15].field237;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(3603 == var24) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field271 == 2 && var15 < client.field348) {
                                             class36.field780[var5++] = client.field428[var15].field240;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(3604 == var24) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          --var5;
                                          var29 = class36.field780[var5];
                                          class103.method2276(var75, var29);
                                          continue;
                                       }

                                       String var55;
                                       class7 var56;
                                       class17 var57;
                                       if(3605 == var24) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          if(null == var75) {
                                             continue;
                                          }

                                          if((client.field348 < 200 || 1 == client.field398) && client.field348 < 400) {
                                             var49 = class75.method1629(var75, client.field278);
                                             if(null == var49) {
                                                continue;
                                             }

                                             for(var27 = 0; var27 < client.field348; ++var27) {
                                                var57 = client.field428[var27];
                                                var55 = class75.method1629(var57.field239, client.field278);
                                                if(null != var55 && var55.equals(var49)) {
                                                   class8.method109(30, "", var75 + " is already on your friend list");
                                                   continue label3744;
                                                }

                                                if(var57.field238 != null) {
                                                   var53 = class75.method1629(var57.field238, client.field278);
                                                   if(null != var53 && var53.equals(var49)) {
                                                      class8.method109(30, "", var75 + " is already on your friend list");
                                                      continue label3744;
                                                   }
                                                }
                                             }

                                             for(var27 = 0; var27 < client.field544; ++var27) {
                                                var56 = client.field545[var27];
                                                var55 = class75.method1629(var56.field131, client.field278);
                                                if(null != var55 && var55.equals(var49)) {
                                                   class8.method109(30, "", "Please remove " + var75 + " from your ignore list first");
                                                   continue label3744;
                                                }

                                                if(var56.field133 != null) {
                                                   var53 = class75.method1629(var56.field133, client.field278);
                                                   if(null != var53 && var53.equals(var49)) {
                                                      class8.method109(30, "", "Please remove " + var75 + " from your ignore list first");
                                                      continue label3744;
                                                   }
                                                }
                                             }

                                             if(class75.method1629(class47.field1053.field58, client.field278).equals(var49)) {
                                                class8.method109(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                client.field318.method2735(32);
                                                client.field318.method2503(class116.method2447(var75));
                                                client.field318.method2491(var75);
                                             }
                                             continue;
                                          }

                                          class8.method109(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var24 == 3606) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          if(var75 == null) {
                                             continue;
                                          }

                                          var49 = class75.method1629(var75, client.field278);
                                          if(var49 == null) {
                                             continue;
                                          }

                                          var27 = 0;

                                          while(true) {
                                             if(var27 >= client.field348) {
                                                continue label3744;
                                             }

                                             var57 = client.field428[var27];
                                             var55 = var57.field239;
                                             var53 = class75.method1629(var55, client.field278);
                                             if(class102.method2274(var75, var49, var55, var53)) {
                                                --client.field348;

                                                for(var46 = var27; var46 < client.field348; ++var46) {
                                                   client.field428[var46] = client.field428[1 + var46];
                                                }

                                                client.field466 = client.field458;
                                                client.field318.method2735(71);
                                                client.field318.method2503(class116.method2447(var75));
                                                client.field318.method2491(var75);
                                                continue label3744;
                                             }

                                             ++var27;
                                          }
                                       }

                                       if(3607 == var24) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          if(var75 == null) {
                                             continue;
                                          }

                                          if((client.field544 < 100 || client.field398 == 1) && client.field544 < 400) {
                                             var49 = class75.method1629(var75, client.field278);
                                             if(var49 == null) {
                                                continue;
                                             }

                                             for(var27 = 0; var27 < client.field544; ++var27) {
                                                var56 = client.field545[var27];
                                                var55 = class75.method1629(var56.field131, client.field278);
                                                if(null != var55 && var55.equals(var49)) {
                                                   class8.method109(31, "", var75 + " is already on your ignore list");
                                                   continue label3744;
                                                }

                                                if(null != var56.field133) {
                                                   var53 = class75.method1629(var56.field133, client.field278);
                                                   if(null != var53 && var53.equals(var49)) {
                                                      class8.method109(31, "", var75 + " is already on your ignore list");
                                                      continue label3744;
                                                   }
                                                }
                                             }

                                             for(var27 = 0; var27 < client.field348; ++var27) {
                                                var57 = client.field428[var27];
                                                var55 = class75.method1629(var57.field239, client.field278);
                                                if(null != var55 && var55.equals(var49)) {
                                                   class8.method109(31, "", "Please remove " + var75 + " from your friend list first");
                                                   continue label3744;
                                                }

                                                if(var57.field238 != null) {
                                                   var53 = class75.method1629(var57.field238, client.field278);
                                                   if(var53 != null && var53.equals(var49)) {
                                                      class8.method109(31, "", "Please remove " + var75 + " from your friend list first");
                                                      continue label3744;
                                                   }
                                                }
                                             }

                                             if(class75.method1629(class47.field1053.field58, client.field278).equals(var49)) {
                                                class8.method109(31, "", "You can\'t add yourself to your own ignore list");
                                             } else {
                                                client.field318.method2735(150);
                                                client.field318.method2503(class116.method2447(var75));
                                                client.field318.method2491(var75);
                                             }
                                             continue;
                                          }

                                          class8.method109(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var24 == 3608) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          if(var75 == null) {
                                             continue;
                                          }

                                          var49 = class75.method1629(var75, client.field278);
                                          if(var49 == null) {
                                             continue;
                                          }

                                          var27 = 0;

                                          while(true) {
                                             if(var27 >= client.field544) {
                                                continue label3744;
                                             }

                                             var56 = client.field545[var27];
                                             var55 = var56.field131;
                                             var53 = class75.method1629(var55, client.field278);
                                             if(class102.method2274(var75, var49, var55, var53)) {
                                                --client.field544;

                                                for(var46 = var27; var46 < client.field544; ++var46) {
                                                   client.field545[var46] = client.field545[var46 + 1];
                                                }

                                                client.field466 = client.field458;
                                                client.field318.method2735(46);
                                                client.field318.method2503(class116.method2447(var75));
                                                client.field318.method2491(var75);
                                                continue label3744;
                                             }

                                             ++var27;
                                          }
                                       }

                                       if(3609 == var24) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          class152[] var65 = class168.method3331();

                                          for(var27 = 0; var27 < var65.length; ++var27) {
                                             class152 var54 = var65[var27];
                                             if(var54.field2251 != -1 && var75.startsWith(class7.method106(var54.field2251))) {
                                                var75 = var75.substring(6 + Integer.toString(var54.field2251).length());
                                                break;
                                             }
                                          }

                                          class36.field780[var5++] = class109.method2418(var75, false)?1:0;
                                          continue;
                                       }

                                       String var52;
                                       String[] var84;
                                       if(var24 == 3611) {
                                          if(null != client.field416) {
                                             var84 = class36.field781;
                                             var29 = var6++;
                                             var52 = client.field416;
                                             var55 = class104.method2281(class23.method597(var52));
                                             if(null == var55) {
                                                var55 = "";
                                             }

                                             var84[var29] = var55;
                                          } else {
                                             class36.field781[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(3612 == var24) {
                                          if(client.field416 != null) {
                                             class36.field780[var5++] = class37.field853;
                                          } else {
                                             class36.field780[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var24 == 3613) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field416 != null && var15 < class37.field853) {
                                             class36.field781[var6++] = class123.field2005[var15].field607;
                                             continue;
                                          }

                                          class36.field781[var6++] = "";
                                          continue;
                                       }

                                       if(3614 == var24) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(null != client.field416 && var15 < class37.field853) {
                                             class36.field780[var5++] = class123.field2005[var15].field605;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var24 == 3615) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(client.field416 != null && var15 < class37.field853) {
                                             class36.field780[var5++] = class123.field2005[var15].field606;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(3616 == var24) {
                                          class36.field780[var5++] = class109.field1890;
                                          continue;
                                       }

                                       if(var24 == 3617) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          class138.method2907(var75);
                                          continue;
                                       }

                                       if(3618 == var24) {
                                          class36.field780[var5++] = class59.field1204;
                                          continue;
                                       }

                                       if(var24 == 3619) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          if(!var75.equals("")) {
                                             client.field318.method2735(133);
                                             client.field318.method2503(class116.method2447(var75));
                                             client.field318.method2491(var75);
                                          }
                                          continue;
                                       }

                                       if(3620 == var24) {
                                          client.field318.method2735(133);
                                          client.field318.method2503(0);
                                          continue;
                                       }

                                       if(3621 == var24) {
                                          if(0 == client.field271) {
                                             class36.field780[var5++] = -1;
                                          } else {
                                             class36.field780[var5++] = client.field544;
                                          }
                                          continue;
                                       }

                                       if(var24 == 3622) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(0 != client.field271 && var15 < client.field544) {
                                             class36.field781[var6++] = client.field545[var15].field131;
                                             class36.field781[var6++] = client.field545[var15].field133;
                                             continue;
                                          }

                                          class36.field781[var6++] = "";
                                          class36.field781[var6++] = "";
                                          continue;
                                       }

                                       if(3623 == var24) {
                                          --var6;
                                          var75 = class36.field781[var6];
                                          if(var75.startsWith(class7.method106(0)) || var75.startsWith(class7.method106(1))) {
                                             var75 = var75.substring(7);
                                          }

                                          class36.field780[var5++] = class18.method200(var75)?1:0;
                                          continue;
                                       }

                                       if(3624 == var24) {
                                          --var5;
                                          var15 = class36.field780[var5];
                                          if(class123.field2005 != null && var15 < class37.field853 && class123.field2005[var15].field607.equalsIgnoreCase(class47.field1053.field58)) {
                                             class36.field780[var5++] = 1;
                                             continue;
                                          }

                                          class36.field780[var5++] = 0;
                                          continue;
                                       }

                                       if(var24 == 3625) {
                                          if(null != client.field501) {
                                             var84 = class36.field781;
                                             var29 = var6++;
                                             var52 = client.field501;
                                             var55 = class104.method2281(class23.method597(var52));
                                             if(null == var55) {
                                                var55 = "";
                                             }

                                             var84[var29] = var55;
                                          } else {
                                             class36.field781[var6++] = "";
                                          }
                                          continue;
                                       }
                                    } else {
                                       long var62;
                                       if(var24 < 4000) {
                                          if(var24 == 3903) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field549[var15].method3972();
                                             continue;
                                          }

                                          if(3904 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field549[var15].field3177;
                                             continue;
                                          }

                                          if(var24 == 3905) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field549[var15].field3175;
                                             continue;
                                          }

                                          if(var24 == 3906) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field549[var15].field3176;
                                             continue;
                                          }

                                          if(var24 == 3907) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field549[var15].field3173;
                                             continue;
                                          }

                                          if(var24 == 3908) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = client.field549[var15].field3178;
                                             continue;
                                          }

                                          if(3910 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var29 = client.field549[var15].method3991();
                                             class36.field780[var5++] = 0 == var29?1:0;
                                             continue;
                                          }

                                          if(3911 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var29 = client.field549[var15].method3991();
                                             class36.field780[var5++] = var29 == 2?1:0;
                                             continue;
                                          }

                                          if(var24 == 3912) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var29 = client.field549[var15].method3991();
                                             class36.field780[var5++] = 5 == var29?1:0;
                                             continue;
                                          }

                                          if(3913 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var29 = client.field549[var15].method3991();
                                             class36.field780[var5++] = var29 == 1?1:0;
                                             continue;
                                          }

                                          boolean var90;
                                          if(var24 == 3914) {
                                             --var5;
                                             var90 = class36.field780[var5] == 1;
                                             if(client.field556 != null) {
                                                client.field556.method3992(class221.field3182, var90);
                                             }
                                             continue;
                                          }

                                          if(var24 == 3915) {
                                             --var5;
                                             var90 = class36.field780[var5] == 1;
                                             if(null != client.field556) {
                                                client.field556.method3992(class221.field3180, var90);
                                             }
                                             continue;
                                          }

                                          if(3916 == var24) {
                                             var5 -= 2;
                                             var90 = 1 == class36.field780[var5];
                                             var51 = 1 == class36.field780[var5 + 1];
                                             if(client.field556 != null) {
                                                client.field556.method3992(new class21(var51), var90);
                                             }
                                             continue;
                                          }

                                          if(3917 == var24) {
                                             --var5;
                                             var90 = class36.field780[var5] == 1;
                                             if(null != client.field556) {
                                                client.field556.method3992(class221.field3181, var90);
                                             }
                                             continue;
                                          }

                                          if(3918 == var24) {
                                             --var5;
                                             var90 = class36.field780[var5] == 1;
                                             if(client.field556 != null) {
                                                client.field556.method3992(class221.field3183, var90);
                                             }
                                             continue;
                                          }

                                          if(var24 == 3919) {
                                             class36.field780[var5++] = null == client.field556?0:client.field556.field3179.size();
                                             continue;
                                          }

                                          class214 var70;
                                          if(3920 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             class36.field780[var5++] = var70.field3162;
                                             continue;
                                          }

                                          if(var24 == 3921) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             class36.field781[var6++] = var70.method3920();
                                             continue;
                                          }

                                          if(3922 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             class36.field781[var6++] = var70.method3918();
                                             continue;
                                          }

                                          if(var24 == 3923) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             var62 = class77.method1674() - class149.field2223 - var70.field3156;
                                             var50 = (int)(var62 / 3600000L);
                                             var20 = (int)((var62 - (long)(3600000 * var50)) / 60000L);
                                             var46 = (int)((var62 - (long)(3600000 * var50) - (long)(var20 * '\uea60')) / 1000L);
                                             String var22 = var50 + ":" + var20 / 10 + var20 % 10 + ":" + var46 / 10 + var46 % 10;
                                             class36.field781[var6++] = var22;
                                             continue;
                                          }

                                          if(var24 == 3924) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             class36.field780[var5++] = var70.field3158.field3176;
                                             continue;
                                          }

                                          if(3925 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             class36.field780[var5++] = var70.field3158.field3175;
                                             continue;
                                          }

                                          if(var24 == 3926) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var70 = (class214)client.field556.field3179.get(var15);
                                             class36.field780[var5++] = var70.field3158.field3177;
                                             continue;
                                          }
                                       } else if(var24 < 4100) {
                                          if(var24 == 4000) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var29 + var15;
                                             continue;
                                          }

                                          if(4001 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 - var29;
                                             continue;
                                          }

                                          if(var24 == 4002) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var29 * var15;
                                             continue;
                                          }

                                          if(var24 == 4003) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 / var29;
                                             continue;
                                          }

                                          if(var24 == 4004) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = (int)(Math.random() * (double)var15);
                                             continue;
                                          }

                                          if(4005 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = (int)(Math.random() * (double)(1 + var15));
                                             continue;
                                          }

                                          if(4006 == var24) {
                                             var5 -= 5;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             var27 = class36.field780[2 + var5];
                                             var37 = class36.field780[var5 + 3];
                                             var50 = class36.field780[var5 + 4];
                                             class36.field780[var5++] = (var29 - var15) * (var50 - var27) / (var37 - var27) + var15;
                                             continue;
                                          }

                                          if(4007 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var15 + var15 * var29 / 100;
                                             continue;
                                          }

                                          if(var24 == 4008) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 | 1 << var29;
                                             continue;
                                          }

                                          if(4009 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var15 & -1 - (1 << var29);
                                             continue;
                                          }

                                          if(4010 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = (var15 & 1 << var29) != 0?1:0;
                                             continue;
                                          }

                                          if(4011 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var15 % var29;
                                             continue;
                                          }

                                          if(var24 == 4012) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             if(0 == var15) {
                                                class36.field780[var5++] = 0;
                                             } else {
                                                class36.field780[var5++] = (int)Math.pow((double)var15, (double)var29);
                                             }
                                             continue;
                                          }

                                          if(4013 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             if(0 == var15) {
                                                class36.field780[var5++] = 0;
                                             } else if(0 == var29) {
                                                class36.field780[var5++] = Integer.MAX_VALUE;
                                             } else {
                                                class36.field780[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var29);
                                             }
                                             continue;
                                          }

                                          if(4014 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class36.field780[var5++] = var15 & var29;
                                             continue;
                                          }

                                          if(var24 == 4015) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             class36.field780[var5++] = var15 | var29;
                                             continue;
                                          }

                                          if(4018 == var24) {
                                             var5 -= 3;
                                             long var93 = (long)class36.field780[var5];
                                             var62 = (long)class36.field780[var5 + 1];
                                             long var61 = (long)class36.field780[var5 + 2];
                                             class36.field780[var5++] = (int)(var61 * var93 / var62);
                                             continue;
                                          }
                                       } else if(var24 < 4200) {
                                          if(var24 == 4100) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             class36.field781[var6++] = var75 + var29;
                                             continue;
                                          }

                                          if(var24 == 4101) {
                                             var6 -= 2;
                                             var75 = class36.field781[var6];
                                             var49 = class36.field781[1 + var6];
                                             class36.field781[var6++] = var75 + var49;
                                             continue;
                                          }

                                          if(var24 == 4102) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             var73 = class36.field781;
                                             var37 = var6++;
                                             if(var29 < 0) {
                                                var53 = Integer.toString(var29);
                                             } else {
                                                var53 = class35.method730(var29, 10, true);
                                             }

                                             var73[var37] = var75 + var53;
                                             continue;
                                          }

                                          if(var24 == 4103) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             class36.field781[var6++] = var75.toLowerCase();
                                             continue;
                                          }

                                          if(var24 == 4104) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             long var85 = 86400000L * ((long)var15 + 11745L);
                                             class36.field785.setTime(new Date(var85));
                                             var37 = class36.field785.get(5);
                                             var50 = class36.field785.get(2);
                                             var20 = class36.field785.get(1);
                                             class36.field781[var6++] = var37 + "-" + class36.field782[var50] + "-" + var20;
                                             continue;
                                          }

                                          if(4105 == var24) {
                                             var6 -= 2;
                                             var75 = class36.field781[var6];
                                             var49 = class36.field781[1 + var6];
                                             if(null != class47.field1053.field36 && class47.field1053.field36.field2920) {
                                                class36.field781[var6++] = var49;
                                                continue;
                                             }

                                             class36.field781[var6++] = var75;
                                             continue;
                                          }

                                          if(var24 == 4106) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field781[var6++] = Integer.toString(var15);
                                             continue;
                                          }

                                          if(4107 == var24) {
                                             var6 -= 2;
                                             var94 = class36.field780;
                                             var29 = var5++;
                                             var37 = class9.method132(class36.field781[var6], class36.field781[1 + var6], client.field292);
                                             if(var37 > 0) {
                                                var71 = 1;
                                             } else if(var37 < 0) {
                                                var71 = -1;
                                             } else {
                                                var71 = 0;
                                             }

                                             var94[var29] = var71;
                                             continue;
                                          }

                                          byte[] var64;
                                          class224 var66;
                                          if(4108 == var24) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             var5 -= 2;
                                             var29 = class36.field780[var5];
                                             var27 = class36.field780[var5 + 1];
                                             var64 = class123.field1997.method3217(var27, 0);
                                             var66 = new class224(var64);
                                             class36.field780[var5++] = var66.method4040(var75, var29);
                                             continue;
                                          }

                                          if(4109 == var24) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             var5 -= 2;
                                             var29 = class36.field780[var5];
                                             var27 = class36.field780[1 + var5];
                                             var64 = class123.field1997.method3217(var27, 0);
                                             var66 = new class224(var64);
                                             class36.field780[var5++] = var66.method4004(var75, var29);
                                             continue;
                                          }

                                          if(4110 == var24) {
                                             var6 -= 2;
                                             var75 = class36.field781[var6];
                                             var49 = class36.field781[1 + var6];
                                             --var5;
                                             if(class36.field780[var5] == 1) {
                                                class36.field781[var6++] = var75;
                                             } else {
                                                class36.field781[var6++] = var49;
                                             }
                                             continue;
                                          }

                                          if(var24 == 4111) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             class36.field781[var6++] = class223.method4005(var75);
                                             continue;
                                          }

                                          if(var24 == 4112) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             class36.field781[var6++] = var75 + (char)var29;
                                             continue;
                                          }

                                          char var63;
                                          if(4113 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var60 = class36.field780;
                                             var27 = var5++;
                                             var63 = (char)var15;
                                             if(var63 >= 32 && var63 <= 126) {
                                                var59 = true;
                                             } else if(var63 >= 160 && var63 <= 255) {
                                                var59 = true;
                                             } else if(var63 != 8364 && 338 != var63 && var63 != 8212 && var63 != 339 && 376 != var63) {
                                                var59 = false;
                                             } else {
                                                var59 = true;
                                             }

                                             var60[var27] = var59?1:0;
                                             continue;
                                          }

                                          if(var24 == 4114) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var60 = class36.field780;
                                             var27 = var5++;
                                             var63 = (char)var15;
                                             var59 = var63 >= 48 && var63 <= 57 || var63 >= 65 && var63 <= 90 || var63 >= 97 && var63 <= 122;
                                             var60[var27] = var59?1:0;
                                             continue;
                                          }

                                          if(4115 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class1.method6((char)var15)?1:0;
                                             continue;
                                          }

                                          if(4116 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var60 = class36.field780;
                                             var27 = var5++;
                                             var63 = (char)var15;
                                             var59 = var63 >= 48 && var63 <= 57;
                                             var60[var27] = var59?1:0;
                                             continue;
                                          }

                                          if(var24 == 4117) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             if(var75 != null) {
                                                class36.field780[var5++] = var75.length();
                                             } else {
                                                class36.field780[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(4118 == var24) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             var5 -= 2;
                                             var29 = class36.field780[var5];
                                             var27 = class36.field780[1 + var5];
                                             class36.field781[var6++] = var75.substring(var29, var27);
                                             continue;
                                          }

                                          if(var24 == 4119) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             StringBuilder var82 = new StringBuilder(var75.length());
                                             var17 = false;

                                             for(var37 = 0; var37 < var75.length(); ++var37) {
                                                var63 = var75.charAt(var37);
                                                if(var63 == 60) {
                                                   var17 = true;
                                                } else if(62 == var63) {
                                                   var17 = false;
                                                } else if(!var17) {
                                                   var82.append(var63);
                                                }
                                             }

                                             class36.field781[var6++] = var82.toString();
                                             continue;
                                          }

                                          if(4120 == var24) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             class36.field780[var5++] = var75.indexOf(var29);
                                             continue;
                                          }

                                          if(4121 == var24) {
                                             var6 -= 2;
                                             var75 = class36.field781[var6];
                                             var49 = class36.field781[var6 + 1];
                                             --var5;
                                             var27 = class36.field780[var5];
                                             class36.field780[var5++] = var75.indexOf(var49, var27);
                                             continue;
                                          }
                                       } else if(var24 < 4300) {
                                          if(var24 == 4200) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field781[var6++] = class89.method2081(var15).field1095;
                                             continue;
                                          }

                                          class51 var74;
                                          if(var24 == 4201) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             var74 = class89.method2081(var15);
                                             if(var29 >= 1 && var29 <= 5 && null != var74.field1088[var29 - 1]) {
                                                class36.field781[var6++] = var74.field1088[var29 - 1];
                                                continue;
                                             }

                                             class36.field781[var6++] = "";
                                             continue;
                                          }

                                          if(var24 == 4202) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[var5 + 1];
                                             var74 = class89.method2081(var15);
                                             if(var29 >= 1 && var29 <= 5 && var74.field1110[var29 - 1] != null) {
                                                class36.field781[var6++] = var74.field1110[var29 - 1];
                                                continue;
                                             }

                                             class36.field781[var6++] = "";
                                             continue;
                                          }

                                          if(4203 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class89.method2081(var15).field1107;
                                             continue;
                                          }

                                          if(var24 == 4204) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class89.method2081(var15).field1106 == 1?1:0;
                                             continue;
                                          }

                                          class51 var86;
                                          if(var24 == 4205) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var86 = class89.method2081(var15);
                                             if(-1 == var86.field1139 && var86.field1125 >= 0) {
                                                class36.field780[var5++] = var86.field1125;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var24 == 4206) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var86 = class89.method2081(var15);
                                             if(var86.field1139 >= 0 && var86.field1125 >= 0) {
                                                class36.field780[var5++] = var86.field1125;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var24 == 4207) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class89.method2081(var15).field1108?1:0;
                                             continue;
                                          }

                                          if(var24 == 4208) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var86 = class89.method2081(var15);
                                             if(var86.field1137 == -1 && var86.field1113 >= 0) {
                                                class36.field780[var5++] = var86.field1113;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(var24 == 4209) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var86 = class89.method2081(var15);
                                             if(var86.field1137 >= 0 && var86.field1113 >= 0) {
                                                class36.field780[var5++] = var86.field1113;
                                                continue;
                                             }

                                             class36.field780[var5++] = var15;
                                             continue;
                                          }

                                          if(4210 == var24) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             class133.method2829(var75, var29 == 1);
                                             class36.field780[var5++] = class121.field1985;
                                             continue;
                                          }

                                          if(var24 == 4211) {
                                             if(null != class36.field789 && class52.field1143 < class121.field1985) {
                                                class36.field780[var5++] = class36.field789[++class52.field1143 - 1] & '\uffff';
                                                continue;
                                             }

                                             class36.field780[var5++] = -1;
                                             continue;
                                          }

                                          if(var24 == 4212) {
                                             class52.field1143 = 0;
                                             continue;
                                          }
                                       } else if(var24 < 5100) {
                                          if(var24 == 5000) {
                                             class36.field780[var5++] = client.field491;
                                             continue;
                                          }

                                          if(5001 == var24) {
                                             var5 -= 3;
                                             client.field491 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class130[] var80 = class141.method2958();
                                             var37 = 0;

                                             class130 var95;
                                             while(true) {
                                                if(var37 >= var80.length) {
                                                   var95 = null;
                                                   break;
                                                }

                                                class130 var76 = var80[var37];
                                                if(var29 == var76.field2038) {
                                                   var95 = var76;
                                                   break;
                                                }

                                                ++var37;
                                             }

                                             class27.field653 = var95;
                                             if(class27.field653 == null) {
                                                class27.field653 = class130.field2036;
                                             }

                                             client.field287 = class36.field780[var5 + 2];
                                             client.field318.method2735(79);
                                             client.field318.method2503(client.field491);
                                             client.field318.method2503(class27.field653.field2038);
                                             client.field318.method2503(client.field287);
                                             continue;
                                          }

                                          if(var24 == 5002) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             var5 -= 2;
                                             var29 = class36.field780[var5];
                                             var27 = class36.field780[1 + var5];
                                             client.field318.method2735(53);
                                             client.field318.method2503(class116.method2447(var75) + 2);
                                             client.field318.method2491(var75);
                                             client.field318.method2503(var29 - 1);
                                             client.field318.method2503(var27);
                                             continue;
                                          }

                                          if(5003 == var24) {
                                             var5 -= 2;
                                             var15 = class36.field780[var5];
                                             var29 = class36.field780[1 + var5];
                                             class35 var77 = class37.method745(var15, var29);
                                             if(var77 != null) {
                                                class36.field780[var5++] = var77.field765;
                                                class36.field780[var5++] = var77.field763;
                                                class36.field781[var6++] = var77.field764 != null?var77.field764:"";
                                                class36.field781[var6++] = null != var77.field766?var77.field766:"";
                                                class36.field781[var6++] = var77.field768 != null?var77.field768:"";
                                             } else {
                                                class36.field780[var5++] = -1;
                                                class36.field780[var5++] = 0;
                                                class36.field781[var6++] = "";
                                                class36.field781[var6++] = "";
                                                class36.field781[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(5004 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class35 var87 = class59.method1262(var15);
                                             if(var87 != null) {
                                                class36.field780[var5++] = var87.field770;
                                                class36.field780[var5++] = var87.field763;
                                                class36.field781[var6++] = var87.field764 != null?var87.field764:"";
                                                class36.field781[var6++] = null != var87.field766?var87.field766:"";
                                                class36.field781[var6++] = null != var87.field768?var87.field768:"";
                                             } else {
                                                class36.field780[var5++] = -1;
                                                class36.field780[var5++] = 0;
                                                class36.field781[var6++] = "";
                                                class36.field781[var6++] = "";
                                                class36.field781[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(5005 == var24) {
                                             if(class27.field653 == null) {
                                                class36.field780[var5++] = -1;
                                             } else {
                                                class36.field780[var5++] = class27.field653.field2038;
                                             }
                                             continue;
                                          }

                                          if(5008 == var24) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             --var5;
                                             var29 = class36.field780[var5];
                                             var28 = var75.toLowerCase();
                                             byte var72 = 0;
                                             if(var28.startsWith("yellow:")) {
                                                var72 = 0;
                                                var75 = var75.substring("yellow:".length());
                                             } else if(var28.startsWith("red:")) {
                                                var72 = 1;
                                                var75 = var75.substring("red:".length());
                                             } else if(var28.startsWith("green:")) {
                                                var72 = 2;
                                                var75 = var75.substring("green:".length());
                                             } else if(var28.startsWith("cyan:")) {
                                                var72 = 3;
                                                var75 = var75.substring("cyan:".length());
                                             } else if(var28.startsWith("purple:")) {
                                                var72 = 4;
                                                var75 = var75.substring("purple:".length());
                                             } else if(var28.startsWith("white:")) {
                                                var72 = 5;
                                                var75 = var75.substring("white:".length());
                                             } else if(var28.startsWith("flash1:")) {
                                                var72 = 6;
                                                var75 = var75.substring("flash1:".length());
                                             } else if(var28.startsWith("flash2:")) {
                                                var72 = 7;
                                                var75 = var75.substring("flash2:".length());
                                             } else if(var28.startsWith("flash3:")) {
                                                var72 = 8;
                                                var75 = var75.substring("flash3:".length());
                                             } else if(var28.startsWith("glow1:")) {
                                                var72 = 9;
                                                var75 = var75.substring("glow1:".length());
                                             } else if(var28.startsWith("glow2:")) {
                                                var72 = 10;
                                                var75 = var75.substring("glow2:".length());
                                             } else if(var28.startsWith("glow3:")) {
                                                var72 = 11;
                                                var75 = var75.substring("glow3:".length());
                                             } else if(0 != client.field292) {
                                                if(var28.startsWith("yellow:")) {
                                                   var72 = 0;
                                                   var75 = var75.substring("yellow:".length());
                                                } else if(var28.startsWith("red:")) {
                                                   var72 = 1;
                                                   var75 = var75.substring("red:".length());
                                                } else if(var28.startsWith("green:")) {
                                                   var72 = 2;
                                                   var75 = var75.substring("green:".length());
                                                } else if(var28.startsWith("cyan:")) {
                                                   var72 = 3;
                                                   var75 = var75.substring("cyan:".length());
                                                } else if(var28.startsWith("purple:")) {
                                                   var72 = 4;
                                                   var75 = var75.substring("purple:".length());
                                                } else if(var28.startsWith("white:")) {
                                                   var72 = 5;
                                                   var75 = var75.substring("white:".length());
                                                } else if(var28.startsWith("flash1:")) {
                                                   var72 = 6;
                                                   var75 = var75.substring("flash1:".length());
                                                } else if(var28.startsWith("flash2:")) {
                                                   var72 = 7;
                                                   var75 = var75.substring("flash2:".length());
                                                } else if(var28.startsWith("flash3:")) {
                                                   var72 = 8;
                                                   var75 = var75.substring("flash3:".length());
                                                } else if(var28.startsWith("glow1:")) {
                                                   var72 = 9;
                                                   var75 = var75.substring("glow1:".length());
                                                } else if(var28.startsWith("glow2:")) {
                                                   var72 = 10;
                                                   var75 = var75.substring("glow2:".length());
                                                } else if(var28.startsWith("glow3:")) {
                                                   var72 = 11;
                                                   var75 = var75.substring("glow3:".length());
                                                }
                                             }

                                             var28 = var75.toLowerCase();
                                             byte var69 = 0;
                                             if(var28.startsWith("wave:")) {
                                                var69 = 1;
                                                var75 = var75.substring("wave:".length());
                                             } else if(var28.startsWith("wave2:")) {
                                                var69 = 2;
                                                var75 = var75.substring("wave2:".length());
                                             } else if(var28.startsWith("shake:")) {
                                                var69 = 3;
                                                var75 = var75.substring("shake:".length());
                                             } else if(var28.startsWith("scroll:")) {
                                                var69 = 4;
                                                var75 = var75.substring("scroll:".length());
                                             } else if(var28.startsWith("slide:")) {
                                                var69 = 5;
                                                var75 = var75.substring("slide:".length());
                                             } else if(client.field292 != 0) {
                                                if(var28.startsWith("wave:")) {
                                                   var69 = 1;
                                                   var75 = var75.substring("wave:".length());
                                                } else if(var28.startsWith("wave2:")) {
                                                   var69 = 2;
                                                   var75 = var75.substring("wave2:".length());
                                                } else if(var28.startsWith("shake:")) {
                                                   var69 = 3;
                                                   var75 = var75.substring("shake:".length());
                                                } else if(var28.startsWith("scroll:")) {
                                                   var69 = 4;
                                                   var75 = var75.substring("scroll:".length());
                                                } else if(var28.startsWith("slide:")) {
                                                   var69 = 5;
                                                   var75 = var75.substring("slide:".length());
                                                }
                                             }

                                             client.field318.method2735(172);
                                             client.field318.method2503(0);
                                             var20 = client.field318.field1971;
                                             client.field318.method2503(var29);
                                             client.field318.method2503(var72);
                                             client.field318.method2503(var69);
                                             class110.method2419(client.field318, var75);
                                             client.field318.method2497(client.field318.field1971 - var20);
                                             continue;
                                          }

                                          if(5009 == var24) {
                                             var6 -= 2;
                                             var75 = class36.field781[var6];
                                             var49 = class36.field781[var6 + 1];
                                             client.field318.method2735(156);
                                             client.field318.method2486(0);
                                             var27 = client.field318.field1971;
                                             client.field318.method2491(var75);
                                             class110.method2419(client.field318, var49);
                                             client.field318.method2496(client.field318.field1971 - var27);
                                             continue;
                                          }

                                          if(var24 == 5015) {
                                             if(null != class47.field1053 && class47.field1053.field58 != null) {
                                                var75 = class47.field1053.field58;
                                             } else {
                                                var75 = "";
                                             }

                                             class36.field781[var6++] = var75;
                                             continue;
                                          }

                                          if(5016 == var24) {
                                             class36.field780[var5++] = client.field287;
                                             continue;
                                          }

                                          if(5017 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             class36.field780[var5++] = class45.method938(var15);
                                             continue;
                                          }

                                          class35 var68;
                                          if(5018 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var60 = class36.field780;
                                             var27 = var5++;
                                             var68 = (class35)class11.field171.method3764((long)var15);
                                             if(var68 == null) {
                                                var37 = -1;
                                             } else if(class11.field172.field3108 == var68.field3112) {
                                                var37 = -1;
                                             } else {
                                                var37 = ((class35)var68.field3112).field765;
                                             }

                                             var60[var27] = var37;
                                             continue;
                                          }

                                          if(5019 == var24) {
                                             --var5;
                                             var15 = class36.field780[var5];
                                             var60 = class36.field780;
                                             var27 = var5++;
                                             var68 = (class35)class11.field171.method3764((long)var15);
                                             if(var68 == null) {
                                                var37 = -1;
                                             } else if(var68.field3113 == class11.field172.field3108) {
                                                var37 = -1;
                                             } else {
                                                var37 = ((class35)var68.field3113).field765;
                                             }

                                             var60[var27] = var37;
                                             continue;
                                          }

                                          if(var24 == 5020) {
                                             --var6;
                                             var75 = class36.field781[var6];
                                             if(var75.equalsIgnoreCase("toggleroof")) {
                                                class4.field75.field145 = !class4.field75.field145;
                                                class45.method946();
                                                if(class4.field75.field145) {
                                                   class8.method109(99, "", "Roofs are now all hidden");
                                                } else {
                                                   class8.method109(99, "", "Roofs will only be removed selectively");
                                                }
                                             }

                                             if(var75.equalsIgnoreCase("displayfps")) {
                                                client.field531 = !client.field531;
                                             }

                                             if(client.field440 >= 2) {
                                                if(var75.equalsIgnoreCase("fpson")) {
                                                   client.field531 = true;
                                                }

                                                if(var75.equalsIgnoreCase("fpsoff")) {
                                                   client.field531 = false;
                                                }

                                                if(var75.equalsIgnoreCase("gc")) {
                                                   System.gc();
                                                }

                                                if(var75.equalsIgnoreCase("clientdrop")) {
                                                   if(client.field305 > 0) {
                                                      class21.method579();
                                                   } else {
                                                      class13.method162(40);
                                                      class18.field257 = class99.field1660;
                                                      class99.field1660 = null;
                                                   }
                                                }

                                                if(var75.equalsIgnoreCase("errortest") && client.field431 == 2) {
                                                   throw new RuntimeException();
                                                }
                                             }

                                             client.field318.method2735(11);
                                             client.field318.method2503(var75.length() + 1);
                                             client.field318.method2491(var75);
                                             continue;
                                          }

                                          if(5021 == var24) {
                                             --var6;
                                             client.field481 = class36.field781[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(5022 == var24) {
                                             class36.field781[var6++] = client.field481;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var24 >= 2000) {
                                 var24 -= 1000;
                                 --var5;
                                 var26 = class141.method2959(class36.field780[var5]);
                              } else {
                                 var26 = var44?class142.field2155:class36.field775;
                              }

                              if(1300 == var24) {
                                 --var5;
                                 var29 = class36.field780[var5] - 1;
                                 if(var29 >= 0 && var29 <= 9) {
                                    --var6;
                                    var26.method3370(var29, class36.field781[var6]);
                                    continue;
                                 }

                                 --var6;
                                 continue;
                              }

                              if(var24 == 1301) {
                                 var5 -= 2;
                                 var29 = class36.field780[var5];
                                 var27 = class36.field780[1 + var5];
                                 var26.field2819 = class46.method972(var29, var27);
                                 continue;
                              }

                              if(1302 == var24) {
                                 --var5;
                                 var26.field2822 = class36.field780[var5] == 1;
                                 continue;
                              }

                              if(var24 == 1303) {
                                 --var5;
                                 var26.field2857 = class36.field780[var5];
                                 continue;
                              }

                              if(1304 == var24) {
                                 --var5;
                                 var26.field2821 = class36.field780[var5];
                                 continue;
                              }

                              if(var24 == 1305) {
                                 --var6;
                                 var26.field2817 = class36.field781[var6];
                                 continue;
                              }

                              if(var24 == 1306) {
                                 --var6;
                                 var26.field2823 = class36.field781[var6];
                                 continue;
                              }

                              if(var24 == 1307) {
                                 var26.field2818 = null;
                                 continue;
                              }
                           }
                        } else {
                           if(var24 >= 2000) {
                              var24 -= 1000;
                              --var5;
                              var26 = class141.method2959(class36.field780[var5]);
                           } else {
                              var26 = var44?class142.field2155:class36.field775;
                           }

                           class2.method28(var26);
                           if(var24 == 1200 || var24 == 1205 || var24 == 1212) {
                              var5 -= 2;
                              var29 = class36.field780[var5];
                              var27 = class36.field780[var5 + 1];
                              var26.field2773 = var29;
                              var26.field2738 = var27;
                              class51 var30 = class89.method2081(var29);
                              var26.field2795 = var30.field1101;
                              var26.field2832 = var30.field1084;
                              var26.field2797 = var30.field1103;
                              var26.field2793 = var30.field1104;
                              var26.field2801 = var30.field1096;
                              var26.field2743 = var30.field1100;
                              if(1205 == var24) {
                                 var26.field2802 = 0;
                              } else if(1212 == var24 | var30.field1106 == 1) {
                                 var26.field2802 = 1;
                              } else {
                                 var26.field2802 = 2;
                              }

                              if(var26.field2799 > 0) {
                                 var26.field2743 = var26.field2743 * 32 / var26.field2799;
                              } else if(var26.field2755 > 0) {
                                 var26.field2743 = var26.field2743 * 32 / var26.field2755;
                              }
                              continue;
                           }

                           if(var24 == 1201) {
                              var26.field2787 = 2;
                              --var5;
                              var26.field2776 = class36.field780[var5];
                              continue;
                           }

                           if(1202 == var24) {
                              var26.field2787 = 3;
                              var26.field2776 = class47.field1053.field36.method3446();
                              continue;
                           }
                        }
                     } else {
                        var29 = -1;
                        if(var24 >= 2000) {
                           var24 -= 1000;
                           --var5;
                           var29 = class36.field780[var5];
                           var26 = class141.method2959(var29);
                        } else {
                           var26 = var44?class142.field2155:class36.field775;
                        }

                        if(1100 == var24) {
                           var5 -= 2;
                           var26.field2765 = class36.field780[var5];
                           if(var26.field2765 > var26.field2837 - var26.field2840) {
                              var26.field2765 = var26.field2837 - var26.field2840;
                           }

                           if(var26.field2765 < 0) {
                              var26.field2765 = 0;
                           }

                           var26.field2766 = class36.field780[var5 + 1];
                           if(var26.field2766 > var26.field2784 - var26.field2746) {
                              var26.field2766 = var26.field2784 - var26.field2746;
                           }

                           if(var26.field2766 < 0) {
                              var26.field2766 = 0;
                           }

                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1101) {
                           --var5;
                           var26.field2790 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1102 == var24) {
                           --var5;
                           var26.field2760 = class36.field780[var5] == 1;
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1103) {
                           --var5;
                           var26.field2775 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1104) {
                           --var5;
                           var26.field2777 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1105 == var24) {
                           --var5;
                           var26.field2779 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1106 == var24) {
                           --var5;
                           var26.field2781 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1107 == var24) {
                           --var5;
                           var26.field2782 = class36.field780[var5] == 1;
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1108) {
                           var26.field2787 = 1;
                           --var5;
                           var26.field2776 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1109 == var24) {
                           var5 -= 6;
                           var26.field2793 = class36.field780[var5];
                           var26.field2801 = class36.field780[1 + var5];
                           var26.field2795 = class36.field780[2 + var5];
                           var26.field2832 = class36.field780[var5 + 3];
                           var26.field2797 = class36.field780[4 + var5];
                           var26.field2743 = class36.field780[5 + var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1110 == var24) {
                           --var5;
                           var27 = class36.field780[var5];
                           if(var27 != var26.field2848) {
                              var26.field2848 = var27;
                              var26.field2866 = 0;
                              var26.field2867 = 0;
                              class2.method28(var26);
                           }
                           continue;
                        }

                        if(1111 == var24) {
                           --var5;
                           var26.field2767 = class36.field780[var5] == 1;
                           class2.method28(var26);
                           continue;
                        }

                        if(1112 == var24) {
                           --var6;
                           var28 = class36.field781[var6];
                           if(!var28.equals(var26.field2875)) {
                              var26.field2875 = var28;
                              class2.method28(var26);
                           }
                           continue;
                        }

                        if(1113 == var24) {
                           --var5;
                           var26.field2803 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1114 == var24) {
                           var5 -= 3;
                           var26.field2807 = class36.field780[var5];
                           var26.field2808 = class36.field780[var5 + 1];
                           var26.field2806 = class36.field780[2 + var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1115 == var24) {
                           --var5;
                           var26.field2757 = class36.field780[var5] == 1;
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1116) {
                           --var5;
                           var26.field2783 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1117) {
                           --var5;
                           var26.field2833 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1118) {
                           --var5;
                           var26.field2745 = class36.field780[var5] == 1;
                           class2.method28(var26);
                           continue;
                        }

                        if(1119 == var24) {
                           --var5;
                           var26.field2786 = class36.field780[var5] == 1;
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1120) {
                           var5 -= 2;
                           var26.field2837 = class36.field780[var5];
                           var26.field2784 = class36.field780[1 + var5];
                           class2.method28(var26);
                           if(var29 != -1 && var26.field2820 == 0) {
                              class116.method2448(class173.field2735[var29 >> 16], var26, false);
                           }
                           continue;
                        }

                        if(1121 == var24) {
                           class19.method238(var26.field2774, var26.field2798);
                           client.field437 = var26;
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1122) {
                           --var5;
                           var26.field2780 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1123 == var24) {
                           --var5;
                           var26.field2770 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(1124 == var24) {
                           --var5;
                           var26.field2847 = class36.field780[var5];
                           class2.method28(var26);
                           continue;
                        }

                        if(var24 == 1125) {
                           --var5;
                           var27 = class36.field780[var5];
                           class82[] var18 = new class82[]{class82.field1420, class82.field1422, class82.field1414, class82.field1411, class82.field1410};
                           class82 var19 = (class82)class104.method2282(var18, var27);
                           if(null != var19) {
                              var26.field2788 = var19;
                              class2.method28(var26);
                           }
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var24 >= 2000) {
                        var24 -= 1000;
                        --var5;
                        var15 = class36.field780[var5];
                        var16 = class141.method2959(var15);
                     } else {
                        var16 = var44?class142.field2155:class36.field775;
                     }

                     if(var24 == 1000) {
                        var5 -= 4;
                        var16.field2753 = class36.field780[var5];
                        var16.field2754 = class36.field780[1 + var5];
                        var16.field2749 = class36.field780[var5 + 2];
                        var16.field2750 = class36.field780[var5 + 3];
                        class2.method28(var16);
                        class22.method587(var16);
                        if(var15 != -1 && 0 == var16.field2820) {
                           class116.method2448(class173.field2735[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(1001 == var24) {
                        var5 -= 4;
                        var16.field2755 = class36.field780[var5];
                        var16.field2756 = class36.field780[1 + var5];
                        var16.field2751 = class36.field780[2 + var5];
                        var16.field2752 = class36.field780[3 + var5];
                        class2.method28(var16);
                        class22.method587(var16);
                        if(var15 != -1 && 0 == var16.field2820) {
                           class116.method2448(class173.field2735[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(1003 == var24) {
                        --var5;
                        var17 = class36.field780[var5] == 1;
                        if(var16.field2759 != var17) {
                           var16.field2759 = var17;
                           class2.method28(var16);
                        }
                        continue;
                     }

                     if(1005 == var24) {
                        --var5;
                        var16.field2877 = class36.field780[var5] == 1;
                        continue;
                     }

                     if(1006 == var24) {
                        --var5;
                        var16.field2741 = class36.field780[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var24 < 5400) {
                  if(var24 == 5306) {
                     var94 = class36.field780;
                     var29 = var5++;
                     var27 = client.field487?2:1;
                     var94[var29] = var27;
                     continue;
                  }

                  if(5307 == var24) {
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 != 1 && 2 != var15) {
                        continue;
                     }

                     client.field486 = 0L;
                     if(var15 >= 2) {
                        client.field487 = true;
                     } else {
                        client.field487 = false;
                     }

                     class44.method933();
                     if(client.field283 >= 25) {
                        client.field318.method2735(98);
                        class122 var91 = client.field318;
                        var27 = client.field487?2:1;
                        var91.method2503(var27);
                        client.field318.method2486(class5.field102);
                        client.field318.method2486(class39.field901);
                     }

                     class144.field2183 = true;
                     continue;
                  }

                  if(5308 == var24) {
                     class36.field780[var5++] = class4.field75.field144;
                     continue;
                  }

                  if(var24 == 5309) {
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 == 1 || var15 == 2) {
                        class4.field75.field144 = var15;
                        class45.method946();
                     }
                     continue;
                  }
               }

               if(var24 < 5600) {
                  if(5504 == var24) {
                     var5 -= 2;
                     var15 = class36.field780[var5];
                     var29 = class36.field780[1 + var5];
                     if(!client.field499) {
                        client.field359 = var15;
                        client.field521 = var29;
                     }
                     continue;
                  }

                  if(var24 == 5505) {
                     class36.field780[var5++] = client.field359;
                     continue;
                  }

                  if(5506 == var24) {
                     class36.field780[var5++] = client.field521;
                     continue;
                  }

                  if(var24 == 5530) {
                     --var5;
                     var15 = class36.field780[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     client.field365 = var15;
                     continue;
                  }

                  if(5531 == var24) {
                     class36.field780[var5++] = client.field365;
                     continue;
                  }
               }

               if(var24 < 5700 && var24 == 5630) {
                  client.field305 = 250;
               } else {
                  if(var24 < 6300) {
                     if(var24 == 6200) {
                        var5 -= 2;
                        client.field527 = (short)class36.field780[var5];
                        if(client.field527 <= 0) {
                           client.field527 = 256;
                        }

                        client.field528 = (short)class36.field780[var5 + 1];
                        if(client.field528 <= 0) {
                           client.field528 = 205;
                        }
                        continue;
                     }

                     if(var24 == 6201) {
                        var5 -= 2;
                        client.field426 = (short)class36.field780[var5];
                        if(client.field426 <= 0) {
                           client.field426 = 256;
                        }

                        client.field530 = (short)class36.field780[var5 + 1];
                        if(client.field530 <= 0) {
                           client.field530 = 320;
                        }
                        continue;
                     }

                     if(6202 == var24) {
                        var5 -= 4;
                        client.field324 = (short)class36.field780[var5];
                        if(client.field324 <= 0) {
                           client.field324 = 1;
                        }

                        client.field401 = (short)class36.field780[1 + var5];
                        if(client.field401 <= 0) {
                           client.field401 = 32767;
                        } else if(client.field401 < client.field324) {
                           client.field401 = client.field324;
                        }

                        client.field533 = (short)class36.field780[var5 + 2];
                        if(client.field533 <= 0) {
                           client.field533 = 1;
                        }

                        client.field504 = (short)class36.field780[3 + var5];
                        if(client.field504 <= 0) {
                           client.field504 = 32767;
                        } else if(client.field504 < client.field533) {
                           client.field504 = client.field533;
                        }
                        continue;
                     }

                     if(6203 == var24) {
                        if(client.field298 != null) {
                           class21.method567(0, 0, client.field298.field2840, client.field298.field2746, false);
                           class36.field780[var5++] = client.field505;
                           class36.field780[var5++] = client.field538;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = -1;
                        }
                        continue;
                     }

                     if(var24 == 6204) {
                        class36.field780[var5++] = client.field426;
                        class36.field780[var5++] = client.field530;
                        continue;
                     }

                     if(var24 == 6205) {
                        class36.field780[var5++] = client.field527;
                        class36.field780[var5++] = client.field528;
                        continue;
                     }
                  }

                  if(var24 < 6600) {
                     if(6500 == var24) {
                        class36.field780[var5++] = class76.method1671()?1:0;
                        continue;
                     }

                     class25 var96;
                     if(var24 == 6501) {
                        class25.field615 = 0;
                        var96 = class47.method980();
                        if(var96 != null) {
                           class36.field780[var5++] = var96.field618;
                           class36.field780[var5++] = var96.field613;
                           class36.field781[var6++] = var96.field620;
                           class36.field780[var5++] = var96.field623;
                           class36.field780[var5++] = var96.field625;
                           class36.field781[var6++] = var96.field627;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = 0;
                           class36.field781[var6++] = "";
                           class36.field780[var5++] = 0;
                           class36.field780[var5++] = 0;
                           class36.field781[var6++] = "";
                        }
                        continue;
                     }

                     if(var24 == 6502) {
                        var96 = class47.method980();
                        if(var96 != null) {
                           class36.field780[var5++] = var96.field618;
                           class36.field780[var5++] = var96.field613;
                           class36.field781[var6++] = var96.field620;
                           class36.field780[var5++] = var96.field623;
                           class36.field780[var5++] = var96.field625;
                           class36.field781[var6++] = var96.field627;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = 0;
                           class36.field781[var6++] = "";
                           class36.field780[var5++] = 0;
                           class36.field780[var5++] = 0;
                           class36.field781[var6++] = "";
                        }
                        continue;
                     }

                     class25 var89;
                     if(var24 == 6506) {
                        --var5;
                        var15 = class36.field780[var5];
                        var89 = null;

                        for(var27 = 0; var27 < class25.field614; ++var27) {
                           if(class25.field616[var27].field618 == var15) {
                              var89 = class25.field616[var27];
                              break;
                           }
                        }

                        if(var89 != null) {
                           class36.field780[var5++] = var89.field618;
                           class36.field780[var5++] = var89.field613;
                           class36.field781[var6++] = var89.field620;
                           class36.field780[var5++] = var89.field623;
                           class36.field780[var5++] = var89.field625;
                           class36.field781[var6++] = var89.field627;
                        } else {
                           class36.field780[var5++] = -1;
                           class36.field780[var5++] = 0;
                           class36.field781[var6++] = "";
                           class36.field780[var5++] = 0;
                           class36.field780[var5++] = 0;
                           class36.field781[var6++] = "";
                        }
                        continue;
                     }

                     if(6507 == var24) {
                        var5 -= 4;
                        var15 = class36.field780[var5];
                        var51 = 1 == class36.field780[1 + var5];
                        var27 = class36.field780[var5 + 2];
                        var59 = 1 == class36.field780[var5 + 3];
                        if(null != class25.field616) {
                           class20.method561(0, class25.field616.length - 1, var15, var51, var27, var59);
                        }
                        continue;
                     }

                     if(var24 == 6511) {
                        --var5;
                        var15 = class36.field780[var5];
                        if(var15 >= 0 && var15 < class25.field614) {
                           var89 = class25.field616[var15];
                           class36.field780[var5++] = var89.field618;
                           class36.field780[var5++] = var89.field613;
                           class36.field781[var6++] = var89.field620;
                           class36.field780[var5++] = var89.field623;
                           class36.field780[var5++] = var89.field625;
                           class36.field781[var6++] = var89.field627;
                           continue;
                        }

                        class36.field780[var5++] = -1;
                        class36.field780[var5++] = 0;
                        class36.field781[var6++] = "";
                        class36.field780[var5++] = 0;
                        class36.field780[var5++] = 0;
                        class36.field781[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var23) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3122).append(" ");

            for(var13 = class36.field786 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field783[var13].field205.field3122).append(" ");
            }

            var12.append("").append(var10);
            class6.method102(var12.toString(), var23);
         }
      }
   }
}

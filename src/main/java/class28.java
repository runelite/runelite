import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 410872193
   )
   @Export("quantity")
   int field664;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -758528635
   )
   @Export("id")
   int field666;
   @ObfuscatedName("l")
   public static class119 field667;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "1289840047"
   )
   static void method652(class0 var0, int var1) {
      Object[] var2 = var0.field11;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class19.method222(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field578;
         int[] var9 = var4.field579;
         byte var10 = -1;
         class36.field777 = 0;

         int var13;
         try {
            class36.field771 = new int[var4.field581];
            int var11 = 0;
            class36.field772 = new String[var4.field580];
            int var34 = 0;

            int var14;
            String var43;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(-2147483645 == var14) {
                     var14 = null != var0.field2?var0.field2.field2794:-1;
                  }

                  if(-2147483644 == var14) {
                     var14 = var0.field5;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field2 != null?var0.field2.field2816:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field6?var0.field6.field2794:-1;
                  }

                  if(-2147483641 == var14) {
                     var14 = var0.field6 != null?var0.field6.field2816:-1;
                  }

                  if(-2147483640 == var14) {
                     var14 = var0.field7;
                  }

                  if(-2147483639 == var14) {
                     var14 = var0.field16;
                  }

                  class36.field771[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var43 = (String)var2[var13];
                  if(var43.equals("event_opbase")) {
                     var43 = var0.field9;
                  }

                  class36.field772[var34++] = var43;
               }
            }

            var13 = 0;
            class36.field782 = var0.field10;

            label3721:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var33 = var8[var7];
               int var15;
               int var19;
               int var21;
               int var38;
               int var41;
               int var47;
               byte[] var59;
               String var79;
               String[] var80;
               int[] var87;
               if(var33 < 100) {
                  if(var33 == 0) {
                     class36.field775[var5++] = var9[var7];
                     continue;
                  }

                  if(1 == var33) {
                     var14 = var9[var7];
                     class36.field775[var5++] = class176.field2903[var14];
                     continue;
                  }

                  if(var33 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2903[var14] = class36.field775[var5];
                     class50.method1012(var14);
                     continue;
                  }

                  if(var33 == 3) {
                     class36.field769[var6++] = var4.field585[var7];
                     continue;
                  }

                  if(6 == var33) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var33 == 7) {
                     var5 -= 2;
                     if(class36.field775[var5 + 1] != class36.field775[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var33) {
                     var5 -= 2;
                     if(class36.field775[var5] == class36.field775[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(9 == var33) {
                     var5 -= 2;
                     if(class36.field775[var5] < class36.field775[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 10) {
                     var5 -= 2;
                     if(class36.field775[var5] > class36.field775[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 21) {
                     if(0 == class36.field777) {
                        return;
                     }

                     class14 var70 = class36.field778[--class36.field777];
                     var4 = var70.field207;
                     var8 = var4.field578;
                     var9 = var4.field579;
                     var7 = var70.field208;
                     class36.field771 = var70.field214;
                     class36.field772 = var70.field210;
                     continue;
                  }

                  if(var33 == 25) {
                     var14 = var9[var7];
                     class36.field775[var5++] = class142.method2979(var14);
                     continue;
                  }

                  if(var33 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field775[var5];
                     class47 var89 = (class47)class47.field1049.method3754((long)var14);
                     class47 var97;
                     if(null != var89) {
                        var97 = var89;
                     } else {
                        var59 = class47.field1045.method3280(14, var14);
                        var89 = new class47();
                        if(null != var59) {
                           var89.method976(new class119(var59));
                        }

                        class47.field1049.method3756(var89, (long)var14);
                        var97 = var89;
                     }

                     var41 = var97.field1043;
                     var19 = var97.field1044;
                     var47 = var97.field1046;
                     var21 = class176.field2907[var47 - var19];
                     if(var15 < 0 || var15 > var21) {
                        var15 = 0;
                     }

                     var21 <<= var19;
                     class176.field2903[var41] = class176.field2903[var41] & ~var21 | var15 << var19 & var21;
                     continue;
                  }

                  if(31 == var33) {
                     var5 -= 2;
                     if(class36.field775[var5] <= class36.field775[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 32) {
                     var5 -= 2;
                     if(class36.field775[var5] >= class36.field775[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 33) {
                     class36.field775[var5++] = class36.field771[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var33 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field771[var10001] = class36.field775[var5];
                     continue;
                  }

                  if(var33 == 35) {
                     class36.field769[var6++] = class36.field772[var9[var7]];
                     continue;
                  }

                  if(36 == var33) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field772[var10001] = class36.field769[var6];
                     continue;
                  }

                  if(37 == var33) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var79 = class127.method2815(class36.field769, var6, var14);
                     class36.field769[var6++] = var79;
                     continue;
                  }

                  if(var33 == 38) {
                     --var5;
                     continue;
                  }

                  if(39 == var33) {
                     --var6;
                     continue;
                  }

                  if(40 == var33) {
                     var14 = var9[var7];
                     class22 var100 = class19.method222(var14);
                     var87 = new int[var100.field581];
                     var80 = new String[var100.field580];

                     for(var41 = 0; var41 < var100.field583; ++var41) {
                        var87[var41] = class36.field775[var5 - var100.field583 + var41];
                     }

                     for(var41 = 0; var41 < var100.field584; ++var41) {
                        var80[var41] = class36.field769[var6 - var100.field584 + var41];
                     }

                     var5 -= var100.field583;
                     var6 -= var100.field584;
                     class14 var95 = new class14();
                     var95.field207 = var4;
                     var95.field208 = var7;
                     var95.field214 = class36.field771;
                     var95.field210 = class36.field772;
                     class36.field778[++class36.field777 - 1] = var95;
                     var4 = var100;
                     var8 = var100.field578;
                     var9 = var100.field579;
                     var7 = -1;
                     class36.field771 = var87;
                     class36.field772 = var80;
                     continue;
                  }

                  if(42 == var33) {
                     class36.field775[var5++] = class125.field2027.method202(var9[var7]);
                     continue;
                  }

                  if(43 == var33) {
                     var10001 = var9[var7];
                     --var5;
                     class125.field2027.method194(var10001, class36.field775[var5]);
                     continue;
                  }

                  if(44 == var33) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var38 = class36.field775[var5];
                     if(var38 >= 0 && var38 <= 5000) {
                        class36.field773[var14] = var38;
                        byte var88 = -1;
                        if(var15 == 105) {
                           var88 = 0;
                        }

                        var41 = 0;

                        while(true) {
                           if(var41 >= var38) {
                              continue label3721;
                           }

                           class36.field780[var14][var41] = var88;
                           ++var41;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(45 == var33) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field775[var5];
                     if(var15 >= 0 && var15 < class36.field773[var14]) {
                        class36.field775[var5++] = class36.field780[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var33) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class36.field775[var5];
                     if(var15 >= 0 && var15 < class36.field773[var14]) {
                        class36.field780[var14][var15] = class36.field775[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(47 == var33) {
                     var43 = class125.field2027.method197(var9[var7]);
                     if(var43 == null) {
                        var43 = "null";
                     }

                     class36.field769[var6++] = var43;
                     continue;
                  }

                  if(var33 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class125.field2027.method199(var10001, class36.field769[var6]);
                     continue;
                  }
               }

               boolean var46;
               if(1 == var9[var7]) {
                  var46 = true;
               } else {
                  var46 = false;
               }

               class173 var16;
               class173 var35;
               int var36;
               class173 var40;
               class173 var42;
               boolean var50;
               boolean var57;
               if(var33 < 1000) {
                  if(100 == var33) {
                     var5 -= 3;
                     var15 = class36.field775[var5];
                     var38 = class36.field775[var5 + 1];
                     var36 = class36.field775[var5 + 2];
                     if(var38 == 0) {
                        throw new RuntimeException();
                     }

                     var40 = class148.method3129(var15);
                     if(null == var40.field2879) {
                        var40.field2879 = new class173[var36 + 1];
                     }

                     if(var40.field2879.length <= var36) {
                        class173[] var83 = new class173[1 + var36];

                        for(var47 = 0; var47 < var40.field2879.length; ++var47) {
                           var83[var47] = var40.field2879[var47];
                        }

                        var40.field2879 = var83;
                     }

                     if(var36 > 0 && var40.field2879[var36 - 1] == null) {
                        throw new RuntimeException("" + (var36 - 1));
                     }

                     class173 var84 = new class173();
                     var84.field2757 = var38;
                     var84.field2774 = var84.field2794 = var40.field2794;
                     var84.field2816 = var36;
                     var84.field2809 = true;
                     var40.field2879[var36] = var84;
                     if(var46) {
                        class36.field779 = var84;
                     } else {
                        class1.field27 = var84;
                     }

                     class9.method133(var40);
                     continue;
                  }

                  if(var33 == 101) {
                     var35 = var46?class36.field779:class1.field27;
                     var16 = class148.method3129(var35.field2794);
                     var16.field2879[var35.field2816] = null;
                     class9.method133(var16);
                     continue;
                  }

                  if(var33 == 102) {
                     --var5;
                     var35 = class148.method3129(class36.field775[var5]);
                     var35.field2879 = null;
                     class9.method133(var35);
                     continue;
                  }

                  if(var33 == 200) {
                     var5 -= 2;
                     var15 = class36.field775[var5];
                     var38 = class36.field775[var5 + 1];
                     var42 = class40.method837(var15, var38);
                     if(var42 != null && var38 != -1) {
                        class36.field775[var5++] = 1;
                        if(var46) {
                           class36.field779 = var42;
                        } else {
                           class1.field27 = var42;
                        }
                        continue;
                     }

                     class36.field775[var5++] = 0;
                     continue;
                  }

                  if(201 == var33) {
                     --var5;
                     var35 = class148.method3129(class36.field775[var5]);
                     if(null != var35) {
                        class36.field775[var5++] = 1;
                        if(var46) {
                           class36.field779 = var35;
                        } else {
                           class1.field27 = var35;
                        }
                     } else {
                        class36.field775[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var33 < 1000 || var33 >= 1100) && (var33 < 2000 || var33 >= 2100)) {
                     String var37;
                     if((var33 < 1100 || var33 >= 1200) && (var33 < 2100 || var33 >= 2200)) {
                        if((var33 < 1200 || var33 >= 1300) && (var33 < 2200 || var33 >= 2300)) {
                           if((var33 < 1300 || var33 >= 1400) && (var33 < 2300 || var33 >= 2400)) {
                              int[] var44;
                              String var48;
                              if(var33 >= 1400 && var33 < 1500 || var33 >= 2400 && var33 < 2500) {
                                 if(var33 >= 2000) {
                                    var33 -= 1000;
                                    --var5;
                                    var35 = class148.method3129(class36.field775[var5]);
                                 } else {
                                    var35 = var46?class36.field779:class1.field27;
                                 }

                                 --var6;
                                 var48 = class36.field769[var6];
                                 var44 = null;
                                 if(var48.length() > 0 && var48.charAt(var48.length() - 1) == 89) {
                                    --var5;
                                    var41 = class36.field775[var5];
                                    if(var41 > 0) {
                                       for(var44 = new int[var41]; var41-- > 0; var44[var41] = class36.field775[var5]) {
                                          --var5;
                                       }
                                    }

                                    var48 = var48.substring(0, var48.length() - 1);
                                 }

                                 Object[] var85 = new Object[var48.length() + 1];

                                 for(var19 = var85.length - 1; var19 >= 1; --var19) {
                                    if(var48.charAt(var19 - 1) == 115) {
                                       --var6;
                                       var85[var19] = class36.field769[var6];
                                    } else {
                                       --var5;
                                       var85[var19] = new Integer(class36.field775[var5]);
                                    }
                                 }

                                 --var5;
                                 var19 = class36.field775[var5];
                                 if(-1 != var19) {
                                    var85[0] = new Integer(var19);
                                 } else {
                                    var85 = null;
                                 }

                                 if(1400 == var33) {
                                    var35.field2750 = var85;
                                 }

                                 if(1401 == var33) {
                                    var35.field2840 = var85;
                                 }

                                 if(var33 == 1402) {
                                    var35.field2790 = var85;
                                 }

                                 if(1403 == var33) {
                                    var35.field2832 = var85;
                                 }

                                 if(var33 == 1404) {
                                    var35.field2843 = var85;
                                 }

                                 if(1405 == var33) {
                                    var35.field2844 = var85;
                                 }

                                 if(1406 == var33) {
                                    var35.field2847 = var85;
                                 }

                                 if(1407 == var33) {
                                    var35.field2848 = var85;
                                    var35.field2849 = var44;
                                 }

                                 if(1408 == var33) {
                                    var35.field2875 = var85;
                                 }

                                 if(1409 == var33) {
                                    var35.field2855 = var85;
                                 }

                                 if(1410 == var33) {
                                    var35.field2871 = var85;
                                 }

                                 if(1411 == var33) {
                                    var35.field2838 = var85;
                                 }

                                 if(var33 == 1412) {
                                    var35.field2842 = var85;
                                 }

                                 if(1414 == var33) {
                                    var35.field2850 = var85;
                                    var35.field2851 = var44;
                                 }

                                 if(var33 == 1415) {
                                    var35.field2852 = var85;
                                    var35.field2777 = var44;
                                 }

                                 if(var33 == 1416) {
                                    var35.field2846 = var85;
                                 }

                                 if(var33 == 1417) {
                                    var35.field2821 = var85;
                                 }

                                 if(1418 == var33) {
                                    var35.field2857 = var85;
                                 }

                                 if(var33 == 1419) {
                                    var35.field2869 = var85;
                                 }

                                 if(var33 == 1420) {
                                    var35.field2859 = var85;
                                 }

                                 if(1421 == var33) {
                                    var35.field2781 = var85;
                                 }

                                 if(1422 == var33) {
                                    var35.field2771 = var85;
                                 }

                                 if(1423 == var33) {
                                    var35.field2862 = var85;
                                 }

                                 if(1424 == var33) {
                                    var35.field2744 = var85;
                                 }

                                 if(1425 == var33) {
                                    var35.field2865 = var85;
                                 }

                                 if(1426 == var33) {
                                    var35.field2753 = var85;
                                 }

                                 if(1427 == var33) {
                                    var35.field2864 = var85;
                                 }

                                 var35.field2835 = true;
                                 continue;
                              }

                              if(var33 < 1600) {
                                 var35 = var46?class36.field779:class1.field27;
                                 if(var33 == 1500) {
                                    class36.field775[var5++] = var35.field2880;
                                    continue;
                                 }

                                 if(var33 == 1501) {
                                    class36.field775[var5++] = var35.field2769;
                                    continue;
                                 }

                                 if(1502 == var33) {
                                    class36.field775[var5++] = var35.field2770;
                                    continue;
                                 }

                                 if(var33 == 1503) {
                                    class36.field775[var5++] = var35.field2834;
                                    continue;
                                 }

                                 if(var33 == 1504) {
                                    class36.field775[var5++] = var35.field2775?1:0;
                                    continue;
                                 }

                                 if(var33 == 1505) {
                                    class36.field775[var5++] = var35.field2774;
                                    continue;
                                 }
                              } else if(var33 < 1700) {
                                 var35 = var46?class36.field779:class1.field27;
                                 if(1600 == var33) {
                                    class36.field775[var5++] = var35.field2776;
                                    continue;
                                 }

                                 if(1601 == var33) {
                                    class36.field775[var5++] = var35.field2815;
                                    continue;
                                 }

                                 if(1602 == var33) {
                                    class36.field769[var6++] = var35.field2853;
                                    continue;
                                 }

                                 if(var33 == 1603) {
                                    class36.field775[var5++] = var35.field2778;
                                    continue;
                                 }

                                 if(1604 == var33) {
                                    class36.field775[var5++] = var35.field2779;
                                    continue;
                                 }

                                 if(1605 == var33) {
                                    class36.field775[var5++] = var35.field2802;
                                    continue;
                                 }

                                 if(var33 == 1606) {
                                    class36.field775[var5++] = var35.field2765;
                                    continue;
                                 }

                                 if(var33 == 1607) {
                                    class36.field775[var5++] = var35.field2800;
                                    continue;
                                 }

                                 if(var33 == 1608) {
                                    class36.field775[var5++] = var35.field2807;
                                    continue;
                                 }

                                 if(var33 == 1609) {
                                    class36.field775[var5++] = var35.field2786;
                                    continue;
                                 }

                                 if(var33 == 1610) {
                                    class36.field775[var5++] = var35.field2787;
                                    continue;
                                 }

                                 if(1611 == var33) {
                                    class36.field775[var5++] = var35.field2780;
                                    continue;
                                 }

                                 if(var33 == 1612) {
                                    class36.field775[var5++] = var35.field2831;
                                    continue;
                                 }

                                 if(1613 == var33) {
                                    class36.field775[var5++] = var35.field2785.vmethod3172();
                                    continue;
                                 }
                              } else if(var33 < 1800) {
                                 var35 = var46?class36.field779:class1.field27;
                                 if(var33 == 1700) {
                                    class36.field775[var5++] = var35.field2822;
                                    continue;
                                 }

                                 if(var33 == 1701) {
                                    if(-1 != var35.field2822) {
                                       class36.field775[var5++] = var35.field2866;
                                    } else {
                                       class36.field775[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var33 == 1702) {
                                    class36.field775[var5++] = var35.field2816;
                                    continue;
                                 }
                              } else if(var33 < 1900) {
                                 var35 = var46?class36.field779:class1.field27;
                                 if(1800 == var33) {
                                    class36.field775[var5++] = class170.method3363(class75.method1642(var35));
                                    continue;
                                 }

                                 if(var33 == 1801) {
                                    --var5;
                                    var38 = class36.field775[var5];
                                    --var38;
                                    if(null != var35.field2829 && var38 < var35.field2829.length && null != var35.field2829[var38]) {
                                       class36.field769[var6++] = var35.field2829[var38];
                                       continue;
                                    }

                                    class36.field769[var6++] = "";
                                    continue;
                                 }

                                 if(var33 == 1802) {
                                    if(null == var35.field2828) {
                                       class36.field769[var6++] = "";
                                    } else {
                                       class36.field769[var6++] = var35.field2828;
                                    }
                                    continue;
                                 }
                              } else if(var33 >= 1900 && var33 < 2000 || var33 >= 2900 && var33 < 3000) {
                                 if(var33 >= 2000) {
                                    var33 -= 1000;
                                    --var5;
                                    var35 = class148.method3129(class36.field775[var5]);
                                 } else {
                                    var35 = var46?class36.field779:class1.field27;
                                 }

                                 if(1927 == var33) {
                                    if(class36.field782 >= 10) {
                                       throw new RuntimeException();
                                    }

                                    if(var35.field2864 == null) {
                                       return;
                                    }

                                    class0 var93 = new class0();
                                    var93.field2 = var35;
                                    var93.field11 = var35.field2864;
                                    var93.field10 = class36.field782 + 1;
                                    client.field466.method3834(var0);
                                    continue;
                                 }
                              } else if(var33 < 2600) {
                                 --var5;
                                 var35 = class148.method3129(class36.field775[var5]);
                                 if(var33 == 2500) {
                                    class36.field775[var5++] = var35.field2880;
                                    continue;
                                 }

                                 if(2501 == var33) {
                                    class36.field775[var5++] = var35.field2769;
                                    continue;
                                 }

                                 if(var33 == 2502) {
                                    class36.field775[var5++] = var35.field2770;
                                    continue;
                                 }

                                 if(var33 == 2503) {
                                    class36.field775[var5++] = var35.field2834;
                                    continue;
                                 }

                                 if(var33 == 2504) {
                                    class36.field775[var5++] = var35.field2775?1:0;
                                    continue;
                                 }

                                 if(2505 == var33) {
                                    class36.field775[var5++] = var35.field2774;
                                    continue;
                                 }
                              } else if(var33 < 2700) {
                                 --var5;
                                 var35 = class148.method3129(class36.field775[var5]);
                                 if(2600 == var33) {
                                    class36.field775[var5++] = var35.field2776;
                                    continue;
                                 }

                                 if(2601 == var33) {
                                    class36.field775[var5++] = var35.field2815;
                                    continue;
                                 }

                                 if(var33 == 2602) {
                                    class36.field769[var6++] = var35.field2853;
                                    continue;
                                 }

                                 if(2603 == var33) {
                                    class36.field775[var5++] = var35.field2778;
                                    continue;
                                 }

                                 if(2604 == var33) {
                                    class36.field775[var5++] = var35.field2779;
                                    continue;
                                 }

                                 if(2605 == var33) {
                                    class36.field775[var5++] = var35.field2802;
                                    continue;
                                 }

                                 if(2606 == var33) {
                                    class36.field775[var5++] = var35.field2765;
                                    continue;
                                 }

                                 if(2607 == var33) {
                                    class36.field775[var5++] = var35.field2800;
                                    continue;
                                 }

                                 if(var33 == 2608) {
                                    class36.field775[var5++] = var35.field2807;
                                    continue;
                                 }

                                 if(2609 == var33) {
                                    class36.field775[var5++] = var35.field2786;
                                    continue;
                                 }

                                 if(var33 == 2610) {
                                    class36.field775[var5++] = var35.field2787;
                                    continue;
                                 }

                                 if(2611 == var33) {
                                    class36.field775[var5++] = var35.field2780;
                                    continue;
                                 }

                                 if(2612 == var33) {
                                    class36.field775[var5++] = var35.field2831;
                                    continue;
                                 }

                                 if(2613 == var33) {
                                    class36.field775[var5++] = var35.field2785.vmethod3172();
                                    continue;
                                 }
                              } else if(var33 < 2800) {
                                 if(var33 == 2700) {
                                    --var5;
                                    var35 = class148.method3129(class36.field775[var5]);
                                    class36.field775[var5++] = var35.field2822;
                                    continue;
                                 }

                                 if(2701 == var33) {
                                    --var5;
                                    var35 = class148.method3129(class36.field775[var5]);
                                    if(var35.field2822 != -1) {
                                       class36.field775[var5++] = var35.field2866;
                                    } else {
                                       class36.field775[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(2702 == var33) {
                                    --var5;
                                    var15 = class36.field775[var5];
                                    class3 var45 = (class3)client.field439.method3788((long)var15);
                                    if(null != var45) {
                                       class36.field775[var5++] = 1;
                                    } else {
                                       class36.field775[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var33 == 2706) {
                                    class36.field775[var5++] = client.field438;
                                    continue;
                                 }
                              } else if(var33 < 2900) {
                                 --var5;
                                 var35 = class148.method3129(class36.field775[var5]);
                                 if(2800 == var33) {
                                    class36.field775[var5++] = class170.method3363(class75.method1642(var35));
                                    continue;
                                 }

                                 if(var33 == 2801) {
                                    --var5;
                                    var38 = class36.field775[var5];
                                    --var38;
                                    if(var35.field2829 != null && var38 < var35.field2829.length && null != var35.field2829[var38]) {
                                       class36.field769[var6++] = var35.field2829[var38];
                                       continue;
                                    }

                                    class36.field769[var6++] = "";
                                    continue;
                                 }

                                 if(2802 == var33) {
                                    if(null == var35.field2828) {
                                       class36.field769[var6++] = "";
                                    } else {
                                       class36.field769[var6++] = var35.field2828;
                                    }
                                    continue;
                                 }
                              } else if(var33 < 3200) {
                                 if(var33 == 3100) {
                                    --var6;
                                    var79 = class36.field769[var6];
                                    class87.method2092(0, "", var79);
                                    continue;
                                 }

                                 if(3101 == var33) {
                                    var5 -= 2;
                                    class90.method2100(class20.field572, class36.field775[var5], class36.field775[1 + var5]);
                                    continue;
                                 }

                                 if(var33 == 3103) {
                                    class106.method2400();
                                    continue;
                                 }

                                 if(var33 == 3104) {
                                    --var6;
                                    var79 = class36.field769[var6];
                                    var38 = 0;
                                    if(class116.method2473(var79)) {
                                       var38 = class140.method2929(var79);
                                    }

                                    client.field321.method2762(190);
                                    client.field321.method2617(var38);
                                    continue;
                                 }

                                 if(var33 == 3105) {
                                    --var6;
                                    var79 = class36.field769[var6];
                                    client.field321.method2762(5);
                                    client.field321.method2565(var79.length() + 1);
                                    client.field321.method2514(var79);
                                    continue;
                                 }

                                 if(3106 == var33) {
                                    --var6;
                                    var79 = class36.field769[var6];
                                    client.field321.method2762(172);
                                    client.field321.method2565(var79.length() + 1);
                                    client.field321.method2514(var79);
                                    continue;
                                 }

                                 if(var33 == 3107) {
                                    --var5;
                                    var15 = class36.field775[var5];
                                    --var6;
                                    var48 = class36.field769[var6];
                                    class191.method3747(var15, var48);
                                    continue;
                                 }

                                 if(3108 == var33) {
                                    var5 -= 3;
                                    var15 = class36.field775[var5];
                                    var38 = class36.field775[var5 + 1];
                                    var36 = class36.field775[2 + var5];
                                    var40 = class148.method3129(var36);
                                    class157.method3168(var40, var15, var38);
                                    continue;
                                 }

                                 if(var33 == 3109) {
                                    var5 -= 2;
                                    var15 = class36.field775[var5];
                                    var38 = class36.field775[1 + var5];
                                    var42 = var46?class36.field779:class1.field27;
                                    class157.method3168(var42, var15, var38);
                                    continue;
                                 }

                                 if(3110 == var33) {
                                    --var5;
                                    class3.field66 = class36.field775[var5] == 1;
                                    continue;
                                 }

                                 if(3111 == var33) {
                                    class36.field775[var5++] = class39.field865.field146?1:0;
                                    continue;
                                 }

                                 if(var33 == 3112) {
                                    --var5;
                                    class39.field865.field146 = class36.field775[var5] == 1;
                                    class43.method915();
                                    continue;
                                 }

                                 if(3113 == var33) {
                                    --var6;
                                    var79 = class36.field769[var6];
                                    --var5;
                                    var50 = class36.field775[var5] == 1;
                                    class144.method3102(var79, var50, false);
                                    continue;
                                 }

                                 if(3115 == var33) {
                                    --var5;
                                    var15 = class36.field775[var5];
                                    client.field321.method2762(80);
                                    client.field321.method2713(var15);
                                    continue;
                                 }

                                 if(var33 == 3116) {
                                    --var5;
                                    var15 = class36.field775[var5];
                                    var6 -= 2;
                                    var48 = class36.field769[var6];
                                    var37 = class36.field769[1 + var6];
                                    if(var48.length() <= 500 && var37.length() <= 500) {
                                       client.field321.method2762(136);
                                       client.field321.method2713(1 + class47.method982(var48) + class47.method982(var37));
                                       client.field321.method2546(var15);
                                       client.field321.method2514(var37);
                                       client.field321.method2514(var48);
                                    }
                                    continue;
                                 }
                              } else if(var33 < 3300) {
                                 if(3200 == var33) {
                                    var5 -= 3;
                                    class18.method191(class36.field775[var5], class36.field775[var5 + 1], class36.field775[var5 + 2]);
                                    continue;
                                 }

                                 if(var33 == 3201) {
                                    --var5;
                                    var15 = class36.field775[var5];
                                    if(var15 == -1 && !client.field427) {
                                       class39.method785();
                                    } else if(-1 != var15 && client.field516 != var15 && 0 != client.field515 && !client.field427) {
                                       class168 var56 = class24.field611;
                                       var36 = client.field515;
                                       class183.field2958 = 1;
                                       class14.field209 = var56;
                                       class148.field2219 = var15;
                                       class164.field2656 = 0;
                                       class96.field1611 = var36;
                                       class125.field2030 = false;
                                       class209.field3118 = 2;
                                    }

                                    client.field516 = var15;
                                    continue;
                                 }

                                 if(3202 == var33) {
                                    var5 -= 2;
                                    class190.method3746(class36.field775[var5]);
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 if(var33 < 3400) {
                                    if(var33 == 3300) {
                                       class36.field775[var5++] = client.field289;
                                       continue;
                                    }

                                    class15 var20;
                                    if(var33 == 3301) {
                                       var5 -= 2;
                                       var15 = class36.field775[var5];
                                       var38 = class36.field775[1 + var5];
                                       var44 = class36.field775;
                                       var41 = var5++;
                                       var20 = (class15)class15.field216.method3788((long)var15);
                                       if(var20 == null) {
                                          var19 = -1;
                                       } else if(var38 >= 0 && var38 < var20.field219.length) {
                                          var19 = var20.field219[var38];
                                       } else {
                                          var19 = -1;
                                       }

                                       var44[var41] = var19;
                                       continue;
                                    }

                                    if(var33 == 3302) {
                                       var5 -= 2;
                                       var15 = class36.field775[var5];
                                       var38 = class36.field775[var5 + 1];
                                       var44 = class36.field775;
                                       var41 = var5++;
                                       var20 = (class15)class15.field216.method3788((long)var15);
                                       if(null == var20) {
                                          var19 = 0;
                                       } else if(var38 >= 0 && var38 < var20.field217.length) {
                                          var19 = var20.field217[var38];
                                       } else {
                                          var19 = 0;
                                       }

                                       var44[var41] = var19;
                                       continue;
                                    }

                                    if(3303 == var33) {
                                       var5 -= 2;
                                       var15 = class36.field775[var5];
                                       var38 = class36.field775[1 + var5];
                                       var44 = class36.field775;
                                       var41 = var5++;
                                       var20 = (class15)class15.field216.method3788((long)var15);
                                       if(null == var20) {
                                          var19 = 0;
                                       } else if(var38 == -1) {
                                          var19 = 0;
                                       } else {
                                          var21 = 0;

                                          for(var22 = 0; var22 < var20.field217.length; ++var22) {
                                             if(var20.field219[var22] == var38) {
                                                var21 += var20.field217[var22];
                                             }
                                          }

                                          var19 = var21;
                                       }

                                       var44[var41] = var19;
                                       continue;
                                    }

                                    if(var33 == 3304) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = class157.method3169(var15).field1076;
                                       continue;
                                    }

                                    if(var33 == 3305) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = client.field492[var15];
                                       continue;
                                    }

                                    if(3306 == var33) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = client.field415[var15];
                                       continue;
                                    }

                                    if(var33 == 3307) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = client.field552[var15];
                                       continue;
                                    }

                                    if(3308 == var33) {
                                       var15 = class48.field1063;
                                       var38 = (class20.field572.field804 >> 7) + class85.field1439;
                                       var36 = class6.field128 + (class20.field572.field814 >> 7);
                                       class36.field775[var5++] = (var38 << 14) + (var15 << 28) + var36;
                                       continue;
                                    }

                                    if(3309 == var33) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = var15 >> 14 & 16383;
                                       continue;
                                    }

                                    if(3310 == var33) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = var15 >> 28;
                                       continue;
                                    }

                                    if(var33 == 3311) {
                                       --var5;
                                       var15 = class36.field775[var5];
                                       class36.field775[var5++] = var15 & 16383;
                                       continue;
                                    }

                                    if(var33 == 3312) {
                                       class36.field775[var5++] = client.field284?1:0;
                                       continue;
                                    }

                                    if(3313 == var33) {
                                       var5 -= 2;
                                       var15 = '耀' + class36.field775[var5];
                                       var38 = class36.field775[1 + var5];
                                       var44 = class36.field775;
                                       var41 = var5++;
                                       var20 = (class15)class15.field216.method3788((long)var15);
                                       if(null == var20) {
                                          var19 = -1;
                                       } else if(var38 >= 0 && var38 < var20.field219.length) {
                                          var19 = var20.field219[var38];
                                       } else {
                                          var19 = -1;
                                       }

                                       var44[var41] = var19;
                                       continue;
                                    }

                                    if(3314 == var33) {
                                       var5 -= 2;
                                       var15 = class36.field775[var5] + '耀';
                                       var38 = class36.field775[1 + var5];
                                       var44 = class36.field775;
                                       var41 = var5++;
                                       var20 = (class15)class15.field216.method3788((long)var15);
                                       if(null == var20) {
                                          var19 = 0;
                                       } else if(var38 >= 0 && var38 < var20.field217.length) {
                                          var19 = var20.field217[var38];
                                       } else {
                                          var19 = 0;
                                       }

                                       var44[var41] = var19;
                                       continue;
                                    }

                                    if(var33 == 3315) {
                                       var5 -= 2;
                                       var15 = '耀' + class36.field775[var5];
                                       var38 = class36.field775[var5 + 1];
                                       var44 = class36.field775;
                                       var41 = var5++;
                                       var20 = (class15)class15.field216.method3788((long)var15);
                                       if(var20 == null) {
                                          var19 = 0;
                                       } else if(-1 == var38) {
                                          var19 = 0;
                                       } else {
                                          var21 = 0;

                                          for(var22 = 0; var22 < var20.field217.length; ++var22) {
                                             if(var20.field219[var22] == var38) {
                                                var21 += var20.field217[var22];
                                             }
                                          }

                                          var19 = var21;
                                       }

                                       var44[var41] = var19;
                                       continue;
                                    }

                                    if(3316 == var33) {
                                       if(client.field482 >= 2) {
                                          class36.field775[var5++] = client.field482;
                                       } else {
                                          class36.field775[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(3317 == var33) {
                                       class36.field775[var5++] = client.field430;
                                       continue;
                                    }

                                    if(var33 == 3318) {
                                       class36.field775[var5++] = client.field279;
                                       continue;
                                    }

                                    if(var33 == 3321) {
                                       class36.field775[var5++] = client.field443;
                                       continue;
                                    }

                                    if(3322 == var33) {
                                       class36.field775[var5++] = client.field365;
                                       continue;
                                    }

                                    if(var33 == 3323) {
                                       if(client.field447) {
                                          class36.field775[var5++] = 1;
                                       } else {
                                          class36.field775[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var33 == 3324) {
                                       class36.field775[var5++] = client.field280;
                                       continue;
                                    }
                                 } else if(var33 < 3500) {
                                    if(3400 == var33) {
                                       var5 -= 2;
                                       var15 = class36.field775[var5];
                                       var38 = class36.field775[1 + var5];
                                       class48 var54 = class149.method3131(var15);
                                       if(115 != var54.field1052) {
                                          ;
                                       }

                                       for(var41 = 0; var41 < var54.field1057; ++var41) {
                                          if(var54.field1058[var41] == var38) {
                                             class36.field769[var6++] = var54.field1060[var41];
                                             var54 = null;
                                             break;
                                          }
                                       }

                                       if(var54 != null) {
                                          class36.field769[var6++] = var54.field1055;
                                       }
                                       continue;
                                    }

                                    if(var33 == 3408) {
                                       var5 -= 4;
                                       var15 = class36.field775[var5];
                                       var38 = class36.field775[1 + var5];
                                       var36 = class36.field775[var5 + 2];
                                       var41 = class36.field775[3 + var5];
                                       class48 var62 = class149.method3131(var36);
                                       if(var62.field1059 == var15 && var62.field1052 == var38) {
                                          for(var47 = 0; var47 < var62.field1057; ++var47) {
                                             if(var62.field1058[var47] == var41) {
                                                if(115 == var38) {
                                                   class36.field769[var6++] = var62.field1060[var47];
                                                } else {
                                                   class36.field775[var5++] = var62.field1056[var47];
                                                }

                                                var62 = null;
                                                break;
                                             }
                                          }

                                          if(var62 != null) {
                                             if(var38 == 115) {
                                                class36.field769[var6++] = var62.field1055;
                                             } else {
                                                class36.field775[var5++] = var62.field1054;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var38 == 115) {
                                          class36.field769[var6++] = "null";
                                       } else {
                                          class36.field775[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    String var53;
                                    String var64;
                                    if(var33 < 3700) {
                                       if(3600 == var33) {
                                          if(client.field382 == 0) {
                                             class36.field775[var5++] = -2;
                                          } else if(client.field382 == 1) {
                                             class36.field775[var5++] = -1;
                                          } else {
                                             class36.field775[var5++] = client.field545;
                                          }
                                          continue;
                                       }

                                       if(var33 == 3601) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(2 == client.field382 && var15 < client.field545) {
                                             class36.field769[var6++] = client.field547[var15].field247;
                                             class36.field769[var6++] = client.field547[var15].field245;
                                             continue;
                                          }

                                          class36.field769[var6++] = "";
                                          class36.field769[var6++] = "";
                                          continue;
                                       }

                                       if(3602 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(client.field382 == 2 && var15 < client.field545) {
                                             class36.field775[var5++] = client.field547[var15].field242;
                                             continue;
                                          }

                                          class36.field775[var5++] = 0;
                                          continue;
                                       }

                                       if(var33 == 3603) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(client.field382 == 2 && var15 < client.field545) {
                                             class36.field775[var5++] = client.field547[var15].field244;
                                             continue;
                                          }

                                          class36.field775[var5++] = 0;
                                          continue;
                                       }

                                       if(var33 == 3604) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          client.method484(var79, var38);
                                          continue;
                                       }

                                       class7 var51;
                                       class17 var52;
                                       if(var33 == 3605) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(null == var79) {
                                             continue;
                                          }

                                          if((client.field545 < 200 || 1 == client.field402) && client.field545 < 400) {
                                             var48 = class122.method2773(var79, client.field283);
                                             if(null == var48) {
                                                continue;
                                             }

                                             for(var36 = 0; var36 < client.field545; ++var36) {
                                                var52 = client.field547[var36];
                                                var64 = class122.method2773(var52.field247, client.field283);
                                                if(var64 != null && var64.equals(var48)) {
                                                   class87.method2092(30, "", var79 + " is already on your friend list");
                                                   continue label3721;
                                                }

                                                if(null != var52.field245) {
                                                   var53 = class122.method2773(var52.field245, client.field283);
                                                   if(var53 != null && var53.equals(var48)) {
                                                      class87.method2092(30, "", var79 + " is already on your friend list");
                                                      continue label3721;
                                                   }
                                                }
                                             }

                                             for(var36 = 0; var36 < client.field549; ++var36) {
                                                var51 = client.field550[var36];
                                                var64 = class122.method2773(var51.field141, client.field283);
                                                if(var64 != null && var64.equals(var48)) {
                                                   class87.method2092(30, "", "Please remove " + var79 + " from your ignore list first");
                                                   continue label3721;
                                                }

                                                if(null != var51.field135) {
                                                   var53 = class122.method2773(var51.field135, client.field283);
                                                   if(null != var53 && var53.equals(var48)) {
                                                      class87.method2092(30, "", "Please remove " + var79 + " from your ignore list first");
                                                      continue label3721;
                                                   }
                                                }
                                             }

                                             if(class122.method2773(class20.field572.field45, client.field283).equals(var48)) {
                                                class87.method2092(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                client.field321.method2762(128);
                                                client.field321.method2565(class47.method982(var79));
                                                client.field321.method2514(var79);
                                             }
                                             continue;
                                          }

                                          class87.method2092(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(3606 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(var79 == null) {
                                             continue;
                                          }

                                          var48 = class122.method2773(var79, client.field283);
                                          if(null == var48) {
                                             continue;
                                          }

                                          var36 = 0;

                                          while(true) {
                                             if(var36 >= client.field545) {
                                                continue label3721;
                                             }

                                             var52 = client.field547[var36];
                                             var64 = var52.field247;
                                             var53 = class122.method2773(var64, client.field283);
                                             if(class154.method3163(var79, var48, var64, var53)) {
                                                --client.field545;

                                                for(var21 = var36; var21 < client.field545; ++var21) {
                                                   client.field547[var21] = client.field547[1 + var21];
                                                }

                                                client.field471 = client.field463;
                                                client.field321.method2762(13);
                                                client.field321.method2565(class47.method982(var79));
                                                client.field321.method2514(var79);
                                                continue label3721;
                                             }

                                             ++var36;
                                          }
                                       }

                                       if(3607 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(var79 == null) {
                                             continue;
                                          }

                                          if((client.field549 < 100 || client.field402 == 1) && client.field549 < 400) {
                                             var48 = class122.method2773(var79, client.field283);
                                             if(null == var48) {
                                                continue;
                                             }

                                             for(var36 = 0; var36 < client.field549; ++var36) {
                                                var51 = client.field550[var36];
                                                var64 = class122.method2773(var51.field141, client.field283);
                                                if(null != var64 && var64.equals(var48)) {
                                                   class87.method2092(31, "", var79 + " is already on your ignore list");
                                                   continue label3721;
                                                }

                                                if(null != var51.field135) {
                                                   var53 = class122.method2773(var51.field135, client.field283);
                                                   if(null != var53 && var53.equals(var48)) {
                                                      class87.method2092(31, "", var79 + " is already on your ignore list");
                                                      continue label3721;
                                                   }
                                                }
                                             }

                                             for(var36 = 0; var36 < client.field545; ++var36) {
                                                var52 = client.field547[var36];
                                                var64 = class122.method2773(var52.field247, client.field283);
                                                if(var64 != null && var64.equals(var48)) {
                                                   class87.method2092(31, "", "Please remove " + var79 + " from your friend list first");
                                                   continue label3721;
                                                }

                                                if(var52.field245 != null) {
                                                   var53 = class122.method2773(var52.field245, client.field283);
                                                   if(null != var53 && var53.equals(var48)) {
                                                      class87.method2092(31, "", "Please remove " + var79 + " from your friend list first");
                                                      continue label3721;
                                                   }
                                                }
                                             }

                                             if(class122.method2773(class20.field572.field45, client.field283).equals(var48)) {
                                                class87.method2092(31, "", "You can\'t add yourself to your own ignore list");
                                             } else {
                                                client.field321.method2762(21);
                                                client.field321.method2565(class47.method982(var79));
                                                client.field321.method2514(var79);
                                             }
                                             continue;
                                          }

                                          class87.method2092(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var33 == 3608) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          class143.method2981(var79);
                                          continue;
                                       }

                                       if(var33 == 3609) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          class152[] var63 = class133.method2849();

                                          for(var36 = 0; var36 < var63.length; ++var36) {
                                             class152 var49 = var63[var36];
                                             if(-1 != var49.field2258 && var79.startsWith(class94.method2184(var49.field2258))) {
                                                var79 = var79.substring(6 + Integer.toString(var49.field2258).length());
                                                break;
                                             }
                                          }

                                          class36.field775[var5++] = class9.method128(var79, false)?1:0;
                                          continue;
                                       }

                                       if(3611 == var33) {
                                          if(null != client.field505) {
                                             class36.field769[var6++] = class26.method634(client.field505);
                                          } else {
                                             class36.field769[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(3612 == var33) {
                                          if(null != client.field505) {
                                             class36.field775[var5++] = class26.field644;
                                          } else {
                                             class36.field775[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(3613 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(null != client.field505 && var15 < class26.field644) {
                                             class36.field769[var6++] = class90.field1542[var15].field609;
                                             continue;
                                          }

                                          class36.field769[var6++] = "";
                                          continue;
                                       }

                                       if(var33 == 3614) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(client.field505 != null && var15 < class26.field644) {
                                             class36.field775[var5++] = class90.field1542[var15].field610;
                                             continue;
                                          }

                                          class36.field775[var5++] = 0;
                                          continue;
                                       }

                                       if(var33 == 3615) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(null != client.field505 && var15 < class26.field644) {
                                             class36.field775[var5++] = class90.field1542[var15].field608;
                                             continue;
                                          }

                                          class36.field775[var5++] = 0;
                                          continue;
                                       }

                                       if(3616 == var33) {
                                          class36.field775[var5++] = class0.field17;
                                          continue;
                                       }

                                       if(var33 == 3617) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(null != class90.field1542) {
                                             client.field321.method2762(210);
                                             client.field321.method2565(class47.method982(var79));
                                             client.field321.method2514(var79);
                                          }
                                          continue;
                                       }

                                       if(3618 == var33) {
                                          class36.field775[var5++] = class44.field1012;
                                          continue;
                                       }

                                       if(3619 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          class8.method123(var79);
                                          continue;
                                       }

                                       if(var33 == 3620) {
                                          class49.method1002();
                                          continue;
                                       }

                                       if(3621 == var33) {
                                          if(client.field382 == 0) {
                                             class36.field775[var5++] = -1;
                                          } else {
                                             class36.field775[var5++] = client.field549;
                                          }
                                          continue;
                                       }

                                       if(3622 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(client.field382 != 0 && var15 < client.field549) {
                                             class36.field769[var6++] = client.field550[var15].field141;
                                             class36.field769[var6++] = client.field550[var15].field135;
                                             continue;
                                          }

                                          class36.field769[var6++] = "";
                                          class36.field769[var6++] = "";
                                          continue;
                                       }

                                       if(3623 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(var79.startsWith(class94.method2184(0)) || var79.startsWith(class94.method2184(1))) {
                                             var79 = var79.substring(7);
                                          }

                                          class36.field775[var5++] = class163.method3234(var79)?1:0;
                                          continue;
                                       }

                                       if(3624 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          if(class90.field1542 != null && var15 < class26.field644 && class90.field1542[var15].field609.equalsIgnoreCase(class20.field572.field45)) {
                                             class36.field775[var5++] = 1;
                                             continue;
                                          }

                                          class36.field775[var5++] = 0;
                                          continue;
                                       }

                                       if(3625 == var33) {
                                          if(null != client.field506) {
                                             class36.field769[var6++] = class26.method634(client.field506);
                                          } else {
                                             class36.field769[var6++] = "";
                                          }
                                          continue;
                                       }
                                    } else if(var33 < 4000) {
                                       if(var33 == 3903) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = client.field554[var15].method3981();
                                          continue;
                                       }

                                       if(3904 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = client.field554[var15].field3169;
                                          continue;
                                       }

                                       if(var33 == 3905) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = client.field554[var15].field3167;
                                          continue;
                                       }

                                       if(3906 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = client.field554[var15].field3170;
                                          continue;
                                       }

                                       if(3907 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = client.field554[var15].field3171;
                                          continue;
                                       }

                                       if(var33 == 3908) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = client.field554[var15].field3168;
                                          continue;
                                       }

                                       if(var33 == 3910) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var38 = client.field554[var15].method3996();
                                          class36.field775[var5++] = var38 == 0?1:0;
                                          continue;
                                       }

                                       if(3911 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var38 = client.field554[var15].method3996();
                                          class36.field775[var5++] = 2 == var38?1:0;
                                          continue;
                                       }

                                       if(3912 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var38 = client.field554[var15].method3996();
                                          class36.field775[var5++] = var38 == 5?1:0;
                                          continue;
                                       }

                                       if(var33 == 3913) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var38 = client.field554[var15].method3996();
                                          class36.field775[var5++] = 1 == var38?1:0;
                                          continue;
                                       }

                                       boolean var96;
                                       if(3914 == var33) {
                                          --var5;
                                          var96 = class36.field775[var5] == 1;
                                          if(class10.field168 != null) {
                                             class10.field168.method3998(class221.field3173, var96);
                                          }
                                          continue;
                                       }

                                       if(3915 == var33) {
                                          --var5;
                                          var96 = class36.field775[var5] == 1;
                                          if(class10.field168 != null) {
                                             class10.field168.method3998(class221.field3175, var96);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3916) {
                                          var5 -= 2;
                                          var96 = class36.field775[var5] == 1;
                                          var50 = class36.field775[1 + var5] == 1;
                                          if(null != class10.field168) {
                                             class10.field168.method3998(new class21(var50), var96);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3917) {
                                          --var5;
                                          var96 = class36.field775[var5] == 1;
                                          if(class10.field168 != null) {
                                             class10.field168.method3998(class221.field3174, var96);
                                          }
                                          continue;
                                       }

                                       if(3918 == var33) {
                                          --var5;
                                          var96 = class36.field775[var5] == 1;
                                          if(null != class10.field168) {
                                             class10.field168.method3998(class221.field3177, var96);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3919) {
                                          class36.field775[var5++] = null == class10.field168?0:class10.field168.field3176.size();
                                          continue;
                                       }

                                       class214 var69;
                                       if(3920 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          class36.field775[var5++] = var69.field3149;
                                          continue;
                                       }

                                       if(3921 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          class36.field769[var6++] = var69.method3939();
                                          continue;
                                       }

                                       if(var33 == 3922) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          class36.field769[var6++] = var69.method3940();
                                          continue;
                                       }

                                       if(3923 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          long var65 = class140.method2967() - class1.field31 - var69.field3147;
                                          var19 = (int)(var65 / 3600000L);
                                          var47 = (int)((var65 - (long)(var19 * 3600000)) / 60000L);
                                          var21 = (int)((var65 - (long)(3600000 * var19) - (long)('\uea60' * var47)) / 1000L);
                                          String var55 = var19 + ":" + var47 / 10 + var47 % 10 + ":" + var21 / 10 + var21 % 10;
                                          class36.field769[var6++] = var55;
                                          continue;
                                       }

                                       if(var33 == 3924) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          class36.field775[var5++] = var69.field3146.field3170;
                                          continue;
                                       }

                                       if(var33 == 3925) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          class36.field775[var5++] = var69.field3146.field3167;
                                          continue;
                                       }

                                       if(3926 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var69 = (class214)class10.field168.field3176.get(var15);
                                          class36.field775[var5++] = var69.field3146.field3169;
                                          continue;
                                       }
                                    } else if(var33 < 4100) {
                                       if(var33 == 4000) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 + var38;
                                          continue;
                                       }

                                       if(4001 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 - var38;
                                          continue;
                                       }

                                       if(var33 == 4002) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          class36.field775[var5++] = var15 * var38;
                                          continue;
                                       }

                                       if(4003 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 / var38;
                                          continue;
                                       }

                                       if(4004 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = (int)(Math.random() * (double)var15);
                                          continue;
                                       }

                                       if(var33 == 4005) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = (int)(Math.random() * (double)(1 + var15));
                                          continue;
                                       }

                                       if(4006 == var33) {
                                          var5 -= 5;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          var36 = class36.field775[var5 + 2];
                                          var41 = class36.field775[var5 + 3];
                                          var19 = class36.field775[4 + var5];
                                          class36.field775[var5++] = (var38 - var15) * (var19 - var36) / (var41 - var36) + var15;
                                          continue;
                                       }

                                       if(var33 == 4007) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 * var38 / 100 + var15;
                                          continue;
                                       }

                                       if(4008 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          class36.field775[var5++] = var15 | 1 << var38;
                                          continue;
                                       }

                                       if(var33 == 4009) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 & -1 - (1 << var38);
                                          continue;
                                       }

                                       if(var33 == 4010) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = (var15 & 1 << var38) != 0?1:0;
                                          continue;
                                       }

                                       if(var33 == 4011) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          class36.field775[var5++] = var15 % var38;
                                          continue;
                                       }

                                       if(var33 == 4012) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          if(0 == var15) {
                                             class36.field775[var5++] = 0;
                                          } else {
                                             class36.field775[var5++] = (int)Math.pow((double)var15, (double)var38);
                                          }
                                          continue;
                                       }

                                       if(var33 == 4013) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          if(var15 == 0) {
                                             class36.field775[var5++] = 0;
                                          } else if(0 == var38) {
                                             class36.field775[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class36.field775[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var38);
                                          }
                                          continue;
                                       }

                                       if(4014 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 & var38;
                                          continue;
                                       }

                                       if(var33 == 4015) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          class36.field775[var5++] = var15 | var38;
                                          continue;
                                       }
                                    } else if(var33 < 4200) {
                                       if(4100 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          class36.field769[var6++] = var79 + var38;
                                          continue;
                                       }

                                       if(4101 == var33) {
                                          var6 -= 2;
                                          var79 = class36.field769[var6];
                                          var48 = class36.field769[var6 + 1];
                                          class36.field769[var6++] = var79 + var48;
                                          continue;
                                       }

                                       if(4102 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          var80 = class36.field769;
                                          var41 = var6++;
                                          if(var38 < 0) {
                                             var53 = Integer.toString(var38);
                                          } else {
                                             var53 = class134.method2854(var38, 10);
                                          }

                                          var80[var41] = var79 + var53;
                                          continue;
                                       }

                                       if(var33 == 4103) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          class36.field769[var6++] = var79.toLowerCase();
                                          continue;
                                       }

                                       if(4104 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          long var90 = 86400000L * (11745L + (long)var15);
                                          class36.field781.setTime(new Date(var90));
                                          var41 = class36.field781.get(5);
                                          var19 = class36.field781.get(2);
                                          var47 = class36.field781.get(1);
                                          class36.field769[var6++] = var41 + "-" + class36.field774[var19] + "-" + var47;
                                          continue;
                                       }

                                       if(4105 == var33) {
                                          var6 -= 2;
                                          var79 = class36.field769[var6];
                                          var48 = class36.field769[var6 + 1];
                                          if(class20.field572.field35 != null && class20.field572.field35.field2921) {
                                             class36.field769[var6++] = var48;
                                             continue;
                                          }

                                          class36.field769[var6++] = var79;
                                          continue;
                                       }

                                       if(var33 == 4106) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field769[var6++] = Integer.toString(var15);
                                          continue;
                                       }

                                       if(4107 == var33) {
                                          var6 -= 2;
                                          int[] var98 = class36.field775;
                                          var38 = var5++;
                                          String var60 = class36.field769[var6];
                                          var64 = class36.field769[1 + var6];
                                          var47 = client.field286;
                                          var21 = var60.length();
                                          var22 = var64.length();
                                          int var23 = 0;
                                          int var24 = 0;
                                          byte var25 = 0;
                                          byte var26 = 0;

                                          label3534:
                                          while(true) {
                                             if(var23 - var25 >= var21 && var24 - var26 >= var22) {
                                                int var66 = Math.min(var21, var22);

                                                int var68;
                                                char var75;
                                                for(var68 = 0; var68 < var66; ++var68) {
                                                   char var73 = var60.charAt(var68);
                                                   var75 = var64.charAt(var68);
                                                   if(var75 != var73 && Character.toUpperCase(var73) != Character.toUpperCase(var75)) {
                                                      var73 = Character.toLowerCase(var73);
                                                      var75 = Character.toLowerCase(var75);
                                                      if(var75 != var73) {
                                                         var36 = class99.method2217(var73) - class99.method2217(var75);
                                                         break label3534;
                                                      }
                                                   }
                                                }

                                                var68 = var21 - var22;
                                                if(0 != var68) {
                                                   var36 = var68;
                                                } else {
                                                   for(int var74 = 0; var74 < var66; ++var74) {
                                                      var75 = var60.charAt(var74);
                                                      char var31 = var64.charAt(var74);
                                                      if(var31 != var75) {
                                                         var36 = class99.method2217(var75) - class99.method2217(var31);
                                                         break label3534;
                                                      }
                                                   }

                                                   var36 = 0;
                                                }
                                                break;
                                             }

                                             if(var23 - var25 >= var21) {
                                                var36 = -1;
                                                break;
                                             }

                                             if(var24 - var26 >= var22) {
                                                var36 = 1;
                                                break;
                                             }

                                             char var27;
                                             if(0 != var25) {
                                                var27 = (char)var25;
                                                boolean var58 = false;
                                             } else {
                                                var27 = var60.charAt(var23++);
                                             }

                                             char var28;
                                             if(var26 != 0) {
                                                var28 = (char)var26;
                                                boolean var61 = false;
                                             } else {
                                                var28 = var64.charAt(var24++);
                                             }

                                             byte var29;
                                             if(198 == var27) {
                                                var29 = 69;
                                             } else if(230 == var27) {
                                                var29 = 101;
                                             } else if(223 == var27) {
                                                var29 = 115;
                                             } else if(var27 == 338) {
                                                var29 = 69;
                                             } else if(339 == var27) {
                                                var29 = 101;
                                             } else {
                                                var29 = 0;
                                             }

                                             var25 = var29;
                                             byte var30;
                                             if(var28 == 198) {
                                                var30 = 69;
                                             } else if(230 == var28) {
                                                var30 = 101;
                                             } else if(var28 == 223) {
                                                var30 = 115;
                                             } else if(338 == var28) {
                                                var30 = 69;
                                             } else if(var28 == 339) {
                                                var30 = 101;
                                             } else {
                                                var30 = 0;
                                             }

                                             var26 = var30;
                                             var27 = class217.method3961(var27);
                                             var28 = class217.method3961(var28);
                                             if(var28 != var27 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                                var27 = Character.toLowerCase(var27);
                                                var28 = Character.toLowerCase(var28);
                                                if(var28 != var27) {
                                                   var36 = class99.method2217(var27) - class99.method2217(var28);
                                                   break;
                                                }
                                             }
                                          }

                                          var98[var38] = class44.method944(var36);
                                          continue;
                                       }

                                       class224 var72;
                                       if(4108 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          var5 -= 2;
                                          var38 = class36.field775[var5];
                                          var36 = class36.field775[var5 + 1];
                                          var59 = class72.field1319.method3280(var36, 0);
                                          var72 = new class224(var59);
                                          class36.field775[var5++] = var72.method4017(var79, var38);
                                          continue;
                                       }

                                       if(4109 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          var5 -= 2;
                                          var38 = class36.field775[var5];
                                          var36 = class36.field775[1 + var5];
                                          var59 = class72.field1319.method3280(var36, 0);
                                          var72 = new class224(var59);
                                          class36.field775[var5++] = var72.method4016(var79, var38);
                                          continue;
                                       }

                                       if(4110 == var33) {
                                          var6 -= 2;
                                          var79 = class36.field769[var6];
                                          var48 = class36.field769[var6 + 1];
                                          --var5;
                                          if(class36.field775[var5] == 1) {
                                             class36.field769[var6++] = var79;
                                          } else {
                                             class36.field769[var6++] = var48;
                                          }
                                          continue;
                                       }

                                       if(var33 == 4111) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          class36.field769[var6++] = class223.method4072(var79);
                                          continue;
                                       }

                                       if(var33 == 4112) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          class36.field769[var6++] = var79 + (char)var38;
                                          continue;
                                       }

                                       if(4113 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = class154.method3165((char)var15)?1:0;
                                          continue;
                                       }

                                       if(var33 == 4114) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = class18.method192((char)var15)?1:0;
                                          continue;
                                       }

                                       char var71;
                                       if(var33 == 4115) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var87 = class36.field775;
                                          var36 = var5++;
                                          var71 = (char)var15;
                                          var57 = var71 >= 65 && var71 <= 90 || var71 >= 97 && var71 <= 122;
                                          var87[var36] = var57?1:0;
                                          continue;
                                       }

                                       if(4116 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var87 = class36.field775;
                                          var36 = var5++;
                                          var71 = (char)var15;
                                          var57 = var71 >= 48 && var71 <= 57;
                                          var87[var36] = var57?1:0;
                                          continue;
                                       }

                                       if(var33 == 4117) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(null != var79) {
                                             class36.field775[var5++] = var79.length();
                                          } else {
                                             class36.field775[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var33 == 4118) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          var5 -= 2;
                                          var38 = class36.field775[var5];
                                          var36 = class36.field775[var5 + 1];
                                          class36.field769[var6++] = var79.substring(var38, var36);
                                          continue;
                                       }

                                       if(var33 == 4119) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          StringBuilder var86 = new StringBuilder(var79.length());
                                          var17 = false;

                                          for(var41 = 0; var41 < var79.length(); ++var41) {
                                             var71 = var79.charAt(var41);
                                             if(var71 == 60) {
                                                var17 = true;
                                             } else if(var71 == 62) {
                                                var17 = false;
                                             } else if(!var17) {
                                                var86.append(var71);
                                             }
                                          }

                                          class36.field769[var6++] = var86.toString();
                                          continue;
                                       }

                                       if(var33 == 4120) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          class36.field775[var5++] = var79.indexOf(var38);
                                          continue;
                                       }

                                       if(4121 == var33) {
                                          var6 -= 2;
                                          var79 = class36.field769[var6];
                                          var48 = class36.field769[1 + var6];
                                          --var5;
                                          var36 = class36.field775[var5];
                                          class36.field775[var5++] = var79.indexOf(var48, var36);
                                          continue;
                                       }
                                    } else if(var33 < 4300) {
                                       if(var33 == 4200) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field769[var6++] = class33.method711(var15).field1091;
                                          continue;
                                       }

                                       class51 var81;
                                       if(4201 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[var5 + 1];
                                          var81 = class33.method711(var15);
                                          if(var38 >= 1 && var38 <= 5 && var81.field1105[var38 - 1] != null) {
                                             class36.field769[var6++] = var81.field1105[var38 - 1];
                                             continue;
                                          }

                                          class36.field769[var6++] = "";
                                          continue;
                                       }

                                       if(4202 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          var81 = class33.method711(var15);
                                          if(var38 >= 1 && var38 <= 5 && var81.field1130[var38 - 1] != null) {
                                             class36.field769[var6++] = var81.field1130[var38 - 1];
                                             continue;
                                          }

                                          class36.field769[var6++] = "";
                                          continue;
                                       }

                                       if(var33 == 4203) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = class33.method711(var15).field1125;
                                          continue;
                                       }

                                       if(var33 == 4204) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = class33.method711(var15).field1102 == 1?1:0;
                                          continue;
                                       }

                                       class51 var91;
                                       if(4205 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var91 = class33.method711(var15);
                                          if(-1 == var91.field1122 && var91.field1121 >= 0) {
                                             class36.field775[var5++] = var91.field1121;
                                             continue;
                                          }

                                          class36.field775[var5++] = var15;
                                          continue;
                                       }

                                       if(var33 == 4206) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var91 = class33.method711(var15);
                                          if(var91.field1122 >= 0 && var91.field1121 >= 0) {
                                             class36.field775[var5++] = var91.field1121;
                                             continue;
                                          }

                                          class36.field775[var5++] = var15;
                                          continue;
                                       }

                                       if(4207 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = class33.method711(var15).field1123?1:0;
                                          continue;
                                       }

                                       if(var33 == 4210) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          class38.method754(var79, var38 == 1);
                                          class36.field775[var5++] = class16.field229;
                                          continue;
                                       }

                                       if(var33 == 4211) {
                                          if(class121.field1994 != null && class38.field853 < class16.field229) {
                                             class36.field775[var5++] = class121.field1994[++class38.field853 - 1] & '\uffff';
                                             continue;
                                          }

                                          class36.field775[var5++] = -1;
                                          continue;
                                       }

                                       if(4212 == var33) {
                                          class38.field853 = 0;
                                          continue;
                                       }
                                    } else if(var33 < 5100) {
                                       if(var33 == 5000) {
                                          class36.field775[var5++] = client.field518;
                                          continue;
                                       }

                                       if(var33 == 5001) {
                                          var5 -= 3;
                                          client.field518 = class36.field775[var5];
                                          class104.field1759 = class13.method166(class36.field775[1 + var5]);
                                          if(null == class104.field1759) {
                                             class104.field1759 = class130.field2049;
                                          }

                                          client.field497 = class36.field775[2 + var5];
                                          client.field321.method2762(242);
                                          client.field321.method2565(client.field518);
                                          client.field321.method2565(class104.field1759.field2050);
                                          client.field321.method2565(client.field497);
                                          continue;
                                       }

                                       if(var33 == 5002) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          var5 -= 2;
                                          var38 = class36.field775[var5];
                                          var36 = class36.field775[1 + var5];
                                          client.field321.method2762(57);
                                          client.field321.method2565(class47.method982(var79) + 2);
                                          client.field321.method2514(var79);
                                          client.field321.method2565(var38 - 1);
                                          client.field321.method2565(var36);
                                          continue;
                                       }

                                       if(5003 == var33) {
                                          var5 -= 2;
                                          var15 = class36.field775[var5];
                                          var38 = class36.field775[1 + var5];
                                          class35 var82 = class50.method1013(var15, var38);
                                          if(null != var82) {
                                             class36.field775[var5++] = var82.field760;
                                             class36.field775[var5++] = var82.field759;
                                             class36.field769[var6++] = null != var82.field761?var82.field761:"";
                                             class36.field769[var6++] = null != var82.field767?var82.field767:"";
                                             class36.field769[var6++] = var82.field763 != null?var82.field763:"";
                                          } else {
                                             class36.field775[var5++] = -1;
                                             class36.field775[var5++] = 0;
                                             class36.field769[var6++] = "";
                                             class36.field769[var6++] = "";
                                             class36.field769[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(5004 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class35 var92 = (class35)class11.field171.method3809((long)var15);
                                          if(var92 != null) {
                                             class36.field775[var5++] = var92.field768;
                                             class36.field775[var5++] = var92.field759;
                                             class36.field769[var6++] = null != var92.field761?var92.field761:"";
                                             class36.field769[var6++] = null != var92.field767?var92.field767:"";
                                             class36.field769[var6++] = var92.field763 != null?var92.field763:"";
                                          } else {
                                             class36.field775[var5++] = -1;
                                             class36.field775[var5++] = 0;
                                             class36.field769[var6++] = "";
                                             class36.field769[var6++] = "";
                                             class36.field769[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var33 == 5005) {
                                          if(null == class104.field1759) {
                                             class36.field775[var5++] = -1;
                                          } else {
                                             class36.field775[var5++] = class104.field1759.field2050;
                                          }
                                          continue;
                                       }

                                       if(var33 == 5008) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          --var5;
                                          var38 = class36.field775[var5];
                                          var37 = var79.toLowerCase();
                                          byte var67 = 0;
                                          if(var37.startsWith("yellow:")) {
                                             var67 = 0;
                                             var79 = var79.substring("yellow:".length());
                                          } else if(var37.startsWith("red:")) {
                                             var67 = 1;
                                             var79 = var79.substring("red:".length());
                                          } else if(var37.startsWith("green:")) {
                                             var67 = 2;
                                             var79 = var79.substring("green:".length());
                                          } else if(var37.startsWith("cyan:")) {
                                             var67 = 3;
                                             var79 = var79.substring("cyan:".length());
                                          } else if(var37.startsWith("purple:")) {
                                             var67 = 4;
                                             var79 = var79.substring("purple:".length());
                                          } else if(var37.startsWith("white:")) {
                                             var67 = 5;
                                             var79 = var79.substring("white:".length());
                                          } else if(var37.startsWith("flash1:")) {
                                             var67 = 6;
                                             var79 = var79.substring("flash1:".length());
                                          } else if(var37.startsWith("flash2:")) {
                                             var67 = 7;
                                             var79 = var79.substring("flash2:".length());
                                          } else if(var37.startsWith("flash3:")) {
                                             var67 = 8;
                                             var79 = var79.substring("flash3:".length());
                                          } else if(var37.startsWith("glow1:")) {
                                             var67 = 9;
                                             var79 = var79.substring("glow1:".length());
                                          } else if(var37.startsWith("glow2:")) {
                                             var67 = 10;
                                             var79 = var79.substring("glow2:".length());
                                          } else if(var37.startsWith("glow3:")) {
                                             var67 = 11;
                                             var79 = var79.substring("glow3:".length());
                                          } else if(0 != client.field286) {
                                             if(var37.startsWith("yellow:")) {
                                                var67 = 0;
                                                var79 = var79.substring("yellow:".length());
                                             } else if(var37.startsWith("red:")) {
                                                var67 = 1;
                                                var79 = var79.substring("red:".length());
                                             } else if(var37.startsWith("green:")) {
                                                var67 = 2;
                                                var79 = var79.substring("green:".length());
                                             } else if(var37.startsWith("cyan:")) {
                                                var67 = 3;
                                                var79 = var79.substring("cyan:".length());
                                             } else if(var37.startsWith("purple:")) {
                                                var67 = 4;
                                                var79 = var79.substring("purple:".length());
                                             } else if(var37.startsWith("white:")) {
                                                var67 = 5;
                                                var79 = var79.substring("white:".length());
                                             } else if(var37.startsWith("flash1:")) {
                                                var67 = 6;
                                                var79 = var79.substring("flash1:".length());
                                             } else if(var37.startsWith("flash2:")) {
                                                var67 = 7;
                                                var79 = var79.substring("flash2:".length());
                                             } else if(var37.startsWith("flash3:")) {
                                                var67 = 8;
                                                var79 = var79.substring("flash3:".length());
                                             } else if(var37.startsWith("glow1:")) {
                                                var67 = 9;
                                                var79 = var79.substring("glow1:".length());
                                             } else if(var37.startsWith("glow2:")) {
                                                var67 = 10;
                                                var79 = var79.substring("glow2:".length());
                                             } else if(var37.startsWith("glow3:")) {
                                                var67 = 11;
                                                var79 = var79.substring("glow3:".length());
                                             }
                                          }

                                          var37 = var79.toLowerCase();
                                          byte var78 = 0;
                                          if(var37.startsWith("wave:")) {
                                             var78 = 1;
                                             var79 = var79.substring("wave:".length());
                                          } else if(var37.startsWith("wave2:")) {
                                             var78 = 2;
                                             var79 = var79.substring("wave2:".length());
                                          } else if(var37.startsWith("shake:")) {
                                             var78 = 3;
                                             var79 = var79.substring("shake:".length());
                                          } else if(var37.startsWith("scroll:")) {
                                             var78 = 4;
                                             var79 = var79.substring("scroll:".length());
                                          } else if(var37.startsWith("slide:")) {
                                             var78 = 5;
                                             var79 = var79.substring("slide:".length());
                                          } else if(client.field286 != 0) {
                                             if(var37.startsWith("wave:")) {
                                                var78 = 1;
                                                var79 = var79.substring("wave:".length());
                                             } else if(var37.startsWith("wave2:")) {
                                                var78 = 2;
                                                var79 = var79.substring("wave2:".length());
                                             } else if(var37.startsWith("shake:")) {
                                                var78 = 3;
                                                var79 = var79.substring("shake:".length());
                                             } else if(var37.startsWith("scroll:")) {
                                                var78 = 4;
                                                var79 = var79.substring("scroll:".length());
                                             } else if(var37.startsWith("slide:")) {
                                                var78 = 5;
                                                var79 = var79.substring("slide:".length());
                                             }
                                          }

                                          client.field321.method2762(252);
                                          client.field321.method2565(0);
                                          var47 = client.field321.field1976;
                                          client.field321.method2565(var38);
                                          client.field321.method2565(var67);
                                          client.field321.method2565(var78);
                                          class151.method3150(client.field321, var79);
                                          client.field321.method2524(client.field321.field1976 - var47);
                                          continue;
                                       }

                                       if(var33 == 5009) {
                                          var6 -= 2;
                                          var79 = class36.field769[var6];
                                          var48 = class36.field769[var6 + 1];
                                          client.field321.method2762(233);
                                          client.field321.method2713(0);
                                          var36 = client.field321.field1976;
                                          client.field321.method2514(var79);
                                          class151.method3150(client.field321, var48);
                                          client.field321.method2519(client.field321.field1976 - var36);
                                          continue;
                                       }

                                       if(var33 == 5015) {
                                          if(null != class20.field572 && null != class20.field572.field45) {
                                             var79 = class20.field572.field45;
                                          } else {
                                             var79 = "";
                                          }

                                          class36.field769[var6++] = var79;
                                          continue;
                                       }

                                       if(var33 == 5016) {
                                          class36.field775[var5++] = client.field497;
                                          continue;
                                       }

                                       if(var33 == 5017) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var87 = class36.field775;
                                          var36 = var5++;
                                          class27 var77 = (class27)class11.field172.get(Integer.valueOf(var15));
                                          if(var77 == null) {
                                             var41 = 0;
                                          } else {
                                             var41 = var77.method638();
                                          }

                                          var87[var36] = var41;
                                          continue;
                                       }

                                       if(5018 == var33) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          class36.field775[var5++] = class166.method3252(var15);
                                          continue;
                                       }

                                       if(var33 == 5019) {
                                          --var5;
                                          var15 = class36.field775[var5];
                                          var87 = class36.field775;
                                          var36 = var5++;
                                          class35 var76 = (class35)class11.field171.method3809((long)var15);
                                          if(null == var76) {
                                             var41 = -1;
                                          } else if(var76.field3104 == class11.field173.field3100) {
                                             var41 = -1;
                                          } else {
                                             var41 = ((class35)var76.field3104).field760;
                                          }

                                          var87[var36] = var41;
                                          continue;
                                       }

                                       if(5020 == var33) {
                                          --var6;
                                          var79 = class36.field769[var6];
                                          if(var79.equalsIgnoreCase("toggleroof")) {
                                             class39.field865.field146 = !class39.field865.field146;
                                             class43.method915();
                                             if(class39.field865.field146) {
                                                class87.method2092(99, "", "Roofs are now all hidden");
                                             } else {
                                                class87.method2092(99, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if(var79.equalsIgnoreCase("displayfps")) {
                                             client.field295 = !client.field295;
                                          }

                                          if(client.field482 >= 2) {
                                             if(var79.equalsIgnoreCase("fpson")) {
                                                client.field295 = true;
                                             }

                                             if(var79.equalsIgnoreCase("fpsoff")) {
                                                client.field295 = false;
                                             }

                                             if(var79.equalsIgnoreCase("gc")) {
                                                System.gc();
                                             }

                                             if(var79.equalsIgnoreCase("clientdrop")) {
                                                class4.method46();
                                             }

                                             if(var79.equalsIgnoreCase("errortest") && 2 == client.field282) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          client.field321.method2762(81);
                                          client.field321.method2565(var79.length() + 1);
                                          client.field321.method2514(var79);
                                          continue;
                                       }

                                       if(var33 == 5021) {
                                          --var6;
                                          client.field495 = class36.field769[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var33 == 5022) {
                                          class36.field769[var6++] = client.field495;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var33 >= 2000) {
                                 var33 -= 1000;
                                 --var5;
                                 var35 = class148.method3129(class36.field775[var5]);
                              } else {
                                 var35 = var46?class36.field779:class1.field27;
                              }

                              if(1300 == var33) {
                                 --var5;
                                 var38 = class36.field775[var5] - 1;
                                 if(var38 >= 0 && var38 <= 9) {
                                    --var6;
                                    var35.method3371(var38, class36.field769[var6]);
                                    continue;
                                 }

                                 --var6;
                                 continue;
                              }

                              if(var33 == 1301) {
                                 var5 -= 2;
                                 var38 = class36.field775[var5];
                                 var36 = class36.field775[var5 + 1];
                                 var35.field2830 = class40.method837(var38, var36);
                                 continue;
                              }

                              if(var33 == 1302) {
                                 --var5;
                                 var35.field2863 = class36.field775[var5] == 1;
                                 continue;
                              }

                              if(1303 == var33) {
                                 --var5;
                                 var35.field2854 = class36.field775[var5];
                                 continue;
                              }

                              if(1304 == var33) {
                                 --var5;
                                 var35.field2755 = class36.field775[var5];
                                 continue;
                              }

                              if(var33 == 1305) {
                                 --var6;
                                 var35.field2828 = class36.field769[var6];
                                 continue;
                              }

                              if(1306 == var33) {
                                 --var6;
                                 var35.field2812 = class36.field769[var6];
                                 continue;
                              }

                              if(var33 == 1307) {
                                 var35.field2829 = null;
                                 continue;
                              }
                           }
                        } else {
                           if(var33 >= 2000) {
                              var33 -= 1000;
                              --var5;
                              var35 = class148.method3129(class36.field775[var5]);
                           } else {
                              var35 = var46?class36.field779:class1.field27;
                           }

                           class9.method133(var35);
                           if(1200 == var33 || 1205 == var33 || 1212 == var33) {
                              var5 -= 2;
                              var38 = class36.field775[var5];
                              var36 = class36.field775[1 + var5];
                              var35.field2822 = var38;
                              var35.field2866 = var36;
                              class51 var39 = class33.method711(var38);
                              var35.field2765 = var39.field1097;
                              var35.field2807 = var39.field1098;
                              var35.field2800 = var39.field1084;
                              var35.field2804 = var39.field1106;
                              var35.field2805 = var39.field1133;
                              var35.field2802 = var39.field1096;
                              if(1205 == var33) {
                                 var35.field2813 = 0;
                              } else if(var33 == 1212 | var39.field1102 == 1) {
                                 var35.field2813 = 1;
                              } else {
                                 var35.field2813 = 2;
                              }

                              if(var35.field2810 > 0) {
                                 var35.field2802 = var35.field2802 * 32 / var35.field2810;
                              } else if(var35.field2766 > 0) {
                                 var35.field2802 = var35.field2802 * 32 / var35.field2766;
                              }
                              continue;
                           }

                           if(1201 == var33) {
                              var35.field2798 = 2;
                              --var5;
                              var35.field2876 = class36.field775[var5];
                              continue;
                           }

                           if(var33 == 1202) {
                              var35.field2798 = 3;
                              var35.field2876 = class20.field572.field35.method3471();
                              continue;
                           }
                        }
                     } else {
                        var38 = -1;
                        if(var33 >= 2000) {
                           var33 -= 1000;
                           --var5;
                           var38 = class36.field775[var5];
                           var35 = class148.method3129(var38);
                        } else {
                           var35 = var46?class36.field779:class1.field27;
                        }

                        if(1100 == var33) {
                           var5 -= 2;
                           var35.field2776 = class36.field775[var5];
                           if(var35.field2776 > var35.field2778 - var35.field2770) {
                              var35.field2776 = var35.field2778 - var35.field2770;
                           }

                           if(var35.field2776 < 0) {
                              var35.field2776 = 0;
                           }

                           var35.field2815 = class36.field775[var5 + 1];
                           if(var35.field2815 > var35.field2779 - var35.field2834) {
                              var35.field2815 = var35.field2779 - var35.field2834;
                           }

                           if(var35.field2815 < 0) {
                              var35.field2815 = 0;
                           }

                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1101) {
                           --var5;
                           var35.field2780 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1102) {
                           --var5;
                           var35.field2784 = class36.field775[var5] == 1;
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1103) {
                           --var5;
                           var35.field2786 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(1104 == var33) {
                           --var5;
                           var35.field2788 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1105) {
                           --var5;
                           var35.field2858 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(1106 == var33) {
                           --var5;
                           var35.field2801 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(1107 == var33) {
                           --var5;
                           var35.field2793 = class36.field775[var5] == 1;
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1108) {
                           var35.field2798 = 1;
                           --var5;
                           var35.field2876 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1109) {
                           var5 -= 6;
                           var35.field2804 = class36.field775[var5];
                           var35.field2805 = class36.field775[var5 + 1];
                           var35.field2765 = class36.field775[var5 + 2];
                           var35.field2807 = class36.field775[3 + var5];
                           var35.field2800 = class36.field775[4 + var5];
                           var35.field2802 = class36.field775[5 + var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1110) {
                           --var5;
                           var36 = class36.field775[var5];
                           if(var36 != var35.field2845) {
                              var35.field2845 = var36;
                              var35.field2749 = 0;
                              var35.field2868 = 0;
                              class9.method133(var35);
                           }
                           continue;
                        }

                        if(var33 == 1111) {
                           --var5;
                           var35.field2806 = class36.field775[var5] == 1;
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1112) {
                           --var6;
                           var37 = class36.field769[var6];
                           if(!var37.equals(var35.field2853)) {
                              var35.field2853 = var37;
                              class9.method133(var35);
                           }
                           continue;
                        }

                        if(1113 == var33) {
                           --var5;
                           var35.field2814 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(1114 == var33) {
                           var5 -= 3;
                           var35.field2818 = class36.field775[var5];
                           var35.field2819 = class36.field775[var5 + 1];
                           var35.field2817 = class36.field775[var5 + 2];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1115) {
                           --var5;
                           var35.field2820 = class36.field775[var5] == 1;
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1116) {
                           --var5;
                           var35.field2839 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1117) {
                           --var5;
                           var35.field2795 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(1118 == var33) {
                           --var5;
                           var35.field2796 = class36.field775[var5] == 1;
                           class9.method133(var35);
                           continue;
                        }

                        if(1119 == var33) {
                           --var5;
                           var35.field2797 = class36.field775[var5] == 1;
                           class9.method133(var35);
                           continue;
                        }

                        if(1120 == var33) {
                           var5 -= 2;
                           var35.field2778 = class36.field775[var5];
                           var35.field2779 = class36.field775[1 + var5];
                           class9.method133(var35);
                           if(var38 != -1 && 0 == var35.field2757) {
                              class181.method3515(class173.field2837[var38 >> 16], var35, false);
                           }
                           continue;
                        }

                        if(1121 == var33) {
                           class157.method3170(var35.field2794, var35.field2816);
                           client.field442 = var35;
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1122) {
                           --var5;
                           var35.field2791 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1123) {
                           --var5;
                           var35.field2831 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1124) {
                           --var5;
                           var35.field2787 = class36.field775[var5];
                           class9.method133(var35);
                           continue;
                        }

                        if(var33 == 1125) {
                           --var5;
                           var36 = class36.field775[var5];
                           class82 var18 = (class82)class35.method731(class56.method1202(), var36);
                           if(null != var18) {
                              var35.field2785 = var18;
                              class9.method133(var35);
                           }
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var33 >= 2000) {
                        var33 -= 1000;
                        --var5;
                        var15 = class36.field775[var5];
                        var16 = class148.method3129(var15);
                     } else {
                        var16 = var46?class36.field779:class1.field27;
                     }

                     if(1000 == var33) {
                        var5 -= 4;
                        var16.field2764 = class36.field775[var5];
                        var16.field2886 = class36.field775[1 + var5];
                        var16.field2760 = class36.field775[var5 + 2];
                        var16.field2761 = class36.field775[3 + var5];
                        class9.method133(var16);
                        class90.method2102(var16);
                        if(var15 != -1 && 0 == var16.field2757) {
                           class181.method3515(class173.field2837[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(1001 == var33) {
                        var5 -= 4;
                        var16.field2766 = class36.field775[var5];
                        var16.field2767 = class36.field775[1 + var5];
                        var16.field2762 = class36.field775[2 + var5];
                        var16.field2763 = class36.field775[3 + var5];
                        class9.method133(var16);
                        class90.method2102(var16);
                        if(-1 != var15 && var16.field2757 == 0) {
                           class181.method3515(class173.field2837[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var33 == 1003) {
                        --var5;
                        var17 = class36.field775[var5] == 1;
                        if(var17 != var16.field2775) {
                           var16.field2775 = var17;
                           class9.method133(var16);
                        }
                        continue;
                     }

                     if(var33 == 1005) {
                        --var5;
                        var16.field2888 = class36.field775[var5] == 1;
                        continue;
                     }

                     if(1006 == var33) {
                        --var5;
                        var16.field2889 = class36.field775[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var33 < 5400) {
                  if(var33 == 5306) {
                     class36.field775[var5++] = class89.method2098();
                     continue;
                  }

                  if(var33 == 5307) {
                     --var5;
                     var15 = class36.field775[var5];
                     if(1 == var15 || 2 == var15) {
                        class8.method119(var15);
                     }
                     continue;
                  }

                  if(5308 == var33) {
                     class36.field775[var5++] = class39.field865.field148;
                     continue;
                  }

                  if(var33 == 5309) {
                     --var5;
                     var15 = class36.field775[var5];
                     if(1 == var15 || var15 == 2) {
                        class39.field865.field148 = var15;
                        class43.method915();
                     }
                     continue;
                  }
               }

               if(var33 < 5600) {
                  if(var33 == 5504) {
                     var5 -= 2;
                     var15 = class36.field775[var5];
                     var38 = class36.field775[var5 + 1];
                     if(!client.field313) {
                        client.field449 = var15;
                        client.field368 = var38;
                     }
                     continue;
                  }

                  if(var33 == 5505) {
                     class36.field775[var5++] = client.field449;
                     continue;
                  }

                  if(5506 == var33) {
                     class36.field775[var5++] = client.field368;
                     continue;
                  }

                  if(var33 == 5530) {
                     --var5;
                     var15 = class36.field775[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     client.field322 = var15;
                     continue;
                  }

                  if(var33 == 5531) {
                     class36.field775[var5++] = client.field322;
                     continue;
                  }
               }

               if(var33 < 5700 && 5630 == var33) {
                  client.field472 = 250;
               } else {
                  if(var33 < 6300) {
                     if(var33 == 6200) {
                        var5 -= 2;
                        client.field532 = (short)class36.field775[var5];
                        if(client.field532 <= 0) {
                           client.field532 = 256;
                        }

                        client.field533 = (short)class36.field775[var5 + 1];
                        if(client.field533 <= 0) {
                           client.field533 = 205;
                        }
                        continue;
                     }

                     if(var33 == 6201) {
                        var5 -= 2;
                        client.field534 = (short)class36.field775[var5];
                        if(client.field534 <= 0) {
                           client.field534 = 256;
                        }

                        client.field535 = (short)class36.field775[1 + var5];
                        if(client.field535 <= 0) {
                           client.field535 = 320;
                        }
                        continue;
                     }

                     if(6202 == var33) {
                        var5 -= 4;
                        client.field461 = (short)class36.field775[var5];
                        if(client.field461 <= 0) {
                           client.field461 = 1;
                        }

                        client.field456 = (short)class36.field775[var5 + 1];
                        if(client.field456 <= 0) {
                           client.field456 = 32767;
                        } else if(client.field456 < client.field461) {
                           client.field456 = client.field461;
                        }

                        client.field538 = (short)class36.field775[var5 + 2];
                        if(client.field538 <= 0) {
                           client.field538 = 1;
                        }

                        client.field526 = (short)class36.field775[3 + var5];
                        if(client.field526 <= 0) {
                           client.field526 = 32767;
                        } else if(client.field526 < client.field538) {
                           client.field526 = client.field538;
                        }
                        continue;
                     }

                     if(var33 == 6203) {
                        if(null != client.field510) {
                           class141.method2976(0, 0, client.field510.field2770, client.field510.field2834, false);
                           class36.field775[var5++] = client.field371;
                           class36.field775[var5++] = client.field543;
                        } else {
                           class36.field775[var5++] = -1;
                           class36.field775[var5++] = -1;
                        }
                        continue;
                     }

                     if(var33 == 6204) {
                        class36.field775[var5++] = client.field534;
                        class36.field775[var5++] = client.field535;
                        continue;
                     }

                     if(6205 == var33) {
                        class36.field775[var5++] = client.field532;
                        class36.field775[var5++] = client.field533;
                        continue;
                     }
                  }

                  if(var33 < 6600) {
                     if(6500 == var33) {
                        class36.field775[var5++] = class169.method3352()?1:0;
                        continue;
                     }

                     class25 var99;
                     if(var33 == 6501) {
                        class25.field613 = 0;
                        var99 = class29.method659();
                        if(var99 != null) {
                           class36.field775[var5++] = var99.field620;
                           class36.field775[var5++] = var99.field621;
                           class36.field769[var6++] = var99.field624;
                           class36.field775[var5++] = var99.field625;
                           class36.field775[var5++] = var99.field622;
                           class36.field769[var6++] = var99.field623;
                        } else {
                           class36.field775[var5++] = -1;
                           class36.field775[var5++] = 0;
                           class36.field769[var6++] = "";
                           class36.field775[var5++] = 0;
                           class36.field775[var5++] = 0;
                           class36.field769[var6++] = "";
                        }
                        continue;
                     }

                     if(var33 == 6502) {
                        var99 = class29.method659();
                        if(null != var99) {
                           class36.field775[var5++] = var99.field620;
                           class36.field775[var5++] = var99.field621;
                           class36.field769[var6++] = var99.field624;
                           class36.field775[var5++] = var99.field625;
                           class36.field775[var5++] = var99.field622;
                           class36.field769[var6++] = var99.field623;
                        } else {
                           class36.field775[var5++] = -1;
                           class36.field775[var5++] = 0;
                           class36.field769[var6++] = "";
                           class36.field775[var5++] = 0;
                           class36.field775[var5++] = 0;
                           class36.field769[var6++] = "";
                        }
                        continue;
                     }

                     class25 var94;
                     if(var33 == 6506) {
                        --var5;
                        var15 = class36.field775[var5];
                        var94 = null;

                        for(var36 = 0; var36 < class25.field616; ++var36) {
                           if(var15 == class25.field615[var36].field620) {
                              var94 = class25.field615[var36];
                              break;
                           }
                        }

                        if(var94 != null) {
                           class36.field775[var5++] = var94.field620;
                           class36.field775[var5++] = var94.field621;
                           class36.field769[var6++] = var94.field624;
                           class36.field775[var5++] = var94.field625;
                           class36.field775[var5++] = var94.field622;
                           class36.field769[var6++] = var94.field623;
                        } else {
                           class36.field775[var5++] = -1;
                           class36.field775[var5++] = 0;
                           class36.field769[var6++] = "";
                           class36.field775[var5++] = 0;
                           class36.field775[var5++] = 0;
                           class36.field769[var6++] = "";
                        }
                        continue;
                     }

                     if(var33 == 6507) {
                        var5 -= 4;
                        var15 = class36.field775[var5];
                        var50 = class36.field775[var5 + 1] == 1;
                        var36 = class36.field775[var5 + 2];
                        var57 = class36.field775[var5 + 3] == 1;
                        class170.method3355(var15, var50, var36, var57);
                        continue;
                     }

                     if(var33 == 6511) {
                        --var5;
                        var15 = class36.field775[var5];
                        if(var15 >= 0 && var15 < class25.field616) {
                           var94 = class25.field615[var15];
                           class36.field775[var5++] = var94.field620;
                           class36.field775[var5++] = var94.field621;
                           class36.field769[var6++] = var94.field624;
                           class36.field775[var5++] = var94.field625;
                           class36.field775[var5++] = var94.field622;
                           class36.field769[var6++] = var94.field623;
                           continue;
                        }

                        class36.field775[var5++] = -1;
                        class36.field775[var5++] = 0;
                        class36.field769[var6++] = "";
                        class36.field775[var5++] = 0;
                        class36.field775[var5++] = 0;
                        class36.field769[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var32) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3115).append(" ");

            for(var13 = class36.field777 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field778[var13].field207.field3115).append(" ");
            }

            var12.append("").append(var10);
            class1.method16(var12.toString(), var32);
         }
      }
   }

   @ObfuscatedName("f")
   static class78[] method653(class167 var0, int var1, int var2) {
      return !class23.method586(var0, var1, var2)?null:method658();
   }

   @ObfuscatedName("s")
   static boolean method655(class122 var0, int var1) {
      int var2 = var0.method2756(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2756(1) != 0) {
            method655(var0, var1);
         }

         var3 = var0.method2756(6);
         var4 = var0.method2756(6);
         boolean var11 = var0.method2756(1) == 1;
         if(var11) {
            class32.field739[++class32.field741 - 1] = var1;
         }

         if(client.field387[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field387[var1] = new class2();
            var12.field56 = var1;
            if(class32.field729[var1] != null) {
               var12.method21(class32.field729[var1]);
            }

            var12.field793 = class32.field736[var1];
            var12.field845 = class32.field737[var1];
            var7 = class32.field735[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field844[0] = class32.field730[var1];
            var12.field55 = (byte)var8;
            var12.method25(var3 + (var9 << 6) - class85.field1439, var4 + (var10 << 6) - class6.field128);
            var12.field44 = false;
            return true;
         }
      } else if(1 == var2) {
         var3 = var0.method2756(2);
         var4 = class32.field735[var1];
         class32.field735[var1] = (var4 & 268435455) + ((var3 + (var4 >> 28) & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2756(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field735[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(4 == var5) {
               ++var8;
            }

            if(5 == var5) {
               --var8;
               ++var9;
            }

            if(6 == var5) {
               ++var9;
            }

            if(7 == var5) {
               ++var8;
               ++var9;
            }

            class32.field735[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method2756(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field735[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var6 + var7 & 255;
            class32.field735[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   protected final class105 vmethod1921() {
      return class33.method711(this.field666).method1021(this.field664);
   }

   @ObfuscatedName("m")
   static class78[] method658() {
      class78[] var0 = new class78[class76.field1359];

      for(int var1 = 0; var1 < class76.field1359; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1372 = class76.field1356;
         var2.field1376 = class76.field1354;
         var2.field1373 = class76.field1357[var1];
         var2.field1374 = class84.field1437[var1];
         var2.field1371 = class5.field86[var1];
         var2.field1378 = class76.field1355[var1];
         int var3 = var2.field1371 * var2.field1378;
         byte[] var4 = class76.field1352[var1];
         var2.field1379 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1379[var5] = class215.field3152[var4[var5] & 255];
         }
      }

      class30.method670();
      return var0;
   }
}

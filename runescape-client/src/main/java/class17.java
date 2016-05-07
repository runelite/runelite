import java.awt.event.ActionEvent;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -1459811283
   )
   static int field236;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1588725403
   )
   int field237;
   @ObfuscatedName("d")
   boolean field238;
   @ObfuscatedName("u")
   boolean field239;
   @ObfuscatedName("j")
   @Export("previousName")
   String field240;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 456957503
   )
   static int field241;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 580305805
   )
   @Export("world")
   int field244;
   @ObfuscatedName("s")
   @Export("name")
   String field247;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "200000"
   )
   static void method201(class0 var0, int var1) {
      Object[] var2 = var0.field12;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class6.method93(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field584;
         int[] var9 = var4.field585;
         byte var10 = -1;
         class36.field804 = 0;

         int var13;
         try {
            class36.field798 = new int[var4.field587];
            int var11 = 0;
            class36.field803 = new String[var4.field588];
            int var30 = 0;

            int var14;
            String var41;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(-2147483647 == var14) {
                     var14 = var0.field14;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(-2147483645 == var14) {
                     var14 = var0.field8 != null?var0.field8.field2826:-1;
                  }

                  if(-2147483644 == var14) {
                     var14 = var0.field5;
                  }

                  if(-2147483643 == var14) {
                     var14 = null != var0.field8?var0.field8.field2766:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field6?var0.field6.field2826:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.field2766:-1;
                  }

                  if(-2147483640 == var14) {
                     var14 = var0.field7;
                  }

                  if(-2147483639 == var14) {
                     var14 = var0.field3;
                  }

                  class36.field798[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var41 = (String)var2[var13];
                  if(var41.equals("event_opbase")) {
                     var41 = var0.field9;
                  }

                  class36.field803[var30++] = var41;
               }
            }

            var13 = 0;
            class36.field810 = var0.field2;

            label4013:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var29 = var8[var7];
               int var16;
               int var10001;
               int var17;
               int var19;
               int var20;
               String var31;
               int var32;
               int[] var34;
               int var48;
               String var52;
               String var59;
               byte[] var71;
               byte var79;
               int var81;
               String var83;
               if(var29 < 100) {
                  if(var29 == 0) {
                     class36.field802[var5++] = var9[var7];
                     continue;
                  }

                  if(var29 == 1) {
                     var14 = var9[var7];
                     class36.field802[var5++] = class176.field2920[var14];
                     continue;
                  }

                  if(2 == var29) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2920[var14] = class36.field802[var5];
                     class52.method1069(var14);
                     continue;
                  }

                  if(var29 == 3) {
                     class36.field808[var6++] = var4.field586[var7];
                     continue;
                  }

                  if(var29 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var29 == 7) {
                     var5 -= 2;
                     if(class36.field802[var5] != class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var29) {
                     var5 -= 2;
                     if(class36.field802[var5] == class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(9 == var29) {
                     var5 -= 2;
                     if(class36.field802[var5] < class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var29 == 10) {
                     var5 -= 2;
                     if(class36.field802[var5] > class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var29 == 21) {
                     if(class36.field804 == 0) {
                        return;
                     }

                     class14 var76 = class36.field805[--class36.field804];
                     var4 = var76.field200;
                     var8 = var4.field584;
                     var9 = var4.field585;
                     var7 = var76.field198;
                     class36.field798 = var76.field201;
                     class36.field803 = var76.field202;
                     continue;
                  }

                  if(var29 == 25) {
                     var14 = var9[var7];
                     class36.field802[var5++] = class32.method691(var14);
                     continue;
                  }

                  if(27 == var29) {
                     var14 = var9[var7];
                     --var5;
                     var81 = class36.field802[var5];
                     class47 var92 = (class47)class47.field1065.method3743((long)var14);
                     class47 var102;
                     if(var92 != null) {
                        var102 = var92;
                     } else {
                        var71 = class47.field1070.method3239(14, var14);
                        var92 = new class47();
                        if(null != var71) {
                           var92.method955(new class119(var71));
                        }

                        class47.field1065.method3745(var92, (long)var14);
                        var102 = var92;
                     }

                     var32 = var102.field1066;
                     var19 = var102.field1064;
                     var20 = var102.field1068;
                     var48 = class176.field2919[var20 - var19];
                     if(var81 < 0 || var81 > var48) {
                        var81 = 0;
                     }

                     var48 <<= var19;
                     class176.field2920[var32] = class176.field2920[var32] & ~var48 | var81 << var19 & var48;
                     continue;
                  }

                  if(var29 == 31) {
                     var5 -= 2;
                     if(class36.field802[var5] <= class36.field802[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(32 == var29) {
                     var5 -= 2;
                     if(class36.field802[var5] >= class36.field802[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var29 == 33) {
                     class36.field802[var5++] = class36.field798[var9[var7]];
                     continue;
                  }

                  if(34 == var29) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field798[var10001] = class36.field802[var5];
                     continue;
                  }

                  if(35 == var29) {
                     class36.field808[var6++] = class36.field803[var9[var7]];
                     continue;
                  }

                  if(var29 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field803[var10001] = class36.field808[var6];
                     continue;
                  }

                  if(37 == var29) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var101 = class36.field808;
                     if(var14 == 0) {
                        var83 = "";
                     } else if(1 == var14) {
                        var31 = var101[var6];
                        if(var31 == null) {
                           var83 = "null";
                        } else {
                           var83 = var31.toString();
                        }
                     } else {
                        var17 = var14 + var6;
                        var32 = 0;

                        for(var19 = var6; var19 < var17; ++var19) {
                           var52 = var101[var19];
                           if(null == var52) {
                              var32 += 4;
                           } else {
                              var32 += var52.length();
                           }
                        }

                        StringBuilder var88 = new StringBuilder(var32);

                        for(var20 = var6; var20 < var17; ++var20) {
                           var59 = var101[var20];
                           if(null == var59) {
                              var88.append("null");
                           } else {
                              var88.append(var59);
                           }
                        }

                        var83 = var88.toString();
                     }

                     class36.field808[var6++] = var83;
                     continue;
                  }

                  if(var29 == 38) {
                     --var5;
                     continue;
                  }

                  if(39 == var29) {
                     --var6;
                     continue;
                  }

                  if(var29 == 40) {
                     var14 = var9[var7];
                     class22 var106 = class6.method93(var14);
                     var34 = new int[var106.field587];
                     String[] var91 = new String[var106.field588];

                     for(var32 = 0; var32 < var106.field592; ++var32) {
                        var34[var32] = class36.field802[var5 - var106.field592 + var32];
                     }

                     for(var32 = 0; var32 < var106.field590; ++var32) {
                        var91[var32] = class36.field808[var6 - var106.field590 + var32];
                     }

                     var5 -= var106.field592;
                     var6 -= var106.field590;
                     class14 var99 = new class14();
                     var99.field200 = var4;
                     var99.field198 = var7;
                     var99.field201 = class36.field798;
                     var99.field202 = class36.field803;
                     class36.field805[++class36.field804 - 1] = var99;
                     var4 = var106;
                     var8 = var106.field584;
                     var9 = var106.field585;
                     var7 = -1;
                     class36.field798 = var34;
                     class36.field803 = var91;
                     continue;
                  }

                  if(var29 == 42) {
                     class36.field802[var5++] = class34.field784.method213(var9[var7]);
                     continue;
                  }

                  if(var29 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class34.field784.method226(var10001, class36.field802[var5]);
                     continue;
                  }

                  if(var29 == 44) {
                     var14 = var9[var7] >> 16;
                     var81 = var9[var7] & '\uffff';
                     --var5;
                     var16 = class36.field802[var5];
                     if(var16 >= 0 && var16 <= 5000) {
                        class36.field800[var14] = var16;
                        var79 = -1;
                        if(var81 == 105) {
                           var79 = 0;
                        }

                        var32 = 0;

                        while(true) {
                           if(var32 >= var16) {
                              continue label4013;
                           }

                           class36.field801[var14][var32] = var79;
                           ++var32;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var29 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var81 = class36.field802[var5];
                     if(var81 >= 0 && var81 < class36.field800[var14]) {
                        class36.field802[var5++] = class36.field801[var14][var81];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var29) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var81 = class36.field802[var5];
                     if(var81 >= 0 && var81 < class36.field800[var14]) {
                        class36.field801[var14][var81] = class36.field802[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var29 == 47) {
                     var41 = class34.field784.method233(var9[var7]);
                     if(var41 == null) {
                        var41 = "null";
                     }

                     class36.field808[var6++] = var41;
                     continue;
                  }

                  if(48 == var29) {
                     var10001 = var9[var7];
                     --var6;
                     class34.field784.method214(var10001, class36.field808[var6]);
                     continue;
                  }
               }

               boolean var47;
               if(1 == var9[var7]) {
                  var47 = true;
               } else {
                  var47 = false;
               }

               class173 var15;
               class173 var38;
               class173 var40;
               boolean var46;
               boolean var65;
               class173 var97;
               int[] var104;
               if(var29 < 1000) {
                  if(100 == var29) {
                     var5 -= 3;
                     var81 = class36.field802[var5];
                     var16 = class36.field802[var5 + 1];
                     var17 = class36.field802[var5 + 2];
                     if(var16 == 0) {
                        throw new RuntimeException();
                     }

                     var38 = class29.method645(var81);
                     if(null == var38.field2847) {
                        var38.field2847 = new class173[1 + var17];
                     }

                     if(var38.field2847.length <= var17) {
                        class173[] var85 = new class173[var17 + 1];

                        for(var20 = 0; var20 < var38.field2847.length; ++var20) {
                           var85[var20] = var38.field2847[var20];
                        }

                        var38.field2847 = var85;
                     }

                     if(var17 > 0 && var38.field2847[var17 - 1] == null) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     class173 var87 = new class173();
                     var87.field2767 = var16;
                     var10001 = var38.field2826;
                     var87.field2826 = var38.field2826 * 1244987933;
                     var87.field2784 = var10001;
                     var87.field2766 = var17;
                     var87.field2764 = true;
                     var38.field2847[var17] = var87;
                     if(var47) {
                        class141.field2173 = var87;
                     } else {
                        class12.field185 = var87;
                     }

                     class34.method701(var38);
                     continue;
                  }

                  if(var29 == 101) {
                     var15 = var47?class141.field2173:class12.field185;
                     var97 = class29.method645(var15.field2826);
                     var97.field2847[var15.field2766] = null;
                     class34.method701(var97);
                     continue;
                  }

                  if(102 == var29) {
                     --var5;
                     var15 = class29.method645(class36.field802[var5]);
                     var15.field2847 = null;
                     class34.method701(var15);
                     continue;
                  }

                  if(var29 == 200) {
                     var5 -= 2;
                     var81 = class36.field802[var5];
                     var16 = class36.field802[1 + var5];
                     var40 = class45.method932(var81, var16);
                     if(var40 != null && -1 != var16) {
                        class36.field802[var5++] = 1;
                        if(var47) {
                           class141.field2173 = var40;
                        } else {
                           class12.field185 = var40;
                        }
                        continue;
                     }

                     class36.field802[var5++] = 0;
                     continue;
                  }

                  if(201 == var29) {
                     --var5;
                     var15 = class29.method645(class36.field802[var5]);
                     if(null != var15) {
                        class36.field802[var5++] = 1;
                        if(var47) {
                           class141.field2173 = var15;
                        } else {
                           class12.field185 = var15;
                        }
                     } else {
                        class36.field802[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var69;
                  if(var29 >= 1000 && var29 < 1100 || var29 >= 2000 && var29 < 2100) {
                     var81 = -1;
                     if(var29 >= 2000) {
                        var29 -= 1000;
                        --var5;
                        var81 = class36.field802[var5];
                        var97 = class29.method645(var81);
                     } else {
                        var97 = var47?class141.field2173:class12.field185;
                     }

                     if(1000 == var29) {
                        var5 -= 4;
                        var97.field2774 = class36.field802[var5];
                        var97.field2775 = class36.field802[var5 + 1];
                        var97.field2770 = class36.field802[var5 + 2];
                        var97.field2810 = class36.field802[3 + var5];
                        class34.method701(var97);
                        class87.method2063(var97);
                        if(-1 != var81 && 0 == var97.field2767) {
                           class125.method2796(class217.field3171[var81 >> 16], var97, false);
                        }
                        continue;
                     }

                     if(var29 == 1001) {
                        var5 -= 4;
                        var97.field2776 = class36.field802[var5];
                        var97.field2777 = class36.field802[1 + var5];
                        var97.field2772 = class36.field802[2 + var5];
                        var97.field2889 = class36.field802[var5 + 3];
                        class34.method701(var97);
                        class87.method2063(var97);
                        if(-1 != var81 && 0 == var97.field2767) {
                           class125.method2796(class217.field3171[var81 >> 16], var97, false);
                        }
                        continue;
                     }

                     if(var29 == 1003) {
                        --var5;
                        var69 = class36.field802[var5] == 1;
                        if(var97.field2773 != var69) {
                           var97.field2773 = var69;
                           class34.method701(var97);
                        }
                        continue;
                     }

                     if(var29 == 1005) {
                        --var5;
                        var97.field2898 = class36.field802[var5] == 1;
                        continue;
                     }

                     if(var29 == 1006) {
                        --var5;
                        var97.field2877 = class36.field802[var5] == 1;
                        continue;
                     }
                  } else if((var29 < 1100 || var29 >= 1200) && (var29 < 2100 || var29 >= 2200)) {
                     if((var29 < 1200 || var29 >= 1300) && (var29 < 2200 || var29 >= 2300)) {
                        if((var29 < 1300 || var29 >= 1400) && (var29 < 2300 || var29 >= 2400)) {
                           String var43;
                           int[] var49;
                           if(var29 >= 1400 && var29 < 1500 || var29 >= 2400 && var29 < 2500) {
                              if(var29 >= 2000) {
                                 var29 -= 1000;
                                 --var5;
                                 var15 = class29.method645(class36.field802[var5]);
                              } else {
                                 var15 = var47?class141.field2173:class12.field185;
                              }

                              --var6;
                              var43 = class36.field808[var6];
                              var49 = null;
                              if(var43.length() > 0 && var43.charAt(var43.length() - 1) == 89) {
                                 --var5;
                                 var32 = class36.field802[var5];
                                 if(var32 > 0) {
                                    for(var49 = new int[var32]; var32-- > 0; var49[var32] = class36.field802[var5]) {
                                       --var5;
                                    }
                                 }

                                 var43 = var43.substring(0, var43.length() - 1);
                              }

                              Object[] var90 = new Object[var43.length() + 1];

                              for(var19 = var90.length - 1; var19 >= 1; --var19) {
                                 if(var43.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var90[var19] = class36.field808[var6];
                                 } else {
                                    --var5;
                                    var90[var19] = new Integer(class36.field802[var5]);
                                 }
                              }

                              --var5;
                              var19 = class36.field802[var5];
                              if(-1 != var19) {
                                 var90[0] = new Integer(var19);
                              } else {
                                 var90 = null;
                              }

                              if(1400 == var29) {
                                 var15.field2872 = var90;
                              }

                              if(1401 == var29) {
                                 var15.field2850 = var90;
                              }

                              if(var29 == 1402) {
                                 var15.field2849 = var90;
                              }

                              if(var29 == 1403) {
                                 var15.field2851 = var90;
                              }

                              if(1404 == var29) {
                                 var15.field2853 = var90;
                              }

                              if(1405 == var29) {
                                 var15.field2854 = var90;
                              }

                              if(var29 == 1406) {
                                 var15.field2800 = var90;
                              }

                              if(var29 == 1407) {
                                 var15.field2808 = var90;
                                 var15.field2771 = var49;
                              }

                              if(var29 == 1408) {
                                 var15.field2793 = var90;
                              }

                              if(1409 == var29) {
                                 var15.field2865 = var90;
                              }

                              if(var29 == 1410) {
                                 var15.field2855 = var90;
                              }

                              if(var29 == 1411) {
                                 var15.field2880 = var90;
                              }

                              if(var29 == 1412) {
                                 var15.field2852 = var90;
                              }

                              if(1414 == var29) {
                                 var15.field2860 = var90;
                                 var15.field2758 = var49;
                              }

                              if(var29 == 1415) {
                                 var15.field2862 = var90;
                                 var15.field2863 = var49;
                              }

                              if(1416 == var29) {
                                 var15.field2892 = var90;
                              }

                              if(var29 == 1417) {
                                 var15.field2843 = var90;
                              }

                              if(var29 == 1418) {
                                 var15.field2867 = var90;
                              }

                              if(1419 == var29) {
                                 var15.field2868 = var90;
                              }

                              if(var29 == 1420) {
                                 var15.field2869 = var90;
                              }

                              if(var29 == 1421) {
                                 var15.field2870 = var90;
                              }

                              if(1422 == var29) {
                                 var15.field2782 = var90;
                              }

                              if(var29 == 1423) {
                                 var15.field2763 = var90;
                              }

                              if(var29 == 1424) {
                                 var15.field2873 = var90;
                              }

                              if(var29 == 1425) {
                                 var15.field2875 = var90;
                              }

                              if(1426 == var29) {
                                 var15.field2792 = var90;
                              }

                              if(var29 == 1427) {
                                 var15.field2874 = var90;
                              }

                              var15.field2845 = true;
                              continue;
                           }

                           if(var29 < 1600) {
                              var15 = var47?class141.field2173:class12.field185;
                              if(1500 == var29) {
                                 class36.field802[var5++] = var15.field2768;
                                 continue;
                              }

                              if(1501 == var29) {
                                 class36.field802[var5++] = var15.field2779;
                                 continue;
                              }

                              if(1502 == var29) {
                                 class36.field802[var5++] = var15.field2886;
                                 continue;
                              }

                              if(var29 == 1503) {
                                 class36.field802[var5++] = var15.field2781;
                                 continue;
                              }

                              if(1504 == var29) {
                                 class36.field802[var5++] = var15.field2773?1:0;
                                 continue;
                              }

                              if(var29 == 1505) {
                                 class36.field802[var5++] = var15.field2784;
                                 continue;
                              }
                           } else if(var29 < 1700) {
                              var15 = var47?class141.field2173:class12.field185;
                              if(var29 == 1600) {
                                 class36.field802[var5++] = var15.field2786;
                                 continue;
                              }

                              if(1601 == var29) {
                                 class36.field802[var5++] = var15.field2787;
                                 continue;
                              }

                              if(var29 == 1602) {
                                 class36.field808[var6++] = var15.field2825;
                                 continue;
                              }

                              if(1603 == var29) {
                                 class36.field802[var5++] = var15.field2848;
                                 continue;
                              }

                              if(var29 == 1604) {
                                 class36.field802[var5++] = var15.field2858;
                                 continue;
                              }

                              if(var29 == 1605) {
                                 class36.field802[var5++] = var15.field2819;
                                 continue;
                              }

                              if(var29 == 1606) {
                                 class36.field802[var5++] = var15.field2816;
                                 continue;
                              }

                              if(var29 == 1607) {
                                 class36.field802[var5++] = var15.field2818;
                                 continue;
                              }

                              if(1608 == var29) {
                                 class36.field802[var5++] = var15.field2817;
                                 continue;
                              }

                              if(var29 == 1609) {
                                 class36.field802[var5++] = var15.field2796;
                                 continue;
                              }

                              if(1610 == var29) {
                                 class36.field802[var5++] = var15.field2833;
                                 continue;
                              }

                              if(var29 == 1611) {
                                 class36.field802[var5++] = var15.field2790;
                                 continue;
                              }

                              if(var29 == 1612) {
                                 class36.field802[var5++] = var15.field2791;
                                 continue;
                              }

                              if(var29 == 1613) {
                                 class36.field802[var5++] = var15.field2795.vmethod3150();
                                 continue;
                              }
                           } else if(var29 < 1800) {
                              var15 = var47?class141.field2173:class12.field185;
                              if(1700 == var29) {
                                 class36.field802[var5++] = var15.field2885;
                                 continue;
                              }

                              if(1701 == var29) {
                                 if(-1 != var15.field2885) {
                                    class36.field802[var5++] = var15.field2780;
                                 } else {
                                    class36.field802[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(1702 == var29) {
                                 class36.field802[var5++] = var15.field2766;
                                 continue;
                              }
                           } else if(var29 < 1900) {
                              var15 = var47?class141.field2173:class12.field185;
                              if(var29 == 1800) {
                                 var34 = class36.field802;
                                 var17 = var5++;
                                 var19 = class48.method962(var15);
                                 var32 = var19 >> 11 & 63;
                                 var34[var17] = var32;
                                 continue;
                              }

                              if(var29 == 1801) {
                                 --var5;
                                 var16 = class36.field802[var5];
                                 --var16;
                                 if(var15.field2839 != null && var16 < var15.field2839.length && null != var15.field2839[var16]) {
                                    class36.field808[var6++] = var15.field2839[var16];
                                    continue;
                                 }

                                 class36.field808[var6++] = "";
                                 continue;
                              }

                              if(var29 == 1802) {
                                 if(var15.field2789 == null) {
                                    class36.field808[var6++] = "";
                                 } else {
                                    class36.field808[var6++] = var15.field2789;
                                 }
                                 continue;
                              }
                           } else if((var29 < 1900 || var29 >= 2000) && (var29 < 2900 || var29 >= 3000)) {
                              if(var29 < 2600) {
                                 --var5;
                                 var15 = class29.method645(class36.field802[var5]);
                                 if(2500 == var29) {
                                    class36.field802[var5++] = var15.field2768;
                                    continue;
                                 }

                                 if(2501 == var29) {
                                    class36.field802[var5++] = var15.field2779;
                                    continue;
                                 }

                                 if(var29 == 2502) {
                                    class36.field802[var5++] = var15.field2886;
                                    continue;
                                 }

                                 if(var29 == 2503) {
                                    class36.field802[var5++] = var15.field2781;
                                    continue;
                                 }

                                 if(2504 == var29) {
                                    class36.field802[var5++] = var15.field2773?1:0;
                                    continue;
                                 }

                                 if(2505 == var29) {
                                    class36.field802[var5++] = var15.field2784;
                                    continue;
                                 }
                              } else if(var29 < 2700) {
                                 --var5;
                                 var15 = class29.method645(class36.field802[var5]);
                                 if(var29 == 2600) {
                                    class36.field802[var5++] = var15.field2786;
                                    continue;
                                 }

                                 if(var29 == 2601) {
                                    class36.field802[var5++] = var15.field2787;
                                    continue;
                                 }

                                 if(2602 == var29) {
                                    class36.field808[var6++] = var15.field2825;
                                    continue;
                                 }

                                 if(var29 == 2603) {
                                    class36.field802[var5++] = var15.field2848;
                                    continue;
                                 }

                                 if(var29 == 2604) {
                                    class36.field802[var5++] = var15.field2858;
                                    continue;
                                 }

                                 if(2605 == var29) {
                                    class36.field802[var5++] = var15.field2819;
                                    continue;
                                 }

                                 if(2606 == var29) {
                                    class36.field802[var5++] = var15.field2816;
                                    continue;
                                 }

                                 if(var29 == 2607) {
                                    class36.field802[var5++] = var15.field2818;
                                    continue;
                                 }

                                 if(var29 == 2608) {
                                    class36.field802[var5++] = var15.field2817;
                                    continue;
                                 }

                                 if(var29 == 2609) {
                                    class36.field802[var5++] = var15.field2796;
                                    continue;
                                 }

                                 if(var29 == 2610) {
                                    class36.field802[var5++] = var15.field2833;
                                    continue;
                                 }

                                 if(2611 == var29) {
                                    class36.field802[var5++] = var15.field2790;
                                    continue;
                                 }

                                 if(2612 == var29) {
                                    class36.field802[var5++] = var15.field2791;
                                    continue;
                                 }

                                 if(2613 == var29) {
                                    class36.field802[var5++] = var15.field2795.vmethod3150();
                                    continue;
                                 }
                              } else if(var29 < 2800) {
                                 if(2700 == var29) {
                                    --var5;
                                    var15 = class29.method645(class36.field802[var5]);
                                    class36.field802[var5++] = var15.field2885;
                                    continue;
                                 }

                                 if(2701 == var29) {
                                    --var5;
                                    var15 = class29.method645(class36.field802[var5]);
                                    if(var15.field2885 != -1) {
                                       class36.field802[var5++] = var15.field2780;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(2702 == var29) {
                                    --var5;
                                    var81 = class36.field802[var5];
                                    class3 var36 = (class3)client.field308.method3777((long)var81);
                                    if(var36 != null) {
                                       class36.field802[var5++] = 1;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var29 == 2706) {
                                    class36.field802[var5++] = client.field412;
                                    continue;
                                 }
                              } else if(var29 < 2900) {
                                 --var5;
                                 var15 = class29.method645(class36.field802[var5]);
                                 if(var29 == 2800) {
                                    var34 = class36.field802;
                                    var17 = var5++;
                                    var19 = class48.method962(var15);
                                    var32 = var19 >> 11 & 63;
                                    var34[var17] = var32;
                                    continue;
                                 }

                                 if(var29 == 2801) {
                                    --var5;
                                    var16 = class36.field802[var5];
                                    --var16;
                                    if(null != var15.field2839 && var16 < var15.field2839.length && var15.field2839[var16] != null) {
                                       class36.field808[var6++] = var15.field2839[var16];
                                       continue;
                                    }

                                    class36.field808[var6++] = "";
                                    continue;
                                 }

                                 if(var29 == 2802) {
                                    if(null == var15.field2789) {
                                       class36.field808[var6++] = "";
                                    } else {
                                       class36.field808[var6++] = var15.field2789;
                                    }
                                    continue;
                                 }
                              } else if(var29 < 3200) {
                                 if(var29 == 3100) {
                                    --var6;
                                    var83 = class36.field808[var6];
                                    class125.method2783(0, "", var83);
                                    continue;
                                 }

                                 if(var29 == 3101) {
                                    var5 -= 2;
                                    method204(class106.field1881, class36.field802[var5], class36.field802[var5 + 1]);
                                    continue;
                                 }

                                 if(var29 == 3103) {
                                    client.field322.method2737(224);

                                    for(class3 var86 = (class3)client.field308.method3780(); null != var86; var86 = (class3)client.field308.method3781()) {
                                       if(var86.field62 == 0 || 3 == var86.field62) {
                                          class38.method737(var86, true);
                                       }
                                    }

                                    if(null != client.field441) {
                                       class34.method701(client.field441);
                                       client.field441 = null;
                                    }
                                    continue;
                                 }

                                 if(var29 == 3104) {
                                    --var6;
                                    var83 = class36.field808[var6];
                                    var16 = 0;
                                    if(class133.method2844(var83)) {
                                       var17 = class121.method2729(var83, 10, true);
                                       var16 = var17;
                                    }

                                    client.field322.method2737(181);
                                    client.field322.method2480(var16);
                                    continue;
                                 }

                                 if(3105 == var29) {
                                    --var6;
                                    var83 = class36.field808[var6];
                                    client.field322.method2737(82);
                                    client.field322.method2477(var83.length() + 1);
                                    client.field322.method2483(var83);
                                    continue;
                                 }

                                 if(var29 == 3106) {
                                    --var6;
                                    var83 = class36.field808[var6];
                                    client.field322.method2737(55);
                                    client.field322.method2477(var83.length() + 1);
                                    client.field322.method2483(var83);
                                    continue;
                                 }

                                 if(3107 == var29) {
                                    --var5;
                                    var81 = class36.field802[var5];
                                    --var6;
                                    var43 = class36.field808[var6];
                                    var17 = class32.field755;
                                    int[] var39 = class32.field756;
                                    boolean var37 = false;

                                    for(var20 = 0; var20 < var17; ++var20) {
                                       class2 var21 = client.field491[var39[var20]];
                                       if(var21 != null && class106.field1881 != var21 && var21.field59 != null && var21.field59.equalsIgnoreCase(var43)) {
                                          if(1 == var81) {
                                             client.field322.method2737(89);
                                             client.field322.method2590(0);
                                             client.field322.method2525(var39[var20]);
                                          } else if(var81 == 4) {
                                             client.field322.method2737(128);
                                             client.field322.method2661(var39[var20]);
                                             client.field322.method2681(0);
                                          } else if(6 == var81) {
                                             client.field322.method2737(134);
                                             client.field322.method2477(0);
                                             client.field322.method2557(var39[var20]);
                                          } else if(var81 == 7) {
                                             client.field322.method2737(52);
                                             client.field322.method2525(var39[var20]);
                                             client.field322.method2516(0);
                                          }

                                          var37 = true;
                                          break;
                                       }
                                    }

                                    if(!var37) {
                                       class125.method2783(4, "", "Unable to find " + var43);
                                    }
                                    continue;
                                 }

                                 if(3108 == var29) {
                                    var5 -= 3;
                                    var81 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    var17 = class36.field802[2 + var5];
                                    var38 = class29.method645(var17);
                                    class129.method2810(var38, var81, var16);
                                    continue;
                                 }

                                 if(3109 == var29) {
                                    var5 -= 2;
                                    var81 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    var40 = var47?class141.field2173:class12.field185;
                                    class129.method2810(var40, var81, var16);
                                    continue;
                                 }

                                 if(3110 == var29) {
                                    --var5;
                                    class89.field1563 = class36.field802[var5] == 1;
                                    continue;
                                 }

                                 if(var29 == 3111) {
                                    class36.field802[var5++] = class76.field1388.field148?1:0;
                                    continue;
                                 }

                                 if(3112 == var29) {
                                    --var5;
                                    class76.field1388.field148 = class36.field802[var5] == 1;
                                    class7.method101();
                                    continue;
                                 }

                                 if(3113 == var29) {
                                    --var6;
                                    var83 = class36.field808[var6];
                                    --var5;
                                    var46 = class36.field802[var5] == 1;
                                    class103.method2275(var83, var46, "openjs", false);
                                    continue;
                                 }

                                 if(var29 == 3115) {
                                    --var5;
                                    var81 = class36.field802[var5];
                                    client.field322.method2737(234);
                                    client.field322.method2661(var81);
                                    continue;
                                 }

                                 if(3116 == var29) {
                                    --var5;
                                    var81 = class36.field802[var5];
                                    var6 -= 2;
                                    var43 = class36.field808[var6];
                                    var31 = class36.field808[1 + var6];
                                    if(var43.length() <= 500 && var31.length() <= 500) {
                                       client.field322.method2737(167);
                                       client.field322.method2661(1 + class30.method647(var43) + class30.method647(var31));
                                       client.field322.method2477(var81);
                                       client.field322.method2483(var31);
                                       client.field322.method2483(var43);
                                    }
                                    continue;
                                 }
                              } else if(var29 < 3300) {
                                 if(3200 == var29) {
                                    var5 -= 3;
                                    class153.method3134(class36.field802[var5], class36.field802[var5 + 1], class36.field802[var5 + 2]);
                                    continue;
                                 }

                                 if(3201 == var29) {
                                    --var5;
                                    class77.method1660(class36.field802[var5]);
                                    continue;
                                 }

                                 if(3202 == var29) {
                                    var5 -= 2;
                                    class111.method2421(class36.field802[var5], class36.field802[1 + var5]);
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 if(var29 < 3400) {
                                    if(var29 == 3300) {
                                       class36.field802[var5++] = client.field335;
                                       continue;
                                    }

                                    class15 var44;
                                    if(3301 == var29) {
                                       var5 -= 2;
                                       var81 = class36.field802[var5];
                                       var16 = class36.field802[1 + var5];
                                       var49 = class36.field802;
                                       var32 = var5++;
                                       var44 = (class15)class15.field204.method3777((long)var81);
                                       if(null == var44) {
                                          var19 = -1;
                                       } else if(var16 >= 0 && var16 < var44.field210.length) {
                                          var19 = var44.field210[var16];
                                       } else {
                                          var19 = -1;
                                       }

                                       var49[var32] = var19;
                                       continue;
                                    }

                                    if(var29 == 3302) {
                                       var5 -= 2;
                                       var81 = class36.field802[var5];
                                       var16 = class36.field802[1 + var5];
                                       class36.field802[var5++] = class20.method554(var81, var16);
                                       continue;
                                    }

                                    if(3303 == var29) {
                                       var5 -= 2;
                                       var81 = class36.field802[var5];
                                       var16 = class36.field802[var5 + 1];
                                       var49 = class36.field802;
                                       var32 = var5++;
                                       var44 = (class15)class15.field204.method3777((long)var81);
                                       if(null == var44) {
                                          var19 = 0;
                                       } else if(var16 == -1) {
                                          var19 = 0;
                                       } else {
                                          var48 = 0;

                                          for(var22 = 0; var22 < var44.field206.length; ++var22) {
                                             if(var44.field210[var22] == var16) {
                                                var48 += var44.field206[var22];
                                             }
                                          }

                                          var19 = var48;
                                       }

                                       var49[var32] = var19;
                                       continue;
                                    }

                                    if(var29 == 3304) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       var34 = class36.field802;
                                       var17 = var5++;
                                       class50 var51 = (class50)class50.field1103.method3743((long)var81);
                                       class50 var42;
                                       if(null != var51) {
                                          var42 = var51;
                                       } else {
                                          byte[] var45 = class50.field1102.method3239(5, var81);
                                          var51 = new class50();
                                          if(var45 != null) {
                                             var51.method984(new class119(var45));
                                          }

                                          class50.field1103.method3745(var51, (long)var81);
                                          var42 = var51;
                                       }

                                       var34[var17] = var42.field1101;
                                       continue;
                                    }

                                    if(3305 == var29) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       class36.field802[var5++] = client.field399[var81];
                                       continue;
                                    }

                                    if(3306 == var29) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       class36.field802[var5++] = client.field415[var81];
                                       continue;
                                    }

                                    if(3307 == var29) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       class36.field802[var5++] = client.field427[var81];
                                       continue;
                                    }

                                    if(var29 == 3308) {
                                       var81 = class21.field581;
                                       var16 = class22.field594 + (class106.field1881.field823 >> 7);
                                       var17 = (class106.field1881.field813 >> 7) + class114.field1981;
                                       class36.field802[var5++] = var17 + (var81 << 28) + (var16 << 14);
                                       continue;
                                    }

                                    if(var29 == 3309) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       class36.field802[var5++] = var81 >> 14 & 16383;
                                       continue;
                                    }

                                    if(3310 == var29) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       class36.field802[var5++] = var81 >> 28;
                                       continue;
                                    }

                                    if(var29 == 3311) {
                                       --var5;
                                       var81 = class36.field802[var5];
                                       class36.field802[var5++] = var81 & 16383;
                                       continue;
                                    }

                                    if(var29 == 3312) {
                                       class36.field802[var5++] = client.field447?1:0;
                                       continue;
                                    }

                                    if(3313 == var29) {
                                       var5 -= 2;
                                       var81 = '耀' + class36.field802[var5];
                                       var16 = class36.field802[var5 + 1];
                                       var49 = class36.field802;
                                       var32 = var5++;
                                       var44 = (class15)class15.field204.method3777((long)var81);
                                       if(null == var44) {
                                          var19 = -1;
                                       } else if(var16 >= 0 && var16 < var44.field210.length) {
                                          var19 = var44.field210[var16];
                                       } else {
                                          var19 = -1;
                                       }

                                       var49[var32] = var19;
                                       continue;
                                    }

                                    if(3314 == var29) {
                                       var5 -= 2;
                                       var81 = class36.field802[var5] + '耀';
                                       var16 = class36.field802[1 + var5];
                                       class36.field802[var5++] = class20.method554(var81, var16);
                                       continue;
                                    }

                                    if(var29 == 3315) {
                                       var5 -= 2;
                                       var81 = class36.field802[var5] + '耀';
                                       var16 = class36.field802[1 + var5];
                                       class36.field802[var5++] = class34.method709(var81, var16);
                                       continue;
                                    }

                                    if(var29 == 3316) {
                                       if(client.field517 >= 2) {
                                          class36.field802[var5++] = client.field517;
                                       } else {
                                          class36.field802[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var29 == 3317) {
                                       class36.field802[var5++] = client.field295;
                                       continue;
                                    }

                                    if(var29 == 3318) {
                                       class36.field802[var5++] = client.field551;
                                       continue;
                                    }

                                    if(var29 == 3321) {
                                       class36.field802[var5++] = client.field301;
                                       continue;
                                    }

                                    if(3322 == var29) {
                                       class36.field802[var5++] = client.field437;
                                       continue;
                                    }

                                    if(var29 == 3323) {
                                       if(client.field502) {
                                          class36.field802[var5++] = 1;
                                       } else {
                                          class36.field802[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(3324 == var29) {
                                       class36.field802[var5++] = client.field279;
                                       continue;
                                    }
                                 } else if(var29 < 3500) {
                                    if(var29 == 3400) {
                                       var5 -= 2;
                                       var81 = class36.field802[var5];
                                       var16 = class36.field802[var5 + 1];
                                       class48 var53 = class84.method1884(var81);
                                       if(115 != var53.field1076) {
                                          ;
                                       }

                                       for(var32 = 0; var32 < var53.field1079; ++var32) {
                                          if(var16 == var53.field1080[var32]) {
                                             class36.field808[var6++] = var53.field1077[var32];
                                             var53 = null;
                                             break;
                                          }
                                       }

                                       if(var53 != null) {
                                          class36.field808[var6++] = var53.field1087;
                                       }
                                       continue;
                                    }

                                    if(var29 == 3408) {
                                       var5 -= 4;
                                       var81 = class36.field802[var5];
                                       var16 = class36.field802[var5 + 1];
                                       var17 = class36.field802[var5 + 2];
                                       var32 = class36.field802[3 + var5];
                                       class48 var61 = class84.method1884(var17);
                                       if(var61.field1075 == var81 && var61.field1076 == var16) {
                                          for(var20 = 0; var20 < var61.field1079; ++var20) {
                                             if(var32 == var61.field1080[var20]) {
                                                if(var16 == 115) {
                                                   class36.field808[var6++] = var61.field1077[var20];
                                                } else {
                                                   class36.field802[var5++] = var61.field1081[var20];
                                                }

                                                var61 = null;
                                                break;
                                             }
                                          }

                                          if(null != var61) {
                                             if(115 == var16) {
                                                class36.field808[var6++] = var61.field1087;
                                             } else {
                                                class36.field802[var5++] = var61.field1078;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var16 == 115) {
                                          class36.field808[var6++] = "null";
                                       } else {
                                          class36.field802[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    int var23;
                                    int var24;
                                    if(var29 < 3700) {
                                       if(var29 == 3600) {
                                          if(client.field544 == 0) {
                                             class36.field802[var5++] = -2;
                                          } else if(1 == client.field544) {
                                             class36.field802[var5++] = -1;
                                          } else {
                                             class36.field802[var5++] = client.field499;
                                          }
                                          continue;
                                       }

                                       if(var29 == 3601) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(client.field544 == 2 && var81 < client.field499) {
                                             class36.field808[var6++] = client.field548[var81].field247;
                                             class36.field808[var6++] = client.field548[var81].field240;
                                             continue;
                                          }

                                          class36.field808[var6++] = "";
                                          class36.field808[var6++] = "";
                                          continue;
                                       }

                                       if(3602 == var29) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(2 == client.field544 && var81 < client.field499) {
                                             class36.field802[var5++] = client.field548[var81].field244;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3603 == var29) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(2 == client.field544 && var81 < client.field499) {
                                             class36.field802[var5++] = client.field548[var81].field237;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3604 == var29) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          --var5;
                                          var16 = class36.field802[var5];
                                          class2.method29(var83, var16);
                                          continue;
                                       }

                                       class17 var58;
                                       String var64;
                                       if(3605 == var29) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          if(null == var83) {
                                             continue;
                                          }

                                          if((client.field499 < 200 || 1 == client.field402) && client.field499 < 400) {
                                             var43 = class32.method690(var83, class1.field24);
                                             if(null == var43) {
                                                continue;
                                             }

                                             for(var17 = 0; var17 < client.field499; ++var17) {
                                                var58 = client.field548[var17];
                                                var64 = class32.method690(var58.field247, class1.field24);
                                                if(null != var64 && var64.equals(var43)) {
                                                   class125.method2783(30, "", var83 + " is already on your friend list");
                                                   continue label4013;
                                                }

                                                if(null != var58.field240) {
                                                   var52 = class32.method690(var58.field240, class1.field24);
                                                   if(null != var52 && var52.equals(var43)) {
                                                      class125.method2783(30, "", var83 + " is already on your friend list");
                                                      continue label4013;
                                                   }
                                                }
                                             }

                                             for(var17 = 0; var17 < client.field550; ++var17) {
                                                class7 var60 = client.field344[var17];
                                                var64 = class32.method690(var60.field133, class1.field24);
                                                if(null != var64 && var64.equals(var43)) {
                                                   class125.method2783(30, "", "Please remove " + var83 + " from your ignore list first");
                                                   continue label4013;
                                                }

                                                if(null != var60.field135) {
                                                   var52 = class32.method690(var60.field135, class1.field24);
                                                   if(var52 != null && var52.equals(var43)) {
                                                      class125.method2783(30, "", "Please remove " + var83 + " from your ignore list first");
                                                      continue label4013;
                                                   }
                                                }
                                             }

                                             if(class32.method690(class106.field1881.field59, class1.field24).equals(var43)) {
                                                class125.method2783(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                client.field322.method2737(130);
                                                client.field322.method2477(class30.method647(var83));
                                                client.field322.method2483(var83);
                                             }
                                             continue;
                                          }

                                          class125.method2783(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var29 == 3606) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          if(null == var83) {
                                             continue;
                                          }

                                          var43 = class32.method690(var83, class1.field24);
                                          if(var43 == null) {
                                             continue;
                                          }

                                          var17 = 0;

                                          while(true) {
                                             if(var17 >= client.field499) {
                                                continue label4013;
                                             }

                                             var58 = client.field548[var17];
                                             var64 = var58.field247;
                                             var52 = class32.method690(var64, class1.field24);
                                             boolean var73;
                                             if(null != var83 && var64 != null) {
                                                if(!var83.startsWith("#") && !var64.startsWith("#")) {
                                                   var73 = var43.equals(var52);
                                                } else {
                                                   var73 = var83.equals(var64);
                                                }
                                             } else {
                                                var73 = false;
                                             }

                                             if(var73) {
                                                --client.field499;

                                                for(var22 = var17; var22 < client.field499; ++var22) {
                                                   client.field548[var22] = client.field548[1 + var22];
                                                }

                                                client.field470 = client.field462;
                                                client.field322.method2737(131);
                                                client.field322.method2477(class30.method647(var83));
                                                client.field322.method2483(var83);
                                                continue label4013;
                                             }

                                             ++var17;
                                          }
                                       }

                                       if(var29 == 3607) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          class1.method6(var83, false);
                                          continue;
                                       }

                                       if(3608 == var29) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          class137.method2895(var83);
                                          continue;
                                       }

                                       if(3609 == var29) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          class152[] var67 = class115.method2441();

                                          for(var17 = 0; var17 < var67.length; ++var17) {
                                             class152 var57 = var67[var17];
                                             if(-1 != var57.field2283 && var83.startsWith(class156.method3146(var57.field2283))) {
                                                var83 = var83.substring(6 + Integer.toString(var57.field2283).length());
                                                break;
                                             }
                                          }

                                          class36.field802[var5++] = class19.method241(var83, false)?1:0;
                                          continue;
                                       }

                                       char var25;
                                       long var50;
                                       String var55;
                                       String[] var94;
                                       if(var29 == 3611) {
                                          if(client.field504 == null) {
                                             class36.field808[var6++] = "";
                                             continue;
                                          }

                                          var94 = class36.field808;
                                          var16 = var6++;
                                          var55 = client.field504;
                                          var50 = 0L;
                                          var23 = var55.length();

                                          for(var24 = 0; var24 < var23; ++var24) {
                                             var50 *= 37L;
                                             var25 = var55.charAt(var24);
                                             if(var25 >= 65 && var25 <= 90) {
                                                var50 += (long)(var25 + 1 - 65);
                                             } else if(var25 >= 97 && var25 <= 122) {
                                                var50 += (long)(var25 + 1 - 97);
                                             } else if(var25 >= 48 && var25 <= 57) {
                                                var50 += (long)(var25 + 27 - 48);
                                             }

                                             if(var50 >= 177917621779460413L) {
                                                break;
                                             }
                                          }

                                          while(var50 % 37L == 0L && 0L != var50) {
                                             var50 /= 37L;
                                          }

                                          var59 = class34.method710(var50);
                                          if(null == var59) {
                                             var59 = "";
                                          }

                                          var94[var16] = var59;
                                          continue;
                                       }

                                       if(3612 == var29) {
                                          if(null != client.field504) {
                                             class36.field802[var5++] = class110.field1959;
                                          } else {
                                             class36.field802[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(3613 == var29) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(null != client.field504 && var81 < class110.field1959) {
                                             class36.field808[var6++] = class159.field2612[var81].field616;
                                             continue;
                                          }

                                          class36.field808[var6++] = "";
                                          continue;
                                       }

                                       if(3614 == var29) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(null != client.field504 && var81 < class110.field1959) {
                                             class36.field802[var5++] = class159.field2612[var81].field618;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3615 == var29) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(client.field504 != null && var81 < class110.field1959) {
                                             class36.field802[var5++] = class159.field2612[var81].field622;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(var29 == 3616) {
                                          class36.field802[var5++] = class33.field779;
                                          continue;
                                       }

                                       if(3617 == var29) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          if(null != class159.field2612) {
                                             client.field322.method2737(50);
                                             client.field322.method2477(class30.method647(var83));
                                             client.field322.method2483(var83);
                                          }
                                          continue;
                                       }

                                       if(3618 == var29) {
                                          class36.field802[var5++] = client.field396;
                                          continue;
                                       }

                                       if(var29 == 3619) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          if(!var83.equals("")) {
                                             client.field322.method2737(21);
                                             client.field322.method2477(class30.method647(var83));
                                             client.field322.method2483(var83);
                                          }
                                          continue;
                                       }

                                       if(var29 == 3620) {
                                          class119.method2694();
                                          continue;
                                       }

                                       if(var29 == 3621) {
                                          if(client.field544 == 0) {
                                             class36.field802[var5++] = -1;
                                          } else {
                                             class36.field802[var5++] = client.field550;
                                          }
                                          continue;
                                       }

                                       if(3622 == var29) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(0 != client.field544 && var81 < client.field550) {
                                             class36.field808[var6++] = client.field344[var81].field133;
                                             class36.field808[var6++] = client.field344[var81].field135;
                                             continue;
                                          }

                                          class36.field808[var6++] = "";
                                          class36.field808[var6++] = "";
                                          continue;
                                       }

                                       if(var29 == 3623) {
                                          --var6;
                                          var83 = class36.field808[var6];
                                          if(var83.startsWith(class156.method3146(0)) || var83.startsWith(class156.method3146(1))) {
                                             var83 = var83.substring(7);
                                          }

                                          class36.field802[var5++] = class16.method196(var83)?1:0;
                                          continue;
                                       }

                                       if(var29 == 3624) {
                                          --var5;
                                          var81 = class36.field802[var5];
                                          if(null != class159.field2612 && var81 < class110.field1959 && class159.field2612[var81].field616.equalsIgnoreCase(class106.field1881.field59)) {
                                             class36.field802[var5++] = 1;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3625 == var29) {
                                          if(client.field416 == null) {
                                             class36.field808[var6++] = "";
                                             continue;
                                          }

                                          var94 = class36.field808;
                                          var16 = var6++;
                                          var55 = client.field416;
                                          var50 = 0L;
                                          var23 = var55.length();

                                          for(var24 = 0; var24 < var23; ++var24) {
                                             var50 *= 37L;
                                             var25 = var55.charAt(var24);
                                             if(var25 >= 65 && var25 <= 90) {
                                                var50 += (long)(var25 + 1 - 65);
                                             } else if(var25 >= 97 && var25 <= 122) {
                                                var50 += (long)(var25 + 1 - 97);
                                             } else if(var25 >= 48 && var25 <= 57) {
                                                var50 += (long)(var25 + 27 - 48);
                                             }

                                             if(var50 >= 177917621779460413L) {
                                                break;
                                             }
                                          }

                                          while(var50 % 37L == 0L && 0L != var50) {
                                             var50 /= 37L;
                                          }

                                          var59 = class34.method710(var50);
                                          if(var59 == null) {
                                             var59 = "";
                                          }

                                          var94[var16] = var59;
                                          continue;
                                       }
                                    } else {
                                       long var66;
                                       if(var29 < 4000) {
                                          if(3903 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var81].method3968();
                                             continue;
                                          }

                                          if(3904 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var81].field3178;
                                             continue;
                                          }

                                          if(3905 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var81].field3176;
                                             continue;
                                          }

                                          if(3906 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var81].field3177;
                                             continue;
                                          }

                                          if(var29 == 3907) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var81].field3174;
                                             continue;
                                          }

                                          if(3908 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var81].field3179;
                                             continue;
                                          }

                                          if(3910 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var16 = client.field388[var81].method3974();
                                             class36.field802[var5++] = 0 == var16?1:0;
                                             continue;
                                          }

                                          if(var29 == 3911) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var16 = client.field388[var81].method3974();
                                             class36.field802[var5++] = 2 == var16?1:0;
                                             continue;
                                          }

                                          if(3912 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var16 = client.field388[var81].method3974();
                                             class36.field802[var5++] = var16 == 5?1:0;
                                             continue;
                                          }

                                          if(var29 == 3913) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var16 = client.field388[var81].method3974();
                                             class36.field802[var5++] = var16 == 1?1:0;
                                             continue;
                                          }

                                          boolean var100;
                                          if(var29 == 3914) {
                                             --var5;
                                             var100 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3182, var100);
                                             }
                                             continue;
                                          }

                                          if(var29 == 3915) {
                                             --var5;
                                             var100 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3185, var100);
                                             }
                                             continue;
                                          }

                                          if(3916 == var29) {
                                             var5 -= 2;
                                             var100 = class36.field802[var5] == 1;
                                             var46 = 1 == class36.field802[1 + var5];
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(new class21(var46), var100);
                                             }
                                             continue;
                                          }

                                          if(var29 == 3917) {
                                             --var5;
                                             var100 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3181, var100);
                                             }
                                             continue;
                                          }

                                          if(var29 == 3918) {
                                             --var5;
                                             var100 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3180, var100);
                                             }
                                             continue;
                                          }

                                          if(3919 == var29) {
                                             class36.field802[var5++] = class37.field871 == null?0:class37.field871.field3183.size();
                                             continue;
                                          }

                                          class214 var72;
                                          if(var29 == 3920) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             class36.field802[var5++] = var72.field3161;
                                             continue;
                                          }

                                          if(var29 == 3921) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             class36.field808[var6++] = var72.method3924();
                                             continue;
                                          }

                                          if(3922 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             class36.field808[var6++] = var72.method3925();
                                             continue;
                                          }

                                          if(3923 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             var66 = class12.method162() - class3.field66 - var72.field3160;
                                             var19 = (int)(var66 / 3600000L);
                                             var20 = (int)((var66 - (long)(3600000 * var19)) / 60000L);
                                             var48 = (int)((var66 - (long)(var19 * 3600000) - (long)(var20 * '\uea60')) / 1000L);
                                             String var54 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var48 / 10 + var48 % 10;
                                             class36.field808[var6++] = var54;
                                             continue;
                                          }

                                          if(3924 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             class36.field802[var5++] = var72.field3159.field3177;
                                             continue;
                                          }

                                          if(3925 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             class36.field802[var5++] = var72.field3159.field3176;
                                             continue;
                                          }

                                          if(3926 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var72 = (class214)class37.field871.field3183.get(var81);
                                             class36.field802[var5++] = var72.field3159.field3178;
                                             continue;
                                          }
                                       } else if(var29 < 4100) {
                                          if(4000 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             class36.field802[var5++] = var16 + var81;
                                             continue;
                                          }

                                          if(4001 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             class36.field802[var5++] = var81 - var16;
                                             continue;
                                          }

                                          if(var29 == 4002) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             class36.field802[var5++] = var81 * var16;
                                             continue;
                                          }

                                          if(4003 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             class36.field802[var5++] = var81 / var16;
                                             continue;
                                          }

                                          if(4004 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = (int)(Math.random() * (double)var81);
                                             continue;
                                          }

                                          if(var29 == 4005) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = (int)(Math.random() * (double)(var81 + 1));
                                             continue;
                                          }

                                          if(4006 == var29) {
                                             var5 -= 5;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             var17 = class36.field802[2 + var5];
                                             var32 = class36.field802[var5 + 3];
                                             var19 = class36.field802[var5 + 4];
                                             class36.field802[var5++] = (var16 - var81) * (var19 - var17) / (var32 - var17) + var81;
                                             continue;
                                          }

                                          if(4007 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             class36.field802[var5++] = var81 + var81 * var16 / 100;
                                             continue;
                                          }

                                          if(4008 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             class36.field802[var5++] = var81 | 1 << var16;
                                             continue;
                                          }

                                          if(4009 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             class36.field802[var5++] = var81 & -1 - (1 << var16);
                                             continue;
                                          }

                                          if(var29 == 4010) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             class36.field802[var5++] = 0 != (var81 & 1 << var16)?1:0;
                                             continue;
                                          }

                                          if(var29 == 4011) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             class36.field802[var5++] = var81 % var16;
                                             continue;
                                          }

                                          if(var29 == 4012) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             if(var81 == 0) {
                                                class36.field802[var5++] = 0;
                                             } else {
                                                class36.field802[var5++] = (int)Math.pow((double)var81, (double)var16);
                                             }
                                             continue;
                                          }

                                          if(4013 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             if(var81 == 0) {
                                                class36.field802[var5++] = 0;
                                             } else if(var16 == 0) {
                                                class36.field802[var5++] = Integer.MAX_VALUE;
                                             } else {
                                                class36.field802[var5++] = (int)Math.pow((double)var81, 1.0D / (double)var16);
                                             }
                                             continue;
                                          }

                                          if(4014 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             class36.field802[var5++] = var81 & var16;
                                             continue;
                                          }

                                          if(4015 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             class36.field802[var5++] = var81 | var16;
                                             continue;
                                          }

                                          if(4018 == var29) {
                                             var5 -= 3;
                                             long var103 = (long)class36.field802[var5];
                                             var66 = (long)class36.field802[var5 + 1];
                                             long var68 = (long)class36.field802[var5 + 2];
                                             class36.field802[var5++] = (int)(var68 * var103 / var66);
                                             continue;
                                          }
                                       } else if(var29 < 4200) {
                                          if(var29 == 4100) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             --var5;
                                             var16 = class36.field802[var5];
                                             class36.field808[var6++] = var83 + var16;
                                             continue;
                                          }

                                          if(var29 == 4101) {
                                             var6 -= 2;
                                             var83 = class36.field808[var6];
                                             var43 = class36.field808[var6 + 1];
                                             class36.field808[var6++] = var83 + var43;
                                             continue;
                                          }

                                          if(4102 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             --var5;
                                             var16 = class36.field802[var5];
                                             class36.field808[var6++] = var83 + class42.method874(var16, true);
                                             continue;
                                          }

                                          if(var29 == 4103) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             class36.field808[var6++] = var83.toLowerCase();
                                             continue;
                                          }

                                          if(var29 == 4104) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             long var93 = (11745L + (long)var81) * 86400000L;
                                             class36.field806.setTime(new Date(var93));
                                             var32 = class36.field806.get(5);
                                             var19 = class36.field806.get(2);
                                             var20 = class36.field806.get(1);
                                             class36.field808[var6++] = var32 + "-" + class36.field807[var19] + "-" + var20;
                                             continue;
                                          }

                                          if(4105 == var29) {
                                             var6 -= 2;
                                             var83 = class36.field808[var6];
                                             var43 = class36.field808[var6 + 1];
                                             if(class106.field1881.field34 != null && class106.field1881.field34.field2936) {
                                                class36.field808[var6++] = var43;
                                                continue;
                                             }

                                             class36.field808[var6++] = var83;
                                             continue;
                                          }

                                          if(var29 == 4106) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field808[var6++] = Integer.toString(var81);
                                             continue;
                                          }

                                          if(4107 == var29) {
                                             var6 -= 2;
                                             var104 = class36.field802;
                                             var16 = var5++;
                                             var32 = class164.method3215(class36.field808[var6], class36.field808[var6 + 1], client.field285);
                                             if(var32 > 0) {
                                                var79 = 1;
                                             } else if(var32 < 0) {
                                                var79 = -1;
                                             } else {
                                                var79 = 0;
                                             }

                                             var104[var16] = var79;
                                             continue;
                                          }

                                          class224 var74;
                                          if(4108 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             var5 -= 2;
                                             var16 = class36.field802[var5];
                                             var17 = class36.field802[1 + var5];
                                             var71 = class8.field147.method3239(var17, 0);
                                             var74 = new class224(var71);
                                             class36.field802[var5++] = var74.method4000(var83, var16);
                                             continue;
                                          }

                                          if(4109 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             var5 -= 2;
                                             var16 = class36.field802[var5];
                                             var17 = class36.field802[var5 + 1];
                                             var71 = class8.field147.method3239(var17, 0);
                                             var74 = new class224(var71);
                                             class36.field802[var5++] = var74.method4023(var83, var16);
                                             continue;
                                          }

                                          if(4110 == var29) {
                                             var6 -= 2;
                                             var83 = class36.field808[var6];
                                             var43 = class36.field808[1 + var6];
                                             --var5;
                                             if(class36.field802[var5] == 1) {
                                                class36.field808[var6++] = var83;
                                             } else {
                                                class36.field808[var6++] = var43;
                                             }
                                             continue;
                                          }

                                          if(4111 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             class36.field808[var6++] = class223.method4001(var83);
                                             continue;
                                          }

                                          if(4112 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             --var5;
                                             var16 = class36.field802[var5];
                                             class36.field808[var6++] = var83 + (char)var16;
                                             continue;
                                          }

                                          char var70;
                                          if(4113 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var34 = class36.field802;
                                             var17 = var5++;
                                             var70 = (char)var81;
                                             if(var70 >= 32 && var70 <= 126) {
                                                var65 = true;
                                             } else if(var70 >= 160 && var70 <= 255) {
                                                var65 = true;
                                             } else if(8364 != var70 && var70 != 338 && 8212 != var70 && 339 != var70 && var70 != 376) {
                                                var65 = false;
                                             } else {
                                                var65 = true;
                                             }

                                             var34[var17] = var65?1:0;
                                             continue;
                                          }

                                          if(var29 == 4114) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class33.method694((char)var81)?1:0;
                                             continue;
                                          }

                                          if(var29 == 4115) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var34 = class36.field802;
                                             var17 = var5++;
                                             var70 = (char)var81;
                                             var65 = var70 >= 65 && var70 <= 90 || var70 >= 97 && var70 <= 122;
                                             var34[var17] = var65?1:0;
                                             continue;
                                          }

                                          if(4116 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var34 = class36.field802;
                                             var17 = var5++;
                                             var70 = (char)var81;
                                             var65 = var70 >= 48 && var70 <= 57;
                                             var34[var17] = var65?1:0;
                                             continue;
                                          }

                                          if(var29 == 4117) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             if(var83 != null) {
                                                class36.field802[var5++] = var83.length();
                                             } else {
                                                class36.field802[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(4118 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             var5 -= 2;
                                             var16 = class36.field802[var5];
                                             var17 = class36.field802[var5 + 1];
                                             class36.field808[var6++] = var83.substring(var16, var17);
                                             continue;
                                          }

                                          if(4119 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             StringBuilder var89 = new StringBuilder(var83.length());
                                             var69 = false;

                                             for(var32 = 0; var32 < var83.length(); ++var32) {
                                                var70 = var83.charAt(var32);
                                                if(var70 == 60) {
                                                   var69 = true;
                                                } else if(var70 == 62) {
                                                   var69 = false;
                                                } else if(!var69) {
                                                   var89.append(var70);
                                                }
                                             }

                                             class36.field808[var6++] = var89.toString();
                                             continue;
                                          }

                                          if(4120 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             --var5;
                                             var16 = class36.field802[var5];
                                             class36.field802[var5++] = var83.indexOf(var16);
                                             continue;
                                          }

                                          if(var29 == 4121) {
                                             var6 -= 2;
                                             var83 = class36.field808[var6];
                                             var43 = class36.field808[var6 + 1];
                                             --var5;
                                             var17 = class36.field802[var5];
                                             class36.field802[var5++] = var83.indexOf(var43, var17);
                                             continue;
                                          }
                                       } else if(var29 < 4300) {
                                          if(var29 == 4200) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field808[var6++] = class9.method128(var81).field1128;
                                             continue;
                                          }

                                          class51 var82;
                                          if(var29 == 4201) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[1 + var5];
                                             var82 = class9.method128(var81);
                                             if(var16 >= 1 && var16 <= 5 && var82.field1130[var16 - 1] != null) {
                                                class36.field808[var6++] = var82.field1130[var16 - 1];
                                                continue;
                                             }

                                             class36.field808[var6++] = "";
                                             continue;
                                          }

                                          if(var29 == 4202) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             var82 = class9.method128(var81);
                                             if(var16 >= 1 && var16 <= 5 && var82.field1124[var16 - 1] != null) {
                                                class36.field808[var6++] = var82.field1124[var16 - 1];
                                                continue;
                                             }

                                             class36.field808[var6++] = "";
                                             continue;
                                          }

                                          if(4203 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class9.method128(var81).field1111;
                                             continue;
                                          }

                                          if(4204 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class9.method128(var81).field1127 == 1?1:0;
                                             continue;
                                          }

                                          class51 var95;
                                          if(4205 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var95 = class9.method128(var81);
                                             if(var95.field1147 == -1 && var95.field1146 >= 0) {
                                                class36.field802[var5++] = var95.field1146;
                                                continue;
                                             }

                                             class36.field802[var5++] = var81;
                                             continue;
                                          }

                                          if(4206 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var95 = class9.method128(var81);
                                             if(var95.field1147 >= 0 && var95.field1146 >= 0) {
                                                class36.field802[var5++] = var95.field1146;
                                                continue;
                                             }

                                             class36.field802[var5++] = var81;
                                             continue;
                                          }

                                          if(var29 == 4207) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class9.method128(var81).field1129?1:0;
                                             continue;
                                          }

                                          if(4208 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var95 = class9.method128(var81);
                                             if(-1 == var95.field1109 && var95.field1157 >= 0) {
                                                class36.field802[var5++] = var95.field1157;
                                                continue;
                                             }

                                             class36.field802[var5++] = var81;
                                             continue;
                                          }

                                          if(var29 == 4209) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             var95 = class9.method128(var81);
                                             if(var95.field1109 >= 0 && var95.field1157 >= 0) {
                                                class36.field802[var5++] = var95.field1157;
                                                continue;
                                             }

                                             class36.field802[var5++] = var81;
                                             continue;
                                          }

                                          if(4210 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             --var5;
                                             var16 = class36.field802[var5];
                                             class41.method836(var83, 1 == var16);
                                             class36.field802[var5++] = class5.field95;
                                             continue;
                                          }

                                          if(var29 == 4211) {
                                             if(null != class37.field873 && class48.field1083 < class5.field95) {
                                                class36.field802[var5++] = class37.field873[++class48.field1083 - 1] & '\uffff';
                                                continue;
                                             }

                                             class36.field802[var5++] = -1;
                                             continue;
                                          }

                                          if(4212 == var29) {
                                             class48.field1083 = 0;
                                             continue;
                                          }
                                       } else if(var29 < 5100) {
                                          if(5000 == var29) {
                                             class36.field802[var5++] = client.field495;
                                             continue;
                                          }

                                          if(var29 == 5001) {
                                             var5 -= 3;
                                             client.field495 = class36.field802[var5];
                                             class75.field1377 = class32.method689(class36.field802[var5 + 1]);
                                             if(class75.field1377 == null) {
                                                class75.field1377 = class130.field2069;
                                             }

                                             client.field292 = class36.field802[var5 + 2];
                                             client.field322.method2737(189);
                                             client.field322.method2477(client.field495);
                                             client.field322.method2477(class75.field1377.field2073);
                                             client.field322.method2477(client.field292);
                                             continue;
                                          }

                                          if(5002 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             var5 -= 2;
                                             var16 = class36.field802[var5];
                                             var17 = class36.field802[var5 + 1];
                                             client.field322.method2737(66);
                                             client.field322.method2477(class30.method647(var83) + 2);
                                             client.field322.method2483(var83);
                                             client.field322.method2477(var16 - 1);
                                             client.field322.method2477(var17);
                                             continue;
                                          }

                                          if(5003 == var29) {
                                             var5 -= 2;
                                             var81 = class36.field802[var5];
                                             var16 = class36.field802[var5 + 1];
                                             class35 var84 = class27.method630(var81, var16);
                                             if(var84 != null) {
                                                class36.field802[var5++] = var84.field789;
                                                class36.field802[var5++] = var84.field790;
                                                class36.field808[var6++] = null != var84.field795?var84.field795:"";
                                                class36.field808[var6++] = null != var84.field786?var84.field786:"";
                                                class36.field808[var6++] = null != var84.field791?var84.field791:"";
                                             } else {
                                                class36.field802[var5++] = -1;
                                                class36.field802[var5++] = 0;
                                                class36.field808[var6++] = "";
                                                class36.field808[var6++] = "";
                                                class36.field808[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var29 == 5004) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class35 var96 = class107.method2372(var81);
                                             if(var96 != null) {
                                                class36.field802[var5++] = var96.field787;
                                                class36.field802[var5++] = var96.field790;
                                                class36.field808[var6++] = var96.field795 != null?var96.field795:"";
                                                class36.field808[var6++] = var96.field786 != null?var96.field786:"";
                                                class36.field808[var6++] = null != var96.field791?var96.field791:"";
                                             } else {
                                                class36.field802[var5++] = -1;
                                                class36.field802[var5++] = 0;
                                                class36.field808[var6++] = "";
                                                class36.field808[var6++] = "";
                                                class36.field808[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var29 == 5005) {
                                             if(null == class75.field1377) {
                                                class36.field802[var5++] = -1;
                                             } else {
                                                class36.field802[var5++] = class75.field1377.field2073;
                                             }
                                             continue;
                                          }

                                          if(5008 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             --var5;
                                             var16 = class36.field802[var5];
                                             var31 = var83.toLowerCase();
                                             byte var77 = 0;
                                             if(var31.startsWith("yellow:")) {
                                                var77 = 0;
                                                var83 = var83.substring("yellow:".length());
                                             } else if(var31.startsWith("red:")) {
                                                var77 = 1;
                                                var83 = var83.substring("red:".length());
                                             } else if(var31.startsWith("green:")) {
                                                var77 = 2;
                                                var83 = var83.substring("green:".length());
                                             } else if(var31.startsWith("cyan:")) {
                                                var77 = 3;
                                                var83 = var83.substring("cyan:".length());
                                             } else if(var31.startsWith("purple:")) {
                                                var77 = 4;
                                                var83 = var83.substring("purple:".length());
                                             } else if(var31.startsWith("white:")) {
                                                var77 = 5;
                                                var83 = var83.substring("white:".length());
                                             } else if(var31.startsWith("flash1:")) {
                                                var77 = 6;
                                                var83 = var83.substring("flash1:".length());
                                             } else if(var31.startsWith("flash2:")) {
                                                var77 = 7;
                                                var83 = var83.substring("flash2:".length());
                                             } else if(var31.startsWith("flash3:")) {
                                                var77 = 8;
                                                var83 = var83.substring("flash3:".length());
                                             } else if(var31.startsWith("glow1:")) {
                                                var77 = 9;
                                                var83 = var83.substring("glow1:".length());
                                             } else if(var31.startsWith("glow2:")) {
                                                var77 = 10;
                                                var83 = var83.substring("glow2:".length());
                                             } else if(var31.startsWith("glow3:")) {
                                                var77 = 11;
                                                var83 = var83.substring("glow3:".length());
                                             } else if(client.field285 != 0) {
                                                if(var31.startsWith("yellow:")) {
                                                   var77 = 0;
                                                   var83 = var83.substring("yellow:".length());
                                                } else if(var31.startsWith("red:")) {
                                                   var77 = 1;
                                                   var83 = var83.substring("red:".length());
                                                } else if(var31.startsWith("green:")) {
                                                   var77 = 2;
                                                   var83 = var83.substring("green:".length());
                                                } else if(var31.startsWith("cyan:")) {
                                                   var77 = 3;
                                                   var83 = var83.substring("cyan:".length());
                                                } else if(var31.startsWith("purple:")) {
                                                   var77 = 4;
                                                   var83 = var83.substring("purple:".length());
                                                } else if(var31.startsWith("white:")) {
                                                   var77 = 5;
                                                   var83 = var83.substring("white:".length());
                                                } else if(var31.startsWith("flash1:")) {
                                                   var77 = 6;
                                                   var83 = var83.substring("flash1:".length());
                                                } else if(var31.startsWith("flash2:")) {
                                                   var77 = 7;
                                                   var83 = var83.substring("flash2:".length());
                                                } else if(var31.startsWith("flash3:")) {
                                                   var77 = 8;
                                                   var83 = var83.substring("flash3:".length());
                                                } else if(var31.startsWith("glow1:")) {
                                                   var77 = 9;
                                                   var83 = var83.substring("glow1:".length());
                                                } else if(var31.startsWith("glow2:")) {
                                                   var77 = 10;
                                                   var83 = var83.substring("glow2:".length());
                                                } else if(var31.startsWith("glow3:")) {
                                                   var77 = 11;
                                                   var83 = var83.substring("glow3:".length());
                                                }
                                             }

                                             var31 = var83.toLowerCase();
                                             byte var78 = 0;
                                             if(var31.startsWith("wave:")) {
                                                var78 = 1;
                                                var83 = var83.substring("wave:".length());
                                             } else if(var31.startsWith("wave2:")) {
                                                var78 = 2;
                                                var83 = var83.substring("wave2:".length());
                                             } else if(var31.startsWith("shake:")) {
                                                var78 = 3;
                                                var83 = var83.substring("shake:".length());
                                             } else if(var31.startsWith("scroll:")) {
                                                var78 = 4;
                                                var83 = var83.substring("scroll:".length());
                                             } else if(var31.startsWith("slide:")) {
                                                var78 = 5;
                                                var83 = var83.substring("slide:".length());
                                             } else if(client.field285 != 0) {
                                                if(var31.startsWith("wave:")) {
                                                   var78 = 1;
                                                   var83 = var83.substring("wave:".length());
                                                } else if(var31.startsWith("wave2:")) {
                                                   var78 = 2;
                                                   var83 = var83.substring("wave2:".length());
                                                } else if(var31.startsWith("shake:")) {
                                                   var78 = 3;
                                                   var83 = var83.substring("shake:".length());
                                                } else if(var31.startsWith("scroll:")) {
                                                   var78 = 4;
                                                   var83 = var83.substring("scroll:".length());
                                                } else if(var31.startsWith("slide:")) {
                                                   var78 = 5;
                                                   var83 = var83.substring("slide:".length());
                                                }
                                             }

                                             client.field322.method2737(201);
                                             client.field322.method2477(0);
                                             var20 = client.field322.field2005;
                                             client.field322.method2477(var16);
                                             client.field322.method2477(var77);
                                             client.field322.method2477(var78);
                                             class122 var80 = client.field322;
                                             var22 = var80.field2005;
                                             var24 = var83.length();
                                             byte[] var63 = new byte[var24];

                                             for(int var26 = 0; var26 < var24; ++var26) {
                                                char var27 = var83.charAt(var26);
                                                if((var27 <= 0 || var27 >= 128) && (var27 < 160 || var27 > 255)) {
                                                   if(8364 == var27) {
                                                      var63[var26] = -128;
                                                   } else if(var27 == 8218) {
                                                      var63[var26] = -126;
                                                   } else if(var27 == 402) {
                                                      var63[var26] = -125;
                                                   } else if(var27 == 8222) {
                                                      var63[var26] = -124;
                                                   } else if(var27 == 8230) {
                                                      var63[var26] = -123;
                                                   } else if(8224 == var27) {
                                                      var63[var26] = -122;
                                                   } else if(var27 == 8225) {
                                                      var63[var26] = -121;
                                                   } else if(710 == var27) {
                                                      var63[var26] = -120;
                                                   } else if(8240 == var27) {
                                                      var63[var26] = -119;
                                                   } else if(352 == var27) {
                                                      var63[var26] = -118;
                                                   } else if(var27 == 8249) {
                                                      var63[var26] = -117;
                                                   } else if(var27 == 338) {
                                                      var63[var26] = -116;
                                                   } else if(381 == var27) {
                                                      var63[var26] = -114;
                                                   } else if(var27 == 8216) {
                                                      var63[var26] = -111;
                                                   } else if(var27 == 8217) {
                                                      var63[var26] = -110;
                                                   } else if(var27 == 8220) {
                                                      var63[var26] = -109;
                                                   } else if(8221 == var27) {
                                                      var63[var26] = -108;
                                                   } else if(var27 == 8226) {
                                                      var63[var26] = -107;
                                                   } else if(var27 == 8211) {
                                                      var63[var26] = -106;
                                                   } else if(var27 == 8212) {
                                                      var63[var26] = -105;
                                                   } else if(var27 == 732) {
                                                      var63[var26] = -104;
                                                   } else if(8482 == var27) {
                                                      var63[var26] = -103;
                                                   } else if(353 == var27) {
                                                      var63[var26] = -102;
                                                   } else if(8250 == var27) {
                                                      var63[var26] = -101;
                                                   } else if(339 == var27) {
                                                      var63[var26] = -100;
                                                   } else if(var27 == 382) {
                                                      var63[var26] = -98;
                                                   } else if(var27 == 376) {
                                                      var63[var26] = -97;
                                                   } else {
                                                      var63[var26] = 63;
                                                   }
                                                } else {
                                                   var63[var26] = (byte)var27;
                                                }
                                             }

                                             var80.method2490(var63.length);
                                             var80.field2005 += class222.field3187.method2432(var63, 0, var63.length, var80.field2007, var80.field2005);
                                             client.field322.method2562(client.field322.field2005 - var20);
                                             continue;
                                          }

                                          if(var29 == 5009) {
                                             var6 -= 2;
                                             var83 = class36.field808[var6];
                                             var43 = class36.field808[var6 + 1];
                                             client.field322.method2737(212);
                                             client.field322.method2661(0);
                                             var17 = client.field322.field2005;
                                             client.field322.method2483(var83);
                                             class122 var75 = client.field322;
                                             var19 = var75.field2005;
                                             var48 = var43.length();
                                             byte[] var56 = new byte[var48];

                                             for(var23 = 0; var23 < var48; ++var23) {
                                                char var62 = var43.charAt(var23);
                                                if(var62 > 0 && var62 < 128 || var62 >= 160 && var62 <= 255) {
                                                   var56[var23] = (byte)var62;
                                                } else if(8364 == var62) {
                                                   var56[var23] = -128;
                                                } else if(8218 == var62) {
                                                   var56[var23] = -126;
                                                } else if(var62 == 402) {
                                                   var56[var23] = -125;
                                                } else if(var62 == 8222) {
                                                   var56[var23] = -124;
                                                } else if(var62 == 8230) {
                                                   var56[var23] = -123;
                                                } else if(8224 == var62) {
                                                   var56[var23] = -122;
                                                } else if(8225 == var62) {
                                                   var56[var23] = -121;
                                                } else if(710 == var62) {
                                                   var56[var23] = -120;
                                                } else if(var62 == 8240) {
                                                   var56[var23] = -119;
                                                } else if(352 == var62) {
                                                   var56[var23] = -118;
                                                } else if(8249 == var62) {
                                                   var56[var23] = -117;
                                                } else if(338 == var62) {
                                                   var56[var23] = -116;
                                                } else if(var62 == 381) {
                                                   var56[var23] = -114;
                                                } else if(var62 == 8216) {
                                                   var56[var23] = -111;
                                                } else if(8217 == var62) {
                                                   var56[var23] = -110;
                                                } else if(8220 == var62) {
                                                   var56[var23] = -109;
                                                } else if(var62 == 8221) {
                                                   var56[var23] = -108;
                                                } else if(var62 == 8226) {
                                                   var56[var23] = -107;
                                                } else if(8211 == var62) {
                                                   var56[var23] = -106;
                                                } else if(8212 == var62) {
                                                   var56[var23] = -105;
                                                } else if(var62 == 732) {
                                                   var56[var23] = -104;
                                                } else if(var62 == 8482) {
                                                   var56[var23] = -103;
                                                } else if(var62 == 353) {
                                                   var56[var23] = -102;
                                                } else if(var62 == 8250) {
                                                   var56[var23] = -101;
                                                } else if(var62 == 339) {
                                                   var56[var23] = -100;
                                                } else if(382 == var62) {
                                                   var56[var23] = -98;
                                                } else if(376 == var62) {
                                                   var56[var23] = -97;
                                                } else {
                                                   var56[var23] = 63;
                                                }
                                             }

                                             var75.method2490(var56.length);
                                             var75.field2005 += class222.field3187.method2432(var56, 0, var56.length, var75.field2007, var75.field2005);
                                             client.field322.method2524(client.field322.field2005 - var17);
                                             continue;
                                          }

                                          if(var29 == 5015) {
                                             if(class106.field1881 != null && class106.field1881.field59 != null) {
                                                var83 = class106.field1881.field59;
                                             } else {
                                                var83 = "";
                                             }

                                             class36.field808[var6++] = var83;
                                             continue;
                                          }

                                          if(var29 == 5016) {
                                             class36.field802[var5++] = client.field292;
                                             continue;
                                          }

                                          if(5017 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class184.method3594(var81);
                                             continue;
                                          }

                                          if(var29 == 5018) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class72.method1551(var81);
                                             continue;
                                          }

                                          if(5019 == var29) {
                                             --var5;
                                             var81 = class36.field802[var5];
                                             class36.field802[var5++] = class124.method2782(var81);
                                             continue;
                                          }

                                          if(5020 == var29) {
                                             --var6;
                                             var83 = class36.field808[var6];
                                             if(var83.equalsIgnoreCase("toggleroof")) {
                                                class76.field1388.field148 = !class76.field1388.field148;
                                                class7.method101();
                                                if(class76.field1388.field148) {
                                                   class125.method2783(99, "", "Roofs are now all hidden");
                                                } else {
                                                   class125.method2783(99, "", "Roofs will only be removed selectively");
                                                }
                                             }

                                             if(var83.equalsIgnoreCase("displayfps")) {
                                                client.field282 = !client.field282;
                                             }

                                             if(client.field517 >= 2) {
                                                if(var83.equalsIgnoreCase("fpson")) {
                                                   client.field282 = true;
                                                }

                                                if(var83.equalsIgnoreCase("fpsoff")) {
                                                   client.field282 = false;
                                                }

                                                if(var83.equalsIgnoreCase("gc")) {
                                                   System.gc();
                                                }

                                                if(var83.equalsIgnoreCase("clientdrop")) {
                                                   class115.method2442();
                                                }

                                                if(var83.equalsIgnoreCase("errortest") && client.field281 == 2) {
                                                   throw new RuntimeException();
                                                }
                                             }

                                             client.field322.method2737(146);
                                             client.field322.method2477(var83.length() + 1);
                                             client.field322.method2483(var83);
                                             continue;
                                          }

                                          if(var29 == 5021) {
                                             --var6;
                                             client.field393 = class36.field808[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var29 == 5022) {
                                             class36.field808[var6++] = client.field393;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var29 >= 2000) {
                                 var29 -= 1000;
                                 --var5;
                                 var15 = class29.method645(class36.field802[var5]);
                              } else {
                                 var15 = var47?class141.field2173:class12.field185;
                              }

                              if(1927 == var29) {
                                 if(class36.field810 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var15.field2874) {
                                    return;
                                 }

                                 class0 var35 = new class0();
                                 var35.field8 = var15;
                                 var35.field12 = var15.field2874;
                                 var35.field2 = 1 + class36.field810;
                                 client.field283.method3807(var0);
                                 continue;
                              }
                           }
                        } else {
                           if(var29 >= 2000) {
                              var29 -= 1000;
                              --var5;
                              var15 = class29.method645(class36.field802[var5]);
                           } else {
                              var15 = var47?class141.field2173:class12.field185;
                           }

                           if(1300 == var29) {
                              --var5;
                              var16 = class36.field802[var5] - 1;
                              if(var16 >= 0 && var16 <= 9) {
                                 --var6;
                                 var15.method3377(var16, class36.field808[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var29 == 1301) {
                              var5 -= 2;
                              var16 = class36.field802[var5];
                              var17 = class36.field802[1 + var5];
                              var15.field2871 = class45.method932(var16, var17);
                              continue;
                           }

                           if(1302 == var29) {
                              --var5;
                              var15.field2856 = class36.field802[var5] == 1;
                              continue;
                           }

                           if(var29 == 1303) {
                              --var5;
                              var15.field2841 = class36.field802[var5];
                              continue;
                           }

                           if(var29 == 1304) {
                              --var5;
                              var15.field2842 = class36.field802[var5];
                              continue;
                           }

                           if(var29 == 1305) {
                              --var6;
                              var15.field2789 = class36.field808[var6];
                              continue;
                           }

                           if(var29 == 1306) {
                              --var6;
                              var15.field2844 = class36.field808[var6];
                              continue;
                           }

                           if(1307 == var29) {
                              var15.field2839 = null;
                              continue;
                           }
                        }
                     } else {
                        if(var29 >= 2000) {
                           var29 -= 1000;
                           --var5;
                           var15 = class29.method645(class36.field802[var5]);
                        } else {
                           var15 = var47?class141.field2173:class12.field185;
                        }

                        class34.method701(var15);
                        if(1200 == var29 || 1205 == var29 || var29 == 1212) {
                           var5 -= 2;
                           var16 = class36.field802[var5];
                           var17 = class36.field802[var5 + 1];
                           var15.field2885 = var16;
                           var15.field2780 = var17;
                           class51 var33 = class9.method128(var16);
                           var15.field2816 = var33.field1122;
                           var15.field2817 = var33.field1123;
                           var15.field2818 = var33.field1126;
                           var15.field2859 = var33.field1125;
                           var15.field2815 = var33.field1138;
                           var15.field2819 = var33.field1121;
                           if(1205 == var29) {
                              var15.field2823 = 0;
                           } else if(var29 == 1212 | 1 == var33.field1127) {
                              var15.field2823 = 1;
                           } else {
                              var15.field2823 = 2;
                           }

                           if(var15.field2820 > 0) {
                              var15.field2819 = var15.field2819 * 32 / var15.field2820;
                           } else if(var15.field2776 > 0) {
                              var15.field2819 = var15.field2819 * 32 / var15.field2776;
                           }
                           continue;
                        }

                        if(1201 == var29) {
                           var15.field2788 = 2;
                           --var5;
                           var15.field2830 = class36.field802[var5];
                           continue;
                        }

                        if(1202 == var29) {
                           var15.field2788 = 3;
                           var15.field2830 = class106.field1881.field34.method3491();
                           continue;
                        }
                     }
                  } else {
                     var16 = -1;
                     if(var29 >= 2000) {
                        var29 -= 1000;
                        --var5;
                        var16 = class36.field802[var5];
                        var15 = class29.method645(var16);
                     } else {
                        var15 = var47?class141.field2173:class12.field185;
                     }

                     if(var29 == 1100) {
                        var5 -= 2;
                        var15.field2786 = class36.field802[var5];
                        if(var15.field2786 > var15.field2848 - var15.field2886) {
                           var15.field2786 = var15.field2848 - var15.field2886;
                        }

                        if(var15.field2786 < 0) {
                           var15.field2786 = 0;
                        }

                        var15.field2787 = class36.field802[var5 + 1];
                        if(var15.field2787 > var15.field2858 - var15.field2781) {
                           var15.field2787 = var15.field2858 - var15.field2781;
                        }

                        if(var15.field2787 < 0) {
                           var15.field2787 = 0;
                        }

                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1101) {
                        --var5;
                        var15.field2790 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1102) {
                        --var5;
                        var15.field2794 = class36.field802[var5] == 1;
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1103) {
                        --var5;
                        var15.field2796 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1104) {
                        --var5;
                        var15.field2798 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(1105 == var29) {
                        --var5;
                        var15.field2890 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1106) {
                        --var5;
                        var15.field2802 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1107) {
                        --var5;
                        var15.field2803 = class36.field802[var5] == 1;
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1108) {
                        var15.field2788 = 1;
                        --var5;
                        var15.field2830 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1109) {
                        var5 -= 6;
                        var15.field2859 = class36.field802[var5];
                        var15.field2815 = class36.field802[var5 + 1];
                        var15.field2816 = class36.field802[2 + var5];
                        var15.field2817 = class36.field802[var5 + 3];
                        var15.field2818 = class36.field802[4 + var5];
                        var15.field2819 = class36.field802[var5 + 5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1110) {
                        --var5;
                        var17 = class36.field802[var5];
                        if(var17 != var15.field2812) {
                           var15.field2812 = var17;
                           var15.field2834 = 0;
                           var15.field2754 = 0;
                           class34.method701(var15);
                        }
                        continue;
                     }

                     if(var29 == 1111) {
                        --var5;
                        var15.field2822 = class36.field802[var5] == 1;
                        class34.method701(var15);
                        continue;
                     }

                     if(1112 == var29) {
                        --var6;
                        var31 = class36.field808[var6];
                        if(!var31.equals(var15.field2825)) {
                           var15.field2825 = var31;
                           class34.method701(var15);
                        }
                        continue;
                     }

                     if(1113 == var29) {
                        --var5;
                        var15.field2824 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(1114 == var29) {
                        var5 -= 3;
                        var15.field2828 = class36.field802[var5];
                        var15.field2829 = class36.field802[1 + var5];
                        var15.field2899 = class36.field802[var5 + 2];
                        class34.method701(var15);
                        continue;
                     }

                     if(1115 == var29) {
                        --var5;
                        var15.field2769 = class36.field802[var5] == 1;
                        class34.method701(var15);
                        continue;
                     }

                     if(1116 == var29) {
                        --var5;
                        var15.field2804 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(1117 == var29) {
                        --var5;
                        var15.field2805 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(1118 == var29) {
                        --var5;
                        var15.field2840 = class36.field802[var5] == 1;
                        class34.method701(var15);
                        continue;
                     }

                     if(1119 == var29) {
                        --var5;
                        var15.field2807 = class36.field802[var5] == 1;
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1120) {
                        var5 -= 2;
                        var15.field2848 = class36.field802[var5];
                        var15.field2858 = class36.field802[1 + var5];
                        class34.method701(var15);
                        if(-1 != var16 && var15.field2767 == 0) {
                           class125.method2796(class217.field3171[var16 >> 16], var15, false);
                        }
                        continue;
                     }

                     if(var29 == 1121) {
                        var17 = var15.field2826;
                        var32 = var15.field2766;
                        client.field322.method2737(99);
                        client.field322.method2661(var32);
                        client.field322.method2531(var17);
                        client.field441 = var15;
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1122) {
                        --var5;
                        var15.field2801 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1123) {
                        --var5;
                        var15.field2791 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1124) {
                        --var5;
                        var15.field2833 = class36.field802[var5];
                        class34.method701(var15);
                        continue;
                     }

                     if(var29 == 1125) {
                        --var5;
                        var17 = class36.field802[var5];
                        class82 var18 = (class82)class75.method1616(class38.method735(), var17);
                        if(null != var18) {
                           var15.field2795 = var18;
                           class34.method701(var15);
                        }
                        continue;
                     }
                  }
               }

               if(var29 < 5400) {
                  if(var29 == 5306) {
                     var104 = class36.field802;
                     var16 = var5++;
                     var17 = client.field336?2:1;
                     var104[var16] = var17;
                     continue;
                  }

                  if(var29 == 5307) {
                     --var5;
                     var81 = class36.field802[var5];
                     if(var81 == 1 || 2 == var81) {
                        class9.method127(var81);
                     }
                     continue;
                  }

                  if(var29 == 5308) {
                     class36.field802[var5++] = class76.field1388.field144;
                     continue;
                  }

                  if(5309 == var29) {
                     --var5;
                     var81 = class36.field802[var5];
                     if(var81 == 1 || var81 == 2) {
                        class76.field1388.field144 = var81;
                        class7.method101();
                     }
                     continue;
                  }
               }

               if(var29 < 5600) {
                  if(var29 == 5504) {
                     var5 -= 2;
                     var81 = class36.field802[var5];
                     var16 = class36.field802[var5 + 1];
                     if(!client.field558) {
                        client.field363 = var81;
                        client.field364 = var16;
                     }
                     continue;
                  }

                  if(5505 == var29) {
                     class36.field802[var5++] = client.field363;
                     continue;
                  }

                  if(5506 == var29) {
                     class36.field802[var5++] = client.field364;
                     continue;
                  }

                  if(var29 == 5530) {
                     --var5;
                     var81 = class36.field802[var5];
                     if(var81 < 0) {
                        var81 = 0;
                     }

                     client.field369 = var81;
                     continue;
                  }

                  if(var29 == 5531) {
                     class36.field802[var5++] = client.field369;
                     continue;
                  }
               }

               if(var29 < 5700 && 5630 == var29) {
                  client.field332 = 250;
               } else {
                  if(var29 < 6300) {
                     if(var29 == 6200) {
                        var5 -= 2;
                        client.field554 = (short)class36.field802[var5];
                        if(client.field554 <= 0) {
                           client.field554 = 256;
                        }

                        client.field534 = (short)class36.field802[var5 + 1];
                        if(client.field534 <= 0) {
                           client.field534 = 205;
                        }
                        continue;
                     }

                     if(6201 == var29) {
                        var5 -= 2;
                        client.field533 = (short)class36.field802[var5];
                        if(client.field533 <= 0) {
                           client.field533 = 256;
                        }

                        client.field536 = (short)class36.field802[1 + var5];
                        if(client.field536 <= 0) {
                           client.field536 = 320;
                        }
                        continue;
                     }

                     if(6202 == var29) {
                        var5 -= 4;
                        client.field323 = (short)class36.field802[var5];
                        if(client.field323 <= 0) {
                           client.field323 = 1;
                        }

                        client.field538 = (short)class36.field802[1 + var5];
                        if(client.field538 <= 0) {
                           client.field538 = 32767;
                        } else if(client.field538 < client.field323) {
                           client.field538 = client.field323;
                        }

                        client.field401 = (short)class36.field802[var5 + 2];
                        if(client.field401 <= 0) {
                           client.field401 = 1;
                        }

                        client.field540 = (short)class36.field802[3 + var5];
                        if(client.field540 <= 0) {
                           client.field540 = 32767;
                        } else if(client.field540 < client.field401) {
                           client.field540 = client.field401;
                        }
                        continue;
                     }

                     if(var29 == 6203) {
                        if(null != client.field449) {
                           class11.method137(0, 0, client.field449.field2886, client.field449.field2781, false);
                           class36.field802[var5++] = client.field472;
                           class36.field802[var5++] = client.field383;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = -1;
                        }
                        continue;
                     }

                     if(6204 == var29) {
                        class36.field802[var5++] = client.field533;
                        class36.field802[var5++] = client.field536;
                        continue;
                     }

                     if(6205 == var29) {
                        class36.field802[var5++] = client.field554;
                        class36.field802[var5++] = client.field534;
                        continue;
                     }
                  }

                  if(var29 < 6600) {
                     if(var29 == 6500) {
                        class36.field802[var5++] = class38.method734()?1:0;
                        continue;
                     }

                     class25 var105;
                     if(var29 == 6501) {
                        class25.field629 = 0;
                        var105 = class56.method1203();
                        if(null != var105) {
                           class36.field802[var5++] = var105.field632;
                           class36.field802[var5++] = var105.field633;
                           class36.field808[var6++] = var105.field641;
                           class36.field802[var5++] = var105.field637;
                           class36.field802[var5++] = var105.field634;
                           class36.field808[var6++] = var105.field635;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = 0;
                           class36.field808[var6++] = "";
                           class36.field802[var5++] = 0;
                           class36.field802[var5++] = 0;
                           class36.field808[var6++] = "";
                        }
                        continue;
                     }

                     if(var29 == 6502) {
                        var105 = class56.method1203();
                        if(var105 != null) {
                           class36.field802[var5++] = var105.field632;
                           class36.field802[var5++] = var105.field633;
                           class36.field808[var6++] = var105.field641;
                           class36.field802[var5++] = var105.field637;
                           class36.field802[var5++] = var105.field634;
                           class36.field808[var6++] = var105.field635;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = 0;
                           class36.field808[var6++] = "";
                           class36.field802[var5++] = 0;
                           class36.field802[var5++] = 0;
                           class36.field808[var6++] = "";
                        }
                        continue;
                     }

                     class25 var98;
                     if(var29 == 6506) {
                        --var5;
                        var81 = class36.field802[var5];
                        var98 = null;

                        for(var17 = 0; var17 < class25.field628; ++var17) {
                           if(class25.field636[var17].field632 == var81) {
                              var98 = class25.field636[var17];
                              break;
                           }
                        }

                        if(null != var98) {
                           class36.field802[var5++] = var98.field632;
                           class36.field802[var5++] = var98.field633;
                           class36.field808[var6++] = var98.field641;
                           class36.field802[var5++] = var98.field637;
                           class36.field802[var5++] = var98.field634;
                           class36.field808[var6++] = var98.field635;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = 0;
                           class36.field808[var6++] = "";
                           class36.field802[var5++] = 0;
                           class36.field802[var5++] = 0;
                           class36.field808[var6++] = "";
                        }
                        continue;
                     }

                     if(var29 == 6507) {
                        var5 -= 4;
                        var81 = class36.field802[var5];
                        var46 = 1 == class36.field802[var5 + 1];
                        var17 = class36.field802[2 + var5];
                        var65 = 1 == class36.field802[3 + var5];
                        class77.method1662(var81, var46, var17, var65);
                        continue;
                     }

                     if(6511 == var29) {
                        --var5;
                        var81 = class36.field802[var5];
                        if(var81 >= 0 && var81 < class25.field628) {
                           var98 = class25.field636[var81];
                           class36.field802[var5++] = var98.field632;
                           class36.field802[var5++] = var98.field633;
                           class36.field808[var6++] = var98.field641;
                           class36.field802[var5++] = var98.field637;
                           class36.field802[var5++] = var98.field634;
                           class36.field808[var6++] = var98.field635;
                           continue;
                        }

                        class36.field802[var5++] = -1;
                        class36.field802[var5++] = 0;
                        class36.field808[var6++] = "";
                        class36.field802[var5++] = 0;
                        class36.field802[var5++] = 0;
                        class36.field808[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var28) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3125).append(" ");

            for(var13 = class36.field804 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field805[var13].field200.field3125).append(" ");
            }

            var12.append("").append(var10);
            class90.method2067(var12.toString(), var28);
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/lang/Object;S)V",
      garbageValue = "1480"
   )
   public static void method202(class136 var0, Object var1) {
      if(null != var0.field2111) {
         for(int var2 = 0; var2 < 50 && var0.field2111.peekEvent() != null; ++var2) {
            class116.method2448(1L);
         }

         if(var1 != null) {
            var0.field2111.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "-1805715568"
   )
   static final void method203(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null && var3.field2784 == var1 && (!var3.field2764 || !class85.method1892(var3))) {
            if(0 == var3.field2767) {
               if(!var3.field2764 && class85.method1892(var3) && var3 != class4.field78) {
                  continue;
               }

               method203(var0, var3.field2826);
               if(null != var3.field2847) {
                  method203(var3.field2847, var3.field2826);
               }

               class3 var4 = (class3)client.field308.method3777((long)var3.field2826);
               if(var4 != null) {
                  class176.method3437(var4.field69);
               }
            }

            if(6 == var3.field2767) {
               int var5;
               if(var3.field2812 != -1 || var3.field2813 != -1) {
                  boolean var7 = class127.method2809(var3);
                  if(var7) {
                     var5 = var3.field2813;
                  } else {
                     var5 = var3.field2812;
                  }

                  if(-1 != var5) {
                     class42 var6 = class4.method42(var5);

                     for(var3.field2754 += client.field356; var3.field2754 > var6.field999[var3.field2834]; class34.method701(var3)) {
                        var3.field2754 -= var6.field999[var3.field2834];
                        ++var3.field2834;
                        if(var3.field2834 >= var6.field986.length) {
                           var3.field2834 -= var6.field991;
                           if(var3.field2834 < 0 || var3.field2834 >= var6.field986.length) {
                              var3.field2834 = 0;
                           }
                        }
                     }
                  }
               }

               if(0 != var3.field2821 && !var3.field2764) {
                  int var8 = var3.field2821 >> 16;
                  var5 = var3.field2821 << 16 >> 16;
                  var8 *= client.field356;
                  var5 *= client.field356;
                  var3.field2816 = var8 + var3.field2816 & 2047;
                  var3.field2817 = var3.field2817 + var5 & 2047;
                  class34.method701(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "748769473"
   )
   static void method204(class2 var0, int var1, int var2) {
      if(var0.field843 == var1 && -1 != var1) {
         int var3 = class4.method42(var1).field988;
         if(1 == var3) {
            var0.field844 = 0;
            var0.field845 = 0;
            var0.field851 = var2;
            var0.field826 = 0;
         }

         if(var3 == 2) {
            var0.field826 = 0;
         }
      } else if(var1 == -1 || var0.field843 == -1 || class4.method42(var1).field993 >= class4.method42(var0.field843).field993) {
         var0.field843 = var1;
         var0.field844 = 0;
         var0.field845 = 0;
         var0.field851 = var2;
         var0.field826 = 0;
         var0.field870 = var0.field841;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "31"
   )
   static final byte[] method205(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2492();
      int var3 = var1.method2497();
      if(var3 >= 0 && (0 == class167.field2681 || var3 <= class167.field2681)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2503(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2497();
            if(var4 < 0 || 0 != class167.field2681 && var4 > class167.field2681) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(1 == var2) {
                  class117.method2450(var5, var4, var0, var3, 9);
               } else {
                  class167.field2689.method2445(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}

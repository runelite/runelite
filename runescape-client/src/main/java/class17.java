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
   @Export("rank")
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

         int var11;
         try {
            class36.field798 = new int[var4.field587];
            int var12 = 0;
            class36.field803 = new String[var4.field588];
            int var55 = 0;

            int var14;
            String var15;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var14 = ((Integer)var2[var11]).intValue();
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

                  class36.field798[var12++] = var14;
               } else if(var2[var11] instanceof String) {
                  var15 = (String)var2[var11];
                  if(var15.equals("event_opbase")) {
                     var15 = var0.field9;
                  }

                  class36.field803[var55++] = var15;
               }
            }

            var11 = 0;
            class36.field810 = var0.field2;

            label3311:
            while(true) {
               ++var11;
               if(var11 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var16 = var8[var7];
               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               String var22;
               int var23;
               int[] var24;
               int var25;
               String var26;
               String var27;
               byte[] var28;
               byte var29;
               int var30;
               String var31;
               if(var16 < 100) {
                  if(var16 == 0) {
                     class36.field802[var5++] = var9[var7];
                     continue;
                  }

                  if(var16 == 1) {
                     var14 = var9[var7];
                     class36.field802[var5++] = class176.field2920[var14];
                     continue;
                  }

                  if(2 == var16) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2920[var14] = class36.field802[var5];
                     class52.method1069(var14);
                     continue;
                  }

                  if(var16 == 3) {
                     class36.field808[var6++] = var4.field586[var7];
                     continue;
                  }

                  if(var16 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var16 == 7) {
                     var5 -= 2;
                     if(class36.field802[var5] != class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var16) {
                     var5 -= 2;
                     if(class36.field802[var5] == class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(9 == var16) {
                     var5 -= 2;
                     if(class36.field802[var5] < class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 10) {
                     var5 -= 2;
                     if(class36.field802[var5] > class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 21) {
                     if(class36.field804 == 0) {
                        return;
                     }

                     class14 var60 = class36.field805[--class36.field804];
                     var4 = var60.field200;
                     var8 = var4.field584;
                     var9 = var4.field585;
                     var7 = var60.field198;
                     class36.field798 = var60.field201;
                     class36.field803 = var60.field202;
                     continue;
                  }

                  if(var16 == 25) {
                     var14 = var9[var7];
                     class36.field802[var5++] = class32.method691(var14);
                     continue;
                  }

                  if(27 == var16) {
                     var14 = var9[var7];
                     --var5;
                     var30 = class36.field802[var5];
                     class47 var59 = (class47)class47.field1065.method3743((long)var14);
                     class47 var101;
                     if(var59 != null) {
                        var101 = var59;
                     } else {
                        var28 = class47.field1070.method3239(14, var14);
                        var59 = new class47();
                        if(null != var28) {
                           var59.method955(new class119(var28));
                        }

                        class47.field1065.method3745(var59, (long)var14);
                        var101 = var59;
                     }

                     var23 = var101.field1066;
                     var20 = var101.field1064;
                     var21 = var101.field1068;
                     var25 = class176.field2919[var21 - var20];
                     if(var30 < 0 || var30 > var25) {
                        var30 = 0;
                     }

                     var25 <<= var20;
                     class176.field2920[var23] = class176.field2920[var23] & ~var25 | var30 << var20 & var25;
                     continue;
                  }

                  if(var16 == 31) {
                     var5 -= 2;
                     if(class36.field802[var5] <= class36.field802[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(32 == var16) {
                     var5 -= 2;
                     if(class36.field802[var5] >= class36.field802[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 33) {
                     class36.field802[var5++] = class36.field798[var9[var7]];
                     continue;
                  }

                  if(34 == var16) {
                     var18 = var9[var7];
                     --var5;
                     class36.field798[var18] = class36.field802[var5];
                     continue;
                  }

                  if(35 == var16) {
                     class36.field808[var6++] = class36.field803[var9[var7]];
                     continue;
                  }

                  if(var16 == 36) {
                     var18 = var9[var7];
                     --var6;
                     class36.field803[var18] = class36.field808[var6];
                     continue;
                  }

                  if(37 == var16) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var58 = class36.field808;
                     if(var14 == 0) {
                        var31 = "";
                     } else if(1 == var14) {
                        var22 = var58[var6];
                        if(var22 == null) {
                           var31 = "null";
                        } else {
                           var31 = var22.toString();
                        }
                     } else {
                        var19 = var14 + var6;
                        var23 = 0;

                        for(var20 = var6; var20 < var19; ++var20) {
                           var26 = var58[var20];
                           if(null == var26) {
                              var23 += 4;
                           } else {
                              var23 += var26.length();
                           }
                        }

                        StringBuilder var100 = new StringBuilder(var23);

                        for(var21 = var6; var21 < var19; ++var21) {
                           var27 = var58[var21];
                           if(null == var27) {
                              var100.append("null");
                           } else {
                              var100.append(var27);
                           }
                        }

                        var31 = var100.toString();
                     }

                     class36.field808[var6++] = var31;
                     continue;
                  }

                  if(var16 == 38) {
                     --var5;
                     continue;
                  }

                  if(39 == var16) {
                     --var6;
                     continue;
                  }

                  if(var16 == 40) {
                     var14 = var9[var7];
                     class22 var57 = class6.method93(var14);
                     var24 = new int[var57.field587];
                     String[] var99 = new String[var57.field588];

                     for(var23 = 0; var23 < var57.field592; ++var23) {
                        var24[var23] = class36.field802[var5 - var57.field592 + var23];
                     }

                     for(var23 = 0; var23 < var57.field590; ++var23) {
                        var99[var23] = class36.field808[var6 - var57.field590 + var23];
                     }

                     var5 -= var57.field592;
                     var6 -= var57.field590;
                     class14 var56 = new class14();
                     var56.field200 = var4;
                     var56.field198 = var7;
                     var56.field201 = class36.field798;
                     var56.field202 = class36.field803;
                     class36.field805[++class36.field804 - 1] = var56;
                     var4 = var57;
                     var8 = var57.field584;
                     var9 = var57.field585;
                     var7 = -1;
                     class36.field798 = var24;
                     class36.field803 = var99;
                     continue;
                  }

                  if(var16 == 42) {
                     class36.field802[var5++] = class34.field784.method213(var9[var7]);
                     continue;
                  }

                  if(var16 == 43) {
                     var18 = var9[var7];
                     --var5;
                     class34.field784.method226(var18, class36.field802[var5]);
                     continue;
                  }

                  if(var16 == 44) {
                     var14 = var9[var7] >> 16;
                     var30 = var9[var7] & '\uffff';
                     --var5;
                     var17 = class36.field802[var5];
                     if(var17 >= 0 && var17 <= 5000) {
                        class36.field800[var14] = var17;
                        var29 = -1;
                        if(var30 == 105) {
                           var29 = 0;
                        }

                        var23 = 0;

                        while(true) {
                           if(var23 >= var17) {
                              continue label3311;
                           }

                           class36.field801[var14][var23] = var29;
                           ++var23;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var30 = class36.field802[var5];
                     if(var30 >= 0 && var30 < class36.field800[var14]) {
                        class36.field802[var5++] = class36.field801[var14][var30];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var16) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var30 = class36.field802[var5];
                     if(var30 >= 0 && var30 < class36.field800[var14]) {
                        class36.field801[var14][var30] = class36.field802[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 47) {
                     var15 = class34.field784.method233(var9[var7]);
                     if(var15 == null) {
                        var15 = "null";
                     }

                     class36.field808[var6++] = var15;
                     continue;
                  }

                  if(48 == var16) {
                     var18 = var9[var7];
                     --var6;
                     class34.field784.method214(var18, class36.field808[var6]);
                     continue;
                  }
               }

               boolean var32;
               if(1 == var9[var7]) {
                  var32 = true;
               } else {
                  var32 = false;
               }

               class173 var33;
               class173 var34;
               class173 var35;
               boolean var36;
               boolean var37;
               class173 var38;
               int[] var39;
               if(var16 < 1000) {
                  if(100 == var16) {
                     var5 -= 3;
                     var30 = class36.field802[var5];
                     var17 = class36.field802[var5 + 1];
                     var19 = class36.field802[var5 + 2];
                     if(var17 == 0) {
                        throw new RuntimeException();
                     }

                     var34 = class29.method645(var30);
                     if(null == var34.field2847) {
                        var34.field2847 = new class173[1 + var19];
                     }

                     if(var34.field2847.length <= var19) {
                        class173[] var63 = new class173[var19 + 1];

                        for(var21 = 0; var21 < var34.field2847.length; ++var21) {
                           var63[var21] = var34.field2847[var21];
                        }

                        var34.field2847 = var63;
                     }

                     if(var19 > 0 && var34.field2847[var19 - 1] == null) {
                        throw new RuntimeException("" + (var19 - 1));
                     }

                     class173 var64 = new class173();
                     var64.field2767 = var17;
                     var18 = var34.field2826;
                     var64.field2826 = var34.field2826 * 1244987933;
                     var64.field2784 = var18;
                     var64.field2766 = var19;
                     var64.field2764 = true;
                     var34.field2847[var19] = var64;
                     if(var32) {
                        class141.field2173 = var64;
                     } else {
                        class12.field185 = var64;
                     }

                     class34.method701(var34);
                     continue;
                  }

                  if(var16 == 101) {
                     var33 = var32?class141.field2173:class12.field185;
                     var38 = class29.method645(var33.field2826);
                     var38.field2847[var33.field2766] = null;
                     class34.method701(var38);
                     continue;
                  }

                  if(102 == var16) {
                     --var5;
                     var33 = class29.method645(class36.field802[var5]);
                     var33.field2847 = null;
                     class34.method701(var33);
                     continue;
                  }

                  if(var16 == 200) {
                     var5 -= 2;
                     var30 = class36.field802[var5];
                     var17 = class36.field802[1 + var5];
                     var35 = class45.method932(var30, var17);
                     if(var35 != null && -1 != var17) {
                        class36.field802[var5++] = 1;
                        if(var32) {
                           class141.field2173 = var35;
                        } else {
                           class12.field185 = var35;
                        }
                        continue;
                     }

                     class36.field802[var5++] = 0;
                     continue;
                  }

                  if(201 == var16) {
                     --var5;
                     var33 = class29.method645(class36.field802[var5]);
                     if(null != var33) {
                        class36.field802[var5++] = 1;
                        if(var32) {
                           class141.field2173 = var33;
                        } else {
                           class12.field185 = var33;
                        }
                     } else {
                        class36.field802[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var40;
                  if((var16 < 1000 || var16 >= 1100) && (var16 < 2000 || var16 >= 2100)) {
                     if(var16 >= 1100 && var16 < 1200 || var16 >= 2100 && var16 < 2200) {
                        var17 = -1;
                        if(var16 >= 2000) {
                           var16 -= 1000;
                           --var5;
                           var17 = class36.field802[var5];
                           var33 = class29.method645(var17);
                        } else {
                           var33 = var32?class141.field2173:class12.field185;
                        }

                        if(var16 == 1100) {
                           var5 -= 2;
                           var33.field2786 = class36.field802[var5];
                           if(var33.field2786 > var33.field2848 - var33.field2886) {
                              var33.field2786 = var33.field2848 - var33.field2886;
                           }

                           if(var33.field2786 < 0) {
                              var33.field2786 = 0;
                           }

                           var33.field2787 = class36.field802[var5 + 1];
                           if(var33.field2787 > var33.field2858 - var33.field2781) {
                              var33.field2787 = var33.field2858 - var33.field2781;
                           }

                           if(var33.field2787 < 0) {
                              var33.field2787 = 0;
                           }

                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1101) {
                           --var5;
                           var33.field2790 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1102) {
                           --var5;
                           var33.field2794 = class36.field802[var5] == 1;
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1103) {
                           --var5;
                           var33.field2796 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1104) {
                           --var5;
                           var33.field2798 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(1105 == var16) {
                           --var5;
                           var33.field2890 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1106) {
                           --var5;
                           var33.field2802 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1107) {
                           --var5;
                           var33.field2803 = class36.field802[var5] == 1;
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1108) {
                           var33.field2788 = 1;
                           --var5;
                           var33.field2830 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1109) {
                           var5 -= 6;
                           var33.field2859 = class36.field802[var5];
                           var33.field2815 = class36.field802[var5 + 1];
                           var33.field2816 = class36.field802[2 + var5];
                           var33.field2817 = class36.field802[var5 + 3];
                           var33.field2818 = class36.field802[4 + var5];
                           var33.field2819 = class36.field802[var5 + 5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1110) {
                           --var5;
                           var19 = class36.field802[var5];
                           if(var19 != var33.field2812) {
                              var33.field2812 = var19;
                              var33.field2834 = 0;
                              var33.field2754 = 0;
                              class34.method701(var33);
                           }
                           continue;
                        }

                        if(var16 == 1111) {
                           --var5;
                           var33.field2822 = class36.field802[var5] == 1;
                           class34.method701(var33);
                           continue;
                        }

                        if(1112 == var16) {
                           --var6;
                           var22 = class36.field808[var6];
                           if(!var22.equals(var33.field2825)) {
                              var33.field2825 = var22;
                              class34.method701(var33);
                           }
                           continue;
                        }

                        if(1113 == var16) {
                           --var5;
                           var33.field2824 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(1114 == var16) {
                           var5 -= 3;
                           var33.field2828 = class36.field802[var5];
                           var33.field2829 = class36.field802[1 + var5];
                           var33.field2899 = class36.field802[var5 + 2];
                           class34.method701(var33);
                           continue;
                        }

                        if(1115 == var16) {
                           --var5;
                           var33.field2769 = class36.field802[var5] == 1;
                           class34.method701(var33);
                           continue;
                        }

                        if(1116 == var16) {
                           --var5;
                           var33.field2804 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(1117 == var16) {
                           --var5;
                           var33.field2805 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(1118 == var16) {
                           --var5;
                           var33.field2840 = class36.field802[var5] == 1;
                           class34.method701(var33);
                           continue;
                        }

                        if(1119 == var16) {
                           --var5;
                           var33.field2807 = class36.field802[var5] == 1;
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1120) {
                           var5 -= 2;
                           var33.field2848 = class36.field802[var5];
                           var33.field2858 = class36.field802[1 + var5];
                           class34.method701(var33);
                           if(-1 != var17 && var33.field2767 == 0) {
                              class125.method2796(class217.field3171[var17 >> 16], var33, false);
                           }
                           continue;
                        }

                        if(var16 == 1121) {
                           var19 = var33.field2826;
                           var23 = var33.field2766;
                           client.field322.method2737(99);
                           client.field322.method2661(var23);
                           client.field322.method2531(var19);
                           client.field441 = var33;
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1122) {
                           --var5;
                           var33.field2801 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1123) {
                           --var5;
                           var33.field2791 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1124) {
                           --var5;
                           var33.field2833 = class36.field802[var5];
                           class34.method701(var33);
                           continue;
                        }

                        if(var16 == 1125) {
                           --var5;
                           var19 = class36.field802[var5];
                           class82 var69 = (class82)class75.method1616(class38.method735(), var19);
                           if(null != var69) {
                              var33.field2795 = var69;
                              class34.method701(var33);
                           }
                           continue;
                        }
                     } else if((var16 < 1200 || var16 >= 1300) && (var16 < 2200 || var16 >= 2300)) {
                        if((var16 < 1300 || var16 >= 1400) && (var16 < 2300 || var16 >= 2400)) {
                           int[] var42;
                           String var62;
                           if(var16 >= 1400 && var16 < 1500 || var16 >= 2400 && var16 < 2500) {
                              if(var16 >= 2000) {
                                 var16 -= 1000;
                                 --var5;
                                 var33 = class29.method645(class36.field802[var5]);
                              } else {
                                 var33 = var32?class141.field2173:class12.field185;
                              }

                              --var6;
                              var62 = class36.field808[var6];
                              var42 = null;
                              if(var62.length() > 0 && var62.charAt(var62.length() - 1) == 89) {
                                 --var5;
                                 var23 = class36.field802[var5];
                                 if(var23 > 0) {
                                    for(var42 = new int[var23]; var23-- > 0; var42[var23] = class36.field802[var5]) {
                                       --var5;
                                    }
                                 }

                                 var62 = var62.substring(0, var62.length() - 1);
                              }

                              Object[] var74 = new Object[var62.length() + 1];

                              for(var20 = var74.length - 1; var20 >= 1; --var20) {
                                 if(var62.charAt(var20 - 1) == 115) {
                                    --var6;
                                    var74[var20] = class36.field808[var6];
                                 } else {
                                    --var5;
                                    var74[var20] = new Integer(class36.field802[var5]);
                                 }
                              }

                              --var5;
                              var20 = class36.field802[var5];
                              if(-1 != var20) {
                                 var74[0] = new Integer(var20);
                              } else {
                                 var74 = null;
                              }

                              if(1400 == var16) {
                                 var33.field2872 = var74;
                              }

                              if(1401 == var16) {
                                 var33.field2850 = var74;
                              }

                              if(var16 == 1402) {
                                 var33.field2849 = var74;
                              }

                              if(var16 == 1403) {
                                 var33.field2851 = var74;
                              }

                              if(1404 == var16) {
                                 var33.field2853 = var74;
                              }

                              if(1405 == var16) {
                                 var33.field2854 = var74;
                              }

                              if(var16 == 1406) {
                                 var33.field2800 = var74;
                              }

                              if(var16 == 1407) {
                                 var33.field2808 = var74;
                                 var33.field2771 = var42;
                              }

                              if(var16 == 1408) {
                                 var33.field2793 = var74;
                              }

                              if(1409 == var16) {
                                 var33.field2865 = var74;
                              }

                              if(var16 == 1410) {
                                 var33.field2855 = var74;
                              }

                              if(var16 == 1411) {
                                 var33.field2880 = var74;
                              }

                              if(var16 == 1412) {
                                 var33.field2852 = var74;
                              }

                              if(1414 == var16) {
                                 var33.field2860 = var74;
                                 var33.field2758 = var42;
                              }

                              if(var16 == 1415) {
                                 var33.field2862 = var74;
                                 var33.field2863 = var42;
                              }

                              if(1416 == var16) {
                                 var33.field2892 = var74;
                              }

                              if(var16 == 1417) {
                                 var33.field2843 = var74;
                              }

                              if(var16 == 1418) {
                                 var33.field2867 = var74;
                              }

                              if(1419 == var16) {
                                 var33.field2868 = var74;
                              }

                              if(var16 == 1420) {
                                 var33.field2869 = var74;
                              }

                              if(var16 == 1421) {
                                 var33.field2870 = var74;
                              }

                              if(1422 == var16) {
                                 var33.field2782 = var74;
                              }

                              if(var16 == 1423) {
                                 var33.field2763 = var74;
                              }

                              if(var16 == 1424) {
                                 var33.field2873 = var74;
                              }

                              if(var16 == 1425) {
                                 var33.field2875 = var74;
                              }

                              if(1426 == var16) {
                                 var33.field2792 = var74;
                              }

                              if(var16 == 1427) {
                                 var33.field2874 = var74;
                              }

                              var33.field2845 = true;
                              continue;
                           }

                           if(var16 < 1600) {
                              var33 = var32?class141.field2173:class12.field185;
                              if(1500 == var16) {
                                 class36.field802[var5++] = var33.field2768;
                                 continue;
                              }

                              if(1501 == var16) {
                                 class36.field802[var5++] = var33.field2779;
                                 continue;
                              }

                              if(1502 == var16) {
                                 class36.field802[var5++] = var33.field2886;
                                 continue;
                              }

                              if(var16 == 1503) {
                                 class36.field802[var5++] = var33.field2781;
                                 continue;
                              }

                              if(1504 == var16) {
                                 class36.field802[var5++] = var33.field2773?1:0;
                                 continue;
                              }

                              if(var16 == 1505) {
                                 class36.field802[var5++] = var33.field2784;
                                 continue;
                              }
                           } else if(var16 < 1700) {
                              var33 = var32?class141.field2173:class12.field185;
                              if(var16 == 1600) {
                                 class36.field802[var5++] = var33.field2786;
                                 continue;
                              }

                              if(1601 == var16) {
                                 class36.field802[var5++] = var33.field2787;
                                 continue;
                              }

                              if(var16 == 1602) {
                                 class36.field808[var6++] = var33.field2825;
                                 continue;
                              }

                              if(1603 == var16) {
                                 class36.field802[var5++] = var33.field2848;
                                 continue;
                              }

                              if(var16 == 1604) {
                                 class36.field802[var5++] = var33.field2858;
                                 continue;
                              }

                              if(var16 == 1605) {
                                 class36.field802[var5++] = var33.field2819;
                                 continue;
                              }

                              if(var16 == 1606) {
                                 class36.field802[var5++] = var33.field2816;
                                 continue;
                              }

                              if(var16 == 1607) {
                                 class36.field802[var5++] = var33.field2818;
                                 continue;
                              }

                              if(1608 == var16) {
                                 class36.field802[var5++] = var33.field2817;
                                 continue;
                              }

                              if(var16 == 1609) {
                                 class36.field802[var5++] = var33.field2796;
                                 continue;
                              }

                              if(1610 == var16) {
                                 class36.field802[var5++] = var33.field2833;
                                 continue;
                              }

                              if(var16 == 1611) {
                                 class36.field802[var5++] = var33.field2790;
                                 continue;
                              }

                              if(var16 == 1612) {
                                 class36.field802[var5++] = var33.field2791;
                                 continue;
                              }

                              if(var16 == 1613) {
                                 class36.field802[var5++] = var33.field2795.vmethod3150();
                                 continue;
                              }
                           } else if(var16 < 1800) {
                              var33 = var32?class141.field2173:class12.field185;
                              if(1700 == var16) {
                                 class36.field802[var5++] = var33.field2885;
                                 continue;
                              }

                              if(1701 == var16) {
                                 if(-1 != var33.field2885) {
                                    class36.field802[var5++] = var33.field2780;
                                 } else {
                                    class36.field802[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(1702 == var16) {
                                 class36.field802[var5++] = var33.field2766;
                                 continue;
                              }
                           } else if(var16 < 1900) {
                              var33 = var32?class141.field2173:class12.field185;
                              if(var16 == 1800) {
                                 var24 = class36.field802;
                                 var19 = var5++;
                                 var20 = class48.method962(var33);
                                 var23 = var20 >> 11 & 63;
                                 var24[var19] = var23;
                                 continue;
                              }

                              if(var16 == 1801) {
                                 --var5;
                                 var17 = class36.field802[var5];
                                 --var17;
                                 if(var33.field2839 != null && var17 < var33.field2839.length && null != var33.field2839[var17]) {
                                    class36.field808[var6++] = var33.field2839[var17];
                                    continue;
                                 }

                                 class36.field808[var6++] = "";
                                 continue;
                              }

                              if(var16 == 1802) {
                                 if(var33.field2789 == null) {
                                    class36.field808[var6++] = "";
                                 } else {
                                    class36.field808[var6++] = var33.field2789;
                                 }
                                 continue;
                              }
                           } else if(var16 >= 1900 && var16 < 2000 || var16 >= 2900 && var16 < 3000) {
                              if(var16 >= 2000) {
                                 var16 -= 1000;
                                 --var5;
                                 var33 = class29.method645(class36.field802[var5]);
                              } else {
                                 var33 = var32?class141.field2173:class12.field185;
                              }

                              if(1927 == var16) {
                                 if(class36.field810 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var33.field2874) {
                                    return;
                                 }

                                 class0 var71 = new class0();
                                 var71.field8 = var33;
                                 var71.field12 = var33.field2874;
                                 var71.field2 = 1 + class36.field810;
                                 client.field283.method3807(var0);
                                 continue;
                              }
                           } else if(var16 < 2600) {
                              --var5;
                              var33 = class29.method645(class36.field802[var5]);
                              if(2500 == var16) {
                                 class36.field802[var5++] = var33.field2768;
                                 continue;
                              }

                              if(2501 == var16) {
                                 class36.field802[var5++] = var33.field2779;
                                 continue;
                              }

                              if(var16 == 2502) {
                                 class36.field802[var5++] = var33.field2886;
                                 continue;
                              }

                              if(var16 == 2503) {
                                 class36.field802[var5++] = var33.field2781;
                                 continue;
                              }

                              if(2504 == var16) {
                                 class36.field802[var5++] = var33.field2773?1:0;
                                 continue;
                              }

                              if(2505 == var16) {
                                 class36.field802[var5++] = var33.field2784;
                                 continue;
                              }
                           } else if(var16 < 2700) {
                              --var5;
                              var33 = class29.method645(class36.field802[var5]);
                              if(var16 == 2600) {
                                 class36.field802[var5++] = var33.field2786;
                                 continue;
                              }

                              if(var16 == 2601) {
                                 class36.field802[var5++] = var33.field2787;
                                 continue;
                              }

                              if(2602 == var16) {
                                 class36.field808[var6++] = var33.field2825;
                                 continue;
                              }

                              if(var16 == 2603) {
                                 class36.field802[var5++] = var33.field2848;
                                 continue;
                              }

                              if(var16 == 2604) {
                                 class36.field802[var5++] = var33.field2858;
                                 continue;
                              }

                              if(2605 == var16) {
                                 class36.field802[var5++] = var33.field2819;
                                 continue;
                              }

                              if(2606 == var16) {
                                 class36.field802[var5++] = var33.field2816;
                                 continue;
                              }

                              if(var16 == 2607) {
                                 class36.field802[var5++] = var33.field2818;
                                 continue;
                              }

                              if(var16 == 2608) {
                                 class36.field802[var5++] = var33.field2817;
                                 continue;
                              }

                              if(var16 == 2609) {
                                 class36.field802[var5++] = var33.field2796;
                                 continue;
                              }

                              if(var16 == 2610) {
                                 class36.field802[var5++] = var33.field2833;
                                 continue;
                              }

                              if(2611 == var16) {
                                 class36.field802[var5++] = var33.field2790;
                                 continue;
                              }

                              if(2612 == var16) {
                                 class36.field802[var5++] = var33.field2791;
                                 continue;
                              }

                              if(2613 == var16) {
                                 class36.field802[var5++] = var33.field2795.vmethod3150();
                                 continue;
                              }
                           } else {
                              class3 var43;
                              if(var16 < 2800) {
                                 if(2700 == var16) {
                                    --var5;
                                    var33 = class29.method645(class36.field802[var5]);
                                    class36.field802[var5++] = var33.field2885;
                                    continue;
                                 }

                                 if(2701 == var16) {
                                    --var5;
                                    var33 = class29.method645(class36.field802[var5]);
                                    if(var33.field2885 != -1) {
                                       class36.field802[var5++] = var33.field2780;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(2702 == var16) {
                                    --var5;
                                    var30 = class36.field802[var5];
                                    var43 = (class3)client.field308.method3777((long)var30);
                                    if(var43 != null) {
                                       class36.field802[var5++] = 1;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var16 == 2706) {
                                    class36.field802[var5++] = client.field412;
                                    continue;
                                 }
                              } else if(var16 < 2900) {
                                 --var5;
                                 var33 = class29.method645(class36.field802[var5]);
                                 if(var16 == 2800) {
                                    var24 = class36.field802;
                                    var19 = var5++;
                                    var20 = class48.method962(var33);
                                    var23 = var20 >> 11 & 63;
                                    var24[var19] = var23;
                                    continue;
                                 }

                                 if(var16 == 2801) {
                                    --var5;
                                    var17 = class36.field802[var5];
                                    --var17;
                                    if(null != var33.field2839 && var17 < var33.field2839.length && var33.field2839[var17] != null) {
                                       class36.field808[var6++] = var33.field2839[var17];
                                       continue;
                                    }

                                    class36.field808[var6++] = "";
                                    continue;
                                 }

                                 if(var16 == 2802) {
                                    if(null == var33.field2789) {
                                       class36.field808[var6++] = "";
                                    } else {
                                       class36.field808[var6++] = var33.field2789;
                                    }
                                    continue;
                                 }
                              } else if(var16 < 3200) {
                                 if(var16 == 3100) {
                                    --var6;
                                    var31 = class36.field808[var6];
                                    class125.method2783(0, "", var31);
                                    continue;
                                 }

                                 if(var16 == 3101) {
                                    var5 -= 2;
                                    method204(class106.field1881, class36.field802[var5], class36.field802[var5 + 1]);
                                    continue;
                                 }

                                 if(var16 == 3103) {
                                    client.field322.method2737(224);

                                    for(var43 = (class3)client.field308.method3780(); null != var43; var43 = (class3)client.field308.method3781()) {
                                       if(var43.field62 == 0 || 3 == var43.field62) {
                                          class38.method737(var43, true);
                                       }
                                    }

                                    if(null != client.field441) {
                                       class34.method701(client.field441);
                                       client.field441 = null;
                                    }
                                    continue;
                                 }

                                 if(var16 == 3104) {
                                    --var6;
                                    var31 = class36.field808[var6];
                                    var17 = 0;
                                    if(class133.method2844(var31)) {
                                       var19 = class121.method2729(var31, 10, true);
                                       var17 = var19;
                                    }

                                    client.field322.method2737(181);
                                    client.field322.method2480(var17);
                                    continue;
                                 }

                                 if(3105 == var16) {
                                    --var6;
                                    var31 = class36.field808[var6];
                                    client.field322.method2737(82);
                                    client.field322.method2477(var31.length() + 1);
                                    client.field322.method2483(var31);
                                    continue;
                                 }

                                 if(var16 == 3106) {
                                    --var6;
                                    var31 = class36.field808[var6];
                                    client.field322.method2737(55);
                                    client.field322.method2477(var31.length() + 1);
                                    client.field322.method2483(var31);
                                    continue;
                                 }

                                 if(3107 == var16) {
                                    --var5;
                                    var30 = class36.field802[var5];
                                    --var6;
                                    var62 = class36.field808[var6];
                                    var19 = class32.field755;
                                    int[] var65 = class32.field756;
                                    boolean var44 = false;

                                    for(var21 = 0; var21 < var19; ++var21) {
                                       class2 var45 = client.field491[var65[var21]];
                                       if(var45 != null && class106.field1881 != var45 && var45.field59 != null && var45.field59.equalsIgnoreCase(var62)) {
                                          if(1 == var30) {
                                             client.field322.method2737(89);
                                             client.field322.method2590(0);
                                             client.field322.method2525(var65[var21]);
                                          } else if(var30 == 4) {
                                             client.field322.method2737(128);
                                             client.field322.method2661(var65[var21]);
                                             client.field322.method2681(0);
                                          } else if(6 == var30) {
                                             client.field322.method2737(134);
                                             client.field322.method2477(0);
                                             client.field322.method2557(var65[var21]);
                                          } else if(var30 == 7) {
                                             client.field322.method2737(52);
                                             client.field322.method2525(var65[var21]);
                                             client.field322.method2516(0);
                                          }

                                          var44 = true;
                                          break;
                                       }
                                    }

                                    if(!var44) {
                                       class125.method2783(4, "", "Unable to find " + var62);
                                    }
                                    continue;
                                 }

                                 if(3108 == var16) {
                                    var5 -= 3;
                                    var30 = class36.field802[var5];
                                    var17 = class36.field802[var5 + 1];
                                    var19 = class36.field802[2 + var5];
                                    var34 = class29.method645(var19);
                                    class129.method2810(var34, var30, var17);
                                    continue;
                                 }

                                 if(3109 == var16) {
                                    var5 -= 2;
                                    var30 = class36.field802[var5];
                                    var17 = class36.field802[1 + var5];
                                    var35 = var32?class141.field2173:class12.field185;
                                    class129.method2810(var35, var30, var17);
                                    continue;
                                 }

                                 if(3110 == var16) {
                                    --var5;
                                    class89.field1563 = class36.field802[var5] == 1;
                                    continue;
                                 }

                                 if(var16 == 3111) {
                                    class36.field802[var5++] = class76.field1388.field148?1:0;
                                    continue;
                                 }

                                 if(3112 == var16) {
                                    --var5;
                                    class76.field1388.field148 = class36.field802[var5] == 1;
                                    class7.method101();
                                    continue;
                                 }

                                 if(3113 == var16) {
                                    --var6;
                                    var31 = class36.field808[var6];
                                    --var5;
                                    var36 = class36.field802[var5] == 1;
                                    class103.method2275(var31, var36, "openjs", false);
                                    continue;
                                 }

                                 if(var16 == 3115) {
                                    --var5;
                                    var30 = class36.field802[var5];
                                    client.field322.method2737(234);
                                    client.field322.method2661(var30);
                                    continue;
                                 }

                                 if(3116 == var16) {
                                    --var5;
                                    var30 = class36.field802[var5];
                                    var6 -= 2;
                                    var62 = class36.field808[var6];
                                    var22 = class36.field808[1 + var6];
                                    if(var62.length() <= 500 && var22.length() <= 500) {
                                       client.field322.method2737(167);
                                       client.field322.method2661(1 + class30.method647(var62) + class30.method647(var22));
                                       client.field322.method2477(var30);
                                       client.field322.method2483(var22);
                                       client.field322.method2483(var62);
                                    }
                                    continue;
                                 }
                              } else if(var16 < 3300) {
                                 if(3200 == var16) {
                                    var5 -= 3;
                                    class153.method3134(class36.field802[var5], class36.field802[var5 + 1], class36.field802[var5 + 2]);
                                    continue;
                                 }

                                 if(3201 == var16) {
                                    --var5;
                                    class77.method1660(class36.field802[var5]);
                                    continue;
                                 }

                                 if(3202 == var16) {
                                    var5 -= 2;
                                    class111.method2421(class36.field802[var5], class36.field802[1 + var5]);
                                    continue;
                                 }
                              } else {
                                 int var66;
                                 if(var16 < 3400) {
                                    if(var16 == 3300) {
                                       class36.field802[var5++] = client.field335;
                                       continue;
                                    }

                                    class15 var67;
                                    if(3301 == var16) {
                                       var5 -= 2;
                                       var30 = class36.field802[var5];
                                       var17 = class36.field802[1 + var5];
                                       var42 = class36.field802;
                                       var23 = var5++;
                                       var67 = (class15)class15.field204.method3777((long)var30);
                                       if(null == var67) {
                                          var20 = -1;
                                       } else if(var17 >= 0 && var17 < var67.field210.length) {
                                          var20 = var67.field210[var17];
                                       } else {
                                          var20 = -1;
                                       }

                                       var42[var23] = var20;
                                       continue;
                                    }

                                    if(var16 == 3302) {
                                       var5 -= 2;
                                       var30 = class36.field802[var5];
                                       var17 = class36.field802[1 + var5];
                                       class36.field802[var5++] = class20.method554(var30, var17);
                                       continue;
                                    }

                                    if(3303 == var16) {
                                       var5 -= 2;
                                       var30 = class36.field802[var5];
                                       var17 = class36.field802[var5 + 1];
                                       var42 = class36.field802;
                                       var23 = var5++;
                                       var67 = (class15)class15.field204.method3777((long)var30);
                                       if(null == var67) {
                                          var20 = 0;
                                       } else if(var17 == -1) {
                                          var20 = 0;
                                       } else {
                                          var25 = 0;

                                          for(var66 = 0; var66 < var67.field206.length; ++var66) {
                                             if(var67.field210[var66] == var17) {
                                                var25 += var67.field206[var66];
                                             }
                                          }

                                          var20 = var25;
                                       }

                                       var42[var23] = var20;
                                       continue;
                                    }

                                    if(var16 == 3304) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       var24 = class36.field802;
                                       var19 = var5++;
                                       class50 var68 = (class50)class50.field1103.method3743((long)var30);
                                       class50 var46;
                                       if(null != var68) {
                                          var46 = var68;
                                       } else {
                                          byte[] var47 = class50.field1102.method3239(5, var30);
                                          var68 = new class50();
                                          if(var47 != null) {
                                             var68.method984(new class119(var47));
                                          }

                                          class50.field1103.method3745(var68, (long)var30);
                                          var46 = var68;
                                       }

                                       var24[var19] = var46.field1101;
                                       continue;
                                    }

                                    if(3305 == var16) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       class36.field802[var5++] = client.field399[var30];
                                       continue;
                                    }

                                    if(3306 == var16) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       class36.field802[var5++] = client.field415[var30];
                                       continue;
                                    }

                                    if(3307 == var16) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       class36.field802[var5++] = client.field427[var30];
                                       continue;
                                    }

                                    if(var16 == 3308) {
                                       var30 = class21.field581;
                                       var17 = class22.field594 + (class106.field1881.field823 >> 7);
                                       var19 = (class106.field1881.field813 >> 7) + class114.field1981;
                                       class36.field802[var5++] = var19 + (var30 << 28) + (var17 << 14);
                                       continue;
                                    }

                                    if(var16 == 3309) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       class36.field802[var5++] = var30 >> 14 & 16383;
                                       continue;
                                    }

                                    if(3310 == var16) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       class36.field802[var5++] = var30 >> 28;
                                       continue;
                                    }

                                    if(var16 == 3311) {
                                       --var5;
                                       var30 = class36.field802[var5];
                                       class36.field802[var5++] = var30 & 16383;
                                       continue;
                                    }

                                    if(var16 == 3312) {
                                       class36.field802[var5++] = client.field447?1:0;
                                       continue;
                                    }

                                    if(3313 == var16) {
                                       var5 -= 2;
                                       var30 = '耀' + class36.field802[var5];
                                       var17 = class36.field802[var5 + 1];
                                       var42 = class36.field802;
                                       var23 = var5++;
                                       var67 = (class15)class15.field204.method3777((long)var30);
                                       if(null == var67) {
                                          var20 = -1;
                                       } else if(var17 >= 0 && var17 < var67.field210.length) {
                                          var20 = var67.field210[var17];
                                       } else {
                                          var20 = -1;
                                       }

                                       var42[var23] = var20;
                                       continue;
                                    }

                                    if(3314 == var16) {
                                       var5 -= 2;
                                       var30 = class36.field802[var5] + '耀';
                                       var17 = class36.field802[1 + var5];
                                       class36.field802[var5++] = class20.method554(var30, var17);
                                       continue;
                                    }

                                    if(var16 == 3315) {
                                       var5 -= 2;
                                       var30 = class36.field802[var5] + '耀';
                                       var17 = class36.field802[1 + var5];
                                       class36.field802[var5++] = class34.method709(var30, var17);
                                       continue;
                                    }

                                    if(var16 == 3316) {
                                       if(client.field517 >= 2) {
                                          class36.field802[var5++] = client.field517;
                                       } else {
                                          class36.field802[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3317) {
                                       class36.field802[var5++] = client.field295;
                                       continue;
                                    }

                                    if(var16 == 3318) {
                                       class36.field802[var5++] = client.field551;
                                       continue;
                                    }

                                    if(var16 == 3321) {
                                       class36.field802[var5++] = client.field301;
                                       continue;
                                    }

                                    if(3322 == var16) {
                                       class36.field802[var5++] = client.field437;
                                       continue;
                                    }

                                    if(var16 == 3323) {
                                       if(client.field502) {
                                          class36.field802[var5++] = 1;
                                       } else {
                                          class36.field802[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(3324 == var16) {
                                       class36.field802[var5++] = client.field279;
                                       continue;
                                    }
                                 } else if(var16 < 3500) {
                                    class48 var72;
                                    if(var16 == 3400) {
                                       var5 -= 2;
                                       var30 = class36.field802[var5];
                                       var17 = class36.field802[var5 + 1];
                                       var72 = class84.method1884(var30);
                                       if(115 != var72.field1076) {
                                          ;
                                       }

                                       for(var23 = 0; var23 < var72.field1079; ++var23) {
                                          if(var17 == var72.field1080[var23]) {
                                             class36.field808[var6++] = var72.field1077[var23];
                                             var72 = null;
                                             break;
                                          }
                                       }

                                       if(var72 != null) {
                                          class36.field808[var6++] = var72.field1087;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3408) {
                                       var5 -= 4;
                                       var30 = class36.field802[var5];
                                       var17 = class36.field802[var5 + 1];
                                       var19 = class36.field802[var5 + 2];
                                       var23 = class36.field802[3 + var5];
                                       var72 = class84.method1884(var19);
                                       if(var72.field1075 == var30 && var72.field1076 == var17) {
                                          for(var21 = 0; var21 < var72.field1079; ++var21) {
                                             if(var23 == var72.field1080[var21]) {
                                                if(var17 == 115) {
                                                   class36.field808[var6++] = var72.field1077[var21];
                                                } else {
                                                   class36.field802[var5++] = var72.field1081[var21];
                                                }

                                                var72 = null;
                                                break;
                                             }
                                          }

                                          if(null != var72) {
                                             if(115 == var17) {
                                                class36.field808[var6++] = var72.field1087;
                                             } else {
                                                class36.field802[var5++] = var72.field1078;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var17 == 115) {
                                          class36.field808[var6++] = "null";
                                       } else {
                                          class36.field802[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    int var73;
                                    int var78;
                                    boolean var80;
                                    if(var16 < 3700) {
                                       if(var16 == 3600) {
                                          if(client.field544 == 0) {
                                             class36.field802[var5++] = -2;
                                          } else if(1 == client.field544) {
                                             class36.field802[var5++] = -1;
                                          } else {
                                             class36.field802[var5++] = client.field499;
                                          }
                                          continue;
                                       }

                                       if(var16 == 3601) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(client.field544 == 2 && var30 < client.field499) {
                                             class36.field808[var6++] = client.field548[var30].field247;
                                             class36.field808[var6++] = client.field548[var30].field240;
                                             continue;
                                          }

                                          class36.field808[var6++] = "";
                                          class36.field808[var6++] = "";
                                          continue;
                                       }

                                       if(3602 == var16) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(2 == client.field544 && var30 < client.field499) {
                                             class36.field802[var5++] = client.field548[var30].field244;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3603 == var16) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(2 == client.field544 && var30 < client.field499) {
                                             class36.field802[var5++] = client.field548[var30].field237;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3604 == var16) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          --var5;
                                          var17 = class36.field802[var5];
                                          class2.method29(var31, var17);
                                          continue;
                                       }

                                       class17 var75;
                                       String var76;
                                       if(3605 == var16) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          if(null == var31) {
                                             continue;
                                          }

                                          if((client.field499 < 200 || 1 == client.field402) && client.field499 < 400) {
                                             var62 = class32.method690(var31, class1.field24);
                                             if(null == var62) {
                                                continue;
                                             }

                                             for(var19 = 0; var19 < client.field499; ++var19) {
                                                var75 = client.field548[var19];
                                                var76 = class32.method690(var75.field247, class1.field24);
                                                if(null != var76 && var76.equals(var62)) {
                                                   class125.method2783(30, "", var31 + " is already on your friend list");
                                                   continue label3311;
                                                }

                                                if(null != var75.field240) {
                                                   var26 = class32.method690(var75.field240, class1.field24);
                                                   if(null != var26 && var26.equals(var62)) {
                                                      class125.method2783(30, "", var31 + " is already on your friend list");
                                                      continue label3311;
                                                   }
                                                }
                                             }

                                             for(var19 = 0; var19 < client.field550; ++var19) {
                                                class7 var81 = client.field344[var19];
                                                var76 = class32.method690(var81.field133, class1.field24);
                                                if(null != var76 && var76.equals(var62)) {
                                                   class125.method2783(30, "", "Please remove " + var31 + " from your ignore list first");
                                                   continue label3311;
                                                }

                                                if(null != var81.field135) {
                                                   var26 = class32.method690(var81.field135, class1.field24);
                                                   if(var26 != null && var26.equals(var62)) {
                                                      class125.method2783(30, "", "Please remove " + var31 + " from your ignore list first");
                                                      continue label3311;
                                                   }
                                                }
                                             }

                                             if(class32.method690(class106.field1881.field59, class1.field24).equals(var62)) {
                                                class125.method2783(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                client.field322.method2737(130);
                                                client.field322.method2477(class30.method647(var31));
                                                client.field322.method2483(var31);
                                             }
                                             continue;
                                          }

                                          class125.method2783(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var16 == 3606) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          if(null == var31) {
                                             continue;
                                          }

                                          var62 = class32.method690(var31, class1.field24);
                                          if(var62 == null) {
                                             continue;
                                          }

                                          var19 = 0;

                                          while(true) {
                                             if(var19 >= client.field499) {
                                                continue label3311;
                                             }

                                             var75 = client.field548[var19];
                                             var76 = var75.field247;
                                             var26 = class32.method690(var76, class1.field24);
                                             if(null != var31 && var76 != null) {
                                                if(!var31.startsWith("#") && !var76.startsWith("#")) {
                                                   var80 = var62.equals(var26);
                                                } else {
                                                   var80 = var31.equals(var76);
                                                }
                                             } else {
                                                var80 = false;
                                             }

                                             if(var80) {
                                                --client.field499;

                                                for(var66 = var19; var66 < client.field499; ++var66) {
                                                   client.field548[var66] = client.field548[1 + var66];
                                                }

                                                client.field470 = client.field462;
                                                client.field322.method2737(131);
                                                client.field322.method2477(class30.method647(var31));
                                                client.field322.method2483(var31);
                                                continue label3311;
                                             }

                                             ++var19;
                                          }
                                       }

                                       if(var16 == 3607) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          class1.method6(var31, false);
                                          continue;
                                       }

                                       if(3608 == var16) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          class137.method2895(var31);
                                          continue;
                                       }

                                       if(3609 == var16) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          class152[] var79 = class115.method2441();

                                          for(var19 = 0; var19 < var79.length; ++var19) {
                                             class152 var91 = var79[var19];
                                             if(-1 != var91.field2283 && var31.startsWith(class156.method3146(var91.field2283))) {
                                                var31 = var31.substring(6 + Integer.toString(var91.field2283).length());
                                                break;
                                             }
                                          }

                                          class36.field802[var5++] = class19.method241(var31, false)?1:0;
                                          continue;
                                       }

                                       char var48;
                                       long var49;
                                       String var51;
                                       String[] var52;
                                       if(var16 == 3611) {
                                          if(client.field504 == null) {
                                             class36.field808[var6++] = "";
                                             continue;
                                          }

                                          var52 = class36.field808;
                                          var17 = var6++;
                                          var51 = client.field504;
                                          var49 = 0L;
                                          var78 = var51.length();

                                          for(var73 = 0; var73 < var78; ++var73) {
                                             var49 *= 37L;
                                             var48 = var51.charAt(var73);
                                             if(var48 >= 65 && var48 <= 90) {
                                                var49 += (long)(var48 + 1 - 65);
                                             } else if(var48 >= 97 && var48 <= 122) {
                                                var49 += (long)(var48 + 1 - 97);
                                             } else if(var48 >= 48 && var48 <= 57) {
                                                var49 += (long)(var48 + 27 - 48);
                                             }

                                             if(var49 >= 177917621779460413L) {
                                                break;
                                             }
                                          }

                                          while(var49 % 37L == 0L && 0L != var49) {
                                             var49 /= 37L;
                                          }

                                          var27 = class34.method710(var49);
                                          if(null == var27) {
                                             var27 = "";
                                          }

                                          var52[var17] = var27;
                                          continue;
                                       }

                                       if(3612 == var16) {
                                          if(null != client.field504) {
                                             class36.field802[var5++] = class110.field1959;
                                          } else {
                                             class36.field802[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(3613 == var16) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(null != client.field504 && var30 < class110.field1959) {
                                             class36.field808[var6++] = class159.field2612[var30].field616;
                                             continue;
                                          }

                                          class36.field808[var6++] = "";
                                          continue;
                                       }

                                       if(3614 == var16) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(null != client.field504 && var30 < class110.field1959) {
                                             class36.field802[var5++] = class159.field2612[var30].field618;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3615 == var16) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(client.field504 != null && var30 < class110.field1959) {
                                             class36.field802[var5++] = class159.field2612[var30].field622;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(var16 == 3616) {
                                          class36.field802[var5++] = class33.field779;
                                          continue;
                                       }

                                       if(3617 == var16) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          if(null != class159.field2612) {
                                             client.field322.method2737(50);
                                             client.field322.method2477(class30.method647(var31));
                                             client.field322.method2483(var31);
                                          }
                                          continue;
                                       }

                                       if(3618 == var16) {
                                          class36.field802[var5++] = client.field396;
                                          continue;
                                       }

                                       if(var16 == 3619) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          if(!var31.equals("")) {
                                             client.field322.method2737(21);
                                             client.field322.method2477(class30.method647(var31));
                                             client.field322.method2483(var31);
                                          }
                                          continue;
                                       }

                                       if(var16 == 3620) {
                                          class119.method2694();
                                          continue;
                                       }

                                       if(var16 == 3621) {
                                          if(client.field544 == 0) {
                                             class36.field802[var5++] = -1;
                                          } else {
                                             class36.field802[var5++] = client.field550;
                                          }
                                          continue;
                                       }

                                       if(3622 == var16) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(0 != client.field544 && var30 < client.field550) {
                                             class36.field808[var6++] = client.field344[var30].field133;
                                             class36.field808[var6++] = client.field344[var30].field135;
                                             continue;
                                          }

                                          class36.field808[var6++] = "";
                                          class36.field808[var6++] = "";
                                          continue;
                                       }

                                       if(var16 == 3623) {
                                          --var6;
                                          var31 = class36.field808[var6];
                                          if(var31.startsWith(class156.method3146(0)) || var31.startsWith(class156.method3146(1))) {
                                             var31 = var31.substring(7);
                                          }

                                          class36.field802[var5++] = class16.method196(var31)?1:0;
                                          continue;
                                       }

                                       if(var16 == 3624) {
                                          --var5;
                                          var30 = class36.field802[var5];
                                          if(null != class159.field2612 && var30 < class110.field1959 && class159.field2612[var30].field616.equalsIgnoreCase(class106.field1881.field59)) {
                                             class36.field802[var5++] = 1;
                                             continue;
                                          }

                                          class36.field802[var5++] = 0;
                                          continue;
                                       }

                                       if(3625 == var16) {
                                          if(client.field416 == null) {
                                             class36.field808[var6++] = "";
                                             continue;
                                          }

                                          var52 = class36.field808;
                                          var17 = var6++;
                                          var51 = client.field416;
                                          var49 = 0L;
                                          var78 = var51.length();

                                          for(var73 = 0; var73 < var78; ++var73) {
                                             var49 *= 37L;
                                             var48 = var51.charAt(var73);
                                             if(var48 >= 65 && var48 <= 90) {
                                                var49 += (long)(var48 + 1 - 65);
                                             } else if(var48 >= 97 && var48 <= 122) {
                                                var49 += (long)(var48 + 1 - 97);
                                             } else if(var48 >= 48 && var48 <= 57) {
                                                var49 += (long)(var48 + 27 - 48);
                                             }

                                             if(var49 >= 177917621779460413L) {
                                                break;
                                             }
                                          }

                                          while(var49 % 37L == 0L && 0L != var49) {
                                             var49 /= 37L;
                                          }

                                          var27 = class34.method710(var49);
                                          if(var27 == null) {
                                             var27 = "";
                                          }

                                          var52[var17] = var27;
                                          continue;
                                       }
                                    } else {
                                       long var77;
                                       if(var16 < 4000) {
                                          if(3903 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var30].method3968();
                                             continue;
                                          }

                                          if(3904 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var30].field3178;
                                             continue;
                                          }

                                          if(3905 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var30].field3176;
                                             continue;
                                          }

                                          if(3906 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var30].field3177;
                                             continue;
                                          }

                                          if(var16 == 3907) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var30].field3174;
                                             continue;
                                          }

                                          if(3908 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             class36.field802[var5++] = client.field388[var30].field3179;
                                             continue;
                                          }

                                          if(3910 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var17 = client.field388[var30].method3974();
                                             class36.field802[var5++] = 0 == var17?1:0;
                                             continue;
                                          }

                                          if(var16 == 3911) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var17 = client.field388[var30].method3974();
                                             class36.field802[var5++] = 2 == var17?1:0;
                                             continue;
                                          }

                                          if(3912 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var17 = client.field388[var30].method3974();
                                             class36.field802[var5++] = var17 == 5?1:0;
                                             continue;
                                          }

                                          if(var16 == 3913) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var17 = client.field388[var30].method3974();
                                             class36.field802[var5++] = var17 == 1?1:0;
                                             continue;
                                          }

                                          if(var16 == 3914) {
                                             --var5;
                                             var80 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3182, var80);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3915) {
                                             --var5;
                                             var80 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3185, var80);
                                             }
                                             continue;
                                          }

                                          if(3916 == var16) {
                                             var5 -= 2;
                                             var80 = class36.field802[var5] == 1;
                                             var36 = 1 == class36.field802[1 + var5];
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(new class21(var36), var80);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3917) {
                                             --var5;
                                             var80 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3181, var80);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3918) {
                                             --var5;
                                             var80 = class36.field802[var5] == 1;
                                             if(class37.field871 != null) {
                                                class37.field871.method3985(class221.field3180, var80);
                                             }
                                             continue;
                                          }

                                          if(3919 == var16) {
                                             class36.field802[var5++] = class37.field871 == null?0:class37.field871.field3183.size();
                                             continue;
                                          }

                                          class214 var94;
                                          if(var16 == 3920) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             class36.field802[var5++] = var94.field3161;
                                             continue;
                                          }

                                          if(var16 == 3921) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             class36.field808[var6++] = var94.method3924();
                                             continue;
                                          }

                                          if(3922 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             class36.field808[var6++] = var94.method3925();
                                             continue;
                                          }

                                          if(3923 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             var77 = class12.method162() - class3.field66 - var94.field3160;
                                             var20 = (int)(var77 / 3600000L);
                                             var21 = (int)((var77 - (long)(3600000 * var20)) / 60000L);
                                             var25 = (int)((var77 - (long)(var20 * 3600000) - (long)(var21 * '\uea60')) / 1000L);
                                             String var50 = var20 + ":" + var21 / 10 + var21 % 10 + ":" + var25 / 10 + var25 % 10;
                                             class36.field808[var6++] = var50;
                                             continue;
                                          }

                                          if(3924 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             class36.field802[var5++] = var94.field3159.field3177;
                                             continue;
                                          }

                                          if(3925 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             class36.field802[var5++] = var94.field3159.field3176;
                                             continue;
                                          }

                                          if(3926 == var16) {
                                             --var5;
                                             var30 = class36.field802[var5];
                                             var94 = (class214)class37.field871.field3183.get(var30);
                                             class36.field802[var5++] = var94.field3159.field3178;
                                             continue;
                                          }
                                       } else {
                                          long var87;
                                          if(var16 < 4100) {
                                             if(4000 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                class36.field802[var5++] = var17 + var30;
                                                continue;
                                             }

                                             if(4001 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                class36.field802[var5++] = var30 - var17;
                                                continue;
                                             }

                                             if(var16 == 4002) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                class36.field802[var5++] = var30 * var17;
                                                continue;
                                             }

                                             if(4003 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                class36.field802[var5++] = var30 / var17;
                                                continue;
                                             }

                                             if(4004 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = (int)(Math.random() * (double)var30);
                                                continue;
                                             }

                                             if(var16 == 4005) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = (int)(Math.random() * (double)(var30 + 1));
                                                continue;
                                             }

                                             if(4006 == var16) {
                                                var5 -= 5;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                var19 = class36.field802[2 + var5];
                                                var23 = class36.field802[var5 + 3];
                                                var20 = class36.field802[var5 + 4];
                                                class36.field802[var5++] = (var17 - var30) * (var20 - var19) / (var23 - var19) + var30;
                                                continue;
                                             }

                                             if(4007 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                class36.field802[var5++] = var30 + var30 * var17 / 100;
                                                continue;
                                             }

                                             if(4008 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                class36.field802[var5++] = var30 | 1 << var17;
                                                continue;
                                             }

                                             if(4009 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                class36.field802[var5++] = var30 & -1 - (1 << var17);
                                                continue;
                                             }

                                             if(var16 == 4010) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                class36.field802[var5++] = 0 != (var30 & 1 << var17)?1:0;
                                                continue;
                                             }

                                             if(var16 == 4011) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                class36.field802[var5++] = var30 % var17;
                                                continue;
                                             }

                                             if(var16 == 4012) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                if(var30 == 0) {
                                                   class36.field802[var5++] = 0;
                                                } else {
                                                   class36.field802[var5++] = (int)Math.pow((double)var30, (double)var17);
                                                }
                                                continue;
                                             }

                                             if(4013 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                if(var30 == 0) {
                                                   class36.field802[var5++] = 0;
                                                } else if(var17 == 0) {
                                                   class36.field802[var5++] = Integer.MAX_VALUE;
                                                } else {
                                                   class36.field802[var5++] = (int)Math.pow((double)var30, 1.0D / (double)var17);
                                                }
                                                continue;
                                             }

                                             if(4014 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                class36.field802[var5++] = var30 & var17;
                                                continue;
                                             }

                                             if(4015 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                class36.field802[var5++] = var30 | var17;
                                                continue;
                                             }

                                             if(4018 == var16) {
                                                var5 -= 3;
                                                var87 = (long)class36.field802[var5];
                                                var77 = (long)class36.field802[var5 + 1];
                                                long var82 = (long)class36.field802[var5 + 2];
                                                class36.field802[var5++] = (int)(var82 * var87 / var77);
                                                continue;
                                             }
                                          } else if(var16 < 4200) {
                                             if(var16 == 4100) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                --var5;
                                                var17 = class36.field802[var5];
                                                class36.field808[var6++] = var31 + var17;
                                                continue;
                                             }

                                             if(var16 == 4101) {
                                                var6 -= 2;
                                                var31 = class36.field808[var6];
                                                var62 = class36.field808[var6 + 1];
                                                class36.field808[var6++] = var31 + var62;
                                                continue;
                                             }

                                             if(4102 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                --var5;
                                                var17 = class36.field802[var5];
                                                class36.field808[var6++] = var31 + class42.method874(var17, true);
                                                continue;
                                             }

                                             if(var16 == 4103) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                class36.field808[var6++] = var31.toLowerCase();
                                                continue;
                                             }

                                             if(var16 == 4104) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var87 = (11745L + (long)var30) * 86400000L;
                                                class36.field806.setTime(new Date(var87));
                                                var23 = class36.field806.get(5);
                                                var20 = class36.field806.get(2);
                                                var21 = class36.field806.get(1);
                                                class36.field808[var6++] = var23 + "-" + class36.field807[var20] + "-" + var21;
                                                continue;
                                             }

                                             if(4105 == var16) {
                                                var6 -= 2;
                                                var31 = class36.field808[var6];
                                                var62 = class36.field808[var6 + 1];
                                                if(class106.field1881.field34 != null && class106.field1881.field34.field2936) {
                                                   class36.field808[var6++] = var62;
                                                   continue;
                                                }

                                                class36.field808[var6++] = var31;
                                                continue;
                                             }

                                             if(var16 == 4106) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field808[var6++] = Integer.toString(var30);
                                                continue;
                                             }

                                             if(4107 == var16) {
                                                var6 -= 2;
                                                var39 = class36.field802;
                                                var17 = var5++;
                                                var23 = class164.method3215(class36.field808[var6], class36.field808[var6 + 1], client.field285);
                                                if(var23 > 0) {
                                                   var29 = 1;
                                                } else if(var23 < 0) {
                                                   var29 = -1;
                                                } else {
                                                   var29 = 0;
                                                }

                                                var39[var17] = var29;
                                                continue;
                                             }

                                             class224 var88;
                                             if(4108 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                var5 -= 2;
                                                var17 = class36.field802[var5];
                                                var19 = class36.field802[1 + var5];
                                                var28 = class8.field147.method3239(var19, 0);
                                                var88 = new class224(var28);
                                                class36.field802[var5++] = var88.method4000(var31, var17);
                                                continue;
                                             }

                                             if(4109 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                var5 -= 2;
                                                var17 = class36.field802[var5];
                                                var19 = class36.field802[var5 + 1];
                                                var28 = class8.field147.method3239(var19, 0);
                                                var88 = new class224(var28);
                                                class36.field802[var5++] = var88.method4023(var31, var17);
                                                continue;
                                             }

                                             if(4110 == var16) {
                                                var6 -= 2;
                                                var31 = class36.field808[var6];
                                                var62 = class36.field808[1 + var6];
                                                --var5;
                                                if(class36.field802[var5] == 1) {
                                                   class36.field808[var6++] = var31;
                                                } else {
                                                   class36.field808[var6++] = var62;
                                                }
                                                continue;
                                             }

                                             if(4111 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                class36.field808[var6++] = class223.method4001(var31);
                                                continue;
                                             }

                                             if(4112 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                --var5;
                                                var17 = class36.field802[var5];
                                                class36.field808[var6++] = var31 + (char)var17;
                                                continue;
                                             }

                                             char var95;
                                             if(4113 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var24 = class36.field802;
                                                var19 = var5++;
                                                var95 = (char)var30;
                                                if(var95 >= 32 && var95 <= 126) {
                                                   var37 = true;
                                                } else if(var95 >= 160 && var95 <= 255) {
                                                   var37 = true;
                                                } else if(8364 != var95 && var95 != 338 && 8212 != var95 && 339 != var95 && var95 != 376) {
                                                   var37 = false;
                                                } else {
                                                   var37 = true;
                                                }

                                                var24[var19] = var37?1:0;
                                                continue;
                                             }

                                             if(var16 == 4114) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class33.method694((char)var30)?1:0;
                                                continue;
                                             }

                                             if(var16 == 4115) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var24 = class36.field802;
                                                var19 = var5++;
                                                var95 = (char)var30;
                                                var37 = var95 >= 65 && var95 <= 90 || var95 >= 97 && var95 <= 122;
                                                var24[var19] = var37?1:0;
                                                continue;
                                             }

                                             if(4116 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var24 = class36.field802;
                                                var19 = var5++;
                                                var95 = (char)var30;
                                                var37 = var95 >= 48 && var95 <= 57;
                                                var24[var19] = var37?1:0;
                                                continue;
                                             }

                                             if(var16 == 4117) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                if(var31 != null) {
                                                   class36.field802[var5++] = var31.length();
                                                } else {
                                                   class36.field802[var5++] = 0;
                                                }
                                                continue;
                                             }

                                             if(4118 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                var5 -= 2;
                                                var17 = class36.field802[var5];
                                                var19 = class36.field802[var5 + 1];
                                                class36.field808[var6++] = var31.substring(var17, var19);
                                                continue;
                                             }

                                             if(4119 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                StringBuilder var83 = new StringBuilder(var31.length());
                                                var40 = false;

                                                for(var23 = 0; var23 < var31.length(); ++var23) {
                                                   var95 = var31.charAt(var23);
                                                   if(var95 == 60) {
                                                      var40 = true;
                                                   } else if(var95 == 62) {
                                                      var40 = false;
                                                   } else if(!var40) {
                                                      var83.append(var95);
                                                   }
                                                }

                                                class36.field808[var6++] = var83.toString();
                                                continue;
                                             }

                                             if(4120 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                --var5;
                                                var17 = class36.field802[var5];
                                                class36.field802[var5++] = var31.indexOf(var17);
                                                continue;
                                             }

                                             if(var16 == 4121) {
                                                var6 -= 2;
                                                var31 = class36.field808[var6];
                                                var62 = class36.field808[var6 + 1];
                                                --var5;
                                                var19 = class36.field802[var5];
                                                class36.field802[var5++] = var31.indexOf(var62, var19);
                                                continue;
                                             }
                                          } else if(var16 < 4300) {
                                             if(var16 == 4200) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field808[var6++] = class9.method128(var30).field1128;
                                                continue;
                                             }

                                             class51 var90;
                                             if(var16 == 4201) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[1 + var5];
                                                var90 = class9.method128(var30);
                                                if(var17 >= 1 && var17 <= 5 && var90.field1130[var17 - 1] != null) {
                                                   class36.field808[var6++] = var90.field1130[var17 - 1];
                                                   continue;
                                                }

                                                class36.field808[var6++] = "";
                                                continue;
                                             }

                                             if(var16 == 4202) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                var90 = class9.method128(var30);
                                                if(var17 >= 1 && var17 <= 5 && var90.field1124[var17 - 1] != null) {
                                                   class36.field808[var6++] = var90.field1124[var17 - 1];
                                                   continue;
                                                }

                                                class36.field808[var6++] = "";
                                                continue;
                                             }

                                             if(4203 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class9.method128(var30).field1111;
                                                continue;
                                             }

                                             if(4204 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class9.method128(var30).field1127 == 1?1:0;
                                                continue;
                                             }

                                             class51 var96;
                                             if(4205 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var96 = class9.method128(var30);
                                                if(var96.field1147 == -1 && var96.field1146 >= 0) {
                                                   class36.field802[var5++] = var96.field1146;
                                                   continue;
                                                }

                                                class36.field802[var5++] = var30;
                                                continue;
                                             }

                                             if(4206 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var96 = class9.method128(var30);
                                                if(var96.field1147 >= 0 && var96.field1146 >= 0) {
                                                   class36.field802[var5++] = var96.field1146;
                                                   continue;
                                                }

                                                class36.field802[var5++] = var30;
                                                continue;
                                             }

                                             if(var16 == 4207) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class9.method128(var30).field1129?1:0;
                                                continue;
                                             }

                                             if(4208 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var96 = class9.method128(var30);
                                                if(-1 == var96.field1109 && var96.field1157 >= 0) {
                                                   class36.field802[var5++] = var96.field1157;
                                                   continue;
                                                }

                                                class36.field802[var5++] = var30;
                                                continue;
                                             }

                                             if(var16 == 4209) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var96 = class9.method128(var30);
                                                if(var96.field1109 >= 0 && var96.field1157 >= 0) {
                                                   class36.field802[var5++] = var96.field1157;
                                                   continue;
                                                }

                                                class36.field802[var5++] = var30;
                                                continue;
                                             }

                                             if(4210 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                --var5;
                                                var17 = class36.field802[var5];
                                                class41.method836(var31, 1 == var17);
                                                class36.field802[var5++] = class5.field95;
                                                continue;
                                             }

                                             if(var16 == 4211) {
                                                if(null != class37.field873 && class48.field1083 < class5.field95) {
                                                   class36.field802[var5++] = class37.field873[++class48.field1083 - 1] & '\uffff';
                                                   continue;
                                                }

                                                class36.field802[var5++] = -1;
                                                continue;
                                             }

                                             if(4212 == var16) {
                                                class48.field1083 = 0;
                                                continue;
                                             }
                                          } else if(var16 < 5100) {
                                             if(5000 == var16) {
                                                class36.field802[var5++] = client.field495;
                                                continue;
                                             }

                                             if(var16 == 5001) {
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

                                             if(5002 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                var5 -= 2;
                                                var17 = class36.field802[var5];
                                                var19 = class36.field802[var5 + 1];
                                                client.field322.method2737(66);
                                                client.field322.method2477(class30.method647(var31) + 2);
                                                client.field322.method2483(var31);
                                                client.field322.method2477(var17 - 1);
                                                client.field322.method2477(var19);
                                                continue;
                                             }

                                             class35 var102;
                                             if(5003 == var16) {
                                                var5 -= 2;
                                                var30 = class36.field802[var5];
                                                var17 = class36.field802[var5 + 1];
                                                var102 = class27.method630(var30, var17);
                                                if(var102 != null) {
                                                   class36.field802[var5++] = var102.field789;
                                                   class36.field802[var5++] = var102.field790;
                                                   class36.field808[var6++] = null != var102.field795?var102.field795:"";
                                                   class36.field808[var6++] = null != var102.field786?var102.field786:"";
                                                   class36.field808[var6++] = null != var102.field791?var102.field791:"";
                                                } else {
                                                   class36.field802[var5++] = -1;
                                                   class36.field802[var5++] = 0;
                                                   class36.field808[var6++] = "";
                                                   class36.field808[var6++] = "";
                                                   class36.field808[var6++] = "";
                                                }
                                                continue;
                                             }

                                             if(var16 == 5004) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                var102 = class107.method2372(var30);
                                                if(var102 != null) {
                                                   class36.field802[var5++] = var102.field787;
                                                   class36.field802[var5++] = var102.field790;
                                                   class36.field808[var6++] = var102.field795 != null?var102.field795:"";
                                                   class36.field808[var6++] = var102.field786 != null?var102.field786:"";
                                                   class36.field808[var6++] = null != var102.field791?var102.field791:"";
                                                } else {
                                                   class36.field802[var5++] = -1;
                                                   class36.field802[var5++] = 0;
                                                   class36.field808[var6++] = "";
                                                   class36.field808[var6++] = "";
                                                   class36.field808[var6++] = "";
                                                }
                                                continue;
                                             }

                                             if(var16 == 5005) {
                                                if(null == class75.field1377) {
                                                   class36.field802[var5++] = -1;
                                                } else {
                                                   class36.field802[var5++] = class75.field1377.field2073;
                                                }
                                                continue;
                                             }

                                             if(5008 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                --var5;
                                                var17 = class36.field802[var5];
                                                var22 = var31.toLowerCase();
                                                byte var93 = 0;
                                                if(var22.startsWith("yellow:")) {
                                                   var93 = 0;
                                                   var31 = var31.substring("yellow:".length());
                                                } else if(var22.startsWith("red:")) {
                                                   var93 = 1;
                                                   var31 = var31.substring("red:".length());
                                                } else if(var22.startsWith("green:")) {
                                                   var93 = 2;
                                                   var31 = var31.substring("green:".length());
                                                } else if(var22.startsWith("cyan:")) {
                                                   var93 = 3;
                                                   var31 = var31.substring("cyan:".length());
                                                } else if(var22.startsWith("purple:")) {
                                                   var93 = 4;
                                                   var31 = var31.substring("purple:".length());
                                                } else if(var22.startsWith("white:")) {
                                                   var93 = 5;
                                                   var31 = var31.substring("white:".length());
                                                } else if(var22.startsWith("flash1:")) {
                                                   var93 = 6;
                                                   var31 = var31.substring("flash1:".length());
                                                } else if(var22.startsWith("flash2:")) {
                                                   var93 = 7;
                                                   var31 = var31.substring("flash2:".length());
                                                } else if(var22.startsWith("flash3:")) {
                                                   var93 = 8;
                                                   var31 = var31.substring("flash3:".length());
                                                } else if(var22.startsWith("glow1:")) {
                                                   var93 = 9;
                                                   var31 = var31.substring("glow1:".length());
                                                } else if(var22.startsWith("glow2:")) {
                                                   var93 = 10;
                                                   var31 = var31.substring("glow2:".length());
                                                } else if(var22.startsWith("glow3:")) {
                                                   var93 = 11;
                                                   var31 = var31.substring("glow3:".length());
                                                } else if(client.field285 != 0) {
                                                   if(var22.startsWith("yellow:")) {
                                                      var93 = 0;
                                                      var31 = var31.substring("yellow:".length());
                                                   } else if(var22.startsWith("red:")) {
                                                      var93 = 1;
                                                      var31 = var31.substring("red:".length());
                                                   } else if(var22.startsWith("green:")) {
                                                      var93 = 2;
                                                      var31 = var31.substring("green:".length());
                                                   } else if(var22.startsWith("cyan:")) {
                                                      var93 = 3;
                                                      var31 = var31.substring("cyan:".length());
                                                   } else if(var22.startsWith("purple:")) {
                                                      var93 = 4;
                                                      var31 = var31.substring("purple:".length());
                                                   } else if(var22.startsWith("white:")) {
                                                      var93 = 5;
                                                      var31 = var31.substring("white:".length());
                                                   } else if(var22.startsWith("flash1:")) {
                                                      var93 = 6;
                                                      var31 = var31.substring("flash1:".length());
                                                   } else if(var22.startsWith("flash2:")) {
                                                      var93 = 7;
                                                      var31 = var31.substring("flash2:".length());
                                                   } else if(var22.startsWith("flash3:")) {
                                                      var93 = 8;
                                                      var31 = var31.substring("flash3:".length());
                                                   } else if(var22.startsWith("glow1:")) {
                                                      var93 = 9;
                                                      var31 = var31.substring("glow1:".length());
                                                   } else if(var22.startsWith("glow2:")) {
                                                      var93 = 10;
                                                      var31 = var31.substring("glow2:".length());
                                                   } else if(var22.startsWith("glow3:")) {
                                                      var93 = 11;
                                                      var31 = var31.substring("glow3:".length());
                                                   }
                                                }

                                                var22 = var31.toLowerCase();
                                                byte var98 = 0;
                                                if(var22.startsWith("wave:")) {
                                                   var98 = 1;
                                                   var31 = var31.substring("wave:".length());
                                                } else if(var22.startsWith("wave2:")) {
                                                   var98 = 2;
                                                   var31 = var31.substring("wave2:".length());
                                                } else if(var22.startsWith("shake:")) {
                                                   var98 = 3;
                                                   var31 = var31.substring("shake:".length());
                                                } else if(var22.startsWith("scroll:")) {
                                                   var98 = 4;
                                                   var31 = var31.substring("scroll:".length());
                                                } else if(var22.startsWith("slide:")) {
                                                   var98 = 5;
                                                   var31 = var31.substring("slide:".length());
                                                } else if(client.field285 != 0) {
                                                   if(var22.startsWith("wave:")) {
                                                      var98 = 1;
                                                      var31 = var31.substring("wave:".length());
                                                   } else if(var22.startsWith("wave2:")) {
                                                      var98 = 2;
                                                      var31 = var31.substring("wave2:".length());
                                                   } else if(var22.startsWith("shake:")) {
                                                      var98 = 3;
                                                      var31 = var31.substring("shake:".length());
                                                   } else if(var22.startsWith("scroll:")) {
                                                      var98 = 4;
                                                      var31 = var31.substring("scroll:".length());
                                                   } else if(var22.startsWith("slide:")) {
                                                      var98 = 5;
                                                      var31 = var31.substring("slide:".length());
                                                   }
                                                }

                                                client.field322.method2737(201);
                                                client.field322.method2477(0);
                                                var21 = client.field322.field2005;
                                                client.field322.method2477(var17);
                                                client.field322.method2477(var93);
                                                client.field322.method2477(var98);
                                                class122 var85 = client.field322;
                                                var66 = var85.field2005;
                                                var73 = var31.length();
                                                byte[] var86 = new byte[var73];

                                                for(int var89 = 0; var89 < var73; ++var89) {
                                                   char var53 = var31.charAt(var89);
                                                   if(var53 > 0 && var53 < 128 || var53 >= 160 && var53 <= 255) {
                                                      var86[var89] = (byte)var53;
                                                   } else if(8364 == var53) {
                                                      var86[var89] = -128;
                                                   } else if(var53 == 8218) {
                                                      var86[var89] = -126;
                                                   } else if(var53 == 402) {
                                                      var86[var89] = -125;
                                                   } else if(var53 == 8222) {
                                                      var86[var89] = -124;
                                                   } else if(var53 == 8230) {
                                                      var86[var89] = -123;
                                                   } else if(8224 == var53) {
                                                      var86[var89] = -122;
                                                   } else if(var53 == 8225) {
                                                      var86[var89] = -121;
                                                   } else if(710 == var53) {
                                                      var86[var89] = -120;
                                                   } else if(8240 == var53) {
                                                      var86[var89] = -119;
                                                   } else if(352 == var53) {
                                                      var86[var89] = -118;
                                                   } else if(var53 == 8249) {
                                                      var86[var89] = -117;
                                                   } else if(var53 == 338) {
                                                      var86[var89] = -116;
                                                   } else if(381 == var53) {
                                                      var86[var89] = -114;
                                                   } else if(var53 == 8216) {
                                                      var86[var89] = -111;
                                                   } else if(var53 == 8217) {
                                                      var86[var89] = -110;
                                                   } else if(var53 == 8220) {
                                                      var86[var89] = -109;
                                                   } else if(8221 == var53) {
                                                      var86[var89] = -108;
                                                   } else if(var53 == 8226) {
                                                      var86[var89] = -107;
                                                   } else if(var53 == 8211) {
                                                      var86[var89] = -106;
                                                   } else if(var53 == 8212) {
                                                      var86[var89] = -105;
                                                   } else if(var53 == 732) {
                                                      var86[var89] = -104;
                                                   } else if(8482 == var53) {
                                                      var86[var89] = -103;
                                                   } else if(353 == var53) {
                                                      var86[var89] = -102;
                                                   } else if(8250 == var53) {
                                                      var86[var89] = -101;
                                                   } else if(339 == var53) {
                                                      var86[var89] = -100;
                                                   } else if(var53 == 382) {
                                                      var86[var89] = -98;
                                                   } else if(var53 == 376) {
                                                      var86[var89] = -97;
                                                   } else {
                                                      var86[var89] = 63;
                                                   }
                                                }

                                                var85.method2490(var86.length);
                                                var85.field2005 += class222.field3187.method2432(var86, 0, var86.length, var85.field2007, var85.field2005);
                                                client.field322.method2562(client.field322.field2005 - var21);
                                                continue;
                                             }

                                             if(var16 == 5009) {
                                                var6 -= 2;
                                                var31 = class36.field808[var6];
                                                var62 = class36.field808[var6 + 1];
                                                client.field322.method2737(212);
                                                client.field322.method2661(0);
                                                var19 = client.field322.field2005;
                                                client.field322.method2483(var31);
                                                class122 var92 = client.field322;
                                                var20 = var92.field2005;
                                                var25 = var62.length();
                                                byte[] var97 = new byte[var25];

                                                for(var78 = 0; var78 < var25; ++var78) {
                                                   char var84 = var62.charAt(var78);
                                                   if(var84 > 0 && var84 < 128 || var84 >= 160 && var84 <= 255) {
                                                      var97[var78] = (byte)var84;
                                                   } else if(8364 == var84) {
                                                      var97[var78] = -128;
                                                   } else if(8218 == var84) {
                                                      var97[var78] = -126;
                                                   } else if(var84 == 402) {
                                                      var97[var78] = -125;
                                                   } else if(var84 == 8222) {
                                                      var97[var78] = -124;
                                                   } else if(var84 == 8230) {
                                                      var97[var78] = -123;
                                                   } else if(8224 == var84) {
                                                      var97[var78] = -122;
                                                   } else if(8225 == var84) {
                                                      var97[var78] = -121;
                                                   } else if(710 == var84) {
                                                      var97[var78] = -120;
                                                   } else if(var84 == 8240) {
                                                      var97[var78] = -119;
                                                   } else if(352 == var84) {
                                                      var97[var78] = -118;
                                                   } else if(8249 == var84) {
                                                      var97[var78] = -117;
                                                   } else if(338 == var84) {
                                                      var97[var78] = -116;
                                                   } else if(var84 == 381) {
                                                      var97[var78] = -114;
                                                   } else if(var84 == 8216) {
                                                      var97[var78] = -111;
                                                   } else if(8217 == var84) {
                                                      var97[var78] = -110;
                                                   } else if(8220 == var84) {
                                                      var97[var78] = -109;
                                                   } else if(var84 == 8221) {
                                                      var97[var78] = -108;
                                                   } else if(var84 == 8226) {
                                                      var97[var78] = -107;
                                                   } else if(8211 == var84) {
                                                      var97[var78] = -106;
                                                   } else if(8212 == var84) {
                                                      var97[var78] = -105;
                                                   } else if(var84 == 732) {
                                                      var97[var78] = -104;
                                                   } else if(var84 == 8482) {
                                                      var97[var78] = -103;
                                                   } else if(var84 == 353) {
                                                      var97[var78] = -102;
                                                   } else if(var84 == 8250) {
                                                      var97[var78] = -101;
                                                   } else if(var84 == 339) {
                                                      var97[var78] = -100;
                                                   } else if(382 == var84) {
                                                      var97[var78] = -98;
                                                   } else if(376 == var84) {
                                                      var97[var78] = -97;
                                                   } else {
                                                      var97[var78] = 63;
                                                   }
                                                }

                                                var92.method2490(var97.length);
                                                var92.field2005 += class222.field3187.method2432(var97, 0, var97.length, var92.field2007, var92.field2005);
                                                client.field322.method2524(client.field322.field2005 - var19);
                                                continue;
                                             }

                                             if(var16 == 5015) {
                                                if(class106.field1881 != null && class106.field1881.field59 != null) {
                                                   var31 = class106.field1881.field59;
                                                } else {
                                                   var31 = "";
                                                }

                                                class36.field808[var6++] = var31;
                                                continue;
                                             }

                                             if(var16 == 5016) {
                                                class36.field802[var5++] = client.field292;
                                                continue;
                                             }

                                             if(5017 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class184.method3594(var30);
                                                continue;
                                             }

                                             if(var16 == 5018) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class72.method1551(var30);
                                                continue;
                                             }

                                             if(5019 == var16) {
                                                --var5;
                                                var30 = class36.field802[var5];
                                                class36.field802[var5++] = class124.method2782(var30);
                                                continue;
                                             }

                                             if(5020 == var16) {
                                                --var6;
                                                var31 = class36.field808[var6];
                                                if(var31.equalsIgnoreCase("toggleroof")) {
                                                   class76.field1388.field148 = !class76.field1388.field148;
                                                   class7.method101();
                                                   if(class76.field1388.field148) {
                                                      class125.method2783(99, "", "Roofs are now all hidden");
                                                   } else {
                                                      class125.method2783(99, "", "Roofs will only be removed selectively");
                                                   }
                                                }

                                                if(var31.equalsIgnoreCase("displayfps")) {
                                                   client.field282 = !client.field282;
                                                }

                                                if(client.field517 >= 2) {
                                                   if(var31.equalsIgnoreCase("fpson")) {
                                                      client.field282 = true;
                                                   }

                                                   if(var31.equalsIgnoreCase("fpsoff")) {
                                                      client.field282 = false;
                                                   }

                                                   if(var31.equalsIgnoreCase("gc")) {
                                                      System.gc();
                                                   }

                                                   if(var31.equalsIgnoreCase("clientdrop")) {
                                                      class115.method2442();
                                                   }

                                                   if(var31.equalsIgnoreCase("errortest") && client.field281 == 2) {
                                                      throw new RuntimeException();
                                                   }
                                                }

                                                client.field322.method2737(146);
                                                client.field322.method2477(var31.length() + 1);
                                                client.field322.method2483(var31);
                                                continue;
                                             }

                                             if(var16 == 5021) {
                                                --var6;
                                                client.field393 = class36.field808[var6].toLowerCase().trim();
                                                continue;
                                             }

                                             if(var16 == 5022) {
                                                class36.field808[var6++] = client.field393;
                                                continue;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var16 >= 2000) {
                              var16 -= 1000;
                              --var5;
                              var33 = class29.method645(class36.field802[var5]);
                           } else {
                              var33 = var32?class141.field2173:class12.field185;
                           }

                           if(1300 == var16) {
                              --var5;
                              var17 = class36.field802[var5] - 1;
                              if(var17 >= 0 && var17 <= 9) {
                                 --var6;
                                 var33.method3377(var17, class36.field808[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var16 == 1301) {
                              var5 -= 2;
                              var17 = class36.field802[var5];
                              var19 = class36.field802[1 + var5];
                              var33.field2871 = class45.method932(var17, var19);
                              continue;
                           }

                           if(1302 == var16) {
                              --var5;
                              var33.field2856 = class36.field802[var5] == 1;
                              continue;
                           }

                           if(var16 == 1303) {
                              --var5;
                              var33.field2841 = class36.field802[var5];
                              continue;
                           }

                           if(var16 == 1304) {
                              --var5;
                              var33.field2842 = class36.field802[var5];
                              continue;
                           }

                           if(var16 == 1305) {
                              --var6;
                              var33.field2789 = class36.field808[var6];
                              continue;
                           }

                           if(var16 == 1306) {
                              --var6;
                              var33.field2844 = class36.field808[var6];
                              continue;
                           }

                           if(1307 == var16) {
                              var33.field2839 = null;
                              continue;
                           }
                        }
                     } else {
                        if(var16 >= 2000) {
                           var16 -= 1000;
                           --var5;
                           var33 = class29.method645(class36.field802[var5]);
                        } else {
                           var33 = var32?class141.field2173:class12.field185;
                        }

                        class34.method701(var33);
                        if(1200 == var16 || 1205 == var16 || var16 == 1212) {
                           var5 -= 2;
                           var17 = class36.field802[var5];
                           var19 = class36.field802[var5 + 1];
                           var33.field2885 = var17;
                           var33.field2780 = var19;
                           class51 var41 = class9.method128(var17);
                           var33.field2816 = var41.field1122;
                           var33.field2817 = var41.field1123;
                           var33.field2818 = var41.field1126;
                           var33.field2859 = var41.field1125;
                           var33.field2815 = var41.field1138;
                           var33.field2819 = var41.field1121;
                           if(1205 == var16) {
                              var33.field2823 = 0;
                           } else if(var16 == 1212 | 1 == var41.field1127) {
                              var33.field2823 = 1;
                           } else {
                              var33.field2823 = 2;
                           }

                           if(var33.field2820 > 0) {
                              var33.field2819 = var33.field2819 * 32 / var33.field2820;
                           } else if(var33.field2776 > 0) {
                              var33.field2819 = var33.field2819 * 32 / var33.field2776;
                           }
                           continue;
                        }

                        if(1201 == var16) {
                           var33.field2788 = 2;
                           --var5;
                           var33.field2830 = class36.field802[var5];
                           continue;
                        }

                        if(1202 == var16) {
                           var33.field2788 = 3;
                           var33.field2830 = class106.field1881.field34.method3491();
                           continue;
                        }
                     }
                  } else {
                     var30 = -1;
                     if(var16 >= 2000) {
                        var16 -= 1000;
                        --var5;
                        var30 = class36.field802[var5];
                        var38 = class29.method645(var30);
                     } else {
                        var38 = var32?class141.field2173:class12.field185;
                     }

                     if(1000 == var16) {
                        var5 -= 4;
                        var38.field2774 = class36.field802[var5];
                        var38.field2775 = class36.field802[var5 + 1];
                        var38.field2770 = class36.field802[var5 + 2];
                        var38.field2810 = class36.field802[3 + var5];
                        class34.method701(var38);
                        class87.method2063(var38);
                        if(-1 != var30 && 0 == var38.field2767) {
                           class125.method2796(class217.field3171[var30 >> 16], var38, false);
                        }
                        continue;
                     }

                     if(var16 == 1001) {
                        var5 -= 4;
                        var38.field2776 = class36.field802[var5];
                        var38.field2777 = class36.field802[1 + var5];
                        var38.field2772 = class36.field802[2 + var5];
                        var38.field2889 = class36.field802[var5 + 3];
                        class34.method701(var38);
                        class87.method2063(var38);
                        if(-1 != var30 && 0 == var38.field2767) {
                           class125.method2796(class217.field3171[var30 >> 16], var38, false);
                        }
                        continue;
                     }

                     if(var16 == 1003) {
                        --var5;
                        var40 = class36.field802[var5] == 1;
                        if(var38.field2773 != var40) {
                           var38.field2773 = var40;
                           class34.method701(var38);
                        }
                        continue;
                     }

                     if(var16 == 1005) {
                        --var5;
                        var38.field2898 = class36.field802[var5] == 1;
                        continue;
                     }

                     if(var16 == 1006) {
                        --var5;
                        var38.field2877 = class36.field802[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var16 < 5400) {
                  if(var16 == 5306) {
                     var39 = class36.field802;
                     var17 = var5++;
                     var19 = client.field336?2:1;
                     var39[var17] = var19;
                     continue;
                  }

                  if(var16 == 5307) {
                     --var5;
                     var30 = class36.field802[var5];
                     if(var30 == 1 || 2 == var30) {
                        class9.method127(var30);
                     }
                     continue;
                  }

                  if(var16 == 5308) {
                     class36.field802[var5++] = class76.field1388.field144;
                     continue;
                  }

                  if(5309 == var16) {
                     --var5;
                     var30 = class36.field802[var5];
                     if(var30 == 1 || var30 == 2) {
                        class76.field1388.field144 = var30;
                        class7.method101();
                     }
                     continue;
                  }
               }

               if(var16 < 5600) {
                  if(var16 == 5504) {
                     var5 -= 2;
                     var30 = class36.field802[var5];
                     var17 = class36.field802[var5 + 1];
                     if(!client.field558) {
                        client.field363 = var30;
                        client.field364 = var17;
                     }
                     continue;
                  }

                  if(5505 == var16) {
                     class36.field802[var5++] = client.field363;
                     continue;
                  }

                  if(5506 == var16) {
                     class36.field802[var5++] = client.field364;
                     continue;
                  }

                  if(var16 == 5530) {
                     --var5;
                     var30 = class36.field802[var5];
                     if(var30 < 0) {
                        var30 = 0;
                     }

                     client.field369 = var30;
                     continue;
                  }

                  if(var16 == 5531) {
                     class36.field802[var5++] = client.field369;
                     continue;
                  }
               }

               if(var16 < 5700 && 5630 == var16) {
                  client.field332 = 250;
               } else {
                  if(var16 < 6300) {
                     if(var16 == 6200) {
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

                     if(6201 == var16) {
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

                     if(6202 == var16) {
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

                     if(var16 == 6203) {
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

                     if(6204 == var16) {
                        class36.field802[var5++] = client.field533;
                        class36.field802[var5++] = client.field536;
                        continue;
                     }

                     if(6205 == var16) {
                        class36.field802[var5++] = client.field554;
                        class36.field802[var5++] = client.field534;
                        continue;
                     }
                  }

                  if(var16 < 6600) {
                     if(var16 == 6500) {
                        class36.field802[var5++] = class38.method734()?1:0;
                        continue;
                     }

                     class25 var61;
                     if(var16 == 6501) {
                        class25.field629 = 0;
                        var61 = class56.method1203();
                        if(null != var61) {
                           class36.field802[var5++] = var61.field632;
                           class36.field802[var5++] = var61.field633;
                           class36.field808[var6++] = var61.field641;
                           class36.field802[var5++] = var61.field637;
                           class36.field802[var5++] = var61.field634;
                           class36.field808[var6++] = var61.field635;
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

                     if(var16 == 6502) {
                        var61 = class56.method1203();
                        if(var61 != null) {
                           class36.field802[var5++] = var61.field632;
                           class36.field802[var5++] = var61.field633;
                           class36.field808[var6++] = var61.field641;
                           class36.field802[var5++] = var61.field637;
                           class36.field802[var5++] = var61.field634;
                           class36.field808[var6++] = var61.field635;
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

                     class25 var70;
                     if(var16 == 6506) {
                        --var5;
                        var30 = class36.field802[var5];
                        var70 = null;

                        for(var19 = 0; var19 < class25.field628; ++var19) {
                           if(class25.field636[var19].field632 == var30) {
                              var70 = class25.field636[var19];
                              break;
                           }
                        }

                        if(null != var70) {
                           class36.field802[var5++] = var70.field632;
                           class36.field802[var5++] = var70.field633;
                           class36.field808[var6++] = var70.field641;
                           class36.field802[var5++] = var70.field637;
                           class36.field802[var5++] = var70.field634;
                           class36.field808[var6++] = var70.field635;
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

                     if(var16 == 6507) {
                        var5 -= 4;
                        var30 = class36.field802[var5];
                        var36 = 1 == class36.field802[var5 + 1];
                        var19 = class36.field802[2 + var5];
                        var37 = 1 == class36.field802[3 + var5];
                        class77.method1662(var30, var36, var19, var37);
                        continue;
                     }

                     if(6511 == var16) {
                        --var5;
                        var30 = class36.field802[var5];
                        if(var30 >= 0 && var30 < class25.field628) {
                           var70 = class25.field636[var30];
                           class36.field802[var5++] = var70.field632;
                           class36.field802[var5++] = var70.field633;
                           class36.field808[var6++] = var70.field641;
                           class36.field802[var5++] = var70.field637;
                           class36.field802[var5++] = var70.field634;
                           class36.field808[var6++] = var70.field635;
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
         } catch (Exception var54) {
            StringBuilder var13 = new StringBuilder(30);
            var13.append("").append(var4.field3125).append(" ");

            for(var11 = class36.field804 - 1; var11 >= 0; --var11) {
               var13.append("").append(class36.field805[var11].field200.field3125).append(" ");
            }

            var13.append("").append(var10);
            class90.method2067(var13.toString(), var54);
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
               int var7;
               if(var3.field2812 != -1 || var3.field2813 != -1) {
                  boolean var5 = class127.method2809(var3);
                  if(var5) {
                     var7 = var3.field2813;
                  } else {
                     var7 = var3.field2812;
                  }

                  if(-1 != var7) {
                     class42 var6 = class4.method42(var7);

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
                  var7 = var3.field2821 << 16 >> 16;
                  var8 *= client.field356;
                  var7 *= client.field356;
                  var3.field2816 = var8 + var3.field2816 & 2047;
                  var3.field2817 = var3.field2817 + var7 & 2047;
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
      if(var3 < 0 || 0 != class167.field2681 && var3 > class167.field2681) {
         throw new RuntimeException();
      } else if(var2 == 0) {
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
   }
}

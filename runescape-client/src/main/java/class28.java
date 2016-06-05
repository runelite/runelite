import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("rn")
   protected static boolean field670;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1483225635
   )
   @Export("quantity")
   int field671;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = 1367319911
   )
   static int field672;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -860245285
   )
   @Export("id")
   int field677;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   protected final class105 vmethod1862() {
      return class123.method2743(this.field677).method998(this.field671);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "624021070"
   )
   public static void method634(int var0) {
      if(var0 != -1) {
         if(class173.field2800[var0]) {
            class173.field2853.method3233(var0);
            if(null != class216.field3168[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class216.field3168[var0].length; ++var2) {
                  if(null != class216.field3168[var0][var2]) {
                     if(class216.field3168[var0][var2].field2778 != 2) {
                        class216.field3168[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class216.field3168[var0] = null;
               }

               class173.field2800[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "200000"
   )
   static void method637(class0 var0, int var1) {
      Object[] var2 = var0.field5;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class6.method84(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field580;
         int[] var9 = var4.field586;
         byte var10 = -1;
         class36.field802 = 0;

         int var13;
         try {
            class216.field3167 = new int[var4.field583];
            int var11 = 0;
            class84.field1461 = new String[var4.field584];
            int var12 = 0;

            int var14;
            String var26;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field6;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = null != var0.field2?var0.field2.field2776:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field12;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field2?var0.field2.field2777:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field10?var0.field10.field2776:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field10?var0.field10.field2777:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class216.field3167[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var26 = (String)var2[var13];
                  if(var26.equals("event_opbase")) {
                     var26 = var0.field9;
                  }

                  class84.field1461[var12++] = var26;
               }
            }

            var13 = 0;
            class36.field799 = var0.field17;

            label3470:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var39 = var8[var7];
               int var15;
               String var17;
               int var19;
               int var21;
               int var27;
               int var33;
               int[] var42;
               byte[] var53;
               int var54;
               int var73;
               String var81;
               String var87;
               if(var39 < 100) {
                  if(var39 == 0) {
                     class36.field789[var5++] = var9[var7];
                     continue;
                  }

                  if(var39 == 1) {
                     var14 = var9[var7];
                     class36.field789[var5++] = class176.field2923[var14];
                     continue;
                  }

                  if(var39 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2923[var14] = class36.field789[var5];
                     class76.method1635(var14);
                     continue;
                  }

                  if(var39 == 3) {
                     class36.field796[var6++] = var4.field582[var7];
                     continue;
                  }

                  if(var39 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var39 == 7) {
                     var5 -= 2;
                     if(class36.field789[var5] != class36.field789[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 8) {
                     var5 -= 2;
                     if(class36.field789[var5] == class36.field789[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 9) {
                     var5 -= 2;
                     if(class36.field789[var5] < class36.field789[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 10) {
                     var5 -= 2;
                     if(class36.field789[var5] > class36.field789[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 21) {
                     if(class36.field802 == 0) {
                        return;
                     }

                     class14 var70 = class36.field792[--class36.field802];
                     var4 = var70.field215;
                     var8 = var4.field580;
                     var9 = var4.field586;
                     var7 = var70.field210;
                     class216.field3167 = var70.field211;
                     class84.field1461 = var70.field212;
                     continue;
                  }

                  if(var39 == 25) {
                     var14 = var9[var7];
                     class36.field789[var5++] = class13.method144(var14);
                     continue;
                  }

                  if(var39 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field789[var5];
                     class47 var64 = (class47)class47.field1072.method3716((long)var14);
                     class47 var76;
                     if(null != var64) {
                        var76 = var64;
                     } else {
                        var53 = class47.field1076.method3221(14, var14);
                        var64 = new class47();
                        if(var53 != null) {
                           var64.method950(new class119(var53));
                        }

                        class47.field1072.method3724(var64, (long)var14);
                        var76 = var64;
                     }

                     var27 = var76.field1073;
                     var19 = var76.field1074;
                     var54 = var76.field1078;
                     var21 = class176.field2926[var54 - var19];
                     if(var15 < 0 || var15 > var21) {
                        var15 = 0;
                     }

                     var21 <<= var19;
                     class176.field2923[var27] = class176.field2923[var27] & ~var21 | var15 << var19 & var21;
                     continue;
                  }

                  if(var39 == 31) {
                     var5 -= 2;
                     if(class36.field789[var5] <= class36.field789[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 32) {
                     var5 -= 2;
                     if(class36.field789[var5] >= class36.field789[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 33) {
                     class36.field789[var5++] = class216.field3167[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var39 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class216.field3167[var10001] = class36.field789[var5];
                     continue;
                  }

                  if(var39 == 35) {
                     class36.field796[var6++] = class84.field1461[var9[var7]];
                     continue;
                  }

                  if(var39 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class84.field1461[var10001] = class36.field796[var6];
                     continue;
                  }

                  if(var39 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var75 = class36.field796;
                     if(var14 == 0) {
                        var87 = "";
                     } else if(var14 == 1) {
                        var17 = var75[var6];
                        if(null == var17) {
                           var87 = "null";
                        } else {
                           var87 = var17.toString();
                        }
                     } else {
                        var73 = var14 + var6;
                        var27 = 0;

                        for(var19 = var6; var19 < var73; ++var19) {
                           String var77 = var75[var19];
                           if(null == var77) {
                              var27 += 4;
                           } else {
                              var27 += var77.length();
                           }
                        }

                        StringBuilder var98 = new StringBuilder(var27);

                        for(var54 = var6; var54 < var73; ++var54) {
                           var81 = var75[var54];
                           if(var81 == null) {
                              var98.append("null");
                           } else {
                              var98.append(var81);
                           }
                        }

                        var87 = var98.toString();
                     }

                     class36.field796[var6++] = var87;
                     continue;
                  }

                  if(var39 == 38) {
                     --var5;
                     continue;
                  }

                  if(var39 == 39) {
                     --var6;
                     continue;
                  }

                  if(var39 == 40) {
                     var14 = var9[var7];
                     class22 var103 = class6.method84(var14);
                     var42 = new int[var103.field583];
                     String[] var63 = new String[var103.field584];

                     for(var27 = 0; var27 < var103.field585; ++var27) {
                        var42[var27] = class36.field789[var27 + (var5 - var103.field585)];
                     }

                     for(var27 = 0; var27 < var103.field594; ++var27) {
                        var63[var27] = class36.field796[var27 + (var6 - var103.field594)];
                     }

                     var5 -= var103.field585;
                     var6 -= var103.field594;
                     class14 var82 = new class14();
                     var82.field215 = var4;
                     var82.field210 = var7;
                     var82.field211 = class216.field3167;
                     var82.field212 = class84.field1461;
                     class36.field792[++class36.field802 - 1] = var82;
                     var4 = var103;
                     var8 = var103.field580;
                     var9 = var103.field586;
                     var7 = -1;
                     class216.field3167 = var42;
                     class84.field1461 = var63;
                     continue;
                  }

                  if(var39 == 42) {
                     class36.field789[var5++] = class106.field1879.method181(var9[var7]);
                     continue;
                  }

                  if(var39 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class106.field1879.method180(var10001, class36.field789[var5]);
                     continue;
                  }

                  if(var39 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var33 = class36.field789[var5];
                     if(var33 >= 0 && var33 <= 5000) {
                        class36.field785[var14] = var33;
                        byte var99 = -1;
                        if(var15 == 105) {
                           var99 = 0;
                        }

                        var27 = 0;

                        while(true) {
                           if(var27 >= var33) {
                              continue label3470;
                           }

                           class36.field788[var14][var27] = var99;
                           ++var27;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var39 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field789[var5];
                     if(var15 >= 0 && var15 < class36.field785[var14]) {
                        class36.field789[var5++] = class36.field788[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var39 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class36.field789[var5];
                     if(var15 >= 0 && var15 < class36.field785[var14]) {
                        class36.field788[var14][var15] = class36.field789[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var39 == 47) {
                     var26 = class106.field1879.method183(var9[var7]);
                     if(var26 == null) {
                        var26 = "null";
                     }

                     class36.field796[var6++] = var26;
                     continue;
                  }

                  if(var39 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class106.field1879.method182(var10001, class36.field796[var6]);
                     continue;
                  }
               }

               boolean var51;
               if(var9[var7] == 1) {
                  var51 = true;
               } else {
                  var51 = false;
               }

               class173 var16;
               class173 var18;
               class173 var28;
               class173 var40;
               boolean var69;
               boolean var91;
               if(var39 < 1000) {
                  if(var39 == 100) {
                     var5 -= 3;
                     var15 = class36.field789[var5];
                     var33 = class36.field789[var5 + 1];
                     var73 = class36.field789[2 + var5];
                     if(var33 == 0) {
                        throw new RuntimeException();
                     }

                     var18 = class170.method3344(var15);
                     if(null == var18.field2770) {
                        var18.field2770 = new class173[var73 + 1];
                     }

                     if(var18.field2770.length <= var73) {
                        class173[] var96 = new class173[1 + var73];

                        for(var54 = 0; var54 < var18.field2770.length; ++var54) {
                           var96[var54] = var18.field2770[var54];
                        }

                        var18.field2770 = var96;
                     }

                     if(var73 > 0 && null == var18.field2770[var73 - 1]) {
                        throw new RuntimeException("" + (var73 - 1));
                     }

                     class173 var97 = new class173();
                     var97.field2778 = var33;
                     var97.field2795 = var97.field2776 = var18.field2776;
                     var97.field2777 = var73;
                     var97.field2775 = true;
                     var18.field2770[var73] = var97;
                     if(var51) {
                        class178.field2935 = var97;
                     } else {
                        class36.field793 = var97;
                     }

                     class20.method547(var18);
                     continue;
                  }

                  if(var39 == 101) {
                     var28 = var51?class178.field2935:class36.field793;
                     var16 = class170.method3344(var28.field2776);
                     var16.field2770[var28.field2777] = null;
                     class20.method547(var16);
                     continue;
                  }

                  if(var39 == 102) {
                     --var5;
                     var28 = class170.method3344(class36.field789[var5]);
                     var28.field2770 = null;
                     class20.method547(var28);
                     continue;
                  }

                  if(var39 == 200) {
                     var5 -= 2;
                     var15 = class36.field789[var5];
                     var33 = class36.field789[var5 + 1];
                     var40 = class74.method1561(var15, var33);
                     if(null != var40 && var33 != -1) {
                        class36.field789[var5++] = 1;
                        if(var51) {
                           class178.field2935 = var40;
                        } else {
                           class36.field793 = var40;
                        }
                        continue;
                     }

                     class36.field789[var5++] = 0;
                     continue;
                  }

                  if(var39 == 201) {
                     --var5;
                     var28 = class170.method3344(class36.field789[var5]);
                     if(var28 != null) {
                        class36.field789[var5++] = 1;
                        if(var51) {
                           class178.field2935 = var28;
                        } else {
                           class36.field793 = var28;
                        }
                     } else {
                        class36.field789[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var29;
                  if((var39 < 1000 || var39 >= 1100) && (var39 < 2000 || var39 >= 2100)) {
                     if(var39 >= 1100 && var39 < 1200 || var39 >= 2100 && var39 < 2200) {
                        var33 = -1;
                        if(var39 >= 2000) {
                           var39 -= 1000;
                           --var5;
                           var33 = class36.field789[var5];
                           var28 = class170.method3344(var33);
                        } else {
                           var28 = var51?class178.field2935:class36.field793;
                        }

                        if(var39 == 1100) {
                           var5 -= 2;
                           var28.field2835 = class36.field789[var5];
                           if(var28.field2835 > var28.field2894 - var28.field2791) {
                              var28.field2835 = var28.field2894 - var28.field2791;
                           }

                           if(var28.field2835 < 0) {
                              var28.field2835 = 0;
                           }

                           var28.field2861 = class36.field789[var5 + 1];
                           if(var28.field2861 > var28.field2823 - var28.field2792) {
                              var28.field2861 = var28.field2823 - var28.field2792;
                           }

                           if(var28.field2861 < 0) {
                              var28.field2861 = 0;
                           }

                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1101) {
                           --var5;
                           var28.field2797 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1102) {
                           --var5;
                           var28.field2895 = class36.field789[var5] == 1;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1103) {
                           --var5;
                           var28.field2807 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1104) {
                           --var5;
                           var28.field2809 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1105) {
                           --var5;
                           var28.field2811 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1106) {
                           --var5;
                           var28.field2857 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1107) {
                           --var5;
                           var28.field2814 = class36.field789[var5] == 1;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1108) {
                           var28.field2871 = 1;
                           --var5;
                           var28.field2829 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1109) {
                           var5 -= 6;
                           var28.field2843 = class36.field789[var5];
                           var28.field2826 = class36.field789[1 + var5];
                           var28.field2789 = class36.field789[2 + var5];
                           var28.field2798 = class36.field789[3 + var5];
                           var28.field2799 = class36.field789[4 + var5];
                           var28.field2830 = class36.field789[var5 + 5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1110) {
                           --var5;
                           var73 = class36.field789[var5];
                           if(var73 != var28.field2893) {
                              var28.field2893 = var73;
                              var28.field2898 = 0;
                              var28.field2767 = 0;
                              class20.method547(var28);
                           }
                           continue;
                        }

                        if(var39 == 1111) {
                           --var5;
                           var28.field2855 = class36.field789[var5] == 1;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1112) {
                           --var6;
                           var17 = class36.field796[var6];
                           if(!var17.equals(var28.field2832)) {
                              var28.field2832 = var17;
                              class20.method547(var28);
                           }
                           continue;
                        }

                        if(var39 == 1113) {
                           --var5;
                           var28.field2877 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1114) {
                           var5 -= 3;
                           var28.field2839 = class36.field789[var5];
                           var28.field2840 = class36.field789[1 + var5];
                           var28.field2838 = class36.field789[var5 + 2];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1115) {
                           --var5;
                           var28.field2841 = class36.field789[var5] == 1;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1116) {
                           --var5;
                           var28.field2769 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1117) {
                           --var5;
                           var28.field2816 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1118) {
                           --var5;
                           var28.field2867 = class36.field789[var5] == 1;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1119) {
                           --var5;
                           var28.field2818 = class36.field789[var5] == 1;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1120) {
                           var5 -= 2;
                           var28.field2894 = class36.field789[var5];
                           var28.field2823 = class36.field789[var5 + 1];
                           class20.method547(var28);
                           if(var33 != -1 && var28.field2778 == 0) {
                              class46.method935(class216.field3168[var33 >> 16], var28, false);
                           }
                           continue;
                        }

                        if(var39 == 1121) {
                           class178.method3422(var28.field2776, var28.field2777);
                           client.field399 = var28;
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1122) {
                           --var5;
                           var28.field2907 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1123) {
                           --var5;
                           var28.field2802 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1124) {
                           --var5;
                           var28.field2785 = class36.field789[var5];
                           class20.method547(var28);
                           continue;
                        }

                        if(var39 == 1125) {
                           --var5;
                           var73 = class36.field789[var5];
                           class82 var78 = (class82)class30.method651(class170.method3345(), var73);
                           if(var78 != null) {
                              var28.field2806 = var78;
                              class20.method547(var28);
                           }
                           continue;
                        }
                     } else if(var39 >= 1200 && var39 < 1300 || var39 >= 2200 && var39 < 2300) {
                        if(var39 >= 2000) {
                           var39 -= 1000;
                           --var5;
                           var28 = class170.method3344(class36.field789[var5]);
                        } else {
                           var28 = var51?class178.field2935:class36.field793;
                        }

                        class20.method547(var28);
                        if(var39 == 1200 || var39 == 1205 || var39 == 1212) {
                           var5 -= 2;
                           var33 = class36.field789[var5];
                           var73 = class36.field789[1 + var5];
                           var28.field2896 = var33;
                           var28.field2897 = var73;
                           class51 var74 = class123.method2743(var33);
                           var28.field2789 = var74.field1126;
                           var28.field2798 = var74.field1127;
                           var28.field2799 = var74.field1144;
                           var28.field2843 = var74.field1110;
                           var28.field2826 = var74.field1130;
                           var28.field2830 = var74.field1111;
                           if(var39 == 1205) {
                              var28.field2834 = 0;
                           } else if(var39 == 1212 | var74.field1131 == 1) {
                              var28.field2834 = 1;
                           } else {
                              var28.field2834 = 2;
                           }

                           if(var28.field2865 > 0) {
                              var28.field2830 = var28.field2830 * 32 / var28.field2865;
                           } else if(var28.field2787 > 0) {
                              var28.field2830 = var28.field2830 * 32 / var28.field2787;
                           }
                           continue;
                        }

                        if(var39 == 1201) {
                           var28.field2871 = 2;
                           --var5;
                           var28.field2829 = class36.field789[var5];
                           continue;
                        }

                        if(var39 == 1202) {
                           var28.field2871 = 3;
                           var28.field2829 = class152.field2301.field59.method3438();
                           continue;
                        }
                     } else if((var39 < 1300 || var39 >= 1400) && (var39 < 2300 || var39 >= 2400)) {
                        String var46;
                        if(var39 >= 1400 && var39 < 1500 || var39 >= 2400 && var39 < 2500) {
                           if(var39 >= 2000) {
                              var39 -= 1000;
                              --var5;
                              var28 = class170.method3344(class36.field789[var5]);
                           } else {
                              var28 = var51?class178.field2935:class36.field793;
                           }

                           --var6;
                           var46 = class36.field796[var6];
                           int[] var56 = null;
                           if(var46.length() > 0 && var46.charAt(var46.length() - 1) == 89) {
                              --var5;
                              var27 = class36.field789[var5];
                              if(var27 > 0) {
                                 for(var56 = new int[var27]; var27-- > 0; var56[var27] = class36.field789[var5]) {
                                    --var5;
                                 }
                              }

                              var46 = var46.substring(0, var46.length() - 1);
                           }

                           Object[] var59 = new Object[var46.length() + 1];

                           for(var19 = var59.length - 1; var19 >= 1; --var19) {
                              if(var46.charAt(var19 - 1) == 115) {
                                 --var6;
                                 var59[var19] = class36.field796[var6];
                              } else {
                                 --var5;
                                 var59[var19] = new Integer(class36.field789[var5]);
                              }
                           }

                           --var5;
                           var19 = class36.field789[var5];
                           if(var19 != -1) {
                              var59[0] = new Integer(var19);
                           } else {
                              var59 = null;
                           }

                           if(var39 == 1400) {
                              var28.field2858 = var59;
                           }

                           if(var39 == 1401) {
                              var28.field2828 = var59;
                           }

                           if(var39 == 1402) {
                              var28.field2860 = var59;
                           }

                           if(var39 == 1403) {
                              var28.field2862 = var59;
                           }

                           if(var39 == 1404) {
                              var28.field2864 = var59;
                           }

                           if(var39 == 1405) {
                              var28.field2790 = var59;
                           }

                           if(var39 == 1406) {
                              var28.field2825 = var59;
                           }

                           if(var39 == 1407) {
                              var28.field2899 = var59;
                              var28.field2900 = var56;
                           }

                           if(var39 == 1408) {
                              var28.field2819 = var59;
                           }

                           if(var39 == 1409) {
                              var28.field2847 = var59;
                           }

                           if(var39 == 1410) {
                              var28.field2866 = var59;
                           }

                           if(var39 == 1411) {
                              var28.field2859 = var59;
                           }

                           if(var39 == 1412) {
                              var28.field2863 = var59;
                           }

                           if(var39 == 1414) {
                              var28.field2773 = var59;
                              var28.field2901 = var56;
                           }

                           if(var39 == 1415) {
                              var28.field2902 = var59;
                              var28.field2874 = var56;
                           }

                           if(var39 == 1416) {
                              var28.field2870 = var59;
                           }

                           if(var39 == 1417) {
                              var28.field2873 = var59;
                           }

                           if(var39 == 1418) {
                              var28.field2808 = var59;
                           }

                           if(var39 == 1419) {
                              var28.field2879 = var59;
                           }

                           if(var39 == 1420) {
                              var28.field2880 = var59;
                           }

                           if(var39 == 1421) {
                              var28.field2881 = var59;
                           }

                           if(var39 == 1422) {
                              var28.field2882 = var59;
                           }

                           if(var39 == 1423) {
                              var28.field2883 = var59;
                           }

                           if(var39 == 1424) {
                              var28.field2884 = var59;
                           }

                           if(var39 == 1425) {
                              var28.field2886 = var59;
                           }

                           if(var39 == 1426) {
                              var28.field2887 = var59;
                           }

                           if(var39 == 1427) {
                              var28.field2885 = var59;
                           }

                           var28.field2856 = true;
                           continue;
                        }

                        if(var39 < 1600) {
                           var28 = var51?class178.field2935:class36.field793;
                           if(var39 == 1500) {
                              class36.field789[var5++] = var28.field2876;
                              continue;
                           }

                           if(var39 == 1501) {
                              class36.field789[var5++] = var28.field2801;
                              continue;
                           }

                           if(var39 == 1502) {
                              class36.field789[var5++] = var28.field2791;
                              continue;
                           }

                           if(var39 == 1503) {
                              class36.field789[var5++] = var28.field2792;
                              continue;
                           }

                           if(var39 == 1504) {
                              class36.field789[var5++] = var28.field2875?1:0;
                              continue;
                           }

                           if(var39 == 1505) {
                              class36.field789[var5++] = var28.field2795;
                              continue;
                           }
                        } else if(var39 < 1700) {
                           var28 = var51?class178.field2935:class36.field793;
                           if(var39 == 1600) {
                              class36.field789[var5++] = var28.field2835;
                              continue;
                           }

                           if(var39 == 1601) {
                              class36.field789[var5++] = var28.field2861;
                              continue;
                           }

                           if(var39 == 1602) {
                              class36.field796[var6++] = var28.field2832;
                              continue;
                           }

                           if(var39 == 1603) {
                              class36.field789[var5++] = var28.field2894;
                              continue;
                           }

                           if(var39 == 1604) {
                              class36.field789[var5++] = var28.field2823;
                              continue;
                           }

                           if(var39 == 1605) {
                              class36.field789[var5++] = var28.field2830;
                              continue;
                           }

                           if(var39 == 1606) {
                              class36.field789[var5++] = var28.field2789;
                              continue;
                           }

                           if(var39 == 1607) {
                              class36.field789[var5++] = var28.field2799;
                              continue;
                           }

                           if(var39 == 1608) {
                              class36.field789[var5++] = var28.field2798;
                              continue;
                           }

                           if(var39 == 1609) {
                              class36.field789[var5++] = var28.field2807;
                              continue;
                           }

                           if(var39 == 1610) {
                              class36.field789[var5++] = var28.field2785;
                              continue;
                           }

                           if(var39 == 1611) {
                              class36.field789[var5++] = var28.field2797;
                              continue;
                           }

                           if(var39 == 1612) {
                              class36.field789[var5++] = var28.field2802;
                              continue;
                           }

                           if(var39 == 1613) {
                              class36.field789[var5++] = var28.field2806.vmethod3145();
                              continue;
                           }
                        } else if(var39 < 1800) {
                           var28 = var51?class178.field2935:class36.field793;
                           if(var39 == 1700) {
                              class36.field789[var5++] = var28.field2896;
                              continue;
                           }

                           if(var39 == 1701) {
                              if(var28.field2896 != -1) {
                                 class36.field789[var5++] = var28.field2897;
                              } else {
                                 class36.field789[var5++] = 0;
                              }
                              continue;
                           }

                           if(var39 == 1702) {
                              class36.field789[var5++] = var28.field2777;
                              continue;
                           }
                        } else if(var39 < 1900) {
                           var28 = var51?class178.field2935:class36.field793;
                           if(var39 == 1800) {
                              var42 = class36.field789;
                              var73 = var5++;
                              var19 = class138.method2906(var28);
                              var27 = var19 >> 11 & 63;
                              var42[var73] = var27;
                              continue;
                           }

                           if(var39 == 1801) {
                              --var5;
                              var33 = class36.field789[var5];
                              --var33;
                              if(var28.field2850 != null && var33 < var28.field2850.length && null != var28.field2850[var33]) {
                                 class36.field796[var6++] = var28.field2850[var33];
                                 continue;
                              }

                              class36.field796[var6++] = "";
                              continue;
                           }

                           if(var39 == 1802) {
                              if(null == var28.field2833) {
                                 class36.field796[var6++] = "";
                              } else {
                                 class36.field796[var6++] = var28.field2833;
                              }
                              continue;
                           }
                        } else if(var39 >= 1900 && var39 < 2000 || var39 >= 2900 && var39 < 3000) {
                           if(var39 >= 2000) {
                              var39 -= 1000;
                              --var5;
                              var28 = class170.method3344(class36.field789[var5]);
                           } else {
                              var28 = var51?class178.field2935:class36.field793;
                           }

                           if(var39 == 1927) {
                              if(class36.field799 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(null == var28.field2885) {
                                 return;
                              }

                              class0 var68 = new class0();
                              var68.field2 = var28;
                              var68.field5 = var28.field2885;
                              var68.field17 = 1 + class36.field799;
                              client.field395.method3771(var0);
                              continue;
                           }
                        } else if(var39 < 2600) {
                           --var5;
                           var28 = class170.method3344(class36.field789[var5]);
                           if(var39 == 2500) {
                              class36.field789[var5++] = var28.field2876;
                              continue;
                           }

                           if(var39 == 2501) {
                              class36.field789[var5++] = var28.field2801;
                              continue;
                           }

                           if(var39 == 2502) {
                              class36.field789[var5++] = var28.field2791;
                              continue;
                           }

                           if(var39 == 2503) {
                              class36.field789[var5++] = var28.field2792;
                              continue;
                           }

                           if(var39 == 2504) {
                              class36.field789[var5++] = var28.field2875?1:0;
                              continue;
                           }

                           if(var39 == 2505) {
                              class36.field789[var5++] = var28.field2795;
                              continue;
                           }
                        } else if(var39 < 2700) {
                           --var5;
                           var28 = class170.method3344(class36.field789[var5]);
                           if(var39 == 2600) {
                              class36.field789[var5++] = var28.field2835;
                              continue;
                           }

                           if(var39 == 2601) {
                              class36.field789[var5++] = var28.field2861;
                              continue;
                           }

                           if(var39 == 2602) {
                              class36.field796[var6++] = var28.field2832;
                              continue;
                           }

                           if(var39 == 2603) {
                              class36.field789[var5++] = var28.field2894;
                              continue;
                           }

                           if(var39 == 2604) {
                              class36.field789[var5++] = var28.field2823;
                              continue;
                           }

                           if(var39 == 2605) {
                              class36.field789[var5++] = var28.field2830;
                              continue;
                           }

                           if(var39 == 2606) {
                              class36.field789[var5++] = var28.field2789;
                              continue;
                           }

                           if(var39 == 2607) {
                              class36.field789[var5++] = var28.field2799;
                              continue;
                           }

                           if(var39 == 2608) {
                              class36.field789[var5++] = var28.field2798;
                              continue;
                           }

                           if(var39 == 2609) {
                              class36.field789[var5++] = var28.field2807;
                              continue;
                           }

                           if(var39 == 2610) {
                              class36.field789[var5++] = var28.field2785;
                              continue;
                           }

                           if(var39 == 2611) {
                              class36.field789[var5++] = var28.field2797;
                              continue;
                           }

                           if(var39 == 2612) {
                              class36.field789[var5++] = var28.field2802;
                              continue;
                           }

                           if(var39 == 2613) {
                              class36.field789[var5++] = var28.field2806.vmethod3145();
                              continue;
                           }
                        } else if(var39 < 2800) {
                           if(var39 == 2700) {
                              --var5;
                              var28 = class170.method3344(class36.field789[var5]);
                              class36.field789[var5++] = var28.field2896;
                              continue;
                           }

                           if(var39 == 2701) {
                              --var5;
                              var28 = class170.method3344(class36.field789[var5]);
                              if(var28.field2896 != -1) {
                                 class36.field789[var5++] = var28.field2897;
                              } else {
                                 class36.field789[var5++] = 0;
                              }
                              continue;
                           }

                           if(var39 == 2702) {
                              --var5;
                              var15 = class36.field789[var5];
                              class3 var44 = (class3)client.field443.method3748((long)var15);
                              if(null != var44) {
                                 class36.field789[var5++] = 1;
                              } else {
                                 class36.field789[var5++] = 0;
                              }
                              continue;
                           }

                           if(var39 == 2706) {
                              class36.field789[var5++] = client.field442;
                              continue;
                           }
                        } else if(var39 < 2900) {
                           --var5;
                           var28 = class170.method3344(class36.field789[var5]);
                           if(var39 == 2800) {
                              var42 = class36.field789;
                              var73 = var5++;
                              var19 = class138.method2906(var28);
                              var27 = var19 >> 11 & 63;
                              var42[var73] = var27;
                              continue;
                           }

                           if(var39 == 2801) {
                              --var5;
                              var33 = class36.field789[var5];
                              --var33;
                              if(null != var28.field2850 && var33 < var28.field2850.length && null != var28.field2850[var33]) {
                                 class36.field796[var6++] = var28.field2850[var33];
                                 continue;
                              }

                              class36.field796[var6++] = "";
                              continue;
                           }

                           if(var39 == 2802) {
                              if(var28.field2833 == null) {
                                 class36.field796[var6++] = "";
                              } else {
                                 class36.field796[var6++] = var28.field2833;
                              }
                              continue;
                           }
                        } else {
                           int var22;
                           int var65;
                           if(var39 < 3200) {
                              if(var39 == 3100) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class33.method702(0, "", var87);
                                 continue;
                              }

                              if(var39 == 3101) {
                                 var5 -= 2;
                                 class1.method2(class152.field2301, class36.field789[var5], class36.field789[var5 + 1]);
                                 continue;
                              }

                              if(var39 == 3103) {
                                 class161.method3156();
                                 continue;
                              }

                              if(var39 == 3104) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 var33 = 0;
                                 boolean var47 = false;
                                 boolean var20 = false;
                                 var21 = 0;
                                 var22 = var87.length();
                                 int var23 = 0;

                                 while(true) {
                                    if(var23 >= var22) {
                                       var69 = var20;
                                       break;
                                    }

                                    label3723: {
                                       char var24 = var87.charAt(var23);
                                       if(var23 == 0) {
                                          if(var24 == 45) {
                                             var47 = true;
                                             break label3723;
                                          }

                                          if(var24 == 43) {
                                             break label3723;
                                          }
                                       }

                                       if(var24 >= 48 && var24 <= 57) {
                                          var65 = var24 - 48;
                                       } else if(var24 >= 65 && var24 <= 90) {
                                          var65 = var24 - 55;
                                       } else {
                                          if(var24 < 97 || var24 > 122) {
                                             var69 = false;
                                             break;
                                          }

                                          var65 = var24 - 87;
                                       }

                                       if(var65 >= 10) {
                                          var69 = false;
                                          break;
                                       }

                                       if(var47) {
                                          var65 = -var65;
                                       }

                                       int var25 = var65 + 10 * var21;
                                       if(var25 / 10 != var21) {
                                          var69 = false;
                                          break;
                                       }

                                       var21 = var25;
                                       var20 = true;
                                    }

                                    ++var23;
                                 }

                                 if(var69) {
                                    var33 = class77.method1660(var87);
                                 }

                                 client.field325.method2733(13);
                                 client.field325.method2456(var33);
                                 continue;
                              }

                              if(var39 == 3105) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 client.field325.method2733(173);
                                 client.field325.method2453(var87.length() + 1);
                                 client.field325.method2586(var87);
                                 continue;
                              }

                              if(var39 == 3106) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 client.field325.method2733(187);
                                 client.field325.method2453(var87.length() + 1);
                                 client.field325.method2586(var87);
                                 continue;
                              }

                              if(var39 == 3107) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 --var6;
                                 var46 = class36.field796[var6];
                                 class107.method2349(var15, var46);
                                 continue;
                              }

                              if(var39 == 3108) {
                                 var5 -= 3;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[1 + var5];
                                 var73 = class36.field789[2 + var5];
                                 var18 = class170.method3344(var73);
                                 class7.method87(var18, var15, var33);
                                 continue;
                              }

                              if(var39 == 3109) {
                                 var5 -= 2;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[1 + var5];
                                 var40 = var51?class178.field2935:class36.field793;
                                 class7.method87(var40, var15, var33);
                                 continue;
                              }

                              if(var39 == 3110) {
                                 --var5;
                                 class101.field1755 = class36.field789[var5] == 1;
                                 continue;
                              }

                              if(var39 == 3111) {
                                 class36.field789[var5++] = class116.field1988.field138?1:0;
                                 continue;
                              }

                              if(var39 == 3112) {
                                 --var5;
                                 class116.field1988.field138 = class36.field789[var5] == 1;
                                 class25.method590();
                                 continue;
                              }

                              if(var39 == 3113) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 --var5;
                                 var91 = class36.field789[var5] == 1;
                                 class135.method2850(var87, var91, false);
                                 continue;
                              }

                              if(var39 == 3115) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 client.field325.method2733(82);
                                 client.field325.method2454(var15);
                                 continue;
                              }

                              if(var39 == 3116) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 var6 -= 2;
                                 var46 = class36.field796[var6];
                                 var17 = class36.field796[var6 + 1];
                                 if(var46.length() <= 500 && var17.length() <= 500) {
                                    client.field325.method2733(68);
                                    client.field325.method2454(1 + class102.method2237(var46) + class102.method2237(var17));
                                    client.field325.method2488(var15);
                                    client.field325.method2586(var17);
                                    client.field325.method2586(var46);
                                 }
                                 continue;
                              }
                           } else if(var39 < 3300) {
                              if(var39 == 3200) {
                                 var5 -= 3;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[1 + var5];
                                 var73 = class36.field789[var5 + 2];
                                 if(client.field560 != 0 && var33 != 0 && client.field524 < 50) {
                                    client.field525[client.field524] = var15;
                                    client.field319[client.field524] = var33;
                                    client.field527[client.field524] = var73;
                                    client.field529[client.field524] = null;
                                    client.field532[client.field524] = 0;
                                    ++client.field524;
                                 }
                                 continue;
                              }

                              if(var39 == 3201) {
                                 --var5;
                                 class40.method827(class36.field789[var5]);
                                 continue;
                              }

                              if(var39 == 3202) {
                                 var5 -= 2;
                                 class24.method576(class36.field789[var5], class36.field789[1 + var5]);
                                 continue;
                              }
                           } else if(var39 < 3400) {
                              if(var39 == 3300) {
                                 class36.field789[var5++] = client.field332;
                                 continue;
                              }

                              if(var39 == 3301) {
                                 var5 -= 2;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[var5 + 1];
                                 class36.field789[var5++] = class150.method3118(var15, var33);
                                 continue;
                              }

                              if(var39 == 3302) {
                                 var5 -= 2;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[var5 + 1];
                                 class36.field789[var5++] = class99.method2155(var15, var33);
                                 continue;
                              }

                              if(var39 == 3303) {
                                 var5 -= 2;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[var5 + 1];
                                 class36.field789[var5++] = class48.method972(var15, var33);
                                 continue;
                              }

                              if(var39 == 3304) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = class48.method969(var15).field1104;
                                 continue;
                              }

                              if(var39 == 3305) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = client.field303[var15];
                                 continue;
                              }

                              if(var39 == 3306) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = client.field420[var15];
                                 continue;
                              }

                              if(var39 == 3307) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = client.field421[var15];
                                 continue;
                              }

                              if(var39 == 3308) {
                                 var15 = class32.field754;
                                 var33 = class89.field1565 + (class152.field2301.field809 >> 7);
                                 var73 = (class152.field2301.field804 >> 7) + client.field358;
                                 class36.field789[var5++] = var73 + (var15 << 28) + (var33 << 14);
                                 continue;
                              }

                              if(var39 == 3309) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = var15 >> 14 & 16383;
                                 continue;
                              }

                              if(var39 == 3310) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = var15 >> 28;
                                 continue;
                              }

                              if(var39 == 3311) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 class36.field789[var5++] = var15 & 16383;
                                 continue;
                              }

                              if(var39 == 3312) {
                                 class36.field789[var5++] = client.field286?1:0;
                                 continue;
                              }

                              if(var39 == 3313) {
                                 var5 -= 2;
                                 var15 = '耀' + class36.field789[var5];
                                 var33 = class36.field789[var5 + 1];
                                 class36.field789[var5++] = class150.method3118(var15, var33);
                                 continue;
                              }

                              if(var39 == 3314) {
                                 var5 -= 2;
                                 var15 = class36.field789[var5] + '耀';
                                 var33 = class36.field789[1 + var5];
                                 class36.field789[var5++] = class99.method2155(var15, var33);
                                 continue;
                              }

                              if(var39 == 3315) {
                                 var5 -= 2;
                                 var15 = '耀' + class36.field789[var5];
                                 var33 = class36.field789[1 + var5];
                                 class36.field789[var5++] = class48.method972(var15, var33);
                                 continue;
                              }

                              if(var39 == 3316) {
                                 if(client.field449 >= 2) {
                                    class36.field789[var5++] = client.field449;
                                 } else {
                                    class36.field789[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var39 == 3317) {
                                 class36.field789[var5++] = client.field300;
                                 continue;
                              }

                              if(var39 == 3318) {
                                 class36.field789[var5++] = client.field478;
                                 continue;
                              }

                              if(var39 == 3321) {
                                 class36.field789[var5++] = client.field531;
                                 continue;
                              }

                              if(var39 == 3322) {
                                 class36.field789[var5++] = client.field448;
                                 continue;
                              }

                              if(var39 == 3323) {
                                 if(client.field539) {
                                    class36.field789[var5++] = 1;
                                 } else {
                                    class36.field789[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var39 == 3324) {
                                 class36.field789[var5++] = client.field283;
                                 continue;
                              }
                           } else if(var39 < 3500) {
                              if(var39 == 3400) {
                                 var5 -= 2;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[1 + var5];
                                 class48 var43 = (class48)class48.field1087.method3716((long)var15);
                                 class48 var41;
                                 if(var43 != null) {
                                    var41 = var43;
                                 } else {
                                    byte[] var80 = class142.field2206.method3221(8, var15);
                                    var43 = new class48();
                                    if(null != var80) {
                                       var43.method963(new class119(var80));
                                    }

                                    class48.field1087.method3724(var43, (long)var15);
                                    var41 = var43;
                                 }

                                 var43 = var41;
                                 if(var41.field1085 != 115) {
                                    ;
                                 }

                                 for(var19 = 0; var19 < var43.field1088; ++var19) {
                                    if(var33 == var43.field1093[var19]) {
                                       class36.field796[var6++] = var43.field1091[var19];
                                       var43 = null;
                                       break;
                                    }
                                 }

                                 if(null != var43) {
                                    class36.field796[var6++] = var43.field1086;
                                 }
                                 continue;
                              }

                              if(var39 == 3408) {
                                 var5 -= 4;
                                 var15 = class36.field789[var5];
                                 var33 = class36.field789[var5 + 1];
                                 var73 = class36.field789[var5 + 2];
                                 var27 = class36.field789[var5 + 3];
                                 class48 var30 = (class48)class48.field1087.method3716((long)var73);
                                 class48 var31;
                                 if(null != var30) {
                                    var31 = var30;
                                 } else {
                                    byte[] var32 = class142.field2206.method3221(8, var73);
                                    var30 = new class48();
                                    if(var32 != null) {
                                       var30.method963(new class119(var32));
                                    }

                                    class48.field1087.method3724(var30, (long)var73);
                                    var31 = var30;
                                 }

                                 var30 = var31;
                                 if(var31.field1084 == var15 && var31.field1085 == var33) {
                                    for(var21 = 0; var21 < var30.field1088; ++var21) {
                                       if(var27 == var30.field1093[var21]) {
                                          if(var33 == 115) {
                                             class36.field796[var6++] = var30.field1091[var21];
                                          } else {
                                             class36.field789[var5++] = var30.field1090[var21];
                                          }

                                          var30 = null;
                                          break;
                                       }
                                    }

                                    if(null != var30) {
                                       if(var33 == 115) {
                                          class36.field796[var6++] = var30.field1086;
                                       } else {
                                          class36.field789[var5++] = var30.field1089;
                                       }
                                    }
                                    continue;
                                 }

                                 if(var33 == 115) {
                                    class36.field796[var6++] = "null";
                                 } else {
                                    class36.field789[var5++] = 0;
                                 }
                                 continue;
                              }
                           } else if(var39 < 3700) {
                              if(var39 == 3600) {
                                 if(client.field522 == 0) {
                                    class36.field789[var5++] = -2;
                                 } else if(client.field522 == 1) {
                                    class36.field789[var5++] = -1;
                                 } else {
                                    class36.field789[var5++] = client.field418;
                                 }
                                 continue;
                              }

                              if(var39 == 3601) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(client.field522 == 2 && var15 < client.field418) {
                                    class36.field796[var6++] = client.field551[var15].field239;
                                    class36.field796[var6++] = client.field551[var15].field238;
                                    continue;
                                 }

                                 class36.field796[var6++] = "";
                                 class36.field796[var6++] = "";
                                 continue;
                              }

                              if(var39 == 3602) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(client.field522 == 2 && var15 < client.field418) {
                                    class36.field789[var5++] = client.field551[var15].field249;
                                    continue;
                                 }

                                 class36.field789[var5++] = 0;
                                 continue;
                              }

                              if(var39 == 3603) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(client.field522 == 2 && var15 < client.field418) {
                                    class36.field789[var5++] = client.field551[var15].field237;
                                    continue;
                                 }

                                 class36.field789[var5++] = 0;
                                 continue;
                              }

                              if(var39 == 3604) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 --var5;
                                 var33 = class36.field789[var5];
                                 class17.method166(var87, var33);
                                 continue;
                              }

                              if(var39 == 3605) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class11.method124(var87);
                                 continue;
                              }

                              if(var39 == 3606) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class157.method3139(var87);
                                 continue;
                              }

                              if(var39 == 3607) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class155.method3134(var87, false);
                                 continue;
                              }

                              if(var39 == 3608) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class95.method2148(var87);
                                 continue;
                              }

                              if(var39 == 3609) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class152[] var49 = new class152[]{class152.field2299, class152.field2294, class152.field2293, class152.field2290, class152.field2291};
                                 class152[] var45 = var49;

                                 for(var27 = 0; var27 < var45.length; ++var27) {
                                    class152 var89 = var45[var27];
                                    if(var89.field2296 != -1) {
                                       var22 = var89.field2296;
                                       var81 = "<img=" + var22 + ">";
                                       if(var87.startsWith(var81)) {
                                          var87 = var87.substring(6 + Integer.toString(var89.field2296).length());
                                          break;
                                       }
                                    }
                                 }

                                 class36.field789[var5++] = class47.method962(var87, false)?1:0;
                                 continue;
                              }

                              String var50;
                              String var83;
                              String[] var94;
                              if(var39 == 3611) {
                                 if(null != client.field282) {
                                    var94 = class36.field796;
                                    var33 = var6++;
                                    var50 = client.field282;
                                    var83 = class2.method34(class1.method3(var50));
                                    if(var83 == null) {
                                       var83 = "";
                                    }

                                    var94[var33] = var83;
                                 } else {
                                    class36.field796[var6++] = "";
                                 }
                                 continue;
                              }

                              if(var39 == 3612) {
                                 if(client.field282 != null) {
                                    class36.field789[var5++] = class19.field274;
                                 } else {
                                    class36.field789[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var39 == 3613) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(null != client.field282 && var15 < class19.field274) {
                                    class36.field796[var6++] = class19.field278[var15].field622;
                                    continue;
                                 }

                                 class36.field796[var6++] = "";
                                 continue;
                              }

                              if(var39 == 3614) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(client.field282 != null && var15 < class19.field274) {
                                    class36.field789[var5++] = class19.field278[var15].field615;
                                    continue;
                                 }

                                 class36.field789[var5++] = 0;
                                 continue;
                              }

                              if(var39 == 3615) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(null != client.field282 && var15 < class19.field274) {
                                    class36.field789[var5++] = class19.field278[var15].field616;
                                    continue;
                                 }

                                 class36.field789[var5++] = 0;
                                 continue;
                              }

                              if(var39 == 3616) {
                                 class36.field789[var5++] = class74.field1375;
                                 continue;
                              }

                              if(var39 == 3617) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 if(null != class19.field278) {
                                    client.field325.method2733(51);
                                    client.field325.method2453(class102.method2237(var87));
                                    client.field325.method2586(var87);
                                 }
                                 continue;
                              }

                              if(var39 == 3618) {
                                 class36.field789[var5++] = class72.field1356;
                                 continue;
                              }

                              if(var39 == 3619) {
                                 --var6;
                                 var87 = class36.field796[var6];
                                 class6.method80(var87);
                                 continue;
                              }

                              if(var39 == 3620) {
                                 class103.method2245();
                                 continue;
                              }

                              if(var39 == 3621) {
                                 if(client.field522 == 0) {
                                    class36.field789[var5++] = -1;
                                 } else {
                                    class36.field789[var5++] = client.field553;
                                 }
                                 continue;
                              }

                              if(var39 == 3622) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(client.field522 != 0 && var15 < client.field553) {
                                    class36.field796[var6++] = client.field400[var15].field135;
                                    class36.field796[var6++] = client.field400[var15].field134;
                                    continue;
                                 }

                                 class36.field796[var6++] = "";
                                 class36.field796[var6++] = "";
                                 continue;
                              }

                              if(var39 == 3623) {
                                 label3196: {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    var17 = "<img=0>";
                                    if(!var87.startsWith(var17)) {
                                       var83 = "<img=1>";
                                       if(!var87.startsWith(var83)) {
                                          break label3196;
                                       }
                                    }

                                    var87 = var87.substring(7);
                                 }

                                 class36.field789[var5++] = class19.method202(var87)?1:0;
                                 continue;
                              }

                              if(var39 == 3624) {
                                 --var5;
                                 var15 = class36.field789[var5];
                                 if(class19.field278 != null && var15 < class19.field274 && class19.field278[var15].field622.equalsIgnoreCase(class152.field2301.field39)) {
                                    class36.field789[var5++] = 1;
                                    continue;
                                 }

                                 class36.field789[var5++] = 0;
                                 continue;
                              }

                              if(var39 == 3625) {
                                 if(client.field510 != null) {
                                    var94 = class36.field796;
                                    var33 = var6++;
                                    var50 = client.field510;
                                    var83 = class2.method34(class1.method3(var50));
                                    if(null == var83) {
                                       var83 = "";
                                    }

                                    var94[var33] = var83;
                                 } else {
                                    class36.field796[var6++] = "";
                                 }
                                 continue;
                              }
                           } else {
                              long var79;
                              if(var39 < 4000) {
                                 if(var39 == 3903) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = client.field558[var15].method3924();
                                    continue;
                                 }

                                 if(var39 == 3904) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = client.field558[var15].field3172;
                                    continue;
                                 }

                                 if(var39 == 3905) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = client.field558[var15].field3176;
                                    continue;
                                 }

                                 if(var39 == 3906) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = client.field558[var15].field3174;
                                    continue;
                                 }

                                 if(var39 == 3907) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = client.field558[var15].field3171;
                                    continue;
                                 }

                                 if(var39 == 3908) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = client.field558[var15].field3175;
                                    continue;
                                 }

                                 if(var39 == 3910) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var33 = client.field558[var15].method3937();
                                    class36.field789[var5++] = var33 == 0?1:0;
                                    continue;
                                 }

                                 if(var39 == 3911) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var33 = client.field558[var15].method3937();
                                    class36.field789[var5++] = var33 == 2?1:0;
                                    continue;
                                 }

                                 if(var39 == 3912) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var33 = client.field558[var15].method3937();
                                    class36.field789[var5++] = var33 == 5?1:0;
                                    continue;
                                 }

                                 if(var39 == 3913) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var33 = client.field558[var15].method3937();
                                    class36.field789[var5++] = var33 == 1?1:0;
                                    continue;
                                 }

                                 boolean var72;
                                 if(var39 == 3914) {
                                    --var5;
                                    var72 = class36.field789[var5] == 1;
                                    if(null != class140.field2179) {
                                       class140.field2179.method3947(class221.field3182, var72);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3915) {
                                    --var5;
                                    var72 = class36.field789[var5] == 1;
                                    if(class140.field2179 != null) {
                                       class140.field2179.method3947(class221.field3181, var72);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3916) {
                                    var5 -= 2;
                                    var72 = class36.field789[var5] == 1;
                                    var91 = class36.field789[var5 + 1] == 1;
                                    if(null != class140.field2179) {
                                       class140.field2179.method3947(new class21(var91), var72);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3917) {
                                    --var5;
                                    var72 = class36.field789[var5] == 1;
                                    if(class140.field2179 != null) {
                                       class140.field2179.method3947(class221.field3180, var72);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3918) {
                                    --var5;
                                    var72 = class36.field789[var5] == 1;
                                    if(class140.field2179 != null) {
                                       class140.field2179.method3947(class221.field3183, var72);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3919) {
                                    class36.field789[var5++] = class140.field2179 == null?0:class140.field2179.field3179.size();
                                    continue;
                                 }

                                 class214 var52;
                                 if(var39 == 3920) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    class36.field789[var5++] = var52.field3160;
                                    continue;
                                 }

                                 if(var39 == 3921) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    class36.field796[var6++] = var52.method3889();
                                    continue;
                                 }

                                 if(var39 == 3922) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    class36.field796[var6++] = var52.method3890();
                                    continue;
                                 }

                                 if(var39 == 3923) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    var79 = class124.method2746() - client.field559 - var52.field3156;
                                    var19 = (int)(var79 / 3600000L);
                                    var54 = (int)((var79 - (long)(var19 * 3600000)) / 60000L);
                                    var21 = (int)((var79 - (long)(3600000 * var19) - (long)(var54 * '\uea60')) / 1000L);
                                    String var34 = var19 + ":" + var54 / 10 + var54 % 10 + ":" + var21 / 10 + var21 % 10;
                                    class36.field796[var6++] = var34;
                                    continue;
                                 }

                                 if(var39 == 3924) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    class36.field789[var5++] = var52.field3157.field3174;
                                    continue;
                                 }

                                 if(var39 == 3925) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    class36.field789[var5++] = var52.field3157.field3176;
                                    continue;
                                 }

                                 if(var39 == 3926) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var52 = (class214)class140.field2179.field3179.get(var15);
                                    class36.field789[var5++] = var52.field3157.field3172;
                                    continue;
                                 }
                              } else if(var39 < 4100) {
                                 if(var39 == 4000) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class36.field789[var5++] = var33 + var15;
                                    continue;
                                 }

                                 if(var39 == 4001) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    class36.field789[var5++] = var15 - var33;
                                    continue;
                                 }

                                 if(var39 == 4002) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    class36.field789[var5++] = var33 * var15;
                                    continue;
                                 }

                                 if(var39 == 4003) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class36.field789[var5++] = var15 / var33;
                                    continue;
                                 }

                                 if(var39 == 4004) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = (int)(Math.random() * (double)var15);
                                    continue;
                                 }

                                 if(var39 == 4005) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = (int)(Math.random() * (double)(1 + var15));
                                    continue;
                                 }

                                 if(var39 == 4006) {
                                    var5 -= 5;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    var73 = class36.field789[2 + var5];
                                    var27 = class36.field789[var5 + 3];
                                    var19 = class36.field789[var5 + 4];
                                    class36.field789[var5++] = (var33 - var15) * (var19 - var73) / (var27 - var73) + var15;
                                    continue;
                                 }

                                 if(var39 == 4007) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class36.field789[var5++] = var15 + var15 * var33 / 100;
                                    continue;
                                 }

                                 if(var39 == 4008) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class36.field789[var5++] = var15 | 1 << var33;
                                    continue;
                                 }

                                 if(var39 == 4009) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class36.field789[var5++] = var15 & -1 - (1 << var33);
                                    continue;
                                 }

                                 if(var39 == 4010) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    class36.field789[var5++] = (var15 & 1 << var33) != 0?1:0;
                                    continue;
                                 }

                                 if(var39 == 4011) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    class36.field789[var5++] = var15 % var33;
                                    continue;
                                 }

                                 if(var39 == 4012) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    if(var15 == 0) {
                                       class36.field789[var5++] = 0;
                                    } else {
                                       class36.field789[var5++] = (int)Math.pow((double)var15, (double)var33);
                                    }
                                    continue;
                                 }

                                 if(var39 == 4013) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    if(var15 == 0) {
                                       class36.field789[var5++] = 0;
                                    } else if(var33 == 0) {
                                       class36.field789[var5++] = Integer.MAX_VALUE;
                                    } else {
                                       class36.field789[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var33);
                                    }
                                    continue;
                                 }

                                 if(var39 == 4014) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class36.field789[var5++] = var15 & var33;
                                    continue;
                                 }

                                 if(var39 == 4015) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    class36.field789[var5++] = var15 | var33;
                                    continue;
                                 }

                                 if(var39 == 4018) {
                                    var5 -= 3;
                                    long var86 = (long)class36.field789[var5];
                                    var79 = (long)class36.field789[1 + var5];
                                    long var58 = (long)class36.field789[2 + var5];
                                    class36.field789[var5++] = (int)(var86 * var58 / var79);
                                    continue;
                                 }
                              } else if(var39 < 4200) {
                                 if(var39 == 4100) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    --var5;
                                    var33 = class36.field789[var5];
                                    class36.field796[var6++] = var87 + var33;
                                    continue;
                                 }

                                 if(var39 == 4101) {
                                    var6 -= 2;
                                    var87 = class36.field796[var6];
                                    var46 = class36.field796[1 + var6];
                                    class36.field796[var6++] = var87 + var46;
                                    continue;
                                 }

                                 if(var39 == 4102) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    --var5;
                                    var33 = class36.field789[var5];
                                    class36.field796[var6++] = var87 + class154.method3130(var33, true);
                                    continue;
                                 }

                                 if(var39 == 4103) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    class36.field796[var6++] = var87.toLowerCase();
                                    continue;
                                 }

                                 if(var39 == 4104) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    long var100 = (11745L + (long)var15) * 86400000L;
                                    class36.field794.setTime(new Date(var100));
                                    var27 = class36.field794.get(5);
                                    var19 = class36.field794.get(2);
                                    var54 = class36.field794.get(1);
                                    class36.field796[var6++] = var27 + "-" + class36.field795[var19] + "-" + var54;
                                    continue;
                                 }

                                 if(var39 == 4105) {
                                    var6 -= 2;
                                    var87 = class36.field796[var6];
                                    var46 = class36.field796[var6 + 1];
                                    if(class152.field2301.field59 != null && class152.field2301.field59.field2942) {
                                       class36.field796[var6++] = var46;
                                       continue;
                                    }

                                    class36.field796[var6++] = var87;
                                    continue;
                                 }

                                 if(var39 == 4106) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field796[var6++] = Integer.toString(var15);
                                    continue;
                                 }

                                 if(var39 == 4107) {
                                    var6 -= 2;
                                    class36.field789[var5++] = class126.method2782(class6.method83(class36.field796[var6], class36.field796[var6 + 1], client.field288));
                                    continue;
                                 }

                                 class224 var92;
                                 if(var39 == 4108) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    var5 -= 2;
                                    var33 = class36.field789[var5];
                                    var73 = class36.field789[1 + var5];
                                    var53 = class74.field1371.method3221(var73, 0);
                                    var92 = new class224(var53);
                                    class36.field789[var5++] = var92.method3981(var87, var33);
                                    continue;
                                 }

                                 if(var39 == 4109) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    var5 -= 2;
                                    var33 = class36.field789[var5];
                                    var73 = class36.field789[1 + var5];
                                    var53 = class74.field1371.method3221(var73, 0);
                                    var92 = new class224(var53);
                                    class36.field789[var5++] = var92.method4019(var87, var33);
                                    continue;
                                 }

                                 if(var39 == 4110) {
                                    var6 -= 2;
                                    var87 = class36.field796[var6];
                                    var46 = class36.field796[var6 + 1];
                                    --var5;
                                    if(class36.field789[var5] == 1) {
                                       class36.field796[var6++] = var87;
                                    } else {
                                       class36.field796[var6++] = var46;
                                    }
                                    continue;
                                 }

                                 if(var39 == 4111) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    class36.field796[var6++] = class223.method3967(var87);
                                    continue;
                                 }

                                 if(var39 == 4112) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    --var5;
                                    var33 = class36.field789[var5];
                                    class36.field796[var6++] = var87 + (char)var33;
                                    continue;
                                 }

                                 if(var39 == 4113) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class111.method2389((char)var15)?1:0;
                                    continue;
                                 }

                                 char var60;
                                 if(var39 == 4114) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var42 = class36.field789;
                                    var73 = var5++;
                                    var60 = (char)var15;
                                    var69 = var60 >= 48 && var60 <= 57 || var60 >= 65 && var60 <= 90 || var60 >= 97 && var60 <= 122;
                                    var42[var73] = var69?1:0;
                                    continue;
                                 }

                                 if(var39 == 4115) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class43.method893((char)var15)?1:0;
                                    continue;
                                 }

                                 if(var39 == 4116) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var42 = class36.field789;
                                    var73 = var5++;
                                    var60 = (char)var15;
                                    var69 = var60 >= 48 && var60 <= 57;
                                    var42[var73] = var69?1:0;
                                    continue;
                                 }

                                 if(var39 == 4117) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    if(var87 != null) {
                                       class36.field789[var5++] = var87.length();
                                    } else {
                                       class36.field789[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var39 == 4118) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    var5 -= 2;
                                    var33 = class36.field789[var5];
                                    var73 = class36.field789[1 + var5];
                                    class36.field796[var6++] = var87.substring(var33, var73);
                                    continue;
                                 }

                                 if(var39 == 4119) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    StringBuilder var61 = new StringBuilder(var87.length());
                                    var29 = false;

                                    for(var27 = 0; var27 < var87.length(); ++var27) {
                                       var60 = var87.charAt(var27);
                                       if(var60 == 60) {
                                          var29 = true;
                                       } else if(var60 == 62) {
                                          var29 = false;
                                       } else if(!var29) {
                                          var61.append(var60);
                                       }
                                    }

                                    class36.field796[var6++] = var61.toString();
                                    continue;
                                 }

                                 if(var39 == 4120) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    --var5;
                                    var33 = class36.field789[var5];
                                    class36.field789[var5++] = var87.indexOf(var33);
                                    continue;
                                 }

                                 if(var39 == 4121) {
                                    var6 -= 2;
                                    var87 = class36.field796[var6];
                                    var46 = class36.field796[1 + var6];
                                    --var5;
                                    var73 = class36.field789[var5];
                                    class36.field789[var5++] = var87.indexOf(var46, var73);
                                    continue;
                                 }
                              } else if(var39 < 4300) {
                                 if(var39 == 4200) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field796[var6++] = class123.method2743(var15).field1120;
                                    continue;
                                 }

                                 class51 var48;
                                 if(var39 == 4201) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    var48 = class123.method2743(var15);
                                    if(var33 >= 1 && var33 <= 5 && var48.field1155[var33 - 1] != null) {
                                       class36.field796[var6++] = var48.field1155[var33 - 1];
                                       continue;
                                    }

                                    class36.field796[var6++] = "";
                                    continue;
                                 }

                                 if(var39 == 4202) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[var5 + 1];
                                    var48 = class123.method2743(var15);
                                    if(var33 >= 1 && var33 <= 5 && null != var48.field1121[var33 - 1]) {
                                       class36.field796[var6++] = var48.field1121[var33 - 1];
                                       continue;
                                    }

                                    class36.field796[var6++] = "";
                                    continue;
                                 }

                                 if(var39 == 4203) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class123.method2743(var15).field1117;
                                    continue;
                                 }

                                 if(var39 == 4204) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class123.method2743(var15).field1131 == 1?1:0;
                                    continue;
                                 }

                                 class51 var66;
                                 if(var39 == 4205) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var66 = class123.method2743(var15);
                                    if(var66.field1151 == -1 && var66.field1150 >= 0) {
                                       class36.field789[var5++] = var66.field1150;
                                       continue;
                                    }

                                    class36.field789[var5++] = var15;
                                    continue;
                                 }

                                 if(var39 == 4206) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var66 = class123.method2743(var15);
                                    if(var66.field1151 >= 0 && var66.field1150 >= 0) {
                                       class36.field789[var5++] = var66.field1150;
                                       continue;
                                    }

                                    class36.field789[var5++] = var15;
                                    continue;
                                 }

                                 if(var39 == 4207) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class123.method2743(var15).field1134?1:0;
                                    continue;
                                 }

                                 if(var39 == 4208) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var66 = class123.method2743(var15);
                                    if(var66.field1162 == -1 && var66.field1161 >= 0) {
                                       class36.field789[var5++] = var66.field1161;
                                       continue;
                                    }

                                    class36.field789[var5++] = var15;
                                    continue;
                                 }

                                 if(var39 == 4209) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var66 = class123.method2743(var15);
                                    if(var66.field1162 >= 0 && var66.field1161 >= 0) {
                                       class36.field789[var5++] = var66.field1161;
                                       continue;
                                    }

                                    class36.field789[var5++] = var15;
                                    continue;
                                 }

                                 if(var39 == 4210) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    --var5;
                                    var33 = class36.field789[var5];
                                    var69 = var33 == 1;
                                    var17 = var87.toLowerCase();
                                    short[] var93 = new short[16];
                                    var54 = 0;
                                    var21 = 0;

                                    while(true) {
                                       if(var21 >= class51.field1125) {
                                          class89.field1569 = var93;
                                          class140.field2173 = 0;
                                          class32.field745 = var54;
                                          String[] var84 = new String[class32.field745];

                                          for(var22 = 0; var22 < class32.field745; ++var22) {
                                             var84[var22] = class123.method2743(var93[var22]).field1120;
                                          }

                                          short[] var90 = class89.field1569;
                                          class36.method731(var84, var90, 0, var84.length - 1);
                                          break;
                                       }

                                       class51 var88 = class123.method2743(var21);
                                       if((!var69 || var88.field1158) && var88.field1151 == -1 && var88.field1120.toLowerCase().indexOf(var17) != -1) {
                                          if(var54 >= 250) {
                                             class32.field745 = -1;
                                             class89.field1569 = null;
                                             break;
                                          }

                                          if(var54 >= var93.length) {
                                             short[] var35 = new short[var93.length * 2];

                                             for(var65 = 0; var65 < var54; ++var65) {
                                                var35[var65] = var93[var65];
                                             }

                                             var93 = var35;
                                          }

                                          var93[var54++] = (short)var21;
                                       }

                                       ++var21;
                                    }

                                    class36.field789[var5++] = class32.field745;
                                    continue;
                                 }

                                 if(var39 == 4211) {
                                    if(null != class89.field1569 && class140.field2173 < class32.field745) {
                                       class36.field789[var5++] = class89.field1569[++class140.field2173 - 1] & '\uffff';
                                       continue;
                                    }

                                    class36.field789[var5++] = -1;
                                    continue;
                                 }

                                 if(var39 == 4212) {
                                    class140.field2173 = 0;
                                    continue;
                                 }
                              } else if(var39 < 5100) {
                                 if(var39 == 5000) {
                                    class36.field789[var5++] = client.field500;
                                    continue;
                                 }

                                 if(var39 == 5001) {
                                    var5 -= 3;
                                    client.field500 = class36.field789[var5];
                                    class131.field2079 = class6.method68(class36.field789[1 + var5]);
                                    if(null == class131.field2079) {
                                       class131.field2079 = class130.field2068;
                                    }

                                    client.field501 = class36.field789[var5 + 2];
                                    client.field325.method2733(210);
                                    client.field325.method2453(client.field500);
                                    client.field325.method2453(class131.field2079.field2069);
                                    client.field325.method2453(client.field501);
                                    continue;
                                 }

                                 if(var39 == 5002) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    var5 -= 2;
                                    var33 = class36.field789[var5];
                                    var73 = class36.field789[var5 + 1];
                                    client.field325.method2733(220);
                                    client.field325.method2453(class102.method2237(var87) + 2);
                                    client.field325.method2586(var87);
                                    client.field325.method2453(var33 - 1);
                                    client.field325.method2453(var73);
                                    continue;
                                 }

                                 if(var39 == 5003) {
                                    var5 -= 2;
                                    var15 = class36.field789[var5];
                                    var33 = class36.field789[1 + var5];
                                    class27 var57 = (class27)class11.field175.get(Integer.valueOf(var15));
                                    class35 var55 = var57.method630(var33);
                                    if(var55 != null) {
                                       class36.field789[var5++] = var55.field780;
                                       class36.field789[var5++] = var55.field776;
                                       class36.field796[var6++] = null != var55.field778?var55.field778:"";
                                       class36.field796[var6++] = null != var55.field779?var55.field779:"";
                                       class36.field796[var6++] = null != var55.field784?var55.field784:"";
                                    } else {
                                       class36.field789[var5++] = -1;
                                       class36.field789[var5++] = 0;
                                       class36.field796[var6++] = "";
                                       class36.field796[var6++] = "";
                                       class36.field796[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var39 == 5004) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class35 var67 = class52.method1057(var15);
                                    if(var67 != null) {
                                       class36.field789[var5++] = var67.field777;
                                       class36.field789[var5++] = var67.field776;
                                       class36.field796[var6++] = null != var67.field778?var67.field778:"";
                                       class36.field796[var6++] = var67.field779 != null?var67.field779:"";
                                       class36.field796[var6++] = var67.field784 != null?var67.field784:"";
                                    } else {
                                       class36.field789[var5++] = -1;
                                       class36.field789[var5++] = 0;
                                       class36.field796[var6++] = "";
                                       class36.field796[var6++] = "";
                                       class36.field796[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var39 == 5005) {
                                    if(null == class131.field2079) {
                                       class36.field789[var5++] = -1;
                                    } else {
                                       class36.field789[var5++] = class131.field2079.field2069;
                                    }
                                    continue;
                                 }

                                 if(var39 == 5008) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    --var5;
                                    var33 = class36.field789[var5];
                                    var17 = var87.toLowerCase();
                                    byte var85 = 0;
                                    if(var17.startsWith("yellow:")) {
                                       var85 = 0;
                                       var87 = var87.substring("yellow:".length());
                                    } else if(var17.startsWith("red:")) {
                                       var85 = 1;
                                       var87 = var87.substring("red:".length());
                                    } else if(var17.startsWith("green:")) {
                                       var85 = 2;
                                       var87 = var87.substring("green:".length());
                                    } else if(var17.startsWith("cyan:")) {
                                       var85 = 3;
                                       var87 = var87.substring("cyan:".length());
                                    } else if(var17.startsWith("purple:")) {
                                       var85 = 4;
                                       var87 = var87.substring("purple:".length());
                                    } else if(var17.startsWith("white:")) {
                                       var85 = 5;
                                       var87 = var87.substring("white:".length());
                                    } else if(var17.startsWith("flash1:")) {
                                       var85 = 6;
                                       var87 = var87.substring("flash1:".length());
                                    } else if(var17.startsWith("flash2:")) {
                                       var85 = 7;
                                       var87 = var87.substring("flash2:".length());
                                    } else if(var17.startsWith("flash3:")) {
                                       var85 = 8;
                                       var87 = var87.substring("flash3:".length());
                                    } else if(var17.startsWith("glow1:")) {
                                       var85 = 9;
                                       var87 = var87.substring("glow1:".length());
                                    } else if(var17.startsWith("glow2:")) {
                                       var85 = 10;
                                       var87 = var87.substring("glow2:".length());
                                    } else if(var17.startsWith("glow3:")) {
                                       var85 = 11;
                                       var87 = var87.substring("glow3:".length());
                                    } else if(client.field288 != 0) {
                                       if(var17.startsWith("yellow:")) {
                                          var85 = 0;
                                          var87 = var87.substring("yellow:".length());
                                       } else if(var17.startsWith("red:")) {
                                          var85 = 1;
                                          var87 = var87.substring("red:".length());
                                       } else if(var17.startsWith("green:")) {
                                          var85 = 2;
                                          var87 = var87.substring("green:".length());
                                       } else if(var17.startsWith("cyan:")) {
                                          var85 = 3;
                                          var87 = var87.substring("cyan:".length());
                                       } else if(var17.startsWith("purple:")) {
                                          var85 = 4;
                                          var87 = var87.substring("purple:".length());
                                       } else if(var17.startsWith("white:")) {
                                          var85 = 5;
                                          var87 = var87.substring("white:".length());
                                       } else if(var17.startsWith("flash1:")) {
                                          var85 = 6;
                                          var87 = var87.substring("flash1:".length());
                                       } else if(var17.startsWith("flash2:")) {
                                          var85 = 7;
                                          var87 = var87.substring("flash2:".length());
                                       } else if(var17.startsWith("flash3:")) {
                                          var85 = 8;
                                          var87 = var87.substring("flash3:".length());
                                       } else if(var17.startsWith("glow1:")) {
                                          var85 = 9;
                                          var87 = var87.substring("glow1:".length());
                                       } else if(var17.startsWith("glow2:")) {
                                          var85 = 10;
                                          var87 = var87.substring("glow2:".length());
                                       } else if(var17.startsWith("glow3:")) {
                                          var85 = 11;
                                          var87 = var87.substring("glow3:".length());
                                       }
                                    }

                                    var17 = var87.toLowerCase();
                                    byte var62 = 0;
                                    if(var17.startsWith("wave:")) {
                                       var62 = 1;
                                       var87 = var87.substring("wave:".length());
                                    } else if(var17.startsWith("wave2:")) {
                                       var62 = 2;
                                       var87 = var87.substring("wave2:".length());
                                    } else if(var17.startsWith("shake:")) {
                                       var62 = 3;
                                       var87 = var87.substring("shake:".length());
                                    } else if(var17.startsWith("scroll:")) {
                                       var62 = 4;
                                       var87 = var87.substring("scroll:".length());
                                    } else if(var17.startsWith("slide:")) {
                                       var62 = 5;
                                       var87 = var87.substring("slide:".length());
                                    } else if(client.field288 != 0) {
                                       if(var17.startsWith("wave:")) {
                                          var62 = 1;
                                          var87 = var87.substring("wave:".length());
                                       } else if(var17.startsWith("wave2:")) {
                                          var62 = 2;
                                          var87 = var87.substring("wave2:".length());
                                       } else if(var17.startsWith("shake:")) {
                                          var62 = 3;
                                          var87 = var87.substring("shake:".length());
                                       } else if(var17.startsWith("scroll:")) {
                                          var62 = 4;
                                          var87 = var87.substring("scroll:".length());
                                       } else if(var17.startsWith("slide:")) {
                                          var62 = 5;
                                          var87 = var87.substring("slide:".length());
                                       }
                                    }

                                    client.field325.method2733(194);
                                    client.field325.method2453(0);
                                    var54 = client.field325.field2000;
                                    client.field325.method2453(var33);
                                    client.field325.method2453(var85);
                                    client.field325.method2453(var62);
                                    class184.method3672(client.field325, var87);
                                    client.field325.method2465(client.field325.field2000 - var54);
                                    continue;
                                 }

                                 if(var39 == 5009) {
                                    var6 -= 2;
                                    var87 = class36.field796[var6];
                                    var46 = class36.field796[var6 + 1];
                                    client.field325.method2733(228);
                                    client.field325.method2454(0);
                                    var73 = client.field325.field2000;
                                    client.field325.method2586(var87);
                                    class184.method3672(client.field325, var46);
                                    client.field325.method2471(client.field325.field2000 - var73);
                                    continue;
                                 }

                                 if(var39 == 5015) {
                                    if(class152.field2301 != null && class152.field2301.field39 != null) {
                                       var87 = class152.field2301.field39;
                                    } else {
                                       var87 = "";
                                    }

                                    class36.field796[var6++] = var87;
                                    continue;
                                 }

                                 if(var39 == 5016) {
                                    class36.field789[var5++] = client.field501;
                                    continue;
                                 }

                                 if(var39 == 5017) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class38.method741(var15);
                                    continue;
                                 }

                                 if(var39 == 5018) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    var42 = class36.field789;
                                    var73 = var5++;
                                    class35 var95 = (class35)class11.field180.method3761((long)var15);
                                    if(var95 == null) {
                                       var27 = -1;
                                    } else if(var95.field3114 == class11.field174.field3110) {
                                       var27 = -1;
                                    } else {
                                       var27 = ((class35)var95.field3114).field780;
                                    }

                                    var42[var73] = var27;
                                    continue;
                                 }

                                 if(var39 == 5019) {
                                    --var5;
                                    var15 = class36.field789[var5];
                                    class36.field789[var5++] = class5.method66(var15);
                                    continue;
                                 }

                                 if(var39 == 5020) {
                                    --var6;
                                    var87 = class36.field796[var6];
                                    class148.method3100(var87);
                                    continue;
                                 }

                                 if(var39 == 5021) {
                                    --var6;
                                    client.field299 = class36.field796[var6].toLowerCase().trim();
                                    continue;
                                 }

                                 if(var39 == 5022) {
                                    class36.field796[var6++] = client.field299;
                                    continue;
                                 }
                              }
                           }
                        }
                     } else {
                        if(var39 >= 2000) {
                           var39 -= 1000;
                           --var5;
                           var28 = class170.method3344(class36.field789[var5]);
                        } else {
                           var28 = var51?class178.field2935:class36.field793;
                        }

                        if(var39 == 1300) {
                           --var5;
                           var33 = class36.field789[var5] - 1;
                           if(var33 >= 0 && var33 <= 9) {
                              --var6;
                              var28.method3376(var33, class36.field796[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var39 == 1301) {
                           var5 -= 2;
                           var33 = class36.field789[var5];
                           var73 = class36.field789[1 + var5];
                           var28.field2851 = class74.method1561(var33, var73);
                           continue;
                        }

                        if(var39 == 1302) {
                           --var5;
                           var28.field2854 = class36.field789[var5] == 1;
                           continue;
                        }

                        if(var39 == 1303) {
                           --var5;
                           var28.field2852 = class36.field789[var5];
                           continue;
                        }

                        if(var39 == 1304) {
                           --var5;
                           var28.field2831 = class36.field789[var5];
                           continue;
                        }

                        if(var39 == 1305) {
                           --var6;
                           var28.field2833 = class36.field796[var6];
                           continue;
                        }

                        if(var39 == 1306) {
                           --var6;
                           var28.field2796 = class36.field796[var6];
                           continue;
                        }

                        if(var39 == 1307) {
                           var28.field2850 = null;
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var39 >= 2000) {
                        var39 -= 1000;
                        --var5;
                        var15 = class36.field789[var5];
                        var16 = class170.method3344(var15);
                     } else {
                        var16 = var51?class178.field2935:class36.field793;
                     }

                     if(var39 == 1000) {
                        var5 -= 4;
                        var16.field2815 = class36.field789[var5];
                        var16.field2786 = class36.field789[var5 + 1];
                        var16.field2781 = class36.field789[2 + var5];
                        var16.field2782 = class36.field789[3 + var5];
                        class20.method547(var16);
                        class15.method159(var16);
                        if(var15 != -1 && var16.field2778 == 0) {
                           class46.method935(class216.field3168[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var39 == 1001) {
                        var5 -= 4;
                        var16.field2787 = class36.field789[var5];
                        var16.field2788 = class36.field789[1 + var5];
                        var16.field2783 = class36.field789[2 + var5];
                        var16.field2784 = class36.field789[var5 + 3];
                        class20.method547(var16);
                        class15.method159(var16);
                        if(var15 != -1 && var16.field2778 == 0) {
                           class46.method935(class216.field3168[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var39 == 1003) {
                        --var5;
                        var29 = class36.field789[var5] == 1;
                        if(var16.field2875 != var29) {
                           var16.field2875 = var29;
                           class20.method547(var16);
                        }
                        continue;
                     }

                     if(var39 == 1005) {
                        --var5;
                        var16.field2909 = class36.field789[var5] == 1;
                        continue;
                     }

                     if(var39 == 1006) {
                        --var5;
                        var16.field2910 = class36.field789[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var39 < 5400) {
                  if(var39 == 5306) {
                     int[] var102 = class36.field789;
                     var33 = var5++;
                     var73 = client.field496?2:1;
                     var102[var33] = var73;
                     continue;
                  }

                  if(var39 == 5307) {
                     --var5;
                     var15 = class36.field789[var5];
                     if(var15 == 1 || var15 == 2) {
                        class56.method1188(var15);
                     }
                     continue;
                  }

                  if(var39 == 5308) {
                     class36.field789[var5++] = class116.field1988.field140;
                     continue;
                  }

                  if(var39 == 5309) {
                     --var5;
                     var15 = class36.field789[var5];
                     if(var15 == 1 || var15 == 2) {
                        class116.field1988.field140 = var15;
                        class25.method590();
                     }
                     continue;
                  }
               }

               if(var39 < 5600) {
                  if(var39 == 5504) {
                     var5 -= 2;
                     var15 = class36.field789[var5];
                     var33 = class36.field789[1 + var5];
                     if(!client.field530) {
                        client.field367 = var15;
                        client.field302 = var33;
                     }
                     continue;
                  }

                  if(var39 == 5505) {
                     class36.field789[var5++] = client.field367;
                     continue;
                  }

                  if(var39 == 5506) {
                     class36.field789[var5++] = client.field302;
                     continue;
                  }

                  if(var39 == 5530) {
                     --var5;
                     var15 = class36.field789[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     client.field373 = var15;
                     continue;
                  }

                  if(var39 == 5531) {
                     class36.field789[var5++] = client.field373;
                     continue;
                  }
               }

               if(var39 < 5700 && var39 == 5630) {
                  client.field335 = 250;
               } else {
                  if(var39 < 6300) {
                     if(var39 == 6200) {
                        var5 -= 2;
                        client.field536 = (short)class36.field789[var5];
                        if(client.field536 <= 0) {
                           client.field536 = 256;
                        }

                        client.field419 = (short)class36.field789[var5 + 1];
                        if(client.field419 <= 0) {
                           client.field419 = 205;
                        }
                        continue;
                     }

                     if(var39 == 6201) {
                        var5 -= 2;
                        client.field538 = (short)class36.field789[var5];
                        if(client.field538 <= 0) {
                           client.field538 = 256;
                        }

                        client.field518 = (short)class36.field789[var5 + 1];
                        if(client.field518 <= 0) {
                           client.field518 = 320;
                        }
                        continue;
                     }

                     if(var39 == 6202) {
                        var5 -= 4;
                        client.field540 = (short)class36.field789[var5];
                        if(client.field540 <= 0) {
                           client.field540 = 1;
                        }

                        client.field541 = (short)class36.field789[var5 + 1];
                        if(client.field541 <= 0) {
                           client.field541 = 32767;
                        } else if(client.field541 < client.field540) {
                           client.field541 = client.field540;
                        }

                        client.field526 = (short)class36.field789[2 + var5];
                        if(client.field526 <= 0) {
                           client.field526 = 1;
                        }

                        client.field543 = (short)class36.field789[3 + var5];
                        if(client.field543 <= 0) {
                           client.field543 = 32767;
                        } else if(client.field543 < client.field526) {
                           client.field543 = client.field526;
                        }
                        continue;
                     }

                     if(var39 == 6203) {
                        if(client.field454 != null) {
                           class30.method655(0, 0, client.field454.field2791, client.field454.field2792, false);
                           class36.field789[var5++] = client.field414;
                           class36.field789[var5++] = client.field547;
                        } else {
                           class36.field789[var5++] = -1;
                           class36.field789[var5++] = -1;
                        }
                        continue;
                     }

                     if(var39 == 6204) {
                        class36.field789[var5++] = client.field538;
                        class36.field789[var5++] = client.field518;
                        continue;
                     }

                     if(var39 == 6205) {
                        class36.field789[var5++] = client.field536;
                        class36.field789[var5++] = client.field419;
                        continue;
                     }
                  }

                  if(var39 < 6600) {
                     if(var39 == 6500) {
                        class36.field789[var5++] = class16.method163()?1:0;
                        continue;
                     }

                     class25 var71;
                     if(var39 == 6501) {
                        class25.field634 = 0;
                        if(class25.field634 < class25.field629) {
                           var71 = class25.field636[++class25.field634 - 1];
                        } else {
                           var16 = null;
                        }

                        class36.field789[var5++] = -1;
                        class36.field789[var5++] = 0;
                        class36.field796[var6++] = "";
                        class36.field789[var5++] = 0;
                        class36.field789[var5++] = 0;
                        class36.field796[var6++] = "";
                        continue;
                     }

                     if(var39 == 6502) {
                        class25 var101;
                        if(class25.field634 < class25.field629) {
                           var101 = class25.field636[++class25.field634 - 1];
                        } else {
                           var101 = null;
                        }

                        if(null != var101) {
                           class36.field789[var5++] = var101.field637;
                           class36.field789[var5++] = var101.field645;
                           class36.field796[var6++] = var101.field633;
                           class36.field789[var5++] = var101.field642;
                           class36.field789[var5++] = var101.field639;
                           class36.field796[var6++] = var101.field640;
                        } else {
                           class36.field789[var5++] = -1;
                           class36.field789[var5++] = 0;
                           class36.field796[var6++] = "";
                           class36.field789[var5++] = 0;
                           class36.field789[var5++] = 0;
                           class36.field796[var6++] = "";
                        }
                        continue;
                     }

                     if(var39 == 6506) {
                        --var5;
                        var15 = class36.field789[var5];
                        var71 = null;

                        for(var73 = 0; var73 < class25.field629; ++var73) {
                           if(var15 == class25.field636[var73].field637) {
                              var71 = class25.field636[var73];
                              break;
                           }
                        }

                        if(null != var71) {
                           class36.field789[var5++] = var71.field637;
                           class36.field789[var5++] = var71.field645;
                           class36.field796[var6++] = var71.field633;
                           class36.field789[var5++] = var71.field642;
                           class36.field789[var5++] = var71.field639;
                           class36.field796[var6++] = var71.field640;
                        } else {
                           class36.field789[var5++] = -1;
                           class36.field789[var5++] = 0;
                           class36.field796[var6++] = "";
                           class36.field789[var5++] = 0;
                           class36.field789[var5++] = 0;
                           class36.field796[var6++] = "";
                        }
                        continue;
                     }

                     if(var39 == 6507) {
                        var5 -= 4;
                        var15 = class36.field789[var5];
                        var91 = class36.field789[var5 + 1] == 1;
                        var73 = class36.field789[2 + var5];
                        var69 = class36.field789[var5 + 3] == 1;
                        class163.method3186(var15, var91, var73, var69);
                        continue;
                     }

                     if(var39 == 6511) {
                        --var5;
                        var15 = class36.field789[var5];
                        if(var15 >= 0 && var15 < class25.field629) {
                           var71 = class25.field636[var15];
                           class36.field789[var5++] = var71.field637;
                           class36.field789[var5++] = var71.field645;
                           class36.field796[var6++] = var71.field633;
                           class36.field789[var5++] = var71.field642;
                           class36.field789[var5++] = var71.field639;
                           class36.field796[var6++] = var71.field640;
                           continue;
                        }

                        class36.field789[var5++] = -1;
                        class36.field789[var5++] = 0;
                        class36.field796[var6++] = "";
                        class36.field789[var5++] = 0;
                        class36.field789[var5++] = 0;
                        class36.field796[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var38) {
            StringBuilder var37 = new StringBuilder(30);
            var37.append("").append(var4.field3125).append(" ");

            for(var13 = class36.field802 - 1; var13 >= 0; --var13) {
               var37.append("").append(class36.field792[var13].field215.field3125).append(" ");
            }

            var37.append("").append(var10);
            class30.method654(var37.toString(), var38);
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "-1399018835"
   )
   public static void method638(class167 var0) {
      class49.field1099 = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-63"
   )
   static void method639() {
      class32.field741 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class32.field736[var0] = null;
         class32.field739[var0] = 1;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)[Lclass78;",
      garbageValue = "90492401"
   )
   static class78[] method640(class167 var0, int var1, int var2) {
      return !class21.method551(var0, var1, var2)?null:class72.method1527();
   }
}

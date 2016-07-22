import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class43 extends class207 {
   @ObfuscatedName("m")
   public static class170 field994;
   @ObfuscatedName("w")
   public static class196 field995 = new class196(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 444550015
   )
   public int field996;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2118190143
   )
   public int field997;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -501996985
   )
   public int field999;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1684283751
   )
   public int field1000;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 695784349
   )
   int field1002 = 0;
   @ObfuscatedName("qb")
   protected static class136 field1003;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-71"
   )
   public void method883(class122 var1, int var2) {
      while(true) {
         int var3 = var1.method2556();
         if(var3 == 0) {
            return;
         }

         this.method885(var1, var3, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass0;IB)V",
      garbageValue = "67"
   )
   static void method884(class0 var0, int var1) {
      Object[] var2 = var0.field1;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class33.method705(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field591;
         int[] var9 = var4.field592;
         byte var10 = -1;
         class38.field819 = 0;

         int var13;
         try {
            class38.field813 = new int[var4.field596];
            int var11 = 0;
            class87.field1530 = new String[var4.field595];
            int var12 = 0;

            int var14;
            String var33;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field0;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field3 != null?var0.field3.field2795:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field9;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field3 != null?var0.field3.field2796:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field2 != null?var0.field2.field2795:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field2?var0.field2.field2796:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field11;
                  }

                  class38.field813[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var33 = (String)var2[var13];
                  if(var33.equals("event_opbase")) {
                     var33 = var0.field13;
                  }

                  class87.field1530[var12++] = var33;
               }
            }

            var13 = 0;
            class38.field826 = var0.field10;

            label3966:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var48 = var8[var7];
               String var17;
               int var18;
               int var36;
               int var38;
               int var39;
               String var54;
               int[] var56;
               int var59;
               String var68;
               String var70;
               int var93;
               byte var116;
               if(var48 < 100) {
                  if(var48 == 0) {
                     class38.field823[var5++] = var9[var7];
                     continue;
                  }

                  if(var48 == 1) {
                     var14 = var9[var7];
                     class38.field823[var5++] = class179.field2949[var14];
                     continue;
                  }

                  if(var48 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.field2949[var14] = class38.field823[var5];
                     class3.method36(var14);
                     continue;
                  }

                  if(var48 == 3) {
                     class38.field818[var6++] = var4.field593[var7];
                     continue;
                  }

                  if(var48 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var48 == 7) {
                     var5 -= 2;
                     if(class38.field823[var5] != class38.field823[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var48 == 8) {
                     var5 -= 2;
                     if(class38.field823[1 + var5] == class38.field823[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var48 == 9) {
                     var5 -= 2;
                     if(class38.field823[var5] < class38.field823[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var48 == 10) {
                     var5 -= 2;
                     if(class38.field823[var5] > class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var48 == 21) {
                     if(class38.field819 == 0) {
                        return;
                     }

                     class14 var94 = class38.field820[--class38.field819];
                     var4 = var94.field192;
                     var8 = var4.field591;
                     var9 = var4.field592;
                     var7 = var94.field193;
                     class38.field813 = var94.field189;
                     class87.field1530 = var94.field190;
                     continue;
                  }

                  if(var48 == 25) {
                     var14 = var9[var7];
                     class38.field823[var5++] = class12.method154(var14);
                     continue;
                  }

                  if(var48 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class166.method3268(var14, class38.field823[var5]);
                     continue;
                  }

                  if(var48 == 31) {
                     var5 -= 2;
                     if(class38.field823[var5] <= class38.field823[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var48 == 32) {
                     var5 -= 2;
                     if(class38.field823[var5] >= class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var48 == 33) {
                     class38.field823[var5++] = class38.field813[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var48 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class38.field813[var10001] = class38.field823[var5];
                     continue;
                  }

                  if(var48 == 35) {
                     class38.field818[var6++] = class87.field1530[var9[var7]];
                     continue;
                  }

                  if(var48 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class87.field1530[var10001] = class38.field818[var6];
                     continue;
                  }

                  if(var48 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var90 = class38.field818;
                     if(var14 == 0) {
                        var54 = "";
                     } else if(var14 == 1) {
                        var17 = var90[var6];
                        if(var17 == null) {
                           var54 = "null";
                        } else {
                           var54 = var17.toString();
                        }
                     } else {
                        var93 = var14 + var6;
                        var18 = 0;

                        for(var59 = var6; var59 < var93; ++var59) {
                           var70 = var90[var59];
                           if(null == var70) {
                              var18 += 4;
                           } else {
                              var18 += var70.length();
                           }
                        }

                        StringBuilder var112 = new StringBuilder(var18);

                        for(var36 = var6; var36 < var93; ++var36) {
                           var68 = var90[var36];
                           if(null == var68) {
                              var112.append("null");
                           } else {
                              var112.append(var68);
                           }
                        }

                        var54 = var112.toString();
                     }

                     class38.field818[var6++] = var54;
                     continue;
                  }

                  if(var48 == 38) {
                     --var5;
                     continue;
                  }

                  if(var48 == 39) {
                     --var6;
                     continue;
                  }

                  if(var48 == 40) {
                     var14 = var9[var7];
                     class23 var127 = class33.method705(var14);
                     var56 = new int[var127.field596];
                     String[] var75 = new String[var127.field595];

                     for(var18 = 0; var18 < var127.field597; ++var18) {
                        var56[var18] = class38.field823[var18 + (var5 - var127.field597)];
                     }

                     for(var18 = 0; var18 < var127.field590; ++var18) {
                        var75[var18] = class38.field818[var6 - var127.field590 + var18];
                     }

                     var5 -= var127.field597;
                     var6 -= var127.field590;
                     class14 var123 = new class14();
                     var123.field192 = var4;
                     var123.field193 = var7;
                     var123.field189 = class38.field813;
                     var123.field190 = class87.field1530;
                     class38.field820[++class38.field819 - 1] = var123;
                     var4 = var127;
                     var8 = var127.field591;
                     var9 = var127.field592;
                     var7 = -1;
                     class38.field813 = var56;
                     class87.field1530 = var75;
                     continue;
                  }

                  if(var48 == 42) {
                     class38.field823[var5++] = class33.field764.method195(var9[var7]);
                     continue;
                  }

                  if(var48 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class33.field764.method196(var10001, class38.field823[var5]);
                     continue;
                  }

                  if(var48 == 44) {
                     var14 = var9[var7] >> 16;
                     var38 = var9[var7] & '\uffff';
                     --var5;
                     var39 = class38.field823[var5];
                     if(var39 >= 0 && var39 <= 5000) {
                        class38.field815[var14] = var39;
                        var116 = -1;
                        if(var38 == 105) {
                           var116 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var39) {
                              continue label3966;
                           }

                           class38.field817[var14][var18] = var116;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var48 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var38 = class38.field823[var5];
                     if(var38 >= 0 && var38 < class38.field815[var14]) {
                        class38.field823[var5++] = class38.field817[var14][var38];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var48 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var38 = class38.field823[var5];
                     if(var38 >= 0 && var38 < class38.field815[var14]) {
                        class38.field817[var14][var38] = class38.field823[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var48 == 47) {
                     var33 = class33.field764.method199(var9[var7]);
                     if(var33 == null) {
                        var33 = "null";
                     }

                     class38.field818[var6++] = var33;
                     continue;
                  }

                  if(var48 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class33.field764.method198(var10001, class38.field818[var6]);
                     continue;
                  }
               }

               boolean var61;
               if(var9[var7] == 1) {
                  var61 = true;
               } else {
                  var61 = false;
               }

               class176 var15;
               class176 var16;
               class176 var37;
               class176 var49;
               boolean var60;
               int[] var88;
               boolean var105;
               if(var48 < 1000) {
                  if(var48 == 100) {
                     var5 -= 3;
                     var38 = class38.field823[var5];
                     var39 = class38.field823[1 + var5];
                     var93 = class38.field823[2 + var5];
                     if(var39 == 0) {
                        throw new RuntimeException();
                     }

                     var37 = class34.method720(var38);
                     if(var37.field2919 == null) {
                        var37.field2919 = new class176[var93 + 1];
                     }

                     if(var37.field2919.length <= var93) {
                        class176[] var108 = new class176[var93 + 1];

                        for(var36 = 0; var36 < var37.field2919.length; ++var36) {
                           var108[var36] = var37.field2919[var36];
                        }

                        var37.field2919 = var108;
                     }

                     if(var93 > 0 && null == var37.field2919[var93 - 1]) {
                        throw new RuntimeException("" + (var93 - 1));
                     }

                     class176 var110 = new class176();
                     var110.field2929 = var39;
                     var110.field2836 = var110.field2795 = var37.field2795;
                     var110.field2796 = var93;
                     var110.field2794 = true;
                     var37.field2919[var93] = var110;
                     if(var61) {
                        class38.field825 = var110;
                     } else {
                        class26.field640 = var110;
                     }

                     class92.method2164(var37);
                     continue;
                  }

                  if(var48 == 101) {
                     var15 = var61?class38.field825:class26.field640;
                     var16 = class34.method720(var15.field2795);
                     var16.field2919[var15.field2796] = null;
                     class92.method2164(var16);
                     continue;
                  }

                  if(var48 == 102) {
                     --var5;
                     var15 = class34.method720(class38.field823[var5]);
                     var15.field2919 = null;
                     class92.method2164(var15);
                     continue;
                  }

                  if(var48 == 200) {
                     var5 -= 2;
                     var38 = class38.field823[var5];
                     var39 = class38.field823[1 + var5];
                     var49 = class158.method3212(var38, var39);
                     if(var49 != null && var39 != -1) {
                        class38.field823[var5++] = 1;
                        if(var61) {
                           class38.field825 = var49;
                        } else {
                           class26.field640 = var49;
                        }
                        continue;
                     }

                     class38.field823[var5++] = 0;
                     continue;
                  }

                  if(var48 == 201) {
                     --var5;
                     var15 = class34.method720(class38.field823[var5]);
                     if(var15 != null) {
                        class38.field823[var5++] = 1;
                        if(var61) {
                           class38.field825 = var15;
                        } else {
                           class26.field640 = var15;
                        }
                     } else {
                        class38.field823[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var34;
                  if((var48 < 1000 || var48 >= 1100) && (var48 < 2000 || var48 >= 2100)) {
                     if(var48 >= 1100 && var48 < 1200 || var48 >= 2100 && var48 < 2200) {
                        var39 = -1;
                        if(var48 >= 2000) {
                           var48 -= 1000;
                           --var5;
                           var39 = class38.field823[var5];
                           var15 = class34.method720(var39);
                        } else {
                           var15 = var61?class38.field825:class26.field640;
                        }

                        if(var48 == 1100) {
                           var5 -= 2;
                           var15.field2894 = class38.field823[var5];
                           if(var15.field2894 > var15.field2818 - var15.field2926) {
                              var15.field2894 = var15.field2818 - var15.field2926;
                           }

                           if(var15.field2894 < 0) {
                              var15.field2894 = 0;
                           }

                           var15.field2817 = class38.field823[1 + var5];
                           if(var15.field2817 > var15.field2819 - var15.field2877) {
                              var15.field2817 = var15.field2819 - var15.field2877;
                           }

                           if(var15.field2817 < 0) {
                              var15.field2817 = 0;
                           }

                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1101) {
                           --var5;
                           var15.field2891 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1102) {
                           --var5;
                           var15.field2824 = class38.field823[var5] == 1;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1103) {
                           --var5;
                           var15.field2826 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1104) {
                           --var5;
                           var15.field2828 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1105) {
                           --var5;
                           var15.field2849 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1106) {
                           --var5;
                           var15.field2832 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1107) {
                           --var5;
                           var15.field2833 = class38.field823[var5] == 1;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1108) {
                           var15.field2786 = 1;
                           --var5;
                           var15.field2839 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1109) {
                           var5 -= 6;
                           var15.field2863 = class38.field823[var5];
                           var15.field2851 = class38.field823[var5 + 1];
                           var15.field2853 = class38.field823[var5 + 2];
                           var15.field2847 = class38.field823[3 + var5];
                           var15.field2848 = class38.field823[4 + var5];
                           var15.field2820 = class38.field823[var5 + 5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1110) {
                           --var5;
                           var93 = class38.field823[var5];
                           if(var93 != var15.field2831) {
                              var15.field2831 = var93;
                              var15.field2917 = 0;
                              var15.field2864 = 0;
                              class92.method2164(var15);
                           }
                           continue;
                        }

                        if(var48 == 1111) {
                           --var5;
                           var15.field2852 = class38.field823[var5] == 1;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1112) {
                           --var6;
                           var17 = class38.field818[var6];
                           if(!var17.equals(var15.field2855)) {
                              var15.field2855 = var17;
                              class92.method2164(var15);
                           }
                           continue;
                        }

                        if(var48 == 1113) {
                           --var5;
                           var15.field2854 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1114) {
                           var5 -= 3;
                           var15.field2858 = class38.field823[var5];
                           var15.field2859 = class38.field823[1 + var5];
                           var15.field2884 = class38.field823[2 + var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1115) {
                           --var5;
                           var15.field2860 = class38.field823[var5] == 1;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1116) {
                           --var5;
                           var15.field2844 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1117) {
                           --var5;
                           var15.field2835 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1118) {
                           --var5;
                           var15.field2846 = class38.field823[var5] == 1;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1119) {
                           --var5;
                           var15.field2837 = class38.field823[var5] == 1;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1120) {
                           var5 -= 2;
                           var15.field2818 = class38.field823[var5];
                           var15.field2819 = class38.field823[var5 + 1];
                           class92.method2164(var15);
                           if(var39 != -1 && var15.field2929 == 0) {
                              client.method551(class176.field2814[var39 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var48 == 1121) {
                           var93 = var15.field2795;
                           var18 = var15.field2796;
                           client.field313.method2797(65);
                           client.field313.method2605(var18);
                           client.field313.method2729(var93);
                           client.field402 = var15;
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1122) {
                           --var5;
                           var15.field2866 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1123) {
                           --var5;
                           var15.field2821 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1124) {
                           --var5;
                           var15.field2886 = class38.field823[var5];
                           class92.method2164(var15);
                           continue;
                        }

                        if(var48 == 1125) {
                           --var5;
                           var93 = class38.field823[var5];
                           class85[] var122 = new class85[]{class85.field1507, class85.field1508, class85.field1506, class85.field1504, class85.field1503};
                           class85 var106 = (class85)class5.method77(var122, var93);
                           if(null != var106) {
                              var15.field2811 = var106;
                              class92.method2164(var15);
                           }
                           continue;
                        }
                     } else if(var48 >= 1200 && var48 < 1300 || var48 >= 2200 && var48 < 2300) {
                        if(var48 >= 2000) {
                           var48 -= 1000;
                           --var5;
                           var15 = class34.method720(class38.field823[var5]);
                        } else {
                           var15 = var61?class38.field825:class26.field640;
                        }

                        class92.method2164(var15);
                        if(var48 == 1200 || var48 == 1205 || var48 == 1212) {
                           var5 -= 2;
                           var39 = class38.field823[var5];
                           var93 = class38.field823[var5 + 1];
                           var15.field2834 = var39;
                           var15.field2916 = var93;
                           class55 var121 = class4.method42(var39);
                           var15.field2853 = var121.field1216;
                           var15.field2847 = var121.field1190;
                           var15.field2848 = var121.field1189;
                           var15.field2863 = var121.field1192;
                           var15.field2851 = var121.field1193;
                           var15.field2820 = var121.field1188;
                           if(var48 == 1205) {
                              var15.field2913 = 0;
                           } else if(var48 == 1212 | var121.field1194 == 1) {
                              var15.field2913 = 1;
                           } else {
                              var15.field2913 = 2;
                           }

                           if(var15.field2897 > 0) {
                              var15.field2820 = var15.field2820 * 32 / var15.field2897;
                           } else if(var15.field2806 > 0) {
                              var15.field2820 = var15.field2820 * 32 / var15.field2806;
                           }
                           continue;
                        }

                        if(var48 == 1201) {
                           var15.field2786 = 2;
                           --var5;
                           var15.field2839 = class38.field823[var5];
                           continue;
                        }

                        if(var48 == 1202) {
                           var15.field2786 = 3;
                           var15.field2839 = class114.field2010.field50.method3544();
                           continue;
                        }
                     } else if(var48 >= 1300 && var48 < 1400 || var48 >= 2300 && var48 < 2400) {
                        if(var48 >= 2000) {
                           var48 -= 1000;
                           --var5;
                           var15 = class34.method720(class38.field823[var5]);
                        } else {
                           var15 = var61?class38.field825:class26.field640;
                        }

                        if(var48 == 1300) {
                           --var5;
                           var39 = class38.field823[var5] - 1;
                           if(var39 >= 0 && var39 <= 9) {
                              --var6;
                              var15.method3482(var39, class38.field818[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var48 == 1301) {
                           var5 -= 2;
                           var39 = class38.field823[var5];
                           var93 = class38.field823[1 + var5];
                           var15.field2870 = class158.method3212(var39, var93);
                           continue;
                        }

                        if(var48 == 1302) {
                           --var5;
                           var15.field2873 = class38.field823[var5] == 1;
                           continue;
                        }

                        if(var48 == 1303) {
                           --var5;
                           var15.field2825 = class38.field823[var5];
                           continue;
                        }

                        if(var48 == 1304) {
                           --var5;
                           var15.field2797 = class38.field823[var5];
                           continue;
                        }

                        if(var48 == 1305) {
                           --var6;
                           var15.field2868 = class38.field818[var6];
                           continue;
                        }

                        if(var48 == 1306) {
                           --var6;
                           var15.field2874 = class38.field818[var6];
                           continue;
                        }

                        if(var48 == 1307) {
                           var15.field2812 = null;
                           continue;
                        }
                     } else {
                        int[] var50;
                        String var55;
                        if(var48 >= 1400 && var48 < 1500 || var48 >= 2400 && var48 < 2500) {
                           if(var48 >= 2000) {
                              var48 -= 1000;
                              --var5;
                              var15 = class34.method720(class38.field823[var5]);
                           } else {
                              var15 = var61?class38.field825:class26.field640;
                           }

                           --var6;
                           var55 = class38.field818[var6];
                           var50 = null;
                           if(var55.length() > 0 && var55.charAt(var55.length() - 1) == 89) {
                              --var5;
                              var18 = class38.field823[var5];
                              if(var18 > 0) {
                                 for(var50 = new int[var18]; var18-- > 0; var50[var18] = class38.field823[var5]) {
                                    --var5;
                                 }
                              }

                              var55 = var55.substring(0, var55.length() - 1);
                           }

                           Object[] var119 = new Object[var55.length() + 1];

                           for(var59 = var119.length - 1; var59 >= 1; --var59) {
                              if(var55.charAt(var59 - 1) == 115) {
                                 --var6;
                                 var119[var59] = class38.field818[var6];
                              } else {
                                 --var5;
                                 var119[var59] = new Integer(class38.field823[var5]);
                              }
                           }

                           --var5;
                           var59 = class38.field823[var5];
                           if(var59 != -1) {
                              var119[0] = new Integer(var59);
                           } else {
                              var119 = null;
                           }

                           if(var48 == 1400) {
                              var15.field2838 = var119;
                           }

                           if(var48 == 1401) {
                              var15.field2880 = var119;
                           }

                           if(var48 == 1402) {
                              var15.field2879 = var119;
                           }

                           if(var48 == 1403) {
                              var15.field2881 = var119;
                           }

                           if(var48 == 1404) {
                              var15.field2883 = var119;
                           }

                           if(var48 == 1405) {
                              var15.field2842 = var119;
                           }

                           if(var48 == 1406) {
                              var15.field2887 = var119;
                           }

                           if(var48 == 1407) {
                              var15.field2808 = var119;
                              var15.field2899 = var50;
                           }

                           if(var48 == 1408) {
                              var15.field2871 = var119;
                           }

                           if(var48 == 1409) {
                              var15.field2895 = var119;
                           }

                           if(var48 == 1410) {
                              var15.field2885 = var119;
                           }

                           if(var48 == 1411) {
                              var15.field2878 = var119;
                           }

                           if(var48 == 1412) {
                              var15.field2882 = var119;
                           }

                           if(var48 == 1414) {
                              var15.field2890 = var119;
                              var15.field2827 = var50;
                           }

                           if(var48 == 1415) {
                              var15.field2892 = var119;
                              var15.field2893 = var50;
                           }

                           if(var48 == 1416) {
                              var15.field2905 = var119;
                           }

                           if(var48 == 1417) {
                              var15.field2896 = var119;
                           }

                           if(var48 == 1418) {
                              var15.field2925 = var119;
                           }

                           if(var48 == 1419) {
                              var15.field2898 = var119;
                           }

                           if(var48 == 1420) {
                              var15.field2789 = var119;
                           }

                           if(var48 == 1421) {
                              var15.field2900 = var119;
                           }

                           if(var48 == 1422) {
                              var15.field2901 = var119;
                           }

                           if(var48 == 1423) {
                              var15.field2902 = var119;
                           }

                           if(var48 == 1424) {
                              var15.field2903 = var119;
                           }

                           if(var48 == 1425) {
                              var15.field2801 = var119;
                           }

                           if(var48 == 1426) {
                              var15.field2906 = var119;
                           }

                           if(var48 == 1427) {
                              var15.field2904 = var119;
                           }

                           var15.field2807 = true;
                           continue;
                        }

                        if(var48 < 1600) {
                           var15 = var61?class38.field825:class26.field640;
                           if(var48 == 1500) {
                              class38.field823[var5++] = var15.field2804;
                              continue;
                           }

                           if(var48 == 1501) {
                              class38.field823[var5++] = var15.field2809;
                              continue;
                           }

                           if(var48 == 1502) {
                              class38.field823[var5++] = var15.field2926;
                              continue;
                           }

                           if(var48 == 1503) {
                              class38.field823[var5++] = var15.field2877;
                              continue;
                           }

                           if(var48 == 1504) {
                              class38.field823[var5++] = var15.field2815?1:0;
                              continue;
                           }

                           if(var48 == 1505) {
                              class38.field823[var5++] = var15.field2836;
                              continue;
                           }
                        } else if(var48 < 1700) {
                           var15 = var61?class38.field825:class26.field640;
                           if(var48 == 1600) {
                              class38.field823[var5++] = var15.field2894;
                              continue;
                           }

                           if(var48 == 1601) {
                              class38.field823[var5++] = var15.field2817;
                              continue;
                           }

                           if(var48 == 1602) {
                              class38.field818[var6++] = var15.field2855;
                              continue;
                           }

                           if(var48 == 1603) {
                              class38.field823[var5++] = var15.field2818;
                              continue;
                           }

                           if(var48 == 1604) {
                              class38.field823[var5++] = var15.field2819;
                              continue;
                           }

                           if(var48 == 1605) {
                              class38.field823[var5++] = var15.field2820;
                              continue;
                           }

                           if(var48 == 1606) {
                              class38.field823[var5++] = var15.field2853;
                              continue;
                           }

                           if(var48 == 1607) {
                              class38.field823[var5++] = var15.field2848;
                              continue;
                           }

                           if(var48 == 1608) {
                              class38.field823[var5++] = var15.field2847;
                              continue;
                           }

                           if(var48 == 1609) {
                              class38.field823[var5++] = var15.field2826;
                              continue;
                           }

                           if(var48 == 1610) {
                              class38.field823[var5++] = var15.field2886;
                              continue;
                           }

                           if(var48 == 1611) {
                              class38.field823[var5++] = var15.field2891;
                              continue;
                           }

                           if(var48 == 1612) {
                              class38.field823[var5++] = var15.field2821;
                              continue;
                           }

                           if(var48 == 1613) {
                              class38.field823[var5++] = var15.field2811.vmethod3218();
                              continue;
                           }
                        } else if(var48 < 1800) {
                           var15 = var61?class38.field825:class26.field640;
                           if(var48 == 1700) {
                              class38.field823[var5++] = var15.field2834;
                              continue;
                           }

                           if(var48 == 1701) {
                              if(var15.field2834 != -1) {
                                 class38.field823[var5++] = var15.field2916;
                              } else {
                                 class38.field823[var5++] = 0;
                              }
                              continue;
                           }

                           if(var48 == 1702) {
                              class38.field823[var5++] = var15.field2796;
                              continue;
                           }
                        } else if(var48 < 1900) {
                           var15 = var61?class38.field825:class26.field640;
                           if(var48 == 1800) {
                              class38.field823[var5++] = class25.method599(class12.method151(var15));
                              continue;
                           }

                           if(var48 == 1801) {
                              --var5;
                              var39 = class38.field823[var5];
                              --var39;
                              if(var15.field2812 != null && var39 < var15.field2812.length && var15.field2812[var39] != null) {
                                 class38.field818[var6++] = var15.field2812[var39];
                                 continue;
                              }

                              class38.field818[var6++] = "";
                              continue;
                           }

                           if(var48 == 1802) {
                              if(var15.field2868 == null) {
                                 class38.field818[var6++] = "";
                              } else {
                                 class38.field818[var6++] = var15.field2868;
                              }
                              continue;
                           }
                        } else if((var48 < 1900 || var48 >= 2000) && (var48 < 2900 || var48 >= 3000)) {
                           if(var48 < 2600) {
                              --var5;
                              var15 = class34.method720(class38.field823[var5]);
                              if(var48 == 2500) {
                                 class38.field823[var5++] = var15.field2804;
                                 continue;
                              }

                              if(var48 == 2501) {
                                 class38.field823[var5++] = var15.field2809;
                                 continue;
                              }

                              if(var48 == 2502) {
                                 class38.field823[var5++] = var15.field2926;
                                 continue;
                              }

                              if(var48 == 2503) {
                                 class38.field823[var5++] = var15.field2877;
                                 continue;
                              }

                              if(var48 == 2504) {
                                 class38.field823[var5++] = var15.field2815?1:0;
                                 continue;
                              }

                              if(var48 == 2505) {
                                 class38.field823[var5++] = var15.field2836;
                                 continue;
                              }
                           } else if(var48 < 2700) {
                              --var5;
                              var15 = class34.method720(class38.field823[var5]);
                              if(var48 == 2600) {
                                 class38.field823[var5++] = var15.field2894;
                                 continue;
                              }

                              if(var48 == 2601) {
                                 class38.field823[var5++] = var15.field2817;
                                 continue;
                              }

                              if(var48 == 2602) {
                                 class38.field818[var6++] = var15.field2855;
                                 continue;
                              }

                              if(var48 == 2603) {
                                 class38.field823[var5++] = var15.field2818;
                                 continue;
                              }

                              if(var48 == 2604) {
                                 class38.field823[var5++] = var15.field2819;
                                 continue;
                              }

                              if(var48 == 2605) {
                                 class38.field823[var5++] = var15.field2820;
                                 continue;
                              }

                              if(var48 == 2606) {
                                 class38.field823[var5++] = var15.field2853;
                                 continue;
                              }

                              if(var48 == 2607) {
                                 class38.field823[var5++] = var15.field2848;
                                 continue;
                              }

                              if(var48 == 2608) {
                                 class38.field823[var5++] = var15.field2847;
                                 continue;
                              }

                              if(var48 == 2609) {
                                 class38.field823[var5++] = var15.field2826;
                                 continue;
                              }

                              if(var48 == 2610) {
                                 class38.field823[var5++] = var15.field2886;
                                 continue;
                              }

                              if(var48 == 2611) {
                                 class38.field823[var5++] = var15.field2891;
                                 continue;
                              }

                              if(var48 == 2612) {
                                 class38.field823[var5++] = var15.field2821;
                                 continue;
                              }

                              if(var48 == 2613) {
                                 class38.field823[var5++] = var15.field2811.vmethod3218();
                                 continue;
                              }
                           } else if(var48 < 2800) {
                              if(var48 == 2700) {
                                 --var5;
                                 var15 = class34.method720(class38.field823[var5]);
                                 class38.field823[var5++] = var15.field2834;
                                 continue;
                              }

                              if(var48 == 2701) {
                                 --var5;
                                 var15 = class34.method720(class38.field823[var5]);
                                 if(var15.field2834 != -1) {
                                    class38.field823[var5++] = var15.field2916;
                                 } else {
                                    class38.field823[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var48 == 2702) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class3 var53 = (class3)client.field535.method3856((long)var38);
                                 if(null != var53) {
                                    class38.field823[var5++] = 1;
                                 } else {
                                    class38.field823[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var48 == 2706) {
                                 class38.field823[var5++] = client.field430;
                                 continue;
                              }
                           } else if(var48 < 2900) {
                              --var5;
                              var15 = class34.method720(class38.field823[var5]);
                              if(var48 == 2800) {
                                 class38.field823[var5++] = class25.method599(class12.method151(var15));
                                 continue;
                              }

                              if(var48 == 2801) {
                                 --var5;
                                 var39 = class38.field823[var5];
                                 --var39;
                                 if(var15.field2812 != null && var39 < var15.field2812.length && var15.field2812[var39] != null) {
                                    class38.field818[var6++] = var15.field2812[var39];
                                    continue;
                                 }

                                 class38.field818[var6++] = "";
                                 continue;
                              }

                              if(var48 == 2802) {
                                 if(null == var15.field2868) {
                                    class38.field818[var6++] = "";
                                 } else {
                                    class38.field818[var6++] = var15.field2868;
                                 }
                                 continue;
                              }
                           } else if(var48 < 3200) {
                              if(var48 == 3100) {
                                 --var6;
                                 var54 = class38.field818[var6];
                                 class59.method1304(0, "", var54);
                                 continue;
                              }

                              if(var48 == 3101) {
                                 var5 -= 2;
                                 class16.method179(class114.field2010, class38.field823[var5], class38.field823[1 + var5]);
                                 continue;
                              }

                              if(var48 == 3103) {
                                 class7.method98();
                                 continue;
                              }

                              if(var48 == 3104) {
                                 --var6;
                                 var54 = class38.field818[var6];
                                 var39 = 0;
                                 var34 = class20.method557(var54, 10, true);
                                 if(var34) {
                                    var39 = class136.method2912(var54);
                                 }

                                 client.field313.method2797(236);
                                 client.field313.method2560(var39);
                                 continue;
                              }

                              if(var48 == 3105) {
                                 --var6;
                                 var54 = class38.field818[var6];
                                 client.field313.method2797(112);
                                 client.field313.method2557(var54.length() + 1);
                                 client.field313.method2563(var54);
                                 continue;
                              }

                              if(var48 == 3106) {
                                 --var6;
                                 var54 = class38.field818[var6];
                                 client.field313.method2797(165);
                                 client.field313.method2557(var54.length() + 1);
                                 client.field313.method2563(var54);
                                 continue;
                              }

                              if(var48 == 3107) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 --var6;
                                 var55 = class38.field818[var6];
                                 var93 = class34.field777;
                                 int[] var98 = class34.field780;
                                 boolean var19 = false;

                                 for(var36 = 0; var36 < var93; ++var36) {
                                    class2 var21 = client.field393[var98[var36]];
                                    if(null != var21 && var21 != class114.field2010 && null != var21.field43 && var21.field43.equalsIgnoreCase(var55)) {
                                       if(var38 == 1) {
                                          client.field313.method2797(242);
                                          client.field313.method2596(0);
                                          client.field313.method2567(var98[var36]);
                                       } else if(var38 == 4) {
                                          client.field313.method2797(220);
                                          client.field313.method2567(var98[var36]);
                                          client.field313.method2595(0);
                                       } else if(var38 == 6) {
                                          client.field313.method2797(11);
                                          client.field313.method2597(0);
                                          client.field313.method2567(var98[var36]);
                                       } else if(var38 == 7) {
                                          client.field313.method2797(95);
                                          client.field313.method2567(var98[var36]);
                                          client.field313.method2595(0);
                                       }

                                       var19 = true;
                                       break;
                                    }
                                 }

                                 if(!var19) {
                                    class59.method1304(4, "", "Unable to find " + var55);
                                 }
                                 continue;
                              }

                              if(var48 == 3108) {
                                 var5 -= 3;
                                 var38 = class38.field823[var5];
                                 var39 = class38.field823[1 + var5];
                                 var93 = class38.field823[2 + var5];
                                 var37 = class34.method720(var93);
                                 class223.method4080(var37, var38, var39);
                                 continue;
                              }

                              if(var48 == 3109) {
                                 var5 -= 2;
                                 var38 = class38.field823[var5];
                                 var39 = class38.field823[1 + var5];
                                 var49 = var61?class38.field825:class26.field640;
                                 class223.method4080(var49, var38, var39);
                                 continue;
                              }

                              if(var48 == 3110) {
                                 --var5;
                                 class17.field235 = class38.field823[var5] == 1;
                                 continue;
                              }

                              if(var48 == 3111) {
                                 class38.field823[var5++] = class12.field162.field127?1:0;
                                 continue;
                              }

                              if(var48 == 3112) {
                                 --var5;
                                 class12.field162.field127 = class38.field823[var5] == 1;
                                 class32.method679();
                                 continue;
                              }

                              if(var48 == 3113) {
                                 --var6;
                                 var54 = class38.field818[var6];
                                 --var5;
                                 var105 = class38.field823[var5] == 1;
                                 class157.method3211(var54, var105, "openjs", false);
                                 continue;
                              }

                              if(var48 == 3115) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 client.field313.method2797(170);
                                 client.field313.method2558(var38);
                                 continue;
                              }

                              if(var48 == 3116) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 var6 -= 2;
                                 var55 = class38.field818[var6];
                                 var17 = class38.field818[1 + var6];
                                 if(var55.length() <= 500 && var17.length() <= 500) {
                                    client.field313.method2797(187);
                                    client.field313.method2558(1 + class77.method1679(var55) + class77.method1679(var17));
                                    client.field313.method2563(var17);
                                    client.field313.method2595(var38);
                                    client.field313.method2563(var55);
                                 }
                                 continue;
                              }
                           } else if(var48 < 3300) {
                              if(var48 == 3200) {
                                 var5 -= 3;
                                 class22.method572(class38.field823[var5], class38.field823[1 + var5], class38.field823[var5 + 2]);
                                 continue;
                              }

                              if(var48 == 3201) {
                                 --var5;
                                 class28.method648(class38.field823[var5]);
                                 continue;
                              }

                              if(var48 == 3202) {
                                 var5 -= 2;
                                 class96.method2248(class38.field823[var5], class38.field823[var5 + 1]);
                                 continue;
                              }
                           } else if(var48 < 3400) {
                              if(var48 == 3300) {
                                 class38.field823[var5++] = client.field282;
                                 continue;
                              }

                              class15 var20;
                              if(var48 == 3301) {
                                 var5 -= 2;
                                 var38 = class38.field823[var5];
                                 var39 = class38.field823[var5 + 1];
                                 var50 = class38.field823;
                                 var18 = var5++;
                                 var20 = (class15)class15.field204.method3856((long)var38);
                                 if(var20 == null) {
                                    var59 = -1;
                                 } else if(var39 >= 0 && var39 < var20.field206.length) {
                                    var59 = var20.field206[var39];
                                 } else {
                                    var59 = -1;
                                 }

                                 var50[var18] = var59;
                                 continue;
                              }

                              if(var48 == 3302) {
                                 var5 -= 2;
                                 var38 = class38.field823[var5];
                                 var39 = class38.field823[1 + var5];
                                 class38.field823[var5++] = class78.method1721(var38, var39);
                                 continue;
                              }

                              if(var48 == 3303) {
                                 var5 -= 2;
                                 var38 = class38.field823[var5];
                                 var39 = class38.field823[var5 + 1];
                                 class38.field823[var5++] = class26.method613(var38, var39);
                                 continue;
                              }

                              if(var48 == 3304) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 var56 = class38.field823;
                                 var93 = var5++;
                                 class54 var35 = (class54)class54.field1166.method3817((long)var38);
                                 class54 var99;
                                 if(null != var35) {
                                    var99 = var35;
                                 } else {
                                    byte[] var62 = class54.field1170.method3304(5, var38);
                                    var35 = new class54();
                                    if(null != var62) {
                                       var35.method1129(new class122(var62));
                                    }

                                    class54.field1166.method3823(var35, (long)var38);
                                    var99 = var35;
                                 }

                                 var56[var93] = var99.field1167;
                                 continue;
                              }

                              if(var48 == 3305) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class38.field823[var5++] = client.field407[var38];
                                 continue;
                              }

                              if(var48 == 3306) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class38.field823[var5++] = client.field408[var38];
                                 continue;
                              }

                              if(var48 == 3307) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class38.field823[var5++] = client.field469[var38];
                                 continue;
                              }

                              if(var48 == 3308) {
                                 var38 = class51.field1119;
                                 var39 = class39.field838 + (class114.field2010.field864 >> 7);
                                 var93 = (class114.field2010.field831 >> 7) + class13.field184;
                                 class38.field823[var5++] = (var38 << 28) + (var39 << 14) + var93;
                                 continue;
                              }

                              if(var48 == 3309) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class38.field823[var5++] = var38 >> 14 & 16383;
                                 continue;
                              }

                              if(var48 == 3310) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class38.field823[var5++] = var38 >> 28;
                                 continue;
                              }

                              if(var48 == 3311) {
                                 --var5;
                                 var38 = class38.field823[var5];
                                 class38.field823[var5++] = var38 & 16383;
                                 continue;
                              }

                              if(var48 == 3312) {
                                 class38.field823[var5++] = client.field276?1:0;
                                 continue;
                              }

                              if(var48 == 3313) {
                                 var5 -= 2;
                                 var38 = class38.field823[var5] + '耀';
                                 var39 = class38.field823[var5 + 1];
                                 var50 = class38.field823;
                                 var18 = var5++;
                                 var20 = (class15)class15.field204.method3856((long)var38);
                                 if(null == var20) {
                                    var59 = -1;
                                 } else if(var39 >= 0 && var39 < var20.field206.length) {
                                    var59 = var20.field206[var39];
                                 } else {
                                    var59 = -1;
                                 }

                                 var50[var18] = var59;
                                 continue;
                              }

                              if(var48 == 3314) {
                                 var5 -= 2;
                                 var38 = class38.field823[var5] + '耀';
                                 var39 = class38.field823[var5 + 1];
                                 class38.field823[var5++] = class78.method1721(var38, var39);
                                 continue;
                              }

                              if(var48 == 3315) {
                                 var5 -= 2;
                                 var38 = '耀' + class38.field823[var5];
                                 var39 = class38.field823[var5 + 1];
                                 class38.field823[var5++] = class26.method613(var38, var39);
                                 continue;
                              }

                              if(var48 == 3316) {
                                 if(client.field409 >= 2) {
                                    class38.field823[var5++] = client.field409;
                                 } else {
                                    class38.field823[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var48 == 3317) {
                                 class38.field823[var5++] = client.field289;
                                 continue;
                              }

                              if(var48 == 3318) {
                                 class38.field823[var5++] = client.field272;
                                 continue;
                              }

                              if(var48 == 3321) {
                                 class38.field823[var5++] = client.field435;
                                 continue;
                              }

                              if(var48 == 3322) {
                                 class38.field823[var5++] = client.field436;
                                 continue;
                              }

                              if(var48 == 3323) {
                                 if(client.field439) {
                                    class38.field823[var5++] = 1;
                                 } else {
                                    class38.field823[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var48 == 3324) {
                                 class38.field823[var5++] = client.field480;
                                 continue;
                              }
                           } else {
                              int var40;
                              if(var48 < 3500) {
                                 if(var48 == 3400) {
                                    var5 -= 2;
                                    var38 = class38.field823[var5];
                                    var39 = class38.field823[1 + var5];
                                    class52 var102 = (class52)class52.field1143.method3817((long)var38);
                                    class52 var52;
                                    if(null != var102) {
                                       var52 = var102;
                                    } else {
                                       byte[] var96 = class52.field1149.method3304(8, var38);
                                       var102 = new class52();
                                       if(null != var96) {
                                          var102.method1099(new class122(var96));
                                       }

                                       class52.field1143.method3823(var102, (long)var38);
                                       var52 = var102;
                                    }

                                    var102 = var52;
                                    if(var52.field1145 != 115) {
                                       ;
                                    }

                                    for(var59 = 0; var59 < var102.field1142; ++var59) {
                                       if(var39 == var102.field1153[var59]) {
                                          class38.field818[var6++] = var102.field1151[var59];
                                          var102 = null;
                                          break;
                                       }
                                    }

                                    if(var102 != null) {
                                       class38.field818[var6++] = var102.field1146;
                                    }
                                    continue;
                                 }

                                 if(var48 == 3408) {
                                    var5 -= 4;
                                    var38 = class38.field823[var5];
                                    var39 = class38.field823[var5 + 1];
                                    var93 = class38.field823[var5 + 2];
                                    var18 = class38.field823[var5 + 3];
                                    class52 var65 = (class52)class52.field1143.method3817((long)var93);
                                    class52 var95;
                                    if(null != var65) {
                                       var95 = var65;
                                    } else {
                                       byte[] var66 = class52.field1149.method3304(8, var93);
                                       var65 = new class52();
                                       if(null != var66) {
                                          var65.method1099(new class122(var66));
                                       }

                                       class52.field1143.method3823(var65, (long)var93);
                                       var95 = var65;
                                    }

                                    var65 = var95;
                                    if(var95.field1147 == var38 && var95.field1145 == var39) {
                                       for(var40 = 0; var40 < var65.field1142; ++var40) {
                                          if(var18 == var65.field1153[var40]) {
                                             if(var39 == 115) {
                                                class38.field818[var6++] = var65.field1151[var40];
                                             } else {
                                                class38.field823[var5++] = var65.field1150[var40];
                                             }

                                             var65 = null;
                                             break;
                                          }
                                       }

                                       if(var65 != null) {
                                          if(var39 == 115) {
                                             class38.field818[var6++] = var65.field1146;
                                          } else {
                                             class38.field823[var5++] = var65.field1152;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var39 == 115) {
                                       class38.field818[var6++] = "null";
                                    } else {
                                       class38.field823[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var23;
                                 int var24;
                                 String var97;
                                 if(var48 < 3700) {
                                    if(var48 == 3600) {
                                       if(client.field538 == 0) {
                                          class38.field823[var5++] = -2;
                                       } else if(client.field538 == 1) {
                                          class38.field823[var5++] = -1;
                                       } else {
                                          class38.field823[var5++] = client.field537;
                                       }
                                       continue;
                                    }

                                    if(var48 == 3601) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(client.field538 == 2 && var38 < client.field537) {
                                          class38.field818[var6++] = client.field273[var38].field229;
                                          class38.field818[var6++] = client.field273[var38].field224;
                                          continue;
                                       }

                                       class38.field818[var6++] = "";
                                       class38.field818[var6++] = "";
                                       continue;
                                    }

                                    if(var48 == 3602) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(client.field538 == 2 && var38 < client.field537) {
                                          class38.field823[var5++] = client.field273[var38].field223;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var48 == 3603) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(client.field538 == 2 && var38 < client.field537) {
                                          class38.field823[var5++] = client.field273[var38].field226;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var48 == 3604) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       --var5;
                                       var39 = class38.field823[var5];
                                       client.field313.method2797(145);
                                       client.field313.method2557(class77.method1679(var54) + 1);
                                       client.field313.method2563(var54);
                                       client.field313.method2597(var39);
                                       continue;
                                    }

                                    if(var48 == 3605) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       class7.method97(var54);
                                       continue;
                                    }

                                    if(var48 == 3606) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       class1.method8(var54);
                                       continue;
                                    }

                                    if(var48 == 3607) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       if(var54 == null) {
                                          continue;
                                       }

                                       if((client.field543 < 100 || client.field549 == 1) && client.field543 < 400) {
                                          var55 = class23.method579(var54, class134.field2117);
                                          if(null == var55) {
                                             continue;
                                          }

                                          for(var93 = 0; var93 < client.field543; ++var93) {
                                             class7 var113 = client.field384[var93];
                                             var97 = class23.method579(var113.field120, class134.field2117);
                                             if(var97 != null && var97.equals(var55)) {
                                                class59.method1304(31, "", var54 + " is already on your ignore list");
                                                continue label3966;
                                             }

                                             if(var113.field122 != null) {
                                                var70 = class23.method579(var113.field122, class134.field2117);
                                                if(var70 != null && var70.equals(var55)) {
                                                   class59.method1304(31, "", var54 + " is already on your ignore list");
                                                   continue label3966;
                                                }
                                             }
                                          }

                                          for(var93 = 0; var93 < client.field537; ++var93) {
                                             class17 var114 = client.field273[var93];
                                             var97 = class23.method579(var114.field229, class134.field2117);
                                             if(var97 != null && var97.equals(var55)) {
                                                class59.method1304(31, "", "Please remove " + var54 + " from your friend list first");
                                                continue label3966;
                                             }

                                             if(var114.field224 != null) {
                                                var70 = class23.method579(var114.field224, class134.field2117);
                                                if(var70 != null && var70.equals(var55)) {
                                                   class59.method1304(31, "", "Please remove " + var54 + " from your friend list first");
                                                   continue label3966;
                                                }
                                             }
                                          }

                                          if(class23.method579(class114.field2010.field43, class134.field2117).equals(var55)) {
                                             class59.method1304(31, "", "You can\'t add yourself to your own ignore list");
                                          } else {
                                             client.field313.method2797(180);
                                             client.field313.method2557(class77.method1679(var54));
                                             client.field313.method2563(var54);
                                          }
                                          continue;
                                       }

                                       class59.method1304(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                       continue;
                                    }

                                    if(var48 == 3608) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       class52.method1109(var54);
                                       continue;
                                    }

                                    if(var48 == 3609) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       class155[] var58 = class142.method3000();

                                       for(var93 = 0; var93 < var58.length; ++var93) {
                                          class155 var111 = var58[var93];
                                          if(var111.field2323 != -1) {
                                             var40 = var111.field2323;
                                             var70 = "<img=" + var40 + ">";
                                             if(var54.startsWith(var70)) {
                                                var54 = var54.substring(6 + Integer.toString(var111.field2323).length());
                                                break;
                                             }
                                          }
                                       }

                                       class38.field823[var5++] = class166.method3234(var54, false)?1:0;
                                       continue;
                                    }

                                    char var25;
                                    String[] var64;
                                    String var107;
                                    long var109;
                                    if(var48 == 3611) {
                                       if(null == client.field497) {
                                          class38.field818[var6++] = "";
                                          continue;
                                       }

                                       var64 = class38.field818;
                                       var39 = var6++;
                                       var107 = client.field497;
                                       var109 = 0L;
                                       var23 = var107.length();

                                       for(var24 = 0; var24 < var23; ++var24) {
                                          var109 *= 37L;
                                          var25 = var107.charAt(var24);
                                          if(var25 >= 65 && var25 <= 90) {
                                             var109 += (long)(1 + var25 - 65);
                                          } else if(var25 >= 97 && var25 <= 122) {
                                             var109 += (long)(var25 + 1 - 97);
                                          } else if(var25 >= 48 && var25 <= 57) {
                                             var109 += (long)(var25 + 27 - 48);
                                          }

                                          if(var109 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(0L == var109 % 37L && 0L != var109) {
                                          var109 /= 37L;
                                       }

                                       var68 = class59.method1251(var109);
                                       if(var68 == null) {
                                          var68 = "";
                                       }

                                       var64[var39] = var68;
                                       continue;
                                    }

                                    if(var48 == 3612) {
                                       if(null != client.field497) {
                                          class38.field823[var5++] = class152.field2300;
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var48 == 3613) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(null != client.field497 && var38 < class152.field2300) {
                                          class38.field818[var6++] = class17.field236[var38].field631;
                                          continue;
                                       }

                                       class38.field818[var6++] = "";
                                       continue;
                                    }

                                    if(var48 == 3614) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(null != client.field497 && var38 < class152.field2300) {
                                          class38.field823[var5++] = class17.field236[var38].field630;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var48 == 3615) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(null != client.field497 && var38 < class152.field2300) {
                                          class38.field823[var5++] = class17.field236[var38].field634;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var48 == 3616) {
                                       class38.field823[var5++] = class124.field2062;
                                       continue;
                                    }

                                    if(var48 == 3617) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       if(null != class17.field236) {
                                          client.field313.method2797(7);
                                          client.field313.method2557(class77.method1679(var54));
                                          client.field313.method2563(var54);
                                       }
                                       continue;
                                    }

                                    if(var48 == 3618) {
                                       class38.field823[var5++] = class13.field181;
                                       continue;
                                    }

                                    if(var48 == 3619) {
                                       --var6;
                                       var54 = class38.field818[var6];
                                       if(!var54.equals("")) {
                                          client.field313.method2797(214);
                                          client.field313.method2557(class77.method1679(var54));
                                          client.field313.method2563(var54);
                                       }
                                       continue;
                                    }

                                    if(var48 == 3620) {
                                       class0.method1();
                                       continue;
                                    }

                                    if(var48 == 3621) {
                                       if(client.field538 == 0) {
                                          class38.field823[var5++] = -1;
                                       } else {
                                          class38.field823[var5++] = client.field543;
                                       }
                                       continue;
                                    }

                                    if(var48 == 3622) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(client.field538 != 0 && var38 < client.field543) {
                                          class38.field818[var6++] = client.field384[var38].field120;
                                          class38.field818[var6++] = client.field384[var38].field122;
                                          continue;
                                       }

                                       class38.field818[var6++] = "";
                                       class38.field818[var6++] = "";
                                       continue;
                                    }

                                    if(var48 == 3623) {
                                       label3611: {
                                          --var6;
                                          var54 = class38.field818[var6];
                                          var17 = "<img=0>";
                                          if(!var54.startsWith(var17)) {
                                             var97 = "<img=1>";
                                             if(!var54.startsWith(var97)) {
                                                break label3611;
                                             }
                                          }

                                          var54 = var54.substring(7);
                                       }

                                       class38.field823[var5++] = class53.method1118(var54)?1:0;
                                       continue;
                                    }

                                    if(var48 == 3624) {
                                       --var5;
                                       var38 = class38.field823[var5];
                                       if(null != class17.field236 && var38 < class152.field2300 && class17.field236[var38].field631.equalsIgnoreCase(class114.field2010.field43)) {
                                          class38.field823[var5++] = 1;
                                          continue;
                                       }

                                       class38.field823[var5++] = 0;
                                       continue;
                                    }

                                    if(var48 == 3625) {
                                       if(client.field498 == null) {
                                          class38.field818[var6++] = "";
                                          continue;
                                       }

                                       var64 = class38.field818;
                                       var39 = var6++;
                                       var107 = client.field498;
                                       var109 = 0L;
                                       var23 = var107.length();

                                       for(var24 = 0; var24 < var23; ++var24) {
                                          var109 *= 37L;
                                          var25 = var107.charAt(var24);
                                          if(var25 >= 65 && var25 <= 90) {
                                             var109 += (long)(1 + var25 - 65);
                                          } else if(var25 >= 97 && var25 <= 122) {
                                             var109 += (long)(1 + var25 - 97);
                                          } else if(var25 >= 48 && var25 <= 57) {
                                             var109 += (long)(var25 + 27 - 48);
                                          }

                                          if(var109 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var109 % 37L == 0L && 0L != var109) {
                                          var109 /= 37L;
                                       }

                                       var68 = class59.method1251(var109);
                                       if(null == var68) {
                                          var68 = "";
                                       }

                                       var64[var39] = var68;
                                       continue;
                                    }
                                 } else {
                                    long var101;
                                    if(var48 < 4000) {
                                       if(var48 == 3903) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = client.field546[var38].method4067();
                                          continue;
                                       }

                                       if(var48 == 3904) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = client.field546[var38].field3218;
                                          continue;
                                       }

                                       if(var48 == 3905) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = client.field546[var38].field3217;
                                          continue;
                                       }

                                       if(var48 == 3906) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = client.field546[var38].field3220;
                                          continue;
                                       }

                                       if(var48 == 3907) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = client.field546[var38].field3221;
                                          continue;
                                       }

                                       if(var48 == 3908) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = client.field546[var38].field3219;
                                          continue;
                                       }

                                       if(var48 == 3910) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var39 = client.field546[var38].method4065();
                                          class38.field823[var5++] = var39 == 0?1:0;
                                          continue;
                                       }

                                       if(var48 == 3911) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var39 = client.field546[var38].method4065();
                                          class38.field823[var5++] = var39 == 2?1:0;
                                          continue;
                                       }

                                       if(var48 == 3912) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var39 = client.field546[var38].method4065();
                                          class38.field823[var5++] = var39 == 5?1:0;
                                          continue;
                                       }

                                       if(var48 == 3913) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var39 = client.field546[var38].method4065();
                                          class38.field823[var5++] = var39 == 1?1:0;
                                          continue;
                                       }

                                       boolean var120;
                                       if(var48 == 3914) {
                                          --var5;
                                          var120 = class38.field823[var5] == 1;
                                          if(class137.field2125 != null) {
                                             class137.field2125.method4082(class224.field3226, var120);
                                          }
                                          continue;
                                       }

                                       if(var48 == 3915) {
                                          --var5;
                                          var120 = class38.field823[var5] == 1;
                                          if(null != class137.field2125) {
                                             class137.field2125.method4082(class224.field3225, var120);
                                          }
                                          continue;
                                       }

                                       if(var48 == 3916) {
                                          var5 -= 2;
                                          var120 = class38.field823[var5] == 1;
                                          var105 = class38.field823[var5 + 1] == 1;
                                          if(null != class137.field2125) {
                                             class137.field2125.method4082(new class22(var105), var120);
                                          }
                                          continue;
                                       }

                                       if(var48 == 3917) {
                                          --var5;
                                          var120 = class38.field823[var5] == 1;
                                          if(class137.field2125 != null) {
                                             class137.field2125.method4082(class224.field3227, var120);
                                          }
                                          continue;
                                       }

                                       if(var48 == 3918) {
                                          --var5;
                                          var120 = class38.field823[var5] == 1;
                                          if(null != class137.field2125) {
                                             class137.field2125.method4082(class224.field3223, var120);
                                          }
                                          continue;
                                       }

                                       if(var48 == 3919) {
                                          class38.field823[var5++] = null == class137.field2125?0:class137.field2125.field3224.size();
                                          continue;
                                       }

                                       class217 var63;
                                       if(var48 == 3920) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          class38.field823[var5++] = var63.field3201;
                                          continue;
                                       }

                                       if(var48 == 3921) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          class38.field818[var6++] = var63.method4031();
                                          continue;
                                       }

                                       if(var48 == 3922) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          class38.field818[var6++] = var63.method4027();
                                          continue;
                                       }

                                       if(var48 == 3923) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          var101 = class193.method3805() - class143.field2225 - var63.field3197;
                                          var59 = (int)(var101 / 3600000L);
                                          var36 = (int)((var101 - (long)(3600000 * var59)) / 60000L);
                                          var40 = (int)((var101 - (long)(3600000 * var59) - (long)('\uea60' * var36)) / 1000L);
                                          String var22 = var59 + ":" + var36 / 10 + var36 % 10 + ":" + var40 / 10 + var40 % 10;
                                          class38.field818[var6++] = var22;
                                          continue;
                                       }

                                       if(var48 == 3924) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          class38.field823[var5++] = var63.field3198.field3220;
                                          continue;
                                       }

                                       if(var48 == 3925) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          class38.field823[var5++] = var63.field3198.field3217;
                                          continue;
                                       }

                                       if(var48 == 3926) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          var63 = (class217)class137.field2125.field3224.get(var38);
                                          class38.field823[var5++] = var63.field3198.field3218;
                                          continue;
                                       }
                                    } else if(var48 < 4100) {
                                       if(var48 == 4000) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var39 + var38;
                                          continue;
                                       }

                                       if(var48 == 4001) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var38 - var39;
                                          continue;
                                       }

                                       if(var48 == 4002) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var39 * var38;
                                          continue;
                                       }

                                       if(var48 == 4003) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var38 / var39;
                                          continue;
                                       }

                                       if(var48 == 4004) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = (int)(Math.random() * (double)var38);
                                          continue;
                                       }

                                       if(var48 == 4005) {
                                          --var5;
                                          var38 = class38.field823[var5];
                                          class38.field823[var5++] = (int)(Math.random() * (double)(1 + var38));
                                          continue;
                                       }

                                       if(var48 == 4006) {
                                          var5 -= 5;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          var93 = class38.field823[var5 + 2];
                                          var18 = class38.field823[var5 + 3];
                                          var59 = class38.field823[4 + var5];
                                          class38.field823[var5++] = var38 + (var39 - var38) * (var59 - var93) / (var18 - var93);
                                          continue;
                                       }

                                       if(var48 == 4007) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var38 + var39 * var38 / 100;
                                          continue;
                                       }

                                       if(var48 == 4008) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var38 | 1 << var39;
                                          continue;
                                       }

                                       if(var48 == 4009) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[var5 + 1];
                                          class38.field823[var5++] = var38 & -1 - (1 << var39);
                                          continue;
                                       }

                                       if(var48 == 4010) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          class38.field823[var5++] = (var38 & 1 << var39) != 0?1:0;
                                          continue;
                                       }

                                       if(var48 == 4011) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var38 % var39;
                                          continue;
                                       }

                                       if(var48 == 4012) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[var5 + 1];
                                          if(var38 == 0) {
                                             class38.field823[var5++] = 0;
                                          } else {
                                             class38.field823[var5++] = (int)Math.pow((double)var38, (double)var39);
                                          }
                                          continue;
                                       }

                                       if(var48 == 4013) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          if(var38 == 0) {
                                             class38.field823[var5++] = 0;
                                          } else if(var39 == 0) {
                                             class38.field823[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class38.field823[var5++] = (int)Math.pow((double)var38, 1.0D / (double)var39);
                                          }
                                          continue;
                                       }

                                       if(var48 == 4014) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var38 & var39;
                                          continue;
                                       }

                                       if(var48 == 4015) {
                                          var5 -= 2;
                                          var38 = class38.field823[var5];
                                          var39 = class38.field823[1 + var5];
                                          class38.field823[var5++] = var38 | var39;
                                          continue;
                                       }

                                       if(var48 == 4018) {
                                          var5 -= 3;
                                          long var125 = (long)class38.field823[var5];
                                          var101 = (long)class38.field823[var5 + 1];
                                          long var74 = (long)class38.field823[2 + var5];
                                          class38.field823[var5++] = (int)(var74 * var125 / var101);
                                          continue;
                                       }
                                    } else {
                                       char var27;
                                       int var41;
                                       if(var48 < 4200) {
                                          if(var48 == 4100) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             --var5;
                                             var39 = class38.field823[var5];
                                             class38.field818[var6++] = var54 + var39;
                                             continue;
                                          }

                                          if(var48 == 4101) {
                                             var6 -= 2;
                                             var54 = class38.field818[var6];
                                             var55 = class38.field818[var6 + 1];
                                             class38.field818[var6++] = var54 + var55;
                                             continue;
                                          }

                                          if(var48 == 4102) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             --var5;
                                             var39 = class38.field823[var5];
                                             class38.field818[var6++] = var54 + class182.method3566(var39, true);
                                             continue;
                                          }

                                          if(var48 == 4103) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             class38.field818[var6++] = var54.toLowerCase();
                                             continue;
                                          }

                                          if(var48 == 4104) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             long var124 = ((long)var38 + 11745L) * 86400000L;
                                             class38.field822.setTime(new Date(var124));
                                             var18 = class38.field822.get(5);
                                             var59 = class38.field822.get(2);
                                             var36 = class38.field822.get(1);
                                             class38.field818[var6++] = var18 + "-" + class38.field816[var59] + "-" + var36;
                                             continue;
                                          }

                                          if(var48 == 4105) {
                                             var6 -= 2;
                                             var54 = class38.field818[var6];
                                             var55 = class38.field818[1 + var6];
                                             if(null != class114.field2010.field50 && class114.field2010.field50.field2974) {
                                                class38.field818[var6++] = var55;
                                                continue;
                                             }

                                             class38.field818[var6++] = var54;
                                             continue;
                                          }

                                          if(var48 == 4106) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field818[var6++] = Integer.toString(var38);
                                             continue;
                                          }

                                          if(var48 == 4107) {
                                             var6 -= 2;
                                             var88 = class38.field823;
                                             var39 = var5++;
                                             var97 = class38.field818[var6];
                                             var70 = class38.field818[1 + var6];
                                             var40 = client.field533;
                                             var41 = var97.length();
                                             var23 = var70.length();
                                             var24 = 0;
                                             int var80 = 0;
                                             char var26 = 0;
                                             var27 = 0;

                                             label3704:
                                             while(true) {
                                                if(var24 - var26 >= var41 && var80 - var27 >= var23) {
                                                   int var89 = Math.min(var41, var23);

                                                   char var31;
                                                   int var91;
                                                   for(var91 = 0; var91 < var89; ++var91) {
                                                      char var30 = var97.charAt(var91);
                                                      var31 = var70.charAt(var91);
                                                      if(var31 != var30 && Character.toUpperCase(var30) != Character.toUpperCase(var31)) {
                                                         var30 = Character.toLowerCase(var30);
                                                         var31 = Character.toLowerCase(var31);
                                                         if(var30 != var31) {
                                                            var18 = class116.method2495(var30, var40) - class116.method2495(var31, var40);
                                                            break label3704;
                                                         }
                                                      }
                                                   }

                                                   var91 = var41 - var23;
                                                   if(var91 != 0) {
                                                      var18 = var91;
                                                   } else {
                                                      for(int var92 = 0; var92 < var89; ++var92) {
                                                         var31 = var97.charAt(var92);
                                                         char var32 = var70.charAt(var92);
                                                         if(var31 != var32) {
                                                            var18 = class116.method2495(var31, var40) - class116.method2495(var32, var40);
                                                            break label3704;
                                                         }
                                                      }

                                                      var18 = 0;
                                                   }
                                                   break;
                                                }

                                                if(var24 - var26 >= var41) {
                                                   var18 = -1;
                                                   break;
                                                }

                                                if(var80 - var27 >= var23) {
                                                   var18 = 1;
                                                   break;
                                                }

                                                char var28;
                                                if(var26 != 0) {
                                                   var28 = var26;
                                                   boolean var82 = false;
                                                } else {
                                                   var28 = var97.charAt(var24++);
                                                }

                                                char var29;
                                                if(var27 != 0) {
                                                   var29 = var27;
                                                   boolean var86 = false;
                                                } else {
                                                   var29 = var70.charAt(var80++);
                                                }

                                                var26 = class75.method1660(var28);
                                                var27 = class75.method1660(var29);
                                                var28 = class112.method2483(var28, var40);
                                                var29 = class112.method2483(var29, var40);
                                                if(var28 != var29 && Character.toUpperCase(var28) != Character.toUpperCase(var29)) {
                                                   var28 = Character.toLowerCase(var28);
                                                   var29 = Character.toLowerCase(var29);
                                                   if(var28 != var29) {
                                                      var18 = class116.method2495(var28, var40) - class116.method2495(var29, var40);
                                                      break;
                                                   }
                                                }
                                             }

                                             if(var18 > 0) {
                                                var116 = 1;
                                             } else if(var18 < 0) {
                                                var116 = -1;
                                             } else {
                                                var116 = 0;
                                             }

                                             var88[var39] = var116;
                                             continue;
                                          }

                                          class227 var100;
                                          byte[] var115;
                                          if(var48 == 4108) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             var5 -= 2;
                                             var39 = class38.field823[var5];
                                             var93 = class38.field823[1 + var5];
                                             var115 = class87.field1531.method3304(var93, 0);
                                             var100 = new class227(var115);
                                             class38.field823[var5++] = var100.method4180(var54, var39);
                                             continue;
                                          }

                                          if(var48 == 4109) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             var5 -= 2;
                                             var39 = class38.field823[var5];
                                             var93 = class38.field823[1 + var5];
                                             var115 = class87.field1531.method3304(var93, 0);
                                             var100 = new class227(var115);
                                             class38.field823[var5++] = var100.method4096(var54, var39);
                                             continue;
                                          }

                                          if(var48 == 4110) {
                                             var6 -= 2;
                                             var54 = class38.field818[var6];
                                             var55 = class38.field818[1 + var6];
                                             --var5;
                                             if(class38.field823[var5] == 1) {
                                                class38.field818[var6++] = var54;
                                             } else {
                                                class38.field818[var6++] = var55;
                                             }
                                             continue;
                                          }

                                          if(var48 == 4111) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             class38.field818[var6++] = class226.method4098(var54);
                                             continue;
                                          }

                                          if(var48 == 4112) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             --var5;
                                             var39 = class38.field823[var5];
                                             class38.field818[var6++] = var54 + (char)var39;
                                             continue;
                                          }

                                          if(var48 == 4113) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class26.method600((char)var38)?1:0;
                                             continue;
                                          }

                                          if(var48 == 4114) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class24.method593((char)var38)?1:0;
                                             continue;
                                          }

                                          char var77;
                                          if(var48 == 4115) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             var56 = class38.field823;
                                             var93 = var5++;
                                             var77 = (char)var38;
                                             var60 = var77 >= 65 && var77 <= 90 || var77 >= 97 && var77 <= 122;
                                             var56[var93] = var60?1:0;
                                             continue;
                                          }

                                          if(var48 == 4116) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class30.method665((char)var38)?1:0;
                                             continue;
                                          }

                                          if(var48 == 4117) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             if(null != var54) {
                                                class38.field823[var5++] = var54.length();
                                             } else {
                                                class38.field823[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var48 == 4118) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             var5 -= 2;
                                             var39 = class38.field823[var5];
                                             var93 = class38.field823[1 + var5];
                                             class38.field818[var6++] = var54.substring(var39, var93);
                                             continue;
                                          }

                                          if(var48 == 4119) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             StringBuilder var72 = new StringBuilder(var54.length());
                                             var34 = false;

                                             for(var18 = 0; var18 < var54.length(); ++var18) {
                                                var77 = var54.charAt(var18);
                                                if(var77 == 60) {
                                                   var34 = true;
                                                } else if(var77 == 62) {
                                                   var34 = false;
                                                } else if(!var34) {
                                                   var72.append(var77);
                                                }
                                             }

                                             class38.field818[var6++] = var72.toString();
                                             continue;
                                          }

                                          if(var48 == 4120) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             --var5;
                                             var39 = class38.field823[var5];
                                             class38.field823[var5++] = var54.indexOf(var39);
                                             continue;
                                          }

                                          if(var48 == 4121) {
                                             var6 -= 2;
                                             var54 = class38.field818[var6];
                                             var55 = class38.field818[1 + var6];
                                             --var5;
                                             var93 = class38.field823[var5];
                                             class38.field823[var5++] = var54.indexOf(var55, var93);
                                             continue;
                                          }
                                       } else if(var48 < 4300) {
                                          if(var48 == 4200) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field818[var6++] = class4.method42(var38).field1183;
                                             continue;
                                          }

                                          class55 var57;
                                          if(var48 == 4201) {
                                             var5 -= 2;
                                             var38 = class38.field823[var5];
                                             var39 = class38.field823[var5 + 1];
                                             var57 = class4.method42(var38);
                                             if(var39 >= 1 && var39 <= 5 && var57.field1197[var39 - 1] != null) {
                                                class38.field818[var6++] = var57.field1197[var39 - 1];
                                                continue;
                                             }

                                             class38.field818[var6++] = "";
                                             continue;
                                          }

                                          if(var48 == 4202) {
                                             var5 -= 2;
                                             var38 = class38.field823[var5];
                                             var39 = class38.field823[var5 + 1];
                                             var57 = class4.method42(var38);
                                             if(var39 >= 1 && var39 <= 5 && null != var57.field1198[var39 - 1]) {
                                                class38.field818[var6++] = var57.field1198[var39 - 1];
                                                continue;
                                             }

                                             class38.field818[var6++] = "";
                                             continue;
                                          }

                                          if(var48 == 4203) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class4.method42(var38).field1185;
                                             continue;
                                          }

                                          if(var48 == 4204) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class4.method42(var38).field1194 == 1?1:0;
                                             continue;
                                          }

                                          class55 var79;
                                          if(var48 == 4205) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             var79 = class4.method42(var38);
                                             if(var79.field1214 == -1 && var79.field1213 >= 0) {
                                                class38.field823[var5++] = var79.field1213;
                                                continue;
                                             }

                                             class38.field823[var5++] = var38;
                                             continue;
                                          }

                                          if(var48 == 4206) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             var79 = class4.method42(var38);
                                             if(var79.field1214 >= 0 && var79.field1213 >= 0) {
                                                class38.field823[var5++] = var79.field1213;
                                                continue;
                                             }

                                             class38.field823[var5++] = var38;
                                             continue;
                                          }

                                          if(var48 == 4207) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class4.method42(var38).field1196?1:0;
                                             continue;
                                          }

                                          if(var48 == 4208) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             var79 = class4.method42(var38);
                                             if(var79.field1225 == -1 && var79.field1224 >= 0) {
                                                class38.field823[var5++] = var79.field1224;
                                                continue;
                                             }

                                             class38.field823[var5++] = var38;
                                             continue;
                                          }

                                          if(var48 == 4209) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             var79 = class4.method42(var38);
                                             if(var79.field1225 >= 0 && var79.field1224 >= 0) {
                                                class38.field823[var5++] = var79.field1224;
                                                continue;
                                             }

                                             class38.field823[var5++] = var38;
                                             continue;
                                          }

                                          if(var48 == 4210) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             --var5;
                                             var39 = class38.field823[var5];
                                             var60 = var39 == 1;
                                             var17 = var54.toLowerCase();
                                             short[] var103 = new short[16];
                                             var36 = 0;
                                             var40 = 0;

                                             while(true) {
                                                if(var40 >= class229.field3261) {
                                                   class127.field2085 = var103;
                                                   class39.field892 = 0;
                                                   class24.field616 = var36;
                                                   String[] var73 = new String[class24.field616];

                                                   for(var41 = 0; var41 < class24.field616; ++var41) {
                                                      var73[var41] = class4.method42(var103[var41]).field1183;
                                                   }

                                                   class78.method1693(var73, class127.field2085);
                                                   break;
                                                }

                                                class55 var69 = class4.method42(var40);
                                                if((!var60 || var69.field1220) && var69.field1214 == -1 && var69.field1183.toLowerCase().indexOf(var17) != -1) {
                                                   if(var36 >= 250) {
                                                      class24.field616 = -1;
                                                      class127.field2085 = null;
                                                      break;
                                                   }

                                                   if(var36 >= var103.length) {
                                                      short[] var42 = new short[2 * var103.length];

                                                      for(var24 = 0; var24 < var36; ++var24) {
                                                         var42[var24] = var103[var24];
                                                      }

                                                      var103 = var42;
                                                   }

                                                   var103[var36++] = (short)var40;
                                                }

                                                ++var40;
                                             }

                                             class38.field823[var5++] = class24.field616;
                                             continue;
                                          }

                                          if(var48 == 4211) {
                                             if(null != class127.field2085 && class39.field892 < class24.field616) {
                                                class38.field823[var5++] = class127.field2085[++class39.field892 - 1] & '\uffff';
                                                continue;
                                             }

                                             class38.field823[var5++] = -1;
                                             continue;
                                          }

                                          if(var48 == 4212) {
                                             class39.field892 = 0;
                                             continue;
                                          }
                                       } else if(var48 < 5100) {
                                          if(var48 == 5000) {
                                             class38.field823[var5++] = client.field395;
                                             continue;
                                          }

                                          if(var48 == 5001) {
                                             var5 -= 3;
                                             client.field395 = class38.field823[var5];
                                             class88.field1535 = class87.method1986(class38.field823[var5 + 1]);
                                             if(class88.field1535 == null) {
                                                class88.field1535 = class133.field2110;
                                             }

                                             client.field552 = class38.field823[var5 + 2];
                                             client.field313.method2797(186);
                                             client.field313.method2557(client.field395);
                                             client.field313.method2557(class88.field1535.field2112);
                                             client.field313.method2557(client.field552);
                                             continue;
                                          }

                                          if(var48 == 5002) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             var5 -= 2;
                                             var39 = class38.field823[var5];
                                             var93 = class38.field823[1 + var5];
                                             client.field313.method2797(36);
                                             client.field313.method2557(class77.method1679(var54) + 2);
                                             client.field313.method2563(var54);
                                             client.field313.method2557(var39 - 1);
                                             client.field313.method2557(var93);
                                             continue;
                                          }

                                          if(var48 == 5003) {
                                             var5 -= 2;
                                             var38 = class38.field823[var5];
                                             var39 = class38.field823[var5 + 1];
                                             class29 var118 = (class29)class11.field156.get(Integer.valueOf(var38));
                                             class37 var67 = var118.method651(var39);
                                             if(null != var67) {
                                                class38.field823[var5++] = var67.field809;
                                                class38.field823[var5++] = var67.field805;
                                                class38.field818[var6++] = var67.field811 != null?var67.field811:"";
                                                class38.field818[var6++] = null != var67.field808?var67.field808:"";
                                                class38.field818[var6++] = null != var67.field812?var67.field812:"";
                                             } else {
                                                class38.field823[var5++] = -1;
                                                class38.field823[var5++] = 0;
                                                class38.field818[var6++] = "";
                                                class38.field818[var6++] = "";
                                                class38.field818[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var48 == 5004) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class37 var84 = (class37)class11.field157.method3864((long)var38);
                                             if(null != var84) {
                                                class38.field823[var5++] = var84.field806;
                                                class38.field823[var5++] = var84.field805;
                                                class38.field818[var6++] = null != var84.field811?var84.field811:"";
                                                class38.field818[var6++] = var84.field808 != null?var84.field808:"";
                                                class38.field818[var6++] = null != var84.field812?var84.field812:"";
                                             } else {
                                                class38.field823[var5++] = -1;
                                                class38.field823[var5++] = 0;
                                                class38.field818[var6++] = "";
                                                class38.field818[var6++] = "";
                                                class38.field818[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var48 == 5005) {
                                             if(null == class88.field1535) {
                                                class38.field823[var5++] = -1;
                                             } else {
                                                class38.field823[var5++] = class88.field1535.field2112;
                                             }
                                             continue;
                                          }

                                          if(var48 == 5008) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             --var5;
                                             var39 = class38.field823[var5];
                                             var17 = var54.toLowerCase();
                                             byte var78 = 0;
                                             if(var17.startsWith("yellow:")) {
                                                var78 = 0;
                                                var54 = var54.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var78 = 1;
                                                var54 = var54.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var78 = 2;
                                                var54 = var54.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var78 = 3;
                                                var54 = var54.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var78 = 4;
                                                var54 = var54.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var78 = 5;
                                                var54 = var54.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var78 = 6;
                                                var54 = var54.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var78 = 7;
                                                var54 = var54.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var78 = 8;
                                                var54 = var54.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var78 = 9;
                                                var54 = var54.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var78 = 10;
                                                var54 = var54.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var78 = 11;
                                                var54 = var54.substring("glow3:".length());
                                             } else if(client.field533 != 0) {
                                                if(var17.startsWith("yellow:")) {
                                                   var78 = 0;
                                                   var54 = var54.substring("yellow:".length());
                                                } else if(var17.startsWith("red:")) {
                                                   var78 = 1;
                                                   var54 = var54.substring("red:".length());
                                                } else if(var17.startsWith("green:")) {
                                                   var78 = 2;
                                                   var54 = var54.substring("green:".length());
                                                } else if(var17.startsWith("cyan:")) {
                                                   var78 = 3;
                                                   var54 = var54.substring("cyan:".length());
                                                } else if(var17.startsWith("purple:")) {
                                                   var78 = 4;
                                                   var54 = var54.substring("purple:".length());
                                                } else if(var17.startsWith("white:")) {
                                                   var78 = 5;
                                                   var54 = var54.substring("white:".length());
                                                } else if(var17.startsWith("flash1:")) {
                                                   var78 = 6;
                                                   var54 = var54.substring("flash1:".length());
                                                } else if(var17.startsWith("flash2:")) {
                                                   var78 = 7;
                                                   var54 = var54.substring("flash2:".length());
                                                } else if(var17.startsWith("flash3:")) {
                                                   var78 = 8;
                                                   var54 = var54.substring("flash3:".length());
                                                } else if(var17.startsWith("glow1:")) {
                                                   var78 = 9;
                                                   var54 = var54.substring("glow1:".length());
                                                } else if(var17.startsWith("glow2:")) {
                                                   var78 = 10;
                                                   var54 = var54.substring("glow2:".length());
                                                } else if(var17.startsWith("glow3:")) {
                                                   var78 = 11;
                                                   var54 = var54.substring("glow3:".length());
                                                }
                                             }

                                             var17 = var54.toLowerCase();
                                             byte var81 = 0;
                                             if(var17.startsWith("wave:")) {
                                                var81 = 1;
                                                var54 = var54.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var81 = 2;
                                                var54 = var54.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var81 = 3;
                                                var54 = var54.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var81 = 4;
                                                var54 = var54.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var81 = 5;
                                                var54 = var54.substring("slide:".length());
                                             } else if(client.field533 != 0) {
                                                if(var17.startsWith("wave:")) {
                                                   var81 = 1;
                                                   var54 = var54.substring("wave:".length());
                                                } else if(var17.startsWith("wave2:")) {
                                                   var81 = 2;
                                                   var54 = var54.substring("wave2:".length());
                                                } else if(var17.startsWith("shake:")) {
                                                   var81 = 3;
                                                   var54 = var54.substring("shake:".length());
                                                } else if(var17.startsWith("scroll:")) {
                                                   var81 = 4;
                                                   var54 = var54.substring("scroll:".length());
                                                } else if(var17.startsWith("slide:")) {
                                                   var81 = 5;
                                                   var54 = var54.substring("slide:".length());
                                                }
                                             }

                                             client.field313.method2797(133);
                                             client.field313.method2557(0);
                                             var36 = client.field313.field2045;
                                             client.field313.method2557(var39);
                                             client.field313.method2557(var78);
                                             client.field313.method2557(var81);
                                             class125 var76 = client.field313;
                                             var41 = var76.field2045;
                                             var24 = var54.length();
                                             byte[] var43 = new byte[var24];

                                             for(int var85 = 0; var85 < var24; ++var85) {
                                                var27 = var54.charAt(var85);
                                                if((var27 <= 0 || var27 >= 128) && (var27 < 160 || var27 > 255)) {
                                                   if(var27 == 8364) {
                                                      var43[var85] = -128;
                                                   } else if(var27 == 8218) {
                                                      var43[var85] = -126;
                                                   } else if(var27 == 402) {
                                                      var43[var85] = -125;
                                                   } else if(var27 == 8222) {
                                                      var43[var85] = -124;
                                                   } else if(var27 == 8230) {
                                                      var43[var85] = -123;
                                                   } else if(var27 == 8224) {
                                                      var43[var85] = -122;
                                                   } else if(var27 == 8225) {
                                                      var43[var85] = -121;
                                                   } else if(var27 == 710) {
                                                      var43[var85] = -120;
                                                   } else if(var27 == 8240) {
                                                      var43[var85] = -119;
                                                   } else if(var27 == 352) {
                                                      var43[var85] = -118;
                                                   } else if(var27 == 8249) {
                                                      var43[var85] = -117;
                                                   } else if(var27 == 338) {
                                                      var43[var85] = -116;
                                                   } else if(var27 == 381) {
                                                      var43[var85] = -114;
                                                   } else if(var27 == 8216) {
                                                      var43[var85] = -111;
                                                   } else if(var27 == 8217) {
                                                      var43[var85] = -110;
                                                   } else if(var27 == 8220) {
                                                      var43[var85] = -109;
                                                   } else if(var27 == 8221) {
                                                      var43[var85] = -108;
                                                   } else if(var27 == 8226) {
                                                      var43[var85] = -107;
                                                   } else if(var27 == 8211) {
                                                      var43[var85] = -106;
                                                   } else if(var27 == 8212) {
                                                      var43[var85] = -105;
                                                   } else if(var27 == 732) {
                                                      var43[var85] = -104;
                                                   } else if(var27 == 8482) {
                                                      var43[var85] = -103;
                                                   } else if(var27 == 353) {
                                                      var43[var85] = -102;
                                                   } else if(var27 == 8250) {
                                                      var43[var85] = -101;
                                                   } else if(var27 == 339) {
                                                      var43[var85] = -100;
                                                   } else if(var27 == 382) {
                                                      var43[var85] = -98;
                                                   } else if(var27 == 376) {
                                                      var43[var85] = -97;
                                                   } else {
                                                      var43[var85] = 63;
                                                   }
                                                } else {
                                                   var43[var85] = (byte)var27;
                                                }
                                             }

                                             var76.method2570(var43.length);
                                             var76.field2045 += class225.field3230.method2496(var43, 0, var43.length, var76.field2047, var76.field2045);
                                             client.field313.method2701(client.field313.field2045 - var36);
                                             continue;
                                          }

                                          if(var48 == 5009) {
                                             var6 -= 2;
                                             var54 = class38.field818[var6];
                                             var55 = class38.field818[var6 + 1];
                                             client.field313.method2797(31);
                                             client.field313.method2558(0);
                                             var93 = client.field313.field2045;
                                             client.field313.method2563(var54);
                                             class125 var117 = client.field313;
                                             var59 = var117.field2045;
                                             var40 = var55.length();
                                             byte[] var71 = new byte[var40];

                                             for(var23 = 0; var23 < var40; ++var23) {
                                                char var83 = var55.charAt(var23);
                                                if((var83 <= 0 || var83 >= 128) && (var83 < 160 || var83 > 255)) {
                                                   if(var83 == 8364) {
                                                      var71[var23] = -128;
                                                   } else if(var83 == 8218) {
                                                      var71[var23] = -126;
                                                   } else if(var83 == 402) {
                                                      var71[var23] = -125;
                                                   } else if(var83 == 8222) {
                                                      var71[var23] = -124;
                                                   } else if(var83 == 8230) {
                                                      var71[var23] = -123;
                                                   } else if(var83 == 8224) {
                                                      var71[var23] = -122;
                                                   } else if(var83 == 8225) {
                                                      var71[var23] = -121;
                                                   } else if(var83 == 710) {
                                                      var71[var23] = -120;
                                                   } else if(var83 == 8240) {
                                                      var71[var23] = -119;
                                                   } else if(var83 == 352) {
                                                      var71[var23] = -118;
                                                   } else if(var83 == 8249) {
                                                      var71[var23] = -117;
                                                   } else if(var83 == 338) {
                                                      var71[var23] = -116;
                                                   } else if(var83 == 381) {
                                                      var71[var23] = -114;
                                                   } else if(var83 == 8216) {
                                                      var71[var23] = -111;
                                                   } else if(var83 == 8217) {
                                                      var71[var23] = -110;
                                                   } else if(var83 == 8220) {
                                                      var71[var23] = -109;
                                                   } else if(var83 == 8221) {
                                                      var71[var23] = -108;
                                                   } else if(var83 == 8226) {
                                                      var71[var23] = -107;
                                                   } else if(var83 == 8211) {
                                                      var71[var23] = -106;
                                                   } else if(var83 == 8212) {
                                                      var71[var23] = -105;
                                                   } else if(var83 == 732) {
                                                      var71[var23] = -104;
                                                   } else if(var83 == 8482) {
                                                      var71[var23] = -103;
                                                   } else if(var83 == 353) {
                                                      var71[var23] = -102;
                                                   } else if(var83 == 8250) {
                                                      var71[var23] = -101;
                                                   } else if(var83 == 339) {
                                                      var71[var23] = -100;
                                                   } else if(var83 == 382) {
                                                      var71[var23] = -98;
                                                   } else if(var83 == 376) {
                                                      var71[var23] = -97;
                                                   } else {
                                                      var71[var23] = 63;
                                                   }
                                                } else {
                                                   var71[var23] = (byte)var83;
                                                }
                                             }

                                             var117.method2570(var71.length);
                                             var117.field2045 += class225.field3230.method2496(var71, 0, var71.length, var117.field2047, var117.field2045);
                                             client.field313.method2568(client.field313.field2045 - var93);
                                             continue;
                                          }

                                          if(var48 == 5015) {
                                             if(class114.field2010 != null && null != class114.field2010.field43) {
                                                var54 = class114.field2010.field43;
                                             } else {
                                                var54 = "";
                                             }

                                             class38.field818[var6++] = var54;
                                             continue;
                                          }

                                          if(var48 == 5016) {
                                             class38.field823[var5++] = client.field552;
                                             continue;
                                          }

                                          if(var48 == 5017) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             var56 = class38.field823;
                                             var93 = var5++;
                                             class29 var104 = (class29)class11.field156.get(Integer.valueOf(var38));
                                             if(var104 == null) {
                                                var18 = 0;
                                             } else {
                                                var18 = var104.method649();
                                             }

                                             var56[var93] = var18;
                                             continue;
                                          }

                                          if(var48 == 5018) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class35.method730(var38);
                                             continue;
                                          }

                                          if(var48 == 5019) {
                                             --var5;
                                             var38 = class38.field823[var5];
                                             class38.field823[var5++] = class110.method2450(var38);
                                             continue;
                                          }

                                          if(var48 == 5020) {
                                             --var6;
                                             var54 = class38.field818[var6];
                                             class2.method34(var54);
                                             continue;
                                          }

                                          if(var48 == 5021) {
                                             --var6;
                                             client.field490 = class38.field818[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var48 == 5022) {
                                             class38.field818[var6++] = client.field490;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var48 >= 2000) {
                              var48 -= 1000;
                              --var5;
                              var15 = class34.method720(class38.field823[var5]);
                           } else {
                              var15 = var61?class38.field825:class26.field640;
                           }

                           if(var48 == 1927) {
                              if(class38.field826 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(var15.field2904 == null) {
                                 return;
                              }

                              class0 var51 = new class0();
                              var51.field3 = var15;
                              var51.field1 = var15.field2904;
                              var51.field10 = class38.field826 + 1;
                              client.field327.method3877(var0);
                              continue;
                           }
                        }
                     }
                  } else {
                     var38 = -1;
                     if(var48 >= 2000) {
                        var48 -= 1000;
                        --var5;
                        var38 = class38.field823[var5];
                        var16 = class34.method720(var38);
                     } else {
                        var16 = var61?class38.field825:class26.field640;
                     }

                     if(var48 == 1000) {
                        var5 -= 4;
                        var16.field2816 = class38.field823[var5];
                        var16.field2805 = class38.field823[var5 + 1];
                        var16.field2800 = class38.field823[var5 + 2];
                        var16.field2909 = class38.field823[var5 + 3];
                        class92.method2164(var16);
                        class14.method161(var16);
                        if(var38 != -1 && var16.field2929 == 0) {
                           client.method551(class176.field2814[var38 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var48 == 1001) {
                        var5 -= 4;
                        var16.field2806 = class38.field823[var5];
                        var16.field2915 = class38.field823[1 + var5];
                        var16.field2802 = class38.field823[var5 + 2];
                        var16.field2803 = class38.field823[var5 + 3];
                        class92.method2164(var16);
                        class14.method161(var16);
                        if(var38 != -1 && var16.field2929 == 0) {
                           client.method551(class176.field2814[var38 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var48 == 1003) {
                        --var5;
                        var34 = class38.field823[var5] == 1;
                        if(var16.field2815 != var34) {
                           var16.field2815 = var34;
                           class92.method2164(var16);
                        }
                        continue;
                     }

                     if(var48 == 1005) {
                        --var5;
                        var16.field2928 = class38.field823[var5] == 1;
                        continue;
                     }

                     if(var48 == 1006) {
                        --var5;
                        var16.field2888 = class38.field823[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var48 < 5400) {
                  if(var48 == 5306) {
                     var88 = class38.field823;
                     var39 = var5++;
                     var93 = client.field360?2:1;
                     var88[var39] = var93;
                     continue;
                  }

                  if(var48 == 5307) {
                     --var5;
                     var38 = class38.field823[var5];
                     if(var38 != 1 && var38 != 2) {
                        continue;
                     }

                     client.field483 = 0L;
                     if(var38 >= 2) {
                        client.field360 = true;
                     } else {
                        client.field360 = false;
                     }

                     class16.method181();
                     if(client.field280 >= 25) {
                        class177.method3493();
                     }

                     class147.field2265 = true;
                     continue;
                  }

                  if(var48 == 5308) {
                     class38.field823[var5++] = class12.field162.field136;
                     continue;
                  }

                  if(var48 == 5309) {
                     --var5;
                     var38 = class38.field823[var5];
                     if(var38 == 1 || var38 == 2) {
                        class12.field162.field136 = var38;
                        class32.method679();
                     }
                     continue;
                  }
               }

               if(var48 < 5600) {
                  if(var48 == 5504) {
                     var5 -= 2;
                     var38 = class38.field823[var5];
                     var39 = class38.field823[var5 + 1];
                     if(!client.field518) {
                        client.field356 = var38;
                        client.field357 = var39;
                     }
                     continue;
                  }

                  if(var48 == 5505) {
                     class38.field823[var5++] = client.field356;
                     continue;
                  }

                  if(var48 == 5506) {
                     class38.field823[var5++] = client.field357;
                     continue;
                  }

                  if(var48 == 5530) {
                     --var5;
                     var38 = class38.field823[var5];
                     if(var38 < 0) {
                        var38 = 0;
                     }

                     client.field437 = var38;
                     continue;
                  }

                  if(var48 == 5531) {
                     class38.field823[var5++] = client.field437;
                     continue;
                  }
               }

               if(var48 < 5700 && var48 == 5630) {
                  client.field323 = 250;
               } else {
                  if(var48 < 6300) {
                     if(var48 == 6200) {
                        var5 -= 2;
                        client.field524 = (short)class38.field823[var5];
                        if(client.field524 <= 0) {
                           client.field524 = 256;
                        }

                        client.field525 = (short)class38.field823[1 + var5];
                        if(client.field525 <= 0) {
                           client.field525 = 205;
                        }
                        continue;
                     }

                     if(var48 == 6201) {
                        var5 -= 2;
                        client.field347 = (short)class38.field823[var5];
                        if(client.field347 <= 0) {
                           client.field347 = 256;
                        }

                        client.field367 = (short)class38.field823[var5 + 1];
                        if(client.field367 <= 0) {
                           client.field367 = 320;
                        }
                        continue;
                     }

                     if(var48 == 6202) {
                        var5 -= 4;
                        client.field508 = (short)class38.field823[var5];
                        if(client.field508 <= 0) {
                           client.field508 = 1;
                        }

                        client.field425 = (short)class38.field823[1 + var5];
                        if(client.field425 <= 0) {
                           client.field425 = 32767;
                        } else if(client.field425 < client.field508) {
                           client.field425 = client.field508;
                        }

                        client.field530 = (short)class38.field823[var5 + 2];
                        if(client.field530 <= 0) {
                           client.field530 = 1;
                        }

                        client.field542 = (short)class38.field823[var5 + 3];
                        if(client.field542 <= 0) {
                           client.field542 = 32767;
                        } else if(client.field542 < client.field530) {
                           client.field542 = client.field530;
                        }
                        continue;
                     }

                     if(var48 == 6203) {
                        if(null != client.field292) {
                           method905(0, 0, client.field292.field2926, client.field292.field2877, false);
                           class38.field823[var5++] = client.field534;
                           class38.field823[var5++] = client.field364;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = -1;
                        }
                        continue;
                     }

                     if(var48 == 6204) {
                        class38.field823[var5++] = client.field347;
                        class38.field823[var5++] = client.field367;
                        continue;
                     }

                     if(var48 == 6205) {
                        class38.field823[var5++] = client.field524;
                        class38.field823[var5++] = client.field525;
                        continue;
                     }
                  }

                  if(var48 < 6600) {
                     if(var48 == 6500) {
                        class38.field823[var5++] = class17.method186()?1:0;
                        continue;
                     }

                     class27 var126;
                     if(var48 == 6501) {
                        var126 = class12.method143();
                        if(null != var126) {
                           class38.field823[var5++] = var126.field650;
                           class38.field823[var5++] = var126.field651;
                           class38.field818[var6++] = var126.field645;
                           class38.field823[var5++] = var126.field655;
                           class38.field823[var5++] = var126.field652;
                           class38.field818[var6++] = var126.field654;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                        }
                        continue;
                     }

                     if(var48 == 6502) {
                        var126 = class32.method678();
                        if(var126 != null) {
                           class38.field823[var5++] = var126.field650;
                           class38.field823[var5++] = var126.field651;
                           class38.field818[var6++] = var126.field645;
                           class38.field823[var5++] = var126.field655;
                           class38.field823[var5++] = var126.field652;
                           class38.field818[var6++] = var126.field654;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                        }
                        continue;
                     }

                     class27 var87;
                     if(var48 == 6506) {
                        --var5;
                        var38 = class38.field823[var5];
                        var87 = null;

                        for(var93 = 0; var93 < class27.field646; ++var93) {
                           if(class219.field3210[var93].field650 == var38) {
                              var87 = class219.field3210[var93];
                              break;
                           }
                        }

                        if(null != var87) {
                           class38.field823[var5++] = var87.field650;
                           class38.field823[var5++] = var87.field651;
                           class38.field818[var6++] = var87.field645;
                           class38.field823[var5++] = var87.field655;
                           class38.field823[var5++] = var87.field652;
                           class38.field818[var6++] = var87.field654;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.field818[var6++] = "";
                        }
                        continue;
                     }

                     if(var48 == 6507) {
                        var5 -= 4;
                        var38 = class38.field823[var5];
                        var105 = class38.field823[var5 + 1] == 1;
                        var93 = class38.field823[2 + var5];
                        var60 = class38.field823[var5 + 3] == 1;
                        if(null != class219.field3210) {
                           class3.method39(0, class219.field3210.length - 1, var38, var105, var93, var60);
                        }
                        continue;
                     }

                     if(var48 == 6511) {
                        --var5;
                        var38 = class38.field823[var5];
                        if(var38 >= 0 && var38 < class27.field646) {
                           var87 = class219.field3210[var38];
                           class38.field823[var5++] = var87.field650;
                           class38.field823[var5++] = var87.field651;
                           class38.field818[var6++] = var87.field645;
                           class38.field823[var5++] = var87.field655;
                           class38.field823[var5++] = var87.field652;
                           class38.field818[var6++] = var87.field654;
                           continue;
                        }

                        class38.field823[var5++] = -1;
                        class38.field823[var5++] = 0;
                        class38.field818[var6++] = "";
                        class38.field823[var5++] = 0;
                        class38.field823[var5++] = 0;
                        class38.field818[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var47) {
            StringBuilder var46 = new StringBuilder(30);
            var46.append("").append(var4.field3167).append(" ");

            for(var13 = class38.field819 - 1; var13 >= 0; --var13) {
               var46.append("").append(class38.field820[var13].field192.field3167).append(" ");
            }

            var46.append("").append(var10);
            class54.method1130(var46.toString(), var47);
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;III)V",
      garbageValue = "-437506644"
   )
   void method885(class122 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1002 = var1.method2576();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-736441866"
   )
   void method886(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field996 = (int)(var14 * 256.0D);
      this.field999 = (int)(var16 * 256.0D);
      if(this.field996 < 0) {
         this.field996 = 0;
      } else if(this.field996 > 255) {
         this.field996 = 255;
      }

      if(this.field999 < 0) {
         this.field999 = 0;
      } else if(this.field999 > 255) {
         this.field999 = 255;
      }

      if(var16 > 0.5D) {
         this.field1000 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field1000 = (int)(512.0D * var16 * var14);
      }

      if(this.field1000 < 1) {
         this.field1000 = 1;
      }

      this.field997 = (int)(var12 * (double)this.field1000);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "431387305"
   )
   public void method890() {
      this.method886(this.field1002);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-76"
   )
   static final void method905(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = client.field524 + (client.field525 - client.field524) * var5 / 100;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < client.field530) {
         var15 = client.field530;
         var6 = var15 * var2 * 334 / (512 * var3);
         if(var6 > client.field425) {
            var6 = client.field425;
            var8 = var6 * var3 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class82.method1874();
               class82.method1880(var0, var1, var9, var3, -16777216);
               class82.method1880(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > client.field542) {
         var15 = client.field542;
         var6 = var15 * var2 * 334 / (512 * var3);
         if(var6 < client.field508) {
            var6 = client.field508;
            var8 = var15 * var2 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class82.method1874();
               class82.method1880(var0, var1, var2, var9, -16777216);
               class82.method1880(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = client.field347 + var5 * (client.field367 - client.field347) / 100;
      client.field536 = var8 * var3 * var6 / 85504 << 1;
      if(var2 != client.field534 || client.field364 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 32 * var10 + 128 + 15;
            int var12 = 3 * var11 + 600;
            int var13 = class94.field1660[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         class89.method2033(var14, 500, 800, var2, var3);
      }

      client.field514 = var0;
      client.field316 = var1;
      client.field534 = var2;
      client.field364 = var3;
   }
}

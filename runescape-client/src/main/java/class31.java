import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class31 {
   @ObfuscatedName("x")
   static class80 field713;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1300356837
   )
   static int field714;
   @ObfuscatedName("b")
   static class80 field716;
   @ObfuscatedName("d")
   static class78 field717;
   @ObfuscatedName("s")
   static class80 field718;
   @ObfuscatedName("r")
   static class80 field719;
   @ObfuscatedName("am")
   static String field720;
   @ObfuscatedName("t")
   static int[] field721;
   @ObfuscatedName("ar")
   @Export("worldSelectShown")
   static boolean field722;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2074720193
   )
   static int field723;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1579856095
   )
   @Export("loginIndex")
   static int field724;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1268078983
   )
   static int field725 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 551284127
   )
   static int field726;
   @ObfuscatedName("af")
   static class159 field727;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1759973059
   )
   static int field728;
   @ObfuscatedName("ah")
   @Export("username")
   static String field729;
   @ObfuscatedName("az")
   @Export("loginMessage1")
   static String field730;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -41443695
   )
   @Export("loginWindowX")
   static int field731;
   @ObfuscatedName("f")
   static boolean field732;
   @ObfuscatedName("ai")
   @Export("loginMessage2")
   static String field733;
   @ObfuscatedName("aq")
   @Export("loginMessage3")
   static String field734;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -771303535
   )
   static int field735;
   @ObfuscatedName("ap")
   static String field736;
   @ObfuscatedName("cn")
   static class224 field737;
   @ObfuscatedName("aw")
   static boolean field738;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2018108465
   )
   @Export("loginIndex2")
   static int field739;
   @ObfuscatedName("as")
   static String field740;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2091443851
   )
   static int field742;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1170385015
   )
   static int field743;
   @ObfuscatedName("n")
   public static int[] field744;
   @ObfuscatedName("bl")
   static class168 field746;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -418037327
   )
   static int field747;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 1965720419
   )
   protected static int field749;

   static {
      field731 = 202 + field725;
      field721 = new int[256];
      field714 = 0;
      field723 = 0;
      field735 = 0;
      field747 = 0;
      field726 = 0;
      field742 = 0;
      field728 = 10;
      field740 = "";
      field724 = 0;
      field720 = "";
      field730 = "";
      field733 = "";
      field734 = "";
      field729 = "";
      field736 = "";
      field727 = class159.field2593;
      field738 = true;
      field739 = 0;
      field722 = false;
      field743 = -1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "1999742519"
   )
   static void method737(class0 var0, int var1) {
      Object[] var2 = var0.field0;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class171.method3423(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field592;
         int[] var9 = var4.field593;
         byte var10 = -1;
         class36.field817 = 0;

         int var13;
         try {
            class36.field799 = new int[var4.field591];
            int var11 = 0;
            class36.field816 = new String[var4.field596];
            int var12 = 0;

            int var14;
            String var24;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field1 != null?var0.field1.field2869:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field2;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field1 != null?var0.field1.field2755:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field12?var0.field12.field2869:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field12 != null?var0.field12.field2755:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class36.field799[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var24 = (String)var2[var13];
                  if(var24.equals("event_opbase")) {
                     var24 = var0.field9;
                  }

                  class36.field816[var12++] = var24;
               }
            }

            var13 = 0;
            class36.field809 = var0.field10;

            label3453:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var36 = var8[var7];
               String var17;
               int var18;
               int var19;
               int var27;
               int var29;
               int var30;
               int[] var39;
               String[] var44;
               String var55;
               String var56;
               int var60;
               if(var36 < 100) {
                  if(var36 == 0) {
                     class36.field803[var5++] = var9[var7];
                     continue;
                  }

                  if(var36 == 1) {
                     var14 = var9[var7];
                     class36.field803[var5++] = class176.field2905[var14];
                     continue;
                  }

                  if(var36 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2905[var14] = class36.field803[var5];
                     class21.method615(var14);
                     continue;
                  }

                  if(var36 == 3) {
                     class36.field804[var6++] = var4.field601[var7];
                     continue;
                  }

                  if(var36 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var36 == 7) {
                     var5 -= 2;
                     if(class36.field803[var5 + 1] != class36.field803[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var36 == 8) {
                     var5 -= 2;
                     if(class36.field803[var5 + 1] == class36.field803[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var36 == 9) {
                     var5 -= 2;
                     if(class36.field803[var5] < class36.field803[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var36 == 10) {
                     var5 -= 2;
                     if(class36.field803[var5] > class36.field803[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var36 == 21) {
                     if(class36.field817 == 0) {
                        return;
                     }

                     class14 var63 = class36.field806[--class36.field817];
                     var4 = var63.field213;
                     var8 = var4.field592;
                     var9 = var4.field593;
                     var7 = var63.field207;
                     class36.field799 = var63.field208;
                     class36.field816 = var63.field209;
                     continue;
                  }

                  if(var36 == 25) {
                     var14 = var9[var7];
                     class36.field803[var5++] = class130.method2851(var14);
                     continue;
                  }

                  if(var36 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class28.method693(var14, class36.field803[var5]);
                     continue;
                  }

                  if(var36 == 31) {
                     var5 -= 2;
                     if(class36.field803[var5] <= class36.field803[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var36 == 32) {
                     var5 -= 2;
                     if(class36.field803[var5] >= class36.field803[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var36 == 33) {
                     class36.field803[var5++] = class36.field799[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var36 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field799[var10001] = class36.field803[var5];
                     continue;
                  }

                  if(var36 == 35) {
                     class36.field804[var6++] = class36.field816[var9[var7]];
                     continue;
                  }

                  if(var36 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field816[var10001] = class36.field804[var6];
                     continue;
                  }

                  if(var36 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var84 = class36.field804;
                     if(var14 == 0) {
                        var55 = "";
                     } else if(var14 == 1) {
                        var17 = var84[var6];
                        if(null == var17) {
                           var55 = "null";
                        } else {
                           var55 = var17.toString();
                        }
                     } else {
                        var60 = var14 + var6;
                        var18 = 0;

                        for(var19 = var6; var19 < var60; ++var19) {
                           var56 = var84[var19];
                           if(var56 == null) {
                              var18 += 4;
                           } else {
                              var18 += var56.length();
                           }
                        }

                        StringBuilder var82 = new StringBuilder(var18);

                        for(var27 = var6; var27 < var60; ++var27) {
                           String var52 = var84[var27];
                           if(var52 == null) {
                              var82.append("null");
                           } else {
                              var82.append(var52);
                           }
                        }

                        var55 = var82.toString();
                     }

                     class36.field804[var6++] = var55;
                     continue;
                  }

                  if(var36 == 38) {
                     --var5;
                     continue;
                  }

                  if(var36 == 39) {
                     --var6;
                     continue;
                  }

                  if(var36 == 40) {
                     var14 = var9[var7];
                     class22 var100 = class171.method3423(var14);
                     var39 = new int[var100.field591];
                     var44 = new String[var100.field596];

                     for(var18 = 0; var18 < var100.field597; ++var18) {
                        var39[var18] = class36.field803[var18 + (var5 - var100.field597)];
                     }

                     for(var18 = 0; var18 < var100.field598; ++var18) {
                        var44[var18] = class36.field804[var6 - var100.field598 + var18];
                     }

                     var5 -= var100.field597;
                     var6 -= var100.field598;
                     class14 var94 = new class14();
                     var94.field213 = var4;
                     var94.field207 = var7;
                     var94.field208 = class36.field799;
                     var94.field209 = class36.field816;
                     class36.field806[++class36.field817 - 1] = var94;
                     var4 = var100;
                     var8 = var100.field592;
                     var9 = var100.field593;
                     var7 = -1;
                     class36.field799 = var39;
                     class36.field816 = var44;
                     continue;
                  }

                  if(var36 == 42) {
                     class36.field803[var5++] = class3.field65.method212(var9[var7]);
                     continue;
                  }

                  if(var36 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class3.field65.method211(var10001, class36.field803[var5]);
                     continue;
                  }

                  if(var36 == 44) {
                     var14 = var9[var7] >> 16;
                     var29 = var9[var7] & '\uffff';
                     --var5;
                     var30 = class36.field803[var5];
                     if(var30 >= 0 && var30 <= 5000) {
                        class36.field801[var14] = var30;
                        byte var91 = -1;
                        if(var29 == 105) {
                           var91 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var30) {
                              continue label3453;
                           }

                           class36.field805[var14][var18] = var91;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var36 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var29 = class36.field803[var5];
                     if(var29 >= 0 && var29 < class36.field801[var14]) {
                        class36.field803[var5++] = class36.field805[var14][var29];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var36 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var29 = class36.field803[var5];
                     if(var29 >= 0 && var29 < class36.field801[var14]) {
                        class36.field805[var14][var29] = class36.field803[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var36 == 47) {
                     var24 = class3.field65.method243(var9[var7]);
                     if(null == var24) {
                        var24 = "null";
                     }

                     class36.field804[var6++] = var24;
                     continue;
                  }

                  if(var36 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class3.field65.method239(var10001, class36.field804[var6]);
                     continue;
                  }
               }

               boolean var45;
               if(var9[var7] == 1) {
                  var45 = true;
               } else {
                  var45 = false;
               }

               class173 var15;
               class173 var16;
               class173 var37;
               class173 var70;
               boolean var87;
               if(var36 < 1000) {
                  if(var36 == 100) {
                     var5 -= 3;
                     var29 = class36.field803[var5];
                     var30 = class36.field803[var5 + 1];
                     var60 = class36.field803[2 + var5];
                     if(var30 == 0) {
                        throw new RuntimeException();
                     }

                     var70 = class153.method3177(var29);
                     if(var70.field2767 == null) {
                        var70.field2767 = new class173[var60 + 1];
                     }

                     if(var70.field2767.length <= var60) {
                        class173[] var79 = new class173[var60 + 1];

                        for(var27 = 0; var27 < var70.field2767.length; ++var27) {
                           var79[var27] = var70.field2767[var27];
                        }

                        var70.field2767 = var79;
                     }

                     if(var60 > 0 && var70.field2767[var60 - 1] == null) {
                        throw new RuntimeException("" + (var60 - 1));
                     }

                     class173 var80 = new class173();
                     var80.field2798 = var30;
                     var80.field2773 = var80.field2869 = var70.field2869;
                     var80.field2755 = var60;
                     var80.field2860 = true;
                     var70.field2767[var60] = var80;
                     if(var45) {
                        class36.field800 = var80;
                     } else {
                        class36.field813 = var80;
                     }

                     class39.method818(var70);
                     continue;
                  }

                  if(var36 == 101) {
                     var15 = var45?class36.field800:class36.field813;
                     var16 = class153.method3177(var15.field2869);
                     var16.field2767[var15.field2755] = null;
                     class39.method818(var16);
                     continue;
                  }

                  if(var36 == 102) {
                     --var5;
                     var15 = class153.method3177(class36.field803[var5]);
                     var15.field2767 = null;
                     class39.method818(var15);
                     continue;
                  }

                  if(var36 == 200) {
                     var5 -= 2;
                     var29 = class36.field803[var5];
                     var30 = class36.field803[1 + var5];
                     var37 = class172.method3425(var29, var30);
                     if(null != var37 && var30 != -1) {
                        class36.field803[var5++] = 1;
                        if(var45) {
                           class36.field800 = var37;
                        } else {
                           class36.field813 = var37;
                        }
                        continue;
                     }

                     class36.field803[var5++] = 0;
                     continue;
                  }

                  if(var36 == 201) {
                     --var5;
                     var15 = class153.method3177(class36.field803[var5]);
                     if(var15 != null) {
                        class36.field803[var5++] = 1;
                        if(var45) {
                           class36.field800 = var15;
                        } else {
                           class36.field813 = var15;
                        }
                     } else {
                        class36.field803[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var25;
                  if((var36 < 1000 || var36 >= 1100) && (var36 < 2000 || var36 >= 2100)) {
                     if(var36 >= 1100 && var36 < 1200 || var36 >= 2100 && var36 < 2200) {
                        var30 = -1;
                        if(var36 >= 2000) {
                           var36 -= 1000;
                           --var5;
                           var30 = class36.field803[var5];
                           var15 = class153.method3177(var30);
                        } else {
                           var15 = var45?class36.field800:class36.field813;
                        }

                        if(var36 == 1100) {
                           var5 -= 2;
                           var15.field2878 = class36.field803[var5];
                           if(var15.field2878 > var15.field2777 - var15.field2769) {
                              var15.field2878 = var15.field2777 - var15.field2769;
                           }

                           if(var15.field2878 < 0) {
                              var15.field2878 = 0;
                           }

                           var15.field2776 = class36.field803[1 + var5];
                           if(var15.field2776 > var15.field2778 - var15.field2888) {
                              var15.field2776 = var15.field2778 - var15.field2888;
                           }

                           if(var15.field2776 < 0) {
                              var15.field2776 = 0;
                           }

                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1101) {
                           --var5;
                           var15.field2779 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1102) {
                           --var5;
                           var15.field2842 = class36.field803[var5] == 1;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1103) {
                           --var5;
                           var15.field2785 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1104) {
                           --var5;
                           var15.field2787 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1105) {
                           --var5;
                           var15.field2789 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1106) {
                           --var5;
                           var15.field2877 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1107) {
                           --var5;
                           var15.field2792 = class36.field803[var5] == 1;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1108) {
                           var15.field2797 = 1;
                           --var5;
                           var15.field2768 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1109) {
                           var5 -= 6;
                           var15.field2803 = class36.field803[var5];
                           var15.field2804 = class36.field803[var5 + 1];
                           var15.field2805 = class36.field803[2 + var5];
                           var15.field2806 = class36.field803[var5 + 3];
                           var15.field2746 = class36.field803[var5 + 4];
                           var15.field2874 = class36.field803[var5 + 5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1110) {
                           --var5;
                           var60 = class36.field803[var5];
                           if(var60 != var15.field2756) {
                              var15.field2756 = var60;
                              var15.field2876 = 0;
                              var15.field2743 = 0;
                              class39.method818(var15);
                           }
                           continue;
                        }

                        if(var36 == 1111) {
                           --var5;
                           var15.field2811 = class36.field803[var5] == 1;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1112) {
                           --var6;
                           var17 = class36.field804[var6];
                           if(!var17.equals(var15.field2814)) {
                              var15.field2814 = var17;
                              class39.method818(var15);
                           }
                           continue;
                        }

                        if(var36 == 1113) {
                           --var5;
                           var15.field2813 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1114) {
                           var5 -= 3;
                           var15.field2817 = class36.field803[var5];
                           var15.field2818 = class36.field803[var5 + 1];
                           var15.field2816 = class36.field803[2 + var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1115) {
                           --var5;
                           var15.field2819 = class36.field803[var5] == 1;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1116) {
                           --var5;
                           var15.field2793 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1117) {
                           --var5;
                           var15.field2801 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1118) {
                           --var5;
                           var15.field2754 = class36.field803[var5] == 1;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1119) {
                           --var5;
                           var15.field2837 = class36.field803[var5] == 1;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1120) {
                           var5 -= 2;
                           var15.field2777 = class36.field803[var5];
                           var15.field2778 = class36.field803[var5 + 1];
                           class39.method818(var15);
                           if(var30 != -1 && var15.field2798 == 0) {
                              class75.method1698(class173.field2770[var30 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var36 == 1121) {
                           var60 = var15.field2869;
                           var18 = var15.field2755;
                           client.field333.method2773(89);
                           client.field333.method2595(var60);
                           client.field333.method2540(var18);
                           client.field312 = var15;
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1122) {
                           --var5;
                           var15.field2790 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1123) {
                           --var5;
                           var15.field2780 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1124) {
                           --var5;
                           var15.field2839 = class36.field803[var5];
                           class39.method818(var15);
                           continue;
                        }

                        if(var36 == 1125) {
                           --var5;
                           var60 = class36.field803[var5];
                           class82 var92 = (class82)class14.method177(class14.method175(), var60);
                           if(var92 != null) {
                              var15.field2784 = var92;
                              class39.method818(var15);
                           }
                           continue;
                        }
                     } else if((var36 < 1200 || var36 >= 1300) && (var36 < 2200 || var36 >= 2300)) {
                        if((var36 < 1300 || var36 >= 1400) && (var36 < 2300 || var36 >= 2400)) {
                           int[] var38;
                           String var42;
                           if(var36 >= 1400 && var36 < 1500 || var36 >= 2400 && var36 < 2500) {
                              if(var36 >= 2000) {
                                 var36 -= 1000;
                                 --var5;
                                 var15 = class153.method3177(class36.field803[var5]);
                              } else {
                                 var15 = var45?class36.field800:class36.field813;
                              }

                              --var6;
                              var42 = class36.field804[var6];
                              var38 = null;
                              if(var42.length() > 0 && var42.charAt(var42.length() - 1) == 89) {
                                 --var5;
                                 var18 = class36.field803[var5];
                                 if(var18 > 0) {
                                    for(var38 = new int[var18]; var18-- > 0; var38[var18] = class36.field803[var5]) {
                                       --var5;
                                    }
                                 }

                                 var42 = var42.substring(0, var42.length() - 1);
                              }

                              Object[] var89 = new Object[var42.length() + 1];

                              for(var19 = var89.length - 1; var19 >= 1; --var19) {
                                 if(var42.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var89[var19] = class36.field804[var6];
                                 } else {
                                    --var5;
                                    var89[var19] = new Integer(class36.field803[var5]);
                                 }
                              }

                              --var5;
                              var19 = class36.field803[var5];
                              if(var19 != -1) {
                                 var89[0] = new Integer(var19);
                              } else {
                                 var89 = null;
                              }

                              if(var36 == 1400) {
                                 var15.field2836 = var89;
                              }

                              if(var36 == 1401) {
                                 var15.field2881 = var89;
                              }

                              if(var36 == 1402) {
                                 var15.field2772 = var89;
                              }

                              if(var36 == 1403) {
                                 var15.field2840 = var89;
                              }

                              if(var36 == 1404) {
                                 var15.field2875 = var89;
                              }

                              if(var36 == 1405) {
                                 var15.field2843 = var89;
                              }

                              if(var36 == 1406) {
                                 var15.field2846 = var89;
                              }

                              if(var36 == 1407) {
                                 var15.field2847 = var89;
                                 var15.field2848 = var38;
                              }

                              if(var36 == 1408) {
                                 var15.field2853 = var89;
                              }

                              if(var36 == 1409) {
                                 var15.field2859 = var89;
                              }

                              if(var36 == 1410) {
                                 var15.field2844 = var89;
                              }

                              if(var36 == 1411) {
                                 var15.field2872 = var89;
                              }

                              if(var36 == 1412) {
                                 var15.field2765 = var89;
                              }

                              if(var36 == 1414) {
                                 var15.field2865 = var89;
                                 var15.field2850 = var38;
                              }

                              if(var36 == 1415) {
                                 var15.field2851 = var89;
                                 var15.field2852 = var38;
                              }

                              if(var36 == 1416) {
                                 var15.field2845 = var89;
                              }

                              if(var36 == 1417) {
                                 var15.field2855 = var89;
                              }

                              if(var36 == 1418) {
                                 var15.field2766 = var89;
                              }

                              if(var36 == 1419) {
                                 var15.field2857 = var89;
                              }

                              if(var36 == 1420) {
                                 var15.field2745 = var89;
                              }

                              if(var36 == 1421) {
                                 var15.field2838 = var89;
                              }

                              if(var36 == 1422) {
                                 var15.field2751 = var89;
                              }

                              if(var36 == 1423) {
                                 var15.field2828 = var89;
                              }

                              if(var36 == 1424) {
                                 var15.field2862 = var89;
                              }

                              if(var36 == 1425) {
                                 var15.field2864 = var89;
                              }

                              if(var36 == 1426) {
                                 var15.field2791 = var89;
                              }

                              if(var36 == 1427) {
                                 var15.field2856 = var89;
                              }

                              var15.field2834 = true;
                              continue;
                           }

                           if(var36 < 1600) {
                              var15 = var45?class36.field800:class36.field813;
                              if(var36 == 1500) {
                                 class36.field803[var5++] = var15.field2873;
                                 continue;
                              }

                              if(var36 == 1501) {
                                 class36.field803[var5++] = var15.field2807;
                                 continue;
                              }

                              if(var36 == 1502) {
                                 class36.field803[var5++] = var15.field2769;
                                 continue;
                              }

                              if(var36 == 1503) {
                                 class36.field803[var5++] = var15.field2888;
                                 continue;
                              }

                              if(var36 == 1504) {
                                 class36.field803[var5++] = var15.field2774?1:0;
                                 continue;
                              }

                              if(var36 == 1505) {
                                 class36.field803[var5++] = var15.field2773;
                                 continue;
                              }
                           } else if(var36 < 1700) {
                              var15 = var45?class36.field800:class36.field813;
                              if(var36 == 1600) {
                                 class36.field803[var5++] = var15.field2878;
                                 continue;
                              }

                              if(var36 == 1601) {
                                 class36.field803[var5++] = var15.field2776;
                                 continue;
                              }

                              if(var36 == 1602) {
                                 class36.field804[var6++] = var15.field2814;
                                 continue;
                              }

                              if(var36 == 1603) {
                                 class36.field803[var5++] = var15.field2777;
                                 continue;
                              }

                              if(var36 == 1604) {
                                 class36.field803[var5++] = var15.field2778;
                                 continue;
                              }

                              if(var36 == 1605) {
                                 class36.field803[var5++] = var15.field2874;
                                 continue;
                              }

                              if(var36 == 1606) {
                                 class36.field803[var5++] = var15.field2805;
                                 continue;
                              }

                              if(var36 == 1607) {
                                 class36.field803[var5++] = var15.field2746;
                                 continue;
                              }

                              if(var36 == 1608) {
                                 class36.field803[var5++] = var15.field2806;
                                 continue;
                              }

                              if(var36 == 1609) {
                                 class36.field803[var5++] = var15.field2785;
                                 continue;
                              }

                              if(var36 == 1610) {
                                 class36.field803[var5++] = var15.field2839;
                                 continue;
                              }

                              if(var36 == 1611) {
                                 class36.field803[var5++] = var15.field2779;
                                 continue;
                              }

                              if(var36 == 1612) {
                                 class36.field803[var5++] = var15.field2780;
                                 continue;
                              }

                              if(var36 == 1613) {
                                 class36.field803[var5++] = var15.field2784.vmethod3194();
                                 continue;
                              }
                           } else if(var36 < 1800) {
                              var15 = var45?class36.field800:class36.field813;
                              if(var36 == 1700) {
                                 class36.field803[var5++] = var15.field2764;
                                 continue;
                              }

                              if(var36 == 1701) {
                                 if(var15.field2764 != -1) {
                                    class36.field803[var5++] = var15.field2794;
                                 } else {
                                    class36.field803[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var36 == 1702) {
                                 class36.field803[var5++] = var15.field2755;
                                 continue;
                              }
                           } else if(var36 < 1900) {
                              var15 = var45?class36.field800:class36.field813;
                              if(var36 == 1800) {
                                 var39 = class36.field803;
                                 var60 = var5++;
                                 var19 = class18.method205(var15);
                                 var18 = var19 >> 11 & 63;
                                 var39[var60] = var18;
                                 continue;
                              }

                              if(var36 == 1801) {
                                 --var5;
                                 var30 = class36.field803[var5];
                                 --var30;
                                 if(var15.field2854 != null && var30 < var15.field2854.length && var15.field2854[var30] != null) {
                                    class36.field804[var6++] = var15.field2854[var30];
                                    continue;
                                 }

                                 class36.field804[var6++] = "";
                                 continue;
                              }

                              if(var36 == 1802) {
                                 if(var15.field2833 == null) {
                                    class36.field804[var6++] = "";
                                 } else {
                                    class36.field804[var6++] = var15.field2833;
                                 }
                                 continue;
                              }
                           } else if(var36 >= 1900 && var36 < 2000 || var36 >= 2900 && var36 < 3000) {
                              if(var36 >= 2000) {
                                 var36 -= 1000;
                                 --var5;
                                 var15 = class153.method3177(class36.field803[var5]);
                              } else {
                                 var15 = var45?class36.field800:class36.field813;
                              }

                              if(var36 == 1927) {
                                 if(class36.field809 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var15.field2856 == null) {
                                    return;
                                 }

                                 class0 var68 = new class0();
                                 var68.field1 = var15;
                                 var68.field0 = var15.field2856;
                                 var68.field10 = class36.field809 + 1;
                                 client.field486.method3877(var0);
                                 continue;
                              }
                           } else if(var36 < 2600) {
                              --var5;
                              var15 = class153.method3177(class36.field803[var5]);
                              if(var36 == 2500) {
                                 class36.field803[var5++] = var15.field2873;
                                 continue;
                              }

                              if(var36 == 2501) {
                                 class36.field803[var5++] = var15.field2807;
                                 continue;
                              }

                              if(var36 == 2502) {
                                 class36.field803[var5++] = var15.field2769;
                                 continue;
                              }

                              if(var36 == 2503) {
                                 class36.field803[var5++] = var15.field2888;
                                 continue;
                              }

                              if(var36 == 2504) {
                                 class36.field803[var5++] = var15.field2774?1:0;
                                 continue;
                              }

                              if(var36 == 2505) {
                                 class36.field803[var5++] = var15.field2773;
                                 continue;
                              }
                           } else if(var36 < 2700) {
                              --var5;
                              var15 = class153.method3177(class36.field803[var5]);
                              if(var36 == 2600) {
                                 class36.field803[var5++] = var15.field2878;
                                 continue;
                              }

                              if(var36 == 2601) {
                                 class36.field803[var5++] = var15.field2776;
                                 continue;
                              }

                              if(var36 == 2602) {
                                 class36.field804[var6++] = var15.field2814;
                                 continue;
                              }

                              if(var36 == 2603) {
                                 class36.field803[var5++] = var15.field2777;
                                 continue;
                              }

                              if(var36 == 2604) {
                                 class36.field803[var5++] = var15.field2778;
                                 continue;
                              }

                              if(var36 == 2605) {
                                 class36.field803[var5++] = var15.field2874;
                                 continue;
                              }

                              if(var36 == 2606) {
                                 class36.field803[var5++] = var15.field2805;
                                 continue;
                              }

                              if(var36 == 2607) {
                                 class36.field803[var5++] = var15.field2746;
                                 continue;
                              }

                              if(var36 == 2608) {
                                 class36.field803[var5++] = var15.field2806;
                                 continue;
                              }

                              if(var36 == 2609) {
                                 class36.field803[var5++] = var15.field2785;
                                 continue;
                              }

                              if(var36 == 2610) {
                                 class36.field803[var5++] = var15.field2839;
                                 continue;
                              }

                              if(var36 == 2611) {
                                 class36.field803[var5++] = var15.field2779;
                                 continue;
                              }

                              if(var36 == 2612) {
                                 class36.field803[var5++] = var15.field2780;
                                 continue;
                              }

                              if(var36 == 2613) {
                                 class36.field803[var5++] = var15.field2784.vmethod3194();
                                 continue;
                              }
                           } else if(var36 < 2800) {
                              if(var36 == 2700) {
                                 --var5;
                                 var15 = class153.method3177(class36.field803[var5]);
                                 class36.field803[var5++] = var15.field2764;
                                 continue;
                              }

                              if(var36 == 2701) {
                                 --var5;
                                 var15 = class153.method3177(class36.field803[var5]);
                                 if(var15.field2764 != -1) {
                                    class36.field803[var5++] = var15.field2794;
                                 } else {
                                    class36.field803[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var36 == 2702) {
                                 --var5;
                                 var29 = class36.field803[var5];
                                 class3 var40 = (class3)client.field448.method3822((long)var29);
                                 if(null != var40) {
                                    class36.field803[var5++] = 1;
                                 } else {
                                    class36.field803[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var36 == 2706) {
                                 class36.field803[var5++] = client.field391;
                                 continue;
                              }
                           } else if(var36 < 2900) {
                              --var5;
                              var15 = class153.method3177(class36.field803[var5]);
                              if(var36 == 2800) {
                                 var39 = class36.field803;
                                 var60 = var5++;
                                 var19 = class18.method205(var15);
                                 var18 = var19 >> 11 & 63;
                                 var39[var60] = var18;
                                 continue;
                              }

                              if(var36 == 2801) {
                                 --var5;
                                 var30 = class36.field803[var5];
                                 --var30;
                                 if(null != var15.field2854 && var30 < var15.field2854.length && null != var15.field2854[var30]) {
                                    class36.field804[var6++] = var15.field2854[var30];
                                    continue;
                                 }

                                 class36.field804[var6++] = "";
                                 continue;
                              }

                              if(var36 == 2802) {
                                 if(null == var15.field2833) {
                                    class36.field804[var6++] = "";
                                 } else {
                                    class36.field804[var6++] = var15.field2833;
                                 }
                                 continue;
                              }
                           } else if(var36 < 3200) {
                              if(var36 == 3100) {
                                 --var6;
                                 var55 = class36.field804[var6];
                                 class52.method1147(0, "", var55);
                                 continue;
                              }

                              if(var36 == 3101) {
                                 var5 -= 2;
                                 class7.method110(class15.field225, class36.field803[var5], class36.field803[1 + var5]);
                                 continue;
                              }

                              if(var36 == 3103) {
                                 class98.method2267();
                                 continue;
                              }

                              if(var36 == 3104) {
                                 --var6;
                                 var55 = class36.field804[var6];
                                 var30 = 0;
                                 if(class156.method3184(var55)) {
                                    var30 = class35.method772(var55);
                                 }

                                 client.field333.method2773(90);
                                 client.field333.method2539(var30);
                                 continue;
                              }

                              if(var36 == 3105) {
                                 --var6;
                                 var55 = class36.field804[var6];
                                 client.field333.method2773(234);
                                 client.field333.method2654(var55.length() + 1);
                                 client.field333.method2545(var55);
                                 continue;
                              }

                              if(var36 == 3106) {
                                 --var6;
                                 var55 = class36.field804[var6];
                                 client.field333.method2773(207);
                                 client.field333.method2654(var55.length() + 1);
                                 client.field333.method2545(var55);
                                 continue;
                              }

                              if(var36 == 3107) {
                                 --var5;
                                 var29 = class36.field803[var5];
                                 --var6;
                                 var42 = class36.field804[var6];
                                 class136.method2923(var29, var42);
                                 continue;
                              }

                              if(var36 == 3108) {
                                 var5 -= 3;
                                 var29 = class36.field803[var5];
                                 var30 = class36.field803[1 + var5];
                                 var60 = class36.field803[var5 + 2];
                                 var70 = class153.method3177(var60);
                                 class18.method202(var70, var29, var30);
                                 continue;
                              }

                              if(var36 == 3109) {
                                 var5 -= 2;
                                 var29 = class36.field803[var5];
                                 var30 = class36.field803[var5 + 1];
                                 var37 = var45?class36.field800:class36.field813;
                                 class18.method202(var37, var29, var30);
                                 continue;
                              }

                              if(var36 == 3110) {
                                 --var5;
                                 class148.field2224 = class36.field803[var5] == 1;
                                 continue;
                              }

                              if(var36 == 3111) {
                                 class36.field803[var5++] = class20.field580.field140?1:0;
                                 continue;
                              }

                              if(var36 == 3112) {
                                 --var5;
                                 class20.field580.field140 = class36.field803[var5] == 1;
                                 class21.method613();
                                 continue;
                              }

                              if(var36 == 3113) {
                                 --var6;
                                 var55 = class36.field804[var6];
                                 --var5;
                                 var87 = class36.field803[var5] == 1;
                                 class29.method707(var55, var87, false);
                                 continue;
                              }

                              if(var36 == 3115) {
                                 --var5;
                                 var29 = class36.field803[var5];
                                 client.field333.method2773(62);
                                 client.field333.method2540(var29);
                                 continue;
                              }

                              if(var36 == 3116) {
                                 --var5;
                                 var29 = class36.field803[var5];
                                 var6 -= 2;
                                 var42 = class36.field804[var6];
                                 var17 = class36.field804[1 + var6];
                                 if(var42.length() <= 500 && var17.length() <= 500) {
                                    client.field333.method2773(223);
                                    client.field333.method2540(1 + class23.method629(var42) + class23.method629(var17));
                                    client.field333.method2654(var29);
                                    client.field333.method2545(var42);
                                    client.field333.method2545(var17);
                                 }
                                 continue;
                              }
                           } else if(var36 < 3300) {
                              if(var36 == 3200) {
                                 var5 -= 3;
                                 class87.method2139(class36.field803[var5], class36.field803[1 + var5], class36.field803[var5 + 2]);
                                 continue;
                              }

                              if(var36 == 3201) {
                                 --var5;
                                 var29 = class36.field803[var5];
                                 if(var29 == -1 && !client.field526) {
                                    class38.method807();
                                 } else if(var29 != -1 && var29 != client.field315 && client.field524 != 0 && !client.field526) {
                                    class168 var43 = class17.field261;
                                    var60 = client.field524;
                                    class183.field2953 = 1;
                                    class20.field582 = var43;
                                    class21.field589 = var29;
                                    class213.field3145 = 0;
                                    class183.field2956 = var60;
                                    class20.field583 = false;
                                    class183.field2957 = 2;
                                 }

                                 client.field315 = var29;
                                 continue;
                              }

                              if(var36 == 3202) {
                                 var5 -= 2;
                                 class191.method3781(class36.field803[var5], class36.field803[1 + var5]);
                                 continue;
                              }
                           } else {
                              int var22;
                              int var31;
                              byte[] var47;
                              if(var36 < 3400) {
                                 if(var36 == 3300) {
                                    class36.field803[var5++] = client.field301;
                                    continue;
                                 }

                                 if(var36 == 3301) {
                                    var5 -= 2;
                                    var29 = class36.field803[var5];
                                    var30 = class36.field803[var5 + 1];
                                    class36.field803[var5++] = class77.method1749(var29, var30);
                                    continue;
                                 }

                                 if(var36 == 3302) {
                                    var5 -= 2;
                                    var29 = class36.field803[var5];
                                    var30 = class36.field803[1 + var5];
                                    class36.field803[var5++] = class45.method1001(var29, var30);
                                    continue;
                                 }

                                 class15 var20;
                                 if(var36 == 3303) {
                                    var5 -= 2;
                                    var29 = class36.field803[var5];
                                    var30 = class36.field803[var5 + 1];
                                    var38 = class36.field803;
                                    var18 = var5++;
                                    var20 = (class15)class15.field229.method3822((long)var29);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(var30 == -1) {
                                       var19 = 0;
                                    } else {
                                       var31 = 0;

                                       for(var22 = 0; var22 < var20.field223.length; ++var22) {
                                          if(var30 == var20.field221[var22]) {
                                             var31 += var20.field223[var22];
                                          }
                                       }

                                       var19 = var31;
                                    }

                                    var38[var18] = var19;
                                    continue;
                                 }

                                 if(var36 == 3304) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    var39 = class36.field803;
                                    var60 = var5++;
                                    class50 var26 = (class50)class50.field1110.method3797((long)var29);
                                    class50 var71;
                                    if(null != var26) {
                                       var71 = var26;
                                    } else {
                                       var47 = class226.field3215.method3286(5, var29);
                                       var26 = new class50();
                                       if(null != var47) {
                                          var26.method1064(new class119(var47));
                                       }

                                       class50.field1110.method3788(var26, (long)var29);
                                       var71 = var26;
                                    }

                                    var39[var60] = var71.field1109;
                                    continue;
                                 }

                                 if(var36 == 3305) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    class36.field803[var5++] = client.field424[var29];
                                    continue;
                                 }

                                 if(var36 == 3306) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    class36.field803[var5++] = client.field425[var29];
                                    continue;
                                 }

                                 if(var36 == 3307) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    class36.field803[var5++] = client.field426[var29];
                                    continue;
                                 }

                                 if(var36 == 3308) {
                                    var29 = class14.field212;
                                    var30 = class172.field2734 + (class15.field225.field837 >> 7);
                                    var60 = (class15.field225.field880 >> 7) + class20.field576;
                                    class36.field803[var5++] = (var30 << 14) + (var29 << 28) + var60;
                                    continue;
                                 }

                                 if(var36 == 3309) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    class36.field803[var5++] = var29 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var36 == 3310) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    class36.field803[var5++] = var29 >> 28;
                                    continue;
                                 }

                                 if(var36 == 3311) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    class36.field803[var5++] = var29 & 16383;
                                    continue;
                                 }

                                 if(var36 == 3312) {
                                    class36.field803[var5++] = client.field410?1:0;
                                    continue;
                                 }

                                 if(var36 == 3313) {
                                    var5 -= 2;
                                    var29 = class36.field803[var5] + '耀';
                                    var30 = class36.field803[1 + var5];
                                    var38 = class36.field803;
                                    var18 = var5++;
                                    var20 = (class15)class15.field229.method3822((long)var29);
                                    if(var20 == null) {
                                       var19 = -1;
                                    } else if(var30 >= 0 && var30 < var20.field221.length) {
                                       var19 = var20.field221[var30];
                                    } else {
                                       var19 = -1;
                                    }

                                    var38[var18] = var19;
                                    continue;
                                 }

                                 if(var36 == 3314) {
                                    var5 -= 2;
                                    var29 = '耀' + class36.field803[var5];
                                    var30 = class36.field803[var5 + 1];
                                    class36.field803[var5++] = class45.method1001(var29, var30);
                                    continue;
                                 }

                                 if(var36 == 3315) {
                                    var5 -= 2;
                                    var29 = class36.field803[var5] + '耀';
                                    var30 = class36.field803[1 + var5];
                                    var38 = class36.field803;
                                    var18 = var5++;
                                    var20 = (class15)class15.field229.method3822((long)var29);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(var30 == -1) {
                                       var19 = 0;
                                    } else {
                                       var31 = 0;

                                       for(var22 = 0; var22 < var20.field223.length; ++var22) {
                                          if(var30 == var20.field221[var22]) {
                                             var31 += var20.field223[var22];
                                          }
                                       }

                                       var19 = var31;
                                    }

                                    var38[var18] = var19;
                                    continue;
                                 }

                                 if(var36 == 3316) {
                                    if(client.field454 >= 2) {
                                       class36.field803[var5++] = client.field454;
                                    } else {
                                       class36.field803[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var36 == 3317) {
                                    class36.field803[var5++] = client.field309;
                                    continue;
                                 }

                                 if(var36 == 3318) {
                                    class36.field803[var5++] = client.field386;
                                    continue;
                                 }

                                 if(var36 == 3321) {
                                    class36.field803[var5++] = client.field452;
                                    continue;
                                 }

                                 if(var36 == 3322) {
                                    class36.field803[var5++] = client.field453;
                                    continue;
                                 }

                                 if(var36 == 3323) {
                                    if(client.field456) {
                                       class36.field803[var5++] = 1;
                                    } else {
                                       class36.field803[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var36 == 3324) {
                                    class36.field803[var5++] = client.field291;
                                    continue;
                                 }
                              } else if(var36 < 3500) {
                                 if(var36 == 3400) {
                                    var5 -= 2;
                                    var29 = class36.field803[var5];
                                    var30 = class36.field803[var5 + 1];
                                    class48 var75 = (class48)class48.field1088.method3797((long)var29);
                                    class48 var41;
                                    if(var75 != null) {
                                       var41 = var75;
                                    } else {
                                       byte[] var66 = class48.field1092.method3286(8, var29);
                                       var75 = new class48();
                                       if(null != var66) {
                                          var75.method1038(new class119(var66));
                                       }

                                       class48.field1088.method3788(var75, (long)var29);
                                       var41 = var75;
                                    }

                                    var75 = var41;
                                    if(var41.field1090 != 115) {
                                       ;
                                    }

                                    for(var19 = 0; var19 < var75.field1093; ++var19) {
                                       if(var75.field1094[var19] == var30) {
                                          class36.field804[var6++] = var75.field1096[var19];
                                          var75 = null;
                                          break;
                                       }
                                    }

                                    if(var75 != null) {
                                       class36.field804[var6++] = var75.field1097;
                                    }
                                    continue;
                                 }

                                 if(var36 == 3408) {
                                    var5 -= 4;
                                    var29 = class36.field803[var5];
                                    var30 = class36.field803[var5 + 1];
                                    var60 = class36.field803[2 + var5];
                                    var18 = class36.field803[3 + var5];
                                    class48 var49 = (class48)class48.field1088.method3797((long)var60);
                                    class48 var65;
                                    if(null != var49) {
                                       var65 = var49;
                                    } else {
                                       byte[] var21 = class48.field1092.method3286(8, var60);
                                       var49 = new class48();
                                       if(null != var21) {
                                          var49.method1038(new class119(var21));
                                       }

                                       class48.field1088.method3788(var49, (long)var60);
                                       var65 = var49;
                                    }

                                    var49 = var65;
                                    if(var29 == var65.field1089 && var30 == var65.field1090) {
                                       for(var31 = 0; var31 < var49.field1093; ++var31) {
                                          if(var18 == var49.field1094[var31]) {
                                             if(var30 == 115) {
                                                class36.field804[var6++] = var49.field1096[var31];
                                             } else {
                                                class36.field803[var5++] = var49.field1091[var31];
                                             }

                                             var49 = null;
                                             break;
                                          }
                                       }

                                       if(var49 != null) {
                                          if(var30 == 115) {
                                             class36.field804[var6++] = var49.field1097;
                                          } else {
                                             class36.field803[var5++] = var49.field1095;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var30 == 115) {
                                       class36.field804[var6++] = "null";
                                    } else {
                                       class36.field803[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else if(var36 < 3700) {
                                 if(var36 == 3600) {
                                    if(client.field397 == 0) {
                                       class36.field803[var5++] = -2;
                                    } else if(client.field397 == 1) {
                                       class36.field803[var5++] = -1;
                                    } else {
                                       class36.field803[var5++] = client.field555;
                                    }
                                    continue;
                                 }

                                 if(var36 == 3601) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(client.field397 == 2 && var29 < client.field555) {
                                       class36.field804[var6++] = client.field557[var29].field254;
                                       class36.field804[var6++] = client.field557[var29].field248;
                                       continue;
                                    }

                                    class36.field804[var6++] = "";
                                    class36.field804[var6++] = "";
                                    continue;
                                 }

                                 if(var36 == 3602) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(client.field397 == 2 && var29 < client.field555) {
                                       class36.field803[var5++] = client.field557[var29].field249;
                                       continue;
                                    }

                                    class36.field803[var5++] = 0;
                                    continue;
                                 }

                                 if(var36 == 3603) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(client.field397 == 2 && var29 < client.field555) {
                                       class36.field803[var5++] = client.field557[var29].field260;
                                       continue;
                                    }

                                    class36.field803[var5++] = 0;
                                    continue;
                                 }

                                 if(var36 == 3604) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    --var5;
                                    var30 = class36.field803[var5];
                                    class37.method789(var55, var30);
                                    continue;
                                 }

                                 if(var36 == 3605) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    class166.method3276(var55);
                                    continue;
                                 }

                                 if(var36 == 3606) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    class4.method48(var55);
                                    continue;
                                 }

                                 if(var36 == 3607) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    class74.method1658(var55, false);
                                    continue;
                                 }

                                 String var69;
                                 if(var36 == 3608) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    if(var55 == null) {
                                       continue;
                                    }

                                    var42 = class138.method2969(var55, client.field294);
                                    if(var42 == null) {
                                       continue;
                                    }

                                    var60 = 0;

                                    while(true) {
                                       if(var60 >= client.field559) {
                                          continue label3453;
                                       }

                                       class7 var85 = client.field560[var60];
                                       var69 = var85.field134;
                                       var56 = class138.method2969(var69, client.field294);
                                       if(class26.method674(var55, var42, var69, var56)) {
                                          --client.field559;

                                          for(var31 = var60; var31 < client.field559; ++var31) {
                                             client.field560[var31] = client.field560[var31 + 1];
                                          }

                                          client.field480 = client.field563;
                                          client.field333.method2773(111);
                                          client.field333.method2654(class23.method629(var55));
                                          client.field333.method2545(var55);
                                          continue label3453;
                                       }

                                       ++var60;
                                    }
                                 }

                                 if(var36 == 3609) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    class152[] var48 = class9.method135();

                                    for(var60 = 0; var60 < var48.length; ++var60) {
                                       class152 var83 = var48[var60];
                                       if(var83.field2260 != -1) {
                                          var31 = var83.field2260;
                                          var56 = "<img=" + var31 + ">";
                                          if(var55.startsWith(var56)) {
                                             var55 = var55.substring(6 + Integer.toString(var83.field2260).length());
                                             break;
                                          }
                                       }
                                    }

                                    class36.field803[var5++] = class90.method2140(var55, false)?1:0;
                                    continue;
                                 }

                                 if(var36 == 3611) {
                                    if(null != client.field514) {
                                       class36.field804[var6++] = class19.method245(client.field514);
                                    } else {
                                       class36.field804[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var36 == 3612) {
                                    if(null != client.field514) {
                                       class36.field803[var5++] = class96.field1636;
                                    } else {
                                       class36.field803[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var36 == 3613) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(null != client.field514 && var29 < class96.field1636) {
                                       class36.field804[var6++] = class35.field792[var29].field629;
                                       continue;
                                    }

                                    class36.field804[var6++] = "";
                                    continue;
                                 }

                                 if(var36 == 3614) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(null != client.field514 && var29 < class96.field1636) {
                                       class36.field803[var5++] = class35.field792[var29].field622;
                                       continue;
                                    }

                                    class36.field803[var5++] = 0;
                                    continue;
                                 }

                                 if(var36 == 3615) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(client.field514 != null && var29 < class96.field1636) {
                                       class36.field803[var5++] = class35.field792[var29].field623;
                                       continue;
                                    }

                                    class36.field803[var5++] = 0;
                                    continue;
                                 }

                                 if(var36 == 3616) {
                                    class36.field803[var5++] = class183.field2959;
                                    continue;
                                 }

                                 if(var36 == 3617) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    class99.method2268(var55);
                                    continue;
                                 }

                                 if(var36 == 3618) {
                                    class36.field803[var5++] = class8.field148;
                                    continue;
                                 }

                                 if(var36 == 3619) {
                                    --var6;
                                    var55 = class36.field804[var6];
                                    class151.method3169(var55);
                                    continue;
                                 }

                                 if(var36 == 3620) {
                                    class35.method775();
                                    continue;
                                 }

                                 if(var36 == 3621) {
                                    if(client.field397 == 0) {
                                       class36.field803[var5++] = -1;
                                    } else {
                                       class36.field803[var5++] = client.field559;
                                    }
                                    continue;
                                 }

                                 if(var36 == 3622) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(client.field397 != 0 && var29 < client.field559) {
                                       class36.field804[var6++] = client.field560[var29].field134;
                                       class36.field804[var6++] = client.field560[var29].field137;
                                       continue;
                                    }

                                    class36.field804[var6++] = "";
                                    class36.field804[var6++] = "";
                                    continue;
                                 }

                                 if(var36 == 3623) {
                                    label3238: {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       var17 = "<img=0>";
                                       if(!var55.startsWith(var17)) {
                                          var69 = "<img=1>";
                                          if(!var55.startsWith(var69)) {
                                             break label3238;
                                          }
                                       }

                                       var55 = var55.substring(7);
                                    }

                                    class36.field803[var5++] = class2.method43(var55)?1:0;
                                    continue;
                                 }

                                 if(var36 == 3624) {
                                    --var5;
                                    var29 = class36.field803[var5];
                                    if(class35.field792 != null && var29 < class96.field1636 && class35.field792[var29].field629.equalsIgnoreCase(class15.field225.field60)) {
                                       class36.field803[var5++] = 1;
                                       continue;
                                    }

                                    class36.field803[var5++] = 0;
                                    continue;
                                 }

                                 if(var36 == 3625) {
                                    if(client.field515 != null) {
                                       class36.field804[var6++] = class19.method245(client.field515);
                                    } else {
                                       class36.field804[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else {
                                 long var77;
                                 if(var36 < 4000) {
                                    if(var36 == 3903) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = client.field564[var29].method4018();
                                       continue;
                                    }

                                    if(var36 == 3904) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = client.field564[var29].field3168;
                                       continue;
                                    }

                                    if(var36 == 3905) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = client.field564[var29].field3169;
                                       continue;
                                    }

                                    if(var36 == 3906) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = client.field564[var29].field3172;
                                       continue;
                                    }

                                    if(var36 == 3907) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = client.field564[var29].field3171;
                                       continue;
                                    }

                                    if(var36 == 3908) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = client.field564[var29].field3170;
                                       continue;
                                    }

                                    if(var36 == 3910) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var30 = client.field564[var29].method4017();
                                       class36.field803[var5++] = var30 == 0?1:0;
                                       continue;
                                    }

                                    if(var36 == 3911) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var30 = client.field564[var29].method4017();
                                       class36.field803[var5++] = var30 == 2?1:0;
                                       continue;
                                    }

                                    if(var36 == 3912) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var30 = client.field564[var29].method4017();
                                       class36.field803[var5++] = var30 == 5?1:0;
                                       continue;
                                    }

                                    if(var36 == 3913) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var30 = client.field564[var29].method4017();
                                       class36.field803[var5++] = var30 == 1?1:0;
                                       continue;
                                    }

                                    boolean var93;
                                    if(var36 == 3914) {
                                       --var5;
                                       var93 = class36.field803[var5] == 1;
                                       if(null != class136.field2098) {
                                          class136.field2098.method4035(class221.field3175, var93);
                                       }
                                       continue;
                                    }

                                    if(var36 == 3915) {
                                       --var5;
                                       var93 = class36.field803[var5] == 1;
                                       if(null != class136.field2098) {
                                          class136.field2098.method4035(class221.field3177, var93);
                                       }
                                       continue;
                                    }

                                    if(var36 == 3916) {
                                       var5 -= 2;
                                       var93 = class36.field803[var5] == 1;
                                       var87 = class36.field803[1 + var5] == 1;
                                       if(null != class136.field2098) {
                                          class136.field2098.method4035(new class21(var87), var93);
                                       }
                                       continue;
                                    }

                                    if(var36 == 3917) {
                                       --var5;
                                       var93 = class36.field803[var5] == 1;
                                       if(null != class136.field2098) {
                                          class136.field2098.method4035(class221.field3174, var93);
                                       }
                                       continue;
                                    }

                                    if(var36 == 3918) {
                                       --var5;
                                       var93 = class36.field803[var5] == 1;
                                       if(null != class136.field2098) {
                                          class136.field2098.method4035(class221.field3178, var93);
                                       }
                                       continue;
                                    }

                                    if(var36 == 3919) {
                                       class36.field803[var5++] = class136.field2098 == null?0:class136.field2098.field3176.size();
                                       continue;
                                    }

                                    class214 var51;
                                    if(var36 == 3920) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       class36.field803[var5++] = var51.field3149;
                                       continue;
                                    }

                                    if(var36 == 3921) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       class36.field804[var6++] = var51.method3974();
                                       continue;
                                    }

                                    if(var36 == 3922) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       class36.field804[var6++] = var51.method3975();
                                       continue;
                                    }

                                    if(var36 == 3923) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       var77 = class130.method2846() - class8.field145 - var51.field3148;
                                       var19 = (int)(var77 / 3600000L);
                                       var27 = (int)((var77 - (long)(var19 * 3600000)) / 60000L);
                                       var31 = (int)((var77 - (long)(3600000 * var19) - (long)('\uea60' * var27)) / 1000L);
                                       String var32 = var19 + ":" + var27 / 10 + var27 % 10 + ":" + var31 / 10 + var31 % 10;
                                       class36.field804[var6++] = var32;
                                       continue;
                                    }

                                    if(var36 == 3924) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       class36.field803[var5++] = var51.field3147.field3172;
                                       continue;
                                    }

                                    if(var36 == 3925) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       class36.field803[var5++] = var51.field3147.field3169;
                                       continue;
                                    }

                                    if(var36 == 3926) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var51 = (class214)class136.field2098.field3176.get(var29);
                                       class36.field803[var5++] = var51.field3147.field3168;
                                       continue;
                                    }
                                 } else if(var36 < 4100) {
                                    if(var36 == 4000) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var29 + var30;
                                       continue;
                                    }

                                    if(var36 == 4001) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[1 + var5];
                                       class36.field803[var5++] = var29 - var30;
                                       continue;
                                    }

                                    if(var36 == 4002) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var30 * var29;
                                       continue;
                                    }

                                    if(var36 == 4003) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[1 + var5];
                                       class36.field803[var5++] = var29 / var30;
                                       continue;
                                    }

                                    if(var36 == 4004) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = (int)(Math.random() * (double)var29);
                                       continue;
                                    }

                                    if(var36 == 4005) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = (int)(Math.random() * (double)(var29 + 1));
                                       continue;
                                    }

                                    if(var36 == 4006) {
                                       var5 -= 5;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       var60 = class36.field803[2 + var5];
                                       var18 = class36.field803[3 + var5];
                                       var19 = class36.field803[4 + var5];
                                       class36.field803[var5++] = (var30 - var29) * (var19 - var60) / (var18 - var60) + var29;
                                       continue;
                                    }

                                    if(var36 == 4007) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var29 * var30 / 100 + var29;
                                       continue;
                                    }

                                    if(var36 == 4008) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var29 | 1 << var30;
                                       continue;
                                    }

                                    if(var36 == 4009) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var29 & -1 - (1 << var30);
                                       continue;
                                    }

                                    if(var36 == 4010) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = (var29 & 1 << var30) != 0?1:0;
                                       continue;
                                    }

                                    if(var36 == 4011) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var29 % var30;
                                       continue;
                                    }

                                    if(var36 == 4012) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[1 + var5];
                                       if(var29 == 0) {
                                          class36.field803[var5++] = 0;
                                       } else {
                                          class36.field803[var5++] = (int)Math.pow((double)var29, (double)var30);
                                       }
                                       continue;
                                    }

                                    if(var36 == 4013) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       if(var29 == 0) {
                                          class36.field803[var5++] = 0;
                                       } else if(var30 == 0) {
                                          class36.field803[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class36.field803[var5++] = (int)Math.pow((double)var29, 1.0D / (double)var30);
                                       }
                                       continue;
                                    }

                                    if(var36 == 4014) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class36.field803[var5++] = var29 & var30;
                                       continue;
                                    }

                                    if(var36 == 4015) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[1 + var5];
                                       class36.field803[var5++] = var29 | var30;
                                       continue;
                                    }

                                    if(var36 == 4018) {
                                       var5 -= 3;
                                       long var97 = (long)class36.field803[var5];
                                       var77 = (long)class36.field803[1 + var5];
                                       long var59 = (long)class36.field803[var5 + 2];
                                       class36.field803[var5++] = (int)(var59 * var97 / var77);
                                       continue;
                                    }
                                 } else if(var36 < 4200) {
                                    if(var36 == 4100) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       --var5;
                                       var30 = class36.field803[var5];
                                       class36.field804[var6++] = var55 + var30;
                                       continue;
                                    }

                                    if(var36 == 4101) {
                                       var6 -= 2;
                                       var55 = class36.field804[var6];
                                       var42 = class36.field804[var6 + 1];
                                       class36.field804[var6++] = var55 + var42;
                                       continue;
                                    }

                                    if(var36 == 4102) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       --var5;
                                       var30 = class36.field803[var5];
                                       var44 = class36.field804;
                                       var18 = var6++;
                                       if(var30 < 0) {
                                          var56 = Integer.toString(var30);
                                       } else {
                                          var56 = class76.method1706(var30, 10, true);
                                       }

                                       var44[var18] = var55 + var56;
                                       continue;
                                    }

                                    if(var36 == 4103) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       class36.field804[var6++] = var55.toLowerCase();
                                       continue;
                                    }

                                    if(var36 == 4104) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       long var95 = 86400000L * (11745L + (long)var29);
                                       class36.field807.setTime(new Date(var95));
                                       var18 = class36.field807.get(5);
                                       var19 = class36.field807.get(2);
                                       var27 = class36.field807.get(1);
                                       class36.field804[var6++] = var18 + "-" + class36.field810[var19] + "-" + var27;
                                       continue;
                                    }

                                    if(var36 == 4105) {
                                       var6 -= 2;
                                       var55 = class36.field804[var6];
                                       var42 = class36.field804[var6 + 1];
                                       if(null != class15.field225.field36 && class15.field225.field36.field2917) {
                                          class36.field804[var6++] = var42;
                                          continue;
                                       }

                                       class36.field804[var6++] = var55;
                                       continue;
                                    }

                                    if(var36 == 4106) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field804[var6++] = Integer.toString(var29);
                                       continue;
                                    }

                                    if(var36 == 4107) {
                                       var6 -= 2;
                                       class36.field803[var5++] = class30.method709(class121.method2768(class36.field804[var6], class36.field804[var6 + 1], client.field297));
                                       continue;
                                    }

                                    class224 var72;
                                    byte[] var86;
                                    if(var36 == 4108) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       var5 -= 2;
                                       var30 = class36.field803[var5];
                                       var60 = class36.field803[1 + var5];
                                       var86 = class186.field3004.method3286(var60, 0);
                                       var72 = new class224(var86);
                                       class36.field803[var5++] = var72.method4046(var55, var30);
                                       continue;
                                    }

                                    if(var36 == 4109) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       var5 -= 2;
                                       var30 = class36.field803[var5];
                                       var60 = class36.field803[1 + var5];
                                       var86 = class186.field3004.method3286(var60, 0);
                                       var72 = new class224(var86);
                                       class36.field803[var5++] = var72.method4045(var55, var30);
                                       continue;
                                    }

                                    if(var36 == 4110) {
                                       var6 -= 2;
                                       var55 = class36.field804[var6];
                                       var42 = class36.field804[var6 + 1];
                                       --var5;
                                       if(class36.field803[var5] == 1) {
                                          class36.field804[var6++] = var55;
                                       } else {
                                          class36.field804[var6++] = var42;
                                       }
                                       continue;
                                    }

                                    if(var36 == 4111) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       class36.field804[var6++] = class223.method4069(var55);
                                       continue;
                                    }

                                    if(var36 == 4112) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       --var5;
                                       var30 = class36.field803[var5];
                                       class36.field804[var6++] = var55 + (char)var30;
                                       continue;
                                    }

                                    if(var36 == 4113) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class109.method2471((char)var29)?1:0;
                                       continue;
                                    }

                                    if(var36 == 4114) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class25.method671((char)var29)?1:0;
                                       continue;
                                    }

                                    if(var36 == 4115) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class41.method895((char)var29)?1:0;
                                       continue;
                                    }

                                    if(var36 == 4116) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class36.method786((char)var29)?1:0;
                                       continue;
                                    }

                                    if(var36 == 4117) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       if(null != var55) {
                                          class36.field803[var5++] = var55.length();
                                       } else {
                                          class36.field803[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var36 == 4118) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       var5 -= 2;
                                       var30 = class36.field803[var5];
                                       var60 = class36.field803[1 + var5];
                                       class36.field804[var6++] = var55.substring(var30, var60);
                                       continue;
                                    }

                                    if(var36 == 4119) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       StringBuilder var58 = new StringBuilder(var55.length());
                                       var25 = false;

                                       for(var18 = 0; var18 < var55.length(); ++var18) {
                                          char var62 = var55.charAt(var18);
                                          if(var62 == 60) {
                                             var25 = true;
                                          } else if(var62 == 62) {
                                             var25 = false;
                                          } else if(!var25) {
                                             var58.append(var62);
                                          }
                                       }

                                       class36.field804[var6++] = var58.toString();
                                       continue;
                                    }

                                    if(var36 == 4120) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       --var5;
                                       var30 = class36.field803[var5];
                                       class36.field803[var5++] = var55.indexOf(var30);
                                       continue;
                                    }

                                    if(var36 == 4121) {
                                       var6 -= 2;
                                       var55 = class36.field804[var6];
                                       var42 = class36.field804[var6 + 1];
                                       --var5;
                                       var60 = class36.field803[var5];
                                       class36.field803[var5++] = var55.indexOf(var42, var60);
                                       continue;
                                    }
                                 } else if(var36 < 4300) {
                                    if(var36 == 4200) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field804[var6++] = class141.method3001(var29).field1128;
                                       continue;
                                    }

                                    class51 var46;
                                    if(var36 == 4201) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       var46 = class141.method3001(var29);
                                       if(var30 >= 1 && var30 <= 5 && null != var46.field1136[var30 - 1]) {
                                          class36.field804[var6++] = var46.field1136[var30 - 1];
                                          continue;
                                       }

                                       class36.field804[var6++] = "";
                                       continue;
                                    }

                                    if(var36 == 4202) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       var46 = class141.method3001(var29);
                                       if(var30 >= 1 && var30 <= 5 && null != var46.field1149[var30 - 1]) {
                                          class36.field804[var6++] = var46.field1149[var30 - 1];
                                          continue;
                                       }

                                       class36.field804[var6++] = "";
                                       continue;
                                    }

                                    if(var36 == 4203) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class141.method3001(var29).field1134;
                                       continue;
                                    }

                                    if(var36 == 4204) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class141.method3001(var29).field1151 == 1?1:0;
                                       continue;
                                    }

                                    class51 var61;
                                    if(var36 == 4205) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var61 = class141.method3001(var29);
                                       if(var61.field1153 == -1 && var61.field1152 >= 0) {
                                          class36.field803[var5++] = var61.field1152;
                                          continue;
                                       }

                                       class36.field803[var5++] = var29;
                                       continue;
                                    }

                                    if(var36 == 4206) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var61 = class141.method3001(var29);
                                       if(var61.field1153 >= 0 && var61.field1152 >= 0) {
                                          class36.field803[var5++] = var61.field1152;
                                          continue;
                                       }

                                       class36.field803[var5++] = var29;
                                       continue;
                                    }

                                    if(var36 == 4207) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class141.method3001(var29).field1146?1:0;
                                       continue;
                                    }

                                    if(var36 == 4208) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var61 = class141.method3001(var29);
                                       if(var61.field1164 == -1 && var61.field1163 >= 0) {
                                          class36.field803[var5++] = var61.field1163;
                                          continue;
                                       }

                                       class36.field803[var5++] = var29;
                                       continue;
                                    }

                                    if(var36 == 4209) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var61 = class141.method3001(var29);
                                       if(var61.field1164 >= 0 && var61.field1163 >= 0) {
                                          class36.field803[var5++] = var61.field1163;
                                          continue;
                                       }

                                       class36.field803[var5++] = var29;
                                       continue;
                                    }

                                    if(var36 == 4210) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       --var5;
                                       var30 = class36.field803[var5];
                                       class72.method1636(var55, var30 == 1);
                                       class36.field803[var5++] = class24.field625;
                                       continue;
                                    }

                                    if(var36 == 4211) {
                                       if(class106.field1874 != null && class163.field2647 < class24.field625) {
                                          class36.field803[var5++] = class106.field1874[++class163.field2647 - 1] & '\uffff';
                                          continue;
                                       }

                                       class36.field803[var5++] = -1;
                                       continue;
                                    }

                                    if(var36 == 4212) {
                                       class163.field2647 = 0;
                                       continue;
                                    }
                                 } else if(var36 < 5100) {
                                    if(var36 == 5000) {
                                       class36.field803[var5++] = client.field505;
                                       continue;
                                    }

                                    if(var36 == 5001) {
                                       var5 -= 3;
                                       client.field505 = class36.field803[var5];
                                       var30 = class36.field803[var5 + 1];
                                       class130[] var54 = class113.method2495();
                                       var18 = 0;

                                       class130 var96;
                                       while(true) {
                                          if(var18 >= var54.length) {
                                             var96 = null;
                                             break;
                                          }

                                          class130 var78 = var54[var18];
                                          if(var78.field2065 == var30) {
                                             var96 = var78;
                                             break;
                                          }

                                          ++var18;
                                       }

                                       class47.field1077 = var96;
                                       if(null == class47.field1077) {
                                          class47.field1077 = class130.field2060;
                                       }

                                       client.field506 = class36.field803[var5 + 2];
                                       client.field333.method2773(129);
                                       client.field333.method2654(client.field505);
                                       client.field333.method2654(class47.field1077.field2065);
                                       client.field333.method2654(client.field506);
                                       continue;
                                    }

                                    if(var36 == 5002) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       var5 -= 2;
                                       var30 = class36.field803[var5];
                                       var60 = class36.field803[var5 + 1];
                                       client.field333.method2773(135);
                                       client.field333.method2654(class23.method629(var55) + 2);
                                       client.field333.method2545(var55);
                                       client.field333.method2654(var30 - 1);
                                       client.field333.method2654(var60);
                                       continue;
                                    }

                                    if(var36 == 5003) {
                                       var5 -= 2;
                                       var29 = class36.field803[var5];
                                       var30 = class36.field803[1 + var5];
                                       class35 var53 = class56.method1289(var29, var30);
                                       if(null != var53) {
                                          class36.field803[var5++] = var53.field793;
                                          class36.field803[var5++] = var53.field786;
                                          class36.field804[var6++] = null != var53.field789?var53.field789:"";
                                          class36.field804[var6++] = null != var53.field790?var53.field790:"";
                                          class36.field804[var6++] = var53.field791 != null?var53.field791:"";
                                       } else {
                                          class36.field803[var5++] = -1;
                                          class36.field803[var5++] = 0;
                                          class36.field804[var6++] = "";
                                          class36.field804[var6++] = "";
                                          class36.field804[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var36 == 5004) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class35 var67 = (class35)class11.field182.method3840((long)var29);
                                       if(null != var67) {
                                          class36.field803[var5++] = var67.field794;
                                          class36.field803[var5++] = var67.field786;
                                          class36.field804[var6++] = null != var67.field789?var67.field789:"";
                                          class36.field804[var6++] = null != var67.field790?var67.field790:"";
                                          class36.field804[var6++] = null != var67.field791?var67.field791:"";
                                       } else {
                                          class36.field803[var5++] = -1;
                                          class36.field803[var5++] = 0;
                                          class36.field804[var6++] = "";
                                          class36.field804[var6++] = "";
                                          class36.field804[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var36 == 5005) {
                                       if(class47.field1077 == null) {
                                          class36.field803[var5++] = -1;
                                       } else {
                                          class36.field803[var5++] = class47.field1077.field2065;
                                       }
                                       continue;
                                    }

                                    if(var36 == 5008) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       --var5;
                                       var30 = class36.field803[var5];
                                       var17 = var55.toLowerCase();
                                       byte var57 = 0;
                                       if(var17.startsWith("yellow:")) {
                                          var57 = 0;
                                          var55 = var55.substring("yellow:".length());
                                       } else if(var17.startsWith("red:")) {
                                          var57 = 1;
                                          var55 = var55.substring("red:".length());
                                       } else if(var17.startsWith("green:")) {
                                          var57 = 2;
                                          var55 = var55.substring("green:".length());
                                       } else if(var17.startsWith("cyan:")) {
                                          var57 = 3;
                                          var55 = var55.substring("cyan:".length());
                                       } else if(var17.startsWith("purple:")) {
                                          var57 = 4;
                                          var55 = var55.substring("purple:".length());
                                       } else if(var17.startsWith("white:")) {
                                          var57 = 5;
                                          var55 = var55.substring("white:".length());
                                       } else if(var17.startsWith("flash1:")) {
                                          var57 = 6;
                                          var55 = var55.substring("flash1:".length());
                                       } else if(var17.startsWith("flash2:")) {
                                          var57 = 7;
                                          var55 = var55.substring("flash2:".length());
                                       } else if(var17.startsWith("flash3:")) {
                                          var57 = 8;
                                          var55 = var55.substring("flash3:".length());
                                       } else if(var17.startsWith("glow1:")) {
                                          var57 = 9;
                                          var55 = var55.substring("glow1:".length());
                                       } else if(var17.startsWith("glow2:")) {
                                          var57 = 10;
                                          var55 = var55.substring("glow2:".length());
                                       } else if(var17.startsWith("glow3:")) {
                                          var57 = 11;
                                          var55 = var55.substring("glow3:".length());
                                       } else if(client.field297 != 0) {
                                          if(var17.startsWith("yellow:")) {
                                             var57 = 0;
                                             var55 = var55.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var57 = 1;
                                             var55 = var55.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var57 = 2;
                                             var55 = var55.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var57 = 3;
                                             var55 = var55.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var57 = 4;
                                             var55 = var55.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var57 = 5;
                                             var55 = var55.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var57 = 6;
                                             var55 = var55.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var57 = 7;
                                             var55 = var55.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var57 = 8;
                                             var55 = var55.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var57 = 9;
                                             var55 = var55.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var57 = 10;
                                             var55 = var55.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var57 = 11;
                                             var55 = var55.substring("glow3:".length());
                                          }
                                       }

                                       var17 = var55.toLowerCase();
                                       byte var64 = 0;
                                       if(var17.startsWith("wave:")) {
                                          var64 = 1;
                                          var55 = var55.substring("wave:".length());
                                       } else if(var17.startsWith("wave2:")) {
                                          var64 = 2;
                                          var55 = var55.substring("wave2:".length());
                                       } else if(var17.startsWith("shake:")) {
                                          var64 = 3;
                                          var55 = var55.substring("shake:".length());
                                       } else if(var17.startsWith("scroll:")) {
                                          var64 = 4;
                                          var55 = var55.substring("scroll:".length());
                                       } else if(var17.startsWith("slide:")) {
                                          var64 = 5;
                                          var55 = var55.substring("slide:".length());
                                       } else if(client.field297 != 0) {
                                          if(var17.startsWith("wave:")) {
                                             var64 = 1;
                                             var55 = var55.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var64 = 2;
                                             var55 = var55.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var64 = 3;
                                             var55 = var55.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var64 = 4;
                                             var55 = var55.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var64 = 5;
                                             var55 = var55.substring("slide:".length());
                                          }
                                       }

                                       client.field333.method2773(57);
                                       client.field333.method2654(0);
                                       var27 = client.field333.field1998;
                                       client.field333.method2654(var30);
                                       client.field333.method2654(var57);
                                       client.field333.method2654(var64);
                                       class122 var50 = client.field333;
                                       var22 = var50.field1998;
                                       byte[] var23 = class130.method2850(var55);
                                       var50.method2600(var23.length);
                                       var50.field1998 += class222.field3181.method2489(var23, 0, var23.length, var50.field2000, var50.field1998);
                                       client.field333.method2551(client.field333.field1998 - var27);
                                       continue;
                                    }

                                    if(var36 == 5009) {
                                       var6 -= 2;
                                       var55 = class36.field804[var6];
                                       var42 = class36.field804[var6 + 1];
                                       client.field333.method2773(246);
                                       client.field333.method2540(0);
                                       var60 = client.field333.field1998;
                                       client.field333.method2545(var55);
                                       class122 var88 = client.field333;
                                       var19 = var88.field1998;
                                       var47 = class130.method2850(var42);
                                       var88.method2600(var47.length);
                                       var88.field1998 += class222.field3181.method2489(var47, 0, var47.length, var88.field2000, var88.field1998);
                                       client.field333.method2550(client.field333.field1998 - var60);
                                       continue;
                                    }

                                    if(var36 == 5015) {
                                       if(class15.field225 != null && class15.field225.field60 != null) {
                                          var55 = class15.field225.field60;
                                       } else {
                                          var55 = "";
                                       }

                                       class36.field804[var6++] = var55;
                                       continue;
                                    }

                                    if(var36 == 5016) {
                                       class36.field803[var5++] = client.field506;
                                       continue;
                                    }

                                    if(var36 == 5017) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var39 = class36.field803;
                                       var60 = var5++;
                                       class27 var76 = (class27)class11.field178.get(Integer.valueOf(var29));
                                       if(null == var76) {
                                          var18 = 0;
                                       } else {
                                          var18 = var76.method682();
                                       }

                                       var39[var60] = var18;
                                       continue;
                                    }

                                    if(var36 == 5018) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       var39 = class36.field803;
                                       var60 = var5++;
                                       class35 var74 = (class35)class11.field182.method3840((long)var29);
                                       if(null == var74) {
                                          var18 = -1;
                                       } else if(var74.field3105 == class11.field179.field3101) {
                                          var18 = -1;
                                       } else {
                                          var18 = ((class35)var74.field3105).field793;
                                       }

                                       var39[var60] = var18;
                                       continue;
                                    }

                                    if(var36 == 5019) {
                                       --var5;
                                       var29 = class36.field803[var5];
                                       class36.field803[var5++] = class106.method2423(var29);
                                       continue;
                                    }

                                    if(var36 == 5020) {
                                       --var6;
                                       var55 = class36.field804[var6];
                                       class10.method138(var55);
                                       continue;
                                    }

                                    if(var36 == 5021) {
                                       --var6;
                                       client.field507 = class36.field804[var6].toLowerCase().trim();
                                       continue;
                                    }

                                    if(var36 == 5022) {
                                       class36.field804[var6++] = client.field507;
                                       continue;
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var36 >= 2000) {
                              var36 -= 1000;
                              --var5;
                              var15 = class153.method3177(class36.field803[var5]);
                           } else {
                              var15 = var45?class36.field800:class36.field813;
                           }

                           if(var36 == 1300) {
                              --var5;
                              var30 = class36.field803[var5] - 1;
                              if(var30 >= 0 && var30 <= 9) {
                                 --var6;
                                 var15.method3437(var30, class36.field804[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var36 == 1301) {
                              var5 -= 2;
                              var30 = class36.field803[var5];
                              var60 = class36.field803[1 + var5];
                              var15.field2829 = class172.method3425(var30, var60);
                              continue;
                           }

                           if(var36 == 1302) {
                              --var5;
                              var15.field2832 = class36.field803[var5] == 1;
                              continue;
                           }

                           if(var36 == 1303) {
                              --var5;
                              var15.field2830 = class36.field803[var5];
                              continue;
                           }

                           if(var36 == 1304) {
                              --var5;
                              var15.field2831 = class36.field803[var5];
                              continue;
                           }

                           if(var36 == 1305) {
                              --var6;
                              var15.field2833 = class36.field804[var6];
                              continue;
                           }

                           if(var36 == 1306) {
                              --var6;
                              var15.field2795 = class36.field804[var6];
                              continue;
                           }

                           if(var36 == 1307) {
                              var15.field2854 = null;
                              continue;
                           }
                        }
                     } else {
                        if(var36 >= 2000) {
                           var36 -= 1000;
                           --var5;
                           var15 = class153.method3177(class36.field803[var5]);
                        } else {
                           var15 = var45?class36.field800:class36.field813;
                        }

                        class39.method818(var15);
                        if(var36 == 1200 || var36 == 1205 || var36 == 1212) {
                           var5 -= 2;
                           var30 = class36.field803[var5];
                           var60 = class36.field803[1 + var5];
                           var15.field2764 = var30;
                           var15.field2794 = var60;
                           class51 var28 = class141.method3001(var30);
                           var15.field2805 = var28.field1117;
                           var15.field2806 = var28.field1129;
                           var15.field2746 = var28.field1131;
                           var15.field2803 = var28.field1133;
                           var15.field2804 = var28.field1132;
                           var15.field2874 = var28.field1127;
                           if(var36 == 1205) {
                              var15.field2812 = 0;
                           } else if(var36 == 1212 | var28.field1151 == 1) {
                              var15.field2812 = 1;
                           } else {
                              var15.field2812 = 2;
                           }

                           if(var15.field2809 > 0) {
                              var15.field2874 = var15.field2874 * 32 / var15.field2809;
                           } else if(var15.field2825 > 0) {
                              var15.field2874 = var15.field2874 * 32 / var15.field2825;
                           }
                           continue;
                        }

                        if(var36 == 1201) {
                           var15.field2797 = 2;
                           --var5;
                           var15.field2768 = class36.field803[var5];
                           continue;
                        }

                        if(var36 == 1202) {
                           var15.field2797 = 3;
                           var15.field2768 = class15.field225.field36.method3516();
                           continue;
                        }
                     }
                  } else {
                     var29 = -1;
                     if(var36 >= 2000) {
                        var36 -= 1000;
                        --var5;
                        var29 = class36.field803[var5];
                        var16 = class153.method3177(var29);
                     } else {
                        var16 = var45?class36.field800:class36.field813;
                     }

                     if(var36 == 1000) {
                        var5 -= 4;
                        var16.field2763 = class36.field803[var5];
                        var16.field2753 = class36.field803[var5 + 1];
                        var16.field2759 = class36.field803[var5 + 2];
                        var16.field2858 = class36.field803[3 + var5];
                        class39.method818(var16);
                        class47.method1024(var16);
                        if(var29 != -1 && var16.field2798 == 0) {
                           class75.method1698(class173.field2770[var29 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var36 == 1001) {
                        var5 -= 4;
                        var16.field2825 = class36.field803[var5];
                        var16.field2863 = class36.field803[var5 + 1];
                        var16.field2761 = class36.field803[var5 + 2];
                        var16.field2762 = class36.field803[var5 + 3];
                        class39.method818(var16);
                        class47.method1024(var16);
                        if(var29 != -1 && var16.field2798 == 0) {
                           class75.method1698(class173.field2770[var29 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var36 == 1003) {
                        --var5;
                        var25 = class36.field803[var5] == 1;
                        if(var25 != var16.field2774) {
                           var16.field2774 = var25;
                           class39.method818(var16);
                        }
                        continue;
                     }

                     if(var36 == 1005) {
                        --var5;
                        var16.field2887 = class36.field803[var5] == 1;
                        continue;
                     }

                     if(var36 == 1006) {
                        --var5;
                        var16.field2849 = class36.field803[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var36 < 5400) {
                  if(var36 == 5306) {
                     int[] var99 = class36.field803;
                     var30 = var5++;
                     var60 = client.field501?2:1;
                     var99[var30] = var60;
                     continue;
                  }

                  if(var36 == 5307) {
                     --var5;
                     var29 = class36.field803[var5];
                     if(var29 != 1 && var29 != 2) {
                        continue;
                     }

                     client.field292 = 0L;
                     if(var29 >= 2) {
                        client.field501 = true;
                     } else {
                        client.field501 = false;
                     }

                     class159.method3193();
                     if(client.field299 >= 25) {
                        client.field333.method2773(81);
                        class122 var81 = client.field333;
                        var60 = client.field501?2:1;
                        var81.method2654(var60);
                        client.field333.method2540(class30.field708);
                        client.field333.method2540(class153.field2274);
                     }

                     class144.field2196 = true;
                     continue;
                  }

                  if(var36 == 5308) {
                     class36.field803[var5++] = class20.field580.field142;
                     continue;
                  }

                  if(var36 == 5309) {
                     --var5;
                     var29 = class36.field803[var5];
                     if(var29 == 1 || var29 == 2) {
                        class20.field580.field142 = var29;
                        class21.method613();
                     }
                     continue;
                  }
               }

               if(var36 < 5600) {
                  if(var36 == 5504) {
                     var5 -= 2;
                     var29 = class36.field803[var5];
                     var30 = class36.field803[1 + var5];
                     if(!client.field536) {
                        client.field373 = var29;
                        client.field374 = var30;
                     }
                     continue;
                  }

                  if(var36 == 5505) {
                     class36.field803[var5++] = client.field373;
                     continue;
                  }

                  if(var36 == 5506) {
                     class36.field803[var5++] = client.field374;
                     continue;
                  }

                  if(var36 == 5530) {
                     --var5;
                     var29 = class36.field803[var5];
                     if(var29 < 0) {
                        var29 = 0;
                     }

                     client.field379 = var29;
                     continue;
                  }

                  if(var36 == 5531) {
                     class36.field803[var5++] = client.field379;
                     continue;
                  }
               }

               if(var36 < 5700 && var36 == 5630) {
                  client.field343 = 250;
               } else {
                  if(var36 < 6300) {
                     if(var36 == 6200) {
                        var5 -= 2;
                        client.field344 = (short)class36.field803[var5];
                        if(client.field344 <= 0) {
                           client.field344 = 256;
                        }

                        client.field543 = (short)class36.field803[1 + var5];
                        if(client.field543 <= 0) {
                           client.field543 = 205;
                        }
                        continue;
                     }

                     if(var36 == 6201) {
                        var5 -= 2;
                        client.field544 = (short)class36.field803[var5];
                        if(client.field544 <= 0) {
                           client.field544 = 256;
                        }

                        client.field444 = (short)class36.field803[var5 + 1];
                        if(client.field444 <= 0) {
                           client.field444 = 320;
                        }
                        continue;
                     }

                     if(var36 == 6202) {
                        var5 -= 4;
                        client.field546 = (short)class36.field803[var5];
                        if(client.field546 <= 0) {
                           client.field546 = 1;
                        }

                        client.field547 = (short)class36.field803[1 + var5];
                        if(client.field547 <= 0) {
                           client.field547 = 32767;
                        } else if(client.field547 < client.field546) {
                           client.field547 = client.field546;
                        }

                        client.field420 = (short)class36.field803[var5 + 2];
                        if(client.field420 <= 0) {
                           client.field420 = 1;
                        }

                        client.field565 = (short)class36.field803[var5 + 3];
                        if(client.field565 <= 0) {
                           client.field565 = 32767;
                        } else if(client.field565 < client.field420) {
                           client.field565 = client.field420;
                        }
                        continue;
                     }

                     if(var36 == 6203) {
                        if(null != client.field462) {
                           class157.method3189(0, 0, client.field462.field2769, client.field462.field2888, false);
                           class36.field803[var5++] = client.field432;
                           class36.field803[var5++] = client.field553;
                        } else {
                           class36.field803[var5++] = -1;
                           class36.field803[var5++] = -1;
                        }
                        continue;
                     }

                     if(var36 == 6204) {
                        class36.field803[var5++] = client.field544;
                        class36.field803[var5++] = client.field444;
                        continue;
                     }

                     if(var36 == 6205) {
                        class36.field803[var5++] = client.field344;
                        class36.field803[var5++] = client.field543;
                        continue;
                     }
                  }

                  if(var36 < 6600) {
                     if(var36 == 6500) {
                        class36.field803[var5++] = class23.method623()?1:0;
                        continue;
                     }

                     class25 var98;
                     if(var36 == 6501) {
                        var98 = class4.method49();
                        if(var98 != null) {
                           class36.field803[var5++] = var98.field640;
                           class36.field803[var5++] = var98.field641;
                           class36.field804[var6++] = var98.field631;
                           class36.field803[var5++] = var98.field650;
                           class36.field803[var5++] = var98.field638;
                           class36.field804[var6++] = var98.field643;
                        } else {
                           class36.field803[var5++] = -1;
                           class36.field803[var5++] = 0;
                           class36.field804[var6++] = "";
                           class36.field803[var5++] = 0;
                           class36.field803[var5++] = 0;
                           class36.field804[var6++] = "";
                        }
                        continue;
                     }

                     if(var36 == 6502) {
                        if(class25.field637 < class25.field636) {
                           var98 = class25.field635[++class25.field637 - 1];
                        } else {
                           var15 = null;
                        }

                        class36.field803[var5++] = -1;
                        class36.field803[var5++] = 0;
                        class36.field804[var6++] = "";
                        class36.field803[var5++] = 0;
                        class36.field803[var5++] = 0;
                        class36.field804[var6++] = "";
                        continue;
                     }

                     class25 var73;
                     if(var36 == 6506) {
                        --var5;
                        var29 = class36.field803[var5];
                        var73 = null;

                        for(var60 = 0; var60 < class25.field636; ++var60) {
                           if(var29 == class25.field635[var60].field640) {
                              var73 = class25.field635[var60];
                              break;
                           }
                        }

                        if(null != var73) {
                           class36.field803[var5++] = var73.field640;
                           class36.field803[var5++] = var73.field641;
                           class36.field804[var6++] = var73.field631;
                           class36.field803[var5++] = var73.field650;
                           class36.field803[var5++] = var73.field638;
                           class36.field804[var6++] = var73.field643;
                        } else {
                           class36.field803[var5++] = -1;
                           class36.field803[var5++] = 0;
                           class36.field804[var6++] = "";
                           class36.field803[var5++] = 0;
                           class36.field803[var5++] = 0;
                           class36.field804[var6++] = "";
                        }
                        continue;
                     }

                     if(var36 == 6507) {
                        var5 -= 4;
                        var29 = class36.field803[var5];
                        var87 = class36.field803[var5 + 1] == 1;
                        var60 = class36.field803[2 + var5];
                        boolean var90 = class36.field803[3 + var5] == 1;
                        class24.method632(var29, var87, var60, var90);
                        continue;
                     }

                     if(var36 == 6511) {
                        --var5;
                        var29 = class36.field803[var5];
                        if(var29 >= 0 && var29 < class25.field636) {
                           var73 = class25.field635[var29];
                           class36.field803[var5++] = var73.field640;
                           class36.field803[var5++] = var73.field641;
                           class36.field804[var6++] = var73.field631;
                           class36.field803[var5++] = var73.field650;
                           class36.field803[var5++] = var73.field638;
                           class36.field804[var6++] = var73.field643;
                           continue;
                        }

                        class36.field803[var5++] = -1;
                        class36.field803[var5++] = 0;
                        class36.field804[var6++] = "";
                        class36.field803[var5++] = 0;
                        class36.field803[var5++] = 0;
                        class36.field804[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var35) {
            StringBuilder var34 = new StringBuilder(30);
            var34.append("").append(var4.field3115).append(" ");

            for(var13 = class36.field817 - 1; var13 >= 0; --var13) {
               var34.append("").append(class36.field806[var13].field213.field3115).append(" ");
            }

            var34.append("").append(var10);
            class45.method984(var34.toString(), var35);
         }
      }
   }
}

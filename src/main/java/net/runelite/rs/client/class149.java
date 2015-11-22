package net.runelite.rs.client;

import java.util.Date;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ez")
public final class class149 {
   @ObfuscatedName("eo")
   static class78[] field2236;

   @ObfuscatedName("m")
   static void method3182(class0 var0, int var1) {
      Object[] var2 = var0.field10;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class137.method2972(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field578;
         int[] var9 = var4.field576;
         byte var10 = -1;
         class36.field791 = 0;

         int var13;
         try {
            class36.field782 = new int[var4.field583];
            int var11 = 0;
            class36.field783 = new String[var4.field579];
            int var34 = 0;

            int var14;
            String var46;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(-2147483647 == var14) {
                     var14 = var0.field3;
                  }

                  if(-2147483646 == var14) {
                     var14 = var0.field4;
                  }

                  if(-2147483645 == var14) {
                     var14 = null != var0.field2?var0.field2.field2734 * -1:-1;
                  }

                  if(-2147483644 == var14) {
                     var14 = var0.field16;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field2 != null?var0.field2.field2735:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field15?var0.field15.field2734 * -1:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field15?var0.field15.field2735:-1;
                  }

                  if(-2147483640 == var14) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class36.field782[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var46 = (String)var2[var13];
                  if(var46.equals("event_opbase")) {
                     var46 = var0.field6;
                  }

                  class36.field783[var34++] = var46;
               }
            }

            var13 = 0;
            class36.field780 = var0.field0;

            label3711:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var33 = var8[var7];
               int var16;
               int[] var35;
               int var37;
               int var53;
               String var62;
               if(var33 < 100) {
                  if(var33 == 0) {
                     class36.field786[var5++] = var9[var7];
                     continue;
                  }

                  if(1 == var33) {
                     var14 = var9[var7];
                     class36.field786[var5++] = class175.field2884[var14];
                     continue;
                  }

                  if(var33 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class175.field2884[var14] = class36.field786[var5];
                     class132.method2896(var14);
                     continue;
                  }

                  if(3 == var33) {
                     class36.field787[var6++] = var4.field574[var7];
                     continue;
                  }

                  if(var33 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var33 == 7) {
                     var5 -= 2;
                     if(class36.field786[var5 + 1] != class36.field786[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var33) {
                     var5 -= 2;
                     if(class36.field786[var5 + 1] == class36.field786[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 9) {
                     var5 -= 2;
                     if(class36.field786[var5] < class36.field786[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 10) {
                     var5 -= 2;
                     if(class36.field786[var5] > class36.field786[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 21) {
                     if(class36.field791 == 0) {
                        return;
                     }

                     class14 var83 = class36.field789[--class36.field791];
                     var4 = var83.field211;
                     var8 = var4.field578;
                     var9 = var4.field576;
                     var7 = var83.field203;
                     class36.field782 = var83.field204;
                     class36.field783 = var83.field205;
                     continue;
                  }

                  if(var33 == 25) {
                     var14 = var9[var7];
                     class36.field786[var5++] = class160.method3227(var14);
                     continue;
                  }

                  if(27 == var33) {
                     var14 = var9[var7];
                     --var5;
                     class95.method2213(var14, class36.field786[var5]);
                     continue;
                  }

                  if(var33 == 31) {
                     var5 -= 2;
                     if(class36.field786[var5] <= class36.field786[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var33 == 32) {
                     var5 -= 2;
                     if(class36.field786[var5] >= class36.field786[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(33 == var33) {
                     class36.field786[var5++] = class36.field782[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(34 == var33) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field782[var10001] = class36.field786[var5];
                     continue;
                  }

                  if(35 == var33) {
                     class36.field787[var6++] = class36.field783[var9[var7]];
                     continue;
                  }

                  if(36 == var33) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field783[var10001] = class36.field787[var6];
                     continue;
                  }

                  if(var33 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var62 = class49.method1046(class36.field787, var6, var14);
                     class36.field787[var6++] = var62;
                     continue;
                  }

                  if(var33 == 38) {
                     --var5;
                     continue;
                  }

                  if(var33 == 39) {
                     --var6;
                     continue;
                  }

                  if(var33 == 40) {
                     var14 = var9[var7];
                     class22 var111 = class137.method2972(var14);
                     var35 = new int[var111.field583];
                     String[] var101 = new String[var111.field579];

                     for(var37 = 0; var37 < var111.field580; ++var37) {
                        var35[var37] = class36.field786[var5 - var111.field580 + var37];
                     }

                     for(var37 = 0; var37 < var111.field581; ++var37) {
                        var101[var37] = class36.field787[var6 - var111.field581 + var37];
                     }

                     var5 -= var111.field580;
                     var6 -= var111.field581;
                     class14 var107 = new class14();
                     var107.field211 = var4;
                     var107.field203 = var7;
                     var107.field204 = class36.field782;
                     var107.field205 = class36.field783;
                     class36.field789[++class36.field791 - 1] = var107;
                     var4 = var111;
                     var8 = var111.field578;
                     var9 = var111.field576;
                     var7 = -1;
                     class36.field782 = var35;
                     class36.field783 = var101;
                     continue;
                  }

                  if(var33 == 42) {
                     class36.field786[var5++] = class83.field1439.method232(var9[var7]);
                     continue;
                  }

                  if(var33 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class83.field1439.method224(var10001, class36.field786[var5]);
                     continue;
                  }

                  if(44 == var33) {
                     var14 = var9[var7] >> 16;
                     var53 = var9[var7] & '\uffff';
                     --var5;
                     var16 = class36.field786[var5];
                     if(var16 >= 0 && var16 <= 5000) {
                        class36.field788[var14] = var16;
                        byte var95 = -1;
                        if(105 == var53) {
                           var95 = 0;
                        }

                        var37 = 0;

                        while(true) {
                           if(var37 >= var16) {
                              continue label3711;
                           }

                           class36.field792[var14][var37] = var95;
                           ++var37;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var33 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var53 = class36.field786[var5];
                     if(var53 >= 0 && var53 < class36.field788[var14]) {
                        class36.field786[var5++] = class36.field792[var14][var53];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var33) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var53 = class36.field786[var5];
                     if(var53 >= 0 && var53 < class36.field788[var14]) {
                        class36.field792[var14][var53] = class36.field786[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(47 == var33) {
                     var46 = class83.field1439.method228(var9[var7]);
                     if(var46 == null) {
                        var46 = "null";
                     }

                     class36.field787[var6++] = var46;
                     continue;
                  }

                  if(48 == var33) {
                     var10001 = var9[var7];
                     --var6;
                     class83.field1439.method247(var10001, class36.field787[var6]);
                     continue;
                  }
               }

               boolean var49;
               if(var9[var7] == 1) {
                  var49 = true;
               } else {
                  var49 = false;
               }

               class172 var15;
               int var17;
               int var20;
               class172 var40;
               class172 var41;
               boolean var45;
               boolean var73;
               class172 var105;
               if(var33 < 1000) {
                  if(var33 == 100) {
                     var5 -= 3;
                     var53 = class36.field786[var5];
                     var16 = class36.field786[var5 + 1];
                     var17 = class36.field786[var5 + 2];
                     if(var16 == 0) {
                        throw new RuntimeException();
                     }

                     var41 = class48.method1036(var53);
                     if(var41.field2806 == null) {
                        var41.field2806 = new class172[1 + var17];
                     }

                     if(var41.field2806.length <= var17) {
                        class172[] var98 = new class172[1 + var17];

                        for(var20 = 0; var20 < var41.field2806.length; ++var20) {
                           var98[var20] = var41.field2806[var20];
                        }

                        var41.field2806 = var98;
                     }

                     if(var17 > 0 && var41.field2806[var17 - 1] == null) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     class172 var99 = new class172();
                     var99.field2736 = var16;
                     var99.field2742 = (var99.field2734 = var41.field2734) * -1;
                     var99.field2735 = var17;
                     var99.field2733 = true;
                     var41.field2806[var17] = var99;
                     if(var49) {
                        class150.field2244 = var99;
                     } else {
                        class110.field1938 = var99;
                     }

                     class42.method942(var41);
                     continue;
                  }

                  if(101 == var33) {
                     var15 = var49?class150.field2244:class110.field1938;
                     var105 = class48.method1036(var15.field2734 * -1);
                     var105.field2806[var15.field2735] = null;
                     class42.method942(var105);
                     continue;
                  }

                  if(var33 == 102) {
                     --var5;
                     var15 = class48.method1036(class36.field786[var5]);
                     var15.field2806 = null;
                     class42.method942(var15);
                     continue;
                  }

                  if(var33 == 200) {
                     var5 -= 2;
                     var53 = class36.field786[var5];
                     var16 = class36.field786[var5 + 1];
                     var40 = class214.method4009(var53, var16);
                     if(null != var40 && var16 != -1) {
                        class36.field786[var5++] = 1;
                        if(var49) {
                           class150.field2244 = var40;
                        } else {
                           class110.field1938 = var40;
                        }
                        continue;
                     }

                     class36.field786[var5++] = 0;
                     continue;
                  }

                  if(var33 == 201) {
                     --var5;
                     var15 = class48.method1036(class36.field786[var5]);
                     if(var15 != null) {
                        class36.field786[var5++] = 1;
                        if(var49) {
                           class150.field2244 = var15;
                        } else {
                           class110.field1938 = var15;
                        }
                     } else {
                        class36.field786[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var75;
                  if(var33 >= 1000 && var33 < 1100 || var33 >= 2000 && var33 < 2100) {
                     var53 = -1;
                     if(var33 >= 2000) {
                        var33 -= 1000;
                        --var5;
                        var53 = class36.field786[var5];
                        var105 = class48.method1036(var53);
                     } else {
                        var105 = var49?class150.field2244:class110.field1938;
                     }

                     if(var33 == 1000) {
                        var5 -= 4;
                        var105.field2743 = class36.field786[var5];
                        var105.field2792 = class36.field786[1 + var5];
                        var105.field2739 = class36.field786[var5 + 2];
                        var105.field2740 = class36.field786[3 + var5];
                        class42.method942(var105);
                        class15.method194(var105);
                        if(-1 != var53 && var105.field2736 == 0) {
                           class33.method754(class172.field2857[var53 >> 16], var105, false);
                        }
                        continue;
                     }

                     if(var33 == 1001) {
                        var5 -= 4;
                        var105.field2860 = class36.field786[var5];
                        var105.field2746 = class36.field786[var5 + 1];
                        var105.field2741 = class36.field786[2 + var5];
                        var105.field2837 = class36.field786[var5 + 3];
                        class42.method942(var105);
                        class15.method194(var105);
                        if(var53 != -1 && var105.field2736 == 0) {
                           class33.method754(class172.field2857[var53 >> 16], var105, false);
                        }
                        continue;
                     }

                     if(var33 == 1003) {
                        --var5;
                        var75 = class36.field786[var5] == 1;
                        if(var75 != var105.field2724) {
                           var105.field2724 = var75;
                           class42.method942(var105);
                        }
                        continue;
                     }

                     if(var33 == 1005) {
                        --var5;
                        var105.field2865 = class36.field786[var5] == 1;
                        continue;
                     }

                     if(1006 == var33) {
                        --var5;
                        var105.field2747 = class36.field786[var5] == 1;
                        continue;
                     }
                  } else {
                     String var39;
                     if(var33 >= 1100 && var33 < 1200 || var33 >= 2100 && var33 < 2200) {
                        var16 = -1;
                        if(var33 >= 2000) {
                           var33 -= 1000;
                           --var5;
                           var16 = class36.field786[var5];
                           var15 = class48.method1036(var16);
                        } else {
                           var15 = var49?class150.field2244:class110.field1938;
                        }

                        if(1100 == var33) {
                           var5 -= 2;
                           var15.field2755 = class36.field786[var5];
                           if(var15.field2755 > var15.field2856 - var15.field2749) {
                              var15.field2755 = var15.field2856 - var15.field2749;
                           }

                           if(var15.field2755 < 0) {
                              var15.field2755 = 0;
                           }

                           var15.field2762 = class36.field786[var5 + 1];
                           if(var15.field2762 > var15.field2765 - var15.field2750) {
                              var15.field2762 = var15.field2765 - var15.field2750;
                           }

                           if(var15.field2762 < 0) {
                              var15.field2762 = 0;
                           }

                           class42.method942(var15);
                           continue;
                        }

                        if(1101 == var33) {
                           --var5;
                           var15.field2824 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(1102 == var33) {
                           --var5;
                           var15.field2763 = class36.field786[var5] == 1;
                           class42.method942(var15);
                           continue;
                        }

                        if(1103 == var33) {
                           --var5;
                           var15.field2784 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(1104 == var33) {
                           --var5;
                           var15.field2832 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1105) {
                           --var5;
                           var15.field2866 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1106) {
                           --var5;
                           var15.field2769 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1107) {
                           --var5;
                           var15.field2770 = class36.field786[var5] == 1;
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1108) {
                           var15.field2777 = 1;
                           --var5;
                           var15.field2776 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1109) {
                           var5 -= 6;
                           var15.field2781 = class36.field786[var5];
                           var15.field2782 = class36.field786[1 + var5];
                           var15.field2783 = class36.field786[var5 + 2];
                           var15.field2760 = class36.field786[var5 + 3];
                           var15.field2785 = class36.field786[4 + var5];
                           var15.field2787 = class36.field786[5 + var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1110) {
                           --var5;
                           var17 = class36.field786[var5];
                           if(var15.field2802 != var17) {
                              var15.field2802 = var17;
                              var15.field2854 = 0;
                              var15.field2773 = 0;
                              class42.method942(var15);
                           }
                           continue;
                        }

                        if(1111 == var33) {
                           --var5;
                           var15.field2753 = class36.field786[var5] == 1;
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1112) {
                           --var6;
                           var39 = class36.field787[var6];
                           if(!var39.equals(var15.field2756)) {
                              var15.field2756 = var39;
                              class42.method942(var15);
                           }
                           continue;
                        }

                        if(var33 == 1113) {
                           --var5;
                           var15.field2791 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1114) {
                           var5 -= 3;
                           var15.field2795 = class36.field786[var5];
                           var15.field2796 = class36.field786[1 + var5];
                           var15.field2788 = class36.field786[var5 + 2];
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1115) {
                           --var5;
                           var15.field2744 = class36.field786[var5] == 1;
                           class42.method942(var15);
                           continue;
                        }

                        if(1116 == var33) {
                           --var5;
                           var15.field2771 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(1117 == var33) {
                           --var5;
                           var15.field2772 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }

                        if(1118 == var33) {
                           --var5;
                           var15.field2790 = class36.field786[var5] == 1;
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1119) {
                           --var5;
                           var15.field2774 = class36.field786[var5] == 1;
                           class42.method942(var15);
                           continue;
                        }

                        if(1120 == var33) {
                           var5 -= 2;
                           var15.field2856 = class36.field786[var5];
                           var15.field2765 = class36.field786[var5 + 1];
                           class42.method942(var15);
                           if(-1 != var16 && var15.field2736 == 0) {
                              class33.method754(class172.field2857[var16 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var33 == 1121) {
                           class97.method2214(var15.field2734 * -1, var15.field2735);
                           client.field545 = var15;
                           class42.method942(var15);
                           continue;
                        }

                        if(var33 == 1122) {
                           --var5;
                           var15.field2768 = class36.field786[var5];
                           class42.method942(var15);
                           continue;
                        }
                     } else if((var33 < 1200 || var33 >= 1300) && (var33 < 2200 || var33 >= 2300)) {
                        if((var33 < 1300 || var33 >= 1400) && (var33 < 2300 || var33 >= 2400)) {
                           int var19;
                           String var44;
                           int[] var47;
                           if(var33 >= 1400 && var33 < 1500 || var33 >= 2400 && var33 < 2500) {
                              if(var33 >= 2000) {
                                 var33 -= 1000;
                                 --var5;
                                 var15 = class48.method1036(class36.field786[var5]);
                              } else {
                                 var15 = var49?class150.field2244:class110.field1938;
                              }

                              --var6;
                              var44 = class36.field787[var6];
                              var47 = null;
                              if(var44.length() > 0 && var44.charAt(var44.length() - 1) == 89) {
                                 --var5;
                                 var37 = class36.field786[var5];
                                 if(var37 > 0) {
                                    for(var47 = new int[var37]; var37-- > 0; var47[var37] = class36.field786[var5]) {
                                       --var5;
                                    }
                                 }

                                 var44 = var44.substring(0, var44.length() - 1);
                              }

                              Object[] var100 = new Object[var44.length() + 1];

                              for(var19 = var100.length - 1; var19 >= 1; --var19) {
                                 if(var44.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var100[var19] = class36.field787[var6];
                                 } else {
                                    --var5;
                                    var100[var19] = new Integer(class36.field786[var5]);
                                 }
                              }

                              --var5;
                              var19 = class36.field786[var5];
                              if(-1 != var19) {
                                 var100[0] = new Integer(var19);
                              } else {
                                 var100 = null;
                              }

                              if(var33 == 1400) {
                                 var15.field2814 = var100;
                              }

                              if(var33 == 1401) {
                                 var15.field2817 = var100;
                              }

                              if(var33 == 1402) {
                                 var15.field2855 = var100;
                              }

                              if(1403 == var33) {
                                 var15.field2759 = var100;
                              }

                              if(var33 == 1404) {
                                 var15.field2820 = var100;
                              }

                              if(var33 == 1405) {
                                 var15.field2821 = var100;
                              }

                              if(1406 == var33) {
                                 var15.field2816 = var100;
                              }

                              if(var33 == 1407) {
                                 var15.field2825 = var100;
                                 var15.field2826 = var47;
                              }

                              if(var33 == 1408) {
                                 var15.field2831 = var100;
                              }

                              if(1409 == var33) {
                                 var15.field2766 = var100;
                              }

                              if(1410 == var33) {
                                 var15.field2822 = var100;
                              }

                              if(var33 == 1411) {
                                 var15.field2815 = var100;
                              }

                              if(1412 == var33) {
                                 var15.field2798 = var100;
                              }

                              if(1414 == var33) {
                                 var15.field2827 = var100;
                                 var15.field2757 = var47;
                              }

                              if(var33 == 1415) {
                                 var15.field2829 = var100;
                                 var15.field2794 = var47;
                              }

                              if(1416 == var33) {
                                 var15.field2858 = var100;
                              }

                              if(1417 == var33) {
                                 var15.field2807 = var100;
                              }

                              if(1418 == var33) {
                                 var15.field2834 = var100;
                              }

                              if(1419 == var33) {
                                 var15.field2732 = var100;
                              }

                              if(var33 == 1420) {
                                 var15.field2836 = var100;
                              }

                              if(var33 == 1421) {
                                 var15.field2754 = var100;
                              }

                              if(var33 == 1422) {
                                 var15.field2838 = var100;
                              }

                              if(1423 == var33) {
                                 var15.field2835 = var100;
                              }

                              if(1424 == var33) {
                                 var15.field2840 = var100;
                              }

                              if(1425 == var33) {
                                 var15.field2842 = var100;
                              }

                              if(1426 == var33) {
                                 var15.field2843 = var100;
                              }

                              if(var33 == 1427) {
                                 var15.field2841 = var100;
                              }

                              var15.field2812 = true;
                              continue;
                           }

                           if(var33 < 1600) {
                              var15 = var49?class150.field2244:class110.field1938;
                              if(var33 == 1500) {
                                 class36.field786[var5++] = var15.field2846;
                                 continue;
                              }

                              if(var33 == 1501) {
                                 class36.field786[var5++] = var15.field2748;
                                 continue;
                              }

                              if(var33 == 1502) {
                                 class36.field786[var5++] = var15.field2749;
                                 continue;
                              }

                              if(1503 == var33) {
                                 class36.field786[var5++] = var15.field2750;
                                 continue;
                              }

                              if(var33 == 1504) {
                                 class36.field786[var5++] = var15.field2724?1:0;
                                 continue;
                              }

                              if(var33 == 1505) {
                                 class36.field786[var5++] = var15.field2742;
                                 continue;
                              }
                           } else if(var33 < 1700) {
                              var15 = var49?class150.field2244:class110.field1938;
                              if(var33 == 1600) {
                                 class36.field786[var5++] = var15.field2755;
                                 continue;
                              }

                              if(1601 == var33) {
                                 class36.field786[var5++] = var15.field2762;
                                 continue;
                              }

                              if(1602 == var33) {
                                 class36.field787[var6++] = var15.field2756;
                                 continue;
                              }

                              if(var33 == 1603) {
                                 class36.field786[var5++] = var15.field2856;
                                 continue;
                              }

                              if(1604 == var33) {
                                 class36.field786[var5++] = var15.field2765;
                                 continue;
                              }

                              if(1605 == var33) {
                                 class36.field786[var5++] = var15.field2787;
                                 continue;
                              }

                              if(1606 == var33) {
                                 class36.field786[var5++] = var15.field2783;
                                 continue;
                              }

                              if(1607 == var33) {
                                 class36.field786[var5++] = var15.field2785;
                                 continue;
                              }

                              if(1608 == var33) {
                                 class36.field786[var5++] = var15.field2760;
                                 continue;
                              }

                              if(1609 == var33) {
                                 class36.field786[var5++] = var15.field2784;
                                 continue;
                              }
                           } else if(var33 < 1800) {
                              var15 = var49?class150.field2244:class110.field1938;
                              if(var33 == 1700) {
                                 class36.field786[var5++] = var15.field2852;
                                 continue;
                              }

                              if(1701 == var33) {
                                 if(-1 != var15.field2852) {
                                    class36.field786[var5++] = var15.field2853;
                                 } else {
                                    class36.field786[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(1702 == var33) {
                                 class36.field786[var5++] = var15.field2735;
                                 continue;
                              }
                           } else if(var33 < 1900) {
                              var15 = var49?class150.field2244:class110.field1938;
                              if(1800 == var33) {
                                 var35 = class36.field786;
                                 var17 = var5++;
                                 var19 = class7.method126(var15);
                                 var37 = var19 >> 11 & 63;
                                 var35[var17] = var37;
                                 continue;
                              }

                              if(var33 == 1801) {
                                 --var5;
                                 var16 = class36.field786[var5];
                                 --var16;
                                 if(null != var15.field2786 && var16 < var15.field2786.length && null != var15.field2786[var16]) {
                                    class36.field787[var6++] = var15.field2786[var16];
                                    continue;
                                 }

                                 class36.field787[var6++] = "";
                                 continue;
                              }

                              if(1802 == var33) {
                                 if(var15.field2805 == null) {
                                    class36.field787[var6++] = "";
                                 } else {
                                    class36.field787[var6++] = var15.field2805;
                                 }
                                 continue;
                              }
                           } else if((var33 < 1900 || var33 >= 2000) && (var33 < 2900 || var33 >= 3000)) {
                              if(var33 < 2600) {
                                 --var5;
                                 var15 = class48.method1036(class36.field786[var5]);
                                 if(var33 == 2500) {
                                    class36.field786[var5++] = var15.field2846;
                                    continue;
                                 }

                                 if(var33 == 2501) {
                                    class36.field786[var5++] = var15.field2748;
                                    continue;
                                 }

                                 if(2502 == var33) {
                                    class36.field786[var5++] = var15.field2749;
                                    continue;
                                 }

                                 if(var33 == 2503) {
                                    class36.field786[var5++] = var15.field2750;
                                    continue;
                                 }

                                 if(var33 == 2504) {
                                    class36.field786[var5++] = var15.field2724?1:0;
                                    continue;
                                 }

                                 if(2505 == var33) {
                                    class36.field786[var5++] = var15.field2742;
                                    continue;
                                 }
                              } else if(var33 < 2700) {
                                 --var5;
                                 var15 = class48.method1036(class36.field786[var5]);
                                 if(var33 == 2600) {
                                    class36.field786[var5++] = var15.field2755;
                                    continue;
                                 }

                                 if(var33 == 2601) {
                                    class36.field786[var5++] = var15.field2762;
                                    continue;
                                 }

                                 if(2602 == var33) {
                                    class36.field787[var6++] = var15.field2756;
                                    continue;
                                 }

                                 if(var33 == 2603) {
                                    class36.field786[var5++] = var15.field2856;
                                    continue;
                                 }

                                 if(var33 == 2604) {
                                    class36.field786[var5++] = var15.field2765;
                                    continue;
                                 }

                                 if(var33 == 2605) {
                                    class36.field786[var5++] = var15.field2787;
                                    continue;
                                 }

                                 if(var33 == 2606) {
                                    class36.field786[var5++] = var15.field2783;
                                    continue;
                                 }

                                 if(var33 == 2607) {
                                    class36.field786[var5++] = var15.field2785;
                                    continue;
                                 }

                                 if(var33 == 2608) {
                                    class36.field786[var5++] = var15.field2760;
                                    continue;
                                 }

                                 if(2609 == var33) {
                                    class36.field786[var5++] = var15.field2784;
                                    continue;
                                 }
                              } else if(var33 < 2800) {
                                 if(var33 == 2700) {
                                    --var5;
                                    var15 = class48.method1036(class36.field786[var5]);
                                    class36.field786[var5++] = var15.field2852;
                                    continue;
                                 }

                                 if(2701 == var33) {
                                    --var5;
                                    var15 = class48.method1036(class36.field786[var5]);
                                    if(var15.field2852 != -1) {
                                       class36.field786[var5++] = var15.field2853;
                                    } else {
                                       class36.field786[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var33 == 2702) {
                                    --var5;
                                    var53 = class36.field786[var5];
                                    class3 var38 = (class3)client.field304.method3836((long)var53);
                                    if(var38 != null) {
                                       class36.field786[var5++] = 1;
                                    } else {
                                       class36.field786[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var33 == 2706) {
                                    class36.field786[var5++] = client.field438;
                                    continue;
                                 }
                              } else if(var33 < 2900) {
                                 --var5;
                                 var15 = class48.method1036(class36.field786[var5]);
                                 if(var33 == 2800) {
                                    var35 = class36.field786;
                                    var17 = var5++;
                                    var19 = class7.method126(var15);
                                    var37 = var19 >> 11 & 63;
                                    var35[var17] = var37;
                                    continue;
                                 }

                                 if(var33 == 2801) {
                                    --var5;
                                    var16 = class36.field786[var5];
                                    --var16;
                                    if(null != var15.field2786 && var16 < var15.field2786.length && var15.field2786[var16] != null) {
                                       class36.field787[var6++] = var15.field2786[var16];
                                       continue;
                                    }

                                    class36.field787[var6++] = "";
                                    continue;
                                 }

                                 if(2802 == var33) {
                                    if(null == var15.field2805) {
                                       class36.field787[var6++] = "";
                                    } else {
                                       class36.field787[var6++] = var15.field2805;
                                    }
                                    continue;
                                 }
                              } else if(var33 < 3200) {
                                 if(3100 == var33) {
                                    --var6;
                                    var62 = class36.field787[var6];
                                    class50.method1063(0, "", var62);
                                    continue;
                                 }

                                 if(var33 == 3101) {
                                    var5 -= 2;
                                    class172.method3500(class0.field12, class36.field786[var5], class36.field786[var5 + 1]);
                                    continue;
                                 }

                                 if(3103 == var33) {
                                    class20.method596();
                                    continue;
                                 }

                                 if(3104 == var33) {
                                    --var6;
                                    var62 = class36.field787[var6];
                                    var16 = 0;
                                    if(class18.method222(var62)) {
                                       var17 = client.method585(var62, 10);
                                       var16 = var17;
                                    }

                                    client.field318.method2785(9);
                                    client.field318.method2524(var16);
                                    continue;
                                 }

                                 if(var33 == 3105) {
                                    --var6;
                                    var62 = class36.field787[var6];
                                    client.field318.method2785(106);
                                    client.field318.method2521(var62.length() + 1);
                                    client.field318.method2527(var62);
                                    continue;
                                 }

                                 if(var33 == 3106) {
                                    --var6;
                                    var62 = class36.field787[var6];
                                    client.field318.method2785(177);
                                    client.field318.method2521(var62.length() + 1);
                                    client.field318.method2527(var62);
                                    continue;
                                 }

                                 if(var33 == 3107) {
                                    --var5;
                                    var53 = class36.field786[var5];
                                    --var6;
                                    var44 = class36.field787[var6];
                                    var17 = class32.field733;
                                    int[] var42 = class32.field730;
                                    boolean var43 = false;

                                    for(var20 = 0; var20 < var17; ++var20) {
                                       class2 var21 = client.field397[var42[var20]];
                                       if(var21 != null && var21 != class0.field12 && var21.field34 != null && var21.field34.equalsIgnoreCase(var44)) {
                                          if(var53 == 1) {
                                             client.field318.method2785(91);
                                             client.field318.method2558(0);
                                             client.field318.method2567(var42[var20]);
                                          } else if(var53 == 4) {
                                             client.field318.method2785(67);
                                             client.field318.method2632(0);
                                             client.field318.method2567(var42[var20]);
                                          } else if(var53 == 6) {
                                             client.field318.method2785(62);
                                             client.field318.method2522(var42[var20]);
                                             client.field318.method2521(0);
                                          } else if(var53 == 7) {
                                             client.field318.method2785(55);
                                             client.field318.method2558(0);
                                             client.field318.method2567(var42[var20]);
                                          }

                                          var43 = true;
                                          break;
                                       }
                                    }

                                    if(!var43) {
                                       class50.method1063(4, "", "Unable to find " + var44);
                                    }
                                    continue;
                                 }

                                 if(var33 == 3108) {
                                    var5 -= 3;
                                    var53 = class36.field786[var5];
                                    var16 = class36.field786[var5 + 1];
                                    var17 = class36.field786[2 + var5];
                                    var41 = class48.method1036(var17);
                                    class23.method625(var41, var53, var16);
                                    continue;
                                 }

                                 if(3109 == var33) {
                                    var5 -= 2;
                                    var53 = class36.field786[var5];
                                    var16 = class36.field786[var5 + 1];
                                    var40 = var49?class150.field2244:class110.field1938;
                                    class23.method625(var40, var53, var16);
                                    continue;
                                 }

                                 if(3110 == var33) {
                                    --var5;
                                    class33.field752 = class36.field786[var5] == 1;
                                    continue;
                                 }

                                 if(3111 == var33) {
                                    class36.field786[var5++] = class153.field2277.field142?1:0;
                                    continue;
                                 }

                                 if(var33 == 3112) {
                                    --var5;
                                    class153.field2277.field142 = class36.field786[var5] == 1;
                                    class125.method2852();
                                    continue;
                                 }

                                 if(3113 == var33) {
                                    --var6;
                                    var62 = class36.field787[var6];
                                    --var5;
                                    var45 = class36.field786[var5] == 1;
                                    class158.method3209(var62, var45);
                                    continue;
                                 }

                                 if(var33 == 3115) {
                                    --var5;
                                    var53 = class36.field786[var5];
                                    client.field318.method2785(184);
                                    client.field318.method2522(var53);
                                    continue;
                                 }

                                 if(var33 == 3116) {
                                    --var5;
                                    var53 = class36.field786[var5];
                                    var6 -= 2;
                                    var44 = class36.field787[var6];
                                    var39 = class36.field787[var6 + 1];
                                    if(var44.length() <= 500 && var39.length() <= 500) {
                                       client.field318.method2785(63);
                                       client.field318.method2522(1 + class102.method2318(var44) + class102.method2318(var39));
                                       client.field318.method2527(var39);
                                       client.field318.method2558(var53);
                                       client.field318.method2527(var44);
                                    }
                                    continue;
                                 }
                              } else if(var33 < 3300) {
                                 if(3200 == var33) {
                                    var5 -= 3;
                                    class38.method805(class36.field786[var5], class36.field786[var5 + 1], class36.field786[2 + var5]);
                                    continue;
                                 }

                                 if(var33 == 3201) {
                                    --var5;
                                    var53 = class36.field786[var5];
                                    if(-1 == var53 && !client.field513) {
                                       class182.field2943.method3658();
                                       class182.field2940 = 1;
                                       class188.field3038 = null;
                                    } else if(-1 != var53 && var53 != client.field512 && client.field543 != 0 && !client.field513) {
                                       class167 var55 = class142.field2165;
                                       var17 = client.field543;
                                       class182.field2940 = 1;
                                       class188.field3038 = var55;
                                       class182.field2945 = var53;
                                       class35.field778 = 0;
                                       class182.field2942 = var17;
                                       class158.field2586 = false;
                                       class173.field2874 = 2;
                                    }

                                    client.field512 = var53;
                                    continue;
                                 }

                                 if(3202 == var33) {
                                    var5 -= 2;
                                    var53 = class36.field786[var5];
                                    int var10000 = class36.field786[1 + var5];
                                    if(client.field543 != 0 && -1 != var53) {
                                       class41.method903(class118.field1985, var53, 0, client.field543, false);
                                       client.field513 = true;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 int var51;
                                 if(var33 < 3400) {
                                    if(3300 == var33) {
                                       class36.field786[var5++] = client.field286;
                                       continue;
                                    }

                                    if(3301 == var33) {
                                       var5 -= 2;
                                       var53 = class36.field786[var5];
                                       var16 = class36.field786[1 + var5];
                                       class36.field786[var5++] = class47.method1025(var53, var16);
                                       continue;
                                    }

                                    class15 var48;
                                    if(3302 == var33) {
                                       var5 -= 2;
                                       var53 = class36.field786[var5];
                                       var16 = class36.field786[1 + var5];
                                       var47 = class36.field786;
                                       var37 = var5++;
                                       var48 = (class15)class15.field216.method3836((long)var53);
                                       if(var48 == null) {
                                          var19 = 0;
                                       } else if(var16 >= 0 && var16 < var48.field214.length) {
                                          var19 = var48.field214[var16];
                                       } else {
                                          var19 = 0;
                                       }

                                       var47[var37] = var19;
                                       continue;
                                    }

                                    if(var33 == 3303) {
                                       var5 -= 2;
                                       var53 = class36.field786[var5];
                                       var16 = class36.field786[1 + var5];
                                       var47 = class36.field786;
                                       var37 = var5++;
                                       var48 = (class15)class15.field216.method3836((long)var53);
                                       if(null == var48) {
                                          var19 = 0;
                                       } else if(var16 == -1) {
                                          var19 = 0;
                                       } else {
                                          var51 = 0;

                                          for(var22 = 0; var22 < var48.field214.length; ++var22) {
                                             if(var16 == var48.field217[var22]) {
                                                var51 += var48.field214[var22];
                                             }
                                          }

                                          var19 = var51;
                                       }

                                       var47[var37] = var19;
                                       continue;
                                    }

                                    if(var33 == 3304) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = class180.method3581(var53).field1079;
                                       continue;
                                    }

                                    if(3305 == var33) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = client.field411[var53];
                                       continue;
                                    }

                                    if(var33 == 3306) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = client.field412[var53];
                                       continue;
                                    }

                                    if(var33 == 3307) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = client.field347[var53];
                                       continue;
                                    }

                                    if(var33 == 3308) {
                                       var53 = class8.field134;
                                       var16 = class47.field1053 + (class0.field12.field846 >> 7);
                                       var17 = class161.field2629 + (class0.field12.field834 >> 7);
                                       class36.field786[var5++] = (var16 << 14) + (var53 << 28) + var17;
                                       continue;
                                    }

                                    if(var33 == 3309) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = var53 >> 14 & 16383;
                                       continue;
                                    }

                                    if(3310 == var33) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = var53 >> 28;
                                       continue;
                                    }

                                    if(var33 == 3311) {
                                       --var5;
                                       var53 = class36.field786[var5];
                                       class36.field786[var5++] = var53 & 16383;
                                       continue;
                                    }

                                    if(var33 == 3312) {
                                       class36.field786[var5++] = client.field281?1:0;
                                       continue;
                                    }

                                    if(var33 == 3313) {
                                       var5 -= 2;
                                       var53 = '耀' + class36.field786[var5];
                                       var16 = class36.field786[1 + var5];
                                       class36.field786[var5++] = class47.method1025(var53, var16);
                                       continue;
                                    }

                                    if(3314 == var33) {
                                       var5 -= 2;
                                       var53 = class36.field786[var5] + '耀';
                                       var16 = class36.field786[1 + var5];
                                       var47 = class36.field786;
                                       var37 = var5++;
                                       var48 = (class15)class15.field216.method3836((long)var53);
                                       if(var48 == null) {
                                          var19 = 0;
                                       } else if(var16 >= 0 && var16 < var48.field214.length) {
                                          var19 = var48.field214[var16];
                                       } else {
                                          var19 = 0;
                                       }

                                       var47[var37] = var19;
                                       continue;
                                    }

                                    if(var33 == 3315) {
                                       var5 -= 2;
                                       var53 = '耀' + class36.field786[var5];
                                       var16 = class36.field786[1 + var5];
                                       var47 = class36.field786;
                                       var37 = var5++;
                                       var48 = (class15)class15.field216.method3836((long)var53);
                                       if(null == var48) {
                                          var19 = 0;
                                       } else if(-1 == var16) {
                                          var19 = 0;
                                       } else {
                                          var51 = 0;

                                          for(var22 = 0; var22 < var48.field214.length; ++var22) {
                                             if(var16 == var48.field217[var22]) {
                                                var51 += var48.field214[var22];
                                             }
                                          }

                                          var19 = var51;
                                       }

                                       var47[var37] = var19;
                                       continue;
                                    }

                                    if(var33 == 3316) {
                                       if(client.field441 >= 2) {
                                          class36.field786[var5++] = client.field441;
                                       } else {
                                          class36.field786[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(3317 == var33) {
                                       class36.field786[var5++] = client.field486;
                                       continue;
                                    }

                                    if(3318 == var33) {
                                       class36.field786[var5++] = client.field421;
                                       continue;
                                    }

                                    if(3321 == var33) {
                                       class36.field786[var5++] = client.field439;
                                       continue;
                                    }

                                    if(var33 == 3322) {
                                       class36.field786[var5++] = client.field431;
                                       continue;
                                    }

                                    if(3323 == var33) {
                                       if(client.field383) {
                                          class36.field786[var5++] = 1;
                                       } else {
                                          class36.field786[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var33 == 3324) {
                                       class36.field786[var5++] = client.field277;
                                       continue;
                                    }
                                 } else if(var33 < 3500) {
                                    if(var33 == 3400) {
                                       var5 -= 2;
                                       var53 = class36.field786[var5];
                                       var16 = class36.field786[var5 + 1];
                                       class48 var50 = (class48)class48.field1068.method3808((long)var53);
                                       class48 var54;
                                       if(var50 != null) {
                                          var54 = var50;
                                       } else {
                                          byte[] var72 = class48.field1069.method3352(8, var53);
                                          var50 = new class48();
                                          if(null != var72) {
                                             var50.method1028(new class118(var72));
                                          }

                                          class48.field1068.method3805(var50, (long)var53);
                                          var54 = var50;
                                       }

                                       var50 = var54;
                                       if(var54.field1062 != 115) {
                                          ;
                                       }

                                       for(var19 = 0; var19 < var50.field1065; ++var19) {
                                          if(var50.field1059[var19] == var16) {
                                             class36.field787[var6++] = var50.field1060[var19];
                                             var50 = null;
                                             break;
                                          }
                                       }

                                       if(null != var50) {
                                          class36.field787[var6++] = var50.field1064;
                                       }
                                       continue;
                                    }

                                    if(3408 == var33) {
                                       var5 -= 4;
                                       var53 = class36.field786[var5];
                                       var16 = class36.field786[1 + var5];
                                       var17 = class36.field786[2 + var5];
                                       var37 = class36.field786[3 + var5];
                                       class48 var52 = (class48)class48.field1068.method3808((long)var17);
                                       class48 var67;
                                       if(var52 != null) {
                                          var67 = var52;
                                       } else {
                                          byte[] var56 = class48.field1069.method3352(8, var17);
                                          var52 = new class48();
                                          if(var56 != null) {
                                             var52.method1028(new class118(var56));
                                          }

                                          class48.field1068.method3805(var52, (long)var17);
                                          var67 = var52;
                                       }

                                       var52 = var67;
                                       if(var53 == var67.field1061 && var67.field1062 == var16) {
                                          for(var51 = 0; var51 < var52.field1065; ++var51) {
                                             if(var37 == var52.field1059[var51]) {
                                                if(var16 == 115) {
                                                   class36.field787[var6++] = var52.field1060[var51];
                                                } else {
                                                   class36.field786[var5++] = var52.field1067[var51];
                                                }

                                                var52 = null;
                                                break;
                                             }
                                          }

                                          if(null != var52) {
                                             if(var16 == 115) {
                                                class36.field787[var6++] = var52.field1064;
                                             } else {
                                                class36.field786[var5++] = var52.field1066;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var16 == 115) {
                                          class36.field787[var6++] = "null";
                                       } else {
                                          class36.field786[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    String var57;
                                    String var77;
                                    if(var33 < 3700) {
                                       if(var33 == 3600) {
                                          if(client.field542 == 0) {
                                             class36.field786[var5++] = -2;
                                          } else if(client.field542 == 1) {
                                             class36.field786[var5++] = -1;
                                          } else {
                                             class36.field786[var5++] = client.field541;
                                          }
                                          continue;
                                       }

                                       if(var33 == 3601) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(client.field542 == 2 && var53 < client.field541) {
                                             class36.field787[var6++] = client.field410[var53].field237;
                                             class36.field787[var6++] = client.field410[var53].field241;
                                             continue;
                                          }

                                          class36.field787[var6++] = "";
                                          class36.field787[var6++] = "";
                                          continue;
                                       }

                                       if(var33 == 3602) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(2 == client.field542 && var53 < client.field541) {
                                             class36.field786[var5++] = client.field410[var53].field238;
                                             continue;
                                          }

                                          class36.field786[var5++] = 0;
                                          continue;
                                       }

                                       if(3603 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(2 == client.field542 && var53 < client.field541) {
                                             class36.field786[var5++] = client.field410[var53].field239;
                                             continue;
                                          }

                                          class36.field786[var5++] = 0;
                                          continue;
                                       }

                                       if(var33 == 3604) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          client.field318.method2785(208);
                                          client.field318.method2521(class102.method2318(var62) + 1);
                                          client.field318.method2527(var62);
                                          client.field318.method2667(var16);
                                          continue;
                                       }

                                       String var60;
                                       class7 var63;
                                       class17 var64;
                                       if(3605 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(var62 == null) {
                                             continue;
                                          }

                                          if((client.field541 < 200 || 1 == client.field351) && client.field541 < 400) {
                                             var44 = class140.method3010(var62, client.field280);
                                             if(null == var44) {
                                                continue;
                                             }

                                             for(var17 = 0; var17 < client.field541; ++var17) {
                                                var64 = client.field410[var17];
                                                var77 = class140.method3010(var64.field237, client.field280);
                                                if(var77 != null && var77.equals(var44)) {
                                                   class50.method1063(30, "", var62 + " is already on your friend list");
                                                   continue label3711;
                                                }

                                                if(var64.field241 != null) {
                                                   var60 = class140.method3010(var64.field241, client.field280);
                                                   if(null != var60 && var60.equals(var44)) {
                                                      class50.method1063(30, "", var62 + " is already on your friend list");
                                                      continue label3711;
                                                   }
                                                }
                                             }

                                             for(var17 = 0; var17 < client.field354; ++var17) {
                                                var63 = client.field445[var17];
                                                var77 = class140.method3010(var63.field130, client.field280);
                                                if(var77 != null && var77.equals(var44)) {
                                                   class50.method1063(30, "", "Please remove " + var62 + " from your ignore list first");
                                                   continue label3711;
                                                }

                                                if(var63.field126 != null) {
                                                   var60 = class140.method3010(var63.field126, client.field280);
                                                   if(var60 != null && var60.equals(var44)) {
                                                      class50.method1063(30, "", "Please remove " + var62 + " from your ignore list first");
                                                      continue label3711;
                                                   }
                                                }
                                             }

                                             if(class140.method3010(class0.field12.field34, client.field280).equals(var44)) {
                                                class50.method1063(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                client.field318.method2785(181);
                                                client.field318.method2521(class102.method2318(var62));
                                                client.field318.method2527(var62);
                                             }
                                             continue;
                                          }

                                          class50.method1063(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(3606 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(var62 == null) {
                                             continue;
                                          }

                                          var44 = class140.method3010(var62, client.field280);
                                          if(null == var44) {
                                             continue;
                                          }

                                          var17 = 0;

                                          while(true) {
                                             if(var17 >= client.field541) {
                                                continue label3711;
                                             }

                                             var64 = client.field410[var17];
                                             var77 = var64.field237;
                                             var60 = class140.method3010(var77, client.field280);
                                             if(class47.method1024(var62, var44, var77, var60)) {
                                                --client.field541;

                                                for(var51 = var17; var51 < client.field541; ++var51) {
                                                   client.field410[var51] = client.field410[var51 + 1];
                                                }

                                                client.field458 = client.field459;
                                                client.field318.method2785(89);
                                                client.field318.method2521(class102.method2318(var62));
                                                client.field318.method2527(var62);
                                                continue label3711;
                                             }

                                             ++var17;
                                          }
                                       }

                                       if(var33 == 3607) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(var62 == null) {
                                             continue;
                                          }

                                          if((client.field354 < 100 || client.field351 == 1) && client.field354 < 400) {
                                             var44 = class140.method3010(var62, client.field280);
                                             if(var44 == null) {
                                                continue;
                                             }

                                             for(var17 = 0; var17 < client.field354; ++var17) {
                                                var63 = client.field445[var17];
                                                var77 = class140.method3010(var63.field130, client.field280);
                                                if(var77 != null && var77.equals(var44)) {
                                                   class50.method1063(31, "", var62 + " is already on your ignore list");
                                                   continue label3711;
                                                }

                                                if(null != var63.field126) {
                                                   var60 = class140.method3010(var63.field126, client.field280);
                                                   if(var60 != null && var60.equals(var44)) {
                                                      class50.method1063(31, "", var62 + " is already on your ignore list");
                                                      continue label3711;
                                                   }
                                                }
                                             }

                                             for(var17 = 0; var17 < client.field541; ++var17) {
                                                var64 = client.field410[var17];
                                                var77 = class140.method3010(var64.field237, client.field280);
                                                if(var77 != null && var77.equals(var44)) {
                                                   class50.method1063(31, "", "Please remove " + var62 + " from your friend list first");
                                                   continue label3711;
                                                }

                                                if(var64.field241 != null) {
                                                   var60 = class140.method3010(var64.field241, client.field280);
                                                   if(null != var60 && var60.equals(var44)) {
                                                      class50.method1063(31, "", "Please remove " + var62 + " from your friend list first");
                                                      continue label3711;
                                                   }
                                                }
                                             }

                                             if(class140.method3010(class0.field12.field34, client.field280).equals(var44)) {
                                                class50.method1063(31, "", "You can\'t add yourself to your own ignore list");
                                             } else {
                                                client.field318.method2785(25);
                                                client.field318.method2521(class102.method2318(var62));
                                                client.field318.method2527(var62);
                                             }
                                             continue;
                                          }

                                          class50.method1063(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var33 == 3608) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          class37.method800(var62);
                                          continue;
                                       }

                                       if(3609 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          class151[] var68 = new class151[]{class151.field2253, class151.field2249, class151.field2252, class151.field2250, class151.field2251};
                                          class151[] var58 = var68;

                                          for(var37 = 0; var37 < var58.length; ++var37) {
                                             class151 var82 = var58[var37];
                                             if(-1 != var82.field2255 && var62.startsWith(class19.method265(var82.field2255))) {
                                                var62 = var62.substring(6 + Integer.toString(var82.field2255).length());
                                                break;
                                             }
                                          }

                                          class36.field786[var5++] = class8.method138(var62, false)?1:0;
                                          continue;
                                       }

                                       String[] var87;
                                       if(3611 == var33) {
                                          if(client.field501 != null) {
                                             var87 = class36.field787;
                                             var16 = var6++;
                                             var57 = client.field501;
                                             var77 = class16.method211(class21.method610(var57));
                                             if(var77 == null) {
                                                var77 = "";
                                             }

                                             var87[var16] = var77;
                                          } else {
                                             class36.field787[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var33 == 3612) {
                                          if(null != client.field501) {
                                             class36.field786[var5++] = class41.field964;
                                          } else {
                                             class36.field786[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var33 == 3613) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(client.field501 != null && var53 < class41.field964) {
                                             class36.field787[var6++] = class98.field1667[var53].field604;
                                             continue;
                                          }

                                          class36.field787[var6++] = "";
                                          continue;
                                       }

                                       if(var33 == 3614) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(null != client.field501 && var53 < class41.field964) {
                                             class36.field786[var5++] = class98.field1667[var53].field606;
                                             continue;
                                          }

                                          class36.field786[var5++] = 0;
                                          continue;
                                       }

                                       if(var33 == 3615) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(client.field501 != null && var53 < class41.field964) {
                                             class36.field786[var5++] = class98.field1667[var53].field607;
                                             continue;
                                          }

                                          class36.field786[var5++] = 0;
                                          continue;
                                       }

                                       if(3616 == var33) {
                                          class36.field786[var5++] = class5.field91;
                                          continue;
                                       }

                                       if(3617 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(null != class98.field1667) {
                                             client.field318.method2785(215);
                                             client.field318.method2521(class102.method2318(var62));
                                             client.field318.method2527(var62);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3618) {
                                          class36.field786[var5++] = class139.field2137;
                                          continue;
                                       }

                                       if(3619 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(!var62.equals("")) {
                                             client.field318.method2785(255);
                                             client.field318.method2521(class102.method2318(var62));
                                             client.field318.method2527(var62);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3620) {
                                          client.field318.method2785(255);
                                          client.field318.method2521(0);
                                          continue;
                                       }

                                       if(var33 == 3621) {
                                          if(client.field542 == 0) {
                                             class36.field786[var5++] = -1;
                                          } else {
                                             class36.field786[var5++] = client.field354;
                                          }
                                          continue;
                                       }

                                       if(var33 == 3622) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(client.field542 != 0 && var53 < client.field354) {
                                             class36.field787[var6++] = client.field445[var53].field130;
                                             class36.field787[var6++] = client.field445[var53].field126;
                                             continue;
                                          }

                                          class36.field787[var6++] = "";
                                          class36.field787[var6++] = "";
                                          continue;
                                       }

                                       if(3623 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(var62.startsWith(class19.method265(0)) || var62.startsWith(class19.method265(1))) {
                                             var62 = var62.substring(7);
                                          }

                                          class36.field786[var5++] = class40.method881(var62)?1:0;
                                          continue;
                                       }

                                       if(3624 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          if(class98.field1667 != null && var53 < class41.field964 && class98.field1667[var53].field604.equalsIgnoreCase(class0.field12.field34)) {
                                             class36.field786[var5++] = 1;
                                             continue;
                                          }

                                          class36.field786[var5++] = 0;
                                          continue;
                                       }

                                       if(3625 == var33) {
                                          if(client.field295 != null) {
                                             var87 = class36.field787;
                                             var16 = var6++;
                                             var57 = client.field295;
                                             var77 = class16.method211(class21.method610(var57));
                                             if(var77 == null) {
                                                var77 = "";
                                             }

                                             var87[var16] = var77;
                                          } else {
                                             class36.field787[var6++] = "";
                                          }
                                          continue;
                                       }
                                    } else if(var33 < 4000) {
                                       if(var33 == 3903) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = client.field499[var53].method4044();
                                          continue;
                                       }

                                       if(var33 == 3904) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = client.field499[var53].field3150;
                                          continue;
                                       }

                                       if(3905 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = client.field499[var53].field3151;
                                          continue;
                                       }

                                       if(var33 == 3906) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = client.field499[var53].field3152;
                                          continue;
                                       }

                                       if(3907 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = client.field499[var53].field3153;
                                          continue;
                                       }

                                       if(3908 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = client.field499[var53].field3154;
                                          continue;
                                       }

                                       if(var33 == 3910) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var16 = client.field499[var53].method4043();
                                          class36.field786[var5++] = 0 == var16?1:0;
                                          continue;
                                       }

                                       if(3911 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var16 = client.field499[var53].method4043();
                                          class36.field786[var5++] = var16 == 2?1:0;
                                          continue;
                                       }

                                       if(var33 == 3912) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var16 = client.field499[var53].method4043();
                                          class36.field786[var5++] = var16 == 5?1:0;
                                          continue;
                                       }

                                       if(3913 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var16 = client.field499[var53].method4043();
                                          class36.field786[var5++] = 1 == var16?1:0;
                                          continue;
                                       }

                                       boolean var103;
                                       if(3914 == var33) {
                                          --var5;
                                          var103 = class36.field786[var5] == 1;
                                          if(class143.field2193 != null) {
                                             class143.field2193.method4057(class220.field3158, var103);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3915) {
                                          --var5;
                                          var103 = class36.field786[var5] == 1;
                                          if(class143.field2193 != null) {
                                             class143.field2193.method4057(class220.field3157, var103);
                                          }
                                          continue;
                                       }

                                       if(var33 == 3916) {
                                          var5 -= 2;
                                          var103 = 1 == class36.field786[var5];
                                          var45 = 1 == class36.field786[var5 + 1];
                                          if(null != class143.field2193) {
                                             class143.field2193.method4057(new class21(var45), var103);
                                          }
                                          continue;
                                       }

                                       if(3917 == var33) {
                                          --var5;
                                          var103 = class36.field786[var5] == 1;
                                          if(null != class143.field2193) {
                                             class143.field2193.method4057(class220.field3160, var103);
                                          }
                                          continue;
                                       }

                                       if(3918 == var33) {
                                          --var5;
                                          var103 = class36.field786[var5] == 1;
                                          if(class143.field2193 != null) {
                                             class143.field2193.method4057(class220.field3161, var103);
                                          }
                                          continue;
                                       }

                                       if(3919 == var33) {
                                          class36.field786[var5++] = null == class143.field2193?0:class143.field2193.field3159.size();
                                          continue;
                                       }

                                       class213 var76;
                                       if(var33 == 3920) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          class36.field786[var5++] = var76.field3134;
                                          continue;
                                       }

                                       if(3921 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          class36.field787[var6++] = var76.method4006();
                                          continue;
                                       }

                                       if(var33 == 3922) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          class36.field787[var6++] = var76.method4008();
                                          continue;
                                       }

                                       if(3923 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          long var74 = class92.method2177() - class34.field759 - var76.field3136;
                                          var19 = (int)(var74 / 3600000L);
                                          var20 = (int)((var74 - (long)(var19 * 3600000)) / 60000L);
                                          var51 = (int)((var74 - (long)(3600000 * var19) - (long)('\uea60' * var20)) / 1000L);
                                          String var59 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var51 / 10 + var51 % 10;
                                          class36.field787[var6++] = var59;
                                          continue;
                                       }

                                       if(3924 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          class36.field786[var5++] = var76.field3135.field3152;
                                          continue;
                                       }

                                       if(3925 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          class36.field786[var5++] = var76.field3135.field3151;
                                          continue;
                                       }

                                       if(var33 == 3926) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var76 = (class213)class143.field2193.field3159.get(var53);
                                          class36.field786[var5++] = var76.field3135.field3150;
                                          continue;
                                       }
                                    } else if(var33 < 4100) {
                                       if(var33 == 4000) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var53 + var16;
                                          continue;
                                       }

                                       if(4001 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var53 - var16;
                                          continue;
                                       }

                                       if(var33 == 4002) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var53 * var16;
                                          continue;
                                       }

                                       if(var33 == 4003) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[1 + var5];
                                          class36.field786[var5++] = var53 / var16;
                                          continue;
                                       }

                                       if(4004 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = (int)(Math.random() * (double)var53);
                                          continue;
                                       }

                                       if(4005 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = (int)(Math.random() * (double)(var53 + 1));
                                          continue;
                                       }

                                       if(4006 == var33) {
                                          var5 -= 5;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          var17 = class36.field786[var5 + 2];
                                          var37 = class36.field786[3 + var5];
                                          var19 = class36.field786[4 + var5];
                                          class36.field786[var5++] = var53 + (var19 - var17) * (var16 - var53) / (var37 - var17);
                                          continue;
                                       }

                                       if(var33 == 4007) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var16 * var53 / 100 + var53;
                                          continue;
                                       }

                                       if(4008 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[1 + var5];
                                          class36.field786[var5++] = var53 | 1 << var16;
                                          continue;
                                       }

                                       if(var33 == 4009) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var53 & -1 - (1 << var16);
                                          continue;
                                       }

                                       if(4010 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[1 + var5];
                                          class36.field786[var5++] = (var53 & 1 << var16) != 0?1:0;
                                          continue;
                                       }

                                       if(4011 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[1 + var5];
                                          class36.field786[var5++] = var53 % var16;
                                          continue;
                                       }

                                       if(4012 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[1 + var5];
                                          if(0 == var53) {
                                             class36.field786[var5++] = 0;
                                          } else {
                                             class36.field786[var5++] = (int)Math.pow((double)var53, (double)var16);
                                          }
                                          continue;
                                       }

                                       if(var33 == 4013) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          if(var53 == 0) {
                                             class36.field786[var5++] = 0;
                                          } else if(var16 == 0) {
                                             class36.field786[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class36.field786[var5++] = (int)Math.pow((double)var53, 1.0D / (double)var16);
                                          }
                                          continue;
                                       }

                                       if(var33 == 4014) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var53 & var16;
                                          continue;
                                       }

                                       if(4015 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class36.field786[var5++] = var53 | var16;
                                          continue;
                                       }
                                    } else if(var33 < 4200) {
                                       if(4100 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          class36.field787[var6++] = var62 + var16;
                                          continue;
                                       }

                                       if(4101 == var33) {
                                          var6 -= 2;
                                          var62 = class36.field787[var6];
                                          var44 = class36.field787[1 + var6];
                                          class36.field787[var6++] = var62 + var44;
                                          continue;
                                       }

                                       if(var33 == 4102) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          class36.field787[var6++] = var62 + class157.method3207(var16, true);
                                          continue;
                                       }

                                       if(4103 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          class36.field787[var6++] = var62.toLowerCase();
                                          continue;
                                       }

                                       if(4104 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          long var97 = 86400000L * (11745L + (long)var53);
                                          class36.field790.setTime(new Date(var97));
                                          var37 = class36.field790.get(5);
                                          var19 = class36.field790.get(2);
                                          var20 = class36.field790.get(1);
                                          class36.field787[var6++] = var37 + "-" + class36.field784[var19] + "-" + var20;
                                          continue;
                                       }

                                       if(4105 == var33) {
                                          var6 -= 2;
                                          var62 = class36.field787[var6];
                                          var44 = class36.field787[1 + var6];
                                          if(null != class0.field12.field31 && class0.field12.field31.field2900) {
                                             class36.field787[var6++] = var44;
                                             continue;
                                          }

                                          class36.field787[var6++] = var62;
                                          continue;
                                       }

                                       if(4106 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field787[var6++] = Integer.toString(var53);
                                          continue;
                                       }

                                       if(4107 == var33) {
                                          var6 -= 2;
                                          int[] var108 = class36.field786;
                                          var16 = var5++;
                                          var57 = class36.field787[var6];
                                          var77 = class36.field787[1 + var6];
                                          var20 = client.field283;
                                          var51 = var57.length();
                                          var22 = var77.length();
                                          int var23 = 0;
                                          int var24 = 0;
                                          char var25 = 0;
                                          char var26 = 0;

                                          label3504:
                                          while(true) {
                                             if(var23 - var25 >= var51 && var24 - var26 >= var22) {
                                                int var78 = Math.min(var51, var22);

                                                char var30;
                                                int var80;
                                                for(var80 = 0; var80 < var78; ++var80) {
                                                   char var29 = var57.charAt(var80);
                                                   var30 = var77.charAt(var80);
                                                   if(var30 != var29 && Character.toUpperCase(var29) != Character.toUpperCase(var30)) {
                                                      var29 = Character.toLowerCase(var29);
                                                      var30 = Character.toLowerCase(var30);
                                                      if(var30 != var29) {
                                                         var17 = class72.method1601(var29) - class72.method1601(var30);
                                                         break label3504;
                                                      }
                                                   }
                                                }

                                                var80 = var51 - var22;
                                                if(var80 != 0) {
                                                   var17 = var80;
                                                } else {
                                                   for(int var81 = 0; var81 < var78; ++var81) {
                                                      var30 = var57.charAt(var81);
                                                      char var31 = var77.charAt(var81);
                                                      if(var31 != var30) {
                                                         var17 = class72.method1601(var30) - class72.method1601(var31);
                                                         break label3504;
                                                      }
                                                   }

                                                   var17 = 0;
                                                }
                                                break;
                                             }

                                             if(var23 - var25 >= var51) {
                                                var17 = -1;
                                                break;
                                             }

                                             if(var24 - var26 >= var22) {
                                                var17 = 1;
                                                break;
                                             }

                                             char var27;
                                             if(0 != var25) {
                                                var27 = var25;
                                                boolean var66 = false;
                                             } else {
                                                var27 = var57.charAt(var23++);
                                             }

                                             char var28;
                                             if(var26 != 0) {
                                                var28 = var26;
                                                boolean var70 = false;
                                             } else {
                                                var28 = var77.charAt(var24++);
                                             }

                                             var25 = class56.method1269(var27);
                                             var26 = class56.method1269(var28);
                                             var27 = class45.method985(var27);
                                             var28 = class45.method985(var28);
                                             if(var28 != var27 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                                var27 = Character.toLowerCase(var27);
                                                var28 = Character.toLowerCase(var28);
                                                if(var28 != var27) {
                                                   var17 = class72.method1601(var27) - class72.method1601(var28);
                                                   break;
                                                }
                                             }
                                          }

                                          var108[var16] = class51.method1112(var17);
                                          continue;
                                       }

                                       byte[] var79;
                                       class223 var89;
                                       if(var33 == 4108) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          var5 -= 2;
                                          var16 = class36.field786[var5];
                                          var17 = class36.field786[var5 + 1];
                                          var79 = class7.field131.method3352(var17, 0);
                                          var89 = new class223(var79);
                                          class36.field786[var5++] = var89.method4087(var62, var16);
                                          continue;
                                       }

                                       if(var33 == 4109) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          var5 -= 2;
                                          var16 = class36.field786[var5];
                                          var17 = class36.field786[1 + var5];
                                          var79 = class7.field131.method3352(var17, 0);
                                          var89 = new class223(var79);
                                          class36.field786[var5++] = var89.method4101(var62, var16);
                                          continue;
                                       }

                                       if(4110 == var33) {
                                          var6 -= 2;
                                          var62 = class36.field787[var6];
                                          var44 = class36.field787[1 + var6];
                                          --var5;
                                          if(class36.field786[var5] == 1) {
                                             class36.field787[var6++] = var62;
                                          } else {
                                             class36.field787[var6++] = var44;
                                          }
                                          continue;
                                       }

                                       if(var33 == 4111) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          class36.field787[var6++] = class222.method4107(var62);
                                          continue;
                                       }

                                       if(var33 == 4112) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          class36.field787[var6++] = var62 + (char)var16;
                                          continue;
                                       }

                                       char var86;
                                       if(var33 == 4113) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var35 = class36.field786;
                                          var17 = var5++;
                                          var86 = (char)var53;
                                          if(var86 >= 32 && var86 <= 126) {
                                             var73 = true;
                                          } else if(var86 >= 160 && var86 <= 255) {
                                             var73 = true;
                                          } else if(8364 != var86 && var86 != 338 && var86 != 8212 && 339 != var86 && var86 != 376) {
                                             var73 = false;
                                          } else {
                                             var73 = true;
                                          }

                                          var35[var17] = var73?1:0;
                                          continue;
                                       }

                                       if(4114 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class3.method46((char)var53)?1:0;
                                          continue;
                                       }

                                       if(4115 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var35 = class36.field786;
                                          var17 = var5++;
                                          var86 = (char)var53;
                                          var73 = var86 >= 65 && var86 <= 90 || var86 >= 97 && var86 <= 122;
                                          var35[var17] = var73?1:0;
                                          continue;
                                       }

                                       if(var33 == 4116) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class42.method943((char)var53)?1:0;
                                          continue;
                                       }

                                       if(var33 == 4117) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(null != var62) {
                                             class36.field786[var5++] = var62.length();
                                          } else {
                                             class36.field786[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(4118 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          var5 -= 2;
                                          var16 = class36.field786[var5];
                                          var17 = class36.field786[1 + var5];
                                          class36.field787[var6++] = var62.substring(var16, var17);
                                          continue;
                                       }

                                       if(var33 == 4119) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          StringBuilder var94 = new StringBuilder(var62.length());
                                          var75 = false;

                                          for(var37 = 0; var37 < var62.length(); ++var37) {
                                             var86 = var62.charAt(var37);
                                             if(var86 == 60) {
                                                var75 = true;
                                             } else if(62 == var86) {
                                                var75 = false;
                                             } else if(!var75) {
                                                var94.append(var86);
                                             }
                                          }

                                          class36.field787[var6++] = var94.toString();
                                          continue;
                                       }

                                       if(4120 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          class36.field786[var5++] = var62.indexOf(var16);
                                          continue;
                                       }

                                       if(var33 == 4121) {
                                          var6 -= 2;
                                          var62 = class36.field787[var6];
                                          var44 = class36.field787[1 + var6];
                                          --var5;
                                          var17 = class36.field786[var5];
                                          class36.field786[var5++] = var62.indexOf(var44, var17);
                                          continue;
                                       }
                                    } else if(var33 < 4300) {
                                       if(4200 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field787[var6++] = class10.method158(var53).field1099;
                                          continue;
                                       }

                                       class51 var88;
                                       if(var33 == 4201) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          var88 = class10.method158(var53);
                                          if(var16 >= 1 && var16 <= 5 && var88.field1108[var16 - 1] != null) {
                                             class36.field787[var6++] = var88.field1108[var16 - 1];
                                             continue;
                                          }

                                          class36.field787[var6++] = "";
                                          continue;
                                       }

                                       if(4202 == var33) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          var88 = class10.method158(var53);
                                          if(var16 >= 1 && var16 <= 5 && null != var88.field1116[var16 - 1]) {
                                             class36.field787[var6++] = var88.field1116[var16 - 1];
                                             continue;
                                          }

                                          class36.field787[var6++] = "";
                                          continue;
                                       }

                                       if(var33 == 4203) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class10.method158(var53).field1111;
                                          continue;
                                       }

                                       if(var33 == 4204) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class10.method158(var53).field1110 == 1?1:0;
                                          continue;
                                       }

                                       class51 var102;
                                       if(4205 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var102 = class10.method158(var53);
                                          if(var102.field1114 == -1 && var102.field1104 >= 0) {
                                             class36.field786[var5++] = var102.field1104;
                                             continue;
                                          }

                                          class36.field786[var5++] = var53;
                                          continue;
                                       }

                                       if(var33 == 4206) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var102 = class10.method158(var53);
                                          if(var102.field1114 >= 0 && var102.field1104 >= 0) {
                                             class36.field786[var5++] = var102.field1104;
                                             continue;
                                          }

                                          class36.field786[var5++] = var53;
                                          continue;
                                       }

                                       if(4207 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class10.method158(var53).field1112?1:0;
                                          continue;
                                       }

                                       if(var33 == 4210) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          class6.method118(var62, 1 == var16);
                                          class36.field786[var5++] = class19.field268;
                                          continue;
                                       }

                                       if(4211 == var33) {
                                          if(class110.field1939 != null && class89.field1544 < class19.field268) {
                                             class36.field786[var5++] = class110.field1939[++class89.field1544 - 1] & '\uffff';
                                             continue;
                                          }

                                          class36.field786[var5++] = -1;
                                          continue;
                                       }

                                       if(4212 == var33) {
                                          class89.field1544 = 0;
                                          continue;
                                       }
                                    } else if(var33 < 5100) {
                                       if(var33 == 5000) {
                                          class36.field786[var5++] = client.field492;
                                          continue;
                                       }

                                       if(5001 == var33) {
                                          var5 -= 3;
                                          client.field492 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class129[] var93 = new class129[]{class129.field2043, class129.field2047, class129.field2045};
                                          class129[] var96 = var93;
                                          var19 = 0;

                                          class129 var109;
                                          while(true) {
                                             if(var19 >= var96.length) {
                                                var109 = null;
                                                break;
                                             }

                                             class129 var71 = var96[var19];
                                             if(var71.field2046 == var16) {
                                                var109 = var71;
                                                break;
                                             }

                                             ++var19;
                                          }

                                          class163.field2640 = var109;
                                          if(class163.field2640 == null) {
                                             class163.field2640 = class129.field2043;
                                          }

                                          client.field493 = class36.field786[2 + var5];
                                          client.field318.method2785(150);
                                          client.field318.method2521(client.field492);
                                          client.field318.method2521(class163.field2640.field2046);
                                          client.field318.method2521(client.field493);
                                          continue;
                                       }

                                       if(var33 == 5002) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          var5 -= 2;
                                          var16 = class36.field786[var5];
                                          var17 = class36.field786[1 + var5];
                                          client.field318.method2785(74);
                                          client.field318.method2521(class102.method2318(var62) + 2);
                                          client.field318.method2527(var62);
                                          client.field318.method2521(var16 - 1);
                                          client.field318.method2521(var17);
                                          continue;
                                       }

                                       if(var33 == 5003) {
                                          var5 -= 2;
                                          var53 = class36.field786[var5];
                                          var16 = class36.field786[var5 + 1];
                                          class35 var91 = class100.method2308(var53, var16);
                                          if(var91 != null) {
                                             class36.field786[var5++] = var91.field769;
                                             class36.field786[var5++] = var91.field767;
                                             class36.field787[var6++] = var91.field774 != null?var91.field774:"";
                                             class36.field787[var6++] = null != var91.field770?var91.field770:"";
                                             class36.field787[var6++] = null != var91.field771?var91.field771:"";
                                          } else {
                                             class36.field786[var5++] = -1;
                                             class36.field786[var5++] = 0;
                                             class36.field787[var6++] = "";
                                             class36.field787[var6++] = "";
                                             class36.field787[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(5004 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class35 var104 = (class35)class11.field166.method3851((long)var53);
                                          if(null != var104) {
                                             class36.field786[var5++] = var104.field768;
                                             class36.field786[var5++] = var104.field767;
                                             class36.field787[var6++] = null != var104.field774?var104.field774:"";
                                             class36.field787[var6++] = var104.field770 != null?var104.field770:"";
                                             class36.field787[var6++] = var104.field771 != null?var104.field771:"";
                                          } else {
                                             class36.field786[var5++] = -1;
                                             class36.field786[var5++] = 0;
                                             class36.field787[var6++] = "";
                                             class36.field787[var6++] = "";
                                             class36.field787[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var33 == 5005) {
                                          if(class163.field2640 == null) {
                                             class36.field786[var5++] = -1;
                                          } else {
                                             class36.field786[var5++] = class163.field2640.field2046;
                                          }
                                          continue;
                                       }

                                       if(var33 == 5008) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          --var5;
                                          var16 = class36.field786[var5];
                                          var39 = var62.toLowerCase();
                                          byte var85 = 0;
                                          if(var39.startsWith("yellow:")) {
                                             var85 = 0;
                                             var62 = var62.substring("yellow:".length());
                                          } else if(var39.startsWith("red:")) {
                                             var85 = 1;
                                             var62 = var62.substring("red:".length());
                                          } else if(var39.startsWith("green:")) {
                                             var85 = 2;
                                             var62 = var62.substring("green:".length());
                                          } else if(var39.startsWith("cyan:")) {
                                             var85 = 3;
                                             var62 = var62.substring("cyan:".length());
                                          } else if(var39.startsWith("purple:")) {
                                             var85 = 4;
                                             var62 = var62.substring("purple:".length());
                                          } else if(var39.startsWith("white:")) {
                                             var85 = 5;
                                             var62 = var62.substring("white:".length());
                                          } else if(var39.startsWith("flash1:")) {
                                             var85 = 6;
                                             var62 = var62.substring("flash1:".length());
                                          } else if(var39.startsWith("flash2:")) {
                                             var85 = 7;
                                             var62 = var62.substring("flash2:".length());
                                          } else if(var39.startsWith("flash3:")) {
                                             var85 = 8;
                                             var62 = var62.substring("flash3:".length());
                                          } else if(var39.startsWith("glow1:")) {
                                             var85 = 9;
                                             var62 = var62.substring("glow1:".length());
                                          } else if(var39.startsWith("glow2:")) {
                                             var85 = 10;
                                             var62 = var62.substring("glow2:".length());
                                          } else if(var39.startsWith("glow3:")) {
                                             var85 = 11;
                                             var62 = var62.substring("glow3:".length());
                                          } else if(0 != client.field283) {
                                             if(var39.startsWith("yellow:")) {
                                                var85 = 0;
                                                var62 = var62.substring("yellow:".length());
                                             } else if(var39.startsWith("red:")) {
                                                var85 = 1;
                                                var62 = var62.substring("red:".length());
                                             } else if(var39.startsWith("green:")) {
                                                var85 = 2;
                                                var62 = var62.substring("green:".length());
                                             } else if(var39.startsWith("cyan:")) {
                                                var85 = 3;
                                                var62 = var62.substring("cyan:".length());
                                             } else if(var39.startsWith("purple:")) {
                                                var85 = 4;
                                                var62 = var62.substring("purple:".length());
                                             } else if(var39.startsWith("white:")) {
                                                var85 = 5;
                                                var62 = var62.substring("white:".length());
                                             } else if(var39.startsWith("flash1:")) {
                                                var85 = 6;
                                                var62 = var62.substring("flash1:".length());
                                             } else if(var39.startsWith("flash2:")) {
                                                var85 = 7;
                                                var62 = var62.substring("flash2:".length());
                                             } else if(var39.startsWith("flash3:")) {
                                                var85 = 8;
                                                var62 = var62.substring("flash3:".length());
                                             } else if(var39.startsWith("glow1:")) {
                                                var85 = 9;
                                                var62 = var62.substring("glow1:".length());
                                             } else if(var39.startsWith("glow2:")) {
                                                var85 = 10;
                                                var62 = var62.substring("glow2:".length());
                                             } else if(var39.startsWith("glow3:")) {
                                                var85 = 11;
                                                var62 = var62.substring("glow3:".length());
                                             }
                                          }

                                          var39 = var62.toLowerCase();
                                          byte var92 = 0;
                                          if(var39.startsWith("wave:")) {
                                             var92 = 1;
                                             var62 = var62.substring("wave:".length());
                                          } else if(var39.startsWith("wave2:")) {
                                             var92 = 2;
                                             var62 = var62.substring("wave2:".length());
                                          } else if(var39.startsWith("shake:")) {
                                             var92 = 3;
                                             var62 = var62.substring("shake:".length());
                                          } else if(var39.startsWith("scroll:")) {
                                             var92 = 4;
                                             var62 = var62.substring("scroll:".length());
                                          } else if(var39.startsWith("slide:")) {
                                             var92 = 5;
                                             var62 = var62.substring("slide:".length());
                                          } else if(0 != client.field283) {
                                             if(var39.startsWith("wave:")) {
                                                var92 = 1;
                                                var62 = var62.substring("wave:".length());
                                             } else if(var39.startsWith("wave2:")) {
                                                var92 = 2;
                                                var62 = var62.substring("wave2:".length());
                                             } else if(var39.startsWith("shake:")) {
                                                var92 = 3;
                                                var62 = var62.substring("shake:".length());
                                             } else if(var39.startsWith("scroll:")) {
                                                var92 = 4;
                                                var62 = var62.substring("scroll:".length());
                                             } else if(var39.startsWith("slide:")) {
                                                var92 = 5;
                                                var62 = var62.substring("slide:".length());
                                             }
                                          }

                                          client.field318.method2785(146);
                                          client.field318.method2521(0);
                                          var20 = client.field318.field1981;
                                          client.field318.method2521(var16);
                                          client.field318.method2521(var85);
                                          client.field318.method2521(var92);
                                          class121 var65 = client.field318;
                                          var22 = var65.field1981;
                                          byte[] var61 = class21.method611(var62);
                                          var65.method2534(var61.length);
                                          var65.field1981 += class221.field3165.method2458(var61, 0, var61.length, var65.field1980, var65.field1981);
                                          client.field318.method2533(client.field318.field1981 - var20);
                                          continue;
                                       }

                                       if(5009 == var33) {
                                          var6 -= 2;
                                          var62 = class36.field787[var6];
                                          var44 = class36.field787[var6 + 1];
                                          client.field318.method2785(189);
                                          client.field318.method2522(0);
                                          var17 = client.field318.field1981;
                                          client.field318.method2527(var62);
                                          class121 var84 = client.field318;
                                          var19 = var84.field1981;
                                          byte[] var69 = class21.method611(var44);
                                          var84.method2534(var69.length);
                                          var84.field1981 += class221.field3165.method2458(var69, 0, var69.length, var84.field1980, var84.field1981);
                                          client.field318.method2719(client.field318.field1981 - var17);
                                          continue;
                                       }

                                       if(var33 == 5015) {
                                          if(null != class0.field12 && null != class0.field12.field34) {
                                             var62 = class0.field12.field34;
                                          } else {
                                             var62 = "";
                                          }

                                          class36.field787[var6++] = var62;
                                          continue;
                                       }

                                       if(5016 == var33) {
                                          class36.field786[var5++] = client.field493;
                                          continue;
                                       }

                                       if(5017 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class45.method990(var53);
                                          continue;
                                       }

                                       if(5018 == var33) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          class36.field786[var5++] = class161.method3233(var53);
                                          continue;
                                       }

                                       if(var33 == 5019) {
                                          --var5;
                                          var53 = class36.field786[var5];
                                          var35 = class36.field786;
                                          var17 = var5++;
                                          class35 var90 = (class35)class11.field166.method3851((long)var53);
                                          if(var90 == null) {
                                             var37 = -1;
                                          } else if(class11.field172.field3088 == var90.field3092) {
                                             var37 = -1;
                                          } else {
                                             var37 = ((class35)var90.field3092).field769;
                                          }

                                          var35[var17] = var37;
                                          continue;
                                       }

                                       if(5020 == var33) {
                                          --var6;
                                          var62 = class36.field787[var6];
                                          if(var62.equalsIgnoreCase("toggleroof")) {
                                             class153.field2277.field142 = !class153.field2277.field142;
                                             class125.method2852();
                                             if(class153.field2277.field142) {
                                                class50.method1063(99, "", "Roofs are now all hidden");
                                             } else {
                                                class50.method1063(99, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if(var62.equalsIgnoreCase("displayfps")) {
                                             client.field292 = !client.field292;
                                          }

                                          if(client.field441 >= 2) {
                                             if(var62.equalsIgnoreCase("fpson")) {
                                                client.field292 = true;
                                             }

                                             if(var62.equalsIgnoreCase("fpsoff")) {
                                                client.field292 = false;
                                             }

                                             if(var62.equalsIgnoreCase("gc")) {
                                                System.gc();
                                             }

                                             if(var62.equalsIgnoreCase("clientdrop")) {
                                                if(client.field400 > 0) {
                                                   class77.method1699();
                                                } else {
                                                   class31.method714(40);
                                                   class8.field138 = class11.field170;
                                                   class11.field170 = null;
                                                }
                                             }

                                             if(var62.equalsIgnoreCase("errortest") && client.field279 == 2) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          client.field318.method2785(246);
                                          client.field318.method2521(var62.length() + 1);
                                          client.field318.method2527(var62);
                                          continue;
                                       }

                                       if(var33 == 5021) {
                                          --var6;
                                          client.field494 = class36.field787[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(5022 == var33) {
                                          class36.field787[var6++] = client.field494;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var33 >= 2000) {
                                 var33 -= 1000;
                                 --var5;
                                 var15 = class48.method1036(class36.field786[var5]);
                              } else {
                                 var15 = var49?class150.field2244:class110.field1938;
                              }

                              if(1927 == var33) {
                                 if(class36.field780 * -624964409 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var15.field2841 == null) {
                                    return;
                                 }

                                 class0 var36 = new class0();
                                 var36.field2 = var15;
                                 var36.field10 = var15.field2841;
                                 var36.field0 = class36.field780 + -1763756809;
                                 client.field473.method3868(var0);
                                 continue;
                              }
                           }
                        } else {
                           if(var33 >= 2000) {
                              var33 -= 1000;
                              --var5;
                              var15 = class48.method1036(class36.field786[var5]);
                           } else {
                              var15 = var49?class150.field2244:class110.field1938;
                           }

                           if(1300 == var33) {
                              --var5;
                              var16 = class36.field786[var5] - 1;
                              if(var16 >= 0 && var16 <= 9) {
                                 --var6;
                                 var15.method3471(var16, class36.field787[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var33 == 1301) {
                              var5 -= 2;
                              var16 = class36.field786[var5];
                              var17 = class36.field786[var5 + 1];
                              var15.field2775 = class214.method4009(var16, var17);
                              continue;
                           }

                           if(1302 == var33) {
                              --var5;
                              var15.field2810 = class36.field786[var5] == 1;
                              continue;
                           }

                           if(var33 == 1303) {
                              --var5;
                              var15.field2804 = class36.field786[var5];
                              continue;
                           }

                           if(var33 == 1304) {
                              --var5;
                              var15.field2809 = class36.field786[var5];
                              continue;
                           }

                           if(1305 == var33) {
                              --var6;
                              var15.field2805 = class36.field787[var6];
                              continue;
                           }

                           if(1306 == var33) {
                              --var6;
                              var15.field2811 = class36.field787[var6];
                              continue;
                           }

                           if(var33 == 1307) {
                              var15.field2786 = null;
                              continue;
                           }
                        }
                     } else {
                        if(var33 >= 2000) {
                           var33 -= 1000;
                           --var5;
                           var15 = class48.method1036(class36.field786[var5]);
                        } else {
                           var15 = var49?class150.field2244:class110.field1938;
                        }

                        class42.method942(var15);
                        if(var33 == 1200 || var33 == 1205 || var33 == 1212) {
                           var5 -= 2;
                           var16 = class36.field786[var5];
                           var17 = class36.field786[var5 + 1];
                           var15.field2852 = var16;
                           var15.field2853 = var17;
                           class51 var18 = class10.method158(var16);
                           var15.field2783 = var18.field1105;
                           var15.field2760 = var18.field1103;
                           var15.field2785 = var18.field1089;
                           var15.field2781 = var18.field1139;
                           var15.field2782 = var18.field1130;
                           var15.field2787 = var18.field1129;
                           if(1205 == var33) {
                              var15.field2779 = 0;
                           } else if(var33 == 1212 | 1 == var18.field1110) {
                              var15.field2779 = 1;
                           } else {
                              var15.field2779 = 2;
                           }

                           if(var15.field2789 > 0) {
                              var15.field2787 = var15.field2787 * 32 / var15.field2789;
                           } else if(var15.field2860 > 0) {
                              var15.field2787 = var15.field2787 * 32 / var15.field2860;
                           }
                           continue;
                        }

                        if(1201 == var33) {
                           var15.field2777 = 2;
                           --var5;
                           var15.field2776 = class36.field786[var5];
                           continue;
                        }

                        if(1202 == var33) {
                           var15.field2777 = 3;
                           var15.field2776 = class0.field12.field31.method3558();
                           continue;
                        }
                     }
                  }
               }

               if(var33 < 5400) {
                  if(5306 == var33) {
                     class36.field786[var5++] = class27.method688();
                     continue;
                  }

                  if(5307 == var33) {
                     --var5;
                     var53 = class36.field786[var5];
                     if(1 != var53 && 2 != var53) {
                        continue;
                     }

                     client.field487 = 0L;
                     if(var53 >= 2) {
                        client.field426 = true;
                     } else {
                        client.field426 = false;
                     }

                     class125.method2846();
                     if(client.field296 >= 25) {
                        class19.method256();
                     }

                     class143.field2186 = true;
                     continue;
                  }

                  if(5308 == var33) {
                     class36.field786[var5++] = class153.field2277.field132;
                     continue;
                  }

                  if(5309 == var33) {
                     --var5;
                     var53 = class36.field786[var5];
                     if(1 == var53 || var53 == 2) {
                        class153.field2277.field132 = var53;
                        class125.method2852();
                     }
                     continue;
                  }
               }

               if(var33 < 5600) {
                  if(var33 == 5504) {
                     var5 -= 2;
                     var53 = class36.field786[var5];
                     var16 = class36.field786[var5 + 1];
                     if(!client.field334) {
                        client.field360 = var53;
                        client.field434 = var16;
                     }
                     continue;
                  }

                  if(var33 == 5505) {
                     class36.field786[var5++] = client.field360;
                     continue;
                  }

                  if(var33 == 5506) {
                     class36.field786[var5++] = client.field434;
                     continue;
                  }

                  if(5530 == var33) {
                     --var5;
                     var53 = class36.field786[var5];
                     if(var53 < 0) {
                        var53 = 0;
                     }

                     client.field366 = var53;
                     continue;
                  }

                  if(var33 == 5531) {
                     class36.field786[var5++] = client.field366;
                     continue;
                  }
               }

               if(var33 < 5700 && 5630 == var33) {
                  client.field400 = 250;
               } else {
                  if(var33 < 6300) {
                     if(var33 == 6200) {
                        var5 -= 2;
                        client.field528 = (short)class36.field786[var5];
                        if(client.field528 <= 0) {
                           client.field528 = 256;
                        }

                        client.field529 = (short)class36.field786[1 + var5];
                        if(client.field529 <= 0) {
                           client.field529 = 205;
                        }
                        continue;
                     }

                     if(var33 == 6201) {
                        var5 -= 2;
                        client.field488 = (short)class36.field786[var5];
                        if(client.field488 <= 0) {
                           client.field488 = 256;
                        }

                        client.field531 = (short)class36.field786[var5 + 1];
                        if(client.field531 <= 0) {
                           client.field531 = 320;
                        }
                        continue;
                     }

                     if(var33 == 6202) {
                        var5 -= 4;
                        client.field386 = (short)class36.field786[var5];
                        if(client.field386 <= 0) {
                           client.field386 = 1;
                        }

                        client.field533 = (short)class36.field786[var5 + 1];
                        if(client.field533 <= 0) {
                           client.field533 = 32767;
                        } else if(client.field533 < client.field386) {
                           client.field533 = client.field386;
                        }

                        client.field534 = (short)class36.field786[2 + var5];
                        if(client.field534 <= 0) {
                           client.field534 = 1;
                        }

                        client.field284 = (short)class36.field786[var5 + 3];
                        if(client.field284 <= 0) {
                           client.field284 = 32767;
                        } else if(client.field284 < client.field534) {
                           client.field284 = client.field534;
                        }
                        continue;
                     }

                     if(var33 == 6203) {
                        if(client.field535 != null) {
                           class31.method735(0, 0, client.field535.field2749, client.field535.field2750, false);
                           class36.field786[var5++] = client.field538;
                           class36.field786[var5++] = client.field539;
                        } else {
                           class36.field786[var5++] = -1;
                           class36.field786[var5++] = -1;
                        }
                        continue;
                     }

                     if(var33 == 6204) {
                        class36.field786[var5++] = client.field488;
                        class36.field786[var5++] = client.field531;
                        continue;
                     }

                     if(6205 == var33) {
                        class36.field786[var5++] = client.field528;
                        class36.field786[var5++] = client.field529;
                        continue;
                     }
                  }

                  if(var33 < 6600) {
                     if(var33 == 6500) {
                        class36.field786[var5++] = class160.method3226()?1:0;
                        continue;
                     }

                     class25 var110;
                     if(var33 == 6501) {
                        class25.field623 = 0;
                        var110 = class17.method214();
                        if(var110 != null) {
                           class36.field786[var5++] = var110.field621;
                           class36.field786[var5++] = var110.field622;
                           class36.field787[var6++] = var110.field633;
                           class36.field786[var5++] = var110.field626;
                           class36.field786[var5++] = var110.field629;
                           class36.field787[var6++] = var110.field624;
                        } else {
                           class36.field786[var5++] = -1;
                           class36.field786[var5++] = 0;
                           class36.field787[var6++] = "";
                           class36.field786[var5++] = 0;
                           class36.field786[var5++] = 0;
                           class36.field787[var6++] = "";
                        }
                        continue;
                     }

                     if(var33 == 6502) {
                        if(class25.field623 < class25.field616) {
                           var110 = class25.field615[++class25.field623 - 1];
                        } else {
                           var110 = null;
                        }

                        if(var110 != null) {
                           class36.field786[var5++] = var110.field621;
                           class36.field786[var5++] = var110.field622;
                           class36.field787[var6++] = var110.field633;
                           class36.field786[var5++] = var110.field626;
                           class36.field786[var5++] = var110.field629;
                           class36.field787[var6++] = var110.field624;
                        } else {
                           class36.field786[var5++] = -1;
                           class36.field786[var5++] = 0;
                           class36.field787[var6++] = "";
                           class36.field786[var5++] = 0;
                           class36.field786[var5++] = 0;
                           class36.field787[var6++] = "";
                        }
                        continue;
                     }

                     class25 var106;
                     if(6506 == var33) {
                        --var5;
                        var53 = class36.field786[var5];
                        var106 = null;

                        for(var17 = 0; var17 < class25.field616; ++var17) {
                           if(var53 == class25.field615[var17].field621) {
                              var106 = class25.field615[var17];
                              break;
                           }
                        }

                        if(null != var106) {
                           class36.field786[var5++] = var106.field621;
                           class36.field786[var5++] = var106.field622;
                           class36.field787[var6++] = var106.field633;
                           class36.field786[var5++] = var106.field626;
                           class36.field786[var5++] = var106.field629;
                           class36.field787[var6++] = var106.field624;
                        } else {
                           class36.field786[var5++] = -1;
                           class36.field786[var5++] = 0;
                           class36.field787[var6++] = "";
                           class36.field786[var5++] = 0;
                           class36.field786[var5++] = 0;
                           class36.field787[var6++] = "";
                        }
                        continue;
                     }

                     if(var33 == 6507) {
                        var5 -= 4;
                        var53 = class36.field786[var5];
                        var45 = 1 == class36.field786[1 + var5];
                        var17 = class36.field786[var5 + 2];
                        var73 = class36.field786[var5 + 3] == 1;
                        class28.method695(var53, var45, var17, var73);
                        continue;
                     }

                     if(6511 == var33) {
                        --var5;
                        var53 = class36.field786[var5];
                        if(var53 >= 0 && var53 < class25.field616) {
                           var106 = class25.field615[var53];
                           class36.field786[var5++] = var106.field621;
                           class36.field786[var5++] = var106.field622;
                           class36.field787[var6++] = var106.field633;
                           class36.field786[var5++] = var106.field626;
                           class36.field786[var5++] = var106.field629;
                           class36.field787[var6++] = var106.field624;
                           continue;
                        }

                        class36.field786[var5++] = -1;
                        class36.field786[var5++] = 0;
                        class36.field787[var6++] = "";
                        class36.field786[var5++] = 0;
                        class36.field786[var5++] = 0;
                        class36.field787[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var32) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3104).append(" ");

            for(var13 = class36.field791 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field789[var13].field211.field3104).append(" ");
            }

            var12.append("").append(var10);
            class37.method803(var12.toString(), var32);
         }
      }
   }
}

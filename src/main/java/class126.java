import java.util.Date;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dk")
public class class126 {
   @ObfuscatedName("v")
   static int[] field2045;
   @ObfuscatedName("a")
   public static class166 field2046;
   @ObfuscatedName("h")
   static int[] field2048;

   @ObfuscatedName("ca")
   static final void method2750() {
      class114.method2400(client.field536);
      ++class83.field1458;
      if(client.field469 && client.field466) {
         int var0 = class139.field2162;
         int var1 = class139.field2171;
         var0 -= client.field428;
         var1 -= client.field464;
         if(var0 < client.field467) {
            var0 = client.field467;
         }

         if(client.field536.field2774 + var0 > client.field467 + client.field297.field2774) {
            var0 = client.field467 + client.field297.field2774 - client.field536.field2774;
         }

         if(var1 < client.field468) {
            var1 = client.field468;
         }

         if(var1 + client.field536.field2890 > client.field297.field2890 + client.field468) {
            var1 = client.field468 + client.field297.field2890 - client.field536.field2890;
         }

         int var2 = var0 - client.field470;
         int var3 = var1 - client.field321;
         int var4 = client.field536.field2833;
         if(class83.field1458 > client.field536.field2834 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field314 = true;
         }

         int var5 = var0 - client.field467 + client.field297.field2829;
         int var6 = var1 - client.field468 + client.field297.field2886;
         class0 var7;
         if(null != client.field536.field2811 && client.field314) {
            var7 = new class0();
            var7.field2 = client.field536;
            var7.field3 = var5;
            var7.field6 = var6;
            var7.field5 = client.field536.field2811;
            method2751(var7, 200000);
         }

         if(0 == class139.field2161) {
            int var9;
            if(client.field314) {
               if(client.field536.field2887 != null) {
                  var7 = new class0();
                  var7.field2 = client.field536;
                  var7.field3 = var5;
                  var7.field6 = var6;
                  var7.field11 = client.field312;
                  var7.field5 = client.field536.field2887;
                  method2751(var7, 200000);
               }

               if(client.field312 != null) {
                  class172 var14 = client.field536;
                  int var10 = class42.method898(var14);
                  var9 = var10 >> 17 & 7;
                  int var11 = var9;
                  class172 var15;
                  if(var9 == 0) {
                     var15 = null;
                  } else {
                     int var12 = 0;

                     while(true) {
                        if(var12 >= var11) {
                           var15 = var14;
                           break;
                        }

                        var14 = class31.method698(var14.field2778);
                        if(var14 == null) {
                           var15 = null;
                           break;
                        }

                        ++var12;
                     }
                  }

                  if(null != var15) {
                     client.field329.method2686(211);
                     client.field329.method2607(client.field312.field2759 * -1);
                     client.field329.method2541(client.field536.field2825);
                     client.field329.method2440(client.field312.field2877);
                     client.field329.method2564(client.field312.field2825);
                     client.field329.method2441(client.field536.field2759 * -1);
                     client.field329.method2564(client.field536.field2877);
                  }
               }
            } else {
               label170: {
                  label141: {
                     if(1 != client.field427) {
                        int var8 = client.field430 - 1;
                        boolean var13;
                        if(var8 < 0) {
                           var13 = false;
                        } else {
                           var9 = client.field433[var8];
                           if(var9 >= 2000) {
                              var9 -= 2000;
                           }

                           if(var9 == 1007) {
                              var13 = true;
                           } else {
                              var13 = false;
                           }
                        }

                        if(!var13) {
                           break label141;
                        }
                     }

                     if(client.field430 > 2) {
                        class19.method212(client.field428 + client.field470, client.field321 + client.field464);
                        break label170;
                     }
                  }

                  if(client.field430 > 0) {
                     class49.method1006(client.field428 + client.field470, client.field464 + client.field321);
                  }
               }
            }

            client.field536 = null;
         }

      } else {
         if(class83.field1458 > 1) {
            client.field536 = null;
         }

      }
   }

   @ObfuscatedName("j")
   static void method2751(class0 var0, int var1) {
      Object[] var2 = var0.field5;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class22.method580(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field588;
         int[] var9 = var4.field589;
         byte var10 = -1;
         class36.field801 = 0;

         int var13;
         try {
            class36.field796 = new int[var4.field591];
            int var11 = 0;
            class217.field3160 = new String[var4.field587];
            int var31 = 0;

            int var14;
            String var43;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field6;
                  }

                  if(-2147483645 == var14) {
                     var14 = null != var0.field2?var0.field2.field2759 * -1:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field14;
                  }

                  if(-2147483643 == var14) {
                     var14 = null != var0.field2?var0.field2.field2825:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field11?var0.field11.field2759 * -1:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field11?var0.field11.field2825:-1;
                  }

                  if(-2147483640 == var14) {
                     var14 = var0.field7;
                  }

                  if(-2147483639 == var14) {
                     var14 = var0.field8;
                  }

                  class36.field796[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var43 = (String)var2[var13];
                  if(var43.equals("event_opbase")) {
                     var43 = var0.field9;
                  }

                  class217.field3160[var31++] = var43;
               }
            }

            var13 = 0;
            class36.field805 = var0.field0;

            label3364:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var30 = var8[var7];
               int var16;
               int var35;
               String var42;
               int var51;
               int[] var56;
               String[] var68;
               if(var30 < 100) {
                  if(0 == var30) {
                     class36.field795[var5++] = var9[var7];
                     continue;
                  }

                  if(1 == var30) {
                     var14 = var9[var7];
                     class36.field795[var5++] = class175.field2906[var14];
                     continue;
                  }

                  if(var30 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class175.field2906[var14] = class36.field795[var5];
                     class129.method2758(var14);
                     continue;
                  }

                  if(3 == var30) {
                     class36.field800[var6++] = var4.field594[var7];
                     continue;
                  }

                  if(6 == var30) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(7 == var30) {
                     var5 -= 2;
                     if(class36.field795[1 + var5] != class36.field795[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var30) {
                     var5 -= 2;
                     if(class36.field795[1 + var5] == class36.field795[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(9 == var30) {
                     var5 -= 2;
                     if(class36.field795[var5] < class36.field795[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(10 == var30) {
                     var5 -= 2;
                     if(class36.field795[var5] > class36.field795[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var30 == 21) {
                     if(0 == class36.field801) {
                        return;
                     }

                     class14 var79 = class36.field794[--class36.field801];
                     var4 = var79.field212;
                     var8 = var4.field588;
                     var9 = var4.field589;
                     var7 = var79.field216;
                     class36.field796 = var79.field220;
                     class217.field3160 = var79.field214;
                     continue;
                  }

                  if(25 == var30) {
                     var14 = var9[var7];
                     class36.field795[var5++] = class109.method2380(var14);
                     continue;
                  }

                  if(27 == var30) {
                     var14 = var9[var7];
                     --var5;
                     class100.method2243(var14, class36.field795[var5]);
                     continue;
                  }

                  if(31 == var30) {
                     var5 -= 2;
                     if(class36.field795[var5] <= class36.field795[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(32 == var30) {
                     var5 -= 2;
                     if(class36.field795[var5] >= class36.field795[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(33 == var30) {
                     class36.field795[var5++] = class36.field796[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(34 == var30) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field796[var10001] = class36.field795[var5];
                     continue;
                  }

                  if(var30 == 35) {
                     class36.field800[var6++] = class217.field3160[var9[var7]];
                     continue;
                  }

                  if(36 == var30) {
                     var10001 = var9[var7];
                     --var6;
                     class217.field3160[var10001] = class36.field800[var6];
                     continue;
                  }

                  if(var30 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var42 = class159.method3132(class36.field800, var6, var14);
                     class36.field800[var6++] = var42;
                     continue;
                  }

                  if(38 == var30) {
                     --var5;
                     continue;
                  }

                  if(var30 == 39) {
                     --var6;
                     continue;
                  }

                  if(40 == var30) {
                     var14 = var9[var7];
                     class22 var95 = class22.method580(var14);
                     var56 = new int[var95.field591];
                     var68 = new String[var95.field587];

                     for(var51 = 0; var51 < var95.field592; ++var51) {
                        var56[var51] = class36.field795[var5 - var95.field592 + var51];
                     }

                     for(var51 = 0; var51 < var95.field601; ++var51) {
                        var68[var51] = class36.field800[var6 - var95.field601 + var51];
                     }

                     var5 -= var95.field592;
                     var6 -= var95.field601;
                     class14 var93 = new class14();
                     var93.field212 = var4;
                     var93.field216 = var7;
                     var93.field220 = class36.field796;
                     var93.field214 = class217.field3160;
                     class36.field794[++class36.field801 - 1] = var93;
                     var4 = var95;
                     var8 = var95.field588;
                     var9 = var95.field589;
                     var7 = -1;
                     class36.field796 = var56;
                     class217.field3160 = var68;
                     continue;
                  }

                  if(42 == var30) {
                     class36.field795[var5++] = class3.field63.method216(var9[var7]);
                     continue;
                  }

                  if(43 == var30) {
                     var10001 = var9[var7];
                     --var5;
                     class3.field63.method200(var10001, class36.field795[var5]);
                     continue;
                  }

                  if(44 == var30) {
                     var14 = var9[var7] >> 16;
                     var35 = var9[var7] & '\uffff';
                     --var5;
                     var16 = class36.field795[var5];
                     if(var16 >= 0 && var16 <= 5000) {
                        class36.field802[var14] = var16;
                        byte var82 = -1;
                        if(var35 == 105) {
                           var82 = 0;
                        }

                        var51 = 0;

                        while(true) {
                           if(var51 >= var16) {
                              continue label3364;
                           }

                           class36.field808[var14][var51] = var82;
                           ++var51;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(45 == var30) {
                     var14 = var9[var7];
                     --var5;
                     var35 = class36.field795[var5];
                     if(var35 >= 0 && var35 < class36.field802[var14]) {
                        class36.field795[var5++] = class36.field808[var14][var35];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var30 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var35 = class36.field795[var5];
                     if(var35 >= 0 && var35 < class36.field802[var14]) {
                        class36.field808[var14][var35] = class36.field795[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(47 == var30) {
                     var43 = class3.field63.method203(var9[var7]);
                     if(null == var43) {
                        var43 = "null";
                     }

                     class36.field800[var6++] = var43;
                     continue;
                  }

                  if(var30 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class3.field63.method202(var10001, class36.field800[var6]);
                     continue;
                  }
               }

               boolean var47;
               if(var9[var7] == 1) {
                  var47 = true;
               } else {
                  var47 = false;
               }

               class172 var15;
               int var17;
               int var20;
               class172 var34;
               class172 var37;
               boolean var38;
               boolean var40;
               class172 var91;
               if(var30 < 1000) {
                  if(var30 == 100) {
                     var5 -= 3;
                     var35 = class36.field795[var5];
                     var16 = class36.field795[var5 + 1];
                     var17 = class36.field795[var5 + 2];
                     if(0 == var16) {
                        throw new RuntimeException();
                     }

                     var37 = class31.method698(var35);
                     if(null == var37.field2881) {
                        var37.field2881 = new class172[var17 + 1];
                     }

                     if(var37.field2881.length <= var17) {
                        class172[] var80 = new class172[1 + var17];

                        for(var20 = 0; var20 < var37.field2881.length; ++var20) {
                           var80[var20] = var37.field2881[var20];
                        }

                        var37.field2881 = var80;
                     }

                     if(var17 > 0 && null == var37.field2881[var17 - 1]) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     class172 var81 = new class172();
                     var81.field2849 = var16;
                     var81.field2778 = (var81.field2759 = var37.field2759) * -1;
                     var81.field2825 = var17;
                     var81.field2758 = true;
                     var37.field2881[var17] = var81;
                     if(var47) {
                        class110.field1959 = var81;
                     } else {
                        class21.field582 = var81;
                     }

                     class114.method2400(var37);
                     continue;
                  }

                  if(101 == var30) {
                     var15 = var47?class110.field1959:class21.field582;
                     var91 = class31.method698(var15.field2759 * -1);
                     var91.field2881[var15.field2825] = null;
                     class114.method2400(var91);
                     continue;
                  }

                  if(102 == var30) {
                     --var5;
                     var15 = class31.method698(class36.field795[var5]);
                     var15.field2881 = null;
                     class114.method2400(var15);
                     continue;
                  }

                  if(var30 == 200) {
                     var5 -= 2;
                     var35 = class36.field795[var5];
                     var16 = class36.field795[var5 + 1];
                     var34 = class142.method2954(var35, var16);
                     if(null != var34 && var16 != -1) {
                        class36.field795[var5++] = 1;
                        if(var47) {
                           class110.field1959 = var34;
                        } else {
                           class21.field582 = var34;
                        }
                        continue;
                     }

                     class36.field795[var5++] = 0;
                     continue;
                  }

                  if(201 == var30) {
                     --var5;
                     var15 = class31.method698(class36.field795[var5]);
                     if(null != var15) {
                        class36.field795[var5++] = 1;
                        if(var47) {
                           class110.field1959 = var15;
                        } else {
                           class21.field582 = var15;
                        }
                     } else {
                        class36.field795[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var60;
                  if(var30 >= 1000 && var30 < 1100 || var30 >= 2000 && var30 < 2100) {
                     var35 = -1;
                     if(var30 >= 2000) {
                        var30 -= 1000;
                        --var5;
                        var35 = class36.field795[var5];
                        var91 = class31.method698(var35);
                     } else {
                        var91 = var47?class110.field1959:class21.field582;
                     }

                     if(var30 == 1000) {
                        var5 -= 4;
                        var91.field2768 = class36.field795[var5];
                        var91.field2769 = class36.field795[var5 + 1];
                        var91.field2764 = class36.field795[2 + var5];
                        var91.field2866 = class36.field795[var5 + 3];
                        class114.method2400(var91);
                        class84.method1869(var91);
                        if(var35 != -1 && 0 == var91.field2849) {
                           class13.method154(class172.field2757[var35 >> 16], var91, false);
                        }
                        continue;
                     }

                     if(var30 == 1001) {
                        var5 -= 4;
                        var91.field2781 = class36.field795[var5];
                        var91.field2771 = class36.field795[1 + var5];
                        var91.field2766 = class36.field795[2 + var5];
                        var91.field2767 = class36.field795[var5 + 3];
                        class114.method2400(var91);
                        class84.method1869(var91);
                        if(var35 != -1 && var91.field2849 == 0) {
                           class13.method154(class172.field2757[var35 >> 16], var91, false);
                        }
                        continue;
                     }

                     if(1003 == var30) {
                        --var5;
                        var60 = class36.field795[var5] == 1;
                        if(var60 != var91.field2794) {
                           var91.field2794 = var60;
                           class114.method2400(var91);
                        }
                        continue;
                     }

                     if(1005 == var30) {
                        --var5;
                        var91.field2884 = class36.field795[var5] == 1;
                        continue;
                     }

                     if(1006 == var30) {
                        --var5;
                        var91.field2880 = class36.field795[var5] == 1;
                        continue;
                     }
                  } else {
                     String var33;
                     if(var30 >= 1100 && var30 < 1200 || var30 >= 2100 && var30 < 2200) {
                        var16 = -1;
                        if(var30 >= 2000) {
                           var30 -= 1000;
                           --var5;
                           var16 = class36.field795[var5];
                           var15 = class31.method698(var16);
                        } else {
                           var15 = var47?class110.field1959:class21.field582;
                        }

                        if(var30 == 1100) {
                           var5 -= 2;
                           var15.field2829 = class36.field795[var5];
                           if(var15.field2829 > var15.field2782 - var15.field2774) {
                              var15.field2829 = var15.field2782 - var15.field2774;
                           }

                           if(var15.field2829 < 0) {
                              var15.field2829 = 0;
                           }

                           var15.field2886 = class36.field795[1 + var5];
                           if(var15.field2886 > var15.field2783 - var15.field2890) {
                              var15.field2886 = var15.field2783 - var15.field2890;
                           }

                           if(var15.field2886 < 0) {
                              var15.field2886 = 0;
                           }

                           class114.method2400(var15);
                           continue;
                        }

                        if(1101 == var30) {
                           --var5;
                           var15.field2859 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1102) {
                           --var5;
                           var15.field2788 = class36.field795[var5] == 1;
                           class114.method2400(var15);
                           continue;
                        }

                        if(1103 == var30) {
                           --var5;
                           var15.field2753 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1104) {
                           --var5;
                           var15.field2790 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(1105 == var30) {
                           --var5;
                           var15.field2765 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(1106 == var30) {
                           --var5;
                           var15.field2761 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1107) {
                           --var5;
                           var15.field2795 = class36.field795[var5] == 1;
                           class114.method2400(var15);
                           continue;
                        }

                        if(1108 == var30) {
                           var15.field2800 = 1;
                           --var5;
                           var15.field2857 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(1109 == var30) {
                           var5 -= 6;
                           var15.field2770 = class36.field795[var5];
                           var15.field2839 = class36.field795[var5 + 1];
                           var15.field2808 = class36.field795[var5 + 2];
                           var15.field2809 = class36.field795[var5 + 3];
                           var15.field2810 = class36.field795[4 + var5];
                           var15.field2818 = class36.field795[var5 + 5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(1110 == var30) {
                           --var5;
                           var17 = class36.field795[var5];
                           if(var17 != var15.field2836) {
                              var15.field2836 = var17;
                              var15.field2816 = 0;
                              var15.field2760 = 0;
                              class114.method2400(var15);
                           }
                           continue;
                        }

                        if(1111 == var30) {
                           --var5;
                           var15.field2801 = class36.field795[var5] == 1;
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1112) {
                           --var6;
                           var33 = class36.field800[var6];
                           if(!var33.equals(var15.field2817)) {
                              var15.field2817 = var33;
                              class114.method2400(var15);
                           }
                           continue;
                        }

                        if(var30 == 1113) {
                           --var5;
                           var15.field2873 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(1114 == var30) {
                           var5 -= 3;
                           var15.field2820 = class36.field795[var5];
                           var15.field2821 = class36.field795[1 + var5];
                           var15.field2819 = class36.field795[var5 + 2];
                           class114.method2400(var15);
                           continue;
                        }

                        if(1115 == var30) {
                           --var5;
                           var15.field2822 = class36.field795[var5] == 1;
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1116) {
                           --var5;
                           var15.field2796 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1117) {
                           --var5;
                           var15.field2797 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1118) {
                           --var5;
                           var15.field2798 = class36.field795[var5] == 1;
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1119) {
                           --var5;
                           var15.field2799 = class36.field795[var5] == 1;
                           class114.method2400(var15);
                           continue;
                        }

                        if(var30 == 1120) {
                           var5 -= 2;
                           var15.field2782 = class36.field795[var5];
                           var15.field2783 = class36.field795[1 + var5];
                           class114.method2400(var15);
                           if(-1 != var16 && var15.field2849 == 0) {
                              class13.method154(class172.field2757[var16 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(1121 == var30) {
                           var17 = var15.field2759 * -1;
                           var51 = var15.field2825;
                           client.field329.method2686(13);
                           client.field329.method2440(var51);
                           client.field329.method2494(var17);
                           client.field452 = var15;
                           class114.method2400(var15);
                           continue;
                        }

                        if(1122 == var30) {
                           --var5;
                           var15.field2793 = class36.field795[var5];
                           class114.method2400(var15);
                           continue;
                        }
                     } else if((var30 < 1200 || var30 >= 1300) && (var30 < 2200 || var30 >= 2300)) {
                        if(var30 >= 1300 && var30 < 1400 || var30 >= 2300 && var30 < 2400) {
                           if(var30 >= 2000) {
                              var30 -= 1000;
                              --var5;
                              var15 = class31.method698(class36.field795[var5]);
                           } else {
                              var15 = var47?class110.field1959:class21.field582;
                           }

                           if(1300 == var30) {
                              --var5;
                              var16 = class36.field795[var5] - 1;
                              if(var16 >= 0 && var16 <= 9) {
                                 --var6;
                                 var15.method3378(var16, class36.field800[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var30 == 1301) {
                              var5 -= 2;
                              var16 = class36.field795[var5];
                              var17 = class36.field795[var5 + 1];
                              var15.field2843 = class142.method2954(var16, var17);
                              continue;
                           }

                           if(1302 == var30) {
                              --var5;
                              var15.field2775 = class36.field795[var5] == 1;
                              continue;
                           }

                           if(1303 == var30) {
                              --var5;
                              var15.field2833 = class36.field795[var5];
                              continue;
                           }

                           if(1304 == var30) {
                              --var5;
                              var15.field2834 = class36.field795[var5];
                              continue;
                           }

                           if(1305 == var30) {
                              --var6;
                              var15.field2830 = class36.field800[var6];
                              continue;
                           }

                           if(var30 == 1306) {
                              --var6;
                              var15.field2806 = class36.field800[var6];
                              continue;
                           }

                           if(var30 == 1307) {
                              var15.field2831 = null;
                              continue;
                           }
                        } else {
                           String var36;
                           int var59;
                           if(var30 >= 1400 && var30 < 1500 || var30 >= 2400 && var30 < 2500) {
                              if(var30 >= 2000) {
                                 var30 -= 1000;
                                 --var5;
                                 var15 = class31.method698(class36.field795[var5]);
                              } else {
                                 var15 = var47?class110.field1959:class21.field582;
                              }

                              --var6;
                              var36 = class36.field800[var6];
                              int[] var77 = null;
                              if(var36.length() > 0 && var36.charAt(var36.length() - 1) == 89) {
                                 --var5;
                                 var51 = class36.field795[var5];
                                 if(var51 > 0) {
                                    for(var77 = new int[var51]; var51-- > 0; var77[var51] = class36.field795[var5]) {
                                       --var5;
                                    }
                                 }

                                 var36 = var36.substring(0, var36.length() - 1);
                              }

                              Object[] var86 = new Object[var36.length() + 1];

                              for(var59 = var86.length - 1; var59 >= 1; --var59) {
                                 if(var36.charAt(var59 - 1) == 115) {
                                    --var6;
                                    var86[var59] = class36.field800[var6];
                                 } else {
                                    --var5;
                                    var86[var59] = new Integer(class36.field795[var5]);
                                 }
                              }

                              --var5;
                              var59 = class36.field795[var5];
                              if(var59 != -1) {
                                 var86[0] = new Integer(var59);
                              } else {
                                 var86 = null;
                              }

                              if(1400 == var30) {
                                 var15.field2755 = var86;
                              }

                              if(1401 == var30) {
                                 var15.field2842 = var86;
                              }

                              if(var30 == 1402) {
                                 var15.field2863 = var86;
                              }

                              if(1403 == var30) {
                                 var15.field2807 = var86;
                              }

                              if(var30 == 1404) {
                                 var15.field2845 = var86;
                              }

                              if(1405 == var30) {
                                 var15.field2811 = var86;
                              }

                              if(var30 == 1406) {
                                 var15.field2814 = var86;
                              }

                              if(var30 == 1407) {
                                 var15.field2838 = var86;
                                 var15.field2851 = var77;
                              }

                              if(1408 == var30) {
                                 var15.field2856 = var86;
                              }

                              if(1409 == var30) {
                                 var15.field2891 = var86;
                              }

                              if(var30 == 1410) {
                                 var15.field2887 = var86;
                              }

                              if(1411 == var30) {
                                 var15.field2840 = var86;
                              }

                              if(var30 == 1412) {
                                 var15.field2844 = var86;
                              }

                              if(1414 == var30) {
                                 var15.field2852 = var86;
                                 var15.field2751 = var77;
                              }

                              if(var30 == 1415) {
                                 var15.field2854 = var86;
                                 var15.field2855 = var77;
                              }

                              if(var30 == 1416) {
                                 var15.field2792 = var86;
                              }

                              if(var30 == 1417) {
                                 var15.field2858 = var86;
                              }

                              if(var30 == 1418) {
                                 var15.field2885 = var86;
                              }

                              if(var30 == 1419) {
                                 var15.field2860 = var86;
                              }

                              if(1420 == var30) {
                                 var15.field2861 = var86;
                              }

                              if(var30 == 1421) {
                                 var15.field2862 = var86;
                              }

                              if(var30 == 1422) {
                                 var15.field2828 = var86;
                              }

                              if(var30 == 1423) {
                                 var15.field2864 = var86;
                              }

                              if(1424 == var30) {
                                 var15.field2865 = var86;
                              }

                              if(var30 == 1425) {
                                 var15.field2867 = var86;
                              }

                              if(1426 == var30) {
                                 var15.field2868 = var86;
                              }

                              if(var30 == 1427) {
                                 var15.field2879 = var86;
                              }

                              var15.field2837 = true;
                              continue;
                           }

                           if(var30 < 1600) {
                              var15 = var47?class110.field1959:class21.field582;
                              if(1500 == var30) {
                                 class36.field795[var5++] = var15.field2772;
                                 continue;
                              }

                              if(1501 == var30) {
                                 class36.field795[var5++] = var15.field2773;
                                 continue;
                              }

                              if(var30 == 1502) {
                                 class36.field795[var5++] = var15.field2774;
                                 continue;
                              }

                              if(var30 == 1503) {
                                 class36.field795[var5++] = var15.field2890;
                                 continue;
                              }

                              if(1504 == var30) {
                                 class36.field795[var5++] = var15.field2794?1:0;
                                 continue;
                              }

                              if(var30 == 1505) {
                                 class36.field795[var5++] = var15.field2778;
                                 continue;
                              }
                           } else if(var30 < 1700) {
                              var15 = var47?class110.field1959:class21.field582;
                              if(var30 == 1600) {
                                 class36.field795[var5++] = var15.field2829;
                                 continue;
                              }

                              if(var30 == 1601) {
                                 class36.field795[var5++] = var15.field2886;
                                 continue;
                              }

                              if(var30 == 1602) {
                                 class36.field800[var6++] = var15.field2817;
                                 continue;
                              }

                              if(1603 == var30) {
                                 class36.field795[var5++] = var15.field2782;
                                 continue;
                              }

                              if(1604 == var30) {
                                 class36.field795[var5++] = var15.field2783;
                                 continue;
                              }

                              if(var30 == 1605) {
                                 class36.field795[var5++] = var15.field2818;
                                 continue;
                              }

                              if(var30 == 1606) {
                                 class36.field795[var5++] = var15.field2808;
                                 continue;
                              }

                              if(var30 == 1607) {
                                 class36.field795[var5++] = var15.field2810;
                                 continue;
                              }

                              if(1608 == var30) {
                                 class36.field795[var5++] = var15.field2809;
                                 continue;
                              }

                              if(var30 == 1609) {
                                 class36.field795[var5++] = var15.field2753;
                                 continue;
                              }
                           } else if(var30 < 1800) {
                              var15 = var47?class110.field1959:class21.field582;
                              if(1700 == var30) {
                                 class36.field795[var5++] = var15.field2877;
                                 continue;
                              }

                              if(var30 == 1701) {
                                 if(-1 != var15.field2877) {
                                    class36.field795[var5++] = var15.field2878;
                                 } else {
                                    class36.field795[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var30 == 1702) {
                                 class36.field795[var5++] = var15.field2825;
                                 continue;
                              }
                           } else if(var30 < 1900) {
                              var15 = var47?class110.field1959:class21.field582;
                              if(var30 == 1800) {
                                 class36.field795[var5++] = class156.method3118(class42.method898(var15));
                                 continue;
                              }

                              if(1801 == var30) {
                                 --var5;
                                 var16 = class36.field795[var5];
                                 --var16;
                                 if(var15.field2831 != null && var16 < var15.field2831.length && var15.field2831[var16] != null) {
                                    class36.field800[var6++] = var15.field2831[var16];
                                    continue;
                                 }

                                 class36.field800[var6++] = "";
                                 continue;
                              }

                              if(1802 == var30) {
                                 if(null == var15.field2830) {
                                    class36.field800[var6++] = "";
                                 } else {
                                    class36.field800[var6++] = var15.field2830;
                                 }
                                 continue;
                              }
                           } else if(var30 >= 1900 && var30 < 2000 || var30 >= 2900 && var30 < 3000) {
                              if(var30 >= 2000) {
                                 var30 -= 1000;
                                 --var5;
                                 var15 = class31.method698(class36.field795[var5]);
                              } else {
                                 var15 = var47?class110.field1959:class21.field582;
                              }

                              if(var30 == 1927) {
                                 if(class36.field805 * 1542744173 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var15.field2879) {
                                    return;
                                 }

                                 class0 var90 = new class0();
                                 var90.field2 = var15;
                                 var90.field5 = var15.field2879;
                                 var90.field0 = class36.field805 + 1125638501;
                                 client.field465.method3768(var0);
                                 continue;
                              }
                           } else if(var30 < 2600) {
                              --var5;
                              var15 = class31.method698(class36.field795[var5]);
                              if(2500 == var30) {
                                 class36.field795[var5++] = var15.field2772;
                                 continue;
                              }

                              if(var30 == 2501) {
                                 class36.field795[var5++] = var15.field2773;
                                 continue;
                              }

                              if(2502 == var30) {
                                 class36.field795[var5++] = var15.field2774;
                                 continue;
                              }

                              if(var30 == 2503) {
                                 class36.field795[var5++] = var15.field2890;
                                 continue;
                              }

                              if(2504 == var30) {
                                 class36.field795[var5++] = var15.field2794?1:0;
                                 continue;
                              }

                              if(2505 == var30) {
                                 class36.field795[var5++] = var15.field2778;
                                 continue;
                              }
                           } else if(var30 < 2700) {
                              --var5;
                              var15 = class31.method698(class36.field795[var5]);
                              if(2600 == var30) {
                                 class36.field795[var5++] = var15.field2829;
                                 continue;
                              }

                              if(var30 == 2601) {
                                 class36.field795[var5++] = var15.field2886;
                                 continue;
                              }

                              if(var30 == 2602) {
                                 class36.field800[var6++] = var15.field2817;
                                 continue;
                              }

                              if(var30 == 2603) {
                                 class36.field795[var5++] = var15.field2782;
                                 continue;
                              }

                              if(var30 == 2604) {
                                 class36.field795[var5++] = var15.field2783;
                                 continue;
                              }

                              if(2605 == var30) {
                                 class36.field795[var5++] = var15.field2818;
                                 continue;
                              }

                              if(2606 == var30) {
                                 class36.field795[var5++] = var15.field2808;
                                 continue;
                              }

                              if(2607 == var30) {
                                 class36.field795[var5++] = var15.field2810;
                                 continue;
                              }

                              if(var30 == 2608) {
                                 class36.field795[var5++] = var15.field2809;
                                 continue;
                              }

                              if(2609 == var30) {
                                 class36.field795[var5++] = var15.field2753;
                                 continue;
                              }
                           } else if(var30 < 2800) {
                              if(var30 == 2700) {
                                 --var5;
                                 var15 = class31.method698(class36.field795[var5]);
                                 class36.field795[var5++] = var15.field2877;
                                 continue;
                              }

                              if(2701 == var30) {
                                 --var5;
                                 var15 = class31.method698(class36.field795[var5]);
                                 if(-1 != var15.field2877) {
                                    class36.field795[var5++] = var15.field2878;
                                 } else {
                                    class36.field795[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var30 == 2702) {
                                 --var5;
                                 var35 = class36.field795[var5];
                                 class3 var32 = (class3)client.field449.method3744((long)var35);
                                 if(null != var32) {
                                    class36.field795[var5++] = 1;
                                 } else {
                                    class36.field795[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(2706 == var30) {
                                 class36.field795[var5++] = client.field448;
                                 continue;
                              }
                           } else if(var30 < 2900) {
                              --var5;
                              var15 = class31.method698(class36.field795[var5]);
                              if(var30 == 2800) {
                                 class36.field795[var5++] = class156.method3118(class42.method898(var15));
                                 continue;
                              }

                              if(2801 == var30) {
                                 --var5;
                                 var16 = class36.field795[var5];
                                 --var16;
                                 if(null != var15.field2831 && var16 < var15.field2831.length && var15.field2831[var16] != null) {
                                    class36.field800[var6++] = var15.field2831[var16];
                                    continue;
                                 }

                                 class36.field800[var6++] = "";
                                 continue;
                              }

                              if(var30 == 2802) {
                                 if(null == var15.field2830) {
                                    class36.field800[var6++] = "";
                                 } else {
                                    class36.field800[var6++] = var15.field2830;
                                 }
                                 continue;
                              }
                           } else {
                              int var22;
                              int var23;
                              int var48;
                              int var66;
                              if(var30 < 3200) {
                                 if(3100 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class16.method186(0, "", var42);
                                    continue;
                                 }

                                 if(3101 == var30) {
                                    var5 -= 2;
                                    class14.method164(class148.field2249, class36.field795[var5], class36.field795[var5 + 1]);
                                    continue;
                                 }

                                 if(3103 == var30) {
                                    class83.method1868();
                                    continue;
                                 }

                                 boolean var19;
                                 if(3104 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    var16 = 0;
                                    var19 = false;
                                    boolean var44 = false;
                                    var48 = 0;
                                    var22 = var42.length();
                                    var23 = 0;

                                    while(true) {
                                       if(var23 >= var22) {
                                          var40 = var44;
                                          break;
                                       }

                                       label3612: {
                                          char var24 = var42.charAt(var23);
                                          if(0 == var23) {
                                             if(var24 == 45) {
                                                var19 = true;
                                                break label3612;
                                             }

                                             if(var24 == 43) {
                                                break label3612;
                                             }
                                          }

                                          if(var24 >= 48 && var24 <= 57) {
                                             var66 = var24 - 48;
                                          } else if(var24 >= 65 && var24 <= 90) {
                                             var66 = var24 - 55;
                                          } else {
                                             if(var24 < 97 || var24 > 122) {
                                                var40 = false;
                                                break;
                                             }

                                             var66 = var24 - 87;
                                          }

                                          if(var66 >= 10) {
                                             var40 = false;
                                             break;
                                          }

                                          if(var19) {
                                             var66 = -var66;
                                          }

                                          int var25 = var66 + var48 * 10;
                                          if(var48 != var25 / 10) {
                                             var40 = false;
                                             break;
                                          }

                                          var48 = var25;
                                          var44 = true;
                                       }

                                       ++var23;
                                    }

                                    if(var40) {
                                       var16 = class106.method2339(var42);
                                    }

                                    client.field329.method2686(34);
                                    client.field329.method2441(var16);
                                    continue;
                                 }

                                 if(3105 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    client.field329.method2686(221);
                                    client.field329.method2438(var42.length() + 1);
                                    client.field329.method2444(var42);
                                    continue;
                                 }

                                 if(3106 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    client.field329.method2686(118);
                                    client.field329.method2438(var42.length() + 1);
                                    client.field329.method2444(var42);
                                    continue;
                                 }

                                 if(var30 == 3107) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    --var6;
                                    var36 = class36.field800[var6];
                                    var17 = class32.field749;
                                    int[] var39 = class32.field755;
                                    var19 = false;

                                    for(var20 = 0; var20 < var17; ++var20) {
                                       class2 var21 = client.field410[var39[var20]];
                                       if(null != var21 && var21 != class148.field2249 && null != var21.field48 && var21.field48.equalsIgnoreCase(var36)) {
                                          if(1 == var35) {
                                             client.field329.method2686(28);
                                             client.field329.method2622(0);
                                             client.field329.method2484(var39[var20]);
                                          } else if(var35 == 4) {
                                             client.field329.method2686(144);
                                             client.field329.method2484(var39[var20]);
                                             client.field329.method2477(0);
                                          } else if(var35 == 6) {
                                             client.field329.method2686(158);
                                             client.field329.method2440(var39[var20]);
                                             client.field329.method2476(0);
                                          } else if(var35 == 7) {
                                             client.field329.method2686(9);
                                             client.field329.method2476(0);
                                             client.field329.method2564(var39[var20]);
                                          }

                                          var19 = true;
                                          break;
                                       }
                                    }

                                    if(!var19) {
                                       class16.method186(4, "", "Unable to find " + var36);
                                    }
                                    continue;
                                 }

                                 if(3108 == var30) {
                                    var5 -= 3;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    var17 = class36.field795[var5 + 2];
                                    var37 = class31.method698(var17);
                                    class49.method1007(var37, var35, var16);
                                    continue;
                                 }

                                 if(3109 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    var34 = var47?class110.field1959:class21.field582;
                                    class49.method1007(var34, var35, var16);
                                    continue;
                                 }

                                 if(var30 == 3110) {
                                    --var5;
                                    class94.field1617 = class36.field795[var5] == 1;
                                    continue;
                                 }

                                 if(var30 == 3111) {
                                    class36.field795[var5++] = class10.field169.field142?1:0;
                                    continue;
                                 }

                                 if(3112 == var30) {
                                    --var5;
                                    class10.field169.field142 = class36.field795[var5] == 1;
                                    class3.method35();
                                    continue;
                                 }

                                 if(3113 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var38 = class36.field795[var5] == 1;
                                    class164.method3191(var42, var38);
                                    continue;
                                 }

                                 if(var30 == 3115) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    client.field329.method2686(134);
                                    client.field329.method2541(var35);
                                    continue;
                                 }

                                 if(var30 == 3116) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var6 -= 2;
                                    var36 = class36.field800[var6];
                                    var33 = class36.field800[1 + var6];
                                    if(var36.length() <= 500 && var33.length() <= 500) {
                                       client.field329.method2686(44);
                                       client.field329.method2541(1 + class36.method742(var36) + class36.method742(var33));
                                       client.field329.method2476(var35);
                                       client.field329.method2444(var36);
                                       client.field329.method2444(var33);
                                    }
                                    continue;
                                 }
                              } else if(var30 < 3300) {
                                 if(3200 == var30) {
                                    var5 -= 3;
                                    class38.method761(class36.field795[var5], class36.field795[1 + var5], class36.field795[var5 + 2]);
                                    continue;
                                 }

                                 if(3201 == var30) {
                                    --var5;
                                    class18.method190(class36.field795[var5]);
                                    continue;
                                 }

                                 if(3202 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    int var10000 = class36.field795[1 + var5];
                                    if(client.field525 != 0 && var35 != -1) {
                                       class108.method2379(class97.field1669, var35, 0, client.field525, false);
                                       client.field527 = true;
                                    }
                                    continue;
                                 }
                              } else if(var30 < 3400) {
                                 if(var30 == 3300) {
                                    class36.field795[var5++] = client.field394;
                                    continue;
                                 }

                                 if(3301 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class36.field795[var5++] = class6.method94(var35, var16);
                                    continue;
                                 }

                                 if(3302 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = class5.method77(var35, var16);
                                    continue;
                                 }

                                 if(var30 == 3303) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = class12.method153(var35, var16);
                                    continue;
                                 }

                                 if(3304 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var56 = class36.field795;
                                    var17 = var5++;
                                    class50 var45 = (class50)class50.field1108.method3711((long)var35);
                                    class50 var46;
                                    if(null != var45) {
                                       var46 = var45;
                                    } else {
                                       byte[] var50 = class50.field1107.method3214(5, var35);
                                       var45 = new class50();
                                       if(null != var50) {
                                          var45.method1010(new class118(var50));
                                       }

                                       class50.field1108.method3713(var45, (long)var35);
                                       var46 = var45;
                                    }

                                    var56[var17] = var46.field1100;
                                    continue;
                                 }

                                 if(3305 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field424[var35];
                                    continue;
                                 }

                                 if(3306 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field425[var35];
                                    continue;
                                 }

                                 if(var30 == 3307) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field426[var35];
                                    continue;
                                 }

                                 if(3308 == var30) {
                                    var35 = class75.field1386;
                                    var16 = (class148.field2249.field839 >> 7) + class98.field1683;
                                    var17 = (class148.field2249.field848 >> 7) + class92.field1598;
                                    class36.field795[var5++] = var17 + (var16 << 14) + (var35 << 28);
                                    continue;
                                 }

                                 if(var30 == 3309) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = var35 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var30 == 3310) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = var35 >> 28;
                                    continue;
                                 }

                                 if(var30 == 3311) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = var35 & 16383;
                                    continue;
                                 }

                                 if(3312 == var30) {
                                    class36.field795[var5++] = client.field291?1:0;
                                    continue;
                                 }

                                 if(var30 == 3313) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5] + '耀';
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = class6.method94(var35, var16);
                                    continue;
                                 }

                                 if(3314 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5] + '耀';
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = class5.method77(var35, var16);
                                    continue;
                                 }

                                 if(3315 == var30) {
                                    var5 -= 2;
                                    var35 = '耀' + class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = class12.method153(var35, var16);
                                    continue;
                                 }

                                 if(3316 == var30) {
                                    if(client.field455 >= 2) {
                                       class36.field795[var5++] = client.field455;
                                    } else {
                                       class36.field795[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var30 == 3317) {
                                    class36.field795[var5++] = client.field290;
                                    continue;
                                 }

                                 if(var30 == 3318) {
                                    class36.field795[var5++] = client.field286;
                                    continue;
                                 }

                                 if(var30 == 3321) {
                                    class36.field795[var5++] = client.field335;
                                    continue;
                                 }

                                 if(var30 == 3322) {
                                    class36.field795[var5++] = client.field454;
                                    continue;
                                 }

                                 if(3323 == var30) {
                                    if(client.field520) {
                                       class36.field795[var5++] = 1;
                                    } else {
                                       class36.field795[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var30 == 3324) {
                                    class36.field795[var5++] = client.field287;
                                    continue;
                                 }
                              } else if(var30 < 3500) {
                                 if(3400 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class48 var54 = (class48)class48.field1077.method3711((long)var35);
                                    class48 var41;
                                    if(var54 != null) {
                                       var41 = var54;
                                    } else {
                                       byte[] var57 = class48.field1083.method3214(8, var35);
                                       var54 = new class48();
                                       if(var57 != null) {
                                          var54.method985(new class118(var57));
                                       }

                                       class48.field1077.method3713(var54, (long)var35);
                                       var41 = var54;
                                    }

                                    var54 = var41;
                                    if(115 != var41.field1086) {
                                       ;
                                    }

                                    for(var59 = 0; var59 < var54.field1082; ++var59) {
                                       if(var16 == var54.field1079[var59]) {
                                          class36.field800[var6++] = var54.field1085[var59];
                                          var54 = null;
                                          break;
                                       }
                                    }

                                    if(var54 != null) {
                                       class36.field800[var6++] = var54.field1080;
                                    }
                                    continue;
                                 }

                                 if(3408 == var30) {
                                    var5 -= 4;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    var17 = class36.field795[2 + var5];
                                    var51 = class36.field795[var5 + 3];
                                    class48 var52 = (class48)class48.field1077.method3711((long)var17);
                                    class48 var49;
                                    if(null != var52) {
                                       var49 = var52;
                                    } else {
                                       byte[] var55 = class48.field1083.method3214(8, var17);
                                       var52 = new class48();
                                       if(null != var55) {
                                          var52.method985(new class118(var55));
                                       }

                                       class48.field1077.method3713(var52, (long)var17);
                                       var49 = var52;
                                    }

                                    var52 = var49;
                                    if(var35 == var49.field1078 && var16 == var49.field1086) {
                                       for(var48 = 0; var48 < var52.field1082; ++var48) {
                                          if(var51 == var52.field1079[var48]) {
                                             if(115 == var16) {
                                                class36.field800[var6++] = var52.field1085[var48];
                                             } else {
                                                class36.field795[var5++] = var52.field1076[var48];
                                             }

                                             var52 = null;
                                             break;
                                          }
                                       }

                                       if(null != var52) {
                                          if(var16 == 115) {
                                             class36.field800[var6++] = var52.field1080;
                                          } else {
                                             class36.field795[var5++] = var52.field1081;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var16 == 115) {
                                       class36.field800[var6++] = "null";
                                    } else {
                                       class36.field795[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else if(var30 < 3700) {
                                 if(var30 == 3600) {
                                    if(client.field386 == 0) {
                                       class36.field795[var5++] = -2;
                                    } else if(client.field386 == 1) {
                                       class36.field795[var5++] = -1;
                                    } else {
                                       class36.field795[var5++] = client.field421;
                                    }
                                    continue;
                                 }

                                 if(var30 == 3601) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(2 == client.field386 && var35 < client.field421) {
                                       class36.field800[var6++] = client.field557[var35].field253;
                                       class36.field800[var6++] = client.field557[var35].field247;
                                       continue;
                                    }

                                    class36.field800[var6++] = "";
                                    class36.field800[var6++] = "";
                                    continue;
                                 }

                                 if(var30 == 3602) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(client.field386 == 2 && var35 < client.field421) {
                                       class36.field795[var5++] = client.field557[var35].field248;
                                       continue;
                                    }

                                    class36.field795[var5++] = 0;
                                    continue;
                                 }

                                 if(3603 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(2 == client.field386 && var35 < client.field421) {
                                       class36.field795[var5++] = client.field557[var35].field249;
                                       continue;
                                    }

                                    class36.field795[var5++] = 0;
                                    continue;
                                 }

                                 if(var30 == 3604) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    class134.method2807(var42, var16);
                                    continue;
                                 }

                                 if(3605 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class106.method2338(var42);
                                    continue;
                                 }

                                 if(var30 == 3606) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class140.method2923(var42);
                                    continue;
                                 }

                                 if(3607 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class40.method801(var42);
                                    continue;
                                 }

                                 if(3608 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class83.method1865(var42);
                                    continue;
                                 }

                                 if(3609 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class151[] var65 = class175.method3414();

                                    for(var17 = 0; var17 < var65.length; ++var17) {
                                       class151 var63 = var65[var17];
                                       if(var63.field2276 != -1 && var42.startsWith(class18.method198(var63.field2276))) {
                                          var42 = var42.substring(6 + Integer.toString(var63.field2276).length());
                                          break;
                                       }
                                    }

                                    class36.field795[var5++] = class132.method2791(var42, false)?1:0;
                                    continue;
                                 }

                                 if(3611 == var30) {
                                    if(null != client.field515) {
                                       class36.field800[var6++] = class142.method2955(client.field515);
                                    } else {
                                       class36.field800[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(3612 == var30) {
                                    if(client.field515 != null) {
                                       class36.field795[var5++] = class10.field163;
                                    } else {
                                       class36.field795[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var30 == 3613) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(null != client.field515 && var35 < class10.field163) {
                                       class36.field800[var6++] = class135.field2103[var35].field626;
                                       continue;
                                    }

                                    class36.field800[var6++] = "";
                                    continue;
                                 }

                                 if(var30 == 3614) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(null != client.field515 && var35 < class10.field163) {
                                       class36.field795[var5++] = class135.field2103[var35].field620;
                                       continue;
                                    }

                                    class36.field795[var5++] = 0;
                                    continue;
                                 }

                                 if(var30 == 3615) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(null != client.field515 && var35 < class10.field163) {
                                       class36.field795[var5++] = class135.field2103[var35].field622;
                                       continue;
                                    }

                                    class36.field795[var5++] = 0;
                                    continue;
                                 }

                                 if(var30 == 3616) {
                                    class36.field795[var5++] = client.field571;
                                    continue;
                                 }

                                 if(3617 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    if(class135.field2103 != null) {
                                       client.field329.method2686(110);
                                       client.field329.method2438(class36.method742(var42));
                                       client.field329.method2444(var42);
                                    }
                                    continue;
                                 }

                                 if(3618 == var30) {
                                    class36.field795[var5++] = class161.field2653;
                                    continue;
                                 }

                                 if(3619 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class190.method3704(var42);
                                    continue;
                                 }

                                 if(3620 == var30) {
                                    client.field329.method2686(20);
                                    client.field329.method2438(0);
                                    continue;
                                 }

                                 if(3621 == var30) {
                                    if(0 == client.field386) {
                                       class36.field795[var5++] = -1;
                                    } else {
                                       class36.field795[var5++] = client.field559;
                                    }
                                    continue;
                                 }

                                 if(var30 == 3622) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(client.field386 != 0 && var35 < client.field559) {
                                       class36.field800[var6++] = client.field560[var35].field139;
                                       class36.field800[var6++] = client.field560[var35].field136;
                                       continue;
                                    }

                                    class36.field800[var6++] = "";
                                    class36.field800[var6++] = "";
                                    continue;
                                 }

                                 if(3623 == var30) {
                                    label3133: {
                                       --var6;
                                       var42 = class36.field800[var6];
                                       var33 = "<img=0>";
                                       if(!var42.startsWith(var33)) {
                                          String var62 = "<img=1>";
                                          if(!var42.startsWith(var62)) {
                                             break label3133;
                                          }
                                       }

                                       var42 = var42.substring(7);
                                    }

                                    class36.field795[var5++] = class18.method194(var42)?1:0;
                                    continue;
                                 }

                                 if(3624 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    if(class135.field2103 != null && var35 < class10.field163 && class135.field2103[var35].field626.equalsIgnoreCase(class148.field2249.field48)) {
                                       class36.field795[var5++] = 1;
                                       continue;
                                    }

                                    class36.field795[var5++] = 0;
                                    continue;
                                 }

                                 if(3625 == var30) {
                                    if(null != client.field516) {
                                       class36.field800[var6++] = class142.method2955(client.field516);
                                    } else {
                                       class36.field800[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else if(var30 < 4000) {
                                 if(var30 == 3903) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field564[var35].method3929();
                                    continue;
                                 }

                                 if(var30 == 3904) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field564[var35].field3165;
                                    continue;
                                 }

                                 if(3905 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field564[var35].field3169;
                                    continue;
                                 }

                                 if(var30 == 3906) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field564[var35].field3167;
                                    continue;
                                 }

                                 if(3907 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field564[var35].field3168;
                                    continue;
                                 }

                                 if(3908 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = client.field564[var35].field3164;
                                    continue;
                                 }

                                 if(3910 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var16 = client.field564[var35].method3935();
                                    class36.field795[var5++] = var16 == 0?1:0;
                                    continue;
                                 }

                                 if(var30 == 3911) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var16 = client.field564[var35].method3935();
                                    class36.field795[var5++] = var16 == 2?1:0;
                                    continue;
                                 }

                                 if(var30 == 3912) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var16 = client.field564[var35].method3935();
                                    class36.field795[var5++] = var16 == 5?1:0;
                                    continue;
                                 }

                                 if(var30 == 3913) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var16 = client.field564[var35].method3935();
                                    class36.field795[var5++] = var16 == 1?1:0;
                                    continue;
                                 }

                                 boolean var87;
                                 if(var30 == 3914) {
                                    --var5;
                                    var87 = class36.field795[var5] == 1;
                                    if(null != class32.field760) {
                                       class32.field760.method3945(class220.field3173, var87);
                                    }
                                    continue;
                                 }

                                 if(3915 == var30) {
                                    --var5;
                                    var87 = class36.field795[var5] == 1;
                                    if(null != class32.field760) {
                                       class32.field760.method3945(class220.field3171, var87);
                                    }
                                    continue;
                                 }

                                 if(3916 == var30) {
                                    var5 -= 2;
                                    var87 = class36.field795[var5] == 1;
                                    var38 = class36.field795[1 + var5] == 1;
                                    if(class32.field760 != null) {
                                       class32.field760.method3945(new class21(var38), var87);
                                    }
                                    continue;
                                 }

                                 if(var30 == 3917) {
                                    --var5;
                                    var87 = class36.field795[var5] == 1;
                                    if(class32.field760 != null) {
                                       class32.field760.method3945(class220.field3172, var87);
                                    }
                                    continue;
                                 }

                                 if(3918 == var30) {
                                    --var5;
                                    var87 = class36.field795[var5] == 1;
                                    if(null != class32.field760) {
                                       class32.field760.method3945(class220.field3174, var87);
                                    }
                                    continue;
                                 }

                                 if(var30 == 3919) {
                                    class36.field795[var5++] = class32.field760 == null?0:class32.field760.field3170.size();
                                    continue;
                                 }

                                 class213 var70;
                                 if(var30 == 3920) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    class36.field795[var5++] = var70.field3147;
                                    continue;
                                 }

                                 if(3921 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    class36.field800[var6++] = var70.method3882();
                                    continue;
                                 }

                                 if(var30 == 3922) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    class36.field800[var6++] = var70.method3883();
                                    continue;
                                 }

                                 if(3923 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    long var53 = class109.method2381() - class4.field79 - var70.field3143;
                                    var59 = (int)(var53 / 3600000L);
                                    var20 = (int)((var53 - (long)(3600000 * var59)) / 60000L);
                                    var48 = (int)((var53 - (long)(var59 * 3600000) - (long)('\uea60' * var20)) / 1000L);
                                    String var58 = var59 + ":" + var20 / 10 + var20 % 10 + ":" + var48 / 10 + var48 % 10;
                                    class36.field800[var6++] = var58;
                                    continue;
                                 }

                                 if(var30 == 3924) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    class36.field795[var5++] = var70.field3142.field3167;
                                    continue;
                                 }

                                 if(var30 == 3925) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    class36.field795[var5++] = var70.field3142.field3169;
                                    continue;
                                 }

                                 if(var30 == 3926) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var70 = (class213)class32.field760.field3170.get(var35);
                                    class36.field795[var5++] = var70.field3142.field3165;
                                    continue;
                                 }
                              } else if(var30 < 4100) {
                                 if(var30 == 4000) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = var16 + var35;
                                    continue;
                                 }

                                 if(4001 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = var35 - var16;
                                    continue;
                                 }

                                 if(4002 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = var35 * var16;
                                    continue;
                                 }

                                 if(4003 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = var35 / var16;
                                    continue;
                                 }

                                 if(var30 == 4004) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = (int)(Math.random() * (double)var35);
                                    continue;
                                 }

                                 if(var30 == 4005) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = (int)(Math.random() * (double)(1 + var35));
                                    continue;
                                 }

                                 if(4006 == var30) {
                                    var5 -= 5;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    var17 = class36.field795[2 + var5];
                                    var51 = class36.field795[var5 + 3];
                                    var59 = class36.field795[4 + var5];
                                    class36.field795[var5++] = (var59 - var17) * (var16 - var35) / (var51 - var17) + var35;
                                    continue;
                                 }

                                 if(var30 == 4007) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class36.field795[var5++] = var16 * var35 / 100 + var35;
                                    continue;
                                 }

                                 if(var30 == 4008) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = var35 | 1 << var16;
                                    continue;
                                 }

                                 if(4009 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    class36.field795[var5++] = var35 & -1 - (1 << var16);
                                    continue;
                                 }

                                 if(4010 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class36.field795[var5++] = 0 != (var35 & 1 << var16)?1:0;
                                    continue;
                                 }

                                 if(4011 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class36.field795[var5++] = var35 % var16;
                                    continue;
                                 }

                                 if(var30 == 4012) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    if(var35 == 0) {
                                       class36.field795[var5++] = 0;
                                    } else {
                                       class36.field795[var5++] = (int)Math.pow((double)var35, (double)var16);
                                    }
                                    continue;
                                 }

                                 if(var30 == 4013) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[1 + var5];
                                    if(var35 == 0) {
                                       class36.field795[var5++] = 0;
                                    } else if(var16 == 0) {
                                       class36.field795[var5++] = Integer.MAX_VALUE;
                                    } else {
                                       class36.field795[var5++] = (int)Math.pow((double)var35, 1.0D / (double)var16);
                                    }
                                    continue;
                                 }

                                 if(4014 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class36.field795[var5++] = var35 & var16;
                                    continue;
                                 }

                                 if(4015 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class36.field795[var5++] = var35 | var16;
                                    continue;
                                 }
                              } else if(var30 < 4200) {
                                 if(4100 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    class36.field800[var6++] = var42 + var16;
                                    continue;
                                 }

                                 if(4101 == var30) {
                                    var6 -= 2;
                                    var42 = class36.field800[var6];
                                    var36 = class36.field800[1 + var6];
                                    class36.field800[var6++] = var42 + var36;
                                    continue;
                                 }

                                 if(var30 == 4102) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    var68 = class36.field800;
                                    var51 = var6++;
                                    String var64;
                                    if(var16 < 0) {
                                       var64 = Integer.toString(var16);
                                    } else {
                                       var22 = var16;
                                       String var61;
                                       if(var16 < 0) {
                                          var61 = Integer.toString(var16, 10);
                                       } else {
                                          var23 = 2;

                                          for(var66 = var16 / 10; var66 != 0; ++var23) {
                                             var66 /= 10;
                                          }

                                          char[] var73 = new char[var23];
                                          var73[0] = 43;

                                          for(int var26 = var23 - 1; var26 > 0; --var26) {
                                             int var27 = var22;
                                             var22 /= 10;
                                             int var28 = var27 - var22 * 10;
                                             if(var28 >= 10) {
                                                var73[var26] = (char)(var28 + 87);
                                             } else {
                                                var73[var26] = (char)(48 + var28);
                                             }
                                          }

                                          var61 = new String(var73);
                                       }

                                       var64 = var61;
                                    }

                                    var68[var51] = var42 + var64;
                                    continue;
                                 }

                                 if(var30 == 4103) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class36.field800[var6++] = var42.toLowerCase();
                                    continue;
                                 }

                                 if(var30 == 4104) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    long var84 = 86400000L * (11745L + (long)var35);
                                    class36.field803.setTime(new Date(var84));
                                    var51 = class36.field803.get(5);
                                    var59 = class36.field803.get(2);
                                    var20 = class36.field803.get(1);
                                    class36.field800[var6++] = var51 + "-" + class36.field804[var59] + "-" + var20;
                                    continue;
                                 }

                                 if(var30 == 4105) {
                                    var6 -= 2;
                                    var42 = class36.field800[var6];
                                    var36 = class36.field800[1 + var6];
                                    if(null != class148.field2249.field34 && class148.field2249.field34.field2922) {
                                       class36.field800[var6++] = var36;
                                       continue;
                                    }

                                    class36.field800[var6++] = var42;
                                    continue;
                                 }

                                 if(var30 == 4106) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field800[var6++] = Integer.toString(var35);
                                    continue;
                                 }

                                 if(4107 == var30) {
                                    var6 -= 2;
                                    class36.field795[var5++] = class0.method3(class18.method193(class36.field800[var6], class36.field800[1 + var6]));
                                    continue;
                                 }

                                 class223 var69;
                                 byte[] var72;
                                 if(4108 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    var5 -= 2;
                                    var16 = class36.field795[var5];
                                    var17 = class36.field795[1 + var5];
                                    var72 = class182.field2958.method3214(var17, 0);
                                    var69 = new class223(var72);
                                    class36.field795[var5++] = var69.method3965(var42, var16);
                                    continue;
                                 }

                                 if(4109 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    var5 -= 2;
                                    var16 = class36.field795[var5];
                                    var17 = class36.field795[1 + var5];
                                    var72 = class182.field2958.method3214(var17, 0);
                                    var69 = new class223(var72);
                                    class36.field795[var5++] = var69.method3964(var42, var16);
                                    continue;
                                 }

                                 if(4110 == var30) {
                                    var6 -= 2;
                                    var42 = class36.field800[var6];
                                    var36 = class36.field800[1 + var6];
                                    --var5;
                                    if(class36.field795[var5] == 1) {
                                       class36.field800[var6++] = var42;
                                    } else {
                                       class36.field800[var6++] = var36;
                                    }
                                    continue;
                                 }

                                 if(var30 == 4111) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    class36.field800[var6++] = class222.method3966(var42);
                                    continue;
                                 }

                                 if(var30 == 4112) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    class36.field800[var6++] = var42 + (char)var16;
                                    continue;
                                 }

                                 if(var30 == 4113) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class13.method159((char)var35)?1:0;
                                    continue;
                                 }

                                 if(var30 == 4114) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class101.method2245((char)var35)?1:0;
                                    continue;
                                 }

                                 if(4115 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class147.method3085((char)var35)?1:0;
                                    continue;
                                 }

                                 if(4116 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class47.method980((char)var35)?1:0;
                                    continue;
                                 }

                                 if(4117 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    if(null != var42) {
                                       class36.field795[var5++] = var42.length();
                                    } else {
                                       class36.field795[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(4118 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    var5 -= 2;
                                    var16 = class36.field795[var5];
                                    var17 = class36.field795[var5 + 1];
                                    class36.field800[var6++] = var42.substring(var16, var17);
                                    continue;
                                 }

                                 if(var30 == 4119) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    StringBuilder var83 = new StringBuilder(var42.length());
                                    var60 = false;

                                    for(var51 = 0; var51 < var42.length(); ++var51) {
                                       char var67 = var42.charAt(var51);
                                       if(var67 == 60) {
                                          var60 = true;
                                       } else if(var67 == 62) {
                                          var60 = false;
                                       } else if(!var60) {
                                          var83.append(var67);
                                       }
                                    }

                                    class36.field800[var6++] = var83.toString();
                                    continue;
                                 }

                                 if(var30 == 4120) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    class36.field795[var5++] = var42.indexOf(var16);
                                    continue;
                                 }

                                 if(var30 == 4121) {
                                    var6 -= 2;
                                    var42 = class36.field800[var6];
                                    var36 = class36.field800[1 + var6];
                                    --var5;
                                    var17 = class36.field795[var5];
                                    class36.field795[var5++] = var42.indexOf(var36, var17);
                                    continue;
                                 }
                              } else if(var30 < 4300) {
                                 if(4200 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field800[var6++] = class22.method581(var35).field1121;
                                    continue;
                                 }

                                 class51 var71;
                                 if(4201 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    var71 = class22.method581(var35);
                                    if(var16 >= 1 && var16 <= 5 && var71.field1135[var16 - 1] != null) {
                                       class36.field800[var6++] = var71.field1135[var16 - 1];
                                       continue;
                                    }

                                    class36.field800[var6++] = "";
                                    continue;
                                 }

                                 if(4202 == var30) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    var71 = class22.method581(var35);
                                    if(var16 >= 1 && var16 <= 5 && var71.field1136[var16 - 1] != null) {
                                       class36.field800[var6++] = var71.field1136[var16 - 1];
                                       continue;
                                    }

                                    class36.field800[var6++] = "";
                                    continue;
                                 }

                                 if(var30 == 4203) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class22.method581(var35).field1133;
                                    continue;
                                 }

                                 if(4204 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class22.method581(var35).field1134 == 1?1:0;
                                    continue;
                                 }

                                 class51 var88;
                                 if(var30 == 4205) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var88 = class22.method581(var35);
                                    if(-1 == var88.field1152 && var88.field1148 >= 0) {
                                       class36.field795[var5++] = var88.field1148;
                                       continue;
                                    }

                                    class36.field795[var5++] = var35;
                                    continue;
                                 }

                                 if(4206 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var88 = class22.method581(var35);
                                    if(var88.field1152 >= 0 && var88.field1148 >= 0) {
                                       class36.field795[var5++] = var88.field1148;
                                       continue;
                                    }

                                    class36.field795[var5++] = var35;
                                    continue;
                                 }

                                 if(var30 == 4207) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class22.method581(var35).field1114?1:0;
                                    continue;
                                 }

                                 if(4210 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    class112.method2390(var42, var16 == 1);
                                    class36.field795[var5++] = class213.field3145;
                                    continue;
                                 }

                                 if(var30 == 4211) {
                                    if(null != class15.field224 && class36.field798 < class213.field3145) {
                                       class36.field795[var5++] = class15.field224[++class36.field798 - 1] & '\uffff';
                                       continue;
                                    }

                                    class36.field795[var5++] = -1;
                                    continue;
                                 }

                                 if(var30 == 4212) {
                                    class36.field798 = 0;
                                    continue;
                                 }
                              } else if(var30 < 5100) {
                                 if(5000 == var30) {
                                    class36.field795[var5++] = client.field506;
                                    continue;
                                 }

                                 if(var30 == 5001) {
                                    var5 -= 3;
                                    client.field506 = class36.field795[var5];
                                    class51.field1143 = class36.method748(class36.field795[1 + var5]);
                                    if(null == class51.field1143) {
                                       class51.field1143 = class129.field2061;
                                    }

                                    client.field507 = class36.field795[var5 + 2];
                                    client.field329.method2686(191);
                                    client.field329.method2438(client.field506);
                                    client.field329.method2438(class51.field1143.field2063);
                                    client.field329.method2438(client.field507);
                                    continue;
                                 }

                                 if(5002 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    var5 -= 2;
                                    var16 = class36.field795[var5];
                                    var17 = class36.field795[1 + var5];
                                    client.field329.method2686(94);
                                    client.field329.method2438(class36.method742(var42) + 2);
                                    client.field329.method2444(var42);
                                    client.field329.method2438(var16 - 1);
                                    client.field329.method2438(var17);
                                    continue;
                                 }

                                 if(var30 == 5003) {
                                    var5 -= 2;
                                    var35 = class36.field795[var5];
                                    var16 = class36.field795[var5 + 1];
                                    class27 var85 = (class27)class11.field174.get(Integer.valueOf(var35));
                                    class35 var76 = var85.method643(var16);
                                    if(var76 != null) {
                                       class36.field795[var5++] = var76.field789;
                                       class36.field795[var5++] = var76.field780;
                                       class36.field800[var6++] = var76.field783 != null?var76.field783:"";
                                       class36.field800[var6++] = var76.field784 != null?var76.field784:"";
                                       class36.field800[var6++] = null != var76.field785?var76.field785:"";
                                    } else {
                                       class36.field795[var5++] = -1;
                                       class36.field795[var5++] = 0;
                                       class36.field800[var6++] = "";
                                       class36.field800[var6++] = "";
                                       class36.field800[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var30 == 5004) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class35 var89 = (class35)class11.field172.method3761((long)var35);
                                    if(null != var89) {
                                       class36.field795[var5++] = var89.field781;
                                       class36.field795[var5++] = var89.field780;
                                       class36.field800[var6++] = null != var89.field783?var89.field783:"";
                                       class36.field800[var6++] = var89.field784 != null?var89.field784:"";
                                       class36.field800[var6++] = null != var89.field785?var89.field785:"";
                                    } else {
                                       class36.field795[var5++] = -1;
                                       class36.field795[var5++] = 0;
                                       class36.field800[var6++] = "";
                                       class36.field800[var6++] = "";
                                       class36.field800[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(5005 == var30) {
                                    if(class51.field1143 == null) {
                                       class36.field795[var5++] = -1;
                                    } else {
                                       class36.field795[var5++] = class51.field1143.field2063;
                                    }
                                    continue;
                                 }

                                 if(5008 == var30) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    --var5;
                                    var16 = class36.field795[var5];
                                    var33 = var42.toLowerCase();
                                    byte var78 = 0;
                                    if(var33.startsWith("yellow:")) {
                                       var78 = 0;
                                       var42 = var42.substring("yellow:".length());
                                    } else if(var33.startsWith("red:")) {
                                       var78 = 1;
                                       var42 = var42.substring("red:".length());
                                    } else if(var33.startsWith("green:")) {
                                       var78 = 2;
                                       var42 = var42.substring("green:".length());
                                    } else if(var33.startsWith("cyan:")) {
                                       var78 = 3;
                                       var42 = var42.substring("cyan:".length());
                                    } else if(var33.startsWith("purple:")) {
                                       var78 = 4;
                                       var42 = var42.substring("purple:".length());
                                    } else if(var33.startsWith("white:")) {
                                       var78 = 5;
                                       var42 = var42.substring("white:".length());
                                    } else if(var33.startsWith("flash1:")) {
                                       var78 = 6;
                                       var42 = var42.substring("flash1:".length());
                                    } else if(var33.startsWith("flash2:")) {
                                       var78 = 7;
                                       var42 = var42.substring("flash2:".length());
                                    } else if(var33.startsWith("flash3:")) {
                                       var78 = 8;
                                       var42 = var42.substring("flash3:".length());
                                    } else if(var33.startsWith("glow1:")) {
                                       var78 = 9;
                                       var42 = var42.substring("glow1:".length());
                                    } else if(var33.startsWith("glow2:")) {
                                       var78 = 10;
                                       var42 = var42.substring("glow2:".length());
                                    } else if(var33.startsWith("glow3:")) {
                                       var78 = 11;
                                       var42 = var42.substring("glow3:".length());
                                    } else if(client.field472 != 0) {
                                       if(var33.startsWith("yellow:")) {
                                          var78 = 0;
                                          var42 = var42.substring("yellow:".length());
                                       } else if(var33.startsWith("red:")) {
                                          var78 = 1;
                                          var42 = var42.substring("red:".length());
                                       } else if(var33.startsWith("green:")) {
                                          var78 = 2;
                                          var42 = var42.substring("green:".length());
                                       } else if(var33.startsWith("cyan:")) {
                                          var78 = 3;
                                          var42 = var42.substring("cyan:".length());
                                       } else if(var33.startsWith("purple:")) {
                                          var78 = 4;
                                          var42 = var42.substring("purple:".length());
                                       } else if(var33.startsWith("white:")) {
                                          var78 = 5;
                                          var42 = var42.substring("white:".length());
                                       } else if(var33.startsWith("flash1:")) {
                                          var78 = 6;
                                          var42 = var42.substring("flash1:".length());
                                       } else if(var33.startsWith("flash2:")) {
                                          var78 = 7;
                                          var42 = var42.substring("flash2:".length());
                                       } else if(var33.startsWith("flash3:")) {
                                          var78 = 8;
                                          var42 = var42.substring("flash3:".length());
                                       } else if(var33.startsWith("glow1:")) {
                                          var78 = 9;
                                          var42 = var42.substring("glow1:".length());
                                       } else if(var33.startsWith("glow2:")) {
                                          var78 = 10;
                                          var42 = var42.substring("glow2:".length());
                                       } else if(var33.startsWith("glow3:")) {
                                          var78 = 11;
                                          var42 = var42.substring("glow3:".length());
                                       }
                                    }

                                    var33 = var42.toLowerCase();
                                    byte var75 = 0;
                                    if(var33.startsWith("wave:")) {
                                       var75 = 1;
                                       var42 = var42.substring("wave:".length());
                                    } else if(var33.startsWith("wave2:")) {
                                       var75 = 2;
                                       var42 = var42.substring("wave2:".length());
                                    } else if(var33.startsWith("shake:")) {
                                       var75 = 3;
                                       var42 = var42.substring("shake:".length());
                                    } else if(var33.startsWith("scroll:")) {
                                       var75 = 4;
                                       var42 = var42.substring("scroll:".length());
                                    } else if(var33.startsWith("slide:")) {
                                       var75 = 5;
                                       var42 = var42.substring("slide:".length());
                                    } else if(0 != client.field472) {
                                       if(var33.startsWith("wave:")) {
                                          var75 = 1;
                                          var42 = var42.substring("wave:".length());
                                       } else if(var33.startsWith("wave2:")) {
                                          var75 = 2;
                                          var42 = var42.substring("wave2:".length());
                                       } else if(var33.startsWith("shake:")) {
                                          var75 = 3;
                                          var42 = var42.substring("shake:".length());
                                       } else if(var33.startsWith("scroll:")) {
                                          var75 = 4;
                                          var42 = var42.substring("scroll:".length());
                                       } else if(var33.startsWith("slide:")) {
                                          var75 = 5;
                                          var42 = var42.substring("slide:".length());
                                       }
                                    }

                                    client.field329.method2686(162);
                                    client.field329.method2438(0);
                                    var20 = client.field329.field1998;
                                    client.field329.method2438(var16);
                                    client.field329.method2438(var78);
                                    client.field329.method2438(var75);
                                    class177.method3431(client.field329, var42);
                                    client.field329.method2450(client.field329.field1998 - var20);
                                    continue;
                                 }

                                 if(var30 == 5009) {
                                    var6 -= 2;
                                    var42 = class36.field800[var6];
                                    var36 = class36.field800[var6 + 1];
                                    client.field329.method2686(177);
                                    client.field329.method2541(0);
                                    var17 = client.field329.field1998;
                                    client.field329.method2444(var42);
                                    class177.method3431(client.field329, var36);
                                    client.field329.method2514(client.field329.field1998 - var17);
                                    continue;
                                 }

                                 if(5015 == var30) {
                                    if(class148.field2249 != null && class148.field2249.field48 != null) {
                                       var42 = class148.field2249.field48;
                                    } else {
                                       var42 = "";
                                    }

                                    class36.field800[var6++] = var42;
                                    continue;
                                 }

                                 if(var30 == 5016) {
                                    class36.field795[var5++] = client.field507;
                                    continue;
                                 }

                                 if(5017 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class139.method2893(var35);
                                    continue;
                                 }

                                 if(5018 == var30) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    var56 = class36.field795;
                                    var17 = var5++;
                                    class35 var74 = (class35)class11.field172.method3761((long)var35);
                                    if(var74 == null) {
                                       var51 = -1;
                                    } else if(var74.field3100 == class11.field173.field3096) {
                                       var51 = -1;
                                    } else {
                                       var51 = ((class35)var74.field3100).field789;
                                    }

                                    var56[var17] = var51;
                                    continue;
                                 }

                                 if(var30 == 5019) {
                                    --var5;
                                    var35 = class36.field795[var5];
                                    class36.field795[var5++] = class16.method182(var35);
                                    continue;
                                 }

                                 if(var30 == 5020) {
                                    --var6;
                                    var42 = class36.field800[var6];
                                    if(var42.equalsIgnoreCase("toggleroof")) {
                                       class10.field169.field142 = !class10.field169.field142;
                                       class3.method35();
                                       if(class10.field169.field142) {
                                          class16.method186(99, "", "Roofs are now all hidden");
                                       } else {
                                          class16.method186(99, "", "Roofs will only be removed selectively");
                                       }
                                    }

                                    if(var42.equalsIgnoreCase("displayfps")) {
                                       client.field303 = !client.field303;
                                    }

                                    if(client.field455 >= 2) {
                                       if(var42.equalsIgnoreCase("fpson")) {
                                          client.field303 = true;
                                       }

                                       if(var42.equalsIgnoreCase("fpsoff")) {
                                          client.field303 = false;
                                       }

                                       if(var42.equalsIgnoreCase("gc")) {
                                          System.gc();
                                       }

                                       if(var42.equalsIgnoreCase("clientdrop")) {
                                          class21.method570();
                                       }

                                       if(var42.equalsIgnoreCase("errortest") && 2 == client.field288) {
                                          throw new RuntimeException();
                                       }
                                    }

                                    client.field329.method2686(5);
                                    client.field329.method2438(var42.length() + 1);
                                    client.field329.method2444(var42);
                                    continue;
                                 }

                                 if(var30 == 5021) {
                                    --var6;
                                    client.field508 = class36.field800[var6].toLowerCase().trim();
                                    continue;
                                 }

                                 if(5022 == var30) {
                                    class36.field800[var6++] = client.field508;
                                    continue;
                                 }
                              }
                           }
                        }
                     } else {
                        if(var30 >= 2000) {
                           var30 -= 1000;
                           --var5;
                           var15 = class31.method698(class36.field795[var5]);
                        } else {
                           var15 = var47?class110.field1959:class21.field582;
                        }

                        class114.method2400(var15);
                        if(1200 == var30 || 1205 == var30 || var30 == 1212) {
                           var5 -= 2;
                           var16 = class36.field795[var5];
                           var17 = class36.field795[1 + var5];
                           var15.field2877 = var16;
                           var15.field2878 = var17;
                           class51 var18 = class22.method581(var16);
                           var15.field2808 = var18.field1127;
                           var15.field2809 = var18.field1128;
                           var15.field2810 = var18.field1142;
                           var15.field2770 = var18.field1130;
                           var15.field2839 = var18.field1163;
                           var15.field2818 = var18.field1126;
                           if(1205 == var30) {
                              var15.field2815 = 0;
                           } else if(var30 == 1212 | var18.field1134 == 1) {
                              var15.field2815 = 1;
                           } else {
                              var15.field2815 = 2;
                           }

                           if(var15.field2812 > 0) {
                              var15.field2818 = var15.field2818 * 32 / var15.field2812;
                           } else if(var15.field2781 > 0) {
                              var15.field2818 = var15.field2818 * 32 / var15.field2781;
                           }
                           continue;
                        }

                        if(var30 == 1201) {
                           var15.field2800 = 2;
                           --var5;
                           var15.field2857 = class36.field795[var5];
                           continue;
                        }

                        if(var30 == 1202) {
                           var15.field2800 = 3;
                           var15.field2857 = class148.field2249.field34.method3445();
                           continue;
                        }
                     }
                  }
               }

               if(var30 < 5400) {
                  if(var30 == 5306) {
                     class36.field795[var5++] = class97.method2167();
                     continue;
                  }

                  if(var30 == 5307) {
                     --var5;
                     var35 = class36.field795[var5];
                     if(1 != var35 && 2 != var35) {
                        continue;
                     }

                     client.field501 = 0L;
                     if(var35 >= 2) {
                        client.field382 = true;
                     } else {
                        client.field382 = false;
                     }

                     class41.method860();
                     if(client.field295 >= 25) {
                        client.field329.method2686(179);
                        client.field329.method2438(class97.method2167());
                        client.field329.method2541(class142.field2190);
                        client.field329.method2541(class89.field1566);
                     }

                     class143.field2210 = true;
                     continue;
                  }

                  if(5308 == var30) {
                     class36.field795[var5++] = class10.field169.field144;
                     continue;
                  }

                  if(5309 == var30) {
                     --var5;
                     var35 = class36.field795[var5];
                     if(var35 == 1 || 2 == var35) {
                        class10.field169.field144 = var35;
                        class3.method35();
                     }
                     continue;
                  }
               }

               if(var30 < 5600) {
                  if(var30 == 5504) {
                     var5 -= 2;
                     var35 = class36.field795[var5];
                     var16 = class36.field795[var5 + 1];
                     if(!client.field528) {
                        client.field555 = var35;
                        client.field374 = var16;
                     }
                     continue;
                  }

                  if(5505 == var30) {
                     class36.field795[var5++] = client.field555;
                     continue;
                  }

                  if(5506 == var30) {
                     class36.field795[var5++] = client.field374;
                     continue;
                  }

                  if(5530 == var30) {
                     --var5;
                     var35 = class36.field795[var5];
                     if(var35 < 0) {
                        var35 = 0;
                     }

                     client.field379 = var35;
                     continue;
                  }

                  if(5531 == var30) {
                     class36.field795[var5++] = client.field379;
                     continue;
                  }
               }

               if(var30 < 5700 && 5630 == var30) {
                  client.field339 = 250;
               } else {
                  if(var30 < 6300) {
                     if(var30 == 6200) {
                        var5 -= 2;
                        client.field370 = (short)class36.field795[var5];
                        if(client.field370 <= 0) {
                           client.field370 = 256;
                        }

                        client.field404 = (short)class36.field795[var5 + 1];
                        if(client.field404 <= 0) {
                           client.field404 = 205;
                        }
                        continue;
                     }

                     if(6201 == var30) {
                        var5 -= 2;
                        client.field544 = (short)class36.field795[var5];
                        if(client.field544 <= 0) {
                           client.field544 = 256;
                        }

                        client.field545 = (short)class36.field795[var5 + 1];
                        if(client.field545 <= 0) {
                           client.field545 = 320;
                        }
                        continue;
                     }

                     if(var30 == 6202) {
                        var5 -= 4;
                        client.field462 = (short)class36.field795[var5];
                        if(client.field462 <= 0) {
                           client.field462 = 1;
                        }

                        client.field547 = (short)class36.field795[1 + var5];
                        if(client.field547 <= 0) {
                           client.field547 = 32767;
                        } else if(client.field547 < client.field462) {
                           client.field547 = client.field462;
                        }

                        client.field548 = (short)class36.field795[2 + var5];
                        if(client.field548 <= 0) {
                           client.field548 = 1;
                        }

                        client.field549 = (short)class36.field795[var5 + 3];
                        if(client.field549 <= 0) {
                           client.field549 = 32767;
                        } else if(client.field549 < client.field548) {
                           client.field549 = client.field548;
                        }
                        continue;
                     }

                     if(6203 == var30) {
                        if(client.field460 != null) {
                           class174.method3407(0, 0, client.field460.field2774, client.field460.field2890, false);
                           class36.field795[var5++] = client.field552;
                           class36.field795[var5++] = client.field553;
                        } else {
                           class36.field795[var5++] = -1;
                           class36.field795[var5++] = -1;
                        }
                        continue;
                     }

                     if(var30 == 6204) {
                        class36.field795[var5++] = client.field544;
                        class36.field795[var5++] = client.field545;
                        continue;
                     }

                     if(6205 == var30) {
                        class36.field795[var5++] = client.field370;
                        class36.field795[var5++] = client.field404;
                        continue;
                     }
                  }

                  if(var30 < 6600) {
                     if(var30 == 6500) {
                        class36.field795[var5++] = class86.method2051()?1:0;
                        continue;
                     }

                     class25 var94;
                     if(6501 == var30) {
                        var94 = class9.method122();
                        if(var94 != null) {
                           class36.field795[var5++] = var94.field637;
                           class36.field795[var5++] = var94.field638;
                           class36.field800[var6++] = var94.field641;
                           class36.field795[var5++] = var94.field635;
                           class36.field795[var5++] = var94.field639;
                           class36.field800[var6++] = var94.field640;
                        } else {
                           class36.field795[var5++] = -1;
                           class36.field795[var5++] = 0;
                           class36.field800[var6++] = "";
                           class36.field795[var5++] = 0;
                           class36.field795[var5++] = 0;
                           class36.field800[var6++] = "";
                        }
                        continue;
                     }

                     if(6502 == var30) {
                        var94 = class83.method1867();
                        if(var94 != null) {
                           class36.field795[var5++] = var94.field637;
                           class36.field795[var5++] = var94.field638;
                           class36.field800[var6++] = var94.field641;
                           class36.field795[var5++] = var94.field635;
                           class36.field795[var5++] = var94.field639;
                           class36.field800[var6++] = var94.field640;
                        } else {
                           class36.field795[var5++] = -1;
                           class36.field795[var5++] = 0;
                           class36.field800[var6++] = "";
                           class36.field795[var5++] = 0;
                           class36.field795[var5++] = 0;
                           class36.field800[var6++] = "";
                        }
                        continue;
                     }

                     class25 var92;
                     if(6506 == var30) {
                        --var5;
                        var35 = class36.field795[var5];
                        var92 = null;

                        for(var17 = 0; var17 < class25.field633; ++var17) {
                           if(class25.field632[var17].field637 == var35) {
                              var92 = class25.field632[var17];
                              break;
                           }
                        }

                        if(null != var92) {
                           class36.field795[var5++] = var92.field637;
                           class36.field795[var5++] = var92.field638;
                           class36.field800[var6++] = var92.field641;
                           class36.field795[var5++] = var92.field635;
                           class36.field795[var5++] = var92.field639;
                           class36.field800[var6++] = var92.field640;
                        } else {
                           class36.field795[var5++] = -1;
                           class36.field795[var5++] = 0;
                           class36.field800[var6++] = "";
                           class36.field795[var5++] = 0;
                           class36.field795[var5++] = 0;
                           class36.field800[var6++] = "";
                        }
                        continue;
                     }

                     if(6507 == var30) {
                        var5 -= 4;
                        var35 = class36.field795[var5];
                        var38 = class36.field795[1 + var5] == 1;
                        var17 = class36.field795[2 + var5];
                        var40 = class36.field795[3 + var5] == 1;
                        class59.method1268(var35, var38, var17, var40);
                        continue;
                     }

                     if(var30 == 6511) {
                        --var5;
                        var35 = class36.field795[var5];
                        if(var35 >= 0 && var35 < class25.field633) {
                           var92 = class25.field632[var35];
                           class36.field795[var5++] = var92.field637;
                           class36.field795[var5++] = var92.field638;
                           class36.field800[var6++] = var92.field641;
                           class36.field795[var5++] = var92.field635;
                           class36.field795[var5++] = var92.field639;
                           class36.field800[var6++] = var92.field640;
                           continue;
                        }

                        class36.field795[var5++] = -1;
                        class36.field795[var5++] = 0;
                        class36.field800[var6++] = "";
                        class36.field795[var5++] = 0;
                        class36.field795[var5++] = 0;
                        class36.field800[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var29) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3112).append(" ");

            for(var13 = class36.field801 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field794[var13].field212.field3112).append(" ");
            }

            var12.append("").append(var10);
            class16.method184(var12.toString(), var29);
         }
      }
   }
}

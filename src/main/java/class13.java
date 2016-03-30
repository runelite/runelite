import java.awt.Desktop;
import java.awt.FontMetrics;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class13 implements Runnable {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1804891845
   )
   int field206 = 0;
   @ObfuscatedName("x")
   Object field207 = new Object();
   @ObfuscatedName("p")
   int[] field209 = new int[500];
   @ObfuscatedName("e")
   int[] field210 = new int[500];
   @ObfuscatedName("bf")
   protected static FontMetrics field212;
   @ObfuscatedName("d")
   public static class119 field213;
   @ObfuscatedName("w")
   boolean field215 = true;

   @ObfuscatedName("x")
   static void method160(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != class25.field645[var5]) {
            var2[var4] = class25.field645[var5];
            var3[var4] = class25.field644[var5];
            ++var4;
         }
      }

      class25.field645 = var2;
      class25.field644 = var3;
      class15.method176(class189.field3062, 0, class189.field3062.length - 1, class25.field645, class25.field644);
   }

   public void run() {
      for(; this.field215; class104.method2291(50L)) {
         Object var1 = this.field207;
         synchronized(this.field207) {
            if(this.field206 < 500) {
               this.field209[this.field206] = class140.field2168;
               this.field210[this.field206] = class140.field2182;
               ++this.field206;
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "139896927"
   )
   static void method161(class0 var0, int var1) {
      Object[] var2 = var0.field7;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class126.method2819(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field597;
         int[] var9 = var4.field599;
         byte var10 = -1;
         class36.field812 = 0;

         int var13;
         try {
            class36.field800 = new int[var4.field603];
            int var11 = 0;
            class36.field801 = new String[var4.field598];
            int var31 = 0;

            int var14;
            String var43;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(-2147483647 == var14) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field0;
                  }

                  if(-2147483645 == var14) {
                     var14 = var0.field2 != null?var0.field2.field2838:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field5;
                  }

                  if(-2147483643 == var14) {
                     var14 = var0.field2 != null?var0.field2.field2802:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field6?var0.field6.field2838:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.field2802:-1;
                  }

                  if(-2147483640 == var14) {
                     var14 = var0.field19;
                  }

                  if(-2147483639 == var14) {
                     var14 = var0.field8;
                  }

                  class36.field800[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var43 = (String)var2[var13];
                  if(var43.equals("event_opbase")) {
                     var43 = var0.field9;
                  }

                  class36.field801[var31++] = var43;
               }
            }

            var13 = 0;
            class36.field806 = var0.field10;

            label3873:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var30 = var8[var7];
               int var15;
               int var18;
               int var19;
               int var20;
               int var33;
               String var34;
               int var36;
               int[] var44;
               String var52;
               String var55;
               byte[] var59;
               String var67;
               int var74;
               if(var30 < 100) {
                  if(0 == var30) {
                     class36.field804[var5++] = var9[var7];
                     continue;
                  }

                  if(1 == var30) {
                     var14 = var9[var7];
                     class36.field804[var5++] = class176.field2916[var14];
                     continue;
                  }

                  if(2 == var30) {
                     var14 = var9[var7];
                     --var5;
                     class176.field2916[var14] = class36.field804[var5];
                     class95.method2184(var14);
                     continue;
                  }

                  if(3 == var30) {
                     class36.field816[var6++] = var4.field600[var7];
                     continue;
                  }

                  if(6 == var30) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(7 == var30) {
                     var5 -= 2;
                     if(class36.field804[var5] != class36.field804[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var30 == 8) {
                     var5 -= 2;
                     if(class36.field804[var5] == class36.field804[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(9 == var30) {
                     var5 -= 2;
                     if(class36.field804[var5] < class36.field804[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(10 == var30) {
                     var5 -= 2;
                     if(class36.field804[var5] > class36.field804[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(21 == var30) {
                     if(class36.field812 == 0) {
                        return;
                     }

                     class14 var88 = class36.field808[--class36.field812];
                     var4 = var88.field226;
                     var8 = var4.field597;
                     var9 = var4.field599;
                     var7 = var88.field223;
                     class36.field800 = var88.field221;
                     class36.field801 = var88.field222;
                     continue;
                  }

                  if(25 == var30) {
                     var14 = var9[var7];
                     class36.field804[var5++] = class152.method3179(var14);
                     continue;
                  }

                  if(27 == var30) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field804[var5];
                     class47 var98 = (class47)class47.field1079.method3771((long)var14);
                     class47 var108;
                     if(null != var98) {
                        var108 = var98;
                     } else {
                        var59 = class47.field1083.method3335(14, var14);
                        var98 = new class47();
                        if(null != var59) {
                           var98.method1011(new class119(var59));
                        }

                        class47.field1079.method3773(var98, (long)var14);
                        var108 = var98;
                     }

                     var18 = var108.field1085;
                     var19 = var108.field1081;
                     var20 = var108.field1082;
                     var74 = class176.field2918[var20 - var19];
                     if(var15 < 0 || var15 > var74) {
                        var15 = 0;
                     }

                     var74 <<= var19;
                     class176.field2916[var18] = class176.field2916[var18] & ~var74 | var15 << var19 & var74;
                     continue;
                  }

                  if(31 == var30) {
                     var5 -= 2;
                     if(class36.field804[var5] <= class36.field804[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(32 == var30) {
                     var5 -= 2;
                     if(class36.field804[var5] >= class36.field804[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var30 == 33) {
                     class36.field804[var5++] = class36.field800[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var30 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field800[var10001] = class36.field804[var5];
                     continue;
                  }

                  if(var30 == 35) {
                     class36.field816[var6++] = class36.field801[var9[var7]];
                     continue;
                  }

                  if(36 == var30) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field801[var10001] = class36.field816[var6];
                     continue;
                  }

                  if(var30 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var107 = class36.field816;
                     if(0 == var14) {
                        var52 = "";
                     } else if(1 == var14) {
                        var34 = var107[var6];
                        if(var34 == null) {
                           var52 = "null";
                        } else {
                           var52 = var34.toString();
                        }
                     } else {
                        var33 = var14 + var6;
                        var18 = 0;

                        for(var19 = var6; var19 < var33; ++var19) {
                           var55 = var107[var19];
                           if(var55 == null) {
                              var18 += 4;
                           } else {
                              var18 += var55.length();
                           }
                        }

                        StringBuilder var93 = new StringBuilder(var18);

                        for(var20 = var6; var20 < var33; ++var20) {
                           var67 = var107[var20];
                           if(null == var67) {
                              var93.append("null");
                           } else {
                              var93.append(var67);
                           }
                        }

                        var52 = var93.toString();
                     }

                     class36.field816[var6++] = var52;
                     continue;
                  }

                  if(38 == var30) {
                     --var5;
                     continue;
                  }

                  if(39 == var30) {
                     --var6;
                     continue;
                  }

                  if(var30 == 40) {
                     var14 = var9[var7];
                     class22 var111 = class126.method2819(var14);
                     var44 = new int[var111.field603];
                     String[] var95 = new String[var111.field598];

                     for(var18 = 0; var18 < var111.field602; ++var18) {
                        var44[var18] = class36.field804[var18 + (var5 - var111.field602)];
                     }

                     for(var18 = 0; var18 < var111.field604; ++var18) {
                        var95[var18] = class36.field816[var6 - var111.field604 + var18];
                     }

                     var5 -= var111.field602;
                     var6 -= var111.field604;
                     class14 var106 = new class14();
                     var106.field226 = var4;
                     var106.field223 = var7;
                     var106.field221 = class36.field800;
                     var106.field222 = class36.field801;
                     class36.field808[++class36.field812 - 1] = var106;
                     var4 = var111;
                     var8 = var111.field597;
                     var9 = var111.field599;
                     var7 = -1;
                     class36.field800 = var44;
                     class36.field801 = var95;
                     continue;
                  }

                  if(var30 == 42) {
                     class36.field804[var5++] = class74.field1375.method197(var9[var7]);
                     continue;
                  }

                  if(43 == var30) {
                     var10001 = var9[var7];
                     --var5;
                     class74.field1375.method196(var10001, class36.field804[var5]);
                     continue;
                  }

                  if(var30 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var36 = class36.field804[var5];
                     if(var36 >= 0 && var36 <= 5000) {
                        class36.field802[var14] = var36;
                        byte var94 = -1;
                        if(var15 == 105) {
                           var94 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var36) {
                              continue label3873;
                           }

                           class36.field803[var14][var18] = var94;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var30 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class36.field804[var5];
                     if(var15 >= 0 && var15 < class36.field802[var14]) {
                        class36.field804[var5++] = class36.field803[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var30) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class36.field804[var5];
                     if(var15 >= 0 && var15 < class36.field802[var14]) {
                        class36.field803[var14][var15] = class36.field804[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(47 == var30) {
                     var43 = class74.field1375.method226(var9[var7]);
                     if(null == var43) {
                        var43 = "null";
                     }

                     class36.field816[var6++] = var43;
                     continue;
                  }

                  if(var30 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class74.field1375.method198(var10001, class36.field816[var6]);
                     continue;
                  }
               }

               boolean var51;
               if(1 == var9[var7]) {
                  var51 = true;
               } else {
                  var51 = false;
               }

               class173 var16;
               class173 var32;
               class173 var35;
               class173 var37;
               boolean var49;
               boolean var56;
               if(var30 < 1000) {
                  if(100 == var30) {
                     var5 -= 3;
                     var15 = class36.field804[var5];
                     var36 = class36.field804[var5 + 1];
                     var33 = class36.field804[var5 + 2];
                     if(var36 == 0) {
                        throw new RuntimeException();
                     }

                     var37 = class52.method1115(var15);
                     if(null == var37.field2891) {
                        var37.field2891 = new class173[var33 + 1];
                     }

                     if(var37.field2891.length <= var33) {
                        class173[] var91 = new class173[var33 + 1];

                        for(var20 = 0; var20 < var37.field2891.length; ++var20) {
                           var91[var20] = var37.field2891[var20];
                        }

                        var37.field2891 = var91;
                     }

                     if(var33 > 0 && null == var37.field2891[var33 - 1]) {
                        throw new RuntimeException("" + (var33 - 1));
                     }

                     class173 var92 = new class173();
                     var92.field2814 = var36;
                     var92.field2786 = var92.field2838 = var37.field2838;
                     var92.field2802 = var33;
                     var92.field2766 = true;
                     var37.field2891[var33] = var92;
                     if(var51) {
                        class36.field809 = var92;
                     } else {
                        class36.field798 = var92;
                     }

                     class134.method2877(var37);
                     continue;
                  }

                  if(101 == var30) {
                     var32 = var51?class36.field809:class36.field798;
                     var16 = class52.method1115(var32.field2838);
                     var16.field2891[var32.field2802] = null;
                     class134.method2877(var16);
                     continue;
                  }

                  if(102 == var30) {
                     --var5;
                     var32 = class52.method1115(class36.field804[var5]);
                     var32.field2891 = null;
                     class134.method2877(var32);
                     continue;
                  }

                  if(200 == var30) {
                     var5 -= 2;
                     var15 = class36.field804[var5];
                     var36 = class36.field804[var5 + 1];
                     var35 = class157.method3195(var15, var36);
                     if(var35 != null && -1 != var36) {
                        class36.field804[var5++] = 1;
                        if(var51) {
                           class36.field809 = var35;
                        } else {
                           class36.field798 = var35;
                        }
                        continue;
                     }

                     class36.field804[var5++] = 0;
                     continue;
                  }

                  if(var30 == 201) {
                     --var5;
                     var32 = class52.method1115(class36.field804[var5]);
                     if(var32 != null) {
                        class36.field804[var5++] = 1;
                        if(var51) {
                           class36.field809 = var32;
                        } else {
                           class36.field798 = var32;
                        }
                     } else {
                        class36.field804[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var30 < 1000 || var30 >= 1100) && (var30 < 2000 || var30 >= 2100)) {
                     if(var30 >= 1100 && var30 < 1200 || var30 >= 2100 && var30 < 2200) {
                        var36 = -1;
                        if(var30 >= 2000) {
                           var30 -= 1000;
                           --var5;
                           var36 = class36.field804[var5];
                           var32 = class52.method1115(var36);
                        } else {
                           var32 = var51?class36.field809:class36.field798;
                        }

                        if(var30 == 1100) {
                           var5 -= 2;
                           var32.field2788 = class36.field804[var5];
                           if(var32.field2788 > var32.field2790 - var32.field2767) {
                              var32.field2788 = var32.field2790 - var32.field2767;
                           }

                           if(var32.field2788 < 0) {
                              var32.field2788 = 0;
                           }

                           var32.field2882 = class36.field804[var5 + 1];
                           if(var32.field2882 > var32.field2791 - var32.field2783) {
                              var32.field2882 = var32.field2791 - var32.field2783;
                           }

                           if(var32.field2882 < 0) {
                              var32.field2882 = 0;
                           }

                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1101) {
                           --var5;
                           var32.field2884 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1102 == var30) {
                           --var5;
                           var32.field2796 = class36.field804[var5] == 1;
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1103) {
                           --var5;
                           var32.field2798 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1104 == var30) {
                           --var5;
                           var32.field2800 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1105) {
                           --var5;
                           var32.field2806 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1106 == var30) {
                           --var5;
                           var32.field2804 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1107 == var30) {
                           --var5;
                           var32.field2805 = class36.field804[var5] == 1;
                           class134.method2877(var32);
                           continue;
                        }

                        if(1108 == var30) {
                           var32.field2810 = 1;
                           --var5;
                           var32.field2811 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1109 == var30) {
                           var5 -= 6;
                           var32.field2816 = class36.field804[var5];
                           var32.field2817 = class36.field804[1 + var5];
                           var32.field2763 = class36.field804[var5 + 2];
                           var32.field2819 = class36.field804[var5 + 3];
                           var32.field2836 = class36.field804[4 + var5];
                           var32.field2821 = class36.field804[5 + var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1110) {
                           --var5;
                           var33 = class36.field804[var5];
                           if(var32.field2851 != var33) {
                              var32.field2851 = var33;
                              var32.field2889 = 0;
                              var32.field2898 = 0;
                              class134.method2877(var32);
                           }
                           continue;
                        }

                        if(var30 == 1111) {
                           --var5;
                           var32.field2824 = class36.field804[var5] == 1;
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1112) {
                           --var6;
                           var34 = class36.field816[var6];
                           if(!var34.equals(var32.field2771)) {
                              var32.field2771 = var34;
                              class134.method2877(var32);
                           }
                           continue;
                        }

                        if(var30 == 1113) {
                           --var5;
                           var32.field2826 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1114) {
                           var5 -= 3;
                           var32.field2789 = class36.field804[var5];
                           var32.field2831 = class36.field804[1 + var5];
                           var32.field2770 = class36.field804[var5 + 2];
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1115) {
                           --var5;
                           var32.field2832 = class36.field804[var5] == 1;
                           class134.method2877(var32);
                           continue;
                        }

                        if(1116 == var30) {
                           --var5;
                           var32.field2825 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1117 == var30) {
                           --var5;
                           var32.field2820 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1118 == var30) {
                           --var5;
                           var32.field2808 = class36.field804[var5] == 1;
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1119) {
                           --var5;
                           var32.field2827 = class36.field804[var5] == 1;
                           class134.method2877(var32);
                           continue;
                        }

                        if(1120 == var30) {
                           var5 -= 2;
                           var32.field2790 = class36.field804[var5];
                           var32.field2791 = class36.field804[var5 + 1];
                           class134.method2877(var32);
                           if(var36 != -1 && var32.field2814 == 0) {
                              class34.method746(class173.field2830[var36 >> 16], var32, false);
                           }
                           continue;
                        }

                        if(1121 == var30) {
                           var33 = var32.field2838;
                           var18 = var32.field2802;
                           client.field318.method2757(138);
                           client.field318.method2549(var33);
                           client.field318.method2540(var18);
                           client.field458 = var32;
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1122) {
                           --var5;
                           var32.field2887 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1123 == var30) {
                           --var5;
                           var32.field2793 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(var30 == 1124) {
                           --var5;
                           var32.field2799 = class36.field804[var5];
                           class134.method2877(var32);
                           continue;
                        }

                        if(1125 == var30) {
                           --var5;
                           var33 = class36.field804[var5];
                           class82 var104 = (class82)class23.method606(class1.method3(), var33);
                           if(null != var104) {
                              var32.field2797 = var104;
                              class134.method2877(var32);
                           }
                           continue;
                        }
                     } else if(var30 >= 1200 && var30 < 1300 || var30 >= 2200 && var30 < 2300) {
                        if(var30 >= 2000) {
                           var30 -= 1000;
                           --var5;
                           var32 = class52.method1115(class36.field804[var5]);
                        } else {
                           var32 = var51?class36.field809:class36.field798;
                        }

                        class134.method2877(var32);
                        if(1200 == var30 || 1205 == var30 || 1212 == var30) {
                           var5 -= 2;
                           var36 = class36.field804[var5];
                           var33 = class36.field804[1 + var5];
                           var32.field2883 = var36;
                           var32.field2888 = var33;
                           class51 var103 = class50.method1055(var36);
                           var32.field2763 = var103.field1140;
                           var32.field2819 = var103.field1129;
                           var32.field2836 = var103.field1130;
                           var32.field2816 = var103.field1131;
                           var32.field2817 = var103.field1132;
                           var32.field2821 = var103.field1158;
                           if(var30 == 1205) {
                              var32.field2807 = 0;
                           } else if(1212 == var30 | var103.field1133 == 1) {
                              var32.field2807 = 1;
                           } else {
                              var32.field2807 = 2;
                           }

                           if(var32.field2822 > 0) {
                              var32.field2821 = var32.field2821 * 32 / var32.field2822;
                           } else if(var32.field2778 > 0) {
                              var32.field2821 = var32.field2821 * 32 / var32.field2778;
                           }
                           continue;
                        }

                        if(1201 == var30) {
                           var32.field2810 = 2;
                           --var5;
                           var32.field2811 = class36.field804[var5];
                           continue;
                        }

                        if(1202 == var30) {
                           var32.field2810 = 3;
                           var32.field2811 = class167.field2692.field47.method3490();
                           continue;
                        }
                     } else if(var30 >= 1300 && var30 < 1400 || var30 >= 2300 && var30 < 2400) {
                        if(var30 >= 2000) {
                           var30 -= 1000;
                           --var5;
                           var32 = class52.method1115(class36.field804[var5]);
                        } else {
                           var32 = var51?class36.field809:class36.field798;
                        }

                        if(var30 == 1300) {
                           --var5;
                           var36 = class36.field804[var5] - 1;
                           if(var36 >= 0 && var36 <= 9) {
                              --var6;
                              var32.method3425(var36, class36.field816[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var30 == 1301) {
                           var5 -= 2;
                           var36 = class36.field804[var5];
                           var33 = class36.field804[var5 + 1];
                           var32.field2768 = class157.method3195(var36, var33);
                           continue;
                        }

                        if(var30 == 1302) {
                           --var5;
                           var32.field2845 = class36.field804[var5] == 1;
                           continue;
                        }

                        if(1303 == var30) {
                           --var5;
                           var32.field2792 = class36.field804[var5];
                           continue;
                        }

                        if(var30 == 1304) {
                           --var5;
                           var32.field2844 = class36.field804[var5];
                           continue;
                        }

                        if(var30 == 1305) {
                           --var6;
                           var32.field2870 = class36.field816[var6];
                           continue;
                        }

                        if(1306 == var30) {
                           --var6;
                           var32.field2846 = class36.field816[var6];
                           continue;
                        }

                        if(var30 == 1307) {
                           var32.field2842 = null;
                           continue;
                        }
                     } else {
                        int[] var42;
                        String var45;
                        if(var30 >= 1400 && var30 < 1500 || var30 >= 2400 && var30 < 2500) {
                           if(var30 >= 2000) {
                              var30 -= 1000;
                              --var5;
                              var32 = class52.method1115(class36.field804[var5]);
                           } else {
                              var32 = var51?class36.field809:class36.field798;
                           }

                           --var6;
                           var45 = class36.field816[var6];
                           var42 = null;
                           if(var45.length() > 0 && var45.charAt(var45.length() - 1) == 89) {
                              --var5;
                              var18 = class36.field804[var5];
                              if(var18 > 0) {
                                 for(var42 = new int[var18]; var18-- > 0; var42[var18] = class36.field804[var5]) {
                                    --var5;
                                 }
                              }

                              var45 = var45.substring(0, var45.length() - 1);
                           }

                           Object[] var96 = new Object[var45.length() + 1];

                           for(var19 = var96.length - 1; var19 >= 1; --var19) {
                              if(var45.charAt(var19 - 1) == 115) {
                                 --var6;
                                 var96[var19] = class36.field816[var6];
                              } else {
                                 --var5;
                                 var96[var19] = new Integer(class36.field804[var5]);
                              }
                           }

                           --var5;
                           var19 = class36.field804[var5];
                           if(-1 != var19) {
                              var96[0] = new Integer(var19);
                           } else {
                              var96 = null;
                           }

                           if(1400 == var30) {
                              var32.field2849 = var96;
                           }

                           if(1401 == var30) {
                              var32.field2852 = var96;
                           }

                           if(var30 == 1402) {
                              var32.field2896 = var96;
                           }

                           if(var30 == 1403) {
                              var32.field2781 = var96;
                           }

                           if(1404 == var30) {
                              var32.field2855 = var96;
                           }

                           if(var30 == 1405) {
                              var32.field2856 = var96;
                           }

                           if(var30 == 1406) {
                              var32.field2859 = var96;
                           }

                           if(1407 == var30) {
                              var32.field2860 = var96;
                              var32.field2861 = var42;
                           }

                           if(1408 == var30) {
                              var32.field2866 = var96;
                           }

                           if(var30 == 1409) {
                              var32.field2867 = var96;
                           }

                           if(var30 == 1410) {
                              var32.field2795 = var96;
                           }

                           if(1411 == var30) {
                              var32.field2850 = var96;
                           }

                           if(var30 == 1412) {
                              var32.field2762 = var96;
                           }

                           if(var30 == 1414) {
                              var32.field2862 = var96;
                              var32.field2775 = var42;
                           }

                           if(1415 == var30) {
                              var32.field2864 = var96;
                              var32.field2865 = var42;
                           }

                           if(1416 == var30) {
                              var32.field2858 = var96;
                           }

                           if(var30 == 1417) {
                              var32.field2773 = var96;
                           }

                           if(1418 == var30) {
                              var32.field2869 = var96;
                           }

                           if(var30 == 1419) {
                              var32.field2863 = var96;
                           }

                           if(var30 == 1420) {
                              var32.field2829 = var96;
                           }

                           if(1421 == var30) {
                              var32.field2872 = var96;
                           }

                           if(1422 == var30) {
                              var32.field2809 = var96;
                           }

                           if(var30 == 1423) {
                              var32.field2874 = var96;
                           }

                           if(1424 == var30) {
                              var32.field2875 = var96;
                           }

                           if(1425 == var30) {
                              var32.field2877 = var96;
                           }

                           if(1426 == var30) {
                              var32.field2878 = var96;
                           }

                           if(var30 == 1427) {
                              var32.field2876 = var96;
                           }

                           var32.field2847 = true;
                           continue;
                        }

                        if(var30 < 1600) {
                           var32 = var51?class36.field809:class36.field798;
                           if(var30 == 1500) {
                              class36.field804[var5++] = var32.field2780;
                              continue;
                           }

                           if(var30 == 1501) {
                              class36.field804[var5++] = var32.field2892;
                              continue;
                           }

                           if(var30 == 1502) {
                              class36.field804[var5++] = var32.field2767;
                              continue;
                           }

                           if(1503 == var30) {
                              class36.field804[var5++] = var32.field2783;
                              continue;
                           }

                           if(1504 == var30) {
                              class36.field804[var5++] = var32.field2787?1:0;
                              continue;
                           }

                           if(1505 == var30) {
                              class36.field804[var5++] = var32.field2786;
                              continue;
                           }
                        } else if(var30 < 1700) {
                           var32 = var51?class36.field809:class36.field798;
                           if(1600 == var30) {
                              class36.field804[var5++] = var32.field2788;
                              continue;
                           }

                           if(1601 == var30) {
                              class36.field804[var5++] = var32.field2882;
                              continue;
                           }

                           if(var30 == 1602) {
                              class36.field816[var6++] = var32.field2771;
                              continue;
                           }

                           if(1603 == var30) {
                              class36.field804[var5++] = var32.field2790;
                              continue;
                           }

                           if(var30 == 1604) {
                              class36.field804[var5++] = var32.field2791;
                              continue;
                           }

                           if(var30 == 1605) {
                              class36.field804[var5++] = var32.field2821;
                              continue;
                           }

                           if(1606 == var30) {
                              class36.field804[var5++] = var32.field2763;
                              continue;
                           }

                           if(var30 == 1607) {
                              class36.field804[var5++] = var32.field2836;
                              continue;
                           }

                           if(var30 == 1608) {
                              class36.field804[var5++] = var32.field2819;
                              continue;
                           }

                           if(var30 == 1609) {
                              class36.field804[var5++] = var32.field2798;
                              continue;
                           }

                           if(var30 == 1610) {
                              class36.field804[var5++] = var32.field2799;
                              continue;
                           }

                           if(1611 == var30) {
                              class36.field804[var5++] = var32.field2884;
                              continue;
                           }

                           if(var30 == 1612) {
                              class36.field804[var5++] = var32.field2793;
                              continue;
                           }

                           if(1613 == var30) {
                              class36.field804[var5++] = var32.field2797.vmethod3196();
                              continue;
                           }
                        } else if(var30 < 1800) {
                           var32 = var51?class36.field809:class36.field798;
                           if(1700 == var30) {
                              class36.field804[var5++] = var32.field2883;
                              continue;
                           }

                           if(var30 == 1701) {
                              if(-1 != var32.field2883) {
                                 class36.field804[var5++] = var32.field2888;
                              } else {
                                 class36.field804[var5++] = 0;
                              }
                              continue;
                           }

                           if(var30 == 1702) {
                              class36.field804[var5++] = var32.field2802;
                              continue;
                           }
                        } else if(var30 < 1900) {
                           var32 = var51?class36.field809:class36.field798;
                           if(var30 == 1800) {
                              class36.field804[var5++] = class3.method46(class169.method3395(var32));
                              continue;
                           }

                           if(var30 == 1801) {
                              --var5;
                              var36 = class36.field804[var5];
                              --var36;
                              if(null != var32.field2842 && var36 < var32.field2842.length && null != var32.field2842[var36]) {
                                 class36.field816[var6++] = var32.field2842[var36];
                                 continue;
                              }

                              class36.field816[var6++] = "";
                              continue;
                           }

                           if(var30 == 1802) {
                              if(var32.field2870 == null) {
                                 class36.field816[var6++] = "";
                              } else {
                                 class36.field816[var6++] = var32.field2870;
                              }
                              continue;
                           }
                        } else if((var30 < 1900 || var30 >= 2000) && (var30 < 2900 || var30 >= 3000)) {
                           if(var30 < 2600) {
                              --var5;
                              var32 = class52.method1115(class36.field804[var5]);
                              if(2500 == var30) {
                                 class36.field804[var5++] = var32.field2780;
                                 continue;
                              }

                              if(2501 == var30) {
                                 class36.field804[var5++] = var32.field2892;
                                 continue;
                              }

                              if(2502 == var30) {
                                 class36.field804[var5++] = var32.field2767;
                                 continue;
                              }

                              if(2503 == var30) {
                                 class36.field804[var5++] = var32.field2783;
                                 continue;
                              }

                              if(var30 == 2504) {
                                 class36.field804[var5++] = var32.field2787?1:0;
                                 continue;
                              }

                              if(2505 == var30) {
                                 class36.field804[var5++] = var32.field2786;
                                 continue;
                              }
                           } else if(var30 < 2700) {
                              --var5;
                              var32 = class52.method1115(class36.field804[var5]);
                              if(var30 == 2600) {
                                 class36.field804[var5++] = var32.field2788;
                                 continue;
                              }

                              if(var30 == 2601) {
                                 class36.field804[var5++] = var32.field2882;
                                 continue;
                              }

                              if(var30 == 2602) {
                                 class36.field816[var6++] = var32.field2771;
                                 continue;
                              }

                              if(var30 == 2603) {
                                 class36.field804[var5++] = var32.field2790;
                                 continue;
                              }

                              if(var30 == 2604) {
                                 class36.field804[var5++] = var32.field2791;
                                 continue;
                              }

                              if(var30 == 2605) {
                                 class36.field804[var5++] = var32.field2821;
                                 continue;
                              }

                              if(2606 == var30) {
                                 class36.field804[var5++] = var32.field2763;
                                 continue;
                              }

                              if(2607 == var30) {
                                 class36.field804[var5++] = var32.field2836;
                                 continue;
                              }

                              if(var30 == 2608) {
                                 class36.field804[var5++] = var32.field2819;
                                 continue;
                              }

                              if(var30 == 2609) {
                                 class36.field804[var5++] = var32.field2798;
                                 continue;
                              }

                              if(var30 == 2610) {
                                 class36.field804[var5++] = var32.field2799;
                                 continue;
                              }

                              if(var30 == 2611) {
                                 class36.field804[var5++] = var32.field2884;
                                 continue;
                              }

                              if(2612 == var30) {
                                 class36.field804[var5++] = var32.field2793;
                                 continue;
                              }

                              if(2613 == var30) {
                                 class36.field804[var5++] = var32.field2797.vmethod3196();
                                 continue;
                              }
                           } else if(var30 < 2800) {
                              if(2700 == var30) {
                                 --var5;
                                 var32 = class52.method1115(class36.field804[var5]);
                                 class36.field804[var5++] = var32.field2883;
                                 continue;
                              }

                              if(2701 == var30) {
                                 --var5;
                                 var32 = class52.method1115(class36.field804[var5]);
                                 if(-1 != var32.field2883) {
                                    class36.field804[var5++] = var32.field2888;
                                 } else {
                                    class36.field804[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var30 == 2702) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class3 var40 = (class3)client.field455.method3806((long)var15);
                                 if(null != var40) {
                                    class36.field804[var5++] = 1;
                                 } else {
                                    class36.field804[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(2706 == var30) {
                                 class36.field804[var5++] = client.field454;
                                 continue;
                              }
                           } else if(var30 < 2900) {
                              --var5;
                              var32 = class52.method1115(class36.field804[var5]);
                              if(var30 == 2800) {
                                 var44 = class36.field804;
                                 var33 = var5++;
                                 var19 = class169.method3395(var32);
                                 var18 = var19 >> 11 & 63;
                                 var44[var33] = var18;
                                 continue;
                              }

                              if(var30 == 2801) {
                                 --var5;
                                 var36 = class36.field804[var5];
                                 --var36;
                                 if(var32.field2842 != null && var36 < var32.field2842.length && var32.field2842[var36] != null) {
                                    class36.field816[var6++] = var32.field2842[var36];
                                    continue;
                                 }

                                 class36.field816[var6++] = "";
                                 continue;
                              }

                              if(2802 == var30) {
                                 if(var32.field2870 == null) {
                                    class36.field816[var6++] = "";
                                 } else {
                                    class36.field816[var6++] = var32.field2870;
                                 }
                                 continue;
                              }
                           } else if(var30 < 3200) {
                              if(var30 == 3100) {
                                 --var6;
                                 var52 = class36.field816[var6];
                                 class103.method2289(0, "", var52);
                                 continue;
                              }

                              if(var30 == 3101) {
                                 var5 -= 2;
                                 class17.method186(class167.field2692, class36.field804[var5], class36.field804[var5 + 1]);
                                 continue;
                              }

                              if(var30 == 3103) {
                                 client.field318.method2757(243);

                                 for(class3 var64 = (class3)client.field455.method3805(); var64 != null; var64 = (class3)client.field455.method3809()) {
                                    if(var64.field79 == 0 || var64.field79 == 3) {
                                       class5.method93(var64, true);
                                    }
                                 }

                                 if(null != client.field458) {
                                    class134.method2877(client.field458);
                                    client.field458 = null;
                                 }
                                 continue;
                              }

                              if(3104 == var30) {
                                 --var6;
                                 var52 = class36.field816[var6];
                                 var36 = 0;
                                 var17 = class149.method3169(var52, 10);
                                 if(var17) {
                                    var36 = class141.method2991(var52);
                                 }

                                 client.field318.method2757(104);
                                 client.field318.method2494(var36);
                                 continue;
                              }

                              if(3105 == var30) {
                                 --var6;
                                 var52 = class36.field816[var6];
                                 client.field318.method2757(255);
                                 client.field318.method2573(var52.length() + 1);
                                 client.field318.method2661(var52);
                                 continue;
                              }

                              if(3106 == var30) {
                                 --var6;
                                 var52 = class36.field816[var6];
                                 client.field318.method2757(117);
                                 client.field318.method2573(var52.length() + 1);
                                 client.field318.method2661(var52);
                                 continue;
                              }

                              if(var30 == 3107) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 --var6;
                                 var45 = class36.field816[var6];
                                 var33 = class32.field751;
                                 int[] var38 = class32.field757;
                                 boolean var41 = false;

                                 for(var20 = 0; var20 < var33; ++var20) {
                                    class2 var21 = client.field415[var38[var20]];
                                    if(null != var21 && class167.field2692 != var21 && var21.field59 != null && var21.field59.equalsIgnoreCase(var45)) {
                                       if(var15 == 1) {
                                          client.field318.method2757(77);
                                          client.field318.method2573(0);
                                          client.field318.method2492(var38[var20]);
                                       } else if(4 == var15) {
                                          client.field318.method2757(36);
                                          client.field318.method2538(var38[var20]);
                                          client.field318.method2573(0);
                                       } else if(6 == var15) {
                                          client.field318.method2757(236);
                                          client.field318.method2618(0);
                                          client.field318.method2492(var38[var20]);
                                       } else if(7 == var15) {
                                          client.field318.method2757(119);
                                          client.field318.method2573(0);
                                          client.field318.method2492(var38[var20]);
                                       }

                                       var41 = true;
                                       break;
                                    }
                                 }

                                 if(!var41) {
                                    class103.method2289(4, "", "Unable to find " + var45);
                                 }
                                 continue;
                              }

                              if(var30 == 3108) {
                                 var5 -= 3;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 var33 = class36.field804[var5 + 2];
                                 var37 = class52.method1115(var33);
                                 class10.method128(var37, var15, var36);
                                 continue;
                              }

                              if(var30 == 3109) {
                                 var5 -= 2;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 var35 = var51?class36.field809:class36.field798;
                                 class10.method128(var35, var15, var36);
                                 continue;
                              }

                              if(var30 == 3110) {
                                 --var5;
                                 class39.field922 = class36.field804[var5] == 1;
                                 continue;
                              }

                              if(3111 == var30) {
                                 class36.field804[var5++] = class41.field989.field164?1:0;
                                 continue;
                              }

                              if(3112 == var30) {
                                 --var5;
                                 class41.field989.field164 = class36.field804[var5] == 1;
                                 class11.method152();
                                 continue;
                              }

                              if(3113 == var30) {
                                 --var6;
                                 var52 = class36.field816[var6];
                                 --var5;
                                 var49 = class36.field804[var5] == 1;
                                 if(!var49) {
                                    class35.method749(var52, 3, "openjs");
                                    continue;
                                 }

                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var52));
                                       continue;
                                    } catch (Exception var28) {
                                       ;
                                    }
                                 }

                                 if(class138.field2151.startsWith("win")) {
                                    class35.method749(var52, 0, "openjs");
                                 } else if(class138.field2151.startsWith("mac")) {
                                    class35.method749(var52, 1, "openjs");
                                 } else {
                                    class35.method749(var52, 2, "openjs");
                                 }
                                 continue;
                              }

                              if(3115 == var30) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 client.field318.method2757(57);
                                 client.field318.method2492(var15);
                                 continue;
                              }

                              if(3116 == var30) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 var6 -= 2;
                                 var45 = class36.field816[var6];
                                 var34 = class36.field816[var6 + 1];
                                 if(var45.length() <= 500 && var34.length() <= 500) {
                                    client.field318.method2757(252);
                                    client.field318.method2492(1 + class45.method992(var45) + class45.method992(var34));
                                    client.field318.method2661(var34);
                                    client.field318.method2661(var45);
                                    client.field318.method2618(var15);
                                 }
                                 continue;
                              }
                           } else if(var30 < 3300) {
                              if(3200 == var30) {
                                 var5 -= 3;
                                 class103.method2290(class36.field804[var5], class36.field804[1 + var5], class36.field804[var5 + 2]);
                                 continue;
                              }

                              if(var30 == 3201) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 if(var15 == -1 && !client.field496) {
                                    class183.field2967.method3652();
                                    class183.field2968 = 1;
                                    class151.field2279 = null;
                                 } else if(-1 != var15 && var15 != client.field532 && client.field369 != 0 && !client.field496) {
                                    class168 var61 = class19.field289;
                                    var33 = client.field369;
                                    class183.field2968 = 1;
                                    class151.field2279 = var61;
                                    class72.field1358 = var15;
                                    class183.field2964 = 0;
                                    class183.field2970 = var33;
                                    class14.field225 = false;
                                    class75.field1384 = 2;
                                 }

                                 client.field532 = var15;
                                 continue;
                              }

                              if(3202 == var30) {
                                 var5 -= 2;
                                 class76.method1667(class36.field804[var5]);
                                 continue;
                              }
                           } else if(var30 < 3400) {
                              if(3300 == var30) {
                                 class36.field804[var5++] = client.field305;
                                 continue;
                              }

                              class15 var46;
                              if(3301 == var30) {
                                 var5 -= 2;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 var42 = class36.field804;
                                 var18 = var5++;
                                 var46 = (class15)class15.field234.method3806((long)var15);
                                 if(var46 == null) {
                                    var19 = -1;
                                 } else if(var36 >= 0 && var36 < var46.field228.length) {
                                    var19 = var46.field228[var36];
                                 } else {
                                    var19 = -1;
                                 }

                                 var42[var18] = var19;
                                 continue;
                              }

                              if(var30 == 3302) {
                                 var5 -= 2;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[var5 + 1];
                                 class36.field804[var5++] = class168.method3394(var15, var36);
                                 continue;
                              }

                              if(3303 == var30) {
                                 var5 -= 2;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 class36.field804[var5++] = class15.method178(var15, var36);
                                 continue;
                              }

                              if(3304 == var30) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = method163(var15).field1109;
                                 continue;
                              }

                              if(var30 == 3305) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = client.field429[var15];
                                 continue;
                              }

                              if(var30 == 3306) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = client.field537[var15];
                                 continue;
                              }

                              if(3307 == var30) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = client.field464[var15];
                                 continue;
                              }

                              if(var30 == 3308) {
                                 var15 = class82.field1437;
                                 var36 = class41.field990 + (class167.field2692.field849 >> 7);
                                 var33 = class2.field37 + (class167.field2692.field819 >> 7);
                                 class36.field804[var5++] = var33 + (var15 << 28) + (var36 << 14);
                                 continue;
                              }

                              if(3309 == var30) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = var15 >> 14 & 16383;
                                 continue;
                              }

                              if(var30 == 3310) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = var15 >> 28;
                                 continue;
                              }

                              if(var30 == 3311) {
                                 --var5;
                                 var15 = class36.field804[var5];
                                 class36.field804[var5++] = var15 & 16383;
                                 continue;
                              }

                              if(var30 == 3312) {
                                 class36.field804[var5++] = client.field300?1:0;
                                 continue;
                              }

                              if(var30 == 3313) {
                                 var5 -= 2;
                                 var15 = class36.field804[var5] + '耀';
                                 var36 = class36.field804[var5 + 1];
                                 var42 = class36.field804;
                                 var18 = var5++;
                                 var46 = (class15)class15.field234.method3806((long)var15);
                                 if(var46 == null) {
                                    var19 = -1;
                                 } else if(var36 >= 0 && var36 < var46.field228.length) {
                                    var19 = var46.field228[var36];
                                 } else {
                                    var19 = -1;
                                 }

                                 var42[var18] = var19;
                                 continue;
                              }

                              if(3314 == var30) {
                                 var5 -= 2;
                                 var15 = '耀' + class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 class36.field804[var5++] = class168.method3394(var15, var36);
                                 continue;
                              }

                              if(3315 == var30) {
                                 var5 -= 2;
                                 var15 = '耀' + class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 class36.field804[var5++] = class15.method178(var15, var36);
                                 continue;
                              }

                              if(var30 == 3316) {
                                 if(client.field461 >= 2) {
                                    class36.field804[var5++] = client.field461;
                                 } else {
                                    class36.field804[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(3317 == var30) {
                                 class36.field804[var5++] = client.field394;
                                 continue;
                              }

                              if(3318 == var30) {
                                 class36.field804[var5++] = client.field296;
                                 continue;
                              }

                              if(var30 == 3321) {
                                 class36.field804[var5++] = client.field522;
                                 continue;
                              }

                              if(var30 == 3322) {
                                 class36.field804[var5++] = client.field460;
                                 continue;
                              }

                              if(var30 == 3323) {
                                 if(client.field463) {
                                    class36.field804[var5++] = 1;
                                 } else {
                                    class36.field804[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var30 == 3324) {
                                 class36.field804[var5++] = client.field503;
                                 continue;
                              }
                           } else if(var30 < 3500) {
                              if(3400 == var30) {
                                 var5 -= 2;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[1 + var5];
                                 class48 var48 = class141.method2992(var15);
                                 if(115 != var48.field1094) {
                                    ;
                                 }

                                 for(var18 = 0; var18 < var48.field1093; ++var18) {
                                    if(var36 == var48.field1095[var18]) {
                                       class36.field816[var6++] = var48.field1096[var18];
                                       var48 = null;
                                       break;
                                    }
                                 }

                                 if(var48 != null) {
                                    class36.field816[var6++] = var48.field1091;
                                 }
                                 continue;
                              }

                              if(var30 == 3408) {
                                 var5 -= 4;
                                 var15 = class36.field804[var5];
                                 var36 = class36.field804[var5 + 1];
                                 var33 = class36.field804[var5 + 2];
                                 var18 = class36.field804[3 + var5];
                                 class48 var58 = class141.method2992(var33);
                                 if(var58.field1089 == var15 && var58.field1094 == var36) {
                                    for(var20 = 0; var20 < var58.field1093; ++var20) {
                                       if(var18 == var58.field1095[var20]) {
                                          if(var36 == 115) {
                                             class36.field816[var6++] = var58.field1096[var20];
                                          } else {
                                             class36.field804[var5++] = var58.field1090[var20];
                                          }

                                          var58 = null;
                                          break;
                                       }
                                    }

                                    if(var58 != null) {
                                       if(115 == var36) {
                                          class36.field816[var6++] = var58.field1091;
                                       } else {
                                          class36.field804[var5++] = var58.field1092;
                                       }
                                    }
                                    continue;
                                 }

                                 if(115 == var36) {
                                    class36.field816[var6++] = "null";
                                 } else {
                                    class36.field804[var5++] = 0;
                                 }
                                 continue;
                              }
                           } else {
                              int var22;
                              int var23;
                              int var24;
                              if(var30 < 3700) {
                                 if(3600 == var30) {
                                    if(client.field562 == 0) {
                                       class36.field804[var5++] = -2;
                                    } else if(client.field562 == 1) {
                                       class36.field804[var5++] = -1;
                                    } else {
                                       class36.field804[var5++] = client.field561;
                                    }
                                    continue;
                                 }

                                 if(var30 == 3601) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(client.field562 == 2 && var15 < client.field561) {
                                       class36.field816[var6++] = client.field474[var15].field260;
                                       class36.field816[var6++] = client.field474[var15].field254;
                                       continue;
                                    }

                                    class36.field816[var6++] = "";
                                    class36.field816[var6++] = "";
                                    continue;
                                 }

                                 if(3602 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(2 == client.field562 && var15 < client.field561) {
                                       class36.field804[var5++] = client.field474[var15].field255;
                                       continue;
                                    }

                                    class36.field804[var5++] = 0;
                                    continue;
                                 }

                                 if(3603 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(2 == client.field562 && var15 < client.field561) {
                                       class36.field804[var5++] = client.field474[var15].field261;
                                       continue;
                                    }

                                    class36.field804[var5++] = 0;
                                    continue;
                                 }

                                 if(3604 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    client.field318.method2757(174);
                                    client.field318.method2573(class45.method992(var52) + 1);
                                    client.field318.method2661(var52);
                                    client.field318.method2530(var36);
                                    continue;
                                 }

                                 if(var30 == 3605) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class84.method1898(var52);
                                    continue;
                                 }

                                 if(3606 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    if(null == var52) {
                                       continue;
                                    }

                                    var45 = class142.method2997(var52, class164.field2678);
                                    if(var45 == null) {
                                       continue;
                                    }

                                    var33 = 0;

                                    while(true) {
                                       if(var33 >= client.field561) {
                                          continue label3873;
                                       }

                                       class17 var53 = client.field474[var33];
                                       String var65 = var53.field260;
                                       var55 = class142.method2997(var65, class164.field2678);
                                       boolean var69;
                                       if(null != var52 && var65 != null) {
                                          if(!var52.startsWith("#") && !var65.startsWith("#")) {
                                             var69 = var45.equals(var55);
                                          } else {
                                             var69 = var52.equals(var65);
                                          }
                                       } else {
                                          var69 = false;
                                       }

                                       if(var69) {
                                          --client.field561;

                                          for(var22 = var33; var22 < client.field561; ++var22) {
                                             client.field474[var22] = client.field474[1 + var22];
                                          }

                                          client.field572 = client.field491;
                                          client.field318.method2757(79);
                                          client.field318.method2573(class45.method992(var52));
                                          client.field318.method2661(var52);
                                          continue label3873;
                                       }

                                       ++var33;
                                    }
                                 }

                                 if(3607 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class101.method2281(var52);
                                    continue;
                                 }

                                 if(3608 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class16.method183(var52);
                                    continue;
                                 }

                                 if(var30 == 3609) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class152[] var78 = class96.method2188();

                                    for(var33 = 0; var33 < var78.length; ++var33) {
                                       class152 var50 = var78[var33];
                                       if(-1 != var50.field2284 && var52.startsWith(class134.method2878(var50.field2284))) {
                                          var52 = var52.substring(6 + Integer.toString(var50.field2284).length());
                                          break;
                                       }
                                    }

                                    class36.field804[var5++] = class130.method2834(var52, false)?1:0;
                                    continue;
                                 }

                                 if(var30 == 3611) {
                                    if(null != client.field338) {
                                       class36.field816[var6++] = class36.method765(client.field338);
                                    } else {
                                       class36.field816[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var30 == 3612) {
                                    if(client.field338 != null) {
                                       class36.field804[var5++] = class11.field189;
                                    } else {
                                       class36.field804[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(3613 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(null != client.field338 && var15 < class11.field189) {
                                       class36.field816[var6++] = class8.field162[var15].field634;
                                       continue;
                                    }

                                    class36.field816[var6++] = "";
                                    continue;
                                 }

                                 if(3614 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(client.field338 != null && var15 < class11.field189) {
                                       class36.field804[var5++] = class8.field162[var15].field627;
                                       continue;
                                    }

                                    class36.field804[var5++] = 0;
                                    continue;
                                 }

                                 if(var30 == 3615) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(client.field338 != null && var15 < class11.field189) {
                                       class36.field804[var5++] = class8.field162[var15].field630;
                                       continue;
                                    }

                                    class36.field804[var5++] = 0;
                                    continue;
                                 }

                                 if(var30 == 3616) {
                                    class36.field804[var5++] = class184.field3001;
                                    continue;
                                 }

                                 if(var30 == 3617) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class41.method886(var52);
                                    continue;
                                 }

                                 if(var30 == 3618) {
                                    class36.field804[var5++] = class157.field2502;
                                    continue;
                                 }

                                 if(var30 == 3619) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    if(!var52.equals("")) {
                                       client.field318.method2757(232);
                                       client.field318.method2573(class45.method992(var52));
                                       client.field318.method2661(var52);
                                    }
                                    continue;
                                 }

                                 if(3620 == var30) {
                                    class12.method156();
                                    continue;
                                 }

                                 if(var30 == 3621) {
                                    if(0 == client.field562) {
                                       class36.field804[var5++] = -1;
                                    } else {
                                       class36.field804[var5++] = client.field565;
                                    }
                                    continue;
                                 }

                                 if(3622 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(client.field562 != 0 && var15 < client.field565) {
                                       class36.field816[var6++] = client.field566[var15].field146;
                                       class36.field816[var6++] = client.field566[var15].field140;
                                       continue;
                                    }

                                    class36.field816[var6++] = "";
                                    class36.field816[var6++] = "";
                                    continue;
                                 }

                                 if(3623 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    if(var52.startsWith(class134.method2878(0)) || var52.startsWith(class134.method2878(1))) {
                                       var52 = var52.substring(7);
                                    }

                                    class36.field804[var5++] = class45.method991(var52)?1:0;
                                    continue;
                                 }

                                 if(var30 == 3624) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    if(class8.field162 != null && var15 < class11.field189 && class8.field162[var15].field634.equalsIgnoreCase(class167.field2692.field59)) {
                                       class36.field804[var5++] = 1;
                                       continue;
                                    }

                                    class36.field804[var5++] = 0;
                                    continue;
                                 }

                                 if(var30 == 3625) {
                                    if(null == client.field450) {
                                       class36.field816[var6++] = "";
                                       continue;
                                    }

                                    String[] var89 = class36.field816;
                                    var36 = var6++;
                                    String var47 = client.field450;
                                    long var54 = 0L;
                                    var23 = var47.length();

                                    for(var24 = 0; var24 < var23; ++var24) {
                                       var54 *= 37L;
                                       char var25 = var47.charAt(var24);
                                       if(var25 >= 65 && var25 <= 90) {
                                          var54 += (long)(var25 + 1 - 65);
                                       } else if(var25 >= 97 && var25 <= 122) {
                                          var54 += (long)(1 + var25 - 97);
                                       } else if(var25 >= 48 && var25 <= 57) {
                                          var54 += (long)(27 + var25 - 48);
                                       }

                                       if(var54 >= 177917621779460413L) {
                                          break;
                                       }
                                    }

                                    while(var54 % 37L == 0L && var54 != 0L) {
                                       var54 /= 37L;
                                    }

                                    var67 = class104.method2296(var54);
                                    if(null == var67) {
                                       var67 = "";
                                    }

                                    var89[var36] = var67;
                                    continue;
                                 }
                              } else if(var30 < 4000) {
                                 if(var30 == 3903) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = client.field570[var15].method4003();
                                    continue;
                                 }

                                 if(var30 == 3904) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = client.field570[var15].field3172;
                                    continue;
                                 }

                                 if(var30 == 3905) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = client.field570[var15].field3173;
                                    continue;
                                 }

                                 if(3906 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = client.field570[var15].field3174;
                                    continue;
                                 }

                                 if(var30 == 3907) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = client.field570[var15].field3171;
                                    continue;
                                 }

                                 if(3908 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = client.field570[var15].field3176;
                                    continue;
                                 }

                                 if(3910 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var36 = client.field570[var15].method4000();
                                    class36.field804[var5++] = 0 == var36?1:0;
                                    continue;
                                 }

                                 if(3911 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var36 = client.field570[var15].method4000();
                                    class36.field804[var5++] = var36 == 2?1:0;
                                    continue;
                                 }

                                 if(var30 == 3912) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var36 = client.field570[var15].method4000();
                                    class36.field804[var5++] = 5 == var36?1:0;
                                    continue;
                                 }

                                 if(var30 == 3913) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var36 = client.field570[var15].method4000();
                                    class36.field804[var5++] = 1 == var36?1:0;
                                    continue;
                                 }

                                 boolean var100;
                                 if(3914 == var30) {
                                    --var5;
                                    var100 = class36.field804[var5] == 1;
                                    if(class52.field1164 != null) {
                                       class52.field1164.method4019(class221.field3182, var100);
                                    }
                                    continue;
                                 }

                                 if(var30 == 3915) {
                                    --var5;
                                    var100 = class36.field804[var5] == 1;
                                    if(null != class52.field1164) {
                                       class52.field1164.method4019(class221.field3181, var100);
                                    }
                                    continue;
                                 }

                                 if(var30 == 3916) {
                                    var5 -= 2;
                                    var100 = class36.field804[var5] == 1;
                                    var49 = 1 == class36.field804[var5 + 1];
                                    if(class52.field1164 != null) {
                                       class52.field1164.method4019(new class21(var49), var100);
                                    }
                                    continue;
                                 }

                                 if(3917 == var30) {
                                    --var5;
                                    var100 = class36.field804[var5] == 1;
                                    if(class52.field1164 != null) {
                                       class52.field1164.method4019(class221.field3180, var100);
                                    }
                                    continue;
                                 }

                                 if(var30 == 3918) {
                                    --var5;
                                    var100 = class36.field804[var5] == 1;
                                    if(null != class52.field1164) {
                                       class52.field1164.method4019(class221.field3183, var100);
                                    }
                                    continue;
                                 }

                                 if(var30 == 3919) {
                                    class36.field804[var5++] = class52.field1164 == null?0:class52.field1164.field3179.size();
                                    continue;
                                 }

                                 class214 var84;
                                 if(var30 == 3920) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    class36.field804[var5++] = var84.field3160;
                                    continue;
                                 }

                                 if(var30 == 3921) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    class36.field816[var6++] = var84.method3964();
                                    continue;
                                 }

                                 if(3922 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    class36.field816[var6++] = var84.method3963();
                                    continue;
                                 }

                                 if(var30 == 3923) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    long var63 = class14.method165() - class1.field26 - var84.field3154;
                                    var19 = (int)(var63 / 3600000L);
                                    var20 = (int)((var63 - (long)(3600000 * var19)) / 60000L);
                                    var74 = (int)((var63 - (long)(var19 * 3600000) - (long)('\uea60' * var20)) / 1000L);
                                    String var57 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var74 / 10 + var74 % 10;
                                    class36.field816[var6++] = var57;
                                    continue;
                                 }

                                 if(3924 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    class36.field804[var5++] = var84.field3156.field3174;
                                    continue;
                                 }

                                 if(var30 == 3925) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    class36.field804[var5++] = var84.field3156.field3173;
                                    continue;
                                 }

                                 if(3926 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var84 = (class214)class52.field1164.field3179.get(var15);
                                    class36.field804[var5++] = var84.field3156.field3172;
                                    continue;
                                 }
                              } else if(var30 < 4100) {
                                 if(4000 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 + var36;
                                    continue;
                                 }

                                 if(var30 == 4001) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 - var36;
                                    continue;
                                 }

                                 if(var30 == 4002) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[var5 + 1];
                                    class36.field804[var5++] = var36 * var15;
                                    continue;
                                 }

                                 if(4003 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 / var36;
                                    continue;
                                 }

                                 if(var30 == 4004) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = (int)(Math.random() * (double)var15);
                                    continue;
                                 }

                                 if(4005 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = (int)(Math.random() * (double)(var15 + 1));
                                    continue;
                                 }

                                 if(4006 == var30) {
                                    var5 -= 5;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[var5 + 1];
                                    var33 = class36.field804[var5 + 2];
                                    var18 = class36.field804[var5 + 3];
                                    var19 = class36.field804[var5 + 4];
                                    class36.field804[var5++] = var15 + (var36 - var15) * (var19 - var33) / (var18 - var33);
                                    continue;
                                 }

                                 if(var30 == 4007) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 * var36 / 100 + var15;
                                    continue;
                                 }

                                 if(var30 == 4008) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 | 1 << var36;
                                    continue;
                                 }

                                 if(4009 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 & -1 - (1 << var36);
                                    continue;
                                 }

                                 if(4010 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = (var15 & 1 << var36) != 0?1:0;
                                    continue;
                                 }

                                 if(4011 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[var5 + 1];
                                    class36.field804[var5++] = var15 % var36;
                                    continue;
                                 }

                                 if(var30 == 4012) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    if(0 == var15) {
                                       class36.field804[var5++] = 0;
                                    } else {
                                       class36.field804[var5++] = (int)Math.pow((double)var15, (double)var36);
                                    }
                                    continue;
                                 }

                                 if(var30 == 4013) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    if(0 == var15) {
                                       class36.field804[var5++] = 0;
                                    } else if(var36 == 0) {
                                       class36.field804[var5++] = Integer.MAX_VALUE;
                                    } else {
                                       class36.field804[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var36);
                                    }
                                    continue;
                                 }

                                 if(4014 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class36.field804[var5++] = var15 & var36;
                                    continue;
                                 }

                                 if(4015 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[var5 + 1];
                                    class36.field804[var5++] = var15 | var36;
                                    continue;
                                 }
                              } else if(var30 < 4200) {
                                 if(4100 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    class36.field816[var6++] = var52 + var36;
                                    continue;
                                 }

                                 if(4101 == var30) {
                                    var6 -= 2;
                                    var52 = class36.field816[var6];
                                    var45 = class36.field816[1 + var6];
                                    class36.field816[var6++] = var52 + var45;
                                    continue;
                                 }

                                 if(var30 == 4102) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    class36.field816[var6++] = var52 + class3.method45(var36);
                                    continue;
                                 }

                                 if(4103 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class36.field816[var6++] = var52.toLowerCase();
                                    continue;
                                 }

                                 if(var30 == 4104) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    long var99 = ((long)var15 + 11745L) * 86400000L;
                                    class36.field810.setTime(new Date(var99));
                                    var18 = class36.field810.get(5);
                                    var19 = class36.field810.get(2);
                                    var20 = class36.field810.get(1);
                                    class36.field816[var6++] = var18 + "-" + class36.field811[var19] + "-" + var20;
                                    continue;
                                 }

                                 if(var30 == 4105) {
                                    var6 -= 2;
                                    var52 = class36.field816[var6];
                                    var45 = class36.field816[var6 + 1];
                                    if(class167.field2692.field47 != null && class167.field2692.field47.field2927) {
                                       class36.field816[var6++] = var45;
                                       continue;
                                    }

                                    class36.field816[var6++] = var52;
                                    continue;
                                 }

                                 if(var30 == 4106) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field816[var6++] = Integer.toString(var15);
                                    continue;
                                 }

                                 if(4107 == var30) {
                                    var6 -= 2;
                                    class36.field804[var5++] = class29.method670(class7.method101(class36.field816[var6], class36.field816[var6 + 1]));
                                    continue;
                                 }

                                 class224 var73;
                                 if(4108 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    var5 -= 2;
                                    var36 = class36.field804[var5];
                                    var33 = class36.field804[var5 + 1];
                                    var59 = class96.field1649.method3335(var33, 0);
                                    var73 = new class224(var59);
                                    class36.field804[var5++] = var73.method4035(var52, var36);
                                    continue;
                                 }

                                 if(4109 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    var5 -= 2;
                                    var36 = class36.field804[var5];
                                    var33 = class36.field804[1 + var5];
                                    var59 = class96.field1649.method3335(var33, 0);
                                    var73 = new class224(var59);
                                    class36.field804[var5++] = var73.method4034(var52, var36);
                                    continue;
                                 }

                                 if(var30 == 4110) {
                                    var6 -= 2;
                                    var52 = class36.field816[var6];
                                    var45 = class36.field816[var6 + 1];
                                    --var5;
                                    if(class36.field804[var5] == 1) {
                                       class36.field816[var6++] = var52;
                                    } else {
                                       class36.field816[var6++] = var45;
                                    }
                                    continue;
                                 }

                                 if(var30 == 4111) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    class36.field816[var6++] = class223.method4103(var52);
                                    continue;
                                 }

                                 if(var30 == 4112) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    class36.field816[var6++] = var52 + (char)var36;
                                    continue;
                                 }

                                 if(var30 == 4113) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class56.method1217((char)var15)?1:0;
                                    continue;
                                 }

                                 if(4114 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class104.method2294((char)var15)?1:0;
                                    continue;
                                 }

                                 char var70;
                                 if(4115 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var44 = class36.field804;
                                    var33 = var5++;
                                    var70 = (char)var15;
                                    var56 = var70 >= 65 && var70 <= 90 || var70 >= 97 && var70 <= 122;
                                    var44[var33] = var56?1:0;
                                    continue;
                                 }

                                 if(var30 == 4116) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class15.method175((char)var15)?1:0;
                                    continue;
                                 }

                                 if(4117 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    if(var52 != null) {
                                       class36.field804[var5++] = var52.length();
                                    } else {
                                       class36.field804[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var30 == 4118) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    var5 -= 2;
                                    var36 = class36.field804[var5];
                                    var33 = class36.field804[var5 + 1];
                                    class36.field816[var6++] = var52.substring(var36, var33);
                                    continue;
                                 }

                                 if(4119 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    StringBuilder var97 = new StringBuilder(var52.length());
                                    var17 = false;

                                    for(var18 = 0; var18 < var52.length(); ++var18) {
                                       var70 = var52.charAt(var18);
                                       if(var70 == 60) {
                                          var17 = true;
                                       } else if(var70 == 62) {
                                          var17 = false;
                                       } else if(!var17) {
                                          var97.append(var70);
                                       }
                                    }

                                    class36.field816[var6++] = var97.toString();
                                    continue;
                                 }

                                 if(4120 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    class36.field804[var5++] = var52.indexOf(var36);
                                    continue;
                                 }

                                 if(var30 == 4121) {
                                    var6 -= 2;
                                    var52 = class36.field816[var6];
                                    var45 = class36.field816[var6 + 1];
                                    --var5;
                                    var33 = class36.field804[var5];
                                    class36.field804[var5++] = var52.indexOf(var45, var33);
                                    continue;
                                 }
                              } else if(var30 < 4300) {
                                 if(4200 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field816[var6++] = class50.method1055(var15).field1122;
                                    continue;
                                 }

                                 class51 var77;
                                 if(var30 == 4201) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    var77 = class50.method1055(var15);
                                    if(var36 >= 1 && var36 <= 5 && var77.field1136[var36 - 1] != null) {
                                       class36.field816[var6++] = var77.field1136[var36 - 1];
                                       continue;
                                    }

                                    class36.field816[var6++] = "";
                                    continue;
                                 }

                                 if(4202 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[var5 + 1];
                                    var77 = class50.method1055(var15);
                                    if(var36 >= 1 && var36 <= 5 && var77.field1112[var36 - 1] != null) {
                                       class36.field816[var6++] = var77.field1112[var36 - 1];
                                       continue;
                                    }

                                    class36.field816[var6++] = "";
                                    continue;
                                 }

                                 if(4203 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class50.method1055(var15).field1162;
                                    continue;
                                 }

                                 if(4204 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class50.method1055(var15).field1133 == 1?1:0;
                                    continue;
                                 }

                                 class51 var101;
                                 if(var30 == 4205) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var101 = class50.method1055(var15);
                                    if(-1 == var101.field1153 && var101.field1150 >= 0) {
                                       class36.field804[var5++] = var101.field1150;
                                       continue;
                                    }

                                    class36.field804[var5++] = var15;
                                    continue;
                                 }

                                 if(4206 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var101 = class50.method1055(var15);
                                    if(var101.field1153 >= 0 && var101.field1150 >= 0) {
                                       class36.field804[var5++] = var101.field1150;
                                       continue;
                                    }

                                    class36.field804[var5++] = var15;
                                    continue;
                                 }

                                 if(var30 == 4207) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class50.method1055(var15).field1135?1:0;
                                    continue;
                                 }

                                 if(var30 == 4210) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    var56 = var36 == 1;
                                    var34 = var52.toLowerCase();
                                    short[] var76 = new short[16];
                                    var20 = 0;
                                    var74 = 0;

                                    while(true) {
                                       if(var74 >= class51.field1116) {
                                          class155.field2323 = var76;
                                          class152.field2295 = 0;
                                          class131.field2074 = var20;
                                          String[] var80 = new String[class131.field2074];

                                          for(var22 = 0; var22 < class131.field2074; ++var22) {
                                             var80[var22] = class50.method1055(var76[var22]).field1122;
                                          }

                                          short[] var66 = class155.field2323;
                                          class115.method2449(var80, var66, 0, var80.length - 1);
                                          break;
                                       }

                                       class51 var60 = class50.method1055(var74);
                                       if((!var56 || var60.field1160) && var60.field1153 == -1 && var60.field1122.toLowerCase().indexOf(var34) != -1) {
                                          if(var20 >= 250) {
                                             class131.field2074 = -1;
                                             class155.field2323 = null;
                                             break;
                                          }

                                          if(var20 >= var76.length) {
                                             short[] var62 = new short[2 * var76.length];

                                             for(var24 = 0; var24 < var20; ++var24) {
                                                var62[var24] = var76[var24];
                                             }

                                             var76 = var62;
                                          }

                                          var76[var20++] = (short)var74;
                                       }

                                       ++var74;
                                    }

                                    class36.field804[var5++] = class131.field2074;
                                    continue;
                                 }

                                 if(var30 == 4211) {
                                    if(null != class155.field2323 && class152.field2295 < class131.field2074) {
                                       class36.field804[var5++] = class155.field2323[++class152.field2295 - 1] & '\uffff';
                                       continue;
                                    }

                                    class36.field804[var5++] = -1;
                                    continue;
                                 }

                                 if(4212 == var30) {
                                    class152.field2295 = 0;
                                    continue;
                                 }
                              } else if(var30 < 5100) {
                                 if(var30 == 5000) {
                                    class36.field804[var5++] = client.field512;
                                    continue;
                                 }

                                 if(5001 == var30) {
                                    var5 -= 3;
                                    client.field512 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class130[] var87 = class8.method110();
                                    var18 = 0;

                                    class130 var109;
                                    while(true) {
                                       if(var18 >= var87.length) {
                                          var109 = null;
                                          break;
                                       }

                                       class130 var90 = var87[var18];
                                       if(var90.field2067 == var36) {
                                          var109 = var90;
                                          break;
                                       }

                                       ++var18;
                                    }

                                    class103.field1785 = var109;
                                    if(class103.field1785 == null) {
                                       class103.field1785 = class130.field2066;
                                    }

                                    client.field513 = class36.field804[2 + var5];
                                    client.field318.method2757(197);
                                    client.field318.method2573(client.field512);
                                    client.field318.method2573(class103.field1785.field2067);
                                    client.field318.method2573(client.field513);
                                    continue;
                                 }

                                 if(5002 == var30) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    var5 -= 2;
                                    var36 = class36.field804[var5];
                                    var33 = class36.field804[var5 + 1];
                                    client.field318.method2757(94);
                                    client.field318.method2573(class45.method992(var52) + 2);
                                    client.field318.method2661(var52);
                                    client.field318.method2573(var36 - 1);
                                    client.field318.method2573(var33);
                                    continue;
                                 }

                                 if(5003 == var30) {
                                    var5 -= 2;
                                    var15 = class36.field804[var5];
                                    var36 = class36.field804[1 + var5];
                                    class35 var86 = class26.method645(var15, var36);
                                    if(var86 != null) {
                                       class36.field804[var5++] = var86.field794;
                                       class36.field804[var5++] = var86.field789;
                                       class36.field816[var6++] = var86.field796 != null?var86.field796:"";
                                       class36.field816[var6++] = var86.field793 != null?var86.field793:"";
                                       class36.field816[var6++] = var86.field792 != null?var86.field792:"";
                                    } else {
                                       class36.field804[var5++] = -1;
                                       class36.field804[var5++] = 0;
                                       class36.field816[var6++] = "";
                                       class36.field816[var6++] = "";
                                       class36.field816[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var30 == 5004) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class35 var102 = class173.method3443(var15);
                                    if(var102 != null) {
                                       class36.field804[var5++] = var102.field791;
                                       class36.field804[var5++] = var102.field789;
                                       class36.field816[var6++] = var102.field796 != null?var102.field796:"";
                                       class36.field816[var6++] = null != var102.field793?var102.field793:"";
                                       class36.field816[var6++] = null != var102.field792?var102.field792:"";
                                    } else {
                                       class36.field804[var5++] = -1;
                                       class36.field804[var5++] = 0;
                                       class36.field816[var6++] = "";
                                       class36.field816[var6++] = "";
                                       class36.field816[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(5005 == var30) {
                                    if(class103.field1785 == null) {
                                       class36.field804[var5++] = -1;
                                    } else {
                                       class36.field804[var5++] = class103.field1785.field2067;
                                    }
                                    continue;
                                 }

                                 if(var30 == 5008) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    --var5;
                                    var36 = class36.field804[var5];
                                    var34 = var52.toLowerCase();
                                    byte var79 = 0;
                                    if(var34.startsWith("yellow:")) {
                                       var79 = 0;
                                       var52 = var52.substring("yellow:".length());
                                    } else if(var34.startsWith("red:")) {
                                       var79 = 1;
                                       var52 = var52.substring("red:".length());
                                    } else if(var34.startsWith("green:")) {
                                       var79 = 2;
                                       var52 = var52.substring("green:".length());
                                    } else if(var34.startsWith("cyan:")) {
                                       var79 = 3;
                                       var52 = var52.substring("cyan:".length());
                                    } else if(var34.startsWith("purple:")) {
                                       var79 = 4;
                                       var52 = var52.substring("purple:".length());
                                    } else if(var34.startsWith("white:")) {
                                       var79 = 5;
                                       var52 = var52.substring("white:".length());
                                    } else if(var34.startsWith("flash1:")) {
                                       var79 = 6;
                                       var52 = var52.substring("flash1:".length());
                                    } else if(var34.startsWith("flash2:")) {
                                       var79 = 7;
                                       var52 = var52.substring("flash2:".length());
                                    } else if(var34.startsWith("flash3:")) {
                                       var79 = 8;
                                       var52 = var52.substring("flash3:".length());
                                    } else if(var34.startsWith("glow1:")) {
                                       var79 = 9;
                                       var52 = var52.substring("glow1:".length());
                                    } else if(var34.startsWith("glow2:")) {
                                       var79 = 10;
                                       var52 = var52.substring("glow2:".length());
                                    } else if(var34.startsWith("glow3:")) {
                                       var79 = 11;
                                       var52 = var52.substring("glow3:".length());
                                    } else if(client.field302 != 0) {
                                       if(var34.startsWith("yellow:")) {
                                          var79 = 0;
                                          var52 = var52.substring("yellow:".length());
                                       } else if(var34.startsWith("red:")) {
                                          var79 = 1;
                                          var52 = var52.substring("red:".length());
                                       } else if(var34.startsWith("green:")) {
                                          var79 = 2;
                                          var52 = var52.substring("green:".length());
                                       } else if(var34.startsWith("cyan:")) {
                                          var79 = 3;
                                          var52 = var52.substring("cyan:".length());
                                       } else if(var34.startsWith("purple:")) {
                                          var79 = 4;
                                          var52 = var52.substring("purple:".length());
                                       } else if(var34.startsWith("white:")) {
                                          var79 = 5;
                                          var52 = var52.substring("white:".length());
                                       } else if(var34.startsWith("flash1:")) {
                                          var79 = 6;
                                          var52 = var52.substring("flash1:".length());
                                       } else if(var34.startsWith("flash2:")) {
                                          var79 = 7;
                                          var52 = var52.substring("flash2:".length());
                                       } else if(var34.startsWith("flash3:")) {
                                          var79 = 8;
                                          var52 = var52.substring("flash3:".length());
                                       } else if(var34.startsWith("glow1:")) {
                                          var79 = 9;
                                          var52 = var52.substring("glow1:".length());
                                       } else if(var34.startsWith("glow2:")) {
                                          var79 = 10;
                                          var52 = var52.substring("glow2:".length());
                                       } else if(var34.startsWith("glow3:")) {
                                          var79 = 11;
                                          var52 = var52.substring("glow3:".length());
                                       }
                                    }

                                    var34 = var52.toLowerCase();
                                    byte var85 = 0;
                                    if(var34.startsWith("wave:")) {
                                       var85 = 1;
                                       var52 = var52.substring("wave:".length());
                                    } else if(var34.startsWith("wave2:")) {
                                       var85 = 2;
                                       var52 = var52.substring("wave2:".length());
                                    } else if(var34.startsWith("shake:")) {
                                       var85 = 3;
                                       var52 = var52.substring("shake:".length());
                                    } else if(var34.startsWith("scroll:")) {
                                       var85 = 4;
                                       var52 = var52.substring("scroll:".length());
                                    } else if(var34.startsWith("slide:")) {
                                       var85 = 5;
                                       var52 = var52.substring("slide:".length());
                                    } else if(client.field302 != 0) {
                                       if(var34.startsWith("wave:")) {
                                          var85 = 1;
                                          var52 = var52.substring("wave:".length());
                                       } else if(var34.startsWith("wave2:")) {
                                          var85 = 2;
                                          var52 = var52.substring("wave2:".length());
                                       } else if(var34.startsWith("shake:")) {
                                          var85 = 3;
                                          var52 = var52.substring("shake:".length());
                                       } else if(var34.startsWith("scroll:")) {
                                          var85 = 4;
                                          var52 = var52.substring("scroll:".length());
                                       } else if(var34.startsWith("slide:")) {
                                          var85 = 5;
                                          var52 = var52.substring("slide:".length());
                                       }
                                    }

                                    client.field318.method2757(26);
                                    client.field318.method2573(0);
                                    var20 = client.field318.field2011;
                                    client.field318.method2573(var36);
                                    client.field318.method2573(var79);
                                    client.field318.method2573(var85);
                                    class122 var82 = client.field318;
                                    var22 = var82.field2011;
                                    var24 = var52.length();
                                    byte[] var72 = new byte[var24];

                                    for(int var26 = 0; var26 < var24; ++var26) {
                                       char var27 = var52.charAt(var26);
                                       if((var27 <= 0 || var27 >= 128) && (var27 < 160 || var27 > 255)) {
                                          if(8364 == var27) {
                                             var72[var26] = -128;
                                          } else if(var27 == 8218) {
                                             var72[var26] = -126;
                                          } else if(402 == var27) {
                                             var72[var26] = -125;
                                          } else if(8222 == var27) {
                                             var72[var26] = -124;
                                          } else if(8230 == var27) {
                                             var72[var26] = -123;
                                          } else if(var27 == 8224) {
                                             var72[var26] = -122;
                                          } else if(8225 == var27) {
                                             var72[var26] = -121;
                                          } else if(710 == var27) {
                                             var72[var26] = -120;
                                          } else if(var27 == 8240) {
                                             var72[var26] = -119;
                                          } else if(352 == var27) {
                                             var72[var26] = -118;
                                          } else if(var27 == 8249) {
                                             var72[var26] = -117;
                                          } else if(338 == var27) {
                                             var72[var26] = -116;
                                          } else if(381 == var27) {
                                             var72[var26] = -114;
                                          } else if(8216 == var27) {
                                             var72[var26] = -111;
                                          } else if(var27 == 8217) {
                                             var72[var26] = -110;
                                          } else if(8220 == var27) {
                                             var72[var26] = -109;
                                          } else if(8221 == var27) {
                                             var72[var26] = -108;
                                          } else if(var27 == 8226) {
                                             var72[var26] = -107;
                                          } else if(var27 == 8211) {
                                             var72[var26] = -106;
                                          } else if(8212 == var27) {
                                             var72[var26] = -105;
                                          } else if(var27 == 732) {
                                             var72[var26] = -104;
                                          } else if(8482 == var27) {
                                             var72[var26] = -103;
                                          } else if(var27 == 353) {
                                             var72[var26] = -102;
                                          } else if(var27 == 8250) {
                                             var72[var26] = -101;
                                          } else if(339 == var27) {
                                             var72[var26] = -100;
                                          } else if(var27 == 382) {
                                             var72[var26] = -98;
                                          } else if(var27 == 376) {
                                             var72[var26] = -97;
                                          } else {
                                             var72[var26] = 63;
                                          }
                                       } else {
                                          var72[var26] = (byte)var27;
                                       }
                                    }

                                    var82.method2504(var72.length);
                                    var82.field2011 += class222.field3185.method2446(var72, 0, var72.length, var82.field2012, var82.field2011);
                                    client.field318.method2635(client.field318.field2011 - var20);
                                    continue;
                                 }

                                 if(var30 == 5009) {
                                    var6 -= 2;
                                    var52 = class36.field816[var6];
                                    var45 = class36.field816[var6 + 1];
                                    client.field318.method2757(39);
                                    client.field318.method2492(0);
                                    var33 = client.field318.field2011;
                                    client.field318.method2661(var52);
                                    class122 var75 = client.field318;
                                    var19 = var75.field2011;
                                    var74 = var45.length();
                                    byte[] var68 = new byte[var74];

                                    for(var23 = 0; var23 < var74; ++var23) {
                                       char var71 = var45.charAt(var23);
                                       if((var71 <= 0 || var71 >= 128) && (var71 < 160 || var71 > 255)) {
                                          if(var71 == 8364) {
                                             var68[var23] = -128;
                                          } else if(var71 == 8218) {
                                             var68[var23] = -126;
                                          } else if(var71 == 402) {
                                             var68[var23] = -125;
                                          } else if(var71 == 8222) {
                                             var68[var23] = -124;
                                          } else if(8230 == var71) {
                                             var68[var23] = -123;
                                          } else if(8224 == var71) {
                                             var68[var23] = -122;
                                          } else if(8225 == var71) {
                                             var68[var23] = -121;
                                          } else if(710 == var71) {
                                             var68[var23] = -120;
                                          } else if(8240 == var71) {
                                             var68[var23] = -119;
                                          } else if(var71 == 352) {
                                             var68[var23] = -118;
                                          } else if(var71 == 8249) {
                                             var68[var23] = -117;
                                          } else if(var71 == 338) {
                                             var68[var23] = -116;
                                          } else if(var71 == 381) {
                                             var68[var23] = -114;
                                          } else if(8216 == var71) {
                                             var68[var23] = -111;
                                          } else if(8217 == var71) {
                                             var68[var23] = -110;
                                          } else if(var71 == 8220) {
                                             var68[var23] = -109;
                                          } else if(8221 == var71) {
                                             var68[var23] = -108;
                                          } else if(8226 == var71) {
                                             var68[var23] = -107;
                                          } else if(8211 == var71) {
                                             var68[var23] = -106;
                                          } else if(8212 == var71) {
                                             var68[var23] = -105;
                                          } else if(732 == var71) {
                                             var68[var23] = -104;
                                          } else if(8482 == var71) {
                                             var68[var23] = -103;
                                          } else if(353 == var71) {
                                             var68[var23] = -102;
                                          } else if(var71 == 8250) {
                                             var68[var23] = -101;
                                          } else if(var71 == 339) {
                                             var68[var23] = -100;
                                          } else if(var71 == 382) {
                                             var68[var23] = -98;
                                          } else if(376 == var71) {
                                             var68[var23] = -97;
                                          } else {
                                             var68[var23] = 63;
                                          }
                                       } else {
                                          var68[var23] = (byte)var71;
                                       }
                                    }

                                    var75.method2504(var68.length);
                                    var75.field2011 += class222.field3185.method2446(var68, 0, var68.length, var75.field2012, var75.field2011);
                                    client.field318.method2589(client.field318.field2011 - var33);
                                    continue;
                                 }

                                 if(var30 == 5015) {
                                    if(null != class167.field2692 && class167.field2692.field59 != null) {
                                       var52 = class167.field2692.field59;
                                    } else {
                                       var52 = "";
                                    }

                                    class36.field816[var6++] = var52;
                                    continue;
                                 }

                                 if(var30 == 5016) {
                                    class36.field804[var5++] = client.field513;
                                    continue;
                                 }

                                 if(5017 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var44 = class36.field804;
                                    var33 = var5++;
                                    class27 var83 = (class27)class11.field188.get(Integer.valueOf(var15));
                                    if(null == var83) {
                                       var18 = 0;
                                    } else {
                                       var18 = var83.method650();
                                    }

                                    var44[var33] = var18;
                                    continue;
                                 }

                                 if(var30 == 5018) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    var44 = class36.field804;
                                    var33 = var5++;
                                    class35 var81 = (class35)class11.field186.method3823((long)var15);
                                    if(null == var81) {
                                       var18 = -1;
                                    } else if(class11.field185.field3109 == var81.field3114) {
                                       var18 = -1;
                                    } else {
                                       var18 = ((class35)var81.field3114).field794;
                                    }

                                    var44[var33] = var18;
                                    continue;
                                 }

                                 if(5019 == var30) {
                                    --var5;
                                    var15 = class36.field804[var5];
                                    class36.field804[var5++] = class131.method2847(var15);
                                    continue;
                                 }

                                 if(var30 == 5020) {
                                    --var6;
                                    var52 = class36.field816[var6];
                                    if(var52.equalsIgnoreCase("toggleroof")) {
                                       class41.field989.field164 = !class41.field989.field164;
                                       class11.method152();
                                       if(class41.field989.field164) {
                                          class103.method2289(99, "", "Roofs are now all hidden");
                                       } else {
                                          class103.method2289(99, "", "Roofs will only be removed selectively");
                                       }
                                    }

                                    if(var52.equalsIgnoreCase("displayfps")) {
                                       client.field311 = !client.field311;
                                    }

                                    if(client.field461 >= 2) {
                                       if(var52.equalsIgnoreCase("fpson")) {
                                          client.field311 = true;
                                       }

                                       if(var52.equalsIgnoreCase("fpsoff")) {
                                          client.field311 = false;
                                       }

                                       if(var52.equalsIgnoreCase("gc")) {
                                          System.gc();
                                       }

                                       if(var52.equalsIgnoreCase("clientdrop")) {
                                          class3.method44();
                                       }

                                       if(var52.equalsIgnoreCase("errortest") && 2 == client.field299) {
                                          throw new RuntimeException();
                                       }
                                    }

                                    client.field318.method2757(229);
                                    client.field318.method2573(var52.length() + 1);
                                    client.field318.method2661(var52);
                                    continue;
                                 }

                                 if(5021 == var30) {
                                    --var6;
                                    client.field514 = class36.field816[var6].toLowerCase().trim();
                                    continue;
                                 }

                                 if(var30 == 5022) {
                                    class36.field816[var6++] = client.field514;
                                    continue;
                                 }
                              }
                           }
                        } else {
                           if(var30 >= 2000) {
                              var30 -= 1000;
                              --var5;
                              var32 = class52.method1115(class36.field804[var5]);
                           } else {
                              var32 = var51?class36.field809:class36.field798;
                           }

                           if(1927 == var30) {
                              if(class36.field806 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(null == var32.field2876) {
                                 return;
                              }

                              class0 var39 = new class0();
                              var39.field2 = var32;
                              var39.field7 = var32.field2876;
                              var39.field10 = 1 + class36.field806;
                              client.field493.method3834(var0);
                              continue;
                           }
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var30 >= 2000) {
                        var30 -= 1000;
                        --var5;
                        var15 = class36.field804[var5];
                        var16 = class52.method1115(var15);
                     } else {
                        var16 = var51?class36.field809:class36.field798;
                     }

                     if(var30 == 1000) {
                        var5 -= 4;
                        var16.field2776 = class36.field804[var5];
                        var16.field2873 = class36.field804[1 + var5];
                        var16.field2857 = class36.field804[2 + var5];
                        var16.field2840 = class36.field804[3 + var5];
                        class134.method2877(var16);
                        class43.method950(var16);
                        if(var15 != -1 && 0 == var16.field2814) {
                           class34.method746(class173.field2830[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(1001 == var30) {
                        var5 -= 4;
                        var16.field2778 = class36.field804[var5];
                        var16.field2779 = class36.field804[var5 + 1];
                        var16.field2774 = class36.field804[var5 + 2];
                        var16.field2772 = class36.field804[var5 + 3];
                        class134.method2877(var16);
                        class43.method950(var16);
                        if(-1 != var15 && var16.field2814 == 0) {
                           class34.method746(class173.field2830[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(1003 == var30) {
                        --var5;
                        var17 = class36.field804[var5] == 1;
                        if(var17 != var16.field2787) {
                           var16.field2787 = var17;
                           class134.method2877(var16);
                        }
                        continue;
                     }

                     if(1005 == var30) {
                        --var5;
                        var16.field2900 = class36.field804[var5] == 1;
                        continue;
                     }

                     if(var30 == 1006) {
                        --var5;
                        var16.field2901 = class36.field804[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var30 < 5400) {
                  if(var30 == 5306) {
                     class36.field804[var5++] = class44.method979();
                     continue;
                  }

                  if(5307 == var30) {
                     --var5;
                     var15 = class36.field804[var5];
                     if(var15 == 1 || var15 == 2) {
                        class15.method171(var15);
                     }
                     continue;
                  }

                  if(5308 == var30) {
                     class36.field804[var5++] = class41.field989.field155;
                     continue;
                  }

                  if(5309 == var30) {
                     --var5;
                     var15 = class36.field804[var5];
                     if(var15 == 1 || var15 == 2) {
                        class41.field989.field155 = var15;
                        class11.method152();
                     }
                     continue;
                  }
               }

               if(var30 < 5600) {
                  if(var30 == 5504) {
                     var5 -= 2;
                     var15 = class36.field804[var5];
                     var36 = class36.field804[var5 + 1];
                     if(!client.field542) {
                        client.field378 = var15;
                        client.field388 = var36;
                     }
                     continue;
                  }

                  if(5505 == var30) {
                     class36.field804[var5++] = client.field378;
                     continue;
                  }

                  if(5506 == var30) {
                     class36.field804[var5++] = client.field388;
                     continue;
                  }

                  if(5530 == var30) {
                     --var5;
                     var15 = class36.field804[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     client.field384 = var15;
                     continue;
                  }

                  if(5531 == var30) {
                     class36.field804[var5++] = client.field384;
                     continue;
                  }
               }

               if(var30 < 5700 && var30 == 5630) {
                  client.field346 = 250;
               } else {
                  if(var30 < 6300) {
                     if(var30 == 6200) {
                        var5 -= 2;
                        client.field396 = (short)class36.field804[var5];
                        if(client.field396 <= 0) {
                           client.field396 = 256;
                        }

                        client.field549 = (short)class36.field804[var5 + 1];
                        if(client.field549 <= 0) {
                           client.field549 = 205;
                        }
                        continue;
                     }

                     if(6201 == var30) {
                        var5 -= 2;
                        client.field564 = (short)class36.field804[var5];
                        if(client.field564 <= 0) {
                           client.field564 = 256;
                        }

                        client.field551 = (short)class36.field804[1 + var5];
                        if(client.field551 <= 0) {
                           client.field551 = 320;
                        }
                        continue;
                     }

                     if(var30 == 6202) {
                        var5 -= 4;
                        client.field383 = (short)class36.field804[var5];
                        if(client.field383 <= 0) {
                           client.field383 = 1;
                        }

                        client.field553 = (short)class36.field804[1 + var5];
                        if(client.field553 <= 0) {
                           client.field553 = 32767;
                        } else if(client.field553 < client.field383) {
                           client.field553 = client.field383;
                        }

                        client.field527 = (short)class36.field804[2 + var5];
                        if(client.field527 <= 0) {
                           client.field527 = 1;
                        }

                        client.field555 = (short)class36.field804[var5 + 3];
                        if(client.field555 <= 0) {
                           client.field555 = 32767;
                        } else if(client.field555 < client.field527) {
                           client.field555 = client.field527;
                        }
                        continue;
                     }

                     if(6203 == var30) {
                        if(null != client.field466) {
                           class39.method814(0, 0, client.field466.field2767, client.field466.field2783, false);
                           class36.field804[var5++] = client.field306;
                           class36.field804[var5++] = client.field559;
                        } else {
                           class36.field804[var5++] = -1;
                           class36.field804[var5++] = -1;
                        }
                        continue;
                     }

                     if(6204 == var30) {
                        class36.field804[var5++] = client.field564;
                        class36.field804[var5++] = client.field551;
                        continue;
                     }

                     if(var30 == 6205) {
                        class36.field804[var5++] = client.field396;
                        class36.field804[var5++] = client.field549;
                        continue;
                     }
                  }

                  if(var30 < 6600) {
                     if(var30 == 6500) {
                        class36.field804[var5++] = class10.method129()?1:0;
                        continue;
                     }

                     class25 var110;
                     if(6501 == var30) {
                        class25.field643 = 0;
                        var110 = class3.method47();
                        if(null != var110) {
                           class36.field804[var5++] = var110.field650;
                           class36.field804[var5++] = var110.field647;
                           class36.field816[var6++] = var110.field639;
                           class36.field804[var5++] = var110.field648;
                           class36.field804[var5++] = var110.field638;
                           class36.field816[var6++] = var110.field649;
                        } else {
                           class36.field804[var5++] = -1;
                           class36.field804[var5++] = 0;
                           class36.field816[var6++] = "";
                           class36.field804[var5++] = 0;
                           class36.field804[var5++] = 0;
                           class36.field816[var6++] = "";
                        }
                        continue;
                     }

                     if(6502 == var30) {
                        var110 = class3.method47();
                        if(var110 != null) {
                           class36.field804[var5++] = var110.field650;
                           class36.field804[var5++] = var110.field647;
                           class36.field816[var6++] = var110.field639;
                           class36.field804[var5++] = var110.field648;
                           class36.field804[var5++] = var110.field638;
                           class36.field816[var6++] = var110.field649;
                        } else {
                           class36.field804[var5++] = -1;
                           class36.field804[var5++] = 0;
                           class36.field816[var6++] = "";
                           class36.field804[var5++] = 0;
                           class36.field804[var5++] = 0;
                           class36.field816[var6++] = "";
                        }
                        continue;
                     }

                     class25 var105;
                     if(var30 == 6506) {
                        --var5;
                        var15 = class36.field804[var5];
                        var105 = null;

                        for(var33 = 0; var33 < class25.field642; ++var33) {
                           if(class189.field3062[var33].field650 == var15) {
                              var105 = class189.field3062[var33];
                              break;
                           }
                        }

                        if(null != var105) {
                           class36.field804[var5++] = var105.field650;
                           class36.field804[var5++] = var105.field647;
                           class36.field816[var6++] = var105.field639;
                           class36.field804[var5++] = var105.field648;
                           class36.field804[var5++] = var105.field638;
                           class36.field816[var6++] = var105.field649;
                        } else {
                           class36.field804[var5++] = -1;
                           class36.field804[var5++] = 0;
                           class36.field816[var6++] = "";
                           class36.field804[var5++] = 0;
                           class36.field804[var5++] = 0;
                           class36.field816[var6++] = "";
                        }
                        continue;
                     }

                     if(6507 == var30) {
                        var5 -= 4;
                        var15 = class36.field804[var5];
                        var49 = class36.field804[var5 + 1] == 1;
                        var33 = class36.field804[var5 + 2];
                        var56 = 1 == class36.field804[var5 + 3];
                        if(class189.field3062 != null) {
                           class3.method42(0, class189.field3062.length - 1, var15, var49, var33, var56);
                        }
                        continue;
                     }

                     if(6511 == var30) {
                        --var5;
                        var15 = class36.field804[var5];
                        if(var15 >= 0 && var15 < class25.field642) {
                           var105 = class189.field3062[var15];
                           class36.field804[var5++] = var105.field650;
                           class36.field804[var5++] = var105.field647;
                           class36.field816[var6++] = var105.field639;
                           class36.field804[var5++] = var105.field648;
                           class36.field804[var5++] = var105.field638;
                           class36.field816[var6++] = var105.field649;
                           continue;
                        }

                        class36.field804[var5++] = -1;
                        class36.field804[var5++] = 0;
                        class36.field816[var6++] = "";
                        class36.field804[var5++] = 0;
                        class36.field804[var5++] = 0;
                        class36.field816[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var29) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3123).append(" ");

            for(var13 = class36.field812 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field808[var13].field226.field3123).append(" ");
            }

            var12.append("").append(var10);
            class0.method0(var12.toString(), var29);
         }
      }
   }

   @ObfuscatedName("w")
   public static class50 method163(int var0) {
      class50 var1 = (class50)class50.field1108.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class50.field1110.method3335(5, var0);
         var1 = new class50();
         if(null != var2) {
            var1.method1046(new class119(var2));
         }

         class50.field1108.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   static final int method164(class212 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3148) {
         case 6:
            return 20;
         default:
            return 12;
         }
      }
   }
}

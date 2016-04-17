import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class164 {
   @ObfuscatedName("d")
   static final char[] field2646 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("c")
   static final char[] field2647 = new char[]{'[', ']', '#'};

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method3338(boolean var0) {
      client.field418 = 0;
      client.field336 = 0;
      client.field441.method2866();
      int var1 = client.field441.method2863(8);
      int var2;
      if(var1 < client.field343) {
         for(var2 = var1; var2 < client.field343; ++var2) {
            client.field380[++client.field418 - 1] = client.field335[var2];
         }
      }

      if(var1 > client.field343) {
         throw new RuntimeException("");
      } else {
         client.field343 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = client.field335[var2];
            class34 var4 = client.field546[var3];
            var5 = client.field441.method2863(1);
            if(0 == var5) {
               client.field335[++client.field343 - 1] = var3;
               var4.field823 = client.field306;
            } else {
               var6 = client.field441.method2863(2);
               if(var6 == 0) {
                  client.field335[++client.field343 - 1] = var3;
                  var4.field823 = client.field306;
                  client.field337[++client.field336 - 1] = var3;
               } else if(1 == var6) {
                  client.field335[++client.field343 - 1] = var3;
                  var4.field823 = client.field306;
                  var7 = client.field441.method2863(3);
                  var4.method802(var7, (byte)1);
                  var8 = client.field441.method2863(1);
                  if(1 == var8) {
                     client.field337[++client.field336 - 1] = var3;
                  }
               } else if(2 == var6) {
                  client.field335[++client.field343 - 1] = var3;
                  var4.field823 = client.field306;
                  var7 = client.field441.method2863(3);
                  var4.method802(var7, (byte)2);
                  var8 = client.field441.method2863(3);
                  var4.method802(var8, (byte)2);
                  int var9 = client.field441.method2863(1);
                  if(1 == var9) {
                     client.field337[++client.field336 - 1] = var3;
                  }
               } else if(3 == var6) {
                  client.field380[++client.field418 - 1] = var3;
               }
            }
         }

         class7.method139(var0);

         for(var1 = 0; var1 < client.field336; ++var1) {
            var2 = client.field337[var1];
            class34 var10 = client.field546[var2];
            int var11 = client.field441.method2613();
            if(0 != (var11 & 128)) {
               var5 = client.field441.method2615();
               var6 = client.field441.method2648();
               var7 = var10.field844 - (var5 - class144.field2204 - class144.field2204) * 64;
               var8 = var10.field819 - (var6 - class3.field67 - class3.field67) * 64;
               if(0 != var7 || var8 != 0) {
                  var10.field827 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
               }
            }

            if(0 != (var11 & 1)) {
               var10.field784 = class28.method734(client.field441.method2615());
               var10.field841 = var10.field784.field887;
               var10.field869 = var10.field784.field915;
               var10.field825 = var10.field784.field904;
               var10.field839 = var10.field784.field911;
               var10.field836 = var10.field784.field900;
               var10.field828 = var10.field784.field901;
               var10.field822 = var10.field784.field895;
               var10.field878 = var10.field784.field913;
               var10.field824 = var10.field784.field897;
            }

            if((var11 & 16) != 0) {
               var10.field842 = client.field441.method2631();
               if(var10.field842 == '\uffff') {
                  var10.field842 = -1;
               }
            }

            if((var11 & 2) != 0) {
               var5 = client.field441.method2613();
               var6 = client.field441.method2640();
               var10.method837(var5, var6, client.field306);
               var10.field870 = 300 + client.field306;
               var10.field840 = client.field441.method2597();
               var10.field831 = client.field441.method2597();
            }

            if(0 != (var11 & 8)) {
               var5 = client.field441.method2615();
               if(var5 == '\uffff') {
                  var5 = -1;
               }

               var6 = client.field441.method2639();
               if(var5 == var10.field848 && -1 != var5) {
                  var7 = class96.method2279(var5).field1005;
                  if(1 == var7) {
                     var10.field849 = 0;
                     var10.field872 = 0;
                     var10.field851 = var6;
                     var10.field852 = 0;
                  }

                  if(var7 == 2) {
                     var10.field852 = 0;
                  }
               } else if(var5 == -1 || -1 == var10.field848 || class96.method2279(var5).field999 >= class96.method2279(var10.field848).field999) {
                  var10.field848 = var5;
                  var10.field849 = 0;
                  var10.field872 = 0;
                  var10.field851 = var6;
                  var10.field852 = 0;
                  var10.field875 = var10.field821;
               }
            }

            if((var11 & 64) != 0) {
               var10.field830 = client.field441.method2621();
               var10.field856 = 100;
            }

            if(0 != (var11 & 4)) {
               var10.field865 = client.field441.method2631();
               var5 = client.field441.method2746();
               var10.field857 = var5 >> 16;
               var10.field850 = client.field306 + (var5 & '\uffff');
               var10.field854 = 0;
               var10.field855 = 0;
               if(var10.field850 > client.field306) {
                  var10.field854 = -1;
               }

               if(var10.field865 == '\uffff') {
                  var10.field865 = -1;
               }
            }

            if(0 != (var11 & 32)) {
               var5 = client.field441.method2639();
               var6 = client.field441.method2639();
               var10.method837(var5, var6, client.field306);
               var10.field870 = client.field306 + 300;
               var10.field840 = client.field441.method2597();
               var10.field831 = client.field441.method2648();
            }
         }

         for(var1 = 0; var1 < client.field418; ++var1) {
            var2 = client.field380[var1];
            if(client.field306 != client.field546[var2].field823) {
               client.field546[var2].field784 = null;
               client.field546[var2] = null;
            }
         }

         if(client.field341 != client.field441.field1992) {
            throw new RuntimeException(client.field441.field1992 + "," + client.field341);
         } else {
            for(var1 = 0; var1 < client.field343; ++var1) {
               if(client.field546[client.field335[var1]] == null) {
                  throw new RuntimeException(var1 + "," + client.field343);
               }
            }

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "10915"
   )
   static final void method3339() {
      if(client.field313 > 1) {
         --client.field313;
      }

      if(client.field401 > 0) {
         --client.field401;
      }

      if(client.field349) {
         client.field349 = false;
         class191.method3834();
      } else {
         if(!client.field433) {
            client.field439[0] = "Cancel";
            client.field440[0] = "";
            client.field437[0] = 1006;
            client.field434 = 1;
         }

         int var0;
         int var2;
         String var3;
         int var4;
         int var5;
         int var6;
         int var9;
         int var11;
         int var27;
         boolean var31;
         int var36;
         long var41;
         int var42;
         class173 var48;
         int var54;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var1;
            if(null == class127.field2047) {
               var1 = false;
            } else {
               label2974: {
                  try {
                     var2 = class127.field2047.method3098();
                     if(var2 == 0) {
                        var1 = false;
                        break label2974;
                     }

                     if(client.field394 == -1) {
                        class127.field2047.method3099(client.field441.field1993, 0, 1);
                        client.field441.field1992 = 0;
                        client.field394 = client.field441.method2865();
                        client.field341 = class188.field3057[client.field394];
                        --var2;
                     }

                     if(-1 == client.field341) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label2974;
                        }

                        class127.field2047.method3099(client.field441.field1993, 0, 1);
                        client.field341 = client.field441.field1993[0] & 255;
                        --var2;
                     }

                     if(-2 == client.field341) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label2974;
                        }

                        class127.field2047.method3099(client.field441.field1993, 0, 2);
                        client.field441.field1992 = 0;
                        client.field341 = client.field441.method2615();
                        var2 -= 2;
                     }

                     if(var2 < client.field341) {
                        var1 = false;
                        break label2974;
                     }

                     client.field441.field1992 = 0;
                     class127.field2047.method3099(client.field441.field1993, 0, client.field341);
                     client.field371 = 0;
                     client.field436 = client.field576;
                     client.field576 = client.field471 * -1;
                     client.field471 = client.field394 * -1;
                     class173 var30;
                     if(137 == client.field394) {
                        var27 = client.field441.method2597();
                        var4 = client.field441.method2656();
                        var30 = class20.method641(var4);
                        if(2 != var30.field2801 || var27 != var30.field2869) {
                           var30.field2801 = 2;
                           var30.field2869 = var27;
                           class23.method657(var30);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 254) {
                        var3 = client.field441.method2621();
                        var4 = client.field441.method2618();
                        var30 = class20.method641(var4);
                        if(!var3.equals(var30.field2769)) {
                           var30.field2769 = var3;
                           class23.method657(var30);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 47) {
                        class39.method871();
                        var27 = client.field441.method2641();
                        var4 = client.field441.method2639();
                        var5 = client.field441.method2657();
                        client.field479[var4] = var5;
                        client.field429[var4] = var27;
                        client.field430[var4] = 1;

                        for(var6 = 0; var6 < 98; ++var6) {
                           if(var5 >= class155.field2290[var6]) {
                              client.field430[var4] = 2 + var6;
                           }
                        }

                        client.field483[++client.field484 - 1 & 31] = var4;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(255 == client.field394) {
                        class7.method142();
                        client.field394 = -1;
                        var1 = false;
                        break label2974;
                     }

                     class122 var44;
                     if(client.field394 == 198) {
                        class9.method162(true);
                        client.field441.method2865();
                        var27 = client.field441.method2615();
                        var44 = client.field441;
                        var5 = var44.field1992;
                        class32.field769 = 0;
                        class76.method1765(var44);
                        class2.method44(var44);
                        if(var44.field1992 - var5 != var27) {
                           throw new RuntimeException(var44.field1992 - var5 + " " + var27);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(61 == client.field394) {
                        method3338(true);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(190 == client.field394) {
                        client.field528 = client.field441.method2613();
                        if(client.field528 == 255) {
                           client.field528 = 0;
                        }

                        client.field347 = client.field441.method2613();
                        if(255 == client.field347) {
                           client.field347 = 0;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 128) {
                        var27 = client.field441.method2615();
                        client.field452 = var27;
                        class47.method1085(false);
                        class47.method1079(var27);
                        class219.method4071(client.field452);

                        for(var4 = 0; var4 < 100; ++var4) {
                           client.field323[var4] = true;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     class3 var34;
                     if(180 == client.field394) {
                        var27 = client.field441.method2656();
                        var4 = client.field441.method2613();
                        var5 = client.field441.method2615();
                        var34 = (class3)client.field453.method3868((long)var27);
                        if(var34 != null) {
                           class31.method777(var34, var5 != var34.field70);
                        }

                        class137.method3039(var27, var5, var4);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(22 == client.field394) {
                        var4 = client.field441.method2613();
                        class130[] var91 = class99.method2285();
                        var6 = 0;

                        class130 var95;
                        while(true) {
                           if(var6 >= var91.length) {
                              var95 = null;
                              break;
                           }

                           class130 var86 = var91[var6];
                           if(var4 == var86.field2062) {
                              var95 = var86;
                              break;
                           }

                           ++var6;
                        }

                        class11.field189 = var95;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(44 == client.field394) {
                        class34.field785 = client.field441.method2613();
                        class87.field1538 = client.field441.method2639();

                        for(var27 = class87.field1538; var27 < 8 + class87.field1538; ++var27) {
                           for(var4 = class34.field785; var4 < class34.field785 + 8; ++var4) {
                              if(null != client.field425[class42.field1002][var27][var4]) {
                                 client.field425[class42.field1002][var27][var4] = null;
                                 class130.method2949(var27, var4);
                              }
                           }
                        }

                        for(class16 var93 = (class16)client.field426.method3926(); null != var93; var93 = (class16)client.field426.method3902()) {
                           if(var93.field238 >= class87.field1538 && var93.field238 < 8 + class87.field1538 && var93.field243 >= class34.field785 && var93.field243 < 8 + class34.field785 && class42.field1002 == var93.field242) {
                              var93.field247 = 0;
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(110 == client.field394) {
                        client.field313 = client.field441.method2597() * 30;
                        client.field342 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     long var38;
                     long var55;
                     long var71;
                     if(95 == client.field394) {
                        var3 = client.field441.method2621();
                        var41 = client.field441.method2619();
                        var38 = (long)client.field441.method2615();
                        var55 = (long)client.field441.method2617();
                        class152[] var67 = new class152[]{class152.field2261, class152.field2268, class152.field2262, class152.field2263, class152.field2265};
                        class152 var65 = (class152)class125.method2926(var67, client.field441.method2613());
                        var71 = var55 + (var38 << 32);
                        boolean var80 = false;

                        for(int var15 = 0; var15 < 100; ++var15) {
                           if(var71 == client.field499[var15]) {
                              var80 = true;
                              break;
                           }
                        }

                        if(var65.field2259 && class33.method800(var3)) {
                           var80 = true;
                        }

                        if(!var80 && client.field366 == 0) {
                           client.field499[client.field515] = var71;
                           client.field515 = (1 + client.field515) % 100;
                           String var78 = class223.method4115(class1.method14(class130.method2950(client.field441)));
                           if(var65.field2260 != -1) {
                              int var17 = var65.field2260;
                              String var16 = "<img=" + var17 + ">";
                              class40.method899(9, var16 + var3, var78, class187.method3824(var41));
                           } else {
                              class40.method899(9, var3, var78, class187.method3824(var41));
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 135) {
                        client.field562 = 1;
                        client.field486 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     String var56;
                     if(159 == client.field394) {
                        var3 = client.field441.method2621();
                        var56 = class223.method4115(class1.method14(class130.method2950(client.field441)));
                        class129.method2943(6, var3, var56);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(182 == client.field394) {
                        var27 = client.field441.method2618();
                        class3 var89 = (class3)client.field453.method3868((long)var27);
                        if(var89 != null) {
                           class31.method777(var89, true);
                        }

                        if(client.field526 != null) {
                           class23.method657(client.field526);
                           client.field526 = null;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     class173 var68;
                     if(client.field394 == 191) {
                        var27 = client.field441.method2656();
                        var4 = client.field441.method2618();
                        var5 = client.field441.method2648();
                        if(var5 == '\uffff') {
                           var5 = -1;
                        }

                        var68 = class20.method641(var4);
                        class51 var84;
                        if(!var68.field2757) {
                           if(var5 == -1) {
                              var68.field2801 = 0;
                              client.field394 = -1;
                              var1 = true;
                              break label2974;
                           }

                           var84 = class11.method178(var5);
                           var68.field2801 = 4;
                           var68.field2869 = var5;
                           var68.field2800 = var84.field1131;
                           var68.field2810 = var84.field1132;
                           var68.field2812 = var84.field1148 * 100 / var27;
                           class23.method657(var68);
                        } else {
                           var68.field2878 = var5;
                           var68.field2766 = var27;
                           var84 = class11.method178(var5);
                           var68.field2800 = var84.field1131;
                           var68.field2810 = var84.field1132;
                           var68.field2811 = var84.field1121;
                           var68.field2760 = var84.field1134;
                           var68.field2808 = var84.field1114;
                           var68.field2812 = var84.field1148;
                           if(var84.field1136 == 1) {
                              var68.field2816 = 1;
                           } else {
                              var68.field2816 = 2;
                           }

                           if(var68.field2813 > 0) {
                              var68.field2812 = var68.field2812 * 32 / var68.field2813;
                           } else if(var68.field2827 > 0) {
                              var68.field2812 = var68.field2812 * 32 / var68.field2827;
                           }

                           class23.method657(var68);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(127 == client.field394) {
                        var27 = client.field441.method2618();
                        var48 = class20.method641(var27);
                        var48.field2801 = 3;
                        var48.field2869 = class5.field93.field33.method3567();
                        class23.method657(var48);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 78) {
                        var27 = client.field441.method2618();
                        var4 = client.field441.method2615();
                        if(var27 < -70000) {
                           var4 += '耀';
                        }

                        if(var27 >= 0) {
                           var30 = class20.method641(var27);
                        } else {
                           var30 = null;
                        }

                        if(var30 != null) {
                           for(var6 = 0; var6 < var30.field2876.length; ++var6) {
                              var30.field2876[var6] = 0;
                              var30.field2877[var6] = 0;
                           }
                        }

                        class15 var85 = (class15)class15.field230.method3868((long)var4);
                        if(null != var85) {
                           for(var36 = 0; var36 < var85.field229.length; ++var36) {
                              var85.field229[var36] = -1;
                              var85.field234[var36] = 0;
                           }
                        }

                        var6 = client.field441.method2615();

                        for(var36 = 0; var36 < var6; ++var36) {
                           var42 = client.field441.method2648();
                           var9 = client.field441.method2613();
                           if(255 == var9) {
                              var9 = client.field441.method2746();
                           }

                           if(var30 != null && var36 < var30.field2876.length) {
                              var30.field2876[var36] = var42;
                              var30.field2877[var36] = var9;
                           }

                           class43.method1011(var4, var36, var42 - 1, var9);
                        }

                        if(null != var30) {
                           class23.method657(var30);
                        }

                        class39.method871();
                        client.field481[++client.field482 - 1 & 31] = var4 & 32767;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(27 == client.field394) {
                        var27 = client.field441.method2615();
                        var4 = client.field441.method2613();
                        var5 = client.field441.method2615();
                        class106.method2473(var27, var4, var5);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     boolean var47;
                     boolean var58;
                     if(client.field394 == 83) {
                        var3 = client.field441.method2621();
                        var4 = client.field441.method2615();
                        byte var88 = client.field441.method2699();
                        var47 = false;
                        if(-128 == var88) {
                           var47 = true;
                        }

                        if(var47) {
                           if(0 == class139.field2143) {
                              client.field394 = -1;
                              var1 = true;
                              break label2974;
                           }

                           var58 = false;

                           for(var36 = 0; var36 < class139.field2143 && (!class59.field1226[var36].field637.equals(var3) || class59.field1226[var36].field633 != var4); ++var36) {
                              ;
                           }

                           if(var36 < class139.field2143) {
                              while(var36 < class139.field2143 - 1) {
                                 class59.field1226[var36] = class59.field1226[1 + var36];
                                 ++var36;
                              }

                              --class139.field2143;
                              class59.field1226[class139.field2143] = null;
                           }
                        } else {
                           client.field441.method2621();
                           class24 var82 = new class24();
                           var82.field637 = var3;
                           var82.field630 = class23.method672(var82.field637, client.field551);
                           var82.field633 = var4;
                           var82.field631 = var88;

                           for(var42 = class139.field2143 - 1; var42 >= 0; --var42) {
                              var9 = class59.field1226[var42].field630.compareTo(var82.field630);
                              if(0 == var9) {
                                 class59.field1226[var42].field633 = var4;
                                 class59.field1226[var42].field631 = var88;
                                 if(var3.equals(class5.field93.field58)) {
                                    class6.field128 = var88;
                                 }

                                 client.field487 = client.field477;
                                 client.field394 = -1;
                                 var1 = true;
                                 break label2974;
                              }

                              if(var9 < 0) {
                                 break;
                              }
                           }

                           if(class139.field2143 >= class59.field1226.length) {
                              client.field394 = -1;
                              var1 = true;
                              break label2974;
                           }

                           for(var9 = class139.field2143 - 1; var9 > var42; --var9) {
                              class59.field1226[1 + var9] = class59.field1226[var9];
                           }

                           if(class139.field2143 == 0) {
                              class59.field1226 = new class24[100];
                           }

                           class59.field1226[var42 + 1] = var82;
                           ++class139.field2143;
                           if(var3.equals(class5.field93.field58)) {
                              class6.field128 = var88;
                           }
                        }

                        client.field487 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 210) {
                        for(var27 = 0; var27 < class52.field1169; ++var27) {
                           class52 var83 = class43.method1009(var27);
                           if(var83 != null) {
                              class176.field2906[var27] = 0;
                              class176.field2905[var27] = 0;
                           }
                        }

                        class39.method871();
                        client.field480 += 32;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 76) {
                        byte var92 = client.field441.method2643();
                        var4 = client.field441.method2615();
                        class176.field2906[var4] = var92;
                        if(var92 != class176.field2905[var4]) {
                           class176.field2905[var4] = var92;
                        }

                        class0.method2(var4);
                        client.field489[++client.field480 - 1 & 31] = var4;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(116 == client.field394) {
                        client.field314 = client.field441.method2613();
                        if(client.field314 == 1) {
                           client.field315 = client.field441.method2615();
                        }

                        if(client.field314 >= 2 && client.field314 <= 6) {
                           if(client.field314 == 2) {
                              client.field320 = 64;
                              client.field321 = 64;
                           }

                           if(client.field314 == 3) {
                              client.field320 = 0;
                              client.field321 = 64;
                           }

                           if(client.field314 == 4) {
                              client.field320 = 128;
                              client.field321 = 64;
                           }

                           if(5 == client.field314) {
                              client.field320 = 64;
                              client.field321 = 0;
                           }

                           if(client.field314 == 6) {
                              client.field320 = 64;
                              client.field321 = 128;
                           }

                           client.field314 = 2;
                           client.field391 = client.field441.method2615();
                           client.field318 = client.field441.method2615();
                           client.field319 = client.field441.method2613();
                        }

                        if(client.field314 == 10) {
                           client.field316 = client.field441.method2615();
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 11) {
                        var27 = client.field441.method2650();
                        var4 = client.field441.method2649();
                        var5 = client.field441.method2746();
                        var68 = class20.method641(var5);
                        if(var27 != var68.field2753 || var68.field2768 != var4 || var68.field2763 != 0 || 0 != var68.field2849) {
                           var68.field2753 = var27;
                           var68.field2768 = var4;
                           var68.field2763 = 0;
                           var68.field2849 = 0;
                           class23.method657(var68);
                           class96.method2278(var68);
                           if(0 == var68.field2824) {
                              class14.method202(class173.field2886[var5 >> 16], var68, false);
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(142 == client.field394) {
                        client.field542 = false;

                        for(var27 = 0; var27 < 5; ++var27) {
                           client.field543[var27] = false;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(211 == client.field394) {
                        class32.field771 = 0;

                        for(var27 = 0; var27 < 2048; ++var27) {
                           class32.field761[var27] = null;
                           class32.field772[var27] = 1;
                        }

                        for(var27 = 0; var27 < 2048; ++var27) {
                           client.field550[var27] = null;
                        }

                        class175.method3525(client.field441);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 9) {
                        var3 = client.field441.method2621();
                        Object[] var81 = new Object[var3.length() + 1];

                        for(var5 = var3.length() - 1; var5 >= 0; --var5) {
                           if(var3.charAt(var5) == 115) {
                              var81[1 + var5] = client.field441.method2621();
                           } else {
                              var81[var5 + 1] = new Integer(client.field441.method2618());
                           }
                        }

                        var81[0] = new Integer(client.field441.method2618());
                        class0 var87 = new class0();
                        var87.field4 = var81;
                        class168.method3449(var87, 200000);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(109 == client.field394) {
                        var27 = client.field441.method2656();
                        var4 = client.field441.method2648();
                        var30 = class20.method641(var27);
                        if(1 != var30.field2801 || var30.field2869 != var4) {
                           var30.field2801 = 1;
                           var30.field2869 = var4;
                           class23.method657(var30);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 52) {
                        class122 var90 = client.field441;
                        var4 = client.field341;
                        var5 = var90.field1992;
                        class32.field769 = 0;
                        class76.method1765(var90);
                        class2.method44(var90);
                        if(var90.field1992 - var5 != var4) {
                           throw new RuntimeException(var90.field1992 - var5 + " " + var4);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(57 == client.field394) {
                        var27 = client.field441.method2597();
                        var4 = client.field441.method2746();
                        var30 = class20.method641(var4);
                        if(var30 != null && var30.field2824 == 0) {
                           if(var27 > var30.field2765 - var30.field2774) {
                              var27 = var30.field2765 - var30.field2774;
                           }

                           if(var27 < 0) {
                              var27 = 0;
                           }

                           if(var30.field2780 != var27) {
                              var30.field2780 = var27;
                              class23.method657(var30);
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     String var32;
                     if(client.field394 == 84) {
                        var27 = client.field441.method2812();
                        var31 = client.field441.method2613() == 1;
                        var32 = "";
                        var47 = false;
                        if(var31) {
                           var32 = client.field441.method2621();
                           if(class33.method800(var32)) {
                              var47 = true;
                           }
                        }

                        String var74 = client.field441.method2621();
                        if(!var47) {
                           class129.method2943(var27, var32, var74);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 202 || 73 == client.field394 || client.field394 == 65 || 252 == client.field394 || client.field394 == 214 || 74 == client.field394 || client.field394 == 81 || client.field394 == 228 || client.field394 == 136 || client.field394 == 185) {
                        class123.method2901();
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(243 == client.field394) {
                        var27 = client.field441.method2615();
                        if(var27 == '\uffff') {
                           var27 = -1;
                        }

                        if(-1 == var27 && !client.field299) {
                           class9.method163();
                        } else if(-1 != var27 && client.field532 != var27 && 0 != client.field531 && !client.field299) {
                           class176.method3536(2, class38.field884, var27, 0, client.field531, false);
                        }

                        client.field532 = var27;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 87) {
                        var27 = client.field441.method2631();
                        if('\uffff' == var27) {
                           var27 = -1;
                        }

                        var4 = client.field441.method2752();
                        if(client.field531 != 0 && var27 != -1) {
                           class144.method3157(class36.field814, var27, 0, client.field531, false);
                           client.field299 = true;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 43) {
                        class39.method871();
                        client.field491 = client.field441.method2613();
                        client.field342 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     long var10;
                     if(client.field394 == 195) {
                        var27 = client.field441.method2618();
                        var4 = client.field441.method2618();
                        if(null == class27.field685 || !class27.field685.isValid()) {
                           try {
                              Iterator var76 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var76.hasNext()) {
                                 GarbageCollectorMXBean var75 = (GarbageCollectorMXBean)var76.next();
                                 if(var75.isValid()) {
                                    class27.field685 = var75;
                                    client.field572 = -1L;
                                    client.field490 = -1L;
                                 }
                              }
                           } catch (Throwable var21) {
                              ;
                           }
                        }

                        long var79 = class127.method2941();
                        var36 = -1;
                        if(class27.field685 != null) {
                           var55 = class27.field685.getCollectionTime();
                           if(client.field490 != -1L) {
                              var10 = var55 - client.field490;
                              var71 = var79 - client.field572;
                              if(var71 != 0L) {
                                 var36 = (int)(100L * var10 / var71);
                              }
                           }

                           client.field490 = var55;
                           client.field572 = var79;
                        }

                        client.field338.method2873(145);
                        client.field338.method2786(var27);
                        client.field338.method2655(var4);
                        client.field338.method2603(class144.field2185);
                        client.field338.method2603(var36);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 200) {
                        var27 = client.field441.method2746();
                        var4 = client.field441.method2615();
                        class176.field2906[var4] = var27;
                        if(class176.field2905[var4] != var27) {
                           class176.field2905[var4] = var27;
                        }

                        class0.method2(var4);
                        client.field489[++client.field480 - 1 & 31] = var4;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(64 == client.field394) {
                        var27 = client.field441.field1992 + client.field341;
                        var4 = client.field441.method2615();
                        var5 = client.field441.method2615();
                        if(var4 != client.field452) {
                           client.field452 = var4;
                           class47.method1085(false);
                           class47.method1079(client.field452);
                           class219.method4071(client.field452);

                           for(var6 = 0; var6 < 100; ++var6) {
                              client.field323[var6] = true;
                           }
                        }

                        class3 var60;
                        for(; var5-- > 0; var60.field66 = true) {
                           var6 = client.field441.method2618();
                           var36 = client.field441.method2615();
                           var42 = client.field441.method2613();
                           var60 = (class3)client.field453.method3868((long)var6);
                           if(null != var60 && var36 != var60.field70) {
                              class31.method777(var60, true);
                              var60 = null;
                           }

                           if(null == var60) {
                              var60 = class137.method3039(var6, var36, var42);
                           }
                        }

                        for(var34 = (class3)client.field453.method3871(); var34 != null; var34 = (class3)client.field453.method3867()) {
                           if(var34.field66) {
                              var34.field66 = false;
                           } else {
                              class31.method777(var34, true);
                           }
                        }

                        client.field495 = new class196(512);

                        while(client.field441.field1992 < var27) {
                           var6 = client.field441.method2618();
                           var36 = client.field441.method2615();
                           var42 = client.field441.method2615();
                           var9 = client.field441.method2618();

                           for(var54 = var36; var54 <= var42; ++var54) {
                              long var63 = (long)var54 + ((long)var6 << 32);
                              client.field495.method3875(new class201(var9), var63);
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 141) {
                        var27 = client.field441.method2615();
                        var4 = client.field441.method2746();
                        var5 = client.field441.method2631();
                        var68 = class20.method641(var4);
                        var68.field2779 = var27 + (var5 << 16);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(184 == client.field394) {
                        class39.method871();
                        client.field458 = client.field441.method2664();
                        client.field342 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     boolean var66;
                     if(233 == client.field394) {
                        var66 = client.field441.method2613() == 1;
                        if(var66) {
                           class30.field718 = class127.method2941() - client.field441.method2619();
                           class25.field656 = new class221(client.field441, true);
                        } else {
                           class25.field656 = null;
                        }

                        client.field365 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(85 == client.field394) {
                        while(client.field441.field1992 < client.field341) {
                           var66 = client.field441.method2613() == 1;
                           var56 = client.field441.method2621();
                           var32 = client.field441.method2621();
                           var6 = client.field441.method2615();
                           var36 = client.field441.method2613();
                           var42 = client.field441.method2613();
                           boolean var53 = 0 != (var42 & 2);
                           boolean var61 = (var42 & 1) != 0;
                           if(var6 > 0) {
                              client.field441.method2621();
                              client.field441.method2613();
                              client.field441.method2618();
                           }

                           client.field441.method2621();

                           for(var11 = 0; var11 < client.field561; ++var11) {
                              class17 var70 = client.field563[var11];
                              if(!var66) {
                                 if(var56.equals(var70.field261)) {
                                    if(var6 != var70.field256) {
                                       boolean var73 = true;

                                       for(class38 var77 = (class38)client.field501.method3866(); var77 != null; var77 = (class38)client.field501.method3863()) {
                                          if(var77.field882.equals(var56)) {
                                             if(var6 != 0 && var77.field879 == 0) {
                                                var77.method3994();
                                                var73 = false;
                                             } else if(var6 == 0 && var77.field879 != 0) {
                                                var77.method3994();
                                                var73 = false;
                                             }
                                          }
                                       }

                                       if(var73) {
                                          client.field501.method3862(new class38(var56, var6));
                                       }

                                       var70.field256 = var6;
                                    }

                                    var70.field262 = var32;
                                    var70.field257 = var36;
                                    var70.field258 = var53;
                                    var70.field263 = var61;
                                    var56 = null;
                                    break;
                                 }
                              } else if(var32.equals(var70.field261)) {
                                 var70.field261 = var56;
                                 var70.field262 = var32;
                                 var56 = null;
                                 break;
                              }
                           }

                           if(null != var56 && client.field561 < 400) {
                              class17 var62 = new class17();
                              client.field563[client.field561] = var62;
                              var62.field261 = var56;
                              var62.field262 = var32;
                              var62.field256 = var6;
                              var62.field257 = var36;
                              var62.field258 = var53;
                              var62.field263 = var61;
                              ++client.field561;
                           }
                        }

                        client.field562 = 2;
                        client.field486 = client.field477;
                        var66 = false;
                        var4 = client.field561;

                        while(var4 > 0) {
                           var66 = true;
                           --var4;

                           for(var5 = 0; var5 < var4; ++var5) {
                              var47 = false;
                              class17 var69 = client.field563[var5];
                              class17 var64 = client.field563[var5 + 1];
                              if(var69.field256 != client.field296 && client.field296 == var64.field256) {
                                 var47 = true;
                              }

                              if(!var47 && 0 == var69.field256 && var64.field256 != 0) {
                                 var47 = true;
                              }

                              if(!var47 && !var69.field258 && var64.field258) {
                                 var47 = true;
                              }

                              if(!var47 && !var69.field263 && var64.field263) {
                                 var47 = true;
                              }

                              if(var47) {
                                 class17 var57 = client.field563[var5];
                                 client.field563[var5] = client.field563[var5 + 1];
                                 client.field563[var5 + 1] = var57;
                                 var66 = false;
                              }
                           }

                           if(var66) {
                              break;
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 23) {
                        var66 = client.field441.method2641() == 1;
                        var4 = client.field441.method2618();
                        var30 = class20.method641(var4);
                        if(var66 != var30.field2778) {
                           var30.field2778 = var66;
                           class23.method657(var30);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(239 == client.field394) {
                        var27 = client.field441.method2746();
                        class17.field260 = class107.field1874.method3008(var27);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(10 == client.field394) {
                        var27 = client.field441.method2648();
                        var4 = client.field441.method2657();
                        var5 = var27 >> 10 & 31;
                        var6 = var27 >> 5 & 31;
                        var36 = var27 & 31;
                        var42 = (var36 << 3) + (var6 << 11) + (var5 << 19);
                        class173 var50 = class20.method641(var4);
                        if(var42 != var50.field2783) {
                           var50.field2783 = var42;
                           class23.method657(var50);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 157) {
                        client.field511 = client.field441.method2613();
                        client.field445 = client.field441.method2613();
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 164) {
                        class19.method259(client.field441.method2621());
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 50) {
                        var27 = client.field441.method2613();
                        if(client.field441.method2613() == 0) {
                           client.field570[var27] = new class220();
                           client.field441.field1992 += 18;
                        } else {
                           --client.field441.field1992;
                           client.field570[var27] = new class220(client.field441, false);
                        }

                        client.field405 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 175) {
                        var27 = client.field441.method2613();
                        var4 = client.field441.method2613();
                        var5 = client.field441.method2613();
                        var6 = client.field441.method2613();
                        client.field543[var27] = true;
                        client.field544[var27] = var4;
                        client.field559[var27] = var5;
                        client.field538[var27] = var6;
                        client.field547[var27] = 0;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(178 == client.field394) {
                        method3338(false);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 31) {
                        for(var27 = 0; var27 < class176.field2905.length; ++var27) {
                           if(class176.field2906[var27] != class176.field2905[var27]) {
                              class176.field2905[var27] = class176.field2906[var27];
                              class0.method2(var27);
                              client.field489[++client.field480 - 1 & 31] = var27;
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 152) {
                        var27 = client.field441.method2657();
                        var48 = class20.method641(var27);

                        for(var5 = 0; var5 < var48.field2876.length; ++var5) {
                           var48.field2876[var5] = -1;
                           var48.field2876[var5] = 0;
                        }

                        class23.method657(var48);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(219 == client.field394) {
                        client.field487 = client.field477;
                        if(0 == client.field341) {
                           client.field512 = null;
                           client.field522 = null;
                           class139.field2143 = 0;
                           class59.field1226 = null;
                           client.field394 = -1;
                           var1 = true;
                        } else {
                           client.field522 = client.field441.method2621();
                           long var49 = client.field441.method2619();
                           client.field512 = class50.method1123(var49);
                           class172.field2744 = client.field441.method2699();
                           var5 = client.field441.method2613();
                           if(255 == var5) {
                              client.field394 = -1;
                              var1 = true;
                           } else {
                              class139.field2143 = var5;
                              class24[] var40 = new class24[100];

                              for(var36 = 0; var36 < class139.field2143; ++var36) {
                                 var40[var36] = new class24();
                                 var40[var36].field637 = client.field441.method2621();
                                 var40[var36].field630 = class23.method672(var40[var36].field637, client.field551);
                                 var40[var36].field633 = client.field441.method2615();
                                 var40[var36].field631 = client.field441.method2699();
                                 client.field441.method2621();
                                 if(var40[var36].field637.equals(class5.field93.field58)) {
                                    class6.field128 = var40[var36].field631;
                                 }
                              }

                              var58 = false;
                              var9 = class139.field2143;

                              while(var9 > 0) {
                                 var58 = true;
                                 --var9;

                                 for(var54 = 0; var54 < var9; ++var54) {
                                    if(var40[var54].field630.compareTo(var40[var54 + 1].field630) > 0) {
                                       class24 var59 = var40[var54];
                                       var40[var54] = var40[1 + var54];
                                       var40[1 + var54] = var59;
                                       var58 = false;
                                    }
                                 }

                                 if(var58) {
                                    break;
                                 }
                              }

                              class59.field1226 = var40;
                              client.field394 = -1;
                              var1 = true;
                           }
                        }
                        break label2974;
                     }

                     if(96 == client.field394) {
                        class25 var45 = new class25();
                        var45.field655 = client.field441.method2621();
                        var45.field646 = client.field441.method2615();
                        var4 = client.field441.method2618();
                        var45.field647 = var4;
                        class3.method49(45);
                        class127.field2047.method3095();
                        class127.field2047 = null;
                        class35.method821(var45);
                        client.field394 = -1;
                        var1 = false;
                        break label2974;
                     }

                     if(35 == client.field394) {
                        if(client.field452 != -1) {
                           class124.method2904(client.field452, 0);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 33) {
                        client.field542 = true;
                        class2.field61 = client.field441.method2613();
                        class12.field193 = client.field441.method2613();
                        class28.field692 = client.field441.method2615();
                        class107.field1875 = client.field441.method2613();
                        class28.field693 = client.field441.method2613();
                        if(class28.field693 >= 100) {
                           class26.field673 = class2.field61 * 128 + 64;
                           class137.field2129 = class12.field193 * 128 + 64;
                           class46.field1070 = class34.method816(class26.field673, class137.field2129, class42.field1002) - class28.field692;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 124) {
                        class162.method3288(client.field441, client.field341);
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 187) {
                        client.field530 = client.field441.method2613();
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 196) {
                        var27 = client.field441.method2631();
                        if('\uffff' == var27) {
                           var27 = -1;
                        }

                        var4 = client.field441.method2657();
                        var5 = client.field441.method2615();
                        if('\uffff' == var5) {
                           var5 = -1;
                        }

                        var6 = client.field441.method2656();

                        for(var36 = var27; var36 <= var5; ++var36) {
                           var55 = ((long)var4 << 32) + (long)var36;
                           class208 var52 = client.field495.method3868(var55);
                           if(var52 != null) {
                              var52.method3998();
                           }

                           client.field495.method3875(new class201(var6), var55);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 12) {
                        class9.method162(false);
                        client.field441.method2865();
                        var27 = client.field441.method2615();
                        var44 = client.field441;
                        var5 = var44.field1992;
                        class32.field769 = 0;
                        class76.method1765(var44);
                        class2.method44(var44);
                        if(var44.field1992 - var5 != var27) {
                           throw new RuntimeException(var44.field1992 - var5 + " " + var27);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(167 == client.field394) {
                        client.field441.field1992 += 28;
                        if(client.field441.method2635()) {
                           class15.method211(client.field441, client.field441.field1992 - 28);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 188) {
                        class34.field785 = client.field441.method2641();
                        class87.field1538 = client.field441.method2641();

                        while(client.field441.field1992 < client.field341) {
                           client.field394 = client.field441.method2613();
                           class123.method2901();
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(251 == client.field394) {
                        var3 = client.field441.method2621();
                        var41 = (long)client.field441.method2615();
                        var38 = (long)client.field441.method2617();
                        class152[] var51 = new class152[]{class152.field2261, class152.field2268, class152.field2262, class152.field2263, class152.field2265};
                        class152 var46 = (class152)class125.method2926(var51, client.field441.method2613());
                        var10 = (var41 << 32) + var38;
                        boolean var12 = false;

                        for(int var13 = 0; var13 < 100; ++var13) {
                           if(var10 == client.field499[var13]) {
                              var12 = true;
                              break;
                           }
                        }

                        if(class33.method800(var3)) {
                           var12 = true;
                        }

                        if(!var12 && client.field366 == 0) {
                           client.field499[client.field515] = var10;
                           client.field515 = (1 + client.field515) % 100;
                           String var72 = class223.method4115(class1.method14(class130.method2950(client.field441)));
                           byte var14;
                           if(var46.field2266) {
                              var14 = 7;
                           } else {
                              var14 = 3;
                           }

                           if(var46.field2260 != -1) {
                              class129.method2943(var14, class124.method2912(var46.field2260) + var3, var72);
                           } else {
                              class129.method2943(var14, var3, var72);
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 117) {
                        var27 = client.field441.method2618();
                        var4 = client.field441.method2615();
                        if(var27 < -70000) {
                           var4 += '耀';
                        }

                        if(var27 >= 0) {
                           var30 = class20.method641(var27);
                        } else {
                           var30 = null;
                        }

                        for(; client.field441.field1992 < client.field341; class43.method1011(var4, var6, var36 - 1, var42)) {
                           var6 = client.field441.method2812();
                           var36 = client.field441.method2615();
                           var42 = 0;
                           if(0 != var36) {
                              var42 = client.field441.method2613();
                              if(var42 == 255) {
                                 var42 = client.field441.method2618();
                              }
                           }

                           if(null != var30 && var6 >= 0 && var6 < var30.field2876.length) {
                              var30.field2876[var6] = var36;
                              var30.field2877[var6] = var42;
                           }
                        }

                        if(var30 != null) {
                           class23.method657(var30);
                        }

                        class39.method871();
                        client.field481[++client.field482 - 1 & 31] = var4 & 32767;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(97 == client.field394) {
                        var27 = client.field441.method2639();
                        var4 = client.field441.method2641();
                        var32 = client.field441.method2621();
                        if(var4 >= 1 && var4 <= 8) {
                           if(var32.equalsIgnoreCase("null")) {
                              var32 = null;
                           }

                           client.field317[var4 - 1] = var32;
                           client.field422[var4 - 1] = 0 == var27;
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(26 == client.field394) {
                        client.field542 = true;
                        class16.field236 = client.field441.method2613();
                        class175.field2903 = client.field441.method2613();
                        class17.field266 = client.field441.method2615();
                        class14.field227 = client.field441.method2613();
                        class167.field2665 = client.field441.method2613();
                        if(class167.field2665 >= 100) {
                           var27 = 64 + class16.field236 * 128;
                           var4 = 64 + class175.field2903 * 128;
                           var5 = class34.method816(var27, var4, class42.field1002) - class17.field266;
                           var6 = var27 - class26.field673;
                           var36 = var5 - class46.field1070;
                           var42 = var4 - class137.field2129;
                           var9 = (int)Math.sqrt((double)(var42 * var42 + var6 * var6));
                           class59.field1227 = (int)(Math.atan2((double)var36, (double)var9) * 325.949D) & 2047;
                           class113.field1958 = (int)(Math.atan2((double)var6, (double)var42) * -325.949D) & 2047;
                           if(class59.field1227 < 128) {
                              class59.field1227 = 128;
                           }

                           if(class59.field1227 > 383) {
                              class59.field1227 = 383;
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 25) {
                        class87.field1538 = client.field441.method2639();
                        class34.field785 = client.field441.method2613();
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     class173 var7;
                     if(119 == client.field394) {
                        var27 = client.field441.method2657();
                        var4 = client.field441.method2657();
                        class3 var35 = (class3)client.field453.method3868((long)var27);
                        var34 = (class3)client.field453.method3868((long)var4);
                        if(var34 != null) {
                           class31.method777(var34, null == var35 || var34.field70 != var35.field70);
                        }

                        if(var35 != null) {
                           var35.method3998();
                           client.field453.method3875(var35, (long)var4);
                        }

                        var7 = class20.method641(var27);
                        if(var7 != null) {
                           class23.method657(var7);
                        }

                        var7 = class20.method641(var4);
                        if(null != var7) {
                           class23.method657(var7);
                           class14.method202(class173.field2886[var7.field2842 >>> 16], var7, true);
                        }

                        if(client.field452 != -1) {
                           class124.method2904(client.field452, 1);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 138) {
                        while(client.field441.field1992 < client.field341) {
                           var27 = client.field441.method2613();
                           var31 = (var27 & 1) == 1;
                           var32 = client.field441.method2621();
                           String var33 = client.field441.method2621();
                           client.field441.method2621();

                           for(var36 = 0; var36 < client.field397; ++var36) {
                              class7 var8 = client.field395[var36];
                              if(var31) {
                                 if(var33.equals(var8.field140)) {
                                    var8.field140 = var32;
                                    var8.field137 = var33;
                                    var32 = null;
                                    break;
                                 }
                              } else if(var32.equals(var8.field140)) {
                                 var8.field140 = var32;
                                 var8.field137 = var33;
                                 var32 = null;
                                 break;
                              }
                           }

                           if(null != var32 && client.field397 < 400) {
                              class7 var39 = new class7();
                              client.field395[client.field397] = var39;
                              var39.field140 = var32;
                              var39.field137 = var33;
                              ++client.field397;
                           }
                        }

                        client.field486 = client.field477;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(100 == client.field394) {
                        var27 = client.field441.method2648();
                        class15 var29 = (class15)class15.field230.method3868((long)var27);
                        if(null != var29) {
                           var29.method3998();
                        }

                        client.field481[++client.field482 - 1 & 31] = var27 & 32767;
                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(250 == client.field394) {
                        var27 = client.field441.method2664();
                        var4 = client.field441.method2656();
                        var30 = class20.method641(var4);
                        if(var30.field2805 != var27 || var27 == -1) {
                           var30.field2805 = var27;
                           var30.field2771 = 0;
                           var30.field2856 = 0;
                           class23.method657(var30);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 242) {
                        var27 = client.field441.method2746();
                        var4 = client.field441.method2648();
                        var5 = client.field441.method2648();
                        var6 = client.field441.method2648();
                        var7 = class20.method641(var27);
                        if(var7.field2800 != var5 || var7.field2810 != var4 || var7.field2812 != var6) {
                           var7.field2800 = var5;
                           var7.field2810 = var4;
                           var7.field2812 = var6;
                           class23.method657(var7);
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     if(client.field394 == 105) {
                        for(var27 = 0; var27 < client.field550.length; ++var27) {
                           if(client.field550[var27] != null) {
                              client.field550[var27].field848 = -1;
                           }
                        }

                        for(var27 = 0; var27 < client.field546.length; ++var27) {
                           if(null != client.field546[var27]) {
                              client.field546[var27].field848 = -1;
                           }
                        }

                        client.field394 = -1;
                        var1 = true;
                        break label2974;
                     }

                     class22.method655("" + client.field394 + "," + client.field576 + "," + client.field436 + "," + client.field341, (Throwable)null);
                     class7.method142();
                  } catch (IOException var22) {
                     class191.method3834();
                  } catch (Exception var23) {
                     var3 = "" + client.field394 + "," + client.field576 + "," + client.field436 + "," + client.field341 + "," + (class144.field2204 + class5.field93.field871[0]) + "," + (class3.field67 + class5.field93.field835[0]) + ",";

                     for(var4 = 0; var4 < client.field341 && var4 < 50; ++var4) {
                        var3 = var3 + client.field441.field1993[var4] + ",";
                     }

                     class22.method655(var3, var23);
                     class7.method142();
                  }

                  var1 = true;
               }
            }

            if(!var1) {
               break;
            }
         }

         if(30 == client.field554) {
            while(class38.method855()) {
               client.field338.method2873(140);
               client.field338.method2603(0);
               var0 = client.field338.field1992;
               class107.method2485(client.field338);
               client.field338.method2610(client.field338.field1992 - var0);
            }

            Object var24 = class121.field2008.field206;
            int var99;
            synchronized(class121.field2008.field206) {
               if(!client.field295) {
                  class121.field2008.field208 = 0;
               } else if(class140.field2157 != 0 || class121.field2008.field208 >= 40) {
                  client.field338.method2873(149);
                  client.field338.method2603(0);
                  var99 = client.field338.field1992;
                  var2 = 0;

                  for(var27 = 0; var27 < class121.field2008.field208 && client.field338.field1992 - var99 < 240; ++var27) {
                     ++var2;
                     var4 = class121.field2008.field209[var27];
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 502) {
                        var4 = 502;
                     }

                     var5 = class121.field2008.field212[var27];
                     if(var5 < 0) {
                        var5 = 0;
                     } else if(var5 > 764) {
                        var5 = 764;
                     }

                     var6 = var5 + 765 * var4;
                     if(class121.field2008.field209[var27] == -1 && class121.field2008.field212[var27] == -1) {
                        var5 = -1;
                        var4 = -1;
                        var6 = 524287;
                     }

                     if(var5 == client.field308 && var4 == client.field309) {
                        if(client.field310 < 2047) {
                           ++client.field310;
                        }
                     } else {
                        var36 = var5 - client.field308;
                        client.field308 = var5;
                        var42 = var4 - client.field309;
                        client.field309 = var4;
                        if(client.field310 < 8 && var36 >= -32 && var36 <= 31 && var42 >= -32 && var42 <= 31) {
                           var36 += 32;
                           var42 += 32;
                           client.field338.method2599(var42 + (client.field310 << 12) + (var36 << 6));
                           client.field310 = 0;
                        } else if(client.field310 < 8) {
                           client.field338.method2675((client.field310 << 19) + 8388608 + var6);
                           client.field310 = 0;
                        } else {
                           client.field338.method2786(var6 + -1073741824 + (client.field310 << 19));
                           client.field310 = 0;
                        }
                     }
                  }

                  client.field338.method2610(client.field338.field1992 - var99);
                  if(var2 >= class121.field2008.field208) {
                     class121.field2008.field208 = 0;
                  } else {
                     class121.field2008.field208 -= var2;

                     for(var27 = 0; var27 < class121.field2008.field208; ++var27) {
                        class121.field2008.field212[var27] = class121.field2008.field212[var2 + var27];
                        class121.field2008.field209[var27] = class121.field2008.field209[var2 + var27];
                     }
                  }
               }
            }

            if(class140.field2157 == 1 || !class7.field143 && class140.field2157 == 4 || 2 == class140.field2157) {
               long var25 = (class140.field2158 - client.field304) / 50L;
               if(var25 > 4095L) {
                  var25 = 4095L;
               }

               client.field304 = class140.field2158;
               var2 = class140.field2159;
               if(var2 < 0) {
                  var2 = 0;
               } else if(var2 > class98.field1671) {
                  var2 = class98.field1671;
               }

               var27 = class140.field2160;
               if(var27 < 0) {
                  var27 = 0;
               } else if(var27 > class37.field876) {
                  var27 = class37.field876;
               }

               var4 = (int)var25;
               client.field338.method2873(217);
               client.field338.method2599((2 == class140.field2157?1:0) + (var4 << 1));
               client.field338.method2599(var27);
               client.field338.method2599(var2);
            }

            if(class137.field2123 > 0) {
               client.field338.method2873(212);
               client.field338.method2599(0);
               var0 = client.field338.field1992;
               long var100 = class127.method2941();

               for(var27 = 0; var27 < class137.field2123; ++var27) {
                  var41 = var100 - client.field351;
                  if(var41 > 16777215L) {
                     var41 = 16777215L;
                  }

                  client.field351 = var100;
                  client.field338.method2743(class137.field2122[var27]);
                  client.field338.method2651((int)var41);
               }

               client.field338.method2811(client.field338.field1992 - var0);
            }

            if(client.field355 > 0) {
               --client.field355;
            }

            if(class137.field2115[96] || class137.field2115[97] || class137.field2115[98] || class137.field2115[99]) {
               client.field348 = true;
            }

            if(client.field348 && client.field355 <= 0) {
               client.field355 = 20;
               client.field348 = false;
               client.field338.method2873(32);
               client.field338.method2634(client.field379);
               client.field338.method2634(client.field564);
            }

            if(class121.field2010 && !client.field300) {
               client.field300 = true;
               client.field338.method2873(100);
               client.field338.method2603(1);
            }

            if(!class121.field2010 && client.field300) {
               client.field300 = false;
               client.field338.method2873(100);
               client.field338.method2603(0);
            }

            class168.method3458();
            if(30 == client.field554) {
               for(class16 var26 = (class16)client.field426.method3926(); var26 != null; var26 = (class16)client.field426.method3902()) {
                  if(var26.field247 > 0) {
                     --var26.field247;
                  }

                  if(0 == var26.field247) {
                     if(var26.field240 < 0 || class89.method2162(var26.field240, var26.field249)) {
                        class39.method887(var26.field242, var26.field237, var26.field238, var26.field243, var26.field240, var26.field245, var26.field249);
                        var26.method3998();
                     }
                  } else {
                     if(var26.field239 > 0) {
                        --var26.field239;
                     }

                     if(var26.field239 == 0 && var26.field238 >= 1 && var26.field243 >= 1 && var26.field238 <= 102 && var26.field243 <= 102 && (var26.field241 < 0 || class89.method2162(var26.field241, var26.field250))) {
                        class39.method887(var26.field242, var26.field237, var26.field238, var26.field243, var26.field241, var26.field244, var26.field250);
                        var26.field239 = -1;
                        if(var26.field240 == var26.field241 && -1 == var26.field240) {
                           var26.method3998();
                        } else if(var26.field240 == var26.field241 && var26.field244 == var26.field245 && var26.field250 == var26.field249) {
                           var26.method3998();
                        }
                     }
                  }
               }

               for(var0 = 0; var0 < client.field536; ++var0) {
                  --client.field539[var0];
                  if(client.field539[var0] >= -10) {
                     class58 var101 = client.field541[var0];
                     if(null == var101) {
                        class58 var106 = (class58)null;
                        var101 = class58.method1341(class114.field1967, client.field537[var0], 0);
                        if(null == var101) {
                           continue;
                        }

                        client.field539[var0] += var101.method1333();
                        client.field541[var0] = var101;
                     }

                     if(client.field539[var0] < 0) {
                        if(0 != client.field540[var0]) {
                           var27 = (client.field540[var0] & 255) * 128;
                           var4 = client.field540[var0] >> 16 & 255;
                           var5 = var4 * 128 + 64 - class5.field93.field844;
                           if(var5 < 0) {
                              var5 = -var5;
                           }

                           var6 = client.field540[var0] >> 8 & 255;
                           var36 = var6 * 128 + 64 - class5.field93.field819;
                           if(var36 < 0) {
                              var36 = -var36;
                           }

                           var42 = var36 + var5 - 128;
                           if(var42 > var27) {
                              client.field539[var0] = -100;
                              continue;
                           }

                           if(var42 < 0) {
                              var42 = 0;
                           }

                           var2 = client.field514 * (var27 - var42) / var27;
                        } else {
                           var2 = client.field466;
                        }

                        if(var2 > 0) {
                           class62 var103 = var101.method1330().method1370(class82.field1439);
                           class64 var96 = class64.method1396(var103, 100, var2);
                           var96.method1399(client.field334[var0] - 1);
                           class10.field178.method1253(var96);
                        }

                        client.field539[var0] = -100;
                     }
                  } else {
                     --client.field536;

                     for(var99 = var0; var99 < client.field536; ++var99) {
                        client.field537[var99] = client.field537[1 + var99];
                        client.field541[var99] = client.field541[1 + var99];
                        client.field334[var99] = client.field334[1 + var99];
                        client.field539[var99] = client.field539[1 + var99];
                        client.field540[var99] = client.field540[1 + var99];
                     }

                     --var0;
                  }
               }

               if(client.field299 && !class84.method1994()) {
                  if(client.field531 != 0 && client.field532 != -1) {
                     class144.method3157(class38.field884, client.field532, 0, client.field531, false);
                  }

                  client.field299 = false;
               }

               ++client.field371;
               if(client.field371 > 750) {
                  class191.method3834();
               } else {
                  class36.method834();
                  class15.method210();
                  class96.method2281();
                  ++client.field427;
                  if(0 != client.field467) {
                     client.field404 += 20;
                     if(client.field404 >= 400) {
                        client.field467 = 0;
                     }
                  }

                  if(null != class130.field2061) {
                     ++client.field406;
                     if(client.field406 >= 15) {
                        class23.method657(class130.field2061);
                        class130.field2061 = null;
                     }
                  }

                  class173 var28 = class43.field1032;
                  class173 var102 = class56.field1201;
                  class43.field1032 = null;
                  class56.field1201 = null;
                  client.field469 = null;
                  client.field473 = false;
                  client.field498 = false;
                  client.field517 = 0;

                  while(class114.method2545() && client.field517 < 128) {
                     if(client.field345 >= 2 && class137.field2115[82] && class18.field277 == 66) {
                        var3 = "";

                        class35 var94;
                        for(Iterator var97 = class11.field181.iterator(); var97.hasNext(); var3 = var3 + var94.field792 + ':' + var94.field795 + '\n') {
                           var94 = (class35)var97.next();
                        }

                        class35.field793.setContents(new StringSelection(var3), (ClipboardOwner)null);
                     } else {
                        client.field519[client.field517] = class18.field277;
                        client.field518[client.field517] = class137.field2128;
                        ++client.field517;
                     }
                  }

                  if(-1 != client.field452) {
                     var2 = client.field452;
                     var27 = class37.field876;
                     var4 = class98.field1671;
                     if(class9.method161(var2)) {
                        class93.method2251(class173.field2886[var2], -1, 0, 0, var27, var4, 0, 0);
                     }
                  }

                  ++client.field477;

                  while(true) {
                     class0 var37;
                     class173 var104;
                     do {
                        var37 = (class0)client.field493.method3903();
                        if(var37 == null) {
                           while(true) {
                              do {
                                 var37 = (class0)client.field494.method3903();
                                 if(null == var37) {
                                    while(true) {
                                       do {
                                          var37 = (class0)client.field492.method3903();
                                          if(null == var37) {
                                             class0.method3();
                                             if(null != client.field465) {
                                                class133.method2974();
                                             }

                                             if(class3.field65 != null) {
                                                class23.method657(class3.field65);
                                                ++client.field413;
                                                if(0 == class140.field2147) {
                                                   if(client.field412) {
                                                      if(class140.field2150 == class3.field65 && client.field408 != client.field411) {
                                                         class173 var43 = class3.field65;
                                                         byte var105 = 0;
                                                         if(1 == client.field455 && 206 == var43.field2762) {
                                                            var105 = 1;
                                                         }

                                                         if(var43.field2876[client.field411] <= 0) {
                                                            var105 = 0;
                                                         }

                                                         var5 = class31.method776(var43);
                                                         var31 = (var5 >> 29 & 1) != 0;
                                                         if(var31) {
                                                            var6 = client.field408;
                                                            var36 = client.field411;
                                                            var43.field2876[var36] = var43.field2876[var6];
                                                            var43.field2877[var36] = var43.field2877[var6];
                                                            var43.field2876[var6] = -1;
                                                            var43.field2877[var6] = 0;
                                                         } else if(1 == var105) {
                                                            var6 = client.field408;
                                                            var36 = client.field411;

                                                            while(var36 != var6) {
                                                               if(var6 > var36) {
                                                                  var43.method3493(var6 - 1, var6);
                                                                  --var6;
                                                               } else if(var6 < var36) {
                                                                  var43.method3493(1 + var6, var6);
                                                                  ++var6;
                                                               }
                                                            }
                                                         } else {
                                                            var43.method3493(client.field411, client.field408);
                                                         }

                                                         client.field338.method2873(34);
                                                         client.field338.method2634(client.field408);
                                                         client.field338.method2606(class3.field65.field2842);
                                                         client.field338.method2743(var105);
                                                         client.field338.method2634(client.field411);
                                                      }
                                                   } else if((client.field432 == 1 || class17.method220(client.field434 - 1)) && client.field434 > 2) {
                                                      class10.method171(client.field414, client.field377);
                                                   } else if(client.field434 > 0) {
                                                      class5.method113(client.field414, client.field377);
                                                   }

                                                   client.field406 = 10;
                                                   class140.field2157 = 0;
                                                   class3.field65 = null;
                                                } else if(client.field413 >= 5 && (class140.field2151 > client.field414 + 5 || class140.field2151 < client.field414 - 5 || class140.field2161 > 5 + client.field377 || class140.field2161 < client.field377 - 5)) {
                                                   client.field412 = true;
                                                }
                                             }

                                             if(-1 != class86.field1501) {
                                                var2 = class86.field1501;
                                                var27 = class86.field1478;
                                                client.field338.method2873(220);
                                                client.field338.method2603(5);
                                                client.field338.method2603(class137.field2115[82]?(class137.field2115[81]?2:1):0);
                                                client.field338.method2745(var2 + class144.field2204);
                                                client.field338.method2745(var27 + class3.field67);
                                                class86.field1501 = -1;
                                                client.field402 = class140.field2160;
                                                client.field403 = class140.field2159;
                                                client.field467 = 1;
                                                client.field404 = 0;
                                                client.field528 = var2;
                                                client.field347 = var27;
                                             }

                                             if(var28 != class43.field1032) {
                                                if(null != var28) {
                                                   class23.method657(var28);
                                                }

                                                if(null != class43.field1032) {
                                                   class23.method657(class43.field1032);
                                                }
                                             }

                                             if(var102 != class56.field1201 && client.field410 == client.field444) {
                                                if(var102 != null) {
                                                   class23.method657(var102);
                                                }

                                                if(null != class56.field1201) {
                                                   class23.method657(class56.field1201);
                                                }
                                             }

                                             if(class56.field1201 != null) {
                                                if(client.field410 < client.field444) {
                                                   ++client.field410;
                                                   if(client.field444 == client.field410) {
                                                      class23.method657(class56.field1201);
                                                   }
                                                }
                                             } else if(client.field410 > 0) {
                                                --client.field410;
                                             }

                                             var2 = class5.field93.field844 + client.field359;
                                             var27 = class5.field93.field819 + client.field568;
                                             if(class148.field2222 - var2 < -500 || class148.field2222 - var2 > 500 || class46.field1069 - var27 < -500 || class46.field1069 - var27 > 500) {
                                                class148.field2222 = var2;
                                                class46.field1069 = var27;
                                             }

                                             if(var2 != class148.field2222) {
                                                class148.field2222 += (var2 - class148.field2222) / 16;
                                             }

                                             if(class46.field1069 != var27) {
                                                class46.field1069 += (var27 - class46.field1069) / 16;
                                             }

                                             if(4 == class140.field2147 && class7.field143) {
                                                var4 = class140.field2161 - client.field383;
                                                client.field381 = var4 * 2;
                                                client.field383 = var4 != -1 && 1 != var4?(class140.field2161 + client.field383) / 2:class140.field2161;
                                                var5 = client.field382 - class140.field2151;
                                                client.field357 = var5 * 2;
                                                client.field382 = var5 != -1 && 1 != var5?(class140.field2151 + client.field382) / 2:class140.field2151;
                                             } else {
                                                if(class137.field2115[96]) {
                                                   client.field357 += (-24 - client.field357) / 2;
                                                } else if(class137.field2115[97]) {
                                                   client.field357 += (24 - client.field357) / 2;
                                                } else {
                                                   client.field357 /= 2;
                                                }

                                                if(class137.field2115[98]) {
                                                   client.field381 += (12 - client.field381) / 2;
                                                } else if(class137.field2115[99]) {
                                                   client.field381 += (-12 - client.field381) / 2;
                                                } else {
                                                   client.field381 /= 2;
                                                }

                                                client.field383 = class140.field2161;
                                                client.field382 = class140.field2151;
                                             }

                                             client.field379 = client.field357 / 2 + client.field379 & 2047;
                                             client.field564 += client.field381 / 2;
                                             if(client.field564 < 128) {
                                                client.field564 = 128;
                                             }

                                             if(client.field564 > 383) {
                                                client.field564 = 383;
                                             }

                                             var4 = class148.field2222 >> 7;
                                             var5 = class46.field1069 >> 7;
                                             var6 = class34.method816(class148.field2222, class46.field1069, class42.field1002);
                                             var36 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var42 = var4 - 4; var42 <= var4 + 4; ++var42) {
                                                   for(var9 = var5 - 4; var9 <= 4 + var5; ++var9) {
                                                      var54 = class42.field1002;
                                                      if(var54 < 3 && 2 == (class5.field82[1][var42][var9] & 2)) {
                                                         ++var54;
                                                      }

                                                      var11 = var6 - class5.field94[var54][var42][var9];
                                                      if(var11 > var36) {
                                                         var36 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var42 = var36 * 192;
                                             if(var42 > 98048) {
                                                var42 = 98048;
                                             }

                                             if(var42 < '耀') {
                                                var42 = '耀';
                                             }

                                             if(var42 > client.field387) {
                                                client.field387 += (var42 - client.field387) / 24;
                                             } else if(var42 < client.field387) {
                                                client.field387 += (var42 - client.field387) / 80;
                                             }

                                             if(client.field542) {
                                                class127.method2942();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++client.field547[var2];
                                             }

                                             class171.field2723.method238();
                                             var2 = ++class140.field2146 - 1;
                                             var4 = class167.method3437();
                                             if(var2 > 15000 && var4 > 15000) {
                                                client.field401 = 250;
                                                class96.method2280(14500);
                                                client.field338.method2873(103);
                                             }

                                             ++client.field384;
                                             if(client.field384 > 500) {
                                                client.field384 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   client.field359 += client.field360;
                                                }

                                                if(2 == (var5 & 2)) {
                                                   client.field568 += client.field362;
                                                }

                                                if(4 == (var5 & 4)) {
                                                   client.field363 += client.field364;
                                                }
                                             }

                                             if(client.field359 < -50) {
                                                client.field360 = 2;
                                             }

                                             if(client.field359 > 50) {
                                                client.field360 = -2;
                                             }

                                             if(client.field568 < -55) {
                                                client.field362 = 2;
                                             }

                                             if(client.field568 > 55) {
                                                client.field362 = -2;
                                             }

                                             if(client.field363 < -40) {
                                                client.field364 = 1;
                                             }

                                             if(client.field363 > 40) {
                                                client.field364 = -1;
                                             }

                                             ++client.field370;
                                             if(client.field370 > 500) {
                                                client.field370 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   client.field443 += client.field367;
                                                }

                                                if((var5 & 2) == 2) {
                                                   client.field368 += client.field369;
                                                }
                                             }

                                             if(client.field443 < -60) {
                                                client.field367 = 2;
                                             }

                                             if(client.field443 > 60) {
                                                client.field367 = -2;
                                             }

                                             if(client.field368 < -20) {
                                                client.field369 = 1;
                                             }

                                             if(client.field368 > 10) {
                                                client.field369 = -1;
                                             }

                                             for(class38 var98 = (class38)client.field501.method3866(); null != var98; var98 = (class38)client.field501.method3863()) {
                                                if((long)var98.field880 < class127.method2941() / 1000L - 5L) {
                                                   if(var98.field879 > 0) {
                                                      class129.method2943(5, "", var98.field882 + " has logged in.");
                                                   }

                                                   if(0 == var98.field879) {
                                                      class129.method2943(5, "", var98.field882 + " has logged out.");
                                                   }

                                                   var98.method3994();
                                                }
                                             }

                                             ++client.field416;
                                             if(client.field416 > 50) {
                                                client.field338.method2873(226);
                                             }

                                             try {
                                                if(class127.field2047 != null && client.field338.field1992 > 0) {
                                                   class127.field2047.method3100(client.field338.field1993, 0, client.field338.field1992);
                                                   client.field338.field1992 = 0;
                                                   client.field416 = 0;
                                                }
                                             } catch (IOException var19) {
                                                class191.method3834();
                                             }

                                             return;
                                          }

                                          var104 = var37.field2;
                                          if(var104.field2759 < 0) {
                                             break;
                                          }

                                          var48 = class20.method641(var104.field2777);
                                       } while(var48 == null || var48.field2867 == null || var104.field2759 >= var48.field2867.length || var48.field2867[var104.field2759] != var104);

                                       class168.method3449(var37, 200000);
                                    }
                                 }

                                 var104 = var37.field2;
                                 if(var104.field2759 < 0) {
                                    break;
                                 }

                                 var48 = class20.method641(var104.field2777);
                              } while(var48 == null || null == var48.field2867 || var104.field2759 >= var48.field2867.length || var48.field2867[var104.field2759] != var104);

                              class168.method3449(var37, 200000);
                           }
                        }

                        var104 = var37.field2;
                        if(var104.field2759 < 0) {
                           break;
                        }

                        var48 = class20.method641(var104.field2777);
                     } while(null == var48 || null == var48.field2867 || var104.field2759 >= var48.field2867.length || var48.field2867[var104.field2759] != var104);

                     class168.method3449(var37, 200000);
                  }
               }
            }
         }
      }
   }
}

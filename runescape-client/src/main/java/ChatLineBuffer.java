import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -698810277
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 269778135
   )
   @Export("length")
   int length;
   @ObfuscatedName("z")
   public static Buffer field706;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = -1007100541
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("h")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass0;IS)V",
      garbageValue = "26796"
   )
   static void method634(class0 var0, int var1) {
      Object[] var2 = var0.field8;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class143.method3004(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field615;
         int[] var9 = var4.field617;
         byte var10 = -1;
         class38.field832 = 0;

         int var13;
         try {
            class38.field819 = new int[var4.field619];
            int var11 = 0;
            class38.field820 = new String[var4.field620];
            int var12 = 0;

            int var14;
            String var26;
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
                     var14 = null != var0.field13?var0.field13.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field9;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field13 != null?var0.field13.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field6 != null?var0.field6.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field17;
                  }

                  class38.field819[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var26 = (String)var2[var13];
                  if(var26.equals("event_opbase")) {
                     var26 = var0.field0;
                  }

                  class38.field820[var12++] = var26;
               }
            }

            var13 = 0;
            class38.field830 = var0.field10;

            label3711:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var39 = var8[var7];
               int var28;
               int var29;
               String var45;
               int var47;
               String[] var55;
               int[] var57;
               if(var39 < 100) {
                  if(var39 == 0) {
                     class38.field829[var5++] = var9[var7];
                     continue;
                  }

                  if(var39 == 1) {
                     var14 = var9[var7];
                     class38.field829[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var39 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field829[var5];
                     RSCanvas.method2982(var14);
                     continue;
                  }

                  if(var39 == 3) {
                     class38.chatboxSegments[var6++] = var4.field622[var7];
                     continue;
                  }

                  if(var39 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var39 == 7) {
                     var5 -= 2;
                     if(class38.field829[1 + var5] != class38.field829[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 8) {
                     var5 -= 2;
                     if(class38.field829[var5 + 1] == class38.field829[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 9) {
                     var5 -= 2;
                     if(class38.field829[var5] < class38.field829[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 10) {
                     var5 -= 2;
                     if(class38.field829[var5] > class38.field829[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 21) {
                     if(class38.field832 == 0) {
                        return;
                     }

                     class14 var77 = class38.field818[--class38.field832];
                     var4 = var77.field222;
                     var8 = var4.field615;
                     var9 = var4.field617;
                     var7 = var77.field220;
                     class38.field819 = var77.field221;
                     class38.field820 = var77.field226;
                     continue;
                  }

                  if(var39 == 25) {
                     var14 = var9[var7];
                     class38.field829[var5++] = class9.method127(var14);
                     continue;
                  }

                  if(var39 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class144.method3019(var14, class38.field829[var5]);
                     continue;
                  }

                  if(var39 == 31) {
                     var5 -= 2;
                     if(class38.field829[var5] <= class38.field829[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 32) {
                     var5 -= 2;
                     if(class38.field829[var5] >= class38.field829[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var39 == 33) {
                     class38.field829[var5++] = class38.field819[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var39 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class38.field819[var10001] = class38.field829[var5];
                     continue;
                  }

                  if(var39 == 35) {
                     class38.chatboxSegments[var6++] = class38.field820[var9[var7]];
                     continue;
                  }

                  if(var39 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class38.field820[var10001] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var39 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var45 = ObjectComposition.method853(class38.chatboxSegments, var6, var14);
                     class38.chatboxSegments[var6++] = var45;
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
                     class23 var108 = class143.method3004(var14);
                     var57 = new int[var108.field619];
                     var55 = new String[var108.field620];

                     for(var47 = 0; var47 < var108.field618; ++var47) {
                        var57[var47] = class38.field829[var47 + (var5 - var108.field618)];
                     }

                     for(var47 = 0; var47 < var108.field623; ++var47) {
                        var55[var47] = class38.chatboxSegments[var6 - var108.field623 + var47];
                     }

                     var5 -= var108.field618;
                     var6 -= var108.field623;
                     class14 var101 = new class14();
                     var101.field222 = var4;
                     var101.field220 = var7;
                     var101.field221 = class38.field819;
                     var101.field226 = class38.field820;
                     class38.field818[++class38.field832 - 1] = var101;
                     var4 = var108;
                     var8 = var108.field615;
                     var9 = var108.field617;
                     var7 = -1;
                     class38.field819 = var57;
                     class38.field820 = var55;
                     continue;
                  }

                  if(var39 == 42) {
                     class38.field829[var5++] = class5.chatMessages.method225(var9[var7]);
                     continue;
                  }

                  if(var39 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class5.chatMessages.method219(var10001, class38.field829[var5]);
                     continue;
                  }

                  if(var39 == 44) {
                     var14 = var9[var7] >> 16;
                     var28 = var9[var7] & '\uffff';
                     --var5;
                     var29 = class38.field829[var5];
                     if(var29 >= 0 && var29 <= 5000) {
                        class38.field821[var14] = var29;
                        byte var102 = -1;
                        if(var28 == 105) {
                           var102 = 0;
                        }

                        var47 = 0;

                        while(true) {
                           if(var47 >= var29) {
                              continue label3711;
                           }

                           class38.field822[var14][var47] = var102;
                           ++var47;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var39 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var28 = class38.field829[var5];
                     if(var28 >= 0 && var28 < class38.field821[var14]) {
                        class38.field829[var5++] = class38.field822[var14][var28];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var39 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var28 = class38.field829[var5];
                     if(var28 >= 0 && var28 < class38.field821[var14]) {
                        class38.field822[var14][var28] = class38.field829[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var39 == 47) {
                     var26 = class5.chatMessages.method204(var9[var7]);
                     if(null == var26) {
                        var26 = "null";
                     }

                     class38.chatboxSegments[var6++] = var26;
                     continue;
                  }

                  if(var39 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class5.chatMessages.method206(var10001, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var50;
               if(var9[var7] == 1) {
                  var50 = true;
               } else {
                  var50 = false;
               }

               Widget var15;
               boolean var18;
               int var20;
               Widget var27;
               int var30;
               Widget var42;
               Widget var74;
               boolean var83;
               if(var39 < 1000) {
                  if(var39 == 100) {
                     var5 -= 3;
                     var28 = class38.field829[var5];
                     var29 = class38.field829[1 + var5];
                     var30 = class38.field829[2 + var5];
                     if(var29 == 0) {
                        throw new RuntimeException();
                     }

                     var27 = class173.method3412(var28);
                     if(null == var27.children) {
                        var27.children = new Widget[1 + var30];
                     }

                     if(var27.children.length <= var30) {
                        Widget[] var68 = new Widget[var30 + 1];

                        for(var20 = 0; var20 < var27.children.length; ++var20) {
                           var68[var20] = var27.children[var20];
                        }

                        var27.children = var68;
                     }

                     if(var30 > 0 && var27.children[var30 - 1] == null) {
                        throw new RuntimeException("" + (var30 - 1));
                     }

                     Widget var70 = new Widget();
                     var70.type = var29;
                     var70.parentId = var70.id = var27.id;
                     var70.index = var30;
                     var70.field2862 = true;
                     var27.children[var30] = var70;
                     if(var50) {
                        class212.field3176 = var70;
                     } else {
                        class38.field827 = var70;
                     }

                     class32.method673(var27);
                     continue;
                  }

                  if(var39 == 101) {
                     var15 = var50?class212.field3176:class38.field827;
                     var74 = class173.method3412(var15.id);
                     var74.children[var15.index] = null;
                     class32.method673(var74);
                     continue;
                  }

                  if(var39 == 102) {
                     --var5;
                     var15 = class173.method3412(class38.field829[var5]);
                     var15.children = null;
                     class32.method673(var15);
                     continue;
                  }

                  if(var39 == 200) {
                     var5 -= 2;
                     var28 = class38.field829[var5];
                     var29 = class38.field829[var5 + 1];
                     var42 = class136.method2889(var28, var29);
                     if(null != var42 && var29 != -1) {
                        class38.field829[var5++] = 1;
                        if(var50) {
                           class212.field3176 = var42;
                        } else {
                           class38.field827 = var42;
                        }
                        continue;
                     }

                     class38.field829[var5++] = 0;
                     continue;
                  }

                  if(var39 == 201) {
                     --var5;
                     var15 = class173.method3412(class38.field829[var5]);
                     if(var15 != null) {
                        class38.field829[var5++] = 1;
                        if(var50) {
                           class212.field3176 = var15;
                        } else {
                           class38.field827 = var15;
                        }
                     } else {
                        class38.field829[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var93;
                  if(var39 >= 1000 && var39 < 1100 || var39 >= 2000 && var39 < 2100) {
                     var28 = -1;
                     if(var39 >= 2000) {
                        var39 -= 1000;
                        --var5;
                        var28 = class38.field829[var5];
                        var74 = class173.method3412(var28);
                     } else {
                        var74 = var50?class212.field3176:class38.field827;
                     }

                     if(var39 == 1000) {
                        var5 -= 4;
                        var74.field2842 = class38.field829[var5];
                        var74.field2812 = class38.field829[1 + var5];
                        var74.field2807 = class38.field829[var5 + 2];
                        var74.field2808 = class38.field829[3 + var5];
                        class32.method673(var74);
                        class117.method2481(var74);
                        if(var28 != -1 && var74.type == 0) {
                           class130.method2850(Widget.widgets[var28 >> 16], var74, false);
                        }
                        continue;
                     }

                     if(var39 == 1001) {
                        var5 -= 4;
                        var74.field2813 = class38.field829[var5];
                        var74.field2814 = class38.field829[var5 + 1];
                        var74.field2809 = class38.field829[2 + var5];
                        var74.field2810 = class38.field829[var5 + 3];
                        class32.method673(var74);
                        class117.method2481(var74);
                        if(var28 != -1 && var74.type == 0) {
                           class130.method2850(Widget.widgets[var28 >> 16], var74, false);
                        }
                        continue;
                     }

                     if(var39 == 1003) {
                        --var5;
                        var93 = class38.field829[var5] == 1;
                        if(var74.isHidden != var93) {
                           var74.isHidden = var93;
                           class32.method673(var74);
                        }
                        continue;
                     }

                     if(var39 == 1005) {
                        --var5;
                        var74.field2874 = class38.field829[var5] == 1;
                        continue;
                     }

                     if(var39 == 1006) {
                        --var5;
                        var74.field2936 = class38.field829[var5] == 1;
                        continue;
                     }
                  } else {
                     String var17;
                     if(var39 >= 1100 && var39 < 1200 || var39 >= 2100 && var39 < 2200) {
                        var29 = -1;
                        if(var39 >= 2000) {
                           var39 -= 1000;
                           --var5;
                           var29 = class38.field829[var5];
                           var15 = class173.method3412(var29);
                        } else {
                           var15 = var50?class212.field3176:class38.field827;
                        }

                        if(var39 == 1100) {
                           var5 -= 2;
                           var15.itemId = class38.field829[var5];
                           if(var15.itemId > var15.scrollWidth - var15.width) {
                              var15.itemId = var15.scrollWidth - var15.width;
                           }

                           if(var15.itemId < 0) {
                              var15.itemId = 0;
                           }

                           var15.scrollY = class38.field829[var5 + 1];
                           if(var15.scrollY > var15.scrollHeight - var15.height) {
                              var15.scrollY = var15.scrollHeight - var15.height;
                           }

                           if(var15.scrollY < 0) {
                              var15.scrollY = 0;
                           }

                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1101) {
                           --var5;
                           var15.textColor = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1102) {
                           --var5;
                           var15.field2831 = class38.field829[var5] == 1;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1103) {
                           --var5;
                           var15.opacity = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1104) {
                           --var5;
                           var15.field2835 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1105) {
                           --var5;
                           var15.textureId = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1106) {
                           --var5;
                           var15.field2843 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1107) {
                           --var5;
                           var15.field2840 = class38.field829[var5] == 1;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1108) {
                           var15.modelType = 1;
                           --var5;
                           var15.modelId = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1109) {
                           var5 -= 6;
                           var15.field2913 = class38.field829[var5];
                           var15.field2898 = class38.field829[1 + var5];
                           var15.rotationX = class38.field829[2 + var5];
                           var15.rotationZ = class38.field829[3 + var5];
                           var15.rotationY = class38.field829[4 + var5];
                           var15.field2856 = class38.field829[5 + var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1110) {
                           --var5;
                           var30 = class38.field829[var5];
                           if(var30 != var15.field2828) {
                              var15.field2828 = var30;
                              var15.field2934 = 0;
                              var15.field2925 = 0;
                              class32.method673(var15);
                           }
                           continue;
                        }

                        if(var39 == 1111) {
                           --var5;
                           var15.field2859 = class38.field829[var5] == 1;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1112) {
                           --var6;
                           var17 = class38.chatboxSegments[var6];
                           if(!var17.equals(var15.text)) {
                              var15.text = var17;
                              class32.method673(var15);
                           }
                           continue;
                        }

                        if(var39 == 1113) {
                           --var5;
                           var15.field2861 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1114) {
                           var5 -= 3;
                           var15.field2865 = class38.field829[var5];
                           var15.field2866 = class38.field829[var5 + 1];
                           var15.field2870 = class38.field829[2 + var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1115) {
                           --var5;
                           var15.field2867 = class38.field829[var5] == 1;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1116) {
                           --var5;
                           var15.borderThickness = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1117) {
                           --var5;
                           var15.sprite2 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1118) {
                           --var5;
                           var15.flippedVertically = class38.field829[var5] == 1;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1119) {
                           --var5;
                           var15.flippedHorizontally = class38.field829[var5] == 1;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1120) {
                           var5 -= 2;
                           var15.scrollWidth = class38.field829[var5];
                           var15.scrollHeight = class38.field829[1 + var5];
                           class32.method673(var15);
                           if(var29 != -1 && var15.type == 0) {
                              class130.method2850(Widget.widgets[var29 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var39 == 1121) {
                           class151.method3162(var15.id, var15.index);
                           Client.field464 = var15;
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1122) {
                           --var5;
                           var15.field2826 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1123) {
                           --var5;
                           var15.field2801 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1124) {
                           --var5;
                           var15.field2834 = class38.field829[var5];
                           class32.method673(var15);
                           continue;
                        }

                        if(var39 == 1125) {
                           --var5;
                           var30 = class38.field829[var5];
                           class85 var99 = (class85)class140.method2957(class77.method1637(), var30);
                           if(null != var99) {
                              var15.field2878 = var99;
                              class32.method673(var15);
                           }
                           continue;
                        }
                     } else if(var39 >= 1200 && var39 < 1300 || var39 >= 2200 && var39 < 2300) {
                        if(var39 >= 2000) {
                           var39 -= 1000;
                           --var5;
                           var15 = class173.method3412(class38.field829[var5]);
                        } else {
                           var15 = var50?class212.field3176:class38.field827;
                        }

                        class32.method673(var15);
                        if(var39 == 1200 || var39 == 1205 || var39 == 1212) {
                           var5 -= 2;
                           var29 = class38.field829[var5];
                           var30 = class38.field829[1 + var5];
                           var15.item = var29;
                           var15.stackSize = var30;
                           ItemComposition var97 = class92.getItemDefinition(var29);
                           var15.rotationX = var97.field1178;
                           var15.rotationZ = var97.field1179;
                           var15.rotationY = var97.field1180;
                           var15.field2913 = var97.field1181;
                           var15.field2898 = var97.field1182;
                           var15.field2856 = var97.field1177;
                           if(var39 == 1205) {
                              var15.field2860 = 0;
                           } else if(var39 == 1212 | var97.isStackable == 1) {
                              var15.field2860 = 1;
                           } else {
                              var15.field2860 = 2;
                           }

                           if(var15.field2791 > 0) {
                              var15.field2856 = var15.field2856 * 32 / var15.field2791;
                           } else if(var15.field2813 > 0) {
                              var15.field2856 = var15.field2856 * 32 / var15.field2813;
                           }
                           continue;
                        }

                        if(var39 == 1201) {
                           var15.modelType = 2;
                           --var5;
                           var15.modelId = class38.field829[var5];
                           continue;
                        }

                        if(var39 == 1202) {
                           var15.modelType = 3;
                           var15.modelId = class138.localPlayer.composition.method3516();
                           continue;
                        }
                     } else if(var39 >= 1300 && var39 < 1400 || var39 >= 2300 && var39 < 2400) {
                        if(var39 >= 2000) {
                           var39 -= 1000;
                           --var5;
                           var15 = class173.method3412(class38.field829[var5]);
                        } else {
                           var15 = var50?class212.field3176:class38.field827;
                        }

                        if(var39 == 1300) {
                           --var5;
                           var29 = class38.field829[var5] - 1;
                           if(var29 >= 0 && var29 <= 9) {
                              --var6;
                              var15.method3435(var29, class38.chatboxSegments[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var39 == 1301) {
                           var5 -= 2;
                           var29 = class38.field829[var5];
                           var30 = class38.field829[1 + var5];
                           var15.parent = class136.method2889(var29, var30);
                           continue;
                        }

                        if(var39 == 1302) {
                           --var5;
                           var15.field2880 = class38.field829[var5] == 1;
                           continue;
                        }

                        if(var39 == 1303) {
                           --var5;
                           var15.field2907 = class38.field829[var5];
                           continue;
                        }

                        if(var39 == 1304) {
                           --var5;
                           var15.field2924 = class38.field829[var5];
                           continue;
                        }

                        if(var39 == 1305) {
                           --var6;
                           var15.name = class38.chatboxSegments[var6];
                           continue;
                        }

                        if(var39 == 1306) {
                           --var6;
                           var15.field2881 = class38.chatboxSegments[var6];
                           continue;
                        }

                        if(var39 == 1307) {
                           var15.actions = null;
                           continue;
                        }
                     } else {
                        String var40;
                        int[] var43;
                        int var87;
                        if(var39 >= 1400 && var39 < 1500 || var39 >= 2400 && var39 < 2500) {
                           if(var39 >= 2000) {
                              var39 -= 1000;
                              --var5;
                              var15 = class173.method3412(class38.field829[var5]);
                           } else {
                              var15 = var50?class212.field3176:class38.field827;
                           }

                           --var6;
                           var40 = class38.chatboxSegments[var6];
                           var43 = null;
                           if(var40.length() > 0 && var40.charAt(var40.length() - 1) == 89) {
                              --var5;
                              var47 = class38.field829[var5];
                              if(var47 > 0) {
                                 for(var43 = new int[var47]; var47-- > 0; var43[var47] = class38.field829[var5]) {
                                    --var5;
                                 }
                              }

                              var40 = var40.substring(0, var40.length() - 1);
                           }

                           Object[] var85 = new Object[var40.length() + 1];

                           for(var87 = var85.length - 1; var87 >= 1; --var87) {
                              if(var40.charAt(var87 - 1) == 115) {
                                 --var6;
                                 var85[var87] = class38.chatboxSegments[var6];
                              } else {
                                 --var5;
                                 var85[var87] = new Integer(class38.field829[var5]);
                              }
                           }

                           --var5;
                           var87 = class38.field829[var5];
                           if(var87 != -1) {
                              var85[0] = new Integer(var87);
                           } else {
                              var85 = null;
                           }

                           if(var39 == 1400) {
                              var15.field2884 = var85;
                           }

                           if(var39 == 1401) {
                              var15.field2887 = var85;
                           }

                           if(var39 == 1402) {
                              var15.field2894 = var85;
                           }

                           if(var39 == 1403) {
                              var15.field2838 = var85;
                           }

                           if(var39 == 1404) {
                              var15.field2890 = var85;
                           }

                           if(var39 == 1405) {
                              var15.field2891 = var85;
                           }

                           if(var39 == 1406) {
                              var15.field2910 = var85;
                           }

                           if(var39 == 1407) {
                              var15.field2895 = var85;
                              var15.field2896 = var43;
                           }

                           if(var39 == 1408) {
                              var15.field2926 = var85;
                           }

                           if(var39 == 1409) {
                              var15.field2902 = var85;
                           }

                           if(var39 == 1410) {
                              var15.field2892 = var85;
                           }

                           if(var39 == 1411) {
                              var15.field2885 = var85;
                           }

                           if(var39 == 1412) {
                              var15.field2889 = var85;
                           }

                           if(var39 == 1414) {
                              var15.field2851 = var85;
                              var15.field2917 = var43;
                           }

                           if(var39 == 1415) {
                              var15.field2899 = var85;
                              var15.field2795 = var43;
                           }

                           if(var39 == 1416) {
                              var15.field2893 = var85;
                           }

                           if(var39 == 1417) {
                              var15.field2903 = var85;
                           }

                           if(var39 == 1418) {
                              var15.field2904 = var85;
                           }

                           if(var39 == 1419) {
                              var15.field2929 = var85;
                           }

                           if(var39 == 1420) {
                              var15.field2915 = var85;
                           }

                           if(var39 == 1421) {
                              var15.field2886 = var85;
                           }

                           if(var39 == 1422) {
                              var15.field2853 = var85;
                           }

                           if(var39 == 1423) {
                              var15.field2806 = var85;
                           }

                           if(var39 == 1424) {
                              var15.field2849 = var85;
                           }

                           if(var39 == 1425) {
                              var15.field2912 = var85;
                           }

                           if(var39 == 1426) {
                              var15.field2837 = var85;
                           }

                           if(var39 == 1427) {
                              var15.field2911 = var85;
                           }

                           var15.field2882 = true;
                           continue;
                        }

                        if(var39 < 1600) {
                           var15 = var50?class212.field3176:class38.field827;
                           if(var39 == 1500) {
                              class38.field829[var5++] = var15.relativeX;
                              continue;
                           }

                           if(var39 == 1501) {
                              class38.field829[var5++] = var15.relativeY;
                              continue;
                           }

                           if(var39 == 1502) {
                              class38.field829[var5++] = var15.width;
                              continue;
                           }

                           if(var39 == 1503) {
                              class38.field829[var5++] = var15.height;
                              continue;
                           }

                           if(var39 == 1504) {
                              class38.field829[var5++] = var15.isHidden?1:0;
                              continue;
                           }

                           if(var39 == 1505) {
                              class38.field829[var5++] = var15.parentId;
                              continue;
                           }
                        } else if(var39 < 1700) {
                           var15 = var50?class212.field3176:class38.field827;
                           if(var39 == 1600) {
                              class38.field829[var5++] = var15.itemId;
                              continue;
                           }

                           if(var39 == 1601) {
                              class38.field829[var5++] = var15.scrollY;
                              continue;
                           }

                           if(var39 == 1602) {
                              class38.chatboxSegments[var6++] = var15.text;
                              continue;
                           }

                           if(var39 == 1603) {
                              class38.field829[var5++] = var15.scrollWidth;
                              continue;
                           }

                           if(var39 == 1604) {
                              class38.field829[var5++] = var15.scrollHeight;
                              continue;
                           }

                           if(var39 == 1605) {
                              class38.field829[var5++] = var15.field2856;
                              continue;
                           }

                           if(var39 == 1606) {
                              class38.field829[var5++] = var15.rotationX;
                              continue;
                           }

                           if(var39 == 1607) {
                              class38.field829[var5++] = var15.rotationY;
                              continue;
                           }

                           if(var39 == 1608) {
                              class38.field829[var5++] = var15.rotationZ;
                              continue;
                           }

                           if(var39 == 1609) {
                              class38.field829[var5++] = var15.opacity;
                              continue;
                           }

                           if(var39 == 1610) {
                              class38.field829[var5++] = var15.field2834;
                              continue;
                           }

                           if(var39 == 1611) {
                              class38.field829[var5++] = var15.textColor;
                              continue;
                           }

                           if(var39 == 1612) {
                              class38.field829[var5++] = var15.field2801;
                              continue;
                           }

                           if(var39 == 1613) {
                              class38.field829[var5++] = var15.field2878.vmethod3197();
                              continue;
                           }
                        } else if(var39 < 1800) {
                           var15 = var50?class212.field3176:class38.field827;
                           if(var39 == 1700) {
                              class38.field829[var5++] = var15.item;
                              continue;
                           }

                           if(var39 == 1701) {
                              if(var15.item != -1) {
                                 class38.field829[var5++] = var15.stackSize;
                              } else {
                                 class38.field829[var5++] = 0;
                              }
                              continue;
                           }

                           if(var39 == 1702) {
                              class38.field829[var5++] = var15.index;
                              continue;
                           }
                        } else if(var39 < 1900) {
                           var15 = var50?class212.field3176:class38.field827;
                           if(var39 == 1800) {
                              class38.field829[var5++] = class144.method3020(Projectile.method96(var15));
                              continue;
                           }

                           if(var39 == 1801) {
                              --var5;
                              var29 = class38.field829[var5];
                              --var29;
                              if(var15.actions != null && var29 < var15.actions.length && null != var15.actions[var29]) {
                                 class38.chatboxSegments[var6++] = var15.actions[var29];
                                 continue;
                              }

                              class38.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var39 == 1802) {
                              if(var15.name == null) {
                                 class38.chatboxSegments[var6++] = "";
                              } else {
                                 class38.chatboxSegments[var6++] = var15.name;
                              }
                              continue;
                           }
                        } else if(var39 >= 1900 && var39 < 2000 || var39 >= 2900 && var39 < 3000) {
                           if(var39 >= 2000) {
                              var39 -= 1000;
                              --var5;
                              var15 = class173.method3412(class38.field829[var5]);
                           } else {
                              var15 = var50?class212.field3176:class38.field827;
                           }

                           if(var39 == 1927) {
                              if(class38.field830 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(null == var15.field2911) {
                                 return;
                              }

                              class0 var72 = new class0();
                              var72.field13 = var15;
                              var72.field8 = var15.field2911;
                              var72.field10 = 1 + class38.field830;
                              Client.field522.method3865(var0);
                              continue;
                           }
                        } else if(var39 < 2600) {
                           --var5;
                           var15 = class173.method3412(class38.field829[var5]);
                           if(var39 == 2500) {
                              class38.field829[var5++] = var15.relativeX;
                              continue;
                           }

                           if(var39 == 2501) {
                              class38.field829[var5++] = var15.relativeY;
                              continue;
                           }

                           if(var39 == 2502) {
                              class38.field829[var5++] = var15.width;
                              continue;
                           }

                           if(var39 == 2503) {
                              class38.field829[var5++] = var15.height;
                              continue;
                           }

                           if(var39 == 2504) {
                              class38.field829[var5++] = var15.isHidden?1:0;
                              continue;
                           }

                           if(var39 == 2505) {
                              class38.field829[var5++] = var15.parentId;
                              continue;
                           }
                        } else if(var39 < 2700) {
                           --var5;
                           var15 = class173.method3412(class38.field829[var5]);
                           if(var39 == 2600) {
                              class38.field829[var5++] = var15.itemId;
                              continue;
                           }

                           if(var39 == 2601) {
                              class38.field829[var5++] = var15.scrollY;
                              continue;
                           }

                           if(var39 == 2602) {
                              class38.chatboxSegments[var6++] = var15.text;
                              continue;
                           }

                           if(var39 == 2603) {
                              class38.field829[var5++] = var15.scrollWidth;
                              continue;
                           }

                           if(var39 == 2604) {
                              class38.field829[var5++] = var15.scrollHeight;
                              continue;
                           }

                           if(var39 == 2605) {
                              class38.field829[var5++] = var15.field2856;
                              continue;
                           }

                           if(var39 == 2606) {
                              class38.field829[var5++] = var15.rotationX;
                              continue;
                           }

                           if(var39 == 2607) {
                              class38.field829[var5++] = var15.rotationY;
                              continue;
                           }

                           if(var39 == 2608) {
                              class38.field829[var5++] = var15.rotationZ;
                              continue;
                           }

                           if(var39 == 2609) {
                              class38.field829[var5++] = var15.opacity;
                              continue;
                           }

                           if(var39 == 2610) {
                              class38.field829[var5++] = var15.field2834;
                              continue;
                           }

                           if(var39 == 2611) {
                              class38.field829[var5++] = var15.textColor;
                              continue;
                           }

                           if(var39 == 2612) {
                              class38.field829[var5++] = var15.field2801;
                              continue;
                           }

                           if(var39 == 2613) {
                              class38.field829[var5++] = var15.field2878.vmethod3197();
                              continue;
                           }
                        } else if(var39 < 2800) {
                           if(var39 == 2700) {
                              --var5;
                              var15 = class173.method3412(class38.field829[var5]);
                              class38.field829[var5++] = var15.item;
                              continue;
                           }

                           if(var39 == 2701) {
                              --var5;
                              var15 = class173.method3412(class38.field829[var5]);
                              if(var15.item != -1) {
                                 class38.field829[var5++] = var15.stackSize;
                              } else {
                                 class38.field829[var5++] = 0;
                              }
                              continue;
                           }

                           if(var39 == 2702) {
                              --var5;
                              var28 = class38.field829[var5];
                              WidgetNode var16 = (WidgetNode)Client.componentTable.method3812((long)var28);
                              if(var16 != null) {
                                 class38.field829[var5++] = 1;
                              } else {
                                 class38.field829[var5++] = 0;
                              }
                              continue;
                           }

                           if(var39 == 2706) {
                              class38.field829[var5++] = Client.widgetRoot;
                              continue;
                           }
                        } else if(var39 < 2900) {
                           --var5;
                           var15 = class173.method3412(class38.field829[var5]);
                           if(var39 == 2800) {
                              class38.field829[var5++] = class144.method3020(Projectile.method96(var15));
                              continue;
                           }

                           if(var39 == 2801) {
                              --var5;
                              var29 = class38.field829[var5];
                              --var29;
                              if(var15.actions != null && var29 < var15.actions.length && var15.actions[var29] != null) {
                                 class38.chatboxSegments[var6++] = var15.actions[var29];
                                 continue;
                              }

                              class38.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var39 == 2802) {
                              if(var15.name == null) {
                                 class38.chatboxSegments[var6++] = "";
                              } else {
                                 class38.chatboxSegments[var6++] = var15.name;
                              }
                              continue;
                           }
                        } else {
                           int var21;
                           int var22;
                           int var23;
                           int var69;
                           if(var39 < 3200) {
                              if(var39 == 3100) {
                                 --var6;
                                 var45 = class38.chatboxSegments[var6];
                                 class110.method2416(0, "", var45);
                                 continue;
                              }

                              if(var39 == 3101) {
                                 var5 -= 2;
                                 class26.method579(class138.localPlayer, class38.field829[var5], class38.field829[var5 + 1]);
                                 continue;
                              }

                              if(var39 == 3103) {
                                 class16.method192();
                                 continue;
                              }

                              boolean var31;
                              if(var39 == 3104) {
                                 --var6;
                                 var45 = class38.chatboxSegments[var6];
                                 var29 = 0;
                                 var31 = false;
                                 boolean var54 = false;
                                 var21 = 0;
                                 var22 = var45.length();
                                 var23 = 0;

                                 while(true) {
                                    if(var23 >= var22) {
                                       var18 = var54;
                                       break;
                                    }

                                    label4004: {
                                       char var24 = var45.charAt(var23);
                                       if(var23 == 0) {
                                          if(var24 == 45) {
                                             var31 = true;
                                             break label4004;
                                          }

                                          if(var24 == 43) {
                                             break label4004;
                                          }
                                       }

                                       if(var24 >= 48 && var24 <= 57) {
                                          var69 = var24 - 48;
                                       } else if(var24 >= 65 && var24 <= 90) {
                                          var69 = var24 - 55;
                                       } else {
                                          if(var24 < 97 || var24 > 122) {
                                             var18 = false;
                                             break;
                                          }

                                          var69 = var24 - 87;
                                       }

                                       if(var69 >= 10) {
                                          var18 = false;
                                          break;
                                       }

                                       if(var31) {
                                          var69 = -var69;
                                       }

                                       int var25 = var69 + 10 * var21;
                                       if(var21 != var25 / 10) {
                                          var18 = false;
                                          break;
                                       }

                                       var21 = var25;
                                       var54 = true;
                                    }

                                    ++var23;
                                 }

                                 if(var18) {
                                    var47 = class145.method3022(var45, 10, true);
                                    var29 = var47;
                                 }

                                 Client.field378.method2801(253);
                                 Client.field378.method2709(var29);
                                 continue;
                              }

                              if(var39 == 3105) {
                                 --var6;
                                 var45 = class38.chatboxSegments[var6];
                                 Client.field378.method2801(167);
                                 Client.field378.method2529(var45.length() + 1);
                                 Client.field378.method2535(var45);
                                 continue;
                              }

                              if(var39 == 3106) {
                                 --var6;
                                 var45 = class38.chatboxSegments[var6];
                                 Client.field378.method2801(55);
                                 Client.field378.method2529(var45.length() + 1);
                                 Client.field378.method2535(var45);
                                 continue;
                              }

                              if(var39 == 3107) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 --var6;
                                 var40 = class38.chatboxSegments[var6];
                                 var30 = class34.field779;
                                 int[] var75 = class34.field786;
                                 var31 = false;

                                 for(var20 = 0; var20 < var30; ++var20) {
                                    Player var32 = Client.cachedPlayers[var75[var20]];
                                    if(var32 != null && var32 != class138.localPlayer && var32.name != null && var32.name.equalsIgnoreCase(var40)) {
                                       if(var28 == 1) {
                                          Client.field378.method2801(58);
                                          Client.field378.method2701(var75[var20]);
                                          Client.field378.method2666(0);
                                       } else if(var28 == 4) {
                                          Client.field378.method2801(92);
                                          Client.field378.method2700(var75[var20]);
                                          Client.field378.method2569(0);
                                       } else if(var28 == 6) {
                                          Client.field378.method2801(94);
                                          Client.field378.method2672(var75[var20]);
                                          Client.field378.method2569(0);
                                       } else if(var28 == 7) {
                                          Client.field378.method2801(127);
                                          Client.field378.method2529(0);
                                          Client.field378.method2672(var75[var20]);
                                       }

                                       var31 = true;
                                       break;
                                    }
                                 }

                                 if(!var31) {
                                    class110.method2416(4, "", "Unable to find " + var40);
                                 }
                                 continue;
                              }

                              if(var39 == 3108) {
                                 var5 -= 3;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[var5 + 1];
                                 var30 = class38.field829[var5 + 2];
                                 var27 = class173.method3412(var30);
                                 Player.method39(var27, var28, var29);
                                 continue;
                              }

                              if(var39 == 3109) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[var5 + 1];
                                 var42 = var50?class212.field3176:class38.field827;
                                 Player.method39(var42, var28, var29);
                                 continue;
                              }

                              if(var39 == 3110) {
                                 --var5;
                                 class4.field81 = class38.field829[var5] == 1;
                                 continue;
                              }

                              if(var39 == 3111) {
                                 class38.field829[var5++] = Player.field42.field154?1:0;
                                 continue;
                              }

                              if(var39 == 3112) {
                                 --var5;
                                 Player.field42.field154 = class38.field829[var5] == 1;
                                 class127.method2819();
                                 continue;
                              }

                              if(var39 == 3113) {
                                 --var6;
                                 var45 = class38.chatboxSegments[var6];
                                 --var5;
                                 var83 = class38.field829[var5] == 1;
                                 class113.method2460(var45, var83, false);
                                 continue;
                              }

                              if(var39 == 3115) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 Client.field378.method2801(74);
                                 Client.field378.method2701(var28);
                                 continue;
                              }

                              if(var39 == 3116) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 var6 -= 2;
                                 var40 = class38.chatboxSegments[var6];
                                 var17 = class38.chatboxSegments[1 + var6];
                                 if(var40.length() <= 500 && var17.length() <= 500) {
                                    Client.field378.method2801(119);
                                    Client.field378.method2701(1 + class21.method547(var40) + class21.method547(var17));
                                    Client.field378.method2535(var17);
                                    Client.field378.method2529(var28);
                                    Client.field378.method2535(var40);
                                 }
                                 continue;
                              }
                           } else if(var39 < 3300) {
                              if(var39 == 3200) {
                                 var5 -= 3;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[var5 + 1];
                                 var30 = class38.field829[var5 + 2];
                                 if(Client.field547 != 0 && var29 != 0 && Client.field542 < 50) {
                                    Client.field543[Client.field542] = var28;
                                    Client.field544[Client.field542] = var29;
                                    Client.field545[Client.field542] = var30;
                                    Client.field554[Client.field542] = null;
                                    Client.field546[Client.field542] = 0;
                                    ++Client.field542;
                                 }
                                 continue;
                              }

                              if(var39 == 3201) {
                                 --var5;
                                 class114.method2462(class38.field829[var5]);
                                 continue;
                              }

                              if(var39 == 3202) {
                                 var5 -= 2;
                                 XItemContainer.method182(class38.field829[var5], class38.field829[var5 + 1]);
                                 continue;
                              }
                           } else if(var39 < 3400) {
                              if(var39 == 3300) {
                                 class38.field829[var5++] = Client.gameCycle;
                                 continue;
                              }

                              XItemContainer var33;
                              if(var39 == 3301) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[var5 + 1];
                                 var43 = class38.field829;
                                 var47 = var5++;
                                 var33 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var28);
                                 if(var33 == null) {
                                    var87 = -1;
                                 } else if(var29 >= 0 && var29 < var33.itemIds.length) {
                                    var87 = var33.itemIds[var29];
                                 } else {
                                    var87 = -1;
                                 }

                                 var43[var47] = var87;
                                 continue;
                              }

                              if(var39 == 3302) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[1 + var5];
                                 var43 = class38.field829;
                                 var47 = var5++;
                                 var33 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var28);
                                 if(null == var33) {
                                    var87 = 0;
                                 } else if(var29 >= 0 && var29 < var33.stackSizes.length) {
                                    var87 = var33.stackSizes[var29];
                                 } else {
                                    var87 = 0;
                                 }

                                 var43[var47] = var87;
                                 continue;
                              }

                              if(var39 == 3303) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[1 + var5];
                                 class38.field829[var5++] = Item.method661(var28, var29);
                                 continue;
                              }

                              if(var39 == 3304) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = class75.method1609(var28).field1156;
                                 continue;
                              }

                              if(var39 == 3305) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = Client.boostedSkillLevels[var28];
                                 continue;
                              }

                              if(var39 == 3306) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = Client.realSkillLevels[var28];
                                 continue;
                              }

                              if(var39 == 3307) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = Client.skillExperiences[var28];
                                 continue;
                              }

                              if(var39 == 3308) {
                                 var28 = class173.plane;
                                 var29 = (class138.localPlayer.x >> 7) + class193.baseX;
                                 var30 = DecorativeObject.baseY + (class138.localPlayer.y >> 7);
                                 class38.field829[var5++] = (var28 << 28) + (var29 << 14) + var30;
                                 continue;
                              }

                              if(var39 == 3309) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = var28 >> 14 & 16383;
                                 continue;
                              }

                              if(var39 == 3310) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = var28 >> 28;
                                 continue;
                              }

                              if(var39 == 3311) {
                                 --var5;
                                 var28 = class38.field829[var5];
                                 class38.field829[var5++] = var28 & 16383;
                                 continue;
                              }

                              if(var39 == 3312) {
                                 class38.field829[var5++] = Client.isMembers?1:0;
                                 continue;
                              }

                              if(var39 == 3313) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5] + '耀';
                                 var29 = class38.field829[var5 + 1];
                                 var43 = class38.field829;
                                 var47 = var5++;
                                 var33 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var28);
                                 if(null == var33) {
                                    var87 = -1;
                                 } else if(var29 >= 0 && var29 < var33.itemIds.length) {
                                    var87 = var33.itemIds[var29];
                                 } else {
                                    var87 = -1;
                                 }

                                 var43[var47] = var87;
                                 continue;
                              }

                              if(var39 == 3314) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5] + '耀';
                                 var29 = class38.field829[1 + var5];
                                 var43 = class38.field829;
                                 var47 = var5++;
                                 var33 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var28);
                                 if(var33 == null) {
                                    var87 = 0;
                                 } else if(var29 >= 0 && var29 < var33.stackSizes.length) {
                                    var87 = var33.stackSizes[var29];
                                 } else {
                                    var87 = 0;
                                 }

                                 var43[var47] = var87;
                                 continue;
                              }

                              if(var39 == 3315) {
                                 var5 -= 2;
                                 var28 = '耀' + class38.field829[var5];
                                 var29 = class38.field829[1 + var5];
                                 class38.field829[var5++] = Item.method661(var28, var29);
                                 continue;
                              }

                              if(var39 == 3316) {
                                 if(Client.field465 >= 2) {
                                    class38.field829[var5++] = Client.field465;
                                 } else {
                                    class38.field829[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var39 == 3317) {
                                 class38.field829[var5++] = Client.field317;
                                 continue;
                              }

                              if(var39 == 3318) {
                                 class38.field829[var5++] = Client.world;
                                 continue;
                              }

                              if(var39 == 3321) {
                                 class38.field829[var5++] = Client.energy;
                                 continue;
                              }

                              if(var39 == 3322) {
                                 class38.field829[var5++] = Client.weight;
                                 continue;
                              }

                              if(var39 == 3323) {
                                 if(Client.field516) {
                                    class38.field829[var5++] = 1;
                                 } else {
                                    class38.field829[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var39 == 3324) {
                                 class38.field829[var5++] = Client.flags;
                                 continue;
                              }
                           } else if(var39 < 3500) {
                              if(var39 == 3400) {
                                 var5 -= 2;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[1 + var5];
                                 class52 var76 = (class52)class52.field1129.get((long)var28);
                                 class52 var46;
                                 if(null != var76) {
                                    var46 = var76;
                                 } else {
                                    byte[] var49 = class52.field1136.method3292(8, var28);
                                    var76 = new class52();
                                    if(var49 != null) {
                                       var76.method1076(new Buffer(var49));
                                    }

                                    class52.field1129.put(var76, (long)var28);
                                    var46 = var76;
                                 }

                                 var76 = var46;
                                 if(var46.field1132 != 115) {
                                    ;
                                 }

                                 for(var87 = 0; var87 < var76.field1135; ++var87) {
                                    if(var29 == var76.field1131[var87]) {
                                       class38.chatboxSegments[var6++] = var76.field1133[var87];
                                       var76 = null;
                                       break;
                                    }
                                 }

                                 if(var76 != null) {
                                    class38.chatboxSegments[var6++] = var76.field1130;
                                 }
                                 continue;
                              }

                              if(var39 == 3408) {
                                 var5 -= 4;
                                 var28 = class38.field829[var5];
                                 var29 = class38.field829[var5 + 1];
                                 var30 = class38.field829[2 + var5];
                                 var47 = class38.field829[var5 + 3];
                                 class52 var91 = (class52)class52.field1129.get((long)var30);
                                 class52 var19;
                                 if(null != var91) {
                                    var19 = var91;
                                 } else {
                                    byte[] var86 = class52.field1136.method3292(8, var30);
                                    var91 = new class52();
                                    if(null != var86) {
                                       var91.method1076(new Buffer(var86));
                                    }

                                    class52.field1129.put(var91, (long)var30);
                                    var19 = var91;
                                 }

                                 var91 = var19;
                                 if(var28 == var19.field1134 && var29 == var19.field1132) {
                                    for(var21 = 0; var21 < var91.field1135; ++var21) {
                                       if(var47 == var91.field1131[var21]) {
                                          if(var29 == 115) {
                                             class38.chatboxSegments[var6++] = var91.field1133[var21];
                                          } else {
                                             class38.field829[var5++] = var91.field1137[var21];
                                          }

                                          var91 = null;
                                          break;
                                       }
                                    }

                                    if(var91 != null) {
                                       if(var29 == 115) {
                                          class38.chatboxSegments[var6++] = var91.field1130;
                                       } else {
                                          class38.field829[var5++] = var91.field1138;
                                       }
                                    }
                                    continue;
                                 }

                                 if(var29 == 115) {
                                    class38.chatboxSegments[var6++] = "null";
                                 } else {
                                    class38.field829[var5++] = 0;
                                 }
                                 continue;
                              }
                           } else {
                              String var94;
                              if(var39 < 3700) {
                                 if(var39 == 3600) {
                                    if(Client.field569 == 0) {
                                       class38.field829[var5++] = -2;
                                    } else if(Client.field569 == 1) {
                                       class38.field829[var5++] = -1;
                                    } else {
                                       class38.field829[var5++] = Client.friendCount;
                                    }
                                    continue;
                                 }

                                 if(var39 == 3601) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(Client.field569 == 2 && var28 < Client.friendCount) {
                                       class38.chatboxSegments[var6++] = Client.friends[var28].name;
                                       class38.chatboxSegments[var6++] = Client.friends[var28].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var39 == 3602) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(Client.field569 == 2 && var28 < Client.friendCount) {
                                       class38.field829[var5++] = Client.friends[var28].world;
                                       continue;
                                    }

                                    class38.field829[var5++] = 0;
                                    continue;
                                 }

                                 if(var39 == 3603) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(Client.field569 == 2 && var28 < Client.friendCount) {
                                       class38.field829[var5++] = Client.friends[var28].rank;
                                       continue;
                                    }

                                    class38.field829[var5++] = 0;
                                    continue;
                                 }

                                 if(var39 == 3604) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    --var5;
                                    var29 = class38.field829[var5];
                                    class21.method546(var45, var29);
                                    continue;
                                 }

                                 if(var39 == 3605) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    class54.method1112(var45);
                                    continue;
                                 }

                                 if(var39 == 3606) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    class49.method1020(var45);
                                    continue;
                                 }

                                 if(var39 == 3607) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    if(null == var45) {
                                       continue;
                                    }

                                    if((Client.ignoreCount < 100 || Client.field353 == 1) && Client.ignoreCount < 400) {
                                       var40 = class93.method2141(var45, Client.field302);
                                       if(var40 == null) {
                                          continue;
                                       }

                                       String var56;
                                       for(var30 = 0; var30 < Client.ignoreCount; ++var30) {
                                          Ignore var80 = Client.ignores[var30];
                                          var56 = class93.method2141(var80.name, Client.field302);
                                          if(var56 != null && var56.equals(var40)) {
                                             class110.method2416(31, "", var45 + " is already on your ignore list");
                                             continue label3711;
                                          }

                                          if(null != var80.previousName) {
                                             var94 = class93.method2141(var80.previousName, Client.field302);
                                             if(null != var94 && var94.equals(var40)) {
                                                class110.method2416(31, "", var45 + " is already on your ignore list");
                                                continue label3711;
                                             }
                                          }
                                       }

                                       for(var30 = 0; var30 < Client.friendCount; ++var30) {
                                          Friend var82 = Client.friends[var30];
                                          var56 = class93.method2141(var82.name, Client.field302);
                                          if(var56 != null && var56.equals(var40)) {
                                             class110.method2416(31, "", "Please remove " + var45 + " from your friend list first");
                                             continue label3711;
                                          }

                                          if(null != var82.previousName) {
                                             var94 = class93.method2141(var82.previousName, Client.field302);
                                             if(null != var94 && var94.equals(var40)) {
                                                class110.method2416(31, "", "Please remove " + var45 + " from your friend list first");
                                                continue label3711;
                                             }
                                          }
                                       }

                                       if(class93.method2141(class138.localPlayer.name, Client.field302).equals(var40)) {
                                          class110.method2416(31, "", "You can\'t add yourself to your own ignore list");
                                       } else {
                                          Client.field378.method2801(136);
                                          Client.field378.method2529(class21.method547(var45));
                                          Client.field378.method2535(var45);
                                       }
                                       continue;
                                    }

                                    class110.method2416(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                    continue;
                                 }

                                 if(var39 == 3608) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    class4.method54(var45);
                                    continue;
                                 }

                                 if(var39 == 3609) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    class155[] var41 = new class155[]{class155.field2314, class155.field2311, class155.field2312, class155.field2310, class155.field2309, class155.field2319};
                                    class155[] var51 = var41;

                                    for(var47 = 0; var47 < var51.length; ++var47) {
                                       class155 var52 = var51[var47];
                                       if(var52.field2317 != -1 && var45.startsWith(class109.method2411(var52.field2317))) {
                                          var45 = var45.substring(6 + Integer.toString(var52.field2317).length());
                                          break;
                                       }
                                    }

                                    class38.field829[var5++] = class0.method0(var45, false)?1:0;
                                    continue;
                                 }

                                 if(var39 == 3611) {
                                    if(null != Client.field541) {
                                       class38.chatboxSegments[var6++] = class114.method2461(Client.field541);
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var39 == 3612) {
                                    if(Client.field541 != null) {
                                       class38.field829[var5++] = class40.field896;
                                    } else {
                                       class38.field829[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var39 == 3613) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(null != Client.field541 && var28 < class40.field896) {
                                       class38.chatboxSegments[var6++] = class146.clanMembers[var28].username;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var39 == 3614) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(null != Client.field541 && var28 < class40.field896) {
                                       class38.field829[var5++] = class146.clanMembers[var28].world;
                                       continue;
                                    }

                                    class38.field829[var5++] = 0;
                                    continue;
                                 }

                                 if(var39 == 3615) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(Client.field541 != null && var28 < class40.field896) {
                                       class38.field829[var5++] = class146.clanMembers[var28].rank;
                                       continue;
                                    }

                                    class38.field829[var5++] = 0;
                                    continue;
                                 }

                                 if(var39 == 3616) {
                                    class38.field829[var5++] = class14.field224;
                                    continue;
                                 }

                                 if(var39 == 3617) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    if(null != class146.clanMembers) {
                                       Client.field378.method2801(205);
                                       Client.field378.method2529(class21.method547(var45));
                                       Client.field378.method2535(var45);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3618) {
                                    class38.field829[var5++] = Item.field713;
                                    continue;
                                 }

                                 if(var39 == 3619) {
                                    --var6;
                                    var45 = class38.chatboxSegments[var6];
                                    if(!var45.equals("")) {
                                       Client.field378.method2801(246);
                                       Client.field378.method2529(class21.method547(var45));
                                       Client.field378.method2535(var45);
                                    }
                                    continue;
                                 }

                                 if(var39 == 3620) {
                                    Client.field378.method2801(246);
                                    Client.field378.method2529(0);
                                    continue;
                                 }

                                 if(var39 == 3621) {
                                    if(Client.field569 == 0) {
                                       class38.field829[var5++] = -1;
                                    } else {
                                       class38.field829[var5++] = Client.ignoreCount;
                                    }
                                    continue;
                                 }

                                 if(var39 == 3622) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(Client.field569 != 0 && var28 < Client.ignoreCount) {
                                       class38.chatboxSegments[var6++] = Client.ignores[var28].name;
                                       class38.chatboxSegments[var6++] = Client.ignores[var28].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var39 == 3623) {
                                    label3386: {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       if(!var45.startsWith(class109.method2411(0))) {
                                          var17 = "<img=1>";
                                          if(!var45.startsWith(var17)) {
                                             break label3386;
                                          }
                                       }

                                       var45 = var45.substring(7);
                                    }

                                    class38.field829[var5++] = class128.method2839(var45)?1:0;
                                    continue;
                                 }

                                 if(var39 == 3624) {
                                    --var5;
                                    var28 = class38.field829[var5];
                                    if(class146.clanMembers != null && var28 < class40.field896 && class146.clanMembers[var28].username.equalsIgnoreCase(class138.localPlayer.name)) {
                                       class38.field829[var5++] = 1;
                                       continue;
                                    }

                                    class38.field829[var5++] = 0;
                                    continue;
                                 }

                                 if(var39 == 3625) {
                                    if(null == Client.field528) {
                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    String[] var48 = class38.chatboxSegments;
                                    var29 = var6++;
                                    String var79 = Client.field528;
                                    long var62 = 0L;
                                    var23 = var79.length();

                                    for(var69 = 0; var69 < var23; ++var69) {
                                       var62 *= 37L;
                                       char var73 = var79.charAt(var69);
                                       if(var73 >= 65 && var73 <= 90) {
                                          var62 += (long)(var73 + 1 - 65);
                                       } else if(var73 >= 97 && var73 <= 122) {
                                          var62 += (long)(var73 + 1 - 97);
                                       } else if(var73 >= 48 && var73 <= 57) {
                                          var62 += (long)(var73 + 27 - 48);
                                       }

                                       if(var62 >= 177917621779460413L) {
                                          break;
                                       }
                                    }

                                    while(0L == var62 % 37L && var62 != 0L) {
                                       var62 /= 37L;
                                    }

                                    String var88 = ItemLayer.method2244(var62);
                                    if(var88 == null) {
                                       var88 = "";
                                    }

                                    var48[var29] = var88;
                                    continue;
                                 }
                              } else {
                                 long var89;
                                 if(var39 < 4000) {
                                    if(var39 == 3903) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = Client.grandExchangeOffers[var28].method4027();
                                       continue;
                                    }

                                    if(var39 == 3904) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = Client.grandExchangeOffers[var28].itemId;
                                       continue;
                                    }

                                    if(var39 == 3905) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = Client.grandExchangeOffers[var28].price;
                                       continue;
                                    }

                                    if(var39 == 3906) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = Client.grandExchangeOffers[var28].totalQuantity;
                                       continue;
                                    }

                                    if(var39 == 3907) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = Client.grandExchangeOffers[var28].quantitySold;
                                       continue;
                                    }

                                    if(var39 == 3908) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = Client.grandExchangeOffers[var28].spent;
                                       continue;
                                    }

                                    if(var39 == 3910) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var29 = Client.grandExchangeOffers[var28].method4026();
                                       class38.field829[var5++] = var29 == 0?1:0;
                                       continue;
                                    }

                                    if(var39 == 3911) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var29 = Client.grandExchangeOffers[var28].method4026();
                                       class38.field829[var5++] = var29 == 2?1:0;
                                       continue;
                                    }

                                    if(var39 == 3912) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var29 = Client.grandExchangeOffers[var28].method4026();
                                       class38.field829[var5++] = var29 == 5?1:0;
                                       continue;
                                    }

                                    if(var39 == 3913) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var29 = Client.grandExchangeOffers[var28].method4026();
                                       class38.field829[var5++] = var29 == 1?1:0;
                                       continue;
                                    }

                                    boolean var98;
                                    if(var39 == 3914) {
                                       --var5;
                                       var98 = class38.field829[var5] == 1;
                                       if(class136.field2122 != null) {
                                          class136.field2122.method4046(class224.field3233, var98);
                                       }
                                       continue;
                                    }

                                    if(var39 == 3915) {
                                       --var5;
                                       var98 = class38.field829[var5] == 1;
                                       if(class136.field2122 != null) {
                                          class136.field2122.method4046(class224.field3232, var98);
                                       }
                                       continue;
                                    }

                                    if(var39 == 3916) {
                                       var5 -= 2;
                                       var98 = class38.field829[var5] == 1;
                                       var83 = class38.field829[1 + var5] == 1;
                                       if(null != class136.field2122) {
                                          class136.field2122.method4046(new class22(var83), var98);
                                       }
                                       continue;
                                    }

                                    if(var39 == 3917) {
                                       --var5;
                                       var98 = class38.field829[var5] == 1;
                                       if(null != class136.field2122) {
                                          class136.field2122.method4046(class224.field3231, var98);
                                       }
                                       continue;
                                    }

                                    if(var39 == 3918) {
                                       --var5;
                                       var98 = class38.field829[var5] == 1;
                                       if(class136.field2122 != null) {
                                          class136.field2122.method4046(class224.field3235, var98);
                                       }
                                       continue;
                                    }

                                    if(var39 == 3919) {
                                       class38.field829[var5++] = null == class136.field2122?0:class136.field2122.field3230.size();
                                       continue;
                                    }

                                    class217 var44;
                                    if(var39 == 3920) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       class38.field829[var5++] = var44.field3204;
                                       continue;
                                    }

                                    if(var39 == 3921) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       class38.chatboxSegments[var6++] = var44.method3978();
                                       continue;
                                    }

                                    if(var39 == 3922) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       class38.chatboxSegments[var6++] = var44.method3979();
                                       continue;
                                    }

                                    if(var39 == 3923) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       var89 = class34.method738() - class38.field831 - var44.field3207;
                                       var87 = (int)(var89 / 3600000L);
                                       var20 = (int)((var89 - (long)(var87 * 3600000)) / 60000L);
                                       var21 = (int)((var89 - (long)(3600000 * var87) - (long)(var20 * '\uea60')) / 1000L);
                                       String var34 = var87 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                       class38.chatboxSegments[var6++] = var34;
                                       continue;
                                    }

                                    if(var39 == 3924) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       class38.field829[var5++] = var44.field3205.totalQuantity;
                                       continue;
                                    }

                                    if(var39 == 3925) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       class38.field829[var5++] = var44.field3205.price;
                                       continue;
                                    }

                                    if(var39 == 3926) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var44 = (class217)class136.field2122.field3230.get(var28);
                                       class38.field829[var5++] = var44.field3205.itemId;
                                       continue;
                                    }
                                 } else if(var39 < 4100) {
                                    if(var39 == 4000) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var29 + var28;
                                       continue;
                                    }

                                    if(var39 == 4001) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var28 - var29;
                                       continue;
                                    }

                                    if(var39 == 4002) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var29 * var28;
                                       continue;
                                    }

                                    if(var39 == 4003) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       class38.field829[var5++] = var28 / var29;
                                       continue;
                                    }

                                    if(var39 == 4004) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = (int)(Math.random() * (double)var28);
                                       continue;
                                    }

                                    if(var39 == 4005) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = (int)(Math.random() * (double)(var28 + 1));
                                       continue;
                                    }

                                    if(var39 == 4006) {
                                       var5 -= 5;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       var30 = class38.field829[var5 + 2];
                                       var47 = class38.field829[var5 + 3];
                                       var87 = class38.field829[var5 + 4];
                                       class38.field829[var5++] = var28 + (var29 - var28) * (var87 - var30) / (var47 - var30);
                                       continue;
                                    }

                                    if(var39 == 4007) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var28 * var29 / 100 + var28;
                                       continue;
                                    }

                                    if(var39 == 4008) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       class38.field829[var5++] = var28 | 1 << var29;
                                       continue;
                                    }

                                    if(var39 == 4009) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var28 & -1 - (1 << var29);
                                       continue;
                                    }

                                    if(var39 == 4010) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       class38.field829[var5++] = (var28 & 1 << var29) != 0?1:0;
                                       continue;
                                    }

                                    if(var39 == 4011) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var28 % var29;
                                       continue;
                                    }

                                    if(var39 == 4012) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       if(var28 == 0) {
                                          class38.field829[var5++] = 0;
                                       } else {
                                          class38.field829[var5++] = (int)Math.pow((double)var28, (double)var29);
                                       }
                                       continue;
                                    }

                                    if(var39 == 4013) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       if(var28 == 0) {
                                          class38.field829[var5++] = 0;
                                       } else if(var29 == 0) {
                                          class38.field829[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class38.field829[var5++] = (int)Math.pow((double)var28, 1.0D / (double)var29);
                                       }
                                       continue;
                                    }

                                    if(var39 == 4014) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var28 & var29;
                                       continue;
                                    }

                                    if(var39 == 4015) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       class38.field829[var5++] = var28 | var29;
                                       continue;
                                    }

                                    if(var39 == 4018) {
                                       var5 -= 3;
                                       long var105 = (long)class38.field829[var5];
                                       var89 = (long)class38.field829[1 + var5];
                                       long var95 = (long)class38.field829[2 + var5];
                                       class38.field829[var5++] = (int)(var95 * var105 / var89);
                                       continue;
                                    }
                                 } else if(var39 < 4200) {
                                    if(var39 == 4100) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       --var5;
                                       var29 = class38.field829[var5];
                                       class38.chatboxSegments[var6++] = var45 + var29;
                                       continue;
                                    }

                                    if(var39 == 4101) {
                                       var6 -= 2;
                                       var45 = class38.chatboxSegments[var6];
                                       var40 = class38.chatboxSegments[var6 + 1];
                                       class38.chatboxSegments[var6++] = var45 + var40;
                                       continue;
                                    }

                                    if(var39 == 4102) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       --var5;
                                       var29 = class38.field829[var5];
                                       var55 = class38.chatboxSegments;
                                       var47 = var6++;
                                       if(var29 < 0) {
                                          var94 = Integer.toString(var29);
                                       } else {
                                          var94 = XItemContainer.method185(var29, 10, true);
                                       }

                                       var55[var47] = var45 + var94;
                                       continue;
                                    }

                                    if(var39 == 4103) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = var45.toLowerCase();
                                       continue;
                                    }

                                    if(var39 == 4104) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       long var104 = 86400000L * ((long)var28 + 11745L);
                                       class38.field828.setTime(new Date(var104));
                                       var47 = class38.field828.get(5);
                                       var87 = class38.field828.get(2);
                                       var20 = class38.field828.get(1);
                                       class38.chatboxSegments[var6++] = var47 + "-" + class38.field825[var87] + "-" + var20;
                                       continue;
                                    }

                                    if(var39 == 4105) {
                                       var6 -= 2;
                                       var45 = class38.chatboxSegments[var6];
                                       var40 = class38.chatboxSegments[var6 + 1];
                                       if(null != class138.localPlayer.composition && class138.localPlayer.composition.isFemale) {
                                          class38.chatboxSegments[var6++] = var40;
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = var45;
                                       continue;
                                    }

                                    if(var39 == 4106) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.chatboxSegments[var6++] = Integer.toString(var28);
                                       continue;
                                    }

                                    if(var39 == 4107) {
                                       var6 -= 2;
                                       class38.field829[var5++] = Widget.method3455(class47.method971(class38.chatboxSegments[var6], class38.chatboxSegments[var6 + 1], Client.field310));
                                       continue;
                                    }

                                    class227 var59;
                                    byte[] var84;
                                    if(var39 == 4108) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var29 = class38.field829[var5];
                                       var30 = class38.field829[var5 + 1];
                                       var84 = class168.field2705.method3292(var30, 0);
                                       var59 = new class227(var84);
                                       class38.field829[var5++] = var59.method4084(var45, var29);
                                       continue;
                                    }

                                    if(var39 == 4109) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var29 = class38.field829[var5];
                                       var30 = class38.field829[1 + var5];
                                       var84 = class168.field2705.method3292(var30, 0);
                                       var59 = new class227(var84);
                                       class38.field829[var5++] = var59.method4064(var45, var29);
                                       continue;
                                    }

                                    if(var39 == 4110) {
                                       var6 -= 2;
                                       var45 = class38.chatboxSegments[var6];
                                       var40 = class38.chatboxSegments[1 + var6];
                                       --var5;
                                       if(class38.field829[var5] == 1) {
                                          class38.chatboxSegments[var6++] = var45;
                                       } else {
                                          class38.chatboxSegments[var6++] = var40;
                                       }
                                       continue;
                                    }

                                    if(var39 == 4111) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = class226.method4066(var45);
                                       continue;
                                    }

                                    if(var39 == 4112) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       --var5;
                                       var29 = class38.field829[var5];
                                       class38.chatboxSegments[var6++] = var45 + (char)var29;
                                       continue;
                                    }

                                    char var96;
                                    if(var39 == 4113) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var57 = class38.field829;
                                       var30 = var5++;
                                       var96 = (char)var28;
                                       if(var96 >= 32 && var96 <= 126) {
                                          var18 = true;
                                       } else if(var96 >= 160 && var96 <= 255) {
                                          var18 = true;
                                       } else if(var96 != 8364 && var96 != 338 && var96 != 8212 && var96 != 339 && var96 != 376) {
                                          var18 = false;
                                       } else {
                                          var18 = true;
                                       }

                                       var57[var30] = var18?1:0;
                                       continue;
                                    }

                                    if(var39 == 4114) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var57 = class38.field829;
                                       var30 = var5++;
                                       var96 = (char)var28;
                                       var18 = var96 >= 48 && var96 <= 57 || var96 >= 65 && var96 <= 90 || var96 >= 97 && var96 <= 122;
                                       var57[var30] = var18?1:0;
                                       continue;
                                    }

                                    if(var39 == 4115) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = FrameMap.method2320((char)var28)?1:0;
                                       continue;
                                    }

                                    if(var39 == 4116) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = class143.method3011((char)var28)?1:0;
                                       continue;
                                    }

                                    if(var39 == 4117) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       if(null != var45) {
                                          class38.field829[var5++] = var45.length();
                                       } else {
                                          class38.field829[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var39 == 4118) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var29 = class38.field829[var5];
                                       var30 = class38.field829[1 + var5];
                                       class38.chatboxSegments[var6++] = var45.substring(var29, var30);
                                       continue;
                                    }

                                    if(var39 == 4119) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       StringBuilder var53 = new StringBuilder(var45.length());
                                       var93 = false;

                                       for(var47 = 0; var47 < var45.length(); ++var47) {
                                          var96 = var45.charAt(var47);
                                          if(var96 == 60) {
                                             var93 = true;
                                          } else if(var96 == 62) {
                                             var93 = false;
                                          } else if(!var93) {
                                             var53.append(var96);
                                          }
                                       }

                                       class38.chatboxSegments[var6++] = var53.toString();
                                       continue;
                                    }

                                    if(var39 == 4120) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       --var5;
                                       var29 = class38.field829[var5];
                                       class38.field829[var5++] = var45.indexOf(var29);
                                       continue;
                                    }

                                    if(var39 == 4121) {
                                       var6 -= 2;
                                       var45 = class38.chatboxSegments[var6];
                                       var40 = class38.chatboxSegments[1 + var6];
                                       --var5;
                                       var30 = class38.field829[var5];
                                       class38.field829[var5++] = var45.indexOf(var40, var30);
                                       continue;
                                    }
                                 } else if(var39 < 4300) {
                                    if(var39 == 4200) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.chatboxSegments[var6++] = class92.getItemDefinition(var28).name;
                                       continue;
                                    }

                                    ItemComposition var58;
                                    if(var39 == 4201) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       var58 = class92.getItemDefinition(var28);
                                       if(var29 >= 1 && var29 <= 5 && null != var58.groundActions[var29 - 1]) {
                                          class38.chatboxSegments[var6++] = var58.groundActions[var29 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var39 == 4202) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       var58 = class92.getItemDefinition(var28);
                                       if(var29 >= 1 && var29 <= 5 && var58.inventoryActions[var29 - 1] != null) {
                                          class38.chatboxSegments[var6++] = var58.inventoryActions[var29 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var39 == 4203) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = class92.getItemDefinition(var28).price;
                                       continue;
                                    }

                                    if(var39 == 4204) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = class92.getItemDefinition(var28).isStackable == 1?1:0;
                                       continue;
                                    }

                                    ItemComposition var61;
                                    if(var39 == 4205) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var61 = class92.getItemDefinition(var28);
                                       if(var61.field1203 == -1 && var61.note >= 0) {
                                          class38.field829[var5++] = var61.note;
                                          continue;
                                       }

                                       class38.field829[var5++] = var28;
                                       continue;
                                    }

                                    if(var39 == 4206) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var61 = class92.getItemDefinition(var28);
                                       if(var61.field1203 >= 0 && var61.note >= 0) {
                                          class38.field829[var5++] = var61.note;
                                          continue;
                                       }

                                       class38.field829[var5++] = var28;
                                       continue;
                                    }

                                    if(var39 == 4207) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       class38.field829[var5++] = class92.getItemDefinition(var28).isMembers?1:0;
                                       continue;
                                    }

                                    if(var39 == 4208) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var61 = class92.getItemDefinition(var28);
                                       if(var61.field1212 == -1 && var61.field1213 >= 0) {
                                          class38.field829[var5++] = var61.field1213;
                                          continue;
                                       }

                                       class38.field829[var5++] = var28;
                                       continue;
                                    }

                                    if(var39 == 4209) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var61 = class92.getItemDefinition(var28);
                                       if(var61.field1212 >= 0 && var61.field1213 >= 0) {
                                          class38.field829[var5++] = var61.field1213;
                                          continue;
                                       }

                                       class38.field829[var5++] = var28;
                                       continue;
                                    }

                                    if(var39 == 4210) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       --var5;
                                       var29 = class38.field829[var5];
                                       var18 = var29 == 1;
                                       var17 = var45.toLowerCase();
                                       short[] var60 = new short[16];
                                       var20 = 0;
                                       var21 = 0;

                                       while(true) {
                                          if(var21 >= class54.field1157) {
                                             Ignore.field145 = var60;
                                             class141.field2183 = 0;
                                             class50.field1093 = var20;
                                             String[] var90 = new String[class50.field1093];

                                             for(var22 = 0; var22 < class50.field1093; ++var22) {
                                                var90[var22] = class92.getItemDefinition(var60[var22]).name;
                                             }

                                             GameObject.method2242(var90, Ignore.field145);
                                             break;
                                          }

                                          ItemComposition var92 = class92.getItemDefinition(var21);
                                          if((!var18 || var92.field1210) && var92.field1203 == -1 && var92.name.toLowerCase().indexOf(var17) != -1) {
                                             if(var20 >= 250) {
                                                class50.field1093 = -1;
                                                Ignore.field145 = null;
                                                break;
                                             }

                                             if(var20 >= var60.length) {
                                                short[] var35 = new short[2 * var60.length];

                                                for(var69 = 0; var69 < var20; ++var69) {
                                                   var35[var69] = var60[var69];
                                                }

                                                var60 = var35;
                                             }

                                             var60[var20++] = (short)var21;
                                          }

                                          ++var21;
                                       }

                                       class38.field829[var5++] = class50.field1093;
                                       continue;
                                    }

                                    if(var39 == 4211) {
                                       if(Ignore.field145 != null && class141.field2183 < class50.field1093) {
                                          class38.field829[var5++] = Ignore.field145[++class141.field2183 - 1] & '\uffff';
                                          continue;
                                       }

                                       class38.field829[var5++] = -1;
                                       continue;
                                    }

                                    if(var39 == 4212) {
                                       class141.field2183 = 0;
                                       continue;
                                    }
                                 } else if(var39 < 5100) {
                                    if(var39 == 5000) {
                                       class38.field829[var5++] = Client.field518;
                                       continue;
                                    }

                                    if(var39 == 5001) {
                                       var5 -= 3;
                                       Client.field518 = class38.field829[var5];
                                       var29 = class38.field829[1 + var5];
                                       class133[] var64 = class1.method9();
                                       var47 = 0;

                                       class133 var103;
                                       while(true) {
                                          if(var47 >= var64.length) {
                                             var103 = null;
                                             break;
                                          }

                                          class133 var67 = var64[var47];
                                          if(var67.field2112 == var29) {
                                             var103 = var67;
                                             break;
                                          }

                                          ++var47;
                                       }

                                       class173.field2754 = var103;
                                       if(null == class173.field2754) {
                                          class173.field2754 = class133.field2113;
                                       }

                                       Client.field519 = class38.field829[var5 + 2];
                                       Client.field378.method2801(162);
                                       Client.field378.method2529(Client.field518);
                                       Client.field378.method2529(class173.field2754.field2112);
                                       Client.field378.method2529(Client.field519);
                                       continue;
                                    }

                                    if(var39 == 5002) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var29 = class38.field829[var5];
                                       var30 = class38.field829[1 + var5];
                                       Client.field378.method2801(121);
                                       Client.field378.method2529(class21.method547(var45) + 2);
                                       Client.field378.method2535(var45);
                                       Client.field378.method2529(var29 - 1);
                                       Client.field378.method2529(var30);
                                       continue;
                                    }

                                    if(var39 == 5003) {
                                       var5 -= 2;
                                       var28 = class38.field829[var5];
                                       var29 = class38.field829[var5 + 1];
                                       MessageNode var63 = Actor.method798(var28, var29);
                                       if(null != var63) {
                                          class38.field829[var5++] = var63.id;
                                          class38.field829[var5++] = var63.tick;
                                          class38.chatboxSegments[var6++] = var63.name != null?var63.name:"";
                                          class38.chatboxSegments[var6++] = null != var63.sender?var63.sender:"";
                                          class38.chatboxSegments[var6++] = null != var63.value?var63.value:"";
                                       } else {
                                          class38.field829[var5++] = -1;
                                          class38.field829[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var39 == 5004) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       MessageNode var71 = class54.method1113(var28);
                                       if(null != var71) {
                                          class38.field829[var5++] = var71.type;
                                          class38.field829[var5++] = var71.tick;
                                          class38.chatboxSegments[var6++] = null != var71.name?var71.name:"";
                                          class38.chatboxSegments[var6++] = null != var71.sender?var71.sender:"";
                                          class38.chatboxSegments[var6++] = var71.value != null?var71.value:"";
                                       } else {
                                          class38.field829[var5++] = -1;
                                          class38.field829[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var39 == 5005) {
                                       if(class173.field2754 == null) {
                                          class38.field829[var5++] = -1;
                                       } else {
                                          class38.field829[var5++] = class173.field2754.field2112;
                                       }
                                       continue;
                                    }

                                    if(var39 == 5008) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       --var5;
                                       var29 = class38.field829[var5];
                                       var17 = var45.toLowerCase();
                                       byte var81 = 0;
                                       if(var17.startsWith("yellow:")) {
                                          var81 = 0;
                                          var45 = var45.substring("yellow:".length());
                                       } else if(var17.startsWith("red:")) {
                                          var81 = 1;
                                          var45 = var45.substring("red:".length());
                                       } else if(var17.startsWith("green:")) {
                                          var81 = 2;
                                          var45 = var45.substring("green:".length());
                                       } else if(var17.startsWith("cyan:")) {
                                          var81 = 3;
                                          var45 = var45.substring("cyan:".length());
                                       } else if(var17.startsWith("purple:")) {
                                          var81 = 4;
                                          var45 = var45.substring("purple:".length());
                                       } else if(var17.startsWith("white:")) {
                                          var81 = 5;
                                          var45 = var45.substring("white:".length());
                                       } else if(var17.startsWith("flash1:")) {
                                          var81 = 6;
                                          var45 = var45.substring("flash1:".length());
                                       } else if(var17.startsWith("flash2:")) {
                                          var81 = 7;
                                          var45 = var45.substring("flash2:".length());
                                       } else if(var17.startsWith("flash3:")) {
                                          var81 = 8;
                                          var45 = var45.substring("flash3:".length());
                                       } else if(var17.startsWith("glow1:")) {
                                          var81 = 9;
                                          var45 = var45.substring("glow1:".length());
                                       } else if(var17.startsWith("glow2:")) {
                                          var81 = 10;
                                          var45 = var45.substring("glow2:".length());
                                       } else if(var17.startsWith("glow3:")) {
                                          var81 = 11;
                                          var45 = var45.substring("glow3:".length());
                                       } else if(Client.field310 != 0) {
                                          if(var17.startsWith("yellow:")) {
                                             var81 = 0;
                                             var45 = var45.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var81 = 1;
                                             var45 = var45.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var81 = 2;
                                             var45 = var45.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var81 = 3;
                                             var45 = var45.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var81 = 4;
                                             var45 = var45.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var81 = 5;
                                             var45 = var45.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var81 = 6;
                                             var45 = var45.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var81 = 7;
                                             var45 = var45.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var81 = 8;
                                             var45 = var45.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var81 = 9;
                                             var45 = var45.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var81 = 10;
                                             var45 = var45.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var81 = 11;
                                             var45 = var45.substring("glow3:".length());
                                          }
                                       }

                                       var17 = var45.toLowerCase();
                                       byte var100 = 0;
                                       if(var17.startsWith("wave:")) {
                                          var100 = 1;
                                          var45 = var45.substring("wave:".length());
                                       } else if(var17.startsWith("wave2:")) {
                                          var100 = 2;
                                          var45 = var45.substring("wave2:".length());
                                       } else if(var17.startsWith("shake:")) {
                                          var100 = 3;
                                          var45 = var45.substring("shake:".length());
                                       } else if(var17.startsWith("scroll:")) {
                                          var100 = 4;
                                          var45 = var45.substring("scroll:".length());
                                       } else if(var17.startsWith("slide:")) {
                                          var100 = 5;
                                          var45 = var45.substring("slide:".length());
                                       } else if(Client.field310 != 0) {
                                          if(var17.startsWith("wave:")) {
                                             var100 = 1;
                                             var45 = var45.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var100 = 2;
                                             var45 = var45.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var100 = 3;
                                             var45 = var45.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var100 = 4;
                                             var45 = var45.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var100 = 5;
                                             var45 = var45.substring("slide:".length());
                                          }
                                       }

                                       Client.field378.method2801(133);
                                       Client.field378.method2529(0);
                                       var20 = Client.field378.offset;
                                       Client.field378.method2529(var29);
                                       Client.field378.method2529(var81);
                                       Client.field378.method2529(var100);
                                       class32.method676(Client.field378, var45);
                                       Client.field378.method2563(Client.field378.offset - var20);
                                       continue;
                                    }

                                    if(var39 == 5009) {
                                       var6 -= 2;
                                       var45 = class38.chatboxSegments[var6];
                                       var40 = class38.chatboxSegments[1 + var6];
                                       Client.field378.method2801(120);
                                       Client.field378.method2701(0);
                                       var30 = Client.field378.offset;
                                       Client.field378.method2535(var45);
                                       class32.method676(Client.field378, var40);
                                       Client.field378.method2636(Client.field378.offset - var30);
                                       continue;
                                    }

                                    if(var39 == 5015) {
                                       if(null != class138.localPlayer && null != class138.localPlayer.name) {
                                          var45 = class138.localPlayer.name;
                                       } else {
                                          var45 = "";
                                       }

                                       class38.chatboxSegments[var6++] = var45;
                                       continue;
                                    }

                                    if(var39 == 5016) {
                                       class38.field829[var5++] = Client.field519;
                                       continue;
                                    }

                                    if(var39 == 5017) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var57 = class38.field829;
                                       var30 = var5++;
                                       ChatLineBuffer var66 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var28));
                                       if(var66 == null) {
                                          var47 = 0;
                                       } else {
                                          var47 = var66.method637();
                                       }

                                       var57[var30] = var47;
                                       continue;
                                    }

                                    MessageNode var65;
                                    if(var39 == 5018) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var57 = class38.field829;
                                       var30 = var5++;
                                       var65 = (MessageNode)class11.field192.method3827((long)var28);
                                       if(null == var65) {
                                          var47 = -1;
                                       } else if(class11.field182.field3158 == var65.previous) {
                                          var47 = -1;
                                       } else {
                                          var47 = ((MessageNode)var65.previous).id;
                                       }

                                       var57[var30] = var47;
                                       continue;
                                    }

                                    if(var39 == 5019) {
                                       --var5;
                                       var28 = class38.field829[var5];
                                       var57 = class38.field829;
                                       var30 = var5++;
                                       var65 = (MessageNode)class11.field192.method3827((long)var28);
                                       if(var65 == null) {
                                          var47 = -1;
                                       } else if(var65.next == class11.field182.field3158) {
                                          var47 = -1;
                                       } else {
                                          var47 = ((MessageNode)var65.next).id;
                                       }

                                       var57[var30] = var47;
                                       continue;
                                    }

                                    if(var39 == 5020) {
                                       --var6;
                                       var45 = class38.chatboxSegments[var6];
                                       method643(var45);
                                       continue;
                                    }

                                    if(var39 == 5021) {
                                       --var6;
                                       Client.field505 = class38.chatboxSegments[var6].toLowerCase().trim();
                                       continue;
                                    }

                                    if(var39 == 5022) {
                                       class38.chatboxSegments[var6++] = Client.field505;
                                       continue;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if(var39 < 5400) {
                  if(var39 == 5306) {
                     int[] var107 = class38.field829;
                     var29 = var5++;
                     var30 = Client.isResized?2:1;
                     var107[var29] = var30;
                     continue;
                  }

                  if(var39 == 5307) {
                     --var5;
                     var28 = class38.field829[var5];
                     if(var28 != 1 && var28 != 2) {
                        continue;
                     }

                     Client.field422 = 0L;
                     if(var28 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     class143.method3010();
                     if(Client.gameState >= 25) {
                        class75.method1610();
                     }

                     GameEngine.field2253 = true;
                     continue;
                  }

                  if(var39 == 5308) {
                     class38.field829[var5++] = Player.field42.field161;
                     continue;
                  }

                  if(var39 == 5309) {
                     --var5;
                     var28 = class38.field829[var5];
                     if(var28 == 1 || var28 == 2) {
                        Player.field42.field161 = var28;
                        class127.method2819();
                     }
                     continue;
                  }
               }

               if(var39 < 5600) {
                  if(var39 == 5504) {
                     var5 -= 2;
                     var28 = class38.field829[var5];
                     var29 = class38.field829[1 + var5];
                     if(!Client.field548) {
                        Client.field386 = var28;
                        Client.mapAngle = var29;
                     }
                     continue;
                  }

                  if(var39 == 5505) {
                     class38.field829[var5++] = Client.field386;
                     continue;
                  }

                  if(var39 == 5506) {
                     class38.field829[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var39 == 5530) {
                     --var5;
                     var28 = class38.field829[var5];
                     if(var28 < 0) {
                        var28 = 0;
                     }

                     Client.field579 = var28;
                     continue;
                  }

                  if(var39 == 5531) {
                     class38.field829[var5++] = Client.field579;
                     continue;
                  }
               }

               if(var39 < 5700 && var39 == 5630) {
                  Client.field355 = 250;
               } else {
                  if(var39 < 6300) {
                     if(var39 == 6200) {
                        var5 -= 2;
                        Client.field318 = (short)class38.field829[var5];
                        if(Client.field318 <= 0) {
                           Client.field318 = 256;
                        }

                        Client.field297 = (short)class38.field829[1 + var5];
                        if(Client.field297 <= 0) {
                           Client.field297 = 205;
                        }
                        continue;
                     }

                     if(var39 == 6201) {
                        var5 -= 2;
                        Client.field557 = (short)class38.field829[var5];
                        if(Client.field557 <= 0) {
                           Client.field557 = 256;
                        }

                        Client.field558 = (short)class38.field829[var5 + 1];
                        if(Client.field558 <= 0) {
                           Client.field558 = 320;
                        }
                        continue;
                     }

                     if(var39 == 6202) {
                        var5 -= 4;
                        Client.field559 = (short)class38.field829[var5];
                        if(Client.field559 <= 0) {
                           Client.field559 = 1;
                        }

                        Client.field394 = (short)class38.field829[1 + var5];
                        if(Client.field394 <= 0) {
                           Client.field394 = 32767;
                        } else if(Client.field394 < Client.field559) {
                           Client.field394 = Client.field559;
                        }

                        Client.field561 = (short)class38.field829[var5 + 2];
                        if(Client.field561 <= 0) {
                           Client.field561 = 1;
                        }

                        Client.field560 = (short)class38.field829[3 + var5];
                        if(Client.field560 <= 0) {
                           Client.field560 = 32767;
                        } else if(Client.field560 < Client.field561) {
                           Client.field560 = Client.field561;
                        }
                        continue;
                     }

                     if(var39 == 6203) {
                        if(Client.field535 != null) {
                           class153.method3179(0, 0, Client.field535.width, Client.field535.height, false);
                           class38.field829[var5++] = Client.camera2;
                           class38.field829[var5++] = Client.camera3;
                        } else {
                           class38.field829[var5++] = -1;
                           class38.field829[var5++] = -1;
                        }
                        continue;
                     }

                     if(var39 == 6204) {
                        class38.field829[var5++] = Client.field557;
                        class38.field829[var5++] = Client.field558;
                        continue;
                     }

                     if(var39 == 6205) {
                        class38.field829[var5++] = Client.field318;
                        class38.field829[var5++] = Client.field297;
                        continue;
                     }
                  }

                  if(var39 < 6600) {
                     if(var39 == 6500) {
                        class38.field829[var5++] = FrameMap.loadWorlds()?1:0;
                        continue;
                     }

                     World var106;
                     if(var39 == 6501) {
                        World.field665 = 0;
                        var106 = MessageNode.method771();
                        if(var106 != null) {
                           class38.field829[var5++] = var106.id;
                           class38.field829[var5++] = var106.mask;
                           class38.chatboxSegments[var6++] = var106.activity;
                           class38.field829[var5++] = var106.location;
                           class38.field829[var5++] = var106.playerCount;
                           class38.chatboxSegments[var6++] = var106.address;
                        } else {
                           class38.field829[var5++] = -1;
                           class38.field829[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field829[var5++] = 0;
                           class38.field829[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var39 == 6502) {
                        var106 = MessageNode.method771();
                        if(null != var106) {
                           class38.field829[var5++] = var106.id;
                           class38.field829[var5++] = var106.mask;
                           class38.chatboxSegments[var6++] = var106.activity;
                           class38.field829[var5++] = var106.location;
                           class38.field829[var5++] = var106.playerCount;
                           class38.chatboxSegments[var6++] = var106.address;
                        } else {
                           class38.field829[var5++] = -1;
                           class38.field829[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field829[var5++] = 0;
                           class38.field829[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var78;
                     if(var39 == 6506) {
                        --var5;
                        var28 = class38.field829[var5];
                        var78 = null;

                        for(var30 = 0; var30 < World.field685; ++var30) {
                           if(var28 == VertexNormal.worldList[var30].id) {
                              var78 = VertexNormal.worldList[var30];
                              break;
                           }
                        }

                        if(null != var78) {
                           class38.field829[var5++] = var78.id;
                           class38.field829[var5++] = var78.mask;
                           class38.chatboxSegments[var6++] = var78.activity;
                           class38.field829[var5++] = var78.location;
                           class38.field829[var5++] = var78.playerCount;
                           class38.chatboxSegments[var6++] = var78.address;
                        } else {
                           class38.field829[var5++] = -1;
                           class38.field829[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field829[var5++] = 0;
                           class38.field829[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var39 == 6507) {
                        var5 -= 4;
                        var28 = class38.field829[var5];
                        var83 = class38.field829[var5 + 1] == 1;
                        var30 = class38.field829[2 + var5];
                        var18 = class38.field829[var5 + 3] == 1;
                        XItemContainer.method184(var28, var83, var30, var18);
                        continue;
                     }

                     if(var39 == 6511) {
                        --var5;
                        var28 = class38.field829[var5];
                        if(var28 >= 0 && var28 < World.field685) {
                           var78 = VertexNormal.worldList[var28];
                           class38.field829[var5++] = var78.id;
                           class38.field829[var5++] = var78.mask;
                           class38.chatboxSegments[var6++] = var78.activity;
                           class38.field829[var5++] = var78.location;
                           class38.field829[var5++] = var78.playerCount;
                           class38.chatboxSegments[var6++] = var78.address;
                           continue;
                        }

                        class38.field829[var5++] = -1;
                        class38.field829[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field829[var5++] = 0;
                        class38.field829[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var38) {
            StringBuilder var37 = new StringBuilder(30);
            var37.append("").append(var4.hash).append(" ");

            for(var13 = class38.field832 - 1; var13 >= 0; --var13) {
               var37.append("").append(class38.field818[var13].field222.hash).append(" ");
            }

            var37.append("").append(var10);
            class93.method2139(var37.toString(), var38);
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "1"
   )
   MessageNode method635(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method3924();
         var5.method765(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "38"
   )
   MessageNode method636(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1573349313"
   )
   int method637() {
      return this.length;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "114"
   )
   static final void method643(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         Player.field42.field154 = !Player.field42.field154;
         class127.method2819();
         if(Player.field42.field154) {
            class110.method2416(99, "", "Roofs are now all hidden");
         } else {
            class110.method2416(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field316 = !Client.field316;
      }

      if(Client.field465 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field316 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field316 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field355 > 0) {
               Sequence.method902();
            } else {
               class117.setGameState(40);
               class59.field1250 = ObjectComposition.field993;
               ObjectComposition.field993 = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field514 == 2) {
            throw new RuntimeException();
         }
      }

      Client.field378.method2801(177);
      Client.field378.method2529(var0.length() + 1);
      Client.field378.method2535(var0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "339859276"
   )
   static final int method646(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2529(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2709(var3.nextInt());
      }

      var4.method2709(var6[0]);
      var4.method2709(var6[1]);
      var4.method2678(var0);
      var4.method2678(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2709(var3.nextInt());
      }

      var4.method2565(class9.field169, class9.field168);
      var5.method2529(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2709(var3.nextInt());
      }

      var5.method2678(var3.nextLong());
      var5.method2533(var3.nextLong());
      byte[] var16 = new byte[24];

      try {
         class152.field2283.method4174(0L);
         class152.field2283.method4176(var16);

         int var8;
         for(var8 = 0; var8 < 24 && var16[var8] == 0; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var21) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var16[var9] = -1;
         }
      }

      var5.method2581(var16, 0, 24);
      var5.method2678(var3.nextLong());
      var5.method2565(class9.field169, class9.field168);
      var7 = class21.method547(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var17 = new Buffer(var7);
      var17.method2535(var2);
      var17.offset = var7;
      var17.method2718(var6);
      Buffer var18 = new Buffer(var4.offset + 5 + var5.offset + var17.offset);
      var18.method2529(2);
      var18.method2529(var4.offset);
      var18.method2581(var4.payload, 0, var4.offset);
      var18.method2529(var5.offset);
      var18.method2581(var5.payload, 0, var5.offset);
      var18.method2701(var17.offset);
      var18.method2581(var17.payload, 0, var17.offset);
      String var10 = RSCanvas.method2983(var18.payload);

      try {
         URL var11 = new URL(class118.method2485("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class158.method3193(var10) + "&dest=" + class158.method3193("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var18 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var18.payload, var18.offset, 1000 - var18.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var19 = new String(var18.payload);
               if(var19.startsWith("OFFLINE")) {
                  return 4;
               } else if(var19.startsWith("WRONG")) {
                  return 7;
               } else if(var19.startsWith("RELOAD")) {
                  return 3;
               } else if(var19.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var18.method2562(var6);

                  while(var18.offset > 0 && var18.payload[var18.offset - 1] == 0) {
                     --var18.offset;
                  }

                  var19 = new String(var18.payload, 0, var18.offset);
                  if(class137.method2907(var19)) {
                     class113.method2460(var19, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var18.offset += var15;
         } while(var18.offset < 1000);

         return 5;
      } catch (Throwable var20) {
         var20.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1322228810"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class11.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method635(var0, var1, var2, var3);
      class11.field192.method3830(var5, (long)var5.id);
      class11.field182.method3876(var5);
      Client.field492 = Client.field485;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "691668234"
   )
   public static void method649() {
      class79.field1439 = null;
      class79.field1438 = null;
      class79.field1443 = null;
      class79.field1440 = null;
      class129.field2092 = null;
      class79.field1441 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1187641386"
   )
   static boolean method651(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}

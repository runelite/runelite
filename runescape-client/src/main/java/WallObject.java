import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1602666729
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 675182107
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1804401539
   )
   int field1585;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1256191337
   )
   int field1586 = 0;
   @ObfuscatedName("m")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 683416893
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2037663559
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 904606765
   )
   int field1591;
   @ObfuscatedName("j")
   @Export("renderable1")
   public Renderable renderable1;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1501141884"
   )
   static final int method2149(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass0;IB)V",
      garbageValue = "51"
   )
   static void method2150(class0 var0, int var1) {
      Object[] var2 = var0.field0;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class33.method719(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field597;
         int[] var9 = var4.field591;
         byte var10 = -1;
         class38.field815 = 0;

         int var13;
         try {
            class38.field819 = new int[var4.field593];
            int var11 = 0;
            class214.field3182 = new String[var4.field589];
            int var12 = 0;

            int var14;
            String var29;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field10;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field11 != null?var0.field11.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field2;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field11 != null?var0.field11.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field6 != null?var0.field6.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field6?var0.field6.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field7;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class38.field819[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var29 = (String)var2[var13];
                  if(var29.equals("event_opbase")) {
                     var29 = var0.field9;
                  }

                  class214.field3182[var12++] = var29;
               }
            }

            var13 = 0;
            class38.field810 = var0.field5;

            label4127:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var45 = var8[var7];
               String var17;
               int var18;
               int var19;
               int var32;
               int var34;
               int var35;
               int[] var48;
               String var52;
               String[] var53;
               String var65;
               String var66;
               int var81;
               byte var114;
               if(var45 < 100) {
                  if(var45 == 0) {
                     class38.field812[var5++] = var9[var7];
                     continue;
                  }

                  if(var45 == 1) {
                     var14 = var9[var7];
                     class38.field812[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var45 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field812[var5];
                     class10.method119(var14);
                     continue;
                  }

                  if(var45 == 3) {
                     class38.chatboxSegments[var6++] = var4.field592[var7];
                     continue;
                  }

                  if(var45 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var45 == 7) {
                     var5 -= 2;
                     if(class38.field812[var5] != class38.field812[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var45 == 8) {
                     var5 -= 2;
                     if(class38.field812[var5 + 1] == class38.field812[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var45 == 9) {
                     var5 -= 2;
                     if(class38.field812[var5] < class38.field812[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var45 == 10) {
                     var5 -= 2;
                     if(class38.field812[var5] > class38.field812[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var45 == 21) {
                     if(class38.field815 == 0) {
                        return;
                     }

                     class14 var83 = class38.field816[--class38.field815];
                     var4 = var83.field207;
                     var8 = var4.field597;
                     var9 = var4.field591;
                     var7 = var83.field211;
                     class38.field819 = var83.field204;
                     class214.field3182 = var83.field210;
                     continue;
                  }

                  if(var45 == 25) {
                     var14 = var9[var7];
                     class38.field812[var5++] = class219.method3992(var14);
                     continue;
                  }

                  if(var45 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class49.method1014(var14, class38.field812[var5]);
                     continue;
                  }

                  if(var45 == 31) {
                     var5 -= 2;
                     if(class38.field812[var5] <= class38.field812[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var45 == 32) {
                     var5 -= 2;
                     if(class38.field812[var5] >= class38.field812[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var45 == 33) {
                     class38.field812[var5++] = class38.field819[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var45 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class38.field819[var10001] = class38.field812[var5];
                     continue;
                  }

                  if(var45 == 35) {
                     class38.chatboxSegments[var6++] = class214.field3182[var9[var7]];
                     continue;
                  }

                  if(var45 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class214.field3182[var10001] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var45 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var88 = class38.chatboxSegments;
                     if(var14 == 0) {
                        var52 = "";
                     } else if(var14 == 1) {
                        var17 = var88[var6];
                        if(var17 == null) {
                           var52 = "null";
                        } else {
                           var52 = var17.toString();
                        }
                     } else {
                        var81 = var6 + var14;
                        var18 = 0;

                        for(var19 = var6; var19 < var81; ++var19) {
                           var66 = var88[var19];
                           if(null == var66) {
                              var18 += 4;
                           } else {
                              var18 += var66.length();
                           }
                        }

                        StringBuilder var111 = new StringBuilder(var18);

                        for(var32 = var6; var32 < var81; ++var32) {
                           var65 = var88[var32];
                           if(null == var65) {
                              var111.append("null");
                           } else {
                              var111.append(var65);
                           }
                        }

                        var52 = var111.toString();
                     }

                     class38.chatboxSegments[var6++] = var52;
                     continue;
                  }

                  if(var45 == 38) {
                     --var5;
                     continue;
                  }

                  if(var45 == 39) {
                     --var6;
                     continue;
                  }

                  if(var45 == 40) {
                     var14 = var9[var7];
                     class23 var122 = class33.method719(var14);
                     var48 = new int[var122.field593];
                     var53 = new String[var122.field589];

                     for(var18 = 0; var18 < var122.field600; ++var18) {
                        var48[var18] = class38.field812[var18 + (var5 - var122.field600)];
                     }

                     for(var18 = 0; var18 < var122.field596; ++var18) {
                        var53[var18] = class38.chatboxSegments[var6 - var122.field596 + var18];
                     }

                     var5 -= var122.field600;
                     var6 -= var122.field596;
                     class14 var118 = new class14();
                     var118.field207 = var4;
                     var118.field211 = var7;
                     var118.field204 = class38.field819;
                     var118.field210 = class214.field3182;
                     class38.field816[++class38.field815 - 1] = var118;
                     var4 = var122;
                     var8 = var122.field597;
                     var9 = var122.field591;
                     var7 = -1;
                     class38.field819 = var48;
                     class214.field3182 = var53;
                     continue;
                  }

                  if(var45 == 42) {
                     class38.field812[var5++] = class50.chatMessages.method199(var9[var7]);
                     continue;
                  }

                  if(var45 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class50.chatMessages.method190(var10001, class38.field812[var5]);
                     continue;
                  }

                  if(var45 == 44) {
                     var14 = var9[var7] >> 16;
                     var34 = var9[var7] & '\uffff';
                     --var5;
                     var35 = class38.field812[var5];
                     if(var35 >= 0 && var35 <= 5000) {
                        class38.field811[var14] = var35;
                        var114 = -1;
                        if(var34 == 105) {
                           var114 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var35) {
                              continue label4127;
                           }

                           class38.field823[var14][var18] = var114;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var45 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var34 = class38.field812[var5];
                     if(var34 >= 0 && var34 < class38.field811[var14]) {
                        class38.field812[var5++] = class38.field823[var14][var34];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var45 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var34 = class38.field812[var5];
                     if(var34 >= 0 && var34 < class38.field811[var14]) {
                        class38.field823[var14][var34] = class38.field812[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var45 == 47) {
                     var29 = class50.chatMessages.method193(var9[var7]);
                     if(var29 == null) {
                        var29 = "null";
                     }

                     class38.chatboxSegments[var6++] = var29;
                     continue;
                  }

                  if(var45 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class50.chatMessages.method192(var10001, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var58;
               if(var9[var7] == 1) {
                  var58 = true;
               } else {
                  var58 = false;
               }

               Widget var15;
               Widget var16;
               Widget var46;
               boolean var51;
               int[] var79;
               Widget var87;
               boolean var96;
               if(var45 < 1000) {
                  if(var45 == 100) {
                     var5 -= 3;
                     var34 = class38.field812[var5];
                     var35 = class38.field812[var5 + 1];
                     var81 = class38.field812[2 + var5];
                     if(var35 == 0) {
                        throw new RuntimeException();
                     }

                     var87 = class144.method3012(var34);
                     if(null == var87.children) {
                        var87.children = new Widget[var81 + 1];
                     }

                     if(var87.children.length <= var81) {
                        Widget[] var107 = new Widget[1 + var81];

                        for(var32 = 0; var32 < var87.children.length; ++var32) {
                           var107[var32] = var87.children[var32];
                        }

                        var87.children = var107;
                     }

                     if(var81 > 0 && var87.children[var81 - 1] == null) {
                        throw new RuntimeException("" + (var81 - 1));
                     }

                     Widget var109 = new Widget();
                     var109.type = var35;
                     var109.parentId = var109.id = var87.id;
                     var109.index = var81;
                     var109.field2815 = true;
                     var87.children[var81] = var109;
                     if(var58) {
                        MessageNode.field808 = var109;
                     } else {
                        class156.field2320 = var109;
                     }

                     class166.method3253(var87);
                     continue;
                  }

                  if(var45 == 101) {
                     var15 = var58?MessageNode.field808:class156.field2320;
                     var16 = class144.method3012(var15.id);
                     var16.children[var15.index] = null;
                     class166.method3253(var16);
                     continue;
                  }

                  if(var45 == 102) {
                     --var5;
                     var15 = class144.method3012(class38.field812[var5]);
                     var15.children = null;
                     class166.method3253(var15);
                     continue;
                  }

                  if(var45 == 200) {
                     var5 -= 2;
                     var34 = class38.field812[var5];
                     var35 = class38.field812[var5 + 1];
                     var46 = class162.method3195(var34, var35);
                     if(var46 != null && var35 != -1) {
                        class38.field812[var5++] = 1;
                        if(var58) {
                           MessageNode.field808 = var46;
                        } else {
                           class156.field2320 = var46;
                        }
                        continue;
                     }

                     class38.field812[var5++] = 0;
                     continue;
                  }

                  if(var45 == 201) {
                     --var5;
                     var15 = class144.method3012(class38.field812[var5]);
                     if(var15 != null) {
                        class38.field812[var5++] = 1;
                        if(var58) {
                           MessageNode.field808 = var15;
                        } else {
                           class156.field2320 = var15;
                        }
                     } else {
                        class38.field812[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var30;
                  if((var45 < 1000 || var45 >= 1100) && (var45 < 2000 || var45 >= 2100)) {
                     if(var45 >= 1100 && var45 < 1200 || var45 >= 2100 && var45 < 2200) {
                        var35 = -1;
                        if(var45 >= 2000) {
                           var45 -= 1000;
                           --var5;
                           var35 = class38.field812[var5];
                           var15 = class144.method3012(var35);
                        } else {
                           var15 = var58?MessageNode.field808:class156.field2320;
                        }

                        if(var45 == 1100) {
                           var5 -= 2;
                           var15.itemId = class38.field812[var5];
                           if(var15.itemId > var15.scrollWidth - var15.width) {
                              var15.itemId = var15.scrollWidth - var15.width;
                           }

                           if(var15.itemId < 0) {
                              var15.itemId = 0;
                           }

                           var15.scrollY = class38.field812[var5 + 1];
                           if(var15.scrollY > var15.scrollHeight - var15.height) {
                              var15.scrollY = var15.scrollHeight - var15.height;
                           }

                           if(var15.scrollY < 0) {
                              var15.scrollY = 0;
                           }

                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1101) {
                           --var5;
                           var15.textColor = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1102) {
                           --var5;
                           var15.field2827 = class38.field812[var5] == 1;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1103) {
                           --var5;
                           var15.opacity = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1104) {
                           --var5;
                           var15.field2879 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1105) {
                           --var5;
                           var15.textureId = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1106) {
                           --var5;
                           var15.field2835 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1107) {
                           --var5;
                           var15.field2831 = class38.field812[var5] == 1;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1108) {
                           var15.modelType = 1;
                           --var5;
                           var15.modelId = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1109) {
                           var5 -= 6;
                           var15.field2903 = class38.field812[var5];
                           var15.field2848 = class38.field812[var5 + 1];
                           var15.rotationX = class38.field812[2 + var5];
                           var15.rotationZ = class38.field812[3 + var5];
                           var15.rotationY = class38.field812[4 + var5];
                           var15.field2852 = class38.field812[var5 + 5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1110) {
                           --var5;
                           var81 = class38.field812[var5];
                           if(var15.field2845 != var81) {
                              var15.field2845 = var81;
                              var15.field2920 = 0;
                              var15.field2873 = 0;
                              class166.method3253(var15);
                           }
                           continue;
                        }

                        if(var45 == 1111) {
                           --var5;
                           var15.field2855 = class38.field812[var5] == 1;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1112) {
                           --var6;
                           var17 = class38.chatboxSegments[var6];
                           if(!var17.equals(var15.text)) {
                              var15.text = var17;
                              class166.method3253(var15);
                           }
                           continue;
                        }

                        if(var45 == 1113) {
                           --var5;
                           var15.field2857 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1114) {
                           var5 -= 3;
                           var15.field2861 = class38.field812[var5];
                           var15.field2862 = class38.field812[1 + var5];
                           var15.field2860 = class38.field812[2 + var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1115) {
                           --var5;
                           var15.field2863 = class38.field812[var5] == 1;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1116) {
                           --var5;
                           var15.borderThickness = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1117) {
                           --var5;
                           var15.sprite2 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1118) {
                           --var5;
                           var15.flippedVertically = class38.field812[var5] == 1;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1119) {
                           --var5;
                           var15.flippedHorizontally = class38.field812[var5] == 1;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1120) {
                           var5 -= 2;
                           var15.scrollWidth = class38.field812[var5];
                           var15.scrollHeight = class38.field812[var5 + 1];
                           class166.method3253(var15);
                           if(var35 != -1 && var15.type == 0) {
                              Projectile.method93(Widget.widgets[var35 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var45 == 1121) {
                           class59.method1270(var15.id, var15.index);
                           Client.field361 = var15;
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1122) {
                           --var5;
                           var15.field2834 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1123) {
                           --var5;
                           var15.field2824 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1124) {
                           --var5;
                           var15.field2830 = class38.field812[var5];
                           class166.method3253(var15);
                           continue;
                        }

                        if(var45 == 1125) {
                           --var5;
                           var81 = class38.field812[var5];
                           class85[] var117 = new class85[]{class85.field1484, class85.field1492, class85.field1486, class85.field1494, class85.field1485};
                           class85 var105 = (class85)class77.method1656(var117, var81);
                           if(null != var105) {
                              var15.field2828 = var105;
                              class166.method3253(var15);
                           }
                           continue;
                        }
                     } else if((var45 < 1200 || var45 >= 1300) && (var45 < 2200 || var45 >= 2300)) {
                        if(var45 >= 1300 && var45 < 1400 || var45 >= 2300 && var45 < 2400) {
                           if(var45 >= 2000) {
                              var45 -= 1000;
                              --var5;
                              var15 = class144.method3012(class38.field812[var5]);
                           } else {
                              var15 = var58?MessageNode.field808:class156.field2320;
                           }

                           if(var45 == 1300) {
                              --var5;
                              var35 = class38.field812[var5] - 1;
                              if(var35 >= 0 && var35 <= 9) {
                                 --var6;
                                 var15.method3426(var35, class38.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var45 == 1301) {
                              var5 -= 2;
                              var35 = class38.field812[var5];
                              var81 = class38.field812[var5 + 1];
                              var15.parent = class162.method3195(var35, var81);
                              continue;
                           }

                           if(var45 == 1302) {
                              --var5;
                              var15.field2876 = class38.field812[var5] == 1;
                              continue;
                           }

                           if(var45 == 1303) {
                              --var5;
                              var15.field2897 = class38.field812[var5];
                              continue;
                           }

                           if(var45 == 1304) {
                              --var5;
                              var15.field2875 = class38.field812[var5];
                              continue;
                           }

                           if(var45 == 1305) {
                              --var6;
                              var15.name = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var45 == 1306) {
                              --var6;
                              var15.field2877 = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var45 == 1307) {
                              var15.actions = null;
                              continue;
                           }
                        } else {
                           int[] var47;
                           String var54;
                           if(var45 >= 1400 && var45 < 1500 || var45 >= 2400 && var45 < 2500) {
                              if(var45 >= 2000) {
                                 var45 -= 1000;
                                 --var5;
                                 var15 = class144.method3012(class38.field812[var5]);
                              } else {
                                 var15 = var58?MessageNode.field808:class156.field2320;
                              }

                              --var6;
                              var54 = class38.chatboxSegments[var6];
                              var47 = null;
                              if(var54.length() > 0 && var54.charAt(var54.length() - 1) == 89) {
                                 --var5;
                                 var18 = class38.field812[var5];
                                 if(var18 > 0) {
                                    for(var47 = new int[var18]; var18-- > 0; var47[var18] = class38.field812[var5]) {
                                       --var5;
                                    }
                                 }

                                 var54 = var54.substring(0, var54.length() - 1);
                              }

                              Object[] var113 = new Object[var54.length() + 1];

                              for(var19 = var113.length - 1; var19 >= 1; --var19) {
                                 if(var54.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var113[var19] = class38.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var113[var19] = new Integer(class38.field812[var5]);
                                 }
                              }

                              --var5;
                              var19 = class38.field812[var5];
                              if(var19 != -1) {
                                 var113[0] = new Integer(var19);
                              } else {
                                 var113 = null;
                              }

                              if(var45 == 1400) {
                                 var15.field2880 = var113;
                              }

                              if(var45 == 1401) {
                                 var15.field2883 = var113;
                              }

                              if(var45 == 1402) {
                                 var15.field2797 = var113;
                              }

                              if(var45 == 1403) {
                                 var15.field2884 = var113;
                              }

                              if(var45 == 1404) {
                                 var15.field2886 = var113;
                              }

                              if(var45 == 1405) {
                                 var15.field2887 = var113;
                              }

                              if(var45 == 1406) {
                                 var15.field2814 = var113;
                              }

                              if(var45 == 1407) {
                                 var15.field2891 = var113;
                                 var15.field2892 = var47;
                              }

                              if(var45 == 1408) {
                                 var15.field2926 = var113;
                              }

                              if(var45 == 1409) {
                                 var15.field2898 = var113;
                              }

                              if(var45 == 1410) {
                                 var15.field2921 = var113;
                              }

                              if(var45 == 1411) {
                                 var15.field2881 = var113;
                              }

                              if(var45 == 1412) {
                                 var15.field2885 = var113;
                              }

                              if(var45 == 1414) {
                                 var15.field2900 = var113;
                                 var15.field2894 = var47;
                              }

                              if(var45 == 1415) {
                                 var15.field2819 = var113;
                                 var15.field2896 = var47;
                              }

                              if(var45 == 1416) {
                                 var15.field2914 = var113;
                              }

                              if(var45 == 1417) {
                                 var15.field2899 = var113;
                              }

                              if(var45 == 1418) {
                                 var15.field2890 = var113;
                              }

                              if(var45 == 1419) {
                                 var15.field2901 = var113;
                              }

                              if(var45 == 1420) {
                                 var15.field2888 = var113;
                              }

                              if(var45 == 1421) {
                                 var15.field2806 = var113;
                              }

                              if(var45 == 1422) {
                                 var15.field2913 = var113;
                              }

                              if(var45 == 1423) {
                                 var15.field2905 = var113;
                              }

                              if(var45 == 1424) {
                                 var15.field2929 = var113;
                              }

                              if(var45 == 1425) {
                                 var15.field2908 = var113;
                              }

                              if(var45 == 1426) {
                                 var15.field2909 = var113;
                              }

                              if(var45 == 1427) {
                                 var15.field2787 = var113;
                              }

                              var15.field2918 = true;
                              continue;
                           }

                           if(var45 < 1600) {
                              var15 = var58?MessageNode.field808:class156.field2320;
                              if(var45 == 1500) {
                                 class38.field812[var5++] = var15.relativeX;
                                 continue;
                              }

                              if(var45 == 1501) {
                                 class38.field812[var5++] = var15.relativeY;
                                 continue;
                              }

                              if(var45 == 1502) {
                                 class38.field812[var5++] = var15.width;
                                 continue;
                              }

                              if(var45 == 1503) {
                                 class38.field812[var5++] = var15.height;
                                 continue;
                              }

                              if(var45 == 1504) {
                                 class38.field812[var5++] = var15.isHidden?1:0;
                                 continue;
                              }

                              if(var45 == 1505) {
                                 class38.field812[var5++] = var15.parentId;
                                 continue;
                              }
                           } else if(var45 < 1700) {
                              var15 = var58?MessageNode.field808:class156.field2320;
                              if(var45 == 1600) {
                                 class38.field812[var5++] = var15.itemId;
                                 continue;
                              }

                              if(var45 == 1601) {
                                 class38.field812[var5++] = var15.scrollY;
                                 continue;
                              }

                              if(var45 == 1602) {
                                 class38.chatboxSegments[var6++] = var15.text;
                                 continue;
                              }

                              if(var45 == 1603) {
                                 class38.field812[var5++] = var15.scrollWidth;
                                 continue;
                              }

                              if(var45 == 1604) {
                                 class38.field812[var5++] = var15.scrollHeight;
                                 continue;
                              }

                              if(var45 == 1605) {
                                 class38.field812[var5++] = var15.field2852;
                                 continue;
                              }

                              if(var45 == 1606) {
                                 class38.field812[var5++] = var15.rotationX;
                                 continue;
                              }

                              if(var45 == 1607) {
                                 class38.field812[var5++] = var15.rotationY;
                                 continue;
                              }

                              if(var45 == 1608) {
                                 class38.field812[var5++] = var15.rotationZ;
                                 continue;
                              }

                              if(var45 == 1609) {
                                 class38.field812[var5++] = var15.opacity;
                                 continue;
                              }

                              if(var45 == 1610) {
                                 class38.field812[var5++] = var15.field2830;
                                 continue;
                              }

                              if(var45 == 1611) {
                                 class38.field812[var5++] = var15.textColor;
                                 continue;
                              }

                              if(var45 == 1612) {
                                 class38.field812[var5++] = var15.field2824;
                                 continue;
                              }

                              if(var45 == 1613) {
                                 class38.field812[var5++] = var15.field2828.vmethod3197();
                                 continue;
                              }
                           } else if(var45 < 1800) {
                              var15 = var58?MessageNode.field808:class156.field2320;
                              if(var45 == 1700) {
                                 class38.field812[var5++] = var15.item;
                                 continue;
                              }

                              if(var45 == 1701) {
                                 if(var15.item != -1) {
                                    class38.field812[var5++] = var15.stackSize;
                                 } else {
                                    class38.field812[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var45 == 1702) {
                                 class38.field812[var5++] = var15.index;
                                 continue;
                              }
                           } else if(var45 < 1900) {
                              var15 = var58?MessageNode.field808:class156.field2320;
                              if(var45 == 1800) {
                                 var48 = class38.field812;
                                 var81 = var5++;
                                 var19 = FrameMap.method2356(var15);
                                 var18 = var19 >> 11 & 63;
                                 var48[var81] = var18;
                                 continue;
                              }

                              if(var45 == 1801) {
                                 --var5;
                                 var35 = class38.field812[var5];
                                 --var35;
                                 if(var15.actions != null && var35 < var15.actions.length && var15.actions[var35] != null) {
                                    class38.chatboxSegments[var6++] = var15.actions[var35];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var45 == 1802) {
                                 if(var15.name == null) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var15.name;
                                 }
                                 continue;
                              }
                           } else if(var45 >= 1900 && var45 < 2000 || var45 >= 2900 && var45 < 3000) {
                              if(var45 >= 2000) {
                                 var45 -= 1000;
                                 --var5;
                                 var15 = class144.method3012(class38.field812[var5]);
                              } else {
                                 var15 = var58?MessageNode.field808:class156.field2320;
                              }

                              if(var45 == 1927) {
                                 if(class38.field810 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var15.field2787) {
                                    return;
                                 }

                                 class0 var80 = new class0();
                                 var80.field11 = var15;
                                 var80.field0 = var15.field2787;
                                 var80.field5 = class38.field810 + 1;
                                 Client.field532.method3844(var0);
                                 continue;
                              }
                           } else if(var45 < 2600) {
                              --var5;
                              var15 = class144.method3012(class38.field812[var5]);
                              if(var45 == 2500) {
                                 class38.field812[var5++] = var15.relativeX;
                                 continue;
                              }

                              if(var45 == 2501) {
                                 class38.field812[var5++] = var15.relativeY;
                                 continue;
                              }

                              if(var45 == 2502) {
                                 class38.field812[var5++] = var15.width;
                                 continue;
                              }

                              if(var45 == 2503) {
                                 class38.field812[var5++] = var15.height;
                                 continue;
                              }

                              if(var45 == 2504) {
                                 class38.field812[var5++] = var15.isHidden?1:0;
                                 continue;
                              }

                              if(var45 == 2505) {
                                 class38.field812[var5++] = var15.parentId;
                                 continue;
                              }
                           } else if(var45 < 2700) {
                              --var5;
                              var15 = class144.method3012(class38.field812[var5]);
                              if(var45 == 2600) {
                                 class38.field812[var5++] = var15.itemId;
                                 continue;
                              }

                              if(var45 == 2601) {
                                 class38.field812[var5++] = var15.scrollY;
                                 continue;
                              }

                              if(var45 == 2602) {
                                 class38.chatboxSegments[var6++] = var15.text;
                                 continue;
                              }

                              if(var45 == 2603) {
                                 class38.field812[var5++] = var15.scrollWidth;
                                 continue;
                              }

                              if(var45 == 2604) {
                                 class38.field812[var5++] = var15.scrollHeight;
                                 continue;
                              }

                              if(var45 == 2605) {
                                 class38.field812[var5++] = var15.field2852;
                                 continue;
                              }

                              if(var45 == 2606) {
                                 class38.field812[var5++] = var15.rotationX;
                                 continue;
                              }

                              if(var45 == 2607) {
                                 class38.field812[var5++] = var15.rotationY;
                                 continue;
                              }

                              if(var45 == 2608) {
                                 class38.field812[var5++] = var15.rotationZ;
                                 continue;
                              }

                              if(var45 == 2609) {
                                 class38.field812[var5++] = var15.opacity;
                                 continue;
                              }

                              if(var45 == 2610) {
                                 class38.field812[var5++] = var15.field2830;
                                 continue;
                              }

                              if(var45 == 2611) {
                                 class38.field812[var5++] = var15.textColor;
                                 continue;
                              }

                              if(var45 == 2612) {
                                 class38.field812[var5++] = var15.field2824;
                                 continue;
                              }

                              if(var45 == 2613) {
                                 class38.field812[var5++] = var15.field2828.vmethod3197();
                                 continue;
                              }
                           } else if(var45 < 2800) {
                              if(var45 == 2700) {
                                 --var5;
                                 var15 = class144.method3012(class38.field812[var5]);
                                 class38.field812[var5++] = var15.item;
                                 continue;
                              }

                              if(var45 == 2701) {
                                 --var5;
                                 var15 = class144.method3012(class38.field812[var5]);
                                 if(var15.item != -1) {
                                    class38.field812[var5++] = var15.stackSize;
                                 } else {
                                    class38.field812[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var45 == 2702) {
                                 --var5;
                                 var34 = class38.field812[var5];
                                 WidgetNode var50 = (WidgetNode)Client.componentTable.method3828((long)var34);
                                 if(null != var50) {
                                    class38.field812[var5++] = 1;
                                 } else {
                                    class38.field812[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var45 == 2706) {
                                 class38.field812[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var45 < 2900) {
                              --var5;
                              var15 = class144.method3012(class38.field812[var5]);
                              if(var45 == 2800) {
                                 var48 = class38.field812;
                                 var81 = var5++;
                                 var19 = FrameMap.method2356(var15);
                                 var18 = var19 >> 11 & 63;
                                 var48[var81] = var18;
                                 continue;
                              }

                              if(var45 == 2801) {
                                 --var5;
                                 var35 = class38.field812[var5];
                                 --var35;
                                 if(var15.actions != null && var35 < var15.actions.length && null != var15.actions[var35]) {
                                    class38.chatboxSegments[var6++] = var15.actions[var35];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var45 == 2802) {
                                 if(var15.name == null) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var15.name;
                                 }
                                 continue;
                              }
                           } else {
                              int var22;
                              int var23;
                              char var24;
                              int var36;
                              int var70;
                              if(var45 < 3200) {
                                 if(var45 == 3100) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    Widget.sendGameMessage(0, "", var52);
                                    continue;
                                 }

                                 if(var45 == 3101) {
                                    var5 -= 2;
                                    class141.method2964(class165.localPlayer, class38.field812[var5], class38.field812[1 + var5]);
                                    continue;
                                 }

                                 if(var45 == 3103) {
                                    class53.method1097();
                                    continue;
                                 }

                                 boolean var55;
                                 if(var45 == 3104) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    var35 = 0;
                                    var55 = false;
                                    boolean var86 = false;
                                    var36 = 0;
                                    var22 = var52.length();
                                    var23 = 0;

                                    while(true) {
                                       if(var23 >= var22) {
                                          var51 = var86;
                                          break;
                                       }

                                       label4414: {
                                          var24 = var52.charAt(var23);
                                          if(var23 == 0) {
                                             if(var24 == 45) {
                                                var55 = true;
                                                break label4414;
                                             }

                                             if(var24 == 43) {
                                                break label4414;
                                             }
                                          }

                                          if(var24 >= 48 && var24 <= 57) {
                                             var70 = var24 - 48;
                                          } else if(var24 >= 65 && var24 <= 90) {
                                             var70 = var24 - 55;
                                          } else {
                                             if(var24 < 97 || var24 > 122) {
                                                var51 = false;
                                                break;
                                             }

                                             var70 = var24 - 87;
                                          }

                                          if(var70 >= 10) {
                                             var51 = false;
                                             break;
                                          }

                                          if(var55) {
                                             var70 = -var70;
                                          }

                                          int var25 = var36 * 10 + var70;
                                          if(var25 / 10 != var36) {
                                             var51 = false;
                                             break;
                                          }

                                          var36 = var25;
                                          var86 = true;
                                       }

                                       ++var23;
                                    }

                                    if(var51) {
                                       var35 = class143.method3003(var52);
                                    }

                                    Client.field324.method2828(13);
                                    Client.field324.method2559(var35);
                                    continue;
                                 }

                                 if(var45 == 3105) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    Client.field324.method2828(241);
                                    Client.field324.method2556(var52.length() + 1);
                                    Client.field324.method2562(var52);
                                    continue;
                                 }

                                 if(var45 == 3106) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    Client.field324.method2828(210);
                                    Client.field324.method2556(var52.length() + 1);
                                    Client.field324.method2562(var52);
                                    continue;
                                 }

                                 if(var45 == 3107) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    --var6;
                                    var54 = class38.chatboxSegments[var6];
                                    var81 = class34.field777;
                                    int[] var89 = class34.field773;
                                    var55 = false;

                                    for(var32 = 0; var32 < var81; ++var32) {
                                       Player var21 = Client.cachedPlayers[var89[var32]];
                                       if(null != var21 && var21 != class165.localPlayer && var21.name != null && var21.name.equalsIgnoreCase(var54)) {
                                          if(var34 == 1) {
                                             Client.field324.method2828(204);
                                             Client.field324.method2603(var89[var32]);
                                             Client.field324.method2556(0);
                                          } else if(var34 == 4) {
                                             Client.field324.method2828(128);
                                             Client.field324.method2638(var89[var32]);
                                             Client.field324.method2573(0);
                                          } else if(var34 == 6) {
                                             Client.field324.method2828(146);
                                             Client.field324.method2573(0);
                                             Client.field324.method2638(var89[var32]);
                                          } else if(var34 == 7) {
                                             Client.field324.method2828(115);
                                             Client.field324.method2556(0);
                                             Client.field324.method2603(var89[var32]);
                                          }

                                          var55 = true;
                                          break;
                                       }
                                    }

                                    if(!var55) {
                                       Widget.sendGameMessage(4, "", "Unable to find " + var54);
                                    }
                                    continue;
                                 }

                                 if(var45 == 3108) {
                                    var5 -= 3;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[var5 + 1];
                                    var81 = class38.field812[var5 + 2];
                                    var87 = class144.method3012(var81);
                                    NPC.method756(var87, var34, var35);
                                    continue;
                                 }

                                 if(var45 == 3109) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[var5 + 1];
                                    var46 = var58?MessageNode.field808:class156.field2320;
                                    NPC.method756(var46, var34, var35);
                                    continue;
                                 }

                                 if(var45 == 3110) {
                                    --var5;
                                    class124.field2066 = class38.field812[var5] == 1;
                                    continue;
                                 }

                                 if(var45 == 3111) {
                                    class38.field812[var5++] = class130.field2102.field138?1:0;
                                    continue;
                                 }

                                 if(var45 == 3112) {
                                    --var5;
                                    class130.field2102.field138 = class38.field812[var5] == 1;
                                    class216.method3980();
                                    continue;
                                 }

                                 if(var45 == 3113) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    --var5;
                                    var96 = class38.field812[var5] == 1;
                                    if(!var96) {
                                       class154.method3163(var52, 3, "openjs");
                                       continue;
                                    }

                                    if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                       try {
                                          Desktop.getDesktop().browse(new URI(var52));
                                          continue;
                                       } catch (Exception var43) {
                                          ;
                                       }
                                    }

                                    if(class141.field2182.startsWith("win")) {
                                       class154.method3163(var52, 0, "openjs");
                                    } else if(class141.field2182.startsWith("mac")) {
                                       class154.method3163(var52, 1, "openjs");
                                    } else {
                                       class154.method3163(var52, 2, "openjs");
                                    }
                                    continue;
                                 }

                                 if(var45 == 3115) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    Client.field324.method2828(12);
                                    Client.field324.method2638(var34);
                                    continue;
                                 }

                                 if(var45 == 3116) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    var6 -= 2;
                                    var54 = class38.chatboxSegments[var6];
                                    var17 = class38.chatboxSegments[var6 + 1];
                                    if(var54.length() <= 500 && var17.length() <= 500) {
                                       Client.field324.method2828(42);
                                       Client.field324.method2638(1 + class31.method685(var54) + class31.method685(var17));
                                       Client.field324.method2596(var34);
                                       Client.field324.method2562(var54);
                                       Client.field324.method2562(var17);
                                    }
                                    continue;
                                 }
                              } else if(var45 < 3300) {
                                 if(var45 == 3200) {
                                    var5 -= 3;
                                    class54.method1108(class38.field812[var5], class38.field812[var5 + 1], class38.field812[var5 + 2]);
                                    continue;
                                 }

                                 if(var45 == 3201) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(var34 == -1 && !Client.field519) {
                                       class186.field3008.method3735();
                                       class186.field3007 = 1;
                                       class133.field2114 = null;
                                    } else if(var34 != -1 && Client.field541 != var34 && Client.field433 != 0 && !Client.field519) {
                                       class162.method3196(2, Client.field423, var34, 0, Client.field433, false);
                                    }

                                    Client.field541 = var34;
                                    continue;
                                 }

                                 if(var45 == 3202) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5];
                                    int var10000 = class38.field812[1 + var5];
                                    if(Client.field433 != 0 && var34 != -1) {
                                       class140.method2961(class9.field151, var34, 0, Client.field433, false);
                                       Client.field519 = true;
                                    }
                                    continue;
                                 }
                              } else if(var45 < 3400) {
                                 if(var45 == 3300) {
                                    class38.field812[var5++] = Client.gameCycle;
                                    continue;
                                 }

                                 XItemContainer var20;
                                 if(var45 == 3301) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[var5 + 1];
                                    var47 = class38.field812;
                                    var18 = var5++;
                                    var20 = (XItemContainer)XItemContainer.itemContainers.method3828((long)var34);
                                    if(var20 == null) {
                                       var19 = -1;
                                    } else if(var35 >= 0 && var35 < var20.itemIds.length) {
                                       var19 = var20.itemIds[var35];
                                    } else {
                                       var19 = -1;
                                    }

                                    var47[var18] = var19;
                                    continue;
                                 }

                                 if(var45 == 3302) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[1 + var5];
                                    class38.field812[var5++] = class225.method4042(var34, var35);
                                    continue;
                                 }

                                 if(var45 == 3303) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[1 + var5];
                                    class38.field812[var5++] = class79.method1716(var34, var35);
                                    continue;
                                 }

                                 if(var45 == 3304) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = class155.method3176(var34).field1163;
                                    continue;
                                 }

                                 if(var45 == 3305) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = Client.boostedSkillLevels[var34];
                                    continue;
                                 }

                                 if(var45 == 3306) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = Client.realSkillLevels[var34];
                                    continue;
                                 }

                                 if(var45 == 3307) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = Client.skillExperiences[var34];
                                    continue;
                                 }

                                 if(var45 == 3308) {
                                    var34 = class145.plane;
                                    var35 = class47.baseX + (class165.localPlayer.x >> 7);
                                    var81 = (class165.localPlayer.y >> 7) + class21.baseY;
                                    class38.field812[var5++] = var81 + (var35 << 14) + (var34 << 28);
                                    continue;
                                 }

                                 if(var45 == 3309) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = var34 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var45 == 3310) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = var34 >> 28;
                                    continue;
                                 }

                                 if(var45 == 3311) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    class38.field812[var5++] = var34 & 16383;
                                    continue;
                                 }

                                 if(var45 == 3312) {
                                    class38.field812[var5++] = Client.isMembers?1:0;
                                    continue;
                                 }

                                 if(var45 == 3313) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5] + '耀';
                                    var35 = class38.field812[var5 + 1];
                                    var47 = class38.field812;
                                    var18 = var5++;
                                    var20 = (XItemContainer)XItemContainer.itemContainers.method3828((long)var34);
                                    if(null == var20) {
                                       var19 = -1;
                                    } else if(var35 >= 0 && var35 < var20.itemIds.length) {
                                       var19 = var20.itemIds[var35];
                                    } else {
                                       var19 = -1;
                                    }

                                    var47[var18] = var19;
                                    continue;
                                 }

                                 if(var45 == 3314) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5] + '耀';
                                    var35 = class38.field812[1 + var5];
                                    class38.field812[var5++] = class225.method4042(var34, var35);
                                    continue;
                                 }

                                 if(var45 == 3315) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5] + '耀';
                                    var35 = class38.field812[var5 + 1];
                                    class38.field812[var5++] = class79.method1716(var34, var35);
                                    continue;
                                 }

                                 if(var45 == 3316) {
                                    if(Client.field447 >= 2) {
                                       class38.field812[var5++] = Client.field447;
                                    } else {
                                       class38.field812[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var45 == 3317) {
                                    class38.field812[var5++] = Client.field304;
                                    continue;
                                 }

                                 if(var45 == 3318) {
                                    class38.field812[var5++] = Client.world;
                                    continue;
                                 }

                                 if(var45 == 3321) {
                                    class38.field812[var5++] = Client.energy;
                                    continue;
                                 }

                                 if(var45 == 3322) {
                                    class38.field812[var5++] = Client.weight;
                                    continue;
                                 }

                                 if(var45 == 3323) {
                                    if(Client.field449) {
                                       class38.field812[var5++] = 1;
                                    } else {
                                       class38.field812[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var45 == 3324) {
                                    class38.field812[var5++] = Client.flags;
                                    continue;
                                 }
                              } else if(var45 < 3500) {
                                 if(var45 == 3400) {
                                    var5 -= 2;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[var5 + 1];
                                    class52 var90 = (class52)class52.field1138.get((long)var34);
                                    class52 var49;
                                    if(null != var90) {
                                       var49 = var90;
                                    } else {
                                       byte[] var84 = class52.field1142.method3305(8, var34);
                                       var90 = new class52();
                                       if(null != var84) {
                                          var90.method1077(new Buffer(var84));
                                       }

                                       class52.field1138.put(var90, (long)var34);
                                       var49 = var90;
                                    }

                                    var90 = var49;
                                    if(var49.field1140 != 115) {
                                       ;
                                    }

                                    for(var19 = 0; var19 < var90.field1144; ++var19) {
                                       if(var90.field1150[var19] == var35) {
                                          class38.chatboxSegments[var6++] = var90.field1146[var19];
                                          var90 = null;
                                          break;
                                       }
                                    }

                                    if(var90 != null) {
                                       class38.chatboxSegments[var6++] = var90.field1145;
                                    }
                                    continue;
                                 }

                                 if(var45 == 3408) {
                                    var5 -= 4;
                                    var34 = class38.field812[var5];
                                    var35 = class38.field812[var5 + 1];
                                    var81 = class38.field812[2 + var5];
                                    var18 = class38.field812[3 + var5];
                                    class52 var59 = (class52)class52.field1138.get((long)var81);
                                    class52 var31;
                                    if(var59 != null) {
                                       var31 = var59;
                                    } else {
                                       byte[] var61 = class52.field1142.method3305(8, var81);
                                       var59 = new class52();
                                       if(null != var61) {
                                          var59.method1077(new Buffer(var61));
                                       }

                                       class52.field1138.put(var59, (long)var81);
                                       var31 = var59;
                                    }

                                    var59 = var31;
                                    if(var34 == var31.field1139 && var31.field1140 == var35) {
                                       for(var36 = 0; var36 < var59.field1144; ++var36) {
                                          if(var18 == var59.field1150[var36]) {
                                             if(var35 == 115) {
                                                class38.chatboxSegments[var6++] = var59.field1146[var36];
                                             } else {
                                                class38.field812[var5++] = var59.field1137[var36];
                                             }

                                             var59 = null;
                                             break;
                                          }
                                       }

                                       if(var59 != null) {
                                          if(var35 == 115) {
                                             class38.chatboxSegments[var6++] = var59.field1145;
                                          } else {
                                             class38.field812[var5++] = var59.field1143;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var35 == 115) {
                                       class38.chatboxSegments[var6++] = "null";
                                    } else {
                                       class38.field812[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else if(var45 < 3700) {
                                 if(var45 == 3600) {
                                    if(Client.field534 == 0) {
                                       class38.field812[var5++] = -2;
                                    } else if(Client.field534 == 1) {
                                       class38.field812[var5++] = -1;
                                    } else {
                                       class38.field812[var5++] = Client.friendCount;
                                    }
                                    continue;
                                 }

                                 if(var45 == 3601) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(Client.field534 == 2 && var34 < Client.friendCount) {
                                       class38.chatboxSegments[var6++] = Client.friends[var34].name;
                                       class38.chatboxSegments[var6++] = Client.friends[var34].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var45 == 3602) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(Client.field534 == 2 && var34 < Client.friendCount) {
                                       class38.field812[var5++] = Client.friends[var34].world;
                                       continue;
                                    }

                                    class38.field812[var5++] = 0;
                                    continue;
                                 }

                                 if(var45 == 3603) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(Client.field534 == 2 && var34 < Client.friendCount) {
                                       class38.field812[var5++] = Client.friends[var34].rank;
                                       continue;
                                    }

                                    class38.field812[var5++] = 0;
                                    continue;
                                 }

                                 if(var45 == 3604) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    --var5;
                                    var35 = class38.field812[var5];
                                    Client.field324.method2828(124);
                                    Client.field324.method2556(class31.method685(var52) + 1);
                                    Client.field324.method2562(var52);
                                    Client.field324.method2596(var35);
                                    continue;
                                 }

                                 if(var45 == 3605) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    class32.method688(var52);
                                    continue;
                                 }

                                 String var85;
                                 Friend var98;
                                 if(var45 == 3606) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    if(var52 == null) {
                                       continue;
                                    }

                                    var54 = class112.method2486(var52, class43.field996);
                                    if(null == var54) {
                                       continue;
                                    }

                                    var81 = 0;

                                    while(true) {
                                       if(var81 >= Client.friendCount) {
                                          continue label4127;
                                       }

                                       var98 = Client.friends[var81];
                                       var85 = var98.name;
                                       var66 = class112.method2486(var85, class43.field996);
                                       if(class8.method110(var52, var54, var85, var66)) {
                                          --Client.friendCount;

                                          for(var36 = var81; var36 < Client.friendCount; ++var36) {
                                             Client.friends[var36] = Client.friends[var36 + 1];
                                          }

                                          Client.field359 = Client.field465;
                                          Client.field324.method2828(236);
                                          Client.field324.method2556(class31.method685(var52));
                                          Client.field324.method2562(var52);
                                          continue label4127;
                                       }

                                       ++var81;
                                    }
                                 }

                                 Ignore var97;
                                 if(var45 == 3607) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    if(null == var52) {
                                       continue;
                                    }

                                    if((Client.ignoreCount < 100 || Client.field521 == 1) && Client.ignoreCount < 400) {
                                       var54 = class112.method2486(var52, class43.field996);
                                       if(null == var54) {
                                          continue;
                                       }

                                       for(var81 = 0; var81 < Client.ignoreCount; ++var81) {
                                          var97 = Client.ignores[var81];
                                          var85 = class112.method2486(var97.name, class43.field996);
                                          if(var85 != null && var85.equals(var54)) {
                                             Widget.sendGameMessage(31, "", var52 + " is already on your ignore list");
                                             continue label4127;
                                          }

                                          if(var97.previousName != null) {
                                             var66 = class112.method2486(var97.previousName, class43.field996);
                                             if(var66 != null && var66.equals(var54)) {
                                                Widget.sendGameMessage(31, "", var52 + " is already on your ignore list");
                                                continue label4127;
                                             }
                                          }
                                       }

                                       for(var81 = 0; var81 < Client.friendCount; ++var81) {
                                          var98 = Client.friends[var81];
                                          var85 = class112.method2486(var98.name, class43.field996);
                                          if(null != var85 && var85.equals(var54)) {
                                             Widget.sendGameMessage(31, "", "Please remove " + var52 + " from your friend list first");
                                             continue label4127;
                                          }

                                          if(null != var98.previousName) {
                                             var66 = class112.method2486(var98.previousName, class43.field996);
                                             if(null != var66 && var66.equals(var54)) {
                                                Widget.sendGameMessage(31, "", "Please remove " + var52 + " from your friend list first");
                                                continue label4127;
                                             }
                                          }
                                       }

                                       if(class112.method2486(class165.localPlayer.name, class43.field996).equals(var54)) {
                                          Widget.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                       } else {
                                          Client.field324.method2828(60);
                                          Client.field324.method2556(class31.method685(var52));
                                          Client.field324.method2562(var52);
                                       }
                                       continue;
                                    }

                                    Widget.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                    continue;
                                 }

                                 if(var45 == 3608) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    if(null == var52) {
                                       continue;
                                    }

                                    var54 = class112.method2486(var52, class43.field996);
                                    if(null == var54) {
                                       continue;
                                    }

                                    var81 = 0;

                                    while(true) {
                                       if(var81 >= Client.ignoreCount) {
                                          continue label4127;
                                       }

                                       var97 = Client.ignores[var81];
                                       var85 = var97.name;
                                       var66 = class112.method2486(var85, class43.field996);
                                       if(class8.method110(var52, var54, var85, var66)) {
                                          --Client.ignoreCount;

                                          for(var36 = var81; var36 < Client.ignoreCount; ++var36) {
                                             Client.ignores[var36] = Client.ignores[var36 + 1];
                                          }

                                          Client.field359 = Client.field465;
                                          Client.field324.method2828(37);
                                          Client.field324.method2556(class31.method685(var52));
                                          Client.field324.method2562(var52);
                                          continue label4127;
                                       }

                                       ++var81;
                                    }
                                 }

                                 if(var45 == 3609) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    class155[] var57 = World.method657();

                                    for(var81 = 0; var81 < var57.length; ++var81) {
                                       class155 var94 = var57[var81];
                                       if(var94.field2302 != -1 && var52.startsWith(class154.method3165(var94.field2302))) {
                                          var52 = var52.substring(6 + Integer.toString(var94.field2302).length());
                                          break;
                                       }
                                    }

                                    class38.field812[var5++] = class0.method1(var52, false)?1:0;
                                    continue;
                                 }

                                 String[] var60;
                                 String var92;
                                 if(var45 == 3611) {
                                    if(null != Client.field455) {
                                       var60 = class38.chatboxSegments;
                                       var35 = var6++;
                                       var92 = Client.field455;
                                       var85 = NPCComposition.method831(class215.method3972(var92));
                                       if(var85 == null) {
                                          var85 = "";
                                       }

                                       var60[var35] = var85;
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var45 == 3612) {
                                    if(Client.field455 != null) {
                                       class38.field812[var5++] = class16.field235;
                                    } else {
                                       class38.field812[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var45 == 3613) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(Client.field455 != null && var34 < class16.field235) {
                                       class38.chatboxSegments[var6++] = class114.clanMembers[var34].username;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var45 == 3614) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(null != Client.field455 && var34 < class16.field235) {
                                       class38.field812[var5++] = class114.clanMembers[var34].world;
                                       continue;
                                    }

                                    class38.field812[var5++] = 0;
                                    continue;
                                 }

                                 if(var45 == 3615) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(Client.field455 != null && var34 < class16.field235) {
                                       class38.field812[var5++] = class114.clanMembers[var34].rank;
                                       continue;
                                    }

                                    class38.field812[var5++] = 0;
                                    continue;
                                 }

                                 if(var45 == 3616) {
                                    class38.field812[var5++] = class134.field2116;
                                    continue;
                                 }

                                 if(var45 == 3617) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    class12.method139(var52);
                                    continue;
                                 }

                                 if(var45 == 3618) {
                                    class38.field812[var5++] = class43.field991;
                                    continue;
                                 }

                                 if(var45 == 3619) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    if(!var52.equals("")) {
                                       Client.field324.method2828(21);
                                       Client.field324.method2556(class31.method685(var52));
                                       Client.field324.method2562(var52);
                                    }
                                    continue;
                                 }

                                 if(var45 == 3620) {
                                    Sequence.method896();
                                    continue;
                                 }

                                 if(var45 == 3621) {
                                    if(Client.field534 == 0) {
                                       class38.field812[var5++] = -1;
                                    } else {
                                       class38.field812[var5++] = Client.ignoreCount;
                                    }
                                    continue;
                                 }

                                 if(var45 == 3622) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(Client.field534 != 0 && var34 < Client.ignoreCount) {
                                       class38.chatboxSegments[var6++] = Client.ignores[var34].name;
                                       class38.chatboxSegments[var6++] = Client.ignores[var34].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var45 == 3623) {
                                    --var6;
                                    var52 = class38.chatboxSegments[var6];
                                    if(var52.startsWith(class154.method3165(0)) || var52.startsWith(class154.method3165(1))) {
                                       var52 = var52.substring(7);
                                    }

                                    class38.field812[var5++] = class187.method3736(var52)?1:0;
                                    continue;
                                 }

                                 if(var45 == 3624) {
                                    --var5;
                                    var34 = class38.field812[var5];
                                    if(null != class114.clanMembers && var34 < class16.field235 && class114.clanMembers[var34].username.equalsIgnoreCase(class165.localPlayer.name)) {
                                       class38.field812[var5++] = 1;
                                       continue;
                                    }

                                    class38.field812[var5++] = 0;
                                    continue;
                                 }

                                 if(var45 == 3625) {
                                    if(Client.field508 != null) {
                                       var60 = class38.chatboxSegments;
                                       var35 = var6++;
                                       var92 = Client.field508;
                                       var85 = NPCComposition.method831(class215.method3972(var92));
                                       if(null == var85) {
                                          var85 = "";
                                       }

                                       var60[var35] = var85;
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else {
                                 long var93;
                                 if(var45 < 4000) {
                                    if(var45 == 3903) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = Client.grandExchangeOffers[var34].method4018();
                                       continue;
                                    }

                                    if(var45 == 3904) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = Client.grandExchangeOffers[var34].itemId;
                                       continue;
                                    }

                                    if(var45 == 3905) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = Client.grandExchangeOffers[var34].price;
                                       continue;
                                    }

                                    if(var45 == 3906) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = Client.grandExchangeOffers[var34].totalQuantity;
                                       continue;
                                    }

                                    if(var45 == 3907) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = Client.grandExchangeOffers[var34].quantitySold;
                                       continue;
                                    }

                                    if(var45 == 3908) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = Client.grandExchangeOffers[var34].spent;
                                       continue;
                                    }

                                    if(var45 == 3910) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var35 = Client.grandExchangeOffers[var34].method4029();
                                       class38.field812[var5++] = var35 == 0?1:0;
                                       continue;
                                    }

                                    if(var45 == 3911) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var35 = Client.grandExchangeOffers[var34].method4029();
                                       class38.field812[var5++] = var35 == 2?1:0;
                                       continue;
                                    }

                                    if(var45 == 3912) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var35 = Client.grandExchangeOffers[var34].method4029();
                                       class38.field812[var5++] = var35 == 5?1:0;
                                       continue;
                                    }

                                    if(var45 == 3913) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var35 = Client.grandExchangeOffers[var34].method4029();
                                       class38.field812[var5++] = var35 == 1?1:0;
                                       continue;
                                    }

                                    boolean var116;
                                    if(var45 == 3914) {
                                       --var5;
                                       var116 = class38.field812[var5] == 1;
                                       if(null != Tile.field1816) {
                                          Tile.field1816.method4034(class224.field3230, var116);
                                       }
                                       continue;
                                    }

                                    if(var45 == 3915) {
                                       --var5;
                                       var116 = class38.field812[var5] == 1;
                                       if(Tile.field1816 != null) {
                                          Tile.field1816.method4034(class224.field3229, var116);
                                       }
                                       continue;
                                    }

                                    if(var45 == 3916) {
                                       var5 -= 2;
                                       var116 = class38.field812[var5] == 1;
                                       var96 = class38.field812[var5 + 1] == 1;
                                       if(null != Tile.field1816) {
                                          Tile.field1816.method4034(new class22(var96), var116);
                                       }
                                       continue;
                                    }

                                    if(var45 == 3917) {
                                       --var5;
                                       var116 = class38.field812[var5] == 1;
                                       if(null != Tile.field1816) {
                                          Tile.field1816.method4034(class224.field3228, var116);
                                       }
                                       continue;
                                    }

                                    if(var45 == 3918) {
                                       --var5;
                                       var116 = class38.field812[var5] == 1;
                                       if(null != Tile.field1816) {
                                          Tile.field1816.method4034(class224.field3231, var116);
                                       }
                                       continue;
                                    }

                                    if(var45 == 3919) {
                                       class38.field812[var5++] = null == Tile.field1816?0:Tile.field1816.field3227.size();
                                       continue;
                                    }

                                    class217 var63;
                                    if(var45 == 3920) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       class38.field812[var5++] = var63.field3197;
                                       continue;
                                    }

                                    if(var45 == 3921) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       class38.chatboxSegments[var6++] = var63.method3984();
                                       continue;
                                    }

                                    if(var45 == 3922) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       class38.chatboxSegments[var6++] = var63.method3983();
                                       continue;
                                    }

                                    if(var45 == 3923) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       var93 = class169.method3276() - class184.field2990 - var63.field3199;
                                       var19 = (int)(var93 / 3600000L);
                                       var32 = (int)((var93 - (long)(var19 * 3600000)) / 60000L);
                                       var36 = (int)((var93 - (long)(var19 * 3600000) - (long)(var32 * '\uea60')) / 1000L);
                                       String var37 = var19 + ":" + var32 / 10 + var32 % 10 + ":" + var36 / 10 + var36 % 10;
                                       class38.chatboxSegments[var6++] = var37;
                                       continue;
                                    }

                                    if(var45 == 3924) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       class38.field812[var5++] = var63.field3198.totalQuantity;
                                       continue;
                                    }

                                    if(var45 == 3925) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       class38.field812[var5++] = var63.field3198.price;
                                       continue;
                                    }

                                    if(var45 == 3926) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       var63 = (class217)Tile.field1816.field3227.get(var34);
                                       class38.field812[var5++] = var63.field3198.itemId;
                                       continue;
                                    }
                                 } else if(var45 < 4100) {
                                    if(var45 == 4000) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var34 + var35;
                                       continue;
                                    }

                                    if(var45 == 4001) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var34 - var35;
                                       continue;
                                    }

                                    if(var45 == 4002) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var35 * var34;
                                       continue;
                                    }

                                    if(var45 == 4003) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var34 / var35;
                                       continue;
                                    }

                                    if(var45 == 4004) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = (int)(Math.random() * (double)var34);
                                       continue;
                                    }

                                    if(var45 == 4005) {
                                       --var5;
                                       var34 = class38.field812[var5];
                                       class38.field812[var5++] = (int)(Math.random() * (double)(1 + var34));
                                       continue;
                                    }

                                    if(var45 == 4006) {
                                       var5 -= 5;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[1 + var5];
                                       var81 = class38.field812[2 + var5];
                                       var18 = class38.field812[var5 + 3];
                                       var19 = class38.field812[4 + var5];
                                       class38.field812[var5++] = var34 + (var35 - var34) * (var19 - var81) / (var18 - var81);
                                       continue;
                                    }

                                    if(var45 == 4007) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var35 * var34 / 100 + var34;
                                       continue;
                                    }

                                    if(var45 == 4008) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var34 | 1 << var35;
                                       continue;
                                    }

                                    if(var45 == 4009) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[1 + var5];
                                       class38.field812[var5++] = var34 & -1 - (1 << var35);
                                       continue;
                                    }

                                    if(var45 == 4010) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[1 + var5];
                                       class38.field812[var5++] = (var34 & 1 << var35) != 0?1:0;
                                       continue;
                                    }

                                    if(var45 == 4011) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[1 + var5];
                                       class38.field812[var5++] = var34 % var35;
                                       continue;
                                    }

                                    if(var45 == 4012) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[1 + var5];
                                       if(var34 == 0) {
                                          class38.field812[var5++] = 0;
                                       } else {
                                          class38.field812[var5++] = (int)Math.pow((double)var34, (double)var35);
                                       }
                                       continue;
                                    }

                                    if(var45 == 4013) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[1 + var5];
                                       if(var34 == 0) {
                                          class38.field812[var5++] = 0;
                                       } else if(var35 == 0) {
                                          class38.field812[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class38.field812[var5++] = (int)Math.pow((double)var34, 1.0D / (double)var35);
                                       }
                                       continue;
                                    }

                                    if(var45 == 4014) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var34 & var35;
                                       continue;
                                    }

                                    if(var45 == 4015) {
                                       var5 -= 2;
                                       var34 = class38.field812[var5];
                                       var35 = class38.field812[var5 + 1];
                                       class38.field812[var5++] = var34 | var35;
                                       continue;
                                    }

                                    if(var45 == 4018) {
                                       var5 -= 3;
                                       long var120 = (long)class38.field812[var5];
                                       var93 = (long)class38.field812[var5 + 1];
                                       long var72 = (long)class38.field812[var5 + 2];
                                       class38.field812[var5++] = (int)(var120 * var72 / var93);
                                       continue;
                                    }
                                 } else {
                                    int var26;
                                    if(var45 < 4200) {
                                       if(var45 == 4100) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          --var5;
                                          var35 = class38.field812[var5];
                                          class38.chatboxSegments[var6++] = var52 + var35;
                                          continue;
                                       }

                                       if(var45 == 4101) {
                                          var6 -= 2;
                                          var52 = class38.chatboxSegments[var6];
                                          var54 = class38.chatboxSegments[var6 + 1];
                                          class38.chatboxSegments[var6++] = var52 + var54;
                                          continue;
                                       }

                                       if(var45 == 4102) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          --var5;
                                          var35 = class38.field812[var5];
                                          var53 = class38.chatboxSegments;
                                          var18 = var6++;
                                          if(var35 < 0) {
                                             var66 = Integer.toString(var35);
                                          } else {
                                             var22 = var35;
                                             if(var35 < 0) {
                                                var65 = Integer.toString(var35, 10);
                                             } else {
                                                var23 = 2;

                                                for(var70 = var35 / 10; var70 != 0; ++var23) {
                                                   var70 /= 10;
                                                }

                                                char[] var38 = new char[var23];
                                                var38[0] = 43;

                                                for(var26 = var23 - 1; var26 > 0; --var26) {
                                                   int var27 = var22;
                                                   var22 /= 10;
                                                   int var28 = var27 - 10 * var22;
                                                   if(var28 >= 10) {
                                                      var38[var26] = (char)(87 + var28);
                                                   } else {
                                                      var38[var26] = (char)(48 + var28);
                                                   }
                                                }

                                                var65 = new String(var38);
                                             }

                                             var66 = var65;
                                          }

                                          var53[var18] = var52 + var66;
                                          continue;
                                       }

                                       if(var45 == 4103) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          class38.chatboxSegments[var6++] = var52.toLowerCase();
                                          continue;
                                       }

                                       if(var45 == 4104) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          long var119 = (11745L + (long)var34) * 86400000L;
                                          class38.field817.setTime(new Date(var119));
                                          var18 = class38.field817.get(5);
                                          var19 = class38.field817.get(2);
                                          var32 = class38.field817.get(1);
                                          class38.chatboxSegments[var6++] = var18 + "-" + class38.field818[var19] + "-" + var32;
                                          continue;
                                       }

                                       if(var45 == 4105) {
                                          var6 -= 2;
                                          var52 = class38.chatboxSegments[var6];
                                          var54 = class38.chatboxSegments[1 + var6];
                                          if(null != class165.localPlayer.composition && class165.localPlayer.composition.isFemale) {
                                             class38.chatboxSegments[var6++] = var54;
                                             continue;
                                          }

                                          class38.chatboxSegments[var6++] = var52;
                                          continue;
                                       }

                                       if(var45 == 4106) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          class38.chatboxSegments[var6++] = Integer.toString(var34);
                                          continue;
                                       }

                                       if(var45 == 4107) {
                                          var6 -= 2;
                                          var79 = class38.field812;
                                          var35 = var5++;
                                          var18 = class154.method3162(class38.chatboxSegments[var6], class38.chatboxSegments[1 + var6], Client.field283);
                                          if(var18 > 0) {
                                             var114 = 1;
                                          } else if(var18 < 0) {
                                             var114 = -1;
                                          } else {
                                             var114 = 0;
                                          }

                                          var79[var35] = var114;
                                          continue;
                                       }

                                       class227 var91;
                                       byte[] var103;
                                       if(var45 == 4108) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          var5 -= 2;
                                          var35 = class38.field812[var5];
                                          var81 = class38.field812[var5 + 1];
                                          var103 = MessageNode.field802.method3305(var81, 0);
                                          var91 = new class227(var103);
                                          class38.field812[var5++] = var91.method4050(var52, var35);
                                          continue;
                                       }

                                       if(var45 == 4109) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          var5 -= 2;
                                          var35 = class38.field812[var5];
                                          var81 = class38.field812[var5 + 1];
                                          var103 = MessageNode.field802.method3305(var81, 0);
                                          var91 = new class227(var103);
                                          class38.field812[var5++] = var91.method4049(var52, var35);
                                          continue;
                                       }

                                       if(var45 == 4110) {
                                          var6 -= 2;
                                          var52 = class38.chatboxSegments[var6];
                                          var54 = class38.chatboxSegments[1 + var6];
                                          --var5;
                                          if(class38.field812[var5] == 1) {
                                             class38.chatboxSegments[var6++] = var52;
                                          } else {
                                             class38.chatboxSegments[var6++] = var54;
                                          }
                                          continue;
                                       }

                                       if(var45 == 4111) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          class38.chatboxSegments[var6++] = class226.method4060(var52);
                                          continue;
                                       }

                                       if(var45 == 4112) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          --var5;
                                          var35 = class38.field812[var5];
                                          class38.chatboxSegments[var6++] = var52 + (char)var35;
                                          continue;
                                       }

                                       if(var45 == 4113) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          class38.field812[var5++] = class48.method1003((char)var34)?1:0;
                                          continue;
                                       }

                                       char var73;
                                       if(var45 == 4114) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var48 = class38.field812;
                                          var81 = var5++;
                                          var73 = (char)var34;
                                          var51 = var73 >= 48 && var73 <= 57 || var73 >= 65 && var73 <= 90 || var73 >= 97 && var73 <= 122;
                                          var48[var81] = var51?1:0;
                                          continue;
                                       }

                                       if(var45 == 4115) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var48 = class38.field812;
                                          var81 = var5++;
                                          var73 = (char)var34;
                                          var51 = var73 >= 65 && var73 <= 90 || var73 >= 97 && var73 <= 122;
                                          var48[var81] = var51?1:0;
                                          continue;
                                       }

                                       if(var45 == 4116) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var48 = class38.field812;
                                          var81 = var5++;
                                          var73 = (char)var34;
                                          var51 = var73 >= 48 && var73 <= 57;
                                          var48[var81] = var51?1:0;
                                          continue;
                                       }

                                       if(var45 == 4117) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          if(var52 != null) {
                                             class38.field812[var5++] = var52.length();
                                          } else {
                                             class38.field812[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var45 == 4118) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          var5 -= 2;
                                          var35 = class38.field812[var5];
                                          var81 = class38.field812[1 + var5];
                                          class38.chatboxSegments[var6++] = var52.substring(var35, var81);
                                          continue;
                                       }

                                       if(var45 == 4119) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          StringBuilder var69 = new StringBuilder(var52.length());
                                          var30 = false;

                                          for(var18 = 0; var18 < var52.length(); ++var18) {
                                             var73 = var52.charAt(var18);
                                             if(var73 == 60) {
                                                var30 = true;
                                             } else if(var73 == 62) {
                                                var30 = false;
                                             } else if(!var30) {
                                                var69.append(var73);
                                             }
                                          }

                                          class38.chatboxSegments[var6++] = var69.toString();
                                          continue;
                                       }

                                       if(var45 == 4120) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          --var5;
                                          var35 = class38.field812[var5];
                                          class38.field812[var5++] = var52.indexOf(var35);
                                          continue;
                                       }

                                       if(var45 == 4121) {
                                          var6 -= 2;
                                          var52 = class38.chatboxSegments[var6];
                                          var54 = class38.chatboxSegments[1 + var6];
                                          --var5;
                                          var81 = class38.field812[var5];
                                          class38.field812[var5++] = var52.indexOf(var54, var81);
                                          continue;
                                       }
                                    } else if(var45 < 4300) {
                                       if(var45 == 4200) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          class38.chatboxSegments[var6++] = class22.getItemDefinition(var34).name;
                                          continue;
                                       }

                                       ItemComposition var56;
                                       if(var45 == 4201) {
                                          var5 -= 2;
                                          var34 = class38.field812[var5];
                                          var35 = class38.field812[1 + var5];
                                          var56 = class22.getItemDefinition(var34);
                                          if(var35 >= 1 && var35 <= 5 && var56.groundActions[var35 - 1] != null) {
                                             class38.chatboxSegments[var6++] = var56.groundActions[var35 - 1];
                                             continue;
                                          }

                                          class38.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var45 == 4202) {
                                          var5 -= 2;
                                          var34 = class38.field812[var5];
                                          var35 = class38.field812[var5 + 1];
                                          var56 = class22.getItemDefinition(var34);
                                          if(var35 >= 1 && var35 <= 5 && null != var56.inventoryActions[var35 - 1]) {
                                             class38.chatboxSegments[var6++] = var56.inventoryActions[var35 - 1];
                                             continue;
                                          }

                                          class38.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var45 == 4203) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          class38.field812[var5++] = class22.getItemDefinition(var34).price;
                                          continue;
                                       }

                                       if(var45 == 4204) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          class38.field812[var5++] = class22.getItemDefinition(var34).isStackable == 1?1:0;
                                          continue;
                                       }

                                       ItemComposition var74;
                                       if(var45 == 4205) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var74 = class22.getItemDefinition(var34);
                                          if(var74.field1177 == -1 && var74.note >= 0) {
                                             class38.field812[var5++] = var74.note;
                                             continue;
                                          }

                                          class38.field812[var5++] = var34;
                                          continue;
                                       }

                                       if(var45 == 4206) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var74 = class22.getItemDefinition(var34);
                                          if(var74.field1177 >= 0 && var74.note >= 0) {
                                             class38.field812[var5++] = var74.note;
                                             continue;
                                          }

                                          class38.field812[var5++] = var34;
                                          continue;
                                       }

                                       if(var45 == 4207) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          class38.field812[var5++] = class22.getItemDefinition(var34).isMembers?1:0;
                                          continue;
                                       }

                                       if(var45 == 4208) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var74 = class22.getItemDefinition(var34);
                                          if(var74.field1196 == -1 && var74.field1216 >= 0) {
                                             class38.field812[var5++] = var74.field1216;
                                             continue;
                                          }

                                          class38.field812[var5++] = var34;
                                          continue;
                                       }

                                       if(var45 == 4209) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var74 = class22.getItemDefinition(var34);
                                          if(var74.field1196 >= 0 && var74.field1216 >= 0) {
                                             class38.field812[var5++] = var74.field1216;
                                             continue;
                                          }

                                          class38.field812[var5++] = var34;
                                          continue;
                                       }

                                       if(var45 == 4210) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          --var5;
                                          var35 = class38.field812[var5];
                                          var51 = var35 == 1;
                                          var17 = var52.toLowerCase();
                                          short[] var95 = new short[16];
                                          var32 = 0;
                                          var36 = 0;

                                          while(true) {
                                             if(var36 >= ItemComposition.field1167) {
                                                class11.field162 = var95;
                                                class13.field194 = 0;
                                                class93.field1619 = var32;
                                                String[] var67 = new String[class93.field1619];

                                                for(var22 = 0; var22 < class93.field1619; ++var22) {
                                                   var67[var22] = class22.getItemDefinition(var95[var22]).name;
                                                }

                                                short[] var101 = class11.field162;
                                                class32.method691(var67, var101, 0, var67.length - 1);
                                                break;
                                             }

                                             ItemComposition var100 = class22.getItemDefinition(var36);
                                             if((!var51 || var100.field1170) && var100.field1177 == -1 && var100.name.toLowerCase().indexOf(var17) != -1) {
                                                if(var32 >= 250) {
                                                   class93.field1619 = -1;
                                                   class11.field162 = null;
                                                   break;
                                                }

                                                if(var32 >= var95.length) {
                                                   short[] var39 = new short[2 * var95.length];

                                                   for(var70 = 0; var70 < var32; ++var70) {
                                                      var39[var70] = var95[var70];
                                                   }

                                                   var95 = var39;
                                                }

                                                var95[var32++] = (short)var36;
                                             }

                                             ++var36;
                                          }

                                          class38.field812[var5++] = class93.field1619;
                                          continue;
                                       }

                                       if(var45 == 4211) {
                                          if(null != class11.field162 && class13.field194 < class93.field1619) {
                                             class38.field812[var5++] = class11.field162[++class13.field194 - 1] & '\uffff';
                                             continue;
                                          }

                                          class38.field812[var5++] = -1;
                                          continue;
                                       }

                                       if(var45 == 4212) {
                                          class13.field194 = 0;
                                          continue;
                                       }
                                    } else if(var45 < 5100) {
                                       if(var45 == 5000) {
                                          class38.field812[var5++] = Client.field498;
                                          continue;
                                       }

                                       if(var45 == 5001) {
                                          var5 -= 3;
                                          Client.field498 = class38.field812[var5];
                                          var35 = class38.field812[var5 + 1];
                                          class133[] var64 = new class133[]{class133.field2112, class133.field2110, class133.field2115};
                                          class133[] var112 = var64;
                                          var19 = 0;

                                          class133 var115;
                                          while(true) {
                                             if(var19 >= var112.length) {
                                                var115 = null;
                                                break;
                                             }

                                             class133 var71 = var112[var19];
                                             if(var71.field2113 == var35) {
                                                var115 = var71;
                                                break;
                                             }

                                             ++var19;
                                          }

                                          class160.field2635 = var115;
                                          if(class160.field2635 == null) {
                                             class160.field2635 = class133.field2110;
                                          }

                                          Client.field499 = class38.field812[2 + var5];
                                          Client.field324.method2828(192);
                                          Client.field324.method2556(Client.field498);
                                          Client.field324.method2556(class160.field2635.field2113);
                                          Client.field324.method2556(Client.field499);
                                          continue;
                                       }

                                       if(var45 == 5002) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          var5 -= 2;
                                          var35 = class38.field812[var5];
                                          var81 = class38.field812[1 + var5];
                                          Client.field324.method2828(209);
                                          Client.field324.method2556(class31.method685(var52) + 2);
                                          Client.field324.method2562(var52);
                                          Client.field324.method2556(var35 - 1);
                                          Client.field324.method2556(var81);
                                          continue;
                                       }

                                       if(var45 == 5003) {
                                          var5 -= 2;
                                          var34 = class38.field812[var5];
                                          var35 = class38.field812[1 + var5];
                                          ChatLineBuffer var110 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var34));
                                          MessageNode var62 = var110.method663(var35);
                                          if(var62 != null) {
                                             class38.field812[var5++] = var62.id;
                                             class38.field812[var5++] = var62.tick;
                                             class38.chatboxSegments[var6++] = null != var62.name?var62.name:"";
                                             class38.chatboxSegments[var6++] = var62.sender != null?var62.sender:"";
                                             class38.chatboxSegments[var6++] = null != var62.value?var62.value:"";
                                          } else {
                                             class38.field812[var5++] = -1;
                                             class38.field812[var5++] = 0;
                                             class38.chatboxSegments[var6++] = "";
                                             class38.chatboxSegments[var6++] = "";
                                             class38.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var45 == 5004) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          MessageNode var78 = class50.method1040(var34);
                                          if(var78 != null) {
                                             class38.field812[var5++] = var78.type;
                                             class38.field812[var5++] = var78.tick;
                                             class38.chatboxSegments[var6++] = var78.name != null?var78.name:"";
                                             class38.chatboxSegments[var6++] = var78.sender != null?var78.sender:"";
                                             class38.chatboxSegments[var6++] = var78.value != null?var78.value:"";
                                          } else {
                                             class38.field812[var5++] = -1;
                                             class38.field812[var5++] = 0;
                                             class38.chatboxSegments[var6++] = "";
                                             class38.chatboxSegments[var6++] = "";
                                             class38.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var45 == 5005) {
                                          if(null == class160.field2635) {
                                             class38.field812[var5++] = -1;
                                          } else {
                                             class38.field812[var5++] = class160.field2635.field2113;
                                          }
                                          continue;
                                       }

                                       if(var45 == 5008) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          --var5;
                                          var35 = class38.field812[var5];
                                          var17 = var52.toLowerCase();
                                          byte var77 = 0;
                                          if(var17.startsWith("yellow:")) {
                                             var77 = 0;
                                             var52 = var52.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var77 = 1;
                                             var52 = var52.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var77 = 2;
                                             var52 = var52.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var77 = 3;
                                             var52 = var52.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var77 = 4;
                                             var52 = var52.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var77 = 5;
                                             var52 = var52.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var77 = 6;
                                             var52 = var52.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var77 = 7;
                                             var52 = var52.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var77 = 8;
                                             var52 = var52.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var77 = 9;
                                             var52 = var52.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var77 = 10;
                                             var52 = var52.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var77 = 11;
                                             var52 = var52.substring("glow3:".length());
                                          } else if(Client.field283 != 0) {
                                             if(var17.startsWith("yellow:")) {
                                                var77 = 0;
                                                var52 = var52.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var77 = 1;
                                                var52 = var52.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var77 = 2;
                                                var52 = var52.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var77 = 3;
                                                var52 = var52.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var77 = 4;
                                                var52 = var52.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var77 = 5;
                                                var52 = var52.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var77 = 6;
                                                var52 = var52.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var77 = 7;
                                                var52 = var52.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var77 = 8;
                                                var52 = var52.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var77 = 9;
                                                var52 = var52.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var77 = 10;
                                                var52 = var52.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var77 = 11;
                                                var52 = var52.substring("glow3:".length());
                                             }
                                          }

                                          var17 = var52.toLowerCase();
                                          byte var76 = 0;
                                          if(var17.startsWith("wave:")) {
                                             var76 = 1;
                                             var52 = var52.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var76 = 2;
                                             var52 = var52.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var76 = 3;
                                             var52 = var52.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var76 = 4;
                                             var52 = var52.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var76 = 5;
                                             var52 = var52.substring("slide:".length());
                                          } else if(Client.field283 != 0) {
                                             if(var17.startsWith("wave:")) {
                                                var76 = 1;
                                                var52 = var52.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var76 = 2;
                                                var52 = var52.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var76 = 3;
                                                var52 = var52.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var76 = 4;
                                                var52 = var52.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var76 = 5;
                                                var52 = var52.substring("slide:".length());
                                             }
                                          }

                                          Client.field324.method2828(237);
                                          Client.field324.method2556(0);
                                          var32 = Client.field324.offset;
                                          Client.field324.method2556(var35);
                                          Client.field324.method2556(var77);
                                          Client.field324.method2556(var76);
                                          class125 var68 = Client.field324;
                                          var22 = var68.offset;
                                          var70 = var52.length();
                                          byte[] var106 = new byte[var70];

                                          for(var26 = 0; var26 < var70; ++var26) {
                                             char var75 = var52.charAt(var26);
                                             if((var75 <= 0 || var75 >= 128) && (var75 < 160 || var75 > 255)) {
                                                if(var75 == 8364) {
                                                   var106[var26] = -128;
                                                } else if(var75 == 8218) {
                                                   var106[var26] = -126;
                                                } else if(var75 == 402) {
                                                   var106[var26] = -125;
                                                } else if(var75 == 8222) {
                                                   var106[var26] = -124;
                                                } else if(var75 == 8230) {
                                                   var106[var26] = -123;
                                                } else if(var75 == 8224) {
                                                   var106[var26] = -122;
                                                } else if(var75 == 8225) {
                                                   var106[var26] = -121;
                                                } else if(var75 == 710) {
                                                   var106[var26] = -120;
                                                } else if(var75 == 8240) {
                                                   var106[var26] = -119;
                                                } else if(var75 == 352) {
                                                   var106[var26] = -118;
                                                } else if(var75 == 8249) {
                                                   var106[var26] = -117;
                                                } else if(var75 == 338) {
                                                   var106[var26] = -116;
                                                } else if(var75 == 381) {
                                                   var106[var26] = -114;
                                                } else if(var75 == 8216) {
                                                   var106[var26] = -111;
                                                } else if(var75 == 8217) {
                                                   var106[var26] = -110;
                                                } else if(var75 == 8220) {
                                                   var106[var26] = -109;
                                                } else if(var75 == 8221) {
                                                   var106[var26] = -108;
                                                } else if(var75 == 8226) {
                                                   var106[var26] = -107;
                                                } else if(var75 == 8211) {
                                                   var106[var26] = -106;
                                                } else if(var75 == 8212) {
                                                   var106[var26] = -105;
                                                } else if(var75 == 732) {
                                                   var106[var26] = -104;
                                                } else if(var75 == 8482) {
                                                   var106[var26] = -103;
                                                } else if(var75 == 353) {
                                                   var106[var26] = -102;
                                                } else if(var75 == 8250) {
                                                   var106[var26] = -101;
                                                } else if(var75 == 339) {
                                                   var106[var26] = -100;
                                                } else if(var75 == 382) {
                                                   var106[var26] = -98;
                                                } else if(var75 == 376) {
                                                   var106[var26] = -97;
                                                } else {
                                                   var106[var26] = 63;
                                                }
                                             } else {
                                                var106[var26] = (byte)var75;
                                             }
                                          }

                                          var68.method2569(var106.length);
                                          var68.offset += class145.field2223.method2500(var106, 0, var106.length, var68.payload, var68.offset);
                                          Client.field324.method2568(Client.field324.offset - var32);
                                          continue;
                                       }

                                       if(var45 == 5009) {
                                          var6 -= 2;
                                          var52 = class38.chatboxSegments[var6];
                                          var54 = class38.chatboxSegments[1 + var6];
                                          Client.field324.method2828(26);
                                          Client.field324.method2638(0);
                                          var81 = Client.field324.offset;
                                          Client.field324.method2562(var52);
                                          class125 var108 = Client.field324;
                                          var19 = var108.offset;
                                          var36 = var54.length();
                                          byte[] var102 = new byte[var36];

                                          for(var23 = 0; var23 < var36; ++var23) {
                                             var24 = var54.charAt(var23);
                                             if((var24 <= 0 || var24 >= 128) && (var24 < 160 || var24 > 255)) {
                                                if(var24 == 8364) {
                                                   var102[var23] = -128;
                                                } else if(var24 == 8218) {
                                                   var102[var23] = -126;
                                                } else if(var24 == 402) {
                                                   var102[var23] = -125;
                                                } else if(var24 == 8222) {
                                                   var102[var23] = -124;
                                                } else if(var24 == 8230) {
                                                   var102[var23] = -123;
                                                } else if(var24 == 8224) {
                                                   var102[var23] = -122;
                                                } else if(var24 == 8225) {
                                                   var102[var23] = -121;
                                                } else if(var24 == 710) {
                                                   var102[var23] = -120;
                                                } else if(var24 == 8240) {
                                                   var102[var23] = -119;
                                                } else if(var24 == 352) {
                                                   var102[var23] = -118;
                                                } else if(var24 == 8249) {
                                                   var102[var23] = -117;
                                                } else if(var24 == 338) {
                                                   var102[var23] = -116;
                                                } else if(var24 == 381) {
                                                   var102[var23] = -114;
                                                } else if(var24 == 8216) {
                                                   var102[var23] = -111;
                                                } else if(var24 == 8217) {
                                                   var102[var23] = -110;
                                                } else if(var24 == 8220) {
                                                   var102[var23] = -109;
                                                } else if(var24 == 8221) {
                                                   var102[var23] = -108;
                                                } else if(var24 == 8226) {
                                                   var102[var23] = -107;
                                                } else if(var24 == 8211) {
                                                   var102[var23] = -106;
                                                } else if(var24 == 8212) {
                                                   var102[var23] = -105;
                                                } else if(var24 == 732) {
                                                   var102[var23] = -104;
                                                } else if(var24 == 8482) {
                                                   var102[var23] = -103;
                                                } else if(var24 == 353) {
                                                   var102[var23] = -102;
                                                } else if(var24 == 8250) {
                                                   var102[var23] = -101;
                                                } else if(var24 == 339) {
                                                   var102[var23] = -100;
                                                } else if(var24 == 382) {
                                                   var102[var23] = -98;
                                                } else if(var24 == 376) {
                                                   var102[var23] = -97;
                                                } else {
                                                   var102[var23] = 63;
                                                }
                                             } else {
                                                var102[var23] = (byte)var24;
                                             }
                                          }

                                          var108.method2569(var102.length);
                                          var108.offset += class145.field2223.method2500(var102, 0, var102.length, var108.payload, var108.offset);
                                          Client.field324.method2754(Client.field324.offset - var81);
                                          continue;
                                       }

                                       if(var45 == 5015) {
                                          if(class165.localPlayer != null && class165.localPlayer.name != null) {
                                             var52 = class165.localPlayer.name;
                                          } else {
                                             var52 = "";
                                          }

                                          class38.chatboxSegments[var6++] = var52;
                                          continue;
                                       }

                                       if(var45 == 5016) {
                                          class38.field812[var5++] = Client.field499;
                                          continue;
                                       }

                                       if(var45 == 5017) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var48 = class38.field812;
                                          var81 = var5++;
                                          ChatLineBuffer var104 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var34));
                                          if(null == var104) {
                                             var18 = 0;
                                          } else {
                                             var18 = var104.method664();
                                          }

                                          var48[var81] = var18;
                                          continue;
                                       }

                                       MessageNode var99;
                                       if(var45 == 5018) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var48 = class38.field812;
                                          var81 = var5++;
                                          var99 = (MessageNode)class11.field167.method3835((long)var34);
                                          if(null == var99) {
                                             var18 = -1;
                                          } else if(class11.field164.field3150 == var99.previous) {
                                             var18 = -1;
                                          } else {
                                             var18 = ((MessageNode)var99.previous).id;
                                          }

                                          var48[var81] = var18;
                                          continue;
                                       }

                                       if(var45 == 5019) {
                                          --var5;
                                          var34 = class38.field812[var5];
                                          var48 = class38.field812;
                                          var81 = var5++;
                                          var99 = (MessageNode)class11.field167.method3835((long)var34);
                                          if(null == var99) {
                                             var18 = -1;
                                          } else if(class11.field164.field3150 == var99.next) {
                                             var18 = -1;
                                          } else {
                                             var18 = ((MessageNode)var99.next).id;
                                          }

                                          var48[var81] = var18;
                                          continue;
                                       }

                                       if(var45 == 5020) {
                                          --var6;
                                          var52 = class38.chatboxSegments[var6];
                                          if(var52.equalsIgnoreCase("toggleroof")) {
                                             class130.field2102.field138 = !class130.field2102.field138;
                                             class216.method3980();
                                             if(class130.field2102.field138) {
                                                Widget.sendGameMessage(99, "", "Roofs are now all hidden");
                                             } else {
                                                Widget.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if(var52.equalsIgnoreCase("displayfps")) {
                                             Client.field294 = !Client.field294;
                                          }

                                          if(Client.field447 >= 2) {
                                             if(var52.equalsIgnoreCase("fpson")) {
                                                Client.field294 = true;
                                             }

                                             if(var52.equalsIgnoreCase("fpsoff")) {
                                                Client.field294 = false;
                                             }

                                             if(var52.equalsIgnoreCase("gc")) {
                                                System.gc();
                                             }

                                             if(var52.equalsIgnoreCase("clientdrop")) {
                                                class48.method1004();
                                             }

                                             if(var52.equalsIgnoreCase("errortest") && Client.field279 == 2) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          Client.field324.method2828(148);
                                          Client.field324.method2556(var52.length() + 1);
                                          Client.field324.method2562(var52);
                                          continue;
                                       }

                                       if(var45 == 5021) {
                                          --var6;
                                          Client.field500 = class38.chatboxSegments[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var45 == 5022) {
                                          class38.chatboxSegments[var6++] = Client.field500;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        if(var45 >= 2000) {
                           var45 -= 1000;
                           --var5;
                           var15 = class144.method3012(class38.field812[var5]);
                        } else {
                           var15 = var58?MessageNode.field808:class156.field2320;
                        }

                        class166.method3253(var15);
                        if(var45 == 1200 || var45 == 1205 || var45 == 1212) {
                           var5 -= 2;
                           var35 = class38.field812[var5];
                           var81 = class38.field812[var5 + 1];
                           var15.item = var35;
                           var15.stackSize = var81;
                           ItemComposition var33 = class22.getItemDefinition(var35);
                           var15.rotationX = var33.field1183;
                           var15.rotationZ = var33.field1184;
                           var15.rotationY = var33.field1201;
                           var15.field2903 = var33.field1186;
                           var15.field2848 = var33.field1187;
                           var15.field2852 = var33.field1182;
                           if(var45 == 1205) {
                              var15.field2810 = 0;
                           } else if(var45 == 1212 | var33.isStackable == 1) {
                              var15.field2810 = 1;
                           } else {
                              var15.field2810 = 2;
                           }

                           if(var15.field2853 > 0) {
                              var15.field2852 = var15.field2852 * 32 / var15.field2853;
                           } else if(var15.field2798 > 0) {
                              var15.field2852 = var15.field2852 * 32 / var15.field2798;
                           }
                           continue;
                        }

                        if(var45 == 1201) {
                           var15.modelType = 2;
                           --var5;
                           var15.modelId = class38.field812[var5];
                           continue;
                        }

                        if(var45 == 1202) {
                           var15.modelType = 3;
                           var15.modelId = class165.localPlayer.composition.method3516();
                           continue;
                        }
                     }
                  } else {
                     var34 = -1;
                     if(var45 >= 2000) {
                        var45 -= 1000;
                        --var5;
                        var34 = class38.field812[var5];
                        var16 = class144.method3012(var34);
                     } else {
                        var16 = var58?MessageNode.field808:class156.field2320;
                     }

                     if(var45 == 1000) {
                        var5 -= 4;
                        var16.field2807 = class38.field812[var5];
                        var16.field2808 = class38.field812[var5 + 1];
                        var16.field2803 = class38.field812[var5 + 2];
                        var16.field2804 = class38.field812[var5 + 3];
                        class166.method3253(var16);
                        class11.method127(var16);
                        if(var34 != -1 && var16.type == 0) {
                           Projectile.method93(Widget.widgets[var34 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var45 == 1001) {
                        var5 -= 4;
                        var16.field2798 = class38.field812[var5];
                        var16.field2854 = class38.field812[1 + var5];
                        var16.field2838 = class38.field812[2 + var5];
                        var16.field2893 = class38.field812[var5 + 3];
                        class166.method3253(var16);
                        class11.method127(var16);
                        if(var34 != -1 && var16.type == 0) {
                           Projectile.method93(Widget.widgets[var34 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var45 == 1003) {
                        --var5;
                        var30 = class38.field812[var5] == 1;
                        if(var30 != var16.isHidden) {
                           var16.isHidden = var30;
                           class166.method3253(var16);
                        }
                        continue;
                     }

                     if(var45 == 1005) {
                        --var5;
                        var16.field2931 = class38.field812[var5] == 1;
                        continue;
                     }

                     if(var45 == 1006) {
                        --var5;
                        var16.field2932 = class38.field812[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var45 < 5400) {
                  if(var45 == 5306) {
                     var79 = class38.field812;
                     var35 = var5++;
                     var81 = Client.isResized?2:1;
                     var79[var35] = var81;
                     continue;
                  }

                  if(var45 == 5307) {
                     --var5;
                     var34 = class38.field812[var5];
                     if(var34 == 1 || var34 == 2) {
                        class45.method942(var34);
                     }
                     continue;
                  }

                  if(var45 == 5308) {
                     class38.field812[var5++] = class130.field2102.field136;
                     continue;
                  }

                  if(var45 == 5309) {
                     --var5;
                     var34 = class38.field812[var5];
                     if(var34 == 1 || var34 == 2) {
                        class130.field2102.field136 = var34;
                        class216.method3980();
                     }
                     continue;
                  }
               }

               if(var45 < 5600) {
                  if(var45 == 5504) {
                     var5 -= 2;
                     var34 = class38.field812[var5];
                     var35 = class38.field812[var5 + 1];
                     if(!Client.field528) {
                        Client.field365 = var34;
                        Client.mapAngle = var35;
                     }
                     continue;
                  }

                  if(var45 == 5505) {
                     class38.field812[var5++] = Client.field365;
                     continue;
                  }

                  if(var45 == 5506) {
                     class38.field812[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var45 == 5530) {
                     --var5;
                     var34 = class38.field812[var5];
                     if(var34 < 0) {
                        var34 = 0;
                     }

                     Client.field371 = var34;
                     continue;
                  }

                  if(var45 == 5531) {
                     class38.field812[var5++] = Client.field371;
                     continue;
                  }
               }

               if(var45 < 5700 && var45 == 5630) {
                  Client.field397 = 250;
               } else {
                  if(var45 < 6300) {
                     if(var45 == 6200) {
                        var5 -= 2;
                        Client.field537 = (short)class38.field812[var5];
                        if(Client.field537 <= 0) {
                           Client.field537 = 256;
                        }

                        Client.field448 = (short)class38.field812[1 + var5];
                        if(Client.field448 <= 0) {
                           Client.field448 = 205;
                        }
                        continue;
                     }

                     if(var45 == 6201) {
                        var5 -= 2;
                        Client.field512 = (short)class38.field812[var5];
                        if(Client.field512 <= 0) {
                           Client.field512 = 256;
                        }

                        Client.field344 = (short)class38.field812[1 + var5];
                        if(Client.field344 <= 0) {
                           Client.field344 = 320;
                        }
                        continue;
                     }

                     if(var45 == 6202) {
                        var5 -= 4;
                        Client.field538 = (short)class38.field812[var5];
                        if(Client.field538 <= 0) {
                           Client.field538 = 1;
                        }

                        Client.field536 = (short)class38.field812[var5 + 1];
                        if(Client.field536 <= 0) {
                           Client.field536 = 32767;
                        } else if(Client.field536 < Client.field538) {
                           Client.field536 = Client.field538;
                        }

                        Client.field540 = (short)class38.field812[2 + var5];
                        if(Client.field540 <= 0) {
                           Client.field540 = 1;
                        }

                        Client.field457 = (short)class38.field812[3 + var5];
                        if(Client.field457 <= 0) {
                           Client.field457 = 32767;
                        } else if(Client.field457 < Client.field540) {
                           Client.field457 = Client.field540;
                        }
                        continue;
                     }

                     if(var45 == 6203) {
                        if(Client.field452 != null) {
                           WidgetNode.method46(0, 0, Client.field452.width, Client.field452.height, false);
                           class38.field812[var5++] = Client.camera2;
                           class38.field812[var5++] = Client.camera3;
                        } else {
                           class38.field812[var5++] = -1;
                           class38.field812[var5++] = -1;
                        }
                        continue;
                     }

                     if(var45 == 6204) {
                        class38.field812[var5++] = Client.field512;
                        class38.field812[var5++] = Client.field344;
                        continue;
                     }

                     if(var45 == 6205) {
                        class38.field812[var5++] = Client.field537;
                        class38.field812[var5++] = Client.field448;
                        continue;
                     }
                  }

                  if(var45 < 6600) {
                     if(var45 == 6500) {
                        class38.field812[var5++] = class5.loadWorlds()?1:0;
                        continue;
                     }

                     World var82;
                     if(var45 == 6501) {
                        World.field643 = 0;
                        if(World.field643 < World.field656) {
                           var82 = ItemComposition.worldList[++World.field643 - 1];
                        } else {
                           var82 = null;
                        }

                        if(null != var82) {
                           class38.field812[var5++] = var82.id;
                           class38.field812[var5++] = var82.mask;
                           class38.chatboxSegments[var6++] = var82.activity;
                           class38.field812[var5++] = var82.location;
                           class38.field812[var5++] = var82.playerCount;
                           class38.chatboxSegments[var6++] = var82.address;
                        } else {
                           class38.field812[var5++] = -1;
                           class38.field812[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field812[var5++] = 0;
                           class38.field812[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var45 == 6502) {
                        World var121;
                        if(World.field643 < World.field656) {
                           var121 = ItemComposition.worldList[++World.field643 - 1];
                        } else {
                           var121 = null;
                        }

                        if(var121 != null) {
                           class38.field812[var5++] = var121.id;
                           class38.field812[var5++] = var121.mask;
                           class38.chatboxSegments[var6++] = var121.activity;
                           class38.field812[var5++] = var121.location;
                           class38.field812[var5++] = var121.playerCount;
                           class38.chatboxSegments[var6++] = var121.address;
                        } else {
                           class38.field812[var5++] = -1;
                           class38.field812[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field812[var5++] = 0;
                           class38.field812[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var45 == 6506) {
                        --var5;
                        var34 = class38.field812[var5];
                        var82 = null;

                        for(var81 = 0; var81 < World.field656; ++var81) {
                           if(ItemComposition.worldList[var81].id == var34) {
                              var82 = ItemComposition.worldList[var81];
                              break;
                           }
                        }

                        if(null != var82) {
                           class38.field812[var5++] = var82.id;
                           class38.field812[var5++] = var82.mask;
                           class38.chatboxSegments[var6++] = var82.activity;
                           class38.field812[var5++] = var82.location;
                           class38.field812[var5++] = var82.playerCount;
                           class38.chatboxSegments[var6++] = var82.address;
                        } else {
                           class38.field812[var5++] = -1;
                           class38.field812[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field812[var5++] = 0;
                           class38.field812[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var45 == 6507) {
                        var5 -= 4;
                        var34 = class38.field812[var5];
                        var96 = class38.field812[1 + var5] == 1;
                        var81 = class38.field812[2 + var5];
                        var51 = class38.field812[3 + var5] == 1;
                        if(null != ItemComposition.worldList) {
                           class18.method184(0, ItemComposition.worldList.length - 1, var34, var96, var81, var51);
                        }
                        continue;
                     }

                     if(var45 == 6511) {
                        --var5;
                        var34 = class38.field812[var5];
                        if(var34 >= 0 && var34 < World.field656) {
                           var82 = ItemComposition.worldList[var34];
                           class38.field812[var5++] = var82.id;
                           class38.field812[var5++] = var82.mask;
                           class38.chatboxSegments[var6++] = var82.activity;
                           class38.field812[var5++] = var82.location;
                           class38.field812[var5++] = var82.playerCount;
                           class38.chatboxSegments[var6++] = var82.address;
                           continue;
                        }

                        class38.field812[var5++] = -1;
                        class38.field812[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field812[var5++] = 0;
                        class38.field812[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var44) {
            StringBuilder var42 = new StringBuilder(30);
            var42.append("").append(var4.hash).append(" ");

            for(var13 = class38.field815 - 1; var13 >= 0; --var13) {
               var42.append("").append(class38.field816[var13].field207.hash).append(" ");
            }

            var42.append("").append(var10);
            RSCanvas.method2969(var42.toString(), var44);
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "1349670780"
   )
   static final void method2151(class35 var0) {
      if(class165.localPlayer.x >> 7 == Client.flagX && Client.flagY == class165.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class34.field777;
      int[] var2 = class34.field773;
      int var3 = var1;
      if(var0 == class35.field788 || var0 == class35.field784) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class35.field788) {
            var5 = class165.localPlayer;
            var6 = class165.localPlayer.field51 << 14;
         } else if(class35.field784 == var0) {
            var5 = Client.cachedPlayers[Client.field411];
            var6 = Client.field411 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class35.field785 == var0 && Client.field411 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod774() && !var5.field49) {
            var5.field47 = false;
            if((Client.field282 && var1 > 50 || var1 > 200) && var0 != class35.field788 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field47 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field38) {
                  var5.field47 = false;
                  var5.field36 = class109.method2439(var5.x, var5.y, class145.plane);
                  Frames.region.method2017(class145.plane, var5.x, var5.y, var5.field36, 60, var5, var5.angle, var6, var5.field43, var5.field41, var5.field45, var5.field40);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field386 == Client.field385[var7][var8]) {
                        continue;
                     }

                     Client.field385[var7][var8] = Client.field386;
                  }

                  var5.field36 = class109.method2439(var5.x, var5.y, class145.plane);
                  Frames.region.method1972(class145.plane, var5.x, var5.y, var5.field36, 60, var5, var5.angle, var6, var5.field828);
               }
            }
         }
      }

   }
}

import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class158 {
   @ObfuscatedName("ce")
   static class227 field2347;
   @ObfuscatedName("j")
   public static int[] field2351 = new int[99];
   @ObfuscatedName("r")
   public static final boolean[] field2352 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   static final void method3199() {
      for(class31 var0 = (class31)Client.field357.method3850(); var0 != null; var0 = (class31)Client.field357.method3852()) {
         if(var0.field702 == FrameMap.plane && !var0.field698) {
            if(Client.gameCycle >= var0.field697) {
               var0.method660(Client.field329);
               if(var0.field698) {
                  var0.unlink();
               } else {
                  Projectile.region.method2110(var0.field702, var0.field699, var0.field701, var0.field707, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2351[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-77"
   )
   public static boolean method3200(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "295066504"
   )
   static void method3201(class0 var0, int var1) {
      Object[] var2 = var0.field8;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class12.method153(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field591;
         int[] var9 = var4.field598;
         byte var10 = -1;
         class38.field802 = 0;

         int var13;
         try {
            class38.field804 = new int[var4.field595];
            int var11 = 0;
            class129.field2096 = new String[var4.field596];
            int var12 = 0;

            int var14;
            String var23;
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
                     var14 = null != var0.field7?var0.field7.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field11;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field7?var0.field7.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field6?var0.field6.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field2;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field1;
                  }

                  class38.field804[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var23 = (String)var2[var13];
                  if(var23.equals("event_opbase")) {
                     var23 = var0.field9;
                  }

                  class129.field2096[var12++] = var23;
               }
            }

            var13 = 0;
            class38.field806 = var0.field10;

            label3535:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var35 = var8[var7];
               int var15;
               int var18;
               int var19;
               int var20;
               int var27;
               int var36;
               int[] var50;
               byte var56;
               String var64;
               if(var35 < 100) {
                  if(var35 == 0) {
                     class38.field805[var5++] = var9[var7];
                     continue;
                  }

                  if(var35 == 1) {
                     var14 = var9[var7];
                     class38.field805[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var35 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field805[var5];
                     Widget.method3468(var14);
                     continue;
                  }

                  if(var35 == 3) {
                     class38.chatboxSegments[var6++] = var4.field594[var7];
                     continue;
                  }

                  if(var35 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var35 == 7) {
                     var5 -= 2;
                     if(class38.field805[1 + var5] != class38.field805[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 8) {
                     var5 -= 2;
                     if(class38.field805[var5 + 1] == class38.field805[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 9) {
                     var5 -= 2;
                     if(class38.field805[var5] < class38.field805[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 10) {
                     var5 -= 2;
                     if(class38.field805[var5] > class38.field805[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 21) {
                     if(class38.field802 == 0) {
                        return;
                     }

                     class14 var51 = class38.field808[--class38.field802];
                     var4 = var51.field203;
                     var8 = var4.field591;
                     var9 = var4.field598;
                     var7 = var51.field204;
                     class38.field804 = var51.field215;
                     class129.field2096 = var51.field206;
                     continue;
                  }

                  if(var35 == 25) {
                     var14 = var9[var7];
                     class38.field805[var5++] = Sequence.method901(var14);
                     continue;
                  }

                  if(var35 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field805[var5];
                     class50 var77 = Item.method654(var14);
                     var36 = var77.field1090;
                     var18 = var77.field1093;
                     var19 = var77.field1092;
                     var20 = class179.field2957[var19 - var18];
                     if(var15 < 0 || var15 > var20) {
                        var15 = 0;
                     }

                     var20 <<= var18;
                     class179.widgetSettings[var36] = class179.widgetSettings[var36] & ~var20 | var15 << var18 & var20;
                     continue;
                  }

                  if(var35 == 31) {
                     var5 -= 2;
                     if(class38.field805[var5] <= class38.field805[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 32) {
                     var5 -= 2;
                     if(class38.field805[var5] >= class38.field805[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 33) {
                     class38.field805[var5++] = class38.field804[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var35 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class38.field804[var10001] = class38.field805[var5];
                     continue;
                  }

                  if(var35 == 35) {
                     class38.chatboxSegments[var6++] = class129.field2096[var9[var7]];
                     continue;
                  }

                  if(var35 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class129.field2096[var10001] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var35 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var64 = class32.method669(class38.chatboxSegments, var6, var14);
                     class38.chatboxSegments[var6++] = var64;
                     continue;
                  }

                  if(var35 == 38) {
                     --var5;
                     continue;
                  }

                  if(var35 == 39) {
                     --var6;
                     continue;
                  }

                  if(var35 == 40) {
                     var14 = var9[var7];
                     class23 var88 = class12.method153(var14);
                     var50 = new int[var88.field595];
                     String[] var75 = new String[var88.field596];

                     for(var18 = 0; var18 < var88.field597; ++var18) {
                        var50[var18] = class38.field805[var5 - var88.field597 + var18];
                     }

                     for(var18 = 0; var18 < var88.field600; ++var18) {
                        var75[var18] = class38.chatboxSegments[var6 - var88.field600 + var18];
                     }

                     var5 -= var88.field597;
                     var6 -= var88.field600;
                     class14 var85 = new class14();
                     var85.field203 = var4;
                     var85.field204 = var7;
                     var85.field215 = class38.field804;
                     var85.field206 = class129.field2096;
                     class38.field808[++class38.field802 - 1] = var85;
                     var4 = var88;
                     var8 = var88.field591;
                     var9 = var88.field598;
                     var7 = -1;
                     class38.field804 = var50;
                     class129.field2096 = var75;
                     continue;
                  }

                  if(var35 == 42) {
                     class38.field805[var5++] = class8.chatMessages.method203(var9[var7]);
                     continue;
                  }

                  if(var35 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class8.chatMessages.method202(var10001, class38.field805[var5]);
                     continue;
                  }

                  if(var35 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var27 = class38.field805[var5];
                     if(var27 >= 0 && var27 <= 5000) {
                        class38.field803[var14] = var27;
                        var56 = -1;
                        if(var15 == 105) {
                           var56 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var27) {
                              continue label3535;
                           }

                           class38.field812[var14][var18] = var56;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var35 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field805[var5];
                     if(var15 >= 0 && var15 < class38.field803[var14]) {
                        class38.field805[var5++] = class38.field812[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var35 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class38.field805[var5];
                     if(var15 >= 0 && var15 < class38.field803[var14]) {
                        class38.field812[var14][var15] = class38.field805[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var35 == 47) {
                     var23 = class8.chatMessages.method208(var9[var7]);
                     if(var23 == null) {
                        var23 = "null";
                     }

                     class38.chatboxSegments[var6++] = var23;
                     continue;
                  }

                  if(var35 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class8.chatMessages.method204(var10001, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var43;
               if(var9[var7] == 1) {
                  var43 = true;
               } else {
                  var43 = false;
               }

               Widget var16;
               Widget var24;
               boolean var44;
               Widget var52;
               Widget var55;
               boolean var66;
               if(var35 < 1000) {
                  if(var35 == 100) {
                     var5 -= 3;
                     var15 = class38.field805[var5];
                     var27 = class38.field805[var5 + 1];
                     var36 = class38.field805[2 + var5];
                     if(var27 == 0) {
                        throw new RuntimeException();
                     }

                     var55 = World.method628(var15);
                     if(var55.children == null) {
                        var55.children = new Widget[var36 + 1];
                     }

                     if(var55.children.length <= var36) {
                        Widget[] var80 = new Widget[var36 + 1];

                        for(var20 = 0; var20 < var55.children.length; ++var20) {
                           var80[var20] = var55.children[var20];
                        }

                        var55.children = var80;
                     }

                     if(var36 > 0 && var55.children[var36 - 1] == null) {
                        throw new RuntimeException("" + (var36 - 1));
                     }

                     Widget var82 = new Widget();
                     var82.type = var27;
                     var82.parentId = var82.id = var55.id;
                     var82.index = var36;
                     var82.field2809 = true;
                     var55.children[var36] = var82;
                     if(var43) {
                        class38.field807 = var82;
                     } else {
                        class153.field2306 = var82;
                     }

                     class75.method1606(var55);
                     continue;
                  }

                  if(var35 == 101) {
                     var24 = var43?class38.field807:class153.field2306;
                     var16 = World.method628(var24.id);
                     var16.children[var24.index] = null;
                     class75.method1606(var16);
                     continue;
                  }

                  if(var35 == 102) {
                     --var5;
                     var24 = World.method628(class38.field805[var5]);
                     var24.children = null;
                     class75.method1606(var24);
                     continue;
                  }

                  if(var35 == 200) {
                     var5 -= 2;
                     var15 = class38.field805[var5];
                     var27 = class38.field805[var5 + 1];
                     var52 = class166.method3265(var15, var27);
                     if(var52 != null && var27 != -1) {
                        class38.field805[var5++] = 1;
                        if(var43) {
                           class38.field807 = var52;
                        } else {
                           class153.field2306 = var52;
                        }
                        continue;
                     }

                     class38.field805[var5++] = 0;
                     continue;
                  }

                  if(var35 == 201) {
                     --var5;
                     var24 = World.method628(class38.field805[var5]);
                     if(var24 != null) {
                        class38.field805[var5++] = 1;
                        if(var43) {
                           class38.field807 = var24;
                        } else {
                           class153.field2306 = var24;
                        }
                     } else {
                        class38.field805[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var17;
                  if((var35 < 1000 || var35 >= 1100) && (var35 < 2000 || var35 >= 2100)) {
                     String var25;
                     if(var35 >= 1100 && var35 < 1200 || var35 >= 2100 && var35 < 2200) {
                        var27 = -1;
                        if(var35 >= 2000) {
                           var35 -= 1000;
                           --var5;
                           var27 = class38.field805[var5];
                           var24 = World.method628(var27);
                        } else {
                           var24 = var43?class38.field807:class153.field2306;
                        }

                        if(var35 == 1100) {
                           var5 -= 2;
                           var24.itemId = class38.field805[var5];
                           if(var24.itemId > var24.scrollWidth - var24.width) {
                              var24.itemId = var24.scrollWidth - var24.width;
                           }

                           if(var24.itemId < 0) {
                              var24.itemId = 0;
                           }

                           var24.scrollY = class38.field805[1 + var5];
                           if(var24.scrollY > var24.scrollHeight - var24.height) {
                              var24.scrollY = var24.scrollHeight - var24.height;
                           }

                           if(var24.scrollY < 0) {
                              var24.scrollY = 0;
                           }

                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1101) {
                           --var5;
                           var24.textColor = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1102) {
                           --var5;
                           var24.field2839 = class38.field805[var5] == 1;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1103) {
                           --var5;
                           var24.opacity = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1104) {
                           --var5;
                           var24.field2843 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1105) {
                           --var5;
                           var24.textureId = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1106) {
                           --var5;
                           var24.field2919 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1107) {
                           --var5;
                           var24.field2846 = class38.field805[var5] == 1;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1108) {
                           var24.modelType = 1;
                           --var5;
                           var24.modelId = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1109) {
                           var5 -= 6;
                           var24.field2873 = class38.field805[var5];
                           var24.field2860 = class38.field805[1 + var5];
                           var24.rotationX = class38.field805[var5 + 2];
                           var24.rotationZ = class38.field805[3 + var5];
                           var24.rotationY = class38.field805[var5 + 4];
                           var24.field2864 = class38.field805[5 + var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1110) {
                           --var5;
                           var36 = class38.field805[var5];
                           if(var36 != var24.field2857) {
                              var24.field2857 = var36;
                              var24.field2932 = 0;
                              var24.field2945 = 0;
                              class75.method1606(var24);
                           }
                           continue;
                        }

                        if(var35 == 1111) {
                           --var5;
                           var24.field2867 = class38.field805[var5] == 1;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1112) {
                           --var6;
                           var25 = class38.chatboxSegments[var6];
                           if(!var25.equals(var24.text)) {
                              var24.text = var25;
                              class75.method1606(var24);
                           }
                           continue;
                        }

                        if(var35 == 1113) {
                           --var5;
                           var24.field2869 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1114) {
                           var5 -= 3;
                           var24.field2933 = class38.field805[var5];
                           var24.field2816 = class38.field805[var5 + 1];
                           var24.field2823 = class38.field805[2 + var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1115) {
                           --var5;
                           var24.field2895 = class38.field805[var5] == 1;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1116) {
                           --var5;
                           var24.borderThickness = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1117) {
                           --var5;
                           var24.sprite2 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1118) {
                           --var5;
                           var24.flippedVertically = class38.field805[var5] == 1;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1119) {
                           --var5;
                           var24.flippedHorizontally = class38.field805[var5] == 1;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1120) {
                           var5 -= 2;
                           var24.scrollWidth = class38.field805[var5];
                           var24.scrollHeight = class38.field805[var5 + 1];
                           class75.method1606(var24);
                           if(var27 != -1 && var24.type == 0) {
                              class21.method554(Widget.widgets[var27 >> 16], var24, false);
                           }
                           continue;
                        }

                        if(var35 == 1121) {
                           class12.method152(var24.id, var24.index);
                           Client.field443 = var24;
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1122) {
                           --var5;
                           var24.field2840 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1123) {
                           --var5;
                           var24.field2836 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1124) {
                           --var5;
                           var24.field2842 = class38.field805[var5];
                           class75.method1606(var24);
                           continue;
                        }

                        if(var35 == 1125) {
                           --var5;
                           var36 = class38.field805[var5];
                           class85 var84 = (class85)class5.method98(XItemContainer.method185(), var36);
                           if(null != var84) {
                              var24.field2812 = var84;
                              class75.method1606(var24);
                           }
                           continue;
                        }
                     } else if((var35 < 1200 || var35 >= 1300) && (var35 < 2200 || var35 >= 2300)) {
                        if(var35 >= 1300 && var35 < 1400 || var35 >= 2300 && var35 < 2400) {
                           if(var35 >= 2000) {
                              var35 -= 1000;
                              --var5;
                              var24 = World.method628(class38.field805[var5]);
                           } else {
                              var24 = var43?class38.field807:class153.field2306;
                           }

                           if(var35 == 1300) {
                              --var5;
                              var27 = class38.field805[var5] - 1;
                              if(var27 >= 0 && var27 <= 9) {
                                 --var6;
                                 var24.method3432(var27, class38.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var35 == 1301) {
                              var5 -= 2;
                              var27 = class38.field805[var5];
                              var36 = class38.field805[1 + var5];
                              var24.parent = class166.method3265(var27, var36);
                              continue;
                           }

                           if(var35 == 1302) {
                              --var5;
                              var24.field2838 = class38.field805[var5] == 1;
                              continue;
                           }

                           if(var35 == 1303) {
                              --var5;
                              var24.field2928 = class38.field805[var5];
                              continue;
                           }

                           if(var35 == 1304) {
                              --var5;
                              var24.field2887 = class38.field805[var5];
                              continue;
                           }

                           if(var35 == 1305) {
                              --var6;
                              var24.name = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var35 == 1306) {
                              --var6;
                              var24.field2889 = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var35 == 1307) {
                              var24.actions = null;
                              continue;
                           }
                        } else {
                           String var38;
                           if(var35 >= 1400 && var35 < 1500 || var35 >= 2400 && var35 < 2500) {
                              if(var35 >= 2000) {
                                 var35 -= 1000;
                                 --var5;
                                 var24 = World.method628(class38.field805[var5]);
                              } else {
                                 var24 = var43?class38.field807:class153.field2306;
                              }

                              --var6;
                              var38 = class38.chatboxSegments[var6];
                              int[] var67 = null;
                              if(var38.length() > 0 && var38.charAt(var38.length() - 1) == 89) {
                                 --var5;
                                 var18 = class38.field805[var5];
                                 if(var18 > 0) {
                                    for(var67 = new int[var18]; var18-- > 0; var67[var18] = class38.field805[var5]) {
                                       --var5;
                                    }
                                 }

                                 var38 = var38.substring(0, var38.length() - 1);
                              }

                              Object[] var74 = new Object[var38.length() + 1];

                              for(var19 = var74.length - 1; var19 >= 1; --var19) {
                                 if(var38.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var74[var19] = class38.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var74[var19] = new Integer(class38.field805[var5]);
                                 }
                              }

                              --var5;
                              var19 = class38.field805[var5];
                              if(var19 != -1) {
                                 var74[0] = new Integer(var19);
                              } else {
                                 var74 = null;
                              }

                              if(var35 == 1400) {
                                 var24.field2892 = var74;
                              }

                              if(var35 == 1401) {
                                 var24.field2913 = var74;
                              }

                              if(var35 == 1402) {
                                 var24.field2894 = var74;
                              }

                              if(var35 == 1403) {
                                 var24.field2858 = var74;
                              }

                              if(var35 == 1404) {
                                 var24.field2898 = var74;
                              }

                              if(var35 == 1405) {
                                 var24.field2899 = var74;
                              }

                              if(var35 == 1406) {
                                 var24.field2902 = var74;
                              }

                              if(var35 == 1407) {
                                 var24.field2903 = var74;
                                 var24.field2863 = var67;
                              }

                              if(var35 == 1408) {
                                 var24.field2815 = var74;
                              }

                              if(var35 == 1409) {
                                 var24.field2804 = var74;
                              }

                              if(var35 == 1410) {
                                 var24.field2868 = var74;
                              }

                              if(var35 == 1411) {
                                 var24.field2848 = var74;
                              }

                              if(var35 == 1412) {
                                 var24.field2897 = var74;
                              }

                              if(var35 == 1414) {
                                 var24.field2876 = var74;
                                 var24.field2906 = var67;
                              }

                              if(var35 == 1415) {
                                 var24.field2907 = var74;
                                 var24.field2908 = var67;
                              }

                              if(var35 == 1416) {
                                 var24.field2901 = var74;
                              }

                              if(var35 == 1417) {
                                 var24.field2911 = var74;
                              }

                              if(var35 == 1418) {
                                 var24.field2912 = var74;
                              }

                              if(var35 == 1419) {
                                 var24.field2847 = var74;
                              }

                              if(var35 == 1420) {
                                 var24.field2914 = var74;
                              }

                              if(var35 == 1421) {
                                 var24.field2915 = var74;
                              }

                              if(var35 == 1422) {
                                 var24.field2888 = var74;
                              }

                              if(var35 == 1423) {
                                 var24.field2893 = var74;
                              }

                              if(var35 == 1424) {
                                 var24.field2930 = var74;
                              }

                              if(var35 == 1425) {
                                 var24.field2917 = var74;
                              }

                              if(var35 == 1426) {
                                 var24.field2921 = var74;
                              }

                              if(var35 == 1427) {
                                 var24.field2827 = var74;
                              }

                              var24.field2829 = true;
                              continue;
                           }

                           if(var35 < 1600) {
                              var24 = var43?class38.field807:class153.field2306;
                              if(var35 == 1500) {
                                 class38.field805[var5++] = var24.relativeX;
                                 continue;
                              }

                              if(var35 == 1501) {
                                 class38.field805[var5++] = var24.relativeY;
                                 continue;
                              }

                              if(var35 == 1502) {
                                 class38.field805[var5++] = var24.width;
                                 continue;
                              }

                              if(var35 == 1503) {
                                 class38.field805[var5++] = var24.height;
                                 continue;
                              }

                              if(var35 == 1504) {
                                 class38.field805[var5++] = var24.isHidden?1:0;
                                 continue;
                              }

                              if(var35 == 1505) {
                                 class38.field805[var5++] = var24.parentId;
                                 continue;
                              }
                           } else if(var35 < 1700) {
                              var24 = var43?class38.field807:class153.field2306;
                              if(var35 == 1600) {
                                 class38.field805[var5++] = var24.itemId;
                                 continue;
                              }

                              if(var35 == 1601) {
                                 class38.field805[var5++] = var24.scrollY;
                                 continue;
                              }

                              if(var35 == 1602) {
                                 class38.chatboxSegments[var6++] = var24.text;
                                 continue;
                              }

                              if(var35 == 1603) {
                                 class38.field805[var5++] = var24.scrollWidth;
                                 continue;
                              }

                              if(var35 == 1604) {
                                 class38.field805[var5++] = var24.scrollHeight;
                                 continue;
                              }

                              if(var35 == 1605) {
                                 class38.field805[var5++] = var24.field2864;
                                 continue;
                              }

                              if(var35 == 1606) {
                                 class38.field805[var5++] = var24.rotationX;
                                 continue;
                              }

                              if(var35 == 1607) {
                                 class38.field805[var5++] = var24.rotationY;
                                 continue;
                              }

                              if(var35 == 1608) {
                                 class38.field805[var5++] = var24.rotationZ;
                                 continue;
                              }

                              if(var35 == 1609) {
                                 class38.field805[var5++] = var24.opacity;
                                 continue;
                              }

                              if(var35 == 1610) {
                                 class38.field805[var5++] = var24.field2842;
                                 continue;
                              }

                              if(var35 == 1611) {
                                 class38.field805[var5++] = var24.textColor;
                                 continue;
                              }

                              if(var35 == 1612) {
                                 class38.field805[var5++] = var24.field2836;
                                 continue;
                              }

                              if(var35 == 1613) {
                                 class38.field805[var5++] = var24.field2812.vmethod3206();
                                 continue;
                              }
                           } else if(var35 < 1800) {
                              var24 = var43?class38.field807:class153.field2306;
                              if(var35 == 1700) {
                                 class38.field805[var5++] = var24.item;
                                 continue;
                              }

                              if(var35 == 1701) {
                                 if(var24.item != -1) {
                                    class38.field805[var5++] = var24.stackSize;
                                 } else {
                                    class38.field805[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 1702) {
                                 class38.field805[var5++] = var24.index;
                                 continue;
                              }
                           } else if(var35 < 1900) {
                              var24 = var43?class38.field807:class153.field2306;
                              if(var35 == 1800) {
                                 class38.field805[var5++] = class77.method1637(class132.method2880(var24));
                                 continue;
                              }

                              if(var35 == 1801) {
                                 --var5;
                                 var27 = class38.field805[var5];
                                 --var27;
                                 if(var24.actions != null && var27 < var24.actions.length && null != var24.actions[var27]) {
                                    class38.chatboxSegments[var6++] = var24.actions[var27];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var35 == 1802) {
                                 if(null == var24.name) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var24.name;
                                 }
                                 continue;
                              }
                           } else if(var35 >= 1900 && var35 < 2000 || var35 >= 2900 && var35 < 3000) {
                              if(var35 >= 2000) {
                                 var35 -= 1000;
                                 --var5;
                                 var24 = World.method628(class38.field805[var5]);
                              } else {
                                 var24 = var43?class38.field807:class153.field2306;
                              }

                              if(var35 == 1927) {
                                 if(class38.field806 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var24.field2827) {
                                    return;
                                 }

                                 class0 var62 = new class0();
                                 var62.field7 = var24;
                                 var62.field8 = var24.field2827;
                                 var62.field10 = 1 + class38.field806;
                                 Client.field478.method3844(var0);
                                 continue;
                              }
                           } else if(var35 < 2600) {
                              --var5;
                              var24 = World.method628(class38.field805[var5]);
                              if(var35 == 2500) {
                                 class38.field805[var5++] = var24.relativeX;
                                 continue;
                              }

                              if(var35 == 2501) {
                                 class38.field805[var5++] = var24.relativeY;
                                 continue;
                              }

                              if(var35 == 2502) {
                                 class38.field805[var5++] = var24.width;
                                 continue;
                              }

                              if(var35 == 2503) {
                                 class38.field805[var5++] = var24.height;
                                 continue;
                              }

                              if(var35 == 2504) {
                                 class38.field805[var5++] = var24.isHidden?1:0;
                                 continue;
                              }

                              if(var35 == 2505) {
                                 class38.field805[var5++] = var24.parentId;
                                 continue;
                              }
                           } else if(var35 < 2700) {
                              --var5;
                              var24 = World.method628(class38.field805[var5]);
                              if(var35 == 2600) {
                                 class38.field805[var5++] = var24.itemId;
                                 continue;
                              }

                              if(var35 == 2601) {
                                 class38.field805[var5++] = var24.scrollY;
                                 continue;
                              }

                              if(var35 == 2602) {
                                 class38.chatboxSegments[var6++] = var24.text;
                                 continue;
                              }

                              if(var35 == 2603) {
                                 class38.field805[var5++] = var24.scrollWidth;
                                 continue;
                              }

                              if(var35 == 2604) {
                                 class38.field805[var5++] = var24.scrollHeight;
                                 continue;
                              }

                              if(var35 == 2605) {
                                 class38.field805[var5++] = var24.field2864;
                                 continue;
                              }

                              if(var35 == 2606) {
                                 class38.field805[var5++] = var24.rotationX;
                                 continue;
                              }

                              if(var35 == 2607) {
                                 class38.field805[var5++] = var24.rotationY;
                                 continue;
                              }

                              if(var35 == 2608) {
                                 class38.field805[var5++] = var24.rotationZ;
                                 continue;
                              }

                              if(var35 == 2609) {
                                 class38.field805[var5++] = var24.opacity;
                                 continue;
                              }

                              if(var35 == 2610) {
                                 class38.field805[var5++] = var24.field2842;
                                 continue;
                              }

                              if(var35 == 2611) {
                                 class38.field805[var5++] = var24.textColor;
                                 continue;
                              }

                              if(var35 == 2612) {
                                 class38.field805[var5++] = var24.field2836;
                                 continue;
                              }

                              if(var35 == 2613) {
                                 class38.field805[var5++] = var24.field2812.vmethod3206();
                                 continue;
                              }
                           } else if(var35 < 2800) {
                              if(var35 == 2700) {
                                 --var5;
                                 var24 = World.method628(class38.field805[var5]);
                                 class38.field805[var5++] = var24.item;
                                 continue;
                              }

                              if(var35 == 2701) {
                                 --var5;
                                 var24 = World.method628(class38.field805[var5]);
                                 if(var24.item != -1) {
                                    class38.field805[var5++] = var24.stackSize;
                                 } else {
                                    class38.field805[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 2702) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 WidgetNode var37 = (WidgetNode)Client.componentTable.method3830((long)var15);
                                 if(var37 != null) {
                                    class38.field805[var5++] = 1;
                                 } else {
                                    class38.field805[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 2706) {
                                 class38.field805[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var35 < 2900) {
                              --var5;
                              var24 = World.method628(class38.field805[var5]);
                              if(var35 == 2800) {
                                 class38.field805[var5++] = class77.method1637(class132.method2880(var24));
                                 continue;
                              }

                              if(var35 == 2801) {
                                 --var5;
                                 var27 = class38.field805[var5];
                                 --var27;
                                 if(null != var24.actions && var27 < var24.actions.length && var24.actions[var27] != null) {
                                    class38.chatboxSegments[var6++] = var24.actions[var27];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var35 == 2802) {
                                 if(null == var24.name) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var24.name;
                                 }
                                 continue;
                              }
                           } else if(var35 < 3200) {
                              if(var35 == 3100) {
                                 --var6;
                                 var64 = class38.chatboxSegments[var6];
                                 class23.sendGameMessage(0, "", var64);
                                 continue;
                              }

                              if(var35 == 3101) {
                                 var5 -= 2;
                                 Renderable.method1945(class48.localPlayer, class38.field805[var5], class38.field805[1 + var5]);
                                 continue;
                              }

                              if(var35 == 3103) {
                                 FrameMap.method2348();
                                 continue;
                              }

                              if(var35 == 3104) {
                                 --var6;
                                 var64 = class38.chatboxSegments[var6];
                                 var27 = 0;
                                 if(VertexNormal.method2253(var64)) {
                                    var36 = SecondaryBufferProvider.method1672(var64, 10, true);
                                    var27 = var36;
                                 }

                                 Client.field323.method2818(151);
                                 Client.field323.method2544(var27);
                                 continue;
                              }

                              if(var35 == 3105) {
                                 --var6;
                                 var64 = class38.chatboxSegments[var6];
                                 Client.field323.method2818(56);
                                 Client.field323.method2715(var64.length() + 1);
                                 Client.field323.method2616(var64);
                                 continue;
                              }

                              if(var35 == 3106) {
                                 --var6;
                                 var64 = class38.chatboxSegments[var6];
                                 Client.field323.method2818(112);
                                 Client.field323.method2715(var64.length() + 1);
                                 Client.field323.method2616(var64);
                                 continue;
                              }

                              if(var35 == 3107) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 --var6;
                                 var38 = class38.chatboxSegments[var6];
                                 class18.method200(var15, var38);
                                 continue;
                              }

                              if(var35 == 3108) {
                                 var5 -= 3;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[var5 + 1];
                                 var36 = class38.field805[var5 + 2];
                                 var55 = World.method628(var36);
                                 VertexNormal.method2255(var55, var15, var27);
                                 continue;
                              }

                              if(var35 == 3109) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[1 + var5];
                                 var52 = var43?class38.field807:class153.field2306;
                                 VertexNormal.method2255(var52, var15, var27);
                                 continue;
                              }

                              if(var35 == 3110) {
                                 --var5;
                                 class134.field2117 = class38.field805[var5] == 1;
                                 continue;
                              }

                              if(var35 == 3111) {
                                 class38.field805[var5++] = class161.field2659.field145?1:0;
                                 continue;
                              }

                              if(var35 == 3112) {
                                 --var5;
                                 class161.field2659.field145 = class38.field805[var5] == 1;
                                 class5.method80();
                                 continue;
                              }

                              if(var35 == 3113) {
                                 --var6;
                                 var64 = class38.chatboxSegments[var6];
                                 --var5;
                                 var66 = class38.field805[var5] == 1;
                                 class114.method2482(var64, var66, false);
                                 continue;
                              }

                              if(var35 == 3115) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 Client.field323.method2818(124);
                                 Client.field323.method2542(var15);
                                 continue;
                              }

                              if(var35 == 3116) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 var6 -= 2;
                                 var38 = class38.chatboxSegments[var6];
                                 var25 = class38.chatboxSegments[1 + var6];
                                 if(var38.length() <= 500 && var25.length() <= 500) {
                                    Client.field323.method2818(216);
                                    Client.field323.method2542(1 + class43.method857(var38) + class43.method857(var25));
                                    Client.field323.method2616(var25);
                                    Client.field323.method2758(var15);
                                    Client.field323.method2616(var38);
                                 }
                                 continue;
                              }
                           } else if(var35 < 3300) {
                              if(var35 == 3200) {
                                 var5 -= 3;
                                 class10.method126(class38.field805[var5], class38.field805[1 + var5], class38.field805[var5 + 2]);
                                 continue;
                              }

                              if(var35 == 3201) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 if(var15 == -1 && !Client.field518) {
                                    class186.field3008.method3670();
                                    class186.field3009 = 1;
                                    class186.field3010 = null;
                                 } else if(var15 != -1 && var15 != Client.field517 && Client.field516 != 0 && !Client.field518) {
                                    class171 var39 = class192.field3108;
                                    var36 = Client.field516;
                                    class186.field3009 = 1;
                                    class186.field3010 = var39;
                                    class156.field2330 = var15;
                                    class128.field2091 = 0;
                                    class186.field3011 = var36;
                                    class186.field3016 = false;
                                    class35.field785 = 2;
                                 }

                                 Client.field517 = var15;
                                 continue;
                              }

                              if(var35 == 3202) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5];
                                 int var10000 = class38.field805[var5 + 1];
                                 if(Client.field516 != 0 && var15 != -1) {
                                    Buffer.method2775(class129.field2094, var15, 0, Client.field516, false);
                                    Client.field518 = true;
                                 }
                                 continue;
                              }
                           } else if(var35 < 3400) {
                              if(var35 == 3300) {
                                 class38.field805[var5++] = Client.gameCycle;
                                 continue;
                              }

                              if(var35 == 3301) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[var5 + 1];
                                 class38.field805[var5++] = class40.method769(var15, var27);
                                 continue;
                              }

                              if(var35 == 3302) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[1 + var5];
                                 class38.field805[var5++] = Client.method366(var15, var27);
                                 continue;
                              }

                              if(var35 == 3303) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[var5 + 1];
                                 class38.field805[var5++] = class4.method47(var15, var27);
                                 continue;
                              }

                              if(var35 == 3304) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = class52.method1069(var15).field1144;
                                 continue;
                              }

                              if(var35 == 3305) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = Client.boostedSkillLevels[var15];
                                 continue;
                              }

                              if(var35 == 3306) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = Client.realSkillLevels[var15];
                                 continue;
                              }

                              if(var35 == 3307) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = Client.skillExperiences[var15];
                                 continue;
                              }

                              if(var35 == 3308) {
                                 var15 = FrameMap.plane;
                                 var27 = class28.baseX + (class48.localPlayer.x >> 7);
                                 var36 = class159.baseY + (class48.localPlayer.y >> 7);
                                 class38.field805[var5++] = var36 + (var27 << 14) + (var15 << 28);
                                 continue;
                              }

                              if(var35 == 3309) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = var15 >> 14 & 16383;
                                 continue;
                              }

                              if(var35 == 3310) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = var15 >> 28;
                                 continue;
                              }

                              if(var35 == 3311) {
                                 --var5;
                                 var15 = class38.field805[var5];
                                 class38.field805[var5++] = var15 & 16383;
                                 continue;
                              }

                              if(var35 == 3312) {
                                 class38.field805[var5++] = Client.isMembers?1:0;
                                 continue;
                              }

                              if(var35 == 3313) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5] + '耀';
                                 var27 = class38.field805[1 + var5];
                                 class38.field805[var5++] = class40.method769(var15, var27);
                                 continue;
                              }

                              if(var35 == 3314) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5] + '耀';
                                 var27 = class38.field805[var5 + 1];
                                 class38.field805[var5++] = Client.method366(var15, var27);
                                 continue;
                              }

                              if(var35 == 3315) {
                                 var5 -= 2;
                                 var15 = '耀' + class38.field805[var5];
                                 var27 = class38.field805[var5 + 1];
                                 class38.field805[var5++] = class4.method47(var15, var27);
                                 continue;
                              }

                              if(var35 == 3316) {
                                 if(Client.field312 >= 2) {
                                    class38.field805[var5++] = Client.field312;
                                 } else {
                                    class38.field805[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 3317) {
                                 class38.field805[var5++] = Client.field297;
                                 continue;
                              }

                              if(var35 == 3318) {
                                 class38.field805[var5++] = Client.world;
                                 continue;
                              }

                              if(var35 == 3321) {
                                 class38.field805[var5++] = Client.energy;
                                 continue;
                              }

                              if(var35 == 3322) {
                                 class38.field805[var5++] = Client.weight;
                                 continue;
                              }

                              if(var35 == 3323) {
                                 if(Client.field448) {
                                    class38.field805[var5++] = 1;
                                 } else {
                                    class38.field805[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 3324) {
                                 class38.field805[var5++] = Client.flags;
                                 continue;
                              }
                           } else if(var35 < 3500) {
                              if(var35 == 3400) {
                                 var5 -= 2;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[1 + var5];
                                 class52 var54 = CollisionData.method2472(var15);
                                 if(var54.field1121 != 115) {
                                    ;
                                 }

                                 for(var18 = 0; var18 < var54.field1118; ++var18) {
                                    if(var27 == var54.field1125[var18]) {
                                       class38.chatboxSegments[var6++] = var54.field1122[var18];
                                       var54 = null;
                                       break;
                                    }
                                 }

                                 if(null != var54) {
                                    class38.chatboxSegments[var6++] = var54.field1132;
                                 }
                                 continue;
                              }

                              if(var35 == 3408) {
                                 var5 -= 4;
                                 var15 = class38.field805[var5];
                                 var27 = class38.field805[var5 + 1];
                                 var36 = class38.field805[var5 + 2];
                                 var18 = class38.field805[3 + var5];
                                 class52 var28 = CollisionData.method2472(var36);
                                 if(var28.field1120 == var15 && var27 == var28.field1121) {
                                    for(var20 = 0; var20 < var28.field1118; ++var20) {
                                       if(var28.field1125[var20] == var18) {
                                          if(var27 == 115) {
                                             class38.chatboxSegments[var6++] = var28.field1122[var20];
                                          } else {
                                             class38.field805[var5++] = var28.field1128[var20];
                                          }

                                          var28 = null;
                                          break;
                                       }
                                    }

                                    if(null != var28) {
                                       if(var27 == 115) {
                                          class38.chatboxSegments[var6++] = var28.field1132;
                                       } else {
                                          class38.field805[var5++] = var28.field1123;
                                       }
                                    }
                                    continue;
                                 }

                                 if(var27 == 115) {
                                    class38.chatboxSegments[var6++] = "null";
                                 } else {
                                    class38.field805[var5++] = 0;
                                 }
                                 continue;
                              }
                           } else {
                              int var21;
                              if(var35 < 3700) {
                                 if(var35 == 3600) {
                                    if(Client.field502 == 0) {
                                       class38.field805[var5++] = -2;
                                    } else if(Client.field502 == 1) {
                                       class38.field805[var5++] = -1;
                                    } else {
                                       class38.field805[var5++] = Client.friendCount;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3601) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(Client.field502 == 2 && var15 < Client.friendCount) {
                                       class38.chatboxSegments[var6++] = Client.friends[var15].name;
                                       class38.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var35 == 3602) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(Client.field502 == 2 && var15 < Client.friendCount) {
                                       class38.field805[var5++] = Client.friends[var15].world;
                                       continue;
                                    }

                                    class38.field805[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3603) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(Client.field502 == 2 && var15 < Client.friendCount) {
                                       class38.field805[var5++] = Client.friends[var15].rank;
                                       continue;
                                    }

                                    class38.field805[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3604) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    --var5;
                                    var27 = class38.field805[var5];
                                    ChatLineBuffer.method648(var64, var27);
                                    continue;
                                 }

                                 String var29;
                                 Ignore var59;
                                 Friend var63;
                                 String var69;
                                 if(var35 == 3605) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    if(var64 == null) {
                                       continue;
                                    }

                                    if((Client.friendCount < 200 || Client.field563 == 1) && Client.friendCount < 400) {
                                       var38 = class10.method123(var64, class127.field2087);
                                       if(var38 == null) {
                                          continue;
                                       }

                                       for(var36 = 0; var36 < Client.friendCount; ++var36) {
                                          var63 = Client.friends[var36];
                                          var69 = class10.method123(var63.name, class127.field2087);
                                          if(var69 != null && var69.equals(var38)) {
                                             class23.sendGameMessage(30, "", var64 + " is already on your friend list");
                                             continue label3535;
                                          }

                                          if(null != var63.previousName) {
                                             var29 = class10.method123(var63.previousName, class127.field2087);
                                             if(null != var29 && var29.equals(var38)) {
                                                class23.sendGameMessage(30, "", var64 + " is already on your friend list");
                                                continue label3535;
                                             }
                                          }
                                       }

                                       for(var36 = 0; var36 < Client.ignoreCount; ++var36) {
                                          var59 = Client.ignores[var36];
                                          var69 = class10.method123(var59.name, class127.field2087);
                                          if(var69 != null && var69.equals(var38)) {
                                             class23.sendGameMessage(30, "", "Please remove " + var64 + " from your ignore list first");
                                             continue label3535;
                                          }

                                          if(var59.previousName != null) {
                                             var29 = class10.method123(var59.previousName, class127.field2087);
                                             if(null != var29 && var29.equals(var38)) {
                                                class23.sendGameMessage(30, "", "Please remove " + var64 + " from your ignore list first");
                                                continue label3535;
                                             }
                                          }
                                       }

                                       if(class10.method123(class48.localPlayer.name, class127.field2087).equals(var38)) {
                                          class23.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                       } else {
                                          Client.field323.method2818(121);
                                          Client.field323.method2715(class43.method857(var64));
                                          Client.field323.method2616(var64);
                                       }
                                       continue;
                                    }

                                    class23.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                    continue;
                                 }

                                 if(var35 == 3606) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    if(var64 == null) {
                                       continue;
                                    }

                                    var38 = class10.method123(var64, class127.field2087);
                                    if(var38 == null) {
                                       continue;
                                    }

                                    var36 = 0;

                                    while(true) {
                                       if(var36 >= Client.friendCount) {
                                          continue label3535;
                                       }

                                       var63 = Client.friends[var36];
                                       var69 = var63.name;
                                       var29 = class10.method123(var69, class127.field2087);
                                       if(class107.method2356(var64, var38, var69, var29)) {
                                          --Client.friendCount;

                                          for(var21 = var36; var21 < Client.friendCount; ++var21) {
                                             Client.friends[var21] = Client.friends[var21 + 1];
                                          }

                                          Client.field472 = Client.field532;
                                          Client.field323.method2818(204);
                                          Client.field323.method2715(class43.method857(var64));
                                          Client.field323.method2616(var64);
                                          continue label3535;
                                       }

                                       ++var36;
                                    }
                                 }

                                 if(var35 == 3607) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    if(null == var64) {
                                       continue;
                                    }

                                    if((Client.ignoreCount < 100 || Client.field563 == 1) && Client.ignoreCount < 400) {
                                       var38 = class10.method123(var64, class127.field2087);
                                       if(var38 == null) {
                                          continue;
                                       }

                                       for(var36 = 0; var36 < Client.ignoreCount; ++var36) {
                                          var59 = Client.ignores[var36];
                                          var69 = class10.method123(var59.name, class127.field2087);
                                          if(var69 != null && var69.equals(var38)) {
                                             class23.sendGameMessage(31, "", var64 + " is already on your ignore list");
                                             continue label3535;
                                          }

                                          if(var59.previousName != null) {
                                             var29 = class10.method123(var59.previousName, class127.field2087);
                                             if(null != var29 && var29.equals(var38)) {
                                                class23.sendGameMessage(31, "", var64 + " is already on your ignore list");
                                                continue label3535;
                                             }
                                          }
                                       }

                                       for(var36 = 0; var36 < Client.friendCount; ++var36) {
                                          var63 = Client.friends[var36];
                                          var69 = class10.method123(var63.name, class127.field2087);
                                          if(null != var69 && var69.equals(var38)) {
                                             class23.sendGameMessage(31, "", "Please remove " + var64 + " from your friend list first");
                                             continue label3535;
                                          }

                                          if(var63.previousName != null) {
                                             var29 = class10.method123(var63.previousName, class127.field2087);
                                             if(null != var29 && var29.equals(var38)) {
                                                class23.sendGameMessage(31, "", "Please remove " + var64 + " from your friend list first");
                                                continue label3535;
                                             }
                                          }
                                       }

                                       if(class10.method123(class48.localPlayer.name, class127.field2087).equals(var38)) {
                                          class23.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                       } else {
                                          Client.field323.method2818(236);
                                          Client.field323.method2715(class43.method857(var64));
                                          Client.field323.method2616(var64);
                                       }
                                       continue;
                                    }

                                    class23.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                    continue;
                                 }

                                 if(var35 == 3608) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    class13.method161(var64);
                                    continue;
                                 }

                                 if(var35 == 3609) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    class155[] var41 = new class155[]{class155.field2312, class155.field2314, class155.field2313, class155.field2311, class155.field2320};
                                    class155[] var58 = var41;

                                    for(var18 = 0; var18 < var58.length; ++var18) {
                                       class155 var76 = var58[var18];
                                       if(var76.field2310 != -1) {
                                          int var22 = var76.field2310;
                                          String var30 = "<img=" + var22 + ">";
                                          if(var64.startsWith(var30)) {
                                             var64 = var64.substring(6 + Integer.toString(var76.field2310).length());
                                             break;
                                          }
                                       }
                                    }

                                    class38.field805[var5++] = class109.method2436(var64, false)?1:0;
                                    continue;
                                 }

                                 String var57;
                                 String[] var73;
                                 if(var35 == 3611) {
                                    if(Client.field541 != null) {
                                       var73 = class38.chatboxSegments;
                                       var27 = var6++;
                                       var57 = Client.field541;
                                       var69 = class159.method3202(class119.method2509(var57));
                                       if(null == var69) {
                                          var69 = "";
                                       }

                                       var73[var27] = var69;
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var35 == 3612) {
                                    if(null != Client.field541) {
                                       class38.field805[var5++] = class1.field25;
                                    } else {
                                       class38.field805[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3613) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(Client.field541 != null && var15 < class1.field25) {
                                       class38.chatboxSegments[var6++] = class13.clanMembers[var15].username;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var35 == 3614) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(null != Client.field541 && var15 < class1.field25) {
                                       class38.field805[var5++] = class13.clanMembers[var15].world;
                                       continue;
                                    }

                                    class38.field805[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3615) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(null != Client.field541 && var15 < class1.field25) {
                                       class38.field805[var5++] = class13.clanMembers[var15].rank;
                                       continue;
                                    }

                                    class38.field805[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3616) {
                                    class38.field805[var5++] = DecorativeObject.field1663;
                                    continue;
                                 }

                                 if(var35 == 3617) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    if(null != class13.clanMembers) {
                                       Client.field323.method2818(27);
                                       Client.field323.method2715(class43.method857(var64));
                                       Client.field323.method2616(var64);
                                    }
                                    continue;
                                 }

                                 if(var35 == 3618) {
                                    class38.field805[var5++] = class26.field636;
                                    continue;
                                 }

                                 if(var35 == 3619) {
                                    --var6;
                                    var64 = class38.chatboxSegments[var6];
                                    class38.method745(var64);
                                    continue;
                                 }

                                 if(var35 == 3620) {
                                    Client.field323.method2818(160);
                                    Client.field323.method2715(0);
                                    continue;
                                 }

                                 if(var35 == 3621) {
                                    if(Client.field502 == 0) {
                                       class38.field805[var5++] = -1;
                                    } else {
                                       class38.field805[var5++] = Client.ignoreCount;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3622) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(Client.field502 != 0 && var15 < Client.ignoreCount) {
                                       class38.chatboxSegments[var6++] = Client.ignores[var15].name;
                                       class38.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var35 == 3623) {
                                    label3324: {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       var25 = "<img=0>";
                                       if(!var64.startsWith(var25)) {
                                          var69 = "<img=1>";
                                          if(!var64.startsWith(var69)) {
                                             break label3324;
                                          }
                                       }

                                       var64 = var64.substring(7);
                                    }

                                    class38.field805[var5++] = class140.method2968(var64)?1:0;
                                    continue;
                                 }

                                 if(var35 == 3624) {
                                    --var5;
                                    var15 = class38.field805[var5];
                                    if(class13.clanMembers != null && var15 < class1.field25 && class13.clanMembers[var15].username.equalsIgnoreCase(class48.localPlayer.name)) {
                                       class38.field805[var5++] = 1;
                                       continue;
                                    }

                                    class38.field805[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3625) {
                                    if(Client.field507 != null) {
                                       var73 = class38.chatboxSegments;
                                       var27 = var6++;
                                       var57 = Client.field507;
                                       var69 = class159.method3202(class119.method2509(var57));
                                       if(null == var69) {
                                          var69 = "";
                                       }

                                       var73[var27] = var69;
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else {
                                 long var47;
                                 if(var35 < 4000) {
                                    if(var35 == 3903) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = Client.grandExchangeOffers[var15].method4014();
                                       continue;
                                    }

                                    if(var35 == 3904) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = Client.grandExchangeOffers[var15].itemId;
                                       continue;
                                    }

                                    if(var35 == 3905) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = Client.grandExchangeOffers[var15].price;
                                       continue;
                                    }

                                    if(var35 == 3906) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                       continue;
                                    }

                                    if(var35 == 3907) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                       continue;
                                    }

                                    if(var35 == 3908) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = Client.grandExchangeOffers[var15].spent;
                                       continue;
                                    }

                                    if(var35 == 3910) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var27 = Client.grandExchangeOffers[var15].method4013();
                                       class38.field805[var5++] = var27 == 0?1:0;
                                       continue;
                                    }

                                    if(var35 == 3911) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var27 = Client.grandExchangeOffers[var15].method4013();
                                       class38.field805[var5++] = var27 == 2?1:0;
                                       continue;
                                    }

                                    if(var35 == 3912) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var27 = Client.grandExchangeOffers[var15].method4013();
                                       class38.field805[var5++] = var27 == 5?1:0;
                                       continue;
                                    }

                                    if(var35 == 3913) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var27 = Client.grandExchangeOffers[var15].method4013();
                                       class38.field805[var5++] = var27 == 1?1:0;
                                       continue;
                                    }

                                    boolean var71;
                                    if(var35 == 3914) {
                                       --var5;
                                       var71 = class38.field805[var5] == 1;
                                       if(null != WidgetNode.field55) {
                                          WidgetNode.field55.method4031(class224.field3227, var71);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3915) {
                                       --var5;
                                       var71 = class38.field805[var5] == 1;
                                       if(WidgetNode.field55 != null) {
                                          WidgetNode.field55.method4031(class224.field3224, var71);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3916) {
                                       var5 -= 2;
                                       var71 = class38.field805[var5] == 1;
                                       var66 = class38.field805[1 + var5] == 1;
                                       if(null != WidgetNode.field55) {
                                          WidgetNode.field55.method4031(new class22(var66), var71);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3917) {
                                       --var5;
                                       var71 = class38.field805[var5] == 1;
                                       if(WidgetNode.field55 != null) {
                                          WidgetNode.field55.method4031(class224.field3225, var71);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3918) {
                                       --var5;
                                       var71 = class38.field805[var5] == 1;
                                       if(null != WidgetNode.field55) {
                                          WidgetNode.field55.method4031(class224.field3228, var71);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3919) {
                                       class38.field805[var5++] = WidgetNode.field55 == null?0:WidgetNode.field55.field3226.size();
                                       continue;
                                    }

                                    class217 var46;
                                    if(var35 == 3920) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       class38.field805[var5++] = var46.field3204;
                                       continue;
                                    }

                                    if(var35 == 3921) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       class38.chatboxSegments[var6++] = var46.method3969();
                                       continue;
                                    }

                                    if(var35 == 3922) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       class38.chatboxSegments[var6++] = var46.method3967();
                                       continue;
                                    }

                                    if(var35 == 3923) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       var47 = class34.method713() - class53.field1137 - var46.field3206;
                                       var19 = (int)(var47 / 3600000L);
                                       var20 = (int)((var47 - (long)(3600000 * var19)) / 60000L);
                                       var21 = (int)((var47 - (long)(3600000 * var19) - (long)('\uea60' * var20)) / 1000L);
                                       String var31 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                       class38.chatboxSegments[var6++] = var31;
                                       continue;
                                    }

                                    if(var35 == 3924) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       class38.field805[var5++] = var46.field3203.totalQuantity;
                                       continue;
                                    }

                                    if(var35 == 3925) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       class38.field805[var5++] = var46.field3203.price;
                                       continue;
                                    }

                                    if(var35 == 3926) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var46 = (class217)WidgetNode.field55.field3226.get(var15);
                                       class38.field805[var5++] = var46.field3203.itemId;
                                       continue;
                                    }
                                 } else if(var35 < 4100) {
                                    if(var35 == 4000) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[1 + var5];
                                       class38.field805[var5++] = var27 + var15;
                                       continue;
                                    }

                                    if(var35 == 4001) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[1 + var5];
                                       class38.field805[var5++] = var15 - var27;
                                       continue;
                                    }

                                    if(var35 == 4002) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[1 + var5];
                                       class38.field805[var5++] = var15 * var27;
                                       continue;
                                    }

                                    if(var35 == 4003) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[1 + var5];
                                       class38.field805[var5++] = var15 / var27;
                                       continue;
                                    }

                                    if(var35 == 4004) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = (int)(Math.random() * (double)var15);
                                       continue;
                                    }

                                    if(var35 == 4005) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = (int)(Math.random() * (double)(1 + var15));
                                       continue;
                                    }

                                    if(var35 == 4006) {
                                       var5 -= 5;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       var36 = class38.field805[2 + var5];
                                       var18 = class38.field805[var5 + 3];
                                       var19 = class38.field805[4 + var5];
                                       class38.field805[var5++] = var15 + (var19 - var36) * (var27 - var15) / (var18 - var36);
                                       continue;
                                    }

                                    if(var35 == 4007) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = var15 + var15 * var27 / 100;
                                       continue;
                                    }

                                    if(var35 == 4008) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = var15 | 1 << var27;
                                       continue;
                                    }

                                    if(var35 == 4009) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = var15 & -1 - (1 << var27);
                                       continue;
                                    }

                                    if(var35 == 4010) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = (var15 & 1 << var27) != 0?1:0;
                                       continue;
                                    }

                                    if(var35 == 4011) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = var15 % var27;
                                       continue;
                                    }

                                    if(var35 == 4012) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       if(var15 == 0) {
                                          class38.field805[var5++] = 0;
                                       } else {
                                          class38.field805[var5++] = (int)Math.pow((double)var15, (double)var27);
                                       }
                                       continue;
                                    }

                                    if(var35 == 4013) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       if(var15 == 0) {
                                          class38.field805[var5++] = 0;
                                       } else if(var27 == 0) {
                                          class38.field805[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class38.field805[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var27);
                                       }
                                       continue;
                                    }

                                    if(var35 == 4014) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = var15 & var27;
                                       continue;
                                    }

                                    if(var35 == 4015) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       class38.field805[var5++] = var15 | var27;
                                       continue;
                                    }

                                    if(var35 == 4018) {
                                       var5 -= 3;
                                       long var81 = (long)class38.field805[var5];
                                       var47 = (long)class38.field805[var5 + 1];
                                       long var40 = (long)class38.field805[2 + var5];
                                       class38.field805[var5++] = (int)(var81 * var40 / var47);
                                       continue;
                                    }
                                 } else if(var35 < 4200) {
                                    if(var35 == 4100) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       --var5;
                                       var27 = class38.field805[var5];
                                       class38.chatboxSegments[var6++] = var64 + var27;
                                       continue;
                                    }

                                    if(var35 == 4101) {
                                       var6 -= 2;
                                       var64 = class38.chatboxSegments[var6];
                                       var38 = class38.chatboxSegments[1 + var6];
                                       class38.chatboxSegments[var6++] = var64 + var38;
                                       continue;
                                    }

                                    if(var35 == 4102) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       --var5;
                                       var27 = class38.field805[var5];
                                       class38.chatboxSegments[var6++] = var64 + class12.method147(var27, true);
                                       continue;
                                    }

                                    if(var35 == 4103) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = var64.toLowerCase();
                                       continue;
                                    }

                                    if(var35 == 4104) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       long var86 = 86400000L * ((long)var15 + 11745L);
                                       class38.field810.setTime(new Date(var86));
                                       var18 = class38.field810.get(5);
                                       var19 = class38.field810.get(2);
                                       var20 = class38.field810.get(1);
                                       class38.chatboxSegments[var6++] = var18 + "-" + class38.field801[var19] + "-" + var20;
                                       continue;
                                    }

                                    if(var35 == 4105) {
                                       var6 -= 2;
                                       var64 = class38.chatboxSegments[var6];
                                       var38 = class38.chatboxSegments[var6 + 1];
                                       if(class48.localPlayer.composition != null && class48.localPlayer.composition.isFemale) {
                                          class38.chatboxSegments[var6++] = var38;
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = var64;
                                       continue;
                                    }

                                    if(var35 == 4106) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.chatboxSegments[var6++] = Integer.toString(var15);
                                       continue;
                                    }

                                    if(var35 == 4107) {
                                       var6 -= 2;
                                       int[] var83 = class38.field805;
                                       var27 = var5++;
                                       var18 = BufferProvider.method1724(class38.chatboxSegments[var6], class38.chatboxSegments[1 + var6], Client.field281);
                                       if(var18 > 0) {
                                          var56 = 1;
                                       } else if(var18 < 0) {
                                          var56 = -1;
                                       } else {
                                          var56 = 0;
                                       }

                                       var83[var27] = var56;
                                       continue;
                                    }

                                    byte[] var70;
                                    class227 var78;
                                    if(var35 == 4108) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var27 = class38.field805[var5];
                                       var36 = class38.field805[1 + var5];
                                       var70 = Client.field311.method3290(var36, 0);
                                       var78 = new class227(var70);
                                       class38.field805[var5++] = var78.method4041(var64, var27);
                                       continue;
                                    }

                                    if(var35 == 4109) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var27 = class38.field805[var5];
                                       var36 = class38.field805[1 + var5];
                                       var70 = Client.field311.method3290(var36, 0);
                                       var78 = new class227(var70);
                                       class38.field805[var5++] = var78.method4040(var64, var27);
                                       continue;
                                    }

                                    if(var35 == 4110) {
                                       var6 -= 2;
                                       var64 = class38.chatboxSegments[var6];
                                       var38 = class38.chatboxSegments[var6 + 1];
                                       --var5;
                                       if(class38.field805[var5] == 1) {
                                          class38.chatboxSegments[var6++] = var64;
                                       } else {
                                          class38.chatboxSegments[var6++] = var38;
                                       }
                                       continue;
                                    }

                                    if(var35 == 4111) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = class226.method4082(var64);
                                       continue;
                                    }

                                    if(var35 == 4112) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       --var5;
                                       var27 = class38.field805[var5];
                                       class38.chatboxSegments[var6++] = var64 + (char)var27;
                                       continue;
                                    }

                                    if(var35 == 4113) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = method3200((char)var15)?1:0;
                                       continue;
                                    }

                                    if(var35 == 4114) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = class139.method2942((char)var15)?1:0;
                                       continue;
                                    }

                                    char var42;
                                    if(var35 == 4115) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var50 = class38.field805;
                                       var36 = var5++;
                                       var42 = (char)var15;
                                       var44 = var42 >= 65 && var42 <= 90 || var42 >= 97 && var42 <= 122;
                                       var50[var36] = var44?1:0;
                                       continue;
                                    }

                                    if(var35 == 4116) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = class165.method3223((char)var15)?1:0;
                                       continue;
                                    }

                                    if(var35 == 4117) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       if(null != var64) {
                                          class38.field805[var5++] = var64.length();
                                       } else {
                                          class38.field805[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var35 == 4118) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var27 = class38.field805[var5];
                                       var36 = class38.field805[var5 + 1];
                                       class38.chatboxSegments[var6++] = var64.substring(var27, var36);
                                       continue;
                                    }

                                    if(var35 == 4119) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       StringBuilder var49 = new StringBuilder(var64.length());
                                       var17 = false;

                                       for(var18 = 0; var18 < var64.length(); ++var18) {
                                          var42 = var64.charAt(var18);
                                          if(var42 == 60) {
                                             var17 = true;
                                          } else if(var42 == 62) {
                                             var17 = false;
                                          } else if(!var17) {
                                             var49.append(var42);
                                          }
                                       }

                                       class38.chatboxSegments[var6++] = var49.toString();
                                       continue;
                                    }

                                    if(var35 == 4120) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       --var5;
                                       var27 = class38.field805[var5];
                                       class38.field805[var5++] = var64.indexOf(var27);
                                       continue;
                                    }

                                    if(var35 == 4121) {
                                       var6 -= 2;
                                       var64 = class38.chatboxSegments[var6];
                                       var38 = class38.chatboxSegments[1 + var6];
                                       --var5;
                                       var36 = class38.field805[var5];
                                       class38.field805[var5++] = var64.indexOf(var38, var36);
                                       continue;
                                    }
                                 } else if(var35 < 4300) {
                                    if(var35 == 4200) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.chatboxSegments[var6++] = MessageNode.getItemDefinition(var15).name;
                                       continue;
                                    }

                                    ItemComposition var60;
                                    if(var35 == 4201) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       var60 = MessageNode.getItemDefinition(var15);
                                       if(var27 >= 1 && var27 <= 5 && null != var60.groundActions[var27 - 1]) {
                                          class38.chatboxSegments[var6++] = var60.groundActions[var27 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var35 == 4202) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       var60 = MessageNode.getItemDefinition(var15);
                                       if(var27 >= 1 && var27 <= 5 && var60.inventoryActions[var27 - 1] != null) {
                                          class38.chatboxSegments[var6++] = var60.inventoryActions[var27 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var35 == 4203) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = MessageNode.getItemDefinition(var15).price;
                                       continue;
                                    }

                                    if(var35 == 4204) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = MessageNode.getItemDefinition(var15).isStackable == 1?1:0;
                                       continue;
                                    }

                                    ItemComposition var53;
                                    if(var35 == 4205) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var53 = MessageNode.getItemDefinition(var15);
                                       if(var53.field1195 == -1 && var53.note >= 0) {
                                          class38.field805[var5++] = var53.note;
                                          continue;
                                       }

                                       class38.field805[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4206) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var53 = MessageNode.getItemDefinition(var15);
                                       if(var53.field1195 >= 0 && var53.note >= 0) {
                                          class38.field805[var5++] = var53.note;
                                          continue;
                                       }

                                       class38.field805[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4207) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = MessageNode.getItemDefinition(var15).isMembers?1:0;
                                       continue;
                                    }

                                    if(var35 == 4208) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var53 = MessageNode.getItemDefinition(var15);
                                       if(var53.field1206 == -1 && var53.field1205 >= 0) {
                                          class38.field805[var5++] = var53.field1205;
                                          continue;
                                       }

                                       class38.field805[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4209) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var53 = MessageNode.getItemDefinition(var15);
                                       if(var53.field1206 >= 0 && var53.field1205 >= 0) {
                                          class38.field805[var5++] = var53.field1205;
                                          continue;
                                       }

                                       class38.field805[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4210) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       --var5;
                                       var27 = class38.field805[var5];
                                       class4.method49(var64, var27 == 1);
                                       class38.field805[var5++] = class20.field566;
                                       continue;
                                    }

                                    if(var35 == 4211) {
                                       if(null != class92.field1611 && DecorativeObject.field1666 < class20.field566) {
                                          class38.field805[var5++] = class92.field1611[++DecorativeObject.field1666 - 1] & '\uffff';
                                          continue;
                                       }

                                       class38.field805[var5++] = -1;
                                       continue;
                                    }

                                    if(var35 == 4212) {
                                       DecorativeObject.field1666 = 0;
                                       continue;
                                    }
                                 } else if(var35 < 5100) {
                                    if(var35 == 5000) {
                                       class38.field805[var5++] = Client.field442;
                                       continue;
                                    }

                                    if(var35 == 5001) {
                                       var5 -= 3;
                                       Client.field442 = class38.field805[var5];
                                       class8.field142 = WallObject.method2123(class38.field805[var5 + 1]);
                                       if(null == class8.field142) {
                                          class8.field142 = class133.field2110;
                                       }

                                       Client.field322 = class38.field805[var5 + 2];
                                       Client.field323.method2818(59);
                                       Client.field323.method2715(Client.field442);
                                       Client.field323.method2715(class8.field142.field2107);
                                       Client.field323.method2715(Client.field322);
                                       continue;
                                    }

                                    if(var35 == 5002) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var27 = class38.field805[var5];
                                       var36 = class38.field805[1 + var5];
                                       Client.field323.method2818(167);
                                       Client.field323.method2715(class43.method857(var64) + 2);
                                       Client.field323.method2616(var64);
                                       Client.field323.method2715(var27 - 1);
                                       Client.field323.method2715(var36);
                                       continue;
                                    }

                                    if(var35 == 5003) {
                                       var5 -= 2;
                                       var15 = class38.field805[var5];
                                       var27 = class38.field805[var5 + 1];
                                       ChatLineBuffer var72 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var15));
                                       MessageNode var65 = var72.method634(var27);
                                       if(null != var65) {
                                          class38.field805[var5++] = var65.id;
                                          class38.field805[var5++] = var65.tick;
                                          class38.chatboxSegments[var6++] = null != var65.name?var65.name:"";
                                          class38.chatboxSegments[var6++] = var65.sender != null?var65.sender:"";
                                          class38.chatboxSegments[var6++] = var65.value != null?var65.value:"";
                                       } else {
                                          class38.field805[var5++] = -1;
                                          class38.field805[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var35 == 5004) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       MessageNode var61 = GroundObject.method2218(var15);
                                       if(var61 != null) {
                                          class38.field805[var5++] = var61.type;
                                          class38.field805[var5++] = var61.tick;
                                          class38.chatboxSegments[var6++] = null != var61.name?var61.name:"";
                                          class38.chatboxSegments[var6++] = var61.sender != null?var61.sender:"";
                                          class38.chatboxSegments[var6++] = null != var61.value?var61.value:"";
                                       } else {
                                          class38.field805[var5++] = -1;
                                          class38.field805[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var35 == 5005) {
                                       if(null == class8.field142) {
                                          class38.field805[var5++] = -1;
                                       } else {
                                          class38.field805[var5++] = class8.field142.field2107;
                                       }
                                       continue;
                                    }

                                    if(var35 == 5008) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       --var5;
                                       var27 = class38.field805[var5];
                                       var25 = var64.toLowerCase();
                                       byte var48 = 0;
                                       if(var25.startsWith("yellow:")) {
                                          var48 = 0;
                                          var64 = var64.substring("yellow:".length());
                                       } else if(var25.startsWith("red:")) {
                                          var48 = 1;
                                          var64 = var64.substring("red:".length());
                                       } else if(var25.startsWith("green:")) {
                                          var48 = 2;
                                          var64 = var64.substring("green:".length());
                                       } else if(var25.startsWith("cyan:")) {
                                          var48 = 3;
                                          var64 = var64.substring("cyan:".length());
                                       } else if(var25.startsWith("purple:")) {
                                          var48 = 4;
                                          var64 = var64.substring("purple:".length());
                                       } else if(var25.startsWith("white:")) {
                                          var48 = 5;
                                          var64 = var64.substring("white:".length());
                                       } else if(var25.startsWith("flash1:")) {
                                          var48 = 6;
                                          var64 = var64.substring("flash1:".length());
                                       } else if(var25.startsWith("flash2:")) {
                                          var48 = 7;
                                          var64 = var64.substring("flash2:".length());
                                       } else if(var25.startsWith("flash3:")) {
                                          var48 = 8;
                                          var64 = var64.substring("flash3:".length());
                                       } else if(var25.startsWith("glow1:")) {
                                          var48 = 9;
                                          var64 = var64.substring("glow1:".length());
                                       } else if(var25.startsWith("glow2:")) {
                                          var48 = 10;
                                          var64 = var64.substring("glow2:".length());
                                       } else if(var25.startsWith("glow3:")) {
                                          var48 = 11;
                                          var64 = var64.substring("glow3:".length());
                                       } else if(Client.field281 != 0) {
                                          if(var25.startsWith("yellow:")) {
                                             var48 = 0;
                                             var64 = var64.substring("yellow:".length());
                                          } else if(var25.startsWith("red:")) {
                                             var48 = 1;
                                             var64 = var64.substring("red:".length());
                                          } else if(var25.startsWith("green:")) {
                                             var48 = 2;
                                             var64 = var64.substring("green:".length());
                                          } else if(var25.startsWith("cyan:")) {
                                             var48 = 3;
                                             var64 = var64.substring("cyan:".length());
                                          } else if(var25.startsWith("purple:")) {
                                             var48 = 4;
                                             var64 = var64.substring("purple:".length());
                                          } else if(var25.startsWith("white:")) {
                                             var48 = 5;
                                             var64 = var64.substring("white:".length());
                                          } else if(var25.startsWith("flash1:")) {
                                             var48 = 6;
                                             var64 = var64.substring("flash1:".length());
                                          } else if(var25.startsWith("flash2:")) {
                                             var48 = 7;
                                             var64 = var64.substring("flash2:".length());
                                          } else if(var25.startsWith("flash3:")) {
                                             var48 = 8;
                                             var64 = var64.substring("flash3:".length());
                                          } else if(var25.startsWith("glow1:")) {
                                             var48 = 9;
                                             var64 = var64.substring("glow1:".length());
                                          } else if(var25.startsWith("glow2:")) {
                                             var48 = 10;
                                             var64 = var64.substring("glow2:".length());
                                          } else if(var25.startsWith("glow3:")) {
                                             var48 = 11;
                                             var64 = var64.substring("glow3:".length());
                                          }
                                       }

                                       var25 = var64.toLowerCase();
                                       byte var45 = 0;
                                       if(var25.startsWith("wave:")) {
                                          var45 = 1;
                                          var64 = var64.substring("wave:".length());
                                       } else if(var25.startsWith("wave2:")) {
                                          var45 = 2;
                                          var64 = var64.substring("wave2:".length());
                                       } else if(var25.startsWith("shake:")) {
                                          var45 = 3;
                                          var64 = var64.substring("shake:".length());
                                       } else if(var25.startsWith("scroll:")) {
                                          var45 = 4;
                                          var64 = var64.substring("scroll:".length());
                                       } else if(var25.startsWith("slide:")) {
                                          var45 = 5;
                                          var64 = var64.substring("slide:".length());
                                       } else if(Client.field281 != 0) {
                                          if(var25.startsWith("wave:")) {
                                             var45 = 1;
                                             var64 = var64.substring("wave:".length());
                                          } else if(var25.startsWith("wave2:")) {
                                             var45 = 2;
                                             var64 = var64.substring("wave2:".length());
                                          } else if(var25.startsWith("shake:")) {
                                             var45 = 3;
                                             var64 = var64.substring("shake:".length());
                                          } else if(var25.startsWith("scroll:")) {
                                             var45 = 4;
                                             var64 = var64.substring("scroll:".length());
                                          } else if(var25.startsWith("slide:")) {
                                             var45 = 5;
                                             var64 = var64.substring("slide:".length());
                                          }
                                       }

                                       Client.field323.method2818(26);
                                       Client.field323.method2715(0);
                                       var20 = Client.field323.offset;
                                       Client.field323.method2715(var27);
                                       Client.field323.method2715(var48);
                                       Client.field323.method2715(var45);
                                       class48.method992(Client.field323, var64);
                                       Client.field323.method2553(Client.field323.offset - var20);
                                       continue;
                                    }

                                    if(var35 == 5009) {
                                       var6 -= 2;
                                       var64 = class38.chatboxSegments[var6];
                                       var38 = class38.chatboxSegments[var6 + 1];
                                       Client.field323.method2818(202);
                                       Client.field323.method2542(0);
                                       var36 = Client.field323.offset;
                                       Client.field323.method2616(var64);
                                       class48.method992(Client.field323, var38);
                                       Client.field323.method2552(Client.field323.offset - var36);
                                       continue;
                                    }

                                    if(var35 == 5015) {
                                       if(null != class48.localPlayer && null != class48.localPlayer.name) {
                                          var64 = class48.localPlayer.name;
                                       } else {
                                          var64 = "";
                                       }

                                       class38.chatboxSegments[var6++] = var64;
                                       continue;
                                    }

                                    if(var35 == 5016) {
                                       class38.field805[var5++] = Client.field322;
                                       continue;
                                    }

                                    if(var35 == 5017) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = class9.method122(var15);
                                       continue;
                                    }

                                    if(var35 == 5018) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       class38.field805[var5++] = class93.method2129(var15);
                                       continue;
                                    }

                                    if(var35 == 5019) {
                                       --var5;
                                       var15 = class38.field805[var5];
                                       var50 = class38.field805;
                                       var36 = var5++;
                                       MessageNode var79 = (MessageNode)class11.field164.method3839((long)var15);
                                       if(null == var79) {
                                          var18 = -1;
                                       } else if(var79.next == class11.field165.field3157) {
                                          var18 = -1;
                                       } else {
                                          var18 = ((MessageNode)var79.next).id;
                                       }

                                       var50[var36] = var18;
                                       continue;
                                    }

                                    if(var35 == 5020) {
                                       --var6;
                                       var64 = class38.chatboxSegments[var6];
                                       if(var64.equalsIgnoreCase("toggleroof")) {
                                          class161.field2659.field145 = !class161.field2659.field145;
                                          class5.method80();
                                          if(class161.field2659.field145) {
                                             class23.sendGameMessage(99, "", "Roofs are now all hidden");
                                          } else {
                                             class23.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                          }
                                       }

                                       if(var64.equalsIgnoreCase("displayfps")) {
                                          Client.field296 = !Client.field296;
                                       }

                                       if(Client.field312 >= 2) {
                                          if(var64.equalsIgnoreCase("fpson")) {
                                             Client.field296 = true;
                                          }

                                          if(var64.equalsIgnoreCase("fpsoff")) {
                                             Client.field296 = false;
                                          }

                                          if(var64.equalsIgnoreCase("gc")) {
                                             System.gc();
                                          }

                                          if(var64.equalsIgnoreCase("clientdrop")) {
                                             if(Client.field440 > 0) {
                                                class144.method3029();
                                             } else {
                                                class130.setGameState(40);
                                                class62.field1259 = Item.field694;
                                                Item.field694 = null;
                                             }
                                          }

                                          if(var64.equalsIgnoreCase("errortest") && Client.field560 == 2) {
                                             throw new RuntimeException();
                                          }
                                       }

                                       Client.field323.method2818(201);
                                       Client.field323.method2715(var64.length() + 1);
                                       Client.field323.method2616(var64);
                                       continue;
                                    }

                                    if(var35 == 5021) {
                                       --var6;
                                       Client.field499 = class38.chatboxSegments[var6].toLowerCase().trim();
                                       continue;
                                    }

                                    if(var35 == 5022) {
                                       class38.chatboxSegments[var6++] = Client.field499;
                                       continue;
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        if(var35 >= 2000) {
                           var35 -= 1000;
                           --var5;
                           var24 = World.method628(class38.field805[var5]);
                        } else {
                           var24 = var43?class38.field807:class153.field2306;
                        }

                        class75.method1606(var24);
                        if(var35 == 1200 || var35 == 1205 || var35 == 1212) {
                           var5 -= 2;
                           var27 = class38.field805[var5];
                           var36 = class38.field805[var5 + 1];
                           var24.item = var27;
                           var24.stackSize = var36;
                           ItemComposition var26 = MessageNode.getItemDefinition(var27);
                           var24.rotationX = var26.field1167;
                           var24.rotationZ = var26.field1171;
                           var24.rotationY = var26.field1203;
                           var24.field2873 = var26.field1158;
                           var24.field2860 = var26.field1168;
                           var24.field2864 = var26.field1169;
                           if(var35 == 1205) {
                              var24.field2942 = 0;
                           } else if(var35 == 1212 | var26.isStackable == 1) {
                              var24.field2942 = 1;
                           } else {
                              var24.field2942 = 2;
                           }

                           if(var24.field2929 > 0) {
                              var24.field2864 = var24.field2864 * 32 / var24.field2929;
                           } else if(var24.field2884 > 0) {
                              var24.field2864 = var24.field2864 * 32 / var24.field2884;
                           }
                           continue;
                        }

                        if(var35 == 1201) {
                           var24.modelType = 2;
                           --var5;
                           var24.modelId = class38.field805[var5];
                           continue;
                        }

                        if(var35 == 1202) {
                           var24.modelType = 3;
                           var24.modelId = class48.localPlayer.composition.method3505();
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var35 >= 2000) {
                        var35 -= 1000;
                        --var5;
                        var15 = class38.field805[var5];
                        var16 = World.method628(var15);
                     } else {
                        var16 = var43?class38.field807:class153.field2306;
                     }

                     if(var35 == 1000) {
                        var5 -= 4;
                        var16.field2819 = class38.field805[var5];
                        var16.field2820 = class38.field805[1 + var5];
                        var16.field2909 = class38.field805[2 + var5];
                        var16.field2920 = class38.field805[var5 + 3];
                        class75.method1606(var16);
                        class16.method189(var16);
                        if(var15 != -1 && var16.type == 0) {
                           class21.method554(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var35 == 1001) {
                        var5 -= 4;
                        var16.field2884 = class38.field805[var5];
                        var16.field2822 = class38.field805[var5 + 1];
                        var16.field2810 = class38.field805[2 + var5];
                        var16.field2818 = class38.field805[3 + var5];
                        class75.method1606(var16);
                        class16.method189(var16);
                        if(var15 != -1 && var16.type == 0) {
                           class21.method554(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var35 == 1003) {
                        --var5;
                        var17 = class38.field805[var5] == 1;
                        if(var16.isHidden != var17) {
                           var16.isHidden = var17;
                           class75.method1606(var16);
                        }
                        continue;
                     }

                     if(var35 == 1005) {
                        --var5;
                        var16.field2943 = class38.field805[var5] == 1;
                        continue;
                     }

                     if(var35 == 1006) {
                        --var5;
                        var16.field2944 = class38.field805[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var35 < 5400) {
                  if(var35 == 5306) {
                     class38.field805[var5++] = class92.method2124();
                     continue;
                  }

                  if(var35 == 5307) {
                     --var5;
                     var15 = class38.field805[var5];
                     if(var15 == 1 || var15 == 2) {
                        class14.method167(var15);
                     }
                     continue;
                  }

                  if(var35 == 5308) {
                     class38.field805[var5++] = class161.field2659.field133;
                     continue;
                  }

                  if(var35 == 5309) {
                     --var5;
                     var15 = class38.field805[var5];
                     if(var15 == 1 || var15 == 2) {
                        class161.field2659.field133 = var15;
                        class5.method80();
                     }
                     continue;
                  }
               }

               if(var35 < 5600) {
                  if(var35 == 5504) {
                     var5 -= 2;
                     var15 = class38.field805[var5];
                     var27 = class38.field805[var5 + 1];
                     if(!Client.field418) {
                        Client.field365 = var15;
                        Client.mapAngle = var27;
                     }
                     continue;
                  }

                  if(var35 == 5505) {
                     class38.field805[var5++] = Client.field365;
                     continue;
                  }

                  if(var35 == 5506) {
                     class38.field805[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var35 == 5530) {
                     --var5;
                     var15 = class38.field805[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field371 = var15;
                     continue;
                  }

                  if(var35 == 5531) {
                     class38.field805[var5++] = Client.field371;
                     continue;
                  }
               }

               if(var35 < 5700 && var35 == 5630) {
                  Client.field440 = 250;
               } else {
                  if(var35 < 6300) {
                     if(var35 == 6200) {
                        var5 -= 2;
                        Client.field498 = (short)class38.field805[var5];
                        if(Client.field498 <= 0) {
                           Client.field498 = 256;
                        }

                        Client.field331 = (short)class38.field805[1 + var5];
                        if(Client.field331 <= 0) {
                           Client.field331 = 205;
                        }
                        continue;
                     }

                     if(var35 == 6201) {
                        var5 -= 2;
                        Client.field392 = (short)class38.field805[var5];
                        if(Client.field392 <= 0) {
                           Client.field392 = 256;
                        }

                        Client.field537 = (short)class38.field805[var5 + 1];
                        if(Client.field537 <= 0) {
                           Client.field537 = 320;
                        }
                        continue;
                     }

                     if(var35 == 6202) {
                        var5 -= 4;
                        Client.field538 = (short)class38.field805[var5];
                        if(Client.field538 <= 0) {
                           Client.field538 = 1;
                        }

                        Client.field539 = (short)class38.field805[1 + var5];
                        if(Client.field539 <= 0) {
                           Client.field539 = 32767;
                        } else if(Client.field539 < Client.field538) {
                           Client.field539 = Client.field538;
                        }

                        Client.field540 = (short)class38.field805[2 + var5];
                        if(Client.field540 <= 0) {
                           Client.field540 = 1;
                        }

                        Client.field284 = (short)class38.field805[3 + var5];
                        if(Client.field284 <= 0) {
                           Client.field284 = 32767;
                        } else if(Client.field284 < Client.field540) {
                           Client.field284 = Client.field540;
                        }
                        continue;
                     }

                     if(var35 == 6203) {
                        if(Client.field463 != null) {
                           class9.method119(0, 0, Client.field463.width, Client.field463.height, false);
                           class38.field805[var5++] = Client.camera2;
                           class38.field805[var5++] = Client.camera3;
                        } else {
                           class38.field805[var5++] = -1;
                           class38.field805[var5++] = -1;
                        }
                        continue;
                     }

                     if(var35 == 6204) {
                        class38.field805[var5++] = Client.field392;
                        class38.field805[var5++] = Client.field537;
                        continue;
                     }

                     if(var35 == 6205) {
                        class38.field805[var5++] = Client.field498;
                        class38.field805[var5++] = Client.field331;
                        continue;
                     }
                  }

                  if(var35 < 6600) {
                     if(var35 == 6500) {
                        class38.field805[var5++] = class114.loadWorlds()?1:0;
                        continue;
                     }

                     World var68;
                     if(var35 == 6501) {
                        World.field656 = 0;
                        if(World.field656 < World.field646) {
                           var68 = class35.worldList[++World.field656 - 1];
                        } else {
                           var16 = null;
                        }

                        Object var89 = null;
                        class38.field805[var5++] = -1;
                        class38.field805[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field805[var5++] = 0;
                        class38.field805[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }

                     if(var35 == 6502) {
                        if(World.field656 < World.field646) {
                           World var87 = class35.worldList[++World.field656 - 1];
                        } else {
                           var24 = null;
                        }

                        class38.field805[var5++] = -1;
                        class38.field805[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field805[var5++] = 0;
                        class38.field805[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }

                     if(var35 == 6506) {
                        --var5;
                        var15 = class38.field805[var5];
                        var68 = null;

                        for(var36 = 0; var36 < World.field646; ++var36) {
                           if(class35.worldList[var36].id == var15) {
                              var68 = class35.worldList[var36];
                              break;
                           }
                        }

                        if(var68 != null) {
                           class38.field805[var5++] = var68.id;
                           class38.field805[var5++] = var68.mask;
                           class38.chatboxSegments[var6++] = var68.activity;
                           class38.field805[var5++] = var68.location;
                           class38.field805[var5++] = var68.playerCount;
                           class38.chatboxSegments[var6++] = var68.address;
                        } else {
                           class38.field805[var5++] = -1;
                           class38.field805[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field805[var5++] = 0;
                           class38.field805[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var35 == 6507) {
                        var5 -= 4;
                        var15 = class38.field805[var5];
                        var66 = class38.field805[1 + var5] == 1;
                        var36 = class38.field805[2 + var5];
                        var44 = class38.field805[3 + var5] == 1;
                        if(class35.worldList != null) {
                           class177.method3471(0, class35.worldList.length - 1, var15, var66, var36, var44);
                        }
                        continue;
                     }

                     if(var35 == 6511) {
                        --var5;
                        var15 = class38.field805[var5];
                        if(var15 >= 0 && var15 < World.field646) {
                           var68 = class35.worldList[var15];
                           class38.field805[var5++] = var68.id;
                           class38.field805[var5++] = var68.mask;
                           class38.chatboxSegments[var6++] = var68.activity;
                           class38.field805[var5++] = var68.location;
                           class38.field805[var5++] = var68.playerCount;
                           class38.chatboxSegments[var6++] = var68.address;
                           continue;
                        }

                        class38.field805[var5++] = -1;
                        class38.field805[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field805[var5++] = 0;
                        class38.field805[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var34) {
            StringBuilder var33 = new StringBuilder(30);
            var33.append("").append(var4.hash).append(" ");

            for(var13 = class38.field802 - 1; var13 >= 0; --var13) {
               var33.append("").append(class38.field808[var13].field203.hash).append(" ");
            }

            var33.append("").append(var10);
            class107.method2357(var33.toString(), var34);
         }
      }
   }
}

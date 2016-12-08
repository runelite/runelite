import java.net.URL;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("b")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("m")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("o")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -433104747
   )
   static int field121;

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1879430011"
   )
   static boolean method150(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class162.method3013(var0, Friend.field155);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class162.method3013(var3.name, Friend.field155))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class162.method3013(var3.previousName, Friend.field155))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "990646869"
   )
   static boolean method159(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1799.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class100.method1901(class114.field1800, var2, new Object[]{(new URL(class114.field1800.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1800.getAppletContext().showDocument(new URL(class114.field1800.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method1902(class114.field1800, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class114.field1800.getAppletContext().showDocument(new URL(class114.field1800.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1672052053"
   )
   public static int method161(int var0) {
      class194 var2 = (class194)class194.field2847.get((long)var0);
      class194 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = class194.field2851.method3203(14, var0);
         var2 = new class194();
         if(null != var7) {
            var2.method3452(new Buffer(var7));
         }

         class194.field2847.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.field2850;
      int var4 = var1.field2849;
      int var5 = var1.field2846;
      int var6 = class165.field2176[var5 - var4];
      return class165.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass18;IB)V",
      garbageValue = "18"
   )
   static void method162(class18 var0, int var1) {
      Object[] var2 = var0.field203;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = class11.method145(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field950;
         int[] var9 = var4.field948;
         byte var10 = -1;
         class32.field734 = 0;

         int var13;
         try {
            class32.field739 = new int[var4.field952];
            int var11 = 0;
            class32.field731 = new String[var4.field947];
            int var12 = 0;

            int var14;
            String var28;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field195;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field194;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field193 != null?var0.field193.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field197;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field193 != null?var0.field193.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field198?var0.field198.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field198?var0.field198.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field199;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field200;
                  }

                  class32.field739[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var28 = (String)var2[var13];
                  if(var28.equals("event_opbase")) {
                     var28 = var0.field201;
                  }

                  class32.field731[var12++] = var28;
               }
            }

            var13 = 0;
            class32.field733 = var0.field202;

            label3895:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var42 = var8[var7];
               int var15;
               int[] var16;
               int var10001;
               int var19;
               int var20;
               int var21;
               int var29;
               int var31;
               byte[] var61;
               byte var105;
               String var106;
               if(var42 < 100) {
                  if(var42 == 0) {
                     class32.field732[var5++] = var9[var7];
                     continue;
                  }

                  if(var42 == 1) {
                     var14 = var9[var7];
                     class32.field732[var5++] = class165.widgetSettings[var14];
                     continue;
                  }

                  if(var42 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class165.widgetSettings[var14] = class32.field732[var5];
                     class10.method143(var14);
                     continue;
                  }

                  if(var42 == 3) {
                     class32.chatboxSegments[var6++] = var4.field949[var7];
                     continue;
                  }

                  if(var42 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var42 == 7) {
                     var5 -= 2;
                     if(class32.field732[var5 + 1] != class32.field732[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 8) {
                     var5 -= 2;
                     if(class32.field732[1 + var5] == class32.field732[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 9) {
                     var5 -= 2;
                     if(class32.field732[var5] < class32.field732[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 10) {
                     var5 -= 2;
                     if(class32.field732[var5] > class32.field732[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 21) {
                     if(class32.field734 == 0) {
                        return;
                     }

                     class11 var77 = class32.field735[--class32.field734];
                     var4 = var77.field113;
                     var8 = var4.field950;
                     var9 = var4.field948;
                     var7 = var77.field109;
                     class32.field739 = var77.field110;
                     class32.field731 = var77.field111;
                     continue;
                  }

                  if(var42 == 25) {
                     var14 = var9[var7];
                     class32.field732[var5++] = method161(var14);
                     continue;
                  }

                  if(var42 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field732[var5];
                     class194 var68 = (class194)class194.field2847.get((long)var14);
                     class194 var78;
                     if(var68 != null) {
                        var78 = var68;
                     } else {
                        var61 = class194.field2851.method3203(14, var14);
                        var68 = new class194();
                        if(var61 != null) {
                           var68.method3452(new Buffer(var61));
                        }

                        class194.field2847.put(var68, (long)var14);
                        var78 = var68;
                     }

                     var29 = var78.field2850;
                     var19 = var78.field2849;
                     var20 = var78.field2846;
                     var21 = class165.field2176[var20 - var19];
                     if(var15 < 0 || var15 > var21) {
                        var15 = 0;
                     }

                     var21 <<= var19;
                     class165.widgetSettings[var29] = class165.widgetSettings[var29] & ~var21 | var15 << var19 & var21;
                     continue;
                  }

                  if(var42 == 31) {
                     var5 -= 2;
                     if(class32.field732[var5] <= class32.field732[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 32) {
                     var5 -= 2;
                     if(class32.field732[var5] >= class32.field732[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 33) {
                     class32.field732[var5++] = class32.field739[var9[var7]];
                     continue;
                  }

                  if(var42 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class32.field739[var10001] = class32.field732[var5];
                     continue;
                  }

                  if(var42 == 35) {
                     class32.chatboxSegments[var6++] = class32.field731[var9[var7]];
                     continue;
                  }

                  if(var42 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class32.field731[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var42 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var106 = class7.method83(class32.chatboxSegments, var6, var14);
                     class32.chatboxSegments[var6++] = var106;
                     continue;
                  }

                  if(var42 == 38) {
                     --var5;
                     continue;
                  }

                  if(var42 == 39) {
                     --var6;
                     continue;
                  }

                  if(var42 == 40) {
                     var14 = var9[var7];
                     class48 var113 = class11.method145(var14);
                     var16 = new int[var113.field952];
                     String[] var67 = new String[var113.field947];

                     for(var29 = 0; var29 < var113.field951; ++var29) {
                        var16[var29] = class32.field732[var5 - var113.field951 + var29];
                     }

                     for(var29 = 0; var29 < var113.field953; ++var29) {
                        var67[var29] = class32.chatboxSegments[var6 - var113.field953 + var29];
                     }

                     var5 -= var113.field951;
                     var6 -= var113.field953;
                     class11 var84 = new class11();
                     var84.field113 = var4;
                     var84.field109 = var7;
                     var84.field110 = class32.field739;
                     var84.field111 = class32.field731;
                     class32.field735[++class32.field734 - 1] = var84;
                     var4 = var113;
                     var8 = var113.field950;
                     var9 = var113.field948;
                     var7 = -1;
                     class32.field739 = var16;
                     class32.field731 = var67;
                     continue;
                  }

                  if(var42 == 42) {
                     class32.field732[var5++] = class109.chatMessages.method823(var9[var7]);
                     continue;
                  }

                  if(var42 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class109.chatMessages.method837(var10001, class32.field732[var5]);
                     continue;
                  }

                  if(var42 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var31 = class32.field732[var5];
                     if(var31 >= 0 && var31 <= 5000) {
                        class32.field726[var14] = var31;
                        var105 = -1;
                        if(var15 == 105) {
                           var105 = 0;
                        }

                        var29 = 0;

                        while(true) {
                           if(var29 >= var31) {
                              continue label3895;
                           }

                           class32.field738[var14][var29] = var105;
                           ++var29;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field732[var5];
                     if(var15 >= 0 && var15 < class32.field726[var14]) {
                        class32.field732[var5++] = class32.field738[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class32.field732[var5];
                     if(var15 >= 0 && var15 < class32.field726[var14]) {
                        class32.field738[var14][var15] = class32.field732[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 47) {
                     var28 = class109.chatMessages.method825(var9[var7]);
                     if(var28 == null) {
                        var28 = "null";
                     }

                     class32.chatboxSegments[var6++] = var28;
                     continue;
                  }

                  if(var42 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class109.chatMessages.method835(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var53;
               if(var9[var7] == 1) {
                  var53 = true;
               } else {
                  var53 = false;
               }

               Widget var30;
               int var32;
               Widget var45;
               Widget var48;
               Widget var73;
               boolean var82;
               boolean var83;
               if(var42 < 1000) {
                  if(var42 == 100) {
                     var5 -= 3;
                     var15 = class32.field732[var5];
                     var31 = class32.field732[var5 + 1];
                     var32 = class32.field732[var5 + 2];
                     if(var31 == 0) {
                        throw new RuntimeException();
                     }

                     var48 = class174.method3178(var15);
                     if(var48.children == null) {
                        var48.children = new Widget[1 + var32];
                     }

                     if(var48.children.length <= var32) {
                        Widget[] var103 = new Widget[1 + var32];

                        for(var20 = 0; var20 < var48.children.length; ++var20) {
                           var103[var20] = var48.children[var20];
                        }

                        var48.children = var103;
                     }

                     if(var32 > 0 && null == var48.children[var32 - 1]) {
                        throw new RuntimeException("" + (var32 - 1));
                     }

                     Widget var104 = new Widget();
                     var104.type = var31;
                     var10001 = var48.id;
                     var104.id = var48.id * 553594947;
                     var104.parentId = var10001;
                     var104.index = var32;
                     var104.field2204 = true;
                     var48.children[var32] = var104;
                     if(var53) {
                        class32.field736 = var104;
                     } else {
                        class150.field2060 = var104;
                     }

                     class97.method1886(var48);
                     continue;
                  }

                  if(var42 == 101) {
                     var30 = var53?class32.field736:class150.field2060;
                     var73 = class174.method3178(var30.id);
                     var73.children[var30.index] = null;
                     class97.method1886(var73);
                     continue;
                  }

                  if(var42 == 102) {
                     --var5;
                     var30 = class174.method3178(class32.field732[var5]);
                     var30.children = null;
                     class97.method1886(var30);
                     continue;
                  }

                  if(var42 == 200) {
                     var5 -= 2;
                     var15 = class32.field732[var5];
                     var31 = class32.field732[1 + var5];
                     var45 = class138.method2419(var15, var31);
                     if(var45 != null && var31 != -1) {
                        class32.field732[var5++] = 1;
                        if(var53) {
                           class32.field736 = var45;
                        } else {
                           class150.field2060 = var45;
                        }
                        continue;
                     }

                     class32.field732[var5++] = 0;
                     continue;
                  }

                  if(var42 == 201) {
                     --var5;
                     var30 = class174.method3178(class32.field732[var5]);
                     if(var30 != null) {
                        class32.field732[var5++] = 1;
                        if(var53) {
                           class32.field736 = var30;
                        } else {
                           class150.field2060 = var30;
                        }
                     } else {
                        class32.field732[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var99;
                  if(var42 >= 1000 && var42 < 1100 || var42 >= 2000 && var42 < 2100) {
                     var15 = -1;
                     if(var42 >= 2000) {
                        var42 -= 1000;
                        --var5;
                        var15 = class32.field732[var5];
                        var73 = class174.method3178(var15);
                     } else {
                        var73 = var53?class32.field736:class150.field2060;
                     }

                     if(var42 == 1000) {
                        var5 -= 4;
                        var73.field2216 = class32.field732[var5];
                        var73.field2217 = class32.field732[1 + var5];
                        var73.field2212 = class32.field732[var5 + 2];
                        var73.field2236 = class32.field732[3 + var5];
                        class97.method1886(var73);
                        class8.method94(var73);
                        if(var15 != -1 && var73.type == 0) {
                           Renderable.method1833(Widget.widgets[var15 >> 16], var73, false);
                        }
                        continue;
                     }

                     if(var42 == 1001) {
                        var5 -= 4;
                        var73.field2218 = class32.field732[var5];
                        var73.field2215 = class32.field732[1 + var5];
                        var73.field2214 = class32.field732[var5 + 2];
                        var73.field2253 = class32.field732[3 + var5];
                        class97.method1886(var73);
                        class8.method94(var73);
                        if(var15 != -1 && var73.type == 0) {
                           Renderable.method1833(Widget.widgets[var15 >> 16], var73, false);
                        }
                        continue;
                     }

                     if(var42 == 1003) {
                        --var5;
                        var99 = class32.field732[var5] == 1;
                        if(var73.isHidden != var99) {
                           var73.isHidden = var99;
                           class97.method1886(var73);
                        }
                        continue;
                     }

                     if(var42 == 1005) {
                        --var5;
                        var73.field2340 = class32.field732[var5] == 1;
                        continue;
                     }

                     if(var42 == 1006) {
                        --var5;
                        var73.field2299 = class32.field732[var5] == 1;
                        continue;
                     }
                  } else {
                     String var17;
                     if((var42 < 1100 || var42 >= 1200) && (var42 < 2100 || var42 >= 2200)) {
                        if(var42 >= 1200 && var42 < 1300 || var42 >= 2200 && var42 < 2300) {
                           if(var42 >= 2000) {
                              var42 -= 1000;
                              --var5;
                              var30 = class174.method3178(class32.field732[var5]);
                           } else {
                              var30 = var53?class32.field736:class150.field2060;
                           }

                           class97.method1886(var30);
                           if(var42 == 1200 || var42 == 1205 || var42 == 1212) {
                              var5 -= 2;
                              var31 = class32.field732[var5];
                              var32 = class32.field732[1 + var5];
                              var30.item = var31;
                              var30.stackSize = var32;
                              ItemComposition var79 = class137.getItemDefinition(var31);
                              var30.rotationX = var79.field2973;
                              var30.rotationZ = var79.field2977;
                              var30.rotationY = var79.field2942;
                              var30.field2291 = var79.field2958;
                              var30.field2257 = var79.field2959;
                              var30.field2261 = var79.field2954;
                              if(var42 == 1205) {
                                 var30.field2211 = 0;
                              } else if(var42 == 1212 | var79.isStackable == 1) {
                                 var30.field2211 = 1;
                              } else {
                                 var30.field2211 = 2;
                              }

                              if(var30.field2252 > 0) {
                                 var30.field2261 = var30.field2261 * 32 / var30.field2252;
                              } else if(var30.field2218 > 0) {
                                 var30.field2261 = var30.field2261 * 32 / var30.field2218;
                              }
                              continue;
                           }

                           if(var42 == 1201) {
                              var30.modelType = 2;
                              --var5;
                              var30.modelId = class32.field732[var5];
                              continue;
                           }

                           if(var42 == 1202) {
                              var30.modelType = 3;
                              var30.modelId = class5.localPlayer.composition.method3061();
                              continue;
                           }
                        } else if(var42 >= 1300 && var42 < 1400 || var42 >= 2300 && var42 < 2400) {
                           if(var42 >= 2000) {
                              var42 -= 1000;
                              --var5;
                              var30 = class174.method3178(class32.field732[var5]);
                           } else {
                              var30 = var53?class32.field736:class150.field2060;
                           }

                           if(var42 == 1300) {
                              --var5;
                              var31 = class32.field732[var5] - 1;
                              if(var31 >= 0 && var31 <= 9) {
                                 --var6;
                                 var30.method3115(var31, class32.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var42 == 1301) {
                              var5 -= 2;
                              var31 = class32.field732[var5];
                              var32 = class32.field732[var5 + 1];
                              var30.parent = class138.method2419(var31, var32);
                              continue;
                           }

                           if(var42 == 1302) {
                              --var5;
                              var30.field2285 = class32.field732[var5] == 1;
                              continue;
                           }

                           if(var42 == 1303) {
                              --var5;
                              var30.field2283 = class32.field732[var5];
                              continue;
                           }

                           if(var42 == 1304) {
                              --var5;
                              var30.field2302 = class32.field732[var5];
                              continue;
                           }

                           if(var42 == 1305) {
                              --var6;
                              var30.name = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var42 == 1306) {
                              --var6;
                              var30.field2286 = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var42 == 1307) {
                              var30.actions = null;
                              continue;
                           }
                        } else {
                           String var44;
                           int[] var47;
                           if(var42 >= 1400 && var42 < 1500 || var42 >= 2400 && var42 < 2500) {
                              if(var42 >= 2000) {
                                 var42 -= 1000;
                                 --var5;
                                 var30 = class174.method3178(class32.field732[var5]);
                              } else {
                                 var30 = var53?class32.field736:class150.field2060;
                              }

                              --var6;
                              var44 = class32.chatboxSegments[var6];
                              var47 = null;
                              if(var44.length() > 0 && var44.charAt(var44.length() - 1) == 89) {
                                 --var5;
                                 var29 = class32.field732[var5];
                                 if(var29 > 0) {
                                    for(var47 = new int[var29]; var29-- > 0; var47[var29] = class32.field732[var5]) {
                                       --var5;
                                    }
                                 }

                                 var44 = var44.substring(0, var44.length() - 1);
                              }

                              Object[] var64 = new Object[var44.length() + 1];

                              for(var19 = var64.length - 1; var19 >= 1; --var19) {
                                 if(var44.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var64[var19] = class32.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var64[var19] = new Integer(class32.field732[var5]);
                                 }
                              }

                              --var5;
                              var19 = class32.field732[var5];
                              if(var19 != -1) {
                                 var64[0] = new Integer(var19);
                              } else {
                                 var64 = null;
                              }

                              if(var42 == 1400) {
                                 var30.field2289 = var64;
                              }

                              if(var42 == 1401) {
                                 var30.field2292 = var64;
                              }

                              if(var42 == 1402) {
                                 var30.field2213 = var64;
                              }

                              if(var42 == 1403) {
                                 var30.field2293 = var64;
                              }

                              if(var42 == 1404) {
                                 var30.field2237 = var64;
                              }

                              if(var42 == 1405) {
                                 var30.field2296 = var64;
                              }

                              if(var42 == 1406) {
                                 var30.field2251 = var64;
                              }

                              if(var42 == 1407) {
                                 var30.field2290 = var64;
                                 var30.field2301 = var47;
                              }

                              if(var42 == 1408) {
                                 var30.field2306 = var64;
                              }

                              if(var42 == 1409) {
                                 var30.field2307 = var64;
                              }

                              if(var42 == 1410) {
                                 var30.field2297 = var64;
                              }

                              if(var42 == 1411) {
                                 var30.field2279 = var64;
                              }

                              if(var42 == 1412) {
                                 var30.field2272 = var64;
                              }

                              if(var42 == 1414) {
                                 var30.field2303 = var64;
                                 var30.field2276 = var47;
                              }

                              if(var42 == 1415) {
                                 var30.field2304 = var64;
                                 var30.field2305 = var47;
                              }

                              if(var42 == 1416) {
                                 var30.field2298 = var64;
                              }

                              if(var42 == 1417) {
                                 var30.field2295 = var64;
                              }

                              if(var42 == 1418) {
                                 var30.field2309 = var64;
                              }

                              if(var42 == 1419) {
                                 var30.field2274 = var64;
                              }

                              if(var42 == 1420) {
                                 var30.field2317 = var64;
                              }

                              if(var42 == 1421) {
                                 var30.field2312 = var64;
                              }

                              if(var42 == 1422) {
                                 var30.field2313 = var64;
                              }

                              if(var42 == 1423) {
                                 var30.field2314 = var64;
                              }

                              if(var42 == 1424) {
                                 var30.field2255 = var64;
                              }

                              if(var42 == 1425) {
                                 var30.field2310 = var64;
                              }

                              if(var42 == 1426) {
                                 var30.field2318 = var64;
                              }

                              if(var42 == 1427) {
                                 var30.field2316 = var64;
                              }

                              var30.field2287 = true;
                              continue;
                           }

                           if(var42 < 1600) {
                              var30 = var53?class32.field736:class150.field2060;
                              if(var42 == 1500) {
                                 class32.field732[var5++] = var30.relativeX;
                                 continue;
                              }

                              if(var42 == 1501) {
                                 class32.field732[var5++] = var30.relativeY;
                                 continue;
                              }

                              if(var42 == 1502) {
                                 class32.field732[var5++] = var30.width;
                                 continue;
                              }

                              if(var42 == 1503) {
                                 class32.field732[var5++] = var30.height;
                                 continue;
                              }

                              if(var42 == 1504) {
                                 class32.field732[var5++] = var30.isHidden?1:0;
                                 continue;
                              }

                              if(var42 == 1505) {
                                 class32.field732[var5++] = var30.parentId;
                                 continue;
                              }
                           } else if(var42 < 1700) {
                              var30 = var53?class32.field736:class150.field2060;
                              if(var42 == 1600) {
                                 class32.field732[var5++] = var30.scrollX;
                                 continue;
                              }

                              if(var42 == 1601) {
                                 class32.field732[var5++] = var30.scrollY;
                                 continue;
                              }

                              if(var42 == 1602) {
                                 class32.chatboxSegments[var6++] = var30.text;
                                 continue;
                              }

                              if(var42 == 1603) {
                                 class32.field732[var5++] = var30.scrollWidth;
                                 continue;
                              }

                              if(var42 == 1604) {
                                 class32.field732[var5++] = var30.scrollHeight;
                                 continue;
                              }

                              if(var42 == 1605) {
                                 class32.field732[var5++] = var30.field2261;
                                 continue;
                              }

                              if(var42 == 1606) {
                                 class32.field732[var5++] = var30.rotationX;
                                 continue;
                              }

                              if(var42 == 1607) {
                                 class32.field732[var5++] = var30.rotationY;
                                 continue;
                              }

                              if(var42 == 1608) {
                                 class32.field732[var5++] = var30.rotationZ;
                                 continue;
                              }

                              if(var42 == 1609) {
                                 class32.field732[var5++] = var30.opacity;
                                 continue;
                              }

                              if(var42 == 1610) {
                                 class32.field732[var5++] = var30.field2199;
                                 continue;
                              }

                              if(var42 == 1611) {
                                 class32.field732[var5++] = var30.textColor;
                                 continue;
                              }

                              if(var42 == 1612) {
                                 class32.field732[var5++] = var30.field2233;
                                 continue;
                              }

                              if(var42 == 1613) {
                                 class32.field732[var5++] = var30.field2241.vmethod3989();
                                 continue;
                              }
                           } else if(var42 < 1800) {
                              var30 = var53?class32.field736:class150.field2060;
                              if(var42 == 1700) {
                                 class32.field732[var5++] = var30.item;
                                 continue;
                              }

                              if(var42 == 1701) {
                                 if(var30.item != -1) {
                                    class32.field732[var5++] = var30.stackSize;
                                 } else {
                                    class32.field732[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 1702) {
                                 class32.field732[var5++] = var30.index;
                                 continue;
                              }
                           } else if(var42 < 1900) {
                              var30 = var53?class32.field736:class150.field2060;
                              if(var42 == 1800) {
                                 var16 = class32.field732;
                                 var32 = var5++;
                                 var19 = class217.method3874(var30);
                                 var29 = var19 >> 11 & 63;
                                 var16[var32] = var29;
                                 continue;
                              }

                              if(var42 == 1801) {
                                 --var5;
                                 var31 = class32.field732[var5];
                                 --var31;
                                 if(null != var30.actions && var31 < var30.actions.length && null != var30.actions[var31]) {
                                    class32.chatboxSegments[var6++] = var30.actions[var31];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var42 == 1802) {
                                 if(null == var30.name) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var30.name;
                                 }
                                 continue;
                              }
                           } else if(var42 >= 1900 && var42 < 2000 || var42 >= 2900 && var42 < 3000) {
                              if(var42 >= 2000) {
                                 var42 -= 1000;
                                 --var5;
                                 var30 = class174.method3178(class32.field732[var5]);
                              } else {
                                 var30 = var53?class32.field736:class150.field2060;
                              }

                              if(var42 == 1927) {
                                 if(class32.field733 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var30.field2316 == null) {
                                    return;
                                 }

                                 class18 var70 = new class18();
                                 var70.field193 = var30;
                                 var70.field203 = var30.field2316;
                                 var70.field202 = 1 + class32.field733;
                                 Client.field483.method2361(var0);
                                 continue;
                              }
                           } else if(var42 < 2600) {
                              --var5;
                              var30 = class174.method3178(class32.field732[var5]);
                              if(var42 == 2500) {
                                 class32.field732[var5++] = var30.relativeX;
                                 continue;
                              }

                              if(var42 == 2501) {
                                 class32.field732[var5++] = var30.relativeY;
                                 continue;
                              }

                              if(var42 == 2502) {
                                 class32.field732[var5++] = var30.width;
                                 continue;
                              }

                              if(var42 == 2503) {
                                 class32.field732[var5++] = var30.height;
                                 continue;
                              }

                              if(var42 == 2504) {
                                 class32.field732[var5++] = var30.isHidden?1:0;
                                 continue;
                              }

                              if(var42 == 2505) {
                                 class32.field732[var5++] = var30.parentId;
                                 continue;
                              }
                           } else if(var42 < 2700) {
                              --var5;
                              var30 = class174.method3178(class32.field732[var5]);
                              if(var42 == 2600) {
                                 class32.field732[var5++] = var30.scrollX;
                                 continue;
                              }

                              if(var42 == 2601) {
                                 class32.field732[var5++] = var30.scrollY;
                                 continue;
                              }

                              if(var42 == 2602) {
                                 class32.chatboxSegments[var6++] = var30.text;
                                 continue;
                              }

                              if(var42 == 2603) {
                                 class32.field732[var5++] = var30.scrollWidth;
                                 continue;
                              }

                              if(var42 == 2604) {
                                 class32.field732[var5++] = var30.scrollHeight;
                                 continue;
                              }

                              if(var42 == 2605) {
                                 class32.field732[var5++] = var30.field2261;
                                 continue;
                              }

                              if(var42 == 2606) {
                                 class32.field732[var5++] = var30.rotationX;
                                 continue;
                              }

                              if(var42 == 2607) {
                                 class32.field732[var5++] = var30.rotationY;
                                 continue;
                              }

                              if(var42 == 2608) {
                                 class32.field732[var5++] = var30.rotationZ;
                                 continue;
                              }

                              if(var42 == 2609) {
                                 class32.field732[var5++] = var30.opacity;
                                 continue;
                              }

                              if(var42 == 2610) {
                                 class32.field732[var5++] = var30.field2199;
                                 continue;
                              }

                              if(var42 == 2611) {
                                 class32.field732[var5++] = var30.textColor;
                                 continue;
                              }

                              if(var42 == 2612) {
                                 class32.field732[var5++] = var30.field2233;
                                 continue;
                              }

                              if(var42 == 2613) {
                                 class32.field732[var5++] = var30.field2241.vmethod3989();
                                 continue;
                              }
                           } else if(var42 < 2800) {
                              if(var42 == 2700) {
                                 --var5;
                                 var30 = class174.method3178(class32.field732[var5]);
                                 class32.field732[var5++] = var30.item;
                                 continue;
                              }

                              if(var42 == 2701) {
                                 --var5;
                                 var30 = class174.method3178(class32.field732[var5]);
                                 if(var30.item != -1) {
                                    class32.field732[var5++] = var30.stackSize;
                                 } else {
                                    class32.field732[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 2702) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 WidgetNode var43 = (WidgetNode)Client.componentTable.method2299((long)var15);
                                 if(var43 != null) {
                                    class32.field732[var5++] = 1;
                                 } else {
                                    class32.field732[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 2706) {
                                 class32.field732[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var42 < 2900) {
                              --var5;
                              var30 = class174.method3178(class32.field732[var5]);
                              if(var42 == 2800) {
                                 var16 = class32.field732;
                                 var32 = var5++;
                                 var19 = class217.method3874(var30);
                                 var29 = var19 >> 11 & 63;
                                 var16[var32] = var29;
                                 continue;
                              }

                              if(var42 == 2801) {
                                 --var5;
                                 var31 = class32.field732[var5];
                                 --var31;
                                 if(var30.actions != null && var31 < var30.actions.length && null != var30.actions[var31]) {
                                    class32.chatboxSegments[var6++] = var30.actions[var31];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var42 == 2802) {
                                 if(null == var30.name) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var30.name;
                                 }
                                 continue;
                              }
                           } else if(var42 < 3200) {
                              if(var42 == 3100) {
                                 --var6;
                                 var106 = class32.chatboxSegments[var6];
                                 class16.method183(0, "", var106);
                                 continue;
                              }

                              if(var42 == 3101) {
                                 var5 -= 2;
                                 class30.method645(class5.localPlayer, class32.field732[var5], class32.field732[var5 + 1]);
                                 continue;
                              }

                              if(var42 == 3103) {
                                 Client.field330.method2967(237);

                                 for(WidgetNode var107 = (WidgetNode)Client.componentTable.method2296(); var107 != null; var107 = (WidgetNode)Client.componentTable.method2300()) {
                                    if(var107.field191 == 0 || var107.field191 == 3) {
                                       class44.method783(var107, true);
                                    }
                                 }

                                 if(Client.field448 != null) {
                                    class97.method1886(Client.field448);
                                    Client.field448 = null;
                                 }
                                 continue;
                              }

                              if(var42 == 3104) {
                                 --var6;
                                 var106 = class32.chatboxSegments[var6];
                                 var31 = 0;
                                 if(Tile.method1520(var106)) {
                                    var31 = FileOnDisk.method1403(var106);
                                 }

                                 Client.field330.method2967(205);
                                 Client.field330.method2714(var31);
                                 continue;
                              }

                              if(var42 == 3105) {
                                 --var6;
                                 var106 = class32.chatboxSegments[var6];
                                 Client.field330.method2967(209);
                                 Client.field330.method2815(var106.length() + 1);
                                 Client.field330.method2717(var106);
                                 continue;
                              }

                              if(var42 == 3106) {
                                 --var6;
                                 var106 = class32.chatboxSegments[var6];
                                 Client.field330.method2967(5);
                                 Client.field330.method2815(var106.length() + 1);
                                 Client.field330.method2717(var106);
                                 continue;
                              }

                              if(var42 == 3107) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 --var6;
                                 var44 = class32.chatboxSegments[var6];
                                 class20.method196(var15, var44);
                                 continue;
                              }

                              if(var42 == 3108) {
                                 var5 -= 3;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[var5 + 1];
                                 var32 = class32.field732[2 + var5];
                                 var48 = class174.method3178(var32);
                                 class108.method1999(var48, var15, var31);
                                 continue;
                              }

                              if(var42 == 3109) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[var5 + 1];
                                 var45 = var53?class32.field736:class150.field2060;
                                 class108.method1999(var45, var15, var31);
                                 continue;
                              }

                              if(var42 == 3110) {
                                 --var5;
                                 class148.field2047 = class32.field732[var5] == 1;
                                 continue;
                              }

                              if(var42 == 3111) {
                                 class32.field732[var5++] = XGrandExchangeOffer.field35.field699?1:0;
                                 continue;
                              }

                              if(var42 == 3112) {
                                 --var5;
                                 XGrandExchangeOffer.field35.field699 = class32.field732[var5] == 1;
                                 class119.method2234();
                                 continue;
                              }

                              if(var42 == 3113) {
                                 --var6;
                                 var106 = class32.chatboxSegments[var6];
                                 --var5;
                                 var82 = class32.field732[var5] == 1;
                                 Tile.method1518(var106, var82, false);
                                 continue;
                              }

                              if(var42 == 3115) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 Client.field330.method2967(37);
                                 Client.field330.method2712(var15);
                                 continue;
                              }

                              if(var42 == 3116) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 var6 -= 2;
                                 var44 = class32.chatboxSegments[var6];
                                 var17 = class32.chatboxSegments[1 + var6];
                                 if(var44.length() <= 500 && var17.length() <= 500) {
                                    Client.field330.method2967(123);
                                    Client.field330.method2712(1 + class112.method2050(var44) + class112.method2050(var17));
                                    Client.field330.method2717(var44);
                                    Client.field330.method2717(var17);
                                    Client.field330.method2815(var15);
                                 }
                                 continue;
                              }
                           } else if(var42 < 3300) {
                              if(var42 == 3200) {
                                 var5 -= 3;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[1 + var5];
                                 var32 = class32.field732[var5 + 2];
                                 if(Client.field524 != 0 && var31 != 0 && Client.field526 < 50) {
                                    Client.field527[Client.field526] = var15;
                                    Client.field351[Client.field526] = var31;
                                    Client.field529[Client.field526] = var32;
                                    Client.field531[Client.field526] = null;
                                    Client.field349[Client.field526] = 0;
                                    ++Client.field526;
                                 }
                                 continue;
                              }

                              if(var42 == 3201) {
                                 --var5;
                                 class114.method2155(class32.field732[var5]);
                                 continue;
                              }

                              if(var42 == 3202) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5];
                                 int var10000 = class32.field732[1 + var5];
                                 if(Client.field521 != 0 && var15 != -1) {
                                    WallObject.method1843(Friend.field160, var15, 0, Client.field521, false);
                                    Client.field493 = true;
                                 }
                                 continue;
                              }
                           } else if(var42 < 3400) {
                              if(var42 == 3300) {
                                 class32.field732[var5++] = Client.gameCycle;
                                 continue;
                              }

                              XItemContainer var34;
                              if(var42 == 3301) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[1 + var5];
                                 var47 = class32.field732;
                                 var29 = var5++;
                                 var34 = (XItemContainer)itemContainers.method2299((long)var15);
                                 if(null == var34) {
                                    var19 = -1;
                                 } else if(var31 >= 0 && var31 < var34.itemIds.length) {
                                    var19 = var34.itemIds[var31];
                                 } else {
                                    var19 = -1;
                                 }

                                 var47[var29] = var19;
                                 continue;
                              }

                              if(var42 == 3302) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[1 + var5];
                                 var47 = class32.field732;
                                 var29 = var5++;
                                 var34 = (XItemContainer)itemContainers.method2299((long)var15);
                                 if(var34 == null) {
                                    var19 = 0;
                                 } else if(var31 >= 0 && var31 < var34.stackSizes.length) {
                                    var19 = var34.stackSizes[var31];
                                 } else {
                                    var19 = 0;
                                 }

                                 var47[var29] = var19;
                                 continue;
                              }

                              if(var42 == 3303) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[1 + var5];
                                 class32.field732[var5++] = class207.method3767(var15, var31);
                                 continue;
                              }

                              if(var42 == 3304) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 var16 = class32.field732;
                                 var32 = var5++;
                                 class186 var81 = (class186)class186.field2777.get((long)var15);
                                 class186 var49;
                                 if(var81 != null) {
                                    var49 = var81;
                                 } else {
                                    byte[] var86 = class186.field2779.method3203(5, var15);
                                    var81 = new class186();
                                    if(var86 != null) {
                                       var81.method3334(new Buffer(var86));
                                    }

                                    class186.field2777.put(var81, (long)var15);
                                    var49 = var81;
                                 }

                                 var16[var32] = var49.field2778;
                                 continue;
                              }

                              if(var42 == 3305) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 class32.field732[var5++] = Client.boostedSkillLevels[var15];
                                 continue;
                              }

                              if(var42 == 3306) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 class32.field732[var5++] = Client.realSkillLevels[var15];
                                 continue;
                              }

                              if(var42 == 3307) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 class32.field732[var5++] = Client.skillExperiences[var15];
                                 continue;
                              }

                              if(var42 == 3308) {
                                 var15 = class63.plane;
                                 var31 = (class5.localPlayer.x >> 7) + class107.baseX;
                                 var32 = XClanMember.baseY + (class5.localPlayer.y >> 7);
                                 class32.field732[var5++] = (var15 << 28) + (var31 << 14) + var32;
                                 continue;
                              }

                              if(var42 == 3309) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 class32.field732[var5++] = var15 >> 14 & 16383;
                                 continue;
                              }

                              if(var42 == 3310) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 class32.field732[var5++] = var15 >> 28;
                                 continue;
                              }

                              if(var42 == 3311) {
                                 --var5;
                                 var15 = class32.field732[var5];
                                 class32.field732[var5++] = var15 & 16383;
                                 continue;
                              }

                              if(var42 == 3312) {
                                 class32.field732[var5++] = Client.isMembers?1:0;
                                 continue;
                              }

                              if(var42 == 3313) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5] + '耀';
                                 var31 = class32.field732[1 + var5];
                                 var47 = class32.field732;
                                 var29 = var5++;
                                 var34 = (XItemContainer)itemContainers.method2299((long)var15);
                                 if(null == var34) {
                                    var19 = -1;
                                 } else if(var31 >= 0 && var31 < var34.itemIds.length) {
                                    var19 = var34.itemIds[var31];
                                 } else {
                                    var19 = -1;
                                 }

                                 var47[var29] = var19;
                                 continue;
                              }

                              if(var42 == 3314) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5] + '耀';
                                 var31 = class32.field732[1 + var5];
                                 var47 = class32.field732;
                                 var29 = var5++;
                                 var34 = (XItemContainer)itemContainers.method2299((long)var15);
                                 if(null == var34) {
                                    var19 = 0;
                                 } else if(var31 >= 0 && var31 < var34.stackSizes.length) {
                                    var19 = var34.stackSizes[var31];
                                 } else {
                                    var19 = 0;
                                 }

                                 var47[var29] = var19;
                                 continue;
                              }

                              if(var42 == 3315) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5] + '耀';
                                 var31 = class32.field732[1 + var5];
                                 class32.field732[var5++] = class207.method3767(var15, var31);
                                 continue;
                              }

                              if(var42 == 3316) {
                                 if(Client.field451 >= 2) {
                                    class32.field732[var5++] = Client.field451;
                                 } else {
                                    class32.field732[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 3317) {
                                 class32.field732[var5++] = Client.field305;
                                 continue;
                              }

                              if(var42 == 3318) {
                                 class32.field732[var5++] = Client.world;
                                 continue;
                              }

                              if(var42 == 3321) {
                                 class32.field732[var5++] = Client.energy;
                                 continue;
                              }

                              if(var42 == 3322) {
                                 class32.field732[var5++] = Client.weight;
                                 continue;
                              }

                              if(var42 == 3323) {
                                 if(Client.field453) {
                                    class32.field732[var5++] = 1;
                                 } else {
                                    class32.field732[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 3324) {
                                 class32.field732[var5++] = Client.flags;
                                 continue;
                              }
                           } else if(var42 < 3500) {
                              if(var42 == 3400) {
                                 var5 -= 2;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[1 + var5];
                                 class195 var52 = (class195)class195.field2854.get((long)var15);
                                 class195 var51;
                                 if(var52 != null) {
                                    var51 = var52;
                                 } else {
                                    byte[] var87 = class195.field2855.method3203(8, var15);
                                    var52 = new class195();
                                    if(var87 != null) {
                                       var52.method3469(new Buffer(var87));
                                    }

                                    class195.field2854.put(var52, (long)var15);
                                    var51 = var52;
                                 }

                                 var52 = var51;
                                 if(var51.field2853 != 115) {
                                    ;
                                 }

                                 for(var19 = 0; var19 < var52.field2859; ++var19) {
                                    if(var31 == var52.field2860[var19]) {
                                       class32.chatboxSegments[var6++] = var52.field2862[var19];
                                       var52 = null;
                                       break;
                                    }
                                 }

                                 if(var52 != null) {
                                    class32.chatboxSegments[var6++] = var52.field2857;
                                 }
                                 continue;
                              }

                              if(var42 == 3408) {
                                 var5 -= 4;
                                 var15 = class32.field732[var5];
                                 var31 = class32.field732[var5 + 1];
                                 var32 = class32.field732[var5 + 2];
                                 var29 = class32.field732[var5 + 3];
                                 class195 var90 = (class195)class195.field2854.get((long)var32);
                                 class195 var85;
                                 if(var90 != null) {
                                    var85 = var90;
                                 } else {
                                    byte[] var35 = class195.field2855.method3203(8, var32);
                                    var90 = new class195();
                                    if(var35 != null) {
                                       var90.method3469(new Buffer(var35));
                                    }

                                    class195.field2854.put(var90, (long)var32);
                                    var85 = var90;
                                 }

                                 var90 = var85;
                                 if(var85.field2856 == var15 && var31 == var85.field2853) {
                                    for(var21 = 0; var21 < var90.field2859; ++var21) {
                                       if(var90.field2860[var21] == var29) {
                                          if(var31 == 115) {
                                             class32.chatboxSegments[var6++] = var90.field2862[var21];
                                          } else {
                                             class32.field732[var5++] = var90.field2861[var21];
                                          }

                                          var90 = null;
                                          break;
                                       }
                                    }

                                    if(null != var90) {
                                       if(var31 == 115) {
                                          class32.chatboxSegments[var6++] = var90.field2857;
                                       } else {
                                          class32.field732[var5++] = var90.field2858;
                                       }
                                    }
                                    continue;
                                 }

                                 if(var31 == 115) {
                                    class32.chatboxSegments[var6++] = "null";
                                 } else {
                                    class32.field732[var5++] = 0;
                                 }
                                 continue;
                              }
                           } else {
                              int var22;
                              if(var42 < 3700) {
                                 if(var42 == 3600) {
                                    if(Client.field312 == 0) {
                                       class32.field732[var5++] = -2;
                                    } else if(Client.field312 == 1) {
                                       class32.field732[var5++] = -1;
                                    } else {
                                       class32.field732[var5++] = Client.friendCount;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3601) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(Client.field312 == 2 && var15 < Client.friendCount) {
                                       class32.chatboxSegments[var6++] = Client.friends[var15].name;
                                       class32.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var42 == 3602) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(Client.field312 == 2 && var15 < Client.friendCount) {
                                       class32.field732[var5++] = Client.friends[var15].world;
                                       continue;
                                    }

                                    class32.field732[var5++] = 0;
                                    continue;
                                 }

                                 if(var42 == 3603) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(Client.field312 == 2 && var15 < Client.friendCount) {
                                       class32.field732[var5++] = Client.friends[var15].rank;
                                       continue;
                                    }

                                    class32.field732[var5++] = 0;
                                    continue;
                                 }

                                 if(var42 == 3604) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    --var5;
                                    var31 = class32.field732[var5];
                                    Client.field330.method2967(216);
                                    Client.field330.method2815(class112.method2050(var106) + 1);
                                    Client.field330.method2815(var31);
                                    Client.field330.method2717(var106);
                                    continue;
                                 }

                                 if(var42 == 3605) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    class16.method181(var106);
                                    continue;
                                 }

                                 String var89;
                                 if(var42 == 3606) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    if(null == var106) {
                                       continue;
                                    }

                                    var44 = class162.method3013(var106, Friend.field155);
                                    if(var44 == null) {
                                       continue;
                                    }

                                    var32 = 0;

                                    while(true) {
                                       if(var32 >= Client.friendCount) {
                                          continue label3895;
                                       }

                                       Friend var59 = Client.friends[var32];
                                       var89 = var59.name;
                                       String var97 = class162.method3013(var89, Friend.field155);
                                       boolean var58;
                                       if(null != var106 && null != var89) {
                                          if(!var106.startsWith("#") && !var89.startsWith("#")) {
                                             var58 = var44.equals(var97);
                                          } else {
                                             var58 = var106.equals(var89);
                                          }
                                       } else {
                                          var58 = false;
                                       }

                                       if(var58) {
                                          --Client.friendCount;

                                          for(var22 = var32; var22 < Client.friendCount; ++var22) {
                                             Client.friends[var22] = Client.friends[var22 + 1];
                                          }

                                          Client.field477 = Client.field469;
                                          Client.field330.method2967(154);
                                          Client.field330.method2815(class112.method2050(var106));
                                          Client.field330.method2717(var106);
                                          continue label3895;
                                       }

                                       ++var32;
                                    }
                                 }

                                 if(var42 == 3607) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    class13.method167(var106, false);
                                    continue;
                                 }

                                 if(var42 == 3608) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    class60.method1130(var106);
                                    continue;
                                 }

                                 if(var42 == 3609) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    class177[] var46 = new class177[]{class177.field2672, class177.field2673, class177.field2669, class177.field2671, class177.field2676, class177.field2668};
                                    class177[] var54 = var46;

                                    for(var29 = 0; var29 < var54.length; ++var29) {
                                       class177 var98 = var54[var29];
                                       if(var98.field2675 != -1 && var106.startsWith(class13.method166(var98.field2675))) {
                                          var106 = var106.substring(6 + Integer.toString(var98.field2675).length());
                                          break;
                                       }
                                    }

                                    class32.field732[var5++] = class155.method2934(var106, false)?1:0;
                                    continue;
                                 }

                                 String var57;
                                 String[] var108;
                                 if(var42 == 3611) {
                                    if(Client.field290 != null) {
                                       var108 = class32.chatboxSegments;
                                       var31 = var6++;
                                       var57 = Client.field290;
                                       var89 = class137.method2417(class184.method3324(var57));
                                       if(null == var89) {
                                          var89 = "";
                                       }

                                       var108[var31] = var89;
                                    } else {
                                       class32.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var42 == 3612) {
                                    if(null != Client.field290) {
                                       class32.field732[var5++] = class177.field2678;
                                    } else {
                                       class32.field732[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3613) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(Client.field290 != null && var15 < class177.field2678) {
                                       class32.chatboxSegments[var6++] = class110.clanMembers[var15].username;
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var42 == 3614) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(null != Client.field290 && var15 < class177.field2678) {
                                       class32.field732[var5++] = class110.clanMembers[var15].world;
                                       continue;
                                    }

                                    class32.field732[var5++] = 0;
                                    continue;
                                 }

                                 if(var42 == 3615) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(null != Client.field290 && var15 < class177.field2678) {
                                       class32.field732[var5++] = class110.clanMembers[var15].rank;
                                       continue;
                                    }

                                    class32.field732[var5++] = 0;
                                    continue;
                                 }

                                 if(var42 == 3616) {
                                    class32.field732[var5++] = class165.field2177;
                                    continue;
                                 }

                                 if(var42 == 3617) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    if(class110.clanMembers != null) {
                                       Client.field330.method2967(204);
                                       Client.field330.method2815(class112.method2050(var106));
                                       Client.field330.method2717(var106);
                                    }
                                    continue;
                                 }

                                 if(var42 == 3618) {
                                    class32.field732[var5++] = XGrandExchangeOffer.field34;
                                    continue;
                                 }

                                 if(var42 == 3619) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    if(!var106.equals("")) {
                                       Client.field330.method2967(6);
                                       Client.field330.method2815(class112.method2050(var106));
                                       Client.field330.method2717(var106);
                                    }
                                    continue;
                                 }

                                 if(var42 == 3620) {
                                    Client.field330.method2967(6);
                                    Client.field330.method2815(0);
                                    continue;
                                 }

                                 if(var42 == 3621) {
                                    if(Client.field312 == 0) {
                                       class32.field732[var5++] = -1;
                                    } else {
                                       class32.field732[var5++] = Client.ignoreCount;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3622) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(Client.field312 != 0 && var15 < Client.ignoreCount) {
                                       class32.chatboxSegments[var6++] = Client.ignores[var15].name;
                                       class32.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var42 == 3623) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    if(var106.startsWith(class13.method166(0)) || var106.startsWith(class13.method166(1))) {
                                       var106 = var106.substring(7);
                                    }

                                    class32.field732[var5++] = method150(var106)?1:0;
                                    continue;
                                 }

                                 if(var42 == 3624) {
                                    --var5;
                                    var15 = class32.field732[var5];
                                    if(null != class110.clanMembers && var15 < class177.field2678 && class110.clanMembers[var15].username.equalsIgnoreCase(class5.localPlayer.name)) {
                                       class32.field732[var5++] = 1;
                                       continue;
                                    }

                                    class32.field732[var5++] = 0;
                                    continue;
                                 }

                                 if(var42 == 3625) {
                                    if(null != Client.clanChatOwner) {
                                       var108 = class32.chatboxSegments;
                                       var31 = var6++;
                                       var57 = Client.clanChatOwner;
                                       var89 = class137.method2417(class184.method3324(var57));
                                       if(null == var89) {
                                          var89 = "";
                                       }

                                       var108[var31] = var89;
                                    } else {
                                       class32.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else {
                                 long var92;
                                 if(var42 < 4000) {
                                    if(var42 == 3903) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = Client.grandExchangeOffers[var15].method44();
                                       continue;
                                    }

                                    if(var42 == 3904) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = Client.grandExchangeOffers[var15].itemId;
                                       continue;
                                    }

                                    if(var42 == 3905) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = Client.grandExchangeOffers[var15].price;
                                       continue;
                                    }

                                    if(var42 == 3906) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                       continue;
                                    }

                                    if(var42 == 3907) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                       continue;
                                    }

                                    if(var42 == 3908) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = Client.grandExchangeOffers[var15].spent;
                                       continue;
                                    }

                                    if(var42 == 3910) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var31 = Client.grandExchangeOffers[var15].method43();
                                       class32.field732[var5++] = var31 == 0?1:0;
                                       continue;
                                    }

                                    if(var42 == 3911) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var31 = Client.grandExchangeOffers[var15].method43();
                                       class32.field732[var5++] = var31 == 2?1:0;
                                       continue;
                                    }

                                    if(var42 == 3912) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var31 = Client.grandExchangeOffers[var15].method43();
                                       class32.field732[var5++] = var31 == 5?1:0;
                                       continue;
                                    }

                                    if(var42 == 3913) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var31 = Client.grandExchangeOffers[var15].method43();
                                       class32.field732[var5++] = var31 == 1?1:0;
                                       continue;
                                    }

                                    boolean var74;
                                    if(var42 == 3914) {
                                       --var5;
                                       var74 = class32.field732[var5] == 1;
                                       if(class109.field1748 != null) {
                                          class109.field1748.method11(class1.field9, var74);
                                       }
                                       continue;
                                    }

                                    if(var42 == 3915) {
                                       --var5;
                                       var74 = class32.field732[var5] == 1;
                                       if(null != class109.field1748) {
                                          class109.field1748.method11(class1.field8, var74);
                                       }
                                       continue;
                                    }

                                    if(var42 == 3916) {
                                       var5 -= 2;
                                       var74 = class32.field732[var5] == 1;
                                       var82 = class32.field732[var5 + 1] == 1;
                                       if(null != class109.field1748) {
                                          class109.field1748.method11(new class44(var82), var74);
                                       }
                                       continue;
                                    }

                                    if(var42 == 3917) {
                                       --var5;
                                       var74 = class32.field732[var5] == 1;
                                       if(null != class109.field1748) {
                                          class109.field1748.method11(class1.field11, var74);
                                       }
                                       continue;
                                    }

                                    if(var42 == 3918) {
                                       --var5;
                                       var74 = class32.field732[var5] == 1;
                                       if(class109.field1748 != null) {
                                          class109.field1748.method11(class1.field10, var74);
                                       }
                                       continue;
                                    }

                                    if(var42 == 3919) {
                                       class32.field732[var5++] = class109.field1748 == null?0:class109.field1748.field7.size();
                                       continue;
                                    }

                                    class2 var50;
                                    if(var42 == 3920) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       class32.field732[var5++] = var50.field17;
                                       continue;
                                    }

                                    if(var42 == 3921) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       class32.chatboxSegments[var6++] = var50.method24();
                                       continue;
                                    }

                                    if(var42 == 3922) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       class32.chatboxSegments[var6++] = var50.method17();
                                       continue;
                                    }

                                    if(var42 == 3923) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       var92 = class114.method2154() - Friend.field156 - var50.field16;
                                       var19 = (int)(var92 / 3600000L);
                                       var20 = (int)((var92 - (long)(3600000 * var19)) / 60000L);
                                       var21 = (int)((var92 - (long)(3600000 * var19) - (long)('\uea60' * var20)) / 1000L);
                                       String var36 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                       class32.chatboxSegments[var6++] = var36;
                                       continue;
                                    }

                                    if(var42 == 3924) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       class32.field732[var5++] = var50.field19.totalQuantity;
                                       continue;
                                    }

                                    if(var42 == 3925) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       class32.field732[var5++] = var50.field19.price;
                                       continue;
                                    }

                                    if(var42 == 3926) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var50 = (class2)class109.field1748.field7.get(var15);
                                       class32.field732[var5++] = var50.field19.itemId;
                                       continue;
                                    }
                                 } else if(var42 < 4100) {
                                    if(var42 == 4000) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       class32.field732[var5++] = var31 + var15;
                                       continue;
                                    }

                                    if(var42 == 4001) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[var5 + 1];
                                       class32.field732[var5++] = var15 - var31;
                                       continue;
                                    }

                                    if(var42 == 4002) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       class32.field732[var5++] = var31 * var15;
                                       continue;
                                    }

                                    if(var42 == 4003) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[var5 + 1];
                                       class32.field732[var5++] = var15 / var31;
                                       continue;
                                    }

                                    if(var42 == 4004) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = (int)(Math.random() * (double)var15);
                                       continue;
                                    }

                                    if(var42 == 4005) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.field732[var5++] = (int)(Math.random() * (double)(var15 + 1));
                                       continue;
                                    }

                                    if(var42 == 4006) {
                                       var5 -= 5;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       var32 = class32.field732[2 + var5];
                                       var29 = class32.field732[3 + var5];
                                       var19 = class32.field732[var5 + 4];
                                       class32.field732[var5++] = (var19 - var32) * (var31 - var15) / (var29 - var32) + var15;
                                       continue;
                                    }

                                    if(var42 == 4007) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[var5 + 1];
                                       class32.field732[var5++] = var15 * var31 / 100 + var15;
                                       continue;
                                    }

                                    if(var42 == 4008) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[var5 + 1];
                                       class32.field732[var5++] = var15 | 1 << var31;
                                       continue;
                                    }

                                    if(var42 == 4009) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[var5 + 1];
                                       class32.field732[var5++] = var15 & -1 - (1 << var31);
                                       continue;
                                    }

                                    if(var42 == 4010) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       class32.field732[var5++] = (var15 & 1 << var31) != 0?1:0;
                                       continue;
                                    }

                                    if(var42 == 4011) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       class32.field732[var5++] = var15 % var31;
                                       continue;
                                    }

                                    if(var42 == 4012) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[var5 + 1];
                                       if(var15 == 0) {
                                          class32.field732[var5++] = 0;
                                       } else {
                                          class32.field732[var5++] = (int)Math.pow((double)var15, (double)var31);
                                       }
                                       continue;
                                    }

                                    if(var42 == 4013) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       if(var15 == 0) {
                                          class32.field732[var5++] = 0;
                                       } else if(var31 == 0) {
                                          class32.field732[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class32.field732[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var31);
                                       }
                                       continue;
                                    }

                                    if(var42 == 4014) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       class32.field732[var5++] = var15 & var31;
                                       continue;
                                    }

                                    if(var42 == 4015) {
                                       var5 -= 2;
                                       var15 = class32.field732[var5];
                                       var31 = class32.field732[1 + var5];
                                       class32.field732[var5++] = var15 | var31;
                                       continue;
                                    }

                                    if(var42 == 4018) {
                                       var5 -= 3;
                                       long var80 = (long)class32.field732[var5];
                                       var92 = (long)class32.field732[var5 + 1];
                                       long var71 = (long)class32.field732[2 + var5];
                                       class32.field732[var5++] = (int)(var80 * var71 / var92);
                                       continue;
                                    }
                                 } else if(var42 < 4200) {
                                    if(var42 == 4100) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       --var5;
                                       var31 = class32.field732[var5];
                                       class32.chatboxSegments[var6++] = var106 + var31;
                                       continue;
                                    }

                                    if(var42 == 4101) {
                                       var6 -= 2;
                                       var106 = class32.chatboxSegments[var6];
                                       var44 = class32.chatboxSegments[var6 + 1];
                                       class32.chatboxSegments[var6++] = var106 + var44;
                                       continue;
                                    }

                                    if(var42 == 4102) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       --var5;
                                       var31 = class32.field732[var5];
                                       class32.chatboxSegments[var6++] = var106 + KitDefinition.method3411(var31, true);
                                       continue;
                                    }

                                    if(var42 == 4103) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       class32.chatboxSegments[var6++] = var106.toLowerCase();
                                       continue;
                                    }

                                    if(var42 == 4104) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       long var109 = (11745L + (long)var15) * 86400000L;
                                       class32.field737.setTime(new Date(var109));
                                       var29 = class32.field737.get(5);
                                       var19 = class32.field737.get(2);
                                       var20 = class32.field737.get(1);
                                       class32.chatboxSegments[var6++] = var29 + "-" + class32.field729[var19] + "-" + var20;
                                       continue;
                                    }

                                    if(var42 == 4105) {
                                       var6 -= 2;
                                       var106 = class32.chatboxSegments[var6];
                                       var44 = class32.chatboxSegments[1 + var6];
                                       if(class5.localPlayer.composition != null && class5.localPlayer.composition.isFemale) {
                                          class32.chatboxSegments[var6++] = var44;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = var106;
                                       continue;
                                    }

                                    if(var42 == 4106) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       class32.chatboxSegments[var6++] = Integer.toString(var15);
                                       continue;
                                    }

                                    if(var42 == 4107) {
                                       var6 -= 2;
                                       int[] var110 = class32.field732;
                                       var31 = var5++;
                                       var29 = VertexNormal.method1597(class32.chatboxSegments[var6], class32.chatboxSegments[var6 + 1], Client.field509);
                                       if(var29 > 0) {
                                          var105 = 1;
                                       } else if(var29 < 0) {
                                          var105 = -1;
                                       } else {
                                          var105 = 0;
                                       }

                                       var110[var31] = var105;
                                       continue;
                                    }

                                    class208 var100;
                                    if(var42 == 4108) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       var5 -= 2;
                                       var31 = class32.field732[var5];
                                       var32 = class32.field732[var5 + 1];
                                       var61 = class45.field907.method3203(var32, 0);
                                       var100 = new class208(var61);
                                       class32.field732[var5++] = var100.method3816(var106, var31);
                                       continue;
                                    }

                                    if(var42 == 4109) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       var5 -= 2;
                                       var31 = class32.field732[var5];
                                       var32 = class32.field732[1 + var5];
                                       var61 = class45.field907.method3203(var32, 0);
                                       var100 = new class208(var61);
                                       class32.field732[var5++] = var100.method3781(var106, var31);
                                       continue;
                                    }

                                    if(var42 == 4110) {
                                       var6 -= 2;
                                       var106 = class32.chatboxSegments[var6];
                                       var44 = class32.chatboxSegments[1 + var6];
                                       --var5;
                                       if(class32.field732[var5] == 1) {
                                          class32.chatboxSegments[var6++] = var106;
                                       } else {
                                          class32.chatboxSegments[var6++] = var44;
                                       }
                                       continue;
                                    }

                                    if(var42 == 4111) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       class32.chatboxSegments[var6++] = class209.method3783(var106);
                                       continue;
                                    }

                                    if(var42 == 4112) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       --var5;
                                       var31 = class32.field732[var5];
                                       class32.chatboxSegments[var6++] = var106 + (char)var31;
                                       continue;
                                    }

                                    char var72;
                                    if(var42 == 4113) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var16 = class32.field732;
                                       var32 = var5++;
                                       var72 = (char)var15;
                                       if(var72 >= 32 && var72 <= 126) {
                                          var83 = true;
                                       } else if(var72 >= 160 && var72 <= 255) {
                                          var83 = true;
                                       } else if(var72 != 8364 && var72 != 338 && var72 != 8212 && var72 != 339 && var72 != 376) {
                                          var83 = false;
                                       } else {
                                          var83 = true;
                                       }

                                       var16[var32] = var83?1:0;
                                       continue;
                                    }

                                    if(var42 == 4114) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var16 = class32.field732;
                                       var32 = var5++;
                                       var72 = (char)var15;
                                       var83 = var72 >= 48 && var72 <= 57 || var72 >= 65 && var72 <= 90 || var72 >= 97 && var72 <= 122;
                                       var16[var32] = var83?1:0;
                                       continue;
                                    }

                                    if(var42 == 4115) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var16 = class32.field732;
                                       var32 = var5++;
                                       var72 = (char)var15;
                                       var83 = var72 >= 65 && var72 <= 90 || var72 >= 97 && var72 <= 122;
                                       var16[var32] = var83?1:0;
                                       continue;
                                    }

                                    if(var42 == 4116) {
                                       --var5;
                                       var15 = class32.field732[var5];
                                       var16 = class32.field732;
                                       var32 = var5++;
                                       var72 = (char)var15;
                                       var83 = var72 >= 48 && var72 <= 57;
                                       var16[var32] = var83?1:0;
                                       continue;
                                    }

                                    if(var42 == 4117) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       if(null != var106) {
                                          class32.field732[var5++] = var106.length();
                                       } else {
                                          class32.field732[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var42 == 4118) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       var5 -= 2;
                                       var31 = class32.field732[var5];
                                       var32 = class32.field732[var5 + 1];
                                       class32.chatboxSegments[var6++] = var106.substring(var31, var32);
                                       continue;
                                    }

                                    if(var42 == 4119) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       StringBuilder var56 = new StringBuilder(var106.length());
                                       var99 = false;

                                       for(var29 = 0; var29 < var106.length(); ++var29) {
                                          var72 = var106.charAt(var29);
                                          if(var72 == 60) {
                                             var99 = true;
                                          } else if(var72 == 62) {
                                             var99 = false;
                                          } else if(!var99) {
                                             var56.append(var72);
                                          }
                                       }

                                       class32.chatboxSegments[var6++] = var56.toString();
                                       continue;
                                    }

                                    if(var42 == 4120) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       --var5;
                                       var31 = class32.field732[var5];
                                       class32.field732[var5++] = var106.indexOf(var31);
                                       continue;
                                    }

                                    if(var42 == 4121) {
                                       var6 -= 2;
                                       var106 = class32.chatboxSegments[var6];
                                       var44 = class32.chatboxSegments[var6 + 1];
                                       --var5;
                                       var32 = class32.field732[var5];
                                       class32.field732[var5++] = var106.indexOf(var44, var32);
                                       continue;
                                    }
                                 } else {
                                    int var24;
                                    if(var42 < 4300) {
                                       if(var42 == 4200) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.chatboxSegments[var6++] = class137.getItemDefinition(var15).name;
                                          continue;
                                       }

                                       ItemComposition var55;
                                       if(var42 == 4201) {
                                          var5 -= 2;
                                          var15 = class32.field732[var5];
                                          var31 = class32.field732[1 + var5];
                                          var55 = class137.getItemDefinition(var15);
                                          if(var31 >= 1 && var31 <= 5 && var55.groundActions[var31 - 1] != null) {
                                             class32.chatboxSegments[var6++] = var55.groundActions[var31 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var42 == 4202) {
                                          var5 -= 2;
                                          var15 = class32.field732[var5];
                                          var31 = class32.field732[var5 + 1];
                                          var55 = class137.getItemDefinition(var15);
                                          if(var31 >= 1 && var31 <= 5 && var55.inventoryActions[var31 - 1] != null) {
                                             class32.chatboxSegments[var6++] = var55.inventoryActions[var31 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var42 == 4203) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.field732[var5++] = class137.getItemDefinition(var15).price;
                                          continue;
                                       }

                                       if(var42 == 4204) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.field732[var5++] = class137.getItemDefinition(var15).isStackable == 1?1:0;
                                          continue;
                                       }

                                       ItemComposition var65;
                                       if(var42 == 4205) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          var65 = class137.getItemDefinition(var15);
                                          if(var65.field2980 == -1 && var65.note >= 0) {
                                             class32.field732[var5++] = var65.note;
                                             continue;
                                          }

                                          class32.field732[var5++] = var15;
                                          continue;
                                       }

                                       if(var42 == 4206) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          var65 = class137.getItemDefinition(var15);
                                          if(var65.field2980 >= 0 && var65.note >= 0) {
                                             class32.field732[var5++] = var65.note;
                                             continue;
                                          }

                                          class32.field732[var5++] = var15;
                                          continue;
                                       }

                                       if(var42 == 4207) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.field732[var5++] = class137.getItemDefinition(var15).isMembers?1:0;
                                          continue;
                                       }

                                       if(var42 == 4208) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          var65 = class137.getItemDefinition(var15);
                                          if(var65.field2955 == -1 && var65.field2950 >= 0) {
                                             class32.field732[var5++] = var65.field2950;
                                             continue;
                                          }

                                          class32.field732[var5++] = var15;
                                          continue;
                                       }

                                       if(var42 == 4209) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          var65 = class137.getItemDefinition(var15);
                                          if(var65.field2955 >= 0 && var65.field2950 >= 0) {
                                             class32.field732[var5++] = var65.field2950;
                                             continue;
                                          }

                                          class32.field732[var5++] = var15;
                                          continue;
                                       }

                                       if(var42 == 4210) {
                                          --var6;
                                          var106 = class32.chatboxSegments[var6];
                                          --var5;
                                          var31 = class32.field732[var5];
                                          var83 = var31 == 1;
                                          var17 = var106.toLowerCase();
                                          short[] var101 = new short[16];
                                          var20 = 0;
                                          var21 = 0;

                                          while(true) {
                                             if(var21 >= ItemComposition.field2968) {
                                                class0.field4 = var101;
                                                class177.field2679 = 0;
                                                field121 = var20;
                                                String[] var88 = new String[field121];

                                                for(var22 = 0; var22 < field121; ++var22) {
                                                   var88[var22] = class137.getItemDefinition(var101[var22]).name;
                                                }

                                                short[] var94 = class0.field4;
                                                Friend.method171(var88, var94, 0, var88.length - 1);
                                                break;
                                             }

                                             ItemComposition var93 = class137.getItemDefinition(var21);
                                             if((!var83 || var93.field2987) && var93.field2980 == -1 && var93.name.toLowerCase().indexOf(var17) != -1) {
                                                if(var20 >= 250) {
                                                   field121 = -1;
                                                   class0.field4 = null;
                                                   break;
                                                }

                                                if(var20 >= var101.length) {
                                                   short[] var23 = new short[2 * var101.length];

                                                   for(var24 = 0; var24 < var20; ++var24) {
                                                      var23[var24] = var101[var24];
                                                   }

                                                   var101 = var23;
                                                }

                                                var101[var20++] = (short)var21;
                                             }

                                             ++var21;
                                          }

                                          class32.field732[var5++] = field121;
                                          continue;
                                       }

                                       if(var42 == 4211) {
                                          if(class0.field4 != null && class177.field2679 < field121) {
                                             class32.field732[var5++] = class0.field4[++class177.field2679 - 1] & '\uffff';
                                             continue;
                                          }

                                          class32.field732[var5++] = -1;
                                          continue;
                                       }

                                       if(var42 == 4212) {
                                          class177.field2679 = 0;
                                          continue;
                                       }
                                    } else if(var42 < 5100) {
                                       if(var42 == 5000) {
                                          class32.field732[var5++] = Client.field352;
                                          continue;
                                       }

                                       if(var42 == 5001) {
                                          var5 -= 3;
                                          Client.field352 = class32.field732[var5];
                                          var31 = class32.field732[1 + var5];
                                          class216[] var62 = class205.method3731();
                                          var29 = 0;

                                          class216 var111;
                                          while(true) {
                                             if(var29 >= var62.length) {
                                                var111 = null;
                                                break;
                                             }

                                             class216 var102 = var62[var29];
                                             if(var31 == var102.field3164) {
                                                var111 = var102;
                                                break;
                                             }

                                             ++var29;
                                          }

                                          class20.field222 = var111;
                                          if(null == class20.field222) {
                                             class20.field222 = class216.field3161;
                                          }

                                          Client.field503 = class32.field732[var5 + 2];
                                          Client.field330.method2967(224);
                                          Client.field330.method2815(Client.field352);
                                          Client.field330.method2815(class20.field222.field3164);
                                          Client.field330.method2815(Client.field503);
                                          continue;
                                       }

                                       if(var42 == 5002) {
                                          --var6;
                                          var106 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var31 = class32.field732[var5];
                                          var32 = class32.field732[var5 + 1];
                                          Client.field330.method2967(163);
                                          Client.field330.method2815(class112.method2050(var106) + 2);
                                          Client.field330.method2717(var106);
                                          Client.field330.method2815(var31 - 1);
                                          Client.field330.method2815(var32);
                                          continue;
                                       }

                                       if(var42 == 5003) {
                                          var5 -= 2;
                                          var15 = class32.field732[var5];
                                          var31 = class32.field732[1 + var5];
                                          MessageNode var60 = BufferProvider.method3988(var15, var31);
                                          if(null != var60) {
                                             class32.field732[var5++] = var60.id;
                                             class32.field732[var5++] = var60.tick;
                                             class32.chatboxSegments[var6++] = var60.name != null?var60.name:"";
                                             class32.chatboxSegments[var6++] = null != var60.sender?var60.sender:"";
                                             class32.chatboxSegments[var6++] = null != var60.value?var60.value:"";
                                          } else {
                                             class32.field732[var5++] = -1;
                                             class32.field732[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var42 == 5004) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          MessageNode var69 = class48.method877(var15);
                                          if(null != var69) {
                                             class32.field732[var5++] = var69.type;
                                             class32.field732[var5++] = var69.tick;
                                             class32.chatboxSegments[var6++] = null != var69.name?var69.name:"";
                                             class32.chatboxSegments[var6++] = var69.sender != null?var69.sender:"";
                                             class32.chatboxSegments[var6++] = null != var69.value?var69.value:"";
                                          } else {
                                             class32.field732[var5++] = -1;
                                             class32.field732[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var42 == 5005) {
                                          if(class20.field222 == null) {
                                             class32.field732[var5++] = -1;
                                          } else {
                                             class32.field732[var5++] = class20.field222.field3164;
                                          }
                                          continue;
                                       }

                                       if(var42 == 5008) {
                                          --var6;
                                          var106 = class32.chatboxSegments[var6];
                                          --var5;
                                          var31 = class32.field732[var5];
                                          var17 = var106.toLowerCase();
                                          byte var95 = 0;
                                          if(var17.startsWith("yellow:")) {
                                             var95 = 0;
                                             var106 = var106.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var95 = 1;
                                             var106 = var106.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var95 = 2;
                                             var106 = var106.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var95 = 3;
                                             var106 = var106.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var95 = 4;
                                             var106 = var106.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var95 = 5;
                                             var106 = var106.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var95 = 6;
                                             var106 = var106.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var95 = 7;
                                             var106 = var106.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var95 = 8;
                                             var106 = var106.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var95 = 9;
                                             var106 = var106.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var95 = 10;
                                             var106 = var106.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var95 = 11;
                                             var106 = var106.substring("glow3:".length());
                                          } else if(Client.field509 != 0) {
                                             if(var17.startsWith("yellow:")) {
                                                var95 = 0;
                                                var106 = var106.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var95 = 1;
                                                var106 = var106.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var95 = 2;
                                                var106 = var106.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var95 = 3;
                                                var106 = var106.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var95 = 4;
                                                var106 = var106.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var95 = 5;
                                                var106 = var106.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var95 = 6;
                                                var106 = var106.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var95 = 7;
                                                var106 = var106.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var95 = 8;
                                                var106 = var106.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var95 = 9;
                                                var106 = var106.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var95 = 10;
                                                var106 = var106.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var95 = 11;
                                                var106 = var106.substring("glow3:".length());
                                             }
                                          }

                                          var17 = var106.toLowerCase();
                                          byte var75 = 0;
                                          if(var17.startsWith("wave:")) {
                                             var75 = 1;
                                             var106 = var106.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var75 = 2;
                                             var106 = var106.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var75 = 3;
                                             var106 = var106.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var75 = 4;
                                             var106 = var106.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var75 = 5;
                                             var106 = var106.substring("slide:".length());
                                          } else if(Client.field509 != 0) {
                                             if(var17.startsWith("wave:")) {
                                                var75 = 1;
                                                var106 = var106.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var75 = 2;
                                                var106 = var106.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var75 = 3;
                                                var106 = var106.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var75 = 4;
                                                var106 = var106.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var75 = 5;
                                                var106 = var106.substring("slide:".length());
                                             }
                                          }

                                          Client.field330.method2967(179);
                                          Client.field330.method2815(0);
                                          var20 = Client.field330.offset;
                                          Client.field330.method2815(var31);
                                          Client.field330.method2815(var95);
                                          Client.field330.method2815(var75);
                                          class159 var91 = Client.field330;
                                          var22 = var91.offset;
                                          var24 = var106.length();
                                          byte[] var25 = new byte[var24];

                                          for(int var26 = 0; var26 < var24; ++var26) {
                                             char var27 = var106.charAt(var26);
                                             if((var27 <= 0 || var27 >= 128) && (var27 < 160 || var27 > 255)) {
                                                if(var27 == 8364) {
                                                   var25[var26] = -128;
                                                } else if(var27 == 8218) {
                                                   var25[var26] = -126;
                                                } else if(var27 == 402) {
                                                   var25[var26] = -125;
                                                } else if(var27 == 8222) {
                                                   var25[var26] = -124;
                                                } else if(var27 == 8230) {
                                                   var25[var26] = -123;
                                                } else if(var27 == 8224) {
                                                   var25[var26] = -122;
                                                } else if(var27 == 8225) {
                                                   var25[var26] = -121;
                                                } else if(var27 == 710) {
                                                   var25[var26] = -120;
                                                } else if(var27 == 8240) {
                                                   var25[var26] = -119;
                                                } else if(var27 == 352) {
                                                   var25[var26] = -118;
                                                } else if(var27 == 8249) {
                                                   var25[var26] = -117;
                                                } else if(var27 == 338) {
                                                   var25[var26] = -116;
                                                } else if(var27 == 381) {
                                                   var25[var26] = -114;
                                                } else if(var27 == 8216) {
                                                   var25[var26] = -111;
                                                } else if(var27 == 8217) {
                                                   var25[var26] = -110;
                                                } else if(var27 == 8220) {
                                                   var25[var26] = -109;
                                                } else if(var27 == 8221) {
                                                   var25[var26] = -108;
                                                } else if(var27 == 8226) {
                                                   var25[var26] = -107;
                                                } else if(var27 == 8211) {
                                                   var25[var26] = -106;
                                                } else if(var27 == 8212) {
                                                   var25[var26] = -105;
                                                } else if(var27 == 732) {
                                                   var25[var26] = -104;
                                                } else if(var27 == 8482) {
                                                   var25[var26] = -103;
                                                } else if(var27 == 353) {
                                                   var25[var26] = -102;
                                                } else if(var27 == 8250) {
                                                   var25[var26] = -101;
                                                } else if(var27 == 339) {
                                                   var25[var26] = -100;
                                                } else if(var27 == 382) {
                                                   var25[var26] = -98;
                                                } else if(var27 == 376) {
                                                   var25[var26] = -97;
                                                } else {
                                                   var25[var26] = 63;
                                                }
                                             } else {
                                                var25[var26] = (byte)var27;
                                             }
                                          }

                                          var91.method2724(var25.length);
                                          var91.offset += class9.field78.method2658(var25, 0, var25.length, var91.payload, var91.offset);
                                          Client.field330.method2909(Client.field330.offset - var20);
                                          continue;
                                       }

                                       if(var42 == 5009) {
                                          var6 -= 2;
                                          var106 = class32.chatboxSegments[var6];
                                          var44 = class32.chatboxSegments[var6 + 1];
                                          Client.field330.method2967(130);
                                          Client.field330.method2712(0);
                                          var32 = Client.field330.offset;
                                          Client.field330.method2717(var106);
                                          class159 var63 = Client.field330;
                                          var19 = var63.offset;
                                          var21 = var44.length();
                                          byte[] var96 = new byte[var21];

                                          for(int var38 = 0; var38 < var21; ++var38) {
                                             char var66 = var44.charAt(var38);
                                             if((var66 <= 0 || var66 >= 128) && (var66 < 160 || var66 > 255)) {
                                                if(var66 == 8364) {
                                                   var96[var38] = -128;
                                                } else if(var66 == 8218) {
                                                   var96[var38] = -126;
                                                } else if(var66 == 402) {
                                                   var96[var38] = -125;
                                                } else if(var66 == 8222) {
                                                   var96[var38] = -124;
                                                } else if(var66 == 8230) {
                                                   var96[var38] = -123;
                                                } else if(var66 == 8224) {
                                                   var96[var38] = -122;
                                                } else if(var66 == 8225) {
                                                   var96[var38] = -121;
                                                } else if(var66 == 710) {
                                                   var96[var38] = -120;
                                                } else if(var66 == 8240) {
                                                   var96[var38] = -119;
                                                } else if(var66 == 352) {
                                                   var96[var38] = -118;
                                                } else if(var66 == 8249) {
                                                   var96[var38] = -117;
                                                } else if(var66 == 338) {
                                                   var96[var38] = -116;
                                                } else if(var66 == 381) {
                                                   var96[var38] = -114;
                                                } else if(var66 == 8216) {
                                                   var96[var38] = -111;
                                                } else if(var66 == 8217) {
                                                   var96[var38] = -110;
                                                } else if(var66 == 8220) {
                                                   var96[var38] = -109;
                                                } else if(var66 == 8221) {
                                                   var96[var38] = -108;
                                                } else if(var66 == 8226) {
                                                   var96[var38] = -107;
                                                } else if(var66 == 8211) {
                                                   var96[var38] = -106;
                                                } else if(var66 == 8212) {
                                                   var96[var38] = -105;
                                                } else if(var66 == 732) {
                                                   var96[var38] = -104;
                                                } else if(var66 == 8482) {
                                                   var96[var38] = -103;
                                                } else if(var66 == 353) {
                                                   var96[var38] = -102;
                                                } else if(var66 == 8250) {
                                                   var96[var38] = -101;
                                                } else if(var66 == 339) {
                                                   var96[var38] = -100;
                                                } else if(var66 == 382) {
                                                   var96[var38] = -98;
                                                } else if(var66 == 376) {
                                                   var96[var38] = -97;
                                                } else {
                                                   var96[var38] = 63;
                                                }
                                             } else {
                                                var96[var38] = (byte)var66;
                                             }
                                          }

                                          var63.method2724(var96.length);
                                          var63.offset += class9.field78.method2658(var96, 0, var96.length, var63.payload, var63.offset);
                                          Client.field330.method2722(Client.field330.offset - var32);
                                          continue;
                                       }

                                       if(var42 == 5015) {
                                          if(null != class5.localPlayer && null != class5.localPlayer.name) {
                                             var106 = class5.localPlayer.name;
                                          } else {
                                             var106 = "";
                                          }

                                          class32.chatboxSegments[var6++] = var106;
                                          continue;
                                       }

                                       if(var42 == 5016) {
                                          class32.field732[var5++] = Client.field503;
                                          continue;
                                       }

                                       if(var42 == 5017) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.field732[var5++] = MessageNode.method203(var15);
                                          continue;
                                       }

                                       if(var42 == 5018) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.field732[var5++] = class110.method2018(var15);
                                          continue;
                                       }

                                       if(var42 == 5019) {
                                          --var5;
                                          var15 = class32.field732[var5];
                                          class32.field732[var5++] = class40.method734(var15);
                                          continue;
                                       }

                                       if(var42 == 5020) {
                                          --var6;
                                          var106 = class32.chatboxSegments[var6];
                                          if(var106.equalsIgnoreCase("toggleroof")) {
                                             XGrandExchangeOffer.field35.field699 = !XGrandExchangeOffer.field35.field699;
                                             class119.method2234();
                                             if(XGrandExchangeOffer.field35.field699) {
                                                class16.method183(99, "", "Roofs are now all hidden");
                                             } else {
                                                class16.method183(99, "", "Roofs will only be removed selectively");
                                             }
                                          }

                                          if(var106.equalsIgnoreCase("displayfps")) {
                                             Client.field475 = !Client.field475;
                                          }

                                          if(Client.field451 >= 2) {
                                             if(var106.equalsIgnoreCase("fpson")) {
                                                Client.field475 = true;
                                             }

                                             if(var106.equalsIgnoreCase("fpsoff")) {
                                                Client.field475 = false;
                                             }

                                             if(var106.equalsIgnoreCase("gc")) {
                                                System.gc();
                                             }

                                             if(var106.equalsIgnoreCase("clientdrop")) {
                                                WallObject.method1842();
                                             }

                                             if(var106.equalsIgnoreCase("errortest") && Client.field428 == 2) {
                                                throw new RuntimeException();
                                             }
                                          }

                                          Client.field330.method2967(54);
                                          Client.field330.method2815(var106.length() + 1);
                                          Client.field330.method2717(var106);
                                          continue;
                                       }

                                       if(var42 == 5021) {
                                          --var6;
                                          Client.field303 = class32.chatboxSegments[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var42 == 5022) {
                                          class32.chatboxSegments[var6++] = Client.field303;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        var31 = -1;
                        if(var42 >= 2000) {
                           var42 -= 1000;
                           --var5;
                           var31 = class32.field732[var5];
                           var30 = class174.method3178(var31);
                        } else {
                           var30 = var53?class32.field736:class150.field2060;
                        }

                        if(var42 == 1100) {
                           var5 -= 2;
                           var30.scrollX = class32.field732[var5];
                           if(var30.scrollX > var30.scrollWidth - var30.width) {
                              var30.scrollX = var30.scrollWidth - var30.width;
                           }

                           if(var30.scrollX < 0) {
                              var30.scrollX = 0;
                           }

                           var30.scrollY = class32.field732[var5 + 1];
                           if(var30.scrollY > var30.scrollHeight - var30.height) {
                              var30.scrollY = var30.scrollHeight - var30.height;
                           }

                           if(var30.scrollY < 0) {
                              var30.scrollY = 0;
                           }

                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1101) {
                           --var5;
                           var30.textColor = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1102) {
                           --var5;
                           var30.field2300 = class32.field732[var5] == 1;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1103) {
                           --var5;
                           var30.opacity = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1104) {
                           --var5;
                           var30.field2311 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1105) {
                           --var5;
                           var30.textureId = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1106) {
                           --var5;
                           var30.field2244 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1107) {
                           --var5;
                           var30.field2245 = class32.field732[var5] == 1;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1108) {
                           var30.modelType = 1;
                           --var5;
                           var30.modelId = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1109) {
                           var5 -= 6;
                           var30.field2291 = class32.field732[var5];
                           var30.field2257 = class32.field732[1 + var5];
                           var30.rotationX = class32.field732[2 + var5];
                           var30.rotationZ = class32.field732[var5 + 3];
                           var30.rotationY = class32.field732[var5 + 4];
                           var30.field2261 = class32.field732[var5 + 5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1110) {
                           --var5;
                           var32 = class32.field732[var5];
                           if(var32 != var30.field2254) {
                              var30.field2254 = var32;
                              var30.field2329 = 0;
                              var30.field2226 = 0;
                              class97.method1886(var30);
                           }
                           continue;
                        }

                        if(var42 == 1111) {
                           --var5;
                           var30.field2341 = class32.field732[var5] == 1;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1112) {
                           --var6;
                           var17 = class32.chatboxSegments[var6];
                           if(!var17.equals(var30.text)) {
                              var30.text = var17;
                              class97.method1886(var30);
                           }
                           continue;
                        }

                        if(var42 == 1113) {
                           --var5;
                           var30.field2266 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1114) {
                           var5 -= 3;
                           var30.field2270 = class32.field732[var5];
                           var30.field2271 = class32.field732[1 + var5];
                           var30.field2210 = class32.field732[var5 + 2];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1115) {
                           --var5;
                           var30.field2205 = class32.field732[var5] == 1;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1116) {
                           --var5;
                           var30.borderThickness = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1117) {
                           --var5;
                           var30.sprite2 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1118) {
                           --var5;
                           var30.flippedVertically = class32.field732[var5] == 1;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1119) {
                           --var5;
                           var30.flippedHorizontally = class32.field732[var5] == 1;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1120) {
                           var5 -= 2;
                           var30.scrollWidth = class32.field732[var5];
                           var30.scrollHeight = class32.field732[1 + var5];
                           class97.method1886(var30);
                           if(var31 != -1 && var30.type == 0) {
                              Renderable.method1833(Widget.widgets[var31 >> 16], var30, false);
                           }
                           continue;
                        }

                        if(var42 == 1121) {
                           var32 = var30.id;
                           var29 = var30.index;
                           Client.field330.method2967(53);
                           Client.field330.method2922(var29);
                           Client.field330.method2791(var32);
                           Client.field448 = var30;
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1122) {
                           --var5;
                           var30.field2243 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1123) {
                           --var5;
                           var30.field2233 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1124) {
                           --var5;
                           var30.field2199 = class32.field732[var5];
                           class97.method1886(var30);
                           continue;
                        }

                        if(var42 == 1125) {
                           --var5;
                           var32 = class32.field732[var5];
                           class221[] var18 = new class221[]{class221.field3186, class221.field3184, class221.field3182, class221.field3185, class221.field3188};
                           class221 var33 = (class221)FileOnDisk.method1390(var18, var32);
                           if(null != var33) {
                              var30.field2241 = var33;
                              class97.method1886(var30);
                           }
                           continue;
                        }
                     }
                  }
               }

               if(var42 < 5400) {
                  if(var42 == 5306) {
                     class32.field732[var5++] = class47.method871();
                     continue;
                  }

                  if(var42 == 5307) {
                     --var5;
                     var15 = class32.field732[var5];
                     if(var15 != 1 && var15 != 2) {
                        continue;
                     }

                     Client.field497 = 0L;
                     if(var15 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     class8.method89();
                     if(Client.gameState >= 25) {
                        Client.field330.method2967(92);
                        Client.field330.method2815(class47.method871());
                        Client.field330.method2712(TextureProvider.field1200);
                        Client.field330.method2712(class94.field1584);
                     }

                     GameEngine.field1797 = true;
                     continue;
                  }

                  if(var42 == 5308) {
                     class32.field732[var5++] = XGrandExchangeOffer.field35.field701;
                     continue;
                  }

                  if(var42 == 5309) {
                     --var5;
                     var15 = class32.field732[var5];
                     if(var15 == 1 || var15 == 2) {
                        XGrandExchangeOffer.field35.field701 = var15;
                        class119.method2234();
                     }
                     continue;
                  }
               }

               if(var42 < 5600) {
                  if(var42 == 5504) {
                     var5 -= 2;
                     var15 = class32.field732[var5];
                     var31 = class32.field732[1 + var5];
                     if(!Client.field554) {
                        Client.field370 = var15;
                        Client.mapAngle = var31;
                     }
                     continue;
                  }

                  if(var42 == 5505) {
                     class32.field732[var5++] = Client.field370;
                     continue;
                  }

                  if(var42 == 5506) {
                     class32.field732[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var42 == 5530) {
                     --var5;
                     var15 = class32.field732[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field321 = var15;
                     continue;
                  }

                  if(var42 == 5531) {
                     class32.field732[var5++] = Client.field321;
                     continue;
                  }
               }

               if(var42 < 5700 && var42 == 5630) {
                  Client.field340 = 250;
               } else {
                  if(var42 < 6300) {
                     if(var42 == 6200) {
                        var5 -= 2;
                        Client.field538 = (short)class32.field732[var5];
                        if(Client.field538 <= 0) {
                           Client.field538 = 256;
                        }

                        Client.field539 = (short)class32.field732[var5 + 1];
                        if(Client.field539 <= 0) {
                           Client.field539 = 205;
                        }
                        continue;
                     }

                     if(var42 == 6201) {
                        var5 -= 2;
                        Client.field366 = (short)class32.field732[var5];
                        if(Client.field366 <= 0) {
                           Client.field366 = 256;
                        }

                        Client.field394 = (short)class32.field732[var5 + 1];
                        if(Client.field394 <= 0) {
                           Client.field394 = 320;
                        }
                        continue;
                     }

                     if(var42 == 6202) {
                        var5 -= 4;
                        Client.field397 = (short)class32.field732[var5];
                        if(Client.field397 <= 0) {
                           Client.field397 = 1;
                        }

                        Client.field462 = (short)class32.field732[1 + var5];
                        if(Client.field462 <= 0) {
                           Client.field462 = 32767;
                        } else if(Client.field462 < Client.field397) {
                           Client.field462 = Client.field397;
                        }

                        Client.field544 = (short)class32.field732[var5 + 2];
                        if(Client.field544 <= 0) {
                           Client.field544 = 1;
                        }

                        Client.field510 = (short)class32.field732[var5 + 3];
                        if(Client.field510 <= 0) {
                           Client.field510 = 32767;
                        } else if(Client.field510 < Client.field544) {
                           Client.field510 = Client.field544;
                        }
                        continue;
                     }

                     if(var42 == 6203) {
                        if(Client.field566 != null) {
                           class202.method3707(0, 0, Client.field566.width, Client.field566.height, false);
                           class32.field732[var5++] = Client.camera2;
                           class32.field732[var5++] = Client.camera3;
                        } else {
                           class32.field732[var5++] = -1;
                           class32.field732[var5++] = -1;
                        }
                        continue;
                     }

                     if(var42 == 6204) {
                        class32.field732[var5++] = Client.field366;
                        class32.field732[var5++] = Client.field394;
                        continue;
                     }

                     if(var42 == 6205) {
                        class32.field732[var5++] = Client.field538;
                        class32.field732[var5++] = Client.field539;
                        continue;
                     }
                  }

                  if(var42 < 6600) {
                     if(var42 == 6500) {
                        class32.field732[var5++] = class25.loadWorlds()?1:0;
                        continue;
                     }

                     World var112;
                     if(var42 == 6501) {
                        World.field680 = 0;
                        var112 = TextureProvider.method1431();
                        if(null != var112) {
                           class32.field732[var5++] = var112.id;
                           class32.field732[var5++] = var112.mask;
                           class32.chatboxSegments[var6++] = var112.activity;
                           class32.field732[var5++] = var112.location;
                           class32.field732[var5++] = var112.playerCount;
                           class32.chatboxSegments[var6++] = var112.address;
                        } else {
                           class32.field732[var5++] = -1;
                           class32.field732[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field732[var5++] = 0;
                           class32.field732[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var42 == 6502) {
                        var112 = TextureProvider.method1431();
                        if(var112 != null) {
                           class32.field732[var5++] = var112.id;
                           class32.field732[var5++] = var112.mask;
                           class32.chatboxSegments[var6++] = var112.activity;
                           class32.field732[var5++] = var112.location;
                           class32.field732[var5++] = var112.playerCount;
                           class32.chatboxSegments[var6++] = var112.address;
                        } else {
                           class32.field732[var5++] = -1;
                           class32.field732[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field732[var5++] = 0;
                           class32.field732[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var76;
                     if(var42 == 6506) {
                        --var5;
                        var15 = class32.field732[var5];
                        var76 = null;

                        for(var32 = 0; var32 < World.field679; ++var32) {
                           if(var15 == World.worldList[var32].id) {
                              var76 = World.worldList[var32];
                              break;
                           }
                        }

                        if(var76 != null) {
                           class32.field732[var5++] = var76.id;
                           class32.field732[var5++] = var76.mask;
                           class32.chatboxSegments[var6++] = var76.activity;
                           class32.field732[var5++] = var76.location;
                           class32.field732[var5++] = var76.playerCount;
                           class32.chatboxSegments[var6++] = var76.address;
                        } else {
                           class32.field732[var5++] = -1;
                           class32.field732[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field732[var5++] = 0;
                           class32.field732[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var42 == 6507) {
                        var5 -= 4;
                        var15 = class32.field732[var5];
                        var82 = class32.field732[1 + var5] == 1;
                        var32 = class32.field732[var5 + 2];
                        var83 = class32.field732[3 + var5] == 1;
                        if(World.worldList != null) {
                           Projectile.method772(0, World.worldList.length - 1, var15, var82, var32, var83);
                        }
                        continue;
                     }

                     if(var42 == 6511) {
                        --var5;
                        var15 = class32.field732[var5];
                        if(var15 >= 0 && var15 < World.field679) {
                           var76 = World.worldList[var15];
                           class32.field732[var5++] = var76.id;
                           class32.field732[var5++] = var76.mask;
                           class32.chatboxSegments[var6++] = var76.activity;
                           class32.field732[var5++] = var76.location;
                           class32.field732[var5++] = var76.playerCount;
                           class32.chatboxSegments[var6++] = var76.address;
                           continue;
                        }

                        class32.field732[var5++] = -1;
                        class32.field732[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field732[var5++] = 0;
                        class32.field732[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var41) {
            StringBuilder var40 = new StringBuilder(30);
            var40.append("").append(var4.hash).append(" ");

            for(var13 = class32.field734 - 1; var13 >= 0; --var13) {
               var40.append("").append(class32.field735[var13].field113.hash).append(" ");
            }

            var40.append("").append(var10);
            FaceNormal.method1844(var40.toString(), var41);
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3911"
   )
   public static void method163() {
      CombatInfo2.field2830.reset();
      CombatInfo2.field2832.reset();
   }
}

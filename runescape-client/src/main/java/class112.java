import java.awt.Component;
import java.io.File;
import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public abstract class class112 {
   @ObfuscatedName("a")
   public static File field1766;
   @ObfuscatedName("dr")
   static int[] field1769;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "52"
   )
   public abstract void vmethod2036(Component var1);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-341649815"
   )
   public abstract int vmethod2037();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-1305317040"
   )
   public static Widget method2038(int var0, int var1) {
      Widget var2 = class108.method1988(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public abstract void vmethod2041(Component var1);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass18;IB)V",
      garbageValue = "-81"
   )
   static void method2046(class18 var0, int var1) {
      Object[] var2 = var0.field205;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = Varbit.method3428(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field936;
         int[] var9 = var4.field934;
         byte var10 = -1;
         class32.field735 = 0;

         int var13;
         try {
            class0.field1 = new int[var4.field940];
            int var11 = 0;
            class32.field724 = new String[var4.field937];
            int var12 = 0;

            int var14;
            String var32;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field209;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field206;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field204 != null?var0.field204.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field208;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field204 != null?var0.field204.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field216?var0.field216.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = null != var0.field216?var0.field216.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field214;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field207;
                  }

                  class0.field1[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var32 = (String)var2[var13];
                  if(var32.equals("event_opbase")) {
                     var32 = var0.field202;
                  }

                  class32.field724[var12++] = var32;
               }
            }

            var13 = 0;
            class32.field734 = var0.field212;

            label3684:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var44 = var8[var7];
               int var15;
               int var17;
               int var18;
               int var19;
               int var20;
               String var34;
               int var38;
               int[] var55;
               String var80;
               String[] var82;
               String var103;
               if(var44 < 100) {
                  if(var44 == 0) {
                     class32.field728[var5++] = var9[var7];
                     continue;
                  }

                  if(var44 == 1) {
                     var14 = var9[var7];
                     class32.field728[var5++] = class165.widgetSettings[var14];
                     continue;
                  }

                  if(var44 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class165.widgetSettings[var14] = class32.field728[var5];
                     class2.method26(var14);
                     continue;
                  }

                  if(var44 == 3) {
                     class32.chatboxSegments[var6++] = var4.field935[var7];
                     continue;
                  }

                  if(var44 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var44 == 7) {
                     var5 -= 2;
                     if(class32.field728[var5] != class32.field728[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var44 == 8) {
                     var5 -= 2;
                     if(class32.field728[1 + var5] == class32.field728[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var44 == 9) {
                     var5 -= 2;
                     if(class32.field728[var5] < class32.field728[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var44 == 10) {
                     var5 -= 2;
                     if(class32.field728[var5] > class32.field728[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var44 == 21) {
                     if(class32.field735 == 0) {
                        return;
                     }

                     class11 var76 = class32.field730[--class32.field735];
                     var4 = var76.field122;
                     var8 = var4.field936;
                     var9 = var4.field934;
                     var7 = var76.field113;
                     class0.field1 = var76.field114;
                     class32.field724 = var76.field121;
                     continue;
                  }

                  if(var44 == 25) {
                     var14 = var9[var7];
                     class32.field728[var5++] = class20.method174(var14);
                     continue;
                  }

                  if(var44 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field728[var5];
                     Varbit var74 = class110.method2026(var14);
                     var17 = var74.leastSignificantBit;
                     var18 = var74.configId;
                     var19 = var74.mostSignificantBit;
                     var20 = class165.field2173[var19 - var18];
                     if(var15 < 0 || var15 > var20) {
                        var15 = 0;
                     }

                     var20 <<= var18;
                     class165.widgetSettings[var17] = class165.widgetSettings[var17] & ~var20 | var15 << var18 & var20;
                     continue;
                  }

                  if(var44 == 31) {
                     var5 -= 2;
                     if(class32.field728[var5] <= class32.field728[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var44 == 32) {
                     var5 -= 2;
                     if(class32.field728[var5] >= class32.field728[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var44 == 33) {
                     class32.field728[var5++] = class0.field1[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var44 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class0.field1[var10001] = class32.field728[var5];
                     continue;
                  }

                  if(var44 == 35) {
                     class32.chatboxSegments[var6++] = class32.field724[var9[var7]];
                     continue;
                  }

                  if(var44 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class32.field724[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var44 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var72 = class32.chatboxSegments;
                     if(var14 == 0) {
                        var103 = "";
                     } else if(var14 == 1) {
                        var34 = var72[var6];
                        if(var34 == null) {
                           var103 = "null";
                        } else {
                           var103 = var34.toString();
                        }
                     } else {
                        var17 = var14 + var6;
                        var18 = 0;

                        for(var19 = var6; var19 < var17; ++var19) {
                           var80 = var72[var19];
                           if(null == var80) {
                              var18 += 4;
                           } else {
                              var18 += var80.length();
                           }
                        }

                        StringBuilder var104 = new StringBuilder(var18);

                        for(var20 = var6; var20 < var17; ++var20) {
                           String var56 = var72[var20];
                           if(var56 == null) {
                              var104.append("null");
                           } else {
                              var104.append(var56);
                           }
                        }

                        var103 = var104.toString();
                     }

                     class32.chatboxSegments[var6++] = var103;
                     continue;
                  }

                  if(var44 == 38) {
                     --var5;
                     continue;
                  }

                  if(var44 == 39) {
                     --var6;
                     continue;
                  }

                  if(var44 == 40) {
                     var14 = var9[var7];
                     class48 var111 = Varbit.method3428(var14);
                     var55 = new int[var111.field940];
                     var82 = new String[var111.field937];

                     for(var18 = 0; var18 < var111.field943; ++var18) {
                        var55[var18] = class32.field728[var5 - var111.field943 + var18];
                     }

                     for(var18 = 0; var18 < var111.field939; ++var18) {
                        var82[var18] = class32.chatboxSegments[var6 - var111.field939 + var18];
                     }

                     var5 -= var111.field943;
                     var6 -= var111.field939;
                     class11 var107 = new class11();
                     var107.field122 = var4;
                     var107.field113 = var7;
                     var107.field114 = class0.field1;
                     var107.field121 = class32.field724;
                     class32.field730[++class32.field735 - 1] = var107;
                     var4 = var111;
                     var8 = var111.field936;
                     var9 = var111.field934;
                     var7 = -1;
                     class0.field1 = var55;
                     class32.field724 = var82;
                     continue;
                  }

                  if(var44 == 42) {
                     class32.field728[var5++] = Client.chatMessages.method801(var9[var7]);
                     continue;
                  }

                  if(var44 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     Client.chatMessages.method800(var10001, class32.field728[var5]);
                     continue;
                  }

                  if(var44 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var38 = class32.field728[var5];
                     if(var38 >= 0 && var38 <= 5000) {
                        class32.field729[var14] = var38;
                        byte var75 = -1;
                        if(var15 == 105) {
                           var75 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var38) {
                              continue label3684;
                           }

                           class32.field732[var14][var18] = var75;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var44 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field728[var5];
                     if(var15 >= 0 && var15 < class32.field729[var14]) {
                        class32.field728[var5++] = class32.field732[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var44 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class32.field728[var5];
                     if(var15 >= 0 && var15 < class32.field729[var14]) {
                        class32.field732[var14][var15] = class32.field728[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var44 == 47) {
                     var32 = Client.chatMessages.method803(var9[var7]);
                     if(var32 == null) {
                        var32 = "null";
                     }

                     class32.chatboxSegments[var6++] = var32;
                     continue;
                  }

                  if(var44 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     Client.chatMessages.method802(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var51;
               if(var9[var7] == 1) {
                  var51 = true;
               } else {
                  var51 = false;
               }

               Widget var33;
               boolean var53;
               Widget var66;
               Widget var77;
               Widget var86;
               boolean var97;
               if(var44 < 1000) {
                  if(var44 == 100) {
                     var5 -= 3;
                     var15 = class32.field728[var5];
                     var38 = class32.field728[1 + var5];
                     var17 = class32.field728[var5 + 2];
                     if(var38 == 0) {
                        throw new RuntimeException();
                     }

                     var86 = class108.method1988(var15);
                     if(var86.children == null) {
                        var86.children = new Widget[var17 + 1];
                     }

                     if(var86.children.length <= var17) {
                        Widget[] var100 = new Widget[1 + var17];

                        for(var20 = 0; var20 < var86.children.length; ++var20) {
                           var100[var20] = var86.children[var20];
                        }

                        var86.children = var100;
                     }

                     if(var17 > 0 && var86.children[var17 - 1] == null) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     Widget var101 = new Widget();
                     var101.type = var38;
                     var101.parentId = var101.id = var86.id;
                     var101.index = var17;
                     var101.hasScript = true;
                     var86.children[var17] = var101;
                     if(var51) {
                        class16.field181 = var101;
                     } else {
                        class32.field727 = var101;
                     }

                     class204.method3671(var86);
                     continue;
                  }

                  if(var44 == 101) {
                     var33 = var51?class16.field181:class32.field727;
                     var66 = class108.method1988(var33.id);
                     var66.children[var33.index] = null;
                     class204.method3671(var66);
                     continue;
                  }

                  if(var44 == 102) {
                     --var5;
                     var33 = class108.method1988(class32.field728[var5]);
                     var33.children = null;
                     class204.method3671(var33);
                     continue;
                  }

                  if(var44 == 200) {
                     var5 -= 2;
                     var15 = class32.field728[var5];
                     var38 = class32.field728[var5 + 1];
                     var77 = method2038(var15, var38);
                     if(null != var77 && var38 != -1) {
                        class32.field728[var5++] = 1;
                        if(var51) {
                           class16.field181 = var77;
                        } else {
                           class32.field727 = var77;
                        }
                        continue;
                     }

                     class32.field728[var5++] = 0;
                     continue;
                  }

                  if(var44 == 201) {
                     --var5;
                     var33 = class108.method1988(class32.field728[var5]);
                     if(null != var33) {
                        class32.field728[var5++] = 1;
                        if(var51) {
                           class16.field181 = var33;
                        } else {
                           class32.field727 = var33;
                        }
                     } else {
                        class32.field728[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var48;
                  if(var44 >= 1000 && var44 < 1100 || var44 >= 2000 && var44 < 2100) {
                     var15 = -1;
                     if(var44 >= 2000) {
                        var44 -= 1000;
                        --var5;
                        var15 = class32.field728[var5];
                        var66 = class108.method1988(var15);
                     } else {
                        var66 = var51?class16.field181:class32.field727;
                     }

                     if(var44 == 1000) {
                        var5 -= 4;
                        var66.originalX = class32.field728[var5];
                        var66.originalY = class32.field728[1 + var5];
                        var66.field2214 = class32.field728[var5 + 2];
                        var66.field2215 = class32.field728[3 + var5];
                        class204.method3671(var66);
                        class101.method1903(var66);
                        if(var15 != -1 && var66.type == 0) {
                           class1.method14(Widget.widgets[var15 >> 16], var66, false);
                        }
                        continue;
                     }

                     if(var44 == 1001) {
                        var5 -= 4;
                        var66.originalWidth = class32.field728[var5];
                        var66.field2221 = class32.field728[var5 + 1];
                        var66.field2216 = class32.field728[var5 + 2];
                        var66.field2326 = class32.field728[var5 + 3];
                        class204.method3671(var66);
                        class101.method1903(var66);
                        if(var15 != -1 && var66.type == 0) {
                           class1.method14(Widget.widgets[var15 >> 16], var66, false);
                        }
                        continue;
                     }

                     if(var44 == 1003) {
                        --var5;
                        var48 = class32.field728[var5] == 1;
                        if(var48 != var66.isHidden) {
                           var66.isHidden = var48;
                           class204.method3671(var66);
                        }
                        continue;
                     }

                     if(var44 == 1005) {
                        --var5;
                        var66.field2342 = class32.field728[var5] == 1;
                        continue;
                     }

                     if(var44 == 1006) {
                        --var5;
                        var66.field2220 = class32.field728[var5] == 1;
                        continue;
                     }
                  } else if(var44 >= 1100 && var44 < 1200 || var44 >= 2100 && var44 < 2200) {
                     var38 = -1;
                     if(var44 >= 2000) {
                        var44 -= 1000;
                        --var5;
                        var38 = class32.field728[var5];
                        var33 = class108.method1988(var38);
                     } else {
                        var33 = var51?class16.field181:class32.field727;
                     }

                     if(var44 == 1100) {
                        var5 -= 2;
                        var33.scrollX = class32.field728[var5];
                        if(var33.scrollX > var33.scrollWidth - var33.width) {
                           var33.scrollX = var33.scrollWidth - var33.width;
                        }

                        if(var33.scrollX < 0) {
                           var33.scrollX = 0;
                        }

                        var33.scrollY = class32.field728[var5 + 1];
                        if(var33.scrollY > var33.scrollHeight - var33.height) {
                           var33.scrollY = var33.scrollHeight - var33.height;
                        }

                        if(var33.scrollY < 0) {
                           var33.scrollY = 0;
                        }

                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1101) {
                        --var5;
                        var33.textColor = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1102) {
                        --var5;
                        var33.field2238 = class32.field728[var5] == 1;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1103) {
                        --var5;
                        var33.opacity = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1104) {
                        --var5;
                        var33.field2298 = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1105) {
                        --var5;
                        var33.textureId = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1106) {
                        --var5;
                        var33.field2246 = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1107) {
                        --var5;
                        var33.field2247 = class32.field728[var5] == 1;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1108) {
                        var33.modelType = 1;
                        --var5;
                        var33.modelId = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1109) {
                        var5 -= 6;
                        var33.field2297 = class32.field728[var5];
                        var33.field2259 = class32.field728[1 + var5];
                        var33.rotationX = class32.field728[2 + var5];
                        var33.rotationZ = class32.field728[3 + var5];
                        var33.rotationY = class32.field728[var5 + 4];
                        var33.field2263 = class32.field728[5 + var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1110) {
                        --var5;
                        var17 = class32.field728[var5];
                        if(var33.field2256 != var17) {
                           var33.field2256 = var17;
                           var33.field2331 = 0;
                           var33.field2332 = 0;
                           class204.method3671(var33);
                        }
                        continue;
                     }

                     if(var44 == 1111) {
                        --var5;
                        var33.field2268 = class32.field728[var5] == 1;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1112) {
                        --var6;
                        var34 = class32.chatboxSegments[var6];
                        if(!var34.equals(var33.text)) {
                           var33.text = var34;
                           class204.method3671(var33);
                        }
                        continue;
                     }

                     if(var44 == 1113) {
                        --var5;
                        var33.fontId = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1114) {
                        var5 -= 3;
                        var33.field2272 = class32.field728[var5];
                        var33.field2273 = class32.field728[1 + var5];
                        var33.field2234 = class32.field728[2 + var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1115) {
                        --var5;
                        var33.field2274 = class32.field728[var5] == 1;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1116) {
                        --var5;
                        var33.borderThickness = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1117) {
                        --var5;
                        var33.sprite2 = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1118) {
                        --var5;
                        var33.flippedVertically = class32.field728[var5] == 1;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1119) {
                        --var5;
                        var33.flippedHorizontally = class32.field728[var5] == 1;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1120) {
                        var5 -= 2;
                        var33.scrollWidth = class32.field728[var5];
                        var33.scrollHeight = class32.field728[var5 + 1];
                        class204.method3671(var33);
                        if(var38 != -1 && var33.type == 0) {
                           class1.method14(Widget.widgets[var38 >> 16], var33, false);
                        }
                        continue;
                     }

                     if(var44 == 1121) {
                        var17 = var33.id;
                        var18 = var33.index;
                        Client.field336.method2963(115);
                        Client.field336.method2764(var17);
                        Client.field336.method2709(var18);
                        Client.field455 = var33;
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1122) {
                        --var5;
                        var33.field2245 = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1123) {
                        --var5;
                        var33.field2235 = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1124) {
                        --var5;
                        var33.field2241 = class32.field728[var5];
                        class204.method3671(var33);
                        continue;
                     }

                     if(var44 == 1125) {
                        --var5;
                        var17 = class32.field728[var5];
                        class221[] var106 = new class221[]{class221.field3189, class221.field3188, class221.field3194, class221.field3187, class221.field3190};
                        class221 var98 = (class221)class72.method1368(var106, var17);
                        if(var98 != null) {
                           var33.field2288 = var98;
                           class204.method3671(var33);
                        }
                        continue;
                     }
                  } else if((var44 < 1200 || var44 >= 1300) && (var44 < 2200 || var44 >= 2300)) {
                     if((var44 < 1300 || var44 >= 1400) && (var44 < 2300 || var44 >= 2400)) {
                        String var46;
                        int[] var78;
                        if(var44 >= 1400 && var44 < 1500 || var44 >= 2400 && var44 < 2500) {
                           if(var44 >= 2000) {
                              var44 -= 1000;
                              --var5;
                              var33 = class108.method1988(class32.field728[var5]);
                           } else {
                              var33 = var51?class16.field181:class32.field727;
                           }

                           --var6;
                           var46 = class32.chatboxSegments[var6];
                           var78 = null;
                           if(var46.length() > 0 && var46.charAt(var46.length() - 1) == 89) {
                              --var5;
                              var18 = class32.field728[var5];
                              if(var18 > 0) {
                                 for(var78 = new int[var18]; var18-- > 0; var78[var18] = class32.field728[var5]) {
                                    --var5;
                                 }
                              }

                              var46 = var46.substring(0, var46.length() - 1);
                           }

                           Object[] var102 = new Object[var46.length() + 1];

                           for(var19 = var102.length - 1; var19 >= 1; --var19) {
                              if(var46.charAt(var19 - 1) == 115) {
                                 --var6;
                                 var102[var19] = class32.chatboxSegments[var6];
                              } else {
                                 --var5;
                                 var102[var19] = new Integer(class32.field728[var5]);
                              }
                           }

                           --var5;
                           var19 = class32.field728[var5];
                           if(var19 != -1) {
                              var102[0] = new Integer(var19);
                           } else {
                              var102 = null;
                           }

                           if(var44 == 1400) {
                              var33.field2258 = var102;
                           }

                           if(var44 == 1401) {
                              var33.field2294 = var102;
                           }

                           if(var44 == 1402) {
                              var33.field2252 = var102;
                           }

                           if(var44 == 1403) {
                              var33.field2295 = var102;
                           }

                           if(var44 == 1404) {
                              var33.field2328 = var102;
                           }

                           if(var44 == 1405) {
                              var33.field2233 = var102;
                           }

                           if(var44 == 1406) {
                              var33.field2301 = var102;
                           }

                           if(var44 == 1407) {
                              var33.field2302 = var102;
                              var33.field2293 = var78;
                           }

                           if(var44 == 1408) {
                              var33.field2308 = var102;
                           }

                           if(var44 == 1409) {
                              var33.field2309 = var102;
                           }

                           if(var44 == 1410) {
                              var33.field2254 = var102;
                           }

                           if(var44 == 1411) {
                              var33.field2292 = var102;
                           }

                           if(var44 == 1412) {
                              var33.field2296 = var102;
                           }

                           if(var44 == 1414) {
                              var33.field2248 = var102;
                              var33.field2305 = var78;
                           }

                           if(var44 == 1415) {
                              var33.field2306 = var102;
                              var33.field2307 = var78;
                           }

                           if(var44 == 1416) {
                              var33.field2300 = var102;
                           }

                           if(var44 == 1417) {
                              var33.field2343 = var102;
                           }

                           if(var44 == 1418) {
                              var33.field2311 = var102;
                           }

                           if(var44 == 1419) {
                              var33.field2201 = var102;
                           }

                           if(var44 == 1420) {
                              var33.field2337 = var102;
                           }

                           if(var44 == 1421) {
                              var33.field2314 = var102;
                           }

                           if(var44 == 1422) {
                              var33.field2315 = var102;
                           }

                           if(var44 == 1423) {
                              var33.field2316 = var102;
                           }

                           if(var44 == 1424) {
                              var33.field2317 = var102;
                           }

                           if(var44 == 1425) {
                              var33.field2319 = var102;
                           }

                           if(var44 == 1426) {
                              var33.field2320 = var102;
                           }

                           if(var44 == 1427) {
                              var33.field2318 = var102;
                           }

                           var33.field2289 = true;
                           continue;
                        }

                        if(var44 < 1600) {
                           var33 = var51?class16.field181:class32.field727;
                           if(var44 == 1500) {
                              class32.field728[var5++] = var33.relativeX;
                              continue;
                           }

                           if(var44 == 1501) {
                              class32.field728[var5++] = var33.relativeY;
                              continue;
                           }

                           if(var44 == 1502) {
                              class32.field728[var5++] = var33.width;
                              continue;
                           }

                           if(var44 == 1503) {
                              class32.field728[var5++] = var33.height;
                              continue;
                           }

                           if(var44 == 1504) {
                              class32.field728[var5++] = var33.isHidden?1:0;
                              continue;
                           }

                           if(var44 == 1505) {
                              class32.field728[var5++] = var33.parentId;
                              continue;
                           }
                        } else if(var44 < 1700) {
                           var33 = var51?class16.field181:class32.field727;
                           if(var44 == 1600) {
                              class32.field728[var5++] = var33.scrollX;
                              continue;
                           }

                           if(var44 == 1601) {
                              class32.field728[var5++] = var33.scrollY;
                              continue;
                           }

                           if(var44 == 1602) {
                              class32.chatboxSegments[var6++] = var33.text;
                              continue;
                           }

                           if(var44 == 1603) {
                              class32.field728[var5++] = var33.scrollWidth;
                              continue;
                           }

                           if(var44 == 1604) {
                              class32.field728[var5++] = var33.scrollHeight;
                              continue;
                           }

                           if(var44 == 1605) {
                              class32.field728[var5++] = var33.field2263;
                              continue;
                           }

                           if(var44 == 1606) {
                              class32.field728[var5++] = var33.rotationX;
                              continue;
                           }

                           if(var44 == 1607) {
                              class32.field728[var5++] = var33.rotationY;
                              continue;
                           }

                           if(var44 == 1608) {
                              class32.field728[var5++] = var33.rotationZ;
                              continue;
                           }

                           if(var44 == 1609) {
                              class32.field728[var5++] = var33.opacity;
                              continue;
                           }

                           if(var44 == 1610) {
                              class32.field728[var5++] = var33.field2241;
                              continue;
                           }

                           if(var44 == 1611) {
                              class32.field728[var5++] = var33.textColor;
                              continue;
                           }

                           if(var44 == 1612) {
                              class32.field728[var5++] = var33.field2235;
                              continue;
                           }

                           if(var44 == 1613) {
                              class32.field728[var5++] = var33.field2288.vmethod3916();
                              continue;
                           }
                        } else if(var44 < 1800) {
                           var33 = var51?class16.field181:class32.field727;
                           if(var44 == 1700) {
                              class32.field728[var5++] = var33.item;
                              continue;
                           }

                           if(var44 == 1701) {
                              if(var33.item != -1) {
                                 class32.field728[var5++] = var33.stackSize;
                              } else {
                                 class32.field728[var5++] = 0;
                              }
                              continue;
                           }

                           if(var44 == 1702) {
                              class32.field728[var5++] = var33.index;
                              continue;
                           }
                        } else if(var44 < 1900) {
                           var33 = var51?class16.field181:class32.field727;
                           if(var44 == 1800) {
                              class32.field728[var5++] = class94.method1857(class170.method3147(var33));
                              continue;
                           }

                           if(var44 == 1801) {
                              --var5;
                              var38 = class32.field728[var5];
                              --var38;
                              if(null != var33.actions && var38 < var33.actions.length && null != var33.actions[var38]) {
                                 class32.chatboxSegments[var6++] = var33.actions[var38];
                                 continue;
                              }

                              class32.chatboxSegments[var6++] = "";
                              continue;
                           }

                           if(var44 == 1802) {
                              if(null == var33.name) {
                                 class32.chatboxSegments[var6++] = "";
                              } else {
                                 class32.chatboxSegments[var6++] = var33.name;
                              }
                              continue;
                           }
                        } else if((var44 < 1900 || var44 >= 2000) && (var44 < 2900 || var44 >= 3000)) {
                           if(var44 < 2600) {
                              --var5;
                              var33 = class108.method1988(class32.field728[var5]);
                              if(var44 == 2500) {
                                 class32.field728[var5++] = var33.relativeX;
                                 continue;
                              }

                              if(var44 == 2501) {
                                 class32.field728[var5++] = var33.relativeY;
                                 continue;
                              }

                              if(var44 == 2502) {
                                 class32.field728[var5++] = var33.width;
                                 continue;
                              }

                              if(var44 == 2503) {
                                 class32.field728[var5++] = var33.height;
                                 continue;
                              }

                              if(var44 == 2504) {
                                 class32.field728[var5++] = var33.isHidden?1:0;
                                 continue;
                              }

                              if(var44 == 2505) {
                                 class32.field728[var5++] = var33.parentId;
                                 continue;
                              }
                           } else if(var44 < 2700) {
                              --var5;
                              var33 = class108.method1988(class32.field728[var5]);
                              if(var44 == 2600) {
                                 class32.field728[var5++] = var33.scrollX;
                                 continue;
                              }

                              if(var44 == 2601) {
                                 class32.field728[var5++] = var33.scrollY;
                                 continue;
                              }

                              if(var44 == 2602) {
                                 class32.chatboxSegments[var6++] = var33.text;
                                 continue;
                              }

                              if(var44 == 2603) {
                                 class32.field728[var5++] = var33.scrollWidth;
                                 continue;
                              }

                              if(var44 == 2604) {
                                 class32.field728[var5++] = var33.scrollHeight;
                                 continue;
                              }

                              if(var44 == 2605) {
                                 class32.field728[var5++] = var33.field2263;
                                 continue;
                              }

                              if(var44 == 2606) {
                                 class32.field728[var5++] = var33.rotationX;
                                 continue;
                              }

                              if(var44 == 2607) {
                                 class32.field728[var5++] = var33.rotationY;
                                 continue;
                              }

                              if(var44 == 2608) {
                                 class32.field728[var5++] = var33.rotationZ;
                                 continue;
                              }

                              if(var44 == 2609) {
                                 class32.field728[var5++] = var33.opacity;
                                 continue;
                              }

                              if(var44 == 2610) {
                                 class32.field728[var5++] = var33.field2241;
                                 continue;
                              }

                              if(var44 == 2611) {
                                 class32.field728[var5++] = var33.textColor;
                                 continue;
                              }

                              if(var44 == 2612) {
                                 class32.field728[var5++] = var33.field2235;
                                 continue;
                              }

                              if(var44 == 2613) {
                                 class32.field728[var5++] = var33.field2288.vmethod3916();
                                 continue;
                              }
                           } else if(var44 < 2800) {
                              if(var44 == 2700) {
                                 --var5;
                                 var33 = class108.method1988(class32.field728[var5]);
                                 class32.field728[var5++] = var33.item;
                                 continue;
                              }

                              if(var44 == 2701) {
                                 --var5;
                                 var33 = class108.method1988(class32.field728[var5]);
                                 if(var33.item != -1) {
                                    class32.field728[var5++] = var33.stackSize;
                                 } else {
                                    class32.field728[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var44 == 2702) {
                                 --var5;
                                 var15 = class32.field728[var5];
                                 WidgetNode var45 = (WidgetNode)Client.componentTable.method2274((long)var15);
                                 if(var45 != null) {
                                    class32.field728[var5++] = 1;
                                 } else {
                                    class32.field728[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var44 == 2706) {
                                 class32.field728[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var44 < 2900) {
                              --var5;
                              var33 = class108.method1988(class32.field728[var5]);
                              if(var44 == 2800) {
                                 class32.field728[var5++] = class94.method1857(class170.method3147(var33));
                                 continue;
                              }

                              if(var44 == 2801) {
                                 --var5;
                                 var38 = class32.field728[var5];
                                 --var38;
                                 if(null != var33.actions && var38 < var33.actions.length && null != var33.actions[var38]) {
                                    class32.chatboxSegments[var6++] = var33.actions[var38];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var44 == 2802) {
                                 if(var33.name == null) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var33.name;
                                 }
                                 continue;
                              }
                           } else {
                              int var39;
                              class159 var85;
                              if(var44 < 3200) {
                                 if(var44 == 3100) {
                                    --var6;
                                    var103 = class32.chatboxSegments[var6];
                                    Player.method220(0, "", var103);
                                    continue;
                                 }

                                 if(var44 == 3101) {
                                    var5 -= 2;
                                    class20.method172(XItemContainer.localPlayer, class32.field728[var5], class32.field728[var5 + 1]);
                                    continue;
                                 }

                                 if(var44 == 3103) {
                                    class88.method1820();
                                    continue;
                                 }

                                 if(var44 == 3104) {
                                    --var6;
                                    var103 = class32.chatboxSegments[var6];
                                    var38 = 0;
                                    var48 = class174.method3153(var103, 10, true);
                                    if(var48) {
                                       var18 = ChatMessages.method831(var103, 10, true);
                                       var38 = var18;
                                    }

                                    Client.field336.method2963(40);
                                    Client.field336.method2711(var38);
                                    continue;
                                 }

                                 if(var44 == 3105) {
                                    --var6;
                                    var103 = class32.chatboxSegments[var6];
                                    Client.field336.method2963(210);
                                    Client.field336.method2708(var103.length() + 1);
                                    Client.field336.method2714(var103);
                                    continue;
                                 }

                                 if(var44 == 3106) {
                                    --var6;
                                    var103 = class32.chatboxSegments[var6];
                                    Client.field336.method2963(57);
                                    Client.field336.method2708(var103.length() + 1);
                                    Client.field336.method2714(var103);
                                    continue;
                                 }

                                 if(var44 == 3107) {
                                    --var5;
                                    var15 = class32.field728[var5];
                                    --var6;
                                    var46 = class32.chatboxSegments[var6];
                                    var17 = class45.field894;
                                    int[] var87 = class45.field896;
                                    boolean var50 = false;

                                    for(var20 = 0; var20 < var17; ++var20) {
                                       Player var21 = Client.cachedPlayers[var87[var20]];
                                       if(var21 != null && var21 != XItemContainer.localPlayer && var21.name != null && var21.name.equalsIgnoreCase(var46)) {
                                          if(var15 == 1) {
                                             Client.field336.method2963(252);
                                             Client.field336.method2844(0);
                                             Client.field336.method2755(var87[var20]);
                                          } else if(var15 == 4) {
                                             Client.field336.method2963(190);
                                             Client.field336.method2754(var87[var20]);
                                             Client.field336.method2833(0);
                                          } else if(var15 == 6) {
                                             Client.field336.method2963(219);
                                             Client.field336.method2708(0);
                                             Client.field336.method2754(var87[var20]);
                                          } else if(var15 == 7) {
                                             Client.field336.method2963(25);
                                             Client.field336.method2733(0);
                                             Client.field336.method2756(var87[var20]);
                                          }

                                          var50 = true;
                                          break;
                                       }
                                    }

                                    if(!var50) {
                                       Player.method220(4, "", "Unable to find " + var46);
                                    }
                                    continue;
                                 }

                                 if(var44 == 3108) {
                                    var5 -= 3;
                                    var15 = class32.field728[var5];
                                    var38 = class32.field728[var5 + 1];
                                    var17 = class32.field728[2 + var5];
                                    var86 = class108.method1988(var17);
                                    class184.method3297(var86, var15, var38);
                                    continue;
                                 }

                                 if(var44 == 3109) {
                                    var5 -= 2;
                                    var15 = class32.field728[var5];
                                    var38 = class32.field728[1 + var5];
                                    var77 = var51?class16.field181:class32.field727;
                                    class184.method3297(var77, var15, var38);
                                    continue;
                                 }

                                 if(var44 == 3110) {
                                    --var5;
                                    class10.field110 = class32.field728[var5] == 1;
                                    continue;
                                 }

                                 if(var44 == 3111) {
                                    class32.field728[var5++] = class38.field794.field699?1:0;
                                    continue;
                                 }

                                 if(var44 == 3112) {
                                    --var5;
                                    class38.field794.field699 = class32.field728[var5] == 1;
                                    PlayerComposition.method3057();
                                    continue;
                                 }

                                 if(var44 == 3113) {
                                    --var6;
                                    var103 = class32.chatboxSegments[var6];
                                    --var5;
                                    var97 = class32.field728[var5] == 1;
                                    class48.method850(var103, var97, false);
                                    continue;
                                 }

                                 if(var44 == 3115) {
                                    --var5;
                                    var15 = class32.field728[var5];
                                    Client.field336.method2963(63);
                                    Client.field336.method2709(var15);
                                    continue;
                                 }

                                 if(var44 == 3116) {
                                    --var5;
                                    var15 = class32.field728[var5];
                                    var6 -= 2;
                                    var46 = class32.chatboxSegments[var6];
                                    var34 = class32.chatboxSegments[var6 + 1];
                                    if(var46.length() <= 500 && var34.length() <= 500) {
                                       Client.field336.method2963(113);
                                       var85 = Client.field336;
                                       var19 = var46.length() + 1;
                                       var20 = var19 + 1;
                                       var39 = var34.length() + 1;
                                       var85.method2709(var20 + var39);
                                       Client.field336.method2714(var46);
                                       Client.field336.method2714(var34);
                                       Client.field336.method2844(var15);
                                    }
                                    continue;
                                 }
                              } else if(var44 < 3300) {
                                 if(var44 == 3200) {
                                    var5 -= 3;
                                    class3.method37(class32.field728[var5], class32.field728[var5 + 1], class32.field728[2 + var5]);
                                    continue;
                                 }

                                 if(var44 == 3201) {
                                    --var5;
                                    class16.method156(class32.field728[var5]);
                                    continue;
                                 }

                                 if(var44 == 3202) {
                                    var5 -= 2;
                                    var15 = class32.field728[var5];
                                    int var10000 = class32.field728[var5 + 1];
                                    if(Client.field529 != 0 && var15 != -1) {
                                       WallObject.method1833(Client.field325, var15, 0, Client.field529, false);
                                       Client.field531 = true;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var22;
                                 if(var44 < 3400) {
                                    if(var44 == 3300) {
                                       class32.field728[var5++] = Client.gameCycle;
                                       continue;
                                    }

                                    if(var44 == 3301) {
                                       var5 -= 2;
                                       var15 = class32.field728[var5];
                                       var38 = class32.field728[1 + var5];
                                       class32.field728[var5++] = class162.method2999(var15, var38);
                                       continue;
                                    }

                                    if(var44 == 3302) {
                                       var5 -= 2;
                                       var15 = class32.field728[var5];
                                       var38 = class32.field728[1 + var5];
                                       class32.field728[var5++] = class174.method3151(var15, var38);
                                       continue;
                                    }

                                    XItemContainer var35;
                                    if(var44 == 3303) {
                                       var5 -= 2;
                                       var15 = class32.field728[var5];
                                       var38 = class32.field728[var5 + 1];
                                       var78 = class32.field728;
                                       var18 = var5++;
                                       var35 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var15);
                                       if(null == var35) {
                                          var19 = 0;
                                       } else if(var38 == -1) {
                                          var19 = 0;
                                       } else {
                                          var39 = 0;

                                          for(var22 = 0; var22 < var35.stackSizes.length; ++var22) {
                                             if(var35.itemIds[var22] == var38) {
                                                var39 += var35.stackSizes[var22];
                                             }
                                          }

                                          var19 = var39;
                                       }

                                       var78[var18] = var19;
                                       continue;
                                    }

                                    if(var44 == 3304) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = FaceNormal.method1836(var15).field2770;
                                       continue;
                                    }

                                    if(var44 == 3305) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = Client.boostedSkillLevels[var15];
                                       continue;
                                    }

                                    if(var44 == 3306) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = Client.realSkillLevels[var15];
                                       continue;
                                    }

                                    if(var44 == 3307) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = Client.skillExperiences[var15];
                                       continue;
                                    }

                                    if(var44 == 3308) {
                                       var15 = class118.plane;
                                       var38 = (XItemContainer.localPlayer.x >> 7) + class22.baseX;
                                       var17 = (XItemContainer.localPlayer.y >> 7) + class103.baseY;
                                       class32.field728[var5++] = var17 + (var15 << 28) + (var38 << 14);
                                       continue;
                                    }

                                    if(var44 == 3309) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = var15 >> 14 & 16383;
                                       continue;
                                    }

                                    if(var44 == 3310) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = var15 >> 28;
                                       continue;
                                    }

                                    if(var44 == 3311) {
                                       --var5;
                                       var15 = class32.field728[var5];
                                       class32.field728[var5++] = var15 & 16383;
                                       continue;
                                    }

                                    if(var44 == 3312) {
                                       class32.field728[var5++] = Client.isMembers?1:0;
                                       continue;
                                    }

                                    if(var44 == 3313) {
                                       var5 -= 2;
                                       var15 = class32.field728[var5] + '耀';
                                       var38 = class32.field728[1 + var5];
                                       class32.field728[var5++] = class162.method2999(var15, var38);
                                       continue;
                                    }

                                    if(var44 == 3314) {
                                       var5 -= 2;
                                       var15 = class32.field728[var5] + '耀';
                                       var38 = class32.field728[var5 + 1];
                                       class32.field728[var5++] = class174.method3151(var15, var38);
                                       continue;
                                    }

                                    if(var44 == 3315) {
                                       var5 -= 2;
                                       var15 = '耀' + class32.field728[var5];
                                       var38 = class32.field728[1 + var5];
                                       var78 = class32.field728;
                                       var18 = var5++;
                                       var35 = (XItemContainer)XItemContainer.itemContainers.method2274((long)var15);
                                       if(var35 == null) {
                                          var19 = 0;
                                       } else if(var38 == -1) {
                                          var19 = 0;
                                       } else {
                                          var39 = 0;

                                          for(var22 = 0; var22 < var35.stackSizes.length; ++var22) {
                                             if(var35.itemIds[var22] == var38) {
                                                var39 += var35.stackSizes[var22];
                                             }
                                          }

                                          var19 = var39;
                                       }

                                       var78[var18] = var19;
                                       continue;
                                    }

                                    if(var44 == 3316) {
                                       if(Client.field458 >= 2) {
                                          class32.field728[var5++] = Client.field458;
                                       } else {
                                          class32.field728[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var44 == 3317) {
                                       class32.field728[var5++] = Client.field534;
                                       continue;
                                    }

                                    if(var44 == 3318) {
                                       class32.field728[var5++] = Client.world;
                                       continue;
                                    }

                                    if(var44 == 3321) {
                                       class32.field728[var5++] = Client.energy;
                                       continue;
                                    }

                                    if(var44 == 3322) {
                                       class32.field728[var5++] = Client.weight;
                                       continue;
                                    }

                                    if(var44 == 3323) {
                                       if(Client.field460) {
                                          class32.field728[var5++] = 1;
                                       } else {
                                          class32.field728[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var44 == 3324) {
                                       class32.field728[var5++] = Client.flags;
                                       continue;
                                    }
                                 } else if(var44 < 3500) {
                                    if(var44 == 3400) {
                                       var5 -= 2;
                                       var15 = class32.field728[var5];
                                       var38 = class32.field728[1 + var5];
                                       class195 var79 = Varbit.method3427(var15);
                                       if(var79.field2861 != 115) {
                                          ;
                                       }

                                       for(var18 = 0; var18 < var79.field2868; ++var18) {
                                          if(var38 == var79.field2865[var18]) {
                                             class32.chatboxSegments[var6++] = var79.field2867[var18];
                                             var79 = null;
                                             break;
                                          }
                                       }

                                       if(null != var79) {
                                          class32.chatboxSegments[var6++] = var79.field2862;
                                       }
                                       continue;
                                    }

                                    if(var44 == 3408) {
                                       var5 -= 4;
                                       var15 = class32.field728[var5];
                                       var38 = class32.field728[var5 + 1];
                                       var17 = class32.field728[2 + var5];
                                       var18 = class32.field728[var5 + 3];
                                       class195 var36 = Varbit.method3427(var17);
                                       if(var36.field2860 == var15 && var38 == var36.field2861) {
                                          for(var20 = 0; var20 < var36.field2868; ++var20) {
                                             if(var18 == var36.field2865[var20]) {
                                                if(var38 == 115) {
                                                   class32.chatboxSegments[var6++] = var36.field2867[var20];
                                                } else {
                                                   class32.field728[var5++] = var36.field2866[var20];
                                                }

                                                var36 = null;
                                                break;
                                             }
                                          }

                                          if(var36 != null) {
                                             if(var38 == 115) {
                                                class32.chatboxSegments[var6++] = var36.field2862;
                                             } else {
                                                class32.field728[var5++] = var36.field2864;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var38 == 115) {
                                          class32.chatboxSegments[var6++] = "null";
                                       } else {
                                          class32.field728[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    String var83;
                                    if(var44 < 3700) {
                                       if(var44 == 3600) {
                                          if(Client.field506 == 0) {
                                             class32.field728[var5++] = -2;
                                          } else if(Client.field506 == 1) {
                                             class32.field728[var5++] = -1;
                                          } else {
                                             class32.field728[var5++] = Client.friendCount;
                                          }
                                          continue;
                                       }

                                       if(var44 == 3601) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(Client.field506 == 2 && var15 < Client.friendCount) {
                                             class32.chatboxSegments[var6++] = Client.friends[var15].name;
                                             class32.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var44 == 3602) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(Client.field506 == 2 && var15 < Client.friendCount) {
                                             class32.field728[var5++] = Client.friends[var15].world;
                                             continue;
                                          }

                                          class32.field728[var5++] = 0;
                                          continue;
                                       }

                                       if(var44 == 3603) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(Client.field506 == 2 && var15 < Client.friendCount) {
                                             class32.field728[var5++] = Client.friends[var15].rank;
                                             continue;
                                          }

                                          class32.field728[var5++] = 0;
                                          continue;
                                       }

                                       if(var44 == 3604) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          --var5;
                                          var38 = class32.field728[var5];
                                          class85.method1652(var103, var38);
                                          continue;
                                       }

                                       if(var44 == 3605) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          class18.method162(var103);
                                          continue;
                                       }

                                       class159 var52;
                                       Friend var93;
                                       if(var44 == 3606) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          if(var103 == null) {
                                             continue;
                                          }

                                          var46 = class137.method2397(var103, class1.field15);
                                          if(var46 == null) {
                                             continue;
                                          }

                                          var17 = 0;

                                          while(true) {
                                             if(var17 >= Client.friendCount) {
                                                continue label3684;
                                             }

                                             var93 = Client.friends[var17];
                                             var83 = var93.name;
                                             var80 = class137.method2397(var83, class1.field15);
                                             if(Overlay.method3607(var103, var46, var83, var80)) {
                                                --Client.friendCount;

                                                for(var39 = var17; var39 < Client.friendCount; ++var39) {
                                                   Client.friends[var39] = Client.friends[var39 + 1];
                                                }

                                                Client.field484 = Client.field358;
                                                Client.field336.method2963(188);
                                                var52 = Client.field336;
                                                var22 = var103.length() + 1;
                                                var52.method2708(var22);
                                                Client.field336.method2714(var103);
                                                continue label3684;
                                             }

                                             ++var17;
                                          }
                                       }

                                       Ignore var90;
                                       if(var44 == 3607) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          if(null == var103) {
                                             continue;
                                          }

                                          if((Client.ignoreCount < 100 || Client.field415 == 1) && Client.ignoreCount < 400) {
                                             var46 = class137.method2397(var103, class1.field15);
                                             if(var46 == null) {
                                                continue;
                                             }

                                             for(var17 = 0; var17 < Client.ignoreCount; ++var17) {
                                                var90 = Client.ignores[var17];
                                                var83 = class137.method2397(var90.name, class1.field15);
                                                if(var83 != null && var83.equals(var46)) {
                                                   Player.method220(31, "", var103 + " is already on your ignore list");
                                                   continue label3684;
                                                }

                                                if(null != var90.previousName) {
                                                   var80 = class137.method2397(var90.previousName, class1.field15);
                                                   if(null != var80 && var80.equals(var46)) {
                                                      Player.method220(31, "", var103 + " is already on your ignore list");
                                                      continue label3684;
                                                   }
                                                }
                                             }

                                             for(var17 = 0; var17 < Client.friendCount; ++var17) {
                                                var93 = Client.friends[var17];
                                                var83 = class137.method2397(var93.name, class1.field15);
                                                if(null != var83 && var83.equals(var46)) {
                                                   Player.method220(31, "", "Please remove " + var103 + " from your friend list first");
                                                   continue label3684;
                                                }

                                                if(var93.previousName != null) {
                                                   var80 = class137.method2397(var93.previousName, class1.field15);
                                                   if(var80 != null && var80.equals(var46)) {
                                                      Player.method220(31, "", "Please remove " + var103 + " from your friend list first");
                                                      continue label3684;
                                                   }
                                                }
                                             }

                                             if(class137.method2397(XItemContainer.localPlayer.name, class1.field15).equals(var46)) {
                                                Player.method220(31, "", "You can\'t add yourself to your own ignore list");
                                             } else {
                                                Client.field336.method2963(189);
                                                class159 var81 = Client.field336;
                                                var18 = var103.length() + 1;
                                                var81.method2708(var18);
                                                Client.field336.method2714(var103);
                                             }
                                             continue;
                                          }

                                          Player.method220(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                          continue;
                                       }

                                       if(var44 == 3608) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          if(null == var103) {
                                             continue;
                                          }

                                          var46 = class137.method2397(var103, class1.field15);
                                          if(var46 == null) {
                                             continue;
                                          }

                                          var17 = 0;

                                          while(true) {
                                             if(var17 >= Client.ignoreCount) {
                                                continue label3684;
                                             }

                                             var90 = Client.ignores[var17];
                                             var83 = var90.name;
                                             var80 = class137.method2397(var83, class1.field15);
                                             if(Overlay.method3607(var103, var46, var83, var80)) {
                                                --Client.ignoreCount;

                                                for(var39 = var17; var39 < Client.ignoreCount; ++var39) {
                                                   Client.ignores[var39] = Client.ignores[var39 + 1];
                                                }

                                                Client.field484 = Client.field358;
                                                Client.field336.method2963(10);
                                                var52 = Client.field336;
                                                var22 = var103.length() + 1;
                                                var52.method2708(var22);
                                                Client.field336.method2714(var103);
                                                continue label3684;
                                             }

                                             ++var17;
                                          }
                                       }

                                       if(var44 == 3609) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          class177[] var47 = class7.method91();

                                          for(var17 = 0; var17 < var47.length; ++var17) {
                                             class177 var88 = var47[var17];
                                             if(var88.field2675 != -1) {
                                                var39 = var88.field2675;
                                                var80 = "<img=" + var39 + ">";
                                                if(var103.startsWith(var80)) {
                                                   var103 = var103.substring(6 + Integer.toString(var88.field2675).length());
                                                   break;
                                                }
                                             }
                                          }

                                          class32.field728[var5++] = class49.method854(var103, false)?1:0;
                                          continue;
                                       }

                                       if(var44 == 3611) {
                                          if(Client.field519 != null) {
                                             class32.chatboxSegments[var6++] = class72.method1375(Client.field519);
                                          } else {
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var44 == 3612) {
                                          if(Client.field519 != null) {
                                             class32.field728[var5++] = class162.clanChatCount;
                                          } else {
                                             class32.field728[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var44 == 3613) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(Client.field519 != null && var15 < class162.clanChatCount) {
                                             class32.chatboxSegments[var6++] = class57.clanMembers[var15].username;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var44 == 3614) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(null != Client.field519 && var15 < class162.clanChatCount) {
                                             class32.field728[var5++] = class57.clanMembers[var15].world;
                                             continue;
                                          }

                                          class32.field728[var5++] = 0;
                                          continue;
                                       }

                                       if(var44 == 3615) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(null != Client.field519 && var15 < class162.clanChatCount) {
                                             class32.field728[var5++] = class57.clanMembers[var15].rank;
                                             continue;
                                          }

                                          class32.field728[var5++] = 0;
                                          continue;
                                       }

                                       if(var44 == 3616) {
                                          class32.field728[var5++] = class149.field2046;
                                          continue;
                                       }

                                       if(var44 == 3617) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          class94.method1856(var103);
                                          continue;
                                       }

                                       if(var44 == 3618) {
                                          class32.field728[var5++] = class10.field109;
                                          continue;
                                       }

                                       if(var44 == 3619) {
                                          --var6;
                                          var103 = class32.chatboxSegments[var6];
                                          class6.method79(var103);
                                          continue;
                                       }

                                       if(var44 == 3620) {
                                          class10.method102();
                                          continue;
                                       }

                                       if(var44 == 3621) {
                                          if(Client.field506 == 0) {
                                             class32.field728[var5++] = -1;
                                          } else {
                                             class32.field728[var5++] = Client.ignoreCount;
                                          }
                                          continue;
                                       }

                                       if(var44 == 3622) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(Client.field506 != 0 && var15 < Client.ignoreCount) {
                                             class32.chatboxSegments[var6++] = Client.ignores[var15].name;
                                             class32.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var44 == 3623) {
                                          label3400: {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             var34 = "<img=0>";
                                             if(!var103.startsWith(var34)) {
                                                var83 = "<img=1>";
                                                if(!var103.startsWith(var83)) {
                                                   break label3400;
                                                }
                                             }

                                             var103 = var103.substring(7);
                                          }

                                          class32.field728[var5++] = class119.method2222(var103)?1:0;
                                          continue;
                                       }

                                       if(var44 == 3624) {
                                          --var5;
                                          var15 = class32.field728[var5];
                                          if(null != class57.clanMembers && var15 < class162.clanChatCount && class57.clanMembers[var15].username.equalsIgnoreCase(XItemContainer.localPlayer.name)) {
                                             class32.field728[var5++] = 1;
                                             continue;
                                          }

                                          class32.field728[var5++] = 0;
                                          continue;
                                       }

                                       if(var44 == 3625) {
                                          if(null != Client.clanChatOwner) {
                                             class32.chatboxSegments[var6++] = class72.method1375(Client.clanChatOwner);
                                          } else {
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }
                                    } else {
                                       long var57;
                                       if(var44 < 4000) {
                                          if(var44 == 3903) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = Client.grandExchangeOffers[var15].method43();
                                             continue;
                                          }

                                          if(var44 == 3904) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = Client.grandExchangeOffers[var15].itemId;
                                             continue;
                                          }

                                          if(var44 == 3905) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = Client.grandExchangeOffers[var15].price;
                                             continue;
                                          }

                                          if(var44 == 3906) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                             continue;
                                          }

                                          if(var44 == 3907) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                             continue;
                                          }

                                          if(var44 == 3908) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = Client.grandExchangeOffers[var15].spent;
                                             continue;
                                          }

                                          if(var44 == 3910) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var38 = Client.grandExchangeOffers[var15].method58();
                                             class32.field728[var5++] = var38 == 0?1:0;
                                             continue;
                                          }

                                          if(var44 == 3911) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var38 = Client.grandExchangeOffers[var15].method58();
                                             class32.field728[var5++] = var38 == 2?1:0;
                                             continue;
                                          }

                                          if(var44 == 3912) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var38 = Client.grandExchangeOffers[var15].method58();
                                             class32.field728[var5++] = var38 == 5?1:0;
                                             continue;
                                          }

                                          if(var44 == 3913) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var38 = Client.grandExchangeOffers[var15].method58();
                                             class32.field728[var5++] = var38 == 1?1:0;
                                             continue;
                                          }

                                          boolean var67;
                                          if(var44 == 3914) {
                                             --var5;
                                             var67 = class32.field728[var5] == 1;
                                             if(null != class15.field167) {
                                                class15.field167.method13(class1.field13, var67);
                                             }
                                             continue;
                                          }

                                          if(var44 == 3915) {
                                             --var5;
                                             var67 = class32.field728[var5] == 1;
                                             if(class15.field167 != null) {
                                                class15.field167.method13(class1.field17, var67);
                                             }
                                             continue;
                                          }

                                          if(var44 == 3916) {
                                             var5 -= 2;
                                             var67 = class32.field728[var5] == 1;
                                             var97 = class32.field728[var5 + 1] == 1;
                                             if(class15.field167 != null) {
                                                class15.field167.method13(new class44(var97), var67);
                                             }
                                             continue;
                                          }

                                          if(var44 == 3917) {
                                             --var5;
                                             var67 = class32.field728[var5] == 1;
                                             if(class15.field167 != null) {
                                                class15.field167.method13(class1.field12, var67);
                                             }
                                             continue;
                                          }

                                          if(var44 == 3918) {
                                             --var5;
                                             var67 = class32.field728[var5] == 1;
                                             if(null != class15.field167) {
                                                class15.field167.method13(class1.field14, var67);
                                             }
                                             continue;
                                          }

                                          if(var44 == 3919) {
                                             class32.field728[var5++] = class15.field167 == null?0:class15.field167.field10.size();
                                             continue;
                                          }

                                          class2 var49;
                                          if(var44 == 3920) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             class32.field728[var5++] = var49.field32;
                                             continue;
                                          }

                                          if(var44 == 3921) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             class32.chatboxSegments[var6++] = var49.method17();
                                             continue;
                                          }

                                          if(var44 == 3922) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             class32.chatboxSegments[var6++] = var49.method16();
                                             continue;
                                          }

                                          if(var44 == 3923) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             var57 = class2.method27() - XItemContainer.field133 - var49.field25;
                                             var19 = (int)(var57 / 3600000L);
                                             var20 = (int)((var57 - (long)(var19 * 3600000)) / 60000L);
                                             var39 = (int)((var57 - (long)(var19 * 3600000) - (long)('\uea60' * var20)) / 1000L);
                                             String var40 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var39 / 10 + var39 % 10;
                                             class32.chatboxSegments[var6++] = var40;
                                             continue;
                                          }

                                          if(var44 == 3924) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             class32.field728[var5++] = var49.field23.totalQuantity;
                                             continue;
                                          }

                                          if(var44 == 3925) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             class32.field728[var5++] = var49.field23.price;
                                             continue;
                                          }

                                          if(var44 == 3926) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var49 = (class2)class15.field167.field10.get(var15);
                                             class32.field728[var5++] = var49.field23.itemId;
                                             continue;
                                          }
                                       } else if(var44 < 4100) {
                                          if(var44 == 4000) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var38 + var15;
                                             continue;
                                          }

                                          if(var44 == 4001) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[1 + var5];
                                             class32.field728[var5++] = var15 - var38;
                                             continue;
                                          }

                                          if(var44 == 4002) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var38 * var15;
                                             continue;
                                          }

                                          if(var44 == 4003) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var15 / var38;
                                             continue;
                                          }

                                          if(var44 == 4004) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = (int)(Math.random() * (double)var15);
                                             continue;
                                          }

                                          if(var44 == 4005) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = (int)(Math.random() * (double)(1 + var15));
                                             continue;
                                          }

                                          if(var44 == 4006) {
                                             var5 -= 5;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             var17 = class32.field728[2 + var5];
                                             var18 = class32.field728[var5 + 3];
                                             var19 = class32.field728[4 + var5];
                                             class32.field728[var5++] = var15 + (var38 - var15) * (var19 - var17) / (var18 - var17);
                                             continue;
                                          }

                                          if(var44 == 4007) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[1 + var5];
                                             class32.field728[var5++] = var15 + var38 * var15 / 100;
                                             continue;
                                          }

                                          if(var44 == 4008) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var15 | 1 << var38;
                                             continue;
                                          }

                                          if(var44 == 4009) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[1 + var5];
                                             class32.field728[var5++] = var15 & -1 - (1 << var38);
                                             continue;
                                          }

                                          if(var44 == 4010) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = (var15 & 1 << var38) != 0?1:0;
                                             continue;
                                          }

                                          if(var44 == 4011) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var15 % var38;
                                             continue;
                                          }

                                          if(var44 == 4012) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[1 + var5];
                                             if(var15 == 0) {
                                                class32.field728[var5++] = 0;
                                             } else {
                                                class32.field728[var5++] = (int)Math.pow((double)var15, (double)var38);
                                             }
                                             continue;
                                          }

                                          if(var44 == 4013) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[1 + var5];
                                             if(var15 == 0) {
                                                class32.field728[var5++] = 0;
                                             } else if(var38 == 0) {
                                                class32.field728[var5++] = Integer.MAX_VALUE;
                                             } else {
                                                class32.field728[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var38);
                                             }
                                             continue;
                                          }

                                          if(var44 == 4014) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var15 & var38;
                                             continue;
                                          }

                                          if(var44 == 4015) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class32.field728[var5++] = var15 | var38;
                                             continue;
                                          }

                                          if(var44 == 4018) {
                                             var5 -= 3;
                                             long var73 = (long)class32.field728[var5];
                                             var57 = (long)class32.field728[1 + var5];
                                             long var58 = (long)class32.field728[2 + var5];
                                             class32.field728[var5++] = (int)(var58 * var73 / var57);
                                             continue;
                                          }
                                       } else if(var44 < 4200) {
                                          if(var44 == 4100) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             --var5;
                                             var38 = class32.field728[var5];
                                             class32.chatboxSegments[var6++] = var103 + var38;
                                             continue;
                                          }

                                          if(var44 == 4101) {
                                             var6 -= 2;
                                             var103 = class32.chatboxSegments[var6];
                                             var46 = class32.chatboxSegments[var6 + 1];
                                             class32.chatboxSegments[var6++] = var103 + var46;
                                             continue;
                                          }

                                          if(var44 == 4102) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             --var5;
                                             var38 = class32.field728[var5];
                                             var82 = class32.chatboxSegments;
                                             var18 = var6++;
                                             if(var38 < 0) {
                                                var80 = Integer.toString(var38);
                                             } else {
                                                var80 = ObjectComposition.method3523(var38, 10, true);
                                             }

                                             var82[var18] = var103 + var80;
                                             continue;
                                          }

                                          if(var44 == 4103) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = var103.toLowerCase();
                                             continue;
                                          }

                                          if(var44 == 4104) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             long var108 = ((long)var15 + 11745L) * 86400000L;
                                             class32.field723.setTime(new Date(var108));
                                             var18 = class32.field723.get(5);
                                             var19 = class32.field723.get(2);
                                             var20 = class32.field723.get(1);
                                             class32.chatboxSegments[var6++] = var18 + "-" + class32.field733[var19] + "-" + var20;
                                             continue;
                                          }

                                          if(var44 == 4105) {
                                             var6 -= 2;
                                             var103 = class32.chatboxSegments[var6];
                                             var46 = class32.chatboxSegments[1 + var6];
                                             if(null != XItemContainer.localPlayer.composition && XItemContainer.localPlayer.composition.isFemale) {
                                                class32.chatboxSegments[var6++] = var46;
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = var103;
                                             continue;
                                          }

                                          if(var44 == 4106) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.chatboxSegments[var6++] = Integer.toString(var15);
                                             continue;
                                          }

                                          if(var44 == 4107) {
                                             var6 -= 2;
                                             int[] var105 = class32.field728;
                                             var38 = var5++;
                                             String var99 = class32.chatboxSegments[var6];
                                             var83 = class32.chatboxSegments[1 + var6];
                                             var20 = Client.field300;
                                             var39 = var99.length();
                                             var22 = var83.length();
                                             int var23 = 0;
                                             int var24 = 0;
                                             char var25 = 0;
                                             char var26 = 0;

                                             label3463:
                                             while(true) {
                                                if(var23 - var25 >= var39 && var24 - var26 >= var22) {
                                                   int var68 = Math.min(var39, var22);

                                                   char var30;
                                                   int var70;
                                                   for(var70 = 0; var70 < var68; ++var70) {
                                                      char var29 = var99.charAt(var70);
                                                      var30 = var83.charAt(var70);
                                                      if(var30 != var29 && Character.toUpperCase(var29) != Character.toUpperCase(var30)) {
                                                         var29 = Character.toLowerCase(var29);
                                                         var30 = Character.toLowerCase(var30);
                                                         if(var30 != var29) {
                                                            var17 = class142.method2606(var29, var20) - class142.method2606(var30, var20);
                                                            break label3463;
                                                         }
                                                      }
                                                   }

                                                   var70 = var39 - var22;
                                                   if(var70 != 0) {
                                                      var17 = var70;
                                                   } else {
                                                      for(int var71 = 0; var71 < var68; ++var71) {
                                                         var30 = var99.charAt(var71);
                                                         char var31 = var83.charAt(var71);
                                                         if(var31 != var30) {
                                                            var17 = class142.method2606(var30, var20) - class142.method2606(var31, var20);
                                                            break label3463;
                                                         }
                                                      }

                                                      var17 = 0;
                                                   }
                                                   break;
                                                }

                                                if(var23 - var25 >= var39) {
                                                   var17 = -1;
                                                   break;
                                                }

                                                if(var24 - var26 >= var22) {
                                                   var17 = 1;
                                                   break;
                                                }

                                                char var27;
                                                if(var25 != 0) {
                                                   var27 = var25;
                                                   boolean var61 = false;
                                                } else {
                                                   var27 = var99.charAt(var23++);
                                                }

                                                char var28;
                                                if(var26 != 0) {
                                                   var28 = var26;
                                                   boolean var64 = false;
                                                } else {
                                                   var28 = var83.charAt(var24++);
                                                }

                                                var25 = PlayerComposition.method3079(var27);
                                                var26 = PlayerComposition.method3079(var28);
                                                var27 = class63.method1106(var27, var20);
                                                var28 = class63.method1106(var28, var20);
                                                if(var27 != var28 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                                   var27 = Character.toLowerCase(var27);
                                                   var28 = Character.toLowerCase(var28);
                                                   if(var28 != var27) {
                                                      var17 = class142.method2606(var27, var20) - class142.method2606(var28, var20);
                                                      break;
                                                   }
                                                }
                                             }

                                             var105[var38] = class108.method1990(var17);
                                             continue;
                                          }

                                          Font var91;
                                          byte[] var95;
                                          if(var44 == 4108) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var38 = class32.field728[var5];
                                             var17 = class32.field728[1 + var5];
                                             var95 = class6.field68.getConfigData(var17, 0);
                                             var91 = new Font(var95);
                                             class32.field728[var5++] = var91.method3744(var103, var38);
                                             continue;
                                          }

                                          if(var44 == 4109) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var38 = class32.field728[var5];
                                             var17 = class32.field728[1 + var5];
                                             var95 = class6.field68.getConfigData(var17, 0);
                                             var91 = new Font(var95);
                                             class32.field728[var5++] = var91.method3724(var103, var38);
                                             continue;
                                          }

                                          if(var44 == 4110) {
                                             var6 -= 2;
                                             var103 = class32.chatboxSegments[var6];
                                             var46 = class32.chatboxSegments[1 + var6];
                                             --var5;
                                             if(class32.field728[var5] == 1) {
                                                class32.chatboxSegments[var6++] = var103;
                                             } else {
                                                class32.chatboxSegments[var6++] = var46;
                                             }
                                             continue;
                                          }

                                          if(var44 == 4111) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = FontTypeFace.method3726(var103);
                                             continue;
                                          }

                                          if(var44 == 4112) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             --var5;
                                             var38 = class32.field728[var5];
                                             class32.chatboxSegments[var6++] = var103 + (char)var38;
                                             continue;
                                          }

                                          char var60;
                                          if(var44 == 4113) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var55 = class32.field728;
                                             var17 = var5++;
                                             var60 = (char)var15;
                                             if(var60 >= 32 && var60 <= 126) {
                                                var53 = true;
                                             } else if(var60 >= 160 && var60 <= 255) {
                                                var53 = true;
                                             } else if(var60 != 8364 && var60 != 338 && var60 != 8212 && var60 != 339 && var60 != 376) {
                                                var53 = false;
                                             } else {
                                                var53 = true;
                                             }

                                             var55[var17] = var53?1:0;
                                             continue;
                                          }

                                          if(var44 == 4114) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var55 = class32.field728;
                                             var17 = var5++;
                                             var60 = (char)var15;
                                             var53 = var60 >= 48 && var60 <= 57 || var60 >= 65 && var60 <= 90 || var60 >= 97 && var60 <= 122;
                                             var55[var17] = var53?1:0;
                                             continue;
                                          }

                                          if(var44 == 4115) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var55 = class32.field728;
                                             var17 = var5++;
                                             var60 = (char)var15;
                                             var53 = var60 >= 65 && var60 <= 90 || var60 >= 97 && var60 <= 122;
                                             var55[var17] = var53?1:0;
                                             continue;
                                          }

                                          if(var44 == 4116) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = class183.method3268((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var44 == 4117) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             if(var103 != null) {
                                                class32.field728[var5++] = var103.length();
                                             } else {
                                                class32.field728[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var44 == 4118) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var38 = class32.field728[var5];
                                             var17 = class32.field728[1 + var5];
                                             class32.chatboxSegments[var6++] = var103.substring(var38, var17);
                                             continue;
                                          }

                                          if(var44 == 4119) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             StringBuilder var54 = new StringBuilder(var103.length());
                                             var48 = false;

                                             for(var18 = 0; var18 < var103.length(); ++var18) {
                                                var60 = var103.charAt(var18);
                                                if(var60 == 60) {
                                                   var48 = true;
                                                } else if(var60 == 62) {
                                                   var48 = false;
                                                } else if(!var48) {
                                                   var54.append(var60);
                                                }
                                             }

                                             class32.chatboxSegments[var6++] = var54.toString();
                                             continue;
                                          }

                                          if(var44 == 4120) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             --var5;
                                             var38 = class32.field728[var5];
                                             class32.field728[var5++] = var103.indexOf(var38);
                                             continue;
                                          }

                                          if(var44 == 4121) {
                                             var6 -= 2;
                                             var103 = class32.chatboxSegments[var6];
                                             var46 = class32.chatboxSegments[1 + var6];
                                             --var5;
                                             var17 = class32.field728[var5];
                                             class32.field728[var5++] = var103.indexOf(var46, var17);
                                             continue;
                                          }
                                       } else if(var44 < 4300) {
                                          if(var44 == 4200) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.chatboxSegments[var6++] = NPC.getItemDefinition(var15).name;
                                             continue;
                                          }

                                          ItemComposition var84;
                                          if(var44 == 4201) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             var84 = NPC.getItemDefinition(var15);
                                             if(var38 >= 1 && var38 <= 5 && var84.groundActions[var38 - 1] != null) {
                                                class32.chatboxSegments[var6++] = var84.groundActions[var38 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var44 == 4202) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             var84 = NPC.getItemDefinition(var15);
                                             if(var38 >= 1 && var38 <= 5 && null != var84.inventoryActions[var38 - 1]) {
                                                class32.chatboxSegments[var6++] = var84.inventoryActions[var38 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var44 == 4203) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = NPC.getItemDefinition(var15).price;
                                             continue;
                                          }

                                          if(var44 == 4204) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = NPC.getItemDefinition(var15).isStackable == 1?1:0;
                                             continue;
                                          }

                                          ItemComposition var59;
                                          if(var44 == 4205) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var59 = NPC.getItemDefinition(var15);
                                             if(var59.notedTemplate == -1 && var59.note >= 0) {
                                                class32.field728[var5++] = var59.note;
                                                continue;
                                             }

                                             class32.field728[var5++] = var15;
                                             continue;
                                          }

                                          if(var44 == 4206) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var59 = NPC.getItemDefinition(var15);
                                             if(var59.notedTemplate >= 0 && var59.note >= 0) {
                                                class32.field728[var5++] = var59.note;
                                                continue;
                                             }

                                             class32.field728[var5++] = var15;
                                             continue;
                                          }

                                          if(var44 == 4207) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = NPC.getItemDefinition(var15).isMembers?1:0;
                                             continue;
                                          }

                                          if(var44 == 4208) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var59 = NPC.getItemDefinition(var15);
                                             if(var59.field3002 == -1 && var59.field3001 >= 0) {
                                                class32.field728[var5++] = var59.field3001;
                                                continue;
                                             }

                                             class32.field728[var5++] = var15;
                                             continue;
                                          }

                                          if(var44 == 4209) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var59 = NPC.getItemDefinition(var15);
                                             if(var59.field3002 >= 0 && var59.field3001 >= 0) {
                                                class32.field728[var5++] = var59.field3001;
                                                continue;
                                             }

                                             class32.field728[var5++] = var15;
                                             continue;
                                          }

                                          if(var44 == 4210) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             --var5;
                                             var38 = class32.field728[var5];
                                             class181.method3178(var103, var38 == 1);
                                             class32.field728[var5++] = class168.field2197;
                                             continue;
                                          }

                                          if(var44 == 4211) {
                                             if(null != class22.field249 && ChatMessages.field918 < class168.field2197) {
                                                class32.field728[var5++] = class22.field249[++ChatMessages.field918 - 1] & '\uffff';
                                                continue;
                                             }

                                             class32.field728[var5++] = -1;
                                             continue;
                                          }

                                          if(var44 == 4212) {
                                             ChatMessages.field918 = 0;
                                             continue;
                                          }
                                       } else if(var44 < 5100) {
                                          if(var44 == 5000) {
                                             class32.field728[var5++] = Client.field510;
                                             continue;
                                          }

                                          if(var44 == 5001) {
                                             var5 -= 3;
                                             Client.field510 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             class216[] var92 = class3.method31();
                                             var18 = 0;

                                             class216 var109;
                                             while(true) {
                                                if(var18 >= var92.length) {
                                                   var109 = null;
                                                   break;
                                                }

                                                class216 var96 = var92[var18];
                                                if(var38 == var96.field3168) {
                                                   var109 = var96;
                                                   break;
                                                }

                                                ++var18;
                                             }

                                             class32.field731 = var109;
                                             if(null == class32.field731) {
                                                class32.field731 = class216.field3167;
                                             }

                                             Client.field514 = class32.field728[var5 + 2];
                                             Client.field336.method2963(89);
                                             Client.field336.method2708(Client.field510);
                                             Client.field336.method2708(class32.field731.field3168);
                                             Client.field336.method2708(Client.field514);
                                             continue;
                                          }

                                          if(var44 == 5002) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var38 = class32.field728[var5];
                                             var17 = class32.field728[var5 + 1];
                                             Client.field336.method2963(184);
                                             var85 = Client.field336;
                                             var19 = var103.length() + 1;
                                             var85.method2708(2 + var19);
                                             Client.field336.method2714(var103);
                                             Client.field336.method2708(var38 - 1);
                                             Client.field336.method2708(var17);
                                             continue;
                                          }

                                          if(var44 == 5003) {
                                             var5 -= 2;
                                             var15 = class32.field728[var5];
                                             var38 = class32.field728[var5 + 1];
                                             MessageNode var89 = class156.method2933(var15, var38);
                                             if(null != var89) {
                                                class32.field728[var5++] = var89.id;
                                                class32.field728[var5++] = var89.tick;
                                                class32.chatboxSegments[var6++] = null != var89.name?var89.name:"";
                                                class32.chatboxSegments[var6++] = null != var89.sender?var89.sender:"";
                                                class32.chatboxSegments[var6++] = var89.value != null?var89.value:"";
                                             } else {
                                                class32.field728[var5++] = -1;
                                                class32.field728[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var44 == 5004) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             MessageNode var63 = (MessageNode)class47.field927.method2251((long)var15);
                                             if(null != var63) {
                                                class32.field728[var5++] = var63.type;
                                                class32.field728[var5++] = var63.tick;
                                                class32.chatboxSegments[var6++] = var63.name != null?var63.name:"";
                                                class32.chatboxSegments[var6++] = null != var63.sender?var63.sender:"";
                                                class32.chatboxSegments[var6++] = null != var63.value?var63.value:"";
                                             } else {
                                                class32.field728[var5++] = -1;
                                                class32.field728[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var44 == 5005) {
                                             if(null == class32.field731) {
                                                class32.field728[var5++] = -1;
                                             } else {
                                                class32.field728[var5++] = class32.field731.field3168;
                                             }
                                             continue;
                                          }

                                          if(var44 == 5008) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             --var5;
                                             var38 = class32.field728[var5];
                                             var34 = var103.toLowerCase();
                                             byte var65 = 0;
                                             if(var34.startsWith("yellow:")) {
                                                var65 = 0;
                                                var103 = var103.substring("yellow:".length());
                                             } else if(var34.startsWith("red:")) {
                                                var65 = 1;
                                                var103 = var103.substring("red:".length());
                                             } else if(var34.startsWith("green:")) {
                                                var65 = 2;
                                                var103 = var103.substring("green:".length());
                                             } else if(var34.startsWith("cyan:")) {
                                                var65 = 3;
                                                var103 = var103.substring("cyan:".length());
                                             } else if(var34.startsWith("purple:")) {
                                                var65 = 4;
                                                var103 = var103.substring("purple:".length());
                                             } else if(var34.startsWith("white:")) {
                                                var65 = 5;
                                                var103 = var103.substring("white:".length());
                                             } else if(var34.startsWith("flash1:")) {
                                                var65 = 6;
                                                var103 = var103.substring("flash1:".length());
                                             } else if(var34.startsWith("flash2:")) {
                                                var65 = 7;
                                                var103 = var103.substring("flash2:".length());
                                             } else if(var34.startsWith("flash3:")) {
                                                var65 = 8;
                                                var103 = var103.substring("flash3:".length());
                                             } else if(var34.startsWith("glow1:")) {
                                                var65 = 9;
                                                var103 = var103.substring("glow1:".length());
                                             } else if(var34.startsWith("glow2:")) {
                                                var65 = 10;
                                                var103 = var103.substring("glow2:".length());
                                             } else if(var34.startsWith("glow3:")) {
                                                var65 = 11;
                                                var103 = var103.substring("glow3:".length());
                                             } else if(Client.field300 != 0) {
                                                if(var34.startsWith("yellow:")) {
                                                   var65 = 0;
                                                   var103 = var103.substring("yellow:".length());
                                                } else if(var34.startsWith("red:")) {
                                                   var65 = 1;
                                                   var103 = var103.substring("red:".length());
                                                } else if(var34.startsWith("green:")) {
                                                   var65 = 2;
                                                   var103 = var103.substring("green:".length());
                                                } else if(var34.startsWith("cyan:")) {
                                                   var65 = 3;
                                                   var103 = var103.substring("cyan:".length());
                                                } else if(var34.startsWith("purple:")) {
                                                   var65 = 4;
                                                   var103 = var103.substring("purple:".length());
                                                } else if(var34.startsWith("white:")) {
                                                   var65 = 5;
                                                   var103 = var103.substring("white:".length());
                                                } else if(var34.startsWith("flash1:")) {
                                                   var65 = 6;
                                                   var103 = var103.substring("flash1:".length());
                                                } else if(var34.startsWith("flash2:")) {
                                                   var65 = 7;
                                                   var103 = var103.substring("flash2:".length());
                                                } else if(var34.startsWith("flash3:")) {
                                                   var65 = 8;
                                                   var103 = var103.substring("flash3:".length());
                                                } else if(var34.startsWith("glow1:")) {
                                                   var65 = 9;
                                                   var103 = var103.substring("glow1:".length());
                                                } else if(var34.startsWith("glow2:")) {
                                                   var65 = 10;
                                                   var103 = var103.substring("glow2:".length());
                                                } else if(var34.startsWith("glow3:")) {
                                                   var65 = 11;
                                                   var103 = var103.substring("glow3:".length());
                                                }
                                             }

                                             var34 = var103.toLowerCase();
                                             byte var62 = 0;
                                             if(var34.startsWith("wave:")) {
                                                var62 = 1;
                                                var103 = var103.substring("wave:".length());
                                             } else if(var34.startsWith("wave2:")) {
                                                var62 = 2;
                                                var103 = var103.substring("wave2:".length());
                                             } else if(var34.startsWith("shake:")) {
                                                var62 = 3;
                                                var103 = var103.substring("shake:".length());
                                             } else if(var34.startsWith("scroll:")) {
                                                var62 = 4;
                                                var103 = var103.substring("scroll:".length());
                                             } else if(var34.startsWith("slide:")) {
                                                var62 = 5;
                                                var103 = var103.substring("slide:".length());
                                             } else if(Client.field300 != 0) {
                                                if(var34.startsWith("wave:")) {
                                                   var62 = 1;
                                                   var103 = var103.substring("wave:".length());
                                                } else if(var34.startsWith("wave2:")) {
                                                   var62 = 2;
                                                   var103 = var103.substring("wave2:".length());
                                                } else if(var34.startsWith("shake:")) {
                                                   var62 = 3;
                                                   var103 = var103.substring("shake:".length());
                                                } else if(var34.startsWith("scroll:")) {
                                                   var62 = 4;
                                                   var103 = var103.substring("scroll:".length());
                                                } else if(var34.startsWith("slide:")) {
                                                   var62 = 5;
                                                   var103 = var103.substring("slide:".length());
                                                }
                                             }

                                             Client.field336.method2963(138);
                                             Client.field336.method2708(0);
                                             var20 = Client.field336.offset;
                                             Client.field336.method2708(var38);
                                             Client.field336.method2708(var65);
                                             Client.field336.method2708(var62);
                                             class32.method666(Client.field336, var103);
                                             Client.field336.method2768(Client.field336.offset - var20);
                                             continue;
                                          }

                                          if(var44 == 5009) {
                                             var6 -= 2;
                                             var103 = class32.chatboxSegments[var6];
                                             var46 = class32.chatboxSegments[var6 + 1];
                                             Client.field336.method2963(241);
                                             Client.field336.method2709(0);
                                             var17 = Client.field336.offset;
                                             Client.field336.method2714(var103);
                                             class32.method666(Client.field336, var46);
                                             Client.field336.method2885(Client.field336.offset - var17);
                                             continue;
                                          }

                                          if(var44 == 5015) {
                                             if(null != XItemContainer.localPlayer && null != XItemContainer.localPlayer.name) {
                                                var103 = XItemContainer.localPlayer.name;
                                             } else {
                                                var103 = "";
                                             }

                                             class32.chatboxSegments[var6++] = var103;
                                             continue;
                                          }

                                          if(var44 == 5016) {
                                             class32.field728[var5++] = Client.field514;
                                             continue;
                                          }

                                          if(var44 == 5017) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             class32.field728[var5++] = MessageNode.method183(var15);
                                             continue;
                                          }

                                          MessageNode var94;
                                          if(var44 == 5018) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var55 = class32.field728;
                                             var17 = var5++;
                                             var94 = (MessageNode)class47.field927.method2251((long)var15);
                                             if(null == var94) {
                                                var18 = -1;
                                             } else if(class47.field922.field1906 == var94.previous) {
                                                var18 = -1;
                                             } else {
                                                var18 = ((MessageNode)var94.previous).id;
                                             }

                                             var55[var17] = var18;
                                             continue;
                                          }

                                          if(var44 == 5019) {
                                             --var5;
                                             var15 = class32.field728[var5];
                                             var55 = class32.field728;
                                             var17 = var5++;
                                             var94 = (MessageNode)class47.field927.method2251((long)var15);
                                             if(var94 == null) {
                                                var18 = -1;
                                             } else if(var94.next == class47.field922.field1906) {
                                                var18 = -1;
                                             } else {
                                                var18 = ((MessageNode)var94.next).id;
                                             }

                                             var55[var17] = var18;
                                             continue;
                                          }

                                          if(var44 == 5020) {
                                             --var6;
                                             var103 = class32.chatboxSegments[var6];
                                             class103.method1927(var103);
                                             continue;
                                          }

                                          if(var44 == 5021) {
                                             --var6;
                                             Client.field512 = class32.chatboxSegments[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var44 == 5022) {
                                             class32.chatboxSegments[var6++] = Client.field512;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var44 >= 2000) {
                              var44 -= 1000;
                              --var5;
                              var33 = class108.method1988(class32.field728[var5]);
                           } else {
                              var33 = var51?class16.field181:class32.field727;
                           }

                           if(var44 == 1927) {
                              if(class32.field734 >= 10) {
                                 throw new RuntimeException();
                              }

                              if(null == var33.field2318) {
                                 return;
                              }

                              class18 var16 = new class18();
                              var16.field204 = var33;
                              var16.field205 = var33.field2318;
                              var16.field212 = class32.field734 + 1;
                              Client.field417.method2333(var0);
                              continue;
                           }
                        }
                     } else {
                        if(var44 >= 2000) {
                           var44 -= 1000;
                           --var5;
                           var33 = class108.method1988(class32.field728[var5]);
                        } else {
                           var33 = var51?class16.field181:class32.field727;
                        }

                        if(var44 == 1300) {
                           --var5;
                           var38 = class32.field728[var5] - 1;
                           if(var38 >= 0 && var38 <= 9) {
                              --var6;
                              var33.method3101(var38, class32.chatboxSegments[var6]);
                              continue;
                           }

                           --var6;
                           continue;
                        }

                        if(var44 == 1301) {
                           var5 -= 2;
                           var38 = class32.field728[var5];
                           var17 = class32.field728[1 + var5];
                           var33.parent = method2038(var38, var17);
                           continue;
                        }

                        if(var44 == 1302) {
                           --var5;
                           var33.field2266 = class32.field728[var5] == 1;
                           continue;
                        }

                        if(var44 == 1303) {
                           --var5;
                           var33.field2285 = class32.field728[var5];
                           continue;
                        }

                        if(var44 == 1304) {
                           --var5;
                           var33.field2231 = class32.field728[var5];
                           continue;
                        }

                        if(var44 == 1305) {
                           --var6;
                           var33.name = class32.chatboxSegments[var6];
                           continue;
                        }

                        if(var44 == 1306) {
                           --var6;
                           var33.field2323 = class32.chatboxSegments[var6];
                           continue;
                        }

                        if(var44 == 1307) {
                           var33.actions = null;
                           continue;
                        }
                     }
                  } else {
                     if(var44 >= 2000) {
                        var44 -= 1000;
                        --var5;
                        var33 = class108.method1988(class32.field728[var5]);
                     } else {
                        var33 = var51?class16.field181:class32.field727;
                     }

                     class204.method3671(var33);
                     if(var44 == 1200 || var44 == 1205 || var44 == 1212) {
                        var5 -= 2;
                        var38 = class32.field728[var5];
                        var17 = class32.field728[var5 + 1];
                        var33.item = var38;
                        var33.stackSize = var17;
                        ItemComposition var37 = NPC.getItemDefinition(var38);
                        var33.rotationX = var37.xan2d;
                        var33.rotationZ = var37.yan2d;
                        var33.rotationY = var37.zan2d;
                        var33.field2297 = var37.offsetX2d;
                        var33.field2259 = var37.offsetY2d;
                        var33.field2263 = var37.zoom2d;
                        if(var44 == 1205) {
                           var33.field2267 = 0;
                        } else if(var44 == 1212 | var37.isStackable == 1) {
                           var33.field2267 = 1;
                        } else {
                           var33.field2267 = 2;
                        }

                        if(var33.field2265 > 0) {
                           var33.field2263 = var33.field2263 * 32 / var33.field2265;
                        } else if(var33.originalWidth > 0) {
                           var33.field2263 = var33.field2263 * 32 / var33.originalWidth;
                        }
                        continue;
                     }

                     if(var44 == 1201) {
                        var33.modelType = 2;
                        --var5;
                        var33.modelId = class32.field728[var5];
                        continue;
                     }

                     if(var44 == 1202) {
                        var33.modelType = 3;
                        var33.modelId = XItemContainer.localPlayer.composition.method3049();
                        continue;
                     }
                  }
               }

               if(var44 < 5400) {
                  if(var44 == 5306) {
                     class32.field728[var5++] = Tile.method1515();
                     continue;
                  }

                  if(var44 == 5307) {
                     --var5;
                     var15 = class32.field728[var5];
                     if(var15 == 1 || var15 == 2) {
                        class180.method3175(var15);
                     }
                     continue;
                  }

                  if(var44 == 5308) {
                     class32.field728[var5++] = class38.field794.field696;
                     continue;
                  }

                  if(var44 == 5309) {
                     --var5;
                     var15 = class32.field728[var5];
                     if(var15 == 1 || var15 == 2) {
                        class38.field794.field696 = var15;
                        PlayerComposition.method3057();
                     }
                     continue;
                  }
               }

               if(var44 < 5600) {
                  if(var44 == 5504) {
                     var5 -= 2;
                     var15 = class32.field728[var5];
                     var38 = class32.field728[1 + var5];
                     if(!Client.field499) {
                        Client.field419 = var15;
                        Client.mapAngle = var38;
                     }
                     continue;
                  }

                  if(var44 == 5505) {
                     class32.field728[var5++] = Client.field419;
                     continue;
                  }

                  if(var44 == 5506) {
                     class32.field728[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var44 == 5530) {
                     --var5;
                     var15 = class32.field728[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field366 = var15;
                     continue;
                  }

                  if(var44 == 5531) {
                     class32.field728[var5++] = Client.field366;
                     continue;
                  }
               }

               if(var44 < 5700 && var44 == 5630) {
                  Client.field346 = 250;
               } else {
                  if(var44 < 6300) {
                     if(var44 == 6200) {
                        var5 -= 2;
                        Client.field546 = (short)class32.field728[var5];
                        if(Client.field546 <= 0) {
                           Client.field546 = 256;
                        }

                        Client.field547 = (short)class32.field728[var5 + 1];
                        if(Client.field547 <= 0) {
                           Client.field547 = 205;
                        }
                        continue;
                     }

                     if(var44 == 6201) {
                        var5 -= 2;
                        Client.field535 = (short)class32.field728[var5];
                        if(Client.field535 <= 0) {
                           Client.field535 = 256;
                        }

                        Client.field549 = (short)class32.field728[var5 + 1];
                        if(Client.field549 <= 0) {
                           Client.field549 = 320;
                        }
                        continue;
                     }

                     if(var44 == 6202) {
                        var5 -= 4;
                        Client.field550 = (short)class32.field728[var5];
                        if(Client.field550 <= 0) {
                           Client.field550 = 1;
                        }

                        Client.field384 = (short)class32.field728[1 + var5];
                        if(Client.field384 <= 0) {
                           Client.field384 = 32767;
                        } else if(Client.field384 < Client.field550) {
                           Client.field384 = Client.field550;
                        }

                        Client.field374 = (short)class32.field728[var5 + 2];
                        if(Client.field374 <= 0) {
                           Client.field374 = 1;
                        }

                        Client.field553 = (short)class32.field728[3 + var5];
                        if(Client.field553 <= 0) {
                           Client.field553 = 32767;
                        } else if(Client.field553 < Client.field374) {
                           Client.field553 = Client.field374;
                        }
                        continue;
                     }

                     if(var44 == 6203) {
                        if(null != Client.field463) {
                           class1.method11(0, 0, Client.field463.width, Client.field463.height, false);
                           class32.field728[var5++] = Client.camera2;
                           class32.field728[var5++] = Client.camera3;
                        } else {
                           class32.field728[var5++] = -1;
                           class32.field728[var5++] = -1;
                        }
                        continue;
                     }

                     if(var44 == 6204) {
                        class32.field728[var5++] = Client.field535;
                        class32.field728[var5++] = Client.field549;
                        continue;
                     }

                     if(var44 == 6205) {
                        class32.field728[var5++] = Client.field546;
                        class32.field728[var5++] = Client.field547;
                        continue;
                     }
                  }

                  if(var44 < 6600) {
                     if(var44 == 6500) {
                        class32.field728[var5++] = class10.loadWorlds()?1:0;
                        continue;
                     }

                     World var69;
                     if(var44 == 6501) {
                        World.field678 = 0;
                        if(World.field678 < World.field682) {
                           var69 = World.worldList[++World.field678 - 1];
                        } else {
                           var69 = null;
                        }

                        if(var69 != null) {
                           class32.field728[var5++] = var69.id;
                           class32.field728[var5++] = var69.mask;
                           class32.chatboxSegments[var6++] = var69.activity;
                           class32.field728[var5++] = var69.location;
                           class32.field728[var5++] = var69.playerCount;
                           class32.chatboxSegments[var6++] = var69.address;
                        } else {
                           class32.field728[var5++] = -1;
                           class32.field728[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field728[var5++] = 0;
                           class32.field728[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var44 == 6502) {
                        World var110;
                        if(World.field678 < World.field682) {
                           var110 = World.worldList[++World.field678 - 1];
                        } else {
                           var110 = null;
                        }

                        if(var110 != null) {
                           class32.field728[var5++] = var110.id;
                           class32.field728[var5++] = var110.mask;
                           class32.chatboxSegments[var6++] = var110.activity;
                           class32.field728[var5++] = var110.location;
                           class32.field728[var5++] = var110.playerCount;
                           class32.chatboxSegments[var6++] = var110.address;
                        } else {
                           class32.field728[var5++] = -1;
                           class32.field728[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field728[var5++] = 0;
                           class32.field728[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var44 == 6506) {
                        --var5;
                        var15 = class32.field728[var5];
                        var69 = null;

                        for(var17 = 0; var17 < World.field682; ++var17) {
                           if(var15 == World.worldList[var17].id) {
                              var69 = World.worldList[var17];
                              break;
                           }
                        }

                        if(null != var69) {
                           class32.field728[var5++] = var69.id;
                           class32.field728[var5++] = var69.mask;
                           class32.chatboxSegments[var6++] = var69.activity;
                           class32.field728[var5++] = var69.location;
                           class32.field728[var5++] = var69.playerCount;
                           class32.chatboxSegments[var6++] = var69.address;
                        } else {
                           class32.field728[var5++] = -1;
                           class32.field728[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field728[var5++] = 0;
                           class32.field728[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var44 == 6507) {
                        var5 -= 4;
                        var15 = class32.field728[var5];
                        var97 = class32.field728[1 + var5] == 1;
                        var17 = class32.field728[var5 + 2];
                        var53 = class32.field728[var5 + 3] == 1;
                        if(null != World.worldList) {
                           class156.method2944(0, World.worldList.length - 1, var15, var97, var17, var53);
                        }
                        continue;
                     }

                     if(var44 == 6511) {
                        --var5;
                        var15 = class32.field728[var5];
                        if(var15 >= 0 && var15 < World.field682) {
                           var69 = World.worldList[var15];
                           class32.field728[var5++] = var69.id;
                           class32.field728[var5++] = var69.mask;
                           class32.chatboxSegments[var6++] = var69.activity;
                           class32.field728[var5++] = var69.location;
                           class32.field728[var5++] = var69.playerCount;
                           class32.chatboxSegments[var6++] = var69.address;
                           continue;
                        }

                        class32.field728[var5++] = -1;
                        class32.field728[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field728[var5++] = 0;
                        class32.field728[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var43) {
            StringBuilder var42 = new StringBuilder(30);
            var42.append("").append(var4.hash).append(" ");

            for(var13 = class32.field735 - 1; var13 >= 0; --var13) {
               var42.append("").append(class32.field730[var13].field122.hash).append(" ");
            }

            var42.append("").append(var10);
            NPC.method695(var42.toString(), var43);
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "8"
   )
   public static int method2048(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }
}

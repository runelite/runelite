import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("p")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("g")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("at")
   static class184 field118;
   @ObfuscatedName("x")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "-921433924"
   )
   static void method160(class18 var0, int var1) {
      Object[] var2 = var0.field188;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = class2.method30(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field941;
         int[] var9 = var4.field947;
         byte var10 = -1;
         class32.field725 = 0;

         int var13;
         try {
            class32.field716 = new int[var4.field938];
            int var11 = 0;
            class32.field719 = new String[var4.field942];
            int var12 = 0;

            int var14;
            String var32;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field183;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field184;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field180 != null?var0.field180.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field187;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field180?var0.field180.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field186?var0.field186.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field186 != null?var0.field186.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field195;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field198;
                  }

                  class32.field716[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var32 = (String)var2[var13];
                  if(var32.equals("event_opbase")) {
                     var32 = var0.field190;
                  }

                  class32.field719[var12++] = var32;
               }
            }

            var13 = 0;
            class32.field729 = var0.field185;

            label3607:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var53 = var8[var7];
               int var15;
               int var19;
               int var20;
               int var21;
               int var33;
               int var35;
               int[] var57;
               String[] var65;
               byte[] var69;
               String var106;
               if(var53 < 100) {
                  if(var53 == 0) {
                     class32.field722[var5++] = var9[var7];
                     continue;
                  }

                  if(var53 == 1) {
                     var14 = var9[var7];
                     class32.field722[var5++] = class165.widgetSettings[var14];
                     continue;
                  }

                  if(var53 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class165.widgetSettings[var14] = class32.field722[var5];
                     class37.method732(var14);
                     continue;
                  }

                  if(var53 == 3) {
                     class32.chatboxSegments[var6++] = var4.field940[var7];
                     continue;
                  }

                  if(var53 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var53 == 7) {
                     var5 -= 2;
                     if(class32.field722[var5] != class32.field722[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var53 == 8) {
                     var5 -= 2;
                     if(class32.field722[var5 + 1] == class32.field722[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var53 == 9) {
                     var5 -= 2;
                     if(class32.field722[var5] < class32.field722[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var53 == 10) {
                     var5 -= 2;
                     if(class32.field722[var5] > class32.field722[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var53 == 21) {
                     if(class32.field725 == 0) {
                        return;
                     }

                     class11 var92 = class32.field724[--class32.field725];
                     var4 = var92.field109;
                     var8 = var4.field941;
                     var9 = var4.field947;
                     var7 = var92.field105;
                     class32.field716 = var92.field104;
                     class32.field719 = var92.field107;
                     continue;
                  }

                  if(var53 == 25) {
                     var14 = var9[var7];
                     class32.field722[var5++] = class8.method114(var14);
                     continue;
                  }

                  if(var53 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field722[var5];
                     Varbit var77 = (Varbit)Varbit.field2845.get((long)var14);
                     Varbit var90;
                     if(var77 != null) {
                        var90 = var77;
                     } else {
                        var69 = class44.field892.getConfigData(14, var14);
                        var77 = new Varbit();
                        if(var69 != null) {
                           var77.method3528(new Buffer(var69));
                        }

                        Varbit.field2845.put(var77, (long)var14);
                        var90 = var77;
                     }

                     var33 = var90.leastSignificantBit;
                     var19 = var90.configId;
                     var20 = var90.mostSignificantBit;
                     var21 = class165.field2162[var20 - var19];
                     if(var15 < 0 || var15 > var21) {
                        var15 = 0;
                     }

                     var21 <<= var19;
                     class165.widgetSettings[var33] = class165.widgetSettings[var33] & ~var21 | var15 << var19 & var21;
                     continue;
                  }

                  if(var53 == 31) {
                     var5 -= 2;
                     if(class32.field722[var5] <= class32.field722[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var53 == 32) {
                     var5 -= 2;
                     if(class32.field722[var5] >= class32.field722[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var53 == 33) {
                     class32.field722[var5++] = class32.field716[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var53 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class32.field716[var10001] = class32.field722[var5];
                     continue;
                  }

                  if(var53 == 35) {
                     class32.chatboxSegments[var6++] = class32.field719[var9[var7]];
                     continue;
                  }

                  if(var53 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class32.field719[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var53 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var106 = CombatInfoListHolder.method689(class32.chatboxSegments, var6, var14);
                     class32.chatboxSegments[var6++] = var106;
                     continue;
                  }

                  if(var53 == 38) {
                     --var5;
                     continue;
                  }

                  if(var53 == 39) {
                     --var6;
                     continue;
                  }

                  if(var53 == 40) {
                     var14 = var9[var7];
                     class48 var110 = class2.method30(var14);
                     var57 = new int[var110.field938];
                     var65 = new String[var110.field942];

                     for(var33 = 0; var33 < var110.field943; ++var33) {
                        var57[var33] = class32.field722[var33 + (var5 - var110.field943)];
                     }

                     for(var33 = 0; var33 < var110.field944; ++var33) {
                        var65[var33] = class32.chatboxSegments[var6 - var110.field944 + var33];
                     }

                     var5 -= var110.field943;
                     var6 -= var110.field944;
                     class11 var91 = new class11();
                     var91.field109 = var4;
                     var91.field105 = var7;
                     var91.field104 = class32.field716;
                     var91.field107 = class32.field719;
                     class32.field724[++class32.field725 - 1] = var91;
                     var4 = var110;
                     var8 = var110.field941;
                     var9 = var110.field947;
                     var7 = -1;
                     class32.field716 = var57;
                     class32.field719 = var65;
                     continue;
                  }

                  if(var53 == 42) {
                     class32.field722[var5++] = Tile.chatMessages.method824(var9[var7]);
                     continue;
                  }

                  if(var53 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     Tile.chatMessages.method823(var10001, class32.field722[var5]);
                     continue;
                  }

                  if(var53 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var35 = class32.field722[var5];
                     if(var35 >= 0 && var35 <= 5000) {
                        class32.field718[var14] = var35;
                        byte var105 = -1;
                        if(var15 == 105) {
                           var105 = 0;
                        }

                        var33 = 0;

                        while(true) {
                           if(var33 >= var35) {
                              continue label3607;
                           }

                           class32.field720[var14][var33] = var105;
                           ++var33;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var53 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class32.field722[var5];
                     if(var15 >= 0 && var15 < class32.field718[var14]) {
                        class32.field722[var5++] = class32.field720[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var53 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class32.field722[var5];
                     if(var15 >= 0 && var15 < class32.field718[var14]) {
                        class32.field720[var14][var15] = class32.field722[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var53 == 47) {
                     var32 = Tile.chatMessages.method839(var9[var7]);
                     if(null == var32) {
                        var32 = "null";
                     }

                     class32.chatboxSegments[var6++] = var32;
                     continue;
                  }

                  if(var53 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     Tile.chatMessages.method860(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var70;
               if(var9[var7] == 1) {
                  var70 = true;
               } else {
                  var70 = false;
               }

               Widget var16;
               Widget var34;
               Widget var54;
               Widget var60;
               int var93;
               boolean var94;
               boolean var96;
               int[] var108;
               if(var53 < 1000) {
                  if(var53 == 100) {
                     var5 -= 3;
                     var15 = class32.field722[var5];
                     var35 = class32.field722[1 + var5];
                     var93 = class32.field722[2 + var5];
                     if(var35 == 0) {
                        throw new RuntimeException();
                     }

                     var60 = class37.method736(var15);
                     if(null == var60.children) {
                        var60.children = new Widget[var93 + 1];
                     }

                     if(var60.children.length <= var93) {
                        Widget[] var101 = new Widget[var93 + 1];

                        for(var20 = 0; var20 < var60.children.length; ++var20) {
                           var101[var20] = var60.children[var20];
                        }

                        var60.children = var101;
                     }

                     if(var93 > 0 && null == var60.children[var93 - 1]) {
                        throw new RuntimeException("" + (var93 - 1));
                     }

                     Widget var102 = new Widget();
                     var102.type = var35;
                     var102.parentId = var102.id = var60.id;
                     var102.index = var93;
                     var102.hasScript = true;
                     var60.children[var93] = var102;
                     if(var70) {
                        class32.field726 = var102;
                     } else {
                        class8.field76 = var102;
                     }

                     class33.method682(var60);
                     continue;
                  }

                  if(var53 == 101) {
                     var34 = var70?class32.field726:class8.field76;
                     var16 = class37.method736(var34.id);
                     var16.children[var34.index] = null;
                     class33.method682(var16);
                     continue;
                  }

                  if(var53 == 102) {
                     --var5;
                     var34 = class37.method736(class32.field722[var5]);
                     var34.children = null;
                     class33.method682(var34);
                     continue;
                  }

                  if(var53 == 200) {
                     var5 -= 2;
                     var15 = class32.field722[var5];
                     var35 = class32.field722[var5 + 1];
                     var54 = class105.method1992(var15, var35);
                     if(null != var54 && var35 != -1) {
                        class32.field722[var5++] = 1;
                        if(var70) {
                           class32.field726 = var54;
                        } else {
                           class8.field76 = var54;
                        }
                        continue;
                     }

                     class32.field722[var5++] = 0;
                     continue;
                  }

                  if(var53 == 201) {
                     --var5;
                     var34 = class37.method736(class32.field722[var5]);
                     if(var34 != null) {
                        class32.field722[var5++] = 1;
                        if(var70) {
                           class32.field726 = var34;
                        } else {
                           class8.field76 = var34;
                        }
                     } else {
                        class32.field722[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var36;
                  if((var53 < 1000 || var53 >= 1100) && (var53 < 2000 || var53 >= 2100)) {
                     String var17;
                     if((var53 < 1100 || var53 >= 1200) && (var53 < 2100 || var53 >= 2200)) {
                        if((var53 < 1200 || var53 >= 1300) && (var53 < 2200 || var53 >= 2300)) {
                           if((var53 < 1300 || var53 >= 1400) && (var53 < 2300 || var53 >= 2400)) {
                              int[] var55;
                              String var62;
                              if(var53 >= 1400 && var53 < 1500 || var53 >= 2400 && var53 < 2500) {
                                 if(var53 >= 2000) {
                                    var53 -= 1000;
                                    --var5;
                                    var34 = class37.method736(class32.field722[var5]);
                                 } else {
                                    var34 = var70?class32.field726:class8.field76;
                                 }

                                 --var6;
                                 var62 = class32.chatboxSegments[var6];
                                 var55 = null;
                                 if(var62.length() > 0 && var62.charAt(var62.length() - 1) == 89) {
                                    --var5;
                                    var33 = class32.field722[var5];
                                    if(var33 > 0) {
                                       for(var55 = new int[var33]; var33-- > 0; var55[var33] = class32.field722[var5]) {
                                          --var5;
                                       }
                                    }

                                    var62 = var62.substring(0, var62.length() - 1);
                                 }

                                 Object[] var74 = new Object[var62.length() + 1];

                                 for(var19 = var74.length - 1; var19 >= 1; --var19) {
                                    if(var62.charAt(var19 - 1) == 115) {
                                       --var6;
                                       var74[var19] = class32.chatboxSegments[var6];
                                    } else {
                                       --var5;
                                       var74[var19] = new Integer(class32.field722[var5]);
                                    }
                                 }

                                 --var5;
                                 var19 = class32.field722[var5];
                                 if(var19 != -1) {
                                    var74[0] = new Integer(var19);
                                 } else {
                                    var74 = null;
                                 }

                                 if(var53 == 1400) {
                                    var34.field2295 = var74;
                                 }

                                 if(var53 == 1401) {
                                    var34.field2293 = var74;
                                 }

                                 if(var53 == 1402) {
                                    var34.field2280 = var74;
                                 }

                                 if(var53 == 1403) {
                                    var34.field2282 = var74;
                                 }

                                 if(var53 == 1404) {
                                    var34.field2274 = var74;
                                 }

                                 if(var53 == 1405) {
                                    var34.field2285 = var74;
                                 }

                                 if(var53 == 1406) {
                                    var34.field2253 = var74;
                                 }

                                 if(var53 == 1407) {
                                    var34.field2248 = var74;
                                    var34.field2304 = var55;
                                 }

                                 if(var53 == 1408) {
                                    var34.field2219 = var74;
                                 }

                                 if(var53 == 1409) {
                                    var34.field2296 = var74;
                                 }

                                 if(var53 == 1410) {
                                    var34.field2286 = var74;
                                 }

                                 if(var53 == 1411) {
                                    var34.field2279 = var74;
                                 }

                                 if(var53 == 1412) {
                                    var34.field2213 = var74;
                                 }

                                 if(var53 == 1414) {
                                    var34.field2330 = var74;
                                    var34.field2292 = var55;
                                 }

                                 if(var53 == 1415) {
                                    var34.field2288 = var74;
                                    var34.field2294 = var55;
                                 }

                                 if(var53 == 1416) {
                                    var34.field2287 = var74;
                                 }

                                 if(var53 == 1417) {
                                    var34.field2205 = var74;
                                 }

                                 if(var53 == 1418) {
                                    var34.field2298 = var74;
                                 }

                                 if(var53 == 1419) {
                                    var34.field2290 = var74;
                                 }

                                 if(var53 == 1420) {
                                    var34.field2300 = var74;
                                 }

                                 if(var53 == 1421) {
                                    var34.field2301 = var74;
                                 }

                                 if(var53 == 1422) {
                                    var34.field2302 = var74;
                                 }

                                 if(var53 == 1423) {
                                    var34.field2303 = var74;
                                 }

                                 if(var53 == 1424) {
                                    var34.field2257 = var74;
                                 }

                                 if(var53 == 1425) {
                                    var34.field2306 = var74;
                                 }

                                 if(var53 == 1426) {
                                    var34.field2307 = var74;
                                 }

                                 if(var53 == 1427) {
                                    var34.field2305 = var74;
                                 }

                                 var34.field2276 = true;
                                 continue;
                              }

                              if(var53 < 1600) {
                                 var34 = var70?class32.field726:class8.field76;
                                 if(var53 == 1500) {
                                    class32.field722[var5++] = var34.relativeX;
                                    continue;
                                 }

                                 if(var53 == 1501) {
                                    class32.field722[var5++] = var34.relativeY;
                                    continue;
                                 }

                                 if(var53 == 1502) {
                                    class32.field722[var5++] = var34.width;
                                    continue;
                                 }

                                 if(var53 == 1503) {
                                    class32.field722[var5++] = var34.height;
                                    continue;
                                 }

                                 if(var53 == 1504) {
                                    class32.field722[var5++] = var34.isHidden?1:0;
                                    continue;
                                 }

                                 if(var53 == 1505) {
                                    class32.field722[var5++] = var34.parentId;
                                    continue;
                                 }
                              } else if(var53 < 1700) {
                                 var34 = var70?class32.field726:class8.field76;
                                 if(var53 == 1600) {
                                    class32.field722[var5++] = var34.scrollX;
                                    continue;
                                 }

                                 if(var53 == 1601) {
                                    class32.field722[var5++] = var34.scrollY;
                                    continue;
                                 }

                                 if(var53 == 1602) {
                                    class32.chatboxSegments[var6++] = var34.text;
                                    continue;
                                 }

                                 if(var53 == 1603) {
                                    class32.field722[var5++] = var34.scrollWidth;
                                    continue;
                                 }

                                 if(var53 == 1604) {
                                    class32.field722[var5++] = var34.scrollHeight;
                                    continue;
                                 }

                                 if(var53 == 1605) {
                                    class32.field722[var5++] = var34.field2250;
                                    continue;
                                 }

                                 if(var53 == 1606) {
                                    class32.field722[var5++] = var34.rotationX;
                                    continue;
                                 }

                                 if(var53 == 1607) {
                                    class32.field722[var5++] = var34.rotationY;
                                    continue;
                                 }

                                 if(var53 == 1608) {
                                    class32.field722[var5++] = var34.rotationZ;
                                    continue;
                                 }

                                 if(var53 == 1609) {
                                    class32.field722[var5++] = var34.opacity;
                                    continue;
                                 }

                                 if(var53 == 1610) {
                                    class32.field722[var5++] = var34.field2228;
                                    continue;
                                 }

                                 if(var53 == 1611) {
                                    class32.field722[var5++] = var34.textColor;
                                    continue;
                                 }

                                 if(var53 == 1612) {
                                    class32.field722[var5++] = var34.field2289;
                                    continue;
                                 }

                                 if(var53 == 1613) {
                                    class32.field722[var5++] = var34.field2226.vmethod4074();
                                    continue;
                                 }
                              } else if(var53 < 1800) {
                                 var34 = var70?class32.field726:class8.field76;
                                 if(var53 == 1700) {
                                    class32.field722[var5++] = var34.item;
                                    continue;
                                 }

                                 if(var53 == 1701) {
                                    if(var34.item != -1) {
                                       class32.field722[var5++] = var34.stackSize;
                                    } else {
                                       class32.field722[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var53 == 1702) {
                                    class32.field722[var5++] = var34.index;
                                    continue;
                                 }
                              } else if(var53 < 1900) {
                                 var34 = var70?class32.field726:class8.field76;
                                 if(var53 == 1800) {
                                    var57 = class32.field722;
                                    var93 = var5++;
                                    var19 = class36.method724(var34);
                                    var33 = var19 >> 11 & 63;
                                    var57[var93] = var33;
                                    continue;
                                 }

                                 if(var53 == 1801) {
                                    --var5;
                                    var35 = class32.field722[var5];
                                    --var35;
                                    if(null != var34.actions && var35 < var34.actions.length && null != var34.actions[var35]) {
                                       class32.chatboxSegments[var6++] = var34.actions[var35];
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var53 == 1802) {
                                    if(var34.name == null) {
                                       class32.chatboxSegments[var6++] = "";
                                    } else {
                                       class32.chatboxSegments[var6++] = var34.name;
                                    }
                                    continue;
                                 }
                              } else if(var53 >= 1900 && var53 < 2000 || var53 >= 2900 && var53 < 3000) {
                                 if(var53 >= 2000) {
                                    var53 -= 1000;
                                    --var5;
                                    var34 = class37.method736(class32.field722[var5]);
                                 } else {
                                    var34 = var70?class32.field726:class8.field76;
                                 }

                                 if(var53 == 1927) {
                                    if(class32.field729 >= 10) {
                                       throw new RuntimeException();
                                    }

                                    if(var34.field2305 == null) {
                                       return;
                                    }

                                    class18 var84 = new class18();
                                    var84.field180 = var34;
                                    var84.field188 = var34.field2305;
                                    var84.field185 = 1 + class32.field729;
                                    Client.field476.method2407(var0);
                                    continue;
                                 }
                              } else if(var53 < 2600) {
                                 --var5;
                                 var34 = class37.method736(class32.field722[var5]);
                                 if(var53 == 2500) {
                                    class32.field722[var5++] = var34.relativeX;
                                    continue;
                                 }

                                 if(var53 == 2501) {
                                    class32.field722[var5++] = var34.relativeY;
                                    continue;
                                 }

                                 if(var53 == 2502) {
                                    class32.field722[var5++] = var34.width;
                                    continue;
                                 }

                                 if(var53 == 2503) {
                                    class32.field722[var5++] = var34.height;
                                    continue;
                                 }

                                 if(var53 == 2504) {
                                    class32.field722[var5++] = var34.isHidden?1:0;
                                    continue;
                                 }

                                 if(var53 == 2505) {
                                    class32.field722[var5++] = var34.parentId;
                                    continue;
                                 }
                              } else if(var53 < 2700) {
                                 --var5;
                                 var34 = class37.method736(class32.field722[var5]);
                                 if(var53 == 2600) {
                                    class32.field722[var5++] = var34.scrollX;
                                    continue;
                                 }

                                 if(var53 == 2601) {
                                    class32.field722[var5++] = var34.scrollY;
                                    continue;
                                 }

                                 if(var53 == 2602) {
                                    class32.chatboxSegments[var6++] = var34.text;
                                    continue;
                                 }

                                 if(var53 == 2603) {
                                    class32.field722[var5++] = var34.scrollWidth;
                                    continue;
                                 }

                                 if(var53 == 2604) {
                                    class32.field722[var5++] = var34.scrollHeight;
                                    continue;
                                 }

                                 if(var53 == 2605) {
                                    class32.field722[var5++] = var34.field2250;
                                    continue;
                                 }

                                 if(var53 == 2606) {
                                    class32.field722[var5++] = var34.rotationX;
                                    continue;
                                 }

                                 if(var53 == 2607) {
                                    class32.field722[var5++] = var34.rotationY;
                                    continue;
                                 }

                                 if(var53 == 2608) {
                                    class32.field722[var5++] = var34.rotationZ;
                                    continue;
                                 }

                                 if(var53 == 2609) {
                                    class32.field722[var5++] = var34.opacity;
                                    continue;
                                 }

                                 if(var53 == 2610) {
                                    class32.field722[var5++] = var34.field2228;
                                    continue;
                                 }

                                 if(var53 == 2611) {
                                    class32.field722[var5++] = var34.textColor;
                                    continue;
                                 }

                                 if(var53 == 2612) {
                                    class32.field722[var5++] = var34.field2289;
                                    continue;
                                 }

                                 if(var53 == 2613) {
                                    class32.field722[var5++] = var34.field2226.vmethod4074();
                                    continue;
                                 }
                              } else if(var53 < 2800) {
                                 if(var53 == 2700) {
                                    --var5;
                                    var34 = class37.method736(class32.field722[var5]);
                                    class32.field722[var5++] = var34.item;
                                    continue;
                                 }

                                 if(var53 == 2701) {
                                    --var5;
                                    var34 = class37.method736(class32.field722[var5]);
                                    if(var34.item != -1) {
                                       class32.field722[var5++] = var34.stackSize;
                                    } else {
                                       class32.field722[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var53 == 2702) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    WidgetNode var58 = (WidgetNode)Client.componentTable.method2374((long)var15);
                                    if(null != var58) {
                                       class32.field722[var5++] = 1;
                                    } else {
                                       class32.field722[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var53 == 2706) {
                                    class32.field722[var5++] = Client.widgetRoot;
                                    continue;
                                 }
                              } else if(var53 < 2900) {
                                 --var5;
                                 var34 = class37.method736(class32.field722[var5]);
                                 if(var53 == 2800) {
                                    var57 = class32.field722;
                                    var93 = var5++;
                                    var19 = class36.method724(var34);
                                    var33 = var19 >> 11 & 63;
                                    var57[var93] = var33;
                                    continue;
                                 }

                                 if(var53 == 2801) {
                                    --var5;
                                    var35 = class32.field722[var5];
                                    --var35;
                                    if(null != var34.actions && var35 < var34.actions.length && var34.actions[var35] != null) {
                                       class32.chatboxSegments[var6++] = var34.actions[var35];
                                       continue;
                                    }

                                    class32.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var53 == 2802) {
                                    if(null == var34.name) {
                                       class32.chatboxSegments[var6++] = "";
                                    } else {
                                       class32.chatboxSegments[var6++] = var34.name;
                                    }
                                    continue;
                                 }
                              } else if(var53 < 3200) {
                                 if(var53 == 3100) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    class103.sendGameMessage(0, "", var106);
                                    continue;
                                 }

                                 if(var53 == 3101) {
                                    var5 -= 2;
                                    class175.method3242(class16.localPlayer, class32.field722[var5], class32.field722[1 + var5]);
                                    continue;
                                 }

                                 if(var53 == 3103) {
                                    Client.field394.method3037(181);

                                    for(WidgetNode var107 = (WidgetNode)Client.componentTable.method2361(); var107 != null; var107 = (WidgetNode)Client.componentTable.method2369()) {
                                       if(var107.field175 == 0 || var107.field175 == 3) {
                                          class9.method117(var107, true);
                                       }
                                    }

                                    if(null != Client.field441) {
                                       class33.method682(Client.field441);
                                       Client.field441 = null;
                                    }
                                    continue;
                                 }

                                 if(var53 == 3104) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    var35 = 0;
                                    if(class44.method803(var106)) {
                                       var35 = class205.method3806(var106);
                                    }

                                    Client.field394.method3037(228);
                                    Client.field394.method2802(var35);
                                    continue;
                                 }

                                 if(var53 == 3105) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    Client.field394.method3037(232);
                                    Client.field394.method2799(var106.length() + 1);
                                    Client.field394.method2805(var106);
                                    continue;
                                 }

                                 if(var53 == 3106) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    Client.field394.method3037(5);
                                    Client.field394.method2799(var106.length() + 1);
                                    Client.field394.method2805(var106);
                                    continue;
                                 }

                                 if(var53 == 3107) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    --var6;
                                    var62 = class32.chatboxSegments[var6];
                                    var93 = class45.field898;
                                    int[] var61 = class45.field895;
                                    boolean var64 = false;

                                    for(var20 = 0; var20 < var93; ++var20) {
                                       Player var38 = Client.cachedPlayers[var61[var20]];
                                       if(var38 != null && var38 != class16.localPlayer && null != var38.name && var38.name.equalsIgnoreCase(var62)) {
                                          if(var15 == 1) {
                                             Client.field394.method3037(64);
                                             Client.field394.method2870(var61[var20]);
                                             Client.field394.method2839(0);
                                          } else if(var15 == 4) {
                                             Client.field394.method3037(159);
                                             Client.field394.method2904(var61[var20]);
                                             Client.field394.method2838(0);
                                          } else if(var15 == 6) {
                                             Client.field394.method3037(247);
                                             Client.field394.method2839(0);
                                             Client.field394.method2837(var61[var20]);
                                          } else if(var15 == 7) {
                                             Client.field394.method3037(48);
                                             Client.field394.method2904(var61[var20]);
                                             Client.field394.method2799(0);
                                          }

                                          var64 = true;
                                          break;
                                       }
                                    }

                                    if(!var64) {
                                       class103.sendGameMessage(4, "", "Unable to find " + var62);
                                    }
                                    continue;
                                 }

                                 if(var53 == 3108) {
                                    var5 -= 3;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[1 + var5];
                                    var93 = class32.field722[2 + var5];
                                    var60 = class37.method736(var93);
                                    class119.method2299(var60, var15, var35);
                                    continue;
                                 }

                                 if(var53 == 3109) {
                                    var5 -= 2;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[1 + var5];
                                    var54 = var70?class32.field726:class8.field76;
                                    class119.method2299(var54, var15, var35);
                                    continue;
                                 }

                                 if(var53 == 3110) {
                                    --var5;
                                    class48.field937 = class32.field722[var5] == 1;
                                    continue;
                                 }

                                 if(var53 == 3111) {
                                    class32.field722[var5++] = class107.field1733.field685?1:0;
                                    continue;
                                 }

                                 if(var53 == 3112) {
                                    --var5;
                                    class107.field1733.field685 = class32.field722[var5] == 1;
                                    class85.method1694();
                                    continue;
                                 }

                                 if(var53 == 3113) {
                                    --var6;
                                    var106 = class32.chatboxSegments[var6];
                                    --var5;
                                    var96 = class32.field722[var5] == 1;
                                    NPC.method714(var106, var96, false);
                                    continue;
                                 }

                                 if(var53 == 3115) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    Client.field394.method3037(81);
                                    Client.field394.method2837(var15);
                                    continue;
                                 }

                                 if(var53 == 3116) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    var6 -= 2;
                                    var62 = class32.chatboxSegments[var6];
                                    var17 = class32.chatboxSegments[var6 + 1];
                                    if(var62.length() <= 500 && var17.length() <= 500) {
                                       Client.field394.method3037(105);
                                       Client.field394.method2837(1 + class37.method737(var62) + class37.method737(var17));
                                       Client.field394.method2799(var15);
                                       Client.field394.method2805(var62);
                                       Client.field394.method2805(var17);
                                    }
                                    continue;
                                 }
                              } else if(var53 < 3300) {
                                 if(var53 == 3200) {
                                    var5 -= 3;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[1 + var5];
                                    var93 = class32.field722[var5 + 2];
                                    if(Client.field517 != 0 && var35 != 0 && Client.field370 < 50) {
                                       Client.field520[Client.field370] = var15;
                                       Client.field521[Client.field370] = var35;
                                       Client.field522[Client.field370] = var93;
                                       Client.field302[Client.field370] = null;
                                       Client.field523[Client.field370] = 0;
                                       ++Client.field370;
                                    }
                                    continue;
                                 }

                                 if(var53 == 3201) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    if(var15 == -1 && !Client.field516) {
                                       class138.field1920.method2513();
                                       class138.field1921 = 1;
                                       Item.field887 = null;
                                    } else if(var15 != -1 && var15 != Client.field515 && Client.field536 != 0 && !Client.field516) {
                                       NPCComposition.method3725(2, class227.field3228, var15, 0, Client.field536, false);
                                    }

                                    Client.field515 = var15;
                                    continue;
                                 }

                                 if(var53 == 3202) {
                                    var5 -= 2;
                                    class31.method668(class32.field722[var5], class32.field722[1 + var5]);
                                    continue;
                                 }
                              } else if(var53 < 3400) {
                                 if(var53 == 3300) {
                                    class32.field722[var5++] = Client.gameCycle;
                                    continue;
                                 }

                                 if(var53 == 3301) {
                                    var5 -= 2;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[1 + var5];
                                    class32.field722[var5++] = XGrandExchangeOffer.method47(var15, var35);
                                    continue;
                                 }

                                 XItemContainer var39;
                                 if(var53 == 3302) {
                                    var5 -= 2;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[var5 + 1];
                                    var55 = class32.field722;
                                    var33 = var5++;
                                    var39 = (XItemContainer)itemContainers.method2374((long)var15);
                                    if(var39 == null) {
                                       var19 = 0;
                                    } else if(var35 >= 0 && var35 < var39.stackSizes.length) {
                                       var19 = var39.stackSizes[var35];
                                    } else {
                                       var19 = 0;
                                    }

                                    var55[var33] = var19;
                                    continue;
                                 }

                                 if(var53 == 3303) {
                                    var5 -= 2;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[var5 + 1];
                                    class32.field722[var5++] = class116.method2251(var15, var35);
                                    continue;
                                 }

                                 if(var53 == 3304) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = Widget.method3213(var15).field2765;
                                    continue;
                                 }

                                 if(var53 == 3305) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = Client.boostedSkillLevels[var15];
                                    continue;
                                 }

                                 if(var53 == 3306) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = Client.realSkillLevels[var15];
                                    continue;
                                 }

                                 if(var53 == 3307) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = Client.skillExperiences[var15];
                                    continue;
                                 }

                                 if(var53 == 3308) {
                                    var15 = WallObject.plane;
                                    var35 = (class16.localPlayer.x >> 7) + Projectile.baseX;
                                    var93 = class3.baseY + (class16.localPlayer.y >> 7);
                                    class32.field722[var5++] = (var15 << 28) + (var35 << 14) + var93;
                                    continue;
                                 }

                                 if(var53 == 3309) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = var15 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var53 == 3310) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = var15 >> 28;
                                    continue;
                                 }

                                 if(var53 == 3311) {
                                    --var5;
                                    var15 = class32.field722[var5];
                                    class32.field722[var5++] = var15 & 16383;
                                    continue;
                                 }

                                 if(var53 == 3312) {
                                    class32.field722[var5++] = Client.isMembers?1:0;
                                    continue;
                                 }

                                 if(var53 == 3313) {
                                    var5 -= 2;
                                    var15 = '耀' + class32.field722[var5];
                                    var35 = class32.field722[var5 + 1];
                                    class32.field722[var5++] = XGrandExchangeOffer.method47(var15, var35);
                                    continue;
                                 }

                                 if(var53 == 3314) {
                                    var5 -= 2;
                                    var15 = '耀' + class32.field722[var5];
                                    var35 = class32.field722[var5 + 1];
                                    var55 = class32.field722;
                                    var33 = var5++;
                                    var39 = (XItemContainer)itemContainers.method2374((long)var15);
                                    if(null == var39) {
                                       var19 = 0;
                                    } else if(var35 >= 0 && var35 < var39.stackSizes.length) {
                                       var19 = var39.stackSizes[var35];
                                    } else {
                                       var19 = 0;
                                    }

                                    var55[var33] = var19;
                                    continue;
                                 }

                                 if(var53 == 3315) {
                                    var5 -= 2;
                                    var15 = class32.field722[var5] + '耀';
                                    var35 = class32.field722[var5 + 1];
                                    class32.field722[var5++] = class116.method2251(var15, var35);
                                    continue;
                                 }

                                 if(var53 == 3316) {
                                    if(Client.field327 >= 2) {
                                       class32.field722[var5++] = Client.field327;
                                    } else {
                                       class32.field722[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var53 == 3317) {
                                    class32.field722[var5++] = Client.field295;
                                    continue;
                                 }

                                 if(var53 == 3318) {
                                    class32.field722[var5++] = Client.world;
                                    continue;
                                 }

                                 if(var53 == 3321) {
                                    class32.field722[var5++] = Client.energy;
                                    continue;
                                 }

                                 if(var53 == 3322) {
                                    class32.field722[var5++] = Client.weight;
                                    continue;
                                 }

                                 if(var53 == 3323) {
                                    if(Client.field446) {
                                       class32.field722[var5++] = 1;
                                    } else {
                                       class32.field722[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var53 == 3324) {
                                    class32.field722[var5++] = Client.flags;
                                    continue;
                                 }
                              } else if(var53 < 3500) {
                                 if(var53 == 3400) {
                                    var5 -= 2;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[1 + var5];
                                    class195 var59 = class177.method3253(var15);
                                    if(var59.field2851 != 115) {
                                       ;
                                    }

                                    for(var33 = 0; var33 < var59.field2854; ++var33) {
                                       if(var35 == var59.field2855[var33]) {
                                          class32.chatboxSegments[var6++] = var59.field2852[var33];
                                          var59 = null;
                                          break;
                                       }
                                    }

                                    if(var59 != null) {
                                       class32.chatboxSegments[var6++] = var59.field2858;
                                    }
                                    continue;
                                 }

                                 if(var53 == 3408) {
                                    var5 -= 4;
                                    var15 = class32.field722[var5];
                                    var35 = class32.field722[1 + var5];
                                    var93 = class32.field722[var5 + 2];
                                    var33 = class32.field722[3 + var5];
                                    class195 var37 = class177.method3253(var93);
                                    if(var15 == var37.field2850 && var37.field2851 == var35) {
                                       for(var20 = 0; var20 < var37.field2854; ++var20) {
                                          if(var33 == var37.field2855[var20]) {
                                             if(var35 == 115) {
                                                class32.chatboxSegments[var6++] = var37.field2852[var20];
                                             } else {
                                                class32.field722[var5++] = var37.field2856[var20];
                                             }

                                             var37 = null;
                                             break;
                                          }
                                       }

                                       if(null != var37) {
                                          if(var35 == 115) {
                                             class32.chatboxSegments[var6++] = var37.field2858;
                                          } else {
                                             class32.field722[var5++] = var37.field2853;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var35 == 115) {
                                       class32.chatboxSegments[var6++] = "null";
                                    } else {
                                       class32.field722[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else {
                                 String var95;
                                 String var100;
                                 if(var53 < 3700) {
                                    if(var53 == 3600) {
                                       if(Client.field545 == 0) {
                                          class32.field722[var5++] = -2;
                                       } else if(Client.field545 == 1) {
                                          class32.field722[var5++] = -1;
                                       } else {
                                          class32.field722[var5++] = Client.friendCount;
                                       }
                                       continue;
                                    }

                                    if(var53 == 3601) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(Client.field545 == 2 && var15 < Client.friendCount) {
                                          class32.chatboxSegments[var6++] = Client.friends[var15].name;
                                          class32.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var53 == 3602) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(Client.field545 == 2 && var15 < Client.friendCount) {
                                          class32.field722[var5++] = Client.friends[var15].world;
                                          continue;
                                       }

                                       class32.field722[var5++] = 0;
                                       continue;
                                    }

                                    if(var53 == 3603) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(Client.field545 == 2 && var15 < Client.friendCount) {
                                          class32.field722[var5++] = Client.friends[var15].rank;
                                          continue;
                                       }

                                       class32.field722[var5++] = 0;
                                       continue;
                                    }

                                    if(var53 == 3604) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       --var5;
                                       var35 = class32.field722[var5];
                                       class107.method2037(var106, var35);
                                       continue;
                                    }

                                    if(var53 == 3605) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       Sequence.method3768(var106);
                                       continue;
                                    }

                                    if(var53 == 3606) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       if(null == var106) {
                                          continue;
                                       }

                                       var62 = FrameMap.method1697(var106, FaceNormal.field1561);
                                       if(null == var62) {
                                          continue;
                                       }

                                       var93 = 0;

                                       while(true) {
                                          if(var93 >= Client.friendCount) {
                                             continue label3607;
                                          }

                                          Friend var66 = Client.friends[var93];
                                          var95 = var66.name;
                                          var100 = FrameMap.method1697(var95, FaceNormal.field1561);
                                          if(FileOnDisk.method1429(var106, var62, var95, var100)) {
                                             --Client.friendCount;

                                             for(var21 = var93; var21 < Client.friendCount; ++var21) {
                                                Client.friends[var21] = Client.friends[var21 + 1];
                                             }

                                             Client.field416 = Client.field462;
                                             Client.field394.method3037(0);
                                             Client.field394.method2799(class37.method737(var106));
                                             Client.field394.method2805(var106);
                                             continue label3607;
                                          }

                                          ++var93;
                                       }
                                    }

                                    if(var53 == 3607) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       CollisionData.method2284(var106, false);
                                       continue;
                                    }

                                    if(var53 == 3608) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       class167.method3165(var106);
                                       continue;
                                    }

                                    if(var53 == 3609) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       class177[] var68 = CombatInfoListHolder.method696();

                                       for(var93 = 0; var93 < var68.length; ++var93) {
                                          class177 var63 = var68[var93];
                                          if(var63.field2663 != -1 && var106.startsWith(class167.method3163(var63.field2663))) {
                                             var106 = var106.substring(6 + Integer.toString(var63.field2663).length());
                                             break;
                                          }
                                       }

                                       class32.field722[var5++] = GameEngine.method2194(var106, false)?1:0;
                                       continue;
                                    }

                                    if(var53 == 3611) {
                                       if(Client.field504 != null) {
                                          class32.chatboxSegments[var6++] = Varbit.method3535(Client.field504);
                                       } else {
                                          class32.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var53 == 3612) {
                                       if(null != Client.field504) {
                                          class32.field722[var5++] = class10.clanChatCount;
                                       } else {
                                          class32.field722[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var53 == 3613) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(Client.field504 != null && var15 < class10.clanChatCount) {
                                          class32.chatboxSegments[var6++] = Renderable.clanMembers[var15].username;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var53 == 3614) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(null != Client.field504 && var15 < class10.clanChatCount) {
                                          class32.field722[var5++] = Renderable.clanMembers[var15].world;
                                          continue;
                                       }

                                       class32.field722[var5++] = 0;
                                       continue;
                                    }

                                    if(var53 == 3615) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(null != Client.field504 && var15 < class10.clanChatCount) {
                                          class32.field722[var5++] = Renderable.clanMembers[var15].rank;
                                          continue;
                                       }

                                       class32.field722[var5++] = 0;
                                       continue;
                                    }

                                    if(var53 == 3616) {
                                       class32.field722[var5++] = Friend.field149;
                                       continue;
                                    }

                                    if(var53 == 3617) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       class39.method739(var106);
                                       continue;
                                    }

                                    if(var53 == 3618) {
                                       class32.field722[var5++] = class109.field1742;
                                       continue;
                                    }

                                    if(var53 == 3619) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       if(!var106.equals("")) {
                                          Client.field394.method3037(111);
                                          Client.field394.method2799(class37.method737(var106));
                                          Client.field394.method2805(var106);
                                       }
                                       continue;
                                    }

                                    if(var53 == 3620) {
                                       class85.method1690();
                                       continue;
                                    }

                                    if(var53 == 3621) {
                                       if(Client.field545 == 0) {
                                          class32.field722[var5++] = -1;
                                       } else {
                                          class32.field722[var5++] = Client.ignoreCount;
                                       }
                                       continue;
                                    }

                                    if(var53 == 3622) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(Client.field545 != 0 && var15 < Client.ignoreCount) {
                                          class32.chatboxSegments[var6++] = Client.ignores[var15].name;
                                          class32.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var53 == 3623) {
                                       --var6;
                                       var106 = class32.chatboxSegments[var6];
                                       if(var106.startsWith(class167.method3163(0)) || var106.startsWith(class167.method3163(1))) {
                                          var106 = var106.substring(7);
                                       }

                                       class32.field722[var5++] = class170.method3237(var106)?1:0;
                                       continue;
                                    }

                                    if(var53 == 3624) {
                                       --var5;
                                       var15 = class32.field722[var5];
                                       if(Renderable.clanMembers != null && var15 < class10.clanChatCount && Renderable.clanMembers[var15].username.equalsIgnoreCase(class16.localPlayer.name)) {
                                          class32.field722[var5++] = 1;
                                          continue;
                                       }

                                       class32.field722[var5++] = 0;
                                       continue;
                                    }

                                    if(var53 == 3625) {
                                       if(Client.clanChatOwner != null) {
                                          class32.chatboxSegments[var6++] = Varbit.method3535(Client.clanChatOwner);
                                       } else {
                                          class32.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }
                                 } else {
                                    long var40;
                                    if(var53 < 4000) {
                                       if(var53 == 3903) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = Client.grandExchangeOffers[var15].method48();
                                          continue;
                                       }

                                       if(var53 == 3904) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = Client.grandExchangeOffers[var15].itemId;
                                          continue;
                                       }

                                       if(var53 == 3905) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = Client.grandExchangeOffers[var15].price;
                                          continue;
                                       }

                                       if(var53 == 3906) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                          continue;
                                       }

                                       if(var53 == 3907) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                          continue;
                                       }

                                       if(var53 == 3908) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = Client.grandExchangeOffers[var15].spent;
                                          continue;
                                       }

                                       if(var53 == 3910) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var35 = Client.grandExchangeOffers[var15].method45();
                                          class32.field722[var5++] = var35 == 0?1:0;
                                          continue;
                                       }

                                       if(var53 == 3911) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var35 = Client.grandExchangeOffers[var15].method45();
                                          class32.field722[var5++] = var35 == 2?1:0;
                                          continue;
                                       }

                                       if(var53 == 3912) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var35 = Client.grandExchangeOffers[var15].method45();
                                          class32.field722[var5++] = var35 == 5?1:0;
                                          continue;
                                       }

                                       if(var53 == 3913) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var35 = Client.grandExchangeOffers[var15].method45();
                                          class32.field722[var5++] = var35 == 1?1:0;
                                          continue;
                                       }

                                       boolean var87;
                                       if(var53 == 3914) {
                                          --var5;
                                          var87 = class32.field722[var5] == 1;
                                          if(null != class168.field2184) {
                                             class168.field2184.method16(class1.field9, var87);
                                          }
                                          continue;
                                       }

                                       if(var53 == 3915) {
                                          --var5;
                                          var87 = class32.field722[var5] == 1;
                                          if(class168.field2184 != null) {
                                             class168.field2184.method16(class1.field8, var87);
                                          }
                                          continue;
                                       }

                                       if(var53 == 3916) {
                                          var5 -= 2;
                                          var87 = class32.field722[var5] == 1;
                                          var96 = class32.field722[1 + var5] == 1;
                                          if(class168.field2184 != null) {
                                             class168.field2184.method16(new class44(var96), var87);
                                          }
                                          continue;
                                       }

                                       if(var53 == 3917) {
                                          --var5;
                                          var87 = class32.field722[var5] == 1;
                                          if(null != class168.field2184) {
                                             class168.field2184.method16(class1.field13, var87);
                                          }
                                          continue;
                                       }

                                       if(var53 == 3918) {
                                          --var5;
                                          var87 = class32.field722[var5] == 1;
                                          if(null != class168.field2184) {
                                             class168.field2184.method16(class1.field10, var87);
                                          }
                                          continue;
                                       }

                                       if(var53 == 3919) {
                                          class32.field722[var5++] = class168.field2184 == null?0:class168.field2184.field11.size();
                                          continue;
                                       }

                                       class2 var72;
                                       if(var53 == 3920) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          class32.field722[var5++] = var72.field24;
                                          continue;
                                       }

                                       if(var53 == 3921) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          class32.chatboxSegments[var6++] = var72.method29();
                                          continue;
                                       }

                                       if(var53 == 3922) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          class32.chatboxSegments[var6++] = var72.method31();
                                          continue;
                                       }

                                       if(var53 == 3923) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          var40 = FrameMap.method1695() - class15.field158 - var72.field17;
                                          var19 = (int)(var40 / 3600000L);
                                          var20 = (int)((var40 - (long)(3600000 * var19)) / 60000L);
                                          var21 = (int)((var40 - (long)(var19 * 3600000) - (long)('\uea60' * var20)) / 1000L);
                                          String var22 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                          class32.chatboxSegments[var6++] = var22;
                                          continue;
                                       }

                                       if(var53 == 3924) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          class32.field722[var5++] = var72.field18.totalQuantity;
                                          continue;
                                       }

                                       if(var53 == 3925) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          class32.field722[var5++] = var72.field18.price;
                                          continue;
                                       }

                                       if(var53 == 3926) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          var72 = (class2)class168.field2184.field11.get(var15);
                                          class32.field722[var5++] = var72.field18.itemId;
                                          continue;
                                       }
                                    } else if(var53 < 4100) {
                                       if(var53 == 4000) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[1 + var5];
                                          class32.field722[var5++] = var15 + var35;
                                          continue;
                                       }

                                       if(var53 == 4001) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = var15 - var35;
                                          continue;
                                       }

                                       if(var53 == 4002) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = var15 * var35;
                                          continue;
                                       }

                                       if(var53 == 4003) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[1 + var5];
                                          class32.field722[var5++] = var15 / var35;
                                          continue;
                                       }

                                       if(var53 == 4004) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = (int)(Math.random() * (double)var15);
                                          continue;
                                       }

                                       if(var53 == 4005) {
                                          --var5;
                                          var15 = class32.field722[var5];
                                          class32.field722[var5++] = (int)(Math.random() * (double)(1 + var15));
                                          continue;
                                       }

                                       if(var53 == 4006) {
                                          var5 -= 5;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          var93 = class32.field722[var5 + 2];
                                          var33 = class32.field722[3 + var5];
                                          var19 = class32.field722[4 + var5];
                                          class32.field722[var5++] = var15 + (var35 - var15) * (var19 - var93) / (var33 - var93);
                                          continue;
                                       }

                                       if(var53 == 4007) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = var35 * var15 / 100 + var15;
                                          continue;
                                       }

                                       if(var53 == 4008) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = var15 | 1 << var35;
                                          continue;
                                       }

                                       if(var53 == 4009) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[1 + var5];
                                          class32.field722[var5++] = var15 & -1 - (1 << var35);
                                          continue;
                                       }

                                       if(var53 == 4010) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = (var15 & 1 << var35) != 0?1:0;
                                          continue;
                                       }

                                       if(var53 == 4011) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[1 + var5];
                                          class32.field722[var5++] = var15 % var35;
                                          continue;
                                       }

                                       if(var53 == 4012) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          if(var15 == 0) {
                                             class32.field722[var5++] = 0;
                                          } else {
                                             class32.field722[var5++] = (int)Math.pow((double)var15, (double)var35);
                                          }
                                          continue;
                                       }

                                       if(var53 == 4013) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[1 + var5];
                                          if(var15 == 0) {
                                             class32.field722[var5++] = 0;
                                          } else if(var35 == 0) {
                                             class32.field722[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class32.field722[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var35);
                                          }
                                          continue;
                                       }

                                       if(var53 == 4014) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = var15 & var35;
                                          continue;
                                       }

                                       if(var53 == 4015) {
                                          var5 -= 2;
                                          var15 = class32.field722[var5];
                                          var35 = class32.field722[var5 + 1];
                                          class32.field722[var5++] = var15 | var35;
                                          continue;
                                       }

                                       if(var53 == 4018) {
                                          var5 -= 3;
                                          long var42 = (long)class32.field722[var5];
                                          var40 = (long)class32.field722[1 + var5];
                                          long var44 = (long)class32.field722[2 + var5];
                                          class32.field722[var5++] = (int)(var44 * var42 / var40);
                                          continue;
                                       }
                                    } else {
                                       int var48;
                                       if(var53 < 4200) {
                                          if(var53 == 4100) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field722[var5];
                                             class32.chatboxSegments[var6++] = var106 + var35;
                                             continue;
                                          }

                                          if(var53 == 4101) {
                                             var6 -= 2;
                                             var106 = class32.chatboxSegments[var6];
                                             var62 = class32.chatboxSegments[1 + var6];
                                             class32.chatboxSegments[var6++] = var106 + var62;
                                             continue;
                                          }

                                          if(var53 == 4102) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field722[var5];
                                             var65 = class32.chatboxSegments;
                                             var33 = var6++;
                                             if(var35 < 0) {
                                                var100 = Integer.toString(var35);
                                             } else {
                                                var100 = class148.method2781(var35, 10, true);
                                             }

                                             var65[var33] = var106 + var100;
                                             continue;
                                          }

                                          if(var53 == 4103) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = var106.toLowerCase();
                                             continue;
                                          }

                                          if(var53 == 4104) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             long var46 = ((long)var15 + 11745L) * 86400000L;
                                             class32.field727.setTime(new Date(var46));
                                             var33 = class32.field727.get(5);
                                             var19 = class32.field727.get(2);
                                             var20 = class32.field727.get(1);
                                             class32.chatboxSegments[var6++] = var33 + "-" + class32.field728[var19] + "-" + var20;
                                             continue;
                                          }

                                          if(var53 == 4105) {
                                             var6 -= 2;
                                             var106 = class32.chatboxSegments[var6];
                                             var62 = class32.chatboxSegments[1 + var6];
                                             if(null != class16.localPlayer.composition && class16.localPlayer.composition.isFemale) {
                                                class32.chatboxSegments[var6++] = var62;
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = var106;
                                             continue;
                                          }

                                          if(var53 == 4106) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.chatboxSegments[var6++] = Integer.toString(var15);
                                             continue;
                                          }

                                          if(var53 == 4107) {
                                             var6 -= 2;
                                             var108 = class32.field722;
                                             var35 = var5++;
                                             String var71 = class32.chatboxSegments[var6];
                                             var95 = class32.chatboxSegments[var6 + 1];
                                             var20 = Client.field353;
                                             var21 = var71.length();
                                             var48 = var95.length();
                                             int var23 = 0;
                                             int var24 = 0;
                                             char var25 = 0;
                                             char var26 = 0;

                                             label3410:
                                             while(true) {
                                                if(var23 - var25 >= var21 && var24 - var26 >= var48) {
                                                   int var85 = Math.min(var21, var48);

                                                   char var30;
                                                   int var88;
                                                   for(var88 = 0; var88 < var85; ++var88) {
                                                      char var29 = var71.charAt(var88);
                                                      var30 = var95.charAt(var88);
                                                      if(var30 != var29 && Character.toUpperCase(var29) != Character.toUpperCase(var30)) {
                                                         var29 = Character.toLowerCase(var29);
                                                         var30 = Character.toLowerCase(var30);
                                                         if(var29 != var30) {
                                                            var93 = class214.method3963(var29, var20) - class214.method3963(var30, var20);
                                                            break label3410;
                                                         }
                                                      }
                                                   }

                                                   var88 = var21 - var48;
                                                   if(var88 != 0) {
                                                      var93 = var88;
                                                   } else {
                                                      for(int var89 = 0; var89 < var85; ++var89) {
                                                         var30 = var71.charAt(var89);
                                                         char var31 = var95.charAt(var89);
                                                         if(var31 != var30) {
                                                            var93 = class214.method3963(var30, var20) - class214.method3963(var31, var20);
                                                            break label3410;
                                                         }
                                                      }

                                                      var93 = 0;
                                                   }
                                                   break;
                                                }

                                                if(var23 - var25 >= var21) {
                                                   var93 = -1;
                                                   break;
                                                }

                                                if(var24 - var26 >= var48) {
                                                   var93 = 1;
                                                   break;
                                                }

                                                char var27;
                                                if(var25 != 0) {
                                                   var27 = var25;
                                                   boolean var80 = false;
                                                } else {
                                                   var27 = var71.charAt(var23++);
                                                }

                                                char var28;
                                                if(var26 != 0) {
                                                   var28 = var26;
                                                   boolean var82 = false;
                                                } else {
                                                   var28 = var95.charAt(var24++);
                                                }

                                                var25 = WidgetNode.method189(var27);
                                                var26 = WidgetNode.method189(var28);
                                                var27 = NPC.method706(var27, var20);
                                                var28 = NPC.method706(var28, var20);
                                                if(var27 != var28 && Character.toUpperCase(var27) != Character.toUpperCase(var28)) {
                                                   var27 = Character.toLowerCase(var27);
                                                   var28 = Character.toLowerCase(var28);
                                                   if(var27 != var28) {
                                                      var93 = class214.method3963(var27, var20) - class214.method3963(var28, var20);
                                                      break;
                                                   }
                                                }
                                             }

                                             var108[var35] = class3.method43(var93);
                                             continue;
                                          }

                                          Font var97;
                                          if(var53 == 4108) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field722[var5];
                                             var93 = class32.field722[1 + var5];
                                             var69 = class99.field1649.getConfigData(var93, 0);
                                             var97 = new Font(var69);
                                             class32.field722[var5++] = var97.method3873(var106, var35);
                                             continue;
                                          }

                                          if(var53 == 4109) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field722[var5];
                                             var93 = class32.field722[var5 + 1];
                                             var69 = class99.field1649.getConfigData(var93, 0);
                                             var97 = new Font(var69);
                                             class32.field722[var5++] = var97.method3872(var106, var35);
                                             continue;
                                          }

                                          if(var53 == 4110) {
                                             var6 -= 2;
                                             var106 = class32.chatboxSegments[var6];
                                             var62 = class32.chatboxSegments[var6 + 1];
                                             --var5;
                                             if(class32.field722[var5] == 1) {
                                                class32.chatboxSegments[var6++] = var106;
                                             } else {
                                                class32.chatboxSegments[var6++] = var62;
                                             }
                                             continue;
                                          }

                                          if(var53 == 4111) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             class32.chatboxSegments[var6++] = FontTypeFace.method3919(var106);
                                             continue;
                                          }

                                          if(var53 == 4112) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field722[var5];
                                             class32.chatboxSegments[var6++] = var106 + (char)var35;
                                             continue;
                                          }

                                          char var78;
                                          if(var53 == 4113) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var57 = class32.field722;
                                             var93 = var5++;
                                             var78 = (char)var15;
                                             if(var78 >= 32 && var78 <= 126) {
                                                var94 = true;
                                             } else if(var78 >= 160 && var78 <= 255) {
                                                var94 = true;
                                             } else if(var78 != 8364 && var78 != 338 && var78 != 8212 && var78 != 339 && var78 != 376) {
                                                var94 = false;
                                             } else {
                                                var94 = true;
                                             }

                                             var57[var93] = var94?1:0;
                                             continue;
                                          }

                                          if(var53 == 4114) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.field722[var5++] = Player.method223((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var53 == 4115) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var57 = class32.field722;
                                             var93 = var5++;
                                             var78 = (char)var15;
                                             var94 = var78 >= 65 && var78 <= 90 || var78 >= 97 && var78 <= 122;
                                             var57[var93] = var94?1:0;
                                             continue;
                                          }

                                          if(var53 == 4116) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.field722[var5++] = Tile.method1551((char)var15)?1:0;
                                             continue;
                                          }

                                          if(var53 == 4117) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             if(null != var106) {
                                                class32.field722[var5++] = var106.length();
                                             } else {
                                                class32.field722[var5++] = 0;
                                             }
                                             continue;
                                          }

                                          if(var53 == 4118) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field722[var5];
                                             var93 = class32.field722[1 + var5];
                                             class32.chatboxSegments[var6++] = var106.substring(var35, var93);
                                             continue;
                                          }

                                          if(var53 == 4119) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             StringBuilder var76 = new StringBuilder(var106.length());
                                             var36 = false;

                                             for(var33 = 0; var33 < var106.length(); ++var33) {
                                                var78 = var106.charAt(var33);
                                                if(var78 == 60) {
                                                   var36 = true;
                                                } else if(var78 == 62) {
                                                   var36 = false;
                                                } else if(!var36) {
                                                   var76.append(var78);
                                                }
                                             }

                                             class32.chatboxSegments[var6++] = var76.toString();
                                             continue;
                                          }

                                          if(var53 == 4120) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field722[var5];
                                             class32.field722[var5++] = var106.indexOf(var35);
                                             continue;
                                          }

                                          if(var53 == 4121) {
                                             var6 -= 2;
                                             var106 = class32.chatboxSegments[var6];
                                             var62 = class32.chatboxSegments[var6 + 1];
                                             --var5;
                                             var93 = class32.field722[var5];
                                             class32.field722[var5++] = var106.indexOf(var62, var93);
                                             continue;
                                          }
                                       } else if(var53 < 4300) {
                                          if(var53 == 4200) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.chatboxSegments[var6++] = class36.getItemDefinition(var15).name;
                                             continue;
                                          }

                                          ItemComposition var67;
                                          if(var53 == 4201) {
                                             var5 -= 2;
                                             var15 = class32.field722[var5];
                                             var35 = class32.field722[1 + var5];
                                             var67 = class36.getItemDefinition(var15);
                                             if(var35 >= 1 && var35 <= 5 && null != var67.groundActions[var35 - 1]) {
                                                class32.chatboxSegments[var6++] = var67.groundActions[var35 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var53 == 4202) {
                                             var5 -= 2;
                                             var15 = class32.field722[var5];
                                             var35 = class32.field722[var5 + 1];
                                             var67 = class36.getItemDefinition(var15);
                                             if(var35 >= 1 && var35 <= 5 && null != var67.inventoryActions[var35 - 1]) {
                                                class32.chatboxSegments[var6++] = var67.inventoryActions[var35 - 1];
                                                continue;
                                             }

                                             class32.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          if(var53 == 4203) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.field722[var5++] = class36.getItemDefinition(var15).price;
                                             continue;
                                          }

                                          if(var53 == 4204) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.field722[var5++] = class36.getItemDefinition(var15).isStackable == 1?1:0;
                                             continue;
                                          }

                                          ItemComposition var79;
                                          if(var53 == 4205) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var79 = class36.getItemDefinition(var15);
                                             if(var79.notedTemplate == -1 && var79.note >= 0) {
                                                class32.field722[var5++] = var79.note;
                                                continue;
                                             }

                                             class32.field722[var5++] = var15;
                                             continue;
                                          }

                                          if(var53 == 4206) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var79 = class36.getItemDefinition(var15);
                                             if(var79.notedTemplate >= 0 && var79.note >= 0) {
                                                class32.field722[var5++] = var79.note;
                                                continue;
                                             }

                                             class32.field722[var5++] = var15;
                                             continue;
                                          }

                                          if(var53 == 4207) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.field722[var5++] = class36.getItemDefinition(var15).isMembers?1:0;
                                             continue;
                                          }

                                          if(var53 == 4208) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var79 = class36.getItemDefinition(var15);
                                             if(var79.field2991 == -1 && var79.field2990 >= 0) {
                                                class32.field722[var5++] = var79.field2990;
                                                continue;
                                             }

                                             class32.field722[var5++] = var15;
                                             continue;
                                          }

                                          if(var53 == 4209) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var79 = class36.getItemDefinition(var15);
                                             if(var79.field2991 >= 0 && var79.field2990 >= 0) {
                                                class32.field722[var5++] = var79.field2990;
                                                continue;
                                             }

                                             class32.field722[var5++] = var15;
                                             continue;
                                          }

                                          if(var53 == 4210) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field722[var5];
                                             class139.method2597(var106, var35 == 1);
                                             class32.field722[var5++] = class118.field1854;
                                             continue;
                                          }

                                          if(var53 == 4211) {
                                             if(class115.field1815 != null && class48.field945 < class118.field1854) {
                                                class32.field722[var5++] = class115.field1815[++class48.field945 - 1] & '\uffff';
                                                continue;
                                             }

                                             class32.field722[var5++] = -1;
                                             continue;
                                          }

                                          if(var53 == 4212) {
                                             class48.field945 = 0;
                                             continue;
                                          }
                                       } else if(var53 < 5100) {
                                          if(var53 == 5000) {
                                             class32.field722[var5++] = Client.field495;
                                             continue;
                                          }

                                          if(var53 == 5001) {
                                             var5 -= 3;
                                             Client.field495 = class32.field722[var5];
                                             CombatInfo1.field662 = class202.method3785(class32.field722[1 + var5]);
                                             if(CombatInfo1.field662 == null) {
                                                CombatInfo1.field662 = class216.field3164;
                                             }

                                             Client.field514 = class32.field722[var5 + 2];
                                             Client.field394.method3037(126);
                                             Client.field394.method2799(Client.field495);
                                             Client.field394.method2799(CombatInfo1.field662.field3166);
                                             Client.field394.method2799(Client.field514);
                                             continue;
                                          }

                                          if(var53 == 5002) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             var5 -= 2;
                                             var35 = class32.field722[var5];
                                             var93 = class32.field722[var5 + 1];
                                             Client.field394.method3037(1);
                                             Client.field394.method2799(class37.method737(var106) + 2);
                                             Client.field394.method2805(var106);
                                             Client.field394.method2799(var35 - 1);
                                             Client.field394.method2799(var93);
                                             continue;
                                          }

                                          if(var53 == 5003) {
                                             var5 -= 2;
                                             var15 = class32.field722[var5];
                                             var35 = class32.field722[1 + var5];
                                             MessageNode var75 = class112.method2098(var15, var35);
                                             if(var75 != null) {
                                                class32.field722[var5++] = var75.id;
                                                class32.field722[var5++] = var75.tick;
                                                class32.chatboxSegments[var6++] = null != var75.name?var75.name:"";
                                                class32.chatboxSegments[var6++] = null != var75.sender?var75.sender:"";
                                                class32.chatboxSegments[var6++] = null != var75.value?var75.value:"";
                                             } else {
                                                class32.field722[var5++] = -1;
                                                class32.field722[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var53 == 5004) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             MessageNode var83 = (MessageNode)class47.field928.method2318((long)var15);
                                             if(var83 != null) {
                                                class32.field722[var5++] = var83.type;
                                                class32.field722[var5++] = var83.tick;
                                                class32.chatboxSegments[var6++] = null != var83.name?var83.name:"";
                                                class32.chatboxSegments[var6++] = var83.sender != null?var83.sender:"";
                                                class32.chatboxSegments[var6++] = null != var83.value?var83.value:"";
                                             } else {
                                                class32.field722[var5++] = -1;
                                                class32.field722[var5++] = 0;
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                                class32.chatboxSegments[var6++] = "";
                                             }
                                             continue;
                                          }

                                          if(var53 == 5005) {
                                             if(CombatInfo1.field662 == null) {
                                                class32.field722[var5++] = -1;
                                             } else {
                                                class32.field722[var5++] = CombatInfo1.field662.field3166;
                                             }
                                             continue;
                                          }

                                          if(var53 == 5008) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             --var5;
                                             var35 = class32.field722[var5];
                                             var17 = var106.toLowerCase();
                                             byte var104 = 0;
                                             if(var17.startsWith("yellow:")) {
                                                var104 = 0;
                                                var106 = var106.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var104 = 1;
                                                var106 = var106.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var104 = 2;
                                                var106 = var106.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var104 = 3;
                                                var106 = var106.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var104 = 4;
                                                var106 = var106.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var104 = 5;
                                                var106 = var106.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var104 = 6;
                                                var106 = var106.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var104 = 7;
                                                var106 = var106.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var104 = 8;
                                                var106 = var106.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var104 = 9;
                                                var106 = var106.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var104 = 10;
                                                var106 = var106.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var104 = 11;
                                                var106 = var106.substring("glow3:".length());
                                             } else if(Client.field353 != 0) {
                                                if(var17.startsWith("yellow:")) {
                                                   var104 = 0;
                                                   var106 = var106.substring("yellow:".length());
                                                } else if(var17.startsWith("red:")) {
                                                   var104 = 1;
                                                   var106 = var106.substring("red:".length());
                                                } else if(var17.startsWith("green:")) {
                                                   var104 = 2;
                                                   var106 = var106.substring("green:".length());
                                                } else if(var17.startsWith("cyan:")) {
                                                   var104 = 3;
                                                   var106 = var106.substring("cyan:".length());
                                                } else if(var17.startsWith("purple:")) {
                                                   var104 = 4;
                                                   var106 = var106.substring("purple:".length());
                                                } else if(var17.startsWith("white:")) {
                                                   var104 = 5;
                                                   var106 = var106.substring("white:".length());
                                                } else if(var17.startsWith("flash1:")) {
                                                   var104 = 6;
                                                   var106 = var106.substring("flash1:".length());
                                                } else if(var17.startsWith("flash2:")) {
                                                   var104 = 7;
                                                   var106 = var106.substring("flash2:".length());
                                                } else if(var17.startsWith("flash3:")) {
                                                   var104 = 8;
                                                   var106 = var106.substring("flash3:".length());
                                                } else if(var17.startsWith("glow1:")) {
                                                   var104 = 9;
                                                   var106 = var106.substring("glow1:".length());
                                                } else if(var17.startsWith("glow2:")) {
                                                   var104 = 10;
                                                   var106 = var106.substring("glow2:".length());
                                                } else if(var17.startsWith("glow3:")) {
                                                   var104 = 11;
                                                   var106 = var106.substring("glow3:".length());
                                                }
                                             }

                                             var17 = var106.toLowerCase();
                                             byte var81 = 0;
                                             if(var17.startsWith("wave:")) {
                                                var81 = 1;
                                                var106 = var106.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var81 = 2;
                                                var106 = var106.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var81 = 3;
                                                var106 = var106.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var81 = 4;
                                                var106 = var106.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var81 = 5;
                                                var106 = var106.substring("slide:".length());
                                             } else if(Client.field353 != 0) {
                                                if(var17.startsWith("wave:")) {
                                                   var81 = 1;
                                                   var106 = var106.substring("wave:".length());
                                                } else if(var17.startsWith("wave2:")) {
                                                   var81 = 2;
                                                   var106 = var106.substring("wave2:".length());
                                                } else if(var17.startsWith("shake:")) {
                                                   var81 = 3;
                                                   var106 = var106.substring("shake:".length());
                                                } else if(var17.startsWith("scroll:")) {
                                                   var81 = 4;
                                                   var106 = var106.substring("scroll:".length());
                                                } else if(var17.startsWith("slide:")) {
                                                   var81 = 5;
                                                   var106 = var106.substring("slide:".length());
                                                }
                                             }

                                             Client.field394.method3037(122);
                                             Client.field394.method2799(0);
                                             var20 = Client.field394.offset;
                                             Client.field394.method2799(var35);
                                             Client.field394.method2799(var104);
                                             Client.field394.method2799(var81);
                                             class159 var98 = Client.field394;
                                             var48 = var98.offset;
                                             byte[] var49 = class33.method676(var106);
                                             var98.method2927(var49.length);
                                             var98.offset += class210.field3117.method2741(var49, 0, var49.length, var98.payload, var98.offset);
                                             Client.field394.method2811(Client.field394.offset - var20);
                                             continue;
                                          }

                                          if(var53 == 5009) {
                                             var6 -= 2;
                                             var106 = class32.chatboxSegments[var6];
                                             var62 = class32.chatboxSegments[1 + var6];
                                             Client.field394.method3037(50);
                                             Client.field394.method2837(0);
                                             var93 = Client.field394.offset;
                                             Client.field394.method2805(var106);
                                             class159 var73 = Client.field394;
                                             var19 = var73.offset;
                                             byte[] var103 = class33.method676(var62);
                                             var73.method2927(var103.length);
                                             var73.offset += class210.field3117.method2741(var103, 0, var103.length, var73.payload, var73.offset);
                                             Client.field394.method2810(Client.field394.offset - var93);
                                             continue;
                                          }

                                          if(var53 == 5015) {
                                             if(class16.localPlayer != null && null != class16.localPlayer.name) {
                                                var106 = class16.localPlayer.name;
                                             } else {
                                                var106 = "";
                                             }

                                             class32.chatboxSegments[var6++] = var106;
                                             continue;
                                          }

                                          if(var53 == 5016) {
                                             class32.field722[var5++] = Client.field514;
                                             continue;
                                          }

                                          if(var53 == 5017) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             class32.field722[var5++] = class0.method4(var15);
                                             continue;
                                          }

                                          MessageNode var99;
                                          if(var53 == 5018) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var57 = class32.field722;
                                             var93 = var5++;
                                             var99 = (MessageNode)class47.field928.method2318((long)var15);
                                             if(null == var99) {
                                                var33 = -1;
                                             } else if(var99.previous == class47.field929.field1902) {
                                                var33 = -1;
                                             } else {
                                                var33 = ((MessageNode)var99.previous).id;
                                             }

                                             var57[var93] = var33;
                                             continue;
                                          }

                                          if(var53 == 5019) {
                                             --var5;
                                             var15 = class32.field722[var5];
                                             var57 = class32.field722;
                                             var93 = var5++;
                                             var99 = (MessageNode)class47.field928.method2318((long)var15);
                                             if(var99 == null) {
                                                var33 = -1;
                                             } else if(var99.next == class47.field929.field1902) {
                                                var33 = -1;
                                             } else {
                                                var33 = ((MessageNode)var99.next).id;
                                             }

                                             var57[var93] = var33;
                                             continue;
                                          }

                                          if(var53 == 5020) {
                                             --var6;
                                             var106 = class32.chatboxSegments[var6];
                                             if(var106.equalsIgnoreCase("toggleroof")) {
                                                class107.field1733.field685 = !class107.field1733.field685;
                                                class85.method1694();
                                                if(class107.field1733.field685) {
                                                   class103.sendGameMessage(99, "", "Roofs are now all hidden");
                                                } else {
                                                   class103.sendGameMessage(99, "", "Roofs will only be removed selectively");
                                                }
                                             }

                                             if(var106.equalsIgnoreCase("displayfps")) {
                                                Client.field477 = !Client.field477;
                                             }

                                             if(Client.field327 >= 2) {
                                                if(var106.equalsIgnoreCase("fpson")) {
                                                   Client.field477 = true;
                                                }

                                                if(var106.equalsIgnoreCase("fpsoff")) {
                                                   Client.field477 = false;
                                                }

                                                if(var106.equalsIgnoreCase("gc")) {
                                                   System.gc();
                                                }

                                                if(var106.equalsIgnoreCase("clientdrop")) {
                                                   if(Client.field331 > 0) {
                                                      GameObject.method1915();
                                                   } else {
                                                      class212.setGameState(40);
                                                      Client.field496 = Friend.field152;
                                                      Friend.field152 = null;
                                                   }
                                                }

                                                if(var106.equalsIgnoreCase("errortest") && Client.field424 == 2) {
                                                   throw new RuntimeException();
                                                }
                                             }

                                             Client.field394.method3037(191);
                                             Client.field394.method2799(var106.length() + 1);
                                             Client.field394.method2805(var106);
                                             continue;
                                          }

                                          if(var53 == 5021) {
                                             --var6;
                                             Client.field297 = class32.chatboxSegments[var6].toLowerCase().trim();
                                             continue;
                                          }

                                          if(var53 == 5022) {
                                             class32.chatboxSegments[var6++] = Client.field297;
                                             continue;
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var53 >= 2000) {
                                 var53 -= 1000;
                                 --var5;
                                 var34 = class37.method736(class32.field722[var5]);
                              } else {
                                 var34 = var70?class32.field726:class8.field76;
                              }

                              if(var53 == 1300) {
                                 --var5;
                                 var35 = class32.field722[var5] - 1;
                                 if(var35 >= 0 && var35 <= 9) {
                                    --var6;
                                    var34.method3182(var35, class32.chatboxSegments[var6]);
                                    continue;
                                 }

                                 --var6;
                                 continue;
                              }

                              if(var53 == 1301) {
                                 var5 -= 2;
                                 var35 = class32.field722[var5];
                                 var93 = class32.field722[1 + var5];
                                 var34.parent = class105.method1992(var35, var93);
                                 continue;
                              }

                              if(var53 == 1302) {
                                 --var5;
                                 var34.field2211 = class32.field722[var5] == 1;
                                 continue;
                              }

                              if(var53 == 1303) {
                                 --var5;
                                 var34.field2260 = class32.field722[var5];
                                 continue;
                              }

                              if(var53 == 1304) {
                                 --var5;
                                 var34.field2273 = class32.field722[var5];
                                 continue;
                              }

                              if(var53 == 1305) {
                                 --var6;
                                 var34.name = class32.chatboxSegments[var6];
                                 continue;
                              }

                              if(var53 == 1306) {
                                 --var6;
                                 var34.field2275 = class32.chatboxSegments[var6];
                                 continue;
                              }

                              if(var53 == 1307) {
                                 var34.actions = null;
                                 continue;
                              }
                           }
                        } else {
                           if(var53 >= 2000) {
                              var53 -= 1000;
                              --var5;
                              var34 = class37.method736(class32.field722[var5]);
                           } else {
                              var34 = var70?class32.field726:class8.field76;
                           }

                           class33.method682(var34);
                           if(var53 == 1200 || var53 == 1205 || var53 == 1212) {
                              var5 -= 2;
                              var35 = class32.field722[var5];
                              var93 = class32.field722[var5 + 1];
                              var34.item = var35;
                              var34.stackSize = var93;
                              ItemComposition var56 = class36.getItemDefinition(var35);
                              var34.rotationX = var56.xan2d;
                              var34.rotationZ = var56.yan2d;
                              var34.rotationY = var56.zan2d;
                              var34.field2245 = var56.offsetX2d;
                              var34.field2247 = var56.offsetY2d;
                              var34.field2250 = var56.zoom2d;
                              if(var53 == 1205) {
                                 var34.field2187 = 0;
                              } else if(var53 == 1212 | var56.isStackable == 1) {
                                 var34.field2187 = 1;
                              } else {
                                 var34.field2187 = 2;
                              }

                              if(var34.field2199 > 0) {
                                 var34.field2250 = var34.field2250 * 32 / var34.field2199;
                              } else if(var34.originalWidth > 0) {
                                 var34.field2250 = var34.field2250 * 32 / var34.originalWidth;
                              }
                              continue;
                           }

                           if(var53 == 1201) {
                              var34.modelType = 2;
                              --var5;
                              var34.modelId = class32.field722[var5];
                              continue;
                           }

                           if(var53 == 1202) {
                              var34.modelType = 3;
                              var34.modelId = class16.localPlayer.composition.method3128();
                              continue;
                           }
                        }
                     } else {
                        var35 = -1;
                        if(var53 >= 2000) {
                           var53 -= 1000;
                           --var5;
                           var35 = class32.field722[var5];
                           var34 = class37.method736(var35);
                        } else {
                           var34 = var70?class32.field726:class8.field76;
                        }

                        if(var53 == 1100) {
                           var5 -= 2;
                           var34.scrollX = class32.field722[var5];
                           if(var34.scrollX > var34.scrollWidth - var34.width) {
                              var34.scrollX = var34.scrollWidth - var34.width;
                           }

                           if(var34.scrollX < 0) {
                              var34.scrollX = 0;
                           }

                           var34.scrollY = class32.field722[1 + var5];
                           if(var34.scrollY > var34.scrollHeight - var34.height) {
                              var34.scrollY = var34.scrollHeight - var34.height;
                           }

                           if(var34.scrollY < 0) {
                              var34.scrollY = 0;
                           }

                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1101) {
                           --var5;
                           var34.textColor = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1102) {
                           --var5;
                           var34.field2225 = class32.field722[var5] == 1;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1103) {
                           --var5;
                           var34.opacity = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1104) {
                           --var5;
                           var34.field2229 = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1105) {
                           --var5;
                           var34.textureId = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1106) {
                           --var5;
                           var34.field2233 = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1107) {
                           --var5;
                           var34.field2234 = class32.field722[var5] == 1;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1108) {
                           var34.modelType = 1;
                           --var5;
                           var34.modelId = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1109) {
                           var5 -= 6;
                           var34.field2245 = class32.field722[var5];
                           var34.field2247 = class32.field722[var5 + 1];
                           var34.rotationX = class32.field722[var5 + 2];
                           var34.rotationZ = class32.field722[3 + var5];
                           var34.rotationY = class32.field722[var5 + 4];
                           var34.field2250 = class32.field722[var5 + 5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1110) {
                           --var5;
                           var93 = class32.field722[var5];
                           if(var34.field2243 != var93) {
                              var34.field2243 = var93;
                              var34.field2221 = 0;
                              var34.field2319 = 0;
                              class33.method682(var34);
                           }
                           continue;
                        }

                        if(var53 == 1111) {
                           --var5;
                           var34.field2246 = class32.field722[var5] == 1;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1112) {
                           --var6;
                           var17 = class32.chatboxSegments[var6];
                           if(!var17.equals(var34.text)) {
                              var34.text = var17;
                              class33.method682(var34);
                           }
                           continue;
                        }

                        if(var53 == 1113) {
                           --var5;
                           var34.fontId = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1114) {
                           var5 -= 3;
                           var34.field2259 = class32.field722[var5];
                           var34.field2263 = class32.field722[1 + var5];
                           var34.field2258 = class32.field722[var5 + 2];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1115) {
                           --var5;
                           var34.field2261 = class32.field722[var5] == 1;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1116) {
                           --var5;
                           var34.borderThickness = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1117) {
                           --var5;
                           var34.sprite2 = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1118) {
                           --var5;
                           var34.flippedVertically = class32.field722[var5] == 1;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1119) {
                           --var5;
                           var34.flippedHorizontally = class32.field722[var5] == 1;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1120) {
                           var5 -= 2;
                           var34.scrollWidth = class32.field722[var5];
                           var34.scrollHeight = class32.field722[1 + var5];
                           class33.method682(var34);
                           if(var35 != -1 && var34.type == 0) {
                              Renderable.method1892(Widget.widgets[var35 >> 16], var34, false);
                           }
                           continue;
                        }

                        if(var53 == 1121) {
                           class30.method657(var34.id, var34.index);
                           Client.field441 = var34;
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1122) {
                           --var5;
                           var34.field2232 = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1123) {
                           --var5;
                           var34.field2289 = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1124) {
                           --var5;
                           var34.field2228 = class32.field722[var5];
                           class33.method682(var34);
                           continue;
                        }

                        if(var53 == 1125) {
                           --var5;
                           var93 = class32.field722[var5];
                           class221 var18 = (class221)TextureProvider.method1454(PlayerComposition.method3157(), var93);
                           if(var18 != null) {
                              var34.field2226 = var18;
                              class33.method682(var34);
                           }
                           continue;
                        }
                     }
                  } else {
                     var15 = -1;
                     if(var53 >= 2000) {
                        var53 -= 1000;
                        --var5;
                        var15 = class32.field722[var5];
                        var16 = class37.method736(var15);
                     } else {
                        var16 = var70?class32.field726:class8.field76;
                     }

                     if(var53 == 1000) {
                        var5 -= 4;
                        var16.originalX = class32.field722[var5];
                        var16.originalY = class32.field722[var5 + 1];
                        var16.field2201 = class32.field722[2 + var5];
                        var16.field2195 = class32.field722[3 + var5];
                        class33.method682(var16);
                        class172.method3239(var16);
                        if(var15 != -1 && var16.type == 0) {
                           Renderable.method1892(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var53 == 1001) {
                        var5 -= 4;
                        var16.originalWidth = class32.field722[var5];
                        var16.field2241 = class32.field722[1 + var5];
                        var16.field2251 = class32.field722[2 + var5];
                        var16.field2204 = class32.field722[3 + var5];
                        class33.method682(var16);
                        class172.method3239(var16);
                        if(var15 != -1 && var16.type == 0) {
                           Renderable.method1892(Widget.widgets[var15 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var53 == 1003) {
                        --var5;
                        var36 = class32.field722[var5] == 1;
                        if(var36 != var16.isHidden) {
                           var16.isHidden = var36;
                           class33.method682(var16);
                        }
                        continue;
                     }

                     if(var53 == 1005) {
                        --var5;
                        var16.field2194 = class32.field722[var5] == 1;
                        continue;
                     }

                     if(var53 == 1006) {
                        --var5;
                        var16.field2297 = class32.field722[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var53 < 5400) {
                  if(var53 == 5306) {
                     var108 = class32.field722;
                     var35 = var5++;
                     var93 = Client.isResized?2:1;
                     var108[var35] = var93;
                     continue;
                  }

                  if(var53 == 5307) {
                     --var5;
                     var15 = class32.field722[var5];
                     if(var15 != 1 && var15 != 2) {
                        continue;
                     }

                     Client.field490 = 0L;
                     if(var15 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     class186.method3419();
                     if(Client.gameState >= 25) {
                        class167.method3159();
                     }

                     GameEngine.field1781 = true;
                     continue;
                  }

                  if(var53 == 5308) {
                     class32.field722[var5++] = class107.field1733.field687;
                     continue;
                  }

                  if(var53 == 5309) {
                     --var5;
                     var15 = class32.field722[var5];
                     if(var15 == 1 || var15 == 2) {
                        class107.field1733.field687 = var15;
                        class85.method1694();
                     }
                     continue;
                  }
               }

               if(var53 < 5600) {
                  if(var53 == 5504) {
                     var5 -= 2;
                     var15 = class32.field722[var5];
                     var35 = class32.field722[1 + var5];
                     if(!Client.field525) {
                        Client.field383 = var15;
                        Client.mapAngle = var35;
                     }
                     continue;
                  }

                  if(var53 == 5505) {
                     class32.field722[var5++] = Client.field383;
                     continue;
                  }

                  if(var53 == 5506) {
                     class32.field722[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var53 == 5530) {
                     --var5;
                     var15 = class32.field722[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field298 = var15;
                     continue;
                  }

                  if(var53 == 5531) {
                     class32.field722[var5++] = Client.field298;
                     continue;
                  }
               }

               if(var53 < 5700 && var53 == 5630) {
                  Client.field331 = 250;
               } else {
                  if(var53 < 6300) {
                     if(var53 == 6200) {
                        var5 -= 2;
                        Client.field355 = (short)class32.field722[var5];
                        if(Client.field355 <= 0) {
                           Client.field355 = 256;
                        }

                        Client.field532 = (short)class32.field722[var5 + 1];
                        if(Client.field532 <= 0) {
                           Client.field532 = 205;
                        }
                        continue;
                     }

                     if(var53 == 6201) {
                        var5 -= 2;
                        Client.field533 = (short)class32.field722[var5];
                        if(Client.field533 <= 0) {
                           Client.field533 = 256;
                        }

                        Client.field534 = (short)class32.field722[var5 + 1];
                        if(Client.field534 <= 0) {
                           Client.field534 = 320;
                        }
                        continue;
                     }

                     if(var53 == 6202) {
                        var5 -= 4;
                        Client.field535 = (short)class32.field722[var5];
                        if(Client.field535 <= 0) {
                           Client.field535 = 1;
                        }

                        Client.field450 = (short)class32.field722[1 + var5];
                        if(Client.field450 <= 0) {
                           Client.field450 = 32767;
                        } else if(Client.field450 < Client.field535) {
                           Client.field450 = Client.field535;
                        }

                        Client.field345 = (short)class32.field722[2 + var5];
                        if(Client.field345 <= 0) {
                           Client.field345 = 1;
                        }

                        Client.field538 = (short)class32.field722[var5 + 3];
                        if(Client.field538 <= 0) {
                           Client.field538 = 32767;
                        } else if(Client.field538 < Client.field345) {
                           Client.field538 = Client.field345;
                        }
                        continue;
                     }

                     if(var53 == 6203) {
                        if(null != Client.field449) {
                           class37.method735(0, 0, Client.field449.width, Client.field449.height, false);
                           class32.field722[var5++] = Client.camera2;
                           class32.field722[var5++] = Client.camera3;
                        } else {
                           class32.field722[var5++] = -1;
                           class32.field722[var5++] = -1;
                        }
                        continue;
                     }

                     if(var53 == 6204) {
                        class32.field722[var5++] = Client.field533;
                        class32.field722[var5++] = Client.field534;
                        continue;
                     }

                     if(var53 == 6205) {
                        class32.field722[var5++] = Client.field355;
                        class32.field722[var5++] = Client.field532;
                        continue;
                     }
                  }

                  if(var53 < 6600) {
                     if(var53 == 6500) {
                        class32.field722[var5++] = Ignore.loadWorlds()?1:0;
                        continue;
                     }

                     World var109;
                     if(var53 == 6501) {
                        var109 = class138.method2501();
                        if(null != var109) {
                           class32.field722[var5++] = var109.id;
                           class32.field722[var5++] = var109.mask;
                           class32.chatboxSegments[var6++] = var109.activity;
                           class32.field722[var5++] = var109.location;
                           class32.field722[var5++] = var109.playerCount;
                           class32.chatboxSegments[var6++] = var109.address;
                        } else {
                           class32.field722[var5++] = -1;
                           class32.field722[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field722[var5++] = 0;
                           class32.field722[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var53 == 6502) {
                        if(World.field673 < World.field668) {
                           var109 = class5.worldList[++World.field673 - 1];
                        } else {
                           var109 = null;
                        }

                        if(null != var109) {
                           class32.field722[var5++] = var109.id;
                           class32.field722[var5++] = var109.mask;
                           class32.chatboxSegments[var6++] = var109.activity;
                           class32.field722[var5++] = var109.location;
                           class32.field722[var5++] = var109.playerCount;
                           class32.chatboxSegments[var6++] = var109.address;
                        } else {
                           class32.field722[var5++] = -1;
                           class32.field722[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field722[var5++] = 0;
                           class32.field722[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var86;
                     if(var53 == 6506) {
                        --var5;
                        var15 = class32.field722[var5];
                        var86 = null;

                        for(var93 = 0; var93 < World.field668; ++var93) {
                           if(class5.worldList[var93].id == var15) {
                              var86 = class5.worldList[var93];
                              break;
                           }
                        }

                        if(var86 != null) {
                           class32.field722[var5++] = var86.id;
                           class32.field722[var5++] = var86.mask;
                           class32.chatboxSegments[var6++] = var86.activity;
                           class32.field722[var5++] = var86.location;
                           class32.field722[var5++] = var86.playerCount;
                           class32.chatboxSegments[var6++] = var86.address;
                        } else {
                           class32.field722[var5++] = -1;
                           class32.field722[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field722[var5++] = 0;
                           class32.field722[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var53 == 6507) {
                        var5 -= 4;
                        var15 = class32.field722[var5];
                        var96 = class32.field722[1 + var5] == 1;
                        var93 = class32.field722[2 + var5];
                        var94 = class32.field722[3 + var5] == 1;
                        class170.method3238(var15, var96, var93, var94);
                        continue;
                     }

                     if(var53 == 6511) {
                        --var5;
                        var15 = class32.field722[var5];
                        if(var15 >= 0 && var15 < World.field668) {
                           var86 = class5.worldList[var15];
                           class32.field722[var5++] = var86.id;
                           class32.field722[var5++] = var86.mask;
                           class32.chatboxSegments[var6++] = var86.activity;
                           class32.field722[var5++] = var86.location;
                           class32.field722[var5++] = var86.playerCount;
                           class32.chatboxSegments[var6++] = var86.address;
                           continue;
                        }

                        class32.field722[var5++] = -1;
                        class32.field722[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field722[var5++] = 0;
                        class32.field722[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var52) {
            StringBuilder var51 = new StringBuilder(30);
            var51.append("").append(var4.hash).append(" ");

            for(var13 = class32.field725 - 1; var13 >= 0; --var13) {
               var51.append("").append(class32.field724[var13].field109.hash).append(" ");
            }

            var51.append("").append(var10);
            class65.method1151(var51.toString(), var52);
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-92"
   )
   static final int method168(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
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
}

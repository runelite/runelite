import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class164 {
   @ObfuscatedName("cu")
   public static char field2317;
   @ObfuscatedName("mj")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "-1847926776"
   )
   static void method3225(class18 var0, int var1) {
      Object[] var2 = var0.field196;
      int var3 = ((Integer)var2[0]).intValue();
      class48 var4 = class171.method3300(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field939;
         int[] var9 = var4.field934;
         byte var10 = -1;
         class32.field721 = 0;

         int var13;
         try {
            class32.field716 = new int[var4.field932];
            int var11 = 0;
            FileOnDisk.field1188 = new String[var4.field940];
            int var12 = 0;

            int var14;
            String var29;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field184;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field185;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field192 != null?var0.field192.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field186;
                  }

                  if(var14 == -2147483643) {
                     var14 = var0.field192 != null?var0.field192.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field187 != null?var0.field187.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field187 != null?var0.field187.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field188;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field189;
                  }

                  class32.field716[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var29 = (String)var2[var13];
                  if(var29.equals("event_opbase")) {
                     var29 = var0.field199;
                  }

                  FileOnDisk.field1188[var12++] = var29;
               }
            }

            var13 = 0;
            class32.field720 = var0.field181;

            label3814:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var42 = var8[var7];
               int var31;
               int var32;
               int[] var48;
               int var51;
               String[] var53;
               String var77;
               if(var42 < 100) {
                  if(var42 == 0) {
                     class32.field719[var5++] = var9[var7];
                     continue;
                  }

                  if(var42 == 1) {
                     var14 = var9[var7];
                     class32.field719[var5++] = class146.widgetSettings[var14];
                     continue;
                  }

                  if(var42 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class146.widgetSettings[var14] = class32.field719[var5];
                     class41.method801(var14);
                     continue;
                  }

                  if(var42 == 3) {
                     class32.chatboxSegments[var6++] = var4.field935[var7];
                     continue;
                  }

                  if(var42 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var42 == 7) {
                     var5 -= 2;
                     if(class32.field719[var5 + 1] != class32.field719[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 8) {
                     var5 -= 2;
                     if(class32.field719[1 + var5] == class32.field719[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 9) {
                     var5 -= 2;
                     if(class32.field719[var5] < class32.field719[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 10) {
                     var5 -= 2;
                     if(class32.field719[var5] > class32.field719[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 21) {
                     if(class32.field721 == 0) {
                        return;
                     }

                     class10 var78 = class32.field725[--class32.field721];
                     var4 = var78.field94;
                     var8 = var4.field939;
                     var9 = var4.field934;
                     var7 = var78.field92;
                     class32.field716 = var78.field93;
                     FileOnDisk.field1188 = var78.field98;
                     continue;
                  }

                  if(var42 == 25) {
                     var14 = var9[var7];
                     class32.field719[var5++] = class37.method765(var14);
                     continue;
                  }

                  if(var42 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class85.method1736(var14, class32.field719[var5]);
                     continue;
                  }

                  if(var42 == 31) {
                     var5 -= 2;
                     if(class32.field719[var5] <= class32.field719[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 32) {
                     var5 -= 2;
                     if(class32.field719[var5] >= class32.field719[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var42 == 33) {
                     class32.field719[var5++] = class32.field716[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var42 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class32.field716[var10001] = class32.field719[var5];
                     continue;
                  }

                  if(var42 == 35) {
                     class32.chatboxSegments[var6++] = FileOnDisk.field1188[var9[var7]];
                     continue;
                  }

                  if(var42 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     FileOnDisk.field1188[var10001] = class32.chatboxSegments[var6];
                     continue;
                  }

                  if(var42 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var77 = class1.method22(class32.chatboxSegments, var6, var14);
                     class32.chatboxSegments[var6++] = var77;
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
                     class48 var108 = class171.method3300(var14);
                     var48 = new int[var108.field932];
                     var53 = new String[var108.field940];

                     for(var51 = 0; var51 < var108.field938; ++var51) {
                        var48[var51] = class32.field719[var51 + (var5 - var108.field938)];
                     }

                     for(var51 = 0; var51 < var108.field937; ++var51) {
                        var53[var51] = class32.chatboxSegments[var6 - var108.field937 + var51];
                     }

                     var5 -= var108.field938;
                     var6 -= var108.field937;
                     class10 var102 = new class10();
                     var102.field94 = var4;
                     var102.field92 = var7;
                     var102.field93 = class32.field716;
                     var102.field98 = FileOnDisk.field1188;
                     class32.field725[++class32.field721 - 1] = var102;
                     var4 = var108;
                     var8 = var108.field939;
                     var9 = var108.field934;
                     var7 = -1;
                     class32.field716 = var48;
                     FileOnDisk.field1188 = var53;
                     continue;
                  }

                  if(var42 == 42) {
                     class32.field719[var5++] = class3.chatMessages.method862(var9[var7]);
                     continue;
                  }

                  if(var42 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class3.chatMessages.method846(var10001, class32.field719[var5]);
                     continue;
                  }

                  if(var42 == 44) {
                     var14 = var9[var7] >> 16;
                     var31 = var9[var7] & '\uffff';
                     --var5;
                     var32 = class32.field719[var5];
                     if(var32 >= 0 && var32 <= 5000) {
                        class32.field714[var14] = var32;
                        byte var103 = -1;
                        if(var31 == 105) {
                           var103 = 0;
                        }

                        var51 = 0;

                        while(true) {
                           if(var51 >= var32) {
                              continue label3814;
                           }

                           class32.field718[var14][var51] = var103;
                           ++var51;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var31 = class32.field719[var5];
                     if(var31 >= 0 && var31 < class32.field714[var14]) {
                        class32.field719[var5++] = class32.field718[var14][var31];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var31 = class32.field719[var5];
                     if(var31 >= 0 && var31 < class32.field714[var14]) {
                        class32.field718[var14][var31] = class32.field719[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var42 == 47) {
                     var29 = class3.chatMessages.method852(var9[var7]);
                     if(var29 == null) {
                        var29 = "null";
                     }

                     class32.chatboxSegments[var6++] = var29;
                     continue;
                  }

                  if(var42 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class3.chatMessages.method870(var10001, class32.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var54;
               if(var9[var7] == 1) {
                  var54 = true;
               } else {
                  var54 = false;
               }

               Widget var15;
               Widget var16;
               boolean var18;
               int var20;
               Widget var43;
               Widget var75;
               int var84;
               boolean var86;
               if(var42 < 1000) {
                  if(var42 == 100) {
                     var5 -= 3;
                     var31 = class32.field719[var5];
                     var32 = class32.field719[1 + var5];
                     var84 = class32.field719[var5 + 2];
                     if(var32 == 0) {
                        throw new RuntimeException();
                     }

                     var75 = class5.method79(var31);
                     if(null == var75.children) {
                        var75.children = new Widget[1 + var84];
                     }

                     if(var75.children.length <= var84) {
                        Widget[] var66 = new Widget[var84 + 1];

                        for(var20 = 0; var20 < var75.children.length; ++var20) {
                           var66[var20] = var75.children[var20];
                        }

                        var75.children = var66;
                     }

                     if(var84 > 0 && var75.children[var84 - 1] == null) {
                        throw new RuntimeException("" + (var84 - 1));
                     }

                     Widget var68 = new Widget();
                     var68.type = var32;
                     var68.parentId = var68.id = var75.id;
                     var68.index = var84;
                     var68.field2068 = true;
                     var75.children[var84] = var68;
                     if(var54) {
                        class47.field929 = var68;
                     } else {
                        class32.field723 = var68;
                     }

                     Tile.method1577(var75);
                     continue;
                  }

                  if(var42 == 101) {
                     var15 = var54?class47.field929:class32.field723;
                     var16 = class5.method79(var15.id);
                     var16.children[var15.index] = null;
                     Tile.method1577(var16);
                     continue;
                  }

                  if(var42 == 102) {
                     --var5;
                     var15 = class5.method79(class32.field719[var5]);
                     var15.children = null;
                     Tile.method1577(var15);
                     continue;
                  }

                  if(var42 == 200) {
                     var5 -= 2;
                     var31 = class32.field719[var5];
                     var32 = class32.field719[1 + var5];
                     var43 = XGrandExchangeOffer.method69(var31, var32);
                     if(var43 != null && var32 != -1) {
                        class32.field719[var5++] = 1;
                        if(var54) {
                           class47.field929 = var43;
                        } else {
                           class32.field723 = var43;
                        }
                        continue;
                     }

                     class32.field719[var5++] = 0;
                     continue;
                  }

                  if(var42 == 201) {
                     --var5;
                     var15 = class5.method79(class32.field719[var5]);
                     if(var15 != null) {
                        class32.field719[var5++] = 1;
                        if(var54) {
                           class47.field929 = var15;
                        } else {
                           class32.field723 = var15;
                        }
                     } else {
                        class32.field719[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var33;
                  if((var42 < 1000 || var42 >= 1100) && (var42 < 2000 || var42 >= 2100)) {
                     String var17;
                     if((var42 < 1100 || var42 >= 1200) && (var42 < 2100 || var42 >= 2200)) {
                        if(var42 >= 1200 && var42 < 1300 || var42 >= 2200 && var42 < 2300) {
                           if(var42 >= 2000) {
                              var42 -= 1000;
                              --var5;
                              var15 = class5.method79(class32.field719[var5]);
                           } else {
                              var15 = var54?class47.field929:class32.field723;
                           }

                           Tile.method1577(var15);
                           if(var42 == 1200 || var42 == 1205 || var42 == 1212) {
                              var5 -= 2;
                              var32 = class32.field719[var5];
                              var84 = class32.field719[var5 + 1];
                              var15.item = var32;
                              var15.stackSize = var84;
                              ItemComposition var101 = class18.getItemDefinition(var32);
                              var15.rotationX = var101.field2955;
                              var15.rotationZ = var101.field2982;
                              var15.rotationY = var101.field2977;
                              var15.field2131 = var101.field2940;
                              var15.field2119 = var101.field2959;
                              var15.field2134 = var101.field2952;
                              if(var42 == 1205) {
                                 var15.field2127 = 0;
                              } else if(var42 == 1212 | var101.isStackable == 1) {
                                 var15.field2127 = 1;
                              } else {
                                 var15.field2127 = 2;
                              }

                              if(var15.field2124 > 0) {
                                 var15.field2134 = var15.field2134 * 32 / var15.field2124;
                              } else if(var15.field2144 > 0) {
                                 var15.field2134 = var15.field2134 * 32 / var15.field2144;
                              }
                              continue;
                           }

                           if(var42 == 1201) {
                              var15.modelType = 2;
                              --var5;
                              var15.modelId = class32.field719[var5];
                              continue;
                           }

                           if(var42 == 1202) {
                              var15.modelType = 3;
                              var15.modelId = class40.localPlayer.composition.method2801();
                              continue;
                           }
                        } else if((var42 < 1300 || var42 >= 1400) && (var42 < 2300 || var42 >= 2400)) {
                           int[] var44;
                           String var46;
                           int var90;
                           if(var42 >= 1400 && var42 < 1500 || var42 >= 2400 && var42 < 2500) {
                              if(var42 >= 2000) {
                                 var42 -= 1000;
                                 --var5;
                                 var15 = class5.method79(class32.field719[var5]);
                              } else {
                                 var15 = var54?class47.field929:class32.field723;
                              }

                              --var6;
                              var46 = class32.chatboxSegments[var6];
                              var44 = null;
                              if(var46.length() > 0 && var46.charAt(var46.length() - 1) == 89) {
                                 --var5;
                                 var51 = class32.field719[var5];
                                 if(var51 > 0) {
                                    for(var44 = new int[var51]; var51-- > 0; var44[var51] = class32.field719[var5]) {
                                       --var5;
                                    }
                                 }

                                 var46 = var46.substring(0, var46.length() - 1);
                              }

                              Object[] var92 = new Object[var46.length() + 1];

                              for(var90 = var92.length - 1; var90 >= 1; --var90) {
                                 if(var46.charAt(var90 - 1) == 115) {
                                    --var6;
                                    var92[var90] = class32.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var92[var90] = new Integer(class32.field719[var5]);
                                 }
                              }

                              --var5;
                              var90 = class32.field719[var5];
                              if(var90 != -1) {
                                 var92[0] = new Integer(var90);
                              } else {
                                 var92 = null;
                              }

                              if(var42 == 1400) {
                                 var15.field2151 = var92;
                              }

                              if(var42 == 1401) {
                                 var15.field2154 = var92;
                              }

                              if(var42 == 1402) {
                                 var15.field2153 = var92;
                              }

                              if(var42 == 1403) {
                                 var15.field2155 = var92;
                              }

                              if(var42 == 1404) {
                                 var15.field2157 = var92;
                              }

                              if(var42 == 1405) {
                                 var15.field2158 = var92;
                              }

                              if(var42 == 1406) {
                                 var15.field2161 = var92;
                              }

                              if(var42 == 1407) {
                                 var15.field2189 = var92;
                                 var15.field2079 = var44;
                              }

                              if(var42 == 1408) {
                                 var15.field2168 = var92;
                              }

                              if(var42 == 1409) {
                                 var15.field2178 = var92;
                              }

                              if(var42 == 1410) {
                                 var15.field2058 = var92;
                              }

                              if(var42 == 1411) {
                                 var15.field2152 = var92;
                              }

                              if(var42 == 1412) {
                                 var15.field2156 = var92;
                              }

                              if(var42 == 1414) {
                                 var15.field2164 = var92;
                                 var15.field2143 = var44;
                              }

                              if(var42 == 1415) {
                                 var15.field2166 = var92;
                                 var15.field2089 = var44;
                              }

                              if(var42 == 1416) {
                                 var15.field2160 = var92;
                              }

                              if(var42 == 1417) {
                                 var15.field2170 = var92;
                              }

                              if(var42 == 1418) {
                                 var15.field2171 = var92;
                              }

                              if(var42 == 1419) {
                                 var15.field2182 = var92;
                              }

                              if(var42 == 1420) {
                                 var15.field2167 = var92;
                              }

                              if(var42 == 1421) {
                                 var15.field2174 = var92;
                              }

                              if(var42 == 1422) {
                                 var15.field2175 = var92;
                              }

                              if(var42 == 1423) {
                                 var15.field2176 = var92;
                              }

                              if(var42 == 1424) {
                                 var15.field2177 = var92;
                              }

                              if(var42 == 1425) {
                                 var15.field2105 = var92;
                              }

                              if(var42 == 1426) {
                                 var15.field2180 = var92;
                              }

                              if(var42 == 1427) {
                                 var15.field2100 = var92;
                              }

                              var15.field2149 = true;
                              continue;
                           }

                           if(var42 < 1600) {
                              var15 = var54?class47.field929:class32.field723;
                              if(var42 == 1500) {
                                 class32.field719[var5++] = var15.relativeX;
                                 continue;
                              }

                              if(var42 == 1501) {
                                 class32.field719[var5++] = var15.relativeY;
                                 continue;
                              }

                              if(var42 == 1502) {
                                 class32.field719[var5++] = var15.width;
                                 continue;
                              }

                              if(var42 == 1503) {
                                 class32.field719[var5++] = var15.height;
                                 continue;
                              }

                              if(var42 == 1504) {
                                 class32.field719[var5++] = var15.isHidden?1:0;
                                 continue;
                              }

                              if(var42 == 1505) {
                                 class32.field719[var5++] = var15.parentId;
                                 continue;
                              }
                           } else if(var42 < 1700) {
                              var15 = var54?class47.field929:class32.field723;
                              if(var42 == 1600) {
                                 class32.field719[var5++] = var15.itemId;
                                 continue;
                              }

                              if(var42 == 1601) {
                                 class32.field719[var5++] = var15.scrollY;
                                 continue;
                              }

                              if(var42 == 1602) {
                                 class32.chatboxSegments[var6++] = var15.text;
                                 continue;
                              }

                              if(var42 == 1603) {
                                 class32.field719[var5++] = var15.scrollWidth;
                                 continue;
                              }

                              if(var42 == 1604) {
                                 class32.field719[var5++] = var15.scrollHeight;
                                 continue;
                              }

                              if(var42 == 1605) {
                                 class32.field719[var5++] = var15.field2134;
                                 continue;
                              }

                              if(var42 == 1606) {
                                 class32.field719[var5++] = var15.rotationX;
                                 continue;
                              }

                              if(var42 == 1607) {
                                 class32.field719[var5++] = var15.rotationY;
                                 continue;
                              }

                              if(var42 == 1608) {
                                 class32.field719[var5++] = var15.rotationZ;
                                 continue;
                              }

                              if(var42 == 1609) {
                                 class32.field719[var5++] = var15.opacity;
                                 continue;
                              }

                              if(var42 == 1610) {
                                 class32.field719[var5++] = var15.field2145;
                                 continue;
                              }

                              if(var42 == 1611) {
                                 class32.field719[var5++] = var15.textColor;
                                 continue;
                              }

                              if(var42 == 1612) {
                                 class32.field719[var5++] = var15.field2095;
                                 continue;
                              }

                              if(var42 == 1613) {
                                 class32.field719[var5++] = var15.field2065.vmethod4132();
                                 continue;
                              }
                           } else if(var42 < 1800) {
                              var15 = var54?class47.field929:class32.field723;
                              if(var42 == 1700) {
                                 class32.field719[var5++] = var15.item;
                                 continue;
                              }

                              if(var42 == 1701) {
                                 if(var15.item != -1) {
                                    class32.field719[var5++] = var15.stackSize;
                                 } else {
                                    class32.field719[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 1702) {
                                 class32.field719[var5++] = var15.index;
                                 continue;
                              }
                           } else if(var42 < 1900) {
                              var15 = var54?class47.field929:class32.field723;
                              if(var42 == 1800) {
                                 class32.field719[var5++] = class63.method1151(class185.method3463(var15));
                                 continue;
                              }

                              if(var42 == 1801) {
                                 --var5;
                                 var32 = class32.field719[var5];
                                 --var32;
                                 if(var15.actions != null && var32 < var15.actions.length && var15.actions[var32] != null) {
                                    class32.chatboxSegments[var6++] = var15.actions[var32];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var42 == 1802) {
                                 if(null == var15.name) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var15.name;
                                 }
                                 continue;
                              }
                           } else if(var42 >= 1900 && var42 < 2000 || var42 >= 2900 && var42 < 3000) {
                              if(var42 >= 2000) {
                                 var42 -= 1000;
                                 --var5;
                                 var15 = class5.method79(class32.field719[var5]);
                              } else {
                                 var15 = var54?class47.field929:class32.field723;
                              }

                              if(var42 == 1927) {
                                 if(class32.field720 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var15.field2100) {
                                    return;
                                 }

                                 class18 var73 = new class18();
                                 var73.field192 = var15;
                                 var73.field196 = var15.field2100;
                                 var73.field181 = class32.field720 + 1;
                                 Client.field484.method2454(var0);
                                 continue;
                              }
                           } else if(var42 < 2600) {
                              --var5;
                              var15 = class5.method79(class32.field719[var5]);
                              if(var42 == 2500) {
                                 class32.field719[var5++] = var15.relativeX;
                                 continue;
                              }

                              if(var42 == 2501) {
                                 class32.field719[var5++] = var15.relativeY;
                                 continue;
                              }

                              if(var42 == 2502) {
                                 class32.field719[var5++] = var15.width;
                                 continue;
                              }

                              if(var42 == 2503) {
                                 class32.field719[var5++] = var15.height;
                                 continue;
                              }

                              if(var42 == 2504) {
                                 class32.field719[var5++] = var15.isHidden?1:0;
                                 continue;
                              }

                              if(var42 == 2505) {
                                 class32.field719[var5++] = var15.parentId;
                                 continue;
                              }
                           } else if(var42 < 2700) {
                              --var5;
                              var15 = class5.method79(class32.field719[var5]);
                              if(var42 == 2600) {
                                 class32.field719[var5++] = var15.itemId;
                                 continue;
                              }

                              if(var42 == 2601) {
                                 class32.field719[var5++] = var15.scrollY;
                                 continue;
                              }

                              if(var42 == 2602) {
                                 class32.chatboxSegments[var6++] = var15.text;
                                 continue;
                              }

                              if(var42 == 2603) {
                                 class32.field719[var5++] = var15.scrollWidth;
                                 continue;
                              }

                              if(var42 == 2604) {
                                 class32.field719[var5++] = var15.scrollHeight;
                                 continue;
                              }

                              if(var42 == 2605) {
                                 class32.field719[var5++] = var15.field2134;
                                 continue;
                              }

                              if(var42 == 2606) {
                                 class32.field719[var5++] = var15.rotationX;
                                 continue;
                              }

                              if(var42 == 2607) {
                                 class32.field719[var5++] = var15.rotationY;
                                 continue;
                              }

                              if(var42 == 2608) {
                                 class32.field719[var5++] = var15.rotationZ;
                                 continue;
                              }

                              if(var42 == 2609) {
                                 class32.field719[var5++] = var15.opacity;
                                 continue;
                              }

                              if(var42 == 2610) {
                                 class32.field719[var5++] = var15.field2145;
                                 continue;
                              }

                              if(var42 == 2611) {
                                 class32.field719[var5++] = var15.textColor;
                                 continue;
                              }

                              if(var42 == 2612) {
                                 class32.field719[var5++] = var15.field2095;
                                 continue;
                              }

                              if(var42 == 2613) {
                                 class32.field719[var5++] = var15.field2065.vmethod4132();
                                 continue;
                              }
                           } else if(var42 < 2800) {
                              if(var42 == 2700) {
                                 --var5;
                                 var15 = class5.method79(class32.field719[var5]);
                                 class32.field719[var5++] = var15.item;
                                 continue;
                              }

                              if(var42 == 2701) {
                                 --var5;
                                 var15 = class5.method79(class32.field719[var5]);
                                 if(var15.item != -1) {
                                    class32.field719[var5++] = var15.stackSize;
                                 } else {
                                    class32.field719[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 2702) {
                                 --var5;
                                 var31 = class32.field719[var5];
                                 WidgetNode var45 = (WidgetNode)Client.componentTable.method2405((long)var31);
                                 if(null != var45) {
                                    class32.field719[var5++] = 1;
                                 } else {
                                    class32.field719[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var42 == 2706) {
                                 class32.field719[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var42 < 2900) {
                              --var5;
                              var15 = class5.method79(class32.field719[var5]);
                              if(var42 == 2800) {
                                 class32.field719[var5++] = class63.method1151(class185.method3463(var15));
                                 continue;
                              }

                              if(var42 == 2801) {
                                 --var5;
                                 var32 = class32.field719[var5];
                                 --var32;
                                 if(null != var15.actions && var32 < var15.actions.length && null != var15.actions[var32]) {
                                    class32.chatboxSegments[var6++] = var15.actions[var32];
                                    continue;
                                 }

                                 class32.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var42 == 2802) {
                                 if(var15.name == null) {
                                    class32.chatboxSegments[var6++] = "";
                                 } else {
                                    class32.chatboxSegments[var6++] = var15.name;
                                 }
                                 continue;
                              }
                           } else {
                              int var21;
                              int var22;
                              int var23;
                              int var67;
                              if(var42 < 3200) {
                                 if(var42 == 3100) {
                                    --var6;
                                    var77 = class32.chatboxSegments[var6];
                                    class10.method120(0, "", var77);
                                    continue;
                                 }

                                 if(var42 == 3101) {
                                    var5 -= 2;
                                    class36.method756(class40.localPlayer, class32.field719[var5], class32.field719[1 + var5]);
                                    continue;
                                 }

                                 if(var42 == 3103) {
                                    class5.method72();
                                    continue;
                                 }

                                 boolean var34;
                                 if(var42 == 3104) {
                                    --var6;
                                    var77 = class32.chatboxSegments[var6];
                                    var32 = 0;
                                    var34 = false;
                                    boolean var56 = false;
                                    var21 = 0;
                                    var22 = var77.length();
                                    var23 = 0;

                                    while(true) {
                                       if(var23 >= var22) {
                                          var18 = var56;
                                          break;
                                       }

                                       label4090: {
                                          char var24 = var77.charAt(var23);
                                          if(var23 == 0) {
                                             if(var24 == 45) {
                                                var34 = true;
                                                break label4090;
                                             }

                                             if(var24 == 43) {
                                                break label4090;
                                             }
                                          }

                                          if(var24 >= 48 && var24 <= 57) {
                                             var67 = var24 - 48;
                                          } else if(var24 >= 65 && var24 <= 90) {
                                             var67 = var24 - 55;
                                          } else {
                                             if(var24 < 97 || var24 > 122) {
                                                var18 = false;
                                                break;
                                             }

                                             var67 = var24 - 87;
                                          }

                                          if(var67 >= 10) {
                                             var18 = false;
                                             break;
                                          }

                                          if(var34) {
                                             var67 = -var67;
                                          }

                                          int var25 = var21 * 10 + var67;
                                          if(var25 / 10 != var21) {
                                             var18 = false;
                                             break;
                                          }

                                          var21 = var25;
                                          var56 = true;
                                       }

                                       ++var23;
                                    }

                                    if(var18) {
                                       var32 = class28.method635(var77);
                                    }

                                    Client.field330.method3234(71);
                                    Client.field330.method2978(var32);
                                    continue;
                                 }

                                 if(var42 == 3105) {
                                    --var6;
                                    var77 = class32.chatboxSegments[var6];
                                    Client.field330.method3234(67);
                                    Client.field330.method2975(var77.length() + 1);
                                    Client.field330.method2981(var77);
                                    continue;
                                 }

                                 if(var42 == 3106) {
                                    --var6;
                                    var77 = class32.chatboxSegments[var6];
                                    Client.field330.method3234(213);
                                    Client.field330.method2975(var77.length() + 1);
                                    Client.field330.method2981(var77);
                                    continue;
                                 }

                                 if(var42 == 3107) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    --var6;
                                    var46 = class32.chatboxSegments[var6];
                                    var84 = class45.field897;
                                    int[] var76 = class45.field902;
                                    var34 = false;

                                    for(var20 = 0; var20 < var84; ++var20) {
                                       Player var35 = Client.cachedPlayers[var76[var20]];
                                       if(null != var35 && var35 != class40.localPlayer && null != var35.name && var35.name.equalsIgnoreCase(var46)) {
                                          if(var31 == 1) {
                                             Client.field330.method3234(25);
                                             Client.field330.method2986(0);
                                             Client.field330.method3022(var76[var20]);
                                          } else if(var31 == 4) {
                                             Client.field330.method3234(242);
                                             Client.field330.method3022(var76[var20]);
                                             Client.field330.method2986(0);
                                          } else if(var31 == 6) {
                                             Client.field330.method3234(22);
                                             Client.field330.method3022(var76[var20]);
                                             Client.field330.method3098(0);
                                          } else if(var31 == 7) {
                                             Client.field330.method3234(223);
                                             Client.field330.method2976(var76[var20]);
                                             Client.field330.method2986(0);
                                          }

                                          var34 = true;
                                          break;
                                       }
                                    }

                                    if(!var34) {
                                       class10.method120(4, "", "Unable to find " + var46);
                                    }
                                    continue;
                                 }

                                 if(var42 == 3108) {
                                    var5 -= 3;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[1 + var5];
                                    var84 = class32.field719[2 + var5];
                                    var75 = class5.method79(var84);
                                    class108.method2088(var75, var31, var32);
                                    continue;
                                 }

                                 if(var42 == 3109) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[1 + var5];
                                    var43 = var54?class47.field929:class32.field723;
                                    class108.method2088(var43, var31, var32);
                                    continue;
                                 }

                                 if(var42 == 3110) {
                                    --var5;
                                    MessageNode.field229 = class32.field719[var5] == 1;
                                    continue;
                                 }

                                 if(var42 == 3111) {
                                    class32.field719[var5++] = Tile.field1343.field691?1:0;
                                    continue;
                                 }

                                 if(var42 == 3112) {
                                    --var5;
                                    Tile.field1343.field691 = class32.field719[var5] == 1;
                                    class3.method42();
                                    continue;
                                 }

                                 if(var42 == 3113) {
                                    --var6;
                                    var77 = class32.chatboxSegments[var6];
                                    --var5;
                                    var86 = class32.field719[var5] == 1;
                                    MessageNode.method217(var77, var86, false);
                                    continue;
                                 }

                                 if(var42 == 3115) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    Client.field330.method3234(62);
                                    Client.field330.method2976(var31);
                                    continue;
                                 }

                                 if(var42 == 3116) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    var6 -= 2;
                                    var46 = class32.chatboxSegments[var6];
                                    var17 = class32.chatboxSegments[1 + var6];
                                    if(var46.length() <= 500 && var17.length() <= 500) {
                                       Client.field330.method3234(234);
                                       Client.field330.method2976(1 + RSCanvas.method2132(var46) + RSCanvas.method2132(var17));
                                       Client.field330.method3098(var31);
                                       Client.field330.method2981(var46);
                                       Client.field330.method2981(var17);
                                    }
                                    continue;
                                 }
                              } else if(var42 < 3300) {
                                 if(var42 == 3200) {
                                    var5 -= 3;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[1 + var5];
                                    var84 = class32.field719[var5 + 2];
                                    if(Client.field478 != 0 && var32 != 0 && Client.field527 < 50) {
                                       Client.field528[Client.field527] = var31;
                                       Client.field529[Client.field527] = var32;
                                       Client.field431[Client.field527] = var84;
                                       Client.field532[Client.field527] = null;
                                       Client.field299[Client.field527] = 0;
                                       ++Client.field527;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3201) {
                                    --var5;
                                    class36.method754(class32.field719[var5]);
                                    continue;
                                 }

                                 if(var42 == 3202) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5];
                                    int var10000 = class32.field719[1 + var5];
                                    if(Client.field522 != 0 && var31 != -1) {
                                       class119.method2349(Client.field332, var31, 0, Client.field522, false);
                                       Client.field524 = true;
                                    }
                                    continue;
                                 }
                              } else if(var42 < 3400) {
                                 if(var42 == 3300) {
                                    class32.field719[var5++] = Client.gameCycle;
                                    continue;
                                 }

                                 if(var42 == 3301) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[var5 + 1];
                                    class32.field719[var5++] = class25.method605(var31, var32);
                                    continue;
                                 }

                                 if(var42 == 3302) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[var5 + 1];
                                    class32.field719[var5++] = class8.method105(var31, var32);
                                    continue;
                                 }

                                 XItemContainer var36;
                                 if(var42 == 3303) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[var5 + 1];
                                    var44 = class32.field719;
                                    var51 = var5++;
                                    var36 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var31);
                                    if(null == var36) {
                                       var90 = 0;
                                    } else if(var32 == -1) {
                                       var90 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var36.stackSizes.length; ++var22) {
                                          if(var36.itemIds[var22] == var32) {
                                             var21 += var36.stackSizes[var22];
                                          }
                                       }

                                       var90 = var21;
                                    }

                                    var44[var51] = var90;
                                    continue;
                                 }

                                 if(var42 == 3304) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    var48 = class32.field719;
                                    var84 = var5++;
                                    class186 var49 = (class186)class186.field2769.get((long)var31);
                                    class186 var79;
                                    if(var49 != null) {
                                       var79 = var49;
                                    } else {
                                       byte[] var93 = class186.field2768.method3329(5, var31);
                                       var49 = new class186();
                                       if(var93 != null) {
                                          var49.method3468(new Buffer(var93));
                                       }

                                       class186.field2769.put(var49, (long)var31);
                                       var79 = var49;
                                    }

                                    var48[var84] = var79.field2771;
                                    continue;
                                 }

                                 if(var42 == 3305) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    class32.field719[var5++] = Client.boostedSkillLevels[var31];
                                    continue;
                                 }

                                 if(var42 == 3306) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    class32.field719[var5++] = Client.realSkillLevels[var31];
                                    continue;
                                 }

                                 if(var42 == 3307) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    class32.field719[var5++] = Client.skillExperiences[var31];
                                    continue;
                                 }

                                 if(var42 == 3308) {
                                    var31 = class166.plane;
                                    var32 = class16.baseX + (class40.localPlayer.x >> 7);
                                    var84 = (class40.localPlayer.y >> 7) + Client.baseY;
                                    class32.field719[var5++] = var84 + (var31 << 28) + (var32 << 14);
                                    continue;
                                 }

                                 if(var42 == 3309) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    class32.field719[var5++] = var31 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var42 == 3310) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    class32.field719[var5++] = var31 >> 28;
                                    continue;
                                 }

                                 if(var42 == 3311) {
                                    --var5;
                                    var31 = class32.field719[var5];
                                    class32.field719[var5++] = var31 & 16383;
                                    continue;
                                 }

                                 if(var42 == 3312) {
                                    class32.field719[var5++] = Client.isMembers?1:0;
                                    continue;
                                 }

                                 if(var42 == 3313) {
                                    var5 -= 2;
                                    var31 = '耀' + class32.field719[var5];
                                    var32 = class32.field719[1 + var5];
                                    var44 = class32.field719;
                                    var51 = var5++;
                                    var36 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var31);
                                    if(null == var36) {
                                       var90 = -1;
                                    } else if(var32 >= 0 && var32 < var36.itemIds.length) {
                                       var90 = var36.itemIds[var32];
                                    } else {
                                       var90 = -1;
                                    }

                                    var44[var51] = var90;
                                    continue;
                                 }

                                 if(var42 == 3314) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5] + '耀';
                                    var32 = class32.field719[1 + var5];
                                    class32.field719[var5++] = class8.method105(var31, var32);
                                    continue;
                                 }

                                 if(var42 == 3315) {
                                    var5 -= 2;
                                    var31 = '耀' + class32.field719[var5];
                                    var32 = class32.field719[var5 + 1];
                                    var44 = class32.field719;
                                    var51 = var5++;
                                    var36 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var31);
                                    if(null == var36) {
                                       var90 = 0;
                                    } else if(var32 == -1) {
                                       var90 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var36.stackSizes.length; ++var22) {
                                          if(var36.itemIds[var22] == var32) {
                                             var21 += var36.stackSizes[var22];
                                          }
                                       }

                                       var90 = var21;
                                    }

                                    var44[var51] = var90;
                                    continue;
                                 }

                                 if(var42 == 3316) {
                                    if(Client.field503 >= 2) {
                                       class32.field719[var5++] = Client.field503;
                                    } else {
                                       class32.field719[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3317) {
                                    class32.field719[var5++] = Client.field301;
                                    continue;
                                 }

                                 if(var42 == 3318) {
                                    class32.field719[var5++] = Client.world;
                                    continue;
                                 }

                                 if(var42 == 3321) {
                                    class32.field719[var5++] = Client.energy;
                                    continue;
                                 }

                                 if(var42 == 3322) {
                                    class32.field719[var5++] = Client.weight;
                                    continue;
                                 }

                                 if(var42 == 3323) {
                                    if(Client.field333) {
                                       class32.field719[var5++] = 1;
                                    } else {
                                       class32.field719[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3324) {
                                    class32.field719[var5++] = Client.flags;
                                    continue;
                                 }
                              } else if(var42 < 3500) {
                                 if(var42 == 3400) {
                                    var5 -= 2;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[var5 + 1];
                                    class195 var47 = FrameMap.method1738(var31);
                                    if(var47.field2858 != 115) {
                                       ;
                                    }

                                    for(var51 = 0; var51 < var47.field2860; ++var51) {
                                       if(var32 == var47.field2861[var51]) {
                                          class32.chatboxSegments[var6++] = var47.field2863[var51];
                                          var47 = null;
                                          break;
                                       }
                                    }

                                    if(null != var47) {
                                       class32.chatboxSegments[var6++] = var47.field2854;
                                    }
                                    continue;
                                 }

                                 if(var42 == 3408) {
                                    var5 -= 4;
                                    var31 = class32.field719[var5];
                                    var32 = class32.field719[1 + var5];
                                    var84 = class32.field719[2 + var5];
                                    var51 = class32.field719[var5 + 3];
                                    class195 var52 = FrameMap.method1738(var84);
                                    if(var52.field2856 == var31 && var52.field2858 == var32) {
                                       for(var20 = 0; var20 < var52.field2860; ++var20) {
                                          if(var51 == var52.field2861[var20]) {
                                             if(var32 == 115) {
                                                class32.chatboxSegments[var6++] = var52.field2863[var20];
                                             } else {
                                                class32.field719[var5++] = var52.field2862[var20];
                                             }

                                             var52 = null;
                                             break;
                                          }
                                       }

                                       if(null != var52) {
                                          if(var32 == 115) {
                                             class32.chatboxSegments[var6++] = var52.field2854;
                                          } else {
                                             class32.field719[var5++] = var52.field2859;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var32 == 115) {
                                       class32.chatboxSegments[var6++] = "null";
                                    } else {
                                       class32.field719[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else {
                                 String var88;
                                 String var94;
                                 if(var42 < 3700) {
                                    if(var42 == 3600) {
                                       if(Client.field553 == 0) {
                                          class32.field719[var5++] = -2;
                                       } else if(Client.field553 == 1) {
                                          class32.field719[var5++] = -1;
                                       } else {
                                          class32.field719[var5++] = Client.friendCount;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3601) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(Client.field553 == 2 && var31 < Client.friendCount) {
                                          class32.chatboxSegments[var6++] = Client.friends[var31].name;
                                          class32.chatboxSegments[var6++] = Client.friends[var31].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var42 == 3602) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(Client.field553 == 2 && var31 < Client.friendCount) {
                                          class32.field719[var5++] = Client.friends[var31].world;
                                          continue;
                                       }

                                       class32.field719[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3603) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(Client.field553 == 2 && var31 < Client.friendCount) {
                                          class32.field719[var5++] = Client.friends[var31].rank;
                                          continue;
                                       }

                                       class32.field719[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3604) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       --var5;
                                       var32 = class32.field719[var5];
                                       Client.field330.method3234(184);
                                       Client.field330.method2975(RSCanvas.method2132(var77) + 1);
                                       Client.field330.method2981(var77);
                                       Client.field330.method2975(var32);
                                       continue;
                                    }

                                    String var57;
                                    Ignore var83;
                                    Friend var85;
                                    if(var42 == 3605) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       if(null == var77) {
                                          continue;
                                       }

                                       if((Client.friendCount < 200 || Client.field410 == 1) && Client.friendCount < 400) {
                                          var46 = class162.method3194(var77, class108.field1740);
                                          if(var46 == null) {
                                             continue;
                                          }

                                          for(var84 = 0; var84 < Client.friendCount; ++var84) {
                                             var85 = Client.friends[var84];
                                             var57 = class162.method3194(var85.name, class108.field1740);
                                             if(var57 != null && var57.equals(var46)) {
                                                class10.method120(30, "", var77 + " is already on your friend list");
                                                continue label3814;
                                             }

                                             if(var85.previousName != null) {
                                                var94 = class162.method3194(var85.previousName, class108.field1740);
                                                if(null != var94 && var94.equals(var46)) {
                                                   class10.method120(30, "", var77 + " is already on your friend list");
                                                   continue label3814;
                                                }
                                             }
                                          }

                                          for(var84 = 0; var84 < Client.ignoreCount; ++var84) {
                                             var83 = Client.ignores[var84];
                                             var57 = class162.method3194(var83.name, class108.field1740);
                                             if(null != var57 && var57.equals(var46)) {
                                                class10.method120(30, "", "Please remove " + var77 + " from your ignore list first");
                                                continue label3814;
                                             }

                                             if(null != var83.previousName) {
                                                var94 = class162.method3194(var83.previousName, class108.field1740);
                                                if(var94 != null && var94.equals(var46)) {
                                                   class10.method120(30, "", "Please remove " + var77 + " from your ignore list first");
                                                   continue label3814;
                                                }
                                             }
                                          }

                                          if(class162.method3194(class40.localPlayer.name, class108.field1740).equals(var46)) {
                                             class10.method120(30, "", "You can\'t add yourself to your own friend list");
                                          } else {
                                             Client.field330.method3234(161);
                                             Client.field330.method2975(RSCanvas.method2132(var77));
                                             Client.field330.method2981(var77);
                                          }
                                          continue;
                                       }

                                       class10.method120(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                       continue;
                                    }

                                    if(var42 == 3606) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       if(null == var77) {
                                          continue;
                                       }

                                       var46 = class162.method3194(var77, class108.field1740);
                                       if(var46 == null) {
                                          continue;
                                       }

                                       var84 = 0;

                                       while(true) {
                                          if(var84 >= Client.friendCount) {
                                             continue label3814;
                                          }

                                          var85 = Client.friends[var84];
                                          var57 = var85.name;
                                          var94 = class162.method3194(var57, class108.field1740);
                                          if(class107.method2082(var77, var46, var57, var94)) {
                                             --Client.friendCount;

                                             for(var21 = var84; var21 < Client.friendCount; ++var21) {
                                                Client.friends[var21] = Client.friends[1 + var21];
                                             }

                                             Client.field388 = Client.field470;
                                             Client.field330.method3234(104);
                                             Client.field330.method2975(RSCanvas.method2132(var77));
                                             Client.field330.method2981(var77);
                                             continue label3814;
                                          }

                                          ++var84;
                                       }
                                    }

                                    if(var42 == 3607) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       if(var77 == null) {
                                          continue;
                                       }

                                       if((Client.ignoreCount < 100 || Client.field410 == 1) && Client.ignoreCount < 400) {
                                          var46 = class162.method3194(var77, class108.field1740);
                                          if(null == var46) {
                                             continue;
                                          }

                                          for(var84 = 0; var84 < Client.ignoreCount; ++var84) {
                                             var83 = Client.ignores[var84];
                                             var57 = class162.method3194(var83.name, class108.field1740);
                                             if(null != var57 && var57.equals(var46)) {
                                                class10.method120(31, "", var77 + " is already on your ignore list");
                                                continue label3814;
                                             }

                                             if(null != var83.previousName) {
                                                var94 = class162.method3194(var83.previousName, class108.field1740);
                                                if(null != var94 && var94.equals(var46)) {
                                                   class10.method120(31, "", var77 + " is already on your ignore list");
                                                   continue label3814;
                                                }
                                             }
                                          }

                                          for(var84 = 0; var84 < Client.friendCount; ++var84) {
                                             var85 = Client.friends[var84];
                                             var57 = class162.method3194(var85.name, class108.field1740);
                                             if(var57 != null && var57.equals(var46)) {
                                                class10.method120(31, "", "Please remove " + var77 + " from your friend list first");
                                                continue label3814;
                                             }

                                             if(var85.previousName != null) {
                                                var94 = class162.method3194(var85.previousName, class108.field1740);
                                                if(null != var94 && var94.equals(var46)) {
                                                   class10.method120(31, "", "Please remove " + var77 + " from your friend list first");
                                                   continue label3814;
                                                }
                                             }
                                          }

                                          if(class162.method3194(class40.localPlayer.name, class108.field1740).equals(var46)) {
                                             class10.method120(31, "", "You can\'t add yourself to your own ignore list");
                                          } else {
                                             Client.field330.method3234(69);
                                             Client.field330.method2975(RSCanvas.method2132(var77));
                                             Client.field330.method2981(var77);
                                          }
                                          continue;
                                       }

                                       class10.method120(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                       continue;
                                    }

                                    if(var42 == 3608) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       if(var77 == null) {
                                          continue;
                                       }

                                       var46 = class162.method3194(var77, class108.field1740);
                                       if(var46 == null) {
                                          continue;
                                       }

                                       var84 = 0;

                                       while(true) {
                                          if(var84 >= Client.ignoreCount) {
                                             continue label3814;
                                          }

                                          var83 = Client.ignores[var84];
                                          var57 = var83.name;
                                          var94 = class162.method3194(var57, class108.field1740);
                                          if(class107.method2082(var77, var46, var57, var94)) {
                                             --Client.ignoreCount;

                                             for(var21 = var84; var21 < Client.ignoreCount; ++var21) {
                                                Client.ignores[var21] = Client.ignores[1 + var21];
                                             }

                                             Client.field388 = Client.field470;
                                             Client.field330.method3234(229);
                                             Client.field330.method2975(RSCanvas.method2132(var77));
                                             Client.field330.method2981(var77);
                                             continue label3814;
                                          }

                                          ++var84;
                                       }
                                    }

                                    if(var42 == 3609) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       class177[] var50 = class65.method1170();

                                       for(var84 = 0; var84 < var50.length; ++var84) {
                                          class177 var82 = var50[var84];
                                          if(var82.field2677 != -1 && var77.startsWith(class9.method116(var82.field2677))) {
                                             var77 = var77.substring(6 + Integer.toString(var82.field2677).length());
                                             break;
                                          }
                                       }

                                       class32.field719[var5++] = class22.method221(var77, false)?1:0;
                                       continue;
                                    }

                                    long var62;
                                    char var69;
                                    String var80;
                                    String[] var81;
                                    if(var42 == 3611) {
                                       if(Client.field512 == null) {
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       var81 = class32.chatboxSegments;
                                       var32 = var6++;
                                       var80 = Client.field512;
                                       var62 = 0L;
                                       var23 = var80.length();

                                       for(var67 = 0; var67 < var23; ++var67) {
                                          var62 *= 37L;
                                          var69 = var80.charAt(var67);
                                          if(var69 >= 65 && var69 <= 90) {
                                             var62 += (long)(1 + var69 - 65);
                                          } else if(var69 >= 97 && var69 <= 122) {
                                             var62 += (long)(var69 + 1 - 97);
                                          } else if(var69 >= 48 && var69 <= 57) {
                                             var62 += (long)(27 + var69 - 48);
                                          }

                                          if(var62 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var62 % 37L == 0L && 0L != var62) {
                                          var62 /= 37L;
                                       }

                                       var88 = class11.method159(var62);
                                       if(null == var88) {
                                          var88 = "";
                                       }

                                       var81[var32] = var88;
                                       continue;
                                    }

                                    if(var42 == 3612) {
                                       if(null != Client.field512) {
                                          class32.field719[var5++] = class60.field1072;
                                       } else {
                                          class32.field719[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3613) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(null != Client.field512 && var31 < class60.field1072) {
                                          class32.chatboxSegments[var6++] = clanMembers[var31].username;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var42 == 3614) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(null != Client.field512 && var31 < class60.field1072) {
                                          class32.field719[var5++] = clanMembers[var31].world;
                                          continue;
                                       }

                                       class32.field719[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3615) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(Client.field512 != null && var31 < class60.field1072) {
                                          class32.field719[var5++] = clanMembers[var31].rank;
                                          continue;
                                       }

                                       class32.field719[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3616) {
                                       class32.field719[var5++] = XClanMember.field273;
                                       continue;
                                    }

                                    if(var42 == 3617) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       Ignore.method208(var77);
                                       continue;
                                    }

                                    if(var42 == 3618) {
                                       class32.field719[var5++] = WidgetNode.field175;
                                       continue;
                                    }

                                    if(var42 == 3619) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       class25.method607(var77);
                                       continue;
                                    }

                                    if(var42 == 3620) {
                                       class119.method2350();
                                       continue;
                                    }

                                    if(var42 == 3621) {
                                       if(Client.field553 == 0) {
                                          class32.field719[var5++] = -1;
                                       } else {
                                          class32.field719[var5++] = Client.ignoreCount;
                                       }
                                       continue;
                                    }

                                    if(var42 == 3622) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(Client.field553 != 0 && var31 < Client.ignoreCount) {
                                          class32.chatboxSegments[var6++] = Client.ignores[var31].name;
                                          class32.chatboxSegments[var6++] = Client.ignores[var31].previousName;
                                          continue;
                                       }

                                       class32.chatboxSegments[var6++] = "";
                                       class32.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var42 == 3623) {
                                       --var6;
                                       var77 = class32.chatboxSegments[var6];
                                       if(var77.startsWith(class9.method116(0)) || var77.startsWith(class9.method116(1))) {
                                          var77 = var77.substring(7);
                                       }

                                       class32.field719[var5++] = class186.method3472(var77)?1:0;
                                       continue;
                                    }

                                    if(var42 == 3624) {
                                       --var5;
                                       var31 = class32.field719[var5];
                                       if(null != clanMembers && var31 < class60.field1072 && clanMembers[var31].username.equalsIgnoreCase(class40.localPlayer.name)) {
                                          class32.field719[var5++] = 1;
                                          continue;
                                       }

                                       class32.field719[var5++] = 0;
                                       continue;
                                    }

                                    if(var42 == 3625) {
                                       if(null == Client.field328) {
                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       var81 = class32.chatboxSegments;
                                       var32 = var6++;
                                       var80 = Client.field328;
                                       var62 = 0L;
                                       var23 = var80.length();

                                       for(var67 = 0; var67 < var23; ++var67) {
                                          var62 *= 37L;
                                          var69 = var80.charAt(var67);
                                          if(var69 >= 65 && var69 <= 90) {
                                             var62 += (long)(1 + var69 - 65);
                                          } else if(var69 >= 97 && var69 <= 122) {
                                             var62 += (long)(1 + var69 - 97);
                                          } else if(var69 >= 48 && var69 <= 57) {
                                             var62 += (long)(27 + var69 - 48);
                                          }

                                          if(var62 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var62 % 37L == 0L && var62 != 0L) {
                                          var62 /= 37L;
                                       }

                                       var88 = class11.method159(var62);
                                       if(var88 == null) {
                                          var88 = "";
                                       }

                                       var81[var32] = var88;
                                       continue;
                                    }
                                 } else {
                                    long var98;
                                    if(var42 < 4000) {
                                       if(var42 == 3903) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = Client.grandExchangeOffers[var31].method63();
                                          continue;
                                       }

                                       if(var42 == 3904) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = Client.grandExchangeOffers[var31].itemId;
                                          continue;
                                       }

                                       if(var42 == 3905) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = Client.grandExchangeOffers[var31].price;
                                          continue;
                                       }

                                       if(var42 == 3906) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = Client.grandExchangeOffers[var31].totalQuantity;
                                          continue;
                                       }

                                       if(var42 == 3907) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = Client.grandExchangeOffers[var31].quantitySold;
                                          continue;
                                       }

                                       if(var42 == 3908) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = Client.grandExchangeOffers[var31].spent;
                                          continue;
                                       }

                                       if(var42 == 3910) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var32 = Client.grandExchangeOffers[var31].method48();
                                          class32.field719[var5++] = var32 == 0?1:0;
                                          continue;
                                       }

                                       if(var42 == 3911) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var32 = Client.grandExchangeOffers[var31].method48();
                                          class32.field719[var5++] = var32 == 2?1:0;
                                          continue;
                                       }

                                       if(var42 == 3912) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var32 = Client.grandExchangeOffers[var31].method48();
                                          class32.field719[var5++] = var32 == 5?1:0;
                                          continue;
                                       }

                                       if(var42 == 3913) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var32 = Client.grandExchangeOffers[var31].method48();
                                          class32.field719[var5++] = var32 == 1?1:0;
                                          continue;
                                       }

                                       boolean var100;
                                       if(var42 == 3914) {
                                          --var5;
                                          var100 = class32.field719[var5] == 1;
                                          if(class3.field33 != null) {
                                             class3.field33.method13(class1.field11, var100);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3915) {
                                          --var5;
                                          var100 = class32.field719[var5] == 1;
                                          if(null != class3.field33) {
                                             class3.field33.method13(class1.field6, var100);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3916) {
                                          var5 -= 2;
                                          var100 = class32.field719[var5] == 1;
                                          var86 = class32.field719[1 + var5] == 1;
                                          if(class3.field33 != null) {
                                             class3.field33.method13(new class44(var86), var100);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3917) {
                                          --var5;
                                          var100 = class32.field719[var5] == 1;
                                          if(null != class3.field33) {
                                             class3.field33.method13(class1.field4, var100);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3918) {
                                          --var5;
                                          var100 = class32.field719[var5] == 1;
                                          if(class3.field33 != null) {
                                             class3.field33.method13(class1.field8, var100);
                                          }
                                          continue;
                                       }

                                       if(var42 == 3919) {
                                          class32.field719[var5++] = class3.field33 == null?0:class3.field33.field10.size();
                                          continue;
                                       }

                                       class2 var58;
                                       if(var42 == 3920) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          class32.field719[var5++] = var58.field24;
                                          continue;
                                       }

                                       if(var42 == 3921) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          class32.chatboxSegments[var6++] = var58.method24();
                                          continue;
                                       }

                                       if(var42 == 3922) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          class32.chatboxSegments[var6++] = var58.method25();
                                          continue;
                                       }

                                       if(var42 == 3923) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          var98 = class202.method3838() - class2.field21 - var58.field15;
                                          var90 = (int)(var98 / 3600000L);
                                          var20 = (int)((var98 - (long)(3600000 * var90)) / 60000L);
                                          var21 = (int)((var98 - (long)(3600000 * var90) - (long)('\uea60' * var20)) / 1000L);
                                          String var37 = var90 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                          class32.chatboxSegments[var6++] = var37;
                                          continue;
                                       }

                                       if(var42 == 3924) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          class32.field719[var5++] = var58.field23.totalQuantity;
                                          continue;
                                       }

                                       if(var42 == 3925) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          class32.field719[var5++] = var58.field23.price;
                                          continue;
                                       }

                                       if(var42 == 3926) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var58 = (class2)class3.field33.field10.get(var31);
                                          class32.field719[var5++] = var58.field23.itemId;
                                          continue;
                                       }
                                    } else if(var42 < 4100) {
                                       if(var42 == 4000) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = var32 + var31;
                                          continue;
                                       }

                                       if(var42 == 4001) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = var31 - var32;
                                          continue;
                                       }

                                       if(var42 == 4002) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          class32.field719[var5++] = var31 * var32;
                                          continue;
                                       }

                                       if(var42 == 4003) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = var31 / var32;
                                          continue;
                                       }

                                       if(var42 == 4004) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = (int)(Math.random() * (double)var31);
                                          continue;
                                       }

                                       if(var42 == 4005) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = (int)(Math.random() * (double)(var31 + 1));
                                          continue;
                                       }

                                       if(var42 == 4006) {
                                          var5 -= 5;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          var84 = class32.field719[2 + var5];
                                          var51 = class32.field719[var5 + 3];
                                          var90 = class32.field719[var5 + 4];
                                          class32.field719[var5++] = (var32 - var31) * (var90 - var84) / (var51 - var84) + var31;
                                          continue;
                                       }

                                       if(var42 == 4007) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          class32.field719[var5++] = var31 + var31 * var32 / 100;
                                          continue;
                                       }

                                       if(var42 == 4008) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          class32.field719[var5++] = var31 | 1 << var32;
                                          continue;
                                       }

                                       if(var42 == 4009) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = var31 & -1 - (1 << var32);
                                          continue;
                                       }

                                       if(var42 == 4010) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = (var31 & 1 << var32) != 0?1:0;
                                          continue;
                                       }

                                       if(var42 == 4011) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = var31 % var32;
                                          continue;
                                       }

                                       if(var42 == 4012) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          if(var31 == 0) {
                                             class32.field719[var5++] = 0;
                                          } else {
                                             class32.field719[var5++] = (int)Math.pow((double)var31, (double)var32);
                                          }
                                          continue;
                                       }

                                       if(var42 == 4013) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          if(var31 == 0) {
                                             class32.field719[var5++] = 0;
                                          } else if(var32 == 0) {
                                             class32.field719[var5++] = Integer.MAX_VALUE;
                                          } else {
                                             class32.field719[var5++] = (int)Math.pow((double)var31, 1.0D / (double)var32);
                                          }
                                          continue;
                                       }

                                       if(var42 == 4014) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[var5 + 1];
                                          class32.field719[var5++] = var31 & var32;
                                          continue;
                                       }

                                       if(var42 == 4015) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          class32.field719[var5++] = var31 | var32;
                                          continue;
                                       }

                                       if(var42 == 4018) {
                                          var5 -= 3;
                                          long var105 = (long)class32.field719[var5];
                                          var98 = (long)class32.field719[var5 + 1];
                                          long var95 = (long)class32.field719[2 + var5];
                                          class32.field719[var5++] = (int)(var95 * var105 / var98);
                                          continue;
                                       }
                                    } else if(var42 < 4200) {
                                       if(var42 == 4100) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          --var5;
                                          var32 = class32.field719[var5];
                                          class32.chatboxSegments[var6++] = var77 + var32;
                                          continue;
                                       }

                                       if(var42 == 4101) {
                                          var6 -= 2;
                                          var77 = class32.chatboxSegments[var6];
                                          var46 = class32.chatboxSegments[1 + var6];
                                          class32.chatboxSegments[var6++] = var77 + var46;
                                          continue;
                                       }

                                       if(var42 == 4102) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          --var5;
                                          var32 = class32.field719[var5];
                                          var53 = class32.chatboxSegments;
                                          var51 = var6++;
                                          if(var32 < 0) {
                                             var94 = Integer.toString(var32);
                                          } else {
                                             var22 = var32;
                                             if(var32 < 0) {
                                                var88 = Integer.toString(var32, 10);
                                             } else {
                                                var23 = 2;

                                                for(var67 = var32 / 10; var67 != 0; ++var23) {
                                                   var67 /= 10;
                                                }

                                                char[] var38 = new char[var23];
                                                var38[0] = 43;

                                                for(int var26 = var23 - 1; var26 > 0; --var26) {
                                                   int var27 = var22;
                                                   var22 /= 10;
                                                   int var28 = var27 - 10 * var22;
                                                   if(var28 >= 10) {
                                                      var38[var26] = (char)(var28 + 87);
                                                   } else {
                                                      var38[var26] = (char)(var28 + 48);
                                                   }
                                                }

                                                var88 = new String(var38);
                                             }

                                             var94 = var88;
                                          }

                                          var53[var51] = var77 + var94;
                                          continue;
                                       }

                                       if(var42 == 4103) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          class32.chatboxSegments[var6++] = var77.toLowerCase();
                                          continue;
                                       }

                                       if(var42 == 4104) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          long var104 = 86400000L * (11745L + (long)var31);
                                          class32.field724.setTime(new Date(var104));
                                          var51 = class32.field724.get(5);
                                          var90 = class32.field724.get(2);
                                          var20 = class32.field724.get(1);
                                          class32.chatboxSegments[var6++] = var51 + "-" + class32.field727[var90] + "-" + var20;
                                          continue;
                                       }

                                       if(var42 == 4105) {
                                          var6 -= 2;
                                          var77 = class32.chatboxSegments[var6];
                                          var46 = class32.chatboxSegments[var6 + 1];
                                          if(null != class40.localPlayer.composition && class40.localPlayer.composition.isFemale) {
                                             class32.chatboxSegments[var6++] = var46;
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = var77;
                                          continue;
                                       }

                                       if(var42 == 4106) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.chatboxSegments[var6++] = Integer.toString(var31);
                                          continue;
                                       }

                                       if(var42 == 4107) {
                                          var6 -= 2;
                                          class32.field719[var5++] = Frames.method1932(CollisionData.method2313(class32.chatboxSegments[var6], class32.chatboxSegments[var6 + 1], Client.field289));
                                          continue;
                                       }

                                       class208 var61;
                                       byte[] var87;
                                       if(var42 == 4108) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var32 = class32.field719[var5];
                                          var84 = class32.field719[var5 + 1];
                                          var87 = Client.field319.method3329(var84, 0);
                                          var61 = new class208(var87);
                                          class32.field719[var5++] = var61.method3915(var77, var32);
                                          continue;
                                       }

                                       if(var42 == 4109) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var32 = class32.field719[var5];
                                          var84 = class32.field719[1 + var5];
                                          var87 = Client.field319.method3329(var84, 0);
                                          var61 = new class208(var87);
                                          class32.field719[var5++] = var61.method3914(var77, var32);
                                          continue;
                                       }

                                       if(var42 == 4110) {
                                          var6 -= 2;
                                          var77 = class32.chatboxSegments[var6];
                                          var46 = class32.chatboxSegments[var6 + 1];
                                          --var5;
                                          if(class32.field719[var5] == 1) {
                                             class32.chatboxSegments[var6++] = var77;
                                          } else {
                                             class32.chatboxSegments[var6++] = var46;
                                          }
                                          continue;
                                       }

                                       if(var42 == 4111) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          class32.chatboxSegments[var6++] = class209.method3979(var77);
                                          continue;
                                       }

                                       if(var42 == 4112) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          --var5;
                                          var32 = class32.field719[var5];
                                          class32.chatboxSegments[var6++] = var77 + (char)var32;
                                          continue;
                                       }

                                       if(var42 == 4113) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = class3.method45((char)var31)?1:0;
                                          continue;
                                       }

                                       if(var42 == 4114) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = class57.method1054((char)var31)?1:0;
                                          continue;
                                       }

                                       char var97;
                                       if(var42 == 4115) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var48 = class32.field719;
                                          var84 = var5++;
                                          var97 = (char)var31;
                                          var18 = var97 >= 65 && var97 <= 90 || var97 >= 97 && var97 <= 122;
                                          var48[var84] = var18?1:0;
                                          continue;
                                       }

                                       if(var42 == 4116) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var48 = class32.field719;
                                          var84 = var5++;
                                          var97 = (char)var31;
                                          var18 = var97 >= 48 && var97 <= 57;
                                          var48[var84] = var18?1:0;
                                          continue;
                                       }

                                       if(var42 == 4117) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          if(var77 != null) {
                                             class32.field719[var5++] = var77.length();
                                          } else {
                                             class32.field719[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var42 == 4118) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var32 = class32.field719[var5];
                                          var84 = class32.field719[1 + var5];
                                          class32.chatboxSegments[var6++] = var77.substring(var32, var84);
                                          continue;
                                       }

                                       if(var42 == 4119) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          StringBuilder var65 = new StringBuilder(var77.length());
                                          var33 = false;

                                          for(var51 = 0; var51 < var77.length(); ++var51) {
                                             var97 = var77.charAt(var51);
                                             if(var97 == 60) {
                                                var33 = true;
                                             } else if(var97 == 62) {
                                                var33 = false;
                                             } else if(!var33) {
                                                var65.append(var97);
                                             }
                                          }

                                          class32.chatboxSegments[var6++] = var65.toString();
                                          continue;
                                       }

                                       if(var42 == 4120) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          --var5;
                                          var32 = class32.field719[var5];
                                          class32.field719[var5++] = var77.indexOf(var32);
                                          continue;
                                       }

                                       if(var42 == 4121) {
                                          var6 -= 2;
                                          var77 = class32.chatboxSegments[var6];
                                          var46 = class32.chatboxSegments[var6 + 1];
                                          --var5;
                                          var84 = class32.field719[var5];
                                          class32.field719[var5++] = var77.indexOf(var46, var84);
                                          continue;
                                       }
                                    } else if(var42 < 4300) {
                                       if(var42 == 4200) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.chatboxSegments[var6++] = class18.getItemDefinition(var31).name;
                                          continue;
                                       }

                                       ItemComposition var55;
                                       if(var42 == 4201) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          var55 = class18.getItemDefinition(var31);
                                          if(var32 >= 1 && var32 <= 5 && var55.groundActions[var32 - 1] != null) {
                                             class32.chatboxSegments[var6++] = var55.groundActions[var32 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var42 == 4202) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          var55 = class18.getItemDefinition(var31);
                                          if(var32 >= 1 && var32 <= 5 && null != var55.inventoryActions[var32 - 1]) {
                                             class32.chatboxSegments[var6++] = var55.inventoryActions[var32 - 1];
                                             continue;
                                          }

                                          class32.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var42 == 4203) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = class18.getItemDefinition(var31).price;
                                          continue;
                                       }

                                       if(var42 == 4204) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = class18.getItemDefinition(var31).isStackable == 1?1:0;
                                          continue;
                                       }

                                       ItemComposition var70;
                                       if(var42 == 4205) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var70 = class18.getItemDefinition(var31);
                                          if(var70.field2980 == -1 && var70.note >= 0) {
                                             class32.field719[var5++] = var70.note;
                                             continue;
                                          }

                                          class32.field719[var5++] = var31;
                                          continue;
                                       }

                                       if(var42 == 4206) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var70 = class18.getItemDefinition(var31);
                                          if(var70.field2980 >= 0 && var70.note >= 0) {
                                             class32.field719[var5++] = var70.note;
                                             continue;
                                          }

                                          class32.field719[var5++] = var31;
                                          continue;
                                       }

                                       if(var42 == 4207) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = class18.getItemDefinition(var31).isMembers?1:0;
                                          continue;
                                       }

                                       if(var42 == 4208) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var70 = class18.getItemDefinition(var31);
                                          if(var70.field2991 == -1 && var70.field2958 >= 0) {
                                             class32.field719[var5++] = var70.field2958;
                                             continue;
                                          }

                                          class32.field719[var5++] = var31;
                                          continue;
                                       }

                                       if(var42 == 4209) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var70 = class18.getItemDefinition(var31);
                                          if(var70.field2991 >= 0 && var70.field2958 >= 0) {
                                             class32.field719[var5++] = var70.field2958;
                                             continue;
                                          }

                                          class32.field719[var5++] = var31;
                                          continue;
                                       }

                                       if(var42 == 4210) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          --var5;
                                          var32 = class32.field719[var5];
                                          class94.method1948(var77, var32 == 1);
                                          class32.field719[var5++] = XItemContainer.field125;
                                          continue;
                                       }

                                       if(var42 == 4211) {
                                          if(null != class175.field2659 && class168.field2339 < XItemContainer.field125) {
                                             class32.field719[var5++] = class175.field2659[++class168.field2339 - 1] & '\uffff';
                                             continue;
                                          }

                                          class32.field719[var5++] = -1;
                                          continue;
                                       }

                                       if(var42 == 4212) {
                                          class168.field2339 = 0;
                                          continue;
                                       }
                                    } else if(var42 < 5100) {
                                       if(var42 == 5000) {
                                          class32.field719[var5++] = Client.field364;
                                          continue;
                                       }

                                       if(var42 == 5001) {
                                          var5 -= 3;
                                          Client.field364 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          class216[] var60 = new class216[]{class216.field3154, class216.field3156, class216.field3155};
                                          class216[] var91 = var60;
                                          var90 = 0;

                                          class216 var106;
                                          while(true) {
                                             if(var90 >= var91.length) {
                                                var106 = null;
                                                break;
                                             }

                                             class216 var96 = var91[var90];
                                             if(var96.field3153 == var32) {
                                                var106 = var96;
                                                break;
                                             }

                                             ++var90;
                                          }

                                          Client.field568 = var106;
                                          if(Client.field568 == null) {
                                             Client.field568 = class216.field3154;
                                          }

                                          Client.field504 = class32.field719[2 + var5];
                                          Client.field330.method3234(125);
                                          Client.field330.method2975(Client.field364);
                                          Client.field330.method2975(Client.field568.field3153);
                                          Client.field330.method2975(Client.field504);
                                          continue;
                                       }

                                       if(var42 == 5002) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          var5 -= 2;
                                          var32 = class32.field719[var5];
                                          var84 = class32.field719[1 + var5];
                                          Client.field330.method3234(228);
                                          Client.field330.method2975(RSCanvas.method2132(var77) + 2);
                                          Client.field330.method2981(var77);
                                          Client.field330.method2975(var32 - 1);
                                          Client.field330.method2975(var84);
                                          continue;
                                       }

                                       if(var42 == 5003) {
                                          var5 -= 2;
                                          var31 = class32.field719[var5];
                                          var32 = class32.field719[1 + var5];
                                          ChatLineBuffer var89 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var31));
                                          MessageNode var59 = var89.method901(var32);
                                          if(null != var59) {
                                             class32.field719[var5++] = var59.id;
                                             class32.field719[var5++] = var59.tick;
                                             class32.chatboxSegments[var6++] = null != var59.name?var59.name:"";
                                             class32.chatboxSegments[var6++] = null != var59.sender?var59.sender:"";
                                             class32.chatboxSegments[var6++] = null != var59.value?var59.value:"";
                                          } else {
                                             class32.field719[var5++] = -1;
                                             class32.field719[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var42 == 5004) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          MessageNode var72 = WidgetNode.method202(var31);
                                          if(null != var72) {
                                             class32.field719[var5++] = var72.type;
                                             class32.field719[var5++] = var72.tick;
                                             class32.chatboxSegments[var6++] = var72.name != null?var72.name:"";
                                             class32.chatboxSegments[var6++] = var72.sender != null?var72.sender:"";
                                             class32.chatboxSegments[var6++] = var72.value != null?var72.value:"";
                                          } else {
                                             class32.field719[var5++] = -1;
                                             class32.field719[var5++] = 0;
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                             class32.chatboxSegments[var6++] = "";
                                          }
                                          continue;
                                       }

                                       if(var42 == 5005) {
                                          if(Client.field568 == null) {
                                             class32.field719[var5++] = -1;
                                          } else {
                                             class32.field719[var5++] = Client.field568.field3153;
                                          }
                                          continue;
                                       }

                                       if(var42 == 5008) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          --var5;
                                          var32 = class32.field719[var5];
                                          var17 = var77.toLowerCase();
                                          byte var71 = 0;
                                          if(var17.startsWith("yellow:")) {
                                             var71 = 0;
                                             var77 = var77.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var71 = 1;
                                             var77 = var77.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var71 = 2;
                                             var77 = var77.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var71 = 3;
                                             var77 = var77.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var71 = 4;
                                             var77 = var77.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var71 = 5;
                                             var77 = var77.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var71 = 6;
                                             var77 = var77.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var71 = 7;
                                             var77 = var77.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var71 = 8;
                                             var77 = var77.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var71 = 9;
                                             var77 = var77.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var71 = 10;
                                             var77 = var77.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var71 = 11;
                                             var77 = var77.substring("glow3:".length());
                                          } else if(Client.field289 != 0) {
                                             if(var17.startsWith("yellow:")) {
                                                var71 = 0;
                                                var77 = var77.substring("yellow:".length());
                                             } else if(var17.startsWith("red:")) {
                                                var71 = 1;
                                                var77 = var77.substring("red:".length());
                                             } else if(var17.startsWith("green:")) {
                                                var71 = 2;
                                                var77 = var77.substring("green:".length());
                                             } else if(var17.startsWith("cyan:")) {
                                                var71 = 3;
                                                var77 = var77.substring("cyan:".length());
                                             } else if(var17.startsWith("purple:")) {
                                                var71 = 4;
                                                var77 = var77.substring("purple:".length());
                                             } else if(var17.startsWith("white:")) {
                                                var71 = 5;
                                                var77 = var77.substring("white:".length());
                                             } else if(var17.startsWith("flash1:")) {
                                                var71 = 6;
                                                var77 = var77.substring("flash1:".length());
                                             } else if(var17.startsWith("flash2:")) {
                                                var71 = 7;
                                                var77 = var77.substring("flash2:".length());
                                             } else if(var17.startsWith("flash3:")) {
                                                var71 = 8;
                                                var77 = var77.substring("flash3:".length());
                                             } else if(var17.startsWith("glow1:")) {
                                                var71 = 9;
                                                var77 = var77.substring("glow1:".length());
                                             } else if(var17.startsWith("glow2:")) {
                                                var71 = 10;
                                                var77 = var77.substring("glow2:".length());
                                             } else if(var17.startsWith("glow3:")) {
                                                var71 = 11;
                                                var77 = var77.substring("glow3:".length());
                                             }
                                          }

                                          var17 = var77.toLowerCase();
                                          byte var99 = 0;
                                          if(var17.startsWith("wave:")) {
                                             var99 = 1;
                                             var77 = var77.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var99 = 2;
                                             var77 = var77.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var99 = 3;
                                             var77 = var77.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var99 = 4;
                                             var77 = var77.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var99 = 5;
                                             var77 = var77.substring("slide:".length());
                                          } else if(Client.field289 != 0) {
                                             if(var17.startsWith("wave:")) {
                                                var99 = 1;
                                                var77 = var77.substring("wave:".length());
                                             } else if(var17.startsWith("wave2:")) {
                                                var99 = 2;
                                                var77 = var77.substring("wave2:".length());
                                             } else if(var17.startsWith("shake:")) {
                                                var99 = 3;
                                                var77 = var77.substring("shake:".length());
                                             } else if(var17.startsWith("scroll:")) {
                                                var99 = 4;
                                                var77 = var77.substring("scroll:".length());
                                             } else if(var17.startsWith("slide:")) {
                                                var99 = 5;
                                                var77 = var77.substring("slide:".length());
                                             }
                                          }

                                          Client.field330.method3234(94);
                                          Client.field330.method2975(0);
                                          var20 = Client.field330.offset;
                                          Client.field330.method2975(var32);
                                          Client.field330.method2975(var71);
                                          Client.field330.method2975(var99);
                                          KitDefinition.method3565(Client.field330, var77);
                                          Client.field330.method2990(Client.field330.offset - var20);
                                          continue;
                                       }

                                       if(var42 == 5009) {
                                          var6 -= 2;
                                          var77 = class32.chatboxSegments[var6];
                                          var46 = class32.chatboxSegments[1 + var6];
                                          Client.field330.method3234(220);
                                          Client.field330.method2976(0);
                                          var84 = Client.field330.offset;
                                          Client.field330.method2981(var77);
                                          KitDefinition.method3565(Client.field330, var46);
                                          Client.field330.method3127(Client.field330.offset - var84);
                                          continue;
                                       }

                                       if(var42 == 5015) {
                                          if(null != class40.localPlayer && class40.localPlayer.name != null) {
                                             var77 = class40.localPlayer.name;
                                          } else {
                                             var77 = "";
                                          }

                                          class32.chatboxSegments[var6++] = var77;
                                          continue;
                                       }

                                       if(var42 == 5016) {
                                          class32.field719[var5++] = Client.field504;
                                          continue;
                                       }

                                       if(var42 == 5017) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var48 = class32.field719;
                                          var84 = var5++;
                                          ChatLineBuffer var64 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var31));
                                          if(var64 == null) {
                                             var51 = 0;
                                          } else {
                                             var51 = var64.method902();
                                          }

                                          var48[var84] = var51;
                                          continue;
                                       }

                                       if(var42 == 5018) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          class32.field719[var5++] = class162.method3189(var31);
                                          continue;
                                       }

                                       if(var42 == 5019) {
                                          --var5;
                                          var31 = class32.field719[var5];
                                          var48 = class32.field719;
                                          var84 = var5++;
                                          MessageNode var63 = (MessageNode)class47.field925.method2378((long)var31);
                                          if(null == var63) {
                                             var51 = -1;
                                          } else if(class47.field930.field1897 == var63.next) {
                                             var51 = -1;
                                          } else {
                                             var51 = ((MessageNode)var63.next).id;
                                          }

                                          var48[var84] = var51;
                                          continue;
                                       }

                                       if(var42 == 5020) {
                                          --var6;
                                          var77 = class32.chatboxSegments[var6];
                                          class7.method94(var77);
                                          continue;
                                       }

                                       if(var42 == 5021) {
                                          --var6;
                                          Client.field505 = class32.chatboxSegments[var6].toLowerCase().trim();
                                          continue;
                                       }

                                       if(var42 == 5022) {
                                          class32.chatboxSegments[var6++] = Client.field505;
                                          continue;
                                       }
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var42 >= 2000) {
                              var42 -= 1000;
                              --var5;
                              var15 = class5.method79(class32.field719[var5]);
                           } else {
                              var15 = var54?class47.field929:class32.field723;
                           }

                           if(var42 == 1300) {
                              --var5;
                              var32 = class32.field719[var5] - 1;
                              if(var32 >= 0 && var32 <= 9) {
                                 --var6;
                                 var15.method2847(var32, class32.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var42 == 1301) {
                              var5 -= 2;
                              var32 = class32.field719[var5];
                              var84 = class32.field719[1 + var5];
                              var15.parent = XGrandExchangeOffer.method69(var32, var84);
                              continue;
                           }

                           if(var42 == 1302) {
                              --var5;
                              var15.field2147 = class32.field719[var5] == 1;
                              continue;
                           }

                           if(var42 == 1303) {
                              --var5;
                              var15.field2125 = class32.field719[var5];
                              continue;
                           }

                           if(var42 == 1304) {
                              --var5;
                              var15.field2146 = class32.field719[var5];
                              continue;
                           }

                           if(var42 == 1305) {
                              --var6;
                              var15.name = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var42 == 1306) {
                              --var6;
                              var15.field2148 = class32.chatboxSegments[var6];
                              continue;
                           }

                           if(var42 == 1307) {
                              var15.actions = null;
                              continue;
                           }
                        }
                     } else {
                        var32 = -1;
                        if(var42 >= 2000) {
                           var42 -= 1000;
                           --var5;
                           var32 = class32.field719[var5];
                           var15 = class5.method79(var32);
                        } else {
                           var15 = var54?class47.field929:class32.field723;
                        }

                        if(var42 == 1100) {
                           var5 -= 2;
                           var15.itemId = class32.field719[var5];
                           if(var15.itemId > var15.scrollWidth - var15.width) {
                              var15.itemId = var15.scrollWidth - var15.width;
                           }

                           if(var15.itemId < 0) {
                              var15.itemId = 0;
                           }

                           var15.scrollY = class32.field719[1 + var5];
                           if(var15.scrollY > var15.scrollHeight - var15.height) {
                              var15.scrollY = var15.scrollHeight - var15.height;
                           }

                           if(var15.scrollY < 0) {
                              var15.scrollY = 0;
                           }

                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1101) {
                           --var5;
                           var15.textColor = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1102) {
                           --var5;
                           var15.field2098 = class32.field719[var5] == 1;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1103) {
                           --var5;
                           var15.opacity = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1104) {
                           --var5;
                           var15.field2102 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1105) {
                           --var5;
                           var15.textureId = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1106) {
                           --var5;
                           var15.field2106 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1107) {
                           --var5;
                           var15.field2107 = class32.field719[var5] == 1;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1108) {
                           var15.modelType = 1;
                           --var5;
                           var15.modelId = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1109) {
                           var5 -= 6;
                           var15.field2131 = class32.field719[var5];
                           var15.field2119 = class32.field719[var5 + 1];
                           var15.rotationX = class32.field719[var5 + 2];
                           var15.rotationZ = class32.field719[3 + var5];
                           var15.rotationY = class32.field719[var5 + 4];
                           var15.field2134 = class32.field719[var5 + 5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1110) {
                           --var5;
                           var84 = class32.field719[var5];
                           if(var15.field2116 != var84) {
                              var15.field2116 = var84;
                              var15.field2057 = 0;
                              var15.field2192 = 0;
                              Tile.method1577(var15);
                           }
                           continue;
                        }

                        if(var42 == 1111) {
                           --var5;
                           var15.field2140 = class32.field719[var5] == 1;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1112) {
                           --var6;
                           var17 = class32.chatboxSegments[var6];
                           if(!var17.equals(var15.text)) {
                              var15.text = var17;
                              Tile.method1577(var15);
                           }
                           continue;
                        }

                        if(var42 == 1113) {
                           --var5;
                           var15.field2190 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1114) {
                           var5 -= 3;
                           var15.field2132 = class32.field719[var5];
                           var15.field2070 = class32.field719[var5 + 1];
                           var15.field2086 = class32.field719[var5 + 2];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1115) {
                           --var5;
                           var15.field2173 = class32.field719[var5] == 1;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1116) {
                           --var5;
                           var15.borderThickness = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1117) {
                           --var5;
                           var15.sprite2 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1118) {
                           --var5;
                           var15.flippedVertically = class32.field719[var5] == 1;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1119) {
                           --var5;
                           var15.flippedHorizontally = class32.field719[var5] == 1;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1120) {
                           var5 -= 2;
                           var15.scrollWidth = class32.field719[var5];
                           var15.scrollHeight = class32.field719[1 + var5];
                           Tile.method1577(var15);
                           if(var32 != -1 && var15.type == 0) {
                              class181.method3325(Widget.widgets[var32 >> 16], var15, false);
                           }
                           continue;
                        }

                        if(var42 == 1121) {
                           class7.method104(var15.id, var15.index);
                           Client.field449 = var15;
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1122) {
                           --var5;
                           var15.field2060 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1123) {
                           --var5;
                           var15.field2095 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1124) {
                           --var5;
                           var15.field2145 = class32.field719[var5];
                           Tile.method1577(var15);
                           continue;
                        }

                        if(var42 == 1125) {
                           --var5;
                           var84 = class32.field719[var5];
                           class221[] var30 = new class221[]{class221.field3177, class221.field3179, class221.field3181, class221.field3182, class221.field3180};
                           class221 var19 = (class221)class101.method1985(var30, var84);
                           if(var19 != null) {
                              var15.field2065 = var19;
                              Tile.method1577(var15);
                           }
                           continue;
                        }
                     }
                  } else {
                     var31 = -1;
                     if(var42 >= 2000) {
                        var42 -= 1000;
                        --var5;
                        var31 = class32.field719[var5];
                        var16 = class5.method79(var31);
                     } else {
                        var16 = var54?class47.field929:class32.field723;
                     }

                     if(var42 == 1000) {
                        var5 -= 4;
                        var16.field2078 = class32.field719[var5];
                        var16.field2087 = class32.field719[1 + var5];
                        var16.field2074 = class32.field719[var5 + 2];
                        var16.field2075 = class32.field719[var5 + 3];
                        Tile.method1577(var16);
                        class2.method32(var16);
                        if(var31 != -1 && var16.type == 0) {
                           class181.method3325(Widget.widgets[var31 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var42 == 1001) {
                        var5 -= 4;
                        var16.field2144 = class32.field719[var5];
                        var16.field2081 = class32.field719[1 + var5];
                        var16.field2076 = class32.field719[2 + var5];
                        var16.field2077 = class32.field719[3 + var5];
                        Tile.method1577(var16);
                        class2.method32(var16);
                        if(var31 != -1 && var16.type == 0) {
                           class181.method3325(Widget.widgets[var31 >> 16], var16, false);
                        }
                        continue;
                     }

                     if(var42 == 1003) {
                        --var5;
                        var33 = class32.field719[var5] == 1;
                        if(var16.isHidden != var33) {
                           var16.isHidden = var33;
                           Tile.method1577(var16);
                        }
                        continue;
                     }

                     if(var42 == 1005) {
                        --var5;
                        var16.field2202 = class32.field719[var5] == 1;
                        continue;
                     }

                     if(var42 == 1006) {
                        --var5;
                        var16.field2203 = class32.field719[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var42 < 5400) {
                  if(var42 == 5306) {
                     class32.field719[var5++] = class105.method2061();
                     continue;
                  }

                  if(var42 == 5307) {
                     --var5;
                     var31 = class32.field719[var5];
                     if(var31 == 1 || var31 == 2) {
                        class15.method194(var31);
                     }
                     continue;
                  }

                  if(var42 == 5308) {
                     class32.field719[var5++] = Tile.field1343.field692;
                     continue;
                  }

                  if(var42 == 5309) {
                     --var5;
                     var31 = class32.field719[var5];
                     if(var31 == 1 || var31 == 2) {
                        Tile.field1343.field692 = var31;
                        class3.method42();
                     }
                     continue;
                  }
               }

               if(var42 < 5600) {
                  if(var42 == 5504) {
                     var5 -= 2;
                     var31 = class32.field719[var5];
                     var32 = class32.field719[1 + var5];
                     if(!Client.field533) {
                        Client.field534 = var31;
                        Client.mapAngle = var32;
                     }
                     continue;
                  }

                  if(var42 == 5505) {
                     class32.field719[var5++] = Client.field534;
                     continue;
                  }

                  if(var42 == 5506) {
                     class32.field719[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var42 == 5530) {
                     --var5;
                     var31 = class32.field719[var5];
                     if(var31 < 0) {
                        var31 = 0;
                     }

                     Client.field377 = var31;
                     continue;
                  }

                  if(var42 == 5531) {
                     class32.field719[var5++] = Client.field377;
                     continue;
                  }
               }

               if(var42 < 5700 && var42 == 5630) {
                  Client.field405 = 250;
               } else {
                  if(var42 < 6300) {
                     if(var42 == 6200) {
                        var5 -= 2;
                        Client.field539 = (short)class32.field719[var5];
                        if(Client.field539 <= 0) {
                           Client.field539 = 256;
                        }

                        Client.field456 = (short)class32.field719[1 + var5];
                        if(Client.field456 <= 0) {
                           Client.field456 = 205;
                        }
                        continue;
                     }

                     if(var42 == 6201) {
                        var5 -= 2;
                        Client.field541 = (short)class32.field719[var5];
                        if(Client.field541 <= 0) {
                           Client.field541 = 256;
                        }

                        Client.field458 = (short)class32.field719[var5 + 1];
                        if(Client.field458 <= 0) {
                           Client.field458 = 320;
                        }
                        continue;
                     }

                     if(var42 == 6202) {
                        var5 -= 4;
                        Client.field543 = (short)class32.field719[var5];
                        if(Client.field543 <= 0) {
                           Client.field543 = 1;
                        }

                        Client.field540 = (short)class32.field719[var5 + 1];
                        if(Client.field540 <= 0) {
                           Client.field540 = 32767;
                        } else if(Client.field540 < Client.field543) {
                           Client.field540 = Client.field543;
                        }

                        Client.field545 = (short)class32.field719[2 + var5];
                        if(Client.field545 <= 0) {
                           Client.field545 = 1;
                        }

                        Client.field546 = (short)class32.field719[3 + var5];
                        if(Client.field546 <= 0) {
                           Client.field546 = 32767;
                        } else if(Client.field546 < Client.field545) {
                           Client.field546 = Client.field545;
                        }
                        continue;
                     }

                     if(var42 == 6203) {
                        if(Client.field457 != null) {
                           WidgetNode.method201(0, 0, Client.field457.width, Client.field457.height, false);
                           class32.field719[var5++] = Client.camera2;
                           class32.field719[var5++] = Client.camera3;
                        } else {
                           class32.field719[var5++] = -1;
                           class32.field719[var5++] = -1;
                        }
                        continue;
                     }

                     if(var42 == 6204) {
                        class32.field719[var5++] = Client.field541;
                        class32.field719[var5++] = Client.field458;
                        continue;
                     }

                     if(var42 == 6205) {
                        class32.field719[var5++] = Client.field539;
                        class32.field719[var5++] = Client.field456;
                        continue;
                     }
                  }

                  if(var42 < 6600) {
                     if(var42 == 6500) {
                        class32.field719[var5++] = GroundObject.loadWorlds()?1:0;
                        continue;
                     }

                     World var74;
                     if(var42 == 6501) {
                        World.field673 = 0;
                        if(World.field673 < World.field672) {
                           var74 = World.worldList[++World.field673 - 1];
                        } else {
                           var74 = null;
                        }

                        if(var74 != null) {
                           class32.field719[var5++] = var74.id;
                           class32.field719[var5++] = var74.mask;
                           class32.chatboxSegments[var6++] = var74.activity;
                           class32.field719[var5++] = var74.location;
                           class32.field719[var5++] = var74.playerCount;
                           class32.chatboxSegments[var6++] = var74.address;
                        } else {
                           class32.field719[var5++] = -1;
                           class32.field719[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field719[var5++] = 0;
                           class32.field719[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var42 == 6502) {
                        World var107;
                        if(World.field673 < World.field672) {
                           var107 = World.worldList[++World.field673 - 1];
                        } else {
                           var107 = null;
                        }

                        if(null != var107) {
                           class32.field719[var5++] = var107.id;
                           class32.field719[var5++] = var107.mask;
                           class32.chatboxSegments[var6++] = var107.activity;
                           class32.field719[var5++] = var107.location;
                           class32.field719[var5++] = var107.playerCount;
                           class32.chatboxSegments[var6++] = var107.address;
                        } else {
                           class32.field719[var5++] = -1;
                           class32.field719[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field719[var5++] = 0;
                           class32.field719[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var42 == 6506) {
                        --var5;
                        var31 = class32.field719[var5];
                        var74 = null;

                        for(var84 = 0; var84 < World.field672; ++var84) {
                           if(var31 == World.worldList[var84].id) {
                              var74 = World.worldList[var84];
                              break;
                           }
                        }

                        if(var74 != null) {
                           class32.field719[var5++] = var74.id;
                           class32.field719[var5++] = var74.mask;
                           class32.chatboxSegments[var6++] = var74.activity;
                           class32.field719[var5++] = var74.location;
                           class32.field719[var5++] = var74.playerCount;
                           class32.chatboxSegments[var6++] = var74.address;
                        } else {
                           class32.field719[var5++] = -1;
                           class32.field719[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                           class32.field719[var5++] = 0;
                           class32.field719[var5++] = 0;
                           class32.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var42 == 6507) {
                        var5 -= 4;
                        var31 = class32.field719[var5];
                        var86 = class32.field719[1 + var5] == 1;
                        var84 = class32.field719[2 + var5];
                        var18 = class32.field719[3 + var5] == 1;
                        if(World.worldList != null) {
                           class26.method613(0, World.worldList.length - 1, var31, var86, var84, var18);
                        }
                        continue;
                     }

                     if(var42 == 6511) {
                        --var5;
                        var31 = class32.field719[var5];
                        if(var31 >= 0 && var31 < World.field672) {
                           var74 = World.worldList[var31];
                           class32.field719[var5++] = var74.id;
                           class32.field719[var5++] = var74.mask;
                           class32.chatboxSegments[var6++] = var74.activity;
                           class32.field719[var5++] = var74.location;
                           class32.field719[var5++] = var74.playerCount;
                           class32.chatboxSegments[var6++] = var74.address;
                           continue;
                        }

                        class32.field719[var5++] = -1;
                        class32.field719[var5++] = 0;
                        class32.chatboxSegments[var6++] = "";
                        class32.field719[var5++] = 0;
                        class32.field719[var5++] = 0;
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

            for(var13 = class32.field721 - 1; var13 >= 0; --var13) {
               var40.append("").append(class32.field725[var13].field94.hash).append(" ");
            }

            var40.append("").append(var10);
            class39.reportException(var40.toString(), var41);
         }
      }
   }
}

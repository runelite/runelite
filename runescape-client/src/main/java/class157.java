import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class157 implements class115 {
   @ObfuscatedName("g")
   static final class157 field2341 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("r")
   static final class157 field2342 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("h")
   static final class157 field2344 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("s")
   public static final class157 field2345 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("k")
   public final String field2346;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2021923723
   )
   final int field2347;
   @ObfuscatedName("e")
   static final class157 field2349 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("l")
   static final class157 field2350 = new class157("runescape", "RuneScape", 0);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass27;",
      garbageValue = "1115029881"
   )
   static class27 method3301() {
      class27.field664 = 0;
      return class26.method625();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1633970528"
   )
   public int vmethod3316() {
      return this.field2347;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2346 = var1;
      this.field2347 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass27;I)V",
      garbageValue = "1063959594"
   )
   @Export("selectWorld")
   static void method3303(class27 var0) {
      if(var0.method632() != client.field520) {
         client.field520 = var0.method632();
         class50.method1068(var0.method632());
      }

      class105.field1842 = var0.field670;
      client.field407 = var0.field667;
      client.field561 = var0.field668;
      class12.field198 = client.field297 == 0?'ꩊ':'鱀' + var0.field667;
      class56.field1235 = client.field297 == 0?443:var0.field667 + '썐';
      class109.field1943 = class12.field198;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   public static int method3307(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIIIII)V",
      garbageValue = "-2112531779"
   )
   static final void method3310(class39 var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod794()) {
         if(var0 instanceof class36) {
            class41 var6 = ((class36)var0).field803;
            if(var6.field937 != null) {
               var6 = var6.method820();
            }

            if(null == var6) {
               return;
            }
         }

         int var78 = class34.field783;
         int[] var7 = class34.field784;
         int var8 = 3;
         int var14;
         int var21;
         if(!var0.field870.method4017()) {
            class26.method629(var0, 15 + var0.field837);

            for(class26 var9 = (class26)var0.field870.method4011(); var9 != null; var9 = (class26)var0.field870.method4013()) {
               class20 var74 = var9.method627(client.field305);
               if(null == var74) {
                  if(var9.method619()) {
                     var9.method4067();
                  }
               } else {
                  class49 var11 = var9.field655;
                  class81 var12 = var11.method1039();
                  class81 var13 = var11.method1053();
                  if(var12 != null && var13 != null) {
                     var14 = var13.field1482;
                  } else {
                     var14 = var11.field1110;
                  }

                  int var76 = 255;
                  boolean var16 = true;
                  int var17 = client.field305 - var74.field583;
                  int var18 = var74.field579 * var14 / var11.field1110;
                  int var20;
                  int var77;
                  int var88;
                  if(var74.field577 > var17) {
                     var77 = var11.field1107 == 0?0:var11.field1107 * (var17 / var11.field1107);
                     var20 = var14 * var74.field578 / var11.field1110;
                     var88 = var20 + (var18 - var20) * var77 / var74.field577;
                  } else {
                     var88 = var18;
                     var77 = var11.field1108 + var74.field577 - var17;
                     if(var11.field1111 >= 0) {
                        var76 = (var77 << 8) / (var11.field1108 - var11.field1111);
                     }
                  }

                  if(var74.field579 > 0 && var88 < 2) {
                     var88 = 2;
                  }

                  var77 = var2 + client.field401 - (var14 >> 1);
                  var20 = var3 + client.field402 - var8;
                  if(var12 != null && var13 != null) {
                     var21 = var12.field1479;
                     var8 += var21;
                     if(var76 >= 0 && var76 < 255) {
                        var12.method1812(var77, var20, var76);
                        class82.method1941(var77, var20, var88 + var77, var21 + var20);
                        var13.method1812(var77, var20, var76);
                     } else {
                        var12.method1824(var77, var20);
                        class82.method1941(var77, var20, var88 + var77, var21 + var20);
                        var13.method1824(var77, var20);
                     }

                     class82.method1908(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(client.field401 > -1) {
                        class82.method1907(var77, var20, var88, 5, '\uff00');
                        class82.method1907(var88 + var77, var20, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var78) {
            class2 var85 = (class2)var0;
            if(var85.field51) {
               return;
            }

            if(var85.field30 != -1 || var85.field33 != -1) {
               class26.method629(var0, 15 + var0.field837);
               if(client.field401 > -1) {
                  if(var85.field30 != -1) {
                     class2.field57[var85.field30].method1824(var2 + client.field401 - 12, client.field402 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.field33 != -1) {
                     class125.field2066[var85.field33].method1824(var2 + client.field401 - 12, var3 + client.field402 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field313 == 10 && var7[var1] == client.field315) {
               class26.method629(var0, var0.field837 + 15);
               if(client.field401 > -1) {
                  class158.field2353[1].method1824(client.field401 + var2 - 12, client.field402 + var3 - var8);
               }
            }
         } else {
            class41 var86 = ((class36)var0).field803;
            if(var86.field937 != null) {
               var86 = var86.method820();
            }

            if(var86.field935 >= 0 && var86.field935 < class125.field2066.length) {
               class26.method629(var0, 15 + var0.field837);
               if(client.field401 > -1) {
                  class125.field2066[var86.field935].method1824(client.field401 + var2 - 12, client.field402 + var3 - 30);
               }
            }

            if(client.field313 == 1 && client.field314 == client.field334[var1 - var78] && client.field305 % 20 < 10) {
               class26.method629(var0, var0.field837 + 15);
               if(client.field401 > -1) {
                  class158.field2353[0].method1824(var2 + client.field401 - 12, client.field402 + var3 - 28);
               }
            }
         }

         if(null != var0.field835 && (var1 >= var78 || !var0.field852 && (client.field511 == 4 || !var0.field845 && (client.field511 == 0 || client.field511 == 3 || client.field511 == 1 && class145.method3128(((class2)var0).field58, false))))) {
            class26.method629(var0, var0.field837);
            if(client.field401 > -1 && client.field389 < client.field408) {
               client.field394[client.field389] = class59.field1268.method4165(var0.field835) / 2;
               client.field505[client.field389] = class59.field1268.field3235;
               client.field380[client.field389] = client.field401;
               client.field330[client.field389] = client.field402;
               client.field395[client.field389] = var0.field885;
               client.field396[client.field389] = var0.field881;
               client.field516[client.field389] = var0.field847;
               client.field398[client.field389] = var0.field835;
               ++client.field389;
            }
         }

         for(int var75 = 0; var75 < 4; ++var75) {
            int var10 = var0.field842[var75];
            int var80 = var0.field851[var75];
            class51 var87 = null;
            int var84 = 0;
            if(var80 >= 0) {
               if(var10 <= client.field305) {
                  continue;
               }

               var87 = class5.method52(var0.field851[var75]);
               var84 = var87.field1135;
            } else if(var10 < 0) {
               continue;
            }

            var14 = var0.field854[var75];
            class51 var15 = null;
            if(var14 >= 0) {
               var15 = class5.method52(var14);
            }

            if(var10 - var84 <= client.field305) {
               if(null == var87) {
                  var0.field842[var75] = -1;
               } else {
                  class26.method629(var0, var0.field837 / 2);
                  if(client.field401 > -1) {
                     if(var75 == 1) {
                        client.field402 -= 20;
                     }

                     if(var75 == 2) {
                        client.field401 -= 15;
                        client.field402 -= 10;
                     }

                     if(var75 == 3) {
                        client.field401 += 15;
                        client.field402 -= 10;
                     }

                     class81 var81 = null;
                     class81 var83 = null;
                     class81 var19 = null;
                     class81 var82 = null;
                     var21 = 0;
                     int var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     class81 var29 = null;
                     class81 var30 = null;
                     class81 var31 = null;
                     class81 var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var81 = var87.method1099();
                     int var42;
                     if(var81 != null) {
                        var21 = var81.field1482;
                        var42 = var81.field1479;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var81.field1480;
                     }

                     var83 = var87.method1101();
                     if(var83 != null) {
                        var22 = var83.field1482;
                        var42 = var83.field1479;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var83.field1480;
                     }

                     var19 = var87.method1084();
                     if(var19 != null) {
                        var23 = var19.field1482;
                        var42 = var19.field1479;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var19.field1480;
                     }

                     var82 = var87.method1085();
                     if(var82 != null) {
                        var24 = var82.field1482;
                        var42 = var82.field1479;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var82.field1480;
                     }

                     if(var15 != null) {
                        var29 = var15.method1099();
                        if(null != var29) {
                           var33 = var29.field1482;
                           var42 = var29.field1479;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field1480;
                        }

                        var30 = var15.method1101();
                        if(null != var30) {
                           var34 = var30.field1482;
                           var42 = var30.field1479;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field1480;
                        }

                        var31 = var15.method1084();
                        if(var31 != null) {
                           var35 = var31.field1482;
                           var42 = var31.field1479;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field1480;
                        }

                        var32 = var15.method1085();
                        if(null != var32) {
                           var36 = var32.field1482;
                           var42 = var32.field1479;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field1480;
                        }
                     }

                     class227 var79 = var87.method1094();
                     if(var79 == null) {
                        var79 = class7.field133;
                     }

                     class227 var43;
                     if(var15 != null) {
                        var43 = var15.method1094();
                        if(null == var43) {
                           var43 = class7.field133;
                        }
                     } else {
                        var43 = class7.field133;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method1081(var0.field833[var75]);
                     int var89 = var79.method4165(var44);
                     if(null != var15) {
                        var45 = var15.method1081(var0.field855[var75]);
                        var47 = var43.method4165(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var19 && var82 == null) {
                           var48 = 1;
                        } else {
                           var48 = 1 + var89 / var22;
                        }
                     }

                     if(null != var15 && var34 > 0) {
                        if(null == var31 && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var47 / var34;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var15 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var34 * var49;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field842[var75] - client.field305;
                     int var62 = var87.field1140 - var87.field1140 * var61 / var87.field1135;
                     int var63 = var61 * var87.field1150 / var87.field1135 + -var87.field1150;
                     int var64 = var62 + (client.field401 + var2 - (var50 >> 1));
                     int var65 = var63 + (var3 + client.field402 - 12);
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var65 + 15 + var87.field1145;
                     int var69 = var68 - var79.field3236;
                     int var70 = var79.field3237 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var15 != null) {
                        var71 = var65 + 15 + var15.field1145;
                        var72 = var71 - var43.field3236;
                        var73 = var43.field3237 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field1142 >= 0) {
                        var72 = (var61 << 8) / (var87.field1135 - var87.field1142);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var81 != null) {
                           var81.method1812(var51 + var64 - var25, var65, var72);
                        }

                        if(var19 != null) {
                           var19.method1812(var64 + var52 - var27, var65, var72);
                        }

                        if(null != var83) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method1812(var73 * var22 + (var64 + var53 - var26), var65, var72);
                           }
                        }

                        if(var82 != null) {
                           var82.method1812(var55 + var64 - var28, var65, var72);
                        }

                        var79.method4227(var44, var64 + var54, var68, var87.field1133, 0, var72);
                        if(null != var15) {
                           if(var29 != null) {
                              var29.method1812(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method1812(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1812(var58 + var64 - var38 + var73 * var34, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method1812(var59 + var64 - var40, var65, var72);
                           }

                           var43.method4227(var45, var60 + var64, var71, var15.field1133, 0, var72);
                        }
                     } else {
                        if(var81 != null) {
                           var81.method1824(var64 + var51 - var25, var65);
                        }

                        if(null != var19) {
                           var19.method1824(var52 + var64 - var27, var65);
                        }

                        if(var83 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var83.method1824(var22 * var73 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(null != var82) {
                           var82.method1824(var64 + var55 - var28, var65);
                        }

                        var79.method4170(var44, var64 + var54, var68, var87.field1133 | -16777216, 0);
                        if(null != var15) {
                           if(var29 != null) {
                              var29.method1824(var56 + var64 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method1824(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1824(var58 + var64 - var38 + var34 * var73, var65);
                              }
                           }

                           if(null != var32) {
                              var32.method1824(var59 + var64 - var40, var65);
                           }

                           var43.method4170(var45, var60 + var64, var71, var15.field1133 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}

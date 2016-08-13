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
      signature = "(I)LWorld;",
      garbageValue = "1115029881"
   )
   static World method3301() {
      World.field664 = 0;
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
      signature = "(LWorld;I)V",
      garbageValue = "1063959594"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method632() != Client.isMembers) {
         Client.isMembers = var0.method632();
         class50.method1068(var0.method632());
      }

      FrameMap.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class12.field198 = Client.field297 == 0?'ꩊ':'鱀' + var0.id;
      class56.field1235 = Client.field297 == 0?443:var0.id + '썐';
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
      signature = "(LActor;IIIIII)V",
      garbageValue = "-2112531779"
   )
   static final void method3310(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod794()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.field937 != null) {
               var6 = var6.method820();
            }

            if(null == var6) {
               return;
            }
         }

         int var75 = class34.field783;
         int[] var7 = class34.field784;
         int var8 = 3;
         int var9;
         int var10;
         int var21;
         int var22;
         if(!var0.field870.method4017()) {
            class26.method629(var0, 15 + var0.field837);

            for(class26 var11 = (class26)var0.field870.method4011(); var11 != null; var11 = (class26)var0.field870.method4013()) {
               class20 var12 = var11.method627(Client.gameCycle);
               if(null == var12) {
                  if(var11.method619()) {
                     var11.unlink();
                  }
               } else {
                  class49 var13 = var11.field655;
                  SpritePixels var14 = var13.method1039();
                  SpritePixels var15 = var13.method1053();
                  if(var14 != null && var15 != null) {
                     var9 = var15.width;
                  } else {
                     var9 = var13.field1110;
                  }

                  int var16 = 255;
                  boolean var17 = true;
                  int var18 = Client.gameCycle - var12.field583;
                  int var19 = var12.field579 * var9 / var13.field1110;
                  int var20;
                  if(var12.field577 > var18) {
                     var21 = var13.field1107 == 0?0:var13.field1107 * (var18 / var13.field1107);
                     var20 = var9 * var12.field578 / var13.field1110;
                     var22 = var20 + (var19 - var20) * var21 / var12.field577;
                  } else {
                     var22 = var19;
                     var21 = var13.field1108 + var12.field577 - var18;
                     if(var13.field1111 >= 0) {
                        var16 = (var21 << 8) / (var13.field1108 - var13.field1111);
                     }
                  }

                  if(var12.field579 > 0 && var22 < 2) {
                     var22 = 2;
                  }

                  var21 = var2 + Client.field401 - (var9 >> 1);
                  var20 = var3 + Client.field402 - var8;
                  if(var14 != null && var15 != null) {
                     var10 = var14.height;
                     var8 += var10;
                     if(var16 >= 0 && var16 < 255) {
                        var14.method1812(var21, var20, var16);
                        class82.method1941(var21, var20, var22 + var21, var10 + var20);
                        var15.method1812(var21, var20, var16);
                     } else {
                        var14.method1824(var21, var20);
                        class82.method1941(var21, var20, var22 + var21, var10 + var20);
                        var15.method1824(var21, var20);
                     }

                     class82.method1908(var2, var3, var2 + var4, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field401 > -1) {
                        class82.method1907(var21, var20, var22, 5, '\uff00');
                        class82.method1907(var22 + var21, var20, var9 - var22, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var75) {
            Player var78 = (Player)var0;
            if(var78.field51) {
               return;
            }

            if(var78.field30 != -1 || var78.field33 != -1) {
               class26.method629(var0, 15 + var0.field837);
               if(Client.field401 > -1) {
                  if(var78.field30 != -1) {
                     Player.field57[var78.field30].method1824(var2 + Client.field401 - 12, Client.field402 + var3 - var8);
                     var8 += 25;
                  }

                  if(var78.field33 != -1) {
                     class125.field2066[var78.field33].method1824(var2 + Client.field401 - 12, var3 + Client.field402 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field313 == 10 && var7[var1] == Client.field315) {
               class26.method629(var0, var0.field837 + 15);
               if(Client.field401 > -1) {
                  class158.field2353[1].method1824(Client.field401 + var2 - 12, Client.field402 + var3 - var8);
               }
            }
         } else {
            NPCComposition var76 = ((NPC)var0).composition;
            if(var76.field937 != null) {
               var76 = var76.method820();
            }

            if(var76.field935 >= 0 && var76.field935 < class125.field2066.length) {
               class26.method629(var0, 15 + var0.field837);
               if(Client.field401 > -1) {
                  class125.field2066[var76.field935].method1824(Client.field401 + var2 - 12, Client.field402 + var3 - 30);
               }
            }

            if(Client.field313 == 1 && Client.field314 == Client.field334[var1 - var75] && Client.gameCycle % 20 < 10) {
               class26.method629(var0, var0.field837 + 15);
               if(Client.field401 > -1) {
                  class158.field2353[0].method1824(var2 + Client.field401 - 12, Client.field402 + var3 - 28);
               }
            }
         }

         if(null != var0.overhead && (var1 >= var75 || !var0.inSequence && (Client.field511 == 4 || !var0.field845 && (Client.field511 == 0 || Client.field511 == 3 || Client.field511 == 1 && class145.method3128(((Player)var0).name, false))))) {
            class26.method629(var0, var0.field837);
            if(Client.field401 > -1 && Client.field389 < Client.field408) {
               Client.field394[Client.field389] = class59.field1268.method4165(var0.overhead) / 2;
               Client.field505[Client.field389] = class59.field1268.field3235;
               Client.field380[Client.field389] = Client.field401;
               Client.field330[Client.field389] = Client.field402;
               Client.field395[Client.field389] = var0.field885;
               Client.field396[Client.field389] = var0.field881;
               Client.field516[Client.field389] = var0.field847;
               Client.field398[Client.field389] = var0.overhead;
               ++Client.field389;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var77 = var0.field842[var79];
            int var80 = var0.field851[var79];
            class51 var81 = null;
            int var82 = 0;
            if(var80 >= 0) {
               if(var77 <= Client.gameCycle) {
                  continue;
               }

               var81 = class5.method52(var0.field851[var79]);
               var82 = var81.field1135;
            } else if(var77 < 0) {
               continue;
            }

            var9 = var0.field854[var79];
            class51 var83 = null;
            if(var9 >= 0) {
               var83 = class5.method52(var9);
            }

            if(var77 - var82 <= Client.gameCycle) {
               if(null == var81) {
                  var0.field842[var79] = -1;
               } else {
                  class26.method629(var0, var0.field837 / 2);
                  if(Client.field401 > -1) {
                     if(var79 == 1) {
                        Client.field402 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field401 -= 15;
                        Client.field402 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field401 += 15;
                        Client.field402 -= 10;
                     }

                     SpritePixels var84 = null;
                     SpritePixels var85 = null;
                     SpritePixels var86 = null;
                     SpritePixels var87 = null;
                     var10 = 0;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     SpritePixels var28 = null;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     int var32 = 0;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     var84 = var81.method1099();
                     int var41;
                     if(var84 != null) {
                        var10 = var84.width;
                        var41 = var84.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var24 = var84.field1480;
                     }

                     var85 = var81.method1101();
                     if(var85 != null) {
                        var21 = var85.width;
                        var41 = var85.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var25 = var85.field1480;
                     }

                     var86 = var81.method1084();
                     if(var86 != null) {
                        var22 = var86.width;
                        var41 = var86.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var26 = var86.field1480;
                     }

                     var87 = var81.method1085();
                     if(var87 != null) {
                        var23 = var87.width;
                        var41 = var87.height;
                        if(var41 > var40) {
                           var40 = var41;
                        }

                        var27 = var87.field1480;
                     }

                     if(var83 != null) {
                        var28 = var83.method1099();
                        if(null != var28) {
                           var32 = var28.width;
                           var41 = var28.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var36 = var28.field1480;
                        }

                        var29 = var83.method1101();
                        if(null != var29) {
                           var33 = var29.width;
                           var41 = var29.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var37 = var29.field1480;
                        }

                        var30 = var83.method1084();
                        if(var30 != null) {
                           var34 = var30.width;
                           var41 = var30.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var38 = var30.field1480;
                        }

                        var31 = var83.method1085();
                        if(null != var31) {
                           var35 = var31.width;
                           var41 = var31.height;
                           if(var41 > var40) {
                              var40 = var41;
                           }

                           var39 = var31.field1480;
                        }
                     }

                     class227 var42 = var81.method1094();
                     if(var42 == null) {
                        var42 = Ignore.field133;
                     }

                     class227 var43;
                     if(var83 != null) {
                        var43 = var83.method1094();
                        if(null == var43) {
                           var43 = Ignore.field133;
                        }
                     } else {
                        var43 = Ignore.field133;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var81.method1081(var0.field833[var79]);
                     int var48 = var42.method4165(var44);
                     if(null != var83) {
                        var45 = var83.method1081(var0.field855[var79]);
                        var47 = var43.method4165(var45);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if(var21 > 0) {
                        if(null == var86 && var87 == null) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var48 / var21;
                        }
                     }

                     if(null != var83 && var33 > 0) {
                        if(null == var30 && var31 == null) {
                           var50 = 1;
                        } else {
                           var50 = 1 + var47 / var33;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if(var10 > 0) {
                        var51 += var10;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if(var22 > 0) {
                        var51 += var22;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if(var21 > 0) {
                        var56 = var21 * var49;
                        var51 += var56;
                        var55 += (var56 - var48) / 2;
                     } else {
                        var51 += var48;
                     }

                     var56 = var51;
                     if(var23 > 0) {
                        var51 += var23;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if(var83 != null) {
                        var51 += 2;
                        var57 = var51;
                        if(var32 > 0) {
                           var51 += var32;
                        }

                        var51 += 2;
                        var58 = var51;
                        if(var34 > 0) {
                           var51 += var34;
                        }

                        var59 = var51;
                        var61 = var51;
                        if(var33 > 0) {
                           var62 = var33 * var50;
                           var51 += var62;
                           var61 += (var62 - var47) / 2;
                        } else {
                           var51 += var47;
                        }

                        var60 = var51;
                        if(var35 > 0) {
                           var51 += var35;
                        }
                     }

                     var62 = var0.field842[var79] - Client.gameCycle;
                     int var63 = var81.field1140 - var81.field1140 * var62 / var81.field1135;
                     int var64 = var62 * var81.field1150 / var81.field1135 + -var81.field1150;
                     int var65 = var63 + (Client.field401 + var2 - (var51 >> 1));
                     int var66 = var64 + (var3 + Client.field402 - 12);
                     int var67 = var66;
                     int var68 = var40 + var66;
                     int var69 = var66 + 15 + var81.field1145;
                     int var70 = var69 - var42.field3236;
                     int var71 = var42.field3237 + var69;
                     if(var70 < var66) {
                        var67 = var70;
                     }

                     if(var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if(var83 != null) {
                        var72 = var66 + 15 + var83.field1145;
                        var73 = var72 - var43.field3236;
                        var74 = var43.field3237 + var72;
                        if(var73 < var67) {
                           ;
                        }

                        if(var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if(var81.field1142 >= 0) {
                        var73 = (var62 << 8) / (var81.field1135 - var81.field1142);
                     }

                     if(var73 >= 0 && var73 < 255) {
                        if(var84 != null) {
                           var84.method1812(var52 + var65 - var24, var66, var73);
                        }

                        if(var86 != null) {
                           var86.method1812(var65 + var53 - var26, var66, var73);
                        }

                        if(null != var85) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method1812(var74 * var21 + (var65 + var54 - var25), var66, var73);
                           }
                        }

                        if(var87 != null) {
                           var87.method1812(var56 + var65 - var27, var66, var73);
                        }

                        var42.method4227(var44, var65 + var55, var69, var81.field1133, 0, var73);
                        if(null != var83) {
                           if(var28 != null) {
                              var28.method1812(var65 + var57 - var36, var66, var73);
                           }

                           if(var30 != null) {
                              var30.method1812(var58 + var65 - var38, var66, var73);
                           }

                           if(var29 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method1812(var59 + var65 - var37 + var74 * var33, var66, var73);
                              }
                           }

                           if(var31 != null) {
                              var31.method1812(var60 + var65 - var39, var66, var73);
                           }

                           var43.method4227(var45, var61 + var65, var72, var83.field1133, 0, var73);
                        }
                     } else {
                        if(var84 != null) {
                           var84.method1824(var65 + var52 - var24, var66);
                        }

                        if(null != var86) {
                           var86.method1824(var53 + var65 - var26, var66);
                        }

                        if(var85 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var85.method1824(var21 * var74 + (var54 + var65 - var25), var66);
                           }
                        }

                        if(null != var87) {
                           var87.method1824(var65 + var56 - var27, var66);
                        }

                        var42.method4170(var44, var65 + var55, var69, var81.field1133 | -16777216, 0);
                        if(null != var83) {
                           if(var28 != null) {
                              var28.method1824(var57 + var65 - var36, var66);
                           }

                           if(null != var30) {
                              var30.method1824(var65 + var58 - var38, var66);
                           }

                           if(var29 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var29.method1824(var59 + var65 - var37 + var33 * var74, var66);
                              }
                           }

                           if(null != var31) {
                              var31.method1824(var60 + var65 - var39, var66);
                           }

                           var43.method4170(var45, var61 + var65, var72, var83.field1133 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("q")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1886807931
   )
   @Export("world")
   int world;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1180823103
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("v")
   boolean field246;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -159505381
   )
   static int field248;
   @ObfuscatedName("j")
   boolean field249;

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-9"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field324.method2828(95);
            Client.field324.method2700(class140.field2163[82]?1:0);
            Client.field324.method2756(var3);
         }
      }

      if(var2 == 34) {
         Client.field324.method2828(57);
         Client.field324.method2603(var0);
         Client.field324.method2615(var1);
         Client.field324.method2605(var3);
         Client.field393 = 0;
         class53.field1157 = class144.method3012(var1);
         Client.field394 = var0;
      }

      if(var2 == 45) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field324.method2828(224);
            Client.field324.method2700(class140.field2163[82]?1:0);
            Client.field324.method2756(var3);
         }
      }

      NPC var16;
      if(var2 == 12) {
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field324.method2828(135);
            Client.field324.method2596(class140.field2163[82]?1:0);
            Client.field324.method2605(var3);
         }
      }

      Widget var17;
      if(var2 == 38) {
         class212.method3959();
         var17 = class144.method3012(var1);
         Client.field497 = 1;
         class12.field184 = var0;
         class20.field569 = var1;
         class141.field2187 = var3;
         class166.method3253(var17);
         Client.field434 = class144.method3013(16748608) + class22.getItemDefinition(var3).name + class144.method3013(16777215);
         if(null == Client.field434) {
            Client.field434 = "null";
         }

      } else {
         if(var2 == 1001) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field324.method2828(33);
            Client.field324.method2573(class140.field2163[82]?1:0);
            Client.field324.method2638(class47.baseX + var0);
            Client.field324.method2756(var3 >> 14 & 32767);
            Client.field324.method2605(class21.baseY + var1);
         }

         if(var2 == 1003) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            var16 = Client.cachedNPCs[var3];
            if(null != var16) {
               NPCComposition var13 = var16.composition;
               if(null != var13.field923) {
                  var13 = var13.method801();
               }

               if(var13 != null) {
                  Client.field324.method2828(55);
                  Client.field324.method2638(var13.id);
               }
            }
         }

         if(var2 == 1004) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.field324.method2828(141);
            Client.field324.method2756(var3);
         }

         if(var2 == 18) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field324.method2828(30);
            Client.field324.method2638(var3);
            Client.field324.method2573(class140.field2163[82]?1:0);
            Client.field324.method2603(var1 + class21.baseY);
            Client.field324.method2605(class47.baseX + var0);
         }

         int var9;
         if(var2 == 28) {
            Client.field324.method2828(47);
            Client.field324.method2559(var1);
            var17 = class144.method3012(var1);
            if(null != var17.dynamicValues && var17.dynamicValues[0][0] == 5) {
               var9 = var17.dynamicValues[0][1];
               class179.widgetSettings[var9] = 1 - class179.widgetSettings[var9];
               class10.method119(var9);
            }
         }

         if(var2 == 4) {
            Client.field320 = var6;
            Client.field390 = var7;
            Client.field326 = 2;
            Client.field389 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field324.method2828(46);
            Client.field324.method2605(var0 + class47.baseX);
            Client.field324.method2756(var3 >> 14 & 32767);
            Client.field324.method2605(class21.baseY + var1);
            Client.field324.method2556(class140.field2163[82]?1:0);
         }

         if(var2 == 49) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(146);
               Client.field324.method2573(class140.field2163[82]?1:0);
               Client.field324.method2638(var3);
            }
         }

         if(var2 == 33) {
            Client.field324.method2828(138);
            Client.field324.method2638(var3);
            Client.field324.method2615(var1);
            Client.field324.method2605(var0);
            Client.field393 = 0;
            class53.field1157 = class144.method3012(var1);
            Client.field394 = var0;
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(128);
               Client.field324.method2638(var3);
               Client.field324.method2573(class140.field2163[82]?1:0);
            }
         }

         if(var2 == 32) {
            Client.field324.method2828(5);
            Client.field324.method2605(var3);
            Client.field324.method2605(var0);
            Client.field324.method2605(Client.field436);
            Client.field324.method2615(class85.field1490);
            Client.field324.method2613(var1);
            Client.field393 = 0;
            class53.field1157 = class144.method3012(var1);
            Client.field394 = var0;
         }

         if(var2 == 7) {
            var16 = Client.cachedNPCs[var3];
            if(null != var16) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(127);
               Client.field324.method2605(class141.field2187);
               Client.field324.method2605(var3);
               Client.field324.method2556(class140.field2163[82]?1:0);
               Client.field324.method2603(class12.field184);
               Client.field324.method2613(class20.field569);
            }
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(204);
               Client.field324.method2603(var3);
               Client.field324.method2556(class140.field2163[82]?1:0);
            }
         }

         if(var2 == 25) {
            var17 = class162.method3195(var1, var0);
            if(var17 != null) {
               class212.method3959();
               int var12 = FrameMap.method2356(var17);
               int var19 = var12 >> 11 & 63;
               class79.method1694(var1, var0, var19, var17.item);
               Client.field497 = 0;
               Client.field328 = class18.method186(var17);
               if(Client.field328 == null) {
                  Client.field328 = "Null";
               }

               if(var17.field2815) {
                  Client.field439 = var17.name + class144.method3013(16777215);
               } else {
                  Client.field439 = class144.method3013('\uff00') + var17.field2868 + class144.method3013(16777215);
               }
            }

         } else {
            if(var2 == 31) {
               Client.field324.method2828(132);
               Client.field324.method2603(var3);
               Client.field324.method2638(var0);
               Client.field324.method2605(class141.field2187);
               Client.field324.method2559(var1);
               Client.field324.method2638(class12.field184);
               Client.field324.method2613(class20.field569);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 46) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(90);
                  Client.field324.method2605(var3);
                  Client.field324.method2596(class140.field2163[82]?1:0);
               }
            }

            if(var2 == 35) {
               Client.field324.method2828(134);
               Client.field324.method2603(var0);
               Client.field324.method2605(var3);
               Client.field324.method2614(var1);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 42) {
               Client.field324.method2828(160);
               Client.field324.method2605(var3);
               Client.field324.method2615(var1);
               Client.field324.method2603(var0);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 1002) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.field324.method2828(221);
               Client.field324.method2605(var3 >> 14 & 32767);
            }

            if(var2 == 14) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(86);
                  Client.field324.method2756(var3);
                  Client.field324.method2573(class140.field2163[82]?1:0);
                  Client.field324.method2603(class141.field2187);
                  Client.field324.method2615(class20.field569);
                  Client.field324.method2638(class12.field184);
               }
            }

            if(var2 == 3) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(211);
               Client.field324.method2756(class21.baseY + var1);
               Client.field324.method2603(class47.baseX + var0);
               Client.field324.method2573(class140.field2163[82]?1:0);
               Client.field324.method2605(var3 >> 14 & 32767);
            }

            if(var2 == 51) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(171);
                  Client.field324.method2605(var3);
                  Client.field324.method2596(class140.field2163[82]?1:0);
               }
            }

            if(var2 == 15) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(66);
                  Client.field324.method2756(var3);
                  Client.field324.method2614(class85.field1490);
                  Client.field324.method2756(Client.field436);
                  Client.field324.method2556(class140.field2163[82]?1:0);
               }
            }

            if(var2 == 2) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(64);
               Client.field324.method2638(class47.baseX + var0);
               Client.field324.method2596(class140.field2163[82]?1:0);
               Client.field324.method2756(var3 >> 14 & 32767);
               Client.field324.method2638(var1 + class21.baseY);
               Client.field324.method2615(class85.field1490);
               Client.field324.method2603(Client.field436);
            }

            if(var2 == 19) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(205);
               Client.field324.method2603(var3);
               Client.field324.method2603(var0 + class47.baseX);
               Client.field324.method2573(class140.field2163[82]?1:0);
               Client.field324.method2638(var1 + class21.baseY);
            }

            if(var2 == 26) {
               class53.method1097();
            }

            if(var2 == 17) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(71);
               Client.field324.method2556(class140.field2163[82]?1:0);
               Client.field324.method2638(var0 + class47.baseX);
               Client.field324.method2603(var3);
               Client.field324.method2605(var1 + class21.baseY);
               Client.field324.method2638(Client.field436);
               Client.field324.method2613(class85.field1490);
            }

            if(var2 == 29) {
               Client.field324.method2828(47);
               Client.field324.method2559(var1);
               var17 = class144.method3012(var1);
               if(var17.dynamicValues != null && var17.dynamicValues[0][0] == 5) {
                  var9 = var17.dynamicValues[0][1];
                  if(class179.widgetSettings[var9] != var17.field2912[0]) {
                     class179.widgetSettings[var9] = var17.field2912[0];
                     class10.method119(var9);
                  }
               }
            }

            if(var2 == 6) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(149);
               Client.field324.method2638(var3 >> 14 & 32767);
               Client.field324.method2573(class140.field2163[82]?1:0);
               Client.field324.method2638(var0 + class47.baseX);
               Client.field324.method2603(var1 + class21.baseY);
            }

            if(var2 == 39) {
               Client.field324.method2828(155);
               Client.field324.method2605(var0);
               Client.field324.method2605(var3);
               Client.field324.method2615(var1);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 5) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(27);
               Client.field324.method2603(var3 >> 14 & 32767);
               Client.field324.method2596(class140.field2163[82]?1:0);
               Client.field324.method2603(class21.baseY + var1);
               Client.field324.method2605(var0 + class47.baseX);
            }

            if(var2 == 41) {
               Client.field324.method2828(133);
               Client.field324.method2603(var0);
               Client.field324.method2559(var1);
               Client.field324.method2638(var3);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 23) {
               Frames.region.method2146(class145.plane, var0, var1);
            }

            if(var2 == 9) {
               var16 = Client.cachedNPCs[var3];
               if(var16 != null) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(245);
                  Client.field324.method2638(var3);
                  Client.field324.method2596(class140.field2163[82]?1:0);
               }
            }

            if(var2 == 50) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(115);
                  Client.field324.method2556(class140.field2163[82]?1:0);
                  Client.field324.method2603(var3);
               }
            }

            if(var2 == 10) {
               var16 = Client.cachedNPCs[var3];
               if(null != var16) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(69);
                  Client.field324.method2756(var3);
                  Client.field324.method2556(class140.field2163[82]?1:0);
               }
            }

            if(var2 == 1) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(176);
               Client.field324.method2559(class20.field569);
               Client.field324.method2638(class141.field2187);
               Client.field324.method2605(var3 >> 14 & 32767);
               Client.field324.method2638(class12.field184);
               Client.field324.method2638(class47.baseX + var0);
               Client.field324.method2573(class140.field2163[82]?1:0);
               Client.field324.method2605(class21.baseY + var1);
            }

            if(var2 == 43) {
               Client.field324.method2828(180);
               Client.field324.method2613(var1);
               Client.field324.method2605(var0);
               Client.field324.method2603(var3);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 57 || var2 == 1007) {
               var17 = class162.method3195(var1, var0);
               if(var17 != null) {
                  var9 = var17.item;
                  Widget var14 = class162.method3195(var1, var0);
                  if(var14 != null) {
                     if(null != var14.field2898) {
                        class0 var15 = new class0();
                        var15.field11 = var14;
                        var15.field2 = var3;
                        var15.field9 = var5;
                        var15.field0 = var14.field2898;
                        SecondaryBufferProvider.method1661(var15);
                     }

                     boolean var11 = true;
                     if(var14.contentType > 0) {
                        var11 = class174.method3415(var14);
                     }

                     if(var11 && VertexNormal.method2268(FrameMap.method2356(var14), var3 - 1)) {
                        if(var3 == 1) {
                           Client.field324.method2828(72);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 2) {
                           Client.field324.method2828(38);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 3) {
                           Client.field324.method2828(153);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 4) {
                           Client.field324.method2828(198);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 5) {
                           Client.field324.method2828(32);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 6) {
                           Client.field324.method2828(79);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 7) {
                           Client.field324.method2828(206);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 8) {
                           Client.field324.method2828(105);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 9) {
                           Client.field324.method2828(244);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }

                        if(var3 == 10) {
                           Client.field324.method2828(98);
                           Client.field324.method2559(var1);
                           Client.field324.method2638(var0);
                           Client.field324.method2638(var9);
                        }
                     }
                  }
               }
            }

            if(var2 == 1005) {
               var17 = class144.method3012(var1);
               if(var17 != null && var17.itemQuantities[var0] >= 100000) {
                  Widget.sendGameMessage(27, "", var17.itemQuantities[var0] + " x " + class22.getItemDefinition(var3).name);
               } else {
                  Client.field324.method2828(141);
                  Client.field324.method2756(var3);
               }

               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 37) {
               Client.field324.method2828(100);
               Client.field324.method2559(var1);
               Client.field324.method2756(var3);
               Client.field324.method2638(var0);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 30 && Client.field361 == null) {
               class59.method1270(var1, var0);
               Client.field361 = class162.method3195(var1, var0);
               class166.method3253(Client.field361);
            }

            if(var2 == 58) {
               var17 = class162.method3195(var1, var0);
               if(var17 != null) {
                  Client.field324.method2828(65);
                  Client.field324.method2603(Client.field436);
                  Client.field324.method2613(class85.field1490);
                  Client.field324.method2559(var1);
                  Client.field324.method2603(var0);
                  Client.field324.method2638(Client.field299);
                  Client.field324.method2603(var17.item);
               }
            }

            if(var2 == 8) {
               var16 = Client.cachedNPCs[var3];
               if(var16 != null) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(2);
                  Client.field324.method2756(Client.field436);
                  Client.field324.method2700(class140.field2163[82]?1:0);
                  Client.field324.method2559(class85.field1490);
                  Client.field324.method2603(var3);
               }
            }

            if(var2 == 21) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(110);
               Client.field324.method2603(var3);
               Client.field324.method2605(var1 + class21.baseY);
               Client.field324.method2756(class47.baseX + var0);
               Client.field324.method2556(class140.field2163[82]?1:0);
            }

            if(var2 == 36) {
               Client.field324.method2828(197);
               Client.field324.method2615(var1);
               Client.field324.method2605(var3);
               Client.field324.method2638(var0);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 11) {
               var16 = Client.cachedNPCs[var3];
               if(null != var16) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(218);
                  Client.field324.method2638(var3);
                  Client.field324.method2556(class140.field2163[82]?1:0);
               }
            }

            if(var2 == 40) {
               Client.field324.method2828(116);
               Client.field324.method2756(var0);
               Client.field324.method2559(var1);
               Client.field324.method2638(var3);
               Client.field393 = 0;
               class53.field1157 = class144.method3012(var1);
               Client.field394 = var0;
            }

            if(var2 == 16) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(62);
               Client.field324.method2605(class21.baseY + var1);
               Client.field324.method2615(class20.field569);
               Client.field324.method2605(class12.field184);
               Client.field324.method2605(var3);
               Client.field324.method2556(class140.field2163[82]?1:0);
               Client.field324.method2756(var0 + class47.baseX);
               Client.field324.method2638(class141.field2187);
            }

            if(var2 == 13) {
               var16 = Client.cachedNPCs[var3];
               if(var16 != null) {
                  Client.field320 = var6;
                  Client.field390 = var7;
                  Client.field326 = 2;
                  Client.field389 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field324.method2828(63);
                  Client.field324.method2573(class140.field2163[82]?1:0);
                  Client.field324.method2756(var3);
               }
            }

            if(var2 == 22) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(166);
               Client.field324.method2756(var0 + class47.baseX);
               Client.field324.method2605(class21.baseY + var1);
               Client.field324.method2573(class140.field2163[82]?1:0);
               Client.field324.method2603(var3);
            }

            if(var2 == 20) {
               Client.field320 = var6;
               Client.field390 = var7;
               Client.field326 = 2;
               Client.field389 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field324.method2828(234);
               Client.field324.method2605(var3);
               Client.field324.method2596(class140.field2163[82]?1:0);
               Client.field324.method2603(var0 + class47.baseX);
               Client.field324.method2756(class21.baseY + var1);
            }

            if(var2 == 24) {
               var17 = class144.method3012(var1);
               boolean var18 = true;
               if(var17.contentType > 0) {
                  var18 = class174.method3415(var17);
               }

               if(var18) {
                  Client.field324.method2828(47);
                  Client.field324.method2559(var1);
               }
            }

            if(Client.field497 != 0) {
               Client.field497 = 0;
               class166.method3253(class144.method3012(class20.field569));
            }

            if(Client.field435) {
               class212.method3959();
            }

            if(null != class53.field1157 && Client.field393 == 0) {
               class166.method3253(class53.field1157);
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "13"
   )
   static void method177(GameEngine var0) {
      if(class143.field2206 == 1 || !class124.field2066 && class143.field2206 == 4) {
         int var1 = class33.field729 + 280;
         if(class143.field2207 >= var1 && class143.field2207 <= var1 + 14 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(0, 0);
            return;
         }

         if(class143.field2207 >= 15 + var1 && class143.field2207 <= var1 + 80 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(0, 1);
            return;
         }

         int var2 = 390 + class33.field729;
         if(class143.field2207 >= var2 && class143.field2207 <= 14 + var2 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(1, 0);
            return;
         }

         if(class143.field2207 >= var2 + 15 && class143.field2207 <= var2 + 80 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(1, 1);
            return;
         }

         int var3 = 500 + class33.field729;
         if(class143.field2207 >= var3 && class143.field2207 <= 14 + var3 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(2, 0);
            return;
         }

         if(class143.field2207 >= 15 + var3 && class143.field2207 <= var3 + 80 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(2, 1);
            return;
         }

         int var4 = class33.field729 + 610;
         if(class143.field2207 >= var4 && class143.field2207 <= 14 + var4 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(3, 0);
            return;
         }

         if(class143.field2207 >= 15 + var4 && class143.field2207 <= 80 + var4 && class143.field2196 >= 4 && class143.field2196 <= 18) {
            class219.method3994(3, 1);
            return;
         }

         if(class143.field2207 >= class33.field729 + 708 && class143.field2196 >= 4 && class143.field2207 <= 50 + 708 + class33.field729 && class143.field2196 <= 20) {
            class33.worldSelectShown = false;
            class33.field748.method1767(class33.field729, 0);
            class33.field732.method1767(382 + class33.field729, 0);
            class33.field733.method1911(382 + class33.field729 - class33.field733.originalWidth / 2, 18);
            return;
         }

         if(class33.field762 != -1) {
            World var5 = ItemComposition.worldList[class33.field762];
            class125.selectWorld(var5);
            class33.worldSelectShown = false;
            class33.field748.method1767(class33.field729, 0);
            class33.field732.method1767(382 + class33.field729, 0);
            class33.field733.method1911(382 + class33.field729 - class33.field733.originalWidth / 2, 18);
            return;
         }
      }

   }
}

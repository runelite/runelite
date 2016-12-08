import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class109 {
   @ObfuscatedName("kr")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("pm")
   static class1 field1748;
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = -211951323
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1817"
   )
   public abstract void vmethod2001();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1620220904"
   )
   abstract int vmethod2002(int var1, int var2);

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "638399490"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 18) {
         Client.field500 = var6;
         Client.field395 = var7;
         Client.field476 = 2;
         Client.field396 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method2967(131);
         Client.field330.method2760(var1 + XClanMember.baseY);
         Client.field330.method2752(class105.field1728[82]?1:0);
         Client.field330.method2760(var3);
         Client.field330.method2759(var0 + class107.baseX);
      }

      if(var2 == 34) {
         Client.field330.method2967(74);
         Client.field330.method2922(var0);
         Client.field330.method2714(var1);
         Client.field330.method2759(var3);
         Client.field398 = 0;
         Ignore.field209 = class174.method3178(var1);
         Client.field399 = var0;
      }

      if(var2 == 21) {
         Client.field500 = var6;
         Client.field395 = var7;
         Client.field476 = 2;
         Client.field396 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method2967(195);
         Client.field330.method2712(var3);
         Client.field330.method2759(XClanMember.baseY + var1);
         Client.field330.method2759(var0 + class107.baseX);
         Client.field330.method2913(class105.field1728[82]?1:0);
      }

      Widget var8;
      int var9;
      if(var2 == 57 || var2 == 1007) {
         var8 = class138.method2419(var1, var0);
         if(var8 != null) {
            var9 = var8.item;
            Widget var10 = class138.method2419(var1, var0);
            if(var10 != null) {
               if(var10.field2307 != null) {
                  class18 var11 = new class18();
                  var11.field193 = var10;
                  var11.field197 = var3;
                  var11.field201 = var5;
                  var11.field203 = var10.field2307;
                  class13.method165(var11);
               }

               boolean var16 = true;
               if(var10.contentType > 0) {
                  var16 = class44.method791(var10);
               }

               if(var16 && class94.method1869(class217.method3874(var10), var3 - 1)) {
                  if(var3 == 1) {
                     Client.field330.method2967(151);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 2) {
                     Client.field330.method2967(239);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 3) {
                     Client.field330.method2967(144);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 4) {
                     Client.field330.method2967(238);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 5) {
                     Client.field330.method2967(155);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 6) {
                     Client.field330.method2967(189);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 7) {
                     Client.field330.method2967(226);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 8) {
                     Client.field330.method2967(171);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 9) {
                     Client.field330.method2967(203);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }

                  if(var3 == 10) {
                     Client.field330.method2967(73);
                     Client.field330.method2714(var1);
                     Client.field330.method2712(var0);
                     Client.field330.method2712(var9);
                  }
               }
            }
         }
      }

      if(var2 == 22) {
         Client.field500 = var6;
         Client.field395 = var7;
         Client.field476 = 2;
         Client.field396 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method2967(162);
         Client.field330.method2824(class105.field1728[82]?1:0);
         Client.field330.method2760(class107.baseX + var0);
         Client.field330.method2759(var3);
         Client.field330.method2712(XClanMember.baseY + var1);
      }

      if(var2 == 33) {
         Client.field330.method2967(199);
         Client.field330.method2759(var3);
         Client.field330.method2791(var1);
         Client.field330.method2712(var0);
         Client.field398 = 0;
         Ignore.field209 = class174.method3178(var1);
         Client.field399 = var0;
      }

      if(var2 == 1002) {
         Client.field500 = var6;
         Client.field395 = var7;
         Client.field476 = 2;
         Client.field396 = 0;
         Client.field330.method2967(120);
         Client.field330.method2922(var3 >> 14 & 32767);
      }

      if(var2 == 36) {
         Client.field330.method2967(222);
         Client.field330.method2712(var0);
         Client.field330.method2768(var1);
         Client.field330.method2759(var3);
         Client.field398 = 0;
         Ignore.field209 = class174.method3178(var1);
         Client.field399 = var0;
      }

      if(var2 == 32) {
         Client.field330.method2967(143);
         Client.field330.method2760(var0);
         Client.field330.method2712(Client.field385);
         Client.field330.method2712(var3);
         Client.field330.method2714(class155.field2128);
         Client.field330.method2714(var1);
         Client.field398 = 0;
         Ignore.field209 = class174.method3178(var1);
         Client.field399 = var0;
      }

      if(var2 == 26) {
         Client.field330.method2967(237);

         for(WidgetNode var19 = (WidgetNode)Client.componentTable.method2296(); var19 != null; var19 = (WidgetNode)Client.componentTable.method2300()) {
            if(var19.field191 == 0 || var19.field191 == 3) {
               class44.method783(var19, true);
            }
         }

         if(Client.field448 != null) {
            class97.method1886(Client.field448);
            Client.field448 = null;
         }
      }

      Player var20;
      if(var2 == 48) {
         var20 = Client.cachedPlayers[var3];
         if(null != var20) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(243);
            Client.field330.method2712(var3);
            Client.field330.method2913(class105.field1728[82]?1:0);
         }
      }

      if(var2 == 28) {
         Client.field330.method2967(125);
         Client.field330.method2714(var1);
         var8 = class174.method3178(var1);
         if(null != var8.dynamicValues && var8.dynamicValues[0][0] == 5) {
            var9 = var8.dynamicValues[0][1];
            class165.widgetSettings[var9] = 1 - class165.widgetSettings[var9];
            class10.method143(var9);
         }
      }

      if(var2 == 49) {
         var20 = Client.cachedPlayers[var3];
         if(var20 != null) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(24);
            Client.field330.method2760(var3);
            Client.field330.method2824(class105.field1728[82]?1:0);
         }
      }

      if(var2 == 50) {
         var20 = Client.cachedPlayers[var3];
         if(var20 != null) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(111);
            Client.field330.method2922(var3);
            Client.field330.method2752(class105.field1728[82]?1:0);
         }
      }

      if(var2 == 1001) {
         Client.field500 = var6;
         Client.field395 = var7;
         Client.field476 = 2;
         Client.field396 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method2967(157);
         Client.field330.method2759(var3 >> 14 & 32767);
         Client.field330.method2913(class105.field1728[82]?1:0);
         Client.field330.method2712(XClanMember.baseY + var1);
         Client.field330.method2760(class107.baseX + var0);
      }

      if(var2 == 23) {
         class159.region.method1703(class63.plane, var0, var1);
      }

      if(var2 == 1004) {
         Client.field500 = var6;
         Client.field395 = var7;
         Client.field476 = 2;
         Client.field396 = 0;
         Client.field330.method2967(23);
         Client.field330.method2759(var3);
      }

      NPC var22;
      if(var2 == 7) {
         var22 = Client.cachedNPCs[var3];
         if(null != var22) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(21);
            Client.field330.method2922(var3);
            Client.field330.method2714(class22.field244);
            Client.field330.method2913(class105.field1728[82]?1:0);
            Client.field330.method2712(class138.field1925);
            Client.field330.method2760(class116.field1831);
         }
      }

      if(var2 == 11) {
         var22 = Client.cachedNPCs[var3];
         if(null != var22) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(174);
            Client.field330.method2712(var3);
            Client.field330.method2752(class105.field1728[82]?1:0);
         }
      }

      if(var2 == 25) {
         var8 = class138.method2419(var1, var0);
         if(var8 != null) {
            class3.method30();
            int var12 = class217.method3874(var8);
            int var23 = var12 >> 11 & 63;
            CombatInfoListHolder.method688(var1, var0, var23, var8.item);
            Client.field437 = 0;
            int var15 = class217.method3874(var8);
            int var14 = var15 >> 11 & 63;
            String var13;
            if(var14 == 0) {
               var13 = null;
            } else if(null != var8.field2286 && var8.field2286.trim().length() != 0) {
               var13 = var8.field2286;
            } else {
               var13 = null;
            }

            Client.field562 = var13;
            if(null == Client.field562) {
               Client.field562 = "Null";
            }

            if(var8.field2204) {
               Client.field443 = var8.name + class16.method182(16777215);
            } else {
               Client.field443 = class16.method182('\uff00') + var8.field2323 + class16.method182(16777215);
            }
         }

      } else {
         if(var2 == 31) {
            Client.field330.method2967(102);
            Client.field330.method2760(var0);
            Client.field330.method2769(var1);
            Client.field330.method2791(class22.field244);
            Client.field330.method2922(class138.field1925);
            Client.field330.method2760(class116.field1831);
            Client.field330.method2759(var3);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 14) {
            var20 = Client.cachedPlayers[var3];
            if(null != var20) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(167);
               Client.field330.method2824(class105.field1728[82]?1:0);
               Client.field330.method2714(class22.field244);
               Client.field330.method2922(class116.field1831);
               Client.field330.method2922(class138.field1925);
               Client.field330.method2922(var3);
            }
         }

         if(var2 == 46) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(182);
               Client.field330.method2759(var3);
               Client.field330.method2815(class105.field1728[82]?1:0);
            }
         }

         if(var2 == 1) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(35);
            Client.field330.method2760(class138.field1925);
            Client.field330.method2760(var3 >> 14 & 32767);
            Client.field330.method2712(var0 + class107.baseX);
            Client.field330.method2760(class116.field1831);
            Client.field330.method2922(XClanMember.baseY + var1);
            Client.field330.method2824(class105.field1728[82]?1:0);
            Client.field330.method2791(class22.field244);
         }

         if(var2 == 4) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(95);
            Client.field330.method2760(var1 + XClanMember.baseY);
            Client.field330.method2759(var3 >> 14 & 32767);
            Client.field330.method2759(class107.baseX + var0);
            Client.field330.method2824(class105.field1728[82]?1:0);
         }

         if(var2 == 42) {
            Client.field330.method2967(11);
            Client.field330.method2714(var1);
            Client.field330.method2922(var3);
            Client.field330.method2712(var0);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 40) {
            Client.field330.method2967(135);
            Client.field330.method2760(var0);
            Client.field330.method2791(var1);
            Client.field330.method2760(var3);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 24) {
            var8 = class174.method3178(var1);
            boolean var21 = true;
            if(var8.contentType > 0) {
               var21 = class44.method791(var8);
            }

            if(var21) {
               Client.field330.method2967(125);
               Client.field330.method2714(var1);
            }
         }

         if(var2 == 12) {
            var22 = Client.cachedNPCs[var3];
            if(var22 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(72);
               Client.field330.method2913(class105.field1728[82]?1:0);
               Client.field330.method2760(var3);
            }
         }

         if(var2 == 6) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(106);
            Client.field330.method2752(class105.field1728[82]?1:0);
            Client.field330.method2922(var0 + class107.baseX);
            Client.field330.method2922(XClanMember.baseY + var1);
            Client.field330.method2760(var3 >> 14 & 32767);
         }

         if(var2 == 20) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(190);
            Client.field330.method2824(class105.field1728[82]?1:0);
            Client.field330.method2922(class107.baseX + var0);
            Client.field330.method2712(var3);
            Client.field330.method2922(XClanMember.baseY + var1);
         }

         if(var2 == 5) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(50);
            Client.field330.method2759(class107.baseX + var0);
            Client.field330.method2815(class105.field1728[82]?1:0);
            Client.field330.method2760(XClanMember.baseY + var1);
            Client.field330.method2712(var3 >> 14 & 32767);
         }

         if(var2 == 29) {
            Client.field330.method2967(125);
            Client.field330.method2714(var1);
            var8 = class174.method3178(var1);
            if(null != var8.dynamicValues && var8.dynamicValues[0][0] == 5) {
               var9 = var8.dynamicValues[0][1];
               if(var8.field2321[0] != class165.widgetSettings[var9]) {
                  class165.widgetSettings[var9] = var8.field2321[0];
                  class10.method143(var9);
               }
            }
         }

         if(var2 == 10) {
            var22 = Client.cachedNPCs[var3];
            if(null != var22) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(70);
               Client.field330.method2712(var3);
               Client.field330.method2815(class105.field1728[82]?1:0);
            }
         }

         if(var2 == 51) {
            var20 = Client.cachedPlayers[var3];
            if(null != var20) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(65);
               Client.field330.method2759(var3);
               Client.field330.method2752(class105.field1728[82]?1:0);
            }
         }

         if(var2 == 9) {
            var22 = Client.cachedNPCs[var3];
            if(var22 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(113);
               Client.field330.method2759(var3);
               Client.field330.method2752(class105.field1728[82]?1:0);
            }
         }

         if(var2 == 3) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(45);
            Client.field330.method2759(var3 >> 14 & 32767);
            Client.field330.method2815(class105.field1728[82]?1:0);
            Client.field330.method2922(var1 + XClanMember.baseY);
            Client.field330.method2760(var0 + class107.baseX);
         }

         if(var2 == 41) {
            Client.field330.method2967(211);
            Client.field330.method2712(var0);
            Client.field330.method2922(var3);
            Client.field330.method2791(var1);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 8) {
            var22 = Client.cachedNPCs[var3];
            if(var22 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(252);
               Client.field330.method2922(Client.field385);
               Client.field330.method2922(var3);
               Client.field330.method2824(class105.field1728[82]?1:0);
               Client.field330.method2768(class155.field2128);
            }
         }

         if(var2 == 19) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(107);
            Client.field330.method2712(var3);
            Client.field330.method2752(class105.field1728[82]?1:0);
            Client.field330.method2760(class107.baseX + var0);
            Client.field330.method2760(var1 + XClanMember.baseY);
         }

         if(var2 == 16) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(136);
            Client.field330.method2759(var3);
            Client.field330.method2712(class107.baseX + var0);
            Client.field330.method2759(var1 + XClanMember.baseY);
            Client.field330.method2791(class22.field244);
            Client.field330.method2913(class105.field1728[82]?1:0);
            Client.field330.method2922(class116.field1831);
            Client.field330.method2922(class138.field1925);
         }

         if(var2 == 15) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(79);
               Client.field330.method2712(var3);
               Client.field330.method2712(Client.field385);
               Client.field330.method2913(class105.field1728[82]?1:0);
               Client.field330.method2768(class155.field2128);
            }
         }

         if(var2 == 35) {
            Client.field330.method2967(76);
            Client.field330.method2759(var0);
            Client.field330.method2922(var3);
            Client.field330.method2768(var1);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 1005) {
            var8 = class174.method3178(var1);
            if(null != var8 && var8.itemQuantities[var0] >= 100000) {
               class16.method183(27, "", var8.itemQuantities[var0] + " x " + class137.getItemDefinition(var3).name);
            } else {
               Client.field330.method2967(23);
               Client.field330.method2759(var3);
            }

            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 2) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(20);
            Client.field330.method2922(XClanMember.baseY + var1);
            Client.field330.method2760(var3 >> 14 & 32767);
            Client.field330.method2922(class107.baseX + var0);
            Client.field330.method2759(Client.field385);
            Client.field330.method2768(class155.field2128);
            Client.field330.method2824(class105.field1728[82]?1:0);
         }

         if(var2 == 44) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(150);
               Client.field330.method2913(class105.field1728[82]?1:0);
               Client.field330.method2922(var3);
            }
         }

         if(var2 == 39) {
            Client.field330.method2967(214);
            Client.field330.method2922(var3);
            Client.field330.method2712(var0);
            Client.field330.method2791(var1);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 13) {
            var22 = Client.cachedNPCs[var3];
            if(null != var22) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(168);
               Client.field330.method2824(class105.field1728[82]?1:0);
               Client.field330.method2712(var3);
            }
         }

         if(var2 == 30 && null == Client.field448) {
            Client.field330.method2967(53);
            Client.field330.method2922(var0);
            Client.field330.method2791(var1);
            Client.field448 = class138.method2419(var1, var0);
            class97.method1886(Client.field448);
         }

         if(var2 == 58) {
            var8 = class138.method2419(var1, var0);
            if(var8 != null) {
               Client.field330.method2967(241);
               Client.field330.method2714(class155.field2128);
               Client.field330.method2712(Client.field441);
               Client.field330.method2922(Client.field385);
               Client.field330.method2759(var0);
               Client.field330.method2769(var1);
               Client.field330.method2759(var8.item);
            }
         }

         if(var2 == 43) {
            Client.field330.method2967(69);
            Client.field330.method2760(var3);
            Client.field330.method2791(var1);
            Client.field330.method2922(var0);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 1003) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            var22 = Client.cachedNPCs[var3];
            if(var22 != null) {
               NPCComposition var18 = var22.composition;
               if(null != var18.field3023) {
                  var18 = var18.method3643();
               }

               if(null != var18) {
                  Client.field330.method2967(138);
                  Client.field330.method2712(var18.id);
               }
            }
         }

         if(var2 == 45) {
            var20 = Client.cachedPlayers[var3];
            if(null != var20) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(104);
               Client.field330.method2913(class105.field1728[82]?1:0);
               Client.field330.method2759(var3);
            }
         }

         if(var2 == 17) {
            Client.field500 = var6;
            Client.field395 = var7;
            Client.field476 = 2;
            Client.field396 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method2967(156);
            Client.field330.method2759(Client.field385);
            Client.field330.method2760(class107.baseX + var0);
            Client.field330.method2760(XClanMember.baseY + var1);
            Client.field330.method2752(class105.field1728[82]?1:0);
            Client.field330.method2791(class155.field2128);
            Client.field330.method2712(var3);
         }

         if(var2 == 47) {
            var20 = Client.cachedPlayers[var3];
            if(var20 != null) {
               Client.field500 = var6;
               Client.field395 = var7;
               Client.field476 = 2;
               Client.field396 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method2967(201);
               Client.field330.method2815(class105.field1728[82]?1:0);
               Client.field330.method2922(var3);
            }
         }

         if(var2 == 37) {
            Client.field330.method2967(77);
            Client.field330.method2712(var0);
            Client.field330.method2769(var1);
            Client.field330.method2760(var3);
            Client.field398 = 0;
            Ignore.field209 = class174.method3178(var1);
            Client.field399 = var0;
         }

         if(var2 == 38) {
            class3.method30();
            var8 = class174.method3178(var1);
            Client.field437 = 1;
            class138.field1925 = var0;
            class22.field244 = var1;
            class116.field1831 = var3;
            class97.method1886(var8);
            Client.field438 = class16.method182(16748608) + class137.getItemDefinition(var3).name + class16.method182(16777215);
            if(null == Client.field438) {
               Client.field438 = "null";
            }

         } else {
            if(Client.field437 != 0) {
               Client.field437 = 0;
               class97.method1886(class174.method3178(class22.field244));
            }

            if(Client.field439) {
               class3.method30();
            }

            if(Ignore.field209 != null && Client.field398 == 0) {
               class97.method1886(Ignore.field209);
            }

         }
      }
   }
}

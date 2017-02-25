import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class171 {
   @ObfuscatedName("ib")
   static Widget field2344;

   class171() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "88"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(176);
            Client.field348.method2857(class105.field1713[82]?1:0);
            Client.field348.method2864(var3);
         }
      }

      NPC var14;
      if(var2 == 1003) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            NPCComposition var9 = var14.composition;
            if(var9.configs != null) {
               var9 = var9.method3735();
            }

            if(var9 != null) {
               Client.field348.method3073(108);
               Client.field348.method2862(var9.id);
            }
         }
      }

      if(var2 == 34) {
         Client.field348.method3073(95);
         Client.field348.method2821(var1);
         Client.field348.method2831(var0);
         Client.field348.method2831(var3);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 3) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(83);
         Client.field348.method2865(class5.baseX + var0);
         Client.field348.method2831(var3 >> 14 & 32767);
         Client.field348.method2831(var1 + XClanMember.baseY);
         Client.field348.method2856(class105.field1713[82]?1:0);
      }

      if(var2 == 4) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(161);
         Client.field348.method2856(class105.field1713[82]?1:0);
         Client.field348.method2864(var3 >> 14 & 32767);
         Client.field348.method2862(class5.baseX + var0);
         Client.field348.method2865(XClanMember.baseY + var1);
      }

      if(var2 == 43) {
         Client.field348.method3073(77);
         Client.field348.method2865(var3);
         Client.field348.method2865(var0);
         Client.field348.method2821(var1);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 16) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(107);
         Client.field348.method2831(var1 + XClanMember.baseY);
         Client.field348.method2857(class105.field1713[82]?1:0);
         Client.field348.method2862(ChatLineBuffer.field986);
         Client.field348.method2864(var0 + class5.baseX);
         Client.field348.method2862(class33.field770);
         Client.field348.method2972(class99.field1645);
         Client.field348.method2831(var3);
      }

      if(var2 == 10) {
         var14 = Client.cachedNPCs[var3];
         if(var14 != null) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(135);
            Client.field348.method2864(var3);
            Client.field348.method2857(class105.field1713[82]?1:0);
         }
      }

      if(var2 == 18) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(35);
         Client.field348.method2918(class105.field1713[82]?1:0);
         Client.field348.method2864(class5.baseX + var0);
         Client.field348.method2865(var3);
         Client.field348.method2864(var1 + XClanMember.baseY);
      }

      if(var2 == 39) {
         Client.field348.method3073(223);
         Client.field348.method2865(var3);
         Client.field348.method2876(var1);
         Client.field348.method2864(var0);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 15) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(10);
            Client.field348.method2935(class105.field1713[82]?1:0);
            Client.field348.method2864(Client.field461);
            Client.field348.method2821(Friend.field166);
            Client.field348.method2864(var3);
         }
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(52);
            Client.field348.method2865(var3);
            Client.field348.method2856(class105.field1713[82]?1:0);
         }
      }

      if(var2 == 42) {
         Client.field348.method3073(137);
         Client.field348.method2972(var1);
         Client.field348.method2865(var0);
         Client.field348.method2862(var3);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 1) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(45);
         Client.field348.method2857(class105.field1713[82]?1:0);
         Client.field348.method2831(var3 >> 14 & 32767);
         Client.field348.method2864(class33.field770);
         Client.field348.method2831(XClanMember.baseY + var1);
         Client.field348.method2864(class5.baseX + var0);
         Client.field348.method2972(class99.field1645);
         Client.field348.method2865(ChatLineBuffer.field986);
      }

      if(var2 == 32) {
         Client.field348.method3073(24);
         Client.field348.method2864(var0);
         Client.field348.method2864(var3);
         Client.field348.method3019(var1);
         Client.field348.method2864(Client.field461);
         Client.field348.method2876(Friend.field166);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 12) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(171);
            Client.field348.method2857(class105.field1713[82]?1:0);
            Client.field348.method2864(var3);
         }
      }

      if(var2 == 41) {
         Client.field348.method3073(220);
         Client.field348.method2876(var1);
         Client.field348.method2862(var3);
         Client.field348.method2864(var0);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 50) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(30);
            Client.field348.method2865(var3);
            Client.field348.method2935(class105.field1713[82]?1:0);
         }
      }

      if(var2 == 30 && Client.field469 == null) {
         Projectile.method872(var1, var0);
         Client.field469 = class57.method1157(var1, var0);
         class174.method3276(Client.field469);
      }

      int var12;
      Widget var15;
      if(var2 == 57 || var2 == 1007) {
         var15 = class57.method1157(var1, var0);
         if(var15 != null) {
            var12 = var15.item;
            Widget var10 = class57.method1157(var1, var0);
            if(null != var10) {
               if(null != var10.field2274) {
                  class18 var11 = new class18();
                  var11.field198 = var10;
                  var11.field201 = var3;
                  var11.field202 = var5;
                  var11.field209 = var10.field2274;
                  class174.method3275(var11, 200000);
               }

               boolean var13 = true;
               if(var10.contentType > 0) {
                  var13 = CombatInfoListHolder.method798(var10);
               }

               if(var13 && class44.method883(class196.method3614(var10), var3 - 1)) {
                  if(var3 == 1) {
                     Client.field348.method3073(100);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 2) {
                     Client.field348.method3073(118);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 3) {
                     Client.field348.method3073(168);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 4) {
                     Client.field348.method3073(235);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 5) {
                     Client.field348.method3073(234);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 6) {
                     Client.field348.method3073(87);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 7) {
                     Client.field348.method3073(55);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 8) {
                     Client.field348.method3073(102);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 9) {
                     Client.field348.method3073(249);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }

                  if(var3 == 10) {
                     Client.field348.method3073(111);
                     Client.field348.method2821(var1);
                     Client.field348.method2831(var0);
                     Client.field348.method2831(var12);
                  }
               }
            }
         }
      }

      if(var2 == 1004) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.field348.method3073(133);
         Client.field348.method2864(var3);
      }

      if(var2 == 1005) {
         var15 = class179.method3296(var1);
         if(var15 != null && var15.itemQuantities[var0] >= 100000) {
            class16.sendGameMessage(27, "", var15.itemQuantities[var0] + " x " + class103.getItemDefinition(var3).name);
         } else {
            Client.field348.method3073(133);
            Client.field348.method2864(var3);
         }

         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 17) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(189);
         Client.field348.method2865(var3);
         Client.field348.method2864(XClanMember.baseY + var1);
         Client.field348.method2857(class105.field1713[82]?1:0);
         Client.field348.method3019(Friend.field166);
         Client.field348.method2865(var0 + class5.baseX);
         Client.field348.method2831(Client.field461);
      }

      if(var2 == 45) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(164);
            Client.field348.method2935(class105.field1713[82]?1:0);
            Client.field348.method2864(var3);
         }
      }

      if(var2 == 9) {
         var14 = Client.cachedNPCs[var3];
         if(var14 != null) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(226);
            Client.field348.method2856(class105.field1713[82]?1:0);
            Client.field348.method2862(var3);
         }
      }

      if(var2 == 28) {
         Client.field348.method3073(208);
         Client.field348.method2821(var1);
         var15 = class179.method3296(var1);
         if(null != var15.dynamicValues && var15.dynamicValues[0][0] == 5) {
            var12 = var15.dynamicValues[0][1];
            class165.widgetSettings[var12] = 1 - class165.widgetSettings[var12];
            class145.method2760(var12);
         }
      }

      if(var2 == 24) {
         var15 = class179.method3296(var1);
         boolean var16 = true;
         if(var15.contentType > 0) {
            var16 = CombatInfoListHolder.method798(var15);
         }

         if(var16) {
            Client.field348.method3073(208);
            Client.field348.method2821(var1);
         }
      }

      if(var2 == 33) {
         Client.field348.method3073(148);
         Client.field348.method2865(var0);
         Client.field348.method2876(var1);
         Client.field348.method2831(var3);
         Client.field452 = 0;
         class41.field843 = class179.method3296(var1);
         Client.field444 = var0;
      }

      if(var2 == 6) {
         Client.field412 = var6;
         Client.field413 = var7;
         Client.field415 = 2;
         Client.field414 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field348.method3073(158);
         Client.field348.method2935(class105.field1713[82]?1:0);
         Client.field348.method2864(class5.baseX + var0);
         Client.field348.method2862(XClanMember.baseY + var1);
         Client.field348.method2831(var3 >> 14 & 32767);
      }

      if(var2 == 38) {
         class137.method2529();
         var15 = class179.method3296(var1);
         Client.field458 = 1;
         class33.field770 = var0;
         class99.field1645 = var1;
         ChatLineBuffer.field986 = var3;
         class174.method3276(var15);
         Client.field459 = class18.method199(16748608) + class103.getItemDefinition(var3).name + class18.method199(16777215);
         if(null == Client.field459) {
            Client.field459 = "null";
         }

      } else {
         if(var2 == 31) {
            Client.field348.method3073(73);
            Client.field348.method2865(var0);
            Client.field348.method2972(var1);
            Client.field348.method2831(var3);
            Client.field348.method2862(ChatLineBuffer.field986);
            Client.field348.method2876(class99.field1645);
            Client.field348.method2862(class33.field770);
            Client.field452 = 0;
            class41.field843 = class179.method3296(var1);
            Client.field444 = var0;
         }

         if(var2 == 7) {
            var14 = Client.cachedNPCs[var3];
            if(null != var14) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(165);
               Client.field348.method2865(class33.field770);
               Client.field348.method2831(var3);
               Client.field348.method2864(ChatLineBuffer.field986);
               Client.field348.method2821(class99.field1645);
               Client.field348.method2856(class105.field1713[82]?1:0);
            }
         }

         if(var2 == 5) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(78);
            Client.field348.method2864(class5.baseX + var0);
            Client.field348.method2862(var3 >> 14 & 32767);
            Client.field348.method2831(XClanMember.baseY + var1);
            Client.field348.method2857(class105.field1713[82]?1:0);
         }

         if(var2 == 36) {
            Client.field348.method3073(233);
            Client.field348.method2972(var1);
            Client.field348.method2862(var0);
            Client.field348.method2864(var3);
            Client.field452 = 0;
            class41.field843 = class179.method3296(var1);
            Client.field444 = var0;
         }

         if(var2 == 58) {
            var15 = class57.method1157(var1, var0);
            if(var15 != null) {
               Client.field348.method3073(85);
               Client.field348.method2865(Client.field461);
               Client.field348.method2864(Client.field462);
               Client.field348.method3019(var1);
               Client.field348.method2864(var0);
               Client.field348.method3019(Friend.field166);
               Client.field348.method2864(var15.item);
            }
         }

         if(var2 == 37) {
            Client.field348.method3073(200);
            Client.field348.method3019(var1);
            Client.field348.method2862(var3);
            Client.field348.method2831(var0);
            Client.field452 = 0;
            class41.field843 = class179.method3296(var1);
            Client.field444 = var0;
         }

         if(var2 == 29) {
            Client.field348.method3073(208);
            Client.field348.method2821(var1);
            var15 = class179.method3296(var1);
            if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
               var12 = var15.dynamicValues[0][1];
               if(class165.widgetSettings[var12] != var15.field2319[0]) {
                  class165.widgetSettings[var12] = var15.field2319[0];
                  class145.method2760(var12);
               }
            }
         }

         if(var2 == 19) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(86);
            Client.field348.method2831(var3);
            Client.field348.method2918(class105.field1713[82]?1:0);
            Client.field348.method2864(XClanMember.baseY + var1);
            Client.field348.method2862(class5.baseX + var0);
         }

         if(var2 == 2) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(222);
            Client.field348.method2935(class105.field1713[82]?1:0);
            Client.field348.method2864(Client.field461);
            Client.field348.method2862(var3 >> 14 & 32767);
            Client.field348.method2821(Friend.field166);
            Client.field348.method2864(class5.baseX + var0);
            Client.field348.method2862(var1 + XClanMember.baseY);
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(42);
               Client.field348.method2918(class105.field1713[82]?1:0);
               Client.field348.method2865(var3);
            }
         }

         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(64);
               Client.field348.method2856(class105.field1713[82]?1:0);
               Client.field348.method2862(var3);
            }
         }

         if(var2 == 35) {
            Client.field348.method3073(129);
            Client.field348.method2972(var1);
            Client.field348.method2864(var3);
            Client.field348.method2865(var0);
            Client.field452 = 0;
            class41.field843 = class179.method3296(var1);
            Client.field444 = var0;
         }

         if(var2 == 11) {
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(92);
               Client.field348.method2862(var3);
               Client.field348.method2857(class105.field1713[82]?1:0);
            }
         }

         if(var2 == 21) {
            Client.field412 = var6;
            Client.field413 = var7;
            Client.field415 = 2;
            Client.field414 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field348.method3073(248);
            Client.field348.method2918(class105.field1713[82]?1:0);
            Client.field348.method2862(var3);
            Client.field348.method2864(XClanMember.baseY + var1);
            Client.field348.method2864(class5.baseX + var0);
         }

         if(var2 == 48) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(7);
               Client.field348.method2865(var3);
               Client.field348.method2856(class105.field1713[82]?1:0);
            }
         }

         if(var2 == 25) {
            var15 = class57.method1157(var1, var0);
            if(null != var15) {
               class137.method2529();
               class177.method3279(var1, var0, Friend.method178(class196.method3614(var15)), var15.item);
               Client.field458 = 0;
               Client.field463 = Friend.method177(var15);
               if(Client.field463 == null) {
                  Client.field463 = "Null";
               }

               if(var15.hasScript) {
                  Client.field380 = var15.name + class18.method199(16777215);
               } else {
                  Client.field380 = class18.method199('\uff00') + var15.field2308 + class18.method199(16777215);
               }
            }

         } else {
            if(var2 == 20) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(65);
               Client.field348.method2831(var3);
               Client.field348.method2857(class105.field1713[82]?1:0);
               Client.field348.method2865(var0 + class5.baseX);
               Client.field348.method2864(var1 + XClanMember.baseY);
            }

            if(var2 == 13) {
               var14 = Client.cachedNPCs[var3];
               if(var14 != null) {
                  Client.field412 = var6;
                  Client.field413 = var7;
                  Client.field415 = 2;
                  Client.field414 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field348.method3073(246);
                  Client.field348.method2862(var3);
                  Client.field348.method2857(class105.field1713[82]?1:0);
               }
            }

            if(var2 == 1001) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(58);
               Client.field348.method2865(var3 >> 14 & 32767);
               Client.field348.method2856(class105.field1713[82]?1:0);
               Client.field348.method2862(class5.baseX + var0);
               Client.field348.method2862(XClanMember.baseY + var1);
            }

            if(var2 == 40) {
               Client.field348.method3073(101);
               Client.field348.method3019(var1);
               Client.field348.method2864(var3);
               Client.field348.method2862(var0);
               Client.field452 = 0;
               class41.field843 = class179.method3296(var1);
               Client.field444 = var0;
            }

            if(var2 == 1002) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.field348.method3073(71);
               Client.field348.method2865(var3 >> 14 & 32767);
            }

            if(var2 == 14) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field412 = var6;
                  Client.field413 = var7;
                  Client.field415 = 2;
                  Client.field414 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field348.method3073(244);
                  Client.field348.method2918(class105.field1713[82]?1:0);
                  Client.field348.method2862(class33.field770);
                  Client.field348.method3019(class99.field1645);
                  Client.field348.method2865(ChatLineBuffer.field986);
                  Client.field348.method2831(var3);
               }
            }

            if(var2 == 26) {
               Client.field348.method3073(197);

               for(WidgetNode var17 = (WidgetNode)Client.componentTable.method2403(); null != var17; var17 = (WidgetNode)Client.componentTable.method2411()) {
                  if(var17.field189 == 0 || var17.field189 == 3) {
                     World.method672(var17, true);
                  }
               }

               if(null != Client.field469) {
                  class174.method3276(Client.field469);
                  Client.field469 = null;
               }
            }

            if(var2 == 44) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field412 = var6;
                  Client.field413 = var7;
                  Client.field415 = 2;
                  Client.field414 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field348.method3073(96);
                  Client.field348.method2831(var3);
                  Client.field348.method2856(class105.field1713[82]?1:0);
               }
            }

            if(var2 == 22) {
               Client.field412 = var6;
               Client.field413 = var7;
               Client.field415 = 2;
               Client.field414 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field348.method3073(138);
               Client.field348.method2862(XClanMember.baseY + var1);
               Client.field348.method2865(class5.baseX + var0);
               Client.field348.method2857(class105.field1713[82]?1:0);
               Client.field348.method2865(var3);
            }

            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  Script.region.method1832();
               } else {
                  Script.region.method1871(WallObject.plane, var0, var1, true);
               }
            }

            if(var2 == 8) {
               var14 = Client.cachedNPCs[var3];
               if(null != var14) {
                  Client.field412 = var6;
                  Client.field413 = var7;
                  Client.field415 = 2;
                  Client.field414 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field348.method3073(72);
                  Client.field348.method2935(class105.field1713[82]?1:0);
                  Client.field348.method2972(Friend.field166);
                  Client.field348.method2831(var3);
                  Client.field348.method2862(Client.field461);
               }
            }

            if(Client.field458 != 0) {
               Client.field458 = 0;
               class174.method3276(class179.method3296(class99.field1645));
            }

            if(Client.field511) {
               class137.method2529();
            }

            if(null != class41.field843 && Client.field452 == 0) {
               class174.method3276(class41.field843);
            }

         }
      }
   }
}

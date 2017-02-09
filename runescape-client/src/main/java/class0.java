import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class0 implements Comparator {
   @ObfuscatedName("ak")
   static class184 field2;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "56"
   )
   public static void method0() {
      ObjectComposition.field2882.reset();
      ObjectComposition.field2877.reset();
      ObjectComposition.field2906.reset();
      ObjectComposition.field2879.reset();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1967373017"
   )
   int method1(class2 var1, class2 var2) {
      return var1.field23 < var2.field23?-1:(var2.field23 == var1.field23?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIS)V",
      garbageValue = "-31386"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(117);
            Client.field321.method2959(var3);
            Client.field321.method2951(class105.field1712[82]?1:0);
         }
      }

      if(var2 == 37) {
         Client.field321.method3195(194);
         Client.field321.method2971(var1);
         Client.field321.method2960(var3);
         Client.field321.method2960(var0);
         Client.field389 = 0;
         class31.field708 = class37.method759(var1);
         Client.field390 = var0;
      }

      if(var2 == 6) {
         Client.field385 = var6;
         Client.field386 = var7;
         Client.field520 = 2;
         Client.field464 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field321.method3195(207);
         Client.field321.method2959(class114.baseX + var0);
         Client.field321.method2961(var3 >> 14 & 32767);
         Client.field321.method2960(CombatInfo1.baseY + var1);
         Client.field321.method3032(class105.field1712[82]?1:0);
      }

      NPC var16;
      if(var2 == 1003) {
         Client.field385 = var6;
         Client.field386 = var7;
         Client.field520 = 2;
         Client.field464 = 0;
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            NPCComposition var9 = var16.composition;
            if(null != var9.configs) {
               var9 = var9.method3729();
            }

            if(var9 != null) {
               Client.field321.method3195(220);
               Client.field321.method2961(var9.id);
            }
         }
      }

      if(var2 == 1002) {
         Client.field385 = var6;
         Client.field386 = var7;
         Client.field520 = 2;
         Client.field464 = 0;
         Client.field321.method3195(154);
         Client.field321.method2959(var3 >> 14 & 32767);
      }

      if(var2 == 42) {
         Client.field321.method3195(126);
         Client.field321.method2959(var3);
         Client.field321.method2959(var0);
         Client.field321.method3057(var1);
         Client.field389 = 0;
         class31.field708 = class37.method759(var1);
         Client.field390 = var0;
      }

      if(var2 == 47) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(36);
            Client.field321.method2952(class105.field1712[82]?1:0);
            Client.field321.method2960(var3);
         }
      }

      if(var2 == 4) {
         Client.field385 = var6;
         Client.field386 = var7;
         Client.field520 = 2;
         Client.field464 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field321.method3195(163);
         Client.field321.method2960(var3 >> 14 & 32767);
         Client.field321.method2912(class105.field1712[82]?1:0);
         Client.field321.method2959(var0 + class114.baseX);
         Client.field321.method3094(CombatInfo1.baseY + var1);
      }

      if(var2 == 43) {
         Client.field321.method3195(198);
         Client.field321.method2969(var1);
         Client.field321.method2961(var0);
         Client.field321.method2960(var3);
         Client.field389 = 0;
         class31.field708 = class37.method759(var1);
         Client.field390 = var0;
      }

      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(70);
            Client.field321.method2960(var3);
            Client.field321.method2952(class105.field1712[82]?1:0);
         }
      }

      if(var2 == 1) {
         Client.field385 = var6;
         Client.field386 = var7;
         Client.field520 = 2;
         Client.field464 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field321.method3195(140);
         Client.field321.method2960(var1 + CombatInfo1.baseY);
         Client.field321.method3094(Client.field430);
         Client.field321.method2969(class169.field2313);
         Client.field321.method3094(class114.baseX + var0);
         Client.field321.method2951(class105.field1712[82]?1:0);
         Client.field321.method3094(var3 >> 14 & 32767);
         Client.field321.method2961(Client.field429);
      }

      if(var2 == 7) {
         var16 = Client.cachedNPCs[var3];
         if(var16 != null) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(236);
            Client.field321.method2970(class169.field2313);
            Client.field321.method3094(Client.field429);
            Client.field321.method2961(var3);
            Client.field321.method2960(Client.field430);
            Client.field321.method2951(class105.field1712[82]?1:0);
         }
      }

      int var15;
      Widget var17;
      if(var2 == 25) {
         var17 = ItemLayer.method1468(var1, var0);
         if(null != var17) {
            XGrandExchangeOffer.method71();
            int var10 = class88.method1872(var17);
            var15 = var10 >> 11 & 63;
            int var12 = var17.item;
            Widget var13 = ItemLayer.method1468(var1, var0);
            if(var13 != null && var13.field2096 != null) {
               class18 var14 = new class18();
               var14.field190 = var13;
               var14.field198 = var13.field2096;
               class9.method118(var14);
            }

            Client.field434 = var12;
            Client.field432 = true;
            class39.field800 = var1;
            Client.field433 = var0;
            ItemComposition.field2939 = var15;
            class2.method28(var13);
            Client.field525 = 0;
            Client.field435 = TextureProvider.method1461(var17);
            if(null == Client.field435) {
               Client.field435 = "Null";
            }

            if(var17.hasScript) {
               Client.field436 = var17.name + class163.method3157(16777215);
            } else {
               Client.field436 = class163.method3157('\uff00') + var17.field2165 + class163.method3157(16777215);
            }
         }

      } else {
         if(var2 == 1004) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.field321.method3195(231);
            Client.field321.method2960(var3);
         }

         if(var2 == 10) {
            var16 = Client.cachedNPCs[var3];
            if(null != var16) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(206);
               Client.field321.method2912(class105.field1712[82]?1:0);
               Client.field321.method3094(var3);
            }
         }

         if(var2 == 3) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(185);
            Client.field321.method2961(var3 >> 14 & 32767);
            Client.field321.method2961(var1 + CombatInfo1.baseY);
            Client.field321.method2959(var0 + class114.baseX);
            Client.field321.method2951(class105.field1712[82]?1:0);
         }

         if(var2 == 33) {
            Client.field321.method3195(11);
            Client.field321.method2971(var1);
            Client.field321.method3094(var0);
            Client.field321.method2959(var3);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 57 || var2 == 1007) {
            var17 = ItemLayer.method1468(var1, var0);
            if(null != var17) {
               MessageNode.method221(var3, var1, var0, var17.item, var5);
            }
         }

         if(var2 == 20) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(47);
            Client.field321.method2959(class114.baseX + var0);
            Client.field321.method2959(var3);
            Client.field321.method2952(class105.field1712[82]?1:0);
            Client.field321.method2961(CombatInfo1.baseY + var1);
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(174);
               Client.field321.method2961(var3);
               Client.field321.method2951(class105.field1712[82]?1:0);
            }
         }

         if(var2 == 36) {
            Client.field321.method3195(24);
            Client.field321.method2960(var3);
            Client.field321.method2961(var0);
            Client.field321.method2971(var1);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 50) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(48);
               Client.field321.method2960(var3);
               Client.field321.method2952(class105.field1712[82]?1:0);
            }
         }

         if(var2 == 29) {
            Client.field321.method3195(148);
            Client.field321.method3057(var1);
            var17 = class37.method759(var1);
            if(null != var17.dynamicValues && var17.dynamicValues[0][0] == 5) {
               var15 = var17.dynamicValues[0][1];
               if(var17.field2119[0] != class146.widgetSettings[var15]) {
                  class146.widgetSettings[var15] = var17.field2119[0];
                  class182.method3296(var15);
               }
            }
         }

         if(var2 == 49) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(147);
               Client.field321.method3094(var3);
               Client.field321.method2912(class105.field1712[82]?1:0);
            }
         }

         if(var2 == 9) {
            var16 = Client.cachedNPCs[var3];
            if(null != var16) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(99);
               Client.field321.method3094(var3);
               Client.field321.method2912(class105.field1712[82]?1:0);
            }
         }

         if(var2 == 34) {
            Client.field321.method3195(196);
            Client.field321.method2969(var1);
            Client.field321.method2960(var3);
            Client.field321.method2959(var0);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 12) {
            var16 = Client.cachedNPCs[var3];
            if(null != var16) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(240);
               Client.field321.method2912(class105.field1712[82]?1:0);
               Client.field321.method2960(var3);
            }
         }

         if(var2 == 22) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(38);
            Client.field321.method2912(class105.field1712[82]?1:0);
            Client.field321.method2961(var1 + CombatInfo1.baseY);
            Client.field321.method2960(class114.baseX + var0);
            Client.field321.method2960(var3);
         }

         if(var2 == 41) {
            Client.field321.method3195(25);
            Client.field321.method2960(var0);
            Client.field321.method2969(var1);
            Client.field321.method2959(var3);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 31) {
            Client.field321.method3195(255);
            Client.field321.method2970(class169.field2313);
            Client.field321.method2960(var3);
            Client.field321.method2971(var1);
            Client.field321.method3094(var0);
            Client.field321.method2959(Client.field430);
            Client.field321.method2960(Client.field429);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 11) {
            var16 = Client.cachedNPCs[var3];
            if(null != var16) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(42);
               Client.field321.method2961(var3);
               Client.field321.method3032(class105.field1712[82]?1:0);
            }
         }

         if(var2 == 18) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(77);
            Client.field321.method2960(var3);
            Client.field321.method2961(var1 + CombatInfo1.baseY);
            Client.field321.method2951(class105.field1712[82]?1:0);
            Client.field321.method3094(var0 + class114.baseX);
         }

         if(var2 == 19) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(183);
            Client.field321.method2912(class105.field1712[82]?1:0);
            Client.field321.method3094(class114.baseX + var0);
            Client.field321.method3094(var3);
            Client.field321.method3094(var1 + CombatInfo1.baseY);
         }

         if(var2 == 58) {
            var17 = ItemLayer.method1468(var1, var0);
            if(var17 != null) {
               Client.field321.method3195(133);
               Client.field321.method2961(var0);
               Client.field321.method2971(var1);
               Client.field321.method2959(Client.field433);
               Client.field321.method2959(Client.field434);
               Client.field321.method2970(class39.field800);
               Client.field321.method2959(var17.item);
            }
         }

         if(var2 == 16) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(139);
            Client.field321.method2959(var1 + CombatInfo1.baseY);
            Client.field321.method2960(Client.field429);
            Client.field321.method3032(class105.field1712[82]?1:0);
            Client.field321.method2971(class169.field2313);
            Client.field321.method3094(Client.field430);
            Client.field321.method2960(var3);
            Client.field321.method2961(var0 + class114.baseX);
         }

         if(var2 == 14) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(103);
               Client.field321.method2961(Client.field429);
               Client.field321.method2970(class169.field2313);
               Client.field321.method2951(class105.field1712[82]?1:0);
               Client.field321.method2961(Client.field430);
               Client.field321.method2961(var3);
            }
         }

         if(var2 == 39) {
            Client.field321.method3195(69);
            Client.field321.method3094(var3);
            Client.field321.method2959(var0);
            Client.field321.method2971(var1);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 30 && null == Client.field309) {
            Player.method260(var1, var0);
            Client.field309 = ItemLayer.method1468(var1, var0);
            class2.method28(Client.field309);
         }

         if(var2 == 13) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(65);
               Client.field321.method2952(class105.field1712[82]?1:0);
               Client.field321.method3094(var3);
            }
         }

         if(var2 == 21) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(97);
            Client.field321.method2961(var1 + CombatInfo1.baseY);
            Client.field321.method2960(var3);
            Client.field321.method2961(var0 + class114.baseX);
            Client.field321.method2912(class105.field1712[82]?1:0);
         }

         if(var2 == 8) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(175);
               Client.field321.method2952(class105.field1712[82]?1:0);
               Client.field321.method2969(class39.field800);
               Client.field321.method2961(Client.field433);
               Client.field321.method2959(var3);
            }
         }

         if(var2 == 32) {
            Client.field321.method3195(85);
            Client.field321.method3094(var3);
            Client.field321.method2970(class39.field800);
            Client.field321.method2961(Client.field433);
            Client.field321.method3057(var1);
            Client.field321.method2960(var0);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 5) {
            Client.field385 = var6;
            Client.field386 = var7;
            Client.field520 = 2;
            Client.field464 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field321.method3195(227);
            Client.field321.method2959(var3 >> 14 & 32767);
            Client.field321.method2959(class114.baseX + var0);
            Client.field321.method2959(var1 + CombatInfo1.baseY);
            Client.field321.method2952(class105.field1712[82]?1:0);
         }

         if(var2 == 1005) {
            var17 = class37.method759(var1);
            if(var17 != null && var17.itemQuantities[var0] >= 100000) {
               ChatLineBuffer.sendGameMessage(27, "", var17.itemQuantities[var0] + " x " + PlayerComposition.getItemDefinition(var3).name);
            } else {
               Client.field321.method3195(231);
               Client.field321.method2960(var3);
            }

            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(21);
               Client.field321.method2912(class105.field1712[82]?1:0);
               Client.field321.method3094(var3);
            }
         }

         if(var2 == 35) {
            Client.field321.method3195(119);
            Client.field321.method3094(var3);
            Client.field321.method2960(var0);
            Client.field321.method3057(var1);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 40) {
            Client.field321.method3195(28);
            Client.field321.method2960(var3);
            Client.field321.method2969(var1);
            Client.field321.method2961(var0);
            Client.field389 = 0;
            class31.field708 = class37.method759(var1);
            Client.field390 = var0;
         }

         if(var2 == 26) {
            class108.method2037();
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(88);
               Client.field321.method3032(class105.field1712[82]?1:0);
               Client.field321.method3094(var3);
            }
         }

         if(var2 == 28) {
            Client.field321.method3195(148);
            Client.field321.method3057(var1);
            var17 = class37.method759(var1);
            if(var17.dynamicValues != null && var17.dynamicValues[0][0] == 5) {
               var15 = var17.dynamicValues[0][1];
               class146.widgetSettings[var15] = 1 - class146.widgetSettings[var15];
               class182.method3296(var15);
            }
         }

         if(var2 == 38) {
            XGrandExchangeOffer.method71();
            var17 = class37.method759(var1);
            Client.field525 = 1;
            Client.field429 = var0;
            class169.field2313 = var1;
            Client.field430 = var3;
            class2.method28(var17);
            Client.field431 = class163.method3157(16748608) + PlayerComposition.getItemDefinition(var3).name + class163.method3157(16777215);
            if(Client.field431 == null) {
               Client.field431 = "null";
            }

         } else {
            if(var2 == 1001) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(134);
               Client.field321.method2960(CombatInfo1.baseY + var1);
               Client.field321.method2961(var3 >> 14 & 32767);
               Client.field321.method2912(class105.field1712[82]?1:0);
               Client.field321.method2961(class114.baseX + var0);
            }

            if(var2 == 15) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field385 = var6;
                  Client.field386 = var7;
                  Client.field520 = 2;
                  Client.field464 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field321.method3195(95);
                  Client.field321.method2960(Client.field433);
                  Client.field321.method2952(class105.field1712[82]?1:0);
                  Client.field321.method2969(class39.field800);
                  Client.field321.method2960(var3);
               }
            }

            if(var2 == 17) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(29);
               Client.field321.method2952(class105.field1712[82]?1:0);
               Client.field321.method2959(CombatInfo1.baseY + var1);
               Client.field321.method2961(Client.field433);
               Client.field321.method2969(class39.field800);
               Client.field321.method2961(class114.baseX + var0);
               Client.field321.method2961(var3);
            }

            if(var2 == 24) {
               var17 = class37.method759(var1);
               boolean var18 = true;
               if(var17.contentType > 0) {
                  var18 = NPC.method747(var17);
               }

               if(var18) {
                  Client.field321.method3195(148);
                  Client.field321.method3057(var1);
               }
            }

            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class65.region.method1745();
               } else {
                  class65.region.method1774(class48.plane, var0, var1, true);
               }
            }

            if(var2 == 2) {
               Client.field385 = var6;
               Client.field386 = var7;
               Client.field520 = 2;
               Client.field464 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field321.method3195(209);
               Client.field321.method2969(class39.field800);
               Client.field321.method2951(class105.field1712[82]?1:0);
               Client.field321.method2961(Client.field433);
               Client.field321.method3094(var3 >> 14 & 32767);
               Client.field321.method2960(class114.baseX + var0);
               Client.field321.method2959(var1 + CombatInfo1.baseY);
            }

            if(Client.field525 != 0) {
               Client.field525 = 0;
               class2.method28(class37.method759(class169.field2313));
            }

            if(Client.field432) {
               XGrandExchangeOffer.method71();
            }

            if(class31.field708 != null && Client.field389 == 0) {
               class2.method28(class31.field708);
            }

         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1494643699"
   )
   static final void method12() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2403(); var0 != null; var0 = (Projectile)Client.projectiles.method2398()) {
         if(var0.floor == class48.plane && Client.gameCycle <= var0.field865) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method809(var1.x, var1.y, Renderable.method1883(var1.x, var1.y, var0.floor) - var0.field870, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = VertexNormal.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(null != var3 && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method809(var3.x, var3.y, Renderable.method1883(var3.x, var3.y, var0.floor) - var0.field870, Client.gameCycle);
                  }
               }

               var0.method799(Client.field354);
               class65.region.method1718(class48.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field868, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "2131277876"
   )
   public static Varbit method13(int var0) {
      Varbit var1 = (Varbit)Varbit.field2830.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class151.field2186.getConfigData(14, var0);
         var1 = new Varbit();
         if(null != var2) {
            var1.method3537(new Buffer(var2));
         }

         Varbit.field2830.put(var1, (long)var0);
         return var1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1((class2)var1, (class2)var2);
   }
}

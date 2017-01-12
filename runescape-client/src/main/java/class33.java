import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public final class class33 extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 837194999
   )
   int field733;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1052781683
   )
   int field735;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -865326005
   )
   int field736;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -721934849
   )
   int field737;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 954859989
   )
   int field738;
   @ObfuscatedName("d")
   Sequence field739;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1829856253
   )
   int field740 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 85460389
   )
   int field741;
   @ObfuscatedName("z")
   boolean field742 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1499478225
   )
   int field744 = 0;

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field741 = var1;
      this.field735 = var2;
      this.field736 = var3;
      this.field737 = var4;
      this.field738 = var5;
      this.field733 = var6 + var7;
      int var8 = class185.method3389(this.field741).field2772;
      if(var8 != -1) {
         this.field742 = false;
         this.field739 = CombatInfo2.getAnimation(var8);
      } else {
         this.field742 = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "6"
   )
   final void method693(int var1) {
      if(!this.field742) {
         this.field740 += var1;

         while(this.field740 > this.field739.frameLenghts[this.field744]) {
            this.field740 -= this.field739.frameLenghts[this.field744];
            ++this.field744;
            if(this.field744 >= this.field739.frameIDs.length) {
               this.field742 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "66"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 30 && Client.field537 == null) {
         class140.method2606(var1, var0);
         Client.field537 = class157.method3011(var1, var0);
         class6.method87(Client.field537);
      }

      NPC var8;
      if(var2 == 9) {
         var8 = Client.cachedNPCs[var3];
         if(null != var8) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(145);
            Client.field326.method2800(class105.field1700[82]?1:0);
            Client.field326.method2809(var3);
         }
      }

      if(var2 == 20) {
         Client.field390 = var6;
         Client.field391 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field326.method3029(12);
         Client.field326.method2918(FrameMap.baseX + var0);
         Client.field326.method2807(XItemContainer.baseY + var1);
         Client.field326.method2799(class105.field1700[82]?1:0);
         Client.field326.method2942(var3);
      }

      if(var2 == 6) {
         Client.field390 = var6;
         Client.field391 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field326.method3029(71);
         Client.field326.method2800(class105.field1700[82]?1:0);
         Client.field326.method2918(var0 + FrameMap.baseX);
         Client.field326.method2807(var3 >> 14 & 32767);
         Client.field326.method2942(var1 + XItemContainer.baseY);
      }

      if(var2 == 1003) {
         Client.field390 = var6;
         Client.field391 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         var8 = Client.cachedNPCs[var3];
         if(null != var8) {
            NPCComposition var9 = var8.composition;
            if(var9.field3016 != null) {
               var9 = var9.method3705();
            }

            if(null != var9) {
               Client.field326.method3029(208);
               Client.field326.method2942(var9.id);
            }
         }
      }

      Widget var15;
      if(var2 == 25) {
         var15 = class157.method3011(var1, var0);
         if(var15 != null) {
            class18.method187();
            int var12 = GameObject.method1872(var15);
            int var11 = var12 >> 11 & 63;
            class32.method692(var1, var0, var11, var15.item);
            Client.field447 = 0;
            Client.field438 = class32.method690(var15);
            if(Client.field438 == null) {
               Client.field438 = "Null";
            }

            if(var15.field2184) {
               Client.field282 = var15.name + class32.method691(16777215);
            } else {
               Client.field282 = class32.method691('\uff00') + var15.field2301 + class32.method691(16777215);
            }
         }

      } else {
         if(var2 == 33) {
            Client.field326.method3029(2);
            Client.field326.method2818(var1);
            Client.field326.method2809(var0);
            Client.field326.method2918(var3);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 13) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(192);
               Client.field326.method2809(var3);
               Client.field326.method2760(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(159);
               Client.field326.method2809(var3);
               Client.field326.method2800(class105.field1700[82]?1:0);
            }
         }

         Player var14;
         if(var2 == 44) {
            var14 = Client.cachedPlayers[var3];
            if(var14 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(240);
               Client.field326.method2807(var3);
               Client.field326.method2801(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 14) {
            var14 = Client.cachedPlayers[var3];
            if(var14 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(204);
               Client.field326.method2942(class6.field52);
               Client.field326.method2763(ObjectComposition.field2930);
               Client.field326.method2918(class15.field169);
               Client.field326.method2801(class105.field1700[82]?1:0);
               Client.field326.method2918(var3);
            }
         }

         if(var2 == 22) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(74);
            Client.field326.method2807(XItemContainer.baseY + var1);
            Client.field326.method2942(var0 + FrameMap.baseX);
            Client.field326.method2760(class105.field1700[82]?1:0);
            Client.field326.method2807(var3);
         }

         if(var2 == 1002) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.field326.method3029(205);
            Client.field326.method2809(var3 >> 14 & 32767);
         }

         if(var2 == 23) {
            class6.region.method1707(class60.plane, var0, var1);
         }

         if(var2 == 31) {
            Client.field326.method3029(225);
            Client.field326.method2918(var0);
            Client.field326.method2918(class15.field169);
            Client.field326.method2817(var1);
            Client.field326.method2809(class6.field52);
            Client.field326.method2817(ObjectComposition.field2930);
            Client.field326.method2942(var3);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 18) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(20);
            Client.field326.method2809(XItemContainer.baseY + var1);
            Client.field326.method2942(FrameMap.baseX + var0);
            Client.field326.method2942(var3);
            Client.field326.method2799(class105.field1700[82]?1:0);
         }

         if(var2 == 32) {
            Client.field326.method3029(194);
            Client.field326.method2942(Client.field436);
            Client.field326.method2942(var0);
            Client.field326.method2818(var1);
            Client.field326.method2942(var3);
            Client.field326.method2848(class2.field16);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 45) {
            var14 = Client.cachedPlayers[var3];
            if(var14 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(139);
               Client.field326.method2800(class105.field1700[82]?1:0);
               Client.field326.method2918(var3);
            }
         }

         if(var2 == 21) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(11);
            Client.field326.method2942(var1 + XItemContainer.baseY);
            Client.field326.method2809(FrameMap.baseX + var0);
            Client.field326.method2760(class105.field1700[82]?1:0);
            Client.field326.method2809(var3);
         }

         if(var2 == 58) {
            var15 = class157.method3011(var1, var0);
            if(null != var15) {
               Client.field326.method3029(199);
               Client.field326.method2942(Client.field436);
               Client.field326.method2807(Client.field437);
               Client.field326.method2942(var0);
               Client.field326.method2848(var1);
               Client.field326.method2817(class2.field16);
               Client.field326.method2809(var15.item);
            }
         }

         int var13;
         if(var2 == 29) {
            Client.field326.method3029(253);
            Client.field326.method2763(var1);
            var15 = class44.method799(var1);
            if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
               var13 = var15.dynamicValues[0][1];
               if(class165.widgetSettings[var13] != var15.field2207[0]) {
                  class165.widgetSettings[var13] = var15.field2207[0];
                  CombatInfo2.method3532(var13);
               }
            }
         }

         if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(180);
               Client.field326.method2918(var3);
               Client.field326.method2799(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 1) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(250);
            Client.field326.method2918(XItemContainer.baseY + var1);
            Client.field326.method2760(class105.field1700[82]?1:0);
            Client.field326.method2817(ObjectComposition.field2930);
            Client.field326.method2809(var3 >> 14 & 32767);
            Client.field326.method2942(class6.field52);
            Client.field326.method2942(class15.field169);
            Client.field326.method2942(var0 + FrameMap.baseX);
         }

         if(var2 == 26) {
            Client.field326.method3029(249);

            for(WidgetNode var16 = (WidgetNode)Client.componentTable.method2344(); var16 != null; var16 = (WidgetNode)Client.componentTable.method2343()) {
               if(var16.field182 == 0 || var16.field182 == 3) {
                  class3.method31(var16, true);
               }
            }

            if(null != Client.field537) {
               class6.method87(Client.field537);
               Client.field537 = null;
            }
         }

         if(var2 == 49) {
            var14 = Client.cachedPlayers[var3];
            if(null != var14) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(245);
               Client.field326.method2807(var3);
               Client.field326.method2799(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 42) {
            Client.field326.method3029(179);
            Client.field326.method2942(var3);
            Client.field326.method2809(var0);
            Client.field326.method2817(var1);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 46) {
            var14 = Client.cachedPlayers[var3];
            if(var14 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(144);
               Client.field326.method2807(var3);
               Client.field326.method2799(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 2) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(3);
            Client.field326.method2918(var3 >> 14 & 32767);
            Client.field326.method2942(var0 + FrameMap.baseX);
            Client.field326.method2918(Client.field436);
            Client.field326.method2763(class2.field16);
            Client.field326.method2942(var1 + XItemContainer.baseY);
            Client.field326.method2801(class105.field1700[82]?1:0);
         }

         if(var2 == 47) {
            var14 = Client.cachedPlayers[var3];
            if(null != var14) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(175);
               Client.field326.method2801(class105.field1700[82]?1:0);
               Client.field326.method2942(var3);
            }
         }

         if(var2 == 1001) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(229);
            Client.field326.method2799(class105.field1700[82]?1:0);
            Client.field326.method2918(FrameMap.baseX + var0);
            Client.field326.method2807(var1 + XItemContainer.baseY);
            Client.field326.method2809(var3 >> 14 & 32767);
         }

         if(var2 == 28) {
            Client.field326.method3029(253);
            Client.field326.method2763(var1);
            var15 = class44.method799(var1);
            if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
               var13 = var15.dynamicValues[0][1];
               class165.widgetSettings[var13] = 1 - class165.widgetSettings[var13];
               CombatInfo2.method3532(var13);
            }
         }

         if(var2 == 34) {
            Client.field326.method3029(244);
            Client.field326.method2809(var3);
            Client.field326.method2848(var1);
            Client.field326.method2942(var0);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 57 || var2 == 1007) {
            var15 = class157.method3011(var1, var0);
            if(null != var15) {
               class8.method111(var3, var1, var0, var15.item, var5);
            }
         }

         if(var2 == 1005) {
            var15 = class44.method799(var1);
            if(var15 != null && var15.itemQuantities[var0] >= 100000) {
               class7.method99(27, "", var15.itemQuantities[var0] + " x " + class88.getItemDefinition(var3).name);
            } else {
               Client.field326.method3029(72);
               Client.field326.method2809(var3);
            }

            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 37) {
            Client.field326.method3029(236);
            Client.field326.method2807(var3);
            Client.field326.method2818(var1);
            Client.field326.method2942(var0);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 3) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(203);
            Client.field326.method2799(class105.field1700[82]?1:0);
            Client.field326.method2918(var1 + XItemContainer.baseY);
            Client.field326.method2918(var3 >> 14 & 32767);
            Client.field326.method2918(var0 + FrameMap.baseX);
         }

         if(var2 == 39) {
            Client.field326.method3029(146);
            Client.field326.method2807(var3);
            Client.field326.method2763(var1);
            Client.field326.method2809(var0);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 35) {
            Client.field326.method3029(171);
            Client.field326.method2807(var0);
            Client.field326.method2807(var3);
            Client.field326.method2848(var1);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 17) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(166);
            Client.field326.method2918(Client.field436);
            Client.field326.method2807(XItemContainer.baseY + var1);
            Client.field326.method2799(class105.field1700[82]?1:0);
            Client.field326.method2918(FrameMap.baseX + var0);
            Client.field326.method2763(class2.field16);
            Client.field326.method2809(var3);
         }

         if(var2 == 51) {
            var14 = Client.cachedPlayers[var3];
            if(var14 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(141);
               Client.field326.method2918(var3);
               Client.field326.method2799(class105.field1700[82]?1:0);
            }
         }

         if(var2 == 36) {
            Client.field326.method3029(152);
            Client.field326.method2807(var3);
            Client.field326.method2809(var0);
            Client.field326.method2818(var1);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 50) {
            var14 = Client.cachedPlayers[var3];
            if(null != var14) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(103);
               Client.field326.method2801(class105.field1700[82]?1:0);
               Client.field326.method2807(var3);
            }
         }

         if(var2 == 19) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(46);
            Client.field326.method2942(var3);
            Client.field326.method2760(class105.field1700[82]?1:0);
            Client.field326.method2918(XItemContainer.baseY + var1);
            Client.field326.method2807(var0 + FrameMap.baseX);
         }

         if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(129);
               Client.field326.method2807(var3);
               Client.field326.method2800(class105.field1700[82]?1:0);
               Client.field326.method2763(class2.field16);
               Client.field326.method2942(Client.field436);
            }
         }

         if(var2 == 48) {
            var14 = Client.cachedPlayers[var3];
            if(null != var14) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(202);
               Client.field326.method2801(class105.field1700[82]?1:0);
               Client.field326.method2809(var3);
            }
         }

         if(var2 == 16) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field326.method3029(228);
            Client.field326.method2801(class105.field1700[82]?1:0);
            Client.field326.method2763(ObjectComposition.field2930);
            Client.field326.method2918(class6.field52);
            Client.field326.method2942(class15.field169);
            Client.field326.method2918(var0 + FrameMap.baseX);
            Client.field326.method2918(XItemContainer.baseY + var1);
            Client.field326.method2807(var3);
         }

         if(var2 == 43) {
            Client.field326.method3029(119);
            Client.field326.method2918(var3);
            Client.field326.method2817(var1);
            Client.field326.method2942(var0);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 41) {
            Client.field326.method3029(53);
            Client.field326.method2809(var3);
            Client.field326.method2848(var1);
            Client.field326.method2809(var0);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 15) {
            var14 = Client.cachedPlayers[var3];
            if(var14 != null) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(84);
               Client.field326.method2942(var3);
               Client.field326.method2801(class105.field1700[82]?1:0);
               Client.field326.method2942(Client.field436);
               Client.field326.method2763(class2.field16);
            }
         }

         if(var2 == 1004) {
            Client.field390 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.field326.method3029(72);
            Client.field326.method2809(var3);
         }

         if(var2 == 40) {
            Client.field326.method3029(181);
            Client.field326.method2942(var0);
            Client.field326.method2918(var3);
            Client.field326.method2763(var1);
            Client.field531 = 0;
            PlayerComposition.field2164 = class44.method799(var1);
            Client.field395 = var0;
         }

         if(var2 == 38) {
            class18.method187();
            var15 = class44.method799(var1);
            Client.field447 = 1;
            class15.field169 = var0;
            ObjectComposition.field2930 = var1;
            class6.field52 = var3;
            class6.method87(var15);
            Client.field468 = class32.method691(16748608) + class88.getItemDefinition(var3).name + class32.method691(16777215);
            if(null == Client.field468) {
               Client.field468 = "null";
            }

         } else {
            if(var2 == 4) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(241);
               Client.field326.method2800(class105.field1700[82]?1:0);
               Client.field326.method2809(var3 >> 14 & 32767);
               Client.field326.method2807(FrameMap.baseX + var0);
               Client.field326.method2807(var1 + XItemContainer.baseY);
            }

            if(var2 == 5) {
               Client.field390 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field326.method3029(26);
               Client.field326.method2918(var3 >> 14 & 32767);
               Client.field326.method2800(class105.field1700[82]?1:0);
               Client.field326.method2918(var1 + XItemContainer.baseY);
               Client.field326.method2918(var0 + FrameMap.baseX);
            }

            if(var2 == 10) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field390 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field392 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field326.method3029(189);
                  Client.field326.method2800(class105.field1700[82]?1:0);
                  Client.field326.method2809(var3);
               }
            }

            if(var2 == 24) {
               var15 = class44.method799(var1);
               boolean var17 = true;
               if(var15.contentType > 0) {
                  var17 = class2.method26(var15);
               }

               if(var17) {
                  Client.field326.method3029(253);
                  Client.field326.method2763(var1);
               }
            }

            if(var2 == 7) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field390 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field392 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field326.method3029(106);
                  Client.field326.method2942(class15.field169);
                  Client.field326.method2942(class6.field52);
                  Client.field326.method2817(ObjectComposition.field2930);
                  Client.field326.method2807(var3);
                  Client.field326.method2799(class105.field1700[82]?1:0);
               }
            }

            if(Client.field447 != 0) {
               Client.field447 = 0;
               class6.method87(class44.method799(ObjectComposition.field2930));
            }

            if(Client.field435) {
               class18.method187();
            }

            if(PlayerComposition.field2164 != null && Client.field531 == 0) {
               class6.method87(PlayerComposition.field2164);
            }

         }
      }
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "587697724"
   )
   static void method695() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2344(); null != var0; var0 = (WidgetNode)Client.componentTable.method2343()) {
         int var1 = var0.id;
         if(class94.method1870(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2184;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class44.method799(var4);
               if(var5 != null) {
                  class6.method87(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "25"
   )
   protected final Model getModel() {
      class190 var1 = class185.method3389(this.field741);
      Model var2;
      if(!this.field742) {
         var2 = var1.method3446(this.field744);
      } else {
         var2 = var1.method3446(-1);
      }

      return null == var2?null:var2;
   }
}

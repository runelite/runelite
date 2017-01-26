import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class5 implements Comparator {
   @ObfuscatedName("d")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -1941766199
   )
   static int field58;

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-2143169803"
   )
   static final void method65(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method65(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2374((long)var3.id);
               if(var4 != null) {
                  class148.method2783(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && null != var3.field2303) {
               var5 = new class18();
               var5.field180 = var3;
               var5.field188 = var3.field2303;
               XItemContainer.method160(var5, 200000);
            }

            if(var1 == 1 && null != var3.field2257) {
               if(var3.index >= 0) {
                  Widget var6 = class37.method736(var3.id);
                  if(null == var6 || var6.children == null || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field180 = var3;
               var5.field188 = var3.field2257;
               XItemContainer.method160(var5, 200000);
            }
         }
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1319692076"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var8;
      if(var2 == 58) {
         var8 = class105.method1992(var1, var0);
         if(var8 != null) {
            Client.field394.method3037(116);
            Client.field394.method2802(class40.field814);
            Client.field394.method2837(Client.field433);
            Client.field394.method3002(var1);
            Client.field394.method2837(var8.item);
            Client.field394.method2837(var0);
            Client.field394.method2845(Client.field434);
         }
      }

      NPC var20;
      if(var2 == 1003) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            NPCComposition var9 = var20.composition;
            if(null != var9.configs) {
               var9 = var9.method3708();
            }

            if(null != var9) {
               Client.field394.method3037(8);
               Client.field394.method2845(var9.id);
            }
         }
      }

      Player var21;
      if(var2 == 15) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(117);
            Client.field394.method2802(class40.field814);
            Client.field394.method2799(class105.field1708[82]?1:0);
            Client.field394.method2904(Client.field433);
            Client.field394.method2904(var3);
         }
      }

      if(var2 == 11) {
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(198);
            Client.field394.method2845(var3);
            Client.field394.method2799(class105.field1708[82]?1:0);
         }
      }

      if(var2 == 10) {
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(218);
            Client.field394.method2838(class105.field1708[82]?1:0);
            Client.field394.method2870(var3);
         }
      }

      if(var2 == 48) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(31);
            Client.field394.method2837(var3);
            Client.field394.method2955(class105.field1708[82]?1:0);
         }
      }

      int var15;
      if(var2 == 28) {
         Client.field394.method3037(238);
         Client.field394.method2802(var1);
         var8 = class37.method736(var1);
         if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
            var15 = var8.dynamicValues[0][1];
            class165.widgetSettings[var15] = 1 - class165.widgetSettings[var15];
            class37.method732(var15);
         }
      }

      if(var2 == 5) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(96);
         Client.field394.method2904(var3 >> 14 & 32767);
         Client.field394.method2837(var1 + class3.baseY);
         Client.field394.method2837(Projectile.baseX + var0);
         Client.field394.method2955(class105.field1708[82]?1:0);
      }

      if(var2 == 57 || var2 == 1007) {
         var8 = class105.method1992(var1, var0);
         if(var8 != null) {
            var15 = var8.item;
            Widget var10 = class105.method1992(var1, var0);
            if(var10 != null) {
               if(var10.field2296 != null) {
                  class18 var11 = new class18();
                  var11.field180 = var10;
                  var11.field187 = var3;
                  var11.field190 = var5;
                  var11.field188 = var10.field2296;
                  XItemContainer.method160(var11, 200000);
               }

               boolean var16 = true;
               if(var10.contentType > 0) {
                  var16 = class3.method42(var10);
               }

               if(var16) {
                  int var13 = class36.method724(var10);
                  int var14 = var3 - 1;
                  boolean var12 = (var13 >> var14 + 1 & 1) != 0;
                  if(var12) {
                     if(var3 == 1) {
                        Client.field394.method3037(189);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 2) {
                        Client.field394.method3037(115);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 3) {
                        Client.field394.method3037(185);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 4) {
                        Client.field394.method3037(140);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 5) {
                        Client.field394.method3037(97);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 6) {
                        Client.field394.method3037(233);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 7) {
                        Client.field394.method3037(251);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 8) {
                        Client.field394.method3037(217);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 9) {
                        Client.field394.method3037(215);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }

                     if(var3 == 10) {
                        Client.field394.method3037(194);
                        Client.field394.method2802(var1);
                        Client.field394.method2837(var0);
                        Client.field394.method2837(var15);
                     }
                  }
               }
            }
         }
      }

      if(var2 == 6) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(202);
         Client.field394.method2799(class105.field1708[82]?1:0);
         Client.field394.method2870(class3.baseY + var1);
         Client.field394.method2837(Projectile.baseX + var0);
         Client.field394.method2870(var3 >> 14 & 32767);
      }

      if(var2 == 22) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(19);
         Client.field394.method2904(class3.baseY + var1);
         Client.field394.method2870(var3);
         Client.field394.method2870(Projectile.baseX + var0);
         Client.field394.method2838(class105.field1708[82]?1:0);
      }

      if(var2 == 18) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(128);
         Client.field394.method2837(Projectile.baseX + var0);
         Client.field394.method2837(class3.baseY + var1);
         Client.field394.method2955(class105.field1708[82]?1:0);
         Client.field394.method2904(var3);
      }

      if(var2 == 26) {
         Client.field394.method3037(181);

         for(WidgetNode var22 = (WidgetNode)Client.componentTable.method2361(); var22 != null; var22 = (WidgetNode)Client.componentTable.method2369()) {
            if(var22.field175 == 0 || var22.field175 == 3) {
               class9.method117(var22, true);
            }
         }

         if(Client.field441 != null) {
            class33.method682(Client.field441);
            Client.field441 = null;
         }
      }

      if(var2 == 31) {
         Client.field394.method3037(157);
         Client.field394.method2845(var0);
         Client.field394.method2845(var3);
         Client.field394.method2802(var1);
         Client.field394.method2845(Ignore.field202);
         Client.field394.method2802(Client.field472);
         Client.field394.method2904(class186.field2768);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 41) {
         Client.field394.method3037(154);
         Client.field394.method2837(var3);
         Client.field394.method2847(var1);
         Client.field394.method2837(var0);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 8) {
         var20 = Client.cachedNPCs[var3];
         if(null != var20) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(27);
            Client.field394.method2802(class40.field814);
            Client.field394.method2845(Client.field433);
            Client.field394.method2838(class105.field1708[82]?1:0);
            Client.field394.method2837(var3);
         }
      }

      if(var2 == 2) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(4);
         Client.field394.method2847(class40.field814);
         Client.field394.method2904(var0 + Projectile.baseX);
         Client.field394.method2845(Client.field433);
         Client.field394.method2837(class3.baseY + var1);
         Client.field394.method2845(var3 >> 14 & 32767);
         Client.field394.method2955(class105.field1708[82]?1:0);
      }

      if(var2 == 14) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(211);
            Client.field394.method2845(var3);
            Client.field394.method2870(Ignore.field202);
            Client.field394.method2799(class105.field1708[82]?1:0);
            Client.field394.method2870(class186.field2768);
            Client.field394.method2802(Client.field472);
         }
      }

      if(var2 == 50) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(48);
            Client.field394.method2904(var3);
            Client.field394.method2799(class105.field1708[82]?1:0);
         }
      }

      if(var2 == 51) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(43);
            Client.field394.method2837(var3);
            Client.field394.method2955(class105.field1708[82]?1:0);
         }
      }

      if(var2 == 45) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(42);
            Client.field394.method2838(class105.field1708[82]?1:0);
            Client.field394.method2837(var3);
         }
      }

      if(var2 == 32) {
         Client.field394.method3037(199);
         Client.field394.method2845(var3);
         Client.field394.method2904(var0);
         Client.field394.method3002(var1);
         Client.field394.method2904(Client.field433);
         Client.field394.method3002(class40.field814);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 13) {
         var20 = Client.cachedNPCs[var3];
         if(var20 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(99);
            Client.field394.method2839(class105.field1708[82]?1:0);
            Client.field394.method2837(var3);
         }
      }

      if(var2 == 1005) {
         var8 = class37.method736(var1);
         if(var8 != null && var8.itemQuantities[var0] >= 100000) {
            class103.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + class36.getItemDefinition(var3).name);
         } else {
            Client.field394.method3037(118);
            Client.field394.method2870(var3);
         }

         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 1004) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.field394.method3037(118);
         Client.field394.method2870(var3);
      }

      if(var2 == 43) {
         Client.field394.method3037(168);
         Client.field394.method2837(var3);
         Client.field394.method2904(var0);
         Client.field394.method2855(var1);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 9) {
         var20 = Client.cachedNPCs[var3];
         if(null != var20) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(171);
            Client.field394.method2838(class105.field1708[82]?1:0);
            Client.field394.method2904(var3);
         }
      }

      if(var2 == 35) {
         Client.field394.method3037(241);
         Client.field394.method3002(var1);
         Client.field394.method2904(var3);
         Client.field394.method2904(var0);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 3) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(61);
         Client.field394.method2845(var0 + Projectile.baseX);
         Client.field394.method2838(class105.field1708[82]?1:0);
         Client.field394.method2870(class3.baseY + var1);
         Client.field394.method2837(var3 >> 14 & 32767);
      }

      if(var2 == 29) {
         Client.field394.method3037(238);
         Client.field394.method2802(var1);
         var8 = class37.method736(var1);
         if(null != var8.dynamicValues && var8.dynamicValues[0][0] == 5) {
            var15 = var8.dynamicValues[0][1];
            if(var8.field2310[0] != class165.widgetSettings[var15]) {
               class165.widgetSettings[var15] = var8.field2310[0];
               class37.method732(var15);
            }
         }
      }

      if(var2 == 24) {
         var8 = class37.method736(var1);
         boolean var24 = true;
         if(var8.contentType > 0) {
            var24 = class3.method42(var8);
         }

         if(var24) {
            Client.field394.method3037(238);
            Client.field394.method2802(var1);
         }
      }

      if(var2 == 1001) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(158);
         Client.field394.method2870(var0 + Projectile.baseX);
         Client.field394.method2799(class105.field1708[82]?1:0);
         Client.field394.method2870(var3 >> 14 & 32767);
         Client.field394.method2845(class3.baseY + var1);
      }

      if(var2 == 40) {
         Client.field394.method3037(124);
         Client.field394.method2847(var1);
         Client.field394.method2845(var0);
         Client.field394.method2904(var3);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 7) {
         var20 = Client.cachedNPCs[var3];
         if(null != var20) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(35);
            Client.field394.method2839(class105.field1708[82]?1:0);
            Client.field394.method2845(class186.field2768);
            Client.field394.method2870(var3);
            Client.field394.method2847(Client.field472);
            Client.field394.method2904(Ignore.field202);
         }
      }

      if(var2 == 17) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(58);
         Client.field394.method2802(class40.field814);
         Client.field394.method2838(class105.field1708[82]?1:0);
         Client.field394.method2845(Projectile.baseX + var0);
         Client.field394.method2845(var3);
         Client.field394.method2837(Client.field433);
         Client.field394.method2904(var1 + class3.baseY);
      }

      if(var2 == 37) {
         Client.field394.method3037(172);
         Client.field394.method2802(var1);
         Client.field394.method2870(var0);
         Client.field394.method2904(var3);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 33) {
         Client.field394.method3037(224);
         Client.field394.method2904(var0);
         Client.field394.method2904(var3);
         Client.field394.method2847(var1);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 49) {
         var21 = Client.cachedPlayers[var3];
         if(var21 != null) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(247);
            Client.field394.method2839(class105.field1708[82]?1:0);
            Client.field394.method2837(var3);
         }
      }

      if(var2 == 1) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(197);
         Client.field394.method2904(var1 + class3.baseY);
         Client.field394.method2870(Ignore.field202);
         Client.field394.method2855(Client.field472);
         Client.field394.method2837(Projectile.baseX + var0);
         Client.field394.method2845(var3 >> 14 & 32767);
         Client.field394.method2870(class186.field2768);
         Client.field394.method2955(class105.field1708[82]?1:0);
      }

      if(var2 == 34) {
         Client.field394.method3037(152);
         Client.field394.method2904(var3);
         Client.field394.method2845(var0);
         Client.field394.method3002(var1);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 42) {
         Client.field394.method3037(188);
         Client.field394.method2870(var0);
         Client.field394.method2855(var1);
         Client.field394.method2845(var3);
         Client.field390 = 0;
         class57.field1063 = class37.method736(var1);
         Client.field391 = var0;
      }

      if(var2 == 4) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(56);
         Client.field394.method2837(var3 >> 14 & 32767);
         Client.field394.method2845(var0 + Projectile.baseX);
         Client.field394.method2837(class3.baseY + var1);
         Client.field394.method2955(class105.field1708[82]?1:0);
      }

      if(var2 == 12) {
         var20 = Client.cachedNPCs[var3];
         if(null != var20) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(216);
            Client.field394.method2870(var3);
            Client.field394.method2838(class105.field1708[82]?1:0);
         }
      }

      if(var2 == 46) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(144);
            Client.field394.method2837(var3);
            Client.field394.method2839(class105.field1708[82]?1:0);
         }
      }

      if(var2 == 44) {
         var21 = Client.cachedPlayers[var3];
         if(null != var21) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(64);
            Client.field394.method2870(var3);
            Client.field394.method2839(class105.field1708[82]?1:0);
         }
      }

      if(var2 == 1002) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.field394.method3037(150);
         Client.field394.method2845(var3 >> 14 & 32767);
      }

      if(var2 == 16) {
         Client.field420 = var6;
         Client.field464 = var7;
         Client.field371 = 2;
         Client.field388 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field394.method3037(76);
         Client.field394.method2904(var1 + class3.baseY);
         Client.field394.method2904(class186.field2768);
         Client.field394.method2870(Projectile.baseX + var0);
         Client.field394.method2955(class105.field1708[82]?1:0);
         Client.field394.method2870(var3);
         Client.field394.method2847(Client.field472);
         Client.field394.method2904(Ignore.field202);
      }

      if(var2 == 30 && Client.field441 == null) {
         class30.method657(var1, var0);
         Client.field441 = class105.method1992(var1, var0);
         class33.method682(Client.field441);
      }

      if(var2 == 25) {
         var8 = class105.method1992(var1, var0);
         if(null != var8) {
            class25.method574();
            int var19 = class36.method724(var8);
            var15 = var19 >> 11 & 63;
            int var23 = var8.item;
            Widget var18 = class105.method1992(var1, var0);
            if(var18 != null && null != var18.field2287) {
               class18 var17 = new class18();
               var17.field180 = var18;
               var17.field188 = var18.field2287;
               XItemContainer.method160(var17, 200000);
            }

            Client.field434 = var23;
            Client.field432 = true;
            class40.field814 = var1;
            Client.field433 = var0;
            class3.field29 = var15;
            class33.method682(var18);
            Client.field429 = 0;
            Client.field406 = MessageNode.method205(var8);
            if(Client.field406 == null) {
               Client.field406 = "Null";
            }

            if(var8.hasScript) {
               Client.field436 = var8.name + Client.method568(16777215);
            } else {
               Client.field436 = Client.method568('\uff00') + var8.field2313 + Client.method568(16777215);
            }
         }

      } else {
         if(var2 == 21) {
            Client.field420 = var6;
            Client.field464 = var7;
            Client.field371 = 2;
            Client.field388 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field394.method3037(254);
            Client.field394.method2845(class3.baseY + var1);
            Client.field394.method2839(class105.field1708[82]?1:0);
            Client.field394.method2845(Projectile.baseX + var0);
            Client.field394.method2845(var3);
         }

         if(var2 == 39) {
            Client.field394.method3037(226);
            Client.field394.method2904(var3);
            Client.field394.method2855(var1);
            Client.field394.method2904(var0);
            Client.field390 = 0;
            class57.field1063 = class37.method736(var1);
            Client.field391 = var0;
         }

         if(var2 == 23) {
            if(Client.isMenuOpen) {
               Renderable.region.method1841();
            } else {
               Renderable.region.method1736(WallObject.plane, var0, var1, true);
            }
         }

         if(var2 == 36) {
            Client.field394.method3037(255);
            Client.field394.method2904(var3);
            Client.field394.method2855(var1);
            Client.field394.method2904(var0);
            Client.field390 = 0;
            class57.field1063 = class37.method736(var1);
            Client.field391 = var0;
         }

         if(var2 == 38) {
            class25.method574();
            var8 = class37.method736(var1);
            Client.field429 = 1;
            Ignore.field202 = var0;
            Client.field472 = var1;
            class186.field2768 = var3;
            class33.method682(var8);
            Client.field431 = Client.method568(16748608) + class36.getItemDefinition(var3).name + Client.method568(16777215);
            if(null == Client.field431) {
               Client.field431 = "null";
            }

         } else {
            if(var2 == 19) {
               Client.field420 = var6;
               Client.field464 = var7;
               Client.field371 = 2;
               Client.field388 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field394.method3037(220);
               Client.field394.method2839(class105.field1708[82]?1:0);
               Client.field394.method2904(class3.baseY + var1);
               Client.field394.method2845(var3);
               Client.field394.method2870(var0 + Projectile.baseX);
            }

            if(var2 == 47) {
               var21 = Client.cachedPlayers[var3];
               if(null != var21) {
                  Client.field420 = var6;
                  Client.field464 = var7;
                  Client.field371 = 2;
                  Client.field388 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field394.method3037(159);
                  Client.field394.method2904(var3);
                  Client.field394.method2838(class105.field1708[82]?1:0);
               }
            }

            if(var2 == 20) {
               Client.field420 = var6;
               Client.field464 = var7;
               Client.field371 = 2;
               Client.field388 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field394.method3037(89);
               Client.field394.method2904(var0 + Projectile.baseX);
               Client.field394.method2837(var1 + class3.baseY);
               Client.field394.method2845(var3);
               Client.field394.method2799(class105.field1708[82]?1:0);
            }

            if(Client.field429 != 0) {
               Client.field429 = 0;
               class33.method682(class37.method736(Client.field472));
            }

            if(Client.field432) {
               class25.method574();
            }

            if(null != class57.field1063 && Client.field390 == 0) {
               class33.method682(class57.field1063);
            }

         }
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method79((class2)var1, (class2)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "616807958"
   )
   static void method78(int var0) {
      if(var0 != -1) {
         if(class103.method1973(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2277 != null) {
                  class18 var4 = new class18();
                  var4.field180 = var3;
                  var4.field188 = var3.field2277;
                  XItemContainer.method160(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "7"
   )
   int method79(class2 var1, class2 var2) {
      return var1.field18.price < var2.field18.price?-1:(var1.field18.price == var2.field18.price?0:1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-90"
   )
   static final void method80(boolean var0) {
      for(int var1 = 0; var1 < Client.field316; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field419[var1]];
         int var3 = (Client.field419[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod702() && var0 == var2.composition.isVisible && var2.composition.method3715()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field596 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field524 == Client.field287[var4][var5]) {
                     continue;
                  }

                  Client.field287[var4][var5] = Client.field524;
               }

               if(!var2.composition.field3026) {
                  var3 -= Integer.MIN_VALUE;
               }

               Renderable.region.method1710(WallObject.plane, var2.x, var2.y, class65.method1153(var2.x + (var2.field596 * 64 - 64), var2.field596 * 64 - 64 + var2.y, WallObject.plane), 60 + (var2.field596 * 64 - 64), var2, var2.angle, var3, var2.field637);
            }
         }
      }

   }
}

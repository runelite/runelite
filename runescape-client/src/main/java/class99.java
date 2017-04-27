import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class99 extends class109 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 4993696380198297753L
   )
   long field1630 = class72.method1421();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1809611801
   )
   int field1631 = 256;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 572386227
   )
   int field1633 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -808928943
   )
   int field1634 = 1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -981803925
   )
   int field1635;
   @ObfuscatedName("d")
   long[] field1637 = new long[10];
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = -1233655913
   )
   static int field1638;

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1637[var1] = this.field1630;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "29"
   )
   int vmethod2063(int var1, int var2) {
      int var3 = this.field1631;
      int var4 = this.field1634;
      this.field1631 = 300;
      this.field1634 = 1;
      this.field1630 = class72.method1421();
      if(this.field1637[this.field1635] == 0L) {
         this.field1631 = var3;
         this.field1634 = var4;
      } else if(this.field1630 > this.field1637[this.field1635]) {
         this.field1631 = (int)((long)(var1 * 2560) / (this.field1630 - this.field1637[this.field1635]));
      }

      if(this.field1631 < 25) {
         this.field1631 = 25;
      }

      if(this.field1631 > 256) {
         this.field1631 = 256;
         this.field1634 = (int)((long)var1 - (this.field1630 - this.field1637[this.field1635]) / 10L);
      }

      if(this.field1634 > var1) {
         this.field1634 = var1;
      }

      this.field1637[this.field1635] = this.field1630;
      this.field1635 = (this.field1635 + 1) % 10;
      int var5;
      if(this.field1634 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1637[var5]) {
               this.field1637[var5] += (long)this.field1634;
            }
         }
      }

      if(this.field1634 < var2) {
         this.field1634 = var2;
      }

      class0.method14((long)this.field1634);

      for(var5 = 0; this.field1633 < 256; this.field1633 += this.field1631) {
         ++var5;
      }

      this.field1633 &= 255;
      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   public void vmethod2062() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1637[var1] = 0L;
      }

   }

   @ObfuscatedName("c")
   static final void method1945(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2041038373"
   )
   static final void method1946(int var0) {
      if(class112.method2112(var0)) {
         Widget[] var1 = class133.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2329 = 0;
               var3.field2214 = 0;
            }
         }

      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-836939919"
   )
   static final void method1947(Actor var0, int var1) {
      CombatInfo1.method601(var0.x, var0.y, var1);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1332447491"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 32) {
         Client.secretCipherBuffer1.putOpcode(27);
         Client.secretCipherBuffer1.method2526(var3);
         Client.secretCipherBuffer1.method2526(var0);
         Client.secretCipherBuffer1.method2427(XClanMember.field269);
         Client.secretCipherBuffer1.method2427(var1);
         Client.secretCipherBuffer1.method2375(Client.field441);
         Client.field394 = 0;
         class32.field732 = class128.method2364(var1);
         Client.field395 = var0;
      }

      Widget var8;
      if(var2 == 25) {
         var8 = class0.method13(var1, var0);
         if(var8 != null) {
            class85.method1713();
            class112.method2109(var1, var0, CombatInfo2.method3540(class103.method1988(var8)), var8.item);
            Client.field351 = 0;
            String var19;
            if(CombatInfo2.method3540(class103.method1988(var8)) == 0) {
               var19 = null;
            } else if(var8.field2286 != null && var8.field2286.trim().length() != 0) {
               var19 = var8.field2286;
            } else {
               var19 = null;
            }

            Client.field438 = var19;
            if(Client.field438 == null) {
               Client.field438 = "Null";
            }

            if(var8.hasScript) {
               Client.field392 = var8.name + class213.method4037(16777215);
            } else {
               Client.field392 = class213.method4037('\uff00') + var8.field2213 + class213.method4037(16777215);
            }
         }

      } else {
         if(var2 == 39) {
            Client.secretCipherBuffer1.putOpcode(101);
            Client.secretCipherBuffer1.method2526(var3);
            Client.secretCipherBuffer1.method2526(var0);
            Client.secretCipherBuffer1.method2426(var1);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 43) {
            Client.secretCipherBuffer1.putOpcode(116);
            Client.secretCipherBuffer1.method2427(var1);
            Client.secretCipherBuffer1.method2526(var3);
            Client.secretCipherBuffer1.putShort(var0);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 1) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(224);
            Client.secretCipherBuffer1.method2375(var0 + class108.baseX);
            Client.secretCipherBuffer1.method2427(class72.field1171);
            Client.secretCipherBuffer1.putShort(Player.field264);
            Client.secretCipherBuffer1.putShort(class182.field2701);
            Client.secretCipherBuffer1.method2526(GameEngine.baseY + var1);
            Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
            Client.secretCipherBuffer1.putShort(var3 >> 14 & 32767);
         }

         int var15;
         if(var2 == 57 || var2 == 1007) {
            var8 = class0.method13(var1, var0);
            if(var8 != null) {
               var15 = var8.item;
               Widget var10 = class0.method13(var1, var0);
               if(var10 != null) {
                  if(var10.field2307 != null) {
                     class18 var11 = new class18();
                     var11.field189 = var10;
                     var11.field192 = var3;
                     var11.field190 = var5;
                     var11.field196 = var10.field2307;
                     Script.method910(var11, 200000);
                  }

                  boolean var16 = true;
                  if(var10.contentType > 0) {
                     var16 = Player.method241(var10);
                  }

                  if(var16) {
                     int var13 = class103.method1988(var10);
                     int var14 = var3 - 1;
                     boolean var12 = (var13 >> var14 + 1 & 1) != 0;
                     if(var12) {
                        if(var3 == 1) {
                           Client.secretCipherBuffer1.putOpcode(190);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 2) {
                           Client.secretCipherBuffer1.putOpcode(52);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 3) {
                           Client.secretCipherBuffer1.putOpcode(87);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 4) {
                           Client.secretCipherBuffer1.putOpcode(205);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 5) {
                           Client.secretCipherBuffer1.putOpcode(200);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 6) {
                           Client.secretCipherBuffer1.putOpcode(187);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 7) {
                           Client.secretCipherBuffer1.putOpcode(131);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 8) {
                           Client.secretCipherBuffer1.putOpcode(248);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 9) {
                           Client.secretCipherBuffer1.putOpcode(244);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }

                        if(var3 == 10) {
                           Client.secretCipherBuffer1.putOpcode(88);
                           Client.secretCipherBuffer1.putInt(var1);
                           Client.secretCipherBuffer1.putShort(var0);
                           Client.secretCipherBuffer1.putShort(var15);
                        }
                     }
                  }
               }
            }
         }

         Player var17;
         if(var2 == 50) {
            var17 = Client.cachedPlayers[var3];
            if(var17 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(40);
               Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2375(var3);
            }
         }

         if(var2 == 30 && Client.field449 == null) {
            class40.method780(var1, var0);
            Client.field449 = class0.method13(var1, var0);
            class124.method2350(Client.field449);
         }

         if(var2 == 1004) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.secretCipherBuffer1.putOpcode(81);
            Client.secretCipherBuffer1.putShort(var3);
         }

         if(var2 == 37) {
            Client.secretCipherBuffer1.putOpcode(150);
            Client.secretCipherBuffer1.method2427(var1);
            Client.secretCipherBuffer1.method2375(var3);
            Client.secretCipherBuffer1.putShort(var0);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         NPC var18;
         if(var2 == 1003) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               NPCComposition var9 = var18.composition;
               if(var9.configs != null) {
                  var9 = var9.method3804();
               }

               if(var9 != null) {
                  Client.secretCipherBuffer1.putOpcode(105);
                  Client.secretCipherBuffer1.method2375(var9.id);
               }
            }
         }

         if(var2 == 24) {
            var8 = class128.method2364(var1);
            boolean var21 = true;
            if(var8.contentType > 0) {
               var21 = Player.method241(var8);
            }

            if(var21) {
               Client.secretCipherBuffer1.putOpcode(229);
               Client.secretCipherBuffer1.putInt(var1);
            }
         }

         if(var2 == 58) {
            var8 = class0.method13(var1, var0);
            if(var8 != null) {
               Client.secretCipherBuffer1.putOpcode(44);
               Client.secretCipherBuffer1.method2375(var8.item);
               Client.secretCipherBuffer1.method2427(var1);
               Client.secretCipherBuffer1.putShort(Client.field537);
               Client.secretCipherBuffer1.putShort(Client.field441);
               Client.secretCipherBuffer1.method2526(var0);
               Client.secretCipherBuffer1.putInt(XClanMember.field269);
            }
         }

         if(var2 == 35) {
            Client.secretCipherBuffer1.putOpcode(69);
            Client.secretCipherBuffer1.putShort(var0);
            Client.secretCipherBuffer1.putInt(var1);
            Client.secretCipherBuffer1.method2416(var3);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 16) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(211);
            Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
            Client.secretCipherBuffer1.method2375(class182.field2701);
            Client.secretCipherBuffer1.method2526(Player.field264);
            Client.secretCipherBuffer1.method2526(var3);
            Client.secretCipherBuffer1.method2526(GameEngine.baseY + var1);
            Client.secretCipherBuffer1.method2375(class108.baseX + var0);
            Client.secretCipherBuffer1.method2426(class72.field1171);
         }

         if(var2 == 46) {
            var17 = Client.cachedPlayers[var3];
            if(var17 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(119);
               Client.secretCipherBuffer1.method2416(var3);
               Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
            }
         }

         if(var2 == 7) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(103);
               Client.secretCipherBuffer1.method2375(Player.field264);
               Client.secretCipherBuffer1.method2416(var3);
               Client.secretCipherBuffer1.method2426(class72.field1171);
               Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2526(class182.field2701);
            }
         }

         if(var2 == 4) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(30);
            Client.secretCipherBuffer1.method2526(var3 >> 14 & 32767);
            Client.secretCipherBuffer1.method2375(class108.baseX + var0);
            Client.secretCipherBuffer1.method2375(GameEngine.baseY + var1);
            Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
         }

         if(var2 == 9) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(198);
               Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.putShort(var3);
            }
         }

         if(var2 == 51) {
            var17 = Client.cachedPlayers[var3];
            if(var17 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(185);
               Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2526(var3);
            }
         }

         if(var2 == 23) {
            if(Client.isMenuOpen) {
               class172.region.method1857();
            } else {
               class172.region.method1758(Client.plane, var0, var1, true);
            }
         }

         if(var2 == 48) {
            var17 = Client.cachedPlayers[var3];
            if(var17 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(125);
               Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2375(var3);
            }
         }

         if(var2 == 26) {
            Client.secretCipherBuffer1.putOpcode(197);

            for(WidgetNode var20 = (WidgetNode)Client.componentTable.method2776(); var20 != null; var20 = (WidgetNode)Client.componentTable.method2777()) {
               if(var20.field179 == 0 || var20.field179 == 3) {
                  FrameMap.method1718(var20, true);
               }
            }

            if(Client.field449 != null) {
               class124.method2350(Client.field449);
               Client.field449 = null;
            }
         }

         if(var2 == 12) {
            var18 = Client.cachedNPCs[var3];
            if(var18 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(96);
               Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2375(var3);
            }
         }

         if(var2 == 1005) {
            var8 = class128.method2364(var1);
            if(var8 != null && var8.itemQuantities[var0] >= 100000) {
               WidgetNode.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + class47.getItemDefinition(var3).name);
            } else {
               Client.secretCipherBuffer1.putOpcode(81);
               Client.secretCipherBuffer1.putShort(var3);
            }

            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 36) {
            Client.secretCipherBuffer1.putOpcode(99);
            Client.secretCipherBuffer1.putInt(var1);
            Client.secretCipherBuffer1.method2416(var0);
            Client.secretCipherBuffer1.method2416(var3);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 22) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(239);
            Client.secretCipherBuffer1.method2416(var1 + GameEngine.baseY);
            Client.secretCipherBuffer1.method2416(var3);
            Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
            Client.secretCipherBuffer1.putShort(class108.baseX + var0);
         }

         if(var2 == 34) {
            Client.secretCipherBuffer1.putOpcode(152);
            Client.secretCipherBuffer1.method2526(var3);
            Client.secretCipherBuffer1.method2411(var1);
            Client.secretCipherBuffer1.method2526(var0);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 5) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(247);
            Client.secretCipherBuffer1.method2526(var3 >> 14 & 32767);
            Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
            Client.secretCipherBuffer1.method2526(var0 + class108.baseX);
            Client.secretCipherBuffer1.method2375(var1 + GameEngine.baseY);
         }

         if(var2 == 42) {
            Client.secretCipherBuffer1.putOpcode(160);
            Client.secretCipherBuffer1.method2375(var0);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.putInt(var1);
            Client.field394 = 0;
            class32.field732 = class128.method2364(var1);
            Client.field395 = var0;
         }

         if(var2 == 14) {
            var17 = Client.cachedPlayers[var3];
            if(var17 != null) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(6);
               Client.secretCipherBuffer1.method2416(Player.field264);
               Client.secretCipherBuffer1.method2416(var3);
               Client.secretCipherBuffer1.method2426(class72.field1171);
               Client.secretCipherBuffer1.method2416(class182.field2701);
               Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
            }
         }

         if(var2 == 2) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(115);
            Client.secretCipherBuffer1.method2375(var0 + class108.baseX);
            Client.secretCipherBuffer1.method2416(var3 >> 14 & 32767);
            Client.secretCipherBuffer1.method2526(GameEngine.baseY + var1);
            Client.secretCipherBuffer1.method2375(Client.field441);
            Client.secretCipherBuffer1.putInt(XClanMember.field269);
            Client.secretCipherBuffer1.putByte(class105.field1695[82]?1:0);
         }

         if(var2 == 18) {
            Client.field550 = var6;
            Client.field391 = var7;
            Client.field393 = 2;
            Client.field333 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(136);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
            Client.secretCipherBuffer1.method2526(class108.baseX + var0);
            Client.secretCipherBuffer1.method2526(GameEngine.baseY + var1);
         }

         if(var2 == 38) {
            class85.method1713();
            var8 = class128.method2364(var1);
            Client.field351 = 1;
            Player.field264 = var0;
            class72.field1171 = var1;
            class182.field2701 = var3;
            class124.method2350(var8);
            Client.field439 = class213.method4037(16748608) + class47.getItemDefinition(var3).name + class213.method4037(16777215);
            if(Client.field439 == null) {
               Client.field439 = "null";
            }

         } else {
            if(var2 == 1002) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.secretCipherBuffer1.putOpcode(174);
               Client.secretCipherBuffer1.method2375(var3 >> 14 & 32767);
            }

            if(var2 == 13) {
               var18 = Client.cachedNPCs[var3];
               if(var18 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(49);
                  Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
                  Client.secretCipherBuffer1.method2526(var3);
               }
            }

            if(var2 == 41) {
               Client.secretCipherBuffer1.putOpcode(217);
               Client.secretCipherBuffer1.method2427(var1);
               Client.secretCipherBuffer1.method2375(var0);
               Client.secretCipherBuffer1.method2416(var3);
               Client.field394 = 0;
               class32.field732 = class128.method2364(var1);
               Client.field395 = var0;
            }

            if(var2 == 47) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(73);
                  Client.secretCipherBuffer1.method2526(var3);
                  Client.secretCipherBuffer1.putByte(class105.field1695[82]?1:0);
               }
            }

            if(var2 == 28) {
               Client.secretCipherBuffer1.putOpcode(229);
               Client.secretCipherBuffer1.putInt(var1);
               var8 = class128.method2364(var1);
               if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
                  var15 = var8.dynamicValues[0][1];
                  class167.widgetSettings[var15] = 1 - class167.widgetSettings[var15];
                  class167.method3139(var15);
               }
            }

            if(var2 == 33) {
               Client.secretCipherBuffer1.putOpcode(201);
               Client.secretCipherBuffer1.putShort(var0);
               Client.secretCipherBuffer1.method2426(var1);
               Client.secretCipherBuffer1.putShort(var3);
               Client.field394 = 0;
               class32.field732 = class128.method2364(var1);
               Client.field395 = var0;
            }

            if(var2 == 19) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(4);
               Client.secretCipherBuffer1.putShort(var3);
               Client.secretCipherBuffer1.method2526(GameEngine.baseY + var1);
               Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.putShort(class108.baseX + var0);
            }

            if(var2 == 3) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(203);
               Client.secretCipherBuffer1.method2416(var1 + GameEngine.baseY);
               Client.secretCipherBuffer1.method2375(class108.baseX + var0);
               Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2375(var3 >> 14 & 32767);
            }

            if(var2 == 21) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(158);
               Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2375(var3);
               Client.secretCipherBuffer1.method2526(GameEngine.baseY + var1);
               Client.secretCipherBuffer1.method2375(class108.baseX + var0);
            }

            if(var2 == 40) {
               Client.secretCipherBuffer1.putOpcode(3);
               Client.secretCipherBuffer1.method2416(var0);
               Client.secretCipherBuffer1.method2427(var1);
               Client.secretCipherBuffer1.putShort(var3);
               Client.field394 = 0;
               class32.field732 = class128.method2364(var1);
               Client.field395 = var0;
            }

            if(var2 == 15) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(48);
                  Client.secretCipherBuffer1.method2526(Client.field441);
                  Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
                  Client.secretCipherBuffer1.method2526(var3);
                  Client.secretCipherBuffer1.putInt(XClanMember.field269);
               }
            }

            if(var2 == 6) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(252);
               Client.secretCipherBuffer1.method2375(GameEngine.baseY + var1);
               Client.secretCipherBuffer1.putShort(var3 >> 14 & 32767);
               Client.secretCipherBuffer1.putByte(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2375(var0 + class108.baseX);
            }

            if(var2 == 20) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(137);
               Client.secretCipherBuffer1.method2416(var1 + GameEngine.baseY);
               Client.secretCipherBuffer1.putShort(var0 + class108.baseX);
               Client.secretCipherBuffer1.method2416(var3);
               Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
            }

            if(var2 == 10) {
               var18 = Client.cachedNPCs[var3];
               if(var18 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(53);
                  Client.secretCipherBuffer1.putByte(class105.field1695[82]?1:0);
                  Client.secretCipherBuffer1.method2375(var3);
               }
            }

            if(var2 == 17) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(140);
               Client.secretCipherBuffer1.putShort(var1 + GameEngine.baseY);
               Client.secretCipherBuffer1.method2375(var0 + class108.baseX);
               Client.secretCipherBuffer1.putShort(Client.field441);
               Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.method2416(var3);
               Client.secretCipherBuffer1.method2411(XClanMember.field269);
            }

            if(var2 == 29) {
               Client.secretCipherBuffer1.putOpcode(229);
               Client.secretCipherBuffer1.putInt(var1);
               var8 = class128.method2364(var1);
               if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
                  var15 = var8.dynamicValues[0][1];
                  if(class167.widgetSettings[var15] != var8.field2321[0]) {
                     class167.widgetSettings[var15] = var8.field2321[0];
                     class167.method3139(var15);
                  }
               }
            }

            if(var2 == 31) {
               Client.secretCipherBuffer1.putOpcode(28);
               Client.secretCipherBuffer1.putInt(var1);
               Client.secretCipherBuffer1.method2426(class72.field1171);
               Client.secretCipherBuffer1.method2416(Player.field264);
               Client.secretCipherBuffer1.method2526(class182.field2701);
               Client.secretCipherBuffer1.method2416(var3);
               Client.secretCipherBuffer1.putShort(var0);
               Client.field394 = 0;
               class32.field732 = class128.method2364(var1);
               Client.field395 = var0;
            }

            if(var2 == 45) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(90);
                  Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
                  Client.secretCipherBuffer1.method2526(var3);
               }
            }

            if(var2 == 49) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(32);
                  Client.secretCipherBuffer1.method2526(var3);
                  Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
               }
            }

            if(var2 == 8) {
               var18 = Client.cachedNPCs[var3];
               if(var18 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(65);
                  Client.secretCipherBuffer1.method2375(Client.field441);
                  Client.secretCipherBuffer1.method2416(var3);
                  Client.secretCipherBuffer1.method2426(XClanMember.field269);
                  Client.secretCipherBuffer1.method2406(class105.field1695[82]?1:0);
               }
            }

            if(var2 == 1001) {
               Client.field550 = var6;
               Client.field391 = var7;
               Client.field393 = 2;
               Client.field333 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(234);
               Client.secretCipherBuffer1.putByte(class105.field1695[82]?1:0);
               Client.secretCipherBuffer1.putShort(var1 + GameEngine.baseY);
               Client.secretCipherBuffer1.method2375(var3 >> 14 & 32767);
               Client.secretCipherBuffer1.putShort(var0 + class108.baseX);
            }

            if(var2 == 44) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(164);
                  Client.secretCipherBuffer1.putShort(var3);
                  Client.secretCipherBuffer1.method2429(class105.field1695[82]?1:0);
               }
            }

            if(var2 == 11) {
               var18 = Client.cachedNPCs[var3];
               if(var18 != null) {
                  Client.field550 = var6;
                  Client.field391 = var7;
                  Client.field393 = 2;
                  Client.field333 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(78);
                  Client.secretCipherBuffer1.method2526(var3);
                  Client.secretCipherBuffer1.method2499(class105.field1695[82]?1:0);
               }
            }

            if(Client.field351 != 0) {
               Client.field351 = 0;
               class124.method2350(class128.method2364(class72.field1171));
            }

            if(Client.field440) {
               class85.method1713();
            }

            if(class32.field732 != null && Client.field394 == 0) {
               class124.method2350(class32.field732);
            }

         }
      }
   }
}

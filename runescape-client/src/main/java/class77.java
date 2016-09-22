import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class77 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -326368291
   )
   int field1439;
   @ObfuscatedName("t")
   int[][] field1440;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1116123113
   )
   int field1441;

   public class77(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1439 = var1;
         this.field1441 = var2;
         this.field1440 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1440[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(7.0D + var9);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
            }
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-284865000"
   )
   byte[] method1634(byte[] var1) {
      if(this.field1440 != null) {
         int var2 = (int)((long)this.field1441 * (long)var1.length / (long)this.field1439) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1440[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1441;
            var9 = var5 / this.field1439;
            var4 += var9;
            var5 -= this.field1439 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-2"
   )
   int method1635(int var1) {
      if(this.field1440 != null) {
         var1 = (int)((long)var1 * (long)this.field1441 / (long)this.field1439);
      }

      return var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1251812665"
   )
   int method1636(int var1) {
      if(null != this.field1440) {
         var1 = 6 + (int)((long)this.field1441 * (long)var1 / (long)this.field1439);
      }

      return var1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "1"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 16) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(114);
         Client.field323.method2562(class10.field164);
         Client.field323.method2564(class12.field176);
         Client.field323.method2563(var3);
         Client.field323.method2552(class140.field2190[82]?1:0);
         Client.field323.method2563(class22.field591);
         Client.field323.method2563(var1 + KitDefinition.baseY);
         Client.field323.method2562(var0 + class9.baseX);
      }

      if(var2 == 35) {
         Client.field323.method2801(221);
         Client.field323.method2711(var0);
         Client.field323.method2711(var3);
         Client.field323.method2564(var1);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      if(var2 == 4) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(155);
         Client.field323.method2514(class9.baseX + var0);
         Client.field323.method2563(var3 >> 14 & 32767);
         Client.field323.method2711(var1 + KitDefinition.baseY);
         Client.field323.method2554(class140.field2190[82]?1:0);
      }

      Player var8;
      if(var2 == 15) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(9);
            Client.field323.method2514(Client.field436);
            Client.field323.method2514(var3);
            Client.field323.method2552(class140.field2190[82]?1:0);
            Client.field323.method2564(XClanMember.field638);
         }
      }

      if(var2 == 1001) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(236);
         Client.field323.method2563(var3 >> 14 & 32767);
         Client.field323.method2562(var0 + class9.baseX);
         Client.field323.method2513(class140.field2190[82]?1:0);
         Client.field323.method2711(var1 + KitDefinition.baseY);
      }

      NPC var14;
      if(var2 == 8) {
         var14 = Client.cachedNPCs[var3];
         if(var14 != null) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(45);
            Client.field323.method2554(class140.field2190[82]?1:0);
            Client.field323.method2514(var3);
            Client.field323.method2562(Client.field436);
            Client.field323.method2572(XClanMember.field638);
         }
      }

      if(var2 == 7) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(42);
            Client.field323.method2562(class10.field164);
            Client.field323.method2554(class140.field2190[82]?1:0);
            Client.field323.method2564(class12.field176);
            Client.field323.method2563(class22.field591);
            Client.field323.method2514(var3);
         }
      }

      if(var2 == 1) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(94);
         Client.field323.method2711(class10.field164);
         Client.field323.method2558(class140.field2190[82]?1:0);
         Client.field323.method2562(var0 + class9.baseX);
         Client.field323.method2563(var3 >> 14 & 32767);
         Client.field323.method2514(class22.field591);
         Client.field323.method2563(KitDefinition.baseY + var1);
         Client.field323.method2564(class12.field176);
      }

      if(var2 == 30 && null == Client.field444) {
         class1.method6(var1, var0);
         Client.field444 = class38.method781(var1, var0);
         class53.method1101(Client.field444);
      }

      if(var2 == 11) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(203);
            Client.field323.method2552(class140.field2190[82]?1:0);
            Client.field323.method2563(var3);
         }
      }

      if(var2 == 37) {
         Client.field323.method2801(106);
         Client.field323.method2600(var1);
         Client.field323.method2563(var0);
         Client.field323.method2563(var3);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      if(var2 == 5) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(231);
         Client.field323.method2514(var3 >> 14 & 32767);
         Client.field323.method2711(var0 + class9.baseX);
         Client.field323.method2514(var1 + KitDefinition.baseY);
         Client.field323.method2554(class140.field2190[82]?1:0);
      }

      Widget var15;
      if(var2 == 24) {
         var15 = class24.method600(var1);
         boolean var9 = true;
         if(var15.contentType > 0) {
            var9 = class159.method3209(var15);
         }

         if(var9) {
            Client.field323.method2801(68);
            Client.field323.method2600(var1);
         }
      }

      if(var2 == 47) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(200);
            Client.field323.method2514(var3);
            Client.field323.method2552(class140.field2190[82]?1:0);
         }
      }

      if(var2 == 18) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(110);
         Client.field323.method2711(var3);
         Client.field323.method2563(var1 + KitDefinition.baseY);
         Client.field323.method2552(class140.field2190[82]?1:0);
         Client.field323.method2563(class9.baseX + var0);
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(147);
            Client.field323.method2558(class140.field2190[82]?1:0);
            Client.field323.method2711(var3);
         }
      }

      if(var2 == 12) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(166);
            Client.field323.method2563(var3);
            Client.field323.method2558(class140.field2190[82]?1:0);
         }
      }

      if(var2 == 1003) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            NPCComposition var12 = var14.composition;
            if(var12.field923 != null) {
               var12 = var12.method810();
            }

            if(null != var12) {
               Client.field323.method2801(26);
               Client.field323.method2514(var12.id);
            }
         }
      }

      if(var2 == 40) {
         Client.field323.method2801(118);
         Client.field323.method2563(var0);
         Client.field323.method2514(var3);
         Client.field323.method2600(var1);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      if(var2 == 41) {
         Client.field323.method2801(220);
         Client.field323.method2563(var3);
         Client.field323.method2562(var0);
         Client.field323.method2572(var1);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      if(var2 == 43) {
         Client.field323.method2801(71);
         Client.field323.method2514(var0);
         Client.field323.method2572(var1);
         Client.field323.method2562(var3);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      if(var2 == 6) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(146);
         Client.field323.method2563(KitDefinition.baseY + var1);
         Client.field323.method2558(class140.field2190[82]?1:0);
         Client.field323.method2711(var3 >> 14 & 32767);
         Client.field323.method2514(var0 + class9.baseX);
      }

      if(var2 == 13) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(238);
            Client.field323.method2558(class140.field2190[82]?1:0);
            Client.field323.method2562(var3);
         }
      }

      if(var2 == 46) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(245);
            Client.field323.method2554(class140.field2190[82]?1:0);
            Client.field323.method2563(var3);
         }
      }

      if(var2 == 23) {
         class16.region.method1984(Item.plane, var0, var1);
      }

      if(var2 == 9) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(35);
            Client.field323.method2562(var3);
            Client.field323.method2554(class140.field2190[82]?1:0);
         }
      }

      if(var2 == 32) {
         Client.field323.method2801(76);
         Client.field323.method2600(XClanMember.field638);
         Client.field323.method2541(var1);
         Client.field323.method2514(var3);
         Client.field323.method2514(var0);
         Client.field323.method2514(Client.field436);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      int var16;
      if(var2 == 57 || var2 == 1007) {
         var15 = class38.method781(var1, var0);
         if(var15 != null) {
            var16 = var15.item;
            Widget var10 = class38.method781(var1, var0);
            if(null != var10) {
               if(null != var10.field2887) {
                  class0 var11 = new class0();
                  var11.field2 = var10;
                  var11.field10 = var3;
                  var11.field0 = var5;
                  var11.field7 = var10.field2887;
                  class1.method9(var11, 200000);
               }

               boolean var13 = true;
               if(var10.contentType > 0) {
                  var13 = class159.method3209(var10);
               }

               if(var13 && class23.method587(GameEngine.method3133(var10), var3 - 1)) {
                  if(var3 == 1) {
                     Client.field323.method2801(101);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 2) {
                     Client.field323.method2801(11);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 3) {
                     Client.field323.method2801(186);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 4) {
                     Client.field323.method2801(89);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 5) {
                     Client.field323.method2801(128);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 6) {
                     Client.field323.method2801(247);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 7) {
                     Client.field323.method2801(69);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 8) {
                     Client.field323.method2801(117);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 9) {
                     Client.field323.method2801(90);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }

                  if(var3 == 10) {
                     Client.field323.method2801(59);
                     Client.field323.method2600(var1);
                     Client.field323.method2514(var0);
                     Client.field323.method2514(var16);
                  }
               }
            }
         }
      }

      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(149);
            Client.field323.method2558(class140.field2190[82]?1:0);
            Client.field323.method2562(var3);
         }
      }

      if(var2 == 20) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(97);
         Client.field323.method2711(class9.baseX + var0);
         Client.field323.method2563(var1 + KitDefinition.baseY);
         Client.field323.method2554(class140.field2190[82]?1:0);
         Client.field323.method2562(var3);
      }

      if(var2 == 29) {
         Client.field323.method2801(68);
         Client.field323.method2600(var1);
         var15 = class24.method600(var1);
         if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
            var16 = var15.dynamicValues[0][1];
            if(class179.widgetSettings[var16] != var15.field2930[0]) {
               class179.widgetSettings[var16] = var15.field2930[0];
               class35.method748(var16);
            }
         }
      }

      if(var2 == 10) {
         var14 = Client.cachedNPCs[var3];
         if(null != var14) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(103);
            Client.field323.method2552(class140.field2190[82]?1:0);
            Client.field323.method2514(var3);
         }
      }

      if(var2 == 28) {
         Client.field323.method2801(68);
         Client.field323.method2600(var1);
         var15 = class24.method600(var1);
         if(null != var15.dynamicValues && var15.dynamicValues[0][0] == 5) {
            var16 = var15.dynamicValues[0][1];
            class179.widgetSettings[var16] = 1 - class179.widgetSettings[var16];
            class35.method748(var16);
         }
      }

      if(var2 == 33) {
         Client.field323.method2801(67);
         Client.field323.method2563(var0);
         Client.field323.method2572(var1);
         Client.field323.method2562(var3);
         Client.field455 = 0;
         class35.field801 = class24.method600(var1);
         Client.field395 = var0;
      }

      if(var2 == 19) {
         Client.field521 = var6;
         Client.field394 = var7;
         Client.field393 = 2;
         Client.field392 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field323.method2801(206);
         Client.field323.method2562(var3);
         Client.field323.method2514(var0 + class9.baseX);
         Client.field323.method2563(var1 + KitDefinition.baseY);
         Client.field323.method2513(class140.field2190[82]?1:0);
      }

      if(var2 == 25) {
         var15 = class38.method781(var1, var0);
         if(var15 != null) {
            Client.method440();
            World.method664(var1, var0, ChatMessages.method240(GameEngine.method3133(var15)), var15.item);
            Client.field524 = 0;
            Client.field438 = class1.method7(var15);
            if(null == Client.field438) {
               Client.field438 = "Null";
            }

            if(var15.field2815) {
               Client.field439 = var15.name + class153.method3186(16777215);
            } else {
               Client.field439 = class153.method3186('\uff00') + var15.field2932 + class153.method3186(16777215);
            }
         }

      } else {
         if(var2 == 1005) {
            var15 = class24.method600(var1);
            if(var15 != null && var15.itemQuantities[var0] >= 100000) {
               class10.sendGameMessage(27, "", var15.itemQuantities[var0] + " x " + MessageNode.getItemDefinition(var3).name);
            } else {
               Client.field323.method2801(20);
               Client.field323.method2562(var3);
            }

            Client.field455 = 0;
            class35.field801 = class24.method600(var1);
            Client.field395 = var0;
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field521 = var6;
               Client.field394 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2801(190);
               Client.field323.method2554(class140.field2190[82]?1:0);
               Client.field323.method2563(var3);
            }
         }

         if(var2 == 14) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field521 = var6;
               Client.field394 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2801(13);
               Client.field323.method2558(class140.field2190[82]?1:0);
               Client.field323.method2562(var3);
               Client.field323.method2572(class12.field176);
               Client.field323.method2711(class22.field591);
               Client.field323.method2562(class10.field164);
            }
         }

         if(var2 == 21) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(225);
            Client.field323.method2711(var3);
            Client.field323.method2563(var1 + KitDefinition.baseY);
            Client.field323.method2558(class140.field2190[82]?1:0);
            Client.field323.method2563(var0 + class9.baseX);
         }

         if(var2 == 42) {
            Client.field323.method2801(121);
            Client.field323.method2711(var3);
            Client.field323.method2563(var0);
            Client.field323.method2572(var1);
            Client.field455 = 0;
            class35.field801 = class24.method600(var1);
            Client.field395 = var0;
         }

         if(var2 == 3) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(179);
            Client.field323.method2563(KitDefinition.baseY + var1);
            Client.field323.method2514(class9.baseX + var0);
            Client.field323.method2554(class140.field2190[82]?1:0);
            Client.field323.method2711(var3 >> 14 & 32767);
         }

         if(var2 == 50) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field521 = var6;
               Client.field394 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2801(124);
               Client.field323.method2552(class140.field2190[82]?1:0);
               Client.field323.method2711(var3);
            }
         }

         if(var2 == 1004) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.field323.method2801(20);
            Client.field323.method2562(var3);
         }

         if(var2 == 17) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field323.method2801(208);
            Client.field323.method2563(var3);
            Client.field323.method2558(class140.field2190[82]?1:0);
            Client.field323.method2563(KitDefinition.baseY + var1);
            Client.field323.method2514(Client.field436);
            Client.field323.method2600(XClanMember.field638);
            Client.field323.method2563(class9.baseX + var0);
         }

         if(var2 == 58) {
            var15 = class38.method781(var1, var0);
            if(null != var15) {
               Client.field323.method2801(84);
               Client.field323.method2600(var1);
               Client.field323.method2562(var0);
               Client.field323.method2562(var15.item);
               Client.field323.method2600(XClanMember.field638);
               Client.field323.method2562(Client.field437);
               Client.field323.method2562(Client.field436);
            }
         }

         if(var2 == 1002) {
            Client.field521 = var6;
            Client.field394 = var7;
            Client.field393 = 2;
            Client.field392 = 0;
            Client.field323.method2801(202);
            Client.field323.method2562(var3 >> 14 & 32767);
         }

         if(var2 == 34) {
            Client.field323.method2801(63);
            Client.field323.method2711(var3);
            Client.field323.method2600(var1);
            Client.field323.method2711(var0);
            Client.field455 = 0;
            class35.field801 = class24.method600(var1);
            Client.field395 = var0;
         }

         if(var2 == 39) {
            Client.field323.method2801(98);
            Client.field323.method2514(var0);
            Client.field323.method2514(var3);
            Client.field323.method2572(var1);
            Client.field455 = 0;
            class35.field801 = class24.method600(var1);
            Client.field395 = var0;
         }

         if(var2 == 38) {
            Client.method440();
            var15 = class24.method600(var1);
            Client.field524 = 1;
            class22.field591 = var0;
            class12.field176 = var1;
            class10.field164 = var3;
            class53.method1101(var15);
            Client.field529 = class153.method3186(16748608) + MessageNode.getItemDefinition(var3).name + class153.method3186(16777215);
            if(null == Client.field529) {
               Client.field529 = "null";
            }

         } else {
            if(var2 == 48) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field521 = var6;
                  Client.field394 = var7;
                  Client.field393 = 2;
                  Client.field392 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field323.method2801(251);
                  Client.field323.method2562(var3);
                  Client.field323.method2513(class140.field2190[82]?1:0);
               }
            }

            if(var2 == 2) {
               Client.field521 = var6;
               Client.field394 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2801(125);
               Client.field323.method2572(XClanMember.field638);
               Client.field323.method2563(var1 + KitDefinition.baseY);
               Client.field323.method2562(Client.field436);
               Client.field323.method2562(var3 >> 14 & 32767);
               Client.field323.method2514(class9.baseX + var0);
               Client.field323.method2554(class140.field2190[82]?1:0);
            }

            if(var2 == 44) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field521 = var6;
                  Client.field394 = var7;
                  Client.field393 = 2;
                  Client.field392 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field323.method2801(24);
                  Client.field323.method2558(class140.field2190[82]?1:0);
                  Client.field323.method2562(var3);
               }
            }

            if(var2 == 22) {
               Client.field521 = var6;
               Client.field394 = var7;
               Client.field393 = 2;
               Client.field392 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field323.method2801(246);
               Client.field323.method2563(KitDefinition.baseY + var1);
               Client.field323.method2711(var3);
               Client.field323.method2552(class140.field2190[82]?1:0);
               Client.field323.method2563(class9.baseX + var0);
            }

            if(var2 == 26) {
               class62.method1321();
            }

            if(var2 == 31) {
               Client.field323.method2801(70);
               Client.field323.method2541(var1);
               Client.field323.method2514(class10.field164);
               Client.field323.method2711(var0);
               Client.field323.method2514(var3);
               Client.field323.method2711(class22.field591);
               Client.field323.method2541(class12.field176);
               Client.field455 = 0;
               class35.field801 = class24.method600(var1);
               Client.field395 = var0;
            }

            if(var2 == 36) {
               Client.field323.method2801(58);
               Client.field323.method2711(var0);
               Client.field323.method2562(var3);
               Client.field323.method2572(var1);
               Client.field455 = 0;
               class35.field801 = class24.method600(var1);
               Client.field395 = var0;
            }

            if(Client.field524 != 0) {
               Client.field524 = 0;
               class53.method1101(class24.method600(class12.field176));
            }

            if(Client.field435) {
               Client.method440();
            }

            if(null != class35.field801 && Client.field455 == 0) {
               class53.method1101(class35.field801);
            }

         }
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "4096"
   )
   static final void method1643(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field524 != 0 || Client.field435) {
         String var2;
         if(Client.field524 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field529 + " " + "->";
         } else if(Client.field435 && Client.menuOptionCount < 2) {
            var2 = Client.field438 + " " + Client.field439 + " " + "->";
         } else {
            var2 = class16.method182(Client.menuOptionCount - 1);
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + class153.method3186(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         Frames.field1850.method4063(var2, var0 + 4, 15 + var1, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}

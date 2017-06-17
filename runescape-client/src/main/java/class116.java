import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class116 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -547052117
   )
   int field1680;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -786385247
   )
   int field1682;
   @ObfuscatedName("z")
   int[][] field1684;
   @ObfuscatedName("i")
   static int[] field1686;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1229273058"
   )
   int method2017(int var1) {
      if(this.field1684 != null) {
         var1 = (int)((long)var1 * (long)this.field1682 / (long)this.field1680);
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-602696960"
   )
   byte[] method2018(byte[] var1) {
      if(this.field1684 != null) {
         int var2 = (int)((long)this.field1682 * (long)var1.length / (long)this.field1680) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1684[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1682;
            var9 = var5 / this.field1680;
            var4 += var9;
            var5 -= this.field1680 * var9;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1307727668"
   )
   int method2019(int var1) {
      if(this.field1684 != null) {
         var1 = (int)((long)var1 * (long)this.field1682 / (long)this.field1680) + 6;
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   public static void method2024() {
      if(class50.keyboard != null) {
         class50 var0 = class50.keyboard;
         class50 var1 = class50.keyboard;
         synchronized(class50.keyboard) {
            class50.keyboard = null;
         }
      }

   }

   public class116(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class46.method670(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1680 = var1;
         this.field1682 = var2;
         this.field1684 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1684[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var8 - var6));
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-736181360"
   )
   public static int method2030(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("p")
   public static String method2031(long var0) {
      class182.field2453.setTime(new Date(var0));
      int var2 = class182.field2453.get(7);
      int var3 = class182.field2453.get(5);
      int var4 = class182.field2453.get(2);
      int var5 = class182.field2453.get(1);
      int var6 = class182.field2453.get(11);
      int var7 = class182.field2453.get(12);
      int var8 = class182.field2453.get(13);
      return class182.field2452[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class182.field2456[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "16303310"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      NPC var8;
      if(var2 == 7) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(202);
            Client.secretPacketBuffer1.method3066(XGrandExchangeOffer.field312);
            Client.secretPacketBuffer1.method3065(var3);
            Client.secretPacketBuffer1.putShort(class91.selectedItemIndex);
            Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3114(class33.field480);
         }
      }

      if(var2 == 1001) {
         Client.field1013 = var6;
         Client.field1115 = var7;
         Client.cursorState = 2;
         Client.field906 = 0;
         Client.detinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(197);
         Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
         Client.secretPacketBuffer1.putShort(var1 + class21.baseY);
         Client.secretPacketBuffer1.method3066(var0 + class19.baseX);
         Client.secretPacketBuffer1.method3066(var3 >> 14 & 32767);
      }

      if(var2 == 1) {
         Client.field1013 = var6;
         Client.field1115 = var7;
         Client.cursorState = 2;
         Client.field906 = 0;
         Client.detinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(59);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.putShort(class91.selectedItemIndex);
         Client.secretPacketBuffer1.method3067(class21.baseY + var1);
         Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
         Client.secretPacketBuffer1.method3114(class33.field480);
         Client.secretPacketBuffer1.method3065(XGrandExchangeOffer.field312);
         Client.secretPacketBuffer1.method3067(class19.baseX + var0);
      }

      if(var2 == 32) {
         Client.secretPacketBuffer1.putOpcode(223);
         Client.secretPacketBuffer1.method3077(class47.field611);
         Client.secretPacketBuffer1.method3067(var0);
         Client.secretPacketBuffer1.method3066(var3);
         Client.secretPacketBuffer1.method3067(Client.field1062);
         Client.secretPacketBuffer1.method3114(var1);
         Client.field1017 = 0;
         class59.field735 = class223.method3959(var1);
         Client.field1018 = var0;
      }

      int var9;
      Widget var10;
      if(var2 == 29) {
         Client.secretPacketBuffer1.putOpcode(26);
         Client.secretPacketBuffer1.putInt(var1);
         var10 = class223.method3959(var1);
         if(var10.dynamicValues != null && var10.dynamicValues[0][0] == 5) {
            var9 = var10.dynamicValues[0][1];
            if(class211.widgetSettings[var9] != var10.field2768[0]) {
               class211.widgetSettings[var9] = var10.field2768[0];
               class36.method483(var9);
            }
         }
      }

      Player var11;
      if(var2 == 15) {
         var11 = Client.cachedPlayers[var3];
         if(var11 != null) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(113);
            Client.secretPacketBuffer1.method3066(Client.field1062);
            Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3066(var3);
            Client.secretPacketBuffer1.putInt(class47.field611);
         }
      }

      if(var2 == 28) {
         Client.secretPacketBuffer1.putOpcode(26);
         Client.secretPacketBuffer1.putInt(var1);
         var10 = class223.method3959(var1);
         if(var10.dynamicValues != null && var10.dynamicValues[0][0] == 5) {
            var9 = var10.dynamicValues[0][1];
            class211.widgetSettings[var9] = 1 - class211.widgetSettings[var9];
            class36.method483(var9);
         }
      }

      if(var2 == 25) {
         var10 = class172.method3015(var1, var0);
         if(var10 != null) {
            Preferences.method1501();
            class25.method202(var1, var0, WorldMapType1.method263(class15.method92(var10)), var10.itemId);
            Client.itemSelectionState = 0;
            String var12;
            if(WorldMapType1.method263(class15.method92(var10)) == 0) {
               var12 = null;
            } else if(var10.selectedAction != null && var10.selectedAction.trim().length() != 0) {
               var12 = var10.selectedAction;
            } else {
               var12 = null;
            }

            Client.field1064 = var12;
            if(Client.field1064 == null) {
               Client.field1064 = "Null";
            }

            if(var10.hasScript) {
               Client.field1065 = var10.name + class15.method105(16777215);
            } else {
               Client.field1065 = class15.method105('\uff00') + var10.field2741 + class15.method105(16777215);
            }
         }
      } else {
         if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(250);
               Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
               Client.secretPacketBuffer1.method3065(var3);
            }
         }

         if(var2 == 44) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(187);
               Client.secretPacketBuffer1.method3067(var3);
               Client.secretPacketBuffer1.method3059(class50.field660[82]?1:0);
            }
         }

         if(var2 == 46) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(129);
               Client.secretPacketBuffer1.method3065(var3);
               Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
            }
         }

         if(var2 == 20) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(7);
            Client.secretPacketBuffer1.method3065(var3);
            Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3066(class19.baseX + var0);
            Client.secretPacketBuffer1.method3067(class21.baseY + var1);
         }

         if(var2 == 50) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(165);
               Client.secretPacketBuffer1.method3065(var3);
               Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
            }
         }

         if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(57);
               Client.secretPacketBuffer1.method3077(class47.field611);
               Client.secretPacketBuffer1.method3059(class50.field660[82]?1:0);
               Client.secretPacketBuffer1.method3065(var3);
               Client.secretPacketBuffer1.method3066(Client.field1062);
            }
         }

         if(var2 == 39) {
            Client.secretPacketBuffer1.putOpcode(251);
            Client.secretPacketBuffer1.method3065(var3);
            Client.secretPacketBuffer1.method3077(var1);
            Client.secretPacketBuffer1.method3065(var0);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 17) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(0);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3114(class47.field611);
            Client.secretPacketBuffer1.method3067(var1 + class21.baseY);
            Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3065(Client.field1062);
            Client.secretPacketBuffer1.method3066(class19.baseX + var0);
         }

         if(var2 == 5) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(76);
            Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3067(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShort(class21.baseY + var1);
            Client.secretPacketBuffer1.putShort(class19.baseX + var0);
         }

         if(var2 == 40) {
            Client.secretPacketBuffer1.putOpcode(100);
            Client.secretPacketBuffer1.method3066(var0);
            Client.secretPacketBuffer1.method3066(var3);
            Client.secretPacketBuffer1.method3077(var1);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(118);
               Client.secretPacketBuffer1.method3059(class50.field660[82]?1:0);
               Client.secretPacketBuffer1.method3066(var3);
            }
         }

         if(var2 == 36) {
            Client.secretPacketBuffer1.putOpcode(110);
            Client.secretPacketBuffer1.method3114(var1);
            Client.secretPacketBuffer1.method3065(var3);
            Client.secretPacketBuffer1.method3065(var0);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(85);
               Client.secretPacketBuffer1.method3065(var3);
               Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
            }
         }

         if(var2 == 37) {
            Client.secretPacketBuffer1.putOpcode(229);
            Client.secretPacketBuffer1.method3077(var1);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3066(var0);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 22) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(62);
            Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3066(var3);
            Client.secretPacketBuffer1.method3066(var0 + class19.baseX);
            Client.secretPacketBuffer1.method3066(class21.baseY + var1);
         }

         if(var2 == 51) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(218);
               Client.secretPacketBuffer1.method3067(var3);
               Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
            }
         }

         if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(64);
               Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }
         }

         if(var2 == 24) {
            var10 = class223.method3959(var1);
            boolean var17 = true;
            if(var10.contentType > 0) {
               var17 = class61.method1007(var10);
            }

            if(var17) {
               Client.secretPacketBuffer1.putOpcode(26);
               Client.secretPacketBuffer1.putInt(var1);
            }
         }

         if(var2 == 1004) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.secretPacketBuffer1.putOpcode(104);
            Client.secretPacketBuffer1.putShort(var3);
         }

         if(var2 == 31) {
            Client.secretPacketBuffer1.putOpcode(207);
            Client.secretPacketBuffer1.method3067(var0);
            Client.secretPacketBuffer1.method3057(class33.field480);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3067(class91.selectedItemIndex);
            Client.secretPacketBuffer1.method3066(XGrandExchangeOffer.field312);
            Client.secretPacketBuffer1.putShort(var3);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
            class46.renderOverview.method5130(var2, var3, new Coordinates(var0), new Coordinates(var1));
         }

         if(var2 == 6) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(79);
            Client.secretPacketBuffer1.method3067(class19.baseX + var0);
            Client.secretPacketBuffer1.putShort(var1 + class21.baseY);
            Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3065(var3 >> 14 & 32767);
         }

         if(var2 == 26) {
            class270.method4788();
         }

         if(var2 == 16) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(39);
            Client.secretPacketBuffer1.method3066(class21.baseY + var1);
            Client.secretPacketBuffer1.method3057(class33.field480);
            Client.secretPacketBuffer1.method3066(XGrandExchangeOffer.field312);
            Client.secretPacketBuffer1.method3066(class91.selectedItemIndex);
            Client.secretPacketBuffer1.method3066(var3);
            Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3067(var0 + class19.baseX);
         }

         if(var2 == 14) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(199);
               Client.secretPacketBuffer1.method3077(class33.field480);
               Client.secretPacketBuffer1.method3065(var3);
               Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
               Client.secretPacketBuffer1.method3067(class91.selectedItemIndex);
               Client.secretPacketBuffer1.method3065(XGrandExchangeOffer.field312);
            }
         }

         if(var2 == 41) {
            Client.secretPacketBuffer1.putOpcode(68);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.putInt(var1);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 1005) {
            var10 = class223.method3959(var1);
            if(var10 != null && var10.itemQuantities[var0] >= 100000) {
               class5.sendGameMessage(27, "", var10.itemQuantities[var0] + " x " + class224.getItemDefinition(var3).name);
            } else {
               Client.secretPacketBuffer1.putOpcode(104);
               Client.secretPacketBuffer1.putShort(var3);
            }

            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 2) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(77);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putInt(class47.field611);
            Client.secretPacketBuffer1.method3067(Client.field1062);
            Client.secretPacketBuffer1.method3066(var0 + class19.baseX);
            Client.secretPacketBuffer1.method3067(class21.baseY + var1);
            Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
         }

         if(var2 == 58) {
            var10 = class172.method3015(var1, var0);
            if(var10 != null) {
               Client.secretPacketBuffer1.putOpcode(63);
               Client.secretPacketBuffer1.method3066(var0);
               Client.secretPacketBuffer1.method3065(Client.field1062);
               Client.secretPacketBuffer1.putInt(var1);
               Client.secretPacketBuffer1.method3114(class47.field611);
               Client.secretPacketBuffer1.method3065(var10.itemId);
               Client.secretPacketBuffer1.method3065(Client.field1157);
            }
         }

         if(var2 == 35) {
            Client.secretPacketBuffer1.putOpcode(184);
            Client.secretPacketBuffer1.method3065(var3);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3065(var0);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 49) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(196);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
            }
         }

         if(var2 == 33) {
            Client.secretPacketBuffer1.putOpcode(154);
            Client.secretPacketBuffer1.method3067(var0);
            Client.secretPacketBuffer1.method3066(var3);
            Client.secretPacketBuffer1.method3077(var1);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 42) {
            Client.secretPacketBuffer1.putOpcode(139);
            Client.secretPacketBuffer1.method3067(var0);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3065(var3);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 13) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(46);
               Client.secretPacketBuffer1.method3066(var3);
               Client.secretPacketBuffer1.method3059(class50.field660[82]?1:0);
            }
         }

         if(var2 == 34) {
            Client.secretPacketBuffer1.putOpcode(133);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.method3057(var1);
            Client.secretPacketBuffer1.method3066(var0);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 47) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(90);
               Client.secretPacketBuffer1.method3059(class50.field660[82]?1:0);
               Client.secretPacketBuffer1.method3065(var3);
            }
         }

         if(var2 == 19) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(120);
            Client.secretPacketBuffer1.method3067(var3);
            Client.secretPacketBuffer1.method3067(var1 + class21.baseY);
            Client.secretPacketBuffer1.method3067(var0 + class19.baseX);
            Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
         }

         if(var2 == 1002) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.secretPacketBuffer1.putOpcode(177);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         }

         if(var2 == 21) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(56);
            Client.secretPacketBuffer1.method3067(class21.baseY + var1);
            Client.secretPacketBuffer1.putShort(class19.baseX + var0);
            Client.secretPacketBuffer1.method3067(var3);
            Client.secretPacketBuffer1.method3059(class50.field660[82]?1:0);
         }

         if(var2 == 30 && Client.field1070 == null) {
            class23.method189(var1, var0);
            Client.field1070 = class172.method3015(var1, var0);
            XItemContainer.method1020(Client.field1070);
         }

         if(var2 == 43) {
            Client.secretPacketBuffer1.putOpcode(227);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.method3066(var0);
            Client.field1017 = 0;
            class59.field735 = class223.method3959(var1);
            Client.field1018 = var0;
         }

         if(var2 == 4) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(198);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3066(class19.baseX + var0);
            Client.secretPacketBuffer1.method3065(class21.baseY + var1);
         }

         if(var2 == 3) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(47);
            Client.secretPacketBuffer1.method3067(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShort(var0 + class19.baseX);
            Client.secretPacketBuffer1.method3066(class21.baseY + var1);
            Client.secretPacketBuffer1.method3069(class50.field660[82]?1:0);
         }

         if(var2 == 48) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(43);
               Client.secretPacketBuffer1.method3066(var3);
               Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
            }
         }

         if(var2 == 18) {
            Client.field1013 = var6;
            Client.field1115 = var7;
            Client.cursorState = 2;
            Client.field906 = 0;
            Client.detinationX = var0;
            Client.destinationY = var1;
            Client.secretPacketBuffer1.putOpcode(167);
            Client.secretPacketBuffer1.putShort(class21.baseY + var1);
            Client.secretPacketBuffer1.putByte(class50.field660[82]?1:0);
            Client.secretPacketBuffer1.method3065(var3);
            Client.secretPacketBuffer1.method3065(var0 + class19.baseX);
         }

         if(var2 == 45) {
            var11 = Client.cachedPlayers[var3];
            if(var11 != null) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               Client.detinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(41);
               Client.secretPacketBuffer1.method3066(var3);
               Client.secretPacketBuffer1.method3196(class50.field660[82]?1:0);
            }
         }

         if(var2 == 38) {
            Preferences.method1501();
            var10 = class223.method3959(var1);
            Client.itemSelectionState = 1;
            class91.selectedItemIndex = var0;
            class33.field480 = var1;
            XGrandExchangeOffer.field312 = var3;
            XItemContainer.method1020(var10);
            Client.selectedItemName = class15.method105(16748608) + class224.getItemDefinition(var3).name + class15.method105(16777215);
            if(Client.selectedItemName == null) {
               Client.selectedItemName = "null";
            }
         } else {
            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class17.region.method2616();
               } else {
                  class17.region.method2615(Player.plane, var0, var1, true);
               }
            }

            if(var2 == 1003) {
               Client.field1013 = var6;
               Client.field1115 = var7;
               Client.cursorState = 2;
               Client.field906 = 0;
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  NPCComposition var19 = var8.composition;
                  if(var19.configs != null) {
                     var19 = var19.method4525();
                  }

                  if(var19 != null) {
                     Client.secretPacketBuffer1.putOpcode(109);
                     Client.secretPacketBuffer1.method3066(var19.id);
                  }
               }
            }

            if(var2 == 57 || var2 == 1007) {
               var10 = class172.method3015(var1, var0);
               if(var10 != null) {
                  var9 = var10.itemId;
                  Widget var20 = class172.method3015(var1, var0);
                  if(var20 != null) {
                     if(var20.field2657 != null) {
                        class69 var13 = new class69();
                        var13.field822 = var20;
                        var13.field825 = var3;
                        var13.field833 = var5;
                        var13.field821 = var20.field2657;
                        class77.method1440(var13);
                     }

                     boolean var18 = true;
                     if(var20.contentType > 0) {
                        var18 = class61.method1007(var20);
                     }

                     if(var18) {
                        int var14 = class15.method92(var20);
                        int var15 = var3 - 1;
                        boolean var16 = (var14 >> var15 + 1 & 1) != 0;
                        if(var16) {
                           if(var3 == 1) {
                              Client.secretPacketBuffer1.putOpcode(221);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 2) {
                              Client.secretPacketBuffer1.putOpcode(52);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 3) {
                              Client.secretPacketBuffer1.putOpcode(206);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 4) {
                              Client.secretPacketBuffer1.putOpcode(61);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 5) {
                              Client.secretPacketBuffer1.putOpcode(103);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 6) {
                              Client.secretPacketBuffer1.putOpcode(111);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 7) {
                              Client.secretPacketBuffer1.putOpcode(5);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 8) {
                              Client.secretPacketBuffer1.putOpcode(31);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 9) {
                              Client.secretPacketBuffer1.putOpcode(135);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }

                           if(var3 == 10) {
                              Client.secretPacketBuffer1.putOpcode(28);
                              Client.secretPacketBuffer1.putInt(var1);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.putShort(var9);
                           }
                        }
                     }
                  }
               }
            }

            if(Client.itemSelectionState != 0) {
               Client.itemSelectionState = 0;
               XItemContainer.method1020(class223.method3959(class33.field480));
            }

            if(Client.field1061) {
               Preferences.method1501();
            }

            if(class59.field735 != null && Client.field1017 == 0) {
               XItemContainer.method1020(class59.field735);
            }
         }
      }

   }
}

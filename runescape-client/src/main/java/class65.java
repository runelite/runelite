import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class65 {
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 561396627
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1256115607
   )
   int field1111;
   @ObfuscatedName("h")
   int[][] field1112;
   @ObfuscatedName("ie")
   static class38 field1115;
   @ObfuscatedName("eo")
   static ModIcon[] field1116;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -335262277
   )
   int field1118;

   public class65(int var1, int var2) {
      if(var1 != var2) {
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
         this.field1111 = var1;
         this.field1118 = var2;
         this.field1112 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1112[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
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
               var8[var11] = (int)Math.floor(var17 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "40"
   )
   byte[] method1237(byte[] var1) {
      if(null != this.field1112) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1118 / (long)this.field1111);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1112[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1118;
            var9 = var5 / this.field1111;
            var4 += var9;
            var5 -= this.field1111 * var9;
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "9"
   )
   int method1238(int var1) {
      if(this.field1112 != null) {
         var1 = (int)((long)var1 * (long)this.field1118 / (long)this.field1111);
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "3"
   )
   int method1241(int var1) {
      if(null != this.field1112) {
         var1 = (int)((long)var1 * (long)this.field1118 / (long)this.field1111) + 6;
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-334754811"
   )
   static boolean method1246(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Varbit.method3557(var3);
         return true;
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1304617129"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 31) {
         Client.field309.method3076(233);
         Client.field309.method2873(var1);
         Client.field309.method2909(class107.field1744);
         Client.field309.method2864(class8.field82);
         Client.field309.method2874(class49.field967);
         Client.field309.method2865(var0);
         Client.field309.method2864(var3);
         Client.field425 = 0;
         Tile.field1363 = World.method670(var1);
         Client.field406 = var0;
      }

      Player var8;
      if(var2 == 14) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(146);
            Client.field309.method2843(class105.field1725[82]?1:0);
            Client.field309.method2817(class8.field82);
            Client.field309.method2865(class107.field1744);
            Client.field309.method2817(var3);
            Client.field309.method2874(class49.field967);
         }
      }

      NPC var19;
      if(var2 == 12) {
         var19 = Client.cachedNPCs[var3];
         if(var19 != null) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(199);
            Client.field309.method2857(class105.field1725[82]?1:0);
            Client.field309.method2865(var3);
         }
      }

      if(var2 == 11) {
         var19 = Client.cachedNPCs[var3];
         if(null != var19) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(45);
            Client.field309.method2857(class105.field1725[82]?1:0);
            Client.field309.method2865(var3);
         }
      }

      Widget var20;
      if(var2 == 24) {
         var20 = World.method670(var1);
         boolean var9 = true;
         if(var20.contentType > 0) {
            var9 = CombatInfoListHolder.method776(var20);
         }

         if(var9) {
            Client.field309.method3076(62);
            Client.field309.method2819(var1);
         }
      }

      if(var2 == 30 && null == Client.field477) {
         Client.field309.method3076(171);
         Client.field309.method2864(var0);
         Client.field309.method2819(var1);
         Client.field477 = class40.method826(var1, var0);
         class2.method36(Client.field477);
      }

      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(99);
            Client.field309.method2817(var3);
            Client.field309.method2857(class105.field1725[82]?1:0);
         }
      }

      if(var2 == 1002) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         Client.field309.method3076(88);
         Client.field309.method2909(var3 >> 14 & 32767);
      }

      if(var2 == 39) {
         Client.field309.method3076(29);
         Client.field309.method2909(var0);
         Client.field309.method2909(var3);
         Client.field309.method2874(var1);
         Client.field425 = 0;
         Tile.field1363 = World.method670(var1);
         Client.field406 = var0;
      }

      int var21;
      if(var2 == 29) {
         Client.field309.method3076(62);
         Client.field309.method2819(var1);
         var20 = World.method670(var1);
         if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
            var21 = var20.dynamicValues[0][1];
            if(var20.field2210[0] != class165.widgetSettings[var21]) {
               class165.widgetSettings[var21] = var20.field2210[0];
               Player.method263(var21);
            }
         }
      }

      if(var2 == 15) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(30);
            Client.field309.method2817(Client.field469);
            Client.field309.method2909(var3);
            Client.field309.method2873(class26.field621);
            Client.field309.method2843(class105.field1725[82]?1:0);
         }
      }

      if(var2 == 23) {
         if(Client.isMenuOpen) {
            Friend.region.method1791();
         } else {
            Friend.region.method1790(class31.plane, var0, var1, true);
         }
      }

      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(240);
            Client.field309.method2855(class105.field1725[82]?1:0);
            Client.field309.method2864(var3);
         }
      }

      if(var2 == 36) {
         Client.field309.method3076(249);
         Client.field309.method2909(var0);
         Client.field309.method2909(var3);
         Client.field309.method2875(var1);
         Client.field425 = 0;
         Tile.field1363 = World.method670(var1);
         Client.field406 = var0;
      }

      if(var2 == 8) {
         var19 = Client.cachedNPCs[var3];
         if(null != var19) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(241);
            Client.field309.method2909(Client.field469);
            Client.field309.method2817(var3);
            Client.field309.method2962(class105.field1725[82]?1:0);
            Client.field309.method2873(class26.field621);
         }
      }

      if(var2 == 32) {
         Client.field309.method3076(19);
         Client.field309.method2873(class26.field621);
         Client.field309.method2909(var3);
         Client.field309.method2909(Client.field469);
         Client.field309.method2873(var1);
         Client.field309.method2865(var0);
         Client.field425 = 0;
         Tile.field1363 = World.method670(var1);
         Client.field406 = var0;
      }

      if(var2 == 1003) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         var19 = Client.cachedNPCs[var3];
         if(var19 != null) {
            NPCComposition var16 = var19.composition;
            if(null != var16.configs) {
               var16 = var16.method3719();
            }

            if(var16 != null) {
               Client.field309.method3076(229);
               Client.field309.method2865(var16.id);
            }
         }
      }

      if(var2 == 16) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field309.method3076(159);
         Client.field309.method2909(class107.field1744);
         Client.field309.method2843(class105.field1725[82]?1:0);
         Client.field309.method2909(class3.baseY + var1);
         Client.field309.method2874(class49.field967);
         Client.field309.method2817(var0 + CombatInfoListHolder.baseX);
         Client.field309.method2817(class8.field82);
         Client.field309.method2864(var3);
      }

      if(var2 == 58) {
         var20 = class40.method826(var1, var0);
         if(var20 != null) {
            Client.field309.method3076(91);
            Client.field309.method2864(Client.field405);
            Client.field309.method2873(class26.field621);
            Client.field309.method2909(Client.field469);
            Client.field309.method2864(var0);
            Client.field309.method2874(var1);
            Client.field309.method2865(var20.item);
         }
      }

      if(var2 == 22) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field309.method3076(238);
         Client.field309.method2865(var3);
         Client.field309.method2865(CombatInfoListHolder.baseX + var0);
         Client.field309.method2857(class105.field1725[82]?1:0);
         Client.field309.method2864(var1 + class3.baseY);
      }

      if(var2 == 20) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field309.method3076(27);
         Client.field309.method2864(var3);
         Client.field309.method2865(class3.baseY + var1);
         Client.field309.method2865(var0 + CombatInfoListHolder.baseX);
         Client.field309.method2843(class105.field1725[82]?1:0);
      }

      if(var2 == 37) {
         Client.field309.method3076(251);
         Client.field309.method2819(var1);
         Client.field309.method2909(var0);
         Client.field309.method2864(var3);
         Client.field425 = 0;
         Tile.field1363 = World.method670(var1);
         Client.field406 = var0;
      }

      if(var2 == 2) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field309.method3076(54);
         Client.field309.method2865(var0 + CombatInfoListHolder.baseX);
         Client.field309.method2855(class105.field1725[82]?1:0);
         Client.field309.method2865(var3 >> 14 & 32767);
         Client.field309.method2873(class26.field621);
         Client.field309.method2865(Client.field469);
         Client.field309.method2865(class3.baseY + var1);
      }

      if(var2 == 21) {
         Client.field422 = var6;
         Client.field421 = var7;
         Client.field423 = 2;
         Client.field548 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field309.method3076(28);
         Client.field309.method2857(class105.field1725[82]?1:0);
         Client.field309.method2865(var3);
         Client.field309.method2909(var1 + class3.baseY);
         Client.field309.method2909(CombatInfoListHolder.baseX + var0);
      }

      if(var2 == 25) {
         var20 = class40.method826(var1, var0);
         if(var20 != null) {
            if(Client.field468) {
               Widget var24 = class40.method826(class26.field621, Client.field469);
               if(var24 != null && var24.field2278 != null) {
                  class18 var17 = new class18();
                  var17.field223 = var24;
                  var17.field232 = var24.field2278;
                  Frames.method1963(var17);
               }

               Client.field468 = false;
               class2.method36(var24);
            }

            int var10 = class174.method3271(var20);
            var21 = var10 >> 11 & 63;
            int var12 = var20.item;
            Widget var13 = class40.method826(var1, var0);
            if(var13 != null && var13.field2277 != null) {
               class18 var14 = new class18();
               var14.field223 = var13;
               var14.field232 = var13.field2277;
               Frames.method1963(var14);
            }

            Client.field405 = var12;
            Client.field468 = true;
            class26.field621 = var1;
            Client.field469 = var0;
            class7.field73 = var21;
            class2.method36(var13);
            Client.field466 = 0;
            int var15 = class174.method3271(var20);
            int var18 = var15 >> 11 & 63;
            String var22;
            if(var18 == 0) {
               var22 = null;
            } else if(null != var20.field2265 && var20.field2265.trim().length() != 0) {
               var22 = var20.field2265;
            } else {
               var22 = null;
            }

            Client.field489 = var22;
            if(null == Client.field489) {
               Client.field489 = "Null";
            }

            if(var20.hasScript) {
               Client.field472 = var20.name + class116.method2288(16777215);
            } else {
               Client.field472 = class116.method2288('\uff00') + var20.field2282 + class116.method2288(16777215);
            }
         }

      } else {
         if(var2 == 35) {
            Client.field309.method3076(94);
            Client.field309.method2864(var3);
            Client.field309.method2865(var0);
            Client.field309.method2819(var1);
            Client.field425 = 0;
            Tile.field1363 = World.method670(var1);
            Client.field406 = var0;
         }

         if(var2 == 10) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(100);
               Client.field309.method2817(var3);
               Client.field309.method2962(class105.field1725[82]?1:0);
            }
         }

         if(var2 == 51) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(131);
               Client.field309.method2865(var3);
               Client.field309.method2962(class105.field1725[82]?1:0);
            }
         }

         if(var2 == 1001) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(130);
            Client.field309.method2909(var0 + CombatInfoListHolder.baseX);
            Client.field309.method2857(class105.field1725[82]?1:0);
            Client.field309.method2865(class3.baseY + var1);
            Client.field309.method2865(var3 >> 14 & 32767);
         }

         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(216);
               Client.field309.method2864(var3);
               Client.field309.method2843(class105.field1725[82]?1:0);
            }
         }

         if(var2 == 57 || var2 == 1007) {
            var20 = class40.method826(var1, var0);
            if(var20 != null) {
               XItemContainer.method191(var3, var1, var0, var20.item, var5);
            }
         }

         if(var2 == 42) {
            Client.field309.method3076(58);
            Client.field309.method2909(var3);
            Client.field309.method2875(var1);
            Client.field309.method2864(var0);
            Client.field425 = 0;
            Tile.field1363 = World.method670(var1);
            Client.field406 = var0;
         }

         if(var2 == 33) {
            Client.field309.method3076(132);
            Client.field309.method2817(var3);
            Client.field309.method2865(var0);
            Client.field309.method2874(var1);
            Client.field425 = 0;
            Tile.field1363 = World.method670(var1);
            Client.field406 = var0;
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(197);
               Client.field309.method2864(var3);
               Client.field309.method2855(class105.field1725[82]?1:0);
            }
         }

         if(var2 == 17) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(67);
            Client.field309.method2909(Client.field469);
            Client.field309.method2857(class105.field1725[82]?1:0);
            Client.field309.method2817(var0 + CombatInfoListHolder.baseX);
            Client.field309.method2864(var3);
            Client.field309.method2817(var1 + class3.baseY);
            Client.field309.method2874(class26.field621);
         }

         if(var2 == 41) {
            Client.field309.method3076(161);
            Client.field309.method2873(var1);
            Client.field309.method2864(var3);
            Client.field309.method2864(var0);
            Client.field425 = 0;
            Tile.field1363 = World.method670(var1);
            Client.field406 = var0;
         }

         if(var2 == 1005) {
            var20 = World.method670(var1);
            if(null != var20 && var20.itemQuantities[var0] >= 100000) {
               class30.sendGameMessage(27, "", var20.itemQuantities[var0] + " x " + class154.getItemDefinition(var3).name);
            } else {
               Client.field309.method3076(59);
               Client.field309.method2864(var3);
            }

            Client.field425 = 0;
            Tile.field1363 = World.method670(var1);
            Client.field406 = var0;
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(98);
               Client.field309.method2855(class105.field1725[82]?1:0);
               Client.field309.method2909(var3);
            }
         }

         if(var2 == 40) {
            Client.field309.method3076(167);
            Client.field309.method2909(var3);
            Client.field309.method2819(var1);
            Client.field309.method2865(var0);
            Client.field425 = 0;
            Tile.field1363 = World.method670(var1);
            Client.field406 = var0;
         }

         if(var2 == 3) {
            Client.field422 = var6;
            Client.field421 = var7;
            Client.field423 = 2;
            Client.field548 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field309.method3076(221);
            Client.field309.method2865(CombatInfoListHolder.baseX + var0);
            Client.field309.method2864(var1 + class3.baseY);
            Client.field309.method2857(class105.field1725[82]?1:0);
            Client.field309.method2865(var3 >> 14 & 32767);
         }

         if(var2 == 9) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(39);
               Client.field309.method2864(var3);
               Client.field309.method2857(class105.field1725[82]?1:0);
            }
         }

         if(var2 == 38) {
            class173.method3269();
            var20 = World.method670(var1);
            Client.field466 = 1;
            class107.field1744 = var0;
            class49.field967 = var1;
            class8.field82 = var3;
            class2.method36(var20);
            Client.field496 = class116.method2288(16748608) + class154.getItemDefinition(var3).name + class116.method2288(16777215);
            if(null == Client.field496) {
               Client.field496 = "null";
            }

         } else {
            if(var2 == 1) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(82);
               Client.field309.method2864(class3.baseY + var1);
               Client.field309.method2875(class49.field967);
               Client.field309.method2962(class105.field1725[82]?1:0);
               Client.field309.method2865(CombatInfoListHolder.baseX + var0);
               Client.field309.method2909(class107.field1744);
               Client.field309.method2817(class8.field82);
               Client.field309.method2864(var3 >> 14 & 32767);
            }

            if(var2 == 50) {
               var8 = Client.cachedPlayers[var3];
               if(null != var8) {
                  Client.field422 = var6;
                  Client.field421 = var7;
                  Client.field423 = 2;
                  Client.field548 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field309.method3076(101);
                  Client.field309.method2864(var3);
                  Client.field309.method2843(class105.field1725[82]?1:0);
               }
            }

            if(var2 == 34) {
               Client.field309.method3076(207);
               Client.field309.method2819(var1);
               Client.field309.method2909(var3);
               Client.field309.method2817(var0);
               Client.field425 = 0;
               Tile.field1363 = World.method670(var1);
               Client.field406 = var0;
            }

            if(var2 == 6) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(219);
               Client.field309.method2817(var0 + CombatInfoListHolder.baseX);
               Client.field309.method2864(var1 + class3.baseY);
               Client.field309.method2962(class105.field1725[82]?1:0);
               Client.field309.method2817(var3 >> 14 & 32767);
            }

            if(var2 == 26) {
               class108.method2104();
            }

            if(var2 == 5) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(119);
               Client.field309.method2909(CombatInfoListHolder.baseX + var0);
               Client.field309.method2909(var1 + class3.baseY);
               Client.field309.method2962(class105.field1725[82]?1:0);
               Client.field309.method2817(var3 >> 14 & 32767);
            }

            if(var2 == 4) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(26);
               Client.field309.method2817(class3.baseY + var1);
               Client.field309.method2865(var3 >> 14 & 32767);
               Client.field309.method2857(class105.field1725[82]?1:0);
               Client.field309.method2817(var0 + CombatInfoListHolder.baseX);
            }

            if(var2 == 19) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(93);
               Client.field309.method2817(CombatInfoListHolder.baseX + var0);
               Client.field309.method2855(class105.field1725[82]?1:0);
               Client.field309.method2865(var3);
               Client.field309.method2817(var1 + class3.baseY);
            }

            if(var2 == 43) {
               Client.field309.method3076(153);
               Client.field309.method2817(var0);
               Client.field309.method2909(var3);
               Client.field309.method2819(var1);
               Client.field425 = 0;
               Tile.field1363 = World.method670(var1);
               Client.field406 = var0;
            }

            if(var2 == 1004) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.field309.method3076(59);
               Client.field309.method2864(var3);
            }

            if(var2 == 28) {
               Client.field309.method3076(62);
               Client.field309.method2819(var1);
               var20 = World.method670(var1);
               if(null != var20.dynamicValues && var20.dynamicValues[0][0] == 5) {
                  var21 = var20.dynamicValues[0][1];
                  class165.widgetSettings[var21] = 1 - class165.widgetSettings[var21];
                  Player.method263(var21);
               }
            }

            if(var2 == 7) {
               var19 = Client.cachedNPCs[var3];
               if(null != var19) {
                  Client.field422 = var6;
                  Client.field421 = var7;
                  Client.field423 = 2;
                  Client.field548 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field309.method3076(222);
                  Client.field309.method2909(class8.field82);
                  Client.field309.method2875(class49.field967);
                  Client.field309.method2864(class107.field1744);
                  Client.field309.method2817(var3);
                  Client.field309.method2857(class105.field1725[82]?1:0);
               }
            }

            if(var2 == 18) {
               Client.field422 = var6;
               Client.field421 = var7;
               Client.field423 = 2;
               Client.field548 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field309.method3076(254);
               Client.field309.method2843(class105.field1725[82]?1:0);
               Client.field309.method2864(var1 + class3.baseY);
               Client.field309.method2864(CombatInfoListHolder.baseX + var0);
               Client.field309.method2864(var3);
            }

            if(var2 == 45) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field422 = var6;
                  Client.field421 = var7;
                  Client.field423 = 2;
                  Client.field548 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field309.method3076(160);
                  Client.field309.method2909(var3);
                  Client.field309.method2843(class105.field1725[82]?1:0);
               }
            }

            if(var2 == 13) {
               var19 = Client.cachedNPCs[var3];
               if(var19 != null) {
                  Client.field422 = var6;
                  Client.field421 = var7;
                  Client.field423 = 2;
                  Client.field548 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field309.method3076(110);
                  Client.field309.method2817(var3);
                  Client.field309.method2843(class105.field1725[82]?1:0);
               }
            }

            if(Client.field466 != 0) {
               Client.field466 = 0;
               class2.method36(World.method670(class49.field967));
            }

            if(Client.field468 && Client.field468) {
               var20 = class40.method826(class26.field621, Client.field469);
               if(null != var20 && null != var20.field2278) {
                  class18 var23 = new class18();
                  var23.field223 = var20;
                  var23.field232 = var20.field2278;
                  Frames.method1963(var23);
               }

               Client.field468 = false;
               class2.method36(var20);
            }

            if(null != Tile.field1363 && Client.field425 == 0) {
               class2.method36(Tile.field1363);
            }

         }
      }
   }
}

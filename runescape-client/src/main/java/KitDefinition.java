import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1692499087
   )
   public static int field2818;
   @ObfuscatedName("r")
   int[] field2819;
   @ObfuscatedName("d")
   public static class182 field2820;
   @ObfuscatedName("h")
   public static NodeCache field2821 = new NodeCache(64);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 613603343
   )
   public int field2822 = -1;
   @ObfuscatedName("q")
   int[] field2823 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("c")
   short[] field2824;
   @ObfuscatedName("p")
   short[] field2825;
   @ObfuscatedName("g")
   short[] field2826;
   @ObfuscatedName("z")
   short[] field2827;
   @ObfuscatedName("l")
   public boolean field2828 = false;
   @ObfuscatedName("n")
   public static class182 field2829;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2105556273"
   )
   void method3541(Buffer var1) {
      while(true) {
         int var2 = var1.method3033();
         if(var2 == 0) {
            return;
         }

         this.method3542(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "723491708"
   )
   void method3542(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2822 = var1.method3033();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method3033();
            this.field2819 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2819[var4] = var1.method3097();
            }
         } else if(var2 == 3) {
            this.field2828 = true;
         } else if(var2 == 40) {
            var3 = var1.method3033();
            this.field2824 = new short[var3];
            this.field2825 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2824[var4] = (short)var1.method3097();
               this.field2825[var4] = (short)var1.method3097();
            }
         } else if(var2 == 41) {
            var3 = var1.method3033();
            this.field2826 = new short[var3];
            this.field2827 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2826[var4] = (short)var1.method3097();
               this.field2827[var4] = (short)var1.method3097();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2823[var2 - 60] = var1.method3097();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)LModelData;",
      garbageValue = "-6197"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2819 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2819.length];

         for(int var4 = 0; var4 < this.field2819.length; ++var4) {
            var1[var4] = ModelData.method1491(field2820, this.field2819[var4], 0);
         }

         ModelData var2;
         if(var1.length == 1) {
            var2 = var1[0];
         } else {
            var2 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.field2824 != null) {
            for(var3 = 0; var3 < this.field2824.length; ++var3) {
               var2.method1490(this.field2824[var3], this.field2825[var3]);
            }
         }

         if(null != this.field2826) {
            for(var3 = 0; var3 < this.field2826.length; ++var3) {
               var2.method1506(this.field2826[var3], this.field2827[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1087211689"
   )
   public ModelData method3553() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2823[var3] != -1) {
            var1[var2++] = ModelData.method1491(field2820, this.field2823[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(null != this.field2824) {
         for(var4 = 0; var4 < this.field2824.length; ++var4) {
            var5.method1490(this.field2824[var4], this.field2825[var4]);
         }
      }

      if(this.field2826 != null) {
         for(var4 = 0; var4 < this.field2826.length; ++var4) {
            var5.method1506(this.field2826[var4], this.field2827[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-122"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field2819) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2819.length; ++var2) {
            if(!field2820.method3347(this.field2819[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "588374318"
   )
   public boolean method3560() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2823[var2] != -1 && !field2820.method3347(this.field2823[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-96"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 15) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(162);
            Client.field330.method2976(Client.field441);
            Client.field330.method3124(Friend.field147);
            Client.field330.method2975(class105.field1709[82]?1:0);
            Client.field330.method3023(var3);
         }
      }

      if(var2 == 39) {
         Client.field330.method3234(183);
         Client.field330.method3023(var3);
         Client.field330.method3022(var0);
         Client.field330.method3034(var1);
         Client.field399 = 0;
         GameObject.field1614 = class5.method79(var1);
         Client.field552 = var0;
      }

      if(var2 == 21) {
         Client.field395 = var6;
         Client.field396 = var7;
         Client.field501 = 2;
         Client.field397 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method3234(101);
         Client.field330.method3173(class105.field1709[82]?1:0);
         Client.field330.method3022(class16.baseX + var0);
         Client.field330.method2976(var1 + Client.baseY);
         Client.field330.method3023(var3);
      }

      Widget var19;
      if(var2 == 1005) {
         var19 = class5.method79(var1);
         if(var19 != null && var19.itemQuantities[var0] >= 100000) {
            class10.method120(27, "", var19.itemQuantities[var0] + " x " + class18.getItemDefinition(var3).name);
         } else {
            Client.field330.method3234(156);
            Client.field330.method2976(var3);
         }

         Client.field399 = 0;
         GameObject.field1614 = class5.method79(var1);
         Client.field552 = var0;
      }

      int var9;
      if(var2 == 28) {
         Client.field330.method3234(224);
         Client.field330.method2978(var1);
         var19 = class5.method79(var1);
         if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
            var9 = var19.dynamicValues[0][1];
            class146.widgetSettings[var9] = 1 - class146.widgetSettings[var9];
            class41.method801(var9);
         }
      }

      if(var2 == 4) {
         Client.field395 = var6;
         Client.field396 = var7;
         Client.field501 = 2;
         Client.field397 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method3234(58);
         Client.field330.method2976(var3 >> 14 & 32767);
         Client.field330.method2976(var0 + class16.baseX);
         Client.field330.method3023(Client.baseY + var1);
         Client.field330.method2986(class105.field1709[82]?1:0);
      }

      if(var2 == 22) {
         Client.field395 = var6;
         Client.field396 = var7;
         Client.field501 = 2;
         Client.field397 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field330.method3234(241);
         Client.field330.method3173(class105.field1709[82]?1:0);
         Client.field330.method3022(var0 + class16.baseX);
         Client.field330.method3183(Client.baseY + var1);
         Client.field330.method3183(var3);
      }

      if(var2 == 25) {
         var19 = XGrandExchangeOffer.method69(var1, var0);
         if(var19 != null) {
            class57.method1064();
            var9 = class63.method1151(class185.method3463(var19));
            int var18 = var19.item;
            Widget var22 = XGrandExchangeOffer.method69(var1, var0);
            if(null != var22 && null != var22.field2160) {
               class18 var17 = new class18();
               var17.field192 = var22;
               var17.field196 = var22.field2160;
               class164.method3225(var17, 200000);
            }

            Client.field442 = var18;
            Client.field440 = true;
            Friend.field147 = var1;
            Client.field441 = var0;
            class138.field1920 = var9;
            Tile.method1577(var22);
            Client.field438 = 0;
            String var23;
            if(class63.method1151(class185.method3463(var19)) == 0) {
               var23 = null;
            } else if(null != var19.field2148 && var19.field2148.trim().length() != 0) {
               var23 = var19.field2148;
            } else {
               var23 = null;
            }

            Client.field297 = var23;
            if(null == Client.field297) {
               Client.field297 = "Null";
            }

            if(var19.field2068) {
               Client.field444 = var19.name + class13.method182(16777215);
            } else {
               Client.field444 = class13.method182('\uff00') + var19.field2133 + class13.method182(16777215);
            }
         }

      } else {
         if(var2 == 57 || var2 == 1007) {
            var19 = XGrandExchangeOffer.method69(var1, var0);
            if(null != var19) {
               var9 = var19.item;
               Widget var10 = XGrandExchangeOffer.method69(var1, var0);
               if(var10 != null) {
                  if(null != var10.field2178) {
                     class18 var11 = new class18();
                     var11.field192 = var10;
                     var11.field186 = var3;
                     var11.field199 = var5;
                     var11.field196 = var10.field2178;
                     class164.method3225(var11, 200000);
                  }

                  boolean var15 = true;
                  if(var10.contentType > 0) {
                     var15 = class152.method2921(var10);
                  }

                  if(var15) {
                     int var13 = class185.method3463(var10);
                     int var14 = var3 - 1;
                     boolean var12 = (var13 >> 1 + var14 & 1) != 0;
                     if(var12) {
                        if(var3 == 1) {
                           Client.field330.method3234(169);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 2) {
                           Client.field330.method3234(151);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 3) {
                           Client.field330.method3234(253);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 4) {
                           Client.field330.method3234(212);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 5) {
                           Client.field330.method3234(96);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 6) {
                           Client.field330.method3234(199);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 7) {
                           Client.field330.method3234(37);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 8) {
                           Client.field330.method3234(53);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 9) {
                           Client.field330.method3234(222);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }

                        if(var3 == 10) {
                           Client.field330.method3234(117);
                           Client.field330.method2978(var1);
                           Client.field330.method2976(var0);
                           Client.field330.method2976(var9);
                        }
                     }
                  }
               }
            }
         }

         if(var2 == 14) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(193);
               Client.field330.method2975(class105.field1709[82]?1:0);
               Client.field330.method3022(NPC.field757);
               Client.field330.method3022(class85.field1448);
               Client.field330.method3124(class156.field2238);
               Client.field330.method3022(var3);
            }
         }

         NPC var20;
         if(var2 == 1003) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            var20 = Client.cachedNPCs[var3];
            if(var20 != null) {
               NPCComposition var16 = var20.composition;
               if(var16.field3022 != null) {
                  var16 = var16.method3770();
               }

               if(null != var16) {
                  Client.field330.method3234(52);
                  Client.field330.method3022(var16.id);
               }
            }
         }

         if(var2 == 6) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(109);
            Client.field330.method3022(class16.baseX + var0);
            Client.field330.method3022(var3 >> 14 & 32767);
            Client.field330.method3183(var1 + Client.baseY);
            Client.field330.method3098(class105.field1709[82]?1:0);
         }

         if(var2 == 58) {
            var19 = XGrandExchangeOffer.method69(var1, var0);
            if(var19 != null) {
               Client.field330.method3234(126);
               Client.field330.method3124(Friend.field147);
               Client.field330.method3023(Client.field441);
               Client.field330.method3023(Client.field442);
               Client.field330.method2976(var19.item);
               Client.field330.method3022(var0);
               Client.field330.method2978(var1);
            }
         }

         if(var2 == 43) {
            Client.field330.method3234(152);
            Client.field330.method3124(var1);
            Client.field330.method3183(var0);
            Client.field330.method2976(var3);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(1);
               Client.field330.method3183(var3);
               Client.field330.method2975(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 29) {
            Client.field330.method3234(224);
            Client.field330.method2978(var1);
            var19 = class5.method79(var1);
            if(null != var19.dynamicValues && var19.dynamicValues[0][0] == 5) {
               var9 = var19.dynamicValues[0][1];
               if(var19.field2183[0] != class146.widgetSettings[var9]) {
                  class146.widgetSettings[var9] = var19.field2183[0];
                  class41.method801(var9);
               }
            }
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(245);
               Client.field330.method2986(class105.field1709[82]?1:0);
               Client.field330.method2976(var3);
            }
         }

         if(var2 == 5) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(165);
            Client.field330.method3022(class16.baseX + var0);
            Client.field330.method3023(var1 + Client.baseY);
            Client.field330.method2986(class105.field1709[82]?1:0);
            Client.field330.method3183(var3 >> 14 & 32767);
         }

         if(var2 == 3) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(144);
            Client.field330.method3022(var0 + class16.baseX);
            Client.field330.method3183(Client.baseY + var1);
            Client.field330.method3173(class105.field1709[82]?1:0);
            Client.field330.method3183(var3 >> 14 & 32767);
         }

         if(var2 == 8) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(110);
               Client.field330.method2976(Client.field441);
               Client.field330.method3022(var3);
               Client.field330.method3098(class105.field1709[82]?1:0);
               Client.field330.method3011(Friend.field147);
            }
         }

         if(var2 == 1) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(211);
            Client.field330.method3022(var3 >> 14 & 32767);
            Client.field330.method3183(NPC.field757);
            Client.field330.method3034(class156.field2238);
            Client.field330.method3183(var0 + class16.baseX);
            Client.field330.method3183(var1 + Client.baseY);
            Client.field330.method2975(class105.field1709[82]?1:0);
            Client.field330.method2976(class85.field1448);
         }

         if(var2 == 41) {
            Client.field330.method3234(217);
            Client.field330.method3034(var1);
            Client.field330.method2976(var0);
            Client.field330.method2976(var3);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 51) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(178);
               Client.field330.method2986(class105.field1709[82]?1:0);
               Client.field330.method3023(var3);
            }
         }

         if(var2 == 16) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(163);
            Client.field330.method3183(NPC.field757);
            Client.field330.method3098(class105.field1709[82]?1:0);
            Client.field330.method2976(class85.field1448);
            Client.field330.method3011(class156.field2238);
            Client.field330.method3023(var1 + Client.baseY);
            Client.field330.method3023(var3);
            Client.field330.method3022(var0 + class16.baseX);
         }

         if(var2 == 1001) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(195);
            Client.field330.method3023(class16.baseX + var0);
            Client.field330.method3023(var3 >> 14 & 32767);
            Client.field330.method2976(Client.baseY + var1);
            Client.field330.method2975(class105.field1709[82]?1:0);
         }

         if(var2 == 10) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(231);
               Client.field330.method3023(var3);
               Client.field330.method2975(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 2) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(28);
            Client.field330.method2976(class16.baseX + var0);
            Client.field330.method2978(Friend.field147);
            Client.field330.method3183(Client.baseY + var1);
            Client.field330.method3023(Client.field441);
            Client.field330.method3173(class105.field1709[82]?1:0);
            Client.field330.method3022(var3 >> 14 & 32767);
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(25);
               Client.field330.method2986(class105.field1709[82]?1:0);
               Client.field330.method3022(var3);
            }
         }

         if(var2 == 19) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(200);
            Client.field330.method2986(class105.field1709[82]?1:0);
            Client.field330.method3023(Client.baseY + var1);
            Client.field330.method3183(class16.baseX + var0);
            Client.field330.method2976(var3);
         }

         if(var2 == 7) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(59);
               Client.field330.method3022(class85.field1448);
               Client.field330.method3011(class156.field2238);
               Client.field330.method3022(NPC.field757);
               Client.field330.method2976(var3);
               Client.field330.method2986(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 24) {
            var19 = class5.method79(var1);
            boolean var21 = true;
            if(var19.contentType > 0) {
               var21 = class152.method2921(var19);
            }

            if(var21) {
               Client.field330.method3234(224);
               Client.field330.method2978(var1);
            }
         }

         if(var2 == 32) {
            Client.field330.method3234(128);
            Client.field330.method3183(var0);
            Client.field330.method3011(var1);
            Client.field330.method3011(Friend.field147);
            Client.field330.method2976(var3);
            Client.field330.method3022(Client.field441);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 13) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(191);
               Client.field330.method2986(class105.field1709[82]?1:0);
               Client.field330.method2976(var3);
            }
         }

         if(var2 == 11) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(85);
               Client.field330.method3183(var3);
               Client.field330.method3098(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(242);
               Client.field330.method3022(var3);
               Client.field330.method2986(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 34) {
            Client.field330.method3234(41);
            Client.field330.method3023(var3);
            Client.field330.method3022(var0);
            Client.field330.method3124(var1);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 42) {
            Client.field330.method3234(204);
            Client.field330.method2978(var1);
            Client.field330.method2976(var0);
            Client.field330.method3023(var3);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 31) {
            Client.field330.method3234(140);
            Client.field330.method3034(class156.field2238);
            Client.field330.method3023(NPC.field757);
            Client.field330.method3022(class85.field1448);
            Client.field330.method3023(var3);
            Client.field330.method3022(var0);
            Client.field330.method3011(var1);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 40) {
            Client.field330.method3234(143);
            Client.field330.method3022(var3);
            Client.field330.method3124(var1);
            Client.field330.method3022(var0);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 35) {
            Client.field330.method3234(221);
            Client.field330.method3023(var3);
            Client.field330.method3124(var1);
            Client.field330.method2976(var0);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 17) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field330.method3234(250);
            Client.field330.method3022(Client.baseY + var1);
            Client.field330.method2976(var3);
            Client.field330.method3023(class16.baseX + var0);
            Client.field330.method3022(Client.field441);
            Client.field330.method3011(Friend.field147);
            Client.field330.method3173(class105.field1709[82]?1:0);
         }

         if(var2 == 1004) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.field330.method3234(156);
            Client.field330.method2976(var3);
         }

         if(var2 == 50) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(223);
               Client.field330.method2976(var3);
               Client.field330.method2986(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 9) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(78);
               Client.field330.method2986(class105.field1709[82]?1:0);
               Client.field330.method3022(var3);
            }
         }

         if(var2 == 48) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(9);
               Client.field330.method3023(var3);
               Client.field330.method2986(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 36) {
            Client.field330.method3234(170);
            Client.field330.method3023(var0);
            Client.field330.method3034(var1);
            Client.field330.method3023(var3);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 49) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(22);
               Client.field330.method3022(var3);
               Client.field330.method3098(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 37) {
            Client.field330.method3234(98);
            Client.field330.method3022(var3);
            Client.field330.method2978(var1);
            Client.field330.method2976(var0);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 26) {
            class5.method72();
         }

         if(var2 == 30 && null == Client.field449) {
            class7.method104(var1, var0);
            Client.field449 = XGrandExchangeOffer.method69(var1, var0);
            Tile.method1577(Client.field449);
         }

         if(var2 == 12) {
            var20 = Client.cachedNPCs[var3];
            if(null != var20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(196);
               Client.field330.method3022(var3);
               Client.field330.method2975(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 1002) {
            Client.field395 = var6;
            Client.field396 = var7;
            Client.field501 = 2;
            Client.field397 = 0;
            Client.field330.method3234(147);
            Client.field330.method2976(var3 >> 14 & 32767);
         }

         if(var2 == 23) {
            class157.region.method1790(class166.plane, var0, var1);
         }

         if(var2 == 33) {
            Client.field330.method3234(132);
            Client.field330.method3124(var1);
            Client.field330.method3022(var3);
            Client.field330.method2976(var0);
            Client.field399 = 0;
            GameObject.field1614 = class5.method79(var1);
            Client.field552 = var0;
         }

         if(var2 == 38) {
            class57.method1064();
            var19 = class5.method79(var1);
            Client.field438 = 1;
            class85.field1448 = var0;
            class156.field2238 = var1;
            NPC.field757 = var3;
            Tile.method1577(var19);
            Client.field371 = class13.method182(16748608) + class18.getItemDefinition(var3).name + class13.method182(16777215);
            if(Client.field371 == null) {
               Client.field371 = "null";
            }

         } else {
            if(var2 == 18) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(100);
               Client.field330.method2986(class105.field1709[82]?1:0);
               Client.field330.method2976(var3);
               Client.field330.method3022(var0 + class16.baseX);
               Client.field330.method3183(var1 + Client.baseY);
            }

            if(var2 == 20) {
               Client.field395 = var6;
               Client.field396 = var7;
               Client.field501 = 2;
               Client.field397 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field330.method3234(113);
               Client.field330.method3023(var1 + Client.baseY);
               Client.field330.method3173(class105.field1709[82]?1:0);
               Client.field330.method3023(var3);
               Client.field330.method3023(class16.baseX + var0);
            }

            if(Client.field438 != 0) {
               Client.field438 = 0;
               Tile.method1577(class5.method79(class156.field2238));
            }

            if(Client.field440) {
               class57.method1064();
            }

            if(GameObject.field1614 != null && Client.field399 == 0) {
               Tile.method1577(GameObject.field1614);
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "2007747903"
   )
   public static int method3565(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.method2988(var5.length);
      var0.offset += class210.field3108.method2914(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-916508002"
   )
   static boolean method3566(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3329(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class114.method2249(var3);
         return true;
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "24534"
   )
   static final void method3567(boolean var0) {
      while(true) {
         if(Client.field370.method3239(Client.field564) >= 27) {
            int var1 = Client.field370.method3237(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field559[++Client.field326 - 1] = var1;
               var3.field644 = Client.gameCycle;
               int var4 = Client.field370.method3237(1);
               int var5 = Client.field416[Client.field370.method3237(3)];
               if(var2) {
                  var3.field646 = var3.angle = var5;
               }

               int var6;
               if(var0) {
                  var6 = Client.field370.method3237(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.field370.method3237(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7;
               if(var0) {
                  var7 = Client.field370.method3237(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = Client.field370.method3237(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               int var8 = Client.field370.method3237(1);
               if(var8 == 1) {
                  Client.field329[++Client.field337 - 1] = var1;
               }

               var3.composition = class152.getNpcDefinition(Client.field370.method3237(14));
               var3.field599 = var3.composition.field3009;
               var3.field629 = var3.composition.field3021;
               if(var3.field629 == 0) {
                  var3.angle = 0;
               }

               var3.field603 = var3.composition.field2998;
               var3.field650 = var3.composition.field3005;
               var3.field605 = var3.composition.field3011;
               var3.field606 = var3.composition.field3007;
               var3.idlePoseAnimation = var3.composition.field3001;
               var3.field601 = var3.composition.field3006;
               var3.field604 = var3.composition.field3003;
               var3.method738(var7 + class40.localPlayer.pathX[0], var6 + class40.localPlayer.pathY[0], var4 == 1);
               continue;
            }
         }

         Client.field370.method3238();
         return;
      }
   }
}

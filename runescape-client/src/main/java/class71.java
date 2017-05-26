import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class71 implements Runnable {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 828736543
   )
   int field833;
   @ObfuscatedName("h")
   Object field834;
   @ObfuscatedName("i")
   boolean field835;
   @ObfuscatedName("q")
   int[] field836;
   @ObfuscatedName("g")
   int[] field837;

   class71() {
      this.field835 = true;
      this.field834 = new Object();
      this.field833 = 0;
      this.field836 = new int[500];
      this.field837 = new int[500];
   }

   public void run() {
      for(; this.field835; class19.method145(50L)) {
         Object var1 = this.field834;
         synchronized(this.field834) {
            if(this.field833 < 500) {
               this.field836[this.field833] = class59.field721;
               this.field837[this.field833] = class59.field722;
               ++this.field833;
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModIcon;",
      garbageValue = "-41"
   )
   public static ModIcon method1122() {
      ModIcon var0 = new ModIcon();
      var0.width = class286.field3784;
      var0.originalHeight = class286.field3787;
      var0.offsetX = class286.field3785[0];
      var0.offsetY = class286.field3783[0];
      var0.originalWidth = class252.field3387[0];
      var0.height = class267.field3667[0];
      var0.palette = class87.field1355;
      var0.pixels = MessageNode.field843[0];
      class69.method1117();
      return var0;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "1953632437"
   )
   static final int method1124(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class261.method4792(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class51.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class211.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class222.field2832[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = XGrandExchangeOffer.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2828[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class261.method4792(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class51.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.field1107;
               }

               if(var6 == 12) {
                  var7 = Client.field1010;
               }

               if(var6 == 13) {
                  var9 = class211.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = Actor.method1539(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = class166.baseX + (XGrandExchangeOffer.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = (XGrandExchangeOffer.localPlayer.y >> 7) + class146.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "-1646657438"
   )
   static final void method1125(PacketBuffer var0) {
      var0.method3469();
      int var1 = Client.localInteractingIndex;
      Player var2 = XGrandExchangeOffer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field875 = var1;
      int var3 = var0.method3470(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class166.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method1143() << 6);
      var2.pathY[0] = var6 - class146.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method1143() << 6);
      Sequence.plane = var2.field874 = var4;
      if(class96.field1486[var1] != null) {
         var2.method1142(class96.field1486[var1]);
      }

      class96.field1489 = 0;
      class96.field1496[++class96.field1489 - 1] = var1;
      class96.field1484[var1] = 0;
      class96.field1499 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3470(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1491[var7] = (var9 << 28) + (var10 << 14) + var11;
            class96.field1492[var7] = 0;
            class96.field1493[var7] = -1;
            class96.field1490[++class96.field1499 - 1] = var7;
            class96.field1484[var7] = 0;
         }
      }

      var0.method3466();
   }
}

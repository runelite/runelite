import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2055732619
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("y")
   @Export("sender")
   String sender;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 919001107
   )
   @Export("type")
   int type;
   @ObfuscatedName("v")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1627312589
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @Export("value")
   String value;
   @ObfuscatedName("h")
   public static String field229;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-62"
   )
   void method217(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field945 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "426342119"
   )
   static int method220(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2437(((long)var0.id << 32) + (long)var0.index);
      return null != var1?var1.field1898:var0.field2278;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "1262402123"
   )
   static void method221(class159 var0, int var1) {
      boolean var2 = var0.method3147(1) == 1;
      if(var2) {
         class45.field920[++class45.field919 - 1] = var1;
      }

      int var3 = var0.method3147(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field242 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class45.field912[var1] = (var4.field261 << 28) + (Player.baseX + var4.pathX[0] >> 13 << 14) + (var4.pathY[0] + SecondaryBufferProvider.baseY >> 13);
            if(var4.field631 != -1) {
               class45.field917[var1] = var4.field631;
            } else {
               class45.field917[var1] = var4.field654;
            }

            class45.field910[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3147(1) != 0) {
               class8.method105(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3147(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field242 = true;
                  var4.field265 = var6;
                  var4.field244 = var7;
               } else {
                  var4.field242 = false;
                  var4.method231(var6, var7, class45.field928[var1]);
               }
            } else {
               var4.method233(var6, var7);
               var4.field242 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3147(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field242 = true;
                  var4.field265 = var6;
                  var4.field244 = var7;
               } else {
                  var4.field242 = false;
                  var4.method231(var6, var7, class45.field928[var1]);
               }
            } else {
               var4.method233(var6, var7);
               var4.field242 = false;
            }

         } else {
            var5 = var0.method3147(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3147(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field242 = true;
                     var4.field265 = var10;
                     var4.field244 = var11;
                  } else {
                     var4.field242 = false;
                     var4.method231(var10, var11, class45.field928[var1]);
                  }
               } else {
                  var4.method233(var10, var11);
                  var4.field242 = false;
               }

               var4.field261 = (byte)(var7 + var4.field261 & 3);
               if(Client.localInteractingIndex == var1) {
                  CollisionData.plane = var4.field261;
               }

            } else {
               var6 = var0.method3147(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (Player.baseX + var4.pathX[0] + var8 & 16383) - Player.baseX;
               var11 = (var9 + SecondaryBufferProvider.baseY + var4.pathY[0] & 16383) - SecondaryBufferProvider.baseY;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field242 = true;
                     var4.field265 = var10;
                     var4.field244 = var11;
                  } else {
                     var4.field242 = false;
                     var4.method231(var10, var11, class45.field928[var1]);
                  }
               } else {
                  var4.method233(var10, var11);
                  var4.field242 = false;
               }

               var4.field261 = (byte)(var4.field261 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  CollisionData.plane = var4.field261;
               }

            }
         }
      }
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field945 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }
}

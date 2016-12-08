import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("m")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1423844225
   )
   @Export("length")
   int length;
   @ObfuscatedName("br")
   static class184 field970;
   @ObfuscatedName("g")
   static ModIcon field972;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-969983211"
   )
   int method884() {
      return this.length;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-105701026"
   )
   MessageNode method885(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2380();
         var5.method199(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "-828637397"
   )
   static class109 method889() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "612649749"
   )
   MessageNode method890(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   static final void method892() {
      Region.field1502 = false;
      Client.field314 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;B)V",
      garbageValue = "55"
   )
   static void method894(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2702 = 0;
      var3.hash = (long)var0;
      var3.field2703 = var1;
      var3.field2704 = var2;
      Deque var4 = class183.field2733;
      synchronized(class183.field2733) {
         class183.field2733.method2361(var3);
      }

      Object var9 = class183.field2736;
      synchronized(class183.field2736) {
         if(class183.field2740 == 0) {
            Tile.field1346.method1939(new class183(), 5);
         }

         class183.field2740 = 600;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "-1181665066"
   )
   static void method895(class159 var0, int var1) {
      boolean var2 = var0.method2986(1) == 1;
      if(var2) {
         class45.field909[++class45.field904 - 1] = var1;
      }

      int var3 = var0.method2986(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field271 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class45.field897[var1] = (var4.pathX[0] + class107.baseX >> 6 << 14) + (var4.field256 << 28) + (var4.pathY[0] + XClanMember.baseY >> 6);
            if(var4.field614 != -1) {
               class45.field906[var1] = var4.field614;
            } else {
               class45.field906[var1] = var4.field655;
            }

            class45.field913[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2986(1) != 0) {
               class165.method3058(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2986(3);
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

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method213(var6, var7);
               var4.field271 = false;
            } else if(var2) {
               var4.field271 = true;
               var4.field272 = var6;
               var4.field251 = var7;
            } else {
               var4.field271 = false;
               var4.method212(var6, var7, class45.field916[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2986(4);
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

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field271 = true;
                  var4.field272 = var6;
                  var4.field251 = var7;
               } else {
                  var4.field271 = false;
                  var4.method212(var6, var7, class45.field916[var1]);
               }
            } else {
               var4.method213(var6, var7);
               var4.field271 = false;
            }

         } else {
            var5 = var0.method2986(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2986(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.pathX[0] + var8;
               var11 = var4.pathY[0] + var9;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method213(var10, var11);
                  var4.field271 = false;
               } else if(var2) {
                  var4.field271 = true;
                  var4.field272 = var10;
                  var4.field251 = var11;
               } else {
                  var4.field271 = false;
                  var4.method212(var10, var11, class45.field916[var1]);
               }

               var4.field256 = (byte)(var7 + var4.field256 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class63.plane = var4.field256;
               }

            } else {
               var6 = var0.method2986(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.pathX[0] + class107.baseX & 16383) - class107.baseX;
               var11 = (XClanMember.baseY + var4.pathY[0] + var9 & 16383) - XClanMember.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field271 = true;
                     var4.field272 = var10;
                     var4.field251 = var11;
                  } else {
                     var4.field271 = false;
                     var4.method212(var10, var11, class45.field916[var1]);
                  }
               } else {
                  var4.method213(var10, var11);
                  var4.field271 = false;
               }

               var4.field256 = (byte)(var7 + var4.field256 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class63.plane = var4.field256;
               }

            }
         }
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1324552385"
   )
   static final int method896(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class10.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class10.tileHeights[var5][var3][var4] * (128 - var6) + var6 * class10.tileHeights[var5][1 + var3][var4] >> 7;
         int var9 = (128 - var6) * class10.tileHeights[var5][var3][1 + var4] + class10.tileHeights[var5][1 + var3][var4 + 1] * var6 >> 7;
         return (128 - var7) * var8 + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }
}

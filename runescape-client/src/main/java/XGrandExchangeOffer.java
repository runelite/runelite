import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -545038101
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1877311749
   )
   static int field45;
   @ObfuscatedName("c")
   static ModIcon field46;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 209426457
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1913220197
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 175731921
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("q")
   @Export("progress")
   byte progress;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 155962015
   )
   @Export("price")
   public int price;
   @ObfuscatedName("em")
   static SpritePixels[] field56;
   @ObfuscatedName("r")
   static SpritePixels field57;
   @ObfuscatedName("b")
   static Widget field58;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.method2965();
      this.totalQuantity = var1.method2965();
      this.quantitySold = var1.method2965();
      this.spent = var1.method2965();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1628747381"
   )
   public int method43() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1059353865"
   )
   void method44(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "10"
   )
   void method45(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1949022028"
   )
   public int method55() {
      return this.progress & 7;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)V",
      garbageValue = "54"
   )
   static void method56(class159 var0, int var1) {
      boolean var2 = var0.method3095(1) == 1;
      if(var2) {
         class45.field916[++class45.field928 - 1] = var1;
      }

      int var3 = var0.method3095(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field261 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class45.field925[var1] = (var4.pathY[0] + XClanMember.baseY >> 13) + (var4.field277 << 28) + (var4.pathX[0] + class5.baseX >> 13 << 14);
            if(var4.field651 != -1) {
               class45.field926[var1] = var4.field651;
            } else {
               class45.field926[var1] = var4.field674;
            }

            class45.field927[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3095(1) != 0) {
               Projectile.method866(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3095(3);
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

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field261 = true;
                  var4.field280 = var6;
                  var4.field278 = var7;
               } else {
                  var4.field261 = false;
                  var4.method248(var6, var7, class45.field923[var1]);
               }
            } else {
               var4.method230(var6, var7);
               var4.field261 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method3095(4);
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
                  var4.field261 = true;
                  var4.field280 = var6;
                  var4.field278 = var7;
               } else {
                  var4.field261 = false;
                  var4.method248(var6, var7, class45.field923[var1]);
               }
            } else {
               var4.method230(var6, var7);
               var4.field261 = false;
            }

         } else {
            var5 = var0.method3095(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3095(12);
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
               var11 = var9 + var4.pathY[0];
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method230(var10, var11);
                  var4.field261 = false;
               } else if(var2) {
                  var4.field261 = true;
                  var4.field280 = var10;
                  var4.field278 = var11;
               } else {
                  var4.field261 = false;
                  var4.method248(var10, var11, class45.field923[var1]);
               }

               var4.field277 = (byte)(var7 + var4.field277 & 3);
               if(var1 == Client.localInteractingIndex) {
                  WallObject.plane = var4.field277;
               }

            } else {
               var6 = var0.method3095(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.pathX[0] + class5.baseX + var8 & 16383) - class5.baseX;
               var11 = (XClanMember.baseY + var4.pathY[0] + var9 & 16383) - XClanMember.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field261 = true;
                     var4.field280 = var10;
                     var4.field278 = var11;
                  } else {
                     var4.field261 = false;
                     var4.method248(var10, var11, class45.field923[var1]);
                  }
               } else {
                  var4.method230(var10, var11);
                  var4.field261 = false;
               }

               var4.field277 = (byte)(var7 + var4.field277 & 3);
               if(Client.localInteractingIndex == var1) {
                  WallObject.plane = var4.field277;
               }

            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1904709784"
   )
   public static void method57() {
      if(class105.keyboard != null) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }
}

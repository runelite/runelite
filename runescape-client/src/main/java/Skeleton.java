import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("Skeleton")
public class Skeleton extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2096389021
   )
   static int field874;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache1")
   static IndexCache indexCache1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1634889691
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1875841677
   )
   @Export("count")
   int count;
   @ObfuscatedName("q")
   @Export("transformTypes")
   int[] transformTypes;
   @ObfuscatedName("w")
   @Export("labels")
   int[][] labels;

   Skeleton(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.transformTypes = new int[this.count];
      this.labels = new int[this.count][];

      int var4;
      for (var4 = 0; var4 < this.count; ++var4) {
         this.transformTypes[var4] = var3.readUnsignedByte();
      }

      for (var4 = 0; var4 < this.count; ++var4) {
         this.labels[var4] = new int[var3.readUnsignedByte()];
      }

      for (var4 = 0; var4 < this.count; ++var4) {
         for (int var5 = 0; var5 < this.labels[var4].length; ++var5) {
            this.labels[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhx;IB)V",
      garbageValue = "3"
   )
   static final void method3062(PacketBuffer var0, int var1) {
      int var2 = var0.index;
      Players.field736 = 0;
      int var3 = 0;
      var0.importIndex();

      int var4;
      int var5;
      int var6;
      for (var4 = 0; var4 < Players.Players_count; ++var4) {
         var5 = Players.Players_indices[var4];
         if ((Players.field731[var5] & 1) == 0) {
            if (var3 > 0) {
               --var3;
               Players.field731[var5] = (byte)(Players.field731[var5] | 2);
            } else {
               var6 = var0.readBits(1);
               if (var6 == 0) {
                  var3 = GrandExchangeOffer.method105(var0);
                  Players.field731[var5] = (byte)(Players.field731[var5] | 2);
               } else {
                  class210.method4101(var0, var5);
               }
            }
         }
      }

      var0.exportIndex();
      if (var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.importIndex();

         for (var4 = 0; var4 < Players.Players_count; ++var4) {
            var5 = Players.Players_indices[var4];
            if ((Players.field731[var5] & 1) != 0) {
               if (var3 > 0) {
                  --var3;
                  Players.field731[var5] = (byte)(Players.field731[var5] | 2);
               } else {
                  var6 = var0.readBits(1);
                  if (var6 == 0) {
                     var3 = GrandExchangeOffer.method105(var0);
                     Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                  } else {
                     class210.method4101(var0, var5);
                  }
               }
            }
         }

         var0.exportIndex();
         if (var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.importIndex();

            for (var4 = 0; var4 < Players.field734; ++var4) {
               var5 = Players.field735[var4];
               if ((Players.field731[var5] & 1) != 0) {
                  if (var3 > 0) {
                     --var3;
                     Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                  } else {
                     var6 = var0.readBits(1);
                     if (var6 == 0) {
                        var3 = GrandExchangeOffer.method105(var0);
                        Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                     } else if (class236.updateExternalPlayer(var0, var5)) {
                        Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                     }
                  }
               }
            }

            var0.exportIndex();
            if (var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.importIndex();

               for (var4 = 0; var4 < Players.field734; ++var4) {
                  var5 = Players.field735[var4];
                  if ((Players.field731[var5] & 1) == 0) {
                     if (var3 > 0) {
                        --var3;
                        Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                     } else {
                        var6 = var0.readBits(1);
                        if (var6 == 0) {
                           var3 = GrandExchangeOffer.method105(var0);
                           Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                        } else if (class236.updateExternalPlayer(var0, var5)) {
                           Players.field731[var5] = (byte)(Players.field731[var5] | 2);
                        }
                     }
                  }
               }

               var0.exportIndex();
               if (var3 != 0) {
                  throw new RuntimeException();
               } else {
                  Players.Players_count = 0;
                  Players.field734 = 0;

                  for (var4 = 1; var4 < 2048; ++var4) {
                     Players.field731[var4] = (byte)(Players.field731[var4] >> 1);
                     Player var7 = Client.players[var4];
                     if (var7 != null) {
                        Players.Players_indices[++Players.Players_count - 1] = var4;
                     } else {
                        Players.field735[++Players.field734 - 1] = var4;
                     }
                  }

                  class21.method293(var0);
                  if (var0.index - var2 != var1) {
                     throw new RuntimeException(var0.index - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}

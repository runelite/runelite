import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 1014848265
   )
   static int field315;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("h")
   static int[] field321;
   @ObfuscatedName("i")
   static int[] field316;
   @ObfuscatedName("fu")
   static byte[][] field320;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;B)I",
      garbageValue = "98"
   )
   int method120(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method120((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1868760878"
   )
   static final void method121(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
         var3 = class93.playerIndices[var2];
         if((class93.field1403[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = ScriptEvent.method1090(var0);
                  class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
               } else {
                  Varcs.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class93.playerIndexesCount; ++var2) {
            var3 = class93.playerIndices[var2];
            if((class93.field1403[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = ScriptEvent.method1090(var0);
                     class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                  } else {
                     Varcs.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class93.field1408; ++var2) {
               var3 = class93.field1409[var2];
               if((class93.field1403[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = ScriptEvent.method1090(var0);
                        class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                     } else if(Size.decodeRegionHash(var0, var3)) {
                        class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class93.field1408; ++var2) {
                  var3 = class93.field1409[var2];
                  if((class93.field1403[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = ScriptEvent.method1090(var0);
                           class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                        } else if(Size.decodeRegionHash(var0, var3)) {
                           class93.field1403[var3] = (byte)(class93.field1403[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class93.playerIndexesCount = 0;
                  class93.field1408 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class93.field1403[var2] = (byte)(class93.field1403[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class93.playerIndices[++class93.playerIndexesCount - 1] = var2;
                     } else {
                        class93.field1409[++class93.field1408 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "0"
   )
   static final void method126(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class18.loadWidget(var0)) {
         class22.method171(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}

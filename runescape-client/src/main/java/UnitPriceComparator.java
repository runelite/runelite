import java.util.Comparator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   static SpritePixels field307;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = 1117451845
   )
   static int field308;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "795102094"
   )
   int method123(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method123((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "1250090185"
   )
   static String method133(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "103"
   )
   public static void method132(int var0) {
      class214.field2617 = 1;
      class214.field2614 = null;
      class293.field3798 = -1;
      class23.field342 = -1;
      IndexFile.field2192 = 0;
      class33.field446 = false;
      class214.field2616 = var0;
   }
}

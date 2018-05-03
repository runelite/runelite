import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 350399471
   )
   static int field293;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1746835957
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 8798626848592813739L
   )
   public final long field287;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("z")
   @Export("string1")
   String string1;
   @ObfuscatedName("n")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgg;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field287 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method114(2);
      this.grandExchangeOffer.method113(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1687703362"
   )
   public String method86() {
      return this.string1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-661348167"
   )
   public String method85() {
      return this.string2;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "58"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class62.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class62.tileHeights[var5][var3][var4] + var6 * class62.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = var6 * class62.tileHeights[var5][var3 + 1][var4 + 1] + class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}

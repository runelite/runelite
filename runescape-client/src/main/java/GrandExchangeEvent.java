import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -778129325
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -8473753853482061503L
   )
   public final long field275;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ld;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("s")
   @Export("string1")
   String string1;
   @ObfuscatedName("j")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgj;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field275 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method126(2);
      this.grandExchangeOffer.method111(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-517218738"
   )
   public String method92() {
      return this.string1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2047963805"
   )
   public String method91() {
      return this.string2;
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)Lli;",
      garbageValue = "1844791572"
   )
   static RenderOverview method97() {
      return ScriptState.renderOverview;
   }
}

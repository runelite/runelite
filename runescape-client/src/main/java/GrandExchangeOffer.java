import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = -1743088235
   )
   static int field311;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("g")
   @Export("state")
   byte state;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 550117097
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 549245207
   )
   @Export("price")
   public int price;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 659693431
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1141687211
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -325797749
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgg;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1624057067"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-76"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "16468"
   )
   void method114(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-58019683"
   )
   void method113(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1892695296"
   )
   public static int method122(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(Lbm;II)V",
      garbageValue = "1429104717"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      Widget.worldToScreen(var0.x, var0.y, var1);
   }
}

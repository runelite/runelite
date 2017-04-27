import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -379833969
   )
   @Export("price")
   public int price;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -166841073
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2029908369
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1338561469
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1979301933
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("d")
   @Export("progress")
   byte progress;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-80"
   )
   public int method42() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "785538384"
   )
   public int method44() {
      return this.progress & 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "706873967"
   )
   void method46(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-731297457"
   )
   void method47(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   public XGrandExchangeOffer() {
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1992769239
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 996899667
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 519482543
   )
   @Export("price")
   public int price;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -398437583
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -743788319
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("l")
   @Export("progress")
   byte progress;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "105"
   )
   public int method4144() {
      return this.progress & 7;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-52"
   )
   public int method4148() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-29"
   )
   void method4149(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1395785194"
   )
   void method4150(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.method2634();
      this.itemId = var1.method2635();
      this.price = var1.method2620();
      this.totalQuantity = var1.method2620();
      this.quantitySold = var1.method2620();
      this.spent = var1.method2620();
   }

   public XGrandExchangeOffer() {
   }
}

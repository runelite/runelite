import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 860989665
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("k")
   @Export("progress")
   byte progress;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1187235053
   )
   @Export("price")
   public int price;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -875094553
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2023736145
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -341442047
   )
   @Export("spent")
   public int spent;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-123"
   )
   public int method4018() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-849790857"
   )
   void method4019(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1778799215"
   )
   void method4020(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-713391965"
   )
   public int method4029() {
      return this.progress & 7;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.method2572();
      this.itemId = var1.method2691();
      this.price = var1.method2576();
      this.totalQuantity = var1.method2576();
      this.quantitySold = var1.method2576();
      this.spent = var1.method2576();
   }
}

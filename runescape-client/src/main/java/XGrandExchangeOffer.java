import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -756458473
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("i")
   @Export("progress")
   byte progress;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 291150401
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1613102997
   )
   @Export("price")
   public int price;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1055141957
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -341472721
   )
   @Export("spent")
   public int spent;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.method2545();
      this.itemId = var1.method2546();
      this.price = var1.method2549();
      this.totalQuantity = var1.method2549();
      this.quantitySold = var1.method2549();
      this.spent = var1.method2549();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "54"
   )
   public int method4026() {
      return this.progress & 7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "7150"
   )
   public int method4027() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1818240162"
   )
   void method4028(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-118"
   )
   void method4034(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }
}

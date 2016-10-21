import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -480262523
   )
   @Export("price")
   public int price;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1477429399
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -346476357
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1405432253
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2081928881
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("f")
   @Export("progress")
   byte progress;
   @ObfuscatedName("dh")
   static int[] field3222;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1400561137"
   )
   public int method4063() {
      return this.progress & 7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "863083657"
   )
   void method4065(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "18"
   )
   void method4067(int var1) {
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
      this.progress = var1.method2534();
      this.itemId = var1.method2535();
      this.price = var1.method2538();
      this.totalQuantity = var1.method2538();
      this.quantitySold = var1.method2538();
      this.spent = var1.method2538();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-19464"
   )
   public int method4072() {
      return (this.progress & 8) == 8?1:0;
   }

   public XGrandExchangeOffer() {
   }
}

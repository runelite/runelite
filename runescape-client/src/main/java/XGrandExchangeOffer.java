import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -313402433
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2082528611
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 793461637
   )
   @Export("price")
   public int price;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1207493511
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("a")
   @Export("progress")
   byte progress;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 734411763
   )
   @Export("quantitySold")
   public int quantitySold;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.method2529();
      this.itemId = var1.method2717();
      this.price = var1.method2533();
      this.totalQuantity = var1.method2533();
      this.quantitySold = var1.method2533();
      this.spent = var1.method2533();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "209664566"
   )
   public int method4042() {
      return this.progress & 7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1047829414"
   )
   void method4043(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1423877529"
   )
   public int method4044() {
      return (this.progress & 8) == 8?1:0;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   void method4055(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }
}

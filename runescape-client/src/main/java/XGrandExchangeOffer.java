import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1374357707
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2138448551
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("s")
   @Export("progress")
   byte progress;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 344705533
   )
   @Export("price")
   public int price;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1228457433
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2047488067
   )
   @Export("spent")
   public int spent;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "682164099"
   )
   public int method3984() {
      return this.progress & 7;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "10"
   )
   public int method3989() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "283103088"
   )
   void method3990(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.method2601();
      this.itemId = var1.method2668();
      this.price = var1.method2526();
      this.totalQuantity = var1.method2526();
      this.quantitySold = var1.method2526();
      this.spent = var1.method2526();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "929648981"
   )
   void method4005(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }
}

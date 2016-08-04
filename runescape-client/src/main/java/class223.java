import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("XGrandExchangeOffer")
public class class223 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1992769239
   )
   @Export("totalQuantity")
   public int field3214;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 996899667
   )
   @Export("itemId")
   public int field3215;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 519482543
   )
   @Export("price")
   public int field3216;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -398437583
   )
   @Export("spent")
   public int field3217;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -743788319
   )
   @Export("quantitySold")
   public int field3218;
   @ObfuscatedName("l")
   @Export("progress")
   byte field3219;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "105"
   )
   public int method4144() {
      return this.field3219 & 7;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-52"
   )
   public int method4148() {
      return (this.field3219 & 8) == 8?1:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-29"
   )
   void method4149(int var1) {
      this.field3219 &= -8;
      this.field3219 = (byte)(this.field3219 | var1 & 7);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1395785194"
   )
   void method4150(int var1) {
      this.field3219 &= -9;
      if(var1 == 1) {
         this.field3219 = (byte)(this.field3219 | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass122;Z)V",
      garbageValue = "0"
   )
   public class223(class122 var1, boolean var2) {
      this.field3219 = var1.method2634();
      this.field3215 = var1.method2635();
      this.field3216 = var1.method2620();
      this.field3214 = var1.method2620();
      this.field3218 = var1.method2620();
      this.field3217 = var1.method2620();
   }

   public class223() {
   }
}

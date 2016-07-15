import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("XGrandExchangeOffer")
public class class223 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1131288449
   )
   @Export("totalQuantity")
   public int field3213;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2130230051
   )
   @Export("itemId")
   public int field3214;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2105854815
   )
   @Export("price")
   public int field3215;
   @ObfuscatedName("e")
   @Export("progress")
   byte field3216;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 199662787
   )
   @Export("quantitySold")
   public int field3217;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1372846313
   )
   @Export("spent")
   public int field3218;

   @ObfuscatedSignature(
      signature = "(Lclass122;Z)V",
      garbageValue = "0"
   )
   public class223(class122 var1, boolean var2) {
      this.field3216 = var1.method2611();
      this.field3214 = var1.method2612();
      this.field3215 = var1.method2614();
      this.field3213 = var1.method2614();
      this.field3217 = var1.method2614();
      this.field3218 = var1.method2614();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1193666415"
   )
   void method4084(int var1) {
      this.field3216 &= -8;
      this.field3216 = (byte)(this.field3216 | var1 & 7);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1424728969"
   )
   public int method4085() {
      return (this.field3216 & 8) == 8?1:0;
   }

   public class223() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1094357946"
   )
   void method4090(int var1) {
      this.field3216 &= -9;
      if(var1 == 1) {
         this.field3216 = (byte)(this.field3216 | 8);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1507219133"
   )
   public int method4095() {
      return this.field3216 & 7;
   }
}

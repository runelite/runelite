import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1047643245
   )
   @Export("price")
   public int field3167;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 651764155
   )
   @Export("spent")
   public int field3168;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1104544609
   )
   @Export("itemId")
   public int field3169;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1342885107
   )
   @Export("totalQuantity")
   public int field3170;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -257658507
   )
   @Export("quantitySold")
   public int field3171;
   @ObfuscatedName("e")
   @Export("progress")
   byte field3172;

   public class220() {
   }

   @ObfuscatedName("s")
   public int method3981() {
      return (this.field3172 & 8) == 8?1:0;
   }

   @ObfuscatedName("h")
   void method3982(int var1) {
      this.field3172 &= -9;
      if(var1 == 1) {
         this.field3172 = (byte)(this.field3172 | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3172 = var1.method2633();
      this.field3169 = var1.method2700();
      this.field3167 = var1.method2528();
      this.field3170 = var1.method2528();
      this.field3171 = var1.method2528();
      this.field3168 = var1.method2528();
   }

   @ObfuscatedName("p")
   void method3993(int var1) {
      this.field3172 &= -8;
      this.field3172 = (byte)(this.field3172 | var1 & 7);
   }

   @ObfuscatedName("f")
   public int method3996() {
      return this.field3172 & 7;
   }
}

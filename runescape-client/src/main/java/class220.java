import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 652353607
   )
   @Export("quantitySold")
   public int field3171;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -354674801
   )
   @Export("itemId")
   public int field3172;
   @ObfuscatedName("t")
   @Export("progress")
   byte field3173;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 781857111
   )
   @Export("totalQuantity")
   public int field3174;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -545751387
   )
   @Export("spent")
   public int field3175;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -55078057
   )
   @Export("price")
   public int field3176;

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3173 = var1.method2469();
      this.field3172 = var1.method2470();
      this.field3176 = var1.method2505();
      this.field3174 = var1.method2505();
      this.field3171 = var1.method2505();
      this.field3175 = var1.method2505();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "554498316"
   )
   public int method3924() {
      return (this.field3173 & 8) == 8?1:0;
   }

   public class220() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   void method3927(int var1) {
      this.field3173 &= -8;
      this.field3173 = (byte)(this.field3173 | var1 & 7);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "12956"
   )
   void method3931(int var1) {
      this.field3173 &= -9;
      if(var1 == 1) {
         this.field3173 = (byte)(this.field3173 | 8);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-25214"
   )
   public int method3937() {
      return this.field3173 & 7;
   }
}

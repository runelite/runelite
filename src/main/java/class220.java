import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -563237145
   )
   @Export("quantitySold")
   public int field3173;
   @ObfuscatedName("j")
   @Export("progress")
   byte field3174;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1416949157
   )
   @Export("price")
   public int field3175;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -725045011
   )
   @Export("totalQuantity")
   public int field3176;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2083637273
   )
   @Export("itemId")
   public int field3177;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1905891119
   )
   @Export("spent")
   public int field3178;

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3174 = var1.method2670();
      this.field3177 = var1.method2502();
      this.field3175 = var1.method2505();
      this.field3176 = var1.method2505();
      this.field3173 = var1.method2505();
      this.field3178 = var1.method2505();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "376016919"
   )
   public int method3972() {
      return (this.field3174 & 8) == 8?1:0;
   }

   public class220() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-14"
   )
   void method3973(int var1) {
      this.field3174 &= -9;
      if(1 == var1) {
         this.field3174 = (byte)(this.field3174 | 8);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   void method3984(int var1) {
      this.field3174 &= -8;
      this.field3174 = (byte)(this.field3174 | var1 & 7);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int method3991() {
      return this.field3174 & 7;
   }
}

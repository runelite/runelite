import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1396490125
   )
   @Export("quantitySold")
   public int field3171;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 951021169
   )
   @Export("itemId")
   public int field3172;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1230652013
   )
   @Export("price")
   public int field3173;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2137566865
   )
   @Export("totalQuantity")
   public int field3174;
   @ObfuscatedName("w")
   @Export("progress")
   byte field3175;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1073512627
   )
   @Export("spent")
   public int field3176;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1646966705"
   )
   void method3998(int var1) {
      this.field3175 &= -9;
      if(1 == var1) {
         this.field3175 = (byte)(this.field3175 | 8);
      }

   }

   @ObfuscatedName("t")
   public int method4000() {
      return this.field3175 & 7;
   }

   @ObfuscatedName("e")
   void method4002(int var1) {
      this.field3175 &= -8;
      this.field3175 = (byte)(this.field3175 | var1 & 7);
   }

   @ObfuscatedName("p")
   public int method4003() {
      return 8 == (this.field3175 & 8)?1:0;
   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3175 = var1.method2524();
      this.field3172 = var1.method2508();
      this.field3173 = var1.method2511();
      this.field3174 = var1.method2511();
      this.field3171 = var1.method2511();
      this.field3176 = var1.method2511();
   }

   public class220() {
   }
}

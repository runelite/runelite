import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -236448273
   )
   @Export("quantitySold")
   public int field3169;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1502307281
   )
   @Export("itemId")
   public int field3170;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1558046363
   )
   @Export("price")
   public int field3171;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1353130671
   )
   @Export("totalQuantity")
   public int field3172;
   @ObfuscatedName("a")
   @Export("progress")
   byte field3173;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2056250401
   )
   @Export("spent")
   public int field3174;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   void method4075(int var1) {
      this.field3173 &= -8;
      this.field3173 = (byte)(this.field3173 | var1 & 7);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1279521355"
   )
   public int method4078() {
      return this.field3173 & 7;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-32697393"
   )
   public int method4079() {
      return (this.field3173 & 8) == 8?1:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1491464223"
   )
   void method4081(int var1) {
      this.field3173 &= -9;
      if(1 == var1) {
         this.field3173 = (byte)(this.field3173 | 8);
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3173 = var1.method2699();
      this.field3170 = var1.method2615();
      this.field3171 = var1.method2618();
      this.field3172 = var1.method2618();
      this.field3169 = var1.method2618();
      this.field3174 = var1.method2618();
   }

   public class220() {
   }
}

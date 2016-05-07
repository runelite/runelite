import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1388905309
   )
   @Export("quantitySold")
   public int field3174;
   @ObfuscatedName("s")
   @Export("progress")
   byte field3175;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 663543437
   )
   @Export("price")
   public int field3176;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1782366781
   )
   @Export("totalQuantity")
   public int field3177;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1168657095
   )
   @Export("itemId")
   public int field3178;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -616860469
   )
   @Export("spent")
   public int field3179;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "180"
   )
   public int method3968() {
      return 8 == (this.field3175 & 8)?1:0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   void method3969(int var1) {
      this.field3175 &= -8;
      this.field3175 = (byte)(this.field3175 | var1 & 7);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1690779069"
   )
   void method3970(int var1) {
      this.field3175 &= -9;
      if(1 == var1) {
         this.field3175 = (byte)(this.field3175 | 8);
      }

   }

   public class220() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "99216259"
   )
   public int method3974() {
      return this.field3175 & 7;
   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3175 = var1.method2493();
      this.field3178 = var1.method2584();
      this.field3176 = var1.method2497();
      this.field3177 = var1.method2497();
      this.field3174 = var1.method2497();
      this.field3179 = var1.method2497();
   }
}

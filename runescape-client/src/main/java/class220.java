import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("XGrandExchangeOffer")
public class class220 {
   @ObfuscatedName("f")
   @Export("progress")
   byte field3167;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2082201377
   )
   @Export("itemId")
   public int field3168;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -438863831
   )
   @Export("price")
   public int field3169;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1491577517
   )
   @Export("spent")
   public int field3170;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2138467961
   )
   @Export("quantitySold")
   public int field3171;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1755377981
   )
   @Export("totalQuantity")
   public int field3172;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "128"
   )
   void method4015(int var1) {
      this.field3167 &= -8;
      this.field3167 = (byte)(this.field3167 | var1 & 7);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1189601815"
   )
   public int method4017() {
      return this.field3167 & 7;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-115"
   )
   public int method4018() {
      return (this.field3167 & 8) == 8?1:0;
   }

   @ObfuscatedSignature(
      signature = "(Lclass119;Z)V",
      garbageValue = "0"
   )
   public class220(class119 var1, boolean var2) {
      this.field3167 = var1.method2538();
      this.field3168 = var1.method2556();
      this.field3169 = var1.method2696();
      this.field3172 = var1.method2696();
      this.field3171 = var1.method2696();
      this.field3170 = var1.method2696();
   }

   public class220() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "129993729"
   )
   void method4033(int var1) {
      this.field3167 &= -9;
      if(var1 == 1) {
         this.field3167 = (byte)(this.field3167 | 8);
      }

   }
}

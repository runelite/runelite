import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("XGrandExchangeOffer")
public class class219 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 757875425
   )
   @Export("totalQuantity")
   public int field3162;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 648329009
   )
   @Export("itemId")
   public int field3163;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1396237507
   )
   @Export("price")
   public int field3164;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1021142605
   )
   @Export("quantitySold")
   public int field3165;
   @ObfuscatedName("v")
   static int[] field3166;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -731012833
   )
   @Export("spent")
   public int field3167;
   @ObfuscatedName("a")
   @Export("progress")
   byte field3168;

   @ObfuscatedName("r")
   public int method4028() {
      return this.field3168 & 7;
   }

   @ObfuscatedName("f")
   public int method4029() {
      return (this.field3168 & 8) == 8?1:0;
   }

   @ObfuscatedName("s")
   void method4030(int var1) {
      this.field3168 &= -8;
      this.field3168 = (byte)(this.field3168 | var1 & 7);
   }

   @ObfuscatedName("y")
   void method4031(int var1) {
      this.field3168 &= -9;
      if(var1 == 1) {
         this.field3168 = (byte)(this.field3168 | 8);
      }

   }

   public class219() {
   }

   @ObfuscatedSignature(
      signature = "(Lclass118;Z)V",
      garbageValue = "0"
   )
   public class219(class118 var1, boolean var2) {
      this.field3168 = var1.method2707();
      this.field3163 = var1.method2514();
      this.field3164 = var1.method2517();
      this.field3162 = var1.method2517();
      this.field3165 = var1.method2517();
      this.field3167 = var1.method2517();
   }
}

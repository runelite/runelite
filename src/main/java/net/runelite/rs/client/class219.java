import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hz")
@Implements("XGrandExchangeOffer")
public class class219 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 64102983
   )
   @Export("spent")
   public int field3164;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2103275065
   )
   @Export("itemId")
   public int field3165;
   @ObfuscatedName("j")
   @Export("progress")
   byte field3166;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -369177729
   )
   @Export("totalQuantity")
   public int field3167;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2124224939
   )
   @Export("quantitySold")
   public int field3168;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 705812243
   )
   @Export("price")
   public int field3169;

   public class219(class118 var1, boolean var2) {
      this.field3166 = var1.method2454();
      this.field3165 = var1.method2455();
      this.field3169 = var1.method2458();
      this.field3167 = var1.method2458();
      this.field3168 = var1.method2458();
      this.field3164 = var1.method2458();
   }

   @ObfuscatedName("a")
   public int method3929() {
      return 8 == (this.field3166 & 8)?1:0;
   }

   @ObfuscatedName("i")
   void method3931(int var1) {
      this.field3166 &= -8;
      this.field3166 = (byte)(this.field3166 | var1 & 7);
   }

   @ObfuscatedName("f")
   void method3932(int var1) {
      this.field3166 &= -9;
      if(1 == var1) {
         this.field3166 = (byte)(this.field3166 | 8);
      }

   }

   @ObfuscatedName("l")
   public int method3935() {
      return this.field3166 & 7;
   }

   public class219() {
   }
}

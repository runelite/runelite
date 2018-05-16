import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1963843157
   )
   public static int field3748;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1888106309
   )
   public int field3752;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1531797137
   )
   public int field3749;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 452854427
   )
   public int field3750;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1956337095
   )
   public int field3751;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method5730(var1, var2);
      this.method5729(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-57"
   )
   public void method5730(int var1, int var2) {
      this.field3752 = var1;
      this.field3749 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1628566962"
   )
   public void method5729(int var1, int var2) {
      this.field3750 = var1;
      this.field3751 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lka;Lka;B)V",
      garbageValue = "-24"
   )
   public void method5742(Bounds var1, Bounds var2) {
      this.method5736(var1, var2);
      this.method5727(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lka;Lka;I)V",
      garbageValue = "2101083444"
   )
   void method5736(Bounds var1, Bounds var2) {
      var2.field3752 = this.field3752;
      var2.field3750 = this.field3750;
      if(this.field3752 < var1.field3752) {
         var2.field3750 -= var1.field3752 - this.field3752;
         var2.field3752 = var1.field3752;
      }

      if(var2.method5738() > var1.method5738()) {
         var2.field3750 -= var2.method5738() - var1.method5738();
      }

      if(var2.field3750 < 0) {
         var2.field3750 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lka;Lka;B)V",
      garbageValue = "82"
   )
   void method5727(Bounds var1, Bounds var2) {
      var2.field3749 = this.field3749;
      var2.field3751 = this.field3751;
      if(this.field3749 < var1.field3749) {
         var2.field3751 -= var1.field3749 - this.field3749;
         var2.field3749 = var1.field3749;
      }

      if(var2.method5723() > var1.method5723()) {
         var2.field3751 -= var2.method5723() - var1.method5723();
      }

      if(var2.field3751 < 0) {
         var2.field3751 = 0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-379485306"
   )
   int method5738() {
      return this.field3750 + this.field3752;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "188803038"
   )
   int method5723() {
      return this.field3751 + this.field3749;
   }

   public String toString() {
      return null;
   }
}

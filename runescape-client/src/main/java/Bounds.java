import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2004088829
   )
   public int field41;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1887298731
   )
   public int field42;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2001187823
   )
   public int field43;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1377856837
   )
   public int field44;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method28(var1, var2);
      this.method29(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public void method28(int var1, int var2) {
      this.field41 = var1;
      this.field42 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-11269827"
   )
   public void method29(int var1, int var2) {
      this.field43 = var1;
      this.field44 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;I)V",
      garbageValue = "-2123792170"
   )
   public void method30(Bounds var1, Bounds var2) {
      this.method31(var1, var2);
      this.method32(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;I)V",
      garbageValue = "314675149"
   )
   void method31(Bounds var1, Bounds var2) {
      var2.field41 = this.field41;
      var2.field43 = this.field43;
      if (this.field41 < var1.field41) {
         var2.field43 -= var1.field41 - this.field41;
         var2.field41 = var1.field41;
      }

      if (var2.method33() > var1.method33()) {
         var2.field43 -= var2.method33() - var1.method33();
      }

      if (var2.field43 < 0) {
         var2.field43 = 0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;S)V",
      garbageValue = "128"
   )
   void method32(Bounds var1, Bounds var2) {
      var2.field42 = this.field42;
      var2.field44 = this.field44;
      if (this.field42 < var1.field42) {
         var2.field44 -= var1.field42 - this.field42;
         var2.field42 = var1.field42;
      }

      if (var2.method34() > var1.method34()) {
         var2.field44 -= var2.method34() - var1.method34();
      }

      if (var2.field44 < 0) {
         var2.field44 = 0;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1842151293"
   )
   int method33() {
      return this.field41 + this.field43;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-22"
   )
   int method34() {
      return this.field42 + this.field44;
   }

   @ObfuscatedName("toString")
   public String method35() {
      return null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(DDII)[D",
      garbageValue = "2112793889"
   )
   public static double[] method5905(double var0, double var2, int var4) {
      int var5 = var4 * 2 + 1;
      double[] var6 = new double[var5];
      int var7 = -var4;

      for (int var8 = 0; var7 <= var4; ++var8) {
         double var9 = ((double)var7 - var0) / var2;
         double var11 = Math.exp(-var9 * var9 / 2.0D) / Math.sqrt(6.283185307179586D);
         double var13 = var11 / var2;
         var6[var8] = var13;
         ++var7;
      }

      return var6;
   }
}

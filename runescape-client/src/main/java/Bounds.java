import net.runelite.mapping.Export;
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
   @Export("__m")
   public int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1887298731
   )
   @Export("__f")
   public int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2001187823
   )
   @Export("__q")
   public int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1377856837
   )
   @Export("__w")
   public int __w;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.__m_487(var1, var2);
      this.__f_488(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   @Export("__m_487")
   public void __m_487(int var1, int var2) {
      this.__m = var1;
      this.__f = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-11269827"
   )
   @Export("__f_488")
   public void __f_488(int var1, int var2) {
      this.__q = var1;
      this.__w = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;I)V",
      garbageValue = "-2123792170"
   )
   @Export("__q_490")
   public void __q_490(Bounds var1, Bounds var2) {
      this.__w_491(var1, var2);
      this.__o_492(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;I)V",
      garbageValue = "314675149"
   )
   @Export("__w_491")
   void __w_491(Bounds var1, Bounds var2) {
      var2.__m = this.__m;
      var2.__q = this.__q;
      if(this.__m < var1.__m) {
         var2.__q -= var1.__m - this.__m;
         var2.__m = var1.__m;
      }

      if(var2.__u_493() > var1.__u_493()) {
         var2.__q -= var2.__u_493() - var1.__u_493();
      }

      if(var2.__q < 0) {
         var2.__q = 0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lla;Lla;S)V",
      garbageValue = "128"
   )
   @Export("__o_492")
   void __o_492(Bounds var1, Bounds var2) {
      var2.__f = this.__f;
      var2.__w = this.__w;
      if(this.__f < var1.__f) {
         var2.__w -= var1.__f - this.__f;
         var2.__f = var1.__f;
      }

      if(var2.__g_494() > var1.__g_494()) {
         var2.__w -= var2.__g_494() - var1.__g_494();
      }

      if(var2.__w < 0) {
         var2.__w = 0;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1842151293"
   )
   @Export("__u_493")
   int __u_493() {
      return this.__m + this.__q;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-22"
   )
   @Export("__g_494")
   int __g_494() {
      return this.__f + this.__w;
   }

   @Export("__toString_489")
   @ObfuscatedName("toString")
   public String __toString_489() {
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

      for(int var8 = 0; var7 <= var4; ++var8) {
         double var9 = ((double)var7 - var0) / var2;
         double var11 = Math.exp(-var9 * var9 / 2.0D) / Math.sqrt(6.283185307179586D);
         double var13 = var11 / var2;
         var6[var8] = var13;
         ++var7;
      }

      return var6;
   }
}

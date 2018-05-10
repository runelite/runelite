import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3137(0, -1, true, false, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3135(1, 0, true, true, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3145(2, 1, true, true, false),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3138(3, 2, false, false, true),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3139(4, 3, false, false, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   field3140(5, 10, false, false, true);

   @ObfuscatedName("mz")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   @Export("varcs")
   static Varcs varcs;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1916622673
   )
   final int field3141;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 788425041
   )
   public final int field3142;
   @ObfuscatedName("j")
   public final boolean field3143;
   @ObfuscatedName("a")
   public final boolean field3136;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3141 = var3;
      this.field3142 = var4;
      this.field3143 = var6;
      this.field3136 = var7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.field3141;
   }
}

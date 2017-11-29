import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   field3256(0, -1, true, false, true),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   field3250(1, 0, true, true, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   field3252(2, 1, true, true, false),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   field3253(3, 2, false, false, true),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   field3254(4, 3, false, false, true),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   field3255(5, 10, false, false, true);

   @ObfuscatedName("n")
   static int[] field3260;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1885294161
   )
   final int field3258;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -794377005
   )
   public final int field3251;
   @ObfuscatedName("p")
   public final boolean field3257;
   @ObfuscatedName("r")
   public final boolean field3259;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3258 = var3;
      this.field3251 = var4;
      this.field3257 = var6;
      this.field3259 = var7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field3258;
   }
}

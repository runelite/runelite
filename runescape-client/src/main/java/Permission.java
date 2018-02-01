import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("Permission")
public enum Permission implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3253(0, -1, true, false, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3248(1, 0, true, true, true),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3257(2, 1, true, true, false),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3250(3, 2, false, false, true),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3251(4, 3, false, false, true),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   field3252(5, 10, false, false, true);

   @ObfuscatedName("u")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1685434527
   )
   final int field3249;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -877669211
   )
   public final int field3254;
   @ObfuscatedName("m")
   public final boolean field3255;
   @ObfuscatedName("h")
   public final boolean field3256;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3249 = var3;
      this.field3254 = var4;
      this.field3255 = var6;
      this.field3256 = var7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field3249;
   }
}

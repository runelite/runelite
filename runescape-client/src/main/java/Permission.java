import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3341(0, -1, true, false, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3340(1, 0, true, true, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3344(2, 1, true, true, false),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3342(3, 2, false, false, true),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3343(4, 3, false, false, true),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   field3345(5, 10, false, false, true);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1059495589
   )
   final int field3347;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2111315543
   )
   public final int field3346;
   @ObfuscatedName("p")
   public final boolean field3339;
   @ObfuscatedName("g")
   public final boolean field3348;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3347 = var3;
      this.field3346 = var4;
      this.field3339 = var6;
      this.field3348 = var7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field3347;
   }
}

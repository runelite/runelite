import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   field3289(0, -1, true, false, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   field3287(1, 0, true, true, true),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   field3296(2, 1, true, true, false),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   field3288(3, 2, false, false, true),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   field3290(4, 3, false, false, true),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   field3291(5, 10, false, false, true);

   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1145196799
   )
   final int field3292;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1044674801
   )
   public final int field3293;
   @ObfuscatedName("g")
   public final boolean field3294;
   @ObfuscatedName("c")
   public final boolean field3295;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3292 = var3;
      this.field3293 = var4;
      this.field3294 = var6;
      this.field3295 = var7;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field3292;
   }
}

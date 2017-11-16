import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("Permission")
public enum Permission implements class185 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3237(0, -1, true, false, true),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3232(1, 0, true, true, true),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3240(2, 1, true, true, false),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3234(3, 2, false, false, true),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3235(4, 3, false, false, true),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Liq;"
   )
   field3233(5, 10, false, false, true);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static IndexedSprite field3241;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1472423169
   )
   final int field3236;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2058454407
   )
   public final int field3238;
   @ObfuscatedName("k")
   public final boolean field3231;
   @ObfuscatedName("n")
   public final boolean field3239;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3236 = var3;
      this.field3238 = var4;
      this.field3231 = var6;
      this.field3239 = var7;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int rsOrdinal() {
      return this.field3236;
   }
}

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3165(0, -1, true, false, true),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3164(1, 0, true, true, true),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3166(2, 1, true, true, false),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3168(3, 2, false, false, true),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3167(4, 3, false, false, true),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   field3169(5, 10, false, false, true);

   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -8344847
   )
   public final int field3170;
   @ObfuscatedName("w")
   public final boolean field3171;
   @ObfuscatedName("b")
   public final boolean field3172;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1082140659
   )
   final int field3173;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3173 = var3;
      this.field3170 = var4;
      this.field3171 = var6;
      this.field3172 = var7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field3173;
   }
}

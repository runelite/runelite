import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   field3180(0, -1, true, false, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   field3175(1, 0, true, true, true),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   field3178(2, 1, true, true, false),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   field3174(3, 2, false, false, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   field3176(4, 3, false, false, true),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   field3179(5, 10, false, false, true);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1755925237
   )
   final int field3177;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 379086131
   )
   public final int field3181;
   @ObfuscatedName("v")
   public final boolean field3182;
   @ObfuscatedName("t")
   public final boolean field3183;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3177 = var3;
      this.field3181 = var4;
      this.field3182 = var6;
      this.field3183 = var7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field3177;
   }
}

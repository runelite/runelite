import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3181(0, -1, true, false, true),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3175(1, 0, true, true, true),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3179(2, 1, true, true, false),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3177(3, 2, false, false, true),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3178(4, 3, false, false, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   field3174(5, 10, false, false, true);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1092083065
   )
   public final int field3176;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -246974849
   )
   final int field3180;
   @ObfuscatedName("k")
   public final boolean field3182;
   @ObfuscatedName("s")
   public final boolean field3183;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3180 = var3;
      this.field3176 = var4;
      this.field3182 = var6;
      this.field3183 = var7;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field3180;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "5"
   )
   static final String method4124(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}

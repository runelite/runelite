import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public enum class239 implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3232(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3227(3, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3231(2, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3229(1, 3),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3226(7, 4),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3228(4, 5),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3234(6, 6),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   field3233(5, 7);

   @ObfuscatedName("b")
   static int[] field3236;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1540416405
   )
   public final int field3230;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1624120231
   )
   final int field3235;

   class239(int var3, int var4) {
      this.field3230 = var3;
      this.field3235 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.field3235;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "-19"
   )
   public static int method4340(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class249.NetCache_pendingPriorityResponsesCount + class249.NetCache_pendingPriorityWritesCount;
      return var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "115"
   )
   @Export("getItemStackAmountText")
   static final String getItemStackAmountText(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}

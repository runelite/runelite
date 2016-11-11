import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class155 implements class115 {
   @ObfuscatedName("q")
   static int[] field2308;
   @ObfuscatedName("e")
   public static final class155 field2309 = new class155(2, 1, true, true, false);
   @ObfuscatedName("g")
   public static final class155 field2310 = new class155(3, 2, false, false, true);
   @ObfuscatedName("n")
   public static final class155 field2311 = new class155(4, 3, false, false, true);
   @ObfuscatedName("u")
   public static final class155 field2312 = new class155(5, 10, false, false, true);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -544860651
   )
   final int field2313;
   @ObfuscatedName("h")
   public static final class155 field2314 = new class155(1, 0, true, true, true);
   @ObfuscatedName("m")
   public final boolean field2315;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 636285045
   )
   public final int field2317;
   @ObfuscatedName("i")
   public static final class155 field2319 = new class155(0, -1, true, false, true);
   @ObfuscatedName("j")
   public final boolean field2320;

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2313 = var1;
      this.field2317 = var2;
      this.field2315 = var4;
      this.field2320 = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-134631871"
   )
   static char method3181(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-970198235"
   )
   public int vmethod3197() {
      return this.field2313;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class155 implements class115 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -11826305
   )
   public final int field2310;
   @ObfuscatedName("r")
   public static final class155 field2311 = new class155(1, 0, true, true, true);
   @ObfuscatedName("j")
   public static final class155 field2312 = new class155(2, 1, true, true, false);
   @ObfuscatedName("i")
   public static final class155 field2313 = new class155(4, 3, false, false, true);
   @ObfuscatedName("x")
   public static final class155 field2314 = new class155(0, -1, true, false, true);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 774965429
   )
   final int field2315;
   @ObfuscatedName("p")
   public final boolean field2316;
   @ObfuscatedName("m")
   public final boolean field2317;
   @ObfuscatedName("z")
   public static final class155 field2320 = new class155(3, 2, false, false, true);

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2315 = var1;
      this.field2310 = var2;
      this.field2317 = var4;
      this.field2316 = var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1074689381"
   )
   public int vmethod3206() {
      return this.field2315;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class152 implements class112 {
   @ObfuscatedName("k")
   public final boolean field2271;
   @ObfuscatedName("s")
   static final class152 field2272 = new class152(0, -1, true, false, true);
   @ObfuscatedName("p")
   static final class152 field2273 = new class152(2, 1, true, true, false);
   @ObfuscatedName("d")
   static final class152 field2275 = new class152(4, 3, false, false, true);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1243665561
   )
   final int field2276;
   @ObfuscatedName("j")
   static final class152 field2278 = new class152(1, 0, true, true, true);
   @ObfuscatedName("x")
   static final class152 field2279 = new class152(3, 2, false, false, true);
   @ObfuscatedName("b")
   public final boolean field2280;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1607333337
   )
   public final int field2283;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "693017402"
   )
   public int vmethod3150() {
      return this.field2276;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "0"
   )
   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2276 = var1;
      this.field2283 = var2;
      this.field2280 = var4;
      this.field2271 = var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)Ljava/lang/String;",
      garbageValue = "1551558452"
   )
   public static String method3131(class119 var0) {
      return class175.method3432(var0, 32767);
   }
}

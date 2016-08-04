import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class155 implements class115 {
   @ObfuscatedName("l")
   static final class155 field2322 = new class155(0, -1, true, false, true);
   @ObfuscatedName("g")
   static final class155 field2323 = new class155(1, 0, true, true, true);
   @ObfuscatedName("e")
   static final class155 field2324 = new class155(3, 2, false, false, true);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2097323823
   )
   public final int field2325;
   @ObfuscatedName("h")
   static final class155 field2326 = new class155(4, 3, false, false, true);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1684430931
   )
   final int field2327;
   @ObfuscatedName("r")
   static final class155 field2328 = new class155(2, 1, true, true, false);
   @ObfuscatedName("u")
   public final boolean field2329;
   @ObfuscatedName("n")
   public final boolean field2330;

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2327 = var1;
      this.field2325 = var2;
      this.field2329 = var4;
      this.field2330 = var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1633970528"
   )
   public int vmethod3316() {
      return this.field2327;
   }
}

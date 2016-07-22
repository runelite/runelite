import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class155 implements class115 {
   @ObfuscatedName("x")
   public final boolean field2319;
   @ObfuscatedName("e")
   static final class155 field2320 = new class155(2, 1, true, true, false);
   @ObfuscatedName("o")
   static final class155 field2321 = new class155(3, 2, false, false, true);
   @ObfuscatedName("g")
   static final class155 field2322 = new class155(4, 3, false, false, true);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 299217263
   )
   public final int field2323;
   @ObfuscatedName("m")
   static final class155 field2324 = new class155(0, -1, true, false, true);
   @ObfuscatedName("w")
   static final class155 field2325 = new class155(1, 0, true, true, true);
   @ObfuscatedName("r")
   public final boolean field2326;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -261474883
   )
   final int field2328;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1587180348"
   )
   public int vmethod3218() {
      return this.field2328;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2328 = var1;
      this.field2323 = var2;
      this.field2326 = var4;
      this.field2319 = var5;
   }
}

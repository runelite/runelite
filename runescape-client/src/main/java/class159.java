import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class159 implements class112 {
   @ObfuscatedName("j")
   public static final class159 field2607 = new class159(3, 1);
   @ObfuscatedName("p")
   public static final class159 field2608 = new class159(1, 2);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1479026497
   )
   public final int field2609;
   @ObfuscatedName("s")
   public static final class159 field2610 = new class159(0, 0);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 696913241
   )
   final int field2611;
   @ObfuscatedName("me")
   @Export("clanMembers")
   static class24[] field2612;
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = -1108436255
   )
   static int field2613;
   @ObfuscatedName("x")
   public static final class159 field2614 = new class159(2, 3);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class159(int var1, int var2) {
      this.field2609 = var1;
      this.field2611 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "693017402"
   )
   public int vmethod3150() {
      return this.field2611;
   }
}

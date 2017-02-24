import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class40 implements class158 {
   @ObfuscatedName("df")
   static byte[][] field828;
   @ObfuscatedName("d")
   static final class40 field829 = new class40(1);
   @ObfuscatedName("h")
   static final class40 field830 = new class40(2);
   @ObfuscatedName("q")
   static final class40 field831 = new class40(0);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -776526267
   )
   final int field832;
   @ObfuscatedName("ax")
   static class184 field833;
   @ObfuscatedName("da")
   static int[] field835;
   @ObfuscatedName("p")
   static final class40 field836 = new class40(3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lclass179;",
      garbageValue = "1282679689"
   )
   public static class179[] method825() {
      return new class179[]{class179.field2691, class179.field2690, class179.field2685, class179.field2686, class179.field2693, class179.field2687};
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "555633042"
   )
   public int vmethod4101() {
      return this.field832;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field832 = var1;
   }
}

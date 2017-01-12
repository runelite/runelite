import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class221 implements class158 {
   @ObfuscatedName("x")
   public static final class221 field3182 = new class221(1, 1);
   @ObfuscatedName("i")
   public static final class221 field3183 = new class221(2, 2);
   @ObfuscatedName("u")
   public static final class221 field3184 = new class221(0, 0);
   @ObfuscatedName("f")
   public static final class221 field3185 = new class221(4, 4);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 395988699
   )
   public final int field3186;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 630479207
   )
   final int field3187;
   @ObfuscatedName("a")
   public static final class221 field3188 = new class221(3, 3);
   @ObfuscatedName("v")
   static int[][][] field3189;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod4062() {
      return this.field3187;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3186 = var1;
      this.field3187 = var2;
   }
}

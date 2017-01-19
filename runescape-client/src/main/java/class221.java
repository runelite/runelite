import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class221 implements class158 {
   @ObfuscatedName("s")
   public static final class221 field3187 = new class221(0, 0);
   @ObfuscatedName("c")
   public static final class221 field3188 = new class221(1, 1);
   @ObfuscatedName("h")
   public static final class221 field3189 = new class221(3, 3);
   @ObfuscatedName("f")
   public static final class221 field3190 = new class221(2, 2);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 258050245
   )
   public final int field3191;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 296294499
   )
   final int field3192;
   @ObfuscatedName("v")
   static int[] field3193;
   @ObfuscatedName("a")
   public static final class221 field3194 = new class221(4, 4);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "17064"
   )
   public int vmethod3916() {
      return this.field3192;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3191 = var1;
      this.field3192 = var2;
   }
}

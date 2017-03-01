import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class221 implements class158 {
   @ObfuscatedName("n")
   static final class221 field3202 = new class221(1, 1);
   @ObfuscatedName("g")
   static final class221 field3203 = new class221(2, 2);
   @ObfuscatedName("x")
   public static final class221 field3204 = new class221(0, 0);
   @ObfuscatedName("v")
   static final class221 field3205 = new class221(3, 3);
   @ObfuscatedName("y")
   static final class221 field3206 = new class221(4, 4);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1371168957
   )
   public final int field3207;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1174523285
   )
   final int field3208;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-112"
   )
   public int vmethod4107() {
      return this.field3208;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3207 = var1;
      this.field3208 = var2;
   }
}

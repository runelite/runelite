import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class221 implements class158 {
   @ObfuscatedName("l")
   static final class221 field3194 = new class221(1, 1);
   @ObfuscatedName("i")
   static final class221 field3195 = new class221(2, 2);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -965124657
   )
   public final int field3196;
   @ObfuscatedName("t")
   static final class221 field3197 = new class221(3, 3);
   @ObfuscatedName("k")
   static final class221 field3198 = new class221(4, 4);
   @ObfuscatedName("b")
   public static final class221 field3199 = new class221(0, 0);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1728911575
   )
   final int field3200;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3196 = var1;
      this.field3200 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int vmethod4183() {
      return this.field3200;
   }
}

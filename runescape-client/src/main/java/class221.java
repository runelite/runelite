import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class221 implements class158 {
   @ObfuscatedName("b")
   public static final class221 field3182 = new class221(2, 2);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1544090029
   )
   final int field3183;
   @ObfuscatedName("m")
   public static final class221 field3184 = new class221(1, 1);
   @ObfuscatedName("g")
   public static final class221 field3185 = new class221(3, 3);
   @ObfuscatedName("h")
   public static final class221 field3186 = new class221(4, 4);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1737539175
   )
   public final int field3187;
   @ObfuscatedName("o")
   public static final class221 field3188 = new class221(0, 0);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3187 = var1;
      this.field3183 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   public int vmethod3989() {
      return this.field3183;
   }
}

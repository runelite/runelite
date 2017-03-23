import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class221 implements class158 {
   @ObfuscatedName("i")
   public static final class221 field3200 = new class221(1, 1);
   @ObfuscatedName("f")
   public static final class221 field3201 = new class221(0, 0);
   @ObfuscatedName("u")
   public static final class221 field3202 = new class221(2, 2);
   @ObfuscatedName("h")
   public static final class221 field3203 = new class221(3, 3);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -159628891
   )
   final int field3204;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 731441967
   )
   public final int field3205;
   @ObfuscatedName("r")
   public static final class221 field3206 = new class221(4, 4);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3205 = var1;
      this.field3204 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1935391427"
   )
   public int vmethod4085() {
      return this.field3204;
   }
}

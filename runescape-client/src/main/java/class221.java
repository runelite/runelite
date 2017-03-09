import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class221 implements class158 {
   @ObfuscatedName("j")
   public static final class221 field3199 = new class221(1, 1);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1351679265
   )
   final int field3200;
   @ObfuscatedName("c")
   public static final class221 field3201 = new class221(2, 2);
   @ObfuscatedName("d")
   public static final class221 field3202 = new class221(3, 3);
   @ObfuscatedName("w")
   public static final class221 field3203 = new class221(4, 4);
   @ObfuscatedName("x")
   public static final class221 field3204 = new class221(0, 0);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1751089783
   )
   public final int field3205;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class221(int var1, int var2) {
      this.field3205 = var1;
      this.field3200 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public int vmethod4085() {
      return this.field3200;
   }
}

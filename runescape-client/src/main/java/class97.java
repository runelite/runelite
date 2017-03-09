import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class97 implements class158 {
   @ObfuscatedName("x")
   public static final class97 field1638 = new class97(0, 0);
   @ObfuscatedName("j")
   public static final class97 field1639 = new class97(2, 1);
   @ObfuscatedName("c")
   public static final class97 field1640 = new class97(3, 2);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -410720621
   )
   final int field1641;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1525185673
   )
   public final int field1642;
   @ObfuscatedName("qc")
   protected static java.awt.Font field1643;
   @ObfuscatedName("d")
   public static final class97 field1645 = new class97(1, 3);
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = 848463695
   )
   static int field1646;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public int vmethod4085() {
      return this.field1641;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1642 = var1;
      this.field1641 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-2146932151"
   )
   public static void method1988(class182 var0, class182 var1, class182 var2) {
      Sequence.field3064 = var0;
      Sequence.field3054 = var1;
      Sequence.field3053 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2071390533"
   )
   public static boolean method1989(int var0, int var1) {
      return (var0 >> 1 + var1 & 1) != 0;
   }
}

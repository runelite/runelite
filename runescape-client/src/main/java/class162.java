import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class162 implements class115 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 520818039
   )
   final int field2644;
   @ObfuscatedName("l")
   public static final class162 field2645 = new class162(2, 1);
   @ObfuscatedName("e")
   public static final class162 field2646 = new class162(1, 0);
   @ObfuscatedName("h")
   public static final class162 field2647 = new class162(0, 3);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 747760173
   )
   public final int field2648;
   @ObfuscatedName("c")
   public static final class162 field2649 = new class162(3, 2);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2010364784"
   )
   public int vmethod3262() {
      return this.field2644;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2648 = var1;
      this.field2644 = var2;
   }
}

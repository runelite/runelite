import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class162 implements class115 {
   @ObfuscatedName("m")
   static ModIcon field2660;
   @ObfuscatedName("r")
   public static final class162 field2661 = new class162(0, 1);
   @ObfuscatedName("j")
   public static final class162 field2662 = new class162(1, 2);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 876652037
   )
   public final int field2664;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1745380421
   )
   final int field2665;
   @ObfuscatedName("x")
   public static final class162 field2667 = new class162(2, 0);
   @ObfuscatedName("z")
   public static final class162 field2669 = new class162(3, 3);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2664 = var1;
      this.field2665 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1074689381"
   )
   public int vmethod3206() {
      return this.field2665;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "35"
   )
   public static boolean method3210(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}

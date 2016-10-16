import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class162 implements class115 {
   @ObfuscatedName("t")
   public static final class162 field2643 = new class162(0, 2);
   @ObfuscatedName("z")
   public static final class162 field2644 = new class162(1, 1);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1689236557
   )
   public final int field2647;
   @ObfuscatedName("s")
   public static final class162 field2648 = new class162(3, 0);
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 780235545
   )
   public static int field2650;
   @ObfuscatedName("y")
   public static final class162 field2651 = new class162(2, 3);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1476822293
   )
   final int field2652;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int vmethod3162() {
      return this.field2652;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)Ljava/lang/String;",
      garbageValue = "-24"
   )
   public static String method3165(Buffer var0) {
      return class54.method1063(var0, 32767);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2647 = var1;
      this.field2652 = var2;
   }
}

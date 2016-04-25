import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class82 implements class112 {
   @ObfuscatedName("j")
   public static final class82 field1410 = new class82(0, 0);
   @ObfuscatedName("h")
   public static final class82 field1411 = new class82(1, 1);
   @ObfuscatedName("s")
   static int[] field1412;
   @ObfuscatedName("x")
   public static final class82 field1414 = new class82(4, 4);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -644121743
   )
   public final int field1415;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 451856081
   )
   final int field1416;
   @ObfuscatedName("z")
   public static final class82 field1420 = new class82(3, 3);
   @ObfuscatedName("m")
   public static final class82 field1422 = new class82(2, 2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "1205637778"
   )
   public static boolean method1878(CharSequence var0) {
      return class10.method134(var0, 10, true);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class82(int var1, int var2) {
      this.field1415 = var1;
      this.field1416 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "23"
   )
   public int vmethod3136() {
      return this.field1416;
   }
}

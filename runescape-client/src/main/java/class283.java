import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public class class283 implements class178 {
   @ObfuscatedName("w")
   public static String field3762;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1351289893
   )
   final int field3763;
   @ObfuscatedName("e")
   static final class283 field3764;
   @ObfuscatedName("v")
   static final class283 field3765;
   @ObfuscatedName("b")
   static final class283 field3766;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 904475707
   )
   public final int field3767;
   @ObfuscatedName("i")
   public static final class283 field3768;
   @ObfuscatedName("c")
   static final class283 field3769;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field3763;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class283(int var1, int var2) {
      this.field3767 = var1;
      this.field3763 = var2;
   }

   static {
      field3768 = new class283(0, 0);
      field3769 = new class283(1, 1);
      field3764 = new class283(2, 2);
      field3765 = new class283(3, 3);
      field3766 = new class283(4, 4);
   }
}

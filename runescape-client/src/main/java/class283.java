import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
public class class283 implements class178 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -942280749
   )
   public final int field3763;
   @ObfuscatedName("p")
   static final class283 field3764;
   @ObfuscatedName("i")
   static final class283 field3765;
   @ObfuscatedName("j")
   static final class283 field3766;
   @ObfuscatedName("f")
   static final class283 field3767;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2017666627
   )
   final int field3768;
   @ObfuscatedName("n")
   public static final class283 field3769;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class283(int var1, int var2) {
      this.field3763 = var1;
      this.field3768 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field3768;
   }

   static {
      field3769 = new class283(0, 0);
      field3764 = new class283(1, 1);
      field3765 = new class283(2, 2);
      field3766 = new class283(3, 3);
      field3767 = new class283(4, 4);
   }
}

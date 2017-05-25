import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class class283 implements class178 {
   @ObfuscatedName("h")
   static final class283 field3756;
   @ObfuscatedName("u")
   static final class283 field3757;
   @ObfuscatedName("i")
   public static final class283 field3758;
   @ObfuscatedName("q")
   static final class283 field3759;
   @ObfuscatedName("g")
   static final class283 field3760;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 433350169
   )
   public final int field3761;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2140040899
   )
   final int field3762;

   static {
      field3758 = new class283(0, 0);
      field3756 = new class283(1, 1);
      field3757 = new class283(2, 2);
      field3759 = new class283(3, 3);
      field3760 = new class283(4, 4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field3762;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class283(int var1, int var2) {
      this.field3761 = var1;
      this.field3762 = var2;
   }
}

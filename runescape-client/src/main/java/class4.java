import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class4 implements class178 {
   @ObfuscatedName("p")
   static final class4 field29;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -846400859
   )
   final int field30;
   @ObfuscatedName("n")
   static final class4 field32;
   @ObfuscatedName("i")
   static final class4 field34;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1088816143
   )
   final int field37;
   @ObfuscatedName("bv")
   static ModIcon[] field38;

   static {
      field32 = new class4(0, 0, Integer.class, new class2());
      field29 = new class4(2, 1, Long.class, new class3());
      field34 = new class4(1, 2, String.class, new class5());
   }

   class4(int var1, int var2, Class var3, class0 var4) {
      this.field30 = var1;
      this.field37 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field37;
   }
}

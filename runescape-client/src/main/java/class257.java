import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class257 implements class178 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1272872137
   )
   final int field3551;
   @ObfuscatedName("i")
   static final class257 field3552;
   @ObfuscatedName("n")
   static final class257 field3553;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -83920671
   )
   public final int field3554;
   @ObfuscatedName("p")
   static final class257 field3555;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field3551;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class257(int var1, int var2) {
      this.field3554 = var1;
      this.field3551 = var2;
   }

   static {
      field3553 = new class257(2, 0);
      field3555 = new class257(1, 1);
      field3552 = new class257(0, 2);
   }
}

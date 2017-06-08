import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class239 implements class178 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1532694261
   )
   public final int field3273;
   @ObfuscatedName("p")
   static final class239 field3274;
   @ObfuscatedName("i")
   static final class239 field3275;
   @ObfuscatedName("n")
   static final class239 field3276;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2084459583
   )
   final int field3277;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class239(int var1, int var2) {
      this.field3273 = var1;
      this.field3277 = var2;
   }

   static {
      field3276 = new class239(2, 0);
      field3274 = new class239(1, 1);
      field3275 = new class239(0, 2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field3277;
   }
}

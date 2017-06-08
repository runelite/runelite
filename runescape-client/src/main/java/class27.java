import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class27 implements class178 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1970305373
   )
   final int field400;
   @ObfuscatedName("n")
   static final class27 field401;
   @ObfuscatedName("i")
   static final class27 field402;
   @ObfuscatedName("j")
   static final class27 field403;
   @ObfuscatedName("ho")
   @ObfuscatedGetter(
      intValue = 1544822737
   )
   static int field404;
   @ObfuscatedName("p")
   static final class27 field405;
   @ObfuscatedName("m")
   final byte field408;

   static {
      field401 = new class27(1, (byte)0);
      field405 = new class27(3, (byte)1);
      field402 = new class27(2, (byte)2);
      field403 = new class27(0, (byte)3);
   }

   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   class27(int var1, byte var2) {
      this.field400 = var1;
      this.field408 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field408;
   }
}

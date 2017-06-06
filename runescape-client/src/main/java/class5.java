import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class5 implements class0 {
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "-1926439610"
   )
   public static final void method10(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class109.field1640 = var0;
         class275.field3732 = var1;
         WorldMapType2.field522 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-419253606"
   )
   public static int method11(String var0) {
      return var0.length() + 1;
   }
}

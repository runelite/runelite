import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public class class253 {
   @ObfuscatedName("a")
   static int[] field3314;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1818747089"
   )
   public static int method4507(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[Lio;",
      garbageValue = "-115"
   )
   public static JagexGame[] method4506() {
      return new JagexGame[]{JagexGame.field3364, JagexGame.field3360, JagexGame.field3361, JagexGame.field3363, JagexGame.field3362, JagexGame.field3366};
   }
}

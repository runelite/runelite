import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class203 {
   @ObfuscatedName("x")
   static final char[] field3080 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 864835879
   )
   static int field3083;
   @ObfuscatedName("w")
   static int[] field3085;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "27"
   )
   static final int method3806(int var0, int var1) {
      int var2 = class6.method89(var0 + '넵', var1 + 91923, 4) - 128 + (class6.method89(var0 + 10294, '鎽' + var1, 2) - 128 >> 1) + (class6.method89(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   class203() throws Throwable {
      throw new Error();
   }
}

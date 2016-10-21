import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class168 {
   @ObfuscatedName("f")
   public static final char[] field2698 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("c")
   static ModIcon[] field2699;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "292130674"
   )
   public static class115 method3262(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3196()) {
            return var4;
         }
      }

      return null;
   }
}

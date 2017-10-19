import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class266 {
   @ObfuscatedName("w")
   public static final char[] field3666;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lco;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -124268171
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   static {
      field3666 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1807517717"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class28.method246(var0.charAt(var3));
      }

      return var2;
   }
}

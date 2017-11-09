import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class273 {
   @ObfuscatedName("m")
   public static final char[] field3719;

   static {
      field3719 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)Ljt;",
      garbageValue = "557273139"
   )
   static Font method5019(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class295.field3853, class37.offsetsY, ItemContainer.field745, class31.field428, class295.field3852, class295.spritePixels);
         class276.method5044();
         return var1;
      }
   }
}

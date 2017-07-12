import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
public class class266 {
   @ObfuscatedName("i")
   public static final char[] field3668;
   @ObfuscatedName("s")
   static ModIcon[] field3669;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 612429295
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1367725793"
   )
   static void method4842(int var0) {
      if(var0 == -1 && !Client.field1014) {
         class203.field2509.method3740();
         class203.field2508 = 1;
         class61.field785 = null;
      } else if(var0 != -1 && var0 != Client.field1163 && Client.field1162 != 0 && !Client.field1014) {
         class82.method1628(2, class44.indexTrack1, var0, 0, Client.field1162, false);
      }

      Client.field1163 = var0;
   }

   static {
      field3668 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class277 {
   @ObfuscatedName("n")
   @Export("cp1252AsciiExtension")
   public static final char[] cp1252AsciiExtension;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field3744;

   static {
      cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-275978850"
   )
   public static void method5058() {
      class293.classInfos = new CombatInfoList();
   }
}

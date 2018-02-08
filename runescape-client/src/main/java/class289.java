import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
public class class289 {
   @ObfuscatedName("s")
   @Export("cp1252AsciiExtension")
   public static final char[] cp1252AsciiExtension;
   @ObfuscatedName("d")
   public static int[] field3786;

   static {
      cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1662877639"
   )
   static final void method5468() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            ChatLineBuffer.method2040(var2, var2.composition.field3633);
         }
      }

   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1693516827"
   )
   static final void method5459() {
      Client.field1017 = Client.cycleCntr;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
public class class289 {
   @ObfuscatedName("p")
   @Export("cp1252AsciiExtension")
   public static final char[] cp1252AsciiExtension;

   static {
      cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "125"
   )
   static int method5300(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class19.currentRequest != null && var2 == class19.currentRequest.hash?class94.NetCache_responseArchiveBuffer.offset * 99 / (class94.NetCache_responseArchiveBuffer.payload.length - class19.currentRequest.padding) + 1:0;
   }
}

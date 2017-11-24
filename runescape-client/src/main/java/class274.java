import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class274 {
   @ObfuscatedName("k")
   static final char[] field3731;
   @ObfuscatedName("z")
   static final char[] field3728;

   static {
      field3731 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      field3728 = new char[]{'[', ']', '#'};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-935074298"
   )
   public static String method5048(byte[] var0) {
      return VertexNormal.method2711(var0, 0, var0.length);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "907384295"
   )
   static final int method5045(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}

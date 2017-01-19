import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class204 {
   @ObfuscatedName("h")
   static final char[] field3083 = new char[]{'[', ']', '#'};
   @ObfuscatedName("f")
   static final char[] field3084 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-560743627"
   )
   static void method3671(Widget var0) {
      if(var0.field2287 == Client.field496) {
         Client.field497[var0.boundsIndex] = true;
      }

   }
}

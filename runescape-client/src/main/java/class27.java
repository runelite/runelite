import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public enum class27 implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field371(1, (byte)0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field365(0, (byte)1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field364(3, (byte)2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   field367(2, (byte)3);

   @ObfuscatedName("n")
   static int[] field370;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1778575985
   )
   final int field368;
   @ObfuscatedName("h")
   final byte field369;

   class27(int var3, byte var4) {
      this.field368 = var3;
      this.field369 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field369;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "416947839"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-45"
   )
   public static char method240(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgq;I)V",
      garbageValue = "2003755369"
   )
   public static void method238(Huffman var0) {
      class299.huffman = var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)[Lao;",
      garbageValue = "5004"
   )
   static class27[] method234() {
      return new class27[]{field364, field365, field371, field367};
   }
}

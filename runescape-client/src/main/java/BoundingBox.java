import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("BoundingBox")
public abstract class BoundingBox extends Node {
   @ObfuscatedName("ot")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("d")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("fonts")
   static Fonts fonts;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1287124829"
   )
   @Export("draw")
   abstract void draw();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "7"
   )
   public static char method47(char var0) {
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

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1007746728"
   )
   static int method40() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1321677653"
   )
   public static boolean method46() {
      return Client.rights >= 2;
   }
}

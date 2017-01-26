import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class97 implements class158 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -917972359
   )
   final int field1628;
   @ObfuscatedName("g")
   public static final class97 field1629 = new class97(3, 1);
   @ObfuscatedName("x")
   public static final class97 field1630 = new class97(2, 2);
   @ObfuscatedName("q")
   public static final class97 field1631 = new class97(0, 3);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1826188799
   )
   public final int field1632;
   @ObfuscatedName("p")
   public static final class97 field1633 = new class97(1, 0);
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -947627793
   )
   protected static int field1637;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1632 = var1;
      this.field1628 = var2;
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1704470135"
   )
   static boolean method1917(Widget var0) {
      if(Client.field505) {
         if(class36.method724(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "2105304009"
   )
   static char method1918(char var0) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "9241"
   )
   public int vmethod4074() {
      return this.field1628;
   }
}

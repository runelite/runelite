import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class101 extends RuntimeException {
   @ObfuscatedName("ri")
   protected static boolean field1661;
   @ObfuscatedName("j")
   public static String field1662;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 129274935
   )
   static int field1663;
   @ObfuscatedName("w")
   Throwable field1665;
   @ObfuscatedName("x")
   static Applet field1666;
   @ObfuscatedName("d")
   String field1667;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "89"
   )
   static char method2015(char var0) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1075903388"
   )
   static void method2017(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2403(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BB)LFont;",
      garbageValue = "125"
   )
   static Font method2018(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, XItemContainer.field147, class203.field3085, class225.field3233, class225.field3231, class225.field3237, RSCanvas.field1766);
         XItemContainer.field147 = null;
         class203.field3085 = null;
         class225.field3233 = null;
         class225.field3231 = null;
         class225.field3237 = null;
         RSCanvas.field1766 = null;
         return var1;
      }
   }
}

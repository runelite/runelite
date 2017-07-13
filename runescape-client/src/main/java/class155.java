import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class155 {
   @ObfuscatedName("u")
   public static CacheFile field2239;
   @ObfuscatedName("v")
   public static File field2243;
   @ObfuscatedName("g")
   public static CacheFile field2237;
   @ObfuscatedName("k")
   public static CacheFile field2246;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 726040489
   )
   public static int field2241;
   @ObfuscatedName("t")
   public static CacheFile[] field2247;
   @ObfuscatedName("i")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("r")
   public static File field2244;

   static {
      field2239 = null;
      field2237 = null;
      field2246 = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-495080869"
   )
   static String method2955(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-56"
   )
   static char method2959(char var0) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "256"
   )
   public static final void method2961(int var0, int var1) {
      class134.field1991 = var0;
      class134.field1996 = var1;
      class134.field1999 = true;
      class134.field1995 = 0;
      class134.field1990 = false;
   }
}

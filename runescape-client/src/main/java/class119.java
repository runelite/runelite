import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public abstract class class119 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1438703511
   )
   public int field1854;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -351690363
   )
   public int field1856;
   @ObfuscatedName("t")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1852064017
   )
   public int field1859;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -680239399
   )
   public int field1862;

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1944916373"
   )
   static void method2293() {
      Client.menuOptionCount = 0;
      Client.field431 = -1;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-899017539"
   )
   public abstract boolean vmethod2294(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass199;",
      garbageValue = "-909193892"
   )
   public static class199 method2297(int var0) {
      class199 var1 = (class199)class199.field2878.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class199.field2883.getConfigData(34, var0);
         var1 = new class199();
         if(var2 != null) {
            var1.method3602(new Buffer(var2));
         }

         var1.method3601();
         class199.field2878.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-230269610"
   )
   static char method2298(char var0) {
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
}

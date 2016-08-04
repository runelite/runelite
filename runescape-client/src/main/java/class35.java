import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class35 {
   @ObfuscatedName("l")
   static final class35 field796 = new class35();
   @ObfuscatedName("r")
   static final class35 field797 = new class35();
   @ObfuscatedName("e")
   static final class35 field798 = new class35();
   @ObfuscatedName("g")
   static final class35 field800 = new class35();

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1086130213"
   )
   static final void method756(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class127.method2936(var0, var1, class99.field1701) - var2;
         var0 -= class151.field2282;
         var3 -= class8.field149;
         var1 -= class96.field1670;
         int var4 = class94.field1661[class102.field1759];
         int var5 = class94.field1662[class102.field1759];
         int var6 = class94.field1661[class59.field1255];
         int var7 = class94.field1662[class59.field1255];
         int var8 = var7 * var0 + var6 * var1 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var1 * var4 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            client.field401 = client.field558 / 2 + client.field392 * var0 / var1;
            client.field402 = client.field392 * var8 / var1 + client.field559 / 2;
         } else {
            client.field401 = -1;
            client.field402 = -1;
         }

      } else {
         client.field401 = -1;
         client.field402 = -1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "-96"
   )
   public static void method757(class170 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3410(var1);
      int var6 = var0.method3459(var5, var2);
      class180.method3615(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-101"
   )
   public static boolean method758(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}

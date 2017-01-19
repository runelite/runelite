import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class118 {
   @ObfuscatedName("f")
   static int[][] field1844 = new int[128][128];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 222086771
   )
   static int field1845;
   @ObfuscatedName("h")
   static int[][] field1846 = new int[128][128];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1800984357
   )
   static int field1847;
   @ObfuscatedName("c")
   public static class182 field1848;
   @ObfuscatedName("u")
   static int[] field1849 = new int[4096];
   @ObfuscatedName("b")
   static int[] field1850 = new int[4096];
   @ObfuscatedName("gy")
   @ObfuscatedGetter(
      intValue = 433391421
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("qo")
   protected static java.awt.Frame field1855;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-894303898"
   )
   public static String method2215(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class15.method155(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}

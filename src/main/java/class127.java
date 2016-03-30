import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
public class class127 {
   @ObfuscatedName("ra")
   protected static String field2054;

   @ObfuscatedName("s")
   public static void method2825() {
      class40.field928.method3776();
      class40.field929.method3776();
      class40.field930.method3776();
      class40.field939.method3776();
   }

   @ObfuscatedName("w")
   public static class153[] method2828() {
      return new class153[]{class153.field2298, class153.field2300, class153.field2301, class153.field2306};
   }

   @ObfuscatedName("y")
   public static int method2829(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class93.method2158(var0.charAt(var3));
      }

      return var2;
   }
}

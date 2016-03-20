import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class188 {
   @ObfuscatedName("id")
   static class172 field3039;
   @ObfuscatedName("bd")
   static class167 field3040;

   @ObfuscatedName("j")
   public static String method3784(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(0 == var3) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class92.method2179(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}

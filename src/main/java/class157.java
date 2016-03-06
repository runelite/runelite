import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fj")
public class class157 {
   @ObfuscatedName("bl")
   static class167 field2595;

   @ObfuscatedName("j")
   public static int method3119(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("y")
   public static void method3120() {
      class172.field2827.method3720();
      class172.field2754.method3720();
      class172.field2779.method3720();
      class172.field2784.method3720();
   }
}

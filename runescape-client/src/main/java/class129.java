import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class129 {
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = 1671498257
   )
   static int field2094;
   @ObfuscatedName("bx")
   static class171 field2097;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "2"
   )
   public static int method2868(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class122.field2046[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "407408978"
   )
   public static void method2869(class122 var0) {
      byte[] var1 = new byte[24];

      try {
         class152.field2295.method4227(0L);
         class152.field2295.method4240(var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
            ;
         }

         if(var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var5) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      var0.method2742(var1, 0, 24);
   }
}

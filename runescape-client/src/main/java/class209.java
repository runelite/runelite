import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public final class class209 {
   @ObfuscatedName("ez")
   static class80[] field3126;
   @ObfuscatedName("u")
   public static class224 field3128;

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-63"
   )
   static void method3890(int var0) {
      for(class201 var1 = (class201)client.field475.method3745(); null != var1; var1 = (class201)client.field475.method3746()) {
         if((var1.field3122 >> 48 & 65535L) == (long)var0) {
            var1.method3883();
         }
      }

   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
public class class114 {
   @ObfuscatedName("f")
   static byte[][][] field1972;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 6707467818990419891L
   )
   static long field1973;
   @ObfuscatedName("r")
   static int[] field1974;

   @ObfuscatedName("j")
   public static class44 method2399(int var0) {
      class44 var1 = (class44)class44.field1026.method3711((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class44.field1030.method3214(3, var0);
         var1 = new class44();
         if(var2 != null) {
            var1.method926(new class118(var2));
         }

         class44.field1026.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cf")
   static void method2400(class172 var0) {
      if(client.field492 == var0.field2889 * -1) {
         client.field493[var0.field2888] = true;
      }

   }
}

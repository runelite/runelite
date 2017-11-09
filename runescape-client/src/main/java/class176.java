import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class176 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;I)V",
      garbageValue = "736302090"
   )
   public static void method3252(IndexDataBase var0, IndexDataBase var1) {
      class18.field312 = var0;
      Spotanim.field3390 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lio;",
      garbageValue = "-1446689128"
   )
   public static class251 method3251(int var0) {
      class251 var1 = (class251)class251.field3375.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3376.getConfigData(15, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4507(new Buffer(var2));
         }

         class251.field3375.put(var1, (long)var0);
         return var1;
      }
   }
}

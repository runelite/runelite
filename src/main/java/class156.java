import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fg")
public class class156 {
   @ObfuscatedName("y")
   public static void method3175() {
      try {
         class148.field2225.method4172();

         for(int var0 = 0; var0 < class95.field1619; ++var0) {
            class228.field3221[var0].method4172();
         }

         class148.field2221.method4172();
         class148.field2223.method4172();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("a")
   public static class40 method3176(int var0) {
      class40 var1 = (class40)class40.field945.method3792((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class40.field965.method3263(6, var0);
         var1 = new class40();
         var1.field930 = var0;
         if(null != var2) {
            var1.method808(new class118(var2));
         }

         var1.method829();
         if(var1.field962) {
            var1.field925 = 0;
            var1.field941 = false;
         }

         class40.field945.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   public static void method3177() {
      class46.field1058.method3800();
   }
}

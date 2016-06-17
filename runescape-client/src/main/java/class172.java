import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class172 extends class204 {
   @ObfuscatedName("ia")
   static class173 field2732;
   @ObfuscatedName("b")
   class168 field2733;
   @ObfuscatedName("j")
   byte field2734;
   @ObfuscatedName("bl")
   static class168 field2735;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1426165551
   )
   int field2736;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2146240875"
   )
   static void method3398() {
      class5.field70 = 99;
      class5.field71 = new byte[4][104][104];
      class5.field72 = new byte[4][104][104];
      class5.field73 = new byte[4][104][104];
      class49.field1067 = new byte[4][104][104];
      class149.field2225 = new int[4][105][105];
      class5.field91 = new byte[4][105][105];
      class41.field957 = new int[105][105];
      class9.field144 = new int[104];
      class14.field212 = new int[104];
      class41.field954 = new int[104];
      class76.field1356 = new int[104];
      class10.field161 = new int[104];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass40;",
      garbageValue = "1672084312"
   )
   @Export("getObjectDefinition")
   public static class40 method3399(int var0) {
      class40 var1 = (class40)class40.field902.method3764((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class40.field900.method3266(6, var0);
         var1 = new class40();
         var1.field907 = var0;
         if(var2 != null) {
            var1.method842(new class119(var2));
         }

         var1.method806();
         if(var1.field939) {
            var1.field917 = 0;
            var1.field918 = false;
         }

         class40.field902.method3759(var1, (long)var0);
         return var1;
      }
   }
}

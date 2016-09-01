import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class54 extends CacheableNode {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1498376699
   )
   public static int field1142;
   @ObfuscatedName("r")
   static NodeCache field1143 = new NodeCache(64);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1990892293
   )
   public int field1144 = 0;
   @ObfuscatedName("bb")
   static class171 field1145;
   @ObfuscatedName("x")
   public static class170 field1150;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "103"
   )
   void method1088(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1144 = var1.method2551();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2011118922"
   )
   void method1089(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1088(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass69;B)V",
      garbageValue = "-96"
   )
   static final void method1094(class69 var0) {
      var0.field1308 = false;
      if(var0.field1309 != null) {
         var0.field1309.field1306 = 0;
      }

      for(class69 var1 = var0.vmethod3753(); null != var1; var1 = var0.vmethod3746()) {
         method1094(var1);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lclass133;",
      garbageValue = "-1347907887"
   )
   static class133[] method1095() {
      return new class133[]{class133.field2106, class133.field2108, class133.field2110};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2085526810"
   )
   static final byte[] method1096(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method2556();
      int var3 = var1.method2561();
      if(var3 >= 0 && (class170.field2745 == 0 || var3 <= class170.field2745)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2567(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2561();
            if(var4 >= 0 && (class170.field2745 == 0 || var4 <= class170.field2745)) {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class120.method2511(var5, var4, var0, var3, 9);
               } else {
                  class170.field2741.method2504(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1227826072"
   )
   static void method1097() {
      Object var0 = class173.field2770;
      synchronized(class173.field2770) {
         if(class173.field2771 == 0) {
            class127.field2086.method2927(new class173(), 5);
         }

         class173.field2771 = 600;
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public final class class150 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "763314679"
   )
   static boolean method3240(int var0, int var1) {
      return 4 != var0 || var1 < 8;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "2132342709"
   )
   static final void method3241(class173 var0, int var1, int var2) {
      if(client.field530 == 0 || client.field530 == 3) {
         if(1 == class140.field2157 || !class7.field143 && 4 == class140.field2157) {
            class175 var3 = var0.method3487(true);
            if(var3 == null) {
               return;
            }

            int var4 = class140.field2160 - var1;
            int var5 = class140.field2159 - var2;
            if(var3.method3524(var4, var5)) {
               var4 -= var3.field2901 / 2;
               var5 -= var3.field2900 / 2;
               int var6 = client.field443 + client.field379 & 2047;
               int var7 = class91.field1593[var6];
               int var8 = class91.field1594[var6];
               var7 = (256 + client.field368) * var7 >> 8;
               var8 = var8 * (client.field368 + 256) >> 8;
               int var9 = var7 * var5 + var8 * var4 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = class5.field93.field844 + var9 >> 7;
               int var12 = class5.field93.field819 - var10 >> 7;
               client.field338.method2873(225);
               client.field338.method2603(18);
               client.field338.method2603(class137.field2115[82]?(class137.field2115[81]?2:1):0);
               client.field338.method2745(class144.field2204 + var11);
               client.field338.method2745(var12 + class3.field67);
               client.field338.method2603(var4);
               client.field338.method2603(var5);
               client.field338.method2599(client.field379);
               client.field338.method2603(57);
               client.field338.method2603(client.field443);
               client.field338.method2603(client.field368);
               client.field338.method2603(89);
               client.field338.method2599(class5.field93.field844);
               client.field338.method2599(class5.field93.field819);
               client.field338.method2603(63);
               client.field528 = var11;
               client.field347 = var12;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "270158557"
   )
   static final int method3242(int var0, int var1) {
      int var2 = class99.method2289(var0 + '넵', var1 + 91923, 4) - 128 + (class99.method2289(10294 + var0, '鎽' + var1, 2) - 128 >> 1) + (class99.method2289(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)(0.3D * (double)var2);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}

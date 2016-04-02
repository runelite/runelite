import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cw")
public final class class89 {
   @ObfuscatedName("n")
   static int[] field1529;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1252319205
   )
   int field1531;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -230861831
   )
   int field1532;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -928488033
   )
   int field1533;
   @ObfuscatedName("h")
   boolean field1534 = true;
   @ObfuscatedName("as")
   static class80[] field1536;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 726447747
   )
   int field1538;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1934524409
   )
   int field1539;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 52120741
   )
   int field1540;

   @ObfuscatedName("ao")
   static final void method2096(int var0, int var1) {
      if(2 == client.field297) {
         class113.method2460((client.field536 - class85.field1439 << 7) + client.field303, (client.field346 - class6.field128 << 7) + client.field304, client.field292 * 2);
         if(client.field300 > -1 && client.field289 % 20 < 10) {
            class123.field2014[0].method1709(client.field300 + var0 - 12, var1 + client.field386 - 28);
         }

      }
   }

   @ObfuscatedName("e")
   static void method2097(File var0) {
      class135.field2075 = var0;
      if(!class135.field2075.exists()) {
         throw new RuntimeException("");
      } else {
         class135.field2078 = true;
      }
   }

   @ObfuscatedName("ay")
   static int method2098() {
      return client.field398?2:1;
   }

   class89(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1539 = var1;
      this.field1540 = var2;
      this.field1531 = var3;
      this.field1532 = var4;
      this.field1533 = var5;
      this.field1538 = var6;
      this.field1534 = var7;
   }

   @ObfuscatedName("e")
   public static class46 method2099(int var0) {
      class46 var1 = (class46)class46.field1026.method3754((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class46.field1028.method3280(4, var0);
         var1 = new class46();
         if(null != var2) {
            var1.method960(new class119(var2));
         }

         var1.method959();
         class46.field1026.method3756(var1, (long)var0);
         return var1;
      }
   }
}

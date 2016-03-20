import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hc")
final class class212 implements Comparator {
   @ObfuscatedName("y")
   static class80[] field3138;

   @ObfuscatedName("a")
   int method3975(class213 var1, class213 var2) {
      return var1.method3985().compareTo(var2.method3985());
   }

   public int compare(Object var1, Object var2) {
      return this.method3975((class213)var1, (class213)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   static final void method3982() {
      if(class178.field2912 != null) {
         class178.field2912.method3019();
         class178.field2912 = null;
      }

      class180.method3545();
      class77.field1396.method1922();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field359[var0].method2396();
      }

      System.gc();
      class154.method3173(2);
      client.field532 = -1;
      client.field533 = false;
      class3.method49();
      class1.method9(10);
   }

   @ObfuscatedName("bm")
   static final void method3983(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field470) {
         if(client.field435 < 500) {
            client.field440[client.field435] = var0;
            client.field445[client.field435] = var1;
            client.field302[client.field435] = var2;
            client.field439[client.field435] = var3;
            client.field436[client.field435] = var4;
            client.field437[client.field435] = var5;
            ++client.field435;
         }

      }
   }
}

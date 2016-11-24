import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class6 implements Comparator {
   @ObfuscatedName("q")
   static ModIcon field56;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-663840401"
   )
   public static void method82(String[] var0, short[] var1) {
      class162.method3193(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "998949730"
   )
   int method83(class2 var1, class2 var2) {
      return var1.method24().compareTo(var2.method24());
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIB)I",
      garbageValue = "16"
   )
   static final int method85(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1445[var2 * 1024 / var3] >> 1;
      return (var0 * (65536 - var4) >> 16) + (var4 * var1 >> 16);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method83((class2)var1, (class2)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Lclass196;",
      garbageValue = "17"
   )
   public static class196 method92(int var0) {
      class196 var1 = (class196)class196.field2868.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2881.method3329(32, var0);
         var1 = new class196();
         if(var2 != null) {
            var1.method3617(new Buffer(var2));
         }

         class196.field2868.put(var1, (long)var0);
         return var1;
      }
   }
}

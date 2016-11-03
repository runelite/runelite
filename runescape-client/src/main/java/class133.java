import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class133 {
   @ObfuscatedName("q")
   public static final class133 field2110 = new class133(1);
   @ObfuscatedName("k")
   public static final class133 field2112 = new class133(0);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -490531927
   )
   public final int field2113;
   @ObfuscatedName("j")
   public static class170 field2114;
   @ObfuscatedName("f")
   public static final class133 field2115 = new class133(2);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class133(int var1) {
      this.field2113 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IS)Lclass49;",
      garbageValue = "83"
   )
   public static class49 method2877(int var0) {
      class49 var1 = (class49)class49.field1086.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1087.method3305(33, var0);
         var1 = new class49();
         if(var2 != null) {
            var1.method1007(new Buffer(var2));
         }

         class49.field1086.put(var1, (long)var0);
         return var1;
      }
   }
}

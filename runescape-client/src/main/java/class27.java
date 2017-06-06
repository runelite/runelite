import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class27 implements class178 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2001773211
   )
   final int field393;
   @ObfuscatedName("c")
   static final class27 field394;
   @ObfuscatedName("v")
   static final class27 field395;
   @ObfuscatedName("y")
   final byte field398;
   @ObfuscatedName("bs")
   static class232 field400;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      longValue = 2243327059297469443L
   )
   static long field401;
   @ObfuscatedName("i")
   static final class27 field402;
   @ObfuscatedName("e")
   static final class27 field405;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field398;
   }

   static {
      field402 = new class27(2, (byte)0);
      field394 = new class27(1, (byte)1);
      field405 = new class27(3, (byte)2);
      field395 = new class27(0, (byte)3);
   }

   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   class27(int var1, byte var2) {
      this.field393 = var1;
      this.field398 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Lclass254;",
      garbageValue = "1"
   )
   public static class254 method203(int var0) {
      class254 var1 = (class254)class254.field3409.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class168.field2355.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4485(new Buffer(var2));
         }

         class254.field3409.put(var1, (long)var0);
         return var1;
      }
   }
}

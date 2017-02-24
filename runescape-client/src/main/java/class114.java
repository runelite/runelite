import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class114 {
   @ObfuscatedName("kg")
   static Widget[] field1786;
   @ObfuscatedName("iw")
   static Widget field1787;
   @ObfuscatedName("c")
   public static short[][] field1788;
   @ObfuscatedName("q")
   static Applet field1789 = null;
   @ObfuscatedName("d")
   static String field1791 = null;

   class114() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-28489"
   )
   static final int method2256(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-47932455"
   )
   static final void method2261() {
      Region.field1506 = false;
      Client.field308 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1972974619"
   )
   static void method2262() {
      for(class31 var0 = (class31)class31.field733.method2458(); var0 != null; var0 = (class31)class31.field733.method2472()) {
         if(var0.field729 != null) {
            class16.field184.method990(var0.field729);
            var0.field729 = null;
         }

         if(var0.field734 != null) {
            class16.field184.method990(var0.field734);
            var0.field734 = null;
         }
      }

      class31.field733.method2452();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lclass216;",
      garbageValue = "-2147033354"
   )
   public static class216 method2264(int var0) {
      class216[] var1 = new class216[]{class216.field3182, class216.field3179, class216.field3180};
      class216[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class216 var4 = var2[var3];
         if(var0 == var4.field3181) {
            return var4;
         }
      }

      return null;
   }
}

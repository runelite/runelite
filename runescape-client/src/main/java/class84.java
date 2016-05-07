import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class84 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1584606117
   )
   int field1459;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 873110803
   )
   int field1460;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2146782431
   )
   int field1462;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "-805650761"
   )
   public static class48 method1884(int var0) {
      class48 var1 = (class48)class48.field1073.method3743((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class48.field1084.method3239(8, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method963(new class119(var2));
         }

         class48.field1073.method3745(var1, (long)var0);
         return var1;
      }
   }
}

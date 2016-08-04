import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class181 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Lclass184;",
      garbageValue = "-276240581"
   )
   static class184 method3631(class170 var0, int var1) {
      byte[] var2 = var0.method3402(var1);
      return var2 == null?null:new class184(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass106;",
      garbageValue = "1637661745"
   )
   @Export("getFrames")
   static class106 method3632(int var0) {
      class106 var1 = (class106)class44.field1015.method3905((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class97.method2255(class44.field1012, class44.field1019, var0, false);
         if(null != var1) {
            class44.field1015.method3907(var1, (long)var0);
         }

         return var1;
      }
   }
}

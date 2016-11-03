import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class156 {
   @ObfuscatedName("q")
   static final class156 field2313 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("c")
   static final class156 field2316 = new class156("WIP", 2);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 57343369
   )
   final int field2318;
   @ObfuscatedName("l")
   static Widget field2320;
   @ObfuscatedName("f")
   static final class156 field2321 = new class156("RC", 1);
   @ObfuscatedName("k")
   static final class156 field2322 = new class156("LIVE", 0);
   @ObfuscatedName("v")
   public final String field2324;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2324 = var1;
      this.field2318 = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "-262589820"
   )
   public static class45 method3182(int var0) {
      class45 var1 = (class45)class45.field1029.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1031.method3305(13, var0);
         var1 = new class45();
         var1.field1033 = var0;
         if(null != var2) {
            var1.method936(new Buffer(var2));
         }

         class45.field1029.put(var1, (long)var0);
         return var1;
      }
   }
}

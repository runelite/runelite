import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class168 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)LSequence;",
      garbageValue = "1"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3068.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3064.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method3761(new Buffer(var2));
         }

         var1.method3771();
         Sequence.field3068.put(var1, (long)var0);
         return var1;
      }
   }

   class168() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-701226186"
   )
   static final String method3202(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class116.method2288(16711680):(var2 < -6?class116.method2288(16723968):(var2 < -3?class116.method2288(16740352):(var2 < 0?class116.method2288(16756736):(var2 > 9?class116.method2288('\uff00'):(var2 > 6?class116.method2288(4259584):(var2 > 3?class116.method2288(8453888):(var2 > 0?class116.method2288(12648192):class116.method2288(16776960))))))));
   }
}

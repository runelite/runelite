import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class227 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -277995267
   )
   static int field3140;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)LSequence;",
      garbageValue = "0"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3616.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3602.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method4686(new Buffer(var2));
         }

         var1.method4698();
         Sequence.field3616.put(var1, (long)var0);
         return var1;
      }
   }
}

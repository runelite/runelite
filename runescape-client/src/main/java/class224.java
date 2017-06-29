import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class224 {
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = -1398805273
   )
   static int field2853;
   @ObfuscatedName("e")
   static ModIcon field2855;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "1100169503"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3608.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3617.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method4689(new Buffer(var2));
         }

         var1.method4732();
         Sequence.field3608.put(var1, (long)var0);
         return var1;
      }
   }
}

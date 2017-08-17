import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class224 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Liz;",
      garbageValue = "-404367836"
   )
   public static Enum method4086(int var0) {
      Enum var1 = (Enum)Enum.field3388.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3396.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.field3388.put(var1, (long)var0);
         return var1;
      }
   }
}

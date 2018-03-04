import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class252 {
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      longValue = 2540486135555386615L
   )
   static long field3303;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljo;",
      garbageValue = "-1059466096"
   )
   public static VarPlayerType method4638(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }
}

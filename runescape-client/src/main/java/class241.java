import java.io.File;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class class241 {
   @ObfuscatedName("h")
   static File field2807;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljm;",
      garbageValue = "-939536706"
   )
   public static VarCInt method4414(int var0) {
      VarCInt var1 = (VarCInt)VarCInt.field3475.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarCInt.field3476.getConfigData(19, var0);
         var1 = new VarCInt();
         if(var2 != null) {
            var1.method4773(new Buffer(var2));
         }

         VarCInt.field3475.put(var1, (long)var0);
         return var1;
      }
   }
}

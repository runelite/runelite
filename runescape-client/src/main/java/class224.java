import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class224 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "82"
   )
   public static byte[] method4077() {
      byte[] var0 = new byte[24];

      try {
         class156.field2230.seek(0L);
         class156.field2230.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}

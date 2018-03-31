import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public class class288 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljm;IIB)Z",
      garbageValue = "108"
   )
   public static boolean method5204(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Varbit.decodeSprite(var3);
         return true;
      }
   }
}

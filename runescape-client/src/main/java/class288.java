import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class288 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lil;IIB)Z",
      garbageValue = "23"
   )
   public static boolean method5126(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         BuildType.decodeSprite(var3);
         return true;
      }
   }
}

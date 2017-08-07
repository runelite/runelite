import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class274 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;II)Z",
      garbageValue = "-2013474895"
   )
   public static boolean method4929(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4120(var1);
      if(var2 == null) {
         return false;
      } else {
         Widget.decodeSprite(var2);
         return true;
      }
   }
}

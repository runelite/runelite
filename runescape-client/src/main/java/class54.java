import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class54 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "706378799"
   )
   static boolean method832(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;Ljava/lang/String;I)[Lkp;",
      garbageValue = "-1234400261"
   )
   public static SpritePixels[] method833(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return Parameters.method4934(var0, var3, var4);
   }
}

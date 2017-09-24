import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class178 {
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field2419;
   @ObfuscatedName("o")
   @Export("overlayIds")
   static byte[][][] overlayIds;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lii;III)Z",
      garbageValue = "-544333825"
   )
   static boolean method3474(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         GraphicsObject.decodeSprite(var3);
         return true;
      }
   }
}

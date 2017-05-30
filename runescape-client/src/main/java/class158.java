import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public abstract class class158 {
   @ObfuscatedName("gm")
   static SpritePixels field2238;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1657249328"
   )
   public abstract int vmethod3022(int var1, int var2);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public abstract void vmethod3024();

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-932799188"
   )
   static boolean method3025(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = class27.method214(var0, WorldMapType1.field423);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class27.method214(Client.friends[var3].name, WorldMapType1.field423)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class27.method214(XGrandExchangeOffer.localPlayer.name, WorldMapType1.field423))) {
            return true;
         } else {
            return false;
         }
      }
   }
}

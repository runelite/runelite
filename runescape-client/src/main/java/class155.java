import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class155 extends class297 {
   @ObfuscatedName("t")
   final boolean field2116;

   public class155(boolean var1) {
      this.field2116 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;B)I",
      garbageValue = "-15"
   )
   int method3161(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field2116?var1.world - var2.world:var2.world - var1.world):this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3161((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-131428662"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.listFetcher == null) {
            World.listFetcher = MapIconReference.urlRequester.request(new URL(GrandExchangeOffer.field290));
         } else if(World.listFetcher.isDone()) {
            byte[] var0 = World.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            ItemLayer.method2592(World.worldList, 0, World.worldList.length - 1, World.field1210, World.field1204);
            World.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(I)Llo;",
      garbageValue = "-2027843167"
   )
   static RenderOverview method3159() {
      return class251.renderOverview;
   }
}

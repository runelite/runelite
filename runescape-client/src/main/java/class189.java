import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class189 extends CacheableNode {
   @ObfuscatedName("q")
   public static class182 field2793;
   @ObfuscatedName("h")
   public boolean field2794 = false;
   @ObfuscatedName("ev")
   static SpritePixels field2795;
   @ObfuscatedName("d")
   static NodeCache field2796 = new NodeCache(64);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1685074494"
   )
   void method3459(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2794 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "106"
   )
   void method3460(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3459(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "110"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == Ignore.worldServersDownload) {
            Ignore.worldServersDownload = new class26(class33.field775, new URL(class3.field34));
         } else {
            byte[] var0 = Ignore.worldServersDownload.method610();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field703 = var1.readUnsignedShort();
               World.worldList = new World[World.field703];

               World var3;
               for(int var2 = 0; var2 < World.field703; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method2965();
                  var3.address = var1.method2868();
                  var3.activity = var1.method2868();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class5.method66(World.worldList, 0, World.worldList.length - 1, World.field698, World.field697);
               Ignore.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         Ignore.worldServersDownload = null;
      }

      return false;
   }
}

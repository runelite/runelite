import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("at")
   static java.awt.Font field2094;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 903640827
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 13223679
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 750427611
   )
   @Export("config")
   int config;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1336109723
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -602397291
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 291217615
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1981559819
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1377437617
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lhn;",
      garbageValue = "117"
   )
   public static Widget method2901(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class170.widgets[var1] == null || class170.widgets[var1][var2] == null) {
         boolean var3 = class7.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class170.widgets[var1][var2];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lim;III)Z",
      garbageValue = "2085347341"
   )
   static boolean method2899(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Timer.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "98259965"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class134.method2601();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && CacheFile.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(181);

            try {
               CacheFile.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }
}

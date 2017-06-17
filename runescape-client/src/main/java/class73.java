import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class73 extends class163 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1848577048"
   )
   protected boolean vmethod2950(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2320 && var3 == super.field2322;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1760094016"
   )
   static final void method1065(boolean var0) {
      class69.method1035();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.field958 && WidgetNode.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(71);

            try {
               WidgetNode.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field958 = true;
            }
         }
      }

   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1353972474"
   )
   static String method1066(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field1161 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field1161 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field1161 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field1161 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field1161 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class219.field2810 != null) {
         var3 = "/p=" + class219.field2810;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field1120 + "/a=" + Client.field908 + var3 + "/";
   }
}

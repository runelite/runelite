import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("p")
   @Export("url")
   final URL url;
   @ObfuscatedName("i")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("w")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "997740200"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "50"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "890227465"
   )
   static final void method3037() {
      PacketNode var0 = class35.method501(ClientPacket.field2351, Client.field867.field1439);
      Client.field867.method2021(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.first(); var1 != null; var1 = (WidgetNode)Client.componentTable.next()) {
         if(var1.owner == 0 || var1.owner == 3) {
            GraphicsObject.method1797(var1, true);
         }
      }

      if(Client.field971 != null) {
         class60.method1015(Client.field971);
         Client.field971 = null;
      }

   }
}

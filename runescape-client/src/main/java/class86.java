import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class86 {
   @ObfuscatedName("h")
   static final BigInteger field1303;
   @ObfuscatedName("d")
   static final BigInteger field1307;

   static {
      field1303 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1307 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lil;III)Lkm;",
      garbageValue = "-1048824920"
   )
   static IndexedSprite method1735(IndexDataBase var0, int var1, int var2) {
      return !class288.method5126(var0, var1, var2)?null:Varcs.method1854();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1716033467"
   )
   static void method1727() {
      if(class34.loadWorlds()) {
         class91.worldSelectShown = true;
      }

   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-1456050144"
   )
   static void method1734(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = ScriptVarType.getWidgetChild(var1, var2);
      if(var5 != null) {
         if(var5.field2862 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field798 = var0;
            var6.string = var4;
            var6.objs = var5.field2862;
            Preferences.method1633(var6);
         }

         boolean var8 = true;
         if(var5.contentType > 0) {
            var8 = ContextMenuRow.method1743(var5);
         }

         if(var8) {
            if(ServerPacket.method3243(GraphicsObject.getWidgetConfig(var5), var0 - 1)) {
               PacketNode var7;
               if(var0 == 1) {
                  var7 = class235.method4272(ClientPacket.field2408, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 2) {
                  var7 = class235.method4272(ClientPacket.field2353, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 3) {
                  var7 = class235.method4272(ClientPacket.field2369, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 4) {
                  var7 = class235.method4272(ClientPacket.field2420, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 5) {
                  var7 = class235.method4272(ClientPacket.field2406, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 6) {
                  var7 = class235.method4272(ClientPacket.field2362, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 7) {
                  var7 = class235.method4272(ClientPacket.field2346, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 8) {
                  var7 = class235.method4272(ClientPacket.field2345, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 9) {
                  var7 = class235.method4272(ClientPacket.field2387, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

               if(var0 == 10) {
                  var7 = class235.method4272(ClientPacket.field2411, Client.field915.field1462);
                  var7.packetBuffer.putInt(var1);
                  var7.packetBuffer.putShort(var2);
                  var7.packetBuffer.putShort(var3);
                  Client.field915.method1898(var7);
               }

            }
         }
      }
   }
}

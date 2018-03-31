import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("cc")
   @Export("currentTypedKey")
   public static char currentTypedKey;
   @ObfuscatedName("k")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1926976203
   )
   final int field3344;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.field3344 = var2;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-1821515728"
   )
   static void method4537(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = ClientPacket.getWidgetChild(var1, var2);
      if(var5 != null) {
         if(var5.onOpListener != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field791 = var0;
            var6.string = var4;
            var6.objs = var5.onOpListener;
            AbstractByteBuffer.method3757(var6);
         }

         boolean var11 = true;
         if(var5.contentType > 0) {
            var11 = class240.method4437(var5);
         }

         if(var11) {
            int var8 = class45.getWidgetClickMask(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               PacketNode var10;
               if(var0 == 1) {
                  var10 = FaceNormal.method3078(ClientPacket.field2386, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 2) {
                  var10 = FaceNormal.method3078(ClientPacket.field2434, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 3) {
                  var10 = FaceNormal.method3078(ClientPacket.field2455, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 4) {
                  var10 = FaceNormal.method3078(ClientPacket.field2395, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 5) {
                  var10 = FaceNormal.method3078(ClientPacket.field2424, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 6) {
                  var10 = FaceNormal.method3078(ClientPacket.field2467, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 7) {
                  var10 = FaceNormal.method3078(ClientPacket.field2400, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 8) {
                  var10 = FaceNormal.method3078(ClientPacket.field2451, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 9) {
                  var10 = FaceNormal.method3078(ClientPacket.field2374, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

               if(var0 == 10) {
                  var10 = FaceNormal.method3078(ClientPacket.field2401, Client.field902.field1475);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field902.method2036(var10);
               }

            }
         }
      }
   }
}

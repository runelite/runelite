import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class218 {
   @ObfuscatedName("on")
   @ObfuscatedGetter(
      intValue = -2047994585
   )
   static int field2685;
   @ObfuscatedName("d")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("x")
   @Export("settings")
   @Hook("varbitChanged")
   public static int[] settings;
   @ObfuscatedName("k")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfn;Lgh;I)Lfq;",
      garbageValue = "1436875406"
   )
   public static PacketNode method4105(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2 = class89.method1765();
      var2.clientPacket = var0;
      var2.field2421 = var0.packetLength;
      if(var2.field2421 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2421 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2421 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2421 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2423 = 0;
      return var2;
   }
}

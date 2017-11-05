import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("as")
public class class51 implements class101 {
   @ObfuscatedName("e")
   static ScheduledExecutorService field682;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -1860592847
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = 1377072357
   )
   static int field678;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Ldk;",
      garbageValue = "-997393230"
   )
   public AbstractSoundSystem vmethod1962() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1751943647"
   )
   static void method761(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADVANCE_DIALOGUE);
      if(Client.RUNELITE_PACKET) {
         Client.secretPacketBuffer1.runeliteWriteInt(var1);
         Client.secretPacketBuffer1.runeliteWriteInt(var0);
      } else {
         Client.secretPacketBuffer1.method3342(var1);
         Client.secretPacketBuffer1.method3392(var0);
      }

   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1429194769"
   )
   static final void method760(int var0) {
      if(WorldMapData.loadWidget(var0)) {
         Widget[] var1 = class215.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2680 = 0;
               var3.field2765 = 0;
            }
         }

      }
   }
}

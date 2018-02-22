import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("bb")
   static String field740;
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "[Llm;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 113647491
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -930357889
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("o")
   boolean field739;

   WidgetNode() {
      this.field739 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-148329697"
   )
   public static final void method1124(int var0, int var1) {
      class131.Viewport_mouseX = var0;
      class131.Viewport_mouseY = var1;
      class131.Viewport_containsMouse = true;
      class131.Viewport_entityCountAtMouse = 0;
      class131.Viewport_false0 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lif;",
      garbageValue = "-1773736646"
   )
   static class259[] method1127() {
      return new class259[]{class259.field3376, class259.field3377, class259.field3380};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-43"
   )
   public static boolean method1125(char var0) {
      return var0 >= '0' && var0 <= '9';
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   static void method1126() {
      Client.field863.method2031();
      Client.field863.packetBuffer.offset = 0;
      Client.field863.serverPacket = null;
      Client.field863.field1441 = null;
      Client.field863.field1442 = null;
      Client.field863.field1443 = null;
      Client.field863.packetLength = 0;
      Client.field863.field1439 = 0;
      Client.field836 = 0;
      class272.method4902();
      Client.field834 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      OwnWorldComparator.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1121 = false;
         }
      }

      ItemContainer.itemContainers = new HashTable(32);
      WorldMapType1.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field979[var0] = true;
      }

      Resampler.method2310();
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lgg;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2071439673
   )
   static int field2496;
   @ObfuscatedName("z")
   public static int[] field2491;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = -854639313
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   @Export("clientPacket")
   ClientPacket clientPacket;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1823057557
   )
   int field2492;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 847533503
   )
   public int field2494;

   static {
      packetBufferNodes = new PacketNode[300];
      field2496 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-353960817"
   )
   public void method3431() {
      if(field2496 < packetBufferNodes.length) {
         packetBufferNodes[++field2496 - 1] = this;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "84"
   )
   public static boolean method3430(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method3438(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lib;I)V",
      garbageValue = "-1857951930"
   )
   static final void method3437(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1072 == -1) {
            Client.field1072 = var0.spriteId;
            Client.field924 = var0.field2855;
         }

         if(Client.field1118.isFemale) {
            var0.spriteId = Client.field1072;
         } else {
            var0.spriteId = Client.field924;
         }

      } else if(var1 == 325) {
         if(Client.field1072 == -1) {
            Client.field1072 = var0.spriteId;
            Client.field924 = var0.field2855;
         }

         if(Client.field1118.isFemale) {
            var0.spriteId = Client.field924;
         } else {
            var0.spriteId = Client.field1072;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}

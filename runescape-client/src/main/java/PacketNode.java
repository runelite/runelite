import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lgc;"
   )
   @Export("packetBufferNodes")
   static PacketNode[] packetBufferNodes;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1789163745
   )
   static int field2462;
   @ObfuscatedName("g")
   static int[][] field2469;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("clientPacket")
   ClientPacket clientPacket;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2062955649
   )
   int field2458;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -607845895
   )
   public int field2460;

   static {
      packetBufferNodes = new PacketNode[300];
      field2462 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-594232484"
   )
   public void method3447() {
      if(field2462 < packetBufferNodes.length) {
         packetBufferNodes[++field2462 - 1] = this;
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbl;III)V",
      garbageValue = "1742210614"
   )
   static void method3441(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = Occluder.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1133 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1094 = 0;
         }

         if(var3 == 2) {
            var0.field1094 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || Occluder.getAnimation(var1).forcedPriority >= Occluder.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1133 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1094 = 0;
         var0.field1153 = var0.queueSize;
      }

   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "2106701433"
   )
   static void method3448(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class201.getWidgetChild(var1, var2);
      if(var5 != null) {
         if(var5.field2877 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field753 = var0;
            var6.string = var4;
            var6.objs = var5.field2877;
            class194.method3791(var6);
         }

         boolean var11 = true;
         if(var5.contentType > 0) {
            var11 = class29.method271(var5);
         }

         if(var11) {
            int var8 = class230.getWidgetConfig(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               PacketNode var10;
               if(var0 == 1) {
                  var10 = class61.method1076(ClientPacket.field2377, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 2) {
                  var10 = class61.method1076(ClientPacket.field2356, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 3) {
                  var10 = class61.method1076(ClientPacket.field2350, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 4) {
                  var10 = class61.method1076(ClientPacket.field2355, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 5) {
                  var10 = class61.method1076(ClientPacket.field2393, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 6) {
                  var10 = class61.method1076(ClientPacket.field2382, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 7) {
                  var10 = class61.method1076(ClientPacket.field2414, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 8) {
                  var10 = class61.method1076(ClientPacket.field2428, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 9) {
                  var10 = class61.method1076(ClientPacket.field2402, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

               if(var0 == 10) {
                  var10 = class61.method1076(ClientPacket.field2349, Client.field863.field1434);
                  var10.packetBuffer.putInt(var1);
                  var10.packetBuffer.putShort(var2);
                  var10.packetBuffer.putShort(var3);
                  Client.field863.method2039(var10);
               }

            }
         }
      }
   }
}

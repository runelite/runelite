import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lfc;"
   )
   static PacketNode[] field2419;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1621553429
   )
   static int field2420;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1728680613
   )
   static int field2415;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1559865493
   )
   public int field2416;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1609470239
   )
   public int field2423;

   static {
      field2419 = new PacketNode[300];
      field2420 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "316719324"
   )
   public void method3106() {
      if(field2420 < field2419.length) {
         field2419[++field2420 - 1] = this;
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-234897108"
   )
   static final void method3098(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         class168.method3096((Client.hintArrowX - class13.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - ClanMember.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenY > -1 && Client.gameCycle % 20 < 10) {
            class268.headIconsHint[0].drawAt(var0 + Client.screenY - 12, Client.screenX + var1 - 28);
         }

      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("on")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1603129761
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Les;",
      garbageValue = "-17"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cp")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(Lhq;III)V",
      garbageValue = "1378554582"
   )
   static final void method2929(Widget var0, int var1, int var2) {
      if(Client.field1089 == 0 || Client.field1089 == 3) {
         if(MouseInput.mouseLastButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class221 var3 = var0.method4209(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4141(var4, var5)) {
               var4 -= var3.field2721 / 2;
               var5 -= var3.field2718 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + GrandExchangeOffer.localPlayer.x >> 7;
               int var12 = GrandExchangeOffer.localPlayer.y - var10 >> 7;
               PacketNode var13 = class235.method4272(ClientPacket.field2398, Client.field915.field1462);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.writeIntLE(var11 + class175.baseX);
               var13.packetBuffer.method3361(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.putShortLE(var12 + GraphicsObject.baseY);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(GrandExchangeOffer.localPlayer.x);
               var13.packetBuffer.putShort(GrandExchangeOffer.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field915.method1898(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = -1096011215
   )
   static int field1409;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = -1304764741
   )
   static int field1420;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   static NodeCache field1421;
   @ObfuscatedName("lp")
   @ObfuscatedSignature(
      signature = "[Lho;"
   )
   static Widget[] field1417;
   @ObfuscatedName("i")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("w")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("s")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 136904081
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -743842561
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1786785735
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -417749209
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lgs;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1421 = new NodeCache(128);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[Lgs;",
      garbageValue = "-752944290"
   )
   IterableHashTable[] method1989(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljz;",
      garbageValue = "5"
   )
   public static Enum method1999(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Lho;III)V",
      garbageValue = "-512405377"
   )
   static final void method2000(Widget var0, int var1, int var2) {
      if(Client.field1050 == 0 || Client.field1050 == 3) {
         if(MouseInput.mouseLastButton == 1 || !Client.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            class221 var3 = var0.method4288(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.mouseLastPressedX - var1;
            int var5 = MouseInput.mouseLastPressedY - var2;
            if(var3.method4175(var4, var5)) {
               var4 -= var3.field2686 / 2;
               var5 -= var3.field2684 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var8 * var4 + var7 * var5 >> 11;
               int var10 = var8 * var5 - var7 * var4 >> 11;
               int var11 = var9 + class36.localPlayer.x >> 7;
               int var12 = class36.localPlayer.y - var10 >> 7;
               PacketNode var13 = class35.method501(ClientPacket.field2366, Client.field867.field1439);
               var13.packetBuffer.putByte(18);
               var13.packetBuffer.writeIntLE16(var12 + class85.baseY);
               var13.packetBuffer.writeShortLE(var11 + WorldMapType1.baseX);
               var13.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?(KeyFocusListener.keyPressed[81]?2:1):0);
               var13.packetBuffer.putByte(var4);
               var13.packetBuffer.putByte(var5);
               var13.packetBuffer.putShort(Client.mapAngle);
               var13.packetBuffer.putByte(57);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(0);
               var13.packetBuffer.putByte(89);
               var13.packetBuffer.putShort(class36.localPlayer.x);
               var13.packetBuffer.putShort(class36.localPlayer.y);
               var13.packetBuffer.putByte(63);
               Client.field867.method2021(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}

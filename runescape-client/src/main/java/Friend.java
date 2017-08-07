import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("ny")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1321040307
   )
   @Export("world")
   int world;
   @ObfuscatedName("w")
   boolean field799;
   @ObfuscatedName("k")
   boolean field800;
   @ObfuscatedName("e")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 359071237
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-99406982"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + var6 * class61.tileHeights[var5][var3 + 1][var4] >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Lhg;III)V",
      garbageValue = "1352195589"
   )
   static final void method1089(Widget var0, int var1, int var2) {
      if(Client.field1138 == 0 || Client.field1138 == 3) {
         if(MouseInput.field734 == 1 || !class51.field645 && MouseInput.field734 == 4) {
            class211 var3 = var0.method4008(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field725 - var1;
            int var5 = MouseInput.field726 - var2;
            if(var3.method3919(var4, var5)) {
               var4 -= var3.field2577 / 2;
               var5 -= var3.field2578 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var5 * var7 + var8 * var4 >> 11;
               int var10 = var8 * var5 - var4 * var7 >> 11;
               int var11 = var9 + class54.localPlayer.x >> 7;
               int var12 = class54.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(20);
               Client.secretPacketBuffer1.putByte(18);
               Client.secretPacketBuffer1.method3199(KeyFocusListener.field631[82]?(KeyFocusListener.field631[81]?2:1):0);
               Client.secretPacketBuffer1.putShortLE(var12 + ScriptEvent.baseY);
               Client.secretPacketBuffer1.putShort(var11 + class25.baseX);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(class54.localPlayer.x);
               Client.secretPacketBuffer1.putShort(class54.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}

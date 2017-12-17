import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1032831256"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class3.method7(var0 - 1, var1 - 1) + class3.method7(1 + var0, var1 - 1) + class3.method7(var0 - 1, 1 + var1) + class3.method7(1 + var0, var1 + 1);
      int var3 = class3.method7(var0 - 1, var1) + class3.method7(var0 + 1, var1) + class3.method7(var0, var1 - 1) + class3.method7(var0, var1 + 1);
      int var4 = class3.method7(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lks;",
      garbageValue = "-1374631757"
   )
   static SpritePixels method1060() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class299.field3864;
      var0.maxHeight = class299.field3868;
      var0.offsetX = class299.field3867[0];
      var0.offsetY = class299.offsetsY[0];
      var0.width = Item.field1387[0];
      var0.height = class276.field3727[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = Bounds.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = FaceNormal.field2025[var2[var3] & 255];
      }

      ContextMenuRow.method1663();
      return var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "2053695113"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2013173523"
   )
   static void method1058() {
      PacketNode var0 = FileSystem.method4252(ClientPacket.field2394, Client.field888.field1449);
      PacketBuffer var1 = var0.packetBuffer;
      int var2 = Client.isResized?2:1;
      var1.putByte(var2);
      var0.packetBuffer.putShort(Huffman.canvasWidth);
      var0.packetBuffer.putShort(VertexNormal.canvasHeight);
      Client.field888.method1862(var0);
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Lbr;II)V",
      garbageValue = "89717800"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class285.worldToScreen(var0.x, var0.y, var1);
   }
}

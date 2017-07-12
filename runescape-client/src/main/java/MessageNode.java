import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("jt")
   @ObfuscatedGetter(
      intValue = -672814049
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1001868687
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1154792759
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -743015069
   )
   @Export("type")
   int type;
   @ObfuscatedName("t")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @Export("sender")
   String sender;
   @ObfuscatedName("r")
   @Export("value")
   String value;

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class98.field1549 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "12"
   )
   void method1146(int var1, String var2, String var3, String var4) {
      int var5 = ++class98.field1549 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "1324989332"
   )
   static final void method1144(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var2 * var9 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class31.mapedge.method5118(var14 + 94 + var0 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class40.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;B)I",
      garbageValue = "-15"
   )
   public static int method1142(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = ItemComposition.method4634(var1);
      var0.putShortSmart(var3.length);
      var0.offset += class265.field3665.compress(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}

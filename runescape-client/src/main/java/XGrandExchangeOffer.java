import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   static Task field295;
   @ObfuscatedName("d")
   @Export("progress")
   byte progress;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1824045555
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -581910843
   )
   @Export("price")
   public int price;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -457817791
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -920872559
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1158968297
   )
   @Export("spent")
   public int spent;

   public XGrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfw;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1113626653"
   )
   void method101(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1425869878"
   )
   void method100(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "65280"
   )
   public int method97() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1484189310"
   )
   public int method103() {
      return this.progress & 7;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-86"
   )
   static final boolean method111(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-654078905"
   )
   static final void method113(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2753(var0, var1, var2);
      int[] var8 = Region.method2753(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;S)V",
      garbageValue = "-4818"
   )
   public static void method114(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1037442929"
   )
   static final void method112(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(209);
         Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }
}

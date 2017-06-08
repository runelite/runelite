import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1260806173
   )
   @Export("height")
   int height;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1326247899
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 23290381
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -695810893
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1282356493
   )
   int field2194;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -690191441
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1508606227
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -917193957
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("f")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1756218729
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2130431423
   )
   int field2200;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1320615025
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1251092415
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("w")
   public static String field2203;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -191377343
   )
   @Export("relativeY")
   int relativeY;

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "-666739544"
   )
   static final void method2904(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class136.SINE[var7];
         int var9 = class136.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class44.field577.method5094(var0 + 94 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         XGrandExchangeOffer.method135(var0, var1, var2, var3, var4, var5);
      }

   }

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }
}

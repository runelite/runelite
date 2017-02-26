import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class104 {
   @ObfuscatedName("p")
   static File field1687;
   @ObfuscatedName("j")
   static File field1691;
   @ObfuscatedName("m")
   public static class72 field1692 = null;
   @ObfuscatedName("s")
   public static class72 field1695 = null;
   @ObfuscatedName("u")
   public static class72 field1696 = null;
   @ObfuscatedName("z")
   static String[] field1697;
   @ObfuscatedName("ds")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("k")
   static String field1699;

   class104() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "1944211958"
   )
   static final void method2055(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1468[var7];
         int var9 = class84.field1462[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         ScriptState.field132.method4236(4 + var14 + 94 + var0 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         Tile.method1610(var0, var1, var2, var3, var4, var5);
      }

   }
}

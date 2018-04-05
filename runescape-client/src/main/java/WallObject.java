import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1517793005
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1468676923
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 882823813
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 774109897
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1998202247
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1042684503
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1828772819
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;I)Ljava/lang/String;",
      garbageValue = "-811199669"
   )
   public static String method3061(Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = ChatPlayer.getString(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1694408174"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class254.getSmoothNoise2D(var3, var5);
      int var8 = class254.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class254.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class254.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = AbstractSoundSystem.method2246(var7, var8, var4, var2);
      int var12 = AbstractSoundSystem.method2246(var9, var10, var4, var2);
      return AbstractSoundSystem.method2246(var11, var12, var6, var2);
   }
}

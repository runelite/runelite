import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class152 extends class297 {
   @ObfuscatedName("ft")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("o")
   final boolean field2151;

   public class152(boolean var1) {
      this.field2151 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;B)I",
      garbageValue = "5"
   )
   int method3132(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2151?var1.field3845 - var2.field3845:var2.field3845 - var1.field3845):this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3132((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2146234650"
   )
   static final void method3139(int var0, int var1, int var2, int var3, int var4) {
      class18.scrollbarSprites[0].method5825(var0, var1);
      class18.scrollbarSprites[1].method5825(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field932);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field933);
      Rasterizer2D.method5797(var0, var6 + var1 + 16, var5, Client.field875);
      Rasterizer2D.method5797(var0 + 1, var6 + var1 + 16, var5, Client.field875);
      Rasterizer2D.method5731(var0, var6 + var1 + 16, 16, Client.field875);
      Rasterizer2D.method5731(var0, var6 + var1 + 17, 16, Client.field875);
      Rasterizer2D.method5797(var0 + 15, var6 + var1 + 16, var5, Client.field869);
      Rasterizer2D.method5797(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field869);
      Rasterizer2D.method5731(var0, var5 + var6 + var1 + 15, 16, Client.field869);
      Rasterizer2D.method5731(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field869);
   }
}

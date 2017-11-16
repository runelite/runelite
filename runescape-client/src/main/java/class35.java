import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class35 {
   @ObfuscatedName("lh")
   @ObfuscatedGetter(
      intValue = -259322805
   )
   static int field457;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   static final class35 field462;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   static final class35 field459;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1630807515
   )
   final int field458;

   static {
      field462 = new class35(0);
      field459 = new class35(1);
   }

   class35(int var1) {
      this.field458 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-34"
   )
   static void method473(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1211[var5] != var0) {
            var2[var4] = World.field1211[var5];
            var3[var4] = World.field1217[var5];
            ++var4;
         }
      }

      World.field1211 = var2;
      World.field1217 = var3;
      class72.method1060(class54.worldList, 0, class54.worldList.length - 1, World.field1211, World.field1217);
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "10"
   )
   static final void method474(int var0, int var1, int var2, int var3, int var4) {
      class56.field632[0].method5097(var0, var1);
      class56.field632[1].method5097(var0, var3 + var1 - 16);
      Rasterizer2D.method4981(var0, var1 + 16, 16, var3 - 32, Client.field1061);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4981(var0, var6 + var1 + 16, 16, var5, Client.field924);
      Rasterizer2D.method5019(var0, var6 + var1 + 16, var5, Client.field926);
      Rasterizer2D.method5019(var0 + 1, var6 + var1 + 16, var5, Client.field926);
      Rasterizer2D.method4990(var0, var6 + var1 + 16, 16, Client.field926);
      Rasterizer2D.method4990(var0, var6 + var1 + 17, 16, Client.field926);
      Rasterizer2D.method5019(var0 + 15, var6 + var1 + 16, var5, Client.field925);
      Rasterizer2D.method5019(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field925);
      Rasterizer2D.method4990(var0, var5 + var6 + var1 + 15, 16, Client.field925);
      Rasterizer2D.method4990(var0 + 1, var6 + var5 + var1 + 14, 15, Client.field925);
   }
}

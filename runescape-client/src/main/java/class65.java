import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public class class65 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lfq;",
      garbageValue = "1"
   )
   public static Timer method1071() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   protected static final void method1072() {
      class310.timer.vmethod3175();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field636[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field638[var0] = 0L;
      }

      GameEngine.field632 = 0;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "25222"
   )
   static final void method1069(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1058 - Client.field1057) * var5 / 100 + Client.field1057;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1063) {
         var15 = Client.field1063;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1062) {
            var6 = Client.field1062;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1064) {
         var15 = Client.field1064;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1061) {
            var6 = Client.field1061;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1060 - Client.field856) * var5 / 100 + Client.field856;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2846(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(III)Lfd;",
      garbageValue = "683801603"
   )
   static class168 method1070(int var0, int var1) {
      Client.field896.field2197 = var0;
      Client.field896.field2194 = var1;
      Client.field896.field2195 = 1;
      Client.field896.field2193 = 1;
      return Client.field896;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "([Lho;IIIZI)V",
      garbageValue = "-1889919141"
   )
   static void method1068(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            ScriptVarType.method27(var6, var2, var3, var4);
            class150.method3042(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class33.method362(var0, var6, var4);
            }
         }
      }

   }
}

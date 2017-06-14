import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class71 implements Runnable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 698338235
   )
   int field844;
   @ObfuscatedName("z")
   static ModIcon field845;
   @ObfuscatedName("f")
   int[] field846;
   @ObfuscatedName("j")
   int[] field847;
   @ObfuscatedName("p")
   Object field848;
   @ObfuscatedName("n")
   boolean field849;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1032222531
   )
   public static int field852;

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-883945033"
   )
   static final void method1081(int var0, int var1, int var2, int var3, int var4) {
      GameEngine.field707[0].method5066(var0, var1);
      GameEngine.field707[1].method5066(var0, var3 + var1 - 16);
      Rasterizer2D.method5040(var0, var1 + 16, 16, var3 - 32, Client.field991);
      int var5 = (var3 - 32) * var3 / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method5040(var0, var1 + 16 + var6, 16, var5, Client.field1176);
      Rasterizer2D.method4980(var0, var6 + var1 + 16, var5, Client.field994);
      Rasterizer2D.method4980(var0 + 1, var1 + 16 + var6, var5, Client.field994);
      Rasterizer2D.method4973(var0, var6 + var1 + 16, 16, Client.field994);
      Rasterizer2D.method4973(var0, var6 + var1 + 17, 16, Client.field994);
      Rasterizer2D.method4980(var0 + 15, var1 + 16 + var6, var5, Client.field993);
      Rasterizer2D.method4980(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field993);
      Rasterizer2D.method4973(var0, var5 + var6 + var1 + 15, 16, Client.field993);
      Rasterizer2D.method4973(var0 + 1, var5 + var1 + 14 + var6, 15, Client.field993);
   }

   public void run() {
      for(; this.field849; DynamicObject.method1842(50L)) {
         Object var1 = this.field848;
         synchronized(this.field848) {
            if(this.field844 < 500) {
               this.field847[this.field844] = class59.field729;
               this.field846[this.field844] = class59.field715;
               ++this.field844;
            }
         }
      }

   }

   class71() {
      this.field849 = true;
      this.field848 = new Object();
      this.field844 = 0;
      this.field847 = new int[500];
      this.field846 = new int[500];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797662559"
   )
   public static void method1083() {
      Widget.field2646.reset();
      Widget.field2647.reset();
      Widget.field2648.reset();
      Widget.field2716.reset();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "991402646"
   )
   static final void method1084(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2728(var0, var1, var2);
      int[] var8 = Region.method2728(var3, var4, var5);
      Rasterizer2D.method4969(var7[0], var7[1], var8[0], var8[1], var6);
   }
}

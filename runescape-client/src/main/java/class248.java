import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class248 {
   @ObfuscatedName("rt")
   @ObfuscatedSignature(
      signature = "Llp;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("z")
   public static final boolean[] field3008;
   @ObfuscatedName("n")
   public static int[] field3010;

   static {
      field3008 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field3010 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field3010[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjk;IIIZI)V",
      garbageValue = "916295819"
   )
   public static void method4631(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class229.field2694 = 1;
      class229.field2687 = var1;
      class229.field2691 = var2;
      AttackOption.field1331 = var3;
      class229.field2692 = var4;
      class37.field506 = var5;
      class284.field3699 = var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "81"
   )
   public static boolean method4630(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}

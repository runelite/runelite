import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public final class class5 {
   @ObfuscatedName("w")
   @Export("tileSettings")
   static byte[][][] field80 = new byte[4][104][104];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1497559615
   )
   static int field81 = 99;
   @ObfuscatedName("g")
   static byte[][][] field82;
   @ObfuscatedName("d")
   static final int[] field83 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("i")
   static int[] field84;
   @ObfuscatedName("x")
   static final int[] field85 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("h")
   public static int[] field86;
   @ObfuscatedName("q")
   static final int[] field87 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("u")
   static final int[] field88 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("t")
   static final int[] field89 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("e")
   @Export("tileHeights")
   static int[][][] field90 = new int[4][105][105];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1778670593
   )
   static int field91 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1254189395
   )
   static int field92 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("nn")
   static class56 field94;
   @ObfuscatedName("fz")
   @ObfuscatedGetter(
      intValue = -1235611013
   )
   @Export("cameraY")
   static int field95;
   @ObfuscatedName("b")
   static final int[] field96 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("a")
   static byte[][][] field98;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1111884787
   )
   static int field99;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -96798567
   )
   static int field100;
   @ObfuscatedName("s")
   static class167 field101;

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   static final void method60() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < client.field420 - 1; ++var1) {
            if(client.field301[var1] < 1000 && client.field301[var1 + 1] > 1000) {
               String var2 = client.field426[var1];
               client.field426[var1] = client.field426[1 + var1];
               client.field426[1 + var1] = var2;
               String var3 = client.field425[var1];
               client.field425[var1] = client.field425[var1 + 1];
               client.field425[var1 + 1] = var3;
               int var4 = client.field301[var1];
               client.field301[var1] = client.field301[1 + var1];
               client.field301[var1 + 1] = var4;
               var4 = client.field494[var1];
               client.field494[var1] = client.field494[var1 + 1];
               client.field494[var1 + 1] = var4;
               var4 = client.field422[var1];
               client.field422[var1] = client.field422[1 + var1];
               client.field422[1 + var1] = var4;
               var4 = client.field391[var1];
               client.field391[var1] = client.field391[var1 + 1];
               client.field391[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("l")
   public static void method76() {
      class51.field1086.method3760();
      class51.field1087.method3760();
      class51.field1129.method3760();
   }

   @ObfuscatedName("x")
   static final void method90() {
      class46.field1026.method3760();
      class41.field950.method3760();
      class167.method3320();
      class40.field928.method3760();
      class40.field902.method3760();
      class40.field903.method3760();
      class40.field904.method3760();
      class21.method578();
      method76();
      class42.field964.method3760();
      class42.field963.method3760();
      class43.field984.method3760();
      class43.field985.method3760();
      class47.field1049.method3760();
      class50.method1014();
      class179.field2925.method3760();
      class87.method2090();
      ((class95)class91.field1569).method2205();
      class22.field582.method3760();
      class99.field1651.method3268();
      class216.field3157.method3268();
      class27.field659.method3268();
      class143.field2175.method3268();
      class32.field743.method3268();
      class24.field611.method3268();
      class19.field272.method3268();
      class17.field246.method3268();
      class124.field2023.method3268();
      class108.field1880.method3268();
      class82.field1406.method3268();
      class59.field1189.method3268();
   }
}

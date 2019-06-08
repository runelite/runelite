import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Tiles")
public final class Tiles {
   @ObfuscatedName("m")
   @Export("Tiles_heights")
   static int[][][] Tiles_heights;
   @ObfuscatedName("f")
   @Export("Tiles_renderFlags")
   static byte[][][] Tiles_renderFlags;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1454618167
   )
   @Export("Tiles_minPlane")
   static int Tiles_minPlane;
   @ObfuscatedName("w")
   @Export("__bq_w")
   static byte[][][] __bq_w;
   @ObfuscatedName("l")
   @Export("__bq_l")
   static byte[][][] __bq_l;
   @ObfuscatedName("a")
   @Export("__bq_a")
   static int[][][] __bq_a;
   @ObfuscatedName("t")
   @Export("__bq_t")
   static final int[] __bq_t;
   @ObfuscatedName("y")
   @Export("__bq_y")
   static final int[] __bq_y;
   @ObfuscatedName("h")
   @Export("__bq_h")
   static final int[] __bq_h;
   @ObfuscatedName("b")
   @Export("__bq_b")
   static final int[] __bq_b;
   @ObfuscatedName("c")
   @Export("__bq_c")
   static final int[] __bq_c;
   @ObfuscatedName("r")
   @Export("__bq_r")
   static final int[] __bq_r;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2142579405
   )
   @Export("__bq_p")
   static int __bq_p;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 834543729
   )
   @Export("__bq_v")
   static int __bq_v;

   static {
      Tiles_heights = new int[4][105][105];
      Tiles_renderFlags = new byte[4][104][104];
      Tiles_minPlane = 99;
      __bq_t = new int[]{1, 2, 4, 8};
      __bq_y = new int[]{16, 32, 64, 128};
      __bq_h = new int[]{1, 0, -1, 0};
      __bq_b = new int[]{0, -1, 0, 1};
      __bq_c = new int[]{1, -1, -1, 1};
      __bq_r = new int[]{-1, -1, 1, 1};
      __bq_p = (int)(Math.random() * 17.0D) - 8;
      __bq_v = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1832579963"
   )
   public static final void method1097(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         class309.PcmPlayer_sampleRate = var0;
         PcmPlayer.isStereo = var1;
         Login.pcmPlayerCount = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1525245246"
   )
   public static final void method1106(String var0, String var1, int var2, int var3, int var4, int var5) {
      class16.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
   }
}

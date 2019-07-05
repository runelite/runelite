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
   static byte[][][] field908;
   @ObfuscatedName("l")
   static byte[][][] field909;
   @ObfuscatedName("a")
   static int[][][] field910;
   @ObfuscatedName("t")
   static final int[] field911;
   @ObfuscatedName("y")
   static final int[] field912;
   @ObfuscatedName("h")
   static final int[] field913;
   @ObfuscatedName("b")
   static final int[] field914;
   @ObfuscatedName("c")
   static final int[] field915;
   @ObfuscatedName("r")
   static final int[] field916;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2142579405
   )
   static int field917;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 834543729
   )
   static int field918;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "1832579963"
   )
   public static final void method1097(int var0, boolean var1, int var2) {
      if (var0 >= 8000 && var0 <= 48000) {
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
   @Export("insertMenuItemNoShift")
   public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
      class16.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
   }

   static {
      Tiles_heights = new int[4][105][105];
      Tiles_renderFlags = new byte[4][104][104];
      Tiles_minPlane = 99;
      field911 = new int[]{1, 2, 4, 8};
      field912 = new int[]{16, 32, 64, 128};
      field913 = new int[]{1, 0, -1, 0};
      field914 = new int[]{0, -1, 0, 1};
      field915 = new int[]{1, -1, -1, 1};
      field916 = new int[]{-1, -1, 1, 1};
      field917 = (int)(Math.random() * 17.0D) - 8;
      field918 = (int)(Math.random() * 33.0D) - 16;
   }
}

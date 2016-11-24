import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class32 {
   @ObfuscatedName("w")
   static int[] field714 = new int[5];
   @ObfuscatedName("m")
   static int[] field716;
   @ObfuscatedName("r")
   static int[][] field718 = new int[5][5000];
   @ObfuscatedName("c")
   static int[] field719 = new int[1000];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1697834091
   )
   static int field720 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1915204755
   )
   static int field721 = 0;
   @ObfuscatedName("p")
   @Export("chatboxSegments")
   static String[] chatboxSegments = new String[1000];
   @ObfuscatedName("q")
   static Widget field723;
   @ObfuscatedName("y")
   static Calendar field724 = Calendar.getInstance();
   @ObfuscatedName("z")
   static class10[] field725 = new class10[50];
   @ObfuscatedName("e")
   static final String[] field727 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("dm")
   static int[] field728;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass166;B)V",
      garbageValue = "32"
   )
   static final void method705(class166 var0) {
      var0.method3232();
      int var1 = Client.localInteractingIndex;
      Player var2 = class40.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field265 = var1;
      int var3 = var0.method3237(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class16.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method240() << 6);
      var2.pathY[0] = var6 - Client.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method240() << 6);
      class166.plane = var2.field267 = var4;
      if(class45.field900[var1] != null) {
         var2.method230(class45.field900[var1]);
      }

      class45.field897 = 0;
      class45.field902[++class45.field897 - 1] = var1;
      class45.field898[var1] = 0;
      class45.field903 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method3237(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class45.field905[var7] = var11 + (var9 << 28) + (var10 << 14);
            class45.field906[var7] = 0;
            class45.field896[var7] = -1;
            class45.field904[++class45.field903 - 1] = var7;
            class45.field898[var7] = 0;
         }
      }

      var0.method3238();
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class203 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1406595507
   )
   public static int field2475;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   public static Track1 field2477;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static class204 field2473;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field2476;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 723911165
   )
   public static int field2482;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field2472;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 375915633
   )
   public static int field2474;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   static IndexedSprite[] field2478;

   static {
      field2475 = 0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   protected static final void method3705() {
      WidgetNode.timer.vmethod3003();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field672[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field680[var0] = 0L;
      }

      GameEngine.field666 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-51"
   )
   static int method3707(int var0, int var1, int var2) {
      return (class62.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class62.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "-23"
   )
   static void method3706(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method3706(var0, var1, var2, var5 - 1);
         method3706(var0, var1, var5 + 1, var3);
      }

   }
}

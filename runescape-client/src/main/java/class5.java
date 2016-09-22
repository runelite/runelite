import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class5 {
   @ObfuscatedName("l")
   static final int[] field76 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("s")
   static final int[] field78 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("r")
   static byte[][][] field79;
   @ObfuscatedName("n")
   static byte[][][] field80;
   @ObfuscatedName("g")
   static int[][] field81;
   @ObfuscatedName("o")
   static final int[] field82 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1668504033
   )
   static int field83 = 99;
   @ObfuscatedName("t")
   static class156 field84;
   @ObfuscatedName("e")
   static final int[] field85 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("h")
   static final int[] field86 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("d")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1787325817
   )
   static int field88 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("a")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 162359279
   )
   static int field90 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("y")
   static final int[] field91 = new int[]{16, 32, 64, 128};

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1826541641"
   )
   public static synchronized long method63() {
      long var0 = System.currentTimeMillis();
      if(var0 < class127.field2109) {
         class118.field2056 += class127.field2109 - var0;
      }

      class127.field2109 = var0;
      return class118.field2056 + var0;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "892620470"
   )
   static final void method87(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field217 == 0) {
         var1 = class16.region.method2022(var0.field232, var0.field218, var0.field219);
      }

      if(var0.field217 == 1) {
         var1 = class16.region.method2066(var0.field232, var0.field218, var0.field219);
      }

      if(var0.field217 == 2) {
         var1 = class16.region.method1976(var0.field232, var0.field218, var0.field219);
      }

      if(var0.field217 == 3) {
         var1 = class16.region.method1977(var0.field232, var0.field218, var0.field219);
      }

      if(var1 != 0) {
         int var5 = class16.region.method2033(var0.field232, var0.field218, var0.field219, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field220 = var2;
      var0.field222 = var3;
      var0.field221 = var4;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-748136187"
   )
   static final void method88() {
      Client.field325.method2784();
      int var0 = Client.field325.method2792(8);
      int var1;
      if(var0 < Client.field319) {
         for(var1 = var0; var1 < Client.field319; ++var1) {
            Client.field407[++Client.field406 - 1] = Client.field320[var1];
         }
      }

      if(var0 > Client.field319) {
         throw new RuntimeException("");
      } else {
         Client.field319 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field320[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.field325.method2792(1);
            if(var4 == 0) {
               Client.field320[++Client.field319 - 1] = var2;
               var3.field886 = Client.gameCycle;
            } else {
               int var5 = Client.field325.method2792(2);
               if(var5 == 0) {
                  Client.field320[++Client.field319 - 1] = var2;
                  var3.field886 = Client.gameCycle;
                  Client.field399[++Client.field321 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field320[++Client.field319 - 1] = var2;
                     var3.field886 = Client.gameCycle;
                     var6 = Client.field325.method2792(3);
                     var3.method750(var6, (byte)1);
                     var7 = Client.field325.method2792(1);
                     if(var7 == 1) {
                        Client.field399[++Client.field321 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field320[++Client.field319 - 1] = var2;
                     var3.field886 = Client.gameCycle;
                     var6 = Client.field325.method2792(3);
                     var3.method750(var6, (byte)2);
                     var7 = Client.field325.method2792(3);
                     var3.method750(var7, (byte)2);
                     int var8 = Client.field325.method2792(1);
                     if(var8 == 1) {
                        Client.field399[++Client.field321 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field407[++Client.field406 - 1] = var2;
                  }
               }
            }
         }

      }
   }
}

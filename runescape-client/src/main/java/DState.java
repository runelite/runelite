import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("DState")
public final class DState {
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 219472487
   )
   public static int field2348;
   @ObfuscatedName("d")
   final int field2349;
   @ObfuscatedName("q")
   final int field2324;
   @ObfuscatedName("x")
   final int field2328;
   @ObfuscatedName("y")
   final int field2326;
   @ObfuscatedName("e")
   final int field2327;
   @ObfuscatedName("f")
   final int field2337;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1419227975
   )
   @Export("next_in")
   int next_in;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -514916487
   )
   @Export("next_out")
   int next_out;
   @ObfuscatedName("m")
   int[] field2323;
   @ObfuscatedName("h")
   int[] field2346;
   @ObfuscatedName("am")
   @Export("inUse")
   boolean[] inUse;
   @ObfuscatedName("ac")
   boolean[] field2335;
   @ObfuscatedName("ax")
   @Export("seqToUnseq")
   byte[] seqToUnseq;
   @ObfuscatedName("at")
   byte[] field2343;
   @ObfuscatedName("v")
   @Export("strm")
   byte[] strm;
   @ObfuscatedName("ag")
   int[] field2352;
   @ObfuscatedName("ar")
   byte[] field2353;
   @ObfuscatedName("ae")
   byte[] field2325;
   @ObfuscatedName("r")
   @Export("out")
   byte[] out;
   @ObfuscatedName("ai")
   byte[][] field2355;
   @ObfuscatedName("au")
   int[][] field2356;
   @ObfuscatedName("ad")
   int[][] field2361;
   @ObfuscatedName("ah")
   int[][] field2358;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1997179591
   )
   int field2334;
   @ObfuscatedName("ao")
   int[] field2359;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1412656681
   )
   @Export("total_in_lo32")
   int total_in_lo32;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -555403793
   )
   @Export("total_in_hi32")
   int total_in_hi32;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1090833563
   )
   @Export("total_out_lo32")
   int total_out_lo32;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 579196889
   )
   @Export("total_out_hi32")
   int total_out_hi32;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2046301907
   )
   @Export("blockSize100k")
   int blockSize100k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1308397529
   )
   int field2341;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1622834189
   )
   @Export("nInUse")
   int nInUse;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1245002857
   )
   @Export("out_len")
   int out_len;
   @ObfuscatedName("p")
   @Export("out_ch")
   byte out_ch;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2001994055
   )
   @Export("tPos")
   int tPos;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2008388337
   )
   @Export("nblock_used")
   int nblock_used;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 692493305
   )
   @Export("k0")
   int k0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1273985769
   )
   int field2360;

   DState() {
      this.field2349 = 4096;
      this.field2324 = 16;
      this.field2328 = 258;
      this.field2326 = 6;
      this.field2327 = 50;
      this.field2337 = 18002;
      this.next_in = 0;
      this.next_out = 0;
      this.field2323 = new int[256];
      this.field2346 = new int[257];
      this.inUse = new boolean[256];
      this.field2335 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.field2343 = new byte[4096];
      this.field2352 = new int[16];
      this.field2353 = new byte[18002];
      this.field2325 = new byte[18002];
      this.field2355 = new byte[6][258];
      this.field2356 = new int[6][258];
      this.field2361 = new int[6][258];
      this.field2358 = new int[6][258];
      this.field2359 = new int[6];
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-772444402"
   )
   static final void method3183() {
      Client.field1002 = 0;
      int var0 = (class224.localPlayer.x >> 7) + class33.baseX;
      int var1 = (class224.localPlayer.y >> 7) + class17.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1002 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1002 = 1;
      }

      if(Client.field1002 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1002 = 0;
      }

   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lbg;IIII)V",
      garbageValue = "-2013283586"
   )
   static final void method3184(Player var0, int var1, int var2, int var3) {
      if(class224.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + DecorativeObject.method2921(var0.combatLevel, class224.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class164.addMenuEntry("Use", Client.field1037 + " " + "->" + " " + CacheFile.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((class96.field1481 & 8) == 8) {
                  class164.addMenuEntry(Client.field972, Client.field1042 + " " + "->" + " " + CacheFile.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(class91.field1393 == Client.field1117) {
                           continue;
                        }

                        if(class91.field1384 == Client.field1117 || Client.field1117 == class91.field1386 && var0.combatLevel > class224.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class224.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class224.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     class164.addMenuEntry(Client.playerOptions[var5], CacheFile.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = CacheFile.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}

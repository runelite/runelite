import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public final class class159 {
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1810136681
   )
   int field2218;
   @ObfuscatedName("y")
   final int field2219 = 16;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1015022753
   )
   int field2220;
   @ObfuscatedName("r")
   final int field2221 = 6;
   @ObfuscatedName("w")
   final int field2222 = 50;
   @ObfuscatedName("j")
   final int field2223 = 18002;
   @ObfuscatedName("q")
   byte[] field2224;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1456330587
   )
   int field2225 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1311292011
   )
   int field2226;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2078728595
   )
   int field2227;
   @ObfuscatedName("b")
   int[] field2228 = new int[256];
   @ObfuscatedName("ap")
   boolean[] field2229 = new boolean[256];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -846261349
   )
   int field2230;
   @ObfuscatedName("v")
   byte field2231;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -883939257
   )
   int field2232;
   @ObfuscatedName("ad")
   int[] field2233 = new int[6];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2005432545
   )
   int field2234;
   @ObfuscatedName("ar")
   int[][] field2235 = new int[6][258];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 144030493
   )
   int field2236;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1652620741
   )
   int field2237;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 381604511
   )
   int field2238;
   @ObfuscatedName("o")
   final int field2239 = 258;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 19950251
   )
   int field2240;
   @ObfuscatedName("e")
   int[] field2241 = new int[257];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -864771165
   )
   int field2242;
   @ObfuscatedName("k")
   final int field2243 = 4096;
   @ObfuscatedName("c")
   byte[] field2244;
   @ObfuscatedName("aw")
   byte[] field2245 = new byte[256];
   @ObfuscatedName("as")
   byte[] field2246 = new byte[4096];
   @ObfuscatedName("ah")
   int[] field2247 = new int[16];
   @ObfuscatedName("aa")
   byte[] field2248 = new byte[18002];
   @ObfuscatedName("ai")
   byte[] field2249 = new byte[18002];
   @ObfuscatedName("am")
   int[][] field2250 = new int[6][258];
   @ObfuscatedName("aj")
   int[][] field2251 = new int[6][258];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1625174931
   )
   int field2252 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1584308585
   )
   int field2253;
   @ObfuscatedName("af")
   byte[][] field2254 = new byte[6][258];
   @ObfuscatedName("aq")
   boolean[] field2255 = new boolean[16];

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1850282557"
   )
   static final void method2908(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field644 == 0) {
         var0.field638 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var10 = TextureProvider.getAnimation(var0.animation);
            if(var0.field645 > 0 && var10.precedenceAnimating == 0) {
               ++var0.field638;
               return;
            }

            if(var0.field645 <= 0 && var10.priority == 0) {
               ++var0.field638;
               return;
            }
         }

         int var1 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field597 * 64 + var0.pathX[var0.field644 - 1] * 128;
         int var4 = var0.field597 * 64 + var0.pathY[var0.field644 - 1] * 128;
         if(var1 < var3) {
            if(var2 < var4) {
               var0.field641 = 1280;
            } else if(var2 > var4) {
               var0.field641 = 1792;
            } else {
               var0.field641 = 1536;
            }
         } else if(var1 > var3) {
            if(var2 < var4) {
               var0.field641 = 768;
            } else if(var2 > var4) {
               var0.field641 = 256;
            } else {
               var0.field641 = 512;
            }
         } else if(var2 < var4) {
            var0.field641 = 1024;
         } else if(var2 > var4) {
            var0.field641 = 0;
         }

         byte var5 = var0.field594[var0.field644 - 1];
         if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field641 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field599;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field598;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field601;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field600;
            }

            if(var7 == -1) {
               var7 = var0.field598;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field641 != var0.angle && var0.interacting == -1 && var0.field643 != 0) {
                  var8 = 2;
               }

               if(var0.field644 > 2) {
                  var8 = 6;
               }

               if(var0.field644 > 3) {
                  var8 = 8;
               }

               if(var0.field638 > 0 && var0.field644 > 1) {
                  var8 = 8;
                  --var0.field638;
               }
            } else {
               if(var0.field644 > 1) {
                  var8 = 6;
               }

               if(var0.field644 > 2) {
                  var8 = 8;
               }

               if(var0.field638 > 0 && var0.field644 > 1) {
                  var8 = 8;
                  --var0.field638;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field598 == var0.poseAnimation && var0.field602 != -1) {
               var0.poseAnimation = var0.field602;
            }

            if(var3 != var1 || var2 != var4) {
               if(var1 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var1 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var0.x == var3 && var4 == var0.y) {
               --var0.field644;
               if(var0.field645 > 0) {
                  --var0.field645;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field644;
            if(var0.field645 > 0) {
               --var0.field645;
            }

         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "1462250730"
   )
   public static void method2909(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1910 = 1;
      class1.field10 = var0;
      class138.field1915 = var1;
      ChatLineBuffer.field971 = var2;
      class97.field1631 = var3;
      class138.field1912 = var4;
      class15.field165 = 10000;
   }
}

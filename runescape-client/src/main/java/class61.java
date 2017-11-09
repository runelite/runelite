import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public final class class61 {
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      longValue = -4419768154880236729L
   )
   static long field735;
   @ObfuscatedName("m")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("p")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1409881871
   )
   static int field725;
   @ObfuscatedName("j")
   static byte[][][] field726;
   @ObfuscatedName("x")
   static byte[][][] field727;
   @ObfuscatedName("l")
   static byte[][][] field738;
   @ObfuscatedName("n")
   static int[] field729;
   @ObfuscatedName("w")
   static int[] field728;
   @ObfuscatedName("r")
   static final int[] field723;
   @ObfuscatedName("g")
   static final int[] field732;
   @ObfuscatedName("z")
   static final int[] field733;
   @ObfuscatedName("o")
   static final int[] field734;
   @ObfuscatedName("d")
   static final int[] field724;
   @ObfuscatedName("s")
   static final int[] field736;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1281918547
   )
   static int field737;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1297416271
   )
   static int field730;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field725 = 99;
      field723 = new int[]{1, 2, 4, 8};
      field732 = new int[]{16, 32, 64, 128};
      field733 = new int[]{1, 0, -1, 0};
      field734 = new int[]{0, -1, 0, 1};
      field724 = new int[]{1, -1, -1, 1};
      field736 = new int[]{-1, -1, 1, 1};
      field737 = (int)(Math.random() * 17.0D) - 8;
      field730 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("m")
   public static final void method1130(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var8) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkl;I)I",
      garbageValue = "1294316004"
   )
   static final int method1126(class298 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3919) {
         case 1:
            return 20;
         default:
            return 12;
         }
      }
   }
}

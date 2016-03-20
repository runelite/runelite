import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("e")
public final class class5 {
   @ObfuscatedName("j")
   static int[][] field71;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1414126985
   )
   static int field72 = 99;
   @ObfuscatedName("g")
   static byte[][][] field73;
   @ObfuscatedName("s")
   static byte[][][] field74;
   @ObfuscatedName("y")
   static byte[][][] field75;
   @ObfuscatedName("e")
   static byte[][][] field76;
   @ObfuscatedName("w")
   static final int[] field77 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("m")
   static byte[][][] field78;
   @ObfuscatedName("q")
   static final int[] field79 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("z")
   static int[][][] field80;
   @ObfuscatedName("c")
   static final int[] field81 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("x")
   static final int[] field82 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("d")
   static final int[] field83 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("p")
   static final int[] field84 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("a")
   @Export("tileHeights")
   static int[][][] field86 = new int[4][105][105];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1765698797
   )
   static int field87 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1937801931
   )
   static int field88 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("r")
   @Export("tileSettings")
   static byte[][][] field90 = new byte[4][104][104];

   @ObfuscatedName("l")
   static class102 method83(int var0) {
      class102 var1 = (class102)class42.field1004.method3792((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = class22.method575(class42.field984, class42.field985, var0, false);
         if(var1 != null) {
            class42.field1004.method3794(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("a")
   static boolean method99() {
      try {
         if(class107.field1879 == null) {
            class107.field1879 = new class18(class129.field2056, new URL(class208.field3114));
         } else {
            byte[] var0 = class107.field1879.method206();
            if(null != var0) {
               class118 var1 = new class118(var0);
               class25.field634 = var1.method2514();
               class25.field633 = new class25[class25.field634];

               class25 var3;
               for(int var2 = 0; var2 < class25.field634; var3.field641 = var2++) {
                  var3 = class25.field633[var2] = new class25();
                  var3.field638 = var1.method2514();
                  var3.field639 = var1.method2517();
                  var3.field630 = var1.method2520();
                  var3.field643 = var1.method2520();
                  var3.field644 = var1.method2579();
                  var3.field635 = var1.method2515();
               }

               class4.method53(class25.field633, 0, class25.field633.length - 1, class25.field637, class25.field636);
               class107.field1879 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class107.field1879 = null;
      }

      return false;
   }

   @ObfuscatedName("a")
   public static int method100(int var0, int var1, int var2) {
      var2 &= 3;
      return 0 == var2?var0:(var2 == 1?var1:(2 == var2?7 - var0:7 - var1));
   }

   @ObfuscatedName("a")
   public static class52 method101(int var0) {
      class52 var1 = (class52)class52.field1164.method3792((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1156.method3263(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1100(new class118(var2));
         }

         class52.field1164.method3794(var1, (long)var0);
         return var1;
      }
   }
}

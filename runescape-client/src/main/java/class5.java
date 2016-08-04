import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public final class class5 {
   @ObfuscatedName("g")
   @Export("tileSettings")
   static byte[][][] field80 = new byte[4][104][104];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1822763461
   )
   static int field81 = 99;
   @ObfuscatedName("e")
   static byte[][][] field82;
   @ObfuscatedName("b")
   static int[] field83;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1493846247
   )
   static int field84 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("l")
   @Export("tileHeights")
   static int[][][] field85 = new int[4][105][105];
   @ObfuscatedName("k")
   static byte[][][] field86;
   @ObfuscatedName("m")
   static int[] field87;
   @ObfuscatedName("s")
   static byte[][][] field88;
   @ObfuscatedName("i")
   static final int[] field90 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("v")
   static final int[] field91 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("j")
   static final int[] field92 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("y")
   static final int[] field93 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("t")
   static final int[] field94 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("q")
   static int[] field96;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -898081551
   )
   static int field97 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("x")
   static final int[] field98 = new int[]{0, -1, 0, 1};

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Lclass51;",
      garbageValue = "-18"
   )
   public static class51 method52(int var0) {
      class51 var1 = (class51)class51.field1128.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1134.method3411(32, var0);
         var1 = new class51();
         if(var2 != null) {
            var1.method1079(new class122(var2));
         }

         class51.field1128.method3907(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-6"
   )
   static void method89() {
      class11.field182.clear();
      class11.field174.method3949();
      class11.field173.method4002();
      class11.field184 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1948876053"
   )
   public static int method91(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}

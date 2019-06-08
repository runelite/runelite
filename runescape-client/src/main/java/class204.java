import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class204 {
   @ObfuscatedName("x")
   @Export("__gx_x")
   static final int[] __gx_x;
   @ObfuscatedName("d")
   @Export("__gx_d")
   static final int[] __gx_d;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("__gx_n")
   public static Font __gx_n;

   static {
      __gx_x = new int[2048];
      __gx_d = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         __gx_x[var2] = (int)(65536.0D * Math.sin(var0 * (double)var2));
         __gx_d[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Lho;",
      garbageValue = "-1975300504"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = Huffman.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "0"
   )
   public static void method4011(AbstractIndexCache var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getArchiveId(var1);
      int var6 = var0.getRecordId(var5, var2);
      Login.method2076(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lfy;B)V",
      garbageValue = "64"
   )
   static final void method4013(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionMap[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var21 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < var6 + 8) {
                  int var15 = var2 + CollisionMap.method3632(var11 & 7, var12 & 7, var7);
                  int var18 = var11 & 7;
                  int var19 = var12 & 7;
                  int var20 = var7 & 3;
                  int var17;
                  if(var20 == 0) {
                     var17 = var19;
                  } else if(var20 == 1) {
                     var17 = 7 - var18;
                  } else if(var20 == 2) {
                     var17 = 7 - var19;
                  } else {
                     var17 = var18;
                  }

                  TotalQuantityComparator.loadTerrain(var21, var1, var15, var3 + var17, 0, 0, var7);
               } else {
                  TotalQuantityComparator.loadTerrain(var21, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}

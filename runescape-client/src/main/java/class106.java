import java.awt.Image;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class106 {
   @ObfuscatedName("d")
   public static int[][] field1851 = new int[128][128];
   @ObfuscatedName("j")
   public static int[][] field1853 = new int[128][128];
   @ObfuscatedName("qw")
   protected static Image field1854;
   @ObfuscatedName("c")
   public static int[] field1856 = new int[4096];
   @ObfuscatedName("l")
   public static int[] field1857 = new int[4096];

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-499585730"
   )
   static final void method2375(int var0, int var1) {
      if(client.field429 >= 2 || client.field352 != 0 || client.field442) {
         String var2;
         if(client.field352 == 1 && client.field429 < 2) {
            var2 = "Use" + " " + client.field349 + " " + "->";
         } else if(client.field442 && client.field429 < 2) {
            var2 = client.field445 + " " + client.field446 + " " + "->";
         } else {
            int var4 = client.field429 - 1;
            String var3;
            if(client.field396[var4].length() > 0) {
               var3 = client.field434[var4] + " " + client.field396[var4];
            } else {
               var3 = client.field434[var4];
            }

            var2 = var3;
         }

         if(client.field429 > 2) {
            var2 = var2 + class158.method3184(16777215) + " " + '/' + " " + (client.field429 - 2) + " more options";
         }

         class162.field2636.method4024(var2, var0 + 4, 15 + var1, 16777215, 0, client.field296 / 1000);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lclass50;",
      garbageValue = "-99"
   )
   public static class50 method2382(int var0) {
      class50 var1 = (class50)class50.field1069.method3764((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class50.field1070.method3266(5, var0);
         var1 = new class50();
         if(null != var2) {
            var1.method1008(new class119(var2));
         }

         class50.field1069.method3759(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   static final void method2383(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field541 + (client.field542 - client.field541) * var5 / 100;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < client.field328) {
         var15 = client.field328;
         var6 = 334 * var2 * var15 / (var3 * 512);
         if(var6 > client.field546) {
            var6 = client.field546;
            var8 = var3 * var6 * 512 / (334 * var15);
            var9 = (var2 - var8) / 2;
            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > client.field516) {
         var15 = client.field516;
         var6 = 334 * var2 * var15 / (512 * var3);
         if(var6 < client.field547) {
            var6 = client.field547;
            var8 = var2 * var15 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = (client.field537 - client.field543) * var5 / 100 + client.field543;
      client.field553 = var3 * var6 * var8 / 85504 << 1;
      if(var2 != client.field551 || var3 != client.field552) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 128 + 32 * var10 + 15;
            int var12 = 600 + var11 * 3;
            int var13 = class91.field1563[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         class86.method1992(var14, 500, 800, var2, var3);
      }

      client.field549 = var0;
      client.field550 = var1;
      client.field551 = var2;
      client.field552 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass0;B)V",
      garbageValue = "19"
   )
   static void method2384(class0 var0) {
      class90.method2092(var0, 200000);
   }
}

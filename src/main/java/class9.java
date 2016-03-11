import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class9 {
   @ObfuscatedName("f")
   static final BigInteger field156 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("m")
   static final BigInteger field157 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass37;B)V",
      garbageValue = "2"
   )
   static final void method115(class37 var0) {
      if(0 != var0.field862) {
         if(-1 != var0.field835) {
            Object var1 = null;
            if(var0.field835 < '耀') {
               var1 = client.field324[var0.field835];
            } else if(var0.field835 >= '耀') {
               var1 = client.field410[var0.field835 - '耀'];
            }

            if(null != var1) {
               int var2 = var0.field839 - ((class37)var1).field839;
               int var3 = var0.field848 - ((class37)var1).field848;
               if(0 != var2 || 0 != var3) {
                  var0.field860 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field836) {
               var0.field835 = -1;
               var0.field836 = false;
            }
         }

         if(-1 != var0.field853 && (0 == var0.field824 || var0.field867 > 0)) {
            var0.field860 = var0.field853;
            var0.field853 = -1;
         }

         int var4 = var0.field860 - var0.field852 & 2047;
         if(var4 == 0 && var0.field836) {
            var0.field835 = -1;
            var0.field836 = false;
         }

         if(var4 != 0) {
            ++var0.field861;
            boolean var5;
            if(var4 > 1024) {
               var0.field852 -= var0.field862;
               var5 = true;
               if(var4 < var0.field862 || var4 > 2048 - var0.field862) {
                  var0.field852 = var0.field860;
                  var5 = false;
               }

               if(var0.field838 == var0.field815 && (var0.field861 > 25 || var5)) {
                  if(-1 != var0.field816) {
                     var0.field838 = var0.field816;
                  } else {
                     var0.field838 = var0.field818;
                  }
               }
            } else {
               var0.field852 += var0.field862;
               var5 = true;
               if(var4 < var0.field862 || var4 > 2048 - var0.field862) {
                  var0.field852 = var0.field860;
                  var5 = false;
               }

               if(var0.field838 == var0.field815 && (var0.field861 > 25 || var5)) {
                  if(-1 != var0.field857) {
                     var0.field838 = var0.field857;
                  } else {
                     var0.field838 = var0.field818;
                  }
               }
            }

            var0.field852 &= 2047;
         } else {
            var0.field861 = 0;
         }

      }
   }

   @ObfuscatedName("du")
   static final boolean method121(class172 var0) {
      int var1 = var0.field2763;
      if(205 == var1) {
         client.field339 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field475.method3436(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field475.method3434(var2, var3 == 1);
         }

         if(324 == var1) {
            client.field475.method3441(false);
         }

         if(var1 == 325) {
            client.field475.method3441(true);
         }

         if(var1 == 326) {
            client.field329.method2686(123);
            client.field475.method3454(client.field329);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("o")
   static class25 method122() {
      class25.field634 = 0;
      return class83.method1867();
   }

   @ObfuscatedName("m")
   static void method123(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class171 var4 = (class171)class170.field2728.method3744(var2);
      if(var4 != null) {
         class170.field2727.method3818(var4);
      }
   }

   @ObfuscatedName("h")
   static final int method124(int var0, int var1) {
      int var2 = class184.method3675('넵' + var0, 91923 + var1, 4) - 128 + (class184.method3675(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class184.method3675(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}

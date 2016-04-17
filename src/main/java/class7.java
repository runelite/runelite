import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("dy")
   static byte[][] field136;
   @ObfuscatedName("w")
   @Export("previousName")
   String field137;
   @ObfuscatedName("a")
   @Export("name")
   String field140;
   @ObfuscatedName("ab")
   static boolean field143;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "1408916431"
   )
   public static class48 method138(int var0) {
      class48 var1 = (class48)class48.field1079.method3840((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class48.field1088.method3403(8, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method1097(new class119(var2));
         }

         class48.field1079.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "22"
   )
   static final void method139(boolean var0) {
      while(true) {
         if(client.field441.method2892(client.field341) >= 27) {
            int var1 = client.field441.method2863(15);
            if(32767 != var1) {
               boolean var2 = false;
               if(null == client.field546[var1]) {
                  client.field546[var1] = new class34();
                  var2 = true;
               }

               class34 var3 = client.field546[var1];
               client.field335[++client.field343 - 1] = var1;
               var3.field823 = client.field306;
               int var4 = client.field423[client.field441.method2863(3)];
               if(var2) {
                  var3.field853 = var3.field863 = var4;
               }

               var3.field784 = class28.method734(client.field441.method2863(14));
               int var5;
               if(var0) {
                  var5 = client.field441.method2863(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = client.field441.method2863(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = client.field441.method2863(1);
               if(var6 == 1) {
                  client.field337[++client.field336 - 1] = var1;
               }

               int var7 = client.field441.method2863(1);
               int var8;
               if(var0) {
                  var8 = client.field441.method2863(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = client.field441.method2863(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field841 = var3.field784.field887;
               var3.field869 = var3.field784.field915;
               if(var3.field869 == 0) {
                  var3.field863 = 0;
               }

               var3.field825 = var3.field784.field904;
               var3.field839 = var3.field784.field911;
               var3.field836 = var3.field784.field900;
               var3.field828 = var3.field784.field901;
               var3.field822 = var3.field784.field895;
               var3.field878 = var3.field784.field913;
               var3.field824 = var3.field784.field897;
               var3.method808(class5.field93.field871[0] + var8, class5.field93.field835[0] + var5, 1 == var7);
               continue;
            }
         }

         client.field441.method2868();
         return;
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-71"
   )
   static final void method140(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class34.method816(var0, var1, class42.field1002) - var2;
         var0 -= class26.field673;
         var3 -= class46.field1070;
         var1 -= class137.field2129;
         int var4 = class91.field1593[class59.field1227];
         int var5 = class91.field1594[class59.field1227];
         int var6 = class91.field1593[class113.field1958];
         int var7 = class91.field1594[class113.field1958];
         int var8 = var6 * var1 + var7 * var0 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            client.field400 = client.field558 / 2 + client.field560 * var0 / var1;
            client.field293 = client.field456 / 2 + var8 * client.field560 / var1;
         } else {
            client.field400 = -1;
            client.field293 = -1;
         }

      } else {
         client.field400 = -1;
         client.field293 = -1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-685268489"
   )
   public static void method141() {
      class40.field958.method3843();
      class40.field926.method3843();
      class40.field927.method3843();
      class40.field924.method3843();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1128953794"
   )
   static final void method142() {
      if(null != class127.field2047) {
         class127.field2047.method3095();
         class127.field2047 = null;
      }

      class3.method48();
      class30.field717.method2042();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field361[var0].method2488();
      }

      System.gc();
      class170.method3462(2);
      client.field532 = -1;
      client.field299 = false;

      for(class23 var1 = (class23)class23.field627.method3926(); null != var1; var1 = (class23)class23.field627.method3902()) {
         if(var1.field615 != null) {
            class10.field178.method1235(var1.field615);
            var1.field615 = null;
         }

         if(null != var1.field623) {
            class10.field178.method1235(var1.field623);
            var1.field623 = null;
         }
      }

      class23.field627.method3898();
      class3.method49(10);
   }
}

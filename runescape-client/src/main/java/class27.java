import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("ChatLineBuffer")
public class class27 {
   @ObfuscatedName("ab")
   static int[] field665;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1962396899
   )
   @Export("length")
   int field667;
   @ObfuscatedName("n")
   static int[] field670;
   @ObfuscatedName("j")
   @Export("lines")
   class35[] field673 = new class35[100];
   @ObfuscatedName("c")
   static class80 field678;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lclass35;",
      garbageValue = "-358068472"
   )
   class35 method621(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field673[99];

      for(int var6 = this.field667; var6 > 0; --var6) {
         if(100 != var6) {
            this.field673[var6] = this.field673[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3898();
         var5.method3876();
         var5.method713(var1, var2, var4, var3);
      }

      this.field673[0] = var5;
      if(this.field667 < 100) {
         ++this.field667;
      }

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-24306"
   )
   int method623() {
      return this.field667;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lclass35;",
      garbageValue = "-1260971669"
   )
   static class35 method630(int var0, int var1) {
      class27 var2 = (class27)class11.field168.get(Integer.valueOf(var0));
      return var2.method631(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass35;",
      garbageValue = "-742670079"
   )
   class35 method631(int var1) {
      return var1 >= 0 && var1 < this.field667?this.field673[var1]:null;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-901901879"
   )
   static final void method632(boolean var0) {
      while(true) {
         if(client.field324.method2741(client.field325) >= 27) {
            int var1 = client.field324.method2750(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(client.field515[var1] == null) {
                  client.field515[var1] = new class34();
                  var2 = true;
               }

               class34 var3 = client.field515[var1];
               client.field318[++client.field317 - 1] = var1;
               var3.field864 = client.field335;
               int var4;
               if(var0) {
                  var4 = client.field324.method2750(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = client.field324.method2750(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               int var5 = client.field484[client.field324.method2750(3)];
               if(var2) {
                  var3.field814 = var5 * 1944410881;
                  var3.field862 = var5;
               }

               int var6 = client.field324.method2750(1);
               int var7 = client.field324.method2750(1);
               if(var7 == 1) {
                  client.field320[++client.field319 - 1] = var1;
               }

               int var8;
               if(var0) {
                  var8 = client.field324.method2750(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = client.field324.method2750(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.field782 = class99.method2179(client.field324.method2750(14));
               var3.field872 = var3.field782.field887;
               var3.field852 = var3.field782.field895;
               if(var3.field852 == 0) {
                  var3.field814 = 0;
               }

               var3.field820 = var3.field782.field894;
               var3.field821 = var3.field782.field909;
               var3.field847 = var3.field782.field892;
               var3.field855 = var3.field782.field897;
               var3.field817 = var3.field782.field914;
               var3.field860 = var3.field782.field899;
               var3.field839 = var3.field782.field893;
               var3.method697(class106.field1881.field866[0] + var4, class106.field1881.field863[0] + var8, 1 == var6);
               continue;
            }
         }

         client.field324.method2740();
         return;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1001313700"
   )
   public static void method633() {
      class76.field1387 = null;
      class76.field1390 = null;
      class76.field1389 = null;
      class9.field159 = null;
      class76.field1396 = null;
      class21.field575 = (byte[][])((byte[][])null);
   }
}

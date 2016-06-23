import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class26 {
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -888153895
   )
   @Export("cameraY")
   static int field665;
   @ObfuscatedName("bo")
   static class80[] field666;

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "104"
   )
   static final void method672(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field490; ++var4) {
         if(client.field497[var4] + client.field495[var4] > var0 && client.field495[var4] < var0 + var2 && client.field496[var4] + client.field498[var4] > var1 && client.field496[var4] < var1 + var3) {
            client.field516[var4] = true;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "126307217"
   )
   static boolean method673(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-684736930"
   )
   public static final boolean method674(String var0, String var1, String var2, String var3) {
      return null != var0 && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "82932131"
   )
   public static void method675(Applet var0, String var1) {
      class138.field2136 = var0;
      class138.field2133 = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-498265302"
   )
   static final void method676(int var0, int var1, int var2, int var3) {
      if(client.field394 == 1) {
         class30.field711[client.field511 / 100].method1763(client.field346 - 8, client.field398 - 8);
      }

      if(client.field394 == 2) {
         class30.field711[client.field511 / 100 + 4].method1763(client.field346 - 8, client.field398 - 8);
      }

      client.field409 = 0;
      int var4 = (class15.field225.field837 >> 7) + class172.field2734;
      int var5 = class20.field576 + (class15.field225.field880 >> 7);
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         client.field409 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         client.field409 = 1;
      }

      if(client.field409 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         client.field409 = 0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1409181419"
   )
   static void method677(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field229.method3822((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field229.method3826(var4, (long)var0);
      }

      if(var4.field221.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field221.length; ++var7) {
            var5[var7] = var4.field221[var7];
            var6[var7] = var4.field223[var7];
         }

         for(var7 = var4.field221.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field221 = var5;
         var4.field223 = var6;
      }

      var4.field221[var1] = var2;
      var4.field223[var1] = var3;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "683651784"
   )
   static void method678(int var0, int var1) {
      client.field333.method2773(89);
      client.field333.method2595(var0);
      client.field333.method2540(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "773489012"
   )
   static final int method679(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class91.field1577[1024 * var2 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var1 * var4 >> 16);
   }
}

import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class114 {
   @ObfuscatedName("y")
   public static String field1785 = null;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 148386865
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("k")
   public static Applet field1792 = null;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1114017266"
   )
   public static void method2187(class182 var0) {
      class151.field2186 = var0;
   }

   class114() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "554636484"
   )
   static final void method2188() {
      if(null != class177.field2657) {
         class177.field2657.method2064();
         class177.field2657 = null;
      }

      class45.method827();
      class65.region.method1707();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2240();
      }

      System.gc();
      class103.method1966(2);
      Client.field516 = -1;
      Client.field517 = false;

      for(class31 var1 = (class31)class31.field693.method2403(); null != var1; var1 = (class31)class31.field693.method2398()) {
         if(null != var1.field700) {
            class164.field2290.method919(var1.field700);
            var1.field700 = null;
         }

         if(var1.field705 != null) {
            class164.field2290.method919(var1.field705);
            var1.field705 = null;
         }
      }

      class31.field693.method2379();
      class11.setGameState(10);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[Lclass177;",
      garbageValue = "-1401987844"
   )
   public static class177[] method2189() {
      return new class177[]{class177.field2648, class177.field2655, class177.field2652, class177.field2649, class177.field2650, class177.field2651};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-40"
   )
   static String method2191(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZI)V",
      garbageValue = "708542427"
   )
   public static void method2192(class182 var0, class182 var1, boolean var2) {
      ObjectComposition.field2875 = var0;
      class176.field2641 = var1;
      ObjectComposition.field2878 = var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass15;B)V",
      garbageValue = "79"
   )
   static final void method2193(class15 var0) {
      if(VertexNormal.localPlayer.x >> 7 == Client.flagX && Client.flagY == VertexNormal.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class45.field901;
      int[] var2 = class45.field902;
      int var3 = var1;
      if(var0 == class15.field166 || var0 == class15.field163) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class15.field166 == var0) {
            var5 = VertexNormal.localPlayer;
            var6 = VertexNormal.localPlayer.field256 << 14;
         } else if(class15.field163 == var0) {
            var5 = Client.cachedPlayers[Client.field407];
            var6 = Client.field407 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class15.field164 == var0 && Client.field407 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod736() && !var5.field262) {
            var5.field260 = false;
            if((Client.field278 && var1 > 50 || var1 > 200) && class15.field166 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field260 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field251) {
                  var5.field260 = false;
                  var5.field249 = Renderable.method1883(var5.x, var5.y, class48.plane);
                  class65.region.method1719(class48.plane, var5.x, var5.y, var5.field249, 60, var5, var5.angle, var6, var5.field264, var5.field254, var5.field250, var5.field259);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field451 == Client.field404[var7][var8]) {
                        continue;
                     }

                     Client.field404[var7][var8] = Client.field451;
                  }

                  var5.field249 = Renderable.method1883(var5.x, var5.y, class48.plane);
                  class65.region.method1718(class48.plane, var5.x, var5.y, var5.field249, 60, var5, var5.angle, var6, var5.field593);
               }
            }
         }
      }

   }
}

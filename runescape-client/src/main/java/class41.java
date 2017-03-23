import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class41 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2047806507
   )
   static int field845;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -564104197
   )
   static int field846 = 0;
   @ObfuscatedName("d")
   static ModIcon field847;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1727605419
   )
   static int field848;
   @ObfuscatedName("aw")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("u")
   static SpritePixels field850;
   @ObfuscatedName("y")
   static ModIcon field851;
   @ObfuscatedName("e")
   static ModIcon field852;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1388417139
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("am")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("z")
   static int[] field857;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2075647713
   )
   static int field858;
   @ObfuscatedName("i")
   static int[] field859;
   @ObfuscatedName("o")
   static int[] field860;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1737133199
   )
   static int field861;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 902248849
   )
   static int field862;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1595822077
   )
   static int field863;
   @ObfuscatedName("ay")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1836993881
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("at")
   static String field866;
   @ObfuscatedName("x")
   static boolean field868;
   @ObfuscatedName("ao")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ae")
   static String field870;
   @ObfuscatedName("ak")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1441362941
   )
   static int field872;
   @ObfuscatedName("aq")
   @Export("password")
   static String password;
   @ObfuscatedName("aj")
   static class97 field874;
   @ObfuscatedName("ac")
   static boolean field875;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -516507145
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1111277645
   )
   static int field879;
   @ObfuscatedName("h")
   static SpritePixels field880;
   @ObfuscatedName("c")
   static ModIcon field882;

   static {
      loginWindowX = 202 + field846;
      field859 = new int[256];
      field858 = 0;
      field845 = 0;
      field861 = 0;
      field879 = 0;
      field863 = 0;
      field862 = 0;
      field872 = 10;
      field866 = "";
      loginIndex = 0;
      field870 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field874 = class97.field1640;
      field875 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field848 = -1;
   }

   class41() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   public static void method837() {
      ObjectComposition.field2937.reset();
      ObjectComposition.field2897.reset();
      ObjectComposition.field2898.reset();
      ObjectComposition.field2899.reset();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   static final void method852() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2448(); var0 != null; var0 = (Projectile)Client.projectiles.method2445()) {
         if(var0.floor == class31.plane && Client.gameCycle <= var0.field890) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method862(var1.x, var1.y, class1.method21(var1.x, var1.y, var0.floor) - var0.field894, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class22.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(null != var3 && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method862(var3.x, var3.y, class1.method21(var3.x, var3.y, var0.floor) - var0.field894, Client.gameCycle);
                  }
               }

               var0.method861(Client.field328);
               Friend.region.method1765(class31.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field887, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1950384954"
   )
   static byte[] method856(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}

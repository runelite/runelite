import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class41 {
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -145904815
   )
   static int field834;
   @ObfuscatedName("u")
   static ModIcon field836;
   @ObfuscatedName("r")
   static ModIcon[] field837;
   @ObfuscatedName("o")
   static SpritePixels field838;
   @ObfuscatedName("n")
   static ModIcon field839;
   @ObfuscatedName("m")
   static ModIcon[] field840;
   @ObfuscatedName("v")
   static int[] field843;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1184643091
   )
   static int field844;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1701645463
   )
   static int field845;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1818796025
   )
   static int field846;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -156416559
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -82542839
   )
   static int field849;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -788203553
   )
   static int field850;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 765839835
   )
   static int field851;
   @ObfuscatedName("ax")
   static String field852;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -945652867
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ak")
   static String field854;
   @ObfuscatedName("ai")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 385641765
   )
   static int field856;
   @ObfuscatedName("au")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   static class97 field858;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 756595681
   )
   static int field859 = 0;
   @ObfuscatedName("f")
   static boolean field860;
   @ObfuscatedName("ae")
   static boolean field861;
   @ObfuscatedName("ap")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aj")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ay")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 598659993
   )
   static int field866;
   @ObfuscatedName("b")
   static int[] field867;
   @ObfuscatedName("at")
   @Export("password")
   static String password;
   @ObfuscatedName("dz")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1724044623
   )
   @Export("loginIndex2")
   static int loginIndex2;

   class41() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1678269181"
   )
   static final void method812(boolean var0) {
      World.method596();
      ++Client.field436;
      if(Client.field436 >= 50 || var0) {
         Client.field436 = 0;
         if(!Client.field517 && class20.rssocket != null) {
            Client.secretCipherBuffer1.putOpcode(210);

            try {
               class20.rssocket.queueForWrite(Client.secretCipherBuffer1.payload, 0, Client.secretCipherBuffer1.offset);
               Client.secretCipherBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field517 = true;
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Z",
      garbageValue = "0"
   )
   static boolean method813(String var0, int var1) {
      return class112.method2141(var0, var1, "openjs");
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BS)[B",
      garbageValue = "-1305"
   )
   static byte[] method814(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "54"
   )
   static final void method815(int var0, int var1) {
      int var2 = class63.field1119.method3897("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         Font var4 = class63.field1119;
         String var5;
         if(var3 < 0) {
            var5 = "";
         } else if(Client.menuTargets[var3].length() > 0) {
            var5 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var5 = Client.menuOptions[var3];
         }

         int var6 = var4.method3897(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > class32.field755) {
         var7 = class32.field755 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var8 = var1;
      if(var3 + var1 > class168.field2207) {
         var8 = class168.field2207 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      CombatInfo1.region.method1773(Sequence.plane, var0, var1, false);
      Client.isMenuOpen = true;
      World.menuX = var7;
      class104.menuY = var8;
      Widget.menuWidth = var2;
      class97.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   static {
      loginWindowX = field859 + 202;
      field843 = new int[256];
      field845 = 0;
      field846 = 0;
      field856 = 0;
      field844 = 0;
      field849 = 0;
      field850 = 0;
      field851 = 10;
      field852 = "";
      loginIndex = 0;
      field854 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field858 = class97.field1651;
      field861 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field866 = -1;
   }
}

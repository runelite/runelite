import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class41 {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 631216723
   )
   static int field838;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2040671971
   )
   static int field839 = 0;
   @ObfuscatedName("q")
   static boolean field841;
   @ObfuscatedName("m")
   static ModIcon field842;
   @ObfuscatedName("gc")
   static Widget field843;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1581039503
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("t")
   static int[] field846;
   @ObfuscatedName("y")
   static int[] field847;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 75892571
   )
   static int field848;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 569669247
   )
   static int field849;
   @ObfuscatedName("av")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1261268447
   )
   static int field851;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 678742627
   )
   static int field852;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1624825421
   )
   static int field853;
   @ObfuscatedName("g")
   static int[] field854;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1748391863
   )
   static int field855;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1597557731
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("as")
   static String field859;
   @ObfuscatedName("aa")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ah")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("r")
   static int[] field862;
   @ObfuscatedName("aw")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ap")
   static String field864;
   @ObfuscatedName("ak")
   static class97 field865;
   @ObfuscatedName("an")
   static boolean field866;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -72878417
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 2118621693
   )
   static int field868;
   @ObfuscatedName("aj")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("h")
   static ModIcon field871;
   @ObfuscatedName("ae")
   static int[] field872;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 1825533003
   )
   static int field873;
   @ObfuscatedName("i")
   static ModIcon[] field874;
   @ObfuscatedName("ac")
   static String field876;

   static {
      loginWindowX = 202 + field839;
      field846 = new int[256];
      field848 = 0;
      field849 = 0;
      field852 = 0;
      field853 = 0;
      field838 = 0;
      field855 = 0;
      field851 = 10;
      field876 = "";
      loginIndex = 0;
      field859 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field864 = "";
      field865 = class97.field1634;
      field866 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field868 = -1;
   }

   class41() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "210128019"
   )
   static class184 method865(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(class104.field1695 != null) {
         var4 = new class116(var0, class104.field1695, TextureProvider.field1222[var0], 1000000);
      }

      return new class184(var4, class187.field2781, var0, var1, var2, var3);
   }
}

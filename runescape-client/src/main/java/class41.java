import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class41 {
   @ObfuscatedName("g")
   static ModIcon field821;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2040021115
   )
   static int field822 = 0;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -941180687
   )
   static int field823;
   @ObfuscatedName("p")
   static SpritePixels field824;
   @ObfuscatedName("j")
   static SpritePixels field825;
   @ObfuscatedName("v")
   static ModIcon field826;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1653225779
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("w")
   static int[] field829;
   @ObfuscatedName("r")
   static int[] field830;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -660275815
   )
   static int field831;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1084210149
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1405003779
   )
   static int field833;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -548883125
   )
   static int field834;
   @ObfuscatedName("s")
   static ModIcon field835;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -975080497
   )
   static int field836;
   @ObfuscatedName("hb")
   @ObfuscatedGetter(
      intValue = -1718694785
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("pf")
   static short[] field838;
   @ObfuscatedName("as")
   static String field840;
   @ObfuscatedName("ao")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ax")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("an")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ag")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("aj")
   static String field845;
   @ObfuscatedName("ar")
   static class97 field846;
   @ObfuscatedName("ap")
   static boolean field847;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1621098703
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ah")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bj")
   static ModIcon field852;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -810118195
   )
   static int field853;
   @ObfuscatedName("aa")
   static String field855;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1391161615
   )
   static int field856;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -209200551
   )
   static int field857;
   @ObfuscatedName("x")
   static boolean field858;

   static {
      loginWindowX = field822 + 202;
      field829 = new int[256];
      field831 = 0;
      field856 = 0;
      field833 = 0;
      field857 = 0;
      field834 = 0;
      field836 = 0;
      field853 = 10;
      field855 = "";
      loginIndex = 0;
      field840 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field845 = "";
      field846 = class97.field1637;
      field847 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field823 = -1;
   }

   class41() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "43"
   )
   static void method864(String var0, String var1, String var2) {
      loginMessage1 = var0;
      loginMessage2 = var1;
      loginMessage3 = var2;
   }
}

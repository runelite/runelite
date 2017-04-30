import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class41 {
   @ObfuscatedName("h")
   static int[] field811;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 963019587
   )
   static int field812;
   @ObfuscatedName("n")
   static ModIcon field813;
   @ObfuscatedName("q")
   static ModIcon field814;
   @ObfuscatedName("p")
   static SpritePixels field815;
   @ObfuscatedName("u")
   static SpritePixels field816;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1354849529
   )
   static int field817;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1034531391
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("i")
   static int[] field820;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -277340277
   )
   static int field821;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1634086827
   )
   static int field822;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -190642211
   )
   static int field824;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1257539221
   )
   static int field826;
   @ObfuscatedName("ag")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 969998687
   )
   static int field828;
   @ObfuscatedName("aj")
   static String field829;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1848954881
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("g")
   static ModIcon field831;
   @ObfuscatedName("aq")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("av")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aw")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("af")
   @Export("password")
   static String password;
   @ObfuscatedName("d")
   static boolean field836;
   @ObfuscatedName("ar")
   static class97 field837;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2131087615
   )
   static int field838;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -241180265
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ae")
   static String field840;
   @ObfuscatedName("ah")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ai")
   static boolean field843;
   @ObfuscatedName("z")
   static ModIcon field844;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1992284747
   )
   static int field845;

   static {
      field821 = 0;
      loginWindowX = field821 + 202;
      field820 = new int[256];
      field822 = 0;
      field845 = 0;
      field824 = 0;
      field838 = 0;
      field826 = 0;
      field828 = 0;
      field817 = 10;
      field829 = "";
      loginIndex = 0;
      field840 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field837 = class97.field1620;
      field843 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field812 = -1;
   }

   class41() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "564632501"
   )
   static char method807(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }
}

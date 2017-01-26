import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class41 {
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -602358637
   )
   static int field817;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1403096213
   )
   static int field818 = 0;
   @ObfuscatedName("s")
   static ModIcon field819;
   @ObfuscatedName("q")
   static ModIcon field820;
   @ObfuscatedName("k")
   static SpritePixels field821;
   @ObfuscatedName("ay")
   static String field822;
   @ObfuscatedName("o")
   static ModIcon[] field823;
   @ObfuscatedName("a")
   static ModIcon field824;
   @ObfuscatedName("c")
   static ModIcon field825;
   @ObfuscatedName("p")
   static boolean field826;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -793870753
   )
   static int field827;
   @ObfuscatedName("w")
   static int[] field829;
   @ObfuscatedName("n")
   static int[] field830;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1315848697
   )
   static int field831;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -133070505
   )
   static int field832;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 863575693
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1813645855
   )
   static int field834;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 459205045
   )
   static int field835;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1961122129
   )
   static int field836;
   @ObfuscatedName("ar")
   static String field837;
   @ObfuscatedName("af")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("as")
   static ModIcon[] field839;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -930298357
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("av")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aa")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ag")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ao")
   static String field844;
   @ObfuscatedName("ab")
   static class97 field845;
   @ObfuscatedName("al")
   static boolean field846;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1769703209
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("at")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("x")
   static ModIcon field851;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1602118621
   )
   static int field852;

   static {
      loginWindowX = field818 + 202;
      field830 = new int[256];
      field827 = 0;
      field831 = 0;
      field817 = 0;
      field832 = 0;
      field834 = 0;
      field835 = 0;
      field836 = 10;
      field837 = "";
      loginIndex = 0;
      field822 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field844 = "";
      field845 = class97.field1630;
      field846 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field852 = -1;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-428617469"
   )
   static final void method756(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = class26.field577;
      int var3 = class187.field2776;
      if(class103.method1973(var1)) {
         class205.method3818(Widget.widgets[var1], -1, var2, var3, var0);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1925788575"
   )
   public static SpritePixels[] method771(class182 var0, String var1, String var2) {
      int var3 = var0.method3276(var1);
      int var4 = var0.method3287(var3, var2);
      SpritePixels[] var5;
      if(!class196.method3575(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class225.field3217];

         for(int var8 = 0; var8 < class225.field3217; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class225.field3214;
            var9.maxHeight = NPC.field761;
            var9.offsetX = class225.field3216[var8];
            var9.offsetY = class225.field3215[var8];
            var9.width = class22.field231[var8];
            var9.height = class225.field3218[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = class48.field949[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class183.field2719[var11[var12] & 255];
            }
         }

         class225.field3216 = null;
         class225.field3215 = null;
         class22.field231 = null;
         class225.field3218 = null;
         class183.field2719 = null;
         class48.field949 = null;
         var5 = var7;
      }

      return var5;
   }

   class41() throws Throwable {
      throw new Error();
   }
}

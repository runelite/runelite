import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class41 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1118569857
   )
   static int field824 = 0;
   @ObfuscatedName("af")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("k")
   static ModIcon field826;
   @ObfuscatedName("g")
   static ModIcon[] field827;
   @ObfuscatedName("at")
   static boolean field828;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1211541901
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("j")
   static int[] field832;
   @ObfuscatedName("x")
   static int[] field833;
   @ObfuscatedName("y")
   static int[] field834;
   @ObfuscatedName("i")
   static boolean field835;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1613418313
   )
   static int field836;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -647658227
   )
   static int field837;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1450189925
   )
   static int field838;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 989899569
   )
   static int field839;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -561899767
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("av")
   static String field841;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -2101998663
   )
   static int field842;
   @ObfuscatedName("aw")
   static String field843;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 497329119
   )
   static int field844;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 962797145
   )
   static int field845;
   @ObfuscatedName("az")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aa")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   @Export("username")
   static String username;
   @ObfuscatedName("ab")
   static String field850;
   @ObfuscatedName("al")
   static class97 field851;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 941701877
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("s")
   static int[] field853;
   @ObfuscatedName("pa")
   public static class103 field855;
   @ObfuscatedName("ae")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 559790549
   )
   static int field857;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1914814093
   )
   static int field858;
   @ObfuscatedName("au")
   static SpritePixels[] field860;
   @ObfuscatedName("a")
   static SpritePixels field861;

   static {
      loginWindowX = field824 + 202;
      field832 = new int[256];
      field836 = 0;
      field837 = 0;
      field838 = 0;
      field839 = 0;
      field845 = 0;
      field844 = 0;
      field842 = 10;
      field843 = "";
      loginIndex = 0;
      field841 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field850 = "";
      field851 = class97.field1617;
      field828 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field858 = -1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "1"
   )
   public static void method743(String[] var0, short[] var1) {
      class32.method657(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass187;",
      garbageValue = "177779975"
   )
   public static class187 method751(int var0) {
      class187 var1 = (class187)class187.field2777.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class187.field2775.method3211(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3371(new Buffer(var2));
         }

         class187.field2777.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2000392884"
   )
   static void method759() {
      FileOnDisk var0 = null;

      try {
         var0 = NPC.method688("", MessageNode.field226.field2687, true);
         Buffer var1 = class149.field2044.method626();
         var0.method1388(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1389();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "-1880122857"
   )
   static String method761(Widget var0, int var1) {
      int var3 = class143.method2647(var0);
      boolean var2 = (var3 >> 1 + var1 & 1) != 0;
      return !var2 && var0.field2308 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "563498211"
   )
   static final int method762(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}

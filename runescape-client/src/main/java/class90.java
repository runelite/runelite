import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class90 {
   @ObfuscatedName("g")
   static boolean field1335;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1179492529
   )
   static int field1336;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field1337;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static SpritePixels field1359;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static SpritePixels field1340;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1076950675
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("k")
   static int[] field1365;
   @ObfuscatedName("w")
   static int[] field1338;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2028308905
   )
   static int field1344;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1726213435
   )
   static int field1371;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 331691027
   )
   static int field1360;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 204321343
   )
   static int field1347;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1813997213
   )
   static int field1370;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1259229361
   )
   static int field1349;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 307894415
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ad")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 596035249
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("aa")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ab")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("al")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("af")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ah")
   @Export("username")
   static String username;
   @ObfuscatedName("au")
   @Export("password")
   static String password;
   @ObfuscatedName("ap")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("aq")
   static boolean field1354;
   @ObfuscatedName("bq")
   static boolean field1353;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static BuildType field1348;
   @ObfuscatedName("bj")
   static boolean field1362;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1295030239
   )
   @Export("currentLoginField")
   static int currentLoginField;
   @ObfuscatedName("bl")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -251307941
   )
   static int field1368;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      longValue = 4648050733634967175L
   )
   static long field1361;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      longValue = 2160149342024724893L
   )
   static long field1346;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = -1355095799
   )
   @Export("menuY")
   static int menuY;

   static {
      field1336 = 0;
      loginWindowX = field1336 + 202;
      field1365 = new int[256];
      field1344 = 0;
      field1371 = 0;
      field1360 = 0;
      field1347 = 0;
      field1370 = 0;
      field1349 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      Login_response0 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      Login_isUsernameRemembered = false;
      field1354 = false;
      field1353 = false;
      field1362 = true;
      currentLoginField = 0;
      worldSelectShown = false;
      field1368 = -1;
      new DecimalFormat("##0.00");
      new class160();
      field1361 = -1L;
      field1346 = -1L;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-28176232"
   )
   public static void method1995() {
      WorldMapRegion.field472.method4023(5);
      WorldMapRegion.field473.method4023(5);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1920618832"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = WorldMapData.getSmoothNoise2D(var3, var5);
      int var8 = WorldMapData.getSmoothNoise2D(var3 + 1, var5);
      int var9 = WorldMapData.getSmoothNoise2D(var3, var5 + 1);
      int var10 = WorldMapData.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var14 * var10 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var16 * var13 >> 16);
      return var15;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Liz;IIZS)V",
      garbageValue = "1604"
   )
   static void method1991(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.dynamicWidth == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.dynamicWidth == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.dynamicWidth == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.originalHeight;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.originalHeight;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.originalHeight >> 14;
      }

      if(var0.dynamicWidth == 4) {
         var0.width = var0.field2838 * var0.height / var0.field2839;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2839 / var0.field2838;
      }

      if(var0.contentType == 1337) {
         Client.field862 = var0;
      }

      if(var3 && var0.onResizeListener != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.objs = var0.onResizeListener;
         Client.field1049.addFront(var6);
      }

   }
}

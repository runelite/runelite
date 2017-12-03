import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class91 {
   @ObfuscatedName("a")
   static boolean field1347;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1917314035
   )
   static int field1351;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field1316;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field1317;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static SpritePixels field1315;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static SpritePixels field1319;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static IndexedSprite field1333;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1407958579
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("q")
   static int[] field1324;
   @ObfuscatedName("d")
   static int[] field1325;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -702979315
   )
   static int field1323;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1437060853
   )
   static int field1327;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 274164483
   )
   static int field1321;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 151721363
   )
   static int field1350;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1392249157
   )
   static int field1330;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -709614887
   )
   static int field1342;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -233909077
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ac")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 773237997
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("al")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ay")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ai")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("af")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ah")
   @Export("username")
   static String username;
   @ObfuscatedName("az")
   @Export("password")
   static String password;
   @ObfuscatedName("av")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("au")
   static boolean field1331;
   @ObfuscatedName("bb")
   static boolean field1318;
   @ObfuscatedName("bn")
   static boolean field1346;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1352053935
   )
   static int field1345;
   @ObfuscatedName("bw")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -233833601
   )
   static int field1326;
   @ObfuscatedName("fn")
   @Export("landMapFileIds")
   static int[] landMapFileIds;

   static {
      field1351 = 0;
      loginWindowX = field1351 + 202;
      field1324 = new int[256];
      field1323 = 0;
      field1327 = 0;
      field1321 = 0;
      field1350 = 0;
      field1330 = 0;
      field1342 = 0;
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
      field1331 = false;
      field1318 = false;
      field1346 = true;
      field1345 = 0;
      worldSelectShown = false;
      field1326 = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Lgs;IB)Lgs;",
      garbageValue = "9"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "24186"
   )
   static int method1694() {
      return 11;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;S)V",
      garbageValue = "-3502"
   )
   public static void method1719(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      Frames.field2028 = VarPlayerType.varplayer_ref.fileCount(16);
   }
}

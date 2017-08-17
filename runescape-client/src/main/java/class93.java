import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class93 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1705996823
   )
   static int field1434;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1584418015
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("v")
   static int[] field1439;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -665522787
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1829375503
   )
   static int field1441;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1685083917
   )
   static int field1442;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2142428833
   )
   static int field1464;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 416409023
   )
   static int field1438;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -915352169
   )
   static int field1433;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1465005671
   )
   static int field1458;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1603913045
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("aj")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("at")
   static String field1452;
   @ObfuscatedName("as")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("af")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("au")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("az")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ak")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("al")
   @Export("password")
   static String password;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   static class150 field1443;
   @ObfuscatedName("ad")
   static boolean field1435;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2015505839
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 2036944979
   )
   static int field1463;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field1466;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexedSprite field1446;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -427379161
   )
   static int field1447;
   @ObfuscatedName("n")
   static int[] field1456;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexedSprite field1436;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   static IndexedSprite[] field1437;
   @ObfuscatedName("u")
   static int[] field1440;
   @ObfuscatedName("j")
   static boolean field1465;
   @ObfuscatedName("ao")
   static int[] field1444;

   static {
      field1434 = 0;
      loginWindowX = field1434 + 202;
      field1439 = new int[256];
      field1441 = 0;
      field1442 = 0;
      field1464 = 0;
      field1438 = 0;
      field1433 = 0;
      field1458 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1452 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1443 = class150.field2201;
      field1435 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1463 = -1;
   }

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-962826924"
   )
   static final void method1767() {
      Region.lowMemory = false;
      Client.lowMemory = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-473014288"
   )
   public static void method1766(String[] var0, short[] var1) {
      class22.method179(var0, var1, 0, var0.length - 1);
   }
}

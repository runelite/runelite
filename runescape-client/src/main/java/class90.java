import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class90 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1101905987
   )
   static int field1419;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1320292677
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("a")
   static int[] field1418;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -402345667
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1020956297
   )
   static int field1423;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1543759681
   )
   static int field1420;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1348969651
   )
   static int field1421;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1554402745
   )
   static int field1441;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2009884061
   )
   static int field1413;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1370567727
   )
   static int field1422;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 80044439
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("az")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("an")
   static String field1428;
   @ObfuscatedName("ar")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aa")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("aj")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ap")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ao")
   @Export("password")
   static String password;
   @ObfuscatedName("bl")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("at")
   static boolean field1414;
   @ObfuscatedName("ak")
   static boolean field1435;
   @ObfuscatedName("bj")
   static boolean field1436;
   @ObfuscatedName("bc")
   static boolean field1438;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -861123053
   )
   static int field1439;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 723683725
   )
   static int field1429;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field1411;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field1412;
   @ObfuscatedName("bq")
   static String field1437;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   static IndexedSprite field1415;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Ljz;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("d")
   static boolean field1409;

   static {
      field1419 = 0;
      loginWindowX = field1419 + 202;
      field1418 = new int[256];
      field1423 = 0;
      field1420 = 0;
      field1421 = 0;
      field1441 = 0;
      field1413 = 0;
      field1422 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1428 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1414 = false;
      field1435 = false;
      field1436 = false;
      field1438 = true;
      field1439 = 0;
      worldSelectShown = false;
      field1429 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1366020519"
   )
   public static String method1796(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}

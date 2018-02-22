import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class89 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 644814671
   )
   static int field1324;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field1299;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("l")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field1302;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1422930763
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("j")
   static int[] field1304;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -902480129
   )
   static int field1330;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1043599275
   )
   static int field1306;
   @ObfuscatedName("aj")
   static int[] field1307;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 18192345
   )
   static int field1308;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1618056621
   )
   static int field1309;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1241234237
   )
   static int field1310;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1946664301
   )
   static int field1335;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1174042971
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("as")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 412560517
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ax")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ad")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ar")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ag")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("au")
   @Export("username")
   static String username;
   @ObfuscatedName("ac")
   @Export("password")
   static String password;
   @ObfuscatedName("ay")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("an")
   static boolean field1320;
   @ObfuscatedName("bh")
   static boolean field1325;
   @ObfuscatedName("bf")
   static boolean field1312;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -539555341
   )
   static int field1331;
   @ObfuscatedName("be")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 996013593
   )
   static int field1315;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      longValue = 5106341213291369649L
   )
   static long field1332;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      longValue = 3311156920457379871L
   )
   static long field1333;

   static {
      field1324 = 0;
      loginWindowX = field1324 + 202;
      field1304 = new int[256];
      field1330 = 0;
      field1306 = 0;
      field1308 = 0;
      field1309 = 0;
      field1310 = 0;
      field1335 = 0;
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
      field1320 = false;
      field1325 = false;
      field1312 = true;
      field1331 = 0;
      worldSelectShown = false;
      field1315 = -1;
      new DecimalFormat("##0.00");
      new class159();
      field1332 = -1L;
      field1333 = -1L;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;I)V",
      garbageValue = "-1572015489"
   )
   public static void method1888(IndexDataBase var0) {
      class263.field3412 = var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-459498858"
   )
   public static int method1879(int var0) {
      return var0 >> 11 & 63;
   }
}

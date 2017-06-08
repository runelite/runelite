import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class92 {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -270009107
   )
   static int field1416;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1804289457
   )
   static int field1417;
   @ObfuscatedName("i")
   static ModIcon field1418;
   @ObfuscatedName("f")
   static ModIcon[] field1419;
   @ObfuscatedName("m")
   static SpritePixels field1420;
   @ObfuscatedName("c")
   static SpritePixels field1421;
   @ObfuscatedName("e")
   static ModIcon field1422;
   @ObfuscatedName("ah")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("s")
   static int[] field1425;
   @ObfuscatedName("ac")
   @Export("password")
   static String password;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1013517079
   )
   static int field1427;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1476361347
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2003323907
   )
   static int field1429;
   @ObfuscatedName("n")
   static boolean field1430;
   @ObfuscatedName("ab")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("at")
   static String field1433;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -326716649
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ak")
   static String field1435;
   @ObfuscatedName("as")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -318071665
   )
   static int field1437;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -439280637
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("am")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ax")
   static class149 field1441;
   @ObfuscatedName("af")
   static boolean field1442;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1185643277
   )
   static int field1443;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -271094205
   )
   static int field1444;
   @ObfuscatedName("ap")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1814121861
   )
   static int field1447;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 943649813
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("d")
   static int[] field1449;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 870434301
   )
   static int field1451;

   static {
      field1417 = 0;
      loginWindowX = field1417 + 202;
      field1425 = new int[256];
      field1437 = 0;
      field1427 = 0;
      field1447 = 0;
      field1429 = 0;
      field1451 = 0;
      field1444 = 0;
      field1416 = 10;
      field1433 = "";
      loginIndex = 0;
      field1435 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1441 = class149.field2208;
      field1442 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1443 = -1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "-1713908002"
   )
   static MessageNode method1724(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1847(var1);
   }
}

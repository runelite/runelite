import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class90 {
   @ObfuscatedName("pd")
   @ObfuscatedGetter(
      intValue = 1360976181
   )
   static int field1448;
   @ObfuscatedName("kz")
   @ObfuscatedGetter(
      intValue = -171984717
   )
   static int field1421;
   @ObfuscatedName("w")
   static boolean field1440;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 802800573
   )
   static int field1413;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   static IndexedSprite field1414;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   static IndexedSprite[] field1415;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static SpritePixels field1427;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   static IndexedSprite field1417;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   static IndexedSprite field1418;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   static IndexedSprite field1419;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1949073269
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("k")
   static int[] field1443;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -711567673
   )
   static int field1423;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -998485217
   )
   static int field1424;
   @ObfuscatedName("ay")
   static int[] field1425;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 955073511
   )
   static int field1426;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 113381281
   )
   static int field1430;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -152078545
   )
   static int field1412;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 563413099
   )
   static int field1429;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1583018365
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("av")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1898131193
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ae")
   static String field1442;
   @ObfuscatedName("ab")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aj")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ac")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("am")
   @Export("password")
   static String password;
   @ObfuscatedName("ah")
   static boolean field1439;
   @ObfuscatedName("as")
   static boolean field1450;
   @ObfuscatedName("br")
   static boolean field1441;
   @ObfuscatedName("bw")
   static boolean field1438;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -904804285
   )
   static int field1422;
   @ObfuscatedName("bz")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1421698321
   )
   static int field1428;

   static {
      field1413 = 0;
      loginWindowX = field1413 + 202;
      field1443 = new int[256];
      field1423 = 0;
      field1424 = 0;
      field1426 = 0;
      field1430 = 0;
      field1412 = 0;
      field1429 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1442 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1439 = false;
      field1450 = false;
      field1441 = false;
      field1438 = true;
      field1422 = 0;
      worldSelectShown = false;
      field1428 = -1;
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Z",
      garbageValue = "-114"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = WidgetNode.method1087(var0, Permission.field3169);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(WidgetNode.method1087(Client.friends[var3].name, Permission.field3169)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(WidgetNode.method1087(class66.localPlayer.name, Permission.field3169))) {
            return true;
         } else {
            return false;
         }
      }
   }
}

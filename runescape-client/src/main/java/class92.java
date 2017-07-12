import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class92 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1925576747
   )
   static int field1470;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 903405447
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("f")
   static int[] field1459;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1608954687
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -214960641
   )
   static int field1457;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 469095859
   )
   static int field1458;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1937060197
   )
   static int field1452;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1470106921
   )
   static int field1465;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -753565031
   )
   static int field1456;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1591958589
   )
   static int field1462;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -934114239
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ay")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("as")
   static String field1466;
   @ObfuscatedName("ak")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aq")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ax")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ac")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ap")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("at")
   @Export("password")
   static String password;
   @ObfuscatedName("av")
   static class149 field1472;
   @ObfuscatedName("az")
   static boolean field1473;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1438236143
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1594948465
   )
   static int field1479;
   @ObfuscatedName("r")
   static SpritePixels field1451;
   @ObfuscatedName("a")
   static ModIcon field1461;
   @ObfuscatedName("t")
   static ModIcon field1475;

   static {
      field1470 = 0;
      loginWindowX = field1470 + 202;
      field1459 = new int[256];
      field1457 = 0;
      field1458 = 0;
      field1452 = 0;
      field1465 = 0;
      field1456 = 0;
      field1462 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1466 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1472 = class149.field2213;
      field1473 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1479 = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass186;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-446332078"
   )
   static String method1733(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class185 var3 = (class185)var0.method3478((long)var1);
         return var3 == null?var2:(String)var3.field2450;
      }
   }
}

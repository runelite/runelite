import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class92 {
   @ObfuscatedName("ap")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("e")
   static ModIcon field1442;
   @ObfuscatedName("as")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1600233259
   )
   static int field1444;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1434145207
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("m")
   static int[] field1447;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1282306437
   )
   static int field1448;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 846047257
   )
   static int field1449;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1846576629
   )
   static int field1450;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 2071141653
   )
   static int field1451;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 60190587
   )
   static int field1452;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1989392443
   )
   static int field1453;
   @ObfuscatedName("ag")
   static class149 field1454;
   @ObfuscatedName("aw")
   static String field1455;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 245474999
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("x")
   static ModIcon field1457;
   @ObfuscatedName("aa")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -531974147
   )
   static int field1459;
   @ObfuscatedName("ab")
   static String field1460;
   @ObfuscatedName("av")
   @Export("password")
   static String password;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 407245143
   )
   static int field1463;
   @ObfuscatedName("ax")
   static boolean field1464;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -553440627
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ae")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ak")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -766232281
   )
   static int field1469;
   @ObfuscatedName("b")
   static ModIcon[] field1470;

   static {
      field1459 = 0;
      loginWindowX = field1459 + 202;
      field1447 = new int[256];
      field1444 = 0;
      field1449 = 0;
      field1450 = 0;
      field1451 = 0;
      field1452 = 0;
      field1453 = 0;
      field1448 = 10;
      field1455 = "";
      loginIndex = 0;
      field1460 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1454 = class149.field2213;
      field1464 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1469 = -1;
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-88510903"
   )
   static final void method1736(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1133; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1136[var4] = true;
         }
      }

   }
}

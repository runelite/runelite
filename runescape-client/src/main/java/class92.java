import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class92 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1381787351
   )
   static int field1436;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1348540661
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("x")
   static int[] field1444;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2143465867
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 841758067
   )
   static int field1447;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1754291585
   )
   static int field1422;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1412792835
   )
   static int field1427;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1005840269
   )
   static int field1428;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1799586195
   )
   static int field1429;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1738603773
   )
   static int field1425;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1863759239
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("aw")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("aa")
   static String field1434;
   @ObfuscatedName("ag")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aj")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ax")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("az")
   @Export("password")
   static String password;
   @ObfuscatedName("as")
   static class149 field1430;
   @ObfuscatedName("at")
   static boolean field1446;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -525751797
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ao")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("a")
   static boolean field1426;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 267454629
   )
   static int field1448;
   @ObfuscatedName("n")
   static ModIcon field1419;
   @ObfuscatedName("ac")
   static SpritePixels[] field1437;
   @ObfuscatedName("af")
   static ModIcon[] field1418;
   @ObfuscatedName("h")
   static int[] field1424;
   @ObfuscatedName("f")
   static int[] field1445;

   static {
      field1436 = 0;
      loginWindowX = field1436 + 202;
      field1444 = new int[256];
      field1447 = 0;
      field1422 = 0;
      field1427 = 0;
      field1428 = 0;
      field1429 = 0;
      field1425 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1434 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1430 = class149.field2189;
      field1446 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1448 = -1;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;S)V",
      garbageValue = "3910"
   )
   static final void method1733(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var9 * var2 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class203.mapedge.method4994(var14 + var0 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         ScriptVarType.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}

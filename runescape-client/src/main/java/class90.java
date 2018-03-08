import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class90 {
   @ObfuscatedName("t")
   static boolean field1340;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -418036251
   )
   static int field1323;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llk;"
   )
   static IndexedSprite field1324;
   @ObfuscatedName("a")
   static int[] field1360;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llk;"
   )
   static IndexedSprite field1326;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Llk;"
   )
   static IndexedSprite field1331;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 806100173
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("d")
   static int[] field1330;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 994021257
   )
   static int field1332;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -597929271
   )
   static int field1333;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1340725783
   )
   static int field1334;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1388299511
   )
   static int field1335;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1665776075
   )
   static int field1336;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -729629433
   )
   static int field1338;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1817064831
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ax")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -743811639
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("an")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ai")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("al")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("at")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ag")
   @Export("username")
   static String username;
   @ObfuscatedName("as")
   @Export("password")
   static String password;
   @ObfuscatedName("aw")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("ad")
   static boolean field1348;
   @ObfuscatedName("bg")
   static boolean field1327;
   @ObfuscatedName("bk")
   static boolean field1350;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1530417765
   )
   static int field1351;
   @ObfuscatedName("bs")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -477376755
   )
   static int field1322;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      longValue = 5483961857841493021L
   )
   static long field1356;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      longValue = -7871758363910397079L
   )
   static long field1357;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 677629911
   )
   @Export("menuY")
   static int menuY;

   static {
      field1323 = 0;
      loginWindowX = field1323 + 202;
      field1330 = new int[256];
      field1332 = 0;
      field1333 = 0;
      field1334 = 0;
      field1335 = 0;
      field1336 = 0;
      field1338 = 0;
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
      field1348 = false;
      field1327 = false;
      field1350 = true;
      field1351 = 0;
      worldSelectShown = false;
      field1322 = -1;
      new DecimalFormat("##0.00");
      new class160();
      field1356 = -1L;
      field1357 = -1L;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1690697439"
   )
   static final void method1942() {
      if(!class132.Viewport_false0) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class132.Viewport_mouseX - Graphics3D.centerX) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var7 = (class132.Viewport_mouseY - Graphics3D.centerY) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var8 = (class132.Viewport_mouseX - Graphics3D.centerX) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var9 = (class132.Viewport_mouseY - Graphics3D.centerY) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var10 = Graphics3D.method2799(var7, var4, var1, var0);
         int var11 = Graphics3D.method2784(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2799(var9, var5, var1, var0);
         int var12 = Graphics3D.method2784(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2797(var6, var11, var3, var2);
         var11 = Graphics3D.method2798(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2797(var8, var12, var3, var2);
         var12 = Graphics3D.method2798(var8, var12, var3, var2);
         class5.field30 = (var10 + var6) / 2;
         class132.field1897 = (var9 + var7) / 2;
         class61.field698 = (var12 + var11) / 2;
         NPC.field1282 = (var10 - var6) / 2;
         VarPlayerType.field3451 = (var9 - var7) / 2;
         class228.field2669 = (var12 - var11) / 2;
         class326.field3956 = Math.abs(NPC.field1282);
         class132.field1893 = Math.abs(VarPlayerType.field3451);
         class132.field1899 = Math.abs(class228.field2669);
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1123272087"
   )
   static void method1929(int var0, int var1) {
      if(Client.field1079 != 0 && var0 != -1) {
         CombatInfo1.method1668(class55.indexTrack2, var0, 0, Client.field1079, false);
         Client.field956 = true;
      }

   }
}

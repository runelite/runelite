import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Login")
public class Login {
   @ObfuscatedName("f")
   static boolean field465;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1606541885
   )
   @Export("xPadding")
   static int xPadding;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("titleboxSprite")
   static IndexedSprite titleboxSprite;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("leftTitleSprite")
   static Sprite leftTitleSprite;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -184301597
   )
   @Export("pcmPlayerCount")
   static int pcmPlayerCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("options_buttons_0Sprite")
   static IndexedSprite options_buttons_0Sprite;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 932541923
   )
   @Export("loginBoxX")
   static int loginBoxX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -504870061
   )
   @Export("Login_loadingPercent")
   static int Login_loadingPercent;
   @ObfuscatedName("c")
   @Export("Login_loadingText")
   static String Login_loadingText;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1077910071
   )
   static int field466;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1677133239
   )
   static int field467;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1861681835
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("al")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("ab")
   @Export("Login_response1")
   static String Login_response1;
   @ObfuscatedName("ae")
   @Export("Login_response2")
   static String Login_response2;
   @ObfuscatedName("at")
   @Export("Login_response3")
   static String Login_response3;
   @ObfuscatedName("ad")
   @Export("Login_username")
   static String Login_username;
   @ObfuscatedName("ap")
   @Export("Login_password")
   static String Login_password;
   @ObfuscatedName("aa")
   static boolean field468;
   @ObfuscatedName("ax")
   static boolean field469;
   @ObfuscatedName("ai")
   @Export("otp")
   static String otp;
   @ObfuscatedName("ba")
   static boolean field470;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1769484271
   )
   @Export("currentLoginField")
   static int currentLoginField;
   @ObfuscatedName("bk")
   @Export("worldSelectOpen")
   static boolean worldSelectOpen;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1431381579
   )
   @Export("hoveredWorldIndex")
   static int hoveredWorldIndex;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -376233039
   )
   @Export("worldSelectPage")
   static int worldSelectPage;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1548722671
   )
   @Export("worldSelectPagesCount")
   static int worldSelectPagesCount;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      longValue = 803647694904294325L
   )
   static long field471;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      longValue = -3234258972092460093L
   )
   static long field472;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache11")
   static IndexCache indexCache11;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;II)Lhl;",
      garbageValue = "-1625685874"
   )
   static MusicPatch method2045(AbstractIndexCache var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null ? null : new MusicPatch(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-246495141"
   )
   static void method2056() {
      class248.field1141 = new int[2000];
      int var0 = 0;
      int var1 = 240;

      int var2;
      for (byte var3 = 12; var0 < 16; var1 -= var3) {
         var2 = class277.method5355((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)((float)var0 * 0.425F / 16.0F + 0.075F));
         class248.field1141[var0] = var2;
         ++var0;
      }

      var1 = 48;

      for (int var5 = var1 / 6; var0 < class248.field1141.length; var1 -= var5) {
         var2 = var0 * 2;

         for (int var4 = class277.method5355((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var2 && var0 < class248.field1141.length; ++var0) {
            class248.field1141[var0] = var4;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lir;IIIZB)V",
      garbageValue = "45"
   )
   public static void method2076(AbstractIndexCache var0, int var1, int var2, int var3, boolean var4) {
      class214.field1129 = 1;
      class214.field1130 = var0;
      class30.musicTrackArchiveId = var1;
      GrandExchangeOffer.musicTrackFileId = var2;
      WorldMapLabel.field1039 = var3;
      RectangleMode.musicTrackBoolean = var4;
      FaceNormal.field344 = 10000;
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   static final int method2061() {
      if (ReflectionCheck.clientPreferences.roofsHidden) {
         return SoundSystem.plane;
      } else {
         int var0 = class32.getTileHeight(WorldMapSection1.cameraX, class11.cameraZ, SoundSystem.plane);
         return var0 - GrandExchangeEvents.cameraY < 800 && (Tiles.Tiles_renderFlags[SoundSystem.plane][WorldMapSection1.cameraX >> 7][class11.cameraZ >> 7] & 4) != 0 ? SoundSystem.plane : 3;
      }
   }

   static {
      xPadding = 0;
      loginBoxX = xPadding + 202;
      Login_loadingPercent = 10;
      Login_loadingText = "";
      field466 = -1;
      field467 = 1;
      loginIndex = 0;
      Login_response0 = "";
      Login_response1 = "";
      Login_response2 = "";
      Login_response3 = "";
      Login_username = "";
      Login_password = "";
      field468 = false;
      field469 = false;
      field470 = true;
      currentLoginField = 0;
      worldSelectOpen = false;
      hoveredWorldIndex = -1;
      worldSelectPage = 0;
      worldSelectPagesCount = 0;
      new DecimalFormat("##0.00");
      new class161();
      field471 = -1L;
      field472 = -1L;
   }
}

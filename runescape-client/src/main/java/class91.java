import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class91 {
   @ObfuscatedName("n")
   static boolean field1341;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 381807011
   )
   static int field1336;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field1337;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("runeSprites")
   static IndexedSprite[] runeSprites;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   static SpritePixels field1339;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field1342;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -642011175
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 655202641
   )
   static int field1344;
   @ObfuscatedName("l")
   static int[] field1352;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1662496993
   )
   static int field1346;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1900817919
   )
   static int field1350;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1593271905
   )
   static int field1348;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 911284265
   )
   static int field1353;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -119853867
   )
   static int field1366;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1015136515
   )
   static int field1351;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -173119367
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ax")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1448629513
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ab")
   @Export("Login_response0")
   static String Login_response0;
   @ObfuscatedName("aj")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aa")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ao")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("al")
   @Export("username")
   static String username;
   @ObfuscatedName("ay")
   @Export("password")
   static String password;
   @ObfuscatedName("aq")
   @Export("Login_isUsernameRemembered")
   static boolean Login_isUsernameRemembered;
   @ObfuscatedName("ar")
   static boolean field1335;
   @ObfuscatedName("bg")
   static boolean field1363;
   @ObfuscatedName("by")
   static boolean field1367;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1564681637
   )
   static int field1347;
   @ObfuscatedName("bo")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -855817585
   )
   static int field1349;

   static {
      field1336 = 0;
      loginWindowX = field1336 + 202;
      field1352 = new int[256];
      field1346 = 0;
      field1350 = 0;
      field1348 = 0;
      field1353 = 0;
      field1366 = 0;
      field1351 = 0;
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
      field1335 = false;
      field1363 = false;
      field1367 = true;
      field1347 = 0;
      worldSelectShown = false;
      field1349 = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILhg;I)Lcv;",
      garbageValue = "686350642"
   )
   static Script method1752(int var0, class230 var1) {
      Script var2 = (Script)Script.field1435.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = Timer.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = Timer.indexScripts.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class218.newScript(var5);
               if(var2 != null) {
                  Script.field1435.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-2078154052"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = WorldMapData.cleanUsername(var0, GrandExchangeOffer.jagexLoginType);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(WorldMapData.cleanUsername(Client.friends[var3].name, GrandExchangeOffer.jagexLoginType)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(WorldMapData.cleanUsername(GrandExchangeOffer.localPlayer.name, GrandExchangeOffer.jagexLoginType))) {
            return true;
         } else {
            return false;
         }
      }
   }
}

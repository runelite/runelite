import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class93 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 236331415
   )
   static int field1424;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 150788831
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("a")
   static int[] field1425;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1753625459
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1836739137
   )
   static int field1427;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1175380951
   )
   static int field1431;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 261574169
   )
   static int field1429;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 976060817
   )
   static int field1430;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 491157999
   )
   static int field1426;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1080698283
   )
   static int field1432;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1567698593
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ax")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("aw")
   static String field1448;
   @ObfuscatedName("av")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ac")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ak")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ad")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("at")
   @Export("password")
   static String password;
   @ObfuscatedName("ar")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   static class150 field1447;
   @ObfuscatedName("as")
   static boolean field1443;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1555807829
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -971214109
   )
   static int field1449;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   static SpritePixels field1419;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field1422;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static IndexedSprite field1420;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static IndexedSprite field1421;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 445316239
   )
   static int field1428;
   @ObfuscatedName("f")
   static int[] field1441;
   @ObfuscatedName("e")
   static boolean field1451;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;

   static {
      field1424 = 0;
      loginWindowX = field1424 + 202;
      field1425 = new int[256];
      field1427 = 0;
      field1431 = 0;
      field1429 = 0;
      field1430 = 0;
      field1426 = 0;
      field1432 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1448 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1447 = class150.field2184;
      field1443 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1449 = -1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-321301728"
   )
   static final void method1780(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               ChatLineBuffer.field1546[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1205703154"
   )
   public static final boolean method1781(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}

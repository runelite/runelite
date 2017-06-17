import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class92 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 581330593
   )
   static int field1414;
   @ObfuscatedName("e")
   static ModIcon field1415;
   @ObfuscatedName("i")
   static ModIcon field1416;
   @ObfuscatedName("at")
   static ModIcon[] field1418;
   @ObfuscatedName("j")
   static SpritePixels field1419;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 405553043
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("p")
   static boolean field1422;
   @ObfuscatedName("f")
   static ModIcon[] field1423;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -499703449
   )
   static int field1424;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1130102083
   )
   static int field1425;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1181888333
   )
   static int field1426;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 537350799
   )
   static int field1427;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -730682347
   )
   static int field1428;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 985843175
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("an")
   static boolean field1430;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1455707791
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("ac")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ao")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aa")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ay")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("aj")
   @Export("password")
   static String password;
   @ObfuscatedName("ag")
   static class149 field1438;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -438373437
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("k")
   static int[] field1441;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2069443987
   )
   static int field1442;
   @ObfuscatedName("ah")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ar")
   static String field1444;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -158867045
   )
   static int field1445;
   @ObfuscatedName("ab")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("t")
   static ModIcon field1447;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "17"
   )
   static final boolean method1636(int var0, int var1) {
      ObjectComposition var2 = class29.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4426(var1);
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-512565474"
   )
   static final void method1646(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class44.field590[Client.field906 / 100].method4950(Client.field1013 - 8, Client.field1115 - 8);
      }

      if(Client.cursorState == 2) {
         class44.field590[Client.field906 / 100 + 4].method4950(Client.field1013 - 8, Client.field1115 - 8);
      }

      class280.method4814();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "726429762"
   )
   static void method1649(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3426(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;B)V",
      garbageValue = "-33"
   )
   public static void method1651(IndexDataBase var0) {
      Enum.field3406 = var0;
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-116126260"
   )
   static final void method1652() {
      if(Player.plane != Client.field944) {
         Client.field944 = Player.plane;
         GameObject.method2787(Player.plane);
      }

   }

   static {
      field1414 = 0;
      loginWindowX = field1414 + 202;
      field1441 = new int[256];
      field1442 = 0;
      field1424 = 0;
      field1425 = 0;
      field1426 = 0;
      field1427 = 0;
      field1428 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1444 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1438 = class149.field2206;
      field1430 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field1445 = -1;
   }
}

import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class91 {
   @ObfuscatedName("d")
   static boolean field1342;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1439059239
   )
   static int field1354;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field1341;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field1340;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static SpritePixels field1347;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   public static Font field1376;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 402536235
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1958487055
   )
   static int field1348;
   @ObfuscatedName("h")
   static int[] field1349;
   @ObfuscatedName("g")
   static int[] field1350;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1532878877
   )
   static int field1351;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2101089275
   )
   static int field1352;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 244487979
   )
   static int field1353;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 721223423
   )
   static int field1343;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1029271361
   )
   static int field1368;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1784025909
   )
   static int field1370;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -2129166079
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("am")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1924581473
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("aw")
   static String field1357;
   @ObfuscatedName("ap")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ad")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("an")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ai")
   @Export("username")
   static String username;
   @ObfuscatedName("ay")
   @Export("password")
   static String password;
   @ObfuscatedName("ar")
   static boolean field1366;
   @ObfuscatedName("at")
   static boolean field1364;
   @ObfuscatedName("bj")
   static boolean field1360;
   @ObfuscatedName("bk")
   static boolean field1369;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1484943201
   )
   static int field1339;
   @ObfuscatedName("bn")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1478066013
   )
   static int field1374;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = 618653029
   )
   @Export("menuHeight")
   static int menuHeight;

   static {
      field1354 = 0;
      loginWindowX = field1354 + 202;
      field1349 = new int[256];
      field1351 = 0;
      field1352 = 0;
      field1353 = 0;
      field1343 = 0;
      field1368 = 0;
      field1370 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1357 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1366 = false;
      field1364 = false;
      field1360 = false;
      field1369 = true;
      field1339 = 0;
      worldSelectShown = false;
      field1374 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "509207788"
   )
   public static int method1813(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-33"
   )
   static String method1812() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class96.field1434.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "461775036"
   )
   static final void method1814(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class14.region.method2823(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class14.region.method2827(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class1.field12.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class3.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class228.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5245(var1 * 4 + var15 + 48, (104 - var2 - var13.sizeY) * 4 + var16 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class14.region.method2825(var0, var1, var2);
      if(var5 != 0) {
         var6 = class14.region.method2827(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class3.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class228.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5245(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class1.field12.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class14.region.method2826(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = class3.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class228.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5245(var9 + var1 * 4 + 48, (104 - var2 - var19.sizeY) * 4 + var21 + 48);
            }
         }
      }

   }
}

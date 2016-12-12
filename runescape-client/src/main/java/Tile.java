import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 612718061
   )
   int field1329;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1588233811
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -305837179
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -23742145
   )
   int field1332;
   @ObfuscatedName("g")
   class85 field1333;
   @ObfuscatedName("n")
   class77 field1334;
   @ObfuscatedName("a")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("q")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("v")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("t")
   Tile field1338;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 224981567
   )
   int field1339;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1332092911
   )
   int field1340;
   @ObfuscatedName("l")
   int[] field1341 = new int[5];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1316193777
   )
   int field1343;
   @ObfuscatedName("r")
   boolean field1344;
   @ObfuscatedName("w")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("j")
   boolean field1346;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1712145099
   )
   int field1347;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1103456115
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 490823815
   )
   int field1349 = 0;
   @ObfuscatedName("u")
   boolean field1350;
   @ObfuscatedName("p")
   @Export("objects")
   GameObject[] objects = new GameObject[5];
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1913242129
   )
   public static int field1352;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1615910351
   )
   int field1354;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1528102776"
   )
   static final void method1538() {
      if(Client.widgetRoot != -1) {
         ChatMessages.method834(Client.widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < Client.field281; ++var0) {
         if(Client.field524[var0]) {
            Client.field560[var0] = true;
         }

         Client.field559[var0] = Client.field524[var0];
         Client.field524[var0] = false;
      }

      Client.field490 = Client.gameCycle;
      Client.field435 = -1;
      Client.field340 = -1;
      class156.field2119 = null;
      if(Client.widgetRoot != -1) {
         Client.field281 = 0;
         class63.method1133(Client.widgetRoot, 0, 0, ItemLayer.field1223, class112.field1755, 0, 0, -1);
      }

      class219.method3888();
      if(!Client.isMenuOpen) {
         if(Client.field435 != -1) {
            class170.method3174(Client.field435, Client.field340);
         }
      } else {
         var0 = FileOnDisk.menuX;
         int var1 = XGrandExchangeOffer.menuY;
         int var2 = class20.menuWidth;
         int var3 = class101.menuHeight;
         int var4 = 6116423;
         class219.method3910(var0, var1, var2, var3, var4);
         class219.method3910(var0 + 1, var1 + 1, var2 - 2, 16, 0);
         class219.method3932(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
         class11.field119.method3779("Choose Option", 3 + var0, var1 + 14, var4, -1);
         int var5 = class115.field1794;
         int var6 = class115.field1797;

         for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
            int var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
            int var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
               var9 = 16776960;
            }

            class11.field119.method3779(class172.method3179(var7), 3 + var0, var8, var9, 0);
         }

         class179.method3205(FileOnDisk.menuX, XGrandExchangeOffer.menuY, class20.menuWidth, class101.menuHeight);
      }

      if(Client.field498 == 3) {
         for(var0 = 0; var0 < Client.field281; ++var0) {
            if(Client.field559[var0]) {
               class219.method3894(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field560[var0]) {
               class219.method3894(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      class57.method1046(class171.plane, class39.localPlayer.x, class39.localPlayer.y, Client.field364);
      Client.field364 = 0;
   }

   Tile(int var1, int var2, int var3) {
      this.plane = var1 * -1103456115;
      this.field1354 = var1;
      this.x = var2;
      this.y = var3;
   }
}

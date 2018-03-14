import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class93 {
   @ObfuscatedName("i")
   static byte[] field1394;
   @ObfuscatedName("a")
   static byte[] field1393;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lgb;"
   )
   static Buffer[] field1405;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -621167171
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("e")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1419579715
   )
   static int field1398;
   @ObfuscatedName("p")
   static int[] field1399;
   @ObfuscatedName("g")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("n")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("o")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1372971355
   )
   static int field1395;
   @ObfuscatedName("v")
   static int[] field1404;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   static Buffer field1392;

   static {
      field1394 = new byte[2048];
      field1393 = new byte[2048];
      field1405 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1398 = 0;
      field1399 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1395 = 0;
      field1404 = new int[2048];
      field1392 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("t")
   public static final void method1982(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-108"
   )
   static void method1974(String var0, String var1, String var2) {
      class90.loginMessage1 = var0;
      class90.loginMessage2 = var1;
      class90.loginMessage3 = var2;
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-15"
   )
   static void method1981() {
      if(Client.field890 >= 0 && Client.cachedPlayers[Client.field890] != null) {
         class62.method1112(Client.cachedPlayers[Client.field890], false);
      }

   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lbz;ZI)V",
      garbageValue = "729122055"
   )
   @Export("closeWidget")
   static final void closeWidget(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && WorldComparator.validInterfaces[var2]) {
         Widget.widgetIndex.method4589(var2);
         if(Widget.widgets[var2] != null) {
            boolean var9 = true;

            for(var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(Widget.widgets[var2][var5] != null) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var9 = false;
                  }
               }
            }

            if(var9) {
               Widget.widgets[var2] = null;
            }

            WorldComparator.validInterfaces[var2] = false;
         }
      }

      class27.method232(var2);
      Widget var4 = GZipDecompressor.getWidget(var3);
      if(var4 != null) {
         GameEngine.method1053(var4);
      }

      for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
         int var7 = Client.menuTypes[var5];
         boolean var6 = var7 == 57 || var7 == 58 || var7 == 1007 || var7 == 25 || var7 == 30;
         if(var6) {
            if(var5 < Client.menuOptionCount - 1) {
               for(int var8 = var5; var8 < Client.menuOptionCount - 1; ++var8) {
                  Client.menuOptions[var8] = Client.menuOptions[var8 + 1];
                  Client.menuTargets[var8] = Client.menuTargets[var8 + 1];
                  Client.menuTypes[var8] = Client.menuTypes[var8 + 1];
                  Client.menuIdentifiers[var8] = Client.menuIdentifiers[var8 + 1];
                  Client.menuActionParams0[var8] = Client.menuActionParams0[var8 + 1];
                  Client.menuActionParams1[var8] = Client.menuActionParams1[var8 + 1];
                  Client.menuBooleanArray[var8] = Client.menuBooleanArray[var8 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

      if(Client.widgetRoot != -1) {
         BoundingBox.method50(Client.widgetRoot, 1);
      }

   }
}

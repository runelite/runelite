import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public final class class5 {
   @ObfuscatedName("v")
   static byte[][][] field75;
   @ObfuscatedName("u")
   static ModIcon[] field76;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -761797997
   )
   static int field77 = 99;
   @ObfuscatedName("c")
   static byte[][][] field78;
   @ObfuscatedName("z")
   static final int[] field79 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("q")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("p")
   static int[][][] field82;
   @ObfuscatedName("r")
   static final int[] field83 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("a")
   static final int[] field84 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("n")
   static final int[] field85 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("k")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("b")
   static int[] field87;
   @ObfuscatedName("d")
   static final int[] field88 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 649642755
   )
   static int field89 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 133282749
   )
   static int field90 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("h")
   static int[] field91;
   @ObfuscatedName("ax")
   static class149 field94;
   @ObfuscatedName("x")
   static final int[] field95 = new int[]{1, -1, -1, 1};

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1189202197"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class93.worldServersDownload == null) {
            class93.worldServersDownload = new class18(Item.field699, new URL(Client.field284));
         } else {
            byte[] var0 = class93.worldServersDownload.method187();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field656 = var1.method2691();
               ItemComposition.worldList = new World[World.field656];

               World var3;
               for(int var2 = 0; var2 < World.field656; var3.index = var2++) {
                  var3 = ItemComposition.worldList[var2] = new World();
                  var3.id = var1.method2691();
                  var3.mask = var1.method2576();
                  var3.address = var1.method2579();
                  var3.activity = var1.method2579();
                  var3.location = var1.method2571();
                  var3.playerCount = var1.method2574();
               }

               class165.method3231(ItemComposition.worldList, 0, ItemComposition.worldList.length - 1, World.field645, World.field644);
               class93.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class93.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "486698574"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1317284189"
   )
   static boolean method56(Widget var0) {
      if(Client.field316) {
         if(FrameMap.method2356(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      signature = "Lco;"
   )
   @Export("pcmPlayer0")
   static PcmPlayer pcmPlayer0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   @Export("WorldMapCacheName_details")
   public static final WorldMapCacheName WorldMapCacheName_details;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   @Export("WorldMapCacheName_compositeMap")
   public static final WorldMapCacheName WorldMapCacheName_compositeMap;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   @Export("WorldMapCacheName_compositeTexture")
   public static final WorldMapCacheName WorldMapCacheName_compositeTexture;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   @Export("WorldMapCacheName_area")
   static final WorldMapCacheName WorldMapCacheName_area;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   @Export("WorldMapCacheName_labels")
   public static final WorldMapCacheName WorldMapCacheName_labels;
   @ObfuscatedName("u")
   @Export("name")
   public final String name;

   WorldMapCacheName(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([I[II)V",
      garbageValue = "-1459849000"
   )
   public static void method633(int[] var0, int[] var1) {
      if (var0 != null && var1 != null) {
         ByteArrayPool.field55 = var0;
         WorldMapSection0.field1082 = new int[var0.length];
         RouteStrategy.field760 = new byte[var0.length][][];

         for (int var2 = 0; var2 < ByteArrayPool.field55.length; ++var2) {
            RouteStrategy.field760[var2] = new byte[var1[var2]][];
         }
      } else {
         ByteArrayPool.field55 = null;
         WorldMapSection0.field1082 = null;
         RouteStrategy.field760 = ((byte[][][])null);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "1532180466"
   )
   @Export("openURL")
   public static void openURL(String var0, boolean var1, boolean var2) {
      if (var1) {
         if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
            }
         }

         if (class50.field1160.startsWith("win")) {
            ReflectionCheck.method5920(var0, 0);
         } else if (class50.field1160.startsWith("mac")) {
            FaceNormal.method3237(var0, 1, "openjs");
         } else {
            ReflectionCheck.method5920(var0, 2);
         }
      } else {
         ReflectionCheck.method5920(var0, 3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "199373952"
   )
   public static int method634(int var0) {
      int var1 = 0;
      if (var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if (var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if (var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if (var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if (var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Lbr;ZI)V",
      garbageValue = "519207109"
   )
   @Export("addPlayerToScene")
   static void addPlayerToScene(Player player, boolean var1) {
      if (player != null && player.isVisible() && !player.isHidden) {
         player.isUnanimated = false;
         if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && player.movementSequence == player.readySequence) {
            player.isUnanimated = true;
         }

         int var2 = player.x >> 7;
         int var3 = player.y >> 7;
         if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            long var4 = FontName.calculateTag(0, 0, 0, false, player.index);
            if (player.model0 != null && Client.cycle >= player.animationCycleStart && Client.cycle < player.animationCycleEnd) {
               player.isUnanimated = false;
               player.tileHeight = class32.getTileHeight(player.x, player.y, SoundSystem.plane);
               player.playerCycle = Client.cycle;
               class65.scene.method286(SoundSystem.plane, player.x, player.y, player.tileHeight, 60, player, player.field9, var4, player.field721, player.field722, player.field723, player.field724);
            } else {
               if ((player.x & 127) == 64 && (player.y & 127) == 64) {
                  if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
                     return;
                  }

                  Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
               }

               player.tileHeight = class32.getTileHeight(player.x, player.y, SoundSystem.plane);
               player.playerCycle = Client.cycle;
               class65.scene.method285(SoundSystem.plane, player.x, player.y, player.tileHeight, 60, player, player.field9, var4, player.field10);
            }
         }
      }

   }

   static {
      WorldMapCacheName_details = new WorldMapCacheName("details");
      WorldMapCacheName_compositeMap = new WorldMapCacheName("compositemap");
      WorldMapCacheName_compositeTexture = new WorldMapCacheName("compositetexture");
      WorldMapCacheName_area = new WorldMapCacheName("area");
      WorldMapCacheName_labels = new WorldMapCacheName("labels");
   }
}

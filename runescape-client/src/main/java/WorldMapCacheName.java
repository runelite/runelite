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

   static {
      WorldMapCacheName_details = new WorldMapCacheName("details");
      WorldMapCacheName_compositeMap = new WorldMapCacheName("compositemap");
      WorldMapCacheName_compositeTexture = new WorldMapCacheName("compositetexture");
      WorldMapCacheName_area = new WorldMapCacheName("area");
      WorldMapCacheName_labels = new WorldMapCacheName("labels");
   }

   WorldMapCacheName(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([I[II)V",
      garbageValue = "-1459849000"
   )
   public static void method633(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         ByteArrayPool.__gi_g = var0;
         WorldMapSection2.__ah_l = new int[var0.length];
         class179.__fe_e = new byte[var0.length][][];

         for(int var2 = 0; var2 < ByteArrayPool.__gi_g.length; ++var2) {
            class179.__fe_e[var2] = new byte[var1[var2]][];
         }

      } else {
         ByteArrayPool.__gi_g = null;
         WorldMapSection2.__ah_l = null;
         class179.__fe_e = null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "1532180466"
   )
   public static void method635(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class50.__af_f.startsWith("win")) {
            ReflectionCheck.method5920(var0, 0);
         } else if(class50.__af_f.startsWith("mac")) {
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
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
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
   static void addPlayerToScene(Player var0, boolean var1) {
      if(var0 != null && var0.isVisible() && !var0.isHidden) {
         var0.isUnanimated = false;
         if((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.movementSequence == var0.idleSequence) {
            var0.isUnanimated = true;
         }

         int var2 = var0.x >> 7;
         int var3 = var0.y >> 7;
         if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            long var4 = FontName.method5637(0, 0, 0, false, var0.index);
            if(var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
               var0.isUnanimated = false;
               var0.tileHeight = class32.getTileHeight(var0.x, var0.y, SoundSystem.plane);
               var0.playerCycle = Client.cycle;
               class65.scene.__z_240(SoundSystem.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.__ac, var4, var0.__z, var0.__j, var0.__s, var0.__t);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
                     return;
                  }

                  Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
               }

               var0.tileHeight = class32.getTileHeight(var0.x, var0.y, SoundSystem.plane);
               var0.playerCycle = Client.cycle;
               class65.scene.__a_239(SoundSystem.plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.__ac, var4, var0.__ay);
            }
         }
      }

   }
}

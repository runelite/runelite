import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("MapCacheArchiveNames")
public class MapCacheArchiveNames {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   @Export("DETAILS")
   public static final MapCacheArchiveNames DETAILS;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   @Export("COMPOSITE_MAP")
   public static final MapCacheArchiveNames COMPOSITE_MAP;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   @Export("COMPOSITE_TEXTURE")
   public static final MapCacheArchiveNames COMPOSITE_TEXTURE;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   @Export("AREA")
   public static final MapCacheArchiveNames AREA;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   @Export("LABELS")
   public static final MapCacheArchiveNames LABELS;
   @ObfuscatedName("l")
   @Export("name")
   public final String name;

   static {
      DETAILS = new MapCacheArchiveNames("details");
      COMPOSITE_MAP = new MapCacheArchiveNames("compositemap");
      COMPOSITE_TEXTURE = new MapCacheArchiveNames("compositetexture");
      AREA = new MapCacheArchiveNames("area");
      LABELS = new MapCacheArchiveNames("labels");
   }

   MapCacheArchiveNames(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1159618998"
   )
   protected static int method599() {
      int var0 = 0;
      if(class46.field572 == null || !class46.field572.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  class46.field572 = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(class46.field572 != null) {
         long var9 = class289.method5267();
         long var3 = class46.field572.getCollectionTime();
         if(-1L != GameEngine.garbageCollectorLastCollectionTime) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if(var7 != 0L) {
               var0 = (int)(var5 * 100L / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(Lbd;I)Z",
      garbageValue = "-1902339139"
   )
   static boolean method600(Player var0) {
      if(Client.playerNameMask == 0) {
         return false;
      } else if(class265.localPlayer != var0) {
         boolean var1 = (Client.playerNameMask & 4) != 0;
         boolean var2 = var1 || CombatInfo1.method1725() && var0.isFriend();
         if(!var2) {
            boolean var3 = (Client.playerNameMask & 2) != 0;
            var2 = var3 && var0.isClanMember();
         }

         return var2;
      } else {
         return WorldMapRectangle.method247();
      }
   }
}

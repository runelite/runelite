import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("MapCacheArchiveNames")
public class MapCacheArchiveNames {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   @Export("DETAILS")
   public static final MapCacheArchiveNames DETAILS;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   @Export("COMPOSITE_MAP")
   public static final MapCacheArchiveNames COMPOSITE_MAP;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   @Export("COMPOSITE_TEXTURE")
   public static final MapCacheArchiveNames COMPOSITE_TEXTURE;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   @Export("AREA")
   public static final MapCacheArchiveNames AREA;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lax;"
   )
   @Export("LABELS")
   public static final MapCacheArchiveNames LABELS;
   @ObfuscatedName("bj")
   static String field520;
   @ObfuscatedName("x")
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
}

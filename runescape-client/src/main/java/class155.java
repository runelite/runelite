import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class155 {
   @ObfuscatedName("b")
   @Export("jagexClDat")
   public static File jagexClDat;
   @ObfuscatedName("f")
   public static File field1985;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1645538853
   )
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("randomDat")
   static CacheFile randomDat;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ldd;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("c")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("e")
   public static String[] field1995;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1387990785"
   )
   static final int method3272() {
      return class120.Viewport_mouseY;
   }
}

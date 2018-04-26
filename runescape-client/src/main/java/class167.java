import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class167 {
   @ObfuscatedName("z")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("k")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("m")
   @Export("userHome")
   public static String userHome;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)J",
      garbageValue = "-997311177"
   )
   static long method3334(int var0, int var1, int var2) {
      return (long)(var2 << 16 | var0 << 8 | var1);
   }
}

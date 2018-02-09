import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class157 {
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1779943737
   )
   static int field2152;
   @ObfuscatedName("h")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }
}

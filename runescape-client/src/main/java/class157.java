import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class157 {
   @ObfuscatedName("r")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("h")
   static File field2164;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -532493303
   )
   @Export("idxCount")
   static int idxCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Ldm;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("l")
   @Export("osNameLC")
   public static String osNameLC;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1349106950"
   )
   static byte[] method3065(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}

import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class157 {
   @ObfuscatedName("k")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("u")
   static File field2138;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2015749067
   )
   @Export("idxCount")
   static int idxCount;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("q")
   @Export("osNameLC")
   public static String osNameLC;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-634923653"
   )
   public static void method3016(Buffer var0, int var1) {
      if(randomDat != null) {
         try {
            randomDat.seek(0L);
            randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}

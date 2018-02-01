import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class157 {
   @ObfuscatedName("s")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -16719223
   )
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "994078541"
   )
   public static class262 method3115(int var0) {
      class262 var1 = (class262)class262.field3445.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class262.field3448.getConfigData(11, var0);
         var1 = new class262();
         if(var2 != null) {
            var1.method4690(new Buffer(var2));
         }

         var1.method4703();
         class262.field3445.put(var1, (long)var0);
         return var1;
      }
   }
}

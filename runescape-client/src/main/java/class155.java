import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class155 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   public static CacheFile field2258;
   @ObfuscatedName("q")
   public static File field2256;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   public static CacheFile field2261;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   public static CacheFile field2260;
   @ObfuscatedName("p")
   static File field2255;

   static {
      field2258 = null;
      field2261 = null;
      field2260 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lii;",
      garbageValue = "118"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3321.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lix;",
      garbageValue = "-104"
   )
   public static class251 method3049(int var0) {
      class251 var1 = (class251)class251.field3386.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3388.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4527(new Buffer(var2));
         }

         var1.method4542();
         class251.field3386.put(var1, (long)var0);
         return var1;
      }
   }
}

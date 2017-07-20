import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class155 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   public static CacheFile field2207;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   public static CacheFile field2211;
   @ObfuscatedName("f")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   public static CacheFile field2203;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1349167385
   )
   static int field2209;
   @ObfuscatedName("y")
   static String[] field2210;
   @ObfuscatedName("u")
   static File field2204;
   @ObfuscatedName("gn")
   @ObfuscatedGetter(
      intValue = 646510957
   )
   static int field2213;

   static {
      field2207 = null;
      field2211 = null;
      field2203 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lia;",
      garbageValue = "-498037943"
   )
   public static Varbit method2895(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Varbit.varbits.put(var1, (long)var0);
         return var1;
      }
   }
}

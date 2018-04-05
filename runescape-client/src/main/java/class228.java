import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class228 {
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = -2105996307
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("o")
   byte[] field2680;
   @ObfuscatedName("k")
   byte[] field2684;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 223733873
   )
   int field2676;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -240120851
   )
   int field2679;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2011552557
   )
   int field2677;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1763526805
   )
   int field2681;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -769640769
   )
   int field2682;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 710422243
   )
   int field2683;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1981145311
   )
   int field2678;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljy;",
      garbageValue = "1643689868"
   )
   public static class279 method4119(int var0) {
      class279 var1 = (class279)class279.field3553.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class279.field3552.getConfigData(34, var0);
         var1 = new class279();
         if(var2 != null) {
            var1.method4937(new Buffer(var2));
         }

         var1.method4925();
         class279.field3553.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-33"
   )
   public static int method4120(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}

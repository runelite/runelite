import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public final class class60 {
   @ObfuscatedName("w")
   public static int[] field708;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static BuildType field706;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -1957103251
   )
   @Export("plane")
   static int plane;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljg;",
      garbageValue = "671454457"
   )
   public static Enum method983(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1539295169"
   )
   static final int method982(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}

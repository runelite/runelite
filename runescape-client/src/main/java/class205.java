import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public final class class205 {
   @ObfuscatedName("o")
   static final char[] field3080 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "-547136452"
   )
   static Widget method3728(Widget var0) {
      int var2 = class217.method3874(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class174.method3178(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)[Lclass216;",
      garbageValue = "57"
   )
   public static class216[] method3731() {
      return new class216[]{class216.field3165, class216.field3163, class216.field3161};
   }
}

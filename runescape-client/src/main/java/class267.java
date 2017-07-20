import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
public class class267 {
   @ObfuscatedName("i")
   static final char[] field3652;
   @ObfuscatedName("u")
   static final char[] field3648;
   @ObfuscatedName("k")
   @Export("blendedHue")
   static int[] blendedHue;

   static {
      field3652 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
      field3648 = new char[]{'[', ']', '#'};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Liq;",
      garbageValue = "88"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1816282562"
   )
   static final int method4745(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}

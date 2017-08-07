import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class7 {
   @ObfuscatedName("e")
   public static boolean field231;
   @ObfuscatedName("n")
   public static boolean field235;
   @ObfuscatedName("g")
   public static boolean field227;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static class11 field228;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   public static CombatInfoList field229;
   @ObfuscatedName("ab")
   protected static boolean field226;
   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   static class90 field233;

   static {
      field231 = false;
      field235 = false;
      field227 = false;
      field228 = class11.field267;
      field229 = new CombatInfoList();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lil;",
      garbageValue = "-2001097118"
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
}

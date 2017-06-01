import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class220 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "1844346874"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3547.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3575.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4647(new Buffer(var2));
         }

         var1.method4643();
         NPCComposition.field3547.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "306667014"
   )
   static String method4057(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var1 + var2; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class269.field3672[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class269.field3672[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class269.field3672[(var6 & 15) << 2 | var7 >>> 6]).append(class269.field3672[var7 & 63]);
            } else {
               var3.append(class269.field3672[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class269.field3672[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}

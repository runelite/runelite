import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class127 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "98"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field870.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field869.method3272(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method786(new Buffer(var2));
         }

         var1.method792();
         NPCComposition.field870.put(var1, (long)var0);
         return var1;
      }
   }
}

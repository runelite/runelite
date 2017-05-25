import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class220 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "-17"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3544.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class60.field738.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4701(new Buffer(var2));
         }

         var1.method4700();
         NPCComposition.field3544.put(var1, (long)var0);
         return var1;
      }
   }
}

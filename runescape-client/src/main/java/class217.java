import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class217 {
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1818151570"
   )
   static final void method4073(boolean var0) {
      for(int var1 = 0; var1 < Client.field952; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field953[var1]];
         int var3 = (Client.field953[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod1669() && var0 == var2.composition.isVisible && var2.composition.method4667()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1230 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1018[var4][var5] == Client.field1019) {
                     continue;
                  }

                  Client.field1018[var4][var5] = Client.field1019;
               }

               if(!var2.composition.field3591) {
                  var3 -= Integer.MIN_VALUE;
               }

               class61.region.method2686(class92.plane, var2.x, var2.y, class181.method3424(var2.field1230 * 64 - 64 + var2.x, var2.y + (var2.field1230 * 64 - 64), class92.plane), var2.field1230 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1229);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-1971314030"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3593.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3585.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4664(new Buffer(var2));
         }

         var1.method4678();
         NPCComposition.field3593.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1439630858"
   )
   static final int method4080(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}

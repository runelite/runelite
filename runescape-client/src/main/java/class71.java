import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class71 extends class178 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILff;B)Z",
      garbageValue = "93"
   )
   public boolean vmethod3496(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2275 && var3 == super.field2273;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "-63697673"
   )
   public static void method1203(ScriptEvent var0) {
      class7.runScript(var0, 500000);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljk;",
      garbageValue = "-1100653387"
   )
   public static VarPlayerType method1204(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1760460323"
   )
   public static void method1205() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(I)Lli;",
      garbageValue = "1860010846"
   )
   static RenderOverview method1202() {
      return class196.renderOverview;
   }
}

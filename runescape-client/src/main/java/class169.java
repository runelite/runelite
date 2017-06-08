import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class169 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)I",
      garbageValue = "-1197809163"
   )
   public static int method3122(int var0, class219 var1) {
      return (var0 + '鱀' << 8) + var1.field2799;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "205609558"
   )
   public static void method3123() {
      FloorUnderlayDefinition.field3343.reset();
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "1"
   )
   static boolean method3124(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = CollisionData.method3023(var0, class13.field281);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(CollisionData.method3023(var3.name, class13.field281))) {
               return true;
            }

            if(var1.equalsIgnoreCase(CollisionData.method3023(var3.previousName, class13.field281))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "1596594692"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3625.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3610.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.method4729(new Buffer(var2));
         }

         var1.method4755();
         Sequence.field3625.put(var1, (long)var0);
         return var1;
      }
   }
}

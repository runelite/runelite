import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class160 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "578547655"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field947.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field945.method3411(6, var0);
         var1 = new ObjectComposition();
         var1.field952 = var0;
         if(var2 != null) {
            var1.method880(new Buffer(var2));
         }

         var1.method845();
         if(var1.field984) {
            var1.field998 = 0;
            var1.field961 = false;
         }

         ObjectComposition.field947.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method3313(boolean var0) {
      class47.method1009();
      ++Client.field343;
      if(Client.field343 >= 50 || var0) {
         Client.field343 = 0;
         if(!Client.field348 && null != class40.field904) {
            Client.field337.method2903(177);

            try {
               class40.field904.method3135(Client.field337.payload, 0, Client.field337.offset);
               Client.field337.offset = 0;
            } catch (IOException var2) {
               Client.field348 = true;
            }
         }
      }

   }
}

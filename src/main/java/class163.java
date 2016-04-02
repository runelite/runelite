import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fk")
public final class class163 {
   @ObfuscatedName("e")
   static boolean field2650;

   @ObfuscatedName("dh")
   static boolean method3234(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class122.method2773(var0, client.field283);

         for(int var2 = 0; var2 < client.field549; ++var2) {
            class7 var3 = client.field550[var2];
            if(var1.equalsIgnoreCase(class122.method2773(var3.field141, client.field283))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class122.method2773(var3.field135, client.field283))) {
               return true;
            }
         }

         return false;
      }
   }
}

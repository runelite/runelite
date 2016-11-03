import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class75 implements Runnable {
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1660347315
   )
   static int field1406;
   @ObfuscatedName("q")
   volatile class59[] field1407 = new class59[2];
   @ObfuscatedName("f")
   volatile boolean field1408 = false;
   @ObfuscatedName("c")
   volatile boolean field1409 = false;
   @ObfuscatedName("k")
   class139 field1412;

   public void run() {
      this.field1409 = true;

      try {
         while(!this.field1408) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class59 var2 = this.field1407[var1];
               if(var2 != null) {
                  var2.method1217();
               }
            }

            class127.method2846(10L);
            ChatMessages.method214(this.field1412, (Object)null);
         }
      } catch (Exception var7) {
         RSCanvas.method2969((String)null, var7);
      } finally {
         this.field1409 = false;
      }

   }
}

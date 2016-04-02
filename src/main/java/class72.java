import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class72 implements Runnable {
   @ObfuscatedName("bu")
   static class168 field1319;
   @ObfuscatedName("f")
   volatile boolean field1320 = false;
   @ObfuscatedName("w")
   volatile class56[] field1321 = new class56[2];
   @ObfuscatedName("s")
   volatile boolean field1322 = false;
   @ObfuscatedName("e")
   class136 field1325;

   public void run() {
      this.field1322 = true;

      try {
         while(!this.field1320) {
            class56 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1321[var1];
               if(null != var2) {
                  var2.method1175();
               }
            }

            class130.method2818(10L);
            class136 var9 = this.field1325;
            var2 = null;
            if(var9.field2087 != null) {
               for(int var3 = 0; var3 < 50 && var9.field2087.peekEvent() != null; ++var3) {
                  class130.method2818(1L);
               }

               if(var2 != null) {
                  var9.field2087.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var7) {
         class1.method16((String)null, var7);
      } finally {
         this.field1322 = false;
      }

   }
}

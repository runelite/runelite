import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bk")
public class class75 implements Runnable {
   @ObfuscatedName("r")
   volatile boolean field1420 = false;
   @ObfuscatedName("e")
   volatile boolean field1421 = false;
   @ObfuscatedName("h")
   static byte[][][] field1422;
   @ObfuscatedName("ig")
   static class32 field1423;
   @ObfuscatedName("g")
   volatile class59[] field1424 = new class59[2];
   @ObfuscatedName("l")
   class139 field1427;

   public void run() {
      this.field1421 = true;

      try {
         while(!this.field1420) {
            class59 var1;
            for(int var2 = 0; var2 < 2; ++var2) {
               var1 = this.field1424[var2];
               if(var1 != null) {
                  var1.method1294();
               }
            }

            class22.method594(10L);
            class139 var9 = this.field1427;
            var1 = null;
            if(var9.field2151 != null) {
               for(int var3 = 0; var3 < 50 && var9.field2151.peekEvent() != null; ++var3) {
                  class22.method594(1L);
               }

               if(null != var1) {
                  var9.field2151.postEvent(new ActionEvent(var1, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var7) {
         class13.method176((String)null, var7);
      } finally {
         this.field1421 = false;
      }

   }
}

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
            class59 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1424[var1];
               if(var2 != null) {
                  var2.method1294();
               }
            }

            class22.method594(10L);
            class139 var5 = this.field1427;
            var2 = null;
            if(var5.field2151 != null) {
               for(int var3 = 0; var3 < 50 && var5.field2151.peekEvent() != null; ++var3) {
                  class22.method594(1L);
               }

               if(null != var2) {
                  var5.field2151.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class13.method176((String)null, var8);
      } finally {
         this.field1421 = false;
      }

   }
}

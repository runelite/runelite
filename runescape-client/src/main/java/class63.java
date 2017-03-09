import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public class class63 implements Runnable {
   @ObfuscatedName("c")
   volatile boolean field1095 = false;
   @ObfuscatedName("j")
   volatile class57[] field1096 = new class57[2];
   @ObfuscatedName("d")
   volatile boolean field1098 = false;
   @ObfuscatedName("x")
   class103 field1100;

   public void run() {
      this.field1098 = true;

      try {
         while(!this.field1095) {
            class57 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1096[var1];
               if(null != var2) {
                  var2.method1122();
               }
            }

            class140.method2660(10L);
            class103 var5 = this.field1100;
            var2 = null;
            if(var5.field1679 != null) {
               for(int var3 = 0; var3 < 50 && var5.field1679.peekEvent() != null; ++var3) {
                  class140.method2660(1L);
               }

               if(var2 != null) {
                  var5.field1679.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class31.method703((String)null, var8);
      } finally {
         this.field1098 = false;
      }

   }
}

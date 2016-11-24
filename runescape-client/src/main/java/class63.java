import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class63 implements Runnable {
   @ObfuscatedName("d")
   volatile class57[] field1080 = new class57[2];
   @ObfuscatedName("n")
   class103 field1081;
   @ObfuscatedName("h")
   volatile boolean field1082 = false;
   @ObfuscatedName("rv")
   protected static boolean field1083;
   @ObfuscatedName("m")
   volatile boolean field1084 = false;
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -1612481661
   )
   static int field1085;

   public void run() {
      this.field1082 = true;

      try {
         while(!this.field1084) {
            class57 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1080[var1];
               if(var2 != null) {
                  var2.method1045();
               }
            }

            class0.method12(10L);
            class103 var5 = this.field1081;
            var2 = null;
            if(null != var5.field1670) {
               for(int var3 = 0; var3 < 50 && var5.field1670.peekEvent() != null; ++var3) {
                  class0.method12(1L);
               }

               if(null != var2) {
                  var5.field1670.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class39.method772((String)null, var8);
      } finally {
         this.field1082 = false;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-22"
   )
   public static int method1151(int var0) {
      return var0 >> 11 & 63;
   }
}

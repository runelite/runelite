import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class63 implements Runnable {
   @ObfuscatedName("l")
   volatile class57[] field1074 = new class57[2];
   @ObfuscatedName("i")
   volatile boolean field1075 = false;
   @ObfuscatedName("t")
   volatile boolean field1076 = false;
   @ObfuscatedName("b")
   class103 field1079;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1869141698"
   )
   public static boolean method1215(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   public void run() {
      this.field1076 = true;

      try {
         while(!this.field1075) {
            class57 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1074[var1];
               if(var2 != null) {
                  var2.method1112();
               }
            }

            class115.method2301(10L);
            class103 var5 = this.field1079;
            var2 = null;
            if(null != var5.field1666) {
               for(int var3 = 0; var3 < 50 && var5.field1666.peekEvent() != null; ++var3) {
                  class115.method2301(1L);
               }

               if(null != var2) {
                  var5.field1666.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         FaceNormal.method1950((String)null, var8);
      } finally {
         this.field1076 = false;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-468183425"
   )
   static final int method1217(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}

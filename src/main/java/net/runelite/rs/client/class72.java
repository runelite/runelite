package net.runelite.rs.client;
import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class72 implements Runnable {
   @ObfuscatedName("a")
   volatile boolean field1357 = false;
   @ObfuscatedName("i")
   volatile boolean field1358 = false;
   @ObfuscatedName("l")
   volatile class56[] field1359 = new class56[2];
   @ObfuscatedName("j")
   class135 field1360;

   public void run() {
      this.field1358 = true;

      try {
         while(!this.field1357) {
            class56 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1359[var1];
               if(var2 != null) {
                  var2.method1175();
               }
            }

            class105.method2332(10L);
            class135 var9 = this.field1360;
            var2 = null;
            if(var9.field2097 != null) {
               for(int var3 = 0; var3 < 50 && var9.field2097.peekEvent() != null; ++var3) {
                  class105.method2332(1L);
               }

               if(var2 != null) {
                  var9.field2097.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var7) {
         class16.method184((String)null, var7);
      } finally {
         this.field1358 = false;
      }

   }

   @ObfuscatedName("a")
   public static int method1567(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("cu")
   static final boolean method1568(class172 var0) {
      if(null == var0.field2870) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2870.length; ++var1) {
            int var2 = class141.method2926(var0, var1);
            int var3 = var0.field2871[var1];
            if(2 == var0.field2870[var1]) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(3 == var0.field2870[var1]) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2870[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}

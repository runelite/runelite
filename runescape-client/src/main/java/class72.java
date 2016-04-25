import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class72 implements Runnable {
   @ObfuscatedName("j")
   class136 field1330;
   @ObfuscatedName("h")
   volatile class56[] field1331 = new class56[2];
   @ObfuscatedName("z")
   volatile boolean field1332 = false;
   @ObfuscatedName("e")
   public static boolean field1334;
   @ObfuscatedName("m")
   volatile boolean field1336 = false;

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method1569(boolean var0) {
      class156.method3131(client.field433, class5.field102, class39.field901, var0);
   }

   public void run() {
      this.field1332 = true;

      try {
         while(!this.field1336) {
            class56 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1331[var1];
               if(null != var2) {
                  var2.method1218();
               }
            }

            class14.method170(10L);
            class136 var9 = this.field1330;
            var2 = null;
            if(null != var9.field2077) {
               for(int var3 = 0; var3 < 50 && var9.field2077.peekEvent() != null; ++var3) {
                  class14.method170(1L);
               }

               if(var2 != null) {
                  var9.field2077.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var7) {
         class6.method102((String)null, var7);
      } finally {
         this.field1332 = false;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1602333491"
   )
   static void method1571() {
      int var0 = class5.field102;
      int var1 = class39.field901;
      if(class129.field2028 < var0) {
         var0 = class129.field2028;
      }

      if(class37.field809 < var1) {
         var1 = class37.field809;
      }

      if(class4.field75 != null) {
         try {
            client var2 = client.field272;
            int var3 = client.field487?2:1;
            class132.method2816(var2, "resize", new Object[]{Integer.valueOf(var3)});
         } catch (Throwable var4) {
            ;
         }
      }

   }
}

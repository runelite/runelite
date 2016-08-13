import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class161 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "255"
   )
   public static void method3314(boolean var0) {
      if(null != class174.field2790) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2783(var0?2:3);
            var1.method2849(0);
            class174.field2790.method3135(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2790.method3131();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2787;
            class174.field2790 = null;
         }
      }

   }
}

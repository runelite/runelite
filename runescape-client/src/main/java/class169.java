import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class169 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "-7415"
   )
   public static void method3002(boolean var0) {
      if(class238.field3258 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3258.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3258.method2879();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3276;
            class238.field3258 = null;
         }

      }
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "131949608"
   )
   static final void method3003(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(11);
      Client.secretPacketBuffer1.putByte(Friend.method1023(var0) + 1);
      Client.secretPacketBuffer1.method3125(var0);
      Client.secretPacketBuffer1.method3059(var1);
   }
}

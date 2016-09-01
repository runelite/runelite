import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public abstract class class128 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 508783833
   )
   public static int field2091;
   @ObfuscatedName("r")
   static boolean field2092 = false;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "904637177"
   )
   abstract void vmethod2852(byte[] var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "543168377"
   )
   abstract byte[] vmethod2858();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/lang/Object;I)V",
      garbageValue = "1227330808"
   )
   public static void method2861(class139 var0, Object var1) {
      if(null != var0.field2137) {
         for(int var2 = 0; var2 < 50 && var0.field2137.peekEvent() != null; ++var2) {
            class125.method2820(1L);
         }

         if(null != var1) {
            var0.field2137.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}

import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class91 implements class178 {
   @ObfuscatedName("h")
   static final class91 field1405;
   @ObfuscatedName("u")
   static final class91 field1406;
   @ObfuscatedName("q")
   static final class91 field1407;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1848305003
   )
   final int field1408;
   @ObfuscatedName("i")
   static final class91 field1410;
   @ObfuscatedName("dr")
   static IndexData field1411;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field1408;
   }

   static {
      field1410 = new class91(0);
      field1405 = new class91(1);
      field1406 = new class91(2);
      field1407 = new class91(3);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class91(int var1) {
      this.field1408 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1663943041"
   )
   public static void method1753(boolean var0) {
      if(class238.field3257 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3257.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3257.method3048();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3241;
            class238.field3257 = null;
         }

      }
   }
}

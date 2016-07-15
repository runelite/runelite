import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class175 extends class207 {
   @ObfuscatedName("e")
   public class171 field2777;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 646839473
   )
   public int field2778;
   @ObfuscatedName("c")
   public byte field2779;
   @ObfuscatedName("n")
   static class13 field2782;

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2126426816"
   )
   static final void method3483() {
      for(class16 var0 = (class16)client.field427.method3899(); var0 != null; var0 = (class16)client.field427.method3918()) {
         if(var0.field230 == -1) {
            var0.field239 = 0;
            class5.method53(var0);
         } else {
            var0.method4000();
         }
      }

   }
}

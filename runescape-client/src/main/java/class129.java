import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class129 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1844817342"
   )
   static final void method2964() {
      if(class40.field904 != null) {
         class40.field904.method3131();
         class40.field904 = null;
      }

      class31.method693();
      class136.field2126.method1992();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field354[var0].method2493();
      }

      System.gc();
      class34.method755(2);
      client.field457 = -1;
      client.field533 = false;
      class142.method3089();
      class138.method3024(10);
   }
}

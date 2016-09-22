import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class151 extends RuntimeException {
   @ObfuscatedName("r")
   String field2289;
   @ObfuscatedName("d")
   public static String field2290;
   @ObfuscatedName("a")
   static Applet field2291;
   @ObfuscatedName("z")
   Throwable field2292;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1573726091
   )
   static int field2293;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1309594547"
   )
   static final void method3162() {
      if(Client.field333 > 0) {
         class137.method2908();
      } else {
         XItemContainer.setGameState(40);
         class10.field163 = BufferProvider.field1475;
         BufferProvider.field1475 = null;
      }
   }
}

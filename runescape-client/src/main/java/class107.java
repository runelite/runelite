import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class107 {
   @ObfuscatedName("m")
   static File field1731;
   @ObfuscatedName("b")
   static Hashtable field1732 = new Hashtable(16);
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 310289699
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("o")
   static boolean field1737 = false;

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "386402326"
   )
   static void method1992(int var0) {
      for(class133 var1 = (class133)Client.widgetFlags.method2296(); var1 != null; var1 = (class133)Client.widgetFlags.method2300()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "16777215"
   )
   static boolean method1996(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }
}

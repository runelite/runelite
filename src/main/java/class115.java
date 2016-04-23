import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class115 {
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = -773603593
   )
   @Export("cameraZ")
   static int field1952;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -3811053257872747169L
   )
   static long field1955;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2127028243"
   )
   static void method2440() {
      for(class23 var0 = (class23)class23.field593.method3784(); null != var0; var0 = (class23)class23.field593.method3777()) {
         if(null != var0.field589) {
            var0.method588();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "-1048149013"
   )
   public static void method2441(String[] var0, short[] var1) {
      class96.method2190(var0, var1, 0, var0.length - 1);
   }
}

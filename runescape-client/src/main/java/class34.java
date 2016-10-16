import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class34 {
   @ObfuscatedName("m")
   static int[] field739 = new int[2048];
   @ObfuscatedName("t")
   static byte[] field740 = new byte[2048];
   @ObfuscatedName("y")
   static byte[] field741 = new byte[2048];
   @ObfuscatedName("p")
   static Buffer[] field742 = new Buffer[2048];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -28646119
   )
   static int field743 = 0;
   @ObfuscatedName("n")
   static int[] field744 = new int[2048];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1574905151
   )
   static int field745 = 0;
   @ObfuscatedName("h")
   static int[] field747 = new int[2048];
   @ObfuscatedName("r")
   static int[] field748 = new int[2048];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1329428831
   )
   static int field750 = 0;
   @ObfuscatedName("d")
   static Buffer field751 = new Buffer(new byte[5000]);
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = -2063041645
   )
   protected static int field752;
   @ObfuscatedName("k")
   static int[] field754 = new int[2048];
   @ObfuscatedName("w")
   static int[] field755 = new int[2048];

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "0"
   )
   static void method727(File var0) {
      class138.field2124 = var0;
      if(!class138.field2124.exists()) {
         throw new RuntimeException("");
      } else {
         class138.field2132 = true;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2136734133"
   )
   static void method728(int var0, int var1) {
      Client.field300.method2748(209);
      Client.field300.method2565(var0);
      Client.field300.method2513(var1);
   }
}

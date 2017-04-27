import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public final class class25 extends Node {
   @ObfuscatedName("cq")
   public static char field571;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1738911739
   )
   int field572;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1493479849
   )
   int field573;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -687664959
   )
   int field574;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1974317475
   )
   int field575;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2080561995
   )
   int field576;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -726253813
   )
   int field577;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -571492997
   )
   int field578;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1095374499
   )
   int field579;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 569309071
   )
   int field580;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 537339127
   )
   int field581 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1170290131
   )
   int field582 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 412647969
   )
   int field585;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[BLIndexFile;B)V",
      garbageValue = "48"
   )
   static void method573(int var0, byte[] var1, IndexFile var2) {
      class182 var3 = new class182();
      var3.field2702 = 0;
      var3.hash = (long)var0;
      var3.field2695 = var1;
      var3.field2697 = var2;
      Deque var4 = class185.field2727;
      synchronized(class185.field2727) {
         class185.field2727.method2824(var3);
      }

      Object var9 = class185.field2730;
      synchronized(class185.field2730) {
         if(class185.field2729 == 0) {
            class185.field2731 = new Thread(new class185());
            class185.field2731.setDaemon(true);
            class185.field2731.start();
            class185.field2731.setPriority(5);
         }

         class185.field2729 = 600;
      }
   }
}

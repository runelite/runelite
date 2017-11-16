import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class70 implements Runnable {
   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field802;
   @ObfuscatedName("k")
   @Export("spritePixels")
   static byte[][] spritePixels;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = -1090618991
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 430357985
   )
   static int field793;
   @ObfuscatedName("b")
   boolean field803;
   @ObfuscatedName("s")
   Object field797;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1736388141
   )
   int field795;
   @ObfuscatedName("g")
   int[] field799;
   @ObfuscatedName("x")
   int[] field794;

   class70() {
      this.field803 = true;
      this.field797 = new Object();
      this.field795 = 0;
      this.field799 = new int[500];
      this.field794 = new int[500];
   }

   public void run() {
      for(; this.field803; GZipDecompressor.method3129(50L)) {
         Object var1 = this.field797;
         synchronized(this.field797) {
            if(this.field795 < 500) {
               this.field799[this.field795] = MouseInput.field681;
               this.field794[this.field795] = MouseInput.field676;
               ++this.field795;
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-25"
   )
   static void method1050(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }
}

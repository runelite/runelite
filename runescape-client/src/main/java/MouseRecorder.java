import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   static IndexedSprite field812;
   @ObfuscatedName("kc")
   @ObfuscatedGetter(
      intValue = 690395125
   )
   static int field817;
   @ObfuscatedName("n")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("v")
   @Export("lock")
   Object lock;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1208303387
   )
   @Export("index")
   int index;
   @ObfuscatedName("r")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("h")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; class61.method1077(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;ZB)V",
      garbageValue = "1"
   )
   public static void method1119(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3522 = var1;
      ObjectComposition.ObjectDefinition_isLowDetail = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   static int method1116() {
      return 11;
   }
}

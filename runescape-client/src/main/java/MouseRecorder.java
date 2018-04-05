import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Lin;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("ap")
   static int[] field819;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("o")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("k")
   @Export("lock")
   Object lock;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 301739479
   )
   @Export("index")
   int index;
   @ObfuscatedName("d")
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
      for(; this.isRunning; ScriptVarType.method11(50L)) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1688891512"
   )
   static void method1145() {
      if(WorldMapDecorationType.loadWorlds()) {
         class90.worldSelectShown = true;
      }

   }
}

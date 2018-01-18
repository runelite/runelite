import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 433254391
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 141605773
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1065730419
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1487602585
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1333183839
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1866921115
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 179650203
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   public static void method2930() {
      while(true) {
         Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.load(var0.index, (int)var0.hash, var0.field3299, false);
      }
   }
}

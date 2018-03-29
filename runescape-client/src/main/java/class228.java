import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class228 {
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("c")
   byte[] field2674;
   @ObfuscatedName("i")
   byte[] field2668;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2081667259
   )
   int field2669;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -983114885
   )
   int field2670;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1868928017
   )
   int field2675;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1934327607
   )
   int field2672;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1052578933
   )
   int field2673;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -822011699
   )
   int field2667;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -182592645
   )
   int field2671;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILfa;Ljs;S)V",
      garbageValue = "-15333"
   )
   static void method4120(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.type = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var3);
      }

      class55.method829();
   }
}

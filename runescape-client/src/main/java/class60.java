import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public final class class60 {
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 1097629993
   )
   static int field681;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 1395462501
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1141511745"
   )
   public static void method1016() {
      while(true) {
         Deque var1 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         FileSystem var0;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            var0 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_responseQueue.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.load(var0.index, (int)var0.hash, var0.field3276, false);
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lho;I)V",
      garbageValue = "-1880361395"
   )
   static void method1015(Widget var0) {
      if(var0.loopCycle == Client.field1024) {
         Client.field1012[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      signature = "(Lho;I)I",
      garbageValue = "2052374811"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}

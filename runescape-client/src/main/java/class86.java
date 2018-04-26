import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class86 {
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 2137088647
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[Lkz;",
      garbageValue = "-1939522517"
   )
   public static Parameters[] method1964() {
      return new Parameters[]{Parameters.field3802, Parameters.field3806, Parameters.field3809, Parameters.field3803, Parameters.field3810, Parameters.field3813, Parameters.field3807, Parameters.field3800, Parameters.field3804, Parameters.field3812, Parameters.field3816, Parameters.field3808, Parameters.field3801, Parameters.field3815, Parameters.field3811, Parameters.field3805};
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILfr;Lji;I)V",
      garbageValue = "2053839921"
   )
   static void method1962(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         for(FileSystem var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.type == 0) {
               var3 = var5.field3358;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.load(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.read(var0);
         var2.load(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1380201914"
   )
   static void method1965(int var0) {
      class264.topContextMenuRow = new ContextMenuRow();
      class264.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      class264.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      class264.topContextMenuRow.type = Client.menuTypes[var0];
      class264.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      class264.topContextMenuRow.option = Client.menuOptions[var0];
   }
}

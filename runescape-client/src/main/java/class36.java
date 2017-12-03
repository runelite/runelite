import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class36 {
   @ObfuscatedName("od")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class36 field476;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class36 field471;
   @ObfuscatedName("ad")
   static int[] field478;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = 1715250021
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -998767347
   )
   final int field472;

   static {
      field476 = new class36(0);
      field471 = new class36(1);
   }

   class36(int var1) {
      this.field472 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-96"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class222.varpsMasks[var5 - var4];
      return class222.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILfv;Liu;I)V",
      garbageValue = "390709907"
   )
   static void method497(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         for(FileSystem var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.type == 0) {
               var3 = var5.field3299;
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

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "338988927"
   )
   static void method498(int var0, int var1, int var2) {
      if(Client.field1066 != 0 && var1 != 0 && Client.field1068 < 50) {
         Client.field1069[Client.field1068] = var0;
         Client.field1070[Client.field1068] = var1;
         Client.field1071[Client.field1068] = var2;
         Client.audioEffects[Client.field1068] = null;
         Client.field1072[Client.field1068] = 0;
         ++Client.field1068;
      }

   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Lhz;I)I",
      garbageValue = "-446153179"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}

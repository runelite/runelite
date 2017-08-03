import java.math.BigInteger;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class87 {
   @ObfuscatedName("e")
   static final BigInteger field1347;
   @ObfuscatedName("f")
   static final BigInteger field1348;

   static {
      field1347 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1348 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;III)Ljt;",
      garbageValue = "-481016505"
   )
   public static Font method1713(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!WallObject.method2899(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class270.field3666, class286.offsetsY, class286.field3778, class286.field3782, class286.field3783, class177.spritePixels);
            class229.method4093();
            var4 = var6;
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1759089571"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.listFetcher == null) {
            World.listFetcher = new WorldListFetcher(GameEngine.taskManager, new URL(class251.field3368));
         } else {
            byte[] var0 = World.listFetcher.fetch();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.worldCount = var1.readUnsignedShort();
               World.worldList = new World[World.worldCount];

               World var3;
               for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class13.method76(World.worldList, 0, World.worldList.length - 1, World.field1266, World.field1265);
               World.listFetcher = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "66"
   )
   static int method1711(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}

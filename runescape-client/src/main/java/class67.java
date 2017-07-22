import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class67 extends class196 {
   @ObfuscatedName("l")
   static int[] field816;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -285289231
   )
   int field819;
   @ObfuscatedName("o")
   String field813;
   @ObfuscatedName("i")
   short field815;

   class67(String var1, int var2) {
      this.field819 = (int)(class157.currentTimeMs() / 1000L);
      this.field813 = var1;
      this.field815 = (short)var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILfz;Lix;I)V",
      garbageValue = "-204360795"
   )
   static void method1043(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3171 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class236.field3207;
      synchronized(class236.field3207) {
         class236.field3207.addFront(var3);
      }

      Object var9 = class236.field3203;
      synchronized(class236.field3203) {
         if(class236.field3205 == 0) {
            class19.field316 = new Thread(new class236());
            class19.field316.setDaemon(true);
            class19.field316.start();
            class19.field316.setPriority(5);
         }

         class236.field3205 = 600;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-568782269"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class265.listFetcher == null) {
            class265.listFetcher = new WorldListFetcher(GameEngine.taskManager, new URL(class220.field2783));
         } else {
            byte[] var0 = class265.listFetcher.fetch();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.worldCount = var1.readUnsignedShort();
               class64.worldList = new World[World.worldCount];

               World var3;
               for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
                  var3 = class64.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class1.method1(class64.worldList, 0, class64.worldList.length - 1, World.field1281, World.field1285);
               class265.listFetcher = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class265.listFetcher = null;
      }

      return false;
   }
}

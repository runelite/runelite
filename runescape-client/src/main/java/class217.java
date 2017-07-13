import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class217 {
   @ObfuscatedName("a")
   public static IndexDataBase field2790;

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "768665446"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3229 != 0 && var3 > IndexDataBase.field3229) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3229 != 0 && var6 > IndexDataBase.field3229) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3076(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-69"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class112.worldServersDownload == null) {
            class112.worldServersDownload = new class77(GameEngine.taskManager, new URL(MouseInput.field733));
         } else {
            byte[] var0 = class112.worldServersDownload.method1481();
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

               PacketBuffer.method3403(World.worldList, 0, World.worldList.length - 1, World.field1303, World.field1288);
               class112.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class112.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "297953057"
   )
   static int method4042(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1844();
   }
}

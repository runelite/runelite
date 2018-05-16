import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("fo")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -277523073
   )
   static int field481;
   @ObfuscatedName("m")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("q")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2110619792"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      Varbit.method4951();
      ++Client.field739.field1252;
      if(Client.field739.field1252 >= 50 || var0) {
         Client.field739.field1252 = 0;
         if(!Client.socketError && Client.field739.getSocket() != null) {
            PacketNode var1 = DecorativeObject.method3115(ClientPacket.field2217, Client.field739.field1250);
            Client.field739.method2019(var1);

            try {
               Client.field739.method2034();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }
}

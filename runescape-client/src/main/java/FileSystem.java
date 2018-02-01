import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1706206405
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   byte[] field3276;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lio;IIIBZI)V",
      garbageValue = "-509113099"
   )
   @Export("requestNetFile")
   static void requestNetFile(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class249.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class249.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class249.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class249.NetCache_pendingPriorityWrites.put(var8, var6);
                  --class249.NetCache_pendingWritesCount;
                  ++class249.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class249.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class249.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++class249.NetCache_pendingPriorityWritesCount;
               } else {
                  class249.NetCache_pendingWritesQueue.push(var8);
                  class249.NetCache_pendingWrites.put(var8, var6);
                  ++class249.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }
}

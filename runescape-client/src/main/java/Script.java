import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static NodeCache field1437;
   @ObfuscatedName("e")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("b")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("z")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -624934099
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1417230295
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 612836597
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1063778083
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Lhh;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1437 = new NodeCache(128);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[Lhh;",
      garbageValue = "-935210531"
   )
   IterableHashTable[] method2099(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lji;IIIBZS)V",
      garbageValue = "-17229"
   )
   @Export("requestNetFile")
   static void requestNetFile(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class264.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class264.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class264.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++class264.NetCache_pendingPriorityWritesCount;
               } else {
                  class264.NetCache_pendingWritesQueue.push(var8);
                  class264.NetCache_pendingWrites.put(var8, var6);
                  ++class264.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgl;B)I",
      garbageValue = "-35"
   )
   static int method2103(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }
}

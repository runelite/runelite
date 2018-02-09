import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2131907637
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1486307811
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -575521317
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1387692552"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "79"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lij;IIIBZB)V",
      garbageValue = "-66"
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

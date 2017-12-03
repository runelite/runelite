import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("a")
   boolean field837;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "-1846724803"
   )
   int method1103(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field837) {
            if(Client.world == var1.world) {
               return -1;
            }

            if(var2.world == Client.world) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1103((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1833334710"
   )
   public static void method1116(int var0) {
      if(class214.field2620 != 0) {
         class214.field2625 = var0;
      } else {
         class282.field3753.method3843(var0);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Liu;IIIBZI)V",
      garbageValue = "-1716084241"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1784753058"
   )
   public static int method1113(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "113"
   )
   static void method1114() {
      class94.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class94.field1392[var0] = null;
         class94.field1388[var0] = 1;
      }

   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "760"
   )
   static void method1102() {
      class41.method574();
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}

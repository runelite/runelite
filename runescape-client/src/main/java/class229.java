import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class229 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field2688;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field2693;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field2689;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   public static class230 field2690;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1868776503
   )
   public static int field2694;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field2687;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2000070787
   )
   public static int field2691;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -841866287
   )
   public static int field2692;

   static {
      field2694 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljs;IIIBZI)V",
      garbageValue = "-159576396"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1569507818"
   )
   public static void method4237() {
      KitDefinition.identKits.reset();
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class175 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1736289439
   )
   static int field2398;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 983686233
   )
   static int field2397;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -381855049
   )
   static int field2396;
   @ObfuscatedName("p")
   static byte[][] field2399;
   @ObfuscatedName("x")
   static byte[][] field2400;
   @ObfuscatedName("g")
   static byte[][] field2401;

   static {
      field2398 = 0;
      field2397 = 0;
      field2396 = 0;
      field2399 = new byte[1000][];
      field2400 = new byte[250][];
      field2401 = new byte[50][];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-136856849"
   )
   static synchronized byte[] method3385(int var0) {
      byte[] var1;
      if(var0 == 100 && field2398 > 0) {
         var1 = field2399[--field2398];
         field2399[field2398] = null;
         return var1;
      } else if(var0 == 5000 && field2397 > 0) {
         var1 = field2400[--field2397];
         field2400[field2397] = null;
         return var1;
      } else if(var0 == 30000 && field2396 > 0) {
         var1 = field2401[--field2396];
         field2401[field2396] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lil;IIIBZI)V",
      garbageValue = "-2104560434"
   )
   static void method3389(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class239.field3250.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class239.field3241.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class239.field3239.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class239.field3250.put(var8, var6);
                  --class239.field3245;
                  ++class239.field3240;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class239.field3253.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class239.field3250.put(var8, var6);
                  ++class239.field3240;
               } else {
                  class239.field3243.push(var8);
                  class239.field3239.put(var8, var6);
                  ++class239.field3245;
               }

            }
         }
      }
   }
}

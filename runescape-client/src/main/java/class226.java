import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class226 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;B)V",
      garbageValue = "124"
   )
   static void method4100(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3233;
      synchronized(class236.field3233) {
         for(FileSystem var5 = (FileSystem)class236.field3233.method3622(); var5 != null; var5 = (FileSystem)class236.field3233.method3608()) {
            if((long)var0 == var5.hash && var5.index == var1 && var5.field3204 == 0) {
               var3 = var5.field3200;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4238(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3008(var0);
         var2.method4238(var1, var0, var8, true);
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class140 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "-102"
   )
   static void method2867(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(PendingSpawn.method1481(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method2867(var0, var7 - 1, var2, var3, var4, var5);
         method2867(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-68"
   )
   static int method2868() {
      return Client.isResized?2:1;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class66 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static final class66 field784;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static final class66 field785;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static final class66 field786;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   static final class66 field787;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static IndexedSprite field788;

   static {
      field784 = new class66();
      field785 = new class66();
      field786 = new class66();
      field787 = new class66();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILfv;Lib;S)V",
      garbageValue = "26536"
   )
   static void method1109(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3220;
      synchronized(class236.field3220) {
         for(FileSystem var5 = (FileSystem)class236.field3220.getFront(); var5 != null; var5 = (FileSystem)class236.field3220.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.field3180 == 0) {
               var3 = var5.field3181;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4235(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3043(var0);
         var2.method4235(var1, var0, var8, true);
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public abstract class class158 {
   @ObfuscatedName("lj")
   static Widget[] field2287;
   @ObfuscatedName("po")
   static class102 field2288;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   public abstract void vmethod2971();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-472854462"
   )
   public abstract int vmethod2972(int var1, int var2);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;I)V",
      garbageValue = "-1865526402"
   )
   static void method2973(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3238;
      synchronized(class236.field3238) {
         for(class233 var5 = (class233)class236.field3238.method3576(); var5 != null; var5 = (class233)class236.field3238.method3578()) {
            if(var5.hash == (long)var0 && var1 == var5.field3199 && var5.field3207 == 0) {
               var3 = var5.field3198;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4223(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3008(var0);
         var2.method4223(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   static final void method2978(int var0, int var1) {
      if(RSSocket.method2986(var0)) {
         MessageNode.method1099(CombatInfo1.widgets[var0], var1);
      }
   }
}

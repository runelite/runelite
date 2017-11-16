import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public abstract class class164 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1160721351
   )
   static int field2212;
   @ObfuscatedName("au")
   static int[] field2208;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -337881751
   )
   public int field2210;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 440716055
   )
   public int field2209;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -236547587
   )
   public int field2213;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -488099323
   )
   public int field2211;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILfy;I)Z",
      garbageValue = "1851420855"
   )
   protected abstract boolean vmethod3088(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("s")
   static final void method3084(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "-9621"
   )
   static synchronized void method3083(byte[] var0) {
      if(var0.length == 100 && class181.field2500 < 1000) {
         class181.field2501[++class181.field2500 - 1] = var0;
      } else if(var0.length == 5000 && class181.field2499 < 250) {
         class181.field2502[++class181.field2499 - 1] = var0;
      } else if(var0.length == 30000 && class181.field2498 < 50) {
         class181.field2503[++class181.field2498 - 1] = var0;
      } else {
         if(class90.field1323 != null) {
            for(int var1 = 0; var1 < FrameMap.field1954.length; ++var1) {
               if(var0.length == FrameMap.field1954[var1] && class181.field2504[var1] < class90.field1323[var1].length) {
                  class90.field1323[var1][class181.field2504[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "98"
   )
   static final void method3089(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class14.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field674, MouseInput.field688);
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class172 {
   @ObfuscatedName("h")
   public static int[] field2352 = new int[99];
   @ObfuscatedName("d")
   public static final boolean[] field2354 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2352[var1] = var0 / 4;
      }

   }

   class172() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)V",
      garbageValue = "-6"
   )
   static final void method3273(String var0, int var1) {
      Client.field348.method3073(241);
      Client.field348.method2918(class119.method2340(var0) + 1);
      Client.field348.method2918(var1);
      Client.field348.method2824(var0);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1137285500"
   )
   static final void method3274(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class171.menuAction(var1, var2, var3, var4, var5, var6, class115.field1796, class115.field1806);
      }
   }
}

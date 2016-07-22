import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class9 {
   @ObfuscatedName("g")
   static final BigInteger field141 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("l")
   static final BigInteger field142 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 1621370771
   )
   @Export("cameraX")
   static int field144;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 458167719
   )
   static int field149;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[Lclass83;",
      garbageValue = "465504215"
   )
   public static class83[] method121(class170 var0, String var1, String var2) {
      int var3 = var0.method3319(var1);
      int var4 = var0.method3368(var3, var2);
      return class140.method2984(var0, var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "494170487"
   )
   static void method122(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method122(var0, var1, var2, var5 - 1);
         method122(var0, var1, 1 + var5, var3);
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("GroundObject")
public final class class93 {
   @ObfuscatedName("i")
   static int[] field1565;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 908208307
   )
   @Export("floor")
   int field1566;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -201429215
   )
   @Export("y")
   int field1567;
   @ObfuscatedName("d")
   @Export("renderable")
   public class85 field1568;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -140604811
   )
   @Export("hash")
   public int field1569;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 26227491
   )
   @Export("x")
   int field1570;
   @ObfuscatedName("nq")
   static class56 field1572;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1321912311
   )
   int field1575;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lclass130;",
      garbageValue = "1607718421"
   )
   static class130[] method2170() {
      return new class130[]{class130.field2042, class130.field2043, class130.field2044};
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-100"
   )
   @Export("groundItemSpawned")
   static final void method2171(int var0, int var1) {
      class199 var2 = client.field420[class144.field2193][var0][var1];
      if(null == var2) {
         class150.field2230.method2009(class144.field2193, var0, var1);
      } else {
         long var3 = -99999999L;
         class28 var5 = null;

         class28 var6;
         for(var6 = (class28)var2.method3844(); var6 != null; var6 = (class28)var2.method3834()) {
            class51 var7 = class35.method741(var6.field672);
            long var8 = (long)var7.field1097;
            if(var7.field1096 == 1) {
               var8 *= (long)(var6.field671 + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            class150.field2230.method2009(class144.field2193, var0, var1);
         } else {
            var2.method3820(var5);
            class28 var11 = null;
            class28 var10 = null;

            for(var6 = (class28)var2.method3844(); var6 != null; var6 = (class28)var2.method3834()) {
               if(var5.field672 != var6.field672) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var6.field672 != var11.field672 && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class150.field2230.method1932(class144.field2193, var0, var1, class108.method2413(var0 * 128 + 64, var1 * 128 + 64, class144.field2193), var5, var9, var11, var10);
         }
      }
   }
}

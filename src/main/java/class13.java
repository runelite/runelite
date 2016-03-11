import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class13 implements Runnable {
   @ObfuscatedName("l")
   Object field198 = new Object();
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 2073468339
   )
   static int field199;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 208238489
   )
   static int field200;
   @ObfuscatedName("i")
   int[] field202 = new int[500];
   @ObfuscatedName("j")
   boolean field203 = true;
   @ObfuscatedName("e")
   static int[] field204;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1218314907
   )
   int field205 = 0;
   @ObfuscatedName("f")
   int[] field206 = new int[500];

   @ObfuscatedName("cn")
   static void method154(class172[] var0, class172 var1, boolean var2) {
      int var3 = var1.field2782 != 0?var1.field2782:var1.field2774;
      int var4 = 0 != var1.field2783?var1.field2783:var1.field2890;
      class125.method2744(var0, var1.field2759 * -1, var3, var4, var2);
      if(null != var1.field2881) {
         class125.method2744(var1.field2881, var1.field2759 * -1, var3, var4, var2);
      }

      class3 var5 = (class3)client.field449.method3744((long)(var1.field2759 * -1));
      if(null != var5) {
         class95.method2166(var5.field66, var3, var4, var2);
      }

      if(1337 == var1.field2763) {
         ;
      }

   }

   public void run() {
      for(; this.field203; class105.method2332(50L)) {
         Object var1 = this.field198;
         synchronized(this.field198) {
            if(this.field205 < 500) {
               this.field202[this.field205] = class139.field2162;
               this.field206[this.field205] = class139.field2171;
               ++this.field205;
            }
         }
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Lclass172;IIIIIII)V",
      garbageValue = "-1342971075"
   )
   static final void method158(class172 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field435) {
         client.field371 = 32;
      } else {
         client.field371 = 0;
      }

      client.field435 = false;
      int var7;
      if(class139.field2161 == 1 || !class94.field1617 && class139.field2161 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < var2 + 16) {
            var0.field2886 -= 4;
            class114.method2400(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.field2886 += 4;
            class114.method2400(var0);
         } else if(var5 >= var1 - client.field371 && var5 < client.field371 + var1 + 16 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2886 = (var4 - var3) * var8 / var9;
            class114.method2400(var0);
            client.field435 = true;
         }
      }

      if(client.field486 != 0) {
         var7 = var0.field2774;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.field2886 += client.field486 * 45;
            class114.method2400(var0);
         }
      }

   }

   @ObfuscatedName("b")
   public static boolean method159(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:8364 == var0 || var0 == 338 || 8212 == var0 || 339 == var0 || var0 == 376);
   }
}

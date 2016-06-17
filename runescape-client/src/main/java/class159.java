import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class159 implements class112 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -342460055
   )
   final int field2589;
   @ObfuscatedName("g")
   public static final class159 field2590 = new class159(3, 1);
   @ObfuscatedName("b")
   public static final class159 field2591 = new class159(1, 0);
   @ObfuscatedName("d")
   public static final class159 field2592 = new class159(0, 3);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1725265289
   )
   public final int field2593;
   @ObfuscatedName("j")
   public static final class159 field2594 = new class159(2, 2);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "977914203"
   )
   public int vmethod3185() {
      return this.field2589;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1"
   )
   class159(int var1, int var2) {
      this.field2593 = var1;
      this.field2589 = var2;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "([Lclass173;II)V",
      garbageValue = "1198922324"
   )
   static final void method3188(class173[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class173 var3 = var0[var2];
         if(var3 != null && var1 == var3.field2777 && (!var3.field2741 || !class12.method150(var3))) {
            if(var3.field2833 == 0) {
               if(!var3.field2741 && class12.method150(var3) && class172.field2732 != var3) {
                  continue;
               }

               method3188(var0, var3.field2748);
               if(var3.field2872 != null) {
                  method3188(var3.field2872, var3.field2748);
               }

               class3 var7 = (class3)client.field448.method3807((long)var3.field2748);
               if(null != var7) {
                  class142.method3014(var7.field60);
               }
            }

            if(var3.field2833 == 6) {
               int var5;
               if(var3.field2752 != -1 || var3.field2845 != -1) {
                  boolean var4 = class95.method2186(var3);
                  if(var4) {
                     var5 = var3.field2845;
                  } else {
                     var5 = var3.field2752;
                  }

                  if(var5 != -1) {
                     class42 var6 = class17.method178(var5);

                     for(var3.field2855 += client.field538; var3.field2855 > var6.field983[var3.field2870]; class4.method37(var3)) {
                        var3.field2855 -= var6.field983[var3.field2870];
                        ++var3.field2870;
                        if(var3.field2870 >= var6.field965.length) {
                           var3.field2870 -= var6.field966;
                           if(var3.field2870 < 0 || var3.field2870 >= var6.field965.length) {
                              var3.field2870 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2779 != 0 && !var3.field2741) {
                  int var8 = var3.field2779 >> 16;
                  var5 = var3.field2779 << 16 >> 16;
                  var8 *= client.field538;
                  var5 *= client.field538;
                  var3.field2839 = var3.field2839 + var8 & 2047;
                  var3.field2800 = var3.field2800 + var5 & 2047;
                  class4.method37(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(IIII)Lclass3;",
      garbageValue = "-1301168929"
   )
   static final class3 method3189(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field60 = var1;
      var3.field54 = var2;
      client.field448.method3797(var3, (long)var0);
      class14.method164(var1);
      class173 var4 = class161.method3205(var0);
      class4.method37(var4);
      if(client.field451 != null) {
         class4.method37(client.field451);
         client.field451 = null;
      }

      class26.method635();
      class9.method121(class173.field2750[var0 >> 16], var4, false);
      class32.method711(var1);
      if(client.field456 != -1) {
         class32.method720(client.field456, 1);
      }

      return var3;
   }
}

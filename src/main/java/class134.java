import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class134 {
   @ObfuscatedName("a")
   static boolean field2075 = false;
   @ObfuscatedName("r")
   static File field2076;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -416896633
   )
   public static int field2077;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -257538207
   )
   public static int field2078;
   @ObfuscatedName("f")
   static Hashtable field2079 = new Hashtable(16);

   @ObfuscatedName("r")
   public static class42 method2875(int var0) {
      class42 var1 = (class42)class42.field986.method3792((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field991.method3263(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method874(new class118(var2));
         }

         var1.method870();
         class42.field986.method3794(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "([Lclass172;IB)V",
      garbageValue = "1"
   )
   static final void method2879(class172[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class172 var3 = var0[var2];
         if(var3 != null) {
            if(0 == var3.field2764) {
               if(var3.field2865 != null) {
                  method2879(var3.field2865, var1);
               }

               class3 var4 = (class3)client.field454.method3824((long)(var3.field2800 * -1));
               if(var4 != null) {
                  int var5 = var4.field56;
                  if(class103.method2303(var5)) {
                     method2879(class172.field2850[var5], var1);
                  }
               }
            }

            class0 var6;
            if(var1 == 0 && null != var3.field2848) {
               var6 = new class0();
               var6.field6 = var3;
               var6.field8 = var3.field2848;
               class150.method3148(var6);
            }

            if(var1 == 1 && var3.field2849 != null) {
               if(var3.field2744 >= 0) {
                  class172 var7 = class92.method2180(var3.field2800 * -1);
                  if(var7 == null || var7.field2865 == null || var3.field2744 >= var7.field2865.length || var3 != var7.field2865[var3.field2744]) {
                     continue;
                  }
               }

               var6 = new class0();
               var6.field6 = var3;
               var6.field8 = var3.field2849;
               class150.method3148(var6);
            }
         }
      }

   }
}

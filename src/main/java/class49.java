import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("av")
public class class49 extends class203 {
   @ObfuscatedName("j")
   public static class166 field1088;
   @ObfuscatedName("a")
   public boolean field1090 = false;
   @ObfuscatedName("l")
   static class192 field1092 = new class192(64);

   @ObfuscatedName("a")
   void method997(int var1) {
      if(var1 == 2) {
         this.field1090 = true;
      }

   }

   @ObfuscatedName("l")
   void method998(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method997(var2);
      }
   }

   @ObfuscatedName("cz")
   static void method1006(int var0, int var1) {
      client.method306(class11.field180, var0, var1);
      class11.field180 = null;
   }

   @ObfuscatedName("ci")
   static final void method1007(class172 var0, int var1, int var2) {
      if(null == client.field536 && !client.field308) {
         if(var0 != null && class89.method2057(var0) != null) {
            client.field536 = var0;
            client.field297 = class89.method2057(var0);
            client.field428 = var1;
            client.field464 = var2;
            class83.field1458 = 0;
            client.field314 = false;
            if(client.field430 > 0) {
               int var3 = client.field430 - 1;
               class11.field180 = new class30();
               class11.field180.field704 = client.field431[var3];
               class11.field180.field696 = client.field432[var3];
               class11.field180.field705 = client.field433[var3];
               class11.field180.field698 = client.field523[var3];
               class11.field180.field697 = client.field437[var3];
            }

         }
      }
   }

   @ObfuscatedName("l")
   public static boolean method1008(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class164.field2668;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}

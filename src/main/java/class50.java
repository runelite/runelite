import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class50 extends class204 {
   @ObfuscatedName("x")
   static class193 field1108 = new class193(64);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -442800065
   )
   public int field1109 = 0;
   @ObfuscatedName("w")
   public static class167 field1110;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2002364319
   )
   public static int field1111;

   @ObfuscatedName("x")
   void method1046(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(var2 == 0) {
            return;
         }

         this.method1057(var1, var2);
      }
   }

   @ObfuscatedName("w")
   public static class51 method1055(int var0) {
      class51 var1 = (class51)class51.field1117.method3771((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class26.field672.method3335(10, var0);
         var1 = new class51();
         var1.field1127 = var0;
         if(var2 != null) {
            var1.method1061(new class119(var2));
         }

         var1.method1095();
         if(var1.field1153 != -1) {
            var1.method1063(method1055(var1.field1153), method1055(var1.field1150));
         }

         if(var1.field1152 != -1) {
            var1.method1064(method1055(var1.field1152), method1055(var1.field1161));
         }

         if(!class51.field1115 && var1.field1135) {
            var1.field1122 = "Members object";
            var1.field1160 = false;
            var1.field1136 = null;
            var1.field1112 = null;
            var1.field1159 = 0;
         }

         class51.field1117.method3773(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1961342873"
   )
   static final void method1056(boolean var0) {
      for(int var1 = 0; var1 < client.field332; ++var1) {
         class34 var2 = client.field331[client.field333[var1]];
         int var3 = 536870912 + (client.field333[var1] << 14);
         if(var2 != null && var2.vmethod781() && var2.field781.field910 == var0 && var2.field781.method794()) {
            int var4 = var2.field849 >> 7;
            int var5 = var2.field819 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(1 == var2.field822 && 64 == (var2.field849 & 127) && 64 == (var2.field819 & 127)) {
                  if(client.field398[var4][var5] == client.field329) {
                     continue;
                  }

                  client.field398[var4][var5] = client.field329;
               }

               if(!var2.field781.field896) {
                  var3 -= Integer.MIN_VALUE;
               }

               class3.field75.method1919(class82.field1437, var2.field849, var2.field819, class43.method938(var2.field849 + (var2.field822 * 64 - 64), var2.field822 * 64 - 64 + var2.field819, class82.field1437), var2.field822 * 64 - 64 + 60, var2, var2.field820, var3, var2.field870);
            }
         }
      }

   }

   @ObfuscatedName("t")
   void method1057(class119 var1, int var2) {
      if(2 == var2) {
         this.field1109 = var1.method2508();
      }

   }

   @ObfuscatedName("cd")
   static final boolean method1058(class173 var0) {
      if(var0.field2880 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2880.length; ++var1) {
            int var2 = class15.method179(var0, var1);
            int var3 = var0.field2881[var1];
            if(2 == var0.field2880[var1]) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(3 == var0.field2880[var1]) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(4 == var0.field2880[var1]) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}

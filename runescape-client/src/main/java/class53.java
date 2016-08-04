import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class53 extends class207 {
   @ObfuscatedName("l")
   static class170 field1164;
   @ObfuscatedName("r")
   public boolean field1166 = false;
   @ObfuscatedName("g")
   static class196 field1167 = new class196(64);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-1522750207"
   )
   void method1134(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1135(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1273892065"
   )
   void method1135(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1166 = true;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass136;",
      garbageValue = "-1279913920"
   )
   static class136 method1137() {
      try {
         return new class150();
      } catch (Throwable var1) {
         return new class144();
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "229"
   )
   static int method1139() {
      return client.field507?2:1;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "([Lclass176;Lclass176;ZI)V",
      garbageValue = "-142847619"
   )
   static void method1145(class176[] var0, class176 var1, boolean var2) {
      int var3 = var1.field2830 != 0?var1.field2830:var1.field2822;
      int var4 = var1.field2831 != 0?var1.field2831:var1.field2823;
      class0.method2(var0, var1.field2807, var3, var4, var2);
      if(null != var1.field2931) {
         class0.method2(var1.field2931, var1.field2807, var3, var4, var2);
      }

      class3 var5 = (class3)client.field475.method3936((long)var1.field2807);
      if(var5 != null) {
         int var6 = var5.field70;
         if(class14.method179(var6)) {
            class0.method2(class176.field2836[var6], -1, var3, var4, var2);
         }
      }

      if(var1.field2811 == 1337) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   public static void method1147() {
      while(true) {
         class202 var1 = class173.field2765;
         class172 var0;
         synchronized(class173.field2765) {
            var0 = (class172)class173.field2761.method3966();
         }

         if(var0 == null) {
            return;
         }

         var0.field2758.method3483(var0.field2759, (int)var0.field3175, var0.field2755, false);
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Z",
      garbageValue = "22"
   )
   static final boolean method1149(class176 var0) {
      if(null == var0.field2920) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2920.length; ++var1) {
            int var2 = class31.method689(var0, var1);
            int var3 = var0.field2921[var1];
            if(var0.field2920[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2920[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2920[var1] == 4) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2105001500"
   )
   static final boolean method1150(int var0, int var1) {
      class42 var2 = class160.method3312(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method849(var1);
   }
}

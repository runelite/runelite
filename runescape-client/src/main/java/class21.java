import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class21 implements Comparator {
   @ObfuscatedName("h")
   public static boolean field575;
   @ObfuscatedName("bi")
   static class168 field576;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIS)Z",
      garbageValue = "-19994"
   )
   static boolean method551(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3221(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class163.method3181(var3);
         return true;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method552((class214)var1, (class214)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "934443362"
   )
   int method552(class214 var1, class214 var2) {
      if(var1.field3160 == var2.field3160) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(client.field478 == var1.field3160) {
               return -1;
            }

            if(client.field478 == var2.field3160) {
               return 1;
            }
         }

         return var1.field3160 < var2.field3160?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Lclass52;",
      garbageValue = "49"
   )
   public static class52 method557(int var0) {
      class52 var1 = (class52)class52.field1169.method3716((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class52.field1172.method3221(16, var0);
         var1 = new class52();
         if(var2 != null) {
            var1.method1049(new class119(var2));
         }

         class52.field1169.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-30256"
   )
   public static void method558() {
      class140 var0 = class140.field2186;
      synchronized(class140.field2186) {
         class140.field2178 = class140.field2175;
         class140.field2192 = class140.field2180;
         class140.field2189 = class140.field2177;
         class140.field2185 = class140.field2181;
         class140.field2190 = class140.field2182;
         class140.field2187 = class140.field2183;
         class140.field2188 = class140.field2184;
         class140.field2181 = 0;
      }
   }
}

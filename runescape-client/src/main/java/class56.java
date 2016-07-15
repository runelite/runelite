import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class56 extends class207 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1699041929
   )
   public static int field1229;
   @ObfuscatedName("a")
   static class170 field1230;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1767437133
   )
   public int field1231 = 0;
   @ObfuscatedName("c")
   static class196 field1232 = new class196(64);
   @ObfuscatedName("e")
   static class170 field1233;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "1016466166"
   )
   public static class51 method1223(int var0) {
      class51 var1 = (class51)class51.field1123.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1138.method3340(32, var0);
         var1 = new class51();
         if(null != var2) {
            var1.method1092(new class122(var2));
         }

         class51.field1123.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-32"
   )
   void method1224(class122 var1, int var2) {
      if(var2 == 5) {
         this.field1231 = var1.method2612();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lclass156;",
      garbageValue = "-1867738619"
   )
   static class156[] method1228() {
      return new class156[]{class156.field2322, class156.field2324, class156.field2323, class156.field2328};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1519820578"
   )
   void method1235(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1224(var1, var2);
      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-1351063452"
   )
   static void method1236(int var0, int var1, int var2, int var3, String var4) {
      class176 var5 = class93.method2180(var1, var2);
      if(null != var5) {
         if(var5.field2894 != null) {
            class0 var6 = new class0();
            var6.field2 = var5;
            var6.field5 = var0;
            var6.field9 = var4;
            var6.field4 = var5.field2894;
            class143.method3071(var6);
         }

         boolean var7 = true;
         if(var5.field2916 > 0) {
            var7 = class47.method1024(var5);
         }

         if(var7) {
            if(class54.method1150(class27.method644(var5), var0 - 1)) {
               if(var0 == 1) {
                  client.field336.method2854(105);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 2) {
                  client.field336.method2854(143);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 3) {
                  client.field336.method2854(96);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 4) {
                  client.field336.method2854(159);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 5) {
                  client.field336.method2854(208);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 6) {
                  client.field336.method2854(237);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 7) {
                  client.field336.method2854(116);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 8) {
                  client.field336.method2854(20);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 9) {
                  client.field336.method2854(72);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

               if(var0 == 10) {
                  client.field336.method2854(202);
                  client.field336.method2598(var1);
                  client.field336.method2781(var2);
                  client.field336.method2781(var3);
               }

            }
         }
      }
   }
}

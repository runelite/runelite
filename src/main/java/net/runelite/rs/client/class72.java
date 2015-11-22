package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
public class class72 implements Runnable {
   @ObfuscatedName("l")
   volatile boolean field1338 = false;
   @ObfuscatedName("m")
   volatile class56[] field1340 = new class56[2];
   @ObfuscatedName("f")
   volatile boolean field1341 = false;
   @ObfuscatedName("j")
   class135 field1342;

   public void run() {
      this.field1338 = true;

      try {
         while(!this.field1341) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1340[var1];
               if(var2 != null) {
                  var2.method1218();
               }
            }

            class29.method711(10L);
            class28.method697(this.field1342, (Object)null);
         }
      } catch (Exception var6) {
         class37.method803((String)null, var6);
      } finally {
         this.field1338 = false;
      }

   }

   @ObfuscatedName("w")
   static final int method1598(int var0, int var1) {
      int var2 = class32.method749(var0 + '넵', 91923 + var1, 4) - 128 + (class32.method749(10294 + var0, '鎽' + var1, 2) - 128 >> 1) + (class32.method749(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("j")
   static boolean method1599(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("ba")
   static final void method1600(boolean var0) {
      client.field413 = 0;
      client.field444 = 0;
      class129.method2867();
      class126.method2859(var0);
      class171.method3460();

      int var1;
      for(var1 = 0; var1 < client.field413; ++var1) {
         int var2 = client.field401[var1];
         if(client.field286 != client.field313[var2].field799) {
            client.field313[var2].field761 = null;
            client.field313[var2] = null;
         }
      }

      if(client.field320.field1981 != client.field289) {
         throw new RuntimeException(client.field320.field1981 + "," + client.field289);
      } else {
         for(var1 = 0; var1 < client.field314; ++var1) {
            if(client.field313[client.field315[var1]] == null) {
               throw new RuntimeException(var1 + "," + client.field314);
            }
         }

      }
   }

   @ObfuscatedName("f")
   public static int method1601(char var0) {
      int var1 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var1 = 1 + (var0 << 4);
      }

      return var1;
   }
}

package net.runelite.rs.client;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("t")
public class class8 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -16316055
   )
   int field132 = 1;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = -1222407947
   )
   static int field134;
   @ObfuscatedName("l")
   boolean field135;
   @ObfuscatedName("a")
   LinkedHashMap field137 = new LinkedHashMap();
   @ObfuscatedName("cx")
   static class142 field138;
   @ObfuscatedName("cu")
   static class223 field139;
   @ObfuscatedName("ih")
   static class172 field140;
   @ObfuscatedName("f")
   boolean field142;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1524609657
   )
   protected static int field143;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1262460891
   )
   static int field146 = 4;

   class8(class118 var1) {
      if(var1 != null && null != var1.field1980) {
         int var2 = var1.method2536();
         if(var2 >= 0 && var2 <= field146) {
            if(var1.method2536() == 1) {
               this.field142 = true;
            }

            if(var2 > 1) {
               this.field135 = var1.method2536() == 1;
            }

            if(var2 > 3) {
               this.field132 = var1.method2536();
            }

            if(var2 > 2) {
               int var3 = var1.method2536();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2541();
                  int var6 = var1.method2541();
                  this.field137.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method128();
         }
      } else {
         this.method128();
      }

   }

   @ObfuscatedName("j")
   void method128() {
   }

   class8() {
      this.method128();
   }

   @ObfuscatedName("j")
   public static int method129(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("m")
   class118 method137() {
      class118 var1 = new class118(100);
      var1.method2521(field146);
      var1.method2521(this.field142?1:0);
      var1.method2521(this.field135?1:0);
      var1.method2521(this.field132);
      var1.method2521(this.field137.size());
      Iterator var2 = this.field137.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2524(((Integer)var3.getKey()).intValue());
         var1.method2524(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("dn")
   static boolean method138(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class140.method3010(var0, client.field280);

         for(int var3 = 0; var3 < client.field541; ++var3) {
            if(var2.equalsIgnoreCase(class140.method3010(client.field410[var3].field237, client.field280)) && (!var1 || 0 != client.field410[var3].field238)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class140.method3010(class0.field12.field34, client.field280))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("j")
   public static int method139(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class118.field1978[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("do")
   static final void method140(class172 var0, int var1, int var2) {
      class174 var3 = var0.method3464(false);
      if(null != var3) {
         if(client.field510 < 3) {
            class20.field563.method1739(var1, var2, var3.field2882, var3.field2877, 25, 25, client.field434, 256, var3.field2879, var3.field2878);
         } else {
            class79.method1818(var1, var2, 0, var3.field2879, var3.field2878);
         }

      }
   }

   @ObfuscatedName("l")
   static final void method141(byte[] var0, int var1, int var2, int var3, int var4, class107[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var2 + var8 > 0 && var2 + var8 < 103) {
                  var5[var6].field1879[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class118 var10 = new class118(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class138.method2977(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}

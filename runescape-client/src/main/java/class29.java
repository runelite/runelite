import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class29 extends class85 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -75058051
   )
   int field675;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1548723003
   )
   int field676;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1238523971
   )
   int field678;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1912273331
   )
   int field680;
   @ObfuscatedName("y")
   class42 field681;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1377837243
   )
   int field682 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -110305993
   )
   int field683;
   @ObfuscatedName("u")
   boolean field684 = false;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1996340283
   )
   int field685 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -850363671
   )
   int field687;

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field687 = var1;
      this.field675 = var2;
      this.field678 = var3;
      this.field683 = var4;
      this.field680 = var5;
      this.field676 = var6 + var7;
      int var8 = class32.method708(this.field687).field990;
      if(var8 != -1) {
         this.field684 = false;
         this.field681 = class17.method178(var8);
      } else {
         this.field684 = true;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   final void method652(int var1) {
      if(!this.field684) {
         this.field685 += var1;

         while(this.field685 > this.field681.field983[this.field682]) {
            this.field685 -= this.field681.field983[this.field682];
            ++this.field682;
            if(this.field682 >= this.field681.field965.length) {
               this.field684 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   protected final class105 vmethod1913() {
      class43 var1 = class32.method708(this.field687);
      class105 var2;
      if(!this.field684) {
         var2 = var1.method908(this.field682);
      } else {
         var2 = var1.method908(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1733758469"
   )
   public static void method654(Component var0) {
      var0.addMouseListener(class140.field2131);
      var0.addMouseMotionListener(class140.field2131);
      var0.addFocusListener(class140.field2131);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   static final void method660() {
      int var0 = class153.field2262.field813 + client.field444;
      int var1 = client.field523 + class153.field2262.field791;
      if(class116.field1961 - var0 < -500 || class116.field1961 - var0 > 500 || class164.field2648 - var1 < -500 || class164.field2648 - var1 > 500) {
         class116.field1961 = var0;
         class164.field2648 = var1;
      }

      if(class116.field1961 != var0) {
         class116.field1961 += (var0 - class116.field1961) / 16;
      }

      if(class164.field2648 != var1) {
         class164.field2648 += (var1 - class164.field2648) / 16;
      }

      int var2;
      int var3;
      if(class140.field2133 == 4 && class161.field2631) {
         var2 = class140.field2135 - client.field378;
         client.field376 = var2 * 2;
         client.field378 = var2 != -1 && var2 != 1?(class140.field2135 + client.field378) / 2:class140.field2135;
         var3 = client.field390 - class140.field2134;
         client.field375 = var3 * 2;
         client.field390 = var3 != -1 && var3 != 1?(class140.field2134 + client.field390) / 2:class140.field2134;
      } else {
         if(class137.field2095[96]) {
            client.field375 += (-24 - client.field375) / 2;
         } else if(class137.field2095[97]) {
            client.field375 += (24 - client.field375) / 2;
         } else {
            client.field375 /= 2;
         }

         if(class137.field2095[98]) {
            client.field376 += (12 - client.field376) / 2;
         } else if(class137.field2095[99]) {
            client.field376 += (-12 - client.field376) / 2;
         } else {
            client.field376 /= 2;
         }

         client.field378 = class140.field2135;
         client.field390 = class140.field2134;
      }

      client.field322 = client.field322 + client.field375 / 2 & 2047;
      client.field403 += client.field376 / 2;
      if(client.field403 < 128) {
         client.field403 = 128;
      }

      if(client.field403 > 383) {
         client.field403 = 383;
      }

      var2 = class116.field1961 >> 7;
      var3 = class164.field2648 >> 7;
      int var4 = class108.method2413(class116.field1961, class164.field2648, class144.field2193);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= 4 + var2; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class144.field2193;
               if(var8 < 3 && (class5.field69[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class5.field83[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = 192 * var5;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > client.field450) {
         client.field450 += (var6 - client.field450) / 24;
      } else if(var6 < client.field450) {
         client.field450 += (var6 - client.field450) / 80;
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Lclass173;",
      garbageValue = "1052095320"
   )
   static class173 method661(class173 var0) {
      class173 var1 = class119.method2536(var0);
      if(var1 == null) {
         var1 = var0.field2810;
      }

      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-611683651"
   )
   public static boolean method662(int var0) {
      return (var0 & 1) != 0;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class26 extends Node {
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -429552101
   )
   static int field657;
   @ObfuscatedName("g")
   class205 field658 = new class205();
   @ObfuscatedName("e")
   class49 field662;
   @ObfuscatedName("ay")
   static class146 field664;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-1556331495"
   )
   static void method579(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class192.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field880 = 0;
            var0.actionAnimationDisable = var2;
            var0.field871 = 0;
         }

         if(var3 == 2) {
            var0.field871 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class192.getAnimation(var1).field1014 >= class192.getAnimation(var0.animation).field1014) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field880 = 0;
         var0.actionAnimationDisable = var2;
         var0.field871 = 0;
         var0.field894 = var0.field889;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-80"
   )
   void method580(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field658.method3881(); null != var7; var7 = (class20)this.field658.method3883()) {
         ++var6;
         if(var7.field594 == var1) {
            var7.method530(var1, var2, var3, var4);
            return;
         }

         if(var7.field594 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field658.method3899(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3890(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field658.method3881().unlink();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)I",
      garbageValue = "1558860784"
   )
   static int method581(class125 var0) {
      int var1 = var0.method2787(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2787(5);
      } else if(var1 == 2) {
         var2 = var0.method2787(8);
      } else {
         var2 = var0.method2787(11);
      }

      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1743427268"
   )
   boolean method582() {
      return this.field658.method3884();
   }

   class26(class49 var1) {
      this.field662 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "694503497"
   )
   class20 method585(int var1) {
      class20 var2 = (class20)this.field658.method3881();
      if(null != var2 && var2.field594 <= var1) {
         for(class20 var3 = (class20)this.field658.method3883(); null != var3 && var3.field594 <= var1; var3 = (class20)this.field658.method3883()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field594 + var2.field592 + this.field662.field1087 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass170;IB)Z",
      garbageValue = "0"
   )
   static boolean method590(class170 var0, int var1) {
      byte[] var2 = var0.method3311(var1);
      if(null == var2) {
         return false;
      } else {
         NPC.method760(var2);
         return true;
      }
   }
}

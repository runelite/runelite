import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class45 extends class204 {
   @ObfuscatedName("dg")
   static int[] field1016;
   @ObfuscatedName("w")
   static class193 field1017 = new class193(64);
   @ObfuscatedName("f")
   public boolean field1019 = false;
   @ObfuscatedName("e")
   static class167 field1024;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1775068517
   )
   static int field1025;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "1255076130"
   )
   static void method946(class173 var0, int var1, int var2) {
      if(0 == var0.field2760) {
         var0.field2880 = var0.field2764;
      } else if(1 == var0.field2760) {
         var0.field2880 = (var1 - var0.field2770) / 2 + var0.field2764;
      } else if(var0.field2760 == 2) {
         var0.field2880 = var1 - var0.field2770 - var0.field2764;
      } else if(3 == var0.field2760) {
         var0.field2880 = var1 * var0.field2764 >> 14;
      } else if(4 == var0.field2760) {
         var0.field2880 = (var1 * var0.field2764 >> 14) + (var1 - var0.field2770) / 2;
      } else {
         var0.field2880 = var1 - var0.field2770 - (var1 * var0.field2764 >> 14);
      }

      if(var0.field2761 == 0) {
         var0.field2769 = var0.field2886;
      } else if(1 == var0.field2761) {
         var0.field2769 = var0.field2886 + (var2 - var0.field2834) / 2;
      } else if(var0.field2761 == 2) {
         var0.field2769 = var2 - var0.field2834 - var0.field2886;
      } else if(3 == var0.field2761) {
         var0.field2769 = var2 * var0.field2886 >> 14;
      } else if(4 == var0.field2761) {
         var0.field2769 = (var2 * var0.field2886 >> 14) + (var2 - var0.field2834) / 2;
      } else {
         var0.field2769 = var2 - var0.field2834 - (var2 * var0.field2886 >> 14);
      }

      if(client.field448 && var0.field2757 == 0) {
         if(var0.field2880 < 0) {
            var0.field2880 = 0;
         } else if(var0.field2770 + var0.field2880 > var1) {
            var0.field2880 = var1 - var0.field2770;
         }

         if(var0.field2769 < 0) {
            var0.field2769 = 0;
         } else if(var0.field2769 + var0.field2834 > var2) {
            var0.field2769 = var2 - var0.field2834;
         }
      }

   }

   @ObfuscatedName("f")
   void method947(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method956(var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZIB)V",
      garbageValue = "22050"
   )
   public static final void method949(int var0, boolean var1, int var2) {
      class56.field1153 = var0;
      class56.field1160 = var1;
      class2.field60 = var2;
   }

   @ObfuscatedName("s")
   void method956(int var1) {
      if(2 == var1) {
         this.field1019 = true;
      }

   }

   @ObfuscatedName("e")
   public static void method957(class167 var0, class167 var1) {
      class39.field894 = var0;
      class219.field3166 = var1;
   }
}

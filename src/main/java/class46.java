import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class46 extends class204 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1065860143
   )
   public int field1030;
   @ObfuscatedName("h")
   static class193 field1031 = new class193(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -247824959
   )
   public int field1032;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 352829797
   )
   public int field1033 = -1;
   @ObfuscatedName("x")
   public boolean field1034 = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -559790669
   )
   public int field1035 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -4336901
   )
   public int field1036;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1453642431
   )
   public int field1038;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2103653105
   )
   public int field1040 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2127131259
   )
   public int field1041;
   @ObfuscatedName("j")
   public static class167 field1043;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1042243015
   )
   public int field1044;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIS)V",
      garbageValue = "-16257"
   )
   void method952(class119 var1, int var2, int var3) {
      if(1 == var2) {
         this.field1040 = var1.method2662();
      } else if(var2 == 2) {
         this.field1033 = var1.method2500();
      } else if(5 == var2) {
         this.field1034 = false;
      } else if(7 == var2) {
         this.field1035 = var1.method2662();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   static final int method953(int var0, int var1) {
      int var2 = class29.method653(var0 + '넵', 91923 + var1, 4) - 128 + (class29.method653(var0 + 10294, '鎽' + var1, 2) - 128 >> 1) + (class29.method653(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "4"
   )
   void method955(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field1036 = (int)(256.0D * var12);
      this.field1030 = (int)(256.0D * var14);
      this.field1044 = (int)(var16 * 256.0D);
      if(this.field1030 < 0) {
         this.field1030 = 0;
      } else if(this.field1030 > 255) {
         this.field1030 = 255;
      }

      if(this.field1044 < 0) {
         this.field1044 = 0;
      } else if(this.field1044 > 255) {
         this.field1044 = 255;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-403016732"
   )
   void method956() {
      if(-1 != this.field1035) {
         this.method955(this.field1035);
         this.field1038 = this.field1036;
         this.field1041 = this.field1030;
         this.field1032 = this.field1044;
      }

      this.method955(this.field1040);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-644547126"
   )
   void method957(class119 var1, int var2) {
      while(true) {
         int var3 = var1.method2500();
         if(var3 == 0) {
            return;
         }

         this.method952(var1, var3, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "0"
   )
   public static void method970(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class138.field2110.startsWith("win")) {
            class103.method2280(var0, 0);
         } else if(class138.field2110.startsWith("mac")) {
            class29.method657(var0, 1, "openjs");
         } else {
            class103.method2280(var0, 2);
         }
      } else {
         class103.method2280(var0, 3);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lclass173;",
      garbageValue = "1458482838"
   )
   public static class173 method972(int var0, int var1) {
      class173 var2 = class141.method2959(var0);
      return var1 == -1?var2:(var2 != null && var2.field2868 != null && var1 < var2.field2868.length?var2.field2868[var1]:null);
   }
}

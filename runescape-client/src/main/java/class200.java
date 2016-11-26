import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class200 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2146277333
   )
   public int field3029;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -351846355
   )
   public int field3030 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 928649497
   )
   public int field3031;
   @ObfuscatedName("n")
   public static class182 field3032;
   @ObfuscatedName("w")
   public boolean field3033 = true;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1308704491
   )
   public int field3034 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 169511171
   )
   public int field3035;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 269817765
   )
   public int field3036;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1492208649
   )
   public int field3037;
   @ObfuscatedName("d")
   public static NodeCache field3038 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2069642169
   )
   public int field3039 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -968567485
   )
   public int field3040;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)I",
      garbageValue = "-922147068"
   )
   static int method3780(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3371("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3371("logo", "")) {
         ++var2;
      }

      if(var1.method3371("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3371("titlebox", "")) {
         ++var2;
      }

      if(var1.method3371("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3371("runes", "")) {
         ++var2;
      }

      if(var1.method3371("title_mute", "")) {
         ++var2;
      }

      if(var1.method3348("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3348("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3371("sl_back", "");
      var1.method3371("sl_flags", "");
      var1.method3371("sl_arrows", "");
      var1.method3371("sl_stars", "");
      var1.method3371("sl_button", "");
      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1456392607"
   )
   public void method3781() {
      if(this.field3034 != -1) {
         this.method3784(this.field3034);
         this.field3031 = this.field3035;
         this.field3029 = this.field3036;
         this.field3040 = this.field3037;
      }

      this.method3784(this.field3030);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2010868951"
   )
   public void method3782(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3783(var1, var3, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-20591134"
   )
   void method3783(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3030 = var1.read24BitInt();
      } else if(var2 == 2) {
         this.field3039 = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.field3033 = false;
      } else if(var2 == 7) {
         this.field3034 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "26"
   )
   void method3784(int var1) {
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
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field3035 = (int)(var12 * 256.0D);
      this.field3036 = (int)(var14 * 256.0D);
      this.field3037 = (int)(256.0D * var16);
      if(this.field3036 < 0) {
         this.field3036 = 0;
      } else if(this.field3036 > 255) {
         this.field3036 = 255;
      }

      if(this.field3037 < 0) {
         this.field3037 = 0;
      } else if(this.field3037 > 255) {
         this.field3037 = 255;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1402538900"
   )
   public static boolean method3793() {
      ClassInfo var0 = (ClassInfo)class227.field3232.method2428();
      return null != var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;B)Lclass208;",
      garbageValue = "-46"
   )
   public static class208 method3795(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3350(var2);
      int var5 = var0.method3345(var4, var3);
      return class186.method3474(var0, var1, var4, var5);
   }
}

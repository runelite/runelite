import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class48 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 483684419
   )
   public int field1072;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1135805363
   )
   public int field1073 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2111682389
   )
   public int field1074 = -1;
   @ObfuscatedName("v")
   public boolean field1075 = true;
   @ObfuscatedName("q")
   public static NodeCache field1076 = new NodeCache(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -978612057
   )
   public int field1077;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1649970697
   )
   public int field1078;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1317428131
   )
   public int field1079;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -897251579
   )
   public int field1080;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1529116841
   )
   public int field1081;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1490758185
   )
   public int field1082 = 0;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)[LModIcon;",
      garbageValue = "43"
   )
   public static ModIcon[] method984(class170 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3325(var3, var2);
      return class40.method793(var0, var3, var4);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "126138724"
   )
   void method987(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1082 = var1.method2575();
      } else if(var2 == 2) {
         this.field1073 = var1.method2571();
      } else if(var2 == 5) {
         this.field1075 = false;
      } else if(var2 == 7) {
         this.field1074 = var1.method2575();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "245052120"
   )
   void method988(int var1) {
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
      double var16 = (var10 + var8) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field1077 = (int)(var12 * 256.0D);
      this.field1078 = (int)(256.0D * var14);
      this.field1079 = (int)(256.0D * var16);
      if(this.field1078 < 0) {
         this.field1078 = 0;
      } else if(this.field1078 > 255) {
         this.field1078 = 255;
      }

      if(this.field1079 < 0) {
         this.field1079 = 0;
      } else if(this.field1079 > 255) {
         this.field1079 = 255;
      }

   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1701642419"
   )
   static final void method992() {
      for(class16 var0 = (class16)Client.field413.method3864(); var0 != null; var0 = (class16)Client.field413.method3851()) {
         if(var0.field234 == -1) {
            var0.field233 = 0;
            Projectile.method92(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2028065861"
   )
   void method995(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2571();
         if(var3 == 0) {
            return;
         }

         this.method987(var1, var3, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-549116412"
   )
   void method1000() {
      if(this.field1074 != -1) {
         this.method988(this.field1074);
         this.field1072 = this.field1077;
         this.field1081 = this.field1078;
         this.field1080 = this.field1079;
      }

      this.method988(this.field1082);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "-43"
   )
   public static Object method1001(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2097) {
            try {
               class121 var2 = new class121();
               var2.vmethod2853(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2097 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "294891650"
   )
   public static void method1002(Component var0) {
      var0.removeMouseListener(class143.mouse);
      var0.removeMouseMotionListener(class143.mouse);
      var0.removeFocusListener(class143.mouse);
      class143.field2211 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "16711680"
   )
   public static boolean method1003(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "94"
   )
   static final void method1004() {
      if(Client.field397 > 0) {
         class16.method171();
      } else {
         class127.setGameState(40);
         class12.field178 = class28.field671;
         class28.field671 = null;
      }
   }
}

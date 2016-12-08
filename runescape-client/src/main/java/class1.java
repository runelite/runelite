import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class1 {
   @ObfuscatedName("o")
   public final List field7;
   @ObfuscatedName("b")
   public static Comparator field8;
   @ObfuscatedName("g")
   public static Comparator field9;
   @ObfuscatedName("h")
   public static Comparator field10;
   @ObfuscatedName("m")
   public static Comparator field11 = new class7();

   static {
      new class0();
      field8 = new class5();
      field9 = new class6();
      field10 = new class3();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "-3"
   )
   public void method11(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field7, var1);
      } else {
         Collections.sort(this.field7, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "519238545"
   )
   static void method12() {
      Client.field330.method2967(92);
      Client.field330.method2815(class47.method871());
      Client.field330.method2712(TextureProvider.field1200);
      Client.field330.method2712(class94.field1584);
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field7 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field7.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-13"
   )
   static int method14() {
      return ++class47.field940 - 1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method15() {
      short var0 = 256;
      int var1;
      if(class41.field836 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field836 > 768) {
               ChatMessages.field918[var1] = class57.method1066(class45.field912[var1], class214.field3159[var1], 1024 - class41.field836);
            } else if(class41.field836 > 256) {
               ChatMessages.field918[var1] = class214.field3159[var1];
            } else {
               ChatMessages.field918[var1] = class57.method1066(class214.field3159[var1], class45.field912[var1], 256 - class41.field836);
            }
         }
      } else if(class41.field848 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field848 > 768) {
               ChatMessages.field918[var1] = class57.method1066(class45.field912[var1], class15.field163[var1], 1024 - class41.field848);
            } else if(class41.field848 > 256) {
               ChatMessages.field918[var1] = class15.field163[var1];
            } else {
               ChatMessages.field918[var1] = class57.method1066(class15.field163[var1], class45.field912[var1], 256 - class41.field848);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            ChatMessages.field918[var1] = class45.field912[var1];
         }
      }

      class219.method3893(class41.field860, 9, 128 + class41.field860, 7 + var0);
      class41.field830.method4092(class41.field860, 0);
      class219.method3891();
      var1 = 0;
      int var2 = TextureProvider.bufferProvider.width * 9 + class41.field860;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field851[var3] / var0;
         var5 = 22 + var4;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = MessageNode.field230[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = ChatMessages.field918[var7];
               var10 = TextureProvider.bufferProvider.pixels[var2];
               TextureProvider.bufferProvider.pixels[var2++] = (var9 * (var10 & '\uff00') + (var7 & '\uff00') * var8 & 16711680) + (var9 * (var10 & 16711935) + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += TextureProvider.bufferProvider.width + var5 - 128;
      }

      class219.method3893(class41.field860 + 765 - 128, 9, 765 + class41.field860, var0 + 7);
      RSCanvas.field1766.method4092(class41.field860 + 382, 0);
      class219.method3891();
      var1 = 0;
      var2 = class41.field860 + TextureProvider.bufferProvider.width * 9 + 24 + 637;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field851[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = MessageNode.field230[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = ChatMessages.field918[var7];
               var10 = TextureProvider.bufferProvider.pixels[var2];
               TextureProvider.bufferProvider.pixels[var2++] = ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) + (var9 * (var10 & 16711935) + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += TextureProvider.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1709494423"
   )
   public static void method16(class182 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3218(var1);
      int var6 = var0.method3219(var5, var2);
      WallObject.method1843(var0, var5, var6, var3, var4);
   }
}

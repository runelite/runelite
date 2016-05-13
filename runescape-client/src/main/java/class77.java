import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("BufferProvider")
public abstract class class77 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1711997781
   )
   @Export("width")
   public int field1397;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1974777839
   )
   @Export("height")
   int field1398;
   @ObfuscatedName("u")
   @Export("image")
   public Image field1400;
   @ObfuscatedName("p")
   @Export("pixels")
   public int[] field1401;
   @ObfuscatedName("az")
   static class80[] field1403;
   @ObfuscatedName("fn")
   @ObfuscatedGetter(
      intValue = 713904681
   )
   @Export("cameraX")
   static int field1404;
   @ObfuscatedName("eh")
   static class78[] field1405;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "128"
   )
   public abstract void vmethod1858(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "0"
   )
   abstract void vmethod1852(int var1, int var2, Component var3);

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   public final void method1646() {
      class79.method1800(this.field1401, this.field1397, this.field1398);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   public abstract void vmethod1857(Graphics var1, int var2, int var3);

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-7001"
   )
   static void method1660(int var0) {
      if(var0 == -1 && !client.field518) {
         class107.method2373();
      } else if(-1 != var0 && client.field370 != var0 && client.field516 != 0 && !client.field518) {
         class168 var1 = class102.field1776;
         int var2 = client.field516;
         class183.field2973 = 1;
         class183.field2974 = var1;
         class221.field3184 = var0;
         class151.field2268 = 0;
         class183.field2971 = var2;
         class183.field2977 = false;
         class183.field2976 = 2;
      }

      client.field370 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "-495554698"
   )
   public static final class56 method1661(class136 var0, Component var1, int var2, int var3) {
      if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class69 var4 = new class69();
            var4.field1200 = new int[(class56.field1180?2:1) * 256];
            var4.field1189 = var3;
            var4.vmethod1492(var1);
            var4.field1179 = 1024 + (var3 & -1024);
            if(var4.field1179 > 16384) {
               var4.field1179 = 16384;
            }

            var4.vmethod1493(var4.field1179);
            if(class56.field1194 > 0 && null == class56.field1182) {
               class56.field1182 = new class72();
               class56.field1182.field1354 = var0;
               var0.method2862(class56.field1182, class56.field1194);
            }

            if(null != class56.field1182) {
               if(class56.field1182.field1357[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class56.field1182.field1357[var2] = var4;
            }

            return var4;
         } catch (Throwable var7) {
            try {
               class54 var5 = new class54(var0, var2);
               var5.field1200 = new int[(class56.field1180?2:1) * 256];
               var5.field1189 = var3;
               var5.vmethod1492(var1);
               var5.field1179 = 16384;
               var5.vmethod1493(var5.field1179);
               if(class56.field1194 > 0 && null == class56.field1182) {
                  class56.field1182 = new class72();
                  class56.field1182.field1354 = var0;
                  var0.method2862(class56.field1182, class56.field1194);
               }

               if(class56.field1182 != null) {
                  if(class56.field1182.field1357[var2] != null) {
                     throw new IllegalArgumentException();
                  }

                  class56.field1182.field1357[var2] = var5;
               }

               return var5;
            } catch (Throwable var6) {
               return new class56();
            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "811328132"
   )
   static void method1662(int var0, boolean var1, int var2, boolean var3) {
      if(null != class25.field636) {
         class110.method2418(0, class25.field636.length - 1, var0, var1, var2, var3);
      }

   }
}

import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public abstract class class77 {
   @ObfuscatedName("bf")
   protected static FontMetrics field1372;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 781198483
   )
   public int field1373;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2076673251
   )
   int field1374;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -1298977825
   )
   static int field1375;
   @ObfuscatedName("m")
   public int[] field1376;
   @ObfuscatedName("kd")
   @ObfuscatedGetter(
      intValue = 835964219
   )
   static int field1377;
   @ObfuscatedName("l")
   static class80 field1379;
   @ObfuscatedName("e")
   public Image field1380;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1018784558"
   )
   public abstract void vmethod1872(int var1, int var2, Component var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-42"
   )
   public static synchronized long method1674() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1955) {
         class178.field2916 += class115.field1955 - var0;
      }

      class115.field1955 = var0;
      return var0 + class178.field2916;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   public abstract void vmethod1873(Graphics var1, int var2, int var3);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "40"
   )
   public abstract void vmethod1871(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-31"
   )
   public final void method1678() {
      class79.method1774(this.field1376, this.field1373, this.field1374);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1205398655"
   )
   static final void method1683() {
      int var0 = 64 + class28.field656 * 128;
      int var1 = 64 + class176.field2905 * 128;
      int var2 = class148.method3106(var0, var1, class28.field655) - class76.field1369;
      if(class122.field1991 < var0) {
         class122.field1991 += class148.field2203 + (var0 - class122.field1991) * class41.field966 / 1000;
         if(class122.field1991 > var0) {
            class122.field1991 = var0;
         }
      }

      if(class122.field1991 > var0) {
         class122.field1991 -= class148.field2203 + (class122.field1991 - var0) * class41.field966 / 1000;
         if(class122.field1991 < var0) {
            class122.field1991 = var0;
         }
      }

      if(class115.field1952 < var2) {
         class115.field1952 += class148.field2203 + class41.field966 * (var2 - class115.field1952) / 1000;
         if(class115.field1952 > var2) {
            class115.field1952 = var2;
         }
      }

      if(class115.field1952 > var2) {
         class115.field1952 -= class148.field2203 + (class115.field1952 - var2) * class41.field966 / 1000;
         if(class115.field1952 < var2) {
            class115.field1952 = var2;
         }
      }

      if(class24.field603 < var1) {
         class24.field603 += class41.field966 * (var1 - class24.field603) / 1000 + class148.field2203;
         if(class24.field603 > var1) {
            class24.field603 = var1;
         }
      }

      if(class24.field603 > var1) {
         class24.field603 -= (class24.field603 - var1) * class41.field966 / 1000 + class148.field2203;
         if(class24.field603 < var1) {
            class24.field603 = var1;
         }
      }

      var0 = 64 + class2.field62 * 128;
      var1 = class93.field1580 * 128 + 64;
      var2 = class148.method3106(var0, var1, class28.field655) - class129.field2030;
      int var3 = var0 - class122.field1991;
      int var4 = var2 - class115.field1952;
      int var5 = var1 - class24.field603;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class154.field2276 < var7) {
         class154.field2276 += class175.field2896 * (var7 - class154.field2276) / 1000 + class50.field1080;
         if(class154.field2276 > var7) {
            class154.field2276 = var7;
         }
      }

      if(class154.field2276 > var7) {
         class154.field2276 -= class175.field2896 * (class154.field2276 - var7) / 1000 + class50.field1080;
         if(class154.field2276 < var7) {
            class154.field2276 = var7;
         }
      }

      int var9 = var8 - class17.field243;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class17.field243 += class50.field1080 + var9 * class175.field2896 / 1000;
         class17.field243 &= 2047;
      }

      if(var9 < 0) {
         class17.field243 -= class50.field1080 + class175.field2896 * -var9 / 1000;
         class17.field243 &= 2047;
      }

      int var10 = var8 - class17.field243;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class17.field243 = var8;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-527319065"
   )
   static void method1685(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field178.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class27();
         class11.field178.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method631(var0, var1, var2, var3);
      class11.field171.method3765(var5, (long)var5.field765);
      class11.field172.method3822(var5);
      client.field500 = client.field458;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILclass167;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "2"
   )
   public static void method1686(int var0, class167 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3232(var2);
      int var7 = var1.method3233(var6, var3);
      class183.field2959 = 1;
      class76.field1370 = var1;
      class183.field2960 = var6;
      class183.field2961 = var7;
      class183.field2957 = var4;
      class183.field2964 = var5;
      class183.field2963 = var0;
   }
}

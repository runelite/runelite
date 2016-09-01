import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1921400007
   )
   @Export("width")
   public int width;
   @ObfuscatedName("j")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -529613033
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @Export("image")
   public Image image;
   @ObfuscatedName("ic")
   static Widget field1434;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1590592951"
   )
   public final void method1711() {
      class82.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "2029268660"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1906122185"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "610132572"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "2"
   )
   public static int method1724(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         byte var11;
         if(var9 == 198) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(var9 == 338) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class38.method744(var9, var2);
         var10 = class38.method744(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return Frames.method2355(var9, var2) - Frames.method2355(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      int var17;
      char var20;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var20 = var1.charAt(var17);
         if(var20 != var18 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
            var18 = Character.toLowerCase(var18);
            var20 = Character.toLowerCase(var20);
            if(var20 != var18) {
               return Frames.method2355(var18, var2) - Frames.method2355(var20, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var20 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var20 != var13) {
               return Frames.method2355(var20, var2) - Frames.method2355(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "14"
   )
   static final void method1725(int var0, int var1) {
      int var2 = VertexNormal.field1680.method4099("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class227 var4 = VertexNormal.field1680;
         String var5;
         if(Client.menuTargets[var3].length() > 0) {
            var5 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var5 = Client.menuOptions[var3];
         }

         int var6 = var4.method4099(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var8 = var0 - var2 / 2;
      if(var8 + var2 > FaceNormal.field1499) {
         var8 = FaceNormal.field1499 - var2;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var7 = var1;
      if(var3 + var1 > class212.field3175) {
         var7 = class212.field3175 - var3;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      Client.isMenuOpen = true;
      class92.menuX = var8;
      class85.menuY = var7;
      class109.menuWidth = var2;
      class138.menuHeight = Client.menuOptionCount * 15 + 22;
   }
}

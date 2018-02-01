import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class33 {
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 190861667
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("p")
   String field439;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2067115873
   )
   int field435;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1141674087
   )
   int field437;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   Size field438;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILb;)V"
   )
   class33(String var1, int var2, int var3, Size var4) {
      this.field439 = var1;
      this.field435 = var2;
      this.field437 = var3;
      this.field438 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "56"
   )
   public static void method364(Applet var0, String var1) {
      class56.field620 = var0;
      if(var1 != null) {
         class56.field617 = var1;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1624868287"
   )
   static final void method363(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkh;B)V",
      garbageValue = "67"
   )
   static final void method360(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < ScriptState.field708.length; ++var2) {
         ScriptState.field708[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         ScriptState.field708[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class94.field1404[var5] = (ScriptState.field708[var5 + 128] + ScriptState.field708[var5 - 128] + ScriptState.field708[var5 + 1] + ScriptState.field708[var5 - 1]) / 4;
            }
         }

         int[] var8 = ScriptState.field708;
         ScriptState.field708 = class94.field1404;
         class94.field1404 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  ScriptState.field708[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([Lho;Lho;ZI)V",
      garbageValue = "-1089411346"
   )
   static void method362(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class65.method1068(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class65.method1068(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         Preferences.method1657(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-121"
   )
   static String method361(String var0) {
      Permission[] var1 = new Permission[]{Permission.field3257, Permission.field3253, Permission.field3248, Permission.field3252, Permission.field3251, Permission.field3250};
      Permission[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Permission var4 = var2[var3];
         if(var4.field3254 != -1) {
            int var7 = var4.field3254;
            String var6 = "<img=" + var7 + ">";
            if(var0.startsWith(var6)) {
               var0 = var0.substring(6 + Integer.toString(var4.field3254).length());
               break;
            }
         }
      }

      return var0;
   }
}

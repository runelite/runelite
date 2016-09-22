import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 938986241
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1003454913
   )
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -743780759
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 882007089
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1587795339
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 267022967
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("z")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1793440127
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1424716217
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 942441481
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -771152321
   )
   int field1756;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 756169809
   )
   int field1757;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -324064097
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("ng")
   static class58 field1759;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1005712041
   )
   @Export("flags")
   int flags = 0;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1717439265"
   )
   static boolean method2223(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-150572970"
   )
   public static FileOnDisk method2224(String var0, String var1, boolean var2) {
      File var3 = new File(class152.field2300, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class146.field2248 == 33) {
         var4 = "_rc";
      } else if(class146.field2248 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class228.field3259, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "513329885"
   )
   static void method2225(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2823 == 0) {
         var0.width = var0.field2827;
      } else if(var0.field2823 == 1) {
         var0.width = var1 - var0.field2827;
      } else if(var0.field2823 == 2) {
         var0.width = var0.field2827 * var1 >> 14;
      }

      if(var0.field2824 == 0) {
         var0.height = var0.field2828;
      } else if(var0.field2824 == 1) {
         var0.height = var2 - var0.field2828;
      } else if(var0.field2824 == 2) {
         var0.height = var2 * var0.field2828 >> 14;
      }

      if(var0.field2823 == 4) {
         var0.width = var0.height * var0.field2833 / var0.field2834;
      }

      if(var0.field2824 == 4) {
         var0.height = var0.field2834 * var0.width / var0.field2833;
      }

      if(Client.field558 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field452 = var0;
      }

      if(var3 && null != var0.field2902 && (var4 != var0.width || var0.height != var5)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field7 = var0.field2902;
         Client.field479.method3849(var6);
      }

   }
}

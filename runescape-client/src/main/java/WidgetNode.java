import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("i")
   boolean field815;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1148336583
   )
   int field816;
   @ObfuscatedName("ex")
   static Font field817;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1299048029
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   static ModIcon field820;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lclass243;",
      garbageValue = "-1672255627"
   )
   public static class243 method1065(int var0) {
      class243 var1 = (class243)class243.field3316.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class243.field3318.getConfigData(19, var0);
         var1 = new class243();
         if(var2 != null) {
            var1.method4342(new Buffer(var2));
         }

         class243.field3316.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "2138522478"
   )
   static boolean method1066(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   WidgetNode() {
      this.field815 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;IIIII)V",
      garbageValue = "-128367635"
   )
   public static final void method1067(Model var0, int var1, int var2, int var3, int var4) {
      class7.field236.method3574(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "-73"
   )
   static void method1068(Widget var0, int var1, int var2) {
      if(var0.field2681 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2681 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.originalX;
      } else if(var0.field2681 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2681 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2681 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var1 * var0.originalX >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2777 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2777 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2777 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2777 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2777 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var0.originalY * var2 >> 14);
      }

      if(Client.field1086 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}

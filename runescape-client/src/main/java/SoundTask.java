import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("oq")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   static class115 field1583;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ldo;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2095();
            }
         }
      } catch (Exception var4) {
         Item.method1829((String)null, var4);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "417325012"
   )
   public static boolean method2178(int var0) {
      return var0 >= class228.field2905.field2908 && var0 <= class228.field2906.field2908;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "31755030"
   )
   static void method2177(Widget var0, int var1, int var2) {
      if(var0.field2788 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2788 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2788 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2788 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2788 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2730 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2730 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2730 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2730 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2730 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field967 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "39"
   )
   static void method2175(int var0, int var1) {
      ContextMenuRow var2 = class268.topContextMenuRow;
      ItemLayer.menuAction(var2.param0, var2.param1, var2.type, var2.identifier, var2.option, var2.option, var0, var1);
      class268.topContextMenuRow = null;
   }
}

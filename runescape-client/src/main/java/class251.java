import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public class class251 extends CacheableNode {
   @ObfuscatedName("i")
   public static IndexDataBase field3383;
   @ObfuscatedName("c")
   static NodeCache field3384;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -871973637
   )
   public int field3386;
   @ObfuscatedName("b")
   public String field3387;
   @ObfuscatedName("y")
   boolean field3388;
   @ObfuscatedName("e")
   char field3389;
   @ObfuscatedName("oo")
   static byte field3390;

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "334392730"
   )
   static void method4435(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2658 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2658 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2658 == 2) {
         var0.width = var1 * var0.originalWidth >> 14;
      }

      if(var0.field2659 == 0) {
         var0.height = var0.field2640;
      } else if(var0.field2659 == 1) {
         var0.height = var2 - var0.field2640;
      } else if(var0.field2659 == 2) {
         var0.height = var0.field2640 * var2 >> 14;
      }

      if(var0.field2658 == 4) {
         var0.width = var0.field2668 * var0.height / var0.field2717;
      }

      if(var0.field2659 == 4) {
         var0.height = var0.width * var0.field2717 / var0.field2668;
      }

      if(Client.field1100 && var0.type == 0) {
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
         Client.field1102 = var0;
      }

      if(var3 && var0.field2760 != null && (var4 != var0.width || var5 != var0.height)) {
         class69 var6 = new class69();
         var6.field852 = var0;
         var6.field849 = var0.field2760;
         Client.field955.method3571(var6);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1675639703"
   )
   void method4436() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "61"
   )
   void method4437(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4438(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-940462816"
   )
   void method4438(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3389 = class37.method486(var1.readByte());
      } else if(var2 == 2) {
         this.field3386 = var1.readInt();
      } else if(var2 == 4) {
         this.field3388 = false;
      } else if(var2 == 5) {
         this.field3387 = var1.readString();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1655046816"
   )
   public boolean method4439() {
      return this.field3389 == 115;
   }

   static {
      field3384 = new NodeCache(64);
   }

   class251() {
      this.field3388 = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   public static void method4451() {
      class286.field3793 = null;
      class266.field3657 = null;
      class233.field3205 = null;
      ScriptState.field779 = null;
      class4.field33 = null;
      IndexFile.field2307 = null;
   }
}

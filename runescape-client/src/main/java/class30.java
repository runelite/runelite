import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class30 {
   @ObfuscatedName("d")
   boolean field712;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1222693907
   )
   static int field714 = 4;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1028895165
   )
   int field715 = 1;
   @ObfuscatedName("c")
   boolean field717;
   @ObfuscatedName("dk")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("v")
   public static class60 field721;
   @ObfuscatedName("h")
   LinkedHashMap field722 = new LinkedHashMap();
   @ObfuscatedName("p")
   public static String field724;

   class30(Buffer var1) {
      if(null != var1 && null != var1.payload) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field714) {
            if(var1.readUnsignedByte() == 1) {
               this.field717 = true;
            }

            if(var2 > 1) {
               this.field712 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field715 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.field722.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method681(true);
         }
      } else {
         this.method681(true);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "491852297"
   )
   Buffer method676() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field714);
      var1.putByte(this.field717?1:0);
      var1.putByte(this.field712?1:0);
      var1.putByte(this.field715);
      var1.putByte(this.field722.size());
      Iterator var2 = this.field722.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "326883359"
   )
   void method681(boolean var1) {
   }

   class30() {
      this.method681(true);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1065563985"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class8.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1176677105"
   )
   static final void method687(int var0, int var1) {
      int var2 = BufferProvider.field3198.method3876("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = BufferProvider.field3198.method3876(Player.method269(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var2 + var4 > class108.field1748) {
         var4 = class108.field1748 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class145.field2018) {
         var5 = class145.field2018 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Friend.region.method1790(class31.plane, var0, var1, false);
      Client.isMenuOpen = true;
      class0.menuX = var4;
      XItemContainer.menuY = var5;
      class105.menuWidth = var2;
      NPCComposition.menuHeight = Client.menuOptionCount * 15 + 22;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "1712068550"
   )
   static final void method688(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class36.field807.length; ++var2) {
         class36.field807[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class36.field807[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class41.field860[var5] = (class36.field807[var5 + 128] + class36.field807[var5 - 128] + class36.field807[var5 - 1] + class36.field807[var5 + 1]) / 4;
            }
         }

         int[] var8 = class36.field807;
         class36.field807 = class41.field860;
         class41.field860 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var0.offsetY + 16 + var3;
                  int var7 = (var6 << 7) + var5;
                  class36.field807[var7] = 0;
               }
            }
         }
      }

   }
}

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class26 {
   @ObfuscatedName("i")
   byte[] field606 = new byte[4];
   @ObfuscatedName("u")
   class102 field607;
   @ObfuscatedName("h")
   DataInputStream field608;
   @ObfuscatedName("q")
   static boolean field609;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1176390513
   )
   int field610;
   @ObfuscatedName("o")
   byte[] field611;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -487750155
   )
   int field612;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1811742767
   )
   int field613;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -640800838125000685L
   )
   long field614;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-536872159"
   )
   byte[] method562() throws IOException {
      if(class45.method867() > this.field614) {
         throw new IOException();
      } else {
         if(this.field612 == 0) {
            if(this.field607.field1686 == 2) {
               throw new IOException();
            }

            if(this.field607.field1686 == 1) {
               this.field608 = (DataInputStream)this.field607.field1690;
               this.field612 = 1;
            }
         }

         if(this.field612 == 1) {
            this.field610 += this.field608.read(this.field606, this.field610, this.field606.length - this.field610);
            if(this.field610 == 4) {
               int var1 = (new Buffer(this.field606)).readInt();
               this.field611 = new byte[var1];
               this.field612 = 2;
            }
         }

         if(this.field612 == 2) {
            this.field613 += this.field608.read(this.field611, this.field613, this.field611.length - this.field613);
            if(this.field613 == this.field611.length) {
               return this.field611;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "132730859"
   )
   public static SpritePixels method564(IndexDataBase var0, int var1, int var2) {
      if(!VertexNormal.method1667(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var3 = new SpritePixels();
         var3.maxWidth = class225.field3231;
         var3.maxHeight = class146.field2038;
         var3.offsetX = class225.field3230[0];
         var3.offsetY = ItemComposition.field3003[0];
         var3.width = class225.field3232[0];
         var3.height = ChatLineBuffer.field994[0];
         int var4 = var3.width * var3.height;
         byte[] var5 = BufferProvider.field3199[0];
         var3.image = new int[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            var3.image[var6] = class225.field3234[var5[var6] & 255];
         }

         WidgetNode.method172();
         return var3;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "-426702707"
   )
   static void method565(class18 var0) {
      CombatInfoListHolder.method719(var0, 200000);
   }

   class26(class103 var1, URL var2) {
      this.field607 = var1.method2006(var2);
      this.field612 = 0;
      this.field614 = class45.method867() + 30000L;
   }
}

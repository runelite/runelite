import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class77 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1162929643
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("x")
   public static String[] field1212;
   @ObfuscatedName("r")
   byte[] field1207;
   @ObfuscatedName("j")
   Task field1204;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1575353213
   )
   int field1210;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 7041020616169332995L
   )
   long field1208;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 590718041
   )
   int field1211;
   @ObfuscatedName("n")
   DataInputStream field1206;
   @ObfuscatedName("e")
   byte[] field1209;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1354789391
   )
   int field1205;

   class77(Signlink var1, URL var2) {
      this.field1207 = new byte[4];
      this.field1204 = var1.createURL(var2);
      this.field1210 = 0;
      this.field1208 = class46.currentTimeMs() + 30000L;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "124522945"
   )
   byte[] method1481() throws IOException {
      if(class46.currentTimeMs() > this.field1208) {
         throw new IOException();
      } else {
         if(this.field1210 == 0) {
            if(this.field1204.status == 2) {
               throw new IOException();
            }

            if(this.field1204.status == 1) {
               this.field1206 = (DataInputStream)this.field1204.value;
               this.field1210 = 1;
            }
         }

         if(this.field1210 == 1) {
            this.field1211 += this.field1206.read(this.field1207, this.field1211, this.field1207.length - this.field1211);
            if(this.field1211 == 4) {
               int var1 = (new Buffer(this.field1207)).readInt();
               this.field1209 = new byte[var1];
               this.field1210 = 2;
            }
         }

         if(this.field1210 == 2) {
            this.field1205 += this.field1206.read(this.field1209, this.field1205, this.field1209.length - this.field1205);
            if(this.field1209.length == this.field1205) {
               return this.field1209;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "2055211907"
   )
   static Widget method1480(Widget var0) {
      int var2 = class46.getWidgetConfig(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class61.method1038(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class26 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1177394069
   )
   int field587;
   @ObfuscatedName("f")
   class102 field588;
   @ObfuscatedName("k")
   DataInputStream field589;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -8622872111345299081L
   )
   long field590;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1632845109
   )
   int field591;
   @ObfuscatedName("n")
   byte[] field592;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1399336817
   )
   int field593;
   @ObfuscatedName("z")
   static class20 field596;
   @ObfuscatedName("i")
   byte[] field597 = new byte[4];

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "673177282"
   )
   static void method556(int var0, int var1) {
      Client.field294.method2976(52);
      Client.field294.method2748(var0);
      Client.field294.method2763(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "502558355"
   )
   byte[] method557() throws IOException {
      if(class72.method1385() > this.field590) {
         throw new IOException();
      } else {
         if(this.field587 == 0) {
            if(this.field588.field1650 == 2) {
               throw new IOException();
            }

            if(this.field588.field1650 == 1) {
               this.field589 = (DataInputStream)this.field588.field1652;
               this.field587 = 1;
            }
         }

         int var1;
         if(this.field587 == 1) {
            var1 = this.field589.available();
            if(var1 > 0) {
               if(this.field591 + var1 > 4) {
                  var1 = 4 - this.field591;
               }

               this.field591 += this.field589.read(this.field597, this.field591, var1);
               if(this.field591 == 4) {
                  int var2 = (new Buffer(this.field597)).method2844();
                  this.field592 = new byte[var2];
                  this.field587 = 2;
               }
            }
         }

         if(this.field587 == 2) {
            var1 = this.field589.available();
            if(var1 > 0) {
               if(this.field593 + var1 > this.field592.length) {
                  var1 = this.field592.length - this.field593;
               }

               this.field593 += this.field589.read(this.field592, this.field593, var1);
               if(this.field593 == this.field592.length) {
                  return this.field592;
               }
            }
         }

         return null;
      }
   }

   class26(class103 var1, URL var2) {
      this.field588 = var1.method1929(var2);
      this.field587 = 0;
      this.field590 = class72.method1385() + 30000L;
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "40736180"
   )
   static final void method560(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         Renderable.method1861(var2);
      }

      for(class133 var4 = (class133)Client.widgetFlags.method2313(); null != var4; var4 = (class133)Client.widgetFlags.method2321()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var5 = class191.method3433(var3);
      if(null != var5) {
         class94.method1890(var5);
      }

      class161.method3008();
      if(Client.widgetRoot != -1) {
         class32.method656(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "17"
   )
   public static Widget method561(int var0, int var1) {
      Widget var2 = class191.method3433(var0);
      return var1 == -1?var2:(null != var2 && null != var2.children && var1 < var2.children.length?var2.children[var1]:null);
   }
}

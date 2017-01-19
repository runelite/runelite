import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class26 {
   @ObfuscatedName("er")
   static SpritePixels[] field593;
   @ObfuscatedName("c")
   class102 field594;
   @ObfuscatedName("f")
   DataInputStream field595;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 6429870316216133935L
   )
   long field596;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1808511825
   )
   int field597;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1372933987
   )
   int field598;
   @ObfuscatedName("h")
   byte[] field599 = new byte[4];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1611047403
   )
   int field600;
   @ObfuscatedName("g")
   byte[] field601;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -419900645
   )
   static int field602;

   class26(class103 var1, URL var2) {
      this.field594 = var1.method1914(var2);
      this.field598 = 0;
      this.field596 = class2.method27() + 30000L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "23"
   )
   byte[] method569() throws IOException {
      if(class2.method27() > this.field596) {
         throw new IOException();
      } else {
         if(this.field598 == 0) {
            if(this.field594.field1663 == 2) {
               throw new IOException();
            }

            if(this.field594.field1663 == 1) {
               this.field595 = (DataInputStream)this.field594.field1666;
               this.field598 = 1;
            }
         }

         int var1;
         if(this.field598 == 1) {
            var1 = this.field595.available();
            if(var1 > 0) {
               if(this.field597 + var1 > 4) {
                  var1 = 4 - this.field597;
               }

               this.field597 += this.field595.read(this.field599, this.field597, var1);
               if(this.field597 == 4) {
                  int var2 = (new Buffer(this.field599)).method2727();
                  this.field601 = new byte[var2];
                  this.field598 = 2;
               }
            }
         }

         if(this.field598 == 2) {
            var1 = this.field595.available();
            if(var1 > 0) {
               if(var1 + this.field600 > this.field601.length) {
                  var1 = this.field601.length - this.field600;
               }

               this.field600 += this.field595.read(this.field601, this.field600, var1);
               if(this.field600 == this.field601.length) {
                  return this.field601;
               }
            }
         }

         return null;
      }
   }
}

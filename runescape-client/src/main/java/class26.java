import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class26 {
   @ObfuscatedName("bg")
   static class184 field588;
   @ObfuscatedName("l")
   class102 field589;
   @ObfuscatedName("i")
   byte[] field591 = new byte[4];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1798238023
   )
   int field592;
   @ObfuscatedName("h")
   byte[] field593;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -397873347
   )
   int field594;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 162692107
   )
   int field597;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 7367743154785633675L
   )
   long field598;
   @ObfuscatedName("t")
   DataInputStream field599;

   class26(class103 var1, URL var2) {
      this.field589 = var1.method2022(var2);
      this.field597 = 0;
      this.field598 = ChatMessages.method935() + 30000L;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2136833501"
   )
   byte[] method618() throws IOException {
      if(ChatMessages.method935() > this.field598) {
         throw new IOException();
      } else {
         if(this.field597 == 0) {
            if(this.field589.field1655 == 2) {
               throw new IOException();
            }

            if(this.field589.field1655 == 1) {
               this.field599 = (DataInputStream)this.field589.field1659;
               this.field597 = 1;
            }
         }

         int var1;
         if(this.field597 == 1) {
            var1 = this.field599.available();
            if(var1 > 0) {
               if(this.field592 + var1 > 4) {
                  var1 = 4 - this.field592;
               }

               this.field592 += this.field599.read(this.field591, this.field592, var1);
               if(this.field592 == 4) {
                  int var2 = (new Buffer(this.field591)).readInt();
                  this.field593 = new byte[var2];
                  this.field597 = 2;
               }
            }
         }

         if(this.field597 == 2) {
            var1 = this.field599.available();
            if(var1 > 0) {
               if(var1 + this.field594 > this.field593.length) {
                  var1 = this.field593.length - this.field594;
               }

               this.field594 += this.field599.read(this.field593, this.field594, var1);
               if(this.field594 == this.field593.length) {
                  return this.field593;
               }
            }
         }

         return null;
      }
   }
}

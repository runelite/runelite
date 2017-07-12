import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class77 {
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 1150999927
   )
   static int field1237;
   @ObfuscatedName("i")
   byte[] field1229;
   @ObfuscatedName("a")
   Task field1227;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -69539391
   )
   int field1231;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -8673129038472713675L
   )
   long field1230;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -885124681
   )
   int field1234;
   @ObfuscatedName("t")
   DataInputStream field1228;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1959565033
   )
   int field1233;
   @ObfuscatedName("r")
   byte[] field1232;

   class77(Signlink var1, URL var2) {
      this.field1229 = new byte[4];
      this.field1227 = var1.createURL(var2);
      this.field1231 = 0;
      this.field1230 = DState.currentTimeMs() + 30000L;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "9"
   )
   byte[] method1530() throws IOException {
      if(DState.currentTimeMs() > this.field1230) {
         throw new IOException();
      } else {
         if(this.field1231 == 0) {
            if(this.field1227.status == 2) {
               throw new IOException();
            }

            if(this.field1227.status == 1) {
               this.field1228 = (DataInputStream)this.field1227.value;
               this.field1231 = 1;
            }
         }

         if(this.field1231 == 1) {
            this.field1234 += this.field1228.read(this.field1229, this.field1234, this.field1229.length - this.field1234);
            if(this.field1234 == 4) {
               int var1 = (new Buffer(this.field1229)).readInt();
               this.field1232 = new byte[var1];
               this.field1231 = 2;
            }
         }

         if(this.field1231 == 2) {
            this.field1233 += this.field1228.read(this.field1232, this.field1233, this.field1232.length - this.field1233);
            if(this.field1232.length == this.field1233) {
               return this.field1232;
            }
         }

         return null;
      }
   }
}

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class18 {
   @ObfuscatedName("g")
   class146 field256;
   @ObfuscatedName("j")
   DataInputStream field258;
   @ObfuscatedName("d")
   byte[] field259 = new byte[4];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 282322849
   )
   int field260;
   @ObfuscatedName("y")
   byte[] field261;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1255820041
   )
   int field262;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -6247167416227656319L
   )
   long field263;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -380645977
   )
   static int field264;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1286482083
   )
   int field271;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "53"
   )
   static char method182(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1098108297"
   )
   byte[] method183() throws IOException {
      if(class90.method2090() > this.field263) {
         throw new IOException();
      } else {
         if(this.field262 == 0) {
            if(this.field256.field2199 == 2) {
               throw new IOException();
            }

            if(this.field256.field2199 == 1) {
               this.field258 = (DataInputStream)this.field256.field2201;
               this.field262 = 1;
            }
         }

         int var1;
         if(this.field262 == 1) {
            var1 = this.field258.available();
            if(var1 > 0) {
               if(var1 + this.field260 > 4) {
                  var1 = 4 - this.field260;
               }

               this.field260 += this.field258.read(this.field259, this.field260, var1);
               if(this.field260 == 4) {
                  int var2 = (new class119(this.field259)).method2519();
                  this.field261 = new byte[var2];
                  this.field262 = 2;
               }
            }
         }

         if(this.field262 == 2) {
            var1 = this.field258.available();
            if(var1 > 0) {
               if(this.field271 + var1 > this.field261.length) {
                  var1 = this.field261.length - this.field271;
               }

               this.field271 += this.field258.read(this.field261, this.field271, var1);
               if(this.field261.length == this.field271) {
                  return this.field261;
               }
            }
         }

         return null;
      }
   }

   class18(class136 var1, URL var2) {
      this.field256 = var1.method2925(var2);
      this.field262 = 0;
      this.field263 = class90.method2090() + 30000L;
   }
}

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class18 {
   @ObfuscatedName("e")
   class149 field252;
   @ObfuscatedName("t")
   byte[] field253 = new byte[4];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -5466605645536239435L
   )
   long field254;
   @ObfuscatedName("b")
   byte[] field256;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 868079591
   )
   int field257;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1306279945
   )
   int field258;
   @ObfuscatedName("an")
   static SpritePixels[] field259;
   @ObfuscatedName("n")
   DataInputStream field261;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 584523841
   )
   int field262;
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = 559825379
   )
   static int field264;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-716681488"
   )
   byte[] method190() throws IOException {
      if(class11.method139() > this.field254) {
         throw new IOException();
      } else {
         if(this.field262 == 0) {
            if(this.field252.field2262 == 2) {
               throw new IOException();
            }

            if(this.field252.field2262 == 1) {
               this.field261 = (DataInputStream)this.field252.field2266;
               this.field262 = 1;
            }
         }

         int var1;
         if(this.field262 == 1) {
            var1 = this.field261.available();
            if(var1 > 0) {
               if(this.field258 + var1 > 4) {
                  var1 = 4 - this.field258;
               }

               this.field258 += this.field261.read(this.field253, this.field258, var1);
               if(this.field258 == 4) {
                  int var2 = (new Buffer(this.field253)).method2538();
                  this.field256 = new byte[var2];
                  this.field262 = 2;
               }
            }
         }

         if(this.field262 == 2) {
            var1 = this.field261.available();
            if(var1 > 0) {
               if(var1 + this.field257 > this.field256.length) {
                  var1 = this.field256.length - this.field257;
               }

               this.field257 += this.field261.read(this.field256, this.field257, var1);
               if(this.field256.length == this.field257) {
                  return this.field256;
               }
            }
         }

         return null;
      }
   }

   class18(class139 var1, URL var2) {
      this.field252 = var1.method2920(var2);
      this.field262 = 0;
      this.field254 = class11.method139() + 30000L;
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "131954400"
   )
   static final void method192() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[1 + var1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
               Client.menuIdentifiers[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1292767380"
   )
   static void method193() {
      FileOnDisk var0 = null;

      try {
         var0 = Actor.method786("", class164.field2676.field2332, true);
         Buffer var1 = class16.field232.method98();
         var0.method4190(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4191();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "-1345614149"
   )
   static final void method194(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      if(null != var4) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class94.field1635[var6];
            int var9 = class94.field1646[var6];
            var8 = 256 * var8 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (256 + Client.mapScaleDelta);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1772(var10 + var5.field2930 / 2 - var4.field1462 / 2, var5.field2931 / 2 - var11 - var4.field1457 / 2, var0, var1, var5.field2930, var5.field2931, var5.field2933, var5.field2932);
            } else {
               var4.method1763(var10 + var0 + var5.field2930 / 2 - var4.field1462 / 2, var5.field2931 / 2 + var1 - var11 - var4.field1457 / 2);
            }

         }
      }
   }
}

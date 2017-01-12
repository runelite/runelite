import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class26 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1682536127
   )
   int field586;
   @ObfuscatedName("x")
   class102 field587;
   @ObfuscatedName("a")
   DataInputStream field588;
   @ObfuscatedName("i")
   byte[] field589 = new byte[4];
   @ObfuscatedName("c")
   byte[] field591;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -386308319
   )
   int field592;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -1424136894652848073L
   )
   long field593;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 629761831
   )
   int field596;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "61"
   )
   byte[] method595() throws IOException {
      if(class9.method117() > this.field593) {
         throw new IOException();
      } else {
         if(this.field596 == 0) {
            if(this.field587.field1648 == 2) {
               throw new IOException();
            }

            if(this.field587.field1648 == 1) {
               this.field588 = (DataInputStream)this.field587.field1652;
               this.field596 = 1;
            }
         }

         int var1;
         if(this.field596 == 1) {
            var1 = this.field588.available();
            if(var1 > 0) {
               if(var1 + this.field592 > 4) {
                  var1 = 4 - this.field592;
               }

               this.field592 += this.field588.read(this.field589, this.field592, var1);
               if(this.field592 == 4) {
                  int var2 = (new Buffer(this.field589)).method2780();
                  this.field591 = new byte[var2];
                  this.field596 = 2;
               }
            }
         }

         if(this.field596 == 2) {
            var1 = this.field588.available();
            if(var1 > 0) {
               if(var1 + this.field586 > this.field591.length) {
                  var1 = this.field591.length - this.field586;
               }

               this.field586 += this.field588.read(this.field591, this.field586, var1);
               if(this.field591.length == this.field586) {
                  return this.field591;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1933615163"
   )
   static final void method596(int var0, int var1) {
      if(Client.field298 == 2) {
         class16.method179(Client.field304 + (Client.field530 - FrameMap.baseX << 7), Client.field323 + (Client.field426 - XItemContainer.baseY << 7), Client.field534 * 2);
         if(Client.field388 > -1 && Client.gameCycle % 20 < 10) {
            Player.field253[0].method4122(var0 + Client.field388 - 12, Client.field491 + var1 - 28);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "452074030"
   )
   static int method598(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method628()?(var1.method628()?0:1):(var1.method628()?-1:0)):(var2 == 5?(var0.method637()?(var1.method637()?0:1):(var1.method637()?-1:0)):(var2 == 6?(var0.method625()?(var1.method625()?0:1):(var1.method625()?-1:0)):(var2 == 7?(var0.method636()?(var1.method636()?0:1):(var1.method636()?-1:0)):var0.id - var1.id)))));
      }
   }

   class26(class103 var1, URL var2) {
      this.field587 = var1.method1918(var2);
      this.field596 = 0;
      this.field593 = class9.method117() + 30000L;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "15"
   )
   static final void method599(int var0, int var1, int var2, int var3) {
      if(Client.field393 == 1) {
         class145.field2001[Client.field392 / 100].method4122(Client.field390 - 8, Client.field391 - 8);
      }

      if(Client.field393 == 2) {
         class145.field2001[Client.field392 / 100 + 4].method4122(Client.field390 - 8, Client.field391 - 8);
      }

      class137.method2459();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-98"
   )
   static void method600() {
      int var0 = class0.field1;
      int var1 = class65.field1099;
      if(ItemLayer.field1211 < var0) {
         var0 = ItemLayer.field1211;
      }

      if(class11.field115 < var1) {
         var1 = class11.field115;
      }

      if(class2.field21 != null) {
         try {
            class100.method1902(Client.field279, "resize", new Object[]{Integer.valueOf(class182.method3335())});
         } catch (Throwable var3) {
            ;
         }
      }

   }
}

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class26 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 7110277056247853801L
   )
   long field589;
   @ObfuscatedName("n")
   class102 field590;
   @ObfuscatedName("g")
   DataInputStream field591;
   @ObfuscatedName("v")
   byte[] field592 = new byte[4];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -116892911
   )
   int field593;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1650220233
   )
   int field594;
   @ObfuscatedName("mz")
   static SpritePixels field595;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 372268777
   )
   static int field596;
   @ObfuscatedName("p")
   byte[] field599;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2066533001
   )
   int field600;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "944562491"
   )
   static final void method616(int var0, int var1, int var2, int var3) {
      if(Client.field399 == 1) {
         class7.field57[Client.field426 / 100].method4174(Client.field489 - 8, Client.field490 - 8);
      }

      if(Client.field399 == 2) {
         class7.field57[Client.field426 / 100 + 4].method4174(Client.field489 - 8, Client.field490 - 8);
      }

      Client.field408 = 0;
      int var4 = Player.baseX + (WidgetNode.localPlayer.x >> 7);
      int var5 = SecondaryBufferProvider.baseY + (WidgetNode.localPlayer.y >> 7);
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field408 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field408 = 1;
      }

      if(Client.field408 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field408 = 0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1652355201"
   )
   byte[] method617() throws IOException {
      if(WallObject.method1985() > this.field589) {
         throw new IOException();
      } else {
         if(this.field600 == 0) {
            if(this.field590.field1670 == 2) {
               throw new IOException();
            }

            if(this.field590.field1670 == 1) {
               this.field591 = (DataInputStream)this.field590.field1674;
               this.field600 = 1;
            }
         }

         int var1;
         if(this.field600 == 1) {
            var1 = this.field591.available();
            if(var1 > 0) {
               if(var1 + this.field593 > 4) {
                  var1 = 4 - this.field593;
               }

               this.field593 += this.field591.read(this.field592, this.field593, var1);
               if(this.field593 == 4) {
                  int var2 = (new Buffer(this.field592)).readInt();
                  this.field599 = new byte[var2];
                  this.field600 = 2;
               }
            }
         }

         if(this.field600 == 2) {
            var1 = this.field591.available();
            if(var1 > 0) {
               if(var1 + this.field594 > this.field599.length) {
                  var1 = this.field599.length - this.field594;
               }

               this.field594 += this.field591.read(this.field599, this.field594, var1);
               if(this.field599.length == this.field594) {
                  return this.field599;
               }
            }
         }

         return null;
      }
   }

   class26(class103 var1, URL var2) {
      this.field590 = var1.method2051(var2);
      this.field600 = 0;
      this.field589 = WallObject.method1985() + 30000L;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "1426051353"
   )
   static void method619(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field702 = var0;
      var5.field704 = var1 * 128;
      var5.field716 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field705 = (var6 + var1) * 128;
      var5.field706 = (var2 + var7) * 128;
      var5.field708 = var3.ambientSoundId;
      var5.field712 = var3.field2910 * 128;
      var5.field710 = var3.field2907;
      var5.field711 = var3.field2916;
      var5.field714 = var3.field2946;
      if(var3.impostorIds != null) {
         var5.field715 = var3;
         var5.method707();
      }

      class31.field703.method2511(var5);
      if(null != var5.field714) {
         var5.field713 = var5.field710 + (int)(Math.random() * (double)(var5.field711 - var5.field710));
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-745084683"
   )
   static int method620(World var0, World var1, int var2, boolean var3) {
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
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method681()?(var1.method681()?0:1):(var1.method681()?-1:0)):(var2 == 5?(var0.method649()?(var1.method649()?0:1):(var1.method649()?-1:0)):(var2 == 6?(var0.method650()?(var1.method650()?0:1):(var1.method650()?-1:0)):(var2 == 7?(var0.method658()?(var1.method658()?0:1):(var1.method658()?-1:0)):var0.id - var1.id)))));
      }
   }
}

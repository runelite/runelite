import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class26 {
   @ObfuscatedName("d")
   class102 field609;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 471845455
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("h")
   DataInputStream field611;
   @ObfuscatedName("p")
   byte[] field612 = new byte[4];
   @ObfuscatedName("n")
   byte[] field614;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1127216351
   )
   int field615;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 2627262492402859149L
   )
   long field616;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1980772367
   )
   int field617;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1062387591
   )
   int field618;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 2060549577
   )
   protected static int field619;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2016545344"
   )
   public static void method607() {
      ObjectComposition.field2895.reset();
      ObjectComposition.field2896.reset();
      ObjectComposition.field2897.reset();
      ObjectComposition.field2935.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1533182511"
   )
   byte[] method610() throws IOException {
      if(class0.method11() > this.field616) {
         throw new IOException();
      } else {
         if(this.field618 == 0) {
            if(this.field609.field1671 == 2) {
               throw new IOException();
            }

            if(this.field609.field1671 == 1) {
               this.field611 = (DataInputStream)this.field609.field1672;
               this.field618 = 1;
            }
         }

         int var1;
         if(this.field618 == 1) {
            var1 = this.field611.available();
            if(var1 > 0) {
               if(this.field617 + var1 > 4) {
                  var1 = 4 - this.field617;
               }

               this.field617 += this.field611.read(this.field612, this.field617, var1);
               if(this.field617 == 4) {
                  int var2 = (new Buffer(this.field612)).method2965();
                  this.field614 = new byte[var2];
                  this.field618 = 2;
               }
            }
         }

         if(this.field618 == 2) {
            var1 = this.field611.available();
            if(var1 > 0) {
               if(var1 + this.field615 > this.field614.length) {
                  var1 = this.field614.length - this.field615;
               }

               this.field615 += this.field611.read(this.field614, this.field615, var1);
               if(this.field615 == this.field614.length) {
                  return this.field614;
               }
            }
         }

         return null;
      }
   }

   class26(class103 var1, URL var2) {
      this.field609 = var1.method2035(var2);
      this.field618 = 0;
      this.field616 = class0.method11() + 30000L;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1349326933"
   )
   static void method611() {
      int var0 = GameEngine.field1777;
      int var1 = GameEngine.field1784;
      int var2 = class49.field976 - class32.field758 - var0;
      int var3 = field619 - class47.field950 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field508.method2177();
            int var5 = 0;
            int var6 = 0;
            if(class3.field39 == var4) {
               Insets var7 = class3.field39.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, field619);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class49.field976, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class49.field976 + var5 - var2, var6, var2, field619);
            }

            if(var3 > 0) {
               var9.fillRect(var5, field619 + var6 - var3, class49.field976, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-58"
   )
   static final void method612() {
      Client.field424 = 0;
      int var0 = class5.baseX + (class36.localPlayer.x >> 7);
      int var1 = (class36.localPlayer.y >> 7) + XClanMember.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field424 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field424 = 1;
      }

      if(Client.field424 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field424 = 0;
      }

   }
}

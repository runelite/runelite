import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class26 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -5432475446648348301L
   )
   long field586;
   @ObfuscatedName("d")
   class102 field587;
   @ObfuscatedName("m")
   DataInputStream field588;
   @ObfuscatedName("h")
   byte[] field589 = new byte[4];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2071813627
   )
   int field590;
   @ObfuscatedName("a")
   public static String field591;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2138575293
   )
   int field592;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1153064235
   )
   int field593;
   @ObfuscatedName("r")
   byte[] field594;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-2072144288"
   )
   byte[] method608() throws IOException {
      if(class202.method3838() > this.field586) {
         throw new IOException();
      } else {
         if(this.field592 == 0) {
            if(this.field587.field1661 == 2) {
               throw new IOException();
            }

            if(this.field587.field1661 == 1) {
               this.field588 = (DataInputStream)this.field587.field1663;
               this.field592 = 1;
            }
         }

         int var1;
         if(this.field592 == 1) {
            var1 = this.field588.available();
            if(var1 > 0) {
               if(this.field590 + var1 > 4) {
                  var1 = 4 - this.field590;
               }

               this.field590 += this.field588.read(this.field589, this.field590, var1);
               if(this.field590 == 4) {
                  int var2 = (new Buffer(this.field589)).method2995();
                  this.field594 = new byte[var2];
                  this.field592 = 2;
               }
            }
         }

         if(this.field592 == 2) {
            var1 = this.field588.available();
            if(var1 > 0) {
               if(var1 + this.field593 > this.field594.length) {
                  var1 = this.field594.length - this.field593;
               }

               this.field593 += this.field588.read(this.field594, this.field593, var1);
               if(this.field594.length == this.field593) {
                  return this.field594;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-604970717"
   )
   static final int method609() {
      if(Tile.field1343.field691) {
         return class166.plane;
      } else {
         int var0 = class11.method161(XGrandExchangeOffer.cameraX, Client.cameraY, class166.plane);
         return var0 - Client.cameraZ < 800 && (class11.tileSettings[class166.plane][XGrandExchangeOffer.cameraX >> 7][Client.cameraY >> 7] & 4) != 0?class166.plane:3;
      }
   }

   class26(class103 var1, URL var2) {
      this.field587 = var1.method1997(var2);
      this.field592 = 0;
      this.field586 = class202.method3838() + 30000L;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "2122630368"
   )
   static void method613(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = NPC.method749(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = NPC.method749(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method613(var0, var7 - 1, var2, var3, var4, var5);
         method613(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-3"
   )
   public static void method615(int var0) {
      class115.mouseIdleTicks = var0;
   }
}

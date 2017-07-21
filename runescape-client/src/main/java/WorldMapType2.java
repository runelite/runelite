import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1182558435
   )
   public static int field513;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field521;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field522;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   public static Font field523;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1164467573
   )
   int field519;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1849678207
   )
   int field520;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1437668979
   )
   int field518;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 635502441
   )
   int field514;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1882743701
   )
   int field515;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1616533961
   )
   int field516;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-1713"
   )
   public boolean vmethod676(int var1, int var2) {
      return var1 >> 6 == this.field519 && var2 >> 6 == this.field518;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-762941504"
   )
   public boolean vmethod675(int var1, int var2, int var3) {
      return var1 >= this.field520 && var1 < this.field520 + this.field514?var2 >> 6 == this.field515 && var3 >> 6 == this.field516:false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lab;S)V",
      garbageValue = "-29128"
   )
   public void vmethod693(WorldMapData var1) {
      if(var1.field443 > this.field519) {
         var1.field443 = this.field519;
      }

      if(var1.field444 < this.field519) {
         var1.field444 = this.field519;
      }

      if(var1.field442 > this.field518) {
         var1.field442 = this.field518;
      }

      if(var1.field435 < this.field518) {
         var1.field435 = this.field518;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "861336956"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod676(var1, var2)) {
         return null;
      } else {
         int var3 = this.field515 * 64 - this.field519 * 64 + var1;
         int var4 = this.field516 * 64 - this.field518 * 64 + var2;
         return new Coordinates(this.field520, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1119600547"
   )
   public int[] vmethod677(int var1, int var2, int var3) {
      if(!this.vmethod675(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field519 * 64 - this.field515 * 64 + var2, var3 + (this.field518 * 64 - this.field516 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1571259630"
   )
   void method513() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-58"
   )
   public void vmethod678(Buffer var1) {
      this.field520 = var1.readUnsignedByte();
      this.field514 = var1.readUnsignedByte();
      this.field515 = var1.readUnsignedShort();
      this.field516 = var1.readUnsignedShort();
      this.field519 = var1.readUnsignedShort();
      this.field518 = var1.readUnsignedShort();
      this.method513();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1763375321"
   )
   public static void method495(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-1498745043"
   )
   public static boolean method509(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label84: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label84;
               }

               if(var7 == 43) {
                  break label84;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * 10;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "1119962018"
   )
   static final void method517(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(90);
      Client.secretPacketBuffer1.putByte(class15.getLength(var0) + 1);
      Client.secretPacketBuffer1.putString(var0);
      Client.secretPacketBuffer1.method3120(var1);
   }
}

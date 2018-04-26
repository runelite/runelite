import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("MapIcon")
public class MapIcon {
   @ObfuscatedName("bb")
   static String field531;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("fk")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 625796147
   )
   @Export("areaId")
   public final int areaId;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   public final Coordinates field522;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   public final Coordinates field528;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1406147063
   )
   final int field524;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1334609219
   )
   final int field521;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lao;"
   )
   final MapLabel field526;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1605812407
   )
   @Export("screenX")
   int screenX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 968035903
   )
   @Export("screenY")
   int screenY;

   @ObfuscatedSignature(
      signature = "(ILio;Lio;Lao;)V"
   )
   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field528 = var2;
      this.field522 = var3;
      this.field526 = var4;
      Area var5 = class190.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field524 = var6.width;
         this.field521 = var6.height;
      } else {
         this.field524 = 0;
         this.field521 = 0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "903572246"
   )
   boolean method583(int var1, int var2) {
      return this.method584(var1, var2)?true:this.method585(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-8"
   )
   boolean method584(int var1, int var2) {
      Area var3 = class190.mapAreaType[this.areaId];
      switch(var3.horizontalAlignment.value) {
      case 0:
         if(var1 <= this.screenX - this.field524 || var1 > this.screenX) {
            return false;
         }
         break;
      case 1:
         if(var1 < this.screenX - this.field524 / 2 || var1 > this.field524 / 2 + this.screenX) {
            return false;
         }
         break;
      case 2:
         if(var1 < this.screenX || var1 >= this.field524 + this.screenX) {
            return false;
         }
      }

      switch(var3.verticalAlignment.value) {
      case 0:
         if(var2 >= this.screenY && var2 < this.field521 + this.screenY) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.screenY - this.field521 || var2 > this.screenY) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.screenY - this.field521 / 2 || var2 > this.field521 / 2 + this.screenY) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2033685043"
   )
   boolean method585(int var1, int var2) {
      return this.field526 == null?false:(var1 >= this.screenX - this.field526.field460 / 2 && var1 <= this.field526.field460 / 2 + this.screenX?var2 >= this.screenY && var2 <= this.field526.field462 + this.screenY:false);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-1655105158"
   )
   static final void method597(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(BB)C",
      garbageValue = "-93"
   )
   public static char method598(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class314.cp1252AsciiExtension[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(IIIILlv;Lin;B)V",
      garbageValue = "-48"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2780 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class230.mapedge.method5967(var15 + (var0 + var5.field2780 / 2 - var17 / 2), var5.field2782 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         ClanMemberManager.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "-97"
   )
   public static void method596(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = AbstractSoundSystem.method2350(ClientPacket.field2366, Client.field911.field1460);
      var4.packetBuffer.putShort(var0);
      var4.packetBuffer.putShort(var1);
      var4.packetBuffer.method3624(var2);
      var4.packetBuffer.putInt(var3?Client.field933:0);
      Client.field911.method2135(var4);
   }
}

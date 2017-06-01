import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class39 {
   @ObfuscatedName("c")
   public final Coordinates field525;
   @ObfuscatedName("e")
   public final Coordinates field526;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 597031569
   )
   final int field527;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 428439963
   )
   final int field528;
   @ObfuscatedName("y")
   final class33 field529;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -817716847
   )
   int field530;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1047073313
   )
   int field531;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -900822885
   )
   public final int field536;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "234532059"
   )
   boolean method521(int var1, int var2) {
      Area var3 = class223.field2839[this.field536];
      switch(var3.field3299.field3541) {
      case 0:
         if(var1 >= this.field530 - this.field527 / 2 && var1 <= this.field530 + this.field527 / 2) {
            break;
         }

         return false;
      case 1:
         if(var1 > this.field530 - this.field527 && var1 <= this.field530) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field530 || var1 >= this.field530 + this.field527) {
            return false;
         }
      }

      switch(var3.field3306.field3274) {
      case 0:
         if(var2 > this.field531 - this.field528 && var2 <= this.field531) {
            break;
         }

         return false;
      case 1:
         if(var2 >= this.field531 && var2 < this.field531 + this.field528) {
            break;
         }

         return false;
      case 2:
         if(var2 < this.field531 - this.field528 / 2 || var2 > this.field531 + this.field528 / 2) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1423860356"
   )
   boolean method522(int var1, int var2) {
      return this.method521(var1, var2)?true:this.method523(var1, var2);
   }

   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field536 = var1;
      this.field526 = var2;
      this.field525 = var3;
      this.field529 = var4;
      Area var5 = class223.field2839[this.field536];
      SpritePixels var6 = var5.method4313(false);
      if(var6 != null) {
         this.field527 = var6.width;
         this.field528 = var6.height;
      } else {
         this.field527 = 0;
         this.field528 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1975578765"
   )
   boolean method523(int var1, int var2) {
      return this.field529 == null?false:(var1 >= this.field530 - this.field529.field469 / 2 && var1 <= this.field530 + this.field529.field469 / 2?var2 >= this.field531 && var2 <= this.field531 + this.field529.field468:false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass251;",
      garbageValue = "-45488289"
   )
   public static class251 method528(int var0) {
      class251 var1 = (class251)class251.field3384.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3383.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4437(new Buffer(var2));
         }

         var1.method4436();
         class251.field3384.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "1499760332"
   )
   public static void method531(Applet var0, String var1) {
      class56.field694 = var0;
      class56.field690 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "-1079440964"
   )
   static final void method532(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class96.field1514 = 0;
      class71.method1096(var0);

      for(int var3 = 0; var3 < class96.field1514; ++var3) {
         int var4 = class96.field1517[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 8) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         class56.method805(var0, var4, var5, var6);
      }

      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}

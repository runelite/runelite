import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class39 {
   @ObfuscatedName("p")
   public final Coordinates field527;
   @ObfuscatedName("i")
   public final Coordinates field529;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 776304463
   )
   final int field530;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 292657709
   )
   int field531;
   @ObfuscatedName("m")
   final class33 field532;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1562409383
   )
   int field533;
   @ObfuscatedName("cn")
   public static char field535;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1693354327
   )
   final int field537;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1333333283
   )
   public final int field538;

   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field538 = var1;
      this.field529 = var2;
      this.field527 = var3;
      this.field532 = var4;
      Area var5 = World.field1300[this.field538];
      SpritePixels var6 = var5.method4325(false);
      if(var6 != null) {
         this.field530 = var6.width;
         this.field537 = var6.height;
      } else {
         this.field530 = 0;
         this.field537 = 0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-42"
   )
   boolean method530(int var1, int var2) {
      Area var3 = World.field1300[this.field538];
      switch(var3.field3309.field3554) {
      case 0:
         if(var1 < this.field533 || var1 >= this.field530 + this.field533) {
            return false;
         }
         break;
      case 1:
         if(var1 >= this.field533 - this.field530 / 2 && var1 <= this.field533 + this.field530 / 2) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field533 - this.field530 || var1 > this.field533) {
            return false;
         }
      }

      switch(var3.field3310.field3273) {
      case 0:
         if(var2 >= this.field531 && var2 < this.field537 + this.field531) {
            break;
         }

         return false;
      case 1:
         if(var2 >= this.field531 - this.field537 / 2 && var2 <= this.field537 / 2 + this.field531) {
            break;
         }

         return false;
      case 2:
         if(var2 <= this.field531 - this.field537 || var2 > this.field531) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1984636900"
   )
   boolean method531(int var1, int var2) {
      return this.field532 == null?false:(var1 >= this.field533 - this.field532.field472 / 2 && var1 <= this.field532.field472 / 2 + this.field533?var2 >= this.field531 && var2 <= this.field532.field473 + this.field531:false);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1904540805"
   )
   boolean method540(int var1, int var2) {
      return this.method530(var1, var2)?true:this.method531(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "1035242778"
   )
   static final int method541(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class136.COSINE[var2 * 1024 / var3] >> 1;
      return (var1 * var4 >> 16) + ((65536 - var4) * var0 >> 16);
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "650652029"
   )
   static String method542(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field915 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field915 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field915 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field915 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field915 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class47.field598 != null) {
         var3 = "/p=" + class47.field598;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field919 + "/a=" + class204.field2548 + var3 + "/";
   }
}

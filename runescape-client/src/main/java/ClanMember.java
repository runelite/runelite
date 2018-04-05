import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer {
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field3827;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field3826;

   ClanMember() {
      this.field3827 = class303.field3851;
      this.field3826 = class303.field3851;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-15"
   )
   void method5247() {
      this.field3827 = class303.field3851;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-573194880"
   )
   public final boolean method5242() {
      if(this.field3827 == class303.field3851) {
         this.method5243();
      }

      return this.field3827 == class303.field3850;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   void method5243() {
      this.field3827 = WorldMapRectangle.friendManager.field1256.isMember(super.name)?class303.field3850:class303.field3849;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   void method5258() {
      this.field3826 = class303.field3851;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-994657241"
   )
   public final boolean method5260() {
      if(this.field3826 == class303.field3851) {
         this.method5246();
      }

      return this.field3826 == class303.field3850;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method5246() {
      this.field3826 = WorldMapRectangle.friendManager.field1254.isMember(super.name)?class303.field3850:class303.field3849;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1257437097"
   )
   static int method5252(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "79"
   )
   static char method5259(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }
}

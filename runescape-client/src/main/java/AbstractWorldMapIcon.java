import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -1942470229
   )
   static int field4;
   @ObfuscatedName("ka")
   @ObfuscatedGetter(
      intValue = -1734004743
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("coord2")
   public final Coord coord2;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("coord1")
   public final Coord coord1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -521086143
   )
   @Export("screenX")
   int screenX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1065362217
   )
   @Export("screenY")
   int screenY;

   @ObfuscatedSignature(
      signature = "(Lhu;Lhu;)V"
   )
   AbstractWorldMapIcon(Coord var1, Coord var2) {
      this.coord1 = var1;
      this.coord2 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1990181988"
   )
   @Export("getElement")
   public abstract int getElement();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "1159446036"
   )
   @Export("getLabel")
   abstract WorldMapLabel getLabel();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   abstract int vmethod397();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1558233611"
   )
   abstract int vmethod398();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-63"
   )
   boolean method18(int var1, int var2) {
      return this.method20(var1, var2) ? true : this.method21(var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1150380891"
   )
   boolean method19() {
      return this.getElement() >= 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "484201257"
   )
   boolean method20(int var1, int var2) {
      if (!this.method19()) {
         return false;
      } else {
         WorldMapElement var3 = ViewportMouse.getWorldMapElement(this.getElement());
         int var4 = this.vmethod397();
         int var5 = this.vmethod398();
         switch(var3.horizontalAlignment.value) {
         case 0:
            if (var1 >= this.screenX - var4 / 2 && var1 <= var4 / 2 + this.screenX) {
               break;
            }

            return false;
         case 1:
            if (var1 >= this.screenX && var1 < var4 + this.screenX) {
               break;
            }

            return false;
         case 2:
            if (var1 <= this.screenX - var4 || var1 > this.screenX) {
               return false;
            }
         }

         switch(var3.verticalAlignment.value) {
         case 0:
            if (var2 <= this.screenY - var5 || var2 > this.screenY) {
               return false;
            }
            break;
         case 1:
            if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
               return false;
            }
            break;
         case 2:
            if (var2 < this.screenY || var2 >= var5 + this.screenY) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1201712205"
   )
   boolean method21(int var1, int var2) {
      WorldMapLabel var3 = this.getLabel();
      return var3 == null ? false : (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX ? var2 >= this.screenY && var2 <= var3.height + this.screenY : false);
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;I)V",
      garbageValue = "-1018878027"
   )
   static void method625(Archive var0, String var1) {
      ArchiveLoader var2 = new ArchiveLoader(var0, var1);
      Client.archiveLoaders.add(var2);
      Client.field140 += var2.groupCount;
   }
}
